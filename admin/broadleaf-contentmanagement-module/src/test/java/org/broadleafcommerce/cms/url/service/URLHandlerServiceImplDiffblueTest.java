/*-
 * #%L
 * BroadleafCommerce CMS Module
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
package org.broadleafcommerce.cms.url.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.broadleafcommerce.common.site.domain.Site;
import org.broadleafcommerce.common.site.domain.SiteImpl;
import org.junit.Test;

public class URLHandlerServiceImplDiffblueTest {
  /**
   * Method under test: {@link URLHandlerServiceImpl#checkForMatches(String)}
   */
  @Test
  public void testCheckForMatches() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new URLHandlerServiceImpl()).checkForMatches("https://example.org/example"));
  }

  /**
   * Method under test:
   * {@link URLHandlerServiceImpl#removeURLHandlerFromCache(String)}
   */
  @Test
  public void testRemoveURLHandlerFromCache() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new URLHandlerServiceImpl()).removeURLHandlerFromCache(null));
  }

  /**
   * Method under test: {@link URLHandlerServiceImpl#manipulateUri(String)}
   */
  @Test
  public void testManipulateUri() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("https://example.org/example",
        (new URLHandlerServiceImpl()).manipulateUri("https://example.org/example"));
  }

  /**
   * Method under test:
   * {@link URLHandlerServiceImpl#buildURLHandlerCacheKey(Site, String)}
   */
  @Test
  public void testBuildURLHandlerCacheKey() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    URLHandlerServiceImpl urlHandlerServiceImpl = new URLHandlerServiceImpl();

    // Act and Assert
    assertEquals("site:null_https://example.org/example",
        urlHandlerServiceImpl.buildURLHandlerCacheKey(new SiteImpl(), "https://example.org/example"));
  }

  /**
   * Method under test:
   * {@link URLHandlerServiceImpl#buildURLHandlerCacheKey(Site, String)}
   */
  @Test
  public void testBuildURLHandlerCacheKey2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("null", (new URLHandlerServiceImpl()).buildURLHandlerCacheKey(null, null));
  }

  /**
   * Method under test:
   * {@link URLHandlerServiceImpl#buildURLHandlerCacheKey(Site, String)}
   */
  @Test
  public void testBuildURLHandlerCacheKey3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    URLHandlerServiceImpl urlHandlerServiceImpl = new URLHandlerServiceImpl();
    SiteImpl site = mock(SiteImpl.class);
    when(site.getId()).thenReturn(1L);

    // Act
    String actualBuildURLHandlerCacheKeyResult = urlHandlerServiceImpl.buildURLHandlerCacheKey(site,
        "https://example.org/example");

    // Assert
    verify(site).getId();
    assertEquals("site:1_https://example.org/example", actualBuildURLHandlerCacheKeyResult);
  }

  /**
   * Method under test:
   * {@link URLHandlerServiceImpl#wrapStringsWithAnchors(String)}
   */
  @Test
  public void testWrapStringsWithAnchors() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("^/https://example.org/example$",
        (new URLHandlerServiceImpl()).wrapStringsWithAnchors("https://example.org/example"));
    assertEquals("^$", (new URLHandlerServiceImpl()).wrapStringsWithAnchors("^"));
    assertEquals("^/$", (new URLHandlerServiceImpl()).wrapStringsWithAnchors("$"));
    assertEquals("^ $", (new URLHandlerServiceImpl()).wrapStringsWithAnchors(" "));
    assertEquals("^([\\[\\]\\.\\|\\?\\*\\+\\(\\)\\\\~`\\!@#%&\\-_+={}'\"\"<>:;, \\/])$", (new URLHandlerServiceImpl())
        .wrapStringsWithAnchors("([\\[\\]\\.\\|\\?\\*\\+\\(\\)\\\\~`\\!@#%&\\-_+={}'\"\"<>:;, \\/])"));
  }
}
