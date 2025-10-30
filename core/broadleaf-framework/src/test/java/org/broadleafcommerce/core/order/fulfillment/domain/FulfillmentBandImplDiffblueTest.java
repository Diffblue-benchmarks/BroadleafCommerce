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
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.math.BigDecimal;
import org.broadleafcommerce.core.order.service.type.FulfillmentBandResultAmountType;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class FulfillmentBandImplDiffblueTest {
  /**
   * Test {@link FulfillmentBandImpl#getResultAmount()}.
   * <p>
   * Method under test: {@link FulfillmentBandImpl#getResultAmount()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"BigDecimal FulfillmentBandImpl.getResultAmount()"})
  public void testGetResultAmount() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange, Act and Assert
    assertNull((new FulfillmentPriceBandImpl()).getResultAmount());
  }

  /**
   * Test {@link FulfillmentBandImpl#setResultAmount(BigDecimal)}.
   * <p>
   * Method under test: {@link FulfillmentBandImpl#setResultAmount(BigDecimal)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FulfillmentBandImpl.setResultAmount(BigDecimal)"})
  public void testSetResultAmount() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    FulfillmentPriceBandImpl fulfillmentPriceBandImpl = new FulfillmentPriceBandImpl();
    BigDecimal resultAmount = new BigDecimal("2.3");

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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FulfillmentBandResultAmountType FulfillmentBandImpl.getResultAmountType()"})
  public void testGetResultAmountType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange and Act
    FulfillmentBandResultAmountType actualResultAmountType = (new FulfillmentPriceBandImpl()).getResultAmountType();

    // Assert
    assertSame(actualResultAmountType.RATE, actualResultAmountType);
  }

  /**
   * Test {@link FulfillmentBandImpl#setResultAmountType(FulfillmentBandResultAmountType)}.
   * <ul>
   *   <li>Then {@link FulfillmentPriceBandImpl} (default constructor) {@link FulfillmentBandImpl#resultAmountType} is {@code PERCENTAGE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentBandImpl#setResultAmountType(FulfillmentBandResultAmountType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FulfillmentBandImpl.setResultAmountType(FulfillmentBandResultAmountType)"})
  public void testSetResultAmountType_thenFulfillmentPriceBandImplResultAmountTypeIsPercentage() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

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
