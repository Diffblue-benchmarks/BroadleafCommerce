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
package org.broadleafcommerce.common.i18n.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {TranslatedEntity.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class TranslatedEntityDiffblueTest {
  @Autowired
  private TranslatedEntity translatedEntity;

  /**
   * Test {@link TranslatedEntity#getInstance(String)}.
   * <p>
   * Method under test: {@link TranslatedEntity#getInstance(String)}
   */
  @Test
  public void testGetInstance() {
    // Arrange and Act
    TranslatedEntity actualInstance = TranslatedEntity.getInstance("Type");

    // Assert
    assertEquals("Friendly Type", actualInstance.getFriendlyType());
    assertEquals("Type", actualInstance.getType());
  }

  /**
   * Test {@link TranslatedEntity#getInstanceFromFriendlyType(String)}.
   * <ul>
   *   <li>When {@code 42}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TranslatedEntity#getInstanceFromFriendlyType(String)}
   */
  @Test
  public void testGetInstanceFromFriendlyType_when42_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(TranslatedEntity.getInstanceFromFriendlyType("42"));
  }

  /**
   * Test {@link TranslatedEntity#TranslatedEntity(String, String)}.
   * <p>
   * Method under test: {@link TranslatedEntity#TranslatedEntity(String, String)}
   */
  @Test
  public void testNewTranslatedEntity() {
    // Arrange and Act
    TranslatedEntity actualTranslatedEntity = new TranslatedEntity("Type", "Friendly Type");

    // Assert
    assertEquals("Friendly Type", actualTranslatedEntity.getFriendlyType());
    assertEquals("Type", actualTranslatedEntity.getType());
  }

  /**
   * Test {@link TranslatedEntity#equals(Object)}, and
   * {@link TranslatedEntity#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TranslatedEntity#equals(Object)}
   *   <li>{@link TranslatedEntity#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TranslatedEntity translatedEntity = TranslatedEntity.CATALOG;
    TranslatedEntity translatedEntity2 = TranslatedEntity.CATALOG;

    // Act and Assert
    assertEquals(translatedEntity, translatedEntity2);
    int expectedHashCodeResult = translatedEntity.hashCode();
    assertEquals(expectedHashCodeResult, translatedEntity2.hashCode());
  }

  /**
   * Test {@link TranslatedEntity#equals(Object)}, and
   * {@link TranslatedEntity#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TranslatedEntity#equals(Object)}
   *   <li>{@link TranslatedEntity#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    TranslatedEntity translatedEntity = TranslatedEntity.CATEGORY;
    TranslatedEntity translatedEntity2 = new TranslatedEntity("org.broadleafcommerce.core.catalog.domain.Category",
        "org.broadleafcommerce.core.catalog.domain.Category");

    // Act and Assert
    assertEquals(translatedEntity, translatedEntity2);
    int expectedHashCodeResult = translatedEntity.hashCode();
    assertEquals(expectedHashCodeResult, translatedEntity2.hashCode());
  }

  /**
   * Test {@link TranslatedEntity#equals(Object)}, and
   * {@link TranslatedEntity#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TranslatedEntity#equals(Object)}
   *   <li>{@link TranslatedEntity#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    TranslatedEntity translatedEntity = new TranslatedEntity();
    TranslatedEntity translatedEntity2 = new TranslatedEntity();

    // Act and Assert
    assertEquals(translatedEntity, translatedEntity2);
    int expectedHashCodeResult = translatedEntity.hashCode();
    assertEquals(expectedHashCodeResult, translatedEntity2.hashCode());
  }

  /**
   * Test {@link TranslatedEntity#equals(Object)}, and
   * {@link TranslatedEntity#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TranslatedEntity#equals(Object)}
   *   <li>{@link TranslatedEntity#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TranslatedEntity translatedEntity = TranslatedEntity.CATALOG;

    // Act and Assert
    assertEquals(translatedEntity, translatedEntity);
    int expectedHashCodeResult = translatedEntity.hashCode();
    assertEquals(expectedHashCodeResult, translatedEntity.hashCode());
  }

  /**
   * Test {@link TranslatedEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TranslatedEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(TranslatedEntity.CATEGORY, TranslatedEntity.CATALOG);
    assertNotEquals(new TranslatedEntity(), TranslatedEntity.CATALOG);
  }

  /**
   * Test {@link TranslatedEntity#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TranslatedEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(TranslatedEntity.CATALOG, null);
  }

  /**
   * Test {@link TranslatedEntity#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TranslatedEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(TranslatedEntity.CATALOG, "Different type to TranslatedEntity");
  }
}
