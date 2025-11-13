package org.broadleafcommerce.openadmin.server.service.artifact.image.effects.chain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class ConverterNotFoundExceptionDiffblueTest {
  /**
   * Test {@link ConverterNotFoundException#ConverterNotFoundException(String)}.
   *
   * <ul>
   *   <li>Then return Message is {@code An error occurred}.
   * </ul>
   *
   * <p>Method under test: {@link ConverterNotFoundException#ConverterNotFoundException(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ConverterNotFoundException.<init>()",
    "void ConverterNotFoundException.<init>(String)",
    "void ConverterNotFoundException.<init>(String, Throwable)",
    "void ConverterNotFoundException.<init>(Throwable)"
  })
  public void testNewConverterNotFoundException_thenReturnMessageIsAnErrorOccurred() {
    // Arrange and Act
    ConverterNotFoundException actualConverterNotFoundException =
        new ConverterNotFoundException("An error occurred");

    // Assert
    assertEquals("An error occurred", actualConverterNotFoundException.getMessage());
    assertNull(actualConverterNotFoundException.getCause());
    assertEquals(0, actualConverterNotFoundException.getSuppressed().length);
  }

  /**
   * Test {@link ConverterNotFoundException#ConverterNotFoundException(String, Throwable)}.
   *
   * <ul>
   *   <li>Then return Message is {@code An error occurred}.
   * </ul>
   *
   * <p>Method under test: {@link ConverterNotFoundException#ConverterNotFoundException(String,
   * Throwable)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ConverterNotFoundException.<init>()",
    "void ConverterNotFoundException.<init>(String)",
    "void ConverterNotFoundException.<init>(String, Throwable)",
    "void ConverterNotFoundException.<init>(Throwable)"
  })
  public void testNewConverterNotFoundException_thenReturnMessageIsAnErrorOccurred2() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    ConverterNotFoundException actualConverterNotFoundException =
        new ConverterNotFoundException("An error occurred", cause);

    // Assert
    assertEquals("An error occurred", actualConverterNotFoundException.getMessage());
    assertEquals(0, actualConverterNotFoundException.getSuppressed().length);
    assertSame(cause, actualConverterNotFoundException.getCause());
  }

  /**
   * Test {@link ConverterNotFoundException#ConverterNotFoundException(Throwable)}.
   *
   * <ul>
   *   <li>Then return Message is {@code Throwable}.
   * </ul>
   *
   * <p>Method under test: {@link ConverterNotFoundException#ConverterNotFoundException(Throwable)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ConverterNotFoundException.<init>()",
    "void ConverterNotFoundException.<init>(String)",
    "void ConverterNotFoundException.<init>(String, Throwable)",
    "void ConverterNotFoundException.<init>(Throwable)"
  })
  public void testNewConverterNotFoundException_thenReturnMessageIsJavaLangThrowable() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    ConverterNotFoundException actualConverterNotFoundException =
        new ConverterNotFoundException(cause);

    // Assert
    assertEquals("java.lang.Throwable", actualConverterNotFoundException.getMessage());
    assertEquals(0, actualConverterNotFoundException.getSuppressed().length);
    assertSame(cause, actualConverterNotFoundException.getCause());
  }

  /**
   * Test {@link ConverterNotFoundException#ConverterNotFoundException()}.
   *
   * <ul>
   *   <li>Then return Message is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ConverterNotFoundException#ConverterNotFoundException()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ConverterNotFoundException.<init>()",
    "void ConverterNotFoundException.<init>(String)",
    "void ConverterNotFoundException.<init>(String, Throwable)",
    "void ConverterNotFoundException.<init>(Throwable)"
  })
  public void testNewConverterNotFoundException_thenReturnMessageIsNull() {
    // Arrange and Act
    ConverterNotFoundException actualConverterNotFoundException = new ConverterNotFoundException();

    // Assert
    assertNull(actualConverterNotFoundException.getMessage());
    assertNull(actualConverterNotFoundException.getCause());
    assertEquals(0, actualConverterNotFoundException.getSuppressed().length);
  }
}
