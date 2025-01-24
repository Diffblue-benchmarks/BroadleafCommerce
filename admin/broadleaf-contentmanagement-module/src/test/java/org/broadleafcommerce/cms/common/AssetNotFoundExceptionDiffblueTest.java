package org.broadleafcommerce.cms.common;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import org.junit.Test;

public class AssetNotFoundExceptionDiffblueTest {
  /**
   * Test {@link AssetNotFoundException#AssetNotFoundException(String)}.
   * <ul>
   *   <li>Then return Message is {@code An error occurred}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AssetNotFoundException#AssetNotFoundException(String)}
   */
  @Test
  public void testNewAssetNotFoundException_thenReturnMessageIsAnErrorOccurred() {
    // Arrange and Act
    AssetNotFoundException actualAssetNotFoundException = new AssetNotFoundException("An error occurred");

    // Assert
    assertEquals("An error occurred", actualAssetNotFoundException.getMessage());
    assertNull(actualAssetNotFoundException.getCause());
    assertEquals(0, actualAssetNotFoundException.getSuppressed().length);
  }

  /**
   * Test
   * {@link AssetNotFoundException#AssetNotFoundException(String, Throwable)}.
   * <ul>
   *   <li>Then return Message is {@code An error occurred}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AssetNotFoundException#AssetNotFoundException(String, Throwable)}
   */
  @Test
  public void testNewAssetNotFoundException_thenReturnMessageIsAnErrorOccurred2() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    AssetNotFoundException actualAssetNotFoundException = new AssetNotFoundException("An error occurred", cause);

    // Assert
    assertEquals("An error occurred", actualAssetNotFoundException.getMessage());
    assertEquals(0, actualAssetNotFoundException.getSuppressed().length);
    assertSame(cause, actualAssetNotFoundException.getCause());
  }

  /**
   * Test {@link AssetNotFoundException#AssetNotFoundException()}.
   * <ul>
   *   <li>Then return Message is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AssetNotFoundException#AssetNotFoundException()}
   */
  @Test
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
   * <ul>
   *   <li>When {@link Throwable#Throwable()}.</li>
   *   <li>Then return Message is {@code java.lang.Throwable}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AssetNotFoundException#AssetNotFoundException(Throwable)}
   */
  @Test
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
