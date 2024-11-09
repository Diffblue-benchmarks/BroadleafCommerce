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
package org.broadleafcommerce.openadmin.web.form.entity;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.broadleafcommerce.openadmin.dto.Entity;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

public class EntityFormValidatorDiffblueTest {
  /**
   * Test {@link EntityFormValidator#validate(EntityForm, Entity, Errors)} with
   * {@code form}, {@code entity}, {@code errors}.
   * <p>
   * Method under test:
   * {@link EntityFormValidator#validate(EntityForm, Entity, Errors)}
   */
  @Test
  public void testValidateWithFormEntityErrors() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EntityFormValidator entityFormValidator = new EntityFormValidator();
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
    BindingResult bindingResult = errors.getBindingResult();
    assertTrue(bindingResult instanceof BeanPropertyBindingResult);
    ObjectError globalError = errors.getGlobalError();
    assertEquals("Object Name", globalError.getObjectName());
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
    assertNull(globalError.getArguments());
    List<ObjectError> allErrors = errors.getAllErrors();
    assertEquals(1, allErrors.size());
    assertEquals(1, errors.getErrorCount());
    assertEquals(1, errors.getGlobalErrorCount());
    assertEquals(1, bindingResult.getErrorCount());
    assertEquals(1, bindingResult.getGlobalErrorCount());
    assertTrue(errors.hasErrors());
    assertTrue(errors.hasGlobalErrors());
    assertTrue(bindingResult.hasErrors());
    assertTrue(bindingResult.hasGlobalErrors());
    assertEquals(allErrors, errors.getGlobalErrors());
    assertEquals(allErrors, bindingResult.getAllErrors());
    assertEquals(allErrors, bindingResult.getGlobalErrors());
    assertSame(globalError, allErrors.get(0));
    assertSame(globalError, bindingResult.getGlobalError());
    assertArrayEquals(new String[]{"foo.Object Name", "foo"}, globalError.getCodes());
  }

  /**
   * Test {@link EntityFormValidator#validate(EntityForm, Entity, Errors)} with
   * {@code form}, {@code entity}, {@code errors}.
   * <p>
   * Method under test:
   * {@link EntityFormValidator#validate(EntityForm, Entity, Errors)}
   */
  @Test
  public void testValidateWithFormEntityErrors2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EntityFormValidator entityFormValidator = new EntityFormValidator();
    CodeField codeField = mock(CodeField.class);
    when(codeField.getValue()).thenReturn("42");
    EntityForm form = mock(EntityForm.class);
    when(form.findField(Mockito.<String>any())).thenReturn(codeField);

    ArrayList<String> stringList = new ArrayList<>();
    stringList.add("foo");

    HashMap<String, List<String>> stringListMap = new HashMap<>();
    stringListMap.put("foo", stringList);
    Entity entity = mock(Entity.class);
    when(entity.getGlobalValidationErrors()).thenReturn(new ArrayList<>());
    when(entity.getPropertyValidationErrors()).thenReturn(stringListMap);
    when(entity.isValidationFailure()).thenReturn(true);
    BeanPropertyBindingResult errors = new BeanPropertyBindingResult("Target", ".");

    // Act
    entityFormValidator.validate(form, entity, errors);

    // Assert
    verify(entity).getGlobalValidationErrors();
    verify(entity).getPropertyValidationErrors();
    verify(entity).isValidationFailure();
    verify(form, atLeast(1)).findField(eq("foo"));
    verify(codeField).getValue();
    FieldError fieldError = errors.getFieldError();
    assertEquals("42", fieldError.getRejectedValue());
    assertEquals("entityForm", fieldError.getObjectName());
    assertEquals("fields[foo].value", fieldError.getField());
    assertEquals("foo", fieldError.getCode());
    assertEquals("foo", fieldError.getDefaultMessage());
    assertNull(fieldError.getArguments());
    List<ObjectError> allErrors = errors.getAllErrors();
    assertEquals(1, allErrors.size());
    assertEquals(1, errors.getErrorCount());
    assertEquals(1, errors.getFieldErrorCount());
    assertFalse(fieldError.isBindingFailure());
    assertTrue(errors.hasErrors());
    assertTrue(errors.hasFieldErrors());
    assertEquals(allErrors, errors.getFieldErrors());
    assertSame(fieldError, allErrors.get(0));
    assertArrayEquals(new String[]{"foo...foo", "foo.foo", "foo"}, fieldError.getCodes());
  }

  /**
   * Test {@link EntityFormValidator#validate(EntityForm, Entity, Errors)} with
   * {@code form}, {@code entity}, {@code errors}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@code foo} is
   * {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EntityFormValidator#validate(EntityForm, Entity, Errors)}
   */
  @Test
  public void testValidateWithFormEntityErrors_givenHashMapFooIsArrayList_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EntityFormValidator entityFormValidator = new EntityFormValidator();
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
    BindingResult bindingResult = errors.getBindingResult();
    assertTrue(bindingResult instanceof BeanPropertyBindingResult);
    assertEquals("org.springframework.validation.BeanPropertyBindingResult: 0 errors", errors.getLocalizedMessage());
    assertEquals("org.springframework.validation.BeanPropertyBindingResult: 0 errors", errors.getMessage());
    assertNull(bindingResult.getGlobalError());
    assertEquals(0, errors.getErrorCount());
    assertEquals(0, errors.getGlobalErrorCount());
    assertEquals(0, bindingResult.getErrorCount());
    assertEquals(0, bindingResult.getGlobalErrorCount());
    assertFalse(actualValidateResult);
    assertFalse(errors.hasErrors());
    assertFalse(errors.hasGlobalErrors());
    assertFalse(bindingResult.hasErrors());
    assertFalse(bindingResult.hasGlobalErrors());
    assertTrue(errors.getAllErrors().isEmpty());
    assertTrue(errors.getGlobalErrors().isEmpty());
    assertTrue(bindingResult.getAllErrors().isEmpty());
    assertTrue(bindingResult.getGlobalErrors().isEmpty());
  }

  /**
   * Test {@link EntityFormValidator#validate(EntityForm, Entity, Errors)} with
   * {@code form}, {@code entity}, {@code errors}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()}.</li>
   *   <li>When {@link EntityForm} (default constructor).</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EntityFormValidator#validate(EntityForm, Entity, Errors)}
   */
  @Test
  public void testValidateWithFormEntityErrors_givenHashMap_whenEntityForm_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EntityFormValidator entityFormValidator = new EntityFormValidator();
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
    BindingResult bindingResult = errors.getBindingResult();
    assertTrue(bindingResult instanceof BeanPropertyBindingResult);
    assertEquals("org.springframework.validation.BeanPropertyBindingResult: 0 errors", errors.getLocalizedMessage());
    assertEquals("org.springframework.validation.BeanPropertyBindingResult: 0 errors", errors.getMessage());
    assertNull(bindingResult.getGlobalError());
    assertEquals(0, errors.getErrorCount());
    assertEquals(0, errors.getGlobalErrorCount());
    assertEquals(0, bindingResult.getErrorCount());
    assertEquals(0, bindingResult.getGlobalErrorCount());
    assertFalse(errors.hasErrors());
    assertFalse(errors.hasGlobalErrors());
    assertFalse(bindingResult.hasErrors());
    assertFalse(bindingResult.hasGlobalErrors());
    assertTrue(errors.getAllErrors().isEmpty());
    assertTrue(errors.getGlobalErrors().isEmpty());
    assertTrue(bindingResult.getAllErrors().isEmpty());
    assertTrue(bindingResult.getGlobalErrors().isEmpty());
    assertTrue(actualValidateResult);
  }

  /**
   * Test {@link EntityFormValidator#validate(EntityForm, Entity, Errors)} with
   * {@code form}, {@code entity}, {@code errors}.
   * <ul>
   *   <li>When {@link EntityForm}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EntityFormValidator#validate(EntityForm, Entity, Errors)}
   */
  @Test
  public void testValidateWithFormEntityErrors_whenEntityForm_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EntityFormValidator entityFormValidator = new EntityFormValidator();
    EntityForm form = mock(EntityForm.class);
    Entity entity = new Entity();
    BindException errors = new BindException("Target", "Object Name");

    // Act
    boolean actualValidateResult = entityFormValidator.validate(form, entity, errors);

    // Assert
    BindingResult bindingResult = errors.getBindingResult();
    assertTrue(bindingResult instanceof BeanPropertyBindingResult);
    assertEquals("org.springframework.validation.BeanPropertyBindingResult: 0 errors", errors.getLocalizedMessage());
    assertEquals("org.springframework.validation.BeanPropertyBindingResult: 0 errors", errors.getMessage());
    assertNull(bindingResult.getGlobalError());
    assertEquals(0, errors.getErrorCount());
    assertEquals(0, errors.getGlobalErrorCount());
    assertEquals(0, bindingResult.getErrorCount());
    assertEquals(0, bindingResult.getGlobalErrorCount());
    assertFalse(errors.hasErrors());
    assertFalse(errors.hasGlobalErrors());
    assertFalse(bindingResult.hasErrors());
    assertFalse(bindingResult.hasGlobalErrors());
    assertTrue(errors.getAllErrors().isEmpty());
    assertTrue(errors.getGlobalErrors().isEmpty());
    assertTrue(bindingResult.getAllErrors().isEmpty());
    assertTrue(bindingResult.getGlobalErrors().isEmpty());
    assertTrue(actualValidateResult);
  }

  /**
   * Test {@link EntityFormValidator#validate(EntityForm, Entity, Errors)} with
   * {@code form}, {@code entity}, {@code errors}.
   * <ul>
   *   <li>When {@link Entity} (default constructor).</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EntityFormValidator#validate(EntityForm, Entity, Errors)}
   */
  @Test
  public void testValidateWithFormEntityErrors_whenEntity_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EntityFormValidator entityFormValidator = new EntityFormValidator();
    EntityForm form = new EntityForm();
    Entity entity = new Entity();
    BindException errors = new BindException("Target", "Object Name");

    // Act
    boolean actualValidateResult = entityFormValidator.validate(form, entity, errors);

    // Assert
    BindingResult bindingResult = errors.getBindingResult();
    assertTrue(bindingResult instanceof BeanPropertyBindingResult);
    assertEquals("org.springframework.validation.BeanPropertyBindingResult: 0 errors", errors.getLocalizedMessage());
    assertEquals("org.springframework.validation.BeanPropertyBindingResult: 0 errors", errors.getMessage());
    assertNull(bindingResult.getGlobalError());
    assertEquals(0, errors.getErrorCount());
    assertEquals(0, errors.getGlobalErrorCount());
    assertEquals(0, bindingResult.getErrorCount());
    assertEquals(0, bindingResult.getGlobalErrorCount());
    assertFalse(errors.hasErrors());
    assertFalse(errors.hasGlobalErrors());
    assertFalse(bindingResult.hasErrors());
    assertFalse(bindingResult.hasGlobalErrors());
    assertTrue(errors.getAllErrors().isEmpty());
    assertTrue(errors.getGlobalErrors().isEmpty());
    assertTrue(bindingResult.getAllErrors().isEmpty());
    assertTrue(bindingResult.getGlobalErrors().isEmpty());
    assertTrue(actualValidateResult);
  }

  /**
   * Test {@link EntityFormValidator#validate(EntityForm, Map, Errors)} with
   * {@code form}, {@code propertyErrors}, {@code errors}.
   * <ul>
   *   <li>Given {@code foo}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EntityFormValidator#validate(EntityForm, Map, Errors)}
   */
  @Test
  public void testValidateWithFormPropertyErrorsErrors_givenFoo_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EntityFormValidator entityFormValidator = new EntityFormValidator();
    EntityForm form = new EntityForm();

    HashMap<String, List<String>> propertyErrors = new HashMap<>();
    propertyErrors.put("foo", new ArrayList<>());

    // Act and Assert
    assertFalse(entityFormValidator.validate(form, propertyErrors, new BindException("Target", "Object Name")));
  }

  /**
   * Test {@link EntityFormValidator#validate(EntityForm, Map, Errors)} with
   * {@code form}, {@code propertyErrors}, {@code errors}.
   * <ul>
   *   <li>When {@link EntityForm} (default constructor).</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EntityFormValidator#validate(EntityForm, Map, Errors)}
   */
  @Test
  public void testValidateWithFormPropertyErrorsErrors_whenEntityForm_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EntityFormValidator entityFormValidator = new EntityFormValidator();
    EntityForm form = new EntityForm();
    HashMap<String, List<String>> propertyErrors = new HashMap<>();

    // Act and Assert
    assertTrue(entityFormValidator.validate(form, propertyErrors, new BindException("Target", "Object Name")));
  }

  /**
   * Test {@link EntityFormValidator#validate(EntityForm, Map, Errors)} with
   * {@code form}, {@code propertyErrors}, {@code errors}.
   * <ul>
   *   <li>When {@link EntityForm}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EntityFormValidator#validate(EntityForm, Map, Errors)}
   */
  @Test
  public void testValidateWithFormPropertyErrorsErrors_whenEntityForm_thenReturnTrue2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EntityFormValidator entityFormValidator = new EntityFormValidator();
    EntityForm form = mock(EntityForm.class);
    HashMap<String, List<String>> propertyErrors = new HashMap<>();

    // Act and Assert
    assertTrue(entityFormValidator.validate(form, propertyErrors, new BindException("Target", "Object Name")));
  }

  /**
   * Test {@link EntityFormValidator#validate(EntityForm, Map, List, Errors)} with
   * {@code form}, {@code propertyErrors}, {@code globalErrors}, {@code errors}.
   * <p>
   * Method under test:
   * {@link EntityFormValidator#validate(EntityForm, Map, List, Errors)}
   */
  @Test
  public void testValidateWithFormPropertyErrorsGlobalErrorsErrors() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EntityFormValidator entityFormValidator = new EntityFormValidator();
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
    assertArrayEquals(new String[]{"foo.Object Name", "foo"}, globalError.getCodes());
  }

  /**
   * Test {@link EntityFormValidator#validate(EntityForm, Map, List, Errors)} with
   * {@code form}, {@code propertyErrors}, {@code globalErrors}, {@code errors}.
   * <p>
   * Method under test:
   * {@link EntityFormValidator#validate(EntityForm, Map, List, Errors)}
   */
  @Test
  public void testValidateWithFormPropertyErrorsGlobalErrorsErrors2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EntityFormValidator entityFormValidator = new EntityFormValidator();
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
    List<ObjectError> allErrors = errors.getAllErrors();
    assertEquals(2, allErrors.size());
    ObjectError getResult = allErrors.get(1);
    assertEquals("Object Name", getResult.getObjectName());
    assertEquals("foo", getResult.getCode());
    assertEquals("foo", getResult.getDefaultMessage());
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
    assertNull(getResult.getArguments());
    List<ObjectError> globalErrors2 = errors.getGlobalErrors();
    assertEquals(2, globalErrors2.size());
    List<ObjectError> allErrors2 = bindingResult.getAllErrors();
    assertEquals(2, allErrors2.size());
    List<ObjectError> globalErrors3 = bindingResult.getGlobalErrors();
    assertEquals(2, globalErrors3.size());
    assertEquals(2, errors.getErrorCount());
    assertEquals(2, errors.getGlobalErrorCount());
    assertEquals(2, bindingResult.getErrorCount());
    assertEquals(2, bindingResult.getGlobalErrorCount());
    assertSame(getResult, globalErrors2.get(1));
    assertSame(getResult, allErrors2.get(1));
    assertSame(getResult, globalErrors3.get(1));
    assertSame(globalError, globalErrors2.get(0));
    assertSame(globalError, allErrors2.get(0));
    assertSame(globalError, globalErrors3.get(0));
    assertArrayEquals(new String[]{"42.Object Name", "42"}, globalError.getCodes());
    assertArrayEquals(new String[]{"foo.Object Name", "foo"}, getResult.getCodes());
  }

  /**
   * Test {@link EntityFormValidator#validate(EntityForm, Map, List, Errors)} with
   * {@code form}, {@code propertyErrors}, {@code globalErrors}, {@code errors}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EntityFormValidator#validate(EntityForm, Map, List, Errors)}
   */
  @Test
  public void testValidateWithFormPropertyErrorsGlobalErrorsErrors_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EntityFormValidator entityFormValidator = new EntityFormValidator();
    EntityForm form = new EntityForm();

    HashMap<String, List<String>> propertyErrors = new HashMap<>();
    propertyErrors.put("foo", new ArrayList<>());
    ArrayList<String> globalErrors = new ArrayList<>();
    BindException errors = new BindException("Target", "Object Name");

    // Act
    boolean actualValidateResult = entityFormValidator.validate(form, propertyErrors, globalErrors, errors);

    // Assert
    BindingResult bindingResult = errors.getBindingResult();
    assertTrue(bindingResult instanceof BeanPropertyBindingResult);
    assertEquals("org.springframework.validation.BeanPropertyBindingResult: 0 errors", errors.getLocalizedMessage());
    assertEquals("org.springframework.validation.BeanPropertyBindingResult: 0 errors", errors.getMessage());
    assertNull(bindingResult.getGlobalError());
    assertEquals(0, errors.getErrorCount());
    assertEquals(0, errors.getGlobalErrorCount());
    assertEquals(0, bindingResult.getErrorCount());
    assertEquals(0, bindingResult.getGlobalErrorCount());
    assertFalse(actualValidateResult);
    assertFalse(errors.hasErrors());
    assertFalse(errors.hasGlobalErrors());
    assertFalse(bindingResult.hasErrors());
    assertFalse(bindingResult.hasGlobalErrors());
    assertTrue(errors.getAllErrors().isEmpty());
    assertTrue(errors.getGlobalErrors().isEmpty());
    assertTrue(bindingResult.getAllErrors().isEmpty());
    assertTrue(bindingResult.getGlobalErrors().isEmpty());
  }

  /**
   * Test {@link EntityFormValidator#validate(EntityForm, Map, List, Errors)} with
   * {@code form}, {@code propertyErrors}, {@code globalErrors}, {@code errors}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EntityFormValidator#validate(EntityForm, Map, List, Errors)}
   */
  @Test
  public void testValidateWithFormPropertyErrorsGlobalErrorsErrors_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EntityFormValidator entityFormValidator = new EntityFormValidator();
    EntityForm form = new EntityForm();
    HashMap<String, List<String>> propertyErrors = new HashMap<>();
    ArrayList<String> globalErrors = new ArrayList<>();
    BindException errors = new BindException("Target", "Object Name");

    // Act
    boolean actualValidateResult = entityFormValidator.validate(form, propertyErrors, globalErrors, errors);

    // Assert
    BindingResult bindingResult = errors.getBindingResult();
    assertTrue(bindingResult instanceof BeanPropertyBindingResult);
    assertEquals("org.springframework.validation.BeanPropertyBindingResult: 0 errors", errors.getLocalizedMessage());
    assertEquals("org.springframework.validation.BeanPropertyBindingResult: 0 errors", errors.getMessage());
    assertNull(bindingResult.getGlobalError());
    assertEquals(0, errors.getErrorCount());
    assertEquals(0, errors.getGlobalErrorCount());
    assertEquals(0, bindingResult.getErrorCount());
    assertEquals(0, bindingResult.getGlobalErrorCount());
    assertFalse(errors.hasErrors());
    assertFalse(errors.hasGlobalErrors());
    assertFalse(bindingResult.hasErrors());
    assertFalse(bindingResult.hasGlobalErrors());
    assertTrue(errors.getAllErrors().isEmpty());
    assertTrue(errors.getGlobalErrors().isEmpty());
    assertTrue(bindingResult.getAllErrors().isEmpty());
    assertTrue(bindingResult.getGlobalErrors().isEmpty());
    assertTrue(actualValidateResult);
  }

  /**
   * Test {@link EntityFormValidator#validate(EntityForm, Map, List, Errors)} with
   * {@code form}, {@code propertyErrors}, {@code globalErrors}, {@code errors}.
   * <ul>
   *   <li>When {@link EntityForm}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EntityFormValidator#validate(EntityForm, Map, List, Errors)}
   */
  @Test
  public void testValidateWithFormPropertyErrorsGlobalErrorsErrors_whenEntityForm() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EntityFormValidator entityFormValidator = new EntityFormValidator();
    EntityForm form = mock(EntityForm.class);
    HashMap<String, List<String>> propertyErrors = new HashMap<>();
    ArrayList<String> globalErrors = new ArrayList<>();
    BindException errors = new BindException("Target", "Object Name");

    // Act
    boolean actualValidateResult = entityFormValidator.validate(form, propertyErrors, globalErrors, errors);

    // Assert
    BindingResult bindingResult = errors.getBindingResult();
    assertTrue(bindingResult instanceof BeanPropertyBindingResult);
    assertEquals("org.springframework.validation.BeanPropertyBindingResult: 0 errors", errors.getLocalizedMessage());
    assertEquals("org.springframework.validation.BeanPropertyBindingResult: 0 errors", errors.getMessage());
    assertNull(bindingResult.getGlobalError());
    assertEquals(0, errors.getErrorCount());
    assertEquals(0, errors.getGlobalErrorCount());
    assertEquals(0, bindingResult.getErrorCount());
    assertEquals(0, bindingResult.getGlobalErrorCount());
    assertFalse(errors.hasErrors());
    assertFalse(errors.hasGlobalErrors());
    assertFalse(bindingResult.hasErrors());
    assertFalse(bindingResult.hasGlobalErrors());
    assertTrue(errors.getAllErrors().isEmpty());
    assertTrue(errors.getGlobalErrors().isEmpty());
    assertTrue(bindingResult.getAllErrors().isEmpty());
    assertTrue(bindingResult.getGlobalErrors().isEmpty());
    assertTrue(actualValidateResult);
  }
}
