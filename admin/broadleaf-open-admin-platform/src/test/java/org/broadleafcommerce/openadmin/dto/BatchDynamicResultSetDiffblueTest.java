package org.broadleafcommerce.openadmin.dto;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class BatchDynamicResultSetDiffblueTest {
  /**
   * Test {@link BatchDynamicResultSet#equals(Object)}, and {@link
   * BatchDynamicResultSet#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link BatchDynamicResultSet#equals(Object)}
   *   <li>{@link BatchDynamicResultSet#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean BatchDynamicResultSet.equals(Object)",
    "int BatchDynamicResultSet.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    BatchDynamicResultSet batchDynamicResultSet = new BatchDynamicResultSet();
    batchDynamicResultSet.setDynamicResultSets(new DynamicResultSet[] {});

    BatchDynamicResultSet batchDynamicResultSet2 = new BatchDynamicResultSet();
    batchDynamicResultSet2.setDynamicResultSets(new DynamicResultSet[] {});

    // Act and Assert
    assertEquals(batchDynamicResultSet, batchDynamicResultSet2);
    assertEquals(batchDynamicResultSet.hashCode(), batchDynamicResultSet2.hashCode());
  }

  /**
   * Test {@link BatchDynamicResultSet#equals(Object)}, and {@link
   * BatchDynamicResultSet#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link BatchDynamicResultSet#equals(Object)}
   *   <li>{@link BatchDynamicResultSet#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean BatchDynamicResultSet.equals(Object)",
    "int BatchDynamicResultSet.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    BatchDynamicResultSet batchDynamicResultSet = new BatchDynamicResultSet();
    batchDynamicResultSet.setDynamicResultSets(new DynamicResultSet[] {new DynamicResultSet()});

    // Act and Assert
    assertEquals(batchDynamicResultSet, batchDynamicResultSet);
    int expectedHashCodeResult = batchDynamicResultSet.hashCode();
    assertEquals(expectedHashCodeResult, batchDynamicResultSet.hashCode());
  }

  /**
   * Test {@link BatchDynamicResultSet#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link BatchDynamicResultSet#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean BatchDynamicResultSet.equals(Object)",
    "int BatchDynamicResultSet.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    BatchDynamicResultSet batchDynamicResultSet = new BatchDynamicResultSet();
    batchDynamicResultSet.setDynamicResultSets(new DynamicResultSet[] {new DynamicResultSet()});

    BatchDynamicResultSet batchDynamicResultSet2 = new BatchDynamicResultSet();
    batchDynamicResultSet2.setDynamicResultSets(new DynamicResultSet[] {new DynamicResultSet()});

    // Act and Assert
    assertNotEquals(batchDynamicResultSet, batchDynamicResultSet2);
  }

  /**
   * Test {@link BatchDynamicResultSet#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link BatchDynamicResultSet#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean BatchDynamicResultSet.equals(Object)",
    "int BatchDynamicResultSet.hashCode()"
  })
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    BatchDynamicResultSet batchDynamicResultSet = new BatchDynamicResultSet();
    batchDynamicResultSet.setDynamicResultSets(new DynamicResultSet[] {new DynamicResultSet()});

    // Act and Assert
    assertNotEquals(batchDynamicResultSet, null);
  }

  /**
   * Test {@link BatchDynamicResultSet#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link BatchDynamicResultSet#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean BatchDynamicResultSet.equals(Object)",
    "int BatchDynamicResultSet.hashCode()"
  })
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    BatchDynamicResultSet batchDynamicResultSet = new BatchDynamicResultSet();
    batchDynamicResultSet.setDynamicResultSets(new DynamicResultSet[] {new DynamicResultSet()});

    // Act and Assert
    assertNotEquals(batchDynamicResultSet, "Different type to BatchDynamicResultSet");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link BatchDynamicResultSet}
   *   <li>{@link BatchDynamicResultSet#setDynamicResultSets(DynamicResultSet[])}
   *   <li>{@link BatchDynamicResultSet#getDynamicResultSets()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BatchDynamicResultSet.<init>()",
    "DynamicResultSet[] BatchDynamicResultSet.getDynamicResultSets()",
    "void BatchDynamicResultSet.setDynamicResultSets(DynamicResultSet[])"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    BatchDynamicResultSet actualBatchDynamicResultSet = new BatchDynamicResultSet();
    DynamicResultSet[] dynamicResultSets = new DynamicResultSet[] {new DynamicResultSet()};
    actualBatchDynamicResultSet.setDynamicResultSets(dynamicResultSets);

    // Assert
    assertSame(dynamicResultSets, actualBatchDynamicResultSet.getDynamicResultSets());
  }
}
