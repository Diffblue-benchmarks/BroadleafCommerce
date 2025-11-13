package org.broadleafcommerce.core.web.controller.checkout;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.common.extension.ExtensionResultStatusType;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.Order;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class AbstractConfirmationControllerExtensionHandlerDiffblueTest {
  /**
   * Test {@link
   * AbstractConfirmationControllerExtensionHandler#processAdditionalConfirmationActions(Order)}.
   *
   * <p>Method under test: {@link
   * AbstractConfirmationControllerExtensionHandler#processAdditionalConfirmationActions(Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType AbstractConfirmationControllerExtensionHandler.processAdditionalConfirmationActions(Order)"
  })
  public void testProcessAdditionalConfirmationActions() {
    // Arrange
    AbstractConfirmationControllerExtensionHandler abstractConfirmationControllerExtensionHandler =
        new AbstractConfirmationControllerExtensionHandler();

    // Act and Assert
    assertEquals(
        ExtensionResultStatusType.NOT_HANDLED,
        abstractConfirmationControllerExtensionHandler.processAdditionalConfirmationActions(
            new NullOrderImpl()));
  }

  /**
   * Test new {@link AbstractConfirmationControllerExtensionHandler} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link
   * AbstractConfirmationControllerExtensionHandler}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbstractConfirmationControllerExtensionHandler.<init>()"})
  public void testNewAbstractConfirmationControllerExtensionHandler() {
    // Arrange and Act
    AbstractConfirmationControllerExtensionHandler
        actualAbstractConfirmationControllerExtensionHandler =
            new AbstractConfirmationControllerExtensionHandler();

    // Assert
    assertEquals(0, actualAbstractConfirmationControllerExtensionHandler.getPriority());
    assertTrue(actualAbstractConfirmationControllerExtensionHandler.isEnabled());
  }
}
