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
import org.junit.Test;
import org.mockito.Mockito;

public class ProductSiteMapGeneratorDiffblueTest {
  /**
   * Method under test:
   * {@link ProductSiteMapGenerator#canHandleSiteMapConfiguration(SiteMapGeneratorConfiguration)}
   */
  @Test
  public void testCanHandleSiteMapConfiguration() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductSiteMapGenerator productSiteMapGenerator = new ProductSiteMapGenerator();

    // Act and Assert
    assertFalse(productSiteMapGenerator.canHandleSiteMapConfiguration(new CategorySiteMapGeneratorConfigurationImpl()));
  }

  /**
   * Method under test:
   * {@link ProductSiteMapGenerator#canHandleSiteMapConfiguration(SiteMapGeneratorConfiguration)}
   */
  @Test
  public void testCanHandleSiteMapConfiguration2() {
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
   * Method under test:
   * {@link ProductSiteMapGenerator#canHandleSiteMapConfiguration(SiteMapGeneratorConfiguration)}
   */
  @Test
  public void testCanHandleSiteMapConfiguration3() {
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
   * Method under test:
   * {@link ProductSiteMapGenerator#canHandleSiteMapConfiguration(SiteMapGeneratorConfiguration)}
   */
  @Test
  public void testCanHandleSiteMapConfiguration4() {
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
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getMedia()).thenReturn(new HashMap<>());

    // Act
    productSiteMapGenerator.constructImageURLs(siteMapBuilder, siteMapUrl, product);

    // Assert
    verify(product).getMedia();
    assertTrue(siteMapUrl.getSiteMapImageWrappers().isEmpty());
  }

  /**
   * Method under test:
   * {@link ProductSiteMapGenerator#constructImageURLs(SiteMapBuilder, SiteMapURLWrapper, Product)}
   */
  @Test
  public void testConstructImageURLs2() {
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
   * Method under test:
   * {@link ProductSiteMapGenerator#constructImageURLs(SiteMapBuilder, SiteMapURLWrapper, Product)}
   */
  @Test
  public void testConstructImageURLs3() {
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
   * Method under test:
   * {@link ProductSiteMapGenerator#constructImageURLs(SiteMapBuilder, SiteMapURLWrapper, Product)}
   */
  @Test
  public void testConstructImageURLs4() {
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
   * Method under test:
   * {@link ProductSiteMapGenerator#constructImageURLs(SiteMapBuilder, SiteMapURLWrapper, Product)}
   */
  @Test
  public void testConstructImageURLs5() {
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
   * Method under test:
   * {@link ProductSiteMapGenerator#constructImageURLs(SiteMapBuilder, SiteMapURLWrapper, Product)}
   */
  @Test
  public void testConstructImageURLs6() {
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
   * Method under test:
   * {@link ProductSiteMapGenerator#generateUri(SiteMapBuilder, Product)}
   */
  @Test
  public void testGenerateUri() {
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
   * Method under test:
   * {@link ProductSiteMapGenerator#generateUri(SiteMapBuilder, Product)}
   */
  @Test
  public void testGenerateUri2() {
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
   * Method under test:
   * {@link ProductSiteMapGenerator#generateUri(SiteMapBuilder, Product)}
   */
  @Test
  public void testGenerateUri3() {
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
   * Method under test:
   * {@link ProductSiteMapGenerator#generateUri(SiteMapBuilder, Product)}
   */
  @Test
  public void testGenerateUri4() {
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
