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
package org.broadleafcommerce.common.web.device;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {WebRequestDeviceType.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class WebRequestDeviceTypeDiffblueTest {
  @Autowired
  private WebRequestDeviceType webRequestDeviceType;

  /**
   * Method under test: {@link WebRequestDeviceType#getInstance(String)}
   */
  @Test
  public void testGetInstance() {
    // Arrange and Act
    WebRequestDeviceType actualInstance = WebRequestDeviceType.getInstance("Type");

    // Assert
    assertEquals("Friendly Type", actualInstance.getFriendlyType());
    assertEquals("Type", actualInstance.getType());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link WebRequestDeviceType#equals(Object)}
   *   <li>{@link WebRequestDeviceType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    WebRequestDeviceType webRequestDeviceType = WebRequestDeviceType.MOBILE;
    WebRequestDeviceType webRequestDeviceType2 = WebRequestDeviceType.MOBILE;

    // Act and Assert
    assertEquals(webRequestDeviceType, webRequestDeviceType2);
    int expectedHashCodeResult = webRequestDeviceType.hashCode();
    assertEquals(expectedHashCodeResult, webRequestDeviceType2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link WebRequestDeviceType#equals(Object)}
   *   <li>{@link WebRequestDeviceType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    WebRequestDeviceType webRequestDeviceType = WebRequestDeviceType.MOBILE;

    // Act and Assert
    assertEquals(webRequestDeviceType, webRequestDeviceType);
    int expectedHashCodeResult = webRequestDeviceType.hashCode();
    assertEquals(expectedHashCodeResult, webRequestDeviceType.hashCode());
  }

  /**
   * Method under test: {@link WebRequestDeviceType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(WebRequestDeviceType.NORMAL, WebRequestDeviceType.MOBILE);
  }

  /**
   * Method under test: {@link WebRequestDeviceType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(WebRequestDeviceType.MOBILE, null);
  }

  /**
   * Method under test: {@link WebRequestDeviceType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(WebRequestDeviceType.MOBILE, "Different type to WebRequestDeviceType");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link WebRequestDeviceType#WebRequestDeviceType()}
   *   <li>{@link WebRequestDeviceType#toString()}
   *   <li>{@link WebRequestDeviceType#getFriendlyType()}
   *   <li>{@link WebRequestDeviceType#getType()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    WebRequestDeviceType actualWebRequestDeviceType = new WebRequestDeviceType();
    String actualToStringResult = actualWebRequestDeviceType.toString();
    String actualFriendlyType = actualWebRequestDeviceType.getFriendlyType();

    // Assert
    assertNull(actualFriendlyType);
    assertNull(actualWebRequestDeviceType.getType());
    assertNull(actualToStringResult);
  }

  /**
   * Method under test:
   * {@link WebRequestDeviceType#WebRequestDeviceType(String, String)}
   */
  @Test
  public void testNewWebRequestDeviceType() {
    // Arrange and Act
    WebRequestDeviceType actualWebRequestDeviceType = new WebRequestDeviceType("Type", "Friendly Type");

    // Assert
    assertEquals("Friendly Type", actualWebRequestDeviceType.getFriendlyType());
    assertEquals("Type", actualWebRequestDeviceType.getType());
  }

  /**
   * Method under test:
   * {@link WebRequestDeviceType#WebRequestDeviceType(String, String)}
   */
  @Test
  public void testNewWebRequestDeviceType2() {
    // Arrange and Act
    WebRequestDeviceType actualWebRequestDeviceType = new WebRequestDeviceType("Normal", "Friendly Type");

    // Assert
    assertEquals("Friendly Type", actualWebRequestDeviceType.getFriendlyType());
    assertEquals("Normal", actualWebRequestDeviceType.getType());
  }
}
