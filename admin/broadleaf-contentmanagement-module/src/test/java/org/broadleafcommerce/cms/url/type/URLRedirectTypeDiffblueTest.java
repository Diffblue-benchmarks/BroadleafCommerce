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
package org.broadleafcommerce.cms.url.type;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@ContextConfiguration(classes = {URLRedirectType.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class URLRedirectTypeDiffblueTest {
  @Autowired
  private URLRedirectType uRLRedirectType;

  /**
   * Method under test: {@link URLRedirectType#getInstance(String)}
   */
  @Test
  public void testGetInstance() {
    // Arrange and Act
    URLRedirectType actualInstance = URLRedirectType.getInstance("https://example.org/example");

    // Assert
    assertEquals("https://example.org/example", actualInstance.getFriendlyType());
    assertEquals("https://example.org/example", actualInstance.getType());
  }

  /**
   * Method under test: {@link URLRedirectType#setType(String)}
   */
  @Test
  public void testSetType() {
    // Arrange
    URLRedirectType urlRedirectType = URLRedirectType.FORWARD;

    // Act
    urlRedirectType.setType("https://example.org/example");

    // Assert
    assertEquals("https://example.org/example", urlRedirectType.getType());
  }

  /**
   * Method under test: {@link URLRedirectType#setType(String)}
   */
  @Test
  public void testSetType2() {
    // Arrange
    URLRedirectType urlRedirectType = URLRedirectType.FORWARD;

    // Act
    urlRedirectType.setType("https://example.org/examplehttps://example.org/example");

    // Assert
    assertEquals("https://example.org/examplehttps://example.org/example", urlRedirectType.getType());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link URLRedirectType#equals(Object)}
   *   <li>{@link URLRedirectType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    URLRedirectType urlRedirectType = URLRedirectType.FORWARD;
    URLRedirectType urlRedirectType2 = URLRedirectType.FORWARD;

    // Act and Assert
    assertEquals(urlRedirectType, urlRedirectType2);
    int expectedHashCodeResult = urlRedirectType.hashCode();
    assertEquals(expectedHashCodeResult, urlRedirectType2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link URLRedirectType#equals(Object)}
   *   <li>{@link URLRedirectType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    URLRedirectType urlRedirectType = new URLRedirectType();
    URLRedirectType urlRedirectType2 = new URLRedirectType();

    // Act and Assert
    assertEquals(urlRedirectType, urlRedirectType2);
    int expectedHashCodeResult = urlRedirectType.hashCode();
    assertEquals(expectedHashCodeResult, urlRedirectType2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link URLRedirectType#equals(Object)}
   *   <li>{@link URLRedirectType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    URLRedirectType urlRedirectType = new URLRedirectType("FORWARD", "https://example.org/example");
    URLRedirectType urlRedirectType2 = URLRedirectType.FORWARD;

    // Act and Assert
    assertEquals(urlRedirectType, urlRedirectType2);
    int expectedHashCodeResult = urlRedirectType.hashCode();
    assertEquals(expectedHashCodeResult, urlRedirectType2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link URLRedirectType#equals(Object)}
   *   <li>{@link URLRedirectType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    URLRedirectType urlRedirectType = URLRedirectType.FORWARD;

    // Act and Assert
    assertEquals(urlRedirectType, urlRedirectType);
    int expectedHashCodeResult = urlRedirectType.hashCode();
    assertEquals(expectedHashCodeResult, urlRedirectType.hashCode());
  }

  /**
   * Method under test: {@link URLRedirectType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(URLRedirectType.REDIRECT_PERM, URLRedirectType.FORWARD);
    assertNotEquals(new URLRedirectType(), URLRedirectType.FORWARD);
  }

  /**
   * Method under test: {@link URLRedirectType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(URLRedirectType.FORWARD, null);
  }

  /**
   * Method under test: {@link URLRedirectType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(URLRedirectType.FORWARD, "Different type to URLRedirectType");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link URLRedirectType#URLRedirectType()}
   *   <li>{@link URLRedirectType#getFriendlyType()}
   *   <li>{@link URLRedirectType#getType()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    URLRedirectType actualUrlRedirectType = new URLRedirectType();
    String actualFriendlyType = actualUrlRedirectType.getFriendlyType();

    // Assert
    assertNull(actualFriendlyType);
    assertNull(actualUrlRedirectType.getType());
  }

  /**
   * Method under test: {@link URLRedirectType#URLRedirectType(String, String)}
   */
  @Test
  public void testNewURLRedirectType() {
    // Arrange and Act
    URLRedirectType actualUrlRedirectType = new URLRedirectType("https://example.org/example",
        "https://example.org/example");

    // Assert
    assertEquals("https://example.org/example", actualUrlRedirectType.getFriendlyType());
    assertEquals("https://example.org/example", actualUrlRedirectType.getType());
  }
}
