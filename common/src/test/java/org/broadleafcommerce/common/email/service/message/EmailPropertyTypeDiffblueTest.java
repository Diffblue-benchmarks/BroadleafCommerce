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
package org.broadleafcommerce.common.email.service.message;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {EmailPropertyType.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class EmailPropertyTypeDiffblueTest {
  @Autowired
  private EmailPropertyType emailPropertyType;

  /**
   * Test {@link EmailPropertyType#getInstance(String)}.
   * <p>
   * Method under test: {@link EmailPropertyType#getInstance(String)}
   */
  @Test
  public void testGetInstance() {
    // Arrange and Act
    EmailPropertyType actualInstance = EmailPropertyType.getInstance("Type");

    // Assert
    assertEquals("Friendly Type", actualInstance.getFriendlyType());
    assertEquals("Type", actualInstance.getType());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EmailPropertyType#EmailPropertyType()}
   *   <li>{@link EmailPropertyType#getFriendlyType()}
   *   <li>{@link EmailPropertyType#getType()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    EmailPropertyType actualEmailPropertyType = new EmailPropertyType();
    String actualFriendlyType = actualEmailPropertyType.getFriendlyType();

    // Assert
    assertNull(actualFriendlyType);
    assertNull(actualEmailPropertyType.getType());
  }

  /**
   * Test {@link EmailPropertyType#EmailPropertyType(String, String)}.
   * <p>
   * Method under test:
   * {@link EmailPropertyType#EmailPropertyType(String, String)}
   */
  @Test
  public void testNewEmailPropertyType() {
    // Arrange and Act
    EmailPropertyType actualEmailPropertyType = new EmailPropertyType("Type", "Friendly Type");

    // Assert
    assertEquals("Friendly Type", actualEmailPropertyType.getFriendlyType());
    assertEquals("Type", actualEmailPropertyType.getType());
  }

  /**
   * Test {@link EmailPropertyType#equals(Object)}, and
   * {@link EmailPropertyType#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EmailPropertyType#equals(Object)}
   *   <li>{@link EmailPropertyType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    EmailPropertyType emailPropertyType = EmailPropertyType.INFO;
    EmailPropertyType emailPropertyType2 = EmailPropertyType.INFO;

    // Act and Assert
    assertEquals(emailPropertyType, emailPropertyType2);
    int expectedHashCodeResult = emailPropertyType.hashCode();
    assertEquals(expectedHashCodeResult, emailPropertyType2.hashCode());
  }

  /**
   * Test {@link EmailPropertyType#equals(Object)}, and
   * {@link EmailPropertyType#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EmailPropertyType#equals(Object)}
   *   <li>{@link EmailPropertyType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    EmailPropertyType emailPropertyType = new EmailPropertyType();
    EmailPropertyType emailPropertyType2 = new EmailPropertyType();

    // Act and Assert
    assertEquals(emailPropertyType, emailPropertyType2);
    int expectedHashCodeResult = emailPropertyType.hashCode();
    assertEquals(expectedHashCodeResult, emailPropertyType2.hashCode());
  }

  /**
   * Test {@link EmailPropertyType#equals(Object)}, and
   * {@link EmailPropertyType#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EmailPropertyType#equals(Object)}
   *   <li>{@link EmailPropertyType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    EmailPropertyType emailPropertyType = new EmailPropertyType("info", "Friendly Type");
    EmailPropertyType emailPropertyType2 = EmailPropertyType.INFO;

    // Act and Assert
    assertEquals(emailPropertyType, emailPropertyType2);
    int expectedHashCodeResult = emailPropertyType.hashCode();
    assertEquals(expectedHashCodeResult, emailPropertyType2.hashCode());
  }

  /**
   * Test {@link EmailPropertyType#equals(Object)}, and
   * {@link EmailPropertyType#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EmailPropertyType#equals(Object)}
   *   <li>{@link EmailPropertyType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    EmailPropertyType emailPropertyType = EmailPropertyType.INFO;

    // Act and Assert
    assertEquals(emailPropertyType, emailPropertyType);
    int expectedHashCodeResult = emailPropertyType.hashCode();
    assertEquals(expectedHashCodeResult, emailPropertyType.hashCode());
  }

  /**
   * Test {@link EmailPropertyType#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EmailPropertyType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(EmailPropertyType.SERVERINFO, EmailPropertyType.INFO);
    assertNotEquals(new EmailPropertyType(), EmailPropertyType.INFO);
  }

  /**
   * Test {@link EmailPropertyType#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EmailPropertyType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(EmailPropertyType.INFO, null);
  }

  /**
   * Test {@link EmailPropertyType#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EmailPropertyType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(EmailPropertyType.INFO, "Different type to EmailPropertyType");
  }
}
