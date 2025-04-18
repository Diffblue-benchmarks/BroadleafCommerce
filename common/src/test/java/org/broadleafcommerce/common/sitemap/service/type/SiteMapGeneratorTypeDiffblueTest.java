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
package org.broadleafcommerce.common.sitemap.service.type;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {SiteMapGeneratorType.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class SiteMapGeneratorTypeDiffblueTest {
  @Autowired
  private SiteMapGeneratorType siteMapGeneratorType;

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link SiteMapGeneratorType#SiteMapGeneratorType()}
   *   <li>{@link SiteMapGeneratorType#getFriendlyType()}
   *   <li>{@link SiteMapGeneratorType#getType()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SiteMapGeneratorType.<init>()", "String SiteMapGeneratorType.getFriendlyType()",
      "String SiteMapGeneratorType.getType()"})
  public void testGettersAndSetters() {
    // Arrange and Act
    SiteMapGeneratorType actualSiteMapGeneratorType = new SiteMapGeneratorType();
    String actualFriendlyType = actualSiteMapGeneratorType.getFriendlyType();

    // Assert
    assertNull(actualFriendlyType);
    assertNull(actualSiteMapGeneratorType.getType());
  }

  /**
   * Test {@link SiteMapGeneratorType#SiteMapGeneratorType(String, String)}.
   * <ul>
   *   <li>When {@code Custom}.</li>
   *   <li>Then return Type is {@code Custom}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SiteMapGeneratorType#SiteMapGeneratorType(String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SiteMapGeneratorType.<init>(String, String)"})
  public void testNewSiteMapGeneratorType_whenCustom_thenReturnTypeIsCustom() {
    // Arrange and Act
    SiteMapGeneratorType actualSiteMapGeneratorType = new SiteMapGeneratorType("Custom", "Friendly Type");

    // Assert
    assertEquals("Custom", actualSiteMapGeneratorType.getType());
    assertEquals("Friendly Type", actualSiteMapGeneratorType.getFriendlyType());
  }

  /**
   * Test {@link SiteMapGeneratorType#SiteMapGeneratorType(String, String)}.
   * <ul>
   *   <li>When {@code Type}.</li>
   *   <li>Then return {@code Type}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SiteMapGeneratorType#SiteMapGeneratorType(String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SiteMapGeneratorType.<init>(String, String)"})
  public void testNewSiteMapGeneratorType_whenType_thenReturnType() {
    // Arrange and Act
    SiteMapGeneratorType actualSiteMapGeneratorType = new SiteMapGeneratorType("Type", "Friendly Type");

    // Assert
    assertEquals("Friendly Type", actualSiteMapGeneratorType.getFriendlyType());
    assertEquals("Type", actualSiteMapGeneratorType.getType());
  }

  /**
   * Test {@link SiteMapGeneratorType#equals(Object)}, and {@link SiteMapGeneratorType#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link SiteMapGeneratorType#equals(Object)}
   *   <li>{@link SiteMapGeneratorType#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean SiteMapGeneratorType.equals(Object)", "int SiteMapGeneratorType.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    SiteMapGeneratorType siteMapGeneratorType = SiteMapGeneratorType.CATEGORY;
    SiteMapGeneratorType siteMapGeneratorType2 = SiteMapGeneratorType.CATEGORY;

    // Act and Assert
    assertEquals(siteMapGeneratorType, siteMapGeneratorType2);
    int expectedHashCodeResult = siteMapGeneratorType.hashCode();
    assertEquals(expectedHashCodeResult, siteMapGeneratorType2.hashCode());
  }

  /**
   * Test {@link SiteMapGeneratorType#equals(Object)}, and {@link SiteMapGeneratorType#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link SiteMapGeneratorType#equals(Object)}
   *   <li>{@link SiteMapGeneratorType#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean SiteMapGeneratorType.equals(Object)", "int SiteMapGeneratorType.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    SiteMapGeneratorType siteMapGeneratorType = new SiteMapGeneratorType();
    SiteMapGeneratorType siteMapGeneratorType2 = new SiteMapGeneratorType();

    // Act and Assert
    assertEquals(siteMapGeneratorType, siteMapGeneratorType2);
    int expectedHashCodeResult = siteMapGeneratorType.hashCode();
    assertEquals(expectedHashCodeResult, siteMapGeneratorType2.hashCode());
  }

  /**
   * Test {@link SiteMapGeneratorType#equals(Object)}, and {@link SiteMapGeneratorType#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link SiteMapGeneratorType#equals(Object)}
   *   <li>{@link SiteMapGeneratorType#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean SiteMapGeneratorType.equals(Object)", "int SiteMapGeneratorType.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    SiteMapGeneratorType siteMapGeneratorType = new SiteMapGeneratorType("CATEGORY", "Friendly Type");
    SiteMapGeneratorType siteMapGeneratorType2 = SiteMapGeneratorType.CATEGORY;

    // Act and Assert
    assertEquals(siteMapGeneratorType, siteMapGeneratorType2);
    int expectedHashCodeResult = siteMapGeneratorType.hashCode();
    assertEquals(expectedHashCodeResult, siteMapGeneratorType2.hashCode());
  }

  /**
   * Test {@link SiteMapGeneratorType#equals(Object)}, and {@link SiteMapGeneratorType#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link SiteMapGeneratorType#equals(Object)}
   *   <li>{@link SiteMapGeneratorType#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean SiteMapGeneratorType.equals(Object)", "int SiteMapGeneratorType.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    SiteMapGeneratorType siteMapGeneratorType = SiteMapGeneratorType.CATEGORY;

    // Act and Assert
    assertEquals(siteMapGeneratorType, siteMapGeneratorType);
    int expectedHashCodeResult = siteMapGeneratorType.hashCode();
    assertEquals(expectedHashCodeResult, siteMapGeneratorType.hashCode());
  }

  /**
   * Test {@link SiteMapGeneratorType#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SiteMapGeneratorType#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean SiteMapGeneratorType.equals(Object)", "int SiteMapGeneratorType.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(SiteMapGeneratorType.CUSTOM, SiteMapGeneratorType.CATEGORY);
  }

  /**
   * Test {@link SiteMapGeneratorType#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SiteMapGeneratorType#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean SiteMapGeneratorType.equals(Object)", "int SiteMapGeneratorType.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange, Act and Assert
    assertNotEquals(new SiteMapGeneratorType(), SiteMapGeneratorType.CATEGORY);
  }

  /**
   * Test {@link SiteMapGeneratorType#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SiteMapGeneratorType#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean SiteMapGeneratorType.equals(Object)", "int SiteMapGeneratorType.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(SiteMapGeneratorType.CATEGORY, null);
  }

  /**
   * Test {@link SiteMapGeneratorType#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SiteMapGeneratorType#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean SiteMapGeneratorType.equals(Object)", "int SiteMapGeneratorType.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(SiteMapGeneratorType.CATEGORY, "Different type to SiteMapGeneratorType");
  }
}
