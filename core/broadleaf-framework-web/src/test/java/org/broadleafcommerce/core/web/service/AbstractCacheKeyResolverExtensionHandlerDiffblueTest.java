package org.broadleafcommerce.core.web.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.broadleafcommerce.common.extension.ExtensionResultStatusType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AbstractCacheKeyResolverExtensionHandlerDiffblueTest {
  /**
   * Test
   * {@link AbstractCacheKeyResolverExtensionHandler#updateCacheKey(StringBuilder, boolean)}.
   * <p>
   * Method under test:
   * {@link AbstractCacheKeyResolverExtensionHandler#updateCacheKey(StringBuilder, boolean)}
   */
  @Test
  @DisplayName("Test updateCacheKey(StringBuilder, boolean)")
  void testUpdateCacheKey() {
    // Arrange
    AbstractCacheKeyResolverExtensionHandler abstractCacheKeyResolverExtensionHandler = new AbstractCacheKeyResolverExtensionHandler();

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        abstractCacheKeyResolverExtensionHandler.updateCacheKey(new StringBuilder("foo"), true));
  }

  /**
   * Test new {@link AbstractCacheKeyResolverExtensionHandler} (default
   * constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link AbstractCacheKeyResolverExtensionHandler}
   */
  @Test
  @DisplayName("Test new AbstractCacheKeyResolverExtensionHandler (default constructor)")
  void testNewAbstractCacheKeyResolverExtensionHandler() {
    // Arrange and Act
    AbstractCacheKeyResolverExtensionHandler actualAbstractCacheKeyResolverExtensionHandler = new AbstractCacheKeyResolverExtensionHandler();

    // Assert
    assertEquals(0, actualAbstractCacheKeyResolverExtensionHandler.getPriority());
    assertTrue(actualAbstractCacheKeyResolverExtensionHandler.isEnabled());
  }
}
