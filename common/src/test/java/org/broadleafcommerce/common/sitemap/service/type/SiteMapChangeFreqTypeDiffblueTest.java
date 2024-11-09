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

@ContextConfiguration(classes = {SiteMapChangeFreqType.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class SiteMapChangeFreqTypeDiffblueTest {
  @Autowired
  private SiteMapChangeFreqType siteMapChangeFreqType;

  /**
   * Test {@link SiteMapChangeFreqType#getInstance(String)}.
   * <p>
   * Method under test: {@link SiteMapChangeFreqType#getInstance(String)}
   */
  @Test
  public void testGetInstance() {
    // Arrange and Act
    SiteMapChangeFreqType actualInstance = SiteMapChangeFreqType.getInstance("Type");

    // Assert
    assertEquals("Friendly Type", actualInstance.getFriendlyType());
    assertEquals("Type", actualInstance.getType());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link SiteMapChangeFreqType#SiteMapChangeFreqType()}
   *   <li>{@link SiteMapChangeFreqType#getFriendlyType()}
   *   <li>{@link SiteMapChangeFreqType#getType()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    SiteMapChangeFreqType actualSiteMapChangeFreqType = new SiteMapChangeFreqType();
    String actualFriendlyType = actualSiteMapChangeFreqType.getFriendlyType();

    // Assert
    assertNull(actualFriendlyType);
    assertNull(actualSiteMapChangeFreqType.getType());
  }

  /**
   * Test {@link SiteMapChangeFreqType#SiteMapChangeFreqType(String, String)}.
   * <ul>
   *   <li>When {@code always}.</li>
   *   <li>Then return Type is {@code always}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SiteMapChangeFreqType#SiteMapChangeFreqType(String, String)}
   */
  @Test
  public void testNewSiteMapChangeFreqType_whenAlways_thenReturnTypeIsAlways() {
    // Arrange and Act
    SiteMapChangeFreqType actualSiteMapChangeFreqType = new SiteMapChangeFreqType("always", "Friendly Type");

    // Assert
    assertEquals("Friendly Type", actualSiteMapChangeFreqType.getFriendlyType());
    assertEquals("always", actualSiteMapChangeFreqType.getType());
  }

  /**
   * Test {@link SiteMapChangeFreqType#SiteMapChangeFreqType(String, String)}.
   * <ul>
   *   <li>When {@code Type}.</li>
   *   <li>Then return {@code Type}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SiteMapChangeFreqType#SiteMapChangeFreqType(String, String)}
   */
  @Test
  public void testNewSiteMapChangeFreqType_whenType_thenReturnType() {
    // Arrange and Act
    SiteMapChangeFreqType actualSiteMapChangeFreqType = new SiteMapChangeFreqType("Type", "Friendly Type");

    // Assert
    assertEquals("Friendly Type", actualSiteMapChangeFreqType.getFriendlyType());
    assertEquals("Type", actualSiteMapChangeFreqType.getType());
  }

  /**
   * Test {@link SiteMapChangeFreqType#equals(Object)}, and
   * {@link SiteMapChangeFreqType#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link SiteMapChangeFreqType#equals(Object)}
   *   <li>{@link SiteMapChangeFreqType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    SiteMapChangeFreqType siteMapChangeFreqType = SiteMapChangeFreqType.ALWAYS;
    SiteMapChangeFreqType siteMapChangeFreqType2 = SiteMapChangeFreqType.ALWAYS;

    // Act and Assert
    assertEquals(siteMapChangeFreqType, siteMapChangeFreqType2);
    int expectedHashCodeResult = siteMapChangeFreqType.hashCode();
    assertEquals(expectedHashCodeResult, siteMapChangeFreqType2.hashCode());
  }

  /**
   * Test {@link SiteMapChangeFreqType#equals(Object)}, and
   * {@link SiteMapChangeFreqType#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link SiteMapChangeFreqType#equals(Object)}
   *   <li>{@link SiteMapChangeFreqType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    SiteMapChangeFreqType siteMapChangeFreqType = new SiteMapChangeFreqType();
    SiteMapChangeFreqType siteMapChangeFreqType2 = new SiteMapChangeFreqType();

    // Act and Assert
    assertEquals(siteMapChangeFreqType, siteMapChangeFreqType2);
    int expectedHashCodeResult = siteMapChangeFreqType.hashCode();
    assertEquals(expectedHashCodeResult, siteMapChangeFreqType2.hashCode());
  }

  /**
   * Test {@link SiteMapChangeFreqType#equals(Object)}, and
   * {@link SiteMapChangeFreqType#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link SiteMapChangeFreqType#equals(Object)}
   *   <li>{@link SiteMapChangeFreqType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    SiteMapChangeFreqType siteMapChangeFreqType = new SiteMapChangeFreqType("ALWAYS", "Friendly Type");
    SiteMapChangeFreqType siteMapChangeFreqType2 = SiteMapChangeFreqType.ALWAYS;

    // Act and Assert
    assertEquals(siteMapChangeFreqType, siteMapChangeFreqType2);
    int expectedHashCodeResult = siteMapChangeFreqType.hashCode();
    assertEquals(expectedHashCodeResult, siteMapChangeFreqType2.hashCode());
  }

  /**
   * Test {@link SiteMapChangeFreqType#equals(Object)}, and
   * {@link SiteMapChangeFreqType#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link SiteMapChangeFreqType#equals(Object)}
   *   <li>{@link SiteMapChangeFreqType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    SiteMapChangeFreqType siteMapChangeFreqType = SiteMapChangeFreqType.ALWAYS;

    // Act and Assert
    assertEquals(siteMapChangeFreqType, siteMapChangeFreqType);
    int expectedHashCodeResult = siteMapChangeFreqType.hashCode();
    assertEquals(expectedHashCodeResult, siteMapChangeFreqType.hashCode());
  }

  /**
   * Test {@link SiteMapChangeFreqType#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SiteMapChangeFreqType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(SiteMapChangeFreqType.DAILY, SiteMapChangeFreqType.ALWAYS);
    assertNotEquals(new SiteMapChangeFreqType(), SiteMapChangeFreqType.ALWAYS);
  }

  /**
   * Test {@link SiteMapChangeFreqType#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SiteMapChangeFreqType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(SiteMapChangeFreqType.ALWAYS, null);
  }

  /**
   * Test {@link SiteMapChangeFreqType#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SiteMapChangeFreqType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(SiteMapChangeFreqType.ALWAYS, "Different type to SiteMapChangeFreqType");
  }
}
