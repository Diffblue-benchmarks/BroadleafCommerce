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
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.math.BigDecimal;
import java.util.Currency;
import org.broadleafcommerce.common.copy.CreateResponse;
import org.broadleafcommerce.common.copy.MultiTenantCopyContext;
import org.broadleafcommerce.common.currency.domain.BroadleafCurrency;
import org.broadleafcommerce.common.currency.domain.BroadleafCurrencyImpl;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.core.order.service.type.FulfillmentType;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml"})
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@RunWith(SpringJUnit4ClassRunner.class)
public class FixedPriceFulfillmentOptionImplDiffblueTest {
  @Autowired private FixedPriceFulfillmentOptionImpl fixedPriceFulfillmentOptionImpl;

  /**
   * Test {@link FixedPriceFulfillmentOptionImpl#getPrice()}.
   *
   * <ul>
   *   <li>Given {@link FixedPriceFulfillmentOptionImpl} Currency is {@code null}.
   *   <li>Then return {@link Money#Money()}.
   * </ul>
   *
   * <p>Method under test: {@link FixedPriceFulfillmentOptionImpl#getPrice()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money FixedPriceFulfillmentOptionImpl.getPrice()"})
  public void testGetPrice_givenFixedPriceFulfillmentOptionImplCurrencyIsNull_thenReturnMoney() {
    // Arrange
    Money price = new Money();
    fixedPriceFulfillmentOptionImpl.setPrice(price);
    fixedPriceFulfillmentOptionImpl.setCurrency(null);

    // Act and Assert
    assertEquals(price, fixedPriceFulfillmentOptionImpl.getPrice());
  }

  /**
   * Test {@link FixedPriceFulfillmentOptionImpl#getPrice()}.
   *
   * <ul>
   *   <li>Given {@link FixedPriceFulfillmentOptionImpl}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link FixedPriceFulfillmentOptionImpl#getPrice()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money FixedPriceFulfillmentOptionImpl.getPrice()"})
  public void testGetPrice_givenFixedPriceFulfillmentOptionImpl_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(fixedPriceFulfillmentOptionImpl.getPrice());
  }

  /**
   * Test {@link FixedPriceFulfillmentOptionImpl#getPrice()}.
   *
   * <ul>
   *   <li>Then return Currency DisplayName is {@code British Pound}.
   * </ul>
   *
   * <p>Method under test: {@link FixedPriceFulfillmentOptionImpl#getPrice()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money FixedPriceFulfillmentOptionImpl.getPrice()"})
  public void testGetPrice_thenReturnCurrencyDisplayNameIsBritishPound() {
    // Arrange
    BroadleafCurrency currency = mock(BroadleafCurrency.class);
    when(currency.getCurrencyCode()).thenReturn("GBP");
    fixedPriceFulfillmentOptionImpl.setPrice(new Money());
    fixedPriceFulfillmentOptionImpl.setCurrency(currency);

    // Act
    Money actualPrice = fixedPriceFulfillmentOptionImpl.getPrice();

    // Assert
    verify(currency).getCurrencyCode();
    Currency currency2 = actualPrice.getCurrency();
    assertEquals("British Pound", currency2.getDisplayName());
    assertEquals("GBP", currency2.getCurrencyCode());
    assertEquals("GBP", currency2.toString());
    assertEquals("£", currency2.getSymbol());
    assertEquals(826, currency2.getNumericCode());
    Money actualAbsResult = actualPrice.abs();
    assertEquals(actualPrice, actualAbsResult);
    Money actualZeroResult = actualPrice.zero();
    assertEquals(actualPrice, actualZeroResult);
  }

  /**
   * Test {@link FixedPriceFulfillmentOptionImpl#setPrice(Money)}.
   *
   * <ul>
   *   <li>Then {@link FixedPriceFulfillmentOptionImpl} {@link
   *       FixedPriceFulfillmentOptionImpl#price} is {@link BigDecimal#BigDecimal(String)} with
   *       {@code 0.00}.
   * </ul>
   *
   * <p>Method under test: {@link FixedPriceFulfillmentOptionImpl#setPrice(Money)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void FixedPriceFulfillmentOptionImpl.setPrice(Money)"})
  public void testSetPrice_thenFixedPriceFulfillmentOptionImplPriceIsBigDecimalWith000() {
    // Arrange
    Money price = new Money();

    // Act
    fixedPriceFulfillmentOptionImpl.setPrice(price);

    // Assert
    assertEquals(new BigDecimal("0.00"), fixedPriceFulfillmentOptionImpl.price);
    BigDecimal bigDecimal = fixedPriceFulfillmentOptionImpl.price;
    Money absResult = price.abs();
    assertSame(bigDecimal, absResult.getAmount());
    Money absResult2 = absResult.abs();
    assertSame(bigDecimal, absResult2.getAmount());
    assertSame(bigDecimal, absResult2.abs().getAmount());
    Money zeroResult = price.zero();
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
   * Test {@link FixedPriceFulfillmentOptionImpl#setPrice(Money)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link FixedPriceFulfillmentOptionImpl} {@link
   *       FixedPriceFulfillmentOptionImpl#price} is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link FixedPriceFulfillmentOptionImpl#setPrice(Money)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void FixedPriceFulfillmentOptionImpl.setPrice(Money)"})
  public void testSetPrice_whenNull_thenFixedPriceFulfillmentOptionImplPriceIsNull() {
    // Arrange and Act
    fixedPriceFulfillmentOptionImpl.setPrice(null);

    // Assert that nothing has changed
    assertNull(fixedPriceFulfillmentOptionImpl.price);
  }

  /**
   * Test {@link FixedPriceFulfillmentOptionImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link FixedPriceFulfillmentOptionImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean FixedPriceFulfillmentOptionImpl.equals(Object)",
    "int FixedPriceFulfillmentOptionImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    FixedPriceFulfillmentOptionImpl fixedPriceFulfillmentOptionImpl =
        new FixedPriceFulfillmentOptionImpl();
    fixedPriceFulfillmentOptionImpl.setCurrency(null);
    fixedPriceFulfillmentOptionImpl.setFulfillmentType(FulfillmentType.DIGITAL);
    fixedPriceFulfillmentOptionImpl.setId(1L);
    fixedPriceFulfillmentOptionImpl.setLongDescription("Long Description");
    fixedPriceFulfillmentOptionImpl.setName("Name");
    fixedPriceFulfillmentOptionImpl.setPrice(new Money());
    fixedPriceFulfillmentOptionImpl.setTaxCode("Tax Code");
    fixedPriceFulfillmentOptionImpl.setTaxable(true);
    fixedPriceFulfillmentOptionImpl.setUseFlatRates(true);

    BroadleafCurrency currency = mock(BroadleafCurrency.class);
    when(currency.getCurrencyCode()).thenReturn("GBP");

    FixedPriceFulfillmentOptionImpl fixedPriceFulfillmentOptionImpl2 =
        new FixedPriceFulfillmentOptionImpl();
    fixedPriceFulfillmentOptionImpl2.setCurrency(currency);
    fixedPriceFulfillmentOptionImpl2.setFulfillmentType(FulfillmentType.DIGITAL);
    fixedPriceFulfillmentOptionImpl2.setId(1L);
    fixedPriceFulfillmentOptionImpl2.setLongDescription("Long Description");
    fixedPriceFulfillmentOptionImpl2.setName("Name");
    fixedPriceFulfillmentOptionImpl2.setPrice(new Money());
    fixedPriceFulfillmentOptionImpl2.setTaxCode("Tax Code");
    fixedPriceFulfillmentOptionImpl2.setTaxable(true);
    fixedPriceFulfillmentOptionImpl2.setUseFlatRates(true);

    // Act and Assert
    assertNotEquals(fixedPriceFulfillmentOptionImpl, fixedPriceFulfillmentOptionImpl2);
  }

  /**
   * Test {@link FixedPriceFulfillmentOptionImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link FixedPriceFulfillmentOptionImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean FixedPriceFulfillmentOptionImpl.equals(Object)",
    "int FixedPriceFulfillmentOptionImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    FixedPriceFulfillmentOptionImpl fixedPriceFulfillmentOptionImpl =
        new FixedPriceFulfillmentOptionImpl();
    fixedPriceFulfillmentOptionImpl.setCurrency(null);
    fixedPriceFulfillmentOptionImpl.setFulfillmentType(FulfillmentType.DIGITAL);
    fixedPriceFulfillmentOptionImpl.setId(1L);
    fixedPriceFulfillmentOptionImpl.setLongDescription("Long Description");
    fixedPriceFulfillmentOptionImpl.setName("Name");
    fixedPriceFulfillmentOptionImpl.setPrice(null);
    fixedPriceFulfillmentOptionImpl.setTaxCode("Tax Code");
    fixedPriceFulfillmentOptionImpl.setTaxable(true);
    fixedPriceFulfillmentOptionImpl.setUseFlatRates(true);

    BroadleafCurrency currency = mock(BroadleafCurrency.class);
    when(currency.getCurrencyCode()).thenReturn("GBP");

    FixedPriceFulfillmentOptionImpl fixedPriceFulfillmentOptionImpl2 =
        new FixedPriceFulfillmentOptionImpl();
    fixedPriceFulfillmentOptionImpl2.setCurrency(currency);
    fixedPriceFulfillmentOptionImpl2.setFulfillmentType(FulfillmentType.DIGITAL);
    fixedPriceFulfillmentOptionImpl2.setId(1L);
    fixedPriceFulfillmentOptionImpl2.setLongDescription("Long Description");
    fixedPriceFulfillmentOptionImpl2.setName("Name");
    fixedPriceFulfillmentOptionImpl2.setPrice(new Money());
    fixedPriceFulfillmentOptionImpl2.setTaxCode("Tax Code");
    fixedPriceFulfillmentOptionImpl2.setTaxable(true);
    fixedPriceFulfillmentOptionImpl2.setUseFlatRates(true);

    // Act and Assert
    assertNotEquals(fixedPriceFulfillmentOptionImpl, fixedPriceFulfillmentOptionImpl2);
  }

  /**
   * Test {@link FixedPriceFulfillmentOptionImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link FixedPriceFulfillmentOptionImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean FixedPriceFulfillmentOptionImpl.equals(Object)",
    "int FixedPriceFulfillmentOptionImpl.hashCode()"
  })
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    FixedPriceFulfillmentOptionImpl fixedPriceFulfillmentOptionImpl =
        new FixedPriceFulfillmentOptionImpl();
    fixedPriceFulfillmentOptionImpl.setCurrency(new BroadleafCurrencyImpl());
    fixedPriceFulfillmentOptionImpl.setFulfillmentType(FulfillmentType.DIGITAL);
    fixedPriceFulfillmentOptionImpl.setId(1L);
    fixedPriceFulfillmentOptionImpl.setLongDescription("Long Description");
    fixedPriceFulfillmentOptionImpl.setName("Name");
    fixedPriceFulfillmentOptionImpl.setPrice(new Money());
    fixedPriceFulfillmentOptionImpl.setTaxCode("Tax Code");
    fixedPriceFulfillmentOptionImpl.setTaxable(true);
    fixedPriceFulfillmentOptionImpl.setUseFlatRates(true);

    // Act and Assert
    assertNotEquals(fixedPriceFulfillmentOptionImpl, null);
  }

  /**
   * Test {@link FixedPriceFulfillmentOptionImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Method under test: {@link FixedPriceFulfillmentOptionImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean FixedPriceFulfillmentOptionImpl.equals(Object)",
    "int FixedPriceFulfillmentOptionImpl.hashCode()"
  })
  public void testEquals_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    FixedPriceFulfillmentOptionImpl fixedPriceFulfillmentOptionImpl =
        new FixedPriceFulfillmentOptionImpl();
    fixedPriceFulfillmentOptionImpl.setCurrency(new BroadleafCurrencyImpl());
    fixedPriceFulfillmentOptionImpl.setFulfillmentType(FulfillmentType.DIGITAL);
    fixedPriceFulfillmentOptionImpl.setId(1L);
    fixedPriceFulfillmentOptionImpl.setLongDescription("Long Description");
    fixedPriceFulfillmentOptionImpl.setName("Name");
    fixedPriceFulfillmentOptionImpl.setPrice(new Money());
    fixedPriceFulfillmentOptionImpl.setTaxCode("Tax Code");
    fixedPriceFulfillmentOptionImpl.setTaxable(true);
    fixedPriceFulfillmentOptionImpl.setUseFlatRates(true);

    // Act and Assert
    assertEquals(fixedPriceFulfillmentOptionImpl, fixedPriceFulfillmentOptionImpl);
  }

  /**
   * Test {@link FixedPriceFulfillmentOptionImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link FixedPriceFulfillmentOptionImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean FixedPriceFulfillmentOptionImpl.equals(Object)",
    "int FixedPriceFulfillmentOptionImpl.hashCode()"
  })
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    FixedPriceFulfillmentOptionImpl fixedPriceFulfillmentOptionImpl =
        new FixedPriceFulfillmentOptionImpl();
    fixedPriceFulfillmentOptionImpl.setCurrency(new BroadleafCurrencyImpl());
    fixedPriceFulfillmentOptionImpl.setFulfillmentType(FulfillmentType.DIGITAL);
    fixedPriceFulfillmentOptionImpl.setId(1L);
    fixedPriceFulfillmentOptionImpl.setLongDescription("Long Description");
    fixedPriceFulfillmentOptionImpl.setName("Name");
    fixedPriceFulfillmentOptionImpl.setPrice(new Money());
    fixedPriceFulfillmentOptionImpl.setTaxCode("Tax Code");
    fixedPriceFulfillmentOptionImpl.setTaxable(true);
    fixedPriceFulfillmentOptionImpl.setUseFlatRates(true);

    // Act and Assert
    assertNotEquals(
        fixedPriceFulfillmentOptionImpl, "Different type to FixedPriceFulfillmentOptionImpl");
  }

  /**
   * Test {@link
   * FixedPriceFulfillmentOptionImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   *
   * <p>Method under test: {@link
   * FixedPriceFulfillmentOptionImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CreateResponse FixedPriceFulfillmentOptionImpl.createOrRetrieveCopyInstance(MultiTenantCopyContext)"
  })
  public void testCreateOrRetrieveCopyInstance() throws CloneNotSupportedException {
    // Arrange
    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    CreateResponse<Object> createResponse =
        new CreateResponse<>(new FixedPriceFulfillmentOptionImpl(), true);
    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<FixedPriceFulfillmentOption> actualCreateOrRetrieveCopyInstanceResult =
        fixedPriceFulfillmentOptionImpl.createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
  }

  /**
   * Test {@link
   * FixedPriceFulfillmentOptionImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   *
   * <p>Method under test: {@link
   * FixedPriceFulfillmentOptionImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CreateResponse FixedPriceFulfillmentOptionImpl.createOrRetrieveCopyInstance(MultiTenantCopyContext)"
  })
  public void testCreateOrRetrieveCopyInstance2() throws CloneNotSupportedException {
    // Arrange
    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    CreateResponse<Object> createResponse =
        new CreateResponse<>(fixedPriceFulfillmentOptionImpl, false);
    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<FixedPriceFulfillmentOption> actualCreateOrRetrieveCopyInstanceResult =
        fixedPriceFulfillmentOptionImpl.createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link FixedPriceFulfillmentOptionImpl}
   *   <li>{@link FixedPriceFulfillmentOptionImpl#setCurrency(BroadleafCurrency)}
   *   <li>{@link FixedPriceFulfillmentOptionImpl#getCurrency()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void FixedPriceFulfillmentOptionImpl.<init>()",
    "BroadleafCurrency FixedPriceFulfillmentOptionImpl.getCurrency()",
    "void FixedPriceFulfillmentOptionImpl.setCurrency(BroadleafCurrency)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    FixedPriceFulfillmentOptionImpl actualFixedPriceFulfillmentOptionImpl =
        new FixedPriceFulfillmentOptionImpl();
    BroadleafCurrencyImpl currency = new BroadleafCurrencyImpl();
    actualFixedPriceFulfillmentOptionImpl.setCurrency(currency);
    BroadleafCurrency actualCurrency = actualFixedPriceFulfillmentOptionImpl.getCurrency();

    // Assert
    assertNull(actualFixedPriceFulfillmentOptionImpl.getId());
    assertNull(actualFixedPriceFulfillmentOptionImpl.getTaxCode());
    assertFalse(actualFixedPriceFulfillmentOptionImpl.getTaxable());
    assertTrue(actualFixedPriceFulfillmentOptionImpl.getUseFlatRates());
    assertSame(currency, actualCurrency);
  }
}
