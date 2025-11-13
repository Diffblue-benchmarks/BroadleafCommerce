package org.broadleafcommerce.cms.web;

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
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {DefaultURLHandlerFilterExtensionHandler.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class DefaultURLHandlerFilterExtensionHandlerDiffblueTest {
  @Autowired
  private DefaultURLHandlerFilterExtensionHandler defaultURLHandlerFilterExtensionHandler;

  /**
   * Test {@link DefaultURLHandlerFilterExtensionHandler#processPreRedirect(HttpServletRequest,
   * HttpServletResponse, String)}.
   *
   * <p>Method under test: {@link
   * DefaultURLHandlerFilterExtensionHandler#processPreRedirect(HttpServletRequest,
   * HttpServletResponse, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType DefaultURLHandlerFilterExtensionHandler.processPreRedirect(HttpServletRequest, HttpServletResponse, String)"
  })
  public void testProcessPreRedirect() {
    // Arrange
    MockHttpServletRequest request = new MockHttpServletRequest();

    // Act and Assert
    assertEquals(
        ExtensionResultStatusType.NOT_HANDLED,
        defaultURLHandlerFilterExtensionHandler.processPreRedirect(
            request, new MockHttpServletResponse(), "https://example.org/example"));
  }

  /**
   * Test new {@link DefaultURLHandlerFilterExtensionHandler} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link
   * DefaultURLHandlerFilterExtensionHandler}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DefaultURLHandlerFilterExtensionHandler.<init>()"})
  public void testNewDefaultURLHandlerFilterExtensionHandler() {
    // Arrange and Act
    DefaultURLHandlerFilterExtensionHandler actualDefaultURLHandlerFilterExtensionHandler =
        new DefaultURLHandlerFilterExtensionHandler();

    // Assert
    assertEquals(0, actualDefaultURLHandlerFilterExtensionHandler.getPriority());
    assertTrue(actualDefaultURLHandlerFilterExtensionHandler.isEnabled());
  }
}
