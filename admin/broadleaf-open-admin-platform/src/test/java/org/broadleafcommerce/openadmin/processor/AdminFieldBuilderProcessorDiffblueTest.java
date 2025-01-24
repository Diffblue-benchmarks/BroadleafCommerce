package org.broadleafcommerce.openadmin.processor;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.mock;
import java.util.HashMap;
import java.util.Map;
import org.broadleafcommerce.presentation.model.BroadleafTemplateContext;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml",
    "/bl-open-admin-applicationContext-entity.xml", "/bl-open-admin-contentClient-applicationContext.xml",
    "/bl-open-admin-contentCreator-applicationContext.xml",
    "/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml",
    "/blc-config/admin/framework/bl-open-admin-applicationContext.xml",
    "/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class AdminFieldBuilderProcessorDiffblueTest {
  @Autowired
  private AdminFieldBuilderProcessor adminFieldBuilderProcessor;

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AdminFieldBuilderProcessor#getName()}
   *   <li>{@link AdminFieldBuilderProcessor#getPrefix()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    AdminFieldBuilderProcessor adminFieldBuilderProcessor = new AdminFieldBuilderProcessor();

    // Act
    String actualName = adminFieldBuilderProcessor.getName();

    // Assert
    assertEquals("admin_field_builder", actualName);
    assertEquals("blc_admin", adminFieldBuilderProcessor.getPrefix());
  }

  /**
   * Test {@link AdminFieldBuilderProcessor#getPrecedence()}.
   * <p>
   * Method under test: {@link AdminFieldBuilderProcessor#getPrecedence()}
   */
  @Test
  public void testGetPrecedence() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals(100, (new AdminFieldBuilderProcessor()).getPrecedence());
  }

  /**
   * Test {@link AdminFieldBuilderProcessor#getPrecedence()}.
   * <p>
   * Method under test: {@link AdminFieldBuilderProcessor#getPrecedence()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetPrecedence2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.processor;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass5962 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.processor.AdminFieldBuilderProcessor adminFieldBuilderProcessor;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new AdminFieldBuilderProcessor()).getPrecedence();
  }

  /**
   * Test
   * {@link AdminFieldBuilderProcessor#populateModelVariables(String, Map, BroadleafTemplateContext)}.
   * <p>
   * Method under test:
   * {@link AdminFieldBuilderProcessor#populateModelVariables(String, Map, BroadleafTemplateContext)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testPopulateModelVariables() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.processor;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass5963 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.processor.AdminFieldBuilderProcessor adminFieldBuilderProcessor;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    AdminFieldBuilderProcessor adminFieldBuilderProcessor2 = new AdminFieldBuilderProcessor();

    // Act
    adminFieldBuilderProcessor2.populateModelVariables("Tag Name", new HashMap<>(),
        mock(BroadleafTemplateContext.class));
  }

  /**
   * Test {@link AdminFieldBuilderProcessor#useGlobalScope()}.
   * <p>
   * Method under test: {@link AdminFieldBuilderProcessor#useGlobalScope()}
   */
  @Test
  public void testUseGlobalScope() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new AdminFieldBuilderProcessor()).useGlobalScope());
  }

  /**
   * Test {@link AdminFieldBuilderProcessor#useGlobalScope()}.
   * <p>
   * Method under test: {@link AdminFieldBuilderProcessor#useGlobalScope()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testUseGlobalScope2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.processor;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass5973 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.processor.AdminFieldBuilderProcessor adminFieldBuilderProcessor;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new AdminFieldBuilderProcessor()).useGlobalScope();
  }
}
