/*-
 * #%L
 * BroadleafCommerce Open Admin Platform
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
package org.broadleafcommerce.openadmin.dto;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;
import org.junit.Test;

public class BatchPersistencePackageDiffblueTest {
  /**
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
