package org.broadleafcommerce.core.pricing.service;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.Order;
import org.broadleafcommerce.core.pricing.service.exception.PricingException;
import org.broadleafcommerce.core.workflow.DefaultProcessContextImpl;
import org.broadleafcommerce.core.workflow.Processor;
import org.broadleafcommerce.core.workflow.WorkflowException;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class PricingServiceImplDiffblueTest {
  @InjectMocks private PricingServiceImpl pricingServiceImpl;

  @Mock private Processor processor;

  /**
   * Test {@link PricingServiceImpl#executePricing(Order)}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PricingServiceImpl#executePricing(Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Order PricingServiceImpl.executePricing(Order)"})
  public void testExecutePricing_thenReturnNull() throws PricingException, WorkflowException {
    // Arrange
    when(processor.doActivities(Mockito.<Object>any()))
        .thenReturn(new DefaultProcessContextImpl<>());

    // Act
    Order actualExecutePricingResult = pricingServiceImpl.executePricing(new NullOrderImpl());

    // Assert
    verify(processor).doActivities(isA(Object.class));
    assertNull(actualExecutePricingResult);
  }

  /**
   * Test {@link PricingServiceImpl#executePricing(Order)}.
   *
   * <ul>
   *   <li>Then throw {@link PricingException}.
   * </ul>
   *
   * <p>Method under test: {@link PricingServiceImpl#executePricing(Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Order PricingServiceImpl.executePricing(Order)"})
  public void testExecutePricing_thenThrowPricingException()
      throws PricingException, WorkflowException {
    // Arrange
    when(processor.doActivities(Mockito.<Object>any()))
        .thenThrow(new WorkflowException("An error occurred"));

    // Act and Assert
    assertThrows(
        PricingException.class, () -> pricingServiceImpl.executePricing(new NullOrderImpl()));
    verify(processor).doActivities(isA(Object.class));
  }
}
