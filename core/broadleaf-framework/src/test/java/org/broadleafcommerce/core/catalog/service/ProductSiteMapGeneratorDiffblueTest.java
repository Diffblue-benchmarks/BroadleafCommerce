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
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
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
import org.broadleafcommerce.common.sitemap.domain.SiteMapGeneratorConfigurationImpl;
import org.broadleafcommerce.common.sitemap.service.SiteMapBuilder;
import org.broadleafcommerce.common.sitemap.service.type.SiteMapChangeFreqType;
import org.broadleafcommerce.common.sitemap.service.type.SiteMapGeneratorType;
import org.broadleafcommerce.common.sitemap.service.type.SiteMapPriorityType;
import org.broadleafcommerce.common.sitemap.wrapper.SiteMapImageWrapper;
import org.broadleafcommerce.common.sitemap.wrapper.SiteMapURLWrapper;
import org.broadleafcommerce.core.catalog.dao.ProductDao;
import org.broadleafcommerce.core.catalog.dao.ProductDaoImpl;
import org.broadleafcommerce.core.catalog.domain.Product;
import org.broadleafcommerce.core.catalog.domain.ProductBundleImpl;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ProductSiteMapGeneratorDiffblueTest {
  @Mock private ProductDao productDao;

  @InjectMocks private ProductSiteMapGenerator productSiteMapGenerator;

  /**
   * Test {@link
   * ProductSiteMapGenerator#canHandleSiteMapConfiguration(SiteMapGeneratorConfiguration)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ProductSiteMapGenerator#canHandleSiteMapConfiguration(SiteMapGeneratorConfiguration)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ProductSiteMapGenerator.canHandleSiteMapConfiguration(SiteMapGeneratorConfiguration)"
  })
  public void testCanHandleSiteMapConfiguration_givenArrayList() {
    // Arrange
    CustomUrlSiteMapGeneratorConfigurationImpl siteMapGeneratorConfiguration =
        new CustomUrlSiteMapGeneratorConfigurationImpl();
    siteMapGeneratorConfiguration.setCustomURLEntries(new ArrayList<>());
    siteMapGeneratorConfiguration.setDisabled(true);
    siteMapGeneratorConfiguration.setId(1L);
    siteMapGeneratorConfiguration.setSiteMapChangeFreq(
        new SiteMapChangeFreqType("Type", "Friendly Type"));
    siteMapGeneratorConfiguration.setSiteMapConfiguration(new SiteMapConfigurationImpl());
    siteMapGeneratorConfiguration.setSiteMapGeneratorType(
        new SiteMapGeneratorType("Type", "Friendly Type"));
    siteMapGeneratorConfiguration.setSiteMapPriority(
        new SiteMapPriorityType("Type", "Friendly Type"));

    // Act and Assert
    assertFalse(
        productSiteMapGenerator.canHandleSiteMapConfiguration(siteMapGeneratorConfiguration));
  }

  /**
   * Test {@link
   * ProductSiteMapGenerator#canHandleSiteMapConfiguration(SiteMapGeneratorConfiguration)}.
   *
   * <ul>
   *   <li>Given {@link SiteMapGeneratorType#PRODUCT}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ProductSiteMapGenerator#canHandleSiteMapConfiguration(SiteMapGeneratorConfiguration)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ProductSiteMapGenerator.canHandleSiteMapConfiguration(SiteMapGeneratorConfiguration)"
  })
  public void testCanHandleSiteMapConfiguration_givenProduct_thenReturnTrue() {
    // Arrange
    SiteMapGeneratorConfiguration siteMapGeneratorConfiguration =
        mock(SiteMapGeneratorConfiguration.class);
    when(siteMapGeneratorConfiguration.getSiteMapGeneratorType())
        .thenReturn(SiteMapGeneratorType.PRODUCT);

    // Act
    boolean actualCanHandleSiteMapConfigurationResult =
        productSiteMapGenerator.canHandleSiteMapConfiguration(siteMapGeneratorConfiguration);

    // Assert
    verify(siteMapGeneratorConfiguration).getSiteMapGeneratorType();
    assertTrue(actualCanHandleSiteMapConfigurationResult);
  }

  /**
   * Test {@link
   * ProductSiteMapGenerator#canHandleSiteMapConfiguration(SiteMapGeneratorConfiguration)}.
   *
   * <ul>
   *   <li>When {@link SiteMapGeneratorConfigurationImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link
   * ProductSiteMapGenerator#canHandleSiteMapConfiguration(SiteMapGeneratorConfiguration)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ProductSiteMapGenerator.canHandleSiteMapConfiguration(SiteMapGeneratorConfiguration)"
  })
  public void testCanHandleSiteMapConfiguration_whenSiteMapGeneratorConfigurationImpl() {
    // Arrange, Act and Assert
    assertFalse(
        productSiteMapGenerator.canHandleSiteMapConfiguration(
            new SiteMapGeneratorConfigurationImpl()));
  }

  /**
   * Test {@link ProductSiteMapGenerator#addSiteMapEntries(SiteMapGeneratorConfiguration,
   * SiteMapBuilder)}.
   *
   * <p>Method under test: {@link
   * ProductSiteMapGenerator#addSiteMapEntries(SiteMapGeneratorConfiguration, SiteMapBuilder)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ProductSiteMapGenerator.addSiteMapEntries(SiteMapGeneratorConfiguration, SiteMapBuilder)"
  })
  public void testAddSiteMapEntries() {
    // Arrange
    ProductBundleImpl productBundleImpl = mock(ProductBundleImpl.class);
    when(productBundleImpl.getMedia()).thenReturn(new HashMap<>());
    when(productBundleImpl.getUrl()).thenReturn("https://example.org/example");

    ArrayList<Product> productList = new ArrayList<>();
    productList.add(productBundleImpl);
    when(productDao.readAllActiveProductsForSiteMap(anyInt(), anyInt())).thenReturn(productList);

    SiteMapGeneratorConfiguration smgc = mock(SiteMapGeneratorConfiguration.class);
    when(smgc.getSiteMapChangeFreq())
        .thenReturn(new SiteMapChangeFreqType("Type", "Friendly Type"));
    when(smgc.getSiteMapPriority()).thenReturn(new SiteMapPriorityType("Type", "Friendly Type"));

    FileWorkArea fileWorkArea = new FileWorkArea();
    fileWorkArea.setFilePathLocation("/directory/foo.txt");
    SiteMapBuilder siteMapBuilder =
        new SiteMapBuilder(new SiteMapConfigurationImpl(), fileWorkArea, "/", true);

    // Act
    productSiteMapGenerator.addSiteMapEntries(smgc, siteMapBuilder);

    // Assert
    verify(smgc).getSiteMapChangeFreq();
    verify(smgc).getSiteMapPriority();
    verify(productDao).readAllActiveProductsForSiteMap(0, 0);
    verify(productBundleImpl).getMedia();
    verify(productBundleImpl, atLeast(1)).getUrl();
  }

  /**
   * Test {@link ProductSiteMapGenerator#addSiteMapEntries(SiteMapGeneratorConfiguration,
   * SiteMapBuilder)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link ProductBundleImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link
   * ProductSiteMapGenerator#addSiteMapEntries(SiteMapGeneratorConfiguration, SiteMapBuilder)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ProductSiteMapGenerator.addSiteMapEntries(SiteMapGeneratorConfiguration, SiteMapBuilder)"
  })
  public void testAddSiteMapEntries_givenArrayListAddProductBundleImpl() {
    // Arrange
    ArrayList<Product> productList = new ArrayList<>();
    productList.add(new ProductBundleImpl());
    when(productDao.readAllActiveProductsForSiteMap(anyInt(), anyInt())).thenReturn(productList);
    SiteMapGeneratorConfigurationImpl smgc = new SiteMapGeneratorConfigurationImpl();

    FileWorkArea fileWorkArea = new FileWorkArea();
    fileWorkArea.setFilePathLocation("/directory/foo.txt");
    SiteMapBuilder siteMapBuilder =
        new SiteMapBuilder(
            new SiteMapConfigurationImpl(), fileWorkArea, "https://example.org/example", true);

    // Act
    productSiteMapGenerator.addSiteMapEntries(smgc, siteMapBuilder);

    // Assert
    verify(productDao).readAllActiveProductsForSiteMap(0, 0);
  }

  /**
   * Test {@link ProductSiteMapGenerator#addSiteMapEntries(SiteMapGeneratorConfiguration,
   * SiteMapBuilder)}.
   *
   * <ul>
   *   <li>Given {@code https://example.org/example}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ProductSiteMapGenerator#addSiteMapEntries(SiteMapGeneratorConfiguration, SiteMapBuilder)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ProductSiteMapGenerator.addSiteMapEntries(SiteMapGeneratorConfiguration, SiteMapBuilder)"
  })
  public void testAddSiteMapEntries_givenHttpsExampleOrgExample() {
    // Arrange
    ProductBundleImpl productBundleImpl = mock(ProductBundleImpl.class);
    when(productBundleImpl.getMedia()).thenReturn(new HashMap<>());
    when(productBundleImpl.getUrl()).thenReturn("//");

    ArrayList<Product> productList = new ArrayList<>();
    productList.add(productBundleImpl);
    when(productDao.readAllActiveProductsForSiteMap(anyInt(), anyInt())).thenReturn(productList);

    SiteMapGeneratorConfiguration smgc = mock(SiteMapGeneratorConfiguration.class);
    when(smgc.getSiteMapChangeFreq())
        .thenReturn(new SiteMapChangeFreqType("Type", "Friendly Type"));
    when(smgc.getSiteMapPriority()).thenReturn(new SiteMapPriorityType("Type", "Friendly Type"));

    SiteMapBuilder siteMapBuilder = mock(SiteMapBuilder.class);
    doNothing().when(siteMapBuilder).addUrl(Mockito.<SiteMapURLWrapper>any());
    when(siteMapBuilder.getBaseUrl()).thenReturn("https://example.org/example");

    // Act
    productSiteMapGenerator.addSiteMapEntries(smgc, siteMapBuilder);

    // Assert
    verify(smgc).getSiteMapChangeFreq();
    verify(smgc).getSiteMapPriority();
    verify(siteMapBuilder).addUrl(isA(SiteMapURLWrapper.class));
    verify(siteMapBuilder).getBaseUrl();
    verify(productDao).readAllActiveProductsForSiteMap(0, 0);
    verify(productBundleImpl).getMedia();
    verify(productBundleImpl, atLeast(1)).getUrl();
  }

  /**
   * Test {@link ProductSiteMapGenerator#addSiteMapEntries(SiteMapGeneratorConfiguration,
   * SiteMapBuilder)}.
   *
   * <ul>
   *   <li>Given {@link MediaImpl} (default constructor) AltText is {@code /}.
   *   <li>Then calls {@link SiteMapBuilder#addUrl(SiteMapURLWrapper)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ProductSiteMapGenerator#addSiteMapEntries(SiteMapGeneratorConfiguration, SiteMapBuilder)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ProductSiteMapGenerator.addSiteMapEntries(SiteMapGeneratorConfiguration, SiteMapBuilder)"
  })
  public void testAddSiteMapEntries_givenMediaImplAltTextIsSlash_thenCallsAddUrl() {
    // Arrange
    MediaImpl mediaImpl = new MediaImpl();
    mediaImpl.setAltText("/");
    mediaImpl.setId(1L);
    mediaImpl.setTags("/");
    mediaImpl.setTitle("Dr");
    mediaImpl.setUrl("https://example.org/example");

    HashMap<String, Media> stringMediaMap = new HashMap<>();
    stringMediaMap.put(":", mediaImpl);

    ProductBundleImpl productBundleImpl = mock(ProductBundleImpl.class);
    when(productBundleImpl.getMedia()).thenReturn(stringMediaMap);
    when(productBundleImpl.getUrl()).thenReturn("//");

    ArrayList<Product> productList = new ArrayList<>();
    productList.add(productBundleImpl);
    when(productDao.readAllActiveProductsForSiteMap(anyInt(), anyInt())).thenReturn(productList);

    SiteMapGeneratorConfiguration smgc = mock(SiteMapGeneratorConfiguration.class);
    when(smgc.getSiteMapChangeFreq())
        .thenReturn(new SiteMapChangeFreqType("Type", "Friendly Type"));
    when(smgc.getSiteMapPriority()).thenReturn(new SiteMapPriorityType("Type", "Friendly Type"));

    SiteMapBuilder siteMapBuilder = mock(SiteMapBuilder.class);
    doNothing().when(siteMapBuilder).addUrl(Mockito.<SiteMapURLWrapper>any());
    when(siteMapBuilder.getBaseUrl()).thenReturn("/");

    // Act
    productSiteMapGenerator.addSiteMapEntries(smgc, siteMapBuilder);

    // Assert
    verify(smgc).getSiteMapChangeFreq();
    verify(smgc).getSiteMapPriority();
    verify(siteMapBuilder).addUrl(isA(SiteMapURLWrapper.class));
    verify(siteMapBuilder, atLeast(1)).getBaseUrl();
    verify(productDao).readAllActiveProductsForSiteMap(0, 0);
    verify(productBundleImpl).getMedia();
    verify(productBundleImpl, atLeast(1)).getUrl();
  }

  /**
   * Test {@link ProductSiteMapGenerator#addSiteMapEntries(SiteMapGeneratorConfiguration,
   * SiteMapBuilder)}.
   *
   * <ul>
   *   <li>Given {@link ProductBundleImpl} {@link ProductBundleImpl#getUrl()} return empty string.
   * </ul>
   *
   * <p>Method under test: {@link
   * ProductSiteMapGenerator#addSiteMapEntries(SiteMapGeneratorConfiguration, SiteMapBuilder)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ProductSiteMapGenerator.addSiteMapEntries(SiteMapGeneratorConfiguration, SiteMapBuilder)"
  })
  public void testAddSiteMapEntries_givenProductBundleImplGetUrlReturnEmptyString() {
    // Arrange
    ProductBundleImpl productBundleImpl = mock(ProductBundleImpl.class);
    when(productBundleImpl.getUrl()).thenReturn("");

    ArrayList<Product> productList = new ArrayList<>();
    productList.add(productBundleImpl);
    when(productDao.readAllActiveProductsForSiteMap(anyInt(), anyInt())).thenReturn(productList);

    // Act
    productSiteMapGenerator.addSiteMapEntries(
        mock(SiteMapGeneratorConfiguration.class), mock(SiteMapBuilder.class));

    // Assert
    verify(productDao).readAllActiveProductsForSiteMap(0, 0);
    verify(productBundleImpl).getUrl();
  }

  /**
   * Test {@link ProductSiteMapGenerator#addSiteMapEntries(SiteMapGeneratorConfiguration,
   * SiteMapBuilder)}.
   *
   * <ul>
   *   <li>Given {@code /}.
   *   <li>Then calls {@link SiteMapBuilder#addUrl(SiteMapURLWrapper)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ProductSiteMapGenerator#addSiteMapEntries(SiteMapGeneratorConfiguration, SiteMapBuilder)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ProductSiteMapGenerator.addSiteMapEntries(SiteMapGeneratorConfiguration, SiteMapBuilder)"
  })
  public void testAddSiteMapEntries_givenSlash_thenCallsAddUrl() {
    // Arrange
    ProductBundleImpl productBundleImpl = mock(ProductBundleImpl.class);
    when(productBundleImpl.getMedia()).thenReturn(new HashMap<>());
    when(productBundleImpl.getUrl()).thenReturn("//");

    ArrayList<Product> productList = new ArrayList<>();
    productList.add(productBundleImpl);
    when(productDao.readAllActiveProductsForSiteMap(anyInt(), anyInt())).thenReturn(productList);

    SiteMapGeneratorConfiguration smgc = mock(SiteMapGeneratorConfiguration.class);
    when(smgc.getSiteMapChangeFreq())
        .thenReturn(new SiteMapChangeFreqType("Type", "Friendly Type"));
    when(smgc.getSiteMapPriority()).thenReturn(new SiteMapPriorityType("Type", "Friendly Type"));

    SiteMapBuilder siteMapBuilder = mock(SiteMapBuilder.class);
    doNothing().when(siteMapBuilder).addUrl(Mockito.<SiteMapURLWrapper>any());
    when(siteMapBuilder.getBaseUrl()).thenReturn("/");

    // Act
    productSiteMapGenerator.addSiteMapEntries(smgc, siteMapBuilder);

    // Assert
    verify(smgc).getSiteMapChangeFreq();
    verify(smgc).getSiteMapPriority();
    verify(siteMapBuilder).addUrl(isA(SiteMapURLWrapper.class));
    verify(siteMapBuilder).getBaseUrl();
    verify(productDao).readAllActiveProductsForSiteMap(0, 0);
    verify(productBundleImpl).getMedia();
    verify(productBundleImpl, atLeast(1)).getUrl();
  }

  /**
   * Test {@link ProductSiteMapGenerator#addSiteMapEntries(SiteMapGeneratorConfiguration,
   * SiteMapBuilder)}.
   *
   * <ul>
   *   <li>Then calls {@link SiteMapGeneratorConfiguration#getSiteMapChangeFreq()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ProductSiteMapGenerator#addSiteMapEntries(SiteMapGeneratorConfiguration, SiteMapBuilder)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ProductSiteMapGenerator.addSiteMapEntries(SiteMapGeneratorConfiguration, SiteMapBuilder)"
  })
  public void testAddSiteMapEntries_thenCallsGetSiteMapChangeFreq() {
    // Arrange
    ProductBundleImpl productBundleImpl = mock(ProductBundleImpl.class);
    when(productBundleImpl.getMedia()).thenReturn(new HashMap<>());
    when(productBundleImpl.getUrl()).thenReturn("https://example.org/example");

    ArrayList<Product> productList = new ArrayList<>();
    productList.add(productBundleImpl);
    when(productDao.readAllActiveProductsForSiteMap(anyInt(), anyInt())).thenReturn(productList);

    SiteMapGeneratorConfiguration smgc = mock(SiteMapGeneratorConfiguration.class);
    when(smgc.getSiteMapChangeFreq())
        .thenReturn(new SiteMapChangeFreqType("Type", "Friendly Type"));
    when(smgc.getSiteMapPriority()).thenReturn(new SiteMapPriorityType("Type", "Friendly Type"));

    FileWorkArea fileWorkArea = new FileWorkArea();
    fileWorkArea.setFilePathLocation("/directory/foo.txt");
    SiteMapBuilder siteMapBuilder =
        new SiteMapBuilder(
            new SiteMapConfigurationImpl(), fileWorkArea, "https://example.org/example", true);

    // Act
    productSiteMapGenerator.addSiteMapEntries(smgc, siteMapBuilder);

    // Assert
    verify(smgc).getSiteMapChangeFreq();
    verify(smgc).getSiteMapPriority();
    verify(productDao).readAllActiveProductsForSiteMap(0, 0);
    verify(productBundleImpl).getMedia();
    verify(productBundleImpl, atLeast(1)).getUrl();
  }

  /**
   * Test {@link ProductSiteMapGenerator#addSiteMapEntries(SiteMapGeneratorConfiguration,
   * SiteMapBuilder)}.
   *
   * <ul>
   *   <li>When {@link SiteMapGeneratorConfigurationImpl} (default constructor).
   *   <li>Then calls {@link ProductBundleImpl#getMedia()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ProductSiteMapGenerator#addSiteMapEntries(SiteMapGeneratorConfiguration, SiteMapBuilder)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ProductSiteMapGenerator.addSiteMapEntries(SiteMapGeneratorConfiguration, SiteMapBuilder)"
  })
  public void testAddSiteMapEntries_whenSiteMapGeneratorConfigurationImpl_thenCallsGetMedia() {
    // Arrange
    ProductBundleImpl productBundleImpl = mock(ProductBundleImpl.class);
    when(productBundleImpl.getMedia()).thenReturn(new HashMap<>());
    when(productBundleImpl.getUrl()).thenReturn("https://example.org/example");

    ArrayList<Product> productList = new ArrayList<>();
    productList.add(productBundleImpl);
    when(productDao.readAllActiveProductsForSiteMap(anyInt(), anyInt())).thenReturn(productList);
    SiteMapGeneratorConfigurationImpl smgc = new SiteMapGeneratorConfigurationImpl();

    FileWorkArea fileWorkArea = new FileWorkArea();
    fileWorkArea.setFilePathLocation("/directory/foo.txt");
    SiteMapBuilder siteMapBuilder =
        new SiteMapBuilder(
            new SiteMapConfigurationImpl(), fileWorkArea, "https://example.org/example", true);

    // Act
    productSiteMapGenerator.addSiteMapEntries(smgc, siteMapBuilder);

    // Assert
    verify(productDao).readAllActiveProductsForSiteMap(0, 0);
    verify(productBundleImpl).getMedia();
    verify(productBundleImpl, atLeast(1)).getUrl();
  }

  /**
   * Test {@link ProductSiteMapGenerator#constructImageURLs(SiteMapBuilder, SiteMapURLWrapper,
   * Product)}.
   *
   * <p>Method under test: {@link ProductSiteMapGenerator#constructImageURLs(SiteMapBuilder,
   * SiteMapURLWrapper, Product)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ProductSiteMapGenerator.constructImageURLs(SiteMapBuilder, SiteMapURLWrapper, Product)"
  })
  public void testConstructImageURLs() {
    // Arrange
    FileWorkArea fileWorkArea = new FileWorkArea();
    fileWorkArea.setFilePathLocation("/directory/foo.txt");
    SiteMapBuilder siteMapBuilder =
        new SiteMapBuilder(
            new SiteMapConfigurationImpl(), fileWorkArea, "https://example.org/example", true);
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
    assertEquals(
        "https://example.org/example/https://example.org/example",
        siteMapImageWrappers.get(0).getLoc());
  }

  /**
   * Test {@link ProductSiteMapGenerator#constructImageURLs(SiteMapBuilder, SiteMapURLWrapper,
   * Product)}.
   *
   * <p>Method under test: {@link ProductSiteMapGenerator#constructImageURLs(SiteMapBuilder,
   * SiteMapURLWrapper, Product)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ProductSiteMapGenerator.constructImageURLs(SiteMapBuilder, SiteMapURLWrapper, Product)"
  })
  public void testConstructImageURLs2() {
    // Arrange
    SiteMapBuilder siteMapBuilder = mock(SiteMapBuilder.class);
    when(siteMapBuilder.getBaseUrl()).thenReturn("/");
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
    verify(siteMapBuilder).getBaseUrl();
    verify(product).getMedia();
    List<SiteMapImageWrapper> siteMapImageWrappers = siteMapUrl.getSiteMapImageWrappers();
    assertEquals(1, siteMapImageWrappers.size());
    assertEquals("/https://example.org/example", siteMapImageWrappers.get(0).getLoc());
  }

  /**
   * Test {@link ProductSiteMapGenerator#constructImageURLs(SiteMapBuilder, SiteMapURLWrapper,
   * Product)}.
   *
   * <ul>
   *   <li>Given {@code https://example.org/example}.
   * </ul>
   *
   * <p>Method under test: {@link ProductSiteMapGenerator#constructImageURLs(SiteMapBuilder,
   * SiteMapURLWrapper, Product)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ProductSiteMapGenerator.constructImageURLs(SiteMapBuilder, SiteMapURLWrapper, Product)"
  })
  public void testConstructImageURLs_givenHttpsExampleOrgExample() {
    // Arrange
    SiteMapBuilder siteMapBuilder = mock(SiteMapBuilder.class);
    when(siteMapBuilder.getBaseUrl()).thenReturn("https://example.org/example");

    SiteMapURLWrapper siteMapUrl = mock(SiteMapURLWrapper.class);
    doNothing().when(siteMapUrl).addImage(Mockito.<SiteMapImageWrapper>any());

    Media media = mock(Media.class);
    when(media.getUrl()).thenReturn("/");

    HashMap<String, Media> stringMediaMap = new HashMap<>();
    stringMediaMap.put("foo", media);

    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getMedia()).thenReturn(stringMediaMap);

    // Act
    productSiteMapGenerator.constructImageURLs(siteMapBuilder, siteMapUrl, product);

    // Assert
    verify(media).getUrl();
    verify(siteMapBuilder).getBaseUrl();
    verify(siteMapUrl).addImage(isA(SiteMapImageWrapper.class));
    verify(product).getMedia();
  }

  /**
   * Test {@link ProductSiteMapGenerator#constructImageURLs(SiteMapBuilder, SiteMapURLWrapper,
   * Product)}.
   *
   * <ul>
   *   <li>Then calls {@link SiteMapURLWrapper#addImage(SiteMapImageWrapper)}.
   * </ul>
   *
   * <p>Method under test: {@link ProductSiteMapGenerator#constructImageURLs(SiteMapBuilder,
   * SiteMapURLWrapper, Product)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ProductSiteMapGenerator.constructImageURLs(SiteMapBuilder, SiteMapURLWrapper, Product)"
  })
  public void testConstructImageURLs_thenCallsAddImage() {
    // Arrange
    SiteMapBuilder siteMapBuilder = mock(SiteMapBuilder.class);
    when(siteMapBuilder.getBaseUrl()).thenReturn("/");

    SiteMapURLWrapper siteMapUrl = mock(SiteMapURLWrapper.class);
    doNothing().when(siteMapUrl).addImage(Mockito.<SiteMapImageWrapper>any());

    Media media = mock(Media.class);
    when(media.getUrl()).thenReturn("/");

    HashMap<String, Media> stringMediaMap = new HashMap<>();
    stringMediaMap.put("foo", media);

    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getMedia()).thenReturn(stringMediaMap);

    // Act
    productSiteMapGenerator.constructImageURLs(siteMapBuilder, siteMapUrl, product);

    // Assert
    verify(media).getUrl();
    verify(siteMapBuilder).getBaseUrl();
    verify(siteMapUrl).addImage(isA(SiteMapImageWrapper.class));
    verify(product).getMedia();
  }

  /**
   * Test {@link ProductSiteMapGenerator#constructImageURLs(SiteMapBuilder, SiteMapURLWrapper,
   * Product)}.
   *
   * <ul>
   *   <li>Then {@link SiteMapURLWrapper} (default constructor) SiteMapImageWrappers Empty.
   * </ul>
   *
   * <p>Method under test: {@link ProductSiteMapGenerator#constructImageURLs(SiteMapBuilder,
   * SiteMapURLWrapper, Product)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ProductSiteMapGenerator.constructImageURLs(SiteMapBuilder, SiteMapURLWrapper, Product)"
  })
  public void testConstructImageURLs_thenSiteMapURLWrapperSiteMapImageWrappersEmpty() {
    // Arrange
    FileWorkArea fileWorkArea = new FileWorkArea();
    fileWorkArea.setFilePathLocation("/directory/foo.txt");
    SiteMapBuilder siteMapBuilder =
        new SiteMapBuilder(
            new SiteMapConfigurationImpl(), fileWorkArea, "https://example.org/example", true);
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
   * Test {@link ProductSiteMapGenerator#constructImageURLs(SiteMapBuilder, SiteMapURLWrapper,
   * Product)}.
   *
   * <ul>
   *   <li>Then {@link SiteMapURLWrapper} (default constructor) SiteMapImageWrappers first Loc is
   *       {@code /}.
   * </ul>
   *
   * <p>Method under test: {@link ProductSiteMapGenerator#constructImageURLs(SiteMapBuilder,
   * SiteMapURLWrapper, Product)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ProductSiteMapGenerator.constructImageURLs(SiteMapBuilder, SiteMapURLWrapper, Product)"
  })
  public void testConstructImageURLs_thenSiteMapURLWrapperSiteMapImageWrappersFirstLocIsSlash() {
    // Arrange
    SiteMapBuilder siteMapBuilder = mock(SiteMapBuilder.class);
    when(siteMapBuilder.getBaseUrl()).thenReturn("/");
    SiteMapURLWrapper siteMapUrl = new SiteMapURLWrapper();

    Media media = mock(Media.class);
    when(media.getUrl()).thenReturn("/");

    HashMap<String, Media> stringMediaMap = new HashMap<>();
    stringMediaMap.put("foo", media);

    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getMedia()).thenReturn(stringMediaMap);

    // Act
    productSiteMapGenerator.constructImageURLs(siteMapBuilder, siteMapUrl, product);

    // Assert
    verify(media).getUrl();
    verify(siteMapBuilder).getBaseUrl();
    verify(product).getMedia();
    List<SiteMapImageWrapper> siteMapImageWrappers = siteMapUrl.getSiteMapImageWrappers();
    assertEquals(1, siteMapImageWrappers.size());
    assertEquals("/", siteMapImageWrappers.get(0).getLoc());
  }

  /**
   * Test {@link ProductSiteMapGenerator#generateUri(SiteMapBuilder, Product)}.
   *
   * <ul>
   *   <li>Given {@code https://example.org/example}.
   *   <li>Then return {@code /https://example.org/example}.
   * </ul>
   *
   * <p>Method under test: {@link ProductSiteMapGenerator#generateUri(SiteMapBuilder, Product)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ProductSiteMapGenerator.generateUri(SiteMapBuilder, Product)"})
  public void testGenerateUri_givenHttpsExampleOrgExample_thenReturnHttpsExampleOrgExample() {
    // Arrange
    FileWorkArea fileWorkArea = new FileWorkArea();
    fileWorkArea.setFilePathLocation("/directory/foo.txt");
    SiteMapBuilder smb =
        new SiteMapBuilder(new SiteMapConfigurationImpl(), fileWorkArea, "/", true);

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
   *
   * <ul>
   *   <li>Given {@code /}.
   *   <li>Then return {@code https://example.org/example/}.
   * </ul>
   *
   * <p>Method under test: {@link ProductSiteMapGenerator#generateUri(SiteMapBuilder, Product)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ProductSiteMapGenerator.generateUri(SiteMapBuilder, Product)"})
  public void testGenerateUri_givenSlash_thenReturnHttpsExampleOrgExample() {
    // Arrange
    FileWorkArea fileWorkArea = new FileWorkArea();
    fileWorkArea.setFilePathLocation("/directory/foo.txt");
    SiteMapBuilder smb =
        new SiteMapBuilder(
            new SiteMapConfigurationImpl(), fileWorkArea, "https://example.org/example", true);

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
   *
   * <ul>
   *   <li>Given {@code /}.
   *   <li>Then return {@code /}.
   * </ul>
   *
   * <p>Method under test: {@link ProductSiteMapGenerator#generateUri(SiteMapBuilder, Product)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ProductSiteMapGenerator.generateUri(SiteMapBuilder, Product)"})
  public void testGenerateUri_givenSlash_thenReturnSlash() {
    // Arrange
    FileWorkArea fileWorkArea = new FileWorkArea();
    fileWorkArea.setFilePathLocation("/directory/foo.txt");
    SiteMapBuilder smb =
        new SiteMapBuilder(new SiteMapConfigurationImpl(), fileWorkArea, "/", true);

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
   *
   * <ul>
   *   <li>Then return {@code https://example.org/example/https://example.org/example}.
   * </ul>
   *
   * <p>Method under test: {@link ProductSiteMapGenerator#generateUri(SiteMapBuilder, Product)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ProductSiteMapGenerator.generateUri(SiteMapBuilder, Product)"})
  public void testGenerateUri_thenReturnHttpsExampleOrgExampleHttpsExampleOrgExample() {
    // Arrange
    FileWorkArea fileWorkArea = new FileWorkArea();
    fileWorkArea.setFilePathLocation("/directory/foo.txt");
    SiteMapBuilder smb =
        new SiteMapBuilder(
            new SiteMapConfigurationImpl(), fileWorkArea, "https://example.org/example", true);

    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getUrl()).thenReturn("https://example.org/example");

    // Act
    String actualGenerateUriResult = productSiteMapGenerator.generateUri(smb, product);

    // Assert
    verify(product).getUrl();
    assertEquals(
        "https://example.org/example/https://example.org/example", actualGenerateUriResult);
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ProductSiteMapGenerator#setPageSize(int)}
   *   <li>{@link ProductSiteMapGenerator#setProductDao(ProductDao)}
   *   <li>{@link ProductSiteMapGenerator#getPageSize()}
   *   <li>{@link ProductSiteMapGenerator#getProductDao()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int ProductSiteMapGenerator.getPageSize()",
    "ProductDao ProductSiteMapGenerator.getProductDao()",
    "void ProductSiteMapGenerator.setPageSize(int)",
    "void ProductSiteMapGenerator.setProductDao(ProductDao)"
  })
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
