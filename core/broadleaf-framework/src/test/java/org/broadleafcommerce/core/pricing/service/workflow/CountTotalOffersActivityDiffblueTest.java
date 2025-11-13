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

public class CountTotalOffersActivityDiffblueTest {
  /**
   * Test {@link CountTotalOffersActivity#execute(ProcessContext)}.
   *
   * <ul>
   *   <li>Given {@link CountTotalOffersActivity} (default constructor).
   *   <li>Then return {@link DefaultProcessContextImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link CountTotalOffersActivity#execute(ProcessContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ProcessContext CountTotalOffersActivity.execute(ProcessContext)"})
  public void testExecute_givenCountTotalOffersActivity_thenReturnDefaultProcessContextImpl()
      throws Exception {
    // Arrange
    CountTotalOffersActivity countTotalOffersActivity = new CountTotalOffersActivity();
    DefaultProcessContextImpl<Order> context = new DefaultProcessContextImpl<>();

    // Act
    ProcessContext<Order> actualExecuteResult = countTotalOffersActivity.execute(context);

    // Assert
    assertSame(context, actualExecuteResult);
  }
}
