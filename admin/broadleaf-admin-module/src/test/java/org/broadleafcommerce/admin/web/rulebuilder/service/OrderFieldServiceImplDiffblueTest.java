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

public class OrderFieldServiceImplDiffblueTest {
  /**
   * Test {@link OrderFieldServiceImpl#init()}.
   * <p>
   * Method under test: {@link OrderFieldServiceImpl#init()}
   */
  @Test
  public void testInit() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderFieldServiceImpl orderFieldServiceImpl = new OrderFieldServiceImpl();
    orderFieldServiceImpl
        .setRuleBuilderFieldServiceExtensionManager(mock(RuleBuilderFieldServiceExtensionManager.class));

    // Act
    orderFieldServiceImpl.init();

    // Assert
    List<FieldData> fields = orderFieldServiceImpl.getFields();
    assertEquals(3, fields.size());
    FieldData getResult = fields.get(0);
    assertEquals("[]", getResult.getOptions());
    FieldData getResult2 = fields.get(1);
    assertEquals("[]", getResult2.getOptions());
    FieldData getResult3 = fields.get(2);
    assertEquals("[]", getResult3.getOptions());
    assertEquals("blcOperators_Numeric", getResult2.getOperators());
    assertEquals("blcOperators_Text", getResult.getOperators());
    assertEquals("blcOperators_Text", getResult3.getOperators());
    assertEquals("currency.currencyCode", getResult.getFieldName());
    assertEquals("locale.localeCode", getResult3.getFieldName());
    assertEquals("rule_localeCode", getResult3.getFieldLabel());
    assertEquals("rule_orderCurrencyCode", getResult.getFieldLabel());
    assertEquals("rule_orderSubtotal", getResult2.getFieldLabel());
    assertEquals("subTotal", getResult2.getFieldName());
    assertNull(getResult.getOverrideDtoClassName());
    assertNull(getResult2.getOverrideDtoClassName());
    assertNull(getResult3.getOverrideDtoClassName());
    assertNull(getResult.getOverrideEntityKey());
    assertNull(getResult2.getOverrideEntityKey());
    assertNull(getResult3.getOverrideEntityKey());
    assertNull(getResult.getSelectizeSectionKey());
    assertNull(getResult2.getSelectizeSectionKey());
    assertNull(getResult3.getSelectizeSectionKey());
    assertNull(getResult.getSecondaryFieldType());
    assertNull(getResult2.getSecondaryFieldType());
    assertNull(getResult3.getSecondaryFieldType());
    assertEquals(SupportedFieldType.MONEY, getResult2.getFieldType());
    assertEquals(SupportedFieldType.STRING, getResult.getFieldType());
    assertEquals(SupportedFieldType.STRING, getResult3.getFieldType());
    assertFalse(getResult.getSkipValidation());
    assertFalse(getResult2.getSkipValidation());
    assertFalse(getResult3.getSkipValidation());
  }

  /**
   * Test {@link OrderFieldServiceImpl#init()}.
   * <ul>
   *   <li>Given {@link OrderFieldServiceImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderFieldServiceImpl#init()}
   */
  @Test
  public void testInit_givenOrderFieldServiceImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderFieldServiceImpl orderFieldServiceImpl = new OrderFieldServiceImpl();

    // Act
    orderFieldServiceImpl.init();

    // Assert
    List<FieldData> fields = orderFieldServiceImpl.getFields();
    assertEquals(3, fields.size());
    FieldData getResult = fields.get(0);
    assertEquals("[]", getResult.getOptions());
    FieldData getResult2 = fields.get(1);
    assertEquals("[]", getResult2.getOptions());
    FieldData getResult3 = fields.get(2);
    assertEquals("[]", getResult3.getOptions());
    assertEquals("blcOperators_Numeric", getResult2.getOperators());
    assertEquals("blcOperators_Text", getResult.getOperators());
    assertEquals("blcOperators_Text", getResult3.getOperators());
    assertEquals("currency.currencyCode", getResult.getFieldName());
    assertEquals("locale.localeCode", getResult3.getFieldName());
    assertEquals("rule_localeCode", getResult3.getFieldLabel());
    assertEquals("rule_orderCurrencyCode", getResult.getFieldLabel());
    assertEquals("rule_orderSubtotal", getResult2.getFieldLabel());
    assertEquals("subTotal", getResult2.getFieldName());
    assertNull(getResult.getOverrideDtoClassName());
    assertNull(getResult2.getOverrideDtoClassName());
    assertNull(getResult3.getOverrideDtoClassName());
    assertNull(getResult.getOverrideEntityKey());
    assertNull(getResult2.getOverrideEntityKey());
    assertNull(getResult3.getOverrideEntityKey());
    assertNull(getResult.getSelectizeSectionKey());
    assertNull(getResult2.getSelectizeSectionKey());
    assertNull(getResult3.getSelectizeSectionKey());
    assertNull(getResult.getSecondaryFieldType());
    assertNull(getResult2.getSecondaryFieldType());
    assertNull(getResult3.getSecondaryFieldType());
    assertEquals(SupportedFieldType.MONEY, getResult2.getFieldType());
    assertEquals(SupportedFieldType.STRING, getResult.getFieldType());
    assertEquals(SupportedFieldType.STRING, getResult3.getFieldType());
    assertFalse(getResult.getSkipValidation());
    assertFalse(getResult2.getSkipValidation());
    assertFalse(getResult3.getSkipValidation());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link OrderFieldServiceImpl#getDtoClassName()}
   *   <li>{@link OrderFieldServiceImpl#getName()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    OrderFieldServiceImpl orderFieldServiceImpl = new OrderFieldServiceImpl();

    // Act
    String actualDtoClassName = orderFieldServiceImpl.getDtoClassName();

    // Assert
    assertEquals("ORDER_FIELDS", orderFieldServiceImpl.getName());
    assertEquals("org.broadleafcommerce.core.order.domain.OrderImpl", actualDtoClassName);
  }
}
