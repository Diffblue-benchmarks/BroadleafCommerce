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
import org.broadleafcommerce.common.media.domain.MediaDto;
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
import org.broadleafcommerce.core.catalog.dao.SkuDao;
import org.broadleafcommerce.core.catalog.dao.SkuDaoImpl;
import org.broadleafcommerce.core.catalog.domain.ProductBundleImpl;
import org.broadleafcommerce.core.catalog.domain.ProductImpl;
import org.broadleafcommerce.core.catalog.domain.Sku;
import org.broadleafcommerce.core.catalog.domain.SkuImpl;
import org.broadleafcommerce.core.catalog.domain.SkuMediaXref;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class SkuSiteMapGeneratorDiffblueTest {
  @Mock private SkuDao skuDao;

  @InjectMocks private SkuSiteMapGenerator skuSiteMapGenerator;

  /**
   * Test {@link SkuSiteMapGenerator#canHandleSiteMapConfiguration(SiteMapGeneratorConfiguration)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * SkuSiteMapGenerator#canHandleSiteMapConfiguration(SiteMapGeneratorConfiguration)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SkuSiteMapGenerator.canHandleSiteMapConfiguration(SiteMapGeneratorConfiguration)"
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
    assertFalse(skuSiteMapGenerator.canHandleSiteMapConfiguration(siteMapGeneratorConfiguration));
  }

  /**
   * Test {@link SkuSiteMapGenerator#canHandleSiteMapConfiguration(SiteMapGeneratorConfiguration)}.
   *
   * <ul>
   *   <li>Given {@link SiteMapGeneratorType#SKU}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link
   * SkuSiteMapGenerator#canHandleSiteMapConfiguration(SiteMapGeneratorConfiguration)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SkuSiteMapGenerator.canHandleSiteMapConfiguration(SiteMapGeneratorConfiguration)"
  })
  public void testCanHandleSiteMapConfiguration_givenSku_thenReturnTrue() {
    // Arrange
    SiteMapGeneratorConfiguration siteMapGeneratorConfiguration =
        mock(SiteMapGeneratorConfiguration.class);
    when(siteMapGeneratorConfiguration.getSiteMapGeneratorType())
        .thenReturn(SiteMapGeneratorType.SKU);

    // Act
    boolean actualCanHandleSiteMapConfigurationResult =
        skuSiteMapGenerator.canHandleSiteMapConfiguration(siteMapGeneratorConfiguration);

    // Assert
    verify(siteMapGeneratorConfiguration).getSiteMapGeneratorType();
    assertTrue(actualCanHandleSiteMapConfigurationResult);
  }

  /**
   * Test {@link SkuSiteMapGenerator#canHandleSiteMapConfiguration(SiteMapGeneratorConfiguration)}.
   *
   * <ul>
   *   <li>When {@link SiteMapGeneratorConfigurationImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link
   * SkuSiteMapGenerator#canHandleSiteMapConfiguration(SiteMapGeneratorConfiguration)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SkuSiteMapGenerator.canHandleSiteMapConfiguration(SiteMapGeneratorConfiguration)"
  })
  public void testCanHandleSiteMapConfiguration_whenSiteMapGeneratorConfigurationImpl() {
    // Arrange, Act and Assert
    assertFalse(
        skuSiteMapGenerator.canHandleSiteMapConfiguration(new SiteMapGeneratorConfigurationImpl()));
  }

  /**
   * Test {@link SkuSiteMapGenerator#addSiteMapEntries(SiteMapGeneratorConfiguration,
   * SiteMapBuilder)}.
   *
   * <p>Method under test: {@link
   * SkuSiteMapGenerator#addSiteMapEntries(SiteMapGeneratorConfiguration, SiteMapBuilder)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SkuSiteMapGenerator.addSiteMapEntries(SiteMapGeneratorConfiguration, SiteMapBuilder)"
  })
  public void testAddSiteMapEntries() {
    // Arrange
    ProductBundleImpl productBundleImpl = mock(ProductBundleImpl.class);
    when(productBundleImpl.getUrl()).thenReturn("https://example.org/example");

    SkuImpl skuImpl = mock(SkuImpl.class);
    when(skuImpl.getSkuMediaXref()).thenReturn(new HashMap<>());
    when(skuImpl.getUrlKey()).thenReturn("https://example.org/example");
    when(skuImpl.getDefaultProduct()).thenReturn(new ProductImpl());
    when(skuImpl.getProduct()).thenReturn(productBundleImpl);

    ArrayList<Sku> skuList = new ArrayList<>();
    skuList.add(skuImpl);
    when(skuDao.readAllActiveSkus(anyInt(), anyInt())).thenReturn(skuList);

    SiteMapGeneratorConfiguration smgc = mock(SiteMapGeneratorConfiguration.class);
    when(smgc.getSiteMapChangeFreq())
        .thenReturn(new SiteMapChangeFreqType("Type", "Friendly Type"));
    when(smgc.getSiteMapPriority()).thenReturn(new SiteMapPriorityType("Type", "Friendly Type"));

    FileWorkArea fileWorkArea = new FileWorkArea();
    fileWorkArea.setFilePathLocation("/directory/foo.txt");
    SiteMapBuilder siteMapBuilder =
        new SiteMapBuilder(new SiteMapConfigurationImpl(), fileWorkArea, "/", true);

    // Act
    skuSiteMapGenerator.addSiteMapEntries(smgc, siteMapBuilder);

    // Assert
    verify(smgc).getSiteMapChangeFreq();
    verify(smgc).getSiteMapPriority();
    verify(skuDao).readAllActiveSkus(0, 0);
    verify(productBundleImpl, atLeast(1)).getUrl();
    verify(skuImpl).getDefaultProduct();
    verify(skuImpl, atLeast(1)).getProduct();
    verify(skuImpl).getSkuMediaXref();
    verify(skuImpl, atLeast(1)).getUrlKey();
  }

  /**
   * Test {@link SkuSiteMapGenerator#addSiteMapEntries(SiteMapGeneratorConfiguration,
   * SiteMapBuilder)}.
   *
   * <ul>
   *   <li>Given {@link ProductBundleImpl} {@link ProductBundleImpl#getUrl()} return {@code /}.
   * </ul>
   *
   * <p>Method under test: {@link
   * SkuSiteMapGenerator#addSiteMapEntries(SiteMapGeneratorConfiguration, SiteMapBuilder)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SkuSiteMapGenerator.addSiteMapEntries(SiteMapGeneratorConfiguration, SiteMapBuilder)"
  })
  public void testAddSiteMapEntries_givenProductBundleImplGetUrlReturnSlash() {
    // Arrange
    ProductBundleImpl productBundleImpl = mock(ProductBundleImpl.class);
    when(productBundleImpl.getUrl()).thenReturn("/");

    SkuImpl skuImpl = mock(SkuImpl.class);
    when(skuImpl.getSkuMediaXref()).thenReturn(new HashMap<>());
    when(skuImpl.getUrlKey()).thenReturn("https://example.org/example");
    when(skuImpl.getDefaultProduct()).thenReturn(new ProductImpl());
    when(skuImpl.getProduct()).thenReturn(productBundleImpl);

    ArrayList<Sku> skuList = new ArrayList<>();
    skuList.add(skuImpl);
    when(skuDao.readAllActiveSkus(anyInt(), anyInt())).thenReturn(skuList);

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
    skuSiteMapGenerator.addSiteMapEntries(smgc, siteMapBuilder);

    // Assert
    verify(smgc).getSiteMapChangeFreq();
    verify(smgc).getSiteMapPriority();
    verify(skuDao).readAllActiveSkus(0, 0);
    verify(productBundleImpl, atLeast(1)).getUrl();
    verify(skuImpl).getDefaultProduct();
    verify(skuImpl, atLeast(1)).getProduct();
    verify(skuImpl).getSkuMediaXref();
    verify(skuImpl, atLeast(1)).getUrlKey();
  }

  /**
   * Test {@link SkuSiteMapGenerator#addSiteMapEntries(SiteMapGeneratorConfiguration,
   * SiteMapBuilder)}.
   *
   * <ul>
   *   <li>Given {@link ProductBundleImpl} {@link ProductBundleImpl#getUrl()} return {@code /}.
   * </ul>
   *
   * <p>Method under test: {@link
   * SkuSiteMapGenerator#addSiteMapEntries(SiteMapGeneratorConfiguration, SiteMapBuilder)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SkuSiteMapGenerator.addSiteMapEntries(SiteMapGeneratorConfiguration, SiteMapBuilder)"
  })
  public void testAddSiteMapEntries_givenProductBundleImplGetUrlReturnSlash2() {
    // Arrange
    ProductBundleImpl productBundleImpl = mock(ProductBundleImpl.class);
    when(productBundleImpl.getUrl()).thenReturn("/");

    SkuImpl skuImpl = mock(SkuImpl.class);
    when(skuImpl.getSkuMediaXref()).thenReturn(new HashMap<>());
    when(skuImpl.getUrlKey()).thenReturn("https://example.org/example");
    when(skuImpl.getDefaultProduct()).thenReturn(new ProductImpl());
    when(skuImpl.getProduct()).thenReturn(productBundleImpl);

    ArrayList<Sku> skuList = new ArrayList<>();
    skuList.add(skuImpl);
    when(skuDao.readAllActiveSkus(anyInt(), anyInt())).thenReturn(skuList);

    SiteMapGeneratorConfiguration smgc = mock(SiteMapGeneratorConfiguration.class);
    when(smgc.getSiteMapChangeFreq())
        .thenReturn(new SiteMapChangeFreqType("Type", "Friendly Type"));
    when(smgc.getSiteMapPriority()).thenReturn(new SiteMapPriorityType("Type", "Friendly Type"));

    FileWorkArea fileWorkArea = new FileWorkArea();
    fileWorkArea.setFilePathLocation("/directory/foo.txt");
    SiteMapBuilder siteMapBuilder =
        new SiteMapBuilder(new SiteMapConfigurationImpl(), fileWorkArea, "/", true);

    // Act
    skuSiteMapGenerator.addSiteMapEntries(smgc, siteMapBuilder);

    // Assert
    verify(smgc).getSiteMapChangeFreq();
    verify(smgc).getSiteMapPriority();
    verify(skuDao).readAllActiveSkus(0, 0);
    verify(productBundleImpl, atLeast(1)).getUrl();
    verify(skuImpl).getDefaultProduct();
    verify(skuImpl, atLeast(1)).getProduct();
    verify(skuImpl).getSkuMediaXref();
    verify(skuImpl, atLeast(1)).getUrlKey();
  }

  /**
   * Test {@link SkuSiteMapGenerator#addSiteMapEntries(SiteMapGeneratorConfiguration,
   * SiteMapBuilder)}.
   *
   * <ul>
   *   <li>Given {@link SkuImpl} {@link SkuImpl#getDefaultProduct()} return {@link
   *       ProductBundleImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link
   * SkuSiteMapGenerator#addSiteMapEntries(SiteMapGeneratorConfiguration, SiteMapBuilder)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SkuSiteMapGenerator.addSiteMapEntries(SiteMapGeneratorConfiguration, SiteMapBuilder)"
  })
  public void testAddSiteMapEntries_givenSkuImplGetDefaultProductReturnProductBundleImpl() {
    // Arrange
    SkuImpl skuImpl = mock(SkuImpl.class);
    when(skuImpl.getDefaultProduct()).thenReturn(new ProductBundleImpl());

    ArrayList<Sku> skuList = new ArrayList<>();
    skuList.add(skuImpl);
    when(skuDao.readAllActiveSkus(anyInt(), anyInt())).thenReturn(skuList);
    SiteMapGeneratorConfigurationImpl smgc = new SiteMapGeneratorConfigurationImpl();

    FileWorkArea fileWorkArea = new FileWorkArea();
    fileWorkArea.setFilePathLocation("/directory/foo.txt");
    SiteMapBuilder siteMapBuilder =
        new SiteMapBuilder(
            new SiteMapConfigurationImpl(), fileWorkArea, "https://example.org/example", true);

    // Act
    skuSiteMapGenerator.addSiteMapEntries(smgc, siteMapBuilder);

    // Assert
    verify(skuDao).readAllActiveSkus(0, 0);
    verify(skuImpl).getDefaultProduct();
  }

  /**
   * Test {@link SkuSiteMapGenerator#addSiteMapEntries(SiteMapGeneratorConfiguration,
   * SiteMapBuilder)}.
   *
   * <ul>
   *   <li>Given {@link SkuImpl} {@link SkuImpl#getProduct()} return {@link ProductBundleImpl}
   *       (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link
   * SkuSiteMapGenerator#addSiteMapEntries(SiteMapGeneratorConfiguration, SiteMapBuilder)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SkuSiteMapGenerator.addSiteMapEntries(SiteMapGeneratorConfiguration, SiteMapBuilder)"
  })
  public void testAddSiteMapEntries_givenSkuImplGetProductReturnProductBundleImpl() {
    // Arrange
    SkuImpl skuImpl = mock(SkuImpl.class);
    when(skuImpl.getSkuMediaXref()).thenReturn(new HashMap<>());
    when(skuImpl.getUrlKey()).thenReturn("https://example.org/example");
    when(skuImpl.getDefaultProduct()).thenReturn(new ProductImpl());
    when(skuImpl.getProduct()).thenReturn(new ProductBundleImpl());

    ArrayList<Sku> skuList = new ArrayList<>();
    skuList.add(skuImpl);
    when(skuDao.readAllActiveSkus(anyInt(), anyInt())).thenReturn(skuList);
    SiteMapGeneratorConfigurationImpl smgc = new SiteMapGeneratorConfigurationImpl();

    FileWorkArea fileWorkArea = new FileWorkArea();
    fileWorkArea.setFilePathLocation("/directory/foo.txt");
    SiteMapBuilder siteMapBuilder =
        new SiteMapBuilder(
            new SiteMapConfigurationImpl(), fileWorkArea, "https://example.org/example", true);

    // Act
    skuSiteMapGenerator.addSiteMapEntries(smgc, siteMapBuilder);

    // Assert
    verify(skuDao).readAllActiveSkus(0, 0);
    verify(skuImpl).getDefaultProduct();
    verify(skuImpl, atLeast(1)).getProduct();
    verify(skuImpl).getSkuMediaXref();
    verify(skuImpl, atLeast(1)).getUrlKey();
  }

  /**
   * Test {@link SkuSiteMapGenerator#addSiteMapEntries(SiteMapGeneratorConfiguration,
   * SiteMapBuilder)}.
   *
   * <ul>
   *   <li>Given {@link SkuImpl} {@link SkuImpl#getUrlKey()} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * SkuSiteMapGenerator#addSiteMapEntries(SiteMapGeneratorConfiguration, SiteMapBuilder)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SkuSiteMapGenerator.addSiteMapEntries(SiteMapGeneratorConfiguration, SiteMapBuilder)"
  })
  public void testAddSiteMapEntries_givenSkuImplGetUrlKeyReturnNull() {
    // Arrange
    ProductBundleImpl productBundleImpl = mock(ProductBundleImpl.class);
    when(productBundleImpl.getUrl()).thenReturn("https://example.org/example");

    SkuImpl skuImpl = mock(SkuImpl.class);
    when(skuImpl.getSkuMediaXref()).thenReturn(new HashMap<>());
    when(skuImpl.getUrlKey()).thenReturn(null);
    when(skuImpl.getDefaultProduct()).thenReturn(new ProductImpl());
    when(skuImpl.getProduct()).thenReturn(productBundleImpl);

    ArrayList<Sku> skuList = new ArrayList<>();
    skuList.add(skuImpl);
    when(skuDao.readAllActiveSkus(anyInt(), anyInt())).thenReturn(skuList);

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
    skuSiteMapGenerator.addSiteMapEntries(smgc, siteMapBuilder);

    // Assert
    verify(smgc).getSiteMapChangeFreq();
    verify(smgc).getSiteMapPriority();
    verify(skuDao).readAllActiveSkus(0, 0);
    verify(productBundleImpl, atLeast(1)).getUrl();
    verify(skuImpl).getDefaultProduct();
    verify(skuImpl, atLeast(1)).getProduct();
    verify(skuImpl).getSkuMediaXref();
    verify(skuImpl, atLeast(1)).getUrlKey();
  }

  /**
   * Test {@link SkuSiteMapGenerator#addSiteMapEntries(SiteMapGeneratorConfiguration,
   * SiteMapBuilder)}.
   *
   * <ul>
   *   <li>Then calls {@link SiteMapGeneratorConfiguration#getSiteMapChangeFreq()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * SkuSiteMapGenerator#addSiteMapEntries(SiteMapGeneratorConfiguration, SiteMapBuilder)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SkuSiteMapGenerator.addSiteMapEntries(SiteMapGeneratorConfiguration, SiteMapBuilder)"
  })
  public void testAddSiteMapEntries_thenCallsGetSiteMapChangeFreq() {
    // Arrange
    ProductBundleImpl productBundleImpl = mock(ProductBundleImpl.class);
    when(productBundleImpl.getUrl()).thenReturn("https://example.org/example");

    SkuImpl skuImpl = mock(SkuImpl.class);
    when(skuImpl.getSkuMediaXref()).thenReturn(new HashMap<>());
    when(skuImpl.getUrlKey()).thenReturn("https://example.org/example");
    when(skuImpl.getDefaultProduct()).thenReturn(new ProductImpl());
    when(skuImpl.getProduct()).thenReturn(productBundleImpl);

    ArrayList<Sku> skuList = new ArrayList<>();
    skuList.add(skuImpl);
    when(skuDao.readAllActiveSkus(anyInt(), anyInt())).thenReturn(skuList);

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
    skuSiteMapGenerator.addSiteMapEntries(smgc, siteMapBuilder);

    // Assert
    verify(smgc).getSiteMapChangeFreq();
    verify(smgc).getSiteMapPriority();
    verify(skuDao).readAllActiveSkus(0, 0);
    verify(productBundleImpl, atLeast(1)).getUrl();
    verify(skuImpl).getDefaultProduct();
    verify(skuImpl, atLeast(1)).getProduct();
    verify(skuImpl).getSkuMediaXref();
    verify(skuImpl, atLeast(1)).getUrlKey();
  }

  /**
   * Test {@link SkuSiteMapGenerator#addSiteMapEntries(SiteMapGeneratorConfiguration,
   * SiteMapBuilder)}.
   *
   * <ul>
   *   <li>Then calls {@link ProductBundleImpl#getUrl()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * SkuSiteMapGenerator#addSiteMapEntries(SiteMapGeneratorConfiguration, SiteMapBuilder)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SkuSiteMapGenerator.addSiteMapEntries(SiteMapGeneratorConfiguration, SiteMapBuilder)"
  })
  public void testAddSiteMapEntries_thenCallsGetUrl() {
    // Arrange
    ProductBundleImpl productBundleImpl = mock(ProductBundleImpl.class);
    when(productBundleImpl.getUrl()).thenReturn("https://example.org/example");

    SkuImpl skuImpl = mock(SkuImpl.class);
    when(skuImpl.getSkuMediaXref()).thenReturn(new HashMap<>());
    when(skuImpl.getUrlKey()).thenReturn("https://example.org/example");
    when(skuImpl.getDefaultProduct()).thenReturn(new ProductImpl());
    when(skuImpl.getProduct()).thenReturn(productBundleImpl);

    ArrayList<Sku> skuList = new ArrayList<>();
    skuList.add(skuImpl);
    when(skuDao.readAllActiveSkus(anyInt(), anyInt())).thenReturn(skuList);
    SiteMapGeneratorConfigurationImpl smgc = new SiteMapGeneratorConfigurationImpl();

    FileWorkArea fileWorkArea = new FileWorkArea();
    fileWorkArea.setFilePathLocation("/directory/foo.txt");
    SiteMapBuilder siteMapBuilder =
        new SiteMapBuilder(
            new SiteMapConfigurationImpl(), fileWorkArea, "https://example.org/example", true);

    // Act
    skuSiteMapGenerator.addSiteMapEntries(smgc, siteMapBuilder);

    // Assert
    verify(skuDao).readAllActiveSkus(0, 0);
    verify(productBundleImpl, atLeast(1)).getUrl();
    verify(skuImpl).getDefaultProduct();
    verify(skuImpl, atLeast(1)).getProduct();
    verify(skuImpl).getSkuMediaXref();
    verify(skuImpl, atLeast(1)).getUrlKey();
  }

  /**
   * Test {@link SkuSiteMapGenerator#constructImageURLs(SiteMapBuilder, SiteMapURLWrapper, Sku)}.
   *
   * <p>Method under test: {@link SkuSiteMapGenerator#constructImageURLs(SiteMapBuilder,
   * SiteMapURLWrapper, Sku)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SkuSiteMapGenerator.constructImageURLs(SiteMapBuilder, SiteMapURLWrapper, Sku)"
  })
  public void testConstructImageURLs() {
    // Arrange
    FileWorkArea fileWorkArea = new FileWorkArea();
    fileWorkArea.setFilePathLocation("/directory/foo.txt");
    SiteMapBuilder siteMapBuilder =
        new SiteMapBuilder(
            new SiteMapConfigurationImpl(), fileWorkArea, "https://example.org/example", true);
    SiteMapURLWrapper siteMapUrl = new SiteMapURLWrapper();

    MediaDto mediaDto = new MediaDto();
    mediaDto.setUrl("/");

    SkuMediaXref skuMediaXref = mock(SkuMediaXref.class);
    when(skuMediaXref.getMedia()).thenReturn(mediaDto);

    HashMap<String, SkuMediaXref> skuMediaXref2 = new HashMap<>();
    skuMediaXref2.put("foo", skuMediaXref);

    SkuImpl sku = new SkuImpl();
    sku.setSkuMediaXref(skuMediaXref2);

    // Act
    skuSiteMapGenerator.constructImageURLs(siteMapBuilder, siteMapUrl, sku);

    // Assert
    verify(skuMediaXref).getMedia();
    List<SiteMapImageWrapper> siteMapImageWrappers = siteMapUrl.getSiteMapImageWrappers();
    assertEquals(1, siteMapImageWrappers.size());
    assertEquals("https://example.org/example/", siteMapImageWrappers.get(0).getLoc());
  }

  /**
   * Test {@link SkuSiteMapGenerator#constructImageURLs(SiteMapBuilder, SiteMapURLWrapper, Sku)}.
   *
   * <p>Method under test: {@link SkuSiteMapGenerator#constructImageURLs(SiteMapBuilder,
   * SiteMapURLWrapper, Sku)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SkuSiteMapGenerator.constructImageURLs(SiteMapBuilder, SiteMapURLWrapper, Sku)"
  })
  public void testConstructImageURLs2() {
    // Arrange
    FileWorkArea fileWorkArea = new FileWorkArea();
    fileWorkArea.setFilePathLocation("/directory/foo.txt");
    SiteMapBuilder siteMapBuilder =
        new SiteMapBuilder(
            new SiteMapConfigurationImpl(), fileWorkArea, "https://example.org/example", true);
    SiteMapURLWrapper siteMapUrl = new SiteMapURLWrapper();

    MediaDto mediaDto = mock(MediaDto.class);
    when(mediaDto.getUrl()).thenReturn("https://example.org/example");
    doNothing().when(mediaDto).setUrl(Mockito.<String>any());
    mediaDto.setUrl("/");

    SkuMediaXref skuMediaXref = mock(SkuMediaXref.class);
    when(skuMediaXref.getMedia()).thenReturn(mediaDto);

    HashMap<String, SkuMediaXref> skuMediaXref2 = new HashMap<>();
    skuMediaXref2.put("foo", skuMediaXref);

    SkuImpl sku = new SkuImpl();
    sku.setSkuMediaXref(skuMediaXref2);

    // Act
    skuSiteMapGenerator.constructImageURLs(siteMapBuilder, siteMapUrl, sku);

    // Assert
    verify(mediaDto).getUrl();
    verify(mediaDto).setUrl("/");
    verify(skuMediaXref).getMedia();
    List<SiteMapImageWrapper> siteMapImageWrappers = siteMapUrl.getSiteMapImageWrappers();
    assertEquals(1, siteMapImageWrappers.size());
    assertEquals(
        "https://example.org/example/https://example.org/example",
        siteMapImageWrappers.get(0).getLoc());
  }

  /**
   * Test {@link SkuSiteMapGenerator#constructImageURLs(SiteMapBuilder, SiteMapURLWrapper, Sku)}.
   *
   * <p>Method under test: {@link SkuSiteMapGenerator#constructImageURLs(SiteMapBuilder,
   * SiteMapURLWrapper, Sku)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SkuSiteMapGenerator.constructImageURLs(SiteMapBuilder, SiteMapURLWrapper, Sku)"
  })
  public void testConstructImageURLs3() {
    // Arrange
    FileWorkArea fileWorkArea = new FileWorkArea();
    fileWorkArea.setFilePathLocation("/directory/foo.txt");
    SiteMapBuilder siteMapBuilder =
        new SiteMapBuilder(new SiteMapConfigurationImpl(), fileWorkArea, "/", true);
    SiteMapURLWrapper siteMapUrl = new SiteMapURLWrapper();

    MediaDto mediaDto = mock(MediaDto.class);
    when(mediaDto.getUrl()).thenReturn("https://example.org/example");
    doNothing().when(mediaDto).setUrl(Mockito.<String>any());
    mediaDto.setUrl("/");

    SkuMediaXref skuMediaXref = mock(SkuMediaXref.class);
    when(skuMediaXref.getMedia()).thenReturn(mediaDto);

    HashMap<String, SkuMediaXref> skuMediaXref2 = new HashMap<>();
    skuMediaXref2.put("foo", skuMediaXref);

    SkuImpl sku = new SkuImpl();
    sku.setSkuMediaXref(skuMediaXref2);

    // Act
    skuSiteMapGenerator.constructImageURLs(siteMapBuilder, siteMapUrl, sku);

    // Assert
    verify(mediaDto).getUrl();
    verify(mediaDto).setUrl("/");
    verify(skuMediaXref).getMedia();
    List<SiteMapImageWrapper> siteMapImageWrappers = siteMapUrl.getSiteMapImageWrappers();
    assertEquals(1, siteMapImageWrappers.size());
    assertEquals("/https://example.org/example", siteMapImageWrappers.get(0).getLoc());
  }

  /**
   * Test {@link SkuSiteMapGenerator#constructImageURLs(SiteMapBuilder, SiteMapURLWrapper, Sku)}.
   *
   * <ul>
   *   <li>Then calls {@link SiteMapURLWrapper#addImage(SiteMapImageWrapper)}.
   * </ul>
   *
   * <p>Method under test: {@link SkuSiteMapGenerator#constructImageURLs(SiteMapBuilder,
   * SiteMapURLWrapper, Sku)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SkuSiteMapGenerator.constructImageURLs(SiteMapBuilder, SiteMapURLWrapper, Sku)"
  })
  public void testConstructImageURLs_thenCallsAddImage() {
    // Arrange
    FileWorkArea fileWorkArea = new FileWorkArea();
    fileWorkArea.setFilePathLocation("/directory/foo.txt");
    SiteMapBuilder siteMapBuilder =
        new SiteMapBuilder(
            new SiteMapConfigurationImpl(), fileWorkArea, "https://example.org/example", true);

    SiteMapURLWrapper siteMapUrl = mock(SiteMapURLWrapper.class);
    doNothing().when(siteMapUrl).addImage(Mockito.<SiteMapImageWrapper>any());

    MediaDto mediaDto = mock(MediaDto.class);
    when(mediaDto.getUrl()).thenReturn("https://example.org/example");
    doNothing().when(mediaDto).setUrl(Mockito.<String>any());
    mediaDto.setUrl("/");

    SkuMediaXref skuMediaXref = mock(SkuMediaXref.class);
    when(skuMediaXref.getMedia()).thenReturn(mediaDto);

    HashMap<String, SkuMediaXref> skuMediaXref2 = new HashMap<>();
    skuMediaXref2.put("foo", skuMediaXref);

    SkuImpl sku = new SkuImpl();
    sku.setSkuMediaXref(skuMediaXref2);

    // Act
    skuSiteMapGenerator.constructImageURLs(siteMapBuilder, siteMapUrl, sku);

    // Assert
    verify(mediaDto).getUrl();
    verify(mediaDto).setUrl("/");
    verify(siteMapUrl).addImage(isA(SiteMapImageWrapper.class));
    verify(skuMediaXref).getMedia();
  }

  /**
   * Test {@link SkuSiteMapGenerator#constructImageURLs(SiteMapBuilder, SiteMapURLWrapper, Sku)}.
   *
   * <ul>
   *   <li>Then {@link SiteMapURLWrapper} (default constructor) SiteMapImageWrappers Empty.
   * </ul>
   *
   * <p>Method under test: {@link SkuSiteMapGenerator#constructImageURLs(SiteMapBuilder,
   * SiteMapURLWrapper, Sku)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SkuSiteMapGenerator.constructImageURLs(SiteMapBuilder, SiteMapURLWrapper, Sku)"
  })
  public void testConstructImageURLs_thenSiteMapURLWrapperSiteMapImageWrappersEmpty() {
    // Arrange
    FileWorkArea fileWorkArea = new FileWorkArea();
    fileWorkArea.setFilePathLocation("/directory/foo.txt");
    SiteMapBuilder siteMapBuilder =
        new SiteMapBuilder(
            new SiteMapConfigurationImpl(), fileWorkArea, "https://example.org/example", true);
    SiteMapURLWrapper siteMapUrl = new SiteMapURLWrapper();

    // Act
    skuSiteMapGenerator.constructImageURLs(siteMapBuilder, siteMapUrl, new SkuImpl());

    // Assert that nothing has changed
    assertTrue(siteMapUrl.getSiteMapImageWrappers().isEmpty());
  }

  /**
   * Test {@link SkuSiteMapGenerator#constructImageURLs(SiteMapBuilder, SiteMapURLWrapper, Sku)}.
   *
   * <ul>
   *   <li>Then {@link SiteMapURLWrapper} (default constructor) SiteMapImageWrappers first Loc is
   *       {@code /}.
   * </ul>
   *
   * <p>Method under test: {@link SkuSiteMapGenerator#constructImageURLs(SiteMapBuilder,
   * SiteMapURLWrapper, Sku)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SkuSiteMapGenerator.constructImageURLs(SiteMapBuilder, SiteMapURLWrapper, Sku)"
  })
  public void testConstructImageURLs_thenSiteMapURLWrapperSiteMapImageWrappersFirstLocIsSlash() {
    // Arrange
    FileWorkArea fileWorkArea = new FileWorkArea();
    fileWorkArea.setFilePathLocation("/directory/foo.txt");
    SiteMapBuilder siteMapBuilder =
        new SiteMapBuilder(new SiteMapConfigurationImpl(), fileWorkArea, "/", true);
    SiteMapURLWrapper siteMapUrl = new SiteMapURLWrapper();

    MediaDto mediaDto = new MediaDto();
    mediaDto.setUrl("/");

    SkuMediaXref skuMediaXref = mock(SkuMediaXref.class);
    when(skuMediaXref.getMedia()).thenReturn(mediaDto);

    HashMap<String, SkuMediaXref> skuMediaXref2 = new HashMap<>();
    skuMediaXref2.put("foo", skuMediaXref);

    SkuImpl sku = new SkuImpl();
    sku.setSkuMediaXref(skuMediaXref2);

    // Act
    skuSiteMapGenerator.constructImageURLs(siteMapBuilder, siteMapUrl, sku);

    // Assert
    verify(skuMediaXref).getMedia();
    List<SiteMapImageWrapper> siteMapImageWrappers = siteMapUrl.getSiteMapImageWrappers();
    assertEquals(1, siteMapImageWrappers.size());
    assertEquals("/", siteMapImageWrappers.get(0).getLoc());
  }

  /**
   * Test {@link SkuSiteMapGenerator#generateUri(SiteMapBuilder, Sku)}.
   *
   * <p>Method under test: {@link SkuSiteMapGenerator#generateUri(SiteMapBuilder, Sku)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SkuSiteMapGenerator.generateUri(SiteMapBuilder, Sku)"})
  public void testGenerateUri() {
    // Arrange
    FileWorkArea fileWorkArea = new FileWorkArea();
    fileWorkArea.setFilePathLocation("/directory/foo.txt");
    SiteMapBuilder smb =
        new SiteMapBuilder(
            new SiteMapConfigurationImpl(), fileWorkArea, "https://example.org/example", true);

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
    assertEquals(
        "https://example.org/example/https://example.org/examplehttps://example.org/example",
        actualGenerateUriResult);
  }

  /**
   * Test {@link SkuSiteMapGenerator#generateUri(SiteMapBuilder, Sku)}.
   *
   * <ul>
   *   <li>Then return {@code /https://example.org/example}.
   * </ul>
   *
   * <p>Method under test: {@link SkuSiteMapGenerator#generateUri(SiteMapBuilder, Sku)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SkuSiteMapGenerator.generateUri(SiteMapBuilder, Sku)"})
  public void testGenerateUri_thenReturnHttpsExampleOrgExample() {
    // Arrange
    FileWorkArea fileWorkArea = new FileWorkArea();
    fileWorkArea.setFilePathLocation("/directory/foo.txt");
    SiteMapBuilder smb =
        new SiteMapBuilder(new SiteMapConfigurationImpl(), fileWorkArea, "/", true);

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
   *
   * <ul>
   *   <li>Then return {@code https://example.org/example/https://example.org/example}.
   * </ul>
   *
   * <p>Method under test: {@link SkuSiteMapGenerator#generateUri(SiteMapBuilder, Sku)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SkuSiteMapGenerator.generateUri(SiteMapBuilder, Sku)"})
  public void testGenerateUri_thenReturnHttpsExampleOrgExampleHttpsExampleOrgExample() {
    // Arrange
    FileWorkArea fileWorkArea = new FileWorkArea();
    fileWorkArea.setFilePathLocation("/directory/foo.txt");
    SiteMapBuilder smb =
        new SiteMapBuilder(
            new SiteMapConfigurationImpl(), fileWorkArea, "https://example.org/example", true);

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
    assertEquals(
        "https://example.org/example/https://example.org/example", actualGenerateUriResult);
  }

  /**
   * Test {@link SkuSiteMapGenerator#generateUri(SiteMapBuilder, Sku)}.
   *
   * <ul>
   *   <li>Then return {@code https://example.org/example/nullhttps://example.org/example}.
   * </ul>
   *
   * <p>Method under test: {@link SkuSiteMapGenerator#generateUri(SiteMapBuilder, Sku)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SkuSiteMapGenerator.generateUri(SiteMapBuilder, Sku)"})
  public void testGenerateUri_thenReturnHttpsExampleOrgExampleNullhttpsExampleOrgExample() {
    // Arrange
    FileWorkArea fileWorkArea = new FileWorkArea();
    fileWorkArea.setFilePathLocation("/directory/foo.txt");
    SiteMapBuilder smb =
        new SiteMapBuilder(
            new SiteMapConfigurationImpl(), fileWorkArea, "https://example.org/example", true);

    SkuImpl sku = mock(SkuImpl.class);
    when(sku.getUrlKey()).thenReturn("https://example.org/example");
    when(sku.getProduct()).thenReturn(new ProductBundleImpl());

    // Act
    String actualGenerateUriResult = skuSiteMapGenerator.generateUri(smb, sku);

    // Assert
    verify(sku).getProduct();
    verify(sku, atLeast(1)).getUrlKey();
    assertEquals(
        "https://example.org/example/nullhttps://example.org/example", actualGenerateUriResult);
  }

  /**
   * Test {@link SkuSiteMapGenerator#generateUri(SiteMapBuilder, Sku)}.
   *
   * <ul>
   *   <li>Then return {@code /nullhttps://example.org/example}.
   * </ul>
   *
   * <p>Method under test: {@link SkuSiteMapGenerator#generateUri(SiteMapBuilder, Sku)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SkuSiteMapGenerator.generateUri(SiteMapBuilder, Sku)"})
  public void testGenerateUri_thenReturnNullhttpsExampleOrgExample() {
    // Arrange
    FileWorkArea fileWorkArea = new FileWorkArea();
    fileWorkArea.setFilePathLocation("/directory/foo.txt");
    SiteMapBuilder smb =
        new SiteMapBuilder(new SiteMapConfigurationImpl(), fileWorkArea, "/", true);

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
   * Test {@link SkuSiteMapGenerator#generateUri(SiteMapBuilder, Sku)}.
   *
   * <ul>
   *   <li>When {@link SkuImpl} {@link SkuImpl#getUrlKey()} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SkuSiteMapGenerator#generateUri(SiteMapBuilder, Sku)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SkuSiteMapGenerator.generateUri(SiteMapBuilder, Sku)"})
  public void testGenerateUri_whenSkuImplGetUrlKeyReturnNull() {
    // Arrange
    FileWorkArea fileWorkArea = new FileWorkArea();
    fileWorkArea.setFilePathLocation("/directory/foo.txt");
    SiteMapBuilder smb =
        new SiteMapBuilder(
            new SiteMapConfigurationImpl(), fileWorkArea, "https://example.org/example", true);

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
    assertEquals(
        "https://example.org/example/https://example.org/example", actualGenerateUriResult);
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SkuSiteMapGenerator#setPageSize(int)}
   *   <li>{@link SkuSiteMapGenerator#setSkuDao(SkuDao)}
   *   <li>{@link SkuSiteMapGenerator#getPageSize()}
   *   <li>{@link SkuSiteMapGenerator#getSkuDao()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int SkuSiteMapGenerator.getPageSize()",
    "SkuDao SkuSiteMapGenerator.getSkuDao()",
    "void SkuSiteMapGenerator.setPageSize(int)",
    "void SkuSiteMapGenerator.setSkuDao(SkuDao)"
  })
  public void testGettersAndSetters() {
    // Arrange
    SkuSiteMapGenerator skuSiteMapGenerator = new SkuSiteMapGenerator();

    // Act
    skuSiteMapGenerator.setPageSize(3);
    SkuDaoImpl skuDao = new SkuDaoImpl();
    skuSiteMapGenerator.setSkuDao(skuDao);
    int actualPageSize = skuSiteMapGenerator.getPageSize();
    SkuDao actualSkuDao = skuSiteMapGenerator.getSkuDao();

    // Assert
    assertTrue(actualSkuDao instanceof SkuDaoImpl);
    assertEquals(3, actualPageSize);
    assertSame(skuDao, actualSkuDao);
  }
}
