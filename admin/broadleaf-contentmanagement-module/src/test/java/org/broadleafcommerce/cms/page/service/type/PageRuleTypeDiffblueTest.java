/*-
 * #%L
 * BroadleafCommerce CMS Module
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

@ContextConfiguration(classes = {PageRuleType.class})
@RunWith(SpringJUnit4ClassRunner.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class PageRuleTypeDiffblueTest {
  @Autowired
  private PageRuleType pageRuleType;

  /**
   * Test {@link PageRuleType#getInstance(String)}.
   * <p>
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
   * Test getters and setters.
   * <p>
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
   * Test {@link PageRuleType#PageRuleType(String, String)}.
   * <ul>
   *   <li>When {@code Product}.</li>
   *   <li>Then return Type is {@code Product}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PageRuleType#PageRuleType(String, String)}
   */
  @Test
  public void testNewPageRuleType_whenProduct_thenReturnTypeIsProduct() {
    // Arrange and Act
    PageRuleType actualPageRuleType = new PageRuleType("Product", "Friendly Type");

    // Assert
    assertEquals("Friendly Type", actualPageRuleType.getFriendlyType());
    assertEquals("Product", actualPageRuleType.getType());
  }

  /**
   * Test {@link PageRuleType#PageRuleType(String, String)}.
   * <ul>
   *   <li>When {@code Type}.</li>
   *   <li>Then return {@code Type}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PageRuleType#PageRuleType(String, String)}
   */
  @Test
  public void testNewPageRuleType_whenType_thenReturnType() {
    // Arrange and Act
    PageRuleType actualPageRuleType = new PageRuleType("Type", "Friendly Type");

    // Assert
    assertEquals("Friendly Type", actualPageRuleType.getFriendlyType());
    assertEquals("Type", actualPageRuleType.getType());
  }

  /**
   * Test {@link PageRuleType#setType(String)}.
   * <ul>
   *   <li>When {@code TypeType}.</li>
   *   <li>Then {@link PageRuleType#CUSTOMER} Type is {@code TypeType}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PageRuleType#setType(String)}
   */
  @Test
  public void testSetType_whenTypeType_thenCustomerTypeIsTypeType() {
    // Arrange
    PageRuleType pageRuleType2 = PageRuleType.CUSTOMER;

    // Act
    pageRuleType2.setType("TypeType");

    // Assert
    assertEquals("TypeType", pageRuleType2.getType());
  }

  /**
   * Test {@link PageRuleType#setType(String)}.
   * <ul>
   *   <li>When {@code Type}.</li>
   *   <li>Then {@link PageRuleType#CUSTOMER} Type is {@code Type}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PageRuleType#setType(String)}
   */
  @Test
  public void testSetType_whenType_thenCustomerTypeIsType() {
    // Arrange
    PageRuleType pageRuleType2 = PageRuleType.CUSTOMER;

    // Act
    pageRuleType2.setType("Type");

    // Assert
    assertEquals("Type", pageRuleType2.getType());
  }

  /**
   * Test {@link PageRuleType#equals(Object)}, and
   * {@link PageRuleType#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
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
   * Test {@link PageRuleType#equals(Object)}, and
   * {@link PageRuleType#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
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
   * Test {@link PageRuleType#equals(Object)}, and
   * {@link PageRuleType#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
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
   * Test {@link PageRuleType#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link PageRuleType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(PageRuleType.PRODUCT, PageRuleType.CUSTOMER);
    assertNotEquals(new PageRuleType(), PageRuleType.CUSTOMER);
  }

  /**
   * Test {@link PageRuleType#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link PageRuleType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(PageRuleType.CUSTOMER, null);
  }

  /**
   * Test {@link PageRuleType#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link PageRuleType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(PageRuleType.CUSTOMER, "Different type to PageRuleType");
  }
}
