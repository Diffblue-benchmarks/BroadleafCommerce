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
package org.broadleafcommerce.core.pricing.service.module;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.math.BigDecimal;
import java.util.Currency;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import org.apache.commons.lang.NotImplementedException;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.core.order.domain.FulfillmentGroup;
import org.broadleafcommerce.core.order.domain.FulfillmentGroupImpl;
import org.broadleafcommerce.core.order.domain.FulfillmentGroupItemImpl;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.profile.core.domain.AddressImpl;
import org.broadleafcommerce.profile.core.domain.State;
import org.junit.Test;

public class BandedShippingModuleDiffblueTest {
  /**
   * Test
   * {@link BandedShippingModule#calculateShippingForFulfillmentGroup(FulfillmentGroup)}.
   * <p>
   * Method under test:
   * {@link BandedShippingModule#calculateShippingForFulfillmentGroup(FulfillmentGroup)}
   */
  @Test
  public void testCalculateShippingForFulfillmentGroup() {
    // Arrange
    BandedShippingModule bandedShippingModule = new BandedShippingModule();
    bandedShippingModule.setDefaultModule(true);

    FulfillmentGroupImpl fulfillmentGroup = new FulfillmentGroupImpl();
    NullOrderImpl order = new NullOrderImpl();
    fulfillmentGroup.setOrder(order);

    // Act
    FulfillmentGroup actualCalculateShippingForFulfillmentGroupResult = bandedShippingModule
        .calculateShippingForFulfillmentGroup(fulfillmentGroup);

    // Assert
    assertTrue(actualCalculateShippingForFulfillmentGroupResult instanceof FulfillmentGroupImpl);
    Money fulfillmentGroupAdjustmentsValue = actualCalculateShippingForFulfillmentGroupResult
        .getFulfillmentGroupAdjustmentsValue();
    Currency currency = fulfillmentGroupAdjustmentsValue.getCurrency();
    assertEquals("British Pound", currency.getDisplayName());
    assertEquals("GBP", currency.getCurrencyCode());
    assertEquals("GBP", currency.toString());
    assertEquals("£", currency.getSymbol());
    assertNull(((FulfillmentGroupImpl) actualCalculateShippingForFulfillmentGroupResult).getCurrencyCode());
    assertEquals(2, currency.getDefaultFractionDigits());
    assertEquals(826, currency.getNumericCode());
    BigDecimal expectedAmount = new BigDecimal("0.00");
    assertEquals(expectedAmount, fulfillmentGroupAdjustmentsValue.getAmount());
    assertEquals(fulfillmentGroupAdjustmentsValue, fulfillmentGroupAdjustmentsValue.abs());
    assertEquals(fulfillmentGroupAdjustmentsValue, fulfillmentGroupAdjustmentsValue.zero());
    assertEquals(fulfillmentGroupAdjustmentsValue,
        actualCalculateShippingForFulfillmentGroupResult.getFulfillmentPrice());
    assertEquals(fulfillmentGroupAdjustmentsValue,
        actualCalculateShippingForFulfillmentGroupResult.getFutureCreditFulfillmentGroupAdjustmentsValue());
    assertEquals(fulfillmentGroupAdjustmentsValue,
        actualCalculateShippingForFulfillmentGroupResult.getRetailFulfillmentPrice());
    assertEquals(fulfillmentGroupAdjustmentsValue,
        actualCalculateShippingForFulfillmentGroupResult.getRetailShippingPrice());
    assertEquals(fulfillmentGroupAdjustmentsValue,
        actualCalculateShippingForFulfillmentGroupResult.getSaleFulfillmentPrice());
    assertEquals(fulfillmentGroupAdjustmentsValue,
        actualCalculateShippingForFulfillmentGroupResult.getSaleShippingPrice());
    assertEquals(fulfillmentGroupAdjustmentsValue, actualCalculateShippingForFulfillmentGroupResult.getShippingPrice());
    assertSame(order, actualCalculateShippingForFulfillmentGroupResult.getOrder());
  }

  /**
   * Test
   * {@link BandedShippingModule#calculateShippingForFulfillmentGroup(FulfillmentGroup)}.
   * <ul>
   *   <li>Then return FulfillmentPrice is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BandedShippingModule#calculateShippingForFulfillmentGroup(FulfillmentGroup)}
   */
  @Test
  public void testCalculateShippingForFulfillmentGroup_thenReturnFulfillmentPriceIsNull() {
    // Arrange
    BandedShippingModule bandedShippingModule = new BandedShippingModule();

    // Act
    FulfillmentGroup actualCalculateShippingForFulfillmentGroupResult = bandedShippingModule
        .calculateShippingForFulfillmentGroup(new FulfillmentGroupImpl());

    // Assert
    assertTrue(actualCalculateShippingForFulfillmentGroupResult instanceof FulfillmentGroupImpl);
    assertNull(actualCalculateShippingForFulfillmentGroupResult.getFulfillmentPrice());
    assertNull(actualCalculateShippingForFulfillmentGroupResult.getRetailFulfillmentPrice());
    assertNull(actualCalculateShippingForFulfillmentGroupResult.getRetailShippingPrice());
    assertNull(actualCalculateShippingForFulfillmentGroupResult.getSaleFulfillmentPrice());
    assertNull(actualCalculateShippingForFulfillmentGroupResult.getSaleShippingPrice());
    assertNull(actualCalculateShippingForFulfillmentGroupResult.getShippingPrice());
    assertNull(actualCalculateShippingForFulfillmentGroupResult.getOrder());
  }

  /**
   * Test
   * {@link BandedShippingModule#calculateShippingForFulfillmentGroup(FulfillmentGroup)}.
   * <ul>
   *   <li>Then throw {@link NotImplementedException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BandedShippingModule#calculateShippingForFulfillmentGroup(FulfillmentGroup)}
   */
  @Test
  public void testCalculateShippingForFulfillmentGroup_thenThrowNotImplementedException() {
    // Arrange
    BandedShippingModule bandedShippingModule = new BandedShippingModule();
    bandedShippingModule.setDefaultModule(true);
    State state = mock(State.class);
    when(state.getAbbreviation()).thenThrow(new NotImplementedException());

    AddressImpl address = new AddressImpl();
    address.setState(state);

    FulfillmentGroupImpl fulfillmentGroup = new FulfillmentGroupImpl();
    fulfillmentGroup.setAddress(address);
    fulfillmentGroup.addFulfillmentGroupItem(new FulfillmentGroupItemImpl());

    // Act and Assert
    assertThrows(NotImplementedException.class,
        () -> bandedShippingModule.calculateShippingForFulfillmentGroup(fulfillmentGroup));
    verify(state).getAbbreviation();
  }

  /**
   * Test {@link BandedShippingModule#getServiceName()}.
   * <ul>
   *   <li>Given {@link BandedShippingModule} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link BandedShippingModule#getServiceName()}
   */
  @Test
  public void testGetServiceName_givenBandedShippingModule() {
    // Arrange, Act and Assert
    assertEquals("BANDED_SHIPPING", (new BandedShippingModule()).getServiceName());
  }

  /**
   * Test {@link BandedShippingModule#getServiceName()}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} computeIfPresent {@code foo} and
   * {@link BiFunction}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BandedShippingModule#getServiceName()}
   */
  @Test
  public void testGetServiceName_givenHashMapComputeIfPresentFooAndBiFunction() {
    // Arrange
    HashMap<String, String> feeTypeMapping = new HashMap<>();
    feeTypeMapping.computeIfPresent("foo", mock(BiFunction.class));

    BandedShippingModule bandedShippingModule = new BandedShippingModule();
    bandedShippingModule.setFeeTypeMapping(feeTypeMapping);

    // Act and Assert
    assertEquals("BANDED_SHIPPING", bandedShippingModule.getServiceName());
  }

  /**
   * Test {@link BandedShippingModule#isValidModuleForService(String)}.
   * <ul>
   *   <li>Given {@link BandedShippingModule} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BandedShippingModule#isValidModuleForService(String)}
   */
  @Test
  public void testIsValidModuleForService_givenBandedShippingModule_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new BandedShippingModule()).isValidModuleForService("Service Name"));
  }

  /**
   * Test {@link BandedShippingModule#isValidModuleForService(String)}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} computeIfPresent {@code foo} and
   * {@link BiFunction}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BandedShippingModule#isValidModuleForService(String)}
   */
  @Test
  public void testIsValidModuleForService_givenHashMapComputeIfPresentFooAndBiFunction() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    HashMap<String, String> feeTypeMapping = new HashMap<>();
    feeTypeMapping.computeIfPresent("foo", mock(BiFunction.class));

    BandedShippingModule bandedShippingModule = new BandedShippingModule();
    bandedShippingModule.setFeeTypeMapping(feeTypeMapping);

    // Act and Assert
    assertFalse(bandedShippingModule.isValidModuleForService("Service Name"));
  }

  /**
   * Test {@link BandedShippingModule#isValidModuleForService(String)}.
   * <ul>
   *   <li>When {@code BANDED_SHIPPING}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BandedShippingModule#isValidModuleForService(String)}
   */
  @Test
  public void testIsValidModuleForService_whenBandedShipping_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new BandedShippingModule()).isValidModuleForService("BANDED_SHIPPING"));
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link BandedShippingModule}
   *   <li>{@link BandedShippingModule#setDefaultModule(Boolean)}
   *   <li>{@link BandedShippingModule#setFeeSubTypeMapping(Map)}
   *   <li>{@link BandedShippingModule#setFeeTypeMapping(Map)}
   *   <li>{@link BandedShippingModule#setName(String)}
   *   <li>{@link BandedShippingModule#getFeeSubTypeMapping()}
   *   <li>{@link BandedShippingModule#getFeeTypeMapping()}
   *   <li>{@link BandedShippingModule#getName()}
   *   <li>{@link BandedShippingModule#isDefaultModule()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    BandedShippingModule actualBandedShippingModule = new BandedShippingModule();
    actualBandedShippingModule.setDefaultModule(true);
    HashMap<String, String> feeSubTypeMapping = new HashMap<>();
    actualBandedShippingModule.setFeeSubTypeMapping(feeSubTypeMapping);
    HashMap<String, String> feeTypeMapping = new HashMap<>();
    actualBandedShippingModule.setFeeTypeMapping(feeTypeMapping);
    actualBandedShippingModule.setName("Name");
    Map<String, String> actualFeeSubTypeMapping = actualBandedShippingModule.getFeeSubTypeMapping();
    Map<String, String> actualFeeTypeMapping = actualBandedShippingModule.getFeeTypeMapping();
    String actualName = actualBandedShippingModule.getName();
    Boolean actualIsDefaultModuleResult = actualBandedShippingModule.isDefaultModule();

    // Assert that nothing has changed
    assertEquals("Name", actualName);
    assertTrue(actualFeeSubTypeMapping.isEmpty());
    assertTrue(actualFeeTypeMapping.isEmpty());
    assertTrue(actualIsDefaultModuleResult);
    assertSame(feeSubTypeMapping, actualFeeSubTypeMapping);
    assertSame(feeTypeMapping, actualFeeTypeMapping);
  }
}
