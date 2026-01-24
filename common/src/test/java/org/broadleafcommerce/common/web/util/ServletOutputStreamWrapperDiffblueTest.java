package org.broadleafcommerce.common.web.util;

import static org.junit.Assert.assertFalse;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import javax.servlet.WriteListener;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;

@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@RunWith(MockitoJUnitRunner.class)
public class ServletOutputStreamWrapperDiffblueTest {
  @Mock private OutputStream outputStream;

  @InjectMocks private ServletOutputStreamWrapper servletOutputStreamWrapper;

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
   * Test {@link ServletOutputStreamWrapper#flush()}.
   *
   * <ul>
   *   <li>Given {@link OutputStream} {@link OutputStream#write(byte[])} does nothing.
   *   <li>Then calls {@link OutputStream#write(byte[])}.
   * </ul>
   *
   * <p>Method under test: {@link ServletOutputStreamWrapper#flush()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ServletOutputStreamWrapper.flush()"})
  public void testFlush_givenOutputStreamWriteDoesNothing_thenCallsWrite() throws IOException {
    // Arrange
    doNothing().when(outputStream).write(Mockito.<byte[]>any());

    // Act
    servletOutputStreamWrapper.flush();

    // Assert
    verify(outputStream).write(isA(byte[].class));
  }

  /**
   * Test {@link ServletOutputStreamWrapper#flushInternalBuffer()}.
   *
   * <p>Method under test: {@link ServletOutputStreamWrapper#flushInternalBuffer()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ServletOutputStreamWrapper.flushInternalBuffer()"})
  public void testFlushInternalBuffer() throws IOException {
    // Arrange
    doNothing().when(outputStream).write(Mockito.<byte[]>any());

    // Act
    servletOutputStreamWrapper.flushInternalBuffer();

    // Assert
    verify(outputStream).write(isA(byte[].class));
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
