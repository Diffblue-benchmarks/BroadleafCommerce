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
   * Test {@link DeepLink#withAdminBaseUrl(String)}.
   * <ul>
   *   <li>Then {@link DeepLink} AdminBaseUrl is
   * {@code https://example.org/example}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeepLink#withAdminBaseUrl(String)}
   */
  @Test
  public void testWithAdminBaseUrl_thenDeepLinkAdminBaseUrlIsHttpsExampleOrgExample() {
    // Arrange and Act
    DeepLink actualWithAdminBaseUrlResult = deepLink.withAdminBaseUrl("https://example.org/example");

    // Assert
    assertEquals("https://example.org/example", deepLink.getAdminBaseUrl());
    assertEquals("https://example.org/example/null", deepLink.getFullUrl());
    assertSame(deepLink, actualWithAdminBaseUrlResult);
  }

  /**
   * Test {@link DeepLink#withUrlFragment(String)}.
   * <ul>
   *   <li>Then {@link DeepLink} UrlFragment is
   * {@code https://example.org/example}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeepLink#withUrlFragment(String)}
   */
  @Test
  public void testWithUrlFragment_thenDeepLinkUrlFragmentIsHttpsExampleOrgExample() {
    // Arrange and Act
    DeepLink actualWithUrlFragmentResult = deepLink.withUrlFragment("https://example.org/example");

    // Assert
    assertEquals("https://example.org/example", deepLink.getUrlFragment());
    assertEquals("null/https://example.org/example", deepLink.getFullUrl());
    assertSame(deepLink, actualWithUrlFragmentResult);
  }

  /**
   * Test {@link DeepLink#withDisplayText(String)}.
   * <p>
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
   * Test {@link DeepLink#withSourceObject(Object)}.
   * <p>
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
   * Test {@link DeepLink#setAdminBaseUrl(String)}.
   * <ul>
   *   <li>Then {@link DeepLink} AdminBaseUrl is
   * {@code https://example.org/example}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeepLink#setAdminBaseUrl(String)}
   */
  @Test
  public void testSetAdminBaseUrl_thenDeepLinkAdminBaseUrlIsHttpsExampleOrgExample() {
    // Arrange and Act
    deepLink.setAdminBaseUrl("https://example.org/example");

    // Assert
    assertEquals("https://example.org/example", deepLink.getAdminBaseUrl());
    assertEquals("https://example.org/example/null", deepLink.getFullUrl());
  }

  /**
   * Test {@link DeepLink#setUrlFragment(String)}.
   * <ul>
   *   <li>Then {@link DeepLink} UrlFragment is
   * {@code https://example.org/example}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeepLink#setUrlFragment(String)}
   */
  @Test
  public void testSetUrlFragment_thenDeepLinkUrlFragmentIsHttpsExampleOrgExample() {
    // Arrange and Act
    deepLink.setUrlFragment("https://example.org/example");

    // Assert
    assertEquals("https://example.org/example", deepLink.getUrlFragment());
    assertEquals("null/https://example.org/example", deepLink.getFullUrl());
  }

  /**
   * Test {@link DeepLink#getFullUrl()}.
   * <p>
   * Method under test: {@link DeepLink#getFullUrl()}
   */
  @Test
  public void testGetFullUrl() {
    // Arrange, Act and Assert
    assertEquals("null/null", (new DeepLink()).getFullUrl());
  }

  /**
   * Test getters and setters.
   * <p>
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
