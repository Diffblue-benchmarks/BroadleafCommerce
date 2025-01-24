package org.broadleafcommerce.core.web.seo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.HashMap;
import org.broadleafcommerce.common.page.dto.NullPageDTO;
import org.broadleafcommerce.common.page.dto.PageDTO;
import org.broadleafcommerce.core.catalog.domain.Category;
import org.broadleafcommerce.core.catalog.domain.CategoryImpl;
import org.broadleafcommerce.core.catalog.domain.CategoryMediaXref;
import org.broadleafcommerce.core.catalog.domain.CategoryMediaXrefImpl;
import org.broadleafcommerce.core.catalog.domain.Product;
import org.broadleafcommerce.core.catalog.domain.ProductBundleImpl;
import org.broadleafcommerce.core.catalog.domain.SkuImpl;
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
class SeoDefaultPropertyServiceImplDiffblueTest {
  @Autowired
  private SeoDefaultPropertyServiceImpl seoDefaultPropertyServiceImpl;

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#getProductTitlePattern(Product)}.
   * <p>
   * Method under test:
   * {@link SeoDefaultPropertyServiceImpl#getProductTitlePattern(Product)}
   */
  @Test
  @DisplayName("Test getProductTitlePattern(Product)")
  void testGetProductTitlePattern() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SeoDefaultPropertyServiceImpl seoDefaultPropertyServiceImpl = new SeoDefaultPropertyServiceImpl();
    CategoryImpl categoryImpl = mock(CategoryImpl.class);
    when(categoryImpl.getProductTitlePatternOverride()).thenReturn("");
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getCategory()).thenReturn(categoryImpl);

    // Act
    String actualProductTitlePattern = seoDefaultPropertyServiceImpl.getProductTitlePattern(product);

    // Assert
    verify(categoryImpl).getProductTitlePatternOverride();
    verify(product).getCategory();
    assertEquals("", actualProductTitlePattern);
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#getProductTitlePattern(Product)}.
   * <p>
   * Method under test:
   * {@link SeoDefaultPropertyServiceImpl#getProductTitlePattern(Product)}
   */
  @Test
  @DisplayName("Test getProductTitlePattern(Product)")
  @Disabled("TODO: Complete this test")
  void testGetProductTitlePattern2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.seo;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml","/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2831 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.seo.SeoDefaultPropertyServiceImpl seoDefaultPropertyServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    SeoDefaultPropertyServiceImpl seoDefaultPropertyServiceImpl2 = new SeoDefaultPropertyServiceImpl();

    // Act
    seoDefaultPropertyServiceImpl2.getProductTitlePattern(new ProductBundleImpl());
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#getProductTitlePattern(Product)}.
   * <ul>
   *   <li>Given {@link CategoryImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SeoDefaultPropertyServiceImpl#getProductTitlePattern(Product)}
   */
  @Test
  @DisplayName("Test getProductTitlePattern(Product); given CategoryImpl (default constructor)")
  void testGetProductTitlePattern_givenCategoryImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SeoDefaultPropertyServiceImpl seoDefaultPropertyServiceImpl = new SeoDefaultPropertyServiceImpl();
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getCategory()).thenReturn(new CategoryImpl());

    // Act
    String actualProductTitlePattern = seoDefaultPropertyServiceImpl.getProductTitlePattern(product);

    // Assert
    verify(product).getCategory();
    assertEquals("", actualProductTitlePattern);
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#getProductTitlePattern(Product)}.
   * <ul>
   *   <li>Then return {@code Dr}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SeoDefaultPropertyServiceImpl#getProductTitlePattern(Product)}
   */
  @Test
  @DisplayName("Test getProductTitlePattern(Product); then return 'Dr'")
  void testGetProductTitlePattern_thenReturnDr() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SeoDefaultPropertyServiceImpl seoDefaultPropertyServiceImpl = new SeoDefaultPropertyServiceImpl();
    CategoryImpl categoryImpl = mock(CategoryImpl.class);
    when(categoryImpl.getProductTitlePatternOverride()).thenReturn("Dr");
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getCategory()).thenReturn(categoryImpl);

    // Act
    String actualProductTitlePattern = seoDefaultPropertyServiceImpl.getProductTitlePattern(product);

    // Assert
    verify(categoryImpl).getProductTitlePatternOverride();
    verify(product).getCategory();
    assertEquals("Dr", actualProductTitlePattern);
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#getProductTitlePattern(Product)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SeoDefaultPropertyServiceImpl#getProductTitlePattern(Product)}
   */
  @Test
  @DisplayName("Test getProductTitlePattern(Product); when 'null'; then return empty string")
  void testGetProductTitlePattern_whenNull_thenReturnEmptyString() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("", (new SeoDefaultPropertyServiceImpl()).getProductTitlePattern(null));
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#getProductTitlePattern(Product)}.
   * <ul>
   *   <li>When {@link ProductBundleImpl} (default constructor).</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SeoDefaultPropertyServiceImpl#getProductTitlePattern(Product)}
   */
  @Test
  @DisplayName("Test getProductTitlePattern(Product); when ProductBundleImpl (default constructor); then return empty string")
  void testGetProductTitlePattern_whenProductBundleImpl_thenReturnEmptyString() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SeoDefaultPropertyServiceImpl seoDefaultPropertyServiceImpl = new SeoDefaultPropertyServiceImpl();

    // Act and Assert
    assertEquals("", seoDefaultPropertyServiceImpl.getProductTitlePattern(new ProductBundleImpl()));
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#getCategoryTitlePattern()}.
   * <p>
   * Method under test:
   * {@link SeoDefaultPropertyServiceImpl#getCategoryTitlePattern()}
   */
  @Test
  @DisplayName("Test getCategoryTitlePattern()")
  @Disabled("TODO: Complete this test")
  void testGetCategoryTitlePattern() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.seo;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml","/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2524 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.seo.SeoDefaultPropertyServiceImpl seoDefaultPropertyServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new SeoDefaultPropertyServiceImpl()).getCategoryTitlePattern();
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#getTitle(PageDTO)}.
   * <p>
   * Method under test: {@link SeoDefaultPropertyServiceImpl#getTitle(PageDTO)}
   */
  @Test
  @DisplayName("Test getTitle(PageDTO)")
  @Disabled("TODO: Complete this test")
  void testGetTitle() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.seo;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml","/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2864 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.seo.SeoDefaultPropertyServiceImpl seoDefaultPropertyServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    SeoDefaultPropertyServiceImpl seoDefaultPropertyServiceImpl2 = new SeoDefaultPropertyServiceImpl();

    // Act
    seoDefaultPropertyServiceImpl2.getTitle(new PageDTO());
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#getTitle(PageDTO)}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()}.</li>
   *   <li>Then calls {@link PageDTO#getPageAttributes()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SeoDefaultPropertyServiceImpl#getTitle(PageDTO)}
   */
  @Test
  @DisplayName("Test getTitle(PageDTO); given HashMap(); then calls getPageAttributes()")
  void testGetTitle_givenHashMap_thenCallsGetPageAttributes() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SeoDefaultPropertyServiceImpl seoDefaultPropertyServiceImpl = new SeoDefaultPropertyServiceImpl();
    PageDTO page = mock(PageDTO.class);
    when(page.getPageAttributes()).thenReturn(new HashMap<>());

    // Act
    String actualTitle = seoDefaultPropertyServiceImpl.getTitle(page);

    // Assert
    verify(page).getPageAttributes();
    assertNull(actualTitle);
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#getTitle(PageDTO)}.
   * <ul>
   *   <li>When {@link PageDTO} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SeoDefaultPropertyServiceImpl#getTitle(PageDTO)}
   */
  @Test
  @DisplayName("Test getTitle(PageDTO); when PageDTO (default constructor); then return 'null'")
  void testGetTitle_whenPageDTO_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SeoDefaultPropertyServiceImpl seoDefaultPropertyServiceImpl = new SeoDefaultPropertyServiceImpl();

    // Act and Assert
    assertNull(seoDefaultPropertyServiceImpl.getTitle(new PageDTO()));
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#getType(Category)} with
   * {@code category}.
   * <p>
   * Method under test: {@link SeoDefaultPropertyServiceImpl#getType(Category)}
   */
  @Test
  @DisplayName("Test getType(Category) with 'category'")
  @Disabled("TODO: Complete this test")
  void testGetTypeWithCategory() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.seo;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml","/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2898 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.seo.SeoDefaultPropertyServiceImpl seoDefaultPropertyServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    SeoDefaultPropertyServiceImpl seoDefaultPropertyServiceImpl2 = new SeoDefaultPropertyServiceImpl();

    // Act
    seoDefaultPropertyServiceImpl2.getType(new CategoryImpl());
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#getType(Category)} with
   * {@code category}.
   * <ul>
   *   <li>When {@link CategoryImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link SeoDefaultPropertyServiceImpl#getType(Category)}
   */
  @Test
  @DisplayName("Test getType(Category) with 'category'; when CategoryImpl (default constructor)")
  void testGetTypeWithCategory_whenCategoryImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SeoDefaultPropertyServiceImpl seoDefaultPropertyServiceImpl = new SeoDefaultPropertyServiceImpl();

    // Act and Assert
    assertEquals("article", seoDefaultPropertyServiceImpl.getType(new CategoryImpl()));
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#getType(Category)} with
   * {@code category}.
   * <ul>
   *   <li>When {@link CategoryImpl}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SeoDefaultPropertyServiceImpl#getType(Category)}
   */
  @Test
  @DisplayName("Test getType(Category) with 'category'; when CategoryImpl")
  void testGetTypeWithCategory_whenCategoryImpl2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("article", (new SeoDefaultPropertyServiceImpl()).getType(mock(CategoryImpl.class)));
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#getType(PageDTO)} with
   * {@code page}.
   * <p>
   * Method under test: {@link SeoDefaultPropertyServiceImpl#getType(PageDTO)}
   */
  @Test
  @DisplayName("Test getType(PageDTO) with 'page'")
  @Disabled("TODO: Complete this test")
  void testGetTypeWithPage() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.seo;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml","/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2881 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.seo.SeoDefaultPropertyServiceImpl seoDefaultPropertyServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    SeoDefaultPropertyServiceImpl seoDefaultPropertyServiceImpl2 = new SeoDefaultPropertyServiceImpl();

    // Act
    seoDefaultPropertyServiceImpl2.getType(new PageDTO());
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#getType(PageDTO)} with
   * {@code page}.
   * <ul>
   *   <li>When {@link NullPageDTO}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SeoDefaultPropertyServiceImpl#getType(PageDTO)}
   */
  @Test
  @DisplayName("Test getType(PageDTO) with 'page'; when NullPageDTO")
  void testGetTypeWithPage_whenNullPageDTO() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("article", (new SeoDefaultPropertyServiceImpl()).getType(mock(NullPageDTO.class)));
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#getType(PageDTO)} with
   * {@code page}.
   * <ul>
   *   <li>When {@link PageDTO} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link SeoDefaultPropertyServiceImpl#getType(PageDTO)}
   */
  @Test
  @DisplayName("Test getType(PageDTO) with 'page'; when PageDTO (default constructor)")
  void testGetTypeWithPage_whenPageDTO() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SeoDefaultPropertyServiceImpl seoDefaultPropertyServiceImpl = new SeoDefaultPropertyServiceImpl();

    // Act and Assert
    assertEquals("article", seoDefaultPropertyServiceImpl.getType(new PageDTO()));
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#getType(Product)} with
   * {@code product}.
   * <p>
   * Method under test: {@link SeoDefaultPropertyServiceImpl#getType(Product)}
   */
  @Test
  @DisplayName("Test getType(Product) with 'product'")
  @Disabled("TODO: Complete this test")
  void testGetTypeWithProduct() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.seo;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml","/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2932 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.seo.SeoDefaultPropertyServiceImpl seoDefaultPropertyServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    SeoDefaultPropertyServiceImpl seoDefaultPropertyServiceImpl2 = new SeoDefaultPropertyServiceImpl();

    // Act
    seoDefaultPropertyServiceImpl2.getType(new ProductBundleImpl());
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#getType(Product)} with
   * {@code product}.
   * <ul>
   *   <li>When {@link ProductBundleImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link SeoDefaultPropertyServiceImpl#getType(Product)}
   */
  @Test
  @DisplayName("Test getType(Product) with 'product'; when ProductBundleImpl (default constructor)")
  void testGetTypeWithProduct_whenProductBundleImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SeoDefaultPropertyServiceImpl seoDefaultPropertyServiceImpl = new SeoDefaultPropertyServiceImpl();

    // Act and Assert
    assertEquals("product", seoDefaultPropertyServiceImpl.getType(new ProductBundleImpl()));
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#getType(Product)} with
   * {@code product}.
   * <ul>
   *   <li>When {@link ProductBundleImpl}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SeoDefaultPropertyServiceImpl#getType(Product)}
   */
  @Test
  @DisplayName("Test getType(Product) with 'product'; when ProductBundleImpl")
  void testGetTypeWithProduct_whenProductBundleImpl2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("product", (new SeoDefaultPropertyServiceImpl()).getType(mock(ProductBundleImpl.class)));
  }

  /**
   * Test
   * {@link SeoDefaultPropertyServiceImpl#getProductDescriptionPattern(Product)}.
   * <p>
   * Method under test:
   * {@link SeoDefaultPropertyServiceImpl#getProductDescriptionPattern(Product)}
   */
  @Test
  @DisplayName("Test getProductDescriptionPattern(Product)")
  void testGetProductDescriptionPattern() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SeoDefaultPropertyServiceImpl seoDefaultPropertyServiceImpl = new SeoDefaultPropertyServiceImpl();
    CategoryImpl categoryImpl = mock(CategoryImpl.class);
    when(categoryImpl.getProductDescriptionPatternOverride()).thenReturn("");
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getCategory()).thenReturn(categoryImpl);

    // Act
    String actualProductDescriptionPattern = seoDefaultPropertyServiceImpl.getProductDescriptionPattern(product);

    // Assert
    verify(categoryImpl).getProductDescriptionPatternOverride();
    verify(product).getCategory();
    assertEquals("", actualProductDescriptionPattern);
  }

  /**
   * Test
   * {@link SeoDefaultPropertyServiceImpl#getProductDescriptionPattern(Product)}.
   * <p>
   * Method under test:
   * {@link SeoDefaultPropertyServiceImpl#getProductDescriptionPattern(Product)}
   */
  @Test
  @DisplayName("Test getProductDescriptionPattern(Product)")
  @Disabled("TODO: Complete this test")
  void testGetProductDescriptionPattern2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.seo;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml","/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2797 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.seo.SeoDefaultPropertyServiceImpl seoDefaultPropertyServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    SeoDefaultPropertyServiceImpl seoDefaultPropertyServiceImpl2 = new SeoDefaultPropertyServiceImpl();

    // Act
    seoDefaultPropertyServiceImpl2.getProductDescriptionPattern(new ProductBundleImpl());
  }

  /**
   * Test
   * {@link SeoDefaultPropertyServiceImpl#getProductDescriptionPattern(Product)}.
   * <ul>
   *   <li>Given {@link CategoryImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SeoDefaultPropertyServiceImpl#getProductDescriptionPattern(Product)}
   */
  @Test
  @DisplayName("Test getProductDescriptionPattern(Product); given CategoryImpl (default constructor)")
  void testGetProductDescriptionPattern_givenCategoryImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SeoDefaultPropertyServiceImpl seoDefaultPropertyServiceImpl = new SeoDefaultPropertyServiceImpl();
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getCategory()).thenReturn(new CategoryImpl());

    // Act
    String actualProductDescriptionPattern = seoDefaultPropertyServiceImpl.getProductDescriptionPattern(product);

    // Assert
    verify(product).getCategory();
    assertEquals("", actualProductDescriptionPattern);
  }

  /**
   * Test
   * {@link SeoDefaultPropertyServiceImpl#getProductDescriptionPattern(Product)}.
   * <ul>
   *   <li>Then return {@code Product Description Pattern Override}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SeoDefaultPropertyServiceImpl#getProductDescriptionPattern(Product)}
   */
  @Test
  @DisplayName("Test getProductDescriptionPattern(Product); then return 'Product Description Pattern Override'")
  void testGetProductDescriptionPattern_thenReturnProductDescriptionPatternOverride() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SeoDefaultPropertyServiceImpl seoDefaultPropertyServiceImpl = new SeoDefaultPropertyServiceImpl();
    CategoryImpl categoryImpl = mock(CategoryImpl.class);
    when(categoryImpl.getProductDescriptionPatternOverride()).thenReturn("Product Description Pattern Override");
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getCategory()).thenReturn(categoryImpl);

    // Act
    String actualProductDescriptionPattern = seoDefaultPropertyServiceImpl.getProductDescriptionPattern(product);

    // Assert
    verify(categoryImpl).getProductDescriptionPatternOverride();
    verify(product).getCategory();
    assertEquals("Product Description Pattern Override", actualProductDescriptionPattern);
  }

  /**
   * Test
   * {@link SeoDefaultPropertyServiceImpl#getProductDescriptionPattern(Product)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SeoDefaultPropertyServiceImpl#getProductDescriptionPattern(Product)}
   */
  @Test
  @DisplayName("Test getProductDescriptionPattern(Product); when 'null'; then return empty string")
  void testGetProductDescriptionPattern_whenNull_thenReturnEmptyString() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("", (new SeoDefaultPropertyServiceImpl()).getProductDescriptionPattern(null));
  }

  /**
   * Test
   * {@link SeoDefaultPropertyServiceImpl#getProductDescriptionPattern(Product)}.
   * <ul>
   *   <li>When {@link ProductBundleImpl} (default constructor).</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SeoDefaultPropertyServiceImpl#getProductDescriptionPattern(Product)}
   */
  @Test
  @DisplayName("Test getProductDescriptionPattern(Product); when ProductBundleImpl (default constructor); then return empty string")
  void testGetProductDescriptionPattern_whenProductBundleImpl_thenReturnEmptyString() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SeoDefaultPropertyServiceImpl seoDefaultPropertyServiceImpl = new SeoDefaultPropertyServiceImpl();

    // Act and Assert
    assertEquals("", seoDefaultPropertyServiceImpl.getProductDescriptionPattern(new ProductBundleImpl()));
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#getCategoryDescriptionPattern()}.
   * <p>
   * Method under test:
   * {@link SeoDefaultPropertyServiceImpl#getCategoryDescriptionPattern()}
   */
  @Test
  @DisplayName("Test getCategoryDescriptionPattern()")
  @Disabled("TODO: Complete this test")
  void testGetCategoryDescriptionPattern() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.seo;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml","/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2522 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.seo.SeoDefaultPropertyServiceImpl seoDefaultPropertyServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new SeoDefaultPropertyServiceImpl()).getCategoryDescriptionPattern();
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#getDescription(PageDTO)}.
   * <p>
   * Method under test:
   * {@link SeoDefaultPropertyServiceImpl#getDescription(PageDTO)}
   */
  @Test
  @DisplayName("Test getDescription(PageDTO)")
  @Disabled("TODO: Complete this test")
  void testGetDescription() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.seo;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml","/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2527 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.seo.SeoDefaultPropertyServiceImpl seoDefaultPropertyServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    SeoDefaultPropertyServiceImpl seoDefaultPropertyServiceImpl2 = new SeoDefaultPropertyServiceImpl();

    // Act
    seoDefaultPropertyServiceImpl2.getDescription(new PageDTO());
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#getDescription(PageDTO)}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()}.</li>
   *   <li>Then calls {@link PageDTO#getPageAttributes()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SeoDefaultPropertyServiceImpl#getDescription(PageDTO)}
   */
  @Test
  @DisplayName("Test getDescription(PageDTO); given HashMap(); then calls getPageAttributes()")
  void testGetDescription_givenHashMap_thenCallsGetPageAttributes() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SeoDefaultPropertyServiceImpl seoDefaultPropertyServiceImpl = new SeoDefaultPropertyServiceImpl();
    PageDTO page = mock(PageDTO.class);
    when(page.getPageAttributes()).thenReturn(new HashMap<>());

    // Act
    String actualDescription = seoDefaultPropertyServiceImpl.getDescription(page);

    // Assert
    verify(page).getPageAttributes();
    assertNull(actualDescription);
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#getDescription(PageDTO)}.
   * <ul>
   *   <li>When {@link PageDTO} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SeoDefaultPropertyServiceImpl#getDescription(PageDTO)}
   */
  @Test
  @DisplayName("Test getDescription(PageDTO); when PageDTO (default constructor); then return 'null'")
  void testGetDescription_whenPageDTO_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SeoDefaultPropertyServiceImpl seoDefaultPropertyServiceImpl = new SeoDefaultPropertyServiceImpl();

    // Act and Assert
    assertNull(seoDefaultPropertyServiceImpl.getDescription(new PageDTO()));
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#getUrl(Category)} with
   * {@code category}.
   * <p>
   * Method under test: {@link SeoDefaultPropertyServiceImpl#getUrl(Category)}
   */
  @Test
  @DisplayName("Test getUrl(Category) with 'category'")
  @Disabled("TODO: Complete this test")
  void testGetUrlWithCategory() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.seo;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml","/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2982 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.seo.SeoDefaultPropertyServiceImpl seoDefaultPropertyServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    SeoDefaultPropertyServiceImpl seoDefaultPropertyServiceImpl2 = new SeoDefaultPropertyServiceImpl();

    // Act
    seoDefaultPropertyServiceImpl2.getUrl(new CategoryImpl());
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#getUrl(PageDTO)} with {@code page}.
   * <p>
   * Method under test: {@link SeoDefaultPropertyServiceImpl#getUrl(PageDTO)}
   */
  @Test
  @DisplayName("Test getUrl(PageDTO) with 'page'")
  @Disabled("TODO: Complete this test")
  void testGetUrlWithPage() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.seo;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml","/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2965 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.seo.SeoDefaultPropertyServiceImpl seoDefaultPropertyServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    SeoDefaultPropertyServiceImpl seoDefaultPropertyServiceImpl2 = new SeoDefaultPropertyServiceImpl();

    // Act
    seoDefaultPropertyServiceImpl2.getUrl(new PageDTO());
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#getUrl(Product)} with
   * {@code product}.
   * <p>
   * Method under test: {@link SeoDefaultPropertyServiceImpl#getUrl(Product)}
   */
  @Test
  @DisplayName("Test getUrl(Product) with 'product'")
  @Disabled("TODO: Complete this test")
  void testGetUrlWithProduct() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.seo;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml","/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3016 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.seo.SeoDefaultPropertyServiceImpl seoDefaultPropertyServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    SeoDefaultPropertyServiceImpl seoDefaultPropertyServiceImpl2 = new SeoDefaultPropertyServiceImpl();

    // Act
    seoDefaultPropertyServiceImpl2.getUrl(new ProductBundleImpl());
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#getImage(Category)} with
   * {@code category}.
   * <p>
   * Method under test: {@link SeoDefaultPropertyServiceImpl#getImage(Category)}
   */
  @Test
  @DisplayName("Test getImage(Category) with 'category'")
  @Disabled("TODO: Complete this test")
  void testGetImageWithCategory() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.seo;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml","/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2561 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.seo.SeoDefaultPropertyServiceImpl seoDefaultPropertyServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    SeoDefaultPropertyServiceImpl seoDefaultPropertyServiceImpl2 = new SeoDefaultPropertyServiceImpl();

    // Act
    seoDefaultPropertyServiceImpl2.getImage(new CategoryImpl());
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#getImage(Category)} with
   * {@code category}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SeoDefaultPropertyServiceImpl#getImage(Category)}
   */
  @Test
  @DisplayName("Test getImage(Category) with 'category'; given HashMap(); then return 'null'")
  void testGetImageWithCategory_givenHashMap_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SeoDefaultPropertyServiceImpl seoDefaultPropertyServiceImpl = new SeoDefaultPropertyServiceImpl();
    Category category = mock(Category.class);
    when(category.getCategoryMediaXref()).thenReturn(new HashMap<>());

    // Act
    String actualImage = seoDefaultPropertyServiceImpl.getImage(category);

    // Assert
    verify(category).getCategoryMediaXref();
    assertNull(actualImage);
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#getImage(Category)} with
   * {@code category}.
   * <ul>
   *   <li>Then throw {@link NumberFormatException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SeoDefaultPropertyServiceImpl#getImage(Category)}
   */
  @Test
  @DisplayName("Test getImage(Category) with 'category'; then throw NumberFormatException")
  void testGetImageWithCategory_thenThrowNumberFormatException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SeoDefaultPropertyServiceImpl seoDefaultPropertyServiceImpl = new SeoDefaultPropertyServiceImpl();
    CategoryMediaXrefImpl categoryMediaXrefImpl = mock(CategoryMediaXrefImpl.class);
    when(categoryMediaXrefImpl.getMedia()).thenThrow(new NumberFormatException("foo"));

    HashMap<String, CategoryMediaXref> stringCategoryMediaXrefMap = new HashMap<>();
    stringCategoryMediaXrefMap.put("primary", categoryMediaXrefImpl);
    Category category = mock(Category.class);
    when(category.getCategoryMediaXref()).thenReturn(stringCategoryMediaXrefMap);

    // Act and Assert
    assertThrows(NumberFormatException.class, () -> seoDefaultPropertyServiceImpl.getImage(category));
    verify(category).getCategoryMediaXref();
    verify(categoryMediaXrefImpl).getMedia();
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#getImage(Category)} with
   * {@code category}.
   * <ul>
   *   <li>When {@link CategoryImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SeoDefaultPropertyServiceImpl#getImage(Category)}
   */
  @Test
  @DisplayName("Test getImage(Category) with 'category'; when CategoryImpl (default constructor); then return 'null'")
  void testGetImageWithCategory_whenCategoryImpl_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SeoDefaultPropertyServiceImpl seoDefaultPropertyServiceImpl = new SeoDefaultPropertyServiceImpl();

    // Act and Assert
    assertNull(seoDefaultPropertyServiceImpl.getImage(new CategoryImpl()));
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#getImage(PageDTO)} with
   * {@code page}.
   * <p>
   * Method under test: {@link SeoDefaultPropertyServiceImpl#getImage(PageDTO)}
   */
  @Test
  @DisplayName("Test getImage(PageDTO) with 'page'")
  @Disabled("TODO: Complete this test")
  void testGetImageWithPage() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.seo;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml","/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2544 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.seo.SeoDefaultPropertyServiceImpl seoDefaultPropertyServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    SeoDefaultPropertyServiceImpl seoDefaultPropertyServiceImpl2 = new SeoDefaultPropertyServiceImpl();

    // Act
    seoDefaultPropertyServiceImpl2.getImage(new PageDTO());
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#getImage(PageDTO)} with
   * {@code page}.
   * <ul>
   *   <li>When {@link NullPageDTO}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SeoDefaultPropertyServiceImpl#getImage(PageDTO)}
   */
  @Test
  @DisplayName("Test getImage(PageDTO) with 'page'; when NullPageDTO")
  void testGetImageWithPage_whenNullPageDTO() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new SeoDefaultPropertyServiceImpl()).getImage(mock(NullPageDTO.class)));
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#getImage(PageDTO)} with
   * {@code page}.
   * <ul>
   *   <li>When {@link PageDTO} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link SeoDefaultPropertyServiceImpl#getImage(PageDTO)}
   */
  @Test
  @DisplayName("Test getImage(PageDTO) with 'page'; when PageDTO (default constructor)")
  void testGetImageWithPage_whenPageDTO() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SeoDefaultPropertyServiceImpl seoDefaultPropertyServiceImpl = new SeoDefaultPropertyServiceImpl();

    // Act and Assert
    assertNull(seoDefaultPropertyServiceImpl.getImage(new PageDTO()));
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#getImage(Product)} with
   * {@code product}.
   * <p>
   * Method under test: {@link SeoDefaultPropertyServiceImpl#getImage(Product)}
   */
  @Test
  @DisplayName("Test getImage(Product) with 'product'")
  @Disabled("TODO: Complete this test")
  void testGetImageWithProduct() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.seo;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml","/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2595 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.seo.SeoDefaultPropertyServiceImpl seoDefaultPropertyServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    SeoDefaultPropertyServiceImpl seoDefaultPropertyServiceImpl2 = new SeoDefaultPropertyServiceImpl();

    // Act
    seoDefaultPropertyServiceImpl2.getImage(new ProductBundleImpl());
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#getImage(Product)} with
   * {@code product}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SeoDefaultPropertyServiceImpl#getImage(Product)}
   */
  @Test
  @DisplayName("Test getImage(Product) with 'product'; given SkuImpl (default constructor); then return 'null'")
  void testGetImageWithProduct_givenSkuImpl_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SeoDefaultPropertyServiceImpl seoDefaultPropertyServiceImpl = new SeoDefaultPropertyServiceImpl();
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getDefaultSku()).thenReturn(new SkuImpl());

    // Act
    String actualImage = seoDefaultPropertyServiceImpl.getImage(product);

    // Assert
    verify(product).getDefaultSku();
    assertNull(actualImage);
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#getCanonicalUrl(Category)} with
   * {@code category}.
   * <p>
   * Method under test:
   * {@link SeoDefaultPropertyServiceImpl#getCanonicalUrl(Category)}
   */
  @Test
  @DisplayName("Test getCanonicalUrl(Category) with 'category'")
  @Disabled("TODO: Complete this test")
  void testGetCanonicalUrlWithCategory() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.seo;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml","/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2378 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.seo.SeoDefaultPropertyServiceImpl seoDefaultPropertyServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    SeoDefaultPropertyServiceImpl seoDefaultPropertyServiceImpl2 = new SeoDefaultPropertyServiceImpl();

    // Act
    seoDefaultPropertyServiceImpl2.getCanonicalUrl(new CategoryImpl());
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#getCanonicalUrl(Category, int)}
   * with {@code category}, {@code pageNumber}.
   * <p>
   * Method under test:
   * {@link SeoDefaultPropertyServiceImpl#getCanonicalUrl(Category, int)}
   */
  @Test
  @DisplayName("Test getCanonicalUrl(Category, int) with 'category', 'pageNumber'")
  @Disabled("TODO: Complete this test")
  void testGetCanonicalUrlWithCategoryPageNumber() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.seo;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml","/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2412 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.seo.SeoDefaultPropertyServiceImpl seoDefaultPropertyServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    SeoDefaultPropertyServiceImpl seoDefaultPropertyServiceImpl2 = new SeoDefaultPropertyServiceImpl();

    // Act
    seoDefaultPropertyServiceImpl2.getCanonicalUrl(new CategoryImpl(), 10);
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#getCanonicalUrl(Product)} with
   * {@code product}.
   * <p>
   * Method under test:
   * {@link SeoDefaultPropertyServiceImpl#getCanonicalUrl(Product)}
   */
  @Test
  @DisplayName("Test getCanonicalUrl(Product) with 'product'")
  @Disabled("TODO: Complete this test")
  void testGetCanonicalUrlWithProduct() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.seo;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml","/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2451 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.seo.SeoDefaultPropertyServiceImpl seoDefaultPropertyServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    SeoDefaultPropertyServiceImpl seoDefaultPropertyServiceImpl2 = new SeoDefaultPropertyServiceImpl();

    // Act
    seoDefaultPropertyServiceImpl2.getCanonicalUrl(new ProductBundleImpl());
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#getCanonicalUrl(Product, int)} with
   * {@code product}, {@code pageNumber}.
   * <p>
   * Method under test:
   * {@link SeoDefaultPropertyServiceImpl#getCanonicalUrl(Product, int)}
   */
  @Test
  @DisplayName("Test getCanonicalUrl(Product, int) with 'product', 'pageNumber'")
  @Disabled("TODO: Complete this test")
  void testGetCanonicalUrlWithProductPageNumber() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.seo;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml","/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2484 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.seo.SeoDefaultPropertyServiceImpl seoDefaultPropertyServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    SeoDefaultPropertyServiceImpl seoDefaultPropertyServiceImpl2 = new SeoDefaultPropertyServiceImpl();

    // Act
    seoDefaultPropertyServiceImpl2.getCanonicalUrl(new ProductBundleImpl(), 10);
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#getPaginationPrevUrl(Category)}
   * with {@code category}.
   * <p>
   * Method under test:
   * {@link SeoDefaultPropertyServiceImpl#getPaginationPrevUrl(Category)}
   */
  @Test
  @DisplayName("Test getPaginationPrevUrl(Category) with 'category'")
  @Disabled("TODO: Complete this test")
  void testGetPaginationPrevUrlWithCategory() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.seo;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml","/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2730 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.seo.SeoDefaultPropertyServiceImpl seoDefaultPropertyServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    SeoDefaultPropertyServiceImpl seoDefaultPropertyServiceImpl2 = new SeoDefaultPropertyServiceImpl();

    // Act
    seoDefaultPropertyServiceImpl2.getPaginationPrevUrl(new CategoryImpl());
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#getPaginationPrevUrl(Product)} with
   * {@code product}.
   * <p>
   * Method under test:
   * {@link SeoDefaultPropertyServiceImpl#getPaginationPrevUrl(Product)}
   */
  @Test
  @DisplayName("Test getPaginationPrevUrl(Product) with 'product'")
  @Disabled("TODO: Complete this test")
  void testGetPaginationPrevUrlWithProduct() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.seo;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml","/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2764 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.seo.SeoDefaultPropertyServiceImpl seoDefaultPropertyServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    SeoDefaultPropertyServiceImpl seoDefaultPropertyServiceImpl2 = new SeoDefaultPropertyServiceImpl();

    // Act
    seoDefaultPropertyServiceImpl2.getPaginationPrevUrl(new ProductBundleImpl());
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#getPaginationNextUrl(Category)}
   * with {@code category}.
   * <p>
   * Method under test:
   * {@link SeoDefaultPropertyServiceImpl#getPaginationNextUrl(Category)}
   */
  @Test
  @DisplayName("Test getPaginationNextUrl(Category) with 'category'")
  @Disabled("TODO: Complete this test")
  void testGetPaginationNextUrlWithCategory() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.seo;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml","/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2663 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.seo.SeoDefaultPropertyServiceImpl seoDefaultPropertyServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    SeoDefaultPropertyServiceImpl seoDefaultPropertyServiceImpl2 = new SeoDefaultPropertyServiceImpl();

    // Act
    seoDefaultPropertyServiceImpl2.getPaginationNextUrl(new CategoryImpl());
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#getPaginationNextUrl(Product)} with
   * {@code product}.
   * <p>
   * Method under test:
   * {@link SeoDefaultPropertyServiceImpl#getPaginationNextUrl(Product)}
   */
  @Test
  @DisplayName("Test getPaginationNextUrl(Product) with 'product'")
  @Disabled("TODO: Complete this test")
  void testGetPaginationNextUrlWithProduct() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.seo;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml","/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2697 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.seo.SeoDefaultPropertyServiceImpl seoDefaultPropertyServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    SeoDefaultPropertyServiceImpl seoDefaultPropertyServiceImpl2 = new SeoDefaultPropertyServiceImpl();

    // Act
    seoDefaultPropertyServiceImpl2.getPaginationNextUrl(new ProductBundleImpl());
  }

  /**
   * Test
   * {@link SeoDefaultPropertyServiceImpl#shouldIncludeProductPagination(int)}.
   * <p>
   * Method under test:
   * {@link SeoDefaultPropertyServiceImpl#shouldIncludeProductPagination(int)}
   */
  @Test
  @DisplayName("Test shouldIncludeProductPagination(int)")
  @Disabled("TODO: Complete this test")
  void testShouldIncludeProductPagination() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.seo;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml","/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3136 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.seo.SeoDefaultPropertyServiceImpl seoDefaultPropertyServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new SeoDefaultPropertyServiceImpl()).shouldIncludeProductPagination(10);
  }

  /**
   * Test
   * {@link SeoDefaultPropertyServiceImpl#shouldIncludeCategoryPagination(int)}.
   * <p>
   * Method under test:
   * {@link SeoDefaultPropertyServiceImpl#shouldIncludeCategoryPagination(int)}
   */
  @Test
  @DisplayName("Test shouldIncludeCategoryPagination(int)")
  @Disabled("TODO: Complete this test")
  void testShouldIncludeCategoryPagination() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.seo;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml","/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3130 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.seo.SeoDefaultPropertyServiceImpl seoDefaultPropertyServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new SeoDefaultPropertyServiceImpl()).shouldIncludeCategoryPagination(10);
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#isValidPrevPageNumber(Integer)}.
   * <p>
   * Method under test:
   * {@link SeoDefaultPropertyServiceImpl#isValidPrevPageNumber(Integer)}
   */
  @Test
  @DisplayName("Test isValidPrevPageNumber(Integer)")
  @Disabled("TODO: Complete this test")
  void testIsValidPrevPageNumber() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.seo;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml","/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3124 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.seo.SeoDefaultPropertyServiceImpl seoDefaultPropertyServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new SeoDefaultPropertyServiceImpl()).isValidPrevPageNumber(10);
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#isValidPrevPageNumber(Integer)}.
   * <ul>
   *   <li>When ten.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SeoDefaultPropertyServiceImpl#isValidPrevPageNumber(Integer)}
   */
  @Test
  @DisplayName("Test isValidPrevPageNumber(Integer); when ten; then return 'true'")
  void testIsValidPrevPageNumber_whenTen_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new SeoDefaultPropertyServiceImpl()).isValidPrevPageNumber(10));
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#isValidPrevPageNumber(Integer)}.
   * <ul>
   *   <li>When zero.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SeoDefaultPropertyServiceImpl#isValidPrevPageNumber(Integer)}
   */
  @Test
  @DisplayName("Test isValidPrevPageNumber(Integer); when zero; then return 'false'")
  void testIsValidPrevPageNumber_whenZero_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new SeoDefaultPropertyServiceImpl()).isValidPrevPageNumber(0));
  }

  /**
   * Test
   * {@link SeoDefaultPropertyServiceImpl#isValidNextPageNumber(Category, Integer)}
   * with {@code category}, {@code pageNumber}.
   * <p>
   * Method under test:
   * {@link SeoDefaultPropertyServiceImpl#isValidNextPageNumber(Category, Integer)}
   */
  @Test
  @DisplayName("Test isValidNextPageNumber(Category, Integer) with 'category', 'pageNumber'")
  @Disabled("TODO: Complete this test")
  void testIsValidNextPageNumberWithCategoryPageNumber() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.seo;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml","/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3049 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.seo.SeoDefaultPropertyServiceImpl seoDefaultPropertyServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    SeoDefaultPropertyServiceImpl seoDefaultPropertyServiceImpl2 = new SeoDefaultPropertyServiceImpl();

    // Act
    seoDefaultPropertyServiceImpl2.isValidNextPageNumber(new CategoryImpl(), 10);
  }

  /**
   * Test
   * {@link SeoDefaultPropertyServiceImpl#isValidNextPageNumber(Product, Integer)}
   * with {@code product}, {@code pageNumber}.
   * <p>
   * Method under test:
   * {@link SeoDefaultPropertyServiceImpl#isValidNextPageNumber(Product, Integer)}
   */
  @Test
  @DisplayName("Test isValidNextPageNumber(Product, Integer) with 'product', 'pageNumber'")
  @Disabled("TODO: Complete this test")
  void testIsValidNextPageNumberWithProductPageNumber() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.seo;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml","/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3087 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.seo.SeoDefaultPropertyServiceImpl seoDefaultPropertyServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    SeoDefaultPropertyServiceImpl seoDefaultPropertyServiceImpl2 = new SeoDefaultPropertyServiceImpl();

    // Act
    seoDefaultPropertyServiceImpl2.isValidNextPageNumber(new ProductBundleImpl(), 10);
  }

  /**
   * Test
   * {@link SeoDefaultPropertyServiceImpl#isValidNextPageNumber(Product, Integer)}
   * with {@code product}, {@code pageNumber}.
   * <ul>
   *   <li>When {@link ProductBundleImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SeoDefaultPropertyServiceImpl#isValidNextPageNumber(Product, Integer)}
   */
  @Test
  @DisplayName("Test isValidNextPageNumber(Product, Integer) with 'product', 'pageNumber'; when ProductBundleImpl (default constructor)")
  void testIsValidNextPageNumberWithProductPageNumber_whenProductBundleImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SeoDefaultPropertyServiceImpl seoDefaultPropertyServiceImpl = new SeoDefaultPropertyServiceImpl();

    // Act and Assert
    assertTrue(seoDefaultPropertyServiceImpl.isValidNextPageNumber(new ProductBundleImpl(), 10));
  }

  /**
   * Test
   * {@link SeoDefaultPropertyServiceImpl#isValidNextPageNumber(Product, Integer)}
   * with {@code product}, {@code pageNumber}.
   * <ul>
   *   <li>When {@link ProductBundleImpl}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SeoDefaultPropertyServiceImpl#isValidNextPageNumber(Product, Integer)}
   */
  @Test
  @DisplayName("Test isValidNextPageNumber(Product, Integer) with 'product', 'pageNumber'; when ProductBundleImpl")
  void testIsValidNextPageNumberWithProductPageNumber_whenProductBundleImpl2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new SeoDefaultPropertyServiceImpl()).isValidNextPageNumber(mock(ProductBundleImpl.class), 10));
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#getPageCount(Category)}.
   * <p>
   * Method under test:
   * {@link SeoDefaultPropertyServiceImpl#getPageCount(Category)}
   */
  @Test
  @DisplayName("Test getPageCount(Category)")
  @Disabled("TODO: Complete this test")
  void testGetPageCount() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.seo;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml","/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2628 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.seo.SeoDefaultPropertyServiceImpl seoDefaultPropertyServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    SeoDefaultPropertyServiceImpl seoDefaultPropertyServiceImpl2 = new SeoDefaultPropertyServiceImpl();

    // Act
    seoDefaultPropertyServiceImpl2.getPageCount(new CategoryImpl());
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#getCurrentProductPageNumber()}.
   * <p>
   * Method under test:
   * {@link SeoDefaultPropertyServiceImpl#getCurrentProductPageNumber()}
   */
  @Test
  @DisplayName("Test getCurrentProductPageNumber()")
  @Disabled("TODO: Complete this test")
  void testGetCurrentProductPageNumber() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.seo;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml","/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2526 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.seo.SeoDefaultPropertyServiceImpl seoDefaultPropertyServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new SeoDefaultPropertyServiceImpl()).getCurrentProductPageNumber();
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#getCurrentCategoryPageNumber()}.
   * <p>
   * Method under test:
   * {@link SeoDefaultPropertyServiceImpl#getCurrentCategoryPageNumber()}
   */
  @Test
  @DisplayName("Test getCurrentCategoryPageNumber()")
  @Disabled("TODO: Complete this test")
  void testGetCurrentCategoryPageNumber() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.seo;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml","/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2525 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.seo.SeoDefaultPropertyServiceImpl seoDefaultPropertyServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new SeoDefaultPropertyServiceImpl()).getCurrentCategoryPageNumber();
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#productPaginationIsEnabled()}.
   * <p>
   * Method under test:
   * {@link SeoDefaultPropertyServiceImpl#productPaginationIsEnabled()}
   */
  @Test
  @DisplayName("Test productPaginationIsEnabled()")
  @Disabled("TODO: Complete this test")
  void testProductPaginationIsEnabled() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.seo;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml","/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3129 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.seo.SeoDefaultPropertyServiceImpl seoDefaultPropertyServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new SeoDefaultPropertyServiceImpl()).productPaginationIsEnabled();
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#getProductPaginationParam()}.
   * <p>
   * Method under test:
   * {@link SeoDefaultPropertyServiceImpl#getProductPaginationParam()}
   */
  @Test
  @DisplayName("Test getProductPaginationParam()")
  @Disabled("TODO: Complete this test")
  void testGetProductPaginationParam() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.seo;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml","/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2830 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.seo.SeoDefaultPropertyServiceImpl seoDefaultPropertyServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new SeoDefaultPropertyServiceImpl()).getProductPaginationParam();
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#getCategoryPaginationParam()}.
   * <p>
   * Method under test:
   * {@link SeoDefaultPropertyServiceImpl#getCategoryPaginationParam()}
   */
  @Test
  @DisplayName("Test getCategoryPaginationParam()")
  @Disabled("TODO: Complete this test")
  void testGetCategoryPaginationParam() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.seo;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml","/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2523 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.seo.SeoDefaultPropertyServiceImpl seoDefaultPropertyServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new SeoDefaultPropertyServiceImpl()).getCategoryPaginationParam();
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#getPageSize()}.
   * <p>
   * Method under test: {@link SeoDefaultPropertyServiceImpl#getPageSize()}
   */
  @Test
  @DisplayName("Test getPageSize()")
  @Disabled("TODO: Complete this test")
  void testGetPageSize() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.seo;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml","/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2662 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.seo.SeoDefaultPropertyServiceImpl seoDefaultPropertyServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new SeoDefaultPropertyServiceImpl()).getPageSize();
  }
}
