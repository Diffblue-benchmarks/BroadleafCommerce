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
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.math.BigDecimal;
import java.util.Currency;
import org.broadleafcommerce.common.copy.CreateResponse;
import org.broadleafcommerce.common.copy.MultiTenantCopierExtensionManager;
import org.broadleafcommerce.common.copy.MultiTenantCopyContext;
import org.broadleafcommerce.common.currency.domain.BroadleafCurrency;
import org.broadleafcommerce.common.currency.domain.BroadleafCurrencyImpl;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.common.service.GenericEntityService;
import org.broadleafcommerce.common.site.domain.CatalogImpl;
import org.broadleafcommerce.common.site.domain.SiteImpl;
import org.broadleafcommerce.core.order.service.type.FulfillmentType;
import org.junit.Test;
import org.mockito.Mockito;

public class FixedPriceFulfillmentOptionImplDiffblueTest {
  /**
   * Method under test: {@link FixedPriceFulfillmentOptionImpl#getPrice()}
   */
  @Test
  public void testGetPrice() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new FixedPriceFulfillmentOptionImpl()).getPrice());
  }

  /**
   * Method under test: {@link FixedPriceFulfillmentOptionImpl#getPrice()}
   */
  @Test
  public void testGetPrice2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FixedPriceFulfillmentOptionImpl fixedPriceFulfillmentOptionImpl = new FixedPriceFulfillmentOptionImpl();
    fixedPriceFulfillmentOptionImpl.setFulfillmentType(FulfillmentType.DIGITAL);
    fixedPriceFulfillmentOptionImpl.setId(1L);
    fixedPriceFulfillmentOptionImpl.setLongDescription("Long Description");
    fixedPriceFulfillmentOptionImpl.setName("Name");
    fixedPriceFulfillmentOptionImpl.setTaxCode("Tax Code");
    fixedPriceFulfillmentOptionImpl.setTaxable(true);
    fixedPriceFulfillmentOptionImpl.setUseFlatRates(true);
    Money price = new Money();
    fixedPriceFulfillmentOptionImpl.setPrice(price);
    fixedPriceFulfillmentOptionImpl.setCurrency(null);

    // Act and Assert
    assertEquals(price, fixedPriceFulfillmentOptionImpl.getPrice());
  }

  /**
   * Method under test: {@link FixedPriceFulfillmentOptionImpl#getPrice()}
   */
  @Test
  public void testGetPrice3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentType fulfillmentType = mock(FulfillmentType.class);
    when(fulfillmentType.getType()).thenReturn("Type");

    FixedPriceFulfillmentOptionImpl fixedPriceFulfillmentOptionImpl = new FixedPriceFulfillmentOptionImpl();
    fixedPriceFulfillmentOptionImpl.setFulfillmentType(fulfillmentType);
    fixedPriceFulfillmentOptionImpl.setId(1L);
    fixedPriceFulfillmentOptionImpl.setLongDescription("Long Description");
    fixedPriceFulfillmentOptionImpl.setName("Name");
    fixedPriceFulfillmentOptionImpl.setTaxCode("Tax Code");
    fixedPriceFulfillmentOptionImpl.setTaxable(true);
    fixedPriceFulfillmentOptionImpl.setUseFlatRates(true);
    Money price = new Money();
    fixedPriceFulfillmentOptionImpl.setPrice(price);
    fixedPriceFulfillmentOptionImpl.setCurrency(null);

    // Act
    Money actualPrice = fixedPriceFulfillmentOptionImpl.getPrice();

    // Assert
    verify(fulfillmentType).getType();
    assertEquals(price, actualPrice);
  }

  /**
   * Method under test: {@link FixedPriceFulfillmentOptionImpl#getPrice()}
   */
  @Test
  public void testGetPrice4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentType fulfillmentType = mock(FulfillmentType.class);
    when(fulfillmentType.getType()).thenReturn("Type");
    BroadleafCurrency currency = mock(BroadleafCurrency.class);
    when(currency.getCurrencyCode()).thenReturn("GBP");

    FixedPriceFulfillmentOptionImpl fixedPriceFulfillmentOptionImpl = new FixedPriceFulfillmentOptionImpl();
    fixedPriceFulfillmentOptionImpl.setFulfillmentType(fulfillmentType);
    fixedPriceFulfillmentOptionImpl.setId(1L);
    fixedPriceFulfillmentOptionImpl.setLongDescription("Long Description");
    fixedPriceFulfillmentOptionImpl.setName("Name");
    fixedPriceFulfillmentOptionImpl.setTaxCode("Tax Code");
    fixedPriceFulfillmentOptionImpl.setTaxable(true);
    fixedPriceFulfillmentOptionImpl.setUseFlatRates(true);
    fixedPriceFulfillmentOptionImpl.setPrice(new Money());
    fixedPriceFulfillmentOptionImpl.setCurrency(currency);

    // Act
    Money actualPrice = fixedPriceFulfillmentOptionImpl.getPrice();

    // Assert
    verify(currency).getCurrencyCode();
    verify(fulfillmentType).getType();
    Currency currency2 = actualPrice.getCurrency();
    assertEquals("British Pound", currency2.getDisplayName());
    assertEquals("GBP", currency2.getCurrencyCode());
    assertEquals("GBP", currency2.toString());
    assertEquals("£", currency2.getSymbol());
    assertEquals(2, currency2.getDefaultFractionDigits());
    assertEquals(826, currency2.getNumericCode());
    BigDecimal expectedAmount = new BigDecimal("0.00");
    BigDecimal amount = actualPrice.getAmount();
    assertEquals(expectedAmount, amount);
    assertEquals(actualPrice, actualPrice.abs());
    assertEquals(actualPrice, actualPrice.zero());
    assertSame(fixedPriceFulfillmentOptionImpl.price, amount);
  }

  /**
   * Method under test: {@link FixedPriceFulfillmentOptionImpl#setPrice(Money)}
   */
  @Test
  public void testSetPrice() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FixedPriceFulfillmentOptionImpl fixedPriceFulfillmentOptionImpl = new FixedPriceFulfillmentOptionImpl();
    Money price = new Money();

    // Act
    fixedPriceFulfillmentOptionImpl.setPrice(price);

    // Assert
    BigDecimal expectedAmount = new BigDecimal("0.00");
    BigDecimal amount = price.getAmount();
    assertEquals(expectedAmount, amount);
    assertEquals(new BigDecimal("0.00"), fixedPriceFulfillmentOptionImpl.price);
    assertEquals(price, price.abs());
    assertEquals(price, price.zero());
    assertSame(fixedPriceFulfillmentOptionImpl.price, amount);
  }

  /**
   * Method under test: {@link FixedPriceFulfillmentOptionImpl#setPrice(Money)}
   */
  @Test
  public void testSetPrice2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FixedPriceFulfillmentOptionImpl fixedPriceFulfillmentOptionImpl = new FixedPriceFulfillmentOptionImpl();
    fixedPriceFulfillmentOptionImpl.setCurrency(new BroadleafCurrencyImpl());
    fixedPriceFulfillmentOptionImpl.setFulfillmentType(FulfillmentType.DIGITAL);
    fixedPriceFulfillmentOptionImpl.setId(1L);
    fixedPriceFulfillmentOptionImpl.setLongDescription("Long Description");
    fixedPriceFulfillmentOptionImpl.setName("Name");
    fixedPriceFulfillmentOptionImpl.setPrice(new Money());
    fixedPriceFulfillmentOptionImpl.setTaxCode("Tax Code");
    fixedPriceFulfillmentOptionImpl.setTaxable(true);
    fixedPriceFulfillmentOptionImpl.setUseFlatRates(true);

    // Act
    fixedPriceFulfillmentOptionImpl.setPrice(null);

    // Assert
    assertNull(fixedPriceFulfillmentOptionImpl.price);
    assertNull(fixedPriceFulfillmentOptionImpl.getPrice());
  }

  /**
   * Method under test: {@link FixedPriceFulfillmentOptionImpl#setPrice(Money)}
   */
  @Test
  public void testSetPrice3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FixedPriceFulfillmentOptionImpl fixedPriceFulfillmentOptionImpl = new FixedPriceFulfillmentOptionImpl();

    // Act
    fixedPriceFulfillmentOptionImpl.setPrice(mock(Money.class));

    // Assert
    assertNull(fixedPriceFulfillmentOptionImpl.price);
    assertNull(fixedPriceFulfillmentOptionImpl.getPrice());
  }

  /**
   * Method under test:
   * {@link FixedPriceFulfillmentOptionImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  public void testCreateOrRetrieveCopyInstance() throws CloneNotSupportedException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FixedPriceFulfillmentOptionImpl fixedPriceFulfillmentOptionImpl = new FixedPriceFulfillmentOptionImpl();
    GenericEntityService genericEntityService = mock(GenericEntityService.class);
    when(genericEntityService.getIdentifier(Mockito.<Object>any())).thenReturn(null);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(genericEntityService.getCeilingImplClass(Mockito.<String>any())).thenReturn(forNameResult);
    CatalogImpl fromCatalog = new CatalogImpl();
    CatalogImpl toCatalog = new CatalogImpl();
    SiteImpl fromSite = new SiteImpl();
    SiteImpl toSite = new SiteImpl();

    // Act
    CreateResponse<FixedPriceFulfillmentOption> actualCreateOrRetrieveCopyInstanceResult = fixedPriceFulfillmentOptionImpl
        .createOrRetrieveCopyInstance(new MultiTenantCopyContext(fromCatalog, toCatalog, fromSite, toSite,
            genericEntityService, new MultiTenantCopierExtensionManager()));

    // Assert
    verify(genericEntityService)
        .getCeilingImplClass(eq("org.broadleafcommerce.core.order.fulfillment.domain.FixedPriceFulfillmentOptionImpl"));
    verify(genericEntityService).getIdentifier(isA(Object.class));
    FixedPriceFulfillmentOption clone = actualCreateOrRetrieveCopyInstanceResult.getClone();
    assertTrue(clone instanceof FixedPriceFulfillmentOptionImpl);
    assertFalse(actualCreateOrRetrieveCopyInstanceResult.isAlreadyPopulated());
    assertEquals(fixedPriceFulfillmentOptionImpl, clone);
  }

  /**
   * Method under test:
   * {@link FixedPriceFulfillmentOptionImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  public void testCreateOrRetrieveCopyInstance2() throws CloneNotSupportedException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FixedPriceFulfillmentOptionImpl fixedPriceFulfillmentOptionImpl = new FixedPriceFulfillmentOptionImpl();
    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    CreateResponse<Object> createResponse = new CreateResponse<>("Clone", true);

    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<FixedPriceFulfillmentOption> actualCreateOrRetrieveCopyInstanceResult = fixedPriceFulfillmentOptionImpl
        .createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
  }

  /**
   * Method under test: {@link FixedPriceFulfillmentOptionImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    BroadleafCurrencyImpl currency = mock(BroadleafCurrencyImpl.class);
    when(currency.getCurrencyCode()).thenReturn("GBP");

    FixedPriceFulfillmentOptionImpl fixedPriceFulfillmentOptionImpl = new FixedPriceFulfillmentOptionImpl();
    fixedPriceFulfillmentOptionImpl.setCurrency(currency);
    fixedPriceFulfillmentOptionImpl.setFulfillmentType(FulfillmentType.DIGITAL);
    fixedPriceFulfillmentOptionImpl.setId(1L);
    fixedPriceFulfillmentOptionImpl.setLongDescription("Long Description");
    fixedPriceFulfillmentOptionImpl.setName("Name");
    fixedPriceFulfillmentOptionImpl.setPrice(new Money());
    fixedPriceFulfillmentOptionImpl.setTaxCode("Tax Code");
    fixedPriceFulfillmentOptionImpl.setTaxable(true);
    fixedPriceFulfillmentOptionImpl.setUseFlatRates(true);
    BroadleafCurrency currency2 = mock(BroadleafCurrency.class);
    when(currency2.getCurrencyCode()).thenReturn("GBP");

    FixedPriceFulfillmentOptionImpl fixedPriceFulfillmentOptionImpl2 = new FixedPriceFulfillmentOptionImpl();
    fixedPriceFulfillmentOptionImpl2.setCurrency(currency2);
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
   * Method under test: {@link FixedPriceFulfillmentOptionImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    FixedPriceFulfillmentOptionImpl fixedPriceFulfillmentOptionImpl = new FixedPriceFulfillmentOptionImpl();
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
   * Method under test: {@link FixedPriceFulfillmentOptionImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    FixedPriceFulfillmentOptionImpl fixedPriceFulfillmentOptionImpl = new FixedPriceFulfillmentOptionImpl();
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
   * Method under test: {@link FixedPriceFulfillmentOptionImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    FixedPriceFulfillmentOptionImpl fixedPriceFulfillmentOptionImpl = new FixedPriceFulfillmentOptionImpl();
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
    assertNotEquals(fixedPriceFulfillmentOptionImpl, "Different type to FixedPriceFulfillmentOptionImpl");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link FixedPriceFulfillmentOptionImpl}
   *   <li>{@link FixedPriceFulfillmentOptionImpl#setCurrency(BroadleafCurrency)}
   *   <li>{@link FixedPriceFulfillmentOptionImpl#getCurrency()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    FixedPriceFulfillmentOptionImpl actualFixedPriceFulfillmentOptionImpl = new FixedPriceFulfillmentOptionImpl();
    BroadleafCurrencyImpl currency = new BroadleafCurrencyImpl();
    actualFixedPriceFulfillmentOptionImpl.setCurrency(currency);
    BroadleafCurrency actualCurrency = actualFixedPriceFulfillmentOptionImpl.getCurrency();

    // Assert that nothing has changed
    assertFalse(actualFixedPriceFulfillmentOptionImpl.getTaxable());
    assertTrue(actualFixedPriceFulfillmentOptionImpl.getUseFlatRates());
    assertSame(currency, actualCurrency);
  }
}
