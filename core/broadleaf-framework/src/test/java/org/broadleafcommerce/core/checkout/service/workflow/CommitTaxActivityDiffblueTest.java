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
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import org.broadleafcommerce.core.order.domain.Order;
import org.broadleafcommerce.core.workflow.DefaultProcessContextImpl;
import org.broadleafcommerce.core.workflow.ProcessContext;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CommitTaxActivityDiffblueTest {
  @InjectMocks
  private CommitTaxActivity commitTaxActivity;

  /**
   * Test {@link CommitTaxActivity#execute(ProcessContext)}.
   * <ul>
   *   <li>Then return {@link DefaultProcessContextImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link CommitTaxActivity#execute(ProcessContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ProcessContext CommitTaxActivity.execute(ProcessContext)"})
  public void testExecute_thenReturnDefaultProcessContextImpl() throws Exception {
    // Arrange
    Order order = mock(Order.class);
    when(order.getTaxOverride()).thenReturn(true);
    CheckoutSeed checkoutSeed = new CheckoutSeed(order, new HashMap<>());

    DefaultProcessContextImpl<CheckoutSeed> context = new DefaultProcessContextImpl<>();
    context.setSeedData(checkoutSeed);

    // Act
    ProcessContext<CheckoutSeed> actualExecuteResult = commitTaxActivity.execute(context);

    // Assert
    verify(order).getTaxOverride();
    assertSame(context, actualExecuteResult);
  }
}
