package org.broadleafcommerce.cms.web.file;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class StaticAssetViewDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link StaticAssetView}
   *   <li>{@link StaticAssetView#setBrowserAssetCachingEnabled(boolean)}
   *   <li>{@link StaticAssetView#setCacheSeconds(long)}
   *   <li>{@link StaticAssetView#getCacheSeconds()}
   *   <li>{@link StaticAssetView#getContentType()}
   *   <li>{@link StaticAssetView#isBrowserAssetCachingEnabled()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void StaticAssetView.<init>()",
    "long StaticAssetView.getCacheSeconds()",
    "String StaticAssetView.getContentType()",
    "boolean StaticAssetView.isBrowserAssetCachingEnabled()",
    "void StaticAssetView.setBrowserAssetCachingEnabled(boolean)",
    "void StaticAssetView.setCacheSeconds(long)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    StaticAssetView actualStaticAssetView = new StaticAssetView();
    actualStaticAssetView.setBrowserAssetCachingEnabled(true);
    actualStaticAssetView.setCacheSeconds(1L);
    long actualCacheSeconds = actualStaticAssetView.getCacheSeconds();
    String actualContentType = actualStaticAssetView.getContentType();

    // Assert
    assertNull(actualContentType);
    assertEquals(1L, actualCacheSeconds);
    assertTrue(actualStaticAssetView.isBrowserAssetCachingEnabled());
  }
}
