package org.broadleafcommerce.cms.common;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class AssetNotFoundExceptionDiffblueTest {
  /**
   * Test {@link AssetNotFoundException#AssetNotFoundException(String)}.
   *
   * <ul>
   *   <li>Then return Message is {@code An error occurred}.
   * </ul>
   *
   * <p>Method under test: {@link AssetNotFoundException#AssetNotFoundException(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AssetNotFoundException.<init>()",
    "void AssetNotFoundException.<init>(String)",
    "void AssetNotFoundException.<init>(String, Throwable)",
    "void AssetNotFoundException.<init>(Throwable)"
  })
  public void testNewAssetNotFoundException_thenReturnMessageIsAnErrorOccurred() {
    // Arrange and Act
    AssetNotFoundException actualAssetNotFoundException =
        new AssetNotFoundException("An error occurred");

    // Assert
    assertEquals("An error occurred", actualAssetNotFoundException.getMessage());
    assertNull(actualAssetNotFoundException.getCause());
    assertEquals(0, actualAssetNotFoundException.getSuppressed().length);
  }

  /**
   * Test {@link AssetNotFoundException#AssetNotFoundException(String, Throwable)}.
   *
   * <ul>
   *   <li>Then return Message is {@code An error occurred}.
   * </ul>
   *
   * <p>Method under test: {@link AssetNotFoundException#AssetNotFoundException(String, Throwable)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AssetNotFoundException.<init>()",
    "void AssetNotFoundException.<init>(String)",
    "void AssetNotFoundException.<init>(String, Throwable)",
    "void AssetNotFoundException.<init>(Throwable)"
  })
  public void testNewAssetNotFoundException_thenReturnMessageIsAnErrorOccurred2() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    AssetNotFoundException actualAssetNotFoundException =
        new AssetNotFoundException("An error occurred", cause);

    // Assert
    assertEquals("An error occurred", actualAssetNotFoundException.getMessage());
    assertEquals(0, actualAssetNotFoundException.getSuppressed().length);
    assertSame(cause, actualAssetNotFoundException.getCause());
  }

  /**
   * Test {@link AssetNotFoundException#AssetNotFoundException()}.
   *
   * <ul>
   *   <li>Then return Message is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AssetNotFoundException#AssetNotFoundException()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AssetNotFoundException.<init>()",
    "void AssetNotFoundException.<init>(String)",
    "void AssetNotFoundException.<init>(String, Throwable)",
    "void AssetNotFoundException.<init>(Throwable)"
  })
  public void testNewAssetNotFoundException_thenReturnMessageIsNull() {
    // Arrange and Act
    AssetNotFoundException actualAssetNotFoundException = new AssetNotFoundException();

    // Assert
    assertNull(actualAssetNotFoundException.getMessage());
    assertNull(actualAssetNotFoundException.getCause());
    assertEquals(0, actualAssetNotFoundException.getSuppressed().length);
  }

  /**
   * Test {@link AssetNotFoundException#AssetNotFoundException(Throwable)}.
   *
   * <ul>
   *   <li>When {@link Throwable#Throwable()}.
   *   <li>Then return Message is {@code Throwable}.
   * </ul>
   *
   * <p>Method under test: {@link AssetNotFoundException#AssetNotFoundException(Throwable)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AssetNotFoundException.<init>()",
    "void AssetNotFoundException.<init>(String)",
    "void AssetNotFoundException.<init>(String, Throwable)",
    "void AssetNotFoundException.<init>(Throwable)"
  })
  public void testNewAssetNotFoundException_whenThrowable_thenReturnMessageIsJavaLangThrowable() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    AssetNotFoundException actualAssetNotFoundException = new AssetNotFoundException(cause);

    // Assert
    assertEquals("java.lang.Throwable", actualAssetNotFoundException.getMessage());
    assertEquals(0, actualAssetNotFoundException.getSuppressed().length);
    assertSame(cause, actualAssetNotFoundException.getCause());
  }
}
