package org.broadleafcommerce.core.pricing.service.workflow;

import static org.junit.Assert.assertSame;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.core.offer.service.ShippingOfferService;
import org.broadleafcommerce.core.order.domain.Order;
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
public class ShippingOfferActivityDiffblueTest {
  @InjectMocks private ShippingOfferActivity shippingOfferActivity;

  @Mock private ShippingOfferService shippingOfferService;

  /**
   * Test {@link ShippingOfferActivity#execute(ProcessContext)}.
   *
   * <ul>
   *   <li>When {@link DefaultProcessContextImpl} (default constructor).
   *   <li>Then return {@link DefaultProcessContextImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link ShippingOfferActivity#execute(ProcessContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ProcessContext ShippingOfferActivity.execute(ProcessContext)"})
  public void testExecute_whenDefaultProcessContextImpl_thenReturnDefaultProcessContextImpl()
      throws Exception {
    // Arrange
    doNothing().when(shippingOfferService).reviewOffers(Mockito.<Order>any());
    DefaultProcessContextImpl<Order> context = new DefaultProcessContextImpl<>();

    // Act
    ProcessContext<Order> actualExecuteResult = shippingOfferActivity.execute(context);

    // Assert
    verify(shippingOfferService).reviewOffers(isNull());
    assertSame(context, actualExecuteResult);
  }
}
