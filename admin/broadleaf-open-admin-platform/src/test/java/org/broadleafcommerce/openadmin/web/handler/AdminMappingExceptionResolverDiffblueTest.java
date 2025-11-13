package org.broadleafcommerce.openadmin.web.handler;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.servlet.ModelAndView;

@ContextConfiguration(classes = {AdminMappingExceptionResolver.class})
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@RunWith(SpringJUnit4ClassRunner.class)
public class AdminMappingExceptionResolverDiffblueTest {
  @Autowired private AdminMappingExceptionResolver adminMappingExceptionResolver;

  /**
   * Test {@link AdminMappingExceptionResolver#resolveException(HttpServletRequest,
   * HttpServletResponse, Object, Exception)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link MockHttpServletRequest#MockHttpServletRequest()} addParameter {@code blcAjax}
   *       and {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link AdminMappingExceptionResolver#resolveException(HttpServletRequest,
   * HttpServletResponse, Object, Exception)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ModelAndView AdminMappingExceptionResolver.resolveException(HttpServletRequest, HttpServletResponse, Object, Exception)"
  })
  public void testResolveException_given42_whenMockHttpServletRequestAddParameterBlcAjaxAnd42() {
    // Arrange
    MockHttpServletRequest request = new MockHttpServletRequest();
    request.addParameter("blcAjax", "42");
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act and Assert
    assertNull(
        adminMappingExceptionResolver.resolveException(
            request, response, "Handler", new Exception()));
    assertEquals(200, response.getStatus());
  }

  /**
   * Test {@link AdminMappingExceptionResolver#resolveException(HttpServletRequest,
   * HttpServletResponse, Object, Exception)}.
   *
   * <ul>
   *   <li>Given {@link Boolean#TRUE} toString.
   *   <li>Then return ViewName is {@code utility/blcException}.
   * </ul>
   *
   * <p>Method under test: {@link AdminMappingExceptionResolver#resolveException(HttpServletRequest,
   * HttpServletResponse, Object, Exception)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ModelAndView AdminMappingExceptionResolver.resolveException(HttpServletRequest, HttpServletResponse, Object, Exception)"
  })
  public void testResolveException_givenTrueToString_thenReturnViewNameIsUtilityBlcException() {
    // Arrange
    MockHttpServletRequest request = new MockHttpServletRequest();
    request.addParameter("blcAjax", Boolean.TRUE.toString());
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    ModelAndView actualResolveExceptionResult =
        adminMappingExceptionResolver.resolveException(
            request, response, "Handler", new Exception());

    // Assert
    assertEquals("utility/blcException", actualResolveExceptionResult.getViewName());
    Map<String, Object> model = actualResolveExceptionResult.getModel();
    assertEquals(2, model.size());
    assertNull(model.get("exceptionMessage"));
    assertNull(actualResolveExceptionResult.getStatus());
    assertNull(actualResolveExceptionResult.getView());
    assertEquals(500, response.getStatus());
    assertFalse(actualResolveExceptionResult.isEmpty());
    assertFalse((Boolean) model.get("showDebugMessage"));
    assertTrue(actualResolveExceptionResult.hasView());
    assertTrue(actualResolveExceptionResult.isReference());
    assertSame(model, actualResolveExceptionResult.getModelMap());
  }

  /**
   * Test {@link AdminMappingExceptionResolver#resolveException(HttpServletRequest,
   * HttpServletResponse, Object, Exception)}.
   *
   * <ul>
   *   <li>Then return Model {@code debugMessage} is {@code An error has occured}.
   * </ul>
   *
   * <p>Method under test: {@link AdminMappingExceptionResolver#resolveException(HttpServletRequest,
   * HttpServletResponse, Object, Exception)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ModelAndView AdminMappingExceptionResolver.resolveException(HttpServletRequest, HttpServletResponse, Object, Exception)"
  })
  public void testResolveException_thenReturnModelDebugMessageIsAnErrorHasOccured() {
    // Arrange
    AdminMappingExceptionResolver adminMappingExceptionResolver =
        new AdminMappingExceptionResolver();
    adminMappingExceptionResolver.setShowDebugMessage(true);

    MockHttpServletRequest request = new MockHttpServletRequest();
    request.addParameter("blcAjax", Boolean.TRUE.toString());
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act and Assert
    Map<String, Object> model =
        adminMappingExceptionResolver
            .resolveException(request, response, "Handler", new Exception())
            .getModel();
    assertEquals(3, model.size());
    assertEquals("An error has occured", model.get("debugMessage"));
    assertTrue(model.containsKey("exceptionMessage"));
    assertTrue((Boolean) model.get("showDebugMessage"));
  }

  /**
   * Test {@link AdminMappingExceptionResolver#resolveException(HttpServletRequest,
   * HttpServletResponse, Object, Exception)}.
   *
   * <ul>
   *   <li>When {@link MockHttpServletRequest#MockHttpServletRequest()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AdminMappingExceptionResolver#resolveException(HttpServletRequest,
   * HttpServletResponse, Object, Exception)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ModelAndView AdminMappingExceptionResolver.resolveException(HttpServletRequest, HttpServletResponse, Object, Exception)"
  })
  public void testResolveException_whenMockHttpServletRequest_thenReturnNull() {
    // Arrange
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act and Assert
    assertNull(
        adminMappingExceptionResolver.resolveException(
            request, response, "Handler", new Exception()));
    assertEquals(200, response.getStatus());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AdminMappingExceptionResolver#setEnableStacktrace(boolean)}
   *   <li>{@link AdminMappingExceptionResolver#setShowDebugMessage(boolean)}
   *   <li>{@link AdminMappingExceptionResolver#isEnableStacktrace()}
   *   <li>{@link AdminMappingExceptionResolver#isShowDebugMessage()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AdminMappingExceptionResolver.isEnableStacktrace()",
    "boolean AdminMappingExceptionResolver.isShowDebugMessage()",
    "void AdminMappingExceptionResolver.setEnableStacktrace(boolean)",
    "void AdminMappingExceptionResolver.setShowDebugMessage(boolean)"
  })
  public void testGettersAndSetters() {
    // Arrange
    AdminMappingExceptionResolver adminMappingExceptionResolver =
        new AdminMappingExceptionResolver();

    // Act
    adminMappingExceptionResolver.setEnableStacktrace(true);
    adminMappingExceptionResolver.setShowDebugMessage(true);
    boolean actualIsEnableStacktraceResult = adminMappingExceptionResolver.isEnableStacktrace();

    // Assert
    assertTrue(actualIsEnableStacktraceResult);
    assertTrue(adminMappingExceptionResolver.isShowDebugMessage());
  }

  /**
   * Test new {@link AdminMappingExceptionResolver} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link
   * AdminMappingExceptionResolver}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AdminMappingExceptionResolver.<init>()"})
  public void testNewAdminMappingExceptionResolver() {
    // Arrange and Act
    AdminMappingExceptionResolver actualAdminMappingExceptionResolver =
        new AdminMappingExceptionResolver();

    // Assert
    assertFalse(actualAdminMappingExceptionResolver.isEnableStacktrace());
    assertFalse(actualAdminMappingExceptionResolver.isShowDebugMessage());
    assertTrue(actualAdminMappingExceptionResolver.getStatusCodesAsMap().isEmpty());
    assertEquals(Integer.MAX_VALUE, actualAdminMappingExceptionResolver.getOrder());
  }
}
