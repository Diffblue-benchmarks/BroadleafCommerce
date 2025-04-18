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
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.HashMap;
import org.broadleafcommerce.common.file.domain.FileWorkArea;
import org.broadleafcommerce.common.sitemap.domain.CustomUrlSiteMapGeneratorConfigurationImpl;
import org.broadleafcommerce.common.sitemap.domain.SiteMapConfigurationImpl;
import org.broadleafcommerce.common.sitemap.domain.SiteMapGeneratorConfiguration;
import org.broadleafcommerce.common.sitemap.service.SiteMapBuilder;
import org.broadleafcommerce.common.sitemap.service.type.SiteMapChangeFreqType;
import org.broadleafcommerce.common.sitemap.service.type.SiteMapGeneratorType;
import org.broadleafcommerce.common.sitemap.service.type.SiteMapPriorityType;
import org.broadleafcommerce.core.catalog.dao.SkuDao;
import org.broadleafcommerce.core.catalog.dao.SkuDaoImpl;
import org.broadleafcommerce.core.catalog.domain.CategorySiteMapGeneratorConfigurationImpl;
import org.broadleafcommerce.core.catalog.domain.ProductBundleImpl;
import org.broadleafcommerce.core.catalog.domain.ProductImpl;
import org.broadleafcommerce.core.catalog.domain.Sku;
import org.broadleafcommerce.core.catalog.domain.SkuImpl;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class SkuSiteMapGeneratorDiffblueTest {
  @Mock
  private SkuDao skuDao;

  @InjectMocks
  private SkuSiteMapGenerator skuSiteMapGenerator;

  /**
   * Test {@link SkuSiteMapGenerator#canHandleSiteMapConfiguration(SiteMapGeneratorConfiguration)}.
   * <p>
   * Method under test: {@link SkuSiteMapGenerator#canHandleSiteMapConfiguration(SiteMapGeneratorConfiguration)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean SkuSiteMapGenerator.canHandleSiteMapConfiguration(SiteMapGeneratorConfiguration)"})
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
    assertFalse(skuSiteMapGenerator.canHandleSiteMapConfiguration(siteMapGeneratorConfiguration));
  }

  /**
   * Test {@link SkuSiteMapGenerator#canHandleSiteMapConfiguration(SiteMapGeneratorConfiguration)}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuSiteMapGenerator#canHandleSiteMapConfiguration(SiteMapGeneratorConfiguration)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean SkuSiteMapGenerator.canHandleSiteMapConfiguration(SiteMapGeneratorConfiguration)"})
  public void testCanHandleSiteMapConfiguration_thenReturnTrue() {
    // Arrange
    CustomUrlSiteMapGeneratorConfigurationImpl siteMapGeneratorConfiguration = new CustomUrlSiteMapGeneratorConfigurationImpl();
    siteMapGeneratorConfiguration.setCustomURLEntries(new ArrayList<>());
    siteMapGeneratorConfiguration.setDisabled(true);
    siteMapGeneratorConfiguration.setId(1L);
    siteMapGeneratorConfiguration.setSiteMapChangeFreq(new SiteMapChangeFreqType("Type", "Friendly Type"));
    siteMapGeneratorConfiguration.setSiteMapConfiguration(new SiteMapConfigurationImpl());
    siteMapGeneratorConfiguration.setSiteMapGeneratorType(new SiteMapGeneratorType("SKU", "Friendly Type"));
    siteMapGeneratorConfiguration.setSiteMapPriority(new SiteMapPriorityType("Type", "Friendly Type"));

    // Act and Assert
    assertTrue(skuSiteMapGenerator.canHandleSiteMapConfiguration(siteMapGeneratorConfiguration));
  }

  /**
   * Test {@link SkuSiteMapGenerator#canHandleSiteMapConfiguration(SiteMapGeneratorConfiguration)}.
   * <ul>
   *   <li>When {@link CategorySiteMapGeneratorConfigurationImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuSiteMapGenerator#canHandleSiteMapConfiguration(SiteMapGeneratorConfiguration)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean SkuSiteMapGenerator.canHandleSiteMapConfiguration(SiteMapGeneratorConfiguration)"})
  public void testCanHandleSiteMapConfiguration_whenCategorySiteMapGeneratorConfigurationImpl() {
    // Arrange, Act and Assert
    assertFalse(skuSiteMapGenerator.canHandleSiteMapConfiguration(new CategorySiteMapGeneratorConfigurationImpl()));
  }

  /**
   * Test {@link SkuSiteMapGenerator#addSiteMapEntries(SiteMapGeneratorConfiguration, SiteMapBuilder)}.
   * <p>
   * Method under test: {@link SkuSiteMapGenerator#addSiteMapEntries(SiteMapGeneratorConfiguration, SiteMapBuilder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SkuSiteMapGenerator.addSiteMapEntries(SiteMapGeneratorConfiguration, SiteMapBuilder)"})
  public void testAddSiteMapEntries() {
    // Arrange
    ProductBundleImpl productBundleImpl = mock(ProductBundleImpl.class);
    when(productBundleImpl.getUrl()).thenReturn("https://example.org/example");
    SkuImpl skuImpl = mock(SkuImpl.class);
    when(skuImpl.getSkuMediaXref()).thenReturn(new HashMap<>());
    when(skuImpl.getUrlKey()).thenReturn("https://example.org/example");
    when(skuImpl.getDefaultProduct()).thenReturn(null);
    when(skuImpl.getProduct()).thenReturn(productBundleImpl);

    ArrayList<Sku> skuList = new ArrayList<>();
    skuList.add(skuImpl);
    when(skuDao.readAllActiveSkus(anyInt(), anyInt())).thenReturn(skuList);
    SiteMapGeneratorConfiguration smgc = mock(SiteMapGeneratorConfiguration.class);
    when(smgc.getSiteMapChangeFreq()).thenReturn(new SiteMapChangeFreqType("Type", "Friendly Type"));
    when(smgc.getSiteMapPriority()).thenReturn(new SiteMapPriorityType("Type", "Friendly Type"));
    SiteMapConfigurationImpl siteMapConfig = new SiteMapConfigurationImpl();

    // Act
    skuSiteMapGenerator.addSiteMapEntries(smgc, new SiteMapBuilder(siteMapConfig, new FileWorkArea(), "/", true));

    // Assert
    verify(smgc).getSiteMapChangeFreq();
    verify(smgc).getSiteMapPriority();
    verify(skuDao).readAllActiveSkus(eq(0), eq(0));
    verify(productBundleImpl, atLeast(1)).getUrl();
    verify(skuImpl).getDefaultProduct();
    verify(skuImpl, atLeast(1)).getProduct();
    verify(skuImpl).getSkuMediaXref();
    verify(skuImpl, atLeast(1)).getUrlKey();
  }

  /**
   * Test {@link SkuSiteMapGenerator#addSiteMapEntries(SiteMapGeneratorConfiguration, SiteMapBuilder)}.
   * <ul>
   *   <li>Given {@link ProductBundleImpl} {@link ProductImpl#getUrl()} return {@code /}.</li>
   *   <li>Then calls {@link ProductImpl#getUrl()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuSiteMapGenerator#addSiteMapEntries(SiteMapGeneratorConfiguration, SiteMapBuilder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SkuSiteMapGenerator.addSiteMapEntries(SiteMapGeneratorConfiguration, SiteMapBuilder)"})
  public void testAddSiteMapEntries_givenProductBundleImplGetUrlReturnSlash_thenCallsGetUrl() {
    // Arrange
    ProductBundleImpl productBundleImpl = mock(ProductBundleImpl.class);
    when(productBundleImpl.getUrl()).thenReturn("/");
    SkuImpl skuImpl = mock(SkuImpl.class);
    when(skuImpl.getSkuMediaXref()).thenReturn(new HashMap<>());
    when(skuImpl.getUrlKey()).thenReturn("https://example.org/example");
    when(skuImpl.getDefaultProduct()).thenReturn(null);
    when(skuImpl.getProduct()).thenReturn(productBundleImpl);

    ArrayList<Sku> skuList = new ArrayList<>();
    skuList.add(skuImpl);
    when(skuDao.readAllActiveSkus(anyInt(), anyInt())).thenReturn(skuList);
    CategorySiteMapGeneratorConfigurationImpl smgc = new CategorySiteMapGeneratorConfigurationImpl();
    SiteMapConfigurationImpl siteMapConfig = new SiteMapConfigurationImpl();

    // Act
    skuSiteMapGenerator.addSiteMapEntries(smgc,
        new SiteMapBuilder(siteMapConfig, new FileWorkArea(), "https://example.org/example", true));

    // Assert
    verify(skuDao).readAllActiveSkus(eq(0), eq(0));
    verify(productBundleImpl, atLeast(1)).getUrl();
    verify(skuImpl).getDefaultProduct();
    verify(skuImpl, atLeast(1)).getProduct();
    verify(skuImpl).getSkuMediaXref();
    verify(skuImpl, atLeast(1)).getUrlKey();
  }

  /**
   * Test {@link SkuSiteMapGenerator#addSiteMapEntries(SiteMapGeneratorConfiguration, SiteMapBuilder)}.
   * <ul>
   *   <li>Given {@link SkuImpl} {@link SkuImpl#getDefaultProduct()} return {@link ProductBundleImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuSiteMapGenerator#addSiteMapEntries(SiteMapGeneratorConfiguration, SiteMapBuilder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SkuSiteMapGenerator.addSiteMapEntries(SiteMapGeneratorConfiguration, SiteMapBuilder)"})
  public void testAddSiteMapEntries_givenSkuImplGetDefaultProductReturnProductBundleImpl() {
    // Arrange
    SkuImpl skuImpl = mock(SkuImpl.class);
    when(skuImpl.getDefaultProduct()).thenReturn(new ProductBundleImpl());

    ArrayList<Sku> skuList = new ArrayList<>();
    skuList.add(skuImpl);
    when(skuDao.readAllActiveSkus(anyInt(), anyInt())).thenReturn(skuList);
    CategorySiteMapGeneratorConfigurationImpl smgc = new CategorySiteMapGeneratorConfigurationImpl();
    SiteMapConfigurationImpl siteMapConfig = new SiteMapConfigurationImpl();

    // Act
    skuSiteMapGenerator.addSiteMapEntries(smgc,
        new SiteMapBuilder(siteMapConfig, new FileWorkArea(), "https://example.org/example", true));

    // Assert
    verify(skuDao).readAllActiveSkus(eq(0), eq(0));
    verify(skuImpl).getDefaultProduct();
  }

  /**
   * Test {@link SkuSiteMapGenerator#addSiteMapEntries(SiteMapGeneratorConfiguration, SiteMapBuilder)}.
   * <ul>
   *   <li>Given {@link SkuImpl} {@link SkuImpl#getProduct()} return {@link ProductBundleImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuSiteMapGenerator#addSiteMapEntries(SiteMapGeneratorConfiguration, SiteMapBuilder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SkuSiteMapGenerator.addSiteMapEntries(SiteMapGeneratorConfiguration, SiteMapBuilder)"})
  public void testAddSiteMapEntries_givenSkuImplGetProductReturnProductBundleImpl() {
    // Arrange
    SkuImpl skuImpl = mock(SkuImpl.class);
    when(skuImpl.getSkuMediaXref()).thenReturn(new HashMap<>());
    when(skuImpl.getUrlKey()).thenReturn("https://example.org/example");
    when(skuImpl.getDefaultProduct()).thenReturn(null);
    when(skuImpl.getProduct()).thenReturn(new ProductBundleImpl());

    ArrayList<Sku> skuList = new ArrayList<>();
    skuList.add(skuImpl);
    when(skuDao.readAllActiveSkus(anyInt(), anyInt())).thenReturn(skuList);
    CategorySiteMapGeneratorConfigurationImpl smgc = new CategorySiteMapGeneratorConfigurationImpl();
    SiteMapConfigurationImpl siteMapConfig = new SiteMapConfigurationImpl();

    // Act
    skuSiteMapGenerator.addSiteMapEntries(smgc,
        new SiteMapBuilder(siteMapConfig, new FileWorkArea(), "https://example.org/example", true));

    // Assert
    verify(skuDao).readAllActiveSkus(eq(0), eq(0));
    verify(skuImpl).getDefaultProduct();
    verify(skuImpl, atLeast(1)).getProduct();
    verify(skuImpl).getSkuMediaXref();
    verify(skuImpl, atLeast(1)).getUrlKey();
  }

  /**
   * Test {@link SkuSiteMapGenerator#addSiteMapEntries(SiteMapGeneratorConfiguration, SiteMapBuilder)}.
   * <ul>
   *   <li>Given {@link SkuImpl} {@link SkuImpl#getUrlKey()} return {@code null}.</li>
   *   <li>Then calls {@link ProductImpl#getUrl()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuSiteMapGenerator#addSiteMapEntries(SiteMapGeneratorConfiguration, SiteMapBuilder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SkuSiteMapGenerator.addSiteMapEntries(SiteMapGeneratorConfiguration, SiteMapBuilder)"})
  public void testAddSiteMapEntries_givenSkuImplGetUrlKeyReturnNull_thenCallsGetUrl() {
    // Arrange
    ProductBundleImpl productBundleImpl = mock(ProductBundleImpl.class);
    when(productBundleImpl.getUrl()).thenReturn("https://example.org/example");
    SkuImpl skuImpl = mock(SkuImpl.class);
    when(skuImpl.getSkuMediaXref()).thenReturn(new HashMap<>());
    when(skuImpl.getUrlKey()).thenReturn(null);
    when(skuImpl.getDefaultProduct()).thenReturn(null);
    when(skuImpl.getProduct()).thenReturn(productBundleImpl);

    ArrayList<Sku> skuList = new ArrayList<>();
    skuList.add(skuImpl);
    when(skuDao.readAllActiveSkus(anyInt(), anyInt())).thenReturn(skuList);
    CategorySiteMapGeneratorConfigurationImpl smgc = new CategorySiteMapGeneratorConfigurationImpl();
    SiteMapConfigurationImpl siteMapConfig = new SiteMapConfigurationImpl();

    // Act
    skuSiteMapGenerator.addSiteMapEntries(smgc,
        new SiteMapBuilder(siteMapConfig, new FileWorkArea(), "https://example.org/example", true));

    // Assert
    verify(skuDao).readAllActiveSkus(eq(0), eq(0));
    verify(productBundleImpl, atLeast(1)).getUrl();
    verify(skuImpl).getDefaultProduct();
    verify(skuImpl, atLeast(1)).getProduct();
    verify(skuImpl).getSkuMediaXref();
    verify(skuImpl, atLeast(1)).getUrlKey();
  }

  /**
   * Test {@link SkuSiteMapGenerator#addSiteMapEntries(SiteMapGeneratorConfiguration, SiteMapBuilder)}.
   * <ul>
   *   <li>Then calls {@link SiteMapGeneratorConfiguration#getSiteMapChangeFreq()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuSiteMapGenerator#addSiteMapEntries(SiteMapGeneratorConfiguration, SiteMapBuilder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SkuSiteMapGenerator.addSiteMapEntries(SiteMapGeneratorConfiguration, SiteMapBuilder)"})
  public void testAddSiteMapEntries_thenCallsGetSiteMapChangeFreq() {
    // Arrange
    ProductBundleImpl productBundleImpl = mock(ProductBundleImpl.class);
    when(productBundleImpl.getUrl()).thenReturn("https://example.org/example");
    SkuImpl skuImpl = mock(SkuImpl.class);
    when(skuImpl.getSkuMediaXref()).thenReturn(new HashMap<>());
    when(skuImpl.getUrlKey()).thenReturn("https://example.org/example");
    when(skuImpl.getDefaultProduct()).thenReturn(null);
    when(skuImpl.getProduct()).thenReturn(productBundleImpl);

    ArrayList<Sku> skuList = new ArrayList<>();
    skuList.add(skuImpl);
    when(skuDao.readAllActiveSkus(anyInt(), anyInt())).thenReturn(skuList);
    SiteMapGeneratorConfiguration smgc = mock(SiteMapGeneratorConfiguration.class);
    when(smgc.getSiteMapChangeFreq()).thenReturn(new SiteMapChangeFreqType("Type", "Friendly Type"));
    when(smgc.getSiteMapPriority()).thenReturn(new SiteMapPriorityType("Type", "Friendly Type"));
    SiteMapConfigurationImpl siteMapConfig = new SiteMapConfigurationImpl();

    // Act
    skuSiteMapGenerator.addSiteMapEntries(smgc,
        new SiteMapBuilder(siteMapConfig, new FileWorkArea(), "https://example.org/example", true));

    // Assert
    verify(smgc).getSiteMapChangeFreq();
    verify(smgc).getSiteMapPriority();
    verify(skuDao).readAllActiveSkus(eq(0), eq(0));
    verify(productBundleImpl, atLeast(1)).getUrl();
    verify(skuImpl).getDefaultProduct();
    verify(skuImpl, atLeast(1)).getProduct();
    verify(skuImpl).getSkuMediaXref();
    verify(skuImpl, atLeast(1)).getUrlKey();
  }

  /**
   * Test {@link SkuSiteMapGenerator#addSiteMapEntries(SiteMapGeneratorConfiguration, SiteMapBuilder)}.
   * <ul>
   *   <li>Then calls {@link ProductImpl#getUrl()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuSiteMapGenerator#addSiteMapEntries(SiteMapGeneratorConfiguration, SiteMapBuilder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SkuSiteMapGenerator.addSiteMapEntries(SiteMapGeneratorConfiguration, SiteMapBuilder)"})
  public void testAddSiteMapEntries_thenCallsGetUrl() {
    // Arrange
    ProductBundleImpl productBundleImpl = mock(ProductBundleImpl.class);
    when(productBundleImpl.getUrl()).thenReturn("https://example.org/example");
    SkuImpl skuImpl = mock(SkuImpl.class);
    when(skuImpl.getSkuMediaXref()).thenReturn(new HashMap<>());
    when(skuImpl.getUrlKey()).thenReturn("https://example.org/example");
    when(skuImpl.getDefaultProduct()).thenReturn(null);
    when(skuImpl.getProduct()).thenReturn(productBundleImpl);

    ArrayList<Sku> skuList = new ArrayList<>();
    skuList.add(skuImpl);
    when(skuDao.readAllActiveSkus(anyInt(), anyInt())).thenReturn(skuList);
    CategorySiteMapGeneratorConfigurationImpl smgc = new CategorySiteMapGeneratorConfigurationImpl();
    SiteMapConfigurationImpl siteMapConfig = new SiteMapConfigurationImpl();

    // Act
    skuSiteMapGenerator.addSiteMapEntries(smgc,
        new SiteMapBuilder(siteMapConfig, new FileWorkArea(), "https://example.org/example", true));

    // Assert
    verify(skuDao).readAllActiveSkus(eq(0), eq(0));
    verify(productBundleImpl, atLeast(1)).getUrl();
    verify(skuImpl).getDefaultProduct();
    verify(skuImpl, atLeast(1)).getProduct();
    verify(skuImpl).getSkuMediaXref();
    verify(skuImpl, atLeast(1)).getUrlKey();
  }

  /**
   * Test {@link SkuSiteMapGenerator#generateUri(SiteMapBuilder, Sku)}.
   * <p>
   * Method under test: {@link SkuSiteMapGenerator#generateUri(SiteMapBuilder, Sku)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String SkuSiteMapGenerator.generateUri(SiteMapBuilder, Sku)"})
  public void testGenerateUri() {
    // Arrange
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
   * <ul>
   *   <li>Then return {@code /https://example.org/example}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuSiteMapGenerator#generateUri(SiteMapBuilder, Sku)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String SkuSiteMapGenerator.generateUri(SiteMapBuilder, Sku)"})
  public void testGenerateUri_thenReturnHttpsExampleOrgExample() {
    // Arrange
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
   *   <li>Then return {@code https://example.org/example/https://example.org/example}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuSiteMapGenerator#generateUri(SiteMapBuilder, Sku)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String SkuSiteMapGenerator.generateUri(SiteMapBuilder, Sku)"})
  public void testGenerateUri_thenReturnHttpsExampleOrgExampleHttpsExampleOrgExample() {
    // Arrange
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
   *   <li>Then return {@code https://example.org/example/https://example.org/example}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuSiteMapGenerator#generateUri(SiteMapBuilder, Sku)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String SkuSiteMapGenerator.generateUri(SiteMapBuilder, Sku)"})
  public void testGenerateUri_thenReturnHttpsExampleOrgExampleHttpsExampleOrgExample2() {
    // Arrange
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
   *   <li>Then return {@code https://example.org/example/nullhttps://example.org/example}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuSiteMapGenerator#generateUri(SiteMapBuilder, Sku)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String SkuSiteMapGenerator.generateUri(SiteMapBuilder, Sku)"})
  public void testGenerateUri_thenReturnHttpsExampleOrgExampleNullhttpsExampleOrgExample() {
    // Arrange
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
   * Method under test: {@link SkuSiteMapGenerator#generateUri(SiteMapBuilder, Sku)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String SkuSiteMapGenerator.generateUri(SiteMapBuilder, Sku)"})
  public void testGenerateUri_thenReturnNullhttpsExampleOrgExample() {
    // Arrange
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int SkuSiteMapGenerator.getPageSize()", "SkuDao SkuSiteMapGenerator.getSkuDao()",
      "void SkuSiteMapGenerator.setPageSize(int)", "void SkuSiteMapGenerator.setSkuDao(SkuDao)"})
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
