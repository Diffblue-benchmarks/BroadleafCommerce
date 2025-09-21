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
package org.broadleafcommerce.openadmin.dto;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {SimpleValueMapStructure.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class SimpleValueMapStructureDiffblueTest {
  @Autowired private SimpleValueMapStructure simpleValueMapStructure;

  /**
   * Test {@link SimpleValueMapStructure#SimpleValueMapStructure()}.
   *
   * <p>Method under test: {@link SimpleValueMapStructure#SimpleValueMapStructure()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SimpleValueMapStructure.<init>()"})
  public void testNewSimpleValueMapStructure() {
    // Arrange and Act
    SimpleValueMapStructure actualSimpleValueMapStructure = new SimpleValueMapStructure();

    // Assert
    assertNull(actualSimpleValueMapStructure.getKeyClassName());
    assertNull(actualSimpleValueMapStructure.getKeyPropertyFriendlyName());
    assertNull(actualSimpleValueMapStructure.getKeyPropertyName());
    assertNull(actualSimpleValueMapStructure.getManyToField());
    assertNull(actualSimpleValueMapStructure.getMapKeyValueProperty());
    assertNull(actualSimpleValueMapStructure.getMapProperty());
    assertNull(actualSimpleValueMapStructure.getValueClassName());
    assertNull(actualSimpleValueMapStructure.getValuePropertyFriendlyName());
    assertNull(actualSimpleValueMapStructure.getValuePropertyName());
    assertFalse(actualSimpleValueMapStructure.getDeleteValueEntity());
    assertTrue(actualSimpleValueMapStructure.getMutable());
  }

  /**
   * Test {@link SimpleValueMapStructure#SimpleValueMapStructure(String, String, String, String,
   * String, String, String, String)}.
   *
   * <ul>
   *   <li>Then return MapKeyValueProperty is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link SimpleValueMapStructure#SimpleValueMapStructure(String, String,
   * String, String, String, String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SimpleValueMapStructure.<init>(String, String, String, String, String, String, String, String)"
  })
  public void testNewSimpleValueMapStructure_thenReturnMapKeyValuePropertyIs42() {
    // Arrange and Act
    SimpleValueMapStructure actualSimpleValueMapStructure =
        new SimpleValueMapStructure(
            "java.lang.String",
            "Key Property Name",
            "Key Property Friendly Name",
            "42",
            "42",
            "42",
            "Map Property",
            "42");

    // Assert
    assertEquals("42", actualSimpleValueMapStructure.getMapKeyValueProperty());
    assertEquals("42", actualSimpleValueMapStructure.getValueClassName());
    assertEquals("42", actualSimpleValueMapStructure.getValuePropertyFriendlyName());
    assertEquals("42", actualSimpleValueMapStructure.getValuePropertyName());
    assertEquals(
        "Key Property Friendly Name", actualSimpleValueMapStructure.getKeyPropertyFriendlyName());
    assertEquals("Key Property Name", actualSimpleValueMapStructure.getKeyPropertyName());
    assertEquals("Map Property", actualSimpleValueMapStructure.getMapProperty());
    assertEquals("java.lang.String", actualSimpleValueMapStructure.getKeyClassName());
    assertNull(actualSimpleValueMapStructure.getManyToField());
    assertFalse(actualSimpleValueMapStructure.getDeleteValueEntity());
    assertTrue(actualSimpleValueMapStructure.getMutable());
  }

  /**
   * Test {@link SimpleValueMapStructure#SimpleValueMapStructure(String, String, String, String,
   * String, String, String, String)}.
   *
   * <ul>
   *   <li>When {@code Key Class Name}.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link SimpleValueMapStructure#SimpleValueMapStructure(String, String,
   * String, String, String, String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SimpleValueMapStructure.<init>(String, String, String, String, String, String, String, String)"
  })
  public void testNewSimpleValueMapStructure_whenKeyClassName_thenThrowRuntimeException() {
    // Arrange, Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            new SimpleValueMapStructure(
                "Key Class Name",
                "Key Property Name",
                "Key Property Friendly Name",
                "42",
                "42",
                "42",
                "Map Property",
                "42"));
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SimpleValueMapStructure#setValuePropertyFriendlyName(String)}
   *   <li>{@link SimpleValueMapStructure#setValuePropertyName(String)}
   *   <li>{@link SimpleValueMapStructure#toString()}
   *   <li>{@link SimpleValueMapStructure#getValuePropertyFriendlyName()}
   *   <li>{@link SimpleValueMapStructure#getValuePropertyName()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String SimpleValueMapStructure.getValuePropertyFriendlyName()",
    "String SimpleValueMapStructure.getValuePropertyName()",
    "void SimpleValueMapStructure.setValuePropertyFriendlyName(String)",
    "void SimpleValueMapStructure.setValuePropertyName(String)",
    "String SimpleValueMapStructure.toString()"
  })
  public void testGettersAndSetters() {
    // Arrange
    SimpleValueMapStructure simpleValueMapStructure = new SimpleValueMapStructure();

    // Act
    simpleValueMapStructure.setValuePropertyFriendlyName("42");
    simpleValueMapStructure.setValuePropertyName("42");
    String actualToStringResult = simpleValueMapStructure.toString();
    String actualValuePropertyFriendlyName = simpleValueMapStructure.getValuePropertyFriendlyName();

    // Assert
    assertEquals("42", actualValuePropertyFriendlyName);
    assertEquals("42", simpleValueMapStructure.getValuePropertyName());
    assertEquals(
        "SimpleValueMapStructure{MapStructure{keyClassName='null', mapKeyValueProperty='null', keyPropertyName='null',"
            + " keyPropertyFriendlyName='null', valueClassName='null', mapProperty='null', deleteValueEntity=false,"
            + " manyToField='null', mutable=true}valuePropertyName='42', valuePropertyFriendlyName='42'}",
        actualToStringResult);
  }

  /**
   * Test {@link SimpleValueMapStructure#clonePersistencePerspectiveItem()}.
   *
   * <ul>
   *   <li>Then return {@link SimpleValueMapStructure}.
   * </ul>
   *
   * <p>Method under test: {@link SimpleValueMapStructure#clonePersistencePerspectiveItem()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PersistencePerspectiveItem SimpleValueMapStructure.clonePersistencePerspectiveItem()"
  })
  public void testClonePersistencePerspectiveItem_thenReturnSimpleValueMapStructure() {
    // Arrange
    SimpleValueMapStructure simpleValueMapStructure = new SimpleValueMapStructure();
    simpleValueMapStructure.setKeyClassName("java.lang.String");

    // Act
    PersistencePerspectiveItem actualClonePersistencePerspectiveItemResult =
        simpleValueMapStructure.clonePersistencePerspectiveItem();

    // Assert
    assertTrue(actualClonePersistencePerspectiveItemResult instanceof SimpleValueMapStructure);
    assertEquals(simpleValueMapStructure, actualClonePersistencePerspectiveItemResult);
  }

  /**
   * Test {@link SimpleValueMapStructure#equals(Object)}, and {@link
   * SimpleValueMapStructure#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SimpleValueMapStructure#equals(Object)}
   *   <li>{@link SimpleValueMapStructure#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SimpleValueMapStructure.equals(Object)",
    "int SimpleValueMapStructure.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    SimpleValueMapStructure simpleValueMapStructure = new SimpleValueMapStructure();
    SimpleValueMapStructure simpleValueMapStructure2 = new SimpleValueMapStructure();

    // Act and Assert
    assertEquals(simpleValueMapStructure, simpleValueMapStructure2);
    assertEquals(simpleValueMapStructure.hashCode(), simpleValueMapStructure2.hashCode());
  }

  /**
   * Test {@link SimpleValueMapStructure#equals(Object)}, and {@link
   * SimpleValueMapStructure#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SimpleValueMapStructure#equals(Object)}
   *   <li>{@link SimpleValueMapStructure#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SimpleValueMapStructure.equals(Object)",
    "int SimpleValueMapStructure.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    SimpleValueMapStructure simpleValueMapStructure = new SimpleValueMapStructure();
    simpleValueMapStructure.setValuePropertyName("42");

    SimpleValueMapStructure simpleValueMapStructure2 = new SimpleValueMapStructure();
    simpleValueMapStructure2.setValuePropertyName("42");

    // Act and Assert
    assertEquals(simpleValueMapStructure, simpleValueMapStructure2);
    assertEquals(simpleValueMapStructure.hashCode(), simpleValueMapStructure2.hashCode());
  }

  /**
   * Test {@link SimpleValueMapStructure#equals(Object)}, and {@link
   * SimpleValueMapStructure#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SimpleValueMapStructure#equals(Object)}
   *   <li>{@link SimpleValueMapStructure#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SimpleValueMapStructure.equals(Object)",
    "int SimpleValueMapStructure.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    SimpleValueMapStructure simpleValueMapStructure = new SimpleValueMapStructure();
    simpleValueMapStructure.setValuePropertyFriendlyName("42");

    SimpleValueMapStructure simpleValueMapStructure2 = new SimpleValueMapStructure();
    simpleValueMapStructure2.setValuePropertyFriendlyName("42");

    // Act and Assert
    assertEquals(simpleValueMapStructure, simpleValueMapStructure2);
    assertEquals(simpleValueMapStructure.hashCode(), simpleValueMapStructure2.hashCode());
  }

  /**
   * Test {@link SimpleValueMapStructure#equals(Object)}, and {@link
   * SimpleValueMapStructure#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SimpleValueMapStructure#equals(Object)}
   *   <li>{@link SimpleValueMapStructure#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SimpleValueMapStructure.equals(Object)",
    "int SimpleValueMapStructure.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    SimpleValueMapStructure simpleValueMapStructure = new SimpleValueMapStructure();

    // Act and Assert
    assertEquals(simpleValueMapStructure, simpleValueMapStructure);
    int expectedHashCodeResult = simpleValueMapStructure.hashCode();
    assertEquals(expectedHashCodeResult, simpleValueMapStructure.hashCode());
  }

  /**
   * Test {@link SimpleValueMapStructure#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SimpleValueMapStructure#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SimpleValueMapStructure.equals(Object)",
    "int SimpleValueMapStructure.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new SimpleValueMapStructure(), 1);
  }

  /**
   * Test {@link SimpleValueMapStructure#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SimpleValueMapStructure#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SimpleValueMapStructure.equals(Object)",
    "int SimpleValueMapStructure.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    SimpleValueMapStructure simpleValueMapStructure = new SimpleValueMapStructure();
    simpleValueMapStructure.setValuePropertyName("42");

    // Act and Assert
    assertNotEquals(simpleValueMapStructure, new SimpleValueMapStructure());
  }

  /**
   * Test {@link SimpleValueMapStructure#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SimpleValueMapStructure#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SimpleValueMapStructure.equals(Object)",
    "int SimpleValueMapStructure.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    SimpleValueMapStructure simpleValueMapStructure = new SimpleValueMapStructure();
    simpleValueMapStructure.setValuePropertyFriendlyName("42");

    // Act and Assert
    assertNotEquals(simpleValueMapStructure, new SimpleValueMapStructure());
  }

  /**
   * Test {@link SimpleValueMapStructure#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SimpleValueMapStructure#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SimpleValueMapStructure.equals(Object)",
    "int SimpleValueMapStructure.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    SimpleValueMapStructure simpleValueMapStructure = new SimpleValueMapStructure();
    simpleValueMapStructure.setValueClassName("42");

    // Act and Assert
    assertNotEquals(simpleValueMapStructure, new SimpleValueMapStructure());
  }

  /**
   * Test {@link SimpleValueMapStructure#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SimpleValueMapStructure#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SimpleValueMapStructure.equals(Object)",
    "int SimpleValueMapStructure.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    SimpleValueMapStructure simpleValueMapStructure = new SimpleValueMapStructure();

    SimpleValueMapStructure simpleValueMapStructure2 = new SimpleValueMapStructure();
    simpleValueMapStructure2.setValuePropertyName("42");

    // Act and Assert
    assertNotEquals(simpleValueMapStructure, simpleValueMapStructure2);
  }

  /**
   * Test {@link SimpleValueMapStructure#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SimpleValueMapStructure#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SimpleValueMapStructure.equals(Object)",
    "int SimpleValueMapStructure.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    SimpleValueMapStructure simpleValueMapStructure = new SimpleValueMapStructure();

    SimpleValueMapStructure simpleValueMapStructure2 = new SimpleValueMapStructure();
    simpleValueMapStructure2.setValuePropertyFriendlyName("42");

    // Act and Assert
    assertNotEquals(simpleValueMapStructure, simpleValueMapStructure2);
  }

  /**
   * Test {@link SimpleValueMapStructure#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SimpleValueMapStructure#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SimpleValueMapStructure.equals(Object)",
    "int SimpleValueMapStructure.hashCode()"
  })
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new SimpleValueMapStructure(), null);
  }

  /**
   * Test {@link SimpleValueMapStructure#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SimpleValueMapStructure#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SimpleValueMapStructure.equals(Object)",
    "int SimpleValueMapStructure.hashCode()"
  })
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new SimpleValueMapStructure(), "Different type to SimpleValueMapStructure");
  }
}
