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
package org.broadleafcommerce.common.file.service.type;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {FileApplicationType.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class FileApplicationTypeDiffblueTest {
  @Autowired
  private FileApplicationType fileApplicationType;

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link FileApplicationType#equals(Object)}
   *   <li>{@link FileApplicationType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    FileApplicationType fileApplicationType = FileApplicationType.ALL;
    FileApplicationType fileApplicationType2 = FileApplicationType.ALL;

    // Act and Assert
    assertEquals(fileApplicationType, fileApplicationType2);
    int expectedHashCodeResult = fileApplicationType.hashCode();
    assertEquals(expectedHashCodeResult, fileApplicationType2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link FileApplicationType#equals(Object)}
   *   <li>{@link FileApplicationType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    FileApplicationType fileApplicationType = new FileApplicationType();
    FileApplicationType fileApplicationType2 = new FileApplicationType();

    // Act and Assert
    assertEquals(fileApplicationType, fileApplicationType2);
    int expectedHashCodeResult = fileApplicationType.hashCode();
    assertEquals(expectedHashCodeResult, fileApplicationType2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link FileApplicationType#equals(Object)}
   *   <li>{@link FileApplicationType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    FileApplicationType fileApplicationType = new FileApplicationType("ALL", "Friendly Type");
    FileApplicationType fileApplicationType2 = FileApplicationType.ALL;

    // Act and Assert
    assertEquals(fileApplicationType, fileApplicationType2);
    int expectedHashCodeResult = fileApplicationType.hashCode();
    assertEquals(expectedHashCodeResult, fileApplicationType2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link FileApplicationType#equals(Object)}
   *   <li>{@link FileApplicationType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    FileApplicationType fileApplicationType = FileApplicationType.ALL;

    // Act and Assert
    assertEquals(fileApplicationType, fileApplicationType);
    int expectedHashCodeResult = fileApplicationType.hashCode();
    assertEquals(expectedHashCodeResult, fileApplicationType.hashCode());
  }

  /**
   * Method under test: {@link FileApplicationType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(FileApplicationType.IMAGE, FileApplicationType.ALL);
    assertNotEquals(new FileApplicationType(), FileApplicationType.ALL);
  }

  /**
   * Method under test: {@link FileApplicationType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(FileApplicationType.ALL, null);
  }

  /**
   * Method under test: {@link FileApplicationType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(FileApplicationType.ALL, "Different type to FileApplicationType");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link FileApplicationType#FileApplicationType()}
   *   <li>{@link FileApplicationType#getFriendlyType()}
   *   <li>{@link FileApplicationType#getType()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    FileApplicationType actualFileApplicationType = new FileApplicationType();
    String actualFriendlyType = actualFileApplicationType.getFriendlyType();

    // Assert
    assertNull(actualFriendlyType);
    assertNull(actualFileApplicationType.getType());
  }

  /**
   * Method under test:
   * {@link FileApplicationType#FileApplicationType(String, String)}
   */
  @Test
  public void testNewFileApplicationType() {
    // Arrange and Act
    FileApplicationType actualFileApplicationType = new FileApplicationType("Type", "Friendly Type");

    // Assert
    assertEquals("Friendly Type", actualFileApplicationType.getFriendlyType());
    assertEquals("Type", actualFileApplicationType.getType());
  }

  /**
   * Method under test:
   * {@link FileApplicationType#FileApplicationType(String, String)}
   */
  @Test
  public void testNewFileApplicationType2() {
    // Arrange and Act
    FileApplicationType actualFileApplicationType = new FileApplicationType("Images", "Friendly Type");

    // Assert
    assertEquals("Friendly Type", actualFileApplicationType.getFriendlyType());
    assertEquals("Images", actualFileApplicationType.getType());
  }
}
