package org.broadleafcommerce.common.web.controller;

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

public class BroadleafRedirectControllerDiffblueTest {
  /**
   * Test {@link BroadleafRedirectController#redirect(HttpServletRequest, HttpServletResponse,
   * Model)}.
   *
   * <p>Method under test: {@link BroadleafRedirectController#redirect(HttpServletRequest,
   * HttpServletResponse, Model)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.String BroadleafRedirectController.redirect(HttpServletRequest, HttpServletResponse, Model)"
  })
  public void testRedirect() {
    // Arrange
    BroadleafRedirectController broadleafRedirectController = new BroadleafRedirectController();
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act and Assert
    assertEquals(
        "ajaxredirect:",
        broadleafRedirectController.redirect(request, response, new ConcurrentModel()));
  }
}
