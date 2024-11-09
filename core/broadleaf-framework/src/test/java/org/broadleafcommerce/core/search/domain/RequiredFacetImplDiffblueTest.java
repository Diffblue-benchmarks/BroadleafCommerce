/*-
 * #%L
 * BroadleafCommerce Framework
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
package org.broadleafcommerce.core.search.domain;

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

public class RequiredFacetImplDiffblueTest {
  /**
   * Test
   * {@link RequiredFacetImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   * <p>
   * Method under test:
   * {@link RequiredFacetImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  public void testCreateOrRetrieveCopyInstance() throws CloneNotSupportedException {
    // Arrange
    RequiredFacetImpl requiredFacetImpl = new RequiredFacetImpl();
    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    CreateResponse<Object> createResponse = new CreateResponse<>("Clone", true);

    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<RequiredFacet> actualCreateOrRetrieveCopyInstanceResult = requiredFacetImpl
        .createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
  }

  /**
   * Test
   * {@link RequiredFacetImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   * <p>
   * Method under test:
   * {@link RequiredFacetImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  public void testCreateOrRetrieveCopyInstance2() throws CloneNotSupportedException {
    // Arrange
    RequiredFacetImpl requiredFacetImpl = new RequiredFacetImpl();
    requiredFacetImpl.setRequiredFacet(new SearchFacetImpl());

    RequiredFacetImpl requiredFacetImpl2 = new RequiredFacetImpl();
    requiredFacetImpl2.setId(1L);
    requiredFacetImpl2.setRequiredFacet(new SearchFacetImpl());
    requiredFacetImpl2.setSearchFacet(new SearchFacetImpl());
    CreateResponse<Object> createResponse = new CreateResponse<>(requiredFacetImpl2, false);

    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<RequiredFacet> actualCreateOrRetrieveCopyInstanceResult = requiredFacetImpl
        .createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
  }

  /**
   * Test
   * {@link RequiredFacetImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   * <p>
   * Method under test:
   * {@link RequiredFacetImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  public void testCreateOrRetrieveCopyInstance3() throws CloneNotSupportedException {
    // Arrange
    RequiredFacetImpl requiredFacetImpl = new RequiredFacetImpl();
    requiredFacetImpl.setSearchFacet(new SearchFacetImpl());

    RequiredFacetImpl requiredFacetImpl2 = new RequiredFacetImpl();
    requiredFacetImpl2.setId(1L);
    requiredFacetImpl2.setRequiredFacet(new SearchFacetImpl());
    requiredFacetImpl2.setSearchFacet(new SearchFacetImpl());
    CreateResponse<Object> createResponse = new CreateResponse<>(requiredFacetImpl2, false);

    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<RequiredFacet> actualCreateOrRetrieveCopyInstanceResult = requiredFacetImpl
        .createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
  }

  /**
   * Test
   * {@link RequiredFacetImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   * <ul>
   *   <li>Then Clone return {@link RequiredFacetImpl}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RequiredFacetImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  public void testCreateOrRetrieveCopyInstance_thenCloneReturnRequiredFacetImpl() throws CloneNotSupportedException {
    // Arrange
    RequiredFacetImpl requiredFacetImpl = new RequiredFacetImpl();
    GenericEntityService genericEntityService = mock(GenericEntityService.class);
    when(genericEntityService.getIdentifier(Mockito.<Object>any())).thenReturn(null);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(genericEntityService.getCeilingImplClass(Mockito.<String>any())).thenReturn(forNameResult);
    CatalogImpl fromCatalog = new CatalogImpl();
    CatalogImpl toCatalog = new CatalogImpl();
    SiteImpl fromSite = new SiteImpl();
    SiteImpl toSite = new SiteImpl();

    // Act
    CreateResponse<RequiredFacet> actualCreateOrRetrieveCopyInstanceResult = requiredFacetImpl
        .createOrRetrieveCopyInstance(new MultiTenantCopyContext(fromCatalog, toCatalog, fromSite, toSite,
            genericEntityService, new MultiTenantCopierExtensionManager()));

    // Assert
    verify(genericEntityService).getCeilingImplClass(eq("org.broadleafcommerce.core.search.domain.RequiredFacetImpl"));
    verify(genericEntityService).getIdentifier(isA(Object.class));
    RequiredFacet clone = actualCreateOrRetrieveCopyInstanceResult.getClone();
    assertTrue(clone instanceof RequiredFacetImpl);
    assertNull(clone.getId());
    assertNull(clone.getRequiredFacet());
    assertNull(clone.getSearchFacet());
    assertFalse(actualCreateOrRetrieveCopyInstanceResult.isAlreadyPopulated());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link RequiredFacetImpl}
   *   <li>{@link RequiredFacetImpl#setId(Long)}
   *   <li>{@link RequiredFacetImpl#setRequiredFacet(SearchFacet)}
   *   <li>{@link RequiredFacetImpl#setSearchFacet(SearchFacet)}
   *   <li>{@link RequiredFacetImpl#getId()}
   *   <li>{@link RequiredFacetImpl#getRequiredFacet()}
   *   <li>{@link RequiredFacetImpl#getSearchFacet()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    RequiredFacetImpl actualRequiredFacetImpl = new RequiredFacetImpl();
    actualRequiredFacetImpl.setId(1L);
    SearchFacetImpl requiredFacet = new SearchFacetImpl();
    actualRequiredFacetImpl.setRequiredFacet(requiredFacet);
    SearchFacetImpl searchFacet = new SearchFacetImpl();
    actualRequiredFacetImpl.setSearchFacet(searchFacet);
    Long actualId = actualRequiredFacetImpl.getId();
    SearchFacet actualRequiredFacet = actualRequiredFacetImpl.getRequiredFacet();
    SearchFacet actualSearchFacet = actualRequiredFacetImpl.getSearchFacet();

    // Assert that nothing has changed
    assertEquals(1L, actualId.longValue());
    assertSame(requiredFacet, actualRequiredFacet);
    assertSame(searchFacet, actualSearchFacet);
  }
}
