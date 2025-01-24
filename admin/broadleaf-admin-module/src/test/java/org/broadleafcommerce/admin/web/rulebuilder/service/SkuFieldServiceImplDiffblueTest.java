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
public class SkuFieldServiceImplDiffblueTest {
  @Autowired
  private SkuFieldServiceImpl skuFieldServiceImpl;

  /**
   * Test {@link SkuFieldServiceImpl#init()}.
   * <p>
   * Method under test: {@link SkuFieldServiceImpl#init()}
   */
  @Test
  public void testInit() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuFieldServiceImpl skuFieldServiceImpl = new SkuFieldServiceImpl();
    skuFieldServiceImpl.setRuleBuilderFieldServiceExtensionManager(mock(RuleBuilderFieldServiceExtensionManager.class));

    // Act
    skuFieldServiceImpl.init();

    // Assert
    List<FieldData> fields = skuFieldServiceImpl.getFields();
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
    assertEquals("blcOperators_Selectize", getResult.getOperators());
    assertEquals("blcOperators_Selectize", getResult5.getOperators());
    assertEquals("blcOperators_Text", getResult2.getOperators());
    assertEquals("blcOperators_Text", getResult3.getOperators());
    assertEquals("blcOperators_Text", getResult4.getOperators());
    assertEquals("category", getResult5.getSelectizeSectionKey());
    assertEquals("longDescription", getResult2.getFieldName());
    assertEquals("name", getResult.getFieldName());
    assertEquals("product", getResult.getSelectizeSectionKey());
    assertEquals("product.allParentCategoryIds", getResult5.getFieldName());
    assertEquals("product.manufacturer", getResult4.getFieldName());
    assertEquals("product.url", getResult3.getFieldName());
    assertEquals("rule_productCategory", getResult5.getFieldLabel());
    assertEquals("rule_skuLongDescription", getResult2.getFieldLabel());
    assertEquals("rule_skuName", getResult.getFieldLabel());
    assertEquals("rule_skuProductManufacturer", getResult4.getFieldLabel());
    assertEquals("rule_skuProductUrl", getResult3.getFieldLabel());
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
   * Test {@link SkuFieldServiceImpl#init()}.
   * <p>
   * Method under test: {@link SkuFieldServiceImpl#init()}
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
    //   public class DiffblueFakeClass30 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.admin.web.rulebuilder.service.SkuFieldServiceImpl skuFieldServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new SkuFieldServiceImpl()).init();
  }

  /**
   * Test {@link SkuFieldServiceImpl#init()}.
   * <ul>
   *   <li>Given {@link SkuFieldServiceImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuFieldServiceImpl#init()}
   */
  @Test
  public void testInit_givenSkuFieldServiceImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuFieldServiceImpl skuFieldServiceImpl = new SkuFieldServiceImpl();

    // Act
    skuFieldServiceImpl.init();

    // Assert
    List<FieldData> fields = skuFieldServiceImpl.getFields();
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
    assertEquals("blcOperators_Selectize", getResult.getOperators());
    assertEquals("blcOperators_Selectize", getResult5.getOperators());
    assertEquals("blcOperators_Text", getResult2.getOperators());
    assertEquals("blcOperators_Text", getResult3.getOperators());
    assertEquals("blcOperators_Text", getResult4.getOperators());
    assertEquals("category", getResult5.getSelectizeSectionKey());
    assertEquals("longDescription", getResult2.getFieldName());
    assertEquals("name", getResult.getFieldName());
    assertEquals("product", getResult.getSelectizeSectionKey());
    assertEquals("product.allParentCategoryIds", getResult5.getFieldName());
    assertEquals("product.manufacturer", getResult4.getFieldName());
    assertEquals("product.url", getResult3.getFieldName());
    assertEquals("rule_productCategory", getResult5.getFieldLabel());
    assertEquals("rule_skuLongDescription", getResult2.getFieldLabel());
    assertEquals("rule_skuName", getResult.getFieldLabel());
    assertEquals("rule_skuProductManufacturer", getResult4.getFieldLabel());
    assertEquals("rule_skuProductUrl", getResult3.getFieldLabel());
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
   *   <li>{@link SkuFieldServiceImpl#getDtoClassName()}
   *   <li>{@link SkuFieldServiceImpl#getName()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    SkuFieldServiceImpl skuFieldServiceImpl = new SkuFieldServiceImpl();

    // Act
    String actualDtoClassName = skuFieldServiceImpl.getDtoClassName();

    // Assert
    assertEquals("SKU_FIELDS", skuFieldServiceImpl.getName());
    assertEquals("org.broadleafcommerce.core.catalog.domain.SkuImpl", actualDtoClassName);
  }
}
