package org.broadleafcommerce.admin.web.controller.extension;

import org.broadleafcommerce.openadmin.web.form.TranslationForm;
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
public class AdminProductTranslationExtensionHandlerDiffblueTest {
  @Autowired
  private AdminProductTranslationExtensionHandler adminProductTranslationExtensionHandler;

  /**
   * Test {@link AdminProductTranslationExtensionHandler#init()}.
   * <p>
   * Method under test: {@link AdminProductTranslationExtensionHandler#init()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testInit() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.admin.web.controller.extension;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-admin-applicationContext-servlet.xml","/bl-admin-applicationContext.xml","/blc-config/admin/framework/bl-admin-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-admin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass525 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.admin.web.controller.extension.AdminProductTranslationExtensionHandler adminProductTranslationExtensionHandler;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new AdminProductTranslationExtensionHandler()).init();
  }

  /**
   * Test {@link AdminProductTranslationExtensionHandler#getTranslationEnabled()}.
   * <p>
   * Method under test:
   * {@link AdminProductTranslationExtensionHandler#getTranslationEnabled()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetTranslationEnabled() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.admin.web.controller.extension;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-admin-applicationContext-servlet.xml","/bl-admin-applicationContext.xml","/blc-config/admin/framework/bl-admin-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-admin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass522 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.admin.web.controller.extension.AdminProductTranslationExtensionHandler adminProductTranslationExtensionHandler;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new AdminProductTranslationExtensionHandler()).getTranslationEnabled();
  }

  /**
   * Test
   * {@link AdminProductTranslationExtensionHandler#applyTransformation(TranslationForm)}.
   * <p>
   * Method under test:
   * {@link AdminProductTranslationExtensionHandler#applyTransformation(TranslationForm)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testApplyTransformation() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.admin.web.controller.extension;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-admin-applicationContext-servlet.xml","/bl-admin-applicationContext.xml","/blc-config/admin/framework/bl-admin-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-admin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass393 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.admin.web.controller.extension.AdminProductTranslationExtensionHandler adminProductTranslationExtensionHandler;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    AdminProductTranslationExtensionHandler adminProductTranslationExtensionHandler2 = new AdminProductTranslationExtensionHandler();

    TranslationForm form = new TranslationForm();
    form.setCeilingEntity("Ceiling Entity");
    form.setEntityId("42");
    form.setFieldType("Field Type");
    form.setIsRte(true);
    form.setLocaleCode("en");
    form.setPropertyName("Property Name");
    form.setTranslatedValue("42");
    form.setTranslationId(1L);

    // Act
    adminProductTranslationExtensionHandler2.applyTransformation(form);
  }
}
