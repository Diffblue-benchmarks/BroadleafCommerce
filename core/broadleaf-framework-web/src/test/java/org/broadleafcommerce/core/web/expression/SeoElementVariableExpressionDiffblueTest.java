package org.broadleafcommerce.core.web.expression;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.core.catalog.domain.Category;
import org.broadleafcommerce.core.catalog.domain.CategoryImpl;
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
class SeoElementVariableExpressionDiffblueTest {
  @Autowired
  private SeoElementVariableExpression seoElementVariableExpression;

  /**
   * Test {@link SeoElementVariableExpression#getName()}.
   * <p>
   * Method under test: {@link SeoElementVariableExpression#getName()}
   */
  @Test
  @DisplayName("Test getName()")
  void testGetName() {
    // Arrange, Act and Assert
    assertEquals("seoElement", (new SeoElementVariableExpression()).getName());
  }

  /**
   * Test {@link SeoElementVariableExpression#getSiteSimpleURL()}.
   * <p>
   * Method under test: {@link SeoElementVariableExpression#getSiteSimpleURL()}
   */
  @Test
  @DisplayName("Test getSiteSimpleURL()")
  @Disabled("TODO: Complete this test")
  void testGetSiteSimpleURL() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.expression;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml","/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3336 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.expression.SeoElementVariableExpression seoElementVariableExpression;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new SeoElementVariableExpression()).getSiteSimpleURL();
  }

  /**
   * Test {@link SeoElementVariableExpression#getTitle(Category)} with
   * {@code category}.
   * <p>
   * Method under test: {@link SeoElementVariableExpression#getTitle(Category)}
   */
  @Test
  @DisplayName("Test getTitle(Category) with 'category'")
  @Disabled("TODO: Complete this test")
  void testGetTitleWithCategory() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.expression;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml","/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3337 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.expression.SeoElementVariableExpression seoElementVariableExpression;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    SeoElementVariableExpression seoElementVariableExpression2 = new SeoElementVariableExpression();

    // Act
    seoElementVariableExpression2.getTitle(new CategoryImpl());
  }

  /**
   * Test {@link SeoElementVariableExpression#getTitle(Category)} with
   * {@code category}.
   * <ul>
   *   <li>Given {@code Dr}.</li>
   *   <li>When {@link Category} {@link Category#getMetaTitle()} return
   * {@code Dr}.</li>
   *   <li>Then return {@code Dr}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SeoElementVariableExpression#getTitle(Category)}
   */
  @Test
  @DisplayName("Test getTitle(Category) with 'category'; given 'Dr'; when Category getMetaTitle() return 'Dr'; then return 'Dr'")
  void testGetTitleWithCategory_givenDr_whenCategoryGetMetaTitleReturnDr_thenReturnDr() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SeoElementVariableExpression seoElementVariableExpression = new SeoElementVariableExpression();
    Category category = mock(Category.class);
    when(category.getMetaTitle()).thenReturn("Dr");

    // Act
    String actualTitle = seoElementVariableExpression.getTitle(category);

    // Assert
    verify(category).getMetaTitle();
    assertEquals("Dr", actualTitle);
  }

  /**
   * Test {@link SeoElementVariableExpression#getTitle(Category)} with
   * {@code category}.
   * <ul>
   *   <li>Given empty string.</li>
   *   <li>Then return {@code Name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SeoElementVariableExpression#getTitle(Category)}
   */
  @Test
  @DisplayName("Test getTitle(Category) with 'category'; given empty string; then return 'Name'")
  void testGetTitleWithCategory_givenEmptyString_thenReturnName() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SeoElementVariableExpression seoElementVariableExpression = new SeoElementVariableExpression();
    Category category = mock(Category.class);
    when(category.getMetaTitle()).thenReturn("");
    when(category.getName()).thenReturn("Name");

    // Act
    String actualTitle = seoElementVariableExpression.getTitle(category);

    // Assert
    verify(category).getMetaTitle();
    verify(category).getName();
    assertEquals("Name", actualTitle);
  }

  /**
   * Test {@link SeoElementVariableExpression#getTitle(Category)} with
   * {@code category}.
   * <ul>
   *   <li>When {@link CategoryImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SeoElementVariableExpression#getTitle(Category)}
   */
  @Test
  @DisplayName("Test getTitle(Category) with 'category'; when CategoryImpl (default constructor); then return 'null'")
  void testGetTitleWithCategory_whenCategoryImpl_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SeoElementVariableExpression seoElementVariableExpression = new SeoElementVariableExpression();

    // Act and Assert
    assertNull(seoElementVariableExpression.getTitle(new CategoryImpl()));
  }

  /**
   * Test {@link SeoElementVariableExpression#getTitle(Product)} with
   * {@code product}.
   * <p>
   * Method under test: {@link SeoElementVariableExpression#getTitle(Product)}
   */
  @Test
  @DisplayName("Test getTitle(Product) with 'product'")
  @Disabled("TODO: Complete this test")
  void testGetTitleWithProduct() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.expression;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml","/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3371 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.expression.SeoElementVariableExpression seoElementVariableExpression;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    SeoElementVariableExpression seoElementVariableExpression2 = new SeoElementVariableExpression();

    // Act
    seoElementVariableExpression2.getTitle(new ProductBundleImpl());
  }

  /**
   * Test {@link SeoElementVariableExpression#getTitle(Product)} with
   * {@code product}.
   * <ul>
   *   <li>Given {@code Dr}.</li>
   *   <li>Then return {@code Dr}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SeoElementVariableExpression#getTitle(Product)}
   */
  @Test
  @DisplayName("Test getTitle(Product) with 'product'; given 'Dr'; then return 'Dr'")
  void testGetTitleWithProduct_givenDr_thenReturnDr() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SeoElementVariableExpression seoElementVariableExpression = new SeoElementVariableExpression();
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getMetaTitle()).thenReturn("Dr");

    // Act
    String actualTitle = seoElementVariableExpression.getTitle(product);

    // Assert
    verify(product).getMetaTitle();
    assertEquals("Dr", actualTitle);
  }

  /**
   * Test {@link SeoElementVariableExpression#getTitle(Product)} with
   * {@code product}.
   * <ul>
   *   <li>Given empty string.</li>
   *   <li>Then return {@code Name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SeoElementVariableExpression#getTitle(Product)}
   */
  @Test
  @DisplayName("Test getTitle(Product) with 'product'; given empty string; then return 'Name'")
  void testGetTitleWithProduct_givenEmptyString_thenReturnName() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SeoElementVariableExpression seoElementVariableExpression = new SeoElementVariableExpression();
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getMetaTitle()).thenReturn("");
    when(product.getName()).thenReturn("Name");

    // Act
    String actualTitle = seoElementVariableExpression.getTitle(product);

    // Assert
    verify(product).getMetaTitle();
    verify(product).getName();
    assertEquals("Name", actualTitle);
  }

  /**
   * Test {@link SeoElementVariableExpression#getTitle(Product)} with
   * {@code product}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) SalePrice is
   * {@link Money#Money()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SeoElementVariableExpression#getTitle(Product)}
   */
  @Test
  @DisplayName("Test getTitle(Product) with 'product'; given SkuImpl (default constructor) SalePrice is Money(); then return 'null'")
  void testGetTitleWithProduct_givenSkuImplSalePriceIsMoney_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SeoElementVariableExpression seoElementVariableExpression = new SeoElementVariableExpression();

    SkuImpl defaultSku = new SkuImpl();
    defaultSku.setSalePrice(new Money());

    ProductBundleImpl product = new ProductBundleImpl();
    product.setDefaultSku(defaultSku);

    // Act and Assert
    assertNull(seoElementVariableExpression.getTitle(product));
  }

  /**
   * Test {@link SeoElementVariableExpression#getTitle(Product)} with
   * {@code product}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SeoElementVariableExpression#getTitle(Product)}
   */
  @Test
  @DisplayName("Test getTitle(Product) with 'product'; given SkuImpl (default constructor); then return 'null'")
  void testGetTitleWithProduct_givenSkuImpl_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SeoElementVariableExpression seoElementVariableExpression = new SeoElementVariableExpression();

    ProductBundleImpl product = new ProductBundleImpl();
    product.setDefaultSku(new SkuImpl());

    // Act and Assert
    assertNull(seoElementVariableExpression.getTitle(product));
  }

  /**
   * Test {@link SeoElementVariableExpression#getDescription(Category)} with
   * {@code category}.
   * <p>
   * Method under test:
   * {@link SeoElementVariableExpression#getDescription(Category)}
   */
  @Test
  @DisplayName("Test getDescription(Category) with 'category'")
  @Disabled("TODO: Complete this test")
  void testGetDescriptionWithCategory() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.expression;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml","/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3269 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.expression.SeoElementVariableExpression seoElementVariableExpression;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    SeoElementVariableExpression seoElementVariableExpression2 = new SeoElementVariableExpression();

    // Act
    seoElementVariableExpression2.getDescription(new CategoryImpl());
  }

  /**
   * Test {@link SeoElementVariableExpression#getDescription(Category)} with
   * {@code category}.
   * <ul>
   *   <li>Given empty string.</li>
   *   <li>Then return {@code Long Description}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SeoElementVariableExpression#getDescription(Category)}
   */
  @Test
  @DisplayName("Test getDescription(Category) with 'category'; given empty string; then return 'Long Description'")
  void testGetDescriptionWithCategory_givenEmptyString_thenReturnLongDescription() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SeoElementVariableExpression seoElementVariableExpression = new SeoElementVariableExpression();
    Category category = mock(Category.class);
    when(category.getLongDescription()).thenReturn("Long Description");
    when(category.getMetaDescription()).thenReturn("");

    // Act
    String actualDescription = seoElementVariableExpression.getDescription(category);

    // Assert
    verify(category).getLongDescription();
    verify(category).getMetaDescription();
    assertEquals("Long Description", actualDescription);
  }

  /**
   * Test {@link SeoElementVariableExpression#getDescription(Category)} with
   * {@code category}.
   * <ul>
   *   <li>Given {@code Meta Description}.</li>
   *   <li>Then return {@code Meta Description}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SeoElementVariableExpression#getDescription(Category)}
   */
  @Test
  @DisplayName("Test getDescription(Category) with 'category'; given 'Meta Description'; then return 'Meta Description'")
  void testGetDescriptionWithCategory_givenMetaDescription_thenReturnMetaDescription() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SeoElementVariableExpression seoElementVariableExpression = new SeoElementVariableExpression();
    Category category = mock(Category.class);
    when(category.getLongDescription()).thenReturn("Long Description");
    when(category.getMetaDescription()).thenReturn("Meta Description");

    // Act
    String actualDescription = seoElementVariableExpression.getDescription(category);

    // Assert
    verify(category).getLongDescription();
    verify(category).getMetaDescription();
    assertEquals("Meta Description", actualDescription);
  }

  /**
   * Test {@link SeoElementVariableExpression#getDescription(Category)} with
   * {@code category}.
   * <ul>
   *   <li>When {@link CategoryImpl} (default constructor).</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SeoElementVariableExpression#getDescription(Category)}
   */
  @Test
  @DisplayName("Test getDescription(Category) with 'category'; when CategoryImpl (default constructor); then return empty string")
  void testGetDescriptionWithCategory_whenCategoryImpl_thenReturnEmptyString() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SeoElementVariableExpression seoElementVariableExpression = new SeoElementVariableExpression();

    // Act and Assert
    assertEquals("", seoElementVariableExpression.getDescription(new CategoryImpl()));
  }

  /**
   * Test {@link SeoElementVariableExpression#getDescription(Product)} with
   * {@code product}.
   * <p>
   * Method under test:
   * {@link SeoElementVariableExpression#getDescription(Product)}
   */
  @Test
  @DisplayName("Test getDescription(Product) with 'product'")
  void testGetDescriptionWithProduct() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SeoElementVariableExpression seoElementVariableExpression = new SeoElementVariableExpression();
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getLongDescription()).thenReturn("");
    when(product.getMetaDescription()).thenReturn("");

    // Act
    String actualDescription = seoElementVariableExpression.getDescription(product);

    // Assert
    verify(product).getLongDescription();
    verify(product).getMetaDescription();
    assertEquals("", actualDescription);
  }

  /**
   * Test {@link SeoElementVariableExpression#getDescription(Product)} with
   * {@code product}.
   * <p>
   * Method under test:
   * {@link SeoElementVariableExpression#getDescription(Product)}
   */
  @Test
  @DisplayName("Test getDescription(Product) with 'product'")
  @Disabled("TODO: Complete this test")
  void testGetDescriptionWithProduct2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.expression;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml","/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3303 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.expression.SeoElementVariableExpression seoElementVariableExpression;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    SeoElementVariableExpression seoElementVariableExpression2 = new SeoElementVariableExpression();

    // Act
    seoElementVariableExpression2.getDescription(new ProductBundleImpl());
  }

  /**
   * Test {@link SeoElementVariableExpression#getDescription(Product)} with
   * {@code product}.
   * <ul>
   *   <li>Given {@code Long Description}.</li>
   *   <li>Then return {@code Long Description}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SeoElementVariableExpression#getDescription(Product)}
   */
  @Test
  @DisplayName("Test getDescription(Product) with 'product'; given 'Long Description'; then return 'Long Description'")
  void testGetDescriptionWithProduct_givenLongDescription_thenReturnLongDescription() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SeoElementVariableExpression seoElementVariableExpression = new SeoElementVariableExpression();
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getLongDescription()).thenReturn("Long Description");
    when(product.getMetaDescription()).thenReturn("");

    // Act
    String actualDescription = seoElementVariableExpression.getDescription(product);

    // Assert
    verify(product).getLongDescription();
    verify(product).getMetaDescription();
    assertEquals("Long Description", actualDescription);
  }

  /**
   * Test {@link SeoElementVariableExpression#getDescription(Product)} with
   * {@code product}.
   * <ul>
   *   <li>Given {@code Meta Description}.</li>
   *   <li>Then return {@code Meta Description}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SeoElementVariableExpression#getDescription(Product)}
   */
  @Test
  @DisplayName("Test getDescription(Product) with 'product'; given 'Meta Description'; then return 'Meta Description'")
  void testGetDescriptionWithProduct_givenMetaDescription_thenReturnMetaDescription() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SeoElementVariableExpression seoElementVariableExpression = new SeoElementVariableExpression();
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getLongDescription()).thenReturn("Long Description");
    when(product.getMetaDescription()).thenReturn("Meta Description");

    // Act
    String actualDescription = seoElementVariableExpression.getDescription(product);

    // Assert
    verify(product).getLongDescription();
    verify(product).getMetaDescription();
    assertEquals("Meta Description", actualDescription);
  }

  /**
   * Test {@link SeoElementVariableExpression#getDescription(Product)} with
   * {@code product}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SeoElementVariableExpression#getDescription(Product)}
   */
  @Test
  @DisplayName("Test getDescription(Product) with 'product'; given SkuImpl (default constructor)")
  void testGetDescriptionWithProduct_givenSkuImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SeoElementVariableExpression seoElementVariableExpression = new SeoElementVariableExpression();

    ProductBundleImpl product = new ProductBundleImpl();
    product.setDefaultSku(new SkuImpl());

    // Act and Assert
    assertEquals("", seoElementVariableExpression.getDescription(product));
  }

  /**
   * Test {@link SeoElementVariableExpression#getDescription(Product)} with
   * {@code product}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) SalePrice is
   * {@link Money#Money()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SeoElementVariableExpression#getDescription(Product)}
   */
  @Test
  @DisplayName("Test getDescription(Product) with 'product'; given SkuImpl (default constructor) SalePrice is Money()")
  void testGetDescriptionWithProduct_givenSkuImplSalePriceIsMoney() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SeoElementVariableExpression seoElementVariableExpression = new SeoElementVariableExpression();

    SkuImpl defaultSku = new SkuImpl();
    defaultSku.setSalePrice(new Money());

    ProductBundleImpl product = new ProductBundleImpl();
    product.setDefaultSku(defaultSku);

    // Act and Assert
    assertEquals("", seoElementVariableExpression.getDescription(product));
  }

  /**
   * Test {@link SeoElementVariableExpression#buildTitleString(List, String)}.
   * <p>
   * Method under test:
   * {@link SeoElementVariableExpression#buildTitleString(List, String)}
   */
  @Test
  @DisplayName("Test buildTitleString(List, String)")
  @Disabled("TODO: Complete this test")
  void testBuildTitleString() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.expression;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml","/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3261 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.expression.SeoElementVariableExpression seoElementVariableExpression;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    SeoElementVariableExpression seoElementVariableExpression2 = new SeoElementVariableExpression();

    // Act
    seoElementVariableExpression2.buildTitleString(new ArrayList<>(), "Element Delimiter");
  }

  /**
   * Test {@link SeoElementVariableExpression#buildTitleString(List, String)}.
   * <ul>
   *   <li>Given {@code foo}.</li>
   *   <li>Then return {@code fooElement Delimiterseo.site.simple.url}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SeoElementVariableExpression#buildTitleString(List, String)}
   */
  @Test
  @DisplayName("Test buildTitleString(List, String); given 'foo'; then return 'fooElement Delimiterseo.site.simple.url'")
  void testBuildTitleString_givenFoo_thenReturnFooElementDelimiterseoSiteSimpleUrl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SeoElementVariableExpression seoElementVariableExpression = new SeoElementVariableExpression();

    ArrayList<String> titleElements = new ArrayList<>();
    titleElements.add("foo");
    titleElements.add("seo.site.simple.url");

    // Act and Assert
    assertEquals("fooElement Delimiterseo.site.simple.url",
        seoElementVariableExpression.buildTitleString(titleElements, "Element Delimiter"));
  }

  /**
   * Test {@link SeoElementVariableExpression#buildTitleString(List, String)}.
   * <ul>
   *   <li>Given {@code seo.site.simple.url}.</li>
   *   <li>Then return {@code seo.site.simple.url}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SeoElementVariableExpression#buildTitleString(List, String)}
   */
  @Test
  @DisplayName("Test buildTitleString(List, String); given 'seo.site.simple.url'; then return 'seo.site.simple.url'")
  void testBuildTitleString_givenSeoSiteSimpleUrl_thenReturnSeoSiteSimpleUrl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SeoElementVariableExpression seoElementVariableExpression = new SeoElementVariableExpression();

    ArrayList<String> titleElements = new ArrayList<>();
    titleElements.add("seo.site.simple.url");

    // Act and Assert
    assertEquals("seo.site.simple.url",
        seoElementVariableExpression.buildTitleString(titleElements, "Element Delimiter"));
  }
}
