package org.broadleafcommerce.core.order.strategy;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;
import org.broadleafcommerce.core.order.dao.FulfillmentGroupItemDao;
import org.broadleafcommerce.core.order.domain.BundleOrderItemImpl;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.service.FulfillmentGroupService;
import org.broadleafcommerce.core.order.service.OrderItemService;
import org.broadleafcommerce.core.order.service.OrderService;
import org.broadleafcommerce.core.order.service.call.OrderItemRequestDTO;
import org.broadleafcommerce.core.order.service.workflow.CartOperationRequest;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {NullFulfillmentGroupItemStrategyImpl.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class NullFulfillmentGroupItemStrategyImplDiffblueTest {
  @MockBean
  private FulfillmentGroupItemDao fulfillmentGroupItemDao;

  @MockBean
  private FulfillmentGroupService fulfillmentGroupService;

  @Autowired
  private NullFulfillmentGroupItemStrategyImpl nullFulfillmentGroupItemStrategyImpl;

  @MockBean
  private OrderItemService orderItemService;

  @MockBean
  private OrderService orderService;

  /**
   * Test
   * {@link NullFulfillmentGroupItemStrategyImpl#onItemAdded(CartOperationRequest)}.
   * <p>
   * Method under test:
   * {@link NullFulfillmentGroupItemStrategyImpl#onItemAdded(CartOperationRequest)}
   */
  @Test
  public void testOnItemAdded() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    NullFulfillmentGroupItemStrategyImpl nullFulfillmentGroupItemStrategyImpl = new NullFulfillmentGroupItemStrategyImpl();
    NullOrderImpl order = new NullOrderImpl();
    CartOperationRequest request = new CartOperationRequest(order, new OrderItemRequestDTO(), true);

    // Act and Assert
    assertSame(request, nullFulfillmentGroupItemStrategyImpl.onItemAdded(request));
  }

  /**
   * Test
   * {@link NullFulfillmentGroupItemStrategyImpl#onItemAdded(CartOperationRequest)}.
   * <p>
   * Method under test:
   * {@link NullFulfillmentGroupItemStrategyImpl#onItemAdded(CartOperationRequest)}
   */
  @Test
  public void testOnItemAdded2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    NullFulfillmentGroupItemStrategyImpl nullFulfillmentGroupItemStrategyImpl = new NullFulfillmentGroupItemStrategyImpl();
    NullOrderImpl order = mock(NullOrderImpl.class);
    CartOperationRequest request = new CartOperationRequest(order, new OrderItemRequestDTO(), true);

    // Act and Assert
    assertSame(request, nullFulfillmentGroupItemStrategyImpl.onItemAdded(request));
  }

  /**
   * Test
   * {@link NullFulfillmentGroupItemStrategyImpl#onItemAdded(CartOperationRequest)}.
   * <p>
   * Method under test:
   * {@link NullFulfillmentGroupItemStrategyImpl#onItemAdded(CartOperationRequest)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testOnItemAdded3() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.order.strategy;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.core.order.strategy.NullFulfillmentGroupItemStrategyImpl.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass664 {
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.FulfillmentGroupItemDao fulfillmentGroupItemDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.FulfillmentGroupService fulfillmentGroupService;
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.order.strategy.NullFulfillmentGroupItemStrategyImpl nullFulfillmentGroupItemStrategyImpl;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.OrderItemService orderItemService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.OrderService orderService;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    NullOrderImpl order = new NullOrderImpl();

    // Act
    nullFulfillmentGroupItemStrategyImpl.onItemAdded(new CartOperationRequest(order, new OrderItemRequestDTO(), true));
  }

  /**
   * Test
   * {@link NullFulfillmentGroupItemStrategyImpl#onItemUpdated(CartOperationRequest)}.
   * <p>
   * Method under test:
   * {@link NullFulfillmentGroupItemStrategyImpl#onItemUpdated(CartOperationRequest)}
   */
  @Test
  public void testOnItemUpdated() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    NullFulfillmentGroupItemStrategyImpl nullFulfillmentGroupItemStrategyImpl = new NullFulfillmentGroupItemStrategyImpl();
    NullOrderImpl order = new NullOrderImpl();
    CartOperationRequest request = new CartOperationRequest(order, new OrderItemRequestDTO(), true);

    // Act and Assert
    assertSame(request, nullFulfillmentGroupItemStrategyImpl.onItemUpdated(request));
  }

  /**
   * Test
   * {@link NullFulfillmentGroupItemStrategyImpl#onItemUpdated(CartOperationRequest)}.
   * <p>
   * Method under test:
   * {@link NullFulfillmentGroupItemStrategyImpl#onItemUpdated(CartOperationRequest)}
   */
  @Test
  public void testOnItemUpdated2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    NullFulfillmentGroupItemStrategyImpl nullFulfillmentGroupItemStrategyImpl = new NullFulfillmentGroupItemStrategyImpl();
    NullOrderImpl order = mock(NullOrderImpl.class);
    CartOperationRequest request = new CartOperationRequest(order, new OrderItemRequestDTO(), true);

    // Act and Assert
    assertSame(request, nullFulfillmentGroupItemStrategyImpl.onItemUpdated(request));
  }

  /**
   * Test
   * {@link NullFulfillmentGroupItemStrategyImpl#onItemUpdated(CartOperationRequest)}.
   * <p>
   * Method under test:
   * {@link NullFulfillmentGroupItemStrategyImpl#onItemUpdated(CartOperationRequest)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testOnItemUpdated3() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.order.strategy;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.core.order.strategy.NullFulfillmentGroupItemStrategyImpl.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass666 {
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.FulfillmentGroupItemDao fulfillmentGroupItemDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.FulfillmentGroupService fulfillmentGroupService;
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.order.strategy.NullFulfillmentGroupItemStrategyImpl nullFulfillmentGroupItemStrategyImpl;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.OrderItemService orderItemService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.OrderService orderService;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    NullOrderImpl order = new NullOrderImpl();

    // Act
    nullFulfillmentGroupItemStrategyImpl
        .onItemUpdated(new CartOperationRequest(order, new OrderItemRequestDTO(), true));
  }

  /**
   * Test
   * {@link NullFulfillmentGroupItemStrategyImpl#onItemRemoved(CartOperationRequest)}.
   * <p>
   * Method under test:
   * {@link NullFulfillmentGroupItemStrategyImpl#onItemRemoved(CartOperationRequest)}
   */
  @Test
  public void testOnItemRemoved() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    NullFulfillmentGroupItemStrategyImpl nullFulfillmentGroupItemStrategyImpl = new NullFulfillmentGroupItemStrategyImpl();
    NullOrderImpl order = new NullOrderImpl();

    CartOperationRequest request = new CartOperationRequest(order, new OrderItemRequestDTO(), true);
    request.setOrderItem(new BundleOrderItemImpl());

    // Act and Assert
    assertSame(request, nullFulfillmentGroupItemStrategyImpl.onItemRemoved(request));
  }

  /**
   * Test
   * {@link NullFulfillmentGroupItemStrategyImpl#onItemRemoved(CartOperationRequest)}.
   * <p>
   * Method under test:
   * {@link NullFulfillmentGroupItemStrategyImpl#onItemRemoved(CartOperationRequest)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testOnItemRemoved2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.order.strategy;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.core.order.strategy.NullFulfillmentGroupItemStrategyImpl.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass665 {
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.FulfillmentGroupItemDao fulfillmentGroupItemDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.FulfillmentGroupService fulfillmentGroupService;
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.order.strategy.NullFulfillmentGroupItemStrategyImpl nullFulfillmentGroupItemStrategyImpl;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.OrderItemService orderItemService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.OrderService orderService;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    NullOrderImpl order = new NullOrderImpl();

    // Act
    nullFulfillmentGroupItemStrategyImpl
        .onItemRemoved(new CartOperationRequest(order, new OrderItemRequestDTO(), true));
  }

  /**
   * Test
   * {@link NullFulfillmentGroupItemStrategyImpl#verify(CartOperationRequest)}.
   * <p>
   * Method under test:
   * {@link NullFulfillmentGroupItemStrategyImpl#verify(CartOperationRequest)}
   */
  @Test
  public void testVerify() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    NullFulfillmentGroupItemStrategyImpl nullFulfillmentGroupItemStrategyImpl = new NullFulfillmentGroupItemStrategyImpl();
    NullOrderImpl order = new NullOrderImpl();
    CartOperationRequest request = new CartOperationRequest(order, new OrderItemRequestDTO(), true);

    // Act and Assert
    assertSame(request, nullFulfillmentGroupItemStrategyImpl.verify(request));
  }

  /**
   * Test
   * {@link NullFulfillmentGroupItemStrategyImpl#verify(CartOperationRequest)}.
   * <p>
   * Method under test:
   * {@link NullFulfillmentGroupItemStrategyImpl#verify(CartOperationRequest)}
   */
  @Test
  public void testVerify2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    NullFulfillmentGroupItemStrategyImpl nullFulfillmentGroupItemStrategyImpl = new NullFulfillmentGroupItemStrategyImpl();
    NullOrderImpl order = mock(NullOrderImpl.class);
    CartOperationRequest request = new CartOperationRequest(order, new OrderItemRequestDTO(), true);

    // Act and Assert
    assertSame(request, nullFulfillmentGroupItemStrategyImpl.verify(request));
  }

  /**
   * Test
   * {@link NullFulfillmentGroupItemStrategyImpl#verify(CartOperationRequest)}.
   * <p>
   * Method under test:
   * {@link NullFulfillmentGroupItemStrategyImpl#verify(CartOperationRequest)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testVerify3() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.order.strategy;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.core.order.strategy.NullFulfillmentGroupItemStrategyImpl.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass667 {
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.dao.FulfillmentGroupItemDao fulfillmentGroupItemDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.FulfillmentGroupService fulfillmentGroupService;
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.order.strategy.NullFulfillmentGroupItemStrategyImpl nullFulfillmentGroupItemStrategyImpl;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.OrderItemService orderItemService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.OrderService orderService;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    NullOrderImpl order = new NullOrderImpl();

    // Act
    nullFulfillmentGroupItemStrategyImpl.verify(new CartOperationRequest(order, new OrderItemRequestDTO(), true));
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link NullFulfillmentGroupItemStrategyImpl}
   *   <li>
   * {@link NullFulfillmentGroupItemStrategyImpl#isRemoveEmptyFulfillmentGroups()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertFalse((new NullFulfillmentGroupItemStrategyImpl()).isRemoveEmptyFulfillmentGroups());
  }
}
