package org.broadleafcommerce.core.web.seo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import org.broadleafcommerce.common.page.dto.PageDTO;
import org.broadleafcommerce.core.catalog.domain.Category;
import org.broadleafcommerce.core.catalog.domain.CategoryImpl;
import org.broadleafcommerce.core.catalog.domain.Product;
import org.broadleafcommerce.core.catalog.domain.ProductBundleImpl;
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
class BasicSeoPropertyGeneratorImplDiffblueTest {
  @Autowired
  private BasicSeoPropertyGeneratorImpl basicSeoPropertyGeneratorImpl;

  /**
   * Test {@link BasicSeoPropertyGeneratorImpl#filterForSeoProperties(Map)}.
   * <p>
   * Method under test:
   * {@link BasicSeoPropertyGeneratorImpl#filterForSeoProperties(Map)}
   */
  @Test
  @DisplayName("Test filterForSeoProperties(Map)")
  @Disabled("TODO: Complete this test")
  void testFilterForSeoProperties() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.seo;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml","/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2278 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.seo.BasicSeoPropertyGeneratorImpl basicSeoPropertyGeneratorImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    BasicSeoPropertyGeneratorImpl basicSeoPropertyGeneratorImpl2 = new BasicSeoPropertyGeneratorImpl();

    // Act
    basicSeoPropertyGeneratorImpl2.filterForSeoProperties(new HashMap<>());
  }

  /**
   * Test {@link BasicSeoPropertyGeneratorImpl#filterForSeoProperties(Map)}.
   * <ul>
   *   <li>Given {@link BiFunction}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BasicSeoPropertyGeneratorImpl#filterForSeoProperties(Map)}
   */
  @Test
  @DisplayName("Test filterForSeoProperties(Map); given BiFunction")
  void testFilterForSeoProperties_givenBiFunction() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicSeoPropertyGeneratorImpl basicSeoPropertyGeneratorImpl = new BasicSeoPropertyGeneratorImpl();

    HashMap<String, String> properties = new HashMap<>();
    properties.computeIfPresent("title", mock(BiFunction.class));
    properties.put("foo", "foo");

    // Act and Assert
    assertTrue(basicSeoPropertyGeneratorImpl.filterForSeoProperties(properties).isEmpty());
  }

  /**
   * Test {@link BasicSeoPropertyGeneratorImpl#filterForSeoProperties(Map)}.
   * <ul>
   *   <li>Given {@code foo}.</li>
   *   <li>When {@link HashMap#HashMap()} {@code foo} is {@code foo}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BasicSeoPropertyGeneratorImpl#filterForSeoProperties(Map)}
   */
  @Test
  @DisplayName("Test filterForSeoProperties(Map); given 'foo'; when HashMap() 'foo' is 'foo'; then return Empty")
  void testFilterForSeoProperties_givenFoo_whenHashMapFooIsFoo_thenReturnEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicSeoPropertyGeneratorImpl basicSeoPropertyGeneratorImpl = new BasicSeoPropertyGeneratorImpl();

    HashMap<String, String> properties = new HashMap<>();
    properties.put("foo", "foo");

    // Act and Assert
    assertTrue(basicSeoPropertyGeneratorImpl.filterForSeoProperties(properties).isEmpty());
  }

  /**
   * Test {@link BasicSeoPropertyGeneratorImpl#filterForSeoProperties(Map)}.
   * <ul>
   *   <li>Given {@code metaDescription}.</li>
   *   <li>Then return {@code metaDescription} is {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BasicSeoPropertyGeneratorImpl#filterForSeoProperties(Map)}
   */
  @Test
  @DisplayName("Test filterForSeoProperties(Map); given 'metaDescription'; then return 'metaDescription' is 'foo'")
  void testFilterForSeoProperties_givenMetaDescription_thenReturnMetaDescriptionIsFoo() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicSeoPropertyGeneratorImpl basicSeoPropertyGeneratorImpl = new BasicSeoPropertyGeneratorImpl();

    HashMap<String, String> properties = new HashMap<>();
    properties.put("metaDescription", "foo");

    // Act
    Map<String, String> actualFilterForSeoPropertiesResult = basicSeoPropertyGeneratorImpl
        .filterForSeoProperties(properties);

    // Assert
    assertEquals(1, actualFilterForSeoPropertiesResult.size());
    assertEquals("foo", actualFilterForSeoPropertiesResult.get("metaDescription"));
  }

  /**
   * Test {@link BasicSeoPropertyGeneratorImpl#filterForSeoProperties(Map)}.
   * <ul>
   *   <li>Given {@code title}.</li>
   *   <li>When {@link HashMap#HashMap()} {@code title} is {@code foo}.</li>
   *   <li>Then return {@code title} is {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BasicSeoPropertyGeneratorImpl#filterForSeoProperties(Map)}
   */
  @Test
  @DisplayName("Test filterForSeoProperties(Map); given 'title'; when HashMap() 'title' is 'foo'; then return 'title' is 'foo'")
  void testFilterForSeoProperties_givenTitle_whenHashMapTitleIsFoo_thenReturnTitleIsFoo() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicSeoPropertyGeneratorImpl basicSeoPropertyGeneratorImpl = new BasicSeoPropertyGeneratorImpl();

    HashMap<String, String> properties = new HashMap<>();
    properties.put("title", "foo");

    // Act
    Map<String, String> actualFilterForSeoPropertiesResult = basicSeoPropertyGeneratorImpl
        .filterForSeoProperties(properties);

    // Assert
    assertEquals(1, actualFilterForSeoPropertiesResult.size());
    assertEquals("foo", actualFilterForSeoPropertiesResult.get("title"));
  }

  /**
   * Test {@link BasicSeoPropertyGeneratorImpl#filterForSeoProperties(Map)}.
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BasicSeoPropertyGeneratorImpl#filterForSeoProperties(Map)}
   */
  @Test
  @DisplayName("Test filterForSeoProperties(Map); when HashMap(); then return Empty")
  void testFilterForSeoProperties_whenHashMap_thenReturnEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicSeoPropertyGeneratorImpl basicSeoPropertyGeneratorImpl = new BasicSeoPropertyGeneratorImpl();

    // Act and Assert
    assertTrue(basicSeoPropertyGeneratorImpl.filterForSeoProperties(new HashMap<>()).isEmpty());
  }

  /**
   * Test {@link BasicSeoPropertyGeneratorImpl#gatherSeoProperties(Category)} with
   * {@code category}.
   * <p>
   * Method under test:
   * {@link BasicSeoPropertyGeneratorImpl#gatherSeoProperties(Category)}
   */
  @Test
  @DisplayName("Test gatherSeoProperties(Category) with 'category'")
  @Disabled("TODO: Complete this test")
  void testGatherSeoPropertiesWithCategory() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.seo;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml","/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2307 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.seo.BasicSeoPropertyGeneratorImpl basicSeoPropertyGeneratorImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    BasicSeoPropertyGeneratorImpl basicSeoPropertyGeneratorImpl2 = new BasicSeoPropertyGeneratorImpl();

    // Act
    basicSeoPropertyGeneratorImpl2.gatherSeoProperties(new CategoryImpl());
  }

  /**
   * Test {@link BasicSeoPropertyGeneratorImpl#gatherSeoProperties(PageDTO)} with
   * {@code page}.
   * <p>
   * Method under test:
   * {@link BasicSeoPropertyGeneratorImpl#gatherSeoProperties(PageDTO)}
   */
  @Test
  @DisplayName("Test gatherSeoProperties(PageDTO) with 'page'")
  @Disabled("TODO: Complete this test")
  void testGatherSeoPropertiesWithPage() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.seo;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml","/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2288 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.seo.BasicSeoPropertyGeneratorImpl basicSeoPropertyGeneratorImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    BasicSeoPropertyGeneratorImpl basicSeoPropertyGeneratorImpl2 = new BasicSeoPropertyGeneratorImpl();

    // Act
    basicSeoPropertyGeneratorImpl2.gatherSeoProperties(new PageDTO());
  }

  /**
   * Test {@link BasicSeoPropertyGeneratorImpl#gatherSeoProperties(Product)} with
   * {@code product}.
   * <p>
   * Method under test:
   * {@link BasicSeoPropertyGeneratorImpl#gatherSeoProperties(Product)}
   */
  @Test
  @DisplayName("Test gatherSeoProperties(Product) with 'product'")
  @Disabled("TODO: Complete this test")
  void testGatherSeoPropertiesWithProduct() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.seo;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml","/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2343 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.seo.BasicSeoPropertyGeneratorImpl basicSeoPropertyGeneratorImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    BasicSeoPropertyGeneratorImpl basicSeoPropertyGeneratorImpl2 = new BasicSeoPropertyGeneratorImpl();

    // Act
    basicSeoPropertyGeneratorImpl2.gatherSeoProperties(new ProductBundleImpl());
  }

  /**
   * Test {@link BasicSeoPropertyGeneratorImpl#addDefaultTitle(Map, String)}.
   * <p>
   * Method under test:
   * {@link BasicSeoPropertyGeneratorImpl#addDefaultTitle(Map, String)}
   */
  @Test
  @DisplayName("Test addDefaultTitle(Map, String)")
  @Disabled("TODO: Complete this test")
  void testAddDefaultTitle() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.seo;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml","/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2260 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.seo.BasicSeoPropertyGeneratorImpl basicSeoPropertyGeneratorImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    BasicSeoPropertyGeneratorImpl basicSeoPropertyGeneratorImpl2 = new BasicSeoPropertyGeneratorImpl();

    // Act
    basicSeoPropertyGeneratorImpl2.addDefaultTitle(new HashMap<>(), "Dr");
  }

  /**
   * Test {@link BasicSeoPropertyGeneratorImpl#addDefaultTitle(Map, String)}.
   * <ul>
   *   <li>Given {@link BiFunction}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BasicSeoPropertyGeneratorImpl#addDefaultTitle(Map, String)}
   */
  @Test
  @DisplayName("Test addDefaultTitle(Map, String); given BiFunction")
  void testAddDefaultTitle_givenBiFunction() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicSeoPropertyGeneratorImpl basicSeoPropertyGeneratorImpl = new BasicSeoPropertyGeneratorImpl();

    HashMap<String, String> properties = new HashMap<>();
    properties.computeIfPresent("title", mock(BiFunction.class));

    // Act
    basicSeoPropertyGeneratorImpl.addDefaultTitle(properties, "Dr");

    // Assert
    assertEquals(1, properties.size());
    assertEquals("Dr", properties.get("title"));
  }

  /**
   * Test {@link BasicSeoPropertyGeneratorImpl#addDefaultTitle(Map, String)}.
   * <ul>
   *   <li>Given {@code Properties}.</li>
   *   <li>Then {@link HashMap#HashMap()} {@code title} is {@code Properties}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BasicSeoPropertyGeneratorImpl#addDefaultTitle(Map, String)}
   */
  @Test
  @DisplayName("Test addDefaultTitle(Map, String); given 'Properties'; then HashMap() 'title' is 'Properties'")
  void testAddDefaultTitle_givenProperties_thenHashMapTitleIsProperties() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicSeoPropertyGeneratorImpl basicSeoPropertyGeneratorImpl = new BasicSeoPropertyGeneratorImpl();

    HashMap<String, String> properties = new HashMap<>();
    properties.put("title", "Properties");

    // Act
    basicSeoPropertyGeneratorImpl.addDefaultTitle(properties, "Dr");

    // Assert that nothing has changed
    assertEquals(1, properties.size());
    assertEquals("Properties", properties.get("title"));
  }

  /**
   * Test {@link BasicSeoPropertyGeneratorImpl#addDefaultTitle(Map, String)}.
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.</li>
   *   <li>Then {@link HashMap#HashMap()} {@code title} is {@code Dr}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BasicSeoPropertyGeneratorImpl#addDefaultTitle(Map, String)}
   */
  @Test
  @DisplayName("Test addDefaultTitle(Map, String); when HashMap(); then HashMap() 'title' is 'Dr'")
  void testAddDefaultTitle_whenHashMap_thenHashMapTitleIsDr() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicSeoPropertyGeneratorImpl basicSeoPropertyGeneratorImpl = new BasicSeoPropertyGeneratorImpl();
    HashMap<String, String> properties = new HashMap<>();

    // Act
    basicSeoPropertyGeneratorImpl.addDefaultTitle(properties, "Dr");

    // Assert
    assertEquals(1, properties.size());
    assertEquals("Dr", properties.get("title"));
  }

  /**
   * Test
   * {@link BasicSeoPropertyGeneratorImpl#addDefaultDescription(Map, String)}.
   * <p>
   * Method under test:
   * {@link BasicSeoPropertyGeneratorImpl#addDefaultDescription(Map, String)}
   */
  @Test
  @DisplayName("Test addDefaultDescription(Map, String)")
  @Disabled("TODO: Complete this test")
  void testAddDefaultDescription() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.seo;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml","/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2245 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.seo.BasicSeoPropertyGeneratorImpl basicSeoPropertyGeneratorImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    BasicSeoPropertyGeneratorImpl basicSeoPropertyGeneratorImpl2 = new BasicSeoPropertyGeneratorImpl();

    // Act
    basicSeoPropertyGeneratorImpl2.addDefaultDescription(new HashMap<>(), "Default Description");
  }

  /**
   * Test
   * {@link BasicSeoPropertyGeneratorImpl#addDefaultDescription(Map, String)}.
   * <ul>
   *   <li>Given {@link BiFunction}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BasicSeoPropertyGeneratorImpl#addDefaultDescription(Map, String)}
   */
  @Test
  @DisplayName("Test addDefaultDescription(Map, String); given BiFunction")
  void testAddDefaultDescription_givenBiFunction() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicSeoPropertyGeneratorImpl basicSeoPropertyGeneratorImpl = new BasicSeoPropertyGeneratorImpl();

    HashMap<String, String> properties = new HashMap<>();
    properties.computeIfPresent("metaDescription", mock(BiFunction.class));

    // Act
    basicSeoPropertyGeneratorImpl.addDefaultDescription(properties, "Default Description");

    // Assert
    assertEquals(1, properties.size());
    assertEquals("Default Description", properties.get("metaDescription"));
  }

  /**
   * Test
   * {@link BasicSeoPropertyGeneratorImpl#addDefaultDescription(Map, String)}.
   * <ul>
   *   <li>Given {@code Properties}.</li>
   *   <li>Then {@link HashMap#HashMap()} {@code metaDescription} is
   * {@code Properties}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BasicSeoPropertyGeneratorImpl#addDefaultDescription(Map, String)}
   */
  @Test
  @DisplayName("Test addDefaultDescription(Map, String); given 'Properties'; then HashMap() 'metaDescription' is 'Properties'")
  void testAddDefaultDescription_givenProperties_thenHashMapMetaDescriptionIsProperties() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicSeoPropertyGeneratorImpl basicSeoPropertyGeneratorImpl = new BasicSeoPropertyGeneratorImpl();

    HashMap<String, String> properties = new HashMap<>();
    properties.put("metaDescription", "Properties");

    // Act
    basicSeoPropertyGeneratorImpl.addDefaultDescription(properties, "Default Description");

    // Assert that nothing has changed
    assertEquals(1, properties.size());
    assertEquals("Properties", properties.get("metaDescription"));
  }

  /**
   * Test
   * {@link BasicSeoPropertyGeneratorImpl#addDefaultDescription(Map, String)}.
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BasicSeoPropertyGeneratorImpl#addDefaultDescription(Map, String)}
   */
  @Test
  @DisplayName("Test addDefaultDescription(Map, String); when HashMap()")
  void testAddDefaultDescription_whenHashMap() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicSeoPropertyGeneratorImpl basicSeoPropertyGeneratorImpl = new BasicSeoPropertyGeneratorImpl();
    HashMap<String, String> properties = new HashMap<>();

    // Act
    basicSeoPropertyGeneratorImpl.addDefaultDescription(properties, "Default Description");

    // Assert
    assertEquals(1, properties.size());
    assertEquals("Default Description", properties.get("metaDescription"));
  }
}
