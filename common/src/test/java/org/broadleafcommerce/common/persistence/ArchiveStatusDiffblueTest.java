/*-
 * #%L
 * BroadleafCommerce Common Libraries
 * %%
 * Copyright (C) 2009 - 2024 Broadleaf Commerce
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
package org.broadleafcommerce.common.persistence;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import org.junit.Test;

public class ArchiveStatusDiffblueTest {
  /**
   * Test {@link ArchiveStatus#equals(Object)}, and
   * {@link ArchiveStatus#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ArchiveStatus#equals(Object)}
   *   <li>{@link ArchiveStatus#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ArchiveStatus archiveStatus = new ArchiveStatus();
    archiveStatus.setArchived('A');

    ArchiveStatus archiveStatus2 = new ArchiveStatus();
    archiveStatus2.setArchived('A');

    // Act and Assert
    assertEquals(archiveStatus, archiveStatus2);
    int expectedHashCodeResult = archiveStatus.hashCode();
    assertEquals(expectedHashCodeResult, archiveStatus2.hashCode());
  }

  /**
   * Test {@link ArchiveStatus#equals(Object)}, and
   * {@link ArchiveStatus#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ArchiveStatus#equals(Object)}
   *   <li>{@link ArchiveStatus#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    ArchiveStatus archiveStatus = new ArchiveStatus();
    archiveStatus.setArchived(null);

    ArchiveStatus archiveStatus2 = new ArchiveStatus();
    archiveStatus2.setArchived(null);

    // Act and Assert
    assertEquals(archiveStatus, archiveStatus2);
    int expectedHashCodeResult = archiveStatus.hashCode();
    assertEquals(expectedHashCodeResult, archiveStatus2.hashCode());
  }

  /**
   * Test {@link ArchiveStatus#equals(Object)}, and
   * {@link ArchiveStatus#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ArchiveStatus#equals(Object)}
   *   <li>{@link ArchiveStatus#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ArchiveStatus archiveStatus = new ArchiveStatus();
    archiveStatus.setArchived('A');

    // Act and Assert
    assertEquals(archiveStatus, archiveStatus);
    int expectedHashCodeResult = archiveStatus.hashCode();
    assertEquals(expectedHashCodeResult, archiveStatus.hashCode());
  }

  /**
   * Test {@link ArchiveStatus#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ArchiveStatus#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ArchiveStatus archiveStatus = new ArchiveStatus();
    archiveStatus.setArchived('\u0001');

    ArchiveStatus archiveStatus2 = new ArchiveStatus();
    archiveStatus2.setArchived('A');

    // Act and Assert
    assertNotEquals(archiveStatus, archiveStatus2);
  }

  /**
   * Test {@link ArchiveStatus#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ArchiveStatus#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ArchiveStatus archiveStatus = new ArchiveStatus();
    archiveStatus.setArchived(null);

    ArchiveStatus archiveStatus2 = new ArchiveStatus();
    archiveStatus2.setArchived('A');

    // Act and Assert
    assertNotEquals(archiveStatus, archiveStatus2);
  }

  /**
   * Test {@link ArchiveStatus#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ArchiveStatus#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    ArchiveStatus archiveStatus = new ArchiveStatus();
    archiveStatus.setArchived('A');

    // Act and Assert
    assertNotEquals(archiveStatus, null);
  }

  /**
   * Test {@link ArchiveStatus#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ArchiveStatus#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    ArchiveStatus archiveStatus = new ArchiveStatus();
    archiveStatus.setArchived('A');

    // Act and Assert
    assertNotEquals(archiveStatus, "Different type to ArchiveStatus");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link ArchiveStatus}
   *   <li>{@link ArchiveStatus#setArchived(Character)}
   *   <li>{@link ArchiveStatus#getArchived()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    ArchiveStatus actualArchiveStatus = new ArchiveStatus();
    actualArchiveStatus.setArchived('A');

    // Assert that nothing has changed
    assertEquals('A', actualArchiveStatus.getArchived().charValue());
  }
}
