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

public class ProductFieldServiceImplDiffblueTest {
  /**
   * Test {@link ProductFieldServiceImpl#init()}.
   * <p>
   * Method under test: {@link ProductFieldServiceImpl#init()}
   */
  @Test
  public void testInit() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductFieldServiceImpl productFieldServiceImpl = new ProductFieldServiceImpl();
    productFieldServiceImpl
        .setRuleBuilderFieldServiceExtensionManager(mock(RuleBuilderFieldServiceExtensionManager.class));

    // Act
    productFieldServiceImpl.init();

    // Assert
    List<FieldData> fields = productFieldServiceImpl.getFields();
    assertEquals(5, fields.size());
    FieldData getResult = fields.get(0);
    assertEquals("[]", getResult.getOptions());
    FieldData getResult2 = fields.get(1);
    assertEquals("[]", getResult2.getOptions());
    FieldData getResult3 = fields.get(2);
    assertEquals("[]", getResult3.getOptions());
    FieldData getResult4 = fields.get(3);
    assertEquals("[]", getResult4.getOptions());
    FieldData getResult5 = fields.get(4);
    assertEquals("[]", getResult5.getOptions());
    assertEquals("allParentCategoryIds", getResult5.getFieldName());
    assertEquals("blcOperators_Selectize", getResult5.getOperators());
    assertEquals("blcOperators_Text", getResult.getOperators());
    assertEquals("blcOperators_Text", getResult2.getOperators());
    assertEquals("blcOperators_Text", getResult3.getOperators());
    assertEquals("blcOperators_Text", getResult4.getOperators());
    assertEquals("category", getResult5.getSelectizeSectionKey());
    assertEquals("defaultSku.longDescription", getResult4.getFieldName());
    assertEquals("defaultSku.name", getResult3.getFieldName());
    assertEquals("manufacturer", getResult2.getFieldName());
    assertEquals("rule_productCategory", getResult5.getFieldLabel());
    assertEquals("rule_productManufacturer", getResult2.getFieldLabel());
    assertEquals("rule_productSkuLongDescription", getResult4.getFieldLabel());
    assertEquals("rule_productSkuName", getResult3.getFieldLabel());
    assertEquals("rule_productUrl", getResult.getFieldLabel());
    assertEquals("url", getResult.getFieldName());
    assertNull(getResult.getOverrideDtoClassName());
    assertNull(getResult2.getOverrideDtoClassName());
    assertNull(getResult3.getOverrideDtoClassName());
    assertNull(getResult4.getOverrideDtoClassName());
    assertNull(getResult5.getOverrideDtoClassName());
    assertNull(getResult.getOverrideEntityKey());
    assertNull(getResult2.getOverrideEntityKey());
    assertNull(getResult3.getOverrideEntityKey());
    assertNull(getResult4.getOverrideEntityKey());
    assertNull(getResult5.getOverrideEntityKey());
    assertNull(getResult.getSelectizeSectionKey());
    assertNull(getResult2.getSelectizeSectionKey());
    assertNull(getResult3.getSelectizeSectionKey());
    assertNull(getResult4.getSelectizeSectionKey());
    assertNull(getResult.getSecondaryFieldType());
    assertNull(getResult2.getSecondaryFieldType());
    assertNull(getResult3.getSecondaryFieldType());
    assertNull(getResult4.getSecondaryFieldType());
    assertNull(getResult5.getSecondaryFieldType());
    assertEquals(SupportedFieldType.COLLECTION, getResult5.getFieldType());
    assertEquals(SupportedFieldType.STRING, getResult.getFieldType());
    assertEquals(SupportedFieldType.STRING, getResult2.getFieldType());
    assertEquals(SupportedFieldType.STRING, getResult3.getFieldType());
    assertEquals(SupportedFieldType.STRING, getResult4.getFieldType());
    assertFalse(getResult.getSkipValidation());
    assertFalse(getResult2.getSkipValidation());
    assertFalse(getResult3.getSkipValidation());
    assertFalse(getResult4.getSkipValidation());
    assertFalse(getResult5.getSkipValidation());
  }

  /**
   * Test {@link ProductFieldServiceImpl#init()}.
   * <ul>
   *   <li>Given {@link ProductFieldServiceImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductFieldServiceImpl#init()}
   */
  @Test
  public void testInit_givenProductFieldServiceImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductFieldServiceImpl productFieldServiceImpl = new ProductFieldServiceImpl();

    // Act
    productFieldServiceImpl.init();

    // Assert
    List<FieldData> fields = productFieldServiceImpl.getFields();
    assertEquals(5, fields.size());
    FieldData getResult = fields.get(0);
    assertEquals("[]", getResult.getOptions());
    FieldData getResult2 = fields.get(1);
    assertEquals("[]", getResult2.getOptions());
    FieldData getResult3 = fields.get(2);
    assertEquals("[]", getResult3.getOptions());
    FieldData getResult4 = fields.get(3);
    assertEquals("[]", getResult4.getOptions());
    FieldData getResult5 = fields.get(4);
    assertEquals("[]", getResult5.getOptions());
    assertEquals("allParentCategoryIds", getResult5.getFieldName());
    assertEquals("blcOperators_Selectize", getResult5.getOperators());
    assertEquals("blcOperators_Text", getResult.getOperators());
    assertEquals("blcOperators_Text", getResult2.getOperators());
    assertEquals("blcOperators_Text", getResult3.getOperators());
    assertEquals("blcOperators_Text", getResult4.getOperators());
    assertEquals("category", getResult5.getSelectizeSectionKey());
    assertEquals("defaultSku.longDescription", getResult4.getFieldName());
    assertEquals("defaultSku.name", getResult3.getFieldName());
    assertEquals("manufacturer", getResult2.getFieldName());
    assertEquals("rule_productCategory", getResult5.getFieldLabel());
    assertEquals("rule_productManufacturer", getResult2.getFieldLabel());
    assertEquals("rule_productSkuLongDescription", getResult4.getFieldLabel());
    assertEquals("rule_productSkuName", getResult3.getFieldLabel());
    assertEquals("rule_productUrl", getResult.getFieldLabel());
    assertEquals("url", getResult.getFieldName());
    assertNull(getResult.getOverrideDtoClassName());
    assertNull(getResult2.getOverrideDtoClassName());
    assertNull(getResult3.getOverrideDtoClassName());
    assertNull(getResult4.getOverrideDtoClassName());
    assertNull(getResult5.getOverrideDtoClassName());
    assertNull(getResult.getOverrideEntityKey());
    assertNull(getResult2.getOverrideEntityKey());
    assertNull(getResult3.getOverrideEntityKey());
    assertNull(getResult4.getOverrideEntityKey());
    assertNull(getResult5.getOverrideEntityKey());
    assertNull(getResult.getSelectizeSectionKey());
    assertNull(getResult2.getSelectizeSectionKey());
    assertNull(getResult3.getSelectizeSectionKey());
    assertNull(getResult4.getSelectizeSectionKey());
    assertNull(getResult.getSecondaryFieldType());
    assertNull(getResult2.getSecondaryFieldType());
    assertNull(getResult3.getSecondaryFieldType());
    assertNull(getResult4.getSecondaryFieldType());
    assertNull(getResult5.getSecondaryFieldType());
    assertEquals(SupportedFieldType.COLLECTION, getResult5.getFieldType());
    assertEquals(SupportedFieldType.STRING, getResult.getFieldType());
    assertEquals(SupportedFieldType.STRING, getResult2.getFieldType());
    assertEquals(SupportedFieldType.STRING, getResult3.getFieldType());
    assertEquals(SupportedFieldType.STRING, getResult4.getFieldType());
    assertFalse(getResult.getSkipValidation());
    assertFalse(getResult2.getSkipValidation());
    assertFalse(getResult3.getSkipValidation());
    assertFalse(getResult4.getSkipValidation());
    assertFalse(getResult5.getSkipValidation());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ProductFieldServiceImpl#getDtoClassName()}
   *   <li>{@link ProductFieldServiceImpl#getName()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    ProductFieldServiceImpl productFieldServiceImpl = new ProductFieldServiceImpl();

    // Act
    String actualDtoClassName = productFieldServiceImpl.getDtoClassName();

    // Assert
    assertEquals("PRODUCT_FIELDS", productFieldServiceImpl.getName());
    assertEquals("org.broadleafcommerce.core.catalog.domain.ProductImpl", actualDtoClassName);
  }
}
