package org.broadleafcommerce.openadmin.server.service.persistence.module;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class FieldNotAvailableExceptionDiffblueTest {
  /**
   * Test {@link FieldNotAvailableException#FieldNotAvailableException(Throwable)}.
   *
   * <ul>
   *   <li>Then return Message is {@code Throwable}.
   * </ul>
   *
   * <p>Method under test: {@link FieldNotAvailableException#FieldNotAvailableException(Throwable)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void FieldNotAvailableException.<init>()",
    "void FieldNotAvailableException.<init>(String)",
    "void FieldNotAvailableException.<init>(String, Throwable)",
    "void FieldNotAvailableException.<init>(Throwable)"
  })
  public void testNewFieldNotAvailableException_thenReturnMessageIsJavaLangThrowable() {
    // Arrange
    Throwable throwable = new Throwable();

    // Act
    FieldNotAvailableException actualFieldNotAvailableException =
        new FieldNotAvailableException(throwable);

    // Assert
    assertEquals("java.lang.Throwable", actualFieldNotAvailableException.getMessage());
    assertEquals(0, actualFieldNotAvailableException.getSuppressed().length);
    assertSame(throwable, actualFieldNotAvailableException.getCause());
  }

  /**
   * Test {@link FieldNotAvailableException#FieldNotAvailableException()}.
   *
   * <ul>
   *   <li>Then return Message is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link FieldNotAvailableException#FieldNotAvailableException()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void FieldNotAvailableException.<init>()",
    "void FieldNotAvailableException.<init>(String)",
    "void FieldNotAvailableException.<init>(String, Throwable)",
    "void FieldNotAvailableException.<init>(Throwable)"
  })
  public void testNewFieldNotAvailableException_thenReturnMessageIsNull() {
    // Arrange and Act
    FieldNotAvailableException actualFieldNotAvailableException = new FieldNotAvailableException();

    // Assert
    assertNull(actualFieldNotAvailableException.getMessage());
    assertNull(actualFieldNotAvailableException.getCause());
    assertEquals(0, actualFieldNotAvailableException.getSuppressed().length);
  }

  /**
   * Test {@link FieldNotAvailableException#FieldNotAvailableException(String)}.
   *
   * <ul>
   *   <li>When {@code foo}.
   *   <li>Then return Message is {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link FieldNotAvailableException#FieldNotAvailableException(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void FieldNotAvailableException.<init>()",
    "void FieldNotAvailableException.<init>(String)",
    "void FieldNotAvailableException.<init>(String, Throwable)",
    "void FieldNotAvailableException.<init>(Throwable)"
  })
  public void testNewFieldNotAvailableException_whenFoo_thenReturnMessageIsFoo() {
    // Arrange and Act
    FieldNotAvailableException actualFieldNotAvailableException =
        new FieldNotAvailableException("foo");

    // Assert
    assertEquals("foo", actualFieldNotAvailableException.getMessage());
    assertNull(actualFieldNotAvailableException.getCause());
    assertEquals(0, actualFieldNotAvailableException.getSuppressed().length);
  }

  /**
   * Test {@link FieldNotAvailableException#FieldNotAvailableException(String, Throwable)}.
   *
   * <ul>
   *   <li>When {@code foo}.
   *   <li>Then return Message is {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link FieldNotAvailableException#FieldNotAvailableException(String,
   * Throwable)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void FieldNotAvailableException.<init>()",
    "void FieldNotAvailableException.<init>(String)",
    "void FieldNotAvailableException.<init>(String, Throwable)",
    "void FieldNotAvailableException.<init>(Throwable)"
  })
  public void testNewFieldNotAvailableException_whenFoo_thenReturnMessageIsFoo2() {
    // Arrange
    Throwable throwable = new Throwable();

    // Act
    FieldNotAvailableException actualFieldNotAvailableException =
        new FieldNotAvailableException("foo", throwable);

    // Assert
    assertEquals("foo", actualFieldNotAvailableException.getMessage());
    assertEquals(0, actualFieldNotAvailableException.getSuppressed().length);
    assertSame(throwable, actualFieldNotAvailableException.getCause());
  }
}
