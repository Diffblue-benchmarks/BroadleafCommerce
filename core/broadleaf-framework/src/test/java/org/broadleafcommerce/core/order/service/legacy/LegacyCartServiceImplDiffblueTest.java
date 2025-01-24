package org.broadleafcommerce.core.order.service.legacy;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import org.broadleafcommerce.core.catalog.dao.CategoryDao;
import org.broadleafcommerce.core.catalog.dao.ProductDao;
import org.broadleafcommerce.core.catalog.dao.SkuDao;
import org.broadleafcommerce.core.offer.dao.OfferDao;
import org.broadleafcommerce.core.offer.service.OfferService;
import org.broadleafcommerce.core.offer.service.OfferServiceExtensionManager;
import org.broadleafcommerce.core.order.dao.FulfillmentGroupDao;
import org.broadleafcommerce.core.order.dao.FulfillmentGroupItemDao;
import org.broadleafcommerce.core.order.dao.OrderDao;
import org.broadleafcommerce.core.order.dao.OrderItemDao;
import org.broadleafcommerce.core.order.domain.BundleOrderItemImpl;
import org.broadleafcommerce.core.order.domain.NullOrderFactory;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.Order;
import org.broadleafcommerce.core.order.domain.OrderItem;
import org.broadleafcommerce.core.order.service.FulfillmentGroupService;
import org.broadleafcommerce.core.order.service.MergeCartService;
import org.broadleafcommerce.core.order.service.OrderItemService;
import org.broadleafcommerce.core.order.service.OrderMultishipOptionService;
import org.broadleafcommerce.core.order.service.OrderServiceExtensionManager;
import org.broadleafcommerce.core.order.service.call.OrderItemRequestDTO;
import org.broadleafcommerce.core.order.service.exception.AddToCartException;
import org.broadleafcommerce.core.order.service.exception.RemoveFromCartException;
import org.broadleafcommerce.core.order.service.exception.UpdateCartException;
import org.broadleafcommerce.core.payment.dao.OrderPaymentDao;
import org.broadleafcommerce.core.payment.service.SecureOrderPaymentService;
import org.broadleafcommerce.core.pricing.service.PricingService;
import org.broadleafcommerce.core.pricing.service.exception.PricingException;
import org.broadleafcommerce.core.workflow.Processor;
import org.broadleafcommerce.profile.core.domain.Customer;
import org.broadleafcommerce.profile.core.domain.CustomerImpl;
import org.broadleafcommerce.profile.core.service.CustomerService;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.PlatformTransactionManager;

@ContextConfiguration(classes = {LegacyCartServiceImpl.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class LegacyCartServiceImplDiffblueTest {
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
  private LegacyCartServiceImpl legacyCartServiceImpl;

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
   * Test {@link LegacyCartServiceImpl#addAllItemsToCartFromNamedOrder(Order)}
   * with {@code namedOrder}.
   * <p>
   * Method under test:
   * {@link LegacyCartServiceImpl#addAllItemsToCartFromNamedOrder(Order)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testAddAllItemsToCartFromNamedOrderWithNamedOrder() throws PricingException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.order.service.legacy;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.core.order.service.legacy.LegacyCartServiceImpl.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass928 {
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.CategoryDao categoryDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.profile.core.service.CustomerService customerService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.FulfillmentGroupDao fulfillmentGroupDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.FulfillmentGroupItemDao fulfillmentGroupItemDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.FulfillmentGroupService fulfillmentGroupService;
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.order.service.legacy.LegacyCartServiceImpl legacyCartServiceImpl;
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
    legacyCartServiceImpl.addAllItemsToCartFromNamedOrder(new NullOrderImpl());
  }

  /**
   * Test
   * {@link LegacyCartServiceImpl#addAllItemsToCartFromNamedOrder(Order, boolean)}
   * with {@code namedOrder}, {@code priceOrder}.
   * <p>
   * Method under test:
   * {@link LegacyCartServiceImpl#addAllItemsToCartFromNamedOrder(Order, boolean)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testAddAllItemsToCartFromNamedOrderWithNamedOrderPriceOrder() throws PricingException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.order.service.legacy;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.core.order.service.legacy.LegacyCartServiceImpl.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass929 {
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.CategoryDao categoryDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.profile.core.service.CustomerService customerService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.FulfillmentGroupDao fulfillmentGroupDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.FulfillmentGroupItemDao fulfillmentGroupItemDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.FulfillmentGroupService fulfillmentGroupService;
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.order.service.legacy.LegacyCartServiceImpl legacyCartServiceImpl;
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
    legacyCartServiceImpl.addAllItemsToCartFromNamedOrder(new NullOrderImpl(), true);
  }

  /**
   * Test
   * {@link LegacyCartServiceImpl#moveItemToCartFromNamedOrder(Long, String, Long, Integer)}
   * with {@code customerId}, {@code orderName}, {@code orderItemId},
   * {@code quantity}.
   * <p>
   * Method under test:
   * {@link LegacyCartServiceImpl#moveItemToCartFromNamedOrder(Long, String, Long, Integer)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testMoveItemToCartFromNamedOrderWithCustomerIdOrderNameOrderItemIdQuantity() throws PricingException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.order.service.legacy;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.core.order.service.legacy.LegacyCartServiceImpl.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass935 {
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.CategoryDao categoryDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.profile.core.service.CustomerService customerService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.FulfillmentGroupDao fulfillmentGroupDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.FulfillmentGroupItemDao fulfillmentGroupItemDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.FulfillmentGroupService fulfillmentGroupService;
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.order.service.legacy.LegacyCartServiceImpl legacyCartServiceImpl;
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
    legacyCartServiceImpl.moveItemToCartFromNamedOrder(1L, "Order Name", 1L, 1);
  }

  /**
   * Test
   * {@link LegacyCartServiceImpl#moveItemToCartFromNamedOrder(Long, String, Long, Integer, boolean)}
   * with {@code customerId}, {@code orderName}, {@code orderItemId},
   * {@code quantity}, {@code priceOrder}.
   * <p>
   * Method under test:
   * {@link LegacyCartServiceImpl#moveItemToCartFromNamedOrder(Long, String, Long, Integer, boolean)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testMoveItemToCartFromNamedOrderWithCustomerIdOrderNameOrderItemIdQuantityPriceOrder()
      throws PricingException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.order.service.legacy;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.core.order.service.legacy.LegacyCartServiceImpl.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass936 {
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.CategoryDao categoryDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.profile.core.service.CustomerService customerService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.FulfillmentGroupDao fulfillmentGroupDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.FulfillmentGroupItemDao fulfillmentGroupItemDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.FulfillmentGroupService fulfillmentGroupService;
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.order.service.legacy.LegacyCartServiceImpl legacyCartServiceImpl;
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
    legacyCartServiceImpl.moveItemToCartFromNamedOrder(1L, "Order Name", 1L, 1, true);
  }

  /**
   * Test
   * {@link LegacyCartServiceImpl#moveItemToCartFromNamedOrder(Order, OrderItem)}
   * with {@code namedOrder}, {@code orderItem}.
   * <p>
   * Method under test:
   * {@link LegacyCartServiceImpl#moveItemToCartFromNamedOrder(Order, OrderItem)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testMoveItemToCartFromNamedOrderWithNamedOrderOrderItem() throws PricingException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.order.service.legacy;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.core.order.service.legacy.LegacyCartServiceImpl.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass937 {
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.CategoryDao categoryDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.profile.core.service.CustomerService customerService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.FulfillmentGroupDao fulfillmentGroupDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.FulfillmentGroupItemDao fulfillmentGroupItemDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.FulfillmentGroupService fulfillmentGroupService;
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.order.service.legacy.LegacyCartServiceImpl legacyCartServiceImpl;
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
    NullOrderImpl namedOrder = new NullOrderImpl();

    // Act
    legacyCartServiceImpl.moveItemToCartFromNamedOrder(namedOrder, new BundleOrderItemImpl());
  }

  /**
   * Test
   * {@link LegacyCartServiceImpl#moveItemToCartFromNamedOrder(Order, OrderItem, boolean)}
   * with {@code namedOrder}, {@code orderItem}, {@code priceOrder}.
   * <p>
   * Method under test:
   * {@link LegacyCartServiceImpl#moveItemToCartFromNamedOrder(Order, OrderItem, boolean)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testMoveItemToCartFromNamedOrderWithNamedOrderOrderItemPriceOrder() throws PricingException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.order.service.legacy;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.core.order.service.legacy.LegacyCartServiceImpl.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass938 {
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.CategoryDao categoryDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.profile.core.service.CustomerService customerService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.FulfillmentGroupDao fulfillmentGroupDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.FulfillmentGroupItemDao fulfillmentGroupItemDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.FulfillmentGroupService fulfillmentGroupService;
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.order.service.legacy.LegacyCartServiceImpl legacyCartServiceImpl;
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
    NullOrderImpl namedOrder = new NullOrderImpl();

    // Act
    legacyCartServiceImpl.moveItemToCartFromNamedOrder(namedOrder, new BundleOrderItemImpl(), true);
  }

  /**
   * Test {@link LegacyCartServiceImpl#moveAllItemsToCartFromNamedOrder(Order)}
   * with {@code namedOrder}.
   * <p>
   * Method under test:
   * {@link LegacyCartServiceImpl#moveAllItemsToCartFromNamedOrder(Order)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testMoveAllItemsToCartFromNamedOrderWithNamedOrder() throws PricingException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.order.service.legacy;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.core.order.service.legacy.LegacyCartServiceImpl.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass933 {
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.CategoryDao categoryDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.profile.core.service.CustomerService customerService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.FulfillmentGroupDao fulfillmentGroupDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.FulfillmentGroupItemDao fulfillmentGroupItemDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.FulfillmentGroupService fulfillmentGroupService;
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.order.service.legacy.LegacyCartServiceImpl legacyCartServiceImpl;
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
    legacyCartServiceImpl.moveAllItemsToCartFromNamedOrder(new NullOrderImpl());
  }

  /**
   * Test
   * {@link LegacyCartServiceImpl#moveAllItemsToCartFromNamedOrder(Order, boolean)}
   * with {@code namedOrder}, {@code priceOrder}.
   * <p>
   * Method under test:
   * {@link LegacyCartServiceImpl#moveAllItemsToCartFromNamedOrder(Order, boolean)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testMoveAllItemsToCartFromNamedOrderWithNamedOrderPriceOrder() throws PricingException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.order.service.legacy;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.core.order.service.legacy.LegacyCartServiceImpl.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass934 {
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.CategoryDao categoryDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.profile.core.service.CustomerService customerService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.FulfillmentGroupDao fulfillmentGroupDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.FulfillmentGroupItemDao fulfillmentGroupItemDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.FulfillmentGroupService fulfillmentGroupService;
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.order.service.legacy.LegacyCartServiceImpl legacyCartServiceImpl;
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
    legacyCartServiceImpl.moveAllItemsToCartFromNamedOrder(new NullOrderImpl(), true);
  }

  /**
   * Test {@link LegacyCartServiceImpl#mergeCart(Customer, Order)} with
   * {@code customer}, {@code anonymousCart}.
   * <p>
   * Method under test: {@link LegacyCartServiceImpl#mergeCart(Customer, Order)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testMergeCartWithCustomerAnonymousCart() throws PricingException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.order.service.legacy;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.core.order.service.legacy.LegacyCartServiceImpl.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass931 {
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.CategoryDao categoryDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.profile.core.service.CustomerService customerService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.FulfillmentGroupDao fulfillmentGroupDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.FulfillmentGroupItemDao fulfillmentGroupItemDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.FulfillmentGroupService fulfillmentGroupService;
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.order.service.legacy.LegacyCartServiceImpl legacyCartServiceImpl;
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
    CustomerImpl customer = new CustomerImpl();

    // Act
    legacyCartServiceImpl.mergeCart(customer, new NullOrderImpl());
  }

  /**
   * Test {@link LegacyCartServiceImpl#mergeCart(Customer, Order, boolean)} with
   * {@code customer}, {@code anonymousCart}, {@code priceOrder}.
   * <p>
   * Method under test:
   * {@link LegacyCartServiceImpl#mergeCart(Customer, Order, boolean)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testMergeCartWithCustomerAnonymousCartPriceOrder() throws PricingException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.order.service.legacy;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.core.order.service.legacy.LegacyCartServiceImpl.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass932 {
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.CategoryDao categoryDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.profile.core.service.CustomerService customerService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.FulfillmentGroupDao fulfillmentGroupDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.FulfillmentGroupItemDao fulfillmentGroupItemDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.FulfillmentGroupService fulfillmentGroupService;
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.order.service.legacy.LegacyCartServiceImpl legacyCartServiceImpl;
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
    CustomerImpl customer = new CustomerImpl();

    // Act
    legacyCartServiceImpl.mergeCart(customer, new NullOrderImpl(), true);
  }

  /**
   * Test {@link LegacyCartServiceImpl#reconstructCart(Customer)} with
   * {@code customer}.
   * <p>
   * Method under test: {@link LegacyCartServiceImpl#reconstructCart(Customer)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testReconstructCartWithCustomer() throws PricingException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.order.service.legacy;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.core.order.service.legacy.LegacyCartServiceImpl.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass939 {
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.CategoryDao categoryDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.profile.core.service.CustomerService customerService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.FulfillmentGroupDao fulfillmentGroupDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.FulfillmentGroupItemDao fulfillmentGroupItemDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.FulfillmentGroupService fulfillmentGroupService;
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.order.service.legacy.LegacyCartServiceImpl legacyCartServiceImpl;
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
    legacyCartServiceImpl.reconstructCart(new CustomerImpl());
  }

  /**
   * Test {@link LegacyCartServiceImpl#reconstructCart(Customer, boolean)} with
   * {@code customer}, {@code priceOrder}.
   * <p>
   * Method under test:
   * {@link LegacyCartServiceImpl#reconstructCart(Customer, boolean)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testReconstructCartWithCustomerPriceOrder() throws PricingException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.order.service.legacy;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.core.order.service.legacy.LegacyCartServiceImpl.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass940 {
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.CategoryDao categoryDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.profile.core.service.CustomerService customerService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.FulfillmentGroupDao fulfillmentGroupDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.FulfillmentGroupItemDao fulfillmentGroupItemDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.FulfillmentGroupService fulfillmentGroupService;
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.order.service.legacy.LegacyCartServiceImpl legacyCartServiceImpl;
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
    legacyCartServiceImpl.reconstructCart(new CustomerImpl(), true);
  }

  /**
   * Test
   * {@link LegacyCartServiceImpl#addItem(Long, OrderItemRequestDTO, boolean)}.
   * <p>
   * Method under test:
   * {@link LegacyCartServiceImpl#addItem(Long, OrderItemRequestDTO, boolean)}
   */
  @Test
  public void testAddItem() throws AddToCartException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LegacyCartServiceImpl legacyCartServiceImpl = new LegacyCartServiceImpl();

    // Act and Assert
    assertNull(legacyCartServiceImpl.addItem(1L, new OrderItemRequestDTO(), true));
  }

  /**
   * Test
   * {@link LegacyCartServiceImpl#addItem(Long, OrderItemRequestDTO, boolean)}.
   * <p>
   * Method under test:
   * {@link LegacyCartServiceImpl#addItem(Long, OrderItemRequestDTO, boolean)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testAddItem2() throws AddToCartException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.order.service.legacy;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.core.order.service.legacy.LegacyCartServiceImpl.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass930 {
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.CategoryDao categoryDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.profile.core.service.CustomerService customerService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.FulfillmentGroupDao fulfillmentGroupDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.FulfillmentGroupItemDao fulfillmentGroupItemDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.FulfillmentGroupService fulfillmentGroupService;
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.order.service.legacy.LegacyCartServiceImpl legacyCartServiceImpl;
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
    legacyCartServiceImpl.addItem(1L, new OrderItemRequestDTO(), true);
  }

  /**
   * Test
   * {@link LegacyCartServiceImpl#updateItemQuantity(Long, OrderItemRequestDTO, boolean)}
   * with {@code orderId}, {@code orderItemRequestDTO}, {@code priceOrder}.
   * <p>
   * Method under test:
   * {@link LegacyCartServiceImpl#updateItemQuantity(Long, OrderItemRequestDTO, boolean)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testUpdateItemQuantityWithOrderIdOrderItemRequestDTOPriceOrder() throws UpdateCartException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.order.service.legacy;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.core.order.service.legacy.LegacyCartServiceImpl.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass942 {
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.CategoryDao categoryDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.profile.core.service.CustomerService customerService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.FulfillmentGroupDao fulfillmentGroupDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.FulfillmentGroupItemDao fulfillmentGroupItemDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.FulfillmentGroupService fulfillmentGroupService;
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.order.service.legacy.LegacyCartServiceImpl legacyCartServiceImpl;
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
    legacyCartServiceImpl.updateItemQuantity(1L, new OrderItemRequestDTO(), true);
  }

  /**
   * Test {@link LegacyCartServiceImpl#removeItem(Long, Long, boolean)}.
   * <p>
   * Method under test:
   * {@link LegacyCartServiceImpl#removeItem(Long, Long, boolean)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testRemoveItem() throws RemoveFromCartException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.order.service.legacy;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.core.order.service.legacy.LegacyCartServiceImpl.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass941 {
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.CategoryDao categoryDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.profile.core.service.CustomerService customerService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.FulfillmentGroupDao fulfillmentGroupDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.FulfillmentGroupItemDao fulfillmentGroupItemDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.FulfillmentGroupService fulfillmentGroupService;
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.order.service.legacy.LegacyCartServiceImpl legacyCartServiceImpl;
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
    legacyCartServiceImpl.removeItem(1L, 1L, true);
  }

  /**
   * Test new {@link LegacyCartServiceImpl} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link LegacyCartServiceImpl}
   */
  @Test
  public void testNewLegacyCartServiceImpl() {
    // Arrange and Act
    LegacyCartServiceImpl actualLegacyCartServiceImpl = new LegacyCartServiceImpl();

    // Assert
    assertNull(actualLegacyCartServiceImpl.getFulfillmentGroupDao());
    assertNull(actualLegacyCartServiceImpl.getFulfillmentGroupItemDao());
    assertNull(actualLegacyCartServiceImpl.getOrderDao());
    assertNull(actualLegacyCartServiceImpl.getOrderItemService());
    assertNull(actualLegacyCartServiceImpl.getPaymentInfoDao());
    assertTrue(actualLegacyCartServiceImpl.isDeleteEmptyNamedOrders());
    assertTrue(actualLegacyCartServiceImpl.isMoveNamedOrderItems());
  }
}
