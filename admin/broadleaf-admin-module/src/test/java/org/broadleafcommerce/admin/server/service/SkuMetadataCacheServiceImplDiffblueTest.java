package org.broadleafcommerce.admin.server.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.Map;
import org.broadleafcommerce.openadmin.dto.FieldMetadata;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class SkuMetadataCacheServiceImplDiffblueTest {
  /**
   * Test {@link SkuMetadataCacheServiceImpl#getEntireCache()}.
   *
   * <p>Method under test: {@link SkuMetadataCacheServiceImpl#getEntireCache()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map SkuMetadataCacheServiceImpl.getEntireCache()"})
  public void testGetEntireCache() {
    // Arrange and Act
    Map<String, Map<String, FieldMetadata>> actualEntireCache =
        new SkuMetadataCacheServiceImpl().getEntireCache();

    // Assert
    assertTrue(actualEntireCache.isEmpty());
    assertSame(SkuMetadataCacheServiceImpl.METADATA_CACHE, actualEntireCache);
  }

  /**
   * Test {@link SkuMetadataCacheServiceImpl#useCache()}.
   *
   * <p>Method under test: {@link SkuMetadataCacheServiceImpl#useCache()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SkuMetadataCacheServiceImpl.useCache()"})
  public void testUseCache() {
    // Arrange, Act and Assert
    assertFalse(new SkuMetadataCacheServiceImpl().useCache());
  }

  /**
   * Test {@link SkuMetadataCacheServiceImpl#getFromCache(String)}.
   *
   * <p>Method under test: {@link SkuMetadataCacheServiceImpl#getFromCache(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map SkuMetadataCacheServiceImpl.getFromCache(String)"})
  public void testGetFromCache() {
    // Arrange, Act and Assert
    assertNull(new SkuMetadataCacheServiceImpl().getFromCache("Cache Key"));
  }

  /**
   * Test {@link SkuMetadataCacheServiceImpl#addToCache(String, Map)}.
   *
   * <p>Method under test: {@link SkuMetadataCacheServiceImpl#addToCache(String, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SkuMetadataCacheServiceImpl.addToCache(String, Map)"})
  public void testAddToCache() {
    // Arrange
    SkuMetadataCacheServiceImpl skuMetadataCacheServiceImpl = new SkuMetadataCacheServiceImpl();

    // Act and Assert
    assertFalse(skuMetadataCacheServiceImpl.addToCache("Cache Key", new HashMap<>()));
  }

  /**
   * Test {@link SkuMetadataCacheServiceImpl#buildCacheKey(String)}.
   *
   * <ul>
   *   <li>Then return {@code org.broadleafcommerce.core.catalog.domain.SkuImpl}.
   * </ul>
   *
   * <p>Method under test: {@link SkuMetadataCacheServiceImpl#buildCacheKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SkuMetadataCacheServiceImpl.buildCacheKey(String)"})
  public void testBuildCacheKey_thenReturnOrgBroadleafcommerceCoreCatalogDomainSkuImpl() {
    // Arrange, Act and Assert
    assertEquals(
        "org.broadleafcommerce.core.catalog.domain.SkuImpl",
        new SkuMetadataCacheServiceImpl().buildCacheKey(null));
  }

  /**
   * Test {@link SkuMetadataCacheServiceImpl#buildCacheKey(String)}.
   *
   * <ul>
   *   <li>Then return {@code org.broadleafcommerce.core.catalog.domain.SkuImpl_42}.
   * </ul>
   *
   * <p>Method under test: {@link SkuMetadataCacheServiceImpl#buildCacheKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SkuMetadataCacheServiceImpl.buildCacheKey(String)"})
  public void testBuildCacheKey_thenReturnOrgBroadleafcommerceCoreCatalogDomainSkuImpl42() {
    // Arrange, Act and Assert
    assertEquals(
        "org.broadleafcommerce.core.catalog.domain.SkuImpl_42",
        new SkuMetadataCacheServiceImpl().buildCacheKey("42"));
  }
}
