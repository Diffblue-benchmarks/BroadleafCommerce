/*-
 * #%L
 * BroadleafCommerce Framework Web
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
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ProductBreadcrumbServiceExtensionHandlerDiffblueTest {
  /**
   * Method under test:
   * {@link ProductBreadcrumbServiceExtensionHandler#modifyBreadcrumbList(String, Map, ExtensionResultHolder)}
   */
  @Test
  void testModifyBreadcrumbList() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductBreadcrumbServiceExtensionHandler productBreadcrumbServiceExtensionHandler = new ProductBreadcrumbServiceExtensionHandler();
    HashMap<String, String[]> params = new HashMap<>();

    ExtensionResultHolder<List<BreadcrumbDTO>> holder = new ExtensionResultHolder<>();
    holder.setResult(new ArrayList<>());
    holder.setThrowable(new Throwable());

    // Act
    ExtensionResultStatusType actualModifyBreadcrumbListResult = productBreadcrumbServiceExtensionHandler
        .modifyBreadcrumbList("https://example.org/example", params, holder);

    // Assert
    Map<String, Object> contextMap = holder.getContextMap();
    assertEquals(1, contextMap.size());
    assertEquals("https://example.org", contextMap.get("STRIPPED_URL"));
    assertEquals(ExtensionResultStatusType.HANDLED_CONTINUE, actualModifyBreadcrumbListResult);
    assertTrue(params.isEmpty());
  }

  /**
   * Method under test:
   * {@link ProductBreadcrumbServiceExtensionHandler#modifyBreadcrumbList(String, Map, ExtensionResultHolder)}
   */
  @Test
  void testModifyBreadcrumbList2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductBreadcrumbServiceExtensionHandler productBreadcrumbServiceExtensionHandler = new ProductBreadcrumbServiceExtensionHandler();

    ExtensionResultHolder<List<BreadcrumbDTO>> holder = new ExtensionResultHolder<>();
    holder.setThrowable(new Throwable());
    holder.setResult(new ArrayList<>());

    // Act
    ExtensionResultStatusType actualModifyBreadcrumbListResult = productBreadcrumbServiceExtensionHandler
        .modifyBreadcrumbList("https://example.org/example", null, holder);

    // Assert
    Map<String, Object> contextMap = holder.getContextMap();
    assertEquals(1, contextMap.size());
    assertEquals("https://example.org", contextMap.get("STRIPPED_URL"));
    assertEquals(ExtensionResultStatusType.HANDLED_CONTINUE, actualModifyBreadcrumbListResult);
  }

  /**
   * Method under test:
   * {@link ProductBreadcrumbServiceExtensionHandler#modifyBreadcrumbList(String, Map, ExtensionResultHolder)}
   */
  @Test
  void testModifyBreadcrumbList3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductBreadcrumbServiceExtensionHandler productBreadcrumbServiceExtensionHandler = new ProductBreadcrumbServiceExtensionHandler();

    HashMap<String, String[]> params = new HashMap<>();
    params.put("productId", new String[]{"Params"});

    ExtensionResultHolder<List<BreadcrumbDTO>> holder = new ExtensionResultHolder<>();
    holder.setThrowable(new Throwable());
    holder.setResult(new ArrayList<>());

    // Act
    ExtensionResultStatusType actualModifyBreadcrumbListResult = productBreadcrumbServiceExtensionHandler
        .modifyBreadcrumbList("https://example.org/example", params, holder);

    // Assert
    Map<String, Object> contextMap = holder.getContextMap();
    assertEquals(2, contextMap.size());
    assertEquals("https://example.org", contextMap.get("STRIPPED_URL"));
    assertEquals(ExtensionResultStatusType.HANDLED_CONTINUE, actualModifyBreadcrumbListResult);
    assertTrue(params.isEmpty());
    assertSame(params, contextMap.get("STRIPPED_PARAMS"));
  }

  /**
   * Method under test:
   * {@link ProductBreadcrumbServiceExtensionHandler#modifyBreadcrumbList(String, Map, ExtensionResultHolder)}
   */
  @Test
  void testModifyBreadcrumbList4() {
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
   * Method under test:
   * {@link ProductBreadcrumbServiceExtensionHandler#modifyBreadcrumbList(String, Map, ExtensionResultHolder)}
   */
  @Test
  void testModifyBreadcrumbList5() {
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
   * Method under test:
   * {@link ProductBreadcrumbServiceExtensionHandler#determineProduct(String, Map, ExtensionResultHolder)}
   */
  @Test
  void testDetermineProduct() {
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
   * Method under test:
   * {@link ProductBreadcrumbServiceExtensionHandler#determineProduct(String, Map, ExtensionResultHolder)}
   */
  @Test
  void testDetermineProduct2() {
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
   * Method under test:
   * {@link ProductBreadcrumbServiceExtensionHandler#getNameForProductLink(Product)}
   */
  @Test
  void testGetNameForProductLink() {
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
   * Method under test:
   * {@link ProductBreadcrumbServiceExtensionHandler#getNameForProductLink(Product)}
   */
  @Test
  void testGetNameForProductLink2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductBreadcrumbServiceExtensionHandler productBreadcrumbServiceExtensionHandler = new ProductBreadcrumbServiceExtensionHandler();

    ProductBundleImpl product = new ProductBundleImpl();
    product.setDefaultSku(new SkuImpl());

    // Act and Assert
    assertNull(productBreadcrumbServiceExtensionHandler.getNameForProductLink(product));
  }

  /**
   * Method under test:
   * {@link ProductBreadcrumbServiceExtensionHandler#getNameForProductLink(Product)}
   */
  @Test
  void testGetNameForProductLink3() {
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
   * Method under test:
   * {@link ProductBreadcrumbServiceExtensionHandler#updateContextMap(String, Map, ExtensionResultHolder)}
   */
  @Test
  void testUpdateContextMap() {
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
   * Method under test:
   * {@link ProductBreadcrumbServiceExtensionHandler#updateContextMap(String, Map, ExtensionResultHolder)}
   */
  @Test
  void testUpdateContextMap2() {
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
  }

  /**
   * Method under test:
   * {@link ProductBreadcrumbServiceExtensionHandler#updateContextMap(String, Map, ExtensionResultHolder)}
   */
  @Test
  void testUpdateContextMap3() {
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
    assertEquals("https://example.org", contextMap.get("STRIPPED_URL"));
    assertTrue(params.isEmpty());
    assertSame(params, contextMap.get("STRIPPED_PARAMS"));
  }

  /**
   * Method under test:
   * {@link ProductBreadcrumbServiceExtensionHandler#updateContextMap(String, Map, ExtensionResultHolder)}
   */
  @Test
  void testUpdateContextMap4() {
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
   * Method under test:
   * {@link ProductBreadcrumbServiceExtensionHandler#updateContextMap(String, Map, ExtensionResultHolder)}
   */
  @Test
  void testUpdateContextMap5() {
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
   * Method under test:
   * {@link ProductBreadcrumbServiceExtensionHandler#getProductIdParam()}
   */
  @Test
  void testGetProductIdParam() {
    // Arrange, Act and Assert
    assertEquals("productId", (new ProductBreadcrumbServiceExtensionHandler()).getProductIdParam());
  }

  /**
   * Method under test:
   * {@link ProductBreadcrumbServiceExtensionHandler#getDefaultPriority()}
   */
  @Test
  void testGetDefaultPriority() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals(4000, (new ProductBreadcrumbServiceExtensionHandler()).getDefaultPriority());
  }
}
