/*-
 * #%L
 * BroadleafCommerce CMS Module
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
package org.broadleafcommerce.cms.field.type;

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

@ContextConfiguration(classes = {StorageType.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class StorageTypeDiffblueTest {
  @Autowired private StorageType storageType;

  /**
   * Test {@link StorageType#getInstance(String)}.
   *
   * <p>Method under test: {@link StorageType#getInstance(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"StorageType StorageType.getInstance(String)"})
  public void testGetInstance() {
    // Arrange and Act
    StorageType actualInstance = StorageType.getInstance("Type");

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
   *   <li>{@link StorageType#StorageType()}
   *   <li>{@link StorageType#getFriendlyType()}
   *   <li>{@link StorageType#getType()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void StorageType.<init>()",
    "String StorageType.getFriendlyType()",
    "String StorageType.getType()"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    StorageType actualStorageType = new StorageType();
    String actualFriendlyType = actualStorageType.getFriendlyType();

    // Assert
    assertNull(actualFriendlyType);
    assertNull(actualStorageType.getType());
  }

  /**
   * Test {@link StorageType#StorageType(String, String)}.
   *
   * <p>Method under test: {@link StorageType#StorageType(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void StorageType.<init>(String, String)"})
  public void testNewStorageType() {
    // Arrange and Act
    StorageType actualStorageType = new StorageType("Type", "Friendly Type");

    // Assert
    assertEquals("Friendly Type", actualStorageType.getFriendlyType());
    assertEquals("Type", actualStorageType.getType());
  }

  /**
   * Test {@link StorageType#equals(Object)}, and {@link StorageType#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link StorageType#equals(Object)}
   *   <li>{@link StorageType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean StorageType.equals(Object)", "int StorageType.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    StorageType storageType = StorageType.DATABASE;
    StorageType storageType2 = StorageType.DATABASE;

    // Act and Assert
    assertEquals(storageType, storageType2);
    assertEquals(storageType.hashCode(), storageType2.hashCode());
  }

  /**
   * Test {@link StorageType#equals(Object)}, and {@link StorageType#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link StorageType#equals(Object)}
   *   <li>{@link StorageType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean StorageType.equals(Object)", "int StorageType.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    StorageType storageType = StorageType.FILESYSTEM;
    StorageType storageType2 = new StorageType("FILESYSTEM", "FILESYSTEM");

    // Act and Assert
    assertEquals(storageType, storageType2);
    assertEquals(storageType.hashCode(), storageType2.hashCode());
  }

  /**
   * Test {@link StorageType#equals(Object)}, and {@link StorageType#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link StorageType#equals(Object)}
   *   <li>{@link StorageType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean StorageType.equals(Object)", "int StorageType.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    StorageType storageType = new StorageType();
    StorageType storageType2 = new StorageType();

    // Act and Assert
    assertEquals(storageType, storageType2);
    assertEquals(storageType.hashCode(), storageType2.hashCode());
  }

  /**
   * Test {@link StorageType#equals(Object)}, and {@link StorageType#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link StorageType#equals(Object)}
   *   <li>{@link StorageType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean StorageType.equals(Object)", "int StorageType.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    StorageType storageType = StorageType.DATABASE;

    // Act and Assert
    assertEquals(storageType, storageType);
    int expectedHashCodeResult = storageType.hashCode();
    assertEquals(expectedHashCodeResult, storageType.hashCode());
  }

  /**
   * Test {@link StorageType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link StorageType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean StorageType.equals(Object)", "int StorageType.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(StorageType.FILESYSTEM, StorageType.DATABASE);
  }

  /**
   * Test {@link StorageType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link StorageType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean StorageType.equals(Object)", "int StorageType.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange, Act and Assert
    assertNotEquals(new StorageType(), StorageType.DATABASE);
  }

  /**
   * Test {@link StorageType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link StorageType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean StorageType.equals(Object)", "int StorageType.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(StorageType.DATABASE, null);
  }

  /**
   * Test {@link StorageType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link StorageType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean StorageType.equals(Object)", "int StorageType.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(StorageType.DATABASE, "Different type to StorageType");
  }
}
