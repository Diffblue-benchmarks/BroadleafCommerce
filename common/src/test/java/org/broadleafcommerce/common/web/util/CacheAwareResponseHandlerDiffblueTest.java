/*-
 * #%L
 * BroadleafCommerce Common Libraries
 * %%
 * Copyright (C) 2009 - 2025 Broadleaf Commerce
 * %%
 * Licensed under the Broadleaf Fair Use License Agreement, Version 1.0
 * (the "Fair Use License" located  at http://license.broadleafcommerce.org/fair_use_license-1.0.txt)
 * unless the restrictions on use therein are violated and require payment to Broadleaf in which case
 * the Broadleaf End User License Agreement (EULA), Version 1.1
 * (the "Commercial License" located at http://license.broadleafcommerce.org/commercial_license-1.1.txt)
 * shall apply.
 * 
 * Alternatively, the Commercial License may be replaced with a mutually agreed upon license (the "Custom License")
 * between you and Broadleaf Commerce. You may not use this file except in compliance with the applicable license.
 * #L%
 */
package org.broadleafcommerce.common.web.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class CacheAwareResponseHandlerDiffblueTest {
  /**
   * Test new {@link CacheAwareResponseHandler} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link CacheAwareResponseHandler}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CacheAwareResponseHandler.<init>()"})
  public void testNewCacheAwareResponseHandler() {
    // Arrange and Act
    CacheAwareResponseHandler actualCacheAwareResponseHandler = new CacheAwareResponseHandler();

    // Assert
    assertNull(actualCacheAwareResponseHandler.getVaryByRequestHeaders());
    assertNull(actualCacheAwareResponseHandler.getCacheControl());
    assertNull(actualCacheAwareResponseHandler.getResourceHttpMessageConverter());
    assertNull(actualCacheAwareResponseHandler.getResourceRegionHttpMessageConverter());
    assertNull(actualCacheAwareResponseHandler.getContentNegotiationManager());
    assertNull(actualCacheAwareResponseHandler.getUrlPathHelper());
    assertEquals(-1, actualCacheAwareResponseHandler.getCacheSeconds());
    assertEquals(2, actualCacheAwareResponseHandler.getSupportedMethods().length);
    assertFalse(actualCacheAwareResponseHandler.isOptimizeLocations());
    assertFalse(actualCacheAwareResponseHandler.isAlwaysMustRevalidate());
    assertFalse(actualCacheAwareResponseHandler.isRequireSession());
    assertFalse(actualCacheAwareResponseHandler.isUseExpiresHeader());
    assertTrue(actualCacheAwareResponseHandler.getLocations().isEmpty());
    assertTrue(actualCacheAwareResponseHandler.getResourceResolvers().isEmpty());
    assertTrue(actualCacheAwareResponseHandler.getResourceTransformers().isEmpty());
    assertTrue(actualCacheAwareResponseHandler.getMediaTypes().isEmpty());
    assertTrue(actualCacheAwareResponseHandler.isUseLastModified());
    assertTrue(actualCacheAwareResponseHandler.isUseCacheControlHeader());
    assertTrue(actualCacheAwareResponseHandler.isUseCacheControlNoStore());
  }
}
