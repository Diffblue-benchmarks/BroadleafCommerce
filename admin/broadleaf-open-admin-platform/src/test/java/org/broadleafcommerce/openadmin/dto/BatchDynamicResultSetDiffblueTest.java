package org.broadleafcommerce.openadmin.dto;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;
import org.junit.Test;

public class BatchDynamicResultSetDiffblueTest {
  /**
   * Test {@link BatchDynamicResultSet#equals(Object)}, and
   * {@link BatchDynamicResultSet#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link BatchDynamicResultSet#equals(Object)}
   *   <li>{@link BatchDynamicResultSet#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    BatchDynamicResultSet batchDynamicResultSet = new BatchDynamicResultSet();
    batchDynamicResultSet.setDynamicResultSets(new DynamicResultSet[]{null});

    BatchDynamicResultSet batchDynamicResultSet2 = new BatchDynamicResultSet();
    batchDynamicResultSet2.setDynamicResultSets(new DynamicResultSet[]{null});

    // Act and Assert
    assertEquals(batchDynamicResultSet, batchDynamicResultSet2);
    int expectedHashCodeResult = batchDynamicResultSet.hashCode();
    assertEquals(expectedHashCodeResult, batchDynamicResultSet2.hashCode());
  }

  /**
   * Test {@link BatchDynamicResultSet#equals(Object)}, and
   * {@link BatchDynamicResultSet#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link BatchDynamicResultSet#equals(Object)}
   *   <li>{@link BatchDynamicResultSet#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    BatchDynamicResultSet batchDynamicResultSet = new BatchDynamicResultSet();
    batchDynamicResultSet.setDynamicResultSets(new DynamicResultSet[]{new DynamicResultSet()});

    // Act and Assert
    assertEquals(batchDynamicResultSet, batchDynamicResultSet);
    int expectedHashCodeResult = batchDynamicResultSet.hashCode();
    assertEquals(expectedHashCodeResult, batchDynamicResultSet.hashCode());
  }

  /**
   * Test {@link BatchDynamicResultSet#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link BatchDynamicResultSet#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    BatchDynamicResultSet batchDynamicResultSet = new BatchDynamicResultSet();
    batchDynamicResultSet.setDynamicResultSets(new DynamicResultSet[]{new DynamicResultSet()});

    BatchDynamicResultSet batchDynamicResultSet2 = new BatchDynamicResultSet();
    batchDynamicResultSet2.setDynamicResultSets(new DynamicResultSet[]{new DynamicResultSet()});

    // Act and Assert
    assertNotEquals(batchDynamicResultSet, batchDynamicResultSet2);
  }

  /**
   * Test {@link BatchDynamicResultSet#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link BatchDynamicResultSet#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    BatchDynamicResultSet batchDynamicResultSet = new BatchDynamicResultSet();
    batchDynamicResultSet.setDynamicResultSets(new DynamicResultSet[]{mock(DynamicResultSet.class)});

    BatchDynamicResultSet batchDynamicResultSet2 = new BatchDynamicResultSet();
    batchDynamicResultSet2.setDynamicResultSets(new DynamicResultSet[]{new DynamicResultSet()});

    // Act and Assert
    assertNotEquals(batchDynamicResultSet, batchDynamicResultSet2);
  }

  /**
   * Test {@link BatchDynamicResultSet#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link BatchDynamicResultSet#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    BatchDynamicResultSet batchDynamicResultSet = new BatchDynamicResultSet();
    batchDynamicResultSet.setDynamicResultSets(new DynamicResultSet[]{new DynamicResultSet()});

    // Act and Assert
    assertNotEquals(batchDynamicResultSet, null);
  }

  /**
   * Test {@link BatchDynamicResultSet#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link BatchDynamicResultSet#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    BatchDynamicResultSet batchDynamicResultSet = new BatchDynamicResultSet();
    batchDynamicResultSet.setDynamicResultSets(new DynamicResultSet[]{new DynamicResultSet()});

    // Act and Assert
    assertNotEquals(batchDynamicResultSet, "Different type to BatchDynamicResultSet");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link BatchDynamicResultSet}
   *   <li>{@link BatchDynamicResultSet#setDynamicResultSets(DynamicResultSet[])}
   *   <li>{@link BatchDynamicResultSet#getDynamicResultSets()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    BatchDynamicResultSet actualBatchDynamicResultSet = new BatchDynamicResultSet();
    DynamicResultSet[] dynamicResultSets = new DynamicResultSet[]{new DynamicResultSet()};
    actualBatchDynamicResultSet.setDynamicResultSets(dynamicResultSets);

    // Assert that nothing has changed
    assertSame(dynamicResultSets, actualBatchDynamicResultSet.getDynamicResultSets());
  }
}
