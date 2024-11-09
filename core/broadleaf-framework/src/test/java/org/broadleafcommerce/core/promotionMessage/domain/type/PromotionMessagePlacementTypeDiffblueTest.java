/*-
 * #%L
 * BroadleafCommerce Framework
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
package org.broadleafcommerce.core.promotionMessage.domain.type;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {PromotionMessagePlacementType.class})
@RunWith(SpringJUnit4ClassRunner.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class PromotionMessagePlacementTypeDiffblueTest {
  @Autowired
  private PromotionMessagePlacementType promotionMessagePlacementType;

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link PromotionMessagePlacementType#PromotionMessagePlacementType()}
   *   <li>{@link PromotionMessagePlacementType#setOrder(int)}
   *   <li>{@link PromotionMessagePlacementType#getFriendlyType()}
   *   <li>{@link PromotionMessagePlacementType#getOrder()}
   *   <li>{@link PromotionMessagePlacementType#getType()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    PromotionMessagePlacementType actualPromotionMessagePlacementType = new PromotionMessagePlacementType();
    actualPromotionMessagePlacementType.setOrder(1);
    actualPromotionMessagePlacementType.getFriendlyType();
    int actualOrder = actualPromotionMessagePlacementType.getOrder();
    actualPromotionMessagePlacementType.getType();

    // Assert that nothing has changed
    assertEquals(1, actualOrder);
  }

  /**
   * Test
   * {@link PromotionMessagePlacementType#PromotionMessagePlacementType(String, String, int)}.
   * <p>
   * Method under test:
   * {@link PromotionMessagePlacementType#PromotionMessagePlacementType(String, String, int)}
   */
  @Test
  public void testNewPromotionMessagePlacementType() {
    // Arrange and Act
    PromotionMessagePlacementType actualPromotionMessagePlacementType = new PromotionMessagePlacementType("Type",
        "Friendly Type", 1);

    // Assert
    assertEquals("Friendly Type", actualPromotionMessagePlacementType.getFriendlyType());
    assertEquals("Type", actualPromotionMessagePlacementType.getType());
    assertEquals(1, actualPromotionMessagePlacementType.getOrder());
  }

  /**
   * Test {@link PromotionMessagePlacementType#setType(String)}.
   * <ul>
   *   <li>When {@code TypeType}.</li>
   *   <li>Then {@link PromotionMessagePlacementType#BROWSE} Type is
   * {@code TypeType}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PromotionMessagePlacementType#setType(String)}
   */
  @Test
  public void testSetType_whenTypeType_thenBrowseTypeIsTypeType() {
    // Arrange
    PromotionMessagePlacementType promotionMessagePlacementType2 = PromotionMessagePlacementType.BROWSE;

    // Act
    promotionMessagePlacementType2.setType("TypeType");

    // Assert
    assertEquals("TypeType", promotionMessagePlacementType2.getType());
  }

  /**
   * Test {@link PromotionMessagePlacementType#setType(String)}.
   * <ul>
   *   <li>When {@code Type}.</li>
   *   <li>Then {@link PromotionMessagePlacementType#BROWSE} Type is
   * {@code Type}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PromotionMessagePlacementType#setType(String)}
   */
  @Test
  public void testSetType_whenType_thenBrowseTypeIsType() {
    // Arrange
    PromotionMessagePlacementType promotionMessagePlacementType2 = PromotionMessagePlacementType.BROWSE;

    // Act
    promotionMessagePlacementType2.setType("Type");

    // Assert
    assertEquals("Type", promotionMessagePlacementType2.getType());
  }

  /**
   * Test {@link PromotionMessagePlacementType#equals(Object)}, and
   * {@link PromotionMessagePlacementType#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link PromotionMessagePlacementType#equals(Object)}
   *   <li>{@link PromotionMessagePlacementType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    PromotionMessagePlacementType promotionMessagePlacementType = PromotionMessagePlacementType.BROWSE;
    PromotionMessagePlacementType promotionMessagePlacementType2 = PromotionMessagePlacementType.BROWSE;

    // Act and Assert
    assertEquals(promotionMessagePlacementType, promotionMessagePlacementType2);
    int expectedHashCodeResult = promotionMessagePlacementType.hashCode();
    assertEquals(expectedHashCodeResult, promotionMessagePlacementType2.hashCode());
  }

  /**
   * Test {@link PromotionMessagePlacementType#equals(Object)}, and
   * {@link PromotionMessagePlacementType#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link PromotionMessagePlacementType#equals(Object)}
   *   <li>{@link PromotionMessagePlacementType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    PromotionMessagePlacementType promotionMessagePlacementType = new PromotionMessagePlacementType();
    PromotionMessagePlacementType promotionMessagePlacementType2 = new PromotionMessagePlacementType();

    // Act and Assert
    assertEquals(promotionMessagePlacementType, promotionMessagePlacementType2);
    int expectedHashCodeResult = promotionMessagePlacementType.hashCode();
    assertEquals(expectedHashCodeResult, promotionMessagePlacementType2.hashCode());
  }

  /**
   * Test {@link PromotionMessagePlacementType#equals(Object)}, and
   * {@link PromotionMessagePlacementType#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link PromotionMessagePlacementType#equals(Object)}
   *   <li>{@link PromotionMessagePlacementType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    PromotionMessagePlacementType promotionMessagePlacementType = PromotionMessagePlacementType.BROWSE;

    // Act and Assert
    assertEquals(promotionMessagePlacementType, promotionMessagePlacementType);
    int expectedHashCodeResult = promotionMessagePlacementType.hashCode();
    assertEquals(expectedHashCodeResult, promotionMessagePlacementType.hashCode());
  }

  /**
   * Test {@link PromotionMessagePlacementType#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link PromotionMessagePlacementType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(PromotionMessagePlacementType.CART, PromotionMessagePlacementType.BROWSE);
    assertNotEquals(new PromotionMessagePlacementType(), PromotionMessagePlacementType.BROWSE);
  }

  /**
   * Test {@link PromotionMessagePlacementType#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link PromotionMessagePlacementType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(PromotionMessagePlacementType.BROWSE, null);
  }

  /**
   * Test {@link PromotionMessagePlacementType#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link PromotionMessagePlacementType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(PromotionMessagePlacementType.BROWSE, "Different type to PromotionMessagePlacementType");
  }

  /**
   * Test
   * {@link PromotionMessagePlacementType#compareTo(PromotionMessagePlacementType)}
   * with {@code PromotionMessagePlacementType}.
   * <ul>
   *   <li>When {@link PromotionMessagePlacementType#BROWSE}.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PromotionMessagePlacementType#compareTo(PromotionMessagePlacementType)}
   */
  @Test
  public void testCompareToWithPromotionMessagePlacementType_whenBrowse_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, PromotionMessagePlacementType.BROWSE.compareTo(PromotionMessagePlacementType.BROWSE));
  }
}
