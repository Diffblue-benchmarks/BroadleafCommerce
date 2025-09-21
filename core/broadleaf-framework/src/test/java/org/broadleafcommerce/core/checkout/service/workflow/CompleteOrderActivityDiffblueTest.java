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
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
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
  @Autowired private CompleteOrderActivity completeOrderActivity;

  @MockBean(name = "blCompleteOrderRollbackHandler")
  private CompleteOrderRollbackHandler completeOrderRollbackHandler;

  /**
   * Test {@link CompleteOrderActivity#execute(ProcessContext)}.
   *
   * <ul>
   *   <li>Then return {@link DefaultProcessContextImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link CompleteOrderActivity#execute(ProcessContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ProcessContext CompleteOrderActivity.execute(ProcessContext)"})
  public void testExecute_thenReturnDefaultProcessContextImpl() throws Exception {
    // Arrange
    DefaultProcessContextImpl<CheckoutSeed> context = new DefaultProcessContextImpl<>();
    OrderImpl order = new OrderImpl();
    CheckoutSeed checkoutSeed = new CheckoutSeed(order, new HashMap<>());
    context.setSeedData(checkoutSeed);

    // Act
    ProcessContext<CheckoutSeed> actualExecuteResult = completeOrderActivity.execute(context);

    // Assert
    assertSame(context, actualExecuteResult);
  }

  /**
   * Test {@link CompleteOrderActivity#getCompletedStatus()}.
   *
   * <p>Method under test: {@link CompleteOrderActivity#getCompletedStatus()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"OrderStatus CompleteOrderActivity.getCompletedStatus()"})
  public void testGetCompletedStatus() {
    // Arrange, Act and Assert
    assertSame(
        OrderStatus.SUBMITTED,
        new CompleteOrderActivity(new CompleteOrderRollbackHandler()).getCompletedStatus());
  }
}
