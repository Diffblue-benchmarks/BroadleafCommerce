package org.broadleafcommerce.core.catalog.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.broadleafcommerce.common.file.domain.FileWorkArea;
import org.broadleafcommerce.common.media.domain.Media;
import org.broadleafcommerce.common.media.domain.MediaImpl;
import org.broadleafcommerce.common.sitemap.domain.CustomUrlSiteMapGeneratorConfigurationImpl;
import org.broadleafcommerce.common.sitemap.domain.SiteMapConfigurationImpl;
import org.broadleafcommerce.common.sitemap.domain.SiteMapGeneratorConfiguration;
import org.broadleafcommerce.common.sitemap.service.SiteMapBuilder;
import org.broadleafcommerce.common.sitemap.service.type.SiteMapChangeFreqType;
import org.broadleafcommerce.common.sitemap.service.type.SiteMapGeneratorType;
import org.broadleafcommerce.common.sitemap.service.type.SiteMapPriorityType;
import org.broadleafcommerce.common.sitemap.wrapper.SiteMapImageWrapper;
import org.broadleafcommerce.common.sitemap.wrapper.SiteMapURLWrapper;
import org.broadleafcommerce.core.catalog.dao.ProductDao;
import org.broadleafcommerce.core.catalog.dao.ProductDaoImpl;
import org.broadleafcommerce.core.catalog.domain.CategorySiteMapGeneratorConfigurationImpl;
import org.broadleafcommerce.core.catalog.domain.Product;
import org.broadleafcommerce.core.catalog.domain.ProductBundleImpl;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml",
    "/bl-framework-applicationContext-persistence.xml", "/bl-framework-applicationContext-workflow.xml",
    "/bl-framework-applicationContext.xml", "/blc-config/admin/framework/bl-framework-admin-applicationContext.xml",
    "/blc-config/site/framework/bl-framework-applicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class ProductSiteMapGeneratorDiffblueTest {
  @Autowired
  private ProductSiteMapGenerator productSiteMapGenerator;

  /**
   * Test
   * {@link ProductSiteMapGenerator#canHandleSiteMapConfiguration(SiteMapGeneratorConfiguration)}.
   * <p>
   * Method under test:
   * {@link ProductSiteMapGenerator#canHandleSiteMapConfiguration(SiteMapGeneratorConfiguration)}
   */
  @Test
  public void testCanHandleSiteMapConfiguration() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductSiteMapGenerator productSiteMapGenerator = new ProductSiteMapGenerator();
    CustomUrlSiteMapGeneratorConfigurationImpl siteMapGeneratorConfiguration = mock(
        CustomUrlSiteMapGeneratorConfigurationImpl.class);
    when(siteMapGeneratorConfiguration.getSiteMapGeneratorType())
        .thenReturn(new SiteMapGeneratorType("Type", "Friendly Type"));

    // Act
    boolean actualCanHandleSiteMapConfigurationResult = productSiteMapGenerator
        .canHandleSiteMapConfiguration(siteMapGeneratorConfiguration);

    // Assert
    verify(siteMapGeneratorConfiguration).getSiteMapGeneratorType();
    assertFalse(actualCanHandleSiteMapConfigurationResult);
  }

  /**
   * Test
   * {@link ProductSiteMapGenerator#canHandleSiteMapConfiguration(SiteMapGeneratorConfiguration)}.
   * <p>
   * Method under test:
   * {@link ProductSiteMapGenerator#canHandleSiteMapConfiguration(SiteMapGeneratorConfiguration)}
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
    //   public class DiffblueFakeClass6033 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.catalog.service.ProductSiteMapGenerator productSiteMapGenerator;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    ProductSiteMapGenerator productSiteMapGenerator2 = new ProductSiteMapGenerator();

    // Act
    productSiteMapGenerator2.canHandleSiteMapConfiguration(new CategorySiteMapGeneratorConfigurationImpl());
  }

  /**
   * Test
   * {@link ProductSiteMapGenerator#canHandleSiteMapConfiguration(SiteMapGeneratorConfiguration)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ProductSiteMapGenerator#canHandleSiteMapConfiguration(SiteMapGeneratorConfiguration)}
   */
  @Test
  public void testCanHandleSiteMapConfiguration_givenArrayList() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductSiteMapGenerator productSiteMapGenerator = new ProductSiteMapGenerator();

    CustomUrlSiteMapGeneratorConfigurationImpl siteMapGeneratorConfiguration = new CustomUrlSiteMapGeneratorConfigurationImpl();
    siteMapGeneratorConfiguration.setCustomURLEntries(new ArrayList<>());
    siteMapGeneratorConfiguration.setDisabled(true);
    siteMapGeneratorConfiguration.setId(1L);
    siteMapGeneratorConfiguration.setSiteMapChangeFreq(new SiteMapChangeFreqType("Type", "Friendly Type"));
    siteMapGeneratorConfiguration.setSiteMapConfiguration(new SiteMapConfigurationImpl());
    siteMapGeneratorConfiguration.setSiteMapGeneratorType(new SiteMapGeneratorType("Type", "Friendly Type"));
    siteMapGeneratorConfiguration.setSiteMapPriority(new SiteMapPriorityType("Type", "Friendly Type"));

    // Act and Assert
    assertFalse(productSiteMapGenerator.canHandleSiteMapConfiguration(siteMapGeneratorConfiguration));
  }

  /**
   * Test
   * {@link ProductSiteMapGenerator#canHandleSiteMapConfiguration(SiteMapGeneratorConfiguration)}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ProductSiteMapGenerator#canHandleSiteMapConfiguration(SiteMapGeneratorConfiguration)}
   */
  @Test
  public void testCanHandleSiteMapConfiguration_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductSiteMapGenerator productSiteMapGenerator = new ProductSiteMapGenerator();
    CustomUrlSiteMapGeneratorConfigurationImpl siteMapGeneratorConfiguration = mock(
        CustomUrlSiteMapGeneratorConfigurationImpl.class);
    when(siteMapGeneratorConfiguration.getSiteMapGeneratorType())
        .thenReturn(new SiteMapGeneratorType("PRODUCT", "Friendly Type"));

    // Act
    boolean actualCanHandleSiteMapConfigurationResult = productSiteMapGenerator
        .canHandleSiteMapConfiguration(siteMapGeneratorConfiguration);

    // Assert
    verify(siteMapGeneratorConfiguration).getSiteMapGeneratorType();
    assertTrue(actualCanHandleSiteMapConfigurationResult);
  }

  /**
   * Test
   * {@link ProductSiteMapGenerator#canHandleSiteMapConfiguration(SiteMapGeneratorConfiguration)}.
   * <ul>
   *   <li>When {@link CategorySiteMapGeneratorConfigurationImpl} (default
   * constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ProductSiteMapGenerator#canHandleSiteMapConfiguration(SiteMapGeneratorConfiguration)}
   */
  @Test
  public void testCanHandleSiteMapConfiguration_whenCategorySiteMapGeneratorConfigurationImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductSiteMapGenerator productSiteMapGenerator = new ProductSiteMapGenerator();

    // Act and Assert
    assertFalse(productSiteMapGenerator.canHandleSiteMapConfiguration(new CategorySiteMapGeneratorConfigurationImpl()));
  }

  /**
   * Test
   * {@link ProductSiteMapGenerator#addSiteMapEntries(SiteMapGeneratorConfiguration, SiteMapBuilder)}.
   * <p>
   * Method under test:
   * {@link ProductSiteMapGenerator#addSiteMapEntries(SiteMapGeneratorConfiguration, SiteMapBuilder)}
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
    //   public class DiffblueFakeClass6003 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.catalog.service.ProductSiteMapGenerator productSiteMapGenerator;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    ProductSiteMapGenerator productSiteMapGenerator2 = new ProductSiteMapGenerator();
    CategorySiteMapGeneratorConfigurationImpl smgc = new CategorySiteMapGeneratorConfigurationImpl();
    SiteMapConfigurationImpl siteMapConfig = new SiteMapConfigurationImpl();

    // Act
    productSiteMapGenerator2.addSiteMapEntries(smgc,
        new SiteMapBuilder(siteMapConfig, new FileWorkArea(), "https://example.org/example", true));
  }

  /**
   * Test
   * {@link ProductSiteMapGenerator#constructImageURLs(SiteMapBuilder, SiteMapURLWrapper, Product)}.
   * <p>
   * Method under test:
   * {@link ProductSiteMapGenerator#constructImageURLs(SiteMapBuilder, SiteMapURLWrapper, Product)}
   */
  @Test
  public void testConstructImageURLs() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductSiteMapGenerator productSiteMapGenerator = new ProductSiteMapGenerator();
    SiteMapConfigurationImpl siteMapConfig = new SiteMapConfigurationImpl();
    SiteMapBuilder siteMapBuilder = new SiteMapBuilder(siteMapConfig, new FileWorkArea(), "https://example.org/example",
        true);

    SiteMapURLWrapper siteMapUrl = new SiteMapURLWrapper();

    MediaImpl mediaImpl = new MediaImpl();
    mediaImpl.setAltText("/");
    mediaImpl.setId(1L);
    mediaImpl.setTags("/");
    mediaImpl.setTitle("Dr");
    mediaImpl.setUrl("https://example.org/example");

    HashMap<String, Media> stringMediaMap = new HashMap<>();
    stringMediaMap.put("foo", mediaImpl);
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getMedia()).thenReturn(stringMediaMap);

    // Act
    productSiteMapGenerator.constructImageURLs(siteMapBuilder, siteMapUrl, product);

    // Assert
    verify(product).getMedia();
    List<SiteMapImageWrapper> siteMapImageWrappers = siteMapUrl.getSiteMapImageWrappers();
    assertEquals(1, siteMapImageWrappers.size());
    assertEquals("https://example.org/example/https://example.org/example", siteMapImageWrappers.get(0).getLoc());
  }

  /**
   * Test
   * {@link ProductSiteMapGenerator#constructImageURLs(SiteMapBuilder, SiteMapURLWrapper, Product)}.
   * <p>
   * Method under test:
   * {@link ProductSiteMapGenerator#constructImageURLs(SiteMapBuilder, SiteMapURLWrapper, Product)}
   */
  @Test
  public void testConstructImageURLs2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductSiteMapGenerator productSiteMapGenerator = new ProductSiteMapGenerator();
    SiteMapConfigurationImpl siteMapConfig = new SiteMapConfigurationImpl();
    SiteMapBuilder siteMapBuilder = new SiteMapBuilder(siteMapConfig, new FileWorkArea(), "/", true);

    SiteMapURLWrapper siteMapUrl = new SiteMapURLWrapper();

    MediaImpl mediaImpl = new MediaImpl();
    mediaImpl.setAltText("/");
    mediaImpl.setId(1L);
    mediaImpl.setTags("/");
    mediaImpl.setTitle("Dr");
    mediaImpl.setUrl("https://example.org/example");

    HashMap<String, Media> stringMediaMap = new HashMap<>();
    stringMediaMap.put("foo", mediaImpl);
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getMedia()).thenReturn(stringMediaMap);

    // Act
    productSiteMapGenerator.constructImageURLs(siteMapBuilder, siteMapUrl, product);

    // Assert
    verify(product).getMedia();
    List<SiteMapImageWrapper> siteMapImageWrappers = siteMapUrl.getSiteMapImageWrappers();
    assertEquals(1, siteMapImageWrappers.size());
    assertEquals("/https://example.org/example", siteMapImageWrappers.get(0).getLoc());
  }

  /**
   * Test
   * {@link ProductSiteMapGenerator#constructImageURLs(SiteMapBuilder, SiteMapURLWrapper, Product)}.
   * <p>
   * Method under test:
   * {@link ProductSiteMapGenerator#constructImageURLs(SiteMapBuilder, SiteMapURLWrapper, Product)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testConstructImageURLs3() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.catalog.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass6058 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.catalog.service.ProductSiteMapGenerator productSiteMapGenerator;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    ProductSiteMapGenerator productSiteMapGenerator2 = new ProductSiteMapGenerator();
    SiteMapConfigurationImpl siteMapConfig = new SiteMapConfigurationImpl();
    SiteMapBuilder siteMapBuilder = new SiteMapBuilder(siteMapConfig, new FileWorkArea(), "https://example.org/example",
        true);

    SiteMapURLWrapper siteMapUrl = new SiteMapURLWrapper();

    // Act
    productSiteMapGenerator2.constructImageURLs(siteMapBuilder, siteMapUrl, new ProductBundleImpl());
  }

  /**
   * Test
   * {@link ProductSiteMapGenerator#constructImageURLs(SiteMapBuilder, SiteMapURLWrapper, Product)}.
   * <ul>
   *   <li>Given {@link MediaImpl} (default constructor) Url is {@code /}.</li>
   *   <li>Then calls {@link SiteMapURLWrapper#addImage(SiteMapImageWrapper)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ProductSiteMapGenerator#constructImageURLs(SiteMapBuilder, SiteMapURLWrapper, Product)}
   */
  @Test
  public void testConstructImageURLs_givenMediaImplUrlIsSlash_thenCallsAddImage() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductSiteMapGenerator productSiteMapGenerator = new ProductSiteMapGenerator();
    SiteMapConfigurationImpl siteMapConfig = new SiteMapConfigurationImpl();
    SiteMapBuilder siteMapBuilder = new SiteMapBuilder(siteMapConfig, new FileWorkArea(), "https://example.org/example",
        true);

    SiteMapURLWrapper siteMapUrl = mock(SiteMapURLWrapper.class);
    doNothing().when(siteMapUrl).addImage(Mockito.<SiteMapImageWrapper>any());

    MediaImpl mediaImpl = new MediaImpl();
    mediaImpl.setAltText("/");
    mediaImpl.setId(1L);
    mediaImpl.setTags("/");
    mediaImpl.setTitle("Dr");
    mediaImpl.setUrl("/");

    HashMap<String, Media> stringMediaMap = new HashMap<>();
    stringMediaMap.put("foo", mediaImpl);
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getMedia()).thenReturn(stringMediaMap);

    // Act
    productSiteMapGenerator.constructImageURLs(siteMapBuilder, siteMapUrl, product);

    // Assert
    verify(siteMapUrl).addImage(isA(SiteMapImageWrapper.class));
    verify(product).getMedia();
  }

  /**
   * Test
   * {@link ProductSiteMapGenerator#constructImageURLs(SiteMapBuilder, SiteMapURLWrapper, Product)}.
   * <ul>
   *   <li>Given {@link MediaImpl} (default constructor) Url is {@code /}.</li>
   *   <li>Then calls {@link SiteMapURLWrapper#addImage(SiteMapImageWrapper)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ProductSiteMapGenerator#constructImageURLs(SiteMapBuilder, SiteMapURLWrapper, Product)}
   */
  @Test
  public void testConstructImageURLs_givenMediaImplUrlIsSlash_thenCallsAddImage2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductSiteMapGenerator productSiteMapGenerator = new ProductSiteMapGenerator();
    SiteMapConfigurationImpl siteMapConfig = new SiteMapConfigurationImpl();
    SiteMapBuilder siteMapBuilder = new SiteMapBuilder(siteMapConfig, new FileWorkArea(), "/", true);

    SiteMapURLWrapper siteMapUrl = mock(SiteMapURLWrapper.class);
    doNothing().when(siteMapUrl).addImage(Mockito.<SiteMapImageWrapper>any());

    MediaImpl mediaImpl = new MediaImpl();
    mediaImpl.setAltText("/");
    mediaImpl.setId(1L);
    mediaImpl.setTags("/");
    mediaImpl.setTitle("Dr");
    mediaImpl.setUrl("/");

    HashMap<String, Media> stringMediaMap = new HashMap<>();
    stringMediaMap.put("foo", mediaImpl);
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getMedia()).thenReturn(stringMediaMap);

    // Act
    productSiteMapGenerator.constructImageURLs(siteMapBuilder, siteMapUrl, product);

    // Assert
    verify(siteMapUrl).addImage(isA(SiteMapImageWrapper.class));
    verify(product).getMedia();
  }

  /**
   * Test
   * {@link ProductSiteMapGenerator#constructImageURLs(SiteMapBuilder, SiteMapURLWrapper, Product)}.
   * <ul>
   *   <li>Then calls {@link SiteMapURLWrapper#addImage(SiteMapImageWrapper)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ProductSiteMapGenerator#constructImageURLs(SiteMapBuilder, SiteMapURLWrapper, Product)}
   */
  @Test
  public void testConstructImageURLs_thenCallsAddImage() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductSiteMapGenerator productSiteMapGenerator = new ProductSiteMapGenerator();
    SiteMapConfigurationImpl siteMapConfig = new SiteMapConfigurationImpl();
    SiteMapBuilder siteMapBuilder = new SiteMapBuilder(siteMapConfig, new FileWorkArea(), "https://example.org/example",
        true);

    SiteMapURLWrapper siteMapUrl = mock(SiteMapURLWrapper.class);
    doNothing().when(siteMapUrl).addImage(Mockito.<SiteMapImageWrapper>any());

    MediaImpl mediaImpl = new MediaImpl();
    mediaImpl.setAltText("/");
    mediaImpl.setId(1L);
    mediaImpl.setTags("/");
    mediaImpl.setTitle("Dr");
    mediaImpl.setUrl("https://example.org/example");

    HashMap<String, Media> stringMediaMap = new HashMap<>();
    stringMediaMap.put("foo", mediaImpl);
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getMedia()).thenReturn(stringMediaMap);

    // Act
    productSiteMapGenerator.constructImageURLs(siteMapBuilder, siteMapUrl, product);

    // Assert
    verify(siteMapUrl).addImage(isA(SiteMapImageWrapper.class));
    verify(product).getMedia();
  }

  /**
   * Test
   * {@link ProductSiteMapGenerator#constructImageURLs(SiteMapBuilder, SiteMapURLWrapper, Product)}.
   * <ul>
   *   <li>Then {@link SiteMapURLWrapper} (default constructor) SiteMapImageWrappers
   * Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ProductSiteMapGenerator#constructImageURLs(SiteMapBuilder, SiteMapURLWrapper, Product)}
   */
  @Test
  public void testConstructImageURLs_thenSiteMapURLWrapperSiteMapImageWrappersEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductSiteMapGenerator productSiteMapGenerator = new ProductSiteMapGenerator();
    SiteMapConfigurationImpl siteMapConfig = new SiteMapConfigurationImpl();
    SiteMapBuilder siteMapBuilder = new SiteMapBuilder(siteMapConfig, new FileWorkArea(), "https://example.org/example",
        true);

    SiteMapURLWrapper siteMapUrl = new SiteMapURLWrapper();
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getMedia()).thenReturn(new HashMap<>());

    // Act
    productSiteMapGenerator.constructImageURLs(siteMapBuilder, siteMapUrl, product);

    // Assert
    verify(product).getMedia();
    assertTrue(siteMapUrl.getSiteMapImageWrappers().isEmpty());
  }

  /**
   * Test {@link ProductSiteMapGenerator#generateUri(SiteMapBuilder, Product)}.
   * <p>
   * Method under test:
   * {@link ProductSiteMapGenerator#generateUri(SiteMapBuilder, Product)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGenerateUri() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.catalog.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass6118 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.catalog.service.ProductSiteMapGenerator productSiteMapGenerator;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    ProductSiteMapGenerator productSiteMapGenerator2 = new ProductSiteMapGenerator();
    SiteMapConfigurationImpl siteMapConfig = new SiteMapConfigurationImpl();
    SiteMapBuilder smb = new SiteMapBuilder(siteMapConfig, new FileWorkArea(), "https://example.org/example", true);

    // Act
    productSiteMapGenerator2.generateUri(smb, new ProductBundleImpl());
  }

  /**
   * Test {@link ProductSiteMapGenerator#generateUri(SiteMapBuilder, Product)}.
   * <ul>
   *   <li>Given {@code https://example.org/example}.</li>
   *   <li>Then return {@code /https://example.org/example}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ProductSiteMapGenerator#generateUri(SiteMapBuilder, Product)}
   */
  @Test
  public void testGenerateUri_givenHttpsExampleOrgExample_thenReturnHttpsExampleOrgExample() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductSiteMapGenerator productSiteMapGenerator = new ProductSiteMapGenerator();
    SiteMapConfigurationImpl siteMapConfig = new SiteMapConfigurationImpl();
    SiteMapBuilder smb = new SiteMapBuilder(siteMapConfig, new FileWorkArea(), "/", true);

    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getUrl()).thenReturn("https://example.org/example");

    // Act
    String actualGenerateUriResult = productSiteMapGenerator.generateUri(smb, product);

    // Assert
    verify(product).getUrl();
    assertEquals("/https://example.org/example", actualGenerateUriResult);
  }

  /**
   * Test {@link ProductSiteMapGenerator#generateUri(SiteMapBuilder, Product)}.
   * <ul>
   *   <li>Given {@code /}.</li>
   *   <li>Then return {@code https://example.org/example/}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ProductSiteMapGenerator#generateUri(SiteMapBuilder, Product)}
   */
  @Test
  public void testGenerateUri_givenSlash_thenReturnHttpsExampleOrgExample() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductSiteMapGenerator productSiteMapGenerator = new ProductSiteMapGenerator();
    SiteMapConfigurationImpl siteMapConfig = new SiteMapConfigurationImpl();
    SiteMapBuilder smb = new SiteMapBuilder(siteMapConfig, new FileWorkArea(), "https://example.org/example", true);

    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getUrl()).thenReturn("/");

    // Act
    String actualGenerateUriResult = productSiteMapGenerator.generateUri(smb, product);

    // Assert
    verify(product).getUrl();
    assertEquals("https://example.org/example/", actualGenerateUriResult);
  }

  /**
   * Test {@link ProductSiteMapGenerator#generateUri(SiteMapBuilder, Product)}.
   * <ul>
   *   <li>Given {@code /}.</li>
   *   <li>Then return {@code /}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ProductSiteMapGenerator#generateUri(SiteMapBuilder, Product)}
   */
  @Test
  public void testGenerateUri_givenSlash_thenReturnSlash() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductSiteMapGenerator productSiteMapGenerator = new ProductSiteMapGenerator();
    SiteMapConfigurationImpl siteMapConfig = new SiteMapConfigurationImpl();
    SiteMapBuilder smb = new SiteMapBuilder(siteMapConfig, new FileWorkArea(), "/", true);

    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getUrl()).thenReturn("/");

    // Act
    String actualGenerateUriResult = productSiteMapGenerator.generateUri(smb, product);

    // Assert
    verify(product).getUrl();
    assertEquals("/", actualGenerateUriResult);
  }

  /**
   * Test {@link ProductSiteMapGenerator#generateUri(SiteMapBuilder, Product)}.
   * <ul>
   *   <li>Then return
   * {@code https://example.org/example/https://example.org/example}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ProductSiteMapGenerator#generateUri(SiteMapBuilder, Product)}
   */
  @Test
  public void testGenerateUri_thenReturnHttpsExampleOrgExampleHttpsExampleOrgExample() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductSiteMapGenerator productSiteMapGenerator = new ProductSiteMapGenerator();
    SiteMapConfigurationImpl siteMapConfig = new SiteMapConfigurationImpl();
    SiteMapBuilder smb = new SiteMapBuilder(siteMapConfig, new FileWorkArea(), "https://example.org/example", true);

    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getUrl()).thenReturn("https://example.org/example");

    // Act
    String actualGenerateUriResult = productSiteMapGenerator.generateUri(smb, product);

    // Assert
    verify(product).getUrl();
    assertEquals("https://example.org/example/https://example.org/example", actualGenerateUriResult);
  }

  /**
   * Test {@link ProductSiteMapGenerator#generateDate(Product)}.
   * <p>
   * Method under test: {@link ProductSiteMapGenerator#generateDate(Product)}
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
    //   public class DiffblueFakeClass6088 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.catalog.service.ProductSiteMapGenerator productSiteMapGenerator;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    ProductSiteMapGenerator productSiteMapGenerator2 = new ProductSiteMapGenerator();

    // Act
    productSiteMapGenerator2.generateDate(new ProductBundleImpl());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ProductSiteMapGenerator#setPageSize(int)}
   *   <li>{@link ProductSiteMapGenerator#setProductDao(ProductDao)}
   *   <li>{@link ProductSiteMapGenerator#getPageSize()}
   *   <li>{@link ProductSiteMapGenerator#getProductDao()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    ProductSiteMapGenerator productSiteMapGenerator = new ProductSiteMapGenerator();

    // Act
    productSiteMapGenerator.setPageSize(3);
    ProductDaoImpl productDao = new ProductDaoImpl();
    productSiteMapGenerator.setProductDao(productDao);
    int actualPageSize = productSiteMapGenerator.getPageSize();
    ProductDao actualProductDao = productSiteMapGenerator.getProductDao();

    // Assert that nothing has changed
    assertTrue(actualProductDao instanceof ProductDaoImpl);
    assertEquals(3, actualPageSize);
    assertSame(productDao, actualProductDao);
  }
}
