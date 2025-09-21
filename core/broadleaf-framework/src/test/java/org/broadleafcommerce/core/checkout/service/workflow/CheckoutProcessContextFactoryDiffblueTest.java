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

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.workflow.DefaultProcessContextImpl;
import org.broadleafcommerce.core.workflow.ProcessContext;
import org.broadleafcommerce.core.workflow.WorkflowException;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class CheckoutProcessContextFactoryDiffblueTest {
  /**
   * Test {@link CheckoutProcessContextFactory#createContext(CheckoutSeed)} with {@code
   * CheckoutSeed}.
   *
   * <p>Method under test: {@link CheckoutProcessContextFactory#createContext(CheckoutSeed)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ProcessContext CheckoutProcessContextFactory.createContext(CheckoutSeed)"})
  public void testCreateContextWithCheckoutSeed() throws WorkflowException {
    // Arrange
    CheckoutProcessContextFactory checkoutProcessContextFactory =
        new CheckoutProcessContextFactory();
    NullOrderImpl order = new NullOrderImpl();
    CheckoutSeed seedData = new CheckoutSeed(order, new HashMap<>());

    // Act
    ProcessContext<CheckoutSeed> actualCreateContextResult =
        checkoutProcessContextFactory.createContext(seedData);

    // Assert
    assertTrue(actualCreateContextResult instanceof DefaultProcessContextImpl);
    assertFalse(actualCreateContextResult.isStopped());
    assertTrue(
        ((DefaultProcessContextImpl<CheckoutSeed>) actualCreateContextResult)
            .getActivityMessages()
            .isEmpty());
    assertSame(seedData, actualCreateContextResult.getSeedData());
  }
}
