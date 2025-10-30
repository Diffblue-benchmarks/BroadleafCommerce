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
public class OrderFieldServiceImplDiffblueTest {
  @InjectMocks
  private OrderFieldServiceImpl orderFieldServiceImpl;

  /**
   * Test {@link OrderFieldServiceImpl#init()}.
   * <p>
   * Method under test: {@link OrderFieldServiceImpl#init()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OrderFieldServiceImpl.init()"})
  public void testInit() {
    // Arrange and Act
    orderFieldServiceImpl.init();

    // Assert
    assertEquals(3, orderFieldServiceImpl.getFields().size());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link OrderFieldServiceImpl#getDtoClassName()}
   *   <li>{@link OrderFieldServiceImpl#getName()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String OrderFieldServiceImpl.getDtoClassName()", "String OrderFieldServiceImpl.getName()"})
  public void testGettersAndSetters() {
    // Arrange
    OrderFieldServiceImpl orderFieldServiceImpl = new OrderFieldServiceImpl();

    // Act
    String actualDtoClassName = orderFieldServiceImpl.getDtoClassName();

    // Assert
    assertEquals("ORDER_FIELDS", orderFieldServiceImpl.getName());
    assertEquals("org.broadleafcommerce.core.order.domain.OrderImpl", actualDtoClassName);
  }
}
