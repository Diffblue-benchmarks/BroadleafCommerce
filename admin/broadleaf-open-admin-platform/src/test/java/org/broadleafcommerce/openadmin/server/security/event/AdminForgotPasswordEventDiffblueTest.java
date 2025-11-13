package org.broadleafcommerce.openadmin.server.security.event;

import static org.junit.Assert.assertEquals;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class AdminForgotPasswordEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AdminForgotPasswordEvent#setAdminUserId(Long)}
   *   <li>{@link AdminForgotPasswordEvent#setResetPasswordUrl(String)}
   *   <li>{@link AdminForgotPasswordEvent#setToken(String)}
   *   <li>{@link AdminForgotPasswordEvent#getAdminUserId()}
   *   <li>{@link AdminForgotPasswordEvent#getResetPasswordUrl()}
   *   <li>{@link AdminForgotPasswordEvent#getToken()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Long AdminForgotPasswordEvent.getAdminUserId()",
    "String AdminForgotPasswordEvent.getResetPasswordUrl()",
    "String AdminForgotPasswordEvent.getToken()",
    "void AdminForgotPasswordEvent.setAdminUserId(Long)",
    "void AdminForgotPasswordEvent.setResetPasswordUrl(String)",
    "void AdminForgotPasswordEvent.setToken(String)"
  })
  public void testGettersAndSetters() {
    // Arrange
    AdminForgotPasswordEvent adminForgotPasswordEvent =
        new AdminForgotPasswordEvent("Source", 1L, "ABC123", "https://example.org/example");

    // Act
    adminForgotPasswordEvent.setAdminUserId(1L);
    adminForgotPasswordEvent.setResetPasswordUrl("https://example.org/example");
    adminForgotPasswordEvent.setToken("ABC123");
    Long actualAdminUserId = adminForgotPasswordEvent.getAdminUserId();
    String actualResetPasswordUrl = adminForgotPasswordEvent.getResetPasswordUrl();

    // Assert
    assertEquals("ABC123", adminForgotPasswordEvent.getToken());
    assertEquals("https://example.org/example", actualResetPasswordUrl);
    assertEquals(1L, actualAdminUserId.longValue());
  }
}
