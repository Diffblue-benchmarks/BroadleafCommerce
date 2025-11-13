package org.broadleafcommerce.openadmin.server.service.artifact.image.effects.chain.conversion;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class ConversionExceptionDiffblueTest {
  /**
   * Test {@link ConversionException#ConversionException(String)}.
   *
   * <ul>
   *   <li>Then return Message is {@code An error occurred}.
   * </ul>
   *
   * <p>Method under test: {@link ConversionException#ConversionException(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ConversionException.<init>()",
    "void ConversionException.<init>(String)",
    "void ConversionException.<init>(String, Throwable)",
    "void ConversionException.<init>(Throwable)"
  })
  public void testNewConversionException_thenReturnMessageIsAnErrorOccurred() {
    // Arrange and Act
    ConversionException actualConversionException = new ConversionException("An error occurred");

    // Assert
    assertEquals("An error occurred", actualConversionException.getMessage());
    assertNull(actualConversionException.getCause());
    assertEquals(0, actualConversionException.getSuppressed().length);
  }

  /**
   * Test {@link ConversionException#ConversionException(String, Throwable)}.
   *
   * <ul>
   *   <li>Then return Message is {@code An error occurred}.
   * </ul>
   *
   * <p>Method under test: {@link ConversionException#ConversionException(String, Throwable)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ConversionException.<init>()",
    "void ConversionException.<init>(String)",
    "void ConversionException.<init>(String, Throwable)",
    "void ConversionException.<init>(Throwable)"
  })
  public void testNewConversionException_thenReturnMessageIsAnErrorOccurred2() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    ConversionException actualConversionException =
        new ConversionException("An error occurred", cause);

    // Assert
    assertEquals("An error occurred", actualConversionException.getMessage());
    assertEquals(0, actualConversionException.getSuppressed().length);
    assertSame(cause, actualConversionException.getCause());
  }

  /**
   * Test {@link ConversionException#ConversionException()}.
   *
   * <ul>
   *   <li>Then return Message is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ConversionException#ConversionException()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ConversionException.<init>()",
    "void ConversionException.<init>(String)",
    "void ConversionException.<init>(String, Throwable)",
    "void ConversionException.<init>(Throwable)"
  })
  public void testNewConversionException_thenReturnMessageIsNull() {
    // Arrange and Act
    ConversionException actualConversionException = new ConversionException();

    // Assert
    assertNull(actualConversionException.getMessage());
    assertNull(actualConversionException.getCause());
    assertEquals(0, actualConversionException.getSuppressed().length);
  }

  /**
   * Test {@link ConversionException#ConversionException(Throwable)}.
   *
   * <ul>
   *   <li>When {@link Throwable#Throwable()}.
   *   <li>Then return Message is {@code Throwable}.
   * </ul>
   *
   * <p>Method under test: {@link ConversionException#ConversionException(Throwable)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ConversionException.<init>()",
    "void ConversionException.<init>(String)",
    "void ConversionException.<init>(String, Throwable)",
    "void ConversionException.<init>(Throwable)"
  })
  public void testNewConversionException_whenThrowable_thenReturnMessageIsJavaLangThrowable() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    ConversionException actualConversionException = new ConversionException(cause);

    // Assert
    assertEquals("java.lang.Throwable", actualConversionException.getMessage());
    assertEquals(0, actualConversionException.getSuppressed().length);
    assertSame(cause, actualConversionException.getCause());
  }
}
