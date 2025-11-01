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
package org.broadleafcommerce.common.site.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import org.junit.Test;

public class ThemeDTODiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ThemeDTO#equals(Object)}
   *   <li>{@link ThemeDTO#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ThemeDTO themeDTO = new ThemeDTO("Name", "Path");
    ThemeDTO themeDTO2 = new ThemeDTO("Name", "Path");

    // Act and Assert
    assertEquals(themeDTO, themeDTO2);
    int expectedHashCodeResult = themeDTO.hashCode();
    assertEquals(expectedHashCodeResult, themeDTO2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ThemeDTO#equals(Object)}
   *   <li>{@link ThemeDTO#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ThemeDTO themeDTO = new ThemeDTO("Name", "Path");

    // Act and Assert
    assertEquals(themeDTO, themeDTO);
    int expectedHashCodeResult = themeDTO.hashCode();
    assertEquals(expectedHashCodeResult, themeDTO.hashCode());
  }

  /**
   * Method under test: {@link ThemeDTO#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ThemeDTO themeDTO = new ThemeDTO("Name", "Path");
    themeDTO.setId(1L);

    // Act and Assert
    assertNotEquals(themeDTO, new ThemeDTO("Name", "Path"));
  }

  /**
   * Method under test: {@link ThemeDTO#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ThemeDTO("Name", "Path"), null);
  }

  /**
   * Method under test: {@link ThemeDTO#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ThemeDTO("Name", "Path"), "Different type to ThemeDTO");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ThemeDTO#ThemeDTO()}
   *   <li>{@link ThemeDTO#setId(Long)}
   *   <li>{@link ThemeDTO#setName(String)}
   *   <li>{@link ThemeDTO#setPath(String)}
   *   <li>{@link ThemeDTO#getId()}
   *   <li>{@link ThemeDTO#getName()}
   *   <li>{@link ThemeDTO#getPath()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    ThemeDTO actualThemeDTO = new ThemeDTO();
    actualThemeDTO.setId(1L);
    actualThemeDTO.setName("Name");
    actualThemeDTO.setPath("Path");
    Long actualId = actualThemeDTO.getId();
    String actualName = actualThemeDTO.getName();

    // Assert that nothing has changed
    assertEquals("Name", actualName);
    assertEquals("Path", actualThemeDTO.getPath());
    assertEquals(1L, actualId.longValue());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ThemeDTO#ThemeDTO(String, String)}
   *   <li>{@link ThemeDTO#setId(Long)}
   *   <li>{@link ThemeDTO#setName(String)}
   *   <li>{@link ThemeDTO#setPath(String)}
   *   <li>{@link ThemeDTO#getId()}
   *   <li>{@link ThemeDTO#getName()}
   *   <li>{@link ThemeDTO#getPath()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters2() {
    // Arrange and Act
    ThemeDTO actualThemeDTO = new ThemeDTO("Name", "Path");
    actualThemeDTO.setId(1L);
    actualThemeDTO.setName("Name");
    actualThemeDTO.setPath("Path");
    Long actualId = actualThemeDTO.getId();
    String actualName = actualThemeDTO.getName();

    // Assert that nothing has changed
    assertEquals("Name", actualName);
    assertEquals("Path", actualThemeDTO.getPath());
    assertEquals(1L, actualId.longValue());
  }
}
