package org.broadleafcommerce.cms.admin.server.handler;

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
import org.broadleafcommerce.common.presentation.client.VisibilityEnum;
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
  @Autowired private DynamicFieldPersistenceHandlerHelper dynamicFieldPersistenceHandlerHelper;

  /**
   * Test {@link DynamicFieldPersistenceHandlerHelper#buildDynamicProperty(FieldDefinition, Class)}.
   *
   * <p>Method under test: {@link
   * DynamicFieldPersistenceHandlerHelper#buildDynamicProperty(FieldDefinition, Class)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Property DynamicFieldPersistenceHandlerHelper.buildDynamicProperty(FieldDefinition, Class)"
  })
  public void testBuildDynamicProperty() {
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
    when(definition.getDataDrivenEnumeration()).thenReturn(null);
    when(definition.getFieldType()).thenReturn(SupportedFieldType.UNKNOWN);
    Class<Object> inheritedType = Object.class;

    // Act
    Property actualBuildDynamicPropertyResult =
        dynamicFieldPersistenceHandlerHelper.buildDynamicProperty(definition, inheritedType);

    // Assert
    verify(definition).getColumnWidth();
    verify(definition).getDataDrivenEnumeration();
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
    Map<String, List<Map<String, String>>> validationConfigurations =
        ((BasicFieldMetadata) metadata).getValidationConfigurations();
    assertEquals(1, validationConfigurations.size());
    List<Map<String, String>> getResult = validationConfigurations.get("blRegexPropertyValidator");
    assertEquals(1, getResult.size());
    Map<String, String> getResult2 = getResult.get(0);
    assertEquals(2, getResult2.size());
    assertEquals(".*", getResult2.get("regularExpression"));
    assertEquals("An error occurred", getResult2.get("errorMessage"));
    assertEquals("Security Level", metadata.getSecurityLevel());
    assertEquals(VisibilityEnum.HIDDEN_ALL, ((BasicFieldMetadata) metadata).getVisibility());
  }

  /**
   * Test {@link DynamicFieldPersistenceHandlerHelper#buildDynamicProperty(FieldDefinition, Class)}.
   *
   * <ul>
   *   <li>Given {@code false}.
   *   <li>Then return Metadata Visibility is {@code VISIBLE_ALL}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DynamicFieldPersistenceHandlerHelper#buildDynamicProperty(FieldDefinition, Class)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Property DynamicFieldPersistenceHandlerHelper.buildDynamicProperty(FieldDefinition, Class)"
  })
  public void testBuildDynamicProperty_givenFalse_thenReturnMetadataVisibilityIsVisibleAll() {
    // Arrange
    FieldDefinitionImpl definition = mock(FieldDefinitionImpl.class);
    when(definition.getValidationErrorMesageKey()).thenReturn("An error occurred");
    when(definition.getFieldOrder()).thenReturn(1);
    when(definition.getHiddenFlag()).thenReturn(false);
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
    Property actualBuildDynamicPropertyResult =
        dynamicFieldPersistenceHandlerHelper.buildDynamicProperty(definition, inheritedType);

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
    Map<String, List<Map<String, String>>> validationConfigurations =
        ((BasicFieldMetadata) metadata).getValidationConfigurations();
    assertEquals(1, validationConfigurations.size());
    List<Map<String, String>> getResult = validationConfigurations.get("blRegexPropertyValidator");
    assertEquals(1, getResult.size());
    Map<String, String> getResult2 = getResult.get(0);
    assertEquals(2, getResult2.size());
    assertEquals(".*", getResult2.get("regularExpression"));
    assertEquals("An error occurred", getResult2.get("errorMessage"));
    assertEquals("Security Level", metadata.getSecurityLevel());
    assertEquals(VisibilityEnum.VISIBLE_ALL, ((BasicFieldMetadata) metadata).getVisibility());
  }

  /**
   * Test {@link DynamicFieldPersistenceHandlerHelper#buildDynamicProperty(FieldDefinition, Class)}.
   *
   * <ul>
   *   <li>Then return Metadata SecurityLevel is empty string.
   * </ul>
   *
   * <p>Method under test: {@link
   * DynamicFieldPersistenceHandlerHelper#buildDynamicProperty(FieldDefinition, Class)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Property DynamicFieldPersistenceHandlerHelper.buildDynamicProperty(FieldDefinition, Class)"
  })
  public void testBuildDynamicProperty_thenReturnMetadataSecurityLevelIsEmptyString() {
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
    when(definition.getSecurityLevel()).thenReturn(null);
    when(definition.getTooltip()).thenReturn("127.0.0.1");
    when(definition.getValidationRegEx()).thenReturn(".*");
    when(definition.getDataDrivenEnumeration()).thenReturn(new DataDrivenEnumerationImpl());
    when(definition.getFieldType()).thenReturn(SupportedFieldType.UNKNOWN);
    Class<Object> inheritedType = Object.class;

    // Act
    Property actualBuildDynamicPropertyResult =
        dynamicFieldPersistenceHandlerHelper.buildDynamicProperty(definition, inheritedType);

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
    verify(definition).getSecurityLevel();
    verify(definition).getTextAreaFlag();
    verify(definition).getTooltip();
    verify(definition).getValidationErrorMesageKey();
    verify(definition, atLeast(1)).getValidationRegEx();
    FieldMetadata metadata = actualBuildDynamicPropertyResult.getMetadata();
    assertTrue(metadata instanceof BasicFieldMetadata);
    assertEquals("", metadata.getSecurityLevel());
    Map<String, List<Map<String, String>>> validationConfigurations =
        ((BasicFieldMetadata) metadata).getValidationConfigurations();
    assertEquals(1, validationConfigurations.size());
    List<Map<String, String>> getResult = validationConfigurations.get("blRegexPropertyValidator");
    assertEquals(1, getResult.size());
    Map<String, String> getResult2 = getResult.get(0);
    assertEquals(2, getResult2.size());
    assertEquals(".*", getResult2.get("regularExpression"));
    assertEquals("An error occurred", getResult2.get("errorMessage"));
    assertEquals(VisibilityEnum.HIDDEN_ALL, ((BasicFieldMetadata) metadata).getVisibility());
  }

  /**
   * Test {@link DynamicFieldPersistenceHandlerHelper#buildDynamicProperty(FieldDefinition, Class)}.
   *
   * <ul>
   *   <li>Then return Metadata SecurityLevel is {@code Security Level}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DynamicFieldPersistenceHandlerHelper#buildDynamicProperty(FieldDefinition, Class)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Property DynamicFieldPersistenceHandlerHelper.buildDynamicProperty(FieldDefinition, Class)"
  })
  public void testBuildDynamicProperty_thenReturnMetadataSecurityLevelIsSecurityLevel() {
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
    Property actualBuildDynamicPropertyResult =
        dynamicFieldPersistenceHandlerHelper.buildDynamicProperty(definition, inheritedType);

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
    Map<String, List<Map<String, String>>> validationConfigurations =
        ((BasicFieldMetadata) metadata).getValidationConfigurations();
    assertEquals(1, validationConfigurations.size());
    List<Map<String, String>> getResult = validationConfigurations.get("blRegexPropertyValidator");
    assertEquals(1, getResult.size());
    Map<String, String> getResult2 = getResult.get(0);
    assertEquals(2, getResult2.size());
    assertEquals(".*", getResult2.get("regularExpression"));
    assertEquals("An error occurred", getResult2.get("errorMessage"));
    assertEquals("Security Level", metadata.getSecurityLevel());
    assertEquals(VisibilityEnum.HIDDEN_ALL, ((BasicFieldMetadata) metadata).getVisibility());
  }

  /**
   * Test {@link DynamicFieldPersistenceHandlerHelper#buildDynamicProperty(FieldDefinition, Class)}.
   *
   * <ul>
   *   <li>Then return {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DynamicFieldPersistenceHandlerHelper#buildDynamicProperty(FieldDefinition, Class)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Property DynamicFieldPersistenceHandlerHelper.buildDynamicProperty(FieldDefinition, Class)"
  })
  public void testBuildDynamicProperty_thenReturnName() {
    // Arrange
    FieldDefinitionImpl definition = mock(FieldDefinitionImpl.class);
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
    when(definition.getValidationRegEx()).thenReturn(null);
    when(definition.getDataDrivenEnumeration()).thenReturn(new DataDrivenEnumerationImpl());
    when(definition.getFieldType()).thenReturn(SupportedFieldType.UNKNOWN);
    Class<Object> inheritedType = Object.class;

    // Act
    Property actualBuildDynamicPropertyResult =
        dynamicFieldPersistenceHandlerHelper.buildDynamicProperty(definition, inheritedType);

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
    verify(definition).getValidationRegEx();
    assertEquals("Name", actualBuildDynamicPropertyResult.getName());
    assertNull(actualBuildDynamicPropertyResult.getDisplayValue());
    assertNull(actualBuildDynamicPropertyResult.getOriginalDisplayValue());
    assertNull(actualBuildDynamicPropertyResult.getOriginalValue());
    assertNull(actualBuildDynamicPropertyResult.getRawValue());
    assertNull(actualBuildDynamicPropertyResult.getUnHtmlEncodedValue());
    assertNull(actualBuildDynamicPropertyResult.getValue());
    assertNull(actualBuildDynamicPropertyResult.getDeployDate());
    assertFalse(actualBuildDynamicPropertyResult.getIsDirty());
    assertFalse(actualBuildDynamicPropertyResult.isAdvancedCollection());
    assertTrue(actualBuildDynamicPropertyResult.getEnabled());
  }

  /**
   * Test {@link DynamicFieldPersistenceHandlerHelper#buildDynamicPropertyList(List, Class)} with
   * {@code List}, {@code Class}.
   *
   * <p>Method under test: {@link
   * DynamicFieldPersistenceHandlerHelper#buildDynamicPropertyList(List, Class)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Property[] DynamicFieldPersistenceHandlerHelper.buildDynamicPropertyList(List, Class)"
  })
  public void testBuildDynamicPropertyListWithListClass() {
    // Arrange
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
    when(fieldDefinitionImpl.getDataDrivenEnumeration())
        .thenReturn(new DataDrivenEnumerationImpl());
    when(fieldDefinitionImpl.getFieldType()).thenReturn(SupportedFieldType.UNKNOWN);

    ArrayList<FieldDefinition> fieldDefinitions = new ArrayList<>();
    fieldDefinitions.add(fieldDefinitionImpl);

    FieldGroupImpl fieldGroupImpl = new FieldGroupImpl();
    fieldGroupImpl.setFieldDefinitions(fieldDefinitions);

    ArrayList<FieldGroup> fieldGroups = new ArrayList<>();
    fieldGroups.add(fieldGroupImpl);
    Class<Object> inheritedType = Object.class;

    // Act
    Property[] actualBuildDynamicPropertyListResult =
        dynamicFieldPersistenceHandlerHelper.buildDynamicPropertyList(fieldGroups, inheritedType);

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
    Property property = actualBuildDynamicPropertyListResult[1];
    assertTrue(property.getMetadata() instanceof BasicFieldMetadata);
    assertEquals("Name", actualBuildDynamicPropertyListResult[0].getName());
    assertEquals("id", property.getName());
    assertNull(property.getDisplayValue());
    assertNull(property.getOriginalDisplayValue());
    assertNull(property.getOriginalValue());
    assertNull(property.getRawValue());
    assertNull(property.getUnHtmlEncodedValue());
    assertNull(property.getValue());
    assertNull(property.getDeployDate());
    assertEquals(2, actualBuildDynamicPropertyListResult.length);
    assertFalse(property.getIsDirty());
    assertFalse(property.isAdvancedCollection());
    assertTrue(property.getEnabled());
  }

  /**
   * Test {@link DynamicFieldPersistenceHandlerHelper#buildDynamicPropertyList(List, Class)} with
   * {@code List}, {@code Class}.
   *
   * <p>Method under test: {@link
   * DynamicFieldPersistenceHandlerHelper#buildDynamicPropertyList(List, Class)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Property[] DynamicFieldPersistenceHandlerHelper.buildDynamicPropertyList(List, Class)"
  })
  public void testBuildDynamicPropertyListWithListClass2() {
    // Arrange
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
    when(fieldDefinitionImpl.getDataDrivenEnumeration()).thenReturn(null);
    when(fieldDefinitionImpl.getFieldType()).thenReturn(SupportedFieldType.UNKNOWN);

    ArrayList<FieldDefinition> fieldDefinitions = new ArrayList<>();
    fieldDefinitions.add(fieldDefinitionImpl);

    FieldGroupImpl fieldGroupImpl = new FieldGroupImpl();
    fieldGroupImpl.setFieldDefinitions(fieldDefinitions);

    ArrayList<FieldGroup> fieldGroups = new ArrayList<>();
    fieldGroups.add(fieldGroupImpl);
    Class<Object> inheritedType = Object.class;

    // Act
    Property[] actualBuildDynamicPropertyListResult =
        dynamicFieldPersistenceHandlerHelper.buildDynamicPropertyList(fieldGroups, inheritedType);

    // Assert
    verify(fieldDefinitionImpl).getColumnWidth();
    verify(fieldDefinitionImpl).getDataDrivenEnumeration();
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
    Property property = actualBuildDynamicPropertyListResult[1];
    assertTrue(property.getMetadata() instanceof BasicFieldMetadata);
    assertEquals("Name", actualBuildDynamicPropertyListResult[0].getName());
    assertEquals("id", property.getName());
    assertNull(property.getDisplayValue());
    assertNull(property.getOriginalDisplayValue());
    assertNull(property.getOriginalValue());
    assertNull(property.getRawValue());
    assertNull(property.getUnHtmlEncodedValue());
    assertNull(property.getValue());
    assertNull(property.getDeployDate());
    assertEquals(2, actualBuildDynamicPropertyListResult.length);
    assertFalse(property.getIsDirty());
    assertFalse(property.isAdvancedCollection());
    assertTrue(property.getEnabled());
  }

  /**
   * Test {@link DynamicFieldPersistenceHandlerHelper#buildDynamicPropertyList(List, Class)} with
   * {@code List}, {@code Class}.
   *
   * <p>Method under test: {@link
   * DynamicFieldPersistenceHandlerHelper#buildDynamicPropertyList(List, Class)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Property[] DynamicFieldPersistenceHandlerHelper.buildDynamicPropertyList(List, Class)"
  })
  public void testBuildDynamicPropertyListWithListClass3() {
    // Arrange
    FieldDefinitionImpl fieldDefinitionImpl = mock(FieldDefinitionImpl.class);
    when(fieldDefinitionImpl.getValidationErrorMesageKey()).thenReturn("An error occurred");
    when(fieldDefinitionImpl.getFieldOrder()).thenReturn(1);
    when(fieldDefinitionImpl.getHiddenFlag()).thenReturn(false);
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
    when(fieldDefinitionImpl.getDataDrivenEnumeration())
        .thenReturn(new DataDrivenEnumerationImpl());
    when(fieldDefinitionImpl.getFieldType()).thenReturn(SupportedFieldType.UNKNOWN);

    ArrayList<FieldDefinition> fieldDefinitions = new ArrayList<>();
    fieldDefinitions.add(fieldDefinitionImpl);

    FieldGroupImpl fieldGroupImpl = new FieldGroupImpl();
    fieldGroupImpl.setFieldDefinitions(fieldDefinitions);

    ArrayList<FieldGroup> fieldGroups = new ArrayList<>();
    fieldGroups.add(fieldGroupImpl);
    Class<Object> inheritedType = Object.class;

    // Act
    Property[] actualBuildDynamicPropertyListResult =
        dynamicFieldPersistenceHandlerHelper.buildDynamicPropertyList(fieldGroups, inheritedType);

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
    Property property = actualBuildDynamicPropertyListResult[1];
    assertTrue(property.getMetadata() instanceof BasicFieldMetadata);
    assertEquals("Name", actualBuildDynamicPropertyListResult[0].getName());
    assertEquals("id", property.getName());
    assertNull(property.getDisplayValue());
    assertNull(property.getOriginalDisplayValue());
    assertNull(property.getOriginalValue());
    assertNull(property.getRawValue());
    assertNull(property.getUnHtmlEncodedValue());
    assertNull(property.getValue());
    assertNull(property.getDeployDate());
    assertEquals(2, actualBuildDynamicPropertyListResult.length);
    assertFalse(property.getIsDirty());
    assertFalse(property.isAdvancedCollection());
    assertTrue(property.getEnabled());
  }

  /**
   * Test {@link DynamicFieldPersistenceHandlerHelper#buildDynamicPropertyList(List, Class)} with
   * {@code List}, {@code Class}.
   *
   * <ul>
   *   <li>Given {@link FieldGroupImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link
   * DynamicFieldPersistenceHandlerHelper#buildDynamicPropertyList(List, Class)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Property[] DynamicFieldPersistenceHandlerHelper.buildDynamicPropertyList(List, Class)"
  })
  public void testBuildDynamicPropertyListWithListClass_givenFieldGroupImpl() {
    // Arrange
    ArrayList<FieldGroup> fieldGroups = new ArrayList<>();
    fieldGroups.add(new FieldGroupImpl());
    Class<Object> inheritedType = Object.class;

    // Act
    Property[] actualBuildDynamicPropertyListResult =
        dynamicFieldPersistenceHandlerHelper.buildDynamicPropertyList(fieldGroups, inheritedType);

    // Assert
    Property property = actualBuildDynamicPropertyListResult[0];
    assertTrue(property.getMetadata() instanceof BasicFieldMetadata);
    assertEquals("id", property.getName());
    assertEquals(1, actualBuildDynamicPropertyListResult.length);
  }

  /**
   * Test {@link DynamicFieldPersistenceHandlerHelper#buildDynamicPropertyList(List, Class)} with
   * {@code List}, {@code Class}.
   *
   * <ul>
   *   <li>Given {@link FieldGroupImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link
   * DynamicFieldPersistenceHandlerHelper#buildDynamicPropertyList(List, Class)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Property[] DynamicFieldPersistenceHandlerHelper.buildDynamicPropertyList(List, Class)"
  })
  public void testBuildDynamicPropertyListWithListClass_givenFieldGroupImpl2() {
    // Arrange
    ArrayList<FieldGroup> fieldGroups = new ArrayList<>();
    fieldGroups.add(new FieldGroupImpl());
    fieldGroups.add(new FieldGroupImpl());
    Class<Object> inheritedType = Object.class;

    // Act
    Property[] actualBuildDynamicPropertyListResult =
        dynamicFieldPersistenceHandlerHelper.buildDynamicPropertyList(fieldGroups, inheritedType);

    // Assert
    Property property = actualBuildDynamicPropertyListResult[0];
    assertTrue(property.getMetadata() instanceof BasicFieldMetadata);
    assertEquals("id", property.getName());
    assertEquals(1, actualBuildDynamicPropertyListResult.length);
  }

  /**
   * Test {@link DynamicFieldPersistenceHandlerHelper#buildDynamicPropertyList(List, Class)} with
   * {@code List}, {@code Class}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DynamicFieldPersistenceHandlerHelper#buildDynamicPropertyList(List, Class)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Property[] DynamicFieldPersistenceHandlerHelper.buildDynamicPropertyList(List, Class)"
  })
  public void testBuildDynamicPropertyListWithListClass_whenArrayList() {
    // Arrange
    ArrayList<FieldGroup> fieldGroups = new ArrayList<>();
    Class<Object> inheritedType = Object.class;

    // Act
    Property[] actualBuildDynamicPropertyListResult =
        dynamicFieldPersistenceHandlerHelper.buildDynamicPropertyList(fieldGroups, inheritedType);

    // Assert
    Property property = actualBuildDynamicPropertyListResult[0];
    assertTrue(property.getMetadata() instanceof BasicFieldMetadata);
    assertEquals("id", property.getName());
    assertEquals(1, actualBuildDynamicPropertyListResult.length);
  }

  /**
   * Test {@link DynamicFieldPersistenceHandlerHelper#buildDynamicPropertyList(Map, Class)} with
   * {@code Map}, {@code Class}.
   *
   * <p>Method under test: {@link DynamicFieldPersistenceHandlerHelper#buildDynamicPropertyList(Map,
   * Class)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Property[] DynamicFieldPersistenceHandlerHelper.buildDynamicPropertyList(Map, Class)"
  })
  public void testBuildDynamicPropertyListWithMapClass() {
    // Arrange
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
    when(fieldDefinitionImpl.getDataDrivenEnumeration())
        .thenReturn(new DataDrivenEnumerationImpl());
    when(fieldDefinitionImpl.getFieldType()).thenReturn(SupportedFieldType.UNKNOWN);

    ArrayList<FieldDefinition> fieldDefinitionList = new ArrayList<>();
    fieldDefinitionList.add(fieldDefinitionImpl);

    FieldGroup fieldGroup = mock(FieldGroup.class);
    when(fieldGroup.getInitCollapsedFlag()).thenReturn(true);
    when(fieldGroup.getName()).thenReturn("Name");
    when(fieldGroup.getFieldDefinitions()).thenReturn(fieldDefinitionList);

    HashMap<FieldGroup, Long> fieldGroups = new HashMap<>();
    fieldGroups.put(fieldGroup, 5L);
    Class<Object> inheritedType = Object.class;

    // Act
    Property[] actualBuildDynamicPropertyListResult =
        dynamicFieldPersistenceHandlerHelper.buildDynamicPropertyList(fieldGroups, inheritedType);

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
    verify(fieldGroup).getFieldDefinitions();
    verify(fieldGroup).getInitCollapsedFlag();
    verify(fieldGroup).getName();
    FieldMetadata metadata = actualBuildDynamicPropertyListResult[0].getMetadata();
    assertTrue(metadata instanceof BasicFieldMetadata);
    Map<String, List<Map<String, String>>> validationConfigurations =
        ((BasicFieldMetadata) metadata).getValidationConfigurations();
    assertEquals(1, validationConfigurations.size());
    List<Map<String, String>> getResult = validationConfigurations.get("blRegexPropertyValidator");
    assertEquals(1, getResult.size());
    Map<String, String> getResult2 = getResult.get(0);
    assertEquals(2, getResult2.size());
    assertEquals(".*", getResult2.get("regularExpression"));
    assertEquals("An error occurred", getResult2.get("errorMessage"));
    assertEquals("Security Level", metadata.getSecurityLevel());
    assertEquals(2, actualBuildDynamicPropertyListResult.length);
  }

  /**
   * Test {@link DynamicFieldPersistenceHandlerHelper#buildDynamicPropertyList(Map, Class)} with
   * {@code Map}, {@code Class}.
   *
   * <p>Method under test: {@link DynamicFieldPersistenceHandlerHelper#buildDynamicPropertyList(Map,
   * Class)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Property[] DynamicFieldPersistenceHandlerHelper.buildDynamicPropertyList(Map, Class)"
  })
  public void testBuildDynamicPropertyListWithMapClass2() {
    // Arrange
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
    when(fieldDefinitionImpl.getDataDrivenEnumeration()).thenReturn(null);
    when(fieldDefinitionImpl.getFieldType()).thenReturn(SupportedFieldType.UNKNOWN);

    ArrayList<FieldDefinition> fieldDefinitionList = new ArrayList<>();
    fieldDefinitionList.add(fieldDefinitionImpl);

    FieldGroup fieldGroup = mock(FieldGroup.class);
    when(fieldGroup.getInitCollapsedFlag()).thenReturn(true);
    when(fieldGroup.getName()).thenReturn("Name");
    when(fieldGroup.getFieldDefinitions()).thenReturn(fieldDefinitionList);

    HashMap<FieldGroup, Long> fieldGroups = new HashMap<>();
    fieldGroups.put(fieldGroup, 5L);
    Class<Object> inheritedType = Object.class;

    // Act
    Property[] actualBuildDynamicPropertyListResult =
        dynamicFieldPersistenceHandlerHelper.buildDynamicPropertyList(fieldGroups, inheritedType);

    // Assert
    verify(fieldDefinitionImpl).getColumnWidth();
    verify(fieldDefinitionImpl).getDataDrivenEnumeration();
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
    verify(fieldGroup).getFieldDefinitions();
    verify(fieldGroup).getInitCollapsedFlag();
    verify(fieldGroup).getName();
    FieldMetadata metadata = actualBuildDynamicPropertyListResult[0].getMetadata();
    assertTrue(metadata instanceof BasicFieldMetadata);
    Map<String, List<Map<String, String>>> validationConfigurations =
        ((BasicFieldMetadata) metadata).getValidationConfigurations();
    assertEquals(1, validationConfigurations.size());
    List<Map<String, String>> getResult = validationConfigurations.get("blRegexPropertyValidator");
    assertEquals(1, getResult.size());
    Map<String, String> getResult2 = getResult.get(0);
    assertEquals(2, getResult2.size());
    assertEquals(".*", getResult2.get("regularExpression"));
    assertEquals("An error occurred", getResult2.get("errorMessage"));
    assertEquals("Security Level", metadata.getSecurityLevel());
    assertEquals(2, actualBuildDynamicPropertyListResult.length);
  }

  /**
   * Test {@link DynamicFieldPersistenceHandlerHelper#buildDynamicPropertyList(Map, Class)} with
   * {@code Map}, {@code Class}.
   *
   * <p>Method under test: {@link DynamicFieldPersistenceHandlerHelper#buildDynamicPropertyList(Map,
   * Class)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Property[] DynamicFieldPersistenceHandlerHelper.buildDynamicPropertyList(Map, Class)"
  })
  public void testBuildDynamicPropertyListWithMapClass3() {
    // Arrange
    FieldDefinitionImpl fieldDefinitionImpl = mock(FieldDefinitionImpl.class);
    when(fieldDefinitionImpl.getValidationErrorMesageKey()).thenReturn("An error occurred");
    when(fieldDefinitionImpl.getFieldOrder()).thenReturn(1);
    when(fieldDefinitionImpl.getHiddenFlag()).thenReturn(false);
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
    when(fieldDefinitionImpl.getDataDrivenEnumeration())
        .thenReturn(new DataDrivenEnumerationImpl());
    when(fieldDefinitionImpl.getFieldType()).thenReturn(SupportedFieldType.UNKNOWN);

    ArrayList<FieldDefinition> fieldDefinitionList = new ArrayList<>();
    fieldDefinitionList.add(fieldDefinitionImpl);

    FieldGroup fieldGroup = mock(FieldGroup.class);
    when(fieldGroup.getInitCollapsedFlag()).thenReturn(true);
    when(fieldGroup.getName()).thenReturn("Name");
    when(fieldGroup.getFieldDefinitions()).thenReturn(fieldDefinitionList);

    HashMap<FieldGroup, Long> fieldGroups = new HashMap<>();
    fieldGroups.put(fieldGroup, 5L);
    Class<Object> inheritedType = Object.class;

    // Act
    Property[] actualBuildDynamicPropertyListResult =
        dynamicFieldPersistenceHandlerHelper.buildDynamicPropertyList(fieldGroups, inheritedType);

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
    verify(fieldGroup).getFieldDefinitions();
    verify(fieldGroup).getInitCollapsedFlag();
    verify(fieldGroup).getName();
    FieldMetadata metadata = actualBuildDynamicPropertyListResult[0].getMetadata();
    assertTrue(metadata instanceof BasicFieldMetadata);
    Map<String, List<Map<String, String>>> validationConfigurations =
        ((BasicFieldMetadata) metadata).getValidationConfigurations();
    assertEquals(1, validationConfigurations.size());
    List<Map<String, String>> getResult = validationConfigurations.get("blRegexPropertyValidator");
    assertEquals(1, getResult.size());
    Map<String, String> getResult2 = getResult.get(0);
    assertEquals(2, getResult2.size());
    assertEquals(".*", getResult2.get("regularExpression"));
    assertEquals("An error occurred", getResult2.get("errorMessage"));
    assertEquals("Security Level", metadata.getSecurityLevel());
    assertEquals(2, actualBuildDynamicPropertyListResult.length);
    assertEquals(VisibilityEnum.VISIBLE_ALL, ((BasicFieldMetadata) metadata).getVisibility());
  }

  /**
   * Test {@link DynamicFieldPersistenceHandlerHelper#buildDynamicPropertyList(Map, Class)} with
   * {@code Map}, {@code Class}.
   *
   * <p>Method under test: {@link DynamicFieldPersistenceHandlerHelper#buildDynamicPropertyList(Map,
   * Class)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Property[] DynamicFieldPersistenceHandlerHelper.buildDynamicPropertyList(Map, Class)"
  })
  public void testBuildDynamicPropertyListWithMapClass4() {
    // Arrange
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
    when(fieldDefinitionImpl.getSecurityLevel()).thenReturn(null);
    when(fieldDefinitionImpl.getTooltip()).thenReturn("127.0.0.1");
    when(fieldDefinitionImpl.getValidationRegEx()).thenReturn(".*");
    when(fieldDefinitionImpl.getDataDrivenEnumeration())
        .thenReturn(new DataDrivenEnumerationImpl());
    when(fieldDefinitionImpl.getFieldType()).thenReturn(SupportedFieldType.UNKNOWN);

    ArrayList<FieldDefinition> fieldDefinitionList = new ArrayList<>();
    fieldDefinitionList.add(fieldDefinitionImpl);

    FieldGroup fieldGroup = mock(FieldGroup.class);
    when(fieldGroup.getInitCollapsedFlag()).thenReturn(true);
    when(fieldGroup.getName()).thenReturn("Name");
    when(fieldGroup.getFieldDefinitions()).thenReturn(fieldDefinitionList);

    HashMap<FieldGroup, Long> fieldGroups = new HashMap<>();
    fieldGroups.put(fieldGroup, 5L);
    Class<Object> inheritedType = Object.class;

    // Act
    Property[] actualBuildDynamicPropertyListResult =
        dynamicFieldPersistenceHandlerHelper.buildDynamicPropertyList(fieldGroups, inheritedType);

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
    verify(fieldDefinitionImpl).getSecurityLevel();
    verify(fieldDefinitionImpl).getTextAreaFlag();
    verify(fieldDefinitionImpl).getTooltip();
    verify(fieldDefinitionImpl).getValidationErrorMesageKey();
    verify(fieldDefinitionImpl, atLeast(1)).getValidationRegEx();
    verify(fieldGroup).getFieldDefinitions();
    verify(fieldGroup).getInitCollapsedFlag();
    verify(fieldGroup).getName();
    FieldMetadata metadata = actualBuildDynamicPropertyListResult[0].getMetadata();
    assertTrue(metadata instanceof BasicFieldMetadata);
    assertEquals("", metadata.getSecurityLevel());
    Map<String, List<Map<String, String>>> validationConfigurations =
        ((BasicFieldMetadata) metadata).getValidationConfigurations();
    assertEquals(1, validationConfigurations.size());
    List<Map<String, String>> getResult = validationConfigurations.get("blRegexPropertyValidator");
    assertEquals(1, getResult.size());
    Map<String, String> getResult2 = getResult.get(0);
    assertEquals(2, getResult2.size());
    assertEquals(".*", getResult2.get("regularExpression"));
    assertEquals("An error occurred", getResult2.get("errorMessage"));
    assertEquals(2, actualBuildDynamicPropertyListResult.length);
  }

  /**
   * Test {@link DynamicFieldPersistenceHandlerHelper#buildDynamicPropertyList(Map, Class)} with
   * {@code Map}, {@code Class}.
   *
   * <p>Method under test: {@link DynamicFieldPersistenceHandlerHelper#buildDynamicPropertyList(Map,
   * Class)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Property[] DynamicFieldPersistenceHandlerHelper.buildDynamicPropertyList(Map, Class)"
  })
  public void testBuildDynamicPropertyListWithMapClass5() {
    // Arrange
    FieldDefinitionImpl fieldDefinitionImpl = mock(FieldDefinitionImpl.class);
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
    when(fieldDefinitionImpl.getValidationRegEx()).thenReturn(null);
    when(fieldDefinitionImpl.getDataDrivenEnumeration())
        .thenReturn(new DataDrivenEnumerationImpl());
    when(fieldDefinitionImpl.getFieldType()).thenReturn(SupportedFieldType.UNKNOWN);

    ArrayList<FieldDefinition> fieldDefinitionList = new ArrayList<>();
    fieldDefinitionList.add(fieldDefinitionImpl);

    FieldGroup fieldGroup = mock(FieldGroup.class);
    when(fieldGroup.getInitCollapsedFlag()).thenReturn(true);
    when(fieldGroup.getName()).thenReturn("Name");
    when(fieldGroup.getFieldDefinitions()).thenReturn(fieldDefinitionList);

    HashMap<FieldGroup, Long> fieldGroups = new HashMap<>();
    fieldGroups.put(fieldGroup, 5L);
    Class<Object> inheritedType = Object.class;

    // Act
    Property[] actualBuildDynamicPropertyListResult =
        dynamicFieldPersistenceHandlerHelper.buildDynamicPropertyList(fieldGroups, inheritedType);

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
    verify(fieldDefinitionImpl).getValidationRegEx();
    verify(fieldGroup).getFieldDefinitions();
    verify(fieldGroup).getInitCollapsedFlag();
    verify(fieldGroup).getName();
    Property property = actualBuildDynamicPropertyListResult[1];
    assertTrue(property.getMetadata() instanceof BasicFieldMetadata);
    assertEquals("Name", actualBuildDynamicPropertyListResult[0].getName());
    assertEquals("id", property.getName());
    assertNull(property.getDisplayValue());
    assertNull(property.getOriginalDisplayValue());
    assertNull(property.getOriginalValue());
    assertNull(property.getRawValue());
    assertNull(property.getUnHtmlEncodedValue());
    assertNull(property.getValue());
    assertNull(property.getDeployDate());
    assertEquals(2, actualBuildDynamicPropertyListResult.length);
    assertFalse(property.getIsDirty());
    assertFalse(property.isAdvancedCollection());
    assertTrue(property.getEnabled());
  }

  /**
   * Test {@link DynamicFieldPersistenceHandlerHelper#buildDynamicPropertyList(Map, Class)} with
   * {@code Map}, {@code Class}.
   *
   * <ul>
   *   <li>Given {@link FieldGroupImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link DynamicFieldPersistenceHandlerHelper#buildDynamicPropertyList(Map,
   * Class)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Property[] DynamicFieldPersistenceHandlerHelper.buildDynamicPropertyList(Map, Class)"
  })
  public void testBuildDynamicPropertyListWithMapClass_givenFieldGroupImpl() {
    // Arrange
    HashMap<FieldGroup, Long> fieldGroups = new HashMap<>();
    fieldGroups.put(new FieldGroupImpl(), 5L);
    Class<Object> inheritedType = Object.class;

    // Act
    Property[] actualBuildDynamicPropertyListResult =
        dynamicFieldPersistenceHandlerHelper.buildDynamicPropertyList(fieldGroups, inheritedType);

    // Assert
    Property property = actualBuildDynamicPropertyListResult[0];
    assertTrue(property.getMetadata() instanceof BasicFieldMetadata);
    assertEquals("id", property.getName());
    assertEquals(1, actualBuildDynamicPropertyListResult.length);
  }

  /**
   * Test {@link DynamicFieldPersistenceHandlerHelper#buildDynamicPropertyList(Map, Class)} with
   * {@code Map}, {@code Class}.
   *
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.
   * </ul>
   *
   * <p>Method under test: {@link DynamicFieldPersistenceHandlerHelper#buildDynamicPropertyList(Map,
   * Class)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Property[] DynamicFieldPersistenceHandlerHelper.buildDynamicPropertyList(Map, Class)"
  })
  public void testBuildDynamicPropertyListWithMapClass_whenHashMap() {
    // Arrange
    HashMap<FieldGroup, Long> fieldGroups = new HashMap<>();
    Class<Object> inheritedType = Object.class;

    // Act
    Property[] actualBuildDynamicPropertyListResult =
        dynamicFieldPersistenceHandlerHelper.buildDynamicPropertyList(fieldGroups, inheritedType);

    // Assert
    Property property = actualBuildDynamicPropertyListResult[0];
    assertTrue(property.getMetadata() instanceof BasicFieldMetadata);
    assertEquals("id", property.getName());
    assertEquals(1, actualBuildDynamicPropertyListResult.length);
  }
}
