package org.broadleafcommerce.openadmin.server.security.event;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class AdminForgotPasswordEventDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
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
  public void testGettersAndSetters() {
    // Arrange
    AdminForgotPasswordEvent adminForgotPasswordEvent = new AdminForgotPasswordEvent("Source", 1L, "ABC123",
        "https://example.org/example");

    // Act
    adminForgotPasswordEvent.setAdminUserId(1L);
    adminForgotPasswordEvent.setResetPasswordUrl("https://example.org/example");
    adminForgotPasswordEvent.setToken("ABC123");
    Long actualAdminUserId = adminForgotPasswordEvent.getAdminUserId();
    String actualResetPasswordUrl = adminForgotPasswordEvent.getResetPasswordUrl();

    // Assert that nothing has changed
    assertEquals("ABC123", adminForgotPasswordEvent.getToken());
    assertEquals("https://example.org/example", actualResetPasswordUrl);
    assertEquals(1L, actualAdminUserId.longValue());
  }
}
