package org.broadleafcommerce.cms.structure.service.type;

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

@ContextConfiguration(classes = {StructuredContentRuleType.class})
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@RunWith(SpringJUnit4ClassRunner.class)
public class StructuredContentRuleTypeDiffblueTest {
  @Autowired private StructuredContentRuleType structuredContentRuleType;

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link StructuredContentRuleType#StructuredContentRuleType()}
   *   <li>{@link StructuredContentRuleType#getFriendlyType()}
   *   <li>{@link StructuredContentRuleType#getType()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void StructuredContentRuleType.<init>()",
    "String StructuredContentRuleType.getFriendlyType()",
    "String StructuredContentRuleType.getType()"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    StructuredContentRuleType actualStructuredContentRuleType = new StructuredContentRuleType();
    String actualFriendlyType = actualStructuredContentRuleType.getFriendlyType();

    // Assert
    assertNull(actualFriendlyType);
    assertNull(actualStructuredContentRuleType.getType());
  }

  /**
   * Test {@link StructuredContentRuleType#StructuredContentRuleType(String, String)}.
   *
   * <p>Method under test: {@link StructuredContentRuleType#StructuredContentRuleType(String,
   * String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void StructuredContentRuleType.<init>(String, String)"})
  public void testNewStructuredContentRuleType() {
    // Arrange and Act
    StructuredContentRuleType actualStructuredContentRuleType =
        new StructuredContentRuleType("Type", "Friendly Type");

    // Assert
    assertEquals("Friendly Type", actualStructuredContentRuleType.getFriendlyType());
    assertEquals("Type", actualStructuredContentRuleType.getType());
  }

  /**
   * Test {@link StructuredContentRuleType#setType(String)}.
   *
   * <ul>
   *   <li>When {@code TypeType}.
   *   <li>Then {@link StructuredContentRuleType} Type is {@code TypeType}.
   * </ul>
   *
   * <p>Method under test: {@link StructuredContentRuleType#setType(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void StructuredContentRuleType.setType(String)"})
  public void testSetType_whenTypeType_thenStructuredContentRuleTypeTypeIsTypeType() {
    // Arrange and Act
    structuredContentRuleType.setType("TypeType");

    // Assert
    assertEquals("TypeType", structuredContentRuleType.getType());
  }

  /**
   * Test {@link StructuredContentRuleType#setType(String)}.
   *
   * <ul>
   *   <li>When {@code Type}.
   *   <li>Then {@link StructuredContentRuleType} Type is {@code Type}.
   * </ul>
   *
   * <p>Method under test: {@link StructuredContentRuleType#setType(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void StructuredContentRuleType.setType(String)"})
  public void testSetType_whenType_thenStructuredContentRuleTypeTypeIsType() {
    // Arrange and Act
    structuredContentRuleType.setType("Type");

    // Assert
    assertEquals("Type", structuredContentRuleType.getType());
  }

  /**
   * Test {@link StructuredContentRuleType#equals(Object)}, and {@link
   * StructuredContentRuleType#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link StructuredContentRuleType#equals(Object)}
   *   <li>{@link StructuredContentRuleType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean StructuredContentRuleType.equals(Object)",
    "int StructuredContentRuleType.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    StructuredContentRuleType structuredContentRuleType = StructuredContentRuleType.CUSTOMER;
    StructuredContentRuleType structuredContentRuleType2 = StructuredContentRuleType.CUSTOMER;

    // Act and Assert
    assertEquals(structuredContentRuleType, structuredContentRuleType2);
    assertEquals(structuredContentRuleType.hashCode(), structuredContentRuleType2.hashCode());
  }

  /**
   * Test {@link StructuredContentRuleType#equals(Object)}, and {@link
   * StructuredContentRuleType#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link StructuredContentRuleType#equals(Object)}
   *   <li>{@link StructuredContentRuleType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean StructuredContentRuleType.equals(Object)",
    "int StructuredContentRuleType.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    StructuredContentRuleType structuredContentRuleType = StructuredContentRuleType.PRODUCT;
    StructuredContentRuleType structuredContentRuleType2 =
        new StructuredContentRuleType("PRODUCT", "PRODUCT");

    // Act and Assert
    assertEquals(structuredContentRuleType, structuredContentRuleType2);
    assertEquals(structuredContentRuleType.hashCode(), structuredContentRuleType2.hashCode());
  }

  /**
   * Test {@link StructuredContentRuleType#equals(Object)}, and {@link
   * StructuredContentRuleType#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link StructuredContentRuleType#equals(Object)}
   *   <li>{@link StructuredContentRuleType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean StructuredContentRuleType.equals(Object)",
    "int StructuredContentRuleType.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    StructuredContentRuleType structuredContentRuleType = new StructuredContentRuleType();
    StructuredContentRuleType structuredContentRuleType2 = new StructuredContentRuleType();

    // Act and Assert
    assertEquals(structuredContentRuleType, structuredContentRuleType2);
    assertEquals(structuredContentRuleType.hashCode(), structuredContentRuleType2.hashCode());
  }

  /**
   * Test {@link StructuredContentRuleType#equals(Object)}, and {@link
   * StructuredContentRuleType#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link StructuredContentRuleType#equals(Object)}
   *   <li>{@link StructuredContentRuleType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean StructuredContentRuleType.equals(Object)",
    "int StructuredContentRuleType.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    StructuredContentRuleType structuredContentRuleType = StructuredContentRuleType.CUSTOMER;

    // Act and Assert
    assertEquals(structuredContentRuleType, structuredContentRuleType);
    int expectedHashCodeResult = structuredContentRuleType.hashCode();
    assertEquals(expectedHashCodeResult, structuredContentRuleType.hashCode());
  }

  /**
   * Test {@link StructuredContentRuleType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link StructuredContentRuleType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean StructuredContentRuleType.equals(Object)",
    "int StructuredContentRuleType.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(StructuredContentRuleType.PRODUCT, StructuredContentRuleType.CUSTOMER);
  }

  /**
   * Test {@link StructuredContentRuleType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link StructuredContentRuleType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean StructuredContentRuleType.equals(Object)",
    "int StructuredContentRuleType.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange, Act and Assert
    assertNotEquals(new StructuredContentRuleType(), StructuredContentRuleType.CUSTOMER);
  }

  /**
   * Test {@link StructuredContentRuleType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link StructuredContentRuleType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean StructuredContentRuleType.equals(Object)",
    "int StructuredContentRuleType.hashCode()"
  })
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(StructuredContentRuleType.CUSTOMER, null);
  }

  /**
   * Test {@link StructuredContentRuleType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link StructuredContentRuleType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean StructuredContentRuleType.equals(Object)",
    "int StructuredContentRuleType.hashCode()"
  })
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        StructuredContentRuleType.CUSTOMER, "Different type to StructuredContentRuleType");
  }
}
