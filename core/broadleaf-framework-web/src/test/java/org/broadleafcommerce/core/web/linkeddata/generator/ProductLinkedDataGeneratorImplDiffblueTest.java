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
package org.broadleafcommerce.core.web.linkeddata.generator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import org.broadleafcommerce.common.media.domain.Media;
import org.broadleafcommerce.common.media.domain.MediaDto;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.common.web.BaseUrlResolver;
import org.broadleafcommerce.core.catalog.domain.CategoryImpl;
import org.broadleafcommerce.core.catalog.domain.Product;
import org.broadleafcommerce.core.catalog.domain.ProductBundleImpl;
import org.broadleafcommerce.core.catalog.domain.ProductImpl;
import org.broadleafcommerce.core.catalog.domain.Sku;
import org.broadleafcommerce.core.catalog.domain.SkuImpl;
import org.broadleafcommerce.core.inventory.service.type.InventoryType;
import org.broadleafcommerce.core.web.search.SearchRequestWrapper;
import org.broadleafcommerce.core.web.security.XssRequestWrapper;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.web.reactive.context.StandardReactiveWebEnvironment;
import org.springframework.core.env.Environment;
import org.springframework.core.env.PropertyResolver;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.multipart.support.DefaultMultipartHttpServletRequest;

@ExtendWith(MockitoExtension.class)
class ProductLinkedDataGeneratorImplDiffblueTest {
  @InjectMocks
  private ProductLinkedDataGeneratorImpl productLinkedDataGeneratorImpl;

  @Mock
  private Environment environment;

  @Mock
  private LinkedDataGeneratorExtensionManager linkedDataGeneratorExtensionManager;

  @Mock
  private BaseUrlResolver baseUrlResolver;

  /**
   * Test {@link ProductLinkedDataGeneratorImpl#canHandle(HttpServletRequest)}.
   * <ul>
   *   <li>Given {@code Attribute}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductLinkedDataGeneratorImpl#canHandle(HttpServletRequest)}
   */
  @Test
  @DisplayName("Test canHandle(HttpServletRequest); given 'Attribute'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ProductLinkedDataGeneratorImpl.canHandle(HttpServletRequest)"})
  void testCanHandle_givenAttribute_thenReturnTrue() {
    // Arrange
    DefaultMultipartHttpServletRequest servletRequest = mock(DefaultMultipartHttpServletRequest.class);
    when(servletRequest.getAttribute(Mockito.<String>any())).thenReturn("Attribute");

    // Act
    boolean actualCanHandleResult = productLinkedDataGeneratorImpl.canHandle(new SearchRequestWrapper(
        new XssRequestWrapper(servletRequest, environment, new String[]{"White List Param Names"})));

    // Assert
    verify(servletRequest).getAttribute(eq("currentProduct"));
    assertTrue(actualCanHandleResult);
  }

  /**
   * Test {@link ProductLinkedDataGeneratorImpl#canHandle(HttpServletRequest)}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductLinkedDataGeneratorImpl#canHandle(HttpServletRequest)}
   */
  @Test
  @DisplayName("Test canHandle(HttpServletRequest); then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ProductLinkedDataGeneratorImpl.canHandle(HttpServletRequest)"})
  void testCanHandle_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(productLinkedDataGeneratorImpl.canHandle(new SearchRequestWrapper(
        new XssRequestWrapper(new MockHttpServletRequest(), environment, new String[]{"White List Param Names"}))));
  }

  /**
   * Test {@link ProductLinkedDataGeneratorImpl#addProductData(HttpServletRequest, Product, String)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return RecursionDepthLimit is five hundred.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductLinkedDataGeneratorImpl#addProductData(HttpServletRequest, Product, String)}
   */
  @Test
  @DisplayName("Test addProductData(HttpServletRequest, Product, String); given ArrayList(); then return RecursionDepthLimit is five hundred")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JSONObject ProductLinkedDataGeneratorImpl.addProductData(HttpServletRequest, Product, String)"})
  void testAddProductData_givenArrayList_thenReturnRecursionDepthLimitIsFiveHundred() throws JSONException {
    // Arrange
    when(linkedDataGeneratorExtensionManager.getProxy()).thenReturn(new DefaultLinkedDataGeneratorExtensionHandler());
    SearchRequestWrapper request = new SearchRequestWrapper(
        new XssRequestWrapper(new MockHttpServletRequest(), environment, new String[]{"White List Param Names"}));
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getAllSellableSkus()).thenReturn(new ArrayList<>());
    when(product.getRetailPrice()).thenReturn(new Money());
    when(product.getCategory()).thenReturn(new CategoryImpl());
    when(product.getLongDescription()).thenReturn("Long Description");
    when(product.getManufacturer()).thenReturn("Manufacturer");
    when(product.getName()).thenReturn("Name");
    when(product.getMedia()).thenReturn(new HashMap<>());
    when(product.getDefaultSku()).thenReturn(new SkuImpl());

    // Act
    JSONObject actualAddProductDataResult = productLinkedDataGeneratorImpl.addProductData(request, product,
        "https://example.org/example");

    // Assert
    verify(linkedDataGeneratorExtensionManager).getProxy();
    verify(product).getRetailPrice();
    verify(product).getAllSellableSkus();
    verify(product).getCategory();
    verify(product).getDefaultSku();
    verify(product).getLongDescription();
    verify(product).getManufacturer();
    verify(product).getMedia();
    verify(product).getName();
    assertEquals(500, actualAddProductDataResult.getRecursionDepthLimit());
    assertEquals(7, actualAddProductDataResult.length());
    assertTrue(actualAddProductDataResult.isEscapeForwardSlashAlways());
  }

  /**
   * Test {@link ProductLinkedDataGeneratorImpl#addProductData(HttpServletRequest, Product, String)}.
   * <ul>
   *   <li>Given {@link Money} {@link Money#greaterThan(BigDecimal)} return {@code true}.</li>
   *   <li>Then calls {@link Money#getAmount()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductLinkedDataGeneratorImpl#addProductData(HttpServletRequest, Product, String)}
   */
  @Test
  @DisplayName("Test addProductData(HttpServletRequest, Product, String); given Money greaterThan(BigDecimal) return 'true'; then calls getAmount()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JSONObject ProductLinkedDataGeneratorImpl.addProductData(HttpServletRequest, Product, String)"})
  void testAddProductData_givenMoneyGreaterThanReturnTrue_thenCallsGetAmount() throws JSONException {
    // Arrange
    when(linkedDataGeneratorExtensionManager.getProxy()).thenReturn(new DefaultLinkedDataGeneratorExtensionHandler());
    SearchRequestWrapper request = new SearchRequestWrapper(
        new XssRequestWrapper(new MockHttpServletRequest(), environment, new String[]{"White List Param Names"}));

    ArrayList<Sku> skuList = new ArrayList<>();
    skuList.add(new SkuImpl());
    Money money = mock(Money.class);
    when(money.greaterThan(Mockito.<BigDecimal>any())).thenReturn(true);
    when(money.getAmount()).thenReturn(new BigDecimal("2.3"));
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getPrice()).thenReturn(money);
    when(product.getAllSellableSkus()).thenReturn(skuList);
    when(product.getRetailPrice()).thenReturn(new Money());
    when(product.getCategory()).thenReturn(new CategoryImpl());
    when(product.getLongDescription()).thenReturn("Long Description");
    when(product.getManufacturer()).thenReturn("Manufacturer");
    when(product.getName()).thenReturn("Name");
    when(product.getMedia()).thenReturn(new HashMap<>());
    when(product.getDefaultSku()).thenReturn(new SkuImpl());

    // Act
    JSONObject actualAddProductDataResult = productLinkedDataGeneratorImpl.addProductData(request, product,
        "https://example.org/example");

    // Assert
    verify(linkedDataGeneratorExtensionManager, atLeast(1)).getProxy();
    verify(money, atLeast(1)).getAmount();
    verify(money).greaterThan(isA(BigDecimal.class));
    verify(product).getRetailPrice();
    verify(product).getAllSellableSkus();
    verify(product, atLeast(1)).getCategory();
    verify(product).getDefaultSku();
    verify(product).getLongDescription();
    verify(product).getManufacturer();
    verify(product).getMedia();
    verify(product).getName();
    verify(product).getPrice();
    assertEquals(500, actualAddProductDataResult.getRecursionDepthLimit());
    assertEquals(7, actualAddProductDataResult.length());
    assertTrue(actualAddProductDataResult.isEscapeForwardSlashAlways());
  }

  /**
   * Test {@link ProductLinkedDataGeneratorImpl#addProductData(HttpServletRequest, Product, String)}.
   * <ul>
   *   <li>Given {@link Money} {@link Money#lessThan(BigDecimal)} return {@code true}.</li>
   *   <li>Then calls {@link Money#lessThan(BigDecimal)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductLinkedDataGeneratorImpl#addProductData(HttpServletRequest, Product, String)}
   */
  @Test
  @DisplayName("Test addProductData(HttpServletRequest, Product, String); given Money lessThan(BigDecimal) return 'true'; then calls lessThan(BigDecimal)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JSONObject ProductLinkedDataGeneratorImpl.addProductData(HttpServletRequest, Product, String)"})
  void testAddProductData_givenMoneyLessThanReturnTrue_thenCallsLessThan() throws JSONException {
    // Arrange
    when(linkedDataGeneratorExtensionManager.getProxy()).thenReturn(new DefaultLinkedDataGeneratorExtensionHandler());
    SearchRequestWrapper request = new SearchRequestWrapper(
        new XssRequestWrapper(new MockHttpServletRequest(), environment, new String[]{"White List Param Names"}));

    ArrayList<Sku> skuList = new ArrayList<>();
    skuList.add(new SkuImpl());
    skuList.add(new SkuImpl());
    Money money = mock(Money.class);
    when(money.lessThan(Mockito.<BigDecimal>any())).thenReturn(true);
    when(money.greaterThan(Mockito.<BigDecimal>any())).thenReturn(true);
    when(money.getAmount()).thenReturn(new BigDecimal("2.3"));
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getPrice()).thenReturn(money);
    when(product.getAllSellableSkus()).thenReturn(skuList);
    when(product.getRetailPrice()).thenReturn(new Money());
    when(product.getCategory()).thenReturn(new CategoryImpl());
    when(product.getLongDescription()).thenReturn("Long Description");
    when(product.getManufacturer()).thenReturn("Manufacturer");
    when(product.getName()).thenReturn("Name");
    when(product.getMedia()).thenReturn(new HashMap<>());
    when(product.getDefaultSku()).thenReturn(new SkuImpl());

    // Act
    JSONObject actualAddProductDataResult = productLinkedDataGeneratorImpl.addProductData(request, product,
        "https://example.org/example");

    // Assert
    verify(linkedDataGeneratorExtensionManager, atLeast(1)).getProxy();
    verify(money, atLeast(1)).getAmount();
    verify(money, atLeast(1)).greaterThan(Mockito.<BigDecimal>any());
    verify(money).lessThan(isA(BigDecimal.class));
    verify(product).getRetailPrice();
    verify(product).getAllSellableSkus();
    verify(product, atLeast(1)).getCategory();
    verify(product).getDefaultSku();
    verify(product).getLongDescription();
    verify(product).getManufacturer();
    verify(product).getMedia();
    verify(product).getName();
    verify(product, atLeast(1)).getPrice();
    assertEquals(500, actualAddProductDataResult.getRecursionDepthLimit());
    assertEquals(7, actualAddProductDataResult.length());
    assertTrue(actualAddProductDataResult.isEscapeForwardSlashAlways());
  }

  /**
   * Test {@link ProductLinkedDataGeneratorImpl#addProductData(HttpServletRequest, Product, String)}.
   * <ul>
   *   <li>Given {@link Money#Money(double)} with amount is ten.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductLinkedDataGeneratorImpl#addProductData(HttpServletRequest, Product, String)}
   */
  @Test
  @DisplayName("Test addProductData(HttpServletRequest, Product, String); given Money(double) with amount is ten")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JSONObject ProductLinkedDataGeneratorImpl.addProductData(HttpServletRequest, Product, String)"})
  void testAddProductData_givenMoneyWithAmountIsTen() throws JSONException {
    // Arrange
    when(linkedDataGeneratorExtensionManager.getProxy()).thenReturn(new DefaultLinkedDataGeneratorExtensionHandler());
    SearchRequestWrapper request = new SearchRequestWrapper(
        new XssRequestWrapper(new MockHttpServletRequest(), environment, new String[]{"White List Param Names"}));

    ArrayList<Sku> skuList = new ArrayList<>();
    skuList.add(new SkuImpl());
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getPrice()).thenReturn(new Money(10.0d));
    when(product.getAllSellableSkus()).thenReturn(skuList);
    when(product.getRetailPrice()).thenReturn(new Money());
    when(product.getCategory()).thenReturn(new CategoryImpl());
    when(product.getLongDescription()).thenReturn("Long Description");
    when(product.getManufacturer()).thenReturn("Manufacturer");
    when(product.getName()).thenReturn("Name");
    when(product.getMedia()).thenReturn(new HashMap<>());
    when(product.getDefaultSku()).thenReturn(new SkuImpl());

    // Act
    JSONObject actualAddProductDataResult = productLinkedDataGeneratorImpl.addProductData(request, product,
        "https://example.org/example");

    // Assert
    verify(linkedDataGeneratorExtensionManager, atLeast(1)).getProxy();
    verify(product).getRetailPrice();
    verify(product).getAllSellableSkus();
    verify(product, atLeast(1)).getCategory();
    verify(product).getDefaultSku();
    verify(product).getLongDescription();
    verify(product).getManufacturer();
    verify(product).getMedia();
    verify(product).getName();
    verify(product).getPrice();
    assertEquals(500, actualAddProductDataResult.getRecursionDepthLimit());
    assertEquals(7, actualAddProductDataResult.length());
    assertTrue(actualAddProductDataResult.isEscapeForwardSlashAlways());
  }

  /**
   * Test {@link ProductLinkedDataGeneratorImpl#addProductData(HttpServletRequest, Product, String)}.
   * <ul>
   *   <li>When {@link ProductBundleImpl} {@link ProductImpl#getPrice()} return {@link Money#Money()}.</li>
   *   <li>Then calls {@link ProductImpl#getPrice()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductLinkedDataGeneratorImpl#addProductData(HttpServletRequest, Product, String)}
   */
  @Test
  @DisplayName("Test addProductData(HttpServletRequest, Product, String); when ProductBundleImpl getPrice() return Money(); then calls getPrice()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JSONObject ProductLinkedDataGeneratorImpl.addProductData(HttpServletRequest, Product, String)"})
  void testAddProductData_whenProductBundleImplGetPriceReturnMoney_thenCallsGetPrice() throws JSONException {
    // Arrange
    when(linkedDataGeneratorExtensionManager.getProxy()).thenReturn(new DefaultLinkedDataGeneratorExtensionHandler());
    SearchRequestWrapper request = new SearchRequestWrapper(
        new XssRequestWrapper(new MockHttpServletRequest(), environment, new String[]{"White List Param Names"}));

    ArrayList<Sku> skuList = new ArrayList<>();
    skuList.add(new SkuImpl());
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getPrice()).thenReturn(new Money());
    when(product.getAllSellableSkus()).thenReturn(skuList);
    when(product.getRetailPrice()).thenReturn(new Money());
    when(product.getCategory()).thenReturn(new CategoryImpl());
    when(product.getLongDescription()).thenReturn("Long Description");
    when(product.getManufacturer()).thenReturn("Manufacturer");
    when(product.getName()).thenReturn("Name");
    when(product.getMedia()).thenReturn(new HashMap<>());
    when(product.getDefaultSku()).thenReturn(new SkuImpl());

    // Act
    JSONObject actualAddProductDataResult = productLinkedDataGeneratorImpl.addProductData(request, product,
        "https://example.org/example");

    // Assert
    verify(linkedDataGeneratorExtensionManager, atLeast(1)).getProxy();
    verify(product).getRetailPrice();
    verify(product).getAllSellableSkus();
    verify(product, atLeast(1)).getCategory();
    verify(product).getDefaultSku();
    verify(product).getLongDescription();
    verify(product).getManufacturer();
    verify(product).getMedia();
    verify(product).getName();
    verify(product).getPrice();
    assertEquals(500, actualAddProductDataResult.getRecursionDepthLimit());
    assertEquals(7, actualAddProductDataResult.length());
    assertTrue(actualAddProductDataResult.isEscapeForwardSlashAlways());
  }

  /**
   * Test {@link ProductLinkedDataGeneratorImpl#addImageUrl(Product, JSONObject)}.
   * <ul>
   *   <li>Given {@link Environment} {@link PropertyResolver#getProperty(String)} return {@code /cmsstatic/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductLinkedDataGeneratorImpl#addImageUrl(Product, JSONObject)}
   */
  @Test
  @DisplayName("Test addImageUrl(Product, JSONObject); given Environment getProperty(String) return '/cmsstatic/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ProductLinkedDataGeneratorImpl.addImageUrl(Product, JSONObject)"})
  void testAddImageUrl_givenEnvironmentGetPropertyReturnCmsstatic() throws JSONException {
    // Arrange
    when(environment.getProperty(Mockito.<String>any())).thenReturn("/cmsstatic/");
    when(environment.getProperty(Mockito.<String>any(), Mockito.<Class<Object>>any(), Mockito.<Object>any()))
        .thenReturn(true);

    HashMap<String, Media> stringMediaMap = new HashMap<>();
    stringMediaMap.put("foo", new MediaDto());
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getMedia()).thenReturn(stringMediaMap);
    JSONObject productData = new JSONObject();

    // Act
    productLinkedDataGeneratorImpl.addImageUrl(product, productData);

    // Assert
    verify(product).getMedia();
    verify(environment).getProperty(eq("asset.server.url.prefix.secure"));
    verify(environment).getProperty(eq("site.baseurl.secure"), isA(Class.class), isA(Object.class));
    assertEquals(1, productData.length());
  }

  /**
   * Test {@link ProductLinkedDataGeneratorImpl#addImageUrl(Product, JSONObject)}.
   * <ul>
   *   <li>Given {@link Environment} {@link PropertyResolver#getProperty(String, Class, Object)} return {@code false}.</li>
   *   <li>Then {@link JSONObject#JSONObject()} length is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductLinkedDataGeneratorImpl#addImageUrl(Product, JSONObject)}
   */
  @Test
  @DisplayName("Test addImageUrl(Product, JSONObject); given Environment getProperty(String, Class, Object) return 'false'; then JSONObject() length is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ProductLinkedDataGeneratorImpl.addImageUrl(Product, JSONObject)"})
  void testAddImageUrl_givenEnvironmentGetPropertyReturnFalse_thenJSONObjectLengthIsOne() throws JSONException {
    // Arrange
    when(environment.getProperty(Mockito.<String>any())).thenReturn("Property");
    when(environment.getProperty(Mockito.<String>any(), Mockito.<Class<Object>>any(), Mockito.<Object>any()))
        .thenReturn(false);

    HashMap<String, Media> stringMediaMap = new HashMap<>();
    stringMediaMap.put("foo", new MediaDto());
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getMedia()).thenReturn(stringMediaMap);
    JSONObject productData = new JSONObject();

    // Act
    productLinkedDataGeneratorImpl.addImageUrl(product, productData);

    // Assert
    verify(product).getMedia();
    verify(environment).getProperty(eq("asset.server.url.prefix"));
    verify(environment).getProperty(eq("site.baseurl.secure"), isA(Class.class), isA(Object.class));
    assertEquals(1, productData.length());
  }

  /**
   * Test {@link ProductLinkedDataGeneratorImpl#addImageUrl(Product, JSONObject)}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@code primary} is {@link MediaDto} (default constructor).</li>
   *   <li>Then {@link JSONObject#JSONObject()} length is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductLinkedDataGeneratorImpl#addImageUrl(Product, JSONObject)}
   */
  @Test
  @DisplayName("Test addImageUrl(Product, JSONObject); given HashMap() 'primary' is MediaDto (default constructor); then JSONObject() length is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ProductLinkedDataGeneratorImpl.addImageUrl(Product, JSONObject)"})
  void testAddImageUrl_givenHashMapPrimaryIsMediaDto_thenJSONObjectLengthIsOne() throws JSONException {
    // Arrange
    when(environment.getProperty(Mockito.<String>any())).thenReturn("Property");
    when(environment.getProperty(Mockito.<String>any(), Mockito.<Class<Object>>any(), Mockito.<Object>any()))
        .thenReturn(true);

    HashMap<String, Media> stringMediaMap = new HashMap<>();
    stringMediaMap.put("primary", new MediaDto());
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getMedia()).thenReturn(stringMediaMap);
    JSONObject productData = new JSONObject();

    // Act
    productLinkedDataGeneratorImpl.addImageUrl(product, productData);

    // Assert
    verify(product).getMedia();
    verify(environment).getProperty(eq("asset.server.url.prefix.secure"));
    verify(environment).getProperty(eq("site.baseurl.secure"), isA(Class.class), isA(Object.class));
    assertEquals(1, productData.length());
  }

  /**
   * Test {@link ProductLinkedDataGeneratorImpl#addImageUrl(Product, JSONObject)}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()}.</li>
   *   <li>Then {@link JSONObject#JSONObject()} length is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductLinkedDataGeneratorImpl#addImageUrl(Product, JSONObject)}
   */
  @Test
  @DisplayName("Test addImageUrl(Product, JSONObject); given HashMap(); then JSONObject() length is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ProductLinkedDataGeneratorImpl.addImageUrl(Product, JSONObject)"})
  void testAddImageUrl_givenHashMap_thenJSONObjectLengthIsZero() throws JSONException {
    // Arrange
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getMedia()).thenReturn(new HashMap<>());
    JSONObject productData = new JSONObject();

    // Act
    productLinkedDataGeneratorImpl.addImageUrl(product, productData);

    // Assert that nothing has changed
    verify(product).getMedia();
    assertEquals(0, productData.length());
  }

  /**
   * Test {@link ProductLinkedDataGeneratorImpl#addImageUrl(Product, JSONObject)}.
   * <ul>
   *   <li>Then {@link JSONObject#JSONObject()} length is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductLinkedDataGeneratorImpl#addImageUrl(Product, JSONObject)}
   */
  @Test
  @DisplayName("Test addImageUrl(Product, JSONObject); then JSONObject() length is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ProductLinkedDataGeneratorImpl.addImageUrl(Product, JSONObject)"})
  void testAddImageUrl_thenJSONObjectLengthIsOne() throws JSONException {
    // Arrange
    when(environment.getProperty(Mockito.<String>any())).thenReturn("Property");
    when(environment.getProperty(Mockito.<String>any(), Mockito.<Class<Object>>any(), Mockito.<Object>any()))
        .thenReturn(true);

    HashMap<String, Media> stringMediaMap = new HashMap<>();
    stringMediaMap.put("foo", new MediaDto());
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getMedia()).thenReturn(stringMediaMap);
    JSONObject productData = new JSONObject();

    // Act
    productLinkedDataGeneratorImpl.addImageUrl(product, productData);

    // Assert
    verify(product).getMedia();
    verify(environment).getProperty(eq("asset.server.url.prefix.secure"));
    verify(environment).getProperty(eq("site.baseurl.secure"), isA(Class.class), isA(Object.class));
    assertEquals(1, productData.length());
  }

  /**
   * Test {@link ProductLinkedDataGeneratorImpl#getImageUrlPrefix()}.
   * <ul>
   *   <li>Given {@link Environment} {@link PropertyResolver#getProperty(String, Class, Object)} return {@code false}.</li>
   *   <li>Then return {@code Property}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductLinkedDataGeneratorImpl#getImageUrlPrefix()}
   */
  @Test
  @DisplayName("Test getImageUrlPrefix(); given Environment getProperty(String, Class, Object) return 'false'; then return 'Property'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ProductLinkedDataGeneratorImpl.getImageUrlPrefix()"})
  void testGetImageUrlPrefix_givenEnvironmentGetPropertyReturnFalse_thenReturnProperty() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any())).thenReturn("Property");
    when(environment.getProperty(Mockito.<String>any(), Mockito.<Class<Object>>any(), Mockito.<Object>any()))
        .thenReturn(false);

    // Act
    String actualImageUrlPrefix = productLinkedDataGeneratorImpl.getImageUrlPrefix();

    // Assert
    verify(environment).getProperty(eq("asset.server.url.prefix"));
    verify(environment).getProperty(eq("site.baseurl.secure"), isA(Class.class), isA(Object.class));
    assertEquals("Property", actualImageUrlPrefix);
  }

  /**
   * Test {@link ProductLinkedDataGeneratorImpl#getImageUrlPrefix()}.
   * <ul>
   *   <li>Given {@link Environment} {@link PropertyResolver#getProperty(String)} return {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductLinkedDataGeneratorImpl#getImageUrlPrefix()}
   */
  @Test
  @DisplayName("Test getImageUrlPrefix(); given Environment getProperty(String) return 'null'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ProductLinkedDataGeneratorImpl.getImageUrlPrefix()"})
  void testGetImageUrlPrefix_givenEnvironmentGetPropertyReturnNull_thenReturnNull() {
    // Arrange
    when(baseUrlResolver.getSiteBaseUrl()).thenReturn("https://example.org/example");
    when(environment.getProperty(Mockito.<String>any())).thenReturn(null);
    when(environment.getProperty(Mockito.<String>any(), Mockito.<Class<Object>>any(), Mockito.<Object>any()))
        .thenReturn(true);

    // Act
    String actualImageUrlPrefix = productLinkedDataGeneratorImpl.getImageUrlPrefix();

    // Assert
    verify(baseUrlResolver).getSiteBaseUrl();
    verify(environment).getProperty(eq("asset.server.url.prefix.secure"));
    verify(environment).getProperty(eq("site.baseurl.secure"), isA(Class.class), isA(Object.class));
    assertNull(actualImageUrlPrefix);
  }

  /**
   * Test {@link ProductLinkedDataGeneratorImpl#getImageUrlPrefix()}.
   * <ul>
   *   <li>Given {@link Environment} {@link PropertyResolver#getProperty(String, Class, Object)} return {@code true}.</li>
   *   <li>Then return {@code Property}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductLinkedDataGeneratorImpl#getImageUrlPrefix()}
   */
  @Test
  @DisplayName("Test getImageUrlPrefix(); given Environment getProperty(String, Class, Object) return 'true'; then return 'Property'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ProductLinkedDataGeneratorImpl.getImageUrlPrefix()"})
  void testGetImageUrlPrefix_givenEnvironmentGetPropertyReturnTrue_thenReturnProperty() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any())).thenReturn("Property");
    when(environment.getProperty(Mockito.<String>any(), Mockito.<Class<Object>>any(), Mockito.<Object>any()))
        .thenReturn(true);

    // Act
    String actualImageUrlPrefix = productLinkedDataGeneratorImpl.getImageUrlPrefix();

    // Assert
    verify(environment).getProperty(eq("asset.server.url.prefix.secure"));
    verify(environment).getProperty(eq("site.baseurl.secure"), isA(Class.class), isA(Object.class));
    assertEquals("Property", actualImageUrlPrefix);
  }

  /**
   * Test {@link ProductLinkedDataGeneratorImpl#getAssetServerUrlPrefix()}.
   * <ul>
   *   <li>Given {@link Environment} {@link PropertyResolver#getProperty(String, Class, Object)} return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductLinkedDataGeneratorImpl#getAssetServerUrlPrefix()}
   */
  @Test
  @DisplayName("Test getAssetServerUrlPrefix(); given Environment getProperty(String, Class, Object) return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ProductLinkedDataGeneratorImpl.getAssetServerUrlPrefix()"})
  void testGetAssetServerUrlPrefix_givenEnvironmentGetPropertyReturnFalse() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any())).thenReturn("Property");
    when(environment.getProperty(Mockito.<String>any(), Mockito.<Class<Object>>any(), Mockito.<Object>any()))
        .thenReturn(false);

    // Act
    String actualAssetServerUrlPrefix = productLinkedDataGeneratorImpl.getAssetServerUrlPrefix();

    // Assert
    verify(environment).getProperty(eq("asset.server.url.prefix"));
    verify(environment).getProperty(eq("site.baseurl.secure"), isA(Class.class), isA(Object.class));
    assertEquals("Property", actualAssetServerUrlPrefix);
  }

  /**
   * Test {@link ProductLinkedDataGeneratorImpl#getAssetServerUrlPrefix()}.
   * <ul>
   *   <li>Given {@link Environment} {@link PropertyResolver#getProperty(String, Class, Object)} return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductLinkedDataGeneratorImpl#getAssetServerUrlPrefix()}
   */
  @Test
  @DisplayName("Test getAssetServerUrlPrefix(); given Environment getProperty(String, Class, Object) return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ProductLinkedDataGeneratorImpl.getAssetServerUrlPrefix()"})
  void testGetAssetServerUrlPrefix_givenEnvironmentGetPropertyReturnTrue() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any())).thenReturn("Property");
    when(environment.getProperty(Mockito.<String>any(), Mockito.<Class<Object>>any(), Mockito.<Object>any()))
        .thenReturn(true);

    // Act
    String actualAssetServerUrlPrefix = productLinkedDataGeneratorImpl.getAssetServerUrlPrefix();

    // Assert
    verify(environment).getProperty(eq("asset.server.url.prefix.secure"));
    verify(environment).getProperty(eq("site.baseurl.secure"), isA(Class.class), isA(Object.class));
    assertEquals("Property", actualAssetServerUrlPrefix);
  }

  /**
   * Test {@link ProductLinkedDataGeneratorImpl#addSkus(HttpServletRequest, Product, JSONObject, String)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.</li>
   *   <li>Then {@link JSONObject#JSONObject()} length is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductLinkedDataGeneratorImpl#addSkus(HttpServletRequest, Product, JSONObject, String)}
   */
  @Test
  @DisplayName("Test addSkus(HttpServletRequest, Product, JSONObject, String); given ArrayList(); then JSONObject() length is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ProductLinkedDataGeneratorImpl.addSkus(HttpServletRequest, Product, JSONObject, String)"})
  void testAddSkus_givenArrayList_thenJSONObjectLengthIsOne() throws JSONException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    ProductLinkedDataGeneratorImpl productLinkedDataGeneratorImpl = new ProductLinkedDataGeneratorImpl();
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();
    SearchRequestWrapper request = new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
        new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"}));
    Product product = mock(Product.class);
    when(product.getAllSellableSkus()).thenReturn(new ArrayList<>());
    when(product.getRetailPrice()).thenReturn(new Money());
    JSONObject productData = new JSONObject();

    // Act
    productLinkedDataGeneratorImpl.addSkus(request, product, productData, "https://example.org/example");

    // Assert
    verify(product).getAllSellableSkus();
    verify(product).getRetailPrice();
    assertEquals(1, productData.length());
  }

  /**
   * Test {@link ProductLinkedDataGeneratorImpl#determineAvailability(Sku)}.
   * <ul>
   *   <li>Given {@link InventoryType#InventoryType()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductLinkedDataGeneratorImpl#determineAvailability(Sku)}
   */
  @Test
  @DisplayName("Test determineAvailability(Sku); given InventoryType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ProductLinkedDataGeneratorImpl.determineAvailability(Sku)"})
  void testDetermineAvailability_givenInventoryType() {
    // Arrange
    ProductLinkedDataGeneratorImpl productLinkedDataGeneratorImpl = new ProductLinkedDataGeneratorImpl();
    Sku sku = mock(Sku.class);
    when(sku.getInventoryType()).thenReturn(new InventoryType());
    when(sku.isActive()).thenReturn(true);

    // Act
    String actualDetermineAvailabilityResult = productLinkedDataGeneratorImpl.determineAvailability(sku);

    // Assert
    verify(sku, atLeast(1)).getInventoryType();
    verify(sku).isActive();
    assertEquals("OutOfStock", actualDetermineAvailabilityResult);
  }

  /**
   * Test {@link ProductLinkedDataGeneratorImpl#determineAvailability(Sku)}.
   * <ul>
   *   <li>Given {@link InventoryType}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductLinkedDataGeneratorImpl#determineAvailability(Sku)}
   */
  @Test
  @DisplayName("Test determineAvailability(Sku); given InventoryType")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ProductLinkedDataGeneratorImpl.determineAvailability(Sku)"})
  void testDetermineAvailability_givenInventoryType2() {
    // Arrange
    ProductLinkedDataGeneratorImpl productLinkedDataGeneratorImpl = new ProductLinkedDataGeneratorImpl();
    Sku sku = mock(Sku.class);
    when(sku.getInventoryType()).thenReturn(mock(InventoryType.class));
    when(sku.isActive()).thenReturn(true);

    // Act
    String actualDetermineAvailabilityResult = productLinkedDataGeneratorImpl.determineAvailability(sku);

    // Assert
    verify(sku, atLeast(1)).getInventoryType();
    verify(sku).isActive();
    assertEquals("OutOfStock", actualDetermineAvailabilityResult);
  }

  /**
   * Test {@link ProductLinkedDataGeneratorImpl#determineAvailability(Sku)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>Then return {@code InStock}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductLinkedDataGeneratorImpl#determineAvailability(Sku)}
   */
  @Test
  @DisplayName("Test determineAvailability(Sku); given 'null'; then return 'InStock'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ProductLinkedDataGeneratorImpl.determineAvailability(Sku)"})
  void testDetermineAvailability_givenNull_thenReturnInStock() {
    // Arrange
    ProductLinkedDataGeneratorImpl productLinkedDataGeneratorImpl = new ProductLinkedDataGeneratorImpl();
    Sku sku = mock(Sku.class);
    when(sku.getInventoryType()).thenReturn(null);
    when(sku.isActive()).thenReturn(true);

    // Act
    String actualDetermineAvailabilityResult = productLinkedDataGeneratorImpl.determineAvailability(sku);

    // Assert
    verify(sku).getInventoryType();
    verify(sku).isActive();
    assertEquals("InStock", actualDetermineAvailabilityResult);
  }

  /**
   * Test {@link ProductLinkedDataGeneratorImpl#determineAvailability(Sku)}.
   * <ul>
   *   <li>When {@link SkuImpl} (default constructor).</li>
   *   <li>Then return {@code OutOfStock}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductLinkedDataGeneratorImpl#determineAvailability(Sku)}
   */
  @Test
  @DisplayName("Test determineAvailability(Sku); when SkuImpl (default constructor); then return 'OutOfStock'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ProductLinkedDataGeneratorImpl.determineAvailability(Sku)"})
  void testDetermineAvailability_whenSkuImpl_thenReturnOutOfStock() {
    // Arrange
    ProductLinkedDataGeneratorImpl productLinkedDataGeneratorImpl = new ProductLinkedDataGeneratorImpl();

    // Act and Assert
    assertEquals("OutOfStock", productLinkedDataGeneratorImpl.determineAvailability(new SkuImpl()));
  }
}
