package org.broadleafcommerce.openadmin.dto;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;
import org.junit.Test;

public class BatchPersistencePackageDiffblueTest {
  /**
   * Test {@link BatchPersistencePackage#equals(Object)}, and
   * {@link BatchPersistencePackage#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link BatchPersistencePackage#equals(Object)}
   *   <li>{@link BatchPersistencePackage#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    BatchPersistencePackage batchPersistencePackage = new BatchPersistencePackage();
    batchPersistencePackage.setPersistencePackages(new PersistencePackage[]{new PersistencePackage()});

    BatchPersistencePackage batchPersistencePackage2 = new BatchPersistencePackage();
    batchPersistencePackage2.setPersistencePackages(new PersistencePackage[]{new PersistencePackage()});

    // Act and Assert
    assertEquals(batchPersistencePackage, batchPersistencePackage2);
    int expectedHashCodeResult = batchPersistencePackage.hashCode();
    assertEquals(expectedHashCodeResult, batchPersistencePackage2.hashCode());
  }

  /**
   * Test {@link BatchPersistencePackage#equals(Object)}, and
   * {@link BatchPersistencePackage#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link BatchPersistencePackage#equals(Object)}
   *   <li>{@link BatchPersistencePackage#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    BatchPersistencePackage batchPersistencePackage = new BatchPersistencePackage();
    batchPersistencePackage.setPersistencePackages(new PersistencePackage[]{new PersistencePackage()});

    // Act and Assert
    assertEquals(batchPersistencePackage, batchPersistencePackage);
    int expectedHashCodeResult = batchPersistencePackage.hashCode();
    assertEquals(expectedHashCodeResult, batchPersistencePackage.hashCode());
  }

  /**
   * Test {@link BatchPersistencePackage#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link BatchPersistencePackage#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    BatchPersistencePackage batchPersistencePackage = new BatchPersistencePackage();
    batchPersistencePackage.setPersistencePackages(new PersistencePackage[]{null});

    BatchPersistencePackage batchPersistencePackage2 = new BatchPersistencePackage();
    batchPersistencePackage2.setPersistencePackages(new PersistencePackage[]{new PersistencePackage()});

    // Act and Assert
    assertNotEquals(batchPersistencePackage, batchPersistencePackage2);
  }

  /**
   * Test {@link BatchPersistencePackage#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link BatchPersistencePackage#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    BatchPersistencePackage batchPersistencePackage = new BatchPersistencePackage();
    batchPersistencePackage.setPersistencePackages(new PersistencePackage[]{mock(PersistencePackage.class)});

    BatchPersistencePackage batchPersistencePackage2 = new BatchPersistencePackage();
    batchPersistencePackage2.setPersistencePackages(new PersistencePackage[]{new PersistencePackage()});

    // Act and Assert
    assertNotEquals(batchPersistencePackage, batchPersistencePackage2);
  }

  /**
   * Test {@link BatchPersistencePackage#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link BatchPersistencePackage#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    BatchPersistencePackage batchPersistencePackage = new BatchPersistencePackage();
    batchPersistencePackage.setPersistencePackages(new PersistencePackage[]{new PersistencePackage()});

    // Act and Assert
    assertNotEquals(batchPersistencePackage, null);
  }

  /**
   * Test {@link BatchPersistencePackage#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link BatchPersistencePackage#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    BatchPersistencePackage batchPersistencePackage = new BatchPersistencePackage();
    batchPersistencePackage.setPersistencePackages(new PersistencePackage[]{new PersistencePackage()});

    // Act and Assert
    assertNotEquals(batchPersistencePackage, "Different type to BatchPersistencePackage");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link BatchPersistencePackage}
   *   <li>
   * {@link BatchPersistencePackage#setPersistencePackages(PersistencePackage[])}
   *   <li>{@link BatchPersistencePackage#getPersistencePackages()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    BatchPersistencePackage actualBatchPersistencePackage = new BatchPersistencePackage();
    PersistencePackage[] persistencePackages = new PersistencePackage[]{new PersistencePackage()};
    actualBatchPersistencePackage.setPersistencePackages(persistencePackages);

    // Assert that nothing has changed
    assertSame(persistencePackages, actualBatchPersistencePackage.getPersistencePackages());
  }
}
