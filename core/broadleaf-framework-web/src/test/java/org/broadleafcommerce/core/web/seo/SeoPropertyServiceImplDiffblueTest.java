package org.broadleafcommerce.core.web.seo;

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
class SeoPropertyServiceImplDiffblueTest {
  @Autowired
  private SeoPropertyServiceImpl seoPropertyServiceImpl;

  /**
   * Test {@link SeoPropertyServiceImpl#getSeoProperties(Category)} with
   * {@code category}.
   * <p>
   * Method under test: {@link SeoPropertyServiceImpl#getSeoProperties(Category)}
   */
  @Test
  @DisplayName("Test getSeoProperties(Category) with 'category'")
  @Disabled("TODO: Complete this test")
  void testGetSeoPropertiesWithCategory() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.seo;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml","/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3159 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.seo.SeoPropertyServiceImpl seoPropertyServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    SeoPropertyServiceImpl seoPropertyServiceImpl2 = new SeoPropertyServiceImpl();

    // Act
    seoPropertyServiceImpl2.getSeoProperties(new CategoryImpl());
  }

  /**
   * Test {@link SeoPropertyServiceImpl#getSeoProperties(PageDTO)} with
   * {@code page}.
   * <p>
   * Method under test: {@link SeoPropertyServiceImpl#getSeoProperties(PageDTO)}
   */
  @Test
  @DisplayName("Test getSeoProperties(PageDTO) with 'page'")
  @Disabled("TODO: Complete this test")
  void testGetSeoPropertiesWithPage() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.seo;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml","/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3142 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.seo.SeoPropertyServiceImpl seoPropertyServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    SeoPropertyServiceImpl seoPropertyServiceImpl2 = new SeoPropertyServiceImpl();

    // Act
    seoPropertyServiceImpl2.getSeoProperties(new PageDTO());
  }

  /**
   * Test {@link SeoPropertyServiceImpl#getSeoProperties(Product)} with
   * {@code product}.
   * <p>
   * Method under test: {@link SeoPropertyServiceImpl#getSeoProperties(Product)}
   */
  @Test
  @DisplayName("Test getSeoProperties(Product) with 'product'")
  @Disabled("TODO: Complete this test")
  void testGetSeoPropertiesWithProduct() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.seo;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml","/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3193 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.seo.SeoPropertyServiceImpl seoPropertyServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    SeoPropertyServiceImpl seoPropertyServiceImpl2 = new SeoPropertyServiceImpl();

    // Act
    seoPropertyServiceImpl2.getSeoProperties(new ProductBundleImpl());
  }
}
