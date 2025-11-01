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
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import java.io.IOException;
import java.nio.file.Paths;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import org.junit.Test;
import org.mockito.Mockito;
import org.owasp.esapi.filters.SecurityWrapperResponse;
import org.springframework.mock.web.MockHttpServletResponse;

public class StatusExposingServletResponseDiffblueTest {
  /**
   * Method under test: {@link StatusExposingServletResponse#sendError(int)}
   */
  @Test
  public void testSendError() throws IOException {
    // Arrange
    MockHttpServletResponse response = new MockHttpServletResponse();
    FileSystemResponseWrapper response2 = new FileSystemResponseWrapper(response,
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());

    StatusExposingServletResponse statusExposingServletResponse = new StatusExposingServletResponse(response2);

    // Act
    statusExposingServletResponse.sendError(1);

    // Assert
    assertEquals(1, statusExposingServletResponse.getStatus());
    assertTrue(statusExposingServletResponse.isCommitted());
    assertSame(response2, statusExposingServletResponse.getResponse());
  }

  /**
   * Method under test: {@link StatusExposingServletResponse#sendError(int)}
   */
  @Test
  public void testSendError2() throws IOException {
    // Arrange
    MockHttpServletResponse response = new MockHttpServletResponse();
    HttpServletResponseWrapper response2 = new HttpServletResponseWrapper(new StatusExposingServletResponse(
        new FileSystemResponseWrapper(response, Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile())));
    FileSystemResponseWrapper response3 = new FileSystemResponseWrapper(response2,
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());

    StatusExposingServletResponse statusExposingServletResponse = new StatusExposingServletResponse(response3);

    // Act
    statusExposingServletResponse.sendError(1);

    // Assert
    assertEquals(1, statusExposingServletResponse.getStatus());
    assertTrue(statusExposingServletResponse.isCommitted());
    assertSame(response3, statusExposingServletResponse.getResponse());
  }

  /**
   * Method under test: {@link StatusExposingServletResponse#sendError(int)}
   */
  @Test
  public void testSendError3() throws IOException {
    // Arrange
    MockHttpServletResponse response = new MockHttpServletResponse();
    SecurityWrapperResponse response2 = new SecurityWrapperResponse(new StatusExposingServletResponse(
        new FileSystemResponseWrapper(response, Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile())),
        "Mode");

    FileSystemResponseWrapper response3 = new FileSystemResponseWrapper(response2,
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());

    StatusExposingServletResponse statusExposingServletResponse = new StatusExposingServletResponse(response3);

    // Act
    statusExposingServletResponse.sendError(1);

    // Assert
    assertEquals(1, statusExposingServletResponse.getStatus());
    assertTrue(statusExposingServletResponse.isCommitted());
    assertSame(response3, statusExposingServletResponse.getResponse());
  }

  /**
   * Method under test: {@link StatusExposingServletResponse#sendError(int)}
   */
  @Test
  public void testSendError4() throws IOException {
    // Arrange
    MockHttpServletResponse response = new MockHttpServletResponse();
    HttpServletResponseWrapper response2 = new HttpServletResponseWrapper(new StatusExposingServletResponse(
        new FileSystemResponseWrapper(response, Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile())));
    SecurityWrapperResponse response3 = new SecurityWrapperResponse(new StatusExposingServletResponse(
        new FileSystemResponseWrapper(response2, Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile())),
        "Mode");

    FileSystemResponseWrapper response4 = new FileSystemResponseWrapper(response3,
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());

    StatusExposingServletResponse statusExposingServletResponse = new StatusExposingServletResponse(response4);

    // Act
    statusExposingServletResponse.sendError(1);

    // Assert
    assertEquals(1, statusExposingServletResponse.getStatus());
    assertTrue(statusExposingServletResponse.isCommitted());
    assertSame(response4, statusExposingServletResponse.getResponse());
  }

  /**
   * Method under test:
   * {@link StatusExposingServletResponse#sendError(int, String)}
   */
  @Test
  public void testSendError5() throws IOException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MockHttpServletResponse response = new MockHttpServletResponse();
    FileSystemResponseWrapper response2 = new FileSystemResponseWrapper(response,
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());

    StatusExposingServletResponse statusExposingServletResponse = new StatusExposingServletResponse(response2);

    // Act
    statusExposingServletResponse.sendError(1, "Msg");

    // Assert
    assertEquals(1, statusExposingServletResponse.getStatus());
    assertTrue(statusExposingServletResponse.isCommitted());
    assertSame(response2, statusExposingServletResponse.getResponse());
  }

  /**
   * Method under test:
   * {@link StatusExposingServletResponse#sendError(int, String)}
   */
  @Test
  public void testSendError6() throws IOException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MockHttpServletResponse response = new MockHttpServletResponse();
    HttpServletResponseWrapper response2 = new HttpServletResponseWrapper(new StatusExposingServletResponse(
        new FileSystemResponseWrapper(response, Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile())));
    FileSystemResponseWrapper response3 = new FileSystemResponseWrapper(response2,
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());

    StatusExposingServletResponse statusExposingServletResponse = new StatusExposingServletResponse(response3);

    // Act
    statusExposingServletResponse.sendError(1, "Msg");

    // Assert
    assertEquals(1, statusExposingServletResponse.getStatus());
    assertTrue(statusExposingServletResponse.isCommitted());
    assertSame(response3, statusExposingServletResponse.getResponse());
  }

  /**
   * Method under test:
   * {@link StatusExposingServletResponse#sendError(int, String)}
   */
  @Test
  public void testSendError7() throws IOException {
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
    assertEquals(1, statusExposingServletResponse.getStatus());
  }

  /**
   * Method under test: {@link StatusExposingServletResponse#setStatus(int)}
   */
  @Test
  public void testSetStatus() throws IOException {
    // Arrange
    MockHttpServletResponse response = new MockHttpServletResponse();
    FileSystemResponseWrapper response2 = new FileSystemResponseWrapper(response,
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());

    StatusExposingServletResponse statusExposingServletResponse = new StatusExposingServletResponse(response2);

    // Act
    statusExposingServletResponse.setStatus(1);

    // Assert
    assertEquals(1, statusExposingServletResponse.getStatus());
    assertSame(response2, statusExposingServletResponse.getResponse());
  }

  /**
   * Method under test: {@link StatusExposingServletResponse#setStatus(int)}
   */
  @Test
  public void testSetStatus2() throws IOException {
    // Arrange
    MockHttpServletResponse response = new MockHttpServletResponse();
    HttpServletResponseWrapper response2 = new HttpServletResponseWrapper(new StatusExposingServletResponse(
        new FileSystemResponseWrapper(response, Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile())));
    FileSystemResponseWrapper response3 = new FileSystemResponseWrapper(response2,
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());

    StatusExposingServletResponse statusExposingServletResponse = new StatusExposingServletResponse(response3);

    // Act
    statusExposingServletResponse.setStatus(1);

    // Assert
    assertEquals(1, statusExposingServletResponse.getStatus());
    assertSame(response3, statusExposingServletResponse.getResponse());
  }

  /**
   * Method under test:
   * {@link StatusExposingServletResponse#setStatus(int, String)}
   */
  @Test
  public void testSetStatus3() throws IOException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MockHttpServletResponse response = new MockHttpServletResponse();
    FileSystemResponseWrapper response2 = new FileSystemResponseWrapper(response,
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());

    StatusExposingServletResponse statusExposingServletResponse = new StatusExposingServletResponse(response2);

    // Act
    statusExposingServletResponse.setStatus(1, "String");

    // Assert
    assertEquals(1, statusExposingServletResponse.getStatus());
    assertSame(response2, statusExposingServletResponse.getResponse());
  }

  /**
   * Method under test:
   * {@link StatusExposingServletResponse#setStatus(int, String)}
   */
  @Test
  public void testSetStatus4() throws IOException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MockHttpServletResponse response = new MockHttpServletResponse();
    HttpServletResponseWrapper response2 = new HttpServletResponseWrapper(new StatusExposingServletResponse(
        new FileSystemResponseWrapper(response, Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile())));
    FileSystemResponseWrapper response3 = new FileSystemResponseWrapper(response2,
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());

    StatusExposingServletResponse statusExposingServletResponse = new StatusExposingServletResponse(response3);

    // Act
    statusExposingServletResponse.setStatus(1, "String");

    // Assert
    assertEquals(1, statusExposingServletResponse.getStatus());
    assertSame(response3, statusExposingServletResponse.getResponse());
  }

  /**
   * Method under test:
   * {@link StatusExposingServletResponse#setStatus(int, String)}
   */
  @Test
  public void testSetStatus5() throws IOException {
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
    assertEquals(1, statusExposingServletResponse.getStatus());
  }

  /**
   * Method under test:
   * {@link StatusExposingServletResponse#setStatus(int, String)}
   */
  @Test
  public void testSetStatus6() throws IOException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile();
    MockHttpServletResponse response = new MockHttpServletResponse();
    SecurityWrapperResponse response2 = new SecurityWrapperResponse(new StatusExposingServletResponse(
        new FileSystemResponseWrapper(response, Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile())),
        "Mode");

    StatusExposingServletResponse statusExposingServletResponse = new StatusExposingServletResponse(response2);

    // Act
    statusExposingServletResponse.setStatus(1, "String");

    // Assert
    assertEquals(1, statusExposingServletResponse.getStatus());
    assertTrue(statusExposingServletResponse.isCommitted());
    assertSame(response2, statusExposingServletResponse.getResponse());
  }

  /**
   * Method under test:
   * {@link StatusExposingServletResponse#setStatus(int, String)}
   */
  @Test
  public void testSetStatus7() throws IOException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile();
    MockHttpServletResponse response = new MockHttpServletResponse();
    HttpServletResponseWrapper response2 = new HttpServletResponseWrapper(new StatusExposingServletResponse(
        new FileSystemResponseWrapper(response, Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile())));
    SecurityWrapperResponse response3 = new SecurityWrapperResponse(new StatusExposingServletResponse(
        new FileSystemResponseWrapper(response2, Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile())),
        "Mode");

    StatusExposingServletResponse statusExposingServletResponse = new StatusExposingServletResponse(response3);

    // Act
    statusExposingServletResponse.setStatus(1, "String");

    // Assert
    assertEquals(1, statusExposingServletResponse.getStatus());
    assertTrue(statusExposingServletResponse.isCommitted());
    assertSame(response3, statusExposingServletResponse.getResponse());
  }

  /**
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
   * Method under test: {@link StatusExposingServletResponse#reset()}
   */
  @Test
  public void testReset() throws IOException {
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
