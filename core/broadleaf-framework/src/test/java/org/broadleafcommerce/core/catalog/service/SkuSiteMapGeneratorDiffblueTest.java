/*-
 * #%L
 * BroadleafCommerce Framework
 * %%
 * Copyright (C) 2009 - 2024 Broadleaf Commerce
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
import org.broadleafcommerce.core.catalog.dao.SkuDao;
import org.broadleafcommerce.core.catalog.dao.SkuDaoImpl;
import org.broadleafcommerce.core.catalog.domain.CategorySiteMapGeneratorConfigurationImpl;
import org.broadleafcommerce.core.catalog.domain.ProductBundleImpl;
import org.broadleafcommerce.core.catalog.domain.Sku;
import org.broadleafcommerce.core.catalog.domain.SkuImpl;
import org.junit.Test;

public class SkuSiteMapGeneratorDiffblueTest {
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
