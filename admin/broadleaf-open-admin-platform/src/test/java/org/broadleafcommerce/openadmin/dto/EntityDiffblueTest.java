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
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {Entity.class})
@RunWith(SpringJUnit4ClassRunner.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class EntityDiffblueTest {
  @Autowired
  private Entity entity;

  /**
   * Test {@link Entity#setType(String[])}.
   * <ul>
   *   <li>When array of {@link String} with {@code Type}.</li>
   *   <li>Then {@link Entity} (default constructor) Type is array of {@link String}
   * with {@code Type}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Entity#setType(String[])}
   */
  @Test
  public void testSetType_whenArrayOfStringWithType_thenEntityTypeIsArrayOfStringWithType() {
    // Arrange
    Entity entity = new Entity();
    String[] type = new String[]{"Type"};

    // Act
    entity.setType(type);

    // Assert
    assertSame(type, entity.getType());
  }

  /**
   * Test {@link Entity#setType(String[])}.
   * <ul>
   *   <li>When empty array of {@link String}.</li>
   *   <li>Then {@link Entity} (default constructor) Type is empty array of
   * {@link String}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Entity#setType(String[])}
   */
  @Test
  public void testSetType_whenEmptyArrayOfString_thenEntityTypeIsEmptyArrayOfString() {
    // Arrange
    Entity entity = new Entity();
    String[] type = new String[]{};

    // Act
    entity.setType(type);

    // Assert
    assertSame(type, entity.getType());
  }

  /**
   * Test {@link Entity#setType(String[])}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link Entity} (default constructor) Type is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Entity#setType(String[])}
   */
  @Test
  public void testSetType_whenNull_thenEntityTypeIsNull() {
    // Arrange
    Entity entity = new Entity();

    // Act
    entity.setType(null);

    // Assert
    assertNull(entity.getType());
  }

  /**
   * Test {@link Entity#getPMap()}.
   * <ul>
   *   <li>Given {@link Entity} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link Entity#getPMap()}
   */
  @Test
  public void testGetPMap_givenEntity() {
    // Arrange, Act and Assert
    assertTrue((new Entity()).getPMap().isEmpty());
  }

  /**
   * Test {@link Entity#getPMap()}.
   * <ul>
   *   <li>Given {@link Entity} (default constructor) DeployDate is
   * {@link Date}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Entity#getPMap()}
   */
  @Test
  public void testGetPMap_givenEntityDeployDateIsDate() {
    // Arrange
    Entity entity = new Entity();
    entity.setDeployDate(mock(java.sql.Date.class));

    // Act and Assert
    assertTrue(entity.getPMap().isEmpty());
  }

  /**
   * Test {@link Entity#setProperties(Property[])}.
   * <ul>
   *   <li>Given {@link Entity} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link Entity#setProperties(Property[])}
   */
  @Test
  public void testSetProperties_givenEntity() {
    // Arrange
    Entity entity = new Entity();
    Property property = new Property();
    Property[] properties = new Property[]{property};

    // Act
    entity.setProperties(properties);

    // Assert
    Map<String, Property> pMap = entity.getPMap();
    assertEquals(1, pMap.size());
    assertSame(property, pMap.get(null));
    assertSame(properties, entity.getProperties());
  }

  /**
   * Test {@link Entity#setProperties(Property[])}.
   * <ul>
   *   <li>Given {@link Entity} (default constructor) DeployDate is
   * {@link Date}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Entity#setProperties(Property[])}
   */
  @Test
  public void testSetProperties_givenEntityDeployDateIsDate() {
    // Arrange
    Entity entity = new Entity();
    entity.setDeployDate(mock(java.sql.Date.class));
    Property property = new Property();
    Property[] properties = new Property[]{property};

    // Act
    entity.setProperties(properties);

    // Assert
    Map<String, Property> pMap = entity.getPMap();
    assertEquals(1, pMap.size());
    assertSame(property, pMap.get(null));
    assertSame(properties, entity.getProperties());
  }

  /**
   * Test {@link Entity#addValidationError(String, String)}.
   * <p>
   * Method under test: {@link Entity#addValidationError(String, String)}
   */
  @Test
  public void testAddValidationError() {
    // Arrange and Act
    entity.addValidationError("Field Name", "An error occurred");

    // Assert
    Map<String, List<String>> propertyValidationErrors = entity.getPropertyValidationErrors();
    assertEquals(1, propertyValidationErrors.size());
    List<String> getResult = propertyValidationErrors.get("Field Name");
    assertEquals(1, getResult.size());
    assertEquals("An error occurred", getResult.get(0));
    assertTrue(entity.isValidationFailure);
  }

  /**
   * Test {@link Entity#addValidationError(String, String)}.
   * <p>
   * Method under test: {@link Entity#addValidationError(String, String)}
   */
  @Test
  public void testAddValidationError2() {
    // Arrange and Act
    entity.addValidationError("Field Name", "Error Or Error Key");

    // Assert
    Map<String, List<String>> propertyValidationErrors = entity.getPropertyValidationErrors();
    assertEquals(1, propertyValidationErrors.size());
    List<String> getResult = propertyValidationErrors.get("Field Name");
    assertEquals(1, getResult.size());
    assertEquals("Error Or Error Key", getResult.get(0));
    assertTrue(entity.isValidationFailure);
  }

  /**
   * Test {@link Entity#isValidationFailure()}.
   * <ul>
   *   <li>Given {@link Entity} (default constructor) addGlobalValidationError
   * {@code An error occurred}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Entity#isValidationFailure()}
   */
  @Test
  public void testIsValidationFailure_givenEntityAddGlobalValidationErrorAnErrorOccurred() {
    // Arrange
    Entity entity = new Entity();
    entity.addGlobalValidationError("An error occurred");

    // Act and Assert
    assertTrue(entity.isValidationFailure());
  }

  /**
   * Test {@link Entity#isValidationFailure()}.
   * <ul>
   *   <li>Given {@link Entity} (default constructor) addValidationError
   * {@code Field Name} and {@code An error occurred}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Entity#isValidationFailure()}
   */
  @Test
  public void testIsValidationFailure_givenEntityAddValidationErrorFieldNameAndAnErrorOccurred() {
    // Arrange
    Entity entity = new Entity();
    entity.addValidationError("Field Name", "An error occurred");

    // Act and Assert
    assertTrue(entity.isValidationFailure());
  }

  /**
   * Test {@link Entity#isValidationFailure()}.
   * <ul>
   *   <li>Given {@link Entity} (default constructor) PropertyValidationErrors is
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Entity#isValidationFailure()}
   */
  @Test
  public void testIsValidationFailure_givenEntityPropertyValidationErrorsIsNull() {
    // Arrange
    Entity entity = new Entity();
    entity.setPropertyValidationErrors(null);
    entity.setGlobalValidationErrors(null);

    // Act and Assert
    assertFalse(entity.isValidationFailure());
  }

  /**
   * Test {@link Entity#isValidationFailure()}.
   * <ul>
   *   <li>Given {@link Entity} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Entity#isValidationFailure()}
   */
  @Test
  public void testIsValidationFailure_givenEntity_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new Entity()).isValidationFailure());
  }

  /**
   * Test {@link Entity#getValidationErrors()}.
   * <ul>
   *   <li>Given {@link Entity} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link Entity#getValidationErrors()}
   */
  @Test
  public void testGetValidationErrors_givenEntity() {
    // Arrange, Act and Assert
    assertTrue((new Entity()).getValidationErrors().isEmpty());
  }

  /**
   * Test {@link Entity#getValidationErrors()}.
   * <ul>
   *   <li>Given {@link Entity} (default constructor) DeployDate is
   * {@link Date}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Entity#getValidationErrors()}
   */
  @Test
  public void testGetValidationErrors_givenEntityDeployDateIsDate() {
    // Arrange
    Entity entity = new Entity();
    entity.setDeployDate(mock(java.sql.Date.class));

    // Act and Assert
    assertTrue(entity.getValidationErrors().isEmpty());
  }

  /**
   * Test {@link Entity#setValidationErrors(Map)}.
   * <ul>
   *   <li>Given {@link BiFunction}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Entity#setValidationErrors(Map)}
   */
  @Test
  public void testSetValidationErrors_givenBiFunction() {
    // Arrange
    Entity entity = new Entity();

    HashMap<String, List<String>> validationErrors = new HashMap<>();
    validationErrors.computeIfPresent("foo", mock(BiFunction.class));
    validationErrors.put("foo", new ArrayList<>());

    // Act
    entity.setValidationErrors(validationErrors);

    // Assert
    assertTrue(entity.isValidationFailure);
    assertSame(validationErrors, entity.getPropertyValidationErrors());
    assertSame(validationErrors, entity.getValidationErrors());
  }

  /**
   * Test {@link Entity#setValidationErrors(Map)}.
   * <ul>
   *   <li>Given {@code foo}.</li>
   *   <li>Then {@link Entity} (default constructor)
   * {@link Entity#isValidationFailure}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Entity#setValidationErrors(Map)}
   */
  @Test
  public void testSetValidationErrors_givenFoo_thenEntityIsValidationFailure() {
    // Arrange
    Entity entity = new Entity();

    HashMap<String, List<String>> validationErrors = new HashMap<>();
    validationErrors.put("foo", new ArrayList<>());

    // Act
    entity.setValidationErrors(validationErrors);

    // Assert
    assertTrue(entity.isValidationFailure);
    assertSame(validationErrors, entity.getPropertyValidationErrors());
    assertSame(validationErrors, entity.getValidationErrors());
  }

  /**
   * Test {@link Entity#setValidationErrors(Map)}.
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.</li>
   *   <li>Then not {@link Entity} (default constructor)
   * {@link Entity#isValidationFailure}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Entity#setValidationErrors(Map)}
   */
  @Test
  public void testSetValidationErrors_whenHashMap_thenNotEntityIsValidationFailure() {
    // Arrange
    Entity entity = new Entity();
    HashMap<String, List<String>> validationErrors = new HashMap<>();

    // Act
    entity.setValidationErrors(validationErrors);

    // Assert
    assertFalse(entity.isValidationFailure);
    assertSame(validationErrors, entity.getPropertyValidationErrors());
    assertSame(validationErrors, entity.getValidationErrors());
  }

  /**
   * Test {@link Entity#setValidationErrors(Map)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link Entity} (default constructor) PropertyValidationErrors is
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Entity#setValidationErrors(Map)}
   */
  @Test
  public void testSetValidationErrors_whenNull_thenEntityPropertyValidationErrorsIsNull() {
    // Arrange
    Entity entity = new Entity();

    // Act
    entity.setValidationErrors(null);

    // Assert
    assertNull(entity.getPropertyValidationErrors());
    assertNull(entity.getValidationErrors());
    assertFalse(entity.isValidationFailure);
  }

  /**
   * Test {@link Entity#setPropertyValidationErrors(Map)}.
   * <ul>
   *   <li>Given {@link BiFunction}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Entity#setPropertyValidationErrors(Map)}
   */
  @Test
  public void testSetPropertyValidationErrors_givenBiFunction() {
    // Arrange
    Entity entity = new Entity();

    HashMap<String, List<String>> validationErrors = new HashMap<>();
    validationErrors.computeIfPresent("foo", mock(BiFunction.class));
    validationErrors.put("foo", new ArrayList<>());

    // Act
    entity.setPropertyValidationErrors(validationErrors);

    // Assert
    assertTrue(entity.isValidationFailure);
    assertSame(validationErrors, entity.getPropertyValidationErrors());
    assertSame(validationErrors, entity.getValidationErrors());
  }

  /**
   * Test {@link Entity#setPropertyValidationErrors(Map)}.
   * <ul>
   *   <li>Given {@code foo}.</li>
   *   <li>Then {@link Entity} (default constructor)
   * {@link Entity#isValidationFailure}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Entity#setPropertyValidationErrors(Map)}
   */
  @Test
  public void testSetPropertyValidationErrors_givenFoo_thenEntityIsValidationFailure() {
    // Arrange
    Entity entity = new Entity();

    HashMap<String, List<String>> validationErrors = new HashMap<>();
    validationErrors.put("foo", new ArrayList<>());

    // Act
    entity.setPropertyValidationErrors(validationErrors);

    // Assert
    assertTrue(entity.isValidationFailure);
    assertSame(validationErrors, entity.getPropertyValidationErrors());
    assertSame(validationErrors, entity.getValidationErrors());
  }

  /**
   * Test {@link Entity#setPropertyValidationErrors(Map)}.
   * <ul>
   *   <li>Then {@link Entity} (default constructor) PropertyValidationErrors is
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Entity#setPropertyValidationErrors(Map)}
   */
  @Test
  public void testSetPropertyValidationErrors_thenEntityPropertyValidationErrorsIsNull() {
    // Arrange
    Entity entity = new Entity();

    // Act
    entity.setPropertyValidationErrors(null);

    // Assert
    assertNull(entity.getPropertyValidationErrors());
    assertNull(entity.getValidationErrors());
    assertFalse(entity.isValidationFailure);
  }

  /**
   * Test {@link Entity#setPropertyValidationErrors(Map)}.
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.</li>
   *   <li>Then not {@link Entity} (default constructor)
   * {@link Entity#isValidationFailure}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Entity#setPropertyValidationErrors(Map)}
   */
  @Test
  public void testSetPropertyValidationErrors_whenHashMap_thenNotEntityIsValidationFailure() {
    // Arrange
    Entity entity = new Entity();
    HashMap<String, List<String>> validationErrors = new HashMap<>();

    // Act
    entity.setPropertyValidationErrors(validationErrors);

    // Assert
    assertFalse(entity.isValidationFailure);
    assertSame(validationErrors, entity.getPropertyValidationErrors());
    assertSame(validationErrors, entity.getValidationErrors());
  }

  /**
   * Test {@link Entity#addGlobalValidationError(String)}.
   * <p>
   * Method under test: {@link Entity#addGlobalValidationError(String)}
   */
  @Test
  public void testAddGlobalValidationError() {
    // Arrange and Act
    entity.addGlobalValidationError("An error occurred");

    // Assert
    List<String> globalValidationErrors = entity.getGlobalValidationErrors();
    assertEquals(1, globalValidationErrors.size());
    assertEquals("An error occurred", globalValidationErrors.get(0));
    assertTrue(entity.isValidationFailure);
  }

  /**
   * Test {@link Entity#addGlobalValidationErrors(List)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Entity#addGlobalValidationErrors(List)}
   */
  @Test
  public void testAddGlobalValidationErrors_given42_whenArrayListAdd42() {
    // Arrange
    ArrayList<String> errorOrErrorKeys = new ArrayList<>();
    errorOrErrorKeys.add("42");
    errorOrErrorKeys.add("foo");

    // Act
    entity.addGlobalValidationErrors(errorOrErrorKeys);

    // Assert
    assertTrue(entity.isValidationFailure);
    assertEquals(errorOrErrorKeys, entity.getGlobalValidationErrors());
  }

  /**
   * Test {@link Entity#addGlobalValidationErrors(List)}.
   * <ul>
   *   <li>Then {@link Entity} GlobalValidationErrors Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Entity#addGlobalValidationErrors(List)}
   */
  @Test
  public void testAddGlobalValidationErrors_thenEntityGlobalValidationErrorsEmpty() {
    // Arrange and Act
    entity.addGlobalValidationErrors(new ArrayList<>());

    // Assert
    assertTrue(entity.getGlobalValidationErrors().isEmpty());
    assertTrue(entity.isValidationFailure);
  }

  /**
   * Test {@link Entity#addGlobalValidationErrors(List)}.
   * <ul>
   *   <li>Then {@link Entity} GlobalValidationErrors is
   * {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Entity#addGlobalValidationErrors(List)}
   */
  @Test
  public void testAddGlobalValidationErrors_thenEntityGlobalValidationErrorsIsArrayList() {
    // Arrange
    ArrayList<String> errorOrErrorKeys = new ArrayList<>();
    errorOrErrorKeys.add("foo");

    // Act
    entity.addGlobalValidationErrors(errorOrErrorKeys);

    // Assert
    assertTrue(entity.isValidationFailure);
    assertEquals(errorOrErrorKeys, entity.getGlobalValidationErrors());
  }

  /**
   * Test {@link Entity#equals(Object)}, and {@link Entity#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link Entity#equals(Object)}
   *   <li>{@link Entity#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Entity entity = new Entity();
    Entity entity2 = new Entity();

    // Act and Assert
    assertEquals(entity, entity2);
    int expectedHashCodeResult = entity.hashCode();
    assertEquals(expectedHashCodeResult, entity2.hashCode());
  }

  /**
   * Test {@link Entity#equals(Object)}, and {@link Entity#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link Entity#equals(Object)}
   *   <li>{@link Entity#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    Entity entity = new Entity();
    entity.setDeployDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    Entity entity2 = new Entity();
    entity2.setDeployDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    // Act and Assert
    assertEquals(entity, entity2);
    int expectedHashCodeResult = entity.hashCode();
    assertEquals(expectedHashCodeResult, entity2.hashCode());
  }

  /**
   * Test {@link Entity#equals(Object)}, and {@link Entity#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link Entity#equals(Object)}
   *   <li>{@link Entity#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Entity entity = new Entity();

    // Act and Assert
    assertEquals(entity, entity);
    int expectedHashCodeResult = entity.hashCode();
    assertEquals(expectedHashCodeResult, entity.hashCode());
  }

  /**
   * Test {@link Entity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Entity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Entity entity = new Entity();
    entity.addValidationError("Field Name", "An error occurred");

    // Act and Assert
    assertNotEquals(entity, new Entity());
  }

  /**
   * Test {@link Entity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Entity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Entity entity = new Entity();
    entity.setDirty(true);
    entity.addValidationError("Field Name", "An error occurred");

    // Act and Assert
    assertNotEquals(entity, new Entity());
  }

  /**
   * Test {@link Entity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Entity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Entity entity = new Entity();
    entity.setType(new String[]{"Type"});

    // Act and Assert
    assertNotEquals(entity, new Entity());
  }

  /**
   * Test {@link Entity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Entity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    Entity entity = new Entity();
    entity.setMultiPartAvailableOnThread(true);

    // Act and Assert
    assertNotEquals(entity, new Entity());
  }

  /**
   * Test {@link Entity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Entity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    Entity entity = new Entity();
    entity.setActive(true);

    // Act and Assert
    assertNotEquals(entity, new Entity());
  }

  /**
   * Test {@link Entity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Entity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    Entity entity = new Entity();
    entity.setDeleted(true);

    // Act and Assert
    assertNotEquals(entity, new Entity());
  }

  /**
   * Test {@link Entity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Entity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    Entity entity = new Entity();
    entity.setInactive(true);

    // Act and Assert
    assertNotEquals(entity, new Entity());
  }

  /**
   * Test {@link Entity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Entity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    Entity entity = new Entity();
    entity.setDeployDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    // Act and Assert
    assertNotEquals(entity, new Entity());
  }

  /**
   * Test {@link Entity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Entity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    Entity entity = new Entity();
    entity.addValidationError("Field Name", "An error occurred");

    Entity entity2 = new Entity();
    entity2.addValidationError(".", "Error Or Error Key");

    // Act and Assert
    assertNotEquals(entity, entity2);
  }

  /**
   * Test {@link Entity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Entity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    Entity entity = new Entity();
    entity.addValidationError("Field Name", "An error occurred");

    Entity entity2 = new Entity();
    entity2.setDeployDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    entity2.addValidationError(".", "Error Or Error Key");

    // Act and Assert
    assertNotEquals(entity, entity2);
  }

  /**
   * Test {@link Entity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Entity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    Entity entity = new Entity();
    entity.setActive(null);

    // Act and Assert
    assertNotEquals(entity, new Entity());
  }

  /**
   * Test {@link Entity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Entity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
    // Arrange
    Entity entity = new Entity();
    entity.setDeleted(null);

    // Act and Assert
    assertNotEquals(entity, new Entity());
  }

  /**
   * Test {@link Entity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Entity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual13() {
    // Arrange
    Entity entity = new Entity();
    entity.setInactive(null);

    // Act and Assert
    assertNotEquals(entity, new Entity());
  }

  /**
   * Test {@link Entity#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Entity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new Entity(), null);
  }

  /**
   * Test {@link Entity#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Entity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new Entity(), "Different type to Entity");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link Entity}
   *   <li>{@link Entity#setActive(Boolean)}
   *   <li>{@link Entity#setDeleted(Boolean)}
   *   <li>{@link Entity#setDeployDate(Date)}
   *   <li>{@link Entity#setDirty(boolean)}
   *   <li>{@link Entity#setGlobalValidationErrors(List)}
   *   <li>{@link Entity#setInactive(Boolean)}
   *   <li>{@link Entity#setIsPreAdd(boolean)}
   *   <li>{@link Entity#setMultiPartAvailableOnThread(boolean)}
   *   <li>{@link Entity#setValidationFailure(boolean)}
   *   <li>{@link Entity#toString()}
   *   <li>{@link Entity#getActive()}
   *   <li>{@link Entity#getDeleted()}
   *   <li>{@link Entity#getDeployDate()}
   *   <li>{@link Entity#getGlobalValidationErrors()}
   *   <li>{@link Entity#getInactive()}
   *   <li>{@link Entity#getProperties()}
   *   <li>{@link Entity#getPropertyValidationErrors()}
   *   <li>{@link Entity#getType()}
   *   <li>{@link Entity#isDirty()}
   *   <li>{@link Entity#isMultiPartAvailableOnThread()}
   *   <li>{@link Entity#isPreAdd()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    Entity actualEntity = new Entity();
    actualEntity.setActive(true);
    actualEntity.setDeleted(true);
    Date deployDate = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    actualEntity.setDeployDate(deployDate);
    actualEntity.setDirty(true);
    ArrayList<String> globalValidationErrors = new ArrayList<>();
    actualEntity.setGlobalValidationErrors(globalValidationErrors);
    actualEntity.setInactive(true);
    actualEntity.setIsPreAdd(true);
    actualEntity.setMultiPartAvailableOnThread(true);
    actualEntity.setValidationFailure(true);
    String actualToStringResult = actualEntity.toString();
    Boolean actualActive = actualEntity.getActive();
    Boolean actualDeleted = actualEntity.getDeleted();
    Date actualDeployDate = actualEntity.getDeployDate();
    List<String> actualGlobalValidationErrors = actualEntity.getGlobalValidationErrors();
    Boolean actualInactive = actualEntity.getInactive();
    actualEntity.getProperties();
    Map<String, List<String>> actualPropertyValidationErrors = actualEntity.getPropertyValidationErrors();
    actualEntity.getType();
    boolean actualIsDirtyResult = actualEntity.isDirty();
    boolean actualIsMultiPartAvailableOnThreadResult = actualEntity.isMultiPartAvailableOnThread();
    boolean actualIsPreAddResult = actualEntity.isPreAdd();

    // Assert that nothing has changed
    assertEquals("Entity{isValidationFailure=true, isDirty=true, properties=null, type=null}", actualToStringResult);
    assertTrue(actualGlobalValidationErrors.isEmpty());
    assertTrue(actualActive);
    assertTrue(actualDeleted);
    assertTrue(actualInactive);
    assertTrue(actualIsDirtyResult);
    assertTrue(actualIsMultiPartAvailableOnThreadResult);
    assertTrue(actualIsPreAddResult);
    assertSame(globalValidationErrors, actualGlobalValidationErrors);
    assertSame(actualEntity.getValidationErrors(), actualPropertyValidationErrors);
    assertSame(deployDate, actualDeployDate);
  }
}
