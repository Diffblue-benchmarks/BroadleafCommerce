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
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
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
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class FixedPriceFulfillmentOptionImplDiffblueTest {
  @Autowired
  private FixedPriceFulfillmentOptionImpl fixedPriceFulfillmentOptionImpl;

  /**
   * Test {@link FixedPriceFulfillmentOptionImpl#getPrice()}.
   * <ul>
   *   <li>Given {@link FixedPriceFulfillmentOptionImpl} (default constructor) Currency is {@code null}.</li>
   *   <li>Then return {@link Money#Money()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FixedPriceFulfillmentOptionImpl#getPrice()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money FixedPriceFulfillmentOptionImpl.getPrice()"})
  public void testGetPrice_givenFixedPriceFulfillmentOptionImplCurrencyIsNull_thenReturnMoney() {
    // Arrange
    FixedPriceFulfillmentOptionImpl fixedPriceFulfillmentOptionImpl2 = new FixedPriceFulfillmentOptionImpl();
    fixedPriceFulfillmentOptionImpl2.setFulfillmentType(FulfillmentType.DIGITAL);
    fixedPriceFulfillmentOptionImpl2.setId(1L);
    fixedPriceFulfillmentOptionImpl2.setLongDescription("Long Description");
    fixedPriceFulfillmentOptionImpl2.setName("Name");
    fixedPriceFulfillmentOptionImpl2.setTaxCode("Tax Code");
    fixedPriceFulfillmentOptionImpl2.setTaxable(true);
    fixedPriceFulfillmentOptionImpl2.setUseFlatRates(true);
    Money price = new Money();
    fixedPriceFulfillmentOptionImpl2.setPrice(price);
    fixedPriceFulfillmentOptionImpl2.setCurrency(null);

    // Act and Assert
    assertEquals(price, fixedPriceFulfillmentOptionImpl2.getPrice());
  }

  /**
   * Test {@link FixedPriceFulfillmentOptionImpl#getPrice()}.
   * <ul>
   *   <li>Given {@link FixedPriceFulfillmentOptionImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FixedPriceFulfillmentOptionImpl#getPrice()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money FixedPriceFulfillmentOptionImpl.getPrice()"})
  public void testGetPrice_givenFixedPriceFulfillmentOptionImpl_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new FixedPriceFulfillmentOptionImpl()).getPrice());
  }

  /**
   * Test {@link FixedPriceFulfillmentOptionImpl#getPrice()}.
   * <ul>
   *   <li>Then return Currency DisplayName is {@code British Pound}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FixedPriceFulfillmentOptionImpl#getPrice()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money FixedPriceFulfillmentOptionImpl.getPrice()"})
  public void testGetPrice_thenReturnCurrencyDisplayNameIsBritishPound() {
    // Arrange
    BroadleafCurrency currency = mock(BroadleafCurrency.class);
    when(currency.getCurrencyCode()).thenReturn("GBP");

    FixedPriceFulfillmentOptionImpl fixedPriceFulfillmentOptionImpl2 = new FixedPriceFulfillmentOptionImpl();
    fixedPriceFulfillmentOptionImpl2.setFulfillmentType(FulfillmentType.DIGITAL);
    fixedPriceFulfillmentOptionImpl2.setId(1L);
    fixedPriceFulfillmentOptionImpl2.setLongDescription("Long Description");
    fixedPriceFulfillmentOptionImpl2.setName("Name");
    fixedPriceFulfillmentOptionImpl2.setTaxCode("Tax Code");
    fixedPriceFulfillmentOptionImpl2.setTaxable(true);
    fixedPriceFulfillmentOptionImpl2.setUseFlatRates(true);
    fixedPriceFulfillmentOptionImpl2.setPrice(new Money());
    fixedPriceFulfillmentOptionImpl2.setCurrency(currency);

    // Act
    Money actualPrice = fixedPriceFulfillmentOptionImpl2.getPrice();

    // Assert
    verify(currency).getCurrencyCode();
    Currency currency2 = actualPrice.getCurrency();
    assertEquals("British Pound", currency2.getDisplayName());
    assertEquals("GBP", currency2.getCurrencyCode());
    assertEquals("GBP", currency2.toString());
    assertEquals("£", currency2.getSymbol());
    assertEquals(826, currency2.getNumericCode());
    assertEquals(actualPrice, actualPrice.abs());
    assertEquals(actualPrice, actualPrice.zero());
  }

  /**
   * Test {@link FixedPriceFulfillmentOptionImpl#setPrice(Money)}.
   * <ul>
   *   <li>Then {@link FixedPriceFulfillmentOptionImpl} (default constructor) {@link FixedPriceFulfillmentOptionImpl#price} is {@link BigDecimal#BigDecimal(String)} with {@code 0.00}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FixedPriceFulfillmentOptionImpl#setPrice(Money)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FixedPriceFulfillmentOptionImpl.setPrice(Money)"})
  public void testSetPrice_thenFixedPriceFulfillmentOptionImplPriceIsBigDecimalWith000() {
    // Arrange
    FixedPriceFulfillmentOptionImpl fixedPriceFulfillmentOptionImpl2 = new FixedPriceFulfillmentOptionImpl();
    Money price = new Money();

    // Act
    fixedPriceFulfillmentOptionImpl2.setPrice(price);

    // Assert
    assertEquals(new BigDecimal("0.00"), fixedPriceFulfillmentOptionImpl2.price);
    BigDecimal bigDecimal = fixedPriceFulfillmentOptionImpl2.price;
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
   * <ul>
   *   <li>Then {@link FixedPriceFulfillmentOptionImpl} (default constructor) {@link FixedPriceFulfillmentOptionImpl#price} is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FixedPriceFulfillmentOptionImpl#setPrice(Money)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FixedPriceFulfillmentOptionImpl.setPrice(Money)"})
  public void testSetPrice_thenFixedPriceFulfillmentOptionImplPriceIsNull() {
    // Arrange
    FixedPriceFulfillmentOptionImpl fixedPriceFulfillmentOptionImpl2 = new FixedPriceFulfillmentOptionImpl();
    fixedPriceFulfillmentOptionImpl2.setCurrency(new BroadleafCurrencyImpl());
    fixedPriceFulfillmentOptionImpl2.setFulfillmentType(FulfillmentType.DIGITAL);
    fixedPriceFulfillmentOptionImpl2.setId(1L);
    fixedPriceFulfillmentOptionImpl2.setLongDescription("Long Description");
    fixedPriceFulfillmentOptionImpl2.setName("Name");
    fixedPriceFulfillmentOptionImpl2.setPrice(new Money());
    fixedPriceFulfillmentOptionImpl2.setTaxCode("Tax Code");
    fixedPriceFulfillmentOptionImpl2.setTaxable(true);
    fixedPriceFulfillmentOptionImpl2.setUseFlatRates(true);

    // Act
    fixedPriceFulfillmentOptionImpl2.setPrice(null);

    // Assert
    assertNull(fixedPriceFulfillmentOptionImpl2.price);
    assertNull(fixedPriceFulfillmentOptionImpl2.getPrice());
  }

  /**
   * Test {@link FixedPriceFulfillmentOptionImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link FixedPriceFulfillmentOptionImpl#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean FixedPriceFulfillmentOptionImpl.equals(Object)",
      "int FixedPriceFulfillmentOptionImpl.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    FixedPriceFulfillmentOptionImpl fixedPriceFulfillmentOptionImpl = new FixedPriceFulfillmentOptionImpl();
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

    FixedPriceFulfillmentOptionImpl fixedPriceFulfillmentOptionImpl2 = new FixedPriceFulfillmentOptionImpl();
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
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link FixedPriceFulfillmentOptionImpl#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean FixedPriceFulfillmentOptionImpl.equals(Object)",
      "int FixedPriceFulfillmentOptionImpl.hashCode()"})
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
   * Test {@link FixedPriceFulfillmentOptionImpl#equals(Object)}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link FixedPriceFulfillmentOptionImpl#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean FixedPriceFulfillmentOptionImpl.equals(Object)",
      "int FixedPriceFulfillmentOptionImpl.hashCode()"})
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
   * Test {@link FixedPriceFulfillmentOptionImpl#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link FixedPriceFulfillmentOptionImpl#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean FixedPriceFulfillmentOptionImpl.equals(Object)",
      "int FixedPriceFulfillmentOptionImpl.hashCode()"})
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
   * Test {@link FixedPriceFulfillmentOptionImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   * <p>
   * Method under test: {@link FixedPriceFulfillmentOptionImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "CreateResponse FixedPriceFulfillmentOptionImpl.createOrRetrieveCopyInstance(MultiTenantCopyContext)"})
  public void testCreateOrRetrieveCopyInstance() throws CloneNotSupportedException {
    // Arrange
    FixedPriceFulfillmentOptionImpl fixedPriceFulfillmentOptionImpl2 = new FixedPriceFulfillmentOptionImpl();
    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    CreateResponse<Object> createResponse = new CreateResponse<>("Clone", true);

    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<FixedPriceFulfillmentOption> actualCreateOrRetrieveCopyInstanceResult = fixedPriceFulfillmentOptionImpl2
        .createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
  }

  /**
   * Test {@link FixedPriceFulfillmentOptionImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   * <ul>
   *   <li>Then Clone return {@link FixedPriceFulfillmentOptionImpl}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FixedPriceFulfillmentOptionImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "CreateResponse FixedPriceFulfillmentOptionImpl.createOrRetrieveCopyInstance(MultiTenantCopyContext)"})
  public void testCreateOrRetrieveCopyInstance_thenCloneReturnFixedPriceFulfillmentOptionImpl()
      throws CloneNotSupportedException {
    // Arrange
    FixedPriceFulfillmentOptionImpl fixedPriceFulfillmentOptionImpl2 = new FixedPriceFulfillmentOptionImpl();
    GenericEntityService genericEntityService = mock(GenericEntityService.class);
    when(genericEntityService.getIdentifier(Mockito.<Object>any())).thenReturn(null);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(genericEntityService.getCeilingImplClass(Mockito.<String>any())).thenReturn(forNameResult);
    CatalogImpl fromCatalog = new CatalogImpl();
    CatalogImpl toCatalog = new CatalogImpl();
    SiteImpl fromSite = new SiteImpl();
    SiteImpl toSite = new SiteImpl();

    // Act
    CreateResponse<FixedPriceFulfillmentOption> actualCreateOrRetrieveCopyInstanceResult = fixedPriceFulfillmentOptionImpl2
        .createOrRetrieveCopyInstance(new MultiTenantCopyContext(fromCatalog, toCatalog, fromSite, toSite,
            genericEntityService, new MultiTenantCopierExtensionManager()));

    // Assert
    verify(genericEntityService)
        .getCeilingImplClass(eq("org.broadleafcommerce.core.order.fulfillment.domain.FixedPriceFulfillmentOptionImpl"));
    verify(genericEntityService).getIdentifier(isA(Object.class));
    FixedPriceFulfillmentOption clone = actualCreateOrRetrieveCopyInstanceResult.getClone();
    assertTrue(clone instanceof FixedPriceFulfillmentOptionImpl);
    assertFalse(actualCreateOrRetrieveCopyInstanceResult.isAlreadyPopulated());
    assertEquals(fixedPriceFulfillmentOptionImpl2, clone);
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link FixedPriceFulfillmentOptionImpl}
   *   <li>{@link FixedPriceFulfillmentOptionImpl#setCurrency(BroadleafCurrency)}
   *   <li>{@link FixedPriceFulfillmentOptionImpl#getCurrency()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FixedPriceFulfillmentOptionImpl.<init>()",
      "BroadleafCurrency FixedPriceFulfillmentOptionImpl.getCurrency()",
      "void FixedPriceFulfillmentOptionImpl.setCurrency(BroadleafCurrency)"})
  public void testGettersAndSetters() {
    // Arrange and Act
    FixedPriceFulfillmentOptionImpl actualFixedPriceFulfillmentOptionImpl = new FixedPriceFulfillmentOptionImpl();
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
