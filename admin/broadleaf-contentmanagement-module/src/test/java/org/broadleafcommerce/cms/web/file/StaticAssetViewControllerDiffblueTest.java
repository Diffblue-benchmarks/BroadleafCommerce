/*-
 * #%L
 * BroadleafCommerce CMS Module
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
package org.broadleafcommerce.cms.web.file;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.HashMap;
import java.util.Map;
import org.junit.Test;
import org.springframework.http.CacheControl;

public class StaticAssetViewControllerDiffblueTest {
  /**
   * Test {@link StaticAssetViewController#convertParameterMap(Map)}.
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link StaticAssetViewController#convertParameterMap(Map)}
   */
  @Test
  public void testConvertParameterMap_whenHashMap_thenReturnEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StaticAssetViewController staticAssetViewController = new StaticAssetViewController();

    // Act and Assert
    assertTrue(staticAssetViewController.convertParameterMap(new HashMap<>()).isEmpty());
  }

  /**
   * Test {@link StaticAssetViewController#removeAssetPrefix(String)}.
   * <ul>
   *   <li>Given {@link StaticAssetViewController} (default constructor)
   * CacheControl is {@link CacheControl}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link StaticAssetViewController#removeAssetPrefix(String)}
   */
  @Test
  public void testRemoveAssetPrefix_givenStaticAssetViewControllerCacheControlIsCacheControl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StaticAssetViewController staticAssetViewController = new StaticAssetViewController();
    staticAssetViewController.setCacheControl(mock(CacheControl.class));

    // Act and Assert
    assertEquals("Request URI", staticAssetViewController.removeAssetPrefix("Request URI"));
  }

  /**
   * Test {@link StaticAssetViewController#removeAssetPrefix(String)}.
   * <ul>
   *   <li>Given {@link StaticAssetViewController} (default constructor).</li>
   *   <li>Then return {@code Request URI}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link StaticAssetViewController#removeAssetPrefix(String)}
   */
  @Test
  public void testRemoveAssetPrefix_givenStaticAssetViewController_thenReturnRequestUri() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("Request URI", (new StaticAssetViewController()).removeAssetPrefix("Request URI"));
  }

  /**
   * Test {@link StaticAssetViewController#removeAssetPrefix(String)}.
   * <ul>
   *   <li>Then return {@code /quest URI}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link StaticAssetViewController#removeAssetPrefix(String)}
   */
  @Test
  public void testRemoveAssetPrefix_thenReturnQuestUri() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StaticAssetViewController staticAssetViewController = new StaticAssetViewController();
    staticAssetViewController.setAssetServerUrlPrefix("foo");

    // Act and Assert
    assertEquals("/quest URI", staticAssetViewController.removeAssetPrefix("Request URI"));
  }

  /**
   * Test {@link StaticAssetViewController#removeAssetPrefix(String)}.
   * <ul>
   *   <li>Then return {@code /}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link StaticAssetViewController#removeAssetPrefix(String)}
   */
  @Test
  public void testRemoveAssetPrefix_thenReturnSlash() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StaticAssetViewController staticAssetViewController = new StaticAssetViewController();
    staticAssetViewController.setAssetServerUrlPrefix("");

    // Act and Assert
    assertEquals("/", staticAssetViewController.removeAssetPrefix("/"));
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link StaticAssetViewController#setAssetServerUrlPrefix(String)}
   *   <li>{@link StaticAssetViewController#setViewResolverName(String)}
   *   <li>{@link StaticAssetViewController#getAssetServerUrlPrefix()}
   *   <li>{@link StaticAssetViewController#getViewResolverName()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    StaticAssetViewController staticAssetViewController = new StaticAssetViewController();

    // Act
    staticAssetViewController.setAssetServerUrlPrefix("https://example.org/example");
    staticAssetViewController.setViewResolverName("View Resolver Name");
    String actualAssetServerUrlPrefix = staticAssetViewController.getAssetServerUrlPrefix();

    // Assert that nothing has changed
    assertEquals("View Resolver Name", staticAssetViewController.getViewResolverName());
    assertEquals("https://example.org/example", actualAssetServerUrlPrefix);
  }

  /**
   * Test new {@link StaticAssetViewController} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link StaticAssetViewController}
   */
  @Test
  public void testNewStaticAssetViewController() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    StaticAssetViewController actualStaticAssetViewController = new StaticAssetViewController();

    // Assert
    assertNull(actualStaticAssetViewController.getVaryByRequestHeaders());
    assertNull(actualStaticAssetViewController.getAssetServerUrlPrefix());
    assertNull(actualStaticAssetViewController.getViewResolverName());
    assertNull(actualStaticAssetViewController.staticAssetStorageService);
    assertNull(actualStaticAssetViewController.namedOperationManager);
    assertNull(actualStaticAssetViewController.siteResolver);
    assertNull(actualStaticAssetViewController.appCtx);
    assertNull(actualStaticAssetViewController.env);
    assertNull(actualStaticAssetViewController.getCacheControl());
    assertEquals(-1, actualStaticAssetViewController.getCacheSeconds());
    assertFalse(actualStaticAssetViewController.isSynchronizeOnSession());
    assertFalse(actualStaticAssetViewController.isAlwaysMustRevalidate());
    assertFalse(actualStaticAssetViewController.isRequireSession());
    assertFalse(actualStaticAssetViewController.isUseExpiresHeader());
    assertTrue(actualStaticAssetViewController.isUseCacheControlHeader());
    assertTrue(actualStaticAssetViewController.isUseCacheControlNoStore());
    assertArrayEquals(new String[]{"GET", "HEAD", "POST"}, actualStaticAssetViewController.getSupportedMethods());
  }
}
