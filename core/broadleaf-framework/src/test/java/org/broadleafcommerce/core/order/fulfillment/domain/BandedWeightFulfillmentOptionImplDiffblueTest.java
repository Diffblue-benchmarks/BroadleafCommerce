/*-
 * #%L
 * BroadleafCommerce Framework
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
package org.broadleafcommerce.core.order.fulfillment.domain;

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
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.broadleafcommerce.common.copy.CreateResponse;
import org.broadleafcommerce.common.copy.MultiTenantCopierExtensionManager;
import org.broadleafcommerce.common.copy.MultiTenantCopyContext;
import org.broadleafcommerce.common.service.GenericEntityService;
import org.broadleafcommerce.common.site.domain.CatalogImpl;
import org.broadleafcommerce.common.site.domain.SiteImpl;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class BandedWeightFulfillmentOptionImplDiffblueTest {
  @Autowired
  private BandedWeightFulfillmentOptionImpl bandedWeightFulfillmentOptionImpl;

  /**
   * Test {@link BandedWeightFulfillmentOptionImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   * <p>
   * Method under test: {@link BandedWeightFulfillmentOptionImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "CreateResponse BandedWeightFulfillmentOptionImpl.createOrRetrieveCopyInstance(MultiTenantCopyContext)"})
  public void testCreateOrRetrieveCopyInstance() throws CloneNotSupportedException {
    // Arrange
    BandedWeightFulfillmentOptionImpl bandedWeightFulfillmentOptionImpl2 = new BandedWeightFulfillmentOptionImpl();
    GenericEntityService genericEntityService = mock(GenericEntityService.class);
    when(genericEntityService.getIdentifier(Mockito.<Object>any())).thenReturn(null);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(genericEntityService.getCeilingImplClass(Mockito.<String>any())).thenReturn(forNameResult);
    CatalogImpl fromCatalog = new CatalogImpl();
    CatalogImpl toCatalog = new CatalogImpl();
    SiteImpl fromSite = new SiteImpl();
    SiteImpl toSite = new SiteImpl();

    // Act
    CreateResponse<BandedWeightFulfillmentOption> actualCreateOrRetrieveCopyInstanceResult = bandedWeightFulfillmentOptionImpl2
        .createOrRetrieveCopyInstance(new MultiTenantCopyContext(fromCatalog, toCatalog, fromSite, toSite,
            genericEntityService, new MultiTenantCopierExtensionManager()));

    // Assert
    verify(genericEntityService).getCeilingImplClass(
        eq("org.broadleafcommerce.core.order.fulfillment.domain.BandedWeightFulfillmentOptionImpl"));
    verify(genericEntityService).getIdentifier(isA(Object.class));
    BandedWeightFulfillmentOption clone = actualCreateOrRetrieveCopyInstanceResult.getClone();
    assertTrue(clone instanceof BandedWeightFulfillmentOptionImpl);
    assertFalse(actualCreateOrRetrieveCopyInstanceResult.isAlreadyPopulated());
    assertEquals(bandedWeightFulfillmentOptionImpl2, clone);
  }

  /**
   * Test {@link BandedWeightFulfillmentOptionImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   * <p>
   * Method under test: {@link BandedWeightFulfillmentOptionImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "CreateResponse BandedWeightFulfillmentOptionImpl.createOrRetrieveCopyInstance(MultiTenantCopyContext)"})
  public void testCreateOrRetrieveCopyInstance2() throws CloneNotSupportedException {
    // Arrange
    BandedWeightFulfillmentOptionImpl bandedWeightFulfillmentOptionImpl2 = new BandedWeightFulfillmentOptionImpl();
    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    CreateResponse<Object> createResponse = new CreateResponse<>("Clone", true);

    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<BandedWeightFulfillmentOption> actualCreateOrRetrieveCopyInstanceResult = bandedWeightFulfillmentOptionImpl2
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
   *   <li>default or parameterless constructor of {@link BandedWeightFulfillmentOptionImpl}
   *   <li>{@link BandedWeightFulfillmentOptionImpl#setBands(List)}
   *   <li>{@link BandedWeightFulfillmentOptionImpl#getBands()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BandedWeightFulfillmentOptionImpl.<init>()",
      "List BandedWeightFulfillmentOptionImpl.getBands()", "void BandedWeightFulfillmentOptionImpl.setBands(List)"})
  public void testGettersAndSetters() {
    // Arrange and Act
    BandedWeightFulfillmentOptionImpl actualBandedWeightFulfillmentOptionImpl = new BandedWeightFulfillmentOptionImpl();
    ArrayList<FulfillmentWeightBand> bands = new ArrayList<>();
    actualBandedWeightFulfillmentOptionImpl.setBands(bands);
    List<FulfillmentWeightBand> actualBands = actualBandedWeightFulfillmentOptionImpl.getBands();

    // Assert
    assertNull(actualBandedWeightFulfillmentOptionImpl.getId());
    assertNull(actualBandedWeightFulfillmentOptionImpl.getTaxCode());
    assertFalse(actualBandedWeightFulfillmentOptionImpl.getTaxable());
    assertTrue(actualBands.isEmpty());
    assertTrue(actualBandedWeightFulfillmentOptionImpl.getUseFlatRates());
    assertSame(bands, actualBands);
  }
}
