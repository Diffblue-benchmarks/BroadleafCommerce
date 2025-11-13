package org.broadleafcommerce.core.web.expression.checkout;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.broadleafcommerce.core.order.domain.FulfillmentOption;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.Order;
import org.broadleafcommerce.core.order.domain.OrderImpl;
import org.broadleafcommerce.core.order.service.FulfillmentGroupService;
import org.broadleafcommerce.core.order.service.FulfillmentOptionService;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class FulfillmentVariableExpressionDiffblueTest {
  @Mock private FulfillmentGroupService fulfillmentGroupService;

  @Mock private FulfillmentOptionService fulfillmentOptionService;

  @InjectMocks private FulfillmentVariableExpression fulfillmentVariableExpression;

  /**
   * Test {@link FulfillmentVariableExpression#getName()}.
   *
   * <p>Method under test: {@link FulfillmentVariableExpression#getName()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String FulfillmentVariableExpression.getName()"})
  public void testGetName() {
    // Arrange, Act and Assert
    assertEquals("fulfillment", new FulfillmentVariableExpression().getName());
  }

  /**
   * Test {@link FulfillmentVariableExpression#getNumShippableFulfillmentGroups()}.
   *
   * <p>Method under test: {@link FulfillmentVariableExpression#getNumShippableFulfillmentGroups()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int FulfillmentVariableExpression.getNumShippableFulfillmentGroups()"})
  public void testGetNumShippableFulfillmentGroups() {
    // Arrange
    when(fulfillmentGroupService.calculateNumShippableFulfillmentGroups(Mockito.<Order>any()))
        .thenReturn(10);

    // Act
    int actualNumShippableFulfillmentGroups =
        fulfillmentVariableExpression.getNumShippableFulfillmentGroups();

    // Assert
    verify(fulfillmentGroupService).calculateNumShippableFulfillmentGroups(isNull());
    assertEquals(10, actualNumShippableFulfillmentGroups);
  }

  /**
   * Test {@link FulfillmentVariableExpression#getFulfillmentOptions()}.
   *
   * <p>Method under test: {@link FulfillmentVariableExpression#getFulfillmentOptions()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List FulfillmentVariableExpression.getFulfillmentOptions()"})
  public void testGetFulfillmentOptions() {
    // Arrange
    when(fulfillmentOptionService.readAllFulfillmentOptions()).thenReturn(new ArrayList<>());

    // Act
    List<FulfillmentOption> actualFulfillmentOptions =
        fulfillmentVariableExpression.getFulfillmentOptions();

    // Assert
    verify(fulfillmentOptionService).readAllFulfillmentOptions();
    assertTrue(actualFulfillmentOptions.isEmpty());
  }

  /**
   * Test {@link FulfillmentVariableExpression#getMultiShipOptions()}.
   *
   * <p>Method under test: {@link FulfillmentVariableExpression#getMultiShipOptions()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List FulfillmentVariableExpression.getMultiShipOptions()"})
  public void testGetMultiShipOptions() {
    // Arrange, Act and Assert
    assertTrue(new FulfillmentVariableExpression().getMultiShipOptions().isEmpty());
  }

  /**
   * Test {@link FulfillmentVariableExpression#getFulfillmentEstimateResponse()}.
   *
   * <p>Method under test: {@link FulfillmentVariableExpression#getFulfillmentEstimateResponse()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.broadleafcommerce.core.pricing.service.fulfillment.provider.FulfillmentEstimationResponse FulfillmentVariableExpression.getFulfillmentEstimateResponse()"
  })
  public void testGetFulfillmentEstimateResponse() {
    // Arrange, Act and Assert
    assertNull(new FulfillmentVariableExpression().getFulfillmentEstimateResponse());
  }

  /**
   * Test {@link FulfillmentVariableExpression#isNullOrder(Order)}.
   *
   * <ul>
   *   <li>When {@link NullOrderImpl} (default constructor).
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentVariableExpression#isNullOrder(Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FulfillmentVariableExpression.isNullOrder(Order)"})
  public void testIsNullOrder_whenNullOrderImpl_thenReturnTrue() {
    // Arrange
    FulfillmentVariableExpression fulfillmentVariableExpression =
        new FulfillmentVariableExpression();

    // Act and Assert
    assertTrue(fulfillmentVariableExpression.isNullOrder(new NullOrderImpl()));
  }

  /**
   * Test {@link FulfillmentVariableExpression#isNullOrder(Order)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentVariableExpression#isNullOrder(Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FulfillmentVariableExpression.isNullOrder(Order)"})
  public void testIsNullOrder_whenNull_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(new FulfillmentVariableExpression().isNullOrder(null));
  }

  /**
   * Test {@link FulfillmentVariableExpression#isNullOrder(Order)}.
   *
   * <ul>
   *   <li>When {@link OrderImpl} (default constructor).
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentVariableExpression#isNullOrder(Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FulfillmentVariableExpression.isNullOrder(Order)"})
  public void testIsNullOrder_whenOrderImpl_thenReturnFalse() {
    // Arrange
    FulfillmentVariableExpression fulfillmentVariableExpression =
        new FulfillmentVariableExpression();

    // Act and Assert
    assertFalse(fulfillmentVariableExpression.isNullOrder(new OrderImpl()));
  }
}
