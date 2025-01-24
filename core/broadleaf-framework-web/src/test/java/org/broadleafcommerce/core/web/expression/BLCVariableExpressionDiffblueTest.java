package org.broadleafcommerce.core.web.expression;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
class BLCVariableExpressionDiffblueTest {
  @Autowired
  private BLCVariableExpression bLCVariableExpression;

  /**
   * Test {@link BLCVariableExpression#getName()}.
   * <p>
   * Method under test: {@link BLCVariableExpression#getName()}
   */
  @Test
  @DisplayName("Test getName()")
  void testGetName() {
    // Arrange, Act and Assert
    assertEquals("blc", (new BLCVariableExpression()).getName());
  }

  /**
   * Test {@link BLCVariableExpression#relativeURL(String, Category)} with
   * {@code baseUrl}, {@code category}.
   * <p>
   * Method under test:
   * {@link BLCVariableExpression#relativeURL(String, Category)}
   */
  @Test
  @DisplayName("Test relativeURL(String, Category) with 'baseUrl', 'category'")
  @Disabled("TODO: Complete this test")
  void testRelativeURLWithBaseUrlCategory() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.expression;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml","/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2334 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.expression.BLCVariableExpression bLCVariableExpression;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    BLCVariableExpression blcVariableExpression = new BLCVariableExpression();

    // Act
    blcVariableExpression.relativeURL("https://example.org/example", new CategoryImpl());
  }

  /**
   * Test {@link BLCVariableExpression#relativeURL(String, Product)} with
   * {@code baseUrl}, {@code product}.
   * <p>
   * Method under test: {@link BLCVariableExpression#relativeURL(String, Product)}
   */
  @Test
  @DisplayName("Test relativeURL(String, Product) with 'baseUrl', 'product'")
  @Disabled("TODO: Complete this test")
  void testRelativeURLWithBaseUrlProduct() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.expression;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml","/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2372 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.expression.BLCVariableExpression bLCVariableExpression;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    BLCVariableExpression blcVariableExpression = new BLCVariableExpression();

    // Act
    blcVariableExpression.relativeURL("https://example.org/example", new ProductBundleImpl());
  }

  /**
   * Test {@link BLCVariableExpression#relativeURL(Category)} with
   * {@code category}.
   * <p>
   * Method under test: {@link BLCVariableExpression#relativeURL(Category)}
   */
  @Test
  @DisplayName("Test relativeURL(Category) with 'category'")
  @Disabled("TODO: Complete this test")
  void testRelativeURLWithCategory() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.expression;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml","/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2409 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.expression.BLCVariableExpression bLCVariableExpression;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    BLCVariableExpression blcVariableExpression = new BLCVariableExpression();

    // Act
    blcVariableExpression.relativeURL(new CategoryImpl());
  }

  /**
   * Test {@link BLCVariableExpression#relativeURL(Product)} with {@code product}.
   * <p>
   * Method under test: {@link BLCVariableExpression#relativeURL(Product)}
   */
  @Test
  @DisplayName("Test relativeURL(Product) with 'product'")
  @Disabled("TODO: Complete this test")
  void testRelativeURLWithProduct() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.expression;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml","/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2444 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.expression.BLCVariableExpression bLCVariableExpression;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    BLCVariableExpression blcVariableExpression = new BLCVariableExpression();

    // Act
    blcVariableExpression.relativeURL(new ProductBundleImpl());
  }

  /**
   * Test {@link BLCVariableExpression#getCurrentUrl()}.
   * <p>
   * Method under test: {@link BLCVariableExpression#getCurrentUrl()}
   */
  @Test
  @DisplayName("Test getCurrentUrl()")
  void testGetCurrentUrl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("", (new BLCVariableExpression()).getCurrentUrl());
  }

  /**
   * Test {@link BLCVariableExpression#getCurrentUrl()}.
   * <p>
   * Method under test: {@link BLCVariableExpression#getCurrentUrl()}
   */
  @Test
  @DisplayName("Test getCurrentUrl()")
  @Disabled("TODO: Complete this test")
  void testGetCurrentUrl2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.expression;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml","/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2291 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.expression.BLCVariableExpression bLCVariableExpression;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new BLCVariableExpression()).getCurrentUrl();
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   * <p>
   * Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName("Test getPrice(String)")
  @Disabled("TODO: Complete this test")
  void testGetPrice() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.expression;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml","/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2293 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.expression.BLCVariableExpression bLCVariableExpression;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new BLCVariableExpression()).getPrice("10");
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   * <ul>
   *   <li>Given {@link BLCVariableExpression} (default constructor).</li>
   *   <li>When {@code 10Amount}.</li>
   *   <li>Then return {@code £10.00}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName("Test getPrice(String); given BLCVariableExpression (default constructor); when '10Amount'; then return '£10.00'")
  void testGetPrice_givenBLCVariableExpression_when10Amount_thenReturn1000() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("£10.00", (new BLCVariableExpression()).getPrice("10Amount"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   * <ul>
   *   <li>Given {@link BLCVariableExpression} (default constructor).</li>
   *   <li>When {@code 10[^\d.]+}.</li>
   *   <li>Then return {@code £10.00}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName("Test getPrice(String); given BLCVariableExpression (default constructor); when '10[^\\d.]+'; then return '£10.00'")
  void testGetPrice_givenBLCVariableExpression_when10D_thenReturn1000() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("£10.00", (new BLCVariableExpression()).getPrice("10[^\\d.]+"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   * <ul>
   *   <li>Given {@link BLCVariableExpression} (default constructor).</li>
   *   <li>When {@code 10}.</li>
   *   <li>Then return {@code £10.00}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName("Test getPrice(String); given BLCVariableExpression (default constructor); when '10'; then return '£10.00'")
  void testGetPrice_givenBLCVariableExpression_when10_thenReturn1000() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("£10.00", (new BLCVariableExpression()).getPrice("10"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   * <ul>
   *   <li>Given {@link BLCVariableExpression} (default constructor).</li>
   *   <li>When {@code 10currency.default}.</li>
   *   <li>Then return {@code £10.00}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName("Test getPrice(String); given BLCVariableExpression (default constructor); when '10currency.default'; then return '£10.00'")
  void testGetPrice_givenBLCVariableExpression_when10currencyDefault_thenReturn1000() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("£10.00", (new BLCVariableExpression()).getPrice("10currency.default"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   * <ul>
   *   <li>Given {@link BLCVariableExpression} (default constructor).</li>
   *   <li>When {@code 10true}.</li>
   *   <li>Then return {@code £10.00}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName("Test getPrice(String); given BLCVariableExpression (default constructor); when '10true'; then return '£10.00'")
  void testGetPrice_givenBLCVariableExpression_when10true_thenReturn1000() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("£10.00", (new BLCVariableExpression()).getPrice("10true"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   * <ul>
   *   <li>Given {@link BLCVariableExpression} (default constructor).</li>
   *   <li>When {@code 10U}.</li>
   *   <li>Then return {@code £10.00}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName("Test getPrice(String); given BLCVariableExpression (default constructor); when '10U'; then return '£10.00'")
  void testGetPrice_givenBLCVariableExpression_when10u_thenReturn1000() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("£10.00", (new BLCVariableExpression()).getPrice("10U"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   * <ul>
   *   <li>Given {@link BLCVariableExpression} (default constructor).</li>
   *   <li>When {@code 42}.</li>
   *   <li>Then return {@code £42.00}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName("Test getPrice(String); given BLCVariableExpression (default constructor); when '42'; then return '£42.00'")
  void testGetPrice_givenBLCVariableExpression_when42_thenReturn4200() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("£42.00", (new BLCVariableExpression()).getPrice("42"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   * <ul>
   *   <li>Given {@link BLCVariableExpression} (default constructor).</li>
   *   <li>When {@code Amount}.</li>
   *   <li>Then return {@code $ 0.00}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName("Test getPrice(String); given BLCVariableExpression (default constructor); when 'Amount'; then return '$ 0.00'")
  void testGetPrice_givenBLCVariableExpression_whenAmount_thenReturn000() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("$ 0.00", (new BLCVariableExpression()).getPrice("Amount"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   * <ul>
   *   <li>Given {@link BLCVariableExpression} (default constructor).</li>
   *   <li>When {@code [^\d.]+10}.</li>
   *   <li>Then return {@code £0.10}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName("Test getPrice(String); given BLCVariableExpression (default constructor); when '[^\\d.]+10'; then return '£0.10'")
  void testGetPrice_givenBLCVariableExpression_whenD10_thenReturn010() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("£0.10", (new BLCVariableExpression()).getPrice("[^\\d.]+10"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   * <ul>
   *   <li>Given {@link BLCVariableExpression} (default constructor).</li>
   *   <li>When {@code [^\d.]+42}.</li>
   *   <li>Then return {@code £0.42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName("Test getPrice(String); given BLCVariableExpression (default constructor); when '[^\\d.]+42'; then return '£0.42'")
  void testGetPrice_givenBLCVariableExpression_whenD42_thenReturn042() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("£0.42", (new BLCVariableExpression()).getPrice("[^\\d.]+42"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   * <ul>
   *   <li>Given {@link BLCVariableExpression} (default constructor).</li>
   *   <li>When {@link Boolean#TRUE} toString.</li>
   *   <li>Then return {@code $ 0.00}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName("Test getPrice(String); given BLCVariableExpression (default constructor); when TRUE toString; then return '$ 0.00'")
  void testGetPrice_givenBLCVariableExpression_whenTrueToString_thenReturn000() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BLCVariableExpression blcVariableExpression = new BLCVariableExpression();

    // Act and Assert
    assertEquals("$ 0.00", blcVariableExpression.getPrice(Boolean.TRUE.toString()));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   * <ul>
   *   <li>Given {@link BLCVariableExpression} (default constructor).</li>
   *   <li>When {@code U10}.</li>
   *   <li>Then return {@code £10.00}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName("Test getPrice(String); given BLCVariableExpression (default constructor); when 'U10'; then return '£10.00'")
  void testGetPrice_givenBLCVariableExpression_whenU10_thenReturn1000() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("£10.00", (new BLCVariableExpression()).getPrice("U10"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   * <ul>
   *   <li>Given {@link BLCVariableExpression} (default constructor).</li>
   *   <li>When {@code U42}.</li>
   *   <li>Then return {@code £42.00}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName("Test getPrice(String); given BLCVariableExpression (default constructor); when 'U42'; then return '£42.00'")
  void testGetPrice_givenBLCVariableExpression_whenU42_thenReturn4200() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("£42.00", (new BLCVariableExpression()).getPrice("U42"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   * <ul>
   *   <li>Given {@link BLCVariableExpression} (default constructor).</li>
   *   <li>When {@code UAmount}.</li>
   *   <li>Then return {@code $ 0.00}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName("Test getPrice(String); given BLCVariableExpression (default constructor); when 'UAmount'; then return '$ 0.00'")
  void testGetPrice_givenBLCVariableExpression_whenUAmount_thenReturn000() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("$ 0.00", (new BLCVariableExpression()).getPrice("UAmount"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   * <ul>
   *   <li>Given {@link BLCVariableExpression} (default constructor).</li>
   *   <li>When {@code U}.</li>
   *   <li>Then return {@code $ 0.00}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName("Test getPrice(String); given BLCVariableExpression (default constructor); when 'U'; then return '$ 0.00'")
  void testGetPrice_givenBLCVariableExpression_whenU_thenReturn000() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("$ 0.00", (new BLCVariableExpression()).getPrice("U"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   * <ul>
   *   <li>Given {@link BLCVariableExpression} (default constructor).</li>
   *   <li>When {@code Utrue}.</li>
   *   <li>Then return {@code $ 0.00}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName("Test getPrice(String); given BLCVariableExpression (default constructor); when 'Utrue'; then return '$ 0.00'")
  void testGetPrice_givenBLCVariableExpression_whenUtrue_thenReturn000() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("$ 0.00", (new BLCVariableExpression()).getPrice("Utrue"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   * <ul>
   *   <li>Given {@link BLCVariableExpression} (default constructor).</li>
   *   <li>When {@code UU}.</li>
   *   <li>Then return {@code $ 0.00}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName("Test getPrice(String); given BLCVariableExpression (default constructor); when 'UU'; then return '$ 0.00'")
  void testGetPrice_givenBLCVariableExpression_whenUu_thenReturn000() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("$ 0.00", (new BLCVariableExpression()).getPrice("UU"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   * <ul>
   *   <li>Given {@link PromotionMessageVariableExpression} (default
   * constructor).</li>
   *   <li>When {@code 42Amount}.</li>
   *   <li>Then return {@code £42.00}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName("Test getPrice(String); given PromotionMessageVariableExpression (default constructor); when '42Amount'; then return '£42.00'")
  void testGetPrice_givenPromotionMessageVariableExpression_when42Amount_thenReturn4200() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("£42.00", (new PromotionMessageVariableExpression()).getPrice("42Amount"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   * <ul>
   *   <li>Given {@link PromotionMessageVariableExpression} (default
   * constructor).</li>
   *   <li>When {@code Amount10}.</li>
   *   <li>Then return {@code £10.00}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName("Test getPrice(String); given PromotionMessageVariableExpression (default constructor); when 'Amount10'; then return '£10.00'")
  void testGetPrice_givenPromotionMessageVariableExpression_whenAmount10_thenReturn1000() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("£10.00", (new PromotionMessageVariableExpression()).getPrice("Amount10"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   * <ul>
   *   <li>Given {@link PromotionMessageVariableExpression} (default
   * constructor).</li>
   *   <li>When {@code Amount42}.</li>
   *   <li>Then return {@code £42.00}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName("Test getPrice(String); given PromotionMessageVariableExpression (default constructor); when 'Amount42'; then return '£42.00'")
  void testGetPrice_givenPromotionMessageVariableExpression_whenAmount42_thenReturn4200() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("£42.00", (new PromotionMessageVariableExpression()).getPrice("Amount42"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   * <ul>
   *   <li>When {@code 10Amount10}.</li>
   *   <li>Then return {@code £1,010.00}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName("Test getPrice(String); when '10Amount10'; then return '£1,010.00'")
  void testGetPrice_when10Amount10_thenReturn101000() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("£1,010.00", (new PromotionMessageVariableExpression()).getPrice("10Amount10"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   * <ul>
   *   <li>When {@code 10Amount42}.</li>
   *   <li>Then return {@code £1,042.00}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName("Test getPrice(String); when '10Amount42'; then return '£1,042.00'")
  void testGetPrice_when10Amount42_thenReturn104200() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("£1,042.00", (new PromotionMessageVariableExpression()).getPrice("10Amount42"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   * <ul>
   *   <li>When {@code 10AmountAmount}.</li>
   *   <li>Then return {@code £10.00}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName("Test getPrice(String); when '10AmountAmount'; then return '£10.00'")
  void testGetPrice_when10AmountAmount_thenReturn1000() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("£10.00", (new PromotionMessageVariableExpression()).getPrice("10AmountAmount"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   * <ul>
   *   <li>When {@code 1010Amount}.</li>
   *   <li>Then return {@code £1,010.00}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName("Test getPrice(String); when '1010Amount'; then return '£1,010.00'")
  void testGetPrice_when1010Amount_thenReturn101000() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("£1,010.00", (new PromotionMessageVariableExpression()).getPrice("1010Amount"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   * <ul>
   *   <li>When {@code 1042Amount}.</li>
   *   <li>Then return {@code £1,042.00}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName("Test getPrice(String); when '1042Amount'; then return '£1,042.00'")
  void testGetPrice_when1042Amount_thenReturn104200() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("£1,042.00", (new PromotionMessageVariableExpression()).getPrice("1042Amount"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   * <ul>
   *   <li>When {@code AmountAmount}.</li>
   *   <li>Then return {@code $ 0.00}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName("Test getPrice(String); when 'AmountAmount'; then return '$ 0.00'")
  void testGetPrice_whenAmountAmount_thenReturn000() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("$ 0.00", (new PromotionMessageVariableExpression()).getPrice("AmountAmount"));
  }
}
