package org.broadleafcommerce.core.web.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.broadleafcommerce.common.audit.Auditable;
import org.broadleafcommerce.common.currency.domain.BroadleafCurrencyImpl;
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
import org.broadleafcommerce.core.order.domain.OrderItemAttribute;
import org.broadleafcommerce.core.order.domain.OrderItemAttributeImpl;
import org.broadleafcommerce.core.order.domain.PersonalMessageImpl;
import org.broadleafcommerce.core.order.service.type.OrderItemType;
import org.broadleafcommerce.core.order.service.type.OrderStatus;
import org.broadleafcommerce.profile.core.domain.CustomerImpl;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;

@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@RunWith(MockitoJUnitRunner.class)
public class i18nUpdateCartServiceExtensionHandlerDiffblueTest {
  @InjectMocks private i18nUpdateCartServiceExtensionHandler i18nUpdateCartServiceExtensionHandler;

  @Mock private UpdateCartServiceExtensionManager updateCartServiceExtensionManager;

  /**
   * Test {@link i18nUpdateCartServiceExtensionHandler#init()}.
   *
   * <ul>
   *   <li>Then calls {@link UpdateCartServiceExtensionManager#getHandlers()}.
   * </ul>
   *
   * <p>Method under test: {@link i18nUpdateCartServiceExtensionHandler#init()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void i18nUpdateCartServiceExtensionHandler.init()"})
  public void testInit_thenCallsGetHandlers() {
    // Arrange
    when(updateCartServiceExtensionManager.getHandlers()).thenReturn(new ArrayList<>());

    // Act
    i18nUpdateCartServiceExtensionHandler.init();

    // Assert
    verify(updateCartServiceExtensionManager).getHandlers();
  }

  /**
   * Test {@link i18nUpdateCartServiceExtensionHandler#fixTranslations(Order)}.
   *
   * <ul>
   *   <li>Given {@link DiscreteOrderItemImpl} {@link DiscreteOrderItemImpl#getSku()} return {@link
   *       SkuImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link i18nUpdateCartServiceExtensionHandler#fixTranslations(Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void i18nUpdateCartServiceExtensionHandler.fixTranslations(Order)"})
  public void testFixTranslations_givenDiscreteOrderItemImplGetSkuReturnSkuImpl() {
    // Arrange
    i18nUpdateCartServiceExtensionHandler i18nUpdateCartServiceExtensionHandler =
        new i18nUpdateCartServiceExtensionHandler();

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(1L);
    auditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(1L);

    DiscreteOrderItemImpl discreteOrderItemImpl = mock(DiscreteOrderItemImpl.class);
    doNothing().when(discreteOrderItemImpl).setName(Mockito.<String>any());
    when(discreteOrderItemImpl.getSku()).thenReturn(new SkuImpl());

    ArrayList<DiscreteOrderItem> discreteOrderItems = new ArrayList<>();
    discreteOrderItems.add(discreteOrderItemImpl);

    BundleOrderItemImpl bundleOrderItemImpl = new BundleOrderItemImpl();
    bundleOrderItemImpl.setAuditable(auditable2);
    bundleOrderItemImpl.setBaseRetailPrice(new Money());
    bundleOrderItemImpl.setBaseSalePrice(new Money());
    bundleOrderItemImpl.setBundleOrderItemFeePrices(new ArrayList<>());
    bundleOrderItemImpl.setCandidateItemOffers(new ArrayList<>());
    bundleOrderItemImpl.setCartMessages(new ArrayList<>());
    bundleOrderItemImpl.setChildOrderItems(new ArrayList<>());
    bundleOrderItemImpl.setDiscountingAllowed(true);
    bundleOrderItemImpl.setDiscreteOrderItems(discreteOrderItems);
    bundleOrderItemImpl.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    bundleOrderItemImpl.setHasValidationError(true);
    bundleOrderItemImpl.setId(1L);
    bundleOrderItemImpl.setName("Name");
    bundleOrderItemImpl.setOrder(new NullOrderImpl());
    bundleOrderItemImpl.setOrderItemAdjustments(new ArrayList<>());
    bundleOrderItemImpl.setOrderItemPriceDetails(new ArrayList<>());
    bundleOrderItemImpl.setOrderItemQualifiers(new ArrayList<>());
    bundleOrderItemImpl.setOrderItemType(new OrderItemType());
    bundleOrderItemImpl.setParentOrderItem(new BundleOrderItemImpl());
    bundleOrderItemImpl.setPersonalMessage(new PersonalMessageImpl());
    bundleOrderItemImpl.setPrice(new Money());
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
    cart.setStatus(new OrderStatus());
    cart.setSubTotal(new Money());
    cart.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    cart.setTaxOverride(true);
    cart.setTotal(new Money());
    cart.setTotalFulfillmentCharges(new Money());
    cart.setTotalTax(new Money());
    cart.setOrderItems(orderItems);

    // Act
    i18nUpdateCartServiceExtensionHandler.fixTranslations(cart);

    // Assert
    verify(discreteOrderItemImpl).getSku();
    verify(discreteOrderItemImpl).setName(null);
  }

  /**
   * Test {@link i18nUpdateCartServiceExtensionHandler#fixTranslations(Order)}.
   *
   * <ul>
   *   <li>Given {@link i18nUpdateCartServiceExtensionHandler} (default constructor).
   *   <li>Then calls {@link SkuImpl#getName()}.
   * </ul>
   *
   * <p>Method under test: {@link i18nUpdateCartServiceExtensionHandler#fixTranslations(Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void i18nUpdateCartServiceExtensionHandler.fixTranslations(Order)"})
  public void testFixTranslations_givenI18nUpdateCartServiceExtensionHandler_thenCallsGetName() {
    // Arrange
    i18nUpdateCartServiceExtensionHandler i18nUpdateCartServiceExtensionHandler =
        new i18nUpdateCartServiceExtensionHandler();

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(1L);
    auditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(1L);

    SkuImpl skuImpl = mock(SkuImpl.class);
    when(skuImpl.getName()).thenReturn("Name");
    when(skuImpl.getProductOptionValues()).thenReturn(new ArrayList<>());

    DiscreteOrderItemImpl discreteOrderItemImpl = mock(DiscreteOrderItemImpl.class);
    doNothing().when(discreteOrderItemImpl).setName(Mockito.<String>any());
    when(discreteOrderItemImpl.getSku()).thenReturn(skuImpl);

    ArrayList<DiscreteOrderItem> discreteOrderItems = new ArrayList<>();
    discreteOrderItems.add(discreteOrderItemImpl);

    BundleOrderItemImpl bundleOrderItemImpl = new BundleOrderItemImpl();
    bundleOrderItemImpl.setAuditable(auditable2);
    bundleOrderItemImpl.setBaseRetailPrice(new Money());
    bundleOrderItemImpl.setBaseSalePrice(new Money());
    bundleOrderItemImpl.setBundleOrderItemFeePrices(new ArrayList<>());
    bundleOrderItemImpl.setCandidateItemOffers(new ArrayList<>());
    bundleOrderItemImpl.setCartMessages(new ArrayList<>());
    bundleOrderItemImpl.setChildOrderItems(new ArrayList<>());
    bundleOrderItemImpl.setDiscountingAllowed(true);
    bundleOrderItemImpl.setDiscreteOrderItems(discreteOrderItems);
    bundleOrderItemImpl.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    bundleOrderItemImpl.setHasValidationError(true);
    bundleOrderItemImpl.setId(1L);
    bundleOrderItemImpl.setName("Name");
    bundleOrderItemImpl.setOrder(new NullOrderImpl());
    bundleOrderItemImpl.setOrderItemAdjustments(new ArrayList<>());
    bundleOrderItemImpl.setOrderItemPriceDetails(new ArrayList<>());
    bundleOrderItemImpl.setOrderItemQualifiers(new ArrayList<>());
    bundleOrderItemImpl.setOrderItemType(new OrderItemType());
    bundleOrderItemImpl.setParentOrderItem(new BundleOrderItemImpl());
    bundleOrderItemImpl.setPersonalMessage(new PersonalMessageImpl());
    bundleOrderItemImpl.setPrice(new Money());
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
    cart.setStatus(new OrderStatus());
    cart.setSubTotal(new Money());
    cart.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    cart.setTaxOverride(true);
    cart.setTotal(new Money());
    cart.setTotalFulfillmentCharges(new Money());
    cart.setTotalTax(new Money());
    cart.setOrderItems(orderItems);

    // Act
    i18nUpdateCartServiceExtensionHandler.fixTranslations(cart);

    // Assert
    verify(skuImpl).getName();
    verify(skuImpl, atLeast(1)).getProductOptionValues();
    verify(discreteOrderItemImpl).getSku();
    verify(discreteOrderItemImpl).setName("Name");
  }

  /**
   * Test {@link i18nUpdateCartServiceExtensionHandler#fixTranslations(Order)}.
   *
   * <ul>
   *   <li>Then calls {@link ProductOptionValueImpl#getAttributeValue()}.
   * </ul>
   *
   * <p>Method under test: {@link i18nUpdateCartServiceExtensionHandler#fixTranslations(Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void i18nUpdateCartServiceExtensionHandler.fixTranslations(Order)"})
  public void testFixTranslations_thenCallsGetAttributeValue() {
    // Arrange
    i18nUpdateCartServiceExtensionHandler i18nUpdateCartServiceExtensionHandler =
        new i18nUpdateCartServiceExtensionHandler();

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(1L);
    auditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(1L);

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

    ArrayList<DiscreteOrderItem> discreteOrderItems = new ArrayList<>();
    discreteOrderItems.add(discreteOrderItemImpl);

    BundleOrderItemImpl bundleOrderItemImpl = new BundleOrderItemImpl();
    bundleOrderItemImpl.setAuditable(auditable2);
    bundleOrderItemImpl.setBaseRetailPrice(new Money());
    bundleOrderItemImpl.setBaseSalePrice(new Money());
    bundleOrderItemImpl.setBundleOrderItemFeePrices(new ArrayList<>());
    bundleOrderItemImpl.setCandidateItemOffers(new ArrayList<>());
    bundleOrderItemImpl.setCartMessages(new ArrayList<>());
    bundleOrderItemImpl.setChildOrderItems(new ArrayList<>());
    bundleOrderItemImpl.setDiscountingAllowed(true);
    bundleOrderItemImpl.setDiscreteOrderItems(discreteOrderItems);
    bundleOrderItemImpl.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    bundleOrderItemImpl.setHasValidationError(true);
    bundleOrderItemImpl.setId(1L);
    bundleOrderItemImpl.setName("Name");
    bundleOrderItemImpl.setOrder(new NullOrderImpl());
    bundleOrderItemImpl.setOrderItemAdjustments(new ArrayList<>());
    bundleOrderItemImpl.setOrderItemPriceDetails(new ArrayList<>());
    bundleOrderItemImpl.setOrderItemQualifiers(new ArrayList<>());
    bundleOrderItemImpl.setOrderItemType(new OrderItemType());
    bundleOrderItemImpl.setParentOrderItem(new BundleOrderItemImpl());
    bundleOrderItemImpl.setPersonalMessage(new PersonalMessageImpl());
    bundleOrderItemImpl.setPrice(new Money());
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
    cart.setStatus(new OrderStatus());
    cart.setSubTotal(new Money());
    cart.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    cart.setTaxOverride(true);
    cart.setTotal(new Money());
    cart.setTotalFulfillmentCharges(new Money());
    cart.setTotalTax(new Money());
    cart.setOrderItems(orderItems);

    // Act
    i18nUpdateCartServiceExtensionHandler.fixTranslations(cart);

    // Assert
    verify(productOptionValueImpl).getAttributeValue();
    verify(productOptionValueImpl).getProductOption();
    verify(skuImpl).getName();
    verify(skuImpl, atLeast(1)).getProductOptionValues();
    verify(discreteOrderItemImpl).getSku();
    verify(discreteOrderItemImpl, atLeast(1)).getOrderItemAttributes();
    verify(discreteOrderItemImpl).setName("Name");
  }

  /**
   * Test {@link i18nUpdateCartServiceExtensionHandler#translateOrderItem(OrderItem, Sku)}.
   *
   * <ul>
   *   <li>Given {@link Auditable} (default constructor) CreatedBy is one.
   * </ul>
   *
   * <p>Method under test: {@link
   * i18nUpdateCartServiceExtensionHandler#translateOrderItem(OrderItem, Sku)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void i18nUpdateCartServiceExtensionHandler.translateOrderItem(OrderItem, Sku)"
  })
  public void testTranslateOrderItem_givenAuditableCreatedByIsOne() {
    // Arrange
    i18nUpdateCartServiceExtensionHandler i18nUpdateCartServiceExtensionHandler =
        new i18nUpdateCartServiceExtensionHandler();

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    orderItem.setOrderItemType(new OrderItemType());
    orderItem.setParentOrderItem(new BundleOrderItemImpl());
    orderItem.setPersonalMessage(new PersonalMessageImpl());
    orderItem.setPrice(new Money());
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
   *
   * <ul>
   *   <li>Then {@link BundleOrderItemImpl} (default constructor) MainEntityName is {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link
   * i18nUpdateCartServiceExtensionHandler#translateOrderItem(OrderItem, Sku)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void i18nUpdateCartServiceExtensionHandler.translateOrderItem(OrderItem, Sku)"
  })
  public void testTranslateOrderItem_thenBundleOrderItemImplMainEntityNameIsName() {
    // Arrange
    i18nUpdateCartServiceExtensionHandler i18nUpdateCartServiceExtensionHandler =
        new i18nUpdateCartServiceExtensionHandler();
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
   *
   * <ul>
   *   <li>Then {@link BundleOrderItemImpl} (default constructor) OrderItemAttributes size is one.
   * </ul>
   *
   * <p>Method under test: {@link
   * i18nUpdateCartServiceExtensionHandler#translateOrderItem(OrderItem, Sku)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void i18nUpdateCartServiceExtensionHandler.translateOrderItem(OrderItem, Sku)"
  })
  public void testTranslateOrderItem_thenBundleOrderItemImplOrderItemAttributesSizeIsOne() {
    // Arrange
    i18nUpdateCartServiceExtensionHandler i18nUpdateCartServiceExtensionHandler =
        new i18nUpdateCartServiceExtensionHandler();
    BundleOrderItemImpl orderItem = new BundleOrderItemImpl();

    ProductOptionValueImpl productOptionValueImpl = mock(ProductOptionValueImpl.class);
    when(productOptionValueImpl.getAttributeValue()).thenReturn("42");
    when(productOptionValueImpl.getProductOption()).thenReturn(new ProductOptionImpl());

    ArrayList<ProductOptionValue> productOptionValueList = new ArrayList<>();
    productOptionValueList.add(productOptionValueImpl);

    Sku sku = mock(Sku.class);
    when(sku.getProductOptionValues()).thenReturn(productOptionValueList);
    when(sku.getName()).thenReturn("Name");

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
   *
   * <ul>
   *   <li>When {@link SkuImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link
   * i18nUpdateCartServiceExtensionHandler#translateOrderItem(OrderItem, Sku)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void i18nUpdateCartServiceExtensionHandler.translateOrderItem(OrderItem, Sku)"
  })
  public void testTranslateOrderItem_whenSkuImpl() {
    // Arrange
    i18nUpdateCartServiceExtensionHandler i18nUpdateCartServiceExtensionHandler =
        new i18nUpdateCartServiceExtensionHandler();
    BundleOrderItemImpl orderItem = new BundleOrderItemImpl();

    // Act
    i18nUpdateCartServiceExtensionHandler.translateOrderItem(orderItem, new SkuImpl());

    // Assert that nothing has changed
    assertTrue(orderItem.getOrderItemAttributes().isEmpty());
  }
}
