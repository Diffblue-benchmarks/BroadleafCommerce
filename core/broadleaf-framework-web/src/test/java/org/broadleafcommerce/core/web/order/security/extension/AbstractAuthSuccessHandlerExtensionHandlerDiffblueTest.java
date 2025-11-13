package org.broadleafcommerce.core.web.order.security.extension;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.broadleafcommerce.common.extension.ExtensionResultStatusType;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.security.authentication.TestingAuthenticationToken;
import org.springframework.security.core.Authentication;

public class AbstractAuthSuccessHandlerExtensionHandlerDiffblueTest {
  /**
   * Test {@link
   * AbstractAuthSuccessHandlerExtensionHandler#preMergeCartExecution(HttpServletRequest,
   * HttpServletResponse, Authentication)}.
   *
   * <p>Method under test: {@link
   * AbstractAuthSuccessHandlerExtensionHandler#preMergeCartExecution(HttpServletRequest,
   * HttpServletResponse, Authentication)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType AbstractAuthSuccessHandlerExtensionHandler.preMergeCartExecution(HttpServletRequest, HttpServletResponse, Authentication)"
  })
  public void testPreMergeCartExecution() {
    // Arrange
    AbstractAuthSuccessHandlerExtensionHandler abstractAuthSuccessHandlerExtensionHandler =
        new AbstractAuthSuccessHandlerExtensionHandler();
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act and Assert
    assertEquals(
        ExtensionResultStatusType.NOT_HANDLED,
        abstractAuthSuccessHandlerExtensionHandler.preMergeCartExecution(
            request, response, new TestingAuthenticationToken("Principal", "Credentials")));
  }

  /**
   * Test new {@link AbstractAuthSuccessHandlerExtensionHandler} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link
   * AbstractAuthSuccessHandlerExtensionHandler}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbstractAuthSuccessHandlerExtensionHandler.<init>()"})
  public void testNewAbstractAuthSuccessHandlerExtensionHandler() {
    // Arrange and Act
    AbstractAuthSuccessHandlerExtensionHandler actualAbstractAuthSuccessHandlerExtensionHandler =
        new AbstractAuthSuccessHandlerExtensionHandler();

    // Assert
    assertEquals(0, actualAbstractAuthSuccessHandlerExtensionHandler.getPriority());
    assertTrue(actualAbstractAuthSuccessHandlerExtensionHandler.isEnabled());
  }
}
