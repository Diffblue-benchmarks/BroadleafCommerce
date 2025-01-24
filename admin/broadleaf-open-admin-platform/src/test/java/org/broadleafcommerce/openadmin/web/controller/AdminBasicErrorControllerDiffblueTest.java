package org.broadleafcommerce.openadmin.web.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.broadleafcommerce.common.web.BroadleafWebRequestProcessor;
import org.broadleafcommerce.openadmin.web.compatibility.JSCompatibilityRequestWrapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ErrorProperties;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.web.error.ErrorAttributeOptions;
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
  @Autowired
  private AdminBasicErrorController adminBasicErrorController;

  @MockBean(name = "blAdminRequestProcessor")
  private BroadleafWebRequestProcessor broadleafWebRequestProcessor;

  @MockBean
  private ErrorAttributes errorAttributes;

  /**
   * Test
   * {@link AdminBasicErrorController#AdminBasicErrorController(ErrorAttributes, ErrorProperties)}.
   * <p>
   * Method under test:
   * {@link AdminBasicErrorController#AdminBasicErrorController(ErrorAttributes, ErrorProperties)}
   */
  @Test
  public void testNewAdminBasicErrorController() {
    // Arrange
    ErrorProperties errorProperties = new ErrorProperties();
    errorProperties.setIncludeBindingErrors(ErrorProperties.IncludeAttribute.NEVER);
    errorProperties.setIncludeException(true);
    errorProperties.setIncludeMessage(ErrorProperties.IncludeAttribute.NEVER);
    errorProperties.setIncludeStacktrace(ErrorProperties.IncludeAttribute.NEVER);
    errorProperties.setPath("Path");

    // Act and Assert
    assertNull((new AdminBasicErrorController(errorAttributes, errorProperties)).requestProcessor);
  }

  /**
   * Test
   * {@link AdminBasicErrorController#errorHtml(HttpServletRequest, HttpServletResponse)}.
   * <ul>
   *   <li>Then return ViewName is {@code error}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminBasicErrorController#errorHtml(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  public void testErrorHtml_thenReturnViewNameIsError() {
    // Arrange
    when(errorAttributes.getErrorAttributes(Mockito.<WebRequest>any(), Mockito.<ErrorAttributeOptions>any()))
        .thenReturn(new HashMap<>());
    doNothing().when(broadleafWebRequestProcessor).process(Mockito.<WebRequest>any());
    JSCompatibilityRequestWrapper request = new JSCompatibilityRequestWrapper(new MockHttpServletRequest());
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    ModelAndView actualErrorHtmlResult = adminBasicErrorController.errorHtml(request, response);

    // Assert
    verify(broadleafWebRequestProcessor).process(isA(WebRequest.class));
    verify(errorAttributes).getErrorAttributes(isA(WebRequest.class), isA(ErrorAttributeOptions.class));
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
}
