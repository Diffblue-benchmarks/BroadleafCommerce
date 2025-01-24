package org.broadleafcommerce.core.order.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.broadleafcommerce.common.audit.Auditable;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.core.offer.domain.OfferCode;
import org.broadleafcommerce.core.offer.domain.OfferCodeImpl;
import org.broadleafcommerce.core.offer.service.exception.OfferException;
import org.broadleafcommerce.core.order.domain.BundleOrderItemImpl;
import org.broadleafcommerce.core.order.domain.GiftWrapOrderItemImpl;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.Order;
import org.broadleafcommerce.core.order.domain.OrderItem;
import org.broadleafcommerce.core.order.domain.OrderItemAttribute;
import org.broadleafcommerce.core.order.domain.PersonalMessageImpl;
import org.broadleafcommerce.core.order.service.call.GiftWrapOrderItemRequest;
import org.broadleafcommerce.core.order.service.call.OrderItemRequestDTO;
import org.broadleafcommerce.core.order.service.exception.AddToCartException;
import org.broadleafcommerce.core.order.service.exception.RemoveFromCartException;
import org.broadleafcommerce.core.order.service.exception.UpdateCartException;
import org.broadleafcommerce.core.order.service.type.OrderItemType;
import org.broadleafcommerce.core.order.service.workflow.CartOperationRequest;
import org.broadleafcommerce.core.payment.domain.OrderPayment;
import org.broadleafcommerce.core.payment.domain.OrderPaymentImpl;
import org.broadleafcommerce.core.payment.domain.secure.Referenced;
import org.broadleafcommerce.core.pricing.service.exception.PricingException;
import org.broadleafcommerce.core.workflow.DefaultProcessContextImpl;
import org.broadleafcommerce.core.workflow.ProcessContext;
import org.broadleafcommerce.core.workflow.WorkflowException;
import org.broadleafcommerce.profile.core.domain.Customer;
import org.broadleafcommerce.profile.core.domain.CustomerImpl;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml",
    "/bl-framework-applicationContext-persistence.xml", "/bl-framework-applicationContext-workflow.xml",
    "/bl-framework-applicationContext.xml", "/blc-config/admin/framework/bl-framework-admin-applicationContext.xml",
    "/blc-config/site/framework/bl-framework-applicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class OrderServiceImplDiffblueTest {
  @Autowired
  private OrderServiceImpl orderServiceImpl;

  /**
   * Test {@link OrderServiceImpl#createNewCartForCustomer(Customer)}.
   * <p>
   * Method under test:
   * {@link OrderServiceImpl#createNewCartForCustomer(Customer)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testCreateNewCartForCustomer() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.order.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1150 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.order.service.OrderServiceImpl orderServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    OrderServiceImpl orderServiceImpl2 = new OrderServiceImpl();

    // Act
    orderServiceImpl2.createNewCartForCustomer(new CustomerImpl());
  }

  /**
   * Test {@link OrderServiceImpl#createNamedOrderForCustomer(String, Customer)}.
   * <p>
   * Method under test:
   * {@link OrderServiceImpl#createNamedOrderForCustomer(String, Customer)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testCreateNamedOrderForCustomer() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.order.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1120 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.order.service.OrderServiceImpl orderServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    OrderServiceImpl orderServiceImpl2 = new OrderServiceImpl();

    // Act
    orderServiceImpl2.createNamedOrderForCustomer("Name", new CustomerImpl());
  }

  /**
   * Test {@link OrderServiceImpl#findNamedOrderForCustomer(String, Customer)}.
   * <p>
   * Method under test:
   * {@link OrderServiceImpl#findNamedOrderForCustomer(String, Customer)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testFindNamedOrderForCustomer() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.order.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1487 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.order.service.OrderServiceImpl orderServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    OrderServiceImpl orderServiceImpl2 = new OrderServiceImpl();

    // Act
    orderServiceImpl2.findNamedOrderForCustomer("Name", new CustomerImpl());
  }

  /**
   * Test {@link OrderServiceImpl#findCartForCustomer(Customer)}.
   * <p>
   * Method under test: {@link OrderServiceImpl#findCartForCustomer(Customer)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testFindCartForCustomer() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.order.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1299 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.order.service.OrderServiceImpl orderServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    OrderServiceImpl orderServiceImpl2 = new OrderServiceImpl();

    // Act
    orderServiceImpl2.findCartForCustomer(new CustomerImpl());
  }

  /**
   * Test
   * {@link OrderServiceImpl#addPaymentToOrder(Order, OrderPayment, Referenced)}.
   * <p>
   * Method under test:
   * {@link OrderServiceImpl#addPaymentToOrder(Order, OrderPayment, Referenced)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testAddPaymentToOrder() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.order.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass968 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.order.service.OrderServiceImpl orderServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    OrderServiceImpl orderServiceImpl2 = new OrderServiceImpl();
    NullOrderImpl order = new NullOrderImpl();

    // Act
    orderServiceImpl2.addPaymentToOrder(order, new OrderPaymentImpl(), mock(Referenced.class));
  }

  /**
   * Test {@link OrderServiceImpl#cancelOrder(Order)}.
   * <p>
   * Method under test: {@link OrderServiceImpl#cancelOrder(Order)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testCancelOrder() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.order.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1012 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.order.service.OrderServiceImpl orderServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    OrderServiceImpl orderServiceImpl2 = new OrderServiceImpl();

    // Act
    orderServiceImpl2.cancelOrder(new NullOrderImpl());
  }

  /**
   * Test {@link OrderServiceImpl#deleteOrder(Order)}.
   * <p>
   * Method under test: {@link OrderServiceImpl#deleteOrder(Order)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testDeleteOrder() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.order.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1193 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.order.service.OrderServiceImpl orderServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    OrderServiceImpl orderServiceImpl2 = new OrderServiceImpl();

    // Act
    orderServiceImpl2.deleteOrder(new NullOrderImpl());
  }

  /**
   * Test {@link OrderServiceImpl#addOfferCode(Order, OfferCode, boolean)}.
   * <p>
   * Method under test:
   * {@link OrderServiceImpl#addOfferCode(Order, OfferCode, boolean)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testAddOfferCode() throws OfferException, PricingException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.order.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass890 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.order.service.OrderServiceImpl orderServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    OrderServiceImpl orderServiceImpl2 = new OrderServiceImpl();
    NullOrderImpl order = new NullOrderImpl();

    // Act
    orderServiceImpl2.addOfferCode(order, new OfferCodeImpl(), true);
  }

  /**
   * Test {@link OrderServiceImpl#addOfferCodes(Order, List, boolean)}.
   * <p>
   * Method under test:
   * {@link OrderServiceImpl#addOfferCodes(Order, List, boolean)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testAddOfferCodes() throws OfferException, PricingException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.order.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass934 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.order.service.OrderServiceImpl orderServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    OrderServiceImpl orderServiceImpl2 = new OrderServiceImpl();
    NullOrderImpl order = new NullOrderImpl();

    // Act
    orderServiceImpl2.addOfferCodes(order, new ArrayList<>(), true);
  }

  /**
   * Test {@link OrderServiceImpl#findLastMatchingItem(Order, Long, Long)}.
   * <p>
   * Method under test:
   * {@link OrderServiceImpl#findLastMatchingItem(Order, Long, Long)}
   */
  @Test
  public void testFindLastMatchingItem() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderServiceImpl orderServiceImpl = new OrderServiceImpl();

    // Act and Assert
    assertNull(orderServiceImpl.findLastMatchingItem(new NullOrderImpl(), 1L, 1L));
  }

  /**
   * Test {@link OrderServiceImpl#findLastMatchingItem(Order, Long, Long)}.
   * <p>
   * Method under test:
   * {@link OrderServiceImpl#findLastMatchingItem(Order, Long, Long)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testFindLastMatchingItem2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.order.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1402 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.order.service.OrderServiceImpl orderServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    OrderServiceImpl orderServiceImpl2 = new OrderServiceImpl();

    // Act
    orderServiceImpl2.findLastMatchingItem(new NullOrderImpl(), 1L, 1L);
  }

  /**
   * Test {@link OrderServiceImpl#confirmOrder(Order)}.
   * <p>
   * Method under test: {@link OrderServiceImpl#confirmOrder(Order)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testConfirmOrder() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.order.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1091 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.order.service.OrderServiceImpl orderServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    OrderServiceImpl orderServiceImpl2 = new OrderServiceImpl();

    // Act
    orderServiceImpl2.confirmOrder(new NullOrderImpl());
  }

  /**
   * Test {@link OrderServiceImpl#addAllItemsFromNamedOrder(Order, boolean)}.
   * <p>
   * Method under test:
   * {@link OrderServiceImpl#addAllItemsFromNamedOrder(Order, boolean)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testAddAllItemsFromNamedOrder() throws AddToCartException, RemoveFromCartException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.order.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass375 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.order.service.OrderServiceImpl orderServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    OrderServiceImpl orderServiceImpl2 = new OrderServiceImpl();

    // Act
    orderServiceImpl2.addAllItemsFromNamedOrder(new NullOrderImpl(), true);
  }

  /**
   * Test
   * {@link OrderServiceImpl#addItemFromNamedOrder(Order, OrderItem, boolean)}
   * with {@code namedOrder}, {@code item}, {@code priceOrder}.
   * <p>
   * Method under test:
   * {@link OrderServiceImpl#addItemFromNamedOrder(Order, OrderItem, boolean)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testAddItemFromNamedOrderWithNamedOrderItemPriceOrder()
      throws AddToCartException, RemoveFromCartException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.order.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass745 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.order.service.OrderServiceImpl orderServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    OrderServiceImpl orderServiceImpl2 = new OrderServiceImpl();
    NullOrderImpl namedOrder = new NullOrderImpl();

    // Act
    orderServiceImpl2.addItemFromNamedOrder(namedOrder, new BundleOrderItemImpl(), true);
  }

  /**
   * Test
   * {@link OrderServiceImpl#addItemFromNamedOrder(Order, OrderItem, int, boolean)}
   * with {@code namedOrder}, {@code item}, {@code quantity}, {@code priceOrder}.
   * <p>
   * Method under test:
   * {@link OrderServiceImpl#addItemFromNamedOrder(Order, OrderItem, int, boolean)}
   */
  @Test
  public void testAddItemFromNamedOrderWithNamedOrderItemQuantityPriceOrder()
      throws AddToCartException, RemoveFromCartException, UpdateCartException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderServiceImpl orderServiceImpl = new OrderServiceImpl();
    NullOrderImpl namedOrder = new NullOrderImpl();

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> orderServiceImpl.addItemFromNamedOrder(namedOrder, new BundleOrderItemImpl(), 2, true));
  }

  /**
   * Test
   * {@link OrderServiceImpl#addItemFromNamedOrder(Order, OrderItem, int, boolean)}
   * with {@code namedOrder}, {@code item}, {@code quantity}, {@code priceOrder}.
   * <p>
   * Method under test:
   * {@link OrderServiceImpl#addItemFromNamedOrder(Order, OrderItem, int, boolean)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testAddItemFromNamedOrderWithNamedOrderItemQuantityPriceOrder2()
      throws AddToCartException, RemoveFromCartException, UpdateCartException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.order.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass650 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.order.service.OrderServiceImpl orderServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    OrderServiceImpl orderServiceImpl2 = new OrderServiceImpl();
    NullOrderImpl namedOrder = new NullOrderImpl();

    // Act
    orderServiceImpl2.addItemFromNamedOrder(namedOrder, new BundleOrderItemImpl(), 2, true);
  }

  /**
   * Test
   * {@link OrderServiceImpl#addGiftWrapItemToOrder(Order, GiftWrapOrderItemRequest, boolean)}.
   * <p>
   * Method under test:
   * {@link OrderServiceImpl#addGiftWrapItemToOrder(Order, GiftWrapOrderItemRequest, boolean)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testAddGiftWrapItemToOrder() throws PricingException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.order.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass546 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.order.service.OrderServiceImpl orderServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    OrderServiceImpl orderServiceImpl2 = new OrderServiceImpl();
    NullOrderImpl order = new NullOrderImpl();

    // Act
    orderServiceImpl2.addGiftWrapItemToOrder(order, new GiftWrapOrderItemRequest(), true);
  }

  /**
   * Test {@link OrderServiceImpl#addItem(Long, OrderItemRequestDTO, boolean)}.
   * <p>
   * Method under test:
   * {@link OrderServiceImpl#addItem(Long, OrderItemRequestDTO, boolean)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testAddItem() throws AddToCartException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.order.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass591 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.order.service.OrderServiceImpl orderServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    OrderServiceImpl orderServiceImpl2 = new OrderServiceImpl();

    // Act
    orderServiceImpl2.addItem(1L, new OrderItemRequestDTO(), true);
  }

  /**
   * Test
   * {@link OrderServiceImpl#addItemWithPriceOverrides(Long, OrderItemRequestDTO, boolean)}.
   * <p>
   * Method under test:
   * {@link OrderServiceImpl#addItemWithPriceOverrides(Long, OrderItemRequestDTO, boolean)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testAddItemWithPriceOverrides() throws AddToCartException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.order.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass831 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.order.service.OrderServiceImpl orderServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    OrderServiceImpl orderServiceImpl2 = new OrderServiceImpl();

    // Act
    orderServiceImpl2.addItemWithPriceOverrides(1L, new OrderItemRequestDTO(), true);
  }

  /**
   * Test
   * {@link OrderServiceImpl#addChildItems(OrderItemRequestDTO, int, int, ProcessContext, List)}.
   * <p>
   * Method under test:
   * {@link OrderServiceImpl#addChildItems(OrderItemRequestDTO, int, int, ProcessContext, List)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testAddChildItems() throws WorkflowException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.order.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass405 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.order.service.OrderServiceImpl orderServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    OrderServiceImpl orderServiceImpl2 = new OrderServiceImpl();
    OrderItemRequestDTO orderItemRequestDTO = new OrderItemRequestDTO();
    DefaultProcessContextImpl<CartOperationRequest> context = new DefaultProcessContextImpl<>();

    // Act
    orderServiceImpl2.addChildItems(orderItemRequestDTO, 10, 2, context, new ArrayList<>());
  }

  /**
   * Test
   * {@link OrderServiceImpl#addDependentOrderItem(OrderItemRequestDTO, OrderItemRequestDTO)}.
   * <p>
   * Method under test:
   * {@link OrderServiceImpl#addDependentOrderItem(OrderItemRequestDTO, OrderItemRequestDTO)}
   */
  @Test
  public void testAddDependentOrderItem() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderServiceImpl orderServiceImpl = new OrderServiceImpl();
    OrderItemRequestDTO parentOrderItemRequest = new OrderItemRequestDTO();
    OrderItemRequestDTO dependentOrderItem = new OrderItemRequestDTO();

    // Act
    orderServiceImpl.addDependentOrderItem(parentOrderItemRequest, dependentOrderItem);

    // Assert
    List<OrderItemRequestDTO> childOrderItems = parentOrderItemRequest.getChildOrderItems();
    assertEquals(1, childOrderItems.size());
    assertSame(dependentOrderItem, childOrderItems.get(0));
  }

  /**
   * Test
   * {@link OrderServiceImpl#addDependentOrderItem(OrderItemRequestDTO, OrderItemRequestDTO)}.
   * <p>
   * Method under test:
   * {@link OrderServiceImpl#addDependentOrderItem(OrderItemRequestDTO, OrderItemRequestDTO)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testAddDependentOrderItem2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.order.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass477 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.order.service.OrderServiceImpl orderServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    OrderServiceImpl orderServiceImpl2 = new OrderServiceImpl();
    OrderItemRequestDTO parentOrderItemRequest = new OrderItemRequestDTO();

    // Act
    orderServiceImpl2.addDependentOrderItem(parentOrderItemRequest, new OrderItemRequestDTO());
  }

  /**
   * Test {@link OrderServiceImpl#findAllChildrenToRemove(List, OrderItem)}.
   * <p>
   * Method under test:
   * {@link OrderServiceImpl#findAllChildrenToRemove(List, OrderItem)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testFindAllChildrenToRemove() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.order.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1222 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.order.service.OrderServiceImpl orderServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    OrderServiceImpl orderServiceImpl2 = new OrderServiceImpl();
    ArrayList<Long> childrenToRemove = new ArrayList<>();

    // Act
    orderServiceImpl2.findAllChildrenToRemove(childrenToRemove, new BundleOrderItemImpl());
  }

  /**
   * Test {@link OrderServiceImpl#findAllChildrenToRemove(List, OrderItem)}.
   * <ul>
   *   <li>Given {@link Auditable} (default constructor) CreatedBy is one.</li>
   *   <li>Then {@link ArrayList#ArrayList()} size is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OrderServiceImpl#findAllChildrenToRemove(List, OrderItem)}
   */
  @Test
  public void testFindAllChildrenToRemove_givenAuditableCreatedByIsOne_thenArrayListSizeIsOne() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderServiceImpl orderServiceImpl = new OrderServiceImpl();
    ArrayList<Long> childrenToRemove = new ArrayList<>();

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
    bundleOrderItemImpl.setDiscountingAllowed(true);
    bundleOrderItemImpl.setDiscreteOrderItems(new ArrayList<>());
    bundleOrderItemImpl.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    bundleOrderItemImpl.setHasValidationError(true);
    bundleOrderItemImpl.setId(1L);
    bundleOrderItemImpl.setName("Name");
    bundleOrderItemImpl.setOrder(new NullOrderImpl());
    bundleOrderItemImpl.setOrderItemAdjustments(new ArrayList<>());
    bundleOrderItemImpl.setOrderItemAttributes(new HashMap<>());
    bundleOrderItemImpl.setOrderItemPriceDetails(new ArrayList<>());
    bundleOrderItemImpl.setOrderItemQualifiers(new ArrayList<>());
    bundleOrderItemImpl.setOrderItemType(OrderItemType.BASIC);
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
    bundleOrderItemImpl.setChildOrderItems(null);

    ArrayList<OrderItem> childOrderItems = new ArrayList<>();
    childOrderItems.add(bundleOrderItemImpl);

    BundleOrderItemImpl orderItem = new BundleOrderItemImpl();
    orderItem.setAuditable(auditable);
    orderItem.setBaseRetailPrice(new Money());
    orderItem.setBaseSalePrice(new Money());
    orderItem.setBundleOrderItemFeePrices(new ArrayList<>());
    orderItem.setCandidateItemOffers(new ArrayList<>());
    orderItem.setCartMessages(new ArrayList<>());
    orderItem.setDiscountingAllowed(true);
    orderItem.setDiscreteOrderItems(new ArrayList<>());
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
    orderItem.setProratedOrderItemAdjustments(new ArrayList<>());
    orderItem.setQuantity(1);
    orderItem.setRetailPrice(new Money());
    orderItem.setRetailPriceOverride(true);
    orderItem.setSalePrice(new Money());
    orderItem.setSalePriceOverride(true);
    orderItem.setTaxable(true);
    orderItem.updateSaleAndRetailPrices();
    orderItem.setChildOrderItems(childOrderItems);

    // Act
    orderServiceImpl.findAllChildrenToRemove(childrenToRemove, orderItem);

    // Assert
    assertEquals(1, childrenToRemove.size());
    assertEquals(1L, childrenToRemove.get(0).longValue());
  }

  /**
   * Test {@link OrderServiceImpl#findAllChildrenToRemove(List, OrderItem)}.
   * <ul>
   *   <li>Then {@link ArrayList#ArrayList()} size is four.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OrderServiceImpl#findAllChildrenToRemove(List, OrderItem)}
   */
  @Test
  public void testFindAllChildrenToRemove_thenArrayListSizeIsFour() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderServiceImpl orderServiceImpl = new OrderServiceImpl();
    ArrayList<Long> childrenToRemove = new ArrayList<>();

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

    Auditable auditable3 = new Auditable();
    auditable3.setCreatedBy(1L);
    auditable3.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable3.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable3.setUpdatedBy(1L);

    Auditable auditable4 = new Auditable();
    auditable4.setCreatedBy(1L);
    auditable4.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable4.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable4.setUpdatedBy(1L);

    Auditable auditable5 = new Auditable();
    auditable5.setCreatedBy(1L);
    auditable5.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable5.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable5.setUpdatedBy(1L);

    BundleOrderItemImpl bundleOrderItemImpl = new BundleOrderItemImpl();
    bundleOrderItemImpl.setAuditable(auditable5);
    bundleOrderItemImpl.setBaseRetailPrice(new Money());
    bundleOrderItemImpl.setBaseSalePrice(new Money());
    bundleOrderItemImpl.setBundleOrderItemFeePrices(new ArrayList<>());
    bundleOrderItemImpl.setCandidateItemOffers(new ArrayList<>());
    bundleOrderItemImpl.setCartMessages(new ArrayList<>());
    bundleOrderItemImpl.setDiscountingAllowed(true);
    bundleOrderItemImpl.setDiscreteOrderItems(new ArrayList<>());
    bundleOrderItemImpl.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    bundleOrderItemImpl.setHasValidationError(true);
    bundleOrderItemImpl.setId(1L);
    bundleOrderItemImpl.setName("Name");
    bundleOrderItemImpl.setOrder(new NullOrderImpl());
    bundleOrderItemImpl.setOrderItemAdjustments(new ArrayList<>());
    bundleOrderItemImpl.setOrderItemAttributes(new HashMap<>());
    bundleOrderItemImpl.setOrderItemPriceDetails(new ArrayList<>());
    bundleOrderItemImpl.setOrderItemQualifiers(new ArrayList<>());
    bundleOrderItemImpl.setOrderItemType(OrderItemType.BASIC);
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
    bundleOrderItemImpl.setChildOrderItems(null);

    ArrayList<OrderItem> childOrderItems = new ArrayList<>();
    childOrderItems.add(bundleOrderItemImpl);

    BundleOrderItemImpl bundleOrderItemImpl2 = new BundleOrderItemImpl();
    bundleOrderItemImpl2.setAuditable(auditable4);
    bundleOrderItemImpl2.setBaseRetailPrice(new Money());
    bundleOrderItemImpl2.setBaseSalePrice(new Money());
    bundleOrderItemImpl2.setBundleOrderItemFeePrices(new ArrayList<>());
    bundleOrderItemImpl2.setCandidateItemOffers(new ArrayList<>());
    bundleOrderItemImpl2.setCartMessages(new ArrayList<>());
    bundleOrderItemImpl2.setDiscountingAllowed(true);
    bundleOrderItemImpl2.setDiscreteOrderItems(new ArrayList<>());
    bundleOrderItemImpl2.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    bundleOrderItemImpl2.setHasValidationError(true);
    bundleOrderItemImpl2.setId(1L);
    bundleOrderItemImpl2.setName("Name");
    bundleOrderItemImpl2.setOrder(new NullOrderImpl());
    bundleOrderItemImpl2.setOrderItemAdjustments(new ArrayList<>());
    bundleOrderItemImpl2.setOrderItemAttributes(new HashMap<>());
    bundleOrderItemImpl2.setOrderItemPriceDetails(new ArrayList<>());
    bundleOrderItemImpl2.setOrderItemQualifiers(new ArrayList<>());
    bundleOrderItemImpl2.setOrderItemType(OrderItemType.BASIC);
    bundleOrderItemImpl2.setParentOrderItem(new BundleOrderItemImpl());
    bundleOrderItemImpl2.setPersonalMessage(new PersonalMessageImpl());
    bundleOrderItemImpl2.setProratedOrderItemAdjustments(new ArrayList<>());
    bundleOrderItemImpl2.setQuantity(1);
    bundleOrderItemImpl2.setRetailPrice(new Money());
    bundleOrderItemImpl2.setRetailPriceOverride(true);
    bundleOrderItemImpl2.setSalePrice(new Money());
    bundleOrderItemImpl2.setSalePriceOverride(true);
    bundleOrderItemImpl2.setTaxable(true);
    bundleOrderItemImpl2.updateSaleAndRetailPrices();
    bundleOrderItemImpl2.setChildOrderItems(childOrderItems);

    ArrayList<OrderItem> childOrderItems2 = new ArrayList<>();
    childOrderItems2.add(bundleOrderItemImpl2);

    BundleOrderItemImpl bundleOrderItemImpl3 = new BundleOrderItemImpl();
    bundleOrderItemImpl3.setAuditable(auditable3);
    bundleOrderItemImpl3.setBaseRetailPrice(new Money());
    bundleOrderItemImpl3.setBaseSalePrice(new Money());
    bundleOrderItemImpl3.setBundleOrderItemFeePrices(new ArrayList<>());
    bundleOrderItemImpl3.setCandidateItemOffers(new ArrayList<>());
    bundleOrderItemImpl3.setCartMessages(new ArrayList<>());
    bundleOrderItemImpl3.setDiscountingAllowed(true);
    bundleOrderItemImpl3.setDiscreteOrderItems(new ArrayList<>());
    bundleOrderItemImpl3.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    bundleOrderItemImpl3.setHasValidationError(true);
    bundleOrderItemImpl3.setId(1L);
    bundleOrderItemImpl3.setName("Name");
    bundleOrderItemImpl3.setOrder(new NullOrderImpl());
    bundleOrderItemImpl3.setOrderItemAdjustments(new ArrayList<>());
    bundleOrderItemImpl3.setOrderItemAttributes(new HashMap<>());
    bundleOrderItemImpl3.setOrderItemPriceDetails(new ArrayList<>());
    bundleOrderItemImpl3.setOrderItemQualifiers(new ArrayList<>());
    bundleOrderItemImpl3.setOrderItemType(OrderItemType.BASIC);
    bundleOrderItemImpl3.setParentOrderItem(new BundleOrderItemImpl());
    bundleOrderItemImpl3.setPersonalMessage(new PersonalMessageImpl());
    bundleOrderItemImpl3.setProratedOrderItemAdjustments(new ArrayList<>());
    bundleOrderItemImpl3.setQuantity(1);
    bundleOrderItemImpl3.setRetailPrice(new Money());
    bundleOrderItemImpl3.setRetailPriceOverride(true);
    bundleOrderItemImpl3.setSalePrice(new Money());
    bundleOrderItemImpl3.setSalePriceOverride(true);
    bundleOrderItemImpl3.setTaxable(true);
    bundleOrderItemImpl3.updateSaleAndRetailPrices();
    bundleOrderItemImpl3.setChildOrderItems(childOrderItems2);

    ArrayList<OrderItem> childOrderItems3 = new ArrayList<>();
    childOrderItems3.add(bundleOrderItemImpl3);

    BundleOrderItemImpl bundleOrderItemImpl4 = new BundleOrderItemImpl();
    bundleOrderItemImpl4.setAuditable(auditable2);
    bundleOrderItemImpl4.setBaseRetailPrice(new Money());
    bundleOrderItemImpl4.setBaseSalePrice(new Money());
    bundleOrderItemImpl4.setBundleOrderItemFeePrices(new ArrayList<>());
    bundleOrderItemImpl4.setCandidateItemOffers(new ArrayList<>());
    bundleOrderItemImpl4.setCartMessages(new ArrayList<>());
    bundleOrderItemImpl4.setDiscountingAllowed(true);
    bundleOrderItemImpl4.setDiscreteOrderItems(new ArrayList<>());
    bundleOrderItemImpl4.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    bundleOrderItemImpl4.setHasValidationError(true);
    bundleOrderItemImpl4.setId(1L);
    bundleOrderItemImpl4.setName("Name");
    bundleOrderItemImpl4.setOrder(new NullOrderImpl());
    bundleOrderItemImpl4.setOrderItemAdjustments(new ArrayList<>());
    bundleOrderItemImpl4.setOrderItemAttributes(new HashMap<>());
    bundleOrderItemImpl4.setOrderItemPriceDetails(new ArrayList<>());
    bundleOrderItemImpl4.setOrderItemQualifiers(new ArrayList<>());
    bundleOrderItemImpl4.setOrderItemType(OrderItemType.BASIC);
    bundleOrderItemImpl4.setParentOrderItem(new BundleOrderItemImpl());
    bundleOrderItemImpl4.setPersonalMessage(new PersonalMessageImpl());
    bundleOrderItemImpl4.setProratedOrderItemAdjustments(new ArrayList<>());
    bundleOrderItemImpl4.setQuantity(1);
    bundleOrderItemImpl4.setRetailPrice(new Money());
    bundleOrderItemImpl4.setRetailPriceOverride(true);
    bundleOrderItemImpl4.setSalePrice(new Money());
    bundleOrderItemImpl4.setSalePriceOverride(true);
    bundleOrderItemImpl4.setTaxable(true);
    bundleOrderItemImpl4.updateSaleAndRetailPrices();
    bundleOrderItemImpl4.setChildOrderItems(childOrderItems3);

    ArrayList<OrderItem> childOrderItems4 = new ArrayList<>();
    childOrderItems4.add(bundleOrderItemImpl4);

    BundleOrderItemImpl orderItem = new BundleOrderItemImpl();
    orderItem.setAuditable(auditable);
    orderItem.setBaseRetailPrice(new Money());
    orderItem.setBaseSalePrice(new Money());
    orderItem.setBundleOrderItemFeePrices(new ArrayList<>());
    orderItem.setCandidateItemOffers(new ArrayList<>());
    orderItem.setCartMessages(new ArrayList<>());
    orderItem.setDiscountingAllowed(true);
    orderItem.setDiscreteOrderItems(new ArrayList<>());
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
    orderItem.setProratedOrderItemAdjustments(new ArrayList<>());
    orderItem.setQuantity(1);
    orderItem.setRetailPrice(new Money());
    orderItem.setRetailPriceOverride(true);
    orderItem.setSalePrice(new Money());
    orderItem.setSalePriceOverride(true);
    orderItem.setTaxable(true);
    orderItem.updateSaleAndRetailPrices();
    orderItem.setChildOrderItems(childOrderItems4);

    // Act
    orderServiceImpl.findAllChildrenToRemove(childrenToRemove, orderItem);

    // Assert
    assertEquals(4, childrenToRemove.size());
    assertEquals(1L, childrenToRemove.get(1).longValue());
    assertEquals(1L, childrenToRemove.get(2).longValue());
    assertEquals(1L, childrenToRemove.get(3).longValue());
  }

  /**
   * Test {@link OrderServiceImpl#findAllChildrenToRemove(List, OrderItem)}.
   * <ul>
   *   <li>Then {@link ArrayList#ArrayList()} size is two.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OrderServiceImpl#findAllChildrenToRemove(List, OrderItem)}
   */
  @Test
  public void testFindAllChildrenToRemove_thenArrayListSizeIsTwo() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderServiceImpl orderServiceImpl = new OrderServiceImpl();
    ArrayList<Long> childrenToRemove = new ArrayList<>();

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

    Auditable auditable3 = new Auditable();
    auditable3.setCreatedBy(1L);
    auditable3.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable3.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable3.setUpdatedBy(1L);

    BundleOrderItemImpl bundleOrderItemImpl = new BundleOrderItemImpl();
    bundleOrderItemImpl.setAuditable(auditable3);
    bundleOrderItemImpl.setBaseRetailPrice(new Money());
    bundleOrderItemImpl.setBaseSalePrice(new Money());
    bundleOrderItemImpl.setBundleOrderItemFeePrices(new ArrayList<>());
    bundleOrderItemImpl.setCandidateItemOffers(new ArrayList<>());
    bundleOrderItemImpl.setCartMessages(new ArrayList<>());
    bundleOrderItemImpl.setDiscountingAllowed(true);
    bundleOrderItemImpl.setDiscreteOrderItems(new ArrayList<>());
    bundleOrderItemImpl.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    bundleOrderItemImpl.setHasValidationError(true);
    bundleOrderItemImpl.setId(1L);
    bundleOrderItemImpl.setName("Name");
    bundleOrderItemImpl.setOrder(new NullOrderImpl());
    bundleOrderItemImpl.setOrderItemAdjustments(new ArrayList<>());
    bundleOrderItemImpl.setOrderItemAttributes(new HashMap<>());
    bundleOrderItemImpl.setOrderItemPriceDetails(new ArrayList<>());
    bundleOrderItemImpl.setOrderItemQualifiers(new ArrayList<>());
    bundleOrderItemImpl.setOrderItemType(OrderItemType.BASIC);
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
    bundleOrderItemImpl.setChildOrderItems(null);

    ArrayList<OrderItem> childOrderItems = new ArrayList<>();
    childOrderItems.add(bundleOrderItemImpl);

    BundleOrderItemImpl bundleOrderItemImpl2 = new BundleOrderItemImpl();
    bundleOrderItemImpl2.setAuditable(auditable2);
    bundleOrderItemImpl2.setBaseRetailPrice(new Money());
    bundleOrderItemImpl2.setBaseSalePrice(new Money());
    bundleOrderItemImpl2.setBundleOrderItemFeePrices(new ArrayList<>());
    bundleOrderItemImpl2.setCandidateItemOffers(new ArrayList<>());
    bundleOrderItemImpl2.setCartMessages(new ArrayList<>());
    bundleOrderItemImpl2.setDiscountingAllowed(true);
    bundleOrderItemImpl2.setDiscreteOrderItems(new ArrayList<>());
    bundleOrderItemImpl2.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    bundleOrderItemImpl2.setHasValidationError(true);
    bundleOrderItemImpl2.setId(1L);
    bundleOrderItemImpl2.setName("Name");
    bundleOrderItemImpl2.setOrder(new NullOrderImpl());
    bundleOrderItemImpl2.setOrderItemAdjustments(new ArrayList<>());
    bundleOrderItemImpl2.setOrderItemAttributes(new HashMap<>());
    bundleOrderItemImpl2.setOrderItemPriceDetails(new ArrayList<>());
    bundleOrderItemImpl2.setOrderItemQualifiers(new ArrayList<>());
    bundleOrderItemImpl2.setOrderItemType(OrderItemType.BASIC);
    bundleOrderItemImpl2.setParentOrderItem(new BundleOrderItemImpl());
    bundleOrderItemImpl2.setPersonalMessage(new PersonalMessageImpl());
    bundleOrderItemImpl2.setProratedOrderItemAdjustments(new ArrayList<>());
    bundleOrderItemImpl2.setQuantity(1);
    bundleOrderItemImpl2.setRetailPrice(new Money());
    bundleOrderItemImpl2.setRetailPriceOverride(true);
    bundleOrderItemImpl2.setSalePrice(new Money());
    bundleOrderItemImpl2.setSalePriceOverride(true);
    bundleOrderItemImpl2.setTaxable(true);
    bundleOrderItemImpl2.updateSaleAndRetailPrices();
    bundleOrderItemImpl2.setChildOrderItems(childOrderItems);

    ArrayList<OrderItem> childOrderItems2 = new ArrayList<>();
    childOrderItems2.add(bundleOrderItemImpl2);

    BundleOrderItemImpl orderItem = new BundleOrderItemImpl();
    orderItem.setAuditable(auditable);
    orderItem.setBaseRetailPrice(new Money());
    orderItem.setBaseSalePrice(new Money());
    orderItem.setBundleOrderItemFeePrices(new ArrayList<>());
    orderItem.setCandidateItemOffers(new ArrayList<>());
    orderItem.setCartMessages(new ArrayList<>());
    orderItem.setDiscountingAllowed(true);
    orderItem.setDiscreteOrderItems(new ArrayList<>());
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
    orderItem.setProratedOrderItemAdjustments(new ArrayList<>());
    orderItem.setQuantity(1);
    orderItem.setRetailPrice(new Money());
    orderItem.setRetailPriceOverride(true);
    orderItem.setSalePrice(new Money());
    orderItem.setSalePriceOverride(true);
    orderItem.setTaxable(true);
    orderItem.updateSaleAndRetailPrices();
    orderItem.setChildOrderItems(childOrderItems2);

    // Act
    orderServiceImpl.findAllChildrenToRemove(childrenToRemove, orderItem);

    // Assert
    assertEquals(2, childrenToRemove.size());
    assertEquals(1L, childrenToRemove.get(0).longValue());
    assertEquals(1L, childrenToRemove.get(1).longValue());
  }

  /**
   * Test {@link OrderServiceImpl#findAllChildrenToRemove(List, OrderItem)}.
   * <ul>
   *   <li>When {@link BundleOrderItemImpl} (default constructor).</li>
   *   <li>Then {@link ArrayList#ArrayList()} Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OrderServiceImpl#findAllChildrenToRemove(List, OrderItem)}
   */
  @Test
  public void testFindAllChildrenToRemove_whenBundleOrderItemImpl_thenArrayListEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderServiceImpl orderServiceImpl = new OrderServiceImpl();
    ArrayList<Long> childrenToRemove = new ArrayList<>();

    // Act
    orderServiceImpl.findAllChildrenToRemove(childrenToRemove, new BundleOrderItemImpl());

    // Assert that nothing has changed
    assertTrue(childrenToRemove.isEmpty());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link OrderServiceImpl#setDeleteEmptyNamedOrders(boolean)}
   *   <li>{@link OrderServiceImpl#setMoveNamedOrderItems(boolean)}
   *   <li>{@link OrderServiceImpl#isDeleteEmptyNamedOrders()}
   *   <li>{@link OrderServiceImpl#isMoveNamedOrderItems()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    OrderServiceImpl orderServiceImpl = new OrderServiceImpl();

    // Act
    orderServiceImpl.setDeleteEmptyNamedOrders(true);
    orderServiceImpl.setMoveNamedOrderItems(true);
    boolean actualIsDeleteEmptyNamedOrdersResult = orderServiceImpl.isDeleteEmptyNamedOrders();

    // Assert that nothing has changed
    assertTrue(actualIsDeleteEmptyNamedOrdersResult);
    assertTrue(orderServiceImpl.isMoveNamedOrderItems());
  }

  /**
   * Test {@link OrderServiceImpl#compareAttributes(Map, OrderItemRequestDTO)}.
   * <p>
   * Method under test:
   * {@link OrderServiceImpl#compareAttributes(Map, OrderItemRequestDTO)}
   */
  @Test
  public void testCompareAttributes() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderServiceImpl orderServiceImpl = new OrderServiceImpl();
    HashMap<String, OrderItemAttribute> item1Attributes = new HashMap<>();

    // Act and Assert
    assertTrue(orderServiceImpl.compareAttributes(item1Attributes, new OrderItemRequestDTO()));
  }

  /**
   * Test {@link OrderServiceImpl#compareAttributes(Map, OrderItemRequestDTO)}.
   * <p>
   * Method under test:
   * {@link OrderServiceImpl#compareAttributes(Map, OrderItemRequestDTO)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testCompareAttributes2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.order.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1041 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.order.service.OrderServiceImpl orderServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    OrderServiceImpl orderServiceImpl2 = new OrderServiceImpl();
    HashMap<String, OrderItemAttribute> item1Attributes = new HashMap<>();

    // Act
    orderServiceImpl2.compareAttributes(item1Attributes, new OrderItemRequestDTO());
  }

  /**
   * Test {@link OrderServiceImpl#findMatchingItem(Order, OrderItemRequestDTO)}.
   * <p>
   * Method under test:
   * {@link OrderServiceImpl#findMatchingItem(Order, OrderItemRequestDTO)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testFindMatchingItem() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.order.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1432 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.order.service.OrderServiceImpl orderServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    OrderServiceImpl orderServiceImpl2 = new OrderServiceImpl();
    NullOrderImpl order = new NullOrderImpl();

    // Act
    orderServiceImpl2.findMatchingItem(order, new OrderItemRequestDTO());
  }

  /**
   * Test {@link OrderServiceImpl#acquireLock(Order)}.
   * <p>
   * Method under test: {@link OrderServiceImpl#acquireLock(Order)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testAcquireLock() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.order.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass346 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.order.service.OrderServiceImpl orderServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    OrderServiceImpl orderServiceImpl2 = new OrderServiceImpl();

    // Act
    orderServiceImpl2.acquireLock(new NullOrderImpl());
  }

  /**
   * Test {@link OrderServiceImpl#findCartForCustomerWithEnhancements(Customer)}
   * with {@code customer}.
   * <p>
   * Method under test:
   * {@link OrderServiceImpl#findCartForCustomerWithEnhancements(Customer)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testFindCartForCustomerWithEnhancementsWithCustomer() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.order.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1342 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.order.service.OrderServiceImpl orderServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    OrderServiceImpl orderServiceImpl2 = new OrderServiceImpl();

    // Act
    orderServiceImpl2.findCartForCustomerWithEnhancements(new CustomerImpl());
  }

  /**
   * Test
   * {@link OrderServiceImpl#findCartForCustomerWithEnhancements(Customer, Order)}
   * with {@code customer}, {@code candidateOrder}.
   * <p>
   * Method under test:
   * {@link OrderServiceImpl#findCartForCustomerWithEnhancements(Customer, Order)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testFindCartForCustomerWithEnhancementsWithCustomerCandidateOrder() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.order.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1372 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.order.service.OrderServiceImpl orderServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    OrderServiceImpl orderServiceImpl2 = new OrderServiceImpl();
    CustomerImpl customer = new CustomerImpl();

    // Act
    orderServiceImpl2.findCartForCustomerWithEnhancements(customer, new NullOrderImpl());
  }
}
