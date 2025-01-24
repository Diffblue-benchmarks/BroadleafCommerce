package org.broadleafcommerce.core.web.processor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.HashMap;
import java.util.Map;
import org.broadleafcommerce.core.catalog.domain.ProductBundleImpl;
import org.broadleafcommerce.core.order.domain.DiscreteOrderItemImpl;
import org.broadleafcommerce.presentation.model.BroadleafTemplateContext;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml",
    "/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml",
    "/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
@ExtendWith(SpringExtension.class)
class ProductOptionDisplayProcessorDiffblueTest {
  @Autowired
  private ProductOptionDisplayProcessor productOptionDisplayProcessor;

  /**
   * Test {@link ProductOptionDisplayProcessor#getName()}.
   * <p>
   * Method under test: {@link ProductOptionDisplayProcessor#getName()}
   */
  @Test
  @DisplayName("Test getName()")
  void testGetName() {
    // Arrange, Act and Assert
    assertEquals("product_option_display", (new ProductOptionDisplayProcessor()).getName());
  }

  /**
   * Test {@link ProductOptionDisplayProcessor#getPrecedence()}.
   * <p>
   * Method under test: {@link ProductOptionDisplayProcessor#getPrecedence()}
   */
  @Test
  @DisplayName("Test getPrecedence()")
  void testGetPrecedence() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals(100, (new ProductOptionDisplayProcessor()).getPrecedence());
  }

  /**
   * Test {@link ProductOptionDisplayProcessor#getPrecedence()}.
   * <p>
   * Method under test: {@link ProductOptionDisplayProcessor#getPrecedence()}
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
    //   public class DiffblueFakeClass11340 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.processor.ProductOptionDisplayProcessor productOptionDisplayProcessor;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new ProductOptionDisplayProcessor()).getPrecedence();
  }

  /**
   * Test {@link ProductOptionDisplayProcessor#useGlobalScope()}.
   * <p>
   * Method under test: {@link ProductOptionDisplayProcessor#useGlobalScope()}
   */
  @Test
  @DisplayName("Test useGlobalScope()")
  void testUseGlobalScope() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new ProductOptionDisplayProcessor()).useGlobalScope());
  }

  /**
   * Test {@link ProductOptionDisplayProcessor#useGlobalScope()}.
   * <p>
   * Method under test: {@link ProductOptionDisplayProcessor#useGlobalScope()}
   */
  @Test
  @DisplayName("Test useGlobalScope()")
  @Disabled("TODO: Complete this test")
  void testUseGlobalScope2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.processor;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml","/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass11356 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.processor.ProductOptionDisplayProcessor productOptionDisplayProcessor;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new ProductOptionDisplayProcessor()).useGlobalScope();
  }

  /**
   * Test
   * {@link ProductOptionDisplayProcessor#populateModelVariables(String, Map, BroadleafTemplateContext)}.
   * <p>
   * Method under test:
   * {@link ProductOptionDisplayProcessor#populateModelVariables(String, Map, BroadleafTemplateContext)}
   */
  @Test
  @DisplayName("Test populateModelVariables(String, Map, BroadleafTemplateContext)")
  @Disabled("TODO: Complete this test")
  void testPopulateModelVariables() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.processor;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml","/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass11341 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.processor.ProductOptionDisplayProcessor productOptionDisplayProcessor;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    ProductOptionDisplayProcessor productOptionDisplayProcessor2 = new ProductOptionDisplayProcessor();

    // Act
    productOptionDisplayProcessor2.populateModelVariables("Tag Name", new HashMap<>(),
        mock(BroadleafTemplateContext.class));
  }

  /**
   * Test
   * {@link ProductOptionDisplayProcessor#populateModelVariables(String, Map, BroadleafTemplateContext)}.
   * <ul>
   *   <li>Given {@code Parse Expression}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ProductOptionDisplayProcessor#populateModelVariables(String, Map, BroadleafTemplateContext)}
   */
  @Test
  @DisplayName("Test populateModelVariables(String, Map, BroadleafTemplateContext); given 'Parse Expression'")
  void testPopulateModelVariables_givenParseExpression() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductOptionDisplayProcessor productOptionDisplayProcessor = new ProductOptionDisplayProcessor();
    HashMap<String, String> tagAttributes = new HashMap<>();
    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.parseExpression(Mockito.<String>any())).thenReturn("Parse Expression");

    // Act
    Map<String, Object> actualPopulateModelVariablesResult = productOptionDisplayProcessor
        .populateModelVariables("Tag Name", tagAttributes, context);

    // Assert
    verify(context).parseExpression(isNull());
    assertEquals(1, actualPopulateModelVariablesResult.size());
    Object getResult = actualPopulateModelVariablesResult.get("productOptionDisplayValues");
    assertTrue(getResult instanceof Map);
    assertTrue(((Map<Object, Object>) getResult).isEmpty());
  }

  /**
   * Test
   * {@link ProductOptionDisplayProcessor#populateModelVariables(String, Map, BroadleafTemplateContext)}.
   * <ul>
   *   <li>Then calls {@link DiscreteOrderItemImpl#getProduct()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ProductOptionDisplayProcessor#populateModelVariables(String, Map, BroadleafTemplateContext)}
   */
  @Test
  @DisplayName("Test populateModelVariables(String, Map, BroadleafTemplateContext); then calls getProduct()")
  void testPopulateModelVariables_thenCallsGetProduct() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductOptionDisplayProcessor productOptionDisplayProcessor = new ProductOptionDisplayProcessor();
    HashMap<String, String> tagAttributes = new HashMap<>();
    DiscreteOrderItemImpl discreteOrderItemImpl = mock(DiscreteOrderItemImpl.class);
    when(discreteOrderItemImpl.getOrderItemAttributes()).thenReturn(new HashMap<>());
    when(discreteOrderItemImpl.getProduct()).thenReturn(new ProductBundleImpl());
    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.parseExpression(Mockito.<String>any())).thenReturn(discreteOrderItemImpl);

    // Act
    Map<String, Object> actualPopulateModelVariablesResult = productOptionDisplayProcessor
        .populateModelVariables("Tag Name", tagAttributes, context);

    // Assert
    verify(discreteOrderItemImpl).getProduct();
    verify(discreteOrderItemImpl).getOrderItemAttributes();
    verify(context).parseExpression(isNull());
    assertEquals(1, actualPopulateModelVariablesResult.size());
    Object getResult = actualPopulateModelVariablesResult.get("productOptionDisplayValues");
    assertTrue(getResult instanceof Map);
    assertTrue(((Map<Object, Object>) getResult).isEmpty());
  }
}
