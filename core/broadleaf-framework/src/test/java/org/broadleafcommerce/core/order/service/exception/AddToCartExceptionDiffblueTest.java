package org.broadleafcommerce.core.order.service.exception;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class AddToCartExceptionDiffblueTest {
  /**
   * Test {@link AddToCartException#AddToCartException()}.
   *
   * <ul>
   *   <li>Then return Message is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AddToCartException#AddToCartException()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AddToCartException.<init>()",
    "void AddToCartException.<init>(String)",
    "void AddToCartException.<init>(String, Throwable)",
    "void AddToCartException.<init>(Throwable)"
  })
  public void testNewAddToCartException_thenReturnMessageIsNull() {
    // Arrange and Act
    AddToCartException actualAddToCartException = new AddToCartException();

    // Assert
    assertNull(actualAddToCartException.getMessage());
    assertNull(actualAddToCartException.getCause());
    assertEquals(0, actualAddToCartException.getSuppressed().length);
  }

  /**
   * Test {@link AddToCartException#AddToCartException(String)}.
   *
   * <ul>
   *   <li>When {@code An error occurred}.
   *   <li>Then return Message is {@code An error occurred}.
   * </ul>
   *
   * <p>Method under test: {@link AddToCartException#AddToCartException(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AddToCartException.<init>()",
    "void AddToCartException.<init>(String)",
    "void AddToCartException.<init>(String, Throwable)",
    "void AddToCartException.<init>(Throwable)"
  })
  public void testNewAddToCartException_whenAnErrorOccurred_thenReturnMessageIsAnErrorOccurred() {
    // Arrange and Act
    AddToCartException actualAddToCartException = new AddToCartException("An error occurred");

    // Assert
    assertEquals("An error occurred", actualAddToCartException.getMessage());
    assertNull(actualAddToCartException.getCause());
    assertEquals(0, actualAddToCartException.getSuppressed().length);
  }

  /**
   * Test {@link AddToCartException#AddToCartException(String, Throwable)}.
   *
   * <ul>
   *   <li>When {@code An error occurred}.
   *   <li>Then return Message is {@code An error occurred}.
   * </ul>
   *
   * <p>Method under test: {@link AddToCartException#AddToCartException(String, Throwable)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AddToCartException.<init>()",
    "void AddToCartException.<init>(String)",
    "void AddToCartException.<init>(String, Throwable)",
    "void AddToCartException.<init>(Throwable)"
  })
  public void testNewAddToCartException_whenAnErrorOccurred_thenReturnMessageIsAnErrorOccurred2() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    AddToCartException actualAddToCartException =
        new AddToCartException("An error occurred", cause);

    // Assert
    assertEquals("An error occurred", actualAddToCartException.getMessage());
    assertEquals(0, actualAddToCartException.getSuppressed().length);
    assertSame(cause, actualAddToCartException.getCause());
  }

  /**
   * Test {@link AddToCartException#AddToCartException(Throwable)}.
   *
   * <ul>
   *   <li>When {@link Throwable#Throwable()}.
   *   <li>Then return Message is {@code Throwable}.
   * </ul>
   *
   * <p>Method under test: {@link AddToCartException#AddToCartException(Throwable)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AddToCartException.<init>()",
    "void AddToCartException.<init>(String)",
    "void AddToCartException.<init>(String, Throwable)",
    "void AddToCartException.<init>(Throwable)"
  })
  public void testNewAddToCartException_whenThrowable_thenReturnMessageIsJavaLangThrowable() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    AddToCartException actualAddToCartException = new AddToCartException(cause);

    // Assert
    assertEquals("java.lang.Throwable", actualAddToCartException.getMessage());
    assertEquals(0, actualAddToCartException.getSuppressed().length);
    assertSame(cause, actualAddToCartException.getCause());
  }
}
