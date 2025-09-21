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

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.broadleafcommerce.common.copy.CreateResponse;
import org.broadleafcommerce.common.copy.MultiTenantCopyContext;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class BandedPriceFulfillmentOptionImplDiffblueTest {
  @Autowired private BandedPriceFulfillmentOptionImpl bandedPriceFulfillmentOptionImpl;

  /**
   * Test {@link
   * BandedPriceFulfillmentOptionImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   *
   * <p>Method under test: {@link
   * BandedPriceFulfillmentOptionImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CreateResponse BandedPriceFulfillmentOptionImpl.createOrRetrieveCopyInstance(MultiTenantCopyContext)"
  })
  public void testCreateOrRetrieveCopyInstance() throws CloneNotSupportedException {
    // Arrange
    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    CreateResponse<Object> createResponse =
        new CreateResponse<>(new BandedPriceFulfillmentOptionImpl(), true);
    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<BandedPriceFulfillmentOption> actualCreateOrRetrieveCopyInstanceResult =
        bandedPriceFulfillmentOptionImpl.createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
  }

  /**
   * Test {@link
   * BandedPriceFulfillmentOptionImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   *
   * <p>Method under test: {@link
   * BandedPriceFulfillmentOptionImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CreateResponse BandedPriceFulfillmentOptionImpl.createOrRetrieveCopyInstance(MultiTenantCopyContext)"
  })
  public void testCreateOrRetrieveCopyInstance2() throws CloneNotSupportedException {
    // Arrange
    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    CreateResponse<Object> createResponse =
        new CreateResponse<>(bandedPriceFulfillmentOptionImpl, false);
    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<BandedPriceFulfillmentOption> actualCreateOrRetrieveCopyInstanceResult =
        bandedPriceFulfillmentOptionImpl.createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link BandedPriceFulfillmentOptionImpl}
   *   <li>{@link BandedPriceFulfillmentOptionImpl#setBands(List)}
   *   <li>{@link BandedPriceFulfillmentOptionImpl#getBands()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BandedPriceFulfillmentOptionImpl.<init>()",
    "List BandedPriceFulfillmentOptionImpl.getBands()",
    "void BandedPriceFulfillmentOptionImpl.setBands(List)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    BandedPriceFulfillmentOptionImpl actualBandedPriceFulfillmentOptionImpl =
        new BandedPriceFulfillmentOptionImpl();
    ArrayList<FulfillmentPriceBand> bands = new ArrayList<>();
    actualBandedPriceFulfillmentOptionImpl.setBands(bands);
    List<FulfillmentPriceBand> actualBands = actualBandedPriceFulfillmentOptionImpl.getBands();

    // Assert
    assertNull(actualBandedPriceFulfillmentOptionImpl.getId());
    assertNull(actualBandedPriceFulfillmentOptionImpl.getTaxCode());
    assertFalse(actualBandedPriceFulfillmentOptionImpl.getTaxable());
    assertTrue(actualBands.isEmpty());
    assertTrue(actualBandedPriceFulfillmentOptionImpl.getUseFlatRates());
    assertSame(bands, actualBands);
  }
}
