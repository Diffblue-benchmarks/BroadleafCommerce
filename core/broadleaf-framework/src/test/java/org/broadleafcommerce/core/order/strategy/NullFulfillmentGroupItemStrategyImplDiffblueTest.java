/*-
 * #%L
 * BroadleafCommerce Framework
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
package org.broadleafcommerce.core.order.strategy;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;
import org.broadleafcommerce.core.order.domain.BundleOrderItemImpl;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.service.call.OrderItemRequestDTO;
import org.broadleafcommerce.core.order.service.workflow.CartOperationRequest;
import org.junit.Test;

public class NullFulfillmentGroupItemStrategyImplDiffblueTest {
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
