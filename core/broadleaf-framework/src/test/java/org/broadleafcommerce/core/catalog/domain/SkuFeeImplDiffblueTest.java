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
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
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
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@RunWith(SpringJUnit4ClassRunner.class)
public class SkuFeeImplDiffblueTest {
  @Autowired private SkuFeeImpl skuFeeImpl;

  /**
   * Test {@link SkuFeeImpl#getAmount()}.
   *
   * <ul>
   *   <li>Given {@link SkuFeeImpl} Currency is {@code null}.
   *   <li>Then return {@link Money#Money()}.
   * </ul>
   *
   * <p>Method under test: {@link SkuFeeImpl#getAmount()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money SkuFeeImpl.getAmount()"})
  public void testGetAmount_givenSkuFeeImplCurrencyIsNull_thenReturnMoney() {
    // Arrange
    Money amount = new Money();
    skuFeeImpl.setAmount(amount);
    skuFeeImpl.setCurrency(null);

    // Act and Assert
    assertEquals(amount, skuFeeImpl.getAmount());
  }

  /**
   * Test {@link SkuFeeImpl#getAmount()}.
   *
   * <ul>
   *   <li>Given {@link SkuFeeImpl}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SkuFeeImpl#getAmount()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money SkuFeeImpl.getAmount()"})
  public void testGetAmount_givenSkuFeeImpl_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(skuFeeImpl.getAmount());
  }

  /**
   * Test {@link SkuFeeImpl#getAmount()}.
   *
   * <ul>
   *   <li>Then return Currency DisplayName is {@code British Pound Sterling}.
   * </ul>
   *
   * <p>Method under test: {@link SkuFeeImpl#getAmount()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money SkuFeeImpl.getAmount()"})
  public void testGetAmount_thenReturnCurrencyDisplayNameIsBritishPoundSterling() {
    // Arrange
    BroadleafCurrency currency = mock(BroadleafCurrency.class);
    when(currency.getCurrencyCode()).thenReturn("GBP");
    skuFeeImpl.setAmount(new Money());
    skuFeeImpl.setCurrency(currency);

    // Act
    Money actualAmount = skuFeeImpl.getAmount();

    // Assert
    verify(currency).getCurrencyCode();
    Currency currency2 = actualAmount.getCurrency();
    assertEquals("British Pound Sterling", currency2.getDisplayName());
    assertEquals("GBP", currency2.getCurrencyCode());
    assertEquals("GBP", currency2.getSymbol());
    assertEquals("GBP", currency2.toString());
    assertEquals(826, currency2.getNumericCode());
    Money actualAbsResult = actualAmount.abs();
    assertEquals(actualAmount, actualAbsResult);
    Money actualZeroResult = actualAmount.zero();
    assertEquals(actualAmount, actualZeroResult);
  }

  /**
   * Test {@link SkuFeeImpl#setAmount(Money)}.
   *
   * <ul>
   *   <li>When {@link Money#Money()}.
   *   <li>Then {@link SkuFeeImpl} {@link SkuFeeImpl#amount} is {@link
   *       BigDecimal#BigDecimal(String)} with {@code 0.00}.
   * </ul>
   *
   * <p>Method under test: {@link SkuFeeImpl#setAmount(Money)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SkuFeeImpl.setAmount(Money)"})
  public void testSetAmount_whenMoney_thenSkuFeeImplAmountIsBigDecimalWith000() {
    // Arrange
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
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link SkuFeeImpl} {@link SkuFeeImpl#amount} is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SkuFeeImpl#setAmount(Money)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SkuFeeImpl.setAmount(Money)"})
  public void testSetAmount_whenNull_thenSkuFeeImplAmountIsNull() {
    // Arrange and Act
    skuFeeImpl.setAmount(null);

    // Assert that nothing has changed
    assertNull(skuFeeImpl.amount);
  }

  /**
   * Test {@link SkuFeeImpl#getFeeType()}.
   *
   * <p>Method under test: {@link SkuFeeImpl#getFeeType()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"SkuFeeType SkuFeeImpl.getFeeType()"})
  public void testGetFeeType() {
    // Arrange, Act and Assert
    assertSame(SkuFeeType.FULFILLMENT, skuFeeImpl.getFeeType());
  }

  /**
   * Test {@link SkuFeeImpl#setFeeType(SkuFeeType)}.
   *
   * <ul>
   *   <li>When {@link SkuFeeType#FULFILLMENT}.
   *   <li>Then {@link SkuFeeImpl} {@link SkuFeeImpl#feeType} is {@code FULFILLMENT}.
   * </ul>
   *
   * <p>Method under test: {@link SkuFeeImpl#setFeeType(SkuFeeType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SkuFeeImpl.setFeeType(SkuFeeType)"})
  public void testSetFeeType_whenFulfillment_thenSkuFeeImplFeeTypeIsFulfillment() {
    // Arrange and Act
    skuFeeImpl.setFeeType(SkuFeeType.FULFILLMENT);

    // Assert that nothing has changed
    assertEquals("FULFILLMENT", skuFeeImpl.feeType);
    assertSame(SkuFeeType.FULFILLMENT, skuFeeImpl.getFeeType());
  }

  /**
   * Test {@link SkuFeeImpl#setFeeType(SkuFeeType)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link SkuFeeImpl} {@link SkuFeeImpl#feeType} is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SkuFeeImpl#setFeeType(SkuFeeType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SkuFeeImpl.setFeeType(SkuFeeType)"})
  public void testSetFeeType_whenNull_thenSkuFeeImplFeeTypeIsNull() {
    // Arrange and Act
    skuFeeImpl.setFeeType(null);

    // Assert
    assertNull(skuFeeImpl.feeType);
    assertNull(skuFeeImpl.getFeeType());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BroadleafCurrency SkuFeeImpl.getCurrency()",
    "String SkuFeeImpl.getDescription()",
    "String SkuFeeImpl.getExpression()",
    "Long SkuFeeImpl.getId()",
    "String SkuFeeImpl.getName()",
    "List SkuFeeImpl.getSkus()",
    "Boolean SkuFeeImpl.getTaxable()",
    "void SkuFeeImpl.setCurrency(BroadleafCurrency)",
    "void SkuFeeImpl.setDescription(String)",
    "void SkuFeeImpl.setExpression(String)",
    "void SkuFeeImpl.setId(Long)",
    "void SkuFeeImpl.setName(String)",
    "void SkuFeeImpl.setSkus(List)",
    "void SkuFeeImpl.setTaxable(Boolean)"
  })
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
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SkuFeeImpl#equals(Object)}
   *   <li>{@link SkuFeeImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
    assertEquals(skuFeeImpl.hashCode(), skuFeeImpl2.hashCode());
  }

  /**
   * Test {@link SkuFeeImpl#equals(Object)}, and {@link SkuFeeImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SkuFeeImpl#equals(Object)}
   *   <li>{@link SkuFeeImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SkuFeeImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SkuFeeImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SkuFeeImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
   *
   * <p>Method under test: default or parameterless constructor of {@link SkuFeeImpl}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
