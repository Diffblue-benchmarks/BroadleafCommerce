package org.broadleafcommerce.core.pricing.service.workflow;

import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.core.order.domain.Order;
import org.broadleafcommerce.core.workflow.DefaultProcessContextImpl;
import org.broadleafcommerce.core.workflow.ProcessContext;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class DetermineOfferChangeActivityDiffblueTest {
  /**
   * Test {@link DetermineOfferChangeActivity#execute(ProcessContext)}.
   *
   * <ul>
   *   <li>Then return {@link DefaultProcessContextImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link DetermineOfferChangeActivity#execute(ProcessContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ProcessContext DetermineOfferChangeActivity.execute(ProcessContext)"})
  public void testExecute_thenReturnDefaultProcessContextImpl() throws Exception {
    // Arrange
    DetermineOfferChangeActivity determineOfferChangeActivity = new DetermineOfferChangeActivity();
    DefaultProcessContextImpl<Order> context = new DefaultProcessContextImpl<>();

    // Act
    ProcessContext<Order> actualExecuteResult = determineOfferChangeActivity.execute(context);

    // Assert
    assertSame(context, actualExecuteResult);
  }
}
