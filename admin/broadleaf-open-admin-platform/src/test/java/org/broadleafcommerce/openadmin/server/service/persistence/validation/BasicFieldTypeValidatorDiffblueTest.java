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
package org.broadleafcommerce.openadmin.server.service.persistence.validation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.Serializable;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import org.broadleafcommerce.common.persistence.EntityConfiguration;
import org.broadleafcommerce.common.presentation.client.SupportedFieldType;
import org.broadleafcommerce.openadmin.dto.BasicFieldMetadata;
import org.broadleafcommerce.openadmin.dto.Entity;
import org.broadleafcommerce.openadmin.dto.Property;
import org.broadleafcommerce.openadmin.server.service.persistence.PersistenceManagerImpl;
import org.broadleafcommerce.openadmin.server.service.persistence.module.AdornedTargetListPersistenceModule;
import org.broadleafcommerce.openadmin.server.service.persistence.module.DataFormatProvider;
import org.broadleafcommerce.openadmin.server.service.persistence.module.FieldManager;
import org.broadleafcommerce.openadmin.server.service.persistence.module.provider.request.PopulateValueRequest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {BasicFieldTypeValidator.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class BasicFieldTypeValidatorDiffblueTest {
  @Autowired private BasicFieldTypeValidator basicFieldTypeValidator;

  /**
   * Test {@link BasicFieldTypeValidator#validate(PopulateValueRequest, Serializable)}.
   *
   * <p>Method under test: {@link BasicFieldTypeValidator#validate(PopulateValueRequest,
   * Serializable)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PropertyValidationResult BasicFieldTypeValidator.validate(PopulateValueRequest, Serializable)"
  })
  public void testValidate() {
    // Arrange
    BasicFieldTypeValidator basicFieldTypeValidator = new BasicFieldTypeValidator();

    BasicFieldMetadata metadata = new BasicFieldMetadata();
    metadata.setFieldType(SupportedFieldType.DATE);
    FieldManager fieldManager = new FieldManager(new EntityConfiguration(), null);
    Property property = new Property();
    Class<Object> returnType = Object.class;
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    AdornedTargetListPersistenceModule dataFormatProvider =
        new AdornedTargetListPersistenceModule();

    PopulateValueRequest populateValueRequest =
        new PopulateValueRequest(
            true,
            fieldManager,
            property,
            metadata,
            returnType,
            "42",
            persistenceManager,
            dataFormatProvider,
            true,
            new Entity());

    // Act
    PropertyValidationResult actualValidateResult =
        basicFieldTypeValidator.validate(populateValueRequest, new SimpleDateFormat("yyyy/mm/dd"));

    // Assert
    List<String> errorMessages = actualValidateResult.getErrorMessages();
    assertEquals(1, errorMessages.size());
    assertEquals("Field must be a date of the format: yyyy.MM.dd HH:mm:ss", errorMessages.get(0));
    assertEquals(
        "Field must be a date of the format: yyyy.MM.dd HH:mm:ss",
        actualValidateResult.getErrorMessage());
    assertFalse(actualValidateResult.isValid());
    assertTrue(actualValidateResult.isNotValid());
  }

  /**
   * Test {@link BasicFieldTypeValidator#validate(PopulateValueRequest, Serializable)}.
   *
   * <p>Method under test: {@link BasicFieldTypeValidator#validate(PopulateValueRequest,
   * Serializable)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PropertyValidationResult BasicFieldTypeValidator.validate(PopulateValueRequest, Serializable)"
  })
  public void testValidate2() {
    // Arrange
    BasicFieldTypeValidator basicFieldTypeValidator = new BasicFieldTypeValidator();

    BasicFieldMetadata metadata = new BasicFieldMetadata();
    metadata.setFieldType(SupportedFieldType.ID);
    FieldManager fieldManager = new FieldManager(new EntityConfiguration(), null);
    Property property = new Property();
    Class<Object> returnType = Object.class;
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    AdornedTargetListPersistenceModule dataFormatProvider =
        new AdornedTargetListPersistenceModule();

    PopulateValueRequest populateValueRequest =
        new PopulateValueRequest(
            false,
            fieldManager,
            property,
            metadata,
            returnType,
            "42",
            persistenceManager,
            dataFormatProvider,
            true,
            new Entity());

    // Act
    PropertyValidationResult actualValidateResult =
        basicFieldTypeValidator.validate(populateValueRequest, new SimpleDateFormat("yyyy/mm/dd"));

    // Assert
    assertNull(actualValidateResult.getErrorMessage());
    assertFalse(actualValidateResult.isNotValid());
    assertTrue(actualValidateResult.getErrorMessages().isEmpty());
    assertTrue(actualValidateResult.isValid());
  }

  /**
   * Test {@link BasicFieldTypeValidator#validate(PopulateValueRequest, Serializable)}.
   *
   * <ul>
   *   <li>Given {@code DECIMAL}.
   *   <li>Then return ErrorMessages first is {@code Field must be a valid decimal}.
   * </ul>
   *
   * <p>Method under test: {@link BasicFieldTypeValidator#validate(PopulateValueRequest,
   * Serializable)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PropertyValidationResult BasicFieldTypeValidator.validate(PopulateValueRequest, Serializable)"
  })
  public void testValidate_givenDecimal_thenReturnErrorMessagesFirstIsFieldMustBeAValidDecimal() {
    // Arrange
    BasicFieldTypeValidator basicFieldTypeValidator = new BasicFieldTypeValidator();

    BasicFieldMetadata metadata = new BasicFieldMetadata();
    metadata.setFieldType(SupportedFieldType.DECIMAL);

    DataFormatProvider dataFormatProvider = mock(DataFormatProvider.class);
    when(dataFormatProvider.getDecimalFormatter()).thenReturn(new DecimalFormat());
    FieldManager fieldManager = new FieldManager(new EntityConfiguration(), null);
    Property property = new Property();
    Class<Object> returnType = Object.class;
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();

    PopulateValueRequest populateValueRequest =
        new PopulateValueRequest(
            true,
            fieldManager,
            property,
            metadata,
            returnType,
            "Requested Value",
            persistenceManager,
            dataFormatProvider,
            true,
            new Entity());

    // Act
    PropertyValidationResult actualValidateResult =
        basicFieldTypeValidator.validate(populateValueRequest, new SimpleDateFormat("yyyy/mm/dd"));

    // Assert
    verify(dataFormatProvider).getDecimalFormatter();
    List<String> errorMessages = actualValidateResult.getErrorMessages();
    assertEquals(1, errorMessages.size());
    assertEquals("Field must be a valid decimal", errorMessages.get(0));
    assertEquals("Field must be a valid decimal", actualValidateResult.getErrorMessage());
    assertFalse(actualValidateResult.isValid());
    assertTrue(actualValidateResult.isNotValid());
  }

  /**
   * Test {@link BasicFieldTypeValidator#validate(PopulateValueRequest, Serializable)}.
   *
   * <ul>
   *   <li>Given {@code DECIMAL}.
   *   <li>When {@link BasicFieldMetadata} (default constructor) FieldType is {@code DECIMAL}.
   * </ul>
   *
   * <p>Method under test: {@link BasicFieldTypeValidator#validate(PopulateValueRequest,
   * Serializable)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PropertyValidationResult BasicFieldTypeValidator.validate(PopulateValueRequest, Serializable)"
  })
  public void testValidate_givenDecimal_whenBasicFieldMetadataFieldTypeIsDecimal() {
    // Arrange
    BasicFieldTypeValidator basicFieldTypeValidator = new BasicFieldTypeValidator();

    BasicFieldMetadata metadata = new BasicFieldMetadata();
    metadata.setFieldType(SupportedFieldType.DECIMAL);

    DataFormatProvider dataFormatProvider = mock(DataFormatProvider.class);
    when(dataFormatProvider.getDecimalFormatter()).thenReturn(new DecimalFormat());
    FieldManager fieldManager = new FieldManager(new EntityConfiguration(), null);
    Property property = new Property();
    Class<Object> returnType = Object.class;
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();

    PopulateValueRequest populateValueRequest =
        new PopulateValueRequest(
            true,
            fieldManager,
            property,
            metadata,
            returnType,
            "42",
            persistenceManager,
            dataFormatProvider,
            true,
            new Entity());

    // Act
    PropertyValidationResult actualValidateResult =
        basicFieldTypeValidator.validate(populateValueRequest, new SimpleDateFormat("yyyy/mm/dd"));

    // Assert
    verify(dataFormatProvider).getDecimalFormatter();
    assertNull(actualValidateResult.getErrorMessage());
    assertFalse(actualValidateResult.isNotValid());
    assertTrue(actualValidateResult.getErrorMessages().isEmpty());
    assertTrue(actualValidateResult.isValid());
  }

  /**
   * Test {@link BasicFieldTypeValidator#validate(PopulateValueRequest, Serializable)}.
   *
   * <ul>
   *   <li>Given {@code ID}.
   *   <li>When {@link BasicFieldMetadata} (default constructor) FieldType is {@code ID}.
   * </ul>
   *
   * <p>Method under test: {@link BasicFieldTypeValidator#validate(PopulateValueRequest,
   * Serializable)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PropertyValidationResult BasicFieldTypeValidator.validate(PopulateValueRequest, Serializable)"
  })
  public void testValidate_givenId_whenBasicFieldMetadataFieldTypeIsId() {
    // Arrange
    BasicFieldMetadata metadata = new BasicFieldMetadata();
    metadata.setFieldType(SupportedFieldType.ID);
    FieldManager fieldManager = new FieldManager(new EntityConfiguration(), null);
    Property property = new Property();
    Class<Object> returnType = Object.class;
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    AdornedTargetListPersistenceModule dataFormatProvider =
        new AdornedTargetListPersistenceModule();

    PopulateValueRequest populateValueRequest =
        new PopulateValueRequest(
            true,
            fieldManager,
            property,
            metadata,
            returnType,
            "42",
            persistenceManager,
            dataFormatProvider,
            true,
            new Entity());

    // Act
    PropertyValidationResult actualValidateResult =
        basicFieldTypeValidator.validate(populateValueRequest, new SimpleDateFormat("yyyy/mm/dd"));

    // Assert
    assertNull(actualValidateResult.getErrorMessage());
    assertFalse(actualValidateResult.isNotValid());
    assertTrue(actualValidateResult.getErrorMessages().isEmpty());
    assertTrue(actualValidateResult.isValid());
  }

  /**
   * Test {@link BasicFieldTypeValidator#validate(PopulateValueRequest, Serializable)}.
   *
   * <ul>
   *   <li>Given {@code INTEGER}.
   *   <li>Then return ErrorMessages first is {@code Field must be an valid number}.
   * </ul>
   *
   * <p>Method under test: {@link BasicFieldTypeValidator#validate(PopulateValueRequest,
   * Serializable)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PropertyValidationResult BasicFieldTypeValidator.validate(PopulateValueRequest, Serializable)"
  })
  public void testValidate_givenInteger_thenReturnErrorMessagesFirstIsFieldMustBeAnValidNumber() {
    // Arrange
    BasicFieldTypeValidator basicFieldTypeValidator = new BasicFieldTypeValidator();

    BasicFieldMetadata metadata = new BasicFieldMetadata();
    metadata.setFieldType(SupportedFieldType.INTEGER);

    DataFormatProvider dataFormatProvider = mock(DataFormatProvider.class);
    when(dataFormatProvider.getDecimalFormatter()).thenReturn(new DecimalFormat());
    FieldManager fieldManager = new FieldManager(new EntityConfiguration(), null);
    Property property = new Property();
    Class<Object> returnType = Object.class;
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();

    PopulateValueRequest populateValueRequest =
        new PopulateValueRequest(
            true,
            fieldManager,
            property,
            metadata,
            returnType,
            "Requested Value",
            persistenceManager,
            dataFormatProvider,
            true,
            new Entity());

    // Act
    PropertyValidationResult actualValidateResult =
        basicFieldTypeValidator.validate(populateValueRequest, new SimpleDateFormat("yyyy/mm/dd"));

    // Assert
    verify(dataFormatProvider).getDecimalFormatter();
    List<String> errorMessages = actualValidateResult.getErrorMessages();
    assertEquals(1, errorMessages.size());
    assertEquals("Field must be an valid number", errorMessages.get(0));
    assertEquals("Field must be an valid number", actualValidateResult.getErrorMessage());
    assertFalse(actualValidateResult.isValid());
    assertTrue(actualValidateResult.isNotValid());
  }

  /**
   * Test {@link BasicFieldTypeValidator#validate(PopulateValueRequest, Serializable)}.
   *
   * <ul>
   *   <li>Given {@code INTEGER}.
   *   <li>When {@link BasicFieldMetadata} (default constructor) FieldType is {@code INTEGER}.
   * </ul>
   *
   * <p>Method under test: {@link BasicFieldTypeValidator#validate(PopulateValueRequest,
   * Serializable)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PropertyValidationResult BasicFieldTypeValidator.validate(PopulateValueRequest, Serializable)"
  })
  public void testValidate_givenInteger_whenBasicFieldMetadataFieldTypeIsInteger() {
    // Arrange
    BasicFieldTypeValidator basicFieldTypeValidator = new BasicFieldTypeValidator();

    BasicFieldMetadata metadata = new BasicFieldMetadata();
    metadata.setFieldType(SupportedFieldType.INTEGER);

    DataFormatProvider dataFormatProvider = mock(DataFormatProvider.class);
    when(dataFormatProvider.getDecimalFormatter()).thenReturn(new DecimalFormat());
    FieldManager fieldManager = new FieldManager(new EntityConfiguration(), null);
    Property property = new Property();
    Class<Object> returnType = Object.class;
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();

    PopulateValueRequest populateValueRequest =
        new PopulateValueRequest(
            true,
            fieldManager,
            property,
            metadata,
            returnType,
            "42",
            persistenceManager,
            dataFormatProvider,
            true,
            new Entity());

    // Act
    PropertyValidationResult actualValidateResult =
        basicFieldTypeValidator.validate(populateValueRequest, new SimpleDateFormat("yyyy/mm/dd"));

    // Assert
    verify(dataFormatProvider).getDecimalFormatter();
    assertNull(actualValidateResult.getErrorMessage());
    assertFalse(actualValidateResult.isNotValid());
    assertTrue(actualValidateResult.getErrorMessages().isEmpty());
    assertTrue(actualValidateResult.isValid());
  }

  /**
   * Test {@link BasicFieldTypeValidator#validate(PopulateValueRequest, Serializable)}.
   *
   * <ul>
   *   <li>Given {@link NumberFormatException#NumberFormatException()}.
   *   <li>Then throw {@link NumberFormatException}.
   * </ul>
   *
   * <p>Method under test: {@link BasicFieldTypeValidator#validate(PopulateValueRequest,
   * Serializable)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PropertyValidationResult BasicFieldTypeValidator.validate(PopulateValueRequest, Serializable)"
  })
  public void testValidate_givenNumberFormatException_thenThrowNumberFormatException() {
    // Arrange
    BasicFieldTypeValidator basicFieldTypeValidator = new BasicFieldTypeValidator();

    BasicFieldMetadata metadata = new BasicFieldMetadata();
    metadata.setFieldType(SupportedFieldType.DATE);

    DataFormatProvider dataFormatProvider = mock(DataFormatProvider.class);
    when(dataFormatProvider.getSimpleDateFormatter()).thenThrow(new NumberFormatException());
    when(dataFormatProvider.getDecimalFormatter()).thenReturn(new DecimalFormat());
    FieldManager fieldManager = new FieldManager(new EntityConfiguration(), null);
    Property property = new Property();
    Class<Object> returnType = Object.class;
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();

    PopulateValueRequest populateValueRequest =
        new PopulateValueRequest(
            true,
            fieldManager,
            property,
            metadata,
            returnType,
            "42",
            persistenceManager,
            dataFormatProvider,
            true,
            new Entity());

    // Act and Assert
    assertThrows(
        NumberFormatException.class,
        () ->
            basicFieldTypeValidator.validate(
                populateValueRequest, new SimpleDateFormat("yyyy/mm/dd")));
    verify(dataFormatProvider).getDecimalFormatter();
    verify(dataFormatProvider).getSimpleDateFormatter();
  }

  /**
   * Test {@link BasicFieldTypeValidator#validate(PopulateValueRequest, Serializable)}.
   *
   * <ul>
   *   <li>Given {@link SimpleDateFormat#SimpleDateFormat(String)} with {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link BasicFieldTypeValidator#validate(PopulateValueRequest,
   * Serializable)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PropertyValidationResult BasicFieldTypeValidator.validate(PopulateValueRequest, Serializable)"
  })
  public void testValidate_givenSimpleDateFormatWith42() {
    // Arrange
    BasicFieldTypeValidator basicFieldTypeValidator = new BasicFieldTypeValidator();

    BasicFieldMetadata metadata = new BasicFieldMetadata();
    metadata.setFieldType(SupportedFieldType.DATE);

    DataFormatProvider dataFormatProvider = mock(DataFormatProvider.class);
    when(dataFormatProvider.getSimpleDateFormatter()).thenReturn(new SimpleDateFormat("42"));
    when(dataFormatProvider.getDecimalFormatter()).thenReturn(new DecimalFormat());
    FieldManager fieldManager = new FieldManager(new EntityConfiguration(), null);
    Property property = new Property();
    Class<Object> returnType = Object.class;
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();

    PopulateValueRequest populateValueRequest =
        new PopulateValueRequest(
            true,
            fieldManager,
            property,
            metadata,
            returnType,
            "42",
            persistenceManager,
            dataFormatProvider,
            true,
            new Entity());

    // Act
    PropertyValidationResult actualValidateResult =
        basicFieldTypeValidator.validate(populateValueRequest, new SimpleDateFormat("yyyy/mm/dd"));

    // Assert
    verify(dataFormatProvider).getDecimalFormatter();
    verify(dataFormatProvider).getSimpleDateFormatter();
    assertNull(actualValidateResult.getErrorMessage());
    assertFalse(actualValidateResult.isNotValid());
    assertTrue(actualValidateResult.getErrorMessages().isEmpty());
    assertTrue(actualValidateResult.isValid());
  }

  /**
   * Test {@link BasicFieldTypeValidator#validate(PopulateValueRequest, Serializable)}.
   *
   * <ul>
   *   <li>Given {@code UNKNOWN}.
   *   <li>When {@link BasicFieldMetadata} (default constructor) FieldType is {@code UNKNOWN}.
   * </ul>
   *
   * <p>Method under test: {@link BasicFieldTypeValidator#validate(PopulateValueRequest,
   * Serializable)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PropertyValidationResult BasicFieldTypeValidator.validate(PopulateValueRequest, Serializable)"
  })
  public void testValidate_givenUnknown_whenBasicFieldMetadataFieldTypeIsUnknown() {
    // Arrange
    BasicFieldMetadata metadata = new BasicFieldMetadata();
    metadata.setFieldType(SupportedFieldType.UNKNOWN);
    FieldManager fieldManager = new FieldManager(new EntityConfiguration(), null);
    Property property = new Property();
    Class<Object> returnType = Object.class;
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    AdornedTargetListPersistenceModule dataFormatProvider =
        new AdornedTargetListPersistenceModule();

    PopulateValueRequest populateValueRequest =
        new PopulateValueRequest(
            true,
            fieldManager,
            property,
            metadata,
            returnType,
            "42",
            persistenceManager,
            dataFormatProvider,
            true,
            new Entity());

    // Act
    PropertyValidationResult actualValidateResult =
        basicFieldTypeValidator.validate(populateValueRequest, new SimpleDateFormat("yyyy/mm/dd"));

    // Assert
    assertNull(actualValidateResult.getErrorMessage());
    assertFalse(actualValidateResult.isNotValid());
    assertTrue(actualValidateResult.getErrorMessages().isEmpty());
    assertTrue(actualValidateResult.isValid());
  }

  /**
   * Test {@link BasicFieldTypeValidator#validate(PopulateValueRequest, Serializable)}.
   *
   * <ul>
   *   <li>Given {@code UNKNOWN}.
   *   <li>When {@link BasicFieldMetadata} (default constructor) FieldType is {@code UNKNOWN}.
   * </ul>
   *
   * <p>Method under test: {@link BasicFieldTypeValidator#validate(PopulateValueRequest,
   * Serializable)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PropertyValidationResult BasicFieldTypeValidator.validate(PopulateValueRequest, Serializable)"
  })
  public void testValidate_givenUnknown_whenBasicFieldMetadataFieldTypeIsUnknown2() {
    // Arrange
    BasicFieldMetadata metadata = new BasicFieldMetadata();
    metadata.setFieldType(SupportedFieldType.UNKNOWN);

    DataFormatProvider dataFormatProvider = mock(DataFormatProvider.class);
    when(dataFormatProvider.getDecimalFormatter()).thenReturn(new DecimalFormat());
    FieldManager fieldManager = new FieldManager(new EntityConfiguration(), null);
    Property property = new Property();
    Class<Object> returnType = Object.class;
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();

    PopulateValueRequest populateValueRequest =
        new PopulateValueRequest(
            true,
            fieldManager,
            property,
            metadata,
            returnType,
            "42",
            persistenceManager,
            dataFormatProvider,
            true,
            new Entity());

    // Act
    PropertyValidationResult actualValidateResult =
        basicFieldTypeValidator.validate(populateValueRequest, new SimpleDateFormat("yyyy/mm/dd"));

    // Assert
    verify(dataFormatProvider).getDecimalFormatter();
    assertNull(actualValidateResult.getErrorMessage());
    assertFalse(actualValidateResult.isNotValid());
    assertTrue(actualValidateResult.getErrorMessages().isEmpty());
    assertTrue(actualValidateResult.isValid());
  }

  /**
   * Test {@link BasicFieldTypeValidator#validate(PopulateValueRequest, Serializable)}.
   *
   * <ul>
   *   <li>Then return ErrorMessages first is {@code Field must be a date of the format:
   *       yyyy/mm/dd}.
   * </ul>
   *
   * <p>Method under test: {@link BasicFieldTypeValidator#validate(PopulateValueRequest,
   * Serializable)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PropertyValidationResult BasicFieldTypeValidator.validate(PopulateValueRequest, Serializable)"
  })
  public void testValidate_thenReturnErrorMessagesFirstIsFieldMustBeADateOfTheFormatYyyyMmDd() {
    // Arrange
    BasicFieldTypeValidator basicFieldTypeValidator = new BasicFieldTypeValidator();

    BasicFieldMetadata metadata = new BasicFieldMetadata();
    metadata.setFieldType(SupportedFieldType.DATE);

    DataFormatProvider dataFormatProvider = mock(DataFormatProvider.class);
    when(dataFormatProvider.getSimpleDateFormatter())
        .thenReturn(new SimpleDateFormat("yyyy/mm/dd"));
    when(dataFormatProvider.getDecimalFormatter()).thenReturn(new DecimalFormat());
    FieldManager fieldManager = new FieldManager(new EntityConfiguration(), null);
    Property property = new Property();
    Class<Object> returnType = Object.class;
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();

    PopulateValueRequest populateValueRequest =
        new PopulateValueRequest(
            true,
            fieldManager,
            property,
            metadata,
            returnType,
            "42",
            persistenceManager,
            dataFormatProvider,
            true,
            new Entity());

    // Act
    PropertyValidationResult actualValidateResult =
        basicFieldTypeValidator.validate(populateValueRequest, new SimpleDateFormat("yyyy/mm/dd"));

    // Assert
    verify(dataFormatProvider).getDecimalFormatter();
    verify(dataFormatProvider, atLeast(1)).getSimpleDateFormatter();
    List<String> errorMessages = actualValidateResult.getErrorMessages();
    assertEquals(1, errorMessages.size());
    assertEquals("Field must be a date of the format: yyyy/mm/dd", errorMessages.get(0));
    assertEquals(
        "Field must be a date of the format: yyyy/mm/dd", actualValidateResult.getErrorMessage());
    assertFalse(actualValidateResult.isValid());
    assertTrue(actualValidateResult.isNotValid());
  }

  /**
   * Test {@link BasicFieldTypeValidator#getOrder()}.
   *
   * <p>Method under test: {@link BasicFieldTypeValidator#getOrder()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int BasicFieldTypeValidator.getOrder()"})
  public void testGetOrder() {
    // Arrange, Act and Assert
    assertEquals(2147482647, new BasicFieldTypeValidator().getOrder());
  }
}
