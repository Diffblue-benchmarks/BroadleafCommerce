package org.broadleafcommerce.core.web.service;

import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.core.order.service.OrderService;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class OrderHistoryServiceImplDiffblueTest {
  @InjectMocks private OrderHistoryServiceImpl orderHistoryServiceImpl;

  @Mock private OrderService orderService;

  /**
   * Test {@link OrderHistoryServiceImpl#getOrderDetails(String)}.
   *
   * <p>Method under test: {@link OrderHistoryServiceImpl#getOrderDetails(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.broadleafcommerce.core.order.domain.Order OrderHistoryServiceImpl.getOrderDetails(String)"
  })
  public void testGetOrderDetails() {
    // Arrange
    when(orderService.findOrderByOrderNumber(Mockito.<String>any()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> orderHistoryServiceImpl.getOrderDetails("42"));
    verify(orderService).findOrderByOrderNumber("42");
  }

  /**
   * Test {@link OrderHistoryServiceImpl#getOrderDetails(String)}.
   *
   * <ul>
   *   <li>Given {@link OrderService} {@link OrderService#findOrderByOrderNumber(String)} return
   *       {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link OrderHistoryServiceImpl#getOrderDetails(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.broadleafcommerce.core.order.domain.Order OrderHistoryServiceImpl.getOrderDetails(String)"
  })
  public void testGetOrderDetails_givenOrderServiceFindOrderByOrderNumberReturnNull() {
    // Arrange
    when(orderService.findOrderByOrderNumber(Mockito.<String>any())).thenReturn(null);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> orderHistoryServiceImpl.getOrderDetails("42"));
    verify(orderService).findOrderByOrderNumber("42");
  }
}
