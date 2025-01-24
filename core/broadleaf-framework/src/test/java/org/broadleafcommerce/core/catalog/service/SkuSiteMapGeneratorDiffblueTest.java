package org.broadleafcommerce.core.catalog.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import org.broadleafcommerce.common.file.domain.FileWorkArea;
import org.broadleafcommerce.common.sitemap.domain.CustomUrlSiteMapGeneratorConfigurationImpl;
import org.broadleafcommerce.common.sitemap.domain.SiteMapConfigurationImpl;
import org.broadleafcommerce.common.sitemap.domain.SiteMapGeneratorConfiguration;
import org.broadleafcommerce.common.sitemap.service.SiteMapBuilder;
import org.broadleafcommerce.common.sitemap.service.type.SiteMapChangeFreqType;
import org.broadleafcommerce.common.sitemap.service.type.SiteMapGeneratorType;
import org.broadleafcommerce.common.sitemap.service.type.SiteMapPriorityType;
import org.broadleafcommerce.common.sitemap.wrapper.SiteMapURLWrapper;
import org.broadleafcommerce.core.catalog.dao.SkuDao;
import org.broadleafcommerce.core.catalog.dao.SkuDaoImpl;
import org.broadleafcommerce.core.catalog.domain.CategorySiteMapGeneratorConfigurationImpl;
import org.broadleafcommerce.core.catalog.domain.ProductBundleImpl;
import org.broadleafcommerce.core.catalog.domain.Sku;
import org.broadleafcommerce.core.catalog.domain.SkuImpl;
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
public class SkuSiteMapGeneratorDiffblueTest {
  @Autowired
  private SkuSiteMapGenerator skuSiteMapGenerator;

  /**
   * Test
   * {@link SkuSiteMapGenerator#canHandleSiteMapConfiguration(SiteMapGeneratorConfiguration)}.
   * <p>
   * Method under test:
   * {@link SkuSiteMapGenerator#canHandleSiteMapConfiguration(SiteMapGeneratorConfiguration)}
   */
  @Test
  public void testCanHandleSiteMapConfiguration() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuSiteMapGenerator skuSiteMapGenerator = new SkuSiteMapGenerator();
    CustomUrlSiteMapGeneratorConfigurationImpl siteMapGeneratorConfiguration = mock(
        CustomUrlSiteMapGeneratorConfigurationImpl.class);
    when(siteMapGeneratorConfiguration.getSiteMapGeneratorType())
        .thenReturn(new SiteMapGeneratorType("Type", "Friendly Type"));

    // Act
    boolean actualCanHandleSiteMapConfigurationResult = skuSiteMapGenerator
        .canHandleSiteMapConfiguration(siteMapGeneratorConfiguration);

    // Assert
    verify(siteMapGeneratorConfiguration).getSiteMapGeneratorType();
    assertFalse(actualCanHandleSiteMapConfigurationResult);
  }

  /**
   * Test
   * {@link SkuSiteMapGenerator#canHandleSiteMapConfiguration(SiteMapGeneratorConfiguration)}.
   * <p>
   * Method under test:
   * {@link SkuSiteMapGenerator#canHandleSiteMapConfiguration(SiteMapGeneratorConfiguration)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testCanHandleSiteMapConfiguration2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.catalog.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass6400 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.catalog.service.SkuSiteMapGenerator skuSiteMapGenerator;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    SkuSiteMapGenerator skuSiteMapGenerator2 = new SkuSiteMapGenerator();

    // Act
    skuSiteMapGenerator2.canHandleSiteMapConfiguration(new CategorySiteMapGeneratorConfigurationImpl());
  }

  /**
   * Test
   * {@link SkuSiteMapGenerator#canHandleSiteMapConfiguration(SiteMapGeneratorConfiguration)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SkuSiteMapGenerator#canHandleSiteMapConfiguration(SiteMapGeneratorConfiguration)}
   */
  @Test
  public void testCanHandleSiteMapConfiguration_givenArrayList() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuSiteMapGenerator skuSiteMapGenerator = new SkuSiteMapGenerator();

    CustomUrlSiteMapGeneratorConfigurationImpl siteMapGeneratorConfiguration = new CustomUrlSiteMapGeneratorConfigurationImpl();
    siteMapGeneratorConfiguration.setCustomURLEntries(new ArrayList<>());
    siteMapGeneratorConfiguration.setDisabled(true);
    siteMapGeneratorConfiguration.setId(1L);
    siteMapGeneratorConfiguration.setSiteMapChangeFreq(new SiteMapChangeFreqType("Type", "Friendly Type"));
    siteMapGeneratorConfiguration.setSiteMapConfiguration(new SiteMapConfigurationImpl());
    siteMapGeneratorConfiguration.setSiteMapGeneratorType(new SiteMapGeneratorType("Type", "Friendly Type"));
    siteMapGeneratorConfiguration.setSiteMapPriority(new SiteMapPriorityType("Type", "Friendly Type"));

    // Act and Assert
    assertFalse(skuSiteMapGenerator.canHandleSiteMapConfiguration(siteMapGeneratorConfiguration));
  }

  /**
   * Test
   * {@link SkuSiteMapGenerator#canHandleSiteMapConfiguration(SiteMapGeneratorConfiguration)}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SkuSiteMapGenerator#canHandleSiteMapConfiguration(SiteMapGeneratorConfiguration)}
   */
  @Test
  public void testCanHandleSiteMapConfiguration_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuSiteMapGenerator skuSiteMapGenerator = new SkuSiteMapGenerator();
    CustomUrlSiteMapGeneratorConfigurationImpl siteMapGeneratorConfiguration = mock(
        CustomUrlSiteMapGeneratorConfigurationImpl.class);
    when(siteMapGeneratorConfiguration.getSiteMapGeneratorType())
        .thenReturn(new SiteMapGeneratorType("SKU", "Friendly Type"));

    // Act
    boolean actualCanHandleSiteMapConfigurationResult = skuSiteMapGenerator
        .canHandleSiteMapConfiguration(siteMapGeneratorConfiguration);

    // Assert
    verify(siteMapGeneratorConfiguration).getSiteMapGeneratorType();
    assertTrue(actualCanHandleSiteMapConfigurationResult);
  }

  /**
   * Test
   * {@link SkuSiteMapGenerator#canHandleSiteMapConfiguration(SiteMapGeneratorConfiguration)}.
   * <ul>
   *   <li>When {@link CategorySiteMapGeneratorConfigurationImpl} (default
   * constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SkuSiteMapGenerator#canHandleSiteMapConfiguration(SiteMapGeneratorConfiguration)}
   */
  @Test
  public void testCanHandleSiteMapConfiguration_whenCategorySiteMapGeneratorConfigurationImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuSiteMapGenerator skuSiteMapGenerator = new SkuSiteMapGenerator();

    // Act and Assert
    assertFalse(skuSiteMapGenerator.canHandleSiteMapConfiguration(new CategorySiteMapGeneratorConfigurationImpl()));
  }

  /**
   * Test
   * {@link SkuSiteMapGenerator#addSiteMapEntries(SiteMapGeneratorConfiguration, SiteMapBuilder)}.
   * <p>
   * Method under test:
   * {@link SkuSiteMapGenerator#addSiteMapEntries(SiteMapGeneratorConfiguration, SiteMapBuilder)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testAddSiteMapEntries() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.catalog.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass6370 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.catalog.service.SkuSiteMapGenerator skuSiteMapGenerator;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    SkuSiteMapGenerator skuSiteMapGenerator2 = new SkuSiteMapGenerator();
    CategorySiteMapGeneratorConfigurationImpl smgc = new CategorySiteMapGeneratorConfigurationImpl();
    SiteMapConfigurationImpl siteMapConfig = new SiteMapConfigurationImpl();

    // Act
    skuSiteMapGenerator2.addSiteMapEntries(smgc,
        new SiteMapBuilder(siteMapConfig, new FileWorkArea(), "https://example.org/example", true));
  }

  /**
   * Test
   * {@link SkuSiteMapGenerator#constructImageURLs(SiteMapBuilder, SiteMapURLWrapper, Sku)}.
   * <p>
   * Method under test:
   * {@link SkuSiteMapGenerator#constructImageURLs(SiteMapBuilder, SiteMapURLWrapper, Sku)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testConstructImageURLs() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.catalog.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass6425 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.catalog.service.SkuSiteMapGenerator skuSiteMapGenerator;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    SkuSiteMapGenerator skuSiteMapGenerator2 = new SkuSiteMapGenerator();
    SiteMapConfigurationImpl siteMapConfig = new SiteMapConfigurationImpl();
    SiteMapBuilder siteMapBuilder = new SiteMapBuilder(siteMapConfig, new FileWorkArea(), "https://example.org/example",
        true);

    SiteMapURLWrapper siteMapUrl = new SiteMapURLWrapper();

    // Act
    skuSiteMapGenerator2.constructImageURLs(siteMapBuilder, siteMapUrl, new SkuImpl());
  }

  /**
   * Test {@link SkuSiteMapGenerator#generateUri(SiteMapBuilder, Sku)}.
   * <p>
   * Method under test:
   * {@link SkuSiteMapGenerator#generateUri(SiteMapBuilder, Sku)}
   */
  @Test
  public void testGenerateUri() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuSiteMapGenerator skuSiteMapGenerator = new SkuSiteMapGenerator();
    SiteMapConfigurationImpl siteMapConfig = new SiteMapConfigurationImpl();
    SiteMapBuilder smb = new SiteMapBuilder(siteMapConfig, new FileWorkArea(), "https://example.org/example", true);

    ProductBundleImpl productBundleImpl = mock(ProductBundleImpl.class);
    when(productBundleImpl.getUrl()).thenReturn("https://example.org/example");
    SkuImpl sku = mock(SkuImpl.class);
    when(sku.getUrlKey()).thenReturn("https://example.org/example");
    when(sku.getProduct()).thenReturn(productBundleImpl);

    // Act
    String actualGenerateUriResult = skuSiteMapGenerator.generateUri(smb, sku);

    // Assert
    verify(productBundleImpl).getUrl();
    verify(sku).getProduct();
    verify(sku, atLeast(1)).getUrlKey();
    assertEquals("https://example.org/example/https://example.org/examplehttps://example.org/example",
        actualGenerateUriResult);
  }

  /**
   * Test {@link SkuSiteMapGenerator#generateUri(SiteMapBuilder, Sku)}.
   * <p>
   * Method under test:
   * {@link SkuSiteMapGenerator#generateUri(SiteMapBuilder, Sku)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGenerateUri2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.catalog.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass6485 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.catalog.service.SkuSiteMapGenerator skuSiteMapGenerator;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    SkuSiteMapGenerator skuSiteMapGenerator2 = new SkuSiteMapGenerator();
    SiteMapConfigurationImpl siteMapConfig = new SiteMapConfigurationImpl();
    SiteMapBuilder smb = new SiteMapBuilder(siteMapConfig, new FileWorkArea(), "https://example.org/example", true);

    // Act
    skuSiteMapGenerator2.generateUri(smb, new SkuImpl());
  }

  /**
   * Test {@link SkuSiteMapGenerator#generateUri(SiteMapBuilder, Sku)}.
   * <ul>
   *   <li>Then return {@code /https://example.org/example}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SkuSiteMapGenerator#generateUri(SiteMapBuilder, Sku)}
   */
  @Test
  public void testGenerateUri_thenReturnHttpsExampleOrgExample() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuSiteMapGenerator skuSiteMapGenerator = new SkuSiteMapGenerator();
    SiteMapConfigurationImpl siteMapConfig = new SiteMapConfigurationImpl();
    SiteMapBuilder smb = new SiteMapBuilder(siteMapConfig, new FileWorkArea(), "/", true);

    ProductBundleImpl productBundleImpl = mock(ProductBundleImpl.class);
    when(productBundleImpl.getUrl()).thenReturn("/");
    SkuImpl sku = mock(SkuImpl.class);
    when(sku.getUrlKey()).thenReturn("https://example.org/example");
    when(sku.getProduct()).thenReturn(productBundleImpl);

    // Act
    String actualGenerateUriResult = skuSiteMapGenerator.generateUri(smb, sku);

    // Assert
    verify(productBundleImpl).getUrl();
    verify(sku).getProduct();
    verify(sku, atLeast(1)).getUrlKey();
    assertEquals("/https://example.org/example", actualGenerateUriResult);
  }

  /**
   * Test {@link SkuSiteMapGenerator#generateUri(SiteMapBuilder, Sku)}.
   * <ul>
   *   <li>Then return
   * {@code https://example.org/example/https://example.org/example}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SkuSiteMapGenerator#generateUri(SiteMapBuilder, Sku)}
   */
  @Test
  public void testGenerateUri_thenReturnHttpsExampleOrgExampleHttpsExampleOrgExample() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuSiteMapGenerator skuSiteMapGenerator = new SkuSiteMapGenerator();
    SiteMapConfigurationImpl siteMapConfig = new SiteMapConfigurationImpl();
    SiteMapBuilder smb = new SiteMapBuilder(siteMapConfig, new FileWorkArea(), "https://example.org/example", true);

    ProductBundleImpl productBundleImpl = mock(ProductBundleImpl.class);
    when(productBundleImpl.getUrl()).thenReturn("https://example.org/example");
    SkuImpl sku = mock(SkuImpl.class);
    when(sku.getUrlKey()).thenReturn(null);
    when(sku.getProduct()).thenReturn(productBundleImpl);

    // Act
    String actualGenerateUriResult = skuSiteMapGenerator.generateUri(smb, sku);

    // Assert
    verify(productBundleImpl).getUrl();
    verify(sku).getProduct();
    verify(sku).getUrlKey();
    assertEquals("https://example.org/example/https://example.org/example", actualGenerateUriResult);
  }

  /**
   * Test {@link SkuSiteMapGenerator#generateUri(SiteMapBuilder, Sku)}.
   * <ul>
   *   <li>Then return
   * {@code https://example.org/example/https://example.org/example}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SkuSiteMapGenerator#generateUri(SiteMapBuilder, Sku)}
   */
  @Test
  public void testGenerateUri_thenReturnHttpsExampleOrgExampleHttpsExampleOrgExample2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuSiteMapGenerator skuSiteMapGenerator = new SkuSiteMapGenerator();
    SiteMapConfigurationImpl siteMapConfig = new SiteMapConfigurationImpl();
    SiteMapBuilder smb = new SiteMapBuilder(siteMapConfig, new FileWorkArea(), "https://example.org/example", true);

    ProductBundleImpl productBundleImpl = mock(ProductBundleImpl.class);
    when(productBundleImpl.getUrl()).thenReturn("/");
    SkuImpl sku = mock(SkuImpl.class);
    when(sku.getUrlKey()).thenReturn("https://example.org/example");
    when(sku.getProduct()).thenReturn(productBundleImpl);

    // Act
    String actualGenerateUriResult = skuSiteMapGenerator.generateUri(smb, sku);

    // Assert
    verify(productBundleImpl).getUrl();
    verify(sku).getProduct();
    verify(sku, atLeast(1)).getUrlKey();
    assertEquals("https://example.org/example/https://example.org/example", actualGenerateUriResult);
  }

  /**
   * Test {@link SkuSiteMapGenerator#generateUri(SiteMapBuilder, Sku)}.
   * <ul>
   *   <li>Then return
   * {@code https://example.org/example/nullhttps://example.org/example}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SkuSiteMapGenerator#generateUri(SiteMapBuilder, Sku)}
   */
  @Test
  public void testGenerateUri_thenReturnHttpsExampleOrgExampleNullhttpsExampleOrgExample() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuSiteMapGenerator skuSiteMapGenerator = new SkuSiteMapGenerator();
    SiteMapConfigurationImpl siteMapConfig = new SiteMapConfigurationImpl();
    SiteMapBuilder smb = new SiteMapBuilder(siteMapConfig, new FileWorkArea(), "https://example.org/example", true);

    SkuImpl sku = mock(SkuImpl.class);
    when(sku.getUrlKey()).thenReturn("https://example.org/example");
    when(sku.getProduct()).thenReturn(new ProductBundleImpl());

    // Act
    String actualGenerateUriResult = skuSiteMapGenerator.generateUri(smb, sku);

    // Assert
    verify(sku).getProduct();
    verify(sku, atLeast(1)).getUrlKey();
    assertEquals("https://example.org/example/nullhttps://example.org/example", actualGenerateUriResult);
  }

  /**
   * Test {@link SkuSiteMapGenerator#generateUri(SiteMapBuilder, Sku)}.
   * <ul>
   *   <li>Then return {@code /nullhttps://example.org/example}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SkuSiteMapGenerator#generateUri(SiteMapBuilder, Sku)}
   */
  @Test
  public void testGenerateUri_thenReturnNullhttpsExampleOrgExample() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuSiteMapGenerator skuSiteMapGenerator = new SkuSiteMapGenerator();
    SiteMapConfigurationImpl siteMapConfig = new SiteMapConfigurationImpl();
    SiteMapBuilder smb = new SiteMapBuilder(siteMapConfig, new FileWorkArea(), "/", true);

    SkuImpl sku = mock(SkuImpl.class);
    when(sku.getUrlKey()).thenReturn("https://example.org/example");
    when(sku.getProduct()).thenReturn(new ProductBundleImpl());

    // Act
    String actualGenerateUriResult = skuSiteMapGenerator.generateUri(smb, sku);

    // Assert
    verify(sku).getProduct();
    verify(sku, atLeast(1)).getUrlKey();
    assertEquals("/nullhttps://example.org/example", actualGenerateUriResult);
  }

  /**
   * Test {@link SkuSiteMapGenerator#generateDate(Sku)}.
   * <p>
   * Method under test: {@link SkuSiteMapGenerator#generateDate(Sku)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGenerateDate() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.catalog.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass6455 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.catalog.service.SkuSiteMapGenerator skuSiteMapGenerator;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    SkuSiteMapGenerator skuSiteMapGenerator2 = new SkuSiteMapGenerator();

    // Act
    skuSiteMapGenerator2.generateDate(new SkuImpl());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link SkuSiteMapGenerator#setPageSize(int)}
   *   <li>{@link SkuSiteMapGenerator#setSkuDao(SkuDao)}
   *   <li>{@link SkuSiteMapGenerator#getPageSize()}
   *   <li>{@link SkuSiteMapGenerator#getSkuDao()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    SkuSiteMapGenerator skuSiteMapGenerator = new SkuSiteMapGenerator();

    // Act
    skuSiteMapGenerator.setPageSize(3);
    SkuDaoImpl skuDao = new SkuDaoImpl();
    skuSiteMapGenerator.setSkuDao(skuDao);
    int actualPageSize = skuSiteMapGenerator.getPageSize();
    SkuDao actualSkuDao = skuSiteMapGenerator.getSkuDao();

    // Assert that nothing has changed
    assertTrue(actualSkuDao instanceof SkuDaoImpl);
    assertEquals(3, actualPageSize);
    assertSame(skuDao, actualSkuDao);
  }
}
