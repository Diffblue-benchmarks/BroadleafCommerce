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
package org.broadleafcommerce.cms.field.type;

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
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {FieldType.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class FieldTypeDiffblueTest {
  @Autowired private FieldType fieldType;

  /**
   * Test {@link FieldType#getInstance(String)}.
   *
   * <p>Method under test: {@link FieldType#getInstance(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"FieldType FieldType.getInstance(String)"})
  public void testGetInstance() {
    // Arrange and Act
    FieldType actualInstance = FieldType.getInstance("Type");

    // Assert
    assertEquals("Friendly Type", actualInstance.getFriendlyType());
    assertEquals("Type", actualInstance.getType());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link FieldType#FieldType()}
   *   <li>{@link FieldType#getFriendlyType()}
   *   <li>{@link FieldType#getType()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void FieldType.<init>()",
    "String FieldType.getFriendlyType()",
    "String FieldType.getType()"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    FieldType actualFieldType = new FieldType();
    String actualFriendlyType = actualFieldType.getFriendlyType();

    // Assert
    assertNull(actualFriendlyType);
    assertNull(actualFieldType.getType());
  }

  /**
   * Test {@link FieldType#FieldType(String, String)}.
   *
   * <ul>
   *   <li>When {@code String}.
   *   <li>Then return Type is {@code String}.
   * </ul>
   *
   * <p>Method under test: {@link FieldType#FieldType(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void FieldType.<init>(String, String)"})
  public void testNewFieldType_whenString_thenReturnTypeIsString() {
    // Arrange and Act
    FieldType actualFieldType = new FieldType("String", "Friendly Type");

    // Assert
    assertEquals("Friendly Type", actualFieldType.getFriendlyType());
    assertEquals("String", actualFieldType.getType());
  }

  /**
   * Test {@link FieldType#FieldType(String, String)}.
   *
   * <ul>
   *   <li>When {@code Type}.
   *   <li>Then return {@code Type}.
   * </ul>
   *
   * <p>Method under test: {@link FieldType#FieldType(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void FieldType.<init>(String, String)"})
  public void testNewFieldType_whenType_thenReturnType() {
    // Arrange and Act
    FieldType actualFieldType = new FieldType("Type", "Friendly Type");

    // Assert
    assertEquals("Friendly Type", actualFieldType.getFriendlyType());
    assertEquals("Type", actualFieldType.getType());
  }

  /**
   * Test {@link FieldType#equals(Object)}, and {@link FieldType#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link FieldType#equals(Object)}
   *   <li>{@link FieldType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FieldType.equals(Object)", "int FieldType.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    FieldType fieldType = FieldType.BOOLEAN;
    FieldType fieldType2 = FieldType.BOOLEAN;

    // Act and Assert
    assertEquals(fieldType, fieldType2);
    assertEquals(fieldType.hashCode(), fieldType2.hashCode());
  }

  /**
   * Test {@link FieldType#equals(Object)}, and {@link FieldType#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link FieldType#equals(Object)}
   *   <li>{@link FieldType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FieldType.equals(Object)", "int FieldType.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    FieldType fieldType = FieldType.DATE;
    FieldType fieldType2 = new FieldType("DATE", "DATE");

    // Act and Assert
    assertEquals(fieldType, fieldType2);
    assertEquals(fieldType.hashCode(), fieldType2.hashCode());
  }

  /**
   * Test {@link FieldType#equals(Object)}, and {@link FieldType#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link FieldType#equals(Object)}
   *   <li>{@link FieldType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FieldType.equals(Object)", "int FieldType.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    FieldType fieldType = new FieldType();
    FieldType fieldType2 = new FieldType();

    // Act and Assert
    assertEquals(fieldType, fieldType2);
    assertEquals(fieldType.hashCode(), fieldType2.hashCode());
  }

  /**
   * Test {@link FieldType#equals(Object)}, and {@link FieldType#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link FieldType#equals(Object)}
   *   <li>{@link FieldType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FieldType.equals(Object)", "int FieldType.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    FieldType fieldType = FieldType.BOOLEAN;

    // Act and Assert
    assertEquals(fieldType, fieldType);
    int expectedHashCodeResult = fieldType.hashCode();
    assertEquals(expectedHashCodeResult, fieldType.hashCode());
  }

  /**
   * Test {@link FieldType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link FieldType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FieldType.equals(Object)", "int FieldType.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(FieldType.DATE, FieldType.BOOLEAN);
  }

  /**
   * Test {@link FieldType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link FieldType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FieldType.equals(Object)", "int FieldType.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange, Act and Assert
    assertNotEquals(new FieldType(), FieldType.BOOLEAN);
  }

  /**
   * Test {@link FieldType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link FieldType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FieldType.equals(Object)", "int FieldType.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(FieldType.BOOLEAN, null);
  }

  /**
   * Test {@link FieldType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link FieldType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FieldType.equals(Object)", "int FieldType.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(FieldType.BOOLEAN, "Different type to FieldType");
  }
}
