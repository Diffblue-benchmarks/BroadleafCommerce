package org.broadleafcommerce.core.web.linkeddata.processor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.broadleafcommerce.core.web.search.SearchRequestWrapper;
import org.broadleafcommerce.core.web.security.XssRequestWrapper;
import org.broadleafcommerce.presentation.model.BroadleafTemplateContext;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.reactive.context.StandardReactiveWebEnvironment;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml",
    "/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml",
    "/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
@ExtendWith(SpringExtension.class)
class LinkedDataProcessorDiffblueTest {
  @Autowired
  private LinkedDataProcessor linkedDataProcessor;

  /**
   * Test
   * {@link LinkedDataProcessor#getReplacementModel(String, Map, BroadleafTemplateContext)}.
   * <p>
   * Method under test:
   * {@link LinkedDataProcessor#getReplacementModel(String, Map, BroadleafTemplateContext)}
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
    //   package org.broadleafcommerce.core.web.linkeddata.processor;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml","/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass7122 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.linkeddata.processor.LinkedDataProcessor linkedDataProcessor;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    LinkedDataProcessor linkedDataProcessor2 = new LinkedDataProcessor();

    // Act
    linkedDataProcessor2.getReplacementModel("foo", new HashMap<>(), mock(BroadleafTemplateContext.class));
  }

  /**
   * Test {@link LinkedDataProcessor#getData(HttpServletRequest)}.
   * <p>
   * Method under test: {@link LinkedDataProcessor#getData(HttpServletRequest)}
   */
  @Test
  @DisplayName("Test getData(HttpServletRequest)")
  @Disabled("TODO: Complete this test")
  void testGetData() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.linkeddata.processor;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml","/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass6967 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.linkeddata.processor.LinkedDataProcessor linkedDataProcessor;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    LinkedDataProcessor linkedDataProcessor2 = new LinkedDataProcessor();
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();

    // Act
    linkedDataProcessor2.getData(new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
        new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"})));
  }

  /**
   * Test {@link LinkedDataProcessor#getName()}.
   * <p>
   * Method under test: {@link LinkedDataProcessor#getName()}
   */
  @Test
  @DisplayName("Test getName()")
  void testGetName() {
    // Arrange, Act and Assert
    assertEquals("linkedData", (new LinkedDataProcessor()).getName());
  }
}
