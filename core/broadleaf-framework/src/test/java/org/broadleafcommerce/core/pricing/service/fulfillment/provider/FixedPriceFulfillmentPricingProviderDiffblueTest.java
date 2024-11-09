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
package org.broadleafcommerce.core.pricing.service.fulfillment.provider;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.common.vendor.service.exception.FulfillmentPriceException;
import org.broadleafcommerce.core.order.domain.FulfillmentGroup;
import org.broadleafcommerce.core.order.domain.FulfillmentGroupImpl;
import org.broadleafcommerce.core.order.domain.FulfillmentOption;
import org.broadleafcommerce.core.order.domain.FulfillmentOptionImpl;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.PersonalMessageImpl;
import org.broadleafcommerce.core.order.fulfillment.domain.FixedPriceFulfillmentOptionImpl;
import org.broadleafcommerce.core.order.service.type.FulfillmentGroupStatusType;
import org.broadleafcommerce.core.order.service.type.FulfillmentType;
import org.broadleafcommerce.profile.core.domain.AddressImpl;
import org.broadleafcommerce.profile.core.domain.PhoneImpl;
import org.junit.Test;
import org.mockito.Mockito;

public class FixedPriceFulfillmentPricingProviderDiffblueTest {
  /**
   * Test
   * {@link FixedPriceFulfillmentPricingProvider#canCalculateCostForFulfillmentGroup(FulfillmentGroup, FulfillmentOption)}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FixedPriceFulfillmentPricingProvider#canCalculateCostForFulfillmentGroup(FulfillmentGroup, FulfillmentOption)}
   */
  @Test
  public void testCanCalculateCostForFulfillmentGroup_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FixedPriceFulfillmentPricingProvider fixedPriceFulfillmentPricingProvider = new FixedPriceFulfillmentPricingProvider();
    FulfillmentGroupImpl fulfillmentGroup = new FulfillmentGroupImpl();

    // Act and Assert
    assertTrue(fixedPriceFulfillmentPricingProvider.canCalculateCostForFulfillmentGroup(fulfillmentGroup,
        new FixedPriceFulfillmentOptionImpl()));
  }

  /**
   * Test
   * {@link FixedPriceFulfillmentPricingProvider#canCalculateCostForFulfillmentGroup(FulfillmentGroup, FulfillmentOption)}.
   * <ul>
   *   <li>When {@link FulfillmentGroupImpl} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FixedPriceFulfillmentPricingProvider#canCalculateCostForFulfillmentGroup(FulfillmentGroup, FulfillmentOption)}
   */
  @Test
  public void testCanCalculateCostForFulfillmentGroup_whenFulfillmentGroupImpl_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FixedPriceFulfillmentPricingProvider fixedPriceFulfillmentPricingProvider = new FixedPriceFulfillmentPricingProvider();
    FulfillmentGroupImpl fulfillmentGroup = new FulfillmentGroupImpl();

    // Act and Assert
    assertFalse(fixedPriceFulfillmentPricingProvider.canCalculateCostForFulfillmentGroup(fulfillmentGroup,
        new FulfillmentOptionImpl()));
  }

  /**
   * Test
   * {@link FixedPriceFulfillmentPricingProvider#canCalculateCostForFulfillmentGroup(FulfillmentGroup, FulfillmentOption)}.
   * <ul>
   *   <li>When {@link FulfillmentGroup}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FixedPriceFulfillmentPricingProvider#canCalculateCostForFulfillmentGroup(FulfillmentGroup, FulfillmentOption)}
   */
  @Test
  public void testCanCalculateCostForFulfillmentGroup_whenFulfillmentGroup_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FixedPriceFulfillmentPricingProvider fixedPriceFulfillmentPricingProvider = new FixedPriceFulfillmentPricingProvider();
    FulfillmentGroup fulfillmentGroup = mock(FulfillmentGroup.class);

    // Act and Assert
    assertFalse(fixedPriceFulfillmentPricingProvider.canCalculateCostForFulfillmentGroup(fulfillmentGroup,
        new FulfillmentOptionImpl()));
  }

  /**
   * Test
   * {@link FixedPriceFulfillmentPricingProvider#calculateCostForFulfillmentGroup(FulfillmentGroup)}.
   * <ul>
   *   <li>Given {@link FulfillmentOptionImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FixedPriceFulfillmentPricingProvider#calculateCostForFulfillmentGroup(FulfillmentGroup)}
   */
  @Test
  public void testCalculateCostForFulfillmentGroup_givenFulfillmentOptionImpl() throws FulfillmentPriceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FixedPriceFulfillmentPricingProvider fixedPriceFulfillmentPricingProvider = new FixedPriceFulfillmentPricingProvider();
    FulfillmentGroup fulfillmentGroup = mock(FulfillmentGroup.class);
    when(fulfillmentGroup.getFulfillmentOption()).thenReturn(new FulfillmentOptionImpl());

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> fixedPriceFulfillmentPricingProvider.calculateCostForFulfillmentGroup(fulfillmentGroup));
    verify(fulfillmentGroup, atLeast(1)).getFulfillmentOption();
  }

  /**
   * Test
   * {@link FixedPriceFulfillmentPricingProvider#calculateCostForFulfillmentGroup(FulfillmentGroup)}.
   * <ul>
   *   <li>Then calls {@link FulfillmentGroup#setRetailShippingPrice(Money)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FixedPriceFulfillmentPricingProvider#calculateCostForFulfillmentGroup(FulfillmentGroup)}
   */
  @Test
  public void testCalculateCostForFulfillmentGroup_thenCallsSetRetailShippingPrice() throws FulfillmentPriceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FixedPriceFulfillmentPricingProvider fixedPriceFulfillmentPricingProvider = new FixedPriceFulfillmentPricingProvider();
    FixedPriceFulfillmentOptionImpl fixedPriceFulfillmentOptionImpl = mock(FixedPriceFulfillmentOptionImpl.class);
    when(fixedPriceFulfillmentOptionImpl.getPrice()).thenReturn(new Money());
    FulfillmentGroup fulfillmentGroup = mock(FulfillmentGroup.class);
    doThrow(new IllegalArgumentException("foo")).when(fulfillmentGroup).setRetailShippingPrice(Mockito.<Money>any());
    when(fulfillmentGroup.getFulfillmentOption()).thenReturn(fixedPriceFulfillmentOptionImpl);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> fixedPriceFulfillmentPricingProvider.calculateCostForFulfillmentGroup(fulfillmentGroup));
    verify(fulfillmentGroup, atLeast(1)).getFulfillmentOption();
    verify(fulfillmentGroup).setRetailShippingPrice(isA(Money.class));
    verify(fixedPriceFulfillmentOptionImpl).getPrice();
  }

  /**
   * Test
   * {@link FixedPriceFulfillmentPricingProvider#calculateCostForFulfillmentGroup(FulfillmentGroup)}.
   * <ul>
   *   <li>Then return {@link FulfillmentGroupImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FixedPriceFulfillmentPricingProvider#calculateCostForFulfillmentGroup(FulfillmentGroup)}
   */
  @Test
  public void testCalculateCostForFulfillmentGroup_thenReturnFulfillmentGroupImpl() throws FulfillmentPriceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FixedPriceFulfillmentPricingProvider fixedPriceFulfillmentPricingProvider = new FixedPriceFulfillmentPricingProvider();

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
    fulfillmentGroup.setFulfillmentOption(new FixedPriceFulfillmentOptionImpl());

    // Act and Assert
    assertSame(fulfillmentGroup,
        fixedPriceFulfillmentPricingProvider.calculateCostForFulfillmentGroup(fulfillmentGroup));
  }

  /**
   * Test
   * {@link FixedPriceFulfillmentPricingProvider#estimateCostForFulfillmentGroup(FulfillmentGroup, Set)}.
   * <ul>
   *   <li>Given {@link FulfillmentOptionImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FixedPriceFulfillmentPricingProvider#estimateCostForFulfillmentGroup(FulfillmentGroup, Set)}
   */
  @Test
  public void testEstimateCostForFulfillmentGroup_givenFulfillmentOptionImpl() throws FulfillmentPriceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FixedPriceFulfillmentPricingProvider fixedPriceFulfillmentPricingProvider = new FixedPriceFulfillmentPricingProvider();
    FulfillmentGroupImpl fulfillmentGroup = new FulfillmentGroupImpl();

    LinkedHashSet<FulfillmentOption> options = new LinkedHashSet<>();
    options.add(new FulfillmentOptionImpl());

    // Act and Assert
    assertTrue(fixedPriceFulfillmentPricingProvider.estimateCostForFulfillmentGroup(fulfillmentGroup, options)
        .getFulfillmentOptionPrices()
        .isEmpty());
  }

  /**
   * Test
   * {@link FixedPriceFulfillmentPricingProvider#estimateCostForFulfillmentGroup(FulfillmentGroup, Set)}.
   * <ul>
   *   <li>Then return FulfillmentOptionPrices size is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FixedPriceFulfillmentPricingProvider#estimateCostForFulfillmentGroup(FulfillmentGroup, Set)}
   */
  @Test
  public void testEstimateCostForFulfillmentGroup_thenReturnFulfillmentOptionPricesSizeIsOne()
      throws FulfillmentPriceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FixedPriceFulfillmentPricingProvider fixedPriceFulfillmentPricingProvider = new FixedPriceFulfillmentPricingProvider();
    FulfillmentGroupImpl fulfillmentGroup = new FulfillmentGroupImpl();

    LinkedHashSet<FulfillmentOption> options = new LinkedHashSet<>();
    options.add(new FixedPriceFulfillmentOptionImpl());

    // Act and Assert
    assertEquals(1,
        fixedPriceFulfillmentPricingProvider.estimateCostForFulfillmentGroup(fulfillmentGroup, options)
            .getFulfillmentOptionPrices()
            .size());
  }

  /**
   * Test
   * {@link FixedPriceFulfillmentPricingProvider#estimateCostForFulfillmentGroup(FulfillmentGroup, Set)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FixedPriceFulfillmentPricingProvider#estimateCostForFulfillmentGroup(FulfillmentGroup, Set)}
   */
  @Test
  public void testEstimateCostForFulfillmentGroup_thenThrowIllegalArgumentException() throws FulfillmentPriceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FixedPriceFulfillmentPricingProvider fixedPriceFulfillmentPricingProvider = new FixedPriceFulfillmentPricingProvider();
    FulfillmentGroupImpl fulfillmentGroup = new FulfillmentGroupImpl();
    FixedPriceFulfillmentOptionImpl fixedPriceFulfillmentOptionImpl = mock(FixedPriceFulfillmentOptionImpl.class);
    when(fixedPriceFulfillmentOptionImpl.getPrice()).thenThrow(new IllegalArgumentException("foo"));

    LinkedHashSet<FulfillmentOption> options = new LinkedHashSet<>();
    options.add(fixedPriceFulfillmentOptionImpl);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> fixedPriceFulfillmentPricingProvider.estimateCostForFulfillmentGroup(fulfillmentGroup, options));
    verify(fixedPriceFulfillmentOptionImpl).getPrice();
  }

  /**
   * Test
   * {@link FixedPriceFulfillmentPricingProvider#estimateCostForFulfillmentGroup(FulfillmentGroup, Set)}.
   * <ul>
   *   <li>When {@link FulfillmentGroupImpl}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FixedPriceFulfillmentPricingProvider#estimateCostForFulfillmentGroup(FulfillmentGroup, Set)}
   */
  @Test
  public void testEstimateCostForFulfillmentGroup_whenFulfillmentGroupImpl() throws FulfillmentPriceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FixedPriceFulfillmentPricingProvider fixedPriceFulfillmentPricingProvider = new FixedPriceFulfillmentPricingProvider();
    FulfillmentGroupImpl fulfillmentGroup = mock(FulfillmentGroupImpl.class);

    // Act and Assert
    assertTrue(fixedPriceFulfillmentPricingProvider.estimateCostForFulfillmentGroup(fulfillmentGroup, new HashSet<>())
        .getFulfillmentOptionPrices()
        .isEmpty());
  }

  /**
   * Test
   * {@link FixedPriceFulfillmentPricingProvider#estimateCostForFulfillmentGroup(FulfillmentGroup, Set)}.
   * <ul>
   *   <li>When {@link HashSet#HashSet()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FixedPriceFulfillmentPricingProvider#estimateCostForFulfillmentGroup(FulfillmentGroup, Set)}
   */
  @Test
  public void testEstimateCostForFulfillmentGroup_whenHashSet() throws FulfillmentPriceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FixedPriceFulfillmentPricingProvider fixedPriceFulfillmentPricingProvider = new FixedPriceFulfillmentPricingProvider();
    FulfillmentGroupImpl fulfillmentGroup = new FulfillmentGroupImpl();

    // Act and Assert
    assertTrue(fixedPriceFulfillmentPricingProvider.estimateCostForFulfillmentGroup(fulfillmentGroup, new HashSet<>())
        .getFulfillmentOptionPrices()
        .isEmpty());
  }
}
