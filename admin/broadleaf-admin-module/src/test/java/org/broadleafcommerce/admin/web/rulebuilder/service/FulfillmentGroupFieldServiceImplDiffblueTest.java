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
public class FulfillmentGroupFieldServiceImplDiffblueTest {
  @Autowired
  private FulfillmentGroupFieldServiceImpl fulfillmentGroupFieldServiceImpl;

  /**
   * Test {@link FulfillmentGroupFieldServiceImpl#init()}.
   * <p>
   * Method under test: {@link FulfillmentGroupFieldServiceImpl#init()}
   */
  @Test
  public void testInit() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupFieldServiceImpl fulfillmentGroupFieldServiceImpl = new FulfillmentGroupFieldServiceImpl();
    fulfillmentGroupFieldServiceImpl
        .setRuleBuilderFieldServiceExtensionManager(mock(RuleBuilderFieldServiceExtensionManager.class));

    // Act
    fulfillmentGroupFieldServiceImpl.init();

    // Assert
    List<FieldData> fields = fulfillmentGroupFieldServiceImpl.getFields();
    assertEquals(19, fields.size());
    FieldData getResult = fields.get(0);
    assertEquals("[]", getResult.getOptions());
    FieldData getResult2 = fields.get(1);
    assertEquals("[]", getResult2.getOptions());
    FieldData getResult3 = fields.get(17);
    assertEquals("[]", getResult3.getOptions());
    FieldData getResult4 = fields.get(18);
    assertEquals("[]", getResult4.getOptions());
    FieldData getResult5 = fields.get(2);
    assertEquals("[]", getResult5.getOptions());
    assertEquals("address.addressLine1", getResult5.getFieldName());
    assertEquals("address.firstName", getResult.getFieldName());
    assertEquals("address.lastName", getResult2.getFieldName());
    FieldData getResult6 = fields.get(Short.SIZE);
    assertEquals("blcOperators_Enumeration", getResult6.getOperators());
    assertEquals("blcOperators_Numeric", getResult3.getOperators());
    assertEquals("blcOperators_Text", getResult.getOperators());
    assertEquals("blcOperators_Text", getResult2.getOperators());
    assertEquals("blcOperators_Text", getResult4.getOperators());
    assertEquals("blcOperators_Text", getResult5.getOperators());
    assertEquals("blcOptions_FulfillmentType", getResult6.getOptions());
    assertEquals("fulfillmentOption.name", getResult4.getFieldName());
    assertEquals("merchandiseTotal", getResult3.getFieldName());
    assertEquals("rule_fulfillmentGroupAddresLine1", getResult5.getFieldLabel());
    assertEquals("rule_fulfillmentGroupFirstName", getResult.getFieldLabel());
    assertEquals("rule_fulfillmentGroupFulfillmentOption", getResult4.getFieldLabel());
    assertEquals("rule_fulfillmentGroupLastName", getResult2.getFieldLabel());
    assertEquals("rule_fulfillmentGroupMerchandiseTotal", getResult3.getFieldLabel());
    assertEquals("rule_fulfillmentGroupType", getResult6.getFieldLabel());
    assertEquals("type", getResult6.getFieldName());
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
    assertEquals(SupportedFieldType.BROADLEAF_ENUMERATION, getResult6.getFieldType());
    assertEquals(SupportedFieldType.MONEY, getResult3.getFieldType());
    assertEquals(SupportedFieldType.STRING, getResult.getFieldType());
    assertEquals(SupportedFieldType.STRING, getResult2.getFieldType());
    assertEquals(SupportedFieldType.STRING, getResult4.getFieldType());
    assertEquals(SupportedFieldType.STRING, getResult5.getFieldType());
    assertFalse(getResult.getSkipValidation());
    assertFalse(getResult2.getSkipValidation());
    assertFalse(getResult3.getSkipValidation());
    assertFalse(getResult4.getSkipValidation());
    assertFalse(getResult5.getSkipValidation());
    assertFalse(getResult6.getSkipValidation());
  }

  /**
   * Test {@link FulfillmentGroupFieldServiceImpl#init()}.
   * <p>
   * Method under test: {@link FulfillmentGroupFieldServiceImpl#init()}
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
    //   public class DiffblueFakeClass0 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.admin.web.rulebuilder.service.FulfillmentGroupFieldServiceImpl fulfillmentGroupFieldServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new FulfillmentGroupFieldServiceImpl()).init();
  }

  /**
   * Test {@link FulfillmentGroupFieldServiceImpl#init()}.
   * <ul>
   *   <li>Given {@link FulfillmentGroupFieldServiceImpl} (default
   * constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentGroupFieldServiceImpl#init()}
   */
  @Test
  public void testInit_givenFulfillmentGroupFieldServiceImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupFieldServiceImpl fulfillmentGroupFieldServiceImpl = new FulfillmentGroupFieldServiceImpl();

    // Act
    fulfillmentGroupFieldServiceImpl.init();

    // Assert
    List<FieldData> fields = fulfillmentGroupFieldServiceImpl.getFields();
    assertEquals(19, fields.size());
    FieldData getResult = fields.get(0);
    assertEquals("[]", getResult.getOptions());
    FieldData getResult2 = fields.get(1);
    assertEquals("[]", getResult2.getOptions());
    FieldData getResult3 = fields.get(17);
    assertEquals("[]", getResult3.getOptions());
    FieldData getResult4 = fields.get(18);
    assertEquals("[]", getResult4.getOptions());
    FieldData getResult5 = fields.get(2);
    assertEquals("[]", getResult5.getOptions());
    assertEquals("address.addressLine1", getResult5.getFieldName());
    assertEquals("address.firstName", getResult.getFieldName());
    assertEquals("address.lastName", getResult2.getFieldName());
    FieldData getResult6 = fields.get(Short.SIZE);
    assertEquals("blcOperators_Enumeration", getResult6.getOperators());
    assertEquals("blcOperators_Numeric", getResult3.getOperators());
    assertEquals("blcOperators_Text", getResult.getOperators());
    assertEquals("blcOperators_Text", getResult2.getOperators());
    assertEquals("blcOperators_Text", getResult4.getOperators());
    assertEquals("blcOperators_Text", getResult5.getOperators());
    assertEquals("blcOptions_FulfillmentType", getResult6.getOptions());
    assertEquals("fulfillmentOption.name", getResult4.getFieldName());
    assertEquals("merchandiseTotal", getResult3.getFieldName());
    assertEquals("rule_fulfillmentGroupAddresLine1", getResult5.getFieldLabel());
    assertEquals("rule_fulfillmentGroupFirstName", getResult.getFieldLabel());
    assertEquals("rule_fulfillmentGroupFulfillmentOption", getResult4.getFieldLabel());
    assertEquals("rule_fulfillmentGroupLastName", getResult2.getFieldLabel());
    assertEquals("rule_fulfillmentGroupMerchandiseTotal", getResult3.getFieldLabel());
    assertEquals("rule_fulfillmentGroupType", getResult6.getFieldLabel());
    assertEquals("type", getResult6.getFieldName());
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
    assertEquals(SupportedFieldType.BROADLEAF_ENUMERATION, getResult6.getFieldType());
    assertEquals(SupportedFieldType.MONEY, getResult3.getFieldType());
    assertEquals(SupportedFieldType.STRING, getResult.getFieldType());
    assertEquals(SupportedFieldType.STRING, getResult2.getFieldType());
    assertEquals(SupportedFieldType.STRING, getResult4.getFieldType());
    assertEquals(SupportedFieldType.STRING, getResult5.getFieldType());
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
   *   <li>{@link FulfillmentGroupFieldServiceImpl#getDtoClassName()}
   *   <li>{@link FulfillmentGroupFieldServiceImpl#getName()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    FulfillmentGroupFieldServiceImpl fulfillmentGroupFieldServiceImpl = new FulfillmentGroupFieldServiceImpl();

    // Act
    String actualDtoClassName = fulfillmentGroupFieldServiceImpl.getDtoClassName();

    // Assert
    assertEquals("FULFILLMENT_GROUP_FIELDS", fulfillmentGroupFieldServiceImpl.getName());
    assertEquals("org.broadleafcommerce.core.order.domain.FulfillmentGroupImpl", actualDtoClassName);
  }
}
