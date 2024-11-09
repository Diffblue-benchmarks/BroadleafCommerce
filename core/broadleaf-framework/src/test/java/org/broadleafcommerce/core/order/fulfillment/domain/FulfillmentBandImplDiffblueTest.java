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
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;
import java.math.BigDecimal;
import org.broadleafcommerce.core.order.service.type.FulfillmentBandResultAmountType;
import org.junit.Test;
import org.mvel2.util.InternalNumber;

public class FulfillmentBandImplDiffblueTest {
  /**
   * Test {@link FulfillmentBandImpl#getResultAmount()}.
   * <p>
   * Method under test: {@link FulfillmentBandImpl#getResultAmount()}
   */
  @Test
  public void testGetResultAmount() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentPriceBandImpl fulfillmentPriceBandImpl = new FulfillmentPriceBandImpl();
    fulfillmentPriceBandImpl.setRetailPriceMinimumAmount(mock(InternalNumber.class));

    // Act and Assert
    assertNull(fulfillmentPriceBandImpl.getResultAmount());
  }

  /**
   * Test {@link FulfillmentBandImpl#getResultAmount()}.
   * <ul>
   *   <li>Given {@link FulfillmentPriceBandImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentBandImpl#getResultAmount()}
   */
  @Test
  public void testGetResultAmount_givenFulfillmentPriceBandImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new FulfillmentPriceBandImpl()).getResultAmount());
  }

  /**
   * Test {@link FulfillmentBandImpl#setResultAmount(BigDecimal)}.
   * <ul>
   *   <li>Then {@link FulfillmentPriceBandImpl} (default constructor) ResultAmount
   * is {@link BigDecimal#BigDecimal(String)} with {@code 2.3}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentBandImpl#setResultAmount(BigDecimal)}
   */
  @Test
  public void testSetResultAmount_thenFulfillmentPriceBandImplResultAmountIsBigDecimalWith23() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentPriceBandImpl fulfillmentPriceBandImpl = new FulfillmentPriceBandImpl();
    BigDecimal resultAmount = new BigDecimal("2.3");

    // Act
    fulfillmentPriceBandImpl.setResultAmount(resultAmount);

    // Assert
    assertSame(resultAmount, fulfillmentPriceBandImpl.getResultAmount());
  }

  /**
   * Test {@link FulfillmentBandImpl#setResultAmount(BigDecimal)}.
   * <ul>
   *   <li>Then {@link FulfillmentPriceBandImpl} (default constructor) ResultAmount
   * is {@link InternalNumber}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentBandImpl#setResultAmount(BigDecimal)}
   */
  @Test
  public void testSetResultAmount_thenFulfillmentPriceBandImplResultAmountIsInternalNumber() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentPriceBandImpl fulfillmentPriceBandImpl = new FulfillmentPriceBandImpl();
    InternalNumber resultAmount = mock(InternalNumber.class);

    // Act
    fulfillmentPriceBandImpl.setResultAmount(resultAmount);

    // Assert
    assertSame(resultAmount, fulfillmentPriceBandImpl.getResultAmount());
  }

  /**
   * Test {@link FulfillmentBandImpl#getResultAmountType()}.
   * <p>
   * Method under test: {@link FulfillmentBandImpl#getResultAmountType()}
   */
  @Test
  public void testGetResultAmountType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentPriceBandImpl fulfillmentPriceBandImpl = new FulfillmentPriceBandImpl();
    fulfillmentPriceBandImpl.setRetailPriceMinimumAmount(mock(InternalNumber.class));

    // Act
    FulfillmentBandResultAmountType actualResultAmountType = fulfillmentPriceBandImpl.getResultAmountType();

    // Assert
    assertSame(actualResultAmountType.RATE, actualResultAmountType);
  }

  /**
   * Test {@link FulfillmentBandImpl#getResultAmountType()}.
   * <ul>
   *   <li>Given {@link FulfillmentPriceBandImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentBandImpl#getResultAmountType()}
   */
  @Test
  public void testGetResultAmountType_givenFulfillmentPriceBandImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    FulfillmentBandResultAmountType actualResultAmountType = (new FulfillmentPriceBandImpl()).getResultAmountType();

    // Assert
    assertSame(actualResultAmountType.RATE, actualResultAmountType);
  }

  /**
   * Test
   * {@link FulfillmentBandImpl#setResultAmountType(FulfillmentBandResultAmountType)}.
   * <ul>
   *   <li>Then {@link FulfillmentPriceBandImpl} (default constructor)
   * {@link FulfillmentBandImpl#resultAmountType} is {@code PERCENTAGE}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FulfillmentBandImpl#setResultAmountType(FulfillmentBandResultAmountType)}
   */
  @Test
  public void testSetResultAmountType_thenFulfillmentPriceBandImplResultAmountTypeIsPercentage() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentPriceBandImpl fulfillmentPriceBandImpl = new FulfillmentPriceBandImpl();
    FulfillmentBandResultAmountType resultAmountType = FulfillmentBandResultAmountType.PERCENTAGE;

    // Act
    fulfillmentPriceBandImpl.setResultAmountType(resultAmountType);

    // Assert
    assertEquals("PERCENTAGE", fulfillmentPriceBandImpl.resultAmountType);
    FulfillmentBandResultAmountType expectedResultAmountType = resultAmountType.PERCENTAGE;
    assertSame(expectedResultAmountType, fulfillmentPriceBandImpl.getResultAmountType());
  }
}
