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
package org.broadleafcommerce.common.web.form;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {BroadleafFormType.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class BroadleafFormTypeDiffblueTest {
  @Autowired
  private BroadleafFormType broadleafFormType;

  /**
   * Method under test: {@link BroadleafFormType#getInstance(String)}
   */
  @Test
  public void testGetInstance() {
    // Arrange and Act
    BroadleafFormType actualInstance = BroadleafFormType.getInstance("Type");

    // Assert
    assertEquals("Friendly Type", actualInstance.getFriendlyType());
    assertEquals("Type", actualInstance.getType());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link BroadleafFormType#equals(Object)}
   *   <li>{@link BroadleafFormType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    BroadleafFormType broadleafFormType = BroadleafFormType.BILLING_FORM;
    BroadleafFormType broadleafFormType2 = BroadleafFormType.BILLING_FORM;

    // Act and Assert
    assertEquals(broadleafFormType, broadleafFormType2);
    int expectedHashCodeResult = broadleafFormType.hashCode();
    assertEquals(expectedHashCodeResult, broadleafFormType2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link BroadleafFormType#equals(Object)}
   *   <li>{@link BroadleafFormType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    BroadleafFormType broadleafFormType = new BroadleafFormType();
    BroadleafFormType broadleafFormType2 = new BroadleafFormType();

    // Act and Assert
    assertEquals(broadleafFormType, broadleafFormType2);
    int expectedHashCodeResult = broadleafFormType.hashCode();
    assertEquals(expectedHashCodeResult, broadleafFormType2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link BroadleafFormType#equals(Object)}
   *   <li>{@link BroadleafFormType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    BroadleafFormType broadleafFormType = new BroadleafFormType("BILLING_FORM", "Friendly Type");
    BroadleafFormType broadleafFormType2 = BroadleafFormType.BILLING_FORM;

    // Act and Assert
    assertEquals(broadleafFormType, broadleafFormType2);
    int expectedHashCodeResult = broadleafFormType.hashCode();
    assertEquals(expectedHashCodeResult, broadleafFormType2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link BroadleafFormType#equals(Object)}
   *   <li>{@link BroadleafFormType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    BroadleafFormType broadleafFormType = BroadleafFormType.BILLING_FORM;

    // Act and Assert
    assertEquals(broadleafFormType, broadleafFormType);
    int expectedHashCodeResult = broadleafFormType.hashCode();
    assertEquals(expectedHashCodeResult, broadleafFormType.hashCode());
  }

  /**
   * Method under test: {@link BroadleafFormType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(BroadleafFormType.CUSTOMER_ADDRESS_FORM, BroadleafFormType.BILLING_FORM);
    assertNotEquals(new BroadleafFormType(), BroadleafFormType.BILLING_FORM);
  }

  /**
   * Method under test: {@link BroadleafFormType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(BroadleafFormType.BILLING_FORM, null);
  }

  /**
   * Method under test: {@link BroadleafFormType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(BroadleafFormType.BILLING_FORM, "Different type to BroadleafFormType");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link BroadleafFormType#BroadleafFormType()}
   *   <li>{@link BroadleafFormType#getFriendlyType()}
   *   <li>{@link BroadleafFormType#getType()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    BroadleafFormType actualBroadleafFormType = new BroadleafFormType();
    String actualFriendlyType = actualBroadleafFormType.getFriendlyType();

    // Assert
    assertNull(actualFriendlyType);
    assertNull(actualBroadleafFormType.getType());
  }

  /**
   * Method under test:
   * {@link BroadleafFormType#BroadleafFormType(String, String)}
   */
  @Test
  public void testNewBroadleafFormType() {
    // Arrange and Act
    BroadleafFormType actualBroadleafFormType = new BroadleafFormType("Type", "Friendly Type");

    // Assert
    assertEquals("Friendly Type", actualBroadleafFormType.getFriendlyType());
    assertEquals("Type", actualBroadleafFormType.getType());
  }
}
