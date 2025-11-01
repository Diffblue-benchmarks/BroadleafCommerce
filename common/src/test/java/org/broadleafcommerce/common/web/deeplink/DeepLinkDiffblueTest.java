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
package org.broadleafcommerce.common.web.deeplink;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import org.broadleafcommerce.common.util.BLCFieldUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {DeepLink.class})
@RunWith(SpringJUnit4ClassRunner.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class DeepLinkDiffblueTest {
  @Autowired
  private DeepLink deepLink;

  /**
   * Method under test: {@link DeepLink#withAdminBaseUrl(String)}
   */
  @Test
  public void testWithAdminBaseUrl() {
    // Arrange and Act
    DeepLink actualWithAdminBaseUrlResult = deepLink.withAdminBaseUrl("https://example.org/example");

    // Assert
    assertEquals("https://example.org/example", deepLink.getAdminBaseUrl());
    assertEquals("https://example.org/example/null", deepLink.getFullUrl());
    assertSame(deepLink, actualWithAdminBaseUrlResult);
  }

  /**
   * Method under test: {@link DeepLink#withUrlFragment(String)}
   */
  @Test
  public void testWithUrlFragment() {
    // Arrange and Act
    DeepLink actualWithUrlFragmentResult = deepLink.withUrlFragment("https://example.org/example");

    // Assert
    assertEquals("https://example.org/example", deepLink.getUrlFragment());
    assertEquals("null/https://example.org/example", deepLink.getFullUrl());
    assertSame(deepLink, actualWithUrlFragmentResult);
  }

  /**
   * Method under test: {@link DeepLink#withDisplayText(String)}
   */
  @Test
  public void testWithDisplayText() {
    // Arrange and Act
    DeepLink actualWithDisplayTextResult = deepLink.withDisplayText("Display Text");

    // Assert
    assertEquals("Display Text", deepLink.getDisplayText());
    assertSame(deepLink, actualWithDisplayTextResult);
  }

  /**
   * Method under test: {@link DeepLink#withSourceObject(Object)}
   */
  @Test
  public void testWithSourceObject() {
    // Arrange
    Object object = BLCFieldUtils.NULL_FIELD;

    // Act and Assert
    assertSame(deepLink, deepLink.withSourceObject(object));
    assertSame(object, deepLink.getSourceObject());
  }

  /**
   * Method under test: {@link DeepLink#setAdminBaseUrl(String)}
   */
  @Test
  public void testSetAdminBaseUrl() {
    // Arrange and Act
    deepLink.setAdminBaseUrl("https://example.org/example");

    // Assert
    assertEquals("https://example.org/example", deepLink.getAdminBaseUrl());
    assertEquals("https://example.org/example/null", deepLink.getFullUrl());
  }

  /**
   * Method under test: {@link DeepLink#setUrlFragment(String)}
   */
  @Test
  public void testSetUrlFragment() {
    // Arrange and Act
    deepLink.setUrlFragment("https://example.org/example");

    // Assert
    assertEquals("https://example.org/example", deepLink.getUrlFragment());
    assertEquals("null/https://example.org/example", deepLink.getFullUrl());
  }

  /**
   * Method under test: {@link DeepLink#getFullUrl()}
   */
  @Test
  public void testGetFullUrl() {
    // Arrange, Act and Assert
    assertEquals("null/null", (new DeepLink()).getFullUrl());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link DeepLink}
   *   <li>{@link DeepLink#setDisplayText(String)}
   *   <li>{@link DeepLink#setSourceObject(Object)}
   *   <li>{@link DeepLink#getAdminBaseUrl()}
   *   <li>{@link DeepLink#getDisplayText()}
   *   <li>{@link DeepLink#getSourceObject()}
   *   <li>{@link DeepLink#getUrlFragment()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    DeepLink actualDeepLink = new DeepLink();
    actualDeepLink.setDisplayText("Display Text");
    Object object = BLCFieldUtils.NULL_FIELD;
    actualDeepLink.setSourceObject(object);
    actualDeepLink.getAdminBaseUrl();
    String actualDisplayText = actualDeepLink.getDisplayText();
    Object actualSourceObject = actualDeepLink.getSourceObject();
    actualDeepLink.getUrlFragment();

    // Assert that nothing has changed
    assertEquals("Display Text", actualDisplayText);
    assertSame(object, actualSourceObject);
  }
}
