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
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.common.web.BaseUrlResolver;
import org.broadleafcommerce.core.catalog.domain.CategoryImpl;
import org.broadleafcommerce.core.catalog.domain.Product;
import org.broadleafcommerce.core.catalog.domain.ProductBundleImpl;
import org.broadleafcommerce.core.catalog.domain.Sku;
import org.broadleafcommerce.core.catalog.domain.SkuImpl;
import org.broadleafcommerce.core.catalog.service.CatalogService;
import org.broadleafcommerce.core.catalog.service.dynamic.DynamicSkuPrices;
import org.broadleafcommerce.core.inventory.service.type.InventoryType;
import org.broadleafcommerce.core.rating.domain.RatingDetailImpl;
import org.broadleafcommerce.core.rating.domain.RatingSummary;
import org.broadleafcommerce.core.rating.domain.RatingSummaryImpl;
import org.broadleafcommerce.core.rating.domain.ReviewDetail;
import org.broadleafcommerce.core.rating.domain.ReviewDetailImpl;
import org.broadleafcommerce.core.rating.service.RatingService;
import org.broadleafcommerce.core.rating.service.type.RatingType;
import org.broadleafcommerce.core.web.search.SearchRequestWrapper;
import org.broadleafcommerce.profile.core.domain.CustomerImpl;
import org.codehaus.jettison.json.JSONArray;
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
import org.springframework.core.env.Environment;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.multipart.support.DefaultMultipartHttpServletRequest;

@ExtendWith(MockitoExtension.class)
class ProductLinkedDataGeneratorImplDiffblueTest {
  @Mock private BaseUrlResolver baseUrlResolver;

  @Mock private CatalogService catalogService;

  @Mock private Environment environment;

  @Mock private LinkedDataGeneratorExtensionManager linkedDataGeneratorExtensionManager;

  @InjectMocks private ProductLinkedDataGeneratorImpl productLinkedDataGeneratorImpl;

  @Mock private RatingService ratingService;

  /**
   * Test {@link ProductLinkedDataGeneratorImpl#canHandle(HttpServletRequest)}.
   *
   * <ul>
   *   <li>Given {@code Attribute}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ProductLinkedDataGeneratorImpl#canHandle(HttpServletRequest)}
   */
  @Test
  @DisplayName("Test canHandle(HttpServletRequest); given 'Attribute'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ProductLinkedDataGeneratorImpl.canHandle(HttpServletRequest)"})
  void testCanHandle_givenAttribute_thenReturnTrue() {
    // Arrange
    DefaultMultipartHttpServletRequest servletRequest =
        mock(DefaultMultipartHttpServletRequest.class);
    when(servletRequest.getAttribute(Mockito.<String>any())).thenReturn("Attribute");
    SearchRequestWrapper request = new SearchRequestWrapper(servletRequest);

    // Act
    boolean actualCanHandleResult =
        productLinkedDataGeneratorImpl.canHandle(new HttpServletRequestWrapper(request));

    // Assert
    verify(servletRequest).getAttribute("currentProduct");
    assertTrue(actualCanHandleResult);
  }

  /**
   * Test {@link ProductLinkedDataGeneratorImpl#canHandle(HttpServletRequest)}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ProductLinkedDataGeneratorImpl#canHandle(HttpServletRequest)}
   */
  @Test
  @DisplayName("Test canHandle(HttpServletRequest); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ProductLinkedDataGeneratorImpl.canHandle(HttpServletRequest)"})
  void testCanHandle_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(
        productLinkedDataGeneratorImpl.canHandle(
            new HttpServletRequestWrapper(new SearchRequestWrapper(new MockHttpServletRequest()))));
  }

  /**
   * Test {@link ProductLinkedDataGeneratorImpl#getLinkedDataJsonInternal(String,
   * HttpServletRequest, JSONArray)}.
   *
   * <p>Method under test: {@link ProductLinkedDataGeneratorImpl#getLinkedDataJsonInternal(String,
   * HttpServletRequest, JSONArray)}
   */
  @Test
  @DisplayName("Test getLinkedDataJsonInternal(String, HttpServletRequest, JSONArray)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "JSONArray ProductLinkedDataGeneratorImpl.getLinkedDataJsonInternal(String, HttpServletRequest, JSONArray)"
  })
  void testGetLinkedDataJsonInternal() throws UnsupportedEncodingException, JSONException {
    // Arrange
    when(linkedDataGeneratorExtensionManager.getProxy())
        .thenReturn(new DefaultLinkedDataGeneratorExtensionHandler());

    ArrayList<Sku> skuList = new ArrayList<>();
    skuList.add(new SkuImpl());

    ProductBundleImpl productBundleImpl = mock(ProductBundleImpl.class);
    when(productBundleImpl.getPrice()).thenReturn(new Money(10.0d));
    when(productBundleImpl.getId()).thenReturn(1L);
    when(productBundleImpl.getAllSellableSkus()).thenReturn(skuList);
    when(productBundleImpl.getRetailPrice()).thenReturn(new Money());
    when(productBundleImpl.getCategory()).thenReturn(new CategoryImpl());
    when(productBundleImpl.getLongDescription()).thenReturn("Long Description");
    when(productBundleImpl.getManufacturer()).thenReturn("Manufacturer");
    when(productBundleImpl.getName()).thenReturn("Name");
    when(productBundleImpl.getMedia()).thenReturn(new HashMap<>());
    when(productBundleImpl.getDefaultSku()).thenReturn(new SkuImpl());
    when(catalogService.findProductById(Mockito.<Long>any())).thenReturn(productBundleImpl);
    when(ratingService.readRatingSummary(Mockito.<String>any(), Mockito.<RatingType>any()))
        .thenReturn(new RatingSummaryImpl());

    MockHttpServletRequest servletRequest = mock(MockHttpServletRequest.class);
    doNothing().when(servletRequest).setCharacterEncoding(Mockito.<String>any());
    when(servletRequest.getAttribute(Mockito.<String>any())).thenReturn(new ProductBundleImpl());
    doNothing().when(servletRequest).addParameter(Mockito.<String>any(), Mockito.<String>any());
    doNothing().when(servletRequest).setAttribute(Mockito.<String>any(), Mockito.<Object>any());
    servletRequest.addParameter("currentProduct", "42");

    SearchRequestWrapper request = new SearchRequestWrapper(servletRequest);
    request.setCharacterEncoding("currentProduct");
    request.setAttribute("currentProduct", "42");
    HttpServletRequestWrapper request2 = new HttpServletRequestWrapper(request);
    JSONArray schemaObjects = new JSONArray(3);

    // Act
    JSONArray actualLinkedDataJsonInternal =
        productLinkedDataGeneratorImpl.getLinkedDataJsonInternal(
            "https://example.org/example", request2, schemaObjects);

    // Assert
    verify(linkedDataGeneratorExtensionManager, atLeast(1)).getProxy();
    verify(productBundleImpl).getRetailPrice();
    verify(productBundleImpl).getAllSellableSkus();
    verify(productBundleImpl, atLeast(1)).getCategory();
    verify(productBundleImpl).getDefaultSku();
    verify(productBundleImpl).getId();
    verify(productBundleImpl).getLongDescription();
    verify(productBundleImpl).getManufacturer();
    verify(productBundleImpl).getMedia();
    verify(productBundleImpl).getName();
    verify(productBundleImpl).getPrice();
    verify(catalogService).findProductById(isNull());
    verify(ratingService).readRatingSummary(eq("1"), isA(RatingType.class));
    verify(servletRequest).addParameter("currentProduct", "42");
    verify(servletRequest).getAttribute("currentProduct");
    verify(servletRequest).setAttribute(eq("currentProduct"), isA(Object.class));
    verify(servletRequest).setCharacterEncoding("currentProduct");
    assertEquals(1, schemaObjects.length());
    assertSame(schemaObjects, actualLinkedDataJsonInternal);
  }

  /**
   * Test {@link ProductLinkedDataGeneratorImpl#getLinkedDataJsonInternal(String,
   * HttpServletRequest, JSONArray)}.
   *
   * <ul>
   *   <li>Given {@link Money} {@link Money#greaterThan(BigDecimal)} return {@code true}.
   *   <li>Then calls {@link Money#getAmount()}.
   * </ul>
   *
   * <p>Method under test: {@link ProductLinkedDataGeneratorImpl#getLinkedDataJsonInternal(String,
   * HttpServletRequest, JSONArray)}
   */
  @Test
  @DisplayName(
      "Test getLinkedDataJsonInternal(String, HttpServletRequest, JSONArray); given Money greaterThan(BigDecimal) return 'true'; then calls getAmount()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "JSONArray ProductLinkedDataGeneratorImpl.getLinkedDataJsonInternal(String, HttpServletRequest, JSONArray)"
  })
  void testGetLinkedDataJsonInternal_givenMoneyGreaterThanReturnTrue_thenCallsGetAmount()
      throws UnsupportedEncodingException, JSONException {
    // Arrange
    when(linkedDataGeneratorExtensionManager.getProxy())
        .thenReturn(new DefaultLinkedDataGeneratorExtensionHandler());

    ArrayList<Sku> skuList = new ArrayList<>();
    skuList.add(new SkuImpl());

    Money money = mock(Money.class);
    when(money.greaterThan(Mockito.<BigDecimal>any())).thenReturn(true);
    when(money.getAmount()).thenReturn(new BigDecimal("2.3"));

    ProductBundleImpl productBundleImpl = mock(ProductBundleImpl.class);
    when(productBundleImpl.getPrice()).thenReturn(money);
    when(productBundleImpl.getId()).thenReturn(1L);
    when(productBundleImpl.getAllSellableSkus()).thenReturn(skuList);
    when(productBundleImpl.getRetailPrice()).thenReturn(new Money());
    when(productBundleImpl.getCategory()).thenReturn(new CategoryImpl());
    when(productBundleImpl.getLongDescription()).thenReturn("Long Description");
    when(productBundleImpl.getManufacturer()).thenReturn("Manufacturer");
    when(productBundleImpl.getName()).thenReturn("Name");
    when(productBundleImpl.getMedia()).thenReturn(new HashMap<>());
    when(productBundleImpl.getDefaultSku()).thenReturn(new SkuImpl());
    when(catalogService.findProductById(Mockito.<Long>any())).thenReturn(productBundleImpl);
    when(ratingService.readRatingSummary(Mockito.<String>any(), Mockito.<RatingType>any()))
        .thenReturn(new RatingSummaryImpl());

    MockHttpServletRequest servletRequest = mock(MockHttpServletRequest.class);
    doNothing().when(servletRequest).setCharacterEncoding(Mockito.<String>any());
    when(servletRequest.getAttribute(Mockito.<String>any())).thenReturn(new ProductBundleImpl());
    doNothing().when(servletRequest).addParameter(Mockito.<String>any(), Mockito.<String>any());
    doNothing().when(servletRequest).setAttribute(Mockito.<String>any(), Mockito.<Object>any());
    servletRequest.addParameter("currentProduct", "42");

    SearchRequestWrapper request = new SearchRequestWrapper(servletRequest);
    request.setCharacterEncoding("currentProduct");
    request.setAttribute("currentProduct", "42");
    HttpServletRequestWrapper request2 = new HttpServletRequestWrapper(request);
    JSONArray schemaObjects = new JSONArray(3);

    // Act
    JSONArray actualLinkedDataJsonInternal =
        productLinkedDataGeneratorImpl.getLinkedDataJsonInternal(
            "https://example.org/example", request2, schemaObjects);

    // Assert
    verify(linkedDataGeneratorExtensionManager, atLeast(1)).getProxy();
    verify(money, atLeast(1)).getAmount();
    verify(money).greaterThan(isA(BigDecimal.class));
    verify(productBundleImpl).getRetailPrice();
    verify(productBundleImpl).getAllSellableSkus();
    verify(productBundleImpl, atLeast(1)).getCategory();
    verify(productBundleImpl).getDefaultSku();
    verify(productBundleImpl).getId();
    verify(productBundleImpl).getLongDescription();
    verify(productBundleImpl).getManufacturer();
    verify(productBundleImpl).getMedia();
    verify(productBundleImpl).getName();
    verify(productBundleImpl).getPrice();
    verify(catalogService).findProductById(isNull());
    verify(ratingService).readRatingSummary(eq("1"), isA(RatingType.class));
    verify(servletRequest).addParameter("currentProduct", "42");
    verify(servletRequest).getAttribute("currentProduct");
    verify(servletRequest).setAttribute(eq("currentProduct"), isA(Object.class));
    verify(servletRequest).setCharacterEncoding("currentProduct");
    assertEquals(1, schemaObjects.length());
    assertSame(schemaObjects, actualLinkedDataJsonInternal);
  }

  /**
   * Test {@link ProductLinkedDataGeneratorImpl#getLinkedDataJsonInternal(String,
   * HttpServletRequest, JSONArray)}.
   *
   * <ul>
   *   <li>Given {@link Money} {@link Money#lessThan(BigDecimal)} return {@code true}.
   *   <li>Then calls {@link Money#lessThan(BigDecimal)}.
   * </ul>
   *
   * <p>Method under test: {@link ProductLinkedDataGeneratorImpl#getLinkedDataJsonInternal(String,
   * HttpServletRequest, JSONArray)}
   */
  @Test
  @DisplayName(
      "Test getLinkedDataJsonInternal(String, HttpServletRequest, JSONArray); given Money lessThan(BigDecimal) return 'true'; then calls lessThan(BigDecimal)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "JSONArray ProductLinkedDataGeneratorImpl.getLinkedDataJsonInternal(String, HttpServletRequest, JSONArray)"
  })
  void testGetLinkedDataJsonInternal_givenMoneyLessThanReturnTrue_thenCallsLessThan()
      throws UnsupportedEncodingException, JSONException {
    // Arrange
    when(linkedDataGeneratorExtensionManager.getProxy())
        .thenReturn(new DefaultLinkedDataGeneratorExtensionHandler());

    ArrayList<Sku> skuList = new ArrayList<>();
    skuList.add(new SkuImpl());
    skuList.add(new SkuImpl());

    Money money = mock(Money.class);
    when(money.lessThan(Mockito.<BigDecimal>any())).thenReturn(true);
    when(money.greaterThan(Mockito.<BigDecimal>any())).thenReturn(true);
    when(money.getAmount()).thenReturn(new BigDecimal("2.3"));

    ProductBundleImpl productBundleImpl = mock(ProductBundleImpl.class);
    when(productBundleImpl.getPrice()).thenReturn(money);
    when(productBundleImpl.getId()).thenReturn(1L);
    when(productBundleImpl.getAllSellableSkus()).thenReturn(skuList);
    when(productBundleImpl.getRetailPrice()).thenReturn(new Money());
    when(productBundleImpl.getCategory()).thenReturn(new CategoryImpl());
    when(productBundleImpl.getLongDescription()).thenReturn("Long Description");
    when(productBundleImpl.getManufacturer()).thenReturn("Manufacturer");
    when(productBundleImpl.getName()).thenReturn("Name");
    when(productBundleImpl.getMedia()).thenReturn(new HashMap<>());
    when(productBundleImpl.getDefaultSku()).thenReturn(new SkuImpl());
    when(catalogService.findProductById(Mockito.<Long>any())).thenReturn(productBundleImpl);
    when(ratingService.readRatingSummary(Mockito.<String>any(), Mockito.<RatingType>any()))
        .thenReturn(new RatingSummaryImpl());

    MockHttpServletRequest servletRequest = mock(MockHttpServletRequest.class);
    doNothing().when(servletRequest).setCharacterEncoding(Mockito.<String>any());
    when(servletRequest.getAttribute(Mockito.<String>any())).thenReturn(new ProductBundleImpl());
    doNothing().when(servletRequest).addParameter(Mockito.<String>any(), Mockito.<String>any());
    doNothing().when(servletRequest).setAttribute(Mockito.<String>any(), Mockito.<Object>any());
    servletRequest.addParameter("currentProduct", "42");

    SearchRequestWrapper request = new SearchRequestWrapper(servletRequest);
    request.setCharacterEncoding("currentProduct");
    request.setAttribute("currentProduct", "42");
    HttpServletRequestWrapper request2 = new HttpServletRequestWrapper(request);
    JSONArray schemaObjects = new JSONArray(3);

    // Act
    JSONArray actualLinkedDataJsonInternal =
        productLinkedDataGeneratorImpl.getLinkedDataJsonInternal(
            "https://example.org/example", request2, schemaObjects);

    // Assert
    verify(linkedDataGeneratorExtensionManager, atLeast(1)).getProxy();
    verify(money, atLeast(1)).getAmount();
    verify(money, atLeast(1)).greaterThan(Mockito.<BigDecimal>any());
    verify(money).lessThan(isA(BigDecimal.class));
    verify(productBundleImpl).getRetailPrice();
    verify(productBundleImpl).getAllSellableSkus();
    verify(productBundleImpl, atLeast(1)).getCategory();
    verify(productBundleImpl).getDefaultSku();
    verify(productBundleImpl).getId();
    verify(productBundleImpl).getLongDescription();
    verify(productBundleImpl).getManufacturer();
    verify(productBundleImpl).getMedia();
    verify(productBundleImpl).getName();
    verify(productBundleImpl, atLeast(1)).getPrice();
    verify(catalogService).findProductById(isNull());
    verify(ratingService).readRatingSummary(eq("1"), isA(RatingType.class));
    verify(servletRequest).addParameter("currentProduct", "42");
    verify(servletRequest).getAttribute("currentProduct");
    verify(servletRequest).setAttribute(eq("currentProduct"), isA(Object.class));
    verify(servletRequest).setCharacterEncoding("currentProduct");
    assertEquals(1, schemaObjects.length());
    assertSame(schemaObjects, actualLinkedDataJsonInternal);
  }

  /**
   * Test {@link ProductLinkedDataGeneratorImpl#getLinkedDataJsonInternal(String,
   * HttpServletRequest, JSONArray)}.
   *
   * <ul>
   *   <li>Given {@link ProductBundleImpl} {@link ProductBundleImpl#getPrice()} return {@link
   *       Money#Money()}.
   * </ul>
   *
   * <p>Method under test: {@link ProductLinkedDataGeneratorImpl#getLinkedDataJsonInternal(String,
   * HttpServletRequest, JSONArray)}
   */
  @Test
  @DisplayName(
      "Test getLinkedDataJsonInternal(String, HttpServletRequest, JSONArray); given ProductBundleImpl getPrice() return Money()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "JSONArray ProductLinkedDataGeneratorImpl.getLinkedDataJsonInternal(String, HttpServletRequest, JSONArray)"
  })
  void testGetLinkedDataJsonInternal_givenProductBundleImplGetPriceReturnMoney()
      throws UnsupportedEncodingException, JSONException {
    // Arrange
    when(linkedDataGeneratorExtensionManager.getProxy())
        .thenReturn(new DefaultLinkedDataGeneratorExtensionHandler());

    ArrayList<Sku> skuList = new ArrayList<>();
    skuList.add(new SkuImpl());

    ProductBundleImpl productBundleImpl = mock(ProductBundleImpl.class);
    when(productBundleImpl.getPrice()).thenReturn(new Money());
    when(productBundleImpl.getId()).thenReturn(1L);
    when(productBundleImpl.getAllSellableSkus()).thenReturn(skuList);
    when(productBundleImpl.getRetailPrice()).thenReturn(new Money());
    when(productBundleImpl.getCategory()).thenReturn(new CategoryImpl());
    when(productBundleImpl.getLongDescription()).thenReturn("Long Description");
    when(productBundleImpl.getManufacturer()).thenReturn("Manufacturer");
    when(productBundleImpl.getName()).thenReturn("Name");
    when(productBundleImpl.getMedia()).thenReturn(new HashMap<>());
    when(productBundleImpl.getDefaultSku()).thenReturn(new SkuImpl());
    when(catalogService.findProductById(Mockito.<Long>any())).thenReturn(productBundleImpl);
    when(ratingService.readRatingSummary(Mockito.<String>any(), Mockito.<RatingType>any()))
        .thenReturn(new RatingSummaryImpl());

    MockHttpServletRequest servletRequest = mock(MockHttpServletRequest.class);
    doNothing().when(servletRequest).setCharacterEncoding(Mockito.<String>any());
    when(servletRequest.getAttribute(Mockito.<String>any())).thenReturn(new ProductBundleImpl());
    doNothing().when(servletRequest).addParameter(Mockito.<String>any(), Mockito.<String>any());
    doNothing().when(servletRequest).setAttribute(Mockito.<String>any(), Mockito.<Object>any());
    servletRequest.addParameter("currentProduct", "42");

    SearchRequestWrapper request = new SearchRequestWrapper(servletRequest);
    request.setCharacterEncoding("currentProduct");
    request.setAttribute("currentProduct", "42");
    HttpServletRequestWrapper request2 = new HttpServletRequestWrapper(request);
    JSONArray schemaObjects = new JSONArray(3);

    // Act
    JSONArray actualLinkedDataJsonInternal =
        productLinkedDataGeneratorImpl.getLinkedDataJsonInternal(
            "https://example.org/example", request2, schemaObjects);

    // Assert
    verify(linkedDataGeneratorExtensionManager, atLeast(1)).getProxy();
    verify(productBundleImpl).getRetailPrice();
    verify(productBundleImpl).getAllSellableSkus();
    verify(productBundleImpl, atLeast(1)).getCategory();
    verify(productBundleImpl).getDefaultSku();
    verify(productBundleImpl).getId();
    verify(productBundleImpl).getLongDescription();
    verify(productBundleImpl).getManufacturer();
    verify(productBundleImpl).getMedia();
    verify(productBundleImpl).getName();
    verify(productBundleImpl).getPrice();
    verify(catalogService).findProductById(isNull());
    verify(ratingService).readRatingSummary(eq("1"), isA(RatingType.class));
    verify(servletRequest).addParameter("currentProduct", "42");
    verify(servletRequest).getAttribute("currentProduct");
    verify(servletRequest).setAttribute(eq("currentProduct"), isA(Object.class));
    verify(servletRequest).setCharacterEncoding("currentProduct");
    assertEquals(1, schemaObjects.length());
    assertSame(schemaObjects, actualLinkedDataJsonInternal);
  }

  /**
   * Test {@link ProductLinkedDataGeneratorImpl#getLinkedDataJsonInternal(String,
   * HttpServletRequest, JSONArray)}.
   *
   * <ul>
   *   <li>Given {@link SkuImpl} {@link SkuImpl#getInventoryType()} return {@link
   *       InventoryType#InventoryType()}.
   * </ul>
   *
   * <p>Method under test: {@link ProductLinkedDataGeneratorImpl#getLinkedDataJsonInternal(String,
   * HttpServletRequest, JSONArray)}
   */
  @Test
  @DisplayName(
      "Test getLinkedDataJsonInternal(String, HttpServletRequest, JSONArray); given SkuImpl getInventoryType() return InventoryType()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "JSONArray ProductLinkedDataGeneratorImpl.getLinkedDataJsonInternal(String, HttpServletRequest, JSONArray)"
  })
  void testGetLinkedDataJsonInternal_givenSkuImplGetInventoryTypeReturnInventoryType()
      throws UnsupportedEncodingException, JSONException {
    // Arrange
    when(linkedDataGeneratorExtensionManager.getProxy())
        .thenReturn(new DefaultLinkedDataGeneratorExtensionHandler());

    DynamicSkuPrices dynamicSkuPrices = new DynamicSkuPrices();
    dynamicSkuPrices.setDidOverride(true);
    dynamicSkuPrices.setPriceAdjustment(new Money());
    dynamicSkuPrices.setRetailPrice(new Money());
    dynamicSkuPrices.setSalePrice(new Money());

    SkuImpl skuImpl = mock(SkuImpl.class);
    when(skuImpl.getInventoryType()).thenReturn(new InventoryType());
    when(skuImpl.isActive()).thenReturn(true);
    when(skuImpl.getId()).thenReturn(1L);
    when(skuImpl.getActiveEndDate())
        .thenReturn(
            Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    when(skuImpl.getPriceData()).thenReturn(dynamicSkuPrices);

    ArrayList<Sku> skuList = new ArrayList<>();
    skuList.add(skuImpl);
    skuList.add(new SkuImpl());

    Money money = mock(Money.class);
    when(money.lessThan(Mockito.<BigDecimal>any())).thenReturn(true);
    when(money.greaterThan(Mockito.<BigDecimal>any())).thenReturn(true);
    when(money.getAmount()).thenReturn(new BigDecimal("2.3"));

    ProductBundleImpl productBundleImpl = mock(ProductBundleImpl.class);
    when(productBundleImpl.getPrice()).thenReturn(money);
    when(productBundleImpl.getId()).thenReturn(1L);
    when(productBundleImpl.getAllSellableSkus()).thenReturn(skuList);
    when(productBundleImpl.getRetailPrice()).thenReturn(new Money());
    when(productBundleImpl.getCategory()).thenReturn(new CategoryImpl());
    when(productBundleImpl.getLongDescription()).thenReturn("Long Description");
    when(productBundleImpl.getManufacturer()).thenReturn("Manufacturer");
    when(productBundleImpl.getName()).thenReturn("Name");
    when(productBundleImpl.getMedia()).thenReturn(new HashMap<>());
    when(productBundleImpl.getDefaultSku()).thenReturn(new SkuImpl());
    when(catalogService.findProductById(Mockito.<Long>any())).thenReturn(productBundleImpl);
    when(ratingService.readRatingSummary(Mockito.<String>any(), Mockito.<RatingType>any()))
        .thenReturn(new RatingSummaryImpl());

    MockHttpServletRequest servletRequest = mock(MockHttpServletRequest.class);
    doNothing().when(servletRequest).setCharacterEncoding(Mockito.<String>any());
    when(servletRequest.getAttribute(Mockito.<String>any())).thenReturn(new ProductBundleImpl());
    doNothing().when(servletRequest).addParameter(Mockito.<String>any(), Mockito.<String>any());
    doNothing().when(servletRequest).setAttribute(Mockito.<String>any(), Mockito.<Object>any());
    servletRequest.addParameter("currentProduct", "42");

    SearchRequestWrapper request = new SearchRequestWrapper(servletRequest);
    request.setCharacterEncoding("currentProduct");
    request.setAttribute("currentProduct", "42");
    HttpServletRequestWrapper request2 = new HttpServletRequestWrapper(request);
    JSONArray schemaObjects = new JSONArray(3);

    // Act
    JSONArray actualLinkedDataJsonInternal =
        productLinkedDataGeneratorImpl.getLinkedDataJsonInternal(
            "https://example.org/example", request2, schemaObjects);

    // Assert
    verify(linkedDataGeneratorExtensionManager, atLeast(1)).getProxy();
    verify(money, atLeast(1)).getAmount();
    verify(money).greaterThan(isA(BigDecimal.class));
    verify(money).lessThan(isA(BigDecimal.class));
    verify(productBundleImpl).getRetailPrice();
    verify(productBundleImpl).getAllSellableSkus();
    verify(productBundleImpl, atLeast(1)).getCategory();
    verify(productBundleImpl).getDefaultSku();
    verify(productBundleImpl).getId();
    verify(productBundleImpl).getLongDescription();
    verify(productBundleImpl).getManufacturer();
    verify(productBundleImpl).getMedia();
    verify(productBundleImpl).getName();
    verify(productBundleImpl).getPrice();
    verify(skuImpl, atLeast(1)).getActiveEndDate();
    verify(skuImpl).getId();
    verify(skuImpl, atLeast(1)).getInventoryType();
    verify(skuImpl).getPriceData();
    verify(skuImpl).isActive();
    verify(catalogService).findProductById(isNull());
    verify(ratingService).readRatingSummary(eq("1"), isA(RatingType.class));
    verify(servletRequest).addParameter("currentProduct", "42");
    verify(servletRequest).getAttribute("currentProduct");
    verify(servletRequest).setAttribute(eq("currentProduct"), isA(Object.class));
    verify(servletRequest).setCharacterEncoding("currentProduct");
    assertEquals(1, schemaObjects.length());
    assertSame(schemaObjects, actualLinkedDataJsonInternal);
  }

  /**
   * Test {@link ProductLinkedDataGeneratorImpl#getLinkedDataJsonInternal(String,
   * HttpServletRequest, JSONArray)}.
   *
   * <ul>
   *   <li>Given {@link SkuImpl} {@link SkuImpl#getInventoryType()} return {@link InventoryType}.
   * </ul>
   *
   * <p>Method under test: {@link ProductLinkedDataGeneratorImpl#getLinkedDataJsonInternal(String,
   * HttpServletRequest, JSONArray)}
   */
  @Test
  @DisplayName(
      "Test getLinkedDataJsonInternal(String, HttpServletRequest, JSONArray); given SkuImpl getInventoryType() return InventoryType")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "JSONArray ProductLinkedDataGeneratorImpl.getLinkedDataJsonInternal(String, HttpServletRequest, JSONArray)"
  })
  void testGetLinkedDataJsonInternal_givenSkuImplGetInventoryTypeReturnInventoryType2()
      throws UnsupportedEncodingException, JSONException {
    // Arrange
    when(linkedDataGeneratorExtensionManager.getProxy())
        .thenReturn(new DefaultLinkedDataGeneratorExtensionHandler());

    DynamicSkuPrices dynamicSkuPrices = new DynamicSkuPrices();
    dynamicSkuPrices.setDidOverride(true);
    dynamicSkuPrices.setPriceAdjustment(new Money());
    dynamicSkuPrices.setRetailPrice(new Money());
    dynamicSkuPrices.setSalePrice(new Money());

    SkuImpl skuImpl = mock(SkuImpl.class);
    when(skuImpl.getInventoryType()).thenReturn(mock(InventoryType.class));
    when(skuImpl.isActive()).thenReturn(true);
    when(skuImpl.getId()).thenReturn(1L);
    when(skuImpl.getActiveEndDate())
        .thenReturn(
            Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    when(skuImpl.getPriceData()).thenReturn(dynamicSkuPrices);

    ArrayList<Sku> skuList = new ArrayList<>();
    skuList.add(skuImpl);
    skuList.add(new SkuImpl());

    Money money = mock(Money.class);
    when(money.lessThan(Mockito.<BigDecimal>any())).thenReturn(true);
    when(money.greaterThan(Mockito.<BigDecimal>any())).thenReturn(true);
    when(money.getAmount()).thenReturn(new BigDecimal("2.3"));

    ProductBundleImpl productBundleImpl = mock(ProductBundleImpl.class);
    when(productBundleImpl.getPrice()).thenReturn(money);
    when(productBundleImpl.getId()).thenReturn(1L);
    when(productBundleImpl.getAllSellableSkus()).thenReturn(skuList);
    when(productBundleImpl.getRetailPrice()).thenReturn(new Money());
    when(productBundleImpl.getCategory()).thenReturn(new CategoryImpl());
    when(productBundleImpl.getLongDescription()).thenReturn("Long Description");
    when(productBundleImpl.getManufacturer()).thenReturn("Manufacturer");
    when(productBundleImpl.getName()).thenReturn("Name");
    when(productBundleImpl.getMedia()).thenReturn(new HashMap<>());
    when(productBundleImpl.getDefaultSku()).thenReturn(new SkuImpl());
    when(catalogService.findProductById(Mockito.<Long>any())).thenReturn(productBundleImpl);
    when(ratingService.readRatingSummary(Mockito.<String>any(), Mockito.<RatingType>any()))
        .thenReturn(new RatingSummaryImpl());

    MockHttpServletRequest servletRequest = mock(MockHttpServletRequest.class);
    doNothing().when(servletRequest).setCharacterEncoding(Mockito.<String>any());
    when(servletRequest.getAttribute(Mockito.<String>any())).thenReturn(new ProductBundleImpl());
    doNothing().when(servletRequest).addParameter(Mockito.<String>any(), Mockito.<String>any());
    doNothing().when(servletRequest).setAttribute(Mockito.<String>any(), Mockito.<Object>any());
    servletRequest.addParameter("currentProduct", "42");

    SearchRequestWrapper request = new SearchRequestWrapper(servletRequest);
    request.setCharacterEncoding("currentProduct");
    request.setAttribute("currentProduct", "42");
    HttpServletRequestWrapper request2 = new HttpServletRequestWrapper(request);
    JSONArray schemaObjects = new JSONArray(3);

    // Act
    JSONArray actualLinkedDataJsonInternal =
        productLinkedDataGeneratorImpl.getLinkedDataJsonInternal(
            "https://example.org/example", request2, schemaObjects);

    // Assert
    verify(linkedDataGeneratorExtensionManager, atLeast(1)).getProxy();
    verify(money, atLeast(1)).getAmount();
    verify(money).greaterThan(isA(BigDecimal.class));
    verify(money).lessThan(isA(BigDecimal.class));
    verify(productBundleImpl).getRetailPrice();
    verify(productBundleImpl).getAllSellableSkus();
    verify(productBundleImpl, atLeast(1)).getCategory();
    verify(productBundleImpl).getDefaultSku();
    verify(productBundleImpl).getId();
    verify(productBundleImpl).getLongDescription();
    verify(productBundleImpl).getManufacturer();
    verify(productBundleImpl).getMedia();
    verify(productBundleImpl).getName();
    verify(productBundleImpl).getPrice();
    verify(skuImpl, atLeast(1)).getActiveEndDate();
    verify(skuImpl).getId();
    verify(skuImpl, atLeast(1)).getInventoryType();
    verify(skuImpl).getPriceData();
    verify(skuImpl).isActive();
    verify(catalogService).findProductById(isNull());
    verify(ratingService).readRatingSummary(eq("1"), isA(RatingType.class));
    verify(servletRequest).addParameter("currentProduct", "42");
    verify(servletRequest).getAttribute("currentProduct");
    verify(servletRequest).setAttribute(eq("currentProduct"), isA(Object.class));
    verify(servletRequest).setCharacterEncoding("currentProduct");
    assertEquals(1, schemaObjects.length());
    assertSame(schemaObjects, actualLinkedDataJsonInternal);
  }

  /**
   * Test {@link ProductLinkedDataGeneratorImpl#getLinkedDataJsonInternal(String,
   * HttpServletRequest, JSONArray)}.
   *
   * <ul>
   *   <li>Given {@link SkuImpl} {@link SkuImpl#getInventoryType()} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ProductLinkedDataGeneratorImpl#getLinkedDataJsonInternal(String,
   * HttpServletRequest, JSONArray)}
   */
  @Test
  @DisplayName(
      "Test getLinkedDataJsonInternal(String, HttpServletRequest, JSONArray); given SkuImpl getInventoryType() return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "JSONArray ProductLinkedDataGeneratorImpl.getLinkedDataJsonInternal(String, HttpServletRequest, JSONArray)"
  })
  void testGetLinkedDataJsonInternal_givenSkuImplGetInventoryTypeReturnNull()
      throws UnsupportedEncodingException, JSONException {
    // Arrange
    when(linkedDataGeneratorExtensionManager.getProxy())
        .thenReturn(new DefaultLinkedDataGeneratorExtensionHandler());

    DynamicSkuPrices dynamicSkuPrices = new DynamicSkuPrices();
    dynamicSkuPrices.setDidOverride(true);
    dynamicSkuPrices.setPriceAdjustment(new Money());
    dynamicSkuPrices.setRetailPrice(new Money());
    dynamicSkuPrices.setSalePrice(new Money());

    SkuImpl skuImpl = mock(SkuImpl.class);
    when(skuImpl.getInventoryType()).thenReturn(null);
    when(skuImpl.isActive()).thenReturn(true);
    when(skuImpl.getId()).thenReturn(1L);
    when(skuImpl.getActiveEndDate())
        .thenReturn(
            Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    when(skuImpl.getPriceData()).thenReturn(dynamicSkuPrices);

    ArrayList<Sku> skuList = new ArrayList<>();
    skuList.add(skuImpl);
    skuList.add(new SkuImpl());

    Money money = mock(Money.class);
    when(money.lessThan(Mockito.<BigDecimal>any())).thenReturn(true);
    when(money.greaterThan(Mockito.<BigDecimal>any())).thenReturn(true);
    when(money.getAmount()).thenReturn(new BigDecimal("2.3"));

    ProductBundleImpl productBundleImpl = mock(ProductBundleImpl.class);
    when(productBundleImpl.getPrice()).thenReturn(money);
    when(productBundleImpl.getId()).thenReturn(1L);
    when(productBundleImpl.getAllSellableSkus()).thenReturn(skuList);
    when(productBundleImpl.getRetailPrice()).thenReturn(new Money());
    when(productBundleImpl.getCategory()).thenReturn(new CategoryImpl());
    when(productBundleImpl.getLongDescription()).thenReturn("Long Description");
    when(productBundleImpl.getManufacturer()).thenReturn("Manufacturer");
    when(productBundleImpl.getName()).thenReturn("Name");
    when(productBundleImpl.getMedia()).thenReturn(new HashMap<>());
    when(productBundleImpl.getDefaultSku()).thenReturn(new SkuImpl());
    when(catalogService.findProductById(Mockito.<Long>any())).thenReturn(productBundleImpl);
    when(ratingService.readRatingSummary(Mockito.<String>any(), Mockito.<RatingType>any()))
        .thenReturn(new RatingSummaryImpl());

    MockHttpServletRequest servletRequest = mock(MockHttpServletRequest.class);
    doNothing().when(servletRequest).setCharacterEncoding(Mockito.<String>any());
    when(servletRequest.getAttribute(Mockito.<String>any())).thenReturn(new ProductBundleImpl());
    doNothing().when(servletRequest).addParameter(Mockito.<String>any(), Mockito.<String>any());
    doNothing().when(servletRequest).setAttribute(Mockito.<String>any(), Mockito.<Object>any());
    servletRequest.addParameter("currentProduct", "42");

    SearchRequestWrapper request = new SearchRequestWrapper(servletRequest);
    request.setCharacterEncoding("currentProduct");
    request.setAttribute("currentProduct", "42");
    HttpServletRequestWrapper request2 = new HttpServletRequestWrapper(request);
    JSONArray schemaObjects = new JSONArray(3);

    // Act
    JSONArray actualLinkedDataJsonInternal =
        productLinkedDataGeneratorImpl.getLinkedDataJsonInternal(
            "https://example.org/example", request2, schemaObjects);

    // Assert
    verify(linkedDataGeneratorExtensionManager, atLeast(1)).getProxy();
    verify(money, atLeast(1)).getAmount();
    verify(money).greaterThan(isA(BigDecimal.class));
    verify(money).lessThan(isA(BigDecimal.class));
    verify(productBundleImpl).getRetailPrice();
    verify(productBundleImpl).getAllSellableSkus();
    verify(productBundleImpl, atLeast(1)).getCategory();
    verify(productBundleImpl).getDefaultSku();
    verify(productBundleImpl).getId();
    verify(productBundleImpl).getLongDescription();
    verify(productBundleImpl).getManufacturer();
    verify(productBundleImpl).getMedia();
    verify(productBundleImpl).getName();
    verify(productBundleImpl).getPrice();
    verify(skuImpl, atLeast(1)).getActiveEndDate();
    verify(skuImpl).getId();
    verify(skuImpl).getInventoryType();
    verify(skuImpl).getPriceData();
    verify(skuImpl).isActive();
    verify(catalogService).findProductById(isNull());
    verify(ratingService).readRatingSummary(eq("1"), isA(RatingType.class));
    verify(servletRequest).addParameter("currentProduct", "42");
    verify(servletRequest).getAttribute("currentProduct");
    verify(servletRequest).setAttribute(eq("currentProduct"), isA(Object.class));
    verify(servletRequest).setCharacterEncoding("currentProduct");
    assertEquals(1, schemaObjects.length());
    assertSame(schemaObjects, actualLinkedDataJsonInternal);
  }

  /**
   * Test {@link ProductLinkedDataGeneratorImpl#getLinkedDataJsonInternal(String,
   * HttpServletRequest, JSONArray)}.
   *
   * <ul>
   *   <li>Then {@link JSONArray#JSONArray(int)} with capacity is three length is one.
   * </ul>
   *
   * <p>Method under test: {@link ProductLinkedDataGeneratorImpl#getLinkedDataJsonInternal(String,
   * HttpServletRequest, JSONArray)}
   */
  @Test
  @DisplayName(
      "Test getLinkedDataJsonInternal(String, HttpServletRequest, JSONArray); then JSONArray(int) with capacity is three length is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "JSONArray ProductLinkedDataGeneratorImpl.getLinkedDataJsonInternal(String, HttpServletRequest, JSONArray)"
  })
  void testGetLinkedDataJsonInternal_thenJSONArrayWithCapacityIsThreeLengthIsOne()
      throws UnsupportedEncodingException, JSONException {
    // Arrange
    when(linkedDataGeneratorExtensionManager.getProxy())
        .thenReturn(new DefaultLinkedDataGeneratorExtensionHandler());

    ProductBundleImpl productBundleImpl = mock(ProductBundleImpl.class);
    when(productBundleImpl.getId()).thenReturn(1L);
    when(productBundleImpl.getAllSellableSkus()).thenReturn(new ArrayList<>());
    when(productBundleImpl.getRetailPrice()).thenReturn(new Money());
    when(productBundleImpl.getCategory()).thenReturn(new CategoryImpl());
    when(productBundleImpl.getLongDescription()).thenReturn("Long Description");
    when(productBundleImpl.getManufacturer()).thenReturn("Manufacturer");
    when(productBundleImpl.getName()).thenReturn("Name");
    when(productBundleImpl.getMedia()).thenReturn(new HashMap<>());
    when(productBundleImpl.getDefaultSku()).thenReturn(new SkuImpl());
    when(catalogService.findProductById(Mockito.<Long>any())).thenReturn(productBundleImpl);
    when(ratingService.readRatingSummary(Mockito.<String>any(), Mockito.<RatingType>any()))
        .thenReturn(new RatingSummaryImpl());

    MockHttpServletRequest servletRequest = mock(MockHttpServletRequest.class);
    doNothing().when(servletRequest).setCharacterEncoding(Mockito.<String>any());
    when(servletRequest.getAttribute(Mockito.<String>any())).thenReturn(new ProductBundleImpl());
    doNothing().when(servletRequest).addParameter(Mockito.<String>any(), Mockito.<String>any());
    doNothing().when(servletRequest).setAttribute(Mockito.<String>any(), Mockito.<Object>any());
    servletRequest.addParameter("currentProduct", "42");

    SearchRequestWrapper request = new SearchRequestWrapper(servletRequest);
    request.setCharacterEncoding("currentProduct");
    request.setAttribute("currentProduct", "42");
    HttpServletRequestWrapper request2 = new HttpServletRequestWrapper(request);
    JSONArray schemaObjects = new JSONArray(3);

    // Act
    JSONArray actualLinkedDataJsonInternal =
        productLinkedDataGeneratorImpl.getLinkedDataJsonInternal(
            "https://example.org/example", request2, schemaObjects);

    // Assert
    verify(linkedDataGeneratorExtensionManager).getProxy();
    verify(productBundleImpl).getRetailPrice();
    verify(productBundleImpl).getAllSellableSkus();
    verify(productBundleImpl).getCategory();
    verify(productBundleImpl).getDefaultSku();
    verify(productBundleImpl).getId();
    verify(productBundleImpl).getLongDescription();
    verify(productBundleImpl).getManufacturer();
    verify(productBundleImpl).getMedia();
    verify(productBundleImpl).getName();
    verify(catalogService).findProductById(isNull());
    verify(ratingService).readRatingSummary(eq("1"), isA(RatingType.class));
    verify(servletRequest).addParameter("currentProduct", "42");
    verify(servletRequest).getAttribute("currentProduct");
    verify(servletRequest).setAttribute(eq("currentProduct"), isA(Object.class));
    verify(servletRequest).setCharacterEncoding("currentProduct");
    assertEquals(1, schemaObjects.length());
    assertSame(schemaObjects, actualLinkedDataJsonInternal);
  }

  /**
   * Test {@link ProductLinkedDataGeneratorImpl#getLinkedDataJsonInternal(String,
   * HttpServletRequest, JSONArray)}.
   *
   * <ul>
   *   <li>Then {@link JSONArray#JSONArray(int)} with capacity is three length is zero.
   * </ul>
   *
   * <p>Method under test: {@link ProductLinkedDataGeneratorImpl#getLinkedDataJsonInternal(String,
   * HttpServletRequest, JSONArray)}
   */
  @Test
  @DisplayName(
      "Test getLinkedDataJsonInternal(String, HttpServletRequest, JSONArray); then JSONArray(int) with capacity is three length is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "JSONArray ProductLinkedDataGeneratorImpl.getLinkedDataJsonInternal(String, HttpServletRequest, JSONArray)"
  })
  void testGetLinkedDataJsonInternal_thenJSONArrayWithCapacityIsThreeLengthIsZero()
      throws UnsupportedEncodingException, JSONException {
    // Arrange
    when(catalogService.findProductById(Mockito.<Long>any())).thenReturn(null);

    MockHttpServletRequest servletRequest = mock(MockHttpServletRequest.class);
    doNothing().when(servletRequest).setCharacterEncoding(Mockito.<String>any());
    when(servletRequest.getAttribute(Mockito.<String>any())).thenReturn(new ProductBundleImpl());
    doNothing().when(servletRequest).addParameter(Mockito.<String>any(), Mockito.<String>any());
    doNothing().when(servletRequest).setAttribute(Mockito.<String>any(), Mockito.<Object>any());
    servletRequest.addParameter("currentProduct", "42");

    SearchRequestWrapper request = new SearchRequestWrapper(servletRequest);
    request.setCharacterEncoding("currentProduct");
    request.setAttribute("currentProduct", "42");
    HttpServletRequestWrapper request2 = new HttpServletRequestWrapper(request);
    JSONArray schemaObjects = new JSONArray(3);

    // Act
    JSONArray actualLinkedDataJsonInternal =
        productLinkedDataGeneratorImpl.getLinkedDataJsonInternal(
            "https://example.org/example", request2, schemaObjects);

    // Assert
    verify(catalogService).findProductById(isNull());
    verify(servletRequest).addParameter("currentProduct", "42");
    verify(servletRequest).getAttribute("currentProduct");
    verify(servletRequest).setAttribute(eq("currentProduct"), isA(Object.class));
    verify(servletRequest).setCharacterEncoding("currentProduct");
    assertEquals(0, schemaObjects.length());
    assertSame(schemaObjects, actualLinkedDataJsonInternal);
  }

  /**
   * Test {@link ProductLinkedDataGeneratorImpl#getProduct(HttpServletRequest)}.
   *
   * <ul>
   *   <li>Then return {@link ProductBundleImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link ProductLinkedDataGeneratorImpl#getProduct(HttpServletRequest)}
   */
  @Test
  @DisplayName(
      "Test getProduct(HttpServletRequest); then return ProductBundleImpl (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Product ProductLinkedDataGeneratorImpl.getProduct(HttpServletRequest)"})
  void testGetProduct_thenReturnProductBundleImpl() throws UnsupportedEncodingException {
    // Arrange
    ProductBundleImpl productBundleImpl = new ProductBundleImpl();
    when(catalogService.findProductById(Mockito.<Long>any())).thenReturn(productBundleImpl);

    MockHttpServletRequest servletRequest = mock(MockHttpServletRequest.class);
    doNothing().when(servletRequest).setCharacterEncoding(Mockito.<String>any());
    when(servletRequest.getAttribute(Mockito.<String>any())).thenReturn(new ProductBundleImpl());
    doNothing().when(servletRequest).addParameter(Mockito.<String>any(), Mockito.<String>any());
    doNothing().when(servletRequest).setAttribute(Mockito.<String>any(), Mockito.<Object>any());
    servletRequest.addParameter("currentProduct", "42");

    SearchRequestWrapper request = new SearchRequestWrapper(servletRequest);
    request.setCharacterEncoding("currentProduct");
    request.setAttribute("currentProduct", "42");

    // Act
    Product actualProduct =
        productLinkedDataGeneratorImpl.getProduct(new HttpServletRequestWrapper(request));

    // Assert
    verify(catalogService).findProductById(isNull());
    verify(servletRequest).addParameter("currentProduct", "42");
    verify(servletRequest).getAttribute("currentProduct");
    verify(servletRequest).setAttribute(eq("currentProduct"), isA(Object.class));
    verify(servletRequest).setCharacterEncoding("currentProduct");
    assertSame(productBundleImpl, actualProduct);
  }

  /**
   * Test {@link ProductLinkedDataGeneratorImpl#addProductData(HttpServletRequest, Product,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.
   *   <li>Then return RecursionDepthLimit is five hundred.
   * </ul>
   *
   * <p>Method under test: {@link ProductLinkedDataGeneratorImpl#addProductData(HttpServletRequest,
   * Product, String)}
   */
  @Test
  @DisplayName(
      "Test addProductData(HttpServletRequest, Product, String); given ArrayList(); then return RecursionDepthLimit is five hundred")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "JSONObject ProductLinkedDataGeneratorImpl.addProductData(HttpServletRequest, Product, String)"
  })
  void testAddProductData_givenArrayList_thenReturnRecursionDepthLimitIsFiveHundred()
      throws JSONException {
    // Arrange
    when(linkedDataGeneratorExtensionManager.getProxy())
        .thenReturn(new DefaultLinkedDataGeneratorExtensionHandler());
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(new SearchRequestWrapper(new MockHttpServletRequest()));

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
    JSONObject actualAddProductDataResult =
        productLinkedDataGeneratorImpl.addProductData(
            request, product, "https://example.org/example");

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
   * Test {@link ProductLinkedDataGeneratorImpl#addProductData(HttpServletRequest, Product,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link Money} {@link Money#getAmount()} return {@code null}.
   *   <li>Then calls {@link Money#getAmount()}.
   * </ul>
   *
   * <p>Method under test: {@link ProductLinkedDataGeneratorImpl#addProductData(HttpServletRequest,
   * Product, String)}
   */
  @Test
  @DisplayName(
      "Test addProductData(HttpServletRequest, Product, String); given Money getAmount() return 'null'; then calls getAmount()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "JSONObject ProductLinkedDataGeneratorImpl.addProductData(HttpServletRequest, Product, String)"
  })
  void testAddProductData_givenMoneyGetAmountReturnNull_thenCallsGetAmount() throws JSONException {
    // Arrange
    when(linkedDataGeneratorExtensionManager.getProxy())
        .thenReturn(new DefaultLinkedDataGeneratorExtensionHandler());
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(new SearchRequestWrapper(new MockHttpServletRequest()));

    ArrayList<Sku> skuList = new ArrayList<>();
    skuList.add(new SkuImpl());

    Money money = mock(Money.class);
    when(money.greaterThan(Mockito.<BigDecimal>any())).thenReturn(false);
    when(money.getAmount()).thenReturn(null);

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
    JSONObject actualAddProductDataResult =
        productLinkedDataGeneratorImpl.addProductData(
            request, product, "https://example.org/example");

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
   * Test {@link ProductLinkedDataGeneratorImpl#addProductData(HttpServletRequest, Product,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link Money} {@link Money#greaterThan(BigDecimal)} return {@code true}.
   *   <li>Then calls {@link Money#getAmount()}.
   * </ul>
   *
   * <p>Method under test: {@link ProductLinkedDataGeneratorImpl#addProductData(HttpServletRequest,
   * Product, String)}
   */
  @Test
  @DisplayName(
      "Test addProductData(HttpServletRequest, Product, String); given Money greaterThan(BigDecimal) return 'true'; then calls getAmount()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "JSONObject ProductLinkedDataGeneratorImpl.addProductData(HttpServletRequest, Product, String)"
  })
  void testAddProductData_givenMoneyGreaterThanReturnTrue_thenCallsGetAmount()
      throws JSONException {
    // Arrange
    when(linkedDataGeneratorExtensionManager.getProxy())
        .thenReturn(new DefaultLinkedDataGeneratorExtensionHandler());
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(new SearchRequestWrapper(new MockHttpServletRequest()));

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
    JSONObject actualAddProductDataResult =
        productLinkedDataGeneratorImpl.addProductData(
            request, product, "https://example.org/example");

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
   * Test {@link ProductLinkedDataGeneratorImpl#addProductData(HttpServletRequest, Product,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link Money} {@link Money#lessThan(BigDecimal)} return {@code false}.
   *   <li>Then calls {@link Money#lessThan(BigDecimal)}.
   * </ul>
   *
   * <p>Method under test: {@link ProductLinkedDataGeneratorImpl#addProductData(HttpServletRequest,
   * Product, String)}
   */
  @Test
  @DisplayName(
      "Test addProductData(HttpServletRequest, Product, String); given Money lessThan(BigDecimal) return 'false'; then calls lessThan(BigDecimal)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "JSONObject ProductLinkedDataGeneratorImpl.addProductData(HttpServletRequest, Product, String)"
  })
  void testAddProductData_givenMoneyLessThanReturnFalse_thenCallsLessThan() throws JSONException {
    // Arrange
    when(linkedDataGeneratorExtensionManager.getProxy())
        .thenReturn(new DefaultLinkedDataGeneratorExtensionHandler());
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(new SearchRequestWrapper(new MockHttpServletRequest()));

    ArrayList<Sku> skuList = new ArrayList<>();
    skuList.add(new SkuImpl());
    skuList.add(new SkuImpl());

    Money money = mock(Money.class);
    when(money.lessThan(Mockito.<BigDecimal>any())).thenReturn(false);
    when(money.greaterThan(Mockito.<BigDecimal>any())).thenReturn(false);
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
    JSONObject actualAddProductDataResult =
        productLinkedDataGeneratorImpl.addProductData(
            request, product, "https://example.org/example");

    // Assert
    verify(linkedDataGeneratorExtensionManager, atLeast(1)).getProxy();
    verify(money, atLeast(1)).getAmount();
    verify(money, atLeast(1)).greaterThan(isA(BigDecimal.class));
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
   * Test {@link ProductLinkedDataGeneratorImpl#addProductData(HttpServletRequest, Product,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link Money} {@link Money#lessThan(BigDecimal)} return {@code true}.
   *   <li>Then calls {@link Money#lessThan(BigDecimal)}.
   * </ul>
   *
   * <p>Method under test: {@link ProductLinkedDataGeneratorImpl#addProductData(HttpServletRequest,
   * Product, String)}
   */
  @Test
  @DisplayName(
      "Test addProductData(HttpServletRequest, Product, String); given Money lessThan(BigDecimal) return 'true'; then calls lessThan(BigDecimal)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "JSONObject ProductLinkedDataGeneratorImpl.addProductData(HttpServletRequest, Product, String)"
  })
  void testAddProductData_givenMoneyLessThanReturnTrue_thenCallsLessThan() throws JSONException {
    // Arrange
    when(linkedDataGeneratorExtensionManager.getProxy())
        .thenReturn(new DefaultLinkedDataGeneratorExtensionHandler());
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(new SearchRequestWrapper(new MockHttpServletRequest()));

    ArrayList<Sku> skuList = new ArrayList<>();
    skuList.add(new SkuImpl());
    skuList.add(new SkuImpl());

    Money money = mock(Money.class);
    when(money.lessThan(Mockito.<BigDecimal>any())).thenReturn(true);
    when(money.greaterThan(Mockito.<BigDecimal>any())).thenReturn(false);
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
    JSONObject actualAddProductDataResult =
        productLinkedDataGeneratorImpl.addProductData(
            request, product, "https://example.org/example");

    // Assert
    verify(linkedDataGeneratorExtensionManager, atLeast(1)).getProxy();
    verify(money, atLeast(1)).getAmount();
    verify(money, atLeast(1)).greaterThan(isA(BigDecimal.class));
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
   * Test {@link ProductLinkedDataGeneratorImpl#addProductData(HttpServletRequest, Product,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link Money#Money(double)} with amount is ten.
   * </ul>
   *
   * <p>Method under test: {@link ProductLinkedDataGeneratorImpl#addProductData(HttpServletRequest,
   * Product, String)}
   */
  @Test
  @DisplayName(
      "Test addProductData(HttpServletRequest, Product, String); given Money(double) with amount is ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "JSONObject ProductLinkedDataGeneratorImpl.addProductData(HttpServletRequest, Product, String)"
  })
  void testAddProductData_givenMoneyWithAmountIsTen() throws JSONException {
    // Arrange
    when(linkedDataGeneratorExtensionManager.getProxy())
        .thenReturn(new DefaultLinkedDataGeneratorExtensionHandler());
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(new SearchRequestWrapper(new MockHttpServletRequest()));

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
    JSONObject actualAddProductDataResult =
        productLinkedDataGeneratorImpl.addProductData(
            request, product, "https://example.org/example");

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
   * Test {@link ProductLinkedDataGeneratorImpl#addProductData(HttpServletRequest, Product,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link SkuImpl} {@link SkuImpl#getInventoryType()} return {@link
   *       InventoryType#InventoryType()}.
   * </ul>
   *
   * <p>Method under test: {@link ProductLinkedDataGeneratorImpl#addProductData(HttpServletRequest,
   * Product, String)}
   */
  @Test
  @DisplayName(
      "Test addProductData(HttpServletRequest, Product, String); given SkuImpl getInventoryType() return InventoryType()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "JSONObject ProductLinkedDataGeneratorImpl.addProductData(HttpServletRequest, Product, String)"
  })
  void testAddProductData_givenSkuImplGetInventoryTypeReturnInventoryType() throws JSONException {
    // Arrange
    when(linkedDataGeneratorExtensionManager.getProxy())
        .thenReturn(new DefaultLinkedDataGeneratorExtensionHandler());
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(new SearchRequestWrapper(new MockHttpServletRequest()));

    DynamicSkuPrices dynamicSkuPrices = new DynamicSkuPrices();
    dynamicSkuPrices.setDidOverride(true);
    dynamicSkuPrices.setPriceAdjustment(new Money());
    dynamicSkuPrices.setRetailPrice(new Money());
    dynamicSkuPrices.setSalePrice(new Money());

    SkuImpl skuImpl = mock(SkuImpl.class);
    when(skuImpl.getInventoryType()).thenReturn(new InventoryType());
    when(skuImpl.isActive()).thenReturn(true);
    when(skuImpl.getId()).thenReturn(1L);
    when(skuImpl.getActiveEndDate())
        .thenReturn(
            Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    when(skuImpl.getPriceData()).thenReturn(dynamicSkuPrices);

    ArrayList<Sku> skuList = new ArrayList<>();
    skuList.add(skuImpl);
    skuList.add(new SkuImpl());

    Money money = mock(Money.class);
    when(money.lessThan(Mockito.<BigDecimal>any())).thenReturn(false);
    when(money.greaterThan(Mockito.<BigDecimal>any())).thenReturn(false);
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
    JSONObject actualAddProductDataResult =
        productLinkedDataGeneratorImpl.addProductData(
            request, product, "https://example.org/example");

    // Assert
    verify(linkedDataGeneratorExtensionManager, atLeast(1)).getProxy();
    verify(money).getAmount();
    verify(money).greaterThan(isA(BigDecimal.class));
    verify(money).lessThan(isA(BigDecimal.class));
    verify(product).getRetailPrice();
    verify(product).getAllSellableSkus();
    verify(product, atLeast(1)).getCategory();
    verify(product).getDefaultSku();
    verify(product).getLongDescription();
    verify(product).getManufacturer();
    verify(product).getMedia();
    verify(product).getName();
    verify(product).getPrice();
    verify(skuImpl, atLeast(1)).getActiveEndDate();
    verify(skuImpl).getId();
    verify(skuImpl, atLeast(1)).getInventoryType();
    verify(skuImpl).getPriceData();
    verify(skuImpl).isActive();
    assertEquals(500, actualAddProductDataResult.getRecursionDepthLimit());
    assertEquals(7, actualAddProductDataResult.length());
    assertTrue(actualAddProductDataResult.isEscapeForwardSlashAlways());
  }

  /**
   * Test {@link ProductLinkedDataGeneratorImpl#addProductData(HttpServletRequest, Product,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link SkuImpl} {@link SkuImpl#getInventoryType()} return {@link InventoryType}.
   * </ul>
   *
   * <p>Method under test: {@link ProductLinkedDataGeneratorImpl#addProductData(HttpServletRequest,
   * Product, String)}
   */
  @Test
  @DisplayName(
      "Test addProductData(HttpServletRequest, Product, String); given SkuImpl getInventoryType() return InventoryType")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "JSONObject ProductLinkedDataGeneratorImpl.addProductData(HttpServletRequest, Product, String)"
  })
  void testAddProductData_givenSkuImplGetInventoryTypeReturnInventoryType2() throws JSONException {
    // Arrange
    when(linkedDataGeneratorExtensionManager.getProxy())
        .thenReturn(new DefaultLinkedDataGeneratorExtensionHandler());
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(new SearchRequestWrapper(new MockHttpServletRequest()));

    DynamicSkuPrices dynamicSkuPrices = new DynamicSkuPrices();
    dynamicSkuPrices.setDidOverride(true);
    dynamicSkuPrices.setPriceAdjustment(new Money());
    dynamicSkuPrices.setRetailPrice(new Money());
    dynamicSkuPrices.setSalePrice(new Money());

    SkuImpl skuImpl = mock(SkuImpl.class);
    when(skuImpl.getInventoryType()).thenReturn(mock(InventoryType.class));
    when(skuImpl.isActive()).thenReturn(true);
    when(skuImpl.getId()).thenReturn(1L);
    when(skuImpl.getActiveEndDate())
        .thenReturn(
            Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    when(skuImpl.getPriceData()).thenReturn(dynamicSkuPrices);

    ArrayList<Sku> skuList = new ArrayList<>();
    skuList.add(skuImpl);
    skuList.add(new SkuImpl());

    Money money = mock(Money.class);
    when(money.lessThan(Mockito.<BigDecimal>any())).thenReturn(false);
    when(money.greaterThan(Mockito.<BigDecimal>any())).thenReturn(false);
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
    JSONObject actualAddProductDataResult =
        productLinkedDataGeneratorImpl.addProductData(
            request, product, "https://example.org/example");

    // Assert
    verify(linkedDataGeneratorExtensionManager, atLeast(1)).getProxy();
    verify(money).getAmount();
    verify(money).greaterThan(isA(BigDecimal.class));
    verify(money).lessThan(isA(BigDecimal.class));
    verify(product).getRetailPrice();
    verify(product).getAllSellableSkus();
    verify(product, atLeast(1)).getCategory();
    verify(product).getDefaultSku();
    verify(product).getLongDescription();
    verify(product).getManufacturer();
    verify(product).getMedia();
    verify(product).getName();
    verify(product).getPrice();
    verify(skuImpl, atLeast(1)).getActiveEndDate();
    verify(skuImpl).getId();
    verify(skuImpl, atLeast(1)).getInventoryType();
    verify(skuImpl).getPriceData();
    verify(skuImpl).isActive();
    assertEquals(500, actualAddProductDataResult.getRecursionDepthLimit());
    assertEquals(7, actualAddProductDataResult.length());
    assertTrue(actualAddProductDataResult.isEscapeForwardSlashAlways());
  }

  /**
   * Test {@link ProductLinkedDataGeneratorImpl#addProductData(HttpServletRequest, Product,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link SkuImpl} {@link SkuImpl#getInventoryType()} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ProductLinkedDataGeneratorImpl#addProductData(HttpServletRequest,
   * Product, String)}
   */
  @Test
  @DisplayName(
      "Test addProductData(HttpServletRequest, Product, String); given SkuImpl getInventoryType() return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "JSONObject ProductLinkedDataGeneratorImpl.addProductData(HttpServletRequest, Product, String)"
  })
  void testAddProductData_givenSkuImplGetInventoryTypeReturnNull() throws JSONException {
    // Arrange
    when(linkedDataGeneratorExtensionManager.getProxy())
        .thenReturn(new DefaultLinkedDataGeneratorExtensionHandler());
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(new SearchRequestWrapper(new MockHttpServletRequest()));

    DynamicSkuPrices dynamicSkuPrices = new DynamicSkuPrices();
    dynamicSkuPrices.setDidOverride(true);
    dynamicSkuPrices.setPriceAdjustment(new Money());
    dynamicSkuPrices.setRetailPrice(new Money());
    dynamicSkuPrices.setSalePrice(new Money());

    SkuImpl skuImpl = mock(SkuImpl.class);
    when(skuImpl.getInventoryType()).thenReturn(null);
    when(skuImpl.isActive()).thenReturn(true);
    when(skuImpl.getId()).thenReturn(1L);
    when(skuImpl.getActiveEndDate())
        .thenReturn(
            Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    when(skuImpl.getPriceData()).thenReturn(dynamicSkuPrices);

    ArrayList<Sku> skuList = new ArrayList<>();
    skuList.add(skuImpl);
    skuList.add(new SkuImpl());

    Money money = mock(Money.class);
    when(money.lessThan(Mockito.<BigDecimal>any())).thenReturn(false);
    when(money.greaterThan(Mockito.<BigDecimal>any())).thenReturn(false);
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
    JSONObject actualAddProductDataResult =
        productLinkedDataGeneratorImpl.addProductData(
            request, product, "https://example.org/example");

    // Assert
    verify(linkedDataGeneratorExtensionManager, atLeast(1)).getProxy();
    verify(money).getAmount();
    verify(money).greaterThan(isA(BigDecimal.class));
    verify(money).lessThan(isA(BigDecimal.class));
    verify(product).getRetailPrice();
    verify(product).getAllSellableSkus();
    verify(product, atLeast(1)).getCategory();
    verify(product).getDefaultSku();
    verify(product).getLongDescription();
    verify(product).getManufacturer();
    verify(product).getMedia();
    verify(product).getName();
    verify(product).getPrice();
    verify(skuImpl, atLeast(1)).getActiveEndDate();
    verify(skuImpl).getId();
    verify(skuImpl).getInventoryType();
    verify(skuImpl).getPriceData();
    verify(skuImpl).isActive();
    assertEquals(500, actualAddProductDataResult.getRecursionDepthLimit());
    assertEquals(7, actualAddProductDataResult.length());
    assertTrue(actualAddProductDataResult.isEscapeForwardSlashAlways());
  }

  /**
   * Test {@link ProductLinkedDataGeneratorImpl#addProductData(HttpServletRequest, Product,
   * String)}.
   *
   * <ul>
   *   <li>When {@link ProductBundleImpl} {@link ProductBundleImpl#getPrice()} return {@link
   *       Money#Money()}.
   *   <li>Then calls {@link ProductBundleImpl#getPrice()}.
   * </ul>
   *
   * <p>Method under test: {@link ProductLinkedDataGeneratorImpl#addProductData(HttpServletRequest,
   * Product, String)}
   */
  @Test
  @DisplayName(
      "Test addProductData(HttpServletRequest, Product, String); when ProductBundleImpl getPrice() return Money(); then calls getPrice()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "JSONObject ProductLinkedDataGeneratorImpl.addProductData(HttpServletRequest, Product, String)"
  })
  void testAddProductData_whenProductBundleImplGetPriceReturnMoney_thenCallsGetPrice()
      throws JSONException {
    // Arrange
    when(linkedDataGeneratorExtensionManager.getProxy())
        .thenReturn(new DefaultLinkedDataGeneratorExtensionHandler());
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(new SearchRequestWrapper(new MockHttpServletRequest()));

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
    JSONObject actualAddProductDataResult =
        productLinkedDataGeneratorImpl.addProductData(
            request, product, "https://example.org/example");

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
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()}.
   *   <li>Then calls {@link ProductBundleImpl#getMedia()}.
   * </ul>
   *
   * <p>Method under test: {@link ProductLinkedDataGeneratorImpl#addImageUrl(Product, JSONObject)}
   */
  @Test
  @DisplayName("Test addImageUrl(Product, JSONObject); given HashMap(); then calls getMedia()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ProductLinkedDataGeneratorImpl.addImageUrl(Product, JSONObject)"})
  void testAddImageUrl_givenHashMap_thenCallsGetMedia() throws JSONException {
    // Arrange
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getMedia()).thenReturn(new HashMap<>());

    // Act
    productLinkedDataGeneratorImpl.addImageUrl(product, new JSONObject());

    // Assert
    verify(product).getMedia();
  }

  /**
   * Test {@link ProductLinkedDataGeneratorImpl#getImageUrlPrefix()}.
   *
   * <ul>
   *   <li>Given {@link Environment} {@link Environment#getProperty(String, Class, Object)} return
   *       {@code false}.
   *   <li>Then return {@code Property}.
   * </ul>
   *
   * <p>Method under test: {@link ProductLinkedDataGeneratorImpl#getImageUrlPrefix()}
   */
  @Test
  @DisplayName(
      "Test getImageUrlPrefix(); given Environment getProperty(String, Class, Object) return 'false'; then return 'Property'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ProductLinkedDataGeneratorImpl.getImageUrlPrefix()"})
  void testGetImageUrlPrefix_givenEnvironmentGetPropertyReturnFalse_thenReturnProperty() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any())).thenReturn("Property");
    when(environment.getProperty(
            Mockito.<String>any(), Mockito.<Class<Object>>any(), Mockito.<Object>any()))
        .thenReturn(false);

    // Act
    String actualImageUrlPrefix = productLinkedDataGeneratorImpl.getImageUrlPrefix();

    // Assert
    verify(environment).getProperty("asset.server.url.prefix");
    verify(environment).getProperty(eq("site.baseurl.secure"), isA(Class.class), isA(Object.class));
    assertEquals("Property", actualImageUrlPrefix);
  }

  /**
   * Test {@link ProductLinkedDataGeneratorImpl#getImageUrlPrefix()}.
   *
   * <ul>
   *   <li>Given {@link Environment} {@link Environment#getProperty(String)} return {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ProductLinkedDataGeneratorImpl#getImageUrlPrefix()}
   */
  @Test
  @DisplayName(
      "Test getImageUrlPrefix(); given Environment getProperty(String) return 'null'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ProductLinkedDataGeneratorImpl.getImageUrlPrefix()"})
  void testGetImageUrlPrefix_givenEnvironmentGetPropertyReturnNull_thenReturnNull() {
    // Arrange
    when(baseUrlResolver.getSiteBaseUrl()).thenReturn("https://example.org/example");
    when(environment.getProperty(Mockito.<String>any())).thenReturn(null);
    when(environment.getProperty(
            Mockito.<String>any(), Mockito.<Class<Object>>any(), Mockito.<Object>any()))
        .thenReturn(true);

    // Act
    String actualImageUrlPrefix = productLinkedDataGeneratorImpl.getImageUrlPrefix();

    // Assert
    verify(baseUrlResolver).getSiteBaseUrl();
    verify(environment).getProperty("asset.server.url.prefix.secure");
    verify(environment).getProperty(eq("site.baseurl.secure"), isA(Class.class), isA(Object.class));
    assertNull(actualImageUrlPrefix);
  }

  /**
   * Test {@link ProductLinkedDataGeneratorImpl#getImageUrlPrefix()}.
   *
   * <ul>
   *   <li>Given {@link Environment} {@link Environment#getProperty(String, Class, Object)} return
   *       {@code true}.
   *   <li>Then return {@code Property}.
   * </ul>
   *
   * <p>Method under test: {@link ProductLinkedDataGeneratorImpl#getImageUrlPrefix()}
   */
  @Test
  @DisplayName(
      "Test getImageUrlPrefix(); given Environment getProperty(String, Class, Object) return 'true'; then return 'Property'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ProductLinkedDataGeneratorImpl.getImageUrlPrefix()"})
  void testGetImageUrlPrefix_givenEnvironmentGetPropertyReturnTrue_thenReturnProperty() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any())).thenReturn("Property");
    when(environment.getProperty(
            Mockito.<String>any(), Mockito.<Class<Object>>any(), Mockito.<Object>any()))
        .thenReturn(true);

    // Act
    String actualImageUrlPrefix = productLinkedDataGeneratorImpl.getImageUrlPrefix();

    // Assert
    verify(environment).getProperty("asset.server.url.prefix.secure");
    verify(environment).getProperty(eq("site.baseurl.secure"), isA(Class.class), isA(Object.class));
    assertEquals("Property", actualImageUrlPrefix);
  }

  /**
   * Test {@link ProductLinkedDataGeneratorImpl#getAssetServerUrlPrefix()}.
   *
   * <ul>
   *   <li>Given {@link Environment} {@link Environment#getProperty(String, Class, Object)} return
   *       {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ProductLinkedDataGeneratorImpl#getAssetServerUrlPrefix()}
   */
  @Test
  @DisplayName(
      "Test getAssetServerUrlPrefix(); given Environment getProperty(String, Class, Object) return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ProductLinkedDataGeneratorImpl.getAssetServerUrlPrefix()"})
  void testGetAssetServerUrlPrefix_givenEnvironmentGetPropertyReturnFalse() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any())).thenReturn("Property");
    when(environment.getProperty(
            Mockito.<String>any(), Mockito.<Class<Object>>any(), Mockito.<Object>any()))
        .thenReturn(false);

    // Act
    String actualAssetServerUrlPrefix = productLinkedDataGeneratorImpl.getAssetServerUrlPrefix();

    // Assert
    verify(environment).getProperty("asset.server.url.prefix");
    verify(environment).getProperty(eq("site.baseurl.secure"), isA(Class.class), isA(Object.class));
    assertEquals("Property", actualAssetServerUrlPrefix);
  }

  /**
   * Test {@link ProductLinkedDataGeneratorImpl#getAssetServerUrlPrefix()}.
   *
   * <ul>
   *   <li>Given {@link Environment} {@link Environment#getProperty(String, Class, Object)} return
   *       {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ProductLinkedDataGeneratorImpl#getAssetServerUrlPrefix()}
   */
  @Test
  @DisplayName(
      "Test getAssetServerUrlPrefix(); given Environment getProperty(String, Class, Object) return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ProductLinkedDataGeneratorImpl.getAssetServerUrlPrefix()"})
  void testGetAssetServerUrlPrefix_givenEnvironmentGetPropertyReturnTrue() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any())).thenReturn("Property");
    when(environment.getProperty(
            Mockito.<String>any(), Mockito.<Class<Object>>any(), Mockito.<Object>any()))
        .thenReturn(true);

    // Act
    String actualAssetServerUrlPrefix = productLinkedDataGeneratorImpl.getAssetServerUrlPrefix();

    // Assert
    verify(environment).getProperty("asset.server.url.prefix.secure");
    verify(environment).getProperty(eq("site.baseurl.secure"), isA(Class.class), isA(Object.class));
    assertEquals("Property", actualAssetServerUrlPrefix);
  }

  /**
   * Test {@link ProductLinkedDataGeneratorImpl#addSkus(HttpServletRequest, Product, JSONObject,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.
   *   <li>Then {@link JSONObject#JSONObject()} length is one.
   * </ul>
   *
   * <p>Method under test: {@link ProductLinkedDataGeneratorImpl#addSkus(HttpServletRequest,
   * Product, JSONObject, String)}
   */
  @Test
  @DisplayName(
      "Test addSkus(HttpServletRequest, Product, JSONObject, String); given ArrayList(); then JSONObject() length is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ProductLinkedDataGeneratorImpl.addSkus(HttpServletRequest, Product, JSONObject, String)"
  })
  void testAddSkus_givenArrayList_thenJSONObjectLengthIsOne() throws JSONException {
    // Arrange
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(new SearchRequestWrapper(new MockHttpServletRequest()));

    Product product = mock(Product.class);
    when(product.getAllSellableSkus()).thenReturn(new ArrayList<>());
    when(product.getRetailPrice()).thenReturn(new Money());
    JSONObject productData = new JSONObject();

    // Act
    productLinkedDataGeneratorImpl.addSkus(
        request, product, productData, "https://example.org/example");

    // Assert
    verify(product).getAllSellableSkus();
    verify(product).getRetailPrice();
    assertEquals(1, productData.length());
  }

  /**
   * Test {@link ProductLinkedDataGeneratorImpl#addSkus(HttpServletRequest, Product, JSONObject,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link CategoryImpl} (default constructor).
   *   <li>When {@link Product} {@link Product#getPrice()} return {@link Money#Money()}.
   *   <li>Then calls {@link LinkedDataGeneratorExtensionManager#getProxy()}.
   * </ul>
   *
   * <p>Method under test: {@link ProductLinkedDataGeneratorImpl#addSkus(HttpServletRequest,
   * Product, JSONObject, String)}
   */
  @Test
  @DisplayName(
      "Test addSkus(HttpServletRequest, Product, JSONObject, String); given CategoryImpl (default constructor); when Product getPrice() return Money(); then calls getProxy()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ProductLinkedDataGeneratorImpl.addSkus(HttpServletRequest, Product, JSONObject, String)"
  })
  void testAddSkus_givenCategoryImpl_whenProductGetPriceReturnMoney_thenCallsGetProxy()
      throws JSONException {
    // Arrange
    when(linkedDataGeneratorExtensionManager.getProxy())
        .thenReturn(new DefaultLinkedDataGeneratorExtensionHandler());
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(new SearchRequestWrapper(new MockHttpServletRequest()));

    ArrayList<Sku> skuList = new ArrayList<>();
    skuList.add(new SkuImpl());

    Product product = mock(Product.class);
    when(product.getPrice()).thenReturn(new Money());
    when(product.getCategory()).thenReturn(new CategoryImpl());
    when(product.getAllSellableSkus()).thenReturn(skuList);
    when(product.getRetailPrice()).thenReturn(new Money());
    JSONObject productData = new JSONObject();

    // Act
    productLinkedDataGeneratorImpl.addSkus(
        request, product, productData, "https://example.org/example");

    // Assert
    verify(linkedDataGeneratorExtensionManager).getProxy();
    verify(product).getAllSellableSkus();
    verify(product).getCategory();
    verify(product).getPrice();
    verify(product).getRetailPrice();
    assertEquals(1, productData.length());
  }

  /**
   * Test {@link ProductLinkedDataGeneratorImpl#addSkus(HttpServletRequest, Product, JSONObject,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link Money} {@link Money#getAmount()} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ProductLinkedDataGeneratorImpl#addSkus(HttpServletRequest,
   * Product, JSONObject, String)}
   */
  @Test
  @DisplayName(
      "Test addSkus(HttpServletRequest, Product, JSONObject, String); given Money getAmount() return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ProductLinkedDataGeneratorImpl.addSkus(HttpServletRequest, Product, JSONObject, String)"
  })
  void testAddSkus_givenMoneyGetAmountReturnNull() throws JSONException {
    // Arrange
    when(linkedDataGeneratorExtensionManager.getProxy())
        .thenReturn(new DefaultLinkedDataGeneratorExtensionHandler());
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(new SearchRequestWrapper(new MockHttpServletRequest()));

    ArrayList<Sku> skuList = new ArrayList<>();
    skuList.add(new SkuImpl());

    Money money = mock(Money.class);
    when(money.greaterThan(Mockito.<BigDecimal>any())).thenReturn(false);
    when(money.getAmount()).thenReturn(null);

    Product product = mock(Product.class);
    when(product.getPrice()).thenReturn(money);
    when(product.getCategory()).thenReturn(new CategoryImpl());
    when(product.getAllSellableSkus()).thenReturn(skuList);
    when(product.getRetailPrice()).thenReturn(new Money());
    JSONObject productData = new JSONObject();

    // Act
    productLinkedDataGeneratorImpl.addSkus(
        request, product, productData, "https://example.org/example");

    // Assert
    verify(linkedDataGeneratorExtensionManager).getProxy();
    verify(money, atLeast(1)).getAmount();
    verify(money).greaterThan(isA(BigDecimal.class));
    verify(product).getAllSellableSkus();
    verify(product).getCategory();
    verify(product).getPrice();
    verify(product).getRetailPrice();
    assertEquals(1, productData.length());
  }

  /**
   * Test {@link ProductLinkedDataGeneratorImpl#addSkus(HttpServletRequest, Product, JSONObject,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link Money} {@link Money#getAmount()} return {@code null}.
   *   <li>Then calls {@link CategoryImpl#getName()}.
   * </ul>
   *
   * <p>Method under test: {@link ProductLinkedDataGeneratorImpl#addSkus(HttpServletRequest,
   * Product, JSONObject, String)}
   */
  @Test
  @DisplayName(
      "Test addSkus(HttpServletRequest, Product, JSONObject, String); given Money getAmount() return 'null'; then calls getName()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ProductLinkedDataGeneratorImpl.addSkus(HttpServletRequest, Product, JSONObject, String)"
  })
  void testAddSkus_givenMoneyGetAmountReturnNull_thenCallsGetName() throws JSONException {
    // Arrange
    when(linkedDataGeneratorExtensionManager.getProxy())
        .thenReturn(new DefaultLinkedDataGeneratorExtensionHandler());
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(new SearchRequestWrapper(new MockHttpServletRequest()));

    ArrayList<Sku> skuList = new ArrayList<>();
    skuList.add(new SkuImpl());

    CategoryImpl categoryImpl = mock(CategoryImpl.class);
    when(categoryImpl.getName()).thenReturn("Name");

    Money money = mock(Money.class);
    when(money.greaterThan(Mockito.<BigDecimal>any())).thenReturn(false);
    when(money.getAmount()).thenReturn(null);

    Product product = mock(Product.class);
    when(product.getPrice()).thenReturn(money);
    when(product.getCategory()).thenReturn(categoryImpl);
    when(product.getAllSellableSkus()).thenReturn(skuList);
    when(product.getRetailPrice()).thenReturn(new Money());
    JSONObject productData = new JSONObject();

    // Act
    productLinkedDataGeneratorImpl.addSkus(
        request, product, productData, "https://example.org/example");

    // Assert
    verify(linkedDataGeneratorExtensionManager).getProxy();
    verify(money, atLeast(1)).getAmount();
    verify(money).greaterThan(isA(BigDecimal.class));
    verify(categoryImpl).getName();
    verify(product).getAllSellableSkus();
    verify(product).getCategory();
    verify(product).getPrice();
    verify(product).getRetailPrice();
    assertEquals(1, productData.length());
  }

  /**
   * Test {@link ProductLinkedDataGeneratorImpl#addSkus(HttpServletRequest, Product, JSONObject,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link Money} {@link Money#greaterThan(BigDecimal)} return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ProductLinkedDataGeneratorImpl#addSkus(HttpServletRequest,
   * Product, JSONObject, String)}
   */
  @Test
  @DisplayName(
      "Test addSkus(HttpServletRequest, Product, JSONObject, String); given Money greaterThan(BigDecimal) return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ProductLinkedDataGeneratorImpl.addSkus(HttpServletRequest, Product, JSONObject, String)"
  })
  void testAddSkus_givenMoneyGreaterThanReturnTrue() throws JSONException {
    // Arrange
    when(linkedDataGeneratorExtensionManager.getProxy())
        .thenReturn(new DefaultLinkedDataGeneratorExtensionHandler());
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(new SearchRequestWrapper(new MockHttpServletRequest()));

    ArrayList<Sku> skuList = new ArrayList<>();
    skuList.add(new SkuImpl());

    Money money = mock(Money.class);
    when(money.greaterThan(Mockito.<BigDecimal>any())).thenReturn(true);
    when(money.getAmount()).thenReturn(new BigDecimal("2.3"));

    Product product = mock(Product.class);
    when(product.getPrice()).thenReturn(money);
    when(product.getCategory()).thenReturn(new CategoryImpl());
    when(product.getAllSellableSkus()).thenReturn(skuList);
    when(product.getRetailPrice()).thenReturn(new Money());
    JSONObject productData = new JSONObject();

    // Act
    productLinkedDataGeneratorImpl.addSkus(
        request, product, productData, "https://example.org/example");

    // Assert
    verify(linkedDataGeneratorExtensionManager).getProxy();
    verify(money, atLeast(1)).getAmount();
    verify(money).greaterThan(isA(BigDecimal.class));
    verify(product).getAllSellableSkus();
    verify(product).getCategory();
    verify(product).getPrice();
    verify(product).getRetailPrice();
    assertEquals(1, productData.length());
  }

  /**
   * Test {@link ProductLinkedDataGeneratorImpl#addSkus(HttpServletRequest, Product, JSONObject,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link Money} {@link Money#lessThan(BigDecimal)} return {@code false}.
   *   <li>Then calls {@link Money#lessThan(BigDecimal)}.
   * </ul>
   *
   * <p>Method under test: {@link ProductLinkedDataGeneratorImpl#addSkus(HttpServletRequest,
   * Product, JSONObject, String)}
   */
  @Test
  @DisplayName(
      "Test addSkus(HttpServletRequest, Product, JSONObject, String); given Money lessThan(BigDecimal) return 'false'; then calls lessThan(BigDecimal)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ProductLinkedDataGeneratorImpl.addSkus(HttpServletRequest, Product, JSONObject, String)"
  })
  void testAddSkus_givenMoneyLessThanReturnFalse_thenCallsLessThan() throws JSONException {
    // Arrange
    when(linkedDataGeneratorExtensionManager.getProxy())
        .thenReturn(new DefaultLinkedDataGeneratorExtensionHandler());
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(new SearchRequestWrapper(new MockHttpServletRequest()));

    ArrayList<Sku> skuList = new ArrayList<>();
    skuList.add(new SkuImpl());
    skuList.add(new SkuImpl());

    CategoryImpl categoryImpl = mock(CategoryImpl.class);
    when(categoryImpl.getName()).thenReturn("Name");

    Money money = mock(Money.class);
    when(money.lessThan(Mockito.<BigDecimal>any())).thenReturn(false);
    when(money.greaterThan(Mockito.<BigDecimal>any())).thenReturn(false);
    when(money.getAmount()).thenReturn(new BigDecimal("2.3"));

    Product product = mock(Product.class);
    when(product.getPrice()).thenReturn(money);
    when(product.getCategory()).thenReturn(categoryImpl);
    when(product.getAllSellableSkus()).thenReturn(skuList);
    when(product.getRetailPrice()).thenReturn(new Money());
    JSONObject productData = new JSONObject();

    // Act
    productLinkedDataGeneratorImpl.addSkus(
        request, product, productData, "https://example.org/example");

    // Assert
    verify(linkedDataGeneratorExtensionManager, atLeast(1)).getProxy();
    verify(money, atLeast(1)).getAmount();
    verify(money, atLeast(1)).greaterThan(isA(BigDecimal.class));
    verify(money).lessThan(isA(BigDecimal.class));
    verify(categoryImpl, atLeast(1)).getName();
    verify(product).getAllSellableSkus();
    verify(product, atLeast(1)).getCategory();
    verify(product, atLeast(1)).getPrice();
    verify(product).getRetailPrice();
    assertEquals(1, productData.length());
  }

  /**
   * Test {@link ProductLinkedDataGeneratorImpl#addSkus(HttpServletRequest, Product, JSONObject,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link Money} {@link Money#lessThan(BigDecimal)} return {@code true}.
   *   <li>Then calls {@link Money#lessThan(BigDecimal)}.
   * </ul>
   *
   * <p>Method under test: {@link ProductLinkedDataGeneratorImpl#addSkus(HttpServletRequest,
   * Product, JSONObject, String)}
   */
  @Test
  @DisplayName(
      "Test addSkus(HttpServletRequest, Product, JSONObject, String); given Money lessThan(BigDecimal) return 'true'; then calls lessThan(BigDecimal)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ProductLinkedDataGeneratorImpl.addSkus(HttpServletRequest, Product, JSONObject, String)"
  })
  void testAddSkus_givenMoneyLessThanReturnTrue_thenCallsLessThan() throws JSONException {
    // Arrange
    when(linkedDataGeneratorExtensionManager.getProxy())
        .thenReturn(new DefaultLinkedDataGeneratorExtensionHandler());
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(new SearchRequestWrapper(new MockHttpServletRequest()));

    ArrayList<Sku> skuList = new ArrayList<>();
    skuList.add(new SkuImpl());
    skuList.add(new SkuImpl());

    CategoryImpl categoryImpl = mock(CategoryImpl.class);
    when(categoryImpl.getName()).thenReturn("Name");

    Money money = mock(Money.class);
    when(money.lessThan(Mockito.<BigDecimal>any())).thenReturn(true);
    when(money.greaterThan(Mockito.<BigDecimal>any())).thenReturn(false);
    when(money.getAmount()).thenReturn(new BigDecimal("2.3"));

    Product product = mock(Product.class);
    when(product.getPrice()).thenReturn(money);
    when(product.getCategory()).thenReturn(categoryImpl);
    when(product.getAllSellableSkus()).thenReturn(skuList);
    when(product.getRetailPrice()).thenReturn(new Money());
    JSONObject productData = new JSONObject();

    // Act
    productLinkedDataGeneratorImpl.addSkus(
        request, product, productData, "https://example.org/example");

    // Assert
    verify(linkedDataGeneratorExtensionManager, atLeast(1)).getProxy();
    verify(money, atLeast(1)).getAmount();
    verify(money, atLeast(1)).greaterThan(isA(BigDecimal.class));
    verify(money).lessThan(isA(BigDecimal.class));
    verify(categoryImpl, atLeast(1)).getName();
    verify(product).getAllSellableSkus();
    verify(product, atLeast(1)).getCategory();
    verify(product, atLeast(1)).getPrice();
    verify(product).getRetailPrice();
    assertEquals(1, productData.length());
  }

  /**
   * Test {@link ProductLinkedDataGeneratorImpl#addSkus(HttpServletRequest, Product, JSONObject,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link Money#Money(double)} with amount is ten.
   * </ul>
   *
   * <p>Method under test: {@link ProductLinkedDataGeneratorImpl#addSkus(HttpServletRequest,
   * Product, JSONObject, String)}
   */
  @Test
  @DisplayName(
      "Test addSkus(HttpServletRequest, Product, JSONObject, String); given Money(double) with amount is ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ProductLinkedDataGeneratorImpl.addSkus(HttpServletRequest, Product, JSONObject, String)"
  })
  void testAddSkus_givenMoneyWithAmountIsTen() throws JSONException {
    // Arrange
    when(linkedDataGeneratorExtensionManager.getProxy())
        .thenReturn(new DefaultLinkedDataGeneratorExtensionHandler());
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(new SearchRequestWrapper(new MockHttpServletRequest()));

    ArrayList<Sku> skuList = new ArrayList<>();
    skuList.add(new SkuImpl());

    Product product = mock(Product.class);
    when(product.getPrice()).thenReturn(new Money(10.0d));
    when(product.getCategory()).thenReturn(new CategoryImpl());
    when(product.getAllSellableSkus()).thenReturn(skuList);
    when(product.getRetailPrice()).thenReturn(new Money());
    JSONObject productData = new JSONObject();

    // Act
    productLinkedDataGeneratorImpl.addSkus(
        request, product, productData, "https://example.org/example");

    // Assert
    verify(linkedDataGeneratorExtensionManager).getProxy();
    verify(product).getAllSellableSkus();
    verify(product).getCategory();
    verify(product).getPrice();
    verify(product).getRetailPrice();
    assertEquals(1, productData.length());
  }

  /**
   * Test {@link ProductLinkedDataGeneratorImpl#addSkus(HttpServletRequest, Product, JSONObject,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link SkuImpl} {@link SkuImpl#getInventoryType()} return {@link
   *       InventoryType#InventoryType()}.
   * </ul>
   *
   * <p>Method under test: {@link ProductLinkedDataGeneratorImpl#addSkus(HttpServletRequest,
   * Product, JSONObject, String)}
   */
  @Test
  @DisplayName(
      "Test addSkus(HttpServletRequest, Product, JSONObject, String); given SkuImpl getInventoryType() return InventoryType()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ProductLinkedDataGeneratorImpl.addSkus(HttpServletRequest, Product, JSONObject, String)"
  })
  void testAddSkus_givenSkuImplGetInventoryTypeReturnInventoryType() throws JSONException {
    // Arrange
    when(linkedDataGeneratorExtensionManager.getProxy())
        .thenReturn(new DefaultLinkedDataGeneratorExtensionHandler());
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(new SearchRequestWrapper(new MockHttpServletRequest()));

    DynamicSkuPrices dynamicSkuPrices = new DynamicSkuPrices();
    dynamicSkuPrices.setDidOverride(true);
    dynamicSkuPrices.setPriceAdjustment(new Money());
    dynamicSkuPrices.setRetailPrice(new Money());
    dynamicSkuPrices.setSalePrice(new Money());

    SkuImpl skuImpl = mock(SkuImpl.class);
    when(skuImpl.getInventoryType()).thenReturn(new InventoryType());
    when(skuImpl.isActive()).thenReturn(true);
    when(skuImpl.getId()).thenReturn(1L);
    when(skuImpl.getActiveEndDate())
        .thenReturn(
            Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    when(skuImpl.getPriceData()).thenReturn(dynamicSkuPrices);

    ArrayList<Sku> skuList = new ArrayList<>();
    skuList.add(skuImpl);
    skuList.add(new SkuImpl());

    CategoryImpl categoryImpl = mock(CategoryImpl.class);
    when(categoryImpl.getName()).thenReturn("Name");

    Money money = mock(Money.class);
    when(money.lessThan(Mockito.<BigDecimal>any())).thenReturn(false);
    when(money.greaterThan(Mockito.<BigDecimal>any())).thenReturn(false);
    when(money.getAmount()).thenReturn(new BigDecimal("2.3"));

    Product product = mock(Product.class);
    when(product.getPrice()).thenReturn(money);
    when(product.getCategory()).thenReturn(categoryImpl);
    when(product.getAllSellableSkus()).thenReturn(skuList);
    when(product.getRetailPrice()).thenReturn(new Money());
    JSONObject productData = new JSONObject();

    // Act
    productLinkedDataGeneratorImpl.addSkus(
        request, product, productData, "https://example.org/example");

    // Assert
    verify(linkedDataGeneratorExtensionManager, atLeast(1)).getProxy();
    verify(money).getAmount();
    verify(money).greaterThan(isA(BigDecimal.class));
    verify(money).lessThan(isA(BigDecimal.class));
    verify(categoryImpl, atLeast(1)).getName();
    verify(product).getAllSellableSkus();
    verify(product, atLeast(1)).getCategory();
    verify(product).getPrice();
    verify(product).getRetailPrice();
    verify(skuImpl, atLeast(1)).getActiveEndDate();
    verify(skuImpl).getId();
    verify(skuImpl, atLeast(1)).getInventoryType();
    verify(skuImpl).getPriceData();
    verify(skuImpl).isActive();
    assertEquals(1, productData.length());
  }

  /**
   * Test {@link ProductLinkedDataGeneratorImpl#addSkus(HttpServletRequest, Product, JSONObject,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link SkuImpl} {@link SkuImpl#getInventoryType()} return {@link InventoryType}.
   * </ul>
   *
   * <p>Method under test: {@link ProductLinkedDataGeneratorImpl#addSkus(HttpServletRequest,
   * Product, JSONObject, String)}
   */
  @Test
  @DisplayName(
      "Test addSkus(HttpServletRequest, Product, JSONObject, String); given SkuImpl getInventoryType() return InventoryType")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ProductLinkedDataGeneratorImpl.addSkus(HttpServletRequest, Product, JSONObject, String)"
  })
  void testAddSkus_givenSkuImplGetInventoryTypeReturnInventoryType2() throws JSONException {
    // Arrange
    when(linkedDataGeneratorExtensionManager.getProxy())
        .thenReturn(new DefaultLinkedDataGeneratorExtensionHandler());
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(new SearchRequestWrapper(new MockHttpServletRequest()));

    DynamicSkuPrices dynamicSkuPrices = new DynamicSkuPrices();
    dynamicSkuPrices.setDidOverride(true);
    dynamicSkuPrices.setPriceAdjustment(new Money());
    dynamicSkuPrices.setRetailPrice(new Money());
    dynamicSkuPrices.setSalePrice(new Money());

    SkuImpl skuImpl = mock(SkuImpl.class);
    when(skuImpl.getInventoryType()).thenReturn(mock(InventoryType.class));
    when(skuImpl.isActive()).thenReturn(true);
    when(skuImpl.getId()).thenReturn(1L);
    when(skuImpl.getActiveEndDate())
        .thenReturn(
            Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    when(skuImpl.getPriceData()).thenReturn(dynamicSkuPrices);

    ArrayList<Sku> skuList = new ArrayList<>();
    skuList.add(skuImpl);
    skuList.add(new SkuImpl());

    CategoryImpl categoryImpl = mock(CategoryImpl.class);
    when(categoryImpl.getName()).thenReturn("Name");

    Money money = mock(Money.class);
    when(money.lessThan(Mockito.<BigDecimal>any())).thenReturn(false);
    when(money.greaterThan(Mockito.<BigDecimal>any())).thenReturn(false);
    when(money.getAmount()).thenReturn(new BigDecimal("2.3"));

    Product product = mock(Product.class);
    when(product.getPrice()).thenReturn(money);
    when(product.getCategory()).thenReturn(categoryImpl);
    when(product.getAllSellableSkus()).thenReturn(skuList);
    when(product.getRetailPrice()).thenReturn(new Money());
    JSONObject productData = new JSONObject();

    // Act
    productLinkedDataGeneratorImpl.addSkus(
        request, product, productData, "https://example.org/example");

    // Assert
    verify(linkedDataGeneratorExtensionManager, atLeast(1)).getProxy();
    verify(money).getAmount();
    verify(money).greaterThan(isA(BigDecimal.class));
    verify(money).lessThan(isA(BigDecimal.class));
    verify(categoryImpl, atLeast(1)).getName();
    verify(product).getAllSellableSkus();
    verify(product, atLeast(1)).getCategory();
    verify(product).getPrice();
    verify(product).getRetailPrice();
    verify(skuImpl, atLeast(1)).getActiveEndDate();
    verify(skuImpl).getId();
    verify(skuImpl, atLeast(1)).getInventoryType();
    verify(skuImpl).getPriceData();
    verify(skuImpl).isActive();
    assertEquals(1, productData.length());
  }

  /**
   * Test {@link ProductLinkedDataGeneratorImpl#addSkus(HttpServletRequest, Product, JSONObject,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link SkuImpl} {@link SkuImpl#getInventoryType()} return {@code null}.
   *   <li>Then calls {@link SkuImpl#getActiveEndDate()}.
   * </ul>
   *
   * <p>Method under test: {@link ProductLinkedDataGeneratorImpl#addSkus(HttpServletRequest,
   * Product, JSONObject, String)}
   */
  @Test
  @DisplayName(
      "Test addSkus(HttpServletRequest, Product, JSONObject, String); given SkuImpl getInventoryType() return 'null'; then calls getActiveEndDate()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ProductLinkedDataGeneratorImpl.addSkus(HttpServletRequest, Product, JSONObject, String)"
  })
  void testAddSkus_givenSkuImplGetInventoryTypeReturnNull_thenCallsGetActiveEndDate()
      throws JSONException {
    // Arrange
    when(linkedDataGeneratorExtensionManager.getProxy())
        .thenReturn(new DefaultLinkedDataGeneratorExtensionHandler());
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(new SearchRequestWrapper(new MockHttpServletRequest()));

    DynamicSkuPrices dynamicSkuPrices = new DynamicSkuPrices();
    dynamicSkuPrices.setDidOverride(true);
    dynamicSkuPrices.setPriceAdjustment(new Money());
    dynamicSkuPrices.setRetailPrice(new Money());
    dynamicSkuPrices.setSalePrice(new Money());

    SkuImpl skuImpl = mock(SkuImpl.class);
    when(skuImpl.getInventoryType()).thenReturn(null);
    when(skuImpl.isActive()).thenReturn(true);
    when(skuImpl.getId()).thenReturn(1L);
    when(skuImpl.getActiveEndDate())
        .thenReturn(
            Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    when(skuImpl.getPriceData()).thenReturn(dynamicSkuPrices);

    ArrayList<Sku> skuList = new ArrayList<>();
    skuList.add(skuImpl);
    skuList.add(new SkuImpl());

    CategoryImpl categoryImpl = mock(CategoryImpl.class);
    when(categoryImpl.getName()).thenReturn("Name");

    Money money = mock(Money.class);
    when(money.lessThan(Mockito.<BigDecimal>any())).thenReturn(false);
    when(money.greaterThan(Mockito.<BigDecimal>any())).thenReturn(false);
    when(money.getAmount()).thenReturn(new BigDecimal("2.3"));

    Product product = mock(Product.class);
    when(product.getPrice()).thenReturn(money);
    when(product.getCategory()).thenReturn(categoryImpl);
    when(product.getAllSellableSkus()).thenReturn(skuList);
    when(product.getRetailPrice()).thenReturn(new Money());
    JSONObject productData = new JSONObject();

    // Act
    productLinkedDataGeneratorImpl.addSkus(
        request, product, productData, "https://example.org/example");

    // Assert
    verify(linkedDataGeneratorExtensionManager, atLeast(1)).getProxy();
    verify(money).getAmount();
    verify(money).greaterThan(isA(BigDecimal.class));
    verify(money).lessThan(isA(BigDecimal.class));
    verify(categoryImpl, atLeast(1)).getName();
    verify(product).getAllSellableSkus();
    verify(product, atLeast(1)).getCategory();
    verify(product).getPrice();
    verify(product).getRetailPrice();
    verify(skuImpl, atLeast(1)).getActiveEndDate();
    verify(skuImpl).getId();
    verify(skuImpl).getInventoryType();
    verify(skuImpl).getPriceData();
    verify(skuImpl).isActive();
    assertEquals(1, productData.length());
  }

  /**
   * Test {@link ProductLinkedDataGeneratorImpl#determineAvailability(Sku)}.
   *
   * <ul>
   *   <li>When {@link SkuImpl} (default constructor).
   *   <li>Then return {@code OutOfStock}.
   * </ul>
   *
   * <p>Method under test: {@link ProductLinkedDataGeneratorImpl#determineAvailability(Sku)}
   */
  @Test
  @DisplayName(
      "Test determineAvailability(Sku); when SkuImpl (default constructor); then return 'OutOfStock'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ProductLinkedDataGeneratorImpl.determineAvailability(Sku)"})
  void testDetermineAvailability_whenSkuImpl_thenReturnOutOfStock() {
    // Arrange, Act and Assert
    assertEquals("OutOfStock", productLinkedDataGeneratorImpl.determineAvailability(new SkuImpl()));
  }

  /**
   * Test {@link ProductLinkedDataGeneratorImpl#addReviewData(HttpServletRequest, Product,
   * JSONObject)}.
   *
   * <p>Method under test: {@link ProductLinkedDataGeneratorImpl#addReviewData(HttpServletRequest,
   * Product, JSONObject)}
   */
  @Test
  @DisplayName("Test addReviewData(HttpServletRequest, Product, JSONObject)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ProductLinkedDataGeneratorImpl.addReviewData(HttpServletRequest, Product, JSONObject)"
  })
  void testAddReviewData() throws JSONException {
    // Arrange
    when(linkedDataGeneratorExtensionManager.getProxy())
        .thenReturn(new DefaultLinkedDataGeneratorExtensionHandler());

    ArrayList<ReviewDetail> reviewDetailList = new ArrayList<>();
    CustomerImpl customer = new CustomerImpl();
    Date reivewSubmittedDate =
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    RatingDetailImpl ratingDetail = new RatingDetailImpl();

    ReviewDetailImpl reviewDetailImpl =
        new ReviewDetailImpl(
            customer, reivewSubmittedDate, ratingDetail, "ratingCount", new RatingSummaryImpl());
    reviewDetailList.add(reviewDetailImpl);

    RatingSummary ratingSummary = mock(RatingSummary.class);
    when(ratingSummary.getAverageRating()).thenReturn(10.0d);
    when(ratingSummary.getReviews()).thenReturn(reviewDetailList);
    when(ratingSummary.getNumberOfRatings()).thenReturn(10);
    when(ratingService.readRatingSummary(Mockito.<String>any(), Mockito.<RatingType>any()))
        .thenReturn(ratingSummary);
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(new SearchRequestWrapper(new MockHttpServletRequest()));

    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getId()).thenReturn(1L);
    JSONObject productData = new JSONObject();

    // Act
    productLinkedDataGeneratorImpl.addReviewData(request, product, productData);

    // Assert
    verify(linkedDataGeneratorExtensionManager, atLeast(1)).getProxy();
    verify(product).getId();
    verify(ratingSummary).getAverageRating();
    verify(ratingSummary, atLeast(1)).getNumberOfRatings();
    verify(ratingSummary).getReviews();
    verify(ratingService).readRatingSummary(eq("1"), isA(RatingType.class));
    assertEquals(2, productData.length());
  }

  /**
   * Test {@link ProductLinkedDataGeneratorImpl#addReviewData(HttpServletRequest, Product,
   * JSONObject)}.
   *
   * <ul>
   *   <li>Given {@link RatingService} {@link RatingService#readRatingSummary(String, RatingType)}
   *       return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ProductLinkedDataGeneratorImpl#addReviewData(HttpServletRequest,
   * Product, JSONObject)}
   */
  @Test
  @DisplayName(
      "Test addReviewData(HttpServletRequest, Product, JSONObject); given RatingService readRatingSummary(String, RatingType) return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ProductLinkedDataGeneratorImpl.addReviewData(HttpServletRequest, Product, JSONObject)"
  })
  void testAddReviewData_givenRatingServiceReadRatingSummaryReturnNull() throws JSONException {
    // Arrange
    when(ratingService.readRatingSummary(Mockito.<String>any(), Mockito.<RatingType>any()))
        .thenReturn(null);
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(new SearchRequestWrapper(new MockHttpServletRequest()));

    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getId()).thenReturn(1L);
    JSONObject productData = new JSONObject();

    // Act
    productLinkedDataGeneratorImpl.addReviewData(request, product, productData);

    // Assert that nothing has changed
    verify(product).getId();
    verify(ratingService).readRatingSummary(eq("1"), isA(RatingType.class));
    assertEquals(0, productData.length());
  }

  /**
   * Test {@link ProductLinkedDataGeneratorImpl#addReviewData(HttpServletRequest, Product,
   * JSONObject)}.
   *
   * <ul>
   *   <li>Given {@link RatingService} {@link RatingService#readRatingSummary(String, RatingType)}
   *       return {@link RatingSummaryImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link ProductLinkedDataGeneratorImpl#addReviewData(HttpServletRequest,
   * Product, JSONObject)}
   */
  @Test
  @DisplayName(
      "Test addReviewData(HttpServletRequest, Product, JSONObject); given RatingService readRatingSummary(String, RatingType) return RatingSummaryImpl (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ProductLinkedDataGeneratorImpl.addReviewData(HttpServletRequest, Product, JSONObject)"
  })
  void testAddReviewData_givenRatingServiceReadRatingSummaryReturnRatingSummaryImpl()
      throws JSONException {
    // Arrange
    when(ratingService.readRatingSummary(Mockito.<String>any(), Mockito.<RatingType>any()))
        .thenReturn(new RatingSummaryImpl());
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(new SearchRequestWrapper(new MockHttpServletRequest()));

    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getId()).thenReturn(1L);
    JSONObject productData = new JSONObject();

    // Act
    productLinkedDataGeneratorImpl.addReviewData(request, product, productData);

    // Assert that nothing has changed
    verify(product).getId();
    verify(ratingService).readRatingSummary(eq("1"), isA(RatingType.class));
    assertEquals(0, productData.length());
  }

  /**
   * Test {@link ProductLinkedDataGeneratorImpl#addReviewData(HttpServletRequest, Product,
   * JSONObject)}.
   *
   * <ul>
   *   <li>Then {@link JSONObject#JSONObject()} length is two.
   * </ul>
   *
   * <p>Method under test: {@link ProductLinkedDataGeneratorImpl#addReviewData(HttpServletRequest,
   * Product, JSONObject)}
   */
  @Test
  @DisplayName(
      "Test addReviewData(HttpServletRequest, Product, JSONObject); then JSONObject() length is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ProductLinkedDataGeneratorImpl.addReviewData(HttpServletRequest, Product, JSONObject)"
  })
  void testAddReviewData_thenJSONObjectLengthIsTwo() throws JSONException {
    // Arrange
    when(linkedDataGeneratorExtensionManager.getProxy())
        .thenReturn(new DefaultLinkedDataGeneratorExtensionHandler());

    RatingSummary ratingSummary = mock(RatingSummary.class);
    when(ratingSummary.getAverageRating()).thenReturn(10.0d);
    when(ratingSummary.getReviews()).thenReturn(new ArrayList<>());
    when(ratingSummary.getNumberOfRatings()).thenReturn(10);
    when(ratingService.readRatingSummary(Mockito.<String>any(), Mockito.<RatingType>any()))
        .thenReturn(ratingSummary);
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(new SearchRequestWrapper(new MockHttpServletRequest()));

    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getId()).thenReturn(1L);
    JSONObject productData = new JSONObject();

    // Act
    productLinkedDataGeneratorImpl.addReviewData(request, product, productData);

    // Assert
    verify(linkedDataGeneratorExtensionManager).getProxy();
    verify(product).getId();
    verify(ratingSummary).getAverageRating();
    verify(ratingSummary, atLeast(1)).getNumberOfRatings();
    verify(ratingSummary).getReviews();
    verify(ratingService).readRatingSummary(eq("1"), isA(RatingType.class));
    assertEquals(2, productData.length());
  }
}
