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
   * Test getters and setters.
   * <p>
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
   * Test {@link FileApplicationType#FileApplicationType(String, String)}.
   * <ul>
   *   <li>When {@code Images}.</li>
   *   <li>Then return Type is {@code Images}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FileApplicationType#FileApplicationType(String, String)}
   */
  @Test
  public void testNewFileApplicationType_whenImages_thenReturnTypeIsImages() {
    // Arrange and Act
    FileApplicationType actualFileApplicationType = new FileApplicationType("Images", "Friendly Type");

    // Assert
    assertEquals("Friendly Type", actualFileApplicationType.getFriendlyType());
    assertEquals("Images", actualFileApplicationType.getType());
  }

  /**
   * Test {@link FileApplicationType#FileApplicationType(String, String)}.
   * <ul>
   *   <li>When {@code Type}.</li>
   *   <li>Then return {@code Type}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FileApplicationType#FileApplicationType(String, String)}
   */
  @Test
  public void testNewFileApplicationType_whenType_thenReturnType() {
    // Arrange and Act
    FileApplicationType actualFileApplicationType = new FileApplicationType("Type", "Friendly Type");

    // Assert
    assertEquals("Friendly Type", actualFileApplicationType.getFriendlyType());
    assertEquals("Type", actualFileApplicationType.getType());
  }

  /**
   * Test {@link FileApplicationType#equals(Object)}, and
   * {@link FileApplicationType#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
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
   * Test {@link FileApplicationType#equals(Object)}, and
   * {@link FileApplicationType#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
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
   * Test {@link FileApplicationType#equals(Object)}, and
   * {@link FileApplicationType#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
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
   * Test {@link FileApplicationType#equals(Object)}, and
   * {@link FileApplicationType#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
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
   * Test {@link FileApplicationType#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link FileApplicationType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(FileApplicationType.IMAGE, FileApplicationType.ALL);
    assertNotEquals(new FileApplicationType(), FileApplicationType.ALL);
  }

  /**
   * Test {@link FileApplicationType#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link FileApplicationType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(FileApplicationType.ALL, null);
  }

  /**
   * Test {@link FileApplicationType#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link FileApplicationType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(FileApplicationType.ALL, "Different type to FileApplicationType");
  }
}
