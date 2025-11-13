package org.broadleafcommerce.core.order.service.exception;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class RemoveFromCartExceptionDiffblueTest {
  /**
   * Test {@link RemoveFromCartException#RemoveFromCartException(String)}.
   *
   * <ul>
   *   <li>Then return Message is {@code An error occurred}.
   * </ul>
   *
   * <p>Method under test: {@link RemoveFromCartException#RemoveFromCartException(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void RemoveFromCartException.<init>()",
    "void RemoveFromCartException.<init>(String)",
    "void RemoveFromCartException.<init>(String, Throwable)",
    "void RemoveFromCartException.<init>(Throwable)"
  })
  public void testNewRemoveFromCartException_thenReturnMessageIsAnErrorOccurred() {
    // Arrange and Act
    RemoveFromCartException actualRemoveFromCartException =
        new RemoveFromCartException("An error occurred");

    // Assert
    assertEquals("An error occurred", actualRemoveFromCartException.getMessage());
    assertNull(actualRemoveFromCartException.getCause());
    assertEquals(0, actualRemoveFromCartException.getSuppressed().length);
  }

  /**
   * Test {@link RemoveFromCartException#RemoveFromCartException(String, Throwable)}.
   *
   * <ul>
   *   <li>Then return Message is {@code An error occurred}.
   * </ul>
   *
   * <p>Method under test: {@link RemoveFromCartException#RemoveFromCartException(String,
   * Throwable)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void RemoveFromCartException.<init>()",
    "void RemoveFromCartException.<init>(String)",
    "void RemoveFromCartException.<init>(String, Throwable)",
    "void RemoveFromCartException.<init>(Throwable)"
  })
  public void testNewRemoveFromCartException_thenReturnMessageIsAnErrorOccurred2() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    RemoveFromCartException actualRemoveFromCartException =
        new RemoveFromCartException("An error occurred", cause);

    // Assert
    assertEquals("An error occurred", actualRemoveFromCartException.getMessage());
    assertEquals(0, actualRemoveFromCartException.getSuppressed().length);
    assertSame(cause, actualRemoveFromCartException.getCause());
  }

  /**
   * Test {@link RemoveFromCartException#RemoveFromCartException(Throwable)}.
   *
   * <ul>
   *   <li>Then return Message is {@code Throwable}.
   * </ul>
   *
   * <p>Method under test: {@link RemoveFromCartException#RemoveFromCartException(Throwable)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void RemoveFromCartException.<init>()",
    "void RemoveFromCartException.<init>(String)",
    "void RemoveFromCartException.<init>(String, Throwable)",
    "void RemoveFromCartException.<init>(Throwable)"
  })
  public void testNewRemoveFromCartException_thenReturnMessageIsJavaLangThrowable() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    RemoveFromCartException actualRemoveFromCartException = new RemoveFromCartException(cause);

    // Assert
    assertEquals("java.lang.Throwable", actualRemoveFromCartException.getMessage());
    assertEquals(0, actualRemoveFromCartException.getSuppressed().length);
    assertSame(cause, actualRemoveFromCartException.getCause());
  }

  /**
   * Test {@link RemoveFromCartException#RemoveFromCartException()}.
   *
   * <ul>
   *   <li>Then return Message is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link RemoveFromCartException#RemoveFromCartException()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void RemoveFromCartException.<init>()",
    "void RemoveFromCartException.<init>(String)",
    "void RemoveFromCartException.<init>(String, Throwable)",
    "void RemoveFromCartException.<init>(Throwable)"
  })
  public void testNewRemoveFromCartException_thenReturnMessageIsNull() {
    // Arrange and Act
    RemoveFromCartException actualRemoveFromCartException = new RemoveFromCartException();

    // Assert
    assertNull(actualRemoveFromCartException.getMessage());
    assertNull(actualRemoveFromCartException.getCause());
    assertEquals(0, actualRemoveFromCartException.getSuppressed().length);
  }
}
