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
package org.broadleafcommerce.core.order.service.legacy;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.broadleafcommerce.common.audit.Auditable;
import org.broadleafcommerce.common.currency.domain.BroadleafCurrencyImpl;
import org.broadleafcommerce.common.locale.domain.LocaleImpl;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.core.catalog.dao.CategoryDao;
import org.broadleafcommerce.core.catalog.dao.ProductDao;
import org.broadleafcommerce.core.catalog.dao.SkuDao;
import org.broadleafcommerce.core.catalog.domain.CategoryImpl;
import org.broadleafcommerce.core.catalog.domain.Product;
import org.broadleafcommerce.core.catalog.domain.ProductBundleImpl;
import org.broadleafcommerce.core.catalog.domain.ProductImpl;
import org.broadleafcommerce.core.catalog.domain.Sku;
import org.broadleafcommerce.core.catalog.domain.SkuImpl;
import org.broadleafcommerce.core.offer.dao.OfferDao;
import org.broadleafcommerce.core.offer.domain.CandidateFulfillmentGroupOffer;
import org.broadleafcommerce.core.offer.domain.FulfillmentGroupAdjustment;
import org.broadleafcommerce.core.offer.service.OfferService;
import org.broadleafcommerce.core.order.dao.FulfillmentGroupDao;
import org.broadleafcommerce.core.order.dao.FulfillmentGroupDaoImpl;
import org.broadleafcommerce.core.order.dao.FulfillmentGroupItemDao;
import org.broadleafcommerce.core.order.dao.FulfillmentGroupItemDaoImpl;
import org.broadleafcommerce.core.order.dao.OrderDao;
import org.broadleafcommerce.core.order.dao.OrderDaoImpl;
import org.broadleafcommerce.core.order.dao.OrderItemDao;
import org.broadleafcommerce.core.order.domain.BundleOrderItem;
import org.broadleafcommerce.core.order.domain.BundleOrderItemImpl;
import org.broadleafcommerce.core.order.domain.DiscreteOrderItem;
import org.broadleafcommerce.core.order.domain.DiscreteOrderItemImpl;
import org.broadleafcommerce.core.order.domain.FulfillmentGroup;
import org.broadleafcommerce.core.order.domain.FulfillmentGroupFee;
import org.broadleafcommerce.core.order.domain.FulfillmentGroupImpl;
import org.broadleafcommerce.core.order.domain.FulfillmentGroupItem;
import org.broadleafcommerce.core.order.domain.FulfillmentGroupItemImpl;
import org.broadleafcommerce.core.order.domain.FulfillmentOption;
import org.broadleafcommerce.core.order.domain.FulfillmentOptionImpl;
import org.broadleafcommerce.core.order.domain.GiftWrapOrderItemImpl;
import org.broadleafcommerce.core.order.domain.NullOrderFactory;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.Order;
import org.broadleafcommerce.core.order.domain.OrderImpl;
import org.broadleafcommerce.core.order.domain.OrderItem;
import org.broadleafcommerce.core.order.domain.OrderItemImpl;
import org.broadleafcommerce.core.order.domain.PersonalMessage;
import org.broadleafcommerce.core.order.domain.PersonalMessageImpl;
import org.broadleafcommerce.core.order.domain.TaxDetail;
import org.broadleafcommerce.core.order.service.FulfillmentGroupService;
import org.broadleafcommerce.core.order.service.MergeCartService;
import org.broadleafcommerce.core.order.service.OrderItemService;
import org.broadleafcommerce.core.order.service.OrderItemServiceImpl;
import org.broadleafcommerce.core.order.service.OrderMultishipOptionService;
import org.broadleafcommerce.core.order.service.call.BundleOrderItemRequest;
import org.broadleafcommerce.core.order.service.call.ConfigurableOrderItemRequest;
import org.broadleafcommerce.core.order.service.call.DiscreteOrderItemRequest;
import org.broadleafcommerce.core.order.service.call.FulfillmentGroupRequest;
import org.broadleafcommerce.core.order.service.call.OrderItemRequestDTO;
import org.broadleafcommerce.core.order.service.exception.ItemNotFoundException;
import org.broadleafcommerce.core.order.service.exception.RequiredAttributeNotProvidedException;
import org.broadleafcommerce.core.order.service.type.FulfillmentGroupStatusType;
import org.broadleafcommerce.core.order.service.type.FulfillmentType;
import org.broadleafcommerce.core.order.service.type.OrderItemType;
import org.broadleafcommerce.core.order.service.type.OrderStatus;
import org.broadleafcommerce.core.payment.dao.OrderPaymentDao;
import org.broadleafcommerce.core.payment.dao.OrderPaymentDaoImpl;
import org.broadleafcommerce.core.payment.domain.OrderPayment;
import org.broadleafcommerce.core.payment.service.SecureOrderPaymentService;
import org.broadleafcommerce.core.pricing.service.PricingService;
import org.broadleafcommerce.core.pricing.service.exception.PricingException;
import org.broadleafcommerce.core.workflow.Processor;
import org.broadleafcommerce.profile.core.domain.Address;
import org.broadleafcommerce.profile.core.domain.AddressImpl;
import org.broadleafcommerce.profile.core.domain.Customer;
import org.broadleafcommerce.profile.core.domain.CustomerImpl;
import org.broadleafcommerce.profile.core.domain.Phone;
import org.broadleafcommerce.profile.core.domain.PhoneImpl;
import org.broadleafcommerce.profile.core.service.CustomerService;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.transaction.PlatformTransactionManager;

@RunWith(MockitoJUnitRunner.class)
public class LegacyOrderServiceImplDiffblueTest {
  @Mock
  private CategoryDao categoryDao;

  @Mock
  private CustomerService customerService;

  @Mock
  private FulfillmentGroupDao fulfillmentGroupDao;

  @Mock
  private FulfillmentGroupItemDao fulfillmentGroupItemDao;

  @Mock
  private FulfillmentGroupService fulfillmentGroupService;

  @InjectMocks
  private LegacyOrderServiceImpl legacyOrderServiceImpl;

  @Mock
  private MergeCartService mergeCartService;

  @Mock
  private NullOrderFactory nullOrderFactory;

  @Mock
  private OfferDao offerDao;

  @Mock
  private OfferService offerService;

  @Mock
  private OrderDao orderDao;

  @Mock
  private OrderItemDao orderItemDao;

  @Mock
  private OrderItemService orderItemService;

  @Mock
  private OrderMultishipOptionService orderMultishipOptionService;

  @Mock
  private OrderPaymentDao orderPaymentDao;

  @Mock
  private PlatformTransactionManager platformTransactionManager;

  @Mock
  private PricingService pricingService;

  @Mock
  private Processor processor;

  @Mock
  private ProductDao productDao;

  @Mock
  private SecureOrderPaymentService secureOrderPaymentService;

  @Mock
  private SkuDao skuDao;

  /**
   * Test {@link LegacyOrderServiceImpl#findDefaultFulfillmentGroupForOrder(Order)}.
   * <ul>
   *   <li>Then return {@link FulfillmentGroupImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link LegacyOrderServiceImpl#findDefaultFulfillmentGroupForOrder(Order)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FulfillmentGroup LegacyOrderServiceImpl.findDefaultFulfillmentGroupForOrder(Order)"})
  public void testFindDefaultFulfillmentGroupForOrder_thenReturnFulfillmentGroupImpl() {
    // Arrange
    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();
    when(fulfillmentGroupDao.readDefaultFulfillmentGroupForOrder(Mockito.<Order>any()))
        .thenReturn(fulfillmentGroupImpl);

    // Act
    FulfillmentGroup actualFindDefaultFulfillmentGroupForOrderResult = legacyOrderServiceImpl
        .findDefaultFulfillmentGroupForOrder(new NullOrderImpl());

    // Assert
    verify(fulfillmentGroupDao).readDefaultFulfillmentGroupForOrder(isA(Order.class));
    assertSame(fulfillmentGroupImpl, actualFindDefaultFulfillmentGroupForOrderResult);
  }

  /**
   * Test {@link LegacyOrderServiceImpl#findDefaultFulfillmentGroupForOrder(Order)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LegacyOrderServiceImpl#findDefaultFulfillmentGroupForOrder(Order)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FulfillmentGroup LegacyOrderServiceImpl.findDefaultFulfillmentGroupForOrder(Order)"})
  public void testFindDefaultFulfillmentGroupForOrder_thenThrowIllegalArgumentException() {
    // Arrange
    when(fulfillmentGroupDao.readDefaultFulfillmentGroupForOrder(Mockito.<Order>any()))
        .thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> legacyOrderServiceImpl.findDefaultFulfillmentGroupForOrder(new NullOrderImpl()));
    verify(fulfillmentGroupDao).readDefaultFulfillmentGroupForOrder(isA(Order.class));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#createDiscreteOrderItemRequest(DiscreteOrderItem)} with {@code discreteOrderItem}.
   * <p>
   * Method under test: {@link LegacyOrderServiceImpl#createDiscreteOrderItemRequest(DiscreteOrderItem)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "DiscreteOrderItemRequest LegacyOrderServiceImpl.createDiscreteOrderItemRequest(DiscreteOrderItem)"})
  public void testCreateDiscreteOrderItemRequestWithDiscreteOrderItem() {
    // Arrange
    PersonalMessageImpl personalMessageImpl = new PersonalMessageImpl();
    when(orderItemService.createPersonalMessage()).thenReturn(personalMessageImpl);
    DiscreteOrderItem discreteOrderItem = mock(DiscreteOrderItem.class);
    when(discreteOrderItem.getQuantity()).thenReturn(1);
    CategoryImpl categoryImpl = new CategoryImpl();
    when(discreteOrderItem.getCategory()).thenReturn(categoryImpl);
    ProductBundleImpl productBundleImpl = new ProductBundleImpl();
    when(discreteOrderItem.getProduct()).thenReturn(productBundleImpl);
    SkuImpl skuImpl = new SkuImpl();
    when(discreteOrderItem.getSku()).thenReturn(skuImpl);
    when(discreteOrderItem.getPersonalMessage()).thenReturn(new PersonalMessageImpl());

    // Act
    DiscreteOrderItemRequest actualCreateDiscreteOrderItemRequestResult = legacyOrderServiceImpl
        .createDiscreteOrderItemRequest(discreteOrderItem);

    // Assert
    verify(discreteOrderItem).getProduct();
    verify(discreteOrderItem).getSku();
    verify(discreteOrderItem).getCategory();
    verify(discreteOrderItem, atLeast(1)).getPersonalMessage();
    verify(discreteOrderItem).getQuantity();
    verify(orderItemService).createPersonalMessage();
    org.broadleafcommerce.core.catalog.domain.Category category = actualCreateDiscreteOrderItemRequestResult
        .getCategory();
    assertTrue(category instanceof CategoryImpl);
    Product product = actualCreateDiscreteOrderItemRequestResult.getProduct();
    assertTrue(product instanceof ProductBundleImpl);
    Sku sku = actualCreateDiscreteOrderItemRequestResult.getSku();
    assertTrue(sku instanceof SkuImpl);
    PersonalMessage personalMessage = actualCreateDiscreteOrderItemRequestResult.getPersonalMessage();
    assertTrue(personalMessage instanceof PersonalMessageImpl);
    assertEquals(1, actualCreateDiscreteOrderItemRequestResult.getQuantity());
    assertSame(categoryImpl, category);
    assertSame(productBundleImpl, product);
    assertSame(skuImpl, sku);
    assertSame(personalMessageImpl, personalMessage);
  }

  /**
   * Test {@link LegacyOrderServiceImpl#createDiscreteOrderItemRequest(DiscreteOrderItem)} with {@code discreteOrderItem}.
   * <p>
   * Method under test: {@link LegacyOrderServiceImpl#createDiscreteOrderItemRequest(DiscreteOrderItem)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "DiscreteOrderItemRequest LegacyOrderServiceImpl.createDiscreteOrderItemRequest(DiscreteOrderItem)"})
  public void testCreateDiscreteOrderItemRequestWithDiscreteOrderItem2() {
    // Arrange
    when(orderItemService.createPersonalMessage()).thenThrow(new IllegalArgumentException("foo"));
    DiscreteOrderItem discreteOrderItem = mock(DiscreteOrderItem.class);
    when(discreteOrderItem.getQuantity()).thenReturn(1);
    when(discreteOrderItem.getCategory()).thenReturn(new CategoryImpl());
    when(discreteOrderItem.getProduct()).thenReturn(new ProductBundleImpl());
    when(discreteOrderItem.getSku()).thenReturn(new SkuImpl());
    when(discreteOrderItem.getPersonalMessage()).thenReturn(new PersonalMessageImpl());

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> legacyOrderServiceImpl.createDiscreteOrderItemRequest(discreteOrderItem));
    verify(discreteOrderItem).getProduct();
    verify(discreteOrderItem).getSku();
    verify(discreteOrderItem).getCategory();
    verify(discreteOrderItem).getPersonalMessage();
    verify(discreteOrderItem).getQuantity();
    verify(orderItemService).createPersonalMessage();
  }

  /**
   * Test {@link LegacyOrderServiceImpl#createDiscreteOrderItemRequest(DiscreteOrderItem)} with {@code discreteOrderItem}.
   * <p>
   * Method under test: {@link LegacyOrderServiceImpl#createDiscreteOrderItemRequest(DiscreteOrderItem)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "DiscreteOrderItemRequest LegacyOrderServiceImpl.createDiscreteOrderItemRequest(DiscreteOrderItem)"})
  public void testCreateDiscreteOrderItemRequestWithDiscreteOrderItem3() {
    // Arrange
    PersonalMessageImpl personalMessageImpl = mock(PersonalMessageImpl.class);
    doThrow(new RequiredAttributeNotProvidedException("Attribute Name")).when(personalMessageImpl)
        .setOccasion(Mockito.<String>any());
    when(orderItemService.createPersonalMessage()).thenReturn(personalMessageImpl);
    PersonalMessageImpl personalMessageImpl2 = mock(PersonalMessageImpl.class);
    when(personalMessageImpl2.getOccasion()).thenReturn("Occasion");
    DiscreteOrderItem discreteOrderItem = mock(DiscreteOrderItem.class);
    when(discreteOrderItem.getQuantity()).thenReturn(1);
    when(discreteOrderItem.getCategory()).thenReturn(new CategoryImpl());
    when(discreteOrderItem.getProduct()).thenReturn(new ProductBundleImpl());
    when(discreteOrderItem.getSku()).thenReturn(new SkuImpl());
    when(discreteOrderItem.getPersonalMessage()).thenReturn(personalMessageImpl2);

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> legacyOrderServiceImpl.createDiscreteOrderItemRequest(discreteOrderItem));
    verify(discreteOrderItem).getProduct();
    verify(discreteOrderItem).getSku();
    verify(discreteOrderItem).getCategory();
    verify(discreteOrderItem, atLeast(1)).getPersonalMessage();
    verify(discreteOrderItem).getQuantity();
    verify(personalMessageImpl2).getOccasion();
    verify(personalMessageImpl).setOccasion(eq("Occasion"));
    verify(orderItemService).createPersonalMessage();
  }

  /**
   * Test {@link LegacyOrderServiceImpl#createDiscreteOrderItemRequest(DiscreteOrderItem)} with {@code discreteOrderItem}.
   * <p>
   * Method under test: {@link LegacyOrderServiceImpl#createDiscreteOrderItemRequest(DiscreteOrderItem)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "DiscreteOrderItemRequest LegacyOrderServiceImpl.createDiscreteOrderItemRequest(DiscreteOrderItem)"})
  public void testCreateDiscreteOrderItemRequestWithDiscreteOrderItem4() {
    // Arrange
    when(orderItemService.createPersonalMessage()).thenReturn(mock(PersonalMessageImpl.class));
    PersonalMessageImpl personalMessageImpl = mock(PersonalMessageImpl.class);
    when(personalMessageImpl.getOccasion()).thenThrow(new IllegalArgumentException("foo"));
    DiscreteOrderItem discreteOrderItem = mock(DiscreteOrderItem.class);
    when(discreteOrderItem.getQuantity()).thenReturn(1);
    when(discreteOrderItem.getCategory()).thenReturn(new CategoryImpl());
    when(discreteOrderItem.getProduct()).thenReturn(new ProductBundleImpl());
    when(discreteOrderItem.getSku()).thenReturn(new SkuImpl());
    when(discreteOrderItem.getPersonalMessage()).thenReturn(personalMessageImpl);

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> legacyOrderServiceImpl.createDiscreteOrderItemRequest(discreteOrderItem));
    verify(discreteOrderItem).getProduct();
    verify(discreteOrderItem).getSku();
    verify(discreteOrderItem).getCategory();
    verify(discreteOrderItem, atLeast(1)).getPersonalMessage();
    verify(discreteOrderItem).getQuantity();
    verify(personalMessageImpl).getOccasion();
    verify(orderItemService).createPersonalMessage();
  }

  /**
   * Test {@link LegacyOrderServiceImpl#createDiscreteOrderItemRequest(DiscreteOrderItem)} with {@code discreteOrderItem}.
   * <ul>
   *   <li>Then calls {@link PersonalMessageImpl#setOccasion(String)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LegacyOrderServiceImpl#createDiscreteOrderItemRequest(DiscreteOrderItem)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "DiscreteOrderItemRequest LegacyOrderServiceImpl.createDiscreteOrderItemRequest(DiscreteOrderItem)"})
  public void testCreateDiscreteOrderItemRequestWithDiscreteOrderItem_thenCallsSetOccasion() {
    // Arrange
    PersonalMessageImpl personalMessageImpl = mock(PersonalMessageImpl.class);
    doThrow(new RequiredAttributeNotProvidedException("Attribute Name")).when(personalMessageImpl)
        .setOccasion(Mockito.<String>any());
    when(orderItemService.createPersonalMessage()).thenReturn(personalMessageImpl);
    DiscreteOrderItem discreteOrderItem = mock(DiscreteOrderItem.class);
    when(discreteOrderItem.getQuantity()).thenReturn(1);
    when(discreteOrderItem.getCategory()).thenReturn(new CategoryImpl());
    when(discreteOrderItem.getProduct()).thenReturn(new ProductBundleImpl());
    when(discreteOrderItem.getSku()).thenReturn(new SkuImpl());
    when(discreteOrderItem.getPersonalMessage()).thenReturn(new PersonalMessageImpl());

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> legacyOrderServiceImpl.createDiscreteOrderItemRequest(discreteOrderItem));
    verify(discreteOrderItem).getProduct();
    verify(discreteOrderItem).getSku();
    verify(discreteOrderItem).getCategory();
    verify(discreteOrderItem, atLeast(1)).getPersonalMessage();
    verify(discreteOrderItem).getQuantity();
    verify(personalMessageImpl).setOccasion(isNull());
    verify(orderItemService).createPersonalMessage();
  }

  /**
   * Test {@link LegacyOrderServiceImpl#createDiscreteOrderItemRequest(DiscreteOrderItem)} with {@code discreteOrderItem}.
   * <ul>
   *   <li>Then return Category is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LegacyOrderServiceImpl#createDiscreteOrderItemRequest(DiscreteOrderItem)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "DiscreteOrderItemRequest LegacyOrderServiceImpl.createDiscreteOrderItemRequest(DiscreteOrderItem)"})
  public void testCreateDiscreteOrderItemRequestWithDiscreteOrderItem_thenReturnCategoryIsNull() {
    // Arrange and Act
    DiscreteOrderItemRequest actualCreateDiscreteOrderItemRequestResult = legacyOrderServiceImpl
        .createDiscreteOrderItemRequest(new DiscreteOrderItemImpl());

    // Assert
    assertNull(actualCreateDiscreteOrderItemRequestResult.getCategory());
    assertNull(actualCreateDiscreteOrderItemRequestResult.getProduct());
    assertNull(actualCreateDiscreteOrderItemRequestResult.getSku());
    assertNull(actualCreateDiscreteOrderItemRequestResult.getPersonalMessage());
    assertEquals(0, actualCreateDiscreteOrderItemRequestResult.getQuantity());
  }

  /**
   * Test {@link LegacyOrderServiceImpl#createDiscreteOrderItemRequest(Order, BundleOrderItem, Sku, Product, Category, Integer, Map)} with {@code order}, {@code bundleOrderItem}, {@code sku}, {@code product}, {@code category}, {@code quantity}, {@code itemAttributes}.
   * <p>
   * Method under test: {@link LegacyOrderServiceImpl#createDiscreteOrderItemRequest(Order, BundleOrderItem, Sku, Product, org.broadleafcommerce.core.catalog.domain.Category, Integer, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "DiscreteOrderItemRequest LegacyOrderServiceImpl.createDiscreteOrderItemRequest(Order, BundleOrderItem, Sku, Product, org.broadleafcommerce.core.catalog.domain.Category, Integer, Map)"})
  public void testCreateDiscreteOrderItemRequestWithOrderBundleOrderItemSkuProductCategoryQuantityItemAttributes() {
    // Arrange
    NullOrderImpl order = new NullOrderImpl();
    BundleOrderItemImpl bundleOrderItem = new BundleOrderItemImpl();
    SkuImpl sku = new SkuImpl();
    ProductBundleImpl product = new ProductBundleImpl();
    CategoryImpl category = new CategoryImpl();

    // Act
    DiscreteOrderItemRequest actualCreateDiscreteOrderItemRequestResult = legacyOrderServiceImpl
        .createDiscreteOrderItemRequest(order, bundleOrderItem, sku, product, category, 1, new HashMap<>());

    // Assert
    org.broadleafcommerce.core.catalog.domain.Category category2 = actualCreateDiscreteOrderItemRequestResult
        .getCategory();
    assertTrue(category2 instanceof CategoryImpl);
    Product product2 = actualCreateDiscreteOrderItemRequestResult.getProduct();
    assertTrue(product2 instanceof ProductBundleImpl);
    Sku sku2 = actualCreateDiscreteOrderItemRequestResult.getSku();
    assertTrue(sku2 instanceof SkuImpl);
    BundleOrderItem bundleOrderItem2 = actualCreateDiscreteOrderItemRequestResult.getBundleOrderItem();
    assertTrue(bundleOrderItem2 instanceof BundleOrderItemImpl);
    Order order2 = actualCreateDiscreteOrderItemRequestResult.getOrder();
    assertTrue(order2 instanceof NullOrderImpl);
    assertNull(actualCreateDiscreteOrderItemRequestResult.getRetailPriceOverride());
    assertNull(actualCreateDiscreteOrderItemRequestResult.getSalePriceOverride());
    assertNull(actualCreateDiscreteOrderItemRequestResult.getPersonalMessage());
    assertEquals(1, actualCreateDiscreteOrderItemRequestResult.getQuantity());
    assertTrue(actualCreateDiscreteOrderItemRequestResult.getDiscreteOrderItemFeePrices().isEmpty());
    assertTrue(actualCreateDiscreteOrderItemRequestResult.getAdditionalAttributes().isEmpty());
    assertTrue(actualCreateDiscreteOrderItemRequestResult.getItemAttributes().isEmpty());
    assertSame(category, category2);
    assertSame(product, product2);
    assertSame(sku, sku2);
    assertSame(bundleOrderItem, bundleOrderItem2);
    assertSame(order, order2);
  }

  /**
   * Test {@link LegacyOrderServiceImpl#createDiscreteOrderItemRequest(Long, Long, Long, Long, Integer)} with {@code orderId}, {@code skuId}, {@code productId}, {@code categoryId}, {@code quantity}.
   * <p>
   * Method under test: {@link LegacyOrderServiceImpl#createDiscreteOrderItemRequest(Long, Long, Long, Long, Integer)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "DiscreteOrderItemRequest LegacyOrderServiceImpl.createDiscreteOrderItemRequest(Long, Long, Long, Long, Integer)"})
  public void testCreateDiscreteOrderItemRequestWithOrderIdSkuIdProductIdCategoryIdQuantity() {
    // Arrange
    when(orderDao.readOrderById(Mockito.<Long>any())).thenReturn(new NullOrderImpl());
    when(categoryDao.readCategoryById(Mockito.<Long>any())).thenReturn(new CategoryImpl());
    when(productDao.readProductById(Mockito.<Long>any())).thenReturn(new ProductBundleImpl());
    when(skuDao.readSkuById(Mockito.<Long>any())).thenReturn(new SkuImpl());

    // Act
    DiscreteOrderItemRequest actualCreateDiscreteOrderItemRequestResult = legacyOrderServiceImpl
        .createDiscreteOrderItemRequest(1L, 1L, 1L, 1L, 1);

    // Assert
    verify(categoryDao).readCategoryById(eq(1L));
    verify(productDao).readProductById(eq(1L));
    verify(skuDao).readSkuById(eq(1L));
    verify(orderDao).readOrderById(eq(1L));
    assertTrue(actualCreateDiscreteOrderItemRequestResult.getProduct() instanceof ProductBundleImpl);
    assertTrue(actualCreateDiscreteOrderItemRequestResult.getSku() instanceof SkuImpl);
    assertTrue(actualCreateDiscreteOrderItemRequestResult.getOrder() instanceof NullOrderImpl);
  }

  /**
   * Test {@link LegacyOrderServiceImpl#createDiscreteOrderItemRequest(Long, Long, Long, Long, Integer)} with {@code orderId}, {@code skuId}, {@code productId}, {@code categoryId}, {@code quantity}.
   * <p>
   * Method under test: {@link LegacyOrderServiceImpl#createDiscreteOrderItemRequest(Long, Long, Long, Long, Integer)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "DiscreteOrderItemRequest LegacyOrderServiceImpl.createDiscreteOrderItemRequest(Long, Long, Long, Long, Integer)"})
  public void testCreateDiscreteOrderItemRequestWithOrderIdSkuIdProductIdCategoryIdQuantity2() {
    // Arrange
    when(skuDao.readSkuById(Mockito.<Long>any())).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> legacyOrderServiceImpl.createDiscreteOrderItemRequest(1L, 1L, 1L, 1L, 1));
    verify(skuDao).readSkuById(eq(1L));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#createDiscreteOrderItemRequest(Long, Long, Long, Long, Integer)} with {@code orderId}, {@code skuId}, {@code productId}, {@code categoryId}, {@code quantity}.
   * <p>
   * Method under test: {@link LegacyOrderServiceImpl#createDiscreteOrderItemRequest(Long, Long, Long, Long, Integer)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "DiscreteOrderItemRequest LegacyOrderServiceImpl.createDiscreteOrderItemRequest(Long, Long, Long, Long, Integer)"})
  public void testCreateDiscreteOrderItemRequestWithOrderIdSkuIdProductIdCategoryIdQuantity3() {
    // Arrange
    when(orderDao.readOrderById(Mockito.<Long>any())).thenReturn(new NullOrderImpl());
    when(categoryDao.readCategoryById(Mockito.<Long>any())).thenReturn(new CategoryImpl());
    when(skuDao.readSkuById(Mockito.<Long>any())).thenReturn(new SkuImpl());

    // Act
    DiscreteOrderItemRequest actualCreateDiscreteOrderItemRequestResult = legacyOrderServiceImpl
        .createDiscreteOrderItemRequest(1L, 1L, null, 1L, 1);

    // Assert
    verify(categoryDao).readCategoryById(eq(1L));
    verify(skuDao).readSkuById(eq(1L));
    verify(orderDao).readOrderById(eq(1L));
    Sku sku = actualCreateDiscreteOrderItemRequestResult.getSku();
    assertTrue(sku instanceof SkuImpl);
    Order order = actualCreateDiscreteOrderItemRequestResult.getOrder();
    assertTrue(order instanceof NullOrderImpl);
    assertNull(actualCreateDiscreteOrderItemRequestResult.getProduct());
    BigDecimal expectedAmount = new BigDecimal("0.00");
    Money orderAdjustmentsValue = order.getOrderAdjustmentsValue();
    assertEquals(expectedAmount, orderAdjustmentsValue.getAmount());
    assertEquals(orderAdjustmentsValue, orderAdjustmentsValue.abs());
    assertEquals(orderAdjustmentsValue, orderAdjustmentsValue.zero());
    assertEquals(orderAdjustmentsValue, order.getSubTotal());
    assertSame(orderAdjustmentsValue, sku.getMargin());
  }

  /**
   * Test {@link LegacyOrderServiceImpl#createDiscreteOrderItemRequest(Long, Long, Long, Long, Integer)} with {@code orderId}, {@code skuId}, {@code productId}, {@code categoryId}, {@code quantity}.
   * <p>
   * Method under test: {@link LegacyOrderServiceImpl#createDiscreteOrderItemRequest(Long, Long, Long, Long, Integer)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "DiscreteOrderItemRequest LegacyOrderServiceImpl.createDiscreteOrderItemRequest(Long, Long, Long, Long, Integer)"})
  public void testCreateDiscreteOrderItemRequestWithOrderIdSkuIdProductIdCategoryIdQuantity4() {
    // Arrange
    when(orderDao.readOrderById(Mockito.<Long>any())).thenReturn(new NullOrderImpl());
    when(productDao.readProductById(Mockito.<Long>any())).thenReturn(new ProductBundleImpl());
    when(skuDao.readSkuById(Mockito.<Long>any())).thenReturn(new SkuImpl());

    // Act
    DiscreteOrderItemRequest actualCreateDiscreteOrderItemRequestResult = legacyOrderServiceImpl
        .createDiscreteOrderItemRequest(1L, 1L, 1L, null, 1);

    // Assert
    verify(productDao).readProductById(eq(1L));
    verify(skuDao).readSkuById(eq(1L));
    verify(orderDao).readOrderById(eq(1L));
    assertTrue(actualCreateDiscreteOrderItemRequestResult.getProduct() instanceof ProductBundleImpl);
    assertTrue(actualCreateDiscreteOrderItemRequestResult.getSku() instanceof SkuImpl);
    assertTrue(actualCreateDiscreteOrderItemRequestResult.getOrder() instanceof NullOrderImpl);
    assertNull(actualCreateDiscreteOrderItemRequestResult.getCategory());
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addBundleItemToOrder(Order, BundleOrderItemRequest, boolean)} with {@code order}, {@code itemRequest}, {@code priceOrder}.
   * <p>
   * Method under test: {@link LegacyOrderServiceImpl#addBundleItemToOrder(Order, BundleOrderItemRequest, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"OrderItem LegacyOrderServiceImpl.addBundleItemToOrder(Order, BundleOrderItemRequest, boolean)"})
  public void testAddBundleItemToOrderWithOrderItemRequestPriceOrder() throws PricingException {
    // Arrange
    when(orderItemService.createBundleOrderItem(Mockito.<BundleOrderItemRequest>any()))
        .thenThrow(new IllegalArgumentException("foo"));
    NullOrderImpl order = new NullOrderImpl();

    BundleOrderItemRequest itemRequest = new BundleOrderItemRequest();
    itemRequest.setBundleOrderItemFeePrices(new ArrayList<>());
    itemRequest.setCategory(new CategoryImpl());
    itemRequest.setDiscreteOrderItems(new ArrayList<>());
    itemRequest.setName("Name");
    itemRequest.setOrder(new NullOrderImpl());
    itemRequest.setQuantity(1);
    itemRequest.setRetailPriceOverride(new Money());
    itemRequest.setSalePriceOverride(new Money());

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> legacyOrderServiceImpl.addBundleItemToOrder(order, itemRequest, true));
    verify(orderItemService).createBundleOrderItem(isA(BundleOrderItemRequest.class));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addBundleItemToOrder(Order, BundleOrderItemRequest)} with {@code order}, {@code itemRequest}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LegacyOrderServiceImpl#addBundleItemToOrder(Order, BundleOrderItemRequest)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"OrderItem LegacyOrderServiceImpl.addBundleItemToOrder(Order, BundleOrderItemRequest)"})
  public void testAddBundleItemToOrderWithOrderItemRequest_thenThrowIllegalArgumentException() throws PricingException {
    // Arrange
    when(orderItemService.createBundleOrderItem(Mockito.<BundleOrderItemRequest>any()))
        .thenThrow(new IllegalArgumentException("foo"));
    NullOrderImpl order = new NullOrderImpl();

    BundleOrderItemRequest itemRequest = new BundleOrderItemRequest();
    itemRequest.setBundleOrderItemFeePrices(new ArrayList<>());
    itemRequest.setCategory(new CategoryImpl());
    itemRequest.setDiscreteOrderItems(new ArrayList<>());
    itemRequest.setName("Name");
    itemRequest.setOrder(new NullOrderImpl());
    itemRequest.setQuantity(1);
    itemRequest.setRetailPriceOverride(new Money());
    itemRequest.setSalePriceOverride(new Money());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> legacyOrderServiceImpl.addBundleItemToOrder(order, itemRequest));
    verify(orderItemService).createBundleOrderItem(isA(BundleOrderItemRequest.class));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#removeItemFromOrder(Long, Long, boolean)} with {@code orderId}, {@code itemId}, {@code priceOrder}.
   * <p>
   * Method under test: {@link LegacyOrderServiceImpl#removeItemFromOrder(Long, Long, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Order LegacyOrderServiceImpl.removeItemFromOrder(Long, Long, boolean)"})
  public void testRemoveItemFromOrderWithOrderIdItemIdPriceOrder() throws PricingException {
    // Arrange
    when(orderDao.readOrderById(Mockito.<Long>any())).thenReturn(new NullOrderImpl());
    when(orderItemService.readOrderItemById(Mockito.<Long>any())).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> legacyOrderServiceImpl.removeItemFromOrder(1L, 1L, true));
    verify(orderDao).readOrderById(eq(1L));
    verify(orderItemService).readOrderItemById(eq(1L));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#removeItemFromOrder(Long, Long)} with {@code orderId}, {@code itemId}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LegacyOrderServiceImpl#removeItemFromOrder(Long, Long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Order LegacyOrderServiceImpl.removeItemFromOrder(Long, Long)"})
  public void testRemoveItemFromOrderWithOrderIdItemId_thenThrowIllegalArgumentException() throws PricingException {
    // Arrange
    when(orderDao.readOrderById(Mockito.<Long>any())).thenReturn(new NullOrderImpl());
    when(orderItemService.readOrderItemById(Mockito.<Long>any())).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> legacyOrderServiceImpl.removeItemFromOrder(1L, 1L));
    verify(orderDao).readOrderById(eq(1L));
    verify(orderItemService).readOrderItemById(eq(1L));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#removeItemFromOrder(Order, OrderItem, boolean)} with {@code order}, {@code item}, {@code priceOrder}.
   * <p>
   * Method under test: {@link LegacyOrderServiceImpl#removeItemFromOrder(Order, OrderItem, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Order LegacyOrderServiceImpl.removeItemFromOrder(Order, OrderItem, boolean)"})
  public void testRemoveItemFromOrderWithOrderItemPriceOrder() throws PricingException {
    // Arrange
    doThrow(new IllegalArgumentException("foo")).when(fulfillmentGroupService)
        .removeOrderItemFromFullfillmentGroups(Mockito.<Order>any(), Mockito.<OrderItem>any());
    NullOrderImpl order = new NullOrderImpl();

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> legacyOrderServiceImpl.removeItemFromOrder(order, new BundleOrderItemImpl(), true));
    verify(fulfillmentGroupService).removeOrderItemFromFullfillmentGroups(isA(Order.class), isA(OrderItem.class));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#removeItemFromOrder(Order, OrderItem, boolean)} with {@code order}, {@code item}, {@code priceOrder}.
   * <p>
   * Method under test: {@link LegacyOrderServiceImpl#removeItemFromOrder(Order, OrderItem, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Order LegacyOrderServiceImpl.removeItemFromOrder(Order, OrderItem, boolean)"})
  public void testRemoveItemFromOrderWithOrderItemPriceOrder2() throws PricingException {
    // Arrange
    doNothing().when(fulfillmentGroupService)
        .removeOrderItemFromFullfillmentGroups(Mockito.<Order>any(), Mockito.<OrderItem>any());
    doNothing().when(orderItemService).delete(Mockito.<OrderItem>any());
    when(pricingService.executePricing(Mockito.<Order>any())).thenThrow(new IllegalArgumentException("foo"));

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    ArrayList<OrderItem> orderItems = new ArrayList<>();
    orderItems.add(new BundleOrderItemImpl());

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCurrency(new BroadleafCurrencyImpl());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
    order.setFulfillmentGroups(new ArrayList<>());
    order.setId(1L);
    order.setLocale(new LocaleImpl());
    order.setName("Name");
    order.setOrderAttributes(new HashMap<>());
    order.setOrderMessages(new ArrayList<>());
    order.setOrderNumber("42");
    order.setPayments(new ArrayList<>());
    order.setStatus(OrderStatus.ARCHIVED);
    order.setSubTotal(new Money());
    order.setSubmitDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());
    order.setOrderItems(orderItems);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> legacyOrderServiceImpl.removeItemFromOrder(order, new BundleOrderItemImpl(), true));
    verify(fulfillmentGroupService).removeOrderItemFromFullfillmentGroups(isA(Order.class), isA(OrderItem.class));
    verify(orderItemService).delete(isA(OrderItem.class));
    verify(pricingService).executePricing(isA(Order.class));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#removeItemFromOrder(Order, OrderItem, boolean)} with {@code order}, {@code item}, {@code priceOrder}.
   * <ul>
   *   <li>Then return {@link NullOrderImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link LegacyOrderServiceImpl#removeItemFromOrder(Order, OrderItem, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Order LegacyOrderServiceImpl.removeItemFromOrder(Order, OrderItem, boolean)"})
  public void testRemoveItemFromOrderWithOrderItemPriceOrder_thenReturnNullOrderImpl() throws PricingException {
    // Arrange
    doNothing().when(fulfillmentGroupService)
        .removeOrderItemFromFullfillmentGroups(Mockito.<Order>any(), Mockito.<OrderItem>any());
    NullOrderImpl nullOrderImpl = new NullOrderImpl();
    when(orderDao.save(Mockito.<Order>any())).thenReturn(nullOrderImpl);
    doNothing().when(orderItemService).delete(Mockito.<OrderItem>any());
    when(pricingService.executePricing(Mockito.<Order>any())).thenReturn(new NullOrderImpl());

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    ArrayList<OrderItem> orderItems = new ArrayList<>();
    orderItems.add(new BundleOrderItemImpl());

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCurrency(new BroadleafCurrencyImpl());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
    order.setFulfillmentGroups(new ArrayList<>());
    order.setId(1L);
    order.setLocale(new LocaleImpl());
    order.setName("Name");
    order.setOrderAttributes(new HashMap<>());
    order.setOrderMessages(new ArrayList<>());
    order.setOrderNumber("42");
    order.setPayments(new ArrayList<>());
    order.setStatus(OrderStatus.ARCHIVED);
    order.setSubTotal(new Money());
    order.setSubmitDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());
    order.setOrderItems(orderItems);

    // Act
    Order actualRemoveItemFromOrderResult = legacyOrderServiceImpl.removeItemFromOrder(order, new BundleOrderItemImpl(),
        true);

    // Assert
    verify(orderDao).save(isA(Order.class));
    verify(fulfillmentGroupService).removeOrderItemFromFullfillmentGroups(isA(Order.class), isA(OrderItem.class));
    verify(orderItemService).delete(isA(OrderItem.class));
    verify(pricingService).executePricing(isA(Order.class));
    assertSame(nullOrderImpl, actualRemoveItemFromOrderResult);
  }

  /**
   * Test {@link LegacyOrderServiceImpl#removeItemFromOrder(Order, OrderItem)} with {@code order}, {@code item}.
   * <ul>
   *   <li>Then return {@link NullOrderImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link LegacyOrderServiceImpl#removeItemFromOrder(Order, OrderItem)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Order LegacyOrderServiceImpl.removeItemFromOrder(Order, OrderItem)"})
  public void testRemoveItemFromOrderWithOrderItem_thenReturnNullOrderImpl() throws PricingException {
    // Arrange
    doNothing().when(fulfillmentGroupService)
        .removeOrderItemFromFullfillmentGroups(Mockito.<Order>any(), Mockito.<OrderItem>any());
    NullOrderImpl nullOrderImpl = new NullOrderImpl();
    when(orderDao.save(Mockito.<Order>any())).thenReturn(nullOrderImpl);
    doNothing().when(orderItemService).delete(Mockito.<OrderItem>any());
    when(pricingService.executePricing(Mockito.<Order>any())).thenReturn(new NullOrderImpl());

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    ArrayList<OrderItem> orderItems = new ArrayList<>();
    orderItems.add(new BundleOrderItemImpl());

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCurrency(new BroadleafCurrencyImpl());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
    order.setFulfillmentGroups(new ArrayList<>());
    order.setId(1L);
    order.setLocale(new LocaleImpl());
    order.setName("Name");
    order.setOrderAttributes(new HashMap<>());
    order.setOrderMessages(new ArrayList<>());
    order.setOrderNumber("42");
    order.setPayments(new ArrayList<>());
    order.setStatus(OrderStatus.ARCHIVED);
    order.setSubTotal(new Money());
    order.setSubmitDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());
    order.setOrderItems(orderItems);

    // Act
    Order actualRemoveItemFromOrderResult = legacyOrderServiceImpl.removeItemFromOrder(order,
        new BundleOrderItemImpl());

    // Assert
    verify(orderDao).save(isA(Order.class));
    verify(fulfillmentGroupService).removeOrderItemFromFullfillmentGroups(isA(Order.class), isA(OrderItem.class));
    verify(orderItemService).delete(isA(OrderItem.class));
    verify(pricingService).executePricing(isA(Order.class));
    assertSame(nullOrderImpl, actualRemoveItemFromOrderResult);
  }

  /**
   * Test {@link LegacyOrderServiceImpl#removeItemFromOrder(Order, OrderItem)} with {@code order}, {@code item}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LegacyOrderServiceImpl#removeItemFromOrder(Order, OrderItem)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Order LegacyOrderServiceImpl.removeItemFromOrder(Order, OrderItem)"})
  public void testRemoveItemFromOrderWithOrderItem_thenThrowIllegalArgumentException() throws PricingException {
    // Arrange
    doNothing().when(fulfillmentGroupService)
        .removeOrderItemFromFullfillmentGroups(Mockito.<Order>any(), Mockito.<OrderItem>any());
    doNothing().when(orderItemService).delete(Mockito.<OrderItem>any());
    when(pricingService.executePricing(Mockito.<Order>any())).thenThrow(new IllegalArgumentException("foo"));

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    ArrayList<OrderItem> orderItems = new ArrayList<>();
    orderItems.add(new BundleOrderItemImpl());

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCurrency(new BroadleafCurrencyImpl());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
    order.setFulfillmentGroups(new ArrayList<>());
    order.setId(1L);
    order.setLocale(new LocaleImpl());
    order.setName("Name");
    order.setOrderAttributes(new HashMap<>());
    order.setOrderMessages(new ArrayList<>());
    order.setOrderNumber("42");
    order.setPayments(new ArrayList<>());
    order.setStatus(OrderStatus.ARCHIVED);
    order.setSubTotal(new Money());
    order.setSubmitDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());
    order.setOrderItems(orderItems);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> legacyOrderServiceImpl.removeItemFromOrder(order, new BundleOrderItemImpl()));
    verify(fulfillmentGroupService).removeOrderItemFromFullfillmentGroups(isA(Order.class), isA(OrderItem.class));
    verify(orderItemService).delete(isA(OrderItem.class));
    verify(pricingService).executePricing(isA(Order.class));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#moveItemToOrder(Order, Order, OrderItem)} with {@code originalOrder}, {@code destinationOrder}, {@code item}.
   * <p>
   * Method under test: {@link LegacyOrderServiceImpl#moveItemToOrder(Order, Order, OrderItem)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Order LegacyOrderServiceImpl.moveItemToOrder(Order, Order, OrderItem)"})
  public void testMoveItemToOrderWithOriginalOrderDestinationOrderItem() throws PricingException {
    // Arrange
    doThrow(new IllegalArgumentException("foo")).when(fulfillmentGroupService)
        .removeOrderItemFromFullfillmentGroups(Mockito.<Order>any(), Mockito.<OrderItem>any());
    NullOrderImpl originalOrder = new NullOrderImpl();
    NullOrderImpl destinationOrder = new NullOrderImpl();

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> legacyOrderServiceImpl.moveItemToOrder(originalOrder, destinationOrder, new BundleOrderItemImpl()));
    verify(fulfillmentGroupService).removeOrderItemFromFullfillmentGroups(isA(Order.class), isA(OrderItem.class));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#moveItemToOrder(Order, Order, OrderItem, boolean)} with {@code originalOrder}, {@code destinationOrder}, {@code item}, {@code priceOrder}.
   * <p>
   * Method under test: {@link LegacyOrderServiceImpl#moveItemToOrder(Order, Order, OrderItem, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Order LegacyOrderServiceImpl.moveItemToOrder(Order, Order, OrderItem, boolean)"})
  public void testMoveItemToOrderWithOriginalOrderDestinationOrderItemPriceOrder() throws PricingException {
    // Arrange
    doThrow(new IllegalArgumentException("foo")).when(fulfillmentGroupService)
        .removeOrderItemFromFullfillmentGroups(Mockito.<Order>any(), Mockito.<OrderItem>any());
    NullOrderImpl originalOrder = new NullOrderImpl();
    NullOrderImpl destinationOrder = new NullOrderImpl();

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> legacyOrderServiceImpl.moveItemToOrder(originalOrder, destinationOrder, new BundleOrderItemImpl(), true));
    verify(fulfillmentGroupService).removeOrderItemFromFullfillmentGroups(isA(Order.class), isA(OrderItem.class));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addFulfillmentGroupToOrder(FulfillmentGroupRequest)} with {@code fulfillmentGroupRequest}.
   * <p>
   * Method under test: {@link LegacyOrderServiceImpl#addFulfillmentGroupToOrder(FulfillmentGroupRequest)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FulfillmentGroup LegacyOrderServiceImpl.addFulfillmentGroupToOrder(FulfillmentGroupRequest)"})
  public void testAddFulfillmentGroupToOrderWithFulfillmentGroupRequest() throws PricingException {
    // Arrange
    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();
    when(fulfillmentGroupDao.create()).thenReturn(fulfillmentGroupImpl);

    FulfillmentGroupRequest fulfillmentGroupRequest = new FulfillmentGroupRequest();
    fulfillmentGroupRequest.setAddress(new AddressImpl());
    fulfillmentGroupRequest.setFulfillmentGroupItemRequests(new ArrayList<>());
    fulfillmentGroupRequest.setFulfillmentType(FulfillmentType.DIGITAL);
    fulfillmentGroupRequest.setMethod("Method");
    fulfillmentGroupRequest.setOption(new FulfillmentOptionImpl());
    fulfillmentGroupRequest.setOrder(new NullOrderImpl());
    fulfillmentGroupRequest.setPhone(new PhoneImpl());
    fulfillmentGroupRequest.setService("Service");

    // Act
    FulfillmentGroup actualAddFulfillmentGroupToOrderResult = legacyOrderServiceImpl
        .addFulfillmentGroupToOrder(fulfillmentGroupRequest);

    // Assert
    verify(fulfillmentGroupDao).create();
    assertSame(fulfillmentGroupImpl, actualAddFulfillmentGroupToOrderResult);
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addFulfillmentGroupToOrder(FulfillmentGroupRequest)} with {@code fulfillmentGroupRequest}.
   * <p>
   * Method under test: {@link LegacyOrderServiceImpl#addFulfillmentGroupToOrder(FulfillmentGroupRequest)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FulfillmentGroup LegacyOrderServiceImpl.addFulfillmentGroupToOrder(FulfillmentGroupRequest)"})
  public void testAddFulfillmentGroupToOrderWithFulfillmentGroupRequest2() throws PricingException {
    // Arrange
    when(fulfillmentGroupDao.create()).thenThrow(new IllegalArgumentException("foo"));

    FulfillmentGroupRequest fulfillmentGroupRequest = new FulfillmentGroupRequest();
    fulfillmentGroupRequest.setAddress(new AddressImpl());
    fulfillmentGroupRequest.setFulfillmentGroupItemRequests(new ArrayList<>());
    fulfillmentGroupRequest.setFulfillmentType(FulfillmentType.DIGITAL);
    fulfillmentGroupRequest.setMethod("Method");
    fulfillmentGroupRequest.setOption(new FulfillmentOptionImpl());
    fulfillmentGroupRequest.setOrder(new NullOrderImpl());
    fulfillmentGroupRequest.setPhone(new PhoneImpl());
    fulfillmentGroupRequest.setService("Service");

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> legacyOrderServiceImpl.addFulfillmentGroupToOrder(fulfillmentGroupRequest));
    verify(fulfillmentGroupDao).create();
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addFulfillmentGroupToOrder(FulfillmentGroupRequest, boolean)} with {@code fulfillmentGroupRequest}, {@code priceOrder}.
   * <p>
   * Method under test: {@link LegacyOrderServiceImpl#addFulfillmentGroupToOrder(FulfillmentGroupRequest, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "FulfillmentGroup LegacyOrderServiceImpl.addFulfillmentGroupToOrder(FulfillmentGroupRequest, boolean)"})
  public void testAddFulfillmentGroupToOrderWithFulfillmentGroupRequestPriceOrder() throws PricingException {
    // Arrange
    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();
    when(fulfillmentGroupDao.create()).thenReturn(fulfillmentGroupImpl);

    FulfillmentGroupRequest fulfillmentGroupRequest = new FulfillmentGroupRequest();
    fulfillmentGroupRequest.setAddress(new AddressImpl());
    fulfillmentGroupRequest.setFulfillmentGroupItemRequests(new ArrayList<>());
    fulfillmentGroupRequest.setFulfillmentType(FulfillmentType.DIGITAL);
    fulfillmentGroupRequest.setMethod("Method");
    fulfillmentGroupRequest.setOption(new FulfillmentOptionImpl());
    fulfillmentGroupRequest.setOrder(new NullOrderImpl());
    fulfillmentGroupRequest.setPhone(new PhoneImpl());
    fulfillmentGroupRequest.setService("Service");

    // Act
    FulfillmentGroup actualAddFulfillmentGroupToOrderResult = legacyOrderServiceImpl
        .addFulfillmentGroupToOrder(fulfillmentGroupRequest, true);

    // Assert
    verify(fulfillmentGroupDao).create();
    assertSame(fulfillmentGroupImpl, actualAddFulfillmentGroupToOrderResult);
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addFulfillmentGroupToOrder(FulfillmentGroupRequest, boolean)} with {@code fulfillmentGroupRequest}, {@code priceOrder}.
   * <p>
   * Method under test: {@link LegacyOrderServiceImpl#addFulfillmentGroupToOrder(FulfillmentGroupRequest, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "FulfillmentGroup LegacyOrderServiceImpl.addFulfillmentGroupToOrder(FulfillmentGroupRequest, boolean)"})
  public void testAddFulfillmentGroupToOrderWithFulfillmentGroupRequestPriceOrder2() throws PricingException {
    // Arrange
    when(fulfillmentGroupDao.create()).thenThrow(new IllegalArgumentException("foo"));

    FulfillmentGroupRequest fulfillmentGroupRequest = new FulfillmentGroupRequest();
    fulfillmentGroupRequest.setAddress(new AddressImpl());
    fulfillmentGroupRequest.setFulfillmentGroupItemRequests(new ArrayList<>());
    fulfillmentGroupRequest.setFulfillmentType(FulfillmentType.DIGITAL);
    fulfillmentGroupRequest.setMethod("Method");
    fulfillmentGroupRequest.setOption(new FulfillmentOptionImpl());
    fulfillmentGroupRequest.setOrder(new NullOrderImpl());
    fulfillmentGroupRequest.setPhone(new PhoneImpl());
    fulfillmentGroupRequest.setService("Service");

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> legacyOrderServiceImpl.addFulfillmentGroupToOrder(fulfillmentGroupRequest, true));
    verify(fulfillmentGroupDao).create();
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addFulfillmentGroupToOrder(Order, FulfillmentGroup)} with {@code order}, {@code fulfillmentGroup}.
   * <p>
   * Method under test: {@link LegacyOrderServiceImpl#addFulfillmentGroupToOrder(Order, FulfillmentGroup)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FulfillmentGroup LegacyOrderServiceImpl.addFulfillmentGroupToOrder(Order, FulfillmentGroup)"})
  public void testAddFulfillmentGroupToOrderWithOrderFulfillmentGroup() throws PricingException {
    // Arrange
    when(pricingService.executePricing(Mockito.<Order>any())).thenThrow(new IllegalArgumentException("foo"));
    when(fulfillmentGroupDao.readDefaultFulfillmentGroupForOrder(Mockito.<Order>any()))
        .thenReturn(new FulfillmentGroupImpl());
    when(fulfillmentGroupDao.save(Mockito.<FulfillmentGroup>any())).thenReturn(new FulfillmentGroupImpl());
    OrderImpl order = new OrderImpl();

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> legacyOrderServiceImpl.addFulfillmentGroupToOrder(order, new FulfillmentGroupImpl()));
    verify(fulfillmentGroupDao).readDefaultFulfillmentGroupForOrder(isA(Order.class));
    verify(fulfillmentGroupDao).save(isA(FulfillmentGroup.class));
    verify(pricingService).executePricing(isA(Order.class));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addFulfillmentGroupToOrder(Order, FulfillmentGroup, boolean)} with {@code order}, {@code fulfillmentGroup}, {@code priceOrder}.
   * <p>
   * Method under test: {@link LegacyOrderServiceImpl#addFulfillmentGroupToOrder(Order, FulfillmentGroup, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "FulfillmentGroup LegacyOrderServiceImpl.addFulfillmentGroupToOrder(Order, FulfillmentGroup, boolean)"})
  public void testAddFulfillmentGroupToOrderWithOrderFulfillmentGroupPriceOrder() throws PricingException {
    // Arrange
    when(pricingService.executePricing(Mockito.<Order>any())).thenThrow(new IllegalArgumentException("foo"));
    when(fulfillmentGroupDao.readDefaultFulfillmentGroupForOrder(Mockito.<Order>any()))
        .thenReturn(new FulfillmentGroupImpl());
    when(fulfillmentGroupDao.save(Mockito.<FulfillmentGroup>any())).thenReturn(new FulfillmentGroupImpl());
    OrderImpl order = new OrderImpl();

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> legacyOrderServiceImpl.addFulfillmentGroupToOrder(order, new FulfillmentGroupImpl(), true));
    verify(fulfillmentGroupDao).readDefaultFulfillmentGroupForOrder(isA(Order.class));
    verify(fulfillmentGroupDao).save(isA(FulfillmentGroup.class));
    verify(pricingService).executePricing(isA(Order.class));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addItemToFulfillmentGroup(OrderItem, FulfillmentGroup)} with {@code item}, {@code fulfillmentGroup}.
   * <p>
   * Method under test: {@link LegacyOrderServiceImpl#addItemToFulfillmentGroup(OrderItem, FulfillmentGroup)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FulfillmentGroup LegacyOrderServiceImpl.addItemToFulfillmentGroup(OrderItem, FulfillmentGroup)"})
  public void testAddItemToFulfillmentGroupWithItemFulfillmentGroup() throws PricingException {
    // Arrange
    when(fulfillmentGroupDao.readDefaultFulfillmentGroupForOrder(Mockito.<Order>any()))
        .thenThrow(new RequiredAttributeNotProvidedException("Attribute Name"));

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

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable2);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCurrency(new BroadleafCurrencyImpl());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
    order.setFulfillmentGroups(new ArrayList<>());
    order.setId(1L);
    order.setLocale(new LocaleImpl());
    order.setName("Name");
    order.setOrderAttributes(new HashMap<>());
    order.setOrderItems(new ArrayList<>());
    order.setOrderMessages(new ArrayList<>());
    order.setOrderNumber("42");
    order.setPayments(new ArrayList<>());
    order.setStatus(OrderStatus.ARCHIVED);
    order.setSubTotal(new Money());
    order.setSubmitDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());

    OrderItemImpl item = new OrderItemImpl();
    item.setAuditable(auditable);
    item.setCandidateItemOffers(new ArrayList<>());
    item.setCartMessages(new ArrayList<>());
    item.setChildOrderItems(new ArrayList<>());
    item.setDiscountingAllowed(true);
    item.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    item.setHasValidationError(true);
    item.setId(1L);
    item.setName("Name");
    item.setOrder(order);
    item.setOrderItemAdjustments(new ArrayList<>());
    item.setOrderItemAttributes(new HashMap<>());
    item.setOrderItemPriceDetails(new ArrayList<>());
    item.setOrderItemQualifiers(new ArrayList<>());
    item.setOrderItemType(OrderItemType.BASIC);
    item.setParentOrderItem(new BundleOrderItemImpl());
    item.setPersonalMessage(new PersonalMessageImpl());
    item.setPrice(new Money());
    item.setProratedOrderItemAdjustments(new ArrayList<>());
    item.setQuantity(1);
    item.setRetailPrice(new Money());
    item.setRetailPriceOverride(true);
    item.setSalePrice(new Money());
    item.setSalePriceOverride(true);
    item.setTaxable(true);
    item.updateSaleAndRetailPrices();

    // Act and Assert
    assertThrows(RequiredAttributeNotProvidedException.class,
        () -> legacyOrderServiceImpl.addItemToFulfillmentGroup(item, new FulfillmentGroupImpl()));
    verify(fulfillmentGroupDao).readDefaultFulfillmentGroupForOrder(isA(Order.class));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addItemToFulfillmentGroup(OrderItem, FulfillmentGroup, boolean)} with {@code item}, {@code fulfillmentGroup}, {@code priceOrder}.
   * <p>
   * Method under test: {@link LegacyOrderServiceImpl#addItemToFulfillmentGroup(OrderItem, FulfillmentGroup, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "FulfillmentGroup LegacyOrderServiceImpl.addItemToFulfillmentGroup(OrderItem, FulfillmentGroup, boolean)"})
  public void testAddItemToFulfillmentGroupWithItemFulfillmentGroupPriceOrder() throws PricingException {
    // Arrange
    when(fulfillmentGroupDao.readDefaultFulfillmentGroupForOrder(Mockito.<Order>any()))
        .thenThrow(new RequiredAttributeNotProvidedException("Attribute Name"));

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

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable2);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCurrency(new BroadleafCurrencyImpl());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
    order.setFulfillmentGroups(new ArrayList<>());
    order.setId(1L);
    order.setLocale(new LocaleImpl());
    order.setName("Name");
    order.setOrderAttributes(new HashMap<>());
    order.setOrderItems(new ArrayList<>());
    order.setOrderMessages(new ArrayList<>());
    order.setOrderNumber("42");
    order.setPayments(new ArrayList<>());
    order.setStatus(OrderStatus.ARCHIVED);
    order.setSubTotal(new Money());
    order.setSubmitDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());

    OrderItemImpl item = new OrderItemImpl();
    item.setAuditable(auditable);
    item.setCandidateItemOffers(new ArrayList<>());
    item.setCartMessages(new ArrayList<>());
    item.setChildOrderItems(new ArrayList<>());
    item.setDiscountingAllowed(true);
    item.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    item.setHasValidationError(true);
    item.setId(1L);
    item.setName("Name");
    item.setOrder(order);
    item.setOrderItemAdjustments(new ArrayList<>());
    item.setOrderItemAttributes(new HashMap<>());
    item.setOrderItemPriceDetails(new ArrayList<>());
    item.setOrderItemQualifiers(new ArrayList<>());
    item.setOrderItemType(OrderItemType.BASIC);
    item.setParentOrderItem(new BundleOrderItemImpl());
    item.setPersonalMessage(new PersonalMessageImpl());
    item.setPrice(new Money());
    item.setProratedOrderItemAdjustments(new ArrayList<>());
    item.setQuantity(1);
    item.setRetailPrice(new Money());
    item.setRetailPriceOverride(true);
    item.setSalePrice(new Money());
    item.setSalePriceOverride(true);
    item.setTaxable(true);
    item.updateSaleAndRetailPrices();

    // Act and Assert
    assertThrows(RequiredAttributeNotProvidedException.class,
        () -> legacyOrderServiceImpl.addItemToFulfillmentGroup(item, new FulfillmentGroupImpl(), true));
    verify(fulfillmentGroupDao).readDefaultFulfillmentGroupForOrder(isA(Order.class));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addItemToFulfillmentGroup(OrderItem, FulfillmentGroup, int)} with {@code item}, {@code fulfillmentGroup}, {@code quantity}.
   * <p>
   * Method under test: {@link LegacyOrderServiceImpl#addItemToFulfillmentGroup(OrderItem, FulfillmentGroup, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "FulfillmentGroup LegacyOrderServiceImpl.addItemToFulfillmentGroup(OrderItem, FulfillmentGroup, int)"})
  public void testAddItemToFulfillmentGroupWithItemFulfillmentGroupQuantity() throws PricingException {
    // Arrange
    when(fulfillmentGroupDao.readDefaultFulfillmentGroupForOrder(Mockito.<Order>any()))
        .thenThrow(new RequiredAttributeNotProvidedException("Attribute Name"));

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

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable2);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCurrency(new BroadleafCurrencyImpl());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
    order.setFulfillmentGroups(new ArrayList<>());
    order.setId(1L);
    order.setLocale(new LocaleImpl());
    order.setName("Name");
    order.setOrderAttributes(new HashMap<>());
    order.setOrderItems(new ArrayList<>());
    order.setOrderMessages(new ArrayList<>());
    order.setOrderNumber("42");
    order.setPayments(new ArrayList<>());
    order.setStatus(OrderStatus.ARCHIVED);
    order.setSubTotal(new Money());
    order.setSubmitDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());

    OrderItemImpl item = new OrderItemImpl();
    item.setAuditable(auditable);
    item.setCandidateItemOffers(new ArrayList<>());
    item.setCartMessages(new ArrayList<>());
    item.setChildOrderItems(new ArrayList<>());
    item.setDiscountingAllowed(true);
    item.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    item.setHasValidationError(true);
    item.setId(1L);
    item.setName("Name");
    item.setOrder(order);
    item.setOrderItemAdjustments(new ArrayList<>());
    item.setOrderItemAttributes(new HashMap<>());
    item.setOrderItemPriceDetails(new ArrayList<>());
    item.setOrderItemQualifiers(new ArrayList<>());
    item.setOrderItemType(OrderItemType.BASIC);
    item.setParentOrderItem(new BundleOrderItemImpl());
    item.setPersonalMessage(new PersonalMessageImpl());
    item.setPrice(new Money());
    item.setProratedOrderItemAdjustments(new ArrayList<>());
    item.setQuantity(1);
    item.setRetailPrice(new Money());
    item.setRetailPriceOverride(true);
    item.setSalePrice(new Money());
    item.setSalePriceOverride(true);
    item.setTaxable(true);
    item.updateSaleAndRetailPrices();

    // Act and Assert
    assertThrows(RequiredAttributeNotProvidedException.class,
        () -> legacyOrderServiceImpl.addItemToFulfillmentGroup(item, new FulfillmentGroupImpl(), 2));
    verify(fulfillmentGroupDao).readDefaultFulfillmentGroupForOrder(isA(Order.class));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addItemToFulfillmentGroup(OrderItem, FulfillmentGroup, int, boolean)} with {@code item}, {@code fulfillmentGroup}, {@code quantity}, {@code priceOrder}.
   * <p>
   * Method under test: {@link LegacyOrderServiceImpl#addItemToFulfillmentGroup(OrderItem, FulfillmentGroup, int, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "FulfillmentGroup LegacyOrderServiceImpl.addItemToFulfillmentGroup(OrderItem, FulfillmentGroup, int, boolean)"})
  public void testAddItemToFulfillmentGroupWithItemFulfillmentGroupQuantityPriceOrder() throws PricingException {
    // Arrange
    when(fulfillmentGroupDao.readDefaultFulfillmentGroupForOrder(Mockito.<Order>any()))
        .thenThrow(new RequiredAttributeNotProvidedException("Attribute Name"));

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

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable2);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCurrency(new BroadleafCurrencyImpl());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
    order.setFulfillmentGroups(new ArrayList<>());
    order.setId(1L);
    order.setLocale(new LocaleImpl());
    order.setName("Name");
    order.setOrderAttributes(new HashMap<>());
    order.setOrderItems(new ArrayList<>());
    order.setOrderMessages(new ArrayList<>());
    order.setOrderNumber("42");
    order.setPayments(new ArrayList<>());
    order.setStatus(OrderStatus.ARCHIVED);
    order.setSubTotal(new Money());
    order.setSubmitDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());

    OrderItemImpl item = new OrderItemImpl();
    item.setAuditable(auditable);
    item.setCandidateItemOffers(new ArrayList<>());
    item.setCartMessages(new ArrayList<>());
    item.setChildOrderItems(new ArrayList<>());
    item.setDiscountingAllowed(true);
    item.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    item.setHasValidationError(true);
    item.setId(1L);
    item.setName("Name");
    item.setOrder(order);
    item.setOrderItemAdjustments(new ArrayList<>());
    item.setOrderItemAttributes(new HashMap<>());
    item.setOrderItemPriceDetails(new ArrayList<>());
    item.setOrderItemQualifiers(new ArrayList<>());
    item.setOrderItemType(OrderItemType.BASIC);
    item.setParentOrderItem(new BundleOrderItemImpl());
    item.setPersonalMessage(new PersonalMessageImpl());
    item.setPrice(new Money());
    item.setProratedOrderItemAdjustments(new ArrayList<>());
    item.setQuantity(1);
    item.setRetailPrice(new Money());
    item.setRetailPriceOverride(true);
    item.setSalePrice(new Money());
    item.setSalePriceOverride(true);
    item.setTaxable(true);
    item.updateSaleAndRetailPrices();

    // Act and Assert
    assertThrows(RequiredAttributeNotProvidedException.class,
        () -> legacyOrderServiceImpl.addItemToFulfillmentGroup(item, new FulfillmentGroupImpl(), 2, true));
    verify(fulfillmentGroupDao).readDefaultFulfillmentGroupForOrder(isA(Order.class));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addItemToFulfillmentGroup(Order, OrderItem, FulfillmentGroup, int, boolean)} with {@code order}, {@code item}, {@code fulfillmentGroup}, {@code quantity}, {@code priceOrder}.
   * <p>
   * Method under test: {@link LegacyOrderServiceImpl#addItemToFulfillmentGroup(Order, OrderItem, FulfillmentGroup, int, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "FulfillmentGroup LegacyOrderServiceImpl.addItemToFulfillmentGroup(Order, OrderItem, FulfillmentGroup, int, boolean)"})
  public void testAddItemToFulfillmentGroupWithOrderItemFulfillmentGroupQuantityPriceOrder() throws PricingException {
    // Arrange
    when(fulfillmentGroupDao.readDefaultFulfillmentGroupForOrder(Mockito.<Order>any()))
        .thenThrow(new RequiredAttributeNotProvidedException("Attribute Name"));

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCurrency(new BroadleafCurrencyImpl());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
    order.setFulfillmentGroups(new ArrayList<>());
    order.setId(1L);
    order.setLocale(new LocaleImpl());
    order.setName("Name");
    order.setOrderAttributes(new HashMap<>());
    order.setOrderItems(new ArrayList<>());
    order.setOrderMessages(new ArrayList<>());
    order.setOrderNumber("42");
    order.setPayments(new ArrayList<>());
    order.setStatus(OrderStatus.ARCHIVED);
    order.setSubTotal(new Money());
    order.setSubmitDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());
    BundleOrderItemImpl item = new BundleOrderItemImpl();

    // Act and Assert
    assertThrows(RequiredAttributeNotProvidedException.class,
        () -> legacyOrderServiceImpl.addItemToFulfillmentGroup(order, item, new FulfillmentGroupImpl(), 2, true));
    verify(fulfillmentGroupDao).readDefaultFulfillmentGroupForOrder(isA(Order.class));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addItemToFulfillmentGroup(Order, OrderItem, FulfillmentGroup, int, boolean)} with {@code order}, {@code item}, {@code fulfillmentGroup}, {@code quantity}, {@code priceOrder}.
   * <p>
   * Method under test: {@link LegacyOrderServiceImpl#addItemToFulfillmentGroup(Order, OrderItem, FulfillmentGroup, int, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "FulfillmentGroup LegacyOrderServiceImpl.addItemToFulfillmentGroup(Order, OrderItem, FulfillmentGroup, int, boolean)"})
  public void testAddItemToFulfillmentGroupWithOrderItemFulfillmentGroupQuantityPriceOrder2() throws PricingException {
    // Arrange
    when(orderDao.save(Mockito.<Order>any())).thenReturn(new NullOrderImpl());
    when(pricingService.executePricing(Mockito.<Order>any())).thenReturn(new NullOrderImpl());
    when(fulfillmentGroupItemDao.save(Mockito.<FulfillmentGroupItem>any())).thenReturn(new FulfillmentGroupItemImpl());
    when(fulfillmentGroupItemDao.create()).thenReturn(new FulfillmentGroupItemImpl());

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCurrency(new BroadleafCurrencyImpl());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
    order.setFulfillmentGroups(new ArrayList<>());
    order.setId(1L);
    order.setLocale(new LocaleImpl());
    order.setName("Name");
    order.setOrderAttributes(new HashMap<>());
    order.setOrderItems(new ArrayList<>());
    order.setOrderMessages(new ArrayList<>());
    order.setOrderNumber("42");
    order.setPayments(new ArrayList<>());
    order.setStatus(OrderStatus.ARCHIVED);
    order.setSubTotal(new Money());
    order.setSubmitDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());
    BundleOrderItemImpl item = new BundleOrderItemImpl();
    FulfillmentGroupImpl fulfillmentGroup = mock(FulfillmentGroupImpl.class);
    when(fulfillmentGroup.getId()).thenReturn(1L);
    doNothing().when(fulfillmentGroup).addFulfillmentGroupItem(Mockito.<FulfillmentGroupItem>any());

    // Act
    FulfillmentGroup actualAddItemToFulfillmentGroupResult = legacyOrderServiceImpl.addItemToFulfillmentGroup(order,
        item, fulfillmentGroup, 2, true);

    // Assert
    verify(fulfillmentGroupItemDao).create();
    verify(fulfillmentGroupItemDao).save(isA(FulfillmentGroupItem.class));
    verify(orderDao).save(isA(Order.class));
    verify(fulfillmentGroup).addFulfillmentGroupItem(isA(FulfillmentGroupItem.class));
    verify(fulfillmentGroup).getId();
    verify(pricingService).executePricing(isA(Order.class));
    assertSame(fulfillmentGroup, actualAddItemToFulfillmentGroupResult);
  }

  /**
   * Test {@link LegacyOrderServiceImpl#updateItemQuantity(Order, OrderItem, boolean)} with {@code order}, {@code item}, {@code priceOrder}.
   * <ul>
   *   <li>Then throw {@link ItemNotFoundException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LegacyOrderServiceImpl#updateItemQuantity(Order, OrderItem, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void LegacyOrderServiceImpl.updateItemQuantity(Order, OrderItem, boolean)"})
  public void testUpdateItemQuantityWithOrderItemPriceOrder_thenThrowItemNotFoundException()
      throws ItemNotFoundException, PricingException {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    ArrayList<OrderItem> orderItems = new ArrayList<>();
    orderItems.add(new BundleOrderItemImpl());

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCurrency(new BroadleafCurrencyImpl());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
    order.setFulfillmentGroups(new ArrayList<>());
    order.setId(1L);
    order.setLocale(new LocaleImpl());
    order.setName("Name");
    order.setOrderAttributes(new HashMap<>());
    order.setOrderMessages(new ArrayList<>());
    order.setOrderNumber("42");
    order.setPayments(new ArrayList<>());
    order.setStatus(OrderStatus.ARCHIVED);
    order.setSubTotal(new Money());
    order.setSubmitDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());
    order.setOrderItems(orderItems);

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(1L);
    auditable2.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(1L);

    BundleOrderItemImpl item = new BundleOrderItemImpl();
    item.setAuditable(auditable2);
    item.setBaseRetailPrice(new Money());
    item.setBaseSalePrice(new Money());
    item.setBundleOrderItemFeePrices(new ArrayList<>());
    item.setCandidateItemOffers(new ArrayList<>());
    item.setCartMessages(new ArrayList<>());
    item.setChildOrderItems(new ArrayList<>());
    item.setDiscountingAllowed(true);
    item.setDiscreteOrderItems(new ArrayList<>());
    item.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    item.setHasValidationError(true);
    item.setId(1L);
    item.setName("Name");
    item.setOrder(new NullOrderImpl());
    item.setOrderItemAdjustments(new ArrayList<>());
    item.setOrderItemAttributes(new HashMap<>());
    item.setOrderItemPriceDetails(new ArrayList<>());
    item.setOrderItemQualifiers(new ArrayList<>());
    item.setOrderItemType(OrderItemType.BASIC);
    item.setParentOrderItem(new BundleOrderItemImpl());
    item.setPersonalMessage(new PersonalMessageImpl());
    item.setPrice(new Money());
    item.setProratedOrderItemAdjustments(new ArrayList<>());
    item.setRetailPrice(new Money());
    item.setRetailPriceOverride(true);
    item.setSalePrice(new Money());
    item.setSalePriceOverride(true);
    item.setTaxable(true);
    item.updateSaleAndRetailPrices();
    item.setQuantity(0);

    // Act and Assert
    assertThrows(ItemNotFoundException.class, () -> legacyOrderServiceImpl.updateItemQuantity(order, item, true));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#updateItemQuantity(Order, OrderItem)} with {@code order}, {@code item}.
   * <ul>
   *   <li>Then throw {@link ItemNotFoundException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LegacyOrderServiceImpl#updateItemQuantity(Order, OrderItem)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void LegacyOrderServiceImpl.updateItemQuantity(Order, OrderItem)"})
  public void testUpdateItemQuantityWithOrderItem_thenThrowItemNotFoundException()
      throws ItemNotFoundException, PricingException {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    ArrayList<OrderItem> orderItems = new ArrayList<>();
    orderItems.add(new BundleOrderItemImpl());

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCurrency(new BroadleafCurrencyImpl());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
    order.setFulfillmentGroups(new ArrayList<>());
    order.setId(1L);
    order.setLocale(new LocaleImpl());
    order.setName("Name");
    order.setOrderAttributes(new HashMap<>());
    order.setOrderMessages(new ArrayList<>());
    order.setOrderNumber("42");
    order.setPayments(new ArrayList<>());
    order.setStatus(OrderStatus.ARCHIVED);
    order.setSubTotal(new Money());
    order.setSubmitDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());
    order.setOrderItems(orderItems);

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(1L);
    auditable2.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(1L);

    BundleOrderItemImpl item = new BundleOrderItemImpl();
    item.setAuditable(auditable2);
    item.setBaseRetailPrice(new Money());
    item.setBaseSalePrice(new Money());
    item.setBundleOrderItemFeePrices(new ArrayList<>());
    item.setCandidateItemOffers(new ArrayList<>());
    item.setCartMessages(new ArrayList<>());
    item.setChildOrderItems(new ArrayList<>());
    item.setDiscountingAllowed(true);
    item.setDiscreteOrderItems(new ArrayList<>());
    item.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    item.setHasValidationError(true);
    item.setId(1L);
    item.setName("Name");
    item.setOrder(new NullOrderImpl());
    item.setOrderItemAdjustments(new ArrayList<>());
    item.setOrderItemAttributes(new HashMap<>());
    item.setOrderItemPriceDetails(new ArrayList<>());
    item.setOrderItemQualifiers(new ArrayList<>());
    item.setOrderItemType(OrderItemType.BASIC);
    item.setParentOrderItem(new BundleOrderItemImpl());
    item.setPersonalMessage(new PersonalMessageImpl());
    item.setPrice(new Money());
    item.setProratedOrderItemAdjustments(new ArrayList<>());
    item.setRetailPrice(new Money());
    item.setRetailPriceOverride(true);
    item.setSalePrice(new Money());
    item.setSalePriceOverride(true);
    item.setTaxable(true);
    item.updateSaleAndRetailPrices();
    item.setQuantity(0);

    // Act and Assert
    assertThrows(ItemNotFoundException.class, () -> legacyOrderServiceImpl.updateItemQuantity(order, item));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#removeAllFulfillmentGroupsFromOrder(Order)} with {@code order}.
   * <p>
   * Method under test: {@link LegacyOrderServiceImpl#removeAllFulfillmentGroupsFromOrder(Order)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void LegacyOrderServiceImpl.removeAllFulfillmentGroupsFromOrder(Order)"})
  public void testRemoveAllFulfillmentGroupsFromOrderWithOrder() throws PricingException {
    // Arrange
    when(orderDao.save(Mockito.<Order>any())).thenReturn(new NullOrderImpl());

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCurrency(new BroadleafCurrencyImpl());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
    order.setId(1L);
    order.setLocale(new LocaleImpl());
    order.setName("Name");
    order.setOrderAttributes(new HashMap<>());
    order.setOrderItems(new ArrayList<>());
    order.setOrderMessages(new ArrayList<>());
    order.setOrderNumber("42");
    order.setPayments(new ArrayList<>());
    order.setStatus(OrderStatus.ARCHIVED);
    order.setSubTotal(new Money());
    order.setSubmitDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());
    order.setFulfillmentGroups(new ArrayList<>());

    // Act
    legacyOrderServiceImpl.removeAllFulfillmentGroupsFromOrder(order);

    // Assert that nothing has changed
    verify(orderDao).save(isA(Order.class));
    assertTrue(order.getFulfillmentGroups().isEmpty());
  }

  /**
   * Test {@link LegacyOrderServiceImpl#removeAllFulfillmentGroupsFromOrder(Order)} with {@code order}.
   * <p>
   * Method under test: {@link LegacyOrderServiceImpl#removeAllFulfillmentGroupsFromOrder(Order)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void LegacyOrderServiceImpl.removeAllFulfillmentGroupsFromOrder(Order)"})
  public void testRemoveAllFulfillmentGroupsFromOrderWithOrder2() throws PricingException {
    // Arrange
    when(orderDao.save(Mockito.<Order>any())).thenReturn(new NullOrderImpl());
    doNothing().when(fulfillmentGroupDao).delete(Mockito.<FulfillmentGroup>any());

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    ArrayList<FulfillmentGroup> fulfillmentGroups = new ArrayList<>();
    fulfillmentGroups.add(new FulfillmentGroupImpl());

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCurrency(new BroadleafCurrencyImpl());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
    order.setId(1L);
    order.setLocale(new LocaleImpl());
    order.setName("Name");
    order.setOrderAttributes(new HashMap<>());
    order.setOrderItems(new ArrayList<>());
    order.setOrderMessages(new ArrayList<>());
    order.setOrderNumber("42");
    order.setPayments(new ArrayList<>());
    order.setStatus(OrderStatus.ARCHIVED);
    order.setSubTotal(new Money());
    order.setSubmitDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());
    order.setFulfillmentGroups(fulfillmentGroups);

    // Act
    legacyOrderServiceImpl.removeAllFulfillmentGroupsFromOrder(order);

    // Assert
    verify(fulfillmentGroupDao).delete(isA(FulfillmentGroup.class));
    verify(orderDao).save(isA(Order.class));
    assertTrue(order.getFulfillmentGroups().isEmpty());
  }

  /**
   * Test {@link LegacyOrderServiceImpl#removeAllFulfillmentGroupsFromOrder(Order)} with {@code order}.
   * <p>
   * Method under test: {@link LegacyOrderServiceImpl#removeAllFulfillmentGroupsFromOrder(Order)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void LegacyOrderServiceImpl.removeAllFulfillmentGroupsFromOrder(Order)"})
  public void testRemoveAllFulfillmentGroupsFromOrderWithOrder3() throws PricingException {
    // Arrange
    doThrow(new IllegalArgumentException("foo")).when(fulfillmentGroupDao).delete(Mockito.<FulfillmentGroup>any());

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    ArrayList<FulfillmentGroup> fulfillmentGroups = new ArrayList<>();
    fulfillmentGroups.add(new FulfillmentGroupImpl());

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCurrency(new BroadleafCurrencyImpl());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
    order.setId(1L);
    order.setLocale(new LocaleImpl());
    order.setName("Name");
    order.setOrderAttributes(new HashMap<>());
    order.setOrderItems(new ArrayList<>());
    order.setOrderMessages(new ArrayList<>());
    order.setOrderNumber("42");
    order.setPayments(new ArrayList<>());
    order.setStatus(OrderStatus.ARCHIVED);
    order.setSubTotal(new Money());
    order.setSubmitDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());
    order.setFulfillmentGroups(fulfillmentGroups);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> legacyOrderServiceImpl.removeAllFulfillmentGroupsFromOrder(order));
    verify(fulfillmentGroupDao).delete(isA(FulfillmentGroup.class));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#removeAllFulfillmentGroupsFromOrder(Order)} with {@code order}.
   * <p>
   * Method under test: {@link LegacyOrderServiceImpl#removeAllFulfillmentGroupsFromOrder(Order)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void LegacyOrderServiceImpl.removeAllFulfillmentGroupsFromOrder(Order)"})
  public void testRemoveAllFulfillmentGroupsFromOrderWithOrder4() throws PricingException {
    // Arrange
    when(orderDao.save(Mockito.<Order>any())).thenThrow(new IllegalArgumentException("foo"));

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCurrency(new BroadleafCurrencyImpl());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
    order.setFulfillmentGroups(new ArrayList<>());
    order.setId(1L);
    order.setLocale(new LocaleImpl());
    order.setName("Name");
    order.setOrderAttributes(new HashMap<>());
    order.setOrderItems(new ArrayList<>());
    order.setOrderMessages(new ArrayList<>());
    order.setOrderNumber("42");
    order.setPayments(new ArrayList<>());
    order.setStatus(OrderStatus.ARCHIVED);
    order.setSubTotal(new Money());
    order.setSubmitDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> legacyOrderServiceImpl.removeAllFulfillmentGroupsFromOrder(order));
    verify(orderDao).save(isA(Order.class));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#removeAllFulfillmentGroupsFromOrder(Order, boolean)} with {@code order}, {@code priceOrder}.
   * <p>
   * Method under test: {@link LegacyOrderServiceImpl#removeAllFulfillmentGroupsFromOrder(Order, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void LegacyOrderServiceImpl.removeAllFulfillmentGroupsFromOrder(Order, boolean)"})
  public void testRemoveAllFulfillmentGroupsFromOrderWithOrderPriceOrder() throws PricingException {
    // Arrange
    when(orderDao.save(Mockito.<Order>any())).thenReturn(new NullOrderImpl());
    when(pricingService.executePricing(Mockito.<Order>any())).thenReturn(new NullOrderImpl());

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCurrency(new BroadleafCurrencyImpl());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
    order.setId(1L);
    order.setLocale(new LocaleImpl());
    order.setName("Name");
    order.setOrderAttributes(new HashMap<>());
    order.setOrderItems(new ArrayList<>());
    order.setOrderMessages(new ArrayList<>());
    order.setOrderNumber("42");
    order.setPayments(new ArrayList<>());
    order.setStatus(OrderStatus.ARCHIVED);
    order.setSubTotal(new Money());
    order.setSubmitDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());
    order.setFulfillmentGroups(new ArrayList<>());

    // Act
    legacyOrderServiceImpl.removeAllFulfillmentGroupsFromOrder(order, true);

    // Assert that nothing has changed
    verify(orderDao).save(isA(Order.class));
    verify(pricingService).executePricing(isA(Order.class));
    assertTrue(order.getFulfillmentGroups().isEmpty());
  }

  /**
   * Test {@link LegacyOrderServiceImpl#removeAllFulfillmentGroupsFromOrder(Order, boolean)} with {@code order}, {@code priceOrder}.
   * <p>
   * Method under test: {@link LegacyOrderServiceImpl#removeAllFulfillmentGroupsFromOrder(Order, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void LegacyOrderServiceImpl.removeAllFulfillmentGroupsFromOrder(Order, boolean)"})
  public void testRemoveAllFulfillmentGroupsFromOrderWithOrderPriceOrder2() throws PricingException {
    // Arrange
    when(pricingService.executePricing(Mockito.<Order>any())).thenThrow(new IllegalArgumentException("foo"));

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCurrency(new BroadleafCurrencyImpl());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
    order.setId(1L);
    order.setLocale(new LocaleImpl());
    order.setName("Name");
    order.setOrderAttributes(new HashMap<>());
    order.setOrderItems(new ArrayList<>());
    order.setOrderMessages(new ArrayList<>());
    order.setOrderNumber("42");
    order.setPayments(new ArrayList<>());
    order.setStatus(OrderStatus.ARCHIVED);
    order.setSubTotal(new Money());
    order.setSubmitDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());
    order.setFulfillmentGroups(new ArrayList<>());

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> legacyOrderServiceImpl.removeAllFulfillmentGroupsFromOrder(order, true));
    verify(pricingService).executePricing(isA(Order.class));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#removeAllFulfillmentGroupsFromOrder(Order, boolean)} with {@code order}, {@code priceOrder}.
   * <p>
   * Method under test: {@link LegacyOrderServiceImpl#removeAllFulfillmentGroupsFromOrder(Order, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void LegacyOrderServiceImpl.removeAllFulfillmentGroupsFromOrder(Order, boolean)"})
  public void testRemoveAllFulfillmentGroupsFromOrderWithOrderPriceOrder3() throws PricingException {
    // Arrange
    when(orderDao.save(Mockito.<Order>any())).thenReturn(new NullOrderImpl());
    when(pricingService.executePricing(Mockito.<Order>any())).thenReturn(new NullOrderImpl());
    doNothing().when(fulfillmentGroupDao).delete(Mockito.<FulfillmentGroup>any());

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    ArrayList<FulfillmentGroup> fulfillmentGroups = new ArrayList<>();
    fulfillmentGroups.add(new FulfillmentGroupImpl());

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCurrency(new BroadleafCurrencyImpl());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
    order.setId(1L);
    order.setLocale(new LocaleImpl());
    order.setName("Name");
    order.setOrderAttributes(new HashMap<>());
    order.setOrderItems(new ArrayList<>());
    order.setOrderMessages(new ArrayList<>());
    order.setOrderNumber("42");
    order.setPayments(new ArrayList<>());
    order.setStatus(OrderStatus.ARCHIVED);
    order.setSubTotal(new Money());
    order.setSubmitDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());
    order.setFulfillmentGroups(fulfillmentGroups);

    // Act
    legacyOrderServiceImpl.removeAllFulfillmentGroupsFromOrder(order, true);

    // Assert
    verify(fulfillmentGroupDao).delete(isA(FulfillmentGroup.class));
    verify(orderDao).save(isA(Order.class));
    verify(pricingService).executePricing(isA(Order.class));
    assertTrue(order.getFulfillmentGroups().isEmpty());
  }

  /**
   * Test {@link LegacyOrderServiceImpl#removeAllFulfillmentGroupsFromOrder(Order, boolean)} with {@code order}, {@code priceOrder}.
   * <p>
   * Method under test: {@link LegacyOrderServiceImpl#removeAllFulfillmentGroupsFromOrder(Order, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void LegacyOrderServiceImpl.removeAllFulfillmentGroupsFromOrder(Order, boolean)"})
  public void testRemoveAllFulfillmentGroupsFromOrderWithOrderPriceOrder4() throws PricingException {
    // Arrange
    doThrow(new IllegalArgumentException("foo")).when(fulfillmentGroupDao).delete(Mockito.<FulfillmentGroup>any());

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    ArrayList<FulfillmentGroup> fulfillmentGroups = new ArrayList<>();
    fulfillmentGroups.add(new FulfillmentGroupImpl());

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCurrency(new BroadleafCurrencyImpl());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
    order.setId(1L);
    order.setLocale(new LocaleImpl());
    order.setName("Name");
    order.setOrderAttributes(new HashMap<>());
    order.setOrderItems(new ArrayList<>());
    order.setOrderMessages(new ArrayList<>());
    order.setOrderNumber("42");
    order.setPayments(new ArrayList<>());
    order.setStatus(OrderStatus.ARCHIVED);
    order.setSubTotal(new Money());
    order.setSubmitDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());
    order.setFulfillmentGroups(fulfillmentGroups);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> legacyOrderServiceImpl.removeAllFulfillmentGroupsFromOrder(order, true));
    verify(fulfillmentGroupDao).delete(isA(FulfillmentGroup.class));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#removeFulfillmentGroupFromOrder(Order, FulfillmentGroup)} with {@code order}, {@code fulfillmentGroup}.
   * <p>
   * Method under test: {@link LegacyOrderServiceImpl#removeFulfillmentGroupFromOrder(Order, FulfillmentGroup)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void LegacyOrderServiceImpl.removeFulfillmentGroupFromOrder(Order, FulfillmentGroup)"})
  public void testRemoveFulfillmentGroupFromOrderWithOrderFulfillmentGroup() throws PricingException {
    // Arrange
    when(orderDao.save(Mockito.<Order>any())).thenReturn(new NullOrderImpl());
    when(pricingService.executePricing(Mockito.<Order>any())).thenReturn(new NullOrderImpl());
    doNothing().when(fulfillmentGroupDao).delete(Mockito.<FulfillmentGroup>any());

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCurrency(new BroadleafCurrencyImpl());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
    order.setId(1L);
    order.setLocale(new LocaleImpl());
    order.setName("Name");
    order.setOrderAttributes(new HashMap<>());
    order.setOrderItems(new ArrayList<>());
    order.setOrderMessages(new ArrayList<>());
    order.setOrderNumber("42");
    order.setPayments(new ArrayList<>());
    order.setStatus(OrderStatus.ARCHIVED);
    order.setSubTotal(new Money());
    order.setSubmitDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());
    order.setFulfillmentGroups(new ArrayList<>());

    // Act
    legacyOrderServiceImpl.removeFulfillmentGroupFromOrder(order, new FulfillmentGroupImpl());

    // Assert
    verify(fulfillmentGroupDao).delete(isA(FulfillmentGroup.class));
    verify(orderDao).save(isA(Order.class));
    verify(pricingService).executePricing(isA(Order.class));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#removeFulfillmentGroupFromOrder(Order, FulfillmentGroup)} with {@code order}, {@code fulfillmentGroup}.
   * <p>
   * Method under test: {@link LegacyOrderServiceImpl#removeFulfillmentGroupFromOrder(Order, FulfillmentGroup)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void LegacyOrderServiceImpl.removeFulfillmentGroupFromOrder(Order, FulfillmentGroup)"})
  public void testRemoveFulfillmentGroupFromOrderWithOrderFulfillmentGroup2() throws PricingException {
    // Arrange
    doThrow(new IllegalArgumentException("foo")).when(fulfillmentGroupDao).delete(Mockito.<FulfillmentGroup>any());

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCurrency(new BroadleafCurrencyImpl());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
    order.setId(1L);
    order.setLocale(new LocaleImpl());
    order.setName("Name");
    order.setOrderAttributes(new HashMap<>());
    order.setOrderItems(new ArrayList<>());
    order.setOrderMessages(new ArrayList<>());
    order.setOrderNumber("42");
    order.setPayments(new ArrayList<>());
    order.setStatus(OrderStatus.ARCHIVED);
    order.setSubTotal(new Money());
    order.setSubmitDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());
    order.setFulfillmentGroups(new ArrayList<>());

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> legacyOrderServiceImpl.removeFulfillmentGroupFromOrder(order, new FulfillmentGroupImpl()));
    verify(fulfillmentGroupDao).delete(isA(FulfillmentGroup.class));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#removeFulfillmentGroupFromOrder(Order, FulfillmentGroup)} with {@code order}, {@code fulfillmentGroup}.
   * <p>
   * Method under test: {@link LegacyOrderServiceImpl#removeFulfillmentGroupFromOrder(Order, FulfillmentGroup)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void LegacyOrderServiceImpl.removeFulfillmentGroupFromOrder(Order, FulfillmentGroup)"})
  public void testRemoveFulfillmentGroupFromOrderWithOrderFulfillmentGroup3() throws PricingException {
    // Arrange
    when(orderDao.save(Mockito.<Order>any())).thenThrow(new IllegalArgumentException("foo"));
    when(pricingService.executePricing(Mockito.<Order>any())).thenReturn(new NullOrderImpl());
    doNothing().when(fulfillmentGroupDao).delete(Mockito.<FulfillmentGroup>any());

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCurrency(new BroadleafCurrencyImpl());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
    order.setFulfillmentGroups(new ArrayList<>());
    order.setId(1L);
    order.setLocale(new LocaleImpl());
    order.setName("Name");
    order.setOrderAttributes(new HashMap<>());
    order.setOrderItems(new ArrayList<>());
    order.setOrderMessages(new ArrayList<>());
    order.setOrderNumber("42");
    order.setPayments(new ArrayList<>());
    order.setStatus(OrderStatus.ARCHIVED);
    order.setSubTotal(new Money());
    order.setSubmitDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> legacyOrderServiceImpl.removeFulfillmentGroupFromOrder(order, new FulfillmentGroupImpl()));
    verify(fulfillmentGroupDao).delete(isA(FulfillmentGroup.class));
    verify(orderDao).save(isA(Order.class));
    verify(pricingService).executePricing(isA(Order.class));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#removeFulfillmentGroupFromOrder(Order, FulfillmentGroup, boolean)} with {@code order}, {@code fulfillmentGroup}, {@code priceOrder}.
   * <p>
   * Method under test: {@link LegacyOrderServiceImpl#removeFulfillmentGroupFromOrder(Order, FulfillmentGroup, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void LegacyOrderServiceImpl.removeFulfillmentGroupFromOrder(Order, FulfillmentGroup, boolean)"})
  public void testRemoveFulfillmentGroupFromOrderWithOrderFulfillmentGroupPriceOrder() throws PricingException {
    // Arrange
    when(orderDao.save(Mockito.<Order>any())).thenReturn(new NullOrderImpl());
    when(pricingService.executePricing(Mockito.<Order>any())).thenReturn(new NullOrderImpl());
    doNothing().when(fulfillmentGroupDao).delete(Mockito.<FulfillmentGroup>any());

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCurrency(new BroadleafCurrencyImpl());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
    order.setId(1L);
    order.setLocale(new LocaleImpl());
    order.setName("Name");
    order.setOrderAttributes(new HashMap<>());
    order.setOrderItems(new ArrayList<>());
    order.setOrderMessages(new ArrayList<>());
    order.setOrderNumber("42");
    order.setPayments(new ArrayList<>());
    order.setStatus(OrderStatus.ARCHIVED);
    order.setSubTotal(new Money());
    order.setSubmitDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());
    order.setFulfillmentGroups(new ArrayList<>());

    // Act
    legacyOrderServiceImpl.removeFulfillmentGroupFromOrder(order, new FulfillmentGroupImpl(), true);

    // Assert
    verify(fulfillmentGroupDao).delete(isA(FulfillmentGroup.class));
    verify(orderDao).save(isA(Order.class));
    verify(pricingService).executePricing(isA(Order.class));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#removeFulfillmentGroupFromOrder(Order, FulfillmentGroup, boolean)} with {@code order}, {@code fulfillmentGroup}, {@code priceOrder}.
   * <p>
   * Method under test: {@link LegacyOrderServiceImpl#removeFulfillmentGroupFromOrder(Order, FulfillmentGroup, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void LegacyOrderServiceImpl.removeFulfillmentGroupFromOrder(Order, FulfillmentGroup, boolean)"})
  public void testRemoveFulfillmentGroupFromOrderWithOrderFulfillmentGroupPriceOrder2() throws PricingException {
    // Arrange
    doThrow(new IllegalArgumentException("foo")).when(fulfillmentGroupDao).delete(Mockito.<FulfillmentGroup>any());

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCurrency(new BroadleafCurrencyImpl());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
    order.setId(1L);
    order.setLocale(new LocaleImpl());
    order.setName("Name");
    order.setOrderAttributes(new HashMap<>());
    order.setOrderItems(new ArrayList<>());
    order.setOrderMessages(new ArrayList<>());
    order.setOrderNumber("42");
    order.setPayments(new ArrayList<>());
    order.setStatus(OrderStatus.ARCHIVED);
    order.setSubTotal(new Money());
    order.setSubmitDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());
    order.setFulfillmentGroups(new ArrayList<>());

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> legacyOrderServiceImpl.removeFulfillmentGroupFromOrder(order, new FulfillmentGroupImpl(), true));
    verify(fulfillmentGroupDao).delete(isA(FulfillmentGroup.class));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#removeFulfillmentGroupFromOrder(Order, FulfillmentGroup, boolean)} with {@code order}, {@code fulfillmentGroup}, {@code priceOrder}.
   * <p>
   * Method under test: {@link LegacyOrderServiceImpl#removeFulfillmentGroupFromOrder(Order, FulfillmentGroup, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void LegacyOrderServiceImpl.removeFulfillmentGroupFromOrder(Order, FulfillmentGroup, boolean)"})
  public void testRemoveFulfillmentGroupFromOrderWithOrderFulfillmentGroupPriceOrder3() throws PricingException {
    // Arrange
    when(orderDao.save(Mockito.<Order>any())).thenThrow(new IllegalArgumentException("foo"));
    when(pricingService.executePricing(Mockito.<Order>any())).thenReturn(new NullOrderImpl());
    doNothing().when(fulfillmentGroupDao).delete(Mockito.<FulfillmentGroup>any());

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCurrency(new BroadleafCurrencyImpl());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
    order.setFulfillmentGroups(new ArrayList<>());
    order.setId(1L);
    order.setLocale(new LocaleImpl());
    order.setName("Name");
    order.setOrderAttributes(new HashMap<>());
    order.setOrderItems(new ArrayList<>());
    order.setOrderMessages(new ArrayList<>());
    order.setOrderNumber("42");
    order.setPayments(new ArrayList<>());
    order.setStatus(OrderStatus.ARCHIVED);
    order.setSubTotal(new Money());
    order.setSubmitDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> legacyOrderServiceImpl.removeFulfillmentGroupFromOrder(order, new FulfillmentGroupImpl(), true));
    verify(fulfillmentGroupDao).delete(isA(FulfillmentGroup.class));
    verify(orderDao).save(isA(Order.class));
    verify(pricingService).executePricing(isA(Order.class));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#removeNamedOrderForCustomer(String, Customer)}.
   * <ul>
   *   <li>Then calls {@link OrderDao#delete(Order)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LegacyOrderServiceImpl#removeNamedOrderForCustomer(String, Customer)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void LegacyOrderServiceImpl.removeNamedOrderForCustomer(String, Customer)"})
  public void testRemoveNamedOrderForCustomer_thenCallsDelete() {
    // Arrange
    when(orderDao.readNamedOrderForCustomer(Mockito.<Customer>any(), Mockito.<String>any()))
        .thenReturn(new NullOrderImpl());
    doNothing().when(orderDao).delete(Mockito.<Order>any());

    // Act
    legacyOrderServiceImpl.removeNamedOrderForCustomer("Name", new CustomerImpl());

    // Assert
    verify(orderDao).delete(isA(Order.class));
    verify(orderDao).readNamedOrderForCustomer(isA(Customer.class), eq("Name"));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#readPaymentInfosForOrder(Order)}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link LegacyOrderServiceImpl#readPaymentInfosForOrder(Order)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List LegacyOrderServiceImpl.readPaymentInfosForOrder(Order)"})
  public void testReadPaymentInfosForOrder_thenReturnEmpty() {
    // Arrange
    when(orderPaymentDao.readPaymentsForOrder(Mockito.<Order>any())).thenReturn(new ArrayList<>());

    // Act
    List<OrderPayment> actualReadPaymentInfosForOrderResult = legacyOrderServiceImpl
        .readPaymentInfosForOrder(new NullOrderImpl());

    // Assert
    verify(orderPaymentDao).readPaymentsForOrder(isA(Order.class));
    assertTrue(actualReadPaymentInfosForOrderResult.isEmpty());
  }

  /**
   * Test {@link LegacyOrderServiceImpl#readPaymentInfosForOrder(Order)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LegacyOrderServiceImpl#readPaymentInfosForOrder(Order)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List LegacyOrderServiceImpl.readPaymentInfosForOrder(Order)"})
  public void testReadPaymentInfosForOrder_thenThrowIllegalArgumentException() {
    // Arrange
    when(orderPaymentDao.readPaymentsForOrder(Mockito.<Order>any())).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> legacyOrderServiceImpl.readPaymentInfosForOrder(new NullOrderImpl()));
    verify(orderPaymentDao).readPaymentsForOrder(isA(Order.class));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#itemMatches(DiscreteOrderItem, DiscreteOrderItem)} with {@code item1}, {@code item2}.
   * <ul>
   *   <li>Given {@link SkuImpl} {@link SkuImpl#getId()} return one.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LegacyOrderServiceImpl#itemMatches(DiscreteOrderItem, DiscreteOrderItem)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean LegacyOrderServiceImpl.itemMatches(DiscreteOrderItem, DiscreteOrderItem)"})
  public void testItemMatchesWithItem1Item2_givenSkuImplGetIdReturnOne_thenReturnFalse() {
    // Arrange
    SkuImpl skuImpl = mock(SkuImpl.class);
    when(skuImpl.getId()).thenReturn(1L);
    DiscreteOrderItem item1 = mock(DiscreteOrderItem.class);
    when(item1.getSku()).thenReturn(skuImpl);
    DiscreteOrderItem item2 = mock(DiscreteOrderItem.class);
    when(item2.getSku()).thenReturn(new SkuImpl());

    // Act
    boolean actualItemMatchesResult = legacyOrderServiceImpl.itemMatches(item1, item2);

    // Assert
    verify(skuImpl).getId();
    verify(item1, atLeast(1)).getSku();
    verify(item2, atLeast(1)).getSku();
    assertFalse(actualItemMatchesResult);
  }

  /**
   * Test {@link LegacyOrderServiceImpl#itemMatches(DiscreteOrderItem, DiscreteOrderItem)} with {@code item1}, {@code item2}.
   * <ul>
   *   <li>Given {@link SkuImpl} {@link SkuImpl#getId()} return one.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LegacyOrderServiceImpl#itemMatches(DiscreteOrderItem, DiscreteOrderItem)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean LegacyOrderServiceImpl.itemMatches(DiscreteOrderItem, DiscreteOrderItem)"})
  public void testItemMatchesWithItem1Item2_givenSkuImplGetIdReturnOne_thenReturnTrue() {
    // Arrange
    SkuImpl skuImpl = mock(SkuImpl.class);
    when(skuImpl.getId()).thenReturn(1L);
    DiscreteOrderItem item1 = mock(DiscreteOrderItem.class);
    when(item1.getSku()).thenReturn(skuImpl);
    SkuImpl skuImpl2 = mock(SkuImpl.class);
    when(skuImpl2.getId()).thenReturn(1L);
    DiscreteOrderItem item2 = mock(DiscreteOrderItem.class);
    when(item2.getSku()).thenReturn(skuImpl2);

    // Act
    boolean actualItemMatchesResult = legacyOrderServiceImpl.itemMatches(item1, item2);

    // Assert
    verify(skuImpl).getId();
    verify(skuImpl2).getId();
    verify(item1, atLeast(1)).getSku();
    verify(item2, atLeast(1)).getSku();
    assertTrue(actualItemMatchesResult);
  }

  /**
   * Test {@link LegacyOrderServiceImpl#itemMatches(DiscreteOrderItem, DiscreteOrderItem)} with {@code item1}, {@code item2}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LegacyOrderServiceImpl#itemMatches(DiscreteOrderItem, DiscreteOrderItem)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean LegacyOrderServiceImpl.itemMatches(DiscreteOrderItem, DiscreteOrderItem)"})
  public void testItemMatchesWithItem1Item2_thenThrowIllegalArgumentException() {
    // Arrange
    SkuImpl skuImpl = mock(SkuImpl.class);
    when(skuImpl.getId()).thenReturn(1L);
    DiscreteOrderItem item1 = mock(DiscreteOrderItem.class);
    when(item1.getSku()).thenReturn(skuImpl);
    SkuImpl skuImpl2 = mock(SkuImpl.class);
    when(skuImpl2.getId()).thenThrow(new IllegalArgumentException("foo"));
    DiscreteOrderItem item2 = mock(DiscreteOrderItem.class);
    when(item2.getSku()).thenReturn(skuImpl2);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> legacyOrderServiceImpl.itemMatches(item1, item2));
    verify(skuImpl).getId();
    verify(skuImpl2).getId();
    verify(item1, atLeast(1)).getSku();
    verify(item2, atLeast(1)).getSku();
  }

  /**
   * Test {@link LegacyOrderServiceImpl#itemMatches(DiscreteOrderItem, DiscreteOrderItem)} with {@code item1}, {@code item2}.
   * <ul>
   *   <li>When {@link DiscreteOrderItemImpl} (default constructor).</li>
   *   <li>Then calls {@link DiscreteOrderItem#getProduct()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LegacyOrderServiceImpl#itemMatches(DiscreteOrderItem, DiscreteOrderItem)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean LegacyOrderServiceImpl.itemMatches(DiscreteOrderItem, DiscreteOrderItem)"})
  public void testItemMatchesWithItem1Item2_whenDiscreteOrderItemImpl_thenCallsGetProduct() {
    // Arrange
    DiscreteOrderItem item1 = mock(DiscreteOrderItem.class);
    when(item1.getProduct()).thenReturn(new ProductBundleImpl());
    when(item1.getSku()).thenReturn(new SkuImpl());

    // Act
    boolean actualItemMatchesResult = legacyOrderServiceImpl.itemMatches(item1, new DiscreteOrderItemImpl());

    // Assert
    verify(item1).getProduct();
    verify(item1).getSku();
    assertFalse(actualItemMatchesResult);
  }

  /**
   * Test {@link LegacyOrderServiceImpl#itemMatches(DiscreteOrderItem, DiscreteOrderItem)} with {@code item1}, {@code item2}.
   * <ul>
   *   <li>When {@link DiscreteOrderItemImpl} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LegacyOrderServiceImpl#itemMatches(DiscreteOrderItem, DiscreteOrderItem)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean LegacyOrderServiceImpl.itemMatches(DiscreteOrderItem, DiscreteOrderItem)"})
  public void testItemMatchesWithItem1Item2_whenDiscreteOrderItemImpl_thenReturnFalse() {
    // Arrange
    DiscreteOrderItemImpl item1 = new DiscreteOrderItemImpl();

    // Act and Assert
    assertFalse(legacyOrderServiceImpl.itemMatches(item1, new DiscreteOrderItemImpl()));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#findMatchingDiscreteItem(Order, DiscreteOrderItem)}.
   * <ul>
   *   <li>Given {@link Auditable} (default constructor) CreatedBy is one.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LegacyOrderServiceImpl#findMatchingDiscreteItem(Order, DiscreteOrderItem)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"OrderItem LegacyOrderServiceImpl.findMatchingDiscreteItem(Order, DiscreteOrderItem)"})
  public void testFindMatchingDiscreteItem_givenAuditableCreatedByIsOne_thenReturnNull() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCurrency(new BroadleafCurrencyImpl());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
    order.setFulfillmentGroups(new ArrayList<>());
    order.setId(1L);
    order.setLocale(new LocaleImpl());
    order.setName("Name");
    order.setOrderAttributes(new HashMap<>());
    order.setOrderMessages(new ArrayList<>());
    order.setOrderNumber("42");
    order.setPayments(new ArrayList<>());
    order.setStatus(OrderStatus.ARCHIVED);
    order.setSubTotal(new Money());
    order.setSubmitDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());
    order.setOrderItems(new ArrayList<>());

    // Act and Assert
    assertNull(legacyOrderServiceImpl.findMatchingDiscreteItem(order, new DiscreteOrderItemImpl()));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#bundleItemMatches(BundleOrderItem, BundleOrderItem)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.</li>
   *   <li>Then calls {@link BundleOrderItem#getDiscreteOrderItems()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LegacyOrderServiceImpl#bundleItemMatches(BundleOrderItem, BundleOrderItem)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean LegacyOrderServiceImpl.bundleItemMatches(BundleOrderItem, BundleOrderItem)"})
  public void testBundleItemMatches_givenArrayList_thenCallsGetDiscreteOrderItems() {
    // Arrange
    BundleOrderItem item1 = mock(BundleOrderItem.class);
    when(item1.getDiscreteOrderItems()).thenReturn(new ArrayList<>());
    when(item1.getSku()).thenReturn(new SkuImpl());

    // Act
    boolean actualBundleItemMatchesResult = legacyOrderServiceImpl.bundleItemMatches(item1, new BundleOrderItemImpl());

    // Assert
    verify(item1).getDiscreteOrderItems();
    verify(item1).getSku();
    assertTrue(actualBundleItemMatchesResult);
  }

  /**
   * Test {@link LegacyOrderServiceImpl#bundleItemMatches(BundleOrderItem, BundleOrderItem)}.
   * <ul>
   *   <li>Given {@link SkuImpl} {@link SkuImpl#getId()} return one.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LegacyOrderServiceImpl#bundleItemMatches(BundleOrderItem, BundleOrderItem)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean LegacyOrderServiceImpl.bundleItemMatches(BundleOrderItem, BundleOrderItem)"})
  public void testBundleItemMatches_givenSkuImplGetIdReturnOne_thenReturnFalse() {
    // Arrange
    SkuImpl skuImpl = mock(SkuImpl.class);
    when(skuImpl.getId()).thenReturn(1L);
    BundleOrderItem item1 = mock(BundleOrderItem.class);
    when(item1.getSku()).thenReturn(skuImpl);
    BundleOrderItem item2 = mock(BundleOrderItem.class);
    when(item2.getSku()).thenReturn(new SkuImpl());

    // Act
    boolean actualBundleItemMatchesResult = legacyOrderServiceImpl.bundleItemMatches(item1, item2);

    // Assert
    verify(skuImpl).getId();
    verify(item1, atLeast(1)).getSku();
    verify(item2, atLeast(1)).getSku();
    assertFalse(actualBundleItemMatchesResult);
  }

  /**
   * Test {@link LegacyOrderServiceImpl#bundleItemMatches(BundleOrderItem, BundleOrderItem)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LegacyOrderServiceImpl#bundleItemMatches(BundleOrderItem, BundleOrderItem)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean LegacyOrderServiceImpl.bundleItemMatches(BundleOrderItem, BundleOrderItem)"})
  public void testBundleItemMatches_thenThrowIllegalArgumentException() {
    // Arrange
    SkuImpl skuImpl = mock(SkuImpl.class);
    when(skuImpl.getId()).thenReturn(1L);
    BundleOrderItem item1 = mock(BundleOrderItem.class);
    when(item1.getSku()).thenReturn(skuImpl);
    SkuImpl skuImpl2 = mock(SkuImpl.class);
    when(skuImpl2.getId()).thenThrow(new IllegalArgumentException("foo"));
    BundleOrderItem item2 = mock(BundleOrderItem.class);
    when(item2.getSku()).thenReturn(skuImpl2);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> legacyOrderServiceImpl.bundleItemMatches(item1, item2));
    verify(skuImpl).getId();
    verify(skuImpl2).getId();
    verify(item1, atLeast(1)).getSku();
    verify(item2, atLeast(1)).getSku();
  }

  /**
   * Test {@link LegacyOrderServiceImpl#bundleItemMatches(BundleOrderItem, BundleOrderItem)}.
   * <ul>
   *   <li>When {@link BundleOrderItemImpl} (default constructor).</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LegacyOrderServiceImpl#bundleItemMatches(BundleOrderItem, BundleOrderItem)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean LegacyOrderServiceImpl.bundleItemMatches(BundleOrderItem, BundleOrderItem)"})
  public void testBundleItemMatches_whenBundleOrderItemImpl_thenReturnTrue() {
    // Arrange
    BundleOrderItemImpl item1 = new BundleOrderItemImpl();

    // Act and Assert
    assertTrue(legacyOrderServiceImpl.bundleItemMatches(item1, new BundleOrderItemImpl()));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#findMatchingBundleItem(Order, BundleOrderItem)}.
   * <ul>
   *   <li>Given {@link Auditable} (default constructor) CreatedBy is one.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LegacyOrderServiceImpl#findMatchingBundleItem(Order, BundleOrderItem)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"OrderItem LegacyOrderServiceImpl.findMatchingBundleItem(Order, BundleOrderItem)"})
  public void testFindMatchingBundleItem_givenAuditableCreatedByIsOne_thenReturnNull() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCurrency(new BroadleafCurrencyImpl());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
    order.setFulfillmentGroups(new ArrayList<>());
    order.setId(1L);
    order.setLocale(new LocaleImpl());
    order.setName("Name");
    order.setOrderAttributes(new HashMap<>());
    order.setOrderItems(new ArrayList<>());
    order.setOrderMessages(new ArrayList<>());
    order.setOrderNumber("42");
    order.setPayments(new ArrayList<>());
    order.setStatus(OrderStatus.ARCHIVED);
    order.setSubTotal(new Money());
    order.setSubmitDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());

    // Act and Assert
    assertNull(legacyOrderServiceImpl.findMatchingBundleItem(order, new BundleOrderItemImpl()));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#findMatchingBundleItem(Order, BundleOrderItem)}.
   * <ul>
   *   <li>Then return {@link BundleOrderItemImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link LegacyOrderServiceImpl#findMatchingBundleItem(Order, BundleOrderItem)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"OrderItem LegacyOrderServiceImpl.findMatchingBundleItem(Order, BundleOrderItem)"})
  public void testFindMatchingBundleItem_thenReturnBundleOrderItemImpl() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    ArrayList<OrderItem> orderItems = new ArrayList<>();
    BundleOrderItemImpl bundleOrderItemImpl = new BundleOrderItemImpl();
    orderItems.add(bundleOrderItemImpl);

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCurrency(new BroadleafCurrencyImpl());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
    order.setFulfillmentGroups(new ArrayList<>());
    order.setId(1L);
    order.setLocale(new LocaleImpl());
    order.setName("Name");
    order.setOrderAttributes(new HashMap<>());
    order.setOrderItems(orderItems);
    order.setOrderMessages(new ArrayList<>());
    order.setOrderNumber("42");
    order.setPayments(new ArrayList<>());
    order.setStatus(OrderStatus.ARCHIVED);
    order.setSubTotal(new Money());
    order.setSubmitDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());

    // Act and Assert
    assertSame(bundleOrderItemImpl, legacyOrderServiceImpl.findMatchingBundleItem(order, new BundleOrderItemImpl()));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#findMatchingItem(Order, OrderItem)} with {@code Order}, {@code OrderItem}.
   * <ul>
   *   <li>Given {@link Auditable} (default constructor) CreatedBy is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link LegacyOrderServiceImpl#findMatchingItem(Order, OrderItem)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"OrderItem LegacyOrderServiceImpl.findMatchingItem(Order, OrderItem)"})
  public void testFindMatchingItemWithOrderOrderItem_givenAuditableCreatedByIsOne() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    OrderItemImpl orderItem = new OrderItemImpl();
    orderItem.setAuditable(auditable);
    orderItem.setCandidateItemOffers(new ArrayList<>());
    orderItem.setCartMessages(new ArrayList<>());
    orderItem.setChildOrderItems(new ArrayList<>());
    orderItem.setDiscountingAllowed(true);
    orderItem.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    orderItem.setHasValidationError(true);
    orderItem.setId(1L);
    orderItem.setName("Name");
    orderItem.setOrder(new NullOrderImpl());
    orderItem.setOrderItemAdjustments(new ArrayList<>());
    orderItem.setOrderItemAttributes(new HashMap<>());
    orderItem.setOrderItemPriceDetails(new ArrayList<>());
    orderItem.setOrderItemQualifiers(new ArrayList<>());
    orderItem.setOrderItemType(OrderItemType.BASIC);
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

    OrderImpl order = new OrderImpl();
    order.addOrderItem(orderItem);

    // Act and Assert
    assertNull(legacyOrderServiceImpl.findMatchingItem(order, new BundleOrderItemImpl()));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#findMatchingItem(Order, OrderItem)} with {@code Order}, {@code OrderItem}.
   * <ul>
   *   <li>Given {@link SkuImpl} {@link SkuImpl#getId()} return one.</li>
   *   <li>Then calls {@link SkuImpl#getId()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LegacyOrderServiceImpl#findMatchingItem(Order, OrderItem)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"OrderItem LegacyOrderServiceImpl.findMatchingItem(Order, OrderItem)"})
  public void testFindMatchingItemWithOrderOrderItem_givenSkuImplGetIdReturnOne_thenCallsGetId() {
    // Arrange
    SkuImpl skuImpl = mock(SkuImpl.class);
    when(skuImpl.getId()).thenReturn(1L);
    BundleOrderItemImpl orderItem = mock(BundleOrderItemImpl.class);
    when(orderItem.getSku()).thenReturn(skuImpl);

    OrderImpl order = new OrderImpl();
    order.addOrderItem(orderItem);
    BundleOrderItemImpl itemToFind = mock(BundleOrderItemImpl.class);
    when(itemToFind.getSku()).thenReturn(new SkuImpl());

    // Act
    OrderItem actualFindMatchingItemResult = legacyOrderServiceImpl.findMatchingItem(order, itemToFind);

    // Assert
    verify(skuImpl).getId();
    verify(orderItem, atLeast(1)).getSku();
    verify(itemToFind, atLeast(1)).getSku();
    assertNull(actualFindMatchingItemResult);
  }

  /**
   * Test {@link LegacyOrderServiceImpl#findMatchingItem(Order, OrderItem)} with {@code Order}, {@code OrderItem}.
   * <ul>
   *   <li>Then calls {@link BundleOrderItemImpl#getDiscreteOrderItems()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LegacyOrderServiceImpl#findMatchingItem(Order, OrderItem)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"OrderItem LegacyOrderServiceImpl.findMatchingItem(Order, OrderItem)"})
  public void testFindMatchingItemWithOrderOrderItem_thenCallsGetDiscreteOrderItems() {
    // Arrange
    BundleOrderItemImpl orderItem = mock(BundleOrderItemImpl.class);
    when(orderItem.getDiscreteOrderItems()).thenReturn(new ArrayList<>());
    when(orderItem.getSku()).thenReturn(new SkuImpl());

    OrderImpl order = new OrderImpl();
    order.addOrderItem(orderItem);

    // Act
    legacyOrderServiceImpl.findMatchingItem(order, new BundleOrderItemImpl());

    // Assert
    verify(orderItem).getDiscreteOrderItems();
    verify(orderItem).getSku();
  }

  /**
   * Test {@link LegacyOrderServiceImpl#findMatchingItem(Order, OrderItem)} with {@code Order}, {@code OrderItem}.
   * <ul>
   *   <li>Then return {@link BundleOrderItemImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link LegacyOrderServiceImpl#findMatchingItem(Order, OrderItem)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"OrderItem LegacyOrderServiceImpl.findMatchingItem(Order, OrderItem)"})
  public void testFindMatchingItemWithOrderOrderItem_thenReturnBundleOrderItemImpl() {
    // Arrange
    OrderImpl order = new OrderImpl();
    BundleOrderItemImpl orderItem = new BundleOrderItemImpl();
    order.addOrderItem(orderItem);

    // Act and Assert
    assertSame(orderItem, legacyOrderServiceImpl.findMatchingItem(order, new BundleOrderItemImpl()));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#findMatchingItem(Order, OrderItem)} with {@code Order}, {@code OrderItem}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LegacyOrderServiceImpl#findMatchingItem(Order, OrderItem)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"OrderItem LegacyOrderServiceImpl.findMatchingItem(Order, OrderItem)"})
  public void testFindMatchingItemWithOrderOrderItem_thenThrowIllegalArgumentException() {
    // Arrange
    SkuImpl skuImpl = mock(SkuImpl.class);
    when(skuImpl.getId()).thenReturn(1L);
    BundleOrderItemImpl orderItem = mock(BundleOrderItemImpl.class);
    when(orderItem.getSku()).thenReturn(skuImpl);

    OrderImpl order = new OrderImpl();
    order.addOrderItem(orderItem);
    SkuImpl skuImpl2 = mock(SkuImpl.class);
    when(skuImpl2.getId()).thenThrow(new IllegalArgumentException("foo"));
    BundleOrderItemImpl itemToFind = mock(BundleOrderItemImpl.class);
    when(itemToFind.getSku()).thenReturn(skuImpl2);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> legacyOrderServiceImpl.findMatchingItem(order, itemToFind));
    verify(skuImpl).getId();
    verify(skuImpl2).getId();
    verify(orderItem, atLeast(1)).getSku();
    verify(itemToFind, atLeast(1)).getSku();
  }

  /**
   * Test {@link LegacyOrderServiceImpl#findMatchingItem(Order, OrderItem)} with {@code Order}, {@code OrderItem}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LegacyOrderServiceImpl#findMatchingItem(Order, OrderItem)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"OrderItem LegacyOrderServiceImpl.findMatchingItem(Order, OrderItem)"})
  public void testFindMatchingItemWithOrderOrderItem_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(legacyOrderServiceImpl.findMatchingItem(new NullOrderImpl(), (OrderItem) null));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#findMatchingItem(Order, OrderItem)} with {@code Order}, {@code OrderItem}.
   * <ul>
   *   <li>When {@link OrderImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LegacyOrderServiceImpl#findMatchingItem(Order, OrderItem)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"OrderItem LegacyOrderServiceImpl.findMatchingItem(Order, OrderItem)"})
  public void testFindMatchingItemWithOrderOrderItem_whenOrderImpl_thenReturnNull() {
    // Arrange
    OrderImpl order = new OrderImpl();

    // Act and Assert
    assertNull(legacyOrderServiceImpl.findMatchingItem(order, new BundleOrderItemImpl()));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#findMatchingItem(Order, OrderItem)} with {@code Order}, {@code OrderItem}.
   * <ul>
   *   <li>When {@link OrderImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LegacyOrderServiceImpl#findMatchingItem(Order, OrderItem)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"OrderItem LegacyOrderServiceImpl.findMatchingItem(Order, OrderItem)"})
  public void testFindMatchingItemWithOrderOrderItem_whenOrderImpl_thenReturnNull2() {
    // Arrange
    OrderImpl order = new OrderImpl();

    // Act and Assert
    assertNull(legacyOrderServiceImpl.findMatchingItem(order, new DiscreteOrderItemImpl()));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addOrderItemToBundle(Order, BundleOrderItem, DiscreteOrderItem, boolean)}.
   * <p>
   * Method under test: {@link LegacyOrderServiceImpl#addOrderItemToBundle(Order, BundleOrderItem, DiscreteOrderItem, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "OrderItem LegacyOrderServiceImpl.addOrderItemToBundle(Order, BundleOrderItem, DiscreteOrderItem, boolean)"})
  public void testAddOrderItemToBundle() throws PricingException {
    // Arrange
    when(pricingService.executePricing(Mockito.<Order>any())).thenThrow(new IllegalArgumentException("foo"));
    NullOrderImpl order = new NullOrderImpl();
    BundleOrderItemImpl bundle = new BundleOrderItemImpl();

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> legacyOrderServiceImpl.addOrderItemToBundle(order, bundle, new DiscreteOrderItemImpl(), true));
    verify(pricingService).executePricing(isA(Order.class));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addOrderItemToBundle(Order, BundleOrderItem, DiscreteOrderItem, boolean)}.
   * <ul>
   *   <li>Given {@link OrderDao} {@link OrderDao#save(Order)} return {@link OrderImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LegacyOrderServiceImpl#addOrderItemToBundle(Order, BundleOrderItem, DiscreteOrderItem, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "OrderItem LegacyOrderServiceImpl.addOrderItemToBundle(Order, BundleOrderItem, DiscreteOrderItem, boolean)"})
  public void testAddOrderItemToBundle_givenOrderDaoSaveReturnOrderImpl_thenReturnNull() throws PricingException {
    // Arrange
    when(orderDao.save(Mockito.<Order>any())).thenReturn(new OrderImpl());
    when(pricingService.executePricing(Mockito.<Order>any())).thenReturn(new NullOrderImpl());
    NullOrderImpl order = new NullOrderImpl();
    BundleOrderItemImpl bundle = new BundleOrderItemImpl();

    // Act
    OrderItem actualAddOrderItemToBundleResult = legacyOrderServiceImpl.addOrderItemToBundle(order, bundle,
        new DiscreteOrderItemImpl(), true);

    // Assert
    verify(orderDao).save(isA(Order.class));
    verify(pricingService).executePricing(isA(Order.class));
    assertNull(actualAddOrderItemToBundleResult);
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addOrderItemToBundle(Order, BundleOrderItem, DiscreteOrderItem, boolean)}.
   * <ul>
   *   <li>Given {@link PricingService}.</li>
   *   <li>Then calls {@link DiscreteOrderItem#setBundleOrderItem(BundleOrderItem)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LegacyOrderServiceImpl#addOrderItemToBundle(Order, BundleOrderItem, DiscreteOrderItem, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "OrderItem LegacyOrderServiceImpl.addOrderItemToBundle(Order, BundleOrderItem, DiscreteOrderItem, boolean)"})
  public void testAddOrderItemToBundle_givenPricingService_thenCallsSetBundleOrderItem() throws PricingException {
    // Arrange
    NullOrderImpl order = new NullOrderImpl();
    BundleOrderItemImpl bundle = new BundleOrderItemImpl();
    DiscreteOrderItem newOrderItem = mock(DiscreteOrderItem.class);
    doThrow(new IllegalArgumentException("foo")).when(newOrderItem).setBundleOrderItem(Mockito.<BundleOrderItem>any());

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> legacyOrderServiceImpl.addOrderItemToBundle(order, bundle, newOrderItem, true));
    verify(newOrderItem).setBundleOrderItem(isA(BundleOrderItem.class));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addOrUpdateOrderItemAttributes(Order, OrderItem, Map, boolean)}.
   * <ul>
   *   <li>Then return {@link OrderImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link LegacyOrderServiceImpl#addOrUpdateOrderItemAttributes(Order, OrderItem, Map, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Order LegacyOrderServiceImpl.addOrUpdateOrderItemAttributes(Order, OrderItem, Map, boolean)"})
  public void testAddOrUpdateOrderItemAttributes_thenReturnOrderImpl() throws ItemNotFoundException, PricingException {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    ArrayList<OrderItem> orderItems = new ArrayList<>();
    orderItems.add(new BundleOrderItemImpl());

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCurrency(new BroadleafCurrencyImpl());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
    order.setFulfillmentGroups(new ArrayList<>());
    order.setId(1L);
    order.setLocale(new LocaleImpl());
    order.setName("Name");
    order.setOrderAttributes(new HashMap<>());
    order.setOrderItems(orderItems);
    order.setOrderMessages(new ArrayList<>());
    order.setOrderNumber("42");
    order.setPayments(new ArrayList<>());
    order.setStatus(OrderStatus.ARCHIVED);
    order.setSubTotal(new Money());
    order.setSubmitDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());
    BundleOrderItemImpl item = new BundleOrderItemImpl();

    // Act and Assert
    assertSame(order, legacyOrderServiceImpl.addOrUpdateOrderItemAttributes(order, item, new HashMap<>(), true));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addOrUpdateOrderItemAttributes(Order, OrderItem, Map, boolean)}.
   * <ul>
   *   <li>Then throw {@link ItemNotFoundException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LegacyOrderServiceImpl#addOrUpdateOrderItemAttributes(Order, OrderItem, Map, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Order LegacyOrderServiceImpl.addOrUpdateOrderItemAttributes(Order, OrderItem, Map, boolean)"})
  public void testAddOrUpdateOrderItemAttributes_thenThrowItemNotFoundException()
      throws ItemNotFoundException, PricingException {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCurrency(new BroadleafCurrencyImpl());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
    order.setFulfillmentGroups(new ArrayList<>());
    order.setId(1L);
    order.setLocale(new LocaleImpl());
    order.setName("Name");
    order.setOrderAttributes(new HashMap<>());
    order.setOrderItems(new ArrayList<>());
    order.setOrderMessages(new ArrayList<>());
    order.setOrderNumber("42");
    order.setPayments(new ArrayList<>());
    order.setStatus(OrderStatus.ARCHIVED);
    order.setSubTotal(new Money());
    order.setSubmitDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());
    BundleOrderItemImpl item = new BundleOrderItemImpl();

    // Act and Assert
    assertThrows(ItemNotFoundException.class,
        () -> legacyOrderServiceImpl.addOrUpdateOrderItemAttributes(order, item, new HashMap<>(), true));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#removeOrderItemAttribute(Order, OrderItem, String, boolean)}.
   * <ul>
   *   <li>Then return {@link OrderImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link LegacyOrderServiceImpl#removeOrderItemAttribute(Order, OrderItem, String, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Order LegacyOrderServiceImpl.removeOrderItemAttribute(Order, OrderItem, String, boolean)"})
  public void testRemoveOrderItemAttribute_thenReturnOrderImpl() throws ItemNotFoundException, PricingException {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    ArrayList<OrderItem> orderItems = new ArrayList<>();
    orderItems.add(new BundleOrderItemImpl());

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCurrency(new BroadleafCurrencyImpl());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
    order.setFulfillmentGroups(new ArrayList<>());
    order.setId(1L);
    order.setLocale(new LocaleImpl());
    order.setName("Name");
    order.setOrderAttributes(new HashMap<>());
    order.setOrderMessages(new ArrayList<>());
    order.setOrderNumber("42");
    order.setPayments(new ArrayList<>());
    order.setStatus(OrderStatus.ARCHIVED);
    order.setSubTotal(new Money());
    order.setSubmitDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());
    order.setOrderItems(orderItems);

    // Act and Assert
    assertSame(order,
        legacyOrderServiceImpl.removeOrderItemAttribute(order, new BundleOrderItemImpl(), "Attribute Name", true));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#removeOrderItemAttribute(Order, OrderItem, String, boolean)}.
   * <ul>
   *   <li>Then throw {@link ItemNotFoundException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LegacyOrderServiceImpl#removeOrderItemAttribute(Order, OrderItem, String, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Order LegacyOrderServiceImpl.removeOrderItemAttribute(Order, OrderItem, String, boolean)"})
  public void testRemoveOrderItemAttribute_thenThrowItemNotFoundException()
      throws ItemNotFoundException, PricingException {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCurrency(new BroadleafCurrencyImpl());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
    order.setFulfillmentGroups(new ArrayList<>());
    order.setId(1L);
    order.setLocale(new LocaleImpl());
    order.setName("Name");
    order.setOrderAttributes(new HashMap<>());
    order.setOrderItems(new ArrayList<>());
    order.setOrderMessages(new ArrayList<>());
    order.setOrderNumber("42");
    order.setPayments(new ArrayList<>());
    order.setStatus(OrderStatus.ARCHIVED);
    order.setSubTotal(new Money());
    order.setSubmitDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());

    // Act and Assert
    assertThrows(ItemNotFoundException.class, () -> legacyOrderServiceImpl.removeOrderItemAttribute(order,
        new BundleOrderItemImpl(), "Attribute Name", true));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#createDefaultFulfillmentGroup(Order, Address)}.
   * <ul>
   *   <li>Then calls {@link FulfillmentGroupImpl#isPrimary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LegacyOrderServiceImpl#createDefaultFulfillmentGroup(Order, Address)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FulfillmentGroup LegacyOrderServiceImpl.createDefaultFulfillmentGroup(Order, Address)"})
  public void testCreateDefaultFulfillmentGroup_thenCallsIsPrimary() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);
    FulfillmentGroupImpl fulfillmentGroupImpl = mock(FulfillmentGroupImpl.class);
    when(fulfillmentGroupImpl.isPrimary()).thenReturn(true);
    doNothing().when(fulfillmentGroupImpl).setAddress(Mockito.<Address>any());
    doNothing().when(fulfillmentGroupImpl)
        .setCandidateFulfillmentGroupOffer(Mockito.<List<CandidateFulfillmentGroupOffer>>any());
    doNothing().when(fulfillmentGroupImpl).setDeliveryInstruction(Mockito.<String>any());
    doNothing().when(fulfillmentGroupImpl)
        .setFulfillmentGroupAdjustments(Mockito.<List<FulfillmentGroupAdjustment>>any());
    doNothing().when(fulfillmentGroupImpl).setFulfillmentGroupFees(Mockito.<List<FulfillmentGroupFee>>any());
    doNothing().when(fulfillmentGroupImpl).setFulfillmentGroupItems(Mockito.<List<FulfillmentGroupItem>>any());
    doNothing().when(fulfillmentGroupImpl).setFulfillmentOption(Mockito.<FulfillmentOption>any());
    doNothing().when(fulfillmentGroupImpl).setFulfillmentPrice(Mockito.<Money>any());
    doNothing().when(fulfillmentGroupImpl).setId(Mockito.<Long>any());
    doNothing().when(fulfillmentGroupImpl).setIsShippingPriceTaxable(Mockito.<Boolean>any());
    doNothing().when(fulfillmentGroupImpl).setMerchandiseTotal(Mockito.<Money>any());
    doNothing().when(fulfillmentGroupImpl).setMethod(Mockito.<String>any());
    doNothing().when(fulfillmentGroupImpl).setOrder(Mockito.<Order>any());
    doNothing().when(fulfillmentGroupImpl).setPersonalMessage(Mockito.<PersonalMessage>any());
    doNothing().when(fulfillmentGroupImpl).setPhone(Mockito.<Phone>any());
    doNothing().when(fulfillmentGroupImpl).setPrimary(anyBoolean());
    doNothing().when(fulfillmentGroupImpl).setReferenceNumber(Mockito.<String>any());
    doNothing().when(fulfillmentGroupImpl).setRetailFulfillmentPrice(Mockito.<Money>any());
    doNothing().when(fulfillmentGroupImpl).setSaleFulfillmentPrice(Mockito.<Money>any());
    doNothing().when(fulfillmentGroupImpl).setSequence(Mockito.<Integer>any());
    doNothing().when(fulfillmentGroupImpl).setService(Mockito.<String>any());
    doNothing().when(fulfillmentGroupImpl).setShippingOverride(Mockito.<Boolean>any());
    doNothing().when(fulfillmentGroupImpl).setStatus(Mockito.<FulfillmentGroupStatusType>any());
    doNothing().when(fulfillmentGroupImpl).setTaxes(Mockito.<List<TaxDetail>>any());
    doNothing().when(fulfillmentGroupImpl).setTotal(Mockito.<Money>any());
    doNothing().when(fulfillmentGroupImpl).setTotalFeeTax(Mockito.<Money>any());
    doNothing().when(fulfillmentGroupImpl).setTotalFulfillmentGroupTax(Mockito.<Money>any());
    doNothing().when(fulfillmentGroupImpl).setTotalItemTax(Mockito.<Money>any());
    doNothing().when(fulfillmentGroupImpl).setTotalTax(Mockito.<Money>any());
    doNothing().when(fulfillmentGroupImpl).setType(Mockito.<FulfillmentType>any());
    fulfillmentGroupImpl.setAddress(new AddressImpl());
    fulfillmentGroupImpl.setCandidateFulfillmentGroupOffer(new ArrayList<>());
    fulfillmentGroupImpl.setDeliveryInstruction("Delivery Instruction");
    fulfillmentGroupImpl.setFulfillmentGroupAdjustments(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentGroupFees(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentGroupItems(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentOption(new FulfillmentOptionImpl());
    fulfillmentGroupImpl.setFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setId(1L);
    fulfillmentGroupImpl.setIsShippingPriceTaxable(true);
    fulfillmentGroupImpl.setMerchandiseTotal(new Money());
    fulfillmentGroupImpl.setMethod("Fulfillment Method");
    fulfillmentGroupImpl.setOrder(new NullOrderImpl());
    fulfillmentGroupImpl.setPersonalMessage(new PersonalMessageImpl());
    fulfillmentGroupImpl.setPhone(new PhoneImpl());
    fulfillmentGroupImpl.setReferenceNumber("42");
    fulfillmentGroupImpl.setRetailFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setSaleFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setSequence(1);
    fulfillmentGroupImpl.setService("Service");
    fulfillmentGroupImpl.setShippingOverride(true);
    fulfillmentGroupImpl.setStatus(FulfillmentGroupStatusType.CANCELLED);
    fulfillmentGroupImpl.setTaxes(new ArrayList<>());
    fulfillmentGroupImpl.setTotal(new Money());
    fulfillmentGroupImpl.setTotalFeeTax(new Money());
    fulfillmentGroupImpl.setTotalFulfillmentGroupTax(new Money());
    fulfillmentGroupImpl.setTotalItemTax(new Money());
    fulfillmentGroupImpl.setTotalTax(new Money());
    fulfillmentGroupImpl.setType(FulfillmentType.DIGITAL);
    fulfillmentGroupImpl.setPrimary(false);

    ArrayList<FulfillmentGroup> fulfillmentGroups = new ArrayList<>();
    fulfillmentGroups.add(fulfillmentGroupImpl);

    ArrayList<OrderItem> orderItems = new ArrayList<>();
    orderItems.add(new BundleOrderItemImpl());

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCurrency(new BroadleafCurrencyImpl());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
    order.setId(1L);
    order.setLocale(new LocaleImpl());
    order.setName("Name");
    order.setOrderAttributes(new HashMap<>());
    order.setOrderMessages(new ArrayList<>());
    order.setOrderNumber("42");
    order.setPayments(new ArrayList<>());
    order.setStatus(OrderStatus.ARCHIVED);
    order.setSubTotal(new Money());
    order.setSubmitDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());
    order.setFulfillmentGroups(fulfillmentGroups);
    order.setOrderItems(orderItems);

    // Act
    legacyOrderServiceImpl.createDefaultFulfillmentGroup(order, new AddressImpl());

    // Assert
    verify(fulfillmentGroupImpl).isPrimary();
    verify(fulfillmentGroupImpl).setAddress(isA(Address.class));
    verify(fulfillmentGroupImpl).setCandidateFulfillmentGroupOffer(isA(List.class));
    verify(fulfillmentGroupImpl).setDeliveryInstruction(eq("Delivery Instruction"));
    verify(fulfillmentGroupImpl).setFulfillmentGroupAdjustments(isA(List.class));
    verify(fulfillmentGroupImpl).setFulfillmentGroupFees(isA(List.class));
    verify(fulfillmentGroupImpl).setFulfillmentGroupItems(isA(List.class));
    verify(fulfillmentGroupImpl).setFulfillmentOption(isA(FulfillmentOption.class));
    verify(fulfillmentGroupImpl).setFulfillmentPrice(isA(Money.class));
    verify(fulfillmentGroupImpl).setId(eq(1L));
    verify(fulfillmentGroupImpl).setIsShippingPriceTaxable(eq(true));
    verify(fulfillmentGroupImpl).setMerchandiseTotal(isA(Money.class));
    verify(fulfillmentGroupImpl).setMethod(eq("Fulfillment Method"));
    verify(fulfillmentGroupImpl).setOrder(isA(Order.class));
    verify(fulfillmentGroupImpl).setPersonalMessage(isA(PersonalMessage.class));
    verify(fulfillmentGroupImpl).setPhone(isA(Phone.class));
    verify(fulfillmentGroupImpl).setPrimary(eq(false));
    verify(fulfillmentGroupImpl).setReferenceNumber(eq("42"));
    verify(fulfillmentGroupImpl).setRetailFulfillmentPrice(isA(Money.class));
    verify(fulfillmentGroupImpl).setSaleFulfillmentPrice(isA(Money.class));
    verify(fulfillmentGroupImpl).setSequence(eq(1));
    verify(fulfillmentGroupImpl).setService(eq("Service"));
    verify(fulfillmentGroupImpl).setShippingOverride(eq(true));
    verify(fulfillmentGroupImpl).setStatus(isA(FulfillmentGroupStatusType.class));
    verify(fulfillmentGroupImpl).setTaxes(isA(List.class));
    verify(fulfillmentGroupImpl).setTotal(isA(Money.class));
    verify(fulfillmentGroupImpl).setTotalFeeTax(isA(Money.class));
    verify(fulfillmentGroupImpl).setTotalFulfillmentGroupTax(isA(Money.class));
    verify(fulfillmentGroupImpl).setTotalItemTax(isA(Money.class));
    verify(fulfillmentGroupImpl).setTotalTax(isA(Money.class));
    verify(fulfillmentGroupImpl).setType(isA(FulfillmentType.class));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#createDefaultFulfillmentGroup(Order, Address)}.
   * <ul>
   *   <li>Then return {@link FulfillmentGroupImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link LegacyOrderServiceImpl#createDefaultFulfillmentGroup(Order, Address)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FulfillmentGroup LegacyOrderServiceImpl.createDefaultFulfillmentGroup(Order, Address)"})
  public void testCreateDefaultFulfillmentGroup_thenReturnFulfillmentGroupImpl() {
    // Arrange
    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();
    when(fulfillmentGroupService.createEmptyFulfillmentGroup()).thenReturn(fulfillmentGroupImpl);
    when(fulfillmentGroupItemDao.create()).thenReturn(new FulfillmentGroupItemImpl());

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    FulfillmentGroupImpl fulfillmentGroupImpl2 = new FulfillmentGroupImpl();
    fulfillmentGroupImpl2.setAddress(new AddressImpl());
    fulfillmentGroupImpl2.setCandidateFulfillmentGroupOffer(new ArrayList<>());
    fulfillmentGroupImpl2.setDeliveryInstruction("Delivery Instruction");
    fulfillmentGroupImpl2.setFulfillmentGroupAdjustments(new ArrayList<>());
    fulfillmentGroupImpl2.setFulfillmentGroupFees(new ArrayList<>());
    fulfillmentGroupImpl2.setFulfillmentGroupItems(new ArrayList<>());
    fulfillmentGroupImpl2.setFulfillmentOption(new FulfillmentOptionImpl());
    fulfillmentGroupImpl2.setFulfillmentPrice(new Money());
    fulfillmentGroupImpl2.setId(1L);
    fulfillmentGroupImpl2.setIsShippingPriceTaxable(true);
    fulfillmentGroupImpl2.setMerchandiseTotal(new Money());
    fulfillmentGroupImpl2.setMethod("Fulfillment Method");
    fulfillmentGroupImpl2.setOrder(new NullOrderImpl());
    fulfillmentGroupImpl2.setPersonalMessage(new PersonalMessageImpl());
    fulfillmentGroupImpl2.setPhone(new PhoneImpl());
    fulfillmentGroupImpl2.setReferenceNumber("42");
    fulfillmentGroupImpl2.setRetailFulfillmentPrice(new Money());
    fulfillmentGroupImpl2.setSaleFulfillmentPrice(new Money());
    fulfillmentGroupImpl2.setSequence(1);
    fulfillmentGroupImpl2.setService("Service");
    fulfillmentGroupImpl2.setShippingOverride(true);
    fulfillmentGroupImpl2.setStatus(FulfillmentGroupStatusType.CANCELLED);
    fulfillmentGroupImpl2.setTaxes(new ArrayList<>());
    fulfillmentGroupImpl2.setTotal(new Money());
    fulfillmentGroupImpl2.setTotalFeeTax(new Money());
    fulfillmentGroupImpl2.setTotalFulfillmentGroupTax(new Money());
    fulfillmentGroupImpl2.setTotalItemTax(new Money());
    fulfillmentGroupImpl2.setTotalTax(new Money());
    fulfillmentGroupImpl2.setType(FulfillmentType.DIGITAL);
    fulfillmentGroupImpl2.setPrimary(false);

    ArrayList<FulfillmentGroup> fulfillmentGroups = new ArrayList<>();
    fulfillmentGroups.add(fulfillmentGroupImpl2);

    ArrayList<OrderItem> orderItems = new ArrayList<>();
    orderItems.add(new BundleOrderItemImpl());

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCurrency(new BroadleafCurrencyImpl());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
    order.setId(1L);
    order.setLocale(new LocaleImpl());
    order.setName("Name");
    order.setOrderAttributes(new HashMap<>());
    order.setOrderMessages(new ArrayList<>());
    order.setOrderNumber("42");
    order.setPayments(new ArrayList<>());
    order.setStatus(OrderStatus.ARCHIVED);
    order.setSubTotal(new Money());
    order.setSubmitDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());
    order.setFulfillmentGroups(fulfillmentGroups);
    order.setOrderItems(orderItems);

    // Act
    FulfillmentGroup actualCreateDefaultFulfillmentGroupResult = legacyOrderServiceImpl
        .createDefaultFulfillmentGroup(order, new AddressImpl());

    // Assert
    verify(fulfillmentGroupItemDao).create();
    verify(fulfillmentGroupService).createEmptyFulfillmentGroup();
    assertSame(fulfillmentGroupImpl, actualCreateDefaultFulfillmentGroupResult);
  }

  /**
   * Test {@link LegacyOrderServiceImpl#createDefaultFulfillmentGroup(Order, Address)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LegacyOrderServiceImpl#createDefaultFulfillmentGroup(Order, Address)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FulfillmentGroup LegacyOrderServiceImpl.createDefaultFulfillmentGroup(Order, Address)"})
  public void testCreateDefaultFulfillmentGroup_thenThrowIllegalArgumentException() {
    // Arrange
    when(fulfillmentGroupService.createEmptyFulfillmentGroup()).thenReturn(new FulfillmentGroupImpl());
    when(fulfillmentGroupItemDao.create()).thenThrow(new IllegalArgumentException("foo"));

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();
    fulfillmentGroupImpl.setAddress(new AddressImpl());
    fulfillmentGroupImpl.setCandidateFulfillmentGroupOffer(new ArrayList<>());
    fulfillmentGroupImpl.setDeliveryInstruction("Delivery Instruction");
    fulfillmentGroupImpl.setFulfillmentGroupAdjustments(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentGroupFees(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentGroupItems(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentOption(new FulfillmentOptionImpl());
    fulfillmentGroupImpl.setFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setId(1L);
    fulfillmentGroupImpl.setIsShippingPriceTaxable(true);
    fulfillmentGroupImpl.setMerchandiseTotal(new Money());
    fulfillmentGroupImpl.setMethod("Fulfillment Method");
    fulfillmentGroupImpl.setOrder(new NullOrderImpl());
    fulfillmentGroupImpl.setPersonalMessage(new PersonalMessageImpl());
    fulfillmentGroupImpl.setPhone(new PhoneImpl());
    fulfillmentGroupImpl.setReferenceNumber("42");
    fulfillmentGroupImpl.setRetailFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setSaleFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setSequence(1);
    fulfillmentGroupImpl.setService("Service");
    fulfillmentGroupImpl.setShippingOverride(true);
    fulfillmentGroupImpl.setStatus(FulfillmentGroupStatusType.CANCELLED);
    fulfillmentGroupImpl.setTaxes(new ArrayList<>());
    fulfillmentGroupImpl.setTotal(new Money());
    fulfillmentGroupImpl.setTotalFeeTax(new Money());
    fulfillmentGroupImpl.setTotalFulfillmentGroupTax(new Money());
    fulfillmentGroupImpl.setTotalItemTax(new Money());
    fulfillmentGroupImpl.setTotalTax(new Money());
    fulfillmentGroupImpl.setType(FulfillmentType.DIGITAL);
    fulfillmentGroupImpl.setPrimary(false);

    ArrayList<FulfillmentGroup> fulfillmentGroups = new ArrayList<>();
    fulfillmentGroups.add(fulfillmentGroupImpl);

    ArrayList<OrderItem> orderItems = new ArrayList<>();
    orderItems.add(new BundleOrderItemImpl());

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCurrency(new BroadleafCurrencyImpl());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
    order.setId(1L);
    order.setLocale(new LocaleImpl());
    order.setName("Name");
    order.setOrderAttributes(new HashMap<>());
    order.setOrderMessages(new ArrayList<>());
    order.setOrderNumber("42");
    order.setPayments(new ArrayList<>());
    order.setStatus(OrderStatus.ARCHIVED);
    order.setSubTotal(new Money());
    order.setSubmitDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());
    order.setFulfillmentGroups(fulfillmentGroups);
    order.setOrderItems(orderItems);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> legacyOrderServiceImpl.createDefaultFulfillmentGroup(order, new AddressImpl()));
    verify(fulfillmentGroupItemDao).create();
    verify(fulfillmentGroupService).createEmptyFulfillmentGroup();
  }

  /**
   * Test {@link LegacyOrderServiceImpl#findOrderByOrderNumber(String)}.
   * <ul>
   *   <li>Then return {@link NullOrderImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link LegacyOrderServiceImpl#findOrderByOrderNumber(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Order LegacyOrderServiceImpl.findOrderByOrderNumber(String)"})
  public void testFindOrderByOrderNumber_thenReturnNullOrderImpl() {
    // Arrange
    NullOrderImpl nullOrderImpl = new NullOrderImpl();
    when(orderDao.readOrderByOrderNumber(Mockito.<String>any())).thenReturn(nullOrderImpl);

    // Act
    Order actualFindOrderByOrderNumberResult = legacyOrderServiceImpl.findOrderByOrderNumber("42");

    // Assert
    verify(orderDao).readOrderByOrderNumber(eq("42"));
    assertSame(nullOrderImpl, actualFindOrderByOrderNumberResult);
  }

  /**
   * Test {@link LegacyOrderServiceImpl#findOrderByOrderNumber(String)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LegacyOrderServiceImpl#findOrderByOrderNumber(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Order LegacyOrderServiceImpl.findOrderByOrderNumber(String)"})
  public void testFindOrderByOrderNumber_thenThrowIllegalArgumentException() {
    // Arrange
    when(orderDao.readOrderByOrderNumber(Mockito.<String>any())).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> legacyOrderServiceImpl.findOrderByOrderNumber("42"));
    verify(orderDao).readOrderByOrderNumber(eq("42"));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#updateOrder(Order, Boolean)}.
   * <ul>
   *   <li>Given {@link OrderDao}.</li>
   *   <li>When {@code true}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LegacyOrderServiceImpl#updateOrder(Order, Boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Order LegacyOrderServiceImpl.updateOrder(Order, Boolean)"})
  public void testUpdateOrder_givenOrderDao_whenTrue_thenThrowIllegalArgumentException() throws PricingException {
    // Arrange
    when(pricingService.executePricing(Mockito.<Order>any())).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> legacyOrderServiceImpl.updateOrder(new NullOrderImpl(), true));
    verify(pricingService).executePricing(isA(Order.class));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#updateOrder(Order, Boolean)}.
   * <ul>
   *   <li>Given {@link PricingService} {@link PricingService#executePricing(Order)} return {@link NullOrderImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link LegacyOrderServiceImpl#updateOrder(Order, Boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Order LegacyOrderServiceImpl.updateOrder(Order, Boolean)"})
  public void testUpdateOrder_givenPricingServiceExecutePricingReturnNullOrderImpl() throws PricingException {
    // Arrange
    when(orderDao.save(Mockito.<Order>any())).thenReturn(new NullOrderImpl());
    when(pricingService.executePricing(Mockito.<Order>any())).thenReturn(new NullOrderImpl());

    // Act
    Order actualUpdateOrderResult = legacyOrderServiceImpl.updateOrder(new NullOrderImpl(), true);

    // Assert
    verify(orderDao).save(isA(Order.class));
    verify(pricingService).executePricing(isA(Order.class));
    assertTrue(actualUpdateOrderResult instanceof NullOrderImpl);
    Money orderAdjustmentsValue = actualUpdateOrderResult.getOrderAdjustmentsValue();
    assertEquals(orderAdjustmentsValue, orderAdjustmentsValue.abs());
    assertEquals(orderAdjustmentsValue, orderAdjustmentsValue.zero());
    assertEquals(orderAdjustmentsValue, actualUpdateOrderResult.getSubTotal());
  }

  /**
   * Test {@link LegacyOrderServiceImpl#updateOrder(Order, Boolean)}.
   * <ul>
   *   <li>Given {@link PricingService}.</li>
   *   <li>When {@code false}.</li>
   *   <li>Then return {@link NullOrderImpl}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LegacyOrderServiceImpl#updateOrder(Order, Boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Order LegacyOrderServiceImpl.updateOrder(Order, Boolean)"})
  public void testUpdateOrder_givenPricingService_whenFalse_thenReturnNullOrderImpl() throws PricingException {
    // Arrange
    when(orderDao.save(Mockito.<Order>any())).thenReturn(new NullOrderImpl());

    // Act
    Order actualUpdateOrderResult = legacyOrderServiceImpl.updateOrder(new NullOrderImpl(), false);

    // Assert
    verify(orderDao).save(isA(Order.class));
    assertTrue(actualUpdateOrderResult instanceof NullOrderImpl);
    Money orderAdjustmentsValue = actualUpdateOrderResult.getOrderAdjustmentsValue();
    assertEquals(orderAdjustmentsValue, orderAdjustmentsValue.abs());
    assertEquals(orderAdjustmentsValue, orderAdjustmentsValue.zero());
    assertEquals(orderAdjustmentsValue, actualUpdateOrderResult.getSubTotal());
  }

  /**
   * Test {@link LegacyOrderServiceImpl#persistOrder(Order)}.
   * <ul>
   *   <li>Given {@link OrderDao} {@link OrderDao#save(Order)} return {@link NullOrderImpl} (default constructor).</li>
   *   <li>Then return {@link NullOrderImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link LegacyOrderServiceImpl#persistOrder(Order)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Order LegacyOrderServiceImpl.persistOrder(Order)"})
  public void testPersistOrder_givenOrderDaoSaveReturnNullOrderImpl_thenReturnNullOrderImpl() {
    // Arrange
    NullOrderImpl nullOrderImpl = new NullOrderImpl();
    when(orderDao.save(Mockito.<Order>any())).thenReturn(nullOrderImpl);

    // Act
    Order actualPersistOrderResult = legacyOrderServiceImpl.persistOrder(new NullOrderImpl());

    // Assert
    verify(orderDao).save(isA(Order.class));
    assertSame(nullOrderImpl, actualPersistOrderResult);
  }

  /**
   * Test {@link LegacyOrderServiceImpl#persistOrder(Order)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LegacyOrderServiceImpl#persistOrder(Order)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Order LegacyOrderServiceImpl.persistOrder(Order)"})
  public void testPersistOrder_thenThrowIllegalArgumentException() {
    // Arrange
    when(orderDao.save(Mockito.<Order>any())).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> legacyOrderServiceImpl.persistOrder(new NullOrderImpl()));
    verify(orderDao).save(isA(Order.class));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#createFulfillmentGroupItemFromOrderItem(OrderItem, FulfillmentGroup, int)}.
   * <ul>
   *   <li>Then return {@link FulfillmentGroupItemImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link LegacyOrderServiceImpl#createFulfillmentGroupItemFromOrderItem(OrderItem, FulfillmentGroup, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "FulfillmentGroupItem LegacyOrderServiceImpl.createFulfillmentGroupItemFromOrderItem(OrderItem, FulfillmentGroup, int)"})
  public void testCreateFulfillmentGroupItemFromOrderItem_thenReturnFulfillmentGroupItemImpl() {
    // Arrange
    FulfillmentGroupItemImpl fulfillmentGroupItemImpl = new FulfillmentGroupItemImpl();
    when(fulfillmentGroupItemDao.create()).thenReturn(fulfillmentGroupItemImpl);
    BundleOrderItemImpl orderItem = new BundleOrderItemImpl();

    // Act
    FulfillmentGroupItem actualCreateFulfillmentGroupItemFromOrderItemResult = legacyOrderServiceImpl
        .createFulfillmentGroupItemFromOrderItem(orderItem, new FulfillmentGroupImpl(), 1);

    // Assert
    verify(fulfillmentGroupItemDao).create();
    assertSame(fulfillmentGroupItemImpl, actualCreateFulfillmentGroupItemFromOrderItemResult);
  }

  /**
   * Test {@link LegacyOrderServiceImpl#createFulfillmentGroupItemFromOrderItem(OrderItem, FulfillmentGroup, int)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LegacyOrderServiceImpl#createFulfillmentGroupItemFromOrderItem(OrderItem, FulfillmentGroup, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "FulfillmentGroupItem LegacyOrderServiceImpl.createFulfillmentGroupItemFromOrderItem(OrderItem, FulfillmentGroup, int)"})
  public void testCreateFulfillmentGroupItemFromOrderItem_thenThrowIllegalArgumentException() {
    // Arrange
    when(fulfillmentGroupItemDao.create()).thenThrow(new IllegalArgumentException("foo"));
    BundleOrderItemImpl orderItem = new BundleOrderItemImpl();

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> legacyOrderServiceImpl.createFulfillmentGroupItemFromOrderItem(orderItem, new FulfillmentGroupImpl(), 1));
    verify(fulfillmentGroupItemDao).create();
  }

  /**
   * Test {@link LegacyOrderServiceImpl#createBundleOrderItemRequest(BundleOrderItem, List)}.
   * <ul>
   *   <li>Then return DiscreteOrderItems is {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LegacyOrderServiceImpl#createBundleOrderItemRequest(BundleOrderItem, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "BundleOrderItemRequest LegacyOrderServiceImpl.createBundleOrderItemRequest(BundleOrderItem, List)"})
  public void testCreateBundleOrderItemRequest_thenReturnDiscreteOrderItemsIsArrayList() {
    // Arrange
    BundleOrderItemImpl bundleOrderItem = new BundleOrderItemImpl();

    ArrayList<DiscreteOrderItemRequest> discreteOrderItemRequests = new ArrayList<>();
    discreteOrderItemRequests.add(new DiscreteOrderItemRequest());

    // Act and Assert
    assertSame(discreteOrderItemRequests,
        legacyOrderServiceImpl.createBundleOrderItemRequest(bundleOrderItem, discreteOrderItemRequests)
            .getDiscreteOrderItems());
  }

  /**
   * Test {@link LegacyOrderServiceImpl#createBundleOrderItemRequest(BundleOrderItem, List)}.
   * <ul>
   *   <li>Then return DiscreteOrderItems size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link LegacyOrderServiceImpl#createBundleOrderItemRequest(BundleOrderItem, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "BundleOrderItemRequest LegacyOrderServiceImpl.createBundleOrderItemRequest(BundleOrderItem, List)"})
  public void testCreateBundleOrderItemRequest_thenReturnDiscreteOrderItemsSizeIsTwo() {
    // Arrange
    BundleOrderItemImpl bundleOrderItem = new BundleOrderItemImpl();

    ArrayList<DiscreteOrderItemRequest> discreteOrderItemRequests = new ArrayList<>();
    discreteOrderItemRequests.add(new DiscreteOrderItemRequest());
    DiscreteOrderItemRequest discreteOrderItemRequest = new DiscreteOrderItemRequest();
    discreteOrderItemRequests.add(discreteOrderItemRequest);

    // Act and Assert
    List<DiscreteOrderItemRequest> discreteOrderItems = legacyOrderServiceImpl
        .createBundleOrderItemRequest(bundleOrderItem, discreteOrderItemRequests)
        .getDiscreteOrderItems();
    assertEquals(2, discreteOrderItems.size());
    assertSame(discreteOrderItemRequest, discreteOrderItems.get(1));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#createBundleOrderItemRequest(BundleOrderItem, List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return Name is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LegacyOrderServiceImpl#createBundleOrderItemRequest(BundleOrderItem, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "BundleOrderItemRequest LegacyOrderServiceImpl.createBundleOrderItemRequest(BundleOrderItem, List)"})
  public void testCreateBundleOrderItemRequest_whenArrayList_thenReturnNameIsNull() {
    // Arrange
    BundleOrderItemImpl bundleOrderItem = new BundleOrderItemImpl();

    // Act
    BundleOrderItemRequest actualCreateBundleOrderItemRequestResult = legacyOrderServiceImpl
        .createBundleOrderItemRequest(bundleOrderItem, new ArrayList<>());

    // Assert
    assertNull(actualCreateBundleOrderItemRequestResult.getName());
    assertNull(actualCreateBundleOrderItemRequestResult.getRetailPriceOverride());
    assertNull(actualCreateBundleOrderItemRequestResult.getSalePriceOverride());
    assertNull(actualCreateBundleOrderItemRequestResult.getCategory());
    assertNull(actualCreateBundleOrderItemRequestResult.getOrder());
    assertEquals(0, actualCreateBundleOrderItemRequestResult.getQuantity());
    assertTrue(actualCreateBundleOrderItemRequestResult.getBundleOrderItemFeePrices().isEmpty());
    assertTrue(actualCreateBundleOrderItemRequestResult.getDiscreteOrderItems().isEmpty());
  }

  /**
   * Test {@link LegacyOrderServiceImpl#validateOrder(Long)}.
   * <ul>
   *   <li>Given {@link OrderDao} {@link OrderDao#readOrderById(Long)} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LegacyOrderServiceImpl#validateOrder(Long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Order LegacyOrderServiceImpl.validateOrder(Long)"})
  public void testValidateOrder_givenOrderDaoReadOrderByIdReturnNull() {
    // Arrange
    when(orderDao.readOrderById(Mockito.<Long>any())).thenReturn(null);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> legacyOrderServiceImpl.validateOrder(1L));
    verify(orderDao).readOrderById(eq(1L));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#validateOrder(Long)}.
   * <ul>
   *   <li>Given {@link OrderDao}.</li>
   *   <li>When {@code null}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LegacyOrderServiceImpl#validateOrder(Long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Order LegacyOrderServiceImpl.validateOrder(Long)"})
  public void testValidateOrder_givenOrderDao_whenNull_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> legacyOrderServiceImpl.validateOrder(null));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#validateOrder(Long)}.
   * <ul>
   *   <li>Then return {@link NullOrderImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link LegacyOrderServiceImpl#validateOrder(Long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Order LegacyOrderServiceImpl.validateOrder(Long)"})
  public void testValidateOrder_thenReturnNullOrderImpl() {
    // Arrange
    NullOrderImpl nullOrderImpl = new NullOrderImpl();
    when(orderDao.readOrderById(Mockito.<Long>any())).thenReturn(nullOrderImpl);

    // Act
    Order actualValidateOrderResult = legacyOrderServiceImpl.validateOrder(1L);

    // Assert
    verify(orderDao).readOrderById(eq(1L));
    assertSame(nullOrderImpl, actualValidateOrderResult);
  }

  /**
   * Test {@link LegacyOrderServiceImpl#validateProduct(Long)}.
   * <p>
   * Method under test: {@link LegacyOrderServiceImpl#validateProduct(Long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Product LegacyOrderServiceImpl.validateProduct(Long)"})
  public void testValidateProduct() {
    // Arrange
    when(productDao.readProductById(Mockito.<Long>any()))
        .thenThrow(new IllegalArgumentException("No product found matching passed in productId "));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> legacyOrderServiceImpl.validateProduct(1L));
    verify(productDao).readProductById(eq(1L));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#validateProduct(Long)}.
   * <ul>
   *   <li>Given {@link ProductDao} {@link ProductDao#readProductById(Long)} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LegacyOrderServiceImpl#validateProduct(Long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Product LegacyOrderServiceImpl.validateProduct(Long)"})
  public void testValidateProduct_givenProductDaoReadProductByIdReturnNull() {
    // Arrange
    when(productDao.readProductById(Mockito.<Long>any())).thenReturn(null);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> legacyOrderServiceImpl.validateProduct(1L));
    verify(productDao).readProductById(eq(1L));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#validateProduct(Long)}.
   * <ul>
   *   <li>Given {@link ProductDao}.</li>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LegacyOrderServiceImpl#validateProduct(Long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Product LegacyOrderServiceImpl.validateProduct(Long)"})
  public void testValidateProduct_givenProductDao_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(legacyOrderServiceImpl.validateProduct(null));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#validateProduct(Long)}.
   * <ul>
   *   <li>Then return {@link ProductBundleImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link LegacyOrderServiceImpl#validateProduct(Long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Product LegacyOrderServiceImpl.validateProduct(Long)"})
  public void testValidateProduct_thenReturnProductBundleImpl() {
    // Arrange
    ProductBundleImpl productBundleImpl = new ProductBundleImpl();
    when(productDao.readProductById(Mockito.<Long>any())).thenReturn(productBundleImpl);

    // Act
    Product actualValidateProductResult = legacyOrderServiceImpl.validateProduct(1L);

    // Assert
    verify(productDao).readProductById(eq(1L));
    assertSame(productBundleImpl, actualValidateProductResult);
  }

  /**
   * Test {@link LegacyOrderServiceImpl#determineCategory(Product, Long)}.
   * <ul>
   *   <li>Given {@link CategoryDao}.</li>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LegacyOrderServiceImpl#determineCategory(Product, Long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "org.broadleafcommerce.core.catalog.domain.Category LegacyOrderServiceImpl.determineCategory(Product, Long)"})
  public void testDetermineCategory_givenCategoryDao_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(legacyOrderServiceImpl.determineCategory(null, null));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#determineCategory(Product, Long)}.
   * <ul>
   *   <li>Given {@link CategoryDao}.</li>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LegacyOrderServiceImpl#determineCategory(Product, Long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "org.broadleafcommerce.core.catalog.domain.Category LegacyOrderServiceImpl.determineCategory(Product, Long)"})
  public void testDetermineCategory_givenCategoryDao_whenNull_thenReturnNull2() {
    // Arrange, Act and Assert
    assertNull(legacyOrderServiceImpl.determineCategory(new ProductBundleImpl(), null));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#determineCategory(Product, Long)}.
   * <ul>
   *   <li>Then return {@link CategoryImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link LegacyOrderServiceImpl#determineCategory(Product, Long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "org.broadleafcommerce.core.catalog.domain.Category LegacyOrderServiceImpl.determineCategory(Product, Long)"})
  public void testDetermineCategory_thenReturnCategoryImpl() {
    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();
    when(categoryDao.readCategoryById(Mockito.<Long>any())).thenReturn(categoryImpl);

    // Act
    org.broadleafcommerce.core.catalog.domain.Category actualDetermineCategoryResult = legacyOrderServiceImpl
        .determineCategory(new ProductBundleImpl(), 1L);

    // Assert
    verify(categoryDao).readCategoryById(eq(1L));
    assertSame(categoryImpl, actualDetermineCategoryResult);
  }

  /**
   * Test {@link LegacyOrderServiceImpl#determineCategory(Product, Long)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LegacyOrderServiceImpl#determineCategory(Product, Long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "org.broadleafcommerce.core.catalog.domain.Category LegacyOrderServiceImpl.determineCategory(Product, Long)"})
  public void testDetermineCategory_thenThrowIllegalArgumentException() {
    // Arrange
    when(categoryDao.readCategoryById(Mockito.<Long>any())).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> legacyOrderServiceImpl.determineCategory(new ProductBundleImpl(), 1L));
    verify(categoryDao).readCategoryById(eq(1L));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#determineSku(Product, Long, Map)}.
   * <ul>
   *   <li>Given {@link SkuDao} {@link SkuDao#readSkuById(Long)} return {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LegacyOrderServiceImpl#determineSku(Product, Long, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Sku LegacyOrderServiceImpl.determineSku(Product, Long, Map)"})
  public void testDetermineSku_givenSkuDaoReadSkuByIdReturnNull_thenReturnNull() {
    // Arrange
    when(skuDao.readSkuById(Mockito.<Long>any())).thenReturn(null);
    ProductBundleImpl product = new ProductBundleImpl();

    // Act
    Sku actualDetermineSkuResult = legacyOrderServiceImpl.determineSku(product, 1L, new HashMap<>());

    // Assert
    verify(skuDao).readSkuById(eq(1L));
    assertNull(actualDetermineSkuResult);
  }

  /**
   * Test {@link LegacyOrderServiceImpl#determineSku(Product, Long, Map)}.
   * <ul>
   *   <li>Given {@link SkuDao} {@link SkuDao#readSkuById(Long)} return {@link SkuImpl} (default constructor).</li>
   *   <li>Then return {@link SkuImpl}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LegacyOrderServiceImpl#determineSku(Product, Long, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Sku LegacyOrderServiceImpl.determineSku(Product, Long, Map)"})
  public void testDetermineSku_givenSkuDaoReadSkuByIdReturnSkuImpl_thenReturnSkuImpl() {
    // Arrange
    when(skuDao.readSkuById(Mockito.<Long>any())).thenReturn(new SkuImpl());
    ProductBundleImpl product = new ProductBundleImpl();

    // Act
    Sku actualDetermineSkuResult = legacyOrderServiceImpl.determineSku(product, 1L, new HashMap<>());

    // Assert
    verify(skuDao).readSkuById(eq(1L));
    assertTrue(actualDetermineSkuResult instanceof SkuImpl);
    Money margin = actualDetermineSkuResult.getMargin();
    assertEquals(margin, margin.abs());
    assertEquals(margin, margin.zero());
  }

  /**
   * Test {@link LegacyOrderServiceImpl#determineSku(Product, Long, Map)}.
   * <ul>
   *   <li>Given {@link SkuDao} {@link SkuDao#readSkuById(Long)} return {@link SkuImpl} (default constructor).</li>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@link SkuImpl}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LegacyOrderServiceImpl#determineSku(Product, Long, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Sku LegacyOrderServiceImpl.determineSku(Product, Long, Map)"})
  public void testDetermineSku_givenSkuDaoReadSkuByIdReturnSkuImpl_whenNull_thenReturnSkuImpl() {
    // Arrange
    when(skuDao.readSkuById(Mockito.<Long>any())).thenReturn(new SkuImpl());

    // Act
    Sku actualDetermineSkuResult = legacyOrderServiceImpl.determineSku(null, 1L, new HashMap<>());

    // Assert
    verify(skuDao).readSkuById(eq(1L));
    assertTrue(actualDetermineSkuResult instanceof SkuImpl);
    Money margin = actualDetermineSkuResult.getMargin();
    assertEquals(margin, margin.abs());
    assertEquals(margin, margin.zero());
  }

  /**
   * Test {@link LegacyOrderServiceImpl#findMatchingSku(Product, Map)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LegacyOrderServiceImpl#findMatchingSku(Product, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Sku LegacyOrderServiceImpl.findMatchingSku(Product, Map)"})
  public void testFindMatchingSku_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(legacyOrderServiceImpl.findMatchingSku(null, new HashMap<>()));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#findMatchingSku(Product, Map)}.
   * <ul>
   *   <li>When {@link ProductBundleImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LegacyOrderServiceImpl#findMatchingSku(Product, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Sku LegacyOrderServiceImpl.findMatchingSku(Product, Map)"})
  public void testFindMatchingSku_whenProductBundleImpl_thenReturnNull() {
    // Arrange
    ProductBundleImpl product = new ProductBundleImpl();

    // Act and Assert
    assertNull(legacyOrderServiceImpl.findMatchingSku(product, new HashMap<>()));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#checkSkuForMatch(Sku, Map)}.
   * <ul>
   *   <li>Given {@code foo}.</li>
   *   <li>When {@link SkuImpl} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LegacyOrderServiceImpl#checkSkuForMatch(Sku, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean LegacyOrderServiceImpl.checkSkuForMatch(Sku, Map)"})
  public void testCheckSkuForMatch_givenFoo_whenSkuImpl_thenReturnFalse() {
    // Arrange
    SkuImpl sku = new SkuImpl();

    HashMap<String, String> attributeValues = new HashMap<>();
    attributeValues.put("foo", "foo");

    // Act and Assert
    assertFalse(legacyOrderServiceImpl.checkSkuForMatch(sku, attributeValues));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#checkSkuForMatch(Sku, Map)}.
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LegacyOrderServiceImpl#checkSkuForMatch(Sku, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean LegacyOrderServiceImpl.checkSkuForMatch(Sku, Map)"})
  public void testCheckSkuForMatch_whenHashMap_thenReturnFalse() {
    // Arrange
    SkuImpl sku = new SkuImpl();

    // Act and Assert
    assertFalse(legacyOrderServiceImpl.checkSkuForMatch(sku, new HashMap<>()));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addItemToOrder(Long, OrderItemRequestDTO, boolean)}.
   * <p>
   * Method under test: {@link LegacyOrderServiceImpl#addItemToOrder(Long, OrderItemRequestDTO, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Order LegacyOrderServiceImpl.addItemToOrder(Long, OrderItemRequestDTO, boolean)"})
  public void testAddItemToOrder() throws PricingException {
    // Arrange
    when(orderDao.readOrderById(Mockito.<Long>any())).thenReturn(new OrderImpl());
    when(pricingService.executePricing(Mockito.<Order>any())).thenThrow(new IllegalArgumentException("name"));
    when(categoryDao.readCategoryById(Mockito.<Long>any())).thenReturn(new CategoryImpl());
    when(orderItemDao.create(Mockito.<OrderItemType>any())).thenReturn(new BundleOrderItemImpl());
    ProductBundleImpl productBundleImpl = mock(ProductBundleImpl.class);
    when(productBundleImpl.getName()).thenReturn("Name");
    when(productBundleImpl.getSkuBundleItems()).thenReturn(new ArrayList<>());
    when(productBundleImpl.getProductOptions()).thenReturn(new ArrayList<>());
    when(productDao.readProductById(Mockito.<Long>any())).thenReturn(productBundleImpl);
    when(skuDao.readSkuById(Mockito.<Long>any())).thenReturn(new SkuImpl());

    ConfigurableOrderItemRequest orderItemRequestDTO = new ConfigurableOrderItemRequest();
    orderItemRequestDTO.setAdditionalAttributes(new HashMap<>());
    orderItemRequestDTO.setCategoryId(1L);
    orderItemRequestDTO.setChildOrderItems(new ArrayList<>());
    orderItemRequestDTO.setDiscountsAllowed(true);
    orderItemRequestDTO.setDisplayPrice(new Money());
    orderItemRequestDTO.setExpandable(true);
    orderItemRequestDTO.setFirstExpandable(true);
    orderItemRequestDTO.setHasConfigurationError(true);
    orderItemRequestDTO.setHasOverridenPrice(true);
    orderItemRequestDTO.setIsMultiSelect(true);
    orderItemRequestDTO.setItemAttributes(new HashMap<>());
    orderItemRequestDTO.setLastExpandable(true);
    orderItemRequestDTO.setMaxQuantity(3);
    orderItemRequestDTO.setMinQuantity(1);
    orderItemRequestDTO.setOrderItemId(1L);
    orderItemRequestDTO.setOrderItemIndex(1);
    orderItemRequestDTO.setOverrideRetailPrice(new Money());
    orderItemRequestDTO.setOverrideSalePrice(new Money());
    orderItemRequestDTO.setParentOrderItemId(1L);
    orderItemRequestDTO.setPricingModelType("Not adding item to order because quantity is zero.");
    orderItemRequestDTO.setProduct(new ProductBundleImpl());
    orderItemRequestDTO.setProductChoices(new ArrayList<>());
    orderItemRequestDTO.setProductId(1L);
    orderItemRequestDTO.setQuantity(1);
    orderItemRequestDTO.setSku(new SkuImpl());
    orderItemRequestDTO.setSkuId(1L);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> legacyOrderServiceImpl.addItemToOrder(1L, orderItemRequestDTO, true));
    verify(categoryDao).readCategoryById(eq(1L));
    verify(productDao).readProductById(eq(1L));
    verify(skuDao).readSkuById(eq(1L));
    verify(productBundleImpl).getSkuBundleItems();
    verify(productBundleImpl).getName();
    verify(productBundleImpl, atLeast(1)).getProductOptions();
    verify(orderDao).readOrderById(eq(1L));
    verify(orderItemDao).create(isA(OrderItemType.class));
    verify(pricingService).executePricing(isA(Order.class));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addItemToOrder(Long, OrderItemRequestDTO, boolean)}.
   * <ul>
   *   <li>Given minus one.</li>
   *   <li>When {@link OrderItemRequestDTO#OrderItemRequestDTO()} Quantity is minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link LegacyOrderServiceImpl#addItemToOrder(Long, OrderItemRequestDTO, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Order LegacyOrderServiceImpl.addItemToOrder(Long, OrderItemRequestDTO, boolean)"})
  public void testAddItemToOrder_givenMinusOne_whenOrderItemRequestDTOQuantityIsMinusOne() throws PricingException {
    // Arrange
    OrderItemRequestDTO orderItemRequestDTO = new OrderItemRequestDTO();
    orderItemRequestDTO.setQuantity(-1);
    orderItemRequestDTO.setCategoryId(null);
    orderItemRequestDTO.setProductId(null);
    orderItemRequestDTO.setSkuId(null);
    orderItemRequestDTO.setItemAttributes(new HashMap<>());

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> legacyOrderServiceImpl.addItemToOrder(null, orderItemRequestDTO, true));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addItemToOrder(Long, OrderItemRequestDTO, boolean)}.
   * <ul>
   *   <li>Given {@link OrderDao} {@link OrderDao#readOrderById(Long)} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LegacyOrderServiceImpl#addItemToOrder(Long, OrderItemRequestDTO, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Order LegacyOrderServiceImpl.addItemToOrder(Long, OrderItemRequestDTO, boolean)"})
  public void testAddItemToOrder_givenOrderDaoReadOrderByIdReturnNull() throws PricingException {
    // Arrange
    when(orderDao.readOrderById(Mockito.<Long>any())).thenReturn(null);

    ConfigurableOrderItemRequest orderItemRequestDTO = new ConfigurableOrderItemRequest();
    orderItemRequestDTO.setAdditionalAttributes(new HashMap<>());
    orderItemRequestDTO.setCategoryId(1L);
    orderItemRequestDTO.setChildOrderItems(new ArrayList<>());
    orderItemRequestDTO.setDiscountsAllowed(true);
    orderItemRequestDTO.setDisplayPrice(new Money());
    orderItemRequestDTO.setExpandable(true);
    orderItemRequestDTO.setFirstExpandable(true);
    orderItemRequestDTO.setHasConfigurationError(true);
    orderItemRequestDTO.setHasOverridenPrice(true);
    orderItemRequestDTO.setIsMultiSelect(true);
    orderItemRequestDTO.setItemAttributes(new HashMap<>());
    orderItemRequestDTO.setLastExpandable(true);
    orderItemRequestDTO.setMaxQuantity(3);
    orderItemRequestDTO.setMinQuantity(1);
    orderItemRequestDTO.setOrderItemId(1L);
    orderItemRequestDTO.setOrderItemIndex(1);
    orderItemRequestDTO.setOverrideRetailPrice(new Money());
    orderItemRequestDTO.setOverrideSalePrice(new Money());
    orderItemRequestDTO.setParentOrderItemId(1L);
    orderItemRequestDTO.setPricingModelType("Not adding item to order because quantity is zero.");
    orderItemRequestDTO.setProduct(new ProductBundleImpl());
    orderItemRequestDTO.setProductChoices(new ArrayList<>());
    orderItemRequestDTO.setProductId(1L);
    orderItemRequestDTO.setQuantity(1);
    orderItemRequestDTO.setSku(new SkuImpl());
    orderItemRequestDTO.setSkuId(1L);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> legacyOrderServiceImpl.addItemToOrder(1L, orderItemRequestDTO, true));
    verify(orderDao).readOrderById(eq(1L));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addItemToOrder(Long, OrderItemRequestDTO, boolean)}.
   * <ul>
   *   <li>Given {@link OrderDao} {@link OrderDao#save(Order)} return {@link NullOrderImpl} (default constructor).</li>
   *   <li>Then return {@link NullOrderImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link LegacyOrderServiceImpl#addItemToOrder(Long, OrderItemRequestDTO, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Order LegacyOrderServiceImpl.addItemToOrder(Long, OrderItemRequestDTO, boolean)"})
  public void testAddItemToOrder_givenOrderDaoSaveReturnNullOrderImpl_thenReturnNullOrderImpl()
      throws PricingException {
    // Arrange
    NullOrderImpl nullOrderImpl = new NullOrderImpl();
    when(orderDao.save(Mockito.<Order>any())).thenReturn(nullOrderImpl);
    when(orderDao.readOrderById(Mockito.<Long>any())).thenReturn(new OrderImpl());
    when(pricingService.executePricing(Mockito.<Order>any())).thenReturn(new NullOrderImpl());
    when(categoryDao.readCategoryById(Mockito.<Long>any())).thenReturn(new CategoryImpl());
    when(orderItemDao.create(Mockito.<OrderItemType>any())).thenReturn(new BundleOrderItemImpl());
    ProductBundleImpl productBundleImpl = mock(ProductBundleImpl.class);
    when(productBundleImpl.getName()).thenReturn("Name");
    when(productBundleImpl.getSkuBundleItems()).thenReturn(new ArrayList<>());
    when(productBundleImpl.getProductOptions()).thenReturn(new ArrayList<>());
    when(productDao.readProductById(Mockito.<Long>any())).thenReturn(productBundleImpl);
    when(skuDao.readSkuById(Mockito.<Long>any())).thenReturn(new SkuImpl());

    ConfigurableOrderItemRequest orderItemRequestDTO = new ConfigurableOrderItemRequest();
    orderItemRequestDTO.setAdditionalAttributes(new HashMap<>());
    orderItemRequestDTO.setCategoryId(1L);
    orderItemRequestDTO.setChildOrderItems(new ArrayList<>());
    orderItemRequestDTO.setDiscountsAllowed(true);
    orderItemRequestDTO.setDisplayPrice(new Money());
    orderItemRequestDTO.setExpandable(true);
    orderItemRequestDTO.setFirstExpandable(true);
    orderItemRequestDTO.setHasConfigurationError(true);
    orderItemRequestDTO.setHasOverridenPrice(true);
    orderItemRequestDTO.setIsMultiSelect(true);
    orderItemRequestDTO.setItemAttributes(new HashMap<>());
    orderItemRequestDTO.setLastExpandable(true);
    orderItemRequestDTO.setMaxQuantity(3);
    orderItemRequestDTO.setMinQuantity(1);
    orderItemRequestDTO.setOrderItemId(1L);
    orderItemRequestDTO.setOrderItemIndex(1);
    orderItemRequestDTO.setOverrideRetailPrice(new Money());
    orderItemRequestDTO.setOverrideSalePrice(new Money());
    orderItemRequestDTO.setParentOrderItemId(1L);
    orderItemRequestDTO.setPricingModelType("Not adding item to order because quantity is zero.");
    orderItemRequestDTO.setProduct(new ProductBundleImpl());
    orderItemRequestDTO.setProductChoices(new ArrayList<>());
    orderItemRequestDTO.setProductId(1L);
    orderItemRequestDTO.setQuantity(1);
    orderItemRequestDTO.setSku(new SkuImpl());
    orderItemRequestDTO.setSkuId(1L);

    // Act
    Order actualAddItemToOrderResult = legacyOrderServiceImpl.addItemToOrder(1L, orderItemRequestDTO, true);

    // Assert
    verify(categoryDao).readCategoryById(eq(1L));
    verify(productDao).readProductById(eq(1L));
    verify(skuDao).readSkuById(eq(1L));
    verify(productBundleImpl).getSkuBundleItems();
    verify(productBundleImpl).getName();
    verify(productBundleImpl, atLeast(1)).getProductOptions();
    verify(orderDao).readOrderById(eq(1L));
    verify(orderDao).save(isA(Order.class));
    verify(orderItemDao).create(isA(OrderItemType.class));
    verify(pricingService).executePricing(isA(Order.class));
    assertSame(nullOrderImpl, actualAddItemToOrderResult);
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addItemToOrder(Long, OrderItemRequestDTO, boolean)}.
   * <ul>
   *   <li>Given {@link OrderDao}.</li>
   *   <li>When {@link OrderItemRequestDTO#OrderItemRequestDTO()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LegacyOrderServiceImpl#addItemToOrder(Long, OrderItemRequestDTO, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Order LegacyOrderServiceImpl.addItemToOrder(Long, OrderItemRequestDTO, boolean)"})
  public void testAddItemToOrder_givenOrderDao_whenOrderItemRequestDTO_thenReturnNull() throws PricingException {
    // Arrange, Act and Assert
    assertNull(legacyOrderServiceImpl.addItemToOrder(1L, new OrderItemRequestDTO(), true));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addItemToOrder(Long, OrderItemRequestDTO, boolean)}.
   * <ul>
   *   <li>Given {@link OrderItemDao} {@link OrderItemDao#create(OrderItemType)} throw {@link IllegalArgumentException#IllegalArgumentException(String)} with {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LegacyOrderServiceImpl#addItemToOrder(Long, OrderItemRequestDTO, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Order LegacyOrderServiceImpl.addItemToOrder(Long, OrderItemRequestDTO, boolean)"})
  public void testAddItemToOrder_givenOrderItemDaoCreateThrowIllegalArgumentExceptionWithFoo() throws PricingException {
    // Arrange
    when(orderDao.readOrderById(Mockito.<Long>any())).thenReturn(new NullOrderImpl());
    when(categoryDao.readCategoryById(Mockito.<Long>any())).thenReturn(new CategoryImpl());
    when(orderItemDao.create(Mockito.<OrderItemType>any())).thenThrow(new IllegalArgumentException("foo"));
    when(productDao.readProductById(Mockito.<Long>any())).thenReturn(new ProductBundleImpl());
    when(skuDao.readSkuById(Mockito.<Long>any())).thenReturn(new SkuImpl());

    ConfigurableOrderItemRequest orderItemRequestDTO = new ConfigurableOrderItemRequest();
    orderItemRequestDTO.setAdditionalAttributes(new HashMap<>());
    orderItemRequestDTO.setCategoryId(1L);
    orderItemRequestDTO.setChildOrderItems(new ArrayList<>());
    orderItemRequestDTO.setDiscountsAllowed(true);
    orderItemRequestDTO.setDisplayPrice(new Money());
    orderItemRequestDTO.setExpandable(true);
    orderItemRequestDTO.setFirstExpandable(true);
    orderItemRequestDTO.setHasConfigurationError(true);
    orderItemRequestDTO.setHasOverridenPrice(true);
    orderItemRequestDTO.setIsMultiSelect(true);
    orderItemRequestDTO.setItemAttributes(new HashMap<>());
    orderItemRequestDTO.setLastExpandable(true);
    orderItemRequestDTO.setMaxQuantity(3);
    orderItemRequestDTO.setMinQuantity(1);
    orderItemRequestDTO.setOrderItemId(1L);
    orderItemRequestDTO.setOrderItemIndex(1);
    orderItemRequestDTO.setOverrideRetailPrice(new Money());
    orderItemRequestDTO.setOverrideSalePrice(new Money());
    orderItemRequestDTO.setParentOrderItemId(1L);
    orderItemRequestDTO.setPricingModelType("Not adding item to order because quantity is zero.");
    orderItemRequestDTO.setProduct(new ProductBundleImpl());
    orderItemRequestDTO.setProductChoices(new ArrayList<>());
    orderItemRequestDTO.setProductId(1L);
    orderItemRequestDTO.setQuantity(1);
    orderItemRequestDTO.setSku(new SkuImpl());
    orderItemRequestDTO.setSkuId(1L);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> legacyOrderServiceImpl.addItemToOrder(1L, orderItemRequestDTO, true));
    verify(categoryDao).readCategoryById(eq(1L));
    verify(productDao).readProductById(eq(1L));
    verify(skuDao).readSkuById(eq(1L));
    verify(orderDao).readOrderById(eq(1L));
    verify(orderItemDao).create(isA(OrderItemType.class));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addItemToOrder(Long, OrderItemRequestDTO, boolean)}.
   * <ul>
   *   <li>Given {@link ProductBundleImpl} {@link ProductImpl#getDefaultSku()} return {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LegacyOrderServiceImpl#addItemToOrder(Long, OrderItemRequestDTO, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Order LegacyOrderServiceImpl.addItemToOrder(Long, OrderItemRequestDTO, boolean)"})
  public void testAddItemToOrder_givenProductBundleImplGetDefaultSkuReturnNull_thenReturnNull()
      throws PricingException {
    // Arrange
    when(orderDao.readOrderById(Mockito.<Long>any())).thenReturn(mock(Order.class));
    ProductBundleImpl productBundleImpl = mock(ProductBundleImpl.class);
    when(productBundleImpl.getAdditionalSkus()).thenReturn(new ArrayList<>());
    when(productBundleImpl.getDefaultSku()).thenReturn(null);
    when(productBundleImpl.getProductOptions()).thenReturn(new ArrayList<>());
    when(productDao.readProductById(Mockito.<Long>any())).thenReturn(productBundleImpl);
    when(skuDao.readSkuById(Mockito.<Long>any())).thenReturn(null);

    ConfigurableOrderItemRequest orderItemRequestDTO = new ConfigurableOrderItemRequest();
    orderItemRequestDTO.setAdditionalAttributes(new HashMap<>());
    orderItemRequestDTO.setCategoryId(1L);
    orderItemRequestDTO.setChildOrderItems(new ArrayList<>());
    orderItemRequestDTO.setDiscountsAllowed(true);
    orderItemRequestDTO.setDisplayPrice(new Money());
    orderItemRequestDTO.setExpandable(true);
    orderItemRequestDTO.setFirstExpandable(true);
    orderItemRequestDTO.setHasConfigurationError(true);
    orderItemRequestDTO.setHasOverridenPrice(true);
    orderItemRequestDTO.setIsMultiSelect(true);
    orderItemRequestDTO.setItemAttributes(new HashMap<>());
    orderItemRequestDTO.setLastExpandable(true);
    orderItemRequestDTO.setMaxQuantity(3);
    orderItemRequestDTO.setMinQuantity(1);
    orderItemRequestDTO.setOrderItemId(1L);
    orderItemRequestDTO.setOrderItemIndex(1);
    orderItemRequestDTO.setOverrideRetailPrice(new Money());
    orderItemRequestDTO.setOverrideSalePrice(new Money());
    orderItemRequestDTO.setParentOrderItemId(1L);
    orderItemRequestDTO.setPricingModelType("Not adding item to order because quantity is zero.");
    orderItemRequestDTO.setProduct(new ProductBundleImpl());
    orderItemRequestDTO.setProductChoices(new ArrayList<>());
    orderItemRequestDTO.setProductId(1L);
    orderItemRequestDTO.setQuantity(1);
    orderItemRequestDTO.setSku(new SkuImpl());
    orderItemRequestDTO.setSkuId(1L);

    // Act
    Order actualAddItemToOrderResult = legacyOrderServiceImpl.addItemToOrder(1L, orderItemRequestDTO, true);

    // Assert
    verify(productDao).readProductById(eq(1L));
    verify(skuDao).readSkuById(eq(1L));
    verify(productBundleImpl, atLeast(1)).getAdditionalSkus();
    verify(productBundleImpl).getDefaultSku();
    verify(productBundleImpl, atLeast(1)).getProductOptions();
    verify(orderDao).readOrderById(eq(1L));
    assertNull(actualAddItemToOrderResult);
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addItemToOrder(Long, OrderItemRequestDTO, boolean)}.
   * <ul>
   *   <li>Given {@link ProductBundleImpl} {@link ProductImpl#getDefaultSku()} return {@link SkuImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link LegacyOrderServiceImpl#addItemToOrder(Long, OrderItemRequestDTO, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Order LegacyOrderServiceImpl.addItemToOrder(Long, OrderItemRequestDTO, boolean)"})
  public void testAddItemToOrder_givenProductBundleImplGetDefaultSkuReturnSkuImpl() throws PricingException {
    // Arrange
    when(orderDao.readOrderById(Mockito.<Long>any())).thenReturn(mock(Order.class));
    when(categoryDao.readCategoryById(Mockito.<Long>any())).thenReturn(null);
    ProductBundleImpl productBundleImpl = mock(ProductBundleImpl.class);
    when(productBundleImpl.getAdditionalSkus()).thenReturn(new ArrayList<>());
    when(productBundleImpl.getDefaultSku()).thenReturn(new SkuImpl());
    when(productBundleImpl.getDefaultCategory()).thenThrow(new IllegalArgumentException("foo"));
    when(productBundleImpl.getProductOptions()).thenReturn(new ArrayList<>());
    when(productDao.readProductById(Mockito.<Long>any())).thenReturn(productBundleImpl);
    when(skuDao.readSkuById(Mockito.<Long>any())).thenReturn(null);

    ConfigurableOrderItemRequest orderItemRequestDTO = new ConfigurableOrderItemRequest();
    orderItemRequestDTO.setAdditionalAttributes(new HashMap<>());
    orderItemRequestDTO.setCategoryId(1L);
    orderItemRequestDTO.setChildOrderItems(new ArrayList<>());
    orderItemRequestDTO.setDiscountsAllowed(true);
    orderItemRequestDTO.setDisplayPrice(new Money());
    orderItemRequestDTO.setExpandable(true);
    orderItemRequestDTO.setFirstExpandable(true);
    orderItemRequestDTO.setHasConfigurationError(true);
    orderItemRequestDTO.setHasOverridenPrice(true);
    orderItemRequestDTO.setIsMultiSelect(true);
    orderItemRequestDTO.setItemAttributes(new HashMap<>());
    orderItemRequestDTO.setLastExpandable(true);
    orderItemRequestDTO.setMaxQuantity(3);
    orderItemRequestDTO.setMinQuantity(1);
    orderItemRequestDTO.setOrderItemId(1L);
    orderItemRequestDTO.setOrderItemIndex(1);
    orderItemRequestDTO.setOverrideRetailPrice(new Money());
    orderItemRequestDTO.setOverrideSalePrice(new Money());
    orderItemRequestDTO.setParentOrderItemId(1L);
    orderItemRequestDTO.setPricingModelType("Not adding item to order because quantity is zero.");
    orderItemRequestDTO.setProduct(new ProductBundleImpl());
    orderItemRequestDTO.setProductChoices(new ArrayList<>());
    orderItemRequestDTO.setProductId(1L);
    orderItemRequestDTO.setQuantity(1);
    orderItemRequestDTO.setSku(new SkuImpl());
    orderItemRequestDTO.setSkuId(1L);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> legacyOrderServiceImpl.addItemToOrder(1L, orderItemRequestDTO, true));
    verify(categoryDao).readCategoryById(eq(1L));
    verify(productDao).readProductById(eq(1L));
    verify(skuDao).readSkuById(eq(1L));
    verify(productBundleImpl, atLeast(1)).getAdditionalSkus();
    verify(productBundleImpl).getDefaultCategory();
    verify(productBundleImpl).getDefaultSku();
    verify(productBundleImpl, atLeast(1)).getProductOptions();
    verify(orderDao).readOrderById(eq(1L));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addItemToOrder(Long, OrderItemRequestDTO, boolean)}.
   * <ul>
   *   <li>Given {@link ProductDao} {@link ProductDao#readProductById(Long)} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LegacyOrderServiceImpl#addItemToOrder(Long, OrderItemRequestDTO, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Order LegacyOrderServiceImpl.addItemToOrder(Long, OrderItemRequestDTO, boolean)"})
  public void testAddItemToOrder_givenProductDaoReadProductByIdReturnNull() throws PricingException {
    // Arrange
    when(orderDao.readOrderById(Mockito.<Long>any())).thenReturn(new NullOrderImpl());
    when(productDao.readProductById(Mockito.<Long>any())).thenReturn(null);

    ConfigurableOrderItemRequest orderItemRequestDTO = new ConfigurableOrderItemRequest();
    orderItemRequestDTO.setAdditionalAttributes(new HashMap<>());
    orderItemRequestDTO.setCategoryId(1L);
    orderItemRequestDTO.setChildOrderItems(new ArrayList<>());
    orderItemRequestDTO.setDiscountsAllowed(true);
    orderItemRequestDTO.setDisplayPrice(new Money());
    orderItemRequestDTO.setExpandable(true);
    orderItemRequestDTO.setFirstExpandable(true);
    orderItemRequestDTO.setHasConfigurationError(true);
    orderItemRequestDTO.setHasOverridenPrice(true);
    orderItemRequestDTO.setIsMultiSelect(true);
    orderItemRequestDTO.setItemAttributes(new HashMap<>());
    orderItemRequestDTO.setLastExpandable(true);
    orderItemRequestDTO.setMaxQuantity(3);
    orderItemRequestDTO.setMinQuantity(1);
    orderItemRequestDTO.setOrderItemId(1L);
    orderItemRequestDTO.setOrderItemIndex(1);
    orderItemRequestDTO.setOverrideRetailPrice(new Money());
    orderItemRequestDTO.setOverrideSalePrice(new Money());
    orderItemRequestDTO.setParentOrderItemId(1L);
    orderItemRequestDTO.setPricingModelType("Not adding item to order because quantity is zero.");
    orderItemRequestDTO.setProduct(new ProductBundleImpl());
    orderItemRequestDTO.setProductChoices(new ArrayList<>());
    orderItemRequestDTO.setProductId(1L);
    orderItemRequestDTO.setQuantity(1);
    orderItemRequestDTO.setSku(new SkuImpl());
    orderItemRequestDTO.setSkuId(1L);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> legacyOrderServiceImpl.addItemToOrder(1L, orderItemRequestDTO, true));
    verify(productDao).readProductById(eq(1L));
    verify(orderDao).readOrderById(eq(1L));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addItemToOrder(Long, OrderItemRequestDTO, boolean)}.
   * <ul>
   *   <li>Given two.</li>
   *   <li>When {@link OrderItemRequestDTO#OrderItemRequestDTO()} Quantity is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link LegacyOrderServiceImpl#addItemToOrder(Long, OrderItemRequestDTO, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Order LegacyOrderServiceImpl.addItemToOrder(Long, OrderItemRequestDTO, boolean)"})
  public void testAddItemToOrder_givenTwo_whenOrderItemRequestDTOQuantityIsTwo() throws PricingException {
    // Arrange
    OrderItemRequestDTO orderItemRequestDTO = new OrderItemRequestDTO();
    orderItemRequestDTO.setQuantity(2);
    orderItemRequestDTO.setCategoryId(null);
    orderItemRequestDTO.setProductId(null);
    orderItemRequestDTO.setSkuId(null);
    orderItemRequestDTO.setItemAttributes(new HashMap<>());

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> legacyOrderServiceImpl.addItemToOrder(null, orderItemRequestDTO, true));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addItemToOrder(Long, OrderItemRequestDTO, boolean)}.
   * <ul>
   *   <li>Given zero.</li>
   *   <li>When {@link OrderItemRequestDTO#OrderItemRequestDTO()} Quantity is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link LegacyOrderServiceImpl#addItemToOrder(Long, OrderItemRequestDTO, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Order LegacyOrderServiceImpl.addItemToOrder(Long, OrderItemRequestDTO, boolean)"})
  public void testAddItemToOrder_givenZero_whenOrderItemRequestDTOQuantityIsZero() throws PricingException {
    // Arrange
    OrderItemRequestDTO orderItemRequestDTO = new OrderItemRequestDTO();
    orderItemRequestDTO.setQuantity(0);
    orderItemRequestDTO.setCategoryId(null);
    orderItemRequestDTO.setProductId(null);
    orderItemRequestDTO.setSkuId(null);
    orderItemRequestDTO.setItemAttributes(new HashMap<>());

    // Act and Assert
    assertNull(legacyOrderServiceImpl.addItemToOrder(null, orderItemRequestDTO, true));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addItemToOrder(Long, OrderItemRequestDTO, boolean)}.
   * <ul>
   *   <li>Then calls {@link ProductImpl#getDefaultCategory()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LegacyOrderServiceImpl#addItemToOrder(Long, OrderItemRequestDTO, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Order LegacyOrderServiceImpl.addItemToOrder(Long, OrderItemRequestDTO, boolean)"})
  public void testAddItemToOrder_thenCallsGetDefaultCategory() throws PricingException {
    // Arrange
    when(orderDao.readOrderById(Mockito.<Long>any())).thenReturn(mock(Order.class));
    when(categoryDao.readCategoryById(Mockito.<Long>any())).thenReturn(null);
    ProductBundleImpl productBundleImpl = mock(ProductBundleImpl.class);
    when(productBundleImpl.getDefaultCategory()).thenThrow(new IllegalArgumentException("foo"));
    when(productBundleImpl.getProductOptions()).thenReturn(new ArrayList<>());
    when(productDao.readProductById(Mockito.<Long>any())).thenReturn(productBundleImpl);
    when(skuDao.readSkuById(Mockito.<Long>any())).thenReturn(new SkuImpl());

    ConfigurableOrderItemRequest orderItemRequestDTO = new ConfigurableOrderItemRequest();
    orderItemRequestDTO.setAdditionalAttributes(new HashMap<>());
    orderItemRequestDTO.setCategoryId(1L);
    orderItemRequestDTO.setChildOrderItems(new ArrayList<>());
    orderItemRequestDTO.setDiscountsAllowed(true);
    orderItemRequestDTO.setDisplayPrice(new Money());
    orderItemRequestDTO.setExpandable(true);
    orderItemRequestDTO.setFirstExpandable(true);
    orderItemRequestDTO.setHasConfigurationError(true);
    orderItemRequestDTO.setHasOverridenPrice(true);
    orderItemRequestDTO.setIsMultiSelect(true);
    orderItemRequestDTO.setItemAttributes(new HashMap<>());
    orderItemRequestDTO.setLastExpandable(true);
    orderItemRequestDTO.setMaxQuantity(3);
    orderItemRequestDTO.setMinQuantity(1);
    orderItemRequestDTO.setOrderItemId(1L);
    orderItemRequestDTO.setOrderItemIndex(1);
    orderItemRequestDTO.setOverrideRetailPrice(new Money());
    orderItemRequestDTO.setOverrideSalePrice(new Money());
    orderItemRequestDTO.setParentOrderItemId(1L);
    orderItemRequestDTO.setPricingModelType("Not adding item to order because quantity is zero.");
    orderItemRequestDTO.setProduct(new ProductBundleImpl());
    orderItemRequestDTO.setProductChoices(new ArrayList<>());
    orderItemRequestDTO.setProductId(1L);
    orderItemRequestDTO.setQuantity(1);
    orderItemRequestDTO.setSku(new SkuImpl());
    orderItemRequestDTO.setSkuId(1L);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> legacyOrderServiceImpl.addItemToOrder(1L, orderItemRequestDTO, true));
    verify(categoryDao).readCategoryById(eq(1L));
    verify(productDao).readProductById(eq(1L));
    verify(skuDao).readSkuById(eq(1L));
    verify(productBundleImpl).getDefaultCategory();
    verify(productBundleImpl, atLeast(1)).getProductOptions();
    verify(orderDao).readOrderById(eq(1L));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addItemToOrder(Long, OrderItemRequestDTO, boolean)}.
   * <ul>
   *   <li>Then calls {@link Order#getOrderItems()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LegacyOrderServiceImpl#addItemToOrder(Long, OrderItemRequestDTO, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Order LegacyOrderServiceImpl.addItemToOrder(Long, OrderItemRequestDTO, boolean)"})
  public void testAddItemToOrder_thenCallsGetOrderItems() throws PricingException {
    // Arrange
    Order order = mock(Order.class);
    when(order.getOrderItems()).thenThrow(new IllegalArgumentException("foo"));
    when(orderDao.readOrderById(Mockito.<Long>any())).thenReturn(order);
    when(categoryDao.readCategoryById(Mockito.<Long>any())).thenReturn(new CategoryImpl());
    when(orderItemDao.create(Mockito.<OrderItemType>any())).thenReturn(new BundleOrderItemImpl());
    ProductBundleImpl productBundleImpl = mock(ProductBundleImpl.class);
    when(productBundleImpl.getName()).thenReturn("Name");
    when(productBundleImpl.getSkuBundleItems()).thenReturn(new ArrayList<>());
    when(productBundleImpl.getProductOptions()).thenReturn(new ArrayList<>());
    when(productDao.readProductById(Mockito.<Long>any())).thenReturn(productBundleImpl);
    when(skuDao.readSkuById(Mockito.<Long>any())).thenReturn(new SkuImpl());

    ConfigurableOrderItemRequest orderItemRequestDTO = new ConfigurableOrderItemRequest();
    orderItemRequestDTO.setAdditionalAttributes(new HashMap<>());
    orderItemRequestDTO.setCategoryId(1L);
    orderItemRequestDTO.setChildOrderItems(new ArrayList<>());
    orderItemRequestDTO.setDiscountsAllowed(true);
    orderItemRequestDTO.setDisplayPrice(new Money());
    orderItemRequestDTO.setExpandable(true);
    orderItemRequestDTO.setFirstExpandable(true);
    orderItemRequestDTO.setHasConfigurationError(true);
    orderItemRequestDTO.setHasOverridenPrice(true);
    orderItemRequestDTO.setIsMultiSelect(true);
    orderItemRequestDTO.setItemAttributes(new HashMap<>());
    orderItemRequestDTO.setLastExpandable(true);
    orderItemRequestDTO.setMaxQuantity(3);
    orderItemRequestDTO.setMinQuantity(1);
    orderItemRequestDTO.setOrderItemId(1L);
    orderItemRequestDTO.setOrderItemIndex(1);
    orderItemRequestDTO.setOverrideRetailPrice(new Money());
    orderItemRequestDTO.setOverrideSalePrice(new Money());
    orderItemRequestDTO.setParentOrderItemId(1L);
    orderItemRequestDTO.setPricingModelType("Not adding item to order because quantity is zero.");
    orderItemRequestDTO.setProduct(new ProductBundleImpl());
    orderItemRequestDTO.setProductChoices(new ArrayList<>());
    orderItemRequestDTO.setProductId(1L);
    orderItemRequestDTO.setQuantity(1);
    orderItemRequestDTO.setSku(new SkuImpl());
    orderItemRequestDTO.setSkuId(1L);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> legacyOrderServiceImpl.addItemToOrder(1L, orderItemRequestDTO, true));
    verify(categoryDao).readCategoryById(eq(1L));
    verify(productDao).readProductById(eq(1L));
    verify(skuDao).readSkuById(eq(1L));
    verify(productBundleImpl).getSkuBundleItems();
    verify(productBundleImpl).getName();
    verify(productBundleImpl, atLeast(1)).getProductOptions();
    verify(orderDao).readOrderById(eq(1L));
    verify(orderItemDao).create(isA(OrderItemType.class));
    verify(order).getOrderItems();
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addItemToOrder(Long, OrderItemRequestDTO, boolean)}.
   * <ul>
   *   <li>Then throw {@link RequiredAttributeNotProvidedException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LegacyOrderServiceImpl#addItemToOrder(Long, OrderItemRequestDTO, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Order LegacyOrderServiceImpl.addItemToOrder(Long, OrderItemRequestDTO, boolean)"})
  public void testAddItemToOrder_thenThrowRequiredAttributeNotProvidedException() throws PricingException {
    // Arrange
    when(orderDao.readOrderById(Mockito.<Long>any())).thenReturn(mock(Order.class));

    ArrayList<Sku> skuList = new ArrayList<>();
    skuList.add(new SkuImpl());
    ProductBundleImpl productBundleImpl = mock(ProductBundleImpl.class);
    when(productBundleImpl.getAdditionalSkus()).thenReturn(skuList);
    when(productBundleImpl.getProductOptions()).thenReturn(new ArrayList<>());
    when(productDao.readProductById(Mockito.<Long>any())).thenReturn(productBundleImpl);
    when(skuDao.readSkuById(Mockito.<Long>any())).thenReturn(null);

    ConfigurableOrderItemRequest orderItemRequestDTO = new ConfigurableOrderItemRequest();
    orderItemRequestDTO.setAdditionalAttributes(new HashMap<>());
    orderItemRequestDTO.setCategoryId(1L);
    orderItemRequestDTO.setChildOrderItems(new ArrayList<>());
    orderItemRequestDTO.setDiscountsAllowed(true);
    orderItemRequestDTO.setDisplayPrice(new Money());
    orderItemRequestDTO.setExpandable(true);
    orderItemRequestDTO.setFirstExpandable(true);
    orderItemRequestDTO.setHasConfigurationError(true);
    orderItemRequestDTO.setHasOverridenPrice(true);
    orderItemRequestDTO.setIsMultiSelect(true);
    orderItemRequestDTO.setItemAttributes(new HashMap<>());
    orderItemRequestDTO.setLastExpandable(true);
    orderItemRequestDTO.setMaxQuantity(3);
    orderItemRequestDTO.setMinQuantity(1);
    orderItemRequestDTO.setOrderItemId(1L);
    orderItemRequestDTO.setOrderItemIndex(1);
    orderItemRequestDTO.setOverrideRetailPrice(new Money());
    orderItemRequestDTO.setOverrideSalePrice(new Money());
    orderItemRequestDTO.setParentOrderItemId(1L);
    orderItemRequestDTO.setPricingModelType("Not adding item to order because quantity is zero.");
    orderItemRequestDTO.setProduct(new ProductBundleImpl());
    orderItemRequestDTO.setProductChoices(new ArrayList<>());
    orderItemRequestDTO.setProductId(1L);
    orderItemRequestDTO.setQuantity(1);
    orderItemRequestDTO.setSku(new SkuImpl());
    orderItemRequestDTO.setSkuId(1L);

    // Act and Assert
    assertThrows(RequiredAttributeNotProvidedException.class,
        () -> legacyOrderServiceImpl.addItemToOrder(1L, orderItemRequestDTO, true));
    verify(productDao).readProductById(eq(1L));
    verify(skuDao).readSkuById(eq(1L));
    verify(productBundleImpl, atLeast(1)).getAdditionalSkus();
    verify(productBundleImpl, atLeast(1)).getProductOptions();
    verify(orderDao).readOrderById(eq(1L));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addItemToOrder(Long, OrderItemRequestDTO, boolean)}.
   * <ul>
   *   <li>When {@link ConfigurableOrderItemRequest} (default constructor) CategoryId is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LegacyOrderServiceImpl#addItemToOrder(Long, OrderItemRequestDTO, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Order LegacyOrderServiceImpl.addItemToOrder(Long, OrderItemRequestDTO, boolean)"})
  public void testAddItemToOrder_whenConfigurableOrderItemRequestCategoryIdIsNull() throws PricingException {
    // Arrange
    when(orderDao.readOrderById(Mockito.<Long>any())).thenReturn(mock(Order.class));
    ProductBundleImpl productBundleImpl = mock(ProductBundleImpl.class);
    when(productBundleImpl.getAdditionalSkus()).thenReturn(new ArrayList<>());
    when(productBundleImpl.getDefaultSku()).thenReturn(new SkuImpl());
    when(productBundleImpl.getDefaultCategory()).thenThrow(new IllegalArgumentException("foo"));
    when(productBundleImpl.getProductOptions()).thenReturn(new ArrayList<>());
    when(productDao.readProductById(Mockito.<Long>any())).thenReturn(productBundleImpl);
    when(skuDao.readSkuById(Mockito.<Long>any())).thenReturn(null);

    ConfigurableOrderItemRequest orderItemRequestDTO = new ConfigurableOrderItemRequest();
    orderItemRequestDTO.setAdditionalAttributes(new HashMap<>());
    orderItemRequestDTO.setCategoryId(null);
    orderItemRequestDTO.setChildOrderItems(new ArrayList<>());
    orderItemRequestDTO.setDiscountsAllowed(true);
    orderItemRequestDTO.setDisplayPrice(new Money());
    orderItemRequestDTO.setExpandable(true);
    orderItemRequestDTO.setFirstExpandable(true);
    orderItemRequestDTO.setHasConfigurationError(true);
    orderItemRequestDTO.setHasOverridenPrice(true);
    orderItemRequestDTO.setIsMultiSelect(true);
    orderItemRequestDTO.setItemAttributes(new HashMap<>());
    orderItemRequestDTO.setLastExpandable(true);
    orderItemRequestDTO.setMaxQuantity(3);
    orderItemRequestDTO.setMinQuantity(1);
    orderItemRequestDTO.setOrderItemId(1L);
    orderItemRequestDTO.setOrderItemIndex(1);
    orderItemRequestDTO.setOverrideRetailPrice(new Money());
    orderItemRequestDTO.setOverrideSalePrice(new Money());
    orderItemRequestDTO.setParentOrderItemId(1L);
    orderItemRequestDTO.setPricingModelType("Not adding item to order because quantity is zero.");
    orderItemRequestDTO.setProduct(new ProductBundleImpl());
    orderItemRequestDTO.setProductChoices(new ArrayList<>());
    orderItemRequestDTO.setProductId(1L);
    orderItemRequestDTO.setQuantity(1);
    orderItemRequestDTO.setSku(new SkuImpl());
    orderItemRequestDTO.setSkuId(1L);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> legacyOrderServiceImpl.addItemToOrder(1L, orderItemRequestDTO, true));
    verify(productDao).readProductById(eq(1L));
    verify(skuDao).readSkuById(eq(1L));
    verify(productBundleImpl, atLeast(1)).getAdditionalSkus();
    verify(productBundleImpl).getDefaultCategory();
    verify(productBundleImpl).getDefaultSku();
    verify(productBundleImpl, atLeast(1)).getProductOptions();
    verify(orderDao).readOrderById(eq(1L));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addDiscreteItemToOrder(Order, DiscreteOrderItemRequest, boolean)} with {@code order}, {@code itemRequest}, {@code priceOrder}.
   * <p>
   * Method under test: {@link LegacyOrderServiceImpl#addDiscreteItemToOrder(Order, DiscreteOrderItemRequest, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "OrderItem LegacyOrderServiceImpl.addDiscreteItemToOrder(Order, DiscreteOrderItemRequest, boolean)"})
  public void testAddDiscreteItemToOrderWithOrderItemRequestPriceOrder() throws PricingException {
    // Arrange
    when(orderItemService.createDiscreteOrderItem(Mockito.<DiscreteOrderItemRequest>any()))
        .thenThrow(new IllegalArgumentException("foo"));
    NullOrderImpl order = new NullOrderImpl();

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> legacyOrderServiceImpl.addDiscreteItemToOrder(order, new DiscreteOrderItemRequest(), true));
    verify(orderItemService).createDiscreteOrderItem(isA(DiscreteOrderItemRequest.class));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addDiscreteItemToOrder(Order, DiscreteOrderItemRequest)} with {@code order}, {@code itemRequest}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LegacyOrderServiceImpl#addDiscreteItemToOrder(Order, DiscreteOrderItemRequest)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"OrderItem LegacyOrderServiceImpl.addDiscreteItemToOrder(Order, DiscreteOrderItemRequest)"})
  public void testAddDiscreteItemToOrderWithOrderItemRequest_thenThrowIllegalArgumentException()
      throws PricingException {
    // Arrange
    when(orderItemService.createDiscreteOrderItem(Mockito.<DiscreteOrderItemRequest>any()))
        .thenThrow(new IllegalArgumentException("foo"));
    NullOrderImpl order = new NullOrderImpl();

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> legacyOrderServiceImpl.addDiscreteItemToOrder(order, new DiscreteOrderItemRequest()));
    verify(orderItemService).createDiscreteOrderItem(isA(DiscreteOrderItemRequest.class));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer)} with {@code orderId}, {@code skuId}, {@code productId}, {@code categoryId}, {@code quantity}.
   * <p>
   * Method under test: {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"OrderItem LegacyOrderServiceImpl.addSkuToOrder(Long, Long, Long, Long, Integer)"})
  public void testAddSkuToOrderWithOrderIdSkuIdProductIdCategoryIdQuantity() throws PricingException {
    // Arrange
    when(orderDao.readOrderById(Mockito.<Long>any())).thenReturn(new NullOrderImpl());
    when(categoryDao.readCategoryById(Mockito.<Long>any())).thenReturn(new CategoryImpl());
    when(orderItemDao.create(Mockito.<OrderItemType>any())).thenThrow(new IllegalArgumentException("foo"));
    when(productDao.readProductById(Mockito.<Long>any())).thenReturn(new ProductBundleImpl());
    when(skuDao.readSkuById(Mockito.<Long>any())).thenReturn(new SkuImpl());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> legacyOrderServiceImpl.addSkuToOrder(1L, 1L, 1L, 1L, 2));
    verify(categoryDao).readCategoryById(eq(1L));
    verify(productDao).readProductById(eq(1L));
    verify(skuDao).readSkuById(eq(1L));
    verify(orderDao).readOrderById(eq(1L));
    verify(orderItemDao).create(isA(OrderItemType.class));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer)} with {@code orderId}, {@code skuId}, {@code productId}, {@code categoryId}, {@code quantity}.
   * <p>
   * Method under test: {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"OrderItem LegacyOrderServiceImpl.addSkuToOrder(Long, Long, Long, Long, Integer)"})
  public void testAddSkuToOrderWithOrderIdSkuIdProductIdCategoryIdQuantity2() throws PricingException {
    // Arrange
    when(orderDao.readOrderById(Mockito.<Long>any())).thenReturn(null);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> legacyOrderServiceImpl.addSkuToOrder(1L, 1L, 1L, 1L, 2));
    verify(orderDao).readOrderById(eq(1L));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer)} with {@code orderId}, {@code skuId}, {@code productId}, {@code categoryId}, {@code quantity}.
   * <p>
   * Method under test: {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"OrderItem LegacyOrderServiceImpl.addSkuToOrder(Long, Long, Long, Long, Integer)"})
  public void testAddSkuToOrderWithOrderIdSkuIdProductIdCategoryIdQuantity3() throws PricingException {
    // Arrange
    when(orderDao.readOrderById(Mockito.<Long>any())).thenReturn(new NullOrderImpl());
    when(productDao.readProductById(Mockito.<Long>any())).thenReturn(null);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> legacyOrderServiceImpl.addSkuToOrder(1L, 1L, 1L, 1L, 2));
    verify(productDao).readProductById(eq(1L));
    verify(orderDao).readOrderById(eq(1L));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer)} with {@code orderId}, {@code skuId}, {@code productId}, {@code categoryId}, {@code quantity}.
   * <p>
   * Method under test: {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"OrderItem LegacyOrderServiceImpl.addSkuToOrder(Long, Long, Long, Long, Integer)"})
  public void testAddSkuToOrderWithOrderIdSkuIdProductIdCategoryIdQuantity4() throws PricingException {
    // Arrange
    when(orderDao.save(Mockito.<Order>any())).thenReturn(new NullOrderImpl());
    when(orderDao.readOrderById(Mockito.<Long>any())).thenReturn(new OrderImpl());
    when(pricingService.executePricing(Mockito.<Order>any())).thenReturn(new NullOrderImpl());
    when(categoryDao.readCategoryById(Mockito.<Long>any())).thenReturn(new CategoryImpl());
    when(orderItemDao.create(Mockito.<OrderItemType>any())).thenReturn(new BundleOrderItemImpl());
    ProductBundleImpl productBundleImpl = mock(ProductBundleImpl.class);
    when(productBundleImpl.getName()).thenReturn("Name");
    when(productBundleImpl.getSkuBundleItems()).thenReturn(new ArrayList<>());
    when(productBundleImpl.getProductOptions()).thenReturn(new ArrayList<>());
    when(productDao.readProductById(Mockito.<Long>any())).thenReturn(productBundleImpl);
    when(skuDao.readSkuById(Mockito.<Long>any())).thenReturn(new SkuImpl());

    // Act
    OrderItem actualAddSkuToOrderResult = legacyOrderServiceImpl.addSkuToOrder(1L, 1L, 1L, 1L, 2);

    // Assert
    verify(categoryDao).readCategoryById(eq(1L));
    verify(productDao).readProductById(eq(1L));
    verify(skuDao).readSkuById(eq(1L));
    verify(productBundleImpl).getSkuBundleItems();
    verify(productBundleImpl).getName();
    verify(productBundleImpl, atLeast(1)).getProductOptions();
    verify(orderDao).readOrderById(eq(1L));
    verify(orderDao).save(isA(Order.class));
    verify(orderItemDao).create(isA(OrderItemType.class));
    verify(pricingService).executePricing(isA(Order.class));
    assertNull(actualAddSkuToOrderResult);
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer)} with {@code orderId}, {@code skuId}, {@code productId}, {@code categoryId}, {@code quantity}.
   * <p>
   * Method under test: {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"OrderItem LegacyOrderServiceImpl.addSkuToOrder(Long, Long, Long, Long, Integer)"})
  public void testAddSkuToOrderWithOrderIdSkuIdProductIdCategoryIdQuantity5() throws PricingException {
    // Arrange
    when(orderDao.readOrderById(Mockito.<Long>any())).thenReturn(new OrderImpl());
    when(pricingService.executePricing(Mockito.<Order>any()))
        .thenThrow(new IllegalArgumentException("ThreadLocalManager.notify.orphans"));
    when(categoryDao.readCategoryById(Mockito.<Long>any())).thenReturn(new CategoryImpl());
    when(orderItemDao.create(Mockito.<OrderItemType>any())).thenReturn(new BundleOrderItemImpl());
    ProductBundleImpl productBundleImpl = mock(ProductBundleImpl.class);
    when(productBundleImpl.getName()).thenReturn("Name");
    when(productBundleImpl.getSkuBundleItems()).thenReturn(new ArrayList<>());
    when(productBundleImpl.getProductOptions()).thenReturn(new ArrayList<>());
    when(productDao.readProductById(Mockito.<Long>any())).thenReturn(productBundleImpl);
    when(skuDao.readSkuById(Mockito.<Long>any())).thenReturn(new SkuImpl());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> legacyOrderServiceImpl.addSkuToOrder(1L, 1L, 1L, 1L, 2));
    verify(categoryDao).readCategoryById(eq(1L));
    verify(productDao).readProductById(eq(1L));
    verify(skuDao).readSkuById(eq(1L));
    verify(productBundleImpl).getSkuBundleItems();
    verify(productBundleImpl).getName();
    verify(productBundleImpl, atLeast(1)).getProductOptions();
    verify(orderDao).readOrderById(eq(1L));
    verify(orderItemDao).create(isA(OrderItemType.class));
    verify(pricingService).executePricing(isA(Order.class));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer)} with {@code orderId}, {@code skuId}, {@code productId}, {@code categoryId}, {@code quantity}.
   * <p>
   * Method under test: {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"OrderItem LegacyOrderServiceImpl.addSkuToOrder(Long, Long, Long, Long, Integer)"})
  public void testAddSkuToOrderWithOrderIdSkuIdProductIdCategoryIdQuantity6() throws PricingException {
    // Arrange
    when(orderDao.save(Mockito.<Order>any())).thenReturn(null);
    when(orderDao.readOrderById(Mockito.<Long>any())).thenReturn(new OrderImpl());
    when(pricingService.executePricing(Mockito.<Order>any())).thenReturn(new NullOrderImpl());
    when(categoryDao.readCategoryById(Mockito.<Long>any())).thenReturn(new CategoryImpl());
    when(orderItemDao.create(Mockito.<OrderItemType>any())).thenReturn(new BundleOrderItemImpl());
    ProductBundleImpl productBundleImpl = mock(ProductBundleImpl.class);
    when(productBundleImpl.getName()).thenReturn("Name");
    when(productBundleImpl.getSkuBundleItems()).thenReturn(new ArrayList<>());
    when(productBundleImpl.getProductOptions()).thenReturn(new ArrayList<>());
    when(productDao.readProductById(Mockito.<Long>any())).thenReturn(productBundleImpl);
    when(skuDao.readSkuById(Mockito.<Long>any())).thenReturn(new SkuImpl());

    // Act
    OrderItem actualAddSkuToOrderResult = legacyOrderServiceImpl.addSkuToOrder(1L, 1L, 1L, 1L, 2);

    // Assert
    verify(categoryDao).readCategoryById(eq(1L));
    verify(productDao).readProductById(eq(1L));
    verify(skuDao).readSkuById(eq(1L));
    verify(productBundleImpl).getSkuBundleItems();
    verify(productBundleImpl).getName();
    verify(productBundleImpl, atLeast(1)).getProductOptions();
    verify(orderDao).readOrderById(eq(1L));
    verify(orderDao).save(isA(Order.class));
    verify(orderItemDao).create(isA(OrderItemType.class));
    verify(pricingService).executePricing(isA(Order.class));
    assertNull(actualAddSkuToOrderResult);
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer)} with {@code orderId}, {@code skuId}, {@code productId}, {@code categoryId}, {@code quantity}.
   * <p>
   * Method under test: {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"OrderItem LegacyOrderServiceImpl.addSkuToOrder(Long, Long, Long, Long, Integer)"})
  public void testAddSkuToOrderWithOrderIdSkuIdProductIdCategoryIdQuantity7() throws PricingException {
    // Arrange
    Order order = mock(Order.class);
    when(order.getOrderItems()).thenThrow(new IllegalArgumentException("foo"));
    when(orderDao.readOrderById(Mockito.<Long>any())).thenReturn(order);
    when(categoryDao.readCategoryById(Mockito.<Long>any())).thenReturn(new CategoryImpl());
    when(orderItemDao.create(Mockito.<OrderItemType>any())).thenReturn(new BundleOrderItemImpl());
    ProductBundleImpl productBundleImpl = mock(ProductBundleImpl.class);
    when(productBundleImpl.getName()).thenReturn("Name");
    when(productBundleImpl.getSkuBundleItems()).thenReturn(new ArrayList<>());
    when(productBundleImpl.getProductOptions()).thenReturn(new ArrayList<>());
    when(productDao.readProductById(Mockito.<Long>any())).thenReturn(productBundleImpl);
    when(skuDao.readSkuById(Mockito.<Long>any())).thenReturn(new SkuImpl());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> legacyOrderServiceImpl.addSkuToOrder(1L, 1L, 1L, 1L, 2));
    verify(categoryDao).readCategoryById(eq(1L));
    verify(productDao).readProductById(eq(1L));
    verify(skuDao).readSkuById(eq(1L));
    verify(productBundleImpl).getSkuBundleItems();
    verify(productBundleImpl).getName();
    verify(productBundleImpl, atLeast(1)).getProductOptions();
    verify(orderDao).readOrderById(eq(1L));
    verify(orderItemDao).create(isA(OrderItemType.class));
    verify(order).getOrderItems();
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer)} with {@code orderId}, {@code skuId}, {@code productId}, {@code categoryId}, {@code quantity}.
   * <p>
   * Method under test: {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"OrderItem LegacyOrderServiceImpl.addSkuToOrder(Long, Long, Long, Long, Integer)"})
  public void testAddSkuToOrderWithOrderIdSkuIdProductIdCategoryIdQuantity8() throws PricingException {
    // Arrange
    when(orderDao.readOrderById(Mockito.<Long>any())).thenReturn(mock(Order.class));
    when(categoryDao.readCategoryById(Mockito.<Long>any())).thenReturn(null);
    ProductBundleImpl productBundleImpl = mock(ProductBundleImpl.class);
    when(productBundleImpl.getDefaultCategory()).thenThrow(new IllegalArgumentException("foo"));
    when(productBundleImpl.getProductOptions()).thenReturn(new ArrayList<>());
    when(productDao.readProductById(Mockito.<Long>any())).thenReturn(productBundleImpl);
    when(skuDao.readSkuById(Mockito.<Long>any())).thenReturn(new SkuImpl());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> legacyOrderServiceImpl.addSkuToOrder(1L, 1L, 1L, 1L, 2));
    verify(categoryDao).readCategoryById(eq(1L));
    verify(productDao).readProductById(eq(1L));
    verify(skuDao).readSkuById(eq(1L));
    verify(productBundleImpl).getDefaultCategory();
    verify(productBundleImpl, atLeast(1)).getProductOptions();
    verify(orderDao).readOrderById(eq(1L));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer)} with {@code orderId}, {@code skuId}, {@code productId}, {@code categoryId}, {@code quantity}.
   * <p>
   * Method under test: {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"OrderItem LegacyOrderServiceImpl.addSkuToOrder(Long, Long, Long, Long, Integer)"})
  public void testAddSkuToOrderWithOrderIdSkuIdProductIdCategoryIdQuantity9() throws PricingException {
    // Arrange
    when(orderDao.readOrderById(Mockito.<Long>any())).thenReturn(mock(Order.class));
    when(categoryDao.readCategoryById(Mockito.<Long>any())).thenReturn(null);
    ProductBundleImpl productBundleImpl = mock(ProductBundleImpl.class);
    when(productBundleImpl.getAdditionalSkus()).thenReturn(new ArrayList<>());
    when(productBundleImpl.getDefaultSku()).thenReturn(new SkuImpl());
    when(productBundleImpl.getDefaultCategory()).thenThrow(new IllegalArgumentException("foo"));
    when(productBundleImpl.getProductOptions()).thenReturn(new ArrayList<>());
    when(productDao.readProductById(Mockito.<Long>any())).thenReturn(productBundleImpl);
    when(skuDao.readSkuById(Mockito.<Long>any())).thenReturn(null);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> legacyOrderServiceImpl.addSkuToOrder(1L, 1L, 1L, 1L, 2));
    verify(categoryDao).readCategoryById(eq(1L));
    verify(productDao).readProductById(eq(1L));
    verify(skuDao).readSkuById(eq(1L));
    verify(productBundleImpl, atLeast(1)).getAdditionalSkus();
    verify(productBundleImpl).getDefaultCategory();
    verify(productBundleImpl).getDefaultSku();
    verify(productBundleImpl, atLeast(1)).getProductOptions();
    verify(orderDao).readOrderById(eq(1L));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer)} with {@code orderId}, {@code skuId}, {@code productId}, {@code categoryId}, {@code quantity}.
   * <p>
   * Method under test: {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"OrderItem LegacyOrderServiceImpl.addSkuToOrder(Long, Long, Long, Long, Integer)"})
  public void testAddSkuToOrderWithOrderIdSkuIdProductIdCategoryIdQuantity10() throws PricingException {
    // Arrange
    when(orderDao.readOrderById(Mockito.<Long>any())).thenReturn(mock(Order.class));

    ArrayList<Sku> skuList = new ArrayList<>();
    skuList.add(new SkuImpl());
    ProductBundleImpl productBundleImpl = mock(ProductBundleImpl.class);
    when(productBundleImpl.getAdditionalSkus()).thenReturn(skuList);
    when(productBundleImpl.getProductOptions()).thenReturn(new ArrayList<>());
    when(productDao.readProductById(Mockito.<Long>any())).thenReturn(productBundleImpl);
    when(skuDao.readSkuById(Mockito.<Long>any())).thenReturn(null);

    // Act and Assert
    assertThrows(RequiredAttributeNotProvidedException.class,
        () -> legacyOrderServiceImpl.addSkuToOrder(1L, 1L, 1L, 1L, 2));
    verify(productDao).readProductById(eq(1L));
    verify(skuDao).readSkuById(eq(1L));
    verify(productBundleImpl, atLeast(1)).getAdditionalSkus();
    verify(productBundleImpl, atLeast(1)).getProductOptions();
    verify(orderDao).readOrderById(eq(1L));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer)} with {@code orderId}, {@code skuId}, {@code productId}, {@code categoryId}, {@code quantity}.
   * <p>
   * Method under test: {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"OrderItem LegacyOrderServiceImpl.addSkuToOrder(Long, Long, Long, Long, Integer)"})
  public void testAddSkuToOrderWithOrderIdSkuIdProductIdCategoryIdQuantity11() throws PricingException {
    // Arrange
    when(orderDao.readOrderById(Mockito.<Long>any())).thenReturn(mock(Order.class));
    ProductBundleImpl productBundleImpl = mock(ProductBundleImpl.class);
    when(productBundleImpl.getAdditionalSkus()).thenReturn(new ArrayList<>());
    when(productBundleImpl.getDefaultSku()).thenReturn(null);
    when(productBundleImpl.getProductOptions()).thenReturn(new ArrayList<>());
    when(productDao.readProductById(Mockito.<Long>any())).thenReturn(productBundleImpl);
    when(skuDao.readSkuById(Mockito.<Long>any())).thenReturn(null);

    // Act
    OrderItem actualAddSkuToOrderResult = legacyOrderServiceImpl.addSkuToOrder(1L, 1L, 1L, 1L, 2);

    // Assert
    verify(productDao).readProductById(eq(1L));
    verify(skuDao).readSkuById(eq(1L));
    verify(productBundleImpl, atLeast(1)).getAdditionalSkus();
    verify(productBundleImpl).getDefaultSku();
    verify(productBundleImpl, atLeast(1)).getProductOptions();
    verify(orderDao).readOrderById(eq(1L));
    assertNull(actualAddSkuToOrderResult);
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer)} with {@code orderId}, {@code skuId}, {@code productId}, {@code categoryId}, {@code quantity}.
   * <p>
   * Method under test: {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"OrderItem LegacyOrderServiceImpl.addSkuToOrder(Long, Long, Long, Long, Integer)"})
  public void testAddSkuToOrderWithOrderIdSkuIdProductIdCategoryIdQuantity12() throws PricingException {
    // Arrange
    when(orderDao.readOrderById(Mockito.<Long>any())).thenReturn(mock(Order.class));
    when(categoryDao.readCategoryById(Mockito.<Long>any())).thenReturn(null);
    ProductBundleImpl productBundleImpl = mock(ProductBundleImpl.class);
    when(productBundleImpl.getAdditionalSkus()).thenReturn(new ArrayList<>());
    when(productBundleImpl.getDefaultSku()).thenReturn(new SkuImpl());
    when(productBundleImpl.getDefaultCategory()).thenThrow(new IllegalArgumentException("foo"));
    when(productBundleImpl.getProductOptions()).thenReturn(new ArrayList<>());
    when(productDao.readProductById(Mockito.<Long>any())).thenReturn(productBundleImpl);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> legacyOrderServiceImpl.addSkuToOrder(1L, null, 1L, 1L, 2));
    verify(categoryDao).readCategoryById(eq(1L));
    verify(productDao).readProductById(eq(1L));
    verify(productBundleImpl, atLeast(1)).getAdditionalSkus();
    verify(productBundleImpl).getDefaultCategory();
    verify(productBundleImpl).getDefaultSku();
    verify(productBundleImpl, atLeast(1)).getProductOptions();
    verify(orderDao).readOrderById(eq(1L));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer)} with {@code orderId}, {@code skuId}, {@code productId}, {@code categoryId}, {@code quantity}.
   * <p>
   * Method under test: {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"OrderItem LegacyOrderServiceImpl.addSkuToOrder(Long, Long, Long, Long, Integer)"})
  public void testAddSkuToOrderWithOrderIdSkuIdProductIdCategoryIdQuantity13() throws PricingException {
    // Arrange
    when(orderDao.readOrderById(Mockito.<Long>any())).thenReturn(mock(Order.class));
    when(skuDao.readSkuById(Mockito.<Long>any())).thenReturn(null);

    // Act
    OrderItem actualAddSkuToOrderResult = legacyOrderServiceImpl.addSkuToOrder(1L, 1L, null, 1L, 2);

    // Assert
    verify(skuDao).readSkuById(eq(1L));
    verify(orderDao).readOrderById(eq(1L));
    assertNull(actualAddSkuToOrderResult);
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer)} with {@code orderId}, {@code skuId}, {@code productId}, {@code categoryId}, {@code quantity}.
   * <p>
   * Method under test: {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"OrderItem LegacyOrderServiceImpl.addSkuToOrder(Long, Long, Long, Long, Integer)"})
  public void testAddSkuToOrderWithOrderIdSkuIdProductIdCategoryIdQuantity14() throws PricingException {
    // Arrange
    when(orderDao.readOrderById(Mockito.<Long>any())).thenReturn(mock(Order.class));
    ProductBundleImpl productBundleImpl = mock(ProductBundleImpl.class);
    when(productBundleImpl.getAdditionalSkus()).thenReturn(new ArrayList<>());
    when(productBundleImpl.getDefaultSku()).thenReturn(new SkuImpl());
    when(productBundleImpl.getDefaultCategory()).thenThrow(new IllegalArgumentException("foo"));
    when(productBundleImpl.getProductOptions()).thenReturn(new ArrayList<>());
    when(productDao.readProductById(Mockito.<Long>any())).thenReturn(productBundleImpl);
    when(skuDao.readSkuById(Mockito.<Long>any())).thenReturn(null);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> legacyOrderServiceImpl.addSkuToOrder(1L, 1L, 1L, null, 2));
    verify(productDao).readProductById(eq(1L));
    verify(skuDao).readSkuById(eq(1L));
    verify(productBundleImpl, atLeast(1)).getAdditionalSkus();
    verify(productBundleImpl).getDefaultCategory();
    verify(productBundleImpl).getDefaultSku();
    verify(productBundleImpl, atLeast(1)).getProductOptions();
    verify(orderDao).readOrderById(eq(1L));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer, Map)} with {@code orderId}, {@code skuId}, {@code productId}, {@code categoryId}, {@code quantity}, {@code itemAttributes}.
   * <p>
   * Method under test: {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"OrderItem LegacyOrderServiceImpl.addSkuToOrder(Long, Long, Long, Long, Integer, Map)"})
  public void testAddSkuToOrderWithOrderIdSkuIdProductIdCategoryIdQuantityItemAttributes() throws PricingException {
    // Arrange, Act and Assert
    assertNull(legacyOrderServiceImpl.addSkuToOrder(null, null, null, 1L, null, new HashMap<>()));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer, Map)} with {@code orderId}, {@code skuId}, {@code productId}, {@code categoryId}, {@code quantity}, {@code itemAttributes}.
   * <p>
   * Method under test: {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"OrderItem LegacyOrderServiceImpl.addSkuToOrder(Long, Long, Long, Long, Integer, Map)"})
  public void testAddSkuToOrderWithOrderIdSkuIdProductIdCategoryIdQuantityItemAttributes2() throws PricingException {
    // Arrange, Act and Assert
    assertNull(legacyOrderServiceImpl.addSkuToOrder(1L, null, null, 1L, null, new HashMap<>()));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer, Map)} with {@code orderId}, {@code skuId}, {@code productId}, {@code categoryId}, {@code quantity}, {@code itemAttributes}.
   * <p>
   * Method under test: {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"OrderItem LegacyOrderServiceImpl.addSkuToOrder(Long, Long, Long, Long, Integer, Map)"})
  public void testAddSkuToOrderWithOrderIdSkuIdProductIdCategoryIdQuantityItemAttributes3() throws PricingException {
    // Arrange, Act and Assert
    assertNull(legacyOrderServiceImpl.addSkuToOrder(1L, null, 1L, 1L, null, new HashMap<>()));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer, Map)} with {@code orderId}, {@code skuId}, {@code productId}, {@code categoryId}, {@code quantity}, {@code itemAttributes}.
   * <p>
   * Method under test: {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"OrderItem LegacyOrderServiceImpl.addSkuToOrder(Long, Long, Long, Long, Integer, Map)"})
  public void testAddSkuToOrderWithOrderIdSkuIdProductIdCategoryIdQuantityItemAttributes4() throws PricingException {
    // Arrange, Act and Assert
    assertNull(legacyOrderServiceImpl.addSkuToOrder(1L, 1L, null, 1L, null, new HashMap<>()));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer, Map)} with {@code orderId}, {@code skuId}, {@code productId}, {@code categoryId}, {@code quantity}, {@code itemAttributes}.
   * <p>
   * Method under test: {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"OrderItem LegacyOrderServiceImpl.addSkuToOrder(Long, Long, Long, Long, Integer, Map)"})
  public void testAddSkuToOrderWithOrderIdSkuIdProductIdCategoryIdQuantityItemAttributes5() throws PricingException {
    // Arrange
    when(orderDao.readOrderById(Mockito.<Long>any())).thenReturn(new NullOrderImpl());
    when(categoryDao.readCategoryById(Mockito.<Long>any())).thenReturn(new CategoryImpl());
    when(orderItemDao.create(Mockito.<OrderItemType>any())).thenThrow(new IllegalArgumentException("foo"));
    when(productDao.readProductById(Mockito.<Long>any())).thenReturn(new ProductBundleImpl());
    when(skuDao.readSkuById(Mockito.<Long>any())).thenReturn(new SkuImpl());

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> legacyOrderServiceImpl.addSkuToOrder(1L, 1L, 1L, 1L, 2, new HashMap<>()));
    verify(categoryDao).readCategoryById(eq(1L));
    verify(productDao).readProductById(eq(1L));
    verify(skuDao).readSkuById(eq(1L));
    verify(orderDao).readOrderById(eq(1L));
    verify(orderItemDao).create(isA(OrderItemType.class));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer, Map)} with {@code orderId}, {@code skuId}, {@code productId}, {@code categoryId}, {@code quantity}, {@code itemAttributes}.
   * <p>
   * Method under test: {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"OrderItem LegacyOrderServiceImpl.addSkuToOrder(Long, Long, Long, Long, Integer, Map)"})
  public void testAddSkuToOrderWithOrderIdSkuIdProductIdCategoryIdQuantityItemAttributes6() throws PricingException {
    // Arrange
    when(orderDao.readOrderById(Mockito.<Long>any())).thenReturn(null);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> legacyOrderServiceImpl.addSkuToOrder(1L, 1L, 1L, 1L, 2, new HashMap<>()));
    verify(orderDao).readOrderById(eq(1L));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer, Map)} with {@code orderId}, {@code skuId}, {@code productId}, {@code categoryId}, {@code quantity}, {@code itemAttributes}.
   * <p>
   * Method under test: {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"OrderItem LegacyOrderServiceImpl.addSkuToOrder(Long, Long, Long, Long, Integer, Map)"})
  public void testAddSkuToOrderWithOrderIdSkuIdProductIdCategoryIdQuantityItemAttributes7() throws PricingException {
    // Arrange
    when(orderDao.readOrderById(Mockito.<Long>any())).thenReturn(new NullOrderImpl());
    when(productDao.readProductById(Mockito.<Long>any())).thenReturn(null);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> legacyOrderServiceImpl.addSkuToOrder(1L, 1L, 1L, 1L, 2, new HashMap<>()));
    verify(productDao).readProductById(eq(1L));
    verify(orderDao).readOrderById(eq(1L));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer, Map)} with {@code orderId}, {@code skuId}, {@code productId}, {@code categoryId}, {@code quantity}, {@code itemAttributes}.
   * <p>
   * Method under test: {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"OrderItem LegacyOrderServiceImpl.addSkuToOrder(Long, Long, Long, Long, Integer, Map)"})
  public void testAddSkuToOrderWithOrderIdSkuIdProductIdCategoryIdQuantityItemAttributes8() throws PricingException {
    // Arrange
    when(orderDao.save(Mockito.<Order>any())).thenReturn(new NullOrderImpl());
    when(orderDao.readOrderById(Mockito.<Long>any())).thenReturn(new OrderImpl());
    when(pricingService.executePricing(Mockito.<Order>any())).thenReturn(new NullOrderImpl());
    when(categoryDao.readCategoryById(Mockito.<Long>any())).thenReturn(new CategoryImpl());
    when(orderItemDao.create(Mockito.<OrderItemType>any())).thenReturn(new BundleOrderItemImpl());
    ProductBundleImpl productBundleImpl = mock(ProductBundleImpl.class);
    when(productBundleImpl.getName()).thenReturn("Name");
    when(productBundleImpl.getSkuBundleItems()).thenReturn(new ArrayList<>());
    when(productBundleImpl.getProductOptions()).thenReturn(new ArrayList<>());
    when(productDao.readProductById(Mockito.<Long>any())).thenReturn(productBundleImpl);
    when(skuDao.readSkuById(Mockito.<Long>any())).thenReturn(new SkuImpl());

    // Act
    OrderItem actualAddSkuToOrderResult = legacyOrderServiceImpl.addSkuToOrder(1L, 1L, 1L, 1L, 2, new HashMap<>());

    // Assert
    verify(categoryDao).readCategoryById(eq(1L));
    verify(productDao).readProductById(eq(1L));
    verify(skuDao).readSkuById(eq(1L));
    verify(productBundleImpl).getSkuBundleItems();
    verify(productBundleImpl).getName();
    verify(productBundleImpl, atLeast(1)).getProductOptions();
    verify(orderDao).readOrderById(eq(1L));
    verify(orderDao).save(isA(Order.class));
    verify(orderItemDao).create(isA(OrderItemType.class));
    verify(pricingService).executePricing(isA(Order.class));
    assertNull(actualAddSkuToOrderResult);
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer, Map)} with {@code orderId}, {@code skuId}, {@code productId}, {@code categoryId}, {@code quantity}, {@code itemAttributes}.
   * <p>
   * Method under test: {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"OrderItem LegacyOrderServiceImpl.addSkuToOrder(Long, Long, Long, Long, Integer, Map)"})
  public void testAddSkuToOrderWithOrderIdSkuIdProductIdCategoryIdQuantityItemAttributes9() throws PricingException {
    // Arrange
    when(orderDao.readOrderById(Mockito.<Long>any())).thenReturn(new OrderImpl());
    when(pricingService.executePricing(Mockito.<Order>any()))
        .thenThrow(new IllegalArgumentException("ThreadLocalManager.notify.orphans"));
    when(categoryDao.readCategoryById(Mockito.<Long>any())).thenReturn(new CategoryImpl());
    when(orderItemDao.create(Mockito.<OrderItemType>any())).thenReturn(new BundleOrderItemImpl());
    ProductBundleImpl productBundleImpl = mock(ProductBundleImpl.class);
    when(productBundleImpl.getName()).thenReturn("Name");
    when(productBundleImpl.getSkuBundleItems()).thenReturn(new ArrayList<>());
    when(productBundleImpl.getProductOptions()).thenReturn(new ArrayList<>());
    when(productDao.readProductById(Mockito.<Long>any())).thenReturn(productBundleImpl);
    when(skuDao.readSkuById(Mockito.<Long>any())).thenReturn(new SkuImpl());

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> legacyOrderServiceImpl.addSkuToOrder(1L, 1L, 1L, 1L, 2, new HashMap<>()));
    verify(categoryDao).readCategoryById(eq(1L));
    verify(productDao).readProductById(eq(1L));
    verify(skuDao).readSkuById(eq(1L));
    verify(productBundleImpl).getSkuBundleItems();
    verify(productBundleImpl).getName();
    verify(productBundleImpl, atLeast(1)).getProductOptions();
    verify(orderDao).readOrderById(eq(1L));
    verify(orderItemDao).create(isA(OrderItemType.class));
    verify(pricingService).executePricing(isA(Order.class));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer, Map)} with {@code orderId}, {@code skuId}, {@code productId}, {@code categoryId}, {@code quantity}, {@code itemAttributes}.
   * <p>
   * Method under test: {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"OrderItem LegacyOrderServiceImpl.addSkuToOrder(Long, Long, Long, Long, Integer, Map)"})
  public void testAddSkuToOrderWithOrderIdSkuIdProductIdCategoryIdQuantityItemAttributes10() throws PricingException {
    // Arrange
    when(orderDao.save(Mockito.<Order>any())).thenReturn(null);
    when(orderDao.readOrderById(Mockito.<Long>any())).thenReturn(new OrderImpl());
    when(pricingService.executePricing(Mockito.<Order>any())).thenReturn(new NullOrderImpl());
    when(categoryDao.readCategoryById(Mockito.<Long>any())).thenReturn(new CategoryImpl());
    when(orderItemDao.create(Mockito.<OrderItemType>any())).thenReturn(new BundleOrderItemImpl());
    ProductBundleImpl productBundleImpl = mock(ProductBundleImpl.class);
    when(productBundleImpl.getName()).thenReturn("Name");
    when(productBundleImpl.getSkuBundleItems()).thenReturn(new ArrayList<>());
    when(productBundleImpl.getProductOptions()).thenReturn(new ArrayList<>());
    when(productDao.readProductById(Mockito.<Long>any())).thenReturn(productBundleImpl);
    when(skuDao.readSkuById(Mockito.<Long>any())).thenReturn(new SkuImpl());

    // Act
    OrderItem actualAddSkuToOrderResult = legacyOrderServiceImpl.addSkuToOrder(1L, 1L, 1L, 1L, 2, new HashMap<>());

    // Assert
    verify(categoryDao).readCategoryById(eq(1L));
    verify(productDao).readProductById(eq(1L));
    verify(skuDao).readSkuById(eq(1L));
    verify(productBundleImpl).getSkuBundleItems();
    verify(productBundleImpl).getName();
    verify(productBundleImpl, atLeast(1)).getProductOptions();
    verify(orderDao).readOrderById(eq(1L));
    verify(orderDao).save(isA(Order.class));
    verify(orderItemDao).create(isA(OrderItemType.class));
    verify(pricingService).executePricing(isA(Order.class));
    assertNull(actualAddSkuToOrderResult);
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer, Map)} with {@code orderId}, {@code skuId}, {@code productId}, {@code categoryId}, {@code quantity}, {@code itemAttributes}.
   * <p>
   * Method under test: {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"OrderItem LegacyOrderServiceImpl.addSkuToOrder(Long, Long, Long, Long, Integer, Map)"})
  public void testAddSkuToOrderWithOrderIdSkuIdProductIdCategoryIdQuantityItemAttributes11() throws PricingException {
    // Arrange
    Order order = mock(Order.class);
    when(order.getOrderItems()).thenThrow(new IllegalArgumentException("foo"));
    when(orderDao.readOrderById(Mockito.<Long>any())).thenReturn(order);
    when(categoryDao.readCategoryById(Mockito.<Long>any())).thenReturn(new CategoryImpl());
    when(orderItemDao.create(Mockito.<OrderItemType>any())).thenReturn(new BundleOrderItemImpl());
    ProductBundleImpl productBundleImpl = mock(ProductBundleImpl.class);
    when(productBundleImpl.getName()).thenReturn("Name");
    when(productBundleImpl.getSkuBundleItems()).thenReturn(new ArrayList<>());
    when(productBundleImpl.getProductOptions()).thenReturn(new ArrayList<>());
    when(productDao.readProductById(Mockito.<Long>any())).thenReturn(productBundleImpl);
    when(skuDao.readSkuById(Mockito.<Long>any())).thenReturn(new SkuImpl());

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> legacyOrderServiceImpl.addSkuToOrder(1L, 1L, 1L, 1L, 2, new HashMap<>()));
    verify(categoryDao).readCategoryById(eq(1L));
    verify(productDao).readProductById(eq(1L));
    verify(skuDao).readSkuById(eq(1L));
    verify(productBundleImpl).getSkuBundleItems();
    verify(productBundleImpl).getName();
    verify(productBundleImpl, atLeast(1)).getProductOptions();
    verify(orderDao).readOrderById(eq(1L));
    verify(orderItemDao).create(isA(OrderItemType.class));
    verify(order).getOrderItems();
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer, Map)} with {@code orderId}, {@code skuId}, {@code productId}, {@code categoryId}, {@code quantity}, {@code itemAttributes}.
   * <p>
   * Method under test: {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"OrderItem LegacyOrderServiceImpl.addSkuToOrder(Long, Long, Long, Long, Integer, Map)"})
  public void testAddSkuToOrderWithOrderIdSkuIdProductIdCategoryIdQuantityItemAttributes12() throws PricingException {
    // Arrange
    when(orderDao.readOrderById(Mockito.<Long>any())).thenReturn(mock(Order.class));
    when(categoryDao.readCategoryById(Mockito.<Long>any())).thenReturn(null);
    ProductBundleImpl productBundleImpl = mock(ProductBundleImpl.class);
    when(productBundleImpl.getDefaultCategory()).thenThrow(new IllegalArgumentException("foo"));
    when(productBundleImpl.getProductOptions()).thenReturn(new ArrayList<>());
    when(productDao.readProductById(Mockito.<Long>any())).thenReturn(productBundleImpl);
    when(skuDao.readSkuById(Mockito.<Long>any())).thenReturn(new SkuImpl());

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> legacyOrderServiceImpl.addSkuToOrder(1L, 1L, 1L, 1L, 2, new HashMap<>()));
    verify(categoryDao).readCategoryById(eq(1L));
    verify(productDao).readProductById(eq(1L));
    verify(skuDao).readSkuById(eq(1L));
    verify(productBundleImpl).getDefaultCategory();
    verify(productBundleImpl, atLeast(1)).getProductOptions();
    verify(orderDao).readOrderById(eq(1L));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer, Map)} with {@code orderId}, {@code skuId}, {@code productId}, {@code categoryId}, {@code quantity}, {@code itemAttributes}.
   * <p>
   * Method under test: {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"OrderItem LegacyOrderServiceImpl.addSkuToOrder(Long, Long, Long, Long, Integer, Map)"})
  public void testAddSkuToOrderWithOrderIdSkuIdProductIdCategoryIdQuantityItemAttributes13() throws PricingException {
    // Arrange
    when(orderDao.readOrderById(Mockito.<Long>any())).thenReturn(mock(Order.class));
    when(categoryDao.readCategoryById(Mockito.<Long>any())).thenReturn(null);
    ProductBundleImpl productBundleImpl = mock(ProductBundleImpl.class);
    when(productBundleImpl.getAdditionalSkus()).thenReturn(new ArrayList<>());
    when(productBundleImpl.getDefaultSku()).thenReturn(new SkuImpl());
    when(productBundleImpl.getDefaultCategory()).thenThrow(new IllegalArgumentException("foo"));
    when(productBundleImpl.getProductOptions()).thenReturn(new ArrayList<>());
    when(productDao.readProductById(Mockito.<Long>any())).thenReturn(productBundleImpl);
    when(skuDao.readSkuById(Mockito.<Long>any())).thenReturn(null);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> legacyOrderServiceImpl.addSkuToOrder(1L, 1L, 1L, 1L, 2, new HashMap<>()));
    verify(categoryDao).readCategoryById(eq(1L));
    verify(productDao).readProductById(eq(1L));
    verify(skuDao).readSkuById(eq(1L));
    verify(productBundleImpl, atLeast(1)).getAdditionalSkus();
    verify(productBundleImpl).getDefaultCategory();
    verify(productBundleImpl).getDefaultSku();
    verify(productBundleImpl, atLeast(1)).getProductOptions();
    verify(orderDao).readOrderById(eq(1L));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer, Map)} with {@code orderId}, {@code skuId}, {@code productId}, {@code categoryId}, {@code quantity}, {@code itemAttributes}.
   * <p>
   * Method under test: {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"OrderItem LegacyOrderServiceImpl.addSkuToOrder(Long, Long, Long, Long, Integer, Map)"})
  public void testAddSkuToOrderWithOrderIdSkuIdProductIdCategoryIdQuantityItemAttributes14() throws PricingException {
    // Arrange
    when(orderDao.readOrderById(Mockito.<Long>any())).thenReturn(mock(Order.class));

    ArrayList<Sku> skuList = new ArrayList<>();
    skuList.add(new SkuImpl());
    ProductBundleImpl productBundleImpl = mock(ProductBundleImpl.class);
    when(productBundleImpl.getAdditionalSkus()).thenReturn(skuList);
    when(productBundleImpl.getProductOptions()).thenReturn(new ArrayList<>());
    when(productDao.readProductById(Mockito.<Long>any())).thenReturn(productBundleImpl);
    when(skuDao.readSkuById(Mockito.<Long>any())).thenReturn(null);

    // Act and Assert
    assertThrows(RequiredAttributeNotProvidedException.class,
        () -> legacyOrderServiceImpl.addSkuToOrder(1L, 1L, 1L, 1L, 2, new HashMap<>()));
    verify(productDao).readProductById(eq(1L));
    verify(skuDao).readSkuById(eq(1L));
    verify(productBundleImpl, atLeast(1)).getAdditionalSkus();
    verify(productBundleImpl, atLeast(1)).getProductOptions();
    verify(orderDao).readOrderById(eq(1L));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer, Map)} with {@code orderId}, {@code skuId}, {@code productId}, {@code categoryId}, {@code quantity}, {@code itemAttributes}.
   * <p>
   * Method under test: {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"OrderItem LegacyOrderServiceImpl.addSkuToOrder(Long, Long, Long, Long, Integer, Map)"})
  public void testAddSkuToOrderWithOrderIdSkuIdProductIdCategoryIdQuantityItemAttributes15() throws PricingException {
    // Arrange
    when(orderDao.readOrderById(Mockito.<Long>any())).thenReturn(mock(Order.class));
    ProductBundleImpl productBundleImpl = mock(ProductBundleImpl.class);
    when(productBundleImpl.getAdditionalSkus()).thenReturn(new ArrayList<>());
    when(productBundleImpl.getDefaultSku()).thenReturn(null);
    when(productBundleImpl.getProductOptions()).thenReturn(new ArrayList<>());
    when(productDao.readProductById(Mockito.<Long>any())).thenReturn(productBundleImpl);
    when(skuDao.readSkuById(Mockito.<Long>any())).thenReturn(null);

    // Act
    OrderItem actualAddSkuToOrderResult = legacyOrderServiceImpl.addSkuToOrder(1L, 1L, 1L, 1L, 2, new HashMap<>());

    // Assert
    verify(productDao).readProductById(eq(1L));
    verify(skuDao).readSkuById(eq(1L));
    verify(productBundleImpl, atLeast(1)).getAdditionalSkus();
    verify(productBundleImpl).getDefaultSku();
    verify(productBundleImpl, atLeast(1)).getProductOptions();
    verify(orderDao).readOrderById(eq(1L));
    assertNull(actualAddSkuToOrderResult);
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer, Map)} with {@code orderId}, {@code skuId}, {@code productId}, {@code categoryId}, {@code quantity}, {@code itemAttributes}.
   * <p>
   * Method under test: {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"OrderItem LegacyOrderServiceImpl.addSkuToOrder(Long, Long, Long, Long, Integer, Map)"})
  public void testAddSkuToOrderWithOrderIdSkuIdProductIdCategoryIdQuantityItemAttributes16() throws PricingException {
    // Arrange
    when(orderDao.readOrderById(Mockito.<Long>any())).thenReturn(mock(Order.class));
    when(categoryDao.readCategoryById(Mockito.<Long>any())).thenReturn(null);
    ProductBundleImpl productBundleImpl = mock(ProductBundleImpl.class);
    when(productBundleImpl.getAdditionalSkus()).thenReturn(new ArrayList<>());
    when(productBundleImpl.getDefaultSku()).thenReturn(new SkuImpl());
    when(productBundleImpl.getDefaultCategory()).thenThrow(new IllegalArgumentException("foo"));
    when(productBundleImpl.getProductOptions()).thenReturn(new ArrayList<>());
    when(productDao.readProductById(Mockito.<Long>any())).thenReturn(productBundleImpl);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> legacyOrderServiceImpl.addSkuToOrder(1L, null, 1L, 1L, 2, new HashMap<>()));
    verify(categoryDao).readCategoryById(eq(1L));
    verify(productDao).readProductById(eq(1L));
    verify(productBundleImpl, atLeast(1)).getAdditionalSkus();
    verify(productBundleImpl).getDefaultCategory();
    verify(productBundleImpl).getDefaultSku();
    verify(productBundleImpl, atLeast(1)).getProductOptions();
    verify(orderDao).readOrderById(eq(1L));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer, Map)} with {@code orderId}, {@code skuId}, {@code productId}, {@code categoryId}, {@code quantity}, {@code itemAttributes}.
   * <p>
   * Method under test: {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"OrderItem LegacyOrderServiceImpl.addSkuToOrder(Long, Long, Long, Long, Integer, Map)"})
  public void testAddSkuToOrderWithOrderIdSkuIdProductIdCategoryIdQuantityItemAttributes17() throws PricingException {
    // Arrange
    when(orderDao.readOrderById(Mockito.<Long>any())).thenReturn(mock(Order.class));
    when(skuDao.readSkuById(Mockito.<Long>any())).thenReturn(null);

    // Act
    OrderItem actualAddSkuToOrderResult = legacyOrderServiceImpl.addSkuToOrder(1L, 1L, null, 1L, 2, new HashMap<>());

    // Assert
    verify(skuDao).readSkuById(eq(1L));
    verify(orderDao).readOrderById(eq(1L));
    assertNull(actualAddSkuToOrderResult);
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer, Map)} with {@code orderId}, {@code skuId}, {@code productId}, {@code categoryId}, {@code quantity}, {@code itemAttributes}.
   * <p>
   * Method under test: {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"OrderItem LegacyOrderServiceImpl.addSkuToOrder(Long, Long, Long, Long, Integer, Map)"})
  public void testAddSkuToOrderWithOrderIdSkuIdProductIdCategoryIdQuantityItemAttributes18() throws PricingException {
    // Arrange
    when(orderDao.readOrderById(Mockito.<Long>any())).thenReturn(mock(Order.class));
    ProductBundleImpl productBundleImpl = mock(ProductBundleImpl.class);
    when(productBundleImpl.getAdditionalSkus()).thenReturn(new ArrayList<>());
    when(productBundleImpl.getDefaultSku()).thenReturn(new SkuImpl());
    when(productBundleImpl.getDefaultCategory()).thenThrow(new IllegalArgumentException("foo"));
    when(productBundleImpl.getProductOptions()).thenReturn(new ArrayList<>());
    when(productDao.readProductById(Mockito.<Long>any())).thenReturn(productBundleImpl);
    when(skuDao.readSkuById(Mockito.<Long>any())).thenReturn(null);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> legacyOrderServiceImpl.addSkuToOrder(1L, 1L, 1L, null, 2, new HashMap<>()));
    verify(productDao).readProductById(eq(1L));
    verify(skuDao).readSkuById(eq(1L));
    verify(productBundleImpl, atLeast(1)).getAdditionalSkus();
    verify(productBundleImpl).getDefaultCategory();
    verify(productBundleImpl).getDefaultSku();
    verify(productBundleImpl, atLeast(1)).getProductOptions();
    verify(orderDao).readOrderById(eq(1L));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer, boolean)} with {@code orderId}, {@code skuId}, {@code productId}, {@code categoryId}, {@code quantity}, {@code priceOrder}.
   * <p>
   * Method under test: {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"OrderItem LegacyOrderServiceImpl.addSkuToOrder(Long, Long, Long, Long, Integer, boolean)"})
  public void testAddSkuToOrderWithOrderIdSkuIdProductIdCategoryIdQuantityPriceOrder() throws PricingException {
    // Arrange, Act and Assert
    assertNull(legacyOrderServiceImpl.addSkuToOrder(null, null, null, 1L, null, true));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer, boolean)} with {@code orderId}, {@code skuId}, {@code productId}, {@code categoryId}, {@code quantity}, {@code priceOrder}.
   * <p>
   * Method under test: {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"OrderItem LegacyOrderServiceImpl.addSkuToOrder(Long, Long, Long, Long, Integer, boolean)"})
  public void testAddSkuToOrderWithOrderIdSkuIdProductIdCategoryIdQuantityPriceOrder2() throws PricingException {
    // Arrange, Act and Assert
    assertNull(legacyOrderServiceImpl.addSkuToOrder(1L, null, null, 1L, null, true));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer, boolean)} with {@code orderId}, {@code skuId}, {@code productId}, {@code categoryId}, {@code quantity}, {@code priceOrder}.
   * <p>
   * Method under test: {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"OrderItem LegacyOrderServiceImpl.addSkuToOrder(Long, Long, Long, Long, Integer, boolean)"})
  public void testAddSkuToOrderWithOrderIdSkuIdProductIdCategoryIdQuantityPriceOrder3() throws PricingException {
    // Arrange, Act and Assert
    assertNull(legacyOrderServiceImpl.addSkuToOrder(1L, null, 1L, 1L, null, true));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer, boolean)} with {@code orderId}, {@code skuId}, {@code productId}, {@code categoryId}, {@code quantity}, {@code priceOrder}.
   * <p>
   * Method under test: {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"OrderItem LegacyOrderServiceImpl.addSkuToOrder(Long, Long, Long, Long, Integer, boolean)"})
  public void testAddSkuToOrderWithOrderIdSkuIdProductIdCategoryIdQuantityPriceOrder4() throws PricingException {
    // Arrange, Act and Assert
    assertNull(legacyOrderServiceImpl.addSkuToOrder(1L, 1L, null, 1L, null, true));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer, boolean)} with {@code orderId}, {@code skuId}, {@code productId}, {@code categoryId}, {@code quantity}, {@code priceOrder}.
   * <p>
   * Method under test: {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"OrderItem LegacyOrderServiceImpl.addSkuToOrder(Long, Long, Long, Long, Integer, boolean)"})
  public void testAddSkuToOrderWithOrderIdSkuIdProductIdCategoryIdQuantityPriceOrder5() throws PricingException {
    // Arrange
    when(orderDao.readOrderById(Mockito.<Long>any())).thenReturn(new NullOrderImpl());
    when(categoryDao.readCategoryById(Mockito.<Long>any())).thenReturn(new CategoryImpl());
    when(orderItemDao.create(Mockito.<OrderItemType>any())).thenThrow(new IllegalArgumentException("foo"));
    when(productDao.readProductById(Mockito.<Long>any())).thenReturn(new ProductBundleImpl());
    when(skuDao.readSkuById(Mockito.<Long>any())).thenReturn(new SkuImpl());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> legacyOrderServiceImpl.addSkuToOrder(1L, 1L, 1L, 1L, 2, true));
    verify(categoryDao).readCategoryById(eq(1L));
    verify(productDao).readProductById(eq(1L));
    verify(skuDao).readSkuById(eq(1L));
    verify(orderDao).readOrderById(eq(1L));
    verify(orderItemDao).create(isA(OrderItemType.class));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer, boolean)} with {@code orderId}, {@code skuId}, {@code productId}, {@code categoryId}, {@code quantity}, {@code priceOrder}.
   * <p>
   * Method under test: {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"OrderItem LegacyOrderServiceImpl.addSkuToOrder(Long, Long, Long, Long, Integer, boolean)"})
  public void testAddSkuToOrderWithOrderIdSkuIdProductIdCategoryIdQuantityPriceOrder6() throws PricingException {
    // Arrange
    when(orderDao.readOrderById(Mockito.<Long>any())).thenReturn(null);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> legacyOrderServiceImpl.addSkuToOrder(1L, 1L, 1L, 1L, 2, true));
    verify(orderDao).readOrderById(eq(1L));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer, boolean)} with {@code orderId}, {@code skuId}, {@code productId}, {@code categoryId}, {@code quantity}, {@code priceOrder}.
   * <p>
   * Method under test: {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"OrderItem LegacyOrderServiceImpl.addSkuToOrder(Long, Long, Long, Long, Integer, boolean)"})
  public void testAddSkuToOrderWithOrderIdSkuIdProductIdCategoryIdQuantityPriceOrder7() throws PricingException {
    // Arrange
    when(orderDao.readOrderById(Mockito.<Long>any())).thenReturn(new NullOrderImpl());
    when(productDao.readProductById(Mockito.<Long>any())).thenReturn(null);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> legacyOrderServiceImpl.addSkuToOrder(1L, 1L, 1L, 1L, 2, true));
    verify(productDao).readProductById(eq(1L));
    verify(orderDao).readOrderById(eq(1L));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer, boolean)} with {@code orderId}, {@code skuId}, {@code productId}, {@code categoryId}, {@code quantity}, {@code priceOrder}.
   * <p>
   * Method under test: {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"OrderItem LegacyOrderServiceImpl.addSkuToOrder(Long, Long, Long, Long, Integer, boolean)"})
  public void testAddSkuToOrderWithOrderIdSkuIdProductIdCategoryIdQuantityPriceOrder8() throws PricingException {
    // Arrange
    when(orderDao.save(Mockito.<Order>any())).thenReturn(new NullOrderImpl());
    when(orderDao.readOrderById(Mockito.<Long>any())).thenReturn(new OrderImpl());
    when(pricingService.executePricing(Mockito.<Order>any())).thenReturn(new NullOrderImpl());
    when(categoryDao.readCategoryById(Mockito.<Long>any())).thenReturn(new CategoryImpl());
    when(orderItemDao.create(Mockito.<OrderItemType>any())).thenReturn(new BundleOrderItemImpl());
    ProductBundleImpl productBundleImpl = mock(ProductBundleImpl.class);
    when(productBundleImpl.getName()).thenReturn("Name");
    when(productBundleImpl.getSkuBundleItems()).thenReturn(new ArrayList<>());
    when(productBundleImpl.getProductOptions()).thenReturn(new ArrayList<>());
    when(productDao.readProductById(Mockito.<Long>any())).thenReturn(productBundleImpl);
    when(skuDao.readSkuById(Mockito.<Long>any())).thenReturn(new SkuImpl());

    // Act
    OrderItem actualAddSkuToOrderResult = legacyOrderServiceImpl.addSkuToOrder(1L, 1L, 1L, 1L, 2, true);

    // Assert
    verify(categoryDao).readCategoryById(eq(1L));
    verify(productDao).readProductById(eq(1L));
    verify(skuDao).readSkuById(eq(1L));
    verify(productBundleImpl).getSkuBundleItems();
    verify(productBundleImpl).getName();
    verify(productBundleImpl, atLeast(1)).getProductOptions();
    verify(orderDao).readOrderById(eq(1L));
    verify(orderDao).save(isA(Order.class));
    verify(orderItemDao).create(isA(OrderItemType.class));
    verify(pricingService).executePricing(isA(Order.class));
    assertNull(actualAddSkuToOrderResult);
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer, boolean)} with {@code orderId}, {@code skuId}, {@code productId}, {@code categoryId}, {@code quantity}, {@code priceOrder}.
   * <p>
   * Method under test: {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"OrderItem LegacyOrderServiceImpl.addSkuToOrder(Long, Long, Long, Long, Integer, boolean)"})
  public void testAddSkuToOrderWithOrderIdSkuIdProductIdCategoryIdQuantityPriceOrder9() throws PricingException {
    // Arrange
    when(orderDao.readOrderById(Mockito.<Long>any())).thenReturn(new OrderImpl());
    when(pricingService.executePricing(Mockito.<Order>any()))
        .thenThrow(new IllegalArgumentException("ThreadLocalManager.notify.orphans"));
    when(categoryDao.readCategoryById(Mockito.<Long>any())).thenReturn(new CategoryImpl());
    when(orderItemDao.create(Mockito.<OrderItemType>any())).thenReturn(new BundleOrderItemImpl());
    ProductBundleImpl productBundleImpl = mock(ProductBundleImpl.class);
    when(productBundleImpl.getName()).thenReturn("Name");
    when(productBundleImpl.getSkuBundleItems()).thenReturn(new ArrayList<>());
    when(productBundleImpl.getProductOptions()).thenReturn(new ArrayList<>());
    when(productDao.readProductById(Mockito.<Long>any())).thenReturn(productBundleImpl);
    when(skuDao.readSkuById(Mockito.<Long>any())).thenReturn(new SkuImpl());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> legacyOrderServiceImpl.addSkuToOrder(1L, 1L, 1L, 1L, 2, true));
    verify(categoryDao).readCategoryById(eq(1L));
    verify(productDao).readProductById(eq(1L));
    verify(skuDao).readSkuById(eq(1L));
    verify(productBundleImpl).getSkuBundleItems();
    verify(productBundleImpl).getName();
    verify(productBundleImpl, atLeast(1)).getProductOptions();
    verify(orderDao).readOrderById(eq(1L));
    verify(orderItemDao).create(isA(OrderItemType.class));
    verify(pricingService).executePricing(isA(Order.class));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer, boolean)} with {@code orderId}, {@code skuId}, {@code productId}, {@code categoryId}, {@code quantity}, {@code priceOrder}.
   * <p>
   * Method under test: {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"OrderItem LegacyOrderServiceImpl.addSkuToOrder(Long, Long, Long, Long, Integer, boolean)"})
  public void testAddSkuToOrderWithOrderIdSkuIdProductIdCategoryIdQuantityPriceOrder10() throws PricingException {
    // Arrange
    when(orderDao.save(Mockito.<Order>any())).thenReturn(null);
    when(orderDao.readOrderById(Mockito.<Long>any())).thenReturn(new OrderImpl());
    when(pricingService.executePricing(Mockito.<Order>any())).thenReturn(new NullOrderImpl());
    when(categoryDao.readCategoryById(Mockito.<Long>any())).thenReturn(new CategoryImpl());
    when(orderItemDao.create(Mockito.<OrderItemType>any())).thenReturn(new BundleOrderItemImpl());
    ProductBundleImpl productBundleImpl = mock(ProductBundleImpl.class);
    when(productBundleImpl.getName()).thenReturn("Name");
    when(productBundleImpl.getSkuBundleItems()).thenReturn(new ArrayList<>());
    when(productBundleImpl.getProductOptions()).thenReturn(new ArrayList<>());
    when(productDao.readProductById(Mockito.<Long>any())).thenReturn(productBundleImpl);
    when(skuDao.readSkuById(Mockito.<Long>any())).thenReturn(new SkuImpl());

    // Act
    OrderItem actualAddSkuToOrderResult = legacyOrderServiceImpl.addSkuToOrder(1L, 1L, 1L, 1L, 2, true);

    // Assert
    verify(categoryDao).readCategoryById(eq(1L));
    verify(productDao).readProductById(eq(1L));
    verify(skuDao).readSkuById(eq(1L));
    verify(productBundleImpl).getSkuBundleItems();
    verify(productBundleImpl).getName();
    verify(productBundleImpl, atLeast(1)).getProductOptions();
    verify(orderDao).readOrderById(eq(1L));
    verify(orderDao).save(isA(Order.class));
    verify(orderItemDao).create(isA(OrderItemType.class));
    verify(pricingService).executePricing(isA(Order.class));
    assertNull(actualAddSkuToOrderResult);
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer, boolean)} with {@code orderId}, {@code skuId}, {@code productId}, {@code categoryId}, {@code quantity}, {@code priceOrder}.
   * <p>
   * Method under test: {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"OrderItem LegacyOrderServiceImpl.addSkuToOrder(Long, Long, Long, Long, Integer, boolean)"})
  public void testAddSkuToOrderWithOrderIdSkuIdProductIdCategoryIdQuantityPriceOrder11() throws PricingException {
    // Arrange
    Order order = mock(Order.class);
    when(order.getOrderItems()).thenThrow(new IllegalArgumentException("foo"));
    when(orderDao.readOrderById(Mockito.<Long>any())).thenReturn(order);
    when(categoryDao.readCategoryById(Mockito.<Long>any())).thenReturn(new CategoryImpl());
    when(orderItemDao.create(Mockito.<OrderItemType>any())).thenReturn(new BundleOrderItemImpl());
    ProductBundleImpl productBundleImpl = mock(ProductBundleImpl.class);
    when(productBundleImpl.getName()).thenReturn("Name");
    when(productBundleImpl.getSkuBundleItems()).thenReturn(new ArrayList<>());
    when(productBundleImpl.getProductOptions()).thenReturn(new ArrayList<>());
    when(productDao.readProductById(Mockito.<Long>any())).thenReturn(productBundleImpl);
    when(skuDao.readSkuById(Mockito.<Long>any())).thenReturn(new SkuImpl());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> legacyOrderServiceImpl.addSkuToOrder(1L, 1L, 1L, 1L, 2, true));
    verify(categoryDao).readCategoryById(eq(1L));
    verify(productDao).readProductById(eq(1L));
    verify(skuDao).readSkuById(eq(1L));
    verify(productBundleImpl).getSkuBundleItems();
    verify(productBundleImpl).getName();
    verify(productBundleImpl, atLeast(1)).getProductOptions();
    verify(orderDao).readOrderById(eq(1L));
    verify(orderItemDao).create(isA(OrderItemType.class));
    verify(order).getOrderItems();
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer, boolean)} with {@code orderId}, {@code skuId}, {@code productId}, {@code categoryId}, {@code quantity}, {@code priceOrder}.
   * <p>
   * Method under test: {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"OrderItem LegacyOrderServiceImpl.addSkuToOrder(Long, Long, Long, Long, Integer, boolean)"})
  public void testAddSkuToOrderWithOrderIdSkuIdProductIdCategoryIdQuantityPriceOrder12() throws PricingException {
    // Arrange
    when(orderDao.readOrderById(Mockito.<Long>any())).thenReturn(mock(Order.class));
    when(categoryDao.readCategoryById(Mockito.<Long>any())).thenReturn(null);
    ProductBundleImpl productBundleImpl = mock(ProductBundleImpl.class);
    when(productBundleImpl.getDefaultCategory()).thenThrow(new IllegalArgumentException("foo"));
    when(productBundleImpl.getProductOptions()).thenReturn(new ArrayList<>());
    when(productDao.readProductById(Mockito.<Long>any())).thenReturn(productBundleImpl);
    when(skuDao.readSkuById(Mockito.<Long>any())).thenReturn(new SkuImpl());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> legacyOrderServiceImpl.addSkuToOrder(1L, 1L, 1L, 1L, 2, true));
    verify(categoryDao).readCategoryById(eq(1L));
    verify(productDao).readProductById(eq(1L));
    verify(skuDao).readSkuById(eq(1L));
    verify(productBundleImpl).getDefaultCategory();
    verify(productBundleImpl, atLeast(1)).getProductOptions();
    verify(orderDao).readOrderById(eq(1L));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer, boolean)} with {@code orderId}, {@code skuId}, {@code productId}, {@code categoryId}, {@code quantity}, {@code priceOrder}.
   * <p>
   * Method under test: {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"OrderItem LegacyOrderServiceImpl.addSkuToOrder(Long, Long, Long, Long, Integer, boolean)"})
  public void testAddSkuToOrderWithOrderIdSkuIdProductIdCategoryIdQuantityPriceOrder13() throws PricingException {
    // Arrange
    when(orderDao.readOrderById(Mockito.<Long>any())).thenReturn(mock(Order.class));
    when(categoryDao.readCategoryById(Mockito.<Long>any())).thenReturn(null);
    ProductBundleImpl productBundleImpl = mock(ProductBundleImpl.class);
    when(productBundleImpl.getAdditionalSkus()).thenReturn(new ArrayList<>());
    when(productBundleImpl.getDefaultSku()).thenReturn(new SkuImpl());
    when(productBundleImpl.getDefaultCategory()).thenThrow(new IllegalArgumentException("foo"));
    when(productBundleImpl.getProductOptions()).thenReturn(new ArrayList<>());
    when(productDao.readProductById(Mockito.<Long>any())).thenReturn(productBundleImpl);
    when(skuDao.readSkuById(Mockito.<Long>any())).thenReturn(null);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> legacyOrderServiceImpl.addSkuToOrder(1L, 1L, 1L, 1L, 2, true));
    verify(categoryDao).readCategoryById(eq(1L));
    verify(productDao).readProductById(eq(1L));
    verify(skuDao).readSkuById(eq(1L));
    verify(productBundleImpl, atLeast(1)).getAdditionalSkus();
    verify(productBundleImpl).getDefaultCategory();
    verify(productBundleImpl).getDefaultSku();
    verify(productBundleImpl, atLeast(1)).getProductOptions();
    verify(orderDao).readOrderById(eq(1L));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer, boolean)} with {@code orderId}, {@code skuId}, {@code productId}, {@code categoryId}, {@code quantity}, {@code priceOrder}.
   * <p>
   * Method under test: {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"OrderItem LegacyOrderServiceImpl.addSkuToOrder(Long, Long, Long, Long, Integer, boolean)"})
  public void testAddSkuToOrderWithOrderIdSkuIdProductIdCategoryIdQuantityPriceOrder14() throws PricingException {
    // Arrange
    when(orderDao.readOrderById(Mockito.<Long>any())).thenReturn(mock(Order.class));

    ArrayList<Sku> skuList = new ArrayList<>();
    skuList.add(new SkuImpl());
    ProductBundleImpl productBundleImpl = mock(ProductBundleImpl.class);
    when(productBundleImpl.getAdditionalSkus()).thenReturn(skuList);
    when(productBundleImpl.getProductOptions()).thenReturn(new ArrayList<>());
    when(productDao.readProductById(Mockito.<Long>any())).thenReturn(productBundleImpl);
    when(skuDao.readSkuById(Mockito.<Long>any())).thenReturn(null);

    // Act and Assert
    assertThrows(RequiredAttributeNotProvidedException.class,
        () -> legacyOrderServiceImpl.addSkuToOrder(1L, 1L, 1L, 1L, 2, true));
    verify(productDao).readProductById(eq(1L));
    verify(skuDao).readSkuById(eq(1L));
    verify(productBundleImpl, atLeast(1)).getAdditionalSkus();
    verify(productBundleImpl, atLeast(1)).getProductOptions();
    verify(orderDao).readOrderById(eq(1L));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer, boolean)} with {@code orderId}, {@code skuId}, {@code productId}, {@code categoryId}, {@code quantity}, {@code priceOrder}.
   * <p>
   * Method under test: {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"OrderItem LegacyOrderServiceImpl.addSkuToOrder(Long, Long, Long, Long, Integer, boolean)"})
  public void testAddSkuToOrderWithOrderIdSkuIdProductIdCategoryIdQuantityPriceOrder15() throws PricingException {
    // Arrange
    when(orderDao.readOrderById(Mockito.<Long>any())).thenReturn(mock(Order.class));
    ProductBundleImpl productBundleImpl = mock(ProductBundleImpl.class);
    when(productBundleImpl.getAdditionalSkus()).thenReturn(new ArrayList<>());
    when(productBundleImpl.getDefaultSku()).thenReturn(null);
    when(productBundleImpl.getProductOptions()).thenReturn(new ArrayList<>());
    when(productDao.readProductById(Mockito.<Long>any())).thenReturn(productBundleImpl);
    when(skuDao.readSkuById(Mockito.<Long>any())).thenReturn(null);

    // Act
    OrderItem actualAddSkuToOrderResult = legacyOrderServiceImpl.addSkuToOrder(1L, 1L, 1L, 1L, 2, true);

    // Assert
    verify(productDao).readProductById(eq(1L));
    verify(skuDao).readSkuById(eq(1L));
    verify(productBundleImpl, atLeast(1)).getAdditionalSkus();
    verify(productBundleImpl).getDefaultSku();
    verify(productBundleImpl, atLeast(1)).getProductOptions();
    verify(orderDao).readOrderById(eq(1L));
    assertNull(actualAddSkuToOrderResult);
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer, boolean)} with {@code orderId}, {@code skuId}, {@code productId}, {@code categoryId}, {@code quantity}, {@code priceOrder}.
   * <p>
   * Method under test: {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"OrderItem LegacyOrderServiceImpl.addSkuToOrder(Long, Long, Long, Long, Integer, boolean)"})
  public void testAddSkuToOrderWithOrderIdSkuIdProductIdCategoryIdQuantityPriceOrder16() throws PricingException {
    // Arrange
    when(orderDao.readOrderById(Mockito.<Long>any())).thenReturn(mock(Order.class));
    when(categoryDao.readCategoryById(Mockito.<Long>any())).thenReturn(null);
    ProductBundleImpl productBundleImpl = mock(ProductBundleImpl.class);
    when(productBundleImpl.getAdditionalSkus()).thenReturn(new ArrayList<>());
    when(productBundleImpl.getDefaultSku()).thenReturn(new SkuImpl());
    when(productBundleImpl.getDefaultCategory()).thenThrow(new IllegalArgumentException("foo"));
    when(productBundleImpl.getProductOptions()).thenReturn(new ArrayList<>());
    when(productDao.readProductById(Mockito.<Long>any())).thenReturn(productBundleImpl);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> legacyOrderServiceImpl.addSkuToOrder(1L, null, 1L, 1L, 2, true));
    verify(categoryDao).readCategoryById(eq(1L));
    verify(productDao).readProductById(eq(1L));
    verify(productBundleImpl, atLeast(1)).getAdditionalSkus();
    verify(productBundleImpl).getDefaultCategory();
    verify(productBundleImpl).getDefaultSku();
    verify(productBundleImpl, atLeast(1)).getProductOptions();
    verify(orderDao).readOrderById(eq(1L));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer, boolean)} with {@code orderId}, {@code skuId}, {@code productId}, {@code categoryId}, {@code quantity}, {@code priceOrder}.
   * <p>
   * Method under test: {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"OrderItem LegacyOrderServiceImpl.addSkuToOrder(Long, Long, Long, Long, Integer, boolean)"})
  public void testAddSkuToOrderWithOrderIdSkuIdProductIdCategoryIdQuantityPriceOrder17() throws PricingException {
    // Arrange
    when(orderDao.readOrderById(Mockito.<Long>any())).thenReturn(mock(Order.class));
    when(skuDao.readSkuById(Mockito.<Long>any())).thenReturn(null);

    // Act
    OrderItem actualAddSkuToOrderResult = legacyOrderServiceImpl.addSkuToOrder(1L, 1L, null, 1L, 2, true);

    // Assert
    verify(skuDao).readSkuById(eq(1L));
    verify(orderDao).readOrderById(eq(1L));
    assertNull(actualAddSkuToOrderResult);
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer, boolean)} with {@code orderId}, {@code skuId}, {@code productId}, {@code categoryId}, {@code quantity}, {@code priceOrder}.
   * <p>
   * Method under test: {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"OrderItem LegacyOrderServiceImpl.addSkuToOrder(Long, Long, Long, Long, Integer, boolean)"})
  public void testAddSkuToOrderWithOrderIdSkuIdProductIdCategoryIdQuantityPriceOrder18() throws PricingException {
    // Arrange
    when(orderDao.readOrderById(Mockito.<Long>any())).thenReturn(mock(Order.class));
    ProductBundleImpl productBundleImpl = mock(ProductBundleImpl.class);
    when(productBundleImpl.getAdditionalSkus()).thenReturn(new ArrayList<>());
    when(productBundleImpl.getDefaultSku()).thenReturn(new SkuImpl());
    when(productBundleImpl.getDefaultCategory()).thenThrow(new IllegalArgumentException("foo"));
    when(productBundleImpl.getProductOptions()).thenReturn(new ArrayList<>());
    when(productDao.readProductById(Mockito.<Long>any())).thenReturn(productBundleImpl);
    when(skuDao.readSkuById(Mockito.<Long>any())).thenReturn(null);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> legacyOrderServiceImpl.addSkuToOrder(1L, 1L, 1L, null, 2, true));
    verify(productDao).readProductById(eq(1L));
    verify(skuDao).readSkuById(eq(1L));
    verify(productBundleImpl, atLeast(1)).getAdditionalSkus();
    verify(productBundleImpl).getDefaultCategory();
    verify(productBundleImpl).getDefaultSku();
    verify(productBundleImpl, atLeast(1)).getProductOptions();
    verify(orderDao).readOrderById(eq(1L));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer, boolean, Map)} with {@code orderId}, {@code skuId}, {@code productId}, {@code categoryId}, {@code quantity}, {@code priceOrder}, {@code itemAttributes}.
   * <p>
   * Method under test: {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer, boolean, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"OrderItem LegacyOrderServiceImpl.addSkuToOrder(Long, Long, Long, Long, Integer, boolean, Map)"})
  public void testAddSkuToOrderWithOrderIdSkuIdProductIdCategoryIdQuantityPriceOrderItemAttributes()
      throws PricingException {
    // Arrange, Act and Assert
    assertNull(legacyOrderServiceImpl.addSkuToOrder(null, null, null, 1L, null, true, new HashMap<>()));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer, boolean, Map)} with {@code orderId}, {@code skuId}, {@code productId}, {@code categoryId}, {@code quantity}, {@code priceOrder}, {@code itemAttributes}.
   * <p>
   * Method under test: {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer, boolean, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"OrderItem LegacyOrderServiceImpl.addSkuToOrder(Long, Long, Long, Long, Integer, boolean, Map)"})
  public void testAddSkuToOrderWithOrderIdSkuIdProductIdCategoryIdQuantityPriceOrderItemAttributes2()
      throws PricingException {
    // Arrange, Act and Assert
    assertNull(legacyOrderServiceImpl.addSkuToOrder(1L, null, null, 1L, null, true, new HashMap<>()));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer, boolean, Map)} with {@code orderId}, {@code skuId}, {@code productId}, {@code categoryId}, {@code quantity}, {@code priceOrder}, {@code itemAttributes}.
   * <p>
   * Method under test: {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer, boolean, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"OrderItem LegacyOrderServiceImpl.addSkuToOrder(Long, Long, Long, Long, Integer, boolean, Map)"})
  public void testAddSkuToOrderWithOrderIdSkuIdProductIdCategoryIdQuantityPriceOrderItemAttributes3()
      throws PricingException {
    // Arrange, Act and Assert
    assertNull(legacyOrderServiceImpl.addSkuToOrder(1L, null, 1L, 1L, null, true, new HashMap<>()));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer, boolean, Map)} with {@code orderId}, {@code skuId}, {@code productId}, {@code categoryId}, {@code quantity}, {@code priceOrder}, {@code itemAttributes}.
   * <p>
   * Method under test: {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer, boolean, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"OrderItem LegacyOrderServiceImpl.addSkuToOrder(Long, Long, Long, Long, Integer, boolean, Map)"})
  public void testAddSkuToOrderWithOrderIdSkuIdProductIdCategoryIdQuantityPriceOrderItemAttributes4()
      throws PricingException {
    // Arrange, Act and Assert
    assertNull(legacyOrderServiceImpl.addSkuToOrder(1L, 1L, null, 1L, null, true, new HashMap<>()));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer, boolean, Map)} with {@code orderId}, {@code skuId}, {@code productId}, {@code categoryId}, {@code quantity}, {@code priceOrder}, {@code itemAttributes}.
   * <p>
   * Method under test: {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer, boolean, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"OrderItem LegacyOrderServiceImpl.addSkuToOrder(Long, Long, Long, Long, Integer, boolean, Map)"})
  public void testAddSkuToOrderWithOrderIdSkuIdProductIdCategoryIdQuantityPriceOrderItemAttributes5()
      throws PricingException {
    // Arrange
    when(orderDao.readOrderById(Mockito.<Long>any())).thenReturn(new NullOrderImpl());
    when(categoryDao.readCategoryById(Mockito.<Long>any())).thenReturn(new CategoryImpl());
    when(orderItemDao.create(Mockito.<OrderItemType>any())).thenThrow(new IllegalArgumentException("foo"));
    when(productDao.readProductById(Mockito.<Long>any())).thenReturn(new ProductBundleImpl());
    when(skuDao.readSkuById(Mockito.<Long>any())).thenReturn(new SkuImpl());

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> legacyOrderServiceImpl.addSkuToOrder(1L, 1L, 1L, 1L, 2, true, new HashMap<>()));
    verify(categoryDao).readCategoryById(eq(1L));
    verify(productDao).readProductById(eq(1L));
    verify(skuDao).readSkuById(eq(1L));
    verify(orderDao).readOrderById(eq(1L));
    verify(orderItemDao).create(isA(OrderItemType.class));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer, boolean, Map)} with {@code orderId}, {@code skuId}, {@code productId}, {@code categoryId}, {@code quantity}, {@code priceOrder}, {@code itemAttributes}.
   * <p>
   * Method under test: {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer, boolean, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"OrderItem LegacyOrderServiceImpl.addSkuToOrder(Long, Long, Long, Long, Integer, boolean, Map)"})
  public void testAddSkuToOrderWithOrderIdSkuIdProductIdCategoryIdQuantityPriceOrderItemAttributes6()
      throws PricingException {
    // Arrange
    when(orderDao.readOrderById(Mockito.<Long>any())).thenReturn(null);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> legacyOrderServiceImpl.addSkuToOrder(1L, 1L, 1L, 1L, 2, true, new HashMap<>()));
    verify(orderDao).readOrderById(eq(1L));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer, boolean, Map)} with {@code orderId}, {@code skuId}, {@code productId}, {@code categoryId}, {@code quantity}, {@code priceOrder}, {@code itemAttributes}.
   * <p>
   * Method under test: {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer, boolean, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"OrderItem LegacyOrderServiceImpl.addSkuToOrder(Long, Long, Long, Long, Integer, boolean, Map)"})
  public void testAddSkuToOrderWithOrderIdSkuIdProductIdCategoryIdQuantityPriceOrderItemAttributes7()
      throws PricingException {
    // Arrange
    when(orderDao.readOrderById(Mockito.<Long>any())).thenReturn(new NullOrderImpl());
    when(productDao.readProductById(Mockito.<Long>any())).thenReturn(null);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> legacyOrderServiceImpl.addSkuToOrder(1L, 1L, 1L, 1L, 2, true, new HashMap<>()));
    verify(productDao).readProductById(eq(1L));
    verify(orderDao).readOrderById(eq(1L));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer, boolean, Map)} with {@code orderId}, {@code skuId}, {@code productId}, {@code categoryId}, {@code quantity}, {@code priceOrder}, {@code itemAttributes}.
   * <p>
   * Method under test: {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer, boolean, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"OrderItem LegacyOrderServiceImpl.addSkuToOrder(Long, Long, Long, Long, Integer, boolean, Map)"})
  public void testAddSkuToOrderWithOrderIdSkuIdProductIdCategoryIdQuantityPriceOrderItemAttributes8()
      throws PricingException {
    // Arrange
    when(orderDao.save(Mockito.<Order>any())).thenReturn(new NullOrderImpl());
    when(orderDao.readOrderById(Mockito.<Long>any())).thenReturn(new OrderImpl());
    when(pricingService.executePricing(Mockito.<Order>any())).thenReturn(new NullOrderImpl());
    when(categoryDao.readCategoryById(Mockito.<Long>any())).thenReturn(new CategoryImpl());
    when(orderItemDao.create(Mockito.<OrderItemType>any())).thenReturn(new BundleOrderItemImpl());
    ProductBundleImpl productBundleImpl = mock(ProductBundleImpl.class);
    when(productBundleImpl.getName()).thenReturn("Name");
    when(productBundleImpl.getSkuBundleItems()).thenReturn(new ArrayList<>());
    when(productBundleImpl.getProductOptions()).thenReturn(new ArrayList<>());
    when(productDao.readProductById(Mockito.<Long>any())).thenReturn(productBundleImpl);
    when(skuDao.readSkuById(Mockito.<Long>any())).thenReturn(new SkuImpl());

    // Act
    OrderItem actualAddSkuToOrderResult = legacyOrderServiceImpl.addSkuToOrder(1L, 1L, 1L, 1L, 2, true,
        new HashMap<>());

    // Assert
    verify(categoryDao).readCategoryById(eq(1L));
    verify(productDao).readProductById(eq(1L));
    verify(skuDao).readSkuById(eq(1L));
    verify(productBundleImpl).getSkuBundleItems();
    verify(productBundleImpl).getName();
    verify(productBundleImpl, atLeast(1)).getProductOptions();
    verify(orderDao).readOrderById(eq(1L));
    verify(orderDao).save(isA(Order.class));
    verify(orderItemDao).create(isA(OrderItemType.class));
    verify(pricingService).executePricing(isA(Order.class));
    assertNull(actualAddSkuToOrderResult);
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer, boolean, Map)} with {@code orderId}, {@code skuId}, {@code productId}, {@code categoryId}, {@code quantity}, {@code priceOrder}, {@code itemAttributes}.
   * <p>
   * Method under test: {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer, boolean, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"OrderItem LegacyOrderServiceImpl.addSkuToOrder(Long, Long, Long, Long, Integer, boolean, Map)"})
  public void testAddSkuToOrderWithOrderIdSkuIdProductIdCategoryIdQuantityPriceOrderItemAttributes9()
      throws PricingException {
    // Arrange
    when(orderDao.readOrderById(Mockito.<Long>any())).thenReturn(new OrderImpl());
    when(pricingService.executePricing(Mockito.<Order>any()))
        .thenThrow(new IllegalArgumentException("ThreadLocalManager.notify.orphans"));
    when(categoryDao.readCategoryById(Mockito.<Long>any())).thenReturn(new CategoryImpl());
    when(orderItemDao.create(Mockito.<OrderItemType>any())).thenReturn(new BundleOrderItemImpl());
    ProductBundleImpl productBundleImpl = mock(ProductBundleImpl.class);
    when(productBundleImpl.getName()).thenReturn("Name");
    when(productBundleImpl.getSkuBundleItems()).thenReturn(new ArrayList<>());
    when(productBundleImpl.getProductOptions()).thenReturn(new ArrayList<>());
    when(productDao.readProductById(Mockito.<Long>any())).thenReturn(productBundleImpl);
    when(skuDao.readSkuById(Mockito.<Long>any())).thenReturn(new SkuImpl());

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> legacyOrderServiceImpl.addSkuToOrder(1L, 1L, 1L, 1L, 2, true, new HashMap<>()));
    verify(categoryDao).readCategoryById(eq(1L));
    verify(productDao).readProductById(eq(1L));
    verify(skuDao).readSkuById(eq(1L));
    verify(productBundleImpl).getSkuBundleItems();
    verify(productBundleImpl).getName();
    verify(productBundleImpl, atLeast(1)).getProductOptions();
    verify(orderDao).readOrderById(eq(1L));
    verify(orderItemDao).create(isA(OrderItemType.class));
    verify(pricingService).executePricing(isA(Order.class));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer, boolean, Map)} with {@code orderId}, {@code skuId}, {@code productId}, {@code categoryId}, {@code quantity}, {@code priceOrder}, {@code itemAttributes}.
   * <p>
   * Method under test: {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer, boolean, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"OrderItem LegacyOrderServiceImpl.addSkuToOrder(Long, Long, Long, Long, Integer, boolean, Map)"})
  public void testAddSkuToOrderWithOrderIdSkuIdProductIdCategoryIdQuantityPriceOrderItemAttributes10()
      throws PricingException {
    // Arrange
    when(orderDao.save(Mockito.<Order>any())).thenReturn(null);
    when(orderDao.readOrderById(Mockito.<Long>any())).thenReturn(new OrderImpl());
    when(pricingService.executePricing(Mockito.<Order>any())).thenReturn(new NullOrderImpl());
    when(categoryDao.readCategoryById(Mockito.<Long>any())).thenReturn(new CategoryImpl());
    when(orderItemDao.create(Mockito.<OrderItemType>any())).thenReturn(new BundleOrderItemImpl());
    ProductBundleImpl productBundleImpl = mock(ProductBundleImpl.class);
    when(productBundleImpl.getName()).thenReturn("Name");
    when(productBundleImpl.getSkuBundleItems()).thenReturn(new ArrayList<>());
    when(productBundleImpl.getProductOptions()).thenReturn(new ArrayList<>());
    when(productDao.readProductById(Mockito.<Long>any())).thenReturn(productBundleImpl);
    when(skuDao.readSkuById(Mockito.<Long>any())).thenReturn(new SkuImpl());

    // Act
    OrderItem actualAddSkuToOrderResult = legacyOrderServiceImpl.addSkuToOrder(1L, 1L, 1L, 1L, 2, true,
        new HashMap<>());

    // Assert
    verify(categoryDao).readCategoryById(eq(1L));
    verify(productDao).readProductById(eq(1L));
    verify(skuDao).readSkuById(eq(1L));
    verify(productBundleImpl).getSkuBundleItems();
    verify(productBundleImpl).getName();
    verify(productBundleImpl, atLeast(1)).getProductOptions();
    verify(orderDao).readOrderById(eq(1L));
    verify(orderDao).save(isA(Order.class));
    verify(orderItemDao).create(isA(OrderItemType.class));
    verify(pricingService).executePricing(isA(Order.class));
    assertNull(actualAddSkuToOrderResult);
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer, boolean, Map)} with {@code orderId}, {@code skuId}, {@code productId}, {@code categoryId}, {@code quantity}, {@code priceOrder}, {@code itemAttributes}.
   * <p>
   * Method under test: {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer, boolean, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"OrderItem LegacyOrderServiceImpl.addSkuToOrder(Long, Long, Long, Long, Integer, boolean, Map)"})
  public void testAddSkuToOrderWithOrderIdSkuIdProductIdCategoryIdQuantityPriceOrderItemAttributes11()
      throws PricingException {
    // Arrange
    Order order = mock(Order.class);
    when(order.getOrderItems()).thenThrow(new IllegalArgumentException("foo"));
    when(orderDao.readOrderById(Mockito.<Long>any())).thenReturn(order);
    when(categoryDao.readCategoryById(Mockito.<Long>any())).thenReturn(new CategoryImpl());
    when(orderItemDao.create(Mockito.<OrderItemType>any())).thenReturn(new BundleOrderItemImpl());
    ProductBundleImpl productBundleImpl = mock(ProductBundleImpl.class);
    when(productBundleImpl.getName()).thenReturn("Name");
    when(productBundleImpl.getSkuBundleItems()).thenReturn(new ArrayList<>());
    when(productBundleImpl.getProductOptions()).thenReturn(new ArrayList<>());
    when(productDao.readProductById(Mockito.<Long>any())).thenReturn(productBundleImpl);
    when(skuDao.readSkuById(Mockito.<Long>any())).thenReturn(new SkuImpl());

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> legacyOrderServiceImpl.addSkuToOrder(1L, 1L, 1L, 1L, 2, true, new HashMap<>()));
    verify(categoryDao).readCategoryById(eq(1L));
    verify(productDao).readProductById(eq(1L));
    verify(skuDao).readSkuById(eq(1L));
    verify(productBundleImpl).getSkuBundleItems();
    verify(productBundleImpl).getName();
    verify(productBundleImpl, atLeast(1)).getProductOptions();
    verify(orderDao).readOrderById(eq(1L));
    verify(orderItemDao).create(isA(OrderItemType.class));
    verify(order).getOrderItems();
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer, boolean, Map)} with {@code orderId}, {@code skuId}, {@code productId}, {@code categoryId}, {@code quantity}, {@code priceOrder}, {@code itemAttributes}.
   * <p>
   * Method under test: {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer, boolean, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"OrderItem LegacyOrderServiceImpl.addSkuToOrder(Long, Long, Long, Long, Integer, boolean, Map)"})
  public void testAddSkuToOrderWithOrderIdSkuIdProductIdCategoryIdQuantityPriceOrderItemAttributes12()
      throws PricingException {
    // Arrange
    when(orderDao.readOrderById(Mockito.<Long>any())).thenReturn(mock(Order.class));
    when(categoryDao.readCategoryById(Mockito.<Long>any())).thenReturn(null);
    ProductBundleImpl productBundleImpl = mock(ProductBundleImpl.class);
    when(productBundleImpl.getDefaultCategory()).thenThrow(new IllegalArgumentException("foo"));
    when(productBundleImpl.getProductOptions()).thenReturn(new ArrayList<>());
    when(productDao.readProductById(Mockito.<Long>any())).thenReturn(productBundleImpl);
    when(skuDao.readSkuById(Mockito.<Long>any())).thenReturn(new SkuImpl());

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> legacyOrderServiceImpl.addSkuToOrder(1L, 1L, 1L, 1L, 2, true, new HashMap<>()));
    verify(categoryDao).readCategoryById(eq(1L));
    verify(productDao).readProductById(eq(1L));
    verify(skuDao).readSkuById(eq(1L));
    verify(productBundleImpl).getDefaultCategory();
    verify(productBundleImpl, atLeast(1)).getProductOptions();
    verify(orderDao).readOrderById(eq(1L));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer, boolean, Map)} with {@code orderId}, {@code skuId}, {@code productId}, {@code categoryId}, {@code quantity}, {@code priceOrder}, {@code itemAttributes}.
   * <p>
   * Method under test: {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer, boolean, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"OrderItem LegacyOrderServiceImpl.addSkuToOrder(Long, Long, Long, Long, Integer, boolean, Map)"})
  public void testAddSkuToOrderWithOrderIdSkuIdProductIdCategoryIdQuantityPriceOrderItemAttributes13()
      throws PricingException {
    // Arrange
    when(orderDao.readOrderById(Mockito.<Long>any())).thenReturn(mock(Order.class));
    when(categoryDao.readCategoryById(Mockito.<Long>any())).thenReturn(null);
    ProductBundleImpl productBundleImpl = mock(ProductBundleImpl.class);
    when(productBundleImpl.getAdditionalSkus()).thenReturn(new ArrayList<>());
    when(productBundleImpl.getDefaultSku()).thenReturn(new SkuImpl());
    when(productBundleImpl.getDefaultCategory()).thenThrow(new IllegalArgumentException("foo"));
    when(productBundleImpl.getProductOptions()).thenReturn(new ArrayList<>());
    when(productDao.readProductById(Mockito.<Long>any())).thenReturn(productBundleImpl);
    when(skuDao.readSkuById(Mockito.<Long>any())).thenReturn(null);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> legacyOrderServiceImpl.addSkuToOrder(1L, 1L, 1L, 1L, 2, true, new HashMap<>()));
    verify(categoryDao).readCategoryById(eq(1L));
    verify(productDao).readProductById(eq(1L));
    verify(skuDao).readSkuById(eq(1L));
    verify(productBundleImpl, atLeast(1)).getAdditionalSkus();
    verify(productBundleImpl).getDefaultCategory();
    verify(productBundleImpl).getDefaultSku();
    verify(productBundleImpl, atLeast(1)).getProductOptions();
    verify(orderDao).readOrderById(eq(1L));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer, boolean, Map)} with {@code orderId}, {@code skuId}, {@code productId}, {@code categoryId}, {@code quantity}, {@code priceOrder}, {@code itemAttributes}.
   * <p>
   * Method under test: {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer, boolean, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"OrderItem LegacyOrderServiceImpl.addSkuToOrder(Long, Long, Long, Long, Integer, boolean, Map)"})
  public void testAddSkuToOrderWithOrderIdSkuIdProductIdCategoryIdQuantityPriceOrderItemAttributes14()
      throws PricingException {
    // Arrange
    when(orderDao.readOrderById(Mockito.<Long>any())).thenReturn(mock(Order.class));

    ArrayList<Sku> skuList = new ArrayList<>();
    skuList.add(new SkuImpl());
    ProductBundleImpl productBundleImpl = mock(ProductBundleImpl.class);
    when(productBundleImpl.getAdditionalSkus()).thenReturn(skuList);
    when(productBundleImpl.getProductOptions()).thenReturn(new ArrayList<>());
    when(productDao.readProductById(Mockito.<Long>any())).thenReturn(productBundleImpl);
    when(skuDao.readSkuById(Mockito.<Long>any())).thenReturn(null);

    // Act and Assert
    assertThrows(RequiredAttributeNotProvidedException.class,
        () -> legacyOrderServiceImpl.addSkuToOrder(1L, 1L, 1L, 1L, 2, true, new HashMap<>()));
    verify(productDao).readProductById(eq(1L));
    verify(skuDao).readSkuById(eq(1L));
    verify(productBundleImpl, atLeast(1)).getAdditionalSkus();
    verify(productBundleImpl, atLeast(1)).getProductOptions();
    verify(orderDao).readOrderById(eq(1L));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer, boolean, Map)} with {@code orderId}, {@code skuId}, {@code productId}, {@code categoryId}, {@code quantity}, {@code priceOrder}, {@code itemAttributes}.
   * <p>
   * Method under test: {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer, boolean, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"OrderItem LegacyOrderServiceImpl.addSkuToOrder(Long, Long, Long, Long, Integer, boolean, Map)"})
  public void testAddSkuToOrderWithOrderIdSkuIdProductIdCategoryIdQuantityPriceOrderItemAttributes15()
      throws PricingException {
    // Arrange
    when(orderDao.readOrderById(Mockito.<Long>any())).thenReturn(mock(Order.class));
    ProductBundleImpl productBundleImpl = mock(ProductBundleImpl.class);
    when(productBundleImpl.getAdditionalSkus()).thenReturn(new ArrayList<>());
    when(productBundleImpl.getDefaultSku()).thenReturn(null);
    when(productBundleImpl.getProductOptions()).thenReturn(new ArrayList<>());
    when(productDao.readProductById(Mockito.<Long>any())).thenReturn(productBundleImpl);
    when(skuDao.readSkuById(Mockito.<Long>any())).thenReturn(null);

    // Act
    OrderItem actualAddSkuToOrderResult = legacyOrderServiceImpl.addSkuToOrder(1L, 1L, 1L, 1L, 2, true,
        new HashMap<>());

    // Assert
    verify(productDao).readProductById(eq(1L));
    verify(skuDao).readSkuById(eq(1L));
    verify(productBundleImpl, atLeast(1)).getAdditionalSkus();
    verify(productBundleImpl).getDefaultSku();
    verify(productBundleImpl, atLeast(1)).getProductOptions();
    verify(orderDao).readOrderById(eq(1L));
    assertNull(actualAddSkuToOrderResult);
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer, boolean, Map)} with {@code orderId}, {@code skuId}, {@code productId}, {@code categoryId}, {@code quantity}, {@code priceOrder}, {@code itemAttributes}.
   * <p>
   * Method under test: {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer, boolean, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"OrderItem LegacyOrderServiceImpl.addSkuToOrder(Long, Long, Long, Long, Integer, boolean, Map)"})
  public void testAddSkuToOrderWithOrderIdSkuIdProductIdCategoryIdQuantityPriceOrderItemAttributes16()
      throws PricingException {
    // Arrange
    when(orderDao.readOrderById(Mockito.<Long>any())).thenReturn(mock(Order.class));
    when(categoryDao.readCategoryById(Mockito.<Long>any())).thenReturn(null);
    ProductBundleImpl productBundleImpl = mock(ProductBundleImpl.class);
    when(productBundleImpl.getAdditionalSkus()).thenReturn(new ArrayList<>());
    when(productBundleImpl.getDefaultSku()).thenReturn(new SkuImpl());
    when(productBundleImpl.getDefaultCategory()).thenThrow(new IllegalArgumentException("foo"));
    when(productBundleImpl.getProductOptions()).thenReturn(new ArrayList<>());
    when(productDao.readProductById(Mockito.<Long>any())).thenReturn(productBundleImpl);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> legacyOrderServiceImpl.addSkuToOrder(1L, null, 1L, 1L, 2, true, new HashMap<>()));
    verify(categoryDao).readCategoryById(eq(1L));
    verify(productDao).readProductById(eq(1L));
    verify(productBundleImpl, atLeast(1)).getAdditionalSkus();
    verify(productBundleImpl).getDefaultCategory();
    verify(productBundleImpl).getDefaultSku();
    verify(productBundleImpl, atLeast(1)).getProductOptions();
    verify(orderDao).readOrderById(eq(1L));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer, boolean, Map)} with {@code orderId}, {@code skuId}, {@code productId}, {@code categoryId}, {@code quantity}, {@code priceOrder}, {@code itemAttributes}.
   * <p>
   * Method under test: {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer, boolean, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"OrderItem LegacyOrderServiceImpl.addSkuToOrder(Long, Long, Long, Long, Integer, boolean, Map)"})
  public void testAddSkuToOrderWithOrderIdSkuIdProductIdCategoryIdQuantityPriceOrderItemAttributes17()
      throws PricingException {
    // Arrange
    when(orderDao.readOrderById(Mockito.<Long>any())).thenReturn(mock(Order.class));
    when(skuDao.readSkuById(Mockito.<Long>any())).thenReturn(null);

    // Act
    OrderItem actualAddSkuToOrderResult = legacyOrderServiceImpl.addSkuToOrder(1L, 1L, null, 1L, 2, true,
        new HashMap<>());

    // Assert
    verify(skuDao).readSkuById(eq(1L));
    verify(orderDao).readOrderById(eq(1L));
    assertNull(actualAddSkuToOrderResult);
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer, boolean, Map)} with {@code orderId}, {@code skuId}, {@code productId}, {@code categoryId}, {@code quantity}, {@code priceOrder}, {@code itemAttributes}.
   * <p>
   * Method under test: {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer, boolean, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"OrderItem LegacyOrderServiceImpl.addSkuToOrder(Long, Long, Long, Long, Integer, boolean, Map)"})
  public void testAddSkuToOrderWithOrderIdSkuIdProductIdCategoryIdQuantityPriceOrderItemAttributes18()
      throws PricingException {
    // Arrange
    when(orderDao.readOrderById(Mockito.<Long>any())).thenReturn(mock(Order.class));
    ProductBundleImpl productBundleImpl = mock(ProductBundleImpl.class);
    when(productBundleImpl.getAdditionalSkus()).thenReturn(new ArrayList<>());
    when(productBundleImpl.getDefaultSku()).thenReturn(new SkuImpl());
    when(productBundleImpl.getDefaultCategory()).thenThrow(new IllegalArgumentException("foo"));
    when(productBundleImpl.getProductOptions()).thenReturn(new ArrayList<>());
    when(productDao.readProductById(Mockito.<Long>any())).thenReturn(productBundleImpl);
    when(skuDao.readSkuById(Mockito.<Long>any())).thenReturn(null);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> legacyOrderServiceImpl.addSkuToOrder(1L, 1L, 1L, null, 2, true, new HashMap<>()));
    verify(productDao).readProductById(eq(1L));
    verify(skuDao).readSkuById(eq(1L));
    verify(productBundleImpl, atLeast(1)).getAdditionalSkus();
    verify(productBundleImpl).getDefaultCategory();
    verify(productBundleImpl).getDefaultSku();
    verify(productBundleImpl, atLeast(1)).getProductOptions();
    verify(orderDao).readOrderById(eq(1L));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer)} with {@code orderId}, {@code skuId}, {@code productId}, {@code categoryId}, {@code quantity}.
   * <ul>
   *   <li>Given {@link OrderDao}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"OrderItem LegacyOrderServiceImpl.addSkuToOrder(Long, Long, Long, Long, Integer)"})
  public void testAddSkuToOrderWithOrderIdSkuIdProductIdCategoryIdQuantity_givenOrderDao() throws PricingException {
    // Arrange, Act and Assert
    assertNull(legacyOrderServiceImpl.addSkuToOrder(null, null, null, 1L, null));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer)} with {@code orderId}, {@code skuId}, {@code productId}, {@code categoryId}, {@code quantity}.
   * <ul>
   *   <li>Given {@link OrderDao}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"OrderItem LegacyOrderServiceImpl.addSkuToOrder(Long, Long, Long, Long, Integer)"})
  public void testAddSkuToOrderWithOrderIdSkuIdProductIdCategoryIdQuantity_givenOrderDao2() throws PricingException {
    // Arrange, Act and Assert
    assertNull(legacyOrderServiceImpl.addSkuToOrder(1L, null, null, 1L, null));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer)} with {@code orderId}, {@code skuId}, {@code productId}, {@code categoryId}, {@code quantity}.
   * <ul>
   *   <li>Given {@link OrderDao}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"OrderItem LegacyOrderServiceImpl.addSkuToOrder(Long, Long, Long, Long, Integer)"})
  public void testAddSkuToOrderWithOrderIdSkuIdProductIdCategoryIdQuantity_givenOrderDao3() throws PricingException {
    // Arrange, Act and Assert
    assertNull(legacyOrderServiceImpl.addSkuToOrder(1L, null, 1L, 1L, null));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer)} with {@code orderId}, {@code skuId}, {@code productId}, {@code categoryId}, {@code quantity}.
   * <ul>
   *   <li>Given {@link OrderDao}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"OrderItem LegacyOrderServiceImpl.addSkuToOrder(Long, Long, Long, Long, Integer)"})
  public void testAddSkuToOrderWithOrderIdSkuIdProductIdCategoryIdQuantity_givenOrderDao4() throws PricingException {
    // Arrange, Act and Assert
    assertNull(legacyOrderServiceImpl.addSkuToOrder(1L, 1L, null, 1L, null));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addDynamicPriceDiscreteItemToOrder(Order, DiscreteOrderItemRequest, HashMap)} with {@code order}, {@code itemRequest}, {@code skuPricingConsiderations}.
   * <p>
   * Method under test: {@link LegacyOrderServiceImpl#addDynamicPriceDiscreteItemToOrder(Order, DiscreteOrderItemRequest, HashMap)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "OrderItem LegacyOrderServiceImpl.addDynamicPriceDiscreteItemToOrder(Order, DiscreteOrderItemRequest, HashMap)"})
  public void testAddDynamicPriceDiscreteItemToOrderWithOrderItemRequestSkuPricingConsiderations()
      throws PricingException {
    // Arrange
    when(orderItemService.createDynamicPriceDiscreteOrderItem(Mockito.<DiscreteOrderItemRequest>any(),
        Mockito.<HashMap<Object, Object>>any())).thenThrow(new IllegalArgumentException("foo"));
    NullOrderImpl order = new NullOrderImpl();
    DiscreteOrderItemRequest itemRequest = new DiscreteOrderItemRequest();

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> legacyOrderServiceImpl.addDynamicPriceDiscreteItemToOrder(order, itemRequest, new HashMap()));
    verify(orderItemService).createDynamicPriceDiscreteOrderItem(isA(DiscreteOrderItemRequest.class),
        isA(HashMap.class));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addDynamicPriceDiscreteItemToOrder(Order, DiscreteOrderItemRequest, HashMap, boolean)} with {@code order}, {@code itemRequest}, {@code skuPricingConsiderations}, {@code priceOrder}.
   * <p>
   * Method under test: {@link LegacyOrderServiceImpl#addDynamicPriceDiscreteItemToOrder(Order, DiscreteOrderItemRequest, HashMap, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "OrderItem LegacyOrderServiceImpl.addDynamicPriceDiscreteItemToOrder(Order, DiscreteOrderItemRequest, HashMap, boolean)"})
  public void testAddDynamicPriceDiscreteItemToOrderWithOrderItemRequestSkuPricingConsiderationsPriceOrder()
      throws PricingException {
    // Arrange
    when(orderItemService.createDynamicPriceDiscreteOrderItem(Mockito.<DiscreteOrderItemRequest>any(),
        Mockito.<HashMap<Object, Object>>any())).thenThrow(new IllegalArgumentException("foo"));
    NullOrderImpl order = new NullOrderImpl();
    DiscreteOrderItemRequest itemRequest = new DiscreteOrderItemRequest();

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> legacyOrderServiceImpl.addDynamicPriceDiscreteItemToOrder(order, itemRequest, new HashMap(), true));
    verify(orderItemService).createDynamicPriceDiscreteOrderItem(isA(DiscreteOrderItemRequest.class),
        isA(HashMap.class));
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link LegacyOrderServiceImpl}
   *   <li>{@link LegacyOrderServiceImpl#setFulfillmentGroupDao(FulfillmentGroupDao)}
   *   <li>{@link LegacyOrderServiceImpl#setFulfillmentGroupItemDao(FulfillmentGroupItemDao)}
   *   <li>{@link LegacyOrderServiceImpl#setOrderDao(OrderDao)}
   *   <li>{@link LegacyOrderServiceImpl#setOrderItemService(OrderItemService)}
   *   <li>{@link LegacyOrderServiceImpl#setPaymentInfoDao(OrderPaymentDao)}
   *   <li>{@link LegacyOrderServiceImpl#getFulfillmentGroupDao()}
   *   <li>{@link LegacyOrderServiceImpl#getFulfillmentGroupItemDao()}
   *   <li>{@link LegacyOrderServiceImpl#getOrderDao()}
   *   <li>{@link LegacyOrderServiceImpl#getOrderItemService()}
   *   <li>{@link LegacyOrderServiceImpl#getPaymentInfoDao()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void LegacyOrderServiceImpl.<init>()",
      "FulfillmentGroupDao LegacyOrderServiceImpl.getFulfillmentGroupDao()",
      "FulfillmentGroupItemDao LegacyOrderServiceImpl.getFulfillmentGroupItemDao()",
      "OrderDao LegacyOrderServiceImpl.getOrderDao()", "OrderItemService LegacyOrderServiceImpl.getOrderItemService()",
      "OrderPaymentDao LegacyOrderServiceImpl.getPaymentInfoDao()",
      "void LegacyOrderServiceImpl.setFulfillmentGroupDao(FulfillmentGroupDao)",
      "void LegacyOrderServiceImpl.setFulfillmentGroupItemDao(FulfillmentGroupItemDao)",
      "void LegacyOrderServiceImpl.setOrderDao(OrderDao)",
      "void LegacyOrderServiceImpl.setOrderItemService(OrderItemService)",
      "void LegacyOrderServiceImpl.setPaymentInfoDao(OrderPaymentDao)"})
  public void testGettersAndSetters() {
    // Arrange and Act
    LegacyOrderServiceImpl actualLegacyOrderServiceImpl = new LegacyOrderServiceImpl();
    FulfillmentGroupDaoImpl fulfillmentGroupDao = new FulfillmentGroupDaoImpl();
    actualLegacyOrderServiceImpl.setFulfillmentGroupDao(fulfillmentGroupDao);
    FulfillmentGroupItemDaoImpl fulfillmentGroupItemDao = new FulfillmentGroupItemDaoImpl();
    actualLegacyOrderServiceImpl.setFulfillmentGroupItemDao(fulfillmentGroupItemDao);
    OrderDaoImpl orderDao = new OrderDaoImpl();
    actualLegacyOrderServiceImpl.setOrderDao(orderDao);
    OrderItemServiceImpl orderItemService = new OrderItemServiceImpl();
    actualLegacyOrderServiceImpl.setOrderItemService(orderItemService);
    OrderPaymentDaoImpl paymentInfoDao = new OrderPaymentDaoImpl();
    actualLegacyOrderServiceImpl.setPaymentInfoDao(paymentInfoDao);
    FulfillmentGroupDao actualFulfillmentGroupDao = actualLegacyOrderServiceImpl.getFulfillmentGroupDao();
    FulfillmentGroupItemDao actualFulfillmentGroupItemDao = actualLegacyOrderServiceImpl.getFulfillmentGroupItemDao();
    OrderDao actualOrderDao = actualLegacyOrderServiceImpl.getOrderDao();
    OrderItemService actualOrderItemService = actualLegacyOrderServiceImpl.getOrderItemService();
    OrderPaymentDao actualPaymentInfoDao = actualLegacyOrderServiceImpl.getPaymentInfoDao();

    // Assert
    assertTrue(actualFulfillmentGroupDao instanceof FulfillmentGroupDaoImpl);
    assertTrue(actualFulfillmentGroupItemDao instanceof FulfillmentGroupItemDaoImpl);
    assertTrue(actualOrderDao instanceof OrderDaoImpl);
    assertTrue(actualOrderItemService instanceof OrderItemServiceImpl);
    assertTrue(actualPaymentInfoDao instanceof OrderPaymentDaoImpl);
    assertTrue(actualLegacyOrderServiceImpl.isDeleteEmptyNamedOrders());
    assertTrue(actualLegacyOrderServiceImpl.isMoveNamedOrderItems());
    assertSame(fulfillmentGroupDao, actualFulfillmentGroupDao);
    assertSame(fulfillmentGroupItemDao, actualFulfillmentGroupItemDao);
    assertSame(orderDao, actualOrderDao);
    assertSame(orderItemService, actualOrderItemService);
    assertSame(paymentInfoDao, actualPaymentInfoDao);
  }
}
