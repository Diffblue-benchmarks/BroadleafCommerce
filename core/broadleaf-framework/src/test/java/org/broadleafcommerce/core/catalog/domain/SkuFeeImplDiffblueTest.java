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
package org.broadleafcommerce.core.catalog.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.broadleafcommerce.common.currency.domain.BroadleafCurrency;
import org.broadleafcommerce.common.currency.domain.BroadleafCurrencyImpl;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.core.catalog.service.type.SkuFeeType;
import org.junit.Test;

public class SkuFeeImplDiffblueTest {
  /**
   * Test {@link SkuFeeImpl#getAmount()}.
   * <ul>
   *   <li>Given {@link SkuFeeImpl} (default constructor) FeeType is
   * {@link SkuFeeType#FULFILLMENT}.</li>
   *   <li>Then return {@link Money#Money()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuFeeImpl#getAmount()}
   */
  @Test
  public void testGetAmount_givenSkuFeeImplFeeTypeIsFulfillment_thenReturnMoney() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuFeeImpl skuFeeImpl = new SkuFeeImpl();
    skuFeeImpl.setDescription("The characteristics of someone or something");
    skuFeeImpl.setExpression("Expression");
    skuFeeImpl.setFeeType(SkuFeeType.FULFILLMENT);
    skuFeeImpl.setId(1L);
    skuFeeImpl.setName("Name");
    skuFeeImpl.setSkus(new ArrayList<>());
    skuFeeImpl.setTaxable(true);
    Money amount = new Money();
    skuFeeImpl.setAmount(amount);
    skuFeeImpl.setCurrency(null);

    // Act and Assert
    assertEquals(amount, skuFeeImpl.getAmount());
  }

  /**
   * Test {@link SkuFeeImpl#getAmount()}.
   * <ul>
   *   <li>Given {@link SkuFeeImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuFeeImpl#getAmount()}
   */
  @Test
  public void testGetAmount_givenSkuFeeImpl_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new SkuFeeImpl()).getAmount());
  }

  /**
   * Test {@link SkuFeeImpl#getAmount()}.
   * <ul>
   *   <li>Given {@link SkuFeeType} {@link SkuFeeType#getType()} return
   * {@code Type}.</li>
   *   <li>Then calls {@link SkuFeeType#getType()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuFeeImpl#getAmount()}
   */
  @Test
  public void testGetAmount_givenSkuFeeTypeGetTypeReturnType_thenCallsGetType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuFeeType feeType = mock(SkuFeeType.class);
    when(feeType.getType()).thenReturn("Type");

    SkuFeeImpl skuFeeImpl = new SkuFeeImpl();
    skuFeeImpl.setDescription("The characteristics of someone or something");
    skuFeeImpl.setExpression("Expression");
    skuFeeImpl.setFeeType(feeType);
    skuFeeImpl.setId(1L);
    skuFeeImpl.setName("Name");
    skuFeeImpl.setSkus(new ArrayList<>());
    skuFeeImpl.setTaxable(true);
    Money amount = new Money();
    skuFeeImpl.setAmount(amount);
    skuFeeImpl.setCurrency(null);

    // Act
    Money actualAmount = skuFeeImpl.getAmount();

    // Assert
    verify(feeType).getType();
    assertEquals(amount, actualAmount);
  }

  /**
   * Test {@link SkuFeeImpl#getAmount()}.
   * <ul>
   *   <li>Then calls {@link BroadleafCurrency#getCurrencyCode()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuFeeImpl#getAmount()}
   */
  @Test
  public void testGetAmount_thenCallsGetCurrencyCode() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuFeeType feeType = mock(SkuFeeType.class);
    when(feeType.getType()).thenReturn("Type");
    BroadleafCurrency currency = mock(BroadleafCurrency.class);
    when(currency.getCurrencyCode()).thenReturn("GBP");

    SkuFeeImpl skuFeeImpl = new SkuFeeImpl();
    skuFeeImpl.setDescription("The characteristics of someone or something");
    skuFeeImpl.setExpression("Expression");
    skuFeeImpl.setFeeType(feeType);
    skuFeeImpl.setId(1L);
    skuFeeImpl.setName("Name");
    skuFeeImpl.setSkus(new ArrayList<>());
    skuFeeImpl.setTaxable(true);
    Money amount = new Money();
    skuFeeImpl.setAmount(amount);
    skuFeeImpl.setCurrency(currency);

    // Act
    Money actualAmount = skuFeeImpl.getAmount();

    // Assert
    verify(currency).getCurrencyCode();
    verify(feeType).getType();
    assertEquals(amount, actualAmount);
  }

  /**
   * Test {@link SkuFeeImpl#setAmount(Money)}.
   * <ul>
   *   <li>When {@link Money#Money()}.</li>
   *   <li>Then {@link SkuFeeImpl} (default constructor) {@link SkuFeeImpl#amount}
   * is {@link BigDecimal#BigDecimal(String)} with {@code 0.00}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuFeeImpl#setAmount(Money)}
   */
  @Test
  public void testSetAmount_whenMoney_thenSkuFeeImplAmountIsBigDecimalWith000() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuFeeImpl skuFeeImpl = new SkuFeeImpl();
    Money amount = new Money();

    // Act
    skuFeeImpl.setAmount(amount);

    // Assert
    assertEquals(new BigDecimal("0.00"), skuFeeImpl.amount);
    BigDecimal bigDecimal = skuFeeImpl.amount;
    Money absResult = amount.abs();
    assertSame(bigDecimal, absResult.getAmount());
    Money absResult2 = absResult.abs();
    assertSame(bigDecimal, absResult2.getAmount());
    Money absResult3 = absResult2.abs();
    assertSame(bigDecimal, absResult3.getAmount());
    Money absResult4 = absResult3.abs();
    assertSame(bigDecimal, absResult4.getAmount());
    Money absResult5 = absResult4.abs();
    assertSame(bigDecimal, absResult5.getAmount());
    Money absResult6 = absResult5.abs();
    assertSame(bigDecimal, absResult6.getAmount());
    assertSame(bigDecimal, absResult6.abs().getAmount());
    Money zeroResult = amount.zero();
    Money absResult7 = zeroResult.abs();
    Money absResult8 = absResult7.abs();
    Money absResult9 = absResult8.abs();
    Money absResult10 = absResult9.abs();
    Money absResult11 = absResult10.abs();
    assertSame(bigDecimal, absResult11.abs().getAmount());
    assertSame(bigDecimal, absResult11.getAmount());
    Money zeroResult2 = absResult.zero();
    Money absResult12 = zeroResult2.abs();
    Money absResult13 = absResult12.abs();
    Money absResult14 = absResult13.abs();
    Money absResult15 = absResult14.abs();
    assertSame(bigDecimal, absResult15.abs().getAmount());
    Money zeroResult3 = zeroResult.zero();
    Money absResult16 = zeroResult3.abs();
    Money absResult17 = absResult16.abs();
    Money absResult18 = absResult17.abs();
    Money absResult19 = absResult18.abs();
    assertSame(bigDecimal, absResult19.abs().getAmount());
    assertSame(bigDecimal, absResult10.getAmount());
    assertSame(bigDecimal, absResult15.getAmount());
    Money zeroResult4 = absResult2.zero();
    Money absResult20 = zeroResult4.abs();
    Money absResult21 = absResult20.abs();
    Money absResult22 = absResult21.abs();
    assertSame(bigDecimal, absResult22.abs().getAmount());
    Money zeroResult5 = absResult7.zero();
    Money absResult23 = zeroResult5.abs();
    Money absResult24 = absResult23.abs();
    Money absResult25 = absResult24.abs();
    assertSame(bigDecimal, absResult25.abs().getAmount());
    assertSame(bigDecimal, absResult19.getAmount());
    Money zeroResult6 = zeroResult2.zero();
    Money absResult26 = zeroResult6.abs();
    Money absResult27 = absResult26.abs();
    Money absResult28 = absResult27.abs();
    assertSame(bigDecimal, absResult28.abs().getAmount());
    Money zeroResult7 = zeroResult3.zero();
    Money absResult29 = zeroResult7.abs();
    Money absResult30 = absResult29.abs();
    Money absResult31 = absResult30.abs();
    assertSame(bigDecimal, absResult31.abs().getAmount());
    assertSame(bigDecimal, absResult9.getAmount());
    assertSame(bigDecimal, absResult14.getAmount());
    assertSame(bigDecimal, absResult22.getAmount());
    Money zeroResult8 = absResult3.zero();
    Money absResult32 = zeroResult8.abs();
    Money absResult33 = absResult32.abs();
    assertSame(bigDecimal, absResult33.abs().getAmount());
    Money zeroResult9 = absResult8.zero();
    Money absResult34 = zeroResult9.abs();
    Money absResult35 = absResult34.abs();
    assertSame(bigDecimal, absResult35.abs().getAmount());
    assertSame(bigDecimal, absResult25.getAmount());
    Money zeroResult10 = absResult12.zero();
    Money absResult36 = zeroResult10.abs();
    Money absResult37 = absResult36.abs();
    assertSame(bigDecimal, absResult37.abs().getAmount());
    Money zeroResult11 = absResult16.zero();
    Money absResult38 = zeroResult11.abs();
    Money absResult39 = absResult38.abs();
    assertSame(bigDecimal, absResult39.abs().getAmount());
    assertSame(bigDecimal, absResult18.getAmount());
    assertSame(bigDecimal, absResult28.getAmount());
    Money zeroResult12 = zeroResult4.zero();
    Money absResult40 = zeroResult12.abs();
    Money absResult41 = absResult40.abs();
    assertSame(bigDecimal, absResult41.abs().getAmount());
    Money zeroResult13 = zeroResult5.zero();
    Money absResult42 = zeroResult13.abs();
    Money absResult43 = absResult42.abs();
    assertSame(bigDecimal, absResult43.abs().getAmount());
    assertSame(bigDecimal, absResult31.getAmount());
    Money zeroResult14 = zeroResult6.zero();
    Money absResult44 = zeroResult14.abs();
    Money absResult45 = absResult44.abs();
    assertSame(bigDecimal, absResult45.abs().getAmount());
    Money zeroResult15 = zeroResult7.zero();
    Money absResult46 = zeroResult15.abs();
    Money absResult47 = absResult46.abs();
    assertSame(bigDecimal, absResult47.abs().getAmount());
    assertSame(bigDecimal, absResult8.getAmount());
    assertSame(bigDecimal, absResult13.getAmount());
    assertSame(bigDecimal, absResult21.getAmount());
    assertSame(bigDecimal, absResult33.getAmount());
    Money zeroResult16 = absResult4.zero();
    Money absResult48 = zeroResult16.abs();
    assertSame(bigDecimal, absResult48.abs().getAmount());
    Money zeroResult17 = absResult9.zero();
    Money absResult49 = zeroResult17.abs();
    assertSame(bigDecimal, absResult49.abs().getAmount());
    assertSame(bigDecimal, absResult35.getAmount());
    Money zeroResult18 = absResult13.zero();
    Money absResult50 = zeroResult18.abs();
    assertSame(bigDecimal, absResult50.abs().getAmount());
    Money zeroResult19 = absResult17.zero();
    Money absResult51 = zeroResult19.abs();
    assertSame(bigDecimal, absResult51.abs().getAmount());
    assertSame(bigDecimal, absResult24.getAmount());
    assertSame(bigDecimal, absResult37.getAmount());
    Money zeroResult20 = absResult20.zero();
    Money absResult52 = zeroResult20.abs();
    assertSame(bigDecimal, absResult52.abs().getAmount());
    Money zeroResult21 = absResult23.zero();
    Money absResult53 = zeroResult21.abs();
    assertSame(bigDecimal, absResult53.abs().getAmount());
    assertSame(bigDecimal, absResult39.getAmount());
    Money zeroResult22 = absResult26.zero();
    Money absResult54 = zeroResult22.abs();
    assertSame(bigDecimal, absResult54.abs().getAmount());
    Money zeroResult23 = absResult29.zero();
    Money absResult55 = zeroResult23.abs();
    assertSame(bigDecimal, absResult55.abs().getAmount());
    assertSame(bigDecimal, absResult17.getAmount());
    assertSame(bigDecimal, absResult27.getAmount());
    assertSame(bigDecimal, absResult41.getAmount());
    Money zeroResult24 = zeroResult8.zero();
    Money absResult56 = zeroResult24.abs();
    assertSame(bigDecimal, absResult56.abs().getAmount());
    Money zeroResult25 = zeroResult9.zero();
    Money absResult57 = zeroResult25.abs();
    assertSame(bigDecimal, absResult57.abs().getAmount());
    assertSame(bigDecimal, absResult43.getAmount());
    Money zeroResult26 = zeroResult10.zero();
    Money absResult58 = zeroResult26.abs();
    assertSame(bigDecimal, absResult58.abs().getAmount());
    Money zeroResult27 = zeroResult11.zero();
    Money absResult59 = zeroResult27.abs();
    assertSame(bigDecimal, absResult59.abs().getAmount());
    assertSame(bigDecimal, absResult30.getAmount());
    assertSame(bigDecimal, absResult45.getAmount());
    Money zeroResult28 = zeroResult12.zero();
    Money absResult60 = zeroResult28.abs();
    assertSame(bigDecimal, absResult60.abs().getAmount());
    Money zeroResult29 = zeroResult13.zero();
    Money absResult61 = zeroResult29.abs();
    assertSame(bigDecimal, absResult61.abs().getAmount());
    assertSame(bigDecimal, absResult47.getAmount());
    Money zeroResult30 = zeroResult14.zero();
    Money absResult62 = zeroResult30.abs();
    assertSame(bigDecimal, absResult62.abs().getAmount());
    assertSame(bigDecimal, absResult7.getAmount());
    assertSame(bigDecimal, absResult12.getAmount());
    assertSame(bigDecimal, absResult20.getAmount());
    assertSame(bigDecimal, absResult32.getAmount());
    assertSame(bigDecimal, absResult48.getAmount());
    Money zeroResult31 = absResult5.zero();
    assertSame(bigDecimal, zeroResult31.abs().getAmount());
    Money zeroResult32 = absResult10.zero();
    assertSame(bigDecimal, zeroResult32.abs().getAmount());
    assertSame(bigDecimal, absResult49.getAmount());
    Money zeroResult33 = absResult14.zero();
    assertSame(bigDecimal, zeroResult33.abs().getAmount());
    Money zeroResult34 = absResult18.zero();
    assertSame(bigDecimal, zeroResult34.abs().getAmount());
    assertSame(bigDecimal, absResult34.getAmount());
    assertSame(bigDecimal, absResult50.getAmount());
    Money zeroResult35 = absResult21.zero();
    assertSame(bigDecimal, zeroResult35.abs().getAmount());
    Money zeroResult36 = absResult24.zero();
    assertSame(bigDecimal, zeroResult36.abs().getAmount());
    assertSame(bigDecimal, absResult51.getAmount());
    Money zeroResult37 = absResult27.zero();
    assertSame(bigDecimal, zeroResult37.abs().getAmount());
    Money zeroResult38 = absResult30.zero();
    assertSame(bigDecimal, zeroResult38.abs().getAmount());
    assertSame(bigDecimal, absResult23.getAmount());
    assertSame(bigDecimal, absResult36.getAmount());
    assertSame(bigDecimal, absResult52.getAmount());
    Money zeroResult39 = absResult32.zero();
    assertSame(bigDecimal, zeroResult39.abs().getAmount());
    Money zeroResult40 = absResult34.zero();
    assertSame(bigDecimal, zeroResult40.abs().getAmount());
    assertSame(bigDecimal, absResult53.getAmount());
    Money zeroResult41 = absResult36.zero();
    assertSame(bigDecimal, zeroResult41.abs().getAmount());
    Money zeroResult42 = absResult38.zero();
    assertSame(bigDecimal, zeroResult42.abs().getAmount());
    assertSame(bigDecimal, absResult38.getAmount());
    assertSame(bigDecimal, absResult54.getAmount());
    Money zeroResult43 = absResult40.zero();
    assertSame(bigDecimal, zeroResult43.abs().getAmount());
    Money zeroResult44 = absResult42.zero();
    assertSame(bigDecimal, zeroResult44.abs().getAmount());
    assertSame(bigDecimal, absResult55.getAmount());
    Money zeroResult45 = absResult44.zero();
    assertSame(bigDecimal, zeroResult45.abs().getAmount());
    assertSame(bigDecimal, absResult16.getAmount());
    assertSame(bigDecimal, absResult26.getAmount());
    assertSame(bigDecimal, absResult40.getAmount());
    assertSame(bigDecimal, absResult56.getAmount());
    Money zeroResult46 = zeroResult16.zero();
    assertSame(bigDecimal, zeroResult46.abs().getAmount());
    Money zeroResult47 = zeroResult17.zero();
    assertSame(bigDecimal, zeroResult47.abs().getAmount());
    assertSame(bigDecimal, absResult57.getAmount());
    Money zeroResult48 = zeroResult18.zero();
    assertSame(bigDecimal, zeroResult48.abs().getAmount());
    Money zeroResult49 = zeroResult19.zero();
    assertSame(bigDecimal, zeroResult49.abs().getAmount());
    assertSame(bigDecimal, absResult42.getAmount());
    assertSame(bigDecimal, absResult58.getAmount());
    Money zeroResult50 = zeroResult20.zero();
    assertSame(bigDecimal, zeroResult50.abs().getAmount());
    Money zeroResult51 = zeroResult21.zero();
    assertSame(bigDecimal, zeroResult51.abs().getAmount());
    assertSame(bigDecimal, absResult59.getAmount());
    Money zeroResult52 = zeroResult22.zero();
    assertSame(bigDecimal, zeroResult52.abs().getAmount());
    Money zeroResult53 = zeroResult23.zero();
    assertSame(bigDecimal, zeroResult53.abs().getAmount());
    assertSame(bigDecimal, absResult29.getAmount());
    assertSame(bigDecimal, absResult44.getAmount());
    assertSame(bigDecimal, absResult60.getAmount());
    Money zeroResult54 = zeroResult24.zero();
    assertSame(bigDecimal, zeroResult54.abs().getAmount());
    Money zeroResult55 = zeroResult25.zero();
    assertSame(bigDecimal, zeroResult55.abs().getAmount());
    assertSame(bigDecimal, absResult61.getAmount());
    Money zeroResult56 = zeroResult26.zero();
    assertSame(bigDecimal, zeroResult56.abs().getAmount());
    Money zeroResult57 = zeroResult27.zero();
    assertSame(bigDecimal, zeroResult57.abs().getAmount());
    assertSame(bigDecimal, absResult46.getAmount());
    assertSame(bigDecimal, absResult62.getAmount());
    Money zeroResult58 = zeroResult28.zero();
    assertSame(bigDecimal, zeroResult58.abs().getAmount());
    Money zeroResult59 = zeroResult29.zero();
    assertSame(bigDecimal, zeroResult59.abs().getAmount());
    Money zeroResult60 = zeroResult15.zero();
    assertSame(bigDecimal, zeroResult60.abs().getAmount());
    Money zeroResult61 = zeroResult30.zero();
    assertSame(bigDecimal, zeroResult61.abs().getAmount());
    assertSame(bigDecimal, zeroResult.getAmount());
    assertSame(bigDecimal, zeroResult2.getAmount());
    assertSame(bigDecimal, zeroResult4.getAmount());
    assertSame(bigDecimal, zeroResult8.getAmount());
    assertSame(bigDecimal, zeroResult16.getAmount());
    assertSame(bigDecimal, zeroResult31.getAmount());
    assertSame(bigDecimal, absResult6.zero().getAmount());
    assertSame(bigDecimal, absResult11.zero().getAmount());
    assertSame(bigDecimal, zeroResult32.getAmount());
    assertSame(bigDecimal, absResult15.zero().getAmount());
    assertSame(bigDecimal, absResult19.zero().getAmount());
    assertSame(bigDecimal, zeroResult17.getAmount());
    assertSame(bigDecimal, zeroResult33.getAmount());
    assertSame(bigDecimal, absResult22.zero().getAmount());
    assertSame(bigDecimal, absResult25.zero().getAmount());
    assertSame(bigDecimal, zeroResult34.getAmount());
    assertSame(bigDecimal, absResult28.zero().getAmount());
    assertSame(bigDecimal, absResult31.zero().getAmount());
    assertSame(bigDecimal, zeroResult9.getAmount());
    assertSame(bigDecimal, zeroResult18.getAmount());
    assertSame(bigDecimal, zeroResult35.getAmount());
    assertSame(bigDecimal, absResult33.zero().getAmount());
    assertSame(bigDecimal, absResult35.zero().getAmount());
    assertSame(bigDecimal, zeroResult36.getAmount());
    assertSame(bigDecimal, absResult37.zero().getAmount());
    assertSame(bigDecimal, absResult39.zero().getAmount());
    assertSame(bigDecimal, zeroResult19.getAmount());
    assertSame(bigDecimal, zeroResult37.getAmount());
    assertSame(bigDecimal, absResult41.zero().getAmount());
    assertSame(bigDecimal, absResult43.zero().getAmount());
    assertSame(bigDecimal, zeroResult38.getAmount());
    assertSame(bigDecimal, absResult45.zero().getAmount());
    assertSame(bigDecimal, absResult47.zero().getAmount());
    assertSame(bigDecimal, zeroResult5.getAmount());
    assertSame(bigDecimal, zeroResult10.getAmount());
    assertSame(bigDecimal, zeroResult20.getAmount());
    assertSame(bigDecimal, zeroResult39.getAmount());
    assertSame(bigDecimal, absResult48.zero().getAmount());
    assertSame(bigDecimal, absResult49.zero().getAmount());
    assertSame(bigDecimal, zeroResult40.getAmount());
    assertSame(bigDecimal, absResult50.zero().getAmount());
    assertSame(bigDecimal, absResult51.zero().getAmount());
    assertSame(bigDecimal, zeroResult21.getAmount());
    assertSame(bigDecimal, zeroResult41.getAmount());
    assertSame(bigDecimal, absResult52.zero().getAmount());
    assertSame(bigDecimal, absResult53.zero().getAmount());
    assertSame(bigDecimal, zeroResult42.getAmount());
    assertSame(bigDecimal, absResult54.zero().getAmount());
    assertSame(bigDecimal, absResult55.zero().getAmount());
    assertSame(bigDecimal, zeroResult11.getAmount());
    assertSame(bigDecimal, zeroResult22.getAmount());
    assertSame(bigDecimal, zeroResult43.getAmount());
    assertSame(bigDecimal, absResult56.zero().getAmount());
    assertSame(bigDecimal, absResult57.zero().getAmount());
    assertSame(bigDecimal, zeroResult44.getAmount());
    assertSame(bigDecimal, absResult58.zero().getAmount());
    assertSame(bigDecimal, absResult59.zero().getAmount());
    assertSame(bigDecimal, zeroResult23.getAmount());
    assertSame(bigDecimal, zeroResult45.getAmount());
    assertSame(bigDecimal, absResult60.zero().getAmount());
    assertSame(bigDecimal, absResult61.zero().getAmount());
    assertSame(bigDecimal, absResult46.zero().getAmount());
    assertSame(bigDecimal, absResult62.zero().getAmount());
    assertSame(bigDecimal, zeroResult3.getAmount());
    assertSame(bigDecimal, zeroResult6.getAmount());
    assertSame(bigDecimal, zeroResult12.getAmount());
    assertSame(bigDecimal, zeroResult24.getAmount());
    assertSame(bigDecimal, zeroResult46.getAmount());
    assertSame(bigDecimal, zeroResult31.zero().getAmount());
    assertSame(bigDecimal, zeroResult32.zero().getAmount());
    assertSame(bigDecimal, zeroResult47.getAmount());
    assertSame(bigDecimal, zeroResult33.zero().getAmount());
    assertSame(bigDecimal, zeroResult34.zero().getAmount());
    assertSame(bigDecimal, zeroResult25.getAmount());
    assertSame(bigDecimal, zeroResult48.getAmount());
    assertSame(bigDecimal, zeroResult35.zero().getAmount());
    assertSame(bigDecimal, zeroResult36.zero().getAmount());
    assertSame(bigDecimal, zeroResult49.getAmount());
    assertSame(bigDecimal, zeroResult37.zero().getAmount());
    assertSame(bigDecimal, zeroResult38.zero().getAmount());
    assertSame(bigDecimal, zeroResult13.getAmount());
    assertSame(bigDecimal, zeroResult26.getAmount());
    assertSame(bigDecimal, zeroResult50.getAmount());
    assertSame(bigDecimal, zeroResult39.zero().getAmount());
    assertSame(bigDecimal, zeroResult40.zero().getAmount());
    assertSame(bigDecimal, zeroResult51.getAmount());
    assertSame(bigDecimal, zeroResult41.zero().getAmount());
    assertSame(bigDecimal, zeroResult42.zero().getAmount());
    assertSame(bigDecimal, zeroResult27.getAmount());
    assertSame(bigDecimal, zeroResult52.getAmount());
    assertSame(bigDecimal, zeroResult43.zero().getAmount());
    assertSame(bigDecimal, zeroResult44.zero().getAmount());
    assertSame(bigDecimal, zeroResult53.getAmount());
    assertSame(bigDecimal, zeroResult45.zero().getAmount());
    assertSame(bigDecimal, zeroResult7.getAmount());
    assertSame(bigDecimal, zeroResult14.getAmount());
    assertSame(bigDecimal, zeroResult28.getAmount());
    assertSame(bigDecimal, zeroResult54.getAmount());
    assertSame(bigDecimal, zeroResult46.zero().getAmount());
    assertSame(bigDecimal, zeroResult47.zero().getAmount());
    assertSame(bigDecimal, zeroResult55.getAmount());
    assertSame(bigDecimal, zeroResult48.zero().getAmount());
    assertSame(bigDecimal, zeroResult49.zero().getAmount());
    assertSame(bigDecimal, zeroResult29.getAmount());
    assertSame(bigDecimal, zeroResult56.getAmount());
    assertSame(bigDecimal, zeroResult50.zero().getAmount());
    assertSame(bigDecimal, zeroResult51.zero().getAmount());
    assertSame(bigDecimal, zeroResult57.getAmount());
    assertSame(bigDecimal, zeroResult52.zero().getAmount());
    assertSame(bigDecimal, zeroResult53.zero().getAmount());
    assertSame(bigDecimal, zeroResult15.getAmount());
    assertSame(bigDecimal, zeroResult30.getAmount());
    assertSame(bigDecimal, zeroResult58.getAmount());
    assertSame(bigDecimal, zeroResult54.zero().getAmount());
    assertSame(bigDecimal, zeroResult55.zero().getAmount());
    assertSame(bigDecimal, zeroResult59.getAmount());
    assertSame(bigDecimal, zeroResult56.zero().getAmount());
    assertSame(bigDecimal, zeroResult57.zero().getAmount());
    assertSame(bigDecimal, zeroResult60.getAmount());
    assertSame(bigDecimal, zeroResult61.getAmount());
    assertSame(bigDecimal, zeroResult58.zero().getAmount());
    assertSame(bigDecimal, zeroResult59.zero().getAmount());
    assertSame(bigDecimal, zeroResult60.zero().getAmount());
    assertSame(bigDecimal, zeroResult61.zero().getAmount());
  }

  /**
   * Test {@link SkuFeeImpl#setAmount(Money)}.
   * <ul>
   *   <li>When {@link Money}.</li>
   *   <li>Then {@link SkuFeeImpl} (default constructor) {@link SkuFeeImpl#amount}
   * is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuFeeImpl#setAmount(Money)}
   */
  @Test
  public void testSetAmount_whenMoney_thenSkuFeeImplAmountIsNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuFeeImpl skuFeeImpl = new SkuFeeImpl();

    // Act
    skuFeeImpl.setAmount(mock(Money.class));

    // Assert
    assertNull(skuFeeImpl.amount);
  }

  /**
   * Test {@link SkuFeeImpl#setAmount(Money)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link SkuFeeImpl} (default constructor) {@link SkuFeeImpl#amount}
   * is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuFeeImpl#setAmount(Money)}
   */
  @Test
  public void testSetAmount_whenNull_thenSkuFeeImplAmountIsNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuFeeImpl skuFeeImpl = new SkuFeeImpl();

    // Act
    skuFeeImpl.setAmount(null);

    // Assert
    assertNull(skuFeeImpl.amount);
  }

  /**
   * Test {@link SkuFeeImpl#getFeeType()}.
   * <ul>
   *   <li>Given {@link SkuFeeImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuFeeImpl#getFeeType()}
   */
  @Test
  public void testGetFeeType_givenSkuFeeImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    SkuFeeType actualFeeType = (new SkuFeeImpl()).getFeeType();

    // Assert
    assertSame(actualFeeType.FULFILLMENT, actualFeeType);
  }

  /**
   * Test {@link SkuFeeImpl#getFeeType()}.
   * <ul>
   *   <li>Given {@link SkuFeeImpl} (default constructor) Amount is
   * {@link Money}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuFeeImpl#getFeeType()}
   */
  @Test
  public void testGetFeeType_givenSkuFeeImplAmountIsMoney() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuFeeImpl skuFeeImpl = new SkuFeeImpl();
    skuFeeImpl.setAmount(mock(Money.class));

    // Act
    SkuFeeType actualFeeType = skuFeeImpl.getFeeType();

    // Assert
    assertSame(actualFeeType.FULFILLMENT, actualFeeType);
  }

  /**
   * Test {@link SkuFeeImpl#setFeeType(SkuFeeType)}.
   * <ul>
   *   <li>Given {@link SkuFeeImpl} (default constructor) Amount is
   * {@link Money#Money()}.</li>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link SkuFeeImpl} (default constructor) {@link SkuFeeImpl#feeType}
   * is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuFeeImpl#setFeeType(SkuFeeType)}
   */
  @Test
  public void testSetFeeType_givenSkuFeeImplAmountIsMoney_whenNull_thenSkuFeeImplFeeTypeIsNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuFeeImpl skuFeeImpl = new SkuFeeImpl();
    skuFeeImpl.setAmount(new Money());
    skuFeeImpl.setCurrency(new BroadleafCurrencyImpl());
    skuFeeImpl.setDescription("The characteristics of someone or something");
    skuFeeImpl.setExpression("Expression");
    skuFeeImpl.setFeeType(SkuFeeType.FULFILLMENT);
    skuFeeImpl.setId(1L);
    skuFeeImpl.setName("Name");
    skuFeeImpl.setSkus(new ArrayList<>());
    skuFeeImpl.setTaxable(true);

    // Act
    skuFeeImpl.setFeeType(null);

    // Assert
    assertNull(skuFeeImpl.feeType);
    assertNull(skuFeeImpl.getFeeType());
  }

  /**
   * Test {@link SkuFeeImpl#setFeeType(SkuFeeType)}.
   * <ul>
   *   <li>When {@link SkuFeeType#FULFILLMENT}.</li>
   *   <li>Then {@link SkuFeeImpl} (default constructor) {@link SkuFeeImpl#feeType}
   * is {@code FULFILLMENT}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuFeeImpl#setFeeType(SkuFeeType)}
   */
  @Test
  public void testSetFeeType_whenFulfillment_thenSkuFeeImplFeeTypeIsFulfillment() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuFeeImpl skuFeeImpl = new SkuFeeImpl();
    SkuFeeType feeType = SkuFeeType.FULFILLMENT;

    // Act
    skuFeeImpl.setFeeType(feeType);

    // Assert
    assertEquals("FULFILLMENT", skuFeeImpl.feeType);
    SkuFeeType expectedFeeType = feeType.FULFILLMENT;
    assertSame(expectedFeeType, skuFeeImpl.getFeeType());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link SkuFeeImpl#setCurrency(BroadleafCurrency)}
   *   <li>{@link SkuFeeImpl#setDescription(String)}
   *   <li>{@link SkuFeeImpl#setExpression(String)}
   *   <li>{@link SkuFeeImpl#setId(Long)}
   *   <li>{@link SkuFeeImpl#setName(String)}
   *   <li>{@link SkuFeeImpl#setSkus(List)}
   *   <li>{@link SkuFeeImpl#setTaxable(Boolean)}
   *   <li>{@link SkuFeeImpl#getCurrency()}
   *   <li>{@link SkuFeeImpl#getDescription()}
   *   <li>{@link SkuFeeImpl#getExpression()}
   *   <li>{@link SkuFeeImpl#getId()}
   *   <li>{@link SkuFeeImpl#getName()}
   *   <li>{@link SkuFeeImpl#getSkus()}
   *   <li>{@link SkuFeeImpl#getTaxable()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    SkuFeeImpl skuFeeImpl = new SkuFeeImpl();
    BroadleafCurrencyImpl currency = new BroadleafCurrencyImpl();

    // Act
    skuFeeImpl.setCurrency(currency);
    skuFeeImpl.setDescription("The characteristics of someone or something");
    skuFeeImpl.setExpression("Expression");
    skuFeeImpl.setId(1L);
    skuFeeImpl.setName("Name");
    ArrayList<Sku> skus = new ArrayList<>();
    skuFeeImpl.setSkus(skus);
    skuFeeImpl.setTaxable(true);
    BroadleafCurrency actualCurrency = skuFeeImpl.getCurrency();
    String actualDescription = skuFeeImpl.getDescription();
    String actualExpression = skuFeeImpl.getExpression();
    Long actualId = skuFeeImpl.getId();
    String actualName = skuFeeImpl.getName();
    List<Sku> actualSkus = skuFeeImpl.getSkus();
    Boolean actualTaxable = skuFeeImpl.getTaxable();

    // Assert that nothing has changed
    assertEquals("Expression", actualExpression);
    assertEquals("Name", actualName);
    assertEquals("The characteristics of someone or something", actualDescription);
    assertEquals(1L, actualId.longValue());
    assertTrue(actualSkus.isEmpty());
    assertTrue(actualTaxable);
    assertSame(skus, actualSkus);
    assertSame(currency, actualCurrency);
  }

  /**
   * Test {@link SkuFeeImpl#equals(Object)}, and {@link SkuFeeImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link SkuFeeImpl#equals(Object)}
   *   <li>{@link SkuFeeImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    SkuFeeImpl skuFeeImpl = new SkuFeeImpl();
    skuFeeImpl.setAmount(new Money());
    skuFeeImpl.setCurrency(new BroadleafCurrencyImpl());
    skuFeeImpl.setDescription("The characteristics of someone or something");
    skuFeeImpl.setExpression("Expression");
    skuFeeImpl.setFeeType(SkuFeeType.FULFILLMENT);
    skuFeeImpl.setId(1L);
    skuFeeImpl.setName("Name");
    skuFeeImpl.setSkus(new ArrayList<>());
    skuFeeImpl.setTaxable(true);

    SkuFeeImpl skuFeeImpl2 = new SkuFeeImpl();
    skuFeeImpl2.setAmount(new Money());
    skuFeeImpl2.setCurrency(new BroadleafCurrencyImpl());
    skuFeeImpl2.setDescription("The characteristics of someone or something");
    skuFeeImpl2.setExpression("Expression");
    skuFeeImpl2.setFeeType(SkuFeeType.FULFILLMENT);
    skuFeeImpl2.setId(1L);
    skuFeeImpl2.setName("Name");
    skuFeeImpl2.setSkus(new ArrayList<>());
    skuFeeImpl2.setTaxable(true);

    // Act and Assert
    assertEquals(skuFeeImpl, skuFeeImpl2);
    int expectedHashCodeResult = skuFeeImpl.hashCode();
    assertEquals(expectedHashCodeResult, skuFeeImpl2.hashCode());
  }

  /**
   * Test {@link SkuFeeImpl#equals(Object)}, and {@link SkuFeeImpl#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link SkuFeeImpl#equals(Object)}
   *   <li>{@link SkuFeeImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    SkuFeeImpl skuFeeImpl = new SkuFeeImpl();
    skuFeeImpl.setAmount(new Money());
    skuFeeImpl.setCurrency(new BroadleafCurrencyImpl());
    skuFeeImpl.setDescription("The characteristics of someone or something");
    skuFeeImpl.setExpression("Expression");
    skuFeeImpl.setFeeType(SkuFeeType.FULFILLMENT);
    skuFeeImpl.setId(1L);
    skuFeeImpl.setName("Name");
    skuFeeImpl.setSkus(new ArrayList<>());
    skuFeeImpl.setTaxable(true);

    // Act and Assert
    assertEquals(skuFeeImpl, skuFeeImpl);
    int expectedHashCodeResult = skuFeeImpl.hashCode();
    assertEquals(expectedHashCodeResult, skuFeeImpl.hashCode());
  }

  /**
   * Test {@link SkuFeeImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuFeeImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    SkuFeeImpl skuFeeImpl = new SkuFeeImpl();
    skuFeeImpl.setAmount(null);
    skuFeeImpl.setCurrency(new BroadleafCurrencyImpl());
    skuFeeImpl.setDescription("The characteristics of someone or something");
    skuFeeImpl.setExpression("Expression");
    skuFeeImpl.setFeeType(SkuFeeType.FULFILLMENT);
    skuFeeImpl.setId(1L);
    skuFeeImpl.setName("Name");
    skuFeeImpl.setSkus(new ArrayList<>());
    skuFeeImpl.setTaxable(true);

    SkuFeeImpl skuFeeImpl2 = new SkuFeeImpl();
    skuFeeImpl2.setAmount(new Money());
    skuFeeImpl2.setCurrency(new BroadleafCurrencyImpl());
    skuFeeImpl2.setDescription("The characteristics of someone or something");
    skuFeeImpl2.setExpression("Expression");
    skuFeeImpl2.setFeeType(SkuFeeType.FULFILLMENT);
    skuFeeImpl2.setId(1L);
    skuFeeImpl2.setName("Name");
    skuFeeImpl2.setSkus(new ArrayList<>());
    skuFeeImpl2.setTaxable(true);

    // Act and Assert
    assertNotEquals(skuFeeImpl, skuFeeImpl2);
  }

  /**
   * Test {@link SkuFeeImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuFeeImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    SkuFeeImpl skuFeeImpl = new SkuFeeImpl();
    skuFeeImpl.setAmount(mock(Money.class));
    skuFeeImpl.setCurrency(new BroadleafCurrencyImpl());
    skuFeeImpl.setDescription("The characteristics of someone or something");
    skuFeeImpl.setExpression("Expression");
    skuFeeImpl.setFeeType(SkuFeeType.FULFILLMENT);
    skuFeeImpl.setId(1L);
    skuFeeImpl.setName("Name");
    skuFeeImpl.setSkus(new ArrayList<>());
    skuFeeImpl.setTaxable(true);

    SkuFeeImpl skuFeeImpl2 = new SkuFeeImpl();
    skuFeeImpl2.setAmount(new Money());
    skuFeeImpl2.setCurrency(new BroadleafCurrencyImpl());
    skuFeeImpl2.setDescription("The characteristics of someone or something");
    skuFeeImpl2.setExpression("Expression");
    skuFeeImpl2.setFeeType(SkuFeeType.FULFILLMENT);
    skuFeeImpl2.setId(1L);
    skuFeeImpl2.setName("Name");
    skuFeeImpl2.setSkus(new ArrayList<>());
    skuFeeImpl2.setTaxable(true);

    // Act and Assert
    assertNotEquals(skuFeeImpl, skuFeeImpl2);
  }

  /**
   * Test {@link SkuFeeImpl#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuFeeImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    SkuFeeImpl skuFeeImpl = new SkuFeeImpl();
    skuFeeImpl.setAmount(new Money());
    skuFeeImpl.setCurrency(new BroadleafCurrencyImpl());
    skuFeeImpl.setDescription("The characteristics of someone or something");
    skuFeeImpl.setExpression("Expression");
    skuFeeImpl.setFeeType(SkuFeeType.FULFILLMENT);
    skuFeeImpl.setId(1L);
    skuFeeImpl.setName("Name");
    skuFeeImpl.setSkus(new ArrayList<>());
    skuFeeImpl.setTaxable(true);

    // Act and Assert
    assertNotEquals(skuFeeImpl, null);
  }

  /**
   * Test {@link SkuFeeImpl#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuFeeImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    SkuFeeImpl skuFeeImpl = new SkuFeeImpl();
    skuFeeImpl.setAmount(new Money());
    skuFeeImpl.setCurrency(new BroadleafCurrencyImpl());
    skuFeeImpl.setDescription("The characteristics of someone or something");
    skuFeeImpl.setExpression("Expression");
    skuFeeImpl.setFeeType(SkuFeeType.FULFILLMENT);
    skuFeeImpl.setId(1L);
    skuFeeImpl.setName("Name");
    skuFeeImpl.setSkus(new ArrayList<>());
    skuFeeImpl.setTaxable(true);

    // Act and Assert
    assertNotEquals(skuFeeImpl, "Different type to SkuFeeImpl");
  }

  /**
   * Test new {@link SkuFeeImpl} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link SkuFeeImpl}
   */
  @Test
  public void testNewSkuFeeImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    SkuFeeImpl actualSkuFeeImpl = new SkuFeeImpl();

    // Assert
    SkuFeeType feeType = actualSkuFeeImpl.getFeeType();
    assertEquals("FULFILLMENT", feeType.getType());
    assertEquals("FULFILLMENT", actualSkuFeeImpl.feeType);
    assertEquals("Fulfillment", feeType.getFriendlyType());
    assertNull(actualSkuFeeImpl.getId());
    assertNull(actualSkuFeeImpl.getDescription());
    assertNull(actualSkuFeeImpl.getExpression());
    assertNull(actualSkuFeeImpl.getName());
    assertNull(actualSkuFeeImpl.amount);
    assertNull(actualSkuFeeImpl.getSkus());
    assertNull(actualSkuFeeImpl.getCurrency());
    assertNull(actualSkuFeeImpl.getAmount());
    assertFalse(actualSkuFeeImpl.getTaxable());
  }
}
