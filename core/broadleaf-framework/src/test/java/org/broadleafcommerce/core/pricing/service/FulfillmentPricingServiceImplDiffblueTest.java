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
package org.broadleafcommerce.core.pricing.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.common.vendor.service.exception.FulfillmentPriceException;
import org.broadleafcommerce.core.order.domain.FulfillmentGroup;
import org.broadleafcommerce.core.order.domain.FulfillmentGroupImpl;
import org.broadleafcommerce.core.order.domain.FulfillmentOption;
import org.broadleafcommerce.core.order.domain.FulfillmentOptionImpl;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.PersonalMessageImpl;
import org.broadleafcommerce.core.order.service.type.FulfillmentGroupStatusType;
import org.broadleafcommerce.core.order.service.type.FulfillmentType;
import org.broadleafcommerce.core.pricing.service.fulfillment.provider.BandedFulfillmentPricingProvider;
import org.broadleafcommerce.core.pricing.service.fulfillment.provider.FulfillmentEstimationResponse;
import org.broadleafcommerce.core.pricing.service.fulfillment.provider.FulfillmentPricingProvider;
import org.broadleafcommerce.profile.core.domain.AddressImpl;
import org.broadleafcommerce.profile.core.domain.PhoneImpl;
import org.junit.Test;
import org.mockito.Mockito;

public class FulfillmentPricingServiceImplDiffblueTest {
  /**
   * Test
   * {@link FulfillmentPricingServiceImpl#calculateCostForFulfillmentGroup(FulfillmentGroup)}.
   * <p>
   * Method under test:
   * {@link FulfillmentPricingServiceImpl#calculateCostForFulfillmentGroup(FulfillmentGroup)}
   */
  @Test
  public void testCalculateCostForFulfillmentGroup() throws FulfillmentPriceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ArrayList<FulfillmentPricingProvider> providers = new ArrayList<>();
    providers.add(new BandedFulfillmentPricingProvider());

    FulfillmentPricingServiceImpl fulfillmentPricingServiceImpl = new FulfillmentPricingServiceImpl();
    fulfillmentPricingServiceImpl.setProviders(providers);

    FulfillmentGroupImpl fulfillmentGroup = new FulfillmentGroupImpl();
    fulfillmentGroup.setAddress(new AddressImpl());
    fulfillmentGroup.setCandidateFulfillmentGroupOffer(new ArrayList<>());
    fulfillmentGroup.setDeliveryInstruction("Delivery Instruction");
    fulfillmentGroup.setFulfillmentGroupAdjustments(new ArrayList<>());
    fulfillmentGroup.setFulfillmentGroupFees(new ArrayList<>());
    fulfillmentGroup.setFulfillmentGroupItems(new ArrayList<>());
    fulfillmentGroup.setFulfillmentPrice(new Money());
    fulfillmentGroup.setId(1L);
    fulfillmentGroup.setIsShippingPriceTaxable(true);
    fulfillmentGroup.setMerchandiseTotal(new Money());
    fulfillmentGroup.setMethod("Fulfillment Method");
    fulfillmentGroup.setOrder(new NullOrderImpl());
    fulfillmentGroup.setPersonalMessage(new PersonalMessageImpl());
    fulfillmentGroup.setPhone(new PhoneImpl());
    fulfillmentGroup.setPrimary(true);
    fulfillmentGroup.setReferenceNumber("42");
    fulfillmentGroup.setRetailFulfillmentPrice(new Money());
    fulfillmentGroup.setRetailShippingPrice(new Money());
    fulfillmentGroup.setSaleFulfillmentPrice(new Money());
    fulfillmentGroup.setSaleShippingPrice(new Money());
    fulfillmentGroup.setSequence(1);
    fulfillmentGroup.setService("Service");
    fulfillmentGroup.setShippingOverride(true);
    fulfillmentGroup.setShippingPrice(new Money());
    fulfillmentGroup.setStatus(FulfillmentGroupStatusType.CANCELLED);
    fulfillmentGroup.setTaxes(new ArrayList<>());
    fulfillmentGroup.setTotal(new Money());
    fulfillmentGroup.setTotalFeeTax(new Money());
    fulfillmentGroup.setTotalFulfillmentGroupTax(new Money());
    fulfillmentGroup.setTotalItemTax(new Money());
    fulfillmentGroup.setTotalTax(new Money());
    fulfillmentGroup.setType(FulfillmentType.DIGITAL);
    fulfillmentGroup.setFulfillmentOption(new FulfillmentOptionImpl());

    // Act and Assert
    assertThrows(FulfillmentPriceException.class,
        () -> fulfillmentPricingServiceImpl.calculateCostForFulfillmentGroup(fulfillmentGroup));
  }

  /**
   * Test
   * {@link FulfillmentPricingServiceImpl#calculateCostForFulfillmentGroup(FulfillmentGroup)}.
   * <p>
   * Method under test:
   * {@link FulfillmentPricingServiceImpl#calculateCostForFulfillmentGroup(FulfillmentGroup)}
   */
  @Test
  public void testCalculateCostForFulfillmentGroup2() throws FulfillmentPriceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BandedFulfillmentPricingProvider bandedFulfillmentPricingProvider = mock(BandedFulfillmentPricingProvider.class);
    when(bandedFulfillmentPricingProvider.calculateCostForFulfillmentGroup(Mockito.<FulfillmentGroup>any()))
        .thenThrow(new FulfillmentPriceException("An error occurred"));
    when(bandedFulfillmentPricingProvider.canCalculateCostForFulfillmentGroup(Mockito.<FulfillmentGroup>any(),
        Mockito.<FulfillmentOption>any())).thenReturn(true);

    ArrayList<FulfillmentPricingProvider> providers = new ArrayList<>();
    providers.add(bandedFulfillmentPricingProvider);

    FulfillmentPricingServiceImpl fulfillmentPricingServiceImpl = new FulfillmentPricingServiceImpl();
    fulfillmentPricingServiceImpl.setProviders(providers);

    FulfillmentGroupImpl fulfillmentGroup = new FulfillmentGroupImpl();
    fulfillmentGroup.setAddress(new AddressImpl());
    fulfillmentGroup.setCandidateFulfillmentGroupOffer(new ArrayList<>());
    fulfillmentGroup.setDeliveryInstruction("Delivery Instruction");
    fulfillmentGroup.setFulfillmentGroupAdjustments(new ArrayList<>());
    fulfillmentGroup.setFulfillmentGroupFees(new ArrayList<>());
    fulfillmentGroup.setFulfillmentGroupItems(new ArrayList<>());
    fulfillmentGroup.setFulfillmentPrice(new Money());
    fulfillmentGroup.setId(1L);
    fulfillmentGroup.setIsShippingPriceTaxable(true);
    fulfillmentGroup.setMerchandiseTotal(new Money());
    fulfillmentGroup.setMethod("Fulfillment Method");
    fulfillmentGroup.setOrder(new NullOrderImpl());
    fulfillmentGroup.setPersonalMessage(new PersonalMessageImpl());
    fulfillmentGroup.setPhone(new PhoneImpl());
    fulfillmentGroup.setPrimary(true);
    fulfillmentGroup.setReferenceNumber("42");
    fulfillmentGroup.setRetailFulfillmentPrice(new Money());
    fulfillmentGroup.setRetailShippingPrice(new Money());
    fulfillmentGroup.setSaleFulfillmentPrice(new Money());
    fulfillmentGroup.setSaleShippingPrice(new Money());
    fulfillmentGroup.setSequence(1);
    fulfillmentGroup.setService("Service");
    fulfillmentGroup.setShippingOverride(true);
    fulfillmentGroup.setShippingPrice(new Money());
    fulfillmentGroup.setStatus(FulfillmentGroupStatusType.CANCELLED);
    fulfillmentGroup.setTaxes(new ArrayList<>());
    fulfillmentGroup.setTotal(new Money());
    fulfillmentGroup.setTotalFeeTax(new Money());
    fulfillmentGroup.setTotalFulfillmentGroupTax(new Money());
    fulfillmentGroup.setTotalItemTax(new Money());
    fulfillmentGroup.setTotalTax(new Money());
    fulfillmentGroup.setType(FulfillmentType.DIGITAL);
    fulfillmentGroup.setFulfillmentOption(new FulfillmentOptionImpl());

    // Act and Assert
    assertThrows(FulfillmentPriceException.class,
        () -> fulfillmentPricingServiceImpl.calculateCostForFulfillmentGroup(fulfillmentGroup));
    verify(bandedFulfillmentPricingProvider).calculateCostForFulfillmentGroup(isA(FulfillmentGroup.class));
    verify(bandedFulfillmentPricingProvider).canCalculateCostForFulfillmentGroup(isA(FulfillmentGroup.class),
        isA(FulfillmentOption.class));
  }

  /**
   * Test
   * {@link FulfillmentPricingServiceImpl#calculateCostForFulfillmentGroup(FulfillmentGroup)}.
   * <ul>
   *   <li>Then return {@link FulfillmentGroupImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FulfillmentPricingServiceImpl#calculateCostForFulfillmentGroup(FulfillmentGroup)}
   */
  @Test
  public void testCalculateCostForFulfillmentGroup_thenReturnFulfillmentGroupImpl() throws FulfillmentPriceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentPricingServiceImpl fulfillmentPricingServiceImpl = new FulfillmentPricingServiceImpl();
    FulfillmentGroupImpl fulfillmentGroup = new FulfillmentGroupImpl();

    // Act and Assert
    assertSame(fulfillmentGroup, fulfillmentPricingServiceImpl.calculateCostForFulfillmentGroup(fulfillmentGroup));
  }

  /**
   * Test
   * {@link FulfillmentPricingServiceImpl#calculateCostForFulfillmentGroup(FulfillmentGroup)}.
   * <ul>
   *   <li>Then return {@link FulfillmentGroupImpl}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FulfillmentPricingServiceImpl#calculateCostForFulfillmentGroup(FulfillmentGroup)}
   */
  @Test
  public void testCalculateCostForFulfillmentGroup_thenReturnFulfillmentGroupImpl2() throws FulfillmentPriceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BandedFulfillmentPricingProvider bandedFulfillmentPricingProvider = mock(BandedFulfillmentPricingProvider.class);
    when(bandedFulfillmentPricingProvider.calculateCostForFulfillmentGroup(Mockito.<FulfillmentGroup>any()))
        .thenReturn(new FulfillmentGroupImpl());
    when(bandedFulfillmentPricingProvider.canCalculateCostForFulfillmentGroup(Mockito.<FulfillmentGroup>any(),
        Mockito.<FulfillmentOption>any())).thenReturn(true);

    ArrayList<FulfillmentPricingProvider> providers = new ArrayList<>();
    providers.add(bandedFulfillmentPricingProvider);

    FulfillmentPricingServiceImpl fulfillmentPricingServiceImpl = new FulfillmentPricingServiceImpl();
    fulfillmentPricingServiceImpl.setProviders(providers);

    FulfillmentGroupImpl fulfillmentGroup = new FulfillmentGroupImpl();
    fulfillmentGroup.setAddress(new AddressImpl());
    fulfillmentGroup.setCandidateFulfillmentGroupOffer(new ArrayList<>());
    fulfillmentGroup.setDeliveryInstruction("Delivery Instruction");
    fulfillmentGroup.setFulfillmentGroupAdjustments(new ArrayList<>());
    fulfillmentGroup.setFulfillmentGroupFees(new ArrayList<>());
    fulfillmentGroup.setFulfillmentGroupItems(new ArrayList<>());
    fulfillmentGroup.setFulfillmentPrice(new Money());
    fulfillmentGroup.setId(1L);
    fulfillmentGroup.setIsShippingPriceTaxable(true);
    fulfillmentGroup.setMerchandiseTotal(new Money());
    fulfillmentGroup.setMethod("Fulfillment Method");
    fulfillmentGroup.setOrder(new NullOrderImpl());
    fulfillmentGroup.setPersonalMessage(new PersonalMessageImpl());
    fulfillmentGroup.setPhone(new PhoneImpl());
    fulfillmentGroup.setPrimary(true);
    fulfillmentGroup.setReferenceNumber("42");
    fulfillmentGroup.setRetailFulfillmentPrice(new Money());
    fulfillmentGroup.setRetailShippingPrice(new Money());
    fulfillmentGroup.setSaleFulfillmentPrice(new Money());
    fulfillmentGroup.setSaleShippingPrice(new Money());
    fulfillmentGroup.setSequence(1);
    fulfillmentGroup.setService("Service");
    fulfillmentGroup.setShippingOverride(true);
    fulfillmentGroup.setShippingPrice(new Money());
    fulfillmentGroup.setStatus(FulfillmentGroupStatusType.CANCELLED);
    fulfillmentGroup.setTaxes(new ArrayList<>());
    fulfillmentGroup.setTotal(new Money());
    fulfillmentGroup.setTotalFeeTax(new Money());
    fulfillmentGroup.setTotalFulfillmentGroupTax(new Money());
    fulfillmentGroup.setTotalItemTax(new Money());
    fulfillmentGroup.setTotalTax(new Money());
    fulfillmentGroup.setType(FulfillmentType.DIGITAL);
    fulfillmentGroup.setFulfillmentOption(new FulfillmentOptionImpl());

    // Act
    FulfillmentGroup actualCalculateCostForFulfillmentGroupResult = fulfillmentPricingServiceImpl
        .calculateCostForFulfillmentGroup(fulfillmentGroup);

    // Assert
    verify(bandedFulfillmentPricingProvider).calculateCostForFulfillmentGroup(isA(FulfillmentGroup.class));
    verify(bandedFulfillmentPricingProvider).canCalculateCostForFulfillmentGroup(isA(FulfillmentGroup.class),
        isA(FulfillmentOption.class));
    assertTrue(actualCalculateCostForFulfillmentGroupResult instanceof FulfillmentGroupImpl);
    assertNull(actualCalculateCostForFulfillmentGroupResult.getFulfillmentPrice());
    assertNull(actualCalculateCostForFulfillmentGroupResult.getRetailFulfillmentPrice());
    assertNull(actualCalculateCostForFulfillmentGroupResult.getRetailShippingPrice());
    assertNull(actualCalculateCostForFulfillmentGroupResult.getSaleFulfillmentPrice());
    assertNull(actualCalculateCostForFulfillmentGroupResult.getSaleShippingPrice());
    assertNull(actualCalculateCostForFulfillmentGroupResult.getShippingPrice());
  }

  /**
   * Test
   * {@link FulfillmentPricingServiceImpl#estimateCostForFulfillmentGroup(FulfillmentGroup, Set)}.
   * <p>
   * Method under test:
   * {@link FulfillmentPricingServiceImpl#estimateCostForFulfillmentGroup(FulfillmentGroup, Set)}
   */
  @Test
  public void testEstimateCostForFulfillmentGroup() throws FulfillmentPriceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ArrayList<FulfillmentPricingProvider> providers = new ArrayList<>();
    providers.add(new BandedFulfillmentPricingProvider());

    FulfillmentPricingServiceImpl fulfillmentPricingServiceImpl = new FulfillmentPricingServiceImpl();
    fulfillmentPricingServiceImpl.setProviders(providers);
    FulfillmentGroupImpl fulfillmentGroup = new FulfillmentGroupImpl();

    // Act and Assert
    assertTrue(fulfillmentPricingServiceImpl.estimateCostForFulfillmentGroup(fulfillmentGroup, new HashSet<>())
        .getFulfillmentOptionPrices()
        .isEmpty());
  }

  /**
   * Test
   * {@link FulfillmentPricingServiceImpl#estimateCostForFulfillmentGroup(FulfillmentGroup, Set)}.
   * <p>
   * Method under test:
   * {@link FulfillmentPricingServiceImpl#estimateCostForFulfillmentGroup(FulfillmentGroup, Set)}
   */
  @Test
  public void testEstimateCostForFulfillmentGroup2() throws FulfillmentPriceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BandedFulfillmentPricingProvider bandedFulfillmentPricingProvider = mock(BandedFulfillmentPricingProvider.class);
    when(bandedFulfillmentPricingProvider.estimateCostForFulfillmentGroup(Mockito.<FulfillmentGroup>any(),
        Mockito.<Set<FulfillmentOption>>any())).thenThrow(new FulfillmentPriceException("An error occurred"));

    ArrayList<FulfillmentPricingProvider> providers = new ArrayList<>();
    providers.add(bandedFulfillmentPricingProvider);

    FulfillmentPricingServiceImpl fulfillmentPricingServiceImpl = new FulfillmentPricingServiceImpl();
    fulfillmentPricingServiceImpl.setProviders(providers);
    FulfillmentGroupImpl fulfillmentGroup = new FulfillmentGroupImpl();

    // Act
    FulfillmentEstimationResponse actualEstimateCostForFulfillmentGroupResult = fulfillmentPricingServiceImpl
        .estimateCostForFulfillmentGroup(fulfillmentGroup, new HashSet<>());

    // Assert
    verify(bandedFulfillmentPricingProvider).estimateCostForFulfillmentGroup(isA(FulfillmentGroup.class),
        isA(Set.class));
    assertTrue(actualEstimateCostForFulfillmentGroupResult.getFulfillmentOptionPrices().isEmpty());
  }

  /**
   * Test
   * {@link FulfillmentPricingServiceImpl#estimateCostForFulfillmentGroup(FulfillmentGroup, Set)}.
   * <ul>
   *   <li>Then return FulfillmentOptionPrices size is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FulfillmentPricingServiceImpl#estimateCostForFulfillmentGroup(FulfillmentGroup, Set)}
   */
  @Test
  public void testEstimateCostForFulfillmentGroup_thenReturnFulfillmentOptionPricesSizeIsOne()
      throws FulfillmentPriceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    HashMap<FulfillmentOption, Money> fulfillmentOptionPrices = new HashMap<>();
    FulfillmentOptionImpl fulfillmentOptionImpl = new FulfillmentOptionImpl();
    fulfillmentOptionPrices.put(fulfillmentOptionImpl, new Money());

    FulfillmentEstimationResponse fulfillmentEstimationResponse = new FulfillmentEstimationResponse();
    fulfillmentEstimationResponse.setFulfillmentOptionPrices(fulfillmentOptionPrices);
    BandedFulfillmentPricingProvider bandedFulfillmentPricingProvider = mock(BandedFulfillmentPricingProvider.class);
    when(bandedFulfillmentPricingProvider.estimateCostForFulfillmentGroup(Mockito.<FulfillmentGroup>any(),
        Mockito.<Set<FulfillmentOption>>any())).thenReturn(fulfillmentEstimationResponse);

    ArrayList<FulfillmentPricingProvider> providers = new ArrayList<>();
    providers.add(bandedFulfillmentPricingProvider);

    FulfillmentPricingServiceImpl fulfillmentPricingServiceImpl = new FulfillmentPricingServiceImpl();
    fulfillmentPricingServiceImpl.setProviders(providers);
    FulfillmentGroupImpl fulfillmentGroup = new FulfillmentGroupImpl();

    // Act
    FulfillmentEstimationResponse actualEstimateCostForFulfillmentGroupResult = fulfillmentPricingServiceImpl
        .estimateCostForFulfillmentGroup(fulfillmentGroup, new HashSet<>());

    // Assert
    verify(bandedFulfillmentPricingProvider).estimateCostForFulfillmentGroup(isA(FulfillmentGroup.class),
        isA(Set.class));
    assertEquals(1, actualEstimateCostForFulfillmentGroupResult.getFulfillmentOptionPrices().size());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link FulfillmentPricingServiceImpl#setProviders(List)}
   *   <li>{@link FulfillmentPricingServiceImpl#getProviders()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    FulfillmentPricingServiceImpl fulfillmentPricingServiceImpl = new FulfillmentPricingServiceImpl();
    ArrayList<FulfillmentPricingProvider> providers = new ArrayList<>();

    // Act
    fulfillmentPricingServiceImpl.setProviders(providers);
    List<FulfillmentPricingProvider> actualProviders = fulfillmentPricingServiceImpl.getProviders();

    // Assert that nothing has changed
    assertTrue(actualProviders.isEmpty());
    assertSame(providers, actualProviders);
  }
}
