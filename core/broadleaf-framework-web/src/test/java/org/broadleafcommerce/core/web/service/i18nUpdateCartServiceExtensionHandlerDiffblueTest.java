/*-
 * #%L
 * BroadleafCommerce Framework Web
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
package org.broadleafcommerce.core.web.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import org.broadleafcommerce.common.audit.Auditable;
import org.broadleafcommerce.common.currency.domain.BroadleafCurrencyImpl;
import org.broadleafcommerce.common.extension.ExtensionResultHolder;
import org.broadleafcommerce.common.extension.ExtensionResultStatusType;
import org.broadleafcommerce.common.locale.domain.LocaleImpl;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.core.catalog.domain.ProductOptionImpl;
import org.broadleafcommerce.core.catalog.domain.ProductOptionValue;
import org.broadleafcommerce.core.catalog.domain.ProductOptionValueImpl;
import org.broadleafcommerce.core.catalog.domain.Sku;
import org.broadleafcommerce.core.catalog.domain.SkuImpl;
import org.broadleafcommerce.core.order.domain.BundleOrderItemImpl;
import org.broadleafcommerce.core.order.domain.DiscreteOrderItem;
import org.broadleafcommerce.core.order.domain.DiscreteOrderItemImpl;
import org.broadleafcommerce.core.order.domain.GiftWrapOrderItemImpl;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.Order;
import org.broadleafcommerce.core.order.domain.OrderImpl;
import org.broadleafcommerce.core.order.domain.OrderItem;
import org.broadleafcommerce.core.order.domain.PersonalMessageImpl;
import org.broadleafcommerce.core.order.service.type.OrderItemType;
import org.broadleafcommerce.core.order.service.type.OrderStatus;
import org.broadleafcommerce.profile.core.domain.CustomerImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class i18nUpdateCartServiceExtensionHandlerDiffblueTest {
  /**
   * Test
   * {@link i18nUpdateCartServiceExtensionHandler#updateAndValidateCart(Order, ExtensionResultHolder)}.
   * <ul>
   *   <li>Given {@link Auditable} (default constructor) CreatedBy is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link i18nUpdateCartServiceExtensionHandler#updateAndValidateCart(Order, ExtensionResultHolder)}
   */
  @Test
  @DisplayName("Test updateAndValidateCart(Order, ExtensionResultHolder); given Auditable (default constructor) CreatedBy is one")
  void testUpdateAndValidateCart_givenAuditableCreatedByIsOne() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    i18nUpdateCartServiceExtensionHandler i18nUpdateCartServiceExtensionHandler = new i18nUpdateCartServiceExtensionHandler();

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(1L);
    auditable2.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(1L);

    BundleOrderItemImpl bundleOrderItemImpl = new BundleOrderItemImpl();
    bundleOrderItemImpl.setAuditable(auditable2);
    bundleOrderItemImpl.setBaseRetailPrice(new Money());
    bundleOrderItemImpl.setBaseSalePrice(new Money());
    bundleOrderItemImpl.setBundleOrderItemFeePrices(new ArrayList<>());
    bundleOrderItemImpl.setCandidateItemOffers(new ArrayList<>());
    bundleOrderItemImpl.setCartMessages(new ArrayList<>());
    bundleOrderItemImpl.setChildOrderItems(new ArrayList<>());
    bundleOrderItemImpl.setDiscountingAllowed(true);
    bundleOrderItemImpl.setDiscreteOrderItems(new ArrayList<>());
    bundleOrderItemImpl.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    bundleOrderItemImpl.setHasValidationError(true);
    bundleOrderItemImpl.setId(1L);
    bundleOrderItemImpl.setName("Name");
    bundleOrderItemImpl.setOrder(new NullOrderImpl());
    bundleOrderItemImpl.setOrderItemAdjustments(new ArrayList<>());
    bundleOrderItemImpl.setOrderItemPriceDetails(new ArrayList<>());
    bundleOrderItemImpl.setOrderItemQualifiers(new ArrayList<>());
    bundleOrderItemImpl.setOrderItemType(new OrderItemType("Type", "Friendly Type"));
    bundleOrderItemImpl.setParentOrderItem(new BundleOrderItemImpl());
    bundleOrderItemImpl.setPersonalMessage(new PersonalMessageImpl());
    bundleOrderItemImpl.setProratedOrderItemAdjustments(new ArrayList<>());
    bundleOrderItemImpl.setQuantity(1);
    bundleOrderItemImpl.setRetailPrice(new Money());
    bundleOrderItemImpl.setRetailPriceOverride(true);
    bundleOrderItemImpl.setSalePrice(new Money());
    bundleOrderItemImpl.setSalePriceOverride(true);
    bundleOrderItemImpl.setTaxable(true);
    bundleOrderItemImpl.updateSaleAndRetailPrices();
    bundleOrderItemImpl.setOrderItemAttributes(new HashMap<>());

    ArrayList<OrderItem> orderItems = new ArrayList<>();
    orderItems.add(bundleOrderItemImpl);

    LocaleImpl locale = new LocaleImpl();
    locale.setDefaultCurrency(new BroadleafCurrencyImpl());
    locale.setDefaultFlag(true);
    locale.setFriendlyName("en");
    locale.setUseCountryInSearchIndex(true);
    locale.setLocaleCode(null);

    OrderImpl cart = new OrderImpl();
    cart.setAdditionalOfferInformation(new HashMap<>());
    cart.setAuditable(auditable);
    cart.setCandidateOrderOffers(new ArrayList<>());
    cart.setCurrency(new BroadleafCurrencyImpl());
    cart.setCustomer(new CustomerImpl());
    cart.setEmailAddress("42 Main St");
    cart.setFulfillmentGroups(new ArrayList<>());
    cart.setId(1L);
    cart.setName("Name");
    cart.setOrderAttributes(new HashMap<>());
    cart.setOrderMessages(new ArrayList<>());
    cart.setOrderNumber("42");
    cart.setPayments(new ArrayList<>());
    cart.setStatus(new OrderStatus("Type", "Friendly Type"));
    cart.setSubTotal(new Money());
    cart.setSubmitDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    cart.setTaxOverride(true);
    cart.setTotal(new Money());
    cart.setTotalFulfillmentCharges(new Money());
    cart.setTotalShipping(new Money());
    cart.setTotalTax(new Money());
    cart.setOrderItems(orderItems);
    cart.setLocale(locale);

    ExtensionResultHolder resultHolder = new ExtensionResultHolder();
    resultHolder.setResult("Result");
    resultHolder.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.HANDLED_CONTINUE,
        i18nUpdateCartServiceExtensionHandler.updateAndValidateCart(cart, resultHolder));
  }

  /**
   * Test
   * {@link i18nUpdateCartServiceExtensionHandler#updateAndValidateCart(Order, ExtensionResultHolder)}.
   * <ul>
   *   <li>When {@link NullOrderImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link i18nUpdateCartServiceExtensionHandler#updateAndValidateCart(Order, ExtensionResultHolder)}
   */
  @Test
  @DisplayName("Test updateAndValidateCart(Order, ExtensionResultHolder); when NullOrderImpl (default constructor)")
  void testUpdateAndValidateCart_whenNullOrderImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    i18nUpdateCartServiceExtensionHandler i18nUpdateCartServiceExtensionHandler = new i18nUpdateCartServiceExtensionHandler();
    NullOrderImpl cart = new NullOrderImpl();

    ExtensionResultHolder resultHolder = new ExtensionResultHolder();
    resultHolder.setResult("Result");
    resultHolder.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.HANDLED_CONTINUE,
        i18nUpdateCartServiceExtensionHandler.updateAndValidateCart(cart, resultHolder));
  }

  /**
   * Test
   * {@link i18nUpdateCartServiceExtensionHandler#updateAndValidateCart(Order, ExtensionResultHolder)}.
   * <ul>
   *   <li>When {@link Order}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link i18nUpdateCartServiceExtensionHandler#updateAndValidateCart(Order, ExtensionResultHolder)}
   */
  @Test
  @DisplayName("Test updateAndValidateCart(Order, ExtensionResultHolder); when Order")
  void testUpdateAndValidateCart_whenOrder() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    i18nUpdateCartServiceExtensionHandler i18nUpdateCartServiceExtensionHandler = new i18nUpdateCartServiceExtensionHandler();
    Order cart = mock(Order.class);

    ExtensionResultHolder resultHolder = new ExtensionResultHolder();
    resultHolder.setResult("Result");
    resultHolder.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.HANDLED_CONTINUE,
        i18nUpdateCartServiceExtensionHandler.updateAndValidateCart(cart, resultHolder));
  }

  /**
   * Test {@link i18nUpdateCartServiceExtensionHandler#fixTranslations(Order)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link DiscreteOrderItemImpl}
   * (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link i18nUpdateCartServiceExtensionHandler#fixTranslations(Order)}
   */
  @Test
  @DisplayName("Test fixTranslations(Order); given ArrayList() add DiscreteOrderItemImpl (default constructor)")
  void testFixTranslations_givenArrayListAddDiscreteOrderItemImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    i18nUpdateCartServiceExtensionHandler i18nUpdateCartServiceExtensionHandler = new i18nUpdateCartServiceExtensionHandler();

    ArrayList<DiscreteOrderItem> discreteOrderItemList = new ArrayList<>();
    discreteOrderItemList.add(new DiscreteOrderItemImpl());
    NullOrderImpl cart = mock(NullOrderImpl.class);
    when(cart.getDiscreteOrderItems()).thenReturn(discreteOrderItemList);
    when(cart.getOrderItems()).thenReturn(new ArrayList<>());

    // Act
    i18nUpdateCartServiceExtensionHandler.fixTranslations(cart);

    // Assert
    verify(cart).getDiscreteOrderItems();
    verify(cart).getOrderItems();
  }

  /**
   * Test {@link i18nUpdateCartServiceExtensionHandler#fixTranslations(Order)}.
   * <ul>
   *   <li>Given {@link DiscreteOrderItemImpl}
   * {@link DiscreteOrderItemImpl#getSku()} return {@link SkuImpl} (default
   * constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link i18nUpdateCartServiceExtensionHandler#fixTranslations(Order)}
   */
  @Test
  @DisplayName("Test fixTranslations(Order); given DiscreteOrderItemImpl getSku() return SkuImpl (default constructor)")
  void testFixTranslations_givenDiscreteOrderItemImplGetSkuReturnSkuImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    i18nUpdateCartServiceExtensionHandler i18nUpdateCartServiceExtensionHandler = new i18nUpdateCartServiceExtensionHandler();
    DiscreteOrderItemImpl discreteOrderItemImpl = mock(DiscreteOrderItemImpl.class);
    doNothing().when(discreteOrderItemImpl).setName(Mockito.<String>any());
    when(discreteOrderItemImpl.getSku()).thenReturn(new SkuImpl());

    ArrayList<DiscreteOrderItem> discreteOrderItemList = new ArrayList<>();
    discreteOrderItemList.add(discreteOrderItemImpl);
    NullOrderImpl cart = mock(NullOrderImpl.class);
    when(cart.getDiscreteOrderItems()).thenReturn(discreteOrderItemList);
    when(cart.getOrderItems()).thenReturn(new ArrayList<>());

    // Act
    i18nUpdateCartServiceExtensionHandler.fixTranslations(cart);

    // Assert
    verify(discreteOrderItemImpl).getSku();
    verify(cart).getDiscreteOrderItems();
    verify(cart).getOrderItems();
    verify(discreteOrderItemImpl).setName(isNull());
  }

  /**
   * Test {@link i18nUpdateCartServiceExtensionHandler#fixTranslations(Order)}.
   * <ul>
   *   <li>Given {@link SkuImpl} {@link SkuImpl#getName()} return {@code Name}.</li>
   *   <li>Then calls {@link SkuImpl#getName()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link i18nUpdateCartServiceExtensionHandler#fixTranslations(Order)}
   */
  @Test
  @DisplayName("Test fixTranslations(Order); given SkuImpl getName() return 'Name'; then calls getName()")
  void testFixTranslations_givenSkuImplGetNameReturnName_thenCallsGetName() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    i18nUpdateCartServiceExtensionHandler i18nUpdateCartServiceExtensionHandler = new i18nUpdateCartServiceExtensionHandler();
    SkuImpl skuImpl = mock(SkuImpl.class);
    when(skuImpl.getName()).thenReturn("Name");
    when(skuImpl.getProductOptionValues()).thenReturn(new ArrayList<>());
    DiscreteOrderItemImpl discreteOrderItemImpl = mock(DiscreteOrderItemImpl.class);
    doNothing().when(discreteOrderItemImpl).setName(Mockito.<String>any());
    when(discreteOrderItemImpl.getSku()).thenReturn(skuImpl);

    ArrayList<DiscreteOrderItem> discreteOrderItemList = new ArrayList<>();
    discreteOrderItemList.add(discreteOrderItemImpl);
    NullOrderImpl cart = mock(NullOrderImpl.class);
    when(cart.getDiscreteOrderItems()).thenReturn(discreteOrderItemList);
    when(cart.getOrderItems()).thenReturn(new ArrayList<>());

    // Act
    i18nUpdateCartServiceExtensionHandler.fixTranslations(cart);

    // Assert
    verify(skuImpl).getName();
    verify(skuImpl, atLeast(1)).getProductOptionValues();
    verify(discreteOrderItemImpl).getSku();
    verify(cart).getDiscreteOrderItems();
    verify(cart).getOrderItems();
    verify(discreteOrderItemImpl).setName(eq("Name"));
  }

  /**
   * Test {@link i18nUpdateCartServiceExtensionHandler#fixTranslations(Order)}.
   * <ul>
   *   <li>Then calls {@link ProductOptionValueImpl#getAttributeValue()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link i18nUpdateCartServiceExtensionHandler#fixTranslations(Order)}
   */
  @Test
  @DisplayName("Test fixTranslations(Order); then calls getAttributeValue()")
  void testFixTranslations_thenCallsGetAttributeValue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    i18nUpdateCartServiceExtensionHandler i18nUpdateCartServiceExtensionHandler = new i18nUpdateCartServiceExtensionHandler();
    ProductOptionValueImpl productOptionValueImpl = mock(ProductOptionValueImpl.class);
    when(productOptionValueImpl.getAttributeValue()).thenReturn("42");
    when(productOptionValueImpl.getProductOption()).thenReturn(new ProductOptionImpl());

    ArrayList<ProductOptionValue> productOptionValueList = new ArrayList<>();
    productOptionValueList.add(productOptionValueImpl);
    SkuImpl skuImpl = mock(SkuImpl.class);
    when(skuImpl.getName()).thenReturn("Name");
    when(skuImpl.getProductOptionValues()).thenReturn(productOptionValueList);
    DiscreteOrderItemImpl discreteOrderItemImpl = mock(DiscreteOrderItemImpl.class);
    when(discreteOrderItemImpl.getOrderItemAttributes()).thenReturn(new HashMap<>());
    doNothing().when(discreteOrderItemImpl).setName(Mockito.<String>any());
    when(discreteOrderItemImpl.getSku()).thenReturn(skuImpl);

    ArrayList<DiscreteOrderItem> discreteOrderItemList = new ArrayList<>();
    discreteOrderItemList.add(discreteOrderItemImpl);
    NullOrderImpl cart = mock(NullOrderImpl.class);
    when(cart.getDiscreteOrderItems()).thenReturn(discreteOrderItemList);
    when(cart.getOrderItems()).thenReturn(new ArrayList<>());

    // Act
    i18nUpdateCartServiceExtensionHandler.fixTranslations(cart);

    // Assert
    verify(productOptionValueImpl).getAttributeValue();
    verify(productOptionValueImpl).getProductOption();
    verify(skuImpl).getName();
    verify(skuImpl, atLeast(1)).getProductOptionValues();
    verify(discreteOrderItemImpl).getSku();
    verify(cart).getDiscreteOrderItems();
    verify(cart).getOrderItems();
    verify(discreteOrderItemImpl, atLeast(1)).getOrderItemAttributes();
    verify(discreteOrderItemImpl).setName(eq("Name"));
  }

  /**
   * Test {@link i18nUpdateCartServiceExtensionHandler#fixTranslations(Order)}.
   * <ul>
   *   <li>Then calls {@link NullOrderImpl#getDiscreteOrderItems()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link i18nUpdateCartServiceExtensionHandler#fixTranslations(Order)}
   */
  @Test
  @DisplayName("Test fixTranslations(Order); then calls getDiscreteOrderItems()")
  void testFixTranslations_thenCallsGetDiscreteOrderItems() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    i18nUpdateCartServiceExtensionHandler i18nUpdateCartServiceExtensionHandler = new i18nUpdateCartServiceExtensionHandler();
    NullOrderImpl cart = mock(NullOrderImpl.class);
    when(cart.getDiscreteOrderItems()).thenReturn(new ArrayList<>());
    when(cart.getOrderItems()).thenReturn(new ArrayList<>());

    // Act
    i18nUpdateCartServiceExtensionHandler.fixTranslations(cart);

    // Assert
    verify(cart).getDiscreteOrderItems();
    verify(cart).getOrderItems();
  }

  /**
   * Test
   * {@link i18nUpdateCartServiceExtensionHandler#translateOrderItem(OrderItem, Sku)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.</li>
   *   <li>When {@link Sku} {@link Sku#getName()} return {@code Name}.</li>
   *   <li>Then calls {@link Sku#getName()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link i18nUpdateCartServiceExtensionHandler#translateOrderItem(OrderItem, Sku)}
   */
  @Test
  @DisplayName("Test translateOrderItem(OrderItem, Sku); given ArrayList(); when Sku getName() return 'Name'; then calls getName()")
  void testTranslateOrderItem_givenArrayList_whenSkuGetNameReturnName_thenCallsGetName() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    i18nUpdateCartServiceExtensionHandler i18nUpdateCartServiceExtensionHandler = new i18nUpdateCartServiceExtensionHandler();
    OrderItem orderItem = mock(OrderItem.class);
    doNothing().when(orderItem).setName(Mockito.<String>any());
    Sku sku = mock(Sku.class);
    when(sku.getName()).thenReturn("Name");
    when(sku.getProductOptionValues()).thenReturn(new ArrayList<>());

    // Act
    i18nUpdateCartServiceExtensionHandler.translateOrderItem(orderItem, sku);

    // Assert
    verify(sku).getName();
    verify(sku, atLeast(1)).getProductOptionValues();
    verify(orderItem).setName(eq("Name"));
  }

  /**
   * Test
   * {@link i18nUpdateCartServiceExtensionHandler#translateOrderItem(OrderItem, Sku)}.
   * <ul>
   *   <li>Then {@link BundleOrderItemImpl} (default constructor) MainEntityName is
   * {@code Name}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link i18nUpdateCartServiceExtensionHandler#translateOrderItem(OrderItem, Sku)}
   */
  @Test
  @DisplayName("Test translateOrderItem(OrderItem, Sku); then BundleOrderItemImpl (default constructor) MainEntityName is 'Name'")
  void testTranslateOrderItem_thenBundleOrderItemImplMainEntityNameIsName() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    i18nUpdateCartServiceExtensionHandler i18nUpdateCartServiceExtensionHandler = new i18nUpdateCartServiceExtensionHandler();

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    BundleOrderItemImpl orderItem = new BundleOrderItemImpl();
    orderItem.setAuditable(auditable);
    orderItem.setBaseRetailPrice(new Money());
    orderItem.setBaseSalePrice(new Money());
    orderItem.setBundleOrderItemFeePrices(new ArrayList<>());
    orderItem.setCandidateItemOffers(new ArrayList<>());
    orderItem.setCartMessages(new ArrayList<>());
    orderItem.setChildOrderItems(new ArrayList<>());
    orderItem.setDiscountingAllowed(true);
    orderItem.setDiscreteOrderItems(new ArrayList<>());
    orderItem.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    orderItem.setHasValidationError(true);
    orderItem.setId(1L);
    orderItem.setName("Name");
    orderItem.setOrder(new NullOrderImpl());
    orderItem.setOrderItemAdjustments(new ArrayList<>());
    orderItem.setOrderItemPriceDetails(new ArrayList<>());
    orderItem.setOrderItemQualifiers(new ArrayList<>());
    orderItem.setOrderItemType(new OrderItemType("Type", "Friendly Type"));
    orderItem.setParentOrderItem(new BundleOrderItemImpl());
    orderItem.setPersonalMessage(new PersonalMessageImpl());
    orderItem.setProratedOrderItemAdjustments(new ArrayList<>());
    orderItem.setQuantity(1);
    orderItem.setRetailPrice(new Money());
    orderItem.setRetailPriceOverride(true);
    orderItem.setSalePrice(new Money());
    orderItem.setSalePriceOverride(true);
    orderItem.setTaxable(true);
    orderItem.updateSaleAndRetailPrices();
    orderItem.setOrderItemAttributes(new HashMap<>());

    // Act
    i18nUpdateCartServiceExtensionHandler.translateOrderItem(orderItem, null);

    // Assert that nothing has changed
    assertEquals("Name", orderItem.getMainEntityName());
    assertEquals("Name", orderItem.getName());
  }

  /**
   * Test
   * {@link i18nUpdateCartServiceExtensionHandler#translateOrderItem(OrderItem, Sku)}.
   * <ul>
   *   <li>Then {@link BundleOrderItemImpl} (default constructor) MainEntityName is
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link i18nUpdateCartServiceExtensionHandler#translateOrderItem(OrderItem, Sku)}
   */
  @Test
  @DisplayName("Test translateOrderItem(OrderItem, Sku); then BundleOrderItemImpl (default constructor) MainEntityName is 'null'")
  void testTranslateOrderItem_thenBundleOrderItemImplMainEntityNameIsNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    i18nUpdateCartServiceExtensionHandler i18nUpdateCartServiceExtensionHandler = new i18nUpdateCartServiceExtensionHandler();

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    BundleOrderItemImpl orderItem = new BundleOrderItemImpl();
    orderItem.setAuditable(auditable);
    orderItem.setBaseRetailPrice(new Money());
    orderItem.setBaseSalePrice(new Money());
    orderItem.setBundleOrderItemFeePrices(new ArrayList<>());
    orderItem.setCandidateItemOffers(new ArrayList<>());
    orderItem.setCartMessages(new ArrayList<>());
    orderItem.setChildOrderItems(new ArrayList<>());
    orderItem.setDiscountingAllowed(true);
    orderItem.setDiscreteOrderItems(new ArrayList<>());
    orderItem.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    orderItem.setHasValidationError(true);
    orderItem.setId(1L);
    orderItem.setName("Name");
    orderItem.setOrder(new NullOrderImpl());
    orderItem.setOrderItemAdjustments(new ArrayList<>());
    orderItem.setOrderItemPriceDetails(new ArrayList<>());
    orderItem.setOrderItemQualifiers(new ArrayList<>());
    orderItem.setOrderItemType(new OrderItemType("Type", "Friendly Type"));
    orderItem.setParentOrderItem(new BundleOrderItemImpl());
    orderItem.setPersonalMessage(new PersonalMessageImpl());
    orderItem.setProratedOrderItemAdjustments(new ArrayList<>());
    orderItem.setQuantity(1);
    orderItem.setRetailPrice(new Money());
    orderItem.setRetailPriceOverride(true);
    orderItem.setSalePrice(new Money());
    orderItem.setSalePriceOverride(true);
    orderItem.setTaxable(true);
    orderItem.updateSaleAndRetailPrices();
    orderItem.setOrderItemAttributes(new HashMap<>());

    // Act
    i18nUpdateCartServiceExtensionHandler.translateOrderItem(orderItem, new SkuImpl());

    // Assert
    assertNull(orderItem.getMainEntityName());
    assertNull(orderItem.getName());
  }

  /**
   * Test
   * {@link i18nUpdateCartServiceExtensionHandler#translateOrderItem(OrderItem, Sku)}.
   * <ul>
   *   <li>Then calls {@link ProductOptionValueImpl#getAttributeValue()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link i18nUpdateCartServiceExtensionHandler#translateOrderItem(OrderItem, Sku)}
   */
  @Test
  @DisplayName("Test translateOrderItem(OrderItem, Sku); then calls getAttributeValue()")
  void testTranslateOrderItem_thenCallsGetAttributeValue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    i18nUpdateCartServiceExtensionHandler i18nUpdateCartServiceExtensionHandler = new i18nUpdateCartServiceExtensionHandler();
    OrderItem orderItem = mock(OrderItem.class);
    when(orderItem.getOrderItemAttributes()).thenReturn(new HashMap<>());
    doNothing().when(orderItem).setName(Mockito.<String>any());
    ProductOptionValueImpl productOptionValueImpl = mock(ProductOptionValueImpl.class);
    when(productOptionValueImpl.getAttributeValue()).thenReturn("42");
    when(productOptionValueImpl.getProductOption()).thenReturn(new ProductOptionImpl());

    ArrayList<ProductOptionValue> productOptionValueList = new ArrayList<>();
    productOptionValueList.add(productOptionValueImpl);
    Sku sku = mock(Sku.class);
    when(sku.getName()).thenReturn("Name");
    when(sku.getProductOptionValues()).thenReturn(productOptionValueList);

    // Act
    i18nUpdateCartServiceExtensionHandler.translateOrderItem(orderItem, sku);

    // Assert
    verify(productOptionValueImpl).getAttributeValue();
    verify(productOptionValueImpl).getProductOption();
    verify(sku).getName();
    verify(sku, atLeast(1)).getProductOptionValues();
    verify(orderItem, atLeast(1)).getOrderItemAttributes();
    verify(orderItem).setName(eq("Name"));
  }

  /**
   * Test
   * {@link i18nUpdateCartServiceExtensionHandler#translateOrderItem(OrderItem, Sku)}.
   * <ul>
   *   <li>When {@link BundleOrderItemImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link i18nUpdateCartServiceExtensionHandler#translateOrderItem(OrderItem, Sku)}
   */
  @Test
  @DisplayName("Test translateOrderItem(OrderItem, Sku); when BundleOrderItemImpl (default constructor)")
  void testTranslateOrderItem_whenBundleOrderItemImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    i18nUpdateCartServiceExtensionHandler i18nUpdateCartServiceExtensionHandler = new i18nUpdateCartServiceExtensionHandler();
    BundleOrderItemImpl orderItem = new BundleOrderItemImpl();

    // Act
    i18nUpdateCartServiceExtensionHandler.translateOrderItem(orderItem, new SkuImpl());

    // Assert
    assertNull(orderItem.getMainEntityName());
    assertNull(orderItem.getName());
  }

  /**
   * Test
   * {@link i18nUpdateCartServiceExtensionHandler#translateOrderItem(OrderItem, Sku)}.
   * <ul>
   *   <li>When {@link SkuImpl} (default constructor).</li>
   *   <li>Then calls {@link OrderItem#setName(String)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link i18nUpdateCartServiceExtensionHandler#translateOrderItem(OrderItem, Sku)}
   */
  @Test
  @DisplayName("Test translateOrderItem(OrderItem, Sku); when SkuImpl (default constructor); then calls setName(String)")
  void testTranslateOrderItem_whenSkuImpl_thenCallsSetName() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    i18nUpdateCartServiceExtensionHandler i18nUpdateCartServiceExtensionHandler = new i18nUpdateCartServiceExtensionHandler();
    OrderItem orderItem = mock(OrderItem.class);
    doNothing().when(orderItem).setName(Mockito.<String>any());

    // Act
    i18nUpdateCartServiceExtensionHandler.translateOrderItem(orderItem, new SkuImpl());

    // Assert
    verify(orderItem).setName(isNull());
  }
}
