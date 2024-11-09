/*-
 * #%L
 * BroadleafCommerce Common Libraries
 * %%
 * Copyright (C) 2009 - 2024 Broadleaf Commerce
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
package org.broadleafcommerce.common.extensibility.cache.ehcache;

import static org.junit.Assert.assertEquals;
import java.net.URI;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.springframework.beans.BeansException;
import org.springframework.boot.web.reactive.context.AnnotationConfigReactiveWebApplicationContext;
import org.springframework.context.ApplicationContext;

public class DefaultEhCacheUriProviderDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>
   * {@link DefaultEhCacheUriProvider#setApplicationContext(ApplicationContext)}
   *   <li>{@link DefaultEhCacheUriProvider#setConfigLocations(List)}
   *   <li>{@link DefaultEhCacheUriProvider#getJCacheUri()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() throws BeansException {
    // Arrange
    DefaultEhCacheUriProvider defaultEhCacheUriProvider = new DefaultEhCacheUriProvider();

    // Act
    defaultEhCacheUriProvider.setApplicationContext(new AnnotationConfigReactiveWebApplicationContext());
    defaultEhCacheUriProvider.setConfigLocations(new ArrayList<>());
    URI actualJCacheUri = defaultEhCacheUriProvider.getJCacheUri();

    // Assert that nothing has changed
    String expectedToStringResult = String.join("", "file:",
        Paths.get(System.getProperty("java.io.tmpdir"), "broadleaf-merged-jcache.xml").toString());
    assertEquals(expectedToStringResult, actualJCacheUri.toString());
  }
}
