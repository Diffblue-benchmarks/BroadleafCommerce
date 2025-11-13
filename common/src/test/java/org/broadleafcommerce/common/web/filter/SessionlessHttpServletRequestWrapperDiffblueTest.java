package org.broadleafcommerce.common.web.filter;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.springframework.mock.web.MockHttpServletRequest;

public class SessionlessHttpServletRequestWrapperDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link
   *       SessionlessHttpServletRequestWrapper#SessionlessHttpServletRequestWrapper(HttpServletRequest)}
   *   <li>{@link SessionlessHttpServletRequestWrapper#getRequestedSessionId()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SessionlessHttpServletRequestWrapper.<init>(HttpServletRequest)",
    "String SessionlessHttpServletRequestWrapper.getRequestedSessionId()"
  })
  public void testGettersAndSetters() {
    // Arrange
    MockHttpServletRequest request = new MockHttpServletRequest();

    // Act
    SessionlessHttpServletRequestWrapper actualSessionlessHttpServletRequestWrapper =
        new SessionlessHttpServletRequestWrapper(request);
    String actualRequestedSessionId =
        actualSessionlessHttpServletRequestWrapper.getRequestedSessionId();

    // Assert
    ServletRequest request2 = actualSessionlessHttpServletRequestWrapper.getRequest();
    assertTrue(request2 instanceof MockHttpServletRequest);
    assertNull(actualRequestedSessionId);
    assertSame(request, request2);
  }

  /**
   * Test {@link SessionlessHttpServletRequestWrapper#getSession()}.
   *
   * <p>Method under test: {@link SessionlessHttpServletRequestWrapper#getSession()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "javax.servlet.http.HttpSession SessionlessHttpServletRequestWrapper.getSession()"
  })
  public void testGetSession() {
    // Arrange, Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> new SessionlessHttpServletRequestWrapper(new MockHttpServletRequest()).getSession());
  }

  /**
   * Test {@link SessionlessHttpServletRequestWrapper#getSession(boolean)} with {@code boolean}.
   *
   * <ul>
   *   <li>When {@code false}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SessionlessHttpServletRequestWrapper#getSession(boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "javax.servlet.http.HttpSession SessionlessHttpServletRequestWrapper.getSession(boolean)"
  })
  public void testGetSessionWithBoolean_whenFalse_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(
        new SessionlessHttpServletRequestWrapper(new MockHttpServletRequest()).getSession(false));
  }

  /**
   * Test {@link SessionlessHttpServletRequestWrapper#getSession(boolean)} with {@code boolean}.
   *
   * <ul>
   *   <li>When {@code true}.
   *   <li>Then throw {@link UnsupportedOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link SessionlessHttpServletRequestWrapper#getSession(boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "javax.servlet.http.HttpSession SessionlessHttpServletRequestWrapper.getSession(boolean)"
  })
  public void testGetSessionWithBoolean_whenTrue_thenThrowUnsupportedOperationException() {
    // Arrange, Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () ->
            new SessionlessHttpServletRequestWrapper(new MockHttpServletRequest())
                .getSession(true));
  }
}
