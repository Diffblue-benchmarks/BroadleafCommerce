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
package org.broadleafcommerce.common.site.service.type;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {SiteResolutionType.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class SiteResolutionTypeDiffblueTest {
  @Autowired
  private SiteResolutionType siteResolutionType;

  /**
   * Test {@link SiteResolutionType#getInstance(String)}.
   * <p>
   * Method under test: {@link SiteResolutionType#getInstance(String)}
   */
  @Test
  public void testGetInstance() {
    // Arrange and Act
    SiteResolutionType actualInstance = SiteResolutionType.getInstance("Type");

    // Assert
    assertEquals("Friendly Type", actualInstance.getFriendlyType());
    assertEquals("Type", actualInstance.getType());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link SiteResolutionType#SiteResolutionType()}
   *   <li>{@link SiteResolutionType#getFriendlyType()}
   *   <li>{@link SiteResolutionType#getType()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    SiteResolutionType actualSiteResolutionType = new SiteResolutionType();
    String actualFriendlyType = actualSiteResolutionType.getFriendlyType();

    // Assert
    assertNull(actualFriendlyType);
    assertNull(actualSiteResolutionType.getType());
  }

  /**
   * Test {@link SiteResolutionType#SiteResolutionType(String, String)}.
   * <p>
   * Method under test:
   * {@link SiteResolutionType#SiteResolutionType(String, String)}
   */
  @Test
  public void testNewSiteResolutionType() {
    // Arrange and Act
    SiteResolutionType actualSiteResolutionType = new SiteResolutionType("Type", "Friendly Type");

    // Assert
    assertEquals("Friendly Type", actualSiteResolutionType.getFriendlyType());
    assertEquals("Type", actualSiteResolutionType.getType());
  }

  /**
   * Test {@link SiteResolutionType#equals(Object)}, and
   * {@link SiteResolutionType#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link SiteResolutionType#equals(Object)}
   *   <li>{@link SiteResolutionType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    SiteResolutionType siteResolutionType = SiteResolutionType.DOMAIN;
    SiteResolutionType siteResolutionType2 = SiteResolutionType.DOMAIN;

    // Act and Assert
    assertEquals(siteResolutionType, siteResolutionType2);
    int expectedHashCodeResult = siteResolutionType.hashCode();
    assertEquals(expectedHashCodeResult, siteResolutionType2.hashCode());
  }

  /**
   * Test {@link SiteResolutionType#equals(Object)}, and
   * {@link SiteResolutionType#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link SiteResolutionType#equals(Object)}
   *   <li>{@link SiteResolutionType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    SiteResolutionType siteResolutionType = new SiteResolutionType();
    SiteResolutionType siteResolutionType2 = new SiteResolutionType();

    // Act and Assert
    assertEquals(siteResolutionType, siteResolutionType2);
    int expectedHashCodeResult = siteResolutionType.hashCode();
    assertEquals(expectedHashCodeResult, siteResolutionType2.hashCode());
  }

  /**
   * Test {@link SiteResolutionType#equals(Object)}, and
   * {@link SiteResolutionType#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link SiteResolutionType#equals(Object)}
   *   <li>{@link SiteResolutionType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    SiteResolutionType siteResolutionType = new SiteResolutionType("DOMAIN", "Friendly Type");
    SiteResolutionType siteResolutionType2 = SiteResolutionType.DOMAIN;

    // Act and Assert
    assertEquals(siteResolutionType, siteResolutionType2);
    int expectedHashCodeResult = siteResolutionType.hashCode();
    assertEquals(expectedHashCodeResult, siteResolutionType2.hashCode());
  }

  /**
   * Test {@link SiteResolutionType#equals(Object)}, and
   * {@link SiteResolutionType#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link SiteResolutionType#equals(Object)}
   *   <li>{@link SiteResolutionType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    SiteResolutionType siteResolutionType = SiteResolutionType.DOMAIN;

    // Act and Assert
    assertEquals(siteResolutionType, siteResolutionType);
    int expectedHashCodeResult = siteResolutionType.hashCode();
    assertEquals(expectedHashCodeResult, siteResolutionType.hashCode());
  }

  /**
   * Test {@link SiteResolutionType#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SiteResolutionType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(SiteResolutionType.DOMAIN_PREFIX, SiteResolutionType.DOMAIN);
    assertNotEquals(new SiteResolutionType(), SiteResolutionType.DOMAIN);
  }

  /**
   * Test {@link SiteResolutionType#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SiteResolutionType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(SiteResolutionType.DOMAIN, null);
  }

  /**
   * Test {@link SiteResolutionType#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SiteResolutionType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(SiteResolutionType.DOMAIN, "Different type to SiteResolutionType");
  }
}
