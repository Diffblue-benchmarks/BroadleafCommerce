/*-
 * #%L
 * BroadleafCommerce Framework Web
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
package org.broadleafcommerce.core.web.breadcrumbs;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.broadleafcommerce.common.breadcrumbs.dto.BreadcrumbDTO;
import org.broadleafcommerce.common.extension.ExtensionResultHolder;
import org.broadleafcommerce.common.extension.ExtensionResultStatusType;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.core.catalog.domain.Product;
import org.broadleafcommerce.core.catalog.domain.ProductBundleImpl;
import org.broadleafcommerce.core.catalog.domain.SkuImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ProductBreadcrumbServiceExtensionHandlerDiffblueTest {
  /**
   * Test
   * {@link ProductBreadcrumbServiceExtensionHandler#modifyBreadcrumbList(String, Map, ExtensionResultHolder)}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()}.</li>
   *   <li>Then calls {@link ExtensionResultHolder#getContextMap()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ProductBreadcrumbServiceExtensionHandler#modifyBreadcrumbList(String, Map, ExtensionResultHolder)}
   */
  @Test
  @DisplayName("Test modifyBreadcrumbList(String, Map, ExtensionResultHolder); given HashMap(); then calls getContextMap()")
  void testModifyBreadcrumbList_givenHashMap_thenCallsGetContextMap() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductBreadcrumbServiceExtensionHandler productBreadcrumbServiceExtensionHandler = new ProductBreadcrumbServiceExtensionHandler();
    HashMap<String, String[]> params = new HashMap<>();
    ExtensionResultHolder<List<BreadcrumbDTO>> holder = mock(ExtensionResultHolder.class);
    when(holder.getContextMap()).thenReturn(new HashMap<>());
    doNothing().when(holder).setResult(Mockito.<List<BreadcrumbDTO>>any());
    doNothing().when(holder).setThrowable(Mockito.<Throwable>any());
    holder.setResult(new ArrayList<>());
    holder.setThrowable(new Throwable());

    // Act
    ExtensionResultStatusType actualModifyBreadcrumbListResult = productBreadcrumbServiceExtensionHandler
        .modifyBreadcrumbList("https://example.org/example", params, holder);

    // Assert
    verify(holder).getContextMap();
    verify(holder).setResult(isA(List.class));
    verify(holder).setThrowable(isA(Throwable.class));
    assertEquals(ExtensionResultStatusType.HANDLED_CONTINUE, actualModifyBreadcrumbListResult);
    assertTrue(params.isEmpty());
  }

  /**
   * Test
   * {@link ProductBreadcrumbServiceExtensionHandler#modifyBreadcrumbList(String, Map, ExtensionResultHolder)}.
   * <ul>
   *   <li>Then {@link ExtensionResultHolder} (default constructor) ContextMap
   * Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ProductBreadcrumbServiceExtensionHandler#modifyBreadcrumbList(String, Map, ExtensionResultHolder)}
   */
  @Test
  @DisplayName("Test modifyBreadcrumbList(String, Map, ExtensionResultHolder); then ExtensionResultHolder (default constructor) ContextMap Empty")
  void testModifyBreadcrumbList_thenExtensionResultHolderContextMapEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductBreadcrumbServiceExtensionHandler productBreadcrumbServiceExtensionHandler = new ProductBreadcrumbServiceExtensionHandler();
    HashMap<String, String[]> params = new HashMap<>();

    ExtensionResultHolder<List<BreadcrumbDTO>> holder = new ExtensionResultHolder<>();
    holder.setResult(new ArrayList<>());
    holder.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.HANDLED_CONTINUE, productBreadcrumbServiceExtensionHandler
        .modifyBreadcrumbList("ThreadLocalManager.notify.orphans", params, holder));
    assertTrue(params.isEmpty());
    assertTrue(holder.getContextMap().isEmpty());
  }

  /**
   * Test
   * {@link ProductBreadcrumbServiceExtensionHandler#modifyBreadcrumbList(String, Map, ExtensionResultHolder)}.
   * <ul>
   *   <li>Then {@link ExtensionResultHolder} (default constructor) ContextMap size
   * is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ProductBreadcrumbServiceExtensionHandler#modifyBreadcrumbList(String, Map, ExtensionResultHolder)}
   */
  @Test
  @DisplayName("Test modifyBreadcrumbList(String, Map, ExtensionResultHolder); then ExtensionResultHolder (default constructor) ContextMap size is one")
  void testModifyBreadcrumbList_thenExtensionResultHolderContextMapSizeIsOne() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductBreadcrumbServiceExtensionHandler productBreadcrumbServiceExtensionHandler = new ProductBreadcrumbServiceExtensionHandler();
    HashMap<String, String[]> params = new HashMap<>();

    ExtensionResultHolder<List<BreadcrumbDTO>> holder = new ExtensionResultHolder<>();
    holder.setResult(new ArrayList<>());
    holder.setThrowable(new Throwable());

    // Act
    productBreadcrumbServiceExtensionHandler.modifyBreadcrumbList("https://example.org/example", params, holder);

    // Assert
    Map<String, Object> contextMap = holder.getContextMap();
    assertEquals(1, contextMap.size());
    assertEquals("https://example.org", contextMap.get("STRIPPED_URL"));
    assertTrue(params.isEmpty());
  }

  /**
   * Test
   * {@link ProductBreadcrumbServiceExtensionHandler#modifyBreadcrumbList(String, Map, ExtensionResultHolder)}.
   * <ul>
   *   <li>Then {@link ExtensionResultHolder} (default constructor) ContextMap size
   * is two.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ProductBreadcrumbServiceExtensionHandler#modifyBreadcrumbList(String, Map, ExtensionResultHolder)}
   */
  @Test
  @DisplayName("Test modifyBreadcrumbList(String, Map, ExtensionResultHolder); then ExtensionResultHolder (default constructor) ContextMap size is two")
  void testModifyBreadcrumbList_thenExtensionResultHolderContextMapSizeIsTwo() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductBreadcrumbServiceExtensionHandler productBreadcrumbServiceExtensionHandler = new ProductBreadcrumbServiceExtensionHandler();

    HashMap<String, String[]> params = new HashMap<>();
    params.put("productId", new String[]{"Params"});

    ExtensionResultHolder<List<BreadcrumbDTO>> holder = new ExtensionResultHolder<>();
    holder.setThrowable(new Throwable());
    holder.setResult(new ArrayList<>());

    // Act
    productBreadcrumbServiceExtensionHandler.modifyBreadcrumbList("https://example.org/example", params, holder);

    // Assert
    Map<String, Object> contextMap = holder.getContextMap();
    assertEquals(2, contextMap.size());
    assertTrue(params.isEmpty());
    assertTrue(contextMap.containsKey("STRIPPED_URL"));
    assertSame(params, contextMap.get("STRIPPED_PARAMS"));
  }

  /**
   * Test
   * {@link ProductBreadcrumbServiceExtensionHandler#modifyBreadcrumbList(String, Map, ExtensionResultHolder)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ProductBreadcrumbServiceExtensionHandler#modifyBreadcrumbList(String, Map, ExtensionResultHolder)}
   */
  @Test
  @DisplayName("Test modifyBreadcrumbList(String, Map, ExtensionResultHolder); when 'null'; then 'null'")
  void testModifyBreadcrumbList_whenNull_thenNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductBreadcrumbServiceExtensionHandler productBreadcrumbServiceExtensionHandler = new ProductBreadcrumbServiceExtensionHandler();

    ExtensionResultHolder<List<BreadcrumbDTO>> holder = new ExtensionResultHolder<>();
    holder.setThrowable(new Throwable());
    holder.setResult(new ArrayList<>());

    // Act
    productBreadcrumbServiceExtensionHandler.modifyBreadcrumbList("https://example.org/example", null, holder);

    // Assert
    Map<String, Object> contextMap = holder.getContextMap();
    assertEquals(1, contextMap.size());
    assertEquals("https://example.org", contextMap.get("STRIPPED_URL"));
    assertNull(null);
  }

  /**
   * Test
   * {@link ProductBreadcrumbServiceExtensionHandler#determineProduct(String, Map, ExtensionResultHolder)}.
   * <ul>
   *   <li>Then calls {@link ExtensionResultHolder#setResult(Object)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ProductBreadcrumbServiceExtensionHandler#determineProduct(String, Map, ExtensionResultHolder)}
   */
  @Test
  @DisplayName("Test determineProduct(String, Map, ExtensionResultHolder); then calls setResult(Object)")
  void testDetermineProduct_thenCallsSetResult() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductBreadcrumbServiceExtensionHandler productBreadcrumbServiceExtensionHandler = new ProductBreadcrumbServiceExtensionHandler();
    HashMap<String, String[]> params = new HashMap<>();
    ExtensionResultHolder<List<BreadcrumbDTO>> holder = mock(ExtensionResultHolder.class);
    doNothing().when(holder).setResult(Mockito.<List<BreadcrumbDTO>>any());
    doNothing().when(holder).setThrowable(Mockito.<Throwable>any());
    holder.setResult(new ArrayList<>());
    holder.setThrowable(new Throwable());

    // Act
    Product actualDetermineProductResult = productBreadcrumbServiceExtensionHandler
        .determineProduct("https://example.org/example", params, holder);

    // Assert
    verify(holder).setResult(isA(List.class));
    verify(holder).setThrowable(isA(Throwable.class));
    assertNull(actualDetermineProductResult);
  }

  /**
   * Test
   * {@link ProductBreadcrumbServiceExtensionHandler#determineProduct(String, Map, ExtensionResultHolder)}.
   * <ul>
   *   <li>When {@link ExtensionResultHolder} (default constructor) Result is
   * {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ProductBreadcrumbServiceExtensionHandler#determineProduct(String, Map, ExtensionResultHolder)}
   */
  @Test
  @DisplayName("Test determineProduct(String, Map, ExtensionResultHolder); when ExtensionResultHolder (default constructor) Result is ArrayList()")
  void testDetermineProduct_whenExtensionResultHolderResultIsArrayList() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductBreadcrumbServiceExtensionHandler productBreadcrumbServiceExtensionHandler = new ProductBreadcrumbServiceExtensionHandler();
    HashMap<String, String[]> params = new HashMap<>();

    ExtensionResultHolder<List<BreadcrumbDTO>> holder = new ExtensionResultHolder<>();
    holder.setResult(new ArrayList<>());
    holder.setThrowable(new Throwable());

    // Act and Assert
    assertNull(
        productBreadcrumbServiceExtensionHandler.determineProduct("https://example.org/example", params, holder));
  }

  /**
   * Test
   * {@link ProductBreadcrumbServiceExtensionHandler#getNameForProductLink(Product)}.
   * <ul>
   *   <li>Given {@code Name}.</li>
   *   <li>Then return {@code Name}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ProductBreadcrumbServiceExtensionHandler#getNameForProductLink(Product)}
   */
  @Test
  @DisplayName("Test getNameForProductLink(Product); given 'Name'; then return 'Name'")
  void testGetNameForProductLink_givenName_thenReturnName() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductBreadcrumbServiceExtensionHandler productBreadcrumbServiceExtensionHandler = new ProductBreadcrumbServiceExtensionHandler();
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getName()).thenReturn("Name");

    // Act
    String actualNameForProductLink = productBreadcrumbServiceExtensionHandler.getNameForProductLink(product);

    // Assert
    verify(product).getName();
    assertEquals("Name", actualNameForProductLink);
  }

  /**
   * Test
   * {@link ProductBreadcrumbServiceExtensionHandler#getNameForProductLink(Product)}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) SalePrice is
   * {@link Money#Money()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ProductBreadcrumbServiceExtensionHandler#getNameForProductLink(Product)}
   */
  @Test
  @DisplayName("Test getNameForProductLink(Product); given SkuImpl (default constructor) SalePrice is Money(); then return 'null'")
  void testGetNameForProductLink_givenSkuImplSalePriceIsMoney_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductBreadcrumbServiceExtensionHandler productBreadcrumbServiceExtensionHandler = new ProductBreadcrumbServiceExtensionHandler();

    SkuImpl defaultSku = new SkuImpl();
    defaultSku.setSalePrice(new Money());

    ProductBundleImpl product = new ProductBundleImpl();
    product.setDefaultSku(defaultSku);

    // Act and Assert
    assertNull(productBreadcrumbServiceExtensionHandler.getNameForProductLink(product));
  }

  /**
   * Test
   * {@link ProductBreadcrumbServiceExtensionHandler#getNameForProductLink(Product)}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ProductBreadcrumbServiceExtensionHandler#getNameForProductLink(Product)}
   */
  @Test
  @DisplayName("Test getNameForProductLink(Product); given SkuImpl (default constructor); then return 'null'")
  void testGetNameForProductLink_givenSkuImpl_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductBreadcrumbServiceExtensionHandler productBreadcrumbServiceExtensionHandler = new ProductBreadcrumbServiceExtensionHandler();

    ProductBundleImpl product = new ProductBundleImpl();
    product.setDefaultSku(new SkuImpl());

    // Act and Assert
    assertNull(productBreadcrumbServiceExtensionHandler.getNameForProductLink(product));
  }

  /**
   * Test
   * {@link ProductBreadcrumbServiceExtensionHandler#updateContextMap(String, Map, ExtensionResultHolder)}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()}.</li>
   *   <li>Then calls {@link ExtensionResultHolder#getContextMap()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ProductBreadcrumbServiceExtensionHandler#updateContextMap(String, Map, ExtensionResultHolder)}
   */
  @Test
  @DisplayName("Test updateContextMap(String, Map, ExtensionResultHolder); given HashMap(); then calls getContextMap()")
  void testUpdateContextMap_givenHashMap_thenCallsGetContextMap() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductBreadcrumbServiceExtensionHandler productBreadcrumbServiceExtensionHandler = new ProductBreadcrumbServiceExtensionHandler();
    HashMap<String, String[]> params = new HashMap<>();
    ExtensionResultHolder<List<BreadcrumbDTO>> holder = mock(ExtensionResultHolder.class);
    when(holder.getContextMap()).thenReturn(new HashMap<>());
    doNothing().when(holder).setResult(Mockito.<List<BreadcrumbDTO>>any());
    doNothing().when(holder).setThrowable(Mockito.<Throwable>any());
    holder.setResult(new ArrayList<>());
    holder.setThrowable(new Throwable());

    // Act
    productBreadcrumbServiceExtensionHandler.updateContextMap("https://example.org/example", params, holder);

    // Assert
    verify(holder).getContextMap();
    verify(holder).setResult(isA(List.class));
    verify(holder).setThrowable(isA(Throwable.class));
    assertTrue(params.isEmpty());
  }

  /**
   * Test
   * {@link ProductBreadcrumbServiceExtensionHandler#updateContextMap(String, Map, ExtensionResultHolder)}.
   * <ul>
   *   <li>Given {@code productId}.</li>
   *   <li>Then {@link ExtensionResultHolder} (default constructor) ContextMap size
   * is two.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ProductBreadcrumbServiceExtensionHandler#updateContextMap(String, Map, ExtensionResultHolder)}
   */
  @Test
  @DisplayName("Test updateContextMap(String, Map, ExtensionResultHolder); given 'productId'; then ExtensionResultHolder (default constructor) ContextMap size is two")
  void testUpdateContextMap_givenProductId_thenExtensionResultHolderContextMapSizeIsTwo() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductBreadcrumbServiceExtensionHandler productBreadcrumbServiceExtensionHandler = new ProductBreadcrumbServiceExtensionHandler();

    HashMap<String, String[]> params = new HashMap<>();
    params.put("productId", new String[]{"Params"});

    ExtensionResultHolder<List<BreadcrumbDTO>> holder = new ExtensionResultHolder<>();
    holder.setResult(new ArrayList<>());
    holder.setThrowable(new Throwable());

    // Act
    productBreadcrumbServiceExtensionHandler.updateContextMap("https://example.org/example", params, holder);

    // Assert
    Map<String, Object> contextMap = holder.getContextMap();
    assertEquals(2, contextMap.size());
    assertTrue(params.isEmpty());
    assertTrue(contextMap.containsKey("STRIPPED_URL"));
    assertSame(params, contextMap.get("STRIPPED_PARAMS"));
  }

  /**
   * Test
   * {@link ProductBreadcrumbServiceExtensionHandler#updateContextMap(String, Map, ExtensionResultHolder)}.
   * <ul>
   *   <li>Then {@link ExtensionResultHolder} (default constructor) ContextMap size
   * is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ProductBreadcrumbServiceExtensionHandler#updateContextMap(String, Map, ExtensionResultHolder)}
   */
  @Test
  @DisplayName("Test updateContextMap(String, Map, ExtensionResultHolder); then ExtensionResultHolder (default constructor) ContextMap size is one")
  void testUpdateContextMap_thenExtensionResultHolderContextMapSizeIsOne() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductBreadcrumbServiceExtensionHandler productBreadcrumbServiceExtensionHandler = new ProductBreadcrumbServiceExtensionHandler();
    HashMap<String, String[]> params = new HashMap<>();

    ExtensionResultHolder<List<BreadcrumbDTO>> holder = new ExtensionResultHolder<>();
    holder.setResult(new ArrayList<>());
    holder.setThrowable(new Throwable());

    // Act
    productBreadcrumbServiceExtensionHandler.updateContextMap("https://example.org/example", params, holder);

    // Assert
    Map<String, Object> contextMap = holder.getContextMap();
    assertEquals(1, contextMap.size());
    assertEquals("https://example.org", contextMap.get("STRIPPED_URL"));
    assertTrue(params.isEmpty());
  }

  /**
   * Test
   * {@link ProductBreadcrumbServiceExtensionHandler#updateContextMap(String, Map, ExtensionResultHolder)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ProductBreadcrumbServiceExtensionHandler#updateContextMap(String, Map, ExtensionResultHolder)}
   */
  @Test
  @DisplayName("Test updateContextMap(String, Map, ExtensionResultHolder); when 'null'; then 'null'")
  void testUpdateContextMap_whenNull_thenNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductBreadcrumbServiceExtensionHandler productBreadcrumbServiceExtensionHandler = new ProductBreadcrumbServiceExtensionHandler();

    ExtensionResultHolder<List<BreadcrumbDTO>> holder = new ExtensionResultHolder<>();
    holder.setResult(new ArrayList<>());
    holder.setThrowable(new Throwable());

    // Act
    productBreadcrumbServiceExtensionHandler.updateContextMap("https://example.org/example", null, holder);

    // Assert
    Map<String, Object> contextMap = holder.getContextMap();
    assertEquals(1, contextMap.size());
    assertEquals("https://example.org", contextMap.get("STRIPPED_URL"));
    assertNull(null);
  }

  /**
   * Test
   * {@link ProductBreadcrumbServiceExtensionHandler#updateContextMap(String, Map, ExtensionResultHolder)}.
   * <ul>
   *   <li>When {@code productId}.</li>
   *   <li>Then {@link ExtensionResultHolder} (default constructor) ContextMap
   * Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ProductBreadcrumbServiceExtensionHandler#updateContextMap(String, Map, ExtensionResultHolder)}
   */
  @Test
  @DisplayName("Test updateContextMap(String, Map, ExtensionResultHolder); when 'productId'; then ExtensionResultHolder (default constructor) ContextMap Empty")
  void testUpdateContextMap_whenProductId_thenExtensionResultHolderContextMapEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductBreadcrumbServiceExtensionHandler productBreadcrumbServiceExtensionHandler = new ProductBreadcrumbServiceExtensionHandler();
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
   * <p>
   * Method under test:
   * {@link ProductBreadcrumbServiceExtensionHandler#getProductIdParam()}
   */
  @Test
  @DisplayName("Test getProductIdParam()")
  void testGetProductIdParam() {
    // Arrange, Act and Assert
    assertEquals("productId", (new ProductBreadcrumbServiceExtensionHandler()).getProductIdParam());
  }

  /**
   * Test {@link ProductBreadcrumbServiceExtensionHandler#getDefaultPriority()}.
   * <p>
   * Method under test:
   * {@link ProductBreadcrumbServiceExtensionHandler#getDefaultPriority()}
   */
  @Test
  @DisplayName("Test getDefaultPriority()")
  void testGetDefaultPriority() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals(4000, (new ProductBreadcrumbServiceExtensionHandler()).getDefaultPriority());
  }
}
