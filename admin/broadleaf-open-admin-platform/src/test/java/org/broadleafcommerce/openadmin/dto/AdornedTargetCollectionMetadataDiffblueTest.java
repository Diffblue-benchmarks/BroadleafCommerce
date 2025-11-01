/*-
 * #%L
 * BroadleafCommerce Open Admin Platform
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
package org.broadleafcommerce.openadmin.dto;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import java.util.HashMap;
import java.util.function.BiFunction;
import org.broadleafcommerce.common.presentation.client.AdornedTargetAddMethodType;
import org.broadleafcommerce.common.presentation.client.OperationType;
import org.broadleafcommerce.common.presentation.client.PersistencePerspectiveItemType;
import org.broadleafcommerce.openadmin.dto.visitor.MetadataVisitor;
import org.broadleafcommerce.openadmin.dto.visitor.MetadataVisitorAdapter;
import org.junit.Test;
import org.mockito.Mockito;

public class AdornedTargetCollectionMetadataDiffblueTest {
  /**
   * Method under test:
   * {@link AdornedTargetCollectionMetadata#accept(MetadataVisitor)}
   */
  @Test
  public void testAccept() {
    // Arrange
    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata = new AdornedTargetCollectionMetadata();
    MetadataVisitorAdapter visitor = mock(MetadataVisitorAdapter.class);
    doNothing().when(visitor).visit(Mockito.<AdornedTargetCollectionMetadata>any());

    // Act
    adornedTargetCollectionMetadata.accept(visitor);

    // Assert
    verify(visitor).visit(isA(AdornedTargetCollectionMetadata.class));
  }

  /**
   * Method under test:
   * {@link AdornedTargetCollectionMetadata#populate(FieldMetadata)}
   */
  @Test
  public void testPopulate() {
    // Arrange
    PersistencePerspective persistencePerspective = new PersistencePerspective();
    persistencePerspective.setAdditionalNonPersistentProperties(null);
    persistencePerspective.setAdditionalForeignKeys(null);
    persistencePerspective.setPersistencePerspectiveItems(null);
    persistencePerspective.setExcludeFields(null);
    persistencePerspective.setIncludeFields(null);

    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata = new AdornedTargetCollectionMetadata();
    adornedTargetCollectionMetadata.setPersistencePerspective(persistencePerspective);
    AdornedTargetCollectionMetadata metadata = new AdornedTargetCollectionMetadata();

    // Act and Assert
    assertSame(metadata, adornedTargetCollectionMetadata.populate(metadata));
  }

  /**
   * Method under test:
   * {@link AdornedTargetCollectionMetadata#populate(FieldMetadata)}
   */
  @Test
  public void testPopulate2() {
    // Arrange
    PersistencePerspective persistencePerspective = new PersistencePerspective();
    persistencePerspective.setAdditionalNonPersistentProperties(null);
    persistencePerspective.setAdditionalForeignKeys(null);
    persistencePerspective.setPersistencePerspectiveItems(null);
    persistencePerspective.setExcludeFields(null);
    persistencePerspective.setIncludeFields(new String[]{"foo"});

    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata = new AdornedTargetCollectionMetadata();
    adornedTargetCollectionMetadata.setPersistencePerspective(persistencePerspective);
    AdornedTargetCollectionMetadata metadata = new AdornedTargetCollectionMetadata();

    // Act and Assert
    assertSame(metadata, adornedTargetCollectionMetadata.populate(metadata));
  }

  /**
   * Method under test:
   * {@link AdornedTargetCollectionMetadata#populate(FieldMetadata)}
   */
  @Test
  public void testPopulate3() {
    // Arrange
    PersistencePerspective persistencePerspective = new PersistencePerspective();
    persistencePerspective.setAdditionalNonPersistentProperties(null);
    persistencePerspective.setAdditionalForeignKeys(null);
    persistencePerspective.setPersistencePerspectiveItems(null);
    persistencePerspective.setExcludeFields(new String[]{"foo"});
    persistencePerspective.setIncludeFields(null);

    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata = new AdornedTargetCollectionMetadata();
    adornedTargetCollectionMetadata.setPersistencePerspective(persistencePerspective);
    AdornedTargetCollectionMetadata metadata = new AdornedTargetCollectionMetadata();

    // Act and Assert
    assertSame(metadata, adornedTargetCollectionMetadata.populate(metadata));
  }

  /**
   * Method under test:
   * {@link AdornedTargetCollectionMetadata#populate(FieldMetadata)}
   */
  @Test
  public void testPopulate4() {
    // Arrange
    PersistencePerspective persistencePerspective = new PersistencePerspective();
    persistencePerspective.setAdditionalNonPersistentProperties(null);
    persistencePerspective.setAdditionalForeignKeys(null);
    persistencePerspective.setPersistencePerspectiveItems(new HashMap<>());
    persistencePerspective.setExcludeFields(null);
    persistencePerspective.setIncludeFields(null);

    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata = new AdornedTargetCollectionMetadata();
    adornedTargetCollectionMetadata.setPersistencePerspective(persistencePerspective);
    AdornedTargetCollectionMetadata metadata = new AdornedTargetCollectionMetadata();

    // Act and Assert
    assertSame(metadata, adornedTargetCollectionMetadata.populate(metadata));
  }

  /**
   * Method under test:
   * {@link AdornedTargetCollectionMetadata#populate(FieldMetadata)}
   */
  @Test
  public void testPopulate5() {
    // Arrange
    PersistencePerspective persistencePerspective = new PersistencePerspective();
    persistencePerspective.setAdditionalNonPersistentProperties(null);
    persistencePerspective.setAdditionalForeignKeys(new ForeignKey[]{new ForeignKey()});
    persistencePerspective.setPersistencePerspectiveItems(null);
    persistencePerspective.setExcludeFields(null);
    persistencePerspective.setIncludeFields(null);

    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata = new AdornedTargetCollectionMetadata();
    adornedTargetCollectionMetadata.setPersistencePerspective(persistencePerspective);
    AdornedTargetCollectionMetadata metadata = new AdornedTargetCollectionMetadata();

    // Act and Assert
    assertSame(metadata, adornedTargetCollectionMetadata.populate(metadata));
  }

  /**
   * Method under test:
   * {@link AdornedTargetCollectionMetadata#populate(FieldMetadata)}
   */
  @Test
  public void testPopulate6() {
    // Arrange
    PersistencePerspective persistencePerspective = new PersistencePerspective();
    persistencePerspective.setAdditionalNonPersistentProperties(new String[]{"foo"});
    persistencePerspective.setAdditionalForeignKeys(null);
    persistencePerspective.setPersistencePerspectiveItems(null);
    persistencePerspective.setExcludeFields(null);
    persistencePerspective.setIncludeFields(null);

    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata = new AdornedTargetCollectionMetadata();
    adornedTargetCollectionMetadata.setPersistencePerspective(persistencePerspective);
    AdornedTargetCollectionMetadata metadata = new AdornedTargetCollectionMetadata();

    // Act and Assert
    assertSame(metadata, adornedTargetCollectionMetadata.populate(metadata));
  }

  /**
   * Method under test:
   * {@link AdornedTargetCollectionMetadata#populate(FieldMetadata)}
   */
  @Test
  public void testPopulate7() {
    // Arrange
    PersistencePerspective persistencePerspective = new PersistencePerspective();
    persistencePerspective.setAdditionalNonPersistentProperties(null);
    persistencePerspective.setAdditionalForeignKeys(null);
    persistencePerspective.setPersistencePerspectiveItems(null);
    persistencePerspective.setExcludeFields(null);
    persistencePerspective.setIncludeFields(null);

    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata = new AdornedTargetCollectionMetadata();
    adornedTargetCollectionMetadata.setAvailableToTypes(new String[]{"Available To Types"});
    adornedTargetCollectionMetadata.setPersistencePerspective(persistencePerspective);
    AdornedTargetCollectionMetadata metadata = new AdornedTargetCollectionMetadata();

    // Act and Assert
    assertSame(metadata, adornedTargetCollectionMetadata.populate(metadata));
  }

  /**
   * Method under test:
   * {@link AdornedTargetCollectionMetadata#populate(FieldMetadata)}
   */
  @Test
  public void testPopulate8() {
    // Arrange
    HashMap<PersistencePerspectiveItemType, PersistencePerspectiveItem> persistencePerspectiveItems = new HashMap<>();
    persistencePerspectiveItems.put(PersistencePerspectiveItemType.FOREIGNKEY, new AdornedTargetList());

    PersistencePerspective persistencePerspective = new PersistencePerspective();
    persistencePerspective.setAdditionalNonPersistentProperties(null);
    persistencePerspective.setAdditionalForeignKeys(null);
    persistencePerspective.setPersistencePerspectiveItems(persistencePerspectiveItems);
    persistencePerspective.setExcludeFields(null);
    persistencePerspective.setIncludeFields(null);

    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata = new AdornedTargetCollectionMetadata();
    adornedTargetCollectionMetadata.setPersistencePerspective(persistencePerspective);
    AdornedTargetCollectionMetadata metadata = new AdornedTargetCollectionMetadata();

    // Act and Assert
    assertSame(metadata, adornedTargetCollectionMetadata.populate(metadata));
  }

  /**
   * Method under test:
   * {@link AdornedTargetCollectionMetadata#populate(FieldMetadata)}
   */
  @Test
  public void testPopulate9() {
    // Arrange
    HashMap<PersistencePerspectiveItemType, PersistencePerspectiveItem> persistencePerspectiveItems = new HashMap<>();
    persistencePerspectiveItems.computeIfPresent(PersistencePerspectiveItemType.FOREIGNKEY, mock(BiFunction.class));
    persistencePerspectiveItems.put(PersistencePerspectiveItemType.FOREIGNKEY, new AdornedTargetList());

    PersistencePerspective persistencePerspective = new PersistencePerspective();
    persistencePerspective.setAdditionalNonPersistentProperties(null);
    persistencePerspective.setAdditionalForeignKeys(null);
    persistencePerspective.setPersistencePerspectiveItems(persistencePerspectiveItems);
    persistencePerspective.setExcludeFields(null);
    persistencePerspective.setIncludeFields(null);

    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata = new AdornedTargetCollectionMetadata();
    adornedTargetCollectionMetadata.setPersistencePerspective(persistencePerspective);
    AdornedTargetCollectionMetadata metadata = new AdornedTargetCollectionMetadata();

    // Act and Assert
    assertSame(metadata, adornedTargetCollectionMetadata.populate(metadata));
  }

  /**
   * Method under test:
   * {@link AdornedTargetCollectionMetadata#cloneFieldMetadata()}
   */
  @Test
  public void testCloneFieldMetadata() {
    // Arrange
    PersistencePerspective persistencePerspective = new PersistencePerspective();
    persistencePerspective.setAdditionalNonPersistentProperties(null);
    persistencePerspective.setAdditionalForeignKeys(null);
    persistencePerspective.setPersistencePerspectiveItems(null);
    persistencePerspective.setExcludeFields(null);
    persistencePerspective.setIncludeFields(null);

    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata = new AdornedTargetCollectionMetadata();
    adornedTargetCollectionMetadata.setPersistencePerspective(persistencePerspective);

    // Act
    FieldMetadata actualCloneFieldMetadataResult = adornedTargetCollectionMetadata.cloneFieldMetadata();

    // Assert
    assertTrue(actualCloneFieldMetadataResult instanceof AdornedTargetCollectionMetadata);
    assertNull(((AdornedTargetCollectionMetadata) actualCloneFieldMetadataResult).getCustomCriteria());
    assertNull(actualCloneFieldMetadataResult.getAvailableToTypes());
    assertNull(actualCloneFieldMetadataResult.getChildrenExcluded());
    assertNull(actualCloneFieldMetadataResult.getExcluded());
    assertNull(actualCloneFieldMetadataResult.getLazyFetch());
    assertNull(actualCloneFieldMetadataResult.getGroupOrder());
    assertNull(actualCloneFieldMetadataResult.getOrder());
    assertNull(actualCloneFieldMetadataResult.getTabOrder());
    assertNull(((AdornedTargetCollectionMetadata) actualCloneFieldMetadataResult).getParentObjectClass());
    assertNull(((AdornedTargetCollectionMetadata) actualCloneFieldMetadataResult).getSelectizeVisibleField());
    assertNull(((AdornedTargetCollectionMetadata) actualCloneFieldMetadataResult).getCollectionCeilingEntity());
    assertNull(actualCloneFieldMetadataResult.getAddFriendlyName());
    assertNull(actualCloneFieldMetadataResult.getCurrencyCodeField());
    assertNull(actualCloneFieldMetadataResult.getFieldName());
    assertNull(actualCloneFieldMetadataResult.getFriendlyName());
    assertNull(actualCloneFieldMetadataResult.getGroup());
    assertNull(actualCloneFieldMetadataResult.getInheritedFromType());
    assertNull(actualCloneFieldMetadataResult.getOwningClass());
    assertNull(actualCloneFieldMetadataResult.getOwningClassFriendlyName());
    assertNull(actualCloneFieldMetadataResult.getPrefix());
    assertNull(actualCloneFieldMetadataResult.getSecurityLevel());
    assertNull(actualCloneFieldMetadataResult.getShowIfProperty());
    assertNull(actualCloneFieldMetadataResult.getTab());
    assertNull(actualCloneFieldMetadataResult.getTargetClass());
    PersistencePerspective persistencePerspective2 = ((AdornedTargetCollectionMetadata) actualCloneFieldMetadataResult)
        .getPersistencePerspective();
    assertNull(persistencePerspective2.getConfigurationKey());
    assertNull(actualCloneFieldMetadataResult.getShowIfFieldEquals());
    assertNull(((AdornedTargetCollectionMetadata) actualCloneFieldMetadataResult).getAdornedTargetAddMethodType());
    assertEquals(0, ((AdornedTargetCollectionMetadata) actualCloneFieldMetadataResult).getGridVisibleFields().length);
    assertEquals(0,
        ((AdornedTargetCollectionMetadata) actualCloneFieldMetadataResult).getMaintainedAdornedTargetFields().length);
    assertEquals(0, persistencePerspective2.getAdditionalForeignKeys().length);
    assertEquals(0, persistencePerspective2.getAdditionalNonPersistentProperties().length);
    assertEquals(0, persistencePerspective2.getExcludeFields().length);
    assertEquals(0, persistencePerspective2.getIncludeFields().length);
    OperationTypes operationTypes = persistencePerspective2.getOperationTypes();
    assertEquals(OperationType.BASIC, operationTypes.getAddType());
    assertEquals(OperationType.BASIC, operationTypes.getFetchType());
    assertEquals(OperationType.BASIC, operationTypes.getInspectType());
    assertEquals(OperationType.BASIC, operationTypes.getRemoveType());
    assertEquals(OperationType.BASIC, operationTypes.getUpdateType());
    assertFalse(((AdornedTargetCollectionMetadata) actualCloneFieldMetadataResult).isIgnoreAdornedProperties());
    assertFalse(actualCloneFieldMetadataResult.getManualFetch());
    assertFalse(persistencePerspective2.getPopulateToOneFields());
    assertFalse(persistencePerspective2.getShowArchivedFields());
    assertTrue(actualCloneFieldMetadataResult.getAdditionalMetadata().isEmpty());
    assertTrue(persistencePerspective2.getPersistencePerspectiveItems().isEmpty());
    assertTrue(((AdornedTargetCollectionMetadata) actualCloneFieldMetadataResult).isMutable());
    assertTrue(persistencePerspective2.getUseServerSideInspectionCache());
  }

  /**
   * Method under test:
   * {@link AdornedTargetCollectionMetadata#cloneFieldMetadata()}
   */
  @Test
  public void testCloneFieldMetadata2() {
    // Arrange
    PersistencePerspective persistencePerspective = new PersistencePerspective();
    persistencePerspective.setAdditionalNonPersistentProperties(null);
    persistencePerspective.setAdditionalForeignKeys(null);
    persistencePerspective.setPersistencePerspectiveItems(null);
    persistencePerspective.setExcludeFields(null);
    persistencePerspective.setIncludeFields(new String[]{"foo"});

    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata = new AdornedTargetCollectionMetadata();
    adornedTargetCollectionMetadata.setPersistencePerspective(persistencePerspective);

    // Act
    FieldMetadata actualCloneFieldMetadataResult = adornedTargetCollectionMetadata.cloneFieldMetadata();

    // Assert
    assertTrue(actualCloneFieldMetadataResult instanceof AdornedTargetCollectionMetadata);
    assertNull(((AdornedTargetCollectionMetadata) actualCloneFieldMetadataResult).getCustomCriteria());
    assertNull(actualCloneFieldMetadataResult.getAvailableToTypes());
    assertNull(actualCloneFieldMetadataResult.getChildrenExcluded());
    assertNull(actualCloneFieldMetadataResult.getExcluded());
    assertNull(actualCloneFieldMetadataResult.getLazyFetch());
    assertNull(actualCloneFieldMetadataResult.getGroupOrder());
    assertNull(actualCloneFieldMetadataResult.getOrder());
    assertNull(actualCloneFieldMetadataResult.getTabOrder());
    assertNull(((AdornedTargetCollectionMetadata) actualCloneFieldMetadataResult).getParentObjectClass());
    assertNull(((AdornedTargetCollectionMetadata) actualCloneFieldMetadataResult).getSelectizeVisibleField());
    assertNull(((AdornedTargetCollectionMetadata) actualCloneFieldMetadataResult).getCollectionCeilingEntity());
    assertNull(actualCloneFieldMetadataResult.getAddFriendlyName());
    assertNull(actualCloneFieldMetadataResult.getCurrencyCodeField());
    assertNull(actualCloneFieldMetadataResult.getFieldName());
    assertNull(actualCloneFieldMetadataResult.getFriendlyName());
    assertNull(actualCloneFieldMetadataResult.getGroup());
    assertNull(actualCloneFieldMetadataResult.getInheritedFromType());
    assertNull(actualCloneFieldMetadataResult.getOwningClass());
    assertNull(actualCloneFieldMetadataResult.getOwningClassFriendlyName());
    assertNull(actualCloneFieldMetadataResult.getPrefix());
    assertNull(actualCloneFieldMetadataResult.getSecurityLevel());
    assertNull(actualCloneFieldMetadataResult.getShowIfProperty());
    assertNull(actualCloneFieldMetadataResult.getTab());
    assertNull(actualCloneFieldMetadataResult.getTargetClass());
    PersistencePerspective persistencePerspective2 = ((AdornedTargetCollectionMetadata) actualCloneFieldMetadataResult)
        .getPersistencePerspective();
    assertNull(persistencePerspective2.getConfigurationKey());
    assertNull(actualCloneFieldMetadataResult.getShowIfFieldEquals());
    assertNull(((AdornedTargetCollectionMetadata) actualCloneFieldMetadataResult).getAdornedTargetAddMethodType());
    assertEquals(0, ((AdornedTargetCollectionMetadata) actualCloneFieldMetadataResult).getGridVisibleFields().length);
    assertEquals(0,
        ((AdornedTargetCollectionMetadata) actualCloneFieldMetadataResult).getMaintainedAdornedTargetFields().length);
    assertEquals(0, persistencePerspective2.getAdditionalForeignKeys().length);
    assertEquals(0, persistencePerspective2.getAdditionalNonPersistentProperties().length);
    assertEquals(0, persistencePerspective2.getExcludeFields().length);
    OperationTypes operationTypes = persistencePerspective2.getOperationTypes();
    assertEquals(OperationType.BASIC, operationTypes.getAddType());
    assertEquals(OperationType.BASIC, operationTypes.getFetchType());
    assertEquals(OperationType.BASIC, operationTypes.getInspectType());
    assertEquals(OperationType.BASIC, operationTypes.getRemoveType());
    assertEquals(OperationType.BASIC, operationTypes.getUpdateType());
    assertFalse(((AdornedTargetCollectionMetadata) actualCloneFieldMetadataResult).isIgnoreAdornedProperties());
    assertFalse(actualCloneFieldMetadataResult.getManualFetch());
    assertFalse(persistencePerspective2.getPopulateToOneFields());
    assertFalse(persistencePerspective2.getShowArchivedFields());
    assertTrue(actualCloneFieldMetadataResult.getAdditionalMetadata().isEmpty());
    assertTrue(persistencePerspective2.getPersistencePerspectiveItems().isEmpty());
    assertTrue(((AdornedTargetCollectionMetadata) actualCloneFieldMetadataResult).isMutable());
    assertTrue(persistencePerspective2.getUseServerSideInspectionCache());
    assertArrayEquals(new String[]{"foo"}, persistencePerspective2.getIncludeFields());
  }

  /**
   * Method under test:
   * {@link AdornedTargetCollectionMetadata#cloneFieldMetadata()}
   */
  @Test
  public void testCloneFieldMetadata3() {
    // Arrange
    PersistencePerspective persistencePerspective = new PersistencePerspective();
    persistencePerspective.setAdditionalNonPersistentProperties(null);
    persistencePerspective.setAdditionalForeignKeys(null);
    persistencePerspective.setPersistencePerspectiveItems(null);
    persistencePerspective.setExcludeFields(new String[]{"foo"});
    persistencePerspective.setIncludeFields(null);

    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata = new AdornedTargetCollectionMetadata();
    adornedTargetCollectionMetadata.setPersistencePerspective(persistencePerspective);

    // Act
    FieldMetadata actualCloneFieldMetadataResult = adornedTargetCollectionMetadata.cloneFieldMetadata();

    // Assert
    assertTrue(actualCloneFieldMetadataResult instanceof AdornedTargetCollectionMetadata);
    assertNull(((AdornedTargetCollectionMetadata) actualCloneFieldMetadataResult).getCustomCriteria());
    assertNull(actualCloneFieldMetadataResult.getAvailableToTypes());
    assertNull(actualCloneFieldMetadataResult.getChildrenExcluded());
    assertNull(actualCloneFieldMetadataResult.getExcluded());
    assertNull(actualCloneFieldMetadataResult.getLazyFetch());
    assertNull(actualCloneFieldMetadataResult.getGroupOrder());
    assertNull(actualCloneFieldMetadataResult.getOrder());
    assertNull(actualCloneFieldMetadataResult.getTabOrder());
    assertNull(((AdornedTargetCollectionMetadata) actualCloneFieldMetadataResult).getParentObjectClass());
    assertNull(((AdornedTargetCollectionMetadata) actualCloneFieldMetadataResult).getSelectizeVisibleField());
    assertNull(((AdornedTargetCollectionMetadata) actualCloneFieldMetadataResult).getCollectionCeilingEntity());
    assertNull(actualCloneFieldMetadataResult.getAddFriendlyName());
    assertNull(actualCloneFieldMetadataResult.getCurrencyCodeField());
    assertNull(actualCloneFieldMetadataResult.getFieldName());
    assertNull(actualCloneFieldMetadataResult.getFriendlyName());
    assertNull(actualCloneFieldMetadataResult.getGroup());
    assertNull(actualCloneFieldMetadataResult.getInheritedFromType());
    assertNull(actualCloneFieldMetadataResult.getOwningClass());
    assertNull(actualCloneFieldMetadataResult.getOwningClassFriendlyName());
    assertNull(actualCloneFieldMetadataResult.getPrefix());
    assertNull(actualCloneFieldMetadataResult.getSecurityLevel());
    assertNull(actualCloneFieldMetadataResult.getShowIfProperty());
    assertNull(actualCloneFieldMetadataResult.getTab());
    assertNull(actualCloneFieldMetadataResult.getTargetClass());
    PersistencePerspective persistencePerspective2 = ((AdornedTargetCollectionMetadata) actualCloneFieldMetadataResult)
        .getPersistencePerspective();
    assertNull(persistencePerspective2.getConfigurationKey());
    assertNull(actualCloneFieldMetadataResult.getShowIfFieldEquals());
    assertNull(((AdornedTargetCollectionMetadata) actualCloneFieldMetadataResult).getAdornedTargetAddMethodType());
    assertEquals(0, ((AdornedTargetCollectionMetadata) actualCloneFieldMetadataResult).getGridVisibleFields().length);
    assertEquals(0,
        ((AdornedTargetCollectionMetadata) actualCloneFieldMetadataResult).getMaintainedAdornedTargetFields().length);
    assertEquals(0, persistencePerspective2.getAdditionalForeignKeys().length);
    assertEquals(0, persistencePerspective2.getAdditionalNonPersistentProperties().length);
    assertEquals(0, persistencePerspective2.getIncludeFields().length);
    OperationTypes operationTypes = persistencePerspective2.getOperationTypes();
    assertEquals(OperationType.BASIC, operationTypes.getAddType());
    assertEquals(OperationType.BASIC, operationTypes.getFetchType());
    assertEquals(OperationType.BASIC, operationTypes.getInspectType());
    assertEquals(OperationType.BASIC, operationTypes.getRemoveType());
    assertEquals(OperationType.BASIC, operationTypes.getUpdateType());
    assertFalse(((AdornedTargetCollectionMetadata) actualCloneFieldMetadataResult).isIgnoreAdornedProperties());
    assertFalse(actualCloneFieldMetadataResult.getManualFetch());
    assertFalse(persistencePerspective2.getPopulateToOneFields());
    assertFalse(persistencePerspective2.getShowArchivedFields());
    assertTrue(actualCloneFieldMetadataResult.getAdditionalMetadata().isEmpty());
    assertTrue(persistencePerspective2.getPersistencePerspectiveItems().isEmpty());
    assertTrue(((AdornedTargetCollectionMetadata) actualCloneFieldMetadataResult).isMutable());
    assertTrue(persistencePerspective2.getUseServerSideInspectionCache());
    assertArrayEquals(new String[]{"foo"}, persistencePerspective2.getExcludeFields());
  }

  /**
   * Method under test:
   * {@link AdornedTargetCollectionMetadata#cloneFieldMetadata()}
   */
  @Test
  public void testCloneFieldMetadata4() {
    // Arrange
    PersistencePerspective persistencePerspective = new PersistencePerspective();
    persistencePerspective.setAdditionalNonPersistentProperties(null);
    persistencePerspective.setAdditionalForeignKeys(null);
    persistencePerspective.setPersistencePerspectiveItems(new HashMap<>());
    persistencePerspective.setExcludeFields(null);
    persistencePerspective.setIncludeFields(null);

    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata = new AdornedTargetCollectionMetadata();
    adornedTargetCollectionMetadata.setPersistencePerspective(persistencePerspective);

    // Act
    FieldMetadata actualCloneFieldMetadataResult = adornedTargetCollectionMetadata.cloneFieldMetadata();

    // Assert
    assertTrue(actualCloneFieldMetadataResult instanceof AdornedTargetCollectionMetadata);
    assertNull(((AdornedTargetCollectionMetadata) actualCloneFieldMetadataResult).getCustomCriteria());
    assertNull(actualCloneFieldMetadataResult.getAvailableToTypes());
    assertNull(actualCloneFieldMetadataResult.getChildrenExcluded());
    assertNull(actualCloneFieldMetadataResult.getExcluded());
    assertNull(actualCloneFieldMetadataResult.getLazyFetch());
    assertNull(actualCloneFieldMetadataResult.getGroupOrder());
    assertNull(actualCloneFieldMetadataResult.getOrder());
    assertNull(actualCloneFieldMetadataResult.getTabOrder());
    assertNull(((AdornedTargetCollectionMetadata) actualCloneFieldMetadataResult).getParentObjectClass());
    assertNull(((AdornedTargetCollectionMetadata) actualCloneFieldMetadataResult).getSelectizeVisibleField());
    assertNull(((AdornedTargetCollectionMetadata) actualCloneFieldMetadataResult).getCollectionCeilingEntity());
    assertNull(actualCloneFieldMetadataResult.getAddFriendlyName());
    assertNull(actualCloneFieldMetadataResult.getCurrencyCodeField());
    assertNull(actualCloneFieldMetadataResult.getFieldName());
    assertNull(actualCloneFieldMetadataResult.getFriendlyName());
    assertNull(actualCloneFieldMetadataResult.getGroup());
    assertNull(actualCloneFieldMetadataResult.getInheritedFromType());
    assertNull(actualCloneFieldMetadataResult.getOwningClass());
    assertNull(actualCloneFieldMetadataResult.getOwningClassFriendlyName());
    assertNull(actualCloneFieldMetadataResult.getPrefix());
    assertNull(actualCloneFieldMetadataResult.getSecurityLevel());
    assertNull(actualCloneFieldMetadataResult.getShowIfProperty());
    assertNull(actualCloneFieldMetadataResult.getTab());
    assertNull(actualCloneFieldMetadataResult.getTargetClass());
    PersistencePerspective persistencePerspective2 = ((AdornedTargetCollectionMetadata) actualCloneFieldMetadataResult)
        .getPersistencePerspective();
    assertNull(persistencePerspective2.getConfigurationKey());
    assertNull(actualCloneFieldMetadataResult.getShowIfFieldEquals());
    assertNull(((AdornedTargetCollectionMetadata) actualCloneFieldMetadataResult).getAdornedTargetAddMethodType());
    assertEquals(0, ((AdornedTargetCollectionMetadata) actualCloneFieldMetadataResult).getGridVisibleFields().length);
    assertEquals(0,
        ((AdornedTargetCollectionMetadata) actualCloneFieldMetadataResult).getMaintainedAdornedTargetFields().length);
    assertEquals(0, persistencePerspective2.getAdditionalForeignKeys().length);
    assertEquals(0, persistencePerspective2.getAdditionalNonPersistentProperties().length);
    assertEquals(0, persistencePerspective2.getExcludeFields().length);
    assertEquals(0, persistencePerspective2.getIncludeFields().length);
    OperationTypes operationTypes = persistencePerspective2.getOperationTypes();
    assertEquals(OperationType.BASIC, operationTypes.getAddType());
    assertEquals(OperationType.BASIC, operationTypes.getFetchType());
    assertEquals(OperationType.BASIC, operationTypes.getInspectType());
    assertEquals(OperationType.BASIC, operationTypes.getRemoveType());
    assertEquals(OperationType.BASIC, operationTypes.getUpdateType());
    assertFalse(((AdornedTargetCollectionMetadata) actualCloneFieldMetadataResult).isIgnoreAdornedProperties());
    assertFalse(actualCloneFieldMetadataResult.getManualFetch());
    assertFalse(persistencePerspective2.getPopulateToOneFields());
    assertFalse(persistencePerspective2.getShowArchivedFields());
    assertTrue(actualCloneFieldMetadataResult.getAdditionalMetadata().isEmpty());
    assertTrue(persistencePerspective2.getPersistencePerspectiveItems().isEmpty());
    assertTrue(((AdornedTargetCollectionMetadata) actualCloneFieldMetadataResult).isMutable());
    assertTrue(persistencePerspective2.getUseServerSideInspectionCache());
  }

  /**
   * Method under test:
   * {@link AdornedTargetCollectionMetadata#cloneFieldMetadata()}
   */
  @Test
  public void testCloneFieldMetadata5() {
    // Arrange
    PersistencePerspective persistencePerspective = new PersistencePerspective();
    persistencePerspective.setAdditionalNonPersistentProperties(null);
    ForeignKey foreignKey = new ForeignKey();
    persistencePerspective.setAdditionalForeignKeys(new ForeignKey[]{foreignKey});
    persistencePerspective.setPersistencePerspectiveItems(null);
    persistencePerspective.setExcludeFields(null);
    persistencePerspective.setIncludeFields(null);

    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata = new AdornedTargetCollectionMetadata();
    adornedTargetCollectionMetadata.setPersistencePerspective(persistencePerspective);

    // Act
    FieldMetadata actualCloneFieldMetadataResult = adornedTargetCollectionMetadata.cloneFieldMetadata();

    // Assert
    assertTrue(actualCloneFieldMetadataResult instanceof AdornedTargetCollectionMetadata);
    assertNull(((AdornedTargetCollectionMetadata) actualCloneFieldMetadataResult).getCustomCriteria());
    assertNull(actualCloneFieldMetadataResult.getAvailableToTypes());
    assertNull(actualCloneFieldMetadataResult.getChildrenExcluded());
    assertNull(actualCloneFieldMetadataResult.getExcluded());
    assertNull(actualCloneFieldMetadataResult.getLazyFetch());
    assertNull(actualCloneFieldMetadataResult.getGroupOrder());
    assertNull(actualCloneFieldMetadataResult.getOrder());
    assertNull(actualCloneFieldMetadataResult.getTabOrder());
    assertNull(((AdornedTargetCollectionMetadata) actualCloneFieldMetadataResult).getParentObjectClass());
    assertNull(((AdornedTargetCollectionMetadata) actualCloneFieldMetadataResult).getSelectizeVisibleField());
    assertNull(((AdornedTargetCollectionMetadata) actualCloneFieldMetadataResult).getCollectionCeilingEntity());
    assertNull(actualCloneFieldMetadataResult.getAddFriendlyName());
    assertNull(actualCloneFieldMetadataResult.getCurrencyCodeField());
    assertNull(actualCloneFieldMetadataResult.getFieldName());
    assertNull(actualCloneFieldMetadataResult.getFriendlyName());
    assertNull(actualCloneFieldMetadataResult.getGroup());
    assertNull(actualCloneFieldMetadataResult.getInheritedFromType());
    assertNull(actualCloneFieldMetadataResult.getOwningClass());
    assertNull(actualCloneFieldMetadataResult.getOwningClassFriendlyName());
    assertNull(actualCloneFieldMetadataResult.getPrefix());
    assertNull(actualCloneFieldMetadataResult.getSecurityLevel());
    assertNull(actualCloneFieldMetadataResult.getShowIfProperty());
    assertNull(actualCloneFieldMetadataResult.getTab());
    assertNull(actualCloneFieldMetadataResult.getTargetClass());
    PersistencePerspective persistencePerspective2 = ((AdornedTargetCollectionMetadata) actualCloneFieldMetadataResult)
        .getPersistencePerspective();
    assertNull(persistencePerspective2.getConfigurationKey());
    assertNull(actualCloneFieldMetadataResult.getShowIfFieldEquals());
    assertNull(((AdornedTargetCollectionMetadata) actualCloneFieldMetadataResult).getAdornedTargetAddMethodType());
    assertEquals(0, ((AdornedTargetCollectionMetadata) actualCloneFieldMetadataResult).getGridVisibleFields().length);
    assertEquals(0,
        ((AdornedTargetCollectionMetadata) actualCloneFieldMetadataResult).getMaintainedAdornedTargetFields().length);
    assertEquals(0, persistencePerspective2.getAdditionalNonPersistentProperties().length);
    assertEquals(0, persistencePerspective2.getExcludeFields().length);
    assertEquals(0, persistencePerspective2.getIncludeFields().length);
    ForeignKey[] additionalForeignKeys = persistencePerspective2.getAdditionalForeignKeys();
    assertEquals(1, additionalForeignKeys.length);
    OperationTypes operationTypes = persistencePerspective2.getOperationTypes();
    assertEquals(OperationType.BASIC, operationTypes.getAddType());
    assertEquals(OperationType.BASIC, operationTypes.getFetchType());
    assertEquals(OperationType.BASIC, operationTypes.getInspectType());
    assertEquals(OperationType.BASIC, operationTypes.getRemoveType());
    assertEquals(OperationType.BASIC, operationTypes.getUpdateType());
    assertFalse(((AdornedTargetCollectionMetadata) actualCloneFieldMetadataResult).isIgnoreAdornedProperties());
    assertFalse(actualCloneFieldMetadataResult.getManualFetch());
    assertFalse(persistencePerspective2.getPopulateToOneFields());
    assertFalse(persistencePerspective2.getShowArchivedFields());
    assertTrue(actualCloneFieldMetadataResult.getAdditionalMetadata().isEmpty());
    assertTrue(persistencePerspective2.getPersistencePerspectiveItems().isEmpty());
    assertTrue(((AdornedTargetCollectionMetadata) actualCloneFieldMetadataResult).isMutable());
    assertTrue(persistencePerspective2.getUseServerSideInspectionCache());
    assertEquals(foreignKey, additionalForeignKeys[0]);
  }

  /**
   * Method under test:
   * {@link AdornedTargetCollectionMetadata#cloneFieldMetadata()}
   */
  @Test
  public void testCloneFieldMetadata6() {
    // Arrange
    PersistencePerspective persistencePerspective = new PersistencePerspective();
    persistencePerspective.setAdditionalNonPersistentProperties(new String[]{"foo"});
    persistencePerspective.setAdditionalForeignKeys(null);
    persistencePerspective.setPersistencePerspectiveItems(null);
    persistencePerspective.setExcludeFields(null);
    persistencePerspective.setIncludeFields(null);

    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata = new AdornedTargetCollectionMetadata();
    adornedTargetCollectionMetadata.setPersistencePerspective(persistencePerspective);

    // Act
    FieldMetadata actualCloneFieldMetadataResult = adornedTargetCollectionMetadata.cloneFieldMetadata();

    // Assert
    assertTrue(actualCloneFieldMetadataResult instanceof AdornedTargetCollectionMetadata);
    assertNull(((AdornedTargetCollectionMetadata) actualCloneFieldMetadataResult).getCustomCriteria());
    assertNull(actualCloneFieldMetadataResult.getAvailableToTypes());
    assertNull(actualCloneFieldMetadataResult.getChildrenExcluded());
    assertNull(actualCloneFieldMetadataResult.getExcluded());
    assertNull(actualCloneFieldMetadataResult.getLazyFetch());
    assertNull(actualCloneFieldMetadataResult.getGroupOrder());
    assertNull(actualCloneFieldMetadataResult.getOrder());
    assertNull(actualCloneFieldMetadataResult.getTabOrder());
    assertNull(((AdornedTargetCollectionMetadata) actualCloneFieldMetadataResult).getParentObjectClass());
    assertNull(((AdornedTargetCollectionMetadata) actualCloneFieldMetadataResult).getSelectizeVisibleField());
    assertNull(((AdornedTargetCollectionMetadata) actualCloneFieldMetadataResult).getCollectionCeilingEntity());
    assertNull(actualCloneFieldMetadataResult.getAddFriendlyName());
    assertNull(actualCloneFieldMetadataResult.getCurrencyCodeField());
    assertNull(actualCloneFieldMetadataResult.getFieldName());
    assertNull(actualCloneFieldMetadataResult.getFriendlyName());
    assertNull(actualCloneFieldMetadataResult.getGroup());
    assertNull(actualCloneFieldMetadataResult.getInheritedFromType());
    assertNull(actualCloneFieldMetadataResult.getOwningClass());
    assertNull(actualCloneFieldMetadataResult.getOwningClassFriendlyName());
    assertNull(actualCloneFieldMetadataResult.getPrefix());
    assertNull(actualCloneFieldMetadataResult.getSecurityLevel());
    assertNull(actualCloneFieldMetadataResult.getShowIfProperty());
    assertNull(actualCloneFieldMetadataResult.getTab());
    assertNull(actualCloneFieldMetadataResult.getTargetClass());
    PersistencePerspective persistencePerspective2 = ((AdornedTargetCollectionMetadata) actualCloneFieldMetadataResult)
        .getPersistencePerspective();
    assertNull(persistencePerspective2.getConfigurationKey());
    assertNull(actualCloneFieldMetadataResult.getShowIfFieldEquals());
    assertNull(((AdornedTargetCollectionMetadata) actualCloneFieldMetadataResult).getAdornedTargetAddMethodType());
    assertEquals(0, ((AdornedTargetCollectionMetadata) actualCloneFieldMetadataResult).getGridVisibleFields().length);
    assertEquals(0,
        ((AdornedTargetCollectionMetadata) actualCloneFieldMetadataResult).getMaintainedAdornedTargetFields().length);
    assertEquals(0, persistencePerspective2.getAdditionalForeignKeys().length);
    assertEquals(0, persistencePerspective2.getExcludeFields().length);
    assertEquals(0, persistencePerspective2.getIncludeFields().length);
    OperationTypes operationTypes = persistencePerspective2.getOperationTypes();
    assertEquals(OperationType.BASIC, operationTypes.getAddType());
    assertEquals(OperationType.BASIC, operationTypes.getFetchType());
    assertEquals(OperationType.BASIC, operationTypes.getInspectType());
    assertEquals(OperationType.BASIC, operationTypes.getRemoveType());
    assertEquals(OperationType.BASIC, operationTypes.getUpdateType());
    assertFalse(((AdornedTargetCollectionMetadata) actualCloneFieldMetadataResult).isIgnoreAdornedProperties());
    assertFalse(actualCloneFieldMetadataResult.getManualFetch());
    assertFalse(persistencePerspective2.getPopulateToOneFields());
    assertFalse(persistencePerspective2.getShowArchivedFields());
    assertTrue(actualCloneFieldMetadataResult.getAdditionalMetadata().isEmpty());
    assertTrue(persistencePerspective2.getPersistencePerspectiveItems().isEmpty());
    assertTrue(((AdornedTargetCollectionMetadata) actualCloneFieldMetadataResult).isMutable());
    assertTrue(persistencePerspective2.getUseServerSideInspectionCache());
    assertArrayEquals(new String[]{"foo"}, persistencePerspective2.getAdditionalNonPersistentProperties());
  }

  /**
   * Method under test:
   * {@link AdornedTargetCollectionMetadata#cloneFieldMetadata()}
   */
  @Test
  public void testCloneFieldMetadata7() {
    // Arrange
    HashMap<PersistencePerspectiveItemType, PersistencePerspectiveItem> persistencePerspectiveItems = new HashMap<>();
    persistencePerspectiveItems.put(PersistencePerspectiveItemType.FOREIGNKEY, new AdornedTargetList());

    PersistencePerspective persistencePerspective = new PersistencePerspective();
    persistencePerspective.setAdditionalNonPersistentProperties(null);
    persistencePerspective.setAdditionalForeignKeys(null);
    persistencePerspective.setPersistencePerspectiveItems(persistencePerspectiveItems);
    persistencePerspective.setExcludeFields(null);
    persistencePerspective.setIncludeFields(null);

    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata = new AdornedTargetCollectionMetadata();
    adornedTargetCollectionMetadata.setPersistencePerspective(persistencePerspective);

    // Act
    FieldMetadata actualCloneFieldMetadataResult = adornedTargetCollectionMetadata.cloneFieldMetadata();

    // Assert
    assertTrue(actualCloneFieldMetadataResult instanceof AdornedTargetCollectionMetadata);
    assertNull(((AdornedTargetCollectionMetadata) actualCloneFieldMetadataResult).getCustomCriteria());
    assertNull(actualCloneFieldMetadataResult.getAvailableToTypes());
    assertNull(actualCloneFieldMetadataResult.getChildrenExcluded());
    assertNull(actualCloneFieldMetadataResult.getExcluded());
    assertNull(actualCloneFieldMetadataResult.getLazyFetch());
    assertNull(actualCloneFieldMetadataResult.getGroupOrder());
    assertNull(actualCloneFieldMetadataResult.getOrder());
    assertNull(actualCloneFieldMetadataResult.getTabOrder());
    assertNull(((AdornedTargetCollectionMetadata) actualCloneFieldMetadataResult).getParentObjectClass());
    assertNull(((AdornedTargetCollectionMetadata) actualCloneFieldMetadataResult).getSelectizeVisibleField());
    assertNull(((AdornedTargetCollectionMetadata) actualCloneFieldMetadataResult).getCollectionCeilingEntity());
    assertNull(actualCloneFieldMetadataResult.getAddFriendlyName());
    assertNull(actualCloneFieldMetadataResult.getCurrencyCodeField());
    assertNull(actualCloneFieldMetadataResult.getFieldName());
    assertNull(actualCloneFieldMetadataResult.getFriendlyName());
    assertNull(actualCloneFieldMetadataResult.getGroup());
    assertNull(actualCloneFieldMetadataResult.getInheritedFromType());
    assertNull(actualCloneFieldMetadataResult.getOwningClass());
    assertNull(actualCloneFieldMetadataResult.getOwningClassFriendlyName());
    assertNull(actualCloneFieldMetadataResult.getPrefix());
    assertNull(actualCloneFieldMetadataResult.getSecurityLevel());
    assertNull(actualCloneFieldMetadataResult.getShowIfProperty());
    assertNull(actualCloneFieldMetadataResult.getTab());
    assertNull(actualCloneFieldMetadataResult.getTargetClass());
    PersistencePerspective persistencePerspective2 = ((AdornedTargetCollectionMetadata) actualCloneFieldMetadataResult)
        .getPersistencePerspective();
    assertNull(persistencePerspective2.getConfigurationKey());
    assertNull(actualCloneFieldMetadataResult.getShowIfFieldEquals());
    assertNull(((AdornedTargetCollectionMetadata) actualCloneFieldMetadataResult).getAdornedTargetAddMethodType());
    assertEquals(0, ((AdornedTargetCollectionMetadata) actualCloneFieldMetadataResult).getGridVisibleFields().length);
    assertEquals(0,
        ((AdornedTargetCollectionMetadata) actualCloneFieldMetadataResult).getMaintainedAdornedTargetFields().length);
    assertEquals(0, persistencePerspective2.getAdditionalForeignKeys().length);
    assertEquals(0, persistencePerspective2.getAdditionalNonPersistentProperties().length);
    assertEquals(0, persistencePerspective2.getExcludeFields().length);
    assertEquals(0, persistencePerspective2.getIncludeFields().length);
    OperationTypes operationTypes = persistencePerspective2.getOperationTypes();
    assertEquals(OperationType.BASIC, operationTypes.getAddType());
    assertEquals(OperationType.BASIC, operationTypes.getFetchType());
    assertEquals(OperationType.BASIC, operationTypes.getInspectType());
    assertEquals(OperationType.BASIC, operationTypes.getRemoveType());
    assertEquals(OperationType.BASIC, operationTypes.getUpdateType());
    assertFalse(((AdornedTargetCollectionMetadata) actualCloneFieldMetadataResult).isIgnoreAdornedProperties());
    assertFalse(actualCloneFieldMetadataResult.getManualFetch());
    assertFalse(persistencePerspective2.getPopulateToOneFields());
    assertFalse(persistencePerspective2.getShowArchivedFields());
    assertTrue(actualCloneFieldMetadataResult.getAdditionalMetadata().isEmpty());
    assertTrue(((AdornedTargetCollectionMetadata) actualCloneFieldMetadataResult).isMutable());
    assertTrue(persistencePerspective2.getUseServerSideInspectionCache());
    assertEquals(persistencePerspectiveItems, persistencePerspective2.getPersistencePerspectiveItems());
  }

  /**
   * Method under test:
   * {@link AdornedTargetCollectionMetadata#cloneFieldMetadata()}
   */
  @Test
  public void testCloneFieldMetadata8() {
    // Arrange
    HashMap<PersistencePerspectiveItemType, PersistencePerspectiveItem> persistencePerspectiveItems = new HashMap<>();
    persistencePerspectiveItems.computeIfPresent(PersistencePerspectiveItemType.FOREIGNKEY, mock(BiFunction.class));
    persistencePerspectiveItems.put(PersistencePerspectiveItemType.FOREIGNKEY, new AdornedTargetList());

    PersistencePerspective persistencePerspective = new PersistencePerspective();
    persistencePerspective.setAdditionalNonPersistentProperties(null);
    persistencePerspective.setAdditionalForeignKeys(null);
    persistencePerspective.setPersistencePerspectiveItems(persistencePerspectiveItems);
    persistencePerspective.setExcludeFields(null);
    persistencePerspective.setIncludeFields(null);

    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata = new AdornedTargetCollectionMetadata();
    adornedTargetCollectionMetadata.setPersistencePerspective(persistencePerspective);

    // Act
    FieldMetadata actualCloneFieldMetadataResult = adornedTargetCollectionMetadata.cloneFieldMetadata();

    // Assert
    assertTrue(actualCloneFieldMetadataResult instanceof AdornedTargetCollectionMetadata);
    assertNull(((AdornedTargetCollectionMetadata) actualCloneFieldMetadataResult).getCustomCriteria());
    assertNull(actualCloneFieldMetadataResult.getAvailableToTypes());
    assertNull(actualCloneFieldMetadataResult.getChildrenExcluded());
    assertNull(actualCloneFieldMetadataResult.getExcluded());
    assertNull(actualCloneFieldMetadataResult.getLazyFetch());
    assertNull(actualCloneFieldMetadataResult.getGroupOrder());
    assertNull(actualCloneFieldMetadataResult.getOrder());
    assertNull(actualCloneFieldMetadataResult.getTabOrder());
    assertNull(((AdornedTargetCollectionMetadata) actualCloneFieldMetadataResult).getParentObjectClass());
    assertNull(((AdornedTargetCollectionMetadata) actualCloneFieldMetadataResult).getSelectizeVisibleField());
    assertNull(((AdornedTargetCollectionMetadata) actualCloneFieldMetadataResult).getCollectionCeilingEntity());
    assertNull(actualCloneFieldMetadataResult.getAddFriendlyName());
    assertNull(actualCloneFieldMetadataResult.getCurrencyCodeField());
    assertNull(actualCloneFieldMetadataResult.getFieldName());
    assertNull(actualCloneFieldMetadataResult.getFriendlyName());
    assertNull(actualCloneFieldMetadataResult.getGroup());
    assertNull(actualCloneFieldMetadataResult.getInheritedFromType());
    assertNull(actualCloneFieldMetadataResult.getOwningClass());
    assertNull(actualCloneFieldMetadataResult.getOwningClassFriendlyName());
    assertNull(actualCloneFieldMetadataResult.getPrefix());
    assertNull(actualCloneFieldMetadataResult.getSecurityLevel());
    assertNull(actualCloneFieldMetadataResult.getShowIfProperty());
    assertNull(actualCloneFieldMetadataResult.getTab());
    assertNull(actualCloneFieldMetadataResult.getTargetClass());
    PersistencePerspective persistencePerspective2 = ((AdornedTargetCollectionMetadata) actualCloneFieldMetadataResult)
        .getPersistencePerspective();
    assertNull(persistencePerspective2.getConfigurationKey());
    assertNull(actualCloneFieldMetadataResult.getShowIfFieldEquals());
    assertNull(((AdornedTargetCollectionMetadata) actualCloneFieldMetadataResult).getAdornedTargetAddMethodType());
    assertEquals(0, ((AdornedTargetCollectionMetadata) actualCloneFieldMetadataResult).getGridVisibleFields().length);
    assertEquals(0,
        ((AdornedTargetCollectionMetadata) actualCloneFieldMetadataResult).getMaintainedAdornedTargetFields().length);
    assertEquals(0, persistencePerspective2.getAdditionalForeignKeys().length);
    assertEquals(0, persistencePerspective2.getAdditionalNonPersistentProperties().length);
    assertEquals(0, persistencePerspective2.getExcludeFields().length);
    assertEquals(0, persistencePerspective2.getIncludeFields().length);
    OperationTypes operationTypes = persistencePerspective2.getOperationTypes();
    assertEquals(OperationType.BASIC, operationTypes.getAddType());
    assertEquals(OperationType.BASIC, operationTypes.getFetchType());
    assertEquals(OperationType.BASIC, operationTypes.getInspectType());
    assertEquals(OperationType.BASIC, operationTypes.getRemoveType());
    assertEquals(OperationType.BASIC, operationTypes.getUpdateType());
    assertFalse(((AdornedTargetCollectionMetadata) actualCloneFieldMetadataResult).isIgnoreAdornedProperties());
    assertFalse(actualCloneFieldMetadataResult.getManualFetch());
    assertFalse(persistencePerspective2.getPopulateToOneFields());
    assertFalse(persistencePerspective2.getShowArchivedFields());
    assertTrue(actualCloneFieldMetadataResult.getAdditionalMetadata().isEmpty());
    assertTrue(((AdornedTargetCollectionMetadata) actualCloneFieldMetadataResult).isMutable());
    assertTrue(persistencePerspective2.getUseServerSideInspectionCache());
    assertEquals(persistencePerspectiveItems, persistencePerspective2.getPersistencePerspectiveItems());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link AdornedTargetCollectionMetadata#equals(Object)}
   *   <li>{@link AdornedTargetCollectionMetadata#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata = new AdornedTargetCollectionMetadata();
    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata2 = new AdornedTargetCollectionMetadata();

    // Act and Assert
    assertEquals(adornedTargetCollectionMetadata, adornedTargetCollectionMetadata2);
    int expectedHashCodeResult = adornedTargetCollectionMetadata.hashCode();
    assertEquals(expectedHashCodeResult, adornedTargetCollectionMetadata2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link AdornedTargetCollectionMetadata#equals(Object)}
   *   <li>{@link AdornedTargetCollectionMetadata#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata = new AdornedTargetCollectionMetadata();
    adornedTargetCollectionMetadata.setParentObjectClass("Parent Object Class");

    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata2 = new AdornedTargetCollectionMetadata();
    adornedTargetCollectionMetadata2.setParentObjectClass("Parent Object Class");

    // Act and Assert
    assertEquals(adornedTargetCollectionMetadata, adornedTargetCollectionMetadata2);
    int expectedHashCodeResult = adornedTargetCollectionMetadata.hashCode();
    assertEquals(expectedHashCodeResult, adornedTargetCollectionMetadata2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link AdornedTargetCollectionMetadata#equals(Object)}
   *   <li>{@link AdornedTargetCollectionMetadata#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata = new AdornedTargetCollectionMetadata();
    adornedTargetCollectionMetadata.setSelectizeVisibleField("Selectize Visible Field");

    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata2 = new AdornedTargetCollectionMetadata();
    adornedTargetCollectionMetadata2.setSelectizeVisibleField("Selectize Visible Field");

    // Act and Assert
    assertEquals(adornedTargetCollectionMetadata, adornedTargetCollectionMetadata2);
    int expectedHashCodeResult = adornedTargetCollectionMetadata.hashCode();
    assertEquals(expectedHashCodeResult, adornedTargetCollectionMetadata2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link AdornedTargetCollectionMetadata#equals(Object)}
   *   <li>{@link AdornedTargetCollectionMetadata#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata = new AdornedTargetCollectionMetadata();

    // Act and Assert
    assertEquals(adornedTargetCollectionMetadata, adornedTargetCollectionMetadata);
    int expectedHashCodeResult = adornedTargetCollectionMetadata.hashCode();
    assertEquals(expectedHashCodeResult, adornedTargetCollectionMetadata.hashCode());
  }

  /**
   * Method under test: {@link AdornedTargetCollectionMetadata#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new AdornedTargetCollectionMetadata(), 1);
    assertNotEquals(new AdornedTargetCollectionMetadata(), mock(BasicCollectionMetadata.class));
  }

  /**
   * Method under test: {@link AdornedTargetCollectionMetadata#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata = new AdornedTargetCollectionMetadata();
    adornedTargetCollectionMetadata.setIgnoreAdornedProperties(true);

    // Act and Assert
    assertNotEquals(adornedTargetCollectionMetadata, new AdornedTargetCollectionMetadata());
  }

  /**
   * Method under test: {@link AdornedTargetCollectionMetadata#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata = new AdornedTargetCollectionMetadata();
    adornedTargetCollectionMetadata.setParentObjectClass("Parent Object Class");

    // Act and Assert
    assertNotEquals(adornedTargetCollectionMetadata, new AdornedTargetCollectionMetadata());
  }

  /**
   * Method under test: {@link AdornedTargetCollectionMetadata#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata = new AdornedTargetCollectionMetadata();
    adornedTargetCollectionMetadata.setGridVisibleFields(new String[]{"Grid Visible Fields"});

    // Act and Assert
    assertNotEquals(adornedTargetCollectionMetadata, new AdornedTargetCollectionMetadata());
  }

  /**
   * Method under test: {@link AdornedTargetCollectionMetadata#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata = new AdornedTargetCollectionMetadata();
    adornedTargetCollectionMetadata.setSelectizeVisibleField("Selectize Visible Field");

    // Act and Assert
    assertNotEquals(adornedTargetCollectionMetadata, new AdornedTargetCollectionMetadata());
  }

  /**
   * Method under test: {@link AdornedTargetCollectionMetadata#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata = new AdornedTargetCollectionMetadata();
    adornedTargetCollectionMetadata.setMaintainedAdornedTargetFields(new String[]{"Maintained Adorned Target Fields"});

    // Act and Assert
    assertNotEquals(adornedTargetCollectionMetadata, new AdornedTargetCollectionMetadata());
  }

  /**
   * Method under test: {@link AdornedTargetCollectionMetadata#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata = new AdornedTargetCollectionMetadata();
    adornedTargetCollectionMetadata.setPersistencePerspective(new PersistencePerspective());

    // Act and Assert
    assertNotEquals(adornedTargetCollectionMetadata, new AdornedTargetCollectionMetadata());
  }

  /**
   * Method under test: {@link AdornedTargetCollectionMetadata#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata = new AdornedTargetCollectionMetadata();

    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata2 = new AdornedTargetCollectionMetadata();
    adornedTargetCollectionMetadata2.setParentObjectClass("Parent Object Class");

    // Act and Assert
    assertNotEquals(adornedTargetCollectionMetadata, adornedTargetCollectionMetadata2);
  }

  /**
   * Method under test: {@link AdornedTargetCollectionMetadata#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata = new AdornedTargetCollectionMetadata();

    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata2 = new AdornedTargetCollectionMetadata();
    adornedTargetCollectionMetadata2.setSelectizeVisibleField("Selectize Visible Field");

    // Act and Assert
    assertNotEquals(adornedTargetCollectionMetadata, adornedTargetCollectionMetadata2);
  }

  /**
   * Method under test: {@link AdornedTargetCollectionMetadata#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new AdornedTargetCollectionMetadata(), null);
  }

  /**
   * Method under test: {@link AdornedTargetCollectionMetadata#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new AdornedTargetCollectionMetadata(), "Different type to AdornedTargetCollectionMetadata");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link AdornedTargetCollectionMetadata#setAdornedTargetAddMethodType(AdornedTargetAddMethodType)}
   *   <li>{@link AdornedTargetCollectionMetadata#setGridVisibleFields(String[])}
   *   <li>
   * {@link AdornedTargetCollectionMetadata#setIgnoreAdornedProperties(boolean)}
   *   <li>
   * {@link AdornedTargetCollectionMetadata#setMaintainedAdornedTargetFields(String[])}
   *   <li>{@link AdornedTargetCollectionMetadata#setParentObjectClass(String)}
   *   <li>{@link AdornedTargetCollectionMetadata#setSelectizeVisibleField(String)}
   *   <li>{@link AdornedTargetCollectionMetadata#getAdornedTargetAddMethodType()}
   *   <li>{@link AdornedTargetCollectionMetadata#getGridVisibleFields()}
   *   <li>
   * {@link AdornedTargetCollectionMetadata#getMaintainedAdornedTargetFields()}
   *   <li>{@link AdornedTargetCollectionMetadata#getParentObjectClass()}
   *   <li>{@link AdornedTargetCollectionMetadata#getSelectizeVisibleField()}
   *   <li>{@link AdornedTargetCollectionMetadata#isIgnoreAdornedProperties()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata = new AdornedTargetCollectionMetadata();

    // Act
    adornedTargetCollectionMetadata.setAdornedTargetAddMethodType(AdornedTargetAddMethodType.LOOKUP);
    String[] gridVisibleFields = new String[]{"Grid Visible Fields"};
    adornedTargetCollectionMetadata.setGridVisibleFields(gridVisibleFields);
    adornedTargetCollectionMetadata.setIgnoreAdornedProperties(true);
    String[] maintainedAdornedTargetFields = new String[]{"Maintained Adorned Target Fields"};
    adornedTargetCollectionMetadata.setMaintainedAdornedTargetFields(maintainedAdornedTargetFields);
    adornedTargetCollectionMetadata.setParentObjectClass("Parent Object Class");
    adornedTargetCollectionMetadata.setSelectizeVisibleField("Selectize Visible Field");
    AdornedTargetAddMethodType actualAdornedTargetAddMethodType = adornedTargetCollectionMetadata
        .getAdornedTargetAddMethodType();
    String[] actualGridVisibleFields = adornedTargetCollectionMetadata.getGridVisibleFields();
    String[] actualMaintainedAdornedTargetFields = adornedTargetCollectionMetadata.getMaintainedAdornedTargetFields();
    String actualParentObjectClass = adornedTargetCollectionMetadata.getParentObjectClass();
    String actualSelectizeVisibleField = adornedTargetCollectionMetadata.getSelectizeVisibleField();

    // Assert that nothing has changed
    assertEquals("Parent Object Class", actualParentObjectClass);
    assertEquals("Selectize Visible Field", actualSelectizeVisibleField);
    assertEquals(AdornedTargetAddMethodType.LOOKUP, actualAdornedTargetAddMethodType);
    assertTrue(adornedTargetCollectionMetadata.isIgnoreAdornedProperties());
    assertSame(gridVisibleFields, actualGridVisibleFields);
    assertSame(maintainedAdornedTargetFields, actualMaintainedAdornedTargetFields);
    assertArrayEquals(new String[]{"Grid Visible Fields"}, actualGridVisibleFields);
    assertArrayEquals(new String[]{"Maintained Adorned Target Fields"}, actualMaintainedAdornedTargetFields);
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link AdornedTargetCollectionMetadata}
   */
  @Test
  public void testNewAdornedTargetCollectionMetadata() {
    // Arrange and Act
    AdornedTargetCollectionMetadata actualAdornedTargetCollectionMetadata = new AdornedTargetCollectionMetadata();

    // Assert
    assertNull(actualAdornedTargetCollectionMetadata.getCustomCriteria());
    assertNull(actualAdornedTargetCollectionMetadata.getAvailableToTypes());
    assertNull(actualAdornedTargetCollectionMetadata.getChildrenExcluded());
    assertNull(actualAdornedTargetCollectionMetadata.getExcluded());
    assertNull(actualAdornedTargetCollectionMetadata.getLazyFetch());
    assertNull(actualAdornedTargetCollectionMetadata.getGroupOrder());
    assertNull(actualAdornedTargetCollectionMetadata.getOrder());
    assertNull(actualAdornedTargetCollectionMetadata.getTabOrder());
    assertNull(actualAdornedTargetCollectionMetadata.getParentObjectClass());
    assertNull(actualAdornedTargetCollectionMetadata.getSelectizeVisibleField());
    assertNull(actualAdornedTargetCollectionMetadata.getCollectionCeilingEntity());
    assertNull(actualAdornedTargetCollectionMetadata.getAddFriendlyName());
    assertNull(actualAdornedTargetCollectionMetadata.getCurrencyCodeField());
    assertNull(actualAdornedTargetCollectionMetadata.getFieldName());
    assertNull(actualAdornedTargetCollectionMetadata.getFriendlyName());
    assertNull(actualAdornedTargetCollectionMetadata.getGroup());
    assertNull(actualAdornedTargetCollectionMetadata.getInheritedFromType());
    assertNull(actualAdornedTargetCollectionMetadata.getOwningClass());
    assertNull(actualAdornedTargetCollectionMetadata.getOwningClassFriendlyName());
    assertNull(actualAdornedTargetCollectionMetadata.getPrefix());
    assertNull(actualAdornedTargetCollectionMetadata.getSecurityLevel());
    assertNull(actualAdornedTargetCollectionMetadata.getShowIfProperty());
    assertNull(actualAdornedTargetCollectionMetadata.getTab());
    assertNull(actualAdornedTargetCollectionMetadata.getTargetClass());
    assertNull(actualAdornedTargetCollectionMetadata.getShowIfFieldEquals());
    assertNull(actualAdornedTargetCollectionMetadata.getAdornedTargetAddMethodType());
    assertNull(actualAdornedTargetCollectionMetadata.getPersistencePerspective());
    assertEquals(0, actualAdornedTargetCollectionMetadata.getGridVisibleFields().length);
    assertEquals(0, actualAdornedTargetCollectionMetadata.getMaintainedAdornedTargetFields().length);
    assertFalse(actualAdornedTargetCollectionMetadata.isIgnoreAdornedProperties());
    assertFalse(actualAdornedTargetCollectionMetadata.getManualFetch());
    assertTrue(actualAdornedTargetCollectionMetadata.getAdditionalMetadata().isEmpty());
    assertTrue(actualAdornedTargetCollectionMetadata.isMutable());
  }
}
