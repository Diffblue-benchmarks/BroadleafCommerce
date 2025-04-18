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
package org.broadleafcommerce.core.pricing.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
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
import org.broadleafcommerce.core.order.fulfillment.domain.BandedPriceFulfillmentOptionImpl;
import org.broadleafcommerce.core.order.fulfillment.domain.FulfillmentPriceBand;
import org.broadleafcommerce.core.order.fulfillment.domain.FulfillmentPriceBandImpl;
import org.broadleafcommerce.core.order.service.FulfillmentGroupService;
import org.broadleafcommerce.core.order.service.type.FulfillmentGroupStatusType;
import org.broadleafcommerce.core.order.service.type.FulfillmentType;
import org.broadleafcommerce.core.pricing.service.fulfillment.provider.BandedFulfillmentPricingProvider;
import org.broadleafcommerce.core.pricing.service.fulfillment.provider.FulfillmentEstimationResponse;
import org.broadleafcommerce.core.pricing.service.fulfillment.provider.FulfillmentPricingProvider;
import org.broadleafcommerce.profile.core.domain.AddressImpl;
import org.broadleafcommerce.profile.core.domain.PhoneImpl;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;

@RunWith(MockitoJUnitRunner.class)
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class FulfillmentPricingServiceImplDiffblueTest {
  @Mock
  private FulfillmentGroupService fulfillmentGroupService;

  @InjectMocks
  private FulfillmentPricingServiceImpl fulfillmentPricingServiceImpl;

  @Mock
  private List<FulfillmentPricingProvider> list;

  /**
   * Test {@link FulfillmentPricingServiceImpl#calculateCostForFulfillmentGroup(FulfillmentGroup)}.
   * <ul>
   *   <li>Then return {@link FulfillmentGroupImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentPricingServiceImpl#calculateCostForFulfillmentGroup(FulfillmentGroup)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "FulfillmentGroup FulfillmentPricingServiceImpl.calculateCostForFulfillmentGroup(FulfillmentGroup)"})
  public void testCalculateCostForFulfillmentGroup_thenReturnFulfillmentGroupImpl() throws FulfillmentPriceException {
    // Arrange
    FulfillmentGroupImpl fulfillmentGroup = new FulfillmentGroupImpl();

    // Act and Assert
    assertSame(fulfillmentGroup, fulfillmentPricingServiceImpl.calculateCostForFulfillmentGroup(fulfillmentGroup));
  }

  /**
   * Test {@link FulfillmentPricingServiceImpl#calculateCostForFulfillmentGroup(FulfillmentGroup)}.
   * <ul>
   *   <li>Then return {@link FulfillmentGroupImpl}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentPricingServiceImpl#calculateCostForFulfillmentGroup(FulfillmentGroup)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "FulfillmentGroup FulfillmentPricingServiceImpl.calculateCostForFulfillmentGroup(FulfillmentGroup)"})
  public void testCalculateCostForFulfillmentGroup_thenReturnFulfillmentGroupImpl2() throws FulfillmentPriceException {
    // Arrange
    ArrayList<FulfillmentPricingProvider> fulfillmentPricingProviderList = new ArrayList<>();
    fulfillmentPricingProviderList.add(new BandedFulfillmentPricingProvider());
    when(list.iterator()).thenReturn(fulfillmentPricingProviderList.iterator());

    ArrayList<FulfillmentPriceBand> bands = new ArrayList<>();
    bands.add(new FulfillmentPriceBandImpl());

    BandedPriceFulfillmentOptionImpl bandedPriceFulfillmentOptionImpl = new BandedPriceFulfillmentOptionImpl();
    bandedPriceFulfillmentOptionImpl.setBands(bands);
    bandedPriceFulfillmentOptionImpl.setFulfillmentType(FulfillmentType.DIGITAL);
    bandedPriceFulfillmentOptionImpl.setId(1L);
    bandedPriceFulfillmentOptionImpl.setLongDescription("Long Description");
    bandedPriceFulfillmentOptionImpl.setName("Name");
    bandedPriceFulfillmentOptionImpl.setTaxCode("Tax Code");
    bandedPriceFulfillmentOptionImpl.setTaxable(true);
    bandedPriceFulfillmentOptionImpl.setUseFlatRates(true);
    FulfillmentGroupImpl fulfillmentGroup = mock(FulfillmentGroupImpl.class);
    when(fulfillmentGroup.getId()).thenReturn(1L);
    when(fulfillmentGroup.getFulfillmentGroupItems()).thenReturn(new ArrayList<>());
    when(fulfillmentGroup.getFulfillmentOption()).thenReturn(bandedPriceFulfillmentOptionImpl);
    doNothing().when(fulfillmentGroup).setFulfillmentPrice(Mockito.<Money>any());
    doNothing().when(fulfillmentGroup).setRetailFulfillmentPrice(Mockito.<Money>any());
    doNothing().when(fulfillmentGroup).setSaleFulfillmentPrice(Mockito.<Money>any());

    // Act
    FulfillmentGroup actualCalculateCostForFulfillmentGroupResult = fulfillmentPricingServiceImpl
        .calculateCostForFulfillmentGroup(fulfillmentGroup);

    // Assert
    verify(list).iterator();
    verify(fulfillmentGroup).getFulfillmentGroupItems();
    verify(fulfillmentGroup, atLeast(1)).getFulfillmentOption();
    verify(fulfillmentGroup).getId();
    verify(fulfillmentGroup).setFulfillmentPrice(isA(Money.class));
    verify(fulfillmentGroup).setRetailFulfillmentPrice(isA(Money.class));
    verify(fulfillmentGroup).setSaleFulfillmentPrice(isA(Money.class));
    assertSame(fulfillmentGroup, actualCalculateCostForFulfillmentGroupResult);
  }

  /**
   * Test {@link FulfillmentPricingServiceImpl#calculateCostForFulfillmentGroup(FulfillmentGroup)}.
   * <ul>
   *   <li>Then throw {@link FulfillmentPriceException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentPricingServiceImpl#calculateCostForFulfillmentGroup(FulfillmentGroup)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "FulfillmentGroup FulfillmentPricingServiceImpl.calculateCostForFulfillmentGroup(FulfillmentGroup)"})
  public void testCalculateCostForFulfillmentGroup_thenThrowFulfillmentPriceException()
      throws FulfillmentPriceException {
    // Arrange
    ArrayList<FulfillmentPricingProvider> providers = new ArrayList<>();
    providers.add(new BandedFulfillmentPricingProvider());
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
    fulfillmentGroup.setSaleFulfillmentPrice(new Money());
    fulfillmentGroup.setSequence(1);
    fulfillmentGroup.setService("Service");
    fulfillmentGroup.setShippingOverride(true);
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
   * Test {@link FulfillmentPricingServiceImpl#estimateCostForFulfillmentGroup(FulfillmentGroup, Set)}.
   * <p>
   * Method under test: {@link FulfillmentPricingServiceImpl#estimateCostForFulfillmentGroup(FulfillmentGroup, Set)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "FulfillmentEstimationResponse FulfillmentPricingServiceImpl.estimateCostForFulfillmentGroup(FulfillmentGroup, Set)"})
  public void testEstimateCostForFulfillmentGroup() throws FulfillmentPriceException {
    // Arrange
    ArrayList<FulfillmentPricingProvider> providers = new ArrayList<>();
    providers.add(new BandedFulfillmentPricingProvider());
    fulfillmentPricingServiceImpl.setProviders(providers);
    FulfillmentGroupImpl fulfillmentGroup = new FulfillmentGroupImpl();

    // Act and Assert
    assertTrue(fulfillmentPricingServiceImpl.estimateCostForFulfillmentGroup(fulfillmentGroup, new HashSet<>())
        .getFulfillmentOptionPrices()
        .isEmpty());
  }

  /**
   * Test {@link FulfillmentPricingServiceImpl#estimateCostForFulfillmentGroup(FulfillmentGroup, Set)}.
   * <p>
   * Method under test: {@link FulfillmentPricingServiceImpl#estimateCostForFulfillmentGroup(FulfillmentGroup, Set)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "FulfillmentEstimationResponse FulfillmentPricingServiceImpl.estimateCostForFulfillmentGroup(FulfillmentGroup, Set)"})
  public void testEstimateCostForFulfillmentGroup2() throws FulfillmentPriceException {
    // Arrange
    BandedFulfillmentPricingProvider bandedFulfillmentPricingProvider = mock(BandedFulfillmentPricingProvider.class);
    when(bandedFulfillmentPricingProvider.estimateCostForFulfillmentGroup(Mockito.<FulfillmentGroup>any(),
        Mockito.<Set<FulfillmentOption>>any())).thenThrow(new FulfillmentPriceException("An error occurred"));

    ArrayList<FulfillmentPricingProvider> providers = new ArrayList<>();
    providers.add(bandedFulfillmentPricingProvider);
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
   * Test {@link FulfillmentPricingServiceImpl#estimateCostForFulfillmentGroup(FulfillmentGroup, Set)}.
   * <ul>
   *   <li>Then calls {@link List#iterator()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentPricingServiceImpl#estimateCostForFulfillmentGroup(FulfillmentGroup, Set)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "FulfillmentEstimationResponse FulfillmentPricingServiceImpl.estimateCostForFulfillmentGroup(FulfillmentGroup, Set)"})
  public void testEstimateCostForFulfillmentGroup_thenCallsIterator() throws FulfillmentPriceException {
    // Arrange
    ArrayList<FulfillmentPricingProvider> fulfillmentPricingProviderList = new ArrayList<>();
    when(list.iterator()).thenReturn(fulfillmentPricingProviderList.iterator());
    FulfillmentGroupImpl fulfillmentGroup = new FulfillmentGroupImpl();

    HashSet<FulfillmentOption> options = new HashSet<>();
    options.add(new FulfillmentOptionImpl());

    // Act
    FulfillmentEstimationResponse actualEstimateCostForFulfillmentGroupResult = fulfillmentPricingServiceImpl
        .estimateCostForFulfillmentGroup(fulfillmentGroup, options);

    // Assert
    verify(list).iterator();
    assertTrue(actualEstimateCostForFulfillmentGroupResult.getFulfillmentOptionPrices().isEmpty());
  }

  /**
   * Test {@link FulfillmentPricingServiceImpl#estimateCostForFulfillmentGroup(FulfillmentGroup, Set)}.
   * <ul>
   *   <li>Then return FulfillmentOptionPrices size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentPricingServiceImpl#estimateCostForFulfillmentGroup(FulfillmentGroup, Set)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "FulfillmentEstimationResponse FulfillmentPricingServiceImpl.estimateCostForFulfillmentGroup(FulfillmentGroup, Set)"})
  public void testEstimateCostForFulfillmentGroup_thenReturnFulfillmentOptionPricesSizeIsOne()
      throws FulfillmentPriceException {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List FulfillmentPricingServiceImpl.getProviders()",
      "void FulfillmentPricingServiceImpl.setProviders(List)"})
  public void testGettersAndSetters() {
    // Arrange
    FulfillmentPricingServiceImpl fulfillmentPricingServiceImpl = new FulfillmentPricingServiceImpl();
    ArrayList<FulfillmentPricingProvider> providers = new ArrayList<>();

    // Act
    fulfillmentPricingServiceImpl.setProviders(providers);
    List<FulfillmentPricingProvider> actualProviders = fulfillmentPricingServiceImpl.getProviders();

    // Assert
    assertTrue(actualProviders.isEmpty());
    assertSame(providers, actualProviders);
  }
}
