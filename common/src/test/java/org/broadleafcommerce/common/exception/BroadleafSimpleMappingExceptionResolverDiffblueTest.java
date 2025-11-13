package org.broadleafcommerce.common.exception;

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
import org.broadleafcommerce.common.util.BLCFieldUtils;
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

@ContextConfiguration(classes = {BroadleafSimpleMappingExceptionResolver.class})
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@RunWith(SpringJUnit4ClassRunner.class)
public class BroadleafSimpleMappingExceptionResolverDiffblueTest {
  @Autowired
  private BroadleafSimpleMappingExceptionResolver broadleafSimpleMappingExceptionResolver;

  /**
   * Test {@link BroadleafSimpleMappingExceptionResolver#doResolveException(HttpServletRequest,
   * HttpServletResponse, Object, Exception)}.
   *
   * <ul>
   *   <li>Given {@link BroadleafSimpleMappingExceptionResolver}.
   * </ul>
   *
   * <p>Method under test: {@link
   * BroadleafSimpleMappingExceptionResolver#doResolveException(HttpServletRequest,
   * HttpServletResponse, Object, Exception)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ModelAndView BroadleafSimpleMappingExceptionResolver.doResolveException(HttpServletRequest, HttpServletResponse, Object, Exception)"
  })
  public void testDoResolveException_givenBroadleafSimpleMappingExceptionResolver() {
    // Arrange
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();
    Exception ex = new Exception();

    // Act
    ModelAndView actualDoResolveExceptionResult =
        broadleafSimpleMappingExceptionResolver.doResolveException(
            request, response, BLCFieldUtils.NULL_FIELD, ex);

    // Assert
    Map<String, Object> model = actualDoResolveExceptionResult.getModel();
    assertEquals(2, model.size());
    Object getResult = model.get("exception");
    assertTrue(getResult instanceof Exception);
    assertEquals("", model.get("exceptionUUID"));
    assertEquals("utility/error", actualDoResolveExceptionResult.getViewName());
    assertNull(actualDoResolveExceptionResult.getStatus());
    assertNull(actualDoResolveExceptionResult.getView());
    assertFalse(actualDoResolveExceptionResult.isEmpty());
    assertTrue(actualDoResolveExceptionResult.hasView());
    assertTrue(actualDoResolveExceptionResult.isReference());
    assertSame(ex, getResult);
    assertSame(model, actualDoResolveExceptionResult.getModelMap());
  }

  /**
   * Test {@link BroadleafSimpleMappingExceptionResolver#doResolveException(HttpServletRequest,
   * HttpServletResponse, Object, Exception)}.
   *
   * <ul>
   *   <li>Then {@link MockHttpServletResponse} (default constructor) Status is one.
   * </ul>
   *
   * <p>Method under test: {@link
   * BroadleafSimpleMappingExceptionResolver#doResolveException(HttpServletRequest,
   * HttpServletResponse, Object, Exception)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ModelAndView BroadleafSimpleMappingExceptionResolver.doResolveException(HttpServletRequest, HttpServletResponse, Object, Exception)"
  })
  public void testDoResolveException_thenMockHttpServletResponseStatusIsOne() {
    // Arrange
    BroadleafSimpleMappingExceptionResolver broadleafSimpleMappingExceptionResolver =
        new BroadleafSimpleMappingExceptionResolver();
    broadleafSimpleMappingExceptionResolver.setDefaultStatusCode(1);
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();
    Exception ex = new Exception();

    // Act
    ModelAndView actualDoResolveExceptionResult =
        broadleafSimpleMappingExceptionResolver.doResolveException(
            request, response, BLCFieldUtils.NULL_FIELD, ex);

    // Assert
    Map<String, Object> model = actualDoResolveExceptionResult.getModel();
    assertEquals(2, model.size());
    Object getResult = model.get("exception");
    assertTrue(getResult instanceof Exception);
    assertEquals("", model.get("exceptionUUID"));
    assertEquals("utility/error", actualDoResolveExceptionResult.getViewName());
    assertNull(actualDoResolveExceptionResult.getStatus());
    assertNull(actualDoResolveExceptionResult.getView());
    assertEquals(1, response.getStatus());
    assertFalse(actualDoResolveExceptionResult.isEmpty());
    assertTrue(actualDoResolveExceptionResult.hasView());
    assertTrue(actualDoResolveExceptionResult.isReference());
    assertSame(ex, getResult);
    assertSame(model, actualDoResolveExceptionResult.getModelMap());
  }

  /**
   * Test {@link BroadleafSimpleMappingExceptionResolver#resolveException(HttpServletRequest,
   * HttpServletResponse, Object, Exception)}.
   *
   * <p>Method under test: {@link
   * BroadleafSimpleMappingExceptionResolver#resolveException(HttpServletRequest,
   * HttpServletResponse, Object, Exception)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ModelAndView BroadleafSimpleMappingExceptionResolver.resolveException(HttpServletRequest, HttpServletResponse, Object, Exception)"
  })
  public void testResolveException() {
    // Arrange
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act and Assert
    assertNull(
        broadleafSimpleMappingExceptionResolver.resolveException(
            request, response, BLCFieldUtils.NULL_FIELD, new Exception()));
  }

  /**
   * Test {@link BroadleafSimpleMappingExceptionResolver#getDefaultErrorView()}.
   *
   * <p>Method under test: {@link BroadleafSimpleMappingExceptionResolver#getDefaultErrorView()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BroadleafSimpleMappingExceptionResolver.getDefaultErrorView()"})
  public void testGetDefaultErrorView() {
    // Arrange, Act and Assert
    assertEquals(
        "utility/error", new BroadleafSimpleMappingExceptionResolver().getDefaultErrorView());
  }
}
