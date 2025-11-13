package org.broadleafcommerce.core.web.controller.checkout;

import static org.junit.Assert.assertEquals;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.ui.ConcurrentModel;
import org.springframework.ui.Model;

public class BroadleafOrderConfirmationControllerDiffblueTest {
  /**
   * Test {@link BroadleafOrderConfirmationController#displayOrderConfirmationByOrderNumber(String,
   * Model, HttpServletRequest, HttpServletResponse)}.
   *
   * <p>Method under test: {@link
   * BroadleafOrderConfirmationController#displayOrderConfirmationByOrderNumber(String, Model,
   * HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BroadleafOrderConfirmationController.displayOrderConfirmationByOrderNumber(String, Model, HttpServletRequest, HttpServletResponse)"
  })
  public void testDisplayOrderConfirmationByOrderNumber() {
    // Arrange
    BroadleafOrderConfirmationController broadleafOrderConfirmationController =
        new BroadleafOrderConfirmationController();
    ConcurrentModel model = new ConcurrentModel();
    MockHttpServletRequest request = new MockHttpServletRequest();

    // Act and Assert
    assertEquals(
        "redirect:/",
        broadleafOrderConfirmationController.displayOrderConfirmationByOrderNumber(
            "42", model, request, new MockHttpServletResponse()));
  }

  /**
   * Test {@link BroadleafOrderConfirmationController#displayOrderConfirmationByOrderId(Long, Model,
   * HttpServletRequest, HttpServletResponse)}.
   *
   * <p>Method under test: {@link
   * BroadleafOrderConfirmationController#displayOrderConfirmationByOrderId(Long, Model,
   * HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BroadleafOrderConfirmationController.displayOrderConfirmationByOrderId(Long, Model, HttpServletRequest, HttpServletResponse)"
  })
  public void testDisplayOrderConfirmationByOrderId() {
    // Arrange
    BroadleafOrderConfirmationController broadleafOrderConfirmationController =
        new BroadleafOrderConfirmationController();
    ConcurrentModel model = new ConcurrentModel();
    MockHttpServletRequest request = new MockHttpServletRequest();

    // Act and Assert
    assertEquals(
        "redirect:/",
        broadleafOrderConfirmationController.displayOrderConfirmationByOrderId(
            1L, model, request, new MockHttpServletResponse()));
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link BroadleafOrderConfirmationController}
   *   <li>{@link BroadleafOrderConfirmationController#getOrderConfirmationView()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BroadleafOrderConfirmationController.<init>()",
    "String BroadleafOrderConfirmationController.getOrderConfirmationView()"
  })
  public void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals(
        "checkout/confirmation",
        new BroadleafOrderConfirmationController().getOrderConfirmationView());
  }
}
