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
import org.broadleafcommerce.core.catalog.dao.CategoryDao;
import org.broadleafcommerce.core.catalog.dao.CategoryDaoImpl;
import org.broadleafcommerce.core.catalog.domain.CategoryImpl;
import org.broadleafcommerce.core.catalog.domain.CategoryProductXref;
import org.broadleafcommerce.core.catalog.domain.CategoryProductXrefImpl;
import org.broadleafcommerce.core.catalog.domain.CategorySiteMapGeneratorConfiguration;
import org.broadleafcommerce.core.catalog.domain.CategorySiteMapGeneratorConfigurationImpl;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.web.reactive.context.StandardReactiveWebEnvironment;
import org.springframework.core.env.Environment;
import org.springframework.core.env.PropertyResolver;

@RunWith(MockitoJUnitRunner.class)
public class CategorySiteMapGeneratorDiffblueTest {
  @InjectMocks
  private CategorySiteMapGenerator categorySiteMapGenerator;

  @Mock
  private Environment environment;

  /**
   * Test {@link CategorySiteMapGenerator#canHandleSiteMapConfiguration(SiteMapGeneratorConfiguration)}.
   * <p>
   * Method under test: {@link CategorySiteMapGenerator#canHandleSiteMapConfiguration(SiteMapGeneratorConfiguration)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean CategorySiteMapGenerator.canHandleSiteMapConfiguration(SiteMapGeneratorConfiguration)"})
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
    assertFalse(categorySiteMapGenerator.canHandleSiteMapConfiguration(siteMapGeneratorConfiguration));
  }

  /**
   * Test {@link CategorySiteMapGenerator#canHandleSiteMapConfiguration(SiteMapGeneratorConfiguration)}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategorySiteMapGenerator#canHandleSiteMapConfiguration(SiteMapGeneratorConfiguration)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean CategorySiteMapGenerator.canHandleSiteMapConfiguration(SiteMapGeneratorConfiguration)"})
  public void testCanHandleSiteMapConfiguration_thenReturnTrue() {
    // Arrange
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
   * Test {@link CategorySiteMapGenerator#canHandleSiteMapConfiguration(SiteMapGeneratorConfiguration)}.
   * <ul>
   *   <li>When {@link CategorySiteMapGeneratorConfigurationImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link CategorySiteMapGenerator#canHandleSiteMapConfiguration(SiteMapGeneratorConfiguration)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean CategorySiteMapGenerator.canHandleSiteMapConfiguration(SiteMapGeneratorConfiguration)"})
  public void testCanHandleSiteMapConfiguration_whenCategorySiteMapGeneratorConfigurationImpl() {
    // Arrange, Act and Assert
    assertFalse(
        categorySiteMapGenerator.canHandleSiteMapConfiguration(new CategorySiteMapGeneratorConfigurationImpl()));
  }

  /**
   * Test {@link CategorySiteMapGenerator#constructSiteMapURLs(CategorySiteMapGeneratorConfiguration, SiteMapBuilder, Category)}.
   * <p>
   * Method under test: {@link CategorySiteMapGenerator#constructSiteMapURLs(CategorySiteMapGeneratorConfiguration, SiteMapBuilder, org.broadleafcommerce.core.catalog.domain.Category)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void CategorySiteMapGenerator.constructSiteMapURLs(CategorySiteMapGeneratorConfiguration, SiteMapBuilder, org.broadleafcommerce.core.catalog.domain.Category)"})
  public void testConstructSiteMapURLs() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any(), Mockito.<String>any())).thenReturn("Property");
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
    verify(environment).getProperty(eq("seo.category.pagination.param"), eq("page"));
  }

  /**
   * Test {@link CategorySiteMapGenerator#constructSiteMapURLs(CategorySiteMapGeneratorConfiguration, SiteMapBuilder, Category)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.</li>
   *   <li>Then calls {@link SiteMapGeneratorConfiguration#getSiteMapChangeFreq()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategorySiteMapGenerator#constructSiteMapURLs(CategorySiteMapGeneratorConfiguration, SiteMapBuilder, org.broadleafcommerce.core.catalog.domain.Category)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void CategorySiteMapGenerator.constructSiteMapURLs(CategorySiteMapGeneratorConfiguration, SiteMapBuilder, org.broadleafcommerce.core.catalog.domain.Category)"})
  public void testConstructSiteMapURLs_givenArrayList_thenCallsGetSiteMapChangeFreq() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any(), Mockito.<String>any())).thenReturn("Property");
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
    verify(environment).getProperty(eq("seo.category.pagination.param"), eq("page"));
  }

  /**
   * Test {@link CategorySiteMapGenerator#constructSiteMapURLs(CategorySiteMapGeneratorConfiguration, SiteMapBuilder, Category)}.
   * <ul>
   *   <li>Given {@code /}.</li>
   *   <li>When {@link CategoryImpl} {@link CategoryImpl#getUrl()} return {@code /}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategorySiteMapGenerator#constructSiteMapURLs(CategorySiteMapGeneratorConfiguration, SiteMapBuilder, org.broadleafcommerce.core.catalog.domain.Category)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void CategorySiteMapGenerator.constructSiteMapURLs(CategorySiteMapGeneratorConfiguration, SiteMapBuilder, org.broadleafcommerce.core.catalog.domain.Category)"})
  public void testConstructSiteMapURLs_givenSlash_whenCategoryImplGetUrlReturnSlash() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any(), Mockito.<String>any())).thenReturn("Property");
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
    verify(environment).getProperty(eq("seo.category.pagination.param"), eq("page"));
  }

  /**
   * Test {@link CategorySiteMapGenerator#constructSiteMapURLs(CategorySiteMapGeneratorConfiguration, SiteMapBuilder, Category)}.
   * <ul>
   *   <li>Then calls {@link PropertyResolver#getProperty(String, Class, Object)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategorySiteMapGenerator#constructSiteMapURLs(CategorySiteMapGeneratorConfiguration, SiteMapBuilder, org.broadleafcommerce.core.catalog.domain.Category)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void CategorySiteMapGenerator.constructSiteMapURLs(CategorySiteMapGeneratorConfiguration, SiteMapBuilder, org.broadleafcommerce.core.catalog.domain.Category)"})
  public void testConstructSiteMapURLs_thenCallsGetProperty() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any(), Mockito.<Class<Object>>any(), Mockito.<Object>any()))
        .thenReturn(1);
    when(environment.getProperty(Mockito.<String>any(), Mockito.<String>any())).thenReturn("Property");
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
    verify(environment).getProperty(eq("seo.category.pagination.param"), eq("page"));
    verify(environment).getProperty(eq("web.defaultPageSize"), isA(Class.class), isA(Object.class));
  }

  /**
   * Test {@link CategorySiteMapGenerator#constructSiteMapURLs(CategorySiteMapGeneratorConfiguration, SiteMapBuilder, Category)}.
   * <ul>
   *   <li>When {@link CategorySiteMapGeneratorConfigurationImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link CategorySiteMapGenerator#constructSiteMapURLs(CategorySiteMapGeneratorConfiguration, SiteMapBuilder, org.broadleafcommerce.core.catalog.domain.Category)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void CategorySiteMapGenerator.constructSiteMapURLs(CategorySiteMapGeneratorConfiguration, SiteMapBuilder, org.broadleafcommerce.core.catalog.domain.Category)"})
  public void testConstructSiteMapURLs_whenCategorySiteMapGeneratorConfigurationImpl() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any(), Mockito.<String>any())).thenReturn("Property");
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
    verify(environment).getProperty(eq("seo.category.pagination.param"), eq("page"));
  }

  /**
   * Test {@link CategorySiteMapGenerator#getPageCountForCategory(Category)}.
   * <ul>
   *   <li>When {@link CategoryImpl} (default constructor).</li>
   *   <li>Then return intValue is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategorySiteMapGenerator#getPageCountForCategory(org.broadleafcommerce.core.catalog.domain.Category)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "java.lang.Integer CategorySiteMapGenerator.getPageCountForCategory(org.broadleafcommerce.core.catalog.domain.Category)"})
  public void testGetPageCountForCategory_whenCategoryImpl_thenReturnIntValueIsOne() {
    // Arrange, Act and Assert
    assertEquals(1, categorySiteMapGenerator.getPageCountForCategory(new CategoryImpl()).intValue());
  }

  /**
   * Test {@link CategorySiteMapGenerator#generateUrl(SiteMapBuilder, Category, int)}.
   * <ul>
   *   <li>Given {@code ?}.</li>
   *   <li>When {@link CategoryImpl} {@link CategoryImpl#getUrl()} return {@code ?}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategorySiteMapGenerator#generateUrl(SiteMapBuilder, org.broadleafcommerce.core.catalog.domain.Category, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "String CategorySiteMapGenerator.generateUrl(SiteMapBuilder, org.broadleafcommerce.core.catalog.domain.Category, int)"})
  public void testGenerateUrl_givenQuestionMark_whenCategoryImplGetUrlReturnQuestionMark() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any(), Mockito.<String>any())).thenReturn("Property");
    SiteMapConfigurationImpl siteMapConfig = new SiteMapConfigurationImpl();
    SiteMapBuilder siteMapBuilder = new SiteMapBuilder(siteMapConfig, new FileWorkArea(), "https://example.org/example",
        true);

    CategoryImpl category = mock(CategoryImpl.class);
    when(category.getUrl()).thenReturn("?");

    // Act
    String actualGenerateUrlResult = categorySiteMapGenerator.generateUrl(siteMapBuilder, category, 10);

    // Assert
    verify(category).getUrl();
    verify(environment).getProperty(eq("seo.category.pagination.param"), eq("page"));
    assertEquals("https://example.org/example/?Property=10", actualGenerateUrlResult);
  }

  /**
   * Test {@link CategorySiteMapGenerator#generateUrl(SiteMapBuilder, Category, int)}.
   * <ul>
   *   <li>Given {@code /}.</li>
   *   <li>Then return {@code https://example.org/example/?Property=10}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategorySiteMapGenerator#generateUrl(SiteMapBuilder, org.broadleafcommerce.core.catalog.domain.Category, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "String CategorySiteMapGenerator.generateUrl(SiteMapBuilder, org.broadleafcommerce.core.catalog.domain.Category, int)"})
  public void testGenerateUrl_givenSlash_thenReturnHttpsExampleOrgExampleProperty10() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any(), Mockito.<String>any())).thenReturn("Property");
    SiteMapConfigurationImpl siteMapConfig = new SiteMapConfigurationImpl();
    SiteMapBuilder siteMapBuilder = new SiteMapBuilder(siteMapConfig, new FileWorkArea(), "https://example.org/example",
        true);

    CategoryImpl category = mock(CategoryImpl.class);
    when(category.getUrl()).thenReturn("/");

    // Act
    String actualGenerateUrlResult = categorySiteMapGenerator.generateUrl(siteMapBuilder, category, 10);

    // Assert
    verify(category).getUrl();
    verify(environment).getProperty(eq("seo.category.pagination.param"), eq("page"));
    assertEquals("https://example.org/example/?Property=10", actualGenerateUrlResult);
  }

  /**
   * Test {@link CategorySiteMapGenerator#generateUrl(SiteMapBuilder, Category, int)}.
   * <ul>
   *   <li>Given {@code /}.</li>
   *   <li>Then return {@code /?Property=10}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategorySiteMapGenerator#generateUrl(SiteMapBuilder, org.broadleafcommerce.core.catalog.domain.Category, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "String CategorySiteMapGenerator.generateUrl(SiteMapBuilder, org.broadleafcommerce.core.catalog.domain.Category, int)"})
  public void testGenerateUrl_givenSlash_thenReturnProperty10() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any(), Mockito.<String>any())).thenReturn("Property");
    SiteMapConfigurationImpl siteMapConfig = new SiteMapConfigurationImpl();
    SiteMapBuilder siteMapBuilder = new SiteMapBuilder(siteMapConfig, new FileWorkArea(), "/", true);

    CategoryImpl category = mock(CategoryImpl.class);
    when(category.getUrl()).thenReturn("/");

    // Act
    String actualGenerateUrlResult = categorySiteMapGenerator.generateUrl(siteMapBuilder, category, 10);

    // Assert
    verify(category).getUrl();
    verify(environment).getProperty(eq("seo.category.pagination.param"), eq("page"));
    assertEquals("/?Property=10", actualGenerateUrlResult);
  }

  /**
   * Test {@link CategorySiteMapGenerator#generateUrl(SiteMapBuilder, Category, int)}.
   * <ul>
   *   <li>Then return {@code Base Url/https://example.org/example}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategorySiteMapGenerator#generateUrl(SiteMapBuilder, org.broadleafcommerce.core.catalog.domain.Category, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "String CategorySiteMapGenerator.generateUrl(SiteMapBuilder, org.broadleafcommerce.core.catalog.domain.Category, int)"})
  public void testGenerateUrl_thenReturnBaseUrlHttpsExampleOrgExample() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any(), Mockito.<String>any())).thenReturn("Property");
    SiteMapConfigurationImpl siteMapConfig = new SiteMapConfigurationImpl();
    SiteMapBuilder siteMapBuilder = new SiteMapBuilder(siteMapConfig, new FileWorkArea(), "Base Url", true);

    CategoryImpl category = mock(CategoryImpl.class);
    when(category.getUrl()).thenReturn("https://example.org/example");

    // Act
    String actualGenerateUrlResult = categorySiteMapGenerator.generateUrl(siteMapBuilder, category, 10);

    // Assert
    verify(category).getUrl();
    verify(environment).getProperty(eq("seo.category.pagination.param"), eq("page"));
    assertEquals("Base Url/https://example.org/example", actualGenerateUrlResult);
  }

  /**
   * Test {@link CategorySiteMapGenerator#generateUrl(SiteMapBuilder, Category, int)}.
   * <ul>
   *   <li>Then return {@code https://example.org/example/https://example.org/example?Property=10}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategorySiteMapGenerator#generateUrl(SiteMapBuilder, org.broadleafcommerce.core.catalog.domain.Category, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "String CategorySiteMapGenerator.generateUrl(SiteMapBuilder, org.broadleafcommerce.core.catalog.domain.Category, int)"})
  public void testGenerateUrl_thenReturnHttpsExampleOrgExampleHttpsExampleOrgExampleProperty10() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any(), Mockito.<String>any())).thenReturn("Property");
    SiteMapConfigurationImpl siteMapConfig = new SiteMapConfigurationImpl();
    SiteMapBuilder siteMapBuilder = new SiteMapBuilder(siteMapConfig, new FileWorkArea(), "https://example.org/example",
        true);

    CategoryImpl category = mock(CategoryImpl.class);
    when(category.getUrl()).thenReturn("https://example.org/example");

    // Act
    String actualGenerateUrlResult = categorySiteMapGenerator.generateUrl(siteMapBuilder, category, 10);

    // Assert
    verify(category).getUrl();
    verify(environment).getProperty(eq("seo.category.pagination.param"), eq("page"));
    assertEquals("https://example.org/example/https://example.org/example?Property=10", actualGenerateUrlResult);
  }

  /**
   * Test {@link CategorySiteMapGenerator#generateUrl(SiteMapBuilder, Category, int)}.
   * <ul>
   *   <li>Then return {@code /https://example.org/example?Property=10}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategorySiteMapGenerator#generateUrl(SiteMapBuilder, org.broadleafcommerce.core.catalog.domain.Category, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "String CategorySiteMapGenerator.generateUrl(SiteMapBuilder, org.broadleafcommerce.core.catalog.domain.Category, int)"})
  public void testGenerateUrl_thenReturnHttpsExampleOrgExampleProperty10() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any(), Mockito.<String>any())).thenReturn("Property");
    SiteMapConfigurationImpl siteMapConfig = new SiteMapConfigurationImpl();
    SiteMapBuilder siteMapBuilder = new SiteMapBuilder(siteMapConfig, new FileWorkArea(), "/", true);

    CategoryImpl category = mock(CategoryImpl.class);
    when(category.getUrl()).thenReturn("https://example.org/example");

    // Act
    String actualGenerateUrlResult = categorySiteMapGenerator.generateUrl(siteMapBuilder, category, 10);

    // Assert
    verify(category).getUrl();
    verify(environment).getProperty(eq("seo.category.pagination.param"), eq("page"));
    assertEquals("/https://example.org/example?Property=10", actualGenerateUrlResult);
  }

  /**
   * Test {@link CategorySiteMapGenerator#generateUrl(SiteMapBuilder, Category, int)}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return {@code https://example.org/example/https://example.org/example}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategorySiteMapGenerator#generateUrl(SiteMapBuilder, org.broadleafcommerce.core.catalog.domain.Category, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "String CategorySiteMapGenerator.generateUrl(SiteMapBuilder, org.broadleafcommerce.core.catalog.domain.Category, int)"})
  public void testGenerateUrl_whenOne_thenReturnHttpsExampleOrgExampleHttpsExampleOrgExample() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any(), Mockito.<String>any())).thenReturn("Property");
    SiteMapConfigurationImpl siteMapConfig = new SiteMapConfigurationImpl();
    SiteMapBuilder siteMapBuilder = new SiteMapBuilder(siteMapConfig, new FileWorkArea(), "https://example.org/example",
        true);

    CategoryImpl category = mock(CategoryImpl.class);
    when(category.getUrl()).thenReturn("https://example.org/example");

    // Act
    String actualGenerateUrlResult = categorySiteMapGenerator.generateUrl(siteMapBuilder, category, 1);

    // Assert
    verify(category).getUrl();
    verify(environment).getProperty(eq("seo.category.pagination.param"), eq("page"));
    assertEquals("https://example.org/example/https://example.org/example", actualGenerateUrlResult);
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link CategorySiteMapGenerator#setCategoryDao(CategoryDao)}
   *   <li>{@link CategorySiteMapGenerator#setRowLimit(int)}
   *   <li>{@link CategorySiteMapGenerator#getCategoryDao()}
   *   <li>{@link CategorySiteMapGenerator#getRowLimit()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CategoryDao CategorySiteMapGenerator.getCategoryDao()",
      "int CategorySiteMapGenerator.getRowLimit()", "void CategorySiteMapGenerator.setCategoryDao(CategoryDao)",
      "void CategorySiteMapGenerator.setRowLimit(int)"})
  public void testGettersAndSetters() {
    // Arrange
    CategorySiteMapGenerator categorySiteMapGenerator = new CategorySiteMapGenerator(
        new StandardReactiveWebEnvironment());
    CategoryDaoImpl categoryDao = new CategoryDaoImpl();

    // Act
    categorySiteMapGenerator.setCategoryDao(categoryDao);
    categorySiteMapGenerator.setRowLimit(1);
    CategoryDao actualCategoryDao = categorySiteMapGenerator.getCategoryDao();

    // Assert
    assertTrue(actualCategoryDao instanceof CategoryDaoImpl);
    assertEquals(1, categorySiteMapGenerator.getRowLimit());
    assertSame(categoryDao, actualCategoryDao);
  }

  /**
   * Test {@link CategorySiteMapGenerator#getDefaultPageSize()}.
   * <p>
   * Method under test: {@link CategorySiteMapGenerator#getDefaultPageSize()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int CategorySiteMapGenerator.getDefaultPageSize()"})
  public void testGetDefaultPageSize() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any(), Mockito.<Class<Object>>any(), Mockito.<Object>any()))
        .thenReturn(40);

    // Act
    int actualDefaultPageSize = categorySiteMapGenerator.getDefaultPageSize();

    // Assert
    verify(environment).getProperty(eq("web.defaultPageSize"), isA(Class.class), isA(Object.class));
    assertEquals(40, actualDefaultPageSize);
  }

  /**
   * Test {@link CategorySiteMapGenerator#getCategoryPaginationParam()}.
   * <p>
   * Method under test: {@link CategorySiteMapGenerator#getCategoryPaginationParam()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String CategorySiteMapGenerator.getCategoryPaginationParam()"})
  public void testGetCategoryPaginationParam() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any(), Mockito.<String>any())).thenReturn("Property");

    // Act
    String actualCategoryPaginationParam = categorySiteMapGenerator.getCategoryPaginationParam();

    // Assert
    verify(environment).getProperty(eq("seo.category.pagination.param"), eq("page"));
    assertEquals("Property", actualCategoryPaginationParam);
  }
}
