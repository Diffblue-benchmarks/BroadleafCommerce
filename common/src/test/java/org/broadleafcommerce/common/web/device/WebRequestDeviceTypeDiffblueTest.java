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
   * Test getters and setters.
   * <p>
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
   * Test {@link WebRequestDeviceType#WebRequestDeviceType(String, String)}.
   * <ul>
   *   <li>When {@code Normal}.</li>
   *   <li>Then return Type is {@code Normal}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link WebRequestDeviceType#WebRequestDeviceType(String, String)}
   */
  @Test
  public void testNewWebRequestDeviceType_whenNormal_thenReturnTypeIsNormal() {
    // Arrange and Act
    WebRequestDeviceType actualWebRequestDeviceType = new WebRequestDeviceType("Normal", "Friendly Type");

    // Assert
    assertEquals("Friendly Type", actualWebRequestDeviceType.getFriendlyType());
    assertEquals("Normal", actualWebRequestDeviceType.getType());
  }

  /**
   * Test {@link WebRequestDeviceType#WebRequestDeviceType(String, String)}.
   * <ul>
   *   <li>When {@code Type}.</li>
   *   <li>Then return {@code Type}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link WebRequestDeviceType#WebRequestDeviceType(String, String)}
   */
  @Test
  public void testNewWebRequestDeviceType_whenType_thenReturnType() {
    // Arrange and Act
    WebRequestDeviceType actualWebRequestDeviceType = new WebRequestDeviceType("Type", "Friendly Type");

    // Assert
    assertEquals("Friendly Type", actualWebRequestDeviceType.getFriendlyType());
    assertEquals("Type", actualWebRequestDeviceType.getType());
  }

  /**
   * Test {@link WebRequestDeviceType#getInstance(String)}.
   * <p>
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
   * Test {@link WebRequestDeviceType#equals(Object)}, and
   * {@link WebRequestDeviceType#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
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
   * Test {@link WebRequestDeviceType#equals(Object)}, and
   * {@link WebRequestDeviceType#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
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
   * Test {@link WebRequestDeviceType#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebRequestDeviceType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(WebRequestDeviceType.NORMAL, WebRequestDeviceType.MOBILE);
  }

  /**
   * Test {@link WebRequestDeviceType#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebRequestDeviceType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(WebRequestDeviceType.MOBILE, null);
  }

  /**
   * Test {@link WebRequestDeviceType#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebRequestDeviceType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(WebRequestDeviceType.MOBILE, "Different type to WebRequestDeviceType");
  }
}
