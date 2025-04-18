/*-
 * #%L
 * BroadleafCommerce Common Libraries
 * %%
 * Copyright (C) 2009 - 2025 Broadleaf Commerce
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
package org.broadleafcommerce.common.web.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.nio.file.Paths;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.owasp.esapi.filters.SecurityWrapperResponse;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;

@RunWith(MockitoJUnitRunner.class)
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class StatusExposingServletResponseDiffblueTest {
  @Mock
  private HttpServletResponse httpServletResponse;

  @InjectMocks
  private StatusExposingServletResponse statusExposingServletResponse;

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link StatusExposingServletResponse#StatusExposingServletResponse(HttpServletResponse)}
   *   <li>{@link StatusExposingServletResponse#getStatus()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void StatusExposingServletResponse.<init>(HttpServletResponse)",
      "int StatusExposingServletResponse.getStatus()"})
  public void testGettersAndSetters() throws IOException {
    // Arrange
    MockHttpServletResponse response = new MockHttpServletResponse();
    FileSystemResponseWrapper response2 = new FileSystemResponseWrapper(response,
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());

    // Act
    StatusExposingServletResponse actualStatusExposingServletResponse = new StatusExposingServletResponse(response2);

    // Assert
    assertEquals(200, actualStatusExposingServletResponse.getStatus());
    assertSame(response2, actualStatusExposingServletResponse.getResponse());
  }

  /**
   * Test {@link StatusExposingServletResponse#sendError(int)} with {@code sc}.
   * <p>
   * Method under test: {@link StatusExposingServletResponse#sendError(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void StatusExposingServletResponse.sendError(int)"})
  public void testSendErrorWithSc() throws IOException {
    // Arrange
    MockHttpServletResponse response = new MockHttpServletResponse();
    StatusExposingServletResponse statusExposingServletResponse = new StatusExposingServletResponse(
        new FileSystemResponseWrapper(response, Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));

    // Act
    statusExposingServletResponse.sendError(1);

    // Assert
    ServletResponse response2 = statusExposingServletResponse.getResponse();
    assertTrue(response2 instanceof FileSystemResponseWrapper);
    ServletResponse response3 = ((FileSystemResponseWrapper) response2).getResponse();
    assertTrue(response3 instanceof MockHttpServletResponse);
    assertEquals(1, ((FileSystemResponseWrapper) response2).getStatus());
    assertEquals(1, statusExposingServletResponse.getStatus());
    assertEquals(1, ((MockHttpServletResponse) response3).getStatus());
    assertTrue(response2.isCommitted());
    assertTrue(response3.isCommitted());
    assertTrue(statusExposingServletResponse.isCommitted());
  }

  /**
   * Test {@link StatusExposingServletResponse#sendError(int)} with {@code sc}.
   * <p>
   * Method under test: {@link StatusExposingServletResponse#sendError(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void StatusExposingServletResponse.sendError(int)"})
  public void testSendErrorWithSc2() throws IOException {
    // Arrange
    MockHttpServletResponse response = new MockHttpServletResponse();
    HttpServletResponseWrapper response2 = new HttpServletResponseWrapper(new StatusExposingServletResponse(
        new FileSystemResponseWrapper(response, Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile())));
    StatusExposingServletResponse statusExposingServletResponse = new StatusExposingServletResponse(
        new FileSystemResponseWrapper(response2, Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));

    // Act
    statusExposingServletResponse.sendError(1);

    // Assert
    ServletResponse response3 = statusExposingServletResponse.getResponse();
    ServletResponse response4 = ((FileSystemResponseWrapper) response3).getResponse();
    assertTrue(response4 instanceof HttpServletResponseWrapper);
    assertTrue(response3 instanceof FileSystemResponseWrapper);
    ServletResponse response5 = ((HttpServletResponseWrapper) response4).getResponse();
    ServletResponse response6 = ((StatusExposingServletResponse) response5).getResponse();
    assertTrue(response6 instanceof FileSystemResponseWrapper);
    assertTrue(response5 instanceof StatusExposingServletResponse);
    ServletResponse response7 = ((FileSystemResponseWrapper) response6).getResponse();
    assertTrue(response7 instanceof MockHttpServletResponse);
    assertEquals(1, ((HttpServletResponseWrapper) response4).getStatus());
    assertEquals(1, ((FileSystemResponseWrapper) response6).getStatus());
    assertEquals(1, ((StatusExposingServletResponse) response5).getStatus());
    assertEquals(1, ((MockHttpServletResponse) response7).getStatus());
    assertTrue(response4.isCommitted());
  }

  /**
   * Test {@link StatusExposingServletResponse#sendError(int)} with {@code sc}.
   * <p>
   * Method under test: {@link StatusExposingServletResponse#sendError(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void StatusExposingServletResponse.sendError(int)"})
  public void testSendErrorWithSc3() throws IOException {
    // Arrange
    MockHttpServletResponse response = new MockHttpServletResponse();
    SecurityWrapperResponse response2 = new SecurityWrapperResponse(new StatusExposingServletResponse(
        new FileSystemResponseWrapper(response, Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile())),
        "Mode");

    StatusExposingServletResponse statusExposingServletResponse = new StatusExposingServletResponse(
        new FileSystemResponseWrapper(response2, Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));

    // Act
    statusExposingServletResponse.sendError(1);

    // Assert
    ServletResponse response3 = statusExposingServletResponse.getResponse();
    assertTrue(response3 instanceof FileSystemResponseWrapper);
    ServletResponse response4 = ((FileSystemResponseWrapper) response3).getResponse();
    ServletResponse response5 = ((SecurityWrapperResponse) response4).getResponse();
    ServletResponse response6 = ((StatusExposingServletResponse) response5).getResponse();
    assertTrue(response6 instanceof FileSystemResponseWrapper);
    assertTrue(response5 instanceof StatusExposingServletResponse);
    assertTrue(response4 instanceof SecurityWrapperResponse);
    ServletResponse response7 = ((FileSystemResponseWrapper) response6).getResponse();
    assertTrue(response7 instanceof MockHttpServletResponse);
    assertEquals("HTTP error code: 1", ((MockHttpServletResponse) response7).getErrorMessage());
    assertEquals(200, ((FileSystemResponseWrapper) response3).getStatus());
    assertTrue(response4.isCommitted());
    assertTrue(response7.isCommitted());
  }

  /**
   * Test {@link StatusExposingServletResponse#sendError(int)} with {@code sc}.
   * <p>
   * Method under test: {@link StatusExposingServletResponse#sendError(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void StatusExposingServletResponse.sendError(int)"})
  public void testSendErrorWithSc4() throws IOException {
    // Arrange
    MockHttpServletResponse response = new MockHttpServletResponse();
    HttpServletResponseWrapper response2 = new HttpServletResponseWrapper(new StatusExposingServletResponse(
        new FileSystemResponseWrapper(response, Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile())));
    SecurityWrapperResponse response3 = new SecurityWrapperResponse(new StatusExposingServletResponse(
        new FileSystemResponseWrapper(response2, Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile())),
        "Mode");

    StatusExposingServletResponse statusExposingServletResponse = new StatusExposingServletResponse(
        new FileSystemResponseWrapper(response3, Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));

    // Act
    statusExposingServletResponse.sendError(1);

    // Assert
    ServletResponse response4 = statusExposingServletResponse.getResponse();
    ServletResponse response5 = ((FileSystemResponseWrapper) response4).getResponse();
    ServletResponse response6 = ((SecurityWrapperResponse) response5).getResponse();
    ServletResponse response7 = ((StatusExposingServletResponse) response6).getResponse();
    ServletResponse response8 = ((FileSystemResponseWrapper) response7).getResponse();
    assertTrue(response8 instanceof HttpServletResponseWrapper);
    assertTrue(response4 instanceof FileSystemResponseWrapper);
    ServletResponse response9 = ((HttpServletResponseWrapper) response8).getResponse();
    ServletResponse response10 = ((StatusExposingServletResponse) response9).getResponse();
    assertTrue(response10 instanceof FileSystemResponseWrapper);
    assertTrue(response7 instanceof FileSystemResponseWrapper);
    assertTrue(response9 instanceof StatusExposingServletResponse);
    assertTrue(response6 instanceof StatusExposingServletResponse);
    assertTrue(response5 instanceof SecurityWrapperResponse);
    assertTrue(response9.isCommitted());
    assertTrue(response8.isCommitted());
    assertTrue(response10.isCommitted());
  }

  /**
   * Test {@link StatusExposingServletResponse#sendError(int, String)} with {@code sc}, {@code msg}.
   * <p>
   * Method under test: {@link StatusExposingServletResponse#sendError(int, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void StatusExposingServletResponse.sendError(int, String)"})
  public void testSendErrorWithScMsg() throws IOException {
    // Arrange
    MockHttpServletResponse response = new MockHttpServletResponse();
    HttpServletResponseWrapper response2 = new HttpServletResponseWrapper(new StatusExposingServletResponse(
        new FileSystemResponseWrapper(response, Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile())));
    StatusExposingServletResponse statusExposingServletResponse = new StatusExposingServletResponse(
        new FileSystemResponseWrapper(response2, Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));

    // Act
    statusExposingServletResponse.sendError(1, "Msg");

    // Assert
    ServletResponse response3 = statusExposingServletResponse.getResponse();
    ServletResponse response4 = ((FileSystemResponseWrapper) response3).getResponse();
    assertTrue(response4 instanceof HttpServletResponseWrapper);
    assertTrue(response3 instanceof FileSystemResponseWrapper);
    ServletResponse response5 = ((HttpServletResponseWrapper) response4).getResponse();
    ServletResponse response6 = ((StatusExposingServletResponse) response5).getResponse();
    assertTrue(response6 instanceof FileSystemResponseWrapper);
    assertTrue(response5 instanceof StatusExposingServletResponse);
    assertEquals(1, ((HttpServletResponseWrapper) response4).getStatus());
    assertEquals(1, ((FileSystemResponseWrapper) response6).getStatus());
    assertEquals(1, ((StatusExposingServletResponse) response5).getStatus());
    assertTrue(response5.isCommitted());
    assertTrue(response4.isCommitted());
    assertTrue(response6.isCommitted());
  }

  /**
   * Test {@link StatusExposingServletResponse#sendError(int, String)} with {@code sc}, {@code msg}.
   * <ul>
   *   <li>Then {@link StatusExposingServletResponse} Status is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link StatusExposingServletResponse#sendError(int, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void StatusExposingServletResponse.sendError(int, String)"})
  public void testSendErrorWithScMsg_thenStatusExposingServletResponseStatusIsOne() throws IOException {
    // Arrange
    doNothing().when(httpServletResponse).sendError(anyInt(), Mockito.<String>any());

    // Act
    statusExposingServletResponse.sendError(1, "Msg");

    // Assert
    verify(httpServletResponse).sendError(eq(1), eq("Msg"));
    assertEquals(1, statusExposingServletResponse.getStatus());
  }

  /**
   * Test {@link StatusExposingServletResponse#setStatus(int)} with {@code sc}.
   * <p>
   * Method under test: {@link StatusExposingServletResponse#setStatus(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void StatusExposingServletResponse.setStatus(int)"})
  public void testSetStatusWithSc() throws IOException {
    // Arrange
    MockHttpServletResponse response = new MockHttpServletResponse();
    StatusExposingServletResponse statusExposingServletResponse = new StatusExposingServletResponse(
        new FileSystemResponseWrapper(response, Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));

    // Act
    statusExposingServletResponse.setStatus(1);

    // Assert
    ServletResponse response2 = statusExposingServletResponse.getResponse();
    assertTrue(response2 instanceof FileSystemResponseWrapper);
    ServletResponse response3 = ((FileSystemResponseWrapper) response2).getResponse();
    assertTrue(response3 instanceof MockHttpServletResponse);
    assertEquals(1, ((FileSystemResponseWrapper) response2).getStatus());
    assertEquals(1, statusExposingServletResponse.getStatus());
    assertEquals(1, ((MockHttpServletResponse) response3).getStatus());
  }

  /**
   * Test {@link StatusExposingServletResponse#setStatus(int)} with {@code sc}.
   * <p>
   * Method under test: {@link StatusExposingServletResponse#setStatus(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void StatusExposingServletResponse.setStatus(int)"})
  public void testSetStatusWithSc2() throws IOException {
    // Arrange
    MockHttpServletResponse response = new MockHttpServletResponse();
    HttpServletResponseWrapper response2 = new HttpServletResponseWrapper(new StatusExposingServletResponse(
        new FileSystemResponseWrapper(response, Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile())));
    StatusExposingServletResponse statusExposingServletResponse = new StatusExposingServletResponse(
        new FileSystemResponseWrapper(response2, Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));

    // Act
    statusExposingServletResponse.setStatus(1);

    // Assert
    ServletResponse response3 = statusExposingServletResponse.getResponse();
    ServletResponse response4 = ((FileSystemResponseWrapper) response3).getResponse();
    assertTrue(response4 instanceof HttpServletResponseWrapper);
    assertTrue(response3 instanceof FileSystemResponseWrapper);
    ServletResponse response5 = ((HttpServletResponseWrapper) response4).getResponse();
    ServletResponse response6 = ((StatusExposingServletResponse) response5).getResponse();
    assertTrue(response6 instanceof FileSystemResponseWrapper);
    assertTrue(response5 instanceof StatusExposingServletResponse);
    ServletResponse response7 = ((FileSystemResponseWrapper) response6).getResponse();
    assertTrue(response7 instanceof MockHttpServletResponse);
    assertEquals(1, ((HttpServletResponseWrapper) response4).getStatus());
    assertEquals(1, ((FileSystemResponseWrapper) response6).getStatus());
    assertEquals(1, ((StatusExposingServletResponse) response5).getStatus());
    assertEquals(1, ((MockHttpServletResponse) response7).getStatus());
  }

  /**
   * Test {@link StatusExposingServletResponse#setStatus(int, String)} with {@code status}, {@code string}.
   * <p>
   * Method under test: {@link StatusExposingServletResponse#setStatus(int, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void StatusExposingServletResponse.setStatus(int, String)"})
  public void testSetStatusWithStatusString() throws IOException {
    // Arrange
    MockHttpServletResponse response = new MockHttpServletResponse();
    HttpServletResponseWrapper response2 = new HttpServletResponseWrapper(new StatusExposingServletResponse(
        new FileSystemResponseWrapper(response, Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile())));
    StatusExposingServletResponse statusExposingServletResponse = new StatusExposingServletResponse(
        new FileSystemResponseWrapper(response2, Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));

    // Act
    statusExposingServletResponse.setStatus(1, "String");

    // Assert
    ServletResponse response3 = statusExposingServletResponse.getResponse();
    ServletResponse response4 = ((FileSystemResponseWrapper) response3).getResponse();
    assertTrue(response4 instanceof HttpServletResponseWrapper);
    assertTrue(response3 instanceof FileSystemResponseWrapper);
    ServletResponse response5 = ((HttpServletResponseWrapper) response4).getResponse();
    ServletResponse response6 = ((StatusExposingServletResponse) response5).getResponse();
    assertTrue(response6 instanceof FileSystemResponseWrapper);
    assertTrue(response5 instanceof StatusExposingServletResponse);
    ServletResponse response7 = ((FileSystemResponseWrapper) response6).getResponse();
    assertTrue(response7 instanceof MockHttpServletResponse);
    assertEquals(1, ((HttpServletResponseWrapper) response4).getStatus());
    assertEquals(1, ((FileSystemResponseWrapper) response6).getStatus());
    assertEquals(1, ((StatusExposingServletResponse) response5).getStatus());
    assertEquals(1, ((MockHttpServletResponse) response7).getStatus());
  }

  /**
   * Test {@link StatusExposingServletResponse#setStatus(int, String)} with {@code status}, {@code string}.
   * <p>
   * Method under test: {@link StatusExposingServletResponse#setStatus(int, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void StatusExposingServletResponse.setStatus(int, String)"})
  public void testSetStatusWithStatusString2() throws IOException {
    // Arrange
    MockHttpServletResponse response = new MockHttpServletResponse();
    SecurityWrapperResponse response2 = new SecurityWrapperResponse(new StatusExposingServletResponse(
        new FileSystemResponseWrapper(response, Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile())),
        "Mode");

    StatusExposingServletResponse statusExposingServletResponse = new StatusExposingServletResponse(
        new FileSystemResponseWrapper(response2, Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));

    // Act
    statusExposingServletResponse.setStatus(1, "String");

    // Assert
    ServletResponse response3 = statusExposingServletResponse.getResponse();
    assertTrue(response3 instanceof FileSystemResponseWrapper);
    ServletResponse response4 = ((FileSystemResponseWrapper) response3).getResponse();
    ServletResponse response5 = ((SecurityWrapperResponse) response4).getResponse();
    ServletResponse response6 = ((StatusExposingServletResponse) response5).getResponse();
    assertTrue(response6 instanceof FileSystemResponseWrapper);
    assertTrue(response5 instanceof StatusExposingServletResponse);
    assertTrue(response4 instanceof SecurityWrapperResponse);
    ServletResponse response7 = ((FileSystemResponseWrapper) response6).getResponse();
    assertTrue(response7 instanceof MockHttpServletResponse);
    assertEquals(200, ((FileSystemResponseWrapper) response3).getStatus());
    assertTrue(response3.isCommitted());
    assertTrue(response4.isCommitted());
    assertTrue(response7.isCommitted());
    assertTrue(response6.isCommitted());
    assertTrue(response5.isCommitted());
    assertTrue(statusExposingServletResponse.isCommitted());
  }

  /**
   * Test {@link StatusExposingServletResponse#setStatus(int, String)} with {@code status}, {@code string}.
   * <ul>
   *   <li>Then {@link StatusExposingServletResponse} Status is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link StatusExposingServletResponse#setStatus(int, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void StatusExposingServletResponse.setStatus(int, String)"})
  public void testSetStatusWithStatusString_thenStatusExposingServletResponseStatusIsOne() {
    // Arrange
    doNothing().when(httpServletResponse).setStatus(anyInt(), Mockito.<String>any());

    // Act
    statusExposingServletResponse.setStatus(1, "String");

    // Assert
    verify(httpServletResponse).setStatus(eq(1), eq("String"));
    assertEquals(1, statusExposingServletResponse.getStatus());
  }
}
