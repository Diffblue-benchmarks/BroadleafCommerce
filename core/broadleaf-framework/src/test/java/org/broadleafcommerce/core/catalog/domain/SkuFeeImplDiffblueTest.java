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
import java.util.Currency;
import java.util.List;
import org.broadleafcommerce.common.currency.domain.BroadleafCurrency;
import org.broadleafcommerce.common.currency.domain.BroadleafCurrencyImpl;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.core.catalog.service.type.SkuFeeType;
import org.junit.Test;

public class SkuFeeImplDiffblueTest {
  /**
   * Method under test: {@link SkuFeeImpl#getAmount()}
   */
  @Test
  public void testGetAmount() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new SkuFeeImpl()).getAmount());
  }

  /**
   * Method under test: {@link SkuFeeImpl#getAmount()}
   */
  @Test
  public void testGetAmount2() {
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
   * Method under test: {@link SkuFeeImpl#getAmount()}
   */
  @Test
  public void testGetAmount3() {
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
   * Method under test: {@link SkuFeeImpl#getAmount()}
   */
  @Test
  public void testGetAmount4() {
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
    skuFeeImpl.setAmount(new Money());
    skuFeeImpl.setCurrency(currency);

    // Act
    Money actualAmount = skuFeeImpl.getAmount();

    // Assert
    verify(currency).getCurrencyCode();
    verify(feeType).getType();
    Currency currency2 = actualAmount.getCurrency();
    assertEquals("British Pound", currency2.getDisplayName());
    assertEquals("GBP", currency2.getCurrencyCode());
    assertEquals("GBP", currency2.toString());
    assertEquals("£", currency2.getSymbol());
    assertEquals(2, currency2.getDefaultFractionDigits());
    assertEquals(826, currency2.getNumericCode());
    BigDecimal expectedAmount = new BigDecimal("0.00");
    BigDecimal amount = actualAmount.getAmount();
    assertEquals(expectedAmount, amount);
    assertEquals(actualAmount, actualAmount.abs());
    assertEquals(actualAmount, actualAmount.zero());
    assertSame(skuFeeImpl.amount, amount);
  }

  /**
   * Method under test: {@link SkuFeeImpl#setAmount(Money)}
   */
  @Test
  public void testSetAmount() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuFeeImpl skuFeeImpl = new SkuFeeImpl();
    Money amount = new Money();

    // Act
    skuFeeImpl.setAmount(amount);

    // Assert
    BigDecimal expectedAmount = new BigDecimal("0.00");
    BigDecimal amount2 = amount.getAmount();
    assertEquals(expectedAmount, amount2);
    assertEquals(new BigDecimal("0.00"), skuFeeImpl.amount);
    assertEquals(amount, amount.abs());
    assertEquals(amount, amount.zero());
    assertSame(skuFeeImpl.amount, amount2);
  }

  /**
   * Method under test: {@link SkuFeeImpl#setAmount(Money)}
   */
  @Test
  public void testSetAmount2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuFeeImpl skuFeeImpl = new SkuFeeImpl();

    // Act
    skuFeeImpl.setAmount(null);

    // Assert
    assertNull(skuFeeImpl.amount);
  }

  /**
   * Method under test: {@link SkuFeeImpl#setAmount(Money)}
   */
  @Test
  public void testSetAmount3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuFeeImpl skuFeeImpl = new SkuFeeImpl();

    // Act
    skuFeeImpl.setAmount(mock(Money.class));

    // Assert
    assertNull(skuFeeImpl.amount);
  }

  /**
   * Method under test: {@link SkuFeeImpl#getFeeType()}
   */
  @Test
  public void testGetFeeType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    SkuFeeType actualFeeType = (new SkuFeeImpl()).getFeeType();

    // Assert
    assertSame(actualFeeType.FULFILLMENT, actualFeeType);
  }

  /**
   * Method under test: {@link SkuFeeImpl#getFeeType()}
   */
  @Test
  public void testGetFeeType2() {
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
   * Method under test: {@link SkuFeeImpl#setFeeType(SkuFeeType)}
   */
  @Test
  public void testSetFeeType() {
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
   * Method under test: {@link SkuFeeImpl#setFeeType(SkuFeeType)}
   */
  @Test
  public void testSetFeeType2() {
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
