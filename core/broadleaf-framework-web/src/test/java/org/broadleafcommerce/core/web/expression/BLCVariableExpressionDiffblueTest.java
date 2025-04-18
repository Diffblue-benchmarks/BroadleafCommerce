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
  @InjectMocks
  private BLCVariableExpression bLCVariableExpression;

  @Mock
  private CatalogURLService catalogURLService;

  /**
   * Test {@link BLCVariableExpression#getName()}.
   * <p>
   * Method under test: {@link BLCVariableExpression#getName()}
   */
  @Test
  @DisplayName("Test getName()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String BLCVariableExpression.getName()"})
  void testGetName() {
    // Arrange, Act and Assert
    assertEquals("blc", (new BLCVariableExpression()).getName());
  }

  /**
   * Test {@link BLCVariableExpression#relativeURL(String, Category)} with {@code baseUrl}, {@code category}.
   * <p>
   * Method under test: {@link BLCVariableExpression#relativeURL(String, Category)}
   */
  @Test
  @DisplayName("Test relativeURL(String, Category) with 'baseUrl', 'category'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String BLCVariableExpression.relativeURL(String, Category)"})
  void testRelativeURLWithBaseUrlCategory() {
    // Arrange
    when(catalogURLService.buildRelativeCategoryURL(Mockito.<String>any(), Mockito.<Category>any()))
        .thenReturn("https://example.org/example");

    // Act
    String actualRelativeURLResult = bLCVariableExpression.relativeURL("https://example.org/example",
        new CategoryImpl());

    // Assert
    verify(catalogURLService).buildRelativeCategoryURL(eq("https://example.org/example"), isA(Category.class));
    assertEquals("https://example.org/example", actualRelativeURLResult);
  }

  /**
   * Test {@link BLCVariableExpression#relativeURL(String, Product)} with {@code baseUrl}, {@code product}.
   * <p>
   * Method under test: {@link BLCVariableExpression#relativeURL(String, Product)}
   */
  @Test
  @DisplayName("Test relativeURL(String, Product) with 'baseUrl', 'product'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String BLCVariableExpression.relativeURL(String, Product)"})
  void testRelativeURLWithBaseUrlProduct() {
    // Arrange
    when(catalogURLService.buildRelativeProductURL(Mockito.<String>any(), Mockito.<Product>any()))
        .thenReturn("https://example.org/example");

    // Act
    String actualRelativeURLResult = bLCVariableExpression.relativeURL("https://example.org/example",
        new ProductBundleImpl());

    // Assert
    verify(catalogURLService).buildRelativeProductURL(eq("https://example.org/example"), isA(Product.class));
    assertEquals("https://example.org/example", actualRelativeURLResult);
  }

  /**
   * Test {@link BLCVariableExpression#relativeURL(Category)} with {@code category}.
   * <p>
   * Method under test: {@link BLCVariableExpression#relativeURL(Category)}
   */
  @Test
  @DisplayName("Test relativeURL(Category) with 'category'")
  @Tag("MaintainedByDiffblue")
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
   * <p>
   * Method under test: {@link BLCVariableExpression#relativeURL(Product)}
   */
  @Test
  @DisplayName("Test relativeURL(Product) with 'product'")
  @Tag("MaintainedByDiffblue")
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
   * <p>
   * Method under test: {@link BLCVariableExpression#getCurrentUrl()}
   */
  @Test
  @DisplayName("Test getCurrentUrl()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String BLCVariableExpression.getCurrentUrl()"})
  void testGetCurrentUrl() {
    // Arrange, Act and Assert
    assertEquals("", bLCVariableExpression.getCurrentUrl());
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   * <ul>
   *   <li>When {@code 10Amount10}.</li>
   *   <li>Then return {@code £1,010.00}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName("Test getPrice(String); when '10Amount10'; then return '£1,010.00'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_when10Amount10_thenReturn101000() {
    // Arrange, Act and Assert
    assertEquals("£1,010.00", bLCVariableExpression.getPrice("10Amount10"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   * <ul>
   *   <li>When {@code 10Amount42}.</li>
   *   <li>Then return {@code £1,042.00}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName("Test getPrice(String); when '10Amount42'; then return '£1,042.00'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_when10Amount42_thenReturn104200() {
    // Arrange, Act and Assert
    assertEquals("£1,042.00", bLCVariableExpression.getPrice("10Amount42"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   * <ul>
   *   <li>When {@code 10AmountAmount}.</li>
   *   <li>Then return {@code £10.00}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName("Test getPrice(String); when '10AmountAmount'; then return '£10.00'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_when10AmountAmount_thenReturn1000() {
    // Arrange, Act and Assert
    assertEquals("£10.00", bLCVariableExpression.getPrice("10AmountAmount"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   * <ul>
   *   <li>When {@code 10Amount[^\d.]+}.</li>
   *   <li>Then return {@code £10.00}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName("Test getPrice(String); when '10Amount[^\\d.]+'; then return '£10.00'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_when10AmountD_thenReturn1000() {
    // Arrange, Act and Assert
    assertEquals("£10.00", bLCVariableExpression.getPrice("10Amount[^\\d.]+"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   * <ul>
   *   <li>When {@code 10AmountU}.</li>
   *   <li>Then return {@code £10.00}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName("Test getPrice(String); when '10AmountU'; then return '£10.00'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_when10AmountU_thenReturn1000() {
    // Arrange, Act and Assert
    assertEquals("£10.00", bLCVariableExpression.getPrice("10AmountU"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   * <ul>
   *   <li>When {@code 10Amount}.</li>
   *   <li>Then return {@code £10.00}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName("Test getPrice(String); when '10Amount'; then return '£10.00'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_when10Amount_thenReturn1000() {
    // Arrange, Act and Assert
    assertEquals("£10.00", bLCVariableExpression.getPrice("10Amount"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   * <ul>
   *   <li>When {@code 10Amountcurrency.default}.</li>
   *   <li>Then return {@code £10.00}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName("Test getPrice(String); when '10Amountcurrency.default'; then return '£10.00'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_when10AmountcurrencyDefault_thenReturn1000() {
    // Arrange, Act and Assert
    assertEquals("£10.00", bLCVariableExpression.getPrice("10Amountcurrency.default"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   * <ul>
   *   <li>When {@code 10Amounttrue}.</li>
   *   <li>Then return {@code £10.00}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName("Test getPrice(String); when '10Amounttrue'; then return '£10.00'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_when10Amounttrue_thenReturn1000() {
    // Arrange, Act and Assert
    assertEquals("£10.00", bLCVariableExpression.getPrice("10Amounttrue"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   * <ul>
   *   <li>When {@code 10[^\d.]+10}.</li>
   *   <li>Then return {@code £10.10}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName("Test getPrice(String); when '10[^\\d.]+10'; then return '£10.10'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_when10D10_thenReturn1010() {
    // Arrange, Act and Assert
    assertEquals("£10.10", bLCVariableExpression.getPrice("10[^\\d.]+10"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   * <ul>
   *   <li>When {@code 10[^\d.]+42}.</li>
   *   <li>Then return {@code £10.42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName("Test getPrice(String); when '10[^\\d.]+42'; then return '£10.42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_when10D42_thenReturn1042() {
    // Arrange, Act and Assert
    assertEquals("£10.42", bLCVariableExpression.getPrice("10[^\\d.]+42"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   * <ul>
   *   <li>When {@code 10[^\d.]+Amount}.</li>
   *   <li>Then return {@code £10.00}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName("Test getPrice(String); when '10[^\\d.]+Amount'; then return '£10.00'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_when10DAmount_thenReturn1000() {
    // Arrange, Act and Assert
    assertEquals("£10.00", bLCVariableExpression.getPrice("10[^\\d.]+Amount"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   * <ul>
   *   <li>When {@code 10[^\d.]+true}.</li>
   *   <li>Then return {@code £10.00}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName("Test getPrice(String); when '10[^\\d.]+true'; then return '£10.00'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_when10DTrue_thenReturn1000() {
    // Arrange, Act and Assert
    assertEquals("£10.00", bLCVariableExpression.getPrice("10[^\\d.]+true"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   * <ul>
   *   <li>When {@code 10[^\d.]+U}.</li>
   *   <li>Then return {@code £10.00}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName("Test getPrice(String); when '10[^\\d.]+U'; then return '£10.00'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_when10DU_thenReturn1000() {
    // Arrange, Act and Assert
    assertEquals("£10.00", bLCVariableExpression.getPrice("10[^\\d.]+U"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   * <ul>
   *   <li>When {@code 10[^\d.]+}.</li>
   *   <li>Then return {@code £10.00}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName("Test getPrice(String); when '10[^\\d.]+'; then return '£10.00'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_when10D_thenReturn1000() {
    // Arrange, Act and Assert
    assertEquals("£10.00", bLCVariableExpression.getPrice("10[^\\d.]+"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   * <ul>
   *   <li>When {@code 10UAmount}.</li>
   *   <li>Then return {@code £10.00}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName("Test getPrice(String); when '10UAmount'; then return '£10.00'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_when10UAmount_thenReturn1000() {
    // Arrange, Act and Assert
    assertEquals("£10.00", bLCVariableExpression.getPrice("10UAmount"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   * <ul>
   *   <li>When {@code 10Ucurrency.default}.</li>
   *   <li>Then return {@code £10.00}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName("Test getPrice(String); when '10Ucurrency.default'; then return '£10.00'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_when10UcurrencyDefault_thenReturn1000() {
    // Arrange, Act and Assert
    assertEquals("£10.00", bLCVariableExpression.getPrice("10Ucurrency.default"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   * <ul>
   *   <li>When {@code 10Utrue}.</li>
   *   <li>Then return {@code £10.00}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName("Test getPrice(String); when '10Utrue'; then return '£10.00'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_when10Utrue_thenReturn1000() {
    // Arrange, Act and Assert
    assertEquals("£10.00", bLCVariableExpression.getPrice("10Utrue"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   * <ul>
   *   <li>When {@code 10}.</li>
   *   <li>Then return {@code £10.00}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName("Test getPrice(String); when '10'; then return '£10.00'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_when10_thenReturn1000() {
    // Arrange, Act and Assert
    assertEquals("£10.00", bLCVariableExpression.getPrice("10"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   * <ul>
   *   <li>When {@code 10currency.default10}.</li>
   *   <li>Then return {@code £10.10}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName("Test getPrice(String); when '10currency.default10'; then return '£10.10'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_when10currencyDefault10_thenReturn1010() {
    // Arrange, Act and Assert
    assertEquals("£10.10", bLCVariableExpression.getPrice("10currency.default10"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   * <ul>
   *   <li>When {@code 10currency.default42}.</li>
   *   <li>Then return {@code £10.42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName("Test getPrice(String); when '10currency.default42'; then return '£10.42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_when10currencyDefault42_thenReturn1042() {
    // Arrange, Act and Assert
    assertEquals("£10.42", bLCVariableExpression.getPrice("10currency.default42"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   * <ul>
   *   <li>When {@code 10currency.defaultAmount}.</li>
   *   <li>Then return {@code £10.00}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName("Test getPrice(String); when '10currency.defaultAmount'; then return '£10.00'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_when10currencyDefaultAmount_thenReturn1000() {
    // Arrange, Act and Assert
    assertEquals("£10.00", bLCVariableExpression.getPrice("10currency.defaultAmount"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   * <ul>
   *   <li>When {@code 10currency.defaultU}.</li>
   *   <li>Then return {@code £10.00}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName("Test getPrice(String); when '10currency.defaultU'; then return '£10.00'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_when10currencyDefaultU_thenReturn1000() {
    // Arrange, Act and Assert
    assertEquals("£10.00", bLCVariableExpression.getPrice("10currency.defaultU"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   * <ul>
   *   <li>When {@code 10currency.default}.</li>
   *   <li>Then return {@code £10.00}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName("Test getPrice(String); when '10currency.default'; then return '£10.00'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_when10currencyDefault_thenReturn1000() {
    // Arrange, Act and Assert
    assertEquals("£10.00", bLCVariableExpression.getPrice("10currency.default"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   * <ul>
   *   <li>When {@code 10currency.defaulttrue}.</li>
   *   <li>Then return {@code £10.00}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName("Test getPrice(String); when '10currency.defaulttrue'; then return '£10.00'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_when10currencyDefaulttrue_thenReturn1000() {
    // Arrange, Act and Assert
    assertEquals("£10.00", bLCVariableExpression.getPrice("10currency.defaulttrue"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   * <ul>
   *   <li>When {@code 10true10}.</li>
   *   <li>Then return {@code £1,010.00}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName("Test getPrice(String); when '10true10'; then return '£1,010.00'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_when10true10_thenReturn101000() {
    // Arrange, Act and Assert
    assertEquals("£1,010.00", bLCVariableExpression.getPrice("10true10"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   * <ul>
   *   <li>When {@code 10true42}.</li>
   *   <li>Then return {@code £1,042.00}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName("Test getPrice(String); when '10true42'; then return '£1,042.00'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_when10true42_thenReturn104200() {
    // Arrange, Act and Assert
    assertEquals("£1,042.00", bLCVariableExpression.getPrice("10true42"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   * <ul>
   *   <li>When {@code 10trueAmount}.</li>
   *   <li>Then return {@code £10.00}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName("Test getPrice(String); when '10trueAmount'; then return '£10.00'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_when10trueAmount_thenReturn1000() {
    // Arrange, Act and Assert
    assertEquals("£10.00", bLCVariableExpression.getPrice("10trueAmount"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   * <ul>
   *   <li>When {@code 10true[^\d.]+}.</li>
   *   <li>Then return {@code £10.00}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName("Test getPrice(String); when '10true[^\\d.]+'; then return '£10.00'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_when10trueD_thenReturn1000() {
    // Arrange, Act and Assert
    assertEquals("£10.00", bLCVariableExpression.getPrice("10true[^\\d.]+"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   * <ul>
   *   <li>When {@code 10trueU}.</li>
   *   <li>Then return {@code £10.00}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName("Test getPrice(String); when '10trueU'; then return '£10.00'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_when10trueU_thenReturn1000() {
    // Arrange, Act and Assert
    assertEquals("£10.00", bLCVariableExpression.getPrice("10trueU"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   * <ul>
   *   <li>When {@code 10true}.</li>
   *   <li>Then return {@code £10.00}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName("Test getPrice(String); when '10true'; then return '£10.00'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_when10true_thenReturn1000() {
    // Arrange, Act and Assert
    assertEquals("£10.00", bLCVariableExpression.getPrice("10true"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   * <ul>
   *   <li>When {@code 10truecurrency.default}.</li>
   *   <li>Then return {@code £10.00}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName("Test getPrice(String); when '10truecurrency.default'; then return '£10.00'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_when10truecurrencyDefault_thenReturn1000() {
    // Arrange, Act and Assert
    assertEquals("£10.00", bLCVariableExpression.getPrice("10truecurrency.default"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   * <ul>
   *   <li>When {@code 10truetrue}.</li>
   *   <li>Then return {@code £10.00}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName("Test getPrice(String); when '10truetrue'; then return '£10.00'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_when10truetrue_thenReturn1000() {
    // Arrange, Act and Assert
    assertEquals("£10.00", bLCVariableExpression.getPrice("10truetrue"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   * <ul>
   *   <li>When {@code 10U10}.</li>
   *   <li>Then return {@code £1,010.00}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName("Test getPrice(String); when '10U10'; then return '£1,010.00'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_when10u10_thenReturn101000() {
    // Arrange, Act and Assert
    assertEquals("£1,010.00", bLCVariableExpression.getPrice("10U10"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   * <ul>
   *   <li>When {@code 10U42}.</li>
   *   <li>Then return {@code £1,042.00}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName("Test getPrice(String); when '10U42'; then return '£1,042.00'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_when10u42_thenReturn104200() {
    // Arrange, Act and Assert
    assertEquals("£1,042.00", bLCVariableExpression.getPrice("10U42"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   * <ul>
   *   <li>When {@code 10U[^\d.]+}.</li>
   *   <li>Then return {@code £10.00}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName("Test getPrice(String); when '10U[^\\d.]+'; then return '£10.00'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_when10uD_thenReturn1000() {
    // Arrange, Act and Assert
    assertEquals("£10.00", bLCVariableExpression.getPrice("10U[^\\d.]+"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   * <ul>
   *   <li>When {@code 10U}.</li>
   *   <li>Then return {@code £10.00}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName("Test getPrice(String); when '10U'; then return '£10.00'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_when10u_thenReturn1000() {
    // Arrange, Act and Assert
    assertEquals("£10.00", bLCVariableExpression.getPrice("10U"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   * <ul>
   *   <li>When {@code 10UU}.</li>
   *   <li>Then return {@code £10.00}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName("Test getPrice(String); when '10UU'; then return '£10.00'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_when10uu_thenReturn1000() {
    // Arrange, Act and Assert
    assertEquals("£10.00", bLCVariableExpression.getPrice("10UU"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   * <ul>
   *   <li>When {@code 42Amount}.</li>
   *   <li>Then return {@code £42.00}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName("Test getPrice(String); when '42Amount'; then return '£42.00'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_when42Amount_thenReturn4200() {
    // Arrange, Act and Assert
    assertEquals("£42.00", bLCVariableExpression.getPrice("42Amount"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   * <ul>
   *   <li>When {@code 42[^\d.]+}.</li>
   *   <li>Then return {@code £42.00}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName("Test getPrice(String); when '42[^\\d.]+'; then return '£42.00'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_when42D_thenReturn4200() {
    // Arrange, Act and Assert
    assertEquals("£42.00", bLCVariableExpression.getPrice("42[^\\d.]+"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   * <ul>
   *   <li>When {@code 42}.</li>
   *   <li>Then return {@code £42.00}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName("Test getPrice(String); when '42'; then return '£42.00'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_when42_thenReturn4200() {
    // Arrange, Act and Assert
    assertEquals("£42.00", bLCVariableExpression.getPrice("42"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   * <ul>
   *   <li>When {@code 42currency.default}.</li>
   *   <li>Then return {@code £42.00}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName("Test getPrice(String); when '42currency.default'; then return '£42.00'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_when42currencyDefault_thenReturn4200() {
    // Arrange, Act and Assert
    assertEquals("£42.00", bLCVariableExpression.getPrice("42currency.default"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   * <ul>
   *   <li>When {@code 42true}.</li>
   *   <li>Then return {@code £42.00}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName("Test getPrice(String); when '42true'; then return '£42.00'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_when42true_thenReturn4200() {
    // Arrange, Act and Assert
    assertEquals("£42.00", bLCVariableExpression.getPrice("42true"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   * <ul>
   *   <li>When {@code 42U}.</li>
   *   <li>Then return {@code £42.00}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName("Test getPrice(String); when '42U'; then return '£42.00'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_when42u_thenReturn4200() {
    // Arrange, Act and Assert
    assertEquals("£42.00", bLCVariableExpression.getPrice("42U"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   * <ul>
   *   <li>When {@code 1010Amount}.</li>
   *   <li>Then return {@code £1,010.00}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName("Test getPrice(String); when '1010Amount'; then return '£1,010.00'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_when1010Amount_thenReturn101000() {
    // Arrange, Act and Assert
    assertEquals("£1,010.00", bLCVariableExpression.getPrice("1010Amount"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   * <ul>
   *   <li>When {@code 1010[^\d.]+}.</li>
   *   <li>Then return {@code £1,010.00}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName("Test getPrice(String); when '1010[^\\d.]+'; then return '£1,010.00'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_when1010D_thenReturn101000() {
    // Arrange, Act and Assert
    assertEquals("£1,010.00", bLCVariableExpression.getPrice("1010[^\\d.]+"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   * <ul>
   *   <li>When {@code 1010currency.default}.</li>
   *   <li>Then return {@code £1,010.00}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName("Test getPrice(String); when '1010currency.default'; then return '£1,010.00'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_when1010currencyDefault_thenReturn101000() {
    // Arrange, Act and Assert
    assertEquals("£1,010.00", bLCVariableExpression.getPrice("1010currency.default"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   * <ul>
   *   <li>When {@code 1010true}.</li>
   *   <li>Then return {@code £1,010.00}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName("Test getPrice(String); when '1010true'; then return '£1,010.00'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_when1010true_thenReturn101000() {
    // Arrange, Act and Assert
    assertEquals("£1,010.00", bLCVariableExpression.getPrice("1010true"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   * <ul>
   *   <li>When {@code 1010U}.</li>
   *   <li>Then return {@code £1,010.00}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName("Test getPrice(String); when '1010U'; then return '£1,010.00'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_when1010u_thenReturn101000() {
    // Arrange, Act and Assert
    assertEquals("£1,010.00", bLCVariableExpression.getPrice("1010U"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   * <ul>
   *   <li>When {@code 1042Amount}.</li>
   *   <li>Then return {@code £1,042.00}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName("Test getPrice(String); when '1042Amount'; then return '£1,042.00'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_when1042Amount_thenReturn104200() {
    // Arrange, Act and Assert
    assertEquals("£1,042.00", bLCVariableExpression.getPrice("1042Amount"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   * <ul>
   *   <li>When {@code 1042[^\d.]+}.</li>
   *   <li>Then return {@code £1,042.00}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName("Test getPrice(String); when '1042[^\\d.]+'; then return '£1,042.00'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_when1042D_thenReturn104200() {
    // Arrange, Act and Assert
    assertEquals("£1,042.00", bLCVariableExpression.getPrice("1042[^\\d.]+"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   * <ul>
   *   <li>When {@code 1042currency.default}.</li>
   *   <li>Then return {@code £1,042.00}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName("Test getPrice(String); when '1042currency.default'; then return '£1,042.00'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_when1042currencyDefault_thenReturn104200() {
    // Arrange, Act and Assert
    assertEquals("£1,042.00", bLCVariableExpression.getPrice("1042currency.default"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   * <ul>
   *   <li>When {@code 1042true}.</li>
   *   <li>Then return {@code £1,042.00}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName("Test getPrice(String); when '1042true'; then return '£1,042.00'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_when1042true_thenReturn104200() {
    // Arrange, Act and Assert
    assertEquals("£1,042.00", bLCVariableExpression.getPrice("1042true"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   * <ul>
   *   <li>When {@code 1042U}.</li>
   *   <li>Then return {@code £1,042.00}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName("Test getPrice(String); when '1042U'; then return '£1,042.00'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_when1042u_thenReturn104200() {
    // Arrange, Act and Assert
    assertEquals("£1,042.00", bLCVariableExpression.getPrice("1042U"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   * <ul>
   *   <li>When {@code Amount10}.</li>
   *   <li>Then return {@code £10.00}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName("Test getPrice(String); when 'Amount10'; then return '£10.00'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_whenAmount10_thenReturn1000() {
    // Arrange, Act and Assert
    assertEquals("£10.00", bLCVariableExpression.getPrice("Amount10"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   * <ul>
   *   <li>When {@code Amount42}.</li>
   *   <li>Then return {@code £42.00}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName("Test getPrice(String); when 'Amount42'; then return '£42.00'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_whenAmount42_thenReturn4200() {
    // Arrange, Act and Assert
    assertEquals("£42.00", bLCVariableExpression.getPrice("Amount42"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   * <ul>
   *   <li>When {@code AmountAmount}.</li>
   *   <li>Then return {@code $ 0.00}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName("Test getPrice(String); when 'AmountAmount'; then return '$ 0.00'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_whenAmountAmount_thenReturn000() {
    // Arrange, Act and Assert
    assertEquals("$ 0.00", bLCVariableExpression.getPrice("AmountAmount"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   * <ul>
   *   <li>When {@code AmountU}.</li>
   *   <li>Then return {@code $ 0.00}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName("Test getPrice(String); when 'AmountU'; then return '$ 0.00'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_whenAmountU_thenReturn000() {
    // Arrange, Act and Assert
    assertEquals("$ 0.00", bLCVariableExpression.getPrice("AmountU"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   * <ul>
   *   <li>When {@code Amount}.</li>
   *   <li>Then return {@code $ 0.00}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName("Test getPrice(String); when 'Amount'; then return '$ 0.00'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_whenAmount_thenReturn000() {
    // Arrange, Act and Assert
    assertEquals("$ 0.00", bLCVariableExpression.getPrice("Amount"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   * <ul>
   *   <li>When {@code Amounttrue}.</li>
   *   <li>Then return {@code $ 0.00}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName("Test getPrice(String); when 'Amounttrue'; then return '$ 0.00'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_whenAmounttrue_thenReturn000() {
    // Arrange, Act and Assert
    assertEquals("$ 0.00", bLCVariableExpression.getPrice("Amounttrue"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   * <ul>
   *   <li>When {@code currency.default10}.</li>
   *   <li>Then return {@code £0.10}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName("Test getPrice(String); when 'currency.default10'; then return '£0.10'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_whenCurrencyDefault10_thenReturn010() {
    // Arrange, Act and Assert
    assertEquals("£0.10", bLCVariableExpression.getPrice("currency.default10"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   * <ul>
   *   <li>When {@code currency.default42}.</li>
   *   <li>Then return {@code £0.42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName("Test getPrice(String); when 'currency.default42'; then return '£0.42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_whenCurrencyDefault42_thenReturn042() {
    // Arrange, Act and Assert
    assertEquals("£0.42", bLCVariableExpression.getPrice("currency.default42"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   * <ul>
   *   <li>When {@code [^\d.]+10}.</li>
   *   <li>Then return {@code £0.10}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName("Test getPrice(String); when '[^\\d.]+10'; then return '£0.10'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_whenD10_thenReturn010() {
    // Arrange, Act and Assert
    assertEquals("£0.10", bLCVariableExpression.getPrice("[^\\d.]+10"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   * <ul>
   *   <li>When {@code [^\d.]+42}.</li>
   *   <li>Then return {@code £0.42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName("Test getPrice(String); when '[^\\d.]+42'; then return '£0.42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_whenD42_thenReturn042() {
    // Arrange, Act and Assert
    assertEquals("£0.42", bLCVariableExpression.getPrice("[^\\d.]+42"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   * <ul>
   *   <li>When {@code true10}.</li>
   *   <li>Then return {@code £10.00}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName("Test getPrice(String); when 'true10'; then return '£10.00'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_whenTrue10_thenReturn1000() {
    // Arrange, Act and Assert
    assertEquals("£10.00", bLCVariableExpression.getPrice("true10"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   * <ul>
   *   <li>When {@code true42}.</li>
   *   <li>Then return {@code £42.00}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName("Test getPrice(String); when 'true42'; then return '£42.00'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_whenTrue42_thenReturn4200() {
    // Arrange, Act and Assert
    assertEquals("£42.00", bLCVariableExpression.getPrice("true42"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   * <ul>
   *   <li>When {@code trueAmount}.</li>
   *   <li>Then return {@code $ 0.00}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName("Test getPrice(String); when 'trueAmount'; then return '$ 0.00'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_whenTrueAmount_thenReturn000() {
    // Arrange, Act and Assert
    assertEquals("$ 0.00", bLCVariableExpression.getPrice("trueAmount"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   * <ul>
   *   <li>When {@link Boolean#TRUE} toString.</li>
   *   <li>Then return {@code $ 0.00}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName("Test getPrice(String); when TRUE toString; then return '$ 0.00'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_whenTrueToString_thenReturn000() {
    // Arrange, Act and Assert
    assertEquals("$ 0.00", bLCVariableExpression.getPrice(Boolean.TRUE.toString()));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   * <ul>
   *   <li>When {@code trueU}.</li>
   *   <li>Then return {@code $ 0.00}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName("Test getPrice(String); when 'trueU'; then return '$ 0.00'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_whenTrueU_thenReturn000() {
    // Arrange, Act and Assert
    assertEquals("$ 0.00", bLCVariableExpression.getPrice("trueU"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   * <ul>
   *   <li>When {@code truetrue}.</li>
   *   <li>Then return {@code $ 0.00}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName("Test getPrice(String); when 'truetrue'; then return '$ 0.00'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_whenTruetrue_thenReturn000() {
    // Arrange, Act and Assert
    assertEquals("$ 0.00", bLCVariableExpression.getPrice("truetrue"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   * <ul>
   *   <li>When {@code U10Amount}.</li>
   *   <li>Then return {@code £10.00}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName("Test getPrice(String); when 'U10Amount'; then return '£10.00'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_whenU10Amount_thenReturn1000() {
    // Arrange, Act and Assert
    assertEquals("£10.00", bLCVariableExpression.getPrice("U10Amount"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   * <ul>
   *   <li>When {@code U10[^\d.]+}.</li>
   *   <li>Then return {@code £10.00}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName("Test getPrice(String); when 'U10[^\\d.]+'; then return '£10.00'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_whenU10D_thenReturn1000() {
    // Arrange, Act and Assert
    assertEquals("£10.00", bLCVariableExpression.getPrice("U10[^\\d.]+"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   * <ul>
   *   <li>When {@code U10}.</li>
   *   <li>Then return {@code £10.00}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName("Test getPrice(String); when 'U10'; then return '£10.00'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_whenU10_thenReturn1000() {
    // Arrange, Act and Assert
    assertEquals("£10.00", bLCVariableExpression.getPrice("U10"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   * <ul>
   *   <li>When {@code U10currency.default}.</li>
   *   <li>Then return {@code £10.00}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName("Test getPrice(String); when 'U10currency.default'; then return '£10.00'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_whenU10currencyDefault_thenReturn1000() {
    // Arrange, Act and Assert
    assertEquals("£10.00", bLCVariableExpression.getPrice("U10currency.default"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   * <ul>
   *   <li>When {@code U10true}.</li>
   *   <li>Then return {@code £10.00}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName("Test getPrice(String); when 'U10true'; then return '£10.00'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_whenU10true_thenReturn1000() {
    // Arrange, Act and Assert
    assertEquals("£10.00", bLCVariableExpression.getPrice("U10true"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   * <ul>
   *   <li>When {@code U10U}.</li>
   *   <li>Then return {@code £10.00}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName("Test getPrice(String); when 'U10U'; then return '£10.00'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_whenU10u_thenReturn1000() {
    // Arrange, Act and Assert
    assertEquals("£10.00", bLCVariableExpression.getPrice("U10U"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   * <ul>
   *   <li>When {@code U42}.</li>
   *   <li>Then return {@code £42.00}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName("Test getPrice(String); when 'U42'; then return '£42.00'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_whenU42_thenReturn4200() {
    // Arrange, Act and Assert
    assertEquals("£42.00", bLCVariableExpression.getPrice("U42"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   * <ul>
   *   <li>When {@code U1010}.</li>
   *   <li>Then return {@code £1,010.00}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName("Test getPrice(String); when 'U1010'; then return '£1,010.00'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_whenU1010_thenReturn101000() {
    // Arrange, Act and Assert
    assertEquals("£1,010.00", bLCVariableExpression.getPrice("U1010"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   * <ul>
   *   <li>When {@code U1042}.</li>
   *   <li>Then return {@code £1,042.00}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName("Test getPrice(String); when 'U1042'; then return '£1,042.00'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_whenU1042_thenReturn104200() {
    // Arrange, Act and Assert
    assertEquals("£1,042.00", bLCVariableExpression.getPrice("U1042"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   * <ul>
   *   <li>When {@code UAmount}.</li>
   *   <li>Then return {@code $ 0.00}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName("Test getPrice(String); when 'UAmount'; then return '$ 0.00'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_whenUAmount_thenReturn000() {
    // Arrange, Act and Assert
    assertEquals("$ 0.00", bLCVariableExpression.getPrice("UAmount"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   * <ul>
   *   <li>When {@code U[^\d.]+10}.</li>
   *   <li>Then return {@code £0.10}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName("Test getPrice(String); when 'U[^\\d.]+10'; then return '£0.10'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_whenUD10_thenReturn010() {
    // Arrange, Act and Assert
    assertEquals("£0.10", bLCVariableExpression.getPrice("U[^\\d.]+10"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   * <ul>
   *   <li>When {@code U[^\d.]+42}.</li>
   *   <li>Then return {@code £0.42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName("Test getPrice(String); when 'U[^\\d.]+42'; then return '£0.42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_whenUD42_thenReturn042() {
    // Arrange, Act and Assert
    assertEquals("£0.42", bLCVariableExpression.getPrice("U[^\\d.]+42"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   * <ul>
   *   <li>When {@code UUAmount}.</li>
   *   <li>Then return {@code $ 0.00}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName("Test getPrice(String); when 'UUAmount'; then return '$ 0.00'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_whenUUAmount_thenReturn000() {
    // Arrange, Act and Assert
    assertEquals("$ 0.00", bLCVariableExpression.getPrice("UUAmount"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   * <ul>
   *   <li>When {@code UUtrue}.</li>
   *   <li>Then return {@code $ 0.00}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName("Test getPrice(String); when 'UUtrue'; then return '$ 0.00'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_whenUUtrue_thenReturn000() {
    // Arrange, Act and Assert
    assertEquals("$ 0.00", bLCVariableExpression.getPrice("UUtrue"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   * <ul>
   *   <li>When {@code U}.</li>
   *   <li>Then return {@code $ 0.00}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName("Test getPrice(String); when 'U'; then return '$ 0.00'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_whenU_thenReturn000() {
    // Arrange, Act and Assert
    assertEquals("$ 0.00", bLCVariableExpression.getPrice("U"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   * <ul>
   *   <li>When {@code Utrue}.</li>
   *   <li>Then return {@code $ 0.00}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName("Test getPrice(String); when 'Utrue'; then return '$ 0.00'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_whenUtrue_thenReturn000() {
    // Arrange, Act and Assert
    assertEquals("$ 0.00", bLCVariableExpression.getPrice("Utrue"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   * <ul>
   *   <li>When {@code UU10}.</li>
   *   <li>Then return {@code £10.00}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName("Test getPrice(String); when 'UU10'; then return '£10.00'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_whenUu10_thenReturn1000() {
    // Arrange, Act and Assert
    assertEquals("£10.00", bLCVariableExpression.getPrice("UU10"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   * <ul>
   *   <li>When {@code UU42}.</li>
   *   <li>Then return {@code £42.00}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName("Test getPrice(String); when 'UU42'; then return '£42.00'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_whenUu42_thenReturn4200() {
    // Arrange, Act and Assert
    assertEquals("£42.00", bLCVariableExpression.getPrice("UU42"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   * <ul>
   *   <li>When {@code UU}.</li>
   *   <li>Then return {@code $ 0.00}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName("Test getPrice(String); when 'UU'; then return '$ 0.00'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_whenUu_thenReturn000() {
    // Arrange, Act and Assert
    assertEquals("$ 0.00", bLCVariableExpression.getPrice("UU"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   * <ul>
   *   <li>When {@code UUU}.</li>
   *   <li>Then return {@code $ 0.00}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @DisplayName("Test getPrice(String); when 'UUU'; then return '$ 0.00'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  void testGetPrice_whenUuu_thenReturn000() {
    // Arrange, Act and Assert
    assertEquals("$ 0.00", bLCVariableExpression.getPrice("UUU"));
  }
}
