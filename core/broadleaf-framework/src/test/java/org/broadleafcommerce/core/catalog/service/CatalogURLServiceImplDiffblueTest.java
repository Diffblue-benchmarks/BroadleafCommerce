package org.broadleafcommerce.core.catalog.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.broadleafcommerce.core.catalog.domain.Category;
import org.broadleafcommerce.core.catalog.domain.CategoryImpl;
import org.broadleafcommerce.core.catalog.domain.Product;
import org.broadleafcommerce.core.catalog.domain.ProductBundleImpl;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml",
    "/bl-framework-applicationContext-persistence.xml", "/bl-framework-applicationContext-workflow.xml",
    "/bl-framework-applicationContext.xml", "/blc-config/admin/framework/bl-framework-admin-applicationContext.xml",
    "/blc-config/site/framework/bl-framework-applicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class CatalogURLServiceImplDiffblueTest {
  @Autowired
  private CatalogURLServiceImpl catalogURLServiceImpl;

  /**
   * Test {@link CatalogURLServiceImpl#buildRelativeProductURL(String, Product)}.
   * <p>
   * Method under test:
   * {@link CatalogURLServiceImpl#buildRelativeProductURL(String, Product)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testBuildRelativeProductURL() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.catalog.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass5355 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.catalog.service.CatalogURLServiceImpl catalogURLServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    CatalogURLServiceImpl catalogURLServiceImpl2 = new CatalogURLServiceImpl();

    // Act
    catalogURLServiceImpl2.buildRelativeProductURL("https://example.org/example", new ProductBundleImpl());
  }

  /**
   * Test {@link CatalogURLServiceImpl#buildRelativeProductURL(String, Product)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>When {@code Current Url}.</li>
   *   <li>Then return {@code Current Url}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CatalogURLServiceImpl#buildRelativeProductURL(String, Product)}
   */
  @Test
  public void testBuildRelativeProductURL_givenOne_whenCurrentUrl_thenReturnCurrentUrl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CatalogURLServiceImpl catalogURLServiceImpl = new CatalogURLServiceImpl();
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getId()).thenReturn(1L);
    when(product.getUrl()).thenReturn("https://example.org/example");

    // Act
    String actualBuildRelativeProductURLResult = catalogURLServiceImpl.buildRelativeProductURL("Current Url", product);

    // Assert
    verify(product).getId();
    verify(product).getUrl();
    assertEquals("Current Url", actualBuildRelativeProductURLResult);
  }

  /**
   * Test {@link CatalogURLServiceImpl#buildRelativeProductURL(String, Product)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>When empty string.</li>
   *   <li>Then return {@code /example}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CatalogURLServiceImpl#buildRelativeProductURL(String, Product)}
   */
  @Test
  public void testBuildRelativeProductURL_givenOne_whenEmptyString_thenReturnExample() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CatalogURLServiceImpl catalogURLServiceImpl = new CatalogURLServiceImpl();
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getId()).thenReturn(1L);
    when(product.getUrl()).thenReturn("https://example.org/example");

    // Act
    String actualBuildRelativeProductURLResult = catalogURLServiceImpl.buildRelativeProductURL("", product);

    // Assert
    verify(product).getId();
    verify(product).getUrl();
    assertEquals("/example", actualBuildRelativeProductURLResult);
  }

  /**
   * Test {@link CatalogURLServiceImpl#buildRelativeProductURL(String, Product)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>When {@code /}.</li>
   *   <li>Then return {@code /example}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CatalogURLServiceImpl#buildRelativeProductURL(String, Product)}
   */
  @Test
  public void testBuildRelativeProductURL_givenOne_whenSlash_thenReturnExample() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CatalogURLServiceImpl catalogURLServiceImpl = new CatalogURLServiceImpl();
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getId()).thenReturn(1L);
    when(product.getUrl()).thenReturn("https://example.org/example");

    // Act
    String actualBuildRelativeProductURLResult = catalogURLServiceImpl.buildRelativeProductURL("/", product);

    // Assert
    verify(product).getId();
    verify(product).getUrl();
    assertEquals("/example", actualBuildRelativeProductURLResult);
  }

  /**
   * Test {@link CatalogURLServiceImpl#buildRelativeProductURL(String, Product)}.
   * <ul>
   *   <li>Then return {@code https://example.org/example/example}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CatalogURLServiceImpl#buildRelativeProductURL(String, Product)}
   */
  @Test
  public void testBuildRelativeProductURL_thenReturnHttpsExampleOrgExampleExample() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CatalogURLServiceImpl catalogURLServiceImpl = new CatalogURLServiceImpl();
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getId()).thenReturn(1L);
    when(product.getUrl()).thenReturn("https://example.org/example");

    // Act
    String actualBuildRelativeProductURLResult = catalogURLServiceImpl
        .buildRelativeProductURL("https://example.org/example", product);

    // Assert
    verify(product).getId();
    verify(product).getUrl();
    assertEquals("https://example.org/example/example", actualBuildRelativeProductURLResult);
  }

  /**
   * Test
   * {@link CatalogURLServiceImpl#buildRelativeCategoryURL(String, Category)}.
   * <p>
   * Method under test:
   * {@link CatalogURLServiceImpl#buildRelativeCategoryURL(String, Category)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testBuildRelativeCategoryURL() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.catalog.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass5325 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.catalog.service.CatalogURLServiceImpl catalogURLServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    CatalogURLServiceImpl catalogURLServiceImpl2 = new CatalogURLServiceImpl();

    // Act
    catalogURLServiceImpl2.buildRelativeCategoryURL("https://example.org/example", new CategoryImpl());
  }

  /**
   * Test
   * {@link CatalogURLServiceImpl#buildRelativeCategoryURL(String, Category)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>When {@code Current Url}.</li>
   *   <li>Then return {@code Current Url}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CatalogURLServiceImpl#buildRelativeCategoryURL(String, Category)}
   */
  @Test
  public void testBuildRelativeCategoryURL_givenOne_whenCurrentUrl_thenReturnCurrentUrl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CatalogURLServiceImpl catalogURLServiceImpl = new CatalogURLServiceImpl();
    CategoryImpl category = mock(CategoryImpl.class);
    when(category.getId()).thenReturn(1L);
    when(category.getUrl()).thenReturn("https://example.org/example");

    // Act
    String actualBuildRelativeCategoryURLResult = catalogURLServiceImpl.buildRelativeCategoryURL("Current Url",
        category);

    // Assert
    verify(category).getId();
    verify(category).getUrl();
    assertEquals("Current Url", actualBuildRelativeCategoryURLResult);
  }

  /**
   * Test
   * {@link CatalogURLServiceImpl#buildRelativeCategoryURL(String, Category)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>When empty string.</li>
   *   <li>Then return {@code /example}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CatalogURLServiceImpl#buildRelativeCategoryURL(String, Category)}
   */
  @Test
  public void testBuildRelativeCategoryURL_givenOne_whenEmptyString_thenReturnExample() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CatalogURLServiceImpl catalogURLServiceImpl = new CatalogURLServiceImpl();
    CategoryImpl category = mock(CategoryImpl.class);
    when(category.getId()).thenReturn(1L);
    when(category.getUrl()).thenReturn("https://example.org/example");

    // Act
    String actualBuildRelativeCategoryURLResult = catalogURLServiceImpl.buildRelativeCategoryURL("", category);

    // Assert
    verify(category).getId();
    verify(category).getUrl();
    assertEquals("/example", actualBuildRelativeCategoryURLResult);
  }

  /**
   * Test
   * {@link CatalogURLServiceImpl#buildRelativeCategoryURL(String, Category)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>When {@code /}.</li>
   *   <li>Then return {@code /example}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CatalogURLServiceImpl#buildRelativeCategoryURL(String, Category)}
   */
  @Test
  public void testBuildRelativeCategoryURL_givenOne_whenSlash_thenReturnExample() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CatalogURLServiceImpl catalogURLServiceImpl = new CatalogURLServiceImpl();
    CategoryImpl category = mock(CategoryImpl.class);
    when(category.getId()).thenReturn(1L);
    when(category.getUrl()).thenReturn("https://example.org/example");

    // Act
    String actualBuildRelativeCategoryURLResult = catalogURLServiceImpl.buildRelativeCategoryURL("/", category);

    // Assert
    verify(category).getId();
    verify(category).getUrl();
    assertEquals("/example", actualBuildRelativeCategoryURLResult);
  }

  /**
   * Test
   * {@link CatalogURLServiceImpl#buildRelativeCategoryURL(String, Category)}.
   * <ul>
   *   <li>Then return {@code https://example.org/example/example}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CatalogURLServiceImpl#buildRelativeCategoryURL(String, Category)}
   */
  @Test
  public void testBuildRelativeCategoryURL_thenReturnHttpsExampleOrgExampleExample() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CatalogURLServiceImpl catalogURLServiceImpl = new CatalogURLServiceImpl();
    CategoryImpl category = mock(CategoryImpl.class);
    when(category.getId()).thenReturn(1L);
    when(category.getUrl()).thenReturn("https://example.org/example");

    // Act
    String actualBuildRelativeCategoryURLResult = catalogURLServiceImpl
        .buildRelativeCategoryURL("https://example.org/example", category);

    // Assert
    verify(category).getId();
    verify(category).getUrl();
    assertEquals("https://example.org/example/example", actualBuildRelativeCategoryURLResult);
  }

  /**
   * Test
   * {@link CatalogURLServiceImpl#buildRelativeUrlWithParam(String, String, String, String)}.
   * <p>
   * Method under test:
   * {@link CatalogURLServiceImpl#buildRelativeUrlWithParam(String, String, String, String)}
   */
  @Test
  public void testBuildRelativeUrlWithParam() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("https://example.org/example/https://example.org/example",
        (new CatalogURLServiceImpl()).buildRelativeUrlWithParam("https://example.org/example",
            "https://example.org/example", "https://example.org/example", "https://example.org/example"));
  }

  /**
   * Test
   * {@link CatalogURLServiceImpl#buildRelativeUrlWithParam(String, String, String, String)}.
   * <p>
   * Method under test:
   * {@link CatalogURLServiceImpl#buildRelativeUrlWithParam(String, String, String, String)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testBuildRelativeUrlWithParam2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.catalog.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass5385 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.catalog.service.CatalogURLServiceImpl catalogURLServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new CatalogURLServiceImpl()).buildRelativeUrlWithParam("https://example.org/example",
        "https://example.org/example", "https://example.org/example", "https://example.org/example");
  }

  /**
   * Test
   * {@link CatalogURLServiceImpl#buildRelativeUrlWithParam(String, String, String, String)}.
   * <ul>
   *   <li>When {@code Current Url}.</li>
   *   <li>Then return {@code Current Url}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CatalogURLServiceImpl#buildRelativeUrlWithParam(String, String, String, String)}
   */
  @Test
  public void testBuildRelativeUrlWithParam_whenCurrentUrl_thenReturnCurrentUrl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("Current Url", (new CatalogURLServiceImpl()).buildRelativeUrlWithParam("Current Url",
        "https://example.org/example", "https://example.org/example", "https://example.org/example"));
  }

  /**
   * Test
   * {@link CatalogURLServiceImpl#buildRelativeUrlWithParam(String, String, String, String)}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then return {@code /https://example.org/example}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CatalogURLServiceImpl#buildRelativeUrlWithParam(String, String, String, String)}
   */
  @Test
  public void testBuildRelativeUrlWithParam_whenEmptyString_thenReturnHttpsExampleOrgExample() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("/https://example.org/example", (new CatalogURLServiceImpl()).buildRelativeUrlWithParam("",
        "https://example.org/example", "https://example.org/example", "https://example.org/example"));
  }

  /**
   * Test
   * {@link CatalogURLServiceImpl#buildRelativeUrlWithParam(String, String, String, String)}.
   * <ul>
   *   <li>When {@code /}.</li>
   *   <li>Then return {@code /https://example.org/example}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CatalogURLServiceImpl#buildRelativeUrlWithParam(String, String, String, String)}
   */
  @Test
  public void testBuildRelativeUrlWithParam_whenSlash_thenReturnHttpsExampleOrgExample() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("/https://example.org/example", (new CatalogURLServiceImpl()).buildRelativeUrlWithParam("/",
        "https://example.org/example", "https://example.org/example", "https://example.org/example"));
  }

  /**
   * Test
   * {@link CatalogURLServiceImpl#buildRelativeUrlWithParam(String, String, String, String)}.
   * <ul>
   *   <li>When {@code /}.</li>
   *   <li>Then return {@code /}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CatalogURLServiceImpl#buildRelativeUrlWithParam(String, String, String, String)}
   */
  @Test
  public void testBuildRelativeUrlWithParam_whenSlash_thenReturnSlash() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("/", (new CatalogURLServiceImpl()).buildRelativeUrlWithParam("/", "/", "https://example.org/example",
        "https://example.org/example"));
  }

  /**
   * Test {@link CatalogURLServiceImpl#getProductUrlFragment(Product)}.
   * <p>
   * Method under test:
   * {@link CatalogURLServiceImpl#getProductUrlFragment(Product)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetProductUrlFragment() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.catalog.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass5462 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.catalog.service.CatalogURLServiceImpl catalogURLServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    CatalogURLServiceImpl catalogURLServiceImpl2 = new CatalogURLServiceImpl();

    // Act
    catalogURLServiceImpl2.getProductUrlFragment(new ProductBundleImpl());
  }

  /**
   * Test {@link CatalogURLServiceImpl#getProductUrlFragment(Product)}.
   * <ul>
   *   <li>Given {@code https://example.org/example}.</li>
   *   <li>Then return {@code example}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CatalogURLServiceImpl#getProductUrlFragment(Product)}
   */
  @Test
  public void testGetProductUrlFragment_givenHttpsExampleOrgExample_thenReturnExample() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CatalogURLServiceImpl catalogURLServiceImpl = new CatalogURLServiceImpl();
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getUrl()).thenReturn("https://example.org/example");

    // Act
    String actualProductUrlFragment = catalogURLServiceImpl.getProductUrlFragment(product);

    // Assert
    verify(product).getUrl();
    assertEquals("example", actualProductUrlFragment);
  }

  /**
   * Test {@link CatalogURLServiceImpl#getCategoryUrlFragment(Category)}.
   * <p>
   * Method under test:
   * {@link CatalogURLServiceImpl#getCategoryUrlFragment(Category)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetCategoryUrlFragment() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.catalog.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass5402 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.catalog.service.CatalogURLServiceImpl catalogURLServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    CatalogURLServiceImpl catalogURLServiceImpl2 = new CatalogURLServiceImpl();

    // Act
    catalogURLServiceImpl2.getCategoryUrlFragment(new CategoryImpl());
  }

  /**
   * Test {@link CatalogURLServiceImpl#getCategoryUrlFragment(Category)}.
   * <ul>
   *   <li>Given {@code https://example.org/example}.</li>
   *   <li>Then return {@code example}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CatalogURLServiceImpl#getCategoryUrlFragment(Category)}
   */
  @Test
  public void testGetCategoryUrlFragment_givenHttpsExampleOrgExample_thenReturnExample() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CatalogURLServiceImpl catalogURLServiceImpl = new CatalogURLServiceImpl();
    CategoryImpl category = mock(CategoryImpl.class);
    when(category.getUrl()).thenReturn("https://example.org/example");

    // Act
    String actualCategoryUrlFragment = catalogURLServiceImpl.getCategoryUrlFragment(category);

    // Assert
    verify(category).getUrl();
    assertEquals("example", actualCategoryUrlFragment);
  }

  /**
   * Test {@link CatalogURLServiceImpl#getLastFragment(String)}.
   * <p>
   * Method under test: {@link CatalogURLServiceImpl#getLastFragment(String)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetLastFragment() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.catalog.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass5432 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.catalog.service.CatalogURLServiceImpl catalogURLServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new CatalogURLServiceImpl()).getLastFragment("https://example.org/example");
  }

  /**
   * Test {@link CatalogURLServiceImpl#getLastFragment(String)}.
   * <ul>
   *   <li>When {@code https://example.org/example}.</li>
   *   <li>Then return {@code example}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CatalogURLServiceImpl#getLastFragment(String)}
   */
  @Test
  public void testGetLastFragment_whenHttpsExampleOrgExample_thenReturnExample() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("example", (new CatalogURLServiceImpl()).getLastFragment("https://example.org/example"));
  }
}
