package org.broadleafcommerce.core.catalog.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
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
import org.broadleafcommerce.core.catalog.dao.CategoryDao;
import org.broadleafcommerce.core.catalog.dao.CategoryDaoImpl;
import org.broadleafcommerce.core.catalog.domain.Category;
import org.broadleafcommerce.core.catalog.domain.CategoryImpl;
import org.broadleafcommerce.core.catalog.domain.CategoryMediaXref;
import org.broadleafcommerce.core.catalog.domain.CategoryMediaXrefImpl;
import org.broadleafcommerce.core.catalog.domain.CategoryProductXref;
import org.broadleafcommerce.core.catalog.domain.CategoryProductXrefImpl;
import org.broadleafcommerce.core.catalog.domain.CategorySiteMapGeneratorConfiguration;
import org.broadleafcommerce.core.catalog.domain.CategorySiteMapGeneratorConfigurationImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.web.reactive.context.StandardReactiveWebEnvironment;
import org.springframework.core.env.Environment;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;

@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@RunWith(MockitoJUnitRunner.class)
public class CategorySiteMapGeneratorDiffblueTest {
  @InjectMocks private CategorySiteMapGenerator categorySiteMapGenerator;

  /**
   * Test {@link
   * CategorySiteMapGenerator#canHandleSiteMapConfiguration(SiteMapGeneratorConfiguration)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * CategorySiteMapGenerator#canHandleSiteMapConfiguration(SiteMapGeneratorConfiguration)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CategorySiteMapGenerator.canHandleSiteMapConfiguration(SiteMapGeneratorConfiguration)"
  })
  public void testCanHandleSiteMapConfiguration_givenArrayList() {
    // Arrange
    CustomUrlSiteMapGeneratorConfigurationImpl siteMapGeneratorConfiguration =
        new CustomUrlSiteMapGeneratorConfigurationImpl();
    siteMapGeneratorConfiguration.setCustomURLEntries(new ArrayList<>());
    siteMapGeneratorConfiguration.setDisabled(true);
    siteMapGeneratorConfiguration.setId(1L);
    siteMapGeneratorConfiguration.setSiteMapChangeFreq(new SiteMapChangeFreqType());
    siteMapGeneratorConfiguration.setSiteMapConfiguration(new SiteMapConfigurationImpl());
    siteMapGeneratorConfiguration.setSiteMapGeneratorType(
        new SiteMapGeneratorType("Type", "Friendly Type"));
    siteMapGeneratorConfiguration.setSiteMapPriority(new SiteMapPriorityType());

    // Act and Assert
    assertFalse(
        categorySiteMapGenerator.canHandleSiteMapConfiguration(siteMapGeneratorConfiguration));
  }

  /**
   * Test {@link
   * CategorySiteMapGenerator#canHandleSiteMapConfiguration(SiteMapGeneratorConfiguration)}.
   *
   * <ul>
   *   <li>Given {@link SiteMapGeneratorType#CATEGORY}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link
   * CategorySiteMapGenerator#canHandleSiteMapConfiguration(SiteMapGeneratorConfiguration)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CategorySiteMapGenerator.canHandleSiteMapConfiguration(SiteMapGeneratorConfiguration)"
  })
  public void testCanHandleSiteMapConfiguration_givenCategory_thenReturnTrue() {
    // Arrange
    CategorySiteMapGenerator categorySiteMapGenerator =
        new CategorySiteMapGenerator(new StandardReactiveWebEnvironment());

    SiteMapGeneratorConfiguration siteMapGeneratorConfiguration =
        mock(SiteMapGeneratorConfiguration.class);
    when(siteMapGeneratorConfiguration.getSiteMapGeneratorType())
        .thenReturn(SiteMapGeneratorType.CATEGORY);

    // Act
    boolean actualCanHandleSiteMapConfigurationResult =
        categorySiteMapGenerator.canHandleSiteMapConfiguration(siteMapGeneratorConfiguration);

    // Assert
    verify(siteMapGeneratorConfiguration).getSiteMapGeneratorType();
    assertTrue(actualCanHandleSiteMapConfigurationResult);
  }

  /**
   * Test {@link
   * CategorySiteMapGenerator#canHandleSiteMapConfiguration(SiteMapGeneratorConfiguration)}.
   *
   * <ul>
   *   <li>Given {@link SiteMapGeneratorType#SiteMapGeneratorType()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * CategorySiteMapGenerator#canHandleSiteMapConfiguration(SiteMapGeneratorConfiguration)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CategorySiteMapGenerator.canHandleSiteMapConfiguration(SiteMapGeneratorConfiguration)"
  })
  public void testCanHandleSiteMapConfiguration_givenSiteMapGeneratorType() {
    // Arrange
    CategorySiteMapGenerator categorySiteMapGenerator =
        new CategorySiteMapGenerator(new StandardReactiveWebEnvironment());

    SiteMapGeneratorConfiguration siteMapGeneratorConfiguration =
        mock(SiteMapGeneratorConfiguration.class);
    when(siteMapGeneratorConfiguration.getSiteMapGeneratorType())
        .thenReturn(new SiteMapGeneratorType());

    // Act
    boolean actualCanHandleSiteMapConfigurationResult =
        categorySiteMapGenerator.canHandleSiteMapConfiguration(siteMapGeneratorConfiguration);

    // Assert
    verify(siteMapGeneratorConfiguration).getSiteMapGeneratorType();
    assertFalse(actualCanHandleSiteMapConfigurationResult);
  }

  /**
   * Test {@link
   * CategorySiteMapGenerator#canHandleSiteMapConfiguration(SiteMapGeneratorConfiguration)}.
   *
   * <ul>
   *   <li>When {@link SiteMapGeneratorConfigurationImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link
   * CategorySiteMapGenerator#canHandleSiteMapConfiguration(SiteMapGeneratorConfiguration)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CategorySiteMapGenerator.canHandleSiteMapConfiguration(SiteMapGeneratorConfiguration)"
  })
  public void testCanHandleSiteMapConfiguration_whenSiteMapGeneratorConfigurationImpl() {
    // Arrange
    CategorySiteMapGenerator categorySiteMapGenerator =
        new CategorySiteMapGenerator(new StandardReactiveWebEnvironment());

    // Act and Assert
    assertFalse(
        categorySiteMapGenerator.canHandleSiteMapConfiguration(
            new SiteMapGeneratorConfigurationImpl()));
  }

  /**
   * Test {@link CategorySiteMapGenerator#addSiteMapEntries(SiteMapGeneratorConfiguration,
   * SiteMapBuilder)}.
   *
   * <p>Method under test: {@link
   * CategorySiteMapGenerator#addSiteMapEntries(SiteMapGeneratorConfiguration, SiteMapBuilder)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CategorySiteMapGenerator.addSiteMapEntries(SiteMapGeneratorConfiguration, SiteMapBuilder)"
  })
  public void testAddSiteMapEntries() {
    // Arrange
    CategoryImpl categoryImpl = mock(CategoryImpl.class);
    when(categoryImpl.getActiveProductXrefs()).thenReturn(new ArrayList<>());
    when(categoryImpl.getCategoryMediaXref()).thenReturn(new HashMap<>());
    when(categoryImpl.getUrl()).thenReturn("https://example.org/example");

    ArrayList<Category> categoryList = new ArrayList<>();
    categoryList.add(categoryImpl);

    CategoryDaoImpl categoryDao = mock(CategoryDaoImpl.class);
    when(categoryDao.readActiveSubCategoriesByCategory(Mockito.<Category>any(), anyInt(), anyInt()))
        .thenReturn(categoryList);
    when(categoryDao.readCategoryById(Mockito.<Long>any())).thenReturn(new CategoryImpl());

    CategorySiteMapGenerator categorySiteMapGenerator =
        new CategorySiteMapGenerator(new StandardReactiveWebEnvironment());
    categorySiteMapGenerator.setCategoryDao(categoryDao);

    CategorySiteMapGeneratorConfigurationImpl smgc =
        new CategorySiteMapGeneratorConfigurationImpl();
    smgc.setDisabled(true);
    smgc.setEndingDepth(2);
    smgc.setId(1L);
    smgc.setRootCategory(new CategoryImpl());
    smgc.setSiteMapChangeFreq(new SiteMapChangeFreqType());
    smgc.setSiteMapConfiguration(new SiteMapConfigurationImpl());
    smgc.setSiteMapGeneratorType(new SiteMapGeneratorType());
    smgc.setSiteMapPriority(new SiteMapPriorityType());
    smgc.setStartingDepth(2);

    FileWorkArea fileWorkArea = new FileWorkArea();
    fileWorkArea.setFilePathLocation("/directory/foo.txt");
    SiteMapBuilder siteMapBuilder =
        new SiteMapBuilder(new SiteMapConfigurationImpl(), fileWorkArea, "/", true);

    // Act
    categorySiteMapGenerator.addSiteMapEntries(smgc, siteMapBuilder);

    // Assert
    verify(categoryDao, atLeast(1))
        .readActiveSubCategoriesByCategory(Mockito.<Category>any(), eq(0), eq(0));
    verify(categoryDao).readCategoryById(isNull());
    verify(categoryImpl).getActiveProductXrefs();
    verify(categoryImpl).getCategoryMediaXref();
    verify(categoryImpl, atLeast(1)).getUrl();
  }

  /**
   * Test {@link CategorySiteMapGenerator#addSiteMapEntries(SiteMapGeneratorConfiguration,
   * SiteMapBuilder)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link CategoryImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link
   * CategorySiteMapGenerator#addSiteMapEntries(SiteMapGeneratorConfiguration, SiteMapBuilder)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CategorySiteMapGenerator.addSiteMapEntries(SiteMapGeneratorConfiguration, SiteMapBuilder)"
  })
  public void testAddSiteMapEntries_givenArrayListAddCategoryImpl() {
    // Arrange
    ArrayList<Category> categoryList = new ArrayList<>();
    categoryList.add(new CategoryImpl());

    CategoryDaoImpl categoryDao = mock(CategoryDaoImpl.class);
    when(categoryDao.readActiveSubCategoriesByCategory(Mockito.<Category>any(), anyInt(), anyInt()))
        .thenReturn(categoryList);
    when(categoryDao.readCategoryById(Mockito.<Long>any())).thenReturn(new CategoryImpl());

    CategorySiteMapGenerator categorySiteMapGenerator =
        new CategorySiteMapGenerator(new StandardReactiveWebEnvironment());
    categorySiteMapGenerator.setCategoryDao(categoryDao);

    CategorySiteMapGeneratorConfigurationImpl smgc =
        new CategorySiteMapGeneratorConfigurationImpl();
    smgc.setDisabled(true);
    smgc.setEndingDepth(2);
    smgc.setId(1L);
    smgc.setRootCategory(new CategoryImpl());
    smgc.setSiteMapChangeFreq(new SiteMapChangeFreqType());
    smgc.setSiteMapConfiguration(new SiteMapConfigurationImpl());
    smgc.setSiteMapGeneratorType(new SiteMapGeneratorType());
    smgc.setSiteMapPriority(new SiteMapPriorityType());
    smgc.setStartingDepth(2);

    FileWorkArea fileWorkArea = new FileWorkArea();
    fileWorkArea.setFilePathLocation("/directory/foo.txt");
    SiteMapBuilder siteMapBuilder =
        new SiteMapBuilder(
            new SiteMapConfigurationImpl(), fileWorkArea, "https://example.org/example", true);

    // Act
    categorySiteMapGenerator.addSiteMapEntries(smgc, siteMapBuilder);

    // Assert
    verify(categoryDao).readActiveSubCategoriesByCategory(isA(Category.class), eq(0), eq(0));
    verify(categoryDao).readCategoryById(isNull());
  }

  /**
   * Test {@link CategorySiteMapGenerator#addSiteMapEntries(SiteMapGeneratorConfiguration,
   * SiteMapBuilder)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link CategoryProductXrefImpl} (default
   *       constructor).
   * </ul>
   *
   * <p>Method under test: {@link
   * CategorySiteMapGenerator#addSiteMapEntries(SiteMapGeneratorConfiguration, SiteMapBuilder)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CategorySiteMapGenerator.addSiteMapEntries(SiteMapGeneratorConfiguration, SiteMapBuilder)"
  })
  public void testAddSiteMapEntries_givenArrayListAddCategoryProductXrefImpl() {
    // Arrange
    ArrayList<CategoryProductXref> categoryProductXrefList = new ArrayList<>();
    categoryProductXrefList.add(new CategoryProductXrefImpl());

    CategoryImpl categoryImpl = mock(CategoryImpl.class);
    when(categoryImpl.getActiveProductXrefs()).thenReturn(categoryProductXrefList);
    when(categoryImpl.getCategoryMediaXref()).thenReturn(new HashMap<>());
    when(categoryImpl.getUrl()).thenReturn("https://example.org/example");

    ArrayList<Category> categoryList = new ArrayList<>();
    categoryList.add(categoryImpl);

    CategoryDaoImpl categoryDao = mock(CategoryDaoImpl.class);
    when(categoryDao.readActiveSubCategoriesByCategory(Mockito.<Category>any(), anyInt(), anyInt()))
        .thenReturn(categoryList);
    when(categoryDao.readCategoryById(Mockito.<Long>any())).thenReturn(new CategoryImpl());

    CategorySiteMapGenerator categorySiteMapGenerator =
        new CategorySiteMapGenerator(new StandardReactiveWebEnvironment());
    categorySiteMapGenerator.setCategoryDao(categoryDao);

    CategorySiteMapGeneratorConfigurationImpl smgc =
        new CategorySiteMapGeneratorConfigurationImpl();
    smgc.setDisabled(true);
    smgc.setEndingDepth(2);
    smgc.setId(1L);
    smgc.setRootCategory(new CategoryImpl());
    smgc.setSiteMapChangeFreq(new SiteMapChangeFreqType());
    smgc.setSiteMapConfiguration(new SiteMapConfigurationImpl());
    smgc.setSiteMapGeneratorType(new SiteMapGeneratorType());
    smgc.setSiteMapPriority(new SiteMapPriorityType());
    smgc.setStartingDepth(2);

    FileWorkArea fileWorkArea = new FileWorkArea();
    fileWorkArea.setFilePathLocation("/directory/foo.txt");
    SiteMapBuilder siteMapBuilder =
        new SiteMapBuilder(
            new SiteMapConfigurationImpl(), fileWorkArea, "https://example.org/example", true);

    // Act
    categorySiteMapGenerator.addSiteMapEntries(smgc, siteMapBuilder);

    // Assert
    verify(categoryDao, atLeast(1))
        .readActiveSubCategoriesByCategory(Mockito.<Category>any(), eq(0), eq(0));
    verify(categoryDao).readCategoryById(isNull());
    verify(categoryImpl).getActiveProductXrefs();
    verify(categoryImpl).getCategoryMediaXref();
    verify(categoryImpl, atLeast(1)).getUrl();
  }

  /**
   * Test {@link CategorySiteMapGenerator#addSiteMapEntries(SiteMapGeneratorConfiguration,
   * SiteMapBuilder)}.
   *
   * <ul>
   *   <li>Given {@link CategoryImpl} {@link CategoryImpl#getUrl()} return empty string.
   *   <li>Then calls {@link CategoryImpl#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * CategorySiteMapGenerator#addSiteMapEntries(SiteMapGeneratorConfiguration, SiteMapBuilder)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CategorySiteMapGenerator.addSiteMapEntries(SiteMapGeneratorConfiguration, SiteMapBuilder)"
  })
  public void testAddSiteMapEntries_givenCategoryImplGetUrlReturnEmptyString_thenCallsGetId() {
    // Arrange
    CategoryImpl categoryImpl = mock(CategoryImpl.class);
    when(categoryImpl.getId()).thenReturn(1L);
    when(categoryImpl.getUrl()).thenReturn("");

    ArrayList<Category> categoryList = new ArrayList<>();
    categoryList.add(categoryImpl);

    CategoryDaoImpl categoryDao = mock(CategoryDaoImpl.class);
    when(categoryDao.readActiveSubCategoriesByCategory(Mockito.<Category>any(), anyInt(), anyInt()))
        .thenReturn(categoryList);
    when(categoryDao.readCategoryById(Mockito.<Long>any())).thenReturn(new CategoryImpl());

    CategorySiteMapGenerator categorySiteMapGenerator =
        new CategorySiteMapGenerator(new StandardReactiveWebEnvironment());
    categorySiteMapGenerator.setCategoryDao(categoryDao);

    CategorySiteMapGeneratorConfigurationImpl smgc =
        new CategorySiteMapGeneratorConfigurationImpl();
    smgc.setDisabled(true);
    smgc.setEndingDepth(2);
    smgc.setId(1L);
    smgc.setRootCategory(new CategoryImpl());
    smgc.setSiteMapChangeFreq(new SiteMapChangeFreqType());
    smgc.setSiteMapConfiguration(new SiteMapConfigurationImpl());
    smgc.setSiteMapGeneratorType(new SiteMapGeneratorType());
    smgc.setSiteMapPriority(new SiteMapPriorityType());
    smgc.setStartingDepth(2);

    FileWorkArea fileWorkArea = new FileWorkArea();
    fileWorkArea.setFilePathLocation("/directory/foo.txt");
    SiteMapBuilder siteMapBuilder =
        new SiteMapBuilder(
            new SiteMapConfigurationImpl(), fileWorkArea, "https://example.org/example", true);

    // Act
    categorySiteMapGenerator.addSiteMapEntries(smgc, siteMapBuilder);

    // Assert
    verify(categoryDao).readActiveSubCategoriesByCategory(isA(Category.class), eq(0), eq(0));
    verify(categoryDao).readCategoryById(isNull());
    verify(categoryImpl).getId();
    verify(categoryImpl).getUrl();
  }

  /**
   * Test {@link CategorySiteMapGenerator#addSiteMapEntries(SiteMapGeneratorConfiguration,
   * SiteMapBuilder)}.
   *
   * <ul>
   *   <li>Given {@link CategoryImpl} {@link CategoryImpl#getUrl()} return {@code /}.
   * </ul>
   *
   * <p>Method under test: {@link
   * CategorySiteMapGenerator#addSiteMapEntries(SiteMapGeneratorConfiguration, SiteMapBuilder)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CategorySiteMapGenerator.addSiteMapEntries(SiteMapGeneratorConfiguration, SiteMapBuilder)"
  })
  public void testAddSiteMapEntries_givenCategoryImplGetUrlReturnSlash() {
    // Arrange
    CategoryImpl categoryImpl = mock(CategoryImpl.class);
    when(categoryImpl.getActiveProductXrefs()).thenReturn(new ArrayList<>());
    when(categoryImpl.getCategoryMediaXref()).thenReturn(new HashMap<>());
    when(categoryImpl.getUrl()).thenReturn("/");

    ArrayList<Category> categoryList = new ArrayList<>();
    categoryList.add(categoryImpl);

    CategoryDaoImpl categoryDao = mock(CategoryDaoImpl.class);
    when(categoryDao.readActiveSubCategoriesByCategory(Mockito.<Category>any(), anyInt(), anyInt()))
        .thenReturn(categoryList);
    when(categoryDao.readCategoryById(Mockito.<Long>any())).thenReturn(new CategoryImpl());

    CategorySiteMapGenerator categorySiteMapGenerator =
        new CategorySiteMapGenerator(new StandardReactiveWebEnvironment());
    categorySiteMapGenerator.setCategoryDao(categoryDao);

    CategorySiteMapGeneratorConfigurationImpl smgc =
        new CategorySiteMapGeneratorConfigurationImpl();
    smgc.setDisabled(true);
    smgc.setEndingDepth(2);
    smgc.setId(1L);
    smgc.setRootCategory(new CategoryImpl());
    smgc.setSiteMapChangeFreq(new SiteMapChangeFreqType());
    smgc.setSiteMapConfiguration(new SiteMapConfigurationImpl());
    smgc.setSiteMapGeneratorType(new SiteMapGeneratorType());
    smgc.setSiteMapPriority(new SiteMapPriorityType());
    smgc.setStartingDepth(2);

    FileWorkArea fileWorkArea = new FileWorkArea();
    fileWorkArea.setFilePathLocation("/directory/foo.txt");
    SiteMapBuilder siteMapBuilder =
        new SiteMapBuilder(
            new SiteMapConfigurationImpl(), fileWorkArea, "https://example.org/example", true);

    // Act
    categorySiteMapGenerator.addSiteMapEntries(smgc, siteMapBuilder);

    // Assert
    verify(categoryDao, atLeast(1))
        .readActiveSubCategoriesByCategory(Mockito.<Category>any(), eq(0), eq(0));
    verify(categoryDao).readCategoryById(isNull());
    verify(categoryImpl).getActiveProductXrefs();
    verify(categoryImpl).getCategoryMediaXref();
    verify(categoryImpl, atLeast(1)).getUrl();
  }

  /**
   * Test {@link CategorySiteMapGenerator#addSiteMapEntries(SiteMapGeneratorConfiguration,
   * SiteMapBuilder)}.
   *
   * <ul>
   *   <li>Given minus one.
   * </ul>
   *
   * <p>Method under test: {@link
   * CategorySiteMapGenerator#addSiteMapEntries(SiteMapGeneratorConfiguration, SiteMapBuilder)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CategorySiteMapGenerator.addSiteMapEntries(SiteMapGeneratorConfiguration, SiteMapBuilder)"
  })
  public void testAddSiteMapEntries_givenMinusOne() {
    // Arrange
    CategoryDaoImpl categoryDao = mock(CategoryDaoImpl.class);
    when(categoryDao.readCategoryById(Mockito.<Long>any())).thenReturn(new CategoryImpl());

    CategorySiteMapGenerator categorySiteMapGenerator =
        new CategorySiteMapGenerator(new StandardReactiveWebEnvironment());
    categorySiteMapGenerator.setCategoryDao(categoryDao);

    CategorySiteMapGeneratorConfigurationImpl smgc =
        new CategorySiteMapGeneratorConfigurationImpl();
    smgc.setDisabled(true);
    smgc.setEndingDepth(-1);
    smgc.setId(1L);
    smgc.setRootCategory(new CategoryImpl());
    smgc.setSiteMapChangeFreq(new SiteMapChangeFreqType());
    smgc.setSiteMapConfiguration(new SiteMapConfigurationImpl());
    smgc.setSiteMapGeneratorType(new SiteMapGeneratorType());
    smgc.setSiteMapPriority(new SiteMapPriorityType());
    smgc.setStartingDepth(2);

    FileWorkArea fileWorkArea = new FileWorkArea();
    fileWorkArea.setFilePathLocation("/directory/foo.txt");
    SiteMapBuilder siteMapBuilder =
        new SiteMapBuilder(
            new SiteMapConfigurationImpl(), fileWorkArea, "https://example.org/example", true);

    // Act
    categorySiteMapGenerator.addSiteMapEntries(smgc, siteMapBuilder);

    // Assert
    verify(categoryDao).readCategoryById(isNull());
  }

  /**
   * Test {@link CategorySiteMapGenerator#addSiteMapEntries(SiteMapGeneratorConfiguration,
   * SiteMapBuilder)}.
   *
   * <ul>
   *   <li>Given {@link SiteMapChangeFreqType#SiteMapChangeFreqType(String, String)} with {@code
   *       Type} and {@code Friendly Type}.
   * </ul>
   *
   * <p>Method under test: {@link
   * CategorySiteMapGenerator#addSiteMapEntries(SiteMapGeneratorConfiguration, SiteMapBuilder)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CategorySiteMapGenerator.addSiteMapEntries(SiteMapGeneratorConfiguration, SiteMapBuilder)"
  })
  public void testAddSiteMapEntries_givenSiteMapChangeFreqTypeWithTypeAndFriendlyType() {
    // Arrange
    CategoryImpl categoryImpl = mock(CategoryImpl.class);
    when(categoryImpl.getActiveProductXrefs()).thenReturn(new ArrayList<>());
    when(categoryImpl.getCategoryMediaXref()).thenReturn(new HashMap<>());
    when(categoryImpl.getUrl()).thenReturn("https://example.org/example");

    ArrayList<Category> categoryList = new ArrayList<>();
    categoryList.add(categoryImpl);

    CategoryDaoImpl categoryDao = mock(CategoryDaoImpl.class);
    when(categoryDao.readActiveSubCategoriesByCategory(Mockito.<Category>any(), anyInt(), anyInt()))
        .thenReturn(categoryList);
    when(categoryDao.readCategoryById(Mockito.<Long>any())).thenReturn(new CategoryImpl());

    CategorySiteMapGenerator categorySiteMapGenerator =
        new CategorySiteMapGenerator(new StandardReactiveWebEnvironment());
    categorySiteMapGenerator.setCategoryDao(categoryDao);

    CategorySiteMapGeneratorConfigurationImpl smgc =
        new CategorySiteMapGeneratorConfigurationImpl();
    smgc.setDisabled(true);
    smgc.setEndingDepth(2);
    smgc.setId(1L);
    smgc.setRootCategory(new CategoryImpl());
    smgc.setSiteMapChangeFreq(new SiteMapChangeFreqType("Type", "Friendly Type"));
    smgc.setSiteMapConfiguration(new SiteMapConfigurationImpl());
    smgc.setSiteMapGeneratorType(new SiteMapGeneratorType());
    smgc.setSiteMapPriority(new SiteMapPriorityType());
    smgc.setStartingDepth(2);

    FileWorkArea fileWorkArea = new FileWorkArea();
    fileWorkArea.setFilePathLocation("/directory/foo.txt");
    SiteMapBuilder siteMapBuilder =
        new SiteMapBuilder(
            new SiteMapConfigurationImpl(), fileWorkArea, "https://example.org/example", true);

    // Act
    categorySiteMapGenerator.addSiteMapEntries(smgc, siteMapBuilder);

    // Assert
    verify(categoryDao, atLeast(1))
        .readActiveSubCategoriesByCategory(Mockito.<Category>any(), eq(0), eq(0));
    verify(categoryDao).readCategoryById(isNull());
    verify(categoryImpl).getActiveProductXrefs();
    verify(categoryImpl).getCategoryMediaXref();
    verify(categoryImpl, atLeast(1)).getUrl();
  }

  /**
   * Test {@link CategorySiteMapGenerator#addSiteMapEntries(SiteMapGeneratorConfiguration,
   * SiteMapBuilder)}.
   *
   * <ul>
   *   <li>Given {@link SiteMapPriorityType#SiteMapPriorityType(String, String)} with {@code Type}
   *       and {@code Friendly Type}.
   * </ul>
   *
   * <p>Method under test: {@link
   * CategorySiteMapGenerator#addSiteMapEntries(SiteMapGeneratorConfiguration, SiteMapBuilder)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CategorySiteMapGenerator.addSiteMapEntries(SiteMapGeneratorConfiguration, SiteMapBuilder)"
  })
  public void testAddSiteMapEntries_givenSiteMapPriorityTypeWithTypeAndFriendlyType() {
    // Arrange
    CategoryImpl categoryImpl = mock(CategoryImpl.class);
    when(categoryImpl.getActiveProductXrefs()).thenReturn(new ArrayList<>());
    when(categoryImpl.getCategoryMediaXref()).thenReturn(new HashMap<>());
    when(categoryImpl.getUrl()).thenReturn("https://example.org/example");

    ArrayList<Category> categoryList = new ArrayList<>();
    categoryList.add(categoryImpl);

    CategoryDaoImpl categoryDao = mock(CategoryDaoImpl.class);
    when(categoryDao.readActiveSubCategoriesByCategory(Mockito.<Category>any(), anyInt(), anyInt()))
        .thenReturn(categoryList);
    when(categoryDao.readCategoryById(Mockito.<Long>any())).thenReturn(new CategoryImpl());

    CategorySiteMapGenerator categorySiteMapGenerator =
        new CategorySiteMapGenerator(new StandardReactiveWebEnvironment());
    categorySiteMapGenerator.setCategoryDao(categoryDao);

    CategorySiteMapGeneratorConfigurationImpl smgc =
        new CategorySiteMapGeneratorConfigurationImpl();
    smgc.setDisabled(true);
    smgc.setEndingDepth(2);
    smgc.setId(1L);
    smgc.setRootCategory(new CategoryImpl());
    smgc.setSiteMapChangeFreq(new SiteMapChangeFreqType());
    smgc.setSiteMapConfiguration(new SiteMapConfigurationImpl());
    smgc.setSiteMapGeneratorType(new SiteMapGeneratorType());
    smgc.setSiteMapPriority(new SiteMapPriorityType("Type", "Friendly Type"));
    smgc.setStartingDepth(2);

    FileWorkArea fileWorkArea = new FileWorkArea();
    fileWorkArea.setFilePathLocation("/directory/foo.txt");
    SiteMapBuilder siteMapBuilder =
        new SiteMapBuilder(
            new SiteMapConfigurationImpl(), fileWorkArea, "https://example.org/example", true);

    // Act
    categorySiteMapGenerator.addSiteMapEntries(smgc, siteMapBuilder);

    // Assert
    verify(categoryDao, atLeast(1))
        .readActiveSubCategoriesByCategory(Mockito.<Category>any(), eq(0), eq(0));
    verify(categoryDao).readCategoryById(isNull());
    verify(categoryImpl).getActiveProductXrefs();
    verify(categoryImpl).getCategoryMediaXref();
    verify(categoryImpl, atLeast(1)).getUrl();
  }

  /**
   * Test {@link CategorySiteMapGenerator#addSiteMapEntries(SiteMapGeneratorConfiguration,
   * SiteMapBuilder)}.
   *
   * <ul>
   *   <li>Then calls {@link CategoryImpl#getActiveProductXrefs()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * CategorySiteMapGenerator#addSiteMapEntries(SiteMapGeneratorConfiguration, SiteMapBuilder)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CategorySiteMapGenerator.addSiteMapEntries(SiteMapGeneratorConfiguration, SiteMapBuilder)"
  })
  public void testAddSiteMapEntries_thenCallsGetActiveProductXrefs() {
    // Arrange
    CategoryImpl categoryImpl = mock(CategoryImpl.class);
    when(categoryImpl.getActiveProductXrefs()).thenReturn(new ArrayList<>());
    when(categoryImpl.getCategoryMediaXref()).thenReturn(new HashMap<>());
    when(categoryImpl.getUrl()).thenReturn("https://example.org/example");

    ArrayList<Category> categoryList = new ArrayList<>();
    categoryList.add(categoryImpl);

    CategoryDaoImpl categoryDao = mock(CategoryDaoImpl.class);
    when(categoryDao.readActiveSubCategoriesByCategory(Mockito.<Category>any(), anyInt(), anyInt()))
        .thenReturn(categoryList);
    when(categoryDao.readCategoryById(Mockito.<Long>any())).thenReturn(new CategoryImpl());

    CategorySiteMapGenerator categorySiteMapGenerator =
        new CategorySiteMapGenerator(new StandardReactiveWebEnvironment());
    categorySiteMapGenerator.setCategoryDao(categoryDao);

    CategorySiteMapGeneratorConfigurationImpl smgc =
        new CategorySiteMapGeneratorConfigurationImpl();
    smgc.setDisabled(true);
    smgc.setEndingDepth(2);
    smgc.setId(1L);
    smgc.setRootCategory(new CategoryImpl());
    smgc.setSiteMapChangeFreq(new SiteMapChangeFreqType());
    smgc.setSiteMapConfiguration(new SiteMapConfigurationImpl());
    smgc.setSiteMapGeneratorType(new SiteMapGeneratorType());
    smgc.setSiteMapPriority(new SiteMapPriorityType());
    smgc.setStartingDepth(2);

    FileWorkArea fileWorkArea = new FileWorkArea();
    fileWorkArea.setFilePathLocation("/directory/foo.txt");
    SiteMapBuilder siteMapBuilder =
        new SiteMapBuilder(
            new SiteMapConfigurationImpl(), fileWorkArea, "https://example.org/example", true);

    // Act
    categorySiteMapGenerator.addSiteMapEntries(smgc, siteMapBuilder);

    // Assert
    verify(categoryDao, atLeast(1))
        .readActiveSubCategoriesByCategory(Mockito.<Category>any(), eq(0), eq(0));
    verify(categoryDao).readCategoryById(isNull());
    verify(categoryImpl).getActiveProductXrefs();
    verify(categoryImpl).getCategoryMediaXref();
    verify(categoryImpl, atLeast(1)).getUrl();
  }

  /**
   * Test {@link
   * CategorySiteMapGenerator#constructSiteMapURLs(CategorySiteMapGeneratorConfiguration,
   * SiteMapBuilder, Category)}.
   *
   * <p>Method under test: {@link
   * CategorySiteMapGenerator#constructSiteMapURLs(CategorySiteMapGeneratorConfiguration,
   * SiteMapBuilder, Category)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CategorySiteMapGenerator.constructSiteMapURLs(CategorySiteMapGeneratorConfiguration, SiteMapBuilder, Category)"
  })
  public void testConstructSiteMapURLs() {
    // Arrange
    CategorySiteMapGenerator categorySiteMapGenerator =
        new CategorySiteMapGenerator(new StandardReactiveWebEnvironment());

    CategorySiteMapGeneratorConfiguration categorySMGC =
        mock(CategorySiteMapGeneratorConfiguration.class);
    when(categorySMGC.getSiteMapChangeFreq()).thenReturn(new SiteMapChangeFreqType());
    when(categorySMGC.getSiteMapPriority()).thenReturn(new SiteMapPriorityType());

    FileWorkArea fileWorkArea = new FileWorkArea();
    fileWorkArea.setFilePathLocation("/directory/foo.txt");
    SiteMapBuilder siteMapBuilder =
        new SiteMapBuilder(new SiteMapConfigurationImpl(), fileWorkArea, "/", true);

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
   * Test {@link
   * CategorySiteMapGenerator#constructSiteMapURLs(CategorySiteMapGeneratorConfiguration,
   * SiteMapBuilder, Category)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link CategoryProductXrefImpl} (default
   *       constructor).
   * </ul>
   *
   * <p>Method under test: {@link
   * CategorySiteMapGenerator#constructSiteMapURLs(CategorySiteMapGeneratorConfiguration,
   * SiteMapBuilder, Category)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CategorySiteMapGenerator.constructSiteMapURLs(CategorySiteMapGeneratorConfiguration, SiteMapBuilder, Category)"
  })
  public void testConstructSiteMapURLs_givenArrayListAddCategoryProductXrefImpl() {
    // Arrange
    CategorySiteMapGenerator categorySiteMapGenerator =
        new CategorySiteMapGenerator(new StandardReactiveWebEnvironment());

    CategorySiteMapGeneratorConfiguration categorySMGC =
        mock(CategorySiteMapGeneratorConfiguration.class);
    when(categorySMGC.getSiteMapChangeFreq()).thenReturn(new SiteMapChangeFreqType());
    when(categorySMGC.getSiteMapPriority()).thenReturn(new SiteMapPriorityType());

    FileWorkArea fileWorkArea = new FileWorkArea();
    fileWorkArea.setFilePathLocation("/directory/foo.txt");
    SiteMapBuilder siteMapBuilder =
        new SiteMapBuilder(
            new SiteMapConfigurationImpl(), fileWorkArea, "https://example.org/example", true);

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
   * Test {@link
   * CategorySiteMapGenerator#constructSiteMapURLs(CategorySiteMapGeneratorConfiguration,
   * SiteMapBuilder, Category)}.
   *
   * <ul>
   *   <li>Given {@link CategoryMediaXrefImpl#CategoryMediaXrefImpl()} Url is {@code
   *       https://example.org/example}.
   * </ul>
   *
   * <p>Method under test: {@link
   * CategorySiteMapGenerator#constructSiteMapURLs(CategorySiteMapGeneratorConfiguration,
   * SiteMapBuilder, Category)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CategorySiteMapGenerator.constructSiteMapURLs(CategorySiteMapGeneratorConfiguration, SiteMapBuilder, Category)"
  })
  public void testConstructSiteMapURLs_givenCategoryMediaXrefImplUrlIsHttpsExampleOrgExample() {
    // Arrange
    CategorySiteMapGenerator categorySiteMapGenerator =
        new CategorySiteMapGenerator(new StandardReactiveWebEnvironment());

    CategorySiteMapGeneratorConfiguration categorySMGC =
        mock(CategorySiteMapGeneratorConfiguration.class);
    when(categorySMGC.getSiteMapChangeFreq()).thenReturn(new SiteMapChangeFreqType());
    when(categorySMGC.getSiteMapPriority()).thenReturn(new SiteMapPriorityType());

    FileWorkArea fileWorkArea = new FileWorkArea();
    fileWorkArea.setFilePathLocation("/directory/foo.txt");
    SiteMapBuilder siteMapBuilder =
        new SiteMapBuilder(
            new SiteMapConfigurationImpl(), fileWorkArea, "https://example.org/example", true);

    CategoryMediaXrefImpl categoryMediaXrefImpl = new CategoryMediaXrefImpl();
    categoryMediaXrefImpl.setUrl("https://example.org/example");

    HashMap<String, CategoryMediaXref> stringCategoryMediaXrefMap = new HashMap<>();
    stringCategoryMediaXrefMap.put("/", categoryMediaXrefImpl);

    CategoryImpl category = mock(CategoryImpl.class);
    when(category.getCategoryMediaXref()).thenReturn(stringCategoryMediaXrefMap);
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
   * Test {@link
   * CategorySiteMapGenerator#constructSiteMapURLs(CategorySiteMapGeneratorConfiguration,
   * SiteMapBuilder, Category)}.
   *
   * <ul>
   *   <li>Given {@code /}.
   * </ul>
   *
   * <p>Method under test: {@link
   * CategorySiteMapGenerator#constructSiteMapURLs(CategorySiteMapGeneratorConfiguration,
   * SiteMapBuilder, Category)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CategorySiteMapGenerator.constructSiteMapURLs(CategorySiteMapGeneratorConfiguration, SiteMapBuilder, Category)"
  })
  public void testConstructSiteMapURLs_givenSlash() {
    // Arrange
    CategorySiteMapGenerator categorySiteMapGenerator =
        new CategorySiteMapGenerator(new StandardReactiveWebEnvironment());

    CategorySiteMapGeneratorConfiguration categorySMGC =
        mock(CategorySiteMapGeneratorConfiguration.class);
    when(categorySMGC.getSiteMapChangeFreq()).thenReturn(new SiteMapChangeFreqType());
    when(categorySMGC.getSiteMapPriority()).thenReturn(new SiteMapPriorityType());

    FileWorkArea fileWorkArea = new FileWorkArea();
    fileWorkArea.setFilePathLocation("/directory/foo.txt");
    SiteMapBuilder siteMapBuilder =
        new SiteMapBuilder(new SiteMapConfigurationImpl(), fileWorkArea, "/", true);

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
   * Test {@link
   * CategorySiteMapGenerator#constructSiteMapURLs(CategorySiteMapGeneratorConfiguration,
   * SiteMapBuilder, Category)}.
   *
   * <ul>
   *   <li>Given {@code /}.
   *   <li>When {@link CategoryImpl} {@link CategoryImpl#getUrl()} return {@code /}.
   * </ul>
   *
   * <p>Method under test: {@link
   * CategorySiteMapGenerator#constructSiteMapURLs(CategorySiteMapGeneratorConfiguration,
   * SiteMapBuilder, Category)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CategorySiteMapGenerator.constructSiteMapURLs(CategorySiteMapGeneratorConfiguration, SiteMapBuilder, Category)"
  })
  public void testConstructSiteMapURLs_givenSlash_whenCategoryImplGetUrlReturnSlash() {
    // Arrange
    CategorySiteMapGenerator categorySiteMapGenerator =
        new CategorySiteMapGenerator(new StandardReactiveWebEnvironment());

    CategorySiteMapGeneratorConfiguration categorySMGC =
        mock(CategorySiteMapGeneratorConfiguration.class);
    when(categorySMGC.getSiteMapChangeFreq()).thenReturn(new SiteMapChangeFreqType());
    when(categorySMGC.getSiteMapPriority()).thenReturn(new SiteMapPriorityType());

    FileWorkArea fileWorkArea = new FileWorkArea();
    fileWorkArea.setFilePathLocation("/directory/foo.txt");
    SiteMapBuilder siteMapBuilder =
        new SiteMapBuilder(
            new SiteMapConfigurationImpl(), fileWorkArea, "https://example.org/example", true);

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
   * Test {@link
   * CategorySiteMapGenerator#constructSiteMapURLs(CategorySiteMapGeneratorConfiguration,
   * SiteMapBuilder, Category)}.
   *
   * <ul>
   *   <li>Then calls {@link CategorySiteMapGeneratorConfiguration#getSiteMapChangeFreq()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * CategorySiteMapGenerator#constructSiteMapURLs(CategorySiteMapGeneratorConfiguration,
   * SiteMapBuilder, Category)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CategorySiteMapGenerator.constructSiteMapURLs(CategorySiteMapGeneratorConfiguration, SiteMapBuilder, Category)"
  })
  public void testConstructSiteMapURLs_thenCallsGetSiteMapChangeFreq() {
    // Arrange
    CategorySiteMapGenerator categorySiteMapGenerator =
        new CategorySiteMapGenerator(new StandardReactiveWebEnvironment());

    CategorySiteMapGeneratorConfiguration categorySMGC =
        mock(CategorySiteMapGeneratorConfiguration.class);
    when(categorySMGC.getSiteMapChangeFreq()).thenReturn(new SiteMapChangeFreqType());
    when(categorySMGC.getSiteMapPriority()).thenReturn(new SiteMapPriorityType());

    FileWorkArea fileWorkArea = new FileWorkArea();
    fileWorkArea.setFilePathLocation("/directory/foo.txt");
    SiteMapBuilder siteMapBuilder =
        new SiteMapBuilder(
            new SiteMapConfigurationImpl(), fileWorkArea, "https://example.org/example", true);

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
   * Test {@link
   * CategorySiteMapGenerator#constructSiteMapURLs(CategorySiteMapGeneratorConfiguration,
   * SiteMapBuilder, Category)}.
   *
   * <ul>
   *   <li>When {@link CategorySiteMapGeneratorConfigurationImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link
   * CategorySiteMapGenerator#constructSiteMapURLs(CategorySiteMapGeneratorConfiguration,
   * SiteMapBuilder, Category)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CategorySiteMapGenerator.constructSiteMapURLs(CategorySiteMapGeneratorConfiguration, SiteMapBuilder, Category)"
  })
  public void testConstructSiteMapURLs_whenCategorySiteMapGeneratorConfigurationImpl() {
    // Arrange
    CategorySiteMapGenerator categorySiteMapGenerator =
        new CategorySiteMapGenerator(new StandardReactiveWebEnvironment());
    CategorySiteMapGeneratorConfigurationImpl categorySMGC =
        new CategorySiteMapGeneratorConfigurationImpl();

    FileWorkArea fileWorkArea = new FileWorkArea();
    fileWorkArea.setFilePathLocation("/directory/foo.txt");
    SiteMapBuilder siteMapBuilder =
        new SiteMapBuilder(
            new SiteMapConfigurationImpl(), fileWorkArea, "https://example.org/example", true);

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
   * Test {@link CategorySiteMapGenerator#constructImageURLs(SiteMapBuilder, SiteMapURLWrapper,
   * Category)}.
   *
   * <p>Method under test: {@link CategorySiteMapGenerator#constructImageURLs(SiteMapBuilder,
   * SiteMapURLWrapper, Category)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CategorySiteMapGenerator.constructImageURLs(SiteMapBuilder, SiteMapURLWrapper, Category)"
  })
  public void testConstructImageURLs() {
    // Arrange
    CategorySiteMapGenerator categorySiteMapGenerator =
        new CategorySiteMapGenerator(new StandardReactiveWebEnvironment());

    FileWorkArea fileWorkArea = new FileWorkArea();
    fileWorkArea.setFilePathLocation("/directory/foo.txt");
    SiteMapBuilder siteMapBuilder =
        new SiteMapBuilder(
            new SiteMapConfigurationImpl(), fileWorkArea, "https://example.org/example", true);
    SiteMapURLWrapper siteMapUrl = new SiteMapURLWrapper();

    MediaDto mediaDto = new MediaDto();
    mediaDto.setUrl("/");

    CategoryMediaXref categoryMediaXref = mock(CategoryMediaXref.class);
    when(categoryMediaXref.getMedia()).thenReturn(mediaDto);

    HashMap<String, CategoryMediaXref> categoryMediaXref2 = new HashMap<>();
    categoryMediaXref2.put("foo", categoryMediaXref);

    CategoryImpl category = new CategoryImpl();
    category.setCategoryMediaXref(categoryMediaXref2);

    // Act
    categorySiteMapGenerator.constructImageURLs(siteMapBuilder, siteMapUrl, category);

    // Assert
    verify(categoryMediaXref).getMedia();
    List<SiteMapImageWrapper> siteMapImageWrappers = siteMapUrl.getSiteMapImageWrappers();
    assertEquals(1, siteMapImageWrappers.size());
    assertEquals("https://example.org/example/", siteMapImageWrappers.get(0).getLoc());
  }

  /**
   * Test {@link CategorySiteMapGenerator#constructImageURLs(SiteMapBuilder, SiteMapURLWrapper,
   * Category)}.
   *
   * <p>Method under test: {@link CategorySiteMapGenerator#constructImageURLs(SiteMapBuilder,
   * SiteMapURLWrapper, Category)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CategorySiteMapGenerator.constructImageURLs(SiteMapBuilder, SiteMapURLWrapper, Category)"
  })
  public void testConstructImageURLs2() {
    // Arrange
    CategorySiteMapGenerator categorySiteMapGenerator =
        new CategorySiteMapGenerator(new StandardReactiveWebEnvironment());

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

    CategoryMediaXref categoryMediaXref = mock(CategoryMediaXref.class);
    when(categoryMediaXref.getMedia()).thenReturn(mediaDto);

    HashMap<String, CategoryMediaXref> categoryMediaXref2 = new HashMap<>();
    categoryMediaXref2.put("foo", categoryMediaXref);

    CategoryImpl category = new CategoryImpl();
    category.setCategoryMediaXref(categoryMediaXref2);

    // Act
    categorySiteMapGenerator.constructImageURLs(siteMapBuilder, siteMapUrl, category);

    // Assert
    verify(mediaDto).getUrl();
    verify(mediaDto).setUrl("/");
    verify(categoryMediaXref).getMedia();
    List<SiteMapImageWrapper> siteMapImageWrappers = siteMapUrl.getSiteMapImageWrappers();
    assertEquals(1, siteMapImageWrappers.size());
    assertEquals(
        "https://example.org/example/https://example.org/example",
        siteMapImageWrappers.get(0).getLoc());
  }

  /**
   * Test {@link CategorySiteMapGenerator#constructImageURLs(SiteMapBuilder, SiteMapURLWrapper,
   * Category)}.
   *
   * <p>Method under test: {@link CategorySiteMapGenerator#constructImageURLs(SiteMapBuilder,
   * SiteMapURLWrapper, Category)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CategorySiteMapGenerator.constructImageURLs(SiteMapBuilder, SiteMapURLWrapper, Category)"
  })
  public void testConstructImageURLs3() {
    // Arrange
    CategorySiteMapGenerator categorySiteMapGenerator =
        new CategorySiteMapGenerator(new StandardReactiveWebEnvironment());

    FileWorkArea fileWorkArea = new FileWorkArea();
    fileWorkArea.setFilePathLocation("/directory/foo.txt");
    SiteMapBuilder siteMapBuilder =
        new SiteMapBuilder(new SiteMapConfigurationImpl(), fileWorkArea, "/", true);
    SiteMapURLWrapper siteMapUrl = new SiteMapURLWrapper();

    MediaDto mediaDto = mock(MediaDto.class);
    when(mediaDto.getUrl()).thenReturn("https://example.org/example");
    doNothing().when(mediaDto).setUrl(Mockito.<String>any());
    mediaDto.setUrl("/");

    CategoryMediaXref categoryMediaXref = mock(CategoryMediaXref.class);
    when(categoryMediaXref.getMedia()).thenReturn(mediaDto);

    HashMap<String, CategoryMediaXref> categoryMediaXref2 = new HashMap<>();
    categoryMediaXref2.put("foo", categoryMediaXref);

    CategoryImpl category = new CategoryImpl();
    category.setCategoryMediaXref(categoryMediaXref2);

    // Act
    categorySiteMapGenerator.constructImageURLs(siteMapBuilder, siteMapUrl, category);

    // Assert
    verify(mediaDto).getUrl();
    verify(mediaDto).setUrl("/");
    verify(categoryMediaXref).getMedia();
    List<SiteMapImageWrapper> siteMapImageWrappers = siteMapUrl.getSiteMapImageWrappers();
    assertEquals(1, siteMapImageWrappers.size());
    assertEquals("/https://example.org/example", siteMapImageWrappers.get(0).getLoc());
  }

  /**
   * Test {@link CategorySiteMapGenerator#constructImageURLs(SiteMapBuilder, SiteMapURLWrapper,
   * Category)}.
   *
   * <ul>
   *   <li>Then calls {@link SiteMapURLWrapper#addImage(SiteMapImageWrapper)}.
   * </ul>
   *
   * <p>Method under test: {@link CategorySiteMapGenerator#constructImageURLs(SiteMapBuilder,
   * SiteMapURLWrapper, Category)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CategorySiteMapGenerator.constructImageURLs(SiteMapBuilder, SiteMapURLWrapper, Category)"
  })
  public void testConstructImageURLs_thenCallsAddImage() {
    // Arrange
    CategorySiteMapGenerator categorySiteMapGenerator =
        new CategorySiteMapGenerator(new StandardReactiveWebEnvironment());

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

    CategoryMediaXref categoryMediaXref = mock(CategoryMediaXref.class);
    when(categoryMediaXref.getMedia()).thenReturn(mediaDto);

    HashMap<String, CategoryMediaXref> categoryMediaXref2 = new HashMap<>();
    categoryMediaXref2.put("foo", categoryMediaXref);

    CategoryImpl category = new CategoryImpl();
    category.setCategoryMediaXref(categoryMediaXref2);

    // Act
    categorySiteMapGenerator.constructImageURLs(siteMapBuilder, siteMapUrl, category);

    // Assert
    verify(mediaDto).getUrl();
    verify(mediaDto).setUrl("/");
    verify(siteMapUrl).addImage(isA(SiteMapImageWrapper.class));
    verify(categoryMediaXref).getMedia();
  }

  /**
   * Test {@link CategorySiteMapGenerator#constructImageURLs(SiteMapBuilder, SiteMapURLWrapper,
   * Category)}.
   *
   * <ul>
   *   <li>Then {@link SiteMapURLWrapper} (default constructor) SiteMapImageWrappers Empty.
   * </ul>
   *
   * <p>Method under test: {@link CategorySiteMapGenerator#constructImageURLs(SiteMapBuilder,
   * SiteMapURLWrapper, Category)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CategorySiteMapGenerator.constructImageURLs(SiteMapBuilder, SiteMapURLWrapper, Category)"
  })
  public void testConstructImageURLs_thenSiteMapURLWrapperSiteMapImageWrappersEmpty() {
    // Arrange
    CategorySiteMapGenerator categorySiteMapGenerator =
        new CategorySiteMapGenerator(new StandardReactiveWebEnvironment());

    FileWorkArea fileWorkArea = new FileWorkArea();
    fileWorkArea.setFilePathLocation("/directory/foo.txt");
    SiteMapBuilder siteMapBuilder =
        new SiteMapBuilder(
            new SiteMapConfigurationImpl(), fileWorkArea, "https://example.org/example", true);
    SiteMapURLWrapper siteMapUrl = new SiteMapURLWrapper();

    // Act
    categorySiteMapGenerator.constructImageURLs(siteMapBuilder, siteMapUrl, new CategoryImpl());

    // Assert that nothing has changed
    assertTrue(siteMapUrl.getSiteMapImageWrappers().isEmpty());
  }

  /**
   * Test {@link CategorySiteMapGenerator#constructImageURLs(SiteMapBuilder, SiteMapURLWrapper,
   * Category)}.
   *
   * <ul>
   *   <li>Then {@link SiteMapURLWrapper} (default constructor) SiteMapImageWrappers first Loc is
   *       {@code /}.
   * </ul>
   *
   * <p>Method under test: {@link CategorySiteMapGenerator#constructImageURLs(SiteMapBuilder,
   * SiteMapURLWrapper, Category)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CategorySiteMapGenerator.constructImageURLs(SiteMapBuilder, SiteMapURLWrapper, Category)"
  })
  public void testConstructImageURLs_thenSiteMapURLWrapperSiteMapImageWrappersFirstLocIsSlash() {
    // Arrange
    CategorySiteMapGenerator categorySiteMapGenerator =
        new CategorySiteMapGenerator(new StandardReactiveWebEnvironment());

    FileWorkArea fileWorkArea = new FileWorkArea();
    fileWorkArea.setFilePathLocation("/directory/foo.txt");
    SiteMapBuilder siteMapBuilder =
        new SiteMapBuilder(new SiteMapConfigurationImpl(), fileWorkArea, "/", true);
    SiteMapURLWrapper siteMapUrl = new SiteMapURLWrapper();

    MediaDto mediaDto = new MediaDto();
    mediaDto.setUrl("/");

    CategoryMediaXref categoryMediaXref = mock(CategoryMediaXref.class);
    when(categoryMediaXref.getMedia()).thenReturn(mediaDto);

    HashMap<String, CategoryMediaXref> categoryMediaXref2 = new HashMap<>();
    categoryMediaXref2.put("foo", categoryMediaXref);

    CategoryImpl category = new CategoryImpl();
    category.setCategoryMediaXref(categoryMediaXref2);

    // Act
    categorySiteMapGenerator.constructImageURLs(siteMapBuilder, siteMapUrl, category);

    // Assert
    verify(categoryMediaXref).getMedia();
    List<SiteMapImageWrapper> siteMapImageWrappers = siteMapUrl.getSiteMapImageWrappers();
    assertEquals(1, siteMapImageWrappers.size());
    assertEquals("/", siteMapImageWrappers.get(0).getLoc());
  }

  /**
   * Test {@link CategorySiteMapGenerator#getPageCountForCategory(Category)}.
   *
   * <ul>
   *   <li>Then return intValue is one.
   * </ul>
   *
   * <p>Method under test: {@link CategorySiteMapGenerator#getPageCountForCategory(Category)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Integer CategorySiteMapGenerator.getPageCountForCategory(Category)"
  })
  public void testGetPageCountForCategory_thenReturnIntValueIsOne() {
    // Arrange
    CategorySiteMapGenerator categorySiteMapGenerator =
        new CategorySiteMapGenerator(new StandardReactiveWebEnvironment());

    // Act and Assert
    assertEquals(
        1, categorySiteMapGenerator.getPageCountForCategory(new CategoryImpl()).intValue());
  }

  /**
   * Test {@link CategorySiteMapGenerator#generateUrl(SiteMapBuilder, Category, int)}.
   *
   * <ul>
   *   <li>Given {@code ?}.
   *   <li>When {@link CategoryImpl} {@link CategoryImpl#getUrl()} return {@code ?}.
   * </ul>
   *
   * <p>Method under test: {@link CategorySiteMapGenerator#generateUrl(SiteMapBuilder, Category,
   * int)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String CategorySiteMapGenerator.generateUrl(SiteMapBuilder, Category, int)"})
  public void testGenerateUrl_givenQuestionMark_whenCategoryImplGetUrlReturnQuestionMark() {
    // Arrange
    Environment env = mock(Environment.class);
    when(env.getProperty(Mockito.<String>any(), Mockito.<String>any())).thenReturn("Property");
    CategorySiteMapGenerator categorySiteMapGenerator = new CategorySiteMapGenerator(env);

    FileWorkArea fileWorkArea = new FileWorkArea();
    fileWorkArea.setFilePathLocation("/directory/foo.txt");
    SiteMapBuilder siteMapBuilder =
        new SiteMapBuilder(
            new SiteMapConfigurationImpl(), fileWorkArea, "https://example.org/example", true);

    CategoryImpl category = mock(CategoryImpl.class);
    when(category.getUrl()).thenReturn("?");

    // Act
    String actualGenerateUrlResult =
        categorySiteMapGenerator.generateUrl(siteMapBuilder, category, 10);

    // Assert
    verify(category).getUrl();
    verify(env).getProperty("seo.category.pagination.param", "page");
    assertEquals("https://example.org/example/?Property=10", actualGenerateUrlResult);
  }

  /**
   * Test {@link CategorySiteMapGenerator#generateUrl(SiteMapBuilder, Category, int)}.
   *
   * <ul>
   *   <li>Given {@code /}.
   *   <li>Then return {@code https://example.org/example/?Property=10}.
   * </ul>
   *
   * <p>Method under test: {@link CategorySiteMapGenerator#generateUrl(SiteMapBuilder, Category,
   * int)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String CategorySiteMapGenerator.generateUrl(SiteMapBuilder, Category, int)"})
  public void testGenerateUrl_givenSlash_thenReturnHttpsExampleOrgExampleProperty10() {
    // Arrange
    Environment env = mock(Environment.class);
    when(env.getProperty(Mockito.<String>any(), Mockito.<String>any())).thenReturn("Property");
    CategorySiteMapGenerator categorySiteMapGenerator = new CategorySiteMapGenerator(env);

    FileWorkArea fileWorkArea = new FileWorkArea();
    fileWorkArea.setFilePathLocation("/directory/foo.txt");
    SiteMapBuilder siteMapBuilder =
        new SiteMapBuilder(
            new SiteMapConfigurationImpl(), fileWorkArea, "https://example.org/example", true);

    CategoryImpl category = mock(CategoryImpl.class);
    when(category.getUrl()).thenReturn("/");

    // Act
    String actualGenerateUrlResult =
        categorySiteMapGenerator.generateUrl(siteMapBuilder, category, 10);

    // Assert
    verify(category).getUrl();
    verify(env).getProperty("seo.category.pagination.param", "page");
    assertEquals("https://example.org/example/?Property=10", actualGenerateUrlResult);
  }

  /**
   * Test {@link CategorySiteMapGenerator#generateUrl(SiteMapBuilder, Category, int)}.
   *
   * <ul>
   *   <li>Given {@code /}.
   *   <li>Then return {@code /?Property=10}.
   * </ul>
   *
   * <p>Method under test: {@link CategorySiteMapGenerator#generateUrl(SiteMapBuilder, Category,
   * int)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String CategorySiteMapGenerator.generateUrl(SiteMapBuilder, Category, int)"})
  public void testGenerateUrl_givenSlash_thenReturnProperty10() {
    // Arrange
    Environment env = mock(Environment.class);
    when(env.getProperty(Mockito.<String>any(), Mockito.<String>any())).thenReturn("Property");
    CategorySiteMapGenerator categorySiteMapGenerator = new CategorySiteMapGenerator(env);

    FileWorkArea fileWorkArea = new FileWorkArea();
    fileWorkArea.setFilePathLocation("/directory/foo.txt");
    SiteMapBuilder siteMapBuilder =
        new SiteMapBuilder(new SiteMapConfigurationImpl(), fileWorkArea, "/", true);

    CategoryImpl category = mock(CategoryImpl.class);
    when(category.getUrl()).thenReturn("/");

    // Act
    String actualGenerateUrlResult =
        categorySiteMapGenerator.generateUrl(siteMapBuilder, category, 10);

    // Assert
    verify(category).getUrl();
    verify(env).getProperty("seo.category.pagination.param", "page");
    assertEquals("/?Property=10", actualGenerateUrlResult);
  }

  /**
   * Test {@link CategorySiteMapGenerator#generateUrl(SiteMapBuilder, Category, int)}.
   *
   * <ul>
   *   <li>Then return {@code Base Url/https://example.org/example}.
   * </ul>
   *
   * <p>Method under test: {@link CategorySiteMapGenerator#generateUrl(SiteMapBuilder, Category,
   * int)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String CategorySiteMapGenerator.generateUrl(SiteMapBuilder, Category, int)"})
  public void testGenerateUrl_thenReturnBaseUrlHttpsExampleOrgExample() {
    // Arrange
    CategorySiteMapGenerator categorySiteMapGenerator =
        new CategorySiteMapGenerator(new StandardReactiveWebEnvironment());

    FileWorkArea fileWorkArea = new FileWorkArea();
    fileWorkArea.setFilePathLocation("/directory/foo.txt");
    SiteMapBuilder siteMapBuilder =
        new SiteMapBuilder(new SiteMapConfigurationImpl(), fileWorkArea, "Base Url", true);

    CategoryImpl category = mock(CategoryImpl.class);
    when(category.getUrl()).thenReturn("https://example.org/example");

    // Act
    String actualGenerateUrlResult =
        categorySiteMapGenerator.generateUrl(siteMapBuilder, category, 10);

    // Assert
    verify(category).getUrl();
    assertEquals("Base Url/https://example.org/example", actualGenerateUrlResult);
  }

  /**
   * Test {@link CategorySiteMapGenerator#generateUrl(SiteMapBuilder, Category, int)}.
   *
   * <ul>
   *   <li>Then return {@code https://example.org/example/https://example.org/example?page=10}.
   * </ul>
   *
   * <p>Method under test: {@link CategorySiteMapGenerator#generateUrl(SiteMapBuilder, Category,
   * int)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String CategorySiteMapGenerator.generateUrl(SiteMapBuilder, Category, int)"})
  public void testGenerateUrl_thenReturnHttpsExampleOrgExampleHttpsExampleOrgExamplePage10() {
    // Arrange
    CategorySiteMapGenerator categorySiteMapGenerator =
        new CategorySiteMapGenerator(new StandardReactiveWebEnvironment());

    FileWorkArea fileWorkArea = new FileWorkArea();
    fileWorkArea.setFilePathLocation("/directory/foo.txt");
    SiteMapBuilder siteMapBuilder =
        new SiteMapBuilder(
            new SiteMapConfigurationImpl(), fileWorkArea, "https://example.org/example", true);

    CategoryImpl category = mock(CategoryImpl.class);
    when(category.getUrl()).thenReturn("https://example.org/example");

    // Act
    String actualGenerateUrlResult =
        categorySiteMapGenerator.generateUrl(siteMapBuilder, category, 10);

    // Assert
    verify(category).getUrl();
    assertEquals(
        "https://example.org/example/https://example.org/example?page=10", actualGenerateUrlResult);
  }

  /**
   * Test {@link CategorySiteMapGenerator#generateUrl(SiteMapBuilder, Category, int)}.
   *
   * <ul>
   *   <li>Then return {@code /https://example.org/example?page=10}.
   * </ul>
   *
   * <p>Method under test: {@link CategorySiteMapGenerator#generateUrl(SiteMapBuilder, Category,
   * int)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String CategorySiteMapGenerator.generateUrl(SiteMapBuilder, Category, int)"})
  public void testGenerateUrl_thenReturnHttpsExampleOrgExamplePage10() {
    // Arrange
    CategorySiteMapGenerator categorySiteMapGenerator =
        new CategorySiteMapGenerator(new StandardReactiveWebEnvironment());

    FileWorkArea fileWorkArea = new FileWorkArea();
    fileWorkArea.setFilePathLocation("/directory/foo.txt");
    SiteMapBuilder siteMapBuilder =
        new SiteMapBuilder(new SiteMapConfigurationImpl(), fileWorkArea, "/", true);

    CategoryImpl category = mock(CategoryImpl.class);
    when(category.getUrl()).thenReturn("https://example.org/example");

    // Act
    String actualGenerateUrlResult =
        categorySiteMapGenerator.generateUrl(siteMapBuilder, category, 10);

    // Assert
    verify(category).getUrl();
    assertEquals("/https://example.org/example?page=10", actualGenerateUrlResult);
  }

  /**
   * Test {@link CategorySiteMapGenerator#generateUrl(SiteMapBuilder, Category, int)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return {@code https://example.org/example/https://example.org/example}.
   * </ul>
   *
   * <p>Method under test: {@link CategorySiteMapGenerator#generateUrl(SiteMapBuilder, Category,
   * int)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String CategorySiteMapGenerator.generateUrl(SiteMapBuilder, Category, int)"})
  public void testGenerateUrl_whenOne_thenReturnHttpsExampleOrgExampleHttpsExampleOrgExample() {
    // Arrange
    Environment env = mock(Environment.class);
    when(env.getProperty(Mockito.<String>any(), Mockito.<String>any())).thenReturn("Property");
    CategorySiteMapGenerator categorySiteMapGenerator = new CategorySiteMapGenerator(env);

    FileWorkArea fileWorkArea = new FileWorkArea();
    fileWorkArea.setFilePathLocation("/directory/foo.txt");
    SiteMapBuilder siteMapBuilder =
        new SiteMapBuilder(
            new SiteMapConfigurationImpl(), fileWorkArea, "https://example.org/example", true);

    CategoryImpl category = mock(CategoryImpl.class);
    when(category.getUrl()).thenReturn("https://example.org/example");

    // Act
    String actualGenerateUrlResult =
        categorySiteMapGenerator.generateUrl(siteMapBuilder, category, 1);

    // Assert
    verify(category).getUrl();
    verify(env).getProperty("seo.category.pagination.param", "page");
    assertEquals(
        "https://example.org/example/https://example.org/example", actualGenerateUrlResult);
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CategorySiteMapGenerator#setCategoryDao(CategoryDao)}
   *   <li>{@link CategorySiteMapGenerator#setRowLimit(int)}
   *   <li>{@link CategorySiteMapGenerator#getCategoryDao()}
   *   <li>{@link CategorySiteMapGenerator#getRowLimit()}
   * </ul>
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CategoryDao CategorySiteMapGenerator.getCategoryDao()",
    "int CategorySiteMapGenerator.getRowLimit()",
    "void CategorySiteMapGenerator.setCategoryDao(CategoryDao)",
    "void CategorySiteMapGenerator.setRowLimit(int)"
  })
  public void testGettersAndSetters() {
    // Arrange
    CategorySiteMapGenerator categorySiteMapGenerator =
        new CategorySiteMapGenerator(new StandardReactiveWebEnvironment());
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
   *
   * <ul>
   *   <li>Then return forty.
   * </ul>
   *
   * <p>Method under test: {@link CategorySiteMapGenerator#getDefaultPageSize()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int CategorySiteMapGenerator.getDefaultPageSize()"})
  public void testGetDefaultPageSize_thenReturnForty() {
    // Arrange, Act and Assert
    assertEquals(
        40,
        new CategorySiteMapGenerator(new StandardReactiveWebEnvironment()).getDefaultPageSize());
  }

  /**
   * Test {@link CategorySiteMapGenerator#getCategoryPaginationParam()}.
   *
   * <p>Method under test: {@link CategorySiteMapGenerator#getCategoryPaginationParam()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String CategorySiteMapGenerator.getCategoryPaginationParam()"})
  public void testGetCategoryPaginationParam() {
    // Arrange, Act and Assert
    assertEquals(
        "page",
        new CategorySiteMapGenerator(new StandardReactiveWebEnvironment())
            .getCategoryPaginationParam());
  }
}
