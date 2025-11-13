package org.broadleafcommerce.openadmin.dto;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class BatchPersistencePackageDiffblueTest {
  /**
   * Test {@link BatchPersistencePackage#equals(Object)}, and {@link
   * BatchPersistencePackage#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link BatchPersistencePackage#equals(Object)}
   *   <li>{@link BatchPersistencePackage#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean BatchPersistencePackage.equals(Object)",
    "int BatchPersistencePackage.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    BatchPersistencePackage batchPersistencePackage = new BatchPersistencePackage();
    batchPersistencePackage.setPersistencePackages(
        new PersistencePackage[] {new PersistencePackage()});

    BatchPersistencePackage batchPersistencePackage2 = new BatchPersistencePackage();
    batchPersistencePackage2.setPersistencePackages(
        new PersistencePackage[] {new PersistencePackage()});

    // Act and Assert
    assertEquals(batchPersistencePackage, batchPersistencePackage2);
    assertEquals(batchPersistencePackage.hashCode(), batchPersistencePackage2.hashCode());
  }

  /**
   * Test {@link BatchPersistencePackage#equals(Object)}, and {@link
   * BatchPersistencePackage#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link BatchPersistencePackage#equals(Object)}
   *   <li>{@link BatchPersistencePackage#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean BatchPersistencePackage.equals(Object)",
    "int BatchPersistencePackage.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    BatchPersistencePackage batchPersistencePackage = new BatchPersistencePackage();
    batchPersistencePackage.setPersistencePackages(
        new PersistencePackage[] {new PersistencePackage()});

    // Act and Assert
    assertEquals(batchPersistencePackage, batchPersistencePackage);
    int expectedHashCodeResult = batchPersistencePackage.hashCode();
    assertEquals(expectedHashCodeResult, batchPersistencePackage.hashCode());
  }

  /**
   * Test {@link BatchPersistencePackage#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link BatchPersistencePackage#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean BatchPersistencePackage.equals(Object)",
    "int BatchPersistencePackage.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    BatchPersistencePackage batchPersistencePackage = new BatchPersistencePackage();
    batchPersistencePackage.setPersistencePackages(new PersistencePackage[] {null});

    BatchPersistencePackage batchPersistencePackage2 = new BatchPersistencePackage();
    batchPersistencePackage2.setPersistencePackages(
        new PersistencePackage[] {new PersistencePackage()});

    // Act and Assert
    assertNotEquals(batchPersistencePackage, batchPersistencePackage2);
  }

  /**
   * Test {@link BatchPersistencePackage#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link BatchPersistencePackage#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean BatchPersistencePackage.equals(Object)",
    "int BatchPersistencePackage.hashCode()"
  })
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    BatchPersistencePackage batchPersistencePackage = new BatchPersistencePackage();
    batchPersistencePackage.setPersistencePackages(
        new PersistencePackage[] {new PersistencePackage()});

    // Act and Assert
    assertNotEquals(batchPersistencePackage, null);
  }

  /**
   * Test {@link BatchPersistencePackage#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link BatchPersistencePackage#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean BatchPersistencePackage.equals(Object)",
    "int BatchPersistencePackage.hashCode()"
  })
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    BatchPersistencePackage batchPersistencePackage = new BatchPersistencePackage();
    batchPersistencePackage.setPersistencePackages(
        new PersistencePackage[] {new PersistencePackage()});

    // Act and Assert
    assertNotEquals(batchPersistencePackage, "Different type to BatchPersistencePackage");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link BatchPersistencePackage}
   *   <li>{@link BatchPersistencePackage#setPersistencePackages(PersistencePackage[])}
   *   <li>{@link BatchPersistencePackage#getPersistencePackages()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BatchPersistencePackage.<init>()",
    "PersistencePackage[] BatchPersistencePackage.getPersistencePackages()",
    "void BatchPersistencePackage.setPersistencePackages(PersistencePackage[])"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    BatchPersistencePackage actualBatchPersistencePackage = new BatchPersistencePackage();
    PersistencePackage[] persistencePackages = new PersistencePackage[] {new PersistencePackage()};
    actualBatchPersistencePackage.setPersistencePackages(persistencePackages);

    // Assert
    assertSame(persistencePackages, actualBatchPersistencePackage.getPersistencePackages());
  }
}
