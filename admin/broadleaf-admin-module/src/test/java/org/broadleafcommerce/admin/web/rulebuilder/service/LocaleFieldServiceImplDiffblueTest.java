/*-
 * #%L
 * BroadleafCommerce Admin Module
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
package org.broadleafcommerce.admin.web.rulebuilder.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.mock;
import java.util.List;
import org.broadleafcommerce.common.presentation.client.SupportedFieldType;
import org.broadleafcommerce.openadmin.web.rulebuilder.dto.FieldData;
import org.broadleafcommerce.openadmin.web.rulebuilder.service.RuleBuilderFieldServiceExtensionManager;
import org.junit.Test;

public class LocaleFieldServiceImplDiffblueTest {
  /**
   * Test {@link LocaleFieldServiceImpl#init()}.
   * <p>
   * Method under test: {@link LocaleFieldServiceImpl#init()}
   */
  @Test
  public void testInit() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LocaleFieldServiceImpl localeFieldServiceImpl = new LocaleFieldServiceImpl();
    localeFieldServiceImpl
        .setRuleBuilderFieldServiceExtensionManager(mock(RuleBuilderFieldServiceExtensionManager.class));

    // Act
    localeFieldServiceImpl.init();

    // Assert
    List<FieldData> fields = localeFieldServiceImpl.getFields();
    assertEquals(2, fields.size());
    FieldData getResult = fields.get(0);
    assertEquals("[]", getResult.getOptions());
    FieldData getResult2 = fields.get(1);
    assertEquals("[]", getResult2.getOptions());
    assertEquals("blcOperators_Text", getResult.getOperators());
    assertEquals("blcOperators_Text", getResult2.getOperators());
    assertEquals("friendlyName", getResult.getFieldName());
    assertEquals("localeCode", getResult2.getFieldName());
    assertEquals("rule_localeCode", getResult2.getFieldLabel());
    assertEquals("rule_localeName", getResult.getFieldLabel());
    assertNull(getResult.getOverrideDtoClassName());
    assertNull(getResult2.getOverrideDtoClassName());
    assertNull(getResult.getOverrideEntityKey());
    assertNull(getResult2.getOverrideEntityKey());
    assertNull(getResult.getSelectizeSectionKey());
    assertNull(getResult2.getSelectizeSectionKey());
    assertNull(getResult.getSecondaryFieldType());
    assertNull(getResult2.getSecondaryFieldType());
    assertEquals(SupportedFieldType.STRING, getResult.getFieldType());
    assertEquals(SupportedFieldType.STRING, getResult2.getFieldType());
    assertFalse(getResult.getSkipValidation());
    assertFalse(getResult2.getSkipValidation());
  }

  /**
   * Test {@link LocaleFieldServiceImpl#init()}.
   * <ul>
   *   <li>Given {@link LocaleFieldServiceImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link LocaleFieldServiceImpl#init()}
   */
  @Test
  public void testInit_givenLocaleFieldServiceImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LocaleFieldServiceImpl localeFieldServiceImpl = new LocaleFieldServiceImpl();

    // Act
    localeFieldServiceImpl.init();

    // Assert
    List<FieldData> fields = localeFieldServiceImpl.getFields();
    assertEquals(2, fields.size());
    FieldData getResult = fields.get(0);
    assertEquals("[]", getResult.getOptions());
    FieldData getResult2 = fields.get(1);
    assertEquals("[]", getResult2.getOptions());
    assertEquals("blcOperators_Text", getResult.getOperators());
    assertEquals("blcOperators_Text", getResult2.getOperators());
    assertEquals("friendlyName", getResult.getFieldName());
    assertEquals("localeCode", getResult2.getFieldName());
    assertEquals("rule_localeCode", getResult2.getFieldLabel());
    assertEquals("rule_localeName", getResult.getFieldLabel());
    assertNull(getResult.getOverrideDtoClassName());
    assertNull(getResult2.getOverrideDtoClassName());
    assertNull(getResult.getOverrideEntityKey());
    assertNull(getResult2.getOverrideEntityKey());
    assertNull(getResult.getSelectizeSectionKey());
    assertNull(getResult2.getSelectizeSectionKey());
    assertNull(getResult.getSecondaryFieldType());
    assertNull(getResult2.getSecondaryFieldType());
    assertEquals(SupportedFieldType.STRING, getResult.getFieldType());
    assertEquals(SupportedFieldType.STRING, getResult2.getFieldType());
    assertFalse(getResult.getSkipValidation());
    assertFalse(getResult2.getSkipValidation());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link LocaleFieldServiceImpl#getDtoClassName()}
   *   <li>{@link LocaleFieldServiceImpl#getName()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    LocaleFieldServiceImpl localeFieldServiceImpl = new LocaleFieldServiceImpl();

    // Act
    String actualDtoClassName = localeFieldServiceImpl.getDtoClassName();

    // Assert
    assertEquals("LOCALE_FIELDS", localeFieldServiceImpl.getName());
    assertEquals("org.broadleafcommerce.common.locale.domain.LocaleImpl", actualDtoClassName);
  }
}
