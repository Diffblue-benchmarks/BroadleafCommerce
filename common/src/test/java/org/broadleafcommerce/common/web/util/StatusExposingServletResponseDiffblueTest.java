package org.broadleafcommerce.common.web.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
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
  public void testGettersAndSetters() {
    // Arrange
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    StatusExposingServletResponse actualStatusExposingServletResponse =
        new StatusExposingServletResponse(response);

    // Assert
    assertEquals(200, actualStatusExposingServletResponse.getStatus());
    assertSame(response, actualStatusExposingServletResponse.getResponse());
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
        new StatusExposingServletResponse(new MockHttpServletResponse());

    // Act
    statusExposingServletResponse.sendError(1);

    // Assert
    ServletResponse response = statusExposingServletResponse.getResponse();
    assertTrue(response instanceof MockHttpServletResponse);
    assertEquals(1, statusExposingServletResponse.getStatus());
    assertEquals(1, ((MockHttpServletResponse) response).getStatus());
    assertTrue(response.isCommitted());
    assertTrue(statusExposingServletResponse.isCommitted());
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
    StatusExposingServletResponse statusExposingServletResponse =
        new StatusExposingServletResponse(new MockHttpServletResponse());

    // Act
    statusExposingServletResponse.sendError(1, "Msg");

    // Assert
    ServletResponse response = statusExposingServletResponse.getResponse();
    assertTrue(response instanceof MockHttpServletResponse);
    assertEquals("Msg", ((MockHttpServletResponse) response).getErrorMessage());
    assertEquals(1, statusExposingServletResponse.getStatus());
    assertEquals(1, ((MockHttpServletResponse) response).getStatus());
    assertTrue(response.isCommitted());
    assertTrue(statusExposingServletResponse.isCommitted());
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
        new StatusExposingServletResponse(new MockHttpServletResponse());

    // Act
    statusExposingServletResponse.setStatus(1);

    // Assert
    ServletResponse response = statusExposingServletResponse.getResponse();
    assertTrue(response instanceof MockHttpServletResponse);
    assertEquals(1, statusExposingServletResponse.getStatus());
    assertEquals(1, ((MockHttpServletResponse) response).getStatus());
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
    StatusExposingServletResponse statusExposingServletResponse =
        new StatusExposingServletResponse(new MockHttpServletResponse());

    // Act
    statusExposingServletResponse.setStatus(1, "String");

    // Assert
    ServletResponse response = statusExposingServletResponse.getResponse();
    assertTrue(response instanceof MockHttpServletResponse);
    assertEquals("String", ((MockHttpServletResponse) response).getErrorMessage());
    assertEquals(1, statusExposingServletResponse.getStatus());
    assertEquals(1, ((MockHttpServletResponse) response).getStatus());
  }
}
