/*-
 * #%L
 * BroadleafCommerce Framework
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
package org.broadleafcommerce.core.media.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import org.broadleafcommerce.core.media.domain.CategoryMediaMap.CategoryMediaMapPK;
import org.junit.Test;

public class CategoryMediaMapDiffblueTest {
  /**
   * Test CategoryMediaMapPK {@link CategoryMediaMapPK#equals(Object)}, and
   * {@link CategoryMediaMapPK#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link CategoryMediaMap.CategoryMediaMapPK#equals(Object)}
   *   <li>{@link CategoryMediaMap.CategoryMediaMapPK#hashCode()}
   * </ul>
   */
  @Test
  public void testCategoryMediaMapPKEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    CategoryMediaMap.CategoryMediaMapPK categoryMediaMapPK = new CategoryMediaMap.CategoryMediaMapPK();
    categoryMediaMapPK.setCategoryId(1L);
    categoryMediaMapPK.setMediaId(1L);

    CategoryMediaMap.CategoryMediaMapPK categoryMediaMapPK2 = new CategoryMediaMap.CategoryMediaMapPK();
    categoryMediaMapPK2.setCategoryId(1L);
    categoryMediaMapPK2.setMediaId(1L);

    // Act and Assert
    assertEquals(categoryMediaMapPK, categoryMediaMapPK2);
    int expectedHashCodeResult = categoryMediaMapPK.hashCode();
    assertEquals(expectedHashCodeResult, categoryMediaMapPK2.hashCode());
  }

  /**
   * Test CategoryMediaMapPK {@link CategoryMediaMapPK#equals(Object)}, and
   * {@link CategoryMediaMapPK#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link CategoryMediaMap.CategoryMediaMapPK#equals(Object)}
   *   <li>{@link CategoryMediaMap.CategoryMediaMapPK#hashCode()}
   * </ul>
   */
  @Test
  public void testCategoryMediaMapPKEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    CategoryMediaMap.CategoryMediaMapPK categoryMediaMapPK = new CategoryMediaMap.CategoryMediaMapPK();
    categoryMediaMapPK.setCategoryId(1L);
    categoryMediaMapPK.setMediaId(1L);

    // Act and Assert
    assertEquals(categoryMediaMapPK, categoryMediaMapPK);
    int expectedHashCodeResult = categoryMediaMapPK.hashCode();
    assertEquals(expectedHashCodeResult, categoryMediaMapPK.hashCode());
  }

  /**
   * Test CategoryMediaMapPK {@link CategoryMediaMapPK#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryMediaMap.CategoryMediaMapPK#equals(Object)}
   */
  @Test
  public void testCategoryMediaMapPKEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    CategoryMediaMap.CategoryMediaMapPK categoryMediaMapPK = new CategoryMediaMap.CategoryMediaMapPK();
    categoryMediaMapPK.setCategoryId(2L);
    categoryMediaMapPK.setMediaId(1L);

    CategoryMediaMap.CategoryMediaMapPK categoryMediaMapPK2 = new CategoryMediaMap.CategoryMediaMapPK();
    categoryMediaMapPK2.setCategoryId(1L);
    categoryMediaMapPK2.setMediaId(1L);

    // Act and Assert
    assertNotEquals(categoryMediaMapPK, categoryMediaMapPK2);
  }

  /**
   * Test CategoryMediaMapPK {@link CategoryMediaMapPK#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryMediaMap.CategoryMediaMapPK#equals(Object)}
   */
  @Test
  public void testCategoryMediaMapPKEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    CategoryMediaMap.CategoryMediaMapPK categoryMediaMapPK = new CategoryMediaMap.CategoryMediaMapPK();
    categoryMediaMapPK.setCategoryId(1L);
    categoryMediaMapPK.setMediaId(2L);

    CategoryMediaMap.CategoryMediaMapPK categoryMediaMapPK2 = new CategoryMediaMap.CategoryMediaMapPK();
    categoryMediaMapPK2.setCategoryId(1L);
    categoryMediaMapPK2.setMediaId(1L);

    // Act and Assert
    assertNotEquals(categoryMediaMapPK, categoryMediaMapPK2);
  }

  /**
   * Test CategoryMediaMapPK {@link CategoryMediaMapPK#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryMediaMap.CategoryMediaMapPK#equals(Object)}
   */
  @Test
  public void testCategoryMediaMapPKEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    CategoryMediaMap.CategoryMediaMapPK categoryMediaMapPK = new CategoryMediaMap.CategoryMediaMapPK();
    categoryMediaMapPK.setCategoryId(1L);
    categoryMediaMapPK.setMediaId(1L);

    // Act and Assert
    assertNotEquals(categoryMediaMapPK, null);
  }

  /**
   * Test CategoryMediaMapPK {@link CategoryMediaMapPK#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryMediaMap.CategoryMediaMapPK#equals(Object)}
   */
  @Test
  public void testCategoryMediaMapPKEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    CategoryMediaMap.CategoryMediaMapPK categoryMediaMapPK = new CategoryMediaMap.CategoryMediaMapPK();
    categoryMediaMapPK.setCategoryId(1L);
    categoryMediaMapPK.setMediaId(1L);

    // Act and Assert
    assertNotEquals(categoryMediaMapPK, "Different type to CategoryMediaMapPK");
  }

  /**
   * Test CategoryMediaMapPK getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link CategoryMediaMap.CategoryMediaMapPK}
   *   <li>{@link CategoryMediaMap.CategoryMediaMapPK#setCategoryId(Long)}
   *   <li>{@link CategoryMediaMap.CategoryMediaMapPK#setMediaId(Long)}
   *   <li>{@link CategoryMediaMap.CategoryMediaMapPK#getCategoryId()}
   *   <li>{@link CategoryMediaMap.CategoryMediaMapPK#getMediaId()}
   * </ul>
   */
  @Test
  public void testCategoryMediaMapPKGettersAndSetters() {
    // Arrange and Act
    CategoryMediaMap.CategoryMediaMapPK actualCategoryMediaMapPK = new CategoryMediaMap.CategoryMediaMapPK();
    actualCategoryMediaMapPK.setCategoryId(1L);
    actualCategoryMediaMapPK.setMediaId(1L);
    Long actualCategoryId = actualCategoryMediaMapPK.getCategoryId();
    Long actualMediaId = actualCategoryMediaMapPK.getMediaId();

    // Assert that nothing has changed
    assertEquals(1L, actualCategoryId.longValue());
    assertEquals(1L, actualMediaId.longValue());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link CategoryMediaMap}
   *   <li>{@link CategoryMediaMap#setKey(String)}
   *   <li>{@link CategoryMediaMap#getCategoryMediaMapPK()}
   *   <li>{@link CategoryMediaMap#getKey()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    CategoryMediaMap actualCategoryMediaMap = new CategoryMediaMap();
    actualCategoryMediaMap.setKey("Key");
    actualCategoryMediaMap.getCategoryMediaMapPK();

    // Assert that nothing has changed
    assertEquals("Key", actualCategoryMediaMap.getKey());
  }
}
