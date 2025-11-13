package org.broadleafcommerce.core.pricing.service.workflow;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.Order;
import org.broadleafcommerce.core.workflow.DefaultProcessContextImpl;
import org.broadleafcommerce.core.workflow.ProcessContext;
import org.broadleafcommerce.core.workflow.WorkflowException;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class PricingProcessContextFactoryDiffblueTest {
  /**
   * Test {@link PricingProcessContextFactory#createContext(Order)} with {@code Order}.
   *
   * <p>Method under test: {@link PricingProcessContextFactory#createContext(Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ProcessContext PricingProcessContextFactory.createContext(Order)"})
  public void testCreateContextWithOrder() throws WorkflowException {
    // Arrange
    PricingProcessContextFactory pricingProcessContextFactory = new PricingProcessContextFactory();
    NullOrderImpl seedData = new NullOrderImpl();

    // Act
    ProcessContext<Order> actualCreateContextResult =
        pricingProcessContextFactory.createContext(seedData);

    // Assert
    Order seedData2 = actualCreateContextResult.getSeedData();
    assertTrue(seedData2 instanceof NullOrderImpl);
    assertTrue(actualCreateContextResult instanceof DefaultProcessContextImpl);
    assertFalse(actualCreateContextResult.isStopped());
    assertTrue(
        ((DefaultProcessContextImpl<Order>) actualCreateContextResult)
            .getActivityMessages()
            .isEmpty());
    assertSame(seedData, seedData2);
  }
}
