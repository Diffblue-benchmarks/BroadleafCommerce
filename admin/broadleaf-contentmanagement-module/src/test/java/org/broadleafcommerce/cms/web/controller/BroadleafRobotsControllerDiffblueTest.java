package org.broadleafcommerce.cms.web.controller;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

public class BroadleafRobotsControllerDiffblueTest {
  /**
   * Test
   * {@link BroadleafRobotsController#getRobotsFile(HttpServletRequest, HttpServletResponse)}.
   * <p>
   * Method under test:
   * {@link BroadleafRobotsController#getRobotsFile(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetRobotsFile() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.NullPointerException
    //       at org.broadleafcommerce.cms.web.controller.BroadleafRobotsController.getRobotsFile(BroadleafRobotsController.java:60)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange
    BroadleafRobotsController broadleafRobotsController = new BroadleafRobotsController();
    MockHttpServletRequest request = new MockHttpServletRequest();

    // Act
    broadleafRobotsController.getRobotsFile(request, new MockHttpServletResponse());
  }

  /**
   * Test {@link BroadleafRobotsController#isSecure(HttpServletRequest)}.
   * <ul>
   *   <li>Given {@code true}.</li>
   *   <li>When {@link MockHttpServletRequest#MockHttpServletRequest()} Secure is
   * {@code true}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BroadleafRobotsController#isSecure(HttpServletRequest)}
   */
  @Test
  public void testIsSecure_givenTrue_whenMockHttpServletRequestSecureIsTrue_thenReturnTrue() {
    // Arrange
    BroadleafRobotsController broadleafRobotsController = new BroadleafRobotsController();

    MockHttpServletRequest request = new MockHttpServletRequest();
    request.setSecure(true);

    // Act and Assert
    assertTrue(broadleafRobotsController.isSecure(request));
  }

  /**
   * Test {@link BroadleafRobotsController#isSecure(HttpServletRequest)}.
   * <ul>
   *   <li>When {@link MockHttpServletRequest#MockHttpServletRequest()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BroadleafRobotsController#isSecure(HttpServletRequest)}
   */
  @Test
  public void testIsSecure_whenMockHttpServletRequest_thenReturnFalse() {
    // Arrange
    BroadleafRobotsController broadleafRobotsController = new BroadleafRobotsController();

    // Act and Assert
    assertFalse(broadleafRobotsController.isSecure(new MockHttpServletRequest()));
  }

  /**
   * Test {@link BroadleafRobotsController#isSecure(HttpServletRequest)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BroadleafRobotsController#isSecure(HttpServletRequest)}
   */
  @Test
  public void testIsSecure_whenNull_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new BroadleafRobotsController()).isSecure(null));
  }

  /**
   * Test {@link BroadleafRobotsController#getDefaultRobotsTxt()}.
   * <p>
   * Method under test: {@link BroadleafRobotsController#getDefaultRobotsTxt()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetDefaultRobotsTxt() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.NullPointerException
    //       at org.broadleafcommerce.cms.web.controller.BroadleafRobotsController.getDefaultRobotsTxt(BroadleafRobotsController.java:96)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange and Act
    (new BroadleafRobotsController()).getDefaultRobotsTxt();
  }

  /**
   * Test new {@link BroadleafRobotsController} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link BroadleafRobotsController}
   */
  @Test
  public void testNewBroadleafRobotsController() {
    // Arrange, Act and Assert
    assertNull((new BroadleafRobotsController()).blcContextUtil);
  }
}
