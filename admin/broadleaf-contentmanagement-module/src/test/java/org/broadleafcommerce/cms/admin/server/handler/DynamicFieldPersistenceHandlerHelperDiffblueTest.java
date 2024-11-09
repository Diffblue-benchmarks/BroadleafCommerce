/*-
 * #%L
 * BroadleafCommerce CMS Module
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
package org.broadleafcommerce.cms.admin.server.handler;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import org.broadleafcommerce.cms.field.domain.FieldDefinition;
import org.broadleafcommerce.cms.field.domain.FieldDefinitionImpl;
import org.broadleafcommerce.cms.field.domain.FieldGroup;
import org.broadleafcommerce.cms.field.domain.FieldGroupImpl;
import org.broadleafcommerce.common.enumeration.domain.DataDrivenEnumerationImpl;
import org.broadleafcommerce.common.presentation.client.SupportedFieldType;
import org.broadleafcommerce.common.presentation.client.VisibilityEnum;
import org.broadleafcommerce.openadmin.dto.BasicFieldMetadata;
import org.broadleafcommerce.openadmin.dto.FieldMetadata;
import org.broadleafcommerce.openadmin.dto.MergedPropertyType;
import org.broadleafcommerce.openadmin.dto.Property;
import org.junit.Test;

public class DynamicFieldPersistenceHandlerHelperDiffblueTest {
  /**
   * Test
   * {@link DynamicFieldPersistenceHandlerHelper#buildDynamicProperty(FieldDefinition, Class)}.
   * <p>
   * Method under test:
   * {@link DynamicFieldPersistenceHandlerHelper#buildDynamicProperty(FieldDefinition, Class)}
   */
  @Test
  public void testBuildDynamicProperty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DynamicFieldPersistenceHandlerHelper dynamicFieldPersistenceHandlerHelper = new DynamicFieldPersistenceHandlerHelper();
    FieldDefinitionImpl definition = mock(FieldDefinitionImpl.class);
    when(definition.getAdditionalForeignKeyClass()).thenReturn("Additional Foreign Key Class");
    when(definition.getValidationErrorMesageKey()).thenReturn("An error occurred");
    when(definition.getFieldOrder()).thenReturn(1);
    when(definition.getHiddenFlag()).thenReturn(true);
    when(definition.getRequiredFlag()).thenReturn(true);
    when(definition.getTextAreaFlag()).thenReturn(true);
    when(definition.getMaxLength()).thenReturn(3);
    when(definition.getColumnWidth()).thenReturn("Column Width");
    when(definition.getFriendlyName()).thenReturn("Friendly Name");
    when(definition.getHelpText()).thenReturn("Help Text");
    when(definition.getHint()).thenReturn("Hint");
    when(definition.getName()).thenReturn("Name");
    when(definition.getSecurityLevel()).thenReturn("Security Level");
    when(definition.getTooltip()).thenReturn("127.0.0.1");
    when(definition.getValidationRegEx()).thenReturn(".*");
    when(definition.getDataDrivenEnumeration()).thenReturn(new DataDrivenEnumerationImpl());
    when(definition.getFieldType()).thenReturn(SupportedFieldType.ADDITIONAL_FOREIGN_KEY);
    Class<Object> inheritedType = Object.class;

    // Act
    Property actualBuildDynamicPropertyResult = dynamicFieldPersistenceHandlerHelper.buildDynamicProperty(definition,
        inheritedType);

    // Assert
    verify(definition, atLeast(1)).getAdditionalForeignKeyClass();
    verify(definition).getColumnWidth();
    verify(definition, atLeast(1)).getDataDrivenEnumeration();
    verify(definition).getFieldOrder();
    verify(definition, atLeast(1)).getFieldType();
    verify(definition).getFriendlyName();
    verify(definition).getHelpText();
    verify(definition).getHiddenFlag();
    verify(definition).getHint();
    verify(definition).getMaxLength();
    verify(definition, atLeast(1)).getName();
    verify(definition).getRequiredFlag();
    verify(definition, atLeast(1)).getSecurityLevel();
    verify(definition).getTextAreaFlag();
    verify(definition).getTooltip();
    verify(definition).getValidationErrorMesageKey();
    verify(definition, atLeast(1)).getValidationRegEx();
    FieldMetadata metadata = actualBuildDynamicPropertyResult.getMetadata();
    assertTrue(metadata instanceof BasicFieldMetadata);
    assertEquals("Additional Foreign Key Class", ((BasicFieldMetadata) metadata).getForeignKeyClass());
    assertEquals("Additional Foreign Key Class", metadata.getOwningClass());
    assertEquals("__adminMainEntity", ((BasicFieldMetadata) metadata).getForeignKeyDisplayValueProperty());
    assertEquals(SupportedFieldType.ADDITIONAL_FOREIGN_KEY, ((BasicFieldMetadata) metadata).getFieldType());
  }

  /**
   * Test
   * {@link DynamicFieldPersistenceHandlerHelper#buildDynamicProperty(FieldDefinition, Class)}.
   * <ul>
   *   <li>Given {@code UNKNOWN}.</li>
   *   <li>Then return Metadata ForeignKeyClass is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DynamicFieldPersistenceHandlerHelper#buildDynamicProperty(FieldDefinition, Class)}
   */
  @Test
  public void testBuildDynamicProperty_givenUnknown_thenReturnMetadataForeignKeyClassIsNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DynamicFieldPersistenceHandlerHelper dynamicFieldPersistenceHandlerHelper = new DynamicFieldPersistenceHandlerHelper();
    FieldDefinitionImpl definition = mock(FieldDefinitionImpl.class);
    when(definition.getValidationErrorMesageKey()).thenReturn("An error occurred");
    when(definition.getFieldOrder()).thenReturn(1);
    when(definition.getHiddenFlag()).thenReturn(true);
    when(definition.getRequiredFlag()).thenReturn(true);
    when(definition.getTextAreaFlag()).thenReturn(true);
    when(definition.getMaxLength()).thenReturn(3);
    when(definition.getColumnWidth()).thenReturn("Column Width");
    when(definition.getFriendlyName()).thenReturn("Friendly Name");
    when(definition.getHelpText()).thenReturn("Help Text");
    when(definition.getHint()).thenReturn("Hint");
    when(definition.getName()).thenReturn("Name");
    when(definition.getSecurityLevel()).thenReturn("Security Level");
    when(definition.getTooltip()).thenReturn("127.0.0.1");
    when(definition.getValidationRegEx()).thenReturn(".*");
    when(definition.getDataDrivenEnumeration()).thenReturn(new DataDrivenEnumerationImpl());
    when(definition.getFieldType()).thenReturn(SupportedFieldType.UNKNOWN);
    Class<Object> inheritedType = Object.class;

    // Act
    Property actualBuildDynamicPropertyResult = dynamicFieldPersistenceHandlerHelper.buildDynamicProperty(definition,
        inheritedType);

    // Assert
    verify(definition).getColumnWidth();
    verify(definition, atLeast(1)).getDataDrivenEnumeration();
    verify(definition).getFieldOrder();
    verify(definition, atLeast(1)).getFieldType();
    verify(definition).getFriendlyName();
    verify(definition).getHelpText();
    verify(definition).getHiddenFlag();
    verify(definition).getHint();
    verify(definition).getMaxLength();
    verify(definition, atLeast(1)).getName();
    verify(definition).getRequiredFlag();
    verify(definition, atLeast(1)).getSecurityLevel();
    verify(definition).getTextAreaFlag();
    verify(definition).getTooltip();
    verify(definition).getValidationErrorMesageKey();
    verify(definition, atLeast(1)).getValidationRegEx();
    FieldMetadata metadata = actualBuildDynamicPropertyResult.getMetadata();
    assertTrue(metadata instanceof BasicFieldMetadata);
    assertNull(((BasicFieldMetadata) metadata).getForeignKeyClass());
    assertNull(((BasicFieldMetadata) metadata).getForeignKeyDisplayValueProperty());
    assertNull(metadata.getOwningClass());
    assertEquals(SupportedFieldType.UNKNOWN, ((BasicFieldMetadata) metadata).getFieldType());
  }

  /**
   * Test
   * {@link DynamicFieldPersistenceHandlerHelper#buildDynamicPropertyList(List, Class)}
   * with {@code List}, {@code Class}.
   * <p>
   * Method under test:
   * {@link DynamicFieldPersistenceHandlerHelper#buildDynamicPropertyList(List, Class)}
   */
  @Test
  public void testBuildDynamicPropertyListWithListClass() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DynamicFieldPersistenceHandlerHelper dynamicFieldPersistenceHandlerHelper = new DynamicFieldPersistenceHandlerHelper();
    FieldDefinitionImpl fieldDefinitionImpl = mock(FieldDefinitionImpl.class);
    when(fieldDefinitionImpl.getValidationErrorMesageKey()).thenReturn("An error occurred");
    when(fieldDefinitionImpl.getFieldOrder()).thenReturn(1);
    when(fieldDefinitionImpl.getHiddenFlag()).thenReturn(true);
    when(fieldDefinitionImpl.getRequiredFlag()).thenReturn(true);
    when(fieldDefinitionImpl.getTextAreaFlag()).thenReturn(true);
    when(fieldDefinitionImpl.getMaxLength()).thenReturn(3);
    when(fieldDefinitionImpl.getColumnWidth()).thenReturn("Column Width");
    when(fieldDefinitionImpl.getFriendlyName()).thenReturn("Friendly Name");
    when(fieldDefinitionImpl.getHelpText()).thenReturn("Help Text");
    when(fieldDefinitionImpl.getHint()).thenReturn("Hint");
    when(fieldDefinitionImpl.getName()).thenReturn("Name");
    when(fieldDefinitionImpl.getSecurityLevel()).thenReturn("Security Level");
    when(fieldDefinitionImpl.getTooltip()).thenReturn("127.0.0.1");
    when(fieldDefinitionImpl.getValidationRegEx()).thenReturn(".*");
    when(fieldDefinitionImpl.getDataDrivenEnumeration()).thenReturn(new DataDrivenEnumerationImpl());
    when(fieldDefinitionImpl.getFieldType()).thenReturn(SupportedFieldType.UNKNOWN);

    ArrayList<FieldDefinition> fieldDefinitionList = new ArrayList<>();
    fieldDefinitionList.add(fieldDefinitionImpl);
    FieldGroupImpl fieldGroupImpl = mock(FieldGroupImpl.class);
    when(fieldGroupImpl.getInitCollapsedFlag()).thenReturn(true);
    when(fieldGroupImpl.getName()).thenReturn("Name");
    when(fieldGroupImpl.getFieldDefinitions()).thenReturn(fieldDefinitionList);

    ArrayList<FieldGroup> fieldGroups = new ArrayList<>();
    fieldGroups.add(fieldGroupImpl);
    Class<Object> inheritedType = Object.class;

    // Act
    Property[] actualBuildDynamicPropertyListResult = dynamicFieldPersistenceHandlerHelper
        .buildDynamicPropertyList(fieldGroups, inheritedType);

    // Assert
    verify(fieldDefinitionImpl).getColumnWidth();
    verify(fieldDefinitionImpl, atLeast(1)).getDataDrivenEnumeration();
    verify(fieldDefinitionImpl).getFieldOrder();
    verify(fieldDefinitionImpl, atLeast(1)).getFieldType();
    verify(fieldDefinitionImpl).getFriendlyName();
    verify(fieldDefinitionImpl).getHelpText();
    verify(fieldDefinitionImpl).getHiddenFlag();
    verify(fieldDefinitionImpl).getHint();
    verify(fieldDefinitionImpl).getMaxLength();
    verify(fieldDefinitionImpl, atLeast(1)).getName();
    verify(fieldDefinitionImpl).getRequiredFlag();
    verify(fieldDefinitionImpl, atLeast(1)).getSecurityLevel();
    verify(fieldDefinitionImpl).getTextAreaFlag();
    verify(fieldDefinitionImpl).getTooltip();
    verify(fieldDefinitionImpl).getValidationErrorMesageKey();
    verify(fieldDefinitionImpl, atLeast(1)).getValidationRegEx();
    verify(fieldGroupImpl).getFieldDefinitions();
    verify(fieldGroupImpl).getInitCollapsedFlag();
    verify(fieldGroupImpl).getName();
    Property property = actualBuildDynamicPropertyListResult[0];
    FieldMetadata metadata = property.getMetadata();
    assertTrue(metadata instanceof BasicFieldMetadata);
    Property property2 = actualBuildDynamicPropertyListResult[1];
    FieldMetadata metadata2 = property2.getMetadata();
    assertTrue(metadata2 instanceof BasicFieldMetadata);
    assertEquals("", ((BasicFieldMetadata) metadata2).getBroadleafEnumeration());
    assertEquals("", metadata2.getSecurityLevel());
    assertEquals("*", ((BasicFieldMetadata) metadata2).getColumnWidth());
    Map<String, List<Map<String, String>>> validationConfigurations = ((BasicFieldMetadata) metadata)
        .getValidationConfigurations();
    assertEquals(1, validationConfigurations.size());
    List<Map<String, String>> getResult = validationConfigurations.get("blRegexPropertyValidator");
    assertEquals(1, getResult.size());
    Map<String, String> getResult2 = getResult.get(0);
    assertEquals(2, getResult2.size());
    assertEquals(".*", getResult2.get("regularExpression"));
    assertEquals("An error occurred", getResult2.get("errorMessage"));
    assertEquals("Column Width", ((BasicFieldMetadata) metadata).getColumnWidth());
    assertEquals("Friendly Name", metadata.getFriendlyName());
    assertEquals("General", metadata.getTab());
    assertEquals("Help Text", ((BasicFieldMetadata) metadata).getHelpText());
    assertEquals("Hint", ((BasicFieldMetadata) metadata).getHint());
    assertEquals("ID", metadata2.getFriendlyName());
    assertEquals("Name", ((BasicFieldMetadata) metadata).getName());
    assertEquals("Name", metadata.getGroup());
    assertEquals("Name", property.getName());
    assertEquals("Security Level", metadata.getSecurityLevel());
    assertEquals("id", ((BasicFieldMetadata) metadata2).getName());
    assertEquals("id", property2.getName());
    assertEquals("java.lang.Object", metadata2.getInheritedFromType());
    assertNull(((BasicFieldMetadata) metadata2).getCustomCriteria());
    assertNull(((BasicFieldMetadata) metadata2).getEnumerationValues());
    assertNull(((BasicFieldMetadata) metadata2).getOptionFilterParams());
    assertNull(((BasicFieldMetadata) metadata2).getCanLinkToExternalEntity());
    assertNull(((BasicFieldMetadata) metadata2).getEnableTypeaheadLookup());
    assertNull(((BasicFieldMetadata) metadata2).getForcePopulateChildProperties());
    assertNull(((BasicFieldMetadata) metadata2).getGroupCollapsed());
    assertNull(((BasicFieldMetadata) metadata2).getHideEnumerationIfEmpty());
    assertNull(((BasicFieldMetadata) metadata2).getIsDerived());
    assertNull(((BasicFieldMetadata) metadata2).getIsFilter());
    assertNull(((BasicFieldMetadata) metadata2).getOptionCanEditValues());
    assertNull(((BasicFieldMetadata) metadata2).getOptionHideIfEmpty());
    assertNull(((BasicFieldMetadata) metadata2).getRequiredOverride());
    assertNull(((BasicFieldMetadata) metadata2).getSearchable());
    assertNull(((BasicFieldMetadata) metadata2).getToOneLookupCreatedViaAnnotation());
    assertNull(((BasicFieldMetadata) metadata2).getTranslatable());
    assertNull(((BasicFieldMetadata) metadata2).getUnique());
    assertNull(((BasicFieldMetadata) metadata2).getUseServerSideInspectionCache());
    assertNull(metadata2.getChildrenExcluded());
    assertNull(metadata2.getExcluded());
    assertNull(metadata2.getLazyFetch());
    assertNull(((BasicFieldMetadata) metadata2).getGridOrder());
    assertNull(((BasicFieldMetadata) metadata2).getLength());
    assertNull(((BasicFieldMetadata) metadata2).getPrecision());
    assertNull(((BasicFieldMetadata) metadata2).getScale());
    assertNull(metadata2.getGroupOrder());
    assertNull(metadata2.getOrder());
    assertNull(metadata2.getTabOrder());
    assertNull(((BasicFieldMetadata) metadata2).getAssociatedFieldName());
    assertNull(((BasicFieldMetadata) metadata2).getDefaultValue());
    assertNull(((BasicFieldMetadata) metadata2).getEnumerationClass());
    assertNull(((BasicFieldMetadata) metadata2).getFieldComponentRendererTemplate());
    assertNull(((BasicFieldMetadata) metadata2).getForeignKeyClass());
    assertNull(((BasicFieldMetadata) metadata2).getForeignKeyDisplayValueProperty());
    assertNull(((BasicFieldMetadata) metadata2).getForeignKeyProperty());
    assertNull(((BasicFieldMetadata) metadata2).getGridFieldComponentRendererTemplate());
    assertNull(((BasicFieldMetadata) metadata2).getHelpText());
    assertNull(((BasicFieldMetadata) metadata2).getHint());
    assertNull(((BasicFieldMetadata) metadata2).getLookupDisplayProperty());
    assertNull(((BasicFieldMetadata) metadata2).getManyToField());
    assertNull(((BasicFieldMetadata) metadata2).getMapFieldValueClass());
    assertNull(((BasicFieldMetadata) metadata2).getMapKeyValueProperty());
    assertNull(((BasicFieldMetadata) metadata2).getOptionDisplayFieldName());
    assertNull(((BasicFieldMetadata) metadata2).getOptionListEntity());
    assertNull(((BasicFieldMetadata) metadata2).getOptionValueFieldName());
    assertNull(((BasicFieldMetadata) metadata2).getRuleIdentifier());
    assertNull(((BasicFieldMetadata) metadata2).getToOneParentProperty());
    assertNull(((BasicFieldMetadata) metadata2).getToOneTargetProperty());
    assertNull(((BasicFieldMetadata) metadata2).getTooltip());
    assertNull(metadata2.getAddFriendlyName());
    assertNull(metadata2.getCurrencyCodeField());
    assertNull(metadata2.getFieldName());
    assertNull(metadata2.getGroup());
    assertNull(metadata2.getOwningClass());
    assertNull(metadata2.getOwningClassFriendlyName());
    assertNull(metadata2.getPrefix());
    assertNull(metadata2.getShowIfProperty());
    assertNull(metadata2.getTab());
    assertNull(metadata2.getTargetClass());
    assertNull(property2.getDisplayValue());
    assertNull(property2.getOriginalDisplayValue());
    assertNull(property2.getOriginalValue());
    assertNull(property2.getRawValue());
    assertNull(property2.getUnHtmlEncodedValue());
    assertNull(property2.getValue());
    assertNull(property2.getDeployDate());
    assertNull(metadata2.getShowIfFieldEquals());
    assertNull(((BasicFieldMetadata) metadata2).getLookupType());
    assertNull(((BasicFieldMetadata) metadata2).getDisplayType());
    assertNull(((BasicFieldMetadata) metadata2).getFieldComponentRenderer());
    assertNull(((BasicFieldMetadata) metadata2).getGridFieldComponentRenderer());
    assertEquals(0, metadata.getGroupOrder().intValue());
    assertEquals(1, metadata.getOrder().intValue());
    assertEquals(100, metadata.getTabOrder().intValue());
    assertEquals(2, actualBuildDynamicPropertyListResult.length);
    assertEquals(3, ((BasicFieldMetadata) metadata).getLength().intValue());
    assertEquals(SupportedFieldType.ID, ((BasicFieldMetadata) metadata2).getFieldType());
    assertEquals(SupportedFieldType.INTEGER, ((BasicFieldMetadata) metadata2).getSecondaryType());
    assertEquals(SupportedFieldType.UNKNOWN, ((BasicFieldMetadata) metadata2).getExplicitFieldType());
    assertEquals(SupportedFieldType.UNKNOWN, ((BasicFieldMetadata) metadata).getFieldType());
    assertEquals(VisibilityEnum.HIDDEN_ALL, ((BasicFieldMetadata) metadata2).getVisibility());
    assertEquals(MergedPropertyType.PRIMARY, ((BasicFieldMetadata) metadata2).getMergedPropertyType());
    assertFalse(((BasicFieldMetadata) metadata).getAllowNoValueEnumOption());
    assertFalse(((BasicFieldMetadata) metadata2).getForeignKeyCollection());
    assertFalse(((BasicFieldMetadata) metadata).getReadOnly());
    assertFalse(((BasicFieldMetadata) metadata2).getRequired());
    assertFalse(((BasicFieldMetadata) metadata2).isLargeEntry());
    assertFalse(((BasicFieldMetadata) metadata2).isProminent());
    assertFalse(metadata2.getManualFetch());
    assertFalse(property2.getIsDirty());
    assertFalse(property2.isAdvancedCollection());
    assertTrue(((BasicFieldMetadata) metadata2).getValidationConfigurations().isEmpty());
    assertTrue(metadata2.getAdditionalMetadata().isEmpty());
    assertTrue(((BasicFieldMetadata) metadata2).getAllowNoValueEnumOption());
    assertTrue(((BasicFieldMetadata) metadata).getGroupCollapsed());
    assertTrue(((BasicFieldMetadata) metadata2).getMutable());
    assertTrue(((BasicFieldMetadata) metadata2).getReadOnly());
    assertTrue(((BasicFieldMetadata) metadata).getRequiredOverride());
    assertTrue(((BasicFieldMetadata) metadata).getTranslatable());
    assertTrue(((BasicFieldMetadata) metadata).isLargeEntry());
    assertTrue(property2.getEnabled());
    assertArrayEquals(new String[]{"java.lang.Object"}, metadata2.getAvailableToTypes());
  }

  /**
   * Test
   * {@link DynamicFieldPersistenceHandlerHelper#buildDynamicPropertyList(List, Class)}
   * with {@code List}, {@code Class}.
   * <p>
   * Method under test:
   * {@link DynamicFieldPersistenceHandlerHelper#buildDynamicPropertyList(List, Class)}
   */
  @Test
  public void testBuildDynamicPropertyListWithListClass2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DynamicFieldPersistenceHandlerHelper dynamicFieldPersistenceHandlerHelper = new DynamicFieldPersistenceHandlerHelper();
    FieldDefinitionImpl fieldDefinitionImpl = mock(FieldDefinitionImpl.class);
    when(fieldDefinitionImpl.getAdditionalForeignKeyClass()).thenReturn("Additional Foreign Key Class");
    when(fieldDefinitionImpl.getValidationErrorMesageKey()).thenReturn("An error occurred");
    when(fieldDefinitionImpl.getFieldOrder()).thenReturn(1);
    when(fieldDefinitionImpl.getHiddenFlag()).thenReturn(true);
    when(fieldDefinitionImpl.getRequiredFlag()).thenReturn(true);
    when(fieldDefinitionImpl.getTextAreaFlag()).thenReturn(true);
    when(fieldDefinitionImpl.getMaxLength()).thenReturn(3);
    when(fieldDefinitionImpl.getColumnWidth()).thenReturn("Column Width");
    when(fieldDefinitionImpl.getFriendlyName()).thenReturn("Friendly Name");
    when(fieldDefinitionImpl.getHelpText()).thenReturn("Help Text");
    when(fieldDefinitionImpl.getHint()).thenReturn("Hint");
    when(fieldDefinitionImpl.getName()).thenReturn("Name");
    when(fieldDefinitionImpl.getSecurityLevel()).thenReturn("Security Level");
    when(fieldDefinitionImpl.getTooltip()).thenReturn("127.0.0.1");
    when(fieldDefinitionImpl.getValidationRegEx()).thenReturn(".*");
    when(fieldDefinitionImpl.getDataDrivenEnumeration()).thenReturn(new DataDrivenEnumerationImpl());
    when(fieldDefinitionImpl.getFieldType()).thenReturn(SupportedFieldType.ADDITIONAL_FOREIGN_KEY);

    ArrayList<FieldDefinition> fieldDefinitionList = new ArrayList<>();
    fieldDefinitionList.add(fieldDefinitionImpl);
    FieldGroupImpl fieldGroupImpl = mock(FieldGroupImpl.class);
    when(fieldGroupImpl.getInitCollapsedFlag()).thenReturn(true);
    when(fieldGroupImpl.getName()).thenReturn("Name");
    when(fieldGroupImpl.getFieldDefinitions()).thenReturn(fieldDefinitionList);

    ArrayList<FieldGroup> fieldGroups = new ArrayList<>();
    fieldGroups.add(fieldGroupImpl);
    Class<Object> inheritedType = Object.class;

    // Act
    Property[] actualBuildDynamicPropertyListResult = dynamicFieldPersistenceHandlerHelper
        .buildDynamicPropertyList(fieldGroups, inheritedType);

    // Assert
    verify(fieldDefinitionImpl, atLeast(1)).getAdditionalForeignKeyClass();
    verify(fieldDefinitionImpl).getColumnWidth();
    verify(fieldDefinitionImpl, atLeast(1)).getDataDrivenEnumeration();
    verify(fieldDefinitionImpl).getFieldOrder();
    verify(fieldDefinitionImpl, atLeast(1)).getFieldType();
    verify(fieldDefinitionImpl).getFriendlyName();
    verify(fieldDefinitionImpl).getHelpText();
    verify(fieldDefinitionImpl).getHiddenFlag();
    verify(fieldDefinitionImpl).getHint();
    verify(fieldDefinitionImpl).getMaxLength();
    verify(fieldDefinitionImpl, atLeast(1)).getName();
    verify(fieldDefinitionImpl).getRequiredFlag();
    verify(fieldDefinitionImpl, atLeast(1)).getSecurityLevel();
    verify(fieldDefinitionImpl).getTextAreaFlag();
    verify(fieldDefinitionImpl).getTooltip();
    verify(fieldDefinitionImpl).getValidationErrorMesageKey();
    verify(fieldDefinitionImpl, atLeast(1)).getValidationRegEx();
    verify(fieldGroupImpl).getFieldDefinitions();
    verify(fieldGroupImpl).getInitCollapsedFlag();
    verify(fieldGroupImpl).getName();
    FieldMetadata metadata = (actualBuildDynamicPropertyListResult[0]).getMetadata();
    assertTrue(metadata instanceof BasicFieldMetadata);
    assertEquals("Additional Foreign Key Class", ((BasicFieldMetadata) metadata).getForeignKeyClass());
    assertEquals("Additional Foreign Key Class", metadata.getOwningClass());
    assertEquals("__adminMainEntity", ((BasicFieldMetadata) metadata).getForeignKeyDisplayValueProperty());
    assertEquals(2, actualBuildDynamicPropertyListResult.length);
    assertEquals(SupportedFieldType.ADDITIONAL_FOREIGN_KEY, ((BasicFieldMetadata) metadata).getFieldType());
  }

  /**
   * Test
   * {@link DynamicFieldPersistenceHandlerHelper#buildDynamicPropertyList(List, Class)}
   * with {@code List}, {@code Class}.
   * <ul>
   *   <li>Given {@link FieldGroupImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DynamicFieldPersistenceHandlerHelper#buildDynamicPropertyList(List, Class)}
   */
  @Test
  public void testBuildDynamicPropertyListWithListClass_givenFieldGroupImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DynamicFieldPersistenceHandlerHelper dynamicFieldPersistenceHandlerHelper = new DynamicFieldPersistenceHandlerHelper();

    ArrayList<FieldGroup> fieldGroups = new ArrayList<>();
    fieldGroups.add(new FieldGroupImpl());
    Class<Object> inheritedType = Object.class;

    // Act
    Property[] actualBuildDynamicPropertyListResult = dynamicFieldPersistenceHandlerHelper
        .buildDynamicPropertyList(fieldGroups, inheritedType);

    // Assert
    Property property = actualBuildDynamicPropertyListResult[0];
    FieldMetadata metadata = property.getMetadata();
    assertTrue(metadata instanceof BasicFieldMetadata);
    assertEquals("", metadata.getSecurityLevel());
    assertEquals("*", ((BasicFieldMetadata) metadata).getColumnWidth());
    assertEquals("ID", metadata.getFriendlyName());
    assertEquals("id", ((BasicFieldMetadata) metadata).getName());
    assertEquals("id", property.getName());
    assertNull(((BasicFieldMetadata) metadata).getGroupCollapsed());
    assertNull(((BasicFieldMetadata) metadata).getRequiredOverride());
    assertNull(((BasicFieldMetadata) metadata).getTranslatable());
    assertNull(((BasicFieldMetadata) metadata).getLength());
    assertNull(metadata.getGroupOrder());
    assertNull(metadata.getOrder());
    assertNull(metadata.getTabOrder());
    assertNull(((BasicFieldMetadata) metadata).getHelpText());
    assertNull(((BasicFieldMetadata) metadata).getHint());
    assertNull(((BasicFieldMetadata) metadata).getTooltip());
    assertNull(metadata.getGroup());
    assertNull(metadata.getTab());
    assertEquals(1, actualBuildDynamicPropertyListResult.length);
    assertEquals(SupportedFieldType.ID, ((BasicFieldMetadata) metadata).getFieldType());
    assertFalse(((BasicFieldMetadata) metadata).isLargeEntry());
    assertTrue(((BasicFieldMetadata) metadata).getValidationConfigurations().isEmpty());
    assertTrue(((BasicFieldMetadata) metadata).getAllowNoValueEnumOption());
    assertTrue(((BasicFieldMetadata) metadata).getReadOnly());
  }

  /**
   * Test
   * {@link DynamicFieldPersistenceHandlerHelper#buildDynamicPropertyList(List, Class)}
   * with {@code List}, {@code Class}.
   * <ul>
   *   <li>Given {@link FieldGroupImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DynamicFieldPersistenceHandlerHelper#buildDynamicPropertyList(List, Class)}
   */
  @Test
  public void testBuildDynamicPropertyListWithListClass_givenFieldGroupImpl2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DynamicFieldPersistenceHandlerHelper dynamicFieldPersistenceHandlerHelper = new DynamicFieldPersistenceHandlerHelper();

    ArrayList<FieldGroup> fieldGroups = new ArrayList<>();
    fieldGroups.add(new FieldGroupImpl());
    fieldGroups.add(new FieldGroupImpl());
    Class<Object> inheritedType = Object.class;

    // Act
    Property[] actualBuildDynamicPropertyListResult = dynamicFieldPersistenceHandlerHelper
        .buildDynamicPropertyList(fieldGroups, inheritedType);

    // Assert
    Property property = actualBuildDynamicPropertyListResult[0];
    FieldMetadata metadata = property.getMetadata();
    assertTrue(metadata instanceof BasicFieldMetadata);
    assertEquals("", metadata.getSecurityLevel());
    assertEquals("*", ((BasicFieldMetadata) metadata).getColumnWidth());
    assertEquals("ID", metadata.getFriendlyName());
    assertEquals("id", ((BasicFieldMetadata) metadata).getName());
    assertEquals("id", property.getName());
    assertNull(((BasicFieldMetadata) metadata).getGroupCollapsed());
    assertNull(((BasicFieldMetadata) metadata).getRequiredOverride());
    assertNull(((BasicFieldMetadata) metadata).getTranslatable());
    assertNull(((BasicFieldMetadata) metadata).getLength());
    assertNull(metadata.getGroupOrder());
    assertNull(metadata.getOrder());
    assertNull(metadata.getTabOrder());
    assertNull(((BasicFieldMetadata) metadata).getHelpText());
    assertNull(((BasicFieldMetadata) metadata).getHint());
    assertNull(((BasicFieldMetadata) metadata).getTooltip());
    assertNull(metadata.getGroup());
    assertNull(metadata.getTab());
    assertEquals(1, actualBuildDynamicPropertyListResult.length);
    assertEquals(SupportedFieldType.ID, ((BasicFieldMetadata) metadata).getFieldType());
    assertFalse(((BasicFieldMetadata) metadata).isLargeEntry());
    assertTrue(((BasicFieldMetadata) metadata).getValidationConfigurations().isEmpty());
    assertTrue(((BasicFieldMetadata) metadata).getAllowNoValueEnumOption());
    assertTrue(((BasicFieldMetadata) metadata).getReadOnly());
  }

  /**
   * Test
   * {@link DynamicFieldPersistenceHandlerHelper#buildDynamicPropertyList(List, Class)}
   * with {@code List}, {@code Class}.
   * <ul>
   *   <li>Then calls {@link FieldGroupImpl#getFieldDefinitions()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DynamicFieldPersistenceHandlerHelper#buildDynamicPropertyList(List, Class)}
   */
  @Test
  public void testBuildDynamicPropertyListWithListClass_thenCallsGetFieldDefinitions() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DynamicFieldPersistenceHandlerHelper dynamicFieldPersistenceHandlerHelper = new DynamicFieldPersistenceHandlerHelper();
    FieldGroupImpl fieldGroupImpl = mock(FieldGroupImpl.class);
    when(fieldGroupImpl.getFieldDefinitions()).thenReturn(new ArrayList<>());

    ArrayList<FieldGroup> fieldGroups = new ArrayList<>();
    fieldGroups.add(fieldGroupImpl);
    Class<Object> inheritedType = Object.class;

    // Act
    Property[] actualBuildDynamicPropertyListResult = dynamicFieldPersistenceHandlerHelper
        .buildDynamicPropertyList(fieldGroups, inheritedType);

    // Assert
    verify(fieldGroupImpl).getFieldDefinitions();
    Property property = actualBuildDynamicPropertyListResult[0];
    FieldMetadata metadata = property.getMetadata();
    assertTrue(metadata instanceof BasicFieldMetadata);
    assertEquals("", metadata.getSecurityLevel());
    assertEquals("*", ((BasicFieldMetadata) metadata).getColumnWidth());
    assertEquals("ID", metadata.getFriendlyName());
    assertEquals("id", ((BasicFieldMetadata) metadata).getName());
    assertEquals("id", property.getName());
    assertNull(((BasicFieldMetadata) metadata).getGroupCollapsed());
    assertNull(((BasicFieldMetadata) metadata).getRequiredOverride());
    assertNull(((BasicFieldMetadata) metadata).getTranslatable());
    assertNull(((BasicFieldMetadata) metadata).getLength());
    assertNull(metadata.getGroupOrder());
    assertNull(metadata.getOrder());
    assertNull(metadata.getTabOrder());
    assertNull(((BasicFieldMetadata) metadata).getHelpText());
    assertNull(((BasicFieldMetadata) metadata).getHint());
    assertNull(((BasicFieldMetadata) metadata).getTooltip());
    assertNull(metadata.getGroup());
    assertNull(metadata.getTab());
    assertEquals(1, actualBuildDynamicPropertyListResult.length);
    assertEquals(SupportedFieldType.ID, ((BasicFieldMetadata) metadata).getFieldType());
    assertFalse(((BasicFieldMetadata) metadata).isLargeEntry());
    assertTrue(((BasicFieldMetadata) metadata).getValidationConfigurations().isEmpty());
    assertTrue(((BasicFieldMetadata) metadata).getAllowNoValueEnumOption());
    assertTrue(((BasicFieldMetadata) metadata).getReadOnly());
  }

  /**
   * Test
   * {@link DynamicFieldPersistenceHandlerHelper#buildDynamicPropertyList(List, Class)}
   * with {@code List}, {@code Class}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DynamicFieldPersistenceHandlerHelper#buildDynamicPropertyList(List, Class)}
   */
  @Test
  public void testBuildDynamicPropertyListWithListClass_whenArrayList() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DynamicFieldPersistenceHandlerHelper dynamicFieldPersistenceHandlerHelper = new DynamicFieldPersistenceHandlerHelper();
    ArrayList<FieldGroup> fieldGroups = new ArrayList<>();
    Class<Object> inheritedType = Object.class;

    // Act
    Property[] actualBuildDynamicPropertyListResult = dynamicFieldPersistenceHandlerHelper
        .buildDynamicPropertyList(fieldGroups, inheritedType);

    // Assert
    Property property = actualBuildDynamicPropertyListResult[0];
    FieldMetadata metadata = property.getMetadata();
    assertTrue(metadata instanceof BasicFieldMetadata);
    assertEquals("", metadata.getSecurityLevel());
    assertEquals("*", ((BasicFieldMetadata) metadata).getColumnWidth());
    assertEquals("ID", metadata.getFriendlyName());
    assertEquals("id", ((BasicFieldMetadata) metadata).getName());
    assertEquals("id", property.getName());
    assertNull(((BasicFieldMetadata) metadata).getGroupCollapsed());
    assertNull(((BasicFieldMetadata) metadata).getRequiredOverride());
    assertNull(((BasicFieldMetadata) metadata).getTranslatable());
    assertNull(((BasicFieldMetadata) metadata).getLength());
    assertNull(metadata.getGroupOrder());
    assertNull(metadata.getOrder());
    assertNull(metadata.getTabOrder());
    assertNull(((BasicFieldMetadata) metadata).getHelpText());
    assertNull(((BasicFieldMetadata) metadata).getHint());
    assertNull(((BasicFieldMetadata) metadata).getTooltip());
    assertNull(metadata.getGroup());
    assertNull(metadata.getTab());
    assertEquals(1, actualBuildDynamicPropertyListResult.length);
    assertEquals(SupportedFieldType.ID, ((BasicFieldMetadata) metadata).getFieldType());
    assertFalse(((BasicFieldMetadata) metadata).isLargeEntry());
    assertTrue(((BasicFieldMetadata) metadata).getValidationConfigurations().isEmpty());
    assertTrue(((BasicFieldMetadata) metadata).getAllowNoValueEnumOption());
    assertTrue(((BasicFieldMetadata) metadata).getReadOnly());
  }

  /**
   * Test
   * {@link DynamicFieldPersistenceHandlerHelper#buildDynamicPropertyList(Map, Class)}
   * with {@code Map}, {@code Class}.
   * <ul>
   *   <li>Given {@link BiFunction}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DynamicFieldPersistenceHandlerHelper#buildDynamicPropertyList(Map, Class)}
   */
  @Test
  public void testBuildDynamicPropertyListWithMapClass_givenBiFunction() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DynamicFieldPersistenceHandlerHelper dynamicFieldPersistenceHandlerHelper = new DynamicFieldPersistenceHandlerHelper();

    HashMap<FieldGroup, Long> fieldGroups = new HashMap<>();
    fieldGroups.computeIfPresent(new FieldGroupImpl(), mock(BiFunction.class));
    fieldGroups.put(new FieldGroupImpl(), 5L);
    Class<Object> inheritedType = Object.class;

    // Act
    Property[] actualBuildDynamicPropertyListResult = dynamicFieldPersistenceHandlerHelper
        .buildDynamicPropertyList(fieldGroups, inheritedType);

    // Assert
    Property property = actualBuildDynamicPropertyListResult[0];
    FieldMetadata metadata = property.getMetadata();
    assertTrue(metadata instanceof BasicFieldMetadata);
    assertEquals("", ((BasicFieldMetadata) metadata).getBroadleafEnumeration());
    assertEquals("", metadata.getSecurityLevel());
    assertEquals("*", ((BasicFieldMetadata) metadata).getColumnWidth());
    assertEquals("ID", metadata.getFriendlyName());
    assertEquals("id", ((BasicFieldMetadata) metadata).getName());
    assertEquals("id", property.getName());
    assertEquals("java.lang.Object", metadata.getInheritedFromType());
    assertNull(((BasicFieldMetadata) metadata).getCustomCriteria());
    assertNull(((BasicFieldMetadata) metadata).getEnumerationValues());
    assertNull(((BasicFieldMetadata) metadata).getOptionFilterParams());
    assertNull(((BasicFieldMetadata) metadata).getCanLinkToExternalEntity());
    assertNull(((BasicFieldMetadata) metadata).getEnableTypeaheadLookup());
    assertNull(((BasicFieldMetadata) metadata).getForcePopulateChildProperties());
    assertNull(((BasicFieldMetadata) metadata).getGroupCollapsed());
    assertNull(((BasicFieldMetadata) metadata).getHideEnumerationIfEmpty());
    assertNull(((BasicFieldMetadata) metadata).getIsDerived());
    assertNull(((BasicFieldMetadata) metadata).getIsFilter());
    assertNull(((BasicFieldMetadata) metadata).getOptionCanEditValues());
    assertNull(((BasicFieldMetadata) metadata).getOptionHideIfEmpty());
    assertNull(((BasicFieldMetadata) metadata).getRequiredOverride());
    assertNull(((BasicFieldMetadata) metadata).getSearchable());
    assertNull(((BasicFieldMetadata) metadata).getToOneLookupCreatedViaAnnotation());
    assertNull(((BasicFieldMetadata) metadata).getTranslatable());
    assertNull(((BasicFieldMetadata) metadata).getUnique());
    assertNull(((BasicFieldMetadata) metadata).getUseServerSideInspectionCache());
    assertNull(metadata.getChildrenExcluded());
    assertNull(metadata.getExcluded());
    assertNull(metadata.getLazyFetch());
    assertNull(((BasicFieldMetadata) metadata).getGridOrder());
    assertNull(((BasicFieldMetadata) metadata).getLength());
    assertNull(((BasicFieldMetadata) metadata).getPrecision());
    assertNull(((BasicFieldMetadata) metadata).getScale());
    assertNull(metadata.getGroupOrder());
    assertNull(metadata.getOrder());
    assertNull(metadata.getTabOrder());
    assertNull(((BasicFieldMetadata) metadata).getAssociatedFieldName());
    assertNull(((BasicFieldMetadata) metadata).getDefaultValue());
    assertNull(((BasicFieldMetadata) metadata).getEnumerationClass());
    assertNull(((BasicFieldMetadata) metadata).getFieldComponentRendererTemplate());
    assertNull(((BasicFieldMetadata) metadata).getForeignKeyClass());
    assertNull(((BasicFieldMetadata) metadata).getForeignKeyDisplayValueProperty());
    assertNull(((BasicFieldMetadata) metadata).getForeignKeyProperty());
    assertNull(((BasicFieldMetadata) metadata).getGridFieldComponentRendererTemplate());
    assertNull(((BasicFieldMetadata) metadata).getHelpText());
    assertNull(((BasicFieldMetadata) metadata).getHint());
    assertNull(((BasicFieldMetadata) metadata).getLookupDisplayProperty());
    assertNull(((BasicFieldMetadata) metadata).getManyToField());
    assertNull(((BasicFieldMetadata) metadata).getMapFieldValueClass());
    assertNull(((BasicFieldMetadata) metadata).getMapKeyValueProperty());
    assertNull(((BasicFieldMetadata) metadata).getOptionDisplayFieldName());
    assertNull(((BasicFieldMetadata) metadata).getOptionListEntity());
    assertNull(((BasicFieldMetadata) metadata).getOptionValueFieldName());
    assertNull(((BasicFieldMetadata) metadata).getRuleIdentifier());
    assertNull(((BasicFieldMetadata) metadata).getToOneParentProperty());
    assertNull(((BasicFieldMetadata) metadata).getToOneTargetProperty());
    assertNull(((BasicFieldMetadata) metadata).getTooltip());
    assertNull(metadata.getAddFriendlyName());
    assertNull(metadata.getCurrencyCodeField());
    assertNull(metadata.getFieldName());
    assertNull(metadata.getGroup());
    assertNull(metadata.getOwningClass());
    assertNull(metadata.getOwningClassFriendlyName());
    assertNull(metadata.getPrefix());
    assertNull(metadata.getShowIfProperty());
    assertNull(metadata.getTab());
    assertNull(metadata.getTargetClass());
    assertNull(property.getDisplayValue());
    assertNull(property.getOriginalDisplayValue());
    assertNull(property.getOriginalValue());
    assertNull(property.getRawValue());
    assertNull(property.getUnHtmlEncodedValue());
    assertNull(property.getValue());
    assertNull(property.getDeployDate());
    assertNull(metadata.getShowIfFieldEquals());
    assertNull(((BasicFieldMetadata) metadata).getLookupType());
    assertNull(((BasicFieldMetadata) metadata).getDisplayType());
    assertNull(((BasicFieldMetadata) metadata).getFieldComponentRenderer());
    assertNull(((BasicFieldMetadata) metadata).getGridFieldComponentRenderer());
    assertEquals(1, actualBuildDynamicPropertyListResult.length);
    assertEquals(SupportedFieldType.ID, ((BasicFieldMetadata) metadata).getFieldType());
    assertEquals(SupportedFieldType.INTEGER, ((BasicFieldMetadata) metadata).getSecondaryType());
    assertEquals(SupportedFieldType.UNKNOWN, ((BasicFieldMetadata) metadata).getExplicitFieldType());
    assertEquals(VisibilityEnum.HIDDEN_ALL, ((BasicFieldMetadata) metadata).getVisibility());
    assertEquals(MergedPropertyType.PRIMARY, ((BasicFieldMetadata) metadata).getMergedPropertyType());
    assertFalse(((BasicFieldMetadata) metadata).getForeignKeyCollection());
    assertFalse(((BasicFieldMetadata) metadata).getRequired());
    assertFalse(((BasicFieldMetadata) metadata).isLargeEntry());
    assertFalse(((BasicFieldMetadata) metadata).isProminent());
    assertFalse(metadata.getManualFetch());
    assertFalse(property.getIsDirty());
    assertFalse(property.isAdvancedCollection());
    assertTrue(((BasicFieldMetadata) metadata).getValidationConfigurations().isEmpty());
    assertTrue(metadata.getAdditionalMetadata().isEmpty());
    assertTrue(((BasicFieldMetadata) metadata).getAllowNoValueEnumOption());
    assertTrue(((BasicFieldMetadata) metadata).getMutable());
    assertTrue(((BasicFieldMetadata) metadata).getReadOnly());
    assertTrue(property.getEnabled());
    assertArrayEquals(new String[]{"java.lang.Object"}, metadata.getAvailableToTypes());
  }

  /**
   * Test
   * {@link DynamicFieldPersistenceHandlerHelper#buildDynamicPropertyList(Map, Class)}
   * with {@code Map}, {@code Class}.
   * <ul>
   *   <li>Given {@link FieldGroupImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DynamicFieldPersistenceHandlerHelper#buildDynamicPropertyList(Map, Class)}
   */
  @Test
  public void testBuildDynamicPropertyListWithMapClass_givenFieldGroupImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DynamicFieldPersistenceHandlerHelper dynamicFieldPersistenceHandlerHelper = new DynamicFieldPersistenceHandlerHelper();

    HashMap<FieldGroup, Long> fieldGroups = new HashMap<>();
    fieldGroups.put(new FieldGroupImpl(), 5L);
    Class<Object> inheritedType = Object.class;

    // Act
    Property[] actualBuildDynamicPropertyListResult = dynamicFieldPersistenceHandlerHelper
        .buildDynamicPropertyList(fieldGroups, inheritedType);

    // Assert
    Property property = actualBuildDynamicPropertyListResult[0];
    FieldMetadata metadata = property.getMetadata();
    assertTrue(metadata instanceof BasicFieldMetadata);
    assertEquals("", ((BasicFieldMetadata) metadata).getBroadleafEnumeration());
    assertEquals("", metadata.getSecurityLevel());
    assertEquals("*", ((BasicFieldMetadata) metadata).getColumnWidth());
    assertEquals("ID", metadata.getFriendlyName());
    assertEquals("id", ((BasicFieldMetadata) metadata).getName());
    assertEquals("id", property.getName());
    assertEquals("java.lang.Object", metadata.getInheritedFromType());
    assertNull(((BasicFieldMetadata) metadata).getCustomCriteria());
    assertNull(((BasicFieldMetadata) metadata).getEnumerationValues());
    assertNull(((BasicFieldMetadata) metadata).getOptionFilterParams());
    assertNull(((BasicFieldMetadata) metadata).getCanLinkToExternalEntity());
    assertNull(((BasicFieldMetadata) metadata).getEnableTypeaheadLookup());
    assertNull(((BasicFieldMetadata) metadata).getForcePopulateChildProperties());
    assertNull(((BasicFieldMetadata) metadata).getGroupCollapsed());
    assertNull(((BasicFieldMetadata) metadata).getHideEnumerationIfEmpty());
    assertNull(((BasicFieldMetadata) metadata).getIsDerived());
    assertNull(((BasicFieldMetadata) metadata).getIsFilter());
    assertNull(((BasicFieldMetadata) metadata).getOptionCanEditValues());
    assertNull(((BasicFieldMetadata) metadata).getOptionHideIfEmpty());
    assertNull(((BasicFieldMetadata) metadata).getRequiredOverride());
    assertNull(((BasicFieldMetadata) metadata).getSearchable());
    assertNull(((BasicFieldMetadata) metadata).getToOneLookupCreatedViaAnnotation());
    assertNull(((BasicFieldMetadata) metadata).getTranslatable());
    assertNull(((BasicFieldMetadata) metadata).getUnique());
    assertNull(((BasicFieldMetadata) metadata).getUseServerSideInspectionCache());
    assertNull(metadata.getChildrenExcluded());
    assertNull(metadata.getExcluded());
    assertNull(metadata.getLazyFetch());
    assertNull(((BasicFieldMetadata) metadata).getGridOrder());
    assertNull(((BasicFieldMetadata) metadata).getLength());
    assertNull(((BasicFieldMetadata) metadata).getPrecision());
    assertNull(((BasicFieldMetadata) metadata).getScale());
    assertNull(metadata.getGroupOrder());
    assertNull(metadata.getOrder());
    assertNull(metadata.getTabOrder());
    assertNull(((BasicFieldMetadata) metadata).getAssociatedFieldName());
    assertNull(((BasicFieldMetadata) metadata).getDefaultValue());
    assertNull(((BasicFieldMetadata) metadata).getEnumerationClass());
    assertNull(((BasicFieldMetadata) metadata).getFieldComponentRendererTemplate());
    assertNull(((BasicFieldMetadata) metadata).getForeignKeyClass());
    assertNull(((BasicFieldMetadata) metadata).getForeignKeyDisplayValueProperty());
    assertNull(((BasicFieldMetadata) metadata).getForeignKeyProperty());
    assertNull(((BasicFieldMetadata) metadata).getGridFieldComponentRendererTemplate());
    assertNull(((BasicFieldMetadata) metadata).getHelpText());
    assertNull(((BasicFieldMetadata) metadata).getHint());
    assertNull(((BasicFieldMetadata) metadata).getLookupDisplayProperty());
    assertNull(((BasicFieldMetadata) metadata).getManyToField());
    assertNull(((BasicFieldMetadata) metadata).getMapFieldValueClass());
    assertNull(((BasicFieldMetadata) metadata).getMapKeyValueProperty());
    assertNull(((BasicFieldMetadata) metadata).getOptionDisplayFieldName());
    assertNull(((BasicFieldMetadata) metadata).getOptionListEntity());
    assertNull(((BasicFieldMetadata) metadata).getOptionValueFieldName());
    assertNull(((BasicFieldMetadata) metadata).getRuleIdentifier());
    assertNull(((BasicFieldMetadata) metadata).getToOneParentProperty());
    assertNull(((BasicFieldMetadata) metadata).getToOneTargetProperty());
    assertNull(((BasicFieldMetadata) metadata).getTooltip());
    assertNull(metadata.getAddFriendlyName());
    assertNull(metadata.getCurrencyCodeField());
    assertNull(metadata.getFieldName());
    assertNull(metadata.getGroup());
    assertNull(metadata.getOwningClass());
    assertNull(metadata.getOwningClassFriendlyName());
    assertNull(metadata.getPrefix());
    assertNull(metadata.getShowIfProperty());
    assertNull(metadata.getTab());
    assertNull(metadata.getTargetClass());
    assertNull(property.getDisplayValue());
    assertNull(property.getOriginalDisplayValue());
    assertNull(property.getOriginalValue());
    assertNull(property.getRawValue());
    assertNull(property.getUnHtmlEncodedValue());
    assertNull(property.getValue());
    assertNull(property.getDeployDate());
    assertNull(metadata.getShowIfFieldEquals());
    assertNull(((BasicFieldMetadata) metadata).getLookupType());
    assertNull(((BasicFieldMetadata) metadata).getDisplayType());
    assertNull(((BasicFieldMetadata) metadata).getFieldComponentRenderer());
    assertNull(((BasicFieldMetadata) metadata).getGridFieldComponentRenderer());
    assertEquals(1, actualBuildDynamicPropertyListResult.length);
    assertEquals(SupportedFieldType.ID, ((BasicFieldMetadata) metadata).getFieldType());
    assertEquals(SupportedFieldType.INTEGER, ((BasicFieldMetadata) metadata).getSecondaryType());
    assertEquals(SupportedFieldType.UNKNOWN, ((BasicFieldMetadata) metadata).getExplicitFieldType());
    assertEquals(VisibilityEnum.HIDDEN_ALL, ((BasicFieldMetadata) metadata).getVisibility());
    assertEquals(MergedPropertyType.PRIMARY, ((BasicFieldMetadata) metadata).getMergedPropertyType());
    assertFalse(((BasicFieldMetadata) metadata).getForeignKeyCollection());
    assertFalse(((BasicFieldMetadata) metadata).getRequired());
    assertFalse(((BasicFieldMetadata) metadata).isLargeEntry());
    assertFalse(((BasicFieldMetadata) metadata).isProminent());
    assertFalse(metadata.getManualFetch());
    assertFalse(property.getIsDirty());
    assertFalse(property.isAdvancedCollection());
    assertTrue(((BasicFieldMetadata) metadata).getValidationConfigurations().isEmpty());
    assertTrue(metadata.getAdditionalMetadata().isEmpty());
    assertTrue(((BasicFieldMetadata) metadata).getAllowNoValueEnumOption());
    assertTrue(((BasicFieldMetadata) metadata).getMutable());
    assertTrue(((BasicFieldMetadata) metadata).getReadOnly());
    assertTrue(property.getEnabled());
    assertArrayEquals(new String[]{"java.lang.Object"}, metadata.getAvailableToTypes());
  }

  /**
   * Test
   * {@link DynamicFieldPersistenceHandlerHelper#buildDynamicPropertyList(Map, Class)}
   * with {@code Map}, {@code Class}.
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DynamicFieldPersistenceHandlerHelper#buildDynamicPropertyList(Map, Class)}
   */
  @Test
  public void testBuildDynamicPropertyListWithMapClass_whenHashMap() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DynamicFieldPersistenceHandlerHelper dynamicFieldPersistenceHandlerHelper = new DynamicFieldPersistenceHandlerHelper();
    HashMap<FieldGroup, Long> fieldGroups = new HashMap<>();
    Class<Object> inheritedType = Object.class;

    // Act
    Property[] actualBuildDynamicPropertyListResult = dynamicFieldPersistenceHandlerHelper
        .buildDynamicPropertyList(fieldGroups, inheritedType);

    // Assert
    Property property = actualBuildDynamicPropertyListResult[0];
    FieldMetadata metadata = property.getMetadata();
    assertTrue(metadata instanceof BasicFieldMetadata);
    assertEquals("", ((BasicFieldMetadata) metadata).getBroadleafEnumeration());
    assertEquals("", metadata.getSecurityLevel());
    assertEquals("*", ((BasicFieldMetadata) metadata).getColumnWidth());
    assertEquals("ID", metadata.getFriendlyName());
    assertEquals("id", ((BasicFieldMetadata) metadata).getName());
    assertEquals("id", property.getName());
    assertEquals("java.lang.Object", metadata.getInheritedFromType());
    assertNull(((BasicFieldMetadata) metadata).getCustomCriteria());
    assertNull(((BasicFieldMetadata) metadata).getEnumerationValues());
    assertNull(((BasicFieldMetadata) metadata).getOptionFilterParams());
    assertNull(((BasicFieldMetadata) metadata).getCanLinkToExternalEntity());
    assertNull(((BasicFieldMetadata) metadata).getEnableTypeaheadLookup());
    assertNull(((BasicFieldMetadata) metadata).getForcePopulateChildProperties());
    assertNull(((BasicFieldMetadata) metadata).getGroupCollapsed());
    assertNull(((BasicFieldMetadata) metadata).getHideEnumerationIfEmpty());
    assertNull(((BasicFieldMetadata) metadata).getIsDerived());
    assertNull(((BasicFieldMetadata) metadata).getIsFilter());
    assertNull(((BasicFieldMetadata) metadata).getOptionCanEditValues());
    assertNull(((BasicFieldMetadata) metadata).getOptionHideIfEmpty());
    assertNull(((BasicFieldMetadata) metadata).getRequiredOverride());
    assertNull(((BasicFieldMetadata) metadata).getSearchable());
    assertNull(((BasicFieldMetadata) metadata).getToOneLookupCreatedViaAnnotation());
    assertNull(((BasicFieldMetadata) metadata).getTranslatable());
    assertNull(((BasicFieldMetadata) metadata).getUnique());
    assertNull(((BasicFieldMetadata) metadata).getUseServerSideInspectionCache());
    assertNull(metadata.getChildrenExcluded());
    assertNull(metadata.getExcluded());
    assertNull(metadata.getLazyFetch());
    assertNull(((BasicFieldMetadata) metadata).getGridOrder());
    assertNull(((BasicFieldMetadata) metadata).getLength());
    assertNull(((BasicFieldMetadata) metadata).getPrecision());
    assertNull(((BasicFieldMetadata) metadata).getScale());
    assertNull(metadata.getGroupOrder());
    assertNull(metadata.getOrder());
    assertNull(metadata.getTabOrder());
    assertNull(((BasicFieldMetadata) metadata).getAssociatedFieldName());
    assertNull(((BasicFieldMetadata) metadata).getDefaultValue());
    assertNull(((BasicFieldMetadata) metadata).getEnumerationClass());
    assertNull(((BasicFieldMetadata) metadata).getFieldComponentRendererTemplate());
    assertNull(((BasicFieldMetadata) metadata).getForeignKeyClass());
    assertNull(((BasicFieldMetadata) metadata).getForeignKeyDisplayValueProperty());
    assertNull(((BasicFieldMetadata) metadata).getForeignKeyProperty());
    assertNull(((BasicFieldMetadata) metadata).getGridFieldComponentRendererTemplate());
    assertNull(((BasicFieldMetadata) metadata).getHelpText());
    assertNull(((BasicFieldMetadata) metadata).getHint());
    assertNull(((BasicFieldMetadata) metadata).getLookupDisplayProperty());
    assertNull(((BasicFieldMetadata) metadata).getManyToField());
    assertNull(((BasicFieldMetadata) metadata).getMapFieldValueClass());
    assertNull(((BasicFieldMetadata) metadata).getMapKeyValueProperty());
    assertNull(((BasicFieldMetadata) metadata).getOptionDisplayFieldName());
    assertNull(((BasicFieldMetadata) metadata).getOptionListEntity());
    assertNull(((BasicFieldMetadata) metadata).getOptionValueFieldName());
    assertNull(((BasicFieldMetadata) metadata).getRuleIdentifier());
    assertNull(((BasicFieldMetadata) metadata).getToOneParentProperty());
    assertNull(((BasicFieldMetadata) metadata).getToOneTargetProperty());
    assertNull(((BasicFieldMetadata) metadata).getTooltip());
    assertNull(metadata.getAddFriendlyName());
    assertNull(metadata.getCurrencyCodeField());
    assertNull(metadata.getFieldName());
    assertNull(metadata.getGroup());
    assertNull(metadata.getOwningClass());
    assertNull(metadata.getOwningClassFriendlyName());
    assertNull(metadata.getPrefix());
    assertNull(metadata.getShowIfProperty());
    assertNull(metadata.getTab());
    assertNull(metadata.getTargetClass());
    assertNull(property.getDisplayValue());
    assertNull(property.getOriginalDisplayValue());
    assertNull(property.getOriginalValue());
    assertNull(property.getRawValue());
    assertNull(property.getUnHtmlEncodedValue());
    assertNull(property.getValue());
    assertNull(property.getDeployDate());
    assertNull(metadata.getShowIfFieldEquals());
    assertNull(((BasicFieldMetadata) metadata).getLookupType());
    assertNull(((BasicFieldMetadata) metadata).getDisplayType());
    assertNull(((BasicFieldMetadata) metadata).getFieldComponentRenderer());
    assertNull(((BasicFieldMetadata) metadata).getGridFieldComponentRenderer());
    assertEquals(1, actualBuildDynamicPropertyListResult.length);
    assertEquals(SupportedFieldType.ID, ((BasicFieldMetadata) metadata).getFieldType());
    assertEquals(SupportedFieldType.INTEGER, ((BasicFieldMetadata) metadata).getSecondaryType());
    assertEquals(SupportedFieldType.UNKNOWN, ((BasicFieldMetadata) metadata).getExplicitFieldType());
    assertEquals(VisibilityEnum.HIDDEN_ALL, ((BasicFieldMetadata) metadata).getVisibility());
    assertEquals(MergedPropertyType.PRIMARY, ((BasicFieldMetadata) metadata).getMergedPropertyType());
    assertFalse(((BasicFieldMetadata) metadata).getForeignKeyCollection());
    assertFalse(((BasicFieldMetadata) metadata).getRequired());
    assertFalse(((BasicFieldMetadata) metadata).isLargeEntry());
    assertFalse(((BasicFieldMetadata) metadata).isProminent());
    assertFalse(metadata.getManualFetch());
    assertFalse(property.getIsDirty());
    assertFalse(property.isAdvancedCollection());
    assertTrue(((BasicFieldMetadata) metadata).getValidationConfigurations().isEmpty());
    assertTrue(metadata.getAdditionalMetadata().isEmpty());
    assertTrue(((BasicFieldMetadata) metadata).getAllowNoValueEnumOption());
    assertTrue(((BasicFieldMetadata) metadata).getMutable());
    assertTrue(((BasicFieldMetadata) metadata).getReadOnly());
    assertTrue(property.getEnabled());
    assertArrayEquals(new String[]{"java.lang.Object"}, metadata.getAvailableToTypes());
  }
}
