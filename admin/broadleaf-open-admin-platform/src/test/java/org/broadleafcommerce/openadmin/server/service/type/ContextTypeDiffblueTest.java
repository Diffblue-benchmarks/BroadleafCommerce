/*-
 * #%L
 * BroadleafCommerce Open Admin Platform
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
package org.broadleafcommerce.openadmin.server.service.type;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {ContextType.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class ContextTypeDiffblueTest {
  @Autowired
  private ContextType contextType;

  /**
   * Method under test: {@link ContextType#getInstance(String)}
   */
  @Test
  public void testGetInstance() {
    // Arrange and Act
    ContextType actualInstance = ContextType.getInstance("Type");

    // Assert
    assertEquals("Friendly Type", actualInstance.getFriendlyType());
    assertEquals("Type", actualInstance.getType());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ContextType#equals(Object)}
   *   <li>{@link ContextType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ContextType contextType = ContextType.CATALOG;
    ContextType contextType2 = ContextType.CATALOG;

    // Act and Assert
    assertEquals(contextType, contextType2);
    int expectedHashCodeResult = contextType.hashCode();
    assertEquals(expectedHashCodeResult, contextType2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ContextType#equals(Object)}
   *   <li>{@link ContextType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    ContextType contextType = new ContextType();
    ContextType contextType2 = new ContextType();

    // Act and Assert
    assertEquals(contextType, contextType2);
    int expectedHashCodeResult = contextType.hashCode();
    assertEquals(expectedHashCodeResult, contextType2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ContextType#equals(Object)}
   *   <li>{@link ContextType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    ContextType contextType = new ContextType("CATALOG", "Friendly Type");
    ContextType contextType2 = ContextType.CATALOG;

    // Act and Assert
    assertEquals(contextType, contextType2);
    int expectedHashCodeResult = contextType.hashCode();
    assertEquals(expectedHashCodeResult, contextType2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ContextType#equals(Object)}
   *   <li>{@link ContextType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ContextType contextType = ContextType.CATALOG;

    // Act and Assert
    assertEquals(contextType, contextType);
    int expectedHashCodeResult = contextType.hashCode();
    assertEquals(expectedHashCodeResult, contextType.hashCode());
  }

  /**
   * Method under test: {@link ContextType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ContextType.GLOBAL, ContextType.CATALOG);
    assertNotEquals(new ContextType(), ContextType.CATALOG);
  }

  /**
   * Method under test: {@link ContextType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ContextType.CATALOG, null);
  }

  /**
   * Method under test: {@link ContextType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ContextType.CATALOG, "Different type to ContextType");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ContextType#ContextType()}
   *   <li>{@link ContextType#getFriendlyType()}
   *   <li>{@link ContextType#getType()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    ContextType actualContextType = new ContextType();
    String actualFriendlyType = actualContextType.getFriendlyType();

    // Assert
    assertNull(actualFriendlyType);
    assertNull(actualContextType.getType());
  }

  /**
   * Method under test: {@link ContextType#ContextType(String, String)}
   */
  @Test
  public void testNewContextType() {
    // Arrange and Act
    ContextType actualContextType = new ContextType("Type", "Friendly Type");

    // Assert
    assertEquals("Friendly Type", actualContextType.getFriendlyType());
    assertEquals("Type", actualContextType.getType());
  }

  /**
   * Method under test: {@link ContextType#ContextType(String, String)}
   */
  @Test
  public void testNewContextType2() {
    // Arrange and Act
    ContextType actualContextType = new ContextType("Global", "Friendly Type");

    // Assert
    assertEquals("Friendly Type", actualContextType.getFriendlyType());
    assertEquals("Global", actualContextType.getType());
  }
}
