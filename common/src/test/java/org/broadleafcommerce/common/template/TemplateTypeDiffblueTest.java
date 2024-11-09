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
package org.broadleafcommerce.common.template;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import org.junit.Test;

public class TemplateTypeDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TemplateType#TemplateType()}
   *   <li>{@link TemplateType#setOrder(int)}
   *   <li>{@link TemplateType#getFriendlyType()}
   *   <li>{@link TemplateType#getOrder()}
   *   <li>{@link TemplateType#getType()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    TemplateType actualTemplateType = new TemplateType();
    actualTemplateType.setOrder(1);
    actualTemplateType.getFriendlyType();
    int actualOrder = actualTemplateType.getOrder();
    actualTemplateType.getType();

    // Assert that nothing has changed
    assertEquals(1, actualOrder);
  }

  /**
   * Test {@link TemplateType#equals(Object)}, and
   * {@link TemplateType#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TemplateType#equals(Object)}
   *   <li>{@link TemplateType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TemplateType templateType = TemplateType.CATEGORY;
    TemplateType templateType2 = TemplateType.CATEGORY;

    // Act and Assert
    assertEquals(templateType, templateType2);
    int expectedHashCodeResult = templateType.hashCode();
    assertEquals(expectedHashCodeResult, templateType2.hashCode());
  }

  /**
   * Test {@link TemplateType#equals(Object)}, and
   * {@link TemplateType#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TemplateType#equals(Object)}
   *   <li>{@link TemplateType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    TemplateType templateType = new TemplateType();
    TemplateType templateType2 = new TemplateType();

    // Act and Assert
    assertEquals(templateType, templateType2);
    int expectedHashCodeResult = templateType.hashCode();
    assertEquals(expectedHashCodeResult, templateType2.hashCode());
  }

  /**
   * Test {@link TemplateType#equals(Object)}, and
   * {@link TemplateType#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TemplateType#equals(Object)}
   *   <li>{@link TemplateType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TemplateType templateType = TemplateType.CATEGORY;

    // Act and Assert
    assertEquals(templateType, templateType);
    int expectedHashCodeResult = templateType.hashCode();
    assertEquals(expectedHashCodeResult, templateType.hashCode());
  }

  /**
   * Test {@link TemplateType#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TemplateType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(TemplateType.OTHER, TemplateType.CATEGORY);
    assertNotEquals(new TemplateType(), TemplateType.CATEGORY);
  }

  /**
   * Test {@link TemplateType#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TemplateType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(TemplateType.CATEGORY, null);
  }

  /**
   * Test {@link TemplateType#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TemplateType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(TemplateType.CATEGORY, "Different type to TemplateType");
  }

  /**
   * Test {@link TemplateType#compareTo(TemplateType)} with {@code TemplateType}.
   * <ul>
   *   <li>When {@link TemplateType#CATEGORY}.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link TemplateType#compareTo(TemplateType)}
   */
  @Test
  public void testCompareToWithTemplateType_whenCategory_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, TemplateType.CATEGORY.compareTo(TemplateType.CATEGORY));
  }
}
