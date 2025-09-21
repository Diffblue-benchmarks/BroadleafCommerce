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
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {PageRuleType.class})
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@RunWith(SpringJUnit4ClassRunner.class)
public class PageRuleTypeDiffblueTest {
  @Autowired private PageRuleType pageRuleType;

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PageRuleType#PageRuleType()}
   *   <li>{@link PageRuleType#getFriendlyType()}
   *   <li>{@link PageRuleType#getType()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PageRuleType.<init>()",
    "String PageRuleType.getFriendlyType()",
    "String PageRuleType.getType()"
  })
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
   *
   * <p>Method under test: {@link PageRuleType#PageRuleType(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void PageRuleType.<init>(String, String)"})
  public void testNewPageRuleType() {
    // Arrange and Act
    PageRuleType actualPageRuleType = new PageRuleType("Type", "Friendly Type");

    // Assert
    assertEquals("Friendly Type", actualPageRuleType.getFriendlyType());
    assertEquals("Type", actualPageRuleType.getType());
  }

  /**
   * Test {@link PageRuleType#setType(String)}.
   *
   * <ul>
   *   <li>When {@code TypeType}.
   *   <li>Then {@link PageRuleType} Type is {@code TypeType}.
   * </ul>
   *
   * <p>Method under test: {@link PageRuleType#setType(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void PageRuleType.setType(String)"})
  public void testSetType_whenTypeType_thenPageRuleTypeTypeIsTypeType() {
    // Arrange and Act
    pageRuleType.setType("TypeType");

    // Assert
    assertEquals("TypeType", pageRuleType.getType());
  }

  /**
   * Test {@link PageRuleType#setType(String)}.
   *
   * <ul>
   *   <li>When {@code Type}.
   *   <li>Then {@link PageRuleType} Type is {@code Type}.
   * </ul>
   *
   * <p>Method under test: {@link PageRuleType#setType(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void PageRuleType.setType(String)"})
  public void testSetType_whenType_thenPageRuleTypeTypeIsType() {
    // Arrange and Act
    pageRuleType.setType("Type");

    // Assert
    assertEquals("Type", pageRuleType.getType());
  }

  /**
   * Test {@link PageRuleType#equals(Object)}, and {@link PageRuleType#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PageRuleType#equals(Object)}
   *   <li>{@link PageRuleType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PageRuleType.equals(Object)", "int PageRuleType.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    PageRuleType pageRuleType = PageRuleType.CUSTOMER;
    PageRuleType pageRuleType2 = PageRuleType.CUSTOMER;

    // Act and Assert
    assertEquals(pageRuleType, pageRuleType2);
    assertEquals(pageRuleType.hashCode(), pageRuleType2.hashCode());
  }

  /**
   * Test {@link PageRuleType#equals(Object)}, and {@link PageRuleType#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PageRuleType#equals(Object)}
   *   <li>{@link PageRuleType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PageRuleType.equals(Object)", "int PageRuleType.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    PageRuleType pageRuleType = PageRuleType.PRODUCT;
    PageRuleType pageRuleType2 = new PageRuleType("PRODUCT", "PRODUCT");

    // Act and Assert
    assertEquals(pageRuleType, pageRuleType2);
    assertEquals(pageRuleType.hashCode(), pageRuleType2.hashCode());
  }

  /**
   * Test {@link PageRuleType#equals(Object)}, and {@link PageRuleType#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PageRuleType#equals(Object)}
   *   <li>{@link PageRuleType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PageRuleType.equals(Object)", "int PageRuleType.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    PageRuleType pageRuleType = new PageRuleType();
    PageRuleType pageRuleType2 = new PageRuleType();

    // Act and Assert
    assertEquals(pageRuleType, pageRuleType2);
    assertEquals(pageRuleType.hashCode(), pageRuleType2.hashCode());
  }

  /**
   * Test {@link PageRuleType#equals(Object)}, and {@link PageRuleType#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PageRuleType#equals(Object)}
   *   <li>{@link PageRuleType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PageRuleType.equals(Object)", "int PageRuleType.hashCode()"})
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link PageRuleType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PageRuleType.equals(Object)", "int PageRuleType.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(PageRuleType.PRODUCT, PageRuleType.CUSTOMER);
  }

  /**
   * Test {@link PageRuleType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link PageRuleType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PageRuleType.equals(Object)", "int PageRuleType.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange, Act and Assert
    assertNotEquals(new PageRuleType(), PageRuleType.CUSTOMER);
  }

  /**
   * Test {@link PageRuleType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link PageRuleType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PageRuleType.equals(Object)", "int PageRuleType.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(PageRuleType.CUSTOMER, null);
  }

  /**
   * Test {@link PageRuleType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link PageRuleType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PageRuleType.equals(Object)", "int PageRuleType.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(PageRuleType.CUSTOMER, "Different type to PageRuleType");
  }
}
