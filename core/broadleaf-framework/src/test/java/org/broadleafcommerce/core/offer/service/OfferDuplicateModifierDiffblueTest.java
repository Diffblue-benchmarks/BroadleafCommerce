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
package org.broadleafcommerce.core.offer.service;

import static org.junit.Assert.assertFalse;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.broadleafcommerce.common.copy.MultiTenantCloneable;
import org.broadleafcommerce.common.copy.MultiTenantCopierExtensionManager;
import org.broadleafcommerce.common.copy.MultiTenantCopyContext;
import org.broadleafcommerce.common.service.GenericEntityServiceImpl;
import org.broadleafcommerce.common.site.domain.CatalogImpl;
import org.broadleafcommerce.common.site.domain.SiteImpl;
import org.broadleafcommerce.core.offer.domain.Offer;
import org.broadleafcommerce.core.offer.domain.OfferImpl;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.boot.web.reactive.context.StandardReactiveWebEnvironment;
import org.springframework.core.env.Environment;

public class OfferDuplicateModifierDiffblueTest {
  /**
   * Test {@link OfferDuplicateModifier#canHandle(MultiTenantCloneable)}.
   * <ul>
   *   <li>When {@link MultiTenantCloneable}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OfferDuplicateModifier#canHandle(MultiTenantCloneable)}
   */
  @Test
  public void testCanHandle_whenMultiTenantCloneable_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse(
        (new OfferDuplicateModifier(new StandardReactiveWebEnvironment())).canHandle(mock(MultiTenantCloneable.class)));
  }

  /**
   * Test
   * {@link OfferDuplicateModifier#modifyInitialDuplicateState(Offer, Offer, MultiTenantCopyContext)}
   * with {@code Offer}, {@code Offer}, {@code MultiTenantCopyContext}.
   * <p>
   * Method under test:
   * {@link OfferDuplicateModifier#modifyInitialDuplicateState(Offer, Offer, MultiTenantCopyContext)}
   */
  @Test
  public void testModifyInitialDuplicateStateWithOfferOfferMultiTenantCopyContext() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Environment environment = mock(Environment.class);
    when(environment.getProperty(Mockito.<String>any(), Mockito.<Class<String>>any(), Mockito.<String>any()))
        .thenReturn("Property");
    OfferDuplicateModifier offerDuplicateModifier = new OfferDuplicateModifier(environment);
    OfferImpl original = new OfferImpl();
    OfferImpl copy = new OfferImpl();
    CatalogImpl fromCatalog = new CatalogImpl();
    CatalogImpl toCatalog = new CatalogImpl();
    SiteImpl fromSite = new SiteImpl();
    SiteImpl toSite = new SiteImpl();
    GenericEntityServiceImpl genericEntityService = new GenericEntityServiceImpl();

    // Act
    offerDuplicateModifier.modifyInitialDuplicateState(original, copy, new MultiTenantCopyContext(fromCatalog,
        toCatalog, fromSite, toSite, genericEntityService, new MultiTenantCopierExtensionManager()));

    // Assert
    verify(environment).getProperty(eq("admin.entity.duplication.suffix.default"), isA(Class.class), eq(" - Copy"));
  }
}
