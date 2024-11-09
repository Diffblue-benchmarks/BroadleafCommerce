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
package org.broadleafcommerce.openadmin.server.service.persistence.validation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import org.broadleafcommerce.common.persistence.EntityConfiguration;
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

public class RuleFieldValidatorDiffblueTest {
  /**
   * Test {@link RuleFieldValidator#validate(PopulateValueRequest, Serializable)}.
   * <ul>
   *   <li>Then return ErrorMessage is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RuleFieldValidator#validate(PopulateValueRequest, Serializable)}
   */
  @Test
  public void testValidate_thenReturnErrorMessageIsNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RuleFieldValidator ruleFieldValidator = new RuleFieldValidator();
    FieldManager fieldManager = new FieldManager(mock(EntityConfiguration.class), null);

    Property property = new Property();
    BasicFieldMetadata metadata = new BasicFieldMetadata();
    Class<Object> returnType = Object.class;
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    AdornedTargetListPersistenceModule dataFormatProvider = new AdornedTargetListPersistenceModule();
    PopulateValueRequest populateValueRequest = new PopulateValueRequest(true, fieldManager, property, metadata,
        returnType, "42", persistenceManager, dataFormatProvider, true, new Entity());

    // Act
    PropertyValidationResult actualValidateResult = ruleFieldValidator.validate(populateValueRequest,
        new SimpleDateFormat("yyyy/mm/dd"));

    // Assert
    assertNull(actualValidateResult.getErrorMessage());
    assertFalse(actualValidateResult.isNotValid());
    assertTrue(actualValidateResult.getErrorMessages().isEmpty());
    assertTrue(actualValidateResult.isValid());
  }

  /**
   * Test
   * {@link RuleFieldValidator#getMvelParsingErrorMesage(DataWrapper, MVELTranslationException)}.
   * <p>
   * Method under test:
   * {@link RuleFieldValidator#getMvelParsingErrorMesage(DataWrapper, MVELTranslationException)}
   */
  @Test
  public void testGetMvelParsingErrorMesage() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RuleFieldValidator ruleFieldValidator = new RuleFieldValidator();
    DataWrapper dw = new DataWrapper();

    // Act and Assert
    assertEquals("Problem translating rule builder, error code 1: An error occurred",
        ruleFieldValidator.getMvelParsingErrorMesage(dw, new MVELTranslationException(1, "An error occurred")));
  }

  /**
   * Test
   * {@link RuleFieldValidator#getMvelParsingErrorMesage(DataWrapper, MVELTranslationException)}.
   * <ul>
   *   <li>When {@link DataWrapper}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RuleFieldValidator#getMvelParsingErrorMesage(DataWrapper, MVELTranslationException)}
   */
  @Test
  public void testGetMvelParsingErrorMesage_whenDataWrapper() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RuleFieldValidator ruleFieldValidator = new RuleFieldValidator();
    DataWrapper dw = mock(DataWrapper.class);

    // Act and Assert
    assertEquals("Problem translating rule builder, error code 1: An error occurred",
        ruleFieldValidator.getMvelParsingErrorMesage(dw, new MVELTranslationException(1, "An error occurred")));
  }

  /**
   * Test {@link RuleFieldValidator#canHandleValidation(PopulateValueRequest)}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RuleFieldValidator#canHandleValidation(PopulateValueRequest)}
   */
  @Test
  public void testCanHandleValidation_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RuleFieldValidator ruleFieldValidator = new RuleFieldValidator();
    FieldManager fieldManager = new FieldManager(mock(EntityConfiguration.class), null);

    Property property = new Property();
    BasicFieldMetadata metadata = new BasicFieldMetadata();
    Class<Object> returnType = Object.class;
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    AdornedTargetListPersistenceModule dataFormatProvider = new AdornedTargetListPersistenceModule();

    // Act and Assert
    assertFalse(ruleFieldValidator.canHandleValidation(new PopulateValueRequest(true, fieldManager, property, metadata,
        returnType, "42", persistenceManager, dataFormatProvider, true, new Entity())));
  }

  /**
   * Test {@link RuleFieldValidator#getOrder()}.
   * <p>
   * Method under test: {@link RuleFieldValidator#getOrder()}
   */
  @Test
  public void testGetOrder() {
    // Arrange, Act and Assert
    assertEquals(2147482647, (new RuleFieldValidator()).getOrder());
  }
}
