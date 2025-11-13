package org.broadleafcommerce.core.checkout.service.workflow;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.Order;
import org.broadleafcommerce.core.pricing.service.PricingService;
import org.broadleafcommerce.core.workflow.DefaultProcessContextImpl;
import org.broadleafcommerce.core.workflow.ProcessContext;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class PricingServiceActivityDiffblueTest {
  @Mock private PricingService pricingService;

  @InjectMocks private PricingServiceActivity pricingServiceActivity;

  /**
   * Test {@link PricingServiceActivity#execute(ProcessContext)}.
   *
   * <ul>
   *   <li>Then return {@link DefaultProcessContextImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link PricingServiceActivity#execute(ProcessContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ProcessContext PricingServiceActivity.execute(ProcessContext)"})
  public void testExecute_thenReturnDefaultProcessContextImpl() throws Exception {
    // Arrange
    when(pricingService.executePricing(Mockito.<Order>any())).thenReturn(new NullOrderImpl());

    DefaultProcessContextImpl<CheckoutSeed> context = new DefaultProcessContextImpl<>();
    NullOrderImpl order = new NullOrderImpl();
    CheckoutSeed checkoutSeed = new CheckoutSeed(order, new HashMap<>());
    context.setSeedData(checkoutSeed);

    // Act
    ProcessContext<CheckoutSeed> actualExecuteResult = pricingServiceActivity.execute(context);

    // Assert
    verify(pricingService).executePricing(isA(Order.class));
    assertSame(context, actualExecuteResult);
  }

  /**
   * Test new {@link PricingServiceActivity} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link PricingServiceActivity}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void PricingServiceActivity.<init>()"})
  public void testNewPricingServiceActivity() {
    // Arrange and Act
    PricingServiceActivity actualPricingServiceActivity = new PricingServiceActivity();

    // Assert
    assertNull(actualPricingServiceActivity.getBeanName());
    assertNull(actualPricingServiceActivity.getRollbackRegion());
    assertNull(actualPricingServiceActivity.getStateConfiguration());
    assertNull(actualPricingServiceActivity.getErrorHandler());
    assertNull(actualPricingServiceActivity.getRollbackHandler());
    assertFalse(actualPricingServiceActivity.getAutomaticallyRegisterRollbackHandler());
    assertEquals(Integer.MAX_VALUE, actualPricingServiceActivity.getOrder());
  }
}
