package org.broadleafcommerce.admin.web.rulebuilder.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.mock;
import java.util.List;
import org.broadleafcommerce.common.presentation.client.SupportedFieldType;
import org.broadleafcommerce.openadmin.web.rulebuilder.dto.FieldData;
import org.broadleafcommerce.openadmin.web.rulebuilder.service.RuleBuilderFieldServiceExtensionManager;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = {"/bl-admin-applicationContext-servlet.xml", "/bl-admin-applicationContext.xml",
    "/blc-config/admin/framework/bl-admin-admin-applicationContext-servlet.xml",
    "/blc-config/admin/framework/bl-admin-applicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class OrderItemFieldServiceImplDiffblueTest {
  @Autowired
  private OrderItemFieldServiceImpl orderItemFieldServiceImpl;

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
   * <p>
   * Method under test: {@link OrderItemFieldServiceImpl#init()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testInit2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.admin.web.rulebuilder.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-admin-applicationContext-servlet.xml","/bl-admin-applicationContext.xml","/blc-config/admin/framework/bl-admin-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-admin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass15 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.admin.web.rulebuilder.service.OrderItemFieldServiceImpl orderItemFieldServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new OrderItemFieldServiceImpl()).init();
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
