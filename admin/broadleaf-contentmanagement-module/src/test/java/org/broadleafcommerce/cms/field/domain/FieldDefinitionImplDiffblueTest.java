package org.broadleafcommerce.cms.field.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.common.enumeration.domain.DataDrivenEnumeration;
import org.broadleafcommerce.common.enumeration.domain.DataDrivenEnumerationImpl;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class FieldDefinitionImplDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link FieldDefinitionImpl}
   *   <li>{@link FieldDefinitionImpl#setAllowMultiples(Boolean)}
   *   <li>{@link FieldDefinitionImpl#setColumnWidth(String)}
   *   <li>{@link FieldDefinitionImpl#setDataDrivenEnumeration(DataDrivenEnumeration)}
   *   <li>{@link FieldDefinitionImpl#setFieldGroup(FieldGroup)}
   *   <li>{@link FieldDefinitionImpl#setFieldType(String)}
   *   <li>{@link FieldDefinitionImpl#setFriendlyName(String)}
   *   <li>{@link FieldDefinitionImpl#setHelpText(String)}
   *   <li>{@link FieldDefinitionImpl#setHiddenFlag(Boolean)}
   *   <li>{@link FieldDefinitionImpl#setHint(String)}
   *   <li>{@link FieldDefinitionImpl#setId(Long)}
   *   <li>{@link FieldDefinitionImpl#setMaxLength(Integer)}
   *   <li>{@link FieldDefinitionImpl#setName(String)}
   *   <li>{@link FieldDefinitionImpl#setRequiredFlag(Boolean)}
   *   <li>{@link FieldDefinitionImpl#setSecurityLevel(String)}
   *   <li>{@link FieldDefinitionImpl#setTextAreaFlag(Boolean)}
   *   <li>{@link FieldDefinitionImpl#setTooltip(String)}
   *   <li>{@link FieldDefinitionImpl#setValidationErrorMesageKey(String)}
   *   <li>{@link FieldDefinitionImpl#setValidationRegEx(String)}
   *   <li>{@link FieldDefinitionImpl#getAllowMultiples()}
   *   <li>{@link FieldDefinitionImpl#getColumnWidth()}
   *   <li>{@link FieldDefinitionImpl#getDataDrivenEnumeration()}
   *   <li>{@link FieldDefinitionImpl#getFieldGroup()}
   *   <li>{@link FieldDefinitionImpl#getFieldTypeVal()}
   *   <li>{@link FieldDefinitionImpl#getFriendlyName()}
   *   <li>{@link FieldDefinitionImpl#getHelpText()}
   *   <li>{@link FieldDefinitionImpl#getHint()}
   *   <li>{@link FieldDefinitionImpl#getId()}
   *   <li>{@link FieldDefinitionImpl#getMaxLength()}
   *   <li>{@link FieldDefinitionImpl#getRequiredFlag()}
   *   <li>{@link FieldDefinitionImpl#getSecurityLevel()}
   *   <li>{@link FieldDefinitionImpl#getTextAreaFlag()}
   *   <li>{@link FieldDefinitionImpl#getTooltip()}
   *   <li>{@link FieldDefinitionImpl#getValidationErrorMesageKey()}
   *   <li>{@link FieldDefinitionImpl#getValidationRegEx()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void FieldDefinitionImpl.<init>()",
    "Boolean FieldDefinitionImpl.getAllowMultiples()",
    "String FieldDefinitionImpl.getColumnWidth()",
    "DataDrivenEnumeration FieldDefinitionImpl.getDataDrivenEnumeration()",
    "FieldGroup FieldDefinitionImpl.getFieldGroup()",
    "String FieldDefinitionImpl.getFieldTypeVal()",
    "String FieldDefinitionImpl.getFriendlyName()",
    "String FieldDefinitionImpl.getHelpText()",
    "String FieldDefinitionImpl.getHint()",
    "Long FieldDefinitionImpl.getId()",
    "Integer FieldDefinitionImpl.getMaxLength()",
    "Boolean FieldDefinitionImpl.getRequiredFlag()",
    "String FieldDefinitionImpl.getSecurityLevel()",
    "Boolean FieldDefinitionImpl.getTextAreaFlag()",
    "String FieldDefinitionImpl.getTooltip()",
    "String FieldDefinitionImpl.getValidationErrorMesageKey()",
    "String FieldDefinitionImpl.getValidationRegEx()",
    "void FieldDefinitionImpl.setAllowMultiples(Boolean)",
    "void FieldDefinitionImpl.setColumnWidth(String)",
    "void FieldDefinitionImpl.setDataDrivenEnumeration(DataDrivenEnumeration)",
    "void FieldDefinitionImpl.setFieldGroup(FieldGroup)",
    "void FieldDefinitionImpl.setFieldType(String)",
    "void FieldDefinitionImpl.setFriendlyName(String)",
    "void FieldDefinitionImpl.setHelpText(String)",
    "void FieldDefinitionImpl.setHiddenFlag(Boolean)",
    "void FieldDefinitionImpl.setHint(String)",
    "void FieldDefinitionImpl.setId(Long)",
    "void FieldDefinitionImpl.setMaxLength(Integer)",
    "void FieldDefinitionImpl.setName(String)",
    "void FieldDefinitionImpl.setRequiredFlag(Boolean)",
    "void FieldDefinitionImpl.setSecurityLevel(String)",
    "void FieldDefinitionImpl.setTextAreaFlag(Boolean)",
    "void FieldDefinitionImpl.setTooltip(String)",
    "void FieldDefinitionImpl.setValidationErrorMesageKey(String)",
    "void FieldDefinitionImpl.setValidationRegEx(String)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    FieldDefinitionImpl actualFieldDefinitionImpl = new FieldDefinitionImpl();
    actualFieldDefinitionImpl.setAllowMultiples(true);
    actualFieldDefinitionImpl.setColumnWidth("Column Width");
    DataDrivenEnumerationImpl dataDrivenEnumeration = new DataDrivenEnumerationImpl();
    actualFieldDefinitionImpl.setDataDrivenEnumeration(dataDrivenEnumeration);
    FieldGroupImpl fieldGroup = new FieldGroupImpl();
    actualFieldDefinitionImpl.setFieldGroup(fieldGroup);
    actualFieldDefinitionImpl.setFieldType("Field Type");
    actualFieldDefinitionImpl.setFriendlyName("Friendly Name");
    actualFieldDefinitionImpl.setHelpText("Help Text");
    actualFieldDefinitionImpl.setHiddenFlag(true);
    actualFieldDefinitionImpl.setHint("Hint");
    actualFieldDefinitionImpl.setId(1L);
    actualFieldDefinitionImpl.setMaxLength(3);
    actualFieldDefinitionImpl.setName("Name");
    actualFieldDefinitionImpl.setRequiredFlag(true);
    actualFieldDefinitionImpl.setSecurityLevel("Security Level");
    actualFieldDefinitionImpl.setTextAreaFlag(true);
    actualFieldDefinitionImpl.setTooltip("127.0.0.1");
    actualFieldDefinitionImpl.setValidationErrorMesageKey("An error occurred");
    actualFieldDefinitionImpl.setValidationRegEx(".*");
    Boolean actualAllowMultiples = actualFieldDefinitionImpl.getAllowMultiples();
    String actualColumnWidth = actualFieldDefinitionImpl.getColumnWidth();
    DataDrivenEnumeration actualDataDrivenEnumeration =
        actualFieldDefinitionImpl.getDataDrivenEnumeration();
    FieldGroup actualFieldGroup = actualFieldDefinitionImpl.getFieldGroup();
    String actualFieldTypeVal = actualFieldDefinitionImpl.getFieldTypeVal();
    String actualFriendlyName = actualFieldDefinitionImpl.getFriendlyName();
    String actualHelpText = actualFieldDefinitionImpl.getHelpText();
    String actualHint = actualFieldDefinitionImpl.getHint();
    Long actualId = actualFieldDefinitionImpl.getId();
    Integer actualMaxLength = actualFieldDefinitionImpl.getMaxLength();
    Boolean actualRequiredFlag = actualFieldDefinitionImpl.getRequiredFlag();
    String actualSecurityLevel = actualFieldDefinitionImpl.getSecurityLevel();
    Boolean actualTextAreaFlag = actualFieldDefinitionImpl.getTextAreaFlag();
    actualFieldDefinitionImpl.getTooltip();
    String actualValidationErrorMesageKey = actualFieldDefinitionImpl.getValidationErrorMesageKey();

    // Assert
    assertEquals(".*", actualFieldDefinitionImpl.getValidationRegEx());
    assertEquals("An error occurred", actualValidationErrorMesageKey);
    assertEquals("Column Width", actualColumnWidth);
    assertEquals("Field Type", actualFieldTypeVal);
    assertEquals("Friendly Name", actualFriendlyName);
    assertEquals("Help Text", actualHelpText);
    assertEquals("Hint", actualHint);
    assertEquals("Security Level", actualSecurityLevel);
    assertEquals(0, actualFieldDefinitionImpl.fieldOrder.intValue());
    assertEquals(1L, actualId.longValue());
    assertEquals(3, actualMaxLength.intValue());
    assertTrue(actualAllowMultiples);
    assertTrue(actualRequiredFlag);
    assertTrue(actualTextAreaFlag);
    assertSame(fieldGroup, actualFieldGroup);
    assertSame(dataDrivenEnumeration, actualDataDrivenEnumeration);
  }
}
