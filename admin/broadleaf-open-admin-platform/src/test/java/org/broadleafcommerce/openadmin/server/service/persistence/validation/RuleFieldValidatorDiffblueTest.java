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
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import org.broadleafcommerce.common.persistence.EntityConfiguration;
import org.broadleafcommerce.common.presentation.client.SupportedFieldType;
import org.broadleafcommerce.openadmin.dto.BasicFieldMetadata;
import org.broadleafcommerce.openadmin.dto.Entity;
import org.broadleafcommerce.openadmin.dto.Property;
import org.broadleafcommerce.openadmin.server.service.persistence.PersistenceManagerImpl;
import org.broadleafcommerce.openadmin.server.service.persistence.module.AdornedTargetListPersistenceModule;
import org.broadleafcommerce.openadmin.server.service.persistence.module.FieldManager;
import org.broadleafcommerce.openadmin.server.service.persistence.module.provider.request.PopulateValueRequest;
import org.broadleafcommerce.openadmin.web.rulebuilder.MVELTranslationException;
import org.broadleafcommerce.openadmin.web.rulebuilder.dto.DataWrapper;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class RuleFieldValidatorDiffblueTest {
  @InjectMocks private RuleFieldValidator ruleFieldValidator;

  /**
   * Test {@link RuleFieldValidator#validate(PopulateValueRequest, Serializable)}.
   *
   * <ul>
   *   <li>Then return ErrorMessage is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link RuleFieldValidator#validate(PopulateValueRequest, Serializable)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PropertyValidationResult RuleFieldValidator.validate(PopulateValueRequest, Serializable)"
  })
  public void testValidate_thenReturnErrorMessageIsNull() {
    // Arrange
    FieldManager fieldManager = new FieldManager(new EntityConfiguration(), null);
    Property property = new Property();
    BasicFieldMetadata metadata = new BasicFieldMetadata();
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
        ruleFieldValidator.validate(populateValueRequest, new SimpleDateFormat("yyyy/mm/dd"));

    // Assert
    assertNull(actualValidateResult.getErrorMessage());
    assertFalse(actualValidateResult.isNotValid());
    assertTrue(actualValidateResult.getErrorMessages().isEmpty());
    assertTrue(actualValidateResult.isValid());
  }

  /**
   * Test {@link RuleFieldValidator#getMvelParsingErrorMesage(DataWrapper,
   * MVELTranslationException)}.
   *
   * <p>Method under test: {@link RuleFieldValidator#getMvelParsingErrorMesage(DataWrapper,
   * MVELTranslationException)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String RuleFieldValidator.getMvelParsingErrorMesage(DataWrapper, MVELTranslationException)"
  })
  public void testGetMvelParsingErrorMesage() {
    // Arrange
    DataWrapper dw = new DataWrapper();

    // Act
    String actualMvelParsingErrorMesage =
        ruleFieldValidator.getMvelParsingErrorMesage(
            dw, new MVELTranslationException(1, "An error occurred"));

    // Assert
    assertEquals(
        "Problem translating rule builder, error code 1: An error occurred",
        actualMvelParsingErrorMesage);
  }

  /**
   * Test {@link RuleFieldValidator#canHandleValidation(PopulateValueRequest)}.
   *
   * <p>Method under test: {@link RuleFieldValidator#canHandleValidation(PopulateValueRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RuleFieldValidator.canHandleValidation(PopulateValueRequest)"})
  public void testCanHandleValidation() {
    // Arrange
    BasicFieldMetadata metadata = mock(BasicFieldMetadata.class);
    when(metadata.getFieldType()).thenReturn(SupportedFieldType.RULE_WITH_QUANTITY);
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
    boolean actualCanHandleValidationResult =
        ruleFieldValidator.canHandleValidation(populateValueRequest);

    // Assert
    verify(metadata).getFieldType();
    assertTrue(actualCanHandleValidationResult);
  }

  /**
   * Test {@link RuleFieldValidator#canHandleValidation(PopulateValueRequest)}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link RuleFieldValidator#canHandleValidation(PopulateValueRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RuleFieldValidator.canHandleValidation(PopulateValueRequest)"})
  public void testCanHandleValidation_thenReturnFalse() {
    // Arrange
    FieldManager fieldManager = new FieldManager(new EntityConfiguration(), null);
    Property property = new Property();
    BasicFieldMetadata metadata = new BasicFieldMetadata();
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

    // Act and Assert
    assertFalse(ruleFieldValidator.canHandleValidation(populateValueRequest));
  }

  /**
   * Test {@link RuleFieldValidator#canHandleValidation(PopulateValueRequest)}.
   *
   * <ul>
   *   <li>When {@link BasicFieldMetadata} {@link BasicFieldMetadata#getFieldType()} return {@link
   *       SupportedFieldType#RULE_SIMPLE}.
   * </ul>
   *
   * <p>Method under test: {@link RuleFieldValidator#canHandleValidation(PopulateValueRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RuleFieldValidator.canHandleValidation(PopulateValueRequest)"})
  public void testCanHandleValidation_whenBasicFieldMetadataGetFieldTypeReturnRule_simple() {
    // Arrange
    BasicFieldMetadata metadata = mock(BasicFieldMetadata.class);
    when(metadata.getFieldType()).thenReturn(SupportedFieldType.RULE_SIMPLE);
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
    boolean actualCanHandleValidationResult =
        ruleFieldValidator.canHandleValidation(populateValueRequest);

    // Assert
    verify(metadata, atLeast(1)).getFieldType();
    assertTrue(actualCanHandleValidationResult);
  }

  /**
   * Test {@link RuleFieldValidator#canHandleValidation(PopulateValueRequest)}.
   *
   * <ul>
   *   <li>When {@link BasicFieldMetadata} {@link BasicFieldMetadata#getFieldType()} return {@link
   *       SupportedFieldType#RULE_SIMPLE_TIME}.
   * </ul>
   *
   * <p>Method under test: {@link RuleFieldValidator#canHandleValidation(PopulateValueRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RuleFieldValidator.canHandleValidation(PopulateValueRequest)"})
  public void testCanHandleValidation_whenBasicFieldMetadataGetFieldTypeReturnRule_simple_time() {
    // Arrange
    BasicFieldMetadata metadata = mock(BasicFieldMetadata.class);
    when(metadata.getFieldType()).thenReturn(SupportedFieldType.RULE_SIMPLE_TIME);
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
    boolean actualCanHandleValidationResult =
        ruleFieldValidator.canHandleValidation(populateValueRequest);

    // Assert
    verify(metadata, atLeast(1)).getFieldType();
    assertTrue(actualCanHandleValidationResult);
  }

  /**
   * Test {@link RuleFieldValidator#getOrder()}.
   *
   * <p>Method under test: {@link RuleFieldValidator#getOrder()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int RuleFieldValidator.getOrder()"})
  public void testGetOrder() {
    // Arrange, Act and Assert
    assertEquals(2147482647, new RuleFieldValidator().getOrder());
  }
}
