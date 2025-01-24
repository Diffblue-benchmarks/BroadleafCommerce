package org.broadleafcommerce.core.checkout.service.workflow;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import org.broadleafcommerce.core.workflow.DefaultProcessContextImpl;
import org.broadleafcommerce.core.workflow.ProcessContext;
import org.junit.Ignore;
import org.junit.Test;

public class PricingServiceActivityDiffblueTest {
  /**
   * Test {@link PricingServiceActivity#execute(ProcessContext)}.
   * <ul>
   *   <li>Given {@link PricingServiceActivity} (default constructor).</li>
   *   <li>When {@link DefaultProcessContextImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link PricingServiceActivity#execute(ProcessContext)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testExecute_givenPricingServiceActivity_whenDefaultProcessContextImpl() throws Exception {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.NullPointerException
    //       at org.broadleafcommerce.core.checkout.service.workflow.PricingServiceActivity.execute(PricingServiceActivity.java:35)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange
    PricingServiceActivity pricingServiceActivity = new PricingServiceActivity();

    // Act
    pricingServiceActivity.execute((ProcessContext<CheckoutSeed>) new DefaultProcessContextImpl<>());
  }

  /**
   * Test new {@link PricingServiceActivity} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link PricingServiceActivity}
   */
  @Test
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
