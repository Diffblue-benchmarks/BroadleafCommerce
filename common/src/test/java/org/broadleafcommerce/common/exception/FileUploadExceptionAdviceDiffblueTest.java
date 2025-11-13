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
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.servlet.ModelAndView;

@ContextConfiguration(classes = {FileUploadExceptionAdvice.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class FileUploadExceptionAdviceDiffblueTest {
  @Autowired private FileUploadExceptionAdvice fileUploadExceptionAdvice;

  /**
   * Test {@link FileUploadExceptionAdvice#handleMaxSizeException(MaxUploadSizeExceededException,
   * HttpServletRequest, HttpServletResponse)}.
   *
   * <p>Method under test: {@link
   * FileUploadExceptionAdvice#handleMaxSizeException(MaxUploadSizeExceededException,
   * HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ModelAndView FileUploadExceptionAdvice.handleMaxSizeException(MaxUploadSizeExceededException, HttpServletRequest, HttpServletResponse)"
  })
  public void testHandleMaxSizeException() {
    // Arrange
    MaxUploadSizeExceededException exc = new MaxUploadSizeExceededException(3L);
    MockHttpServletRequest request = new MockHttpServletRequest();

    // Act
    ModelAndView actualHandleMaxSizeExceptionResult =
        fileUploadExceptionAdvice.handleMaxSizeException(
            exc, request, new MockHttpServletResponse());

    // Assert
    Map<String, Object> model = actualHandleMaxSizeExceptionResult.getModel();
    assertEquals(2, model.size());
    Object getResult = model.get("exception");
    assertTrue(getResult instanceof MaxUploadSizeExceededException);
    assertEquals("File too large!", model.get("exceptionUUID"));
    assertEquals("utility/error", actualHandleMaxSizeExceptionResult.getViewName());
    assertNull(actualHandleMaxSizeExceptionResult.getView());
    assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, actualHandleMaxSizeExceptionResult.getStatus());
    assertFalse(actualHandleMaxSizeExceptionResult.isEmpty());
    assertTrue(actualHandleMaxSizeExceptionResult.hasView());
    assertTrue(actualHandleMaxSizeExceptionResult.isReference());
    assertSame(exc, getResult);
    assertSame(model, actualHandleMaxSizeExceptionResult.getModelMap());
  }
}
