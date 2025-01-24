package org.broadleafcommerce.core.web.seo;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.HashMap;
import java.util.Map;
import org.broadleafcommerce.common.page.dto.NullPageDTO;
import org.broadleafcommerce.common.page.dto.PageDTO;
import org.broadleafcommerce.core.catalog.domain.Category;
import org.broadleafcommerce.core.catalog.domain.CategoryAttribute;
import org.broadleafcommerce.core.catalog.domain.CategoryAttributeImpl;
import org.broadleafcommerce.core.catalog.domain.CategoryImpl;
import org.broadleafcommerce.core.catalog.domain.Product;
import org.broadleafcommerce.core.catalog.domain.ProductAttribute;
import org.broadleafcommerce.core.catalog.domain.ProductAttributeImpl;
import org.broadleafcommerce.core.catalog.domain.ProductBundleImpl;
import org.broadleafcommerce.core.catalog.domain.ProductImpl;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml",
    "/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml",
    "/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
@ExtendWith(SpringExtension.class)
class AbstractSeoPropertyGeneratorDiffblueTest {
  @MockBean
  private AbstractSeoPropertyGenerator abstractSeoPropertyGenerator;

  @MockBean
  private Environment environment;

  @MockBean
  private SeoDefaultPropertyService seoDefaultPropertyService;

  /**
   * Test {@link AbstractSeoPropertyGenerator#gatherSeoProperties(Category)} with
   * {@code category}.
   * <p>
   * Method under test:
   * {@link AbstractSeoPropertyGenerator#gatherSeoProperties(Category)}
   */
  @Test
  @DisplayName("Test gatherSeoProperties(Category) with 'category'")
  void testGatherSeoPropertiesWithCategory() {
    // Arrange
    when(abstractSeoPropertyGenerator.gatherSeoProperties(Mockito.<Category>any())).thenReturn(new HashMap<>());

    // Act
    Map<String, String> actualGatherSeoPropertiesResult = abstractSeoPropertyGenerator
        .gatherSeoProperties(new CategoryImpl());

    // Assert
    verify(abstractSeoPropertyGenerator).gatherSeoProperties(isA(Category.class));
    assertTrue(actualGatherSeoPropertiesResult.isEmpty());
  }

  /**
   * Test {@link AbstractSeoPropertyGenerator#gatherSeoProperties(PageDTO)} with
   * {@code page}.
   * <p>
   * Method under test:
   * {@link AbstractSeoPropertyGenerator#gatherSeoProperties(PageDTO)}
   */
  @Test
  @DisplayName("Test gatherSeoProperties(PageDTO) with 'page'")
  void testGatherSeoPropertiesWithPage() {
    // Arrange
    when(abstractSeoPropertyGenerator.gatherSeoProperties(Mockito.<PageDTO>any())).thenReturn(new HashMap<>());

    // Act
    Map<String, String> actualGatherSeoPropertiesResult = abstractSeoPropertyGenerator
        .gatherSeoProperties(new PageDTO());

    // Assert
    verify(abstractSeoPropertyGenerator).gatherSeoProperties(isA(PageDTO.class));
    assertTrue(actualGatherSeoPropertiesResult.isEmpty());
  }

  /**
   * Test {@link AbstractSeoPropertyGenerator#gatherSeoProperties(Product)} with
   * {@code product}.
   * <p>
   * Method under test:
   * {@link AbstractSeoPropertyGenerator#gatherSeoProperties(Product)}
   */
  @Test
  @DisplayName("Test gatherSeoProperties(Product) with 'product'")
  void testGatherSeoPropertiesWithProduct() {
    // Arrange
    when(abstractSeoPropertyGenerator.gatherSeoProperties(Mockito.<Product>any())).thenReturn(new HashMap<>());

    // Act
    Map<String, String> actualGatherSeoPropertiesResult = abstractSeoPropertyGenerator
        .gatherSeoProperties(new ProductBundleImpl());

    // Assert
    verify(abstractSeoPropertyGenerator).gatherSeoProperties(isA(Product.class));
    assertTrue(actualGatherSeoPropertiesResult.isEmpty());
  }

  /**
   * Test {@link AbstractSeoPropertyGenerator#getSimpleProperties(Category)} with
   * {@code category}.
   * <p>
   * Method under test:
   * {@link AbstractSeoPropertyGenerator#getSimpleProperties(Category)}
   */
  @Test
  @DisplayName("Test getSimpleProperties(Category) with 'category'")
  @Disabled("TODO: Complete this test")
  void testGetSimplePropertiesWithCategory() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.seo;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml","/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2174 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.seo.AbstractSeoPropertyGenerator abstractSeoPropertyGenerator;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    BasicSeoPropertyGeneratorImpl basicSeoPropertyGeneratorImpl = new BasicSeoPropertyGeneratorImpl();

    // Act
    basicSeoPropertyGeneratorImpl.getSimpleProperties(new CategoryImpl());
  }

  /**
   * Test {@link AbstractSeoPropertyGenerator#getSimpleProperties(Category)} with
   * {@code category}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractSeoPropertyGenerator#getSimpleProperties(Category)}
   */
  @Test
  @DisplayName("Test getSimpleProperties(Category) with 'category'; given HashMap()")
  void testGetSimplePropertiesWithCategory_givenHashMap() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicSeoPropertyGeneratorImpl basicSeoPropertyGeneratorImpl = new BasicSeoPropertyGeneratorImpl();
    CategoryImpl category = mock(CategoryImpl.class);
    when(category.getCategoryAttributesMap()).thenReturn(new HashMap<>());

    // Act
    Map<String, String> actualSimpleProperties = basicSeoPropertyGeneratorImpl.getSimpleProperties(category);

    // Assert
    verify(category).getCategoryAttributesMap();
    assertTrue(actualSimpleProperties.isEmpty());
  }

  /**
   * Test {@link AbstractSeoPropertyGenerator#getSimpleProperties(Category)} with
   * {@code category}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@code foo} is
   * {@link CategoryAttributeImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractSeoPropertyGenerator#getSimpleProperties(Category)}
   */
  @Test
  @DisplayName("Test getSimpleProperties(Category) with 'category'; given HashMap() 'foo' is CategoryAttributeImpl (default constructor)")
  void testGetSimplePropertiesWithCategory_givenHashMapFooIsCategoryAttributeImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicSeoPropertyGeneratorImpl basicSeoPropertyGeneratorImpl = new BasicSeoPropertyGeneratorImpl();

    HashMap<String, CategoryAttribute> stringCategoryAttributeMap = new HashMap<>();
    stringCategoryAttributeMap.put("foo", new CategoryAttributeImpl());
    CategoryImpl category = mock(CategoryImpl.class);
    when(category.getCategoryAttributesMap()).thenReturn(stringCategoryAttributeMap);

    // Act
    Map<String, String> actualSimpleProperties = basicSeoPropertyGeneratorImpl.getSimpleProperties(category);

    // Assert
    verify(category).getCategoryAttributesMap();
    assertTrue(actualSimpleProperties.isEmpty());
  }

  /**
   * Test {@link AbstractSeoPropertyGenerator#getSimpleProperties(Category)} with
   * {@code category}.
   * <ul>
   *   <li>When {@link CategoryImpl} (default constructor).</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractSeoPropertyGenerator#getSimpleProperties(Category)}
   */
  @Test
  @DisplayName("Test getSimpleProperties(Category) with 'category'; when CategoryImpl (default constructor); then return Empty")
  void testGetSimplePropertiesWithCategory_whenCategoryImpl_thenReturnEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicSeoPropertyGeneratorImpl basicSeoPropertyGeneratorImpl = new BasicSeoPropertyGeneratorImpl();

    // Act and Assert
    assertTrue(basicSeoPropertyGeneratorImpl.getSimpleProperties(new CategoryImpl()).isEmpty());
  }

  /**
   * Test {@link AbstractSeoPropertyGenerator#getSimpleProperties(PageDTO)} with
   * {@code page}.
   * <p>
   * Method under test:
   * {@link AbstractSeoPropertyGenerator#getSimpleProperties(PageDTO)}
   */
  @Test
  @DisplayName("Test getSimpleProperties(PageDTO) with 'page'")
  @Disabled("TODO: Complete this test")
  void testGetSimplePropertiesWithPage() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.seo;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml","/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2155 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.seo.AbstractSeoPropertyGenerator abstractSeoPropertyGenerator;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    BasicSeoPropertyGeneratorImpl basicSeoPropertyGeneratorImpl = new BasicSeoPropertyGeneratorImpl();

    // Act
    basicSeoPropertyGeneratorImpl.getSimpleProperties(new PageDTO());
  }

  /**
   * Test {@link AbstractSeoPropertyGenerator#getSimpleProperties(PageDTO)} with
   * {@code page}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@code foo} is {@code foo}.</li>
   *   <li>Then calls {@link PageDTO#getPageAttributes()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractSeoPropertyGenerator#getSimpleProperties(PageDTO)}
   */
  @Test
  @DisplayName("Test getSimpleProperties(PageDTO) with 'page'; given HashMap() 'foo' is 'foo'; then calls getPageAttributes()")
  void testGetSimplePropertiesWithPage_givenHashMapFooIsFoo_thenCallsGetPageAttributes() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicSeoPropertyGeneratorImpl basicSeoPropertyGeneratorImpl = new BasicSeoPropertyGeneratorImpl();

    HashMap<String, String> stringStringMap = new HashMap<>();
    stringStringMap.put("foo", "foo");
    NullPageDTO page = mock(NullPageDTO.class);
    when(page.getPageAttributes()).thenReturn(stringStringMap);

    // Act
    Map<String, String> actualSimpleProperties = basicSeoPropertyGeneratorImpl.getSimpleProperties(page);

    // Assert
    verify(page).getPageAttributes();
    assertTrue(actualSimpleProperties.isEmpty());
  }

  /**
   * Test {@link AbstractSeoPropertyGenerator#getSimpleProperties(PageDTO)} with
   * {@code page}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()}.</li>
   *   <li>Then calls {@link PageDTO#getPageAttributes()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractSeoPropertyGenerator#getSimpleProperties(PageDTO)}
   */
  @Test
  @DisplayName("Test getSimpleProperties(PageDTO) with 'page'; given HashMap(); then calls getPageAttributes()")
  void testGetSimplePropertiesWithPage_givenHashMap_thenCallsGetPageAttributes() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicSeoPropertyGeneratorImpl basicSeoPropertyGeneratorImpl = new BasicSeoPropertyGeneratorImpl();
    NullPageDTO page = mock(NullPageDTO.class);
    when(page.getPageAttributes()).thenReturn(new HashMap<>());

    // Act
    Map<String, String> actualSimpleProperties = basicSeoPropertyGeneratorImpl.getSimpleProperties(page);

    // Assert
    verify(page).getPageAttributes();
    assertTrue(actualSimpleProperties.isEmpty());
  }

  /**
   * Test {@link AbstractSeoPropertyGenerator#getSimpleProperties(PageDTO)} with
   * {@code page}.
   * <ul>
   *   <li>When {@link PageDTO} (default constructor).</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractSeoPropertyGenerator#getSimpleProperties(PageDTO)}
   */
  @Test
  @DisplayName("Test getSimpleProperties(PageDTO) with 'page'; when PageDTO (default constructor); then return Empty")
  void testGetSimplePropertiesWithPage_whenPageDTO_thenReturnEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicSeoPropertyGeneratorImpl basicSeoPropertyGeneratorImpl = new BasicSeoPropertyGeneratorImpl();

    // Act and Assert
    assertTrue(basicSeoPropertyGeneratorImpl.getSimpleProperties(new PageDTO()).isEmpty());
  }

  /**
   * Test {@link AbstractSeoPropertyGenerator#getSimpleProperties(Product)} with
   * {@code product}.
   * <p>
   * Method under test:
   * {@link AbstractSeoPropertyGenerator#getSimpleProperties(Product)}
   */
  @Test
  @DisplayName("Test getSimpleProperties(Product) with 'product'")
  @Disabled("TODO: Complete this test")
  void testGetSimplePropertiesWithProduct() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.seo;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml","/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2210 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.seo.AbstractSeoPropertyGenerator abstractSeoPropertyGenerator;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    BasicSeoPropertyGeneratorImpl basicSeoPropertyGeneratorImpl = new BasicSeoPropertyGeneratorImpl();

    // Act
    basicSeoPropertyGeneratorImpl.getSimpleProperties(new ProductBundleImpl());
  }

  /**
   * Test {@link AbstractSeoPropertyGenerator#getSimpleProperties(Product)} with
   * {@code product}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@code foo} is
   * {@link ProductAttributeImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractSeoPropertyGenerator#getSimpleProperties(Product)}
   */
  @Test
  @DisplayName("Test getSimpleProperties(Product) with 'product'; given HashMap() 'foo' is ProductAttributeImpl (default constructor)")
  void testGetSimplePropertiesWithProduct_givenHashMapFooIsProductAttributeImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicSeoPropertyGeneratorImpl basicSeoPropertyGeneratorImpl = new BasicSeoPropertyGeneratorImpl();

    HashMap<String, ProductAttribute> stringProductAttributeMap = new HashMap<>();
    stringProductAttributeMap.put("foo", new ProductAttributeImpl());
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getProductAttributes()).thenReturn(stringProductAttributeMap);

    // Act
    Map<String, String> actualSimpleProperties = basicSeoPropertyGeneratorImpl.getSimpleProperties(product);

    // Assert
    verify(product).getProductAttributes();
    assertTrue(actualSimpleProperties.isEmpty());
  }

  /**
   * Test {@link AbstractSeoPropertyGenerator#getSimpleProperties(Product)} with
   * {@code product}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()}.</li>
   *   <li>Then calls {@link ProductImpl#getProductAttributes()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractSeoPropertyGenerator#getSimpleProperties(Product)}
   */
  @Test
  @DisplayName("Test getSimpleProperties(Product) with 'product'; given HashMap(); then calls getProductAttributes()")
  void testGetSimplePropertiesWithProduct_givenHashMap_thenCallsGetProductAttributes() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicSeoPropertyGeneratorImpl basicSeoPropertyGeneratorImpl = new BasicSeoPropertyGeneratorImpl();
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getProductAttributes()).thenReturn(new HashMap<>());

    // Act
    Map<String, String> actualSimpleProperties = basicSeoPropertyGeneratorImpl.getSimpleProperties(product);

    // Assert
    verify(product).getProductAttributes();
    assertTrue(actualSimpleProperties.isEmpty());
  }

  /**
   * Test {@link AbstractSeoPropertyGenerator#getSimpleProperties(Product)} with
   * {@code product}.
   * <ul>
   *   <li>When {@link ProductBundleImpl} (default constructor).</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractSeoPropertyGenerator#getSimpleProperties(Product)}
   */
  @Test
  @DisplayName("Test getSimpleProperties(Product) with 'product'; when ProductBundleImpl (default constructor); then return Empty")
  void testGetSimplePropertiesWithProduct_whenProductBundleImpl_thenReturnEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicSeoPropertyGeneratorImpl basicSeoPropertyGeneratorImpl = new BasicSeoPropertyGeneratorImpl();

    // Act and Assert
    assertTrue(basicSeoPropertyGeneratorImpl.getSimpleProperties(new ProductBundleImpl()).isEmpty());
  }
}
