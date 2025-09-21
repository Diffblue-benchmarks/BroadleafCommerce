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
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {SiteMapChangeFreqType.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class SiteMapChangeFreqTypeDiffblueTest {
  @Autowired private SiteMapChangeFreqType siteMapChangeFreqType;

  /**
   * Test {@link SiteMapChangeFreqType#getInstance(String)}.
   *
   * <p>Method under test: {@link SiteMapChangeFreqType#getInstance(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"SiteMapChangeFreqType SiteMapChangeFreqType.getInstance(String)"})
  public void testGetInstance() {
    // Arrange and Act
    SiteMapChangeFreqType actualInstance = SiteMapChangeFreqType.getInstance("Type");

    // Assert
    assertEquals("Friendly Type", actualInstance.getFriendlyType());
    assertEquals("Type", actualInstance.getType());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SiteMapChangeFreqType#SiteMapChangeFreqType()}
   *   <li>{@link SiteMapChangeFreqType#getFriendlyType()}
   *   <li>{@link SiteMapChangeFreqType#getType()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SiteMapChangeFreqType.<init>()",
    "String SiteMapChangeFreqType.getFriendlyType()",
    "String SiteMapChangeFreqType.getType()"
  })
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
   *
   * <p>Method under test: {@link SiteMapChangeFreqType#SiteMapChangeFreqType(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SiteMapChangeFreqType.<init>(String, String)"})
  public void testNewSiteMapChangeFreqType() {
    // Arrange and Act
    SiteMapChangeFreqType actualSiteMapChangeFreqType =
        new SiteMapChangeFreqType("Type", "Friendly Type");

    // Assert
    assertEquals("Friendly Type", actualSiteMapChangeFreqType.getFriendlyType());
    assertEquals("Type", actualSiteMapChangeFreqType.getType());
  }

  /**
   * Test {@link SiteMapChangeFreqType#equals(Object)}, and {@link
   * SiteMapChangeFreqType#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SiteMapChangeFreqType#equals(Object)}
   *   <li>{@link SiteMapChangeFreqType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SiteMapChangeFreqType.equals(Object)",
    "int SiteMapChangeFreqType.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    SiteMapChangeFreqType siteMapChangeFreqType = SiteMapChangeFreqType.ALWAYS;
    SiteMapChangeFreqType siteMapChangeFreqType2 = SiteMapChangeFreqType.ALWAYS;

    // Act and Assert
    assertEquals(siteMapChangeFreqType, siteMapChangeFreqType2);
    assertEquals(siteMapChangeFreqType.hashCode(), siteMapChangeFreqType2.hashCode());
  }

  /**
   * Test {@link SiteMapChangeFreqType#equals(Object)}, and {@link
   * SiteMapChangeFreqType#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SiteMapChangeFreqType#equals(Object)}
   *   <li>{@link SiteMapChangeFreqType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SiteMapChangeFreqType.equals(Object)",
    "int SiteMapChangeFreqType.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    SiteMapChangeFreqType siteMapChangeFreqType = SiteMapChangeFreqType.DAILY;
    SiteMapChangeFreqType siteMapChangeFreqType2 = new SiteMapChangeFreqType("DAILY", "DAILY");

    // Act and Assert
    assertEquals(siteMapChangeFreqType, siteMapChangeFreqType2);
    assertEquals(siteMapChangeFreqType.hashCode(), siteMapChangeFreqType2.hashCode());
  }

  /**
   * Test {@link SiteMapChangeFreqType#equals(Object)}, and {@link
   * SiteMapChangeFreqType#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SiteMapChangeFreqType#equals(Object)}
   *   <li>{@link SiteMapChangeFreqType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SiteMapChangeFreqType.equals(Object)",
    "int SiteMapChangeFreqType.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    SiteMapChangeFreqType siteMapChangeFreqType = new SiteMapChangeFreqType();
    SiteMapChangeFreqType siteMapChangeFreqType2 = new SiteMapChangeFreqType();

    // Act and Assert
    assertEquals(siteMapChangeFreqType, siteMapChangeFreqType2);
    assertEquals(siteMapChangeFreqType.hashCode(), siteMapChangeFreqType2.hashCode());
  }

  /**
   * Test {@link SiteMapChangeFreqType#equals(Object)}, and {@link
   * SiteMapChangeFreqType#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SiteMapChangeFreqType#equals(Object)}
   *   <li>{@link SiteMapChangeFreqType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SiteMapChangeFreqType.equals(Object)",
    "int SiteMapChangeFreqType.hashCode()"
  })
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SiteMapChangeFreqType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SiteMapChangeFreqType.equals(Object)",
    "int SiteMapChangeFreqType.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(SiteMapChangeFreqType.DAILY, SiteMapChangeFreqType.ALWAYS);
  }

  /**
   * Test {@link SiteMapChangeFreqType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SiteMapChangeFreqType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SiteMapChangeFreqType.equals(Object)",
    "int SiteMapChangeFreqType.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange, Act and Assert
    assertNotEquals(new SiteMapChangeFreqType(), SiteMapChangeFreqType.ALWAYS);
  }

  /**
   * Test {@link SiteMapChangeFreqType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SiteMapChangeFreqType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SiteMapChangeFreqType.equals(Object)",
    "int SiteMapChangeFreqType.hashCode()"
  })
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(SiteMapChangeFreqType.ALWAYS, null);
  }

  /**
   * Test {@link SiteMapChangeFreqType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SiteMapChangeFreqType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SiteMapChangeFreqType.equals(Object)",
    "int SiteMapChangeFreqType.hashCode()"
  })
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(SiteMapChangeFreqType.ALWAYS, "Different type to SiteMapChangeFreqType");
  }
}
