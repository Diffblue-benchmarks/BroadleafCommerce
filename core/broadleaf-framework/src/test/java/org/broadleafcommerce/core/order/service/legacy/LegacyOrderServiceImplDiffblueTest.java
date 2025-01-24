package org.broadleafcommerce.core.order.service.legacy;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
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
import org.broadleafcommerce.core.catalog.domain.Category;
import org.broadleafcommerce.core.catalog.domain.CategoryImpl;
import org.broadleafcommerce.core.catalog.domain.Product;
import org.broadleafcommerce.core.catalog.domain.ProductBundleImpl;
import org.broadleafcommerce.core.catalog.domain.Sku;
import org.broadleafcommerce.core.catalog.domain.SkuImpl;
import org.broadleafcommerce.core.offer.dao.OfferDao;
import org.broadleafcommerce.core.offer.service.OfferService;
import org.broadleafcommerce.core.offer.service.OfferServiceExtensionManager;
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
import org.broadleafcommerce.core.order.domain.FulfillmentGroupImpl;
import org.broadleafcommerce.core.order.domain.FulfillmentOptionImpl;
import org.broadleafcommerce.core.order.domain.GiftWrapOrderItemImpl;
import org.broadleafcommerce.core.order.domain.NullOrderFactory;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.Order;
import org.broadleafcommerce.core.order.domain.OrderImpl;
import org.broadleafcommerce.core.order.domain.OrderItem;
import org.broadleafcommerce.core.order.domain.PersonalMessageImpl;
import org.broadleafcommerce.core.order.service.FulfillmentGroupService;
import org.broadleafcommerce.core.order.service.MergeCartService;
import org.broadleafcommerce.core.order.service.OrderItemService;
import org.broadleafcommerce.core.order.service.OrderItemServiceImpl;
import org.broadleafcommerce.core.order.service.OrderMultishipOptionService;
import org.broadleafcommerce.core.order.service.OrderServiceExtensionManager;
import org.broadleafcommerce.core.order.service.call.BundleOrderItemRequest;
import org.broadleafcommerce.core.order.service.call.DiscreteOrderItemRequest;
import org.broadleafcommerce.core.order.service.call.FulfillmentGroupRequest;
import org.broadleafcommerce.core.order.service.call.GiftWrapOrderItemRequest;
import org.broadleafcommerce.core.order.service.call.OrderItemRequestDTO;
import org.broadleafcommerce.core.order.service.exception.ItemNotFoundException;
import org.broadleafcommerce.core.order.service.type.FulfillmentType;
import org.broadleafcommerce.core.order.service.type.OrderItemType;
import org.broadleafcommerce.core.order.service.type.OrderStatus;
import org.broadleafcommerce.core.payment.dao.OrderPaymentDao;
import org.broadleafcommerce.core.payment.dao.OrderPaymentDaoImpl;
import org.broadleafcommerce.core.payment.domain.OrderPayment;
import org.broadleafcommerce.core.payment.domain.OrderPaymentImpl;
import org.broadleafcommerce.core.payment.service.SecureOrderPaymentService;
import org.broadleafcommerce.core.pricing.service.PricingService;
import org.broadleafcommerce.core.pricing.service.exception.PricingException;
import org.broadleafcommerce.core.workflow.Processor;
import org.broadleafcommerce.profile.core.domain.Address;
import org.broadleafcommerce.profile.core.domain.AddressImpl;
import org.broadleafcommerce.profile.core.domain.Customer;
import org.broadleafcommerce.profile.core.domain.CustomerImpl;
import org.broadleafcommerce.profile.core.domain.PhoneImpl;
import org.broadleafcommerce.profile.core.service.CustomerService;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.PlatformTransactionManager;

@ContextConfiguration(classes = {LegacyOrderServiceImpl.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class LegacyOrderServiceImplDiffblueTest {
  @MockBean
  private CategoryDao categoryDao;

  @MockBean
  private CustomerService customerService;

  @MockBean
  private FulfillmentGroupDao fulfillmentGroupDao;

  @MockBean
  private FulfillmentGroupItemDao fulfillmentGroupItemDao;

  @MockBean
  private FulfillmentGroupService fulfillmentGroupService;

  @Autowired
  private LegacyOrderServiceImpl legacyOrderServiceImpl;

  @MockBean
  private MergeCartService mergeCartService;

  @MockBean
  private NullOrderFactory nullOrderFactory;

  @MockBean
  private OfferDao offerDao;

  @MockBean
  private OfferService offerService;

  @MockBean(name = "blOfferServiceExtensionManager")
  private OfferServiceExtensionManager offerServiceExtensionManager;

  @MockBean
  private OrderDao orderDao;

  @MockBean
  private OrderItemDao orderItemDao;

  @MockBean
  private OrderItemService orderItemService;

  @MockBean
  private OrderMultishipOptionService orderMultishipOptionService;

  @MockBean
  private OrderPaymentDao orderPaymentDao;

  @MockBean(name = "blOrderServiceExtensionManager")
  private OrderServiceExtensionManager orderServiceExtensionManager;

  @MockBean
  private PlatformTransactionManager platformTransactionManager;

  @MockBean
  private PricingService pricingService;

  @MockBean
  private Processor processor;

  @MockBean
  private ProductDao productDao;

  @MockBean
  private SecureOrderPaymentService secureOrderPaymentService;

  @MockBean
  private SkuDao skuDao;

  /**
   * Test
   * {@link LegacyOrderServiceImpl#findDefaultFulfillmentGroupForOrder(Order)}.
   * <p>
   * Method under test:
   * {@link LegacyOrderServiceImpl#findDefaultFulfillmentGroupForOrder(Order)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testFindDefaultFulfillmentGroupForOrder() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.order.service.legacy;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.core.order.service.legacy.LegacyOrderServiceImpl.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass979 {
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.CategoryDao categoryDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.profile.core.service.CustomerService customerService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.FulfillmentGroupDao fulfillmentGroupDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.FulfillmentGroupItemDao fulfillmentGroupItemDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.FulfillmentGroupService fulfillmentGroupService;
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.order.service.legacy.LegacyOrderServiceImpl legacyOrderServiceImpl;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.MergeCartService mergeCartService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.domain.NullOrderFactory nullOrderFactory;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.offer.dao.OfferDao offerDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.offer.service.OfferService offerService;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blOfferServiceExtensionManager") org.broadleafcommerce.core.offer.service.OfferServiceExtensionManager offerServiceExtensionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.OrderDao orderDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.OrderItemDao orderItemDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.OrderItemService orderItemService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.OrderMultishipOptionService orderMultishipOptionService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.payment.dao.OrderPaymentDao orderPaymentDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blOrderServiceExtensionManager") org.broadleafcommerce.core.order.service.OrderServiceExtensionManager orderServiceExtensionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.springframework.transaction.PlatformTransactionManager platformTransactionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.pricing.service.PricingService pricingService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.workflow.Processor processor;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.ProductDao productDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.payment.service.SecureOrderPaymentService secureOrderPaymentService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.SkuDao skuDao;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    legacyOrderServiceImpl.findDefaultFulfillmentGroupForOrder(new NullOrderImpl());
  }

  /**
   * Test
   * {@link LegacyOrderServiceImpl#createDiscreteOrderItemRequest(DiscreteOrderItem)}
   * with {@code discreteOrderItem}.
   * <p>
   * Method under test:
   * {@link LegacyOrderServiceImpl#createDiscreteOrderItemRequest(DiscreteOrderItem)}
   */
  @Test
  public void testCreateDiscreteOrderItemRequestWithDiscreteOrderItem() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LegacyOrderServiceImpl legacyOrderServiceImpl = new LegacyOrderServiceImpl();

    // Act
    DiscreteOrderItemRequest actualCreateDiscreteOrderItemRequestResult = legacyOrderServiceImpl
        .createDiscreteOrderItemRequest(new DiscreteOrderItemImpl());

    // Assert
    assertNull(actualCreateDiscreteOrderItemRequestResult.getRetailPriceOverride());
    assertNull(actualCreateDiscreteOrderItemRequestResult.getSalePriceOverride());
    assertNull(actualCreateDiscreteOrderItemRequestResult.getCategory());
    assertNull(actualCreateDiscreteOrderItemRequestResult.getProduct());
    assertNull(actualCreateDiscreteOrderItemRequestResult.getSku());
    assertNull(actualCreateDiscreteOrderItemRequestResult.getBundleOrderItem());
    assertNull(actualCreateDiscreteOrderItemRequestResult.getOrder());
    assertNull(actualCreateDiscreteOrderItemRequestResult.getPersonalMessage());
    assertEquals(0, actualCreateDiscreteOrderItemRequestResult.getQuantity());
    assertTrue(actualCreateDiscreteOrderItemRequestResult.getDiscreteOrderItemFeePrices().isEmpty());
    assertTrue(actualCreateDiscreteOrderItemRequestResult.getAdditionalAttributes().isEmpty());
    assertTrue(actualCreateDiscreteOrderItemRequestResult.getItemAttributes().isEmpty());
  }

  /**
   * Test
   * {@link LegacyOrderServiceImpl#createDiscreteOrderItemRequest(DiscreteOrderItem)}
   * with {@code discreteOrderItem}.
   * <p>
   * Method under test:
   * {@link LegacyOrderServiceImpl#createDiscreteOrderItemRequest(DiscreteOrderItem)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testCreateDiscreteOrderItemRequestWithDiscreteOrderItem2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.order.service.legacy;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.core.order.service.legacy.LegacyOrderServiceImpl.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass974 {
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.CategoryDao categoryDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.profile.core.service.CustomerService customerService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.FulfillmentGroupDao fulfillmentGroupDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.FulfillmentGroupItemDao fulfillmentGroupItemDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.FulfillmentGroupService fulfillmentGroupService;
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.order.service.legacy.LegacyOrderServiceImpl legacyOrderServiceImpl;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.MergeCartService mergeCartService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.domain.NullOrderFactory nullOrderFactory;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.offer.dao.OfferDao offerDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.offer.service.OfferService offerService;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blOfferServiceExtensionManager") org.broadleafcommerce.core.offer.service.OfferServiceExtensionManager offerServiceExtensionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.OrderDao orderDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.OrderItemDao orderItemDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.OrderItemService orderItemService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.OrderMultishipOptionService orderMultishipOptionService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.payment.dao.OrderPaymentDao orderPaymentDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blOrderServiceExtensionManager") org.broadleafcommerce.core.order.service.OrderServiceExtensionManager orderServiceExtensionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.springframework.transaction.PlatformTransactionManager platformTransactionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.pricing.service.PricingService pricingService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.workflow.Processor processor;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.ProductDao productDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.payment.service.SecureOrderPaymentService secureOrderPaymentService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.SkuDao skuDao;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    legacyOrderServiceImpl.createDiscreteOrderItemRequest(new DiscreteOrderItemImpl());
  }

  /**
   * Test
   * {@link LegacyOrderServiceImpl#createDiscreteOrderItemRequest(Order, BundleOrderItem, Sku, Product, Category, Integer, Map)}
   * with {@code order}, {@code bundleOrderItem}, {@code sku}, {@code product},
   * {@code category}, {@code quantity}, {@code itemAttributes}.
   * <p>
   * Method under test:
   * {@link LegacyOrderServiceImpl#createDiscreteOrderItemRequest(Order, BundleOrderItem, Sku, Product, Category, Integer, Map)}
   */
  @Test
  public void testCreateDiscreteOrderItemRequestWithOrderBundleOrderItemSkuProductCategoryQuantityItemAttributes() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LegacyOrderServiceImpl legacyOrderServiceImpl = new LegacyOrderServiceImpl();
    NullOrderImpl order = new NullOrderImpl();
    BundleOrderItemImpl bundleOrderItem = new BundleOrderItemImpl();
    SkuImpl sku = new SkuImpl();
    ProductBundleImpl product = new ProductBundleImpl();
    CategoryImpl category = new CategoryImpl();

    // Act
    DiscreteOrderItemRequest actualCreateDiscreteOrderItemRequestResult = legacyOrderServiceImpl
        .createDiscreteOrderItemRequest(order, bundleOrderItem, sku, product, category, 1, new HashMap<>());

    // Assert
    assertNull(actualCreateDiscreteOrderItemRequestResult.getRetailPriceOverride());
    assertNull(actualCreateDiscreteOrderItemRequestResult.getSalePriceOverride());
    assertNull(actualCreateDiscreteOrderItemRequestResult.getPersonalMessage());
    assertEquals(1, actualCreateDiscreteOrderItemRequestResult.getQuantity());
    assertTrue(actualCreateDiscreteOrderItemRequestResult.getDiscreteOrderItemFeePrices().isEmpty());
    assertTrue(actualCreateDiscreteOrderItemRequestResult.getAdditionalAttributes().isEmpty());
    assertTrue(actualCreateDiscreteOrderItemRequestResult.getItemAttributes().isEmpty());
    assertSame(category, actualCreateDiscreteOrderItemRequestResult.getCategory());
    assertSame(product, actualCreateDiscreteOrderItemRequestResult.getProduct());
    assertSame(sku, actualCreateDiscreteOrderItemRequestResult.getSku());
    assertSame(bundleOrderItem, actualCreateDiscreteOrderItemRequestResult.getBundleOrderItem());
    assertSame(order, actualCreateDiscreteOrderItemRequestResult.getOrder());
  }

  /**
   * Test
   * {@link LegacyOrderServiceImpl#createDiscreteOrderItemRequest(Order, BundleOrderItem, Sku, Product, Category, Integer, Map)}
   * with {@code order}, {@code bundleOrderItem}, {@code sku}, {@code product},
   * {@code category}, {@code quantity}, {@code itemAttributes}.
   * <p>
   * Method under test:
   * {@link LegacyOrderServiceImpl#createDiscreteOrderItemRequest(Order, BundleOrderItem, Sku, Product, Category, Integer, Map)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testCreateDiscreteOrderItemRequestWithOrderBundleOrderItemSkuProductCategoryQuantityItemAttributes2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.order.service.legacy;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.core.order.service.legacy.LegacyOrderServiceImpl.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass975 {
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.CategoryDao categoryDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.profile.core.service.CustomerService customerService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.FulfillmentGroupDao fulfillmentGroupDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.FulfillmentGroupItemDao fulfillmentGroupItemDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.FulfillmentGroupService fulfillmentGroupService;
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.order.service.legacy.LegacyOrderServiceImpl legacyOrderServiceImpl;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.MergeCartService mergeCartService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.domain.NullOrderFactory nullOrderFactory;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.offer.dao.OfferDao offerDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.offer.service.OfferService offerService;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blOfferServiceExtensionManager") org.broadleafcommerce.core.offer.service.OfferServiceExtensionManager offerServiceExtensionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.OrderDao orderDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.OrderItemDao orderItemDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.OrderItemService orderItemService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.OrderMultishipOptionService orderMultishipOptionService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.payment.dao.OrderPaymentDao orderPaymentDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blOrderServiceExtensionManager") org.broadleafcommerce.core.order.service.OrderServiceExtensionManager orderServiceExtensionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.springframework.transaction.PlatformTransactionManager platformTransactionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.pricing.service.PricingService pricingService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.workflow.Processor processor;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.ProductDao productDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.payment.service.SecureOrderPaymentService secureOrderPaymentService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.SkuDao skuDao;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    NullOrderImpl order = new NullOrderImpl();
    BundleOrderItemImpl bundleOrderItem = new BundleOrderItemImpl();
    SkuImpl sku = new SkuImpl();
    ProductBundleImpl product = new ProductBundleImpl();
    CategoryImpl category = new CategoryImpl();

    // Act
    legacyOrderServiceImpl.createDiscreteOrderItemRequest(order, bundleOrderItem, sku, product, category, 1,
        new HashMap<>());
  }

  /**
   * Test
   * {@link LegacyOrderServiceImpl#createDiscreteOrderItemRequest(Long, Long, Long, Long, Integer)}
   * with {@code orderId}, {@code skuId}, {@code productId}, {@code categoryId},
   * {@code quantity}.
   * <p>
   * Method under test:
   * {@link LegacyOrderServiceImpl#createDiscreteOrderItemRequest(Long, Long, Long, Long, Integer)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testCreateDiscreteOrderItemRequestWithOrderIdSkuIdProductIdCategoryIdQuantity() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.order.service.legacy;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.core.order.service.legacy.LegacyOrderServiceImpl.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass973 {
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.CategoryDao categoryDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.profile.core.service.CustomerService customerService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.FulfillmentGroupDao fulfillmentGroupDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.FulfillmentGroupItemDao fulfillmentGroupItemDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.FulfillmentGroupService fulfillmentGroupService;
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.order.service.legacy.LegacyOrderServiceImpl legacyOrderServiceImpl;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.MergeCartService mergeCartService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.domain.NullOrderFactory nullOrderFactory;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.offer.dao.OfferDao offerDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.offer.service.OfferService offerService;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blOfferServiceExtensionManager") org.broadleafcommerce.core.offer.service.OfferServiceExtensionManager offerServiceExtensionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.OrderDao orderDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.OrderItemDao orderItemDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.OrderItemService orderItemService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.OrderMultishipOptionService orderMultishipOptionService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.payment.dao.OrderPaymentDao orderPaymentDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blOrderServiceExtensionManager") org.broadleafcommerce.core.order.service.OrderServiceExtensionManager orderServiceExtensionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.springframework.transaction.PlatformTransactionManager platformTransactionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.pricing.service.PricingService pricingService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.workflow.Processor processor;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.ProductDao productDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.payment.service.SecureOrderPaymentService secureOrderPaymentService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.SkuDao skuDao;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    legacyOrderServiceImpl.createDiscreteOrderItemRequest(1L, 1L, 1L, 1L, 1);
  }

  /**
   * Test
   * {@link LegacyOrderServiceImpl#addGiftWrapItemToOrder(Order, GiftWrapOrderItemRequest)}
   * with {@code order}, {@code itemRequest}.
   * <p>
   * Method under test:
   * {@link LegacyOrderServiceImpl#addGiftWrapItemToOrder(Order, GiftWrapOrderItemRequest)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testAddGiftWrapItemToOrderWithOrderItemRequest() throws PricingException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.order.service.legacy;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.core.order.service.legacy.LegacyOrderServiceImpl.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass953 {
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.CategoryDao categoryDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.profile.core.service.CustomerService customerService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.FulfillmentGroupDao fulfillmentGroupDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.FulfillmentGroupItemDao fulfillmentGroupItemDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.FulfillmentGroupService fulfillmentGroupService;
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.order.service.legacy.LegacyOrderServiceImpl legacyOrderServiceImpl;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.MergeCartService mergeCartService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.domain.NullOrderFactory nullOrderFactory;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.offer.dao.OfferDao offerDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.offer.service.OfferService offerService;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blOfferServiceExtensionManager") org.broadleafcommerce.core.offer.service.OfferServiceExtensionManager offerServiceExtensionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.OrderDao orderDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.OrderItemDao orderItemDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.OrderItemService orderItemService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.OrderMultishipOptionService orderMultishipOptionService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.payment.dao.OrderPaymentDao orderPaymentDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blOrderServiceExtensionManager") org.broadleafcommerce.core.order.service.OrderServiceExtensionManager orderServiceExtensionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.springframework.transaction.PlatformTransactionManager platformTransactionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.pricing.service.PricingService pricingService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.workflow.Processor processor;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.ProductDao productDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.payment.service.SecureOrderPaymentService secureOrderPaymentService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.SkuDao skuDao;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    NullOrderImpl order = new NullOrderImpl();

    // Act
    legacyOrderServiceImpl.addGiftWrapItemToOrder(order, new GiftWrapOrderItemRequest());
  }

  /**
   * Test
   * {@link LegacyOrderServiceImpl#addBundleItemToOrder(Order, BundleOrderItemRequest)}
   * with {@code order}, {@code itemRequest}.
   * <p>
   * Method under test:
   * {@link LegacyOrderServiceImpl#addBundleItemToOrder(Order, BundleOrderItemRequest)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testAddBundleItemToOrderWithOrderItemRequest() throws PricingException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.order.service.legacy;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.core.order.service.legacy.LegacyOrderServiceImpl.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass943 {
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.CategoryDao categoryDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.profile.core.service.CustomerService customerService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.FulfillmentGroupDao fulfillmentGroupDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.FulfillmentGroupItemDao fulfillmentGroupItemDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.FulfillmentGroupService fulfillmentGroupService;
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.order.service.legacy.LegacyOrderServiceImpl legacyOrderServiceImpl;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.MergeCartService mergeCartService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.domain.NullOrderFactory nullOrderFactory;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.offer.dao.OfferDao offerDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.offer.service.OfferService offerService;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blOfferServiceExtensionManager") org.broadleafcommerce.core.offer.service.OfferServiceExtensionManager offerServiceExtensionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.OrderDao orderDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.OrderItemDao orderItemDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.OrderItemService orderItemService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.OrderMultishipOptionService orderMultishipOptionService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.payment.dao.OrderPaymentDao orderPaymentDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blOrderServiceExtensionManager") org.broadleafcommerce.core.order.service.OrderServiceExtensionManager orderServiceExtensionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.springframework.transaction.PlatformTransactionManager platformTransactionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.pricing.service.PricingService pricingService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.workflow.Processor processor;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.ProductDao productDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.payment.service.SecureOrderPaymentService secureOrderPaymentService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.SkuDao skuDao;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
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

    // Act
    legacyOrderServiceImpl.addBundleItemToOrder(order, itemRequest);
  }

  /**
   * Test
   * {@link LegacyOrderServiceImpl#addBundleItemToOrder(Order, BundleOrderItemRequest, boolean)}
   * with {@code order}, {@code itemRequest}, {@code priceOrder}.
   * <p>
   * Method under test:
   * {@link LegacyOrderServiceImpl#addBundleItemToOrder(Order, BundleOrderItemRequest, boolean)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testAddBundleItemToOrderWithOrderItemRequestPriceOrder() throws PricingException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.order.service.legacy;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.core.order.service.legacy.LegacyOrderServiceImpl.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass944 {
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.CategoryDao categoryDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.profile.core.service.CustomerService customerService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.FulfillmentGroupDao fulfillmentGroupDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.FulfillmentGroupItemDao fulfillmentGroupItemDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.FulfillmentGroupService fulfillmentGroupService;
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.order.service.legacy.LegacyOrderServiceImpl legacyOrderServiceImpl;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.MergeCartService mergeCartService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.domain.NullOrderFactory nullOrderFactory;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.offer.dao.OfferDao offerDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.offer.service.OfferService offerService;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blOfferServiceExtensionManager") org.broadleafcommerce.core.offer.service.OfferServiceExtensionManager offerServiceExtensionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.OrderDao orderDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.OrderItemDao orderItemDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.OrderItemService orderItemService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.OrderMultishipOptionService orderMultishipOptionService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.payment.dao.OrderPaymentDao orderPaymentDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blOrderServiceExtensionManager") org.broadleafcommerce.core.order.service.OrderServiceExtensionManager orderServiceExtensionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.springframework.transaction.PlatformTransactionManager platformTransactionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.pricing.service.PricingService pricingService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.workflow.Processor processor;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.ProductDao productDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.payment.service.SecureOrderPaymentService secureOrderPaymentService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.SkuDao skuDao;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
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

    // Act
    legacyOrderServiceImpl.addBundleItemToOrder(order, itemRequest, true);
  }

  /**
   * Test {@link LegacyOrderServiceImpl#removeItemFromOrder(Long, Long)} with
   * {@code orderId}, {@code itemId}.
   * <p>
   * Method under test:
   * {@link LegacyOrderServiceImpl#removeItemFromOrder(Long, Long)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testRemoveItemFromOrderWithOrderIdItemId() throws PricingException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.order.service.legacy;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.core.order.service.legacy.LegacyOrderServiceImpl.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass995 {
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.CategoryDao categoryDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.profile.core.service.CustomerService customerService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.FulfillmentGroupDao fulfillmentGroupDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.FulfillmentGroupItemDao fulfillmentGroupItemDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.FulfillmentGroupService fulfillmentGroupService;
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.order.service.legacy.LegacyOrderServiceImpl legacyOrderServiceImpl;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.MergeCartService mergeCartService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.domain.NullOrderFactory nullOrderFactory;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.offer.dao.OfferDao offerDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.offer.service.OfferService offerService;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blOfferServiceExtensionManager") org.broadleafcommerce.core.offer.service.OfferServiceExtensionManager offerServiceExtensionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.OrderDao orderDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.OrderItemDao orderItemDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.OrderItemService orderItemService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.OrderMultishipOptionService orderMultishipOptionService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.payment.dao.OrderPaymentDao orderPaymentDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blOrderServiceExtensionManager") org.broadleafcommerce.core.order.service.OrderServiceExtensionManager orderServiceExtensionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.springframework.transaction.PlatformTransactionManager platformTransactionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.pricing.service.PricingService pricingService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.workflow.Processor processor;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.ProductDao productDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.payment.service.SecureOrderPaymentService secureOrderPaymentService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.SkuDao skuDao;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    legacyOrderServiceImpl.removeItemFromOrder(1L, 1L);
  }

  /**
   * Test {@link LegacyOrderServiceImpl#removeItemFromOrder(Long, Long, boolean)}
   * with {@code orderId}, {@code itemId}, {@code priceOrder}.
   * <p>
   * Method under test:
   * {@link LegacyOrderServiceImpl#removeItemFromOrder(Long, Long, boolean)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testRemoveItemFromOrderWithOrderIdItemIdPriceOrder() throws PricingException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.order.service.legacy;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.core.order.service.legacy.LegacyOrderServiceImpl.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass996 {
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.CategoryDao categoryDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.profile.core.service.CustomerService customerService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.FulfillmentGroupDao fulfillmentGroupDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.FulfillmentGroupItemDao fulfillmentGroupItemDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.FulfillmentGroupService fulfillmentGroupService;
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.order.service.legacy.LegacyOrderServiceImpl legacyOrderServiceImpl;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.MergeCartService mergeCartService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.domain.NullOrderFactory nullOrderFactory;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.offer.dao.OfferDao offerDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.offer.service.OfferService offerService;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blOfferServiceExtensionManager") org.broadleafcommerce.core.offer.service.OfferServiceExtensionManager offerServiceExtensionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.OrderDao orderDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.OrderItemDao orderItemDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.OrderItemService orderItemService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.OrderMultishipOptionService orderMultishipOptionService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.payment.dao.OrderPaymentDao orderPaymentDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blOrderServiceExtensionManager") org.broadleafcommerce.core.order.service.OrderServiceExtensionManager orderServiceExtensionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.springframework.transaction.PlatformTransactionManager platformTransactionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.pricing.service.PricingService pricingService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.workflow.Processor processor;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.ProductDao productDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.payment.service.SecureOrderPaymentService secureOrderPaymentService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.SkuDao skuDao;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    legacyOrderServiceImpl.removeItemFromOrder(1L, 1L, true);
  }

  /**
   * Test {@link LegacyOrderServiceImpl#removeItemFromOrder(Order, OrderItem)}
   * with {@code order}, {@code item}.
   * <p>
   * Method under test:
   * {@link LegacyOrderServiceImpl#removeItemFromOrder(Order, OrderItem)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testRemoveItemFromOrderWithOrderItem() throws PricingException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.order.service.legacy;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.core.order.service.legacy.LegacyOrderServiceImpl.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass997 {
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.CategoryDao categoryDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.profile.core.service.CustomerService customerService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.FulfillmentGroupDao fulfillmentGroupDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.FulfillmentGroupItemDao fulfillmentGroupItemDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.FulfillmentGroupService fulfillmentGroupService;
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.order.service.legacy.LegacyOrderServiceImpl legacyOrderServiceImpl;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.MergeCartService mergeCartService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.domain.NullOrderFactory nullOrderFactory;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.offer.dao.OfferDao offerDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.offer.service.OfferService offerService;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blOfferServiceExtensionManager") org.broadleafcommerce.core.offer.service.OfferServiceExtensionManager offerServiceExtensionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.OrderDao orderDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.OrderItemDao orderItemDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.OrderItemService orderItemService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.OrderMultishipOptionService orderMultishipOptionService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.payment.dao.OrderPaymentDao orderPaymentDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blOrderServiceExtensionManager") org.broadleafcommerce.core.order.service.OrderServiceExtensionManager orderServiceExtensionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.springframework.transaction.PlatformTransactionManager platformTransactionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.pricing.service.PricingService pricingService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.workflow.Processor processor;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.ProductDao productDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.payment.service.SecureOrderPaymentService secureOrderPaymentService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.SkuDao skuDao;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    NullOrderImpl order = new NullOrderImpl();

    // Act
    legacyOrderServiceImpl.removeItemFromOrder(order, new BundleOrderItemImpl());
  }

  /**
   * Test
   * {@link LegacyOrderServiceImpl#removeItemFromOrder(Order, OrderItem, boolean)}
   * with {@code order}, {@code item}, {@code priceOrder}.
   * <p>
   * Method under test:
   * {@link LegacyOrderServiceImpl#removeItemFromOrder(Order, OrderItem, boolean)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testRemoveItemFromOrderWithOrderItemPriceOrder() throws PricingException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.order.service.legacy;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.core.order.service.legacy.LegacyOrderServiceImpl.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass998 {
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.CategoryDao categoryDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.profile.core.service.CustomerService customerService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.FulfillmentGroupDao fulfillmentGroupDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.FulfillmentGroupItemDao fulfillmentGroupItemDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.FulfillmentGroupService fulfillmentGroupService;
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.order.service.legacy.LegacyOrderServiceImpl legacyOrderServiceImpl;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.MergeCartService mergeCartService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.domain.NullOrderFactory nullOrderFactory;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.offer.dao.OfferDao offerDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.offer.service.OfferService offerService;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blOfferServiceExtensionManager") org.broadleafcommerce.core.offer.service.OfferServiceExtensionManager offerServiceExtensionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.OrderDao orderDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.OrderItemDao orderItemDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.OrderItemService orderItemService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.OrderMultishipOptionService orderMultishipOptionService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.payment.dao.OrderPaymentDao orderPaymentDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blOrderServiceExtensionManager") org.broadleafcommerce.core.order.service.OrderServiceExtensionManager orderServiceExtensionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.springframework.transaction.PlatformTransactionManager platformTransactionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.pricing.service.PricingService pricingService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.workflow.Processor processor;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.ProductDao productDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.payment.service.SecureOrderPaymentService secureOrderPaymentService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.SkuDao skuDao;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    NullOrderImpl order = new NullOrderImpl();

    // Act
    legacyOrderServiceImpl.removeItemFromOrder(order, new BundleOrderItemImpl(), true);
  }

  /**
   * Test {@link LegacyOrderServiceImpl#moveItemToOrder(Order, Order, OrderItem)}
   * with {@code originalOrder}, {@code destinationOrder}, {@code item}.
   * <p>
   * Method under test:
   * {@link LegacyOrderServiceImpl#moveItemToOrder(Order, Order, OrderItem)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testMoveItemToOrderWithOriginalOrderDestinationOrderItem() throws PricingException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.order.service.legacy;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.core.order.service.legacy.LegacyOrderServiceImpl.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass986 {
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.CategoryDao categoryDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.profile.core.service.CustomerService customerService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.FulfillmentGroupDao fulfillmentGroupDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.FulfillmentGroupItemDao fulfillmentGroupItemDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.FulfillmentGroupService fulfillmentGroupService;
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.order.service.legacy.LegacyOrderServiceImpl legacyOrderServiceImpl;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.MergeCartService mergeCartService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.domain.NullOrderFactory nullOrderFactory;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.offer.dao.OfferDao offerDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.offer.service.OfferService offerService;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blOfferServiceExtensionManager") org.broadleafcommerce.core.offer.service.OfferServiceExtensionManager offerServiceExtensionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.OrderDao orderDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.OrderItemDao orderItemDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.OrderItemService orderItemService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.OrderMultishipOptionService orderMultishipOptionService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.payment.dao.OrderPaymentDao orderPaymentDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blOrderServiceExtensionManager") org.broadleafcommerce.core.order.service.OrderServiceExtensionManager orderServiceExtensionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.springframework.transaction.PlatformTransactionManager platformTransactionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.pricing.service.PricingService pricingService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.workflow.Processor processor;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.ProductDao productDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.payment.service.SecureOrderPaymentService secureOrderPaymentService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.SkuDao skuDao;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    NullOrderImpl originalOrder = new NullOrderImpl();
    NullOrderImpl destinationOrder = new NullOrderImpl();

    // Act
    legacyOrderServiceImpl.moveItemToOrder(originalOrder, destinationOrder, new BundleOrderItemImpl());
  }

  /**
   * Test
   * {@link LegacyOrderServiceImpl#moveItemToOrder(Order, Order, OrderItem, boolean)}
   * with {@code originalOrder}, {@code destinationOrder}, {@code item},
   * {@code priceOrder}.
   * <p>
   * Method under test:
   * {@link LegacyOrderServiceImpl#moveItemToOrder(Order, Order, OrderItem, boolean)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testMoveItemToOrderWithOriginalOrderDestinationOrderItemPriceOrder() throws PricingException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.order.service.legacy;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.core.order.service.legacy.LegacyOrderServiceImpl.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass987 {
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.CategoryDao categoryDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.profile.core.service.CustomerService customerService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.FulfillmentGroupDao fulfillmentGroupDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.FulfillmentGroupItemDao fulfillmentGroupItemDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.FulfillmentGroupService fulfillmentGroupService;
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.order.service.legacy.LegacyOrderServiceImpl legacyOrderServiceImpl;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.MergeCartService mergeCartService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.domain.NullOrderFactory nullOrderFactory;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.offer.dao.OfferDao offerDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.offer.service.OfferService offerService;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blOfferServiceExtensionManager") org.broadleafcommerce.core.offer.service.OfferServiceExtensionManager offerServiceExtensionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.OrderDao orderDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.OrderItemDao orderItemDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.OrderItemService orderItemService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.OrderMultishipOptionService orderMultishipOptionService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.payment.dao.OrderPaymentDao orderPaymentDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blOrderServiceExtensionManager") org.broadleafcommerce.core.order.service.OrderServiceExtensionManager orderServiceExtensionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.springframework.transaction.PlatformTransactionManager platformTransactionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.pricing.service.PricingService pricingService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.workflow.Processor processor;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.ProductDao productDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.payment.service.SecureOrderPaymentService secureOrderPaymentService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.SkuDao skuDao;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    NullOrderImpl originalOrder = new NullOrderImpl();
    NullOrderImpl destinationOrder = new NullOrderImpl();

    // Act
    legacyOrderServiceImpl.moveItemToOrder(originalOrder, destinationOrder, new BundleOrderItemImpl(), true);
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addPaymentToOrder(Order, OrderPayment)}
   * with {@code order}, {@code payment}.
   * <p>
   * Method under test:
   * {@link LegacyOrderServiceImpl#addPaymentToOrder(Order, OrderPayment)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testAddPaymentToOrderWithOrderPayment() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.order.service.legacy;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.core.order.service.legacy.LegacyOrderServiceImpl.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass964 {
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.CategoryDao categoryDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.profile.core.service.CustomerService customerService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.FulfillmentGroupDao fulfillmentGroupDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.FulfillmentGroupItemDao fulfillmentGroupItemDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.FulfillmentGroupService fulfillmentGroupService;
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.order.service.legacy.LegacyOrderServiceImpl legacyOrderServiceImpl;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.MergeCartService mergeCartService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.domain.NullOrderFactory nullOrderFactory;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.offer.dao.OfferDao offerDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.offer.service.OfferService offerService;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blOfferServiceExtensionManager") org.broadleafcommerce.core.offer.service.OfferServiceExtensionManager offerServiceExtensionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.OrderDao orderDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.OrderItemDao orderItemDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.OrderItemService orderItemService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.OrderMultishipOptionService orderMultishipOptionService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.payment.dao.OrderPaymentDao orderPaymentDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blOrderServiceExtensionManager") org.broadleafcommerce.core.order.service.OrderServiceExtensionManager orderServiceExtensionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.springframework.transaction.PlatformTransactionManager platformTransactionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.pricing.service.PricingService pricingService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.workflow.Processor processor;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.ProductDao productDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.payment.service.SecureOrderPaymentService secureOrderPaymentService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.SkuDao skuDao;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    NullOrderImpl order = new NullOrderImpl();

    // Act
    legacyOrderServiceImpl.addPaymentToOrder(order, new OrderPaymentImpl());
  }

  /**
   * Test
   * {@link LegacyOrderServiceImpl#addFulfillmentGroupToOrder(FulfillmentGroupRequest)}
   * with {@code fulfillmentGroupRequest}.
   * <p>
   * Method under test:
   * {@link LegacyOrderServiceImpl#addFulfillmentGroupToOrder(FulfillmentGroupRequest)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testAddFulfillmentGroupToOrderWithFulfillmentGroupRequest() throws PricingException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.order.service.legacy;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.core.order.service.legacy.LegacyOrderServiceImpl.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass951 {
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.CategoryDao categoryDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.profile.core.service.CustomerService customerService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.FulfillmentGroupDao fulfillmentGroupDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.FulfillmentGroupItemDao fulfillmentGroupItemDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.FulfillmentGroupService fulfillmentGroupService;
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.order.service.legacy.LegacyOrderServiceImpl legacyOrderServiceImpl;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.MergeCartService mergeCartService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.domain.NullOrderFactory nullOrderFactory;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.offer.dao.OfferDao offerDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.offer.service.OfferService offerService;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blOfferServiceExtensionManager") org.broadleafcommerce.core.offer.service.OfferServiceExtensionManager offerServiceExtensionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.OrderDao orderDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.OrderItemDao orderItemDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.OrderItemService orderItemService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.OrderMultishipOptionService orderMultishipOptionService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.payment.dao.OrderPaymentDao orderPaymentDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blOrderServiceExtensionManager") org.broadleafcommerce.core.order.service.OrderServiceExtensionManager orderServiceExtensionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.springframework.transaction.PlatformTransactionManager platformTransactionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.pricing.service.PricingService pricingService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.workflow.Processor processor;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.ProductDao productDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.payment.service.SecureOrderPaymentService secureOrderPaymentService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.SkuDao skuDao;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
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
    legacyOrderServiceImpl.addFulfillmentGroupToOrder(fulfillmentGroupRequest);
  }

  /**
   * Test
   * {@link LegacyOrderServiceImpl#addFulfillmentGroupToOrder(FulfillmentGroupRequest, boolean)}
   * with {@code fulfillmentGroupRequest}, {@code priceOrder}.
   * <p>
   * Method under test:
   * {@link LegacyOrderServiceImpl#addFulfillmentGroupToOrder(FulfillmentGroupRequest, boolean)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testAddFulfillmentGroupToOrderWithFulfillmentGroupRequestPriceOrder() throws PricingException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.order.service.legacy;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.core.order.service.legacy.LegacyOrderServiceImpl.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass952 {
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.CategoryDao categoryDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.profile.core.service.CustomerService customerService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.FulfillmentGroupDao fulfillmentGroupDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.FulfillmentGroupItemDao fulfillmentGroupItemDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.FulfillmentGroupService fulfillmentGroupService;
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.order.service.legacy.LegacyOrderServiceImpl legacyOrderServiceImpl;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.MergeCartService mergeCartService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.domain.NullOrderFactory nullOrderFactory;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.offer.dao.OfferDao offerDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.offer.service.OfferService offerService;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blOfferServiceExtensionManager") org.broadleafcommerce.core.offer.service.OfferServiceExtensionManager offerServiceExtensionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.OrderDao orderDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.OrderItemDao orderItemDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.OrderItemService orderItemService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.OrderMultishipOptionService orderMultishipOptionService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.payment.dao.OrderPaymentDao orderPaymentDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blOrderServiceExtensionManager") org.broadleafcommerce.core.order.service.OrderServiceExtensionManager orderServiceExtensionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.springframework.transaction.PlatformTransactionManager platformTransactionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.pricing.service.PricingService pricingService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.workflow.Processor processor;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.ProductDao productDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.payment.service.SecureOrderPaymentService secureOrderPaymentService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.SkuDao skuDao;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
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
    legacyOrderServiceImpl.addFulfillmentGroupToOrder(fulfillmentGroupRequest, true);
  }

  /**
   * Test
   * {@link LegacyOrderServiceImpl#addFulfillmentGroupToOrder(Order, FulfillmentGroup)}
   * with {@code order}, {@code fulfillmentGroup}.
   * <p>
   * Method under test:
   * {@link LegacyOrderServiceImpl#addFulfillmentGroupToOrder(Order, FulfillmentGroup)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testAddFulfillmentGroupToOrderWithOrderFulfillmentGroup() throws PricingException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.order.service.legacy;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.core.order.service.legacy.LegacyOrderServiceImpl.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass949 {
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.CategoryDao categoryDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.profile.core.service.CustomerService customerService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.FulfillmentGroupDao fulfillmentGroupDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.FulfillmentGroupItemDao fulfillmentGroupItemDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.FulfillmentGroupService fulfillmentGroupService;
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.order.service.legacy.LegacyOrderServiceImpl legacyOrderServiceImpl;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.MergeCartService mergeCartService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.domain.NullOrderFactory nullOrderFactory;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.offer.dao.OfferDao offerDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.offer.service.OfferService offerService;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blOfferServiceExtensionManager") org.broadleafcommerce.core.offer.service.OfferServiceExtensionManager offerServiceExtensionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.OrderDao orderDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.OrderItemDao orderItemDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.OrderItemService orderItemService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.OrderMultishipOptionService orderMultishipOptionService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.payment.dao.OrderPaymentDao orderPaymentDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blOrderServiceExtensionManager") org.broadleafcommerce.core.order.service.OrderServiceExtensionManager orderServiceExtensionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.springframework.transaction.PlatformTransactionManager platformTransactionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.pricing.service.PricingService pricingService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.workflow.Processor processor;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.ProductDao productDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.payment.service.SecureOrderPaymentService secureOrderPaymentService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.SkuDao skuDao;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    NullOrderImpl order = new NullOrderImpl();

    // Act
    legacyOrderServiceImpl.addFulfillmentGroupToOrder(order, new FulfillmentGroupImpl());
  }

  /**
   * Test
   * {@link LegacyOrderServiceImpl#addFulfillmentGroupToOrder(Order, FulfillmentGroup, boolean)}
   * with {@code order}, {@code fulfillmentGroup}, {@code priceOrder}.
   * <p>
   * Method under test:
   * {@link LegacyOrderServiceImpl#addFulfillmentGroupToOrder(Order, FulfillmentGroup, boolean)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testAddFulfillmentGroupToOrderWithOrderFulfillmentGroupPriceOrder() throws PricingException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.order.service.legacy;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.core.order.service.legacy.LegacyOrderServiceImpl.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass950 {
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.CategoryDao categoryDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.profile.core.service.CustomerService customerService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.FulfillmentGroupDao fulfillmentGroupDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.FulfillmentGroupItemDao fulfillmentGroupItemDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.FulfillmentGroupService fulfillmentGroupService;
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.order.service.legacy.LegacyOrderServiceImpl legacyOrderServiceImpl;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.MergeCartService mergeCartService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.domain.NullOrderFactory nullOrderFactory;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.offer.dao.OfferDao offerDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.offer.service.OfferService offerService;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blOfferServiceExtensionManager") org.broadleafcommerce.core.offer.service.OfferServiceExtensionManager offerServiceExtensionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.OrderDao orderDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.OrderItemDao orderItemDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.OrderItemService orderItemService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.OrderMultishipOptionService orderMultishipOptionService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.payment.dao.OrderPaymentDao orderPaymentDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blOrderServiceExtensionManager") org.broadleafcommerce.core.order.service.OrderServiceExtensionManager orderServiceExtensionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.springframework.transaction.PlatformTransactionManager platformTransactionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.pricing.service.PricingService pricingService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.workflow.Processor processor;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.ProductDao productDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.payment.service.SecureOrderPaymentService secureOrderPaymentService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.SkuDao skuDao;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    NullOrderImpl order = new NullOrderImpl();

    // Act
    legacyOrderServiceImpl.addFulfillmentGroupToOrder(order, new FulfillmentGroupImpl(), true);
  }

  /**
   * Test
   * {@link LegacyOrderServiceImpl#addItemToFulfillmentGroup(OrderItem, FulfillmentGroup)}
   * with {@code item}, {@code fulfillmentGroup}.
   * <p>
   * Method under test:
   * {@link LegacyOrderServiceImpl#addItemToFulfillmentGroup(OrderItem, FulfillmentGroup)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testAddItemToFulfillmentGroupWithItemFulfillmentGroup() throws PricingException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.order.service.legacy;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.core.order.service.legacy.LegacyOrderServiceImpl.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass955 {
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.CategoryDao categoryDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.profile.core.service.CustomerService customerService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.FulfillmentGroupDao fulfillmentGroupDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.FulfillmentGroupItemDao fulfillmentGroupItemDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.FulfillmentGroupService fulfillmentGroupService;
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.order.service.legacy.LegacyOrderServiceImpl legacyOrderServiceImpl;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.MergeCartService mergeCartService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.domain.NullOrderFactory nullOrderFactory;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.offer.dao.OfferDao offerDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.offer.service.OfferService offerService;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blOfferServiceExtensionManager") org.broadleafcommerce.core.offer.service.OfferServiceExtensionManager offerServiceExtensionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.OrderDao orderDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.OrderItemDao orderItemDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.OrderItemService orderItemService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.OrderMultishipOptionService orderMultishipOptionService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.payment.dao.OrderPaymentDao orderPaymentDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blOrderServiceExtensionManager") org.broadleafcommerce.core.order.service.OrderServiceExtensionManager orderServiceExtensionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.springframework.transaction.PlatformTransactionManager platformTransactionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.pricing.service.PricingService pricingService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.workflow.Processor processor;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.ProductDao productDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.payment.service.SecureOrderPaymentService secureOrderPaymentService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.SkuDao skuDao;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    BundleOrderItemImpl item = new BundleOrderItemImpl();

    // Act
    legacyOrderServiceImpl.addItemToFulfillmentGroup(item, new FulfillmentGroupImpl());
  }

  /**
   * Test
   * {@link LegacyOrderServiceImpl#addItemToFulfillmentGroup(OrderItem, FulfillmentGroup, boolean)}
   * with {@code item}, {@code fulfillmentGroup}, {@code priceOrder}.
   * <p>
   * Method under test:
   * {@link LegacyOrderServiceImpl#addItemToFulfillmentGroup(OrderItem, FulfillmentGroup, boolean)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testAddItemToFulfillmentGroupWithItemFulfillmentGroupPriceOrder() throws PricingException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.order.service.legacy;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.core.order.service.legacy.LegacyOrderServiceImpl.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass958 {
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.CategoryDao categoryDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.profile.core.service.CustomerService customerService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.FulfillmentGroupDao fulfillmentGroupDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.FulfillmentGroupItemDao fulfillmentGroupItemDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.FulfillmentGroupService fulfillmentGroupService;
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.order.service.legacy.LegacyOrderServiceImpl legacyOrderServiceImpl;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.MergeCartService mergeCartService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.domain.NullOrderFactory nullOrderFactory;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.offer.dao.OfferDao offerDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.offer.service.OfferService offerService;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blOfferServiceExtensionManager") org.broadleafcommerce.core.offer.service.OfferServiceExtensionManager offerServiceExtensionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.OrderDao orderDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.OrderItemDao orderItemDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.OrderItemService orderItemService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.OrderMultishipOptionService orderMultishipOptionService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.payment.dao.OrderPaymentDao orderPaymentDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blOrderServiceExtensionManager") org.broadleafcommerce.core.order.service.OrderServiceExtensionManager orderServiceExtensionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.springframework.transaction.PlatformTransactionManager platformTransactionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.pricing.service.PricingService pricingService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.workflow.Processor processor;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.ProductDao productDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.payment.service.SecureOrderPaymentService secureOrderPaymentService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.SkuDao skuDao;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    BundleOrderItemImpl item = new BundleOrderItemImpl();

    // Act
    legacyOrderServiceImpl.addItemToFulfillmentGroup(item, new FulfillmentGroupImpl(), true);
  }

  /**
   * Test
   * {@link LegacyOrderServiceImpl#addItemToFulfillmentGroup(OrderItem, FulfillmentGroup, int)}
   * with {@code item}, {@code fulfillmentGroup}, {@code quantity}.
   * <p>
   * Method under test:
   * {@link LegacyOrderServiceImpl#addItemToFulfillmentGroup(OrderItem, FulfillmentGroup, int)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testAddItemToFulfillmentGroupWithItemFulfillmentGroupQuantity() throws PricingException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.order.service.legacy;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.core.order.service.legacy.LegacyOrderServiceImpl.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass956 {
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.CategoryDao categoryDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.profile.core.service.CustomerService customerService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.FulfillmentGroupDao fulfillmentGroupDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.FulfillmentGroupItemDao fulfillmentGroupItemDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.FulfillmentGroupService fulfillmentGroupService;
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.order.service.legacy.LegacyOrderServiceImpl legacyOrderServiceImpl;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.MergeCartService mergeCartService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.domain.NullOrderFactory nullOrderFactory;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.offer.dao.OfferDao offerDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.offer.service.OfferService offerService;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blOfferServiceExtensionManager") org.broadleafcommerce.core.offer.service.OfferServiceExtensionManager offerServiceExtensionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.OrderDao orderDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.OrderItemDao orderItemDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.OrderItemService orderItemService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.OrderMultishipOptionService orderMultishipOptionService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.payment.dao.OrderPaymentDao orderPaymentDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blOrderServiceExtensionManager") org.broadleafcommerce.core.order.service.OrderServiceExtensionManager orderServiceExtensionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.springframework.transaction.PlatformTransactionManager platformTransactionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.pricing.service.PricingService pricingService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.workflow.Processor processor;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.ProductDao productDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.payment.service.SecureOrderPaymentService secureOrderPaymentService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.SkuDao skuDao;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    BundleOrderItemImpl item = new BundleOrderItemImpl();

    // Act
    legacyOrderServiceImpl.addItemToFulfillmentGroup(item, new FulfillmentGroupImpl(), 2);
  }

  /**
   * Test
   * {@link LegacyOrderServiceImpl#addItemToFulfillmentGroup(OrderItem, FulfillmentGroup, int, boolean)}
   * with {@code item}, {@code fulfillmentGroup}, {@code quantity},
   * {@code priceOrder}.
   * <p>
   * Method under test:
   * {@link LegacyOrderServiceImpl#addItemToFulfillmentGroup(OrderItem, FulfillmentGroup, int, boolean)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testAddItemToFulfillmentGroupWithItemFulfillmentGroupQuantityPriceOrder() throws PricingException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.order.service.legacy;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.core.order.service.legacy.LegacyOrderServiceImpl.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass957 {
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.CategoryDao categoryDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.profile.core.service.CustomerService customerService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.FulfillmentGroupDao fulfillmentGroupDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.FulfillmentGroupItemDao fulfillmentGroupItemDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.FulfillmentGroupService fulfillmentGroupService;
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.order.service.legacy.LegacyOrderServiceImpl legacyOrderServiceImpl;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.MergeCartService mergeCartService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.domain.NullOrderFactory nullOrderFactory;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.offer.dao.OfferDao offerDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.offer.service.OfferService offerService;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blOfferServiceExtensionManager") org.broadleafcommerce.core.offer.service.OfferServiceExtensionManager offerServiceExtensionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.OrderDao orderDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.OrderItemDao orderItemDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.OrderItemService orderItemService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.OrderMultishipOptionService orderMultishipOptionService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.payment.dao.OrderPaymentDao orderPaymentDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blOrderServiceExtensionManager") org.broadleafcommerce.core.order.service.OrderServiceExtensionManager orderServiceExtensionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.springframework.transaction.PlatformTransactionManager platformTransactionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.pricing.service.PricingService pricingService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.workflow.Processor processor;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.ProductDao productDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.payment.service.SecureOrderPaymentService secureOrderPaymentService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.SkuDao skuDao;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    BundleOrderItemImpl item = new BundleOrderItemImpl();

    // Act
    legacyOrderServiceImpl.addItemToFulfillmentGroup(item, new FulfillmentGroupImpl(), 2, true);
  }

  /**
   * Test
   * {@link LegacyOrderServiceImpl#addItemToFulfillmentGroup(Order, OrderItem, FulfillmentGroup, int, boolean)}
   * with {@code order}, {@code item}, {@code fulfillmentGroup}, {@code quantity},
   * {@code priceOrder}.
   * <p>
   * Method under test:
   * {@link LegacyOrderServiceImpl#addItemToFulfillmentGroup(Order, OrderItem, FulfillmentGroup, int, boolean)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testAddItemToFulfillmentGroupWithOrderItemFulfillmentGroupQuantityPriceOrder() throws PricingException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.order.service.legacy;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.core.order.service.legacy.LegacyOrderServiceImpl.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass954 {
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.CategoryDao categoryDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.profile.core.service.CustomerService customerService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.FulfillmentGroupDao fulfillmentGroupDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.FulfillmentGroupItemDao fulfillmentGroupItemDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.FulfillmentGroupService fulfillmentGroupService;
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.order.service.legacy.LegacyOrderServiceImpl legacyOrderServiceImpl;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.MergeCartService mergeCartService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.domain.NullOrderFactory nullOrderFactory;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.offer.dao.OfferDao offerDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.offer.service.OfferService offerService;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blOfferServiceExtensionManager") org.broadleafcommerce.core.offer.service.OfferServiceExtensionManager offerServiceExtensionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.OrderDao orderDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.OrderItemDao orderItemDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.OrderItemService orderItemService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.OrderMultishipOptionService orderMultishipOptionService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.payment.dao.OrderPaymentDao orderPaymentDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blOrderServiceExtensionManager") org.broadleafcommerce.core.order.service.OrderServiceExtensionManager orderServiceExtensionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.springframework.transaction.PlatformTransactionManager platformTransactionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.pricing.service.PricingService pricingService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.workflow.Processor processor;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.ProductDao productDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.payment.service.SecureOrderPaymentService secureOrderPaymentService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.SkuDao skuDao;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    NullOrderImpl order = new NullOrderImpl();
    BundleOrderItemImpl item = new BundleOrderItemImpl();

    // Act
    legacyOrderServiceImpl.addItemToFulfillmentGroup(order, item, new FulfillmentGroupImpl(), 2, true);
  }

  /**
   * Test {@link LegacyOrderServiceImpl#updateItemQuantity(Order, OrderItem)} with
   * {@code order}, {@code item}.
   * <p>
   * Method under test:
   * {@link LegacyOrderServiceImpl#updateItemQuantity(Order, OrderItem)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testUpdateItemQuantityWithOrderItem() throws ItemNotFoundException, PricingException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.order.service.legacy;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.core.order.service.legacy.LegacyOrderServiceImpl.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1002 {
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.CategoryDao categoryDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.profile.core.service.CustomerService customerService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.FulfillmentGroupDao fulfillmentGroupDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.FulfillmentGroupItemDao fulfillmentGroupItemDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.FulfillmentGroupService fulfillmentGroupService;
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.order.service.legacy.LegacyOrderServiceImpl legacyOrderServiceImpl;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.MergeCartService mergeCartService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.domain.NullOrderFactory nullOrderFactory;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.offer.dao.OfferDao offerDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.offer.service.OfferService offerService;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blOfferServiceExtensionManager") org.broadleafcommerce.core.offer.service.OfferServiceExtensionManager offerServiceExtensionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.OrderDao orderDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.OrderItemDao orderItemDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.OrderItemService orderItemService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.OrderMultishipOptionService orderMultishipOptionService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.payment.dao.OrderPaymentDao orderPaymentDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blOrderServiceExtensionManager") org.broadleafcommerce.core.order.service.OrderServiceExtensionManager orderServiceExtensionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.springframework.transaction.PlatformTransactionManager platformTransactionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.pricing.service.PricingService pricingService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.workflow.Processor processor;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.ProductDao productDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.payment.service.SecureOrderPaymentService secureOrderPaymentService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.SkuDao skuDao;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    NullOrderImpl order = new NullOrderImpl();

    // Act
    legacyOrderServiceImpl.updateItemQuantity(order, new BundleOrderItemImpl());
  }

  /**
   * Test
   * {@link LegacyOrderServiceImpl#updateItemQuantity(Order, OrderItem, boolean)}
   * with {@code order}, {@code item}, {@code priceOrder}.
   * <p>
   * Method under test:
   * {@link LegacyOrderServiceImpl#updateItemQuantity(Order, OrderItem, boolean)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testUpdateItemQuantityWithOrderItemPriceOrder() throws ItemNotFoundException, PricingException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.order.service.legacy;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.core.order.service.legacy.LegacyOrderServiceImpl.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1003 {
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.CategoryDao categoryDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.profile.core.service.CustomerService customerService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.FulfillmentGroupDao fulfillmentGroupDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.FulfillmentGroupItemDao fulfillmentGroupItemDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.FulfillmentGroupService fulfillmentGroupService;
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.order.service.legacy.LegacyOrderServiceImpl legacyOrderServiceImpl;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.MergeCartService mergeCartService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.domain.NullOrderFactory nullOrderFactory;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.offer.dao.OfferDao offerDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.offer.service.OfferService offerService;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blOfferServiceExtensionManager") org.broadleafcommerce.core.offer.service.OfferServiceExtensionManager offerServiceExtensionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.OrderDao orderDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.OrderItemDao orderItemDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.OrderItemService orderItemService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.OrderMultishipOptionService orderMultishipOptionService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.payment.dao.OrderPaymentDao orderPaymentDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blOrderServiceExtensionManager") org.broadleafcommerce.core.order.service.OrderServiceExtensionManager orderServiceExtensionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.springframework.transaction.PlatformTransactionManager platformTransactionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.pricing.service.PricingService pricingService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.workflow.Processor processor;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.ProductDao productDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.payment.service.SecureOrderPaymentService secureOrderPaymentService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.SkuDao skuDao;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    NullOrderImpl order = new NullOrderImpl();

    // Act
    legacyOrderServiceImpl.updateItemQuantity(order, new BundleOrderItemImpl(), true);
  }

  /**
   * Test
   * {@link LegacyOrderServiceImpl#updateItemQuantity(Order, OrderItem, boolean)}
   * with {@code order}, {@code item}, {@code priceOrder}.
   * <ul>
   *   <li>Then throw {@link ItemNotFoundException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link LegacyOrderServiceImpl#updateItemQuantity(Order, OrderItem, boolean)}
   */
  @Test
  public void testUpdateItemQuantityWithOrderItemPriceOrder_thenThrowItemNotFoundException()
      throws ItemNotFoundException, PricingException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LegacyOrderServiceImpl legacyOrderServiceImpl = new LegacyOrderServiceImpl();

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
    order.setTotalShipping(new Money());
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
   * Test {@link LegacyOrderServiceImpl#updateItemQuantity(Order, OrderItem)} with
   * {@code order}, {@code item}.
   * <ul>
   *   <li>Then throw {@link ItemNotFoundException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link LegacyOrderServiceImpl#updateItemQuantity(Order, OrderItem)}
   */
  @Test
  public void testUpdateItemQuantityWithOrderItem_thenThrowItemNotFoundException()
      throws ItemNotFoundException, PricingException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LegacyOrderServiceImpl legacyOrderServiceImpl = new LegacyOrderServiceImpl();

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
    order.setTotalShipping(new Money());
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
   * Test
   * {@link LegacyOrderServiceImpl#updateItemQuantity(Order, OrderItemRequestDTO)}
   * with {@code order}, {@code orderItemRequestDTO}.
   * <p>
   * Method under test:
   * {@link LegacyOrderServiceImpl#updateItemQuantity(Order, OrderItemRequestDTO)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testUpdateItemQuantityWithOrderOrderItemRequestDTO() throws ItemNotFoundException, PricingException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.order.service.legacy;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.core.order.service.legacy.LegacyOrderServiceImpl.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1004 {
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.CategoryDao categoryDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.profile.core.service.CustomerService customerService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.FulfillmentGroupDao fulfillmentGroupDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.FulfillmentGroupItemDao fulfillmentGroupItemDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.FulfillmentGroupService fulfillmentGroupService;
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.order.service.legacy.LegacyOrderServiceImpl legacyOrderServiceImpl;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.MergeCartService mergeCartService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.domain.NullOrderFactory nullOrderFactory;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.offer.dao.OfferDao offerDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.offer.service.OfferService offerService;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blOfferServiceExtensionManager") org.broadleafcommerce.core.offer.service.OfferServiceExtensionManager offerServiceExtensionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.OrderDao orderDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.OrderItemDao orderItemDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.OrderItemService orderItemService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.OrderMultishipOptionService orderMultishipOptionService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.payment.dao.OrderPaymentDao orderPaymentDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blOrderServiceExtensionManager") org.broadleafcommerce.core.order.service.OrderServiceExtensionManager orderServiceExtensionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.springframework.transaction.PlatformTransactionManager platformTransactionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.pricing.service.PricingService pricingService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.workflow.Processor processor;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.ProductDao productDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.payment.service.SecureOrderPaymentService secureOrderPaymentService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.SkuDao skuDao;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    NullOrderImpl order = new NullOrderImpl();

    // Act
    legacyOrderServiceImpl.updateItemQuantity(order, new OrderItemRequestDTO());
  }

  /**
   * Test
   * {@link LegacyOrderServiceImpl#removeAllFulfillmentGroupsFromOrder(Order)}
   * with {@code order}.
   * <p>
   * Method under test:
   * {@link LegacyOrderServiceImpl#removeAllFulfillmentGroupsFromOrder(Order)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testRemoveAllFulfillmentGroupsFromOrderWithOrder() throws PricingException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.order.service.legacy;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.core.order.service.legacy.LegacyOrderServiceImpl.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass990 {
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.CategoryDao categoryDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.profile.core.service.CustomerService customerService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.FulfillmentGroupDao fulfillmentGroupDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.FulfillmentGroupItemDao fulfillmentGroupItemDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.FulfillmentGroupService fulfillmentGroupService;
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.order.service.legacy.LegacyOrderServiceImpl legacyOrderServiceImpl;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.MergeCartService mergeCartService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.domain.NullOrderFactory nullOrderFactory;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.offer.dao.OfferDao offerDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.offer.service.OfferService offerService;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blOfferServiceExtensionManager") org.broadleafcommerce.core.offer.service.OfferServiceExtensionManager offerServiceExtensionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.OrderDao orderDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.OrderItemDao orderItemDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.OrderItemService orderItemService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.OrderMultishipOptionService orderMultishipOptionService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.payment.dao.OrderPaymentDao orderPaymentDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blOrderServiceExtensionManager") org.broadleafcommerce.core.order.service.OrderServiceExtensionManager orderServiceExtensionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.springframework.transaction.PlatformTransactionManager platformTransactionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.pricing.service.PricingService pricingService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.workflow.Processor processor;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.ProductDao productDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.payment.service.SecureOrderPaymentService secureOrderPaymentService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.SkuDao skuDao;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    legacyOrderServiceImpl.removeAllFulfillmentGroupsFromOrder(new NullOrderImpl());
  }

  /**
   * Test
   * {@link LegacyOrderServiceImpl#removeAllFulfillmentGroupsFromOrder(Order, boolean)}
   * with {@code order}, {@code priceOrder}.
   * <p>
   * Method under test:
   * {@link LegacyOrderServiceImpl#removeAllFulfillmentGroupsFromOrder(Order, boolean)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testRemoveAllFulfillmentGroupsFromOrderWithOrderPriceOrder() throws PricingException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.order.service.legacy;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.core.order.service.legacy.LegacyOrderServiceImpl.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass991 {
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.CategoryDao categoryDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.profile.core.service.CustomerService customerService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.FulfillmentGroupDao fulfillmentGroupDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.FulfillmentGroupItemDao fulfillmentGroupItemDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.FulfillmentGroupService fulfillmentGroupService;
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.order.service.legacy.LegacyOrderServiceImpl legacyOrderServiceImpl;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.MergeCartService mergeCartService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.domain.NullOrderFactory nullOrderFactory;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.offer.dao.OfferDao offerDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.offer.service.OfferService offerService;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blOfferServiceExtensionManager") org.broadleafcommerce.core.offer.service.OfferServiceExtensionManager offerServiceExtensionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.OrderDao orderDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.OrderItemDao orderItemDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.OrderItemService orderItemService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.OrderMultishipOptionService orderMultishipOptionService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.payment.dao.OrderPaymentDao orderPaymentDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blOrderServiceExtensionManager") org.broadleafcommerce.core.order.service.OrderServiceExtensionManager orderServiceExtensionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.springframework.transaction.PlatformTransactionManager platformTransactionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.pricing.service.PricingService pricingService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.workflow.Processor processor;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.ProductDao productDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.payment.service.SecureOrderPaymentService secureOrderPaymentService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.SkuDao skuDao;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    legacyOrderServiceImpl.removeAllFulfillmentGroupsFromOrder(new NullOrderImpl(), true);
  }

  /**
   * Test
   * {@link LegacyOrderServiceImpl#removeFulfillmentGroupFromOrder(Order, FulfillmentGroup)}
   * with {@code order}, {@code fulfillmentGroup}.
   * <p>
   * Method under test:
   * {@link LegacyOrderServiceImpl#removeFulfillmentGroupFromOrder(Order, FulfillmentGroup)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testRemoveFulfillmentGroupFromOrderWithOrderFulfillmentGroup() throws PricingException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.order.service.legacy;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.core.order.service.legacy.LegacyOrderServiceImpl.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass992 {
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.CategoryDao categoryDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.profile.core.service.CustomerService customerService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.FulfillmentGroupDao fulfillmentGroupDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.FulfillmentGroupItemDao fulfillmentGroupItemDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.FulfillmentGroupService fulfillmentGroupService;
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.order.service.legacy.LegacyOrderServiceImpl legacyOrderServiceImpl;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.MergeCartService mergeCartService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.domain.NullOrderFactory nullOrderFactory;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.offer.dao.OfferDao offerDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.offer.service.OfferService offerService;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blOfferServiceExtensionManager") org.broadleafcommerce.core.offer.service.OfferServiceExtensionManager offerServiceExtensionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.OrderDao orderDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.OrderItemDao orderItemDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.OrderItemService orderItemService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.OrderMultishipOptionService orderMultishipOptionService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.payment.dao.OrderPaymentDao orderPaymentDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blOrderServiceExtensionManager") org.broadleafcommerce.core.order.service.OrderServiceExtensionManager orderServiceExtensionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.springframework.transaction.PlatformTransactionManager platformTransactionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.pricing.service.PricingService pricingService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.workflow.Processor processor;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.ProductDao productDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.payment.service.SecureOrderPaymentService secureOrderPaymentService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.SkuDao skuDao;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    NullOrderImpl order = new NullOrderImpl();

    // Act
    legacyOrderServiceImpl.removeFulfillmentGroupFromOrder(order, new FulfillmentGroupImpl());
  }

  /**
   * Test
   * {@link LegacyOrderServiceImpl#removeFulfillmentGroupFromOrder(Order, FulfillmentGroup, boolean)}
   * with {@code order}, {@code fulfillmentGroup}, {@code priceOrder}.
   * <p>
   * Method under test:
   * {@link LegacyOrderServiceImpl#removeFulfillmentGroupFromOrder(Order, FulfillmentGroup, boolean)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testRemoveFulfillmentGroupFromOrderWithOrderFulfillmentGroupPriceOrder() throws PricingException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.order.service.legacy;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.core.order.service.legacy.LegacyOrderServiceImpl.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass993 {
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.CategoryDao categoryDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.profile.core.service.CustomerService customerService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.FulfillmentGroupDao fulfillmentGroupDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.FulfillmentGroupItemDao fulfillmentGroupItemDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.FulfillmentGroupService fulfillmentGroupService;
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.order.service.legacy.LegacyOrderServiceImpl legacyOrderServiceImpl;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.MergeCartService mergeCartService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.domain.NullOrderFactory nullOrderFactory;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.offer.dao.OfferDao offerDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.offer.service.OfferService offerService;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blOfferServiceExtensionManager") org.broadleafcommerce.core.offer.service.OfferServiceExtensionManager offerServiceExtensionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.OrderDao orderDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.OrderItemDao orderItemDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.OrderItemService orderItemService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.OrderMultishipOptionService orderMultishipOptionService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.payment.dao.OrderPaymentDao orderPaymentDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blOrderServiceExtensionManager") org.broadleafcommerce.core.order.service.OrderServiceExtensionManager orderServiceExtensionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.springframework.transaction.PlatformTransactionManager platformTransactionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.pricing.service.PricingService pricingService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.workflow.Processor processor;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.ProductDao productDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.payment.service.SecureOrderPaymentService secureOrderPaymentService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.SkuDao skuDao;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    NullOrderImpl order = new NullOrderImpl();

    // Act
    legacyOrderServiceImpl.removeFulfillmentGroupFromOrder(order, new FulfillmentGroupImpl(), true);
  }

  /**
   * Test
   * {@link LegacyOrderServiceImpl#removeNamedOrderForCustomer(String, Customer)}.
   * <p>
   * Method under test:
   * {@link LegacyOrderServiceImpl#removeNamedOrderForCustomer(String, Customer)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testRemoveNamedOrderForCustomer() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.order.service.legacy;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.core.order.service.legacy.LegacyOrderServiceImpl.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass999 {
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.CategoryDao categoryDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.profile.core.service.CustomerService customerService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.FulfillmentGroupDao fulfillmentGroupDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.FulfillmentGroupItemDao fulfillmentGroupItemDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.FulfillmentGroupService fulfillmentGroupService;
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.order.service.legacy.LegacyOrderServiceImpl legacyOrderServiceImpl;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.MergeCartService mergeCartService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.domain.NullOrderFactory nullOrderFactory;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.offer.dao.OfferDao offerDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.offer.service.OfferService offerService;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blOfferServiceExtensionManager") org.broadleafcommerce.core.offer.service.OfferServiceExtensionManager offerServiceExtensionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.OrderDao orderDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.OrderItemDao orderItemDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.OrderItemService orderItemService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.OrderMultishipOptionService orderMultishipOptionService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.payment.dao.OrderPaymentDao orderPaymentDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blOrderServiceExtensionManager") org.broadleafcommerce.core.order.service.OrderServiceExtensionManager orderServiceExtensionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.springframework.transaction.PlatformTransactionManager platformTransactionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.pricing.service.PricingService pricingService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.workflow.Processor processor;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.ProductDao productDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.payment.service.SecureOrderPaymentService secureOrderPaymentService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.SkuDao skuDao;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    legacyOrderServiceImpl.removeNamedOrderForCustomer("Name", new CustomerImpl());
  }

  /**
   * Test {@link LegacyOrderServiceImpl#readPaymentInfosForOrder(Order)}.
   * <p>
   * Method under test:
   * {@link LegacyOrderServiceImpl#readPaymentInfosForOrder(Order)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testReadPaymentInfosForOrder() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.order.service.legacy;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.core.order.service.legacy.LegacyOrderServiceImpl.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass989 {
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.CategoryDao categoryDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.profile.core.service.CustomerService customerService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.FulfillmentGroupDao fulfillmentGroupDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.FulfillmentGroupItemDao fulfillmentGroupItemDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.FulfillmentGroupService fulfillmentGroupService;
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.order.service.legacy.LegacyOrderServiceImpl legacyOrderServiceImpl;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.MergeCartService mergeCartService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.domain.NullOrderFactory nullOrderFactory;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.offer.dao.OfferDao offerDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.offer.service.OfferService offerService;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blOfferServiceExtensionManager") org.broadleafcommerce.core.offer.service.OfferServiceExtensionManager offerServiceExtensionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.OrderDao orderDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.OrderItemDao orderItemDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.OrderItemService orderItemService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.OrderMultishipOptionService orderMultishipOptionService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.payment.dao.OrderPaymentDao orderPaymentDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blOrderServiceExtensionManager") org.broadleafcommerce.core.order.service.OrderServiceExtensionManager orderServiceExtensionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.springframework.transaction.PlatformTransactionManager platformTransactionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.pricing.service.PricingService pricingService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.workflow.Processor processor;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.ProductDao productDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.payment.service.SecureOrderPaymentService secureOrderPaymentService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.SkuDao skuDao;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    legacyOrderServiceImpl.readPaymentInfosForOrder(new NullOrderImpl());
  }

  /**
   * Test
   * {@link LegacyOrderServiceImpl#itemMatches(DiscreteOrderItem, DiscreteOrderItem)}
   * with {@code item1}, {@code item2}.
   * <p>
   * Method under test:
   * {@link LegacyOrderServiceImpl#itemMatches(DiscreteOrderItem, DiscreteOrderItem)}
   */
  @Test
  public void testItemMatchesWithItem1Item2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LegacyOrderServiceImpl legacyOrderServiceImpl = new LegacyOrderServiceImpl();
    DiscreteOrderItemImpl item1 = new DiscreteOrderItemImpl();

    // Act and Assert
    assertFalse(legacyOrderServiceImpl.itemMatches(item1, new DiscreteOrderItemImpl()));
  }

  /**
   * Test
   * {@link LegacyOrderServiceImpl#itemMatches(DiscreteOrderItem, DiscreteOrderItem)}
   * with {@code item1}, {@code item2}.
   * <p>
   * Method under test:
   * {@link LegacyOrderServiceImpl#itemMatches(DiscreteOrderItem, DiscreteOrderItem)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testItemMatchesWithItem1Item22() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.order.service.legacy;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.core.order.service.legacy.LegacyOrderServiceImpl.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass985 {
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.CategoryDao categoryDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.profile.core.service.CustomerService customerService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.FulfillmentGroupDao fulfillmentGroupDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.FulfillmentGroupItemDao fulfillmentGroupItemDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.FulfillmentGroupService fulfillmentGroupService;
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.order.service.legacy.LegacyOrderServiceImpl legacyOrderServiceImpl;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.MergeCartService mergeCartService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.domain.NullOrderFactory nullOrderFactory;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.offer.dao.OfferDao offerDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.offer.service.OfferService offerService;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blOfferServiceExtensionManager") org.broadleafcommerce.core.offer.service.OfferServiceExtensionManager offerServiceExtensionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.OrderDao orderDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.OrderItemDao orderItemDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.OrderItemService orderItemService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.OrderMultishipOptionService orderMultishipOptionService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.payment.dao.OrderPaymentDao orderPaymentDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blOrderServiceExtensionManager") org.broadleafcommerce.core.order.service.OrderServiceExtensionManager orderServiceExtensionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.springframework.transaction.PlatformTransactionManager platformTransactionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.pricing.service.PricingService pricingService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.workflow.Processor processor;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.ProductDao productDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.payment.service.SecureOrderPaymentService secureOrderPaymentService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.SkuDao skuDao;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    DiscreteOrderItemImpl item1 = new DiscreteOrderItemImpl();

    // Act
    legacyOrderServiceImpl.itemMatches(item1, new DiscreteOrderItemImpl());
  }

  /**
   * Test
   * {@link LegacyOrderServiceImpl#findMatchingDiscreteItem(Order, DiscreteOrderItem)}.
   * <p>
   * Method under test:
   * {@link LegacyOrderServiceImpl#findMatchingDiscreteItem(Order, DiscreteOrderItem)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testFindMatchingDiscreteItem() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.order.service.legacy;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.core.order.service.legacy.LegacyOrderServiceImpl.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass981 {
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.CategoryDao categoryDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.profile.core.service.CustomerService customerService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.FulfillmentGroupDao fulfillmentGroupDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.FulfillmentGroupItemDao fulfillmentGroupItemDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.FulfillmentGroupService fulfillmentGroupService;
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.order.service.legacy.LegacyOrderServiceImpl legacyOrderServiceImpl;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.MergeCartService mergeCartService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.domain.NullOrderFactory nullOrderFactory;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.offer.dao.OfferDao offerDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.offer.service.OfferService offerService;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blOfferServiceExtensionManager") org.broadleafcommerce.core.offer.service.OfferServiceExtensionManager offerServiceExtensionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.OrderDao orderDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.OrderItemDao orderItemDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.OrderItemService orderItemService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.OrderMultishipOptionService orderMultishipOptionService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.payment.dao.OrderPaymentDao orderPaymentDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blOrderServiceExtensionManager") org.broadleafcommerce.core.order.service.OrderServiceExtensionManager orderServiceExtensionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.springframework.transaction.PlatformTransactionManager platformTransactionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.pricing.service.PricingService pricingService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.workflow.Processor processor;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.ProductDao productDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.payment.service.SecureOrderPaymentService secureOrderPaymentService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.SkuDao skuDao;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    NullOrderImpl order = new NullOrderImpl();

    // Act
    legacyOrderServiceImpl.findMatchingDiscreteItem(order, new DiscreteOrderItemImpl());
  }

  /**
   * Test
   * {@link LegacyOrderServiceImpl#findMatchingDiscreteItem(Order, DiscreteOrderItem)}.
   * <ul>
   *   <li>Given {@link Auditable} (default constructor) CreatedBy is one.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link LegacyOrderServiceImpl#findMatchingDiscreteItem(Order, DiscreteOrderItem)}
   */
  @Test
  public void testFindMatchingDiscreteItem_givenAuditableCreatedByIsOne_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LegacyOrderServiceImpl legacyOrderServiceImpl = new LegacyOrderServiceImpl();

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
    order.setTotalShipping(new Money());
    order.setTotalTax(new Money());
    order.setOrderItems(new ArrayList<>());

    // Act and Assert
    assertNull(legacyOrderServiceImpl.findMatchingDiscreteItem(order, new DiscreteOrderItemImpl()));
  }

  /**
   * Test
   * {@link LegacyOrderServiceImpl#bundleItemMatches(BundleOrderItem, BundleOrderItem)}.
   * <p>
   * Method under test:
   * {@link LegacyOrderServiceImpl#bundleItemMatches(BundleOrderItem, BundleOrderItem)}
   */
  @Test
  public void testBundleItemMatches() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LegacyOrderServiceImpl legacyOrderServiceImpl = new LegacyOrderServiceImpl();
    BundleOrderItemImpl item1 = new BundleOrderItemImpl();

    // Act and Assert
    assertTrue(legacyOrderServiceImpl.bundleItemMatches(item1, new BundleOrderItemImpl()));
  }

  /**
   * Test
   * {@link LegacyOrderServiceImpl#bundleItemMatches(BundleOrderItem, BundleOrderItem)}.
   * <p>
   * Method under test:
   * {@link LegacyOrderServiceImpl#bundleItemMatches(BundleOrderItem, BundleOrderItem)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testBundleItemMatches2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.order.service.legacy;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.core.order.service.legacy.LegacyOrderServiceImpl.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass969 {
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.CategoryDao categoryDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.profile.core.service.CustomerService customerService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.FulfillmentGroupDao fulfillmentGroupDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.FulfillmentGroupItemDao fulfillmentGroupItemDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.FulfillmentGroupService fulfillmentGroupService;
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.order.service.legacy.LegacyOrderServiceImpl legacyOrderServiceImpl;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.MergeCartService mergeCartService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.domain.NullOrderFactory nullOrderFactory;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.offer.dao.OfferDao offerDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.offer.service.OfferService offerService;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blOfferServiceExtensionManager") org.broadleafcommerce.core.offer.service.OfferServiceExtensionManager offerServiceExtensionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.OrderDao orderDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.OrderItemDao orderItemDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.OrderItemService orderItemService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.OrderMultishipOptionService orderMultishipOptionService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.payment.dao.OrderPaymentDao orderPaymentDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blOrderServiceExtensionManager") org.broadleafcommerce.core.order.service.OrderServiceExtensionManager orderServiceExtensionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.springframework.transaction.PlatformTransactionManager platformTransactionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.pricing.service.PricingService pricingService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.workflow.Processor processor;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.ProductDao productDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.payment.service.SecureOrderPaymentService secureOrderPaymentService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.SkuDao skuDao;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    BundleOrderItemImpl item1 = new BundleOrderItemImpl();

    // Act
    legacyOrderServiceImpl.bundleItemMatches(item1, new BundleOrderItemImpl());
  }

  /**
   * Test
   * {@link LegacyOrderServiceImpl#findMatchingBundleItem(Order, BundleOrderItem)}.
   * <p>
   * Method under test:
   * {@link LegacyOrderServiceImpl#findMatchingBundleItem(Order, BundleOrderItem)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testFindMatchingBundleItem() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.order.service.legacy;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.core.order.service.legacy.LegacyOrderServiceImpl.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass980 {
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.CategoryDao categoryDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.profile.core.service.CustomerService customerService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.FulfillmentGroupDao fulfillmentGroupDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.FulfillmentGroupItemDao fulfillmentGroupItemDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.FulfillmentGroupService fulfillmentGroupService;
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.order.service.legacy.LegacyOrderServiceImpl legacyOrderServiceImpl;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.MergeCartService mergeCartService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.domain.NullOrderFactory nullOrderFactory;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.offer.dao.OfferDao offerDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.offer.service.OfferService offerService;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blOfferServiceExtensionManager") org.broadleafcommerce.core.offer.service.OfferServiceExtensionManager offerServiceExtensionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.OrderDao orderDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.OrderItemDao orderItemDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.OrderItemService orderItemService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.OrderMultishipOptionService orderMultishipOptionService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.payment.dao.OrderPaymentDao orderPaymentDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blOrderServiceExtensionManager") org.broadleafcommerce.core.order.service.OrderServiceExtensionManager orderServiceExtensionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.springframework.transaction.PlatformTransactionManager platformTransactionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.pricing.service.PricingService pricingService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.workflow.Processor processor;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.ProductDao productDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.payment.service.SecureOrderPaymentService secureOrderPaymentService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.SkuDao skuDao;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    NullOrderImpl order = new NullOrderImpl();

    // Act
    legacyOrderServiceImpl.findMatchingBundleItem(order, new BundleOrderItemImpl());
  }

  /**
   * Test {@link LegacyOrderServiceImpl#findMatchingItem(Order, OrderItem)} with
   * {@code Order}, {@code OrderItem}.
   * <p>
   * Method under test:
   * {@link LegacyOrderServiceImpl#findMatchingItem(Order, OrderItem)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testFindMatchingItemWithOrderOrderItem() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.order.service.legacy;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.core.order.service.legacy.LegacyOrderServiceImpl.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass982 {
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.CategoryDao categoryDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.profile.core.service.CustomerService customerService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.FulfillmentGroupDao fulfillmentGroupDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.FulfillmentGroupItemDao fulfillmentGroupItemDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.FulfillmentGroupService fulfillmentGroupService;
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.order.service.legacy.LegacyOrderServiceImpl legacyOrderServiceImpl;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.MergeCartService mergeCartService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.domain.NullOrderFactory nullOrderFactory;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.offer.dao.OfferDao offerDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.offer.service.OfferService offerService;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blOfferServiceExtensionManager") org.broadleafcommerce.core.offer.service.OfferServiceExtensionManager offerServiceExtensionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.OrderDao orderDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.OrderItemDao orderItemDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.OrderItemService orderItemService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.OrderMultishipOptionService orderMultishipOptionService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.payment.dao.OrderPaymentDao orderPaymentDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blOrderServiceExtensionManager") org.broadleafcommerce.core.order.service.OrderServiceExtensionManager orderServiceExtensionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.springframework.transaction.PlatformTransactionManager platformTransactionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.pricing.service.PricingService pricingService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.workflow.Processor processor;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.ProductDao productDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.payment.service.SecureOrderPaymentService secureOrderPaymentService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.SkuDao skuDao;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    NullOrderImpl order = new NullOrderImpl();

    // Act
    legacyOrderServiceImpl.findMatchingItem(order, new BundleOrderItemImpl());
  }

  /**
   * Test
   * {@link LegacyOrderServiceImpl#addOrderItemToBundle(Order, BundleOrderItem, DiscreteOrderItem, boolean)}.
   * <p>
   * Method under test:
   * {@link LegacyOrderServiceImpl#addOrderItemToBundle(Order, BundleOrderItem, DiscreteOrderItem, boolean)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testAddOrderItemToBundle() throws PricingException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.order.service.legacy;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.core.order.service.legacy.LegacyOrderServiceImpl.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass961 {
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.CategoryDao categoryDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.profile.core.service.CustomerService customerService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.FulfillmentGroupDao fulfillmentGroupDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.FulfillmentGroupItemDao fulfillmentGroupItemDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.FulfillmentGroupService fulfillmentGroupService;
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.order.service.legacy.LegacyOrderServiceImpl legacyOrderServiceImpl;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.MergeCartService mergeCartService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.domain.NullOrderFactory nullOrderFactory;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.offer.dao.OfferDao offerDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.offer.service.OfferService offerService;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blOfferServiceExtensionManager") org.broadleafcommerce.core.offer.service.OfferServiceExtensionManager offerServiceExtensionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.OrderDao orderDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.OrderItemDao orderItemDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.OrderItemService orderItemService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.OrderMultishipOptionService orderMultishipOptionService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.payment.dao.OrderPaymentDao orderPaymentDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blOrderServiceExtensionManager") org.broadleafcommerce.core.order.service.OrderServiceExtensionManager orderServiceExtensionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.springframework.transaction.PlatformTransactionManager platformTransactionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.pricing.service.PricingService pricingService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.workflow.Processor processor;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.ProductDao productDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.payment.service.SecureOrderPaymentService secureOrderPaymentService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.SkuDao skuDao;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    NullOrderImpl order = new NullOrderImpl();
    BundleOrderItemImpl bundle = new BundleOrderItemImpl();

    // Act
    legacyOrderServiceImpl.addOrderItemToBundle(order, bundle, new DiscreteOrderItemImpl(), true);
  }

  /**
   * Test
   * {@link LegacyOrderServiceImpl#removeItemFromBundle(Order, BundleOrderItem, OrderItem, boolean)}.
   * <p>
   * Method under test:
   * {@link LegacyOrderServiceImpl#removeItemFromBundle(Order, BundleOrderItem, OrderItem, boolean)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testRemoveItemFromBundle() throws PricingException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.order.service.legacy;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.core.order.service.legacy.LegacyOrderServiceImpl.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass994 {
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.CategoryDao categoryDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.profile.core.service.CustomerService customerService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.FulfillmentGroupDao fulfillmentGroupDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.FulfillmentGroupItemDao fulfillmentGroupItemDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.FulfillmentGroupService fulfillmentGroupService;
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.order.service.legacy.LegacyOrderServiceImpl legacyOrderServiceImpl;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.MergeCartService mergeCartService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.domain.NullOrderFactory nullOrderFactory;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.offer.dao.OfferDao offerDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.offer.service.OfferService offerService;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blOfferServiceExtensionManager") org.broadleafcommerce.core.offer.service.OfferServiceExtensionManager offerServiceExtensionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.OrderDao orderDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.OrderItemDao orderItemDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.OrderItemService orderItemService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.OrderMultishipOptionService orderMultishipOptionService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.payment.dao.OrderPaymentDao orderPaymentDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blOrderServiceExtensionManager") org.broadleafcommerce.core.order.service.OrderServiceExtensionManager orderServiceExtensionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.springframework.transaction.PlatformTransactionManager platformTransactionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.pricing.service.PricingService pricingService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.workflow.Processor processor;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.ProductDao productDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.payment.service.SecureOrderPaymentService secureOrderPaymentService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.SkuDao skuDao;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    NullOrderImpl order = new NullOrderImpl();
    BundleOrderItemImpl bundle = new BundleOrderItemImpl();

    // Act
    legacyOrderServiceImpl.removeItemFromBundle(order, bundle, new BundleOrderItemImpl(), true);
  }

  /**
   * Test
   * {@link LegacyOrderServiceImpl#addOrUpdateOrderItemAttributes(Order, OrderItem, Map, boolean)}.
   * <p>
   * Method under test:
   * {@link LegacyOrderServiceImpl#addOrUpdateOrderItemAttributes(Order, OrderItem, Map, boolean)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testAddOrUpdateOrderItemAttributes() throws ItemNotFoundException, PricingException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.order.service.legacy;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.core.order.service.legacy.LegacyOrderServiceImpl.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass960 {
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.CategoryDao categoryDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.profile.core.service.CustomerService customerService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.FulfillmentGroupDao fulfillmentGroupDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.FulfillmentGroupItemDao fulfillmentGroupItemDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.FulfillmentGroupService fulfillmentGroupService;
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.order.service.legacy.LegacyOrderServiceImpl legacyOrderServiceImpl;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.MergeCartService mergeCartService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.domain.NullOrderFactory nullOrderFactory;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.offer.dao.OfferDao offerDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.offer.service.OfferService offerService;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blOfferServiceExtensionManager") org.broadleafcommerce.core.offer.service.OfferServiceExtensionManager offerServiceExtensionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.OrderDao orderDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.OrderItemDao orderItemDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.OrderItemService orderItemService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.OrderMultishipOptionService orderMultishipOptionService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.payment.dao.OrderPaymentDao orderPaymentDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blOrderServiceExtensionManager") org.broadleafcommerce.core.order.service.OrderServiceExtensionManager orderServiceExtensionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.springframework.transaction.PlatformTransactionManager platformTransactionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.pricing.service.PricingService pricingService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.workflow.Processor processor;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.ProductDao productDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.payment.service.SecureOrderPaymentService secureOrderPaymentService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.SkuDao skuDao;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    NullOrderImpl order = new NullOrderImpl();
    BundleOrderItemImpl item = new BundleOrderItemImpl();

    // Act
    legacyOrderServiceImpl.addOrUpdateOrderItemAttributes(order, item, new HashMap<>(), true);
  }

  /**
   * Test
   * {@link LegacyOrderServiceImpl#removeOrderItemAttribute(Order, OrderItem, String, boolean)}.
   * <p>
   * Method under test:
   * {@link LegacyOrderServiceImpl#removeOrderItemAttribute(Order, OrderItem, String, boolean)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testRemoveOrderItemAttribute() throws ItemNotFoundException, PricingException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.order.service.legacy;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.core.order.service.legacy.LegacyOrderServiceImpl.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1000 {
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.CategoryDao categoryDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.profile.core.service.CustomerService customerService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.FulfillmentGroupDao fulfillmentGroupDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.FulfillmentGroupItemDao fulfillmentGroupItemDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.FulfillmentGroupService fulfillmentGroupService;
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.order.service.legacy.LegacyOrderServiceImpl legacyOrderServiceImpl;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.MergeCartService mergeCartService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.domain.NullOrderFactory nullOrderFactory;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.offer.dao.OfferDao offerDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.offer.service.OfferService offerService;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blOfferServiceExtensionManager") org.broadleafcommerce.core.offer.service.OfferServiceExtensionManager offerServiceExtensionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.OrderDao orderDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.OrderItemDao orderItemDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.OrderItemService orderItemService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.OrderMultishipOptionService orderMultishipOptionService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.payment.dao.OrderPaymentDao orderPaymentDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blOrderServiceExtensionManager") org.broadleafcommerce.core.order.service.OrderServiceExtensionManager orderServiceExtensionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.springframework.transaction.PlatformTransactionManager platformTransactionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.pricing.service.PricingService pricingService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.workflow.Processor processor;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.ProductDao productDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.payment.service.SecureOrderPaymentService secureOrderPaymentService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.SkuDao skuDao;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    NullOrderImpl order = new NullOrderImpl();

    // Act
    legacyOrderServiceImpl.removeOrderItemAttribute(order, new BundleOrderItemImpl(), "Attribute Name", true);
  }

  /**
   * Test
   * {@link LegacyOrderServiceImpl#removeOrderItemAttribute(Order, OrderItem, String, boolean)}.
   * <ul>
   *   <li>Given {@link Auditable} (default constructor) CreatedBy is one.</li>
   *   <li>Then return {@link OrderImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link LegacyOrderServiceImpl#removeOrderItemAttribute(Order, OrderItem, String, boolean)}
   */
  @Test
  public void testRemoveOrderItemAttribute_givenAuditableCreatedByIsOne_thenReturnOrderImpl()
      throws ItemNotFoundException, PricingException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LegacyOrderServiceImpl legacyOrderServiceImpl = new LegacyOrderServiceImpl();

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
    order.setTotalShipping(new Money());
    order.setTotalTax(new Money());
    order.setOrderItems(orderItems);

    // Act and Assert
    assertSame(order,
        legacyOrderServiceImpl.removeOrderItemAttribute(order, new BundleOrderItemImpl(), "Attribute Name", true));
  }

  /**
   * Test
   * {@link LegacyOrderServiceImpl#createDefaultFulfillmentGroup(Order, Address)}.
   * <p>
   * Method under test:
   * {@link LegacyOrderServiceImpl#createDefaultFulfillmentGroup(Order, Address)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testCreateDefaultFulfillmentGroup() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.order.service.legacy;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.core.order.service.legacy.LegacyOrderServiceImpl.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass972 {
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.CategoryDao categoryDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.profile.core.service.CustomerService customerService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.FulfillmentGroupDao fulfillmentGroupDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.FulfillmentGroupItemDao fulfillmentGroupItemDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.FulfillmentGroupService fulfillmentGroupService;
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.order.service.legacy.LegacyOrderServiceImpl legacyOrderServiceImpl;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.MergeCartService mergeCartService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.domain.NullOrderFactory nullOrderFactory;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.offer.dao.OfferDao offerDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.offer.service.OfferService offerService;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blOfferServiceExtensionManager") org.broadleafcommerce.core.offer.service.OfferServiceExtensionManager offerServiceExtensionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.OrderDao orderDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.OrderItemDao orderItemDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.OrderItemService orderItemService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.OrderMultishipOptionService orderMultishipOptionService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.payment.dao.OrderPaymentDao orderPaymentDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blOrderServiceExtensionManager") org.broadleafcommerce.core.order.service.OrderServiceExtensionManager orderServiceExtensionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.springframework.transaction.PlatformTransactionManager platformTransactionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.pricing.service.PricingService pricingService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.workflow.Processor processor;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.ProductDao productDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.payment.service.SecureOrderPaymentService secureOrderPaymentService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.SkuDao skuDao;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    NullOrderImpl order = new NullOrderImpl();

    // Act
    legacyOrderServiceImpl.createDefaultFulfillmentGroup(order, new AddressImpl());
  }

  /**
   * Test {@link LegacyOrderServiceImpl#findOrderByOrderNumber(String)}.
   * <p>
   * Method under test:
   * {@link LegacyOrderServiceImpl#findOrderByOrderNumber(String)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testFindOrderByOrderNumber() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.order.service.legacy;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.core.order.service.legacy.LegacyOrderServiceImpl.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass984 {
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.CategoryDao categoryDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.profile.core.service.CustomerService customerService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.FulfillmentGroupDao fulfillmentGroupDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.FulfillmentGroupItemDao fulfillmentGroupItemDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.FulfillmentGroupService fulfillmentGroupService;
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.order.service.legacy.LegacyOrderServiceImpl legacyOrderServiceImpl;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.MergeCartService mergeCartService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.domain.NullOrderFactory nullOrderFactory;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.offer.dao.OfferDao offerDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.offer.service.OfferService offerService;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blOfferServiceExtensionManager") org.broadleafcommerce.core.offer.service.OfferServiceExtensionManager offerServiceExtensionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.OrderDao orderDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.OrderItemDao orderItemDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.OrderItemService orderItemService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.OrderMultishipOptionService orderMultishipOptionService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.payment.dao.OrderPaymentDao orderPaymentDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blOrderServiceExtensionManager") org.broadleafcommerce.core.order.service.OrderServiceExtensionManager orderServiceExtensionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.springframework.transaction.PlatformTransactionManager platformTransactionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.pricing.service.PricingService pricingService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.workflow.Processor processor;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.ProductDao productDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.payment.service.SecureOrderPaymentService secureOrderPaymentService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.SkuDao skuDao;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    legacyOrderServiceImpl.findOrderByOrderNumber("42");
  }

  /**
   * Test {@link LegacyOrderServiceImpl#updateOrder(Order, Boolean)}.
   * <p>
   * Method under test: {@link LegacyOrderServiceImpl#updateOrder(Order, Boolean)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testUpdateOrder() throws PricingException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.order.service.legacy;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.core.order.service.legacy.LegacyOrderServiceImpl.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1005 {
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.CategoryDao categoryDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.profile.core.service.CustomerService customerService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.FulfillmentGroupDao fulfillmentGroupDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.FulfillmentGroupItemDao fulfillmentGroupItemDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.FulfillmentGroupService fulfillmentGroupService;
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.order.service.legacy.LegacyOrderServiceImpl legacyOrderServiceImpl;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.MergeCartService mergeCartService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.domain.NullOrderFactory nullOrderFactory;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.offer.dao.OfferDao offerDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.offer.service.OfferService offerService;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blOfferServiceExtensionManager") org.broadleafcommerce.core.offer.service.OfferServiceExtensionManager offerServiceExtensionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.OrderDao orderDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.OrderItemDao orderItemDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.OrderItemService orderItemService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.OrderMultishipOptionService orderMultishipOptionService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.payment.dao.OrderPaymentDao orderPaymentDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blOrderServiceExtensionManager") org.broadleafcommerce.core.order.service.OrderServiceExtensionManager orderServiceExtensionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.springframework.transaction.PlatformTransactionManager platformTransactionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.pricing.service.PricingService pricingService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.workflow.Processor processor;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.ProductDao productDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.payment.service.SecureOrderPaymentService secureOrderPaymentService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.SkuDao skuDao;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    legacyOrderServiceImpl.updateOrder(new NullOrderImpl(), true);
  }

  /**
   * Test {@link LegacyOrderServiceImpl#persistOrder(Order)}.
   * <p>
   * Method under test: {@link LegacyOrderServiceImpl#persistOrder(Order)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testPersistOrder() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.order.service.legacy;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.core.order.service.legacy.LegacyOrderServiceImpl.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass988 {
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.CategoryDao categoryDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.profile.core.service.CustomerService customerService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.FulfillmentGroupDao fulfillmentGroupDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.FulfillmentGroupItemDao fulfillmentGroupItemDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.FulfillmentGroupService fulfillmentGroupService;
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.order.service.legacy.LegacyOrderServiceImpl legacyOrderServiceImpl;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.MergeCartService mergeCartService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.domain.NullOrderFactory nullOrderFactory;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.offer.dao.OfferDao offerDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.offer.service.OfferService offerService;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blOfferServiceExtensionManager") org.broadleafcommerce.core.offer.service.OfferServiceExtensionManager offerServiceExtensionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.OrderDao orderDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.OrderItemDao orderItemDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.OrderItemService orderItemService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.OrderMultishipOptionService orderMultishipOptionService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.payment.dao.OrderPaymentDao orderPaymentDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blOrderServiceExtensionManager") org.broadleafcommerce.core.order.service.OrderServiceExtensionManager orderServiceExtensionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.springframework.transaction.PlatformTransactionManager platformTransactionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.pricing.service.PricingService pricingService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.workflow.Processor processor;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.ProductDao productDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.payment.service.SecureOrderPaymentService secureOrderPaymentService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.SkuDao skuDao;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    legacyOrderServiceImpl.persistOrder(new NullOrderImpl());
  }

  /**
   * Test
   * {@link LegacyOrderServiceImpl#createFulfillmentGroupItemFromOrderItem(OrderItem, FulfillmentGroup, int)}.
   * <p>
   * Method under test:
   * {@link LegacyOrderServiceImpl#createFulfillmentGroupItemFromOrderItem(OrderItem, FulfillmentGroup, int)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testCreateFulfillmentGroupItemFromOrderItem() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.order.service.legacy;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.core.order.service.legacy.LegacyOrderServiceImpl.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass976 {
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.CategoryDao categoryDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.profile.core.service.CustomerService customerService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.FulfillmentGroupDao fulfillmentGroupDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.FulfillmentGroupItemDao fulfillmentGroupItemDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.FulfillmentGroupService fulfillmentGroupService;
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.order.service.legacy.LegacyOrderServiceImpl legacyOrderServiceImpl;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.MergeCartService mergeCartService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.domain.NullOrderFactory nullOrderFactory;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.offer.dao.OfferDao offerDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.offer.service.OfferService offerService;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blOfferServiceExtensionManager") org.broadleafcommerce.core.offer.service.OfferServiceExtensionManager offerServiceExtensionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.OrderDao orderDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.OrderItemDao orderItemDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.OrderItemService orderItemService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.OrderMultishipOptionService orderMultishipOptionService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.payment.dao.OrderPaymentDao orderPaymentDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blOrderServiceExtensionManager") org.broadleafcommerce.core.order.service.OrderServiceExtensionManager orderServiceExtensionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.springframework.transaction.PlatformTransactionManager platformTransactionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.pricing.service.PricingService pricingService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.workflow.Processor processor;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.ProductDao productDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.payment.service.SecureOrderPaymentService secureOrderPaymentService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.SkuDao skuDao;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    BundleOrderItemImpl orderItem = new BundleOrderItemImpl();

    // Act
    legacyOrderServiceImpl.createFulfillmentGroupItemFromOrderItem(orderItem, new FulfillmentGroupImpl(), 1);
  }

  /**
   * Test
   * {@link LegacyOrderServiceImpl#removeOrderItemFromFullfillmentGroup(Order, OrderItem)}.
   * <p>
   * Method under test:
   * {@link LegacyOrderServiceImpl#removeOrderItemFromFullfillmentGroup(Order, OrderItem)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testRemoveOrderItemFromFullfillmentGroup() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.order.service.legacy;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.core.order.service.legacy.LegacyOrderServiceImpl.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1001 {
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.CategoryDao categoryDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.profile.core.service.CustomerService customerService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.FulfillmentGroupDao fulfillmentGroupDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.FulfillmentGroupItemDao fulfillmentGroupItemDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.FulfillmentGroupService fulfillmentGroupService;
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.order.service.legacy.LegacyOrderServiceImpl legacyOrderServiceImpl;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.MergeCartService mergeCartService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.domain.NullOrderFactory nullOrderFactory;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.offer.dao.OfferDao offerDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.offer.service.OfferService offerService;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blOfferServiceExtensionManager") org.broadleafcommerce.core.offer.service.OfferServiceExtensionManager offerServiceExtensionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.OrderDao orderDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.OrderItemDao orderItemDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.OrderItemService orderItemService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.OrderMultishipOptionService orderMultishipOptionService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.payment.dao.OrderPaymentDao orderPaymentDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blOrderServiceExtensionManager") org.broadleafcommerce.core.order.service.OrderServiceExtensionManager orderServiceExtensionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.springframework.transaction.PlatformTransactionManager platformTransactionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.pricing.service.PricingService pricingService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.workflow.Processor processor;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.ProductDao productDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.payment.service.SecureOrderPaymentService secureOrderPaymentService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.SkuDao skuDao;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    NullOrderImpl order = new NullOrderImpl();

    // Act
    legacyOrderServiceImpl.removeOrderItemFromFullfillmentGroup(order, new BundleOrderItemImpl());
  }

  /**
   * Test
   * {@link LegacyOrderServiceImpl#createBundleOrderItemRequest(BundleOrderItem, List)}.
   * <p>
   * Method under test:
   * {@link LegacyOrderServiceImpl#createBundleOrderItemRequest(BundleOrderItem, List)}
   */
  @Test
  public void testCreateBundleOrderItemRequest() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LegacyOrderServiceImpl legacyOrderServiceImpl = new LegacyOrderServiceImpl();
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
   * Test
   * {@link LegacyOrderServiceImpl#createBundleOrderItemRequest(BundleOrderItem, List)}.
   * <p>
   * Method under test:
   * {@link LegacyOrderServiceImpl#createBundleOrderItemRequest(BundleOrderItem, List)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testCreateBundleOrderItemRequest2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.order.service.legacy;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.core.order.service.legacy.LegacyOrderServiceImpl.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass971 {
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.CategoryDao categoryDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.profile.core.service.CustomerService customerService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.FulfillmentGroupDao fulfillmentGroupDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.FulfillmentGroupItemDao fulfillmentGroupItemDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.FulfillmentGroupService fulfillmentGroupService;
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.order.service.legacy.LegacyOrderServiceImpl legacyOrderServiceImpl;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.MergeCartService mergeCartService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.domain.NullOrderFactory nullOrderFactory;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.offer.dao.OfferDao offerDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.offer.service.OfferService offerService;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blOfferServiceExtensionManager") org.broadleafcommerce.core.offer.service.OfferServiceExtensionManager offerServiceExtensionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.OrderDao orderDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.OrderItemDao orderItemDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.OrderItemService orderItemService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.OrderMultishipOptionService orderMultishipOptionService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.payment.dao.OrderPaymentDao orderPaymentDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blOrderServiceExtensionManager") org.broadleafcommerce.core.order.service.OrderServiceExtensionManager orderServiceExtensionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.springframework.transaction.PlatformTransactionManager platformTransactionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.pricing.service.PricingService pricingService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.workflow.Processor processor;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.ProductDao productDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.payment.service.SecureOrderPaymentService secureOrderPaymentService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.SkuDao skuDao;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    BundleOrderItemImpl bundleOrderItem = new BundleOrderItemImpl();

    // Act
    legacyOrderServiceImpl.createBundleOrderItemRequest(bundleOrderItem, new ArrayList<>());
  }

  /**
   * Test {@link LegacyOrderServiceImpl#validateOrder(Long)}.
   * <p>
   * Method under test: {@link LegacyOrderServiceImpl#validateOrder(Long)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testValidateOrder() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.order.service.legacy;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.core.order.service.legacy.LegacyOrderServiceImpl.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1006 {
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.CategoryDao categoryDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.profile.core.service.CustomerService customerService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.FulfillmentGroupDao fulfillmentGroupDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.FulfillmentGroupItemDao fulfillmentGroupItemDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.FulfillmentGroupService fulfillmentGroupService;
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.order.service.legacy.LegacyOrderServiceImpl legacyOrderServiceImpl;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.MergeCartService mergeCartService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.domain.NullOrderFactory nullOrderFactory;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.offer.dao.OfferDao offerDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.offer.service.OfferService offerService;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blOfferServiceExtensionManager") org.broadleafcommerce.core.offer.service.OfferServiceExtensionManager offerServiceExtensionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.OrderDao orderDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.OrderItemDao orderItemDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.OrderItemService orderItemService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.OrderMultishipOptionService orderMultishipOptionService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.payment.dao.OrderPaymentDao orderPaymentDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blOrderServiceExtensionManager") org.broadleafcommerce.core.order.service.OrderServiceExtensionManager orderServiceExtensionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.springframework.transaction.PlatformTransactionManager platformTransactionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.pricing.service.PricingService pricingService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.workflow.Processor processor;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.ProductDao productDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.payment.service.SecureOrderPaymentService secureOrderPaymentService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.SkuDao skuDao;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    legacyOrderServiceImpl.validateOrder(1L);
  }

  /**
   * Test {@link LegacyOrderServiceImpl#validateOrder(Long)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LegacyOrderServiceImpl#validateOrder(Long)}
   */
  @Test
  public void testValidateOrder_whenNull_thenThrowIllegalArgumentException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> (new LegacyOrderServiceImpl()).validateOrder(null));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#validateProduct(Long)}.
   * <p>
   * Method under test: {@link LegacyOrderServiceImpl#validateProduct(Long)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testValidateProduct() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.order.service.legacy;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.core.order.service.legacy.LegacyOrderServiceImpl.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1007 {
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.CategoryDao categoryDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.profile.core.service.CustomerService customerService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.FulfillmentGroupDao fulfillmentGroupDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.FulfillmentGroupItemDao fulfillmentGroupItemDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.FulfillmentGroupService fulfillmentGroupService;
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.order.service.legacy.LegacyOrderServiceImpl legacyOrderServiceImpl;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.MergeCartService mergeCartService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.domain.NullOrderFactory nullOrderFactory;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.offer.dao.OfferDao offerDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.offer.service.OfferService offerService;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blOfferServiceExtensionManager") org.broadleafcommerce.core.offer.service.OfferServiceExtensionManager offerServiceExtensionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.OrderDao orderDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.OrderItemDao orderItemDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.OrderItemService orderItemService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.OrderMultishipOptionService orderMultishipOptionService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.payment.dao.OrderPaymentDao orderPaymentDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blOrderServiceExtensionManager") org.broadleafcommerce.core.order.service.OrderServiceExtensionManager orderServiceExtensionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.springframework.transaction.PlatformTransactionManager platformTransactionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.pricing.service.PricingService pricingService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.workflow.Processor processor;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.ProductDao productDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.payment.service.SecureOrderPaymentService secureOrderPaymentService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.SkuDao skuDao;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    legacyOrderServiceImpl.validateProduct(1L);
  }

  /**
   * Test {@link LegacyOrderServiceImpl#validateProduct(Long)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LegacyOrderServiceImpl#validateProduct(Long)}
   */
  @Test
  public void testValidateProduct_whenNull_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new LegacyOrderServiceImpl()).validateProduct(null));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#determineCategory(Product, Long)}.
   * <p>
   * Method under test:
   * {@link LegacyOrderServiceImpl#determineCategory(Product, Long)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testDetermineCategory() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.order.service.legacy;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.core.order.service.legacy.LegacyOrderServiceImpl.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass977 {
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.CategoryDao categoryDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.profile.core.service.CustomerService customerService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.FulfillmentGroupDao fulfillmentGroupDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.FulfillmentGroupItemDao fulfillmentGroupItemDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.FulfillmentGroupService fulfillmentGroupService;
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.order.service.legacy.LegacyOrderServiceImpl legacyOrderServiceImpl;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.MergeCartService mergeCartService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.domain.NullOrderFactory nullOrderFactory;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.offer.dao.OfferDao offerDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.offer.service.OfferService offerService;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blOfferServiceExtensionManager") org.broadleafcommerce.core.offer.service.OfferServiceExtensionManager offerServiceExtensionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.OrderDao orderDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.OrderItemDao orderItemDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.OrderItemService orderItemService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.OrderMultishipOptionService orderMultishipOptionService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.payment.dao.OrderPaymentDao orderPaymentDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blOrderServiceExtensionManager") org.broadleafcommerce.core.order.service.OrderServiceExtensionManager orderServiceExtensionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.springframework.transaction.PlatformTransactionManager platformTransactionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.pricing.service.PricingService pricingService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.workflow.Processor processor;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.ProductDao productDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.payment.service.SecureOrderPaymentService secureOrderPaymentService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.SkuDao skuDao;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    legacyOrderServiceImpl.determineCategory(new ProductBundleImpl(), 1L);
  }

  /**
   * Test {@link LegacyOrderServiceImpl#determineCategory(Product, Long)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link LegacyOrderServiceImpl#determineCategory(Product, Long)}
   */
  @Test
  public void testDetermineCategory_whenNull_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new LegacyOrderServiceImpl()).determineCategory(null, null));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#determineCategory(Product, Long)}.
   * <ul>
   *   <li>When {@link ProductBundleImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link LegacyOrderServiceImpl#determineCategory(Product, Long)}
   */
  @Test
  public void testDetermineCategory_whenProductBundleImpl_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LegacyOrderServiceImpl legacyOrderServiceImpl = new LegacyOrderServiceImpl();

    // Act and Assert
    assertNull(legacyOrderServiceImpl.determineCategory(new ProductBundleImpl(), null));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#determineSku(Product, Long, Map)}.
   * <p>
   * Method under test:
   * {@link LegacyOrderServiceImpl#determineSku(Product, Long, Map)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testDetermineSku() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.order.service.legacy;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.core.order.service.legacy.LegacyOrderServiceImpl.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass978 {
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.CategoryDao categoryDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.profile.core.service.CustomerService customerService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.FulfillmentGroupDao fulfillmentGroupDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.FulfillmentGroupItemDao fulfillmentGroupItemDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.FulfillmentGroupService fulfillmentGroupService;
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.order.service.legacy.LegacyOrderServiceImpl legacyOrderServiceImpl;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.MergeCartService mergeCartService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.domain.NullOrderFactory nullOrderFactory;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.offer.dao.OfferDao offerDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.offer.service.OfferService offerService;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blOfferServiceExtensionManager") org.broadleafcommerce.core.offer.service.OfferServiceExtensionManager offerServiceExtensionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.OrderDao orderDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.OrderItemDao orderItemDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.OrderItemService orderItemService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.OrderMultishipOptionService orderMultishipOptionService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.payment.dao.OrderPaymentDao orderPaymentDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blOrderServiceExtensionManager") org.broadleafcommerce.core.order.service.OrderServiceExtensionManager orderServiceExtensionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.springframework.transaction.PlatformTransactionManager platformTransactionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.pricing.service.PricingService pricingService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.workflow.Processor processor;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.ProductDao productDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.payment.service.SecureOrderPaymentService secureOrderPaymentService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.SkuDao skuDao;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    ProductBundleImpl product = new ProductBundleImpl();

    // Act
    legacyOrderServiceImpl.determineSku(product, 1L, new HashMap<>());
  }

  /**
   * Test {@link LegacyOrderServiceImpl#findMatchingSku(Product, Map)}.
   * <p>
   * Method under test:
   * {@link LegacyOrderServiceImpl#findMatchingSku(Product, Map)}
   */
  @Test
  public void testFindMatchingSku() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LegacyOrderServiceImpl legacyOrderServiceImpl = new LegacyOrderServiceImpl();
    ProductBundleImpl product = new ProductBundleImpl();

    // Act and Assert
    assertNull(legacyOrderServiceImpl.findMatchingSku(product, new HashMap<>()));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#findMatchingSku(Product, Map)}.
   * <p>
   * Method under test:
   * {@link LegacyOrderServiceImpl#findMatchingSku(Product, Map)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testFindMatchingSku2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.order.service.legacy;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.core.order.service.legacy.LegacyOrderServiceImpl.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass983 {
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.CategoryDao categoryDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.profile.core.service.CustomerService customerService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.FulfillmentGroupDao fulfillmentGroupDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.FulfillmentGroupItemDao fulfillmentGroupItemDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.FulfillmentGroupService fulfillmentGroupService;
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.order.service.legacy.LegacyOrderServiceImpl legacyOrderServiceImpl;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.MergeCartService mergeCartService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.domain.NullOrderFactory nullOrderFactory;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.offer.dao.OfferDao offerDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.offer.service.OfferService offerService;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blOfferServiceExtensionManager") org.broadleafcommerce.core.offer.service.OfferServiceExtensionManager offerServiceExtensionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.OrderDao orderDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.OrderItemDao orderItemDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.OrderItemService orderItemService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.OrderMultishipOptionService orderMultishipOptionService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.payment.dao.OrderPaymentDao orderPaymentDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blOrderServiceExtensionManager") org.broadleafcommerce.core.order.service.OrderServiceExtensionManager orderServiceExtensionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.springframework.transaction.PlatformTransactionManager platformTransactionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.pricing.service.PricingService pricingService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.workflow.Processor processor;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.ProductDao productDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.payment.service.SecureOrderPaymentService secureOrderPaymentService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.SkuDao skuDao;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    ProductBundleImpl product = new ProductBundleImpl();

    // Act
    legacyOrderServiceImpl.findMatchingSku(product, new HashMap<>());
  }

  /**
   * Test {@link LegacyOrderServiceImpl#checkSkuForMatch(Sku, Map)}.
   * <p>
   * Method under test: {@link LegacyOrderServiceImpl#checkSkuForMatch(Sku, Map)}
   */
  @Test
  public void testCheckSkuForMatch() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LegacyOrderServiceImpl legacyOrderServiceImpl = new LegacyOrderServiceImpl();
    SkuImpl sku = new SkuImpl();

    // Act and Assert
    assertFalse(legacyOrderServiceImpl.checkSkuForMatch(sku, new HashMap<>()));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#checkSkuForMatch(Sku, Map)}.
   * <p>
   * Method under test: {@link LegacyOrderServiceImpl#checkSkuForMatch(Sku, Map)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testCheckSkuForMatch2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.order.service.legacy;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.core.order.service.legacy.LegacyOrderServiceImpl.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass970 {
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.CategoryDao categoryDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.profile.core.service.CustomerService customerService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.FulfillmentGroupDao fulfillmentGroupDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.FulfillmentGroupItemDao fulfillmentGroupItemDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.FulfillmentGroupService fulfillmentGroupService;
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.order.service.legacy.LegacyOrderServiceImpl legacyOrderServiceImpl;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.MergeCartService mergeCartService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.domain.NullOrderFactory nullOrderFactory;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.offer.dao.OfferDao offerDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.offer.service.OfferService offerService;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blOfferServiceExtensionManager") org.broadleafcommerce.core.offer.service.OfferServiceExtensionManager offerServiceExtensionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.OrderDao orderDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.OrderItemDao orderItemDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.OrderItemService orderItemService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.OrderMultishipOptionService orderMultishipOptionService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.payment.dao.OrderPaymentDao orderPaymentDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blOrderServiceExtensionManager") org.broadleafcommerce.core.order.service.OrderServiceExtensionManager orderServiceExtensionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.springframework.transaction.PlatformTransactionManager platformTransactionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.pricing.service.PricingService pricingService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.workflow.Processor processor;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.ProductDao productDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.payment.service.SecureOrderPaymentService secureOrderPaymentService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.SkuDao skuDao;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    SkuImpl sku = new SkuImpl();

    // Act
    legacyOrderServiceImpl.checkSkuForMatch(sku, new HashMap<>());
  }

  /**
   * Test
   * {@link LegacyOrderServiceImpl#addItemToOrder(Long, OrderItemRequestDTO, boolean)}.
   * <p>
   * Method under test:
   * {@link LegacyOrderServiceImpl#addItemToOrder(Long, OrderItemRequestDTO, boolean)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testAddItemToOrder() throws PricingException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.order.service.legacy;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.core.order.service.legacy.LegacyOrderServiceImpl.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass959 {
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.CategoryDao categoryDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.profile.core.service.CustomerService customerService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.FulfillmentGroupDao fulfillmentGroupDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.FulfillmentGroupItemDao fulfillmentGroupItemDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.FulfillmentGroupService fulfillmentGroupService;
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.order.service.legacy.LegacyOrderServiceImpl legacyOrderServiceImpl;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.MergeCartService mergeCartService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.domain.NullOrderFactory nullOrderFactory;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.offer.dao.OfferDao offerDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.offer.service.OfferService offerService;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blOfferServiceExtensionManager") org.broadleafcommerce.core.offer.service.OfferServiceExtensionManager offerServiceExtensionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.OrderDao orderDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.OrderItemDao orderItemDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.OrderItemService orderItemService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.OrderMultishipOptionService orderMultishipOptionService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.payment.dao.OrderPaymentDao orderPaymentDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blOrderServiceExtensionManager") org.broadleafcommerce.core.order.service.OrderServiceExtensionManager orderServiceExtensionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.springframework.transaction.PlatformTransactionManager platformTransactionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.pricing.service.PricingService pricingService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.workflow.Processor processor;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.ProductDao productDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.payment.service.SecureOrderPaymentService secureOrderPaymentService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.SkuDao skuDao;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    legacyOrderServiceImpl.addItemToOrder(1L, new OrderItemRequestDTO(), true);
  }

  /**
   * Test
   * {@link LegacyOrderServiceImpl#addItemToOrder(Long, OrderItemRequestDTO, boolean)}.
   * <ul>
   *   <li>Given minus one.</li>
   *   <li>When {@link OrderItemRequestDTO#OrderItemRequestDTO()} Quantity is minus
   * one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link LegacyOrderServiceImpl#addItemToOrder(Long, OrderItemRequestDTO, boolean)}
   */
  @Test
  public void testAddItemToOrder_givenMinusOne_whenOrderItemRequestDTOQuantityIsMinusOne() throws PricingException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LegacyOrderServiceImpl legacyOrderServiceImpl = new LegacyOrderServiceImpl();

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
   * Test
   * {@link LegacyOrderServiceImpl#addItemToOrder(Long, OrderItemRequestDTO, boolean)}.
   * <ul>
   *   <li>Given two.</li>
   *   <li>When {@link OrderItemRequestDTO#OrderItemRequestDTO()} Quantity is
   * two.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link LegacyOrderServiceImpl#addItemToOrder(Long, OrderItemRequestDTO, boolean)}
   */
  @Test
  public void testAddItemToOrder_givenTwo_whenOrderItemRequestDTOQuantityIsTwo() throws PricingException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LegacyOrderServiceImpl legacyOrderServiceImpl = new LegacyOrderServiceImpl();

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
   * Test
   * {@link LegacyOrderServiceImpl#addItemToOrder(Long, OrderItemRequestDTO, boolean)}.
   * <ul>
   *   <li>Given zero.</li>
   *   <li>When {@link OrderItemRequestDTO#OrderItemRequestDTO()} Quantity is
   * zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link LegacyOrderServiceImpl#addItemToOrder(Long, OrderItemRequestDTO, boolean)}
   */
  @Test
  public void testAddItemToOrder_givenZero_whenOrderItemRequestDTOQuantityIsZero() throws PricingException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LegacyOrderServiceImpl legacyOrderServiceImpl = new LegacyOrderServiceImpl();

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
   * Test
   * {@link LegacyOrderServiceImpl#addItemToOrder(Long, OrderItemRequestDTO, boolean)}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link LegacyOrderServiceImpl#addItemToOrder(Long, OrderItemRequestDTO, boolean)}
   */
  @Test
  public void testAddItemToOrder_whenOne_thenReturnNull() throws PricingException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LegacyOrderServiceImpl legacyOrderServiceImpl = new LegacyOrderServiceImpl();

    // Act and Assert
    assertNull(legacyOrderServiceImpl.addItemToOrder(1L, new OrderItemRequestDTO(), true));
  }

  /**
   * Test
   * {@link LegacyOrderServiceImpl#addDiscreteItemToOrder(Order, DiscreteOrderItemRequest)}
   * with {@code order}, {@code itemRequest}.
   * <p>
   * Method under test:
   * {@link LegacyOrderServiceImpl#addDiscreteItemToOrder(Order, DiscreteOrderItemRequest)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testAddDiscreteItemToOrderWithOrderItemRequest() throws PricingException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.order.service.legacy;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.core.order.service.legacy.LegacyOrderServiceImpl.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass945 {
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.CategoryDao categoryDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.profile.core.service.CustomerService customerService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.FulfillmentGroupDao fulfillmentGroupDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.FulfillmentGroupItemDao fulfillmentGroupItemDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.FulfillmentGroupService fulfillmentGroupService;
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.order.service.legacy.LegacyOrderServiceImpl legacyOrderServiceImpl;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.MergeCartService mergeCartService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.domain.NullOrderFactory nullOrderFactory;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.offer.dao.OfferDao offerDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.offer.service.OfferService offerService;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blOfferServiceExtensionManager") org.broadleafcommerce.core.offer.service.OfferServiceExtensionManager offerServiceExtensionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.OrderDao orderDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.OrderItemDao orderItemDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.OrderItemService orderItemService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.OrderMultishipOptionService orderMultishipOptionService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.payment.dao.OrderPaymentDao orderPaymentDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blOrderServiceExtensionManager") org.broadleafcommerce.core.order.service.OrderServiceExtensionManager orderServiceExtensionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.springframework.transaction.PlatformTransactionManager platformTransactionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.pricing.service.PricingService pricingService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.workflow.Processor processor;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.ProductDao productDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.payment.service.SecureOrderPaymentService secureOrderPaymentService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.SkuDao skuDao;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    NullOrderImpl order = new NullOrderImpl();

    // Act
    legacyOrderServiceImpl.addDiscreteItemToOrder(order, new DiscreteOrderItemRequest());
  }

  /**
   * Test
   * {@link LegacyOrderServiceImpl#addDiscreteItemToOrder(Order, DiscreteOrderItemRequest, boolean)}
   * with {@code order}, {@code itemRequest}, {@code priceOrder}.
   * <p>
   * Method under test:
   * {@link LegacyOrderServiceImpl#addDiscreteItemToOrder(Order, DiscreteOrderItemRequest, boolean)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testAddDiscreteItemToOrderWithOrderItemRequestPriceOrder() throws PricingException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.order.service.legacy;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.core.order.service.legacy.LegacyOrderServiceImpl.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass946 {
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.CategoryDao categoryDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.profile.core.service.CustomerService customerService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.FulfillmentGroupDao fulfillmentGroupDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.FulfillmentGroupItemDao fulfillmentGroupItemDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.FulfillmentGroupService fulfillmentGroupService;
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.order.service.legacy.LegacyOrderServiceImpl legacyOrderServiceImpl;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.MergeCartService mergeCartService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.domain.NullOrderFactory nullOrderFactory;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.offer.dao.OfferDao offerDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.offer.service.OfferService offerService;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blOfferServiceExtensionManager") org.broadleafcommerce.core.offer.service.OfferServiceExtensionManager offerServiceExtensionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.OrderDao orderDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.OrderItemDao orderItemDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.OrderItemService orderItemService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.OrderMultishipOptionService orderMultishipOptionService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.payment.dao.OrderPaymentDao orderPaymentDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blOrderServiceExtensionManager") org.broadleafcommerce.core.order.service.OrderServiceExtensionManager orderServiceExtensionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.springframework.transaction.PlatformTransactionManager platformTransactionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.pricing.service.PricingService pricingService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.workflow.Processor processor;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.ProductDao productDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.payment.service.SecureOrderPaymentService secureOrderPaymentService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.SkuDao skuDao;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    NullOrderImpl order = new NullOrderImpl();

    // Act
    legacyOrderServiceImpl.addDiscreteItemToOrder(order, new DiscreteOrderItemRequest(), true);
  }

  /**
   * Test
   * {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer)}
   * with {@code orderId}, {@code skuId}, {@code productId}, {@code categoryId},
   * {@code quantity}.
   * <p>
   * Method under test:
   * {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testAddSkuToOrderWithOrderIdSkuIdProductIdCategoryIdQuantity() throws PricingException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.order.service.legacy;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.core.order.service.legacy.LegacyOrderServiceImpl.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass965 {
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.CategoryDao categoryDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.profile.core.service.CustomerService customerService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.FulfillmentGroupDao fulfillmentGroupDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.FulfillmentGroupItemDao fulfillmentGroupItemDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.FulfillmentGroupService fulfillmentGroupService;
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.order.service.legacy.LegacyOrderServiceImpl legacyOrderServiceImpl;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.MergeCartService mergeCartService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.domain.NullOrderFactory nullOrderFactory;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.offer.dao.OfferDao offerDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.offer.service.OfferService offerService;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blOfferServiceExtensionManager") org.broadleafcommerce.core.offer.service.OfferServiceExtensionManager offerServiceExtensionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.OrderDao orderDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.OrderItemDao orderItemDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.OrderItemService orderItemService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.OrderMultishipOptionService orderMultishipOptionService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.payment.dao.OrderPaymentDao orderPaymentDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blOrderServiceExtensionManager") org.broadleafcommerce.core.order.service.OrderServiceExtensionManager orderServiceExtensionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.springframework.transaction.PlatformTransactionManager platformTransactionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.pricing.service.PricingService pricingService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.workflow.Processor processor;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.ProductDao productDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.payment.service.SecureOrderPaymentService secureOrderPaymentService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.SkuDao skuDao;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    legacyOrderServiceImpl.addSkuToOrder(1L, 1L, 1L, 1L, 2);
  }

  /**
   * Test
   * {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer, Map)}
   * with {@code orderId}, {@code skuId}, {@code productId}, {@code categoryId},
   * {@code quantity}, {@code itemAttributes}.
   * <p>
   * Method under test:
   * {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer, Map)}
   */
  @Test
  public void testAddSkuToOrderWithOrderIdSkuIdProductIdCategoryIdQuantityItemAttributes() throws PricingException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LegacyOrderServiceImpl legacyOrderServiceImpl = new LegacyOrderServiceImpl();

    // Act and Assert
    assertNull(legacyOrderServiceImpl.addSkuToOrder(null, null, null, 1L, null, new HashMap<>()));
  }

  /**
   * Test
   * {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer, Map)}
   * with {@code orderId}, {@code skuId}, {@code productId}, {@code categoryId},
   * {@code quantity}, {@code itemAttributes}.
   * <p>
   * Method under test:
   * {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer, Map)}
   */
  @Test
  public void testAddSkuToOrderWithOrderIdSkuIdProductIdCategoryIdQuantityItemAttributes2() throws PricingException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LegacyOrderServiceImpl legacyOrderServiceImpl = new LegacyOrderServiceImpl();

    // Act and Assert
    assertNull(legacyOrderServiceImpl.addSkuToOrder(1L, null, null, 1L, null, new HashMap<>()));
  }

  /**
   * Test
   * {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer, Map)}
   * with {@code orderId}, {@code skuId}, {@code productId}, {@code categoryId},
   * {@code quantity}, {@code itemAttributes}.
   * <p>
   * Method under test:
   * {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer, Map)}
   */
  @Test
  public void testAddSkuToOrderWithOrderIdSkuIdProductIdCategoryIdQuantityItemAttributes3() throws PricingException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LegacyOrderServiceImpl legacyOrderServiceImpl = new LegacyOrderServiceImpl();

    // Act and Assert
    assertNull(legacyOrderServiceImpl.addSkuToOrder(1L, null, 1L, 1L, null, new HashMap<>()));
  }

  /**
   * Test
   * {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer, Map)}
   * with {@code orderId}, {@code skuId}, {@code productId}, {@code categoryId},
   * {@code quantity}, {@code itemAttributes}.
   * <p>
   * Method under test:
   * {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer, Map)}
   */
  @Test
  public void testAddSkuToOrderWithOrderIdSkuIdProductIdCategoryIdQuantityItemAttributes4() throws PricingException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LegacyOrderServiceImpl legacyOrderServiceImpl = new LegacyOrderServiceImpl();

    // Act and Assert
    assertNull(legacyOrderServiceImpl.addSkuToOrder(1L, 1L, null, 1L, null, new HashMap<>()));
  }

  /**
   * Test
   * {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer, Map)}
   * with {@code orderId}, {@code skuId}, {@code productId}, {@code categoryId},
   * {@code quantity}, {@code itemAttributes}.
   * <p>
   * Method under test:
   * {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer, Map)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testAddSkuToOrderWithOrderIdSkuIdProductIdCategoryIdQuantityItemAttributes5() throws PricingException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.order.service.legacy;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.core.order.service.legacy.LegacyOrderServiceImpl.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass966 {
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.CategoryDao categoryDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.profile.core.service.CustomerService customerService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.FulfillmentGroupDao fulfillmentGroupDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.FulfillmentGroupItemDao fulfillmentGroupItemDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.FulfillmentGroupService fulfillmentGroupService;
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.order.service.legacy.LegacyOrderServiceImpl legacyOrderServiceImpl;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.MergeCartService mergeCartService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.domain.NullOrderFactory nullOrderFactory;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.offer.dao.OfferDao offerDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.offer.service.OfferService offerService;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blOfferServiceExtensionManager") org.broadleafcommerce.core.offer.service.OfferServiceExtensionManager offerServiceExtensionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.OrderDao orderDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.OrderItemDao orderItemDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.OrderItemService orderItemService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.OrderMultishipOptionService orderMultishipOptionService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.payment.dao.OrderPaymentDao orderPaymentDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blOrderServiceExtensionManager") org.broadleafcommerce.core.order.service.OrderServiceExtensionManager orderServiceExtensionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.springframework.transaction.PlatformTransactionManager platformTransactionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.pricing.service.PricingService pricingService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.workflow.Processor processor;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.ProductDao productDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.payment.service.SecureOrderPaymentService secureOrderPaymentService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.SkuDao skuDao;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    legacyOrderServiceImpl.addSkuToOrder(1L, 1L, 1L, 1L, 2, new HashMap<>());
  }

  /**
   * Test
   * {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer, boolean)}
   * with {@code orderId}, {@code skuId}, {@code productId}, {@code categoryId},
   * {@code quantity}, {@code priceOrder}.
   * <p>
   * Method under test:
   * {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer, boolean)}
   */
  @Test
  public void testAddSkuToOrderWithOrderIdSkuIdProductIdCategoryIdQuantityPriceOrder() throws PricingException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new LegacyOrderServiceImpl()).addSkuToOrder(null, null, null, 1L, null, true));
    assertNull((new LegacyOrderServiceImpl()).addSkuToOrder(1L, null, null, 1L, null, true));
    assertNull((new LegacyOrderServiceImpl()).addSkuToOrder(1L, null, 1L, 1L, null, true));
    assertNull((new LegacyOrderServiceImpl()).addSkuToOrder(1L, 1L, null, 1L, null, true));
  }

  /**
   * Test
   * {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer, boolean)}
   * with {@code orderId}, {@code skuId}, {@code productId}, {@code categoryId},
   * {@code quantity}, {@code priceOrder}.
   * <p>
   * Method under test:
   * {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer, boolean)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testAddSkuToOrderWithOrderIdSkuIdProductIdCategoryIdQuantityPriceOrder2() throws PricingException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.order.service.legacy;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.core.order.service.legacy.LegacyOrderServiceImpl.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass967 {
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.CategoryDao categoryDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.profile.core.service.CustomerService customerService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.FulfillmentGroupDao fulfillmentGroupDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.FulfillmentGroupItemDao fulfillmentGroupItemDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.FulfillmentGroupService fulfillmentGroupService;
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.order.service.legacy.LegacyOrderServiceImpl legacyOrderServiceImpl;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.MergeCartService mergeCartService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.domain.NullOrderFactory nullOrderFactory;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.offer.dao.OfferDao offerDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.offer.service.OfferService offerService;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blOfferServiceExtensionManager") org.broadleafcommerce.core.offer.service.OfferServiceExtensionManager offerServiceExtensionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.OrderDao orderDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.OrderItemDao orderItemDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.OrderItemService orderItemService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.OrderMultishipOptionService orderMultishipOptionService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.payment.dao.OrderPaymentDao orderPaymentDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blOrderServiceExtensionManager") org.broadleafcommerce.core.order.service.OrderServiceExtensionManager orderServiceExtensionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.springframework.transaction.PlatformTransactionManager platformTransactionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.pricing.service.PricingService pricingService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.workflow.Processor processor;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.ProductDao productDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.payment.service.SecureOrderPaymentService secureOrderPaymentService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.SkuDao skuDao;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    legacyOrderServiceImpl.addSkuToOrder(1L, 1L, 1L, 1L, 2, true);
  }

  /**
   * Test
   * {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer, boolean, Map)}
   * with {@code orderId}, {@code skuId}, {@code productId}, {@code categoryId},
   * {@code quantity}, {@code priceOrder}, {@code itemAttributes}.
   * <p>
   * Method under test:
   * {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer, boolean, Map)}
   */
  @Test
  public void testAddSkuToOrderWithOrderIdSkuIdProductIdCategoryIdQuantityPriceOrderItemAttributes()
      throws PricingException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LegacyOrderServiceImpl legacyOrderServiceImpl = new LegacyOrderServiceImpl();

    // Act and Assert
    assertNull(legacyOrderServiceImpl.addSkuToOrder(null, null, null, 1L, null, true, new HashMap<>()));
  }

  /**
   * Test
   * {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer, boolean, Map)}
   * with {@code orderId}, {@code skuId}, {@code productId}, {@code categoryId},
   * {@code quantity}, {@code priceOrder}, {@code itemAttributes}.
   * <p>
   * Method under test:
   * {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer, boolean, Map)}
   */
  @Test
  public void testAddSkuToOrderWithOrderIdSkuIdProductIdCategoryIdQuantityPriceOrderItemAttributes2()
      throws PricingException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LegacyOrderServiceImpl legacyOrderServiceImpl = new LegacyOrderServiceImpl();

    // Act and Assert
    assertNull(legacyOrderServiceImpl.addSkuToOrder(1L, null, null, 1L, null, true, new HashMap<>()));
  }

  /**
   * Test
   * {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer, boolean, Map)}
   * with {@code orderId}, {@code skuId}, {@code productId}, {@code categoryId},
   * {@code quantity}, {@code priceOrder}, {@code itemAttributes}.
   * <p>
   * Method under test:
   * {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer, boolean, Map)}
   */
  @Test
  public void testAddSkuToOrderWithOrderIdSkuIdProductIdCategoryIdQuantityPriceOrderItemAttributes3()
      throws PricingException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LegacyOrderServiceImpl legacyOrderServiceImpl = new LegacyOrderServiceImpl();

    // Act and Assert
    assertNull(legacyOrderServiceImpl.addSkuToOrder(1L, null, 1L, 1L, null, true, new HashMap<>()));
  }

  /**
   * Test
   * {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer, boolean, Map)}
   * with {@code orderId}, {@code skuId}, {@code productId}, {@code categoryId},
   * {@code quantity}, {@code priceOrder}, {@code itemAttributes}.
   * <p>
   * Method under test:
   * {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer, boolean, Map)}
   */
  @Test
  public void testAddSkuToOrderWithOrderIdSkuIdProductIdCategoryIdQuantityPriceOrderItemAttributes4()
      throws PricingException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LegacyOrderServiceImpl legacyOrderServiceImpl = new LegacyOrderServiceImpl();

    // Act and Assert
    assertNull(legacyOrderServiceImpl.addSkuToOrder(1L, 1L, null, 1L, null, true, new HashMap<>()));
  }

  /**
   * Test
   * {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer, boolean, Map)}
   * with {@code orderId}, {@code skuId}, {@code productId}, {@code categoryId},
   * {@code quantity}, {@code priceOrder}, {@code itemAttributes}.
   * <p>
   * Method under test:
   * {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer, boolean, Map)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testAddSkuToOrderWithOrderIdSkuIdProductIdCategoryIdQuantityPriceOrderItemAttributes5()
      throws PricingException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.order.service.legacy;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.core.order.service.legacy.LegacyOrderServiceImpl.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass968 {
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.CategoryDao categoryDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.profile.core.service.CustomerService customerService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.FulfillmentGroupDao fulfillmentGroupDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.FulfillmentGroupItemDao fulfillmentGroupItemDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.FulfillmentGroupService fulfillmentGroupService;
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.order.service.legacy.LegacyOrderServiceImpl legacyOrderServiceImpl;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.MergeCartService mergeCartService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.domain.NullOrderFactory nullOrderFactory;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.offer.dao.OfferDao offerDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.offer.service.OfferService offerService;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blOfferServiceExtensionManager") org.broadleafcommerce.core.offer.service.OfferServiceExtensionManager offerServiceExtensionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.OrderDao orderDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.OrderItemDao orderItemDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.OrderItemService orderItemService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.OrderMultishipOptionService orderMultishipOptionService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.payment.dao.OrderPaymentDao orderPaymentDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blOrderServiceExtensionManager") org.broadleafcommerce.core.order.service.OrderServiceExtensionManager orderServiceExtensionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.springframework.transaction.PlatformTransactionManager platformTransactionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.pricing.service.PricingService pricingService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.workflow.Processor processor;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.ProductDao productDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.payment.service.SecureOrderPaymentService secureOrderPaymentService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.SkuDao skuDao;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    legacyOrderServiceImpl.addSkuToOrder(1L, 1L, 1L, 1L, 2, true, new HashMap<>());
  }

  /**
   * Test
   * {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer)}
   * with {@code orderId}, {@code skuId}, {@code productId}, {@code categoryId},
   * {@code quantity}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link LegacyOrderServiceImpl#addSkuToOrder(Long, Long, Long, Long, Integer)}
   */
  @Test
  public void testAddSkuToOrderWithOrderIdSkuIdProductIdCategoryIdQuantity_thenReturnNull() throws PricingException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new LegacyOrderServiceImpl()).addSkuToOrder(null, null, null, 1L, null));
    assertNull((new LegacyOrderServiceImpl()).addSkuToOrder(1L, null, null, 1L, null));
    assertNull((new LegacyOrderServiceImpl()).addSkuToOrder(1L, null, 1L, 1L, null));
    assertNull((new LegacyOrderServiceImpl()).addSkuToOrder(1L, 1L, null, 1L, null));
  }

  /**
   * Test {@link LegacyOrderServiceImpl#addOrderItemToOrder(Order, OrderItem)}
   * with {@code order}, {@code newOrderItem}.
   * <p>
   * Method under test:
   * {@link LegacyOrderServiceImpl#addOrderItemToOrder(Order, OrderItem)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testAddOrderItemToOrderWithOrderNewOrderItem() throws PricingException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.order.service.legacy;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.core.order.service.legacy.LegacyOrderServiceImpl.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass962 {
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.CategoryDao categoryDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.profile.core.service.CustomerService customerService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.FulfillmentGroupDao fulfillmentGroupDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.FulfillmentGroupItemDao fulfillmentGroupItemDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.FulfillmentGroupService fulfillmentGroupService;
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.order.service.legacy.LegacyOrderServiceImpl legacyOrderServiceImpl;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.MergeCartService mergeCartService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.domain.NullOrderFactory nullOrderFactory;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.offer.dao.OfferDao offerDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.offer.service.OfferService offerService;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blOfferServiceExtensionManager") org.broadleafcommerce.core.offer.service.OfferServiceExtensionManager offerServiceExtensionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.OrderDao orderDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.OrderItemDao orderItemDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.OrderItemService orderItemService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.OrderMultishipOptionService orderMultishipOptionService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.payment.dao.OrderPaymentDao orderPaymentDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blOrderServiceExtensionManager") org.broadleafcommerce.core.order.service.OrderServiceExtensionManager orderServiceExtensionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.springframework.transaction.PlatformTransactionManager platformTransactionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.pricing.service.PricingService pricingService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.workflow.Processor processor;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.ProductDao productDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.payment.service.SecureOrderPaymentService secureOrderPaymentService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.SkuDao skuDao;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    NullOrderImpl order = new NullOrderImpl();

    // Act
    legacyOrderServiceImpl.addOrderItemToOrder(order, new BundleOrderItemImpl());
  }

  /**
   * Test
   * {@link LegacyOrderServiceImpl#addOrderItemToOrder(Order, OrderItem, boolean)}
   * with {@code order}, {@code newOrderItem}, {@code priceOrder}.
   * <p>
   * Method under test:
   * {@link LegacyOrderServiceImpl#addOrderItemToOrder(Order, OrderItem, boolean)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testAddOrderItemToOrderWithOrderNewOrderItemPriceOrder() throws PricingException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.order.service.legacy;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.core.order.service.legacy.LegacyOrderServiceImpl.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass963 {
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.CategoryDao categoryDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.profile.core.service.CustomerService customerService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.FulfillmentGroupDao fulfillmentGroupDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.FulfillmentGroupItemDao fulfillmentGroupItemDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.FulfillmentGroupService fulfillmentGroupService;
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.order.service.legacy.LegacyOrderServiceImpl legacyOrderServiceImpl;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.MergeCartService mergeCartService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.domain.NullOrderFactory nullOrderFactory;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.offer.dao.OfferDao offerDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.offer.service.OfferService offerService;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blOfferServiceExtensionManager") org.broadleafcommerce.core.offer.service.OfferServiceExtensionManager offerServiceExtensionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.OrderDao orderDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.OrderItemDao orderItemDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.OrderItemService orderItemService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.OrderMultishipOptionService orderMultishipOptionService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.payment.dao.OrderPaymentDao orderPaymentDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blOrderServiceExtensionManager") org.broadleafcommerce.core.order.service.OrderServiceExtensionManager orderServiceExtensionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.springframework.transaction.PlatformTransactionManager platformTransactionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.pricing.service.PricingService pricingService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.workflow.Processor processor;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.ProductDao productDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.payment.service.SecureOrderPaymentService secureOrderPaymentService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.SkuDao skuDao;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    NullOrderImpl order = new NullOrderImpl();

    // Act
    legacyOrderServiceImpl.addOrderItemToOrder(order, new BundleOrderItemImpl(), true);
  }

  /**
   * Test
   * {@link LegacyOrderServiceImpl#addDynamicPriceDiscreteItemToOrder(Order, DiscreteOrderItemRequest, HashMap)}
   * with {@code order}, {@code itemRequest}, {@code skuPricingConsiderations}.
   * <p>
   * Method under test:
   * {@link LegacyOrderServiceImpl#addDynamicPriceDiscreteItemToOrder(Order, DiscreteOrderItemRequest, HashMap)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testAddDynamicPriceDiscreteItemToOrderWithOrderItemRequestSkuPricingConsiderations()
      throws PricingException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.order.service.legacy;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.core.order.service.legacy.LegacyOrderServiceImpl.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass947 {
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.CategoryDao categoryDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.profile.core.service.CustomerService customerService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.FulfillmentGroupDao fulfillmentGroupDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.FulfillmentGroupItemDao fulfillmentGroupItemDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.FulfillmentGroupService fulfillmentGroupService;
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.order.service.legacy.LegacyOrderServiceImpl legacyOrderServiceImpl;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.MergeCartService mergeCartService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.domain.NullOrderFactory nullOrderFactory;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.offer.dao.OfferDao offerDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.offer.service.OfferService offerService;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blOfferServiceExtensionManager") org.broadleafcommerce.core.offer.service.OfferServiceExtensionManager offerServiceExtensionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.OrderDao orderDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.OrderItemDao orderItemDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.OrderItemService orderItemService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.OrderMultishipOptionService orderMultishipOptionService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.payment.dao.OrderPaymentDao orderPaymentDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blOrderServiceExtensionManager") org.broadleafcommerce.core.order.service.OrderServiceExtensionManager orderServiceExtensionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.springframework.transaction.PlatformTransactionManager platformTransactionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.pricing.service.PricingService pricingService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.workflow.Processor processor;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.ProductDao productDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.payment.service.SecureOrderPaymentService secureOrderPaymentService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.SkuDao skuDao;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    NullOrderImpl order = new NullOrderImpl();
    DiscreteOrderItemRequest itemRequest = new DiscreteOrderItemRequest();

    // Act
    legacyOrderServiceImpl.addDynamicPriceDiscreteItemToOrder(order, itemRequest, new HashMap());
  }

  /**
   * Test
   * {@link LegacyOrderServiceImpl#addDynamicPriceDiscreteItemToOrder(Order, DiscreteOrderItemRequest, HashMap, boolean)}
   * with {@code order}, {@code itemRequest}, {@code skuPricingConsiderations},
   * {@code priceOrder}.
   * <p>
   * Method under test:
   * {@link LegacyOrderServiceImpl#addDynamicPriceDiscreteItemToOrder(Order, DiscreteOrderItemRequest, HashMap, boolean)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testAddDynamicPriceDiscreteItemToOrderWithOrderItemRequestSkuPricingConsiderationsPriceOrder()
      throws PricingException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.order.service.legacy;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.core.order.service.legacy.LegacyOrderServiceImpl.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass948 {
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.CategoryDao categoryDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.profile.core.service.CustomerService customerService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.FulfillmentGroupDao fulfillmentGroupDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.FulfillmentGroupItemDao fulfillmentGroupItemDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.FulfillmentGroupService fulfillmentGroupService;
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.order.service.legacy.LegacyOrderServiceImpl legacyOrderServiceImpl;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.MergeCartService mergeCartService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.domain.NullOrderFactory nullOrderFactory;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.offer.dao.OfferDao offerDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.offer.service.OfferService offerService;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blOfferServiceExtensionManager") org.broadleafcommerce.core.offer.service.OfferServiceExtensionManager offerServiceExtensionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.OrderDao orderDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.OrderItemDao orderItemDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.OrderItemService orderItemService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.OrderMultishipOptionService orderMultishipOptionService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.payment.dao.OrderPaymentDao orderPaymentDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blOrderServiceExtensionManager") org.broadleafcommerce.core.order.service.OrderServiceExtensionManager orderServiceExtensionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.springframework.transaction.PlatformTransactionManager platformTransactionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.pricing.service.PricingService pricingService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.workflow.Processor processor;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.ProductDao productDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.payment.service.SecureOrderPaymentService secureOrderPaymentService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.SkuDao skuDao;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    NullOrderImpl order = new NullOrderImpl();
    DiscreteOrderItemRequest itemRequest = new DiscreteOrderItemRequest();

    // Act
    legacyOrderServiceImpl.addDynamicPriceDiscreteItemToOrder(order, itemRequest, new HashMap(), true);
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link LegacyOrderServiceImpl}
   *   <li>
   * {@link LegacyOrderServiceImpl#setFulfillmentGroupDao(FulfillmentGroupDao)}
   *   <li>
   * {@link LegacyOrderServiceImpl#setFulfillmentGroupItemDao(FulfillmentGroupItemDao)}
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

    // Assert that nothing has changed
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
