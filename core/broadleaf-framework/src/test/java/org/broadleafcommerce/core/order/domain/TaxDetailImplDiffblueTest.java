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
import org.mockito.Mockito;

public class TaxDetailImplDiffblueTest {
  /**
   * Method under test: {@link TaxDetailImpl#getType()}
   */
  @Test
  public void testGetType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new TaxDetailImpl()).getType());
  }

  /**
   * Method under test: {@link TaxDetailImpl#setType(TaxType)}
   */
  @Test
  public void testSetType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TaxDetailImpl taxDetailImpl = new TaxDetailImpl();
    TaxType type = TaxType.CITY;

    // Act
    taxDetailImpl.setType(type);

    // Assert
    assertEquals("CITY", taxDetailImpl.type);
    TaxType expectedType = type.CITY;
    assertSame(expectedType, taxDetailImpl.getType());
  }

  /**
   * Method under test: {@link TaxDetailImpl#getAmount()}
   */
  @Test
  public void testGetAmount() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new TaxDetailImpl()).getAmount());
  }

  /**
   * Method under test: {@link TaxDetailImpl#getAmount()}
   */
  @Test
  public void testGetAmount2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TaxDetailImpl taxDetailImpl = new TaxDetailImpl();
    taxDetailImpl.setCountry("GB");
    taxDetailImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    taxDetailImpl.setJurisdictionName("Jurisdiction");
    taxDetailImpl.setModuleConfiguration(new SiteMapConfigurationImpl());
    taxDetailImpl.setRate(new BigDecimal("2.3"));
    taxDetailImpl.setRegion("us-east-2");
    taxDetailImpl.setTaxName("Tax Name");
    taxDetailImpl.setType(TaxType.CITY);
    Money amount = new Money();
    taxDetailImpl.setAmount(amount);
    taxDetailImpl.setCurrency(null);

    // Act and Assert
    assertEquals(amount, taxDetailImpl.getAmount());
  }

  /**
   * Method under test: {@link TaxDetailImpl#getAmount()}
   */
  @Test
  public void testGetAmount3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TaxDetailImpl taxDetailImpl = new TaxDetailImpl();
    taxDetailImpl.setCountry("GB");
    taxDetailImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    taxDetailImpl.setJurisdictionName("Jurisdiction");
    taxDetailImpl.setModuleConfiguration(mock(ModuleConfiguration.class));
    taxDetailImpl.setRate(new BigDecimal("2.3"));
    taxDetailImpl.setRegion("us-east-2");
    taxDetailImpl.setTaxName("Tax Name");
    taxDetailImpl.setType(TaxType.CITY);
    Money amount = new Money();
    taxDetailImpl.setAmount(amount);
    taxDetailImpl.setCurrency(null);

    // Act and Assert
    assertEquals(amount, taxDetailImpl.getAmount());
  }

  /**
   * Method under test: {@link TaxDetailImpl#getAmount()}
   */
  @Test
  public void testGetAmount4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Money amount = mock(Money.class);
    when(amount.getAmount()).thenReturn(new BigDecimal("2.3"));

    TaxDetailImpl taxDetailImpl = new TaxDetailImpl();
    taxDetailImpl.setCountry("GB");
    taxDetailImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    taxDetailImpl.setJurisdictionName("Jurisdiction");
    taxDetailImpl.setModuleConfiguration(new SiteMapConfigurationImpl());
    taxDetailImpl.setRate(new BigDecimal("2.3"));
    taxDetailImpl.setRegion("us-east-2");
    taxDetailImpl.setTaxName("Tax Name");
    taxDetailImpl.setType(TaxType.CITY);
    taxDetailImpl.setAmount(amount);
    taxDetailImpl.setCurrency(null);

    // Act
    Money actualAmount = taxDetailImpl.getAmount();

    // Assert
    verify(amount).getAmount();
    Currency currency = actualAmount.getCurrency();
    assertEquals("$", currency.getSymbol());
    assertEquals("US Dollar", currency.getDisplayName());
    assertEquals("USD", currency.getCurrencyCode());
    assertEquals("USD", currency.toString());
    assertEquals(2, currency.getDefaultFractionDigits());
    assertEquals(840, currency.getNumericCode());
    BigDecimal expectedAmount = new BigDecimal("2.30");
    assertEquals(expectedAmount, actualAmount.getAmount());
    assertEquals(actualAmount, actualAmount.abs());
    Money expectedZeroResult = actualAmount.ZERO;
    assertEquals(expectedZeroResult, actualAmount.zero());
  }

  /**
   * Method under test: {@link TaxDetailImpl#getAmount()}
   */
  @Test
  public void testGetAmount5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Money amount = mock(Money.class);
    when(amount.getAmount()).thenReturn(new BigDecimal("2.3"));
    BroadleafCurrency currency = mock(BroadleafCurrency.class);
    when(currency.getCurrencyCode()).thenReturn("GBP");

    TaxDetailImpl taxDetailImpl = new TaxDetailImpl();
    taxDetailImpl.setCountry("GB");
    taxDetailImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    taxDetailImpl.setJurisdictionName("Jurisdiction");
    taxDetailImpl.setModuleConfiguration(new SiteMapConfigurationImpl());
    taxDetailImpl.setRate(new BigDecimal("2.3"));
    taxDetailImpl.setRegion("us-east-2");
    taxDetailImpl.setTaxName("Tax Name");
    taxDetailImpl.setType(TaxType.CITY);
    taxDetailImpl.setAmount(amount);
    taxDetailImpl.setCurrency(currency);

    // Act
    Money actualAmount = taxDetailImpl.getAmount();

    // Assert
    verify(currency).getCurrencyCode();
    verify(amount).getAmount();
    Currency currency2 = actualAmount.getCurrency();
    assertEquals("British Pound", currency2.getDisplayName());
    assertEquals("GBP", currency2.getCurrencyCode());
    assertEquals("GBP", currency2.toString());
    assertEquals("£", currency2.getSymbol());
    assertEquals(2, currency2.getDefaultFractionDigits());
    assertEquals(826, currency2.getNumericCode());
    BigDecimal expectedAmount = new BigDecimal("0.00");
    Money zeroResult = actualAmount.zero();
    assertEquals(expectedAmount, zeroResult.getAmount());
    BigDecimal expectedAmount2 = new BigDecimal("2.30");
    assertEquals(expectedAmount2, actualAmount.getAmount());
    assertEquals(zeroResult.zero(), zeroResult.zero());
    assertEquals(zeroResult, zeroResult.abs());
    assertEquals(actualAmount, actualAmount.abs());
    assertSame(currency2, zeroResult.getCurrency());
  }

  /**
   * Method under test: {@link TaxDetailImpl#setAmount(Money)}
   */
  @Test
  public void testSetAmount() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TaxDetailImpl taxDetailImpl = new TaxDetailImpl();
    Money amount = new Money();

    // Act
    taxDetailImpl.setAmount(amount);

    // Assert
    BigDecimal expectedAmount = new BigDecimal("0.00");
    BigDecimal amount2 = amount.getAmount();
    assertEquals(expectedAmount, amount2);
    assertEquals(new BigDecimal("0.00"), taxDetailImpl.amount);
    assertEquals(amount, amount.abs());
    assertEquals(amount, amount.zero());
    assertSame(taxDetailImpl.amount, amount2);
  }

  /**
   * Method under test: {@link TaxDetailImpl#setAmount(Money)}
   */
  @Test
  public void testSetAmount2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TaxDetailImpl taxDetailImpl = new TaxDetailImpl();
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
    BigDecimal expectedAmount = new BigDecimal("2.30");
    assertEquals(expectedAmount, amount2.getAmount());
    assertEquals(amount2, amount2.abs());
    Money expectedZeroResult = amount.ZERO;
    assertEquals(expectedZeroResult, amount2.zero());
  }

  /**
   * Method under test:
   * {@link TaxDetailImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  public void testCreateOrRetrieveCopyInstance() throws CloneNotSupportedException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TaxDetailImpl taxDetailImpl = new TaxDetailImpl();
    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    CreateResponse<Object> createResponse = new CreateResponse<>("Clone", true);

    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<TaxDetail> actualCreateOrRetrieveCopyInstanceResult = taxDetailImpl
        .createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
  }

  /**
   * Methods under test:
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

    // Assert that nothing has changed
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
   * Method under test:
   * {@link TaxDetailImpl#TaxDetailImpl(TaxType, Money, BigDecimal)}
   */
  @Test
  public void testNewTaxDetailImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TaxType type = TaxType.CITY;
    Money amount = new Money();
    BigDecimal rate = new BigDecimal("2.3");

    // Act
    TaxDetailImpl actualTaxDetailImpl = new TaxDetailImpl(type, amount, rate);

    // Assert
    assertEquals("CITY", actualTaxDetailImpl.type);
    assertNull(actualTaxDetailImpl.getId());
    assertNull(actualTaxDetailImpl.getCountry());
    assertNull(actualTaxDetailImpl.getJurisdictionName());
    assertNull(actualTaxDetailImpl.getRegion());
    assertNull(actualTaxDetailImpl.getTaxName());
    assertNull(actualTaxDetailImpl.getModuleConfiguration());
    assertNull(actualTaxDetailImpl.getCurrency());
    assertEquals(new BigDecimal("0.00"), actualTaxDetailImpl.amount);
    BigDecimal expectedRate = new BigDecimal("2.3");
    BigDecimal rate2 = actualTaxDetailImpl.getRate();
    assertEquals(expectedRate, rate2);
    assertEquals(amount, actualTaxDetailImpl.getAmount());
    assertSame(rate, rate2);
    TaxType expectedType = type.CITY;
    assertSame(expectedType, actualTaxDetailImpl.getType());
  }
}
