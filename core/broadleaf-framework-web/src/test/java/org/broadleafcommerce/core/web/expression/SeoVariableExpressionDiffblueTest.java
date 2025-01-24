package org.broadleafcommerce.core.web.expression;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
class SeoVariableExpressionDiffblueTest {
  @Autowired
  private SeoVariableExpression seoVariableExpression;

  /**
   * Test {@link SeoVariableExpression#getName()}.
   * <p>
   * Method under test: {@link SeoVariableExpression#getName()}
   */
  @Test
  @DisplayName("Test getName()")
  void testGetName() {
    // Arrange, Act and Assert
    assertEquals("seo", (new SeoVariableExpression()).getName());
  }

  /**
   * Test {@link SeoVariableExpression#getMetaProperties(Category)} with
   * {@code category}.
   * <p>
   * Method under test: {@link SeoVariableExpression#getMetaProperties(Category)}
   */
  @Test
  @DisplayName("Test getMetaProperties(Category) with 'category'")
  @Disabled("TODO: Complete this test")
  void testGetMetaPropertiesWithCategory() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.expression;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml","/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3421 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.expression.SeoVariableExpression seoVariableExpression;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    SeoVariableExpression seoVariableExpression2 = new SeoVariableExpression();

    // Act
    seoVariableExpression2.getMetaProperties(new CategoryImpl());
  }

  /**
   * Test {@link SeoVariableExpression#getMetaProperties(PageDTO)} with
   * {@code page}.
   * <p>
   * Method under test: {@link SeoVariableExpression#getMetaProperties(PageDTO)}
   */
  @Test
  @DisplayName("Test getMetaProperties(PageDTO) with 'page'")
  @Disabled("TODO: Complete this test")
  void testGetMetaPropertiesWithPage() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.expression;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml","/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3404 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.expression.SeoVariableExpression seoVariableExpression;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    SeoVariableExpression seoVariableExpression2 = new SeoVariableExpression();

    // Act
    seoVariableExpression2.getMetaProperties(new PageDTO());
  }

  /**
   * Test {@link SeoVariableExpression#getMetaProperties(Product)} with
   * {@code product}.
   * <p>
   * Method under test: {@link SeoVariableExpression#getMetaProperties(Product)}
   */
  @Test
  @DisplayName("Test getMetaProperties(Product) with 'product'")
  @Disabled("TODO: Complete this test")
  void testGetMetaPropertiesWithProduct() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.expression;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml","/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3455 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.expression.SeoVariableExpression seoVariableExpression;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    SeoVariableExpression seoVariableExpression2 = new SeoVariableExpression();

    // Act
    seoVariableExpression2.getMetaProperties(new ProductBundleImpl());
  }
}
