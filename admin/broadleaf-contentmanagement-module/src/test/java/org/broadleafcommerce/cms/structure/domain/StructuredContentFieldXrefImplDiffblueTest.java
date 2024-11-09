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
import org.broadleafcommerce.common.copy.CreateResponse;
import org.broadleafcommerce.common.copy.MultiTenantCopierExtensionManager;
import org.broadleafcommerce.common.copy.MultiTenantCopyContext;
import org.broadleafcommerce.common.service.GenericEntityService;
import org.broadleafcommerce.common.site.domain.CatalogImpl;
import org.broadleafcommerce.common.site.domain.SiteImpl;
import org.junit.Test;
import org.mockito.Mockito;

public class StructuredContentFieldXrefImplDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link StructuredContentFieldXrefImpl#StructuredContentFieldXrefImpl()}
   *   <li>{@link StructuredContentFieldXrefImpl#setId(Long)}
   *   <li>{@link StructuredContentFieldXrefImpl#setKey(String)}
   *   <li>
   * {@link StructuredContentFieldXrefImpl#setStructuredContent(StructuredContent)}
   *   <li>
   * {@link StructuredContentFieldXrefImpl#setStrucuturedContentField(StructuredContentField)}
   *   <li>{@link StructuredContentFieldXrefImpl#getId()}
   *   <li>{@link StructuredContentFieldXrefImpl#getKey()}
   *   <li>{@link StructuredContentFieldXrefImpl#getStructuredContent()}
   *   <li>{@link StructuredContentFieldXrefImpl#getStructuredContentField()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    StructuredContentFieldXrefImpl actualStructuredContentFieldXrefImpl = new StructuredContentFieldXrefImpl();
    actualStructuredContentFieldXrefImpl.setId(StructuredContentItemCriteriaImpl.serialVersionUID);
    actualStructuredContentFieldXrefImpl.setKey("Key");
    StructuredContentImpl sc = new StructuredContentImpl();
    actualStructuredContentFieldXrefImpl.setStructuredContent(sc);
    StructuredContentFieldImpl scField = new StructuredContentFieldImpl();
    actualStructuredContentFieldXrefImpl.setStrucuturedContentField(scField);
    Long actualId = actualStructuredContentFieldXrefImpl.getId();
    String actualKey = actualStructuredContentFieldXrefImpl.getKey();
    StructuredContent actualStructuredContent = actualStructuredContentFieldXrefImpl.getStructuredContent();
    StructuredContentField actualStructuredContentField = actualStructuredContentFieldXrefImpl
        .getStructuredContentField();

    // Assert that nothing has changed
    assertEquals("Key", actualKey);
    assertEquals(StructuredContentItemCriteriaImpl.serialVersionUID, actualId.longValue());
    assertSame(scField, actualStructuredContentField);
    assertSame(sc, actualStructuredContent);
  }

  /**
   * Test getters and setters.
   * <ul>
   *   <li>When {@link StructuredContentImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>
   * {@link StructuredContentFieldXrefImpl#StructuredContentFieldXrefImpl(StructuredContent, StructuredContentField, String)}
   *   <li>{@link StructuredContentFieldXrefImpl#setId(Long)}
   *   <li>{@link StructuredContentFieldXrefImpl#setKey(String)}
   *   <li>
   * {@link StructuredContentFieldXrefImpl#setStructuredContent(StructuredContent)}
   *   <li>
   * {@link StructuredContentFieldXrefImpl#setStrucuturedContentField(StructuredContentField)}
   *   <li>{@link StructuredContentFieldXrefImpl#getId()}
   *   <li>{@link StructuredContentFieldXrefImpl#getKey()}
   *   <li>{@link StructuredContentFieldXrefImpl#getStructuredContent()}
   *   <li>{@link StructuredContentFieldXrefImpl#getStructuredContentField()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters_whenStructuredContentImpl() {
    // Arrange
    StructuredContentImpl sc = new StructuredContentImpl();

    // Act
    StructuredContentFieldXrefImpl actualStructuredContentFieldXrefImpl = new StructuredContentFieldXrefImpl(sc,
        new StructuredContentFieldImpl(), "Key");
    actualStructuredContentFieldXrefImpl.setId(StructuredContentItemCriteriaImpl.serialVersionUID);
    actualStructuredContentFieldXrefImpl.setKey("Key");
    StructuredContentImpl sc2 = new StructuredContentImpl();
    actualStructuredContentFieldXrefImpl.setStructuredContent(sc2);
    StructuredContentFieldImpl scField = new StructuredContentFieldImpl();
    actualStructuredContentFieldXrefImpl.setStrucuturedContentField(scField);
    Long actualId = actualStructuredContentFieldXrefImpl.getId();
    String actualKey = actualStructuredContentFieldXrefImpl.getKey();
    StructuredContent actualStructuredContent = actualStructuredContentFieldXrefImpl.getStructuredContent();
    StructuredContentField actualStructuredContentField = actualStructuredContentFieldXrefImpl
        .getStructuredContentField();

    // Assert that nothing has changed
    assertEquals("Key", actualKey);
    assertEquals(StructuredContentItemCriteriaImpl.serialVersionUID, actualId.longValue());
    assertSame(scField, actualStructuredContentField);
    assertSame(sc2, actualStructuredContent);
  }

  /**
   * Test
   * {@link StructuredContentFieldXrefImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   * <p>
   * Method under test:
   * {@link StructuredContentFieldXrefImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  public void testCreateOrRetrieveCopyInstance() throws CloneNotSupportedException {
    // Arrange
    StructuredContentFieldXrefImpl structuredContentFieldXrefImpl = new StructuredContentFieldXrefImpl();
    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    CreateResponse<Object> createResponse = new CreateResponse<>("Clone", true);

    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<StructuredContentFieldXref> actualCreateOrRetrieveCopyInstanceResult = structuredContentFieldXrefImpl
        .createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
  }

  /**
   * Test
   * {@link StructuredContentFieldXrefImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   * <p>
   * Method under test:
   * {@link StructuredContentFieldXrefImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  public void testCreateOrRetrieveCopyInstance2() throws CloneNotSupportedException {
    // Arrange
    CreateResponse<StructuredContent> createResponse = mock(CreateResponse.class);
    when(createResponse.getClone()).thenReturn(new StructuredContentImpl());
    StructuredContent sc = mock(StructuredContent.class);
    when(sc.createOrRetrieveCopyInstance(Mockito.<MultiTenantCopyContext>any())).thenReturn(createResponse);
    StructuredContentFieldXrefImpl structuredContentFieldXrefImpl = new StructuredContentFieldXrefImpl(sc, null,
        "ThreadLocalManager.notify.orphans");

    StructuredContentFieldXrefImpl structuredContentFieldXrefImpl2 = new StructuredContentFieldXrefImpl();
    structuredContentFieldXrefImpl2.setId(StructuredContentItemCriteriaImpl.serialVersionUID);
    structuredContentFieldXrefImpl2.setKey("Key");
    structuredContentFieldXrefImpl2.setStructuredContent(new StructuredContentImpl());
    structuredContentFieldXrefImpl2.setStrucuturedContentField(new StructuredContentFieldImpl());
    CreateResponse<Object> createResponse2 = mock(CreateResponse.class);
    when(createResponse2.isAlreadyPopulated()).thenReturn(false);
    when(createResponse2.getClone()).thenReturn(structuredContentFieldXrefImpl2);
    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse2);

    // Act
    structuredContentFieldXrefImpl.createOrRetrieveCopyInstance(context);

    // Assert
    verify(createResponse2).getClone();
    verify(createResponse).getClone();
    verify(createResponse2).isAlreadyPopulated();
    verify(sc).createOrRetrieveCopyInstance(isA(MultiTenantCopyContext.class));
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
  }

  /**
   * Test
   * {@link StructuredContentFieldXrefImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   * <p>
   * Method under test:
   * {@link StructuredContentFieldXrefImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  public void testCreateOrRetrieveCopyInstance3() throws CloneNotSupportedException {
    // Arrange
    CreateResponse<StructuredContent> createResponse = mock(CreateResponse.class);
    when(createResponse.getClone()).thenReturn(new StructuredContentImpl());
    StructuredContent sc = mock(StructuredContent.class);
    when(sc.createOrRetrieveCopyInstance(Mockito.<MultiTenantCopyContext>any())).thenReturn(createResponse);
    StructuredContentFieldImpl scField = mock(StructuredContentFieldImpl.class);
    when(scField.createOrRetrieveCopyInstance(Mockito.<MultiTenantCopyContext>any()))
        .thenReturn(new CreateResponse<>(new StructuredContentFieldImpl(), true));
    StructuredContentFieldXrefImpl structuredContentFieldXrefImpl = new StructuredContentFieldXrefImpl(sc, scField,
        "ThreadLocalManager.notify.orphans");

    StructuredContentFieldXrefImpl structuredContentFieldXrefImpl2 = new StructuredContentFieldXrefImpl();
    structuredContentFieldXrefImpl2.setId(StructuredContentItemCriteriaImpl.serialVersionUID);
    structuredContentFieldXrefImpl2.setKey("Key");
    structuredContentFieldXrefImpl2.setStructuredContent(new StructuredContentImpl());
    structuredContentFieldXrefImpl2.setStrucuturedContentField(new StructuredContentFieldImpl());
    CreateResponse<Object> createResponse2 = mock(CreateResponse.class);
    when(createResponse2.isAlreadyPopulated()).thenReturn(false);
    when(createResponse2.getClone()).thenReturn(structuredContentFieldXrefImpl2);
    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse2);

    // Act
    structuredContentFieldXrefImpl.createOrRetrieveCopyInstance(context);

    // Assert
    verify(scField).createOrRetrieveCopyInstance(isA(MultiTenantCopyContext.class));
    verify(createResponse2).getClone();
    verify(createResponse).getClone();
    verify(createResponse2).isAlreadyPopulated();
    verify(sc).createOrRetrieveCopyInstance(isA(MultiTenantCopyContext.class));
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
  }

  /**
   * Test
   * {@link StructuredContentFieldXrefImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   * <p>
   * Method under test:
   * {@link StructuredContentFieldXrefImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  public void testCreateOrRetrieveCopyInstance4() throws CloneNotSupportedException {
    // Arrange
    CreateResponse<StructuredContent> createResponse = mock(CreateResponse.class);
    when(createResponse.getClone()).thenReturn(new StructuredContentImpl());
    StructuredContent sc = mock(StructuredContent.class);
    when(sc.createOrRetrieveCopyInstance(Mockito.<MultiTenantCopyContext>any())).thenReturn(createResponse);
    StructuredContentFieldImpl scField = mock(StructuredContentFieldImpl.class);
    when(scField.createOrRetrieveCopyInstance(Mockito.<MultiTenantCopyContext>any()))
        .thenThrow(new CloneNotSupportedException("foo"));
    StructuredContentFieldXrefImpl structuredContentFieldXrefImpl = new StructuredContentFieldXrefImpl(sc, scField,
        "ThreadLocalManager.notify.orphans");

    StructuredContentFieldXrefImpl structuredContentFieldXrefImpl2 = new StructuredContentFieldXrefImpl();
    structuredContentFieldXrefImpl2.setId(StructuredContentItemCriteriaImpl.serialVersionUID);
    structuredContentFieldXrefImpl2.setKey("Key");
    structuredContentFieldXrefImpl2.setStructuredContent(new StructuredContentImpl());
    structuredContentFieldXrefImpl2.setStrucuturedContentField(new StructuredContentFieldImpl());
    CreateResponse<Object> createResponse2 = mock(CreateResponse.class);
    when(createResponse2.isAlreadyPopulated()).thenReturn(false);
    when(createResponse2.getClone()).thenReturn(structuredContentFieldXrefImpl2);
    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse2);

    // Act and Assert
    assertThrows(CloneNotSupportedException.class,
        () -> structuredContentFieldXrefImpl.createOrRetrieveCopyInstance(context));
    verify(scField).createOrRetrieveCopyInstance(isA(MultiTenantCopyContext.class));
    verify(createResponse2).getClone();
    verify(createResponse).getClone();
    verify(createResponse2).isAlreadyPopulated();
    verify(sc).createOrRetrieveCopyInstance(isA(MultiTenantCopyContext.class));
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
  }

  /**
   * Test
   * {@link StructuredContentFieldXrefImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   * <ul>
   *   <li>Then calls
   * {@link StructuredContentImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link StructuredContentFieldXrefImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  public void testCreateOrRetrieveCopyInstance_thenCallsCreateOrRetrieveCopyInstance()
      throws CloneNotSupportedException {
    // Arrange
    StructuredContentImpl sc = mock(StructuredContentImpl.class);
    when(sc.createOrRetrieveCopyInstance(Mockito.<MultiTenantCopyContext>any()))
        .thenThrow(new CloneNotSupportedException("foo"));

    StructuredContentFieldXrefImpl structuredContentFieldXrefImpl = new StructuredContentFieldXrefImpl();
    structuredContentFieldXrefImpl.setId(StructuredContentItemCriteriaImpl.serialVersionUID);
    structuredContentFieldXrefImpl.setKey("Key");
    structuredContentFieldXrefImpl.setStructuredContent(sc);
    structuredContentFieldXrefImpl.setStrucuturedContentField(new StructuredContentFieldImpl());

    StructuredContentFieldXrefImpl structuredContentFieldXrefImpl2 = new StructuredContentFieldXrefImpl();
    structuredContentFieldXrefImpl2.setId(StructuredContentItemCriteriaImpl.serialVersionUID);
    structuredContentFieldXrefImpl2.setKey("Key");
    structuredContentFieldXrefImpl2.setStructuredContent(new StructuredContentImpl());
    structuredContentFieldXrefImpl2.setStrucuturedContentField(new StructuredContentFieldImpl());
    CreateResponse<Object> createResponse = mock(CreateResponse.class);
    when(createResponse.isAlreadyPopulated()).thenReturn(false);
    when(createResponse.getClone()).thenReturn(structuredContentFieldXrefImpl2);
    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act and Assert
    assertThrows(CloneNotSupportedException.class,
        () -> structuredContentFieldXrefImpl.createOrRetrieveCopyInstance(context));
    verify(sc).createOrRetrieveCopyInstance(isA(MultiTenantCopyContext.class));
    verify(createResponse).getClone();
    verify(createResponse).isAlreadyPopulated();
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
  }

  /**
   * Test
   * {@link StructuredContentFieldXrefImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   * <ul>
   *   <li>Then Clone return {@link StructuredContentFieldXrefImpl}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link StructuredContentFieldXrefImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  public void testCreateOrRetrieveCopyInstance_thenCloneReturnStructuredContentFieldXrefImpl()
      throws CloneNotSupportedException {
    // Arrange
    StructuredContentFieldXrefImpl structuredContentFieldXrefImpl = new StructuredContentFieldXrefImpl();
    GenericEntityService genericEntityService = mock(GenericEntityService.class);
    when(genericEntityService.getIdentifier(Mockito.<Object>any())).thenReturn(null);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(genericEntityService.getCeilingImplClass(Mockito.<String>any())).thenReturn(forNameResult);
    CatalogImpl fromCatalog = new CatalogImpl();
    CatalogImpl toCatalog = new CatalogImpl();
    SiteImpl fromSite = new SiteImpl();
    SiteImpl toSite = new SiteImpl();

    // Act
    CreateResponse<StructuredContentFieldXref> actualCreateOrRetrieveCopyInstanceResult = structuredContentFieldXrefImpl
        .createOrRetrieveCopyInstance(new MultiTenantCopyContext(fromCatalog, toCatalog, fromSite, toSite,
            genericEntityService, new MultiTenantCopierExtensionManager()));

    // Assert
    verify(genericEntityService)
        .getCeilingImplClass(eq("org.broadleafcommerce.cms.structure.domain.StructuredContentFieldXrefImpl"));
    verify(genericEntityService).getIdentifier(isA(Object.class));
    StructuredContentFieldXref clone = actualCreateOrRetrieveCopyInstanceResult.getClone();
    assertTrue(clone instanceof StructuredContentFieldXrefImpl);
    assertNull(clone.getId());
    assertNull(clone.getKey());
    assertNull(clone.getStructuredContent());
    assertNull(clone.getStructuredContentField());
    assertFalse(actualCreateOrRetrieveCopyInstanceResult.isAlreadyPopulated());
  }
}
