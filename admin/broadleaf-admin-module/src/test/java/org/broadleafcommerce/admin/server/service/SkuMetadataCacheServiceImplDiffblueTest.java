package org.broadleafcommerce.admin.server.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import org.broadleafcommerce.openadmin.dto.FieldMetadata;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = {"/bl-admin-applicationContext-servlet.xml", "/bl-admin-applicationContext.xml",
    "/blc-config/admin/framework/bl-admin-admin-applicationContext-servlet.xml",
    "/blc-config/admin/framework/bl-admin-applicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class SkuMetadataCacheServiceImplDiffblueTest {
  @Autowired
  private SkuMetadataCacheServiceImpl skuMetadataCacheServiceImpl;

  /**
   * Test {@link SkuMetadataCacheServiceImpl#getEntireCache()}.
   * <p>
   * Method under test: {@link SkuMetadataCacheServiceImpl#getEntireCache()}
   */
  @Test
  public void testGetEntireCache() {
    // Arrange, Act and Assert
    assertTrue((new SkuMetadataCacheServiceImpl()).getEntireCache().isEmpty());
  }

  /**
   * Test {@link SkuMetadataCacheServiceImpl#useCache()}.
   * <p>
   * Method under test: {@link SkuMetadataCacheServiceImpl#useCache()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testUseCache() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.admin.server.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-admin-applicationContext-servlet.xml","/bl-admin-applicationContext.xml","/blc-config/admin/framework/bl-admin-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-admin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass271 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.admin.server.service.SkuMetadataCacheServiceImpl skuMetadataCacheServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new SkuMetadataCacheServiceImpl()).useCache();
  }

  /**
   * Test {@link SkuMetadataCacheServiceImpl#useCache()}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} computeIfPresent {@code foo} and
   * {@link BiFunction}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuMetadataCacheServiceImpl#useCache()}
   */
  @Test
  public void testUseCache_givenHashMapComputeIfPresentFooAndBiFunction() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    HashMap<String, FieldMetadata> metadata = new HashMap<>();
    metadata.computeIfPresent("foo", mock(BiFunction.class));

    SkuMetadataCacheServiceImpl skuMetadataCacheServiceImpl = new SkuMetadataCacheServiceImpl();
    skuMetadataCacheServiceImpl.addToCache("Cache Key", metadata);

    // Act and Assert
    assertFalse(skuMetadataCacheServiceImpl.useCache());
  }

  /**
   * Test {@link SkuMetadataCacheServiceImpl#useCache()}.
   * <ul>
   *   <li>Given {@link SkuMetadataCacheServiceImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuMetadataCacheServiceImpl#useCache()}
   */
  @Test
  public void testUseCache_givenSkuMetadataCacheServiceImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new SkuMetadataCacheServiceImpl()).useCache());
  }

  /**
   * Test {@link SkuMetadataCacheServiceImpl#getFromCache(String)}.
   * <p>
   * Method under test: {@link SkuMetadataCacheServiceImpl#getFromCache(String)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetFromCache() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.admin.server.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-admin-applicationContext-servlet.xml","/bl-admin-applicationContext.xml","/blc-config/admin/framework/bl-admin-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-admin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass99 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.admin.server.service.SkuMetadataCacheServiceImpl skuMetadataCacheServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new SkuMetadataCacheServiceImpl()).getFromCache("Cache Key");
  }

  /**
   * Test {@link SkuMetadataCacheServiceImpl#getFromCache(String)}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} computeIfPresent {@code foo} and
   * {@link BiFunction}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuMetadataCacheServiceImpl#getFromCache(String)}
   */
  @Test
  public void testGetFromCache_givenHashMapComputeIfPresentFooAndBiFunction() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    HashMap<String, FieldMetadata> metadata = new HashMap<>();
    metadata.computeIfPresent("foo", mock(BiFunction.class));

    SkuMetadataCacheServiceImpl skuMetadataCacheServiceImpl = new SkuMetadataCacheServiceImpl();
    skuMetadataCacheServiceImpl.addToCache("Cache Key", metadata);

    // Act and Assert
    assertNull(skuMetadataCacheServiceImpl.getFromCache("Cache Key"));
  }

  /**
   * Test {@link SkuMetadataCacheServiceImpl#getFromCache(String)}.
   * <ul>
   *   <li>Given {@link SkuMetadataCacheServiceImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuMetadataCacheServiceImpl#getFromCache(String)}
   */
  @Test
  public void testGetFromCache_givenSkuMetadataCacheServiceImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new SkuMetadataCacheServiceImpl()).getFromCache("Cache Key"));
  }

  /**
   * Test {@link SkuMetadataCacheServiceImpl#addToCache(String, Map)}.
   * <p>
   * Method under test:
   * {@link SkuMetadataCacheServiceImpl#addToCache(String, Map)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testAddToCache() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.admin.server.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-admin-applicationContext-servlet.xml","/bl-admin-applicationContext.xml","/blc-config/admin/framework/bl-admin-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-admin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass0 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.admin.server.service.SkuMetadataCacheServiceImpl skuMetadataCacheServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    SkuMetadataCacheServiceImpl skuMetadataCacheServiceImpl2 = new SkuMetadataCacheServiceImpl();

    // Act
    skuMetadataCacheServiceImpl2.addToCache("Cache Key", new HashMap<>());
  }

  /**
   * Test {@link SkuMetadataCacheServiceImpl#addToCache(String, Map)}.
   * <ul>
   *   <li>Given {@code foo}.</li>
   *   <li>When {@link HashMap#HashMap()} computeIfPresent {@code foo} and
   * {@link BiFunction}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SkuMetadataCacheServiceImpl#addToCache(String, Map)}
   */
  @Test
  public void testAddToCache_givenFoo_whenHashMapComputeIfPresentFooAndBiFunction() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuMetadataCacheServiceImpl skuMetadataCacheServiceImpl = new SkuMetadataCacheServiceImpl();

    HashMap<String, FieldMetadata> metadata = new HashMap<>();
    metadata.computeIfPresent("foo", mock(BiFunction.class));

    // Act and Assert
    assertFalse(skuMetadataCacheServiceImpl.addToCache("Cache Key", metadata));
  }

  /**
   * Test {@link SkuMetadataCacheServiceImpl#addToCache(String, Map)}.
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SkuMetadataCacheServiceImpl#addToCache(String, Map)}
   */
  @Test
  public void testAddToCache_whenHashMap() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuMetadataCacheServiceImpl skuMetadataCacheServiceImpl = new SkuMetadataCacheServiceImpl();

    // Act and Assert
    assertFalse(skuMetadataCacheServiceImpl.addToCache("Cache Key", new HashMap<>()));
  }

  /**
   * Test {@link SkuMetadataCacheServiceImpl#invalidateFromCache(String)}.
   * <p>
   * Method under test:
   * {@link SkuMetadataCacheServiceImpl#invalidateFromCache(String)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testInvalidateFromCache() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.admin.server.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-admin-applicationContext-servlet.xml","/bl-admin-applicationContext.xml","/blc-config/admin/framework/bl-admin-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-admin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass185 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.admin.server.service.SkuMetadataCacheServiceImpl skuMetadataCacheServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new SkuMetadataCacheServiceImpl()).invalidateFromCache("Cache Key");
  }

  /**
   * Test {@link SkuMetadataCacheServiceImpl#buildCacheKey(String)}.
   * <p>
   * Method under test: {@link SkuMetadataCacheServiceImpl#buildCacheKey(String)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testBuildCacheKey() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.admin.server.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-admin-applicationContext-servlet.xml","/bl-admin-applicationContext.xml","/blc-config/admin/framework/bl-admin-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-admin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass13 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.admin.server.service.SkuMetadataCacheServiceImpl skuMetadataCacheServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new SkuMetadataCacheServiceImpl()).buildCacheKey("42");
  }

  /**
   * Test {@link SkuMetadataCacheServiceImpl#buildCacheKey(String)}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} computeIfPresent {@code foo} and
   * {@link BiFunction}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuMetadataCacheServiceImpl#buildCacheKey(String)}
   */
  @Test
  public void testBuildCacheKey_givenHashMapComputeIfPresentFooAndBiFunction() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    HashMap<String, FieldMetadata> metadata = new HashMap<>();
    metadata.computeIfPresent("foo", mock(BiFunction.class));

    SkuMetadataCacheServiceImpl skuMetadataCacheServiceImpl = new SkuMetadataCacheServiceImpl();
    skuMetadataCacheServiceImpl.addToCache("_", metadata);

    // Act and Assert
    assertEquals("org.broadleafcommerce.core.catalog.domain.SkuImpl_42",
        skuMetadataCacheServiceImpl.buildCacheKey("42"));
  }

  /**
   * Test {@link SkuMetadataCacheServiceImpl#buildCacheKey(String)}.
   * <ul>
   *   <li>Then return
   * {@code org.broadleafcommerce.core.catalog.domain.SkuImpl}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuMetadataCacheServiceImpl#buildCacheKey(String)}
   */
  @Test
  public void testBuildCacheKey_thenReturnOrgBroadleafcommerceCoreCatalogDomainSkuImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("org.broadleafcommerce.core.catalog.domain.SkuImpl",
        (new SkuMetadataCacheServiceImpl()).buildCacheKey(null));
  }

  /**
   * Test {@link SkuMetadataCacheServiceImpl#buildCacheKey(String)}.
   * <ul>
   *   <li>Then return
   * {@code org.broadleafcommerce.core.catalog.domain.SkuImpl_42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuMetadataCacheServiceImpl#buildCacheKey(String)}
   */
  @Test
  public void testBuildCacheKey_thenReturnOrgBroadleafcommerceCoreCatalogDomainSkuImpl42() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("org.broadleafcommerce.core.catalog.domain.SkuImpl_42",
        (new SkuMetadataCacheServiceImpl()).buildCacheKey("42"));
  }
}
