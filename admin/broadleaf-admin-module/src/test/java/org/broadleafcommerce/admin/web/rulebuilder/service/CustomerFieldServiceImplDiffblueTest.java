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

public class CustomerFieldServiceImplDiffblueTest {
  /**
   * Test {@link CustomerFieldServiceImpl#init()}.
   * <p>
   * Method under test: {@link CustomerFieldServiceImpl#init()}
   */
  @Test
  public void testInit() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CustomerFieldServiceImpl customerFieldServiceImpl = new CustomerFieldServiceImpl();
    customerFieldServiceImpl
        .setRuleBuilderFieldServiceExtensionManager(mock(RuleBuilderFieldServiceExtensionManager.class));

    // Act
    customerFieldServiceImpl.init();

    // Assert
    List<FieldData> fields = customerFieldServiceImpl.getFields();
    assertEquals(8, fields.size());
    FieldData getResult = fields.get(0);
    assertEquals("[]", getResult.getOptions());
    FieldData getResult2 = fields.get(1);
    assertEquals("[]", getResult2.getOptions());
    FieldData getResult3 = fields.get(2);
    assertEquals("[]", getResult3.getOptions());
    FieldData getResult4 = fields.get(5);
    assertEquals("[]", getResult4.getOptions());
    FieldData getResult5 = fields.get(6);
    assertEquals("[]", getResult5.getOptions());
    FieldData getResult6 = fields.get(7);
    assertEquals("[]", getResult6.getOptions());
    assertEquals("blcOperators_Boolean", getResult.getOperators());
    assertEquals("blcOperators_Boolean", getResult2.getOperators());
    assertEquals("blcOperators_Numeric", getResult3.getOperators());
    assertEquals("blcOperators_Text", getResult4.getOperators());
    assertEquals("blcOperators_Text", getResult5.getOperators());
    assertEquals("blcOperators_Text", getResult6.getOperators());
    assertEquals("emailAddress", getResult4.getFieldName());
    assertEquals("firstName", getResult5.getFieldName());
    assertEquals("id", getResult3.getFieldName());
    assertEquals("lastName", getResult6.getFieldName());
    assertEquals("loggedIn", getResult.getFieldName());
    assertEquals("registered", getResult2.getFieldName());
    assertEquals("rule_customerEmailAddress", getResult4.getFieldLabel());
    assertEquals("rule_customerFirstName", getResult5.getFieldLabel());
    assertEquals("rule_customerId", getResult3.getFieldLabel());
    assertEquals("rule_customerLastName", getResult6.getFieldLabel());
    assertEquals("rule_customerLoggedIn", getResult.getFieldLabel());
    assertEquals("rule_customerRegistered", getResult2.getFieldLabel());
    assertNull(getResult.getOverrideDtoClassName());
    assertNull(getResult2.getOverrideDtoClassName());
    assertNull(getResult3.getOverrideDtoClassName());
    assertNull(getResult4.getOverrideDtoClassName());
    assertNull(getResult5.getOverrideDtoClassName());
    assertNull(getResult6.getOverrideDtoClassName());
    assertNull(getResult.getOverrideEntityKey());
    assertNull(getResult2.getOverrideEntityKey());
    assertNull(getResult3.getOverrideEntityKey());
    assertNull(getResult4.getOverrideEntityKey());
    assertNull(getResult5.getOverrideEntityKey());
    assertNull(getResult6.getOverrideEntityKey());
    assertNull(getResult.getSelectizeSectionKey());
    assertNull(getResult2.getSelectizeSectionKey());
    assertNull(getResult3.getSelectizeSectionKey());
    assertNull(getResult4.getSelectizeSectionKey());
    assertNull(getResult5.getSelectizeSectionKey());
    assertNull(getResult6.getSelectizeSectionKey());
    assertNull(getResult.getSecondaryFieldType());
    assertNull(getResult2.getSecondaryFieldType());
    assertNull(getResult3.getSecondaryFieldType());
    assertNull(getResult4.getSecondaryFieldType());
    assertNull(getResult5.getSecondaryFieldType());
    assertNull(getResult6.getSecondaryFieldType());
    assertEquals(SupportedFieldType.BOOLEAN, getResult.getFieldType());
    assertEquals(SupportedFieldType.BOOLEAN, getResult2.getFieldType());
    assertEquals(SupportedFieldType.ID, getResult3.getFieldType());
    assertEquals(SupportedFieldType.STRING, getResult4.getFieldType());
    assertEquals(SupportedFieldType.STRING, getResult5.getFieldType());
    assertEquals(SupportedFieldType.STRING, getResult6.getFieldType());
    assertFalse(getResult.getSkipValidation());
    assertFalse(getResult2.getSkipValidation());
    assertFalse(getResult3.getSkipValidation());
    assertFalse(getResult4.getSkipValidation());
    assertFalse(getResult5.getSkipValidation());
    assertFalse(getResult6.getSkipValidation());
  }

  /**
   * Test {@link CustomerFieldServiceImpl#init()}.
   * <ul>
   *   <li>Given {@link CustomerFieldServiceImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerFieldServiceImpl#init()}
   */
  @Test
  public void testInit_givenCustomerFieldServiceImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CustomerFieldServiceImpl customerFieldServiceImpl = new CustomerFieldServiceImpl();

    // Act
    customerFieldServiceImpl.init();

    // Assert
    List<FieldData> fields = customerFieldServiceImpl.getFields();
    assertEquals(8, fields.size());
    FieldData getResult = fields.get(0);
    assertEquals("[]", getResult.getOptions());
    FieldData getResult2 = fields.get(1);
    assertEquals("[]", getResult2.getOptions());
    FieldData getResult3 = fields.get(2);
    assertEquals("[]", getResult3.getOptions());
    FieldData getResult4 = fields.get(5);
    assertEquals("[]", getResult4.getOptions());
    FieldData getResult5 = fields.get(6);
    assertEquals("[]", getResult5.getOptions());
    FieldData getResult6 = fields.get(7);
    assertEquals("[]", getResult6.getOptions());
    assertEquals("blcOperators_Boolean", getResult.getOperators());
    assertEquals("blcOperators_Boolean", getResult2.getOperators());
    assertEquals("blcOperators_Numeric", getResult3.getOperators());
    assertEquals("blcOperators_Text", getResult4.getOperators());
    assertEquals("blcOperators_Text", getResult5.getOperators());
    assertEquals("blcOperators_Text", getResult6.getOperators());
    assertEquals("emailAddress", getResult4.getFieldName());
    assertEquals("firstName", getResult5.getFieldName());
    assertEquals("id", getResult3.getFieldName());
    assertEquals("lastName", getResult6.getFieldName());
    assertEquals("loggedIn", getResult.getFieldName());
    assertEquals("registered", getResult2.getFieldName());
    assertEquals("rule_customerEmailAddress", getResult4.getFieldLabel());
    assertEquals("rule_customerFirstName", getResult5.getFieldLabel());
    assertEquals("rule_customerId", getResult3.getFieldLabel());
    assertEquals("rule_customerLastName", getResult6.getFieldLabel());
    assertEquals("rule_customerLoggedIn", getResult.getFieldLabel());
    assertEquals("rule_customerRegistered", getResult2.getFieldLabel());
    assertNull(getResult.getOverrideDtoClassName());
    assertNull(getResult2.getOverrideDtoClassName());
    assertNull(getResult3.getOverrideDtoClassName());
    assertNull(getResult4.getOverrideDtoClassName());
    assertNull(getResult5.getOverrideDtoClassName());
    assertNull(getResult6.getOverrideDtoClassName());
    assertNull(getResult.getOverrideEntityKey());
    assertNull(getResult2.getOverrideEntityKey());
    assertNull(getResult3.getOverrideEntityKey());
    assertNull(getResult4.getOverrideEntityKey());
    assertNull(getResult5.getOverrideEntityKey());
    assertNull(getResult6.getOverrideEntityKey());
    assertNull(getResult.getSelectizeSectionKey());
    assertNull(getResult2.getSelectizeSectionKey());
    assertNull(getResult3.getSelectizeSectionKey());
    assertNull(getResult4.getSelectizeSectionKey());
    assertNull(getResult5.getSelectizeSectionKey());
    assertNull(getResult6.getSelectizeSectionKey());
    assertNull(getResult.getSecondaryFieldType());
    assertNull(getResult2.getSecondaryFieldType());
    assertNull(getResult3.getSecondaryFieldType());
    assertNull(getResult4.getSecondaryFieldType());
    assertNull(getResult5.getSecondaryFieldType());
    assertNull(getResult6.getSecondaryFieldType());
    assertEquals(SupportedFieldType.BOOLEAN, getResult.getFieldType());
    assertEquals(SupportedFieldType.BOOLEAN, getResult2.getFieldType());
    assertEquals(SupportedFieldType.ID, getResult3.getFieldType());
    assertEquals(SupportedFieldType.STRING, getResult4.getFieldType());
    assertEquals(SupportedFieldType.STRING, getResult5.getFieldType());
    assertEquals(SupportedFieldType.STRING, getResult6.getFieldType());
    assertFalse(getResult.getSkipValidation());
    assertFalse(getResult2.getSkipValidation());
    assertFalse(getResult3.getSkipValidation());
    assertFalse(getResult4.getSkipValidation());
    assertFalse(getResult5.getSkipValidation());
    assertFalse(getResult6.getSkipValidation());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link CustomerFieldServiceImpl#getDtoClassName()}
   *   <li>{@link CustomerFieldServiceImpl#getName()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    CustomerFieldServiceImpl customerFieldServiceImpl = new CustomerFieldServiceImpl();

    // Act
    String actualDtoClassName = customerFieldServiceImpl.getDtoClassName();

    // Assert
    assertEquals("CUSTOMER_FIELDS", customerFieldServiceImpl.getName());
    assertEquals("org.broadleafcommerce.profile.core.domain.CustomerImpl", actualDtoClassName);
  }
}
