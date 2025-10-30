/*-
 * #%L
 * BroadleafCommerce Framework
 * %%
 * Copyright (C) 2009 - 2025 Broadleaf Commerce
 * %%
 * Licensed under the Broadleaf Fair Use License Agreement, Version 1.0
 * (the "Fair Use License" located  at http://license.broadleafcommerce.org/fair_use_license-1.0.txt)
 * unless the restrictions on use therein are violated and require payment to Broadleaf in which case
 * the Broadleaf End User License Agreement (EULA), Version 1.1
 * (the "Commercial License" located at http://license.broadleafcommerce.org/commercial_license-1.1.txt)
 * shall apply.
 * 
 * Alternatively, the Commercial License may be replaced with a mutually agreed upon license (the "Custom License")
 * between you and Broadleaf Commerce. You may not use this file except in compliance with the applicable license.
 * #L%
 */
package org.broadleafcommerce.core.catalog.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
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
import org.broadleafcommerce.core.catalog.domain.ProductImpl;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ProductSiteMapGeneratorDiffblueTest {
  @Mock
  private ProductDao productDao;

  @InjectMocks
  private ProductSiteMapGenerator productSiteMapGenerator;

  /**
   * Test {@link ProductSiteMapGenerator#canHandleSiteMapConfiguration(SiteMapGeneratorConfiguration)}.
   * <p>
   * Method under test: {@link ProductSiteMapGenerator#canHandleSiteMapConfiguration(SiteMapGeneratorConfiguration)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ProductSiteMapGenerator.canHandleSiteMapConfiguration(SiteMapGeneratorConfiguration)"})
  public void testCanHandleSiteMapConfiguration() {
    // Arrange
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
   * Test {@link ProductSiteMapGenerator#canHandleSiteMapConfiguration(SiteMapGeneratorConfiguration)}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductSiteMapGenerator#canHandleSiteMapConfiguration(SiteMapGeneratorConfiguration)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ProductSiteMapGenerator.canHandleSiteMapConfiguration(SiteMapGeneratorConfiguration)"})
  public void testCanHandleSiteMapConfiguration_thenReturnTrue() {
    // Arrange
    CustomUrlSiteMapGeneratorConfigurationImpl siteMapGeneratorConfiguration = new CustomUrlSiteMapGeneratorConfigurationImpl();
    siteMapGeneratorConfiguration.setCustomURLEntries(new ArrayList<>());
    siteMapGeneratorConfiguration.setDisabled(true);
    siteMapGeneratorConfiguration.setId(1L);
    siteMapGeneratorConfiguration.setSiteMapChangeFreq(new SiteMapChangeFreqType("Type", "Friendly Type"));
    siteMapGeneratorConfiguration.setSiteMapConfiguration(new SiteMapConfigurationImpl());
    siteMapGeneratorConfiguration.setSiteMapGeneratorType(new SiteMapGeneratorType("PRODUCT", "Friendly Type"));
    siteMapGeneratorConfiguration.setSiteMapPriority(new SiteMapPriorityType("Type", "Friendly Type"));

    // Act and Assert
    assertTrue(productSiteMapGenerator.canHandleSiteMapConfiguration(siteMapGeneratorConfiguration));
  }

  /**
   * Test {@link ProductSiteMapGenerator#canHandleSiteMapConfiguration(SiteMapGeneratorConfiguration)}.
   * <ul>
   *   <li>When {@link CategorySiteMapGeneratorConfigurationImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductSiteMapGenerator#canHandleSiteMapConfiguration(SiteMapGeneratorConfiguration)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ProductSiteMapGenerator.canHandleSiteMapConfiguration(SiteMapGeneratorConfiguration)"})
  public void testCanHandleSiteMapConfiguration_whenCategorySiteMapGeneratorConfigurationImpl() {
    // Arrange, Act and Assert
    assertFalse(productSiteMapGenerator.canHandleSiteMapConfiguration(new CategorySiteMapGeneratorConfigurationImpl()));
  }

  /**
   * Test {@link ProductSiteMapGenerator#addSiteMapEntries(SiteMapGeneratorConfiguration, SiteMapBuilder)}.
   * <p>
   * Method under test: {@link ProductSiteMapGenerator#addSiteMapEntries(SiteMapGeneratorConfiguration, SiteMapBuilder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ProductSiteMapGenerator.addSiteMapEntries(SiteMapGeneratorConfiguration, SiteMapBuilder)"})
  public void testAddSiteMapEntries() {
    // Arrange
    ProductBundleImpl productBundleImpl = mock(ProductBundleImpl.class);
    when(productBundleImpl.getMedia()).thenReturn(new HashMap<>());
    when(productBundleImpl.getUrl()).thenReturn("https://example.org/example");

    ArrayList<Product> productList = new ArrayList<>();
    productList.add(productBundleImpl);
    when(productDao.readAllActiveProductsForSiteMap(anyInt(), anyInt())).thenReturn(productList);
    SiteMapGeneratorConfiguration smgc = mock(SiteMapGeneratorConfiguration.class);
    when(smgc.getSiteMapChangeFreq()).thenReturn(new SiteMapChangeFreqType("Type", "Friendly Type"));
    when(smgc.getSiteMapPriority()).thenReturn(new SiteMapPriorityType("Type", "Friendly Type"));
    SiteMapConfigurationImpl siteMapConfig = new SiteMapConfigurationImpl();

    // Act
    productSiteMapGenerator.addSiteMapEntries(smgc, new SiteMapBuilder(siteMapConfig, new FileWorkArea(), "/", true));

    // Assert
    verify(smgc).getSiteMapChangeFreq();
    verify(smgc).getSiteMapPriority();
    verify(productDao).readAllActiveProductsForSiteMap(eq(0), eq(0));
    verify(productBundleImpl).getMedia();
    verify(productBundleImpl, atLeast(1)).getUrl();
  }

  /**
   * Test {@link ProductSiteMapGenerator#addSiteMapEntries(SiteMapGeneratorConfiguration, SiteMapBuilder)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link ProductBundleImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductSiteMapGenerator#addSiteMapEntries(SiteMapGeneratorConfiguration, SiteMapBuilder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ProductSiteMapGenerator.addSiteMapEntries(SiteMapGeneratorConfiguration, SiteMapBuilder)"})
  public void testAddSiteMapEntries_givenArrayListAddProductBundleImpl() {
    // Arrange
    ArrayList<Product> productList = new ArrayList<>();
    productList.add(new ProductBundleImpl());
    when(productDao.readAllActiveProductsForSiteMap(anyInt(), anyInt())).thenReturn(productList);
    CategorySiteMapGeneratorConfigurationImpl smgc = new CategorySiteMapGeneratorConfigurationImpl();
    SiteMapConfigurationImpl siteMapConfig = new SiteMapConfigurationImpl();

    // Act
    productSiteMapGenerator.addSiteMapEntries(smgc,
        new SiteMapBuilder(siteMapConfig, new FileWorkArea(), "https://example.org/example", true));

    // Assert
    verify(productDao).readAllActiveProductsForSiteMap(eq(0), eq(0));
  }

  /**
   * Test {@link ProductSiteMapGenerator#addSiteMapEntries(SiteMapGeneratorConfiguration, SiteMapBuilder)}.
   * <ul>
   *   <li>Given {@link ProductBundleImpl} {@link ProductImpl#getUrl()} return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductSiteMapGenerator#addSiteMapEntries(SiteMapGeneratorConfiguration, SiteMapBuilder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ProductSiteMapGenerator.addSiteMapEntries(SiteMapGeneratorConfiguration, SiteMapBuilder)"})
  public void testAddSiteMapEntries_givenProductBundleImplGetUrlReturnEmptyString() {
    // Arrange
    ProductBundleImpl productBundleImpl = mock(ProductBundleImpl.class);
    when(productBundleImpl.getUrl()).thenReturn("");

    ArrayList<Product> productList = new ArrayList<>();
    productList.add(productBundleImpl);
    when(productDao.readAllActiveProductsForSiteMap(anyInt(), anyInt())).thenReturn(productList);
    CategorySiteMapGeneratorConfigurationImpl smgc = new CategorySiteMapGeneratorConfigurationImpl();
    SiteMapConfigurationImpl siteMapConfig = new SiteMapConfigurationImpl();

    // Act
    productSiteMapGenerator.addSiteMapEntries(smgc,
        new SiteMapBuilder(siteMapConfig, new FileWorkArea(), "https://example.org/example", true));

    // Assert
    verify(productDao).readAllActiveProductsForSiteMap(eq(0), eq(0));
    verify(productBundleImpl).getUrl();
  }

  /**
   * Test {@link ProductSiteMapGenerator#addSiteMapEntries(SiteMapGeneratorConfiguration, SiteMapBuilder)}.
   * <ul>
   *   <li>Given {@link ProductBundleImpl} {@link ProductImpl#getUrl()} return {@code /}.</li>
   *   <li>Then calls {@link ProductImpl#getMedia()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductSiteMapGenerator#addSiteMapEntries(SiteMapGeneratorConfiguration, SiteMapBuilder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ProductSiteMapGenerator.addSiteMapEntries(SiteMapGeneratorConfiguration, SiteMapBuilder)"})
  public void testAddSiteMapEntries_givenProductBundleImplGetUrlReturnSlash_thenCallsGetMedia() {
    // Arrange
    ProductBundleImpl productBundleImpl = mock(ProductBundleImpl.class);
    when(productBundleImpl.getMedia()).thenReturn(new HashMap<>());
    when(productBundleImpl.getUrl()).thenReturn("/");

    ArrayList<Product> productList = new ArrayList<>();
    productList.add(productBundleImpl);
    when(productDao.readAllActiveProductsForSiteMap(anyInt(), anyInt())).thenReturn(productList);
    CategorySiteMapGeneratorConfigurationImpl smgc = new CategorySiteMapGeneratorConfigurationImpl();
    SiteMapConfigurationImpl siteMapConfig = new SiteMapConfigurationImpl();

    // Act
    productSiteMapGenerator.addSiteMapEntries(smgc,
        new SiteMapBuilder(siteMapConfig, new FileWorkArea(), "https://example.org/example", true));

    // Assert
    verify(productDao).readAllActiveProductsForSiteMap(eq(0), eq(0));
    verify(productBundleImpl).getMedia();
    verify(productBundleImpl, atLeast(1)).getUrl();
  }

  /**
   * Test {@link ProductSiteMapGenerator#addSiteMapEntries(SiteMapGeneratorConfiguration, SiteMapBuilder)}.
   * <ul>
   *   <li>Then calls {@link ProductImpl#getMedia()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductSiteMapGenerator#addSiteMapEntries(SiteMapGeneratorConfiguration, SiteMapBuilder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ProductSiteMapGenerator.addSiteMapEntries(SiteMapGeneratorConfiguration, SiteMapBuilder)"})
  public void testAddSiteMapEntries_thenCallsGetMedia() {
    // Arrange
    ProductBundleImpl productBundleImpl = mock(ProductBundleImpl.class);
    when(productBundleImpl.getMedia()).thenReturn(new HashMap<>());
    when(productBundleImpl.getUrl()).thenReturn("https://example.org/example");

    ArrayList<Product> productList = new ArrayList<>();
    productList.add(productBundleImpl);
    when(productDao.readAllActiveProductsForSiteMap(anyInt(), anyInt())).thenReturn(productList);
    CategorySiteMapGeneratorConfigurationImpl smgc = new CategorySiteMapGeneratorConfigurationImpl();
    SiteMapConfigurationImpl siteMapConfig = new SiteMapConfigurationImpl();

    // Act
    productSiteMapGenerator.addSiteMapEntries(smgc,
        new SiteMapBuilder(siteMapConfig, new FileWorkArea(), "https://example.org/example", true));

    // Assert
    verify(productDao).readAllActiveProductsForSiteMap(eq(0), eq(0));
    verify(productBundleImpl).getMedia();
    verify(productBundleImpl, atLeast(1)).getUrl();
  }

  /**
   * Test {@link ProductSiteMapGenerator#addSiteMapEntries(SiteMapGeneratorConfiguration, SiteMapBuilder)}.
   * <ul>
   *   <li>Then calls {@link SiteMapGeneratorConfiguration#getSiteMapChangeFreq()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductSiteMapGenerator#addSiteMapEntries(SiteMapGeneratorConfiguration, SiteMapBuilder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ProductSiteMapGenerator.addSiteMapEntries(SiteMapGeneratorConfiguration, SiteMapBuilder)"})
  public void testAddSiteMapEntries_thenCallsGetSiteMapChangeFreq() {
    // Arrange
    ProductBundleImpl productBundleImpl = mock(ProductBundleImpl.class);
    when(productBundleImpl.getMedia()).thenReturn(new HashMap<>());
    when(productBundleImpl.getUrl()).thenReturn("https://example.org/example");

    ArrayList<Product> productList = new ArrayList<>();
    productList.add(productBundleImpl);
    when(productDao.readAllActiveProductsForSiteMap(anyInt(), anyInt())).thenReturn(productList);
    SiteMapGeneratorConfiguration smgc = mock(SiteMapGeneratorConfiguration.class);
    when(smgc.getSiteMapChangeFreq()).thenReturn(new SiteMapChangeFreqType("Type", "Friendly Type"));
    when(smgc.getSiteMapPriority()).thenReturn(new SiteMapPriorityType("Type", "Friendly Type"));
    SiteMapConfigurationImpl siteMapConfig = new SiteMapConfigurationImpl();

    // Act
    productSiteMapGenerator.addSiteMapEntries(smgc,
        new SiteMapBuilder(siteMapConfig, new FileWorkArea(), "https://example.org/example", true));

    // Assert
    verify(smgc).getSiteMapChangeFreq();
    verify(smgc).getSiteMapPriority();
    verify(productDao).readAllActiveProductsForSiteMap(eq(0), eq(0));
    verify(productBundleImpl).getMedia();
    verify(productBundleImpl, atLeast(1)).getUrl();
  }

  /**
   * Test {@link ProductSiteMapGenerator#constructImageURLs(SiteMapBuilder, SiteMapURLWrapper, Product)}.
   * <p>
   * Method under test: {@link ProductSiteMapGenerator#constructImageURLs(SiteMapBuilder, SiteMapURLWrapper, Product)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ProductSiteMapGenerator.constructImageURLs(SiteMapBuilder, SiteMapURLWrapper, Product)"})
  public void testConstructImageURLs() {
    // Arrange
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
   * Test {@link ProductSiteMapGenerator#constructImageURLs(SiteMapBuilder, SiteMapURLWrapper, Product)}.
   * <p>
   * Method under test: {@link ProductSiteMapGenerator#constructImageURLs(SiteMapBuilder, SiteMapURLWrapper, Product)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ProductSiteMapGenerator.constructImageURLs(SiteMapBuilder, SiteMapURLWrapper, Product)"})
  public void testConstructImageURLs2() {
    // Arrange
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
   * Test {@link ProductSiteMapGenerator#constructImageURLs(SiteMapBuilder, SiteMapURLWrapper, Product)}.
   * <ul>
   *   <li>Given {@link MediaImpl} (default constructor) Url is {@code /}.</li>
   *   <li>Then calls {@link SiteMapURLWrapper#addImage(SiteMapImageWrapper)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductSiteMapGenerator#constructImageURLs(SiteMapBuilder, SiteMapURLWrapper, Product)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ProductSiteMapGenerator.constructImageURLs(SiteMapBuilder, SiteMapURLWrapper, Product)"})
  public void testConstructImageURLs_givenMediaImplUrlIsSlash_thenCallsAddImage() {
    // Arrange
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
   * Test {@link ProductSiteMapGenerator#constructImageURLs(SiteMapBuilder, SiteMapURLWrapper, Product)}.
   * <ul>
   *   <li>Then calls {@link SiteMapURLWrapper#addImage(SiteMapImageWrapper)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductSiteMapGenerator#constructImageURLs(SiteMapBuilder, SiteMapURLWrapper, Product)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ProductSiteMapGenerator.constructImageURLs(SiteMapBuilder, SiteMapURLWrapper, Product)"})
  public void testConstructImageURLs_thenCallsAddImage() {
    // Arrange
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
   * Test {@link ProductSiteMapGenerator#constructImageURLs(SiteMapBuilder, SiteMapURLWrapper, Product)}.
   * <ul>
   *   <li>Then {@link SiteMapURLWrapper} (default constructor) SiteMapImageWrappers Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductSiteMapGenerator#constructImageURLs(SiteMapBuilder, SiteMapURLWrapper, Product)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ProductSiteMapGenerator.constructImageURLs(SiteMapBuilder, SiteMapURLWrapper, Product)"})
  public void testConstructImageURLs_thenSiteMapURLWrapperSiteMapImageWrappersEmpty() {
    // Arrange
    SiteMapConfigurationImpl siteMapConfig = new SiteMapConfigurationImpl();
    SiteMapBuilder siteMapBuilder = new SiteMapBuilder(siteMapConfig, new FileWorkArea(), "https://example.org/example",
        true);

    SiteMapURLWrapper siteMapUrl = new SiteMapURLWrapper();
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getMedia()).thenReturn(new HashMap<>());

    // Act
    productSiteMapGenerator.constructImageURLs(siteMapBuilder, siteMapUrl, product);

    // Assert that nothing has changed
    verify(product).getMedia();
    assertTrue(siteMapUrl.getSiteMapImageWrappers().isEmpty());
  }

  /**
   * Test {@link ProductSiteMapGenerator#generateUri(SiteMapBuilder, Product)}.
   * <ul>
   *   <li>Given {@code https://example.org/example}.</li>
   *   <li>Then return {@code /https://example.org/example}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductSiteMapGenerator#generateUri(SiteMapBuilder, Product)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String ProductSiteMapGenerator.generateUri(SiteMapBuilder, Product)"})
  public void testGenerateUri_givenHttpsExampleOrgExample_thenReturnHttpsExampleOrgExample() {
    // Arrange
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
   * Method under test: {@link ProductSiteMapGenerator#generateUri(SiteMapBuilder, Product)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String ProductSiteMapGenerator.generateUri(SiteMapBuilder, Product)"})
  public void testGenerateUri_givenSlash_thenReturnHttpsExampleOrgExample() {
    // Arrange
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
   * Method under test: {@link ProductSiteMapGenerator#generateUri(SiteMapBuilder, Product)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String ProductSiteMapGenerator.generateUri(SiteMapBuilder, Product)"})
  public void testGenerateUri_givenSlash_thenReturnSlash() {
    // Arrange
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
   *   <li>Then return {@code https://example.org/example/https://example.org/example}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductSiteMapGenerator#generateUri(SiteMapBuilder, Product)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String ProductSiteMapGenerator.generateUri(SiteMapBuilder, Product)"})
  public void testGenerateUri_thenReturnHttpsExampleOrgExampleHttpsExampleOrgExample() {
    // Arrange
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int ProductSiteMapGenerator.getPageSize()", "ProductDao ProductSiteMapGenerator.getProductDao()",
      "void ProductSiteMapGenerator.setPageSize(int)", "void ProductSiteMapGenerator.setProductDao(ProductDao)"})
  public void testGettersAndSetters() {
    // Arrange
    ProductSiteMapGenerator productSiteMapGenerator = new ProductSiteMapGenerator();

    // Act
    productSiteMapGenerator.setPageSize(3);
    ProductDaoImpl productDao = new ProductDaoImpl();
    productSiteMapGenerator.setProductDao(productDao);
    int actualPageSize = productSiteMapGenerator.getPageSize();
    ProductDao actualProductDao = productSiteMapGenerator.getProductDao();

    // Assert
    assertTrue(actualProductDao instanceof ProductDaoImpl);
    assertEquals(3, actualPageSize);
    assertSame(productDao, actualProductDao);
  }
}
