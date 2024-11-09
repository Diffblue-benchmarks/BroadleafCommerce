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
package org.broadleafcommerce.common.web.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import java.io.IOException;
import java.nio.file.Paths;
import javax.servlet.ServletResponse;
import javax.servlet.ServletResponseWrapper;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import org.junit.Test;
import org.mockito.Mockito;
import org.owasp.esapi.filters.SecurityWrapperResponse;
import org.springframework.mock.web.MockHttpServletResponse;

public class StatusExposingServletResponseDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>
   * {@link StatusExposingServletResponse#StatusExposingServletResponse(HttpServletResponse)}
   *   <li>{@link StatusExposingServletResponse#getStatus()}
   * </ul>
   */
  @Test
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
    ServletResponse response11 = ((FileSystemResponseWrapper) response10).getResponse();
    assertTrue(response11 instanceof MockHttpServletResponse);
    assertEquals("HTTP error code: 1", ((MockHttpServletResponse) response11).getErrorMessage());
    assertTrue(response9.isCommitted());
    assertTrue(response11.isCommitted());
    assertTrue(response8.isCommitted());
    assertTrue(response10.isCommitted());
  }

  /**
   * Test {@link StatusExposingServletResponse#sendError(int, String)} with
   * {@code sc}, {@code msg}.
   * <p>
   * Method under test:
   * {@link StatusExposingServletResponse#sendError(int, String)}
   */
  @Test
  public void testSendErrorWithScMsg() throws IOException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MockHttpServletResponse response = new MockHttpServletResponse();
    StatusExposingServletResponse statusExposingServletResponse = new StatusExposingServletResponse(
        new FileSystemResponseWrapper(response, Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));

    // Act
    statusExposingServletResponse.sendError(1, "Msg");

    // Assert
    ServletResponse response2 = statusExposingServletResponse.getResponse();
    assertTrue(response2 instanceof FileSystemResponseWrapper);
    ServletResponse response3 = ((FileSystemResponseWrapper) response2).getResponse();
    assertTrue(response3 instanceof MockHttpServletResponse);
    assertEquals("Msg", ((MockHttpServletResponse) response3).getErrorMessage());
    assertEquals(1, ((FileSystemResponseWrapper) response2).getStatus());
    assertEquals(1, ((MockHttpServletResponse) response3).getStatus());
    assertTrue(response2.isCommitted());
    assertTrue(response3.isCommitted());
    assertTrue(statusExposingServletResponse.isCommitted());
  }

  /**
   * Test {@link StatusExposingServletResponse#sendError(int, String)} with
   * {@code sc}, {@code msg}.
   * <p>
   * Method under test:
   * {@link StatusExposingServletResponse#sendError(int, String)}
   */
  @Test
  public void testSendErrorWithScMsg2() throws IOException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
    ServletResponse response7 = ((FileSystemResponseWrapper) response6).getResponse();
    assertTrue(response7 instanceof MockHttpServletResponse);
    assertEquals("Msg", ((MockHttpServletResponse) response7).getErrorMessage());
    assertEquals(1, ((HttpServletResponseWrapper) response4).getStatus());
    assertEquals(1, ((FileSystemResponseWrapper) response6).getStatus());
    assertEquals(1, ((StatusExposingServletResponse) response5).getStatus());
    assertEquals(1, ((MockHttpServletResponse) response7).getStatus());
    assertTrue(response5.isCommitted());
    assertTrue(response4.isCommitted());
    assertTrue(response7.isCommitted());
    assertTrue(response6.isCommitted());
  }

  /**
   * Test {@link StatusExposingServletResponse#sendError(int, String)} with
   * {@code sc}, {@code msg}.
   * <p>
   * Method under test:
   * {@link StatusExposingServletResponse#sendError(int, String)}
   */
  @Test
  public void testSendErrorWithScMsg3() throws IOException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FileSystemResponseWrapper response = mock(FileSystemResponseWrapper.class);
    doNothing().when(response).sendError(anyInt(), Mockito.<String>any());
    StatusExposingServletResponse statusExposingServletResponse = new StatusExposingServletResponse(
        new FileSystemResponseWrapper(response, Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));

    // Act
    statusExposingServletResponse.sendError(1, "Msg");

    // Assert
    verify(response).sendError(eq(1), eq("Msg"));
    ServletResponse response2 = statusExposingServletResponse.getResponse();
    assertTrue(response2 instanceof FileSystemResponseWrapper);
    assertEquals(0, ((FileSystemResponseWrapper) response2).getStatus());
    assertEquals(1, statusExposingServletResponse.getStatus());
    assertFalse(response2.isCommitted());
    assertFalse(statusExposingServletResponse.isCommitted());
  }

  /**
   * Test {@link StatusExposingServletResponse#setStatus(int)} with {@code sc}.
   * <p>
   * Method under test: {@link StatusExposingServletResponse#setStatus(int)}
   */
  @Test
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
   * Test {@link StatusExposingServletResponse#setStatus(int, String)} with
   * {@code status}, {@code string}.
   * <p>
   * Method under test:
   * {@link StatusExposingServletResponse#setStatus(int, String)}
   */
  @Test
  public void testSetStatusWithStatusString() throws IOException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MockHttpServletResponse response = new MockHttpServletResponse();
    StatusExposingServletResponse statusExposingServletResponse = new StatusExposingServletResponse(
        new FileSystemResponseWrapper(response, Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));

    // Act
    statusExposingServletResponse.setStatus(1, "String");

    // Assert
    ServletResponse response2 = statusExposingServletResponse.getResponse();
    assertTrue(response2 instanceof FileSystemResponseWrapper);
    ServletResponse response3 = ((FileSystemResponseWrapper) response2).getResponse();
    assertTrue(response3 instanceof MockHttpServletResponse);
    assertEquals("String", ((MockHttpServletResponse) response3).getErrorMessage());
    assertEquals(1, ((FileSystemResponseWrapper) response2).getStatus());
    assertEquals(1, ((MockHttpServletResponse) response3).getStatus());
    assertFalse(statusExposingServletResponse.isCommitted());
  }

  /**
   * Test {@link StatusExposingServletResponse#setStatus(int, String)} with
   * {@code status}, {@code string}.
   * <p>
   * Method under test:
   * {@link StatusExposingServletResponse#setStatus(int, String)}
   */
  @Test
  public void testSetStatusWithStatusString2() throws IOException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
    assertEquals("String", ((MockHttpServletResponse) response7).getErrorMessage());
    assertEquals(1, ((HttpServletResponseWrapper) response4).getStatus());
    assertEquals(1, ((FileSystemResponseWrapper) response6).getStatus());
    assertEquals(1, ((StatusExposingServletResponse) response5).getStatus());
    assertEquals(1, ((MockHttpServletResponse) response7).getStatus());
  }

  /**
   * Test {@link StatusExposingServletResponse#setStatus(int, String)} with
   * {@code status}, {@code string}.
   * <p>
   * Method under test:
   * {@link StatusExposingServletResponse#setStatus(int, String)}
   */
  @Test
  public void testSetStatusWithStatusString3() throws IOException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FileSystemResponseWrapper response = mock(FileSystemResponseWrapper.class);
    doNothing().when(response).setStatus(anyInt(), Mockito.<String>any());
    StatusExposingServletResponse statusExposingServletResponse = new StatusExposingServletResponse(
        new FileSystemResponseWrapper(response, Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));

    // Act
    statusExposingServletResponse.setStatus(1, "String");

    // Assert
    verify(response).setStatus(eq(1), eq("String"));
    ServletResponse response2 = statusExposingServletResponse.getResponse();
    assertTrue(response2 instanceof FileSystemResponseWrapper);
    assertEquals(0, ((FileSystemResponseWrapper) response2).getStatus());
    assertEquals(1, statusExposingServletResponse.getStatus());
    assertFalse(statusExposingServletResponse.isCommitted());
  }

  /**
   * Test {@link StatusExposingServletResponse#setStatus(int, String)} with
   * {@code status}, {@code string}.
   * <p>
   * Method under test:
   * {@link StatusExposingServletResponse#setStatus(int, String)}
   */
  @Test
  public void testSetStatusWithStatusString4() throws IOException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile();
    MockHttpServletResponse response = new MockHttpServletResponse();
    StatusExposingServletResponse statusExposingServletResponse = new StatusExposingServletResponse(
        new SecurityWrapperResponse(new StatusExposingServletResponse(new FileSystemResponseWrapper(response,
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile())), "Mode"));

    // Act
    statusExposingServletResponse.setStatus(1, "String");

    // Assert
    ServletResponse response2 = statusExposingServletResponse.getResponse();
    ServletResponse response3 = ((SecurityWrapperResponse) response2).getResponse();
    ServletResponse response4 = ((StatusExposingServletResponse) response3).getResponse();
    assertTrue(response4 instanceof FileSystemResponseWrapper);
    assertTrue(response3 instanceof StatusExposingServletResponse);
    assertTrue(response2 instanceof SecurityWrapperResponse);
    ServletResponse response5 = ((FileSystemResponseWrapper) response4).getResponse();
    assertTrue(response5 instanceof MockHttpServletResponse);
    assertEquals("String", ((MockHttpServletResponse) response5).getErrorMessage());
    assertTrue(response2.isCommitted());
    assertTrue(response5.isCommitted());
    assertTrue(response4.isCommitted());
    assertTrue(response3.isCommitted());
    assertTrue(statusExposingServletResponse.isCommitted());
  }

  /**
   * Test {@link StatusExposingServletResponse#setStatus(int, String)} with
   * {@code status}, {@code string}.
   * <p>
   * Method under test:
   * {@link StatusExposingServletResponse#setStatus(int, String)}
   */
  @Test
  public void testSetStatusWithStatusString5() throws IOException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile();
    MockHttpServletResponse response = new MockHttpServletResponse();
    HttpServletResponseWrapper response2 = new HttpServletResponseWrapper(new StatusExposingServletResponse(
        new FileSystemResponseWrapper(response, Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile())));
    StatusExposingServletResponse statusExposingServletResponse = new StatusExposingServletResponse(
        new SecurityWrapperResponse(new StatusExposingServletResponse(new FileSystemResponseWrapper(response2,
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile())), "Mode"));

    // Act
    statusExposingServletResponse.setStatus(1, "String");

    // Assert
    ServletResponse response3 = statusExposingServletResponse.getResponse();
    ServletResponse response4 = ((SecurityWrapperResponse) response3).getResponse();
    ServletResponse response5 = ((StatusExposingServletResponse) response4).getResponse();
    ServletResponse response6 = ((FileSystemResponseWrapper) response5).getResponse();
    assertTrue(response6 instanceof HttpServletResponseWrapper);
    ServletResponse response7 = ((HttpServletResponseWrapper) response6).getResponse();
    ServletResponse response8 = ((StatusExposingServletResponse) response7).getResponse();
    assertTrue(response8 instanceof FileSystemResponseWrapper);
    assertTrue(response5 instanceof FileSystemResponseWrapper);
    assertTrue(response7 instanceof StatusExposingServletResponse);
    assertTrue(response4 instanceof StatusExposingServletResponse);
    assertTrue(response3 instanceof SecurityWrapperResponse);
    ServletResponse response9 = ((FileSystemResponseWrapper) response8).getResponse();
    assertTrue(response9 instanceof MockHttpServletResponse);
    assertEquals("String", ((MockHttpServletResponse) response9).getErrorMessage());
    assertTrue(response7.isCommitted());
    assertTrue(response9.isCommitted());
    assertTrue(response6.isCommitted());
    assertTrue(response8.isCommitted());
  }

  /**
   * Test {@link StatusExposingServletResponse#reset()}.
   * <ul>
   *   <li>Given {@link FileSystemResponseWrapper}
   * {@link ServletResponseWrapper#reset()} does nothing.</li>
   *   <li>Then calls {@link ServletResponseWrapper#reset()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StatusExposingServletResponse#reset()}
   */
  @Test
  public void testReset_givenFileSystemResponseWrapperResetDoesNothing_thenCallsReset() throws IOException {
    // Arrange
    FileSystemResponseWrapper response = mock(FileSystemResponseWrapper.class);
    doNothing().when(response).reset();

    // Act
    (new StatusExposingServletResponse(
        new FileSystemResponseWrapper(response, Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile())))
            .reset();

    // Assert
    verify(response).reset();
  }
}
