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
