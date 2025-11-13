package org.broadleafcommerce.core.checkout.service.workflow;

import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.Map;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.Order;
import org.broadleafcommerce.core.pricing.service.TaxService;
import org.broadleafcommerce.core.pricing.service.exception.TaxException;
import org.broadleafcommerce.core.workflow.Activity;
import org.broadleafcommerce.core.workflow.DefaultProcessContextImpl;
import org.broadleafcommerce.core.workflow.ProcessContext;
import org.broadleafcommerce.core.workflow.state.RollbackFailureException;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CommitTaxRollbackHandlerDiffblueTest {
  @InjectMocks private CommitTaxRollbackHandler commitTaxRollbackHandler;

  @Mock private TaxService taxService;

  /**
   * Test {@link CommitTaxRollbackHandler#rollbackState(Activity, ProcessContext, Map)}.
   *
   * <ul>
   *   <li>Given {@link TaxService} {@link TaxService#cancelTax(Order)} does nothing.
   *   <li>Then calls {@link TaxService#cancelTax(Order)}.
   * </ul>
   *
   * <p>Method under test: {@link CommitTaxRollbackHandler#rollbackState(Activity, ProcessContext,
   * Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CommitTaxRollbackHandler.rollbackState(Activity, ProcessContext, Map)"})
  public void testRollbackState_givenTaxServiceCancelTaxDoesNothing_thenCallsCancelTax()
      throws TaxException, RollbackFailureException {
    // Arrange
    doNothing().when(taxService).cancelTax(Mockito.<Order>any());
    CommitTaxActivity activity = new CommitTaxActivity(commitTaxRollbackHandler);

    DefaultProcessContextImpl<CheckoutSeed> processContext = new DefaultProcessContextImpl<>();
    NullOrderImpl order = new NullOrderImpl();
    CheckoutSeed checkoutSeed = new CheckoutSeed(order, new HashMap<>());
    processContext.setSeedData(checkoutSeed);

    // Act
    commitTaxRollbackHandler.rollbackState(activity, processContext, new HashMap<>());

    // Assert
    verify(taxService).cancelTax(isA(Order.class));
  }

  /**
   * Test {@link CommitTaxRollbackHandler#rollbackState(Activity, ProcessContext, Map)}.
   *
   * <ul>
   *   <li>Then throw {@link RollbackFailureException}.
   * </ul>
   *
   * <p>Method under test: {@link CommitTaxRollbackHandler#rollbackState(Activity, ProcessContext,
   * Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CommitTaxRollbackHandler.rollbackState(Activity, ProcessContext, Map)"})
  public void testRollbackState_thenThrowRollbackFailureException()
      throws TaxException, RollbackFailureException {
    // Arrange
    doThrow(new TaxException("An error occurred")).when(taxService).cancelTax(Mockito.<Order>any());
    CommitTaxActivity activity = new CommitTaxActivity(commitTaxRollbackHandler);

    DefaultProcessContextImpl<CheckoutSeed> processContext = new DefaultProcessContextImpl<>();
    NullOrderImpl order = new NullOrderImpl();
    CheckoutSeed checkoutSeed = new CheckoutSeed(order, new HashMap<>());
    processContext.setSeedData(checkoutSeed);

    // Act and Assert
    assertThrows(
        RollbackFailureException.class,
        () -> commitTaxRollbackHandler.rollbackState(activity, processContext, new HashMap<>()));
    verify(taxService).cancelTax(isA(Order.class));
  }
}
