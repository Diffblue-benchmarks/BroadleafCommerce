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
package org.broadleafcommerce.openadmin.web.form.entity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.broadleafcommerce.openadmin.dto.Entity;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;

@ContextConfiguration(classes = {EntityFormValidator.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class EntityFormValidatorDiffblueTest {
  @Autowired private EntityFormValidator entityFormValidator;

  /**
   * Test {@link EntityFormValidator#validate(EntityForm, Entity, Errors)} with {@code form}, {@code
   * entity}, {@code errors}.
   *
   * <p>Method under test: {@link EntityFormValidator#validate(EntityForm, Entity, Errors)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityFormValidator.validate(EntityForm, Entity, Errors)"})
  public void testValidateWithFormEntityErrors() {
    // Arrange
    EntityForm form = new EntityForm();

    ArrayList<String> stringList = new ArrayList<>();
    stringList.add("foo");

    Entity entity = mock(Entity.class);
    when(entity.getGlobalValidationErrors()).thenReturn(stringList);
    when(entity.getPropertyValidationErrors()).thenReturn(new HashMap<>());
    when(entity.isValidationFailure()).thenReturn(true);
    BindException errors = new BindException("Target", "Object Name");

    // Act
    entityFormValidator.validate(form, entity, errors);

    // Assert
    verify(entity).getGlobalValidationErrors();
    verify(entity).getPropertyValidationErrors();
    verify(entity).isValidationFailure();
    assertEquals(
        "org.springframework.validation.BeanPropertyBindingResult: 1 errors\n"
            + "Error in object 'Object Name': codes [foo.Object Name,foo]; arguments []; default message [foo]",
        errors.getLocalizedMessage());
    assertEquals(
        "org.springframework.validation.BeanPropertyBindingResult: 1 errors\n"
            + "Error in object 'Object Name': codes [foo.Object Name,foo]; arguments []; default message [foo]",
        errors.getMessage());
    List<ObjectError> allErrors = errors.getAllErrors();
    assertEquals(1, allErrors.size());
    assertEquals(1, errors.getErrorCount());
    assertEquals(1, errors.getGlobalErrorCount());
    assertTrue(errors.hasErrors());
    assertTrue(errors.hasGlobalErrors());
    assertEquals(allErrors, errors.getGlobalErrors());
  }

  /**
   * Test {@link EntityFormValidator#validate(EntityForm, Entity, Errors)} with {@code form}, {@code
   * entity}, {@code errors}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link EntityFormValidator#validate(EntityForm, Entity, Errors)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityFormValidator.validate(EntityForm, Entity, Errors)"})
  public void testValidateWithFormEntityErrors_givenArrayList_thenReturnTrue() {
    // Arrange
    EntityForm form = new EntityForm();

    Entity entity = mock(Entity.class);
    when(entity.getGlobalValidationErrors()).thenReturn(new ArrayList<>());
    when(entity.getPropertyValidationErrors()).thenReturn(new HashMap<>());
    when(entity.isValidationFailure()).thenReturn(true);
    BindException errors = new BindException("Target", "Object Name");

    // Act
    boolean actualValidateResult = entityFormValidator.validate(form, entity, errors);

    // Assert
    verify(entity).getGlobalValidationErrors();
    verify(entity).getPropertyValidationErrors();
    verify(entity).isValidationFailure();
    assertEquals(
        "org.springframework.validation.BeanPropertyBindingResult: 0 errors",
        errors.getLocalizedMessage());
    assertEquals(
        "org.springframework.validation.BeanPropertyBindingResult: 0 errors", errors.getMessage());
    assertEquals(0, errors.getErrorCount());
    assertEquals(0, errors.getGlobalErrorCount());
    assertFalse(errors.hasErrors());
    assertFalse(errors.hasGlobalErrors());
    assertTrue(errors.getAllErrors().isEmpty());
    assertTrue(errors.getGlobalErrors().isEmpty());
    assertTrue(actualValidateResult);
  }

  /**
   * Test {@link EntityFormValidator#validate(EntityForm, Entity, Errors)} with {@code form}, {@code
   * entity}, {@code errors}.
   *
   * <ul>
   *   <li>Given {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link EntityFormValidator#validate(EntityForm, Entity, Errors)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityFormValidator.validate(EntityForm, Entity, Errors)"})
  public void testValidateWithFormEntityErrors_givenFalse() {
    // Arrange
    EntityForm form = new EntityForm();

    Entity entity = mock(Entity.class);
    when(entity.isValidationFailure()).thenReturn(false);
    BindException errors = new BindException("Target", "Object Name");

    // Act
    boolean actualValidateResult = entityFormValidator.validate(form, entity, errors);

    // Assert
    verify(entity).isValidationFailure();
    assertEquals(
        "org.springframework.validation.BeanPropertyBindingResult: 0 errors",
        errors.getLocalizedMessage());
    assertEquals(
        "org.springframework.validation.BeanPropertyBindingResult: 0 errors", errors.getMessage());
    assertEquals(0, errors.getErrorCount());
    assertEquals(0, errors.getGlobalErrorCount());
    assertFalse(errors.hasErrors());
    assertFalse(errors.hasGlobalErrors());
    assertTrue(errors.getAllErrors().isEmpty());
    assertTrue(errors.getGlobalErrors().isEmpty());
    assertTrue(actualValidateResult);
  }

  /**
   * Test {@link EntityFormValidator#validate(EntityForm, Entity, Errors)} with {@code form}, {@code
   * entity}, {@code errors}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@code foo} is {@link ArrayList#ArrayList()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link EntityFormValidator#validate(EntityForm, Entity, Errors)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityFormValidator.validate(EntityForm, Entity, Errors)"})
  public void testValidateWithFormEntityErrors_givenHashMapFooIsArrayList_thenReturnFalse() {
    // Arrange
    EntityForm form = new EntityForm();

    HashMap<String, List<String>> stringListMap = new HashMap<>();
    stringListMap.put("foo", new ArrayList<>());

    Entity entity = mock(Entity.class);
    when(entity.getGlobalValidationErrors()).thenReturn(new ArrayList<>());
    when(entity.getPropertyValidationErrors()).thenReturn(stringListMap);
    when(entity.isValidationFailure()).thenReturn(true);
    BindException errors = new BindException("Target", "Object Name");

    // Act
    boolean actualValidateResult = entityFormValidator.validate(form, entity, errors);

    // Assert
    verify(entity).getGlobalValidationErrors();
    verify(entity).getPropertyValidationErrors();
    verify(entity).isValidationFailure();
    assertEquals(
        "org.springframework.validation.BeanPropertyBindingResult: 0 errors",
        errors.getLocalizedMessage());
    assertEquals(
        "org.springframework.validation.BeanPropertyBindingResult: 0 errors", errors.getMessage());
    assertEquals(0, errors.getErrorCount());
    assertEquals(0, errors.getGlobalErrorCount());
    assertFalse(actualValidateResult);
    assertFalse(errors.hasErrors());
    assertFalse(errors.hasGlobalErrors());
    assertTrue(errors.getAllErrors().isEmpty());
    assertTrue(errors.getGlobalErrors().isEmpty());
  }

  /**
   * Test {@link EntityFormValidator#validate(EntityForm, Entity, Errors)} with {@code form}, {@code
   * entity}, {@code errors}.
   *
   * <ul>
   *   <li>When {@link Entity} (default constructor).
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link EntityFormValidator#validate(EntityForm, Entity, Errors)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityFormValidator.validate(EntityForm, Entity, Errors)"})
  public void testValidateWithFormEntityErrors_whenEntity_thenReturnTrue() {
    // Arrange
    EntityForm form = new EntityForm();
    Entity entity = new Entity();
    BindException errors = new BindException("Target", "Object Name");

    // Act
    boolean actualValidateResult = entityFormValidator.validate(form, entity, errors);

    // Assert
    assertEquals(
        "org.springframework.validation.BeanPropertyBindingResult: 0 errors",
        errors.getLocalizedMessage());
    assertEquals(
        "org.springframework.validation.BeanPropertyBindingResult: 0 errors", errors.getMessage());
    assertEquals(0, errors.getErrorCount());
    assertEquals(0, errors.getGlobalErrorCount());
    assertFalse(errors.hasErrors());
    assertFalse(errors.hasGlobalErrors());
    assertTrue(errors.getAllErrors().isEmpty());
    assertTrue(errors.getGlobalErrors().isEmpty());
    assertTrue(actualValidateResult);
  }

  /**
   * Test {@link EntityFormValidator#validate(EntityForm, Map, Errors)} with {@code form}, {@code
   * propertyErrors}, {@code errors}.
   *
   * <ul>
   *   <li>Given {@code foo}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link EntityFormValidator#validate(EntityForm, Map, Errors)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityFormValidator.validate(EntityForm, Map, Errors)"})
  public void testValidateWithFormPropertyErrorsErrors_givenFoo_thenReturnFalse() {
    // Arrange
    EntityForm form = new EntityForm();

    HashMap<String, List<String>> propertyErrors = new HashMap<>();
    propertyErrors.put("foo", new ArrayList<>());

    // Act and Assert
    assertFalse(
        entityFormValidator.validate(
            form, propertyErrors, new BindException("Target", "Object Name")));
  }

  /**
   * Test {@link EntityFormValidator#validate(EntityForm, Map, Errors)} with {@code form}, {@code
   * propertyErrors}, {@code errors}.
   *
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link EntityFormValidator#validate(EntityForm, Map, Errors)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityFormValidator.validate(EntityForm, Map, Errors)"})
  public void testValidateWithFormPropertyErrorsErrors_whenHashMap_thenReturnTrue() {
    // Arrange
    EntityForm form = new EntityForm();
    HashMap<String, List<String>> propertyErrors = new HashMap<>();

    // Act and Assert
    assertTrue(
        entityFormValidator.validate(
            form, propertyErrors, new BindException("Target", "Object Name")));
  }

  /**
   * Test {@link EntityFormValidator#validate(EntityForm, Map, List, Errors)} with {@code form},
   * {@code propertyErrors}, {@code globalErrors}, {@code errors}.
   *
   * <p>Method under test: {@link EntityFormValidator#validate(EntityForm, Map, List, Errors)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityFormValidator.validate(EntityForm, Map, List, Errors)"})
  public void testValidateWithFormPropertyErrorsGlobalErrorsErrors() {
    // Arrange
    EntityForm form = new EntityForm();
    HashMap<String, List<String>> propertyErrors = new HashMap<>();

    ArrayList<String> globalErrors = new ArrayList<>();
    globalErrors.add("foo");
    BindException errors = new BindException("Target", "Object Name");

    // Act
    entityFormValidator.validate(form, propertyErrors, globalErrors, errors);

    // Assert
    BindingResult bindingResult = errors.getBindingResult();
    assertTrue(bindingResult instanceof BeanPropertyBindingResult);
    ObjectError globalError = errors.getGlobalError();
    assertEquals("foo", globalError.getCode());
    assertEquals("foo", globalError.getDefaultMessage());
    assertEquals(
        "org.springframework.validation.BeanPropertyBindingResult: 1 errors\n"
            + "Error in object 'Object Name': codes [foo.Object Name,foo]; arguments []; default message [foo]",
        errors.getLocalizedMessage());
    assertEquals(
        "org.springframework.validation.BeanPropertyBindingResult: 1 errors\n"
            + "Error in object 'Object Name': codes [foo.Object Name,foo]; arguments []; default message [foo]",
        errors.getMessage());
    assertEquals(1, errors.getAllErrors().size());
    assertEquals(1, errors.getErrorCount());
    assertEquals(1, errors.getGlobalErrorCount());
    assertEquals(1, bindingResult.getErrorCount());
    assertEquals(1, bindingResult.getGlobalErrorCount());
  }

  /**
   * Test {@link EntityFormValidator#validate(EntityForm, Map, List, Errors)} with {@code form},
   * {@code propertyErrors}, {@code globalErrors}, {@code errors}.
   *
   * <p>Method under test: {@link EntityFormValidator#validate(EntityForm, Map, List, Errors)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityFormValidator.validate(EntityForm, Map, List, Errors)"})
  public void testValidateWithFormPropertyErrorsGlobalErrorsErrors2() {
    // Arrange
    EntityForm form = new EntityForm();
    HashMap<String, List<String>> propertyErrors = new HashMap<>();

    ArrayList<String> globalErrors = new ArrayList<>();
    globalErrors.add("42");
    globalErrors.add("foo");
    BindException errors = new BindException("Target", "Object Name");

    // Act
    entityFormValidator.validate(form, propertyErrors, globalErrors, errors);

    // Assert
    BindingResult bindingResult = errors.getBindingResult();
    assertTrue(bindingResult instanceof BeanPropertyBindingResult);
    ObjectError globalError = errors.getGlobalError();
    assertEquals("42", globalError.getCode());
    assertEquals("42", globalError.getDefaultMessage());
    assertEquals(
        "org.springframework.validation.BeanPropertyBindingResult: 2 errors\n"
            + "Error in object 'Object Name': codes [42.Object Name,42]; arguments []; default message [42]\n"
            + "Error in object 'Object Name': codes [foo.Object Name,foo]; arguments []; default message [foo]",
        errors.getLocalizedMessage());
    assertEquals(
        "org.springframework.validation.BeanPropertyBindingResult: 2 errors\n"
            + "Error in object 'Object Name': codes [42.Object Name,42]; arguments []; default message [42]\n"
            + "Error in object 'Object Name': codes [foo.Object Name,foo]; arguments []; default message [foo]",
        errors.getMessage());
    assertEquals(2, errors.getAllErrors().size());
    List<ObjectError> globalErrors2 = errors.getGlobalErrors();
    assertEquals(2, globalErrors2.size());
    assertEquals(2, bindingResult.getAllErrors().size());
    assertEquals(2, bindingResult.getGlobalErrors().size());
    assertEquals(2, errors.getErrorCount());
    assertEquals(2, errors.getGlobalErrorCount());
    assertEquals(2, bindingResult.getErrorCount());
    assertEquals(2, bindingResult.getGlobalErrorCount());
    assertSame(globalError, globalErrors2.get(0));
  }

  /**
   * Test {@link EntityFormValidator#validate(EntityForm, Map, List, Errors)} with {@code form},
   * {@code propertyErrors}, {@code globalErrors}, {@code errors}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link EntityFormValidator#validate(EntityForm, Map, List, Errors)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityFormValidator.validate(EntityForm, Map, List, Errors)"})
  public void testValidateWithFormPropertyErrorsGlobalErrorsErrors_givenArrayList() {
    // Arrange
    EntityForm form = new EntityForm();

    HashMap<String, List<String>> propertyErrors = new HashMap<>();
    propertyErrors.put("foo", new ArrayList<>());
    ArrayList<String> globalErrors = new ArrayList<>();
    BindException errors = new BindException("Target", "Object Name");

    // Act
    entityFormValidator.validate(form, propertyErrors, globalErrors, errors);

    // Assert that nothing has changed
    assertEquals(
        "org.springframework.validation.BeanPropertyBindingResult: 0 errors",
        errors.getLocalizedMessage());
    assertEquals(
        "org.springframework.validation.BeanPropertyBindingResult: 0 errors", errors.getMessage());
    assertEquals(0, errors.getErrorCount());
    assertEquals(0, errors.getGlobalErrorCount());
    assertTrue(errors.getAllErrors().isEmpty());
    assertTrue(errors.getGlobalErrors().isEmpty());
  }

  /**
   * Test {@link EntityFormValidator#validate(EntityForm, Map, List, Errors)} with {@code form},
   * {@code propertyErrors}, {@code globalErrors}, {@code errors}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link EntityFormValidator#validate(EntityForm, Map, List, Errors)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityFormValidator.validate(EntityForm, Map, List, Errors)"})
  public void testValidateWithFormPropertyErrorsGlobalErrorsErrors_thenReturnTrue() {
    // Arrange
    EntityForm form = new EntityForm();
    HashMap<String, List<String>> propertyErrors = new HashMap<>();
    ArrayList<String> globalErrors = new ArrayList<>();
    BindException errors = new BindException("Target", "Object Name");

    // Act
    boolean actualValidateResult =
        entityFormValidator.validate(form, propertyErrors, globalErrors, errors);

    // Assert
    assertEquals(
        "org.springframework.validation.BeanPropertyBindingResult: 0 errors",
        errors.getLocalizedMessage());
    assertEquals(
        "org.springframework.validation.BeanPropertyBindingResult: 0 errors", errors.getMessage());
    assertEquals(0, errors.getErrorCount());
    assertEquals(0, errors.getGlobalErrorCount());
    assertTrue(errors.getAllErrors().isEmpty());
    assertTrue(errors.getGlobalErrors().isEmpty());
    assertTrue(actualValidateResult);
  }
}
