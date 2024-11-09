/*-
 * #%L
 * BroadleafCommerce Open Admin Platform
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
package org.broadleafcommerce.openadmin.web.controller.modal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;

public class ModalHeaderTypeDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ModalHeaderType#ModalHeaderType()}
   *   <li>{@link ModalHeaderType#getFriendlyType()}
   *   <li>{@link ModalHeaderType#getType()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    ModalHeaderType actualModalHeaderType = new ModalHeaderType();
    String actualFriendlyType = actualModalHeaderType.getFriendlyType();

    // Assert
    assertNull(actualFriendlyType);
    assertNull(actualModalHeaderType.getType());
  }

  /**
   * Test {@link ModalHeaderType#equals(Object)}, and
   * {@link ModalHeaderType#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ModalHeaderType#equals(Object)}
   *   <li>{@link ModalHeaderType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ModalHeaderType modalHeaderType = ModalHeaderType.ADD_COLLECTION_ITEM;
    ModalHeaderType modalHeaderType2 = ModalHeaderType.ADD_COLLECTION_ITEM;

    // Act and Assert
    assertEquals(modalHeaderType, modalHeaderType2);
    int expectedHashCodeResult = modalHeaderType.hashCode();
    assertEquals(expectedHashCodeResult, modalHeaderType2.hashCode());
  }

  /**
   * Test {@link ModalHeaderType#equals(Object)}, and
   * {@link ModalHeaderType#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ModalHeaderType#equals(Object)}
   *   <li>{@link ModalHeaderType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    ModalHeaderType modalHeaderType = new ModalHeaderType();
    ModalHeaderType modalHeaderType2 = new ModalHeaderType();

    // Act and Assert
    assertEquals(modalHeaderType, modalHeaderType2);
    int expectedHashCodeResult = modalHeaderType.hashCode();
    assertEquals(expectedHashCodeResult, modalHeaderType2.hashCode());
  }

  /**
   * Test {@link ModalHeaderType#equals(Object)}, and
   * {@link ModalHeaderType#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ModalHeaderType#equals(Object)}
   *   <li>{@link ModalHeaderType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ModalHeaderType modalHeaderType = ModalHeaderType.ADD_COLLECTION_ITEM;

    // Act and Assert
    assertEquals(modalHeaderType, modalHeaderType);
    int expectedHashCodeResult = modalHeaderType.hashCode();
    assertEquals(expectedHashCodeResult, modalHeaderType.hashCode());
  }

  /**
   * Test {@link ModalHeaderType#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ModalHeaderType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ModalHeaderType.ADD_ENTITY, ModalHeaderType.ADD_COLLECTION_ITEM);
    assertNotEquals(new ModalHeaderType(), ModalHeaderType.ADD_COLLECTION_ITEM);
  }

  /**
   * Test {@link ModalHeaderType#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ModalHeaderType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ModalHeaderType.ADD_COLLECTION_ITEM, null);
  }

  /**
   * Test {@link ModalHeaderType#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ModalHeaderType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ModalHeaderType.ADD_COLLECTION_ITEM, "Different type to ModalHeaderType");
  }
}
