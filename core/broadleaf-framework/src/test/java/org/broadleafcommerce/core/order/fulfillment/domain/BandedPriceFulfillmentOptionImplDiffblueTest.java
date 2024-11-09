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
package org.broadleafcommerce.core.order.fulfillment.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import org.broadleafcommerce.common.copy.CreateResponse;
import org.broadleafcommerce.common.copy.MultiTenantCopierExtensionManager;
import org.broadleafcommerce.common.copy.MultiTenantCopyContext;
import org.broadleafcommerce.common.service.GenericEntityService;
import org.broadleafcommerce.common.site.domain.CatalogImpl;
import org.broadleafcommerce.common.site.domain.SiteImpl;
import org.junit.Test;
import org.mockito.Mockito;

public class BandedPriceFulfillmentOptionImplDiffblueTest {
  /**
   * Test
   * {@link BandedPriceFulfillmentOptionImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   * <p>
   * Method under test:
   * {@link BandedPriceFulfillmentOptionImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  public void testCreateOrRetrieveCopyInstance() throws CloneNotSupportedException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BandedPriceFulfillmentOptionImpl bandedPriceFulfillmentOptionImpl = new BandedPriceFulfillmentOptionImpl();
    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    CreateResponse<Object> createResponse = new CreateResponse<>("Clone", true);

    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<BandedPriceFulfillmentOption> actualCreateOrRetrieveCopyInstanceResult = bandedPriceFulfillmentOptionImpl
        .createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
  }

  /**
   * Test
   * {@link BandedPriceFulfillmentOptionImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   * <ul>
   *   <li>Then Clone return {@link BandedPriceFulfillmentOptionImpl}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BandedPriceFulfillmentOptionImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  public void testCreateOrRetrieveCopyInstance_thenCloneReturnBandedPriceFulfillmentOptionImpl()
      throws CloneNotSupportedException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BandedPriceFulfillmentOptionImpl bandedPriceFulfillmentOptionImpl = new BandedPriceFulfillmentOptionImpl();
    GenericEntityService genericEntityService = mock(GenericEntityService.class);
    when(genericEntityService.getIdentifier(Mockito.<Object>any())).thenReturn(null);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(genericEntityService.getCeilingImplClass(Mockito.<String>any())).thenReturn(forNameResult);
    CatalogImpl fromCatalog = new CatalogImpl();
    CatalogImpl toCatalog = new CatalogImpl();
    SiteImpl fromSite = new SiteImpl();
    SiteImpl toSite = new SiteImpl();

    // Act
    CreateResponse<BandedPriceFulfillmentOption> actualCreateOrRetrieveCopyInstanceResult = bandedPriceFulfillmentOptionImpl
        .createOrRetrieveCopyInstance(new MultiTenantCopyContext(fromCatalog, toCatalog, fromSite, toSite,
            genericEntityService, new MultiTenantCopierExtensionManager()));

    // Assert
    verify(genericEntityService).getCeilingImplClass(
        eq("org.broadleafcommerce.core.order.fulfillment.domain.BandedPriceFulfillmentOptionImpl"));
    verify(genericEntityService).getIdentifier(isA(Object.class));
    BandedPriceFulfillmentOption clone = actualCreateOrRetrieveCopyInstanceResult.getClone();
    assertTrue(clone instanceof BandedPriceFulfillmentOptionImpl);
    assertFalse(actualCreateOrRetrieveCopyInstanceResult.isAlreadyPopulated());
    assertEquals(bandedPriceFulfillmentOptionImpl, clone);
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link BandedPriceFulfillmentOptionImpl}
   *   <li>{@link BandedPriceFulfillmentOptionImpl#setBands(List)}
   *   <li>{@link BandedPriceFulfillmentOptionImpl#getBands()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    BandedPriceFulfillmentOptionImpl actualBandedPriceFulfillmentOptionImpl = new BandedPriceFulfillmentOptionImpl();
    ArrayList<FulfillmentPriceBand> bands = new ArrayList<>();
    actualBandedPriceFulfillmentOptionImpl.setBands(bands);
    List<FulfillmentPriceBand> actualBands = actualBandedPriceFulfillmentOptionImpl.getBands();

    // Assert that nothing has changed
    assertFalse(actualBandedPriceFulfillmentOptionImpl.getTaxable());
    assertTrue(actualBands.isEmpty());
    assertTrue(actualBandedPriceFulfillmentOptionImpl.getUseFlatRates());
    assertSame(bands, actualBands);
  }
}
