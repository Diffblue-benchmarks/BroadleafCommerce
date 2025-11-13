package org.broadleafcommerce.common.cache.engine;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class CacheFactoryExceptionDiffblueTest {
  /**
   * Test {@link CacheFactoryException#CacheFactoryException(String)}.
   *
   * <ul>
   *   <li>Then return Message is {@code An error occurred}.
   * </ul>
   *
   * <p>Method under test: {@link CacheFactoryException#CacheFactoryException(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CacheFactoryException.<init>()",
    "void CacheFactoryException.<init>(String)",
    "void CacheFactoryException.<init>(String, Throwable)",
    "void CacheFactoryException.<init>(Throwable)"
  })
  public void testNewCacheFactoryException_thenReturnMessageIsAnErrorOccurred() {
    // Arrange and Act
    CacheFactoryException actualCacheFactoryException =
        new CacheFactoryException("An error occurred");

    // Assert
    assertEquals("An error occurred", actualCacheFactoryException.getMessage());
    assertNull(actualCacheFactoryException.getCause());
    assertEquals(0, actualCacheFactoryException.getSuppressed().length);
  }

  /**
   * Test {@link CacheFactoryException#CacheFactoryException(String, Throwable)}.
   *
   * <ul>
   *   <li>Then return Message is {@code An error occurred}.
   * </ul>
   *
   * <p>Method under test: {@link CacheFactoryException#CacheFactoryException(String, Throwable)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CacheFactoryException.<init>()",
    "void CacheFactoryException.<init>(String)",
    "void CacheFactoryException.<init>(String, Throwable)",
    "void CacheFactoryException.<init>(Throwable)"
  })
  public void testNewCacheFactoryException_thenReturnMessageIsAnErrorOccurred2() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    CacheFactoryException actualCacheFactoryException =
        new CacheFactoryException("An error occurred", cause);

    // Assert
    assertEquals("An error occurred", actualCacheFactoryException.getMessage());
    assertEquals(0, actualCacheFactoryException.getSuppressed().length);
    assertSame(cause, actualCacheFactoryException.getCause());
  }

  /**
   * Test {@link CacheFactoryException#CacheFactoryException()}.
   *
   * <ul>
   *   <li>Then return Message is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link CacheFactoryException#CacheFactoryException()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CacheFactoryException.<init>()",
    "void CacheFactoryException.<init>(String)",
    "void CacheFactoryException.<init>(String, Throwable)",
    "void CacheFactoryException.<init>(Throwable)"
  })
  public void testNewCacheFactoryException_thenReturnMessageIsNull() {
    // Arrange and Act
    CacheFactoryException actualCacheFactoryException = new CacheFactoryException();

    // Assert
    assertNull(actualCacheFactoryException.getMessage());
    assertNull(actualCacheFactoryException.getCause());
    assertEquals(0, actualCacheFactoryException.getSuppressed().length);
  }

  /**
   * Test {@link CacheFactoryException#CacheFactoryException(Throwable)}.
   *
   * <ul>
   *   <li>When {@link Throwable#Throwable()}.
   *   <li>Then return Message is {@code Throwable}.
   * </ul>
   *
   * <p>Method under test: {@link CacheFactoryException#CacheFactoryException(Throwable)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CacheFactoryException.<init>()",
    "void CacheFactoryException.<init>(String)",
    "void CacheFactoryException.<init>(String, Throwable)",
    "void CacheFactoryException.<init>(Throwable)"
  })
  public void testNewCacheFactoryException_whenThrowable_thenReturnMessageIsJavaLangThrowable() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    CacheFactoryException actualCacheFactoryException = new CacheFactoryException(cause);

    // Assert
    assertEquals("java.lang.Throwable", actualCacheFactoryException.getMessage());
    assertEquals(0, actualCacheFactoryException.getSuppressed().length);
    assertSame(cause, actualCacheFactoryException.getCause());
  }
}
