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
class CatalogRelativeHrefProcessorDiffblueTest {
  @Autowired
  private CatalogRelativeHrefProcessor catalogRelativeHrefProcessor;

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link CatalogRelativeHrefProcessor#getName()}
   *   <li>{@link CatalogRelativeHrefProcessor#getPrecedence()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange
    CatalogRelativeHrefProcessor catalogRelativeHrefProcessor = new CatalogRelativeHrefProcessor();

    // Act
    String actualName = catalogRelativeHrefProcessor.getName();

    // Assert
    assertEquals("RHREF", actualName);
    assertEquals(0, catalogRelativeHrefProcessor.getPrecedence());
  }

  /**
   * Test
   * {@link CatalogRelativeHrefProcessor#buildRelativeHref(String, Map, String, String, BroadleafTemplateContext)}.
   * <p>
   * Method under test:
   * {@link CatalogRelativeHrefProcessor#buildRelativeHref(String, Map, String, String, BroadleafTemplateContext)}
   */
  @Test
  @DisplayName("Test buildRelativeHref(String, Map, String, String, BroadleafTemplateContext)")
  @Disabled("TODO: Complete this test")
  void testBuildRelativeHref() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.processor;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml","/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass9896 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.processor.CatalogRelativeHrefProcessor catalogRelativeHrefProcessor;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    CatalogRelativeHrefProcessor catalogRelativeHrefProcessor2 = new CatalogRelativeHrefProcessor();

    // Act
    catalogRelativeHrefProcessor2.buildRelativeHref("Tag Name", new HashMap<>(), "Attribute Name", "42",
        mock(BroadleafTemplateContext.class));
  }

  /**
   * Test
   * {@link CatalogRelativeHrefProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}.
   * <p>
   * Method under test:
   * {@link CatalogRelativeHrefProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}
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
    //   public class DiffblueFakeClass9916 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.processor.CatalogRelativeHrefProcessor catalogRelativeHrefProcessor;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    CatalogRelativeHrefProcessor catalogRelativeHrefProcessor2 = new CatalogRelativeHrefProcessor();

    // Act
    catalogRelativeHrefProcessor2.getModifiedAttributes("Tag Name", new HashMap<>(), "Attribute Name", "42",
        mock(BroadleafTemplateContext.class));
  }
}
