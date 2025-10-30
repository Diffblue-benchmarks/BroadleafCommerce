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
package org.broadleafcommerce.core.checkout.service.workflow;

import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import org.broadleafcommerce.core.order.domain.OrderImpl;
import org.broadleafcommerce.core.order.service.type.OrderStatus;
import org.broadleafcommerce.core.workflow.DefaultProcessContextImpl;
import org.broadleafcommerce.core.workflow.ProcessContext;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {CompleteOrderActivity.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class CompleteOrderActivityDiffblueTest {
  @Autowired
  private CompleteOrderActivity completeOrderActivity;

  @MockBean(name = "blCompleteOrderRollbackHandler")
  private CompleteOrderRollbackHandler completeOrderRollbackHandler;

  /**
   * Test {@link CompleteOrderActivity#execute(ProcessContext)}.
   * <ul>
   *   <li>Then return {@link DefaultProcessContextImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link CompleteOrderActivity#execute(ProcessContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ProcessContext CompleteOrderActivity.execute(ProcessContext)"})
  public void testExecute_thenReturnDefaultProcessContextImpl() throws Exception {
    // Arrange
    DefaultProcessContextImpl<CheckoutSeed> context = new DefaultProcessContextImpl<>();
    OrderImpl order = new OrderImpl();
    context.setSeedData(new CheckoutSeed(order, new HashMap<>()));

    // Act and Assert
    assertSame(context, completeOrderActivity.execute(context));
  }

  /**
   * Test {@link CompleteOrderActivity#getCompletedStatus()}.
   * <p>
   * Method under test: {@link CompleteOrderActivity#getCompletedStatus()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"OrderStatus CompleteOrderActivity.getCompletedStatus()"})
  public void testGetCompletedStatus() {
    // Arrange and Act
    OrderStatus actualCompletedStatus = (new CompleteOrderActivity(new CompleteOrderRollbackHandler()))
        .getCompletedStatus();

    // Assert
    assertSame(actualCompletedStatus.SUBMITTED, actualCompletedStatus);
  }
}
