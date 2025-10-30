/*-
 * #%L
 * BroadleafCommerce CMS Module
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
package org.broadleafcommerce.cms.admin.server.handler;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.broadleafcommerce.cms.field.domain.FieldDefinition;
import org.broadleafcommerce.cms.field.domain.FieldDefinitionImpl;
import org.broadleafcommerce.cms.field.domain.FieldGroup;
import org.broadleafcommerce.cms.field.domain.FieldGroupImpl;
import org.broadleafcommerce.common.enumeration.domain.DataDrivenEnumerationImpl;
import org.broadleafcommerce.common.presentation.client.SupportedFieldType;
import org.broadleafcommerce.openadmin.dto.BasicFieldMetadata;
import org.broadleafcommerce.openadmin.dto.FieldMetadata;
import org.broadleafcommerce.openadmin.dto.Property;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {DynamicFieldPersistenceHandlerHelper.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class DynamicFieldPersistenceHandlerHelperDiffblueTest {
  @Autowired
  private DynamicFieldPersistenceHandlerHelper dynamicFieldPersistenceHandlerHelper;

  /**
   * Test {@link DynamicFieldPersistenceHandlerHelper#buildDynamicProperty(FieldDefinition, Class)}.
   * <p>
   * Method under test: {@link DynamicFieldPersistenceHandlerHelper#buildDynamicProperty(FieldDefinition, Class)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Property DynamicFieldPersistenceHandlerHelper.buildDynamicProperty(FieldDefinition, Class)"})
  public void testBuildDynamicProperty() {
    // Arrange
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
   * Test {@link DynamicFieldPersistenceHandlerHelper#buildDynamicProperty(FieldDefinition, Class)}.
   * <ul>
   *   <li>Given {@code UNKNOWN}.</li>
   *   <li>Then return Metadata ForeignKeyClass is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DynamicFieldPersistenceHandlerHelper#buildDynamicProperty(FieldDefinition, Class)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Property DynamicFieldPersistenceHandlerHelper.buildDynamicProperty(FieldDefinition, Class)"})
  public void testBuildDynamicProperty_givenUnknown_thenReturnMetadataForeignKeyClassIsNull() {
    // Arrange
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
   * Test {@link DynamicFieldPersistenceHandlerHelper#buildDynamicPropertyList(List, Class)} with {@code List}, {@code Class}.
   * <ul>
   *   <li>Given {@link FieldGroupImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link DynamicFieldPersistenceHandlerHelper#buildDynamicPropertyList(List, Class)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Property[] DynamicFieldPersistenceHandlerHelper.buildDynamicPropertyList(List, Class)"})
  public void testBuildDynamicPropertyListWithListClass_givenFieldGroupImpl() {
    // Arrange
    ArrayList<FieldGroup> fieldGroups = new ArrayList<>();
    fieldGroups.add(new FieldGroupImpl());
    Class<Object> inheritedType = Object.class;

    // Act
    Property[] actualBuildDynamicPropertyListResult = dynamicFieldPersistenceHandlerHelper
        .buildDynamicPropertyList(fieldGroups, inheritedType);

    // Assert
    Property property = actualBuildDynamicPropertyListResult[0];
    assertTrue(property.getMetadata() instanceof BasicFieldMetadata);
    assertEquals("id", property.getName());
    assertNull(property.getDisplayValue());
    assertNull(property.getOriginalDisplayValue());
    assertNull(property.getOriginalValue());
    assertNull(property.getRawValue());
    assertNull(property.getUnHtmlEncodedValue());
    assertNull(property.getValue());
    assertNull(property.getDeployDate());
    assertEquals(1, actualBuildDynamicPropertyListResult.length);
    assertFalse(property.getIsDirty());
    assertFalse(property.isAdvancedCollection());
    assertTrue(property.getEnabled());
  }

  /**
   * Test {@link DynamicFieldPersistenceHandlerHelper#buildDynamicPropertyList(List, Class)} with {@code List}, {@code Class}.
   * <ul>
   *   <li>Given {@link FieldGroupImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link DynamicFieldPersistenceHandlerHelper#buildDynamicPropertyList(List, Class)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Property[] DynamicFieldPersistenceHandlerHelper.buildDynamicPropertyList(List, Class)"})
  public void testBuildDynamicPropertyListWithListClass_givenFieldGroupImpl2() {
    // Arrange
    ArrayList<FieldGroup> fieldGroups = new ArrayList<>();
    fieldGroups.add(new FieldGroupImpl());
    fieldGroups.add(new FieldGroupImpl());
    Class<Object> inheritedType = Object.class;

    // Act
    Property[] actualBuildDynamicPropertyListResult = dynamicFieldPersistenceHandlerHelper
        .buildDynamicPropertyList(fieldGroups, inheritedType);

    // Assert
    Property property = actualBuildDynamicPropertyListResult[0];
    assertTrue(property.getMetadata() instanceof BasicFieldMetadata);
    assertEquals("id", property.getName());
    assertNull(property.getDisplayValue());
    assertNull(property.getOriginalDisplayValue());
    assertNull(property.getOriginalValue());
    assertNull(property.getRawValue());
    assertNull(property.getUnHtmlEncodedValue());
    assertNull(property.getValue());
    assertNull(property.getDeployDate());
    assertEquals(1, actualBuildDynamicPropertyListResult.length);
    assertFalse(property.getIsDirty());
    assertFalse(property.isAdvancedCollection());
    assertTrue(property.getEnabled());
  }

  /**
   * Test {@link DynamicFieldPersistenceHandlerHelper#buildDynamicPropertyList(List, Class)} with {@code List}, {@code Class}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DynamicFieldPersistenceHandlerHelper#buildDynamicPropertyList(List, Class)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Property[] DynamicFieldPersistenceHandlerHelper.buildDynamicPropertyList(List, Class)"})
  public void testBuildDynamicPropertyListWithListClass_whenArrayList() {
    // Arrange
    ArrayList<FieldGroup> fieldGroups = new ArrayList<>();
    Class<Object> inheritedType = Object.class;

    // Act
    Property[] actualBuildDynamicPropertyListResult = dynamicFieldPersistenceHandlerHelper
        .buildDynamicPropertyList(fieldGroups, inheritedType);

    // Assert
    Property property = actualBuildDynamicPropertyListResult[0];
    assertTrue(property.getMetadata() instanceof BasicFieldMetadata);
    assertEquals("id", property.getName());
    assertNull(property.getDisplayValue());
    assertNull(property.getOriginalDisplayValue());
    assertNull(property.getOriginalValue());
    assertNull(property.getRawValue());
    assertNull(property.getUnHtmlEncodedValue());
    assertNull(property.getValue());
    assertNull(property.getDeployDate());
    assertEquals(1, actualBuildDynamicPropertyListResult.length);
    assertFalse(property.getIsDirty());
    assertFalse(property.isAdvancedCollection());
    assertTrue(property.getEnabled());
  }

  /**
   * Test {@link DynamicFieldPersistenceHandlerHelper#buildDynamicPropertyList(Map, Class)} with {@code Map}, {@code Class}.
   * <p>
   * Method under test: {@link DynamicFieldPersistenceHandlerHelper#buildDynamicPropertyList(Map, Class)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Property[] DynamicFieldPersistenceHandlerHelper.buildDynamicPropertyList(Map, Class)"})
  public void testBuildDynamicPropertyListWithMapClass() {
    // Arrange
    HashMap<FieldGroup, Long> fieldGroups = new HashMap<>();
    Class<Object> inheritedType = Object.class;

    // Act
    Property[] actualBuildDynamicPropertyListResult = dynamicFieldPersistenceHandlerHelper
        .buildDynamicPropertyList(fieldGroups, inheritedType);

    // Assert
    Property property = actualBuildDynamicPropertyListResult[0];
    assertTrue(property.getMetadata() instanceof BasicFieldMetadata);
    assertEquals("id", property.getName());
    assertNull(property.getDisplayValue());
    assertNull(property.getOriginalDisplayValue());
    assertNull(property.getOriginalValue());
    assertNull(property.getRawValue());
    assertNull(property.getUnHtmlEncodedValue());
    assertNull(property.getValue());
    assertNull(property.getDeployDate());
    assertEquals(1, actualBuildDynamicPropertyListResult.length);
    assertFalse(property.getIsDirty());
    assertFalse(property.isAdvancedCollection());
    assertTrue(property.getEnabled());
  }

  /**
   * Test {@link DynamicFieldPersistenceHandlerHelper#buildDynamicPropertyList(Map, Class)} with {@code Map}, {@code Class}.
   * <ul>
   *   <li>Given {@link FieldGroupImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link DynamicFieldPersistenceHandlerHelper#buildDynamicPropertyList(Map, Class)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Property[] DynamicFieldPersistenceHandlerHelper.buildDynamicPropertyList(Map, Class)"})
  public void testBuildDynamicPropertyListWithMapClass_givenFieldGroupImpl() {
    // Arrange
    HashMap<FieldGroup, Long> fieldGroups = new HashMap<>();
    fieldGroups.put(new FieldGroupImpl(), 5L);
    Class<Object> inheritedType = Object.class;

    // Act
    Property[] actualBuildDynamicPropertyListResult = dynamicFieldPersistenceHandlerHelper
        .buildDynamicPropertyList(fieldGroups, inheritedType);

    // Assert
    Property property = actualBuildDynamicPropertyListResult[0];
    assertTrue(property.getMetadata() instanceof BasicFieldMetadata);
    assertEquals("id", property.getName());
    assertNull(property.getDisplayValue());
    assertNull(property.getOriginalDisplayValue());
    assertNull(property.getOriginalValue());
    assertNull(property.getRawValue());
    assertNull(property.getUnHtmlEncodedValue());
    assertNull(property.getValue());
    assertNull(property.getDeployDate());
    assertEquals(1, actualBuildDynamicPropertyListResult.length);
    assertFalse(property.getIsDirty());
    assertFalse(property.isAdvancedCollection());
    assertTrue(property.getEnabled());
  }
}
