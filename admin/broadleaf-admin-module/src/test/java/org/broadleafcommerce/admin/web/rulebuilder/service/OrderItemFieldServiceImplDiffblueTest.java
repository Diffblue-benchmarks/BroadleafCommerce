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

public class OrderItemFieldServiceImplDiffblueTest {
  /**
   * Test {@link OrderItemFieldServiceImpl#init()}.
   * <p>
   * Method under test: {@link OrderItemFieldServiceImpl#init()}
   */
  @Test
  public void testInit() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderItemFieldServiceImpl orderItemFieldServiceImpl = new OrderItemFieldServiceImpl();
    orderItemFieldServiceImpl
        .setRuleBuilderFieldServiceExtensionManager(mock(RuleBuilderFieldServiceExtensionManager.class));

    // Act
    orderItemFieldServiceImpl.init();

    // Assert
    List<FieldData> fields = orderItemFieldServiceImpl.getFields();
    assertEquals(7, fields.size());
    FieldData getResult = fields.get(0);
    assertEquals("[]", getResult.getOptions());
    FieldData getResult2 = fields.get(1);
    assertEquals("[]", getResult2.getOptions());
    FieldData getResult3 = fields.get(2);
    assertEquals("[]", getResult3.getOptions());
    FieldData getResult4 = fields.get(4);
    assertEquals("[]", getResult4.getOptions());
    FieldData getResult5 = fields.get(5);
    assertEquals("[]", getResult5.getOptions());
    FieldData getResult6 = fields.get(6);
    assertEquals("[]", getResult6.getOptions());
    assertEquals("blcOperators_Numeric", getResult2.getOperators());
    assertEquals("blcOperators_Numeric", getResult3.getOperators());
    assertEquals("blcOperators_Text", getResult.getOperators());
    assertEquals("blcOperators_Text", getResult4.getOperators());
    assertEquals("blcOperators_Text", getResult5.getOperators());
    assertEquals("blcOperators_Text", getResult6.getOperators());
    assertEquals("category.url", getResult4.getFieldName());
    assertEquals("name", getResult.getFieldName());
    assertEquals("price", getResult2.getFieldName());
    assertEquals("product.manufacturer", getResult5.getFieldName());
    assertEquals("quantity", getResult3.getFieldName());
    assertEquals("rule_orderItemCategoryUrl", getResult4.getFieldLabel());
    assertEquals("rule_orderItemName", getResult.getFieldLabel());
    assertEquals("rule_orderItemPrice", getResult2.getFieldLabel());
    assertEquals("rule_orderItemProductManufacturer", getResult5.getFieldLabel());
    assertEquals("rule_orderItemQuantity", getResult3.getFieldLabel());
    assertEquals("rule_orderItemSkuLongDescription", getResult6.getFieldLabel());
    assertEquals("sku.longDescription", getResult6.getFieldName());
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
    assertEquals(SupportedFieldType.INTEGER, getResult3.getFieldType());
    assertEquals(SupportedFieldType.MONEY, getResult2.getFieldType());
    assertEquals(SupportedFieldType.STRING, getResult.getFieldType());
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
   * Test {@link OrderItemFieldServiceImpl#init()}.
   * <ul>
   *   <li>Given {@link OrderItemFieldServiceImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderItemFieldServiceImpl#init()}
   */
  @Test
  public void testInit_givenOrderItemFieldServiceImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderItemFieldServiceImpl orderItemFieldServiceImpl = new OrderItemFieldServiceImpl();

    // Act
    orderItemFieldServiceImpl.init();

    // Assert
    List<FieldData> fields = orderItemFieldServiceImpl.getFields();
    assertEquals(7, fields.size());
    FieldData getResult = fields.get(0);
    assertEquals("[]", getResult.getOptions());
    FieldData getResult2 = fields.get(1);
    assertEquals("[]", getResult2.getOptions());
    FieldData getResult3 = fields.get(2);
    assertEquals("[]", getResult3.getOptions());
    FieldData getResult4 = fields.get(4);
    assertEquals("[]", getResult4.getOptions());
    FieldData getResult5 = fields.get(5);
    assertEquals("[]", getResult5.getOptions());
    FieldData getResult6 = fields.get(6);
    assertEquals("[]", getResult6.getOptions());
    assertEquals("blcOperators_Numeric", getResult2.getOperators());
    assertEquals("blcOperators_Numeric", getResult3.getOperators());
    assertEquals("blcOperators_Text", getResult.getOperators());
    assertEquals("blcOperators_Text", getResult4.getOperators());
    assertEquals("blcOperators_Text", getResult5.getOperators());
    assertEquals("blcOperators_Text", getResult6.getOperators());
    assertEquals("category.url", getResult4.getFieldName());
    assertEquals("name", getResult.getFieldName());
    assertEquals("price", getResult2.getFieldName());
    assertEquals("product.manufacturer", getResult5.getFieldName());
    assertEquals("quantity", getResult3.getFieldName());
    assertEquals("rule_orderItemCategoryUrl", getResult4.getFieldLabel());
    assertEquals("rule_orderItemName", getResult.getFieldLabel());
    assertEquals("rule_orderItemPrice", getResult2.getFieldLabel());
    assertEquals("rule_orderItemProductManufacturer", getResult5.getFieldLabel());
    assertEquals("rule_orderItemQuantity", getResult3.getFieldLabel());
    assertEquals("rule_orderItemSkuLongDescription", getResult6.getFieldLabel());
    assertEquals("sku.longDescription", getResult6.getFieldName());
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
    assertEquals(SupportedFieldType.INTEGER, getResult3.getFieldType());
    assertEquals(SupportedFieldType.MONEY, getResult2.getFieldType());
    assertEquals(SupportedFieldType.STRING, getResult.getFieldType());
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
   *   <li>{@link OrderItemFieldServiceImpl#getDtoClassName()}
   *   <li>{@link OrderItemFieldServiceImpl#getName()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    OrderItemFieldServiceImpl orderItemFieldServiceImpl = new OrderItemFieldServiceImpl();

    // Act
    String actualDtoClassName = orderItemFieldServiceImpl.getDtoClassName();

    // Assert
    assertEquals("ORDER_ITEM_FIELDS", orderItemFieldServiceImpl.getName());
    assertEquals("org.broadleafcommerce.core.order.domain.OrderItemImpl", actualDtoClassName);
  }
}
