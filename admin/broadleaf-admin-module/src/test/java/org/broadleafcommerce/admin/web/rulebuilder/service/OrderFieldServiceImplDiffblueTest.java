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
public class OrderFieldServiceImplDiffblueTest {
  @Autowired
  private OrderFieldServiceImpl orderFieldServiceImpl;

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
   * <p>
   * Method under test: {@link OrderFieldServiceImpl#init()}
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
    //   public class DiffblueFakeClass10 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.admin.web.rulebuilder.service.OrderFieldServiceImpl orderFieldServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new OrderFieldServiceImpl()).init();
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
