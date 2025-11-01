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
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
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
import org.broadleafcommerce.core.catalog.dao.CategoryDao;
import org.broadleafcommerce.core.catalog.dao.CategoryDaoImpl;
import org.broadleafcommerce.core.catalog.domain.Category;
import org.broadleafcommerce.core.catalog.domain.CategoryImpl;
import org.broadleafcommerce.core.catalog.domain.CategoryProductXref;
import org.broadleafcommerce.core.catalog.domain.CategoryProductXrefImpl;
import org.broadleafcommerce.core.catalog.domain.CategorySiteMapGeneratorConfiguration;
import org.broadleafcommerce.core.catalog.domain.CategorySiteMapGeneratorConfigurationImpl;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.boot.web.reactive.context.StandardReactiveWebEnvironment;
import org.springframework.core.env.Environment;
import org.springframework.core.env.StandardEnvironment;

public class CategorySiteMapGeneratorDiffblueTest {
  /**
   * Method under test:
   * {@link CategorySiteMapGenerator#canHandleSiteMapConfiguration(SiteMapGeneratorConfiguration)}
   */
  @Test
  public void testCanHandleSiteMapConfiguration() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategorySiteMapGenerator categorySiteMapGenerator = new CategorySiteMapGenerator(
        new StandardReactiveWebEnvironment());

    // Act and Assert
    assertFalse(
        categorySiteMapGenerator.canHandleSiteMapConfiguration(new CategorySiteMapGeneratorConfigurationImpl()));
  }

  /**
   * Method under test:
   * {@link CategorySiteMapGenerator#canHandleSiteMapConfiguration(SiteMapGeneratorConfiguration)}
   */
  @Test
  public void testCanHandleSiteMapConfiguration2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategorySiteMapGenerator categorySiteMapGenerator = new CategorySiteMapGenerator(mock(StandardEnvironment.class));

    // Act and Assert
    assertFalse(
        categorySiteMapGenerator.canHandleSiteMapConfiguration(new CategorySiteMapGeneratorConfigurationImpl()));
  }

  /**
   * Method under test:
   * {@link CategorySiteMapGenerator#canHandleSiteMapConfiguration(SiteMapGeneratorConfiguration)}
   */
  @Test
  public void testCanHandleSiteMapConfiguration3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategorySiteMapGenerator categorySiteMapGenerator = new CategorySiteMapGenerator(
        new StandardReactiveWebEnvironment());

    CustomUrlSiteMapGeneratorConfigurationImpl siteMapGeneratorConfiguration = new CustomUrlSiteMapGeneratorConfigurationImpl();
    siteMapGeneratorConfiguration.setCustomURLEntries(new ArrayList<>());
    siteMapGeneratorConfiguration.setDisabled(true);
    siteMapGeneratorConfiguration.setId(1L);
    siteMapGeneratorConfiguration.setSiteMapChangeFreq(new SiteMapChangeFreqType("Type", "Friendly Type"));
    siteMapGeneratorConfiguration.setSiteMapConfiguration(new SiteMapConfigurationImpl());
    siteMapGeneratorConfiguration.setSiteMapGeneratorType(new SiteMapGeneratorType("Type", "Friendly Type"));
    siteMapGeneratorConfiguration.setSiteMapPriority(new SiteMapPriorityType("Type", "Friendly Type"));

    // Act and Assert
    assertFalse(categorySiteMapGenerator.canHandleSiteMapConfiguration(siteMapGeneratorConfiguration));
  }

  /**
   * Method under test:
   * {@link CategorySiteMapGenerator#canHandleSiteMapConfiguration(SiteMapGeneratorConfiguration)}
   */
  @Test
  public void testCanHandleSiteMapConfiguration4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategorySiteMapGenerator categorySiteMapGenerator = new CategorySiteMapGenerator(
        new StandardReactiveWebEnvironment());

    CustomUrlSiteMapGeneratorConfigurationImpl siteMapGeneratorConfiguration = new CustomUrlSiteMapGeneratorConfigurationImpl();
    siteMapGeneratorConfiguration.setCustomURLEntries(new ArrayList<>());
    siteMapGeneratorConfiguration.setDisabled(true);
    siteMapGeneratorConfiguration.setId(1L);
    siteMapGeneratorConfiguration.setSiteMapChangeFreq(new SiteMapChangeFreqType("Type", "Friendly Type"));
    siteMapGeneratorConfiguration.setSiteMapConfiguration(new SiteMapConfigurationImpl());
    siteMapGeneratorConfiguration.setSiteMapGeneratorType(new SiteMapGeneratorType("CATEGORY", "Friendly Type"));
    siteMapGeneratorConfiguration.setSiteMapPriority(new SiteMapPriorityType("Type", "Friendly Type"));

    // Act and Assert
    assertTrue(categorySiteMapGenerator.canHandleSiteMapConfiguration(siteMapGeneratorConfiguration));
  }

  /**
   * Method under test:
   * {@link CategorySiteMapGenerator#constructSiteMapURLs(CategorySiteMapGeneratorConfiguration, SiteMapBuilder, Category)}
   */
  @Test
  public void testConstructSiteMapURLs() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategorySiteMapGenerator categorySiteMapGenerator = new CategorySiteMapGenerator(
        new StandardReactiveWebEnvironment());
    CategorySiteMapGeneratorConfigurationImpl categorySMGC = new CategorySiteMapGeneratorConfigurationImpl();
    SiteMapConfigurationImpl siteMapConfig = new SiteMapConfigurationImpl();
    SiteMapBuilder siteMapBuilder = new SiteMapBuilder(siteMapConfig, new FileWorkArea(), "https://example.org/example",
        true);

    CategoryImpl category = mock(CategoryImpl.class);
    when(category.getCategoryMediaXref()).thenReturn(new HashMap<>());
    when(category.getUrl()).thenReturn("https://example.org/example");
    when(category.getActiveProductXrefs()).thenReturn(new ArrayList<>());

    // Act
    categorySiteMapGenerator.constructSiteMapURLs(categorySMGC, siteMapBuilder, category);

    // Assert
    verify(category).getActiveProductXrefs();
    verify(category).getCategoryMediaXref();
    verify(category).getUrl();
  }

  /**
   * Method under test:
   * {@link CategorySiteMapGenerator#constructSiteMapURLs(CategorySiteMapGeneratorConfiguration, SiteMapBuilder, Category)}
   */
  @Test
  public void testConstructSiteMapURLs2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategorySiteMapGenerator categorySiteMapGenerator = new CategorySiteMapGenerator(
        new StandardReactiveWebEnvironment());
    CategorySiteMapGeneratorConfiguration categorySMGC = mock(CategorySiteMapGeneratorConfiguration.class);
    when(categorySMGC.getSiteMapChangeFreq()).thenReturn(new SiteMapChangeFreqType("Type", "Friendly Type"));
    when(categorySMGC.getSiteMapPriority()).thenReturn(new SiteMapPriorityType("Type", "Friendly Type"));
    SiteMapConfigurationImpl siteMapConfig = new SiteMapConfigurationImpl();
    SiteMapBuilder siteMapBuilder = new SiteMapBuilder(siteMapConfig, new FileWorkArea(), "https://example.org/example",
        true);

    CategoryImpl category = mock(CategoryImpl.class);
    when(category.getCategoryMediaXref()).thenReturn(new HashMap<>());
    when(category.getUrl()).thenReturn("https://example.org/example");
    when(category.getActiveProductXrefs()).thenReturn(new ArrayList<>());

    // Act
    categorySiteMapGenerator.constructSiteMapURLs(categorySMGC, siteMapBuilder, category);

    // Assert
    verify(categorySMGC).getSiteMapChangeFreq();
    verify(categorySMGC).getSiteMapPriority();
    verify(category).getActiveProductXrefs();
    verify(category).getCategoryMediaXref();
    verify(category).getUrl();
  }

  /**
   * Method under test:
   * {@link CategorySiteMapGenerator#constructSiteMapURLs(CategorySiteMapGeneratorConfiguration, SiteMapBuilder, Category)}
   */
  @Test
  public void testConstructSiteMapURLs3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategorySiteMapGenerator categorySiteMapGenerator = new CategorySiteMapGenerator(
        new StandardReactiveWebEnvironment());
    CategorySiteMapGeneratorConfiguration categorySMGC = mock(CategorySiteMapGeneratorConfiguration.class);
    when(categorySMGC.getSiteMapChangeFreq()).thenReturn(new SiteMapChangeFreqType("Type", "Friendly Type"));
    when(categorySMGC.getSiteMapPriority()).thenReturn(new SiteMapPriorityType("Type", "Friendly Type"));
    SiteMapConfigurationImpl siteMapConfig = new SiteMapConfigurationImpl();
    SiteMapBuilder siteMapBuilder = new SiteMapBuilder(siteMapConfig, new FileWorkArea(), "/", true);

    CategoryImpl category = mock(CategoryImpl.class);
    when(category.getCategoryMediaXref()).thenReturn(new HashMap<>());
    when(category.getUrl()).thenReturn("https://example.org/example");
    when(category.getActiveProductXrefs()).thenReturn(new ArrayList<>());

    // Act
    categorySiteMapGenerator.constructSiteMapURLs(categorySMGC, siteMapBuilder, category);

    // Assert
    verify(categorySMGC).getSiteMapChangeFreq();
    verify(categorySMGC).getSiteMapPriority();
    verify(category).getActiveProductXrefs();
    verify(category).getCategoryMediaXref();
    verify(category).getUrl();
  }

  /**
   * Method under test:
   * {@link CategorySiteMapGenerator#constructSiteMapURLs(CategorySiteMapGeneratorConfiguration, SiteMapBuilder, Category)}
   */
  @Test
  public void testConstructSiteMapURLs4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategorySiteMapGenerator categorySiteMapGenerator = new CategorySiteMapGenerator(
        new StandardReactiveWebEnvironment());
    CategorySiteMapGeneratorConfiguration categorySMGC = mock(CategorySiteMapGeneratorConfiguration.class);
    when(categorySMGC.getSiteMapChangeFreq()).thenReturn(new SiteMapChangeFreqType("Type", "Friendly Type"));
    when(categorySMGC.getSiteMapPriority()).thenReturn(new SiteMapPriorityType("Type", "Friendly Type"));
    SiteMapConfigurationImpl siteMapConfig = new SiteMapConfigurationImpl();
    SiteMapBuilder siteMapBuilder = new SiteMapBuilder(siteMapConfig, new FileWorkArea(), "https://example.org/example",
        true);

    CategoryImpl category = mock(CategoryImpl.class);
    when(category.getCategoryMediaXref()).thenReturn(new HashMap<>());
    when(category.getUrl()).thenReturn("/");
    when(category.getActiveProductXrefs()).thenReturn(new ArrayList<>());

    // Act
    categorySiteMapGenerator.constructSiteMapURLs(categorySMGC, siteMapBuilder, category);

    // Assert
    verify(categorySMGC).getSiteMapChangeFreq();
    verify(categorySMGC).getSiteMapPriority();
    verify(category).getActiveProductXrefs();
    verify(category).getCategoryMediaXref();
    verify(category).getUrl();
  }

  /**
   * Method under test:
   * {@link CategorySiteMapGenerator#constructSiteMapURLs(CategorySiteMapGeneratorConfiguration, SiteMapBuilder, Category)}
   */
  @Test
  public void testConstructSiteMapURLs5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategorySiteMapGenerator categorySiteMapGenerator = new CategorySiteMapGenerator(
        new StandardReactiveWebEnvironment());
    CategorySiteMapGeneratorConfiguration categorySMGC = mock(CategorySiteMapGeneratorConfiguration.class);
    when(categorySMGC.getSiteMapChangeFreq()).thenReturn(new SiteMapChangeFreqType("Type", "Friendly Type"));
    when(categorySMGC.getSiteMapPriority()).thenReturn(new SiteMapPriorityType("Type", "Friendly Type"));
    SiteMapConfigurationImpl siteMapConfig = new SiteMapConfigurationImpl();
    SiteMapBuilder siteMapBuilder = new SiteMapBuilder(siteMapConfig, new FileWorkArea(), "https://example.org/example",
        true);

    ArrayList<CategoryProductXref> categoryProductXrefList = new ArrayList<>();
    categoryProductXrefList.add(new CategoryProductXrefImpl());
    CategoryImpl category = mock(CategoryImpl.class);
    when(category.getCategoryMediaXref()).thenReturn(new HashMap<>());
    when(category.getUrl()).thenReturn("https://example.org/example");
    when(category.getActiveProductXrefs()).thenReturn(categoryProductXrefList);

    // Act
    categorySiteMapGenerator.constructSiteMapURLs(categorySMGC, siteMapBuilder, category);

    // Assert
    verify(categorySMGC).getSiteMapChangeFreq();
    verify(categorySMGC).getSiteMapPriority();
    verify(category).getActiveProductXrefs();
    verify(category).getCategoryMediaXref();
    verify(category).getUrl();
  }

  /**
   * Method under test:
   * {@link CategorySiteMapGenerator#constructSiteMapURLs(CategorySiteMapGeneratorConfiguration, SiteMapBuilder, Category)}
   */
  @Test
  public void testConstructSiteMapURLs6() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategorySiteMapGenerator categorySiteMapGenerator = new CategorySiteMapGenerator(
        new StandardReactiveWebEnvironment());
    CategorySiteMapGeneratorConfiguration categorySMGC = mock(CategorySiteMapGeneratorConfiguration.class);
    when(categorySMGC.getSiteMapChangeFreq()).thenReturn(new SiteMapChangeFreqType("Type", "Friendly Type"));
    when(categorySMGC.getSiteMapPriority()).thenReturn(new SiteMapPriorityType("Type", "Friendly Type"));
    SiteMapConfigurationImpl siteMapConfig = new SiteMapConfigurationImpl();
    SiteMapBuilder siteMapBuilder = new SiteMapBuilder(siteMapConfig, new FileWorkArea(), "/", true);

    CategoryImpl category = mock(CategoryImpl.class);
    when(category.getCategoryMediaXref()).thenReturn(new HashMap<>());
    when(category.getUrl()).thenReturn("/");
    when(category.getActiveProductXrefs()).thenReturn(new ArrayList<>());

    // Act
    categorySiteMapGenerator.constructSiteMapURLs(categorySMGC, siteMapBuilder, category);

    // Assert
    verify(categorySMGC).getSiteMapChangeFreq();
    verify(categorySMGC).getSiteMapPriority();
    verify(category).getActiveProductXrefs();
    verify(category).getCategoryMediaXref();
    verify(category).getUrl();
  }

  /**
   * Method under test:
   * {@link CategorySiteMapGenerator#getPageCountForCategory(Category)}
   */
  @Test
  public void testGetPageCountForCategory() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategorySiteMapGenerator categorySiteMapGenerator = new CategorySiteMapGenerator(
        new StandardReactiveWebEnvironment());

    // Act and Assert
    assertEquals(1, categorySiteMapGenerator.getPageCountForCategory(new CategoryImpl()).intValue());
  }

  /**
   * Method under test:
   * {@link CategorySiteMapGenerator#getPageCountForCategory(Category)}
   */
  @Test
  public void testGetPageCountForCategory2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategorySiteMapGenerator categorySiteMapGenerator = new CategorySiteMapGenerator(mock(StandardEnvironment.class));

    // Act and Assert
    assertEquals(1, categorySiteMapGenerator.getPageCountForCategory(new CategoryImpl()).intValue());
  }

  /**
   * Method under test:
   * {@link CategorySiteMapGenerator#generateUrl(SiteMapBuilder, Category, int)}
   */
  @Test
  public void testGenerateUrl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategorySiteMapGenerator categorySiteMapGenerator = new CategorySiteMapGenerator(
        new StandardReactiveWebEnvironment());
    SiteMapConfigurationImpl siteMapConfig = new SiteMapConfigurationImpl();
    SiteMapBuilder siteMapBuilder = new SiteMapBuilder(siteMapConfig, new FileWorkArea(), "https://example.org/example",
        true);

    CategoryImpl category = mock(CategoryImpl.class);
    when(category.getUrl()).thenReturn("https://example.org/example");

    // Act
    String actualGenerateUrlResult = categorySiteMapGenerator.generateUrl(siteMapBuilder, category, 10);

    // Assert
    verify(category).getUrl();
    assertEquals("https://example.org/example/https://example.org/example?page=10", actualGenerateUrlResult);
  }

  /**
   * Method under test:
   * {@link CategorySiteMapGenerator#generateUrl(SiteMapBuilder, Category, int)}
   */
  @Test
  public void testGenerateUrl2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Environment env = mock(Environment.class);
    when(env.getProperty(Mockito.<String>any(), Mockito.<String>any())).thenReturn("Property");
    CategorySiteMapGenerator categorySiteMapGenerator = new CategorySiteMapGenerator(env);
    SiteMapConfigurationImpl siteMapConfig = new SiteMapConfigurationImpl();
    SiteMapBuilder siteMapBuilder = new SiteMapBuilder(siteMapConfig, new FileWorkArea(), "Base Url", true);

    CategoryImpl category = mock(CategoryImpl.class);
    when(category.getUrl()).thenReturn("https://example.org/example");

    // Act
    String actualGenerateUrlResult = categorySiteMapGenerator.generateUrl(siteMapBuilder, category, 10);

    // Assert
    verify(category).getUrl();
    verify(env).getProperty(eq("seo.category.pagination.param"), eq("page"));
    assertEquals("Base Url/https://example.org/example", actualGenerateUrlResult);
  }

  /**
   * Method under test:
   * {@link CategorySiteMapGenerator#generateUrl(SiteMapBuilder, Category, int)}
   */
  @Test
  public void testGenerateUrl3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Environment env = mock(Environment.class);
    when(env.getProperty(Mockito.<String>any(), Mockito.<String>any())).thenReturn("Property");
    CategorySiteMapGenerator categorySiteMapGenerator = new CategorySiteMapGenerator(env);
    SiteMapConfigurationImpl siteMapConfig = new SiteMapConfigurationImpl();
    SiteMapBuilder siteMapBuilder = new SiteMapBuilder(siteMapConfig, new FileWorkArea(), "42", true);

    CategoryImpl category = mock(CategoryImpl.class);
    when(category.getUrl()).thenReturn("https://example.org/example");

    // Act
    String actualGenerateUrlResult = categorySiteMapGenerator.generateUrl(siteMapBuilder, category, 10);

    // Assert
    verify(category).getUrl();
    verify(env).getProperty(eq("seo.category.pagination.param"), eq("page"));
    assertEquals("42/https://example.org/example?Property=10", actualGenerateUrlResult);
  }

  /**
   * Method under test:
   * {@link CategorySiteMapGenerator#generateUrl(SiteMapBuilder, Category, int)}
   */
  @Test
  public void testGenerateUrl4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Environment env = mock(Environment.class);
    when(env.getProperty(Mockito.<String>any(), Mockito.<String>any())).thenReturn("Property");
    CategorySiteMapGenerator categorySiteMapGenerator = new CategorySiteMapGenerator(env);
    SiteMapConfigurationImpl siteMapConfig = new SiteMapConfigurationImpl();
    SiteMapBuilder siteMapBuilder = new SiteMapBuilder(siteMapConfig, new FileWorkArea(), "https://example.org/example",
        true);

    CategoryImpl category = mock(CategoryImpl.class);
    when(category.getUrl()).thenReturn("/");

    // Act
    String actualGenerateUrlResult = categorySiteMapGenerator.generateUrl(siteMapBuilder, category, 10);

    // Assert
    verify(category).getUrl();
    verify(env).getProperty(eq("seo.category.pagination.param"), eq("page"));
    assertEquals("https://example.org/example/?Property=10", actualGenerateUrlResult);
  }

  /**
   * Method under test:
   * {@link CategorySiteMapGenerator#generateUrl(SiteMapBuilder, Category, int)}
   */
  @Test
  public void testGenerateUrl5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Environment env = mock(Environment.class);
    when(env.getProperty(Mockito.<String>any(), Mockito.<String>any())).thenReturn("Property");
    CategorySiteMapGenerator categorySiteMapGenerator = new CategorySiteMapGenerator(env);
    SiteMapConfigurationImpl siteMapConfig = new SiteMapConfigurationImpl();
    SiteMapBuilder siteMapBuilder = new SiteMapBuilder(siteMapConfig, new FileWorkArea(), "https://example.org/example",
        true);

    CategoryImpl category = mock(CategoryImpl.class);
    when(category.getUrl()).thenReturn("https://example.org/example");

    // Act
    String actualGenerateUrlResult = categorySiteMapGenerator.generateUrl(siteMapBuilder, category, 1);

    // Assert
    verify(category).getUrl();
    verify(env).getProperty(eq("seo.category.pagination.param"), eq("page"));
    assertEquals("https://example.org/example/https://example.org/example", actualGenerateUrlResult);
  }

  /**
   * Method under test:
   * {@link CategorySiteMapGenerator#generateUrl(SiteMapBuilder, Category, int)}
   */
  @Test
  public void testGenerateUrl6() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Environment env = mock(Environment.class);
    when(env.getProperty(Mockito.<String>any(), Mockito.<String>any())).thenReturn("Property");
    CategorySiteMapGenerator categorySiteMapGenerator = new CategorySiteMapGenerator(env);
    SiteMapConfigurationImpl siteMapConfig = new SiteMapConfigurationImpl();
    SiteMapBuilder siteMapBuilder = new SiteMapBuilder(siteMapConfig, new FileWorkArea(), "https://example.org/example",
        true);

    CategoryImpl category = mock(CategoryImpl.class);
    when(category.getUrl()).thenReturn("?");

    // Act
    String actualGenerateUrlResult = categorySiteMapGenerator.generateUrl(siteMapBuilder, category, 10);

    // Assert
    verify(category).getUrl();
    verify(env).getProperty(eq("seo.category.pagination.param"), eq("page"));
    assertEquals("https://example.org/example/?Property=10", actualGenerateUrlResult);
  }

  /**
   * Method under test:
   * {@link CategorySiteMapGenerator#generateUrl(SiteMapBuilder, Category, int)}
   */
  @Test
  public void testGenerateUrl7() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Environment env = mock(Environment.class);
    when(env.getProperty(Mockito.<String>any(), Mockito.<String>any())).thenReturn("Property");
    CategorySiteMapGenerator categorySiteMapGenerator = new CategorySiteMapGenerator(env);
    SiteMapConfigurationImpl siteMapConfig = new SiteMapConfigurationImpl();
    SiteMapBuilder siteMapBuilder = new SiteMapBuilder(siteMapConfig, new FileWorkArea(), "/", true);

    CategoryImpl category = mock(CategoryImpl.class);
    when(category.getUrl()).thenReturn("/");

    // Act
    String actualGenerateUrlResult = categorySiteMapGenerator.generateUrl(siteMapBuilder, category, 10);

    // Assert
    verify(category).getUrl();
    verify(env).getProperty(eq("seo.category.pagination.param"), eq("page"));
    assertEquals("/?Property=10", actualGenerateUrlResult);
  }

  /**
   * Method under test:
   * {@link CategorySiteMapGenerator#generateUrl(SiteMapBuilder, Category, int)}
   */
  @Test
  public void testGenerateUrl8() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Environment env = mock(Environment.class);
    when(env.getProperty(Mockito.<String>any(), Mockito.<String>any())).thenReturn("Property");
    CategorySiteMapGenerator categorySiteMapGenerator = new CategorySiteMapGenerator(env);
    SiteMapConfigurationImpl siteMapConfig = new SiteMapConfigurationImpl();
    SiteMapBuilder siteMapBuilder = new SiteMapBuilder(siteMapConfig, new FileWorkArea(), "/", true);

    CategoryImpl category = mock(CategoryImpl.class);
    when(category.getUrl()).thenReturn("https://example.org/example");

    // Act
    String actualGenerateUrlResult = categorySiteMapGenerator.generateUrl(siteMapBuilder, category, 1);

    // Assert
    verify(category).getUrl();
    verify(env).getProperty(eq("seo.category.pagination.param"), eq("page"));
    assertEquals("/https://example.org/example", actualGenerateUrlResult);
  }

  /**
   * Method under test: {@link CategorySiteMapGenerator#getDefaultPageSize()}
   */
  @Test
  public void testGetDefaultPageSize() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals(40, (new CategorySiteMapGenerator(new StandardReactiveWebEnvironment())).getDefaultPageSize());
  }

  /**
   * Method under test: {@link CategorySiteMapGenerator#getDefaultPageSize()}
   */
  @Test
  public void testGetDefaultPageSize2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Environment env = mock(Environment.class);
    when(env.getProperty(Mockito.<String>any(), Mockito.<Class<Object>>any(), Mockito.<Object>any())).thenReturn(40);

    // Act
    int actualDefaultPageSize = (new CategorySiteMapGenerator(env)).getDefaultPageSize();

    // Assert
    verify(env).getProperty(eq("web.defaultPageSize"), isA(Class.class), isA(Object.class));
    assertEquals(40, actualDefaultPageSize);
  }

  /**
   * Method under test:
   * {@link CategorySiteMapGenerator#getCategoryPaginationParam()}
   */
  @Test
  public void testGetCategoryPaginationParam() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("page",
        (new CategorySiteMapGenerator(new StandardReactiveWebEnvironment())).getCategoryPaginationParam());
  }

  /**
   * Method under test:
   * {@link CategorySiteMapGenerator#getCategoryPaginationParam()}
   */
  @Test
  public void testGetCategoryPaginationParam2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StandardEnvironment env = mock(StandardEnvironment.class);
    when(env.getProperty(Mockito.<String>any(), Mockito.<String>any())).thenReturn("Property");

    // Act
    String actualCategoryPaginationParam = (new CategorySiteMapGenerator(env)).getCategoryPaginationParam();

    // Assert
    verify(env).getProperty(eq("seo.category.pagination.param"), eq("page"));
    assertEquals("Property", actualCategoryPaginationParam);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link CategorySiteMapGenerator#setCategoryDao(CategoryDao)}
   *   <li>{@link CategorySiteMapGenerator#setRowLimit(int)}
   *   <li>{@link CategorySiteMapGenerator#getCategoryDao()}
   *   <li>{@link CategorySiteMapGenerator#getRowLimit()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    CategorySiteMapGenerator categorySiteMapGenerator = new CategorySiteMapGenerator(
        new StandardReactiveWebEnvironment());
    CategoryDaoImpl categoryDao = new CategoryDaoImpl();

    // Act
    categorySiteMapGenerator.setCategoryDao(categoryDao);
    categorySiteMapGenerator.setRowLimit(1);
    CategoryDao actualCategoryDao = categorySiteMapGenerator.getCategoryDao();

    // Assert that nothing has changed
    assertTrue(actualCategoryDao instanceof CategoryDaoImpl);
    assertEquals(1, categorySiteMapGenerator.getRowLimit());
    assertSame(categoryDao, actualCategoryDao);
  }
}
