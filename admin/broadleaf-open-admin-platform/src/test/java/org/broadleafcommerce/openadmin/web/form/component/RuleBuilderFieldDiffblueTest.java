package org.broadleafcommerce.openadmin.web.form.component;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.openadmin.web.rulebuilder.dto.DataWrapper;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class RuleBuilderFieldDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link RuleBuilderField}
   *   <li>{@link RuleBuilderField#setDataWrapper(DataWrapper)}
   *   <li>{@link RuleBuilderField#setFieldBuilder(String)}
   *   <li>{@link RuleBuilderField#setJson(String)}
   *   <li>{@link RuleBuilderField#setJsonFieldName(String)}
   *   <li>{@link RuleBuilderField#setRuleType(String)}
   *   <li>{@link RuleBuilderField#getDataWrapper()}
   *   <li>{@link RuleBuilderField#getFieldBuilder()}
   *   <li>{@link RuleBuilderField#getJson()}
   *   <li>{@link RuleBuilderField#getJsonFieldName()}
   *   <li>{@link RuleBuilderField#getRuleType()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void RuleBuilderField.<init>()",
    "DataWrapper RuleBuilderField.getDataWrapper()",
    "String RuleBuilderField.getFieldBuilder()",
    "String RuleBuilderField.getJson()",
    "String RuleBuilderField.getJsonFieldName()",
    "String RuleBuilderField.getRuleType()",
    "void RuleBuilderField.setDataWrapper(DataWrapper)",
    "void RuleBuilderField.setFieldBuilder(String)",
    "void RuleBuilderField.setJson(String)",
    "void RuleBuilderField.setJsonFieldName(String)",
    "void RuleBuilderField.setRuleType(String)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    RuleBuilderField actualRuleBuilderField = new RuleBuilderField();
    DataWrapper dataWrapper = new DataWrapper();
    actualRuleBuilderField.setDataWrapper(dataWrapper);
    actualRuleBuilderField.setFieldBuilder("Field Builder");
    actualRuleBuilderField.setJson("Json");
    actualRuleBuilderField.setJsonFieldName("Json Field Name");
    actualRuleBuilderField.setRuleType("Rule Type");
    DataWrapper actualDataWrapper = actualRuleBuilderField.getDataWrapper();
    String actualFieldBuilder = actualRuleBuilderField.getFieldBuilder();
    String actualJson = actualRuleBuilderField.getJson();
    String actualJsonFieldName = actualRuleBuilderField.getJsonFieldName();

    // Assert
    assertEquals("Field Builder", actualFieldBuilder);
    assertEquals("Json Field Name", actualJsonFieldName);
    assertEquals("Json", actualJson);
    assertEquals("Rule Type", actualRuleBuilderField.getRuleType());
    assertNull(actualRuleBuilderField.getOrder());
    assertNull(actualRuleBuilderField.getAssociatedFieldName());
    assertNull(actualRuleBuilderField.getColumnWidth());
    assertNull(actualRuleBuilderField.getConfirmEnabledText());
    assertNull(actualRuleBuilderField.getDisplayType());
    assertNull(actualRuleBuilderField.getFieldComponentRenderer());
    assertNull(actualRuleBuilderField.getFieldType());
    assertNull(actualRuleBuilderField.getForeignKeyClass());
    assertNull(actualRuleBuilderField.getForeignKeyDisplayValueProperty());
    assertNull(actualRuleBuilderField.getForeignKeySectionPath());
    assertNull(actualRuleBuilderField.getFriendlyName());
    assertNull(actualRuleBuilderField.getGridFieldComponentRenderer());
    assertNull(actualRuleBuilderField.getIdOverride());
    assertNull(actualRuleBuilderField.getName());
    assertNull(actualRuleBuilderField.getOnChangeTrigger());
    assertNull(actualRuleBuilderField.getOwningEntityClass());
    assertNull(actualRuleBuilderField.getRawDisplayValue());
    assertNull(actualRuleBuilderField.getValue());
    assertFalse(actualRuleBuilderField.getAllowNoValueEnumOption());
    assertTrue(actualRuleBuilderField.getAttributes().isEmpty());
    assertTrue(actualRuleBuilderField.getShouldRender());
    assertSame(dataWrapper, actualDataWrapper);
  }
}
