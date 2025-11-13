package org.broadleafcommerce.openadmin.dto;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.common.presentation.client.OperationType;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class OperationTypesDiffblueTest {
  /**
   * Test {@link OperationTypes#OperationTypes()}.
   *
   * <p>Method under test: {@link OperationTypes#OperationTypes()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void OperationTypes.<init>()"})
  public void testNewOperationTypes() {
    // Arrange and Act
    OperationTypes actualOperationTypes = new OperationTypes();

    // Assert
    assertEquals(OperationType.BASIC, actualOperationTypes.getAddType());
    assertEquals(OperationType.BASIC, actualOperationTypes.getFetchType());
    assertEquals(OperationType.BASIC, actualOperationTypes.getInspectType());
    assertEquals(OperationType.BASIC, actualOperationTypes.getRemoveType());
    assertEquals(OperationType.BASIC, actualOperationTypes.getUpdateType());
  }

  /**
   * Test {@link OperationTypes#OperationTypes(OperationType, OperationType, OperationType,
   * OperationType, OperationType)}.
   *
   * <p>Method under test: {@link OperationTypes#OperationTypes(OperationType, OperationType,
   * OperationType, OperationType, OperationType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void OperationTypes.<init>(OperationType, OperationType, OperationType, OperationType, OperationType)"
  })
  public void testNewOperationTypes2() {
    // Arrange and Act
    OperationTypes actualOperationTypes =
        new OperationTypes(
            OperationType.NONDESTRUCTIVEREMOVE,
            OperationType.NONDESTRUCTIVEREMOVE,
            OperationType.NONDESTRUCTIVEREMOVE,
            OperationType.NONDESTRUCTIVEREMOVE,
            OperationType.NONDESTRUCTIVEREMOVE);

    // Assert
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE, actualOperationTypes.getAddType());
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE, actualOperationTypes.getFetchType());
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE, actualOperationTypes.getInspectType());
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE, actualOperationTypes.getRemoveType());
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE, actualOperationTypes.getUpdateType());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link OperationTypes#setAddType(OperationType)}
   *   <li>{@link OperationTypes#setFetchType(OperationType)}
   *   <li>{@link OperationTypes#setInspectType(OperationType)}
   *   <li>{@link OperationTypes#setRemoveType(OperationType)}
   *   <li>{@link OperationTypes#setUpdateType(OperationType)}
   *   <li>{@link OperationTypes#getAddType()}
   *   <li>{@link OperationTypes#getFetchType()}
   *   <li>{@link OperationTypes#getInspectType()}
   *   <li>{@link OperationTypes#getRemoveType()}
   *   <li>{@link OperationTypes#getUpdateType()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "OperationType OperationTypes.getAddType()",
    "OperationType OperationTypes.getFetchType()",
    "OperationType OperationTypes.getInspectType()",
    "OperationType OperationTypes.getRemoveType()",
    "OperationType OperationTypes.getUpdateType()",
    "void OperationTypes.setAddType(OperationType)",
    "void OperationTypes.setFetchType(OperationType)",
    "void OperationTypes.setInspectType(OperationType)",
    "void OperationTypes.setRemoveType(OperationType)",
    "void OperationTypes.setUpdateType(OperationType)"
  })
  public void testGettersAndSetters() {
    // Arrange
    OperationTypes operationTypes = new OperationTypes();

    // Act
    operationTypes.setAddType(OperationType.NONDESTRUCTIVEREMOVE);
    operationTypes.setFetchType(OperationType.NONDESTRUCTIVEREMOVE);
    operationTypes.setInspectType(OperationType.NONDESTRUCTIVEREMOVE);
    operationTypes.setRemoveType(OperationType.NONDESTRUCTIVEREMOVE);
    operationTypes.setUpdateType(OperationType.NONDESTRUCTIVEREMOVE);
    OperationType actualAddType = operationTypes.getAddType();
    OperationType actualFetchType = operationTypes.getFetchType();
    OperationType actualInspectType = operationTypes.getInspectType();
    OperationType actualRemoveType = operationTypes.getRemoveType();

    // Assert
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE, actualAddType);
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE, actualFetchType);
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE, actualInspectType);
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE, actualRemoveType);
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE, operationTypes.getUpdateType());
  }

  /**
   * Test {@link OperationTypes#cloneOperationTypes()}.
   *
   * <p>Method under test: {@link OperationTypes#cloneOperationTypes()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"OperationTypes OperationTypes.cloneOperationTypes()"})
  public void testCloneOperationTypes() {
    // Arrange
    OperationTypes operationTypes = new OperationTypes();

    // Act
    OperationTypes actualCloneOperationTypesResult = operationTypes.cloneOperationTypes();

    // Assert
    assertEquals(operationTypes, actualCloneOperationTypesResult);
  }

  /**
   * Test {@link OperationTypes#equals(Object)}, and {@link OperationTypes#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link OperationTypes#equals(Object)}
   *   <li>{@link OperationTypes#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OperationTypes.equals(Object)", "int OperationTypes.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    OperationTypes operationTypes = new OperationTypes();
    OperationTypes operationTypes2 = new OperationTypes();

    // Act and Assert
    assertEquals(operationTypes, operationTypes2);
    assertEquals(operationTypes.hashCode(), operationTypes2.hashCode());
  }

  /**
   * Test {@link OperationTypes#equals(Object)}, and {@link OperationTypes#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link OperationTypes#equals(Object)}
   *   <li>{@link OperationTypes#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OperationTypes.equals(Object)", "int OperationTypes.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    OperationTypes operationTypes = new OperationTypes();

    // Act and Assert
    assertEquals(operationTypes, operationTypes);
    int expectedHashCodeResult = operationTypes.hashCode();
    assertEquals(expectedHashCodeResult, operationTypes.hashCode());
  }

  /**
   * Test {@link OperationTypes#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OperationTypes#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OperationTypes.equals(Object)", "int OperationTypes.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    OperationTypes operationTypes =
        new OperationTypes(
            OperationType.NONDESTRUCTIVEREMOVE,
            OperationType.NONDESTRUCTIVEREMOVE,
            OperationType.NONDESTRUCTIVEREMOVE,
            OperationType.NONDESTRUCTIVEREMOVE,
            OperationType.NONDESTRUCTIVEREMOVE);

    // Act and Assert
    assertNotEquals(operationTypes, new OperationTypes());
  }

  /**
   * Test {@link OperationTypes#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OperationTypes#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OperationTypes.equals(Object)", "int OperationTypes.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    OperationTypes operationTypes = new OperationTypes();
    operationTypes.setRemoveType(OperationType.NONDESTRUCTIVEREMOVE);

    // Act and Assert
    assertNotEquals(operationTypes, new OperationTypes());
  }

  /**
   * Test {@link OperationTypes#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OperationTypes#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OperationTypes.equals(Object)", "int OperationTypes.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    OperationTypes operationTypes = new OperationTypes();
    operationTypes.setUpdateType(OperationType.NONDESTRUCTIVEREMOVE);

    // Act and Assert
    assertNotEquals(operationTypes, new OperationTypes());
  }

  /**
   * Test {@link OperationTypes#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OperationTypes#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OperationTypes.equals(Object)", "int OperationTypes.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    OperationTypes operationTypes = new OperationTypes();
    operationTypes.setFetchType(OperationType.NONDESTRUCTIVEREMOVE);

    // Act and Assert
    assertNotEquals(operationTypes, new OperationTypes());
  }

  /**
   * Test {@link OperationTypes#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OperationTypes#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OperationTypes.equals(Object)", "int OperationTypes.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    OperationTypes operationTypes = new OperationTypes();
    operationTypes.setInspectType(OperationType.NONDESTRUCTIVEREMOVE);

    // Act and Assert
    assertNotEquals(operationTypes, new OperationTypes());
  }

  /**
   * Test {@link OperationTypes#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OperationTypes#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OperationTypes.equals(Object)", "int OperationTypes.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new OperationTypes(), null);
  }

  /**
   * Test {@link OperationTypes#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OperationTypes#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OperationTypes.equals(Object)", "int OperationTypes.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new OperationTypes(), "Different type to OperationTypes");
  }
}
