/*-
 * #%L
 * BroadleafCommerce Framework Web
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
package org.broadleafcommerce.core.web.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.broadleafcommerce.common.audit.Auditable;
import org.broadleafcommerce.common.currency.domain.BroadleafCurrencyImpl;
import org.broadleafcommerce.common.extension.ExtensionManager;
import org.broadleafcommerce.common.extension.ExtensionResultHolder;
import org.broadleafcommerce.common.extension.ExtensionResultStatusType;
import org.broadleafcommerce.common.locale.domain.LocaleImpl;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.core.catalog.domain.ProductOptionImpl;
import org.broadleafcommerce.core.catalog.domain.ProductOptionValue;
import org.broadleafcommerce.core.catalog.domain.ProductOptionValueImpl;
import org.broadleafcommerce.core.catalog.domain.Sku;
import org.broadleafcommerce.core.catalog.domain.SkuImpl;
import org.broadleafcommerce.core.offer.domain.CandidateItemOffer;
import org.broadleafcommerce.core.offer.domain.OrderItemAdjustment;
import org.broadleafcommerce.core.offer.domain.ProratedOrderItemAdjustment;
import org.broadleafcommerce.core.order.domain.BundleOrderItemFeePrice;
import org.broadleafcommerce.core.order.domain.BundleOrderItemImpl;
import org.broadleafcommerce.core.order.domain.DiscreteOrderItem;
import org.broadleafcommerce.core.order.domain.DiscreteOrderItemImpl;
import org.broadleafcommerce.core.order.domain.GiftWrapOrderItem;
import org.broadleafcommerce.core.order.domain.GiftWrapOrderItemImpl;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.Order;
import org.broadleafcommerce.core.order.domain.OrderImpl;
import org.broadleafcommerce.core.order.domain.OrderItem;
import org.broadleafcommerce.core.order.domain.OrderItemAttribute;
import org.broadleafcommerce.core.order.domain.OrderItemAttributeImpl;
import org.broadleafcommerce.core.order.domain.OrderItemPriceDetail;
import org.broadleafcommerce.core.order.domain.OrderItemQualifier;
import org.broadleafcommerce.core.order.domain.PersonalMessage;
import org.broadleafcommerce.core.order.domain.PersonalMessageImpl;
import org.broadleafcommerce.core.order.service.type.OrderItemType;
import org.broadleafcommerce.core.order.service.type.OrderStatus;
import org.broadleafcommerce.profile.core.domain.CustomerImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;

@ExtendWith(MockitoExtension.class)
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
class i18nUpdateCartServiceExtensionHandlerDiffblueTest {
  @InjectMocks
  private i18nUpdateCartServiceExtensionHandler i18nUpdateCartServiceExtensionHandler;

  @Mock
  private UpdateCartServiceExtensionManager updateCartServiceExtensionManager;

  /**
   * Test {@link i18nUpdateCartServiceExtensionHandler#init()}.
   * <ul>
   *   <li>Then calls {@link ExtensionManager#getHandlers()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link i18nUpdateCartServiceExtensionHandler#init()}
   */
  @Test
  @DisplayName("Test init(); then calls getHandlers()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void i18nUpdateCartServiceExtensionHandler.init()"})
  void testInit_thenCallsGetHandlers() {
    // Arrange
    when(updateCartServiceExtensionManager.getHandlers()).thenReturn(new ArrayList<>());

    // Act
    i18nUpdateCartServiceExtensionHandler.init();

    // Assert
    verify(updateCartServiceExtensionManager).getHandlers();
  }

  /**
   * Test {@link i18nUpdateCartServiceExtensionHandler#updateAndValidateCart(Order, ExtensionResultHolder)}.
   * <ul>
   *   <li>Given {@link Auditable} (default constructor) CreatedBy is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link i18nUpdateCartServiceExtensionHandler#updateAndValidateCart(Order, ExtensionResultHolder)}
   */
  @Test
  @DisplayName("Test updateAndValidateCart(Order, ExtensionResultHolder); given Auditable (default constructor) CreatedBy is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ExtensionResultStatusType i18nUpdateCartServiceExtensionHandler.updateAndValidateCart(Order, ExtensionResultHolder)"})
  void testUpdateAndValidateCart_givenAuditableCreatedByIsOne() {
    // Arrange
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
   * Test {@link i18nUpdateCartServiceExtensionHandler#updateAndValidateCart(Order, ExtensionResultHolder)}.
   * <ul>
   *   <li>When {@link NullOrderImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link i18nUpdateCartServiceExtensionHandler#updateAndValidateCart(Order, ExtensionResultHolder)}
   */
  @Test
  @DisplayName("Test updateAndValidateCart(Order, ExtensionResultHolder); when NullOrderImpl (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ExtensionResultStatusType i18nUpdateCartServiceExtensionHandler.updateAndValidateCart(Order, ExtensionResultHolder)"})
  void testUpdateAndValidateCart_whenNullOrderImpl() {
    // Arrange
    NullOrderImpl cart = new NullOrderImpl();

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
   *   <li>Given {@link ArrayList#ArrayList()} add {@link DiscreteOrderItemImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link i18nUpdateCartServiceExtensionHandler#fixTranslations(Order)}
   */
  @Test
  @DisplayName("Test fixTranslations(Order); given ArrayList() add DiscreteOrderItemImpl (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void i18nUpdateCartServiceExtensionHandler.fixTranslations(Order)"})
  void testFixTranslations_givenArrayListAddDiscreteOrderItemImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

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

    ArrayList<DiscreteOrderItem> discreteOrderItemList = new ArrayList<>();
    discreteOrderItemList.add(new DiscreteOrderItemImpl());
    BundleOrderItemImpl bundleOrderItemImpl = mock(BundleOrderItemImpl.class);
    when(bundleOrderItemImpl.updateSaleAndRetailPrices()).thenReturn(true);
    when(bundleOrderItemImpl.getDiscreteOrderItems()).thenReturn(discreteOrderItemList);
    when(bundleOrderItemImpl.getSku()).thenReturn(new SkuImpl());
    doNothing().when(bundleOrderItemImpl).setBaseRetailPrice(Mockito.<Money>any());
    doNothing().when(bundleOrderItemImpl).setBaseSalePrice(Mockito.<Money>any());
    doNothing().when(bundleOrderItemImpl).setBundleOrderItemFeePrices(Mockito.<List<BundleOrderItemFeePrice>>any());
    doNothing().when(bundleOrderItemImpl).setDiscreteOrderItems(Mockito.<List<DiscreteOrderItem>>any());
    doNothing().when(bundleOrderItemImpl).setAuditable(Mockito.<Auditable>any());
    doNothing().when(bundleOrderItemImpl).setCandidateItemOffers(Mockito.<List<CandidateItemOffer>>any());
    doNothing().when(bundleOrderItemImpl).setCartMessages(Mockito.<List<String>>any());
    doNothing().when(bundleOrderItemImpl).setChildOrderItems(Mockito.<List<OrderItem>>any());
    doNothing().when(bundleOrderItemImpl).setDiscountingAllowed(anyBoolean());
    doNothing().when(bundleOrderItemImpl).setGiftWrapOrderItem(Mockito.<GiftWrapOrderItem>any());
    doNothing().when(bundleOrderItemImpl).setHasValidationError(Mockito.<Boolean>any());
    doNothing().when(bundleOrderItemImpl).setId(Mockito.<Long>any());
    doNothing().when(bundleOrderItemImpl).setName(Mockito.<String>any());
    doNothing().when(bundleOrderItemImpl).setOrder(Mockito.<Order>any());
    doNothing().when(bundleOrderItemImpl).setOrderItemAdjustments(Mockito.<List<OrderItemAdjustment>>any());
    doNothing().when(bundleOrderItemImpl).setOrderItemAttributes(Mockito.<Map<String, OrderItemAttribute>>any());
    doNothing().when(bundleOrderItemImpl).setOrderItemPriceDetails(Mockito.<List<OrderItemPriceDetail>>any());
    doNothing().when(bundleOrderItemImpl).setOrderItemQualifiers(Mockito.<List<OrderItemQualifier>>any());
    doNothing().when(bundleOrderItemImpl).setOrderItemType(Mockito.<OrderItemType>any());
    doNothing().when(bundleOrderItemImpl).setParentOrderItem(Mockito.<OrderItem>any());
    doNothing().when(bundleOrderItemImpl).setPersonalMessage(Mockito.<PersonalMessage>any());
    doNothing().when(bundleOrderItemImpl)
        .setProratedOrderItemAdjustments(Mockito.<List<ProratedOrderItemAdjustment>>any());
    doNothing().when(bundleOrderItemImpl).setQuantity(anyInt());
    doNothing().when(bundleOrderItemImpl).setRetailPrice(Mockito.<Money>any());
    doNothing().when(bundleOrderItemImpl).setRetailPriceOverride(anyBoolean());
    doNothing().when(bundleOrderItemImpl).setSalePrice(Mockito.<Money>any());
    doNothing().when(bundleOrderItemImpl).setSalePriceOverride(anyBoolean());
    doNothing().when(bundleOrderItemImpl).setTaxable(Mockito.<Boolean>any());
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

    OrderImpl cart = new OrderImpl();
    cart.setAdditionalOfferInformation(new HashMap<>());
    cart.setAuditable(auditable);
    cart.setCandidateOrderOffers(new ArrayList<>());
    cart.setCurrency(new BroadleafCurrencyImpl());
    cart.setCustomer(new CustomerImpl());
    cart.setEmailAddress("42 Main St");
    cart.setFulfillmentGroups(new ArrayList<>());
    cart.setId(1L);
    cart.setLocale(new LocaleImpl());
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

    // Act
    i18nUpdateCartServiceExtensionHandler.fixTranslations(cart);

    // Assert
    verify(bundleOrderItemImpl).getDiscreteOrderItems();
    verify(bundleOrderItemImpl).getSku();
    verify(bundleOrderItemImpl).setBaseRetailPrice(isA(Money.class));
    verify(bundleOrderItemImpl).setBaseSalePrice(isA(Money.class));
    verify(bundleOrderItemImpl).setBundleOrderItemFeePrices(isA(List.class));
    verify(bundleOrderItemImpl).setDiscreteOrderItems(isA(List.class));
    verify(bundleOrderItemImpl).updateSaleAndRetailPrices();
    verify(bundleOrderItemImpl).setAuditable(isA(Auditable.class));
    verify(bundleOrderItemImpl).setCandidateItemOffers(isA(List.class));
    verify(bundleOrderItemImpl).setCartMessages(isA(List.class));
    verify(bundleOrderItemImpl).setChildOrderItems(isA(List.class));
    verify(bundleOrderItemImpl).setDiscountingAllowed(eq(true));
    verify(bundleOrderItemImpl).setGiftWrapOrderItem(isA(GiftWrapOrderItem.class));
    verify(bundleOrderItemImpl).setHasValidationError(eq(true));
    verify(bundleOrderItemImpl).setId(eq(1L));
    verify(bundleOrderItemImpl, atLeast(1)).setName(Mockito.<String>any());
    verify(bundleOrderItemImpl).setOrder(isA(Order.class));
    verify(bundleOrderItemImpl).setOrderItemAdjustments(isA(List.class));
    verify(bundleOrderItemImpl).setOrderItemAttributes(isA(Map.class));
    verify(bundleOrderItemImpl).setOrderItemPriceDetails(isA(List.class));
    verify(bundleOrderItemImpl).setOrderItemQualifiers(isA(List.class));
    verify(bundleOrderItemImpl).setOrderItemType(isA(OrderItemType.class));
    verify(bundleOrderItemImpl).setParentOrderItem(isA(OrderItem.class));
    verify(bundleOrderItemImpl).setPersonalMessage(isA(PersonalMessage.class));
    verify(bundleOrderItemImpl).setProratedOrderItemAdjustments(isA(List.class));
    verify(bundleOrderItemImpl).setQuantity(eq(1));
    verify(bundleOrderItemImpl).setRetailPrice(isA(Money.class));
    verify(bundleOrderItemImpl).setRetailPriceOverride(eq(true));
    verify(bundleOrderItemImpl).setSalePrice(isA(Money.class));
    verify(bundleOrderItemImpl).setSalePriceOverride(eq(true));
    verify(bundleOrderItemImpl).setTaxable(eq(true));
  }

  /**
   * Test {@link i18nUpdateCartServiceExtensionHandler#fixTranslations(Order)}.
   * <ul>
   *   <li>Given {@link BundleOrderItemImpl} {@link BundleOrderItemImpl#getSku()} return {@link SkuImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link i18nUpdateCartServiceExtensionHandler#fixTranslations(Order)}
   */
  @Test
  @DisplayName("Test fixTranslations(Order); given BundleOrderItemImpl getSku() return SkuImpl (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void i18nUpdateCartServiceExtensionHandler.fixTranslations(Order)"})
  void testFixTranslations_givenBundleOrderItemImplGetSkuReturnSkuImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

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
    BundleOrderItemImpl bundleOrderItemImpl = mock(BundleOrderItemImpl.class);
    when(bundleOrderItemImpl.updateSaleAndRetailPrices()).thenReturn(true);
    when(bundleOrderItemImpl.getDiscreteOrderItems()).thenReturn(new ArrayList<>());
    when(bundleOrderItemImpl.getSku()).thenReturn(new SkuImpl());
    doNothing().when(bundleOrderItemImpl).setBaseRetailPrice(Mockito.<Money>any());
    doNothing().when(bundleOrderItemImpl).setBaseSalePrice(Mockito.<Money>any());
    doNothing().when(bundleOrderItemImpl).setBundleOrderItemFeePrices(Mockito.<List<BundleOrderItemFeePrice>>any());
    doNothing().when(bundleOrderItemImpl).setDiscreteOrderItems(Mockito.<List<DiscreteOrderItem>>any());
    doNothing().when(bundleOrderItemImpl).setAuditable(Mockito.<Auditable>any());
    doNothing().when(bundleOrderItemImpl).setCandidateItemOffers(Mockito.<List<CandidateItemOffer>>any());
    doNothing().when(bundleOrderItemImpl).setCartMessages(Mockito.<List<String>>any());
    doNothing().when(bundleOrderItemImpl).setChildOrderItems(Mockito.<List<OrderItem>>any());
    doNothing().when(bundleOrderItemImpl).setDiscountingAllowed(anyBoolean());
    doNothing().when(bundleOrderItemImpl).setGiftWrapOrderItem(Mockito.<GiftWrapOrderItem>any());
    doNothing().when(bundleOrderItemImpl).setHasValidationError(Mockito.<Boolean>any());
    doNothing().when(bundleOrderItemImpl).setId(Mockito.<Long>any());
    doNothing().when(bundleOrderItemImpl).setName(Mockito.<String>any());
    doNothing().when(bundleOrderItemImpl).setOrder(Mockito.<Order>any());
    doNothing().when(bundleOrderItemImpl).setOrderItemAdjustments(Mockito.<List<OrderItemAdjustment>>any());
    doNothing().when(bundleOrderItemImpl).setOrderItemAttributes(Mockito.<Map<String, OrderItemAttribute>>any());
    doNothing().when(bundleOrderItemImpl).setOrderItemPriceDetails(Mockito.<List<OrderItemPriceDetail>>any());
    doNothing().when(bundleOrderItemImpl).setOrderItemQualifiers(Mockito.<List<OrderItemQualifier>>any());
    doNothing().when(bundleOrderItemImpl).setOrderItemType(Mockito.<OrderItemType>any());
    doNothing().when(bundleOrderItemImpl).setParentOrderItem(Mockito.<OrderItem>any());
    doNothing().when(bundleOrderItemImpl).setPersonalMessage(Mockito.<PersonalMessage>any());
    doNothing().when(bundleOrderItemImpl)
        .setProratedOrderItemAdjustments(Mockito.<List<ProratedOrderItemAdjustment>>any());
    doNothing().when(bundleOrderItemImpl).setQuantity(anyInt());
    doNothing().when(bundleOrderItemImpl).setRetailPrice(Mockito.<Money>any());
    doNothing().when(bundleOrderItemImpl).setRetailPriceOverride(anyBoolean());
    doNothing().when(bundleOrderItemImpl).setSalePrice(Mockito.<Money>any());
    doNothing().when(bundleOrderItemImpl).setSalePriceOverride(anyBoolean());
    doNothing().when(bundleOrderItemImpl).setTaxable(Mockito.<Boolean>any());
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

    OrderImpl cart = new OrderImpl();
    cart.setAdditionalOfferInformation(new HashMap<>());
    cart.setAuditable(auditable);
    cart.setCandidateOrderOffers(new ArrayList<>());
    cart.setCurrency(new BroadleafCurrencyImpl());
    cart.setCustomer(new CustomerImpl());
    cart.setEmailAddress("42 Main St");
    cart.setFulfillmentGroups(new ArrayList<>());
    cart.setId(1L);
    cart.setLocale(new LocaleImpl());
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

    // Act
    i18nUpdateCartServiceExtensionHandler.fixTranslations(cart);

    // Assert
    verify(bundleOrderItemImpl).getDiscreteOrderItems();
    verify(bundleOrderItemImpl).getSku();
    verify(bundleOrderItemImpl).setBaseRetailPrice(isA(Money.class));
    verify(bundleOrderItemImpl).setBaseSalePrice(isA(Money.class));
    verify(bundleOrderItemImpl).setBundleOrderItemFeePrices(isA(List.class));
    verify(bundleOrderItemImpl).setDiscreteOrderItems(isA(List.class));
    verify(bundleOrderItemImpl).updateSaleAndRetailPrices();
    verify(bundleOrderItemImpl).setAuditable(isA(Auditable.class));
    verify(bundleOrderItemImpl).setCandidateItemOffers(isA(List.class));
    verify(bundleOrderItemImpl).setCartMessages(isA(List.class));
    verify(bundleOrderItemImpl).setChildOrderItems(isA(List.class));
    verify(bundleOrderItemImpl).setDiscountingAllowed(eq(true));
    verify(bundleOrderItemImpl).setGiftWrapOrderItem(isA(GiftWrapOrderItem.class));
    verify(bundleOrderItemImpl).setHasValidationError(eq(true));
    verify(bundleOrderItemImpl).setId(eq(1L));
    verify(bundleOrderItemImpl, atLeast(1)).setName(Mockito.<String>any());
    verify(bundleOrderItemImpl).setOrder(isA(Order.class));
    verify(bundleOrderItemImpl).setOrderItemAdjustments(isA(List.class));
    verify(bundleOrderItemImpl).setOrderItemAttributes(isA(Map.class));
    verify(bundleOrderItemImpl).setOrderItemPriceDetails(isA(List.class));
    verify(bundleOrderItemImpl).setOrderItemQualifiers(isA(List.class));
    verify(bundleOrderItemImpl).setOrderItemType(isA(OrderItemType.class));
    verify(bundleOrderItemImpl).setParentOrderItem(isA(OrderItem.class));
    verify(bundleOrderItemImpl).setPersonalMessage(isA(PersonalMessage.class));
    verify(bundleOrderItemImpl).setProratedOrderItemAdjustments(isA(List.class));
    verify(bundleOrderItemImpl).setQuantity(eq(1));
    verify(bundleOrderItemImpl).setRetailPrice(isA(Money.class));
    verify(bundleOrderItemImpl).setRetailPriceOverride(eq(true));
    verify(bundleOrderItemImpl).setSalePrice(isA(Money.class));
    verify(bundleOrderItemImpl).setSalePriceOverride(eq(true));
    verify(bundleOrderItemImpl).setTaxable(eq(true));
  }

  /**
   * Test {@link i18nUpdateCartServiceExtensionHandler#fixTranslations(Order)}.
   * <ul>
   *   <li>Given {@link SkuImpl} {@link SkuImpl#getName()} return {@code Name}.</li>
   *   <li>Then calls {@link SkuImpl#getName()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link i18nUpdateCartServiceExtensionHandler#fixTranslations(Order)}
   */
  @Test
  @DisplayName("Test fixTranslations(Order); given SkuImpl getName() return 'Name'; then calls getName()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void i18nUpdateCartServiceExtensionHandler.fixTranslations(Order)"})
  void testFixTranslations_givenSkuImplGetNameReturnName_thenCallsGetName() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

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
    SkuImpl skuImpl = mock(SkuImpl.class);
    when(skuImpl.getName()).thenReturn("Name");
    when(skuImpl.getProductOptionValues()).thenReturn(new ArrayList<>());
    BundleOrderItemImpl bundleOrderItemImpl = mock(BundleOrderItemImpl.class);
    when(bundleOrderItemImpl.updateSaleAndRetailPrices()).thenReturn(true);
    when(bundleOrderItemImpl.getDiscreteOrderItems()).thenReturn(new ArrayList<>());
    when(bundleOrderItemImpl.getSku()).thenReturn(skuImpl);
    doNothing().when(bundleOrderItemImpl).setBaseRetailPrice(Mockito.<Money>any());
    doNothing().when(bundleOrderItemImpl).setBaseSalePrice(Mockito.<Money>any());
    doNothing().when(bundleOrderItemImpl).setBundleOrderItemFeePrices(Mockito.<List<BundleOrderItemFeePrice>>any());
    doNothing().when(bundleOrderItemImpl).setDiscreteOrderItems(Mockito.<List<DiscreteOrderItem>>any());
    doNothing().when(bundleOrderItemImpl).setAuditable(Mockito.<Auditable>any());
    doNothing().when(bundleOrderItemImpl).setCandidateItemOffers(Mockito.<List<CandidateItemOffer>>any());
    doNothing().when(bundleOrderItemImpl).setCartMessages(Mockito.<List<String>>any());
    doNothing().when(bundleOrderItemImpl).setChildOrderItems(Mockito.<List<OrderItem>>any());
    doNothing().when(bundleOrderItemImpl).setDiscountingAllowed(anyBoolean());
    doNothing().when(bundleOrderItemImpl).setGiftWrapOrderItem(Mockito.<GiftWrapOrderItem>any());
    doNothing().when(bundleOrderItemImpl).setHasValidationError(Mockito.<Boolean>any());
    doNothing().when(bundleOrderItemImpl).setId(Mockito.<Long>any());
    doNothing().when(bundleOrderItemImpl).setName(Mockito.<String>any());
    doNothing().when(bundleOrderItemImpl).setOrder(Mockito.<Order>any());
    doNothing().when(bundleOrderItemImpl).setOrderItemAdjustments(Mockito.<List<OrderItemAdjustment>>any());
    doNothing().when(bundleOrderItemImpl).setOrderItemAttributes(Mockito.<Map<String, OrderItemAttribute>>any());
    doNothing().when(bundleOrderItemImpl).setOrderItemPriceDetails(Mockito.<List<OrderItemPriceDetail>>any());
    doNothing().when(bundleOrderItemImpl).setOrderItemQualifiers(Mockito.<List<OrderItemQualifier>>any());
    doNothing().when(bundleOrderItemImpl).setOrderItemType(Mockito.<OrderItemType>any());
    doNothing().when(bundleOrderItemImpl).setParentOrderItem(Mockito.<OrderItem>any());
    doNothing().when(bundleOrderItemImpl).setPersonalMessage(Mockito.<PersonalMessage>any());
    doNothing().when(bundleOrderItemImpl)
        .setProratedOrderItemAdjustments(Mockito.<List<ProratedOrderItemAdjustment>>any());
    doNothing().when(bundleOrderItemImpl).setQuantity(anyInt());
    doNothing().when(bundleOrderItemImpl).setRetailPrice(Mockito.<Money>any());
    doNothing().when(bundleOrderItemImpl).setRetailPriceOverride(anyBoolean());
    doNothing().when(bundleOrderItemImpl).setSalePrice(Mockito.<Money>any());
    doNothing().when(bundleOrderItemImpl).setSalePriceOverride(anyBoolean());
    doNothing().when(bundleOrderItemImpl).setTaxable(Mockito.<Boolean>any());
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

    OrderImpl cart = new OrderImpl();
    cart.setAdditionalOfferInformation(new HashMap<>());
    cart.setAuditable(auditable);
    cart.setCandidateOrderOffers(new ArrayList<>());
    cart.setCurrency(new BroadleafCurrencyImpl());
    cart.setCustomer(new CustomerImpl());
    cart.setEmailAddress("42 Main St");
    cart.setFulfillmentGroups(new ArrayList<>());
    cart.setId(1L);
    cart.setLocale(new LocaleImpl());
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

    // Act
    i18nUpdateCartServiceExtensionHandler.fixTranslations(cart);

    // Assert
    verify(skuImpl).getName();
    verify(skuImpl, atLeast(1)).getProductOptionValues();
    verify(bundleOrderItemImpl).getDiscreteOrderItems();
    verify(bundleOrderItemImpl).getSku();
    verify(bundleOrderItemImpl).setBaseRetailPrice(isA(Money.class));
    verify(bundleOrderItemImpl).setBaseSalePrice(isA(Money.class));
    verify(bundleOrderItemImpl).setBundleOrderItemFeePrices(isA(List.class));
    verify(bundleOrderItemImpl).setDiscreteOrderItems(isA(List.class));
    verify(bundleOrderItemImpl).updateSaleAndRetailPrices();
    verify(bundleOrderItemImpl).setAuditable(isA(Auditable.class));
    verify(bundleOrderItemImpl).setCandidateItemOffers(isA(List.class));
    verify(bundleOrderItemImpl).setCartMessages(isA(List.class));
    verify(bundleOrderItemImpl).setChildOrderItems(isA(List.class));
    verify(bundleOrderItemImpl).setDiscountingAllowed(eq(true));
    verify(bundleOrderItemImpl).setGiftWrapOrderItem(isA(GiftWrapOrderItem.class));
    verify(bundleOrderItemImpl).setHasValidationError(eq(true));
    verify(bundleOrderItemImpl).setId(eq(1L));
    verify(bundleOrderItemImpl, atLeast(1)).setName(eq("Name"));
    verify(bundleOrderItemImpl).setOrder(isA(Order.class));
    verify(bundleOrderItemImpl).setOrderItemAdjustments(isA(List.class));
    verify(bundleOrderItemImpl).setOrderItemAttributes(isA(Map.class));
    verify(bundleOrderItemImpl).setOrderItemPriceDetails(isA(List.class));
    verify(bundleOrderItemImpl).setOrderItemQualifiers(isA(List.class));
    verify(bundleOrderItemImpl).setOrderItemType(isA(OrderItemType.class));
    verify(bundleOrderItemImpl).setParentOrderItem(isA(OrderItem.class));
    verify(bundleOrderItemImpl).setPersonalMessage(isA(PersonalMessage.class));
    verify(bundleOrderItemImpl).setProratedOrderItemAdjustments(isA(List.class));
    verify(bundleOrderItemImpl).setQuantity(eq(1));
    verify(bundleOrderItemImpl).setRetailPrice(isA(Money.class));
    verify(bundleOrderItemImpl).setRetailPriceOverride(eq(true));
    verify(bundleOrderItemImpl).setSalePrice(isA(Money.class));
    verify(bundleOrderItemImpl).setSalePriceOverride(eq(true));
    verify(bundleOrderItemImpl).setTaxable(eq(true));
  }

  /**
   * Test {@link i18nUpdateCartServiceExtensionHandler#translateOrderItem(OrderItem, Sku)}.
   * <ul>
   *   <li>Then {@link BundleOrderItemImpl} (default constructor) MainEntityName is {@code Name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link i18nUpdateCartServiceExtensionHandler#translateOrderItem(OrderItem, Sku)}
   */
  @Test
  @DisplayName("Test translateOrderItem(OrderItem, Sku); then BundleOrderItemImpl (default constructor) MainEntityName is 'Name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void i18nUpdateCartServiceExtensionHandler.translateOrderItem(OrderItem, Sku)"})
  void testTranslateOrderItem_thenBundleOrderItemImplMainEntityNameIsName() {
    // Arrange
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
    assertTrue(orderItem.getOrderItemAttributes().isEmpty());
  }

  /**
   * Test {@link i18nUpdateCartServiceExtensionHandler#translateOrderItem(OrderItem, Sku)}.
   * <ul>
   *   <li>Then {@link BundleOrderItemImpl} (default constructor) MainEntityName is {@code Name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link i18nUpdateCartServiceExtensionHandler#translateOrderItem(OrderItem, Sku)}
   */
  @Test
  @DisplayName("Test translateOrderItem(OrderItem, Sku); then BundleOrderItemImpl (default constructor) MainEntityName is 'Name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void i18nUpdateCartServiceExtensionHandler.translateOrderItem(OrderItem, Sku)"})
  void testTranslateOrderItem_thenBundleOrderItemImplMainEntityNameIsName2() {
    // Arrange
    BundleOrderItemImpl orderItem = new BundleOrderItemImpl();
    Sku sku = mock(Sku.class);
    when(sku.getName()).thenReturn("Name");
    when(sku.getProductOptionValues()).thenReturn(new ArrayList<>());

    // Act
    i18nUpdateCartServiceExtensionHandler.translateOrderItem(orderItem, sku);

    // Assert
    verify(sku).getName();
    verify(sku, atLeast(1)).getProductOptionValues();
    assertEquals("Name", orderItem.getMainEntityName());
    assertEquals("Name", orderItem.getName());
    assertTrue(orderItem.getOrderItemAttributes().isEmpty());
  }

  /**
   * Test {@link i18nUpdateCartServiceExtensionHandler#translateOrderItem(OrderItem, Sku)}.
   * <ul>
   *   <li>Then {@link BundleOrderItemImpl} (default constructor) MainEntityName is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link i18nUpdateCartServiceExtensionHandler#translateOrderItem(OrderItem, Sku)}
   */
  @Test
  @DisplayName("Test translateOrderItem(OrderItem, Sku); then BundleOrderItemImpl (default constructor) MainEntityName is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void i18nUpdateCartServiceExtensionHandler.translateOrderItem(OrderItem, Sku)"})
  void testTranslateOrderItem_thenBundleOrderItemImplMainEntityNameIsNull() {
    // Arrange
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
    assertTrue(orderItem.getOrderItemAttributes().isEmpty());
  }

  /**
   * Test {@link i18nUpdateCartServiceExtensionHandler#translateOrderItem(OrderItem, Sku)}.
   * <ul>
   *   <li>Then {@link BundleOrderItemImpl} (default constructor) OrderItemAttributes size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link i18nUpdateCartServiceExtensionHandler#translateOrderItem(OrderItem, Sku)}
   */
  @Test
  @DisplayName("Test translateOrderItem(OrderItem, Sku); then BundleOrderItemImpl (default constructor) OrderItemAttributes size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void i18nUpdateCartServiceExtensionHandler.translateOrderItem(OrderItem, Sku)"})
  void testTranslateOrderItem_thenBundleOrderItemImplOrderItemAttributesSizeIsOne() {
    // Arrange
    BundleOrderItemImpl orderItem = new BundleOrderItemImpl();
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
    Map<String, OrderItemAttribute> orderItemAttributes = orderItem.getOrderItemAttributes();
    assertEquals(1, orderItemAttributes.size());
    OrderItemAttribute getResult = orderItemAttributes.get(null);
    assertTrue(getResult instanceof OrderItemAttributeImpl);
    assertEquals("42", getResult.toString());
    assertEquals("42", getResult.getValue());
    assertNull(getResult.getId());
    assertNull(getResult.getName());
    assertSame(orderItem, getResult.getOrderItem());
  }

  /**
   * Test {@link i18nUpdateCartServiceExtensionHandler#translateOrderItem(OrderItem, Sku)}.
   * <ul>
   *   <li>When {@link SkuImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link i18nUpdateCartServiceExtensionHandler#translateOrderItem(OrderItem, Sku)}
   */
  @Test
  @DisplayName("Test translateOrderItem(OrderItem, Sku); when SkuImpl (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void i18nUpdateCartServiceExtensionHandler.translateOrderItem(OrderItem, Sku)"})
  void testTranslateOrderItem_whenSkuImpl() {
    // Arrange
    BundleOrderItemImpl orderItem = new BundleOrderItemImpl();

    // Act
    i18nUpdateCartServiceExtensionHandler.translateOrderItem(orderItem, new SkuImpl());

    // Assert that nothing has changed
    assertTrue(orderItem.getOrderItemAttributes().isEmpty());
  }
}
