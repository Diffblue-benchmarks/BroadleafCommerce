/*-
 * #%L
 * BroadleafCommerce Framework
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
package org.broadleafcommerce.core.rule;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.broadleafcommerce.common.presentation.client.SupportedFieldType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {RuleDTOConfig.class, String.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class RuleDTOConfigDiffblueTest {
  @Autowired
  private RuleDTOConfig ruleDTOConfig;

  /**
   * Test {@link RuleDTOConfig#RuleDTOConfig(String, String)}.
   * <p>
   * Method under test: {@link RuleDTOConfig#RuleDTOConfig(String, String)}
   */
  @Test
  public void testNewRuleDTOConfig() {
    // Arrange and Act
    RuleDTOConfig actualRuleDTOConfig = new RuleDTOConfig("Field Name", "Label");

    // Assert
    assertEquals("Field Name", actualRuleDTOConfig.getFieldName());
    assertEquals("Label", actualRuleDTOConfig.getLabel());
    assertEquals("[]", actualRuleDTOConfig.getOptions());
    assertEquals("blcOperators_Text_List", actualRuleDTOConfig.getOperators());
    assertNull(actualRuleDTOConfig.getAlternateName());
    assertEquals(SupportedFieldType.STRING, actualRuleDTOConfig.getType());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link RuleDTOConfig#setAlternateName(String)}
   *   <li>{@link RuleDTOConfig#setFieldName(String)}
   *   <li>{@link RuleDTOConfig#setLabel(String)}
   *   <li>{@link RuleDTOConfig#setOperators(String)}
   *   <li>{@link RuleDTOConfig#setOptions(String)}
   *   <li>{@link RuleDTOConfig#setType(SupportedFieldType)}
   *   <li>{@link RuleDTOConfig#getAlternateName()}
   *   <li>{@link RuleDTOConfig#getFieldName()}
   *   <li>{@link RuleDTOConfig#getLabel()}
   *   <li>{@link RuleDTOConfig#getOperators()}
   *   <li>{@link RuleDTOConfig#getOptions()}
   *   <li>{@link RuleDTOConfig#getType()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    RuleDTOConfig ruleDTOConfig = new RuleDTOConfig("Field Name", "Label");

    // Act
    ruleDTOConfig.setAlternateName("Alternate Name");
    ruleDTOConfig.setFieldName("Field Name");
    ruleDTOConfig.setLabel("Label");
    ruleDTOConfig.setOperators("Operators");
    ruleDTOConfig.setOptions("Options");
    ruleDTOConfig.setType(SupportedFieldType.UNKNOWN);
    String actualAlternateName = ruleDTOConfig.getAlternateName();
    String actualFieldName = ruleDTOConfig.getFieldName();
    String actualLabel = ruleDTOConfig.getLabel();
    String actualOperators = ruleDTOConfig.getOperators();
    String actualOptions = ruleDTOConfig.getOptions();

    // Assert that nothing has changed
    assertEquals("Alternate Name", actualAlternateName);
    assertEquals("Field Name", actualFieldName);
    assertEquals("Label", actualLabel);
    assertEquals("Operators", actualOperators);
    assertEquals("Options", actualOptions);
    assertEquals(SupportedFieldType.UNKNOWN, ruleDTOConfig.getType());
  }
}
