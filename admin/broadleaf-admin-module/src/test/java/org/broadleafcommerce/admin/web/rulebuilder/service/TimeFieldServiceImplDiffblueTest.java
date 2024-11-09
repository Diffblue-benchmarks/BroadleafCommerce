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

public class TimeFieldServiceImplDiffblueTest {
  /**
   * Test {@link TimeFieldServiceImpl#init()}.
   * <p>
   * Method under test: {@link TimeFieldServiceImpl#init()}
   */
  @Test
  public void testInit() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TimeFieldServiceImpl timeFieldServiceImpl = new TimeFieldServiceImpl();
    timeFieldServiceImpl
        .setRuleBuilderFieldServiceExtensionManager(mock(RuleBuilderFieldServiceExtensionManager.class));

    // Act
    timeFieldServiceImpl.init();

    // Assert
    List<FieldData> fields = timeFieldServiceImpl.getFields();
    assertEquals(6, fields.size());
    FieldData getResult = fields.get(5);
    assertEquals("[]", getResult.getOptions());
    assertEquals("blcOperators_Date", getResult.getOperators());
    FieldData getResult2 = fields.get(0);
    assertEquals("blcOperators_Selectize_Enumeration", getResult2.getOperators());
    FieldData getResult3 = fields.get(1);
    assertEquals("blcOperators_Selectize_Enumeration", getResult3.getOperators());
    FieldData getResult4 = fields.get(2);
    assertEquals("blcOperators_Selectize_Enumeration", getResult4.getOperators());
    FieldData getResult5 = fields.get(3);
    assertEquals("blcOperators_Selectize_Enumeration", getResult5.getOperators());
    FieldData getResult6 = fields.get(4);
    assertEquals("blcOperators_Selectize_Enumeration", getResult6.getOperators());
    assertEquals("blcOptions_DayOfMonth", getResult5.getOptions());
    assertEquals("blcOptions_DayOfWeek", getResult3.getOptions());
    assertEquals("blcOptions_HourOfDay", getResult2.getOptions());
    assertEquals("blcOptions_Minute", getResult6.getOptions());
    assertEquals("blcOptions_Month", getResult4.getOptions());
    assertEquals("date", getResult.getFieldName());
    assertEquals("dayOfMonth", getResult5.getFieldName());
    assertEquals("dayOfWeek", getResult3.getFieldName());
    assertEquals("hour", getResult2.getFieldName());
    assertEquals("minute", getResult6.getFieldName());
    assertEquals("month", getResult4.getFieldName());
    assertEquals("rule_timeDate", getResult.getFieldLabel());
    assertEquals("rule_timeDayOfMonth", getResult5.getFieldLabel());
    assertEquals("rule_timeDayOfWeek", getResult3.getFieldLabel());
    assertEquals("rule_timeHourOfDay", getResult2.getFieldLabel());
    assertEquals("rule_timeMinute", getResult6.getFieldLabel());
    assertEquals("rule_timeMonth", getResult4.getFieldLabel());
    assertNull(getResult2.getOverrideDtoClassName());
    assertNull(getResult3.getOverrideDtoClassName());
    assertNull(getResult4.getOverrideDtoClassName());
    assertNull(getResult5.getOverrideDtoClassName());
    assertNull(getResult6.getOverrideDtoClassName());
    assertNull(getResult.getOverrideDtoClassName());
    assertNull(getResult2.getOverrideEntityKey());
    assertNull(getResult3.getOverrideEntityKey());
    assertNull(getResult4.getOverrideEntityKey());
    assertNull(getResult5.getOverrideEntityKey());
    assertNull(getResult6.getOverrideEntityKey());
    assertNull(getResult.getOverrideEntityKey());
    assertNull(getResult2.getSelectizeSectionKey());
    assertNull(getResult3.getSelectizeSectionKey());
    assertNull(getResult4.getSelectizeSectionKey());
    assertNull(getResult5.getSelectizeSectionKey());
    assertNull(getResult6.getSelectizeSectionKey());
    assertNull(getResult.getSelectizeSectionKey());
    assertNull(getResult2.getSecondaryFieldType());
    assertNull(getResult3.getSecondaryFieldType());
    assertNull(getResult4.getSecondaryFieldType());
    assertNull(getResult5.getSecondaryFieldType());
    assertNull(getResult6.getSecondaryFieldType());
    assertNull(getResult.getSecondaryFieldType());
    assertEquals(SupportedFieldType.BROADLEAF_ENUMERATION, getResult2.getFieldType());
    assertEquals(SupportedFieldType.BROADLEAF_ENUMERATION, getResult3.getFieldType());
    assertEquals(SupportedFieldType.BROADLEAF_ENUMERATION, getResult4.getFieldType());
    assertEquals(SupportedFieldType.BROADLEAF_ENUMERATION, getResult5.getFieldType());
    assertEquals(SupportedFieldType.BROADLEAF_ENUMERATION, getResult6.getFieldType());
    assertEquals(SupportedFieldType.DATE, getResult.getFieldType());
    assertFalse(getResult2.getSkipValidation());
    assertFalse(getResult3.getSkipValidation());
    assertFalse(getResult4.getSkipValidation());
    assertFalse(getResult5.getSkipValidation());
    assertFalse(getResult6.getSkipValidation());
    assertFalse(getResult.getSkipValidation());
  }

  /**
   * Test {@link TimeFieldServiceImpl#init()}.
   * <ul>
   *   <li>Given {@link TimeFieldServiceImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link TimeFieldServiceImpl#init()}
   */
  @Test
  public void testInit_givenTimeFieldServiceImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TimeFieldServiceImpl timeFieldServiceImpl = new TimeFieldServiceImpl();

    // Act
    timeFieldServiceImpl.init();

    // Assert
    List<FieldData> fields = timeFieldServiceImpl.getFields();
    assertEquals(6, fields.size());
    FieldData getResult = fields.get(5);
    assertEquals("[]", getResult.getOptions());
    assertEquals("blcOperators_Date", getResult.getOperators());
    FieldData getResult2 = fields.get(0);
    assertEquals("blcOperators_Selectize_Enumeration", getResult2.getOperators());
    FieldData getResult3 = fields.get(1);
    assertEquals("blcOperators_Selectize_Enumeration", getResult3.getOperators());
    FieldData getResult4 = fields.get(2);
    assertEquals("blcOperators_Selectize_Enumeration", getResult4.getOperators());
    FieldData getResult5 = fields.get(3);
    assertEquals("blcOperators_Selectize_Enumeration", getResult5.getOperators());
    FieldData getResult6 = fields.get(4);
    assertEquals("blcOperators_Selectize_Enumeration", getResult6.getOperators());
    assertEquals("blcOptions_DayOfMonth", getResult5.getOptions());
    assertEquals("blcOptions_DayOfWeek", getResult3.getOptions());
    assertEquals("blcOptions_HourOfDay", getResult2.getOptions());
    assertEquals("blcOptions_Minute", getResult6.getOptions());
    assertEquals("blcOptions_Month", getResult4.getOptions());
    assertEquals("date", getResult.getFieldName());
    assertEquals("dayOfMonth", getResult5.getFieldName());
    assertEquals("dayOfWeek", getResult3.getFieldName());
    assertEquals("hour", getResult2.getFieldName());
    assertEquals("minute", getResult6.getFieldName());
    assertEquals("month", getResult4.getFieldName());
    assertEquals("rule_timeDate", getResult.getFieldLabel());
    assertEquals("rule_timeDayOfMonth", getResult5.getFieldLabel());
    assertEquals("rule_timeDayOfWeek", getResult3.getFieldLabel());
    assertEquals("rule_timeHourOfDay", getResult2.getFieldLabel());
    assertEquals("rule_timeMinute", getResult6.getFieldLabel());
    assertEquals("rule_timeMonth", getResult4.getFieldLabel());
    assertNull(getResult2.getOverrideDtoClassName());
    assertNull(getResult3.getOverrideDtoClassName());
    assertNull(getResult4.getOverrideDtoClassName());
    assertNull(getResult5.getOverrideDtoClassName());
    assertNull(getResult6.getOverrideDtoClassName());
    assertNull(getResult.getOverrideDtoClassName());
    assertNull(getResult2.getOverrideEntityKey());
    assertNull(getResult3.getOverrideEntityKey());
    assertNull(getResult4.getOverrideEntityKey());
    assertNull(getResult5.getOverrideEntityKey());
    assertNull(getResult6.getOverrideEntityKey());
    assertNull(getResult.getOverrideEntityKey());
    assertNull(getResult2.getSelectizeSectionKey());
    assertNull(getResult3.getSelectizeSectionKey());
    assertNull(getResult4.getSelectizeSectionKey());
    assertNull(getResult5.getSelectizeSectionKey());
    assertNull(getResult6.getSelectizeSectionKey());
    assertNull(getResult.getSelectizeSectionKey());
    assertNull(getResult2.getSecondaryFieldType());
    assertNull(getResult3.getSecondaryFieldType());
    assertNull(getResult4.getSecondaryFieldType());
    assertNull(getResult5.getSecondaryFieldType());
    assertNull(getResult6.getSecondaryFieldType());
    assertNull(getResult.getSecondaryFieldType());
    assertEquals(SupportedFieldType.BROADLEAF_ENUMERATION, getResult2.getFieldType());
    assertEquals(SupportedFieldType.BROADLEAF_ENUMERATION, getResult3.getFieldType());
    assertEquals(SupportedFieldType.BROADLEAF_ENUMERATION, getResult4.getFieldType());
    assertEquals(SupportedFieldType.BROADLEAF_ENUMERATION, getResult5.getFieldType());
    assertEquals(SupportedFieldType.BROADLEAF_ENUMERATION, getResult6.getFieldType());
    assertEquals(SupportedFieldType.DATE, getResult.getFieldType());
    assertFalse(getResult2.getSkipValidation());
    assertFalse(getResult3.getSkipValidation());
    assertFalse(getResult4.getSkipValidation());
    assertFalse(getResult5.getSkipValidation());
    assertFalse(getResult6.getSkipValidation());
    assertFalse(getResult.getSkipValidation());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TimeFieldServiceImpl#getDtoClassName()}
   *   <li>{@link TimeFieldServiceImpl#getName()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    TimeFieldServiceImpl timeFieldServiceImpl = new TimeFieldServiceImpl();

    // Act
    String actualDtoClassName = timeFieldServiceImpl.getDtoClassName();

    // Assert
    assertEquals("TIME_FIELDS", timeFieldServiceImpl.getName());
    assertEquals("org.broadleafcommerce.common.TimeDTO", actualDtoClassName);
  }
}
