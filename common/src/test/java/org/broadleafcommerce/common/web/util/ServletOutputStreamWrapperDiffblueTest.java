package org.broadleafcommerce.common.web.util;

import static org.junit.Assert.assertFalse;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import javax.servlet.WriteListener;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class ServletOutputStreamWrapperDiffblueTest {
  /**
   * Test {@link ServletOutputStreamWrapper#ServletOutputStreamWrapper(OutputStream)}.
   *
   * <p>Method under test: {@link
   * ServletOutputStreamWrapper#ServletOutputStreamWrapper(OutputStream)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ServletOutputStreamWrapper.<init>(OutputStream)"})
  public void testNewServletOutputStreamWrapper() {
    // Arrange, Act and Assert
    assertFalse(new ServletOutputStreamWrapper(new ByteArrayOutputStream()).isReady());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ServletOutputStreamWrapper#setWriteListener(WriteListener)}
   *   <li>{@link ServletOutputStreamWrapper#isReady()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ServletOutputStreamWrapper.isReady()",
    "void ServletOutputStreamWrapper.setWriteListener(WriteListener)"
  })
  public void testGettersAndSetters() {
    // Arrange
    ServletOutputStreamWrapper servletOutputStreamWrapper =
        new ServletOutputStreamWrapper(new ByteArrayOutputStream());

    // Act
    servletOutputStreamWrapper.setWriteListener(null);

    // Assert
    assertFalse(servletOutputStreamWrapper.isReady());
  }
}
