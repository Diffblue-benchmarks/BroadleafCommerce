package org.broadleafcommerce.core.web.processor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import java.util.HashMap;
import java.util.Map;
import org.broadleafcommerce.presentation.model.BroadleafTemplateContext;
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
class PaginationPageLinkProcessorDiffblueTest {
  @Autowired
  private PaginationPageLinkProcessor paginationPageLinkProcessor;

  /**
   * Test {@link PaginationPageLinkProcessor#getName()}.
   * <p>
   * Method under test: {@link PaginationPageLinkProcessor#getName()}
   */
  @Test
  @DisplayName("Test getName()")
  void testGetName() {
    // Arrange, Act and Assert
    assertEquals("paginationpagelink", (new PaginationPageLinkProcessor()).getName());
  }

  /**
   * Test {@link PaginationPageLinkProcessor#getPrecedence()}.
   * <p>
   * Method under test: {@link PaginationPageLinkProcessor#getPrecedence()}
   */
  @Test
  @DisplayName("Test getPrecedence()")
  void testGetPrecedence() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals(10000, (new PaginationPageLinkProcessor()).getPrecedence());
  }

  /**
   * Test {@link PaginationPageLinkProcessor#getPrecedence()}.
   * <p>
   * Method under test: {@link PaginationPageLinkProcessor#getPrecedence()}
   */
  @Test
  @DisplayName("Test getPrecedence()")
  @Disabled("TODO: Complete this test")
  void testGetPrecedence2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.processor;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml","/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass11282 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.processor.PaginationPageLinkProcessor paginationPageLinkProcessor;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new PaginationPageLinkProcessor()).getPrecedence();
  }

  /**
   * Test
   * {@link PaginationPageLinkProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}.
   * <p>
   * Method under test:
   * {@link PaginationPageLinkProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}
   */
  @Test
  @DisplayName("Test getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)")
  @Disabled("TODO: Complete this test")
  void testGetModifiedAttributes() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.processor;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml","/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass11262 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.processor.PaginationPageLinkProcessor paginationPageLinkProcessor;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    PaginationPageLinkProcessor paginationPageLinkProcessor2 = new PaginationPageLinkProcessor();

    // Act
    paginationPageLinkProcessor2.getModifiedAttributes("Tag Name", new HashMap<>(), "Attribute Name", "42",
        mock(BroadleafTemplateContext.class));
  }
}
