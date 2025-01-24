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
public class LocaleFieldServiceImplDiffblueTest {
  @Autowired
  private LocaleFieldServiceImpl localeFieldServiceImpl;

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
   * <p>
   * Method under test: {@link LocaleFieldServiceImpl#init()}
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
    //   public class DiffblueFakeClass5 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.admin.web.rulebuilder.service.LocaleFieldServiceImpl localeFieldServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new LocaleFieldServiceImpl()).init();
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
