package org.broadleafcommerce.openadmin.web.form.component;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import org.broadleafcommerce.openadmin.web.rulebuilder.dto.DataWrapper;
import org.junit.Test;

public class RuleBuilderFieldDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
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

    // Assert that nothing has changed
    assertEquals("Field Builder", actualFieldBuilder);
    assertEquals("Json Field Name", actualJsonFieldName);
    assertEquals("Json", actualJson);
    assertEquals("Rule Type", actualRuleBuilderField.getRuleType());
    assertFalse(actualRuleBuilderField.getAllowNoValueEnumOption());
    assertTrue(actualRuleBuilderField.getAttributes().isEmpty());
    assertTrue(actualRuleBuilderField.getShouldRender());
    assertSame(dataWrapper, actualDataWrapper);
  }
}
