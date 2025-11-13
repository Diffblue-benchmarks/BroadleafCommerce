package org.broadleafcommerce.core.checkout.service.workflow;

import static org.junit.Assert.assertThrows;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.Map;
import org.broadleafcommerce.core.workflow.Activity;
import org.broadleafcommerce.core.workflow.DefaultProcessContextImpl;
import org.broadleafcommerce.core.workflow.ProcessContext;
import org.broadleafcommerce.core.workflow.state.RollbackFailureException;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class ConfirmPaymentsRollbackHandlerDiffblueTest {
  /**
   * Test {@link ConfirmPaymentsRollbackHandler#rollbackState(Activity, ProcessContext, Map)}.
   *
   * <ul>
   *   <li>Then throw {@link RollbackFailureException}.
   * </ul>
   *
   * <p>Method under test: {@link ConfirmPaymentsRollbackHandler#rollbackState(Activity,
   * ProcessContext, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ConfirmPaymentsRollbackHandler.rollbackState(Activity, ProcessContext, Map)"
  })
  public void testRollbackState_thenThrowRollbackFailureException()
      throws RollbackFailureException {
    // Arrange
    ConfirmPaymentsRollbackHandler confirmPaymentsRollbackHandler =
        new ConfirmPaymentsRollbackHandler();
    CommitTaxActivity activity = new CommitTaxActivity(new CommitTaxRollbackHandler());
    DefaultProcessContextImpl<CheckoutSeed> processContext = new DefaultProcessContextImpl<>();

    // Act and Assert
    assertThrows(
        RollbackFailureException.class,
        () ->
            confirmPaymentsRollbackHandler.rollbackState(
                activity, processContext, new HashMap<>()));
  }
}
