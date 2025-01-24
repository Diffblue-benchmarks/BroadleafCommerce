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
class GoogleTagManagerProcessorDiffblueTest {
  @Autowired
  private GoogleTagManagerProcessor googleTagManagerProcessor;

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link GoogleTagManagerProcessor#getName()}
   *   <li>{@link GoogleTagManagerProcessor#getPrecedence()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange
    GoogleTagManagerProcessor googleTagManagerProcessor = new GoogleTagManagerProcessor();

    // Act
    String actualName = googleTagManagerProcessor.getName();

    // Assert
    assertEquals("google_tag_manager", actualName);
    assertEquals(0, googleTagManagerProcessor.getPrecedence());
  }

  /**
   * Test
   * {@link GoogleTagManagerProcessor#getReplacementModel(String, Map, BroadleafTemplateContext)}.
   * <p>
   * Method under test:
   * {@link GoogleTagManagerProcessor#getReplacementModel(String, Map, BroadleafTemplateContext)}
   */
  @Test
  @DisplayName("Test getReplacementModel(String, Map, BroadleafTemplateContext)")
  @Disabled("TODO: Complete this test")
  void testGetReplacementModel() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.processor;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml","/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass10074 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.processor.GoogleTagManagerProcessor googleTagManagerProcessor;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    GoogleTagManagerProcessor googleTagManagerProcessor2 = new GoogleTagManagerProcessor();

    // Act
    googleTagManagerProcessor2.getReplacementModel("Tag Name", new HashMap<>(), mock(BroadleafTemplateContext.class));
  }
}
