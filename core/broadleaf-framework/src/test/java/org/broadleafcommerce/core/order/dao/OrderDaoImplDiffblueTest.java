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
package org.broadleafcommerce.core.order.dao;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.Order;
import org.junit.Test;

public class OrderDaoImplDiffblueTest {
  /**
   * Method under test: {@link OrderDaoImpl#readOrdersByIds(List)}
   */
  @Test
  public void testReadOrdersByIds() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderDaoImpl orderDaoImpl = new OrderDaoImpl();

    // Act and Assert
    assertNull(orderDaoImpl.readOrdersByIds(new ArrayList<>()));
  }

  /**
   * Method under test: {@link OrderDaoImpl#readOrdersByIds(List)}
   */
  @Test
  public void testReadOrdersByIds2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new OrderDaoImpl()).readOrdersByIds(null));
  }

  /**
   * Method under test: {@link OrderDaoImpl#readOrderByOrderNumber(String)}
   */
  @Test
  public void testReadOrderByOrderNumber() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new OrderDaoImpl()).readOrderByOrderNumber(null));
    assertNull((new OrderDaoImpl()).readOrderByOrderNumber(""));
  }

  /**
   * Method under test: {@link OrderDaoImpl#releaseLock(Order)}
   */
  @Test
  public void testReleaseLock() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderDaoImpl orderDaoImpl = new OrderDaoImpl();

    // Act and Assert
    assertFalse(orderDaoImpl.releaseLock(new NullOrderImpl()));
  }

  /**
   * Method under test: {@link OrderDaoImpl#releaseLock(Order)}
   */
  @Test
  public void testReleaseLock2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderDaoImpl orderDaoImpl = new OrderDaoImpl();
    NullOrderImpl order = mock(NullOrderImpl.class);
    when(order.getId()).thenReturn(1L);

    // Act
    boolean actualReleaseLockResult = orderDaoImpl.releaseLock(order);

    // Assert
    verify(order).getId();
    assertFalse(actualReleaseLockResult);
  }

  /**
   * Method under test: {@link OrderDaoImpl#readOrdersByEmail(String)}
   */
  @Test
  public void testReadOrdersByEmail() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new OrderDaoImpl()).readOrdersByEmail(null).isEmpty());
    assertTrue((new OrderDaoImpl()).readOrdersByEmail("").isEmpty());
  }
}
