package org.broadleafcommerce.common.extensibility.jpa.convert.inheritance;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import javax.persistence.DiscriminatorType;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class SingleTableInheritanceInfoDiffblueTest {
  /**
   * Test {@link SingleTableInheritanceInfo#equals(Object)}, and {@link
   * SingleTableInheritanceInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SingleTableInheritanceInfo#equals(Object)}
   *   <li>{@link SingleTableInheritanceInfo#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SingleTableInheritanceInfo.equals(Object)",
    "int SingleTableInheritanceInfo.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    SingleTableInheritanceInfo singleTableInheritanceInfo = new SingleTableInheritanceInfo();
    singleTableInheritanceInfo.setClassName("Class Name");
    singleTableInheritanceInfo.setDiscriminatorLength(3);
    singleTableInheritanceInfo.setDiscriminatorName("Discriminator Name");
    singleTableInheritanceInfo.setDiscriminatorType(DiscriminatorType.STRING);

    SingleTableInheritanceInfo singleTableInheritanceInfo2 = new SingleTableInheritanceInfo();
    singleTableInheritanceInfo2.setClassName("Class Name");
    singleTableInheritanceInfo2.setDiscriminatorLength(3);
    singleTableInheritanceInfo2.setDiscriminatorName("Discriminator Name");
    singleTableInheritanceInfo2.setDiscriminatorType(DiscriminatorType.STRING);

    // Act and Assert
    assertEquals(singleTableInheritanceInfo, singleTableInheritanceInfo2);
    assertEquals(singleTableInheritanceInfo.hashCode(), singleTableInheritanceInfo2.hashCode());
  }

  /**
   * Test {@link SingleTableInheritanceInfo#equals(Object)}, and {@link
   * SingleTableInheritanceInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SingleTableInheritanceInfo#equals(Object)}
   *   <li>{@link SingleTableInheritanceInfo#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SingleTableInheritanceInfo.equals(Object)",
    "int SingleTableInheritanceInfo.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    SingleTableInheritanceInfo singleTableInheritanceInfo = new SingleTableInheritanceInfo();
    singleTableInheritanceInfo.setClassName(null);
    singleTableInheritanceInfo.setDiscriminatorLength(3);
    singleTableInheritanceInfo.setDiscriminatorName("Discriminator Name");
    singleTableInheritanceInfo.setDiscriminatorType(DiscriminatorType.STRING);

    SingleTableInheritanceInfo singleTableInheritanceInfo2 = new SingleTableInheritanceInfo();
    singleTableInheritanceInfo2.setClassName(null);
    singleTableInheritanceInfo2.setDiscriminatorLength(3);
    singleTableInheritanceInfo2.setDiscriminatorName("Discriminator Name");
    singleTableInheritanceInfo2.setDiscriminatorType(DiscriminatorType.STRING);

    // Act and Assert
    assertEquals(singleTableInheritanceInfo, singleTableInheritanceInfo2);
    assertEquals(singleTableInheritanceInfo.hashCode(), singleTableInheritanceInfo2.hashCode());
  }

  /**
   * Test {@link SingleTableInheritanceInfo#equals(Object)}, and {@link
   * SingleTableInheritanceInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SingleTableInheritanceInfo#equals(Object)}
   *   <li>{@link SingleTableInheritanceInfo#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SingleTableInheritanceInfo.equals(Object)",
    "int SingleTableInheritanceInfo.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    SingleTableInheritanceInfo singleTableInheritanceInfo = new SingleTableInheritanceInfo();
    singleTableInheritanceInfo.setClassName("Class Name");
    singleTableInheritanceInfo.setDiscriminatorLength(3);
    singleTableInheritanceInfo.setDiscriminatorName("Discriminator Name");
    singleTableInheritanceInfo.setDiscriminatorType(DiscriminatorType.STRING);

    // Act and Assert
    assertEquals(singleTableInheritanceInfo, singleTableInheritanceInfo);
    int expectedHashCodeResult = singleTableInheritanceInfo.hashCode();
    assertEquals(expectedHashCodeResult, singleTableInheritanceInfo.hashCode());
  }

  /**
   * Test {@link SingleTableInheritanceInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SingleTableInheritanceInfo#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SingleTableInheritanceInfo.equals(Object)",
    "int SingleTableInheritanceInfo.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    SingleTableInheritanceInfo singleTableInheritanceInfo = new SingleTableInheritanceInfo();
    singleTableInheritanceInfo.setClassName(null);
    singleTableInheritanceInfo.setDiscriminatorLength(3);
    singleTableInheritanceInfo.setDiscriminatorName("Discriminator Name");
    singleTableInheritanceInfo.setDiscriminatorType(DiscriminatorType.STRING);

    SingleTableInheritanceInfo singleTableInheritanceInfo2 = new SingleTableInheritanceInfo();
    singleTableInheritanceInfo2.setClassName("Class Name");
    singleTableInheritanceInfo2.setDiscriminatorLength(3);
    singleTableInheritanceInfo2.setDiscriminatorName("Discriminator Name");
    singleTableInheritanceInfo2.setDiscriminatorType(DiscriminatorType.STRING);

    // Act and Assert
    assertNotEquals(singleTableInheritanceInfo, singleTableInheritanceInfo2);
  }

  /**
   * Test {@link SingleTableInheritanceInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SingleTableInheritanceInfo#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SingleTableInheritanceInfo.equals(Object)",
    "int SingleTableInheritanceInfo.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    SingleTableInheritanceInfo singleTableInheritanceInfo = new SingleTableInheritanceInfo();
    singleTableInheritanceInfo.setClassName("42");
    singleTableInheritanceInfo.setDiscriminatorLength(3);
    singleTableInheritanceInfo.setDiscriminatorName("Discriminator Name");
    singleTableInheritanceInfo.setDiscriminatorType(DiscriminatorType.STRING);

    SingleTableInheritanceInfo singleTableInheritanceInfo2 = new SingleTableInheritanceInfo();
    singleTableInheritanceInfo2.setClassName("Class Name");
    singleTableInheritanceInfo2.setDiscriminatorLength(3);
    singleTableInheritanceInfo2.setDiscriminatorName("Discriminator Name");
    singleTableInheritanceInfo2.setDiscriminatorType(DiscriminatorType.STRING);

    // Act and Assert
    assertNotEquals(singleTableInheritanceInfo, singleTableInheritanceInfo2);
  }

  /**
   * Test {@link SingleTableInheritanceInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SingleTableInheritanceInfo#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SingleTableInheritanceInfo.equals(Object)",
    "int SingleTableInheritanceInfo.hashCode()"
  })
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    SingleTableInheritanceInfo singleTableInheritanceInfo = new SingleTableInheritanceInfo();
    singleTableInheritanceInfo.setClassName("Class Name");
    singleTableInheritanceInfo.setDiscriminatorLength(3);
    singleTableInheritanceInfo.setDiscriminatorName("Discriminator Name");
    singleTableInheritanceInfo.setDiscriminatorType(DiscriminatorType.STRING);

    // Act and Assert
    assertNotEquals(singleTableInheritanceInfo, null);
  }

  /**
   * Test {@link SingleTableInheritanceInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SingleTableInheritanceInfo#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SingleTableInheritanceInfo.equals(Object)",
    "int SingleTableInheritanceInfo.hashCode()"
  })
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    SingleTableInheritanceInfo singleTableInheritanceInfo = new SingleTableInheritanceInfo();
    singleTableInheritanceInfo.setClassName("Class Name");
    singleTableInheritanceInfo.setDiscriminatorLength(3);
    singleTableInheritanceInfo.setDiscriminatorName("Discriminator Name");
    singleTableInheritanceInfo.setDiscriminatorType(DiscriminatorType.STRING);

    // Act and Assert
    assertNotEquals(singleTableInheritanceInfo, "Different type to SingleTableInheritanceInfo");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link SingleTableInheritanceInfo}
   *   <li>{@link SingleTableInheritanceInfo#setClassName(String)}
   *   <li>{@link SingleTableInheritanceInfo#setDiscriminatorLength(int)}
   *   <li>{@link SingleTableInheritanceInfo#setDiscriminatorName(String)}
   *   <li>{@link SingleTableInheritanceInfo#setDiscriminatorType(DiscriminatorType)}
   *   <li>{@link SingleTableInheritanceInfo#getClassName()}
   *   <li>{@link SingleTableInheritanceInfo#getDiscriminatorLength()}
   *   <li>{@link SingleTableInheritanceInfo#getDiscriminatorName()}
   *   <li>{@link SingleTableInheritanceInfo#getDiscriminatorType()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SingleTableInheritanceInfo.<init>()",
    "String SingleTableInheritanceInfo.getClassName()",
    "int SingleTableInheritanceInfo.getDiscriminatorLength()",
    "String SingleTableInheritanceInfo.getDiscriminatorName()",
    "DiscriminatorType SingleTableInheritanceInfo.getDiscriminatorType()",
    "void SingleTableInheritanceInfo.setClassName(String)",
    "void SingleTableInheritanceInfo.setDiscriminatorLength(int)",
    "void SingleTableInheritanceInfo.setDiscriminatorName(String)",
    "void SingleTableInheritanceInfo.setDiscriminatorType(DiscriminatorType)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    SingleTableInheritanceInfo actualSingleTableInheritanceInfo = new SingleTableInheritanceInfo();
    actualSingleTableInheritanceInfo.setClassName("Class Name");
    actualSingleTableInheritanceInfo.setDiscriminatorLength(3);
    actualSingleTableInheritanceInfo.setDiscriminatorName("Discriminator Name");
    actualSingleTableInheritanceInfo.setDiscriminatorType(DiscriminatorType.STRING);
    String actualClassName = actualSingleTableInheritanceInfo.getClassName();
    int actualDiscriminatorLength = actualSingleTableInheritanceInfo.getDiscriminatorLength();
    String actualDiscriminatorName = actualSingleTableInheritanceInfo.getDiscriminatorName();

    // Assert
    assertEquals("Class Name", actualClassName);
    assertEquals("Discriminator Name", actualDiscriminatorName);
    assertEquals(3, actualDiscriminatorLength);
    assertEquals(DiscriminatorType.STRING, actualSingleTableInheritanceInfo.getDiscriminatorType());
  }
}
