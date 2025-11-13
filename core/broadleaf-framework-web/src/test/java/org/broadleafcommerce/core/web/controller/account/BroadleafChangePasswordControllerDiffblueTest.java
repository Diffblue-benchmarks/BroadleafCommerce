package org.broadleafcommerce.core.web.controller.account;

import static org.junit.Assert.assertEquals;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import javax.servlet.http.HttpServletRequest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.ui.ConcurrentModel;
import org.springframework.ui.Model;

public class BroadleafChangePasswordControllerDiffblueTest {
  /**
   * Test {@link BroadleafChangePasswordController#viewChangePassword(HttpServletRequest, Model)}.
   *
   * <p>Method under test: {@link
   * BroadleafChangePasswordController#viewChangePassword(HttpServletRequest, Model)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BroadleafChangePasswordController.viewChangePassword(HttpServletRequest, Model)"
  })
  public void testViewChangePassword() {
    // Arrange
    BroadleafChangePasswordController broadleafChangePasswordController =
        new BroadleafChangePasswordController();
    MockHttpServletRequest request = new MockHttpServletRequest();

    // Act and Assert
    assertEquals(
        "account/changePassword",
        broadleafChangePasswordController.viewChangePassword(request, new ConcurrentModel()));
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link BroadleafChangePasswordController}
   *   <li>{@link BroadleafChangePasswordController#getChangePasswordRedirect()}
   *   <li>{@link BroadleafChangePasswordController#getChangePasswordView()}
   *   <li>{@link BroadleafChangePasswordController#getPasswordChangedMessage()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BroadleafChangePasswordController.<init>()",
    "String BroadleafChangePasswordController.getChangePasswordRedirect()",
    "String BroadleafChangePasswordController.getChangePasswordView()",
    "String BroadleafChangePasswordController.getPasswordChangedMessage()"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    BroadleafChangePasswordController actualBroadleafChangePasswordController =
        new BroadleafChangePasswordController();
    String actualChangePasswordRedirect =
        actualBroadleafChangePasswordController.getChangePasswordRedirect();
    String actualChangePasswordView =
        actualBroadleafChangePasswordController.getChangePasswordView();

    // Assert
    assertEquals(
        "Password successfully changed",
        actualBroadleafChangePasswordController.getPasswordChangedMessage());
    assertEquals("account/changePassword", actualChangePasswordView);
    assertEquals("redirect:/account/password", actualChangePasswordRedirect);
  }
}
