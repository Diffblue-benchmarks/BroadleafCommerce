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
import org.broadleafcommerce.common.sitemap.wrapper.SiteMapURLWrapper;
import org.broadleafcommerce.core.catalog.dao.CategoryDao;
import org.broadleafcommerce.core.catalog.dao.CategoryDaoImpl;
import org.broadleafcommerce.core.catalog.domain.Category;
import org.broadleafcommerce.core.catalog.domain.CategoryImpl;
import org.broadleafcommerce.core.catalog.domain.CategoryProductXref;
import org.broadleafcommerce.core.catalog.domain.CategoryProductXrefImpl;
import org.broadleafcommerce.core.catalog.domain.CategorySiteMapGeneratorConfiguration;
import org.broadleafcommerce.core.catalog.domain.CategorySiteMapGeneratorConfigurationImpl;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.reactive.context.StandardReactiveWebEnvironment;
import org.springframework.core.env.Environment;
import org.springframework.core.env.PropertyResolver;
import org.springframework.core.env.StandardEnvironment;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml",
    "/bl-framework-applicationContext-persistence.xml", "/bl-framework-applicationContext-workflow.xml",
    "/bl-framework-applicationContext.xml", "/blc-config/admin/framework/bl-framework-admin-applicationContext.xml",
    "/blc-config/site/framework/bl-framework-applicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class CategorySiteMapGeneratorDiffblueTest {
  @Autowired
  private CategorySiteMapGenerator categorySiteMapGenerator;

  /**
   * Test
   * {@link CategorySiteMapGenerator#canHandleSiteMapConfiguration(SiteMapGeneratorConfiguration)}.
   * <p>
   * Method under test:
   * {@link CategorySiteMapGenerator#canHandleSiteMapConfiguration(SiteMapGeneratorConfiguration)}
   */
  @Test
  public void testCanHandleSiteMapConfiguration() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategorySiteMapGenerator categorySiteMapGenerator = new CategorySiteMapGenerator(mock(StandardEnvironment.class));

    // Act and Assert
    assertFalse(
        categorySiteMapGenerator.canHandleSiteMapConfiguration(new CategorySiteMapGeneratorConfigurationImpl()));
  }

  /**
   * Test
   * {@link CategorySiteMapGenerator#canHandleSiteMapConfiguration(SiteMapGeneratorConfiguration)}.
   * <p>
   * Method under test:
   * {@link CategorySiteMapGenerator#canHandleSiteMapConfiguration(SiteMapGeneratorConfiguration)}
   */
  @Test
  public void testCanHandleSiteMapConfiguration2() {
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
   * Test
   * {@link CategorySiteMapGenerator#canHandleSiteMapConfiguration(SiteMapGeneratorConfiguration)}.
   * <p>
   * Method under test:
   * {@link CategorySiteMapGenerator#canHandleSiteMapConfiguration(SiteMapGeneratorConfiguration)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testCanHandleSiteMapConfiguration3() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.catalog.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass5552 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.catalog.service.CategorySiteMapGenerator categorySiteMapGenerator;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    CategorySiteMapGenerator categorySiteMapGenerator2 = new CategorySiteMapGenerator(
        new StandardReactiveWebEnvironment());

    // Act
    categorySiteMapGenerator2.canHandleSiteMapConfiguration(new CategorySiteMapGeneratorConfigurationImpl());
  }

  /**
   * Test
   * {@link CategorySiteMapGenerator#canHandleSiteMapConfiguration(SiteMapGeneratorConfiguration)}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CategorySiteMapGenerator#canHandleSiteMapConfiguration(SiteMapGeneratorConfiguration)}
   */
  @Test
  public void testCanHandleSiteMapConfiguration_thenReturnTrue() {
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
   * Test
   * {@link CategorySiteMapGenerator#canHandleSiteMapConfiguration(SiteMapGeneratorConfiguration)}.
   * <ul>
   *   <li>When {@link CategorySiteMapGeneratorConfigurationImpl} (default
   * constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CategorySiteMapGenerator#canHandleSiteMapConfiguration(SiteMapGeneratorConfiguration)}
   */
  @Test
  public void testCanHandleSiteMapConfiguration_whenCategorySiteMapGeneratorConfigurationImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategorySiteMapGenerator categorySiteMapGenerator = new CategorySiteMapGenerator(
        new StandardReactiveWebEnvironment());

    // Act and Assert
    assertFalse(
        categorySiteMapGenerator.canHandleSiteMapConfiguration(new CategorySiteMapGeneratorConfigurationImpl()));
  }

  /**
   * Test
   * {@link CategorySiteMapGenerator#addSiteMapEntries(SiteMapGeneratorConfiguration, SiteMapBuilder)}.
   * <p>
   * Method under test:
   * {@link CategorySiteMapGenerator#addSiteMapEntries(SiteMapGeneratorConfiguration, SiteMapBuilder)}
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
    //   public class DiffblueFakeClass5522 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.catalog.service.CategorySiteMapGenerator categorySiteMapGenerator;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    CategorySiteMapGenerator categorySiteMapGenerator2 = new CategorySiteMapGenerator(
        new StandardReactiveWebEnvironment());
    CategorySiteMapGeneratorConfigurationImpl smgc = new CategorySiteMapGeneratorConfigurationImpl();
    SiteMapConfigurationImpl siteMapConfig = new SiteMapConfigurationImpl();

    // Act
    categorySiteMapGenerator2.addSiteMapEntries(smgc,
        new SiteMapBuilder(siteMapConfig, new FileWorkArea(), "https://example.org/example", true));
  }

  /**
   * Test
   * {@link CategorySiteMapGenerator#addCategorySiteMapEntries(Category, int, CategorySiteMapGeneratorConfiguration, SiteMapBuilder)}.
   * <p>
   * Method under test:
   * {@link CategorySiteMapGenerator#addCategorySiteMapEntries(Category, int, CategorySiteMapGeneratorConfiguration, SiteMapBuilder)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testAddCategorySiteMapEntries() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.catalog.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass5492 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.catalog.service.CategorySiteMapGenerator categorySiteMapGenerator;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    CategorySiteMapGenerator categorySiteMapGenerator2 = new CategorySiteMapGenerator(
        new StandardReactiveWebEnvironment());
    CategoryImpl parentCategory = new CategoryImpl();
    CategorySiteMapGeneratorConfigurationImpl categorySMGC = new CategorySiteMapGeneratorConfigurationImpl();
    SiteMapConfigurationImpl siteMapConfig = new SiteMapConfigurationImpl();

    // Act
    categorySiteMapGenerator2.addCategorySiteMapEntries(parentCategory, 2, categorySMGC,
        new SiteMapBuilder(siteMapConfig, new FileWorkArea(), "https://example.org/example", true));
  }

  /**
   * Test
   * {@link CategorySiteMapGenerator#constructSiteMapURLs(CategorySiteMapGeneratorConfiguration, SiteMapBuilder, Category)}.
   * <p>
   * Method under test:
   * {@link CategorySiteMapGenerator#constructSiteMapURLs(CategorySiteMapGeneratorConfiguration, SiteMapBuilder, Category)}
   */
  @Test
  public void testConstructSiteMapURLs() {
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
   * Test
   * {@link CategorySiteMapGenerator#constructSiteMapURLs(CategorySiteMapGeneratorConfiguration, SiteMapBuilder, Category)}.
   * <p>
   * Method under test:
   * {@link CategorySiteMapGenerator#constructSiteMapURLs(CategorySiteMapGeneratorConfiguration, SiteMapBuilder, Category)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testConstructSiteMapURLs2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.catalog.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass5612 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.catalog.service.CategorySiteMapGenerator categorySiteMapGenerator;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    CategorySiteMapGenerator categorySiteMapGenerator2 = new CategorySiteMapGenerator(
        new StandardReactiveWebEnvironment());
    CategorySiteMapGeneratorConfigurationImpl categorySMGC = new CategorySiteMapGeneratorConfigurationImpl();
    SiteMapConfigurationImpl siteMapConfig = new SiteMapConfigurationImpl();
    SiteMapBuilder siteMapBuilder = new SiteMapBuilder(siteMapConfig, new FileWorkArea(), "https://example.org/example",
        true);

    // Act
    categorySiteMapGenerator2.constructSiteMapURLs(categorySMGC, siteMapBuilder, new CategoryImpl());
  }

  /**
   * Test
   * {@link CategorySiteMapGenerator#constructSiteMapURLs(CategorySiteMapGeneratorConfiguration, SiteMapBuilder, Category)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.</li>
   *   <li>Then calls
   * {@link SiteMapGeneratorConfiguration#getSiteMapChangeFreq()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CategorySiteMapGenerator#constructSiteMapURLs(CategorySiteMapGeneratorConfiguration, SiteMapBuilder, Category)}
   */
  @Test
  public void testConstructSiteMapURLs_givenArrayList_thenCallsGetSiteMapChangeFreq() {
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
   * Test
   * {@link CategorySiteMapGenerator#constructSiteMapURLs(CategorySiteMapGeneratorConfiguration, SiteMapBuilder, Category)}.
   * <ul>
   *   <li>Given {@code /}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CategorySiteMapGenerator#constructSiteMapURLs(CategorySiteMapGeneratorConfiguration, SiteMapBuilder, Category)}
   */
  @Test
  public void testConstructSiteMapURLs_givenSlash() {
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
   * Test
   * {@link CategorySiteMapGenerator#constructSiteMapURLs(CategorySiteMapGeneratorConfiguration, SiteMapBuilder, Category)}.
   * <ul>
   *   <li>Given {@code /}.</li>
   *   <li>When {@link CategoryImpl} {@link CategoryImpl#getUrl()} return
   * {@code /}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CategorySiteMapGenerator#constructSiteMapURLs(CategorySiteMapGeneratorConfiguration, SiteMapBuilder, Category)}
   */
  @Test
  public void testConstructSiteMapURLs_givenSlash_whenCategoryImplGetUrlReturnSlash() {
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
   * Test
   * {@link CategorySiteMapGenerator#constructSiteMapURLs(CategorySiteMapGeneratorConfiguration, SiteMapBuilder, Category)}.
   * <ul>
   *   <li>Then calls
   * {@link SiteMapGeneratorConfiguration#getSiteMapChangeFreq()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CategorySiteMapGenerator#constructSiteMapURLs(CategorySiteMapGeneratorConfiguration, SiteMapBuilder, Category)}
   */
  @Test
  public void testConstructSiteMapURLs_thenCallsGetSiteMapChangeFreq() {
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
   * Test
   * {@link CategorySiteMapGenerator#constructSiteMapURLs(CategorySiteMapGeneratorConfiguration, SiteMapBuilder, Category)}.
   * <ul>
   *   <li>When {@link CategorySiteMapGeneratorConfigurationImpl} (default
   * constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CategorySiteMapGenerator#constructSiteMapURLs(CategorySiteMapGeneratorConfiguration, SiteMapBuilder, Category)}
   */
  @Test
  public void testConstructSiteMapURLs_whenCategorySiteMapGeneratorConfigurationImpl() {
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
   * Test
   * {@link CategorySiteMapGenerator#constructImageURLs(SiteMapBuilder, SiteMapURLWrapper, Category)}.
   * <p>
   * Method under test:
   * {@link CategorySiteMapGenerator#constructImageURLs(SiteMapBuilder, SiteMapURLWrapper, Category)}
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
    //   public class DiffblueFakeClass5582 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.catalog.service.CategorySiteMapGenerator categorySiteMapGenerator;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    CategorySiteMapGenerator categorySiteMapGenerator2 = new CategorySiteMapGenerator(
        new StandardReactiveWebEnvironment());
    SiteMapConfigurationImpl siteMapConfig = new SiteMapConfigurationImpl();
    SiteMapBuilder siteMapBuilder = new SiteMapBuilder(siteMapConfig, new FileWorkArea(), "https://example.org/example",
        true);

    SiteMapURLWrapper siteMapUrl = new SiteMapURLWrapper();

    // Act
    categorySiteMapGenerator2.constructImageURLs(siteMapBuilder, siteMapUrl, new CategoryImpl());
  }

  /**
   * Test {@link CategorySiteMapGenerator#getPageCountForCategory(Category)}.
   * <p>
   * Method under test:
   * {@link CategorySiteMapGenerator#getPageCountForCategory(Category)}
   */
  @Test
  public void testGetPageCountForCategory() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategorySiteMapGenerator categorySiteMapGenerator = new CategorySiteMapGenerator(mock(StandardEnvironment.class));

    // Act and Assert
    assertEquals(1, categorySiteMapGenerator.getPageCountForCategory(new CategoryImpl()).intValue());
  }

  /**
   * Test {@link CategorySiteMapGenerator#getPageCountForCategory(Category)}.
   * <p>
   * Method under test:
   * {@link CategorySiteMapGenerator#getPageCountForCategory(Category)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetPageCountForCategory2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.catalog.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass5750 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.catalog.service.CategorySiteMapGenerator categorySiteMapGenerator;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    CategorySiteMapGenerator categorySiteMapGenerator2 = new CategorySiteMapGenerator(
        new StandardReactiveWebEnvironment());

    // Act
    categorySiteMapGenerator2.getPageCountForCategory(new CategoryImpl());
  }

  /**
   * Test {@link CategorySiteMapGenerator#getPageCountForCategory(Category)}.
   * <ul>
   *   <li>Then return intValue is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CategorySiteMapGenerator#getPageCountForCategory(Category)}
   */
  @Test
  public void testGetPageCountForCategory_thenReturnIntValueIsOne() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategorySiteMapGenerator categorySiteMapGenerator = new CategorySiteMapGenerator(
        new StandardReactiveWebEnvironment());

    // Act and Assert
    assertEquals(1, categorySiteMapGenerator.getPageCountForCategory(new CategoryImpl()).intValue());
  }

  /**
   * Test
   * {@link CategorySiteMapGenerator#generateUrl(SiteMapBuilder, Category, int)}.
   * <p>
   * Method under test:
   * {@link CategorySiteMapGenerator#generateUrl(SiteMapBuilder, Category, int)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGenerateUrl() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.catalog.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass5672 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.catalog.service.CategorySiteMapGenerator categorySiteMapGenerator;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    CategorySiteMapGenerator categorySiteMapGenerator2 = new CategorySiteMapGenerator(
        new StandardReactiveWebEnvironment());
    SiteMapConfigurationImpl siteMapConfig = new SiteMapConfigurationImpl();
    SiteMapBuilder siteMapBuilder = new SiteMapBuilder(siteMapConfig, new FileWorkArea(), "https://example.org/example",
        true);

    // Act
    categorySiteMapGenerator2.generateUrl(siteMapBuilder, new CategoryImpl(), 10);
  }

  /**
   * Test
   * {@link CategorySiteMapGenerator#generateUrl(SiteMapBuilder, Category, int)}.
   * <ul>
   *   <li>Given {@code ?}.</li>
   *   <li>When {@link CategoryImpl} {@link CategoryImpl#getUrl()} return
   * {@code ?}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CategorySiteMapGenerator#generateUrl(SiteMapBuilder, Category, int)}
   */
  @Test
  public void testGenerateUrl_givenQuestionMark_whenCategoryImplGetUrlReturnQuestionMark() {
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
   * Test
   * {@link CategorySiteMapGenerator#generateUrl(SiteMapBuilder, Category, int)}.
   * <ul>
   *   <li>Given {@code /}.</li>
   *   <li>Then return {@code https://example.org/example/?Property=10}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CategorySiteMapGenerator#generateUrl(SiteMapBuilder, Category, int)}
   */
  @Test
  public void testGenerateUrl_givenSlash_thenReturnHttpsExampleOrgExampleProperty10() {
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
   * Test
   * {@link CategorySiteMapGenerator#generateUrl(SiteMapBuilder, Category, int)}.
   * <ul>
   *   <li>Given {@code /}.</li>
   *   <li>Then return {@code /?Property=10}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CategorySiteMapGenerator#generateUrl(SiteMapBuilder, Category, int)}
   */
  @Test
  public void testGenerateUrl_givenSlash_thenReturnProperty10() {
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
   * Test
   * {@link CategorySiteMapGenerator#generateUrl(SiteMapBuilder, Category, int)}.
   * <ul>
   *   <li>Then return {@code 42/https://example.org/example?Property=10}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CategorySiteMapGenerator#generateUrl(SiteMapBuilder, Category, int)}
   */
  @Test
  public void testGenerateUrl_thenReturn42HttpsExampleOrgExampleProperty10() {
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
   * Test
   * {@link CategorySiteMapGenerator#generateUrl(SiteMapBuilder, Category, int)}.
   * <ul>
   *   <li>Then return {@code Base Url/https://example.org/example}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CategorySiteMapGenerator#generateUrl(SiteMapBuilder, Category, int)}
   */
  @Test
  public void testGenerateUrl_thenReturnBaseUrlHttpsExampleOrgExample() {
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
   * Test
   * {@link CategorySiteMapGenerator#generateUrl(SiteMapBuilder, Category, int)}.
   * <ul>
   *   <li>Then return {@code /https://example.org/example}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CategorySiteMapGenerator#generateUrl(SiteMapBuilder, Category, int)}
   */
  @Test
  public void testGenerateUrl_thenReturnHttpsExampleOrgExample() {
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
   * Test
   * {@link CategorySiteMapGenerator#generateUrl(SiteMapBuilder, Category, int)}.
   * <ul>
   *   <li>Then return
   * {@code https://example.org/example/https://example.org/example?page=10}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CategorySiteMapGenerator#generateUrl(SiteMapBuilder, Category, int)}
   */
  @Test
  public void testGenerateUrl_thenReturnHttpsExampleOrgExampleHttpsExampleOrgExamplePage10() {
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
   * Test
   * {@link CategorySiteMapGenerator#generateUrl(SiteMapBuilder, Category, int)}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return
   * {@code https://example.org/example/https://example.org/example}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CategorySiteMapGenerator#generateUrl(SiteMapBuilder, Category, int)}
   */
  @Test
  public void testGenerateUrl_whenOne_thenReturnHttpsExampleOrgExampleHttpsExampleOrgExample() {
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
   * Test {@link CategorySiteMapGenerator#generateDate(Category)}.
   * <p>
   * Method under test: {@link CategorySiteMapGenerator#generateDate(Category)}
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
    //   public class DiffblueFakeClass5642 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.catalog.service.CategorySiteMapGenerator categorySiteMapGenerator;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    CategorySiteMapGenerator categorySiteMapGenerator2 = new CategorySiteMapGenerator(
        new StandardReactiveWebEnvironment());

    // Act
    categorySiteMapGenerator2.generateDate(new CategoryImpl());
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

  /**
   * Test {@link CategorySiteMapGenerator#getDefaultPageSize()}.
   * <p>
   * Method under test: {@link CategorySiteMapGenerator#getDefaultPageSize()}
   */
  @Test
  public void testGetDefaultPageSize() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals(40, (new CategorySiteMapGenerator(new StandardReactiveWebEnvironment())).getDefaultPageSize());
  }

  /**
   * Test {@link CategorySiteMapGenerator#getDefaultPageSize()}.
   * <p>
   * Method under test: {@link CategorySiteMapGenerator#getDefaultPageSize()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetDefaultPageSize2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.catalog.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass5726 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.catalog.service.CategorySiteMapGenerator categorySiteMapGenerator;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new CategorySiteMapGenerator(new StandardReactiveWebEnvironment())).getDefaultPageSize();
  }

  /**
   * Test {@link CategorySiteMapGenerator#getDefaultPageSize()}.
   * <ul>
   *   <li>Then calls
   * {@link PropertyResolver#getProperty(String, Class, Object)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategorySiteMapGenerator#getDefaultPageSize()}
   */
  @Test
  public void testGetDefaultPageSize_thenCallsGetProperty() {
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
   * Test {@link CategorySiteMapGenerator#getCategoryPaginationParam()}.
   * <p>
   * Method under test:
   * {@link CategorySiteMapGenerator#getCategoryPaginationParam()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetCategoryPaginationParam() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.catalog.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass5702 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.catalog.service.CategorySiteMapGenerator categorySiteMapGenerator;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new CategorySiteMapGenerator(new StandardReactiveWebEnvironment())).getCategoryPaginationParam();
  }

  /**
   * Test {@link CategorySiteMapGenerator#getCategoryPaginationParam()}.
   * <ul>
   *   <li>Then return {@code page}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CategorySiteMapGenerator#getCategoryPaginationParam()}
   */
  @Test
  public void testGetCategoryPaginationParam_thenReturnPage() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("page",
        (new CategorySiteMapGenerator(new StandardReactiveWebEnvironment())).getCategoryPaginationParam());
  }

  /**
   * Test {@link CategorySiteMapGenerator#getCategoryPaginationParam()}.
   * <ul>
   *   <li>Then return {@code Property}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CategorySiteMapGenerator#getCategoryPaginationParam()}
   */
  @Test
  public void testGetCategoryPaginationParam_thenReturnProperty() {
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
}
