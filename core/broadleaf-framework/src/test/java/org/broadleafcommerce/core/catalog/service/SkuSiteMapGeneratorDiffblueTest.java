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
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import org.broadleafcommerce.common.currency.domain.BroadleafCurrencyImpl;
import org.broadleafcommerce.common.file.domain.FileWorkArea;
import org.broadleafcommerce.common.media.domain.MediaDto;
import org.broadleafcommerce.common.money.Money;
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
import org.broadleafcommerce.common.util.DimensionUnitOfMeasureType;
import org.broadleafcommerce.common.util.WeightUnitOfMeasureType;
import org.broadleafcommerce.common.vendor.service.type.ContainerShapeType;
import org.broadleafcommerce.common.vendor.service.type.ContainerSizeType;
import org.broadleafcommerce.core.catalog.dao.SkuDao;
import org.broadleafcommerce.core.catalog.dao.SkuDaoImpl;
import org.broadleafcommerce.core.catalog.domain.Dimension;
import org.broadleafcommerce.core.catalog.domain.ProductBundleImpl;
import org.broadleafcommerce.core.catalog.domain.ProductImpl;
import org.broadleafcommerce.core.catalog.domain.Sku;
import org.broadleafcommerce.core.catalog.domain.SkuImpl;
import org.broadleafcommerce.core.catalog.domain.SkuMediaXref;
import org.broadleafcommerce.core.catalog.domain.Weight;
import org.broadleafcommerce.core.inventory.service.type.InventoryType;
import org.broadleafcommerce.core.order.service.type.FulfillmentType;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mockito.Mockito;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;

@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class SkuSiteMapGeneratorDiffblueTest {
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
    SkuSiteMapGenerator skuSiteMapGenerator = new SkuSiteMapGenerator();

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
    assertFalse(skuSiteMapGenerator.canHandleSiteMapConfiguration(siteMapGeneratorConfiguration));
  }

  /**
   * Test {@link SkuSiteMapGenerator#canHandleSiteMapConfiguration(SiteMapGeneratorConfiguration)}.
   *
   * <ul>
   *   <li>Given {@link SiteMapGeneratorType#SiteMapGeneratorType()}.
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
  public void testCanHandleSiteMapConfiguration_givenSiteMapGeneratorType() {
    // Arrange
    SkuSiteMapGenerator skuSiteMapGenerator = new SkuSiteMapGenerator();

    SiteMapGeneratorConfiguration siteMapGeneratorConfiguration =
        mock(SiteMapGeneratorConfiguration.class);
    when(siteMapGeneratorConfiguration.getSiteMapGeneratorType())
        .thenReturn(new SiteMapGeneratorType());

    // Act
    boolean actualCanHandleSiteMapConfigurationResult =
        skuSiteMapGenerator.canHandleSiteMapConfiguration(siteMapGeneratorConfiguration);

    // Assert
    verify(siteMapGeneratorConfiguration).getSiteMapGeneratorType();
    assertFalse(actualCanHandleSiteMapConfigurationResult);
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
    SkuSiteMapGenerator skuSiteMapGenerator = new SkuSiteMapGenerator();

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
    // Arrange
    SkuSiteMapGenerator skuSiteMapGenerator = new SkuSiteMapGenerator();

    // Act and Assert
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

    SkuDaoImpl skuDao = mock(SkuDaoImpl.class);
    when(skuDao.readAllActiveSkus(anyInt(), anyInt())).thenReturn(skuList);

    SkuSiteMapGenerator skuSiteMapGenerator = new SkuSiteMapGenerator();
    skuSiteMapGenerator.setSkuDao(skuDao);

    SiteMapGeneratorConfiguration smgc = mock(SiteMapGeneratorConfiguration.class);
    when(smgc.getSiteMapChangeFreq()).thenReturn(new SiteMapChangeFreqType());
    when(smgc.getSiteMapPriority()).thenReturn(new SiteMapPriorityType());

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

    SkuDaoImpl skuDao = mock(SkuDaoImpl.class);
    when(skuDao.readAllActiveSkus(anyInt(), anyInt())).thenReturn(skuList);

    SkuSiteMapGenerator skuSiteMapGenerator = new SkuSiteMapGenerator();
    skuSiteMapGenerator.setSkuDao(skuDao);

    SiteMapGeneratorConfiguration smgc = mock(SiteMapGeneratorConfiguration.class);
    when(smgc.getSiteMapChangeFreq()).thenReturn(new SiteMapChangeFreqType());
    when(smgc.getSiteMapPriority()).thenReturn(new SiteMapPriorityType());

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

    SkuDaoImpl skuDao = mock(SkuDaoImpl.class);
    when(skuDao.readAllActiveSkus(anyInt(), anyInt())).thenReturn(skuList);

    SkuSiteMapGenerator skuSiteMapGenerator = new SkuSiteMapGenerator();
    skuSiteMapGenerator.setSkuDao(skuDao);

    SiteMapGeneratorConfiguration smgc = mock(SiteMapGeneratorConfiguration.class);
    when(smgc.getSiteMapChangeFreq()).thenReturn(new SiteMapChangeFreqType());
    when(smgc.getSiteMapPriority()).thenReturn(new SiteMapPriorityType());

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

    SkuDaoImpl skuDao = mock(SkuDaoImpl.class);
    when(skuDao.readAllActiveSkus(anyInt(), anyInt())).thenReturn(skuList);

    SkuSiteMapGenerator skuSiteMapGenerator = new SkuSiteMapGenerator();
    skuSiteMapGenerator.setSkuDao(skuDao);
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

    SkuDaoImpl skuDao = mock(SkuDaoImpl.class);
    when(skuDao.readAllActiveSkus(anyInt(), anyInt())).thenReturn(skuList);

    SkuSiteMapGenerator skuSiteMapGenerator = new SkuSiteMapGenerator();
    skuSiteMapGenerator.setSkuDao(skuDao);
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

    SkuDaoImpl skuDao = mock(SkuDaoImpl.class);
    when(skuDao.readAllActiveSkus(anyInt(), anyInt())).thenReturn(skuList);

    SkuSiteMapGenerator skuSiteMapGenerator = new SkuSiteMapGenerator();
    skuSiteMapGenerator.setSkuDao(skuDao);

    SiteMapGeneratorConfiguration smgc = mock(SiteMapGeneratorConfiguration.class);
    when(smgc.getSiteMapChangeFreq()).thenReturn(new SiteMapChangeFreqType());
    when(smgc.getSiteMapPriority()).thenReturn(new SiteMapPriorityType());

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
   *   <li>Given {@link SkuSiteMapGenerator} (default constructor) PageSize is three.
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
  public void testAddSiteMapEntries_givenSkuSiteMapGeneratorPageSizeIsThree() {
    // Arrange
    SkuDaoImpl skuDao = mock(SkuDaoImpl.class);
    when(skuDao.readAllActiveSkus(anyInt(), anyInt())).thenReturn(new ArrayList<>());

    SkuSiteMapGenerator skuSiteMapGenerator = new SkuSiteMapGenerator();
    skuSiteMapGenerator.setPageSize(3);
    skuSiteMapGenerator.setSkuDao(skuDao);
    SiteMapGeneratorConfigurationImpl smgc = new SiteMapGeneratorConfigurationImpl();

    FileWorkArea fileWorkArea = new FileWorkArea();
    fileWorkArea.setFilePathLocation("/directory/foo.txt");
    SiteMapBuilder siteMapBuilder =
        new SiteMapBuilder(
            new SiteMapConfigurationImpl(), fileWorkArea, "https://example.org/example", true);

    // Act
    skuSiteMapGenerator.addSiteMapEntries(smgc, siteMapBuilder);

    // Assert
    verify(skuDao).readAllActiveSkus(0, 3);
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

    SkuDaoImpl skuDao = mock(SkuDaoImpl.class);
    when(skuDao.readAllActiveSkus(anyInt(), anyInt())).thenReturn(skuList);

    SkuSiteMapGenerator skuSiteMapGenerator = new SkuSiteMapGenerator();
    skuSiteMapGenerator.setSkuDao(skuDao);

    SiteMapGeneratorConfiguration smgc = mock(SiteMapGeneratorConfiguration.class);
    when(smgc.getSiteMapChangeFreq()).thenReturn(new SiteMapChangeFreqType());
    when(smgc.getSiteMapPriority()).thenReturn(new SiteMapPriorityType());

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

    SkuDaoImpl skuDao = mock(SkuDaoImpl.class);
    when(skuDao.readAllActiveSkus(anyInt(), anyInt())).thenReturn(skuList);

    SkuSiteMapGenerator skuSiteMapGenerator = new SkuSiteMapGenerator();
    skuSiteMapGenerator.setSkuDao(skuDao);
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
    SkuSiteMapGenerator skuSiteMapGenerator = new SkuSiteMapGenerator();

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
    SkuSiteMapGenerator skuSiteMapGenerator = new SkuSiteMapGenerator();

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
    SkuSiteMapGenerator skuSiteMapGenerator = new SkuSiteMapGenerator();

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
    SkuSiteMapGenerator skuSiteMapGenerator = new SkuSiteMapGenerator();

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
    SkuSiteMapGenerator skuSiteMapGenerator = new SkuSiteMapGenerator();

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
    SkuSiteMapGenerator skuSiteMapGenerator = new SkuSiteMapGenerator();

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
    SkuSiteMapGenerator skuSiteMapGenerator = new SkuSiteMapGenerator();

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
   *   <li>Given {@code Sku}.
   *   <li>When {@link SkuImpl} (default constructor) UrlKey is {@code Sku}.
   *   <li>Then return {@code /nullSku}.
   * </ul>
   *
   * <p>Method under test: {@link SkuSiteMapGenerator#generateUri(SiteMapBuilder, Sku)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SkuSiteMapGenerator.generateUri(SiteMapBuilder, Sku)"})
  public void testGenerateUri_givenSku_whenSkuImplUrlKeyIsSku_thenReturnNullSku() {
    // Arrange
    SkuSiteMapGenerator skuSiteMapGenerator = new SkuSiteMapGenerator();

    FileWorkArea fileWorkArea = new FileWorkArea();
    fileWorkArea.setFilePathLocation("/directory/foo.txt");
    SiteMapBuilder smb =
        new SiteMapBuilder(new SiteMapConfigurationImpl(), fileWorkArea, "/", true);

    Dimension dimension = new Dimension();
    dimension.setContainer(new ContainerShapeType());
    dimension.setDepth(new BigDecimal("2.3"));
    dimension.setDimensionUnitOfMeasure(new DimensionUnitOfMeasureType());
    dimension.setGirth(new BigDecimal("2.3"));
    dimension.setHeight(new BigDecimal("2.3"));
    dimension.setSize(new ContainerSizeType());
    dimension.setWidth(new BigDecimal("2.3"));

    Weight weight = new Weight();
    weight.setWeight(new BigDecimal("2.3"));
    weight.setWeightUnitOfMeasure(new WeightUnitOfMeasureType());

    SkuImpl sku = new SkuImpl();
    sku.setActiveEndDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    sku.setActiveStartDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    sku.setAvailable(true);
    sku.setCost(new Money());
    sku.setCurrency(new BroadleafCurrencyImpl());
    sku.setDefaultProduct(new ProductBundleImpl());
    sku.setDescription("The characteristics of someone or something");
    sku.setDimension(dimension);
    sku.setDiscountable(true);
    sku.setDisplayTemplate("Display Template");
    sku.setExcludedFulfillmentOptions(new ArrayList<>());
    sku.setExternalId("42");
    sku.setFees(new ArrayList<>());
    sku.setFulfillmentFlatRates(new HashMap<>());
    sku.setFulfillmentType(FulfillmentType.DIGITAL);
    sku.setId(1L);
    sku.setInventoryType(InventoryType.ALWAYS_AVAILABLE);
    sku.setIsMachineSortable(true);
    sku.setListPrice(new Money());
    sku.setLongDescription("Long Description");
    sku.setMachineSortable(true);
    sku.setName("Name");
    sku.setProduct(new ProductBundleImpl());
    sku.setProductOptionValueXrefs(new HashSet<>());
    sku.setQuantityAvailable(1);
    sku.setRetailPrice(new Money());
    sku.setSalePrice(new Money());
    sku.setSkuAttributes(new HashMap<>());
    sku.setSkuMediaXref(new HashMap<>());
    sku.setTaxCode("Tax Code");
    sku.setTaxable(true);
    sku.setUpc("Upc");
    sku.setWeight(weight);
    sku.setUrlKey("Sku");

    // Act and Assert
    assertEquals("/nullSku", skuSiteMapGenerator.generateUri(smb, sku));
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
    SkuSiteMapGenerator skuSiteMapGenerator = new SkuSiteMapGenerator();

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
    SkuSiteMapGenerator skuSiteMapGenerator = new SkuSiteMapGenerator();

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
    SkuSiteMapGenerator skuSiteMapGenerator = new SkuSiteMapGenerator();

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
    SkuSiteMapGenerator skuSiteMapGenerator = new SkuSiteMapGenerator();

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
