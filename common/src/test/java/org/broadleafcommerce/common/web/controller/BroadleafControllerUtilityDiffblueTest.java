package org.broadleafcommerce.common.web.controller;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import javax.servlet.http.HttpServletRequest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

public class BroadleafControllerUtilityDiffblueTest {
  /**
   * Test {@link BroadleafControllerUtility#isAjaxRequest(HttpServletRequest)} with {@code
   * HttpServletRequest}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafControllerUtility#isAjaxRequest(HttpServletRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BroadleafControllerUtility.isAjaxRequest(HttpServletRequest)"})
  public void testIsAjaxRequestWithHttpServletRequest_given42() {
    // Arrange
    MockHttpServletRequest request = new MockHttpServletRequest();
    request.addParameter(BroadleafControllerUtility.BLC_AJAX_PARAMETER, "42");

    // Act and Assert
    assertFalse(BroadleafControllerUtility.isAjaxRequest(request));
  }

  /**
   * Test {@link BroadleafControllerUtility#isAjaxRequest(HttpServletRequest)} with {@code
   * HttpServletRequest}.
   *
   * <ul>
   *   <li>Given {@link Boolean#TRUE} toString.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafControllerUtility#isAjaxRequest(HttpServletRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BroadleafControllerUtility.isAjaxRequest(HttpServletRequest)"})
  public void testIsAjaxRequestWithHttpServletRequest_givenTrueToString_thenReturnTrue() {
    // Arrange
    MockHttpServletRequest request = new MockHttpServletRequest();
    request.addParameter(BroadleafControllerUtility.BLC_AJAX_PARAMETER, Boolean.TRUE.toString());

    // Act and Assert
    assertTrue(BroadleafControllerUtility.isAjaxRequest(request));
  }

  /**
   * Test {@link BroadleafControllerUtility#isAjaxRequest(HttpServletRequest)} with {@code
   * HttpServletRequest}.
   *
   * <ul>
   *   <li>When {@link MockHttpServletRequest#MockHttpServletRequest()}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafControllerUtility#isAjaxRequest(HttpServletRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BroadleafControllerUtility.isAjaxRequest(HttpServletRequest)"})
  public void testIsAjaxRequestWithHttpServletRequest_whenMockHttpServletRequest() {
    // Arrange, Act and Assert
    assertFalse(BroadleafControllerUtility.isAjaxRequest(new MockHttpServletRequest()));
  }

  /**
   * Test {@link BroadleafControllerUtility#isAjaxRequest(WebRequest)} with {@code WebRequest}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafControllerUtility#isAjaxRequest(WebRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BroadleafControllerUtility.isAjaxRequest(WebRequest)"})
  public void testIsAjaxRequestWithWebRequest_given42() {
    // Arrange
    MockHttpServletRequest request = new MockHttpServletRequest();
    request.addParameter(BroadleafControllerUtility.BLC_AJAX_PARAMETER, "42");

    // Act and Assert
    assertFalse(BroadleafControllerUtility.isAjaxRequest(new ServletWebRequest(request)));
  }

  /**
   * Test {@link BroadleafControllerUtility#isAjaxRequest(WebRequest)} with {@code WebRequest}.
   *
   * <ul>
   *   <li>Given {@link Boolean#TRUE} toString.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafControllerUtility#isAjaxRequest(WebRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BroadleafControllerUtility.isAjaxRequest(WebRequest)"})
  public void testIsAjaxRequestWithWebRequest_givenTrueToString_thenReturnTrue() {
    // Arrange
    MockHttpServletRequest request = new MockHttpServletRequest();
    request.addParameter(BroadleafControllerUtility.BLC_AJAX_PARAMETER, Boolean.TRUE.toString());

    // Act and Assert
    assertTrue(BroadleafControllerUtility.isAjaxRequest(new ServletWebRequest(request)));
  }

  /**
   * Test {@link BroadleafControllerUtility#isAjaxRequest(WebRequest)} with {@code WebRequest}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafControllerUtility#isAjaxRequest(WebRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BroadleafControllerUtility.isAjaxRequest(WebRequest)"})
  public void testIsAjaxRequestWithWebRequest_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(
        BroadleafControllerUtility.isAjaxRequest(
            new ServletWebRequest(new MockHttpServletRequest())));
  }
}
