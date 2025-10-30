/*-
 * #%L
 * BroadleafCommerce Admin Module
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
package org.broadleafcommerce.admin.persistence.validation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.broadleafcommerce.openadmin.dto.BasicFieldMetadata;
import org.broadleafcommerce.openadmin.dto.Entity;
import org.broadleafcommerce.openadmin.dto.FieldMetadata;
import org.broadleafcommerce.openadmin.dto.Property;
import org.broadleafcommerce.openadmin.server.service.persistence.module.provider.RuleFieldExtractionUtility;
import org.broadleafcommerce.openadmin.server.service.persistence.validation.PropertyValidationResult;
import org.broadleafcommerce.openadmin.web.rulebuilder.dto.DataDTO;
import org.broadleafcommerce.openadmin.web.rulebuilder.dto.DataWrapper;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {OfferQualifyingCriteriaValidator.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class OfferQualifyingCriteriaValidatorDiffblueTest {
  @Autowired
  private OfferQualifyingCriteriaValidator offerQualifyingCriteriaValidator;

  @MockBean(name = "blRuleFieldExtractionUtility")
  private RuleFieldExtractionUtility ruleFieldExtractionUtility;

  /**
   * Test {@link OfferQualifyingCriteriaValidator#validate(Entity, Serializable, Map, Map, BasicFieldMetadata, String, String)}.
   * <p>
   * Method under test: {@link OfferQualifyingCriteriaValidator#validate(Entity, Serializable, Map, Map, BasicFieldMetadata, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "PropertyValidationResult OfferQualifyingCriteriaValidator.validate(Entity, Serializable, Map, Map, BasicFieldMetadata, String, String)"})
  public void testValidate() {
    // Arrange
    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any()))
        .thenReturn(new Property("embeddableAdvancedOffer.offerTemplate", "42"));
    SimpleDateFormat instance = new SimpleDateFormat("yyyy/mm/dd");
    HashMap<String, FieldMetadata> entityFieldMetadata = new HashMap<>();
    HashMap<String, String> validationConfiguration = new HashMap<>();

    // Act
    PropertyValidationResult actualValidateResult = offerQualifyingCriteriaValidator.validate(entity, instance,
        entityFieldMetadata, validationConfiguration, new BasicFieldMetadata(), "Property Name", "42");

    // Assert
    verify(entity).findProperty(eq("embeddableAdvancedOffer.offerTemplate"));
    assertNull(actualValidateResult.getErrorMessage());
    assertFalse(actualValidateResult.isNotValid());
    assertTrue(actualValidateResult.getErrorMessages().isEmpty());
    assertTrue(actualValidateResult.isValid());
  }

  /**
   * Test {@link OfferQualifyingCriteriaValidator#validate(Entity, Serializable, Map, Map, BasicFieldMetadata, String, String)}.
   * <p>
   * Method under test: {@link OfferQualifyingCriteriaValidator#validate(Entity, Serializable, Map, Map, BasicFieldMetadata, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "PropertyValidationResult OfferQualifyingCriteriaValidator.validate(Entity, Serializable, Map, Map, BasicFieldMetadata, String, String)"})
  public void testValidate2() {
    // Arrange
    when(ruleFieldExtractionUtility.convertJsonToDataWrapper(Mockito.<String>any())).thenReturn(new DataWrapper());
    Property property = mock(Property.class);
    when(property.getUnHtmlEncodedValue()).thenReturn("secret");
    when(property.getValue()).thenReturn(OfferQualifyingCriteriaValidator.BOGO_TEMPLATE);
    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);
    SimpleDateFormat instance = new SimpleDateFormat("yyyy/mm/dd");
    HashMap<String, FieldMetadata> entityFieldMetadata = new HashMap<>();
    HashMap<String, String> validationConfiguration = new HashMap<>();

    // Act
    PropertyValidationResult actualValidateResult = offerQualifyingCriteriaValidator.validate(entity, instance,
        entityFieldMetadata, validationConfiguration, new BasicFieldMetadata(), "Property Name", "42");

    // Assert
    verify(entity, atLeast(1)).findProperty(Mockito.<String>any());
    verify(property).getUnHtmlEncodedValue();
    verify(property).getValue();
    verify(ruleFieldExtractionUtility).convertJsonToDataWrapper(eq("secret"));
    List<String> errorMessages = actualValidateResult.getErrorMessages();
    assertEquals(1, errorMessages.size());
    assertEquals("requiredValidationFailure", errorMessages.get(0));
    assertEquals("requiredValidationFailure", actualValidateResult.getErrorMessage());
    assertFalse(actualValidateResult.isValid());
    assertTrue(actualValidateResult.isNotValid());
  }

  /**
   * Test {@link OfferQualifyingCriteriaValidator#validate(Entity, Serializable, Map, Map, BasicFieldMetadata, String, String)}.
   * <ul>
   *   <li>Given {@code blRuleFieldExtractionUtility} {@link RuleFieldExtractionUtility#convertJsonToDataWrapper(String)} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferQualifyingCriteriaValidator#validate(Entity, Serializable, Map, Map, BasicFieldMetadata, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "PropertyValidationResult OfferQualifyingCriteriaValidator.validate(Entity, Serializable, Map, Map, BasicFieldMetadata, String, String)"})
  public void testValidate_givenBlRuleFieldExtractionUtilityConvertJsonToDataWrapperReturnNull() {
    // Arrange
    when(ruleFieldExtractionUtility.convertJsonToDataWrapper(Mockito.<String>any())).thenReturn(null);
    Property property = mock(Property.class);
    when(property.getUnHtmlEncodedValue()).thenReturn("secret");
    when(property.getValue()).thenReturn(OfferQualifyingCriteriaValidator.BOGO_TEMPLATE);
    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);
    SimpleDateFormat instance = new SimpleDateFormat("yyyy/mm/dd");
    HashMap<String, FieldMetadata> entityFieldMetadata = new HashMap<>();
    HashMap<String, String> validationConfiguration = new HashMap<>();

    // Act
    PropertyValidationResult actualValidateResult = offerQualifyingCriteriaValidator.validate(entity, instance,
        entityFieldMetadata, validationConfiguration, new BasicFieldMetadata(), "Property Name", "42");

    // Assert
    verify(entity, atLeast(1)).findProperty(Mockito.<String>any());
    verify(property).getUnHtmlEncodedValue();
    verify(property).getValue();
    verify(ruleFieldExtractionUtility).convertJsonToDataWrapper(eq("secret"));
    List<String> errorMessages = actualValidateResult.getErrorMessages();
    assertEquals(1, errorMessages.size());
    assertEquals("requiredValidationFailure", errorMessages.get(0));
    assertEquals("requiredValidationFailure", actualValidateResult.getErrorMessage());
    assertFalse(actualValidateResult.isValid());
    assertTrue(actualValidateResult.isNotValid());
  }

  /**
   * Test {@link OfferQualifyingCriteriaValidator#validate(Entity, Serializable, Map, Map, BasicFieldMetadata, String, String)}.
   * <ul>
   *   <li>Given {@code blRuleFieldExtractionUtility}.</li>
   *   <li>When {@link Entity} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferQualifyingCriteriaValidator#validate(Entity, Serializable, Map, Map, BasicFieldMetadata, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "PropertyValidationResult OfferQualifyingCriteriaValidator.validate(Entity, Serializable, Map, Map, BasicFieldMetadata, String, String)"})
  public void testValidate_givenBlRuleFieldExtractionUtility_whenEntity() {
    // Arrange
    Entity entity = new Entity();
    SimpleDateFormat instance = new SimpleDateFormat("yyyy/mm/dd");
    HashMap<String, FieldMetadata> entityFieldMetadata = new HashMap<>();
    HashMap<String, String> validationConfiguration = new HashMap<>();

    // Act
    PropertyValidationResult actualValidateResult = offerQualifyingCriteriaValidator.validate(entity, instance,
        entityFieldMetadata, validationConfiguration, new BasicFieldMetadata(), "Property Name", "42");

    // Assert
    assertNull(actualValidateResult.getErrorMessage());
    assertFalse(actualValidateResult.isNotValid());
    assertTrue(actualValidateResult.getErrorMessages().isEmpty());
    assertTrue(actualValidateResult.isValid());
  }

  /**
   * Test {@link OfferQualifyingCriteriaValidator#validate(Entity, Serializable, Map, Map, BasicFieldMetadata, String, String)}.
   * <ul>
   *   <li>Given {@link DataDTO} (default constructor) Condition is {@code embeddableAdvancedOffer.offerTemplate}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferQualifyingCriteriaValidator#validate(Entity, Serializable, Map, Map, BasicFieldMetadata, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "PropertyValidationResult OfferQualifyingCriteriaValidator.validate(Entity, Serializable, Map, Map, BasicFieldMetadata, String, String)"})
  public void testValidate_givenDataDTOConditionIsEmbeddableAdvancedOfferOfferTemplate() {
    // Arrange
    DataDTO dataDTO = new DataDTO();
    dataDTO.setCondition("embeddableAdvancedOffer.offerTemplate");
    dataDTO.setContainedPk(1L);
    dataDTO.setCreatedFromSubGroup(true);
    dataDTO.setPk(1L);
    dataDTO.setPreviousContainedPk(1L);
    dataDTO.setPreviousPk(1L);
    dataDTO.setQuantity(1);
    dataDTO.setRules(new ArrayList<>());

    ArrayList<DataDTO> dataDTOList = new ArrayList<>();
    dataDTOList.add(dataDTO);
    DataWrapper dataWrapper = mock(DataWrapper.class);
    when(dataWrapper.getData()).thenReturn(dataDTOList);
    when(ruleFieldExtractionUtility.convertJsonToDataWrapper(Mockito.<String>any())).thenReturn(dataWrapper);
    Property property = mock(Property.class);
    when(property.getUnHtmlEncodedValue()).thenReturn("secret");
    when(property.getValue()).thenReturn(OfferQualifyingCriteriaValidator.BOGO_TEMPLATE);
    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);
    SimpleDateFormat instance = new SimpleDateFormat("yyyy/mm/dd");
    HashMap<String, FieldMetadata> entityFieldMetadata = new HashMap<>();
    HashMap<String, String> validationConfiguration = new HashMap<>();

    // Act
    PropertyValidationResult actualValidateResult = offerQualifyingCriteriaValidator.validate(entity, instance,
        entityFieldMetadata, validationConfiguration, new BasicFieldMetadata(), "Property Name", "42");

    // Assert
    verify(entity, atLeast(1)).findProperty(Mockito.<String>any());
    verify(property).getUnHtmlEncodedValue();
    verify(property).getValue();
    verify(ruleFieldExtractionUtility).convertJsonToDataWrapper(eq("secret"));
    verify(dataWrapper).getData();
    assertNull(actualValidateResult.getErrorMessage());
    assertFalse(actualValidateResult.isNotValid());
    assertTrue(actualValidateResult.getErrorMessages().isEmpty());
    assertTrue(actualValidateResult.isValid());
  }

  /**
   * Test {@link OfferQualifyingCriteriaValidator#validate(Entity, Serializable, Map, Map, BasicFieldMetadata, String, String)}.
   * <ul>
   *   <li>Given {@link DataWrapper} {@link DataWrapper#getRawMvel()} return {@code Raw Mvel}.</li>
   *   <li>Then calls {@link DataWrapper#getRawMvel()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferQualifyingCriteriaValidator#validate(Entity, Serializable, Map, Map, BasicFieldMetadata, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "PropertyValidationResult OfferQualifyingCriteriaValidator.validate(Entity, Serializable, Map, Map, BasicFieldMetadata, String, String)"})
  public void testValidate_givenDataWrapperGetRawMvelReturnRawMvel_thenCallsGetRawMvel() {
    // Arrange
    DataWrapper dataWrapper = mock(DataWrapper.class);
    when(dataWrapper.getRawMvel()).thenReturn("Raw Mvel");
    when(dataWrapper.getData()).thenReturn(new ArrayList<>());
    when(ruleFieldExtractionUtility.convertJsonToDataWrapper(Mockito.<String>any())).thenReturn(dataWrapper);
    Property property = mock(Property.class);
    when(property.getUnHtmlEncodedValue()).thenReturn("secret");
    when(property.getValue()).thenReturn(OfferQualifyingCriteriaValidator.BOGO_TEMPLATE);
    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);
    SimpleDateFormat instance = new SimpleDateFormat("yyyy/mm/dd");
    HashMap<String, FieldMetadata> entityFieldMetadata = new HashMap<>();
    HashMap<String, String> validationConfiguration = new HashMap<>();

    // Act
    PropertyValidationResult actualValidateResult = offerQualifyingCriteriaValidator.validate(entity, instance,
        entityFieldMetadata, validationConfiguration, new BasicFieldMetadata(), "Property Name", "42");

    // Assert
    verify(entity, atLeast(1)).findProperty(Mockito.<String>any());
    verify(property).getUnHtmlEncodedValue();
    verify(property).getValue();
    verify(ruleFieldExtractionUtility).convertJsonToDataWrapper(eq("secret"));
    verify(dataWrapper).getData();
    verify(dataWrapper).getRawMvel();
    assertNull(actualValidateResult.getErrorMessage());
    assertFalse(actualValidateResult.isNotValid());
    assertTrue(actualValidateResult.getErrorMessages().isEmpty());
    assertTrue(actualValidateResult.isValid());
  }

  /**
   * Test {@link OfferQualifyingCriteriaValidator#validate(Entity, Serializable, Map, Map, BasicFieldMetadata, String, String)}.
   * <ul>
   *   <li>Given {@link Property} {@link Property#getUnHtmlEncodedValue()} return {@code null}.</li>
   *   <li>Then calls {@link DataWrapper#getRawMvel()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferQualifyingCriteriaValidator#validate(Entity, Serializable, Map, Map, BasicFieldMetadata, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "PropertyValidationResult OfferQualifyingCriteriaValidator.validate(Entity, Serializable, Map, Map, BasicFieldMetadata, String, String)"})
  public void testValidate_givenPropertyGetUnHtmlEncodedValueReturnNull_thenCallsGetRawMvel() {
    // Arrange
    DataWrapper dataWrapper = mock(DataWrapper.class);
    when(dataWrapper.getRawMvel()).thenReturn("Raw Mvel");
    when(dataWrapper.getData()).thenReturn(new ArrayList<>());
    when(ruleFieldExtractionUtility.convertJsonToDataWrapper(Mockito.<String>any())).thenReturn(dataWrapper);
    Property property = mock(Property.class);
    when(property.getUnHtmlEncodedValue()).thenReturn(null);
    when(property.getValue()).thenReturn(OfferQualifyingCriteriaValidator.BOGO_TEMPLATE);
    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);
    SimpleDateFormat instance = new SimpleDateFormat("yyyy/mm/dd");
    HashMap<String, FieldMetadata> entityFieldMetadata = new HashMap<>();
    HashMap<String, String> validationConfiguration = new HashMap<>();

    // Act
    PropertyValidationResult actualValidateResult = offerQualifyingCriteriaValidator.validate(entity, instance,
        entityFieldMetadata, validationConfiguration, new BasicFieldMetadata(), "Property Name", "42");

    // Assert
    verify(entity, atLeast(1)).findProperty(Mockito.<String>any());
    verify(property, atLeast(1)).getUnHtmlEncodedValue();
    verify(property).getValue();
    verify(ruleFieldExtractionUtility).convertJsonToDataWrapper(isNull());
    verify(dataWrapper).getData();
    verify(dataWrapper).getRawMvel();
    assertNull(actualValidateResult.getErrorMessage());
    assertFalse(actualValidateResult.isNotValid());
    assertTrue(actualValidateResult.getErrorMessages().isEmpty());
    assertTrue(actualValidateResult.isValid());
  }

  /**
   * Test {@link OfferQualifyingCriteriaValidator#validate(Entity, Serializable, Map, Map, BasicFieldMetadata, String, String)}.
   * <ul>
   *   <li>Given {@link Property} {@link Property#getValue()} return {@code 42}.</li>
   *   <li>Then return ErrorMessage is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferQualifyingCriteriaValidator#validate(Entity, Serializable, Map, Map, BasicFieldMetadata, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "PropertyValidationResult OfferQualifyingCriteriaValidator.validate(Entity, Serializable, Map, Map, BasicFieldMetadata, String, String)"})
  public void testValidate_givenPropertyGetValueReturn42_thenReturnErrorMessageIsNull() {
    // Arrange
    Property property = mock(Property.class);
    when(property.getValue()).thenReturn("42");
    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);
    SimpleDateFormat instance = new SimpleDateFormat("yyyy/mm/dd");
    HashMap<String, FieldMetadata> entityFieldMetadata = new HashMap<>();
    HashMap<String, String> validationConfiguration = new HashMap<>();

    // Act
    PropertyValidationResult actualValidateResult = offerQualifyingCriteriaValidator.validate(entity, instance,
        entityFieldMetadata, validationConfiguration, new BasicFieldMetadata(), "Property Name", "42");

    // Assert
    verify(entity).findProperty(eq("embeddableAdvancedOffer.offerTemplate"));
    verify(property).getValue();
    assertNull(actualValidateResult.getErrorMessage());
    assertFalse(actualValidateResult.isNotValid());
    assertTrue(actualValidateResult.getErrorMessages().isEmpty());
    assertTrue(actualValidateResult.isValid());
  }
}
