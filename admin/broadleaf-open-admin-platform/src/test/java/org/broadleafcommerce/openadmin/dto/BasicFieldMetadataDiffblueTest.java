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

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.broadleafcommerce.common.presentation.client.LookupType;
import org.broadleafcommerce.common.presentation.client.RuleBuilderDisplayType;
import org.broadleafcommerce.common.presentation.client.SupportedFieldType;
import org.broadleafcommerce.common.presentation.client.VisibilityEnum;
import org.broadleafcommerce.openadmin.dto.visitor.MetadataVisitor;
import org.broadleafcommerce.openadmin.dto.visitor.MetadataVisitorAdapter;
import org.junit.Test;
import org.mockito.Mockito;

public class BasicFieldMetadataDiffblueTest {
  /**
   * Test {@link BasicFieldMetadata#getRequired()}.
   * <ul>
   *   <li>Given {@link BasicFieldMetadata} (default constructor) Required is
   * {@code true}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicFieldMetadata#getRequired()}
   */
  @Test
  public void testGetRequired_givenBasicFieldMetadataRequiredIsTrue_thenReturnTrue() {
    // Arrange
    BasicFieldMetadata basicFieldMetadata = new BasicFieldMetadata();
    basicFieldMetadata.setRequired(true);

    // Act and Assert
    assertTrue(basicFieldMetadata.getRequired());
  }

  /**
   * Test {@link BasicFieldMetadata#getRequired()}.
   * <ul>
   *   <li>Given {@link BasicFieldMetadata} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicFieldMetadata#getRequired()}
   */
  @Test
  public void testGetRequired_givenBasicFieldMetadata_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new BasicFieldMetadata()).getRequired());
  }

  /**
   * Test {@link BasicFieldMetadata#getForeignKeyCollection()}.
   * <ul>
   *   <li>Given {@link BasicFieldMetadata} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicFieldMetadata#getForeignKeyCollection()}
   */
  @Test
  public void testGetForeignKeyCollection_givenBasicFieldMetadata_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new BasicFieldMetadata()).getForeignKeyCollection());
  }

  /**
   * Test {@link BasicFieldMetadata#getForeignKeyCollection()}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicFieldMetadata#getForeignKeyCollection()}
   */
  @Test
  public void testGetForeignKeyCollection_thenReturnTrue() {
    // Arrange
    BasicFieldMetadata basicFieldMetadata = new BasicFieldMetadata();
    basicFieldMetadata.setForeignKeyCollection(true);

    // Act and Assert
    assertTrue(basicFieldMetadata.getForeignKeyCollection());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link BasicFieldMetadata#setAllowNoValueEnumOption(Boolean)}
   *   <li>{@link BasicFieldMetadata#setAssociatedFieldName(String)}
   *   <li>{@link BasicFieldMetadata#setBroadleafEnumeration(String)}
   *   <li>{@link BasicFieldMetadata#setCanLinkToExternalEntity(Boolean)}
   *   <li>{@link BasicFieldMetadata#setColumnWidth(String)}
   *   <li>{@link BasicFieldMetadata#setCustomCriteria(String[])}
   *   <li>{@link BasicFieldMetadata#setDefaultValue(String)}
   *   <li>{@link BasicFieldMetadata#setDerived(Boolean)}
   *   <li>{@link BasicFieldMetadata#setDisplayType(RuleBuilderDisplayType)}
   *   <li>{@link BasicFieldMetadata#setEnableTypeaheadLookup(Boolean)}
   *   <li>{@link BasicFieldMetadata#setEnumerationClass(String)}
   *   <li>{@link BasicFieldMetadata#setEnumerationValues(String[][])}
   *   <li>{@link BasicFieldMetadata#setExplicitFieldType(SupportedFieldType)}
   *   <li>{@link BasicFieldMetadata#setFieldComponentRenderer(SupportedFieldType)}
   *   <li>{@link BasicFieldMetadata#setFieldComponentRendererTemplate(String)}
   *   <li>{@link BasicFieldMetadata#setFieldType(SupportedFieldType)}
   *   <li>{@link BasicFieldMetadata#setForcePopulateChildProperties(Boolean)}
   *   <li>{@link BasicFieldMetadata#setForeignKeyClass(String)}
   *   <li>{@link BasicFieldMetadata#setForeignKeyCollection(Boolean)}
   *   <li>{@link BasicFieldMetadata#setForeignKeyDisplayValueProperty(String)}
   *   <li>{@link BasicFieldMetadata#setForeignKeyProperty(String)}
   *   <li>
   * {@link BasicFieldMetadata#setGridFieldComponentRenderer(SupportedFieldType)}
   *   <li>{@link BasicFieldMetadata#setGridFieldComponentRendererTemplate(String)}
   *   <li>{@link BasicFieldMetadata#setGridOrder(Integer)}
   *   <li>{@link BasicFieldMetadata#setGroupCollapsed(Boolean)}
   *   <li>{@link BasicFieldMetadata#setHelpText(String)}
   *   <li>{@link BasicFieldMetadata#setHideEnumerationIfEmpty(Boolean)}
   *   <li>{@link BasicFieldMetadata#setHint(String)}
   *   <li>{@link BasicFieldMetadata#setIsFilter(Boolean)}
   *   <li>{@link BasicFieldMetadata#setLargeEntry(Boolean)}
   *   <li>{@link BasicFieldMetadata#setLength(Integer)}
   *   <li>{@link BasicFieldMetadata#setLookupDisplayProperty(String)}
   *   <li>{@link BasicFieldMetadata#setLookupType(LookupType)}
   *   <li>{@link BasicFieldMetadata#setManyToField(String)}
   *   <li>{@link BasicFieldMetadata#setMapFieldValueClass(String)}
   *   <li>{@link BasicFieldMetadata#setMapKeyValueProperty(String)}
   *   <li>{@link BasicFieldMetadata#setMergedPropertyType(MergedPropertyType)}
   *   <li>{@link BasicFieldMetadata#setMutable(Boolean)}
   *   <li>{@link BasicFieldMetadata#setName(String)}
   *   <li>{@link BasicFieldMetadata#setOptionCanEditValues(Boolean)}
   *   <li>{@link BasicFieldMetadata#setOptionDisplayFieldName(String)}
   *   <li>{@link BasicFieldMetadata#setOptionFilterParams(String[][])}
   *   <li>{@link BasicFieldMetadata#setOptionHideIfEmpty(Boolean)}
   *   <li>{@link BasicFieldMetadata#setOptionListEntity(String)}
   *   <li>{@link BasicFieldMetadata#setOptionValueFieldName(String)}
   *   <li>{@link BasicFieldMetadata#setPrecision(Integer)}
   *   <li>{@link BasicFieldMetadata#setProminent(Boolean)}
   *   <li>{@link BasicFieldMetadata#setReadOnly(Boolean)}
   *   <li>{@link BasicFieldMetadata#setRequired(Boolean)}
   *   <li>{@link BasicFieldMetadata#setRequiredOverride(Boolean)}
   *   <li>{@link BasicFieldMetadata#setRuleIdentifier(String)}
   *   <li>{@link BasicFieldMetadata#setScale(Integer)}
   *   <li>{@link BasicFieldMetadata#setSearchable(Boolean)}
   *   <li>{@link BasicFieldMetadata#setSecondaryType(SupportedFieldType)}
   *   <li>{@link BasicFieldMetadata#setToOneLookupCreatedViaAnnotation(Boolean)}
   *   <li>{@link BasicFieldMetadata#setToOneParentProperty(String)}
   *   <li>{@link BasicFieldMetadata#setToOneTargetProperty(String)}
   *   <li>{@link BasicFieldMetadata#setTooltip(String)}
   *   <li>{@link BasicFieldMetadata#setTranslatable(Boolean)}
   *   <li>{@link BasicFieldMetadata#setUnique(Boolean)}
   *   <li>{@link BasicFieldMetadata#setUseServerSideInspectionCache(Boolean)}
   *   <li>{@link BasicFieldMetadata#setValidationConfigurations(Map)}
   *   <li>{@link BasicFieldMetadata#setVisibility(VisibilityEnum)}
   *   <li>{@link BasicFieldMetadata#getAssociatedFieldName()}
   *   <li>{@link BasicFieldMetadata#getBroadleafEnumeration()}
   *   <li>{@link BasicFieldMetadata#getCanLinkToExternalEntity()}
   *   <li>{@link BasicFieldMetadata#getColumnWidth()}
   *   <li>{@link BasicFieldMetadata#getCustomCriteria()}
   *   <li>{@link BasicFieldMetadata#getDefaultValue()}
   *   <li>{@link BasicFieldMetadata#getDisplayType()}
   *   <li>{@link BasicFieldMetadata#getEnableTypeaheadLookup()}
   *   <li>{@link BasicFieldMetadata#getEnumerationClass()}
   *   <li>{@link BasicFieldMetadata#getEnumerationValues()}
   *   <li>{@link BasicFieldMetadata#getExplicitFieldType()}
   *   <li>{@link BasicFieldMetadata#getFieldComponentRenderer()}
   *   <li>{@link BasicFieldMetadata#getFieldComponentRendererTemplate()}
   *   <li>{@link BasicFieldMetadata#getFieldType()}
   *   <li>{@link BasicFieldMetadata#getForcePopulateChildProperties()}
   *   <li>{@link BasicFieldMetadata#getForeignKeyClass()}
   *   <li>{@link BasicFieldMetadata#getForeignKeyDisplayValueProperty()}
   *   <li>{@link BasicFieldMetadata#getForeignKeyProperty()}
   *   <li>{@link BasicFieldMetadata#getGridFieldComponentRenderer()}
   *   <li>{@link BasicFieldMetadata#getGridFieldComponentRendererTemplate()}
   *   <li>{@link BasicFieldMetadata#getGridOrder()}
   *   <li>{@link BasicFieldMetadata#getGroupCollapsed()}
   *   <li>{@link BasicFieldMetadata#getHelpText()}
   *   <li>{@link BasicFieldMetadata#getHideEnumerationIfEmpty()}
   *   <li>{@link BasicFieldMetadata#getHint()}
   *   <li>{@link BasicFieldMetadata#getIsDerived()}
   *   <li>{@link BasicFieldMetadata#getIsFilter()}
   *   <li>{@link BasicFieldMetadata#getLength()}
   *   <li>{@link BasicFieldMetadata#getLookupDisplayProperty()}
   *   <li>{@link BasicFieldMetadata#getLookupType()}
   *   <li>{@link BasicFieldMetadata#getManyToField()}
   *   <li>{@link BasicFieldMetadata#getMapFieldValueClass()}
   *   <li>{@link BasicFieldMetadata#getMapKeyValueProperty()}
   *   <li>{@link BasicFieldMetadata#getMergedPropertyType()}
   *   <li>{@link BasicFieldMetadata#getMutable()}
   *   <li>{@link BasicFieldMetadata#getName()}
   *   <li>{@link BasicFieldMetadata#getOptionCanEditValues()}
   *   <li>{@link BasicFieldMetadata#getOptionDisplayFieldName()}
   *   <li>{@link BasicFieldMetadata#getOptionFilterParams()}
   *   <li>{@link BasicFieldMetadata#getOptionHideIfEmpty()}
   *   <li>{@link BasicFieldMetadata#getOptionListEntity()}
   *   <li>{@link BasicFieldMetadata#getOptionValueFieldName()}
   *   <li>{@link BasicFieldMetadata#getPrecision()}
   *   <li>{@link BasicFieldMetadata#getReadOnly()}
   *   <li>{@link BasicFieldMetadata#getRequiredOverride()}
   *   <li>{@link BasicFieldMetadata#getRuleIdentifier()}
   *   <li>{@link BasicFieldMetadata#getScale()}
   *   <li>{@link BasicFieldMetadata#getSearchable()}
   *   <li>{@link BasicFieldMetadata#getSecondaryType()}
   *   <li>{@link BasicFieldMetadata#getToOneLookupCreatedViaAnnotation()}
   *   <li>{@link BasicFieldMetadata#getToOneParentProperty()}
   *   <li>{@link BasicFieldMetadata#getToOneTargetProperty()}
   *   <li>{@link BasicFieldMetadata#getTooltip()}
   *   <li>{@link BasicFieldMetadata#getTranslatable()}
   *   <li>{@link BasicFieldMetadata#getUnique()}
   *   <li>{@link BasicFieldMetadata#getUseServerSideInspectionCache()}
   *   <li>{@link BasicFieldMetadata#getValidationConfigurations()}
   *   <li>{@link BasicFieldMetadata#getVisibility()}
   *   <li>{@link BasicFieldMetadata#isLargeEntry()}
   *   <li>{@link BasicFieldMetadata#isProminent()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    BasicFieldMetadata basicFieldMetadata = new BasicFieldMetadata();

    // Act
    basicFieldMetadata.setAllowNoValueEnumOption(true);
    basicFieldMetadata.setAssociatedFieldName("Associated Field Name");
    basicFieldMetadata.setBroadleafEnumeration("Broadleaf Enumeration");
    basicFieldMetadata.setCanLinkToExternalEntity(true);
    basicFieldMetadata.setColumnWidth("Column Width");
    String[] customCriteria = new String[]{"Custom Criteria"};
    basicFieldMetadata.setCustomCriteria(customCriteria);
    basicFieldMetadata.setDefaultValue("42");
    basicFieldMetadata.setDerived(true);
    basicFieldMetadata.setDisplayType(RuleBuilderDisplayType.NORMAL);
    basicFieldMetadata.setEnableTypeaheadLookup(true);
    basicFieldMetadata.setEnumerationClass("Enumeration Class");
    String[][] enumerationValues = new String[][]{new String[]{"42"}};
    basicFieldMetadata.setEnumerationValues(enumerationValues);
    basicFieldMetadata.setExplicitFieldType(SupportedFieldType.UNKNOWN);
    basicFieldMetadata.setFieldComponentRenderer(SupportedFieldType.UNKNOWN);
    basicFieldMetadata.setFieldComponentRendererTemplate("Field Component Renderer Template");
    basicFieldMetadata.setFieldType(SupportedFieldType.UNKNOWN);
    basicFieldMetadata.setForcePopulateChildProperties(true);
    basicFieldMetadata.setForeignKeyClass("Foreign Key Class");
    basicFieldMetadata.setForeignKeyCollection(true);
    basicFieldMetadata.setForeignKeyDisplayValueProperty("42");
    basicFieldMetadata.setForeignKeyProperty("Foreign Key Property");
    basicFieldMetadata.setGridFieldComponentRenderer(SupportedFieldType.UNKNOWN);
    basicFieldMetadata.setGridFieldComponentRendererTemplate("Grid Field Component Renderer Template");
    basicFieldMetadata.setGridOrder(1);
    basicFieldMetadata.setGroupCollapsed(true);
    basicFieldMetadata.setHelpText("Help Text");
    basicFieldMetadata.setHideEnumerationIfEmpty(true);
    basicFieldMetadata.setHint("Hint");
    basicFieldMetadata.setIsFilter(true);
    basicFieldMetadata.setLargeEntry(true);
    basicFieldMetadata.setLength(3);
    basicFieldMetadata.setLookupDisplayProperty("Lookup Display Property");
    basicFieldMetadata.setLookupType(LookupType.STANDARD);
    basicFieldMetadata.setManyToField("Many To Field");
    basicFieldMetadata.setMapFieldValueClass("42");
    basicFieldMetadata.setMapKeyValueProperty("42");
    basicFieldMetadata.setMergedPropertyType(MergedPropertyType.PRIMARY);
    basicFieldMetadata.setMutable(true);
    basicFieldMetadata.setName("Name");
    basicFieldMetadata.setOptionCanEditValues(true);
    basicFieldMetadata.setOptionDisplayFieldName("Option Display Field Name");
    String[][] optionFilterParams = new String[][]{new String[]{"Option Filter Params"}};
    basicFieldMetadata.setOptionFilterParams(optionFilterParams);
    basicFieldMetadata.setOptionHideIfEmpty(true);
    basicFieldMetadata.setOptionListEntity("Option List Entity");
    basicFieldMetadata.setOptionValueFieldName("42");
    basicFieldMetadata.setPrecision(1);
    basicFieldMetadata.setProminent(true);
    basicFieldMetadata.setReadOnly(true);
    basicFieldMetadata.setRequired(true);
    basicFieldMetadata.setRequiredOverride(true);
    basicFieldMetadata.setRuleIdentifier("42");
    basicFieldMetadata.setScale(1);
    basicFieldMetadata.setSearchable(true);
    basicFieldMetadata.setSecondaryType(SupportedFieldType.UNKNOWN);
    basicFieldMetadata.setToOneLookupCreatedViaAnnotation(true);
    basicFieldMetadata.setToOneParentProperty("To One Parent Property");
    basicFieldMetadata.setToOneTargetProperty("To One Target Property");
    basicFieldMetadata.setTooltip("127.0.0.1");
    basicFieldMetadata.setTranslatable(true);
    basicFieldMetadata.setUnique(true);
    basicFieldMetadata.setUseServerSideInspectionCache(true);
    HashMap<String, List<Map<String, String>>> validationConfigurations = new HashMap<>();
    basicFieldMetadata.setValidationConfigurations(validationConfigurations);
    basicFieldMetadata.setVisibility(VisibilityEnum.HIDDEN_ALL);
    String actualAssociatedFieldName = basicFieldMetadata.getAssociatedFieldName();
    String actualBroadleafEnumeration = basicFieldMetadata.getBroadleafEnumeration();
    Boolean actualCanLinkToExternalEntity = basicFieldMetadata.getCanLinkToExternalEntity();
    String actualColumnWidth = basicFieldMetadata.getColumnWidth();
    String[] actualCustomCriteria = basicFieldMetadata.getCustomCriteria();
    String actualDefaultValue = basicFieldMetadata.getDefaultValue();
    RuleBuilderDisplayType actualDisplayType = basicFieldMetadata.getDisplayType();
    Boolean actualEnableTypeaheadLookup = basicFieldMetadata.getEnableTypeaheadLookup();
    String actualEnumerationClass = basicFieldMetadata.getEnumerationClass();
    String[][] actualEnumerationValues = basicFieldMetadata.getEnumerationValues();
    SupportedFieldType actualExplicitFieldType = basicFieldMetadata.getExplicitFieldType();
    SupportedFieldType actualFieldComponentRenderer = basicFieldMetadata.getFieldComponentRenderer();
    String actualFieldComponentRendererTemplate = basicFieldMetadata.getFieldComponentRendererTemplate();
    SupportedFieldType actualFieldType = basicFieldMetadata.getFieldType();
    Boolean actualForcePopulateChildProperties = basicFieldMetadata.getForcePopulateChildProperties();
    String actualForeignKeyClass = basicFieldMetadata.getForeignKeyClass();
    String actualForeignKeyDisplayValueProperty = basicFieldMetadata.getForeignKeyDisplayValueProperty();
    String actualForeignKeyProperty = basicFieldMetadata.getForeignKeyProperty();
    SupportedFieldType actualGridFieldComponentRenderer = basicFieldMetadata.getGridFieldComponentRenderer();
    String actualGridFieldComponentRendererTemplate = basicFieldMetadata.getGridFieldComponentRendererTemplate();
    Integer actualGridOrder = basicFieldMetadata.getGridOrder();
    Boolean actualGroupCollapsed = basicFieldMetadata.getGroupCollapsed();
    String actualHelpText = basicFieldMetadata.getHelpText();
    Boolean actualHideEnumerationIfEmpty = basicFieldMetadata.getHideEnumerationIfEmpty();
    String actualHint = basicFieldMetadata.getHint();
    Boolean actualIsDerived = basicFieldMetadata.getIsDerived();
    Boolean actualIsFilter = basicFieldMetadata.getIsFilter();
    Integer actualLength = basicFieldMetadata.getLength();
    String actualLookupDisplayProperty = basicFieldMetadata.getLookupDisplayProperty();
    LookupType actualLookupType = basicFieldMetadata.getLookupType();
    String actualManyToField = basicFieldMetadata.getManyToField();
    String actualMapFieldValueClass = basicFieldMetadata.getMapFieldValueClass();
    String actualMapKeyValueProperty = basicFieldMetadata.getMapKeyValueProperty();
    MergedPropertyType actualMergedPropertyType = basicFieldMetadata.getMergedPropertyType();
    Boolean actualMutable = basicFieldMetadata.getMutable();
    String actualName = basicFieldMetadata.getName();
    Boolean actualOptionCanEditValues = basicFieldMetadata.getOptionCanEditValues();
    String actualOptionDisplayFieldName = basicFieldMetadata.getOptionDisplayFieldName();
    String[][] actualOptionFilterParams = basicFieldMetadata.getOptionFilterParams();
    Boolean actualOptionHideIfEmpty = basicFieldMetadata.getOptionHideIfEmpty();
    String actualOptionListEntity = basicFieldMetadata.getOptionListEntity();
    String actualOptionValueFieldName = basicFieldMetadata.getOptionValueFieldName();
    Integer actualPrecision = basicFieldMetadata.getPrecision();
    Boolean actualReadOnly = basicFieldMetadata.getReadOnly();
    Boolean actualRequiredOverride = basicFieldMetadata.getRequiredOverride();
    String actualRuleIdentifier = basicFieldMetadata.getRuleIdentifier();
    Integer actualScale = basicFieldMetadata.getScale();
    Boolean actualSearchable = basicFieldMetadata.getSearchable();
    SupportedFieldType actualSecondaryType = basicFieldMetadata.getSecondaryType();
    Boolean actualToOneLookupCreatedViaAnnotation = basicFieldMetadata.getToOneLookupCreatedViaAnnotation();
    String actualToOneParentProperty = basicFieldMetadata.getToOneParentProperty();
    String actualToOneTargetProperty = basicFieldMetadata.getToOneTargetProperty();
    basicFieldMetadata.getTooltip();
    Boolean actualTranslatable = basicFieldMetadata.getTranslatable();
    Boolean actualUnique = basicFieldMetadata.getUnique();
    Boolean actualUseServerSideInspectionCache = basicFieldMetadata.getUseServerSideInspectionCache();
    Map<String, List<Map<String, String>>> actualValidationConfigurations = basicFieldMetadata
        .getValidationConfigurations();
    VisibilityEnum actualVisibility = basicFieldMetadata.getVisibility();
    Boolean actualIsLargeEntryResult = basicFieldMetadata.isLargeEntry();
    Boolean actualIsProminentResult = basicFieldMetadata.isProminent();

    // Assert that nothing has changed
    assertEquals("42", actualDefaultValue);
    assertEquals("42", actualForeignKeyDisplayValueProperty);
    assertEquals("42", actualMapFieldValueClass);
    assertEquals("42", actualMapKeyValueProperty);
    assertEquals("42", actualOptionValueFieldName);
    assertEquals("42", actualRuleIdentifier);
    assertEquals("Associated Field Name", actualAssociatedFieldName);
    assertEquals("Broadleaf Enumeration", actualBroadleafEnumeration);
    assertEquals("Column Width", actualColumnWidth);
    assertEquals("Enumeration Class", actualEnumerationClass);
    assertEquals("Field Component Renderer Template", actualFieldComponentRendererTemplate);
    assertEquals("Foreign Key Class", actualForeignKeyClass);
    assertEquals("Foreign Key Property", actualForeignKeyProperty);
    assertEquals("Grid Field Component Renderer Template", actualGridFieldComponentRendererTemplate);
    assertEquals("Help Text", actualHelpText);
    assertEquals("Hint", actualHint);
    assertEquals("Lookup Display Property", actualLookupDisplayProperty);
    assertEquals("Many To Field", actualManyToField);
    assertEquals("Name", actualName);
    assertEquals("Option Display Field Name", actualOptionDisplayFieldName);
    assertEquals("Option List Entity", actualOptionListEntity);
    assertEquals("To One Parent Property", actualToOneParentProperty);
    assertEquals("To One Target Property", actualToOneTargetProperty);
    assertEquals(1, actualGridOrder.intValue());
    assertEquals(1, actualPrecision.intValue());
    assertEquals(1, actualScale.intValue());
    assertEquals(1, actualEnumerationValues.length);
    assertEquals(1, actualOptionFilterParams.length);
    assertEquals(3, actualLength.intValue());
    assertEquals(LookupType.STANDARD, actualLookupType);
    assertEquals(RuleBuilderDisplayType.NORMAL, actualDisplayType);
    assertEquals(SupportedFieldType.UNKNOWN, actualExplicitFieldType);
    assertEquals(SupportedFieldType.UNKNOWN, actualFieldComponentRenderer);
    assertEquals(SupportedFieldType.UNKNOWN, actualFieldType);
    assertEquals(SupportedFieldType.UNKNOWN, actualGridFieldComponentRenderer);
    assertEquals(SupportedFieldType.UNKNOWN, actualSecondaryType);
    assertEquals(VisibilityEnum.HIDDEN_ALL, actualVisibility);
    assertEquals(MergedPropertyType.PRIMARY, actualMergedPropertyType);
    assertTrue(actualValidationConfigurations.isEmpty());
    assertTrue(actualCanLinkToExternalEntity);
    assertTrue(actualEnableTypeaheadLookup);
    assertTrue(actualForcePopulateChildProperties);
    assertTrue(actualGroupCollapsed);
    assertTrue(actualHideEnumerationIfEmpty);
    assertTrue(actualIsDerived);
    assertTrue(actualIsFilter);
    assertTrue(actualMutable);
    assertTrue(actualOptionCanEditValues);
    assertTrue(actualOptionHideIfEmpty);
    assertTrue(actualReadOnly);
    assertTrue(actualRequiredOverride);
    assertTrue(actualSearchable);
    assertTrue(actualToOneLookupCreatedViaAnnotation);
    assertTrue(actualTranslatable);
    assertTrue(actualUnique);
    assertTrue(actualUseServerSideInspectionCache);
    assertTrue(actualIsLargeEntryResult);
    assertTrue(actualIsProminentResult);
    assertSame(validationConfigurations, actualValidationConfigurations);
    assertSame(customCriteria, actualCustomCriteria);
    assertSame(enumerationValues, actualEnumerationValues);
    assertSame(optionFilterParams, actualOptionFilterParams);
    assertArrayEquals(new String[]{"42"}, actualEnumerationValues[0]);
    assertArrayEquals(new String[]{"Custom Criteria"}, actualCustomCriteria);
    assertArrayEquals(new String[]{"Option Filter Params"}, actualOptionFilterParams[0]);
  }

  /**
   * Test {@link BasicFieldMetadata#getAllowNoValueEnumOption()}.
   * <p>
   * Method under test: {@link BasicFieldMetadata#getAllowNoValueEnumOption()}
   */
  @Test
  public void testGetAllowNoValueEnumOption() {
    // Arrange
    BasicFieldMetadata basicFieldMetadata = new BasicFieldMetadata();
    basicFieldMetadata.setAllowNoValueEnumOption(true);
    basicFieldMetadata.setRequiredOverride(null);
    basicFieldMetadata.setRequired(null);
    basicFieldMetadata.setDefaultValue(null);

    // Act and Assert
    assertTrue(basicFieldMetadata.getAllowNoValueEnumOption());
  }

  /**
   * Test {@link BasicFieldMetadata#getAllowNoValueEnumOption()}.
   * <p>
   * Method under test: {@link BasicFieldMetadata#getAllowNoValueEnumOption()}
   */
  @Test
  public void testGetAllowNoValueEnumOption2() {
    // Arrange
    BasicFieldMetadata basicFieldMetadata = new BasicFieldMetadata();
    basicFieldMetadata.setAllowNoValueEnumOption(false);
    basicFieldMetadata.setRequiredOverride(null);
    basicFieldMetadata.setRequired(null);
    basicFieldMetadata.setDefaultValue("foo");

    // Act and Assert
    assertFalse(basicFieldMetadata.getAllowNoValueEnumOption());
  }

  /**
   * Test {@link BasicFieldMetadata#getAllowNoValueEnumOption()}.
   * <ul>
   *   <li>Given {@link BasicFieldMetadata} (default constructor) DefaultValue is
   * empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicFieldMetadata#getAllowNoValueEnumOption()}
   */
  @Test
  public void testGetAllowNoValueEnumOption_givenBasicFieldMetadataDefaultValueIsEmptyString() {
    // Arrange
    BasicFieldMetadata basicFieldMetadata = new BasicFieldMetadata();
    basicFieldMetadata.setAllowNoValueEnumOption(null);
    basicFieldMetadata.setRequiredOverride(null);
    basicFieldMetadata.setRequired(null);
    basicFieldMetadata.setDefaultValue("");

    // Act and Assert
    assertTrue(basicFieldMetadata.getAllowNoValueEnumOption());
  }

  /**
   * Test {@link BasicFieldMetadata#getAllowNoValueEnumOption()}.
   * <ul>
   *   <li>Given {@link BasicFieldMetadata} (default constructor) DefaultValue is
   * {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicFieldMetadata#getAllowNoValueEnumOption()}
   */
  @Test
  public void testGetAllowNoValueEnumOption_givenBasicFieldMetadataDefaultValueIsFoo() {
    // Arrange
    BasicFieldMetadata basicFieldMetadata = new BasicFieldMetadata();
    basicFieldMetadata.setAllowNoValueEnumOption(null);
    basicFieldMetadata.setRequiredOverride(null);
    basicFieldMetadata.setRequired(null);
    basicFieldMetadata.setDefaultValue("foo");

    // Act and Assert
    assertFalse(basicFieldMetadata.getAllowNoValueEnumOption());
  }

  /**
   * Test {@link BasicFieldMetadata#getAllowNoValueEnumOption()}.
   * <ul>
   *   <li>Given {@link BasicFieldMetadata} (default constructor) Required is
   * {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicFieldMetadata#getAllowNoValueEnumOption()}
   */
  @Test
  public void testGetAllowNoValueEnumOption_givenBasicFieldMetadataRequiredIsTrue() {
    // Arrange
    BasicFieldMetadata basicFieldMetadata = new BasicFieldMetadata();
    basicFieldMetadata.setAllowNoValueEnumOption(null);
    basicFieldMetadata.setRequiredOverride(null);
    basicFieldMetadata.setRequired(true);
    basicFieldMetadata.setDefaultValue(null);

    // Act and Assert
    assertFalse(basicFieldMetadata.getAllowNoValueEnumOption());
  }

  /**
   * Test {@link BasicFieldMetadata#getAllowNoValueEnumOption()}.
   * <ul>
   *   <li>Given {@link BasicFieldMetadata} (default constructor) RequiredOverride
   * is {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicFieldMetadata#getAllowNoValueEnumOption()}
   */
  @Test
  public void testGetAllowNoValueEnumOption_givenBasicFieldMetadataRequiredOverrideIsFalse() {
    // Arrange
    BasicFieldMetadata basicFieldMetadata = new BasicFieldMetadata();
    basicFieldMetadata.setAllowNoValueEnumOption(null);
    basicFieldMetadata.setRequiredOverride(false);
    basicFieldMetadata.setRequired(null);
    basicFieldMetadata.setDefaultValue("");

    // Act and Assert
    assertTrue(basicFieldMetadata.getAllowNoValueEnumOption());
  }

  /**
   * Test {@link BasicFieldMetadata#getAllowNoValueEnumOption()}.
   * <ul>
   *   <li>Given {@link BasicFieldMetadata} (default constructor) RequiredOverride
   * is {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicFieldMetadata#getAllowNoValueEnumOption()}
   */
  @Test
  public void testGetAllowNoValueEnumOption_givenBasicFieldMetadataRequiredOverrideIsTrue() {
    // Arrange
    BasicFieldMetadata basicFieldMetadata = new BasicFieldMetadata();
    basicFieldMetadata.setAllowNoValueEnumOption(null);
    basicFieldMetadata.setRequiredOverride(true);
    basicFieldMetadata.setRequired(null);
    basicFieldMetadata.setDefaultValue(null);

    // Act and Assert
    assertFalse(basicFieldMetadata.getAllowNoValueEnumOption());
  }

  /**
   * Test {@link BasicFieldMetadata#getAllowNoValueEnumOption()}.
   * <ul>
   *   <li>Given {@link BasicFieldMetadata} (default constructor).</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicFieldMetadata#getAllowNoValueEnumOption()}
   */
  @Test
  public void testGetAllowNoValueEnumOption_givenBasicFieldMetadata_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue((new BasicFieldMetadata()).getAllowNoValueEnumOption());
  }

  /**
   * Test {@link BasicFieldMetadata#cloneFieldMetadata()}.
   * <p>
   * Method under test: {@link BasicFieldMetadata#cloneFieldMetadata()}
   */
  @Test
  public void testCloneFieldMetadata() {
    // Arrange
    BasicFieldMetadata basicFieldMetadata = new BasicFieldMetadata();
    basicFieldMetadata.setEnumerationValues(null);
    basicFieldMetadata.setOptionFilterParams(new String[][]{new String[]{"foo"}});

    // Act
    FieldMetadata actualCloneFieldMetadataResult = basicFieldMetadata.cloneFieldMetadata();

    // Assert
    assertTrue(actualCloneFieldMetadataResult instanceof BasicFieldMetadata);
    assertNull(actualCloneFieldMetadataResult.getAvailableToTypes());
    assertNull(((BasicFieldMetadata) actualCloneFieldMetadataResult).getEnumerationValues());
    String[][] optionFilterParams = ((BasicFieldMetadata) actualCloneFieldMetadataResult).getOptionFilterParams();
    assertEquals(1, optionFilterParams.length);
    assertArrayEquals(new String[]{"foo"}, optionFilterParams[0]);
  }

  /**
   * Test {@link BasicFieldMetadata#cloneFieldMetadata()}.
   * <p>
   * Method under test: {@link BasicFieldMetadata#cloneFieldMetadata()}
   */
  @Test
  public void testCloneFieldMetadata2() {
    // Arrange
    BasicFieldMetadata basicFieldMetadata = new BasicFieldMetadata();
    basicFieldMetadata.setEnumerationValues(new String[][]{new String[]{"foo"}});
    basicFieldMetadata.setOptionFilterParams(null);

    // Act
    FieldMetadata actualCloneFieldMetadataResult = basicFieldMetadata.cloneFieldMetadata();

    // Assert
    assertTrue(actualCloneFieldMetadataResult instanceof BasicFieldMetadata);
    assertNull(actualCloneFieldMetadataResult.getAvailableToTypes());
    assertNull(((BasicFieldMetadata) actualCloneFieldMetadataResult).getOptionFilterParams());
    String[][] enumerationValues = ((BasicFieldMetadata) actualCloneFieldMetadataResult).getEnumerationValues();
    assertEquals(1, enumerationValues.length);
    assertArrayEquals(new String[]{"foo"}, enumerationValues[0]);
  }

  /**
   * Test {@link BasicFieldMetadata#cloneFieldMetadata()}.
   * <p>
   * Method under test: {@link BasicFieldMetadata#cloneFieldMetadata()}
   */
  @Test
  public void testCloneFieldMetadata3() {
    // Arrange
    BasicFieldMetadata basicFieldMetadata = new BasicFieldMetadata();
    basicFieldMetadata.setAvailableToTypes(new String[]{"Available To Types"});

    // Act
    FieldMetadata actualCloneFieldMetadataResult = basicFieldMetadata.cloneFieldMetadata();

    // Assert
    assertTrue(actualCloneFieldMetadataResult instanceof BasicFieldMetadata);
    assertNull(((BasicFieldMetadata) actualCloneFieldMetadataResult).getEnumerationValues());
    assertNull(((BasicFieldMetadata) actualCloneFieldMetadataResult).getOptionFilterParams());
    assertArrayEquals(new String[]{"Available To Types"}, actualCloneFieldMetadataResult.getAvailableToTypes());
  }

  /**
   * Test {@link BasicFieldMetadata#cloneFieldMetadata()}.
   * <ul>
   *   <li>Given {@link BasicFieldMetadata} (default constructor).</li>
   *   <li>Then return {@link BasicFieldMetadata} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicFieldMetadata#cloneFieldMetadata()}
   */
  @Test
  public void testCloneFieldMetadata_givenBasicFieldMetadata_thenReturnBasicFieldMetadata() {
    // Arrange
    BasicFieldMetadata basicFieldMetadata = new BasicFieldMetadata();

    // Act
    FieldMetadata actualCloneFieldMetadataResult = basicFieldMetadata.cloneFieldMetadata();

    // Assert
    assertTrue(actualCloneFieldMetadataResult instanceof BasicFieldMetadata);
    assertEquals(basicFieldMetadata, actualCloneFieldMetadataResult);
  }

  /**
   * Test {@link BasicFieldMetadata#accept(MetadataVisitor)}.
   * <ul>
   *   <li>When {@link MetadataVisitorAdapter}
   * {@link MetadataVisitorAdapter#visit(BasicFieldMetadata)} does nothing.</li>
   *   <li>Then calls {@link MetadataVisitorAdapter#visit(BasicFieldMetadata)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicFieldMetadata#accept(MetadataVisitor)}
   */
  @Test
  public void testAccept_whenMetadataVisitorAdapterVisitDoesNothing_thenCallsVisit() {
    // Arrange
    BasicFieldMetadata basicFieldMetadata = new BasicFieldMetadata();
    MetadataVisitorAdapter visitor = mock(MetadataVisitorAdapter.class);
    doNothing().when(visitor).visit(Mockito.<BasicFieldMetadata>any());

    // Act
    basicFieldMetadata.accept(visitor);

    // Assert
    verify(visitor).visit(isA(BasicFieldMetadata.class));
  }

  /**
   * Test {@link BasicFieldMetadata#equals(Object)}, and
   * {@link BasicFieldMetadata#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link BasicFieldMetadata#equals(Object)}
   *   <li>{@link BasicFieldMetadata#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    BasicFieldMetadata basicFieldMetadata = new BasicFieldMetadata();
    BasicFieldMetadata basicFieldMetadata2 = new BasicFieldMetadata();

    // Act and Assert
    assertEquals(basicFieldMetadata, basicFieldMetadata2);
    int expectedHashCodeResult = basicFieldMetadata.hashCode();
    assertEquals(expectedHashCodeResult, basicFieldMetadata2.hashCode());
  }

  /**
   * Test {@link BasicFieldMetadata#equals(Object)}, and
   * {@link BasicFieldMetadata#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link BasicFieldMetadata#equals(Object)}
   *   <li>{@link BasicFieldMetadata#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    BasicFieldMetadata basicFieldMetadata = new BasicFieldMetadata();
    basicFieldMetadata.setLength(3);

    BasicFieldMetadata basicFieldMetadata2 = new BasicFieldMetadata();
    basicFieldMetadata2.setLength(3);

    // Act and Assert
    assertEquals(basicFieldMetadata, basicFieldMetadata2);
    int expectedHashCodeResult = basicFieldMetadata.hashCode();
    assertEquals(expectedHashCodeResult, basicFieldMetadata2.hashCode());
  }

  /**
   * Test {@link BasicFieldMetadata#equals(Object)}, and
   * {@link BasicFieldMetadata#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link BasicFieldMetadata#equals(Object)}
   *   <li>{@link BasicFieldMetadata#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    BasicFieldMetadata basicFieldMetadata = new BasicFieldMetadata();
    basicFieldMetadata.setRequired(true);

    BasicFieldMetadata basicFieldMetadata2 = new BasicFieldMetadata();
    basicFieldMetadata2.setRequired(true);

    // Act and Assert
    assertEquals(basicFieldMetadata, basicFieldMetadata2);
    int expectedHashCodeResult = basicFieldMetadata.hashCode();
    assertEquals(expectedHashCodeResult, basicFieldMetadata2.hashCode());
  }

  /**
   * Test {@link BasicFieldMetadata#equals(Object)}, and
   * {@link BasicFieldMetadata#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link BasicFieldMetadata#equals(Object)}
   *   <li>{@link BasicFieldMetadata#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    BasicFieldMetadata basicFieldMetadata = new BasicFieldMetadata();
    basicFieldMetadata.setScale(1);

    BasicFieldMetadata basicFieldMetadata2 = new BasicFieldMetadata();
    basicFieldMetadata2.setScale(1);

    // Act and Assert
    assertEquals(basicFieldMetadata, basicFieldMetadata2);
    int expectedHashCodeResult = basicFieldMetadata.hashCode();
    assertEquals(expectedHashCodeResult, basicFieldMetadata2.hashCode());
  }

  /**
   * Test {@link BasicFieldMetadata#equals(Object)}, and
   * {@link BasicFieldMetadata#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link BasicFieldMetadata#equals(Object)}
   *   <li>{@link BasicFieldMetadata#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual5() {
    // Arrange
    BasicFieldMetadata basicFieldMetadata = new BasicFieldMetadata();
    basicFieldMetadata.setPrecision(1);

    BasicFieldMetadata basicFieldMetadata2 = new BasicFieldMetadata();
    basicFieldMetadata2.setPrecision(1);

    // Act and Assert
    assertEquals(basicFieldMetadata, basicFieldMetadata2);
    int expectedHashCodeResult = basicFieldMetadata.hashCode();
    assertEquals(expectedHashCodeResult, basicFieldMetadata2.hashCode());
  }

  /**
   * Test {@link BasicFieldMetadata#equals(Object)}, and
   * {@link BasicFieldMetadata#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link BasicFieldMetadata#equals(Object)}
   *   <li>{@link BasicFieldMetadata#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual6() {
    // Arrange
    BasicFieldMetadata basicFieldMetadata = new BasicFieldMetadata();
    basicFieldMetadata.setUnique(true);

    BasicFieldMetadata basicFieldMetadata2 = new BasicFieldMetadata();
    basicFieldMetadata2.setUnique(true);

    // Act and Assert
    assertEquals(basicFieldMetadata, basicFieldMetadata2);
    int expectedHashCodeResult = basicFieldMetadata.hashCode();
    assertEquals(expectedHashCodeResult, basicFieldMetadata2.hashCode());
  }

  /**
   * Test {@link BasicFieldMetadata#equals(Object)}, and
   * {@link BasicFieldMetadata#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link BasicFieldMetadata#equals(Object)}
   *   <li>{@link BasicFieldMetadata#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual7() {
    // Arrange
    BasicFieldMetadata basicFieldMetadata = new BasicFieldMetadata();
    basicFieldMetadata.setMutable(true);

    BasicFieldMetadata basicFieldMetadata2 = new BasicFieldMetadata();
    basicFieldMetadata2.setMutable(true);

    // Act and Assert
    assertEquals(basicFieldMetadata, basicFieldMetadata2);
    int expectedHashCodeResult = basicFieldMetadata.hashCode();
    assertEquals(expectedHashCodeResult, basicFieldMetadata2.hashCode());
  }

  /**
   * Test {@link BasicFieldMetadata#equals(Object)}, and
   * {@link BasicFieldMetadata#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link BasicFieldMetadata#equals(Object)}
   *   <li>{@link BasicFieldMetadata#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual8() {
    // Arrange
    BasicFieldMetadata basicFieldMetadata = new BasicFieldMetadata();
    basicFieldMetadata.setForeignKeyProperty("Foreign Key Property");

    BasicFieldMetadata basicFieldMetadata2 = new BasicFieldMetadata();
    basicFieldMetadata2.setForeignKeyProperty("Foreign Key Property");

    // Act and Assert
    assertEquals(basicFieldMetadata, basicFieldMetadata2);
    int expectedHashCodeResult = basicFieldMetadata.hashCode();
    assertEquals(expectedHashCodeResult, basicFieldMetadata2.hashCode());
  }

  /**
   * Test {@link BasicFieldMetadata#equals(Object)}, and
   * {@link BasicFieldMetadata#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link BasicFieldMetadata#equals(Object)}
   *   <li>{@link BasicFieldMetadata#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual9() {
    // Arrange
    BasicFieldMetadata basicFieldMetadata = new BasicFieldMetadata();
    basicFieldMetadata.setForeignKeyClass("Foreign Key Class");

    BasicFieldMetadata basicFieldMetadata2 = new BasicFieldMetadata();
    basicFieldMetadata2.setForeignKeyClass("Foreign Key Class");

    // Act and Assert
    assertEquals(basicFieldMetadata, basicFieldMetadata2);
    int expectedHashCodeResult = basicFieldMetadata.hashCode();
    assertEquals(expectedHashCodeResult, basicFieldMetadata2.hashCode());
  }

  /**
   * Test {@link BasicFieldMetadata#equals(Object)}, and
   * {@link BasicFieldMetadata#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link BasicFieldMetadata#equals(Object)}
   *   <li>{@link BasicFieldMetadata#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual10() {
    // Arrange
    BasicFieldMetadata basicFieldMetadata = new BasicFieldMetadata();
    basicFieldMetadata.setForeignKeyCollection(true);

    BasicFieldMetadata basicFieldMetadata2 = new BasicFieldMetadata();
    basicFieldMetadata2.setForeignKeyCollection(true);

    // Act and Assert
    assertEquals(basicFieldMetadata, basicFieldMetadata2);
    int expectedHashCodeResult = basicFieldMetadata.hashCode();
    assertEquals(expectedHashCodeResult, basicFieldMetadata2.hashCode());
  }

  /**
   * Test {@link BasicFieldMetadata#equals(Object)}, and
   * {@link BasicFieldMetadata#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link BasicFieldMetadata#equals(Object)}
   *   <li>{@link BasicFieldMetadata#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual11() {
    // Arrange
    BasicFieldMetadata basicFieldMetadata = new BasicFieldMetadata();
    basicFieldMetadata.setForeignKeyDisplayValueProperty("42");

    BasicFieldMetadata basicFieldMetadata2 = new BasicFieldMetadata();
    basicFieldMetadata2.setForeignKeyDisplayValueProperty("42");

    // Act and Assert
    assertEquals(basicFieldMetadata, basicFieldMetadata2);
    int expectedHashCodeResult = basicFieldMetadata.hashCode();
    assertEquals(expectedHashCodeResult, basicFieldMetadata2.hashCode());
  }

  /**
   * Test {@link BasicFieldMetadata#equals(Object)}, and
   * {@link BasicFieldMetadata#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link BasicFieldMetadata#equals(Object)}
   *   <li>{@link BasicFieldMetadata#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual12() {
    // Arrange
    BasicFieldMetadata basicFieldMetadata = new BasicFieldMetadata();
    basicFieldMetadata.setEnumerationClass("Enumeration Class");

    BasicFieldMetadata basicFieldMetadata2 = new BasicFieldMetadata();
    basicFieldMetadata2.setEnumerationClass("Enumeration Class");

    // Act and Assert
    assertEquals(basicFieldMetadata, basicFieldMetadata2);
    int expectedHashCodeResult = basicFieldMetadata.hashCode();
    assertEquals(expectedHashCodeResult, basicFieldMetadata2.hashCode());
  }

  /**
   * Test {@link BasicFieldMetadata#equals(Object)}, and
   * {@link BasicFieldMetadata#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link BasicFieldMetadata#equals(Object)}
   *   <li>{@link BasicFieldMetadata#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual13() {
    // Arrange
    BasicFieldMetadata basicFieldMetadata = new BasicFieldMetadata();
    basicFieldMetadata.setDerived(true);

    BasicFieldMetadata basicFieldMetadata2 = new BasicFieldMetadata();
    basicFieldMetadata2.setDerived(true);

    // Act and Assert
    assertEquals(basicFieldMetadata, basicFieldMetadata2);
    int expectedHashCodeResult = basicFieldMetadata.hashCode();
    assertEquals(expectedHashCodeResult, basicFieldMetadata2.hashCode());
  }

  /**
   * Test {@link BasicFieldMetadata#equals(Object)}, and
   * {@link BasicFieldMetadata#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link BasicFieldMetadata#equals(Object)}
   *   <li>{@link BasicFieldMetadata#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual14() {
    // Arrange
    BasicFieldMetadata basicFieldMetadata = new BasicFieldMetadata();
    basicFieldMetadata.setName("Name");

    BasicFieldMetadata basicFieldMetadata2 = new BasicFieldMetadata();
    basicFieldMetadata2.setName("Name");

    // Act and Assert
    assertEquals(basicFieldMetadata, basicFieldMetadata2);
    int expectedHashCodeResult = basicFieldMetadata.hashCode();
    assertEquals(expectedHashCodeResult, basicFieldMetadata2.hashCode());
  }

  /**
   * Test {@link BasicFieldMetadata#equals(Object)}, and
   * {@link BasicFieldMetadata#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link BasicFieldMetadata#equals(Object)}
   *   <li>{@link BasicFieldMetadata#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual15() {
    // Arrange
    BasicFieldMetadata basicFieldMetadata = new BasicFieldMetadata();
    basicFieldMetadata.setLargeEntry(true);

    BasicFieldMetadata basicFieldMetadata2 = new BasicFieldMetadata();
    basicFieldMetadata2.setLargeEntry(true);

    // Act and Assert
    assertEquals(basicFieldMetadata, basicFieldMetadata2);
    int expectedHashCodeResult = basicFieldMetadata.hashCode();
    assertEquals(expectedHashCodeResult, basicFieldMetadata2.hashCode());
  }

  /**
   * Test {@link BasicFieldMetadata#equals(Object)}, and
   * {@link BasicFieldMetadata#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link BasicFieldMetadata#equals(Object)}
   *   <li>{@link BasicFieldMetadata#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual16() {
    // Arrange
    BasicFieldMetadata basicFieldMetadata = new BasicFieldMetadata();
    basicFieldMetadata.setProminent(true);

    BasicFieldMetadata basicFieldMetadata2 = new BasicFieldMetadata();
    basicFieldMetadata2.setProminent(true);

    // Act and Assert
    assertEquals(basicFieldMetadata, basicFieldMetadata2);
    int expectedHashCodeResult = basicFieldMetadata.hashCode();
    assertEquals(expectedHashCodeResult, basicFieldMetadata2.hashCode());
  }

  /**
   * Test {@link BasicFieldMetadata#equals(Object)}, and
   * {@link BasicFieldMetadata#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link BasicFieldMetadata#equals(Object)}
   *   <li>{@link BasicFieldMetadata#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual17() {
    // Arrange
    BasicFieldMetadata basicFieldMetadata = new BasicFieldMetadata();
    basicFieldMetadata.setColumnWidth("Column Width");

    BasicFieldMetadata basicFieldMetadata2 = new BasicFieldMetadata();
    basicFieldMetadata2.setColumnWidth("Column Width");

    // Act and Assert
    assertEquals(basicFieldMetadata, basicFieldMetadata2);
    int expectedHashCodeResult = basicFieldMetadata.hashCode();
    assertEquals(expectedHashCodeResult, basicFieldMetadata2.hashCode());
  }

  /**
   * Test {@link BasicFieldMetadata#equals(Object)}, and
   * {@link BasicFieldMetadata#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link BasicFieldMetadata#equals(Object)}
   *   <li>{@link BasicFieldMetadata#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual18() {
    // Arrange
    BasicFieldMetadata basicFieldMetadata = new BasicFieldMetadata();
    basicFieldMetadata.setBroadleafEnumeration("Broadleaf Enumeration");

    BasicFieldMetadata basicFieldMetadata2 = new BasicFieldMetadata();
    basicFieldMetadata2.setBroadleafEnumeration("Broadleaf Enumeration");

    // Act and Assert
    assertEquals(basicFieldMetadata, basicFieldMetadata2);
    int expectedHashCodeResult = basicFieldMetadata.hashCode();
    assertEquals(expectedHashCodeResult, basicFieldMetadata2.hashCode());
  }

  /**
   * Test {@link BasicFieldMetadata#equals(Object)}, and
   * {@link BasicFieldMetadata#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link BasicFieldMetadata#equals(Object)}
   *   <li>{@link BasicFieldMetadata#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual19() {
    // Arrange
    BasicFieldMetadata basicFieldMetadata = new BasicFieldMetadata();
    basicFieldMetadata.setHideEnumerationIfEmpty(true);

    BasicFieldMetadata basicFieldMetadata2 = new BasicFieldMetadata();
    basicFieldMetadata2.setHideEnumerationIfEmpty(true);

    // Act and Assert
    assertEquals(basicFieldMetadata, basicFieldMetadata2);
    int expectedHashCodeResult = basicFieldMetadata.hashCode();
    assertEquals(expectedHashCodeResult, basicFieldMetadata2.hashCode());
  }

  /**
   * Test {@link BasicFieldMetadata#equals(Object)}, and
   * {@link BasicFieldMetadata#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link BasicFieldMetadata#equals(Object)}
   *   <li>{@link BasicFieldMetadata#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    BasicFieldMetadata basicFieldMetadata = new BasicFieldMetadata();

    // Act and Assert
    assertEquals(basicFieldMetadata, basicFieldMetadata);
    int expectedHashCodeResult = basicFieldMetadata.hashCode();
    assertEquals(expectedHashCodeResult, basicFieldMetadata.hashCode());
  }

  /**
   * Test {@link BasicFieldMetadata#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicFieldMetadata#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new BasicFieldMetadata(), 1);
    assertNotEquals(new BasicFieldMetadata(), mock(AdornedTargetCollectionMetadata.class));
  }

  /**
   * Test {@link BasicFieldMetadata#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicFieldMetadata#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    BasicFieldMetadata basicFieldMetadata = new BasicFieldMetadata();
    basicFieldMetadata.setFieldType(SupportedFieldType.UNKNOWN);

    // Act and Assert
    assertNotEquals(basicFieldMetadata, new BasicFieldMetadata());
  }

  /**
   * Test {@link BasicFieldMetadata#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicFieldMetadata#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    BasicFieldMetadata basicFieldMetadata = new BasicFieldMetadata();
    basicFieldMetadata.setSecondaryType(SupportedFieldType.UNKNOWN);

    // Act and Assert
    assertNotEquals(basicFieldMetadata, new BasicFieldMetadata());
  }

  /**
   * Test {@link BasicFieldMetadata#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicFieldMetadata#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    BasicFieldMetadata basicFieldMetadata = new BasicFieldMetadata();
    basicFieldMetadata.setLength(3);

    // Act and Assert
    assertNotEquals(basicFieldMetadata, new BasicFieldMetadata());
  }

  /**
   * Test {@link BasicFieldMetadata#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicFieldMetadata#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    BasicFieldMetadata basicFieldMetadata = new BasicFieldMetadata();
    basicFieldMetadata.setRequired(true);

    // Act and Assert
    assertNotEquals(basicFieldMetadata, new BasicFieldMetadata());
  }

  /**
   * Test {@link BasicFieldMetadata#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicFieldMetadata#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    BasicFieldMetadata basicFieldMetadata = new BasicFieldMetadata();
    basicFieldMetadata.setScale(1);

    // Act and Assert
    assertNotEquals(basicFieldMetadata, new BasicFieldMetadata());
  }

  /**
   * Test {@link BasicFieldMetadata#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicFieldMetadata#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    BasicFieldMetadata basicFieldMetadata = new BasicFieldMetadata();
    basicFieldMetadata.setPrecision(1);

    // Act and Assert
    assertNotEquals(basicFieldMetadata, new BasicFieldMetadata());
  }

  /**
   * Test {@link BasicFieldMetadata#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicFieldMetadata#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    BasicFieldMetadata basicFieldMetadata = new BasicFieldMetadata();
    basicFieldMetadata.setUnique(true);

    // Act and Assert
    assertNotEquals(basicFieldMetadata, new BasicFieldMetadata());
  }

  /**
   * Test {@link BasicFieldMetadata#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicFieldMetadata#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    BasicFieldMetadata basicFieldMetadata = new BasicFieldMetadata();
    basicFieldMetadata.setMutable(true);

    // Act and Assert
    assertNotEquals(basicFieldMetadata, new BasicFieldMetadata());
  }

  /**
   * Test {@link BasicFieldMetadata#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicFieldMetadata#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    BasicFieldMetadata basicFieldMetadata = new BasicFieldMetadata();
    basicFieldMetadata.setForeignKeyProperty("Foreign Key Property");

    // Act and Assert
    assertNotEquals(basicFieldMetadata, new BasicFieldMetadata());
  }

  /**
   * Test {@link BasicFieldMetadata#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicFieldMetadata#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    BasicFieldMetadata basicFieldMetadata = new BasicFieldMetadata();
    basicFieldMetadata.setForeignKeyClass("Foreign Key Class");

    // Act and Assert
    assertNotEquals(basicFieldMetadata, new BasicFieldMetadata());
  }

  /**
   * Test {@link BasicFieldMetadata#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicFieldMetadata#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
    // Arrange
    BasicFieldMetadata basicFieldMetadata = new BasicFieldMetadata();
    basicFieldMetadata.setForeignKeyCollection(true);

    // Act and Assert
    assertNotEquals(basicFieldMetadata, new BasicFieldMetadata());
  }

  /**
   * Test {@link BasicFieldMetadata#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicFieldMetadata#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual13() {
    // Arrange
    BasicFieldMetadata basicFieldMetadata = new BasicFieldMetadata();
    basicFieldMetadata.setMergedPropertyType(MergedPropertyType.PRIMARY);

    // Act and Assert
    assertNotEquals(basicFieldMetadata, new BasicFieldMetadata());
  }

  /**
   * Test {@link BasicFieldMetadata#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicFieldMetadata#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual14() {
    // Arrange
    BasicFieldMetadata basicFieldMetadata = new BasicFieldMetadata();
    basicFieldMetadata.setForeignKeyDisplayValueProperty("42");

    // Act and Assert
    assertNotEquals(basicFieldMetadata, new BasicFieldMetadata());
  }

  /**
   * Test {@link BasicFieldMetadata#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicFieldMetadata#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual15() {
    // Arrange
    BasicFieldMetadata basicFieldMetadata = new BasicFieldMetadata();
    basicFieldMetadata.setEnumerationClass("Enumeration Class");

    // Act and Assert
    assertNotEquals(basicFieldMetadata, new BasicFieldMetadata());
  }

  /**
   * Test {@link BasicFieldMetadata#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicFieldMetadata#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual16() {
    // Arrange
    BasicFieldMetadata basicFieldMetadata = new BasicFieldMetadata();
    basicFieldMetadata.setDerived(true);

    // Act and Assert
    assertNotEquals(basicFieldMetadata, new BasicFieldMetadata());
  }

  /**
   * Test {@link BasicFieldMetadata#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicFieldMetadata#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual17() {
    // Arrange
    BasicFieldMetadata basicFieldMetadata = new BasicFieldMetadata();
    basicFieldMetadata.setName("Name");

    // Act and Assert
    assertNotEquals(basicFieldMetadata, new BasicFieldMetadata());
  }

  /**
   * Test {@link BasicFieldMetadata#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicFieldMetadata#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual18() {
    // Arrange
    BasicFieldMetadata basicFieldMetadata = new BasicFieldMetadata();
    basicFieldMetadata.setExplicitFieldType(SupportedFieldType.UNKNOWN);

    // Act and Assert
    assertNotEquals(basicFieldMetadata, new BasicFieldMetadata());
  }

  /**
   * Test {@link BasicFieldMetadata#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicFieldMetadata#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual19() {
    // Arrange
    BasicFieldMetadata basicFieldMetadata = new BasicFieldMetadata();
    basicFieldMetadata.setDisplayType(RuleBuilderDisplayType.NORMAL);

    // Act and Assert
    assertNotEquals(basicFieldMetadata, new BasicFieldMetadata());
  }

  /**
   * Test {@link BasicFieldMetadata#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicFieldMetadata#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual20() {
    // Arrange
    BasicFieldMetadata basicFieldMetadata = new BasicFieldMetadata();
    basicFieldMetadata.setLargeEntry(true);

    // Act and Assert
    assertNotEquals(basicFieldMetadata, new BasicFieldMetadata());
  }

  /**
   * Test {@link BasicFieldMetadata#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicFieldMetadata#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual21() {
    // Arrange
    BasicFieldMetadata basicFieldMetadata = new BasicFieldMetadata();
    basicFieldMetadata.setProminent(true);

    // Act and Assert
    assertNotEquals(basicFieldMetadata, new BasicFieldMetadata());
  }

  /**
   * Test {@link BasicFieldMetadata#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicFieldMetadata#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual22() {
    // Arrange
    BasicFieldMetadata basicFieldMetadata = new BasicFieldMetadata();
    basicFieldMetadata.setColumnWidth("Column Width");

    // Act and Assert
    assertNotEquals(basicFieldMetadata, new BasicFieldMetadata());
  }

  /**
   * Test {@link BasicFieldMetadata#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicFieldMetadata#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual23() {
    // Arrange
    BasicFieldMetadata basicFieldMetadata = new BasicFieldMetadata();
    basicFieldMetadata.setBroadleafEnumeration("Broadleaf Enumeration");

    // Act and Assert
    assertNotEquals(basicFieldMetadata, new BasicFieldMetadata());
  }

  /**
   * Test {@link BasicFieldMetadata#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicFieldMetadata#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual24() {
    // Arrange
    BasicFieldMetadata basicFieldMetadata = new BasicFieldMetadata();
    basicFieldMetadata.setHideEnumerationIfEmpty(true);

    // Act and Assert
    assertNotEquals(basicFieldMetadata, new BasicFieldMetadata());
  }

  /**
   * Test {@link BasicFieldMetadata#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicFieldMetadata#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual25() {
    // Arrange
    BasicFieldMetadata basicFieldMetadata = new BasicFieldMetadata();
    basicFieldMetadata.setFieldComponentRenderer(SupportedFieldType.UNKNOWN);

    // Act and Assert
    assertNotEquals(basicFieldMetadata, new BasicFieldMetadata());
  }

  /**
   * Test {@link BasicFieldMetadata#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicFieldMetadata#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual26() {
    // Arrange
    BasicFieldMetadata basicFieldMetadata = new BasicFieldMetadata();
    basicFieldMetadata.setGridFieldComponentRenderer(SupportedFieldType.UNKNOWN);

    // Act and Assert
    assertNotEquals(basicFieldMetadata, new BasicFieldMetadata());
  }

  /**
   * Test {@link BasicFieldMetadata#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicFieldMetadata#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual27() {
    // Arrange
    BasicFieldMetadata basicFieldMetadata = new BasicFieldMetadata();
    basicFieldMetadata.setFieldComponentRendererTemplate("Field Component Renderer Template");

    // Act and Assert
    assertNotEquals(basicFieldMetadata, new BasicFieldMetadata());
  }

  /**
   * Test {@link BasicFieldMetadata#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicFieldMetadata#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual28() {
    // Arrange
    BasicFieldMetadata basicFieldMetadata = new BasicFieldMetadata();
    basicFieldMetadata.setGridFieldComponentRendererTemplate("Grid Field Component Renderer Template");

    // Act and Assert
    assertNotEquals(basicFieldMetadata, new BasicFieldMetadata());
  }

  /**
   * Test {@link BasicFieldMetadata#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicFieldMetadata#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual29() {
    // Arrange
    BasicFieldMetadata basicFieldMetadata = new BasicFieldMetadata();
    basicFieldMetadata.setReadOnly(true);

    // Act and Assert
    assertNotEquals(basicFieldMetadata, new BasicFieldMetadata());
  }

  /**
   * Test {@link BasicFieldMetadata#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicFieldMetadata#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual30() {
    // Arrange
    BasicFieldMetadata basicFieldMetadata = new BasicFieldMetadata();
    basicFieldMetadata.setGridOrder(1);

    // Act and Assert
    assertNotEquals(basicFieldMetadata, new BasicFieldMetadata());
  }

  /**
   * Test {@link BasicFieldMetadata#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicFieldMetadata#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual31() {
    // Arrange
    BasicFieldMetadata basicFieldMetadata = new BasicFieldMetadata();
    basicFieldMetadata.setRequiredOverride(true);

    // Act and Assert
    assertNotEquals(basicFieldMetadata, new BasicFieldMetadata());
  }

  /**
   * Test {@link BasicFieldMetadata#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicFieldMetadata#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual32() {
    // Arrange
    BasicFieldMetadata basicFieldMetadata = new BasicFieldMetadata();
    basicFieldMetadata.setGroupCollapsed(true);

    // Act and Assert
    assertNotEquals(basicFieldMetadata, new BasicFieldMetadata());
  }

  /**
   * Test {@link BasicFieldMetadata#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicFieldMetadata#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual33() {
    // Arrange
    BasicFieldMetadata basicFieldMetadata = new BasicFieldMetadata();
    basicFieldMetadata.setTooltip("127.0.0.1");

    // Act and Assert
    assertNotEquals(basicFieldMetadata, new BasicFieldMetadata());
  }

  /**
   * Test {@link BasicFieldMetadata#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicFieldMetadata#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual34() {
    // Arrange
    BasicFieldMetadata basicFieldMetadata = new BasicFieldMetadata();
    basicFieldMetadata.setHelpText("Help Text");

    // Act and Assert
    assertNotEquals(basicFieldMetadata, new BasicFieldMetadata());
  }

  /**
   * Test {@link BasicFieldMetadata#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicFieldMetadata#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual35() {
    // Arrange
    BasicFieldMetadata basicFieldMetadata = new BasicFieldMetadata();
    basicFieldMetadata.setHint("Hint");

    // Act and Assert
    assertNotEquals(basicFieldMetadata, new BasicFieldMetadata());
  }

  /**
   * Test {@link BasicFieldMetadata#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicFieldMetadata#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual36() {
    // Arrange
    BasicFieldMetadata basicFieldMetadata = new BasicFieldMetadata();
    basicFieldMetadata.setVisibility(VisibilityEnum.HIDDEN_ALL);

    // Act and Assert
    assertNotEquals(basicFieldMetadata, new BasicFieldMetadata());
  }

  /**
   * Test {@link BasicFieldMetadata#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicFieldMetadata#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual37() {
    // Arrange
    BasicFieldMetadata basicFieldMetadata = new BasicFieldMetadata();
    basicFieldMetadata.setLookupDisplayProperty("Lookup Display Property");

    // Act and Assert
    assertNotEquals(basicFieldMetadata, new BasicFieldMetadata());
  }

  /**
   * Test {@link BasicFieldMetadata#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicFieldMetadata#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual38() {
    // Arrange
    BasicFieldMetadata basicFieldMetadata = new BasicFieldMetadata();
    basicFieldMetadata.setForcePopulateChildProperties(true);

    // Act and Assert
    assertNotEquals(basicFieldMetadata, new BasicFieldMetadata());
  }

  /**
   * Test {@link BasicFieldMetadata#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicFieldMetadata#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual39() {
    // Arrange
    BasicFieldMetadata basicFieldMetadata = new BasicFieldMetadata();
    basicFieldMetadata.setEnableTypeaheadLookup(true);

    // Act and Assert
    assertNotEquals(basicFieldMetadata, new BasicFieldMetadata());
  }

  /**
   * Test {@link BasicFieldMetadata#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicFieldMetadata#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual40() {
    // Arrange
    BasicFieldMetadata basicFieldMetadata = new BasicFieldMetadata();
    basicFieldMetadata.setOptionCanEditValues(true);

    // Act and Assert
    assertNotEquals(basicFieldMetadata, new BasicFieldMetadata());
  }

  /**
   * Test {@link BasicFieldMetadata#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicFieldMetadata#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual41() {
    // Arrange
    BasicFieldMetadata basicFieldMetadata = new BasicFieldMetadata();
    basicFieldMetadata.setOptionHideIfEmpty(true);

    // Act and Assert
    assertNotEquals(basicFieldMetadata, new BasicFieldMetadata());
  }

  /**
   * Test {@link BasicFieldMetadata#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicFieldMetadata#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual42() {
    // Arrange
    BasicFieldMetadata basicFieldMetadata = new BasicFieldMetadata();
    basicFieldMetadata.setOptionDisplayFieldName("Option Display Field Name");

    // Act and Assert
    assertNotEquals(basicFieldMetadata, new BasicFieldMetadata());
  }

  /**
   * Test {@link BasicFieldMetadata#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicFieldMetadata#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual43() {
    // Arrange
    BasicFieldMetadata basicFieldMetadata = new BasicFieldMetadata();
    basicFieldMetadata.setOptionListEntity("Option List Entity");

    // Act and Assert
    assertNotEquals(basicFieldMetadata, new BasicFieldMetadata());
  }

  /**
   * Test {@link BasicFieldMetadata#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicFieldMetadata#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual44() {
    // Arrange
    BasicFieldMetadata basicFieldMetadata = new BasicFieldMetadata();
    basicFieldMetadata.setOptionValueFieldName("42");

    // Act and Assert
    assertNotEquals(basicFieldMetadata, new BasicFieldMetadata());
  }

  /**
   * Test {@link BasicFieldMetadata#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicFieldMetadata#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual45() {
    // Arrange
    BasicFieldMetadata basicFieldMetadata = new BasicFieldMetadata();
    basicFieldMetadata.setRuleIdentifier("42");

    // Act and Assert
    assertNotEquals(basicFieldMetadata, new BasicFieldMetadata());
  }

  /**
   * Test {@link BasicFieldMetadata#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicFieldMetadata#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual46() {
    // Arrange
    BasicFieldMetadata basicFieldMetadata = new BasicFieldMetadata();
    basicFieldMetadata.setMapFieldValueClass("42");

    // Act and Assert
    assertNotEquals(basicFieldMetadata, new BasicFieldMetadata());
  }

  /**
   * Test {@link BasicFieldMetadata#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicFieldMetadata#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual47() {
    // Arrange
    BasicFieldMetadata basicFieldMetadata = new BasicFieldMetadata();
    basicFieldMetadata.setSearchable(true);

    // Act and Assert
    assertNotEquals(basicFieldMetadata, new BasicFieldMetadata());
  }

  /**
   * Test {@link BasicFieldMetadata#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicFieldMetadata#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual48() {
    // Arrange
    BasicFieldMetadata basicFieldMetadata = new BasicFieldMetadata();
    basicFieldMetadata.setManyToField("Many To Field");

    // Act and Assert
    assertNotEquals(basicFieldMetadata, new BasicFieldMetadata());
  }

  /**
   * Test {@link BasicFieldMetadata#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicFieldMetadata#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual49() {
    // Arrange
    BasicFieldMetadata basicFieldMetadata = new BasicFieldMetadata();
    basicFieldMetadata.setToOneTargetProperty("To One Target Property");

    // Act and Assert
    assertNotEquals(basicFieldMetadata, new BasicFieldMetadata());
  }

  /**
   * Test {@link BasicFieldMetadata#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicFieldMetadata#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual50() {
    // Arrange
    BasicFieldMetadata basicFieldMetadata = new BasicFieldMetadata();
    basicFieldMetadata.setToOneParentProperty("To One Parent Property");

    // Act and Assert
    assertNotEquals(basicFieldMetadata, new BasicFieldMetadata());
  }

  /**
   * Test {@link BasicFieldMetadata#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicFieldMetadata#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual51() {
    // Arrange
    BasicFieldMetadata basicFieldMetadata = new BasicFieldMetadata();
    basicFieldMetadata.setMapKeyValueProperty("42");

    // Act and Assert
    assertNotEquals(basicFieldMetadata, new BasicFieldMetadata());
  }

  /**
   * Test {@link BasicFieldMetadata#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicFieldMetadata#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual52() {
    // Arrange
    BasicFieldMetadata basicFieldMetadata = new BasicFieldMetadata();
    basicFieldMetadata.setLookupType(LookupType.STANDARD);

    // Act and Assert
    assertNotEquals(basicFieldMetadata, new BasicFieldMetadata());
  }

  /**
   * Test {@link BasicFieldMetadata#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicFieldMetadata#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual53() {
    // Arrange
    BasicFieldMetadata basicFieldMetadata = new BasicFieldMetadata();
    basicFieldMetadata.setCanLinkToExternalEntity(true);

    // Act and Assert
    assertNotEquals(basicFieldMetadata, new BasicFieldMetadata());
  }

  /**
   * Test {@link BasicFieldMetadata#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicFieldMetadata#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual54() {
    // Arrange
    BasicFieldMetadata basicFieldMetadata = new BasicFieldMetadata();
    basicFieldMetadata.setAvailableToTypes(new String[]{"Available To Types"});

    // Act and Assert
    assertNotEquals(basicFieldMetadata, new BasicFieldMetadata());
  }

  /**
   * Test {@link BasicFieldMetadata#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicFieldMetadata#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual55() {
    // Arrange
    BasicFieldMetadata basicFieldMetadata = new BasicFieldMetadata();

    BasicFieldMetadata basicFieldMetadata2 = new BasicFieldMetadata();
    basicFieldMetadata2.setLength(3);

    // Act and Assert
    assertNotEquals(basicFieldMetadata, basicFieldMetadata2);
  }

  /**
   * Test {@link BasicFieldMetadata#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicFieldMetadata#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual56() {
    // Arrange
    BasicFieldMetadata basicFieldMetadata = new BasicFieldMetadata();

    BasicFieldMetadata basicFieldMetadata2 = new BasicFieldMetadata();
    basicFieldMetadata2.setRequired(true);

    // Act and Assert
    assertNotEquals(basicFieldMetadata, basicFieldMetadata2);
  }

  /**
   * Test {@link BasicFieldMetadata#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicFieldMetadata#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual57() {
    // Arrange
    BasicFieldMetadata basicFieldMetadata = new BasicFieldMetadata();

    BasicFieldMetadata basicFieldMetadata2 = new BasicFieldMetadata();
    basicFieldMetadata2.setScale(1);

    // Act and Assert
    assertNotEquals(basicFieldMetadata, basicFieldMetadata2);
  }

  /**
   * Test {@link BasicFieldMetadata#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicFieldMetadata#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual58() {
    // Arrange
    BasicFieldMetadata basicFieldMetadata = new BasicFieldMetadata();

    BasicFieldMetadata basicFieldMetadata2 = new BasicFieldMetadata();
    basicFieldMetadata2.setPrecision(1);

    // Act and Assert
    assertNotEquals(basicFieldMetadata, basicFieldMetadata2);
  }

  /**
   * Test {@link BasicFieldMetadata#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicFieldMetadata#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual59() {
    // Arrange
    BasicFieldMetadata basicFieldMetadata = new BasicFieldMetadata();

    BasicFieldMetadata basicFieldMetadata2 = new BasicFieldMetadata();
    basicFieldMetadata2.setUnique(true);

    // Act and Assert
    assertNotEquals(basicFieldMetadata, basicFieldMetadata2);
  }

  /**
   * Test {@link BasicFieldMetadata#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicFieldMetadata#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual60() {
    // Arrange
    BasicFieldMetadata basicFieldMetadata = new BasicFieldMetadata();

    BasicFieldMetadata basicFieldMetadata2 = new BasicFieldMetadata();
    basicFieldMetadata2.setMutable(true);

    // Act and Assert
    assertNotEquals(basicFieldMetadata, basicFieldMetadata2);
  }

  /**
   * Test {@link BasicFieldMetadata#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicFieldMetadata#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual61() {
    // Arrange
    BasicFieldMetadata basicFieldMetadata = new BasicFieldMetadata();

    BasicFieldMetadata basicFieldMetadata2 = new BasicFieldMetadata();
    basicFieldMetadata2.setForeignKeyProperty("Foreign Key Property");

    // Act and Assert
    assertNotEquals(basicFieldMetadata, basicFieldMetadata2);
  }

  /**
   * Test {@link BasicFieldMetadata#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicFieldMetadata#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual62() {
    // Arrange
    BasicFieldMetadata basicFieldMetadata = new BasicFieldMetadata();

    BasicFieldMetadata basicFieldMetadata2 = new BasicFieldMetadata();
    basicFieldMetadata2.setForeignKeyClass("Foreign Key Class");

    // Act and Assert
    assertNotEquals(basicFieldMetadata, basicFieldMetadata2);
  }

  /**
   * Test {@link BasicFieldMetadata#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicFieldMetadata#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual63() {
    // Arrange
    BasicFieldMetadata basicFieldMetadata = new BasicFieldMetadata();

    BasicFieldMetadata basicFieldMetadata2 = new BasicFieldMetadata();
    basicFieldMetadata2.setForeignKeyCollection(true);

    // Act and Assert
    assertNotEquals(basicFieldMetadata, basicFieldMetadata2);
  }

  /**
   * Test {@link BasicFieldMetadata#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicFieldMetadata#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual64() {
    // Arrange
    BasicFieldMetadata basicFieldMetadata = new BasicFieldMetadata();

    BasicFieldMetadata basicFieldMetadata2 = new BasicFieldMetadata();
    basicFieldMetadata2.setForeignKeyDisplayValueProperty("42");

    // Act and Assert
    assertNotEquals(basicFieldMetadata, basicFieldMetadata2);
  }

  /**
   * Test {@link BasicFieldMetadata#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicFieldMetadata#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual65() {
    // Arrange
    BasicFieldMetadata basicFieldMetadata = new BasicFieldMetadata();

    BasicFieldMetadata basicFieldMetadata2 = new BasicFieldMetadata();
    basicFieldMetadata2.setEnumerationClass("Enumeration Class");

    // Act and Assert
    assertNotEquals(basicFieldMetadata, basicFieldMetadata2);
  }

  /**
   * Test {@link BasicFieldMetadata#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicFieldMetadata#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual66() {
    // Arrange
    BasicFieldMetadata basicFieldMetadata = new BasicFieldMetadata();

    BasicFieldMetadata basicFieldMetadata2 = new BasicFieldMetadata();
    basicFieldMetadata2.setDerived(true);

    // Act and Assert
    assertNotEquals(basicFieldMetadata, basicFieldMetadata2);
  }

  /**
   * Test {@link BasicFieldMetadata#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicFieldMetadata#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual67() {
    // Arrange
    BasicFieldMetadata basicFieldMetadata = new BasicFieldMetadata();

    BasicFieldMetadata basicFieldMetadata2 = new BasicFieldMetadata();
    basicFieldMetadata2.setName("Name");

    // Act and Assert
    assertNotEquals(basicFieldMetadata, basicFieldMetadata2);
  }

  /**
   * Test {@link BasicFieldMetadata#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicFieldMetadata#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual68() {
    // Arrange
    BasicFieldMetadata basicFieldMetadata = new BasicFieldMetadata();

    BasicFieldMetadata basicFieldMetadata2 = new BasicFieldMetadata();
    basicFieldMetadata2.setLargeEntry(true);

    // Act and Assert
    assertNotEquals(basicFieldMetadata, basicFieldMetadata2);
  }

  /**
   * Test {@link BasicFieldMetadata#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicFieldMetadata#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual69() {
    // Arrange
    BasicFieldMetadata basicFieldMetadata = new BasicFieldMetadata();

    BasicFieldMetadata basicFieldMetadata2 = new BasicFieldMetadata();
    basicFieldMetadata2.setProminent(true);

    // Act and Assert
    assertNotEquals(basicFieldMetadata, basicFieldMetadata2);
  }

  /**
   * Test {@link BasicFieldMetadata#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicFieldMetadata#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual70() {
    // Arrange
    BasicFieldMetadata basicFieldMetadata = new BasicFieldMetadata();

    BasicFieldMetadata basicFieldMetadata2 = new BasicFieldMetadata();
    basicFieldMetadata2.setColumnWidth("Column Width");

    // Act and Assert
    assertNotEquals(basicFieldMetadata, basicFieldMetadata2);
  }

  /**
   * Test {@link BasicFieldMetadata#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicFieldMetadata#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual71() {
    // Arrange
    BasicFieldMetadata basicFieldMetadata = new BasicFieldMetadata();

    BasicFieldMetadata basicFieldMetadata2 = new BasicFieldMetadata();
    basicFieldMetadata2.setBroadleafEnumeration("Broadleaf Enumeration");

    // Act and Assert
    assertNotEquals(basicFieldMetadata, basicFieldMetadata2);
  }

  /**
   * Test {@link BasicFieldMetadata#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicFieldMetadata#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual72() {
    // Arrange
    BasicFieldMetadata basicFieldMetadata = new BasicFieldMetadata();

    BasicFieldMetadata basicFieldMetadata2 = new BasicFieldMetadata();
    basicFieldMetadata2.setHideEnumerationIfEmpty(true);

    // Act and Assert
    assertNotEquals(basicFieldMetadata, basicFieldMetadata2);
  }

  /**
   * Test {@link BasicFieldMetadata#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicFieldMetadata#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual73() {
    // Arrange
    BasicFieldMetadata basicFieldMetadata = new BasicFieldMetadata();

    BasicFieldMetadata basicFieldMetadata2 = new BasicFieldMetadata();
    basicFieldMetadata2.setFieldComponentRenderer(SupportedFieldType.UNKNOWN);

    // Act and Assert
    assertNotEquals(basicFieldMetadata, basicFieldMetadata2);
  }

  /**
   * Test {@link BasicFieldMetadata#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicFieldMetadata#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual74() {
    // Arrange
    BasicFieldMetadata basicFieldMetadata = new BasicFieldMetadata();

    BasicFieldMetadata basicFieldMetadata2 = new BasicFieldMetadata();
    basicFieldMetadata2.setGridFieldComponentRenderer(SupportedFieldType.UNKNOWN);

    // Act and Assert
    assertNotEquals(basicFieldMetadata, basicFieldMetadata2);
  }

  /**
   * Test {@link BasicFieldMetadata#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicFieldMetadata#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual75() {
    // Arrange
    BasicFieldMetadata basicFieldMetadata = new BasicFieldMetadata();

    BasicFieldMetadata basicFieldMetadata2 = new BasicFieldMetadata();
    basicFieldMetadata2.setFieldComponentRendererTemplate("Field Component Renderer Template");

    // Act and Assert
    assertNotEquals(basicFieldMetadata, basicFieldMetadata2);
  }

  /**
   * Test {@link BasicFieldMetadata#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicFieldMetadata#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual76() {
    // Arrange
    BasicFieldMetadata basicFieldMetadata = new BasicFieldMetadata();

    BasicFieldMetadata basicFieldMetadata2 = new BasicFieldMetadata();
    basicFieldMetadata2.setGridFieldComponentRendererTemplate("Grid Field Component Renderer Template");

    // Act and Assert
    assertNotEquals(basicFieldMetadata, basicFieldMetadata2);
  }

  /**
   * Test {@link BasicFieldMetadata#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicFieldMetadata#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual77() {
    // Arrange
    BasicFieldMetadata basicFieldMetadata = new BasicFieldMetadata();

    BasicFieldMetadata basicFieldMetadata2 = new BasicFieldMetadata();
    basicFieldMetadata2.setReadOnly(true);

    // Act and Assert
    assertNotEquals(basicFieldMetadata, basicFieldMetadata2);
  }

  /**
   * Test {@link BasicFieldMetadata#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicFieldMetadata#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual78() {
    // Arrange
    BasicFieldMetadata basicFieldMetadata = new BasicFieldMetadata();

    BasicFieldMetadata basicFieldMetadata2 = new BasicFieldMetadata();
    basicFieldMetadata2.setGridOrder(1);

    // Act and Assert
    assertNotEquals(basicFieldMetadata, basicFieldMetadata2);
  }

  /**
   * Test {@link BasicFieldMetadata#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicFieldMetadata#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual79() {
    // Arrange
    BasicFieldMetadata basicFieldMetadata = new BasicFieldMetadata();

    BasicFieldMetadata basicFieldMetadata2 = new BasicFieldMetadata();
    basicFieldMetadata2.setRequiredOverride(true);

    // Act and Assert
    assertNotEquals(basicFieldMetadata, basicFieldMetadata2);
  }

  /**
   * Test {@link BasicFieldMetadata#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicFieldMetadata#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual80() {
    // Arrange
    BasicFieldMetadata basicFieldMetadata = new BasicFieldMetadata();

    BasicFieldMetadata basicFieldMetadata2 = new BasicFieldMetadata();
    basicFieldMetadata2.setGroupCollapsed(true);

    // Act and Assert
    assertNotEquals(basicFieldMetadata, basicFieldMetadata2);
  }

  /**
   * Test {@link BasicFieldMetadata#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicFieldMetadata#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual81() {
    // Arrange
    BasicFieldMetadata basicFieldMetadata = new BasicFieldMetadata();

    BasicFieldMetadata basicFieldMetadata2 = new BasicFieldMetadata();
    basicFieldMetadata2.setTooltip("127.0.0.1");

    // Act and Assert
    assertNotEquals(basicFieldMetadata, basicFieldMetadata2);
  }

  /**
   * Test {@link BasicFieldMetadata#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicFieldMetadata#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual82() {
    // Arrange
    BasicFieldMetadata basicFieldMetadata = new BasicFieldMetadata();

    BasicFieldMetadata basicFieldMetadata2 = new BasicFieldMetadata();
    basicFieldMetadata2.setHelpText("Help Text");

    // Act and Assert
    assertNotEquals(basicFieldMetadata, basicFieldMetadata2);
  }

  /**
   * Test {@link BasicFieldMetadata#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicFieldMetadata#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual83() {
    // Arrange
    BasicFieldMetadata basicFieldMetadata = new BasicFieldMetadata();

    BasicFieldMetadata basicFieldMetadata2 = new BasicFieldMetadata();
    basicFieldMetadata2.setHint("Hint");

    // Act and Assert
    assertNotEquals(basicFieldMetadata, basicFieldMetadata2);
  }

  /**
   * Test {@link BasicFieldMetadata#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicFieldMetadata#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual84() {
    // Arrange
    BasicFieldMetadata basicFieldMetadata = new BasicFieldMetadata();

    BasicFieldMetadata basicFieldMetadata2 = new BasicFieldMetadata();
    basicFieldMetadata2.setLookupDisplayProperty("Lookup Display Property");

    // Act and Assert
    assertNotEquals(basicFieldMetadata, basicFieldMetadata2);
  }

  /**
   * Test {@link BasicFieldMetadata#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicFieldMetadata#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual85() {
    // Arrange
    BasicFieldMetadata basicFieldMetadata = new BasicFieldMetadata();

    BasicFieldMetadata basicFieldMetadata2 = new BasicFieldMetadata();
    basicFieldMetadata2.setForcePopulateChildProperties(true);

    // Act and Assert
    assertNotEquals(basicFieldMetadata, basicFieldMetadata2);
  }

  /**
   * Test {@link BasicFieldMetadata#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicFieldMetadata#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual86() {
    // Arrange
    BasicFieldMetadata basicFieldMetadata = new BasicFieldMetadata();

    BasicFieldMetadata basicFieldMetadata2 = new BasicFieldMetadata();
    basicFieldMetadata2.setEnableTypeaheadLookup(true);

    // Act and Assert
    assertNotEquals(basicFieldMetadata, basicFieldMetadata2);
  }

  /**
   * Test {@link BasicFieldMetadata#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicFieldMetadata#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual87() {
    // Arrange
    BasicFieldMetadata basicFieldMetadata = new BasicFieldMetadata();

    BasicFieldMetadata basicFieldMetadata2 = new BasicFieldMetadata();
    basicFieldMetadata2.setOptionCanEditValues(true);

    // Act and Assert
    assertNotEquals(basicFieldMetadata, basicFieldMetadata2);
  }

  /**
   * Test {@link BasicFieldMetadata#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicFieldMetadata#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual88() {
    // Arrange
    BasicFieldMetadata basicFieldMetadata = new BasicFieldMetadata();

    BasicFieldMetadata basicFieldMetadata2 = new BasicFieldMetadata();
    basicFieldMetadata2.setOptionHideIfEmpty(true);

    // Act and Assert
    assertNotEquals(basicFieldMetadata, basicFieldMetadata2);
  }

  /**
   * Test {@link BasicFieldMetadata#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicFieldMetadata#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual89() {
    // Arrange
    BasicFieldMetadata basicFieldMetadata = new BasicFieldMetadata();

    BasicFieldMetadata basicFieldMetadata2 = new BasicFieldMetadata();
    basicFieldMetadata2.setOptionDisplayFieldName("Option Display Field Name");

    // Act and Assert
    assertNotEquals(basicFieldMetadata, basicFieldMetadata2);
  }

  /**
   * Test {@link BasicFieldMetadata#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicFieldMetadata#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual90() {
    // Arrange
    BasicFieldMetadata basicFieldMetadata = new BasicFieldMetadata();

    BasicFieldMetadata basicFieldMetadata2 = new BasicFieldMetadata();
    basicFieldMetadata2.setOptionListEntity("Option List Entity");

    // Act and Assert
    assertNotEquals(basicFieldMetadata, basicFieldMetadata2);
  }

  /**
   * Test {@link BasicFieldMetadata#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicFieldMetadata#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual91() {
    // Arrange
    BasicFieldMetadata basicFieldMetadata = new BasicFieldMetadata();

    BasicFieldMetadata basicFieldMetadata2 = new BasicFieldMetadata();
    basicFieldMetadata2.setOptionValueFieldName("42");

    // Act and Assert
    assertNotEquals(basicFieldMetadata, basicFieldMetadata2);
  }

  /**
   * Test {@link BasicFieldMetadata#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicFieldMetadata#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual92() {
    // Arrange
    BasicFieldMetadata basicFieldMetadata = new BasicFieldMetadata();

    BasicFieldMetadata basicFieldMetadata2 = new BasicFieldMetadata();
    basicFieldMetadata2.setRuleIdentifier("42");

    // Act and Assert
    assertNotEquals(basicFieldMetadata, basicFieldMetadata2);
  }

  /**
   * Test {@link BasicFieldMetadata#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicFieldMetadata#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual93() {
    // Arrange
    BasicFieldMetadata basicFieldMetadata = new BasicFieldMetadata();

    BasicFieldMetadata basicFieldMetadata2 = new BasicFieldMetadata();
    basicFieldMetadata2.setMapFieldValueClass("42");

    // Act and Assert
    assertNotEquals(basicFieldMetadata, basicFieldMetadata2);
  }

  /**
   * Test {@link BasicFieldMetadata#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicFieldMetadata#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual94() {
    // Arrange
    BasicFieldMetadata basicFieldMetadata = new BasicFieldMetadata();

    BasicFieldMetadata basicFieldMetadata2 = new BasicFieldMetadata();
    basicFieldMetadata2.setSearchable(true);

    // Act and Assert
    assertNotEquals(basicFieldMetadata, basicFieldMetadata2);
  }

  /**
   * Test {@link BasicFieldMetadata#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicFieldMetadata#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual95() {
    // Arrange
    BasicFieldMetadata basicFieldMetadata = new BasicFieldMetadata();

    BasicFieldMetadata basicFieldMetadata2 = new BasicFieldMetadata();
    basicFieldMetadata2.setManyToField("Many To Field");

    // Act and Assert
    assertNotEquals(basicFieldMetadata, basicFieldMetadata2);
  }

  /**
   * Test {@link BasicFieldMetadata#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicFieldMetadata#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual96() {
    // Arrange
    BasicFieldMetadata basicFieldMetadata = new BasicFieldMetadata();

    BasicFieldMetadata basicFieldMetadata2 = new BasicFieldMetadata();
    basicFieldMetadata2.setToOneTargetProperty("To One Target Property");

    // Act and Assert
    assertNotEquals(basicFieldMetadata, basicFieldMetadata2);
  }

  /**
   * Test {@link BasicFieldMetadata#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicFieldMetadata#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual97() {
    // Arrange
    BasicFieldMetadata basicFieldMetadata = new BasicFieldMetadata();

    BasicFieldMetadata basicFieldMetadata2 = new BasicFieldMetadata();
    basicFieldMetadata2.setToOneParentProperty("To One Parent Property");

    // Act and Assert
    assertNotEquals(basicFieldMetadata, basicFieldMetadata2);
  }

  /**
   * Test {@link BasicFieldMetadata#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicFieldMetadata#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual98() {
    // Arrange
    BasicFieldMetadata basicFieldMetadata = new BasicFieldMetadata();

    BasicFieldMetadata basicFieldMetadata2 = new BasicFieldMetadata();
    basicFieldMetadata2.setMapKeyValueProperty("42");

    // Act and Assert
    assertNotEquals(basicFieldMetadata, basicFieldMetadata2);
  }

  /**
   * Test {@link BasicFieldMetadata#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicFieldMetadata#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual99() {
    // Arrange
    BasicFieldMetadata basicFieldMetadata = new BasicFieldMetadata();

    BasicFieldMetadata basicFieldMetadata2 = new BasicFieldMetadata();
    basicFieldMetadata2.setLookupType(LookupType.STANDARD);

    // Act and Assert
    assertNotEquals(basicFieldMetadata, basicFieldMetadata2);
  }

  /**
   * Test {@link BasicFieldMetadata#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicFieldMetadata#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual100() {
    // Arrange
    BasicFieldMetadata basicFieldMetadata = new BasicFieldMetadata();

    BasicFieldMetadata basicFieldMetadata2 = new BasicFieldMetadata();
    basicFieldMetadata2.setCanLinkToExternalEntity(true);

    // Act and Assert
    assertNotEquals(basicFieldMetadata, basicFieldMetadata2);
  }

  /**
   * Test {@link BasicFieldMetadata#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicFieldMetadata#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new BasicFieldMetadata(), null);
  }

  /**
   * Test {@link BasicFieldMetadata#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicFieldMetadata#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new BasicFieldMetadata(), "Different type to BasicFieldMetadata");
  }

  /**
   * Test new {@link BasicFieldMetadata} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link BasicFieldMetadata}
   */
  @Test
  public void testNewBasicFieldMetadata() {
    // Arrange and Act
    BasicFieldMetadata actualBasicFieldMetadata = new BasicFieldMetadata();

    // Assert
    assertNull(actualBasicFieldMetadata.getCustomCriteria());
    assertNull(actualBasicFieldMetadata.getAvailableToTypes());
    assertNull(actualBasicFieldMetadata.getEnumerationValues());
    assertNull(actualBasicFieldMetadata.getOptionFilterParams());
    assertNull(actualBasicFieldMetadata.getCanLinkToExternalEntity());
    assertNull(actualBasicFieldMetadata.getEnableTypeaheadLookup());
    assertNull(actualBasicFieldMetadata.getForcePopulateChildProperties());
    assertNull(actualBasicFieldMetadata.getGroupCollapsed());
    assertNull(actualBasicFieldMetadata.getHideEnumerationIfEmpty());
    assertNull(actualBasicFieldMetadata.getIsDerived());
    assertNull(actualBasicFieldMetadata.getIsFilter());
    assertNull(actualBasicFieldMetadata.getMutable());
    assertNull(actualBasicFieldMetadata.getOptionCanEditValues());
    assertNull(actualBasicFieldMetadata.getOptionHideIfEmpty());
    assertNull(actualBasicFieldMetadata.getReadOnly());
    assertNull(actualBasicFieldMetadata.getRequiredOverride());
    assertNull(actualBasicFieldMetadata.getSearchable());
    assertNull(actualBasicFieldMetadata.getToOneLookupCreatedViaAnnotation());
    assertNull(actualBasicFieldMetadata.getTranslatable());
    assertNull(actualBasicFieldMetadata.getUnique());
    assertNull(actualBasicFieldMetadata.getUseServerSideInspectionCache());
    assertNull(actualBasicFieldMetadata.isLargeEntry());
    assertNull(actualBasicFieldMetadata.isProminent());
    assertNull(actualBasicFieldMetadata.getChildrenExcluded());
    assertNull(actualBasicFieldMetadata.getExcluded());
    assertNull(actualBasicFieldMetadata.getLazyFetch());
    assertNull(actualBasicFieldMetadata.allowNoValueEnumOption);
    assertNull(actualBasicFieldMetadata.foreignKeyCollection);
    assertNull(actualBasicFieldMetadata.required);
    assertNull(actualBasicFieldMetadata.getGridOrder());
    assertNull(actualBasicFieldMetadata.getLength());
    assertNull(actualBasicFieldMetadata.getPrecision());
    assertNull(actualBasicFieldMetadata.getScale());
    assertNull(actualBasicFieldMetadata.getGroupOrder());
    assertNull(actualBasicFieldMetadata.getOrder());
    assertNull(actualBasicFieldMetadata.getTabOrder());
    assertNull(actualBasicFieldMetadata.getAssociatedFieldName());
    assertNull(actualBasicFieldMetadata.getBroadleafEnumeration());
    assertNull(actualBasicFieldMetadata.getColumnWidth());
    assertNull(actualBasicFieldMetadata.getDefaultValue());
    assertNull(actualBasicFieldMetadata.getEnumerationClass());
    assertNull(actualBasicFieldMetadata.getFieldComponentRendererTemplate());
    assertNull(actualBasicFieldMetadata.getForeignKeyClass());
    assertNull(actualBasicFieldMetadata.getForeignKeyDisplayValueProperty());
    assertNull(actualBasicFieldMetadata.getForeignKeyProperty());
    assertNull(actualBasicFieldMetadata.getGridFieldComponentRendererTemplate());
    assertNull(actualBasicFieldMetadata.getHelpText());
    assertNull(actualBasicFieldMetadata.getHint());
    assertNull(actualBasicFieldMetadata.getLookupDisplayProperty());
    assertNull(actualBasicFieldMetadata.getManyToField());
    assertNull(actualBasicFieldMetadata.getMapFieldValueClass());
    assertNull(actualBasicFieldMetadata.getMapKeyValueProperty());
    assertNull(actualBasicFieldMetadata.getName());
    assertNull(actualBasicFieldMetadata.getOptionDisplayFieldName());
    assertNull(actualBasicFieldMetadata.getOptionListEntity());
    assertNull(actualBasicFieldMetadata.getOptionValueFieldName());
    assertNull(actualBasicFieldMetadata.getRuleIdentifier());
    assertNull(actualBasicFieldMetadata.getToOneParentProperty());
    assertNull(actualBasicFieldMetadata.getToOneTargetProperty());
    assertNull(actualBasicFieldMetadata.getTooltip());
    assertNull(actualBasicFieldMetadata.getAddFriendlyName());
    assertNull(actualBasicFieldMetadata.getCurrencyCodeField());
    assertNull(actualBasicFieldMetadata.getFieldName());
    assertNull(actualBasicFieldMetadata.getFriendlyName());
    assertNull(actualBasicFieldMetadata.getGroup());
    assertNull(actualBasicFieldMetadata.getInheritedFromType());
    assertNull(actualBasicFieldMetadata.getOwningClass());
    assertNull(actualBasicFieldMetadata.getOwningClassFriendlyName());
    assertNull(actualBasicFieldMetadata.getPrefix());
    assertNull(actualBasicFieldMetadata.getSecurityLevel());
    assertNull(actualBasicFieldMetadata.getShowIfProperty());
    assertNull(actualBasicFieldMetadata.getTab());
    assertNull(actualBasicFieldMetadata.getTargetClass());
    assertNull(actualBasicFieldMetadata.getShowIfFieldEquals());
    assertNull(actualBasicFieldMetadata.getLookupType());
    assertNull(actualBasicFieldMetadata.getDisplayType());
    assertNull(actualBasicFieldMetadata.getExplicitFieldType());
    assertNull(actualBasicFieldMetadata.getFieldComponentRenderer());
    assertNull(actualBasicFieldMetadata.getFieldType());
    assertNull(actualBasicFieldMetadata.getGridFieldComponentRenderer());
    assertNull(actualBasicFieldMetadata.getVisibility());
    assertNull(actualBasicFieldMetadata.getMergedPropertyType());
    assertEquals(SupportedFieldType.INTEGER, actualBasicFieldMetadata.getSecondaryType());
    assertFalse(actualBasicFieldMetadata.getForeignKeyCollection());
    assertFalse(actualBasicFieldMetadata.getRequired());
    assertFalse(actualBasicFieldMetadata.getManualFetch());
    assertTrue(actualBasicFieldMetadata.getValidationConfigurations().isEmpty());
    assertTrue(actualBasicFieldMetadata.getAdditionalMetadata().isEmpty());
    assertTrue(actualBasicFieldMetadata.getAllowNoValueEnumOption());
  }
}
