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
package org.broadleafcommerce.core.order.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.math.BigDecimal;
import java.util.Currency;
import org.broadleafcommerce.common.config.domain.ModuleConfiguration;
import org.broadleafcommerce.common.copy.CreateResponse;
import org.broadleafcommerce.common.copy.MultiTenantCopyContext;
import org.broadleafcommerce.common.currency.domain.BroadleafCurrency;
import org.broadleafcommerce.common.currency.domain.BroadleafCurrencyImpl;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.common.sitemap.domain.SiteMapConfigurationImpl;
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
public class TaxDetailImplDiffblueTest {
  @Autowired private TaxDetailImpl taxDetailImpl;

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TaxDetailImpl#TaxDetailImpl()}
   *   <li>{@link TaxDetailImpl#setCountry(String)}
   *   <li>{@link TaxDetailImpl#setCurrency(BroadleafCurrency)}
   *   <li>{@link TaxDetailImpl#setId(Long)}
   *   <li>{@link TaxDetailImpl#setJurisdictionName(String)}
   *   <li>{@link TaxDetailImpl#setModuleConfiguration(ModuleConfiguration)}
   *   <li>{@link TaxDetailImpl#setRate(BigDecimal)}
   *   <li>{@link TaxDetailImpl#setRegion(String)}
   *   <li>{@link TaxDetailImpl#setTaxName(String)}
   *   <li>{@link TaxDetailImpl#getCountry()}
   *   <li>{@link TaxDetailImpl#getCurrency()}
   *   <li>{@link TaxDetailImpl#getId()}
   *   <li>{@link TaxDetailImpl#getJurisdictionName()}
   *   <li>{@link TaxDetailImpl#getModuleConfiguration()}
   *   <li>{@link TaxDetailImpl#getRate()}
   *   <li>{@link TaxDetailImpl#getRegion()}
   *   <li>{@link TaxDetailImpl#getTaxName()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TaxDetailImpl.<init>()",
    "String TaxDetailImpl.getCountry()",
    "BroadleafCurrency TaxDetailImpl.getCurrency()",
    "Long TaxDetailImpl.getId()",
    "String TaxDetailImpl.getJurisdictionName()",
    "ModuleConfiguration TaxDetailImpl.getModuleConfiguration()",
    "BigDecimal TaxDetailImpl.getRate()",
    "String TaxDetailImpl.getRegion()",
    "String TaxDetailImpl.getTaxName()",
    "void TaxDetailImpl.setCountry(String)",
    "void TaxDetailImpl.setCurrency(BroadleafCurrency)",
    "void TaxDetailImpl.setId(Long)",
    "void TaxDetailImpl.setJurisdictionName(String)",
    "void TaxDetailImpl.setModuleConfiguration(ModuleConfiguration)",
    "void TaxDetailImpl.setRate(BigDecimal)",
    "void TaxDetailImpl.setRegion(String)",
    "void TaxDetailImpl.setTaxName(String)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    TaxDetailImpl actualTaxDetailImpl = new TaxDetailImpl();
    actualTaxDetailImpl.setCountry("GB");
    BroadleafCurrencyImpl currency = new BroadleafCurrencyImpl();
    actualTaxDetailImpl.setCurrency(currency);
    actualTaxDetailImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    actualTaxDetailImpl.setJurisdictionName("Jurisdiction");
    SiteMapConfigurationImpl config = new SiteMapConfigurationImpl();
    actualTaxDetailImpl.setModuleConfiguration(config);
    BigDecimal rate = new BigDecimal("2.3");
    actualTaxDetailImpl.setRate(rate);
    actualTaxDetailImpl.setRegion("us-east-2");
    actualTaxDetailImpl.setTaxName("Tax Name");
    String actualCountry = actualTaxDetailImpl.getCountry();
    BroadleafCurrency actualCurrency = actualTaxDetailImpl.getCurrency();
    Long actualId = actualTaxDetailImpl.getId();
    String actualJurisdictionName = actualTaxDetailImpl.getJurisdictionName();
    ModuleConfiguration actualModuleConfiguration = actualTaxDetailImpl.getModuleConfiguration();
    BigDecimal actualRate = actualTaxDetailImpl.getRate();
    String actualRegion = actualTaxDetailImpl.getRegion();

    // Assert
    assertEquals("GB", actualCountry);
    assertEquals("Jurisdiction", actualJurisdictionName);
    assertEquals("Tax Name", actualTaxDetailImpl.getTaxName());
    assertEquals("us-east-2", actualRegion);
    assertEquals(new BigDecimal("2.3"), actualRate);
    assertEquals(OrderItemQualifierImpl.serialVersionUID, actualId.longValue());
    assertSame(rate, actualRate);
    assertSame(currency, actualCurrency);
    assertSame(config, actualModuleConfiguration);
  }

  /**
   * Test {@link TaxDetailImpl#TaxDetailImpl(TaxType, Money, BigDecimal)}.
   *
   * <ul>
   *   <li>Given {@link BigDecimal#BigDecimal(String)} with {@code 2.3}.
   *   <li>Then return {@link TaxDetailImpl#amount} is {@link BigDecimal#BigDecimal(String)} with
   *       {@code 2.3}.
   * </ul>
   *
   * <p>Method under test: {@link TaxDetailImpl#TaxDetailImpl(TaxType, Money, BigDecimal)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TaxDetailImpl.<init>(TaxType, Money, BigDecimal)"})
  public void testNewTaxDetailImpl_givenBigDecimalWith23_thenReturnAmountIsBigDecimalWith23() {
    // Arrange
    TaxType type = mock(TaxType.class);
    when(type.getType()).thenReturn("Type");

    Money amount = mock(Money.class);
    when(amount.getAmount()).thenReturn(new BigDecimal("2.3"));

    // Act
    TaxDetailImpl actualTaxDetailImpl = new TaxDetailImpl(type, amount, new BigDecimal("2.3"));

    // Assert
    verify(amount).getAmount();
    verify(type).getType();
    assertEquals(new BigDecimal("2.3"), actualTaxDetailImpl.amount);
    Money amount2 = actualTaxDetailImpl.getAmount();
    assertEquals(new BigDecimal("2.30"), amount2.getAmount());
    Money actualAbsResult = amount2.abs();
    assertEquals(amount2, actualAbsResult);
    assertEquals(Money.ZERO, amount2.zero());
  }

  /**
   * Test {@link TaxDetailImpl#TaxDetailImpl(TaxType, Money, BigDecimal)}.
   *
   * <ul>
   *   <li>Given {@code Type}.
   *   <li>Then return Amount abs abs Amount is {@link TaxDetailImpl#amount}.
   * </ul>
   *
   * <p>Method under test: {@link TaxDetailImpl#TaxDetailImpl(TaxType, Money, BigDecimal)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TaxDetailImpl.<init>(TaxType, Money, BigDecimal)"})
  public void testNewTaxDetailImpl_givenType_thenReturnAmountAbsAbsAmountIsAmount() {
    // Arrange
    TaxType type = mock(TaxType.class);
    when(type.getType()).thenReturn("Type");
    Money amount = new Money();

    // Act
    TaxDetailImpl actualTaxDetailImpl = new TaxDetailImpl(type, amount, new BigDecimal("2.3"));

    // Assert
    verify(type).getType();
    BigDecimal bigDecimal = actualTaxDetailImpl.amount;
    Money amount2 = actualTaxDetailImpl.getAmount();
    Money absResult = amount2.abs();
    assertSame(bigDecimal, absResult.abs().getAmount());
    Money zeroResult = amount2.zero();
    assertSame(bigDecimal, zeroResult.abs().getAmount());
    assertSame(bigDecimal, absResult.getAmount());
    assertSame(bigDecimal, absResult.zero().getAmount());
    assertSame(bigDecimal, zeroResult.zero().getAmount());
    assertSame(bigDecimal, zeroResult.getAmount());
    assertSame(bigDecimal, amount2.getAmount());
  }

  /**
   * Test {@link TaxDetailImpl#TaxDetailImpl(TaxType, Money, BigDecimal)}.
   *
   * <ul>
   *   <li>When {@link TaxType#CITY}.
   *   <li>Then return {@link TaxDetailImpl#type} is {@code CITY}.
   * </ul>
   *
   * <p>Method under test: {@link TaxDetailImpl#TaxDetailImpl(TaxType, Money, BigDecimal)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TaxDetailImpl.<init>(TaxType, Money, BigDecimal)"})
  public void testNewTaxDetailImpl_whenCity_thenReturnTypeIsCity() {
    // Arrange
    Money amount = new Money();

    // Act
    TaxDetailImpl actualTaxDetailImpl =
        new TaxDetailImpl(TaxType.CITY, amount, new BigDecimal("2.3"));

    // Assert
    assertEquals("CITY", actualTaxDetailImpl.type);
    BigDecimal bigDecimal = actualTaxDetailImpl.amount;
    Money amount2 = actualTaxDetailImpl.getAmount();
    assertSame(bigDecimal, amount2.abs().getAmount());
    assertSame(bigDecimal, amount2.zero().getAmount());
    assertSame(bigDecimal, amount2.getAmount());
    assertSame(TaxType.CITY, actualTaxDetailImpl.getType());
  }

  /**
   * Test {@link TaxDetailImpl#getType()}.
   *
   * <p>Method under test: {@link TaxDetailImpl#getType()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"TaxType TaxDetailImpl.getType()"})
  public void testGetType() {
    // Arrange, Act and Assert
    assertNull(taxDetailImpl.getType());
  }

  /**
   * Test {@link TaxDetailImpl#setType(TaxType)}.
   *
   * <ul>
   *   <li>When {@link TaxType#CITY}.
   *   <li>Then {@link TaxDetailImpl} {@link TaxDetailImpl#type} is {@code CITY}.
   * </ul>
   *
   * <p>Method under test: {@link TaxDetailImpl#setType(TaxType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TaxDetailImpl.setType(TaxType)"})
  public void testSetType_whenCity_thenTaxDetailImplTypeIsCity() {
    // Arrange and Act
    taxDetailImpl.setType(TaxType.CITY);

    // Assert
    assertEquals("CITY", taxDetailImpl.type);
    assertSame(TaxType.CITY, taxDetailImpl.getType());
  }

  /**
   * Test {@link TaxDetailImpl#getAmount()}.
   *
   * <ul>
   *   <li>Given {@link TaxDetailImpl} Currency is {@code null}.
   *   <li>Then return {@link Money#Money()}.
   * </ul>
   *
   * <p>Method under test: {@link TaxDetailImpl#getAmount()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money TaxDetailImpl.getAmount()"})
  public void testGetAmount_givenTaxDetailImplCurrencyIsNull_thenReturnMoney() {
    // Arrange
    Money amount = new Money();
    taxDetailImpl.setAmount(amount);
    taxDetailImpl.setCurrency(null);

    // Act and Assert
    assertEquals(amount, taxDetailImpl.getAmount());
  }

  /**
   * Test {@link TaxDetailImpl#getAmount()}.
   *
   * <ul>
   *   <li>Given {@link TaxDetailImpl}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TaxDetailImpl#getAmount()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money TaxDetailImpl.getAmount()"})
  public void testGetAmount_givenTaxDetailImpl_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(taxDetailImpl.getAmount());
  }

  /**
   * Test {@link TaxDetailImpl#getAmount()}.
   *
   * <ul>
   *   <li>Then return Currency DisplayName is {@code British Pound}.
   * </ul>
   *
   * <p>Method under test: {@link TaxDetailImpl#getAmount()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money TaxDetailImpl.getAmount()"})
  public void testGetAmount_thenReturnCurrencyDisplayNameIsBritishPound() {
    // Arrange
    BroadleafCurrency currency = mock(BroadleafCurrency.class);
    when(currency.getCurrencyCode()).thenReturn("GBP");
    taxDetailImpl.setAmount(new Money());
    taxDetailImpl.setCurrency(currency);

    // Act
    Money actualAmount = taxDetailImpl.getAmount();

    // Assert
    verify(currency).getCurrencyCode();
    Currency currency2 = actualAmount.getCurrency();
    assertEquals("British Pound", currency2.getDisplayName());
    assertEquals("GBP", currency2.getCurrencyCode());
    assertEquals("GBP", currency2.toString());
    assertEquals("£", currency2.getSymbol());
    assertEquals(826, currency2.getNumericCode());
    Money actualAbsResult = actualAmount.abs();
    assertEquals(actualAmount, actualAbsResult);
    Money actualZeroResult = actualAmount.zero();
    assertEquals(actualAmount, actualZeroResult);
  }

  /**
   * Test {@link TaxDetailImpl#setAmount(Money)}.
   *
   * <ul>
   *   <li>Then {@link TaxDetailImpl} Amount Currency Symbol is {@code $}.
   * </ul>
   *
   * <p>Method under test: {@link TaxDetailImpl#setAmount(Money)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TaxDetailImpl.setAmount(Money)"})
  public void testSetAmount_thenTaxDetailImplAmountCurrencySymbolIsDollarSign() {
    // Arrange
    Money amount = mock(Money.class);
    when(amount.getAmount()).thenReturn(new BigDecimal("2.3"));

    // Act
    taxDetailImpl.setAmount(amount);

    // Assert
    verify(amount).getAmount();
    Money amount2 = taxDetailImpl.getAmount();
    Currency currency = amount2.getCurrency();
    assertEquals("$", currency.getSymbol());
    assertEquals("US Dollar", currency.getDisplayName());
    assertEquals("USD", currency.getCurrencyCode());
    assertEquals("USD", currency.toString());
    assertEquals(2, currency.getDefaultFractionDigits());
    assertEquals(840, currency.getNumericCode());
    assertEquals(new BigDecimal("2.3"), taxDetailImpl.amount);
    assertEquals(new BigDecimal("2.30"), amount2.getAmount());
    Money actualAbsResult = amount2.abs();
    assertEquals(amount2, actualAbsResult);
    assertEquals(Money.ZERO, amount2.zero());
  }

  /**
   * Test {@link TaxDetailImpl#setAmount(Money)}.
   *
   * <ul>
   *   <li>When {@link Money#Money()}.
   *   <li>Then {@link TaxDetailImpl} {@link TaxDetailImpl#amount} is {@link
   *       BigDecimal#BigDecimal(String)} with {@code 0.00}.
   * </ul>
   *
   * <p>Method under test: {@link TaxDetailImpl#setAmount(Money)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TaxDetailImpl.setAmount(Money)"})
  public void testSetAmount_whenMoney_thenTaxDetailImplAmountIsBigDecimalWith000() {
    // Arrange
    Money amount = new Money();

    // Act
    taxDetailImpl.setAmount(amount);

    // Assert
    assertEquals(new BigDecimal("0.00"), taxDetailImpl.amount);
    BigDecimal bigDecimal = taxDetailImpl.amount;
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
   * Test {@link TaxDetailImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   *
   * <p>Method under test: {@link
   * TaxDetailImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CreateResponse TaxDetailImpl.createOrRetrieveCopyInstance(MultiTenantCopyContext)"
  })
  public void testCreateOrRetrieveCopyInstance() throws CloneNotSupportedException {
    // Arrange
    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    CreateResponse<Object> createResponse = new CreateResponse<>(new TaxDetailImpl(), true);
    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<TaxDetail> actualCreateOrRetrieveCopyInstanceResult =
        taxDetailImpl.createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
  }
}
