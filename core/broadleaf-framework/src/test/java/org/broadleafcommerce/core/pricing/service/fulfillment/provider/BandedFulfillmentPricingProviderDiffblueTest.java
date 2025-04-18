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
package org.broadleafcommerce.core.pricing.service.fulfillment.provider;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
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
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.common.util.WeightUnitOfMeasureType;
import org.broadleafcommerce.common.vendor.service.exception.FulfillmentPriceException;
import org.broadleafcommerce.core.order.domain.FulfillmentGroup;
import org.broadleafcommerce.core.order.domain.FulfillmentGroupImpl;
import org.broadleafcommerce.core.order.domain.FulfillmentGroupItem;
import org.broadleafcommerce.core.order.domain.FulfillmentGroupItemImpl;
import org.broadleafcommerce.core.order.domain.FulfillmentOption;
import org.broadleafcommerce.core.order.domain.FulfillmentOptionImpl;
import org.broadleafcommerce.core.order.fulfillment.domain.BandedPriceFulfillmentOptionImpl;
import org.broadleafcommerce.core.order.fulfillment.domain.BandedWeightFulfillmentOptionImpl;
import org.broadleafcommerce.core.order.service.type.FulfillmentType;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {BandedFulfillmentPricingProvider.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class BandedFulfillmentPricingProviderDiffblueTest {
  @Autowired
  private BandedFulfillmentPricingProvider bandedFulfillmentPricingProvider;

  /**
   * Test {@link BandedFulfillmentPricingProvider#canCalculateCostForFulfillmentGroup(FulfillmentGroup, FulfillmentOption)}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BandedFulfillmentPricingProvider#canCalculateCostForFulfillmentGroup(FulfillmentGroup, FulfillmentOption)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "boolean BandedFulfillmentPricingProvider.canCalculateCostForFulfillmentGroup(FulfillmentGroup, FulfillmentOption)"})
  public void testCanCalculateCostForFulfillmentGroup_thenReturnFalse() {
    // Arrange
    FulfillmentGroupImpl fulfillmentGroup = new FulfillmentGroupImpl();

    // Act and Assert
    assertFalse(bandedFulfillmentPricingProvider.canCalculateCostForFulfillmentGroup(fulfillmentGroup,
        new FulfillmentOptionImpl()));
  }

  /**
   * Test {@link BandedFulfillmentPricingProvider#canCalculateCostForFulfillmentGroup(FulfillmentGroup, FulfillmentOption)}.
   * <ul>
   *   <li>When {@link BandedPriceFulfillmentOptionImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link BandedFulfillmentPricingProvider#canCalculateCostForFulfillmentGroup(FulfillmentGroup, FulfillmentOption)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "boolean BandedFulfillmentPricingProvider.canCalculateCostForFulfillmentGroup(FulfillmentGroup, FulfillmentOption)"})
  public void testCanCalculateCostForFulfillmentGroup_whenBandedPriceFulfillmentOptionImpl() {
    // Arrange
    FulfillmentGroupImpl fulfillmentGroup = new FulfillmentGroupImpl();

    // Act and Assert
    assertTrue(bandedFulfillmentPricingProvider.canCalculateCostForFulfillmentGroup(fulfillmentGroup,
        new BandedPriceFulfillmentOptionImpl()));
  }

  /**
   * Test {@link BandedFulfillmentPricingProvider#canCalculateCostForFulfillmentGroup(FulfillmentGroup, FulfillmentOption)}.
   * <ul>
   *   <li>When {@link BandedWeightFulfillmentOptionImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link BandedFulfillmentPricingProvider#canCalculateCostForFulfillmentGroup(FulfillmentGroup, FulfillmentOption)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "boolean BandedFulfillmentPricingProvider.canCalculateCostForFulfillmentGroup(FulfillmentGroup, FulfillmentOption)"})
  public void testCanCalculateCostForFulfillmentGroup_whenBandedWeightFulfillmentOptionImpl() {
    // Arrange
    FulfillmentGroupImpl fulfillmentGroup = new FulfillmentGroupImpl();

    // Act and Assert
    assertTrue(bandedFulfillmentPricingProvider.canCalculateCostForFulfillmentGroup(fulfillmentGroup,
        new BandedWeightFulfillmentOptionImpl()));
  }

  /**
   * Test {@link BandedFulfillmentPricingProvider#calculateCostForFulfillmentGroup(FulfillmentGroup)}.
   * <p>
   * Method under test: {@link BandedFulfillmentPricingProvider#calculateCostForFulfillmentGroup(FulfillmentGroup)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "FulfillmentGroup BandedFulfillmentPricingProvider.calculateCostForFulfillmentGroup(FulfillmentGroup)"})
  public void testCalculateCostForFulfillmentGroup() throws FulfillmentPriceException {
    // Arrange
    ArrayList<FulfillmentGroupItem> fulfillmentGroupItemList = new ArrayList<>();
    fulfillmentGroupItemList.add(new FulfillmentGroupItemImpl());

    BandedPriceFulfillmentOptionImpl bandedPriceFulfillmentOptionImpl = new BandedPriceFulfillmentOptionImpl();
    bandedPriceFulfillmentOptionImpl.setBands(new ArrayList<>());
    bandedPriceFulfillmentOptionImpl.setFulfillmentType(FulfillmentType.DIGITAL);
    bandedPriceFulfillmentOptionImpl.setId(1L);
    bandedPriceFulfillmentOptionImpl.setLongDescription(
        "An unsupported FulfillmentOption was passed to the calculateCostForFulfillmentGroup method");
    bandedPriceFulfillmentOptionImpl
        .setName("An unsupported FulfillmentOption was passed to the calculateCostForFulfillmentGroup method");
    bandedPriceFulfillmentOptionImpl
        .setTaxCode("An unsupported FulfillmentOption was passed to the calculateCostForFulfillmentGroup method");
    bandedPriceFulfillmentOptionImpl.setTaxable(true);
    bandedPriceFulfillmentOptionImpl.setUseFlatRates(true);
    FulfillmentGroupImpl fulfillmentGroup = mock(FulfillmentGroupImpl.class);
    when(fulfillmentGroup.getFulfillmentOption()).thenReturn(bandedPriceFulfillmentOptionImpl);
    when(fulfillmentGroup.getFulfillmentGroupItems()).thenReturn(fulfillmentGroupItemList);

    // Act and Assert
    assertThrows(IllegalStateException.class,
        () -> bandedFulfillmentPricingProvider.calculateCostForFulfillmentGroup(fulfillmentGroup));
    verify(fulfillmentGroup).getFulfillmentGroupItems();
    verify(fulfillmentGroup, atLeast(1)).getFulfillmentOption();
  }

  /**
   * Test {@link BandedFulfillmentPricingProvider#calculateCostForFulfillmentGroup(FulfillmentGroup)}.
   * <p>
   * Method under test: {@link BandedFulfillmentPricingProvider#calculateCostForFulfillmentGroup(FulfillmentGroup)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "FulfillmentGroup BandedFulfillmentPricingProvider.calculateCostForFulfillmentGroup(FulfillmentGroup)"})
  public void testCalculateCostForFulfillmentGroup2() throws FulfillmentPriceException {
    // Arrange
    ArrayList<FulfillmentGroupItem> fulfillmentGroupItemList = new ArrayList<>();
    fulfillmentGroupItemList.add(new FulfillmentGroupItemImpl());

    BandedWeightFulfillmentOptionImpl bandedWeightFulfillmentOptionImpl = new BandedWeightFulfillmentOptionImpl();
    bandedWeightFulfillmentOptionImpl.setBands(new ArrayList<>());
    bandedWeightFulfillmentOptionImpl.setFulfillmentType(FulfillmentType.DIGITAL);
    bandedWeightFulfillmentOptionImpl.setId(1L);
    bandedWeightFulfillmentOptionImpl.setLongDescription(
        "An unsupported FulfillmentOption was passed to the calculateCostForFulfillmentGroup method");
    bandedWeightFulfillmentOptionImpl
        .setName("An unsupported FulfillmentOption was passed to the calculateCostForFulfillmentGroup method");
    bandedWeightFulfillmentOptionImpl
        .setTaxCode("An unsupported FulfillmentOption was passed to the calculateCostForFulfillmentGroup method");
    bandedWeightFulfillmentOptionImpl.setTaxable(true);
    bandedWeightFulfillmentOptionImpl.setUseFlatRates(true);
    FulfillmentGroupImpl fulfillmentGroup = mock(FulfillmentGroupImpl.class);
    when(fulfillmentGroup.getFulfillmentOption()).thenReturn(bandedWeightFulfillmentOptionImpl);
    when(fulfillmentGroup.getFulfillmentGroupItems()).thenReturn(fulfillmentGroupItemList);

    // Act and Assert
    assertThrows(IllegalStateException.class,
        () -> bandedFulfillmentPricingProvider.calculateCostForFulfillmentGroup(fulfillmentGroup));
    verify(fulfillmentGroup).getFulfillmentGroupItems();
    verify(fulfillmentGroup, atLeast(1)).getFulfillmentOption();
  }

  /**
   * Test {@link BandedFulfillmentPricingProvider#calculateCostForFulfillmentGroup(FulfillmentGroup)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>Then return {@link FulfillmentGroupImpl}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BandedFulfillmentPricingProvider#calculateCostForFulfillmentGroup(FulfillmentGroup)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "FulfillmentGroup BandedFulfillmentPricingProvider.calculateCostForFulfillmentGroup(FulfillmentGroup)"})
  public void testCalculateCostForFulfillmentGroup_givenOne_thenReturnFulfillmentGroupImpl()
      throws FulfillmentPriceException {
    // Arrange
    FulfillmentGroupImpl fulfillmentGroup = mock(FulfillmentGroupImpl.class);
    when(fulfillmentGroup.getId()).thenReturn(1L);
    when(fulfillmentGroup.getFulfillmentGroupItems()).thenReturn(new ArrayList<>());
    doNothing().when(fulfillmentGroup).setFulfillmentPrice(Mockito.<Money>any());
    doNothing().when(fulfillmentGroup).setRetailFulfillmentPrice(Mockito.<Money>any());
    doNothing().when(fulfillmentGroup).setSaleFulfillmentPrice(Mockito.<Money>any());

    // Act
    FulfillmentGroup actualCalculateCostForFulfillmentGroupResult = bandedFulfillmentPricingProvider
        .calculateCostForFulfillmentGroup(fulfillmentGroup);

    // Assert
    verify(fulfillmentGroup).getFulfillmentGroupItems();
    verify(fulfillmentGroup).getId();
    verify(fulfillmentGroup).setFulfillmentPrice(isA(Money.class));
    verify(fulfillmentGroup).setRetailFulfillmentPrice(isA(Money.class));
    verify(fulfillmentGroup).setSaleFulfillmentPrice(isA(Money.class));
    assertSame(fulfillmentGroup, actualCalculateCostForFulfillmentGroupResult);
  }

  /**
   * Test {@link BandedFulfillmentPricingProvider#calculateCostForFulfillmentGroup(FulfillmentGroup)}.
   * <ul>
   *   <li>Then calls {@link BandedPriceFulfillmentOptionImpl#getBands()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BandedFulfillmentPricingProvider#calculateCostForFulfillmentGroup(FulfillmentGroup)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "FulfillmentGroup BandedFulfillmentPricingProvider.calculateCostForFulfillmentGroup(FulfillmentGroup)"})
  public void testCalculateCostForFulfillmentGroup_thenCallsGetBands() throws FulfillmentPriceException {
    // Arrange
    ArrayList<FulfillmentGroupItem> fulfillmentGroupItemList = new ArrayList<>();
    fulfillmentGroupItemList.add(new FulfillmentGroupItemImpl());
    BandedPriceFulfillmentOptionImpl bandedPriceFulfillmentOptionImpl = mock(BandedPriceFulfillmentOptionImpl.class);
    when(bandedPriceFulfillmentOptionImpl.getBands()).thenThrow(new IllegalStateException("foo"));
    FulfillmentGroupImpl fulfillmentGroup = mock(FulfillmentGroupImpl.class);
    when(fulfillmentGroup.getFulfillmentOption()).thenReturn(bandedPriceFulfillmentOptionImpl);
    when(fulfillmentGroup.getFulfillmentGroupItems()).thenReturn(fulfillmentGroupItemList);

    // Act and Assert
    assertThrows(IllegalStateException.class,
        () -> bandedFulfillmentPricingProvider.calculateCostForFulfillmentGroup(fulfillmentGroup));
    verify(fulfillmentGroup).getFulfillmentGroupItems();
    verify(fulfillmentGroup, atLeast(1)).getFulfillmentOption();
    verify(bandedPriceFulfillmentOptionImpl).getBands();
  }

  /**
   * Test {@link BandedFulfillmentPricingProvider#calculateCostForFulfillmentGroup(FulfillmentGroup)}.
   * <ul>
   *   <li>Then calls {@link BandedWeightFulfillmentOptionImpl#getBands()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BandedFulfillmentPricingProvider#calculateCostForFulfillmentGroup(FulfillmentGroup)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "FulfillmentGroup BandedFulfillmentPricingProvider.calculateCostForFulfillmentGroup(FulfillmentGroup)"})
  public void testCalculateCostForFulfillmentGroup_thenCallsGetBands2() throws FulfillmentPriceException {
    // Arrange
    ArrayList<FulfillmentGroupItem> fulfillmentGroupItemList = new ArrayList<>();
    fulfillmentGroupItemList.add(new FulfillmentGroupItemImpl());
    BandedWeightFulfillmentOptionImpl bandedWeightFulfillmentOptionImpl = mock(BandedWeightFulfillmentOptionImpl.class);
    when(bandedWeightFulfillmentOptionImpl.getBands()).thenThrow(new IllegalStateException("foo"));
    FulfillmentGroupImpl fulfillmentGroup = mock(FulfillmentGroupImpl.class);
    when(fulfillmentGroup.getFulfillmentOption()).thenReturn(bandedWeightFulfillmentOptionImpl);
    when(fulfillmentGroup.getFulfillmentGroupItems()).thenReturn(fulfillmentGroupItemList);

    // Act and Assert
    assertThrows(IllegalStateException.class,
        () -> bandedFulfillmentPricingProvider.calculateCostForFulfillmentGroup(fulfillmentGroup));
    verify(fulfillmentGroup).getFulfillmentGroupItems();
    verify(fulfillmentGroup, atLeast(1)).getFulfillmentOption();
    verify(bandedWeightFulfillmentOptionImpl).getBands();
  }

  /**
   * Test {@link BandedFulfillmentPricingProvider#calculateCostForFulfillmentGroup(FulfillmentGroup)}.
   * <ul>
   *   <li>Then return {@link FulfillmentGroupImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link BandedFulfillmentPricingProvider#calculateCostForFulfillmentGroup(FulfillmentGroup)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "FulfillmentGroup BandedFulfillmentPricingProvider.calculateCostForFulfillmentGroup(FulfillmentGroup)"})
  public void testCalculateCostForFulfillmentGroup_thenReturnFulfillmentGroupImpl() throws FulfillmentPriceException {
    // Arrange
    FulfillmentGroupImpl fulfillmentGroup = new FulfillmentGroupImpl();

    // Act and Assert
    assertSame(fulfillmentGroup, bandedFulfillmentPricingProvider.calculateCostForFulfillmentGroup(fulfillmentGroup));
  }

  /**
   * Test {@link BandedFulfillmentPricingProvider#calculateCostForFulfillmentGroup(FulfillmentGroup)}.
   * <ul>
   *   <li>Then throw {@link FulfillmentPriceException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BandedFulfillmentPricingProvider#calculateCostForFulfillmentGroup(FulfillmentGroup)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "FulfillmentGroup BandedFulfillmentPricingProvider.calculateCostForFulfillmentGroup(FulfillmentGroup)"})
  public void testCalculateCostForFulfillmentGroup_thenThrowFulfillmentPriceException()
      throws FulfillmentPriceException {
    // Arrange
    ArrayList<FulfillmentGroupItem> fulfillmentGroupItemList = new ArrayList<>();
    fulfillmentGroupItemList.add(new FulfillmentGroupItemImpl());
    FulfillmentGroupImpl fulfillmentGroup = mock(FulfillmentGroupImpl.class);
    when(fulfillmentGroup.getFulfillmentOption()).thenReturn(new FulfillmentOptionImpl());
    when(fulfillmentGroup.getFulfillmentGroupItems()).thenReturn(fulfillmentGroupItemList);

    // Act and Assert
    assertThrows(FulfillmentPriceException.class,
        () -> bandedFulfillmentPricingProvider.calculateCostForFulfillmentGroup(fulfillmentGroup));
    verify(fulfillmentGroup).getFulfillmentGroupItems();
    verify(fulfillmentGroup).getFulfillmentOption();
  }

  /**
   * Test {@link BandedFulfillmentPricingProvider#estimateCostForFulfillmentGroup(FulfillmentGroup, Set)}.
   * <p>
   * Method under test: {@link BandedFulfillmentPricingProvider#estimateCostForFulfillmentGroup(FulfillmentGroup, Set)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "org.broadleafcommerce.core.pricing.service.fulfillment.provider.FulfillmentEstimationResponse BandedFulfillmentPricingProvider.estimateCostForFulfillmentGroup(FulfillmentGroup, Set)"})
  public void testEstimateCostForFulfillmentGroup() throws FulfillmentPriceException {
    // Arrange
    FulfillmentGroupImpl fulfillmentGroup = new FulfillmentGroupImpl();

    BandedPriceFulfillmentOptionImpl bandedPriceFulfillmentOptionImpl = new BandedPriceFulfillmentOptionImpl();
    bandedPriceFulfillmentOptionImpl.setBands(new ArrayList<>());
    bandedPriceFulfillmentOptionImpl.setFulfillmentType(FulfillmentType.DIGITAL);
    bandedPriceFulfillmentOptionImpl.setId(1L);
    bandedPriceFulfillmentOptionImpl.setLongDescription("Long Description");
    bandedPriceFulfillmentOptionImpl.setName("Name");
    bandedPriceFulfillmentOptionImpl.setTaxCode("Tax Code");
    bandedPriceFulfillmentOptionImpl.setTaxable(true);
    bandedPriceFulfillmentOptionImpl.setUseFlatRates(true);

    HashSet<FulfillmentOption> options = new HashSet<>();
    options.add(bandedPriceFulfillmentOptionImpl);

    // Act and Assert
    assertThrows(IllegalStateException.class,
        () -> bandedFulfillmentPricingProvider.estimateCostForFulfillmentGroup(fulfillmentGroup, options));
  }

  /**
   * Test {@link BandedFulfillmentPricingProvider#estimateCostForFulfillmentGroup(FulfillmentGroup, Set)}.
   * <p>
   * Method under test: {@link BandedFulfillmentPricingProvider#estimateCostForFulfillmentGroup(FulfillmentGroup, Set)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "org.broadleafcommerce.core.pricing.service.fulfillment.provider.FulfillmentEstimationResponse BandedFulfillmentPricingProvider.estimateCostForFulfillmentGroup(FulfillmentGroup, Set)"})
  public void testEstimateCostForFulfillmentGroup2() throws FulfillmentPriceException {
    // Arrange
    FulfillmentGroupImpl fulfillmentGroup = new FulfillmentGroupImpl();

    BandedWeightFulfillmentOptionImpl bandedWeightFulfillmentOptionImpl = new BandedWeightFulfillmentOptionImpl();
    bandedWeightFulfillmentOptionImpl.setBands(new ArrayList<>());
    bandedWeightFulfillmentOptionImpl.setFulfillmentType(FulfillmentType.DIGITAL);
    bandedWeightFulfillmentOptionImpl.setId(1L);
    bandedWeightFulfillmentOptionImpl.setLongDescription("Long Description");
    bandedWeightFulfillmentOptionImpl.setName("Name");
    bandedWeightFulfillmentOptionImpl.setTaxCode("Tax Code");
    bandedWeightFulfillmentOptionImpl.setTaxable(true);
    bandedWeightFulfillmentOptionImpl.setUseFlatRates(true);

    HashSet<FulfillmentOption> options = new HashSet<>();
    options.add(bandedWeightFulfillmentOptionImpl);

    // Act and Assert
    assertThrows(IllegalStateException.class,
        () -> bandedFulfillmentPricingProvider.estimateCostForFulfillmentGroup(fulfillmentGroup, options));
  }

  /**
   * Test {@link BandedFulfillmentPricingProvider#estimateCostForFulfillmentGroup(FulfillmentGroup, Set)}.
   * <ul>
   *   <li>Given {@link FulfillmentOptionImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link BandedFulfillmentPricingProvider#estimateCostForFulfillmentGroup(FulfillmentGroup, Set)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "org.broadleafcommerce.core.pricing.service.fulfillment.provider.FulfillmentEstimationResponse BandedFulfillmentPricingProvider.estimateCostForFulfillmentGroup(FulfillmentGroup, Set)"})
  public void testEstimateCostForFulfillmentGroup_givenFulfillmentOptionImpl() throws FulfillmentPriceException {
    // Arrange
    FulfillmentGroupImpl fulfillmentGroup = new FulfillmentGroupImpl();
    BandedPriceFulfillmentOptionImpl bandedPriceFulfillmentOptionImpl = mock(BandedPriceFulfillmentOptionImpl.class);
    when(bandedPriceFulfillmentOptionImpl.getBands()).thenThrow(new IllegalStateException("foo"));

    HashSet<FulfillmentOption> options = new HashSet<>();
    options.add(new FulfillmentOptionImpl());
    options.add(bandedPriceFulfillmentOptionImpl);

    // Act and Assert
    assertThrows(IllegalStateException.class,
        () -> bandedFulfillmentPricingProvider.estimateCostForFulfillmentGroup(fulfillmentGroup, options));
    verify(bandedPriceFulfillmentOptionImpl).getBands();
  }

  /**
   * Test {@link BandedFulfillmentPricingProvider#estimateCostForFulfillmentGroup(FulfillmentGroup, Set)}.
   * <ul>
   *   <li>Then calls {@link BandedPriceFulfillmentOptionImpl#getBands()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BandedFulfillmentPricingProvider#estimateCostForFulfillmentGroup(FulfillmentGroup, Set)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "org.broadleafcommerce.core.pricing.service.fulfillment.provider.FulfillmentEstimationResponse BandedFulfillmentPricingProvider.estimateCostForFulfillmentGroup(FulfillmentGroup, Set)"})
  public void testEstimateCostForFulfillmentGroup_thenCallsGetBands() throws FulfillmentPriceException {
    // Arrange
    FulfillmentGroupImpl fulfillmentGroup = new FulfillmentGroupImpl();
    BandedPriceFulfillmentOptionImpl bandedPriceFulfillmentOptionImpl = mock(BandedPriceFulfillmentOptionImpl.class);
    when(bandedPriceFulfillmentOptionImpl.getBands()).thenThrow(new IllegalStateException("foo"));

    HashSet<FulfillmentOption> options = new HashSet<>();
    options.add(bandedPriceFulfillmentOptionImpl);

    // Act and Assert
    assertThrows(IllegalStateException.class,
        () -> bandedFulfillmentPricingProvider.estimateCostForFulfillmentGroup(fulfillmentGroup, options));
    verify(bandedPriceFulfillmentOptionImpl).getBands();
  }

  /**
   * Test {@link BandedFulfillmentPricingProvider#estimateCostForFulfillmentGroup(FulfillmentGroup, Set)}.
   * <ul>
   *   <li>Then return FulfillmentOptionPrices Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link BandedFulfillmentPricingProvider#estimateCostForFulfillmentGroup(FulfillmentGroup, Set)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "org.broadleafcommerce.core.pricing.service.fulfillment.provider.FulfillmentEstimationResponse BandedFulfillmentPricingProvider.estimateCostForFulfillmentGroup(FulfillmentGroup, Set)"})
  public void testEstimateCostForFulfillmentGroup_thenReturnFulfillmentOptionPricesEmpty()
      throws FulfillmentPriceException {
    // Arrange
    FulfillmentGroupImpl fulfillmentGroup = new FulfillmentGroupImpl();

    HashSet<FulfillmentOption> options = new HashSet<>();
    options.add(new FulfillmentOptionImpl());

    // Act and Assert
    assertTrue(bandedFulfillmentPricingProvider.estimateCostForFulfillmentGroup(fulfillmentGroup, options)
        .getFulfillmentOptionPrices()
        .isEmpty());
  }

  /**
   * Test {@link BandedFulfillmentPricingProvider#estimateCostForFulfillmentGroup(FulfillmentGroup, Set)}.
   * <ul>
   *   <li>When {@link HashSet#HashSet()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BandedFulfillmentPricingProvider#estimateCostForFulfillmentGroup(FulfillmentGroup, Set)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "org.broadleafcommerce.core.pricing.service.fulfillment.provider.FulfillmentEstimationResponse BandedFulfillmentPricingProvider.estimateCostForFulfillmentGroup(FulfillmentGroup, Set)"})
  public void testEstimateCostForFulfillmentGroup_whenHashSet() throws FulfillmentPriceException {
    // Arrange
    FulfillmentGroupImpl fulfillmentGroup = new FulfillmentGroupImpl();

    // Act and Assert
    assertTrue(bandedFulfillmentPricingProvider.estimateCostForFulfillmentGroup(fulfillmentGroup, new HashSet<>())
        .getFulfillmentOptionPrices()
        .isEmpty());
  }

  /**
   * Test {@link BandedFulfillmentPricingProvider#convertWeight(BigDecimal, WeightUnitOfMeasureType)}.
   * <ul>
   *   <li>Then return {@link BigDecimal#BigDecimal(String)} with {@code 1.043262451}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BandedFulfillmentPricingProvider#convertWeight(BigDecimal, WeightUnitOfMeasureType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"BigDecimal BandedFulfillmentPricingProvider.convertWeight(BigDecimal, WeightUnitOfMeasureType)"})
  public void testConvertWeight_thenReturnBigDecimalWith1043262451() {
    // Arrange
    BigDecimal weight = new BigDecimal("2.3");

    // Act
    BigDecimal actualConvertWeightResult = bandedFulfillmentPricingProvider.convertWeight(weight,
        new WeightUnitOfMeasureType("KILOGRAMS", "Friendly Type"));

    // Assert
    assertEquals(new BigDecimal("1.043262451"), actualConvertWeightResult);
  }

  /**
   * Test {@link BandedFulfillmentPricingProvider#convertWeight(BigDecimal, WeightUnitOfMeasureType)}.
   * <ul>
   *   <li>When {@link WeightUnitOfMeasureType#WeightUnitOfMeasureType(String, String)} with {@code Type} and {@code Friendly Type}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BandedFulfillmentPricingProvider#convertWeight(BigDecimal, WeightUnitOfMeasureType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"BigDecimal BandedFulfillmentPricingProvider.convertWeight(BigDecimal, WeightUnitOfMeasureType)"})
  public void testConvertWeight_whenWeightUnitOfMeasureTypeWithTypeAndFriendlyType() {
    // Arrange
    BigDecimal weight = new BigDecimal("2.3");

    // Act
    BigDecimal actualConvertWeightResult = bandedFulfillmentPricingProvider.convertWeight(weight,
        new WeightUnitOfMeasureType("Type", "Friendly Type"));

    // Assert
    assertEquals(new BigDecimal("2.3"), actualConvertWeightResult);
  }

  /**
   * Test {@link BandedFulfillmentPricingProvider#convertWeight(BigDecimal, WeightUnitOfMeasureType)}.
   * <ul>
   *   <li>When {@link WeightUnitOfMeasureType#WeightUnitOfMeasureType()}.</li>
   *   <li>Then return {@link BigDecimal#BigDecimal(String)} with {@code 2.3}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BandedFulfillmentPricingProvider#convertWeight(BigDecimal, WeightUnitOfMeasureType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"BigDecimal BandedFulfillmentPricingProvider.convertWeight(BigDecimal, WeightUnitOfMeasureType)"})
  public void testConvertWeight_whenWeightUnitOfMeasureType_thenReturnBigDecimalWith23() {
    // Arrange
    BigDecimal weight = new BigDecimal("2.3");

    // Act
    BigDecimal actualConvertWeightResult = bandedFulfillmentPricingProvider.convertWeight(weight,
        new WeightUnitOfMeasureType());

    // Assert
    assertEquals(new BigDecimal("2.3"), actualConvertWeightResult);
  }

  /**
   * Test {@link BandedFulfillmentPricingProvider#convertWeight(BigDecimal, WeightUnitOfMeasureType)}.
   * <ul>
   *   <li>When {@link WeightUnitOfMeasureType}.</li>
   *   <li>Then return {@link BigDecimal#BigDecimal(String)} with {@code 2.3}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BandedFulfillmentPricingProvider#convertWeight(BigDecimal, WeightUnitOfMeasureType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"BigDecimal BandedFulfillmentPricingProvider.convertWeight(BigDecimal, WeightUnitOfMeasureType)"})
  public void testConvertWeight_whenWeightUnitOfMeasureType_thenReturnBigDecimalWith232() {
    // Arrange and Act
    BigDecimal actualConvertWeightResult = bandedFulfillmentPricingProvider.convertWeight(new BigDecimal("2.3"),
        mock(WeightUnitOfMeasureType.class));

    // Assert
    assertEquals(new BigDecimal("2.3"), actualConvertWeightResult);
  }
}
