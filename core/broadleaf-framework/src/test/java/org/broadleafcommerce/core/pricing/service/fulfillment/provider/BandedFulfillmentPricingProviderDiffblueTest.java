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
import org.mockito.Mockito;

public class BandedFulfillmentPricingProviderDiffblueTest {
  /**
   * Method under test:
   * {@link BandedFulfillmentPricingProvider#canCalculateCostForFulfillmentGroup(FulfillmentGroup, FulfillmentOption)}
   */
  @Test
  public void testCanCalculateCostForFulfillmentGroup() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BandedFulfillmentPricingProvider bandedFulfillmentPricingProvider = new BandedFulfillmentPricingProvider();
    FulfillmentGroupImpl fulfillmentGroup = new FulfillmentGroupImpl();

    // Act and Assert
    assertFalse(bandedFulfillmentPricingProvider.canCalculateCostForFulfillmentGroup(fulfillmentGroup,
        new FulfillmentOptionImpl()));
  }

  /**
   * Method under test:
   * {@link BandedFulfillmentPricingProvider#canCalculateCostForFulfillmentGroup(FulfillmentGroup, FulfillmentOption)}
   */
  @Test
  public void testCanCalculateCostForFulfillmentGroup2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BandedFulfillmentPricingProvider bandedFulfillmentPricingProvider = new BandedFulfillmentPricingProvider();
    FulfillmentGroupImpl fulfillmentGroup = new FulfillmentGroupImpl();

    // Act and Assert
    assertTrue(bandedFulfillmentPricingProvider.canCalculateCostForFulfillmentGroup(fulfillmentGroup,
        new BandedPriceFulfillmentOptionImpl()));
  }

  /**
   * Method under test:
   * {@link BandedFulfillmentPricingProvider#canCalculateCostForFulfillmentGroup(FulfillmentGroup, FulfillmentOption)}
   */
  @Test
  public void testCanCalculateCostForFulfillmentGroup3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BandedFulfillmentPricingProvider bandedFulfillmentPricingProvider = new BandedFulfillmentPricingProvider();
    FulfillmentGroupImpl fulfillmentGroup = new FulfillmentGroupImpl();

    // Act and Assert
    assertTrue(bandedFulfillmentPricingProvider.canCalculateCostForFulfillmentGroup(fulfillmentGroup,
        new BandedWeightFulfillmentOptionImpl()));
  }

  /**
   * Method under test:
   * {@link BandedFulfillmentPricingProvider#canCalculateCostForFulfillmentGroup(FulfillmentGroup, FulfillmentOption)}
   */
  @Test
  public void testCanCalculateCostForFulfillmentGroup4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BandedFulfillmentPricingProvider bandedFulfillmentPricingProvider = new BandedFulfillmentPricingProvider();
    FulfillmentGroup fulfillmentGroup = mock(FulfillmentGroup.class);

    // Act and Assert
    assertFalse(bandedFulfillmentPricingProvider.canCalculateCostForFulfillmentGroup(fulfillmentGroup,
        new FulfillmentOptionImpl()));
  }

  /**
   * Method under test:
   * {@link BandedFulfillmentPricingProvider#calculateCostForFulfillmentGroup(FulfillmentGroup)}
   */
  @Test
  public void testCalculateCostForFulfillmentGroup() throws FulfillmentPriceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BandedFulfillmentPricingProvider bandedFulfillmentPricingProvider = new BandedFulfillmentPricingProvider();
    FulfillmentGroupImpl fulfillmentGroup = new FulfillmentGroupImpl();

    // Act and Assert
    assertSame(fulfillmentGroup, bandedFulfillmentPricingProvider.calculateCostForFulfillmentGroup(fulfillmentGroup));
  }

  /**
   * Method under test:
   * {@link BandedFulfillmentPricingProvider#calculateCostForFulfillmentGroup(FulfillmentGroup)}
   */
  @Test
  public void testCalculateCostForFulfillmentGroup2() throws FulfillmentPriceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BandedFulfillmentPricingProvider bandedFulfillmentPricingProvider = new BandedFulfillmentPricingProvider();
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
   * Method under test:
   * {@link BandedFulfillmentPricingProvider#calculateCostForFulfillmentGroup(FulfillmentGroup)}
   */
  @Test
  public void testCalculateCostForFulfillmentGroup3() throws FulfillmentPriceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BandedFulfillmentPricingProvider bandedFulfillmentPricingProvider = new BandedFulfillmentPricingProvider();

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
   * Method under test:
   * {@link BandedFulfillmentPricingProvider#calculateCostForFulfillmentGroup(FulfillmentGroup)}
   */
  @Test
  public void testCalculateCostForFulfillmentGroup4() throws FulfillmentPriceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BandedFulfillmentPricingProvider bandedFulfillmentPricingProvider = new BandedFulfillmentPricingProvider();

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
   * Method under test:
   * {@link BandedFulfillmentPricingProvider#calculateCostForFulfillmentGroup(FulfillmentGroup)}
   */
  @Test
  public void testCalculateCostForFulfillmentGroup5() throws FulfillmentPriceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BandedFulfillmentPricingProvider bandedFulfillmentPricingProvider = new BandedFulfillmentPricingProvider();

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
   * Method under test:
   * {@link BandedFulfillmentPricingProvider#calculateCostForFulfillmentGroup(FulfillmentGroup)}
   */
  @Test
  public void testCalculateCostForFulfillmentGroup6() throws FulfillmentPriceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BandedFulfillmentPricingProvider bandedFulfillmentPricingProvider = new BandedFulfillmentPricingProvider();

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
   * Method under test:
   * {@link BandedFulfillmentPricingProvider#calculateCostForFulfillmentGroup(FulfillmentGroup)}
   */
  @Test
  public void testCalculateCostForFulfillmentGroup7() throws FulfillmentPriceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BandedFulfillmentPricingProvider bandedFulfillmentPricingProvider = new BandedFulfillmentPricingProvider();

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
   * Method under test:
   * {@link BandedFulfillmentPricingProvider#estimateCostForFulfillmentGroup(FulfillmentGroup, Set)}
   */
  @Test
  public void testEstimateCostForFulfillmentGroup() throws FulfillmentPriceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BandedFulfillmentPricingProvider bandedFulfillmentPricingProvider = new BandedFulfillmentPricingProvider();
    FulfillmentGroupImpl fulfillmentGroup = new FulfillmentGroupImpl();

    // Act and Assert
    assertTrue(bandedFulfillmentPricingProvider.estimateCostForFulfillmentGroup(fulfillmentGroup, new HashSet<>())
        .getFulfillmentOptionPrices()
        .isEmpty());
  }

  /**
   * Method under test:
   * {@link BandedFulfillmentPricingProvider#estimateCostForFulfillmentGroup(FulfillmentGroup, Set)}
   */
  @Test
  public void testEstimateCostForFulfillmentGroup2() throws FulfillmentPriceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BandedFulfillmentPricingProvider bandedFulfillmentPricingProvider = new BandedFulfillmentPricingProvider();
    FulfillmentGroupImpl fulfillmentGroup = mock(FulfillmentGroupImpl.class);

    // Act and Assert
    assertTrue(bandedFulfillmentPricingProvider.estimateCostForFulfillmentGroup(fulfillmentGroup, new HashSet<>())
        .getFulfillmentOptionPrices()
        .isEmpty());
  }

  /**
   * Method under test:
   * {@link BandedFulfillmentPricingProvider#estimateCostForFulfillmentGroup(FulfillmentGroup, Set)}
   */
  @Test
  public void testEstimateCostForFulfillmentGroup3() throws FulfillmentPriceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BandedFulfillmentPricingProvider bandedFulfillmentPricingProvider = new BandedFulfillmentPricingProvider();
    FulfillmentGroupImpl fulfillmentGroup = new FulfillmentGroupImpl();

    HashSet<FulfillmentOption> options = new HashSet<>();
    options.add(new FulfillmentOptionImpl());

    // Act and Assert
    assertTrue(bandedFulfillmentPricingProvider.estimateCostForFulfillmentGroup(fulfillmentGroup, options)
        .getFulfillmentOptionPrices()
        .isEmpty());
  }

  /**
   * Method under test:
   * {@link BandedFulfillmentPricingProvider#estimateCostForFulfillmentGroup(FulfillmentGroup, Set)}
   */
  @Test
  public void testEstimateCostForFulfillmentGroup4() throws FulfillmentPriceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BandedFulfillmentPricingProvider bandedFulfillmentPricingProvider = new BandedFulfillmentPricingProvider();
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
   * Method under test:
   * {@link BandedFulfillmentPricingProvider#estimateCostForFulfillmentGroup(FulfillmentGroup, Set)}
   */
  @Test
  public void testEstimateCostForFulfillmentGroup5() throws FulfillmentPriceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BandedFulfillmentPricingProvider bandedFulfillmentPricingProvider = new BandedFulfillmentPricingProvider();
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
   * Method under test:
   * {@link BandedFulfillmentPricingProvider#estimateCostForFulfillmentGroup(FulfillmentGroup, Set)}
   */
  @Test
  public void testEstimateCostForFulfillmentGroup6() throws FulfillmentPriceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BandedFulfillmentPricingProvider bandedFulfillmentPricingProvider = new BandedFulfillmentPricingProvider();
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
   * Method under test:
   * {@link BandedFulfillmentPricingProvider#estimateCostForFulfillmentGroup(FulfillmentGroup, Set)}
   */
  @Test
  public void testEstimateCostForFulfillmentGroup7() throws FulfillmentPriceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BandedFulfillmentPricingProvider bandedFulfillmentPricingProvider = new BandedFulfillmentPricingProvider();
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
   * Method under test:
   * {@link BandedFulfillmentPricingProvider#convertWeight(BigDecimal, WeightUnitOfMeasureType)}
   */
  @Test
  public void testConvertWeight() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BandedFulfillmentPricingProvider bandedFulfillmentPricingProvider = new BandedFulfillmentPricingProvider();
    BigDecimal weight = new BigDecimal("2.3");

    // Act
    BigDecimal actualConvertWeightResult = bandedFulfillmentPricingProvider.convertWeight(weight,
        new WeightUnitOfMeasureType("Type", "Friendly Type"));

    // Assert
    assertEquals(new BigDecimal("2.3"), actualConvertWeightResult);
    assertSame(weight, actualConvertWeightResult);
  }

  /**
   * Method under test:
   * {@link BandedFulfillmentPricingProvider#convertWeight(BigDecimal, WeightUnitOfMeasureType)}
   */
  @Test
  public void testConvertWeight2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BandedFulfillmentPricingProvider bandedFulfillmentPricingProvider = new BandedFulfillmentPricingProvider();
    BigDecimal weight = new BigDecimal("2.3");

    // Act
    BigDecimal actualConvertWeightResult = bandedFulfillmentPricingProvider.convertWeight(weight,
        new WeightUnitOfMeasureType("KILOGRAMS", "Friendly Type"));

    // Assert
    assertEquals(new BigDecimal("1.043262451"), actualConvertWeightResult);
  }

  /**
   * Method under test:
   * {@link BandedFulfillmentPricingProvider#convertWeight(BigDecimal, WeightUnitOfMeasureType)}
   */
  @Test
  public void testConvertWeight3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BandedFulfillmentPricingProvider bandedFulfillmentPricingProvider = new BandedFulfillmentPricingProvider();
    BigDecimal weight = new BigDecimal("2.3");

    // Act
    BigDecimal actualConvertWeightResult = bandedFulfillmentPricingProvider.convertWeight(weight,
        new WeightUnitOfMeasureType());

    // Assert
    assertEquals(new BigDecimal("2.3"), actualConvertWeightResult);
    assertSame(weight, actualConvertWeightResult);
  }

  /**
   * Method under test:
   * {@link BandedFulfillmentPricingProvider#convertWeight(BigDecimal, WeightUnitOfMeasureType)}
   */
  @Test
  public void testConvertWeight4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BandedFulfillmentPricingProvider bandedFulfillmentPricingProvider = new BandedFulfillmentPricingProvider();
    BigDecimal weight = new BigDecimal("2.3");

    // Act
    BigDecimal actualConvertWeightResult = bandedFulfillmentPricingProvider.convertWeight(weight,
        mock(WeightUnitOfMeasureType.class));

    // Assert
    assertEquals(new BigDecimal("2.3"), actualConvertWeightResult);
    assertSame(weight, actualConvertWeightResult);
  }
}
