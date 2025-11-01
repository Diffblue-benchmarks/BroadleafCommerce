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
package org.broadleafcommerce.admin.web.rulebuilder.service.extension;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import org.broadleafcommerce.common.extension.ExtensionResultStatusType;
import org.broadleafcommerce.common.presentation.client.SupportedFieldType;
import org.broadleafcommerce.core.rule.RuleDTOConfig;
import org.broadleafcommerce.openadmin.web.rulebuilder.dto.FieldData;
import org.broadleafcommerce.openadmin.web.rulebuilder.service.RuleBuilderFieldServiceExtensionManager;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {CookieFieldServiceExtensionHandler.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class CookieFieldServiceExtensionHandlerDiffblueTest {
  @Autowired
  private CookieFieldServiceExtensionHandler cookieFieldServiceExtensionHandler;

  @Autowired
  private List<RuleDTOConfig> list;

  @MockBean(name = "blRuleBuilderFieldServiceExtensionManager")
  private RuleBuilderFieldServiceExtensionManager ruleBuilderFieldServiceExtensionManager;

  @MockBean
  private RuleDTOConfig ruleDTOConfig;

  /**
   * Method under test:
   * {@link CookieFieldServiceExtensionHandler#addFields(List, String, String)}
   */
  @Test
  public void testAddFields() {
    // Arrange
    ArrayList<FieldData> fields = new ArrayList<>();

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        cookieFieldServiceExtensionHandler.addFields(fields, "Rule Field Name", "Dto Class Name"));
    assertTrue(fields.isEmpty());
  }

  /**
   * Method under test:
   * {@link CookieFieldServiceExtensionHandler#addFields(List, String, String)}
   */
  @Test
  public void testAddFields2() {
    // Arrange
    ArrayList<FieldData> fields = new ArrayList<>();
    fields.add(mock(FieldData.class));

    // Act
    ExtensionResultStatusType actualAddFieldsResult = cookieFieldServiceExtensionHandler.addFields(fields,
        "Rule Field Name", "Dto Class Name");

    // Assert
    assertEquals(1, fields.size());
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, actualAddFieldsResult);
  }

  /**
   * Method under test:
   * {@link CookieFieldServiceExtensionHandler#addFields(List, String, String)}
   */
  @Test
  public void testAddFields3() {
    // Arrange
    ArrayList<FieldData> fields = new ArrayList<>();
    fields.add(mock(FieldData.class));
    fields.add(mock(FieldData.class));

    // Act
    ExtensionResultStatusType actualAddFieldsResult = cookieFieldServiceExtensionHandler.addFields(fields,
        "Rule Field Name", "Dto Class Name");

    // Assert
    assertEquals(2, fields.size());
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, actualAddFieldsResult);
  }

  /**
   * Method under test:
   * {@link CookieFieldServiceExtensionHandler#addFields(List, String, String)}
   */
  @Test
  public void testAddFields4() {
    // Arrange
    when(ruleDTOConfig.getFieldName()).thenReturn("Field Name");
    when(ruleDTOConfig.getLabel()).thenReturn("Label");
    when(ruleDTOConfig.getOperators()).thenReturn("Operators");
    when(ruleDTOConfig.getOptions()).thenReturn("Options");
    when(ruleDTOConfig.getType()).thenReturn(SupportedFieldType.UNKNOWN);
    ArrayList<FieldData> fields = new ArrayList<>();

    // Act
    ExtensionResultStatusType actualAddFieldsResult = cookieFieldServiceExtensionHandler.addFields(fields,
        "REQUEST_FIELDS", "Dto Class Name");

    // Assert
    verify(ruleDTOConfig).getFieldName();
    verify(ruleDTOConfig).getLabel();
    verify(ruleDTOConfig).getOperators();
    verify(ruleDTOConfig).getOptions();
    verify(ruleDTOConfig).getType();
    assertEquals(1, fields.size());
    FieldData getResult = fields.get(0);
    assertEquals("Field Name", getResult.getFieldName());
    assertEquals("Label", getResult.getFieldLabel());
    assertEquals("Operators", getResult.getOperators());
    assertEquals("Options", getResult.getOptions());
    assertNull(getResult.getOverrideDtoClassName());
    assertNull(getResult.getSelectizeSectionKey());
    assertNull(getResult.getSecondaryFieldType());
    assertEquals(ExtensionResultStatusType.HANDLED_CONTINUE, actualAddFieldsResult);
    assertEquals(SupportedFieldType.UNKNOWN, getResult.getFieldType());
    assertTrue(getResult.getSkipValidation());
    assertEquals(CookieFieldServiceExtensionHandler.COOKIE_ATTRIBUTE_NAME, getResult.getOverrideEntityKey());
  }

  /**
   * Method under test:
   * {@link CookieFieldServiceExtensionHandler#CookieFieldServiceExtensionHandler(RuleBuilderFieldServiceExtensionManager, List)}
   */
  @Test
  public void testNewCookieFieldServiceExtensionHandler() {
    // Arrange
    RuleBuilderFieldServiceExtensionManager extensionManager = new RuleBuilderFieldServiceExtensionManager();

    // Act
    CookieFieldServiceExtensionHandler actualCookieFieldServiceExtensionHandler = new CookieFieldServiceExtensionHandler(
        extensionManager, new ArrayList<>());

    // Assert
    assertEquals(0, actualCookieFieldServiceExtensionHandler.getPriority());
    assertTrue(actualCookieFieldServiceExtensionHandler.extensionManager.getHandlers().isEmpty());
    assertTrue(actualCookieFieldServiceExtensionHandler.fieldConfigs.isEmpty());
    assertTrue(actualCookieFieldServiceExtensionHandler.isEnabled());
  }
}
