package org.broadleafcommerce.core.web.processor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.broadleafcommerce.core.catalog.domain.Product;
import org.broadleafcommerce.core.catalog.domain.ProductBundleImpl;
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
class UncacheableDataProcessorDiffblueTest {
  @Autowired
  private UncacheableDataProcessor uncacheableDataProcessor;

  /**
   * Test {@link UncacheableDataProcessor#getPrecedence()}.
   * <p>
   * Method under test: {@link UncacheableDataProcessor#getPrecedence()}
   */
  @Test
  @DisplayName("Test getPrecedence()")
  void testGetPrecedence() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals(100, (new UncacheableDataProcessor()).getPrecedence());
  }

  /**
   * Test {@link UncacheableDataProcessor#getPrecedence()}.
   * <p>
   * Method under test: {@link UncacheableDataProcessor#getPrecedence()}
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
    //   public class DiffblueFakeClass102 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.processor.UncacheableDataProcessor uncacheableDataProcessor;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new UncacheableDataProcessor()).getPrecedence();
  }

  /**
   * Test
   * {@link UncacheableDataProcessor#getReplacementModel(String, Map, BroadleafTemplateContext)}.
   * <p>
   * Method under test:
   * {@link UncacheableDataProcessor#getReplacementModel(String, Map, BroadleafTemplateContext)}
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
    //   public class DiffblueFakeClass107 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.processor.UncacheableDataProcessor uncacheableDataProcessor;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    UncacheableDataProcessor uncacheableDataProcessor2 = new UncacheableDataProcessor();

    // Act
    uncacheableDataProcessor2.getReplacementModel("Tag Name", new HashMap<>(), mock(BroadleafTemplateContext.class));
  }

  /**
   * Test
   * {@link UncacheableDataProcessor#buildContentMap(BroadleafTemplateContext)}.
   * <p>
   * Method under test:
   * {@link UncacheableDataProcessor#buildContentMap(BroadleafTemplateContext)}
   */
  @Test
  @DisplayName("Test buildContentMap(BroadleafTemplateContext)")
  @Disabled("TODO: Complete this test")
  void testBuildContentMap() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.processor;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml","/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass88 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.processor.UncacheableDataProcessor uncacheableDataProcessor;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new UncacheableDataProcessor()).buildContentMap(mock(BroadleafTemplateContext.class));
  }

  /**
   * Test
   * {@link UncacheableDataProcessor#addProductInventoryData(Map, BroadleafTemplateContext)}.
   * <p>
   * Method under test:
   * {@link UncacheableDataProcessor#addProductInventoryData(Map, BroadleafTemplateContext)}
   */
  @Test
  @DisplayName("Test addProductInventoryData(Map, BroadleafTemplateContext)")
  @Disabled("TODO: Complete this test")
  void testAddProductInventoryData() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.processor;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml","/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass76 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.processor.UncacheableDataProcessor uncacheableDataProcessor;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    UncacheableDataProcessor uncacheableDataProcessor2 = new UncacheableDataProcessor();

    // Act
    uncacheableDataProcessor2.addProductInventoryData(new HashMap<>(), mock(BroadleafTemplateContext.class));
  }

  /**
   * Test
   * {@link UncacheableDataProcessor#defineOutOfStockProducts(BroadleafTemplateContext, Set, Set)}.
   * <p>
   * Method under test:
   * {@link UncacheableDataProcessor#defineOutOfStockProducts(BroadleafTemplateContext, Set, Set)}
   */
  @Test
  @DisplayName("Test defineOutOfStockProducts(BroadleafTemplateContext, Set, Set)")
  @Disabled("TODO: Complete this test")
  void testDefineOutOfStockProducts() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.processor;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml","/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass93 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.processor.UncacheableDataProcessor uncacheableDataProcessor;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    UncacheableDataProcessor uncacheableDataProcessor2 = new UncacheableDataProcessor();
    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    HashSet<Product> allProducts = new HashSet<>();

    // Act
    uncacheableDataProcessor2.defineOutOfStockProducts(context, allProducts, new HashSet<>());
  }

  /**
   * Test
   * {@link UncacheableDataProcessor#isBlockingAvailabilityOfProduct(Product, Product)}.
   * <p>
   * Method under test:
   * {@link UncacheableDataProcessor#isBlockingAvailabilityOfProduct(Product, Product)}
   */
  @Test
  @DisplayName("Test isBlockingAvailabilityOfProduct(Product, Product)")
  @Disabled("TODO: Complete this test")
  void testIsBlockingAvailabilityOfProduct() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.processor;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml","/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass150 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.processor.UncacheableDataProcessor uncacheableDataProcessor;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    UncacheableDataProcessor uncacheableDataProcessor2 = new UncacheableDataProcessor();
    ProductBundleImpl baseProduct = new ProductBundleImpl();

    // Act
    uncacheableDataProcessor2.isBlockingAvailabilityOfProduct(baseProduct, new ProductBundleImpl());
  }

  /**
   * Test {@link UncacheableDataProcessor#isBundle(Product)}.
   * <p>
   * Method under test: {@link UncacheableDataProcessor#isBundle(Product)}
   */
  @Test
  @DisplayName("Test isBundle(Product)")
  void testIsBundle() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    UncacheableDataProcessor uncacheableDataProcessor = new UncacheableDataProcessor();

    // Act and Assert
    assertFalse(uncacheableDataProcessor.isBundle(new ProductBundleImpl()));
  }

  /**
   * Test {@link UncacheableDataProcessor#isBundle(Product)}.
   * <p>
   * Method under test: {@link UncacheableDataProcessor#isBundle(Product)}
   */
  @Test
  @DisplayName("Test isBundle(Product)")
  @Disabled("TODO: Complete this test")
  void testIsBundle2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.processor;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml","/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass219 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.processor.UncacheableDataProcessor uncacheableDataProcessor;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    UncacheableDataProcessor uncacheableDataProcessor2 = new UncacheableDataProcessor();

    // Act
    uncacheableDataProcessor2.isBundle(new ProductBundleImpl());
  }

  /**
   * Test {@link UncacheableDataProcessor#addCartData(Map)}.
   * <p>
   * Method under test: {@link UncacheableDataProcessor#addCartData(Map)}
   */
  @Test
  @DisplayName("Test addCartData(Map)")
  void testAddCartData() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    UncacheableDataProcessor uncacheableDataProcessor = new UncacheableDataProcessor();
    HashMap<String, Object> attrMap = new HashMap<>();

    // Act
    uncacheableDataProcessor.addCartData(attrMap);

    // Assert
    assertEquals(3, attrMap.size());
    Object getResult = attrMap.get("cartItemIdsWithoutOptions");
    assertTrue(getResult instanceof List);
    assertTrue(attrMap.containsKey("cartItemCount"));
    assertTrue(((List<Object>) getResult).isEmpty());
    assertEquals(getResult, attrMap.get("cartItemIdsWithOptions"));
  }

  /**
   * Test {@link UncacheableDataProcessor#addCartData(Map)}.
   * <p>
   * Method under test: {@link UncacheableDataProcessor#addCartData(Map)}
   */
  @Test
  @DisplayName("Test addCartData(Map)")
  @Disabled("TODO: Complete this test")
  void testAddCartData2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.processor;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml","/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass52 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.processor.UncacheableDataProcessor uncacheableDataProcessor;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    UncacheableDataProcessor uncacheableDataProcessor2 = new UncacheableDataProcessor();

    // Act
    uncacheableDataProcessor2.addCartData(new HashMap<>());
  }

  /**
   * Test {@link UncacheableDataProcessor#addCustomerData(Map)}.
   * <p>
   * Method under test: {@link UncacheableDataProcessor#addCustomerData(Map)}
   */
  @Test
  @DisplayName("Test addCustomerData(Map)")
  void testAddCustomerData() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    UncacheableDataProcessor uncacheableDataProcessor = new UncacheableDataProcessor();
    HashMap<String, Object> attrMap = new HashMap<>();

    // Act
    uncacheableDataProcessor.addCustomerData(attrMap);

    // Assert
    assertEquals(3, attrMap.size());
    assertEquals("", attrMap.get("firstName"));
    assertEquals("", attrMap.get("lastName"));
    assertTrue(attrMap.containsKey("anonymous"));
  }

  /**
   * Test {@link UncacheableDataProcessor#addCustomerData(Map)}.
   * <p>
   * Method under test: {@link UncacheableDataProcessor#addCustomerData(Map)}
   */
  @Test
  @DisplayName("Test addCustomerData(Map)")
  @Disabled("TODO: Complete this test")
  void testAddCustomerData2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.processor;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml","/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass64 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.processor.UncacheableDataProcessor uncacheableDataProcessor;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    UncacheableDataProcessor uncacheableDataProcessor2 = new UncacheableDataProcessor();

    // Act
    uncacheableDataProcessor2.addCustomerData(new HashMap<>());
  }

  /**
   * Test
   * {@link UncacheableDataProcessor#getUncacheableDataFunction(BroadleafTemplateContext, Map)}.
   * <p>
   * Method under test:
   * {@link UncacheableDataProcessor#getUncacheableDataFunction(BroadleafTemplateContext, Map)}
   */
  @Test
  @DisplayName("Test getUncacheableDataFunction(BroadleafTemplateContext, Map)")
  @Disabled("TODO: Complete this test")
  void testGetUncacheableDataFunction() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.processor;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml","/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass138 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.processor.UncacheableDataProcessor uncacheableDataProcessor;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    UncacheableDataProcessor uncacheableDataProcessor2 = new UncacheableDataProcessor();
    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);

    // Act
    uncacheableDataProcessor2.getUncacheableDataFunction(context, new HashMap<>());
  }

  /**
   * Test
   * {@link UncacheableDataProcessor#getUncacheableDataFunction(BroadleafTemplateContext, Map)}.
   * <ul>
   *   <li>Given {@code callbackBlock}.</li>
   *   <li>Then return {@code Tag Attributes}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link UncacheableDataProcessor#getUncacheableDataFunction(BroadleafTemplateContext, Map)}
   */
  @Test
  @DisplayName("Test getUncacheableDataFunction(BroadleafTemplateContext, Map); given 'callbackBlock'; then return 'Tag Attributes'")
  void testGetUncacheableDataFunction_givenCallbackBlock_thenReturnTagAttributes() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    UncacheableDataProcessor uncacheableDataProcessor = new UncacheableDataProcessor();
    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);

    HashMap<String, String> tagAttributes = new HashMap<>();
    tagAttributes.put("callbackBlock", "Tag Attributes");
    tagAttributes.put("callback", "Tag Attributes");
    tagAttributes.put("callbackBlock", "Tag Attributes");
    tagAttributes.put("callback", "Tag Attributes");

    // Act and Assert
    assertEquals("Tag Attributes", uncacheableDataProcessor.getUncacheableDataFunction(context, tagAttributes));
  }

  /**
   * Test
   * {@link UncacheableDataProcessor#getUncacheableDataFunction(BroadleafTemplateContext, Map)}.
   * <ul>
   *   <li>Given {@code foo}.</li>
   *   <li>Then return {@code Tag Attributes;}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link UncacheableDataProcessor#getUncacheableDataFunction(BroadleafTemplateContext, Map)}
   */
  @Test
  @DisplayName("Test getUncacheableDataFunction(BroadleafTemplateContext, Map); given 'foo'; then return 'Tag Attributes;'")
  void testGetUncacheableDataFunction_givenFoo_thenReturnTagAttributes() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    UncacheableDataProcessor uncacheableDataProcessor = new UncacheableDataProcessor();
    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);

    HashMap<String, String> tagAttributes = new HashMap<>();
    tagAttributes.put("foo", "Tag Attributes");
    tagAttributes.put("callback", "Tag Attributes");
    tagAttributes.put("foo", "Tag Attributes");
    tagAttributes.put("callback", "Tag Attributes");

    // Act and Assert
    assertEquals("Tag Attributes;\n", uncacheableDataProcessor.getUncacheableDataFunction(context, tagAttributes));
  }

  /**
   * Test
   * {@link UncacheableDataProcessor#getUncacheableDataFunction(BroadleafTemplateContext, Map)}.
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.</li>
   *   <li>Then return {@code updateUncacheableData(params);}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link UncacheableDataProcessor#getUncacheableDataFunction(BroadleafTemplateContext, Map)}
   */
  @Test
  @DisplayName("Test getUncacheableDataFunction(BroadleafTemplateContext, Map); when HashMap(); then return 'updateUncacheableData(params);'")
  void testGetUncacheableDataFunction_whenHashMap_thenReturnUpdateUncacheableDataParams() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    UncacheableDataProcessor uncacheableDataProcessor = new UncacheableDataProcessor();
    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);

    // Act and Assert
    assertEquals("updateUncacheableData(params);\n",
        uncacheableDataProcessor.getUncacheableDataFunction(context, new HashMap<>()));
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link UncacheableDataProcessor#setDefaultCallbackFunction(String)}
   *   <li>{@link UncacheableDataProcessor#getDefaultCallbackFunction()}
   *   <li>{@link UncacheableDataProcessor#getName()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange
    UncacheableDataProcessor uncacheableDataProcessor = new UncacheableDataProcessor();

    // Act
    uncacheableDataProcessor.setDefaultCallbackFunction("Default Callback Function");
    String actualDefaultCallbackFunction = uncacheableDataProcessor.getDefaultCallbackFunction();

    // Assert that nothing has changed
    assertEquals("Default Callback Function", actualDefaultCallbackFunction);
    assertEquals("uncacheabledata", uncacheableDataProcessor.getName());
  }
}
