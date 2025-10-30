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
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Currency;
import java.util.List;
import org.broadleafcommerce.common.currency.domain.BroadleafCurrency;
import org.broadleafcommerce.common.currency.domain.BroadleafCurrencyImpl;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.core.catalog.service.type.SkuFeeType;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class SkuFeeImplDiffblueTest {
  @Autowired
  private SkuFeeImpl skuFeeImpl;

  /**
   * Test {@link SkuFeeImpl#getAmount()}.
   * <ul>
   *   <li>Given {@link SkuFeeImpl} (default constructor) Currency is {@code null}.</li>
   *   <li>Then return {@link Money#Money()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuFeeImpl#getAmount()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money SkuFeeImpl.getAmount()"})
  public void testGetAmount_givenSkuFeeImplCurrencyIsNull_thenReturnMoney() {
    // Arrange
    SkuFeeImpl skuFeeImpl2 = new SkuFeeImpl();
    skuFeeImpl2.setDescription("The characteristics of someone or something");
    skuFeeImpl2.setExpression("Expression");
    skuFeeImpl2.setFeeType(SkuFeeType.FULFILLMENT);
    skuFeeImpl2.setId(1L);
    skuFeeImpl2.setName("Name");
    skuFeeImpl2.setSkus(new ArrayList<>());
    skuFeeImpl2.setTaxable(true);
    Money amount = new Money();
    skuFeeImpl2.setAmount(amount);
    skuFeeImpl2.setCurrency(null);

    // Act and Assert
    assertEquals(amount, skuFeeImpl2.getAmount());
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money SkuFeeImpl.getAmount()"})
  public void testGetAmount_givenSkuFeeImpl_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new SkuFeeImpl()).getAmount());
  }

  /**
   * Test {@link SkuFeeImpl#getAmount()}.
   * <ul>
   *   <li>Then return Currency DisplayName is {@code British Pound}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuFeeImpl#getAmount()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money SkuFeeImpl.getAmount()"})
  public void testGetAmount_thenReturnCurrencyDisplayNameIsBritishPound() {
    // Arrange
    BroadleafCurrency currency = mock(BroadleafCurrency.class);
    when(currency.getCurrencyCode()).thenReturn("GBP");

    SkuFeeImpl skuFeeImpl2 = new SkuFeeImpl();
    skuFeeImpl2.setDescription("The characteristics of someone or something");
    skuFeeImpl2.setExpression("Expression");
    skuFeeImpl2.setFeeType(SkuFeeType.FULFILLMENT);
    skuFeeImpl2.setId(1L);
    skuFeeImpl2.setName("Name");
    skuFeeImpl2.setSkus(new ArrayList<>());
    skuFeeImpl2.setTaxable(true);
    skuFeeImpl2.setAmount(new Money());
    skuFeeImpl2.setCurrency(currency);

    // Act
    Money actualAmount = skuFeeImpl2.getAmount();

    // Assert
    verify(currency).getCurrencyCode();
    Currency currency2 = actualAmount.getCurrency();
    assertEquals("British Pound", currency2.getDisplayName());
    assertEquals("GBP", currency2.getCurrencyCode());
    assertEquals("GBP", currency2.toString());
    assertEquals("£", currency2.getSymbol());
    assertEquals(826, currency2.getNumericCode());
    assertEquals(actualAmount, actualAmount.abs());
    assertEquals(actualAmount, actualAmount.zero());
  }

  /**
   * Test {@link SkuFeeImpl#setAmount(Money)}.
   * <ul>
   *   <li>When {@link Money#Money()}.</li>
   *   <li>Then {@link SkuFeeImpl} (default constructor) {@link SkuFeeImpl#amount} is {@link BigDecimal#BigDecimal(String)} with {@code 0.00}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuFeeImpl#setAmount(Money)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SkuFeeImpl.setAmount(Money)"})
  public void testSetAmount_whenMoney_thenSkuFeeImplAmountIsBigDecimalWith000() {
    // Arrange
    SkuFeeImpl skuFeeImpl2 = new SkuFeeImpl();
    Money amount = new Money();

    // Act
    skuFeeImpl2.setAmount(amount);

    // Assert
    assertEquals(new BigDecimal("0.00"), skuFeeImpl2.amount);
    BigDecimal bigDecimal = skuFeeImpl2.amount;
    Money absResult = amount.abs();
    assertSame(bigDecimal, absResult.getAmount());
    Money absResult2 = absResult.abs();
    assertSame(bigDecimal, absResult2.getAmount());
    assertSame(bigDecimal, absResult2.abs().getAmount());
    Money zeroResult = amount.zero();
    Money absResult3 = zeroResult.abs();
    assertSame(bigDecimal, absResult3.abs().getAmount());
    assertSame(bigDecimal, absResult3.getAmount());
    Money zeroResult2 = absResult.zero();
    assertSame(bigDecimal, zeroResult2.abs().getAmount());
    Money zeroResult3 = zeroResult.zero();
    assertSame(bigDecimal, zeroResult3.abs().getAmount());
    assertSame(bigDecimal, zeroResult.getAmount());
    assertSame(bigDecimal, zeroResult2.getAmount());
    assertSame(bigDecimal, absResult2.zero().getAmount());
    assertSame(bigDecimal, absResult3.zero().getAmount());
    assertSame(bigDecimal, zeroResult3.getAmount());
    assertSame(bigDecimal, zeroResult2.zero().getAmount());
    assertSame(bigDecimal, zeroResult3.zero().getAmount());
  }

  /**
   * Test {@link SkuFeeImpl#setAmount(Money)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link SkuFeeImpl} (default constructor) {@link SkuFeeImpl#amount} is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuFeeImpl#setAmount(Money)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SkuFeeImpl.setAmount(Money)"})
  public void testSetAmount_whenNull_thenSkuFeeImplAmountIsNull() {
    // Arrange
    SkuFeeImpl skuFeeImpl2 = new SkuFeeImpl();

    // Act
    skuFeeImpl2.setAmount(null);

    // Assert that nothing has changed
    assertNull(skuFeeImpl2.amount);
  }

  /**
   * Test {@link SkuFeeImpl#getFeeType()}.
   * <p>
   * Method under test: {@link SkuFeeImpl#getFeeType()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"SkuFeeType SkuFeeImpl.getFeeType()"})
  public void testGetFeeType() {
    // Arrange and Act
    SkuFeeType actualFeeType = (new SkuFeeImpl()).getFeeType();

    // Assert
    assertSame(actualFeeType.FULFILLMENT, actualFeeType);
  }

  /**
   * Test {@link SkuFeeImpl#setFeeType(SkuFeeType)}.
   * <ul>
   *   <li>Given {@link SkuFeeImpl} (default constructor) Amount is {@link Money#Money()}.</li>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link SkuFeeImpl} (default constructor) {@link SkuFeeImpl#feeType} is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuFeeImpl#setFeeType(SkuFeeType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SkuFeeImpl.setFeeType(SkuFeeType)"})
  public void testSetFeeType_givenSkuFeeImplAmountIsMoney_whenNull_thenSkuFeeImplFeeTypeIsNull() {
    // Arrange
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

    // Act
    skuFeeImpl2.setFeeType(null);

    // Assert
    assertNull(skuFeeImpl2.feeType);
    assertNull(skuFeeImpl2.getFeeType());
  }

  /**
   * Test {@link SkuFeeImpl#setFeeType(SkuFeeType)}.
   * <ul>
   *   <li>When {@link SkuFeeType#FULFILLMENT}.</li>
   *   <li>Then {@link SkuFeeImpl} (default constructor) {@link SkuFeeImpl#feeType} is {@code FULFILLMENT}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuFeeImpl#setFeeType(SkuFeeType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SkuFeeImpl.setFeeType(SkuFeeType)"})
  public void testSetFeeType_whenFulfillment_thenSkuFeeImplFeeTypeIsFulfillment() {
    // Arrange
    SkuFeeImpl skuFeeImpl2 = new SkuFeeImpl();
    SkuFeeType feeType = SkuFeeType.FULFILLMENT;

    // Act
    skuFeeImpl2.setFeeType(feeType);

    // Assert that nothing has changed
    assertEquals("FULFILLMENT", skuFeeImpl2.feeType);
    SkuFeeType expectedFeeType = feeType.FULFILLMENT;
    assertSame(expectedFeeType, skuFeeImpl2.getFeeType());
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"BroadleafCurrency SkuFeeImpl.getCurrency()", "String SkuFeeImpl.getDescription()",
      "String SkuFeeImpl.getExpression()", "Long SkuFeeImpl.getId()", "String SkuFeeImpl.getName()",
      "List SkuFeeImpl.getSkus()", "Boolean SkuFeeImpl.getTaxable()", "void SkuFeeImpl.setCurrency(BroadleafCurrency)",
      "void SkuFeeImpl.setDescription(String)", "void SkuFeeImpl.setExpression(String)", "void SkuFeeImpl.setId(Long)",
      "void SkuFeeImpl.setName(String)", "void SkuFeeImpl.setSkus(List)", "void SkuFeeImpl.setTaxable(Boolean)"})
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

    // Assert
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean SkuFeeImpl.equals(Object)", "int SkuFeeImpl.hashCode()"})
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean SkuFeeImpl.equals(Object)", "int SkuFeeImpl.hashCode()"})
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean SkuFeeImpl.equals(Object)", "int SkuFeeImpl.hashCode()"})
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
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuFeeImpl#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean SkuFeeImpl.equals(Object)", "int SkuFeeImpl.hashCode()"})
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean SkuFeeImpl.equals(Object)", "int SkuFeeImpl.hashCode()"})
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SkuFeeImpl.<init>()"})
  public void testNewSkuFeeImpl() {
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
