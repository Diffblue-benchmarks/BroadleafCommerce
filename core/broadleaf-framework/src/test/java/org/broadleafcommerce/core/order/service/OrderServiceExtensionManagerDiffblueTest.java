package org.broadleafcommerce.core.order.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import org.broadleafcommerce.common.extension.ExtensionResultHolder;
import org.broadleafcommerce.common.extension.ExtensionResultStatusType;
import org.broadleafcommerce.core.offer.domain.OfferCode;
import org.broadleafcommerce.core.offer.domain.OfferCodeImpl;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.Order;
import org.broadleafcommerce.core.order.service.call.OrderItemRequestDTO;
import org.broadleafcommerce.profile.core.domain.Customer;
import org.broadleafcommerce.profile.core.domain.CustomerImpl;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml",
    "/bl-framework-applicationContext-persistence.xml", "/bl-framework-applicationContext-workflow.xml",
    "/bl-framework-applicationContext.xml", "/blc-config/admin/framework/bl-framework-admin-applicationContext.xml",
    "/blc-config/site/framework/bl-framework-applicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class OrderServiceExtensionManagerDiffblueTest {
  @Autowired
  private OrderServiceExtensionManager orderServiceExtensionManager;

  /**
   * Test {@link OrderServiceExtensionManager#continueOnHandled()}.
   * <p>
   * Method under test: {@link OrderServiceExtensionManager#continueOnHandled()}
   */
  @Test
  public void testContinueOnHandled() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new OrderServiceExtensionManager()).continueOnHandled());
  }

  /**
   * Test {@link OrderServiceExtensionManager#continueOnHandled()}.
   * <p>
   * Method under test: {@link OrderServiceExtensionManager#continueOnHandled()}
   */
  @Test
  public void testContinueOnHandled2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderServiceExtensionManager orderServiceExtensionManager = new OrderServiceExtensionManager();
    NullOrderImpl order = mock(NullOrderImpl.class);
    orderServiceExtensionManager.addOfferCodes(order, new ArrayList<>(), true);

    // Act and Assert
    assertTrue(orderServiceExtensionManager.continueOnHandled());
  }

  /**
   * Test {@link OrderServiceExtensionManager#continueOnHandled()}.
   * <p>
   * Method under test: {@link OrderServiceExtensionManager#continueOnHandled()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testContinueOnHandled3() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.order.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass68 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.order.service.OrderServiceExtensionManager orderServiceExtensionManager;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new OrderServiceExtensionManager()).continueOnHandled();
  }

  /**
   * Test
   * {@link OrderServiceExtensionManager#attachAdditionalDataToNewNamedCart(Customer, Order)}.
   * <p>
   * Method under test:
   * {@link OrderServiceExtensionManager#attachAdditionalDataToNewNamedCart(Customer, Order)}
   */
  @Test
  public void testAttachAdditionalDataToNewNamedCart() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderServiceExtensionManager orderServiceExtensionManager = new OrderServiceExtensionManager();
    orderServiceExtensionManager.registerHandler(new CartMessageOrderItemServiceExtensionHandler());
    NullOrderImpl order = new NullOrderImpl();
    orderServiceExtensionManager.addOfferCodes(order, new ArrayList<>(), true);
    CustomerImpl customer = new CustomerImpl();

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        orderServiceExtensionManager.attachAdditionalDataToNewNamedCart(customer, new NullOrderImpl()));
  }

  /**
   * Test
   * {@link OrderServiceExtensionManager#attachAdditionalDataToNewNamedCart(Customer, Order)}.
   * <p>
   * Method under test:
   * {@link OrderServiceExtensionManager#attachAdditionalDataToNewNamedCart(Customer, Order)}
   */
  @Test
  public void testAttachAdditionalDataToNewNamedCart2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderServiceExtensionManager orderServiceExtensionManager = new OrderServiceExtensionManager();
    orderServiceExtensionManager.registerHandler(new OrderServiceExtensionManager());
    NullOrderImpl order = new NullOrderImpl();
    orderServiceExtensionManager.addOfferCodes(order, new ArrayList<>(), true);
    CustomerImpl customer = new CustomerImpl();

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        orderServiceExtensionManager.attachAdditionalDataToNewNamedCart(customer, new NullOrderImpl()));
  }

  /**
   * Test
   * {@link OrderServiceExtensionManager#attachAdditionalDataToNewNamedCart(Customer, Order)}.
   * <p>
   * Method under test:
   * {@link OrderServiceExtensionManager#attachAdditionalDataToNewNamedCart(Customer, Order)}
   */
  @Test
  public void testAttachAdditionalDataToNewNamedCart3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CartMessageOrderItemServiceExtensionHandler cartMessageOrderItemServiceExtensionHandler = mock(
        CartMessageOrderItemServiceExtensionHandler.class);
    when(cartMessageOrderItemServiceExtensionHandler.addOfferCodes(Mockito.<Order>any(), Mockito.<List<OfferCode>>any(),
        anyBoolean())).thenReturn(ExtensionResultStatusType.HANDLED);
    when(cartMessageOrderItemServiceExtensionHandler.attachAdditionalDataToNewNamedCart(Mockito.<Customer>any(),
        Mockito.<Order>any())).thenReturn(ExtensionResultStatusType.HANDLED);
    when(cartMessageOrderItemServiceExtensionHandler.isEnabled()).thenReturn(true);

    OrderServiceExtensionManager orderServiceExtensionManager = new OrderServiceExtensionManager();
    orderServiceExtensionManager.registerHandler(cartMessageOrderItemServiceExtensionHandler);
    NullOrderImpl order = new NullOrderImpl();
    orderServiceExtensionManager.addOfferCodes(order, new ArrayList<>(), true);
    CustomerImpl customer = new CustomerImpl();

    // Act
    ExtensionResultStatusType actualAttachAdditionalDataToNewNamedCartResult = orderServiceExtensionManager
        .attachAdditionalDataToNewNamedCart(customer, new NullOrderImpl());

    // Assert
    verify(cartMessageOrderItemServiceExtensionHandler, atLeast(1)).isEnabled();
    verify(cartMessageOrderItemServiceExtensionHandler).addOfferCodes(isA(Order.class), isA(List.class), eq(true));
    verify(cartMessageOrderItemServiceExtensionHandler).attachAdditionalDataToNewNamedCart(isA(Customer.class),
        isA(Order.class));
    assertEquals(ExtensionResultStatusType.HANDLED, actualAttachAdditionalDataToNewNamedCartResult);
  }

  /**
   * Test
   * {@link OrderServiceExtensionManager#attachAdditionalDataToNewNamedCart(Customer, Order)}.
   * <p>
   * Method under test:
   * {@link OrderServiceExtensionManager#attachAdditionalDataToNewNamedCart(Customer, Order)}
   */
  @Test
  public void testAttachAdditionalDataToNewNamedCart4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CartMessageOrderItemServiceExtensionHandler cartMessageOrderItemServiceExtensionHandler = mock(
        CartMessageOrderItemServiceExtensionHandler.class);
    when(cartMessageOrderItemServiceExtensionHandler.addOfferCodes(Mockito.<Order>any(), Mockito.<List<OfferCode>>any(),
        anyBoolean())).thenReturn(ExtensionResultStatusType.HANDLED);
    when(cartMessageOrderItemServiceExtensionHandler.attachAdditionalDataToNewNamedCart(Mockito.<Customer>any(),
        Mockito.<Order>any())).thenReturn(ExtensionResultStatusType.HANDLED_STOP);
    when(cartMessageOrderItemServiceExtensionHandler.isEnabled()).thenReturn(true);

    OrderServiceExtensionManager orderServiceExtensionManager = new OrderServiceExtensionManager();
    orderServiceExtensionManager.registerHandler(cartMessageOrderItemServiceExtensionHandler);
    NullOrderImpl order = new NullOrderImpl();
    orderServiceExtensionManager.addOfferCodes(order, new ArrayList<>(), true);
    CustomerImpl customer = new CustomerImpl();

    // Act
    ExtensionResultStatusType actualAttachAdditionalDataToNewNamedCartResult = orderServiceExtensionManager
        .attachAdditionalDataToNewNamedCart(customer, new NullOrderImpl());

    // Assert
    verify(cartMessageOrderItemServiceExtensionHandler, atLeast(1)).isEnabled();
    verify(cartMessageOrderItemServiceExtensionHandler).addOfferCodes(isA(Order.class), isA(List.class), eq(true));
    verify(cartMessageOrderItemServiceExtensionHandler).attachAdditionalDataToNewNamedCart(isA(Customer.class),
        isA(Order.class));
    assertEquals(ExtensionResultStatusType.HANDLED, actualAttachAdditionalDataToNewNamedCartResult);
  }

  /**
   * Test
   * {@link OrderServiceExtensionManager#attachAdditionalDataToNewNamedCart(Customer, Order)}.
   * <p>
   * Method under test:
   * {@link OrderServiceExtensionManager#attachAdditionalDataToNewNamedCart(Customer, Order)}
   */
  @Test
  public void testAttachAdditionalDataToNewNamedCart5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CartMessageOrderItemServiceExtensionHandler cartMessageOrderItemServiceExtensionHandler = mock(
        CartMessageOrderItemServiceExtensionHandler.class);
    when(cartMessageOrderItemServiceExtensionHandler.isEnabled()).thenReturn(false);

    OrderServiceExtensionManager orderServiceExtensionManager = new OrderServiceExtensionManager();
    orderServiceExtensionManager.registerHandler(cartMessageOrderItemServiceExtensionHandler);
    NullOrderImpl order = new NullOrderImpl();
    orderServiceExtensionManager.addOfferCodes(order, new ArrayList<>(), true);
    CustomerImpl customer = new CustomerImpl();

    // Act
    ExtensionResultStatusType actualAttachAdditionalDataToNewNamedCartResult = orderServiceExtensionManager
        .attachAdditionalDataToNewNamedCart(customer, new NullOrderImpl());

    // Assert
    verify(cartMessageOrderItemServiceExtensionHandler, atLeast(1)).isEnabled();
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, actualAttachAdditionalDataToNewNamedCartResult);
  }

  /**
   * Test
   * {@link OrderServiceExtensionManager#attachAdditionalDataToNewNamedCart(Customer, Order)}.
   * <p>
   * Method under test:
   * {@link OrderServiceExtensionManager#attachAdditionalDataToNewNamedCart(Customer, Order)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testAttachAdditionalDataToNewNamedCart6() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.order.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass21 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.order.service.OrderServiceExtensionManager orderServiceExtensionManager;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    OrderServiceExtensionManager orderServiceExtensionManager2 = new OrderServiceExtensionManager();
    CustomerImpl customer = new CustomerImpl();

    // Act
    orderServiceExtensionManager2.attachAdditionalDataToNewNamedCart(customer, new NullOrderImpl());
  }

  /**
   * Test
   * {@link OrderServiceExtensionManager#attachAdditionalDataToNewNamedCart(Customer, Order)}.
   * <ul>
   *   <li>Given {@link OrderServiceExtensionManager} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OrderServiceExtensionManager#attachAdditionalDataToNewNamedCart(Customer, Order)}
   */
  @Test
  public void testAttachAdditionalDataToNewNamedCart_givenOrderServiceExtensionManager() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderServiceExtensionManager orderServiceExtensionManager = new OrderServiceExtensionManager();
    CustomerImpl customer = new CustomerImpl();

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        orderServiceExtensionManager.attachAdditionalDataToNewNamedCart(customer, new NullOrderImpl()));
  }

  /**
   * Test
   * {@link OrderServiceExtensionManager#attachAdditionalDataToNewNamedCart(Customer, Order)}.
   * <ul>
   *   <li>Given {@link OrderServiceExtensionManager} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OrderServiceExtensionManager#attachAdditionalDataToNewNamedCart(Customer, Order)}
   */
  @Test
  public void testAttachAdditionalDataToNewNamedCart_givenOrderServiceExtensionManager2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderServiceExtensionManager orderServiceExtensionManager = new OrderServiceExtensionManager();
    NullOrderImpl order = new NullOrderImpl();
    orderServiceExtensionManager.addOfferCodes(order, new ArrayList<>(), true);
    CustomerImpl customer = new CustomerImpl();

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        orderServiceExtensionManager.attachAdditionalDataToNewNamedCart(customer, new NullOrderImpl()));
  }

  /**
   * Test
   * {@link OrderServiceExtensionManager#attachAdditionalDataToNewNamedCart(Customer, Order)}.
   * <ul>
   *   <li>When {@link CustomerImpl}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OrderServiceExtensionManager#attachAdditionalDataToNewNamedCart(Customer, Order)}
   */
  @Test
  public void testAttachAdditionalDataToNewNamedCart_whenCustomerImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderServiceExtensionManager orderServiceExtensionManager = new OrderServiceExtensionManager();
    CustomerImpl customer = mock(CustomerImpl.class);

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        orderServiceExtensionManager.attachAdditionalDataToNewNamedCart(customer, new NullOrderImpl()));
  }

  /**
   * Test
   * {@link OrderServiceExtensionManager#preValidateCartOperation(Order, ExtensionResultHolder)}.
   * <p>
   * Method under test:
   * {@link OrderServiceExtensionManager#preValidateCartOperation(Order, ExtensionResultHolder)}
   */
  @Test
  public void testPreValidateCartOperation() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderServiceExtensionManager orderServiceExtensionManager = new OrderServiceExtensionManager();
    orderServiceExtensionManager.registerHandler(new CartMessageOrderItemServiceExtensionHandler());
    NullOrderImpl order = new NullOrderImpl();
    orderServiceExtensionManager.addOfferCodes(order, new ArrayList<>(), true);
    NullOrderImpl cart = new NullOrderImpl();

    ExtensionResultHolder erh = new ExtensionResultHolder();
    erh.setResult("Result");
    erh.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        orderServiceExtensionManager.preValidateCartOperation(cart, erh));
  }

  /**
   * Test
   * {@link OrderServiceExtensionManager#preValidateCartOperation(Order, ExtensionResultHolder)}.
   * <p>
   * Method under test:
   * {@link OrderServiceExtensionManager#preValidateCartOperation(Order, ExtensionResultHolder)}
   */
  @Test
  public void testPreValidateCartOperation2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderServiceExtensionManager orderServiceExtensionManager = new OrderServiceExtensionManager();
    orderServiceExtensionManager.registerHandler(new OrderServiceExtensionManager());
    NullOrderImpl order = new NullOrderImpl();
    orderServiceExtensionManager.addOfferCodes(order, new ArrayList<>(), true);
    NullOrderImpl cart = new NullOrderImpl();

    ExtensionResultHolder erh = new ExtensionResultHolder();
    erh.setResult("Result");
    erh.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        orderServiceExtensionManager.preValidateCartOperation(cart, erh));
  }

  /**
   * Test
   * {@link OrderServiceExtensionManager#preValidateCartOperation(Order, ExtensionResultHolder)}.
   * <p>
   * Method under test:
   * {@link OrderServiceExtensionManager#preValidateCartOperation(Order, ExtensionResultHolder)}
   */
  @Test
  public void testPreValidateCartOperation3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CartMessageOrderItemServiceExtensionHandler cartMessageOrderItemServiceExtensionHandler = mock(
        CartMessageOrderItemServiceExtensionHandler.class);
    when(cartMessageOrderItemServiceExtensionHandler.addOfferCodes(Mockito.<Order>any(), Mockito.<List<OfferCode>>any(),
        anyBoolean())).thenReturn(ExtensionResultStatusType.HANDLED);
    when(cartMessageOrderItemServiceExtensionHandler.preValidateCartOperation(Mockito.<Order>any(),
        Mockito.<ExtensionResultHolder<Object>>any())).thenReturn(ExtensionResultStatusType.HANDLED);
    when(cartMessageOrderItemServiceExtensionHandler.isEnabled()).thenReturn(true);

    OrderServiceExtensionManager orderServiceExtensionManager = new OrderServiceExtensionManager();
    orderServiceExtensionManager.registerHandler(cartMessageOrderItemServiceExtensionHandler);
    NullOrderImpl order = new NullOrderImpl();
    orderServiceExtensionManager.addOfferCodes(order, new ArrayList<>(), true);
    NullOrderImpl cart = new NullOrderImpl();

    ExtensionResultHolder erh = new ExtensionResultHolder();
    erh.setResult("Result");
    erh.setThrowable(new Throwable());

    // Act
    ExtensionResultStatusType actualPreValidateCartOperationResult = orderServiceExtensionManager
        .preValidateCartOperation(cart, erh);

    // Assert
    verify(cartMessageOrderItemServiceExtensionHandler, atLeast(1)).isEnabled();
    verify(cartMessageOrderItemServiceExtensionHandler).addOfferCodes(isA(Order.class), isA(List.class), eq(true));
    verify(cartMessageOrderItemServiceExtensionHandler).preValidateCartOperation(isA(Order.class),
        isA(ExtensionResultHolder.class));
    assertEquals(ExtensionResultStatusType.HANDLED, actualPreValidateCartOperationResult);
  }

  /**
   * Test
   * {@link OrderServiceExtensionManager#preValidateCartOperation(Order, ExtensionResultHolder)}.
   * <p>
   * Method under test:
   * {@link OrderServiceExtensionManager#preValidateCartOperation(Order, ExtensionResultHolder)}
   */
  @Test
  public void testPreValidateCartOperation4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CartMessageOrderItemServiceExtensionHandler cartMessageOrderItemServiceExtensionHandler = mock(
        CartMessageOrderItemServiceExtensionHandler.class);
    when(cartMessageOrderItemServiceExtensionHandler.addOfferCodes(Mockito.<Order>any(), Mockito.<List<OfferCode>>any(),
        anyBoolean())).thenReturn(ExtensionResultStatusType.HANDLED);
    when(cartMessageOrderItemServiceExtensionHandler.preValidateCartOperation(Mockito.<Order>any(),
        Mockito.<ExtensionResultHolder<Object>>any())).thenReturn(ExtensionResultStatusType.HANDLED_STOP);
    when(cartMessageOrderItemServiceExtensionHandler.isEnabled()).thenReturn(true);

    OrderServiceExtensionManager orderServiceExtensionManager = new OrderServiceExtensionManager();
    orderServiceExtensionManager.registerHandler(cartMessageOrderItemServiceExtensionHandler);
    NullOrderImpl order = new NullOrderImpl();
    orderServiceExtensionManager.addOfferCodes(order, new ArrayList<>(), true);
    NullOrderImpl cart = new NullOrderImpl();

    ExtensionResultHolder erh = new ExtensionResultHolder();
    erh.setResult("Result");
    erh.setThrowable(new Throwable());

    // Act
    ExtensionResultStatusType actualPreValidateCartOperationResult = orderServiceExtensionManager
        .preValidateCartOperation(cart, erh);

    // Assert
    verify(cartMessageOrderItemServiceExtensionHandler, atLeast(1)).isEnabled();
    verify(cartMessageOrderItemServiceExtensionHandler).addOfferCodes(isA(Order.class), isA(List.class), eq(true));
    verify(cartMessageOrderItemServiceExtensionHandler).preValidateCartOperation(isA(Order.class),
        isA(ExtensionResultHolder.class));
    assertEquals(ExtensionResultStatusType.HANDLED, actualPreValidateCartOperationResult);
  }

  /**
   * Test
   * {@link OrderServiceExtensionManager#preValidateCartOperation(Order, ExtensionResultHolder)}.
   * <p>
   * Method under test:
   * {@link OrderServiceExtensionManager#preValidateCartOperation(Order, ExtensionResultHolder)}
   */
  @Test
  public void testPreValidateCartOperation5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CartMessageOrderItemServiceExtensionHandler cartMessageOrderItemServiceExtensionHandler = mock(
        CartMessageOrderItemServiceExtensionHandler.class);
    when(cartMessageOrderItemServiceExtensionHandler.isEnabled()).thenReturn(false);

    OrderServiceExtensionManager orderServiceExtensionManager = new OrderServiceExtensionManager();
    orderServiceExtensionManager.registerHandler(cartMessageOrderItemServiceExtensionHandler);
    NullOrderImpl order = new NullOrderImpl();
    orderServiceExtensionManager.addOfferCodes(order, new ArrayList<>(), true);
    NullOrderImpl cart = new NullOrderImpl();

    ExtensionResultHolder erh = new ExtensionResultHolder();
    erh.setResult("Result");
    erh.setThrowable(new Throwable());

    // Act
    ExtensionResultStatusType actualPreValidateCartOperationResult = orderServiceExtensionManager
        .preValidateCartOperation(cart, erh);

    // Assert
    verify(cartMessageOrderItemServiceExtensionHandler, atLeast(1)).isEnabled();
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, actualPreValidateCartOperationResult);
  }

  /**
   * Test
   * {@link OrderServiceExtensionManager#preValidateCartOperation(Order, ExtensionResultHolder)}.
   * <p>
   * Method under test:
   * {@link OrderServiceExtensionManager#preValidateCartOperation(Order, ExtensionResultHolder)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testPreValidateCartOperation6() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.order.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass192 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.order.service.OrderServiceExtensionManager orderServiceExtensionManager;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    OrderServiceExtensionManager orderServiceExtensionManager2 = new OrderServiceExtensionManager();
    NullOrderImpl cart = new NullOrderImpl();

    ExtensionResultHolder erh = new ExtensionResultHolder();
    erh.setResult("Result");
    erh.setThrowable(new Throwable());

    // Act
    orderServiceExtensionManager2.preValidateCartOperation(cart, erh);
  }

  /**
   * Test
   * {@link OrderServiceExtensionManager#preValidateCartOperation(Order, ExtensionResultHolder)}.
   * <ul>
   *   <li>Given {@link OrderServiceExtensionManager} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OrderServiceExtensionManager#preValidateCartOperation(Order, ExtensionResultHolder)}
   */
  @Test
  public void testPreValidateCartOperation_givenOrderServiceExtensionManager() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderServiceExtensionManager orderServiceExtensionManager = new OrderServiceExtensionManager();
    NullOrderImpl cart = new NullOrderImpl();

    ExtensionResultHolder erh = new ExtensionResultHolder();
    erh.setResult("Result");
    erh.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        orderServiceExtensionManager.preValidateCartOperation(cart, erh));
  }

  /**
   * Test
   * {@link OrderServiceExtensionManager#preValidateCartOperation(Order, ExtensionResultHolder)}.
   * <ul>
   *   <li>Given {@link OrderServiceExtensionManager} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OrderServiceExtensionManager#preValidateCartOperation(Order, ExtensionResultHolder)}
   */
  @Test
  public void testPreValidateCartOperation_givenOrderServiceExtensionManager2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderServiceExtensionManager orderServiceExtensionManager = new OrderServiceExtensionManager();
    NullOrderImpl order = new NullOrderImpl();
    orderServiceExtensionManager.addOfferCodes(order, new ArrayList<>(), true);
    NullOrderImpl cart = new NullOrderImpl();

    ExtensionResultHolder erh = new ExtensionResultHolder();
    erh.setResult("Result");
    erh.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        orderServiceExtensionManager.preValidateCartOperation(cart, erh));
  }

  /**
   * Test
   * {@link OrderServiceExtensionManager#preValidateCartOperation(Order, ExtensionResultHolder)}.
   * <ul>
   *   <li>Given {@link OrderServiceExtensionManager} (default constructor).</li>
   *   <li>When {@link NullOrderImpl}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OrderServiceExtensionManager#preValidateCartOperation(Order, ExtensionResultHolder)}
   */
  @Test
  public void testPreValidateCartOperation_givenOrderServiceExtensionManager_whenNullOrderImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderServiceExtensionManager orderServiceExtensionManager = new OrderServiceExtensionManager();
    NullOrderImpl cart = mock(NullOrderImpl.class);

    ExtensionResultHolder erh = new ExtensionResultHolder();
    erh.setResult("Result");
    erh.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        orderServiceExtensionManager.preValidateCartOperation(cart, erh));
  }

  /**
   * Test
   * {@link OrderServiceExtensionManager#preValidateUpdateQuantityOperation(Order, OrderItemRequestDTO, ExtensionResultHolder)}.
   * <p>
   * Method under test:
   * {@link OrderServiceExtensionManager#preValidateUpdateQuantityOperation(Order, OrderItemRequestDTO, ExtensionResultHolder)}
   */
  @Test
  public void testPreValidateUpdateQuantityOperation() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderServiceExtensionManager orderServiceExtensionManager = new OrderServiceExtensionManager();
    orderServiceExtensionManager.registerHandler(new CartMessageOrderItemServiceExtensionHandler());
    NullOrderImpl order = new NullOrderImpl();
    orderServiceExtensionManager.addOfferCodes(order, new ArrayList<>(), true);
    NullOrderImpl cart = new NullOrderImpl();
    OrderItemRequestDTO dto = new OrderItemRequestDTO();

    ExtensionResultHolder erh = new ExtensionResultHolder();
    erh.setResult("Result");
    erh.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        orderServiceExtensionManager.preValidateUpdateQuantityOperation(cart, dto, erh));
  }

  /**
   * Test
   * {@link OrderServiceExtensionManager#preValidateUpdateQuantityOperation(Order, OrderItemRequestDTO, ExtensionResultHolder)}.
   * <p>
   * Method under test:
   * {@link OrderServiceExtensionManager#preValidateUpdateQuantityOperation(Order, OrderItemRequestDTO, ExtensionResultHolder)}
   */
  @Test
  public void testPreValidateUpdateQuantityOperation2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderServiceExtensionManager orderServiceExtensionManager = new OrderServiceExtensionManager();
    orderServiceExtensionManager.registerHandler(new OrderServiceExtensionManager());
    NullOrderImpl order = new NullOrderImpl();
    orderServiceExtensionManager.addOfferCodes(order, new ArrayList<>(), true);
    NullOrderImpl cart = new NullOrderImpl();
    OrderItemRequestDTO dto = new OrderItemRequestDTO();

    ExtensionResultHolder erh = new ExtensionResultHolder();
    erh.setResult("Result");
    erh.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        orderServiceExtensionManager.preValidateUpdateQuantityOperation(cart, dto, erh));
  }

  /**
   * Test
   * {@link OrderServiceExtensionManager#preValidateUpdateQuantityOperation(Order, OrderItemRequestDTO, ExtensionResultHolder)}.
   * <p>
   * Method under test:
   * {@link OrderServiceExtensionManager#preValidateUpdateQuantityOperation(Order, OrderItemRequestDTO, ExtensionResultHolder)}
   */
  @Test
  public void testPreValidateUpdateQuantityOperation3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CartMessageOrderItemServiceExtensionHandler cartMessageOrderItemServiceExtensionHandler = mock(
        CartMessageOrderItemServiceExtensionHandler.class);
    when(cartMessageOrderItemServiceExtensionHandler.addOfferCodes(Mockito.<Order>any(), Mockito.<List<OfferCode>>any(),
        anyBoolean())).thenReturn(ExtensionResultStatusType.HANDLED);
    when(cartMessageOrderItemServiceExtensionHandler.preValidateUpdateQuantityOperation(Mockito.<Order>any(),
        Mockito.<OrderItemRequestDTO>any(), Mockito.<ExtensionResultHolder<Object>>any()))
            .thenReturn(ExtensionResultStatusType.HANDLED);
    when(cartMessageOrderItemServiceExtensionHandler.isEnabled()).thenReturn(true);

    OrderServiceExtensionManager orderServiceExtensionManager = new OrderServiceExtensionManager();
    orderServiceExtensionManager.registerHandler(cartMessageOrderItemServiceExtensionHandler);
    NullOrderImpl order = new NullOrderImpl();
    orderServiceExtensionManager.addOfferCodes(order, new ArrayList<>(), true);
    NullOrderImpl cart = new NullOrderImpl();
    OrderItemRequestDTO dto = new OrderItemRequestDTO();

    ExtensionResultHolder erh = new ExtensionResultHolder();
    erh.setResult("Result");
    erh.setThrowable(new Throwable());

    // Act
    ExtensionResultStatusType actualPreValidateUpdateQuantityOperationResult = orderServiceExtensionManager
        .preValidateUpdateQuantityOperation(cart, dto, erh);

    // Assert
    verify(cartMessageOrderItemServiceExtensionHandler, atLeast(1)).isEnabled();
    verify(cartMessageOrderItemServiceExtensionHandler).addOfferCodes(isA(Order.class), isA(List.class), eq(true));
    verify(cartMessageOrderItemServiceExtensionHandler).preValidateUpdateQuantityOperation(isA(Order.class),
        isA(OrderItemRequestDTO.class), isA(ExtensionResultHolder.class));
    assertEquals(ExtensionResultStatusType.HANDLED, actualPreValidateUpdateQuantityOperationResult);
  }

  /**
   * Test
   * {@link OrderServiceExtensionManager#preValidateUpdateQuantityOperation(Order, OrderItemRequestDTO, ExtensionResultHolder)}.
   * <p>
   * Method under test:
   * {@link OrderServiceExtensionManager#preValidateUpdateQuantityOperation(Order, OrderItemRequestDTO, ExtensionResultHolder)}
   */
  @Test
  public void testPreValidateUpdateQuantityOperation4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CartMessageOrderItemServiceExtensionHandler cartMessageOrderItemServiceExtensionHandler = mock(
        CartMessageOrderItemServiceExtensionHandler.class);
    when(cartMessageOrderItemServiceExtensionHandler.addOfferCodes(Mockito.<Order>any(), Mockito.<List<OfferCode>>any(),
        anyBoolean())).thenReturn(ExtensionResultStatusType.HANDLED);
    when(cartMessageOrderItemServiceExtensionHandler.preValidateUpdateQuantityOperation(Mockito.<Order>any(),
        Mockito.<OrderItemRequestDTO>any(), Mockito.<ExtensionResultHolder<Object>>any()))
            .thenReturn(ExtensionResultStatusType.HANDLED_STOP);
    when(cartMessageOrderItemServiceExtensionHandler.isEnabled()).thenReturn(true);

    OrderServiceExtensionManager orderServiceExtensionManager = new OrderServiceExtensionManager();
    orderServiceExtensionManager.registerHandler(cartMessageOrderItemServiceExtensionHandler);
    NullOrderImpl order = new NullOrderImpl();
    orderServiceExtensionManager.addOfferCodes(order, new ArrayList<>(), true);
    NullOrderImpl cart = new NullOrderImpl();
    OrderItemRequestDTO dto = new OrderItemRequestDTO();

    ExtensionResultHolder erh = new ExtensionResultHolder();
    erh.setResult("Result");
    erh.setThrowable(new Throwable());

    // Act
    ExtensionResultStatusType actualPreValidateUpdateQuantityOperationResult = orderServiceExtensionManager
        .preValidateUpdateQuantityOperation(cart, dto, erh);

    // Assert
    verify(cartMessageOrderItemServiceExtensionHandler, atLeast(1)).isEnabled();
    verify(cartMessageOrderItemServiceExtensionHandler).addOfferCodes(isA(Order.class), isA(List.class), eq(true));
    verify(cartMessageOrderItemServiceExtensionHandler).preValidateUpdateQuantityOperation(isA(Order.class),
        isA(OrderItemRequestDTO.class), isA(ExtensionResultHolder.class));
    assertEquals(ExtensionResultStatusType.HANDLED, actualPreValidateUpdateQuantityOperationResult);
  }

  /**
   * Test
   * {@link OrderServiceExtensionManager#preValidateUpdateQuantityOperation(Order, OrderItemRequestDTO, ExtensionResultHolder)}.
   * <p>
   * Method under test:
   * {@link OrderServiceExtensionManager#preValidateUpdateQuantityOperation(Order, OrderItemRequestDTO, ExtensionResultHolder)}
   */
  @Test
  public void testPreValidateUpdateQuantityOperation5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CartMessageOrderItemServiceExtensionHandler cartMessageOrderItemServiceExtensionHandler = mock(
        CartMessageOrderItemServiceExtensionHandler.class);
    when(cartMessageOrderItemServiceExtensionHandler.isEnabled()).thenReturn(false);

    OrderServiceExtensionManager orderServiceExtensionManager = new OrderServiceExtensionManager();
    orderServiceExtensionManager.registerHandler(cartMessageOrderItemServiceExtensionHandler);
    NullOrderImpl order = new NullOrderImpl();
    orderServiceExtensionManager.addOfferCodes(order, new ArrayList<>(), true);
    NullOrderImpl cart = new NullOrderImpl();
    OrderItemRequestDTO dto = new OrderItemRequestDTO();

    ExtensionResultHolder erh = new ExtensionResultHolder();
    erh.setResult("Result");
    erh.setThrowable(new Throwable());

    // Act
    ExtensionResultStatusType actualPreValidateUpdateQuantityOperationResult = orderServiceExtensionManager
        .preValidateUpdateQuantityOperation(cart, dto, erh);

    // Assert
    verify(cartMessageOrderItemServiceExtensionHandler, atLeast(1)).isEnabled();
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, actualPreValidateUpdateQuantityOperationResult);
  }

  /**
   * Test
   * {@link OrderServiceExtensionManager#preValidateUpdateQuantityOperation(Order, OrderItemRequestDTO, ExtensionResultHolder)}.
   * <p>
   * Method under test:
   * {@link OrderServiceExtensionManager#preValidateUpdateQuantityOperation(Order, OrderItemRequestDTO, ExtensionResultHolder)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testPreValidateUpdateQuantityOperation6() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.order.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass256 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.order.service.OrderServiceExtensionManager orderServiceExtensionManager;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    OrderServiceExtensionManager orderServiceExtensionManager2 = new OrderServiceExtensionManager();
    NullOrderImpl cart = new NullOrderImpl();
    OrderItemRequestDTO dto = new OrderItemRequestDTO();

    ExtensionResultHolder erh = new ExtensionResultHolder();
    erh.setResult("Result");
    erh.setThrowable(new Throwable());

    // Act
    orderServiceExtensionManager2.preValidateUpdateQuantityOperation(cart, dto, erh);
  }

  /**
   * Test
   * {@link OrderServiceExtensionManager#preValidateUpdateQuantityOperation(Order, OrderItemRequestDTO, ExtensionResultHolder)}.
   * <ul>
   *   <li>Given {@link OrderServiceExtensionManager} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OrderServiceExtensionManager#preValidateUpdateQuantityOperation(Order, OrderItemRequestDTO, ExtensionResultHolder)}
   */
  @Test
  public void testPreValidateUpdateQuantityOperation_givenOrderServiceExtensionManager() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderServiceExtensionManager orderServiceExtensionManager = new OrderServiceExtensionManager();
    NullOrderImpl cart = new NullOrderImpl();
    OrderItemRequestDTO dto = new OrderItemRequestDTO();

    ExtensionResultHolder erh = new ExtensionResultHolder();
    erh.setResult("Result");
    erh.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        orderServiceExtensionManager.preValidateUpdateQuantityOperation(cart, dto, erh));
  }

  /**
   * Test
   * {@link OrderServiceExtensionManager#preValidateUpdateQuantityOperation(Order, OrderItemRequestDTO, ExtensionResultHolder)}.
   * <ul>
   *   <li>Given {@link OrderServiceExtensionManager} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OrderServiceExtensionManager#preValidateUpdateQuantityOperation(Order, OrderItemRequestDTO, ExtensionResultHolder)}
   */
  @Test
  public void testPreValidateUpdateQuantityOperation_givenOrderServiceExtensionManager2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderServiceExtensionManager orderServiceExtensionManager = new OrderServiceExtensionManager();
    NullOrderImpl order = new NullOrderImpl();
    orderServiceExtensionManager.addOfferCodes(order, new ArrayList<>(), true);
    NullOrderImpl cart = new NullOrderImpl();
    OrderItemRequestDTO dto = new OrderItemRequestDTO();

    ExtensionResultHolder erh = new ExtensionResultHolder();
    erh.setResult("Result");
    erh.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        orderServiceExtensionManager.preValidateUpdateQuantityOperation(cart, dto, erh));
  }

  /**
   * Test
   * {@link OrderServiceExtensionManager#preValidateUpdateQuantityOperation(Order, OrderItemRequestDTO, ExtensionResultHolder)}.
   * <ul>
   *   <li>When {@link NullOrderImpl}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OrderServiceExtensionManager#preValidateUpdateQuantityOperation(Order, OrderItemRequestDTO, ExtensionResultHolder)}
   */
  @Test
  public void testPreValidateUpdateQuantityOperation_whenNullOrderImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderServiceExtensionManager orderServiceExtensionManager = new OrderServiceExtensionManager();
    NullOrderImpl cart = mock(NullOrderImpl.class);
    OrderItemRequestDTO dto = new OrderItemRequestDTO();

    ExtensionResultHolder erh = new ExtensionResultHolder();
    erh.setResult("Result");
    erh.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        orderServiceExtensionManager.preValidateUpdateQuantityOperation(cart, dto, erh));
  }

  /**
   * Test
   * {@link OrderServiceExtensionManager#attachAdditionalDataToOrder(Order, boolean)}.
   * <p>
   * Method under test:
   * {@link OrderServiceExtensionManager#attachAdditionalDataToOrder(Order, boolean)}
   */
  @Test
  public void testAttachAdditionalDataToOrder() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderServiceExtensionManager orderServiceExtensionManager = new OrderServiceExtensionManager();
    orderServiceExtensionManager.registerHandler(new OrderServiceExtensionManager());
    NullOrderImpl order = new NullOrderImpl();
    orderServiceExtensionManager.addOfferCodes(order, new ArrayList<>(), true);

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        orderServiceExtensionManager.attachAdditionalDataToOrder(new NullOrderImpl(), true));
  }

  /**
   * Test
   * {@link OrderServiceExtensionManager#attachAdditionalDataToOrder(Order, boolean)}.
   * <p>
   * Method under test:
   * {@link OrderServiceExtensionManager#attachAdditionalDataToOrder(Order, boolean)}
   */
  @Test
  public void testAttachAdditionalDataToOrder2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CartMessageOrderItemServiceExtensionHandler cartMessageOrderItemServiceExtensionHandler = mock(
        CartMessageOrderItemServiceExtensionHandler.class);
    when(cartMessageOrderItemServiceExtensionHandler.addOfferCodes(Mockito.<Order>any(), Mockito.<List<OfferCode>>any(),
        anyBoolean())).thenReturn(ExtensionResultStatusType.HANDLED);
    when(cartMessageOrderItemServiceExtensionHandler.attachAdditionalDataToOrder(Mockito.<Order>any(), anyBoolean()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(cartMessageOrderItemServiceExtensionHandler.isEnabled()).thenReturn(true);

    OrderServiceExtensionManager orderServiceExtensionManager = new OrderServiceExtensionManager();
    orderServiceExtensionManager.registerHandler(cartMessageOrderItemServiceExtensionHandler);
    NullOrderImpl order = new NullOrderImpl();
    orderServiceExtensionManager.addOfferCodes(order, new ArrayList<>(), true);

    // Act
    ExtensionResultStatusType actualAttachAdditionalDataToOrderResult = orderServiceExtensionManager
        .attachAdditionalDataToOrder(new NullOrderImpl(), true);

    // Assert
    verify(cartMessageOrderItemServiceExtensionHandler, atLeast(1)).isEnabled();
    verify(cartMessageOrderItemServiceExtensionHandler).addOfferCodes(isA(Order.class), isA(List.class), eq(true));
    verify(cartMessageOrderItemServiceExtensionHandler).attachAdditionalDataToOrder(isA(Order.class), eq(true));
    assertEquals(ExtensionResultStatusType.HANDLED, actualAttachAdditionalDataToOrderResult);
  }

  /**
   * Test
   * {@link OrderServiceExtensionManager#attachAdditionalDataToOrder(Order, boolean)}.
   * <p>
   * Method under test:
   * {@link OrderServiceExtensionManager#attachAdditionalDataToOrder(Order, boolean)}
   */
  @Test
  public void testAttachAdditionalDataToOrder3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CartMessageOrderItemServiceExtensionHandler cartMessageOrderItemServiceExtensionHandler = mock(
        CartMessageOrderItemServiceExtensionHandler.class);
    when(cartMessageOrderItemServiceExtensionHandler.addOfferCodes(Mockito.<Order>any(), Mockito.<List<OfferCode>>any(),
        anyBoolean())).thenReturn(ExtensionResultStatusType.HANDLED);
    when(cartMessageOrderItemServiceExtensionHandler.attachAdditionalDataToOrder(Mockito.<Order>any(), anyBoolean()))
        .thenReturn(ExtensionResultStatusType.HANDLED_STOP);
    when(cartMessageOrderItemServiceExtensionHandler.isEnabled()).thenReturn(true);

    OrderServiceExtensionManager orderServiceExtensionManager = new OrderServiceExtensionManager();
    orderServiceExtensionManager.registerHandler(cartMessageOrderItemServiceExtensionHandler);
    NullOrderImpl order = new NullOrderImpl();
    orderServiceExtensionManager.addOfferCodes(order, new ArrayList<>(), true);

    // Act
    ExtensionResultStatusType actualAttachAdditionalDataToOrderResult = orderServiceExtensionManager
        .attachAdditionalDataToOrder(new NullOrderImpl(), true);

    // Assert
    verify(cartMessageOrderItemServiceExtensionHandler, atLeast(1)).isEnabled();
    verify(cartMessageOrderItemServiceExtensionHandler).addOfferCodes(isA(Order.class), isA(List.class), eq(true));
    verify(cartMessageOrderItemServiceExtensionHandler).attachAdditionalDataToOrder(isA(Order.class), eq(true));
    assertEquals(ExtensionResultStatusType.HANDLED, actualAttachAdditionalDataToOrderResult);
  }

  /**
   * Test
   * {@link OrderServiceExtensionManager#attachAdditionalDataToOrder(Order, boolean)}.
   * <p>
   * Method under test:
   * {@link OrderServiceExtensionManager#attachAdditionalDataToOrder(Order, boolean)}
   */
  @Test
  public void testAttachAdditionalDataToOrder4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CartMessageOrderItemServiceExtensionHandler cartMessageOrderItemServiceExtensionHandler = mock(
        CartMessageOrderItemServiceExtensionHandler.class);
    when(cartMessageOrderItemServiceExtensionHandler.isEnabled()).thenReturn(false);

    OrderServiceExtensionManager orderServiceExtensionManager = new OrderServiceExtensionManager();
    orderServiceExtensionManager.registerHandler(cartMessageOrderItemServiceExtensionHandler);
    NullOrderImpl order = new NullOrderImpl();
    orderServiceExtensionManager.addOfferCodes(order, new ArrayList<>(), true);

    // Act
    ExtensionResultStatusType actualAttachAdditionalDataToOrderResult = orderServiceExtensionManager
        .attachAdditionalDataToOrder(new NullOrderImpl(), true);

    // Assert
    verify(cartMessageOrderItemServiceExtensionHandler, atLeast(1)).isEnabled();
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, actualAttachAdditionalDataToOrderResult);
  }

  /**
   * Test
   * {@link OrderServiceExtensionManager#attachAdditionalDataToOrder(Order, boolean)}.
   * <p>
   * Method under test:
   * {@link OrderServiceExtensionManager#attachAdditionalDataToOrder(Order, boolean)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testAttachAdditionalDataToOrder5() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.order.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass51 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.order.service.OrderServiceExtensionManager orderServiceExtensionManager;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    OrderServiceExtensionManager orderServiceExtensionManager2 = new OrderServiceExtensionManager();

    // Act
    orderServiceExtensionManager2.attachAdditionalDataToOrder(new NullOrderImpl(), true);
  }

  /**
   * Test
   * {@link OrderServiceExtensionManager#attachAdditionalDataToOrder(Order, boolean)}.
   * <ul>
   *   <li>Given {@link OrderServiceExtensionManager} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OrderServiceExtensionManager#attachAdditionalDataToOrder(Order, boolean)}
   */
  @Test
  public void testAttachAdditionalDataToOrder_givenOrderServiceExtensionManager() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderServiceExtensionManager orderServiceExtensionManager = new OrderServiceExtensionManager();

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        orderServiceExtensionManager.attachAdditionalDataToOrder(new NullOrderImpl(), true));
  }

  /**
   * Test
   * {@link OrderServiceExtensionManager#attachAdditionalDataToOrder(Order, boolean)}.
   * <ul>
   *   <li>Given {@link OrderServiceExtensionManager} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OrderServiceExtensionManager#attachAdditionalDataToOrder(Order, boolean)}
   */
  @Test
  public void testAttachAdditionalDataToOrder_givenOrderServiceExtensionManager2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderServiceExtensionManager orderServiceExtensionManager = new OrderServiceExtensionManager();
    NullOrderImpl order = new NullOrderImpl();
    orderServiceExtensionManager.addOfferCodes(order, new ArrayList<>(), true);

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        orderServiceExtensionManager.attachAdditionalDataToOrder(new NullOrderImpl(), true));
  }

  /**
   * Test
   * {@link OrderServiceExtensionManager#attachAdditionalDataToOrder(Order, boolean)}.
   * <ul>
   *   <li>When {@link NullOrderImpl}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OrderServiceExtensionManager#attachAdditionalDataToOrder(Order, boolean)}
   */
  @Test
  public void testAttachAdditionalDataToOrder_whenNullOrderImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        (new OrderServiceExtensionManager()).attachAdditionalDataToOrder(mock(NullOrderImpl.class), true));
  }

  /**
   * Test
   * {@link OrderServiceExtensionManager#addOfferCodes(Order, List, boolean)}.
   * <p>
   * Method under test:
   * {@link OrderServiceExtensionManager#addOfferCodes(Order, List, boolean)}
   */
  @Test
  public void testAddOfferCodes() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderServiceExtensionManager orderServiceExtensionManager = new OrderServiceExtensionManager();
    orderServiceExtensionManager.registerHandler(new CartMessageOrderItemServiceExtensionHandler());
    NullOrderImpl order = new NullOrderImpl();
    orderServiceExtensionManager.addOfferCodes(order, new ArrayList<>(), true);
    NullOrderImpl order2 = new NullOrderImpl();

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        orderServiceExtensionManager.addOfferCodes(order2, new ArrayList<>(), true));
  }

  /**
   * Test
   * {@link OrderServiceExtensionManager#addOfferCodes(Order, List, boolean)}.
   * <p>
   * Method under test:
   * {@link OrderServiceExtensionManager#addOfferCodes(Order, List, boolean)}
   */
  @Test
  public void testAddOfferCodes2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderServiceExtensionManager orderServiceExtensionManager = new OrderServiceExtensionManager();
    orderServiceExtensionManager.registerHandler(new OrderServiceExtensionManager());
    NullOrderImpl order = new NullOrderImpl();
    orderServiceExtensionManager.addOfferCodes(order, new ArrayList<>(), true);
    NullOrderImpl order2 = new NullOrderImpl();

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        orderServiceExtensionManager.addOfferCodes(order2, new ArrayList<>(), true));
  }

  /**
   * Test
   * {@link OrderServiceExtensionManager#addOfferCodes(Order, List, boolean)}.
   * <p>
   * Method under test:
   * {@link OrderServiceExtensionManager#addOfferCodes(Order, List, boolean)}
   */
  @Test
  public void testAddOfferCodes3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CartMessageOrderItemServiceExtensionHandler cartMessageOrderItemServiceExtensionHandler = mock(
        CartMessageOrderItemServiceExtensionHandler.class);
    when(cartMessageOrderItemServiceExtensionHandler.addOfferCodes(Mockito.<Order>any(), Mockito.<List<OfferCode>>any(),
        anyBoolean())).thenReturn(ExtensionResultStatusType.HANDLED);
    when(cartMessageOrderItemServiceExtensionHandler.isEnabled()).thenReturn(true);

    OrderServiceExtensionManager orderServiceExtensionManager = new OrderServiceExtensionManager();
    orderServiceExtensionManager.registerHandler(cartMessageOrderItemServiceExtensionHandler);
    NullOrderImpl order = new NullOrderImpl();
    orderServiceExtensionManager.addOfferCodes(order, new ArrayList<>(), true);
    NullOrderImpl order2 = new NullOrderImpl();

    // Act
    ExtensionResultStatusType actualAddOfferCodesResult = orderServiceExtensionManager.addOfferCodes(order2,
        new ArrayList<>(), true);

    // Assert
    verify(cartMessageOrderItemServiceExtensionHandler, atLeast(1)).isEnabled();
    verify(cartMessageOrderItemServiceExtensionHandler, atLeast(1)).addOfferCodes(Mockito.<Order>any(), isA(List.class),
        eq(true));
    assertEquals(ExtensionResultStatusType.HANDLED, actualAddOfferCodesResult);
  }

  /**
   * Test
   * {@link OrderServiceExtensionManager#addOfferCodes(Order, List, boolean)}.
   * <p>
   * Method under test:
   * {@link OrderServiceExtensionManager#addOfferCodes(Order, List, boolean)}
   */
  @Test
  public void testAddOfferCodes4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CartMessageOrderItemServiceExtensionHandler cartMessageOrderItemServiceExtensionHandler = mock(
        CartMessageOrderItemServiceExtensionHandler.class);
    when(cartMessageOrderItemServiceExtensionHandler.addOfferCodes(Mockito.<Order>any(), Mockito.<List<OfferCode>>any(),
        anyBoolean())).thenReturn(ExtensionResultStatusType.HANDLED_STOP);
    when(cartMessageOrderItemServiceExtensionHandler.isEnabled()).thenReturn(true);

    OrderServiceExtensionManager orderServiceExtensionManager = new OrderServiceExtensionManager();
    orderServiceExtensionManager.registerHandler(cartMessageOrderItemServiceExtensionHandler);
    NullOrderImpl order = new NullOrderImpl();
    orderServiceExtensionManager.addOfferCodes(order, new ArrayList<>(), true);
    NullOrderImpl order2 = new NullOrderImpl();

    // Act
    ExtensionResultStatusType actualAddOfferCodesResult = orderServiceExtensionManager.addOfferCodes(order2,
        new ArrayList<>(), true);

    // Assert
    verify(cartMessageOrderItemServiceExtensionHandler, atLeast(1)).isEnabled();
    verify(cartMessageOrderItemServiceExtensionHandler, atLeast(1)).addOfferCodes(Mockito.<Order>any(), isA(List.class),
        eq(true));
    assertEquals(ExtensionResultStatusType.HANDLED, actualAddOfferCodesResult);
  }

  /**
   * Test
   * {@link OrderServiceExtensionManager#addOfferCodes(Order, List, boolean)}.
   * <p>
   * Method under test:
   * {@link OrderServiceExtensionManager#addOfferCodes(Order, List, boolean)}
   */
  @Test
  public void testAddOfferCodes5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CartMessageOrderItemServiceExtensionHandler cartMessageOrderItemServiceExtensionHandler = mock(
        CartMessageOrderItemServiceExtensionHandler.class);
    when(cartMessageOrderItemServiceExtensionHandler.isEnabled()).thenReturn(false);

    OrderServiceExtensionManager orderServiceExtensionManager = new OrderServiceExtensionManager();
    orderServiceExtensionManager.registerHandler(cartMessageOrderItemServiceExtensionHandler);
    NullOrderImpl order = new NullOrderImpl();
    orderServiceExtensionManager.addOfferCodes(order, new ArrayList<>(), true);
    NullOrderImpl order2 = new NullOrderImpl();

    // Act
    ExtensionResultStatusType actualAddOfferCodesResult = orderServiceExtensionManager.addOfferCodes(order2,
        new ArrayList<>(), true);

    // Assert
    verify(cartMessageOrderItemServiceExtensionHandler, atLeast(1)).isEnabled();
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, actualAddOfferCodesResult);
  }

  /**
   * Test
   * {@link OrderServiceExtensionManager#addOfferCodes(Order, List, boolean)}.
   * <p>
   * Method under test:
   * {@link OrderServiceExtensionManager#addOfferCodes(Order, List, boolean)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testAddOfferCodes6() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.order.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass0 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.order.service.OrderServiceExtensionManager orderServiceExtensionManager;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    OrderServiceExtensionManager orderServiceExtensionManager2 = new OrderServiceExtensionManager();
    NullOrderImpl order = new NullOrderImpl();

    // Act
    orderServiceExtensionManager2.addOfferCodes(order, new ArrayList<>(), true);
  }

  /**
   * Test
   * {@link OrderServiceExtensionManager#addOfferCodes(Order, List, boolean)}.
   * <ul>
   *   <li>Given {@link OfferCodeImpl} (default constructor).</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link OfferCodeImpl} (default
   * constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OrderServiceExtensionManager#addOfferCodes(Order, List, boolean)}
   */
  @Test
  public void testAddOfferCodes_givenOfferCodeImpl_whenArrayListAddOfferCodeImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderServiceExtensionManager orderServiceExtensionManager = new OrderServiceExtensionManager();
    NullOrderImpl order = new NullOrderImpl();

    ArrayList<OfferCode> offerCodes = new ArrayList<>();
    offerCodes.add(new OfferCodeImpl());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        orderServiceExtensionManager.addOfferCodes(order, offerCodes, true));
  }

  /**
   * Test
   * {@link OrderServiceExtensionManager#addOfferCodes(Order, List, boolean)}.
   * <ul>
   *   <li>Given {@link OfferCodeImpl} (default constructor).</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link OfferCodeImpl} (default
   * constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OrderServiceExtensionManager#addOfferCodes(Order, List, boolean)}
   */
  @Test
  public void testAddOfferCodes_givenOfferCodeImpl_whenArrayListAddOfferCodeImpl2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderServiceExtensionManager orderServiceExtensionManager = new OrderServiceExtensionManager();
    NullOrderImpl order = new NullOrderImpl();

    ArrayList<OfferCode> offerCodes = new ArrayList<>();
    offerCodes.add(new OfferCodeImpl());
    offerCodes.add(new OfferCodeImpl());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        orderServiceExtensionManager.addOfferCodes(order, offerCodes, true));
  }

  /**
   * Test
   * {@link OrderServiceExtensionManager#addOfferCodes(Order, List, boolean)}.
   * <ul>
   *   <li>Given {@link OrderServiceExtensionManager} (default constructor).</li>
   *   <li>Then return {@code NOT_HANDLED}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OrderServiceExtensionManager#addOfferCodes(Order, List, boolean)}
   */
  @Test
  public void testAddOfferCodes_givenOrderServiceExtensionManager_thenReturnNotHandled() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderServiceExtensionManager orderServiceExtensionManager = new OrderServiceExtensionManager();
    NullOrderImpl order = new NullOrderImpl();

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        orderServiceExtensionManager.addOfferCodes(order, new ArrayList<>(), true));
  }

  /**
   * Test
   * {@link OrderServiceExtensionManager#addOfferCodes(Order, List, boolean)}.
   * <ul>
   *   <li>Given {@link OrderServiceExtensionManager} (default constructor).</li>
   *   <li>Then return {@code NOT_HANDLED}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OrderServiceExtensionManager#addOfferCodes(Order, List, boolean)}
   */
  @Test
  public void testAddOfferCodes_givenOrderServiceExtensionManager_thenReturnNotHandled2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderServiceExtensionManager orderServiceExtensionManager = new OrderServiceExtensionManager();
    NullOrderImpl order = new NullOrderImpl();
    orderServiceExtensionManager.addOfferCodes(order, new ArrayList<>(), true);
    NullOrderImpl order2 = new NullOrderImpl();

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        orderServiceExtensionManager.addOfferCodes(order2, new ArrayList<>(), true));
  }

  /**
   * Test
   * {@link OrderServiceExtensionManager#addOfferCodes(Order, List, boolean)}.
   * <ul>
   *   <li>Given {@link OrderServiceExtensionManager} (default constructor).</li>
   *   <li>When {@link NullOrderImpl}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OrderServiceExtensionManager#addOfferCodes(Order, List, boolean)}
   */
  @Test
  public void testAddOfferCodes_givenOrderServiceExtensionManager_whenNullOrderImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderServiceExtensionManager orderServiceExtensionManager = new OrderServiceExtensionManager();
    NullOrderImpl order = mock(NullOrderImpl.class);

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        orderServiceExtensionManager.addOfferCodes(order, new ArrayList<>(), true));
  }

  /**
   * Test
   * {@link OrderServiceExtensionManager#findCartForCustomerWithEnhancements(Customer, Order, ExtensionResultHolder)}
   * with {@code customer}, {@code candidateCart}, {@code erh}.
   * <p>
   * Method under test:
   * {@link OrderServiceExtensionManager#findCartForCustomerWithEnhancements(Customer, Order, ExtensionResultHolder)}
   */
  @Test
  public void testFindCartForCustomerWithEnhancementsWithCustomerCandidateCartErh() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderServiceExtensionManager orderServiceExtensionManager = new OrderServiceExtensionManager();
    CustomerImpl customer = new CustomerImpl();
    NullOrderImpl candidateCart = new NullOrderImpl();

    ExtensionResultHolder erh = new ExtensionResultHolder();
    erh.setResult("Result");
    erh.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        orderServiceExtensionManager.findCartForCustomerWithEnhancements(customer, candidateCart, erh));
  }

  /**
   * Test
   * {@link OrderServiceExtensionManager#findCartForCustomerWithEnhancements(Customer, Order, ExtensionResultHolder)}
   * with {@code customer}, {@code candidateCart}, {@code erh}.
   * <p>
   * Method under test:
   * {@link OrderServiceExtensionManager#findCartForCustomerWithEnhancements(Customer, Order, ExtensionResultHolder)}
   */
  @Test
  public void testFindCartForCustomerWithEnhancementsWithCustomerCandidateCartErh2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderServiceExtensionManager orderServiceExtensionManager = new OrderServiceExtensionManager();
    NullOrderImpl order = new NullOrderImpl();
    orderServiceExtensionManager.addOfferCodes(order, new ArrayList<>(), true);
    CustomerImpl customer = new CustomerImpl();
    NullOrderImpl candidateCart = new NullOrderImpl();

    ExtensionResultHolder erh = new ExtensionResultHolder();
    erh.setResult("Result");
    erh.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        orderServiceExtensionManager.findCartForCustomerWithEnhancements(customer, candidateCart, erh));
  }

  /**
   * Test
   * {@link OrderServiceExtensionManager#findCartForCustomerWithEnhancements(Customer, Order, ExtensionResultHolder)}
   * with {@code customer}, {@code candidateCart}, {@code erh}.
   * <p>
   * Method under test:
   * {@link OrderServiceExtensionManager#findCartForCustomerWithEnhancements(Customer, Order, ExtensionResultHolder)}
   */
  @Test
  public void testFindCartForCustomerWithEnhancementsWithCustomerCandidateCartErh3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderServiceExtensionManager orderServiceExtensionManager = new OrderServiceExtensionManager();
    orderServiceExtensionManager.registerHandler(new CartMessageOrderItemServiceExtensionHandler());
    NullOrderImpl order = new NullOrderImpl();
    orderServiceExtensionManager.addOfferCodes(order, new ArrayList<>(), true);
    CustomerImpl customer = new CustomerImpl();
    NullOrderImpl candidateCart = new NullOrderImpl();

    ExtensionResultHolder erh = new ExtensionResultHolder();
    erh.setResult("Result");
    erh.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        orderServiceExtensionManager.findCartForCustomerWithEnhancements(customer, candidateCart, erh));
  }

  /**
   * Test
   * {@link OrderServiceExtensionManager#findCartForCustomerWithEnhancements(Customer, Order, ExtensionResultHolder)}
   * with {@code customer}, {@code candidateCart}, {@code erh}.
   * <p>
   * Method under test:
   * {@link OrderServiceExtensionManager#findCartForCustomerWithEnhancements(Customer, Order, ExtensionResultHolder)}
   */
  @Test
  public void testFindCartForCustomerWithEnhancementsWithCustomerCandidateCartErh4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderServiceExtensionManager orderServiceExtensionManager = new OrderServiceExtensionManager();
    CustomerImpl customer = mock(CustomerImpl.class);
    NullOrderImpl candidateCart = new NullOrderImpl();

    ExtensionResultHolder erh = new ExtensionResultHolder();
    erh.setResult("Result");
    erh.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        orderServiceExtensionManager.findCartForCustomerWithEnhancements(customer, candidateCart, erh));
  }

  /**
   * Test
   * {@link OrderServiceExtensionManager#findCartForCustomerWithEnhancements(Customer, Order, ExtensionResultHolder)}
   * with {@code customer}, {@code candidateCart}, {@code erh}.
   * <p>
   * Method under test:
   * {@link OrderServiceExtensionManager#findCartForCustomerWithEnhancements(Customer, Order, ExtensionResultHolder)}
   */
  @Test
  public void testFindCartForCustomerWithEnhancementsWithCustomerCandidateCartErh5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderServiceExtensionManager orderServiceExtensionManager = new OrderServiceExtensionManager();
    orderServiceExtensionManager.registerHandler(new OrderServiceExtensionManager());
    NullOrderImpl order = new NullOrderImpl();
    orderServiceExtensionManager.addOfferCodes(order, new ArrayList<>(), true);
    CustomerImpl customer = new CustomerImpl();
    NullOrderImpl candidateCart = new NullOrderImpl();

    ExtensionResultHolder erh = new ExtensionResultHolder();
    erh.setResult("Result");
    erh.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        orderServiceExtensionManager.findCartForCustomerWithEnhancements(customer, candidateCart, erh));
  }

  /**
   * Test
   * {@link OrderServiceExtensionManager#findCartForCustomerWithEnhancements(Customer, Order, ExtensionResultHolder)}
   * with {@code customer}, {@code candidateCart}, {@code erh}.
   * <p>
   * Method under test:
   * {@link OrderServiceExtensionManager#findCartForCustomerWithEnhancements(Customer, Order, ExtensionResultHolder)}
   */
  @Test
  public void testFindCartForCustomerWithEnhancementsWithCustomerCandidateCartErh6() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CartMessageOrderItemServiceExtensionHandler cartMessageOrderItemServiceExtensionHandler = mock(
        CartMessageOrderItemServiceExtensionHandler.class);
    when(cartMessageOrderItemServiceExtensionHandler.addOfferCodes(Mockito.<Order>any(), Mockito.<List<OfferCode>>any(),
        anyBoolean())).thenReturn(ExtensionResultStatusType.HANDLED);
    when(cartMessageOrderItemServiceExtensionHandler.findCartForCustomerWithEnhancements(Mockito.<Customer>any(),
        Mockito.<Order>any(), Mockito.<ExtensionResultHolder<Object>>any()))
            .thenReturn(ExtensionResultStatusType.HANDLED);
    when(cartMessageOrderItemServiceExtensionHandler.isEnabled()).thenReturn(true);

    OrderServiceExtensionManager orderServiceExtensionManager = new OrderServiceExtensionManager();
    orderServiceExtensionManager.registerHandler(cartMessageOrderItemServiceExtensionHandler);
    NullOrderImpl order = new NullOrderImpl();
    orderServiceExtensionManager.addOfferCodes(order, new ArrayList<>(), true);
    CustomerImpl customer = new CustomerImpl();
    NullOrderImpl candidateCart = new NullOrderImpl();

    ExtensionResultHolder erh = new ExtensionResultHolder();
    erh.setResult("Result");
    erh.setThrowable(new Throwable());

    // Act
    ExtensionResultStatusType actualFindCartForCustomerWithEnhancementsResult = orderServiceExtensionManager
        .findCartForCustomerWithEnhancements(customer, candidateCart, erh);

    // Assert
    verify(cartMessageOrderItemServiceExtensionHandler, atLeast(1)).isEnabled();
    verify(cartMessageOrderItemServiceExtensionHandler).addOfferCodes(isA(Order.class), isA(List.class), eq(true));
    verify(cartMessageOrderItemServiceExtensionHandler).findCartForCustomerWithEnhancements(isA(Customer.class),
        isA(Order.class), isA(ExtensionResultHolder.class));
    assertEquals(ExtensionResultStatusType.HANDLED, actualFindCartForCustomerWithEnhancementsResult);
  }

  /**
   * Test
   * {@link OrderServiceExtensionManager#findCartForCustomerWithEnhancements(Customer, Order, ExtensionResultHolder)}
   * with {@code customer}, {@code candidateCart}, {@code erh}.
   * <p>
   * Method under test:
   * {@link OrderServiceExtensionManager#findCartForCustomerWithEnhancements(Customer, Order, ExtensionResultHolder)}
   */
  @Test
  public void testFindCartForCustomerWithEnhancementsWithCustomerCandidateCartErh7() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CartMessageOrderItemServiceExtensionHandler cartMessageOrderItemServiceExtensionHandler = mock(
        CartMessageOrderItemServiceExtensionHandler.class);
    when(cartMessageOrderItemServiceExtensionHandler.addOfferCodes(Mockito.<Order>any(), Mockito.<List<OfferCode>>any(),
        anyBoolean())).thenReturn(ExtensionResultStatusType.HANDLED);
    when(cartMessageOrderItemServiceExtensionHandler.findCartForCustomerWithEnhancements(Mockito.<Customer>any(),
        Mockito.<Order>any(), Mockito.<ExtensionResultHolder<Object>>any()))
            .thenReturn(ExtensionResultStatusType.HANDLED_STOP);
    when(cartMessageOrderItemServiceExtensionHandler.isEnabled()).thenReturn(true);

    OrderServiceExtensionManager orderServiceExtensionManager = new OrderServiceExtensionManager();
    orderServiceExtensionManager.registerHandler(cartMessageOrderItemServiceExtensionHandler);
    NullOrderImpl order = new NullOrderImpl();
    orderServiceExtensionManager.addOfferCodes(order, new ArrayList<>(), true);
    CustomerImpl customer = new CustomerImpl();
    NullOrderImpl candidateCart = new NullOrderImpl();

    ExtensionResultHolder erh = new ExtensionResultHolder();
    erh.setResult("Result");
    erh.setThrowable(new Throwable());

    // Act
    ExtensionResultStatusType actualFindCartForCustomerWithEnhancementsResult = orderServiceExtensionManager
        .findCartForCustomerWithEnhancements(customer, candidateCart, erh);

    // Assert
    verify(cartMessageOrderItemServiceExtensionHandler, atLeast(1)).isEnabled();
    verify(cartMessageOrderItemServiceExtensionHandler).addOfferCodes(isA(Order.class), isA(List.class), eq(true));
    verify(cartMessageOrderItemServiceExtensionHandler).findCartForCustomerWithEnhancements(isA(Customer.class),
        isA(Order.class), isA(ExtensionResultHolder.class));
    assertEquals(ExtensionResultStatusType.HANDLED, actualFindCartForCustomerWithEnhancementsResult);
  }

  /**
   * Test
   * {@link OrderServiceExtensionManager#findCartForCustomerWithEnhancements(Customer, Order, ExtensionResultHolder)}
   * with {@code customer}, {@code candidateCart}, {@code erh}.
   * <p>
   * Method under test:
   * {@link OrderServiceExtensionManager#findCartForCustomerWithEnhancements(Customer, Order, ExtensionResultHolder)}
   */
  @Test
  public void testFindCartForCustomerWithEnhancementsWithCustomerCandidateCartErh8() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CartMessageOrderItemServiceExtensionHandler cartMessageOrderItemServiceExtensionHandler = mock(
        CartMessageOrderItemServiceExtensionHandler.class);
    when(cartMessageOrderItemServiceExtensionHandler.isEnabled()).thenReturn(false);

    OrderServiceExtensionManager orderServiceExtensionManager = new OrderServiceExtensionManager();
    orderServiceExtensionManager.registerHandler(cartMessageOrderItemServiceExtensionHandler);
    NullOrderImpl order = new NullOrderImpl();
    orderServiceExtensionManager.addOfferCodes(order, new ArrayList<>(), true);
    CustomerImpl customer = new CustomerImpl();
    NullOrderImpl candidateCart = new NullOrderImpl();

    ExtensionResultHolder erh = new ExtensionResultHolder();
    erh.setResult("Result");
    erh.setThrowable(new Throwable());

    // Act
    ExtensionResultStatusType actualFindCartForCustomerWithEnhancementsResult = orderServiceExtensionManager
        .findCartForCustomerWithEnhancements(customer, candidateCart, erh);

    // Assert
    verify(cartMessageOrderItemServiceExtensionHandler, atLeast(1)).isEnabled();
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, actualFindCartForCustomerWithEnhancementsResult);
  }

  /**
   * Test
   * {@link OrderServiceExtensionManager#findCartForCustomerWithEnhancements(Customer, Order, ExtensionResultHolder)}
   * with {@code customer}, {@code candidateCart}, {@code erh}.
   * <p>
   * Method under test:
   * {@link OrderServiceExtensionManager#findCartForCustomerWithEnhancements(Customer, Order, ExtensionResultHolder)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testFindCartForCustomerWithEnhancementsWithCustomerCandidateCartErh9() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.order.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass102 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.order.service.OrderServiceExtensionManager orderServiceExtensionManager;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    OrderServiceExtensionManager orderServiceExtensionManager2 = new OrderServiceExtensionManager();
    CustomerImpl customer = new CustomerImpl();
    NullOrderImpl candidateCart = new NullOrderImpl();

    ExtensionResultHolder erh = new ExtensionResultHolder();
    erh.setResult("Result");
    erh.setThrowable(new Throwable());

    // Act
    orderServiceExtensionManager2.findCartForCustomerWithEnhancements(customer, candidateCart, erh);
  }

  /**
   * Test
   * {@link OrderServiceExtensionManager#findCartForCustomerWithEnhancements(Customer, ExtensionResultHolder)}
   * with {@code customer}, {@code erh}.
   * <p>
   * Method under test:
   * {@link OrderServiceExtensionManager#findCartForCustomerWithEnhancements(Customer, ExtensionResultHolder)}
   */
  @Test
  public void testFindCartForCustomerWithEnhancementsWithCustomerErh() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderServiceExtensionManager orderServiceExtensionManager = new OrderServiceExtensionManager();
    CustomerImpl customer = new CustomerImpl();

    ExtensionResultHolder erh = new ExtensionResultHolder();
    erh.setResult("Result");
    erh.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        orderServiceExtensionManager.findCartForCustomerWithEnhancements(customer, erh));
  }

  /**
   * Test
   * {@link OrderServiceExtensionManager#findCartForCustomerWithEnhancements(Customer, ExtensionResultHolder)}
   * with {@code customer}, {@code erh}.
   * <p>
   * Method under test:
   * {@link OrderServiceExtensionManager#findCartForCustomerWithEnhancements(Customer, ExtensionResultHolder)}
   */
  @Test
  public void testFindCartForCustomerWithEnhancementsWithCustomerErh2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderServiceExtensionManager orderServiceExtensionManager = new OrderServiceExtensionManager();
    NullOrderImpl order = new NullOrderImpl();
    orderServiceExtensionManager.addOfferCodes(order, new ArrayList<>(), true);
    CustomerImpl customer = new CustomerImpl();

    ExtensionResultHolder erh = new ExtensionResultHolder();
    erh.setResult("Result");
    erh.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        orderServiceExtensionManager.findCartForCustomerWithEnhancements(customer, erh));
  }

  /**
   * Test
   * {@link OrderServiceExtensionManager#findCartForCustomerWithEnhancements(Customer, ExtensionResultHolder)}
   * with {@code customer}, {@code erh}.
   * <p>
   * Method under test:
   * {@link OrderServiceExtensionManager#findCartForCustomerWithEnhancements(Customer, ExtensionResultHolder)}
   */
  @Test
  public void testFindCartForCustomerWithEnhancementsWithCustomerErh3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderServiceExtensionManager orderServiceExtensionManager = new OrderServiceExtensionManager();
    orderServiceExtensionManager.registerHandler(new CartMessageOrderItemServiceExtensionHandler());
    NullOrderImpl order = new NullOrderImpl();
    orderServiceExtensionManager.addOfferCodes(order, new ArrayList<>(), true);
    CustomerImpl customer = new CustomerImpl();

    ExtensionResultHolder erh = new ExtensionResultHolder();
    erh.setResult("Result");
    erh.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        orderServiceExtensionManager.findCartForCustomerWithEnhancements(customer, erh));
  }

  /**
   * Test
   * {@link OrderServiceExtensionManager#findCartForCustomerWithEnhancements(Customer, ExtensionResultHolder)}
   * with {@code customer}, {@code erh}.
   * <p>
   * Method under test:
   * {@link OrderServiceExtensionManager#findCartForCustomerWithEnhancements(Customer, ExtensionResultHolder)}
   */
  @Test
  public void testFindCartForCustomerWithEnhancementsWithCustomerErh4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderServiceExtensionManager orderServiceExtensionManager = new OrderServiceExtensionManager();
    orderServiceExtensionManager.registerHandler(new OrderServiceExtensionManager());
    NullOrderImpl order = new NullOrderImpl();
    orderServiceExtensionManager.addOfferCodes(order, new ArrayList<>(), true);
    CustomerImpl customer = new CustomerImpl();

    ExtensionResultHolder erh = new ExtensionResultHolder();
    erh.setResult("Result");
    erh.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        orderServiceExtensionManager.findCartForCustomerWithEnhancements(customer, erh));
  }

  /**
   * Test
   * {@link OrderServiceExtensionManager#findCartForCustomerWithEnhancements(Customer, ExtensionResultHolder)}
   * with {@code customer}, {@code erh}.
   * <p>
   * Method under test:
   * {@link OrderServiceExtensionManager#findCartForCustomerWithEnhancements(Customer, ExtensionResultHolder)}
   */
  @Test
  public void testFindCartForCustomerWithEnhancementsWithCustomerErh5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CartMessageOrderItemServiceExtensionHandler cartMessageOrderItemServiceExtensionHandler = mock(
        CartMessageOrderItemServiceExtensionHandler.class);
    when(cartMessageOrderItemServiceExtensionHandler.addOfferCodes(Mockito.<Order>any(), Mockito.<List<OfferCode>>any(),
        anyBoolean())).thenReturn(ExtensionResultStatusType.HANDLED);
    when(cartMessageOrderItemServiceExtensionHandler.findCartForCustomerWithEnhancements(Mockito.<Customer>any(),
        Mockito.<ExtensionResultHolder<Object>>any())).thenReturn(ExtensionResultStatusType.HANDLED);
    when(cartMessageOrderItemServiceExtensionHandler.isEnabled()).thenReturn(true);

    OrderServiceExtensionManager orderServiceExtensionManager = new OrderServiceExtensionManager();
    orderServiceExtensionManager.registerHandler(cartMessageOrderItemServiceExtensionHandler);
    NullOrderImpl order = new NullOrderImpl();
    orderServiceExtensionManager.addOfferCodes(order, new ArrayList<>(), true);
    CustomerImpl customer = new CustomerImpl();

    ExtensionResultHolder erh = new ExtensionResultHolder();
    erh.setResult("Result");
    erh.setThrowable(new Throwable());

    // Act
    ExtensionResultStatusType actualFindCartForCustomerWithEnhancementsResult = orderServiceExtensionManager
        .findCartForCustomerWithEnhancements(customer, erh);

    // Assert
    verify(cartMessageOrderItemServiceExtensionHandler, atLeast(1)).isEnabled();
    verify(cartMessageOrderItemServiceExtensionHandler).addOfferCodes(isA(Order.class), isA(List.class), eq(true));
    verify(cartMessageOrderItemServiceExtensionHandler).findCartForCustomerWithEnhancements(isA(Customer.class),
        isA(ExtensionResultHolder.class));
    assertEquals(ExtensionResultStatusType.HANDLED, actualFindCartForCustomerWithEnhancementsResult);
  }

  /**
   * Test
   * {@link OrderServiceExtensionManager#findCartForCustomerWithEnhancements(Customer, ExtensionResultHolder)}
   * with {@code customer}, {@code erh}.
   * <p>
   * Method under test:
   * {@link OrderServiceExtensionManager#findCartForCustomerWithEnhancements(Customer, ExtensionResultHolder)}
   */
  @Test
  public void testFindCartForCustomerWithEnhancementsWithCustomerErh6() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CartMessageOrderItemServiceExtensionHandler cartMessageOrderItemServiceExtensionHandler = mock(
        CartMessageOrderItemServiceExtensionHandler.class);
    when(cartMessageOrderItemServiceExtensionHandler.addOfferCodes(Mockito.<Order>any(), Mockito.<List<OfferCode>>any(),
        anyBoolean())).thenReturn(ExtensionResultStatusType.HANDLED);
    when(cartMessageOrderItemServiceExtensionHandler.findCartForCustomerWithEnhancements(Mockito.<Customer>any(),
        Mockito.<ExtensionResultHolder<Object>>any())).thenReturn(ExtensionResultStatusType.HANDLED_STOP);
    when(cartMessageOrderItemServiceExtensionHandler.isEnabled()).thenReturn(true);

    OrderServiceExtensionManager orderServiceExtensionManager = new OrderServiceExtensionManager();
    orderServiceExtensionManager.registerHandler(cartMessageOrderItemServiceExtensionHandler);
    NullOrderImpl order = new NullOrderImpl();
    orderServiceExtensionManager.addOfferCodes(order, new ArrayList<>(), true);
    CustomerImpl customer = new CustomerImpl();

    ExtensionResultHolder erh = new ExtensionResultHolder();
    erh.setResult("Result");
    erh.setThrowable(new Throwable());

    // Act
    ExtensionResultStatusType actualFindCartForCustomerWithEnhancementsResult = orderServiceExtensionManager
        .findCartForCustomerWithEnhancements(customer, erh);

    // Assert
    verify(cartMessageOrderItemServiceExtensionHandler, atLeast(1)).isEnabled();
    verify(cartMessageOrderItemServiceExtensionHandler).addOfferCodes(isA(Order.class), isA(List.class), eq(true));
    verify(cartMessageOrderItemServiceExtensionHandler).findCartForCustomerWithEnhancements(isA(Customer.class),
        isA(ExtensionResultHolder.class));
    assertEquals(ExtensionResultStatusType.HANDLED, actualFindCartForCustomerWithEnhancementsResult);
  }

  /**
   * Test
   * {@link OrderServiceExtensionManager#findCartForCustomerWithEnhancements(Customer, ExtensionResultHolder)}
   * with {@code customer}, {@code erh}.
   * <p>
   * Method under test:
   * {@link OrderServiceExtensionManager#findCartForCustomerWithEnhancements(Customer, ExtensionResultHolder)}
   */
  @Test
  public void testFindCartForCustomerWithEnhancementsWithCustomerErh7() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CartMessageOrderItemServiceExtensionHandler cartMessageOrderItemServiceExtensionHandler = mock(
        CartMessageOrderItemServiceExtensionHandler.class);
    when(cartMessageOrderItemServiceExtensionHandler.isEnabled()).thenReturn(false);

    OrderServiceExtensionManager orderServiceExtensionManager = new OrderServiceExtensionManager();
    orderServiceExtensionManager.registerHandler(cartMessageOrderItemServiceExtensionHandler);
    NullOrderImpl order = new NullOrderImpl();
    orderServiceExtensionManager.addOfferCodes(order, new ArrayList<>(), true);
    CustomerImpl customer = new CustomerImpl();

    ExtensionResultHolder erh = new ExtensionResultHolder();
    erh.setResult("Result");
    erh.setThrowable(new Throwable());

    // Act
    ExtensionResultStatusType actualFindCartForCustomerWithEnhancementsResult = orderServiceExtensionManager
        .findCartForCustomerWithEnhancements(customer, erh);

    // Assert
    verify(cartMessageOrderItemServiceExtensionHandler, atLeast(1)).isEnabled();
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, actualFindCartForCustomerWithEnhancementsResult);
  }

  /**
   * Test
   * {@link OrderServiceExtensionManager#findCartForCustomerWithEnhancements(Customer, ExtensionResultHolder)}
   * with {@code customer}, {@code erh}.
   * <p>
   * Method under test:
   * {@link OrderServiceExtensionManager#findCartForCustomerWithEnhancements(Customer, ExtensionResultHolder)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testFindCartForCustomerWithEnhancementsWithCustomerErh8() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.order.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass72 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.order.service.OrderServiceExtensionManager orderServiceExtensionManager;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    OrderServiceExtensionManager orderServiceExtensionManager2 = new OrderServiceExtensionManager();
    CustomerImpl customer = new CustomerImpl();

    ExtensionResultHolder erh = new ExtensionResultHolder();
    erh.setResult("Result");
    erh.setThrowable(new Throwable());

    // Act
    orderServiceExtensionManager2.findCartForCustomerWithEnhancements(customer, erh);
  }

  /**
   * Test
   * {@link OrderServiceExtensionManager#findCartForCustomerWithEnhancements(Customer, ExtensionResultHolder)}
   * with {@code customer}, {@code erh}.
   * <ul>
   *   <li>When {@link CustomerImpl}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OrderServiceExtensionManager#findCartForCustomerWithEnhancements(Customer, ExtensionResultHolder)}
   */
  @Test
  public void testFindCartForCustomerWithEnhancementsWithCustomerErh_whenCustomerImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderServiceExtensionManager orderServiceExtensionManager = new OrderServiceExtensionManager();
    CustomerImpl customer = mock(CustomerImpl.class);

    ExtensionResultHolder erh = new ExtensionResultHolder();
    erh.setResult("Result");
    erh.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        orderServiceExtensionManager.findCartForCustomerWithEnhancements(customer, erh));
  }

  /**
   * Test {@link OrderServiceExtensionManager#isEnabled()}.
   * <p>
   * Method under test: {@link OrderServiceExtensionManager#isEnabled()}
   */
  @Test
  public void testIsEnabled() {
    // Arrange, Act and Assert
    assertTrue((new OrderServiceExtensionManager()).isEnabled());
  }
}
