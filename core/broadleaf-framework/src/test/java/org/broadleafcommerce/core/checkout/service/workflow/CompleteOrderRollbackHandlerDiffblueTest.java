package org.broadleafcommerce.core.checkout.service.workflow;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.Map;
import org.broadleafcommerce.core.order.domain.Order;
import org.broadleafcommerce.core.order.domain.OrderImpl;
import org.broadleafcommerce.core.order.service.type.OrderStatus;
import org.broadleafcommerce.core.workflow.Activity;
import org.broadleafcommerce.core.workflow.DefaultProcessContextImpl;
import org.broadleafcommerce.core.workflow.ProcessContext;
import org.broadleafcommerce.core.workflow.state.RollbackFailureException;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {CompleteOrderRollbackHandler.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class CompleteOrderRollbackHandlerDiffblueTest {
  @Autowired private CompleteOrderRollbackHandler completeOrderRollbackHandler;

  /**
   * Test {@link CompleteOrderRollbackHandler#rollbackState(Activity, ProcessContext, Map)}.
   *
   * <ul>
   *   <li>Then {@link DefaultProcessContextImpl} (default constructor) SeedData Order {@link
   *       OrderImpl}.
   * </ul>
   *
   * <p>Method under test: {@link CompleteOrderRollbackHandler#rollbackState(Activity,
   * ProcessContext, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CompleteOrderRollbackHandler.rollbackState(Activity, ProcessContext, Map)"
  })
  public void testRollbackState_thenDefaultProcessContextImplSeedDataOrderOrderImpl()
      throws RollbackFailureException {
    // Arrange
    CommitTaxActivity activity = new CommitTaxActivity(new CommitTaxRollbackHandler());

    DefaultProcessContextImpl<CheckoutSeed> processContext = new DefaultProcessContextImpl<>();
    OrderImpl order = new OrderImpl();
    CheckoutSeed checkoutSeed = new CheckoutSeed(order, new HashMap<>());
    processContext.setSeedData(checkoutSeed);

    // Act
    completeOrderRollbackHandler.rollbackState(activity, processContext, new HashMap<>());

    // Assert
    Order order2 = processContext.getSeedData().getOrder();
    assertTrue(order2 instanceof OrderImpl);
    OrderStatus status = order2.getStatus();
    assertEquals("IN_PROCESS", status.getType());
    assertEquals("In Process", status.getFriendlyType());
    assertTrue(status.isEditable());
  }
}
