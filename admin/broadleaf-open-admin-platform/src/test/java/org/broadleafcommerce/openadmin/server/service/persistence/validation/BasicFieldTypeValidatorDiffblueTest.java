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
import java.io.Serializable;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import org.broadleafcommerce.common.presentation.client.SupportedFieldType;
import org.broadleafcommerce.openadmin.dto.BasicFieldMetadata;
import org.broadleafcommerce.openadmin.server.service.persistence.module.AdornedTargetListPersistenceModule;
import org.broadleafcommerce.openadmin.server.service.persistence.module.provider.request.PopulateValueRequest;
import org.junit.Test;

public class BasicFieldTypeValidatorDiffblueTest {
  /**
   * Method under test:
   * {@link BasicFieldTypeValidator#validate(PopulateValueRequest, Serializable)}
   */
  @Test
  public void testValidate() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicFieldTypeValidator basicFieldTypeValidator = new BasicFieldTypeValidator();
    AdornedTargetListPersistenceModule adornedTargetListPersistenceModule = mock(
        AdornedTargetListPersistenceModule.class);
    when(adornedTargetListPersistenceModule.getDecimalFormatter()).thenReturn(new DecimalFormat());

    BasicFieldMetadata basicFieldMetadata = new BasicFieldMetadata();
    basicFieldMetadata.setFieldType(SupportedFieldType.UNKNOWN);
    PopulateValueRequest populateValueRequest = mock(PopulateValueRequest.class);
    when(populateValueRequest.getMetadata()).thenReturn(basicFieldMetadata);
    when(populateValueRequest.getDataFormatProvider()).thenReturn(adornedTargetListPersistenceModule);

    // Act
    PropertyValidationResult actualValidateResult = basicFieldTypeValidator.validate(populateValueRequest,
        new SimpleDateFormat("yyyy/mm/dd"));

    // Assert
    verify(adornedTargetListPersistenceModule).getDecimalFormatter();
    verify(populateValueRequest).getDataFormatProvider();
    verify(populateValueRequest).getMetadata();
    assertNull(actualValidateResult.getErrorMessage());
    assertFalse(actualValidateResult.isNotValid());
    assertTrue(actualValidateResult.getErrorMessages().isEmpty());
    assertTrue(actualValidateResult.isValid());
  }

  /**
   * Method under test:
   * {@link BasicFieldTypeValidator#validate(PopulateValueRequest, Serializable)}
   */
  @Test
  public void testValidate2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicFieldTypeValidator basicFieldTypeValidator = new BasicFieldTypeValidator();
    AdornedTargetListPersistenceModule adornedTargetListPersistenceModule = mock(
        AdornedTargetListPersistenceModule.class);
    when(adornedTargetListPersistenceModule.getDecimalFormatter()).thenReturn(new DecimalFormat());

    BasicFieldMetadata basicFieldMetadata = new BasicFieldMetadata();
    basicFieldMetadata.setFieldType(SupportedFieldType.ID);
    PopulateValueRequest populateValueRequest = mock(PopulateValueRequest.class);
    when(populateValueRequest.getRequestedValue()).thenReturn("42");
    when(populateValueRequest.getSetId()).thenReturn(true);
    when(populateValueRequest.getMetadata()).thenReturn(basicFieldMetadata);
    when(populateValueRequest.getDataFormatProvider()).thenReturn(adornedTargetListPersistenceModule);

    // Act
    PropertyValidationResult actualValidateResult = basicFieldTypeValidator.validate(populateValueRequest,
        new SimpleDateFormat("yyyy/mm/dd"));

    // Assert
    verify(adornedTargetListPersistenceModule).getDecimalFormatter();
    verify(populateValueRequest).getDataFormatProvider();
    verify(populateValueRequest, atLeast(1)).getMetadata();
    verify(populateValueRequest).getRequestedValue();
    verify(populateValueRequest).getSetId();
    assertNull(actualValidateResult.getErrorMessage());
    assertFalse(actualValidateResult.isNotValid());
    assertTrue(actualValidateResult.getErrorMessages().isEmpty());
    assertTrue(actualValidateResult.isValid());
  }

  /**
   * Method under test:
   * {@link BasicFieldTypeValidator#validate(PopulateValueRequest, Serializable)}
   */
  @Test
  public void testValidate3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicFieldTypeValidator basicFieldTypeValidator = new BasicFieldTypeValidator();
    AdornedTargetListPersistenceModule adornedTargetListPersistenceModule = mock(
        AdornedTargetListPersistenceModule.class);
    when(adornedTargetListPersistenceModule.getDecimalFormatter()).thenReturn(new DecimalFormat());

    BasicFieldMetadata basicFieldMetadata = new BasicFieldMetadata();
    basicFieldMetadata.setFieldType(SupportedFieldType.ID);
    PopulateValueRequest populateValueRequest = mock(PopulateValueRequest.class);
    when(populateValueRequest.getSetId()).thenReturn(false);
    when(populateValueRequest.getMetadata()).thenReturn(basicFieldMetadata);
    when(populateValueRequest.getDataFormatProvider()).thenReturn(adornedTargetListPersistenceModule);

    // Act
    PropertyValidationResult actualValidateResult = basicFieldTypeValidator.validate(populateValueRequest,
        new SimpleDateFormat("yyyy/mm/dd"));

    // Assert
    verify(adornedTargetListPersistenceModule).getDecimalFormatter();
    verify(populateValueRequest).getDataFormatProvider();
    verify(populateValueRequest).getMetadata();
    verify(populateValueRequest).getSetId();
    assertNull(actualValidateResult.getErrorMessage());
    assertFalse(actualValidateResult.isNotValid());
    assertTrue(actualValidateResult.getErrorMessages().isEmpty());
    assertTrue(actualValidateResult.isValid());
  }

  /**
   * Method under test:
   * {@link BasicFieldTypeValidator#validate(PopulateValueRequest, Serializable)}
   */
  @Test
  public void testValidate4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicFieldTypeValidator basicFieldTypeValidator = new BasicFieldTypeValidator();
    AdornedTargetListPersistenceModule adornedTargetListPersistenceModule = mock(
        AdornedTargetListPersistenceModule.class);
    when(adornedTargetListPersistenceModule.getDecimalFormatter()).thenReturn(new DecimalFormat());

    BasicFieldMetadata basicFieldMetadata = new BasicFieldMetadata();
    basicFieldMetadata.setSecondaryType(SupportedFieldType.UNKNOWN);
    basicFieldMetadata.setFieldType(SupportedFieldType.ID);
    PopulateValueRequest populateValueRequest = mock(PopulateValueRequest.class);
    when(populateValueRequest.getSetId()).thenReturn(true);
    when(populateValueRequest.getMetadata()).thenReturn(basicFieldMetadata);
    when(populateValueRequest.getDataFormatProvider()).thenReturn(adornedTargetListPersistenceModule);

    // Act
    PropertyValidationResult actualValidateResult = basicFieldTypeValidator.validate(populateValueRequest,
        new SimpleDateFormat("yyyy/mm/dd"));

    // Assert
    verify(adornedTargetListPersistenceModule).getDecimalFormatter();
    verify(populateValueRequest).getDataFormatProvider();
    verify(populateValueRequest, atLeast(1)).getMetadata();
    verify(populateValueRequest).getSetId();
    assertNull(actualValidateResult.getErrorMessage());
    assertFalse(actualValidateResult.isNotValid());
    assertTrue(actualValidateResult.getErrorMessages().isEmpty());
    assertTrue(actualValidateResult.isValid());
  }

  /**
   * Method under test:
   * {@link BasicFieldTypeValidator#validate(PopulateValueRequest, Serializable)}
   */
  @Test
  public void testValidate5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicFieldTypeValidator basicFieldTypeValidator = new BasicFieldTypeValidator();
    AdornedTargetListPersistenceModule adornedTargetListPersistenceModule = mock(
        AdornedTargetListPersistenceModule.class);
    when(adornedTargetListPersistenceModule.getSimpleDateFormatter()).thenReturn(new SimpleDateFormat("yyyy/mm/dd"));
    when(adornedTargetListPersistenceModule.getDecimalFormatter()).thenReturn(new DecimalFormat());

    BasicFieldMetadata basicFieldMetadata = new BasicFieldMetadata();
    basicFieldMetadata.setFieldType(SupportedFieldType.DATE);
    PopulateValueRequest populateValueRequest = mock(PopulateValueRequest.class);
    when(populateValueRequest.getRequestedValue()).thenReturn("42");
    when(populateValueRequest.getMetadata()).thenReturn(basicFieldMetadata);
    when(populateValueRequest.getDataFormatProvider()).thenReturn(adornedTargetListPersistenceModule);

    // Act
    PropertyValidationResult actualValidateResult = basicFieldTypeValidator.validate(populateValueRequest,
        new SimpleDateFormat("yyyy/mm/dd"));

    // Assert
    verify(adornedTargetListPersistenceModule).getDecimalFormatter();
    verify(adornedTargetListPersistenceModule, atLeast(1)).getSimpleDateFormatter();
    verify(populateValueRequest, atLeast(1)).getDataFormatProvider();
    verify(populateValueRequest).getMetadata();
    verify(populateValueRequest).getRequestedValue();
    List<String> errorMessages = actualValidateResult.getErrorMessages();
    assertEquals(1, errorMessages.size());
    assertEquals("Field must be a date of the format: yyyy/mm/dd", errorMessages.get(0));
    assertEquals("Field must be a date of the format: yyyy/mm/dd", actualValidateResult.getErrorMessage());
    assertFalse(actualValidateResult.isValid());
    assertTrue(actualValidateResult.isNotValid());
  }

  /**
   * Method under test:
   * {@link BasicFieldTypeValidator#validate(PopulateValueRequest, Serializable)}
   */
  @Test
  public void testValidate6() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicFieldTypeValidator basicFieldTypeValidator = new BasicFieldTypeValidator();
    AdornedTargetListPersistenceModule adornedTargetListPersistenceModule = mock(
        AdornedTargetListPersistenceModule.class);
    when(adornedTargetListPersistenceModule.getSimpleDateFormatter()).thenReturn(new SimpleDateFormat("42"));
    when(adornedTargetListPersistenceModule.getDecimalFormatter()).thenReturn(new DecimalFormat());

    BasicFieldMetadata basicFieldMetadata = new BasicFieldMetadata();
    basicFieldMetadata.setFieldType(SupportedFieldType.DATE);
    PopulateValueRequest populateValueRequest = mock(PopulateValueRequest.class);
    when(populateValueRequest.getRequestedValue()).thenReturn("42");
    when(populateValueRequest.getMetadata()).thenReturn(basicFieldMetadata);
    when(populateValueRequest.getDataFormatProvider()).thenReturn(adornedTargetListPersistenceModule);

    // Act
    PropertyValidationResult actualValidateResult = basicFieldTypeValidator.validate(populateValueRequest,
        new SimpleDateFormat("yyyy/mm/dd"));

    // Assert
    verify(adornedTargetListPersistenceModule).getDecimalFormatter();
    verify(adornedTargetListPersistenceModule).getSimpleDateFormatter();
    verify(populateValueRequest, atLeast(1)).getDataFormatProvider();
    verify(populateValueRequest).getMetadata();
    verify(populateValueRequest).getRequestedValue();
    assertNull(actualValidateResult.getErrorMessage());
    assertFalse(actualValidateResult.isNotValid());
    assertTrue(actualValidateResult.getErrorMessages().isEmpty());
    assertTrue(actualValidateResult.isValid());
  }

  /**
   * Method under test:
   * {@link BasicFieldTypeValidator#validate(PopulateValueRequest, Serializable)}
   */
  @Test
  public void testValidate7() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicFieldTypeValidator basicFieldTypeValidator = new BasicFieldTypeValidator();
    AdornedTargetListPersistenceModule adornedTargetListPersistenceModule = mock(
        AdornedTargetListPersistenceModule.class);
    when(adornedTargetListPersistenceModule.getSimpleDateFormatter())
        .thenThrow(new NumberFormatException("ThreadLocalManager.notify.orphans"));
    when(adornedTargetListPersistenceModule.getDecimalFormatter()).thenReturn(new DecimalFormat());

    BasicFieldMetadata basicFieldMetadata = new BasicFieldMetadata();
    basicFieldMetadata.setFieldType(SupportedFieldType.DATE);
    PopulateValueRequest populateValueRequest = mock(PopulateValueRequest.class);
    when(populateValueRequest.getMetadata()).thenReturn(basicFieldMetadata);
    when(populateValueRequest.getDataFormatProvider()).thenReturn(adornedTargetListPersistenceModule);

    // Act and Assert
    assertThrows(NumberFormatException.class,
        () -> basicFieldTypeValidator.validate(populateValueRequest, new SimpleDateFormat("yyyy/mm/dd")));
    verify(adornedTargetListPersistenceModule).getDecimalFormatter();
    verify(adornedTargetListPersistenceModule).getSimpleDateFormatter();
    verify(populateValueRequest, atLeast(1)).getDataFormatProvider();
    verify(populateValueRequest).getMetadata();
  }

  /**
   * Method under test: {@link BasicFieldTypeValidator#getOrder()}
   */
  @Test
  public void testGetOrder() {
    // Arrange, Act and Assert
    assertEquals(2147482647, (new BasicFieldTypeValidator()).getOrder());
  }
}
