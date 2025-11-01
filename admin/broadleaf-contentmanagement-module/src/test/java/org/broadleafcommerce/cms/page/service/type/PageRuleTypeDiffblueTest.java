/*-
 * #%L
 * BroadleafCommerce CMS Module
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
package org.broadleafcommerce.cms.page.service.type;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@ContextConfiguration(classes = {PageRuleType.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class PageRuleTypeDiffblueTest {
  @Autowired
  private PageRuleType pageRuleType;

  /**
   * Method under test: {@link PageRuleType#getInstance(String)}
   */
  @Test
  public void testGetInstance() {
    // Arrange and Act
    PageRuleType actualInstance = PageRuleType.getInstance("Type");

    // Assert
    assertEquals("Friendly Type", actualInstance.getFriendlyType());
    assertEquals("Type", actualInstance.getType());
  }

  /**
   * Method under test: {@link PageRuleType#setType(String)}
   */
  @Test
  public void testSetType() {
    // Arrange
    PageRuleType pageRuleType2 = PageRuleType.CUSTOMER;

    // Act
    pageRuleType2.setType("Type");

    // Assert
    assertEquals("Type", pageRuleType2.getType());
  }

  /**
   * Method under test: {@link PageRuleType#setType(String)}
   */
  @Test
  public void testSetType2() {
    // Arrange
    PageRuleType pageRuleType2 = PageRuleType.CUSTOMER;

    // Act
    pageRuleType2.setType("TypeType");

    // Assert
    assertEquals("TypeType", pageRuleType2.getType());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link PageRuleType#equals(Object)}
   *   <li>{@link PageRuleType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    PageRuleType pageRuleType = PageRuleType.CUSTOMER;
    PageRuleType pageRuleType2 = PageRuleType.CUSTOMER;

    // Act and Assert
    assertEquals(pageRuleType, pageRuleType2);
    int expectedHashCodeResult = pageRuleType.hashCode();
    assertEquals(expectedHashCodeResult, pageRuleType2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link PageRuleType#equals(Object)}
   *   <li>{@link PageRuleType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    PageRuleType pageRuleType = new PageRuleType();
    PageRuleType pageRuleType2 = new PageRuleType();

    // Act and Assert
    assertEquals(pageRuleType, pageRuleType2);
    int expectedHashCodeResult = pageRuleType.hashCode();
    assertEquals(expectedHashCodeResult, pageRuleType2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link PageRuleType#equals(Object)}
   *   <li>{@link PageRuleType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    PageRuleType pageRuleType = new PageRuleType("CUSTOMER", "Friendly Type");
    PageRuleType pageRuleType2 = PageRuleType.CUSTOMER;

    // Act and Assert
    assertEquals(pageRuleType, pageRuleType2);
    int expectedHashCodeResult = pageRuleType.hashCode();
    assertEquals(expectedHashCodeResult, pageRuleType2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link PageRuleType#equals(Object)}
   *   <li>{@link PageRuleType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    PageRuleType pageRuleType = PageRuleType.CUSTOMER;

    // Act and Assert
    assertEquals(pageRuleType, pageRuleType);
    int expectedHashCodeResult = pageRuleType.hashCode();
    assertEquals(expectedHashCodeResult, pageRuleType.hashCode());
  }

  /**
   * Method under test: {@link PageRuleType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(PageRuleType.PRODUCT, PageRuleType.CUSTOMER);
    assertNotEquals(new PageRuleType(), PageRuleType.CUSTOMER);
  }

  /**
   * Method under test: {@link PageRuleType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(PageRuleType.CUSTOMER, null);
  }

  /**
   * Method under test: {@link PageRuleType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(PageRuleType.CUSTOMER, "Different type to PageRuleType");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link PageRuleType#PageRuleType()}
   *   <li>{@link PageRuleType#getFriendlyType()}
   *   <li>{@link PageRuleType#getType()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    PageRuleType actualPageRuleType = new PageRuleType();
    String actualFriendlyType = actualPageRuleType.getFriendlyType();

    // Assert
    assertNull(actualFriendlyType);
    assertNull(actualPageRuleType.getType());
  }

  /**
   * Method under test: {@link PageRuleType#PageRuleType(String, String)}
   */
  @Test
  public void testNewPageRuleType() {
    // Arrange and Act
    PageRuleType actualPageRuleType = new PageRuleType("Type", "Friendly Type");

    // Assert
    assertEquals("Friendly Type", actualPageRuleType.getFriendlyType());
    assertEquals("Type", actualPageRuleType.getType());
  }

  /**
   * Method under test: {@link PageRuleType#PageRuleType(String, String)}
   */
  @Test
  public void testNewPageRuleType2() {
    // Arrange and Act
    PageRuleType actualPageRuleType = new PageRuleType("Product", "Friendly Type");

    // Assert
    assertEquals("Friendly Type", actualPageRuleType.getFriendlyType());
    assertEquals("Product", actualPageRuleType.getType());
  }
}
