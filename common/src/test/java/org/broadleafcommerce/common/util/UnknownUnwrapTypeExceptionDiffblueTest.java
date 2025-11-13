package org.broadleafcommerce.common.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class UnknownUnwrapTypeExceptionDiffblueTest {
  /**
   * Test {@link UnknownUnwrapTypeException#UnknownUnwrapTypeException(Class)}.
   *
   * <p>Method under test: {@link UnknownUnwrapTypeException#UnknownUnwrapTypeException(Class)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void UnknownUnwrapTypeException.<init>(Class)"})
  public void testNewUnknownUnwrapTypeException() {
    // Arrange
    Class<Object> unwrapType = Object.class;

    // Act
    UnknownUnwrapTypeException actualUnknownUnwrapTypeException =
        new UnknownUnwrapTypeException(unwrapType);

    // Assert
    assertEquals(
        "Cannot unwrap to requested type [java.lang.Object]",
        actualUnknownUnwrapTypeException.getLocalizedMessage());
    assertEquals(
        "Cannot unwrap to requested type [java.lang.Object]",
        actualUnknownUnwrapTypeException.getMessage());
    assertNull(actualUnknownUnwrapTypeException.getCause());
    assertEquals(0, actualUnknownUnwrapTypeException.getSuppressed().length);
  }

  /**
   * Test {@link UnknownUnwrapTypeException#UnknownUnwrapTypeException(Class, Throwable)}.
   *
   * <p>Method under test: {@link UnknownUnwrapTypeException#UnknownUnwrapTypeException(Class,
   * Throwable)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void UnknownUnwrapTypeException.<init>(Class, Throwable)"})
  public void testNewUnknownUnwrapTypeException2() {
    // Arrange
    Class<Object> unwrapType = Object.class;
    Throwable root = new Throwable();

    // Act
    UnknownUnwrapTypeException actualUnknownUnwrapTypeException =
        new UnknownUnwrapTypeException(unwrapType, root);

    // Assert
    assertEquals(
        "Cannot unwrap to requested type [java.lang.Object]",
        actualUnknownUnwrapTypeException.getLocalizedMessage());
    assertEquals(
        "Cannot unwrap to requested type [java.lang.Object]",
        actualUnknownUnwrapTypeException.getMessage());
    assertEquals(0, actualUnknownUnwrapTypeException.getSuppressed().length);
    assertSame(root, actualUnknownUnwrapTypeException.getCause());
  }
}
