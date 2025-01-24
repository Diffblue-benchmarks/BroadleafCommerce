package org.broadleafcommerce.core.web.linkeddata.generator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml",
    "/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml",
    "/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
@ExtendWith(SpringExtension.class)
class DefaultLinkedDataGeneratorExtensionHandlerDiffblueTest {
  @Autowired
  private DefaultLinkedDataGeneratorExtensionHandler defaultLinkedDataGeneratorExtensionHandler;

  /**
   * Test {@link DefaultLinkedDataGeneratorExtensionHandler#init()}.
   * <p>
   * Method under test: {@link DefaultLinkedDataGeneratorExtensionHandler#init()}
   */
  @Test
  @DisplayName("Test init()")
  @Disabled("TODO: Complete this test")
  void testInit() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.linkeddata.generator;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml","/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3969 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.linkeddata.generator.DefaultLinkedDataGeneratorExtensionHandler defaultLinkedDataGeneratorExtensionHandler;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new DefaultLinkedDataGeneratorExtensionHandler()).init();
  }

  /**
   * Test {@link DefaultLinkedDataGeneratorExtensionHandler#getPriority()}.
   * <p>
   * Method under test:
   * {@link DefaultLinkedDataGeneratorExtensionHandler#getPriority()}
   */
  @Test
  @DisplayName("Test getPriority()")
  void testGetPriority() {
    // Arrange, Act and Assert
    assertEquals(Integer.MAX_VALUE, (new DefaultLinkedDataGeneratorExtensionHandler()).getPriority());
  }
}
