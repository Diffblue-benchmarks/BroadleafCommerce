package org.broadleafcommerce.core.order.service;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = {"/bl-framework-applicationContext.xml",
    "/bl-framework-applicationContext-entity.xml", "/bl-framework-applicationContext-persistence.xml",
    "/bl-framework-applicationContext-workflow.xml",
    "/blc-config/admin/framework/bl-framework-admin-applicationContext.xml",
    "/blc-config/site/framework/bl-framework-applicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class StructuredContentCartRuleProcessorDiffblueTest {
  @Autowired
  private StructuredContentCartRuleProcessor structuredContentCartRuleProcessor;

  /**
   * Test new {@link StructuredContentCartRuleProcessor} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link StructuredContentCartRuleProcessor}
   */
  @Test
  public void testNewStructuredContentCartRuleProcessor() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    StructuredContentCartRuleProcessor actualStructuredContentCartRuleProcessor = new StructuredContentCartRuleProcessor();

    // Assert
    assertNull(actualStructuredContentCartRuleProcessor.getOrderDao());
    assertTrue(actualStructuredContentCartRuleProcessor.getContextClassNames().isEmpty());
  }

  /**
   * Test new {@link StructuredContentCartRuleProcessor} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link StructuredContentCartRuleProcessor}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testNewStructuredContentCartRuleProcessor2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.order.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext.xml","/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass0 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.order.service.StructuredContentCartRuleProcessor structuredContentCartRuleProcessor;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    new StructuredContentCartRuleProcessor();
  }
}
