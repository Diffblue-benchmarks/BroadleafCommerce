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
package org.broadleafcommerce.core.web.expression;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.core.catalog.domain.Category;
import org.broadleafcommerce.core.catalog.domain.CategoryImpl;
import org.broadleafcommerce.core.catalog.domain.Product;
import org.broadleafcommerce.core.catalog.domain.ProductBundleImpl;
import org.broadleafcommerce.core.catalog.service.CatalogURLService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class BLCVariableExpressionDiffblueTest {
  @InjectMocks private BLCVariableExpression bLCVariableExpression;

  @Mock private CatalogURLService catalogURLService;

  /**
   * Test {@link BLCVariableExpression#getName()}.
   *
   * <p>Method under test: {@link BLCVariableExpression#getName()}
   */
  @Test
  @DisplayName("Test getName()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getName()"})
  void testGetName() {
    // Arrange, Act and Assert
    assertEquals("blc", new BLCVariableExpression().getName());
  }

  /**
   * Test {@link BLCVariableExpression#relativeURL(String, Category)} with {@code baseUrl}, {@code
   * category}.
   *
   * <p>Method under test: {@link BLCVariableExpression#relativeURL(String, Category)}
   */
  @Test
  @DisplayName("Test relativeURL(String, Category) with 'baseUrl', 'category'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.relativeURL(String, Category)"})
  void testRelativeURLWithBaseUrlCategory() {
    // Arrange
    when(catalogURLService.buildRelativeCategoryURL(Mockito.<String>any(), Mockito.<Category>any()))
        .thenReturn("https://example.org/example");

    // Act
    String actualRelativeURLResult =
        bLCVariableExpression.relativeURL("https://example.org/example", new CategoryImpl());

    // Assert
    verify(catalogURLService)
        .buildRelativeCategoryURL(eq("https://example.org/example"), isA(Category.class));
    assertEquals("https://example.org/example", actualRelativeURLResult);
  }

  /**
   * Test {@link BLCVariableExpression#relativeURL(String, Product)} with {@code baseUrl}, {@code
   * product}.
   *
   * <p>Method under test: {@link BLCVariableExpression#relativeURL(String, Product)}
   */
  @Test
  @DisplayName("Test relativeURL(String, Product) with 'baseUrl', 'product'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.relativeURL(String, Product)"})
  void testRelativeURLWithBaseUrlProduct() {
    // Arrange
    when(catalogURLService.buildRelativeProductURL(Mockito.<String>any(), Mockito.<Product>any()))
        .thenReturn("https://example.org/example");

    // Act
    String actualRelativeURLResult =
        bLCVariableExpression.relativeURL("https://example.org/example", new ProductBundleImpl());

    // Assert
    verify(catalogURLService)
        .buildRelativeProductURL(eq("https://example.org/example"), isA(Product.class));
    assertEquals("https://example.org/example", actualRelativeURLResult);
  }

  /**
   * Test {@link BLCVariableExpression#relativeURL(Category)} with {@code category}.
   *
   * <p>Method under test: {@link BLCVariableExpression#relativeURL(Category)}
   */
  @Test
  @DisplayName("Test relativeURL(Category) with 'category'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.relativeURL(Category)"})
  void testRelativeURLWithCategory() {
    // Arrange
    when(catalogURLService.buildRelativeCategoryURL(Mockito.<String>any(), Mockito.<Category>any()))
        .thenReturn("https://example.org/example");

    // Act
    String actualRelativeURLResult = bLCVariableExpression.relativeURL(new CategoryImpl());

    // Assert
    verify(catalogURLService).buildRelativeCategoryURL(eq(""), isA(Category.class));
    assertEquals("https://example.org/example", actualRelativeURLResult);
  }

  /**
   * Test {@link BLCVariableExpression#relativeURL(Product)} with {@code product}.
   *
   * <p>Method under test: {@link BLCVariableExpression#relativeURL(Product)}
   */
  @Test
  @DisplayName("Test relativeURL(Product) with 'product'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.relativeURL(Product)"})
  void testRelativeURLWithProduct() {
    // Arrange
    when(catalogURLService.buildRelativeProductURL(Mockito.<String>any(), Mockito.<Product>any()))
        .thenReturn("https://example.org/example");

    // Act
    String actualRelativeURLResult = bLCVariableExpression.relativeURL(new ProductBundleImpl());

    // Assert
    verify(catalogURLService).buildRelativeProductURL(eq(""), isA(Product.class));
    assertEquals("https://example.org/example", actualRelativeURLResult);
  }

  /**
   * Test {@link BLCVariableExpression#getCurrentUrl()}.
   *
   * <p>Method under test: {@link BLCVariableExpression#getCurrentUrl()}
   */
  @Test
  @DisplayName("Test getCurrentUrl()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getCurrentUrl()"})
  void testGetCurrentUrl() {
    // Arrange, Act and Assert
    assertEquals("", bLCVariableExpression.getCurrentUrl());
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression}.
   *   <li>When {@code 10Amount10}.
   *   <li>Then return {@code $1,010.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName(
      "Test getPrice(String); given BLCVariableExpression; when '10Amount10'; then return '$1,010.00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_givenBLCVariableExpression_when10Amount10_thenReturn101000() {
    // Arrange, Act and Assert
    assertEquals("$1,010.00", bLCVariableExpression.getPrice("10Amount10"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression}.
   *   <li>When {@code 10Amount42}.
   *   <li>Then return {@code $1,042.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName(
      "Test getPrice(String); given BLCVariableExpression; when '10Amount42'; then return '$1,042.00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_givenBLCVariableExpression_when10Amount42_thenReturn104200() {
    // Arrange, Act and Assert
    assertEquals("$1,042.00", bLCVariableExpression.getPrice("10Amount42"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression}.
   *   <li>When {@code 10AmountAmount}.
   *   <li>Then return {@code $10.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName(
      "Test getPrice(String); given BLCVariableExpression; when '10AmountAmount'; then return '$10.00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_givenBLCVariableExpression_when10AmountAmount_thenReturn1000() {
    // Arrange, Act and Assert
    assertEquals("$10.00", bLCVariableExpression.getPrice("10AmountAmount"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression}.
   *   <li>When {@code 10Amount[^\d.]+}.
   *   <li>Then return {@code $10.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName(
      "Test getPrice(String); given BLCVariableExpression; when '10Amount[^\\d.]+'; then return '$10.00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_givenBLCVariableExpression_when10AmountD_thenReturn1000() {
    // Arrange, Act and Assert
    assertEquals("$10.00", bLCVariableExpression.getPrice("10Amount[^\\d.]+"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression}.
   *   <li>When {@code 10AmountUSD}.
   *   <li>Then return {@code $10.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName(
      "Test getPrice(String); given BLCVariableExpression; when '10AmountUSD'; then return '$10.00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_givenBLCVariableExpression_when10AmountUSD_thenReturn1000() {
    // Arrange, Act and Assert
    assertEquals("$10.00", bLCVariableExpression.getPrice("10AmountUSD"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression}.
   *   <li>When {@code 10AmountU}.
   *   <li>Then return {@code $10.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName(
      "Test getPrice(String); given BLCVariableExpression; when '10AmountU'; then return '$10.00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_givenBLCVariableExpression_when10AmountU_thenReturn1000() {
    // Arrange, Act and Assert
    assertEquals("$10.00", bLCVariableExpression.getPrice("10AmountU"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression}.
   *   <li>When {@code 10Amount}.
   *   <li>Then return {@code $10.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName(
      "Test getPrice(String); given BLCVariableExpression; when '10Amount'; then return '$10.00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_givenBLCVariableExpression_when10Amount_thenReturn1000() {
    // Arrange, Act and Assert
    assertEquals("$10.00", bLCVariableExpression.getPrice("10Amount"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression}.
   *   <li>When {@code 10[^\d.]+10}.
   *   <li>Then return {@code $10.10}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName(
      "Test getPrice(String); given BLCVariableExpression; when '10[^\\d.]+10'; then return '$10.10'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_givenBLCVariableExpression_when10D10_thenReturn1010() {
    // Arrange, Act and Assert
    assertEquals("$10.10", bLCVariableExpression.getPrice("10[^\\d.]+10"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression}.
   *   <li>When {@code 10[^\d.]+42}.
   *   <li>Then return {@code $10.42}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName(
      "Test getPrice(String); given BLCVariableExpression; when '10[^\\d.]+42'; then return '$10.42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_givenBLCVariableExpression_when10D42_thenReturn1042() {
    // Arrange, Act and Assert
    assertEquals("$10.42", bLCVariableExpression.getPrice("10[^\\d.]+42"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression}.
   *   <li>When {@code 10[^\d.]+Amount}.
   *   <li>Then return {@code $10.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName(
      "Test getPrice(String); given BLCVariableExpression; when '10[^\\d.]+Amount'; then return '$10.00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_givenBLCVariableExpression_when10DAmount_thenReturn1000() {
    // Arrange, Act and Assert
    assertEquals("$10.00", bLCVariableExpression.getPrice("10[^\\d.]+Amount"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression}.
   *   <li>When {@code 10[^\d.]+U}.
   *   <li>Then return {@code $10.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName(
      "Test getPrice(String); given BLCVariableExpression; when '10[^\\d.]+U'; then return '$10.00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_givenBLCVariableExpression_when10DU_thenReturn1000() {
    // Arrange, Act and Assert
    assertEquals("$10.00", bLCVariableExpression.getPrice("10[^\\d.]+U"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression}.
   *   <li>When {@code 10[^\d.]+USD}.
   *   <li>Then return {@code $10.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName(
      "Test getPrice(String); given BLCVariableExpression; when '10[^\\d.]+USD'; then return '$10.00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_givenBLCVariableExpression_when10DUsd_thenReturn1000() {
    // Arrange, Act and Assert
    assertEquals("$10.00", bLCVariableExpression.getPrice("10[^\\d.]+USD"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression}.
   *   <li>When {@code 10[^\d.]+}.
   *   <li>Then return {@code $10.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName(
      "Test getPrice(String); given BLCVariableExpression; when '10[^\\d.]+'; then return '$10.00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_givenBLCVariableExpression_when10D_thenReturn1000() {
    // Arrange, Act and Assert
    assertEquals("$10.00", bLCVariableExpression.getPrice("10[^\\d.]+"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression}.
   *   <li>When {@code 10UAmount}.
   *   <li>Then return {@code $10.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName(
      "Test getPrice(String); given BLCVariableExpression; when '10UAmount'; then return '$10.00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_givenBLCVariableExpression_when10UAmount_thenReturn1000() {
    // Arrange, Act and Assert
    assertEquals("$10.00", bLCVariableExpression.getPrice("10UAmount"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression}.
   *   <li>When {@code 10USDAmount}.
   *   <li>Then return {@code $10.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName(
      "Test getPrice(String); given BLCVariableExpression; when '10USDAmount'; then return '$10.00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_givenBLCVariableExpression_when10USDAmount_thenReturn1000() {
    // Arrange, Act and Assert
    assertEquals("$10.00", bLCVariableExpression.getPrice("10USDAmount"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression}.
   *   <li>When {@code 10USDcurrency.default}.
   *   <li>Then return {@code $10.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName(
      "Test getPrice(String); given BLCVariableExpression; when '10USDcurrency.default'; then return '$10.00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_givenBLCVariableExpression_when10USDcurrencyDefault_thenReturn1000() {
    // Arrange, Act and Assert
    assertEquals("$10.00", bLCVariableExpression.getPrice("10USDcurrency.default"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression}.
   *   <li>When {@code 10Ucurrency.default}.
   *   <li>Then return {@code $10.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName(
      "Test getPrice(String); given BLCVariableExpression; when '10Ucurrency.default'; then return '$10.00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_givenBLCVariableExpression_when10UcurrencyDefault_thenReturn1000() {
    // Arrange, Act and Assert
    assertEquals("$10.00", bLCVariableExpression.getPrice("10Ucurrency.default"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression}.
   *   <li>When {@code 10}.
   *   <li>Then return {@code $10.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName(
      "Test getPrice(String); given BLCVariableExpression; when '10'; then return '$10.00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_givenBLCVariableExpression_when10_thenReturn1000() {
    // Arrange, Act and Assert
    assertEquals("$10.00", bLCVariableExpression.getPrice("10"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression}.
   *   <li>When {@code 10currency.default10}.
   *   <li>Then return {@code $10.10}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName(
      "Test getPrice(String); given BLCVariableExpression; when '10currency.default10'; then return '$10.10'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_givenBLCVariableExpression_when10currencyDefault10_thenReturn1010() {
    // Arrange, Act and Assert
    assertEquals("$10.10", bLCVariableExpression.getPrice("10currency.default10"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression}.
   *   <li>When {@code 10currency.default42}.
   *   <li>Then return {@code $10.42}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName(
      "Test getPrice(String); given BLCVariableExpression; when '10currency.default42'; then return '$10.42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_givenBLCVariableExpression_when10currencyDefault42_thenReturn1042() {
    // Arrange, Act and Assert
    assertEquals("$10.42", bLCVariableExpression.getPrice("10currency.default42"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression}.
   *   <li>When {@code 10currency.defaultUSD}.
   *   <li>Then return {@code $10.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName(
      "Test getPrice(String); given BLCVariableExpression; when '10currency.defaultUSD'; then return '$10.00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_givenBLCVariableExpression_when10currencyDefaultUSD_thenReturn1000() {
    // Arrange, Act and Assert
    assertEquals("$10.00", bLCVariableExpression.getPrice("10currency.defaultUSD"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression}.
   *   <li>When {@code 10currency.defaultU}.
   *   <li>Then return {@code $10.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName(
      "Test getPrice(String); given BLCVariableExpression; when '10currency.defaultU'; then return '$10.00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_givenBLCVariableExpression_when10currencyDefaultU_thenReturn1000() {
    // Arrange, Act and Assert
    assertEquals("$10.00", bLCVariableExpression.getPrice("10currency.defaultU"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression}.
   *   <li>When {@code 10currency.default}.
   *   <li>Then return {@code $10.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName(
      "Test getPrice(String); given BLCVariableExpression; when '10currency.default'; then return '$10.00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_givenBLCVariableExpression_when10currencyDefault_thenReturn1000() {
    // Arrange, Act and Assert
    assertEquals("$10.00", bLCVariableExpression.getPrice("10currency.default"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression}.
   *   <li>When {@code 10U10}.
   *   <li>Then return {@code $1,010.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName(
      "Test getPrice(String); given BLCVariableExpression; when '10U10'; then return '$1,010.00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_givenBLCVariableExpression_when10u10_thenReturn101000() {
    // Arrange, Act and Assert
    assertEquals("$1,010.00", bLCVariableExpression.getPrice("10U10"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression}.
   *   <li>When {@code 10U42}.
   *   <li>Then return {@code $1,042.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName(
      "Test getPrice(String); given BLCVariableExpression; when '10U42'; then return '$1,042.00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_givenBLCVariableExpression_when10u42_thenReturn104200() {
    // Arrange, Act and Assert
    assertEquals("$1,042.00", bLCVariableExpression.getPrice("10U42"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression}.
   *   <li>When {@code 10U[^\d.]+}.
   *   <li>Then return {@code $10.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName(
      "Test getPrice(String); given BLCVariableExpression; when '10U[^\\d.]+'; then return '$10.00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_givenBLCVariableExpression_when10uD_thenReturn1000() {
    // Arrange, Act and Assert
    assertEquals("$10.00", bLCVariableExpression.getPrice("10U[^\\d.]+"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression}.
   *   <li>When {@code 10U}.
   *   <li>Then return {@code $10.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName(
      "Test getPrice(String); given BLCVariableExpression; when '10U'; then return '$10.00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_givenBLCVariableExpression_when10u_thenReturn1000() {
    // Arrange, Act and Assert
    assertEquals("$10.00", bLCVariableExpression.getPrice("10U"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression}.
   *   <li>When {@code 10USD10}.
   *   <li>Then return {@code $1,010.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName(
      "Test getPrice(String); given BLCVariableExpression; when '10USD10'; then return '$1,010.00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_givenBLCVariableExpression_when10usd10_thenReturn101000() {
    // Arrange, Act and Assert
    assertEquals("$1,010.00", bLCVariableExpression.getPrice("10USD10"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression}.
   *   <li>When {@code 10USD42}.
   *   <li>Then return {@code $1,042.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName(
      "Test getPrice(String); given BLCVariableExpression; when '10USD42'; then return '$1,042.00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_givenBLCVariableExpression_when10usd42_thenReturn104200() {
    // Arrange, Act and Assert
    assertEquals("$1,042.00", bLCVariableExpression.getPrice("10USD42"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression}.
   *   <li>When {@code 10USD[^\d.]+}.
   *   <li>Then return {@code $10.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName(
      "Test getPrice(String); given BLCVariableExpression; when '10USD[^\\d.]+'; then return '$10.00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_givenBLCVariableExpression_when10usdD_thenReturn1000() {
    // Arrange, Act and Assert
    assertEquals("$10.00", bLCVariableExpression.getPrice("10USD[^\\d.]+"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression}.
   *   <li>When {@code 10USD}.
   *   <li>Then return {@code $10.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName(
      "Test getPrice(String); given BLCVariableExpression; when '10USD'; then return '$10.00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_givenBLCVariableExpression_when10usd_thenReturn1000() {
    // Arrange, Act and Assert
    assertEquals("$10.00", bLCVariableExpression.getPrice("10USD"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression}.
   *   <li>When {@code 10USDU}.
   *   <li>Then return {@code $10.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName(
      "Test getPrice(String); given BLCVariableExpression; when '10USDU'; then return '$10.00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_givenBLCVariableExpression_when10usdu_thenReturn1000() {
    // Arrange, Act and Assert
    assertEquals("$10.00", bLCVariableExpression.getPrice("10USDU"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression}.
   *   <li>When {@code 10USDUSD}.
   *   <li>Then return {@code $10.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName(
      "Test getPrice(String); given BLCVariableExpression; when '10USDUSD'; then return '$10.00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_givenBLCVariableExpression_when10usdusd_thenReturn1000() {
    // Arrange, Act and Assert
    assertEquals("$10.00", bLCVariableExpression.getPrice("10USDUSD"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression}.
   *   <li>When {@code 10UU}.
   *   <li>Then return {@code $10.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName(
      "Test getPrice(String); given BLCVariableExpression; when '10UU'; then return '$10.00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_givenBLCVariableExpression_when10uu_thenReturn1000() {
    // Arrange, Act and Assert
    assertEquals("$10.00", bLCVariableExpression.getPrice("10UU"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression}.
   *   <li>When {@code 10UUSD}.
   *   <li>Then return {@code $10.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName(
      "Test getPrice(String); given BLCVariableExpression; when '10UUSD'; then return '$10.00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_givenBLCVariableExpression_when10uusd_thenReturn1000() {
    // Arrange, Act and Assert
    assertEquals("$10.00", bLCVariableExpression.getPrice("10UUSD"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression}.
   *   <li>When {@code 42Amount}.
   *   <li>Then return {@code $42.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName(
      "Test getPrice(String); given BLCVariableExpression; when '42Amount'; then return '$42.00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_givenBLCVariableExpression_when42Amount_thenReturn4200() {
    // Arrange, Act and Assert
    assertEquals("$42.00", bLCVariableExpression.getPrice("42Amount"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression}.
   *   <li>When {@code 42[^\d.]+}.
   *   <li>Then return {@code $42.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName(
      "Test getPrice(String); given BLCVariableExpression; when '42[^\\d.]+'; then return '$42.00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_givenBLCVariableExpression_when42D_thenReturn4200() {
    // Arrange, Act and Assert
    assertEquals("$42.00", bLCVariableExpression.getPrice("42[^\\d.]+"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression}.
   *   <li>When {@code 42}.
   *   <li>Then return {@code $42.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName(
      "Test getPrice(String); given BLCVariableExpression; when '42'; then return '$42.00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_givenBLCVariableExpression_when42_thenReturn4200() {
    // Arrange, Act and Assert
    assertEquals("$42.00", bLCVariableExpression.getPrice("42"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression}.
   *   <li>When {@code 42currency.default}.
   *   <li>Then return {@code $42.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName(
      "Test getPrice(String); given BLCVariableExpression; when '42currency.default'; then return '$42.00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_givenBLCVariableExpression_when42currencyDefault_thenReturn4200() {
    // Arrange, Act and Assert
    assertEquals("$42.00", bLCVariableExpression.getPrice("42currency.default"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression}.
   *   <li>When {@code 42U}.
   *   <li>Then return {@code $42.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName(
      "Test getPrice(String); given BLCVariableExpression; when '42U'; then return '$42.00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_givenBLCVariableExpression_when42u_thenReturn4200() {
    // Arrange, Act and Assert
    assertEquals("$42.00", bLCVariableExpression.getPrice("42U"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression}.
   *   <li>When {@code 42USD}.
   *   <li>Then return {@code $42.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName(
      "Test getPrice(String); given BLCVariableExpression; when '42USD'; then return '$42.00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_givenBLCVariableExpression_when42usd_thenReturn4200() {
    // Arrange, Act and Assert
    assertEquals("$42.00", bLCVariableExpression.getPrice("42USD"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression}.
   *   <li>When {@code 1010Amount}.
   *   <li>Then return {@code $1,010.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName(
      "Test getPrice(String); given BLCVariableExpression; when '1010Amount'; then return '$1,010.00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_givenBLCVariableExpression_when1010Amount_thenReturn101000() {
    // Arrange, Act and Assert
    assertEquals("$1,010.00", bLCVariableExpression.getPrice("1010Amount"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression}.
   *   <li>When {@code 1010[^\d.]+}.
   *   <li>Then return {@code $1,010.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName(
      "Test getPrice(String); given BLCVariableExpression; when '1010[^\\d.]+'; then return '$1,010.00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_givenBLCVariableExpression_when1010D_thenReturn101000() {
    // Arrange, Act and Assert
    assertEquals("$1,010.00", bLCVariableExpression.getPrice("1010[^\\d.]+"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression}.
   *   <li>When {@code 1010currency.default}.
   *   <li>Then return {@code $1,010.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName(
      "Test getPrice(String); given BLCVariableExpression; when '1010currency.default'; then return '$1,010.00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_givenBLCVariableExpression_when1010currencyDefault_thenReturn101000() {
    // Arrange, Act and Assert
    assertEquals("$1,010.00", bLCVariableExpression.getPrice("1010currency.default"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression}.
   *   <li>When {@code 1010U}.
   *   <li>Then return {@code $1,010.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName(
      "Test getPrice(String); given BLCVariableExpression; when '1010U'; then return '$1,010.00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_givenBLCVariableExpression_when1010u_thenReturn101000() {
    // Arrange, Act and Assert
    assertEquals("$1,010.00", bLCVariableExpression.getPrice("1010U"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression}.
   *   <li>When {@code 1010USD}.
   *   <li>Then return {@code $1,010.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName(
      "Test getPrice(String); given BLCVariableExpression; when '1010USD'; then return '$1,010.00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_givenBLCVariableExpression_when1010usd_thenReturn101000() {
    // Arrange, Act and Assert
    assertEquals("$1,010.00", bLCVariableExpression.getPrice("1010USD"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression}.
   *   <li>When {@code 1042Amount}.
   *   <li>Then return {@code $1,042.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName(
      "Test getPrice(String); given BLCVariableExpression; when '1042Amount'; then return '$1,042.00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_givenBLCVariableExpression_when1042Amount_thenReturn104200() {
    // Arrange, Act and Assert
    assertEquals("$1,042.00", bLCVariableExpression.getPrice("1042Amount"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression}.
   *   <li>When {@code 1042[^\d.]+}.
   *   <li>Then return {@code $1,042.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName(
      "Test getPrice(String); given BLCVariableExpression; when '1042[^\\d.]+'; then return '$1,042.00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_givenBLCVariableExpression_when1042D_thenReturn104200() {
    // Arrange, Act and Assert
    assertEquals("$1,042.00", bLCVariableExpression.getPrice("1042[^\\d.]+"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression}.
   *   <li>When {@code 1042currency.default}.
   *   <li>Then return {@code $1,042.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName(
      "Test getPrice(String); given BLCVariableExpression; when '1042currency.default'; then return '$1,042.00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_givenBLCVariableExpression_when1042currencyDefault_thenReturn104200() {
    // Arrange, Act and Assert
    assertEquals("$1,042.00", bLCVariableExpression.getPrice("1042currency.default"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression}.
   *   <li>When {@code 1042U}.
   *   <li>Then return {@code $1,042.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName(
      "Test getPrice(String); given BLCVariableExpression; when '1042U'; then return '$1,042.00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_givenBLCVariableExpression_when1042u_thenReturn104200() {
    // Arrange, Act and Assert
    assertEquals("$1,042.00", bLCVariableExpression.getPrice("1042U"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression}.
   *   <li>When {@code 1042USD}.
   *   <li>Then return {@code $1,042.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName(
      "Test getPrice(String); given BLCVariableExpression; when '1042USD'; then return '$1,042.00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_givenBLCVariableExpression_when1042usd_thenReturn104200() {
    // Arrange, Act and Assert
    assertEquals("$1,042.00", bLCVariableExpression.getPrice("1042USD"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression}.
   *   <li>When {@code Amount10Amount}.
   *   <li>Then return {@code $10.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName(
      "Test getPrice(String); given BLCVariableExpression; when 'Amount10Amount'; then return '$10.00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_givenBLCVariableExpression_whenAmount10Amount_thenReturn1000() {
    // Arrange, Act and Assert
    assertEquals("$10.00", bLCVariableExpression.getPrice("Amount10Amount"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression}.
   *   <li>When {@code Amount10[^\d.]+}.
   *   <li>Then return {@code $10.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName(
      "Test getPrice(String); given BLCVariableExpression; when 'Amount10[^\\d.]+'; then return '$10.00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_givenBLCVariableExpression_whenAmount10D_thenReturn1000() {
    // Arrange, Act and Assert
    assertEquals("$10.00", bLCVariableExpression.getPrice("Amount10[^\\d.]+"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression}.
   *   <li>When {@code Amount10USD}.
   *   <li>Then return {@code $10.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName(
      "Test getPrice(String); given BLCVariableExpression; when 'Amount10USD'; then return '$10.00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_givenBLCVariableExpression_whenAmount10USD_thenReturn1000() {
    // Arrange, Act and Assert
    assertEquals("$10.00", bLCVariableExpression.getPrice("Amount10USD"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression}.
   *   <li>When {@code Amount10U}.
   *   <li>Then return {@code $10.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName(
      "Test getPrice(String); given BLCVariableExpression; when 'Amount10U'; then return '$10.00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_givenBLCVariableExpression_whenAmount10U_thenReturn1000() {
    // Arrange, Act and Assert
    assertEquals("$10.00", bLCVariableExpression.getPrice("Amount10U"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression}.
   *   <li>When {@code Amount10}.
   *   <li>Then return {@code $10.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName(
      "Test getPrice(String); given BLCVariableExpression; when 'Amount10'; then return '$10.00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_givenBLCVariableExpression_whenAmount10_thenReturn1000() {
    // Arrange, Act and Assert
    assertEquals("$10.00", bLCVariableExpression.getPrice("Amount10"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression}.
   *   <li>When {@code Amount42}.
   *   <li>Then return {@code $42.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName(
      "Test getPrice(String); given BLCVariableExpression; when 'Amount42'; then return '$42.00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_givenBLCVariableExpression_whenAmount42_thenReturn4200() {
    // Arrange, Act and Assert
    assertEquals("$42.00", bLCVariableExpression.getPrice("Amount42"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression}.
   *   <li>When {@code Amount1010}.
   *   <li>Then return {@code $1,010.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName(
      "Test getPrice(String); given BLCVariableExpression; when 'Amount1010'; then return '$1,010.00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_givenBLCVariableExpression_whenAmount1010_thenReturn101000() {
    // Arrange, Act and Assert
    assertEquals("$1,010.00", bLCVariableExpression.getPrice("Amount1010"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression}.
   *   <li>When {@code AmountAmount}.
   *   <li>Then return {@code $ 0.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName(
      "Test getPrice(String); given BLCVariableExpression; when 'AmountAmount'; then return '$ 0.00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_givenBLCVariableExpression_whenAmountAmount_thenReturn000() {
    // Arrange, Act and Assert
    assertEquals("$ 0.00", bLCVariableExpression.getPrice("AmountAmount"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression}.
   *   <li>When {@code AmountUSD}.
   *   <li>Then return {@code $ 0.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName(
      "Test getPrice(String); given BLCVariableExpression; when 'AmountUSD'; then return '$ 0.00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_givenBLCVariableExpression_whenAmountUSD_thenReturn000() {
    // Arrange, Act and Assert
    assertEquals("$ 0.00", bLCVariableExpression.getPrice("AmountUSD"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression}.
   *   <li>When {@code AmountU}.
   *   <li>Then return {@code $ 0.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName(
      "Test getPrice(String); given BLCVariableExpression; when 'AmountU'; then return '$ 0.00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_givenBLCVariableExpression_whenAmountU_thenReturn000() {
    // Arrange, Act and Assert
    assertEquals("$ 0.00", bLCVariableExpression.getPrice("AmountU"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression}.
   *   <li>When {@code Amount}.
   *   <li>Then return {@code $ 0.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName(
      "Test getPrice(String); given BLCVariableExpression; when 'Amount'; then return '$ 0.00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_givenBLCVariableExpression_whenAmount_thenReturn000() {
    // Arrange, Act and Assert
    assertEquals("$ 0.00", bLCVariableExpression.getPrice("Amount"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression}.
   *   <li>When {@code currency.default10USD}.
   *   <li>Then return {@code $0.10}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName(
      "Test getPrice(String); given BLCVariableExpression; when 'currency.default10USD'; then return '$0.10'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_givenBLCVariableExpression_whenCurrencyDefault10USD_thenReturn010() {
    // Arrange, Act and Assert
    assertEquals("$0.10", bLCVariableExpression.getPrice("currency.default10USD"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression}.
   *   <li>When {@code currency.default10U}.
   *   <li>Then return {@code $0.10}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName(
      "Test getPrice(String); given BLCVariableExpression; when 'currency.default10U'; then return '$0.10'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_givenBLCVariableExpression_whenCurrencyDefault10U_thenReturn010() {
    // Arrange, Act and Assert
    assertEquals("$0.10", bLCVariableExpression.getPrice("currency.default10U"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression}.
   *   <li>When {@code currency.default10}.
   *   <li>Then return {@code $0.10}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName(
      "Test getPrice(String); given BLCVariableExpression; when 'currency.default10'; then return '$0.10'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_givenBLCVariableExpression_whenCurrencyDefault10_thenReturn010() {
    // Arrange, Act and Assert
    assertEquals("$0.10", bLCVariableExpression.getPrice("currency.default10"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression}.
   *   <li>When {@code currency.default42USD}.
   *   <li>Then return {@code $0.42}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName(
      "Test getPrice(String); given BLCVariableExpression; when 'currency.default42USD'; then return '$0.42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_givenBLCVariableExpression_whenCurrencyDefault42USD_thenReturn042() {
    // Arrange, Act and Assert
    assertEquals("$0.42", bLCVariableExpression.getPrice("currency.default42USD"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression}.
   *   <li>When {@code currency.default42U}.
   *   <li>Then return {@code $0.42}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName(
      "Test getPrice(String); given BLCVariableExpression; when 'currency.default42U'; then return '$0.42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_givenBLCVariableExpression_whenCurrencyDefault42U_thenReturn042() {
    // Arrange, Act and Assert
    assertEquals("$0.42", bLCVariableExpression.getPrice("currency.default42U"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression}.
   *   <li>When {@code currency.default42}.
   *   <li>Then return {@code $0.42}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName(
      "Test getPrice(String); given BLCVariableExpression; when 'currency.default42'; then return '$0.42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_givenBLCVariableExpression_whenCurrencyDefault42_thenReturn042() {
    // Arrange, Act and Assert
    assertEquals("$0.42", bLCVariableExpression.getPrice("currency.default42"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression}.
   *   <li>When {@code currency.default1010}.
   *   <li>Then return {@code $0.10}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName(
      "Test getPrice(String); given BLCVariableExpression; when 'currency.default1010'; then return '$0.10'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_givenBLCVariableExpression_whenCurrencyDefault1010_thenReturn010() {
    // Arrange, Act and Assert
    assertEquals("$0.10", bLCVariableExpression.getPrice("currency.default1010"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression}.
   *   <li>When {@code currency.default1042}.
   *   <li>Then return {@code $0.10}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName(
      "Test getPrice(String); given BLCVariableExpression; when 'currency.default1042'; then return '$0.10'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_givenBLCVariableExpression_whenCurrencyDefault1042_thenReturn010() {
    // Arrange, Act and Assert
    assertEquals("$0.10", bLCVariableExpression.getPrice("currency.default1042"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression}.
   *   <li>When {@code currency.default4210}.
   *   <li>Then return {@code $0.42}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName(
      "Test getPrice(String); given BLCVariableExpression; when 'currency.default4210'; then return '$0.42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_givenBLCVariableExpression_whenCurrencyDefault4210_thenReturn042() {
    // Arrange, Act and Assert
    assertEquals("$0.42", bLCVariableExpression.getPrice("currency.default4210"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression}.
   *   <li>When {@code currency.default4242}.
   *   <li>Then return {@code $0.42}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName(
      "Test getPrice(String); given BLCVariableExpression; when 'currency.default4242'; then return '$0.42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_givenBLCVariableExpression_whenCurrencyDefault4242_thenReturn042() {
    // Arrange, Act and Assert
    assertEquals("$0.42", bLCVariableExpression.getPrice("currency.default4242"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression}.
   *   <li>When {@code currency.defaultU10}.
   *   <li>Then return {@code $0.10}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName(
      "Test getPrice(String); given BLCVariableExpression; when 'currency.defaultU10'; then return '$0.10'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_givenBLCVariableExpression_whenCurrencyDefaultU10_thenReturn010() {
    // Arrange, Act and Assert
    assertEquals("$0.10", bLCVariableExpression.getPrice("currency.defaultU10"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression}.
   *   <li>When {@code currency.defaultU42}.
   *   <li>Then return {@code $0.42}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName(
      "Test getPrice(String); given BLCVariableExpression; when 'currency.defaultU42'; then return '$0.42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_givenBLCVariableExpression_whenCurrencyDefaultU42_thenReturn042() {
    // Arrange, Act and Assert
    assertEquals("$0.42", bLCVariableExpression.getPrice("currency.defaultU42"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression}.
   *   <li>When {@code currency.defaultUSD10}.
   *   <li>Then return {@code $0.10}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName(
      "Test getPrice(String); given BLCVariableExpression; when 'currency.defaultUSD10'; then return '$0.10'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_givenBLCVariableExpression_whenCurrencyDefaultUSD10_thenReturn010() {
    // Arrange, Act and Assert
    assertEquals("$0.10", bLCVariableExpression.getPrice("currency.defaultUSD10"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression}.
   *   <li>When {@code currency.defaultUSD42}.
   *   <li>Then return {@code $0.42}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName(
      "Test getPrice(String); given BLCVariableExpression; when 'currency.defaultUSD42'; then return '$0.42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_givenBLCVariableExpression_whenCurrencyDefaultUSD42_thenReturn042() {
    // Arrange, Act and Assert
    assertEquals("$0.42", bLCVariableExpression.getPrice("currency.defaultUSD42"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression}.
   *   <li>When {@code [^\d.]+10Amount}.
   *   <li>Then return {@code $0.10}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName(
      "Test getPrice(String); given BLCVariableExpression; when '[^\\d.]+10Amount'; then return '$0.10'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_givenBLCVariableExpression_whenD10Amount_thenReturn010() {
    // Arrange, Act and Assert
    assertEquals("$0.10", bLCVariableExpression.getPrice("[^\\d.]+10Amount"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression}.
   *   <li>When {@code [^\d.]+10}.
   *   <li>Then return {@code $0.10}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName(
      "Test getPrice(String); given BLCVariableExpression; when '[^\\d.]+10'; then return '$0.10'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_givenBLCVariableExpression_whenD10_thenReturn010() {
    // Arrange, Act and Assert
    assertEquals("$0.10", bLCVariableExpression.getPrice("[^\\d.]+10"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression}.
   *   <li>When {@code [^\d.]+10U}.
   *   <li>Then return {@code $0.10}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName(
      "Test getPrice(String); given BLCVariableExpression; when '[^\\d.]+10U'; then return '$0.10'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_givenBLCVariableExpression_whenD10u_thenReturn010() {
    // Arrange, Act and Assert
    assertEquals("$0.10", bLCVariableExpression.getPrice("[^\\d.]+10U"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression}.
   *   <li>When {@code [^\d.]+10USD}.
   *   <li>Then return {@code $0.10}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName(
      "Test getPrice(String); given BLCVariableExpression; when '[^\\d.]+10USD'; then return '$0.10'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_givenBLCVariableExpression_whenD10usd_thenReturn010() {
    // Arrange, Act and Assert
    assertEquals("$0.10", bLCVariableExpression.getPrice("[^\\d.]+10USD"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression}.
   *   <li>When {@code [^\d.]+42Amount}.
   *   <li>Then return {@code $0.42}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName(
      "Test getPrice(String); given BLCVariableExpression; when '[^\\d.]+42Amount'; then return '$0.42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_givenBLCVariableExpression_whenD42Amount_thenReturn042() {
    // Arrange, Act and Assert
    assertEquals("$0.42", bLCVariableExpression.getPrice("[^\\d.]+42Amount"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression}.
   *   <li>When {@code [^\d.]+42}.
   *   <li>Then return {@code $0.42}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName(
      "Test getPrice(String); given BLCVariableExpression; when '[^\\d.]+42'; then return '$0.42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_givenBLCVariableExpression_whenD42_thenReturn042() {
    // Arrange, Act and Assert
    assertEquals("$0.42", bLCVariableExpression.getPrice("[^\\d.]+42"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression}.
   *   <li>When {@code [^\d.]+42U}.
   *   <li>Then return {@code $0.42}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName(
      "Test getPrice(String); given BLCVariableExpression; when '[^\\d.]+42U'; then return '$0.42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_givenBLCVariableExpression_whenD42u_thenReturn042() {
    // Arrange, Act and Assert
    assertEquals("$0.42", bLCVariableExpression.getPrice("[^\\d.]+42U"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression}.
   *   <li>When {@code [^\d.]+42USD}.
   *   <li>Then return {@code $0.42}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName(
      "Test getPrice(String); given BLCVariableExpression; when '[^\\d.]+42USD'; then return '$0.42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_givenBLCVariableExpression_whenD42usd_thenReturn042() {
    // Arrange, Act and Assert
    assertEquals("$0.42", bLCVariableExpression.getPrice("[^\\d.]+42USD"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression}.
   *   <li>When {@code [^\d.]+1010}.
   *   <li>Then return {@code $0.10}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName(
      "Test getPrice(String); given BLCVariableExpression; when '[^\\d.]+1010'; then return '$0.10'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_givenBLCVariableExpression_whenD1010_thenReturn010() {
    // Arrange, Act and Assert
    assertEquals("$0.10", bLCVariableExpression.getPrice("[^\\d.]+1010"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression}.
   *   <li>When {@code [^\d.]+1042}.
   *   <li>Then return {@code $0.10}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName(
      "Test getPrice(String); given BLCVariableExpression; when '[^\\d.]+1042'; then return '$0.10'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_givenBLCVariableExpression_whenD1042_thenReturn010() {
    // Arrange, Act and Assert
    assertEquals("$0.10", bLCVariableExpression.getPrice("[^\\d.]+1042"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression}.
   *   <li>When {@code [^\d.]+4210}.
   *   <li>Then return {@code $0.42}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName(
      "Test getPrice(String); given BLCVariableExpression; when '[^\\d.]+4210'; then return '$0.42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_givenBLCVariableExpression_whenD4210_thenReturn042() {
    // Arrange, Act and Assert
    assertEquals("$0.42", bLCVariableExpression.getPrice("[^\\d.]+4210"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression}.
   *   <li>When {@code [^\d.]+4242}.
   *   <li>Then return {@code $0.42}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName(
      "Test getPrice(String); given BLCVariableExpression; when '[^\\d.]+4242'; then return '$0.42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_givenBLCVariableExpression_whenD4242_thenReturn042() {
    // Arrange, Act and Assert
    assertEquals("$0.42", bLCVariableExpression.getPrice("[^\\d.]+4242"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression}.
   *   <li>When {@code [^\d.]+Amount10}.
   *   <li>Then return {@code $0.10}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName(
      "Test getPrice(String); given BLCVariableExpression; when '[^\\d.]+Amount10'; then return '$0.10'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_givenBLCVariableExpression_whenDAmount10_thenReturn010() {
    // Arrange, Act and Assert
    assertEquals("$0.10", bLCVariableExpression.getPrice("[^\\d.]+Amount10"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression}.
   *   <li>When {@code [^\d.]+Amount42}.
   *   <li>Then return {@code $0.42}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName(
      "Test getPrice(String); given BLCVariableExpression; when '[^\\d.]+Amount42'; then return '$0.42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_givenBLCVariableExpression_whenDAmount42_thenReturn042() {
    // Arrange, Act and Assert
    assertEquals("$0.42", bLCVariableExpression.getPrice("[^\\d.]+Amount42"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression}.
   *   <li>When {@code [^\d.]+U10}.
   *   <li>Then return {@code $0.10}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName(
      "Test getPrice(String); given BLCVariableExpression; when '[^\\d.]+U10'; then return '$0.10'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_givenBLCVariableExpression_whenDU10_thenReturn010() {
    // Arrange, Act and Assert
    assertEquals("$0.10", bLCVariableExpression.getPrice("[^\\d.]+U10"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression}.
   *   <li>When {@code [^\d.]+U42}.
   *   <li>Then return {@code $0.42}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName(
      "Test getPrice(String); given BLCVariableExpression; when '[^\\d.]+U42'; then return '$0.42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_givenBLCVariableExpression_whenDU42_thenReturn042() {
    // Arrange, Act and Assert
    assertEquals("$0.42", bLCVariableExpression.getPrice("[^\\d.]+U42"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression}.
   *   <li>When {@code [^\d.]+USD10}.
   *   <li>Then return {@code $0.10}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName(
      "Test getPrice(String); given BLCVariableExpression; when '[^\\d.]+USD10'; then return '$0.10'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_givenBLCVariableExpression_whenDUsd10_thenReturn010() {
    // Arrange, Act and Assert
    assertEquals("$0.10", bLCVariableExpression.getPrice("[^\\d.]+USD10"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression}.
   *   <li>When {@code [^\d.]+USD42}.
   *   <li>Then return {@code $0.42}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName(
      "Test getPrice(String); given BLCVariableExpression; when '[^\\d.]+USD42'; then return '$0.42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_givenBLCVariableExpression_whenDUsd42_thenReturn042() {
    // Arrange, Act and Assert
    assertEquals("$0.42", bLCVariableExpression.getPrice("[^\\d.]+USD42"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression}.
   *   <li>When {@code U10Amount}.
   *   <li>Then return {@code $10.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName(
      "Test getPrice(String); given BLCVariableExpression; when 'U10Amount'; then return '$10.00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_givenBLCVariableExpression_whenU10Amount_thenReturn1000() {
    // Arrange, Act and Assert
    assertEquals("$10.00", bLCVariableExpression.getPrice("U10Amount"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression}.
   *   <li>When {@code U10[^\d.]+}.
   *   <li>Then return {@code $10.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName(
      "Test getPrice(String); given BLCVariableExpression; when 'U10[^\\d.]+'; then return '$10.00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_givenBLCVariableExpression_whenU10D_thenReturn1000() {
    // Arrange, Act and Assert
    assertEquals("$10.00", bLCVariableExpression.getPrice("U10[^\\d.]+"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression}.
   *   <li>When {@code U10}.
   *   <li>Then return {@code $10.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName(
      "Test getPrice(String); given BLCVariableExpression; when 'U10'; then return '$10.00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_givenBLCVariableExpression_whenU10_thenReturn1000() {
    // Arrange, Act and Assert
    assertEquals("$10.00", bLCVariableExpression.getPrice("U10"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression}.
   *   <li>When {@code U10currency.default}.
   *   <li>Then return {@code $10.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName(
      "Test getPrice(String); given BLCVariableExpression; when 'U10currency.default'; then return '$10.00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_givenBLCVariableExpression_whenU10currencyDefault_thenReturn1000() {
    // Arrange, Act and Assert
    assertEquals("$10.00", bLCVariableExpression.getPrice("U10currency.default"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression}.
   *   <li>When {@code U10U}.
   *   <li>Then return {@code $10.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName(
      "Test getPrice(String); given BLCVariableExpression; when 'U10U'; then return '$10.00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_givenBLCVariableExpression_whenU10u_thenReturn1000() {
    // Arrange, Act and Assert
    assertEquals("$10.00", bLCVariableExpression.getPrice("U10U"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression}.
   *   <li>When {@code U10USD}.
   *   <li>Then return {@code $10.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName(
      "Test getPrice(String); given BLCVariableExpression; when 'U10USD'; then return '$10.00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_givenBLCVariableExpression_whenU10usd_thenReturn1000() {
    // Arrange, Act and Assert
    assertEquals("$10.00", bLCVariableExpression.getPrice("U10USD"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression}.
   *   <li>When {@code U42Amount}.
   *   <li>Then return {@code $42.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName(
      "Test getPrice(String); given BLCVariableExpression; when 'U42Amount'; then return '$42.00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_givenBLCVariableExpression_whenU42Amount_thenReturn4200() {
    // Arrange, Act and Assert
    assertEquals("$42.00", bLCVariableExpression.getPrice("U42Amount"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression}.
   *   <li>When {@code U42[^\d.]+}.
   *   <li>Then return {@code $42.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName(
      "Test getPrice(String); given BLCVariableExpression; when 'U42[^\\d.]+'; then return '$42.00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_givenBLCVariableExpression_whenU42D_thenReturn4200() {
    // Arrange, Act and Assert
    assertEquals("$42.00", bLCVariableExpression.getPrice("U42[^\\d.]+"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression}.
   *   <li>When {@code U42}.
   *   <li>Then return {@code $42.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName(
      "Test getPrice(String); given BLCVariableExpression; when 'U42'; then return '$42.00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_givenBLCVariableExpression_whenU42_thenReturn4200() {
    // Arrange, Act and Assert
    assertEquals("$42.00", bLCVariableExpression.getPrice("U42"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression}.
   *   <li>When {@code U42currency.default}.
   *   <li>Then return {@code $42.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName(
      "Test getPrice(String); given BLCVariableExpression; when 'U42currency.default'; then return '$42.00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_givenBLCVariableExpression_whenU42currencyDefault_thenReturn4200() {
    // Arrange, Act and Assert
    assertEquals("$42.00", bLCVariableExpression.getPrice("U42currency.default"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression}.
   *   <li>When {@code U42U}.
   *   <li>Then return {@code $42.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName(
      "Test getPrice(String); given BLCVariableExpression; when 'U42U'; then return '$42.00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_givenBLCVariableExpression_whenU42u_thenReturn4200() {
    // Arrange, Act and Assert
    assertEquals("$42.00", bLCVariableExpression.getPrice("U42U"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression}.
   *   <li>When {@code U42USD}.
   *   <li>Then return {@code $42.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName(
      "Test getPrice(String); given BLCVariableExpression; when 'U42USD'; then return '$42.00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_givenBLCVariableExpression_whenU42usd_thenReturn4200() {
    // Arrange, Act and Assert
    assertEquals("$42.00", bLCVariableExpression.getPrice("U42USD"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression}.
   *   <li>When {@code U1010}.
   *   <li>Then return {@code $1,010.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName(
      "Test getPrice(String); given BLCVariableExpression; when 'U1010'; then return '$1,010.00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_givenBLCVariableExpression_whenU1010_thenReturn101000() {
    // Arrange, Act and Assert
    assertEquals("$1,010.00", bLCVariableExpression.getPrice("U1010"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression}.
   *   <li>When {@code U1042}.
   *   <li>Then return {@code $1,042.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName(
      "Test getPrice(String); given BLCVariableExpression; when 'U1042'; then return '$1,042.00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_givenBLCVariableExpression_whenU1042_thenReturn104200() {
    // Arrange, Act and Assert
    assertEquals("$1,042.00", bLCVariableExpression.getPrice("U1042"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression}.
   *   <li>When {@code U4210}.
   *   <li>Then return {@code $4,210.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName(
      "Test getPrice(String); given BLCVariableExpression; when 'U4210'; then return '$4,210.00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_givenBLCVariableExpression_whenU4210_thenReturn421000() {
    // Arrange, Act and Assert
    assertEquals("$4,210.00", bLCVariableExpression.getPrice("U4210"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression}.
   *   <li>When {@code U4242}.
   *   <li>Then return {@code $4,242.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName(
      "Test getPrice(String); given BLCVariableExpression; when 'U4242'; then return '$4,242.00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_givenBLCVariableExpression_whenU4242_thenReturn424200() {
    // Arrange, Act and Assert
    assertEquals("$4,242.00", bLCVariableExpression.getPrice("U4242"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression}.
   *   <li>When {@code UAmount10}.
   *   <li>Then return {@code $10.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName(
      "Test getPrice(String); given BLCVariableExpression; when 'UAmount10'; then return '$10.00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_givenBLCVariableExpression_whenUAmount10_thenReturn1000() {
    // Arrange, Act and Assert
    assertEquals("$10.00", bLCVariableExpression.getPrice("UAmount10"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression}.
   *   <li>When {@code UAmount42}.
   *   <li>Then return {@code $42.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName(
      "Test getPrice(String); given BLCVariableExpression; when 'UAmount42'; then return '$42.00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_givenBLCVariableExpression_whenUAmount42_thenReturn4200() {
    // Arrange, Act and Assert
    assertEquals("$42.00", bLCVariableExpression.getPrice("UAmount42"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression}.
   *   <li>When {@code UAmountAmount}.
   *   <li>Then return {@code $ 0.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName(
      "Test getPrice(String); given BLCVariableExpression; when 'UAmountAmount'; then return '$ 0.00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_givenBLCVariableExpression_whenUAmountAmount_thenReturn000() {
    // Arrange, Act and Assert
    assertEquals("$ 0.00", bLCVariableExpression.getPrice("UAmountAmount"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression}.
   *   <li>When {@code UAmountUSD}.
   *   <li>Then return {@code $ 0.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName(
      "Test getPrice(String); given BLCVariableExpression; when 'UAmountUSD'; then return '$ 0.00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_givenBLCVariableExpression_whenUAmountUSD_thenReturn000() {
    // Arrange, Act and Assert
    assertEquals("$ 0.00", bLCVariableExpression.getPrice("UAmountUSD"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression}.
   *   <li>When {@code UAmountU}.
   *   <li>Then return {@code $ 0.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName(
      "Test getPrice(String); given BLCVariableExpression; when 'UAmountU'; then return '$ 0.00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_givenBLCVariableExpression_whenUAmountU_thenReturn000() {
    // Arrange, Act and Assert
    assertEquals("$ 0.00", bLCVariableExpression.getPrice("UAmountU"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression}.
   *   <li>When {@code UAmount}.
   *   <li>Then return {@code $ 0.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName(
      "Test getPrice(String); given BLCVariableExpression; when 'UAmount'; then return '$ 0.00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_givenBLCVariableExpression_whenUAmount_thenReturn000() {
    // Arrange, Act and Assert
    assertEquals("$ 0.00", bLCVariableExpression.getPrice("UAmount"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression}.
   *   <li>When {@code U[^\d.]+10}.
   *   <li>Then return {@code $0.10}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName(
      "Test getPrice(String); given BLCVariableExpression; when 'U[^\\d.]+10'; then return '$0.10'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_givenBLCVariableExpression_whenUD10_thenReturn010() {
    // Arrange, Act and Assert
    assertEquals("$0.10", bLCVariableExpression.getPrice("U[^\\d.]+10"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression}.
   *   <li>When {@code U[^\d.]+42}.
   *   <li>Then return {@code $0.42}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName(
      "Test getPrice(String); given BLCVariableExpression; when 'U[^\\d.]+42'; then return '$0.42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_givenBLCVariableExpression_whenUD42_thenReturn042() {
    // Arrange, Act and Assert
    assertEquals("$0.42", bLCVariableExpression.getPrice("U[^\\d.]+42"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression}.
   *   <li>When {@code USD10Amount}.
   *   <li>Then return {@code $10.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName(
      "Test getPrice(String); given BLCVariableExpression; when 'USD10Amount'; then return '$10.00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_givenBLCVariableExpression_whenUSD10Amount_thenReturn1000() {
    // Arrange, Act and Assert
    assertEquals("$10.00", bLCVariableExpression.getPrice("USD10Amount"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression}.
   *   <li>When {@code USD10currency.default}.
   *   <li>Then return {@code $10.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName(
      "Test getPrice(String); given BLCVariableExpression; when 'USD10currency.default'; then return '$10.00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_givenBLCVariableExpression_whenUSD10currencyDefault_thenReturn1000() {
    // Arrange, Act and Assert
    assertEquals("$10.00", bLCVariableExpression.getPrice("USD10currency.default"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression}.
   *   <li>When {@code USD42Amount}.
   *   <li>Then return {@code $42.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName(
      "Test getPrice(String); given BLCVariableExpression; when 'USD42Amount'; then return '$42.00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_givenBLCVariableExpression_whenUSD42Amount_thenReturn4200() {
    // Arrange, Act and Assert
    assertEquals("$42.00", bLCVariableExpression.getPrice("USD42Amount"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression}.
   *   <li>When {@code USD42currency.default}.
   *   <li>Then return {@code $42.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName(
      "Test getPrice(String); given BLCVariableExpression; when 'USD42currency.default'; then return '$42.00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_givenBLCVariableExpression_whenUSD42currencyDefault_thenReturn4200() {
    // Arrange, Act and Assert
    assertEquals("$42.00", bLCVariableExpression.getPrice("USD42currency.default"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression}.
   *   <li>When {@code USDAmount10}.
   *   <li>Then return {@code $10.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName(
      "Test getPrice(String); given BLCVariableExpression; when 'USDAmount10'; then return '$10.00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_givenBLCVariableExpression_whenUSDAmount10_thenReturn1000() {
    // Arrange, Act and Assert
    assertEquals("$10.00", bLCVariableExpression.getPrice("USDAmount10"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression}.
   *   <li>When {@code USDAmount42}.
   *   <li>Then return {@code $42.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName(
      "Test getPrice(String); given BLCVariableExpression; when 'USDAmount42'; then return '$42.00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_givenBLCVariableExpression_whenUSDAmount42_thenReturn4200() {
    // Arrange, Act and Assert
    assertEquals("$42.00", bLCVariableExpression.getPrice("USDAmount42"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression}.
   *   <li>When {@code USDAmountAmount}.
   *   <li>Then return {@code $ 0.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName(
      "Test getPrice(String); given BLCVariableExpression; when 'USDAmountAmount'; then return '$ 0.00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_givenBLCVariableExpression_whenUSDAmountAmount_thenReturn000() {
    // Arrange, Act and Assert
    assertEquals("$ 0.00", bLCVariableExpression.getPrice("USDAmountAmount"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression}.
   *   <li>When {@code USDAmountUSD}.
   *   <li>Then return {@code $ 0.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName(
      "Test getPrice(String); given BLCVariableExpression; when 'USDAmountUSD'; then return '$ 0.00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_givenBLCVariableExpression_whenUSDAmountUSD_thenReturn000() {
    // Arrange, Act and Assert
    assertEquals("$ 0.00", bLCVariableExpression.getPrice("USDAmountUSD"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression}.
   *   <li>When {@code USDAmountU}.
   *   <li>Then return {@code $ 0.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName(
      "Test getPrice(String); given BLCVariableExpression; when 'USDAmountU'; then return '$ 0.00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_givenBLCVariableExpression_whenUSDAmountU_thenReturn000() {
    // Arrange, Act and Assert
    assertEquals("$ 0.00", bLCVariableExpression.getPrice("USDAmountU"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression}.
   *   <li>When {@code USDAmount}.
   *   <li>Then return {@code $ 0.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName(
      "Test getPrice(String); given BLCVariableExpression; when 'USDAmount'; then return '$ 0.00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_givenBLCVariableExpression_whenUSDAmount_thenReturn000() {
    // Arrange, Act and Assert
    assertEquals("$ 0.00", bLCVariableExpression.getPrice("USDAmount"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression}.
   *   <li>When {@code USDUAmount}.
   *   <li>Then return {@code $ 0.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName(
      "Test getPrice(String); given BLCVariableExpression; when 'USDUAmount'; then return '$ 0.00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_givenBLCVariableExpression_whenUSDUAmount_thenReturn000() {
    // Arrange, Act and Assert
    assertEquals("$ 0.00", bLCVariableExpression.getPrice("USDUAmount"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression}.
   *   <li>When {@code USDUSDAmount}.
   *   <li>Then return {@code $ 0.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName(
      "Test getPrice(String); given BLCVariableExpression; when 'USDUSDAmount'; then return '$ 0.00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_givenBLCVariableExpression_whenUSDUSDAmount_thenReturn000() {
    // Arrange, Act and Assert
    assertEquals("$ 0.00", bLCVariableExpression.getPrice("USDUSDAmount"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression}.
   *   <li>When {@code USDcurrency.default10}.
   *   <li>Then return {@code $0.10}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName(
      "Test getPrice(String); given BLCVariableExpression; when 'USDcurrency.default10'; then return '$0.10'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_givenBLCVariableExpression_whenUSDcurrencyDefault10_thenReturn010() {
    // Arrange, Act and Assert
    assertEquals("$0.10", bLCVariableExpression.getPrice("USDcurrency.default10"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression}.
   *   <li>When {@code USDcurrency.default42}.
   *   <li>Then return {@code $0.42}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName(
      "Test getPrice(String); given BLCVariableExpression; when 'USDcurrency.default42'; then return '$0.42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_givenBLCVariableExpression_whenUSDcurrencyDefault42_thenReturn042() {
    // Arrange, Act and Assert
    assertEquals("$0.42", bLCVariableExpression.getPrice("USDcurrency.default42"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression}.
   *   <li>When {@code UUAmount}.
   *   <li>Then return {@code $ 0.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName(
      "Test getPrice(String); given BLCVariableExpression; when 'UUAmount'; then return '$ 0.00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_givenBLCVariableExpression_whenUUAmount_thenReturn000() {
    // Arrange, Act and Assert
    assertEquals("$ 0.00", bLCVariableExpression.getPrice("UUAmount"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression}.
   *   <li>When {@code UUSDAmount}.
   *   <li>Then return {@code $ 0.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName(
      "Test getPrice(String); given BLCVariableExpression; when 'UUSDAmount'; then return '$ 0.00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_givenBLCVariableExpression_whenUUSDAmount_thenReturn000() {
    // Arrange, Act and Assert
    assertEquals("$ 0.00", bLCVariableExpression.getPrice("UUSDAmount"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression}.
   *   <li>When {@code U}.
   *   <li>Then return {@code $ 0.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName("Test getPrice(String); given BLCVariableExpression; when 'U'; then return '$ 0.00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_givenBLCVariableExpression_whenU_thenReturn000() {
    // Arrange, Act and Assert
    assertEquals("$ 0.00", bLCVariableExpression.getPrice("U"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression}.
   *   <li>When {@code Ucurrency.default10}.
   *   <li>Then return {@code $0.10}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName(
      "Test getPrice(String); given BLCVariableExpression; when 'Ucurrency.default10'; then return '$0.10'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_givenBLCVariableExpression_whenUcurrencyDefault10_thenReturn010() {
    // Arrange, Act and Assert
    assertEquals("$0.10", bLCVariableExpression.getPrice("Ucurrency.default10"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression}.
   *   <li>When {@code Ucurrency.default42}.
   *   <li>Then return {@code $0.42}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName(
      "Test getPrice(String); given BLCVariableExpression; when 'Ucurrency.default42'; then return '$0.42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_givenBLCVariableExpression_whenUcurrencyDefault42_thenReturn042() {
    // Arrange, Act and Assert
    assertEquals("$0.42", bLCVariableExpression.getPrice("Ucurrency.default42"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression}.
   *   <li>When {@code USD10[^\d.]+}.
   *   <li>Then return {@code $10.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName(
      "Test getPrice(String); given BLCVariableExpression; when 'USD10[^\\d.]+'; then return '$10.00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_givenBLCVariableExpression_whenUsd10D_thenReturn1000() {
    // Arrange, Act and Assert
    assertEquals("$10.00", bLCVariableExpression.getPrice("USD10[^\\d.]+"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression}.
   *   <li>When {@code USD10}.
   *   <li>Then return {@code $10.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName(
      "Test getPrice(String); given BLCVariableExpression; when 'USD10'; then return '$10.00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_givenBLCVariableExpression_whenUsd10_thenReturn1000() {
    // Arrange, Act and Assert
    assertEquals("$10.00", bLCVariableExpression.getPrice("USD10"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression}.
   *   <li>When {@code USD10U}.
   *   <li>Then return {@code $10.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName(
      "Test getPrice(String); given BLCVariableExpression; when 'USD10U'; then return '$10.00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_givenBLCVariableExpression_whenUsd10u_thenReturn1000() {
    // Arrange, Act and Assert
    assertEquals("$10.00", bLCVariableExpression.getPrice("USD10U"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression}.
   *   <li>When {@code USD10USD}.
   *   <li>Then return {@code $10.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName(
      "Test getPrice(String); given BLCVariableExpression; when 'USD10USD'; then return '$10.00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_givenBLCVariableExpression_whenUsd10usd_thenReturn1000() {
    // Arrange, Act and Assert
    assertEquals("$10.00", bLCVariableExpression.getPrice("USD10USD"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression}.
   *   <li>When {@code USD42[^\d.]+}.
   *   <li>Then return {@code $42.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName(
      "Test getPrice(String); given BLCVariableExpression; when 'USD42[^\\d.]+'; then return '$42.00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_givenBLCVariableExpression_whenUsd42D_thenReturn4200() {
    // Arrange, Act and Assert
    assertEquals("$42.00", bLCVariableExpression.getPrice("USD42[^\\d.]+"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression}.
   *   <li>When {@code USD42}.
   *   <li>Then return {@code $42.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName(
      "Test getPrice(String); given BLCVariableExpression; when 'USD42'; then return '$42.00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_givenBLCVariableExpression_whenUsd42_thenReturn4200() {
    // Arrange, Act and Assert
    assertEquals("$42.00", bLCVariableExpression.getPrice("USD42"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression}.
   *   <li>When {@code USD42U}.
   *   <li>Then return {@code $42.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName(
      "Test getPrice(String); given BLCVariableExpression; when 'USD42U'; then return '$42.00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_givenBLCVariableExpression_whenUsd42u_thenReturn4200() {
    // Arrange, Act and Assert
    assertEquals("$42.00", bLCVariableExpression.getPrice("USD42U"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression}.
   *   <li>When {@code USD42USD}.
   *   <li>Then return {@code $42.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName(
      "Test getPrice(String); given BLCVariableExpression; when 'USD42USD'; then return '$42.00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_givenBLCVariableExpression_whenUsd42usd_thenReturn4200() {
    // Arrange, Act and Assert
    assertEquals("$42.00", bLCVariableExpression.getPrice("USD42USD"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression}.
   *   <li>When {@code USD1010}.
   *   <li>Then return {@code $1,010.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName(
      "Test getPrice(String); given BLCVariableExpression; when 'USD1010'; then return '$1,010.00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_givenBLCVariableExpression_whenUsd1010_thenReturn101000() {
    // Arrange, Act and Assert
    assertEquals("$1,010.00", bLCVariableExpression.getPrice("USD1010"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression}.
   *   <li>When {@code USD1042}.
   *   <li>Then return {@code $1,042.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName(
      "Test getPrice(String); given BLCVariableExpression; when 'USD1042'; then return '$1,042.00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_givenBLCVariableExpression_whenUsd1042_thenReturn104200() {
    // Arrange, Act and Assert
    assertEquals("$1,042.00", bLCVariableExpression.getPrice("USD1042"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression}.
   *   <li>When {@code USD4210}.
   *   <li>Then return {@code $4,210.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName(
      "Test getPrice(String); given BLCVariableExpression; when 'USD4210'; then return '$4,210.00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_givenBLCVariableExpression_whenUsd4210_thenReturn421000() {
    // Arrange, Act and Assert
    assertEquals("$4,210.00", bLCVariableExpression.getPrice("USD4210"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression}.
   *   <li>When {@code USD4242}.
   *   <li>Then return {@code $4,242.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName(
      "Test getPrice(String); given BLCVariableExpression; when 'USD4242'; then return '$4,242.00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_givenBLCVariableExpression_whenUsd4242_thenReturn424200() {
    // Arrange, Act and Assert
    assertEquals("$4,242.00", bLCVariableExpression.getPrice("USD4242"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression}.
   *   <li>When {@code USD[^\d.]+10}.
   *   <li>Then return {@code $0.10}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName(
      "Test getPrice(String); given BLCVariableExpression; when 'USD[^\\d.]+10'; then return '$0.10'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_givenBLCVariableExpression_whenUsdD10_thenReturn010() {
    // Arrange, Act and Assert
    assertEquals("$0.10", bLCVariableExpression.getPrice("USD[^\\d.]+10"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression}.
   *   <li>When {@code USD[^\d.]+42}.
   *   <li>Then return {@code $0.42}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName(
      "Test getPrice(String); given BLCVariableExpression; when 'USD[^\\d.]+42'; then return '$0.42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_givenBLCVariableExpression_whenUsdD42_thenReturn042() {
    // Arrange, Act and Assert
    assertEquals("$0.42", bLCVariableExpression.getPrice("USD[^\\d.]+42"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression}.
   *   <li>When {@code USD}.
   *   <li>Then return {@code $ 0.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName(
      "Test getPrice(String); given BLCVariableExpression; when 'USD'; then return '$ 0.00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_givenBLCVariableExpression_whenUsd_thenReturn000() {
    // Arrange, Act and Assert
    assertEquals("$ 0.00", bLCVariableExpression.getPrice("USD"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression}.
   *   <li>When {@code USDU10}.
   *   <li>Then return {@code $10.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName(
      "Test getPrice(String); given BLCVariableExpression; when 'USDU10'; then return '$10.00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_givenBLCVariableExpression_whenUsdu10_thenReturn1000() {
    // Arrange, Act and Assert
    assertEquals("$10.00", bLCVariableExpression.getPrice("USDU10"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression}.
   *   <li>When {@code USDU42}.
   *   <li>Then return {@code $42.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName(
      "Test getPrice(String); given BLCVariableExpression; when 'USDU42'; then return '$42.00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_givenBLCVariableExpression_whenUsdu42_thenReturn4200() {
    // Arrange, Act and Assert
    assertEquals("$42.00", bLCVariableExpression.getPrice("USDU42"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression}.
   *   <li>When {@code USDU}.
   *   <li>Then return {@code $ 0.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName(
      "Test getPrice(String); given BLCVariableExpression; when 'USDU'; then return '$ 0.00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_givenBLCVariableExpression_whenUsdu_thenReturn000() {
    // Arrange, Act and Assert
    assertEquals("$ 0.00", bLCVariableExpression.getPrice("USDU"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression}.
   *   <li>When {@code USDUSD10}.
   *   <li>Then return {@code $10.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName(
      "Test getPrice(String); given BLCVariableExpression; when 'USDUSD10'; then return '$10.00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_givenBLCVariableExpression_whenUsdusd10_thenReturn1000() {
    // Arrange, Act and Assert
    assertEquals("$10.00", bLCVariableExpression.getPrice("USDUSD10"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression}.
   *   <li>When {@code USDUSD42}.
   *   <li>Then return {@code $42.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName(
      "Test getPrice(String); given BLCVariableExpression; when 'USDUSD42'; then return '$42.00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_givenBLCVariableExpression_whenUsdusd42_thenReturn4200() {
    // Arrange, Act and Assert
    assertEquals("$42.00", bLCVariableExpression.getPrice("USDUSD42"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression}.
   *   <li>When {@code USDUSD}.
   *   <li>Then return {@code $ 0.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName(
      "Test getPrice(String); given BLCVariableExpression; when 'USDUSD'; then return '$ 0.00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_givenBLCVariableExpression_whenUsdusd_thenReturn000() {
    // Arrange, Act and Assert
    assertEquals("$ 0.00", bLCVariableExpression.getPrice("USDUSD"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression}.
   *   <li>When {@code USDUSDU}.
   *   <li>Then return {@code $ 0.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName(
      "Test getPrice(String); given BLCVariableExpression; when 'USDUSDU'; then return '$ 0.00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_givenBLCVariableExpression_whenUsdusdu_thenReturn000() {
    // Arrange, Act and Assert
    assertEquals("$ 0.00", bLCVariableExpression.getPrice("USDUSDU"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression}.
   *   <li>When {@code USDUSDUSD}.
   *   <li>Then return {@code $ 0.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName(
      "Test getPrice(String); given BLCVariableExpression; when 'USDUSDUSD'; then return '$ 0.00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_givenBLCVariableExpression_whenUsdusdusd_thenReturn000() {
    // Arrange, Act and Assert
    assertEquals("$ 0.00", bLCVariableExpression.getPrice("USDUSDUSD"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression}.
   *   <li>When {@code USDUU}.
   *   <li>Then return {@code $ 0.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName(
      "Test getPrice(String); given BLCVariableExpression; when 'USDUU'; then return '$ 0.00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_givenBLCVariableExpression_whenUsduu_thenReturn000() {
    // Arrange, Act and Assert
    assertEquals("$ 0.00", bLCVariableExpression.getPrice("USDUU"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression}.
   *   <li>When {@code USDUUSD}.
   *   <li>Then return {@code $ 0.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName(
      "Test getPrice(String); given BLCVariableExpression; when 'USDUUSD'; then return '$ 0.00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_givenBLCVariableExpression_whenUsduusd_thenReturn000() {
    // Arrange, Act and Assert
    assertEquals("$ 0.00", bLCVariableExpression.getPrice("USDUUSD"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression}.
   *   <li>When {@code UU10}.
   *   <li>Then return {@code $10.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName(
      "Test getPrice(String); given BLCVariableExpression; when 'UU10'; then return '$10.00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_givenBLCVariableExpression_whenUu10_thenReturn1000() {
    // Arrange, Act and Assert
    assertEquals("$10.00", bLCVariableExpression.getPrice("UU10"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression}.
   *   <li>When {@code UU42}.
   *   <li>Then return {@code $42.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName(
      "Test getPrice(String); given BLCVariableExpression; when 'UU42'; then return '$42.00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_givenBLCVariableExpression_whenUu42_thenReturn4200() {
    // Arrange, Act and Assert
    assertEquals("$42.00", bLCVariableExpression.getPrice("UU42"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression}.
   *   <li>When {@code UU}.
   *   <li>Then return {@code $ 0.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName(
      "Test getPrice(String); given BLCVariableExpression; when 'UU'; then return '$ 0.00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_givenBLCVariableExpression_whenUu_thenReturn000() {
    // Arrange, Act and Assert
    assertEquals("$ 0.00", bLCVariableExpression.getPrice("UU"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression}.
   *   <li>When {@code UUSD10}.
   *   <li>Then return {@code $10.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName(
      "Test getPrice(String); given BLCVariableExpression; when 'UUSD10'; then return '$10.00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_givenBLCVariableExpression_whenUusd10_thenReturn1000() {
    // Arrange, Act and Assert
    assertEquals("$10.00", bLCVariableExpression.getPrice("UUSD10"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression}.
   *   <li>When {@code UUSD42}.
   *   <li>Then return {@code $42.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName(
      "Test getPrice(String); given BLCVariableExpression; when 'UUSD42'; then return '$42.00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_givenBLCVariableExpression_whenUusd42_thenReturn4200() {
    // Arrange, Act and Assert
    assertEquals("$42.00", bLCVariableExpression.getPrice("UUSD42"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression}.
   *   <li>When {@code UUSD}.
   *   <li>Then return {@code $ 0.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName(
      "Test getPrice(String); given BLCVariableExpression; when 'UUSD'; then return '$ 0.00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_givenBLCVariableExpression_whenUusd_thenReturn000() {
    // Arrange, Act and Assert
    assertEquals("$ 0.00", bLCVariableExpression.getPrice("UUSD"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression}.
   *   <li>When {@code UUSDU}.
   *   <li>Then return {@code $ 0.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName(
      "Test getPrice(String); given BLCVariableExpression; when 'UUSDU'; then return '$ 0.00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_givenBLCVariableExpression_whenUusdu_thenReturn000() {
    // Arrange, Act and Assert
    assertEquals("$ 0.00", bLCVariableExpression.getPrice("UUSDU"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression}.
   *   <li>When {@code UUSDUSD}.
   *   <li>Then return {@code $ 0.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName(
      "Test getPrice(String); given BLCVariableExpression; when 'UUSDUSD'; then return '$ 0.00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_givenBLCVariableExpression_whenUusdusd_thenReturn000() {
    // Arrange, Act and Assert
    assertEquals("$ 0.00", bLCVariableExpression.getPrice("UUSDUSD"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression}.
   *   <li>When {@code UUU}.
   *   <li>Then return {@code $ 0.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName(
      "Test getPrice(String); given BLCVariableExpression; when 'UUU'; then return '$ 0.00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_givenBLCVariableExpression_whenUuu_thenReturn000() {
    // Arrange, Act and Assert
    assertEquals("$ 0.00", bLCVariableExpression.getPrice("UUU"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression}.
   *   <li>When {@code UUUSD}.
   *   <li>Then return {@code $ 0.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName(
      "Test getPrice(String); given BLCVariableExpression; when 'UUUSD'; then return '$ 0.00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_givenBLCVariableExpression_whenUuusd_thenReturn000() {
    // Arrange, Act and Assert
    assertEquals("$ 0.00", bLCVariableExpression.getPrice("UUUSD"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link PromotionMessageVariableExpression} (default constructor).
   *   <li>When {@code 42AmountAmount}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName(
      "Test getPrice(String); given PromotionMessageVariableExpression (default constructor); when '42AmountAmount'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_givenPromotionMessageVariableExpression_when42AmountAmount() {
    // Arrange, Act and Assert
    assertEquals("$42.00", new PromotionMessageVariableExpression().getPrice("42AmountAmount"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link PromotionMessageVariableExpression} (default constructor).
   *   <li>When {@code Amount42Amount}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName(
      "Test getPrice(String); given PromotionMessageVariableExpression (default constructor); when 'Amount42Amount'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_givenPromotionMessageVariableExpression_whenAmount42Amount() {
    // Arrange, Act and Assert
    assertEquals("$42.00", new PromotionMessageVariableExpression().getPrice("Amount42Amount"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link PromotionMessageVariableExpression} (default constructor).
   *   <li>When {@code AmountAmount10}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName(
      "Test getPrice(String); given PromotionMessageVariableExpression (default constructor); when 'AmountAmount10'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_givenPromotionMessageVariableExpression_whenAmountAmount10() {
    // Arrange, Act and Assert
    assertEquals("$10.00", new PromotionMessageVariableExpression().getPrice("AmountAmount10"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link PromotionMessageVariableExpression} (default constructor).
   *   <li>When {@code AmountAmount42}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName(
      "Test getPrice(String); given PromotionMessageVariableExpression (default constructor); when 'AmountAmount42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_givenPromotionMessageVariableExpression_whenAmountAmount42() {
    // Arrange, Act and Assert
    assertEquals("$42.00", new PromotionMessageVariableExpression().getPrice("AmountAmount42"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link PromotionMessageVariableExpression} (default constructor).
   *   <li>When {@code AmountAmountAmount}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName(
      "Test getPrice(String); given PromotionMessageVariableExpression (default constructor); when 'AmountAmountAmount'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_givenPromotionMessageVariableExpression_whenAmountAmountAmount() {
    // Arrange, Act and Assert
    assertEquals("$ 0.00", new PromotionMessageVariableExpression().getPrice("AmountAmountAmount"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>When {@code 10Amountcurrency.default}.
   *   <li>Then return {@code $10.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName("Test getPrice(String); when '10Amountcurrency.default'; then return '$10.00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_when10AmountcurrencyDefault_thenReturn1000() {
    // Arrange, Act and Assert
    assertEquals("$10.00", bLCVariableExpression.getPrice("10Amountcurrency.default"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>When {@code 10currency.defaultAmount}.
   *   <li>Then return {@code $10.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName("Test getPrice(String); when '10currency.defaultAmount'; then return '$10.00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_when10currencyDefaultAmount_thenReturn1000() {
    // Arrange, Act and Assert
    assertEquals("$10.00", bLCVariableExpression.getPrice("10currency.defaultAmount"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>When {@code 42Amount10}.
   *   <li>Then return {@code $4,210.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName("Test getPrice(String); when '42Amount10'; then return '$4,210.00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_when42Amount10_thenReturn421000() {
    // Arrange, Act and Assert
    assertEquals("$4,210.00", new PromotionMessageVariableExpression().getPrice("42Amount10"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>When {@code 42Amount42}.
   *   <li>Then return {@code $4,242.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName("Test getPrice(String); when '42Amount42'; then return '$4,242.00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_when42Amount42_thenReturn424200() {
    // Arrange, Act and Assert
    assertEquals("$4,242.00", new PromotionMessageVariableExpression().getPrice("42Amount42"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>When {@code 4210Amount}.
   *   <li>Then return {@code $4,210.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName("Test getPrice(String); when '4210Amount'; then return '$4,210.00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_when4210Amount_thenReturn421000() {
    // Arrange, Act and Assert
    assertEquals("$4,210.00", new PromotionMessageVariableExpression().getPrice("4210Amount"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>When {@code Amount10currency.default}.
   *   <li>Then return {@code $10.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName("Test getPrice(String); when 'Amount10currency.default'; then return '$10.00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_whenAmount10currencyDefault_thenReturn1000() {
    // Arrange, Act and Assert
    assertEquals("$10.00", bLCVariableExpression.getPrice("Amount10currency.default"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>When {@code Amount1042}.
   *   <li>Then return {@code $1,042.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName("Test getPrice(String); when 'Amount1042'; then return '$1,042.00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_whenAmount1042_thenReturn104200() {
    // Arrange, Act and Assert
    assertEquals("$1,042.00", new PromotionMessageVariableExpression().getPrice("Amount1042"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>When {@code Amount4210}.
   *   <li>Then return {@code $4,210.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName("Test getPrice(String); when 'Amount4210'; then return '$4,210.00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_whenAmount4210_thenReturn421000() {
    // Arrange, Act and Assert
    assertEquals("$4,210.00", new PromotionMessageVariableExpression().getPrice("Amount4210"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>When {@code Amount4242}.
   *   <li>Then return {@code $4,242.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName("Test getPrice(String); when 'Amount4242'; then return '$4,242.00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_whenAmount4242_thenReturn424200() {
    // Arrange, Act and Assert
    assertEquals("$4,242.00", new PromotionMessageVariableExpression().getPrice("Amount4242"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>When {@code currency.default10Amount}.
   *   <li>Then return {@code $0.10}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName("Test getPrice(String); when 'currency.default10Amount'; then return '$0.10'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_whenCurrencyDefault10Amount_thenReturn010() {
    // Arrange, Act and Assert
    assertEquals("$0.10", bLCVariableExpression.getPrice("currency.default10Amount"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>When {@code currency.default42Amount}.
   *   <li>Then return {@code $0.42}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName("Test getPrice(String); when 'currency.default42Amount'; then return '$0.42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_whenCurrencyDefault42Amount_thenReturn042() {
    // Arrange, Act and Assert
    assertEquals("$0.42", bLCVariableExpression.getPrice("currency.default42Amount"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>When {@code currency.defaultAmount10}.
   *   <li>Then return {@code $0.10}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName("Test getPrice(String); when 'currency.defaultAmount10'; then return '$0.10'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_whenCurrencyDefaultAmount10_thenReturn010() {
    // Arrange, Act and Assert
    assertEquals("$0.10", bLCVariableExpression.getPrice("currency.defaultAmount10"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>When {@code currency.defaultAmount42}.
   *   <li>Then return {@code $0.42}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName("Test getPrice(String); when 'currency.defaultAmount42'; then return '$0.42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_whenCurrencyDefaultAmount42_thenReturn042() {
    // Arrange, Act and Assert
    assertEquals("$0.42", bLCVariableExpression.getPrice("currency.defaultAmount42"));
  }
}
