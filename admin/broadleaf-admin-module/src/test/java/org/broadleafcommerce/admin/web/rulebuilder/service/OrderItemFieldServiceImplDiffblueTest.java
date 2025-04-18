/*-
 * #%L
 * BroadleafCommerce Admin Module
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
package org.broadleafcommerce.admin.web.rulebuilder.service;

import static org.junit.Assert.assertEquals;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class OrderItemFieldServiceImplDiffblueTest {
  @InjectMocks
  private OrderItemFieldServiceImpl orderItemFieldServiceImpl;

  /**
   * Test {@link OrderItemFieldServiceImpl#init()}.
   * <p>
   * Method under test: {@link OrderItemFieldServiceImpl#init()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OrderItemFieldServiceImpl.init()"})
  public void testInit() {
    // Arrange and Act
    orderItemFieldServiceImpl.init();

    // Assert
    assertEquals(7, orderItemFieldServiceImpl.getFields().size());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link OrderItemFieldServiceImpl#getDtoClassName()}
   *   <li>{@link OrderItemFieldServiceImpl#getName()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String OrderItemFieldServiceImpl.getDtoClassName()",
      "String OrderItemFieldServiceImpl.getName()"})
  public void testGettersAndSetters() {
    // Arrange
    OrderItemFieldServiceImpl orderItemFieldServiceImpl = new OrderItemFieldServiceImpl();

    // Act
    String actualDtoClassName = orderItemFieldServiceImpl.getDtoClassName();

    // Assert
    assertEquals("ORDER_ITEM_FIELDS", orderItemFieldServiceImpl.getName());
    assertEquals("org.broadleafcommerce.core.order.domain.OrderItemImpl", actualDtoClassName);
  }
}
