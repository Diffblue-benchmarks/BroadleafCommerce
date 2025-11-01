/*-
 * #%L
 * BroadleafCommerce Admin Module
 * %%
 * Copyright (C) 2009 - 2025 Broadleaf Commerce
 * %%
 * Licensed under the Broadleaf Fair Use License Agreement, Version 1.0
 * (the "Fair Use License" located  at http://license.broadleafcommerce.org/fair_use_license-1.0.txt)
 * unless the restrictions on use therein are violated and require payment to Broadleaf in which case
 * the Broadleaf End User License Agreement (EULA), Version 1.1
 * (the "Commercial License" located at http://license.broadleafcommerce.org/commercial_license-1.1.txt)
 * shall apply.
 * 
 * Alternatively, the Commercial License may be replaced with a mutually agreed upon license (the "Custom License")
 * between you and Broadleaf Commerce. You may not use this file except in compliance with the applicable license.
 * #L%
 */
package org.broadleafcommerce.admin.server.service.handler;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import org.broadleafcommerce.common.exception.ServiceException;
import org.broadleafcommerce.common.presentation.client.OperationType;
import org.broadleafcommerce.common.presentation.client.SupportedFieldType;
import org.broadleafcommerce.core.catalog.domain.Product;
import org.broadleafcommerce.core.catalog.domain.ProductBundleImpl;
import org.broadleafcommerce.core.catalog.domain.ProductOption;
import org.broadleafcommerce.core.catalog.domain.ProductOptionImpl;
import org.broadleafcommerce.core.catalog.domain.ProductOptionValue;
import org.broadleafcommerce.core.catalog.domain.ProductOptionValueImpl;
import org.broadleafcommerce.core.catalog.domain.Sku;
import org.broadleafcommerce.core.catalog.domain.SkuImpl;
import org.broadleafcommerce.openadmin.dto.AdornedTargetCollectionMetadata;
import org.broadleafcommerce.openadmin.dto.BasicFieldMetadata;
import org.broadleafcommerce.openadmin.dto.CriteriaTransferObject;
import org.broadleafcommerce.openadmin.dto.DynamicResultSet;
import org.broadleafcommerce.openadmin.dto.Entity;
import org.broadleafcommerce.openadmin.dto.FieldMetadata;
import org.broadleafcommerce.openadmin.dto.FilterAndSortCriteria;
import org.broadleafcommerce.openadmin.dto.OperationTypes;
import org.broadleafcommerce.openadmin.dto.PersistencePackage;
import org.broadleafcommerce.openadmin.dto.PersistencePerspective;
import org.broadleafcommerce.openadmin.dto.Property;
import org.broadleafcommerce.openadmin.dto.SectionCrumb;
import org.broadleafcommerce.openadmin.server.dao.DynamicEntityDao;
import org.broadleafcommerce.openadmin.server.dao.DynamicEntityDaoImpl;
import org.broadleafcommerce.openadmin.server.service.persistence.module.RecordHelper;
import org.broadleafcommerce.openadmin.server.service.persistence.module.criteria.FieldPath;
import org.broadleafcommerce.openadmin.server.service.persistence.module.criteria.FieldPathBuilder;
import org.broadleafcommerce.openadmin.server.service.persistence.module.criteria.FilterMapping;
import org.broadleafcommerce.openadmin.server.service.persistence.module.criteria.Restriction;
import org.junit.Test;
import org.mockito.Mockito;

public class SkuCustomPersistenceHandlerDiffblueTest {
  /**
   * Method under test:
   * {@link SkuCustomPersistenceHandler#canHandleInspect(PersistencePackage)}
   */
  @Test
  public void testCanHandleInspect() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuCustomPersistenceHandler skuCustomPersistenceHandler = new SkuCustomPersistenceHandler();
    PersistencePerspective persistencePerspective = mock(PersistencePerspective.class);
    when(persistencePerspective.getOperationTypes()).thenReturn(new OperationTypes());
    Entity entity = new Entity();

    PersistencePackage persistencePackage = new PersistencePackage("Dr Jane Doe", entity, new PersistencePerspective(),
        new String[]{"Custom Criteria"}, "ABC123");
    persistencePackage.setPersistencePerspective(persistencePerspective);

    // Act
    Boolean actualCanHandleInspectResult = skuCustomPersistenceHandler.canHandleInspect(persistencePackage);

    // Assert
    verify(persistencePerspective).getOperationTypes();
    assertFalse(actualCanHandleInspectResult);
  }

  /**
   * Method under test:
   * {@link SkuCustomPersistenceHandler#canHandleInspect(PersistencePackage)}
   */
  @Test
  public void testCanHandleInspect2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuCustomPersistenceHandler skuCustomPersistenceHandler = new SkuCustomPersistenceHandler();
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getCeilingEntityFullyQualifiedClassname()).thenReturn("Dr Jane Doe");
    when(persistencePackage.getPersistencePerspective()).thenReturn(new PersistencePerspective());
    doNothing().when(persistencePackage).setPersistencePerspective(Mockito.<PersistencePerspective>any());
    persistencePackage.setPersistencePerspective(mock(PersistencePerspective.class));

    // Act
    Boolean actualCanHandleInspectResult = skuCustomPersistenceHandler.canHandleInspect(persistencePackage);

    // Assert
    verify(persistencePackage).getCeilingEntityFullyQualifiedClassname();
    verify(persistencePackage).getPersistencePerspective();
    verify(persistencePackage).setPersistencePerspective(isA(PersistencePerspective.class));
    assertFalse(actualCanHandleInspectResult);
  }

  /**
   * Method under test:
   * {@link SkuCustomPersistenceHandler#canHandleFetch(PersistencePackage)}
   */
  @Test
  public void testCanHandleFetch() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuCustomPersistenceHandler skuCustomPersistenceHandler = new SkuCustomPersistenceHandler();
    PersistencePerspective persistencePerspective = mock(PersistencePerspective.class);
    when(persistencePerspective.getOperationTypes()).thenReturn(new OperationTypes());
    Entity entity = new Entity();

    PersistencePackage persistencePackage = new PersistencePackage("Dr Jane Doe", entity, new PersistencePerspective(),
        new String[]{"Custom Criteria"}, "ABC123");
    persistencePackage.setPersistencePerspective(persistencePerspective);

    // Act
    Boolean actualCanHandleFetchResult = skuCustomPersistenceHandler.canHandleFetch(persistencePackage);

    // Assert
    verify(persistencePerspective).getOperationTypes();
    assertFalse(actualCanHandleFetchResult);
  }

  /**
   * Method under test:
   * {@link SkuCustomPersistenceHandler#canHandleFetch(PersistencePackage)}
   */
  @Test
  public void testCanHandleFetch2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuCustomPersistenceHandler skuCustomPersistenceHandler = new SkuCustomPersistenceHandler();
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getCeilingEntityFullyQualifiedClassname()).thenReturn("Dr Jane Doe");
    when(persistencePackage.getPersistencePerspective()).thenReturn(new PersistencePerspective());
    doNothing().when(persistencePackage).setPersistencePerspective(Mockito.<PersistencePerspective>any());
    persistencePackage.setPersistencePerspective(mock(PersistencePerspective.class));

    // Act
    Boolean actualCanHandleFetchResult = skuCustomPersistenceHandler.canHandleFetch(persistencePackage);

    // Assert
    verify(persistencePackage).getCeilingEntityFullyQualifiedClassname();
    verify(persistencePackage).getPersistencePerspective();
    verify(persistencePackage).setPersistencePerspective(isA(PersistencePerspective.class));
    assertFalse(actualCanHandleFetchResult);
  }

  /**
   * Method under test:
   * {@link SkuCustomPersistenceHandler#canHandleAdd(PersistencePackage)}
   */
  @Test
  public void testCanHandleAdd() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuCustomPersistenceHandler skuCustomPersistenceHandler = new SkuCustomPersistenceHandler();
    PersistencePerspective persistencePerspective = mock(PersistencePerspective.class);
    when(persistencePerspective.getOperationTypes()).thenReturn(new OperationTypes());
    Entity entity = new Entity();

    PersistencePackage persistencePackage = new PersistencePackage("Dr Jane Doe", entity, new PersistencePerspective(),
        new String[]{"Custom Criteria"}, "ABC123");
    persistencePackage.setPersistencePerspective(persistencePerspective);

    // Act
    Boolean actualCanHandleAddResult = skuCustomPersistenceHandler.canHandleAdd(persistencePackage);

    // Assert
    verify(persistencePerspective).getOperationTypes();
    assertFalse(actualCanHandleAddResult);
  }

  /**
   * Method under test:
   * {@link SkuCustomPersistenceHandler#canHandleAdd(PersistencePackage)}
   */
  @Test
  public void testCanHandleAdd2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuCustomPersistenceHandler skuCustomPersistenceHandler = new SkuCustomPersistenceHandler();
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getCeilingEntityFullyQualifiedClassname()).thenReturn("Dr Jane Doe");
    when(persistencePackage.getPersistencePerspective()).thenReturn(new PersistencePerspective());
    doNothing().when(persistencePackage).setPersistencePerspective(Mockito.<PersistencePerspective>any());
    persistencePackage.setPersistencePerspective(mock(PersistencePerspective.class));

    // Act
    Boolean actualCanHandleAddResult = skuCustomPersistenceHandler.canHandleAdd(persistencePackage);

    // Assert
    verify(persistencePackage).getCeilingEntityFullyQualifiedClassname();
    verify(persistencePackage).getPersistencePerspective();
    verify(persistencePackage).setPersistencePerspective(isA(PersistencePerspective.class));
    assertFalse(actualCanHandleAddResult);
  }

  /**
   * Method under test:
   * {@link SkuCustomPersistenceHandler#canHandleUpdate(PersistencePackage)}
   */
  @Test
  public void testCanHandleUpdate() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuCustomPersistenceHandler skuCustomPersistenceHandler = new SkuCustomPersistenceHandler();
    PersistencePerspective persistencePerspective = mock(PersistencePerspective.class);
    when(persistencePerspective.getOperationTypes()).thenReturn(new OperationTypes());
    Entity entity = new Entity();

    PersistencePackage persistencePackage = new PersistencePackage("Dr Jane Doe", entity, new PersistencePerspective(),
        new String[]{"Custom Criteria"}, "ABC123");
    persistencePackage.setPersistencePerspective(persistencePerspective);

    // Act
    Boolean actualCanHandleUpdateResult = skuCustomPersistenceHandler.canHandleUpdate(persistencePackage);

    // Assert
    verify(persistencePerspective).getOperationTypes();
    assertFalse(actualCanHandleUpdateResult);
  }

  /**
   * Method under test:
   * {@link SkuCustomPersistenceHandler#canHandleUpdate(PersistencePackage)}
   */
  @Test
  public void testCanHandleUpdate2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuCustomPersistenceHandler skuCustomPersistenceHandler = new SkuCustomPersistenceHandler();
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getCeilingEntityFullyQualifiedClassname()).thenReturn("Dr Jane Doe");
    when(persistencePackage.getPersistencePerspective()).thenReturn(new PersistencePerspective());
    doNothing().when(persistencePackage).setPersistencePerspective(Mockito.<PersistencePerspective>any());
    persistencePackage.setPersistencePerspective(mock(PersistencePerspective.class));

    // Act
    Boolean actualCanHandleUpdateResult = skuCustomPersistenceHandler.canHandleUpdate(persistencePackage);

    // Assert
    verify(persistencePackage).getCeilingEntityFullyQualifiedClassname();
    verify(persistencePackage).getPersistencePerspective();
    verify(persistencePackage).setPersistencePerspective(isA(PersistencePerspective.class));
    assertFalse(actualCanHandleUpdateResult);
  }

  /**
   * Method under test:
   * {@link SkuCustomPersistenceHandler#canHandle(PersistencePackage, OperationType)}
   */
  @Test
  public void testCanHandle() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuCustomPersistenceHandler skuCustomPersistenceHandler = new SkuCustomPersistenceHandler();
    Entity entity = new Entity();

    // Act and Assert
    assertFalse(skuCustomPersistenceHandler.canHandle(new PersistencePackage("Dr Jane Doe", entity,
        new PersistencePerspective(), new String[]{"Custom Criteria"}, "ABC123"), OperationType.NONDESTRUCTIVEREMOVE));
  }

  /**
   * Method under test:
   * {@link SkuCustomPersistenceHandler#canHandle(PersistencePackage, OperationType)}
   */
  @Test
  public void testCanHandle2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuCustomPersistenceHandler skuCustomPersistenceHandler = new SkuCustomPersistenceHandler();
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getCeilingEntityFullyQualifiedClassname()).thenReturn("Dr Jane Doe");

    // Act
    Boolean actualCanHandleResult = skuCustomPersistenceHandler.canHandle(persistencePackage,
        OperationType.NONDESTRUCTIVEREMOVE);

    // Assert
    verify(persistencePackage).getCeilingEntityFullyQualifiedClassname();
    assertFalse(actualCanHandleResult);
  }

  /**
   * Method under test:
   * {@link SkuCustomPersistenceHandler#getOwningProductId(SectionCrumb[])}
   */
  @Test
  public void testGetOwningProductId() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuCustomPersistenceHandler skuCustomPersistenceHandler = new SkuCustomPersistenceHandler();

    SectionCrumb sectionCrumb = new SectionCrumb();
    sectionCrumb.setOriginalSectionIdentifier("42");
    sectionCrumb.setSectionId("42");
    sectionCrumb.setSectionIdentifier("42");

    // Act and Assert
    assertNull(skuCustomPersistenceHandler.getOwningProductId(new SectionCrumb[]{sectionCrumb}));
  }

  /**
   * Method under test:
   * {@link SkuCustomPersistenceHandler#getOwningProductId(SectionCrumb[])}
   */
  @Test
  public void testGetOwningProductId2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuCustomPersistenceHandler skuCustomPersistenceHandler = new SkuCustomPersistenceHandler();
    SectionCrumb sectionCrumb = mock(SectionCrumb.class);
    when(sectionCrumb.getSectionIdentifier()).thenReturn("42");
    doNothing().when(sectionCrumb).setOriginalSectionIdentifier(Mockito.<String>any());
    doNothing().when(sectionCrumb).setSectionId(Mockito.<String>any());
    doNothing().when(sectionCrumb).setSectionIdentifier(Mockito.<String>any());
    sectionCrumb.setOriginalSectionIdentifier("42");
    sectionCrumb.setSectionId("42");
    sectionCrumb.setSectionIdentifier("42");

    // Act
    String actualOwningProductId = skuCustomPersistenceHandler.getOwningProductId(new SectionCrumb[]{sectionCrumb});

    // Assert
    verify(sectionCrumb).getSectionIdentifier();
    verify(sectionCrumb).setOriginalSectionIdentifier(eq("42"));
    verify(sectionCrumb).setSectionId(eq("42"));
    verify(sectionCrumb).setSectionIdentifier(eq("42"));
    assertNull(actualOwningProductId);
  }

  /**
   * Method under test:
   * {@link SkuCustomPersistenceHandler#getOwningProductId(SectionCrumb[])}
   */
  @Test
  public void testGetOwningProductId3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuCustomPersistenceHandler skuCustomPersistenceHandler = new SkuCustomPersistenceHandler();
    SectionCrumb sectionCrumb = mock(SectionCrumb.class);
    when(sectionCrumb.getSectionId()).thenReturn("42");
    when(sectionCrumb.getSectionIdentifier()).thenReturn("org.broadleafcommerce.core.catalog.domain.ProductImpl");
    doNothing().when(sectionCrumb).setOriginalSectionIdentifier(Mockito.<String>any());
    doNothing().when(sectionCrumb).setSectionId(Mockito.<String>any());
    doNothing().when(sectionCrumb).setSectionIdentifier(Mockito.<String>any());
    sectionCrumb.setOriginalSectionIdentifier("42");
    sectionCrumb.setSectionId("42");
    sectionCrumb.setSectionIdentifier("42");

    // Act
    String actualOwningProductId = skuCustomPersistenceHandler.getOwningProductId(new SectionCrumb[]{sectionCrumb});

    // Assert
    verify(sectionCrumb).getSectionId();
    verify(sectionCrumb).getSectionIdentifier();
    verify(sectionCrumb).setOriginalSectionIdentifier(eq("42"));
    verify(sectionCrumb).setSectionId(eq("42"));
    verify(sectionCrumb).setSectionIdentifier(eq("42"));
    assertEquals("42", actualOwningProductId);
  }

  /**
   * Method under test:
   * {@link SkuCustomPersistenceHandler#getOwningProductId(SectionCrumb[])}
   */
  @Test
  public void testGetOwningProductId4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new SkuCustomPersistenceHandler()).getOwningProductId(new SectionCrumb[]{}));
  }

  /**
   * Method under test:
   * {@link SkuCustomPersistenceHandler#getOwningProductId(SectionCrumb[])}
   */
  @Test
  public void testGetOwningProductId5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuCustomPersistenceHandler skuCustomPersistenceHandler = new SkuCustomPersistenceHandler();
    SectionCrumb sectionCrumb = mock(SectionCrumb.class);
    when(sectionCrumb.getSectionId())
        .thenThrow(new NumberFormatException("org.broadleafcommerce.core.catalog.domain.ProductImpl"));
    when(sectionCrumb.getSectionIdentifier()).thenReturn("org.broadleafcommerce.core.catalog.domain.ProductImpl");
    doNothing().when(sectionCrumb).setOriginalSectionIdentifier(Mockito.<String>any());
    doNothing().when(sectionCrumb).setSectionId(Mockito.<String>any());
    doNothing().when(sectionCrumb).setSectionIdentifier(Mockito.<String>any());
    sectionCrumb.setOriginalSectionIdentifier("42");
    sectionCrumb.setSectionId("42");
    sectionCrumb.setSectionIdentifier("42");

    // Act and Assert
    assertThrows(NumberFormatException.class,
        () -> skuCustomPersistenceHandler.getOwningProductId(new SectionCrumb[]{sectionCrumb}));
    verify(sectionCrumb).getSectionId();
    verify(sectionCrumb).getSectionIdentifier();
    verify(sectionCrumb).setOriginalSectionIdentifier(eq("42"));
    verify(sectionCrumb).setSectionId(eq("42"));
    verify(sectionCrumb).setSectionIdentifier(eq("42"));
  }

  /**
   * Method under test:
   * {@link SkuCustomPersistenceHandler#filterOutProductMetadata(Map)}
   */
  @Test
  public void testFilterOutProductMetadata() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuCustomPersistenceHandler skuCustomPersistenceHandler = new SkuCustomPersistenceHandler();
    HashMap<String, FieldMetadata> map = new HashMap<>();

    // Act
    skuCustomPersistenceHandler.filterOutProductMetadata(map);

    // Assert that nothing has changed
    FieldMetadata metadata = skuCustomPersistenceHandler.getBlankConsolidatedOptionProperty().getMetadata();
    assertTrue(metadata instanceof BasicFieldMetadata);
    assertTrue(map.isEmpty());
    assertTrue(((BasicFieldMetadata) metadata).getValidationConfigurations().isEmpty());
    assertTrue(metadata.getAdditionalMetadata().isEmpty());
  }

  /**
   * Method under test:
   * {@link SkuCustomPersistenceHandler#filterOutProductMetadata(Map)}
   */
  @Test
  public void testFilterOutProductMetadata2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuCustomPersistenceHandler skuCustomPersistenceHandler = new SkuCustomPersistenceHandler();

    HashMap<String, FieldMetadata> map = new HashMap<>();
    map.put("foo", new AdornedTargetCollectionMetadata());

    // Act
    skuCustomPersistenceHandler.filterOutProductMetadata(map);

    // Assert that nothing has changed
    FieldMetadata metadata = skuCustomPersistenceHandler.getBlankConsolidatedOptionProperty().getMetadata();
    assertTrue(metadata instanceof BasicFieldMetadata);
    assertEquals(1, map.size());
    assertTrue(map.containsKey("foo"));
    assertTrue(((BasicFieldMetadata) metadata).getValidationConfigurations().isEmpty());
    assertTrue(metadata.getAdditionalMetadata().isEmpty());
  }

  /**
   * Method under test:
   * {@link SkuCustomPersistenceHandler#filterOutProductMetadata(Map)}
   */
  @Test
  public void testFilterOutProductMetadata3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuCustomPersistenceHandler skuCustomPersistenceHandler = new SkuCustomPersistenceHandler();

    HashMap<String, FieldMetadata> map = new HashMap<>();
    map.put("product.", new AdornedTargetCollectionMetadata());
    map.put("foo", new AdornedTargetCollectionMetadata());

    // Act
    skuCustomPersistenceHandler.filterOutProductMetadata(map);

    // Assert
    FieldMetadata metadata = skuCustomPersistenceHandler.getBlankConsolidatedOptionProperty().getMetadata();
    assertTrue(metadata instanceof BasicFieldMetadata);
    assertEquals(1, map.size());
    assertTrue(map.containsKey("foo"));
    assertTrue(((BasicFieldMetadata) metadata).getValidationConfigurations().isEmpty());
    assertTrue(metadata.getAdditionalMetadata().isEmpty());
  }

  /**
   * Method under test:
   * {@link SkuCustomPersistenceHandler#filterOutProductMetadata(Map)}
   */
  @Test
  public void testFilterOutProductMetadata4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuCustomPersistenceHandler skuCustomPersistenceHandler = new SkuCustomPersistenceHandler();

    HashMap<String, FieldMetadata> map = new HashMap<>();
    map.computeIfPresent("defaultProduct.", mock(BiFunction.class));
    map.put("foo", new AdornedTargetCollectionMetadata());

    // Act
    skuCustomPersistenceHandler.filterOutProductMetadata(map);

    // Assert that nothing has changed
    FieldMetadata metadata = skuCustomPersistenceHandler.getBlankConsolidatedOptionProperty().getMetadata();
    assertTrue(metadata instanceof BasicFieldMetadata);
    assertEquals(1, map.size());
    assertTrue(map.containsKey("foo"));
    assertTrue(((BasicFieldMetadata) metadata).getValidationConfigurations().isEmpty());
    assertTrue(metadata.getAdditionalMetadata().isEmpty());
  }

  /**
   * Method under test:
   * {@link SkuCustomPersistenceHandler#filterOutProductMetadata(Map)}
   */
  @Test
  public void testFilterOutProductMetadata5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuCustomPersistenceHandler skuCustomPersistenceHandler = new SkuCustomPersistenceHandler();

    HashMap<String, FieldMetadata> map = new HashMap<>();
    map.put("defaultProduct.", new AdornedTargetCollectionMetadata());

    // Act
    skuCustomPersistenceHandler.filterOutProductMetadata(map);

    // Assert
    FieldMetadata metadata = skuCustomPersistenceHandler.getBlankConsolidatedOptionProperty().getMetadata();
    assertTrue(metadata instanceof BasicFieldMetadata);
    assertTrue(map.isEmpty());
    assertTrue(((BasicFieldMetadata) metadata).getValidationConfigurations().isEmpty());
    assertTrue(metadata.getAdditionalMetadata().isEmpty());
  }

  /**
   * Method under test:
   * {@link SkuCustomPersistenceHandler#getConsolidatedOptionProperty(Collection)}
   */
  @Test
  public void testGetConsolidatedOptionProperty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuCustomPersistenceHandler skuCustomPersistenceHandler = new SkuCustomPersistenceHandler();

    // Act
    Property actualConsolidatedOptionProperty = skuCustomPersistenceHandler
        .getConsolidatedOptionProperty(new ArrayList<>());

    // Assert
    FieldMetadata metadata = actualConsolidatedOptionProperty.getMetadata();
    assertTrue(metadata instanceof BasicFieldMetadata);
    assertEquals("", actualConsolidatedOptionProperty.getRawValue());
    assertEquals("", actualConsolidatedOptionProperty.getUnHtmlEncodedValue());
    assertEquals("", actualConsolidatedOptionProperty.getValue());
    assertEquals("consolidatedProductOptions", actualConsolidatedOptionProperty.getName());
    assertNull(((BasicFieldMetadata) metadata).getCustomCriteria());
    assertNull(metadata.getAvailableToTypes());
    assertNull(((BasicFieldMetadata) metadata).getEnumerationValues());
    assertNull(((BasicFieldMetadata) metadata).getOptionFilterParams());
    assertNull(((BasicFieldMetadata) metadata).getCanLinkToExternalEntity());
    assertNull(((BasicFieldMetadata) metadata).getEnableTypeaheadLookup());
    assertNull(((BasicFieldMetadata) metadata).getForcePopulateChildProperties());
    assertNull(((BasicFieldMetadata) metadata).getGroupCollapsed());
    assertNull(((BasicFieldMetadata) metadata).getHideEnumerationIfEmpty());
    assertNull(((BasicFieldMetadata) metadata).getIsDerived());
    assertNull(((BasicFieldMetadata) metadata).getIsFilter());
    assertNull(((BasicFieldMetadata) metadata).getMutable());
    assertNull(((BasicFieldMetadata) metadata).getOptionCanEditValues());
    assertNull(((BasicFieldMetadata) metadata).getOptionHideIfEmpty());
    assertNull(((BasicFieldMetadata) metadata).getReadOnly());
    assertNull(((BasicFieldMetadata) metadata).getRequiredOverride());
    assertNull(((BasicFieldMetadata) metadata).getSearchable());
    assertNull(((BasicFieldMetadata) metadata).getToOneLookupCreatedViaAnnotation());
    assertNull(((BasicFieldMetadata) metadata).getTranslatable());
    assertNull(((BasicFieldMetadata) metadata).getUnique());
    assertNull(((BasicFieldMetadata) metadata).getUseServerSideInspectionCache());
    assertNull(((BasicFieldMetadata) metadata).isLargeEntry());
    assertNull(((BasicFieldMetadata) metadata).isProminent());
    assertNull(metadata.getChildrenExcluded());
    assertNull(metadata.getExcluded());
    assertNull(metadata.getLazyFetch());
    assertNull(((BasicFieldMetadata) metadata).getGridOrder());
    assertNull(((BasicFieldMetadata) metadata).getLength());
    assertNull(((BasicFieldMetadata) metadata).getPrecision());
    assertNull(((BasicFieldMetadata) metadata).getScale());
    assertNull(metadata.getGroupOrder());
    assertNull(metadata.getOrder());
    assertNull(metadata.getTabOrder());
    assertNull(((BasicFieldMetadata) metadata).getAssociatedFieldName());
    assertNull(((BasicFieldMetadata) metadata).getBroadleafEnumeration());
    assertNull(((BasicFieldMetadata) metadata).getColumnWidth());
    assertNull(((BasicFieldMetadata) metadata).getDefaultValue());
    assertNull(((BasicFieldMetadata) metadata).getEnumerationClass());
    assertNull(((BasicFieldMetadata) metadata).getFieldComponentRendererTemplate());
    assertNull(((BasicFieldMetadata) metadata).getForeignKeyClass());
    assertNull(((BasicFieldMetadata) metadata).getForeignKeyDisplayValueProperty());
    assertNull(((BasicFieldMetadata) metadata).getForeignKeyProperty());
    assertNull(((BasicFieldMetadata) metadata).getGridFieldComponentRendererTemplate());
    assertNull(((BasicFieldMetadata) metadata).getHelpText());
    assertNull(((BasicFieldMetadata) metadata).getHint());
    assertNull(((BasicFieldMetadata) metadata).getLookupDisplayProperty());
    assertNull(((BasicFieldMetadata) metadata).getManyToField());
    assertNull(((BasicFieldMetadata) metadata).getMapFieldValueClass());
    assertNull(((BasicFieldMetadata) metadata).getMapKeyValueProperty());
    assertNull(((BasicFieldMetadata) metadata).getName());
    assertNull(((BasicFieldMetadata) metadata).getOptionDisplayFieldName());
    assertNull(((BasicFieldMetadata) metadata).getOptionListEntity());
    assertNull(((BasicFieldMetadata) metadata).getOptionValueFieldName());
    assertNull(((BasicFieldMetadata) metadata).getRuleIdentifier());
    assertNull(((BasicFieldMetadata) metadata).getToOneParentProperty());
    assertNull(((BasicFieldMetadata) metadata).getToOneTargetProperty());
    assertNull(((BasicFieldMetadata) metadata).getTooltip());
    assertNull(metadata.getAddFriendlyName());
    assertNull(metadata.getCurrencyCodeField());
    assertNull(metadata.getFieldName());
    assertNull(metadata.getFriendlyName());
    assertNull(metadata.getGroup());
    assertNull(metadata.getInheritedFromType());
    assertNull(metadata.getOwningClass());
    assertNull(metadata.getOwningClassFriendlyName());
    assertNull(metadata.getPrefix());
    assertNull(metadata.getSecurityLevel());
    assertNull(metadata.getShowIfProperty());
    assertNull(metadata.getTab());
    assertNull(metadata.getTargetClass());
    assertNull(actualConsolidatedOptionProperty.getDisplayValue());
    assertNull(actualConsolidatedOptionProperty.getOriginalDisplayValue());
    assertNull(actualConsolidatedOptionProperty.getOriginalValue());
    assertNull(actualConsolidatedOptionProperty.getDeployDate());
    assertNull(metadata.getShowIfFieldEquals());
    assertNull(((BasicFieldMetadata) metadata).getLookupType());
    assertNull(((BasicFieldMetadata) metadata).getDisplayType());
    assertNull(((BasicFieldMetadata) metadata).getExplicitFieldType());
    assertNull(((BasicFieldMetadata) metadata).getFieldComponentRenderer());
    assertNull(((BasicFieldMetadata) metadata).getFieldType());
    assertNull(((BasicFieldMetadata) metadata).getGridFieldComponentRenderer());
    assertNull(((BasicFieldMetadata) metadata).getVisibility());
    assertNull(((BasicFieldMetadata) metadata).getMergedPropertyType());
    assertEquals(SupportedFieldType.INTEGER, ((BasicFieldMetadata) metadata).getSecondaryType());
    assertFalse(((BasicFieldMetadata) metadata).getForeignKeyCollection());
    assertFalse(((BasicFieldMetadata) metadata).getRequired());
    assertFalse(metadata.getManualFetch());
    assertFalse(actualConsolidatedOptionProperty.getIsDirty());
    assertFalse(actualConsolidatedOptionProperty.isAdvancedCollection());
    assertTrue(((BasicFieldMetadata) metadata).getValidationConfigurations().isEmpty());
    assertTrue(metadata.getAdditionalMetadata().isEmpty());
    assertTrue(((BasicFieldMetadata) metadata).getAllowNoValueEnumOption());
    assertTrue(actualConsolidatedOptionProperty.getEnabled());
  }

  /**
   * Method under test:
   * {@link SkuCustomPersistenceHandler#getConsolidatedOptionProperty(Collection)}
   */
  @Test
  public void testGetConsolidatedOptionProperty2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuCustomPersistenceHandler skuCustomPersistenceHandler = new SkuCustomPersistenceHandler();

    ArrayList<ProductOptionValue> values = new ArrayList<>();
    values.add(new ProductOptionValueImpl());

    // Act
    Property actualConsolidatedOptionProperty = skuCustomPersistenceHandler.getConsolidatedOptionProperty(values);

    // Assert
    FieldMetadata metadata = actualConsolidatedOptionProperty.getMetadata();
    assertTrue(metadata instanceof BasicFieldMetadata);
    assertEquals("", actualConsolidatedOptionProperty.getRawValue());
    assertEquals("", actualConsolidatedOptionProperty.getUnHtmlEncodedValue());
    assertEquals("", actualConsolidatedOptionProperty.getValue());
    assertEquals("consolidatedProductOptions", actualConsolidatedOptionProperty.getName());
    assertNull(((BasicFieldMetadata) metadata).getCustomCriteria());
    assertNull(metadata.getAvailableToTypes());
    assertNull(((BasicFieldMetadata) metadata).getEnumerationValues());
    assertNull(((BasicFieldMetadata) metadata).getOptionFilterParams());
    assertNull(((BasicFieldMetadata) metadata).getCanLinkToExternalEntity());
    assertNull(((BasicFieldMetadata) metadata).getEnableTypeaheadLookup());
    assertNull(((BasicFieldMetadata) metadata).getForcePopulateChildProperties());
    assertNull(((BasicFieldMetadata) metadata).getGroupCollapsed());
    assertNull(((BasicFieldMetadata) metadata).getHideEnumerationIfEmpty());
    assertNull(((BasicFieldMetadata) metadata).getIsDerived());
    assertNull(((BasicFieldMetadata) metadata).getIsFilter());
    assertNull(((BasicFieldMetadata) metadata).getMutable());
    assertNull(((BasicFieldMetadata) metadata).getOptionCanEditValues());
    assertNull(((BasicFieldMetadata) metadata).getOptionHideIfEmpty());
    assertNull(((BasicFieldMetadata) metadata).getReadOnly());
    assertNull(((BasicFieldMetadata) metadata).getRequiredOverride());
    assertNull(((BasicFieldMetadata) metadata).getSearchable());
    assertNull(((BasicFieldMetadata) metadata).getToOneLookupCreatedViaAnnotation());
    assertNull(((BasicFieldMetadata) metadata).getTranslatable());
    assertNull(((BasicFieldMetadata) metadata).getUnique());
    assertNull(((BasicFieldMetadata) metadata).getUseServerSideInspectionCache());
    assertNull(((BasicFieldMetadata) metadata).isLargeEntry());
    assertNull(((BasicFieldMetadata) metadata).isProminent());
    assertNull(metadata.getChildrenExcluded());
    assertNull(metadata.getExcluded());
    assertNull(metadata.getLazyFetch());
    assertNull(((BasicFieldMetadata) metadata).getGridOrder());
    assertNull(((BasicFieldMetadata) metadata).getLength());
    assertNull(((BasicFieldMetadata) metadata).getPrecision());
    assertNull(((BasicFieldMetadata) metadata).getScale());
    assertNull(metadata.getGroupOrder());
    assertNull(metadata.getOrder());
    assertNull(metadata.getTabOrder());
    assertNull(((BasicFieldMetadata) metadata).getAssociatedFieldName());
    assertNull(((BasicFieldMetadata) metadata).getBroadleafEnumeration());
    assertNull(((BasicFieldMetadata) metadata).getColumnWidth());
    assertNull(((BasicFieldMetadata) metadata).getDefaultValue());
    assertNull(((BasicFieldMetadata) metadata).getEnumerationClass());
    assertNull(((BasicFieldMetadata) metadata).getFieldComponentRendererTemplate());
    assertNull(((BasicFieldMetadata) metadata).getForeignKeyClass());
    assertNull(((BasicFieldMetadata) metadata).getForeignKeyDisplayValueProperty());
    assertNull(((BasicFieldMetadata) metadata).getForeignKeyProperty());
    assertNull(((BasicFieldMetadata) metadata).getGridFieldComponentRendererTemplate());
    assertNull(((BasicFieldMetadata) metadata).getHelpText());
    assertNull(((BasicFieldMetadata) metadata).getHint());
    assertNull(((BasicFieldMetadata) metadata).getLookupDisplayProperty());
    assertNull(((BasicFieldMetadata) metadata).getManyToField());
    assertNull(((BasicFieldMetadata) metadata).getMapFieldValueClass());
    assertNull(((BasicFieldMetadata) metadata).getMapKeyValueProperty());
    assertNull(((BasicFieldMetadata) metadata).getName());
    assertNull(((BasicFieldMetadata) metadata).getOptionDisplayFieldName());
    assertNull(((BasicFieldMetadata) metadata).getOptionListEntity());
    assertNull(((BasicFieldMetadata) metadata).getOptionValueFieldName());
    assertNull(((BasicFieldMetadata) metadata).getRuleIdentifier());
    assertNull(((BasicFieldMetadata) metadata).getToOneParentProperty());
    assertNull(((BasicFieldMetadata) metadata).getToOneTargetProperty());
    assertNull(((BasicFieldMetadata) metadata).getTooltip());
    assertNull(metadata.getAddFriendlyName());
    assertNull(metadata.getCurrencyCodeField());
    assertNull(metadata.getFieldName());
    assertNull(metadata.getFriendlyName());
    assertNull(metadata.getGroup());
    assertNull(metadata.getInheritedFromType());
    assertNull(metadata.getOwningClass());
    assertNull(metadata.getOwningClassFriendlyName());
    assertNull(metadata.getPrefix());
    assertNull(metadata.getSecurityLevel());
    assertNull(metadata.getShowIfProperty());
    assertNull(metadata.getTab());
    assertNull(metadata.getTargetClass());
    assertNull(actualConsolidatedOptionProperty.getDisplayValue());
    assertNull(actualConsolidatedOptionProperty.getOriginalDisplayValue());
    assertNull(actualConsolidatedOptionProperty.getOriginalValue());
    assertNull(actualConsolidatedOptionProperty.getDeployDate());
    assertNull(metadata.getShowIfFieldEquals());
    assertNull(((BasicFieldMetadata) metadata).getLookupType());
    assertNull(((BasicFieldMetadata) metadata).getDisplayType());
    assertNull(((BasicFieldMetadata) metadata).getExplicitFieldType());
    assertNull(((BasicFieldMetadata) metadata).getFieldComponentRenderer());
    assertNull(((BasicFieldMetadata) metadata).getFieldType());
    assertNull(((BasicFieldMetadata) metadata).getGridFieldComponentRenderer());
    assertNull(((BasicFieldMetadata) metadata).getVisibility());
    assertNull(((BasicFieldMetadata) metadata).getMergedPropertyType());
    assertEquals(SupportedFieldType.INTEGER, ((BasicFieldMetadata) metadata).getSecondaryType());
    assertFalse(((BasicFieldMetadata) metadata).getForeignKeyCollection());
    assertFalse(((BasicFieldMetadata) metadata).getRequired());
    assertFalse(metadata.getManualFetch());
    assertFalse(actualConsolidatedOptionProperty.getIsDirty());
    assertFalse(actualConsolidatedOptionProperty.isAdvancedCollection());
    assertTrue(((BasicFieldMetadata) metadata).getValidationConfigurations().isEmpty());
    assertTrue(metadata.getAdditionalMetadata().isEmpty());
    assertTrue(((BasicFieldMetadata) metadata).getAllowNoValueEnumOption());
    assertTrue(actualConsolidatedOptionProperty.getEnabled());
  }

  /**
   * Method under test:
   * {@link SkuCustomPersistenceHandler#getConsolidatedOptionProperty(Collection)}
   */
  @Test
  public void testGetConsolidatedOptionProperty3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuCustomPersistenceHandler skuCustomPersistenceHandler = new SkuCustomPersistenceHandler();

    ArrayList<ProductOptionValue> values = new ArrayList<>();
    values.add(new ProductOptionValueImpl());
    values.add(new ProductOptionValueImpl());

    // Act
    Property actualConsolidatedOptionProperty = skuCustomPersistenceHandler.getConsolidatedOptionProperty(values);

    // Assert
    FieldMetadata metadata = actualConsolidatedOptionProperty.getMetadata();
    assertTrue(metadata instanceof BasicFieldMetadata);
    assertEquals("; ", actualConsolidatedOptionProperty.getRawValue());
    assertEquals("; ", actualConsolidatedOptionProperty.getUnHtmlEncodedValue());
    assertEquals("; ", actualConsolidatedOptionProperty.getValue());
    assertEquals("consolidatedProductOptions", actualConsolidatedOptionProperty.getName());
    assertNull(((BasicFieldMetadata) metadata).getCustomCriteria());
    assertNull(metadata.getAvailableToTypes());
    assertNull(((BasicFieldMetadata) metadata).getEnumerationValues());
    assertNull(((BasicFieldMetadata) metadata).getOptionFilterParams());
    assertNull(((BasicFieldMetadata) metadata).getCanLinkToExternalEntity());
    assertNull(((BasicFieldMetadata) metadata).getEnableTypeaheadLookup());
    assertNull(((BasicFieldMetadata) metadata).getForcePopulateChildProperties());
    assertNull(((BasicFieldMetadata) metadata).getGroupCollapsed());
    assertNull(((BasicFieldMetadata) metadata).getHideEnumerationIfEmpty());
    assertNull(((BasicFieldMetadata) metadata).getIsDerived());
    assertNull(((BasicFieldMetadata) metadata).getIsFilter());
    assertNull(((BasicFieldMetadata) metadata).getMutable());
    assertNull(((BasicFieldMetadata) metadata).getOptionCanEditValues());
    assertNull(((BasicFieldMetadata) metadata).getOptionHideIfEmpty());
    assertNull(((BasicFieldMetadata) metadata).getReadOnly());
    assertNull(((BasicFieldMetadata) metadata).getRequiredOverride());
    assertNull(((BasicFieldMetadata) metadata).getSearchable());
    assertNull(((BasicFieldMetadata) metadata).getToOneLookupCreatedViaAnnotation());
    assertNull(((BasicFieldMetadata) metadata).getTranslatable());
    assertNull(((BasicFieldMetadata) metadata).getUnique());
    assertNull(((BasicFieldMetadata) metadata).getUseServerSideInspectionCache());
    assertNull(((BasicFieldMetadata) metadata).isLargeEntry());
    assertNull(((BasicFieldMetadata) metadata).isProminent());
    assertNull(metadata.getChildrenExcluded());
    assertNull(metadata.getExcluded());
    assertNull(metadata.getLazyFetch());
    assertNull(((BasicFieldMetadata) metadata).getGridOrder());
    assertNull(((BasicFieldMetadata) metadata).getLength());
    assertNull(((BasicFieldMetadata) metadata).getPrecision());
    assertNull(((BasicFieldMetadata) metadata).getScale());
    assertNull(metadata.getGroupOrder());
    assertNull(metadata.getOrder());
    assertNull(metadata.getTabOrder());
    assertNull(((BasicFieldMetadata) metadata).getAssociatedFieldName());
    assertNull(((BasicFieldMetadata) metadata).getBroadleafEnumeration());
    assertNull(((BasicFieldMetadata) metadata).getColumnWidth());
    assertNull(((BasicFieldMetadata) metadata).getDefaultValue());
    assertNull(((BasicFieldMetadata) metadata).getEnumerationClass());
    assertNull(((BasicFieldMetadata) metadata).getFieldComponentRendererTemplate());
    assertNull(((BasicFieldMetadata) metadata).getForeignKeyClass());
    assertNull(((BasicFieldMetadata) metadata).getForeignKeyDisplayValueProperty());
    assertNull(((BasicFieldMetadata) metadata).getForeignKeyProperty());
    assertNull(((BasicFieldMetadata) metadata).getGridFieldComponentRendererTemplate());
    assertNull(((BasicFieldMetadata) metadata).getHelpText());
    assertNull(((BasicFieldMetadata) metadata).getHint());
    assertNull(((BasicFieldMetadata) metadata).getLookupDisplayProperty());
    assertNull(((BasicFieldMetadata) metadata).getManyToField());
    assertNull(((BasicFieldMetadata) metadata).getMapFieldValueClass());
    assertNull(((BasicFieldMetadata) metadata).getMapKeyValueProperty());
    assertNull(((BasicFieldMetadata) metadata).getName());
    assertNull(((BasicFieldMetadata) metadata).getOptionDisplayFieldName());
    assertNull(((BasicFieldMetadata) metadata).getOptionListEntity());
    assertNull(((BasicFieldMetadata) metadata).getOptionValueFieldName());
    assertNull(((BasicFieldMetadata) metadata).getRuleIdentifier());
    assertNull(((BasicFieldMetadata) metadata).getToOneParentProperty());
    assertNull(((BasicFieldMetadata) metadata).getToOneTargetProperty());
    assertNull(((BasicFieldMetadata) metadata).getTooltip());
    assertNull(metadata.getAddFriendlyName());
    assertNull(metadata.getCurrencyCodeField());
    assertNull(metadata.getFieldName());
    assertNull(metadata.getFriendlyName());
    assertNull(metadata.getGroup());
    assertNull(metadata.getInheritedFromType());
    assertNull(metadata.getOwningClass());
    assertNull(metadata.getOwningClassFriendlyName());
    assertNull(metadata.getPrefix());
    assertNull(metadata.getSecurityLevel());
    assertNull(metadata.getShowIfProperty());
    assertNull(metadata.getTab());
    assertNull(metadata.getTargetClass());
    assertNull(actualConsolidatedOptionProperty.getDisplayValue());
    assertNull(actualConsolidatedOptionProperty.getOriginalDisplayValue());
    assertNull(actualConsolidatedOptionProperty.getOriginalValue());
    assertNull(actualConsolidatedOptionProperty.getDeployDate());
    assertNull(metadata.getShowIfFieldEquals());
    assertNull(((BasicFieldMetadata) metadata).getLookupType());
    assertNull(((BasicFieldMetadata) metadata).getDisplayType());
    assertNull(((BasicFieldMetadata) metadata).getExplicitFieldType());
    assertNull(((BasicFieldMetadata) metadata).getFieldComponentRenderer());
    assertNull(((BasicFieldMetadata) metadata).getFieldType());
    assertNull(((BasicFieldMetadata) metadata).getGridFieldComponentRenderer());
    assertNull(((BasicFieldMetadata) metadata).getVisibility());
    assertNull(((BasicFieldMetadata) metadata).getMergedPropertyType());
    assertEquals(SupportedFieldType.INTEGER, ((BasicFieldMetadata) metadata).getSecondaryType());
    assertFalse(((BasicFieldMetadata) metadata).getForeignKeyCollection());
    assertFalse(((BasicFieldMetadata) metadata).getRequired());
    assertFalse(metadata.getManualFetch());
    assertFalse(actualConsolidatedOptionProperty.getIsDirty());
    assertFalse(actualConsolidatedOptionProperty.isAdvancedCollection());
    assertTrue(((BasicFieldMetadata) metadata).getValidationConfigurations().isEmpty());
    assertTrue(metadata.getAdditionalMetadata().isEmpty());
    assertTrue(((BasicFieldMetadata) metadata).getAllowNoValueEnumOption());
    assertTrue(actualConsolidatedOptionProperty.getEnabled());
  }

  /**
   * Method under test:
   * {@link SkuCustomPersistenceHandler#getConsolidatedOptionProperty(Collection)}
   */
  @Test
  public void testGetConsolidatedOptionProperty4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuCustomPersistenceHandler skuCustomPersistenceHandler = new SkuCustomPersistenceHandler();
    ProductOptionValueImpl productOptionValueImpl = mock(ProductOptionValueImpl.class);
    when(productOptionValueImpl.getAttributeValue()).thenReturn("42");

    ArrayList<ProductOptionValue> values = new ArrayList<>();
    values.add(productOptionValueImpl);

    // Act
    Property actualConsolidatedOptionProperty = skuCustomPersistenceHandler.getConsolidatedOptionProperty(values);

    // Assert
    verify(productOptionValueImpl).getAttributeValue();
    FieldMetadata metadata = actualConsolidatedOptionProperty.getMetadata();
    assertTrue(metadata instanceof BasicFieldMetadata);
    assertEquals("42", actualConsolidatedOptionProperty.getRawValue());
    assertEquals("42", actualConsolidatedOptionProperty.getUnHtmlEncodedValue());
    assertEquals("42", actualConsolidatedOptionProperty.getValue());
    assertEquals("consolidatedProductOptions", actualConsolidatedOptionProperty.getName());
    assertNull(((BasicFieldMetadata) metadata).getCustomCriteria());
    assertNull(metadata.getAvailableToTypes());
    assertNull(((BasicFieldMetadata) metadata).getEnumerationValues());
    assertNull(((BasicFieldMetadata) metadata).getOptionFilterParams());
    assertNull(((BasicFieldMetadata) metadata).getCanLinkToExternalEntity());
    assertNull(((BasicFieldMetadata) metadata).getEnableTypeaheadLookup());
    assertNull(((BasicFieldMetadata) metadata).getForcePopulateChildProperties());
    assertNull(((BasicFieldMetadata) metadata).getGroupCollapsed());
    assertNull(((BasicFieldMetadata) metadata).getHideEnumerationIfEmpty());
    assertNull(((BasicFieldMetadata) metadata).getIsDerived());
    assertNull(((BasicFieldMetadata) metadata).getIsFilter());
    assertNull(((BasicFieldMetadata) metadata).getMutable());
    assertNull(((BasicFieldMetadata) metadata).getOptionCanEditValues());
    assertNull(((BasicFieldMetadata) metadata).getOptionHideIfEmpty());
    assertNull(((BasicFieldMetadata) metadata).getReadOnly());
    assertNull(((BasicFieldMetadata) metadata).getRequiredOverride());
    assertNull(((BasicFieldMetadata) metadata).getSearchable());
    assertNull(((BasicFieldMetadata) metadata).getToOneLookupCreatedViaAnnotation());
    assertNull(((BasicFieldMetadata) metadata).getTranslatable());
    assertNull(((BasicFieldMetadata) metadata).getUnique());
    assertNull(((BasicFieldMetadata) metadata).getUseServerSideInspectionCache());
    assertNull(((BasicFieldMetadata) metadata).isLargeEntry());
    assertNull(((BasicFieldMetadata) metadata).isProminent());
    assertNull(metadata.getChildrenExcluded());
    assertNull(metadata.getExcluded());
    assertNull(metadata.getLazyFetch());
    assertNull(((BasicFieldMetadata) metadata).getGridOrder());
    assertNull(((BasicFieldMetadata) metadata).getLength());
    assertNull(((BasicFieldMetadata) metadata).getPrecision());
    assertNull(((BasicFieldMetadata) metadata).getScale());
    assertNull(metadata.getGroupOrder());
    assertNull(metadata.getOrder());
    assertNull(metadata.getTabOrder());
    assertNull(((BasicFieldMetadata) metadata).getAssociatedFieldName());
    assertNull(((BasicFieldMetadata) metadata).getBroadleafEnumeration());
    assertNull(((BasicFieldMetadata) metadata).getColumnWidth());
    assertNull(((BasicFieldMetadata) metadata).getDefaultValue());
    assertNull(((BasicFieldMetadata) metadata).getEnumerationClass());
    assertNull(((BasicFieldMetadata) metadata).getFieldComponentRendererTemplate());
    assertNull(((BasicFieldMetadata) metadata).getForeignKeyClass());
    assertNull(((BasicFieldMetadata) metadata).getForeignKeyDisplayValueProperty());
    assertNull(((BasicFieldMetadata) metadata).getForeignKeyProperty());
    assertNull(((BasicFieldMetadata) metadata).getGridFieldComponentRendererTemplate());
    assertNull(((BasicFieldMetadata) metadata).getHelpText());
    assertNull(((BasicFieldMetadata) metadata).getHint());
    assertNull(((BasicFieldMetadata) metadata).getLookupDisplayProperty());
    assertNull(((BasicFieldMetadata) metadata).getManyToField());
    assertNull(((BasicFieldMetadata) metadata).getMapFieldValueClass());
    assertNull(((BasicFieldMetadata) metadata).getMapKeyValueProperty());
    assertNull(((BasicFieldMetadata) metadata).getName());
    assertNull(((BasicFieldMetadata) metadata).getOptionDisplayFieldName());
    assertNull(((BasicFieldMetadata) metadata).getOptionListEntity());
    assertNull(((BasicFieldMetadata) metadata).getOptionValueFieldName());
    assertNull(((BasicFieldMetadata) metadata).getRuleIdentifier());
    assertNull(((BasicFieldMetadata) metadata).getToOneParentProperty());
    assertNull(((BasicFieldMetadata) metadata).getToOneTargetProperty());
    assertNull(((BasicFieldMetadata) metadata).getTooltip());
    assertNull(metadata.getAddFriendlyName());
    assertNull(metadata.getCurrencyCodeField());
    assertNull(metadata.getFieldName());
    assertNull(metadata.getFriendlyName());
    assertNull(metadata.getGroup());
    assertNull(metadata.getInheritedFromType());
    assertNull(metadata.getOwningClass());
    assertNull(metadata.getOwningClassFriendlyName());
    assertNull(metadata.getPrefix());
    assertNull(metadata.getSecurityLevel());
    assertNull(metadata.getShowIfProperty());
    assertNull(metadata.getTab());
    assertNull(metadata.getTargetClass());
    assertNull(actualConsolidatedOptionProperty.getDisplayValue());
    assertNull(actualConsolidatedOptionProperty.getOriginalDisplayValue());
    assertNull(actualConsolidatedOptionProperty.getOriginalValue());
    assertNull(actualConsolidatedOptionProperty.getDeployDate());
    assertNull(metadata.getShowIfFieldEquals());
    assertNull(((BasicFieldMetadata) metadata).getLookupType());
    assertNull(((BasicFieldMetadata) metadata).getDisplayType());
    assertNull(((BasicFieldMetadata) metadata).getExplicitFieldType());
    assertNull(((BasicFieldMetadata) metadata).getFieldComponentRenderer());
    assertNull(((BasicFieldMetadata) metadata).getFieldType());
    assertNull(((BasicFieldMetadata) metadata).getGridFieldComponentRenderer());
    assertNull(((BasicFieldMetadata) metadata).getVisibility());
    assertNull(((BasicFieldMetadata) metadata).getMergedPropertyType());
    assertEquals(SupportedFieldType.INTEGER, ((BasicFieldMetadata) metadata).getSecondaryType());
    assertFalse(((BasicFieldMetadata) metadata).getForeignKeyCollection());
    assertFalse(((BasicFieldMetadata) metadata).getRequired());
    assertFalse(metadata.getManualFetch());
    assertFalse(actualConsolidatedOptionProperty.getIsDirty());
    assertFalse(actualConsolidatedOptionProperty.isAdvancedCollection());
    assertTrue(((BasicFieldMetadata) metadata).getValidationConfigurations().isEmpty());
    assertTrue(metadata.getAdditionalMetadata().isEmpty());
    assertTrue(((BasicFieldMetadata) metadata).getAllowNoValueEnumOption());
    assertTrue(actualConsolidatedOptionProperty.getEnabled());
  }

  /**
   * Method under test:
   * {@link SkuCustomPersistenceHandler#getBlankConsolidatedOptionProperty()}
   */
  @Test
  public void testGetBlankConsolidatedOptionProperty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    Property actualBlankConsolidatedOptionProperty = (new SkuCustomPersistenceHandler())
        .getBlankConsolidatedOptionProperty();

    // Assert
    FieldMetadata metadata = actualBlankConsolidatedOptionProperty.getMetadata();
    assertTrue(metadata instanceof BasicFieldMetadata);
    assertEquals("", actualBlankConsolidatedOptionProperty.getRawValue());
    assertEquals("", actualBlankConsolidatedOptionProperty.getUnHtmlEncodedValue());
    assertEquals("", actualBlankConsolidatedOptionProperty.getValue());
    assertEquals("consolidatedProductOptions", actualBlankConsolidatedOptionProperty.getName());
    assertNull(((BasicFieldMetadata) metadata).getCustomCriteria());
    assertNull(metadata.getAvailableToTypes());
    assertNull(((BasicFieldMetadata) metadata).getEnumerationValues());
    assertNull(((BasicFieldMetadata) metadata).getOptionFilterParams());
    assertNull(((BasicFieldMetadata) metadata).getCanLinkToExternalEntity());
    assertNull(((BasicFieldMetadata) metadata).getEnableTypeaheadLookup());
    assertNull(((BasicFieldMetadata) metadata).getForcePopulateChildProperties());
    assertNull(((BasicFieldMetadata) metadata).getGroupCollapsed());
    assertNull(((BasicFieldMetadata) metadata).getHideEnumerationIfEmpty());
    assertNull(((BasicFieldMetadata) metadata).getIsDerived());
    assertNull(((BasicFieldMetadata) metadata).getIsFilter());
    assertNull(((BasicFieldMetadata) metadata).getMutable());
    assertNull(((BasicFieldMetadata) metadata).getOptionCanEditValues());
    assertNull(((BasicFieldMetadata) metadata).getOptionHideIfEmpty());
    assertNull(((BasicFieldMetadata) metadata).getReadOnly());
    assertNull(((BasicFieldMetadata) metadata).getRequiredOverride());
    assertNull(((BasicFieldMetadata) metadata).getSearchable());
    assertNull(((BasicFieldMetadata) metadata).getToOneLookupCreatedViaAnnotation());
    assertNull(((BasicFieldMetadata) metadata).getTranslatable());
    assertNull(((BasicFieldMetadata) metadata).getUnique());
    assertNull(((BasicFieldMetadata) metadata).getUseServerSideInspectionCache());
    assertNull(((BasicFieldMetadata) metadata).isLargeEntry());
    assertNull(((BasicFieldMetadata) metadata).isProminent());
    assertNull(metadata.getChildrenExcluded());
    assertNull(metadata.getExcluded());
    assertNull(metadata.getLazyFetch());
    assertNull(((BasicFieldMetadata) metadata).getGridOrder());
    assertNull(((BasicFieldMetadata) metadata).getLength());
    assertNull(((BasicFieldMetadata) metadata).getPrecision());
    assertNull(((BasicFieldMetadata) metadata).getScale());
    assertNull(metadata.getGroupOrder());
    assertNull(metadata.getOrder());
    assertNull(metadata.getTabOrder());
    assertNull(((BasicFieldMetadata) metadata).getAssociatedFieldName());
    assertNull(((BasicFieldMetadata) metadata).getBroadleafEnumeration());
    assertNull(((BasicFieldMetadata) metadata).getColumnWidth());
    assertNull(((BasicFieldMetadata) metadata).getDefaultValue());
    assertNull(((BasicFieldMetadata) metadata).getEnumerationClass());
    assertNull(((BasicFieldMetadata) metadata).getFieldComponentRendererTemplate());
    assertNull(((BasicFieldMetadata) metadata).getForeignKeyClass());
    assertNull(((BasicFieldMetadata) metadata).getForeignKeyDisplayValueProperty());
    assertNull(((BasicFieldMetadata) metadata).getForeignKeyProperty());
    assertNull(((BasicFieldMetadata) metadata).getGridFieldComponentRendererTemplate());
    assertNull(((BasicFieldMetadata) metadata).getHelpText());
    assertNull(((BasicFieldMetadata) metadata).getHint());
    assertNull(((BasicFieldMetadata) metadata).getLookupDisplayProperty());
    assertNull(((BasicFieldMetadata) metadata).getManyToField());
    assertNull(((BasicFieldMetadata) metadata).getMapFieldValueClass());
    assertNull(((BasicFieldMetadata) metadata).getMapKeyValueProperty());
    assertNull(((BasicFieldMetadata) metadata).getName());
    assertNull(((BasicFieldMetadata) metadata).getOptionDisplayFieldName());
    assertNull(((BasicFieldMetadata) metadata).getOptionListEntity());
    assertNull(((BasicFieldMetadata) metadata).getOptionValueFieldName());
    assertNull(((BasicFieldMetadata) metadata).getRuleIdentifier());
    assertNull(((BasicFieldMetadata) metadata).getToOneParentProperty());
    assertNull(((BasicFieldMetadata) metadata).getToOneTargetProperty());
    assertNull(((BasicFieldMetadata) metadata).getTooltip());
    assertNull(metadata.getAddFriendlyName());
    assertNull(metadata.getCurrencyCodeField());
    assertNull(metadata.getFieldName());
    assertNull(metadata.getFriendlyName());
    assertNull(metadata.getGroup());
    assertNull(metadata.getInheritedFromType());
    assertNull(metadata.getOwningClass());
    assertNull(metadata.getOwningClassFriendlyName());
    assertNull(metadata.getPrefix());
    assertNull(metadata.getSecurityLevel());
    assertNull(metadata.getShowIfProperty());
    assertNull(metadata.getTab());
    assertNull(metadata.getTargetClass());
    assertNull(actualBlankConsolidatedOptionProperty.getDisplayValue());
    assertNull(actualBlankConsolidatedOptionProperty.getOriginalDisplayValue());
    assertNull(actualBlankConsolidatedOptionProperty.getOriginalValue());
    assertNull(actualBlankConsolidatedOptionProperty.getDeployDate());
    assertNull(metadata.getShowIfFieldEquals());
    assertNull(((BasicFieldMetadata) metadata).getLookupType());
    assertNull(((BasicFieldMetadata) metadata).getDisplayType());
    assertNull(((BasicFieldMetadata) metadata).getExplicitFieldType());
    assertNull(((BasicFieldMetadata) metadata).getFieldComponentRenderer());
    assertNull(((BasicFieldMetadata) metadata).getFieldType());
    assertNull(((BasicFieldMetadata) metadata).getGridFieldComponentRenderer());
    assertNull(((BasicFieldMetadata) metadata).getVisibility());
    assertNull(((BasicFieldMetadata) metadata).getMergedPropertyType());
    assertEquals(SupportedFieldType.INTEGER, ((BasicFieldMetadata) metadata).getSecondaryType());
    assertFalse(((BasicFieldMetadata) metadata).getForeignKeyCollection());
    assertFalse(((BasicFieldMetadata) metadata).getRequired());
    assertFalse(metadata.getManualFetch());
    assertFalse(actualBlankConsolidatedOptionProperty.getIsDirty());
    assertFalse(actualBlankConsolidatedOptionProperty.isAdvancedCollection());
    assertTrue(((BasicFieldMetadata) metadata).getValidationConfigurations().isEmpty());
    assertTrue(metadata.getAdditionalMetadata().isEmpty());
    assertTrue(((BasicFieldMetadata) metadata).getAllowNoValueEnumOption());
    assertTrue(actualBlankConsolidatedOptionProperty.getEnabled());
  }

  /**
   * Method under test:
   * {@link SkuCustomPersistenceHandler#createIndividualOptionField(ProductOption, int)}
   */
  @Test
  public void testCreateIndividualOptionField() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuCustomPersistenceHandler skuCustomPersistenceHandler = new SkuCustomPersistenceHandler();

    // Act and Assert
    assertNull(skuCustomPersistenceHandler.createIndividualOptionField(new ProductOptionImpl(), 1));
  }

  /**
   * Method under test:
   * {@link SkuCustomPersistenceHandler#createIndividualOptionField(ProductOption, int)}
   */
  @Test
  public void testCreateIndividualOptionField2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuCustomPersistenceHandler skuCustomPersistenceHandler = new SkuCustomPersistenceHandler();
    ProductOptionImpl option = mock(ProductOptionImpl.class);
    when(option.getAllowedValues()).thenReturn(new ArrayList<>());

    // Act
    FieldMetadata actualCreateIndividualOptionFieldResult = skuCustomPersistenceHandler
        .createIndividualOptionField(option, 1);

    // Assert
    verify(option).getAllowedValues();
    assertNull(actualCreateIndividualOptionFieldResult);
  }

  /**
   * Method under test:
   * {@link SkuCustomPersistenceHandler#createExplicitEnumerationIndividualOptionField(ProductOption, int)}
   */
  @Test
  public void testCreateExplicitEnumerationIndividualOptionField() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuCustomPersistenceHandler skuCustomPersistenceHandler = new SkuCustomPersistenceHandler();

    // Act and Assert
    assertNull(skuCustomPersistenceHandler.createExplicitEnumerationIndividualOptionField(new ProductOptionImpl(), 1));
  }

  /**
   * Method under test:
   * {@link SkuCustomPersistenceHandler#createExplicitEnumerationIndividualOptionField(ProductOption, int)}
   */
  @Test
  public void testCreateExplicitEnumerationIndividualOptionField2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuCustomPersistenceHandler skuCustomPersistenceHandler = new SkuCustomPersistenceHandler();
    ProductOptionImpl option = mock(ProductOptionImpl.class);
    when(option.getAllowedValues()).thenReturn(new ArrayList<>());

    // Act
    FieldMetadata actualCreateExplicitEnumerationIndividualOptionFieldResult = skuCustomPersistenceHandler
        .createExplicitEnumerationIndividualOptionField(option, 1);

    // Assert
    verify(option).getAllowedValues();
    assertNull(actualCreateExplicitEnumerationIndividualOptionFieldResult);
  }

  /**
   * Method under test:
   * {@link SkuCustomPersistenceHandler#fetch(PersistencePackage, CriteriaTransferObject, DynamicEntityDao, RecordHelper)}
   */
  @Test
  public void testFetch() throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuCustomPersistenceHandler skuCustomPersistenceHandler = new SkuCustomPersistenceHandler();

    SectionCrumb sectionCrumb = new SectionCrumb();
    sectionCrumb.setOriginalSectionIdentifier("42");
    sectionCrumb.setSectionId("42");
    sectionCrumb.setSectionIdentifier("42");
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.containsCriteria(Mockito.<String>any())).thenReturn(true);
    when(persistencePackage.getCustomCriteria()).thenReturn(new String[]{"Custom Criteria"});
    when(persistencePackage.getSectionCrumbs()).thenReturn(new SectionCrumb[]{sectionCrumb});
    when(persistencePackage.getCeilingEntityFullyQualifiedClassname()).thenReturn("Dr Jane Doe");
    when(persistencePackage.getPersistencePerspective()).thenReturn(new PersistencePerspective());
    CriteriaTransferObject cto = new CriteriaTransferObject();
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();
    RecordHelper helper = mock(RecordHelper.class);
    when(helper.getTotalRecords(Mockito.<String>any(), Mockito.<List<FilterMapping>>any())).thenReturn(1);
    when(helper.getFilterMappings(Mockito.<PersistencePerspective>any(), Mockito.<CriteriaTransferObject>any(),
        Mockito.<String>any(), Mockito.<Map<String, FieldMetadata>>any())).thenReturn(new ArrayList<>());
    when(helper.getPersistentRecords(Mockito.<String>any(), Mockito.<List<FilterMapping>>any(), Mockito.<Integer>any(),
        Mockito.<Integer>any())).thenReturn(new ArrayList<>());
    when(helper.getSimpleMergedProperties(Mockito.<String>any(), Mockito.<PersistencePerspective>any()))
        .thenReturn(new HashMap<>());
    Entity entity = new Entity();
    when(helper.getRecords(Mockito.<Map<String, FieldMetadata>>any(), Mockito.<List<Serializable>>any()))
        .thenReturn(new Entity[]{entity});

    // Act
    DynamicResultSet actualFetchResult = skuCustomPersistenceHandler.fetch(persistencePackage, cto, dynamicEntityDao,
        helper);

    // Assert
    verify(persistencePackage, atLeast(1)).containsCriteria(Mockito.<String>any());
    verify(persistencePackage, atLeast(1)).getCeilingEntityFullyQualifiedClassname();
    verify(persistencePackage, atLeast(1)).getCustomCriteria();
    verify(persistencePackage).getPersistencePerspective();
    verify(persistencePackage).getSectionCrumbs();
    verify(helper).getFilterMappings(isA(PersistencePerspective.class), isA(CriteriaTransferObject.class),
        eq("Dr Jane Doe"), isA(Map.class));
    verify(helper).getPersistentRecords(eq("Dr Jane Doe"), isA(List.class), isNull(), isNull());
    verify(helper).getRecords(isA(Map.class), isA(List.class));
    verify(helper).getSimpleMergedProperties(eq("org.broadleafcommerce.core.catalog.domain.Sku"),
        isA(PersistencePerspective.class));
    verify(helper).getTotalRecords(eq("Dr Jane Doe"), isA(List.class));
    Map<String, FilterAndSortCriteria> criteriaMap = cto.getCriteriaMap();
    assertEquals(1, criteriaMap.size());
    FilterAndSortCriteria getResult = criteriaMap.get("consolidatedProductOptions");
    assertEquals("consolidatedProductOptions", getResult.getPropertyId());
    assertNull(actualFetchResult.getPromptSearch());
    assertNull(actualFetchResult.getTotalCountLessThanPageSize());
    assertNull(getResult.getSortAscending());
    assertNull(actualFetchResult.getBatchId());
    assertNull(actualFetchResult.getLowerCount());
    assertNull(actualFetchResult.getUpperCount());
    assertNull(getResult.getOrder());
    assertNull(actualFetchResult.getFirstId());
    assertNull(actualFetchResult.getLastId());
    assertNull(actualFetchResult.getClassMetaData());
    assertNull(getResult.getSortDirection());
    assertNull(getResult.getRestrictionType());
    assertNull(actualFetchResult.getFetchType());
    assertEquals(0, actualFetchResult.getPageSize().intValue());
    assertEquals(0, actualFetchResult.getStartIndex().intValue());
    assertEquals(1, actualFetchResult.getTotalRecords().intValue());
    Entity[] records = actualFetchResult.getRecords();
    assertEquals(1, records.length);
    assertTrue(getResult.getFilterValues().isEmpty());
    assertTrue(getResult.getSpecialFilterValues().isEmpty());
    assertTrue(dynamicEntityDao.getFieldMetadataProviders().isEmpty());
    assertTrue(actualFetchResult.getUnselectedTabMetadata().isEmpty());
    assertTrue(getResult.isNullsLast());
    assertSame(entity, records[0]);
  }

  /**
   * Method under test:
   * {@link SkuCustomPersistenceHandler#fetch(PersistencePackage, CriteriaTransferObject, DynamicEntityDao, RecordHelper)}
   */
  @Test
  public void testFetch2() throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuCustomPersistenceHandler skuCustomPersistenceHandler = new SkuCustomPersistenceHandler();

    SectionCrumb sectionCrumb = new SectionCrumb();
    sectionCrumb.setOriginalSectionIdentifier("42");
    sectionCrumb.setSectionId("42");
    sectionCrumb.setSectionIdentifier("42");
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.containsCriteria(Mockito.<String>any())).thenReturn(false);
    when(persistencePackage.getCustomCriteria()).thenReturn(new String[]{"Custom Criteria"});
    when(persistencePackage.getSectionCrumbs()).thenReturn(new SectionCrumb[]{sectionCrumb});
    when(persistencePackage.getCeilingEntityFullyQualifiedClassname()).thenReturn("Dr Jane Doe");
    when(persistencePackage.getPersistencePerspective()).thenReturn(new PersistencePerspective());
    CriteriaTransferObject cto = new CriteriaTransferObject();
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();
    RecordHelper helper = mock(RecordHelper.class);
    when(helper.getTotalRecords(Mockito.<String>any(), Mockito.<List<FilterMapping>>any())).thenReturn(1);
    when(helper.getFilterMappings(Mockito.<PersistencePerspective>any(), Mockito.<CriteriaTransferObject>any(),
        Mockito.<String>any(), Mockito.<Map<String, FieldMetadata>>any())).thenReturn(new ArrayList<>());
    when(helper.getPersistentRecords(Mockito.<String>any(), Mockito.<List<FilterMapping>>any(), Mockito.<Integer>any(),
        Mockito.<Integer>any())).thenReturn(new ArrayList<>());
    when(helper.getSimpleMergedProperties(Mockito.<String>any(), Mockito.<PersistencePerspective>any()))
        .thenReturn(new HashMap<>());
    Entity entity = new Entity();
    when(helper.getRecords(Mockito.<Map<String, FieldMetadata>>any(), Mockito.<List<Serializable>>any()))
        .thenReturn(new Entity[]{entity});

    // Act
    DynamicResultSet actualFetchResult = skuCustomPersistenceHandler.fetch(persistencePackage, cto, dynamicEntityDao,
        helper);

    // Assert
    verify(persistencePackage)
        .containsCriteria(eq("owningClass=com.broadleafcommerce.inventory.advanced.domain.InventoryImpl"));
    verify(persistencePackage, atLeast(1)).getCeilingEntityFullyQualifiedClassname();
    verify(persistencePackage, atLeast(1)).getCustomCriteria();
    verify(persistencePackage).getPersistencePerspective();
    verify(persistencePackage).getSectionCrumbs();
    verify(helper).getFilterMappings(isA(PersistencePerspective.class), isA(CriteriaTransferObject.class),
        eq("Dr Jane Doe"), isA(Map.class));
    verify(helper).getPersistentRecords(eq("Dr Jane Doe"), isA(List.class), isNull(), isNull());
    verify(helper).getRecords(isA(Map.class), isA(List.class));
    verify(helper).getSimpleMergedProperties(eq("org.broadleafcommerce.core.catalog.domain.Sku"),
        isA(PersistencePerspective.class));
    verify(helper).getTotalRecords(eq("Dr Jane Doe"), isA(List.class));
    Map<String, FilterAndSortCriteria> criteriaMap = cto.getCriteriaMap();
    assertEquals(1, criteriaMap.size());
    FilterAndSortCriteria getResult = criteriaMap.get("consolidatedProductOptions");
    assertEquals("consolidatedProductOptions", getResult.getPropertyId());
    assertNull(actualFetchResult.getPromptSearch());
    assertNull(actualFetchResult.getTotalCountLessThanPageSize());
    assertNull(getResult.getSortAscending());
    assertNull(actualFetchResult.getBatchId());
    assertNull(actualFetchResult.getLowerCount());
    assertNull(actualFetchResult.getUpperCount());
    assertNull(getResult.getOrder());
    assertNull(actualFetchResult.getFirstId());
    assertNull(actualFetchResult.getLastId());
    assertNull(actualFetchResult.getClassMetaData());
    assertNull(getResult.getSortDirection());
    assertNull(getResult.getRestrictionType());
    assertNull(actualFetchResult.getFetchType());
    assertEquals(0, actualFetchResult.getPageSize().intValue());
    assertEquals(0, actualFetchResult.getStartIndex().intValue());
    assertEquals(1, actualFetchResult.getTotalRecords().intValue());
    Entity[] records = actualFetchResult.getRecords();
    assertEquals(1, records.length);
    assertTrue(getResult.getFilterValues().isEmpty());
    assertTrue(getResult.getSpecialFilterValues().isEmpty());
    assertTrue(dynamicEntityDao.getFieldMetadataProviders().isEmpty());
    assertTrue(actualFetchResult.getUnselectedTabMetadata().isEmpty());
    assertTrue(getResult.isNullsLast());
    assertSame(entity, records[0]);
  }

  /**
   * Method under test:
   * {@link SkuCustomPersistenceHandler#fetch(PersistencePackage, CriteriaTransferObject, DynamicEntityDao, RecordHelper)}
   */
  @Test
  public void testFetch3() throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuCustomPersistenceHandler skuCustomPersistenceHandler = new SkuCustomPersistenceHandler();

    SectionCrumb sectionCrumb = new SectionCrumb();
    sectionCrumb.setOriginalSectionIdentifier("42");
    sectionCrumb.setSectionId("42");
    sectionCrumb.setSectionIdentifier("42");
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.containsCriteria(Mockito.<String>any())).thenReturn(true);
    when(persistencePackage.getCustomCriteria())
        .thenReturn(new String[]{"owningClass=org.broadleafcommerce.core.catalog.domain.SkuBundleItemImpl"});
    when(persistencePackage.getSectionCrumbs()).thenReturn(new SectionCrumb[]{sectionCrumb});
    when(persistencePackage.getCeilingEntityFullyQualifiedClassname()).thenReturn("Dr Jane Doe");
    when(persistencePackage.getPersistencePerspective()).thenReturn(new PersistencePerspective());
    CriteriaTransferObject cto = new CriteriaTransferObject();
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();
    RecordHelper helper = mock(RecordHelper.class);
    when(helper.getTotalRecords(Mockito.<String>any(), Mockito.<List<FilterMapping>>any())).thenReturn(1);
    when(helper.getFilterMappings(Mockito.<PersistencePerspective>any(), Mockito.<CriteriaTransferObject>any(),
        Mockito.<String>any(), Mockito.<Map<String, FieldMetadata>>any())).thenReturn(new ArrayList<>());
    when(helper.getPersistentRecords(Mockito.<String>any(), Mockito.<List<FilterMapping>>any(), Mockito.<Integer>any(),
        Mockito.<Integer>any())).thenReturn(new ArrayList<>());
    when(helper.getSimpleMergedProperties(Mockito.<String>any(), Mockito.<PersistencePerspective>any()))
        .thenReturn(new HashMap<>());
    Entity entity = new Entity();
    when(helper.getRecords(Mockito.<Map<String, FieldMetadata>>any(), Mockito.<List<Serializable>>any()))
        .thenReturn(new Entity[]{entity});

    // Act
    DynamicResultSet actualFetchResult = skuCustomPersistenceHandler.fetch(persistencePackage, cto, dynamicEntityDao,
        helper);

    // Assert
    verify(persistencePackage, atLeast(1)).containsCriteria(Mockito.<String>any());
    verify(persistencePackage, atLeast(1)).getCeilingEntityFullyQualifiedClassname();
    verify(persistencePackage, atLeast(1)).getCustomCriteria();
    verify(persistencePackage).getPersistencePerspective();
    verify(persistencePackage).getSectionCrumbs();
    verify(helper).getFilterMappings(isA(PersistencePerspective.class), isA(CriteriaTransferObject.class),
        eq("Dr Jane Doe"), isA(Map.class));
    verify(helper).getPersistentRecords(eq("Dr Jane Doe"), isA(List.class), isNull(), isNull());
    verify(helper).getRecords(isA(Map.class), isA(List.class));
    verify(helper).getSimpleMergedProperties(eq("org.broadleafcommerce.core.catalog.domain.Sku"),
        isA(PersistencePerspective.class));
    verify(helper).getTotalRecords(eq("Dr Jane Doe"), isA(List.class));
    Map<String, FilterAndSortCriteria> criteriaMap = cto.getCriteriaMap();
    assertEquals(1, criteriaMap.size());
    FilterAndSortCriteria getResult = criteriaMap.get("consolidatedProductOptions");
    assertEquals("consolidatedProductOptions", getResult.getPropertyId());
    assertNull(actualFetchResult.getPromptSearch());
    assertNull(actualFetchResult.getTotalCountLessThanPageSize());
    assertNull(getResult.getSortAscending());
    assertNull(actualFetchResult.getBatchId());
    assertNull(actualFetchResult.getLowerCount());
    assertNull(actualFetchResult.getUpperCount());
    assertNull(getResult.getOrder());
    assertNull(actualFetchResult.getFirstId());
    assertNull(actualFetchResult.getLastId());
    assertNull(actualFetchResult.getClassMetaData());
    assertNull(getResult.getSortDirection());
    assertNull(getResult.getRestrictionType());
    assertNull(actualFetchResult.getFetchType());
    assertEquals(0, actualFetchResult.getPageSize().intValue());
    assertEquals(0, actualFetchResult.getStartIndex().intValue());
    assertEquals(1, actualFetchResult.getTotalRecords().intValue());
    Entity[] records = actualFetchResult.getRecords();
    assertEquals(1, records.length);
    assertTrue(getResult.getFilterValues().isEmpty());
    assertTrue(getResult.getSpecialFilterValues().isEmpty());
    assertTrue(dynamicEntityDao.getFieldMetadataProviders().isEmpty());
    assertTrue(actualFetchResult.getUnselectedTabMetadata().isEmpty());
    assertTrue(getResult.isNullsLast());
    assertSame(entity, records[0]);
  }

  /**
   * Method under test:
   * {@link SkuCustomPersistenceHandler#fetch(PersistencePackage, CriteriaTransferObject, DynamicEntityDao, RecordHelper)}
   */
  @Test
  public void testFetch4() throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuCustomPersistenceHandler skuCustomPersistenceHandler = new SkuCustomPersistenceHandler();

    SectionCrumb sectionCrumb = new SectionCrumb();
    sectionCrumb.setOriginalSectionIdentifier("42");
    sectionCrumb.setSectionId("42");
    sectionCrumb.setSectionIdentifier("42");
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.containsCriteria(Mockito.<String>any())).thenReturn(true);
    when(persistencePackage.getCustomCriteria()).thenReturn(new String[]{"requestingField=sku"});
    when(persistencePackage.getSectionCrumbs()).thenReturn(new SectionCrumb[]{sectionCrumb});
    when(persistencePackage.getCeilingEntityFullyQualifiedClassname()).thenReturn("Dr Jane Doe");
    when(persistencePackage.getPersistencePerspective()).thenReturn(new PersistencePerspective());
    CriteriaTransferObject cto = new CriteriaTransferObject();
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();
    RecordHelper helper = mock(RecordHelper.class);
    when(helper.getTotalRecords(Mockito.<String>any(), Mockito.<List<FilterMapping>>any())).thenReturn(1);
    when(helper.getFilterMappings(Mockito.<PersistencePerspective>any(), Mockito.<CriteriaTransferObject>any(),
        Mockito.<String>any(), Mockito.<Map<String, FieldMetadata>>any())).thenReturn(new ArrayList<>());
    when(helper.getPersistentRecords(Mockito.<String>any(), Mockito.<List<FilterMapping>>any(), Mockito.<Integer>any(),
        Mockito.<Integer>any())).thenReturn(new ArrayList<>());
    when(helper.getSimpleMergedProperties(Mockito.<String>any(), Mockito.<PersistencePerspective>any()))
        .thenReturn(new HashMap<>());
    Entity entity = new Entity();
    when(helper.getRecords(Mockito.<Map<String, FieldMetadata>>any(), Mockito.<List<Serializable>>any()))
        .thenReturn(new Entity[]{entity});

    // Act
    DynamicResultSet actualFetchResult = skuCustomPersistenceHandler.fetch(persistencePackage, cto, dynamicEntityDao,
        helper);

    // Assert
    verify(persistencePackage, atLeast(1)).containsCriteria(Mockito.<String>any());
    verify(persistencePackage, atLeast(1)).getCeilingEntityFullyQualifiedClassname();
    verify(persistencePackage, atLeast(1)).getCustomCriteria();
    verify(persistencePackage).getPersistencePerspective();
    verify(persistencePackage).getSectionCrumbs();
    verify(helper).getFilterMappings(isA(PersistencePerspective.class), isA(CriteriaTransferObject.class),
        eq("Dr Jane Doe"), isA(Map.class));
    verify(helper).getPersistentRecords(eq("Dr Jane Doe"), isA(List.class), isNull(), isNull());
    verify(helper).getRecords(isA(Map.class), isA(List.class));
    verify(helper).getSimpleMergedProperties(eq("org.broadleafcommerce.core.catalog.domain.Sku"),
        isA(PersistencePerspective.class));
    verify(helper).getTotalRecords(eq("Dr Jane Doe"), isA(List.class));
    Map<String, FilterAndSortCriteria> criteriaMap = cto.getCriteriaMap();
    assertEquals(1, criteriaMap.size());
    FilterAndSortCriteria getResult = criteriaMap.get("consolidatedProductOptions");
    assertEquals("consolidatedProductOptions", getResult.getPropertyId());
    assertNull(actualFetchResult.getPromptSearch());
    assertNull(actualFetchResult.getTotalCountLessThanPageSize());
    assertNull(getResult.getSortAscending());
    assertNull(actualFetchResult.getBatchId());
    assertNull(actualFetchResult.getLowerCount());
    assertNull(actualFetchResult.getUpperCount());
    assertNull(getResult.getOrder());
    assertNull(actualFetchResult.getFirstId());
    assertNull(actualFetchResult.getLastId());
    assertNull(actualFetchResult.getClassMetaData());
    assertNull(getResult.getSortDirection());
    assertNull(getResult.getRestrictionType());
    assertNull(actualFetchResult.getFetchType());
    assertEquals(0, actualFetchResult.getPageSize().intValue());
    assertEquals(0, actualFetchResult.getStartIndex().intValue());
    assertEquals(1, actualFetchResult.getTotalRecords().intValue());
    Entity[] records = actualFetchResult.getRecords();
    assertEquals(1, records.length);
    assertTrue(getResult.getFilterValues().isEmpty());
    assertTrue(getResult.getSpecialFilterValues().isEmpty());
    assertTrue(dynamicEntityDao.getFieldMetadataProviders().isEmpty());
    assertTrue(actualFetchResult.getUnselectedTabMetadata().isEmpty());
    assertTrue(getResult.isNullsLast());
    assertSame(entity, records[0]);
  }

  /**
   * Method under test:
   * {@link SkuCustomPersistenceHandler#fetch(PersistencePackage, CriteriaTransferObject, DynamicEntityDao, RecordHelper)}
   */
  @Test
  public void testFetch5() throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuCustomPersistenceHandler skuCustomPersistenceHandler = new SkuCustomPersistenceHandler();

    SectionCrumb sectionCrumb = new SectionCrumb();
    sectionCrumb.setOriginalSectionIdentifier("42");
    sectionCrumb.setSectionId("42");
    sectionCrumb.setSectionIdentifier("42");
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.containsCriteria(Mockito.<String>any())).thenReturn(true);
    when(persistencePackage.getCustomCriteria()).thenReturn(null);
    when(persistencePackage.getSectionCrumbs()).thenReturn(new SectionCrumb[]{sectionCrumb});
    when(persistencePackage.getCeilingEntityFullyQualifiedClassname()).thenReturn("Dr Jane Doe");
    when(persistencePackage.getPersistencePerspective()).thenReturn(new PersistencePerspective());
    CriteriaTransferObject cto = new CriteriaTransferObject();
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();
    RecordHelper helper = mock(RecordHelper.class);
    when(helper.getTotalRecords(Mockito.<String>any(), Mockito.<List<FilterMapping>>any())).thenReturn(1);
    when(helper.getFilterMappings(Mockito.<PersistencePerspective>any(), Mockito.<CriteriaTransferObject>any(),
        Mockito.<String>any(), Mockito.<Map<String, FieldMetadata>>any())).thenReturn(new ArrayList<>());
    when(helper.getPersistentRecords(Mockito.<String>any(), Mockito.<List<FilterMapping>>any(), Mockito.<Integer>any(),
        Mockito.<Integer>any())).thenReturn(new ArrayList<>());
    when(helper.getSimpleMergedProperties(Mockito.<String>any(), Mockito.<PersistencePerspective>any()))
        .thenReturn(new HashMap<>());
    Entity entity = new Entity();
    when(helper.getRecords(Mockito.<Map<String, FieldMetadata>>any(), Mockito.<List<Serializable>>any()))
        .thenReturn(new Entity[]{entity});

    // Act
    DynamicResultSet actualFetchResult = skuCustomPersistenceHandler.fetch(persistencePackage, cto, dynamicEntityDao,
        helper);

    // Assert
    verify(persistencePackage, atLeast(1)).containsCriteria(Mockito.<String>any());
    verify(persistencePackage, atLeast(1)).getCeilingEntityFullyQualifiedClassname();
    verify(persistencePackage).getCustomCriteria();
    verify(persistencePackage).getPersistencePerspective();
    verify(persistencePackage).getSectionCrumbs();
    verify(helper).getFilterMappings(isA(PersistencePerspective.class), isA(CriteriaTransferObject.class),
        eq("Dr Jane Doe"), isA(Map.class));
    verify(helper).getPersistentRecords(eq("Dr Jane Doe"), isA(List.class), isNull(), isNull());
    verify(helper).getRecords(isA(Map.class), isA(List.class));
    verify(helper).getSimpleMergedProperties(eq("org.broadleafcommerce.core.catalog.domain.Sku"),
        isA(PersistencePerspective.class));
    verify(helper).getTotalRecords(eq("Dr Jane Doe"), isA(List.class));
    Map<String, FilterAndSortCriteria> criteriaMap = cto.getCriteriaMap();
    assertEquals(1, criteriaMap.size());
    FilterAndSortCriteria getResult = criteriaMap.get("consolidatedProductOptions");
    assertEquals("consolidatedProductOptions", getResult.getPropertyId());
    assertNull(actualFetchResult.getPromptSearch());
    assertNull(actualFetchResult.getTotalCountLessThanPageSize());
    assertNull(getResult.getSortAscending());
    assertNull(actualFetchResult.getBatchId());
    assertNull(actualFetchResult.getLowerCount());
    assertNull(actualFetchResult.getUpperCount());
    assertNull(getResult.getOrder());
    assertNull(actualFetchResult.getFirstId());
    assertNull(actualFetchResult.getLastId());
    assertNull(actualFetchResult.getClassMetaData());
    assertNull(getResult.getSortDirection());
    assertNull(getResult.getRestrictionType());
    assertNull(actualFetchResult.getFetchType());
    assertEquals(0, actualFetchResult.getPageSize().intValue());
    assertEquals(0, actualFetchResult.getStartIndex().intValue());
    assertEquals(1, actualFetchResult.getTotalRecords().intValue());
    Entity[] records = actualFetchResult.getRecords();
    assertEquals(1, records.length);
    assertTrue(getResult.getFilterValues().isEmpty());
    assertTrue(getResult.getSpecialFilterValues().isEmpty());
    assertTrue(dynamicEntityDao.getFieldMetadataProviders().isEmpty());
    assertTrue(actualFetchResult.getUnselectedTabMetadata().isEmpty());
    assertTrue(getResult.isNullsLast());
    assertSame(entity, records[0]);
  }

  /**
   * Method under test:
   * {@link SkuCustomPersistenceHandler#fetch(PersistencePackage, CriteriaTransferObject, DynamicEntityDao, RecordHelper)}
   */
  @Test
  public void testFetch6() throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuCustomPersistenceHandler skuCustomPersistenceHandler = new SkuCustomPersistenceHandler();
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.containsCriteria(Mockito.<String>any())).thenReturn(true);
    when(persistencePackage.getCustomCriteria()).thenReturn(new String[]{"Custom Criteria"});
    when(persistencePackage.getSectionCrumbs()).thenReturn(null);
    when(persistencePackage.getCeilingEntityFullyQualifiedClassname()).thenReturn("Dr Jane Doe");
    when(persistencePackage.getPersistencePerspective()).thenReturn(new PersistencePerspective());
    CriteriaTransferObject cto = new CriteriaTransferObject();
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();
    RecordHelper helper = mock(RecordHelper.class);
    when(helper.getTotalRecords(Mockito.<String>any(), Mockito.<List<FilterMapping>>any())).thenReturn(1);
    when(helper.getFilterMappings(Mockito.<PersistencePerspective>any(), Mockito.<CriteriaTransferObject>any(),
        Mockito.<String>any(), Mockito.<Map<String, FieldMetadata>>any())).thenReturn(new ArrayList<>());
    when(helper.getPersistentRecords(Mockito.<String>any(), Mockito.<List<FilterMapping>>any(), Mockito.<Integer>any(),
        Mockito.<Integer>any())).thenReturn(new ArrayList<>());
    when(helper.getSimpleMergedProperties(Mockito.<String>any(), Mockito.<PersistencePerspective>any()))
        .thenReturn(new HashMap<>());
    Entity entity = new Entity();
    when(helper.getRecords(Mockito.<Map<String, FieldMetadata>>any(), Mockito.<List<Serializable>>any()))
        .thenReturn(new Entity[]{entity});

    // Act
    DynamicResultSet actualFetchResult = skuCustomPersistenceHandler.fetch(persistencePackage, cto, dynamicEntityDao,
        helper);

    // Assert
    verify(persistencePackage, atLeast(1)).containsCriteria(Mockito.<String>any());
    verify(persistencePackage, atLeast(1)).getCeilingEntityFullyQualifiedClassname();
    verify(persistencePackage).getCustomCriteria();
    verify(persistencePackage).getPersistencePerspective();
    verify(persistencePackage).getSectionCrumbs();
    verify(helper).getFilterMappings(isA(PersistencePerspective.class), isA(CriteriaTransferObject.class),
        eq("Dr Jane Doe"), isA(Map.class));
    verify(helper).getPersistentRecords(eq("Dr Jane Doe"), isA(List.class), isNull(), isNull());
    verify(helper).getRecords(isA(Map.class), isA(List.class));
    verify(helper).getSimpleMergedProperties(eq("org.broadleafcommerce.core.catalog.domain.Sku"),
        isA(PersistencePerspective.class));
    verify(helper).getTotalRecords(eq("Dr Jane Doe"), isA(List.class));
    Map<String, FilterAndSortCriteria> criteriaMap = cto.getCriteriaMap();
    assertEquals(1, criteriaMap.size());
    FilterAndSortCriteria getResult = criteriaMap.get("consolidatedProductOptions");
    assertEquals("consolidatedProductOptions", getResult.getPropertyId());
    assertNull(actualFetchResult.getPromptSearch());
    assertNull(actualFetchResult.getTotalCountLessThanPageSize());
    assertNull(getResult.getSortAscending());
    assertNull(actualFetchResult.getBatchId());
    assertNull(actualFetchResult.getLowerCount());
    assertNull(actualFetchResult.getUpperCount());
    assertNull(getResult.getOrder());
    assertNull(actualFetchResult.getFirstId());
    assertNull(actualFetchResult.getLastId());
    assertNull(actualFetchResult.getClassMetaData());
    assertNull(getResult.getSortDirection());
    assertNull(getResult.getRestrictionType());
    assertNull(actualFetchResult.getFetchType());
    assertEquals(0, actualFetchResult.getPageSize().intValue());
    assertEquals(0, actualFetchResult.getStartIndex().intValue());
    assertEquals(1, actualFetchResult.getTotalRecords().intValue());
    Entity[] records = actualFetchResult.getRecords();
    assertEquals(1, records.length);
    assertTrue(getResult.getFilterValues().isEmpty());
    assertTrue(getResult.getSpecialFilterValues().isEmpty());
    assertTrue(dynamicEntityDao.getFieldMetadataProviders().isEmpty());
    assertTrue(actualFetchResult.getUnselectedTabMetadata().isEmpty());
    assertTrue(getResult.isNullsLast());
    assertSame(entity, records[0]);
  }

  /**
   * Method under test:
   * {@link SkuCustomPersistenceHandler#fetch(PersistencePackage, CriteriaTransferObject, DynamicEntityDao, RecordHelper)}
   */
  @Test
  public void testFetch7() throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuCustomPersistenceHandler skuCustomPersistenceHandler = new SkuCustomPersistenceHandler();

    SectionCrumb sectionCrumb = new SectionCrumb();
    sectionCrumb.setOriginalSectionIdentifier("42");
    sectionCrumb.setSectionId("42");
    sectionCrumb.setSectionIdentifier("42");
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.containsCriteria(Mockito.<String>any())).thenReturn(true);
    when(persistencePackage.getCustomCriteria()).thenReturn(new String[]{"Custom Criteria"});
    when(persistencePackage.getSectionCrumbs()).thenReturn(new SectionCrumb[]{sectionCrumb});
    when(persistencePackage.getCeilingEntityFullyQualifiedClassname()).thenReturn("Dr Jane Doe");
    when(persistencePackage.getPersistencePerspective()).thenReturn(new PersistencePerspective());

    CriteriaTransferObject cto = new CriteriaTransferObject();
    cto.add(new FilterAndSortCriteria("42"));
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();
    RecordHelper helper = mock(RecordHelper.class);
    when(helper.getTotalRecords(Mockito.<String>any(), Mockito.<List<FilterMapping>>any())).thenReturn(1);
    when(helper.getFilterMappings(Mockito.<PersistencePerspective>any(), Mockito.<CriteriaTransferObject>any(),
        Mockito.<String>any(), Mockito.<Map<String, FieldMetadata>>any())).thenReturn(new ArrayList<>());
    when(helper.getPersistentRecords(Mockito.<String>any(), Mockito.<List<FilterMapping>>any(), Mockito.<Integer>any(),
        Mockito.<Integer>any())).thenReturn(new ArrayList<>());
    when(helper.getSimpleMergedProperties(Mockito.<String>any(), Mockito.<PersistencePerspective>any()))
        .thenReturn(new HashMap<>());
    Entity entity = new Entity();
    when(helper.getRecords(Mockito.<Map<String, FieldMetadata>>any(), Mockito.<List<Serializable>>any()))
        .thenReturn(new Entity[]{entity});

    // Act
    DynamicResultSet actualFetchResult = skuCustomPersistenceHandler.fetch(persistencePackage, cto, dynamicEntityDao,
        helper);

    // Assert
    verify(persistencePackage, atLeast(1)).containsCriteria(Mockito.<String>any());
    verify(persistencePackage, atLeast(1)).getCeilingEntityFullyQualifiedClassname();
    verify(persistencePackage, atLeast(1)).getCustomCriteria();
    verify(persistencePackage).getPersistencePerspective();
    verify(persistencePackage).getSectionCrumbs();
    verify(helper).getFilterMappings(isA(PersistencePerspective.class), isA(CriteriaTransferObject.class),
        eq("Dr Jane Doe"), isA(Map.class));
    verify(helper).getPersistentRecords(eq("Dr Jane Doe"), isA(List.class), isNull(), isNull());
    verify(helper).getRecords(isA(Map.class), isA(List.class));
    verify(helper).getSimpleMergedProperties(eq("org.broadleafcommerce.core.catalog.domain.Sku"),
        isA(PersistencePerspective.class));
    verify(helper).getTotalRecords(eq("Dr Jane Doe"), isA(List.class));
    Map<String, FilterAndSortCriteria> criteriaMap = cto.getCriteriaMap();
    assertEquals(2, criteriaMap.size());
    FilterAndSortCriteria getResult = criteriaMap.get("consolidatedProductOptions");
    assertEquals("consolidatedProductOptions", getResult.getPropertyId());
    assertNull(actualFetchResult.getPromptSearch());
    assertNull(actualFetchResult.getTotalCountLessThanPageSize());
    assertNull(getResult.getSortAscending());
    assertNull(actualFetchResult.getBatchId());
    assertNull(actualFetchResult.getLowerCount());
    assertNull(actualFetchResult.getUpperCount());
    assertNull(getResult.getOrder());
    assertNull(actualFetchResult.getFirstId());
    assertNull(actualFetchResult.getLastId());
    assertNull(actualFetchResult.getClassMetaData());
    assertNull(getResult.getSortDirection());
    assertNull(getResult.getRestrictionType());
    assertNull(actualFetchResult.getFetchType());
    assertEquals(0, actualFetchResult.getPageSize().intValue());
    assertEquals(0, actualFetchResult.getStartIndex().intValue());
    assertEquals(1, actualFetchResult.getTotalRecords().intValue());
    Entity[] records = actualFetchResult.getRecords();
    assertEquals(1, records.length);
    assertTrue(getResult.getFilterValues().isEmpty());
    assertTrue(getResult.getSpecialFilterValues().isEmpty());
    assertTrue(dynamicEntityDao.getFieldMetadataProviders().isEmpty());
    assertTrue(criteriaMap.containsKey("42"));
    assertTrue(actualFetchResult.getUnselectedTabMetadata().isEmpty());
    assertTrue(getResult.isNullsLast());
    assertSame(entity, records[0]);
  }

  /**
   * Method under test:
   * {@link SkuCustomPersistenceHandler#fetch(PersistencePackage, CriteriaTransferObject, DynamicEntityDao, RecordHelper)}
   */
  @Test
  public void testFetch8() throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuCustomPersistenceHandler skuCustomPersistenceHandler = new SkuCustomPersistenceHandler();

    SectionCrumb sectionCrumb = new SectionCrumb();
    sectionCrumb.setOriginalSectionIdentifier("42");
    sectionCrumb.setSectionId("42");
    sectionCrumb.setSectionIdentifier("42");
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.containsCriteria(Mockito.<String>any())).thenReturn(true);
    when(persistencePackage.getCustomCriteria()).thenReturn(new String[]{"Custom Criteria"});
    when(persistencePackage.getSectionCrumbs()).thenReturn(new SectionCrumb[]{sectionCrumb});
    when(persistencePackage.getCeilingEntityFullyQualifiedClassname()).thenReturn("Dr Jane Doe");
    when(persistencePackage.getPersistencePerspective()).thenReturn(new PersistencePerspective());
    CriteriaTransferObject cto = mock(CriteriaTransferObject.class);
    when(cto.getFirstResult()).thenReturn(1);
    when(cto.getMaxResults()).thenReturn(3);
    when(cto.getCriteriaMap()).thenReturn(new HashMap<>());
    when(cto.get(Mockito.<String>any())).thenReturn(new FilterAndSortCriteria("42"));
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();
    RecordHelper helper = mock(RecordHelper.class);
    when(helper.getTotalRecords(Mockito.<String>any(), Mockito.<List<FilterMapping>>any())).thenReturn(1);
    when(helper.getFilterMappings(Mockito.<PersistencePerspective>any(), Mockito.<CriteriaTransferObject>any(),
        Mockito.<String>any(), Mockito.<Map<String, FieldMetadata>>any())).thenReturn(new ArrayList<>());
    when(helper.getPersistentRecords(Mockito.<String>any(), Mockito.<List<FilterMapping>>any(), Mockito.<Integer>any(),
        Mockito.<Integer>any())).thenReturn(new ArrayList<>());
    when(helper.getSimpleMergedProperties(Mockito.<String>any(), Mockito.<PersistencePerspective>any()))
        .thenReturn(new HashMap<>());
    Entity entity = new Entity();
    when(helper.getRecords(Mockito.<Map<String, FieldMetadata>>any(), Mockito.<List<Serializable>>any()))
        .thenReturn(new Entity[]{entity});

    // Act
    DynamicResultSet actualFetchResult = skuCustomPersistenceHandler.fetch(persistencePackage, cto, dynamicEntityDao,
        helper);

    // Assert
    verify(cto).get(eq("consolidatedProductOptions"));
    verify(cto).getCriteriaMap();
    verify(cto).getFirstResult();
    verify(cto).getMaxResults();
    verify(persistencePackage, atLeast(1)).containsCriteria(Mockito.<String>any());
    verify(persistencePackage, atLeast(1)).getCeilingEntityFullyQualifiedClassname();
    verify(persistencePackage, atLeast(1)).getCustomCriteria();
    verify(persistencePackage).getPersistencePerspective();
    verify(persistencePackage).getSectionCrumbs();
    verify(helper).getFilterMappings(isA(PersistencePerspective.class), isA(CriteriaTransferObject.class),
        eq("Dr Jane Doe"), isA(Map.class));
    verify(helper).getPersistentRecords(eq("Dr Jane Doe"), isA(List.class), eq(1), eq(3));
    verify(helper).getRecords(isA(Map.class), isA(List.class));
    verify(helper).getSimpleMergedProperties(eq("org.broadleafcommerce.core.catalog.domain.Sku"),
        isA(PersistencePerspective.class));
    verify(helper).getTotalRecords(eq("Dr Jane Doe"), isA(List.class));
    assertNull(actualFetchResult.getPromptSearch());
    assertNull(actualFetchResult.getTotalCountLessThanPageSize());
    assertNull(actualFetchResult.getBatchId());
    assertNull(actualFetchResult.getLowerCount());
    assertNull(actualFetchResult.getUpperCount());
    assertNull(actualFetchResult.getFirstId());
    assertNull(actualFetchResult.getLastId());
    assertNull(actualFetchResult.getClassMetaData());
    assertNull(actualFetchResult.getFetchType());
    assertEquals(0, actualFetchResult.getPageSize().intValue());
    assertEquals(0, actualFetchResult.getStartIndex().intValue());
    assertEquals(1, actualFetchResult.getTotalRecords().intValue());
    Entity[] records = actualFetchResult.getRecords();
    assertEquals(1, records.length);
    assertTrue(dynamicEntityDao.getFieldMetadataProviders().isEmpty());
    assertTrue(actualFetchResult.getUnselectedTabMetadata().isEmpty());
    assertSame(entity, records[0]);
  }

  /**
   * Method under test:
   * {@link SkuCustomPersistenceHandler#fetch(PersistencePackage, CriteriaTransferObject, DynamicEntityDao, RecordHelper)}
   */
  @Test
  public void testFetch9() throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuCustomPersistenceHandler skuCustomPersistenceHandler = new SkuCustomPersistenceHandler();

    SectionCrumb sectionCrumb = new SectionCrumb();
    sectionCrumb.setOriginalSectionIdentifier("42");
    sectionCrumb.setSectionId("42");
    sectionCrumb.setSectionIdentifier("42");
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.containsCriteria(Mockito.<String>any())).thenReturn(true);
    when(persistencePackage.getCustomCriteria()).thenReturn(new String[]{"Custom Criteria"});
    when(persistencePackage.getSectionCrumbs()).thenReturn(new SectionCrumb[]{sectionCrumb});
    when(persistencePackage.getCeilingEntityFullyQualifiedClassname()).thenReturn("Dr Jane Doe");
    when(persistencePackage.getPersistencePerspective()).thenReturn(new PersistencePerspective());
    CriteriaTransferObject cto = mock(CriteriaTransferObject.class);
    when(cto.getFirstResult()).thenThrow(
        new NumberFormatException("owningClass=org.broadleafcommerce.core.catalog.domain.SkuBundleItemImpl"));
    when(cto.getCriteriaMap()).thenReturn(new HashMap<>());
    when(cto.get(Mockito.<String>any())).thenReturn(new FilterAndSortCriteria("42"));
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();
    RecordHelper helper = mock(RecordHelper.class);
    when(helper.getFilterMappings(Mockito.<PersistencePerspective>any(), Mockito.<CriteriaTransferObject>any(),
        Mockito.<String>any(), Mockito.<Map<String, FieldMetadata>>any())).thenReturn(new ArrayList<>());
    when(helper.getSimpleMergedProperties(Mockito.<String>any(), Mockito.<PersistencePerspective>any()))
        .thenReturn(new HashMap<>());

    // Act and Assert
    assertThrows(ServiceException.class,
        () -> skuCustomPersistenceHandler.fetch(persistencePackage, cto, dynamicEntityDao, helper));
    verify(cto).get(eq("consolidatedProductOptions"));
    verify(cto).getCriteriaMap();
    verify(cto).getFirstResult();
    verify(persistencePackage, atLeast(1)).containsCriteria(Mockito.<String>any());
    verify(persistencePackage, atLeast(1)).getCeilingEntityFullyQualifiedClassname();
    verify(persistencePackage, atLeast(1)).getCustomCriteria();
    verify(persistencePackage).getPersistencePerspective();
    verify(persistencePackage).getSectionCrumbs();
    verify(helper).getFilterMappings(isA(PersistencePerspective.class), isA(CriteriaTransferObject.class),
        eq("Dr Jane Doe"), isA(Map.class));
    verify(helper).getSimpleMergedProperties(eq("org.broadleafcommerce.core.catalog.domain.Sku"),
        isA(PersistencePerspective.class));
  }

  /**
   * Method under test:
   * {@link SkuCustomPersistenceHandler#fetch(PersistencePackage, CriteriaTransferObject, DynamicEntityDao, RecordHelper)}
   */
  @Test
  public void testFetch10() throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuCustomPersistenceHandler skuCustomPersistenceHandler = new SkuCustomPersistenceHandler();

    SectionCrumb sectionCrumb = new SectionCrumb();
    sectionCrumb.setOriginalSectionIdentifier("42");
    sectionCrumb.setSectionId("42");
    sectionCrumb.setSectionIdentifier("42");
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.containsCriteria(Mockito.<String>any())).thenReturn(true);
    when(persistencePackage.getCustomCriteria()).thenReturn(new String[]{"Custom Criteria"});
    when(persistencePackage.getSectionCrumbs()).thenReturn(new SectionCrumb[]{sectionCrumb});
    when(persistencePackage.getCeilingEntityFullyQualifiedClassname()).thenReturn("Dr Jane Doe");
    when(persistencePackage.getPersistencePerspective()).thenReturn(new PersistencePerspective());
    CriteriaTransferObject cto = mock(CriteriaTransferObject.class);
    when(cto.getFirstResult()).thenReturn(1);
    when(cto.getMaxResults()).thenReturn(3);
    when(cto.getCriteriaMap()).thenReturn(new HashMap<>());
    when(cto.get(Mockito.<String>any())).thenReturn(new FilterAndSortCriteria("42", "42"));
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();
    RecordHelper helper = mock(RecordHelper.class);
    when(helper.getTotalRecords(Mockito.<String>any(), Mockito.<List<FilterMapping>>any())).thenReturn(1);
    when(helper.getFilterMappings(Mockito.<PersistencePerspective>any(), Mockito.<CriteriaTransferObject>any(),
        Mockito.<String>any(), Mockito.<Map<String, FieldMetadata>>any())).thenReturn(new ArrayList<>());
    when(helper.getPersistentRecords(Mockito.<String>any(), Mockito.<List<FilterMapping>>any(), Mockito.<Integer>any(),
        Mockito.<Integer>any())).thenReturn(new ArrayList<>());
    when(helper.getSimpleMergedProperties(Mockito.<String>any(), Mockito.<PersistencePerspective>any()))
        .thenReturn(new HashMap<>());
    Entity entity = new Entity();
    when(helper.getRecords(Mockito.<Map<String, FieldMetadata>>any(), Mockito.<List<Serializable>>any()))
        .thenReturn(new Entity[]{entity});

    // Act
    DynamicResultSet actualFetchResult = skuCustomPersistenceHandler.fetch(persistencePackage, cto, dynamicEntityDao,
        helper);

    // Assert
    verify(cto).get(eq("consolidatedProductOptions"));
    verify(cto).getCriteriaMap();
    verify(cto).getFirstResult();
    verify(cto).getMaxResults();
    verify(persistencePackage, atLeast(1)).containsCriteria(Mockito.<String>any());
    verify(persistencePackage, atLeast(1)).getCeilingEntityFullyQualifiedClassname();
    verify(persistencePackage, atLeast(1)).getCustomCriteria();
    verify(persistencePackage).getPersistencePerspective();
    verify(persistencePackage).getSectionCrumbs();
    verify(helper).getFilterMappings(isA(PersistencePerspective.class), isA(CriteriaTransferObject.class),
        eq("Dr Jane Doe"), isA(Map.class));
    verify(helper).getPersistentRecords(eq("Dr Jane Doe"), isA(List.class), eq(1), eq(3));
    verify(helper).getRecords(isA(Map.class), isA(List.class));
    verify(helper).getSimpleMergedProperties(eq("org.broadleafcommerce.core.catalog.domain.Sku"),
        isA(PersistencePerspective.class));
    verify(helper).getTotalRecords(eq("Dr Jane Doe"), isA(List.class));
    assertNull(actualFetchResult.getPromptSearch());
    assertNull(actualFetchResult.getTotalCountLessThanPageSize());
    assertNull(actualFetchResult.getBatchId());
    assertNull(actualFetchResult.getLowerCount());
    assertNull(actualFetchResult.getUpperCount());
    assertNull(actualFetchResult.getFirstId());
    assertNull(actualFetchResult.getLastId());
    assertNull(actualFetchResult.getClassMetaData());
    assertNull(actualFetchResult.getFetchType());
    assertEquals(0, actualFetchResult.getPageSize().intValue());
    assertEquals(0, actualFetchResult.getStartIndex().intValue());
    assertEquals(1, actualFetchResult.getTotalRecords().intValue());
    Entity[] records = actualFetchResult.getRecords();
    assertEquals(1, records.length);
    assertTrue(dynamicEntityDao.getFieldMetadataProviders().isEmpty());
    assertTrue(actualFetchResult.getUnselectedTabMetadata().isEmpty());
    assertSame(entity, records[0]);
  }

  /**
   * Method under test:
   * {@link SkuCustomPersistenceHandler#fetch(PersistencePackage, CriteriaTransferObject, DynamicEntityDao, RecordHelper)}
   */
  @Test
  public void testFetch11() throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuCustomPersistenceHandler skuCustomPersistenceHandler = new SkuCustomPersistenceHandler();

    SectionCrumb sectionCrumb = new SectionCrumb();
    sectionCrumb.setOriginalSectionIdentifier("42");
    sectionCrumb.setSectionId("42");
    sectionCrumb.setSectionIdentifier("42");
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.containsCriteria(Mockito.<String>any())).thenReturn(true);
    when(persistencePackage.getCustomCriteria()).thenReturn(new String[]{"Custom Criteria"});
    when(persistencePackage.getSectionCrumbs()).thenReturn(new SectionCrumb[]{sectionCrumb});
    when(persistencePackage.getCeilingEntityFullyQualifiedClassname()).thenReturn("Dr Jane Doe");
    when(persistencePackage.getPersistencePerspective()).thenReturn(new PersistencePerspective());
    FilterAndSortCriteria filterAndSortCriteria = mock(FilterAndSortCriteria.class);
    when(filterAndSortCriteria.getFilterValues()).thenReturn(new ArrayList<>());
    CriteriaTransferObject cto = mock(CriteriaTransferObject.class);
    when(cto.getFirstResult()).thenReturn(1);
    when(cto.getMaxResults()).thenReturn(3);
    when(cto.getCriteriaMap()).thenReturn(new HashMap<>());
    when(cto.get(Mockito.<String>any())).thenReturn(filterAndSortCriteria);
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();
    RecordHelper helper = mock(RecordHelper.class);
    when(helper.getTotalRecords(Mockito.<String>any(), Mockito.<List<FilterMapping>>any())).thenReturn(1);
    when(helper.getFilterMappings(Mockito.<PersistencePerspective>any(), Mockito.<CriteriaTransferObject>any(),
        Mockito.<String>any(), Mockito.<Map<String, FieldMetadata>>any())).thenReturn(new ArrayList<>());
    when(helper.getPersistentRecords(Mockito.<String>any(), Mockito.<List<FilterMapping>>any(), Mockito.<Integer>any(),
        Mockito.<Integer>any())).thenReturn(new ArrayList<>());
    when(helper.getSimpleMergedProperties(Mockito.<String>any(), Mockito.<PersistencePerspective>any()))
        .thenReturn(new HashMap<>());
    Entity entity = new Entity();
    when(helper.getRecords(Mockito.<Map<String, FieldMetadata>>any(), Mockito.<List<Serializable>>any()))
        .thenReturn(new Entity[]{entity});

    // Act
    DynamicResultSet actualFetchResult = skuCustomPersistenceHandler.fetch(persistencePackage, cto, dynamicEntityDao,
        helper);

    // Assert
    verify(cto).get(eq("consolidatedProductOptions"));
    verify(cto).getCriteriaMap();
    verify(cto).getFirstResult();
    verify(cto).getMaxResults();
    verify(filterAndSortCriteria).getFilterValues();
    verify(persistencePackage, atLeast(1)).containsCriteria(Mockito.<String>any());
    verify(persistencePackage, atLeast(1)).getCeilingEntityFullyQualifiedClassname();
    verify(persistencePackage, atLeast(1)).getCustomCriteria();
    verify(persistencePackage).getPersistencePerspective();
    verify(persistencePackage).getSectionCrumbs();
    verify(helper).getFilterMappings(isA(PersistencePerspective.class), isA(CriteriaTransferObject.class),
        eq("Dr Jane Doe"), isA(Map.class));
    verify(helper).getPersistentRecords(eq("Dr Jane Doe"), isA(List.class), eq(1), eq(3));
    verify(helper).getRecords(isA(Map.class), isA(List.class));
    verify(helper).getSimpleMergedProperties(eq("org.broadleafcommerce.core.catalog.domain.Sku"),
        isA(PersistencePerspective.class));
    verify(helper).getTotalRecords(eq("Dr Jane Doe"), isA(List.class));
    assertNull(actualFetchResult.getPromptSearch());
    assertNull(actualFetchResult.getTotalCountLessThanPageSize());
    assertNull(actualFetchResult.getBatchId());
    assertNull(actualFetchResult.getLowerCount());
    assertNull(actualFetchResult.getUpperCount());
    assertNull(actualFetchResult.getFirstId());
    assertNull(actualFetchResult.getLastId());
    assertNull(actualFetchResult.getClassMetaData());
    assertNull(actualFetchResult.getFetchType());
    assertEquals(0, actualFetchResult.getPageSize().intValue());
    assertEquals(0, actualFetchResult.getStartIndex().intValue());
    assertEquals(1, actualFetchResult.getTotalRecords().intValue());
    Entity[] records = actualFetchResult.getRecords();
    assertEquals(1, records.length);
    assertTrue(dynamicEntityDao.getFieldMetadataProviders().isEmpty());
    assertTrue(actualFetchResult.getUnselectedTabMetadata().isEmpty());
    assertSame(entity, records[0]);
  }

  /**
   * Method under test:
   * {@link SkuCustomPersistenceHandler#fetch(PersistencePackage, CriteriaTransferObject, DynamicEntityDao, RecordHelper)}
   */
  @Test
  public void testFetch12() throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuCustomPersistenceHandler skuCustomPersistenceHandler = new SkuCustomPersistenceHandler();

    SectionCrumb sectionCrumb = new SectionCrumb();
    sectionCrumb.setOriginalSectionIdentifier("42");
    sectionCrumb.setSectionId("42");
    sectionCrumb.setSectionIdentifier("42");
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.containsCriteria(Mockito.<String>any())).thenReturn(true);
    when(persistencePackage.getCustomCriteria()).thenReturn(new String[]{"Custom Criteria"});
    when(persistencePackage.getSectionCrumbs()).thenReturn(new SectionCrumb[]{sectionCrumb});
    when(persistencePackage.getCeilingEntityFullyQualifiedClassname()).thenReturn("Dr Jane Doe");
    when(persistencePackage.getPersistencePerspective()).thenReturn(new PersistencePerspective());

    ArrayList<String> stringList = new ArrayList<>();
    stringList.add("owningClass=org.broadleafcommerce.core.catalog.domain.SkuBundleItemImpl");
    FilterAndSortCriteria filterAndSortCriteria = mock(FilterAndSortCriteria.class);
    when(filterAndSortCriteria.getFilterValues()).thenReturn(stringList);
    CriteriaTransferObject cto = mock(CriteriaTransferObject.class);
    when(cto.getFirstResult()).thenReturn(1);
    when(cto.getMaxResults()).thenReturn(3);
    when(cto.getCriteriaMap()).thenReturn(new HashMap<>());
    when(cto.get(Mockito.<String>any())).thenReturn(filterAndSortCriteria);
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();
    RecordHelper helper = mock(RecordHelper.class);
    when(helper.getTotalRecords(Mockito.<String>any(), Mockito.<List<FilterMapping>>any())).thenReturn(1);
    when(helper.getFilterMappings(Mockito.<PersistencePerspective>any(), Mockito.<CriteriaTransferObject>any(),
        Mockito.<String>any(), Mockito.<Map<String, FieldMetadata>>any())).thenReturn(new ArrayList<>());
    when(helper.getPersistentRecords(Mockito.<String>any(), Mockito.<List<FilterMapping>>any(), Mockito.<Integer>any(),
        Mockito.<Integer>any())).thenReturn(new ArrayList<>());
    when(helper.getSimpleMergedProperties(Mockito.<String>any(), Mockito.<PersistencePerspective>any()))
        .thenReturn(new HashMap<>());
    Entity entity = new Entity();
    when(helper.getRecords(Mockito.<Map<String, FieldMetadata>>any(), Mockito.<List<Serializable>>any()))
        .thenReturn(new Entity[]{entity});

    // Act
    DynamicResultSet actualFetchResult = skuCustomPersistenceHandler.fetch(persistencePackage, cto, dynamicEntityDao,
        helper);

    // Assert
    verify(cto).get(eq("consolidatedProductOptions"));
    verify(cto).getCriteriaMap();
    verify(cto).getFirstResult();
    verify(cto).getMaxResults();
    verify(filterAndSortCriteria, atLeast(1)).getFilterValues();
    verify(persistencePackage, atLeast(1)).containsCriteria(Mockito.<String>any());
    verify(persistencePackage, atLeast(1)).getCeilingEntityFullyQualifiedClassname();
    verify(persistencePackage, atLeast(1)).getCustomCriteria();
    verify(persistencePackage).getPersistencePerspective();
    verify(persistencePackage).getSectionCrumbs();
    verify(helper).getFilterMappings(isA(PersistencePerspective.class), isA(CriteriaTransferObject.class),
        eq("Dr Jane Doe"), isA(Map.class));
    verify(helper).getPersistentRecords(eq("Dr Jane Doe"), isA(List.class), eq(1), eq(3));
    verify(helper).getRecords(isA(Map.class), isA(List.class));
    verify(helper).getSimpleMergedProperties(eq("org.broadleafcommerce.core.catalog.domain.Sku"),
        isA(PersistencePerspective.class));
    verify(helper).getTotalRecords(eq("Dr Jane Doe"), isA(List.class));
    assertNull(actualFetchResult.getPromptSearch());
    assertNull(actualFetchResult.getTotalCountLessThanPageSize());
    assertNull(actualFetchResult.getBatchId());
    assertNull(actualFetchResult.getLowerCount());
    assertNull(actualFetchResult.getUpperCount());
    assertNull(actualFetchResult.getFirstId());
    assertNull(actualFetchResult.getLastId());
    assertNull(actualFetchResult.getClassMetaData());
    assertNull(actualFetchResult.getFetchType());
    assertEquals(0, actualFetchResult.getPageSize().intValue());
    assertEquals(0, actualFetchResult.getStartIndex().intValue());
    assertEquals(1, actualFetchResult.getTotalRecords().intValue());
    Entity[] records = actualFetchResult.getRecords();
    assertEquals(1, records.length);
    assertTrue(dynamicEntityDao.getFieldMetadataProviders().isEmpty());
    assertTrue(actualFetchResult.getUnselectedTabMetadata().isEmpty());
    assertSame(entity, records[0]);
  }

  /**
   * Method under test:
   * {@link SkuCustomPersistenceHandler#fetch(PersistencePackage, CriteriaTransferObject, DynamicEntityDao, RecordHelper)}
   */
  @Test
  public void testFetch13() throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuCustomPersistenceHandler skuCustomPersistenceHandler = new SkuCustomPersistenceHandler();

    SectionCrumb sectionCrumb = new SectionCrumb();
    sectionCrumb.setOriginalSectionIdentifier("42");
    sectionCrumb.setSectionId("42");
    sectionCrumb.setSectionIdentifier("42");
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.containsCriteria(Mockito.<String>any())).thenReturn(true);
    when(persistencePackage.getCustomCriteria()).thenReturn(new String[]{"Custom Criteria"});
    when(persistencePackage.getSectionCrumbs()).thenReturn(new SectionCrumb[]{sectionCrumb});
    when(persistencePackage.getCeilingEntityFullyQualifiedClassname()).thenReturn("Dr Jane Doe");
    when(persistencePackage.getPersistencePerspective()).thenReturn(new PersistencePerspective());

    ArrayList<String> stringList = new ArrayList<>();
    stringList.add("Custom Criteria");
    stringList.add("owningClass=org.broadleafcommerce.core.catalog.domain.SkuBundleItemImpl");
    FilterAndSortCriteria filterAndSortCriteria = mock(FilterAndSortCriteria.class);
    when(filterAndSortCriteria.getFilterValues()).thenReturn(stringList);
    CriteriaTransferObject cto = mock(CriteriaTransferObject.class);
    when(cto.getFirstResult()).thenReturn(1);
    when(cto.getMaxResults()).thenReturn(3);
    when(cto.getCriteriaMap()).thenReturn(new HashMap<>());
    when(cto.get(Mockito.<String>any())).thenReturn(filterAndSortCriteria);
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();
    RecordHelper helper = mock(RecordHelper.class);
    when(helper.getTotalRecords(Mockito.<String>any(), Mockito.<List<FilterMapping>>any())).thenReturn(1);
    when(helper.getFilterMappings(Mockito.<PersistencePerspective>any(), Mockito.<CriteriaTransferObject>any(),
        Mockito.<String>any(), Mockito.<Map<String, FieldMetadata>>any())).thenReturn(new ArrayList<>());
    when(helper.getPersistentRecords(Mockito.<String>any(), Mockito.<List<FilterMapping>>any(), Mockito.<Integer>any(),
        Mockito.<Integer>any())).thenReturn(new ArrayList<>());
    when(helper.getSimpleMergedProperties(Mockito.<String>any(), Mockito.<PersistencePerspective>any()))
        .thenReturn(new HashMap<>());
    Entity entity = new Entity();
    when(helper.getRecords(Mockito.<Map<String, FieldMetadata>>any(), Mockito.<List<Serializable>>any()))
        .thenReturn(new Entity[]{entity});

    // Act
    DynamicResultSet actualFetchResult = skuCustomPersistenceHandler.fetch(persistencePackage, cto, dynamicEntityDao,
        helper);

    // Assert
    verify(cto).get(eq("consolidatedProductOptions"));
    verify(cto).getCriteriaMap();
    verify(cto).getFirstResult();
    verify(cto).getMaxResults();
    verify(filterAndSortCriteria, atLeast(1)).getFilterValues();
    verify(persistencePackage, atLeast(1)).containsCriteria(Mockito.<String>any());
    verify(persistencePackage, atLeast(1)).getCeilingEntityFullyQualifiedClassname();
    verify(persistencePackage, atLeast(1)).getCustomCriteria();
    verify(persistencePackage).getPersistencePerspective();
    verify(persistencePackage).getSectionCrumbs();
    verify(helper).getFilterMappings(isA(PersistencePerspective.class), isA(CriteriaTransferObject.class),
        eq("Dr Jane Doe"), isA(Map.class));
    verify(helper).getPersistentRecords(eq("Dr Jane Doe"), isA(List.class), eq(1), eq(3));
    verify(helper).getRecords(isA(Map.class), isA(List.class));
    verify(helper).getSimpleMergedProperties(eq("org.broadleafcommerce.core.catalog.domain.Sku"),
        isA(PersistencePerspective.class));
    verify(helper).getTotalRecords(eq("Dr Jane Doe"), isA(List.class));
    assertNull(actualFetchResult.getPromptSearch());
    assertNull(actualFetchResult.getTotalCountLessThanPageSize());
    assertNull(actualFetchResult.getBatchId());
    assertNull(actualFetchResult.getLowerCount());
    assertNull(actualFetchResult.getUpperCount());
    assertNull(actualFetchResult.getFirstId());
    assertNull(actualFetchResult.getLastId());
    assertNull(actualFetchResult.getClassMetaData());
    assertNull(actualFetchResult.getFetchType());
    assertEquals(0, actualFetchResult.getPageSize().intValue());
    assertEquals(0, actualFetchResult.getStartIndex().intValue());
    assertEquals(1, actualFetchResult.getTotalRecords().intValue());
    Entity[] records = actualFetchResult.getRecords();
    assertEquals(1, records.length);
    assertTrue(dynamicEntityDao.getFieldMetadataProviders().isEmpty());
    assertTrue(actualFetchResult.getUnselectedTabMetadata().isEmpty());
    assertSame(entity, records[0]);
  }

  /**
   * Method under test:
   * {@link SkuCustomPersistenceHandler#applyInventoryRestictions(List, CriteriaTransferObject, PersistencePackage)}
   */
  @Test
  public void testApplyInventoryRestictions() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuCustomPersistenceHandler skuCustomPersistenceHandler = new SkuCustomPersistenceHandler();
    ArrayList<FilterMapping> filterMappings = new ArrayList<>();
    CriteriaTransferObject cto = new CriteriaTransferObject();
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.containsCriteria(Mockito.<String>any())).thenReturn(true);

    // Act
    skuCustomPersistenceHandler.applyInventoryRestictions(filterMappings, cto, persistencePackage);

    // Assert
    verify(persistencePackage, atLeast(1)).containsCriteria(Mockito.<String>any());
  }

  /**
   * Method under test:
   * {@link SkuCustomPersistenceHandler#applyProductOptionValueCriteria(List, CriteriaTransferObject, PersistencePackage, String)}
   */
  @Test
  public void testApplyProductOptionValueCriteria() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuCustomPersistenceHandler skuCustomPersistenceHandler = new SkuCustomPersistenceHandler();
    ArrayList<FilterMapping> filterMappings = new ArrayList<>();
    CriteriaTransferObject cto = new CriteriaTransferObject();
    PersistencePackage persistencePackage = new PersistencePackage();

    // Act
    skuCustomPersistenceHandler.applyProductOptionValueCriteria(filterMappings, cto, persistencePackage,
        "Sku Property Prefix");

    // Assert
    FieldMetadata metadata = skuCustomPersistenceHandler.getBlankConsolidatedOptionProperty().getMetadata();
    assertTrue(metadata instanceof BasicFieldMetadata);
    Map<String, FilterAndSortCriteria> criteriaMap = cto.getCriteriaMap();
    assertEquals(1, criteriaMap.size());
    FilterAndSortCriteria getResult = criteriaMap.get("consolidatedProductOptions");
    assertEquals("consolidatedProductOptions", getResult.getPropertyId());
    assertNull(getResult.getSortAscending());
    assertNull(getResult.getOrder());
    assertNull(getResult.getSortDirection());
    assertNull(getResult.getRestrictionType());
    assertTrue(filterMappings.isEmpty());
    assertTrue(getResult.getFilterValues().isEmpty());
    assertTrue(getResult.getSpecialFilterValues().isEmpty());
    assertTrue(((BasicFieldMetadata) metadata).getValidationConfigurations().isEmpty());
    assertTrue(metadata.getAdditionalMetadata().isEmpty());
    assertTrue(persistencePackage.getPersistencePerspectiveItems().isEmpty());
    assertTrue(persistencePackage.getSubPackages().isEmpty());
    assertTrue(getResult.isNullsLast());
  }

  /**
   * Method under test:
   * {@link SkuCustomPersistenceHandler#applyProductOptionValueCriteria(List, CriteriaTransferObject, PersistencePackage, String)}
   */
  @Test
  public void testApplyProductOptionValueCriteria2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuCustomPersistenceHandler skuCustomPersistenceHandler = new SkuCustomPersistenceHandler();
    ArrayList<FilterMapping> filterMappings = new ArrayList<>();

    HashMap<String, FilterAndSortCriteria> criteriaMap = new HashMap<>();
    criteriaMap.put(SkuCustomPersistenceHandler.CONSOLIDATED_PRODUCT_OPTIONS_FIELD_NAME,
        new FilterAndSortCriteria("42"));
    criteriaMap.put(SkuCustomPersistenceHandler.CONSOLIDATED_PRODUCT_OPTIONS_FIELD_NAME,
        new FilterAndSortCriteria("42"));

    CriteriaTransferObject cto = new CriteriaTransferObject();
    cto.setCriteriaMap(criteriaMap);
    PersistencePackage persistencePackage = new PersistencePackage();

    // Act
    skuCustomPersistenceHandler.applyProductOptionValueCriteria(filterMappings, cto, persistencePackage, null);

    // Assert
    FieldMetadata metadata = skuCustomPersistenceHandler.getBlankConsolidatedOptionProperty().getMetadata();
    assertTrue(metadata instanceof BasicFieldMetadata);
    assertTrue(filterMappings.isEmpty());
    assertTrue(((BasicFieldMetadata) metadata).getValidationConfigurations().isEmpty());
    assertTrue(metadata.getAdditionalMetadata().isEmpty());
    assertTrue(persistencePackage.getPersistencePerspectiveItems().isEmpty());
    assertTrue(persistencePackage.getSubPackages().isEmpty());
    assertSame(criteriaMap, cto.getCriteriaMap());
  }

  /**
   * Method under test:
   * {@link SkuCustomPersistenceHandler#applyProductOptionValueCriteria(List, CriteriaTransferObject, PersistencePackage, String)}
   */
  @Test
  public void testApplyProductOptionValueCriteria3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuCustomPersistenceHandler skuCustomPersistenceHandler = new SkuCustomPersistenceHandler();

    ArrayList<FilterMapping> filterMappings = new ArrayList<>();
    FilterMapping filterMapping = new FilterMapping();
    filterMappings.add(filterMapping);
    CriteriaTransferObject cto = new CriteriaTransferObject();
    PersistencePackage persistencePackage = new PersistencePackage();

    // Act
    skuCustomPersistenceHandler.applyProductOptionValueCriteria(filterMappings, cto, persistencePackage,
        "Sku Property Prefix");

    // Assert
    FieldMetadata metadata = skuCustomPersistenceHandler.getBlankConsolidatedOptionProperty().getMetadata();
    assertTrue(metadata instanceof BasicFieldMetadata);
    Map<String, FilterAndSortCriteria> criteriaMap = cto.getCriteriaMap();
    assertEquals(1, criteriaMap.size());
    FilterAndSortCriteria getResult = criteriaMap.get("consolidatedProductOptions");
    assertEquals("consolidatedProductOptions", getResult.getPropertyId());
    assertNull(getResult.getSortAscending());
    assertNull(getResult.getOrder());
    assertNull(getResult.getSortDirection());
    assertNull(getResult.getRestrictionType());
    assertEquals(1, filterMappings.size());
    assertTrue(getResult.getFilterValues().isEmpty());
    assertTrue(getResult.getSpecialFilterValues().isEmpty());
    assertTrue(((BasicFieldMetadata) metadata).getValidationConfigurations().isEmpty());
    assertTrue(metadata.getAdditionalMetadata().isEmpty());
    assertTrue(persistencePackage.getPersistencePerspectiveItems().isEmpty());
    assertTrue(persistencePackage.getSubPackages().isEmpty());
    assertTrue(getResult.isNullsLast());
    assertSame(filterMapping, filterMappings.get(0));
  }

  /**
   * Method under test:
   * {@link SkuCustomPersistenceHandler#applyProductOptionValueCriteria(List, CriteriaTransferObject, PersistencePackage, String)}
   */
  @Test
  public void testApplyProductOptionValueCriteria4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuCustomPersistenceHandler skuCustomPersistenceHandler = new SkuCustomPersistenceHandler();

    ArrayList<FilterMapping> filterMappings = new ArrayList<>();
    FilterMapping filterMapping = new FilterMapping();
    filterMappings.add(filterMapping);
    filterMappings.add(new FilterMapping());
    CriteriaTransferObject cto = new CriteriaTransferObject();
    PersistencePackage persistencePackage = new PersistencePackage();

    // Act
    skuCustomPersistenceHandler.applyProductOptionValueCriteria(filterMappings, cto, persistencePackage,
        "Sku Property Prefix");

    // Assert
    FieldMetadata metadata = skuCustomPersistenceHandler.getBlankConsolidatedOptionProperty().getMetadata();
    assertTrue(metadata instanceof BasicFieldMetadata);
    Map<String, FilterAndSortCriteria> criteriaMap = cto.getCriteriaMap();
    assertEquals(1, criteriaMap.size());
    FilterAndSortCriteria getResult = criteriaMap.get("consolidatedProductOptions");
    assertEquals("consolidatedProductOptions", getResult.getPropertyId());
    assertNull(getResult.getSortAscending());
    assertNull(getResult.getOrder());
    assertNull(getResult.getSortDirection());
    assertNull(getResult.getRestrictionType());
    assertEquals(2, filterMappings.size());
    assertTrue(getResult.getFilterValues().isEmpty());
    assertTrue(getResult.getSpecialFilterValues().isEmpty());
    assertTrue(((BasicFieldMetadata) metadata).getValidationConfigurations().isEmpty());
    assertTrue(metadata.getAdditionalMetadata().isEmpty());
    assertTrue(persistencePackage.getPersistencePerspectiveItems().isEmpty());
    assertTrue(persistencePackage.getSubPackages().isEmpty());
    assertTrue(getResult.isNullsLast());
    assertSame(filterMapping, filterMappings.get(0));
  }

  /**
   * Method under test:
   * {@link SkuCustomPersistenceHandler#applyProductOptionValueCriteria(List, CriteriaTransferObject, PersistencePackage, String)}
   */
  @Test
  public void testApplyProductOptionValueCriteria5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuCustomPersistenceHandler skuCustomPersistenceHandler = new SkuCustomPersistenceHandler();
    ArrayList<FilterMapping> filterMappings = new ArrayList<>();
    CriteriaTransferObject cto = mock(CriteriaTransferObject.class);
    when(cto.getCriteriaMap()).thenReturn(new HashMap<>());
    when(cto.get(Mockito.<String>any())).thenReturn(new FilterAndSortCriteria("42"));
    PersistencePackage persistencePackage = new PersistencePackage();

    // Act
    skuCustomPersistenceHandler.applyProductOptionValueCriteria(filterMappings, cto, persistencePackage,
        "Sku Property Prefix");

    // Assert
    verify(cto).get(eq("consolidatedProductOptions"));
    verify(cto).getCriteriaMap();
    FieldMetadata metadata = skuCustomPersistenceHandler.getBlankConsolidatedOptionProperty().getMetadata();
    assertTrue(metadata instanceof BasicFieldMetadata);
    assertTrue(filterMappings.isEmpty());
    assertTrue(((BasicFieldMetadata) metadata).getValidationConfigurations().isEmpty());
    assertTrue(metadata.getAdditionalMetadata().isEmpty());
    assertTrue(persistencePackage.getPersistencePerspectiveItems().isEmpty());
    assertTrue(persistencePackage.getSubPackages().isEmpty());
  }

  /**
   * Method under test:
   * {@link SkuCustomPersistenceHandler#applyProductOptionValueCriteria(List, CriteriaTransferObject, PersistencePackage, String)}
   */
  @Test
  public void testApplyProductOptionValueCriteria6() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuCustomPersistenceHandler skuCustomPersistenceHandler = new SkuCustomPersistenceHandler();
    ArrayList<FilterMapping> filterMappings = new ArrayList<>();
    CriteriaTransferObject cto = mock(CriteriaTransferObject.class);
    when(cto.getCriteriaMap()).thenReturn(new HashMap<>());
    when(cto.get(Mockito.<String>any())).thenReturn(new FilterAndSortCriteria("42", "42"));
    PersistencePackage persistencePackage = new PersistencePackage();

    // Act
    skuCustomPersistenceHandler.applyProductOptionValueCriteria(filterMappings, cto, persistencePackage,
        "Sku Property Prefix");

    // Assert
    verify(cto).get(eq("consolidatedProductOptions"));
    verify(cto).getCriteriaMap();
    FieldMetadata metadata = skuCustomPersistenceHandler.getBlankConsolidatedOptionProperty().getMetadata();
    assertTrue(metadata instanceof BasicFieldMetadata);
    assertEquals(1, filterMappings.size());
    FilterMapping getResult = filterMappings.get(0);
    List directFilterValues = getResult.getDirectFilterValues();
    assertEquals(1, directFilterValues.size());
    assertEquals("42", directFilterValues.get(0));
    FieldPath fieldPath = getResult.getFieldPath();
    assertEquals("Sku Property Prefix.productOptionValueXrefs.productOptionValue.attributeValue",
        fieldPath.getTargetProperty());
    assertNull(getResult.getInheritedFromClass());
    assertNull(getResult.getOrder());
    assertNull(getResult.getFullPropertyName());
    Restriction restriction = getResult.getRestriction();
    FieldPathBuilder fieldPathBuilder = restriction.getFieldPathBuilder();
    assertNull(fieldPathBuilder.getRestrictions());
    assertNull(fieldPathBuilder.getCriteria());
    assertNull(getResult.getSortDirection());
    assertNull(restriction.getFilterValueConverter());
    assertTrue(fieldPath.getAssociationPath().isEmpty());
    assertTrue(fieldPath.getTargetPropertyPieces().isEmpty());
    assertTrue(getResult.getFilterValues().isEmpty());
    assertTrue(((BasicFieldMetadata) metadata).getValidationConfigurations().isEmpty());
    assertTrue(metadata.getAdditionalMetadata().isEmpty());
    assertTrue(persistencePackage.getPersistencePerspectiveItems().isEmpty());
    assertTrue(persistencePackage.getSubPackages().isEmpty());
    assertTrue(getResult.getNullsLast());
  }

  /**
   * Method under test:
   * {@link SkuCustomPersistenceHandler#applyProductOptionValueCriteria(List, CriteriaTransferObject, PersistencePackage, String)}
   */
  @Test
  public void testApplyProductOptionValueCriteria7() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuCustomPersistenceHandler skuCustomPersistenceHandler = new SkuCustomPersistenceHandler();
    ArrayList<FilterMapping> filterMappings = new ArrayList<>();
    FilterAndSortCriteria filterAndSortCriteria = mock(FilterAndSortCriteria.class);
    when(filterAndSortCriteria.getFilterValues()).thenReturn(new ArrayList<>());
    CriteriaTransferObject cto = mock(CriteriaTransferObject.class);
    when(cto.getCriteriaMap()).thenReturn(new HashMap<>());
    when(cto.get(Mockito.<String>any())).thenReturn(filterAndSortCriteria);
    PersistencePackage persistencePackage = new PersistencePackage();

    // Act
    skuCustomPersistenceHandler.applyProductOptionValueCriteria(filterMappings, cto, persistencePackage,
        "Sku Property Prefix");

    // Assert
    verify(cto).get(eq("consolidatedProductOptions"));
    verify(cto).getCriteriaMap();
    verify(filterAndSortCriteria).getFilterValues();
    FieldMetadata metadata = skuCustomPersistenceHandler.getBlankConsolidatedOptionProperty().getMetadata();
    assertTrue(metadata instanceof BasicFieldMetadata);
    assertTrue(filterMappings.isEmpty());
    assertTrue(((BasicFieldMetadata) metadata).getValidationConfigurations().isEmpty());
    assertTrue(metadata.getAdditionalMetadata().isEmpty());
    assertTrue(persistencePackage.getPersistencePerspectiveItems().isEmpty());
    assertTrue(persistencePackage.getSubPackages().isEmpty());
  }

  /**
   * Method under test:
   * {@link SkuCustomPersistenceHandler#applyProductOptionValueCriteria(List, CriteriaTransferObject, PersistencePackage, String)}
   */
  @Test
  public void testApplyProductOptionValueCriteria8() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuCustomPersistenceHandler skuCustomPersistenceHandler = new SkuCustomPersistenceHandler();
    ArrayList<FilterMapping> filterMappings = new ArrayList<>();

    ArrayList<String> stringList = new ArrayList<>();
    stringList.add("foo");
    FilterAndSortCriteria filterAndSortCriteria = mock(FilterAndSortCriteria.class);
    when(filterAndSortCriteria.getFilterValues()).thenReturn(stringList);
    CriteriaTransferObject cto = mock(CriteriaTransferObject.class);
    when(cto.getCriteriaMap()).thenReturn(new HashMap<>());
    when(cto.get(Mockito.<String>any())).thenReturn(filterAndSortCriteria);
    PersistencePackage persistencePackage = new PersistencePackage();

    // Act
    skuCustomPersistenceHandler.applyProductOptionValueCriteria(filterMappings, cto, persistencePackage,
        "Sku Property Prefix");

    // Assert
    verify(cto).get(eq("consolidatedProductOptions"));
    verify(cto).getCriteriaMap();
    verify(filterAndSortCriteria, atLeast(1)).getFilterValues();
    FieldMetadata metadata = skuCustomPersistenceHandler.getBlankConsolidatedOptionProperty().getMetadata();
    assertTrue(metadata instanceof BasicFieldMetadata);
    assertEquals(1, filterMappings.size());
    FilterMapping getResult = filterMappings.get(0);
    FieldPath fieldPath = getResult.getFieldPath();
    assertEquals("Sku Property Prefix.productOptionValueXrefs.productOptionValue.attributeValue",
        fieldPath.getTargetProperty());
    List directFilterValues = getResult.getDirectFilterValues();
    assertEquals(1, directFilterValues.size());
    assertEquals("foo", directFilterValues.get(0));
    assertNull(getResult.getInheritedFromClass());
    assertNull(getResult.getOrder());
    assertNull(getResult.getFullPropertyName());
    Restriction restriction = getResult.getRestriction();
    FieldPathBuilder fieldPathBuilder = restriction.getFieldPathBuilder();
    assertNull(fieldPathBuilder.getRestrictions());
    assertNull(fieldPathBuilder.getCriteria());
    assertNull(getResult.getSortDirection());
    assertNull(restriction.getFilterValueConverter());
    assertTrue(fieldPath.getAssociationPath().isEmpty());
    assertTrue(fieldPath.getTargetPropertyPieces().isEmpty());
    assertTrue(getResult.getFilterValues().isEmpty());
    assertTrue(((BasicFieldMetadata) metadata).getValidationConfigurations().isEmpty());
    assertTrue(metadata.getAdditionalMetadata().isEmpty());
    assertTrue(persistencePackage.getPersistencePerspectiveItems().isEmpty());
    assertTrue(persistencePackage.getSubPackages().isEmpty());
    assertTrue(getResult.getNullsLast());
  }

  /**
   * Method under test:
   * {@link SkuCustomPersistenceHandler#applyProductOptionValueCriteria(List, CriteriaTransferObject, PersistencePackage, String)}
   */
  @Test
  public void testApplyProductOptionValueCriteria9() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuCustomPersistenceHandler skuCustomPersistenceHandler = new SkuCustomPersistenceHandler();
    ArrayList<FilterMapping> filterMappings = new ArrayList<>();

    ArrayList<String> stringList = new ArrayList<>();
    stringList.add("foo");
    FilterAndSortCriteria filterAndSortCriteria = mock(FilterAndSortCriteria.class);
    when(filterAndSortCriteria.getFilterValues()).thenReturn(stringList);
    CriteriaTransferObject cto = mock(CriteriaTransferObject.class);
    when(cto.getCriteriaMap()).thenReturn(new HashMap<>());
    when(cto.get(Mockito.<String>any())).thenReturn(filterAndSortCriteria);
    PersistencePackage persistencePackage = new PersistencePackage();

    // Act
    skuCustomPersistenceHandler.applyProductOptionValueCriteria(filterMappings, cto, persistencePackage, "");

    // Assert
    verify(cto).get(eq("consolidatedProductOptions"));
    verify(cto).getCriteriaMap();
    verify(filterAndSortCriteria, atLeast(1)).getFilterValues();
    FieldMetadata metadata = skuCustomPersistenceHandler.getBlankConsolidatedOptionProperty().getMetadata();
    assertTrue(metadata instanceof BasicFieldMetadata);
    assertEquals(1, filterMappings.size());
    FilterMapping getResult = filterMappings.get(0);
    FieldPath fieldPath = getResult.getFieldPath();
    assertEquals("", fieldPath.getTargetProperty());
    List directFilterValues = getResult.getDirectFilterValues();
    assertEquals(1, directFilterValues.size());
    assertEquals("foo", directFilterValues.get(0));
    assertNull(getResult.getInheritedFromClass());
    assertNull(getResult.getOrder());
    assertNull(getResult.getFullPropertyName());
    Restriction restriction = getResult.getRestriction();
    FieldPathBuilder fieldPathBuilder = restriction.getFieldPathBuilder();
    assertNull(fieldPathBuilder.getRestrictions());
    assertNull(fieldPathBuilder.getCriteria());
    assertNull(getResult.getSortDirection());
    assertNull(restriction.getFilterValueConverter());
    assertTrue(fieldPath.getAssociationPath().isEmpty());
    assertTrue(fieldPath.getTargetPropertyPieces().isEmpty());
    assertTrue(getResult.getFilterValues().isEmpty());
    assertTrue(((BasicFieldMetadata) metadata).getValidationConfigurations().isEmpty());
    assertTrue(metadata.getAdditionalMetadata().isEmpty());
    assertTrue(persistencePackage.getPersistencePerspectiveItems().isEmpty());
    assertTrue(persistencePackage.getSubPackages().isEmpty());
    assertTrue(getResult.getNullsLast());
  }

  /**
   * Method under test:
   * {@link SkuCustomPersistenceHandler#applyProductOptionValueCriteria(List, CriteriaTransferObject, PersistencePackage, String)}
   */
  @Test
  public void testApplyProductOptionValueCriteria10() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuCustomPersistenceHandler skuCustomPersistenceHandler = new SkuCustomPersistenceHandler();
    ArrayList<FilterMapping> filterMappings = new ArrayList<>();

    ArrayList<String> stringList = new ArrayList<>();
    stringList.add("");
    FilterAndSortCriteria filterAndSortCriteria = mock(FilterAndSortCriteria.class);
    when(filterAndSortCriteria.getFilterValues()).thenReturn(stringList);
    CriteriaTransferObject cto = mock(CriteriaTransferObject.class);
    when(cto.getCriteriaMap()).thenReturn(new HashMap<>());
    when(cto.get(Mockito.<String>any())).thenReturn(filterAndSortCriteria);
    PersistencePackage persistencePackage = new PersistencePackage();

    // Act
    skuCustomPersistenceHandler.applyProductOptionValueCriteria(filterMappings, cto, persistencePackage, "");

    // Assert
    verify(cto).get(eq("consolidatedProductOptions"));
    verify(cto).getCriteriaMap();
    verify(filterAndSortCriteria, atLeast(1)).getFilterValues();
    FieldMetadata metadata = skuCustomPersistenceHandler.getBlankConsolidatedOptionProperty().getMetadata();
    assertTrue(metadata instanceof BasicFieldMetadata);
    assertTrue(filterMappings.isEmpty());
    assertTrue(((BasicFieldMetadata) metadata).getValidationConfigurations().isEmpty());
    assertTrue(metadata.getAdditionalMetadata().isEmpty());
    assertTrue(persistencePackage.getPersistencePerspectiveItems().isEmpty());
    assertTrue(persistencePackage.getSubPackages().isEmpty());
  }

  /**
   * Method under test:
   * {@link SkuCustomPersistenceHandler#associateProductOptionValuesToSku(Entity, Sku, DynamicEntityDao)}
   */
  @Test
  public void testAssociateProductOptionValuesToSku() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuCustomPersistenceHandler skuCustomPersistenceHandler = new SkuCustomPersistenceHandler();
    Entity entity = mock(Entity.class);
    when(entity.getProperties()).thenReturn(new Property[]{new Property("Name", "42")});
    SkuImpl adminInstance = new SkuImpl();

    // Act
    skuCustomPersistenceHandler.associateProductOptionValuesToSku(entity, adminInstance, new DynamicEntityDaoImpl());

    // Assert
    verify(entity).getProperties();
  }

  /**
   * Method under test:
   * {@link SkuCustomPersistenceHandler#associateProductOptionValuesToSku(Entity, Sku, DynamicEntityDao)}
   */
  @Test
  public void testAssociateProductOptionValuesToSku2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuCustomPersistenceHandler skuCustomPersistenceHandler = new SkuCustomPersistenceHandler();
    Property property = mock(Property.class);
    when(property.getName()).thenReturn("Name");
    Entity entity = mock(Entity.class);
    when(entity.getProperties()).thenReturn(new Property[]{property});
    SkuImpl adminInstance = new SkuImpl();

    // Act
    skuCustomPersistenceHandler.associateProductOptionValuesToSku(entity, adminInstance, new DynamicEntityDaoImpl());

    // Assert
    verify(entity).getProperties();
    verify(property).getName();
  }

  /**
   * Method under test:
   * {@link SkuCustomPersistenceHandler#getProductOptionProperties(Entity)}
   */
  @Test
  public void testGetProductOptionProperties() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuCustomPersistenceHandler skuCustomPersistenceHandler = new SkuCustomPersistenceHandler();
    Entity entity = mock(Entity.class);
    when(entity.getProperties()).thenReturn(new Property[]{new Property("Name", "42")});

    // Act
    List<Property> actualProductOptionProperties = skuCustomPersistenceHandler.getProductOptionProperties(entity);

    // Assert
    verify(entity).getProperties();
    assertTrue(actualProductOptionProperties.isEmpty());
  }

  /**
   * Method under test:
   * {@link SkuCustomPersistenceHandler#getProductOptionProperties(Entity)}
   */
  @Test
  public void testGetProductOptionProperties2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuCustomPersistenceHandler skuCustomPersistenceHandler = new SkuCustomPersistenceHandler();
    Property property = mock(Property.class);
    when(property.getName()).thenReturn("Name");
    Entity entity = mock(Entity.class);
    when(entity.getProperties()).thenReturn(new Property[]{property});

    // Act
    List<Property> actualProductOptionProperties = skuCustomPersistenceHandler.getProductOptionProperties(entity);

    // Assert
    verify(entity).getProperties();
    verify(property).getName();
    assertTrue(actualProductOptionProperties.isEmpty());
  }

  /**
   * Method under test:
   * {@link SkuCustomPersistenceHandler#validateUniqueProductOptionValueCombination(Product, List, Sku)}
   */
  @Test
  public void testValidateUniqueProductOptionValueCombination() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuCustomPersistenceHandler skuCustomPersistenceHandler = new SkuCustomPersistenceHandler();
    ProductBundleImpl product = new ProductBundleImpl();
    ArrayList<Property> productOptionProperties = new ArrayList<>();

    // Act and Assert
    assertNull(skuCustomPersistenceHandler.validateUniqueProductOptionValueCombination(product, productOptionProperties,
        new SkuImpl()));
  }

  /**
   * Method under test:
   * {@link SkuCustomPersistenceHandler#validateUniqueProductOptionValueCombination(Product, List, Sku)}
   */
  @Test
  public void testValidateUniqueProductOptionValueCombination2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuCustomPersistenceHandler skuCustomPersistenceHandler = new SkuCustomPersistenceHandler();
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    ArrayList<Property> productOptionProperties = new ArrayList<>();

    // Act and Assert
    assertNull(skuCustomPersistenceHandler.validateUniqueProductOptionValueCombination(product, productOptionProperties,
        new SkuImpl()));
  }

  /**
   * Method under test:
   * {@link SkuCustomPersistenceHandler#validateUniqueProductOptionValueCombination(Product, List, Sku)}
   */
  @Test
  public void testValidateUniqueProductOptionValueCombination3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuCustomPersistenceHandler skuCustomPersistenceHandler = new SkuCustomPersistenceHandler();
    ProductBundleImpl product = new ProductBundleImpl();

    ArrayList<Property> productOptionProperties = new ArrayList<>();
    productOptionProperties.add(new Property("Name", "42"));

    // Act and Assert
    assertNull(skuCustomPersistenceHandler.validateUniqueProductOptionValueCombination(product, productOptionProperties,
        new SkuImpl()));
  }

  /**
   * Method under test:
   * {@link SkuCustomPersistenceHandler#validateUniqueProductOptionValueCombination(Product, List, Sku)}
   */
  @Test
  public void testValidateUniqueProductOptionValueCombination4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuCustomPersistenceHandler skuCustomPersistenceHandler = new SkuCustomPersistenceHandler();
    ProductBundleImpl product = new ProductBundleImpl();
    Property property = mock(Property.class);
    when(property.getValue()).thenReturn("42");

    ArrayList<Property> productOptionProperties = new ArrayList<>();
    productOptionProperties.add(property);

    // Act
    Entity actualValidateUniqueProductOptionValueCombinationResult = skuCustomPersistenceHandler
        .validateUniqueProductOptionValueCombination(product, productOptionProperties, new SkuImpl());

    // Assert
    verify(property).getValue();
    assertNull(actualValidateUniqueProductOptionValueCombinationResult);
  }
}
