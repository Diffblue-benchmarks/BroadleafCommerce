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
package org.broadleafcommerce.openadmin.web.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;

public class TranslationFormActionDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TranslationFormAction#TranslationFormAction()}
   *   <li>{@link TranslationFormAction#getFriendlyType()}
   *   <li>{@link TranslationFormAction#getType()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    TranslationFormAction actualTranslationFormAction = new TranslationFormAction();
    String actualFriendlyType = actualTranslationFormAction.getFriendlyType();

    // Assert
    assertNull(actualFriendlyType);
    assertNull(actualTranslationFormAction.getType());
  }

  /**
   * Test {@link TranslationFormAction#equals(Object)}, and
   * {@link TranslationFormAction#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TranslationFormAction#equals(Object)}
   *   <li>{@link TranslationFormAction#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TranslationFormAction translationFormAction = TranslationFormAction.ADD;
    TranslationFormAction translationFormAction2 = TranslationFormAction.ADD;

    // Act and Assert
    assertEquals(translationFormAction, translationFormAction2);
    int expectedHashCodeResult = translationFormAction.hashCode();
    assertEquals(expectedHashCodeResult, translationFormAction2.hashCode());
  }

  /**
   * Test {@link TranslationFormAction#equals(Object)}, and
   * {@link TranslationFormAction#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TranslationFormAction#equals(Object)}
   *   <li>{@link TranslationFormAction#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    TranslationFormAction translationFormAction = new TranslationFormAction();
    TranslationFormAction translationFormAction2 = new TranslationFormAction();

    // Act and Assert
    assertEquals(translationFormAction, translationFormAction2);
    int expectedHashCodeResult = translationFormAction.hashCode();
    assertEquals(expectedHashCodeResult, translationFormAction2.hashCode());
  }

  /**
   * Test {@link TranslationFormAction#equals(Object)}, and
   * {@link TranslationFormAction#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TranslationFormAction#equals(Object)}
   *   <li>{@link TranslationFormAction#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TranslationFormAction translationFormAction = TranslationFormAction.ADD;

    // Act and Assert
    assertEquals(translationFormAction, translationFormAction);
    int expectedHashCodeResult = translationFormAction.hashCode();
    assertEquals(expectedHashCodeResult, translationFormAction.hashCode());
  }

  /**
   * Test {@link TranslationFormAction#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TranslationFormAction#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(TranslationFormAction.OTHER, TranslationFormAction.ADD);
    assertNotEquals(new TranslationFormAction(), TranslationFormAction.ADD);
  }

  /**
   * Test {@link TranslationFormAction#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TranslationFormAction#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(TranslationFormAction.ADD, null);
  }

  /**
   * Test {@link TranslationFormAction#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TranslationFormAction#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(TranslationFormAction.ADD, "Different type to TranslationFormAction");
  }
}
