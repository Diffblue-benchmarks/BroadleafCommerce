/*-
 * #%L
 * BroadleafCommerce Common Libraries
 * %%
 * Copyright (C) 2009 - 2024 Broadleaf Commerce
 * %%
 * Licensed under the Broadleaf Fair Use License Agreement, Version 1.0
 * (the "Fair Use License" located  at http://license.broadleafcommerce.org/fair_use_license-1.0.txt)
 * unless the restrictions on use therein are violated and require payment to Broadleaf in which case
 * the Broadleaf End User License Agreement (EULA), Version 1.1
 * (the "Commercial License" located at http://license.broadleafcommerce.org/commercial_license-1.1.txt)
 * shall apply.
 * 
 * Alternatively, the Commercial License may be replaced with a mutually agreed upon license (the "Custom License")
 * between you and Broadleaf Commerce. You may not use this file except in compliance with the applicable license.
 * #L%
 */
package org.broadleafcommerce.common.exception;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.broadleafcommerce.common.web.filter.SessionlessHttpServletRequestWrapper;
import org.broadleafcommerce.common.web.util.FileSystemResponseWrapper;
import org.broadleafcommerce.common.web.util.StatusExposingServletResponse;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.servlet.ModelAndView;

public class FileUploadExceptionAdviceDiffblueTest {
  /**
   * Test
   * {@link FileUploadExceptionAdvice#handleMaxSizeException(MaxUploadSizeExceededException, HttpServletRequest, HttpServletResponse)}.
   * <p>
   * Method under test:
   * {@link FileUploadExceptionAdvice#handleMaxSizeException(MaxUploadSizeExceededException, HttpServletRequest, HttpServletResponse)}
   */
  @Test
  public void testHandleMaxSizeException() throws IOException {
    // Arrange
    FileUploadExceptionAdvice fileUploadExceptionAdvice = new FileUploadExceptionAdvice();
    MaxUploadSizeExceededException exc = new MaxUploadSizeExceededException(3L);
    SessionlessHttpServletRequestWrapper request = new SessionlessHttpServletRequestWrapper(
        new MockHttpServletRequest());
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    ModelAndView actualHandleMaxSizeExceptionResult = fileUploadExceptionAdvice.handleMaxSizeException(exc, request,
        new StatusExposingServletResponse(new FileSystemResponseWrapper(response,
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile())));

    // Assert
    Map<String, Object> model = actualHandleMaxSizeExceptionResult.getModel();
    assertEquals(2, model.size());
    assertEquals("File too large!", model.get("exceptionUUID"));
    assertEquals("utility/error", actualHandleMaxSizeExceptionResult.getViewName());
    assertNull(actualHandleMaxSizeExceptionResult.getView());
    assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, actualHandleMaxSizeExceptionResult.getStatus());
    assertFalse(actualHandleMaxSizeExceptionResult.isEmpty());
    assertTrue(actualHandleMaxSizeExceptionResult.hasView());
    assertTrue(actualHandleMaxSizeExceptionResult.isReference());
    assertSame(exc, model.get("exception"));
    assertSame(model, actualHandleMaxSizeExceptionResult.getModelMap());
  }

  /**
   * Test new {@link FileUploadExceptionAdvice} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link FileUploadExceptionAdvice}
   */
  @Test
  public void testNewFileUploadExceptionAdvice() {
    // Arrange and Act
    FileUploadExceptionAdvice actualFileUploadExceptionAdvice = new FileUploadExceptionAdvice();

    // Assert
    assertEquals("utility/error", actualFileUploadExceptionAdvice.DEFAULT_ERROR_VIEW);
    assertTrue(actualFileUploadExceptionAdvice.getStatusCodesAsMap().isEmpty());
    assertEquals(Integer.MAX_VALUE, actualFileUploadExceptionAdvice.getOrder());
  }
}
