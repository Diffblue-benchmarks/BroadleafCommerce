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
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
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

@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@RunWith(MockitoJUnitRunner.class)
public class StatusExposingServletResponseDiffblueTest {
  @Mock private HttpServletResponse httpServletResponse;

  @InjectMocks private StatusExposingServletResponse statusExposingServletResponse;

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link StatusExposingServletResponse#StatusExposingServletResponse(HttpServletResponse)}
   *   <li>{@link StatusExposingServletResponse#getStatus()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void StatusExposingServletResponse.<init>(HttpServletResponse)",
    "int StatusExposingServletResponse.getStatus()"
  })
  public void testGettersAndSetters() throws IOException {
    // Arrange
    FileSystemResponseWrapper response =
        new FileSystemResponseWrapper(
            new MockHttpServletResponse(),
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());
    HttpServletResponseWrapper response2 = new HttpServletResponseWrapper(response);

    // Act
    StatusExposingServletResponse actualStatusExposingServletResponse =
        new StatusExposingServletResponse(response2);

    // Assert
    assertEquals(200, actualStatusExposingServletResponse.getStatus());
    assertSame(response2, actualStatusExposingServletResponse.getResponse());
  }

  /**
   * Test {@link StatusExposingServletResponse#sendError(int)} with {@code sc}.
   *
   * <p>Method under test: {@link StatusExposingServletResponse#sendError(int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void StatusExposingServletResponse.sendError(int)"})
  public void testSendErrorWithSc() throws IOException {
    // Arrange
    StatusExposingServletResponse statusExposingServletResponse =
        new StatusExposingServletResponse(
            new HttpServletResponseWrapper(new MockHttpServletResponse()));

    // Act
    statusExposingServletResponse.sendError(1);

    // Assert
    ServletResponse response = statusExposingServletResponse.getResponse();
    assertTrue(response instanceof HttpServletResponseWrapper);
    ServletResponse response2 = ((HttpServletResponseWrapper) response).getResponse();
    assertTrue(response2 instanceof MockHttpServletResponse);
    assertEquals(1, ((HttpServletResponseWrapper) response).getStatus());
    assertEquals(1, statusExposingServletResponse.getStatus());
    assertEquals(1, ((MockHttpServletResponse) response2).getStatus());
    assertTrue(response.isCommitted());
    assertTrue(response2.isCommitted());
    assertTrue(statusExposingServletResponse.isCommitted());
  }

  /**
   * Test {@link StatusExposingServletResponse#sendError(int)} with {@code sc}.
   *
   * <p>Method under test: {@link StatusExposingServletResponse#sendError(int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void StatusExposingServletResponse.sendError(int)"})
  public void testSendErrorWithSc2() throws IOException {
    // Arrange
    HttpServletResponseWrapper response =
        new HttpServletResponseWrapper(
            new StatusExposingServletResponse(new MockHttpServletResponse()));
    HttpServletResponseWrapper response2 = new HttpServletResponseWrapper(response);
    StatusExposingServletResponse statusExposingServletResponse =
        new StatusExposingServletResponse(response2);

    // Act
    statusExposingServletResponse.sendError(1);

    // Assert
    ServletResponse response3 = statusExposingServletResponse.getResponse();
    assertTrue(response3 instanceof HttpServletResponseWrapper);
    ServletResponse response4 = ((HttpServletResponseWrapper) response3).getResponse();
    assertTrue(response4 instanceof HttpServletResponseWrapper);
    ServletResponse response5 = ((HttpServletResponseWrapper) response4).getResponse();
    assertTrue(response5 instanceof StatusExposingServletResponse);
    ServletResponse response6 = ((StatusExposingServletResponse) response5).getResponse();
    assertTrue(response6 instanceof MockHttpServletResponse);
    assertEquals(1, ((HttpServletResponseWrapper) response4).getStatus());
    assertEquals(1, ((StatusExposingServletResponse) response5).getStatus());
    assertEquals(1, ((MockHttpServletResponse) response6).getStatus());
    assertTrue(response4.isCommitted());
    assertTrue(response6.isCommitted());
  }

  /**
   * Test {@link StatusExposingServletResponse#sendError(int)} with {@code sc}.
   *
   * <p>Method under test: {@link StatusExposingServletResponse#sendError(int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void StatusExposingServletResponse.sendError(int)"})
  public void testSendErrorWithSc3() throws IOException {
    // Arrange
    HttpServletResponseWrapper response =
        new HttpServletResponseWrapper(
            new StatusExposingServletResponse(new MockHttpServletResponse()));
    SecurityWrapperResponse response2 = new SecurityWrapperResponse(response, "Mode");
    StatusExposingServletResponse statusExposingServletResponse =
        new StatusExposingServletResponse(new HttpServletResponseWrapper(response2));

    // Act
    statusExposingServletResponse.sendError(1);

    // Assert
    ServletResponse response3 = statusExposingServletResponse.getResponse();
    assertTrue(response3 instanceof HttpServletResponseWrapper);
    ServletResponse response4 = ((HttpServletResponseWrapper) response3).getResponse();
    ServletResponse response5 = ((SecurityWrapperResponse) response4).getResponse();
    assertTrue(response5 instanceof HttpServletResponseWrapper);
    ServletResponse response6 = ((HttpServletResponseWrapper) response5).getResponse();
    assertTrue(response6 instanceof StatusExposingServletResponse);
    assertTrue(response4 instanceof SecurityWrapperResponse);
    ServletResponse response7 = ((StatusExposingServletResponse) response6).getResponse();
    assertTrue(response7 instanceof MockHttpServletResponse);
    assertEquals("HTTP error code: 1", ((MockHttpServletResponse) response7).getErrorMessage());
    assertEquals(200, ((HttpServletResponseWrapper) response3).getStatus());
    assertTrue(response4.isCommitted());
    assertTrue(response6.isCommitted());
    assertTrue(response7.isCommitted());
  }

  /**
   * Test {@link StatusExposingServletResponse#sendError(int)} with {@code sc}.
   *
   * <p>Method under test: {@link StatusExposingServletResponse#sendError(int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void StatusExposingServletResponse.sendError(int)"})
  public void testSendErrorWithSc4() throws IOException {
    // Arrange
    HttpServletResponseWrapper response =
        new HttpServletResponseWrapper(
            new StatusExposingServletResponse(new MockHttpServletResponse()));
    StatusExposingServletResponse response2 = new StatusExposingServletResponse(response);
    HttpServletResponseWrapper response3 = new HttpServletResponseWrapper(response2);
    SecurityWrapperResponse response4 = new SecurityWrapperResponse(response3, "Mode");
    StatusExposingServletResponse statusExposingServletResponse =
        new StatusExposingServletResponse(new HttpServletResponseWrapper(response4));

    // Act
    statusExposingServletResponse.sendError(1);

    // Assert
    ServletResponse response5 = statusExposingServletResponse.getResponse();
    assertTrue(response5 instanceof HttpServletResponseWrapper);
    ServletResponse response6 = ((HttpServletResponseWrapper) response5).getResponse();
    ServletResponse response7 = ((SecurityWrapperResponse) response6).getResponse();
    ServletResponse response8 = ((HttpServletResponseWrapper) response7).getResponse();
    ServletResponse response9 = ((StatusExposingServletResponse) response8).getResponse();
    assertTrue(response9 instanceof HttpServletResponseWrapper);
    assertTrue(response7 instanceof HttpServletResponseWrapper);
    ServletResponse response10 = ((HttpServletResponseWrapper) response9).getResponse();
    assertTrue(response10 instanceof StatusExposingServletResponse);
    assertTrue(response8 instanceof StatusExposingServletResponse);
    assertTrue(response6 instanceof SecurityWrapperResponse);
    ServletResponse response11 = ((StatusExposingServletResponse) response10).getResponse();
    assertTrue(response11 instanceof MockHttpServletResponse);
    assertEquals("HTTP error code: 1", ((MockHttpServletResponse) response11).getErrorMessage());
    assertTrue(response10.isCommitted());
    assertTrue(response11.isCommitted());
    assertTrue(response9.isCommitted());
  }

  /**
   * Test {@link StatusExposingServletResponse#sendError(int, String)} with {@code sc}, {@code msg}.
   *
   * <p>Method under test: {@link StatusExposingServletResponse#sendError(int, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void StatusExposingServletResponse.sendError(int, String)"})
  public void testSendErrorWithScMsg() throws IOException {
    // Arrange
    HttpServletResponseWrapper response =
        new HttpServletResponseWrapper(
            new StatusExposingServletResponse(new MockHttpServletResponse()));
    HttpServletResponseWrapper response2 = new HttpServletResponseWrapper(response);
    StatusExposingServletResponse statusExposingServletResponse =
        new StatusExposingServletResponse(response2);

    // Act
    statusExposingServletResponse.sendError(1, "Msg");

    // Assert
    ServletResponse response3 = statusExposingServletResponse.getResponse();
    assertTrue(response3 instanceof HttpServletResponseWrapper);
    ServletResponse response4 = ((HttpServletResponseWrapper) response3).getResponse();
    assertTrue(response4 instanceof HttpServletResponseWrapper);
    ServletResponse response5 = ((HttpServletResponseWrapper) response4).getResponse();
    assertTrue(response5 instanceof StatusExposingServletResponse);
    ServletResponse response6 = ((StatusExposingServletResponse) response5).getResponse();
    assertTrue(response6 instanceof MockHttpServletResponse);
    assertEquals("Msg", ((MockHttpServletResponse) response6).getErrorMessage());
    assertEquals(1, ((HttpServletResponseWrapper) response4).getStatus());
    assertEquals(1, ((StatusExposingServletResponse) response5).getStatus());
    assertEquals(1, ((MockHttpServletResponse) response6).getStatus());
    assertTrue(response4.isCommitted());
    assertTrue(response5.isCommitted());
    assertTrue(response6.isCommitted());
  }

  /**
   * Test {@link StatusExposingServletResponse#sendError(int, String)} with {@code sc}, {@code msg}.
   *
   * <ul>
   *   <li>Then {@link StatusExposingServletResponse} Status is one.
   * </ul>
   *
   * <p>Method under test: {@link StatusExposingServletResponse#sendError(int, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void StatusExposingServletResponse.sendError(int, String)"})
  public void testSendErrorWithScMsg_thenStatusExposingServletResponseStatusIsOne()
      throws IOException {
    // Arrange
    doNothing().when(httpServletResponse).sendError(anyInt(), Mockito.<String>any());

    // Act
    statusExposingServletResponse.sendError(1, "Msg");

    // Assert
    verify(httpServletResponse).sendError(1, "Msg");
    assertEquals(1, statusExposingServletResponse.getStatus());
  }

  /**
   * Test {@link StatusExposingServletResponse#sendError(int, String)} with {@code sc}, {@code msg}.
   *
   * <ul>
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link StatusExposingServletResponse#sendError(int, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void StatusExposingServletResponse.sendError(int, String)"})
  public void testSendErrorWithScMsg_thenThrowIOException() throws IOException {
    // Arrange
    doThrow(new IOException()).when(httpServletResponse).sendError(anyInt(), Mockito.<String>any());

    // Act and Assert
    assertThrows(IOException.class, () -> statusExposingServletResponse.sendError(1, "Msg"));
    verify(httpServletResponse).sendError(1, "Msg");
  }

  /**
   * Test {@link StatusExposingServletResponse#setStatus(int)} with {@code sc}.
   *
   * <p>Method under test: {@link StatusExposingServletResponse#setStatus(int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void StatusExposingServletResponse.setStatus(int)"})
  public void testSetStatusWithSc() {
    // Arrange
    StatusExposingServletResponse statusExposingServletResponse =
        new StatusExposingServletResponse(
            new HttpServletResponseWrapper(new MockHttpServletResponse()));

    // Act
    statusExposingServletResponse.setStatus(1);

    // Assert
    ServletResponse response = statusExposingServletResponse.getResponse();
    assertTrue(response instanceof HttpServletResponseWrapper);
    ServletResponse response2 = ((HttpServletResponseWrapper) response).getResponse();
    assertTrue(response2 instanceof MockHttpServletResponse);
    assertEquals(1, ((HttpServletResponseWrapper) response).getStatus());
    assertEquals(1, statusExposingServletResponse.getStatus());
    assertEquals(1, ((MockHttpServletResponse) response2).getStatus());
  }

  /**
   * Test {@link StatusExposingServletResponse#setStatus(int)} with {@code sc}.
   *
   * <p>Method under test: {@link StatusExposingServletResponse#setStatus(int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void StatusExposingServletResponse.setStatus(int)"})
  public void testSetStatusWithSc2() {
    // Arrange
    HttpServletResponseWrapper response =
        new HttpServletResponseWrapper(
            new StatusExposingServletResponse(new MockHttpServletResponse()));
    HttpServletResponseWrapper response2 = new HttpServletResponseWrapper(response);
    StatusExposingServletResponse statusExposingServletResponse =
        new StatusExposingServletResponse(response2);

    // Act
    statusExposingServletResponse.setStatus(1);

    // Assert
    ServletResponse response3 = statusExposingServletResponse.getResponse();
    assertTrue(response3 instanceof HttpServletResponseWrapper);
    ServletResponse response4 = ((HttpServletResponseWrapper) response3).getResponse();
    assertTrue(response4 instanceof HttpServletResponseWrapper);
    ServletResponse response5 = ((HttpServletResponseWrapper) response4).getResponse();
    assertTrue(response5 instanceof StatusExposingServletResponse);
    ServletResponse response6 = ((StatusExposingServletResponse) response5).getResponse();
    assertTrue(response6 instanceof MockHttpServletResponse);
    assertEquals(1, ((HttpServletResponseWrapper) response3).getStatus());
    assertEquals(1, ((HttpServletResponseWrapper) response4).getStatus());
    assertEquals(1, statusExposingServletResponse.getStatus());
    assertEquals(1, ((StatusExposingServletResponse) response5).getStatus());
    assertEquals(1, ((MockHttpServletResponse) response6).getStatus());
  }

  /**
   * Test {@link StatusExposingServletResponse#setStatus(int, String)} with {@code status}, {@code
   * string}.
   *
   * <p>Method under test: {@link StatusExposingServletResponse#setStatus(int, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void StatusExposingServletResponse.setStatus(int, String)"})
  public void testSetStatusWithStatusString() {
    // Arrange
    HttpServletResponseWrapper response =
        new HttpServletResponseWrapper(
            new StatusExposingServletResponse(new MockHttpServletResponse()));
    HttpServletResponseWrapper response2 = new HttpServletResponseWrapper(response);
    StatusExposingServletResponse statusExposingServletResponse =
        new StatusExposingServletResponse(response2);

    // Act
    statusExposingServletResponse.setStatus(1, "String");

    // Assert
    ServletResponse response3 = statusExposingServletResponse.getResponse();
    assertTrue(response3 instanceof HttpServletResponseWrapper);
    ServletResponse response4 = ((HttpServletResponseWrapper) response3).getResponse();
    assertTrue(response4 instanceof HttpServletResponseWrapper);
    ServletResponse response5 = ((HttpServletResponseWrapper) response4).getResponse();
    assertTrue(response5 instanceof StatusExposingServletResponse);
    ServletResponse response6 = ((StatusExposingServletResponse) response5).getResponse();
    assertTrue(response6 instanceof MockHttpServletResponse);
    assertEquals("String", ((MockHttpServletResponse) response6).getErrorMessage());
    assertEquals(1, ((HttpServletResponseWrapper) response4).getStatus());
    assertEquals(1, ((StatusExposingServletResponse) response5).getStatus());
    assertEquals(1, ((MockHttpServletResponse) response6).getStatus());
  }

  /**
   * Test {@link StatusExposingServletResponse#setStatus(int, String)} with {@code status}, {@code
   * string}.
   *
   * <p>Method under test: {@link StatusExposingServletResponse#setStatus(int, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void StatusExposingServletResponse.setStatus(int, String)"})
  public void testSetStatusWithStatusString2() {
    // Arrange
    HttpServletResponseWrapper response =
        new HttpServletResponseWrapper(
            new StatusExposingServletResponse(new MockHttpServletResponse()));
    SecurityWrapperResponse response2 = new SecurityWrapperResponse(response, "Mode");
    StatusExposingServletResponse statusExposingServletResponse =
        new StatusExposingServletResponse(new HttpServletResponseWrapper(response2));

    // Act
    statusExposingServletResponse.setStatus(1, "String");

    // Assert
    ServletResponse response3 = statusExposingServletResponse.getResponse();
    assertTrue(response3 instanceof HttpServletResponseWrapper);
    ServletResponse response4 = ((HttpServletResponseWrapper) response3).getResponse();
    ServletResponse response5 = ((SecurityWrapperResponse) response4).getResponse();
    assertTrue(response5 instanceof HttpServletResponseWrapper);
    ServletResponse response6 = ((HttpServletResponseWrapper) response5).getResponse();
    assertTrue(response6 instanceof StatusExposingServletResponse);
    assertTrue(response4 instanceof SecurityWrapperResponse);
    assertEquals(200, ((HttpServletResponseWrapper) response3).getStatus());
    assertTrue(response3.isCommitted());
    assertTrue(response4.isCommitted());
    assertTrue(response6.isCommitted());
    assertTrue(response5.isCommitted());
    assertTrue(statusExposingServletResponse.isCommitted());
  }

  /**
   * Test {@link StatusExposingServletResponse#setStatus(int, String)} with {@code status}, {@code
   * string}.
   *
   * <p>Method under test: {@link StatusExposingServletResponse#setStatus(int, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void StatusExposingServletResponse.setStatus(int, String)"})
  public void testSetStatusWithStatusString3() {
    // Arrange
    HttpServletResponseWrapper response =
        new HttpServletResponseWrapper(
            new StatusExposingServletResponse(new MockHttpServletResponse()));
    StatusExposingServletResponse response2 = new StatusExposingServletResponse(response);
    HttpServletResponseWrapper response3 = new HttpServletResponseWrapper(response2);
    SecurityWrapperResponse response4 = new SecurityWrapperResponse(response3, "Mode");
    StatusExposingServletResponse statusExposingServletResponse =
        new StatusExposingServletResponse(new HttpServletResponseWrapper(response4));

    // Act
    statusExposingServletResponse.setStatus(1, "String");

    // Assert
    ServletResponse response5 = statusExposingServletResponse.getResponse();
    assertTrue(response5 instanceof HttpServletResponseWrapper);
    ServletResponse response6 = ((HttpServletResponseWrapper) response5).getResponse();
    ServletResponse response7 = ((SecurityWrapperResponse) response6).getResponse();
    ServletResponse response8 = ((HttpServletResponseWrapper) response7).getResponse();
    ServletResponse response9 = ((StatusExposingServletResponse) response8).getResponse();
    assertTrue(response9 instanceof HttpServletResponseWrapper);
    assertTrue(response7 instanceof HttpServletResponseWrapper);
    ServletResponse response10 = ((HttpServletResponseWrapper) response9).getResponse();
    assertTrue(response10 instanceof StatusExposingServletResponse);
    assertTrue(response8 instanceof StatusExposingServletResponse);
    assertTrue(response6 instanceof SecurityWrapperResponse);
    ServletResponse response11 = ((StatusExposingServletResponse) response10).getResponse();
    assertTrue(response11 instanceof MockHttpServletResponse);
    assertEquals("String", ((MockHttpServletResponse) response11).getErrorMessage());
    assertTrue(response10.isCommitted());
    assertTrue(response11.isCommitted());
    assertTrue(response9.isCommitted());
  }

  /**
   * Test {@link StatusExposingServletResponse#setStatus(int, String)} with {@code status}, {@code
   * string}.
   *
   * <ul>
   *   <li>Then {@link StatusExposingServletResponse} Status is one.
   * </ul>
   *
   * <p>Method under test: {@link StatusExposingServletResponse#setStatus(int, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void StatusExposingServletResponse.setStatus(int, String)"})
  public void testSetStatusWithStatusString_thenStatusExposingServletResponseStatusIsOne() {
    // Arrange
    doNothing().when(httpServletResponse).setStatus(anyInt(), Mockito.<String>any());

    // Act
    statusExposingServletResponse.setStatus(1, "String");

    // Assert
    verify(httpServletResponse).setStatus(1, "String");
    assertEquals(1, statusExposingServletResponse.getStatus());
  }
}
