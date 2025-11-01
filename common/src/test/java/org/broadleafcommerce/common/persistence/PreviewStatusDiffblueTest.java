/*-
 * #%L
 * BroadleafCommerce Common Libraries
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
package org.broadleafcommerce.common.persistence;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class PreviewStatusDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link PreviewStatus#equals(Object)}
   *   <li>{@link PreviewStatus#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    PreviewStatus previewStatus = new PreviewStatus();
    previewStatus.setPreview(true);

    PreviewStatus previewStatus2 = new PreviewStatus();
    previewStatus2.setPreview(true);

    // Act and Assert
    assertEquals(previewStatus, previewStatus2);
    int expectedHashCodeResult = previewStatus.hashCode();
    assertEquals(expectedHashCodeResult, previewStatus2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link PreviewStatus#equals(Object)}
   *   <li>{@link PreviewStatus#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    PreviewStatus previewStatus = new PreviewStatus();
    previewStatus.setPreview(null);

    PreviewStatus previewStatus2 = new PreviewStatus();
    previewStatus2.setPreview(null);

    // Act and Assert
    assertEquals(previewStatus, previewStatus2);
    int expectedHashCodeResult = previewStatus.hashCode();
    assertEquals(expectedHashCodeResult, previewStatus2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link PreviewStatus#equals(Object)}
   *   <li>{@link PreviewStatus#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    PreviewStatus previewStatus = new PreviewStatus();
    previewStatus.setPreview(true);

    // Act and Assert
    assertEquals(previewStatus, previewStatus);
    int expectedHashCodeResult = previewStatus.hashCode();
    assertEquals(expectedHashCodeResult, previewStatus.hashCode());
  }

  /**
   * Method under test: {@link PreviewStatus#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    PreviewStatus previewStatus = new PreviewStatus();
    previewStatus.setPreview(false);

    PreviewStatus previewStatus2 = new PreviewStatus();
    previewStatus2.setPreview(true);

    // Act and Assert
    assertNotEquals(previewStatus, previewStatus2);
  }

  /**
   * Method under test: {@link PreviewStatus#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    PreviewStatus previewStatus = new PreviewStatus();
    previewStatus.setPreview(null);

    PreviewStatus previewStatus2 = new PreviewStatus();
    previewStatus2.setPreview(true);

    // Act and Assert
    assertNotEquals(previewStatus, previewStatus2);
  }

  /**
   * Method under test: {@link PreviewStatus#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    PreviewStatus previewStatus = new PreviewStatus();
    previewStatus.setPreview(true);

    // Act and Assert
    assertNotEquals(previewStatus, null);
  }

  /**
   * Method under test: {@link PreviewStatus#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    PreviewStatus previewStatus = new PreviewStatus();
    previewStatus.setPreview(true);

    // Act and Assert
    assertNotEquals(previewStatus, "Different type to PreviewStatus");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link PreviewStatus}
   *   <li>{@link PreviewStatus#setPreview(Boolean)}
   *   <li>{@link PreviewStatus#getPreview()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    PreviewStatus actualPreviewStatus = new PreviewStatus();
    actualPreviewStatus.setPreview(true);

    // Assert that nothing has changed
    assertTrue(actualPreviewStatus.getPreview());
  }
}
