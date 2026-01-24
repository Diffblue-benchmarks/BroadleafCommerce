package org.broadleafcommerce.core.web.breadcrumbs;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.broadleafcommerce.common.breadcrumbs.dto.BreadcrumbDTO;
import org.broadleafcommerce.common.breadcrumbs.service.BreadcrumbServiceExtensionHandler;
import org.broadleafcommerce.common.breadcrumbs.service.BreadcrumbServiceExtensionManager;
import org.broadleafcommerce.common.extension.ExtensionResultHolder;
import org.broadleafcommerce.common.extension.ExtensionResultStatusType;
import org.broadleafcommerce.core.catalog.domain.Product;
import org.broadleafcommerce.core.catalog.domain.ProductBundleImpl;
import org.broadleafcommerce.core.catalog.domain.SkuImpl;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {ProductBreadcrumbServiceExtensionHandler.class})
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@RunWith(SpringJUnit4ClassRunner.class)
public class ProductBreadcrumbServiceExtensionHandlerDiffblueTest {
  @MockBean(name = "blBreadcrumbServiceExtensionManager")
  private BreadcrumbServiceExtensionManager breadcrumbServiceExtensionManager;

  @Autowired
  private ProductBreadcrumbServiceExtensionHandler productBreadcrumbServiceExtensionHandler;

  /**
   * Test {@link ProductBreadcrumbServiceExtensionHandler#modifyBreadcrumbList(String, Map,
   * ExtensionResultHolder)}.
   *
   * <p>Method under test: {@link
   * ProductBreadcrumbServiceExtensionHandler#modifyBreadcrumbList(String, Map,
   * ExtensionResultHolder)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType ProductBreadcrumbServiceExtensionHandler.modifyBreadcrumbList(String, Map, ExtensionResultHolder)"
  })
  public void testModifyBreadcrumbList() {
    // Arrange
    HashMap<String, String[]> params = new HashMap<>();

    ExtensionResultHolder<List<BreadcrumbDTO>> holder = new ExtensionResultHolder<>();
    holder.setResult(new ArrayList<>());
    holder.setThrowable(new Throwable());

    // Act
    productBreadcrumbServiceExtensionHandler.modifyBreadcrumbList(
        "https://example.org/example", params, holder);

    // Assert
    Map<String, Object> contextMap = holder.getContextMap();
    assertEquals(1, contextMap.size());
    assertEquals("https://example.org", contextMap.get("STRIPPED_URL"));
    assertTrue(params.isEmpty());
  }

  /**
   * Test {@link ProductBreadcrumbServiceExtensionHandler#modifyBreadcrumbList(String, Map,
   * ExtensionResultHolder)}.
   *
   * <p>Method under test: {@link
   * ProductBreadcrumbServiceExtensionHandler#modifyBreadcrumbList(String, Map,
   * ExtensionResultHolder)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType ProductBreadcrumbServiceExtensionHandler.modifyBreadcrumbList(String, Map, ExtensionResultHolder)"
  })
  public void testModifyBreadcrumbList2() {
    // Arrange
    HashMap<String, String[]> params = new HashMap<>();
    params.put("productId", new String[] {"currentProduct"});

    ExtensionResultHolder<List<BreadcrumbDTO>> holder = new ExtensionResultHolder<>();
    holder.setResult(new ArrayList<>());
    holder.setThrowable(new Throwable());

    // Act
    productBreadcrumbServiceExtensionHandler.modifyBreadcrumbList("currentProduct", params, holder);

    // Assert
    Map<String, Object> contextMap = holder.getContextMap();
    assertEquals(1, contextMap.size());
    assertTrue(params.isEmpty());
    assertSame(params, contextMap.get("STRIPPED_PARAMS"));
  }

  /**
   * Test {@link ProductBreadcrumbServiceExtensionHandler#modifyBreadcrumbList(String, Map,
   * ExtensionResultHolder)}.
   *
   * <ul>
   *   <li>When {@code currentProduct}.
   *   <li>Then return {@code HANDLED_CONTINUE}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ProductBreadcrumbServiceExtensionHandler#modifyBreadcrumbList(String, Map,
   * ExtensionResultHolder)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType ProductBreadcrumbServiceExtensionHandler.modifyBreadcrumbList(String, Map, ExtensionResultHolder)"
  })
  public void testModifyBreadcrumbList_whenCurrentProduct_thenReturnHandledContinue() {
    // Arrange
    HashMap<String, String[]> params = new HashMap<>();

    ExtensionResultHolder<List<BreadcrumbDTO>> holder = new ExtensionResultHolder<>();
    holder.setResult(new ArrayList<>());
    holder.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(
        ExtensionResultStatusType.HANDLED_CONTINUE,
        productBreadcrumbServiceExtensionHandler.modifyBreadcrumbList(
            "currentProduct", params, holder));
    assertTrue(params.isEmpty());
    assertTrue(holder.getContextMap().isEmpty());
  }

  /**
   * Test {@link ProductBreadcrumbServiceExtensionHandler#determineProduct(String, Map,
   * ExtensionResultHolder)}.
   *
   * <ul>
   *   <li>When {@code https://example.org/example}.
   * </ul>
   *
   * <p>Method under test: {@link ProductBreadcrumbServiceExtensionHandler#determineProduct(String,
   * Map, ExtensionResultHolder)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Product ProductBreadcrumbServiceExtensionHandler.determineProduct(String, Map, ExtensionResultHolder)"
  })
  public void testDetermineProduct_whenHttpsExampleOrgExample() {
    // Arrange
    HashMap<String, String[]> params = new HashMap<>();

    ExtensionResultHolder<List<BreadcrumbDTO>> holder = new ExtensionResultHolder<>();
    holder.setResult(new ArrayList<>());
    holder.setThrowable(new Throwable());

    // Act and Assert
    assertNull(
        productBreadcrumbServiceExtensionHandler.determineProduct(
            "https://example.org/example", params, holder));
  }

  /**
   * Test {@link ProductBreadcrumbServiceExtensionHandler#determineProduct(String, Map,
   * ExtensionResultHolder)}.
   *
   * <ul>
   *   <li>When {@code ThreadLocalManager.notify.orphans}.
   * </ul>
   *
   * <p>Method under test: {@link ProductBreadcrumbServiceExtensionHandler#determineProduct(String,
   * Map, ExtensionResultHolder)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Product ProductBreadcrumbServiceExtensionHandler.determineProduct(String, Map, ExtensionResultHolder)"
  })
  public void testDetermineProduct_whenThreadLocalManagerNotifyOrphans() {
    // Arrange
    HashMap<String, String[]> params = new HashMap<>();

    ExtensionResultHolder<List<BreadcrumbDTO>> holder = new ExtensionResultHolder<>();
    holder.setResult(new ArrayList<>());
    holder.setThrowable(new Throwable());

    // Act and Assert
    assertNull(
        productBreadcrumbServiceExtensionHandler.determineProduct(
            "ThreadLocalManager.notify.orphans", params, holder));
  }

  /**
   * Test {@link ProductBreadcrumbServiceExtensionHandler#getNameForProductLink(Product)}.
   *
   * <ul>
   *   <li>Given {@code Name}.
   *   <li>Then return {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ProductBreadcrumbServiceExtensionHandler#getNameForProductLink(Product)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String ProductBreadcrumbServiceExtensionHandler.getNameForProductLink(Product)"
  })
  public void testGetNameForProductLink_givenName_thenReturnName() {
    // Arrange
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getName()).thenReturn("Name");

    // Act
    String actualNameForProductLink =
        productBreadcrumbServiceExtensionHandler.getNameForProductLink(product);

    // Assert
    verify(product).getName();
    assertEquals("Name", actualNameForProductLink);
  }

  /**
   * Test {@link ProductBreadcrumbServiceExtensionHandler#getNameForProductLink(Product)}.
   *
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor).
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ProductBreadcrumbServiceExtensionHandler#getNameForProductLink(Product)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String ProductBreadcrumbServiceExtensionHandler.getNameForProductLink(Product)"
  })
  public void testGetNameForProductLink_givenSkuImpl_thenReturnNull() {
    // Arrange
    ProductBundleImpl product = new ProductBundleImpl();
    product.setDefaultSku(new SkuImpl());

    // Act and Assert
    assertNull(productBreadcrumbServiceExtensionHandler.getNameForProductLink(product));
  }

  /**
   * Test {@link ProductBreadcrumbServiceExtensionHandler#updateContextMap(String, Map,
   * ExtensionResultHolder)}.
   *
   * <ul>
   *   <li>Given {@code productId}.
   *   <li>Then {@link ExtensionResultHolder} (default constructor) ContextMap size is two.
   * </ul>
   *
   * <p>Method under test: {@link ProductBreadcrumbServiceExtensionHandler#updateContextMap(String,
   * Map, ExtensionResultHolder)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ProductBreadcrumbServiceExtensionHandler.updateContextMap(String, Map, ExtensionResultHolder)"
  })
  public void testUpdateContextMap_givenProductId_thenExtensionResultHolderContextMapSizeIsTwo() {
    // Arrange
    HashMap<String, String[]> params = new HashMap<>();
    params.put("productId", new String[] {"productId"});

    ExtensionResultHolder<List<BreadcrumbDTO>> holder = new ExtensionResultHolder<>();
    holder.setResult(new ArrayList<>());
    holder.setThrowable(new Throwable());

    // Act
    productBreadcrumbServiceExtensionHandler.updateContextMap(
        "https://example.org/example", params, holder);

    // Assert
    Map<String, Object> contextMap = holder.getContextMap();
    assertEquals(2, contextMap.size());
    assertTrue(params.isEmpty());
    assertTrue(contextMap.containsKey("STRIPPED_URL"));
    assertSame(params, contextMap.get("STRIPPED_PARAMS"));
  }

  /**
   * Test {@link ProductBreadcrumbServiceExtensionHandler#updateContextMap(String, Map,
   * ExtensionResultHolder)}.
   *
   * <ul>
   *   <li>Then {@link ExtensionResultHolder} (default constructor) ContextMap size is one.
   * </ul>
   *
   * <p>Method under test: {@link ProductBreadcrumbServiceExtensionHandler#updateContextMap(String,
   * Map, ExtensionResultHolder)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ProductBreadcrumbServiceExtensionHandler.updateContextMap(String, Map, ExtensionResultHolder)"
  })
  public void testUpdateContextMap_thenExtensionResultHolderContextMapSizeIsOne() {
    // Arrange
    HashMap<String, String[]> params = new HashMap<>();

    ExtensionResultHolder<List<BreadcrumbDTO>> holder = new ExtensionResultHolder<>();
    holder.setResult(new ArrayList<>());
    holder.setThrowable(new Throwable());

    // Act
    productBreadcrumbServiceExtensionHandler.updateContextMap(
        "https://example.org/example", params, holder);

    // Assert
    Map<String, Object> contextMap = holder.getContextMap();
    assertEquals(1, contextMap.size());
    assertEquals("https://example.org", contextMap.get("STRIPPED_URL"));
    assertTrue(params.isEmpty());
  }

  /**
   * Test {@link ProductBreadcrumbServiceExtensionHandler#updateContextMap(String, Map,
   * ExtensionResultHolder)}.
   *
   * <ul>
   *   <li>When {@code productId}.
   *   <li>Then {@link ExtensionResultHolder} (default constructor) ContextMap Empty.
   * </ul>
   *
   * <p>Method under test: {@link ProductBreadcrumbServiceExtensionHandler#updateContextMap(String,
   * Map, ExtensionResultHolder)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ProductBreadcrumbServiceExtensionHandler.updateContextMap(String, Map, ExtensionResultHolder)"
  })
  public void testUpdateContextMap_whenProductId_thenExtensionResultHolderContextMapEmpty() {
    // Arrange
    HashMap<String, String[]> params = new HashMap<>();

    ExtensionResultHolder<List<BreadcrumbDTO>> holder = new ExtensionResultHolder<>();
    holder.setResult(new ArrayList<>());
    holder.setThrowable(new Throwable());

    // Act
    productBreadcrumbServiceExtensionHandler.updateContextMap("productId", params, holder);

    // Assert that nothing has changed
    assertTrue(params.isEmpty());
    assertTrue(holder.getContextMap().isEmpty());
  }

  /**
   * Test {@link ProductBreadcrumbServiceExtensionHandler#getProductIdParam()}.
   *
   * <p>Method under test: {@link ProductBreadcrumbServiceExtensionHandler#getProductIdParam()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ProductBreadcrumbServiceExtensionHandler.getProductIdParam()"})
  public void testGetProductIdParam() {
    // Arrange, Act and Assert
    assertEquals("productId", new ProductBreadcrumbServiceExtensionHandler().getProductIdParam());
  }

  /**
   * Test {@link ProductBreadcrumbServiceExtensionHandler#getDefaultPriority()}.
   *
   * <p>Method under test: {@link ProductBreadcrumbServiceExtensionHandler#getDefaultPriority()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int ProductBreadcrumbServiceExtensionHandler.getDefaultPriority()"})
  public void testGetDefaultPriority() {
    // Arrange, Act and Assert
    assertEquals(4000, productBreadcrumbServiceExtensionHandler.getDefaultPriority());
  }
}
