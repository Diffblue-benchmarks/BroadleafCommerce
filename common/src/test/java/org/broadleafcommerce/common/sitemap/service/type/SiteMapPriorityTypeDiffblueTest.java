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
package org.broadleafcommerce.common.sitemap.service.type;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {SiteMapPriorityType.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class SiteMapPriorityTypeDiffblueTest {
  @Autowired
  private SiteMapPriorityType siteMapPriorityType;

  /**
   * Test {@link SiteMapPriorityType#getInstance(String)}.
   * <p>
   * Method under test: {@link SiteMapPriorityType#getInstance(String)}
   */
  @Test
  public void testGetInstance() {
    // Arrange and Act
    SiteMapPriorityType actualInstance = SiteMapPriorityType.getInstance("Type");

    // Assert
    assertEquals("Friendly Type", actualInstance.getFriendlyType());
    assertEquals("Type", actualInstance.getType());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link SiteMapPriorityType#SiteMapPriorityType()}
   *   <li>{@link SiteMapPriorityType#getFriendlyType()}
   *   <li>{@link SiteMapPriorityType#getType()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    SiteMapPriorityType actualSiteMapPriorityType = new SiteMapPriorityType();
    String actualFriendlyType = actualSiteMapPriorityType.getFriendlyType();

    // Assert
    assertNull(actualFriendlyType);
    assertNull(actualSiteMapPriorityType.getType());
  }

  /**
   * Test {@link SiteMapPriorityType#SiteMapPriorityType(String, String)}.
   * <p>
   * Method under test:
   * {@link SiteMapPriorityType#SiteMapPriorityType(String, String)}
   */
  @Test
  public void testNewSiteMapPriorityType() {
    // Arrange and Act
    SiteMapPriorityType actualSiteMapPriorityType = new SiteMapPriorityType("Type", "Friendly Type");

    // Assert
    assertEquals("Friendly Type", actualSiteMapPriorityType.getFriendlyType());
    assertEquals("Type", actualSiteMapPriorityType.getType());
  }

  /**
   * Test {@link SiteMapPriorityType#equals(Object)}, and
   * {@link SiteMapPriorityType#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link SiteMapPriorityType#equals(Object)}
   *   <li>{@link SiteMapPriorityType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    SiteMapPriorityType siteMapPriorityType = SiteMapPriorityType.ONE;
    SiteMapPriorityType siteMapPriorityType2 = SiteMapPriorityType.ONE;

    // Act and Assert
    assertEquals(siteMapPriorityType, siteMapPriorityType2);
    int expectedHashCodeResult = siteMapPriorityType.hashCode();
    assertEquals(expectedHashCodeResult, siteMapPriorityType2.hashCode());
  }

  /**
   * Test {@link SiteMapPriorityType#equals(Object)}, and
   * {@link SiteMapPriorityType#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link SiteMapPriorityType#equals(Object)}
   *   <li>{@link SiteMapPriorityType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    SiteMapPriorityType siteMapPriorityType = new SiteMapPriorityType();
    SiteMapPriorityType siteMapPriorityType2 = new SiteMapPriorityType();

    // Act and Assert
    assertEquals(siteMapPriorityType, siteMapPriorityType2);
    int expectedHashCodeResult = siteMapPriorityType.hashCode();
    assertEquals(expectedHashCodeResult, siteMapPriorityType2.hashCode());
  }

  /**
   * Test {@link SiteMapPriorityType#equals(Object)}, and
   * {@link SiteMapPriorityType#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link SiteMapPriorityType#equals(Object)}
   *   <li>{@link SiteMapPriorityType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    SiteMapPriorityType siteMapPriorityType = SiteMapPriorityType.ONE;

    // Act and Assert
    assertEquals(siteMapPriorityType, siteMapPriorityType);
    int expectedHashCodeResult = siteMapPriorityType.hashCode();
    assertEquals(expectedHashCodeResult, siteMapPriorityType.hashCode());
  }

  /**
   * Test {@link SiteMapPriorityType#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SiteMapPriorityType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(SiteMapPriorityType.POINT1, SiteMapPriorityType.ONE);
    assertNotEquals(new SiteMapPriorityType(), SiteMapPriorityType.ONE);
  }

  /**
   * Test {@link SiteMapPriorityType#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SiteMapPriorityType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(SiteMapPriorityType.ONE, null);
  }

  /**
   * Test {@link SiteMapPriorityType#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SiteMapPriorityType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(SiteMapPriorityType.ONE, "Different type to SiteMapPriorityType");
  }
}
