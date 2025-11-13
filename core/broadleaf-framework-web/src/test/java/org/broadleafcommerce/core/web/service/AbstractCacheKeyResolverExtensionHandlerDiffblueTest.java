package org.broadleafcommerce.core.web.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.common.extension.ExtensionResultStatusType;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class AbstractCacheKeyResolverExtensionHandlerDiffblueTest {
  /**
   * Test {@link AbstractCacheKeyResolverExtensionHandler#updateCacheKey(StringBuilder, boolean)}.
   *
   * <p>Method under test: {@link
   * AbstractCacheKeyResolverExtensionHandler#updateCacheKey(StringBuilder, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType AbstractCacheKeyResolverExtensionHandler.updateCacheKey(StringBuilder, boolean)"
  })
  public void testUpdateCacheKey() {
    // Arrange
    AbstractCacheKeyResolverExtensionHandler abstractCacheKeyResolverExtensionHandler =
        new AbstractCacheKeyResolverExtensionHandler();

    // Act and Assert
    assertEquals(
        ExtensionResultStatusType.NOT_HANDLED,
        abstractCacheKeyResolverExtensionHandler.updateCacheKey(new StringBuilder("foo"), true));
  }

  /**
   * Test new {@link AbstractCacheKeyResolverExtensionHandler} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link
   * AbstractCacheKeyResolverExtensionHandler}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbstractCacheKeyResolverExtensionHandler.<init>()"})
  public void testNewAbstractCacheKeyResolverExtensionHandler() {
    // Arrange and Act
    AbstractCacheKeyResolverExtensionHandler actualAbstractCacheKeyResolverExtensionHandler =
        new AbstractCacheKeyResolverExtensionHandler();

    // Assert
    assertEquals(0, actualAbstractCacheKeyResolverExtensionHandler.getPriority());
    assertTrue(actualAbstractCacheKeyResolverExtensionHandler.isEnabled());
  }
}
