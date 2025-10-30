/*-
 * #%L
 * BroadleafCommerce Framework
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
package org.broadleafcommerce.core.rating.service.type;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {RatingType.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class RatingTypeDiffblueTest {
  @Autowired
  private RatingType ratingType;

  /**
   * Test {@link RatingType#getInstance(String)}.
   * <p>
   * Method under test: {@link RatingType#getInstance(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"RatingType RatingType.getInstance(String)"})
  public void testGetInstance() {
    // Arrange and Act
    RatingType actualInstance = RatingType.getInstance("Type");

    // Assert
    assertEquals("Type", actualInstance.getFriendlyType());
    assertEquals("Type", actualInstance.getType());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link RatingType#RatingType()}
   *   <li>{@link RatingType#getFriendlyType()}
   *   <li>{@link RatingType#getType()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void RatingType.<init>()", "String RatingType.getFriendlyType()", "String RatingType.getType()"})
  public void testGettersAndSetters() {
    // Arrange and Act
    RatingType actualRatingType = new RatingType();
    String actualFriendlyType = actualRatingType.getFriendlyType();

    // Assert
    assertNull(actualFriendlyType);
    assertNull(actualRatingType.getType());
  }

  /**
   * Test {@link RatingType#RatingType(String, String)}.
   * <p>
   * Method under test: {@link RatingType#RatingType(String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void RatingType.<init>(String, String)"})
  public void testNewRatingType() {
    // Arrange and Act
    RatingType actualRatingType = new RatingType("Type", "Friendly Type");

    // Assert
    assertEquals("Friendly Type", actualRatingType.getFriendlyType());
    assertEquals("Type", actualRatingType.getType());
  }

  /**
   * Test {@link RatingType#RatingType(String)}.
   * <ul>
   *   <li>When {@code ProductType}.</li>
   *   <li>Then return FriendlyType is {@code ProductType}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RatingType#RatingType(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void RatingType.<init>(String)"})
  public void testNewRatingType_whenProductType_thenReturnFriendlyTypeIsProductType() {
    // Arrange and Act
    RatingType actualRatingType = new RatingType("ProductType");

    // Assert
    assertEquals("ProductType", actualRatingType.getFriendlyType());
    assertEquals("ProductType", actualRatingType.getType());
  }

  /**
   * Test {@link RatingType#RatingType(String)}.
   * <ul>
   *   <li>When {@code Type}.</li>
   *   <li>Then return FriendlyType is {@code Type}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RatingType#RatingType(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void RatingType.<init>(String)"})
  public void testNewRatingType_whenType_thenReturnFriendlyTypeIsType() {
    // Arrange and Act
    RatingType actualRatingType = new RatingType("Type");

    // Assert
    assertEquals("Type", actualRatingType.getFriendlyType());
    assertEquals("Type", actualRatingType.getType());
  }

  /**
   * Test {@link RatingType#equals(Object)}, and {@link RatingType#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link RatingType#equals(Object)}
   *   <li>{@link RatingType#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean RatingType.equals(Object)", "int RatingType.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    RatingType ratingType = RatingType.PRODUCT;
    RatingType ratingType2 = RatingType.PRODUCT;

    // Act and Assert
    assertEquals(ratingType, ratingType2);
    int expectedHashCodeResult = ratingType.hashCode();
    assertEquals(expectedHashCodeResult, ratingType2.hashCode());
  }

  /**
   * Test {@link RatingType#equals(Object)}, and {@link RatingType#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link RatingType#equals(Object)}
   *   <li>{@link RatingType#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean RatingType.equals(Object)", "int RatingType.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    RatingType ratingType = new RatingType("PRODUCT");
    RatingType ratingType2 = RatingType.PRODUCT;

    // Act and Assert
    assertEquals(ratingType, ratingType2);
    int expectedHashCodeResult = ratingType.hashCode();
    assertEquals(expectedHashCodeResult, ratingType2.hashCode());
  }

  /**
   * Test {@link RatingType#equals(Object)}, and {@link RatingType#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link RatingType#equals(Object)}
   *   <li>{@link RatingType#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean RatingType.equals(Object)", "int RatingType.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    RatingType ratingType = new RatingType();
    RatingType ratingType2 = new RatingType();

    // Act and Assert
    assertEquals(ratingType, ratingType2);
    int expectedHashCodeResult = ratingType.hashCode();
    assertEquals(expectedHashCodeResult, ratingType2.hashCode());
  }

  /**
   * Test {@link RatingType#equals(Object)}, and {@link RatingType#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link RatingType#equals(Object)}
   *   <li>{@link RatingType#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean RatingType.equals(Object)", "int RatingType.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    RatingType ratingType = RatingType.PRODUCT;

    // Act and Assert
    assertEquals(ratingType, ratingType);
    int expectedHashCodeResult = ratingType.hashCode();
    assertEquals(expectedHashCodeResult, ratingType.hashCode());
  }

  /**
   * Test {@link RatingType#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RatingType#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean RatingType.equals(Object)", "int RatingType.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new RatingType("Type"), RatingType.PRODUCT);
  }

  /**
   * Test {@link RatingType#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RatingType#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean RatingType.equals(Object)", "int RatingType.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange, Act and Assert
    assertNotEquals(new RatingType(), RatingType.PRODUCT);
  }

  /**
   * Test {@link RatingType#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RatingType#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean RatingType.equals(Object)", "int RatingType.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(RatingType.PRODUCT, null);
  }

  /**
   * Test {@link RatingType#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RatingType#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean RatingType.equals(Object)", "int RatingType.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(RatingType.PRODUCT, "Different type to RatingType");
  }
}
