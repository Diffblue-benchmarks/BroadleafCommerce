package org.broadleafcommerce.core.offer.service.type;

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
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {StackabilityType.class})
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@RunWith(SpringJUnit4ClassRunner.class)
public class StackabilityTypeDiffblueTest {
  @Autowired private StackabilityType stackabilityType;

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link StackabilityType#StackabilityType()}
   *   <li>{@link StackabilityType#setOrder(int)}
   *   <li>{@link StackabilityType#getFriendlyType()}
   *   <li>{@link StackabilityType#getOrder()}
   *   <li>{@link StackabilityType#getType()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void StackabilityType.<init>()",
    "String StackabilityType.getFriendlyType()",
    "int StackabilityType.getOrder()",
    "String StackabilityType.getType()",
    "void StackabilityType.setOrder(int)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    StackabilityType actualStackabilityType = new StackabilityType();
    actualStackabilityType.setOrder(1);
    String actualFriendlyType = actualStackabilityType.getFriendlyType();
    int actualOrder = actualStackabilityType.getOrder();

    // Assert
    assertNull(actualFriendlyType);
    assertNull(actualStackabilityType.getType());
    assertEquals(1, actualOrder);
  }

  /**
   * Test {@link StackabilityType#StackabilityType(String, String, int)}.
   *
   * <p>Method under test: {@link StackabilityType#StackabilityType(String, String, int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void StackabilityType.<init>(String, String, int)"})
  public void testNewStackabilityType() {
    // Arrange and Act
    StackabilityType actualStackabilityType = new StackabilityType("Type", "Friendly Type", 1);

    // Assert
    assertEquals("Friendly Type", actualStackabilityType.getFriendlyType());
    assertEquals("Type", actualStackabilityType.getType());
    assertEquals(1, actualStackabilityType.getOrder());
  }

  /**
   * Test {@link StackabilityType#setType(String)}.
   *
   * <ul>
   *   <li>When {@code TypeType}.
   *   <li>Then {@link StackabilityType} Type is {@code TypeType}.
   * </ul>
   *
   * <p>Method under test: {@link StackabilityType#setType(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void StackabilityType.setType(String)"})
  public void testSetType_whenTypeType_thenStackabilityTypeTypeIsTypeType() {
    // Arrange and Act
    stackabilityType.setType("TypeType");

    // Assert
    assertEquals("TypeType", stackabilityType.getType());
  }

  /**
   * Test {@link StackabilityType#setType(String)}.
   *
   * <ul>
   *   <li>When {@code Type}.
   *   <li>Then {@link StackabilityType} Type is {@code Type}.
   * </ul>
   *
   * <p>Method under test: {@link StackabilityType#setType(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void StackabilityType.setType(String)"})
  public void testSetType_whenType_thenStackabilityTypeTypeIsType() {
    // Arrange and Act
    stackabilityType.setType("Type");

    // Assert
    assertEquals("Type", stackabilityType.getType());
  }

  /**
   * Test {@link StackabilityType#equals(Object)}, and {@link StackabilityType#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link StackabilityType#equals(Object)}
   *   <li>{@link StackabilityType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean StackabilityType.equals(Object)", "int StackabilityType.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    StackabilityType stackabilityType = StackabilityType.NO;
    StackabilityType stackabilityType2 = StackabilityType.NO;

    // Act and Assert
    assertEquals(stackabilityType, stackabilityType2);
    assertEquals(stackabilityType.hashCode(), stackabilityType2.hashCode());
  }

  /**
   * Test {@link StackabilityType#equals(Object)}, and {@link StackabilityType#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link StackabilityType#equals(Object)}
   *   <li>{@link StackabilityType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean StackabilityType.equals(Object)", "int StackabilityType.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    StackabilityType stackabilityType = StackabilityType.YES;
    StackabilityType stackabilityType2 = new StackabilityType("YES", "YES", 1);

    // Act and Assert
    assertEquals(stackabilityType, stackabilityType2);
    assertEquals(stackabilityType.hashCode(), stackabilityType2.hashCode());
  }

  /**
   * Test {@link StackabilityType#equals(Object)}, and {@link StackabilityType#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link StackabilityType#equals(Object)}
   *   <li>{@link StackabilityType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean StackabilityType.equals(Object)", "int StackabilityType.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    StackabilityType stackabilityType = new StackabilityType();
    StackabilityType stackabilityType2 = new StackabilityType();

    // Act and Assert
    assertEquals(stackabilityType, stackabilityType2);
    assertEquals(stackabilityType.hashCode(), stackabilityType2.hashCode());
  }

  /**
   * Test {@link StackabilityType#equals(Object)}, and {@link StackabilityType#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link StackabilityType#equals(Object)}
   *   <li>{@link StackabilityType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean StackabilityType.equals(Object)", "int StackabilityType.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    StackabilityType stackabilityType = StackabilityType.NO;

    // Act and Assert
    assertEquals(stackabilityType, stackabilityType);
    int expectedHashCodeResult = stackabilityType.hashCode();
    assertEquals(expectedHashCodeResult, stackabilityType.hashCode());
  }

  /**
   * Test {@link StackabilityType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link StackabilityType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean StackabilityType.equals(Object)", "int StackabilityType.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(StackabilityType.YES, StackabilityType.NO);
  }

  /**
   * Test {@link StackabilityType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link StackabilityType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean StackabilityType.equals(Object)", "int StackabilityType.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange, Act and Assert
    assertNotEquals(new StackabilityType(), StackabilityType.NO);
  }

  /**
   * Test {@link StackabilityType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link StackabilityType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean StackabilityType.equals(Object)", "int StackabilityType.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(StackabilityType.NO, null);
  }

  /**
   * Test {@link StackabilityType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link StackabilityType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean StackabilityType.equals(Object)", "int StackabilityType.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(StackabilityType.NO, "Different type to StackabilityType");
  }

  /**
   * Test {@link StackabilityType#compareTo(StackabilityType)} with {@code StackabilityType}.
   *
   * <ul>
   *   <li>When {@link StackabilityType#NO}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link StackabilityType#compareTo(StackabilityType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int StackabilityType.compareTo(StackabilityType)"})
  public void testCompareToWithStackabilityType_whenNo_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, StackabilityType.NO.compareTo(StackabilityType.NO));
  }
}
