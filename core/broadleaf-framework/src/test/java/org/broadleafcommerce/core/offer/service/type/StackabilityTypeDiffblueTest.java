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
package org.broadleafcommerce.core.offer.service.type;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@ContextConfiguration(classes = {StackabilityType.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class StackabilityTypeDiffblueTest {
  @Autowired
  private StackabilityType stackabilityType;

  /**
   * Test {@link StackabilityType#getInstance(String)}.
   * <p>
   * Method under test: {@link StackabilityType#getInstance(String)}
   */
  @Test
  public void testGetInstance() {
    // Arrange and Act
    StackabilityType actualInstance = StackabilityType.getInstance("Type");

    // Assert
    assertEquals("Friendly Type", actualInstance.getFriendlyType());
    assertEquals("Type", actualInstance.getType());
    assertEquals(1, actualInstance.getOrder());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link StackabilityType#StackabilityType()}
   *   <li>{@link StackabilityType#setOrder(int)}
   *   <li>{@link StackabilityType#getFriendlyType()}
   *   <li>{@link StackabilityType#getOrder()}
   *   <li>{@link StackabilityType#getType()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    StackabilityType actualStackabilityType = new StackabilityType();
    actualStackabilityType.setOrder(1);
    actualStackabilityType.getFriendlyType();
    int actualOrder = actualStackabilityType.getOrder();
    actualStackabilityType.getType();

    // Assert that nothing has changed
    assertEquals(1, actualOrder);
  }

  /**
   * Test {@link StackabilityType#StackabilityType(String, String, int)}.
   * <p>
   * Method under test:
   * {@link StackabilityType#StackabilityType(String, String, int)}
   */
  @Test
  public void testNewStackabilityType() {
    // Arrange and Act
    StackabilityType actualStackabilityType = new StackabilityType("Type", "Friendly Type", 1);

    // Assert
    assertEquals("Friendly Type", actualStackabilityType.getFriendlyType());
    assertEquals("Type", actualStackabilityType.getType());
    assertEquals(1, actualStackabilityType.getOrder());
  }

  /**
   * Test {@link StackabilityType#setType(String)}.
   * <ul>
   *   <li>When {@code TypeType}.</li>
   *   <li>Then {@link StackabilityType#NO} Type is {@code TypeType}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StackabilityType#setType(String)}
   */
  @Test
  public void testSetType_whenTypeType_thenNoTypeIsTypeType() {
    // Arrange
    StackabilityType stackabilityType2 = StackabilityType.NO;

    // Act
    stackabilityType2.setType("TypeType");

    // Assert
    assertEquals("TypeType", stackabilityType2.getType());
  }

  /**
   * Test {@link StackabilityType#setType(String)}.
   * <ul>
   *   <li>When {@code Type}.</li>
   *   <li>Then {@link StackabilityType#NO} Type is {@code Type}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StackabilityType#setType(String)}
   */
  @Test
  public void testSetType_whenType_thenNoTypeIsType() {
    // Arrange
    StackabilityType stackabilityType2 = StackabilityType.NO;

    // Act
    stackabilityType2.setType("Type");

    // Assert
    assertEquals("Type", stackabilityType2.getType());
  }

  /**
   * Test {@link StackabilityType#equals(Object)}, and
   * {@link StackabilityType#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link StackabilityType#equals(Object)}
   *   <li>{@link StackabilityType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    StackabilityType stackabilityType = StackabilityType.NO;
    StackabilityType stackabilityType2 = StackabilityType.NO;

    // Act and Assert
    assertEquals(stackabilityType, stackabilityType2);
    int expectedHashCodeResult = stackabilityType.hashCode();
    assertEquals(expectedHashCodeResult, stackabilityType2.hashCode());
  }

  /**
   * Test {@link StackabilityType#equals(Object)}, and
   * {@link StackabilityType#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link StackabilityType#equals(Object)}
   *   <li>{@link StackabilityType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    StackabilityType stackabilityType = new StackabilityType();
    StackabilityType stackabilityType2 = new StackabilityType();

    // Act and Assert
    assertEquals(stackabilityType, stackabilityType2);
    int expectedHashCodeResult = stackabilityType.hashCode();
    assertEquals(expectedHashCodeResult, stackabilityType2.hashCode());
  }

  /**
   * Test {@link StackabilityType#equals(Object)}, and
   * {@link StackabilityType#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link StackabilityType#equals(Object)}
   *   <li>{@link StackabilityType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    StackabilityType stackabilityType = new StackabilityType("NO", "Friendly Type", 1);
    StackabilityType stackabilityType2 = StackabilityType.NO;

    // Act and Assert
    assertEquals(stackabilityType, stackabilityType2);
    int expectedHashCodeResult = stackabilityType.hashCode();
    assertEquals(expectedHashCodeResult, stackabilityType2.hashCode());
  }

  /**
   * Test {@link StackabilityType#equals(Object)}, and
   * {@link StackabilityType#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link StackabilityType#equals(Object)}
   *   <li>{@link StackabilityType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    StackabilityType stackabilityType = StackabilityType.NO;

    // Act and Assert
    assertEquals(stackabilityType, stackabilityType);
    int expectedHashCodeResult = stackabilityType.hashCode();
    assertEquals(expectedHashCodeResult, stackabilityType.hashCode());
  }

  /**
   * Test {@link StackabilityType#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link StackabilityType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(StackabilityType.YES, StackabilityType.NO);
    assertNotEquals(new StackabilityType(), StackabilityType.NO);
  }

  /**
   * Test {@link StackabilityType#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link StackabilityType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(StackabilityType.NO, null);
  }

  /**
   * Test {@link StackabilityType#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link StackabilityType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(StackabilityType.NO, "Different type to StackabilityType");
  }

  /**
   * Test {@link StackabilityType#compareTo(StackabilityType)} with
   * {@code StackabilityType}.
   * <ul>
   *   <li>When {@link StackabilityType#NO}.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link StackabilityType#compareTo(StackabilityType)}
   */
  @Test
  public void testCompareToWithStackabilityType_whenNo_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, StackabilityType.NO.compareTo(StackabilityType.NO));
  }
}
