/*-
 * #%L
 * BroadleafCommerce Framework
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
package org.broadleafcommerce.core.media.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.core.media.domain.CategoryMediaMap.CategoryMediaMapPK;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class CategoryMediaMapDiffblueTest {
  /**
   * Test CategoryMediaMapPK {@link CategoryMediaMapPK#equals(Object)}, and {@link
   * CategoryMediaMapPK#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CategoryMediaMapPK#equals(Object)}
   *   <li>{@link CategoryMediaMapPK#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CategoryMediaMapPK.equals(Object)",
    "int CategoryMediaMapPK.hashCode()"
  })
  public void testCategoryMediaMapPKEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    CategoryMediaMapPK categoryMediaMapPK = new CategoryMediaMapPK();
    categoryMediaMapPK.setCategoryId(1L);
    categoryMediaMapPK.setMediaId(1L);

    CategoryMediaMapPK categoryMediaMapPK2 = new CategoryMediaMapPK();
    categoryMediaMapPK2.setCategoryId(1L);
    categoryMediaMapPK2.setMediaId(1L);

    // Act and Assert
    assertEquals(categoryMediaMapPK, categoryMediaMapPK2);
    assertEquals(categoryMediaMapPK.hashCode(), categoryMediaMapPK2.hashCode());
  }

  /**
   * Test CategoryMediaMapPK {@link CategoryMediaMapPK#equals(Object)}, and {@link
   * CategoryMediaMapPK#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CategoryMediaMapPK#equals(Object)}
   *   <li>{@link CategoryMediaMapPK#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CategoryMediaMapPK.equals(Object)",
    "int CategoryMediaMapPK.hashCode()"
  })
  public void testCategoryMediaMapPKEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    CategoryMediaMapPK categoryMediaMapPK = new CategoryMediaMapPK();
    categoryMediaMapPK.setCategoryId(1L);
    categoryMediaMapPK.setMediaId(1L);

    // Act and Assert
    assertEquals(categoryMediaMapPK, categoryMediaMapPK);
    int expectedHashCodeResult = categoryMediaMapPK.hashCode();
    assertEquals(expectedHashCodeResult, categoryMediaMapPK.hashCode());
  }

  /**
   * Test CategoryMediaMapPK {@link CategoryMediaMapPK#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CategoryMediaMapPK#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CategoryMediaMapPK.equals(Object)",
    "int CategoryMediaMapPK.hashCode()"
  })
  public void testCategoryMediaMapPKEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    CategoryMediaMapPK categoryMediaMapPK = new CategoryMediaMapPK();
    categoryMediaMapPK.setCategoryId(2L);
    categoryMediaMapPK.setMediaId(1L);

    CategoryMediaMapPK categoryMediaMapPK2 = new CategoryMediaMapPK();
    categoryMediaMapPK2.setCategoryId(1L);
    categoryMediaMapPK2.setMediaId(1L);

    // Act and Assert
    assertNotEquals(categoryMediaMapPK, categoryMediaMapPK2);
  }

  /**
   * Test CategoryMediaMapPK {@link CategoryMediaMapPK#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CategoryMediaMapPK#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CategoryMediaMapPK.equals(Object)",
    "int CategoryMediaMapPK.hashCode()"
  })
  public void testCategoryMediaMapPKEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    CategoryMediaMapPK categoryMediaMapPK = new CategoryMediaMapPK();
    categoryMediaMapPK.setCategoryId(1L);
    categoryMediaMapPK.setMediaId(2L);

    CategoryMediaMapPK categoryMediaMapPK2 = new CategoryMediaMapPK();
    categoryMediaMapPK2.setCategoryId(1L);
    categoryMediaMapPK2.setMediaId(1L);

    // Act and Assert
    assertNotEquals(categoryMediaMapPK, categoryMediaMapPK2);
  }

  /**
   * Test CategoryMediaMapPK {@link CategoryMediaMapPK#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CategoryMediaMapPK#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CategoryMediaMapPK.equals(Object)",
    "int CategoryMediaMapPK.hashCode()"
  })
  public void testCategoryMediaMapPKEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    CategoryMediaMapPK categoryMediaMapPK = new CategoryMediaMapPK();
    categoryMediaMapPK.setCategoryId(1L);
    categoryMediaMapPK.setMediaId(1L);

    // Act and Assert
    assertNotEquals(categoryMediaMapPK, null);
  }

  /**
   * Test CategoryMediaMapPK {@link CategoryMediaMapPK#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CategoryMediaMapPK#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CategoryMediaMapPK.equals(Object)",
    "int CategoryMediaMapPK.hashCode()"
  })
  public void testCategoryMediaMapPKEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    CategoryMediaMapPK categoryMediaMapPK = new CategoryMediaMapPK();
    categoryMediaMapPK.setCategoryId(1L);
    categoryMediaMapPK.setMediaId(1L);

    // Act and Assert
    assertNotEquals(categoryMediaMapPK, "Different type to CategoryMediaMapPK");
  }

  /**
   * Test CategoryMediaMapPK getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link CategoryMediaMapPK}
   *   <li>{@link CategoryMediaMapPK#setCategoryId(Long)}
   *   <li>{@link CategoryMediaMapPK#setMediaId(Long)}
   *   <li>{@link CategoryMediaMapPK#getCategoryId()}
   *   <li>{@link CategoryMediaMapPK#getMediaId()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CategoryMediaMapPK.<init>()",
    "Long CategoryMediaMapPK.getCategoryId()",
    "Long CategoryMediaMapPK.getMediaId()",
    "void CategoryMediaMapPK.setCategoryId(Long)",
    "void CategoryMediaMapPK.setMediaId(Long)"
  })
  public void testCategoryMediaMapPKGettersAndSetters() {
    // Arrange and Act
    CategoryMediaMapPK actualCategoryMediaMapPK = new CategoryMediaMapPK();
    actualCategoryMediaMapPK.setCategoryId(1L);
    actualCategoryMediaMapPK.setMediaId(1L);
    Long actualCategoryId = actualCategoryMediaMapPK.getCategoryId();
    Long actualMediaId = actualCategoryMediaMapPK.getMediaId();

    // Assert
    assertEquals(1L, actualCategoryId.longValue());
    assertEquals(1L, actualMediaId.longValue());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link CategoryMediaMap}
   *   <li>{@link CategoryMediaMap#setKey(String)}
   *   <li>{@link CategoryMediaMap#getCategoryMediaMapPK()}
   *   <li>{@link CategoryMediaMap#getKey()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CategoryMediaMap.<init>()",
    "CategoryMediaMapPK CategoryMediaMap.getCategoryMediaMapPK()",
    "String CategoryMediaMap.getKey()",
    "void CategoryMediaMap.setKey(String)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    CategoryMediaMap actualCategoryMediaMap = new CategoryMediaMap();
    actualCategoryMediaMap.setKey("Key");
    CategoryMediaMapPK actualCategoryMediaMapPK = actualCategoryMediaMap.getCategoryMediaMapPK();

    // Assert
    assertEquals("Key", actualCategoryMediaMap.getKey());
    assertNull(actualCategoryMediaMapPK);
  }
}
