package org.broadleafcommerce.common.file.service.type;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class FileApplicationTypeDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>Then return FriendlyType is {@code null}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link FileApplicationType#FileApplicationType()}
   *   <li>{@link FileApplicationType#getFriendlyType()}
   *   <li>{@link FileApplicationType#getType()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void FileApplicationType.<init>()",
    "void FileApplicationType.<init>(String, String)",
    "String FileApplicationType.getFriendlyType()",
    "String FileApplicationType.getType()"
  })
  public void testGettersAndSetters_thenReturnFriendlyTypeIsNull() {
    // Arrange and Act
    FileApplicationType actualFileApplicationType = new FileApplicationType();
    String actualFriendlyType = actualFileApplicationType.getFriendlyType();

    // Assert
    assertNull(actualFriendlyType);
    assertNull(actualFileApplicationType.getType());
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@code Type}.
   *   <li>Then return {@code Friendly Type}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link FileApplicationType#FileApplicationType(String, String)}
   *   <li>{@link FileApplicationType#getFriendlyType()}
   *   <li>{@link FileApplicationType#getType()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void FileApplicationType.<init>()",
    "void FileApplicationType.<init>(String, String)",
    "String FileApplicationType.getFriendlyType()",
    "String FileApplicationType.getType()"
  })
  public void testGettersAndSetters_whenType_thenReturnFriendlyType() {
    // Arrange and Act
    FileApplicationType actualFileApplicationType =
        new FileApplicationType("Type", "Friendly Type");
    String actualFriendlyType = actualFileApplicationType.getFriendlyType();

    // Assert
    assertEquals("Friendly Type", actualFriendlyType);
    assertEquals("Type", actualFileApplicationType.getType());
  }

  /**
   * Test {@link FileApplicationType#equals(Object)}, and {@link FileApplicationType#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link FileApplicationType#equals(Object)}
   *   <li>{@link FileApplicationType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean FileApplicationType.equals(Object)",
    "int FileApplicationType.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    FileApplicationType fileApplicationType = FileApplicationType.ALL;
    FileApplicationType fileApplicationType2 = FileApplicationType.ALL;

    // Act and Assert
    assertEquals(fileApplicationType, fileApplicationType2);
    assertEquals(fileApplicationType.hashCode(), fileApplicationType2.hashCode());
  }

  /**
   * Test {@link FileApplicationType#equals(Object)}, and {@link FileApplicationType#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link FileApplicationType#equals(Object)}
   *   <li>{@link FileApplicationType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean FileApplicationType.equals(Object)",
    "int FileApplicationType.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    FileApplicationType fileApplicationType = FileApplicationType.IMAGE;
    FileApplicationType fileApplicationType2 = new FileApplicationType("IMAGE", "IMAGE");

    // Act and Assert
    assertEquals(fileApplicationType, fileApplicationType2);
    assertEquals(fileApplicationType.hashCode(), fileApplicationType2.hashCode());
  }

  /**
   * Test {@link FileApplicationType#equals(Object)}, and {@link FileApplicationType#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link FileApplicationType#equals(Object)}
   *   <li>{@link FileApplicationType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean FileApplicationType.equals(Object)",
    "int FileApplicationType.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    FileApplicationType fileApplicationType = new FileApplicationType();
    FileApplicationType fileApplicationType2 = new FileApplicationType();

    // Act and Assert
    assertEquals(fileApplicationType, fileApplicationType2);
    assertEquals(fileApplicationType.hashCode(), fileApplicationType2.hashCode());
  }

  /**
   * Test {@link FileApplicationType#equals(Object)}, and {@link FileApplicationType#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link FileApplicationType#equals(Object)}
   *   <li>{@link FileApplicationType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean FileApplicationType.equals(Object)",
    "int FileApplicationType.hashCode()"
  })
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link FileApplicationType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean FileApplicationType.equals(Object)",
    "int FileApplicationType.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(FileApplicationType.IMAGE, FileApplicationType.ALL);
  }

  /**
   * Test {@link FileApplicationType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link FileApplicationType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean FileApplicationType.equals(Object)",
    "int FileApplicationType.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange, Act and Assert
    assertNotEquals(new FileApplicationType(), FileApplicationType.ALL);
  }

  /**
   * Test {@link FileApplicationType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link FileApplicationType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean FileApplicationType.equals(Object)",
    "int FileApplicationType.hashCode()"
  })
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(FileApplicationType.ALL, null);
  }

  /**
   * Test {@link FileApplicationType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link FileApplicationType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean FileApplicationType.equals(Object)",
    "int FileApplicationType.hashCode()"
  })
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(FileApplicationType.ALL, "Different type to FileApplicationType");
  }
}
