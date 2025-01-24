package org.broadleafcommerce.profile.web.email;

import static org.junit.jupiter.api.Assertions.assertNull;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

class EmailOpenTrackingServletDiffblueTest {
  /**
   * Test
   * {@link EmailOpenTrackingServlet#doGet(HttpServletRequest, HttpServletResponse)}.
   * <ul>
   *   <li>Given {@link EmailOpenTrackingServlet} (default constructor).</li>
   *   <li>When {@link MockHttpServletRequest#MockHttpServletRequest()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EmailOpenTrackingServlet#doGet(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @DisplayName("Test doGet(HttpServletRequest, HttpServletResponse); given EmailOpenTrackingServlet (default constructor); when MockHttpServletRequest()")
  @Disabled("TODO: Complete this test")
  void testDoGet_givenEmailOpenTrackingServlet_whenMockHttpServletRequest() throws IOException, ServletException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.io.IOException: Stream closed
    //       at java.base/java.io.BufferedInputStream.getInIfOpen(BufferedInputStream.java:165)
    //       at java.base/java.io.BufferedInputStream.fill(BufferedInputStream.java:252)
    //       at java.base/java.io.BufferedInputStream.read(BufferedInputStream.java:271)
    //       at org.broadleafcommerce.profile.web.email.EmailOpenTrackingServlet.doGet(EmailOpenTrackingServlet.java:84)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange
    EmailOpenTrackingServlet emailOpenTrackingServlet = new EmailOpenTrackingServlet();
    MockHttpServletRequest request = new MockHttpServletRequest();

    // Act
    emailOpenTrackingServlet.doGet(request, new MockHttpServletResponse());
  }

  /**
   * Test new {@link EmailOpenTrackingServlet} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link EmailOpenTrackingServlet}
   */
  @Test
  @DisplayName("Test new EmailOpenTrackingServlet (default constructor)")
  void testNewEmailOpenTrackingServlet() {
    // Arrange, Act and Assert
    assertNull((new EmailOpenTrackingServlet()).getServletConfig());
  }
}
