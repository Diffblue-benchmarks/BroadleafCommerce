package org.broadleafcommerce.common.file;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class FileServiceExceptionDiffblueTest {
  /**
   * Test {@link FileServiceException#FileServiceException(String)}.
   *
   * <ul>
   *   <li>Then return Message is {@code An error occurred}.
   * </ul>
   *
   * <p>Method under test: {@link FileServiceException#FileServiceException(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void FileServiceException.<init>()",
    "void FileServiceException.<init>(String)",
    "void FileServiceException.<init>(String, Throwable)",
    "void FileServiceException.<init>(Throwable)"
  })
  public void testNewFileServiceException_thenReturnMessageIsAnErrorOccurred() {
    // Arrange and Act
    FileServiceException actualFileServiceException = new FileServiceException("An error occurred");

    // Assert
    assertEquals("An error occurred", actualFileServiceException.getMessage());
    assertNull(actualFileServiceException.getCause());
    assertEquals(0, actualFileServiceException.getSuppressed().length);
  }

  /**
   * Test {@link FileServiceException#FileServiceException(String, Throwable)}.
   *
   * <ul>
   *   <li>Then return Message is {@code An error occurred}.
   * </ul>
   *
   * <p>Method under test: {@link FileServiceException#FileServiceException(String, Throwable)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void FileServiceException.<init>()",
    "void FileServiceException.<init>(String)",
    "void FileServiceException.<init>(String, Throwable)",
    "void FileServiceException.<init>(Throwable)"
  })
  public void testNewFileServiceException_thenReturnMessageIsAnErrorOccurred2() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    FileServiceException actualFileServiceException =
        new FileServiceException("An error occurred", cause);

    // Assert
    assertEquals("An error occurred", actualFileServiceException.getMessage());
    assertEquals(0, actualFileServiceException.getSuppressed().length);
    assertSame(cause, actualFileServiceException.getCause());
  }

  /**
   * Test {@link FileServiceException#FileServiceException()}.
   *
   * <ul>
   *   <li>Then return Message is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link FileServiceException#FileServiceException()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void FileServiceException.<init>()",
    "void FileServiceException.<init>(String)",
    "void FileServiceException.<init>(String, Throwable)",
    "void FileServiceException.<init>(Throwable)"
  })
  public void testNewFileServiceException_thenReturnMessageIsNull() {
    // Arrange and Act
    FileServiceException actualFileServiceException = new FileServiceException();

    // Assert
    assertNull(actualFileServiceException.getMessage());
    assertNull(actualFileServiceException.getCause());
    assertEquals(0, actualFileServiceException.getSuppressed().length);
  }

  /**
   * Test {@link FileServiceException#FileServiceException(Throwable)}.
   *
   * <ul>
   *   <li>When {@link Throwable#Throwable()}.
   *   <li>Then return Message is {@code Throwable}.
   * </ul>
   *
   * <p>Method under test: {@link FileServiceException#FileServiceException(Throwable)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void FileServiceException.<init>()",
    "void FileServiceException.<init>(String)",
    "void FileServiceException.<init>(String, Throwable)",
    "void FileServiceException.<init>(Throwable)"
  })
  public void testNewFileServiceException_whenThrowable_thenReturnMessageIsJavaLangThrowable() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    FileServiceException actualFileServiceException = new FileServiceException(cause);

    // Assert
    assertEquals("java.lang.Throwable", actualFileServiceException.getMessage());
    assertEquals(0, actualFileServiceException.getSuppressed().length);
    assertSame(cause, actualFileServiceException.getCause());
  }
}
