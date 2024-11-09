/*-
 * #%L
 * BroadleafCommerce CMS Module
 * %%
 * Copyright (C) 2009 - 2024 Broadleaf Commerce
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
package org.broadleafcommerce.cms.structure.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import org.broadleafcommerce.cms.field.domain.FieldGroup;
import org.broadleafcommerce.cms.field.domain.FieldGroupImpl;
import org.broadleafcommerce.common.copy.CreateResponse;
import org.broadleafcommerce.common.copy.MultiTenantCopierExtensionManager;
import org.broadleafcommerce.common.copy.MultiTenantCopyContext;
import org.broadleafcommerce.common.service.GenericEntityService;
import org.broadleafcommerce.common.site.domain.CatalogImpl;
import org.broadleafcommerce.common.site.domain.SiteImpl;
import org.junit.Test;
import org.mockito.Mockito;

public class StructuredContentFieldTemplateImplDiffblueTest {
  /**
   * Test {@link StructuredContentFieldTemplateImpl#getFieldGroups()}.
   * <ul>
   *   <li>Given {@link StructuredContentFieldTemplateImpl} (default constructor) Id
   * is {@link StructuredContentItemCriteriaImpl#serialVersionUID}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link StructuredContentFieldTemplateImpl#getFieldGroups()}
   */
  @Test
  public void testGetFieldGroups_givenStructuredContentFieldTemplateImplIdIsSerialVersionUID() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StructuredContentFieldTemplateImpl structuredContentFieldTemplateImpl = new StructuredContentFieldTemplateImpl();
    structuredContentFieldTemplateImpl.setId(StructuredContentItemCriteriaImpl.serialVersionUID);
    structuredContentFieldTemplateImpl.setName("Name");
    structuredContentFieldTemplateImpl.setFieldGroupXrefs(null);

    // Act and Assert
    assertTrue(structuredContentFieldTemplateImpl.getFieldGroups().isEmpty());
  }

  /**
   * Test {@link StructuredContentFieldTemplateImpl#getFieldGroups()}.
   * <ul>
   *   <li>Given {@link StructuredContentFieldTemplateImpl} (default
   * constructor).</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link StructuredContentFieldTemplateImpl#getFieldGroups()}
   */
  @Test
  public void testGetFieldGroups_givenStructuredContentFieldTemplateImpl_thenReturnEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new StructuredContentFieldTemplateImpl()).getFieldGroups().isEmpty());
  }

  /**
   * Test {@link StructuredContentFieldTemplateImpl#getFieldGroups()}.
   * <ul>
   *   <li>Then return first is {@link FieldGroupImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link StructuredContentFieldTemplateImpl#getFieldGroups()}
   */
  @Test
  public void testGetFieldGroups_thenReturnFirstIsFieldGroupImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StructuredContentFieldGroupXrefImpl structuredContentFieldGroupXrefImpl = mock(
        StructuredContentFieldGroupXrefImpl.class);
    FieldGroupImpl fieldGroupImpl = new FieldGroupImpl();
    when(structuredContentFieldGroupXrefImpl.getFieldGroup()).thenReturn(fieldGroupImpl);

    ArrayList<StructuredContentFieldGroupXref> fieldGroupXrefs = new ArrayList<>();
    fieldGroupXrefs.add(structuredContentFieldGroupXrefImpl);

    StructuredContentFieldTemplateImpl structuredContentFieldTemplateImpl = new StructuredContentFieldTemplateImpl();
    structuredContentFieldTemplateImpl.setFieldGroupXrefs(fieldGroupXrefs);

    // Act
    List<FieldGroup> actualFieldGroups = structuredContentFieldTemplateImpl.getFieldGroups();

    // Assert
    verify(structuredContentFieldGroupXrefImpl).getFieldGroup();
    assertEquals(1, actualFieldGroups.size());
    assertSame(fieldGroupImpl, actualFieldGroups.get(0));
  }

  /**
   * Test {@link StructuredContentFieldTemplateImpl#getFieldGroups()}.
   * <ul>
   *   <li>Then return first is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link StructuredContentFieldTemplateImpl#getFieldGroups()}
   */
  @Test
  public void testGetFieldGroups_thenReturnFirstIsNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ArrayList<StructuredContentFieldGroupXref> fieldGroupXrefs = new ArrayList<>();
    fieldGroupXrefs.add(new StructuredContentFieldGroupXrefImpl());

    StructuredContentFieldTemplateImpl structuredContentFieldTemplateImpl = new StructuredContentFieldTemplateImpl();
    structuredContentFieldTemplateImpl.setFieldGroupXrefs(fieldGroupXrefs);

    // Act
    List<FieldGroup> actualFieldGroups = structuredContentFieldTemplateImpl.getFieldGroups();

    // Assert
    assertEquals(1, actualFieldGroups.size());
    assertNull(actualFieldGroups.get(0));
  }

  /**
   * Test {@link StructuredContentFieldTemplateImpl#setFieldGroups(List)}.
   * <ul>
   *   <li>Given {@link FieldGroupImpl} (default constructor).</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link FieldGroupImpl} (default
   * constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link StructuredContentFieldTemplateImpl#setFieldGroups(List)}
   */
  @Test
  public void testSetFieldGroups_givenFieldGroupImpl_whenArrayListAddFieldGroupImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StructuredContentFieldTemplateImpl structuredContentFieldTemplateImpl = new StructuredContentFieldTemplateImpl();

    ArrayList<FieldGroup> fieldGroups = new ArrayList<>();
    fieldGroups.add(new FieldGroupImpl());

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> structuredContentFieldTemplateImpl.setFieldGroups(fieldGroups));
  }

  /**
   * Test {@link StructuredContentFieldTemplateImpl#setFieldGroups(List)}.
   * <ul>
   *   <li>Given {@link FieldGroupImpl} (default constructor).</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link FieldGroupImpl} (default
   * constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link StructuredContentFieldTemplateImpl#setFieldGroups(List)}
   */
  @Test
  public void testSetFieldGroups_givenFieldGroupImpl_whenArrayListAddFieldGroupImpl2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StructuredContentFieldTemplateImpl structuredContentFieldTemplateImpl = new StructuredContentFieldTemplateImpl();

    ArrayList<FieldGroup> fieldGroups = new ArrayList<>();
    fieldGroups.add(new FieldGroupImpl());
    fieldGroups.add(new FieldGroupImpl());

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> structuredContentFieldTemplateImpl.setFieldGroups(fieldGroups));
  }

  /**
   * Test {@link StructuredContentFieldTemplateImpl#setFieldGroups(List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link StructuredContentFieldTemplateImpl#setFieldGroups(List)}
   */
  @Test
  public void testSetFieldGroups_whenArrayList() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StructuredContentFieldTemplateImpl structuredContentFieldTemplateImpl = new StructuredContentFieldTemplateImpl();

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> structuredContentFieldTemplateImpl.setFieldGroups(new ArrayList<>()));
  }

  /**
   * Test
   * {@link StructuredContentFieldTemplateImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   * <p>
   * Method under test:
   * {@link StructuredContentFieldTemplateImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  public void testCreateOrRetrieveCopyInstance() throws CloneNotSupportedException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StructuredContentFieldTemplateImpl structuredContentFieldTemplateImpl = new StructuredContentFieldTemplateImpl();
    GenericEntityService genericEntityService = mock(GenericEntityService.class);
    when(genericEntityService.getIdentifier(Mockito.<Object>any())).thenReturn(null);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(genericEntityService.getCeilingImplClass(Mockito.<String>any())).thenReturn(forNameResult);
    CatalogImpl fromCatalog = new CatalogImpl();
    CatalogImpl toCatalog = new CatalogImpl();
    SiteImpl fromSite = new SiteImpl();
    SiteImpl toSite = new SiteImpl();

    // Act
    CreateResponse<StructuredContentFieldTemplate> actualCreateOrRetrieveCopyInstanceResult = structuredContentFieldTemplateImpl
        .createOrRetrieveCopyInstance(new MultiTenantCopyContext(fromCatalog, toCatalog, fromSite, toSite,
            genericEntityService, new MultiTenantCopierExtensionManager()));

    // Assert
    verify(genericEntityService)
        .getCeilingImplClass(eq("org.broadleafcommerce.cms.structure.domain.StructuredContentFieldTemplateImpl"));
    verify(genericEntityService).getIdentifier(isA(Object.class));
    StructuredContentFieldTemplate clone = actualCreateOrRetrieveCopyInstanceResult.getClone();
    assertTrue(clone instanceof StructuredContentFieldTemplateImpl);
    assertNull(clone.getId());
    assertNull(clone.getName());
    assertFalse(actualCreateOrRetrieveCopyInstanceResult.isAlreadyPopulated());
    assertTrue(clone.getFieldGroupXrefs().isEmpty());
    assertTrue(clone.getFieldGroups().isEmpty());
  }

  /**
   * Test
   * {@link StructuredContentFieldTemplateImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   * <p>
   * Method under test:
   * {@link StructuredContentFieldTemplateImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  public void testCreateOrRetrieveCopyInstance2() throws CloneNotSupportedException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StructuredContentFieldTemplateImpl structuredContentFieldTemplateImpl = new StructuredContentFieldTemplateImpl();
    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    CreateResponse<Object> createResponse = new CreateResponse<>("Clone", true);

    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<StructuredContentFieldTemplate> actualCreateOrRetrieveCopyInstanceResult = structuredContentFieldTemplateImpl
        .createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link StructuredContentFieldTemplateImpl}
   *   <li>{@link StructuredContentFieldTemplateImpl#setFieldGroupXrefs(List)}
   *   <li>{@link StructuredContentFieldTemplateImpl#setId(Long)}
   *   <li>{@link StructuredContentFieldTemplateImpl#setName(String)}
   *   <li>{@link StructuredContentFieldTemplateImpl#getFieldGroupXrefs()}
   *   <li>{@link StructuredContentFieldTemplateImpl#getId()}
   *   <li>{@link StructuredContentFieldTemplateImpl#getName()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    StructuredContentFieldTemplateImpl actualStructuredContentFieldTemplateImpl = new StructuredContentFieldTemplateImpl();
    ArrayList<StructuredContentFieldGroupXref> fieldGroupXrefs = new ArrayList<>();
    actualStructuredContentFieldTemplateImpl.setFieldGroupXrefs(fieldGroupXrefs);
    actualStructuredContentFieldTemplateImpl.setId(StructuredContentItemCriteriaImpl.serialVersionUID);
    actualStructuredContentFieldTemplateImpl.setName("Name");
    List<StructuredContentFieldGroupXref> actualFieldGroupXrefs = actualStructuredContentFieldTemplateImpl
        .getFieldGroupXrefs();
    Long actualId = actualStructuredContentFieldTemplateImpl.getId();

    // Assert that nothing has changed
    assertEquals("Name", actualStructuredContentFieldTemplateImpl.getName());
    assertTrue(actualFieldGroupXrefs.isEmpty());
    assertEquals(StructuredContentItemCriteriaImpl.serialVersionUID, actualId.longValue());
    assertSame(fieldGroupXrefs, actualFieldGroupXrefs);
  }
}
