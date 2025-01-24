package org.broadleafcommerce.cms.web;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.broadleafcommerce.common.extension.ExtensionResultStatusType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.multipart.support.DefaultMultipartHttpServletRequest;

@ContextConfiguration(classes = {DefaultURLHandlerFilterExtensionHandler.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class DefaultURLHandlerFilterExtensionHandlerDiffblueTest {
  @Autowired
  private DefaultURLHandlerFilterExtensionHandler defaultURLHandlerFilterExtensionHandler;

  /**
   * Test
   * {@link DefaultURLHandlerFilterExtensionHandler#processPreRedirect(HttpServletRequest, HttpServletResponse, String)}.
   * <ul>
   *   <li>When {@link DefaultMultipartHttpServletRequest}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultURLHandlerFilterExtensionHandler#processPreRedirect(HttpServletRequest, HttpServletResponse, String)}
   */
  @Test
  public void testProcessPreRedirect_whenDefaultMultipartHttpServletRequest() {
    // Arrange
    DefaultMultipartHttpServletRequest request = mock(DefaultMultipartHttpServletRequest.class);

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, defaultURLHandlerFilterExtensionHandler
        .processPreRedirect(request, new MockHttpServletResponse(), "https://example.org/example"));
  }

  /**
   * Test
   * {@link DefaultURLHandlerFilterExtensionHandler#processPreRedirect(HttpServletRequest, HttpServletResponse, String)}.
   * <ul>
   *   <li>When {@link MockHttpServletRequest#MockHttpServletRequest()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultURLHandlerFilterExtensionHandler#processPreRedirect(HttpServletRequest, HttpServletResponse, String)}
   */
  @Test
  public void testProcessPreRedirect_whenMockHttpServletRequest() {
    // Arrange
    MockHttpServletRequest request = new MockHttpServletRequest();

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, defaultURLHandlerFilterExtensionHandler
        .processPreRedirect(request, new MockHttpServletResponse(), "https://example.org/example"));
  }

  /**
   * Test new {@link DefaultURLHandlerFilterExtensionHandler} (default
   * constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link DefaultURLHandlerFilterExtensionHandler}
   */
  @Test
  public void testNewDefaultURLHandlerFilterExtensionHandler() {
    // Arrange and Act
    DefaultURLHandlerFilterExtensionHandler actualDefaultURLHandlerFilterExtensionHandler = new DefaultURLHandlerFilterExtensionHandler();

    // Assert
    assertEquals(0, actualDefaultURLHandlerFilterExtensionHandler.getPriority());
    assertTrue(actualDefaultURLHandlerFilterExtensionHandler.isEnabled());
  }
}
