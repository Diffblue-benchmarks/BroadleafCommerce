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
package org.broadleafcommerce.cms.file.domain;

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
import org.broadleafcommerce.common.copy.CreateResponse;
import org.broadleafcommerce.common.copy.MultiTenantCopierExtensionManager;
import org.broadleafcommerce.common.copy.MultiTenantCopyContext;
import org.broadleafcommerce.common.service.GenericEntityService;
import org.broadleafcommerce.common.site.domain.CatalogImpl;
import org.broadleafcommerce.common.site.domain.SiteImpl;
import org.junit.Test;
import org.mockito.Mockito;

public class StaticAssetDescriptionImplDiffblueTest {
  /**
   * Test {@link StaticAssetDescriptionImpl#cloneEntity()}.
   * <p>
   * Method under test: {@link StaticAssetDescriptionImpl#cloneEntity()}
   */
  @Test
  public void testCloneEntity() {
    // Arrange and Act
    StaticAssetDescription actualCloneEntityResult = (new StaticAssetDescriptionImpl()).cloneEntity();

    // Assert
    assertTrue(actualCloneEntityResult instanceof StaticAssetDescriptionImpl);
    assertNull(actualCloneEntityResult.getId());
    assertNull(actualCloneEntityResult.getDescription());
    assertNull(actualCloneEntityResult.getLongDescription());
  }

  /**
   * Test
   * {@link StaticAssetDescriptionImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   * <p>
   * Method under test:
   * {@link StaticAssetDescriptionImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  public void testCreateOrRetrieveCopyInstance() throws CloneNotSupportedException {
    // Arrange
    StaticAssetDescriptionImpl staticAssetDescriptionImpl = new StaticAssetDescriptionImpl();
    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    CreateResponse<Object> createResponse = new CreateResponse<>("Clone", true);

    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<StaticAssetDescription> actualCreateOrRetrieveCopyInstanceResult = staticAssetDescriptionImpl
        .createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
  }

  /**
   * Test
   * {@link StaticAssetDescriptionImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   * <ul>
   *   <li>Then Clone return {@link StaticAssetDescriptionImpl}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link StaticAssetDescriptionImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  public void testCreateOrRetrieveCopyInstance_thenCloneReturnStaticAssetDescriptionImpl()
      throws CloneNotSupportedException {
    // Arrange
    StaticAssetDescriptionImpl staticAssetDescriptionImpl = new StaticAssetDescriptionImpl();
    GenericEntityService genericEntityService = mock(GenericEntityService.class);
    when(genericEntityService.getIdentifier(Mockito.<Object>any())).thenReturn(null);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(genericEntityService.getCeilingImplClass(Mockito.<String>any())).thenReturn(forNameResult);
    CatalogImpl fromCatalog = new CatalogImpl();
    CatalogImpl toCatalog = new CatalogImpl();
    SiteImpl fromSite = new SiteImpl();
    SiteImpl toSite = new SiteImpl();

    // Act
    CreateResponse<StaticAssetDescription> actualCreateOrRetrieveCopyInstanceResult = staticAssetDescriptionImpl
        .createOrRetrieveCopyInstance(new MultiTenantCopyContext(fromCatalog, toCatalog, fromSite, toSite,
            genericEntityService, new MultiTenantCopierExtensionManager()));

    // Assert
    verify(genericEntityService)
        .getCeilingImplClass(eq("org.broadleafcommerce.cms.file.domain.StaticAssetDescriptionImpl"));
    verify(genericEntityService).getIdentifier(isA(Object.class));
    StaticAssetDescription clone = actualCreateOrRetrieveCopyInstanceResult.getClone();
    assertTrue(clone instanceof StaticAssetDescriptionImpl);
    assertNull(clone.getId());
    assertNull(clone.getDescription());
    assertNull(clone.getLongDescription());
    assertFalse(actualCreateOrRetrieveCopyInstanceResult.isAlreadyPopulated());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link StaticAssetDescriptionImpl}
   *   <li>{@link StaticAssetDescriptionImpl#setDescription(String)}
   *   <li>{@link StaticAssetDescriptionImpl#setId(Long)}
   *   <li>{@link StaticAssetDescriptionImpl#setLongDescription(String)}
   *   <li>{@link StaticAssetDescriptionImpl#getDescription()}
   *   <li>{@link StaticAssetDescriptionImpl#getId()}
   *   <li>{@link StaticAssetDescriptionImpl#getLongDescription()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    StaticAssetDescriptionImpl actualStaticAssetDescriptionImpl = new StaticAssetDescriptionImpl();
    actualStaticAssetDescriptionImpl.setDescription("The characteristics of someone or something");
    actualStaticAssetDescriptionImpl.setId(1L);
    actualStaticAssetDescriptionImpl.setLongDescription("Long Description");
    String actualDescription = actualStaticAssetDescriptionImpl.getDescription();
    Long actualId = actualStaticAssetDescriptionImpl.getId();

    // Assert that nothing has changed
    assertEquals("Long Description", actualStaticAssetDescriptionImpl.getLongDescription());
    assertEquals("The characteristics of someone or something", actualDescription);
    assertEquals(1L, actualId.longValue());
  }
}
