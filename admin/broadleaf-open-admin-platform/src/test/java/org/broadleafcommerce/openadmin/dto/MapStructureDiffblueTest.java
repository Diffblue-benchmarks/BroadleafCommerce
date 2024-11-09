/*-
 * #%L
 * BroadleafCommerce Open Admin Platform
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
package org.broadleafcommerce.openadmin.dto;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import org.broadleafcommerce.openadmin.dto.visitor.PersistencePerspectiveItemVisitor;
import org.broadleafcommerce.openadmin.dto.visitor.PersistencePerspectiveItemVisitorAdapter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@ContextConfiguration(classes = {MapStructure.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class MapStructureDiffblueTest {
  @Autowired
  private MapStructure mapStructure;

  /**
   * Test {@link MapStructure#MapStructure()}.
   * <p>
   * Method under test: {@link MapStructure#MapStructure()}
   */
  @Test
  public void testNewMapStructure() {
    // Arrange and Act
    MapStructure actualMapStructure = new MapStructure();

    // Assert
    assertNull(actualMapStructure.getKeyClassName());
    assertNull(actualMapStructure.getKeyPropertyFriendlyName());
    assertNull(actualMapStructure.getKeyPropertyName());
    assertNull(actualMapStructure.getManyToField());
    assertNull(actualMapStructure.getMapKeyValueProperty());
    assertNull(actualMapStructure.getMapProperty());
    assertNull(actualMapStructure.getValueClassName());
    assertFalse(actualMapStructure.getDeleteValueEntity());
    assertTrue(actualMapStructure.getMutable());
  }

  /**
   * Test
   * {@link MapStructure#MapStructure(String, String, String, String, String, Boolean, String)}.
   * <ul>
   *   <li>When {@code java.lang.String}.</li>
   *   <li>Then return MapKeyValueProperty is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MapStructure#MapStructure(String, String, String, String, String, Boolean, String)}
   */
  @Test
  public void testNewMapStructure_whenJavaLangString_thenReturnMapKeyValuePropertyIs42() {
    // Arrange and Act
    MapStructure actualMapStructure = new MapStructure("java.lang.String", "Key Property Name",
        "Key Property Friendly Name", "42", "Map Property", true, "42");

    // Assert
    assertEquals("42", actualMapStructure.getMapKeyValueProperty());
    assertEquals("42", actualMapStructure.getValueClassName());
    assertEquals("Key Property Friendly Name", actualMapStructure.getKeyPropertyFriendlyName());
    assertEquals("Key Property Name", actualMapStructure.getKeyPropertyName());
    assertEquals("Map Property", actualMapStructure.getMapProperty());
    assertEquals("java.lang.String", actualMapStructure.getKeyClassName());
    assertNull(actualMapStructure.getManyToField());
    assertTrue(actualMapStructure.getDeleteValueEntity());
    assertTrue(actualMapStructure.getMutable());
  }

  /**
   * Test
   * {@link MapStructure#MapStructure(String, String, String, String, String, Boolean, String)}.
   * <ul>
   *   <li>When {@code Key Class Name}.</li>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MapStructure#MapStructure(String, String, String, String, String, Boolean, String)}
   */
  @Test
  public void testNewMapStructure_whenKeyClassName_thenThrowRuntimeException() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class, () -> new MapStructure("Key Class Name", "Key Property Name",
        "Key Property Friendly Name", "42", "Map Property", true, "42"));

  }

  /**
   * Test {@link MapStructure#setKeyClassName(String)}.
   * <ul>
   *   <li>Then {@link MapStructure} KeyClassName is {@code java.lang.String}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MapStructure#setKeyClassName(String)}
   */
  @Test
  public void testSetKeyClassName_thenMapStructureKeyClassNameIsJavaLangString() {
    // Arrange and Act
    mapStructure.setKeyClassName("java.lang.String");

    // Assert
    assertEquals("java.lang.String", mapStructure.getKeyClassName());
  }

  /**
   * Test {@link MapStructure#setKeyClassName(String)}.
   * <ul>
   *   <li>When {@code Key Class Name}.</li>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MapStructure#setKeyClassName(String)}
   */
  @Test
  public void testSetKeyClassName_whenKeyClassName_thenThrowRuntimeException() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class, () -> mapStructure.setKeyClassName("Key Class Name"));
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link MapStructure#setDeleteValueEntity(Boolean)}
   *   <li>{@link MapStructure#setKeyPropertyFriendlyName(String)}
   *   <li>{@link MapStructure#setKeyPropertyName(String)}
   *   <li>{@link MapStructure#setManyToField(String)}
   *   <li>{@link MapStructure#setMapKeyValueProperty(String)}
   *   <li>{@link MapStructure#setMapProperty(String)}
   *   <li>{@link MapStructure#setMutable(Boolean)}
   *   <li>{@link MapStructure#setValueClassName(String)}
   *   <li>{@link MapStructure#toString()}
   *   <li>{@link MapStructure#getDeleteValueEntity()}
   *   <li>{@link MapStructure#getKeyClassName()}
   *   <li>{@link MapStructure#getKeyPropertyFriendlyName()}
   *   <li>{@link MapStructure#getKeyPropertyName()}
   *   <li>{@link MapStructure#getManyToField()}
   *   <li>{@link MapStructure#getMapKeyValueProperty()}
   *   <li>{@link MapStructure#getMapProperty()}
   *   <li>{@link MapStructure#getMutable()}
   *   <li>{@link MapStructure#getValueClassName()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    MapStructure mapStructure = new MapStructure();

    // Act
    mapStructure.setDeleteValueEntity(true);
    mapStructure.setKeyPropertyFriendlyName("Key Property Friendly Name");
    mapStructure.setKeyPropertyName("Key Property Name");
    mapStructure.setManyToField("Many To Field");
    mapStructure.setMapKeyValueProperty("42");
    mapStructure.setMapProperty("Map Property");
    mapStructure.setMutable(true);
    mapStructure.setValueClassName("42");
    String actualToStringResult = mapStructure.toString();
    Boolean actualDeleteValueEntity = mapStructure.getDeleteValueEntity();
    mapStructure.getKeyClassName();
    String actualKeyPropertyFriendlyName = mapStructure.getKeyPropertyFriendlyName();
    String actualKeyPropertyName = mapStructure.getKeyPropertyName();
    String actualManyToField = mapStructure.getManyToField();
    String actualMapKeyValueProperty = mapStructure.getMapKeyValueProperty();
    String actualMapProperty = mapStructure.getMapProperty();
    Boolean actualMutable = mapStructure.getMutable();

    // Assert that nothing has changed
    assertEquals("42", actualMapKeyValueProperty);
    assertEquals("42", mapStructure.getValueClassName());
    assertEquals("Key Property Friendly Name", actualKeyPropertyFriendlyName);
    assertEquals("Key Property Name", actualKeyPropertyName);
    assertEquals("Many To Field", actualManyToField);
    assertEquals("Map Property", actualMapProperty);
    assertEquals("MapStructure{keyClassName='null', mapKeyValueProperty='42', keyPropertyName='Key Property Name',"
        + " keyPropertyFriendlyName='Key Property Friendly Name', valueClassName='42', mapProperty='Map Property',"
        + " deleteValueEntity=true, manyToField='Many To Field', mutable=true}", actualToStringResult);
    assertTrue(actualDeleteValueEntity);
    assertTrue(actualMutable);
  }

  /**
   * Test {@link MapStructure#accept(PersistencePerspectiveItemVisitor)}.
   * <ul>
   *   <li>Then calls
   * {@link PersistencePerspectiveItemVisitorAdapter#visit(MapStructure)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MapStructure#accept(PersistencePerspectiveItemVisitor)}
   */
  @Test
  public void testAccept_thenCallsVisit() {
    // Arrange
    MapStructure mapStructure = new MapStructure();
    PersistencePerspectiveItemVisitorAdapter visitor = mock(PersistencePerspectiveItemVisitorAdapter.class);
    doNothing().when(visitor).visit(Mockito.<MapStructure>any());

    // Act
    mapStructure.accept(visitor);

    // Assert
    verify(visitor).visit(isA(MapStructure.class));
  }

  /**
   * Test {@link MapStructure#clonePersistencePerspectiveItem()}.
   * <ul>
   *   <li>Given {@link MapStructure#MapStructure()}.</li>
   *   <li>Then return {@link MapStructure}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MapStructure#clonePersistencePerspectiveItem()}
   */
  @Test
  public void testClonePersistencePerspectiveItem_givenMapStructure_thenReturnMapStructure() {
    // Arrange
    MapStructure mapStructure = new MapStructure();

    // Act
    PersistencePerspectiveItem actualClonePersistencePerspectiveItemResult = mapStructure
        .clonePersistencePerspectiveItem();

    // Assert
    assertTrue(actualClonePersistencePerspectiveItemResult instanceof MapStructure);
    assertEquals(mapStructure, actualClonePersistencePerspectiveItemResult);
  }

  /**
   * Test {@link MapStructure#clonePersistencePerspectiveItem()}.
   * <ul>
   *   <li>Then return {@link SimpleValueMapStructure}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MapStructure#clonePersistencePerspectiveItem()}
   */
  @Test
  public void testClonePersistencePerspectiveItem_thenReturnSimpleValueMapStructure() {
    // Arrange
    SimpleValueMapStructure simpleValueMapStructure = new SimpleValueMapStructure();
    simpleValueMapStructure.setKeyClassName("java.lang.String");

    // Act
    PersistencePerspectiveItem actualClonePersistencePerspectiveItemResult = simpleValueMapStructure
        .clonePersistencePerspectiveItem();

    // Assert
    assertTrue(actualClonePersistencePerspectiveItemResult instanceof SimpleValueMapStructure);
    assertEquals(simpleValueMapStructure, actualClonePersistencePerspectiveItemResult);
  }

  /**
   * Test {@link MapStructure#equals(Object)}, and
   * {@link MapStructure#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link MapStructure#equals(Object)}
   *   <li>{@link MapStructure#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    MapStructure mapStructure = new MapStructure();
    MapStructure mapStructure2 = new MapStructure();

    // Act and Assert
    assertEquals(mapStructure, mapStructure2);
    int expectedHashCodeResult = mapStructure.hashCode();
    assertEquals(expectedHashCodeResult, mapStructure2.hashCode());
  }

  /**
   * Test {@link MapStructure#equals(Object)}, and
   * {@link MapStructure#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link MapStructure#equals(Object)}
   *   <li>{@link MapStructure#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    MapStructure mapStructure = new MapStructure();
    mapStructure.setValueClassName("42");

    MapStructure mapStructure2 = new MapStructure();
    mapStructure2.setValueClassName("42");

    // Act and Assert
    assertEquals(mapStructure, mapStructure2);
    int expectedHashCodeResult = mapStructure.hashCode();
    assertEquals(expectedHashCodeResult, mapStructure2.hashCode());
  }

  /**
   * Test {@link MapStructure#equals(Object)}, and
   * {@link MapStructure#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link MapStructure#equals(Object)}
   *   <li>{@link MapStructure#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    MapStructure mapStructure = new MapStructure();
    mapStructure.setMapProperty("Map Property");

    MapStructure mapStructure2 = new MapStructure();
    mapStructure2.setMapProperty("Map Property");

    // Act and Assert
    assertEquals(mapStructure, mapStructure2);
    int expectedHashCodeResult = mapStructure.hashCode();
    assertEquals(expectedHashCodeResult, mapStructure2.hashCode());
  }

  /**
   * Test {@link MapStructure#equals(Object)}, and
   * {@link MapStructure#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link MapStructure#equals(Object)}
   *   <li>{@link MapStructure#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    MapStructure mapStructure = new MapStructure();
    mapStructure.setKeyPropertyName("Key Property Name");

    MapStructure mapStructure2 = new MapStructure();
    mapStructure2.setKeyPropertyName("Key Property Name");

    // Act and Assert
    assertEquals(mapStructure, mapStructure2);
    int expectedHashCodeResult = mapStructure.hashCode();
    assertEquals(expectedHashCodeResult, mapStructure2.hashCode());
  }

  /**
   * Test {@link MapStructure#equals(Object)}, and
   * {@link MapStructure#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link MapStructure#equals(Object)}
   *   <li>{@link MapStructure#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual5() {
    // Arrange
    MapStructure mapStructure = new MapStructure();
    mapStructure.setKeyPropertyFriendlyName("Key Property Friendly Name");

    MapStructure mapStructure2 = new MapStructure();
    mapStructure2.setKeyPropertyFriendlyName("Key Property Friendly Name");

    // Act and Assert
    assertEquals(mapStructure, mapStructure2);
    int expectedHashCodeResult = mapStructure.hashCode();
    assertEquals(expectedHashCodeResult, mapStructure2.hashCode());
  }

  /**
   * Test {@link MapStructure#equals(Object)}, and
   * {@link MapStructure#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link MapStructure#equals(Object)}
   *   <li>{@link MapStructure#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual6() {
    // Arrange
    MapStructure mapStructure = new MapStructure();
    mapStructure.setManyToField("Many To Field");

    MapStructure mapStructure2 = new MapStructure();
    mapStructure2.setManyToField("Many To Field");

    // Act and Assert
    assertEquals(mapStructure, mapStructure2);
    int expectedHashCodeResult = mapStructure.hashCode();
    assertEquals(expectedHashCodeResult, mapStructure2.hashCode());
  }

  /**
   * Test {@link MapStructure#equals(Object)}, and
   * {@link MapStructure#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link MapStructure#equals(Object)}
   *   <li>{@link MapStructure#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual7() {
    // Arrange
    MapStructure mapStructure = new MapStructure();
    mapStructure.setMapKeyValueProperty("42");

    MapStructure mapStructure2 = new MapStructure();
    mapStructure2.setMapKeyValueProperty("42");

    // Act and Assert
    assertEquals(mapStructure, mapStructure2);
    int expectedHashCodeResult = mapStructure.hashCode();
    assertEquals(expectedHashCodeResult, mapStructure2.hashCode());
  }

  /**
   * Test {@link MapStructure#equals(Object)}, and
   * {@link MapStructure#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link MapStructure#equals(Object)}
   *   <li>{@link MapStructure#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    MapStructure mapStructure = new MapStructure();

    // Act and Assert
    assertEquals(mapStructure, mapStructure);
    int expectedHashCodeResult = mapStructure.hashCode();
    assertEquals(expectedHashCodeResult, mapStructure.hashCode());
  }

  /**
   * Test {@link MapStructure#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link MapStructure#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    SimpleValueMapStructure simpleValueMapStructure = new SimpleValueMapStructure();

    // Act and Assert
    assertNotEquals(simpleValueMapStructure, new MapStructure());
  }

  /**
   * Test {@link MapStructure#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link MapStructure#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange, Act and Assert
    assertNotEquals(new MapStructure(), mock(SimpleValueMapStructure.class));
  }

  /**
   * Test {@link MapStructure#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link MapStructure#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    MapStructure mapStructure = new MapStructure();
    mapStructure.setValueClassName("42");

    // Act and Assert
    assertNotEquals(mapStructure, new MapStructure());
  }

  /**
   * Test {@link MapStructure#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link MapStructure#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    MapStructure mapStructure = new MapStructure();
    mapStructure.setMapProperty("Map Property");

    // Act and Assert
    assertNotEquals(mapStructure, new MapStructure());
  }

  /**
   * Test {@link MapStructure#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link MapStructure#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    MapStructure mapStructure = new MapStructure();
    mapStructure.setKeyPropertyName("Key Property Name");

    // Act and Assert
    assertNotEquals(mapStructure, new MapStructure());
  }

  /**
   * Test {@link MapStructure#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link MapStructure#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    MapStructure mapStructure = new MapStructure();
    mapStructure.setKeyPropertyFriendlyName("Key Property Friendly Name");

    // Act and Assert
    assertNotEquals(mapStructure, new MapStructure());
  }

  /**
   * Test {@link MapStructure#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link MapStructure#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    MapStructure mapStructure = new MapStructure();
    mapStructure.setManyToField("Many To Field");

    // Act and Assert
    assertNotEquals(mapStructure, new MapStructure());
  }

  /**
   * Test {@link MapStructure#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link MapStructure#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    MapStructure mapStructure = new MapStructure();
    mapStructure.setMapKeyValueProperty("42");

    // Act and Assert
    assertNotEquals(mapStructure, new MapStructure());
  }

  /**
   * Test {@link MapStructure#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link MapStructure#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    MapStructure mapStructure = new MapStructure();

    MapStructure mapStructure2 = new MapStructure();
    mapStructure2.setValueClassName("42");

    // Act and Assert
    assertNotEquals(mapStructure, mapStructure2);
  }

  /**
   * Test {@link MapStructure#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link MapStructure#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    MapStructure mapStructure = new MapStructure();

    MapStructure mapStructure2 = new MapStructure();
    mapStructure2.setMapProperty("Map Property");

    // Act and Assert
    assertNotEquals(mapStructure, mapStructure2);
  }

  /**
   * Test {@link MapStructure#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link MapStructure#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    MapStructure mapStructure = new MapStructure();

    MapStructure mapStructure2 = new MapStructure();
    mapStructure2.setKeyPropertyName("Key Property Name");

    // Act and Assert
    assertNotEquals(mapStructure, mapStructure2);
  }

  /**
   * Test {@link MapStructure#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link MapStructure#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
    // Arrange
    MapStructure mapStructure = new MapStructure();

    MapStructure mapStructure2 = new MapStructure();
    mapStructure2.setKeyPropertyFriendlyName("Key Property Friendly Name");

    // Act and Assert
    assertNotEquals(mapStructure, mapStructure2);
  }

  /**
   * Test {@link MapStructure#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link MapStructure#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual13() {
    // Arrange
    MapStructure mapStructure = new MapStructure();

    MapStructure mapStructure2 = new MapStructure();
    mapStructure2.setManyToField("Many To Field");

    // Act and Assert
    assertNotEquals(mapStructure, mapStructure2);
  }

  /**
   * Test {@link MapStructure#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link MapStructure#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual14() {
    // Arrange
    MapStructure mapStructure = new MapStructure();

    MapStructure mapStructure2 = new MapStructure();
    mapStructure2.setMapKeyValueProperty("42");

    // Act and Assert
    assertNotEquals(mapStructure, mapStructure2);
  }

  /**
   * Test {@link MapStructure#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link MapStructure#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new MapStructure(), null);
  }

  /**
   * Test {@link MapStructure#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link MapStructure#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new MapStructure(), "Different type to MapStructure");
  }
}
