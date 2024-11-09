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
package org.broadleafcommerce.cms.field.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import org.broadleafcommerce.cms.structure.domain.StructuredContentFieldGroupXref;
import org.broadleafcommerce.common.copy.CreateResponse;
import org.broadleafcommerce.common.copy.MultiTenantCopierExtensionManager;
import org.broadleafcommerce.common.copy.MultiTenantCopyContext;
import org.broadleafcommerce.common.service.GenericEntityService;
import org.broadleafcommerce.common.site.domain.CatalogImpl;
import org.broadleafcommerce.common.site.domain.SiteImpl;
import org.junit.Test;
import org.mockito.Mockito;

public class FieldGroupImplDiffblueTest {
  /**
   * Test
   * {@link FieldGroupImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   * <p>
   * Method under test:
   * {@link FieldGroupImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  public void testCreateOrRetrieveCopyInstance() throws CloneNotSupportedException {
    // Arrange
    FieldGroupImpl fieldGroupImpl = new FieldGroupImpl();
    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    CreateResponse<Object> createResponse = new CreateResponse<>("Clone", true);

    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<FieldGroup> actualCreateOrRetrieveCopyInstanceResult = fieldGroupImpl
        .createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
  }

  /**
   * Test
   * {@link FieldGroupImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   * <ul>
   *   <li>Then Clone return {@link FieldGroupImpl}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FieldGroupImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  public void testCreateOrRetrieveCopyInstance_thenCloneReturnFieldGroupImpl() throws CloneNotSupportedException {
    // Arrange
    FieldGroupImpl fieldGroupImpl = new FieldGroupImpl();
    GenericEntityService genericEntityService = mock(GenericEntityService.class);
    when(genericEntityService.getIdentifier(Mockito.<Object>any())).thenReturn(null);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(genericEntityService.getCeilingImplClass(Mockito.<String>any())).thenReturn(forNameResult);
    CatalogImpl fromCatalog = new CatalogImpl();
    CatalogImpl toCatalog = new CatalogImpl();
    SiteImpl fromSite = new SiteImpl();
    SiteImpl toSite = new SiteImpl();

    // Act
    CreateResponse<FieldGroup> actualCreateOrRetrieveCopyInstanceResult = fieldGroupImpl
        .createOrRetrieveCopyInstance(new MultiTenantCopyContext(fromCatalog, toCatalog, fromSite, toSite,
            genericEntityService, new MultiTenantCopierExtensionManager()));

    // Assert
    verify(genericEntityService).getCeilingImplClass(eq("org.broadleafcommerce.cms.field.domain.FieldGroupImpl"));
    verify(genericEntityService).getIdentifier(isA(Object.class));
    FieldGroup clone = actualCreateOrRetrieveCopyInstanceResult.getClone();
    assertTrue(clone instanceof FieldGroupImpl);
    assertNull(clone.getId());
    assertNull(clone.getName());
    assertFalse(clone.getInitCollapsedFlag());
    assertFalse(clone.isMasterFieldGroup());
    assertFalse(actualCreateOrRetrieveCopyInstanceResult.isAlreadyPopulated());
    assertFalse(((FieldGroupImpl) clone).isMasterFieldGroup);
    assertTrue(clone.getFieldDefinitions().isEmpty());
    assertTrue(clone.getFieldGroupXrefs().isEmpty());
  }

  /**
   * Test {@link FieldGroupImpl#isMasterFieldGroup()}.
   * <ul>
   *   <li>Given {@link FieldGroupImpl} (default constructor) IsMasterFieldGroup is
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldGroupImpl#isMasterFieldGroup()}
   */
  @Test
  public void testIsMasterFieldGroup_givenFieldGroupImplIsMasterFieldGroupIsNull() {
    // Arrange
    FieldGroupImpl fieldGroupImpl = new FieldGroupImpl();
    fieldGroupImpl.setFieldDefinitions(new ArrayList<>());
    fieldGroupImpl.setFieldGroupXrefs(new ArrayList<>());
    fieldGroupImpl.setId(1L);
    fieldGroupImpl.setInitCollapsedFlag(true);
    fieldGroupImpl.setName("Name");
    fieldGroupImpl.setIsMasterFieldGroup(null);

    // Act and Assert
    assertFalse(fieldGroupImpl.isMasterFieldGroup());
  }

  /**
   * Test {@link FieldGroupImpl#isMasterFieldGroup()}.
   * <ul>
   *   <li>Given {@link FieldGroupImpl} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldGroupImpl#isMasterFieldGroup()}
   */
  @Test
  public void testIsMasterFieldGroup_givenFieldGroupImpl_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new FieldGroupImpl()).isMasterFieldGroup());
  }

  /**
   * Test {@link FieldGroupImpl#isMasterFieldGroup()}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldGroupImpl#isMasterFieldGroup()}
   */
  @Test
  public void testIsMasterFieldGroup_thenReturnTrue() {
    // Arrange
    FieldGroupImpl fieldGroupImpl = new FieldGroupImpl();
    fieldGroupImpl.setFieldDefinitions(new ArrayList<>());
    fieldGroupImpl.setFieldGroupXrefs(new ArrayList<>());
    fieldGroupImpl.setId(1L);
    fieldGroupImpl.setInitCollapsedFlag(true);
    fieldGroupImpl.setName("Name");
    fieldGroupImpl.setIsMasterFieldGroup(true);

    // Act and Assert
    assertTrue(fieldGroupImpl.isMasterFieldGroup());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link FieldGroupImpl}
   *   <li>{@link FieldGroupImpl#setFieldDefinitions(List)}
   *   <li>{@link FieldGroupImpl#setFieldGroupXrefs(List)}
   *   <li>{@link FieldGroupImpl#setId(Long)}
   *   <li>{@link FieldGroupImpl#setInitCollapsedFlag(Boolean)}
   *   <li>{@link FieldGroupImpl#setIsMasterFieldGroup(Boolean)}
   *   <li>{@link FieldGroupImpl#setName(String)}
   *   <li>{@link FieldGroupImpl#getFieldDefinitions()}
   *   <li>{@link FieldGroupImpl#getFieldGroupXrefs()}
   *   <li>{@link FieldGroupImpl#getId()}
   *   <li>{@link FieldGroupImpl#getInitCollapsedFlag()}
   *   <li>{@link FieldGroupImpl#getName()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    FieldGroupImpl actualFieldGroupImpl = new FieldGroupImpl();
    ArrayList<FieldDefinition> fieldDefinitions = new ArrayList<>();
    actualFieldGroupImpl.setFieldDefinitions(fieldDefinitions);
    ArrayList<StructuredContentFieldGroupXref> fieldGroupXrefs = new ArrayList<>();
    actualFieldGroupImpl.setFieldGroupXrefs(fieldGroupXrefs);
    actualFieldGroupImpl.setId(1L);
    actualFieldGroupImpl.setInitCollapsedFlag(true);
    actualFieldGroupImpl.setIsMasterFieldGroup(true);
    actualFieldGroupImpl.setName("Name");
    List<FieldDefinition> actualFieldDefinitions = actualFieldGroupImpl.getFieldDefinitions();
    List<StructuredContentFieldGroupXref> actualFieldGroupXrefs = actualFieldGroupImpl.getFieldGroupXrefs();
    Long actualId = actualFieldGroupImpl.getId();
    Boolean actualInitCollapsedFlag = actualFieldGroupImpl.getInitCollapsedFlag();

    // Assert that nothing has changed
    assertEquals("Name", actualFieldGroupImpl.getName());
    assertEquals(1L, actualId.longValue());
    assertTrue(actualFieldDefinitions.isEmpty());
    assertTrue(actualFieldGroupXrefs.isEmpty());
    assertTrue(actualInitCollapsedFlag);
    assertSame(fieldDefinitions, actualFieldDefinitions);
    assertSame(fieldGroupXrefs, actualFieldGroupXrefs);
  }
}
