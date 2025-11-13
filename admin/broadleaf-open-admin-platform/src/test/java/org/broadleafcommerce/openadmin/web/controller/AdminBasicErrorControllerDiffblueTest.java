package org.broadleafcommerce.openadmin.web.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.broadleafcommerce.common.web.BroadleafWebRequestProcessor;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ErrorProperties;
import org.springframework.boot.autoconfigure.web.ErrorProperties.IncludeAttribute;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

@ContextConfiguration(classes = {AdminBasicErrorController.class, ErrorProperties.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class AdminBasicErrorControllerDiffblueTest {
  @Autowired private AdminBasicErrorController adminBasicErrorController;

  @MockBean(name = "blAdminRequestProcessor")
  private BroadleafWebRequestProcessor broadleafWebRequestProcessor;

  @MockBean private ErrorAttributes errorAttributes;

  /**
   * Test {@link AdminBasicErrorController#AdminBasicErrorController(ErrorAttributes,
   * ErrorProperties)}.
   *
   * <p>Method under test: {@link
   * AdminBasicErrorController#AdminBasicErrorController(ErrorAttributes, ErrorProperties)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AdminBasicErrorController.<init>(ErrorAttributes, ErrorProperties)"})
  public void testNewAdminBasicErrorController() {
    // Arrange
    DefaultErrorAttributes errorAttributes = new DefaultErrorAttributes();

    ErrorProperties errorProperties = new ErrorProperties();
    errorProperties.setIncludeBindingErrors(IncludeAttribute.NEVER);
    errorProperties.setIncludeException(true);
    errorProperties.setIncludeMessage(IncludeAttribute.NEVER);
    errorProperties.setIncludeStacktrace(IncludeAttribute.NEVER);
    errorProperties.setPath("Path");

    // Act
    AdminBasicErrorController actualAdminBasicErrorController =
        new AdminBasicErrorController(errorAttributes, errorProperties);

    // Assert
    assertNull(actualAdminBasicErrorController.requestProcessor);
  }

  /**
   * Test {@link AdminBasicErrorController#errorHtml(HttpServletRequest, HttpServletResponse)}.
   *
   * <ul>
   *   <li>Then return ViewName is {@code error}.
   * </ul>
   *
   * <p>Method under test: {@link AdminBasicErrorController#errorHtml(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ModelAndView AdminBasicErrorController.errorHtml(HttpServletRequest, HttpServletResponse)"
  })
  public void testErrorHtml_thenReturnViewNameIsError() {
    // Arrange
    doNothing().when(broadleafWebRequestProcessor).process(Mockito.<WebRequest>any());
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    ModelAndView actualErrorHtmlResult = adminBasicErrorController.errorHtml(request, response);

    // Assert
    verify(broadleafWebRequestProcessor).process(isA(WebRequest.class));
    assertEquals("error", actualErrorHtmlResult.getViewName());
    assertNull(actualErrorHtmlResult.getStatus());
    assertNull(actualErrorHtmlResult.getView());
    assertEquals(500, response.getStatus());
    assertFalse(actualErrorHtmlResult.isEmpty());
    Map<String, Object> model = actualErrorHtmlResult.getModel();
    assertTrue(model.isEmpty());
    assertTrue(actualErrorHtmlResult.hasView());
    assertTrue(actualErrorHtmlResult.isReference());
    assertSame(model, actualErrorHtmlResult.getModelMap());
  }

  /**
   * Test {@link AdminBasicErrorController#errorHtml(HttpServletRequest, HttpServletResponse)}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link AdminBasicErrorController#errorHtml(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ModelAndView AdminBasicErrorController.errorHtml(HttpServletRequest, HttpServletResponse)"
  })
  public void testErrorHtml_thenThrowRuntimeException() {
    // Arrange
    doThrow(new RuntimeException())
        .when(broadleafWebRequestProcessor)
        .process(Mockito.<WebRequest>any());
    MockHttpServletRequest request = new MockHttpServletRequest();

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> adminBasicErrorController.errorHtml(request, new MockHttpServletResponse()));
    verify(broadleafWebRequestProcessor).process(isA(WebRequest.class));
  }
}
