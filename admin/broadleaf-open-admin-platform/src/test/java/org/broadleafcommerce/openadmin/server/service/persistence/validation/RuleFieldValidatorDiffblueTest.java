package org.broadleafcommerce.openadmin.server.service.persistence.validation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
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

public class RuleFieldValidatorDiffblueTest {
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
    "java.lang.String RuleFieldValidator.getMvelParsingErrorMesage(DataWrapper, MVELTranslationException)"
  })
  public void testGetMvelParsingErrorMesage() {
    // Arrange
    RuleFieldValidator ruleFieldValidator = new RuleFieldValidator();
    DataWrapper dw = new DataWrapper();

    // Act and Assert
    assertEquals(
        "Problem translating rule builder, error code 1: An error occurred",
        ruleFieldValidator.getMvelParsingErrorMesage(
            dw, new MVELTranslationException(1, "An error occurred")));
  }

  /**
   * Test {@link RuleFieldValidator#canHandleValidation(PopulateValueRequest)}.
   *
   * <ul>
   *   <li>Given {@link SupportedFieldType#RULE_SIMPLE}.
   * </ul>
   *
   * <p>Method under test: {@link RuleFieldValidator#canHandleValidation(PopulateValueRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RuleFieldValidator.canHandleValidation(PopulateValueRequest)"})
  public void testCanHandleValidation_givenRule_simple() {
    // Arrange
    RuleFieldValidator ruleFieldValidator = new RuleFieldValidator();

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
   *   <li>Given {@link SupportedFieldType#RULE_SIMPLE_TIME}.
   * </ul>
   *
   * <p>Method under test: {@link RuleFieldValidator#canHandleValidation(PopulateValueRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RuleFieldValidator.canHandleValidation(PopulateValueRequest)"})
  public void testCanHandleValidation_givenRule_simple_time() {
    // Arrange
    RuleFieldValidator ruleFieldValidator = new RuleFieldValidator();

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
   * Test {@link RuleFieldValidator#canHandleValidation(PopulateValueRequest)}.
   *
   * <ul>
   *   <li>Given {@link SupportedFieldType#RULE_WITH_QUANTITY}.
   * </ul>
   *
   * <p>Method under test: {@link RuleFieldValidator#canHandleValidation(PopulateValueRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RuleFieldValidator.canHandleValidation(PopulateValueRequest)"})
  public void testCanHandleValidation_givenRule_with_quantity() {
    // Arrange
    RuleFieldValidator ruleFieldValidator = new RuleFieldValidator();

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
    RuleFieldValidator ruleFieldValidator = new RuleFieldValidator();
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
    boolean actualCanHandleValidationResult =
        ruleFieldValidator.canHandleValidation(populateValueRequest);

    // Assert
    assertFalse(actualCanHandleValidationResult);
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
