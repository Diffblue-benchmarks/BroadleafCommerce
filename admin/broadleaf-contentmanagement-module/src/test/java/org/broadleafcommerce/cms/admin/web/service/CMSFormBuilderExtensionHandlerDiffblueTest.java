package org.broadleafcommerce.cms.admin.web.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.broadleafcommerce.common.extension.ExtensionResultStatusType;
import org.broadleafcommerce.openadmin.web.form.entity.EntityForm;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = {"/applicationContext-servlet-cms-contentClient.xml",
    "/applicationContext-servlet-cms-contentCreator.xml", "/bl-cms-applicationContext-entity.xml",
    "/bl-cms-contentClient-applicationContext.xml", "/bl-cms-contentCreator-applicationContext.xml",
    "/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml",
    "/blc-config/admin/framework/bl-cms-admin-applicationContext.xml",
    "/blc-config/site/framework/bl-cms-applicationContext-servlet.xml",
    "/blc-config/site/framework/bl-cms-applicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class CMSFormBuilderExtensionHandlerDiffblueTest {
  @Autowired
  private CMSFormBuilderExtensionHandler cMSFormBuilderExtensionHandler;

  /**
   * Test {@link CMSFormBuilderExtensionHandler#init()}.
   * <p>
   * Method under test: {@link CMSFormBuilderExtensionHandler#init()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testInit() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.cms.admin.web.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-cms-contentClient.xml","/applicationContext-servlet-cms-contentCreator.xml","/bl-cms-applicationContext-entity.xml","/bl-cms-contentClient-applicationContext.xml","/bl-cms-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext.xml","/blc-config/site/framework/bl-cms-applicationContext-servlet.xml","/blc-config/site/framework/bl-cms-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3853 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.cms.admin.web.service.CMSFormBuilderExtensionHandler cMSFormBuilderExtensionHandler;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new CMSFormBuilderExtensionHandler()).init();
  }

  /**
   * Test
   * {@link CMSFormBuilderExtensionHandler#modifyDetailEntityForm(EntityForm)}.
   * <p>
   * Method under test:
   * {@link CMSFormBuilderExtensionHandler#modifyDetailEntityForm(EntityForm)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testModifyDetailEntityForm() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.cms.admin.web.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-cms-contentClient.xml","/applicationContext-servlet-cms-contentCreator.xml","/bl-cms-applicationContext-entity.xml","/bl-cms-contentClient-applicationContext.xml","/bl-cms-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext.xml","/blc-config/site/framework/bl-cms-applicationContext-servlet.xml","/blc-config/site/framework/bl-cms-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3856 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.cms.admin.web.service.CMSFormBuilderExtensionHandler cMSFormBuilderExtensionHandler;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    CMSFormBuilderExtensionHandler cmsFormBuilderExtensionHandler = new CMSFormBuilderExtensionHandler();

    // Act
    cmsFormBuilderExtensionHandler.modifyDetailEntityForm(new EntityForm());
  }

  /**
   * Test
   * {@link CMSFormBuilderExtensionHandler#modifyDetailEntityForm(EntityForm)}.
   * <ul>
   *   <li>Given {@code Ceiling Entity Classname}.</li>
   *   <li>Then return {@code NOT_HANDLED}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CMSFormBuilderExtensionHandler#modifyDetailEntityForm(EntityForm)}
   */
  @Test
  public void testModifyDetailEntityForm_givenCeilingEntityClassname_thenReturnNotHandled() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CMSFormBuilderExtensionHandler cmsFormBuilderExtensionHandler = new CMSFormBuilderExtensionHandler();
    EntityForm ef = mock(EntityForm.class);
    when(ef.getCeilingEntityClassname()).thenReturn("Ceiling Entity Classname");

    // Act
    ExtensionResultStatusType actualModifyDetailEntityFormResult = cmsFormBuilderExtensionHandler
        .modifyDetailEntityForm(ef);

    // Assert
    verify(ef).getCeilingEntityClassname();
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, actualModifyDetailEntityFormResult);
  }
}
