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
package org.broadleafcommerce.common.breadcrumbs.dto;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {BreadcrumbDTOType.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class BreadcrumbDTOTypeDiffblueTest {
  @Autowired
  private BreadcrumbDTOType breadcrumbDTOType;

  /**
   * Test {@link BreadcrumbDTOType#getInstance(String)}.
   * <p>
   * Method under test: {@link BreadcrumbDTOType#getInstance(String)}
   */
  @Test
  public void testGetInstance() {
    // Arrange and Act
    BreadcrumbDTOType actualInstance = BreadcrumbDTOType.getInstance("Type");

    // Assert
    assertEquals("Friendly Type", actualInstance.getFriendlyType());
    assertEquals("Type", actualInstance.getType());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link BreadcrumbDTOType#BreadcrumbDTOType()}
   *   <li>{@link BreadcrumbDTOType#getFriendlyType()}
   *   <li>{@link BreadcrumbDTOType#getType()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    BreadcrumbDTOType actualBreadcrumbDTOType = new BreadcrumbDTOType();
    String actualFriendlyType = actualBreadcrumbDTOType.getFriendlyType();

    // Assert
    assertNull(actualFriendlyType);
    assertNull(actualBreadcrumbDTOType.getType());
  }

  /**
   * Test {@link BreadcrumbDTOType#BreadcrumbDTOType(String, String)}.
   * <ul>
   *   <li>When {@code Home}.</li>
   *   <li>Then return Type is {@code Home}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BreadcrumbDTOType#BreadcrumbDTOType(String, String)}
   */
  @Test
  public void testNewBreadcrumbDTOType_whenHome_thenReturnTypeIsHome() {
    // Arrange and Act
    BreadcrumbDTOType actualBreadcrumbDTOType = new BreadcrumbDTOType("Home", "Friendly Type");

    // Assert
    assertEquals("Friendly Type", actualBreadcrumbDTOType.getFriendlyType());
    assertEquals("Home", actualBreadcrumbDTOType.getType());
  }

  /**
   * Test {@link BreadcrumbDTOType#BreadcrumbDTOType(String, String)}.
   * <ul>
   *   <li>When {@code Type}.</li>
   *   <li>Then return {@code Type}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BreadcrumbDTOType#BreadcrumbDTOType(String, String)}
   */
  @Test
  public void testNewBreadcrumbDTOType_whenType_thenReturnType() {
    // Arrange and Act
    BreadcrumbDTOType actualBreadcrumbDTOType = new BreadcrumbDTOType("Type", "Friendly Type");

    // Assert
    assertEquals("Friendly Type", actualBreadcrumbDTOType.getFriendlyType());
    assertEquals("Type", actualBreadcrumbDTOType.getType());
  }

  /**
   * Test {@link BreadcrumbDTOType#equals(Object)}, and
   * {@link BreadcrumbDTOType#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link BreadcrumbDTOType#equals(Object)}
   *   <li>{@link BreadcrumbDTOType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    BreadcrumbDTOType breadcrumbDTOType = BreadcrumbDTOType.CATEGORY;
    BreadcrumbDTOType breadcrumbDTOType2 = BreadcrumbDTOType.CATEGORY;

    // Act and Assert
    assertEquals(breadcrumbDTOType, breadcrumbDTOType2);
    int expectedHashCodeResult = breadcrumbDTOType.hashCode();
    assertEquals(expectedHashCodeResult, breadcrumbDTOType2.hashCode());
  }

  /**
   * Test {@link BreadcrumbDTOType#equals(Object)}, and
   * {@link BreadcrumbDTOType#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link BreadcrumbDTOType#equals(Object)}
   *   <li>{@link BreadcrumbDTOType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    BreadcrumbDTOType breadcrumbDTOType = new BreadcrumbDTOType();
    BreadcrumbDTOType breadcrumbDTOType2 = new BreadcrumbDTOType();

    // Act and Assert
    assertEquals(breadcrumbDTOType, breadcrumbDTOType2);
    int expectedHashCodeResult = breadcrumbDTOType.hashCode();
    assertEquals(expectedHashCodeResult, breadcrumbDTOType2.hashCode());
  }

  /**
   * Test {@link BreadcrumbDTOType#equals(Object)}, and
   * {@link BreadcrumbDTOType#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link BreadcrumbDTOType#equals(Object)}
   *   <li>{@link BreadcrumbDTOType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    BreadcrumbDTOType breadcrumbDTOType = new BreadcrumbDTOType("CATEGORY", "Friendly Type");
    BreadcrumbDTOType breadcrumbDTOType2 = BreadcrumbDTOType.CATEGORY;

    // Act and Assert
    assertEquals(breadcrumbDTOType, breadcrumbDTOType2);
    int expectedHashCodeResult = breadcrumbDTOType.hashCode();
    assertEquals(expectedHashCodeResult, breadcrumbDTOType2.hashCode());
  }

  /**
   * Test {@link BreadcrumbDTOType#equals(Object)}, and
   * {@link BreadcrumbDTOType#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link BreadcrumbDTOType#equals(Object)}
   *   <li>{@link BreadcrumbDTOType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    BreadcrumbDTOType breadcrumbDTOType = BreadcrumbDTOType.CATEGORY;

    // Act and Assert
    assertEquals(breadcrumbDTOType, breadcrumbDTOType);
    int expectedHashCodeResult = breadcrumbDTOType.hashCode();
    assertEquals(expectedHashCodeResult, breadcrumbDTOType.hashCode());
  }

  /**
   * Test {@link BreadcrumbDTOType#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link BreadcrumbDTOType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(BreadcrumbDTOType.HOME, BreadcrumbDTOType.CATEGORY);
    assertNotEquals(new BreadcrumbDTOType(), BreadcrumbDTOType.CATEGORY);
  }

  /**
   * Test {@link BreadcrumbDTOType#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link BreadcrumbDTOType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(BreadcrumbDTOType.CATEGORY, null);
  }

  /**
   * Test {@link BreadcrumbDTOType#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link BreadcrumbDTOType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(BreadcrumbDTOType.CATEGORY, "Different type to BreadcrumbDTOType");
  }
}
