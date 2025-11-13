package org.broadleafcommerce.core.web.expression;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.core.catalog.domain.CategoryImpl;
import org.broadleafcommerce.core.catalog.domain.Product;
import org.broadleafcommerce.core.catalog.domain.ProductBundleImpl;
import org.broadleafcommerce.core.catalog.service.CatalogURLService;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class BLCVariableExpressionDiffblueTest {
  @InjectMocks private BLCVariableExpression bLCVariableExpression;

  @Mock private CatalogURLService catalogURLService;

  /**
   * Test {@link BLCVariableExpression#getName()}.
   *
   * <p>Method under test: {@link BLCVariableExpression#getName()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getName()"})
  public void testGetName() {
    // Arrange, Act and Assert
    assertEquals("blc", new BLCVariableExpression().getName());
  }

  /**
   * Test {@link BLCVariableExpression#relativeURL(String, Category)} with {@code baseUrl}, {@code
   * category}.
   *
   * <p>Method under test: {@link BLCVariableExpression#relativeURL(String,
   * org.broadleafcommerce.core.catalog.domain.Category)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BLCVariableExpression.relativeURL(String, org.broadleafcommerce.core.catalog.domain.Category)"
  })
  public void testRelativeURLWithBaseUrlCategory() {
    // Arrange
    when(catalogURLService.buildRelativeCategoryURL(
            Mockito.<String>any(),
            Mockito.<org.broadleafcommerce.core.catalog.domain.Category>any()))
        .thenReturn("https://example.org/example");

    // Act
    String actualRelativeURLResult =
        bLCVariableExpression.relativeURL("https://example.org/example", new CategoryImpl());

    // Assert
    verify(catalogURLService)
        .buildRelativeCategoryURL(
            eq("https://example.org/example"),
            isA(org.broadleafcommerce.core.catalog.domain.Category.class));
    assertEquals("https://example.org/example", actualRelativeURLResult);
  }

  /**
   * Test {@link BLCVariableExpression#relativeURL(String, Product)} with {@code baseUrl}, {@code
   * product}.
   *
   * <p>Method under test: {@link BLCVariableExpression#relativeURL(String, Product)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.relativeURL(String, Product)"})
  public void testRelativeURLWithBaseUrlProduct() {
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
   * <p>Method under test: {@link
   * BLCVariableExpression#relativeURL(org.broadleafcommerce.core.catalog.domain.Category)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BLCVariableExpression.relativeURL(org.broadleafcommerce.core.catalog.domain.Category)"
  })
  public void testRelativeURLWithCategory() {
    // Arrange
    when(catalogURLService.buildRelativeCategoryURL(
            Mockito.<String>any(),
            Mockito.<org.broadleafcommerce.core.catalog.domain.Category>any()))
        .thenReturn("https://example.org/example");

    // Act
    String actualRelativeURLResult = bLCVariableExpression.relativeURL(new CategoryImpl());

    // Assert
    verify(catalogURLService)
        .buildRelativeCategoryURL(
            eq(""), isA(org.broadleafcommerce.core.catalog.domain.Category.class));
    assertEquals("https://example.org/example", actualRelativeURLResult);
  }

  /**
   * Test {@link BLCVariableExpression#relativeURL(Product)} with {@code product}.
   *
   * <p>Method under test: {@link BLCVariableExpression#relativeURL(Product)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.relativeURL(Product)"})
  public void testRelativeURLWithProduct() {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getCurrentUrl()"})
  public void testGetCurrentUrl() {
    // Arrange, Act and Assert
    assertEquals("", new BLCVariableExpression().getCurrentUrl());
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression} (default constructor).
   *   <li>When {@code 10Amount[^\d.]+}.
   *   <li>Then return {@code USD10.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  public void testGetPrice_givenBLCVariableExpression_when10AmountD_thenReturnUsd1000() {
    // Arrange, Act and Assert
    assertEquals("USD10.00", new BLCVariableExpression().getPrice("10Amount[^\\d.]+"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression} (default constructor).
   *   <li>When {@code 10AmountUSD}.
   *   <li>Then return {@code USD10.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  public void testGetPrice_givenBLCVariableExpression_when10AmountUSD_thenReturnUsd1000() {
    // Arrange, Act and Assert
    assertEquals("USD10.00", new BLCVariableExpression().getPrice("10AmountUSD"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression} (default constructor).
   *   <li>When {@code 10AmountUUU}.
   *   <li>Then return {@code USD10.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  public void testGetPrice_givenBLCVariableExpression_when10AmountUUU_thenReturnUsd1000() {
    // Arrange, Act and Assert
    assertEquals("USD10.00", new BLCVariableExpression().getPrice("10AmountUUU"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression} (default constructor).
   *   <li>When {@code 10Amount}.
   *   <li>Then return {@code USD10.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  public void testGetPrice_givenBLCVariableExpression_when10Amount_thenReturnUsd1000() {
    // Arrange, Act and Assert
    assertEquals("USD10.00", new BLCVariableExpression().getPrice("10Amount"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression} (default constructor).
   *   <li>When {@code 10[^\d.]+10}.
   *   <li>Then return {@code USD10.10}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  public void testGetPrice_givenBLCVariableExpression_when10D10_thenReturnUsd1010() {
    // Arrange, Act and Assert
    assertEquals("USD10.10", new BLCVariableExpression().getPrice("10[^\\d.]+10"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression} (default constructor).
   *   <li>When {@code 10[^\d.]+42}.
   *   <li>Then return {@code USD10.42}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  public void testGetPrice_givenBLCVariableExpression_when10D42_thenReturnUsd1042() {
    // Arrange, Act and Assert
    assertEquals("USD10.42", new BLCVariableExpression().getPrice("10[^\\d.]+42"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression} (default constructor).
   *   <li>When {@code 10[^\d.]+Amount}.
   *   <li>Then return {@code USD10.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  public void testGetPrice_givenBLCVariableExpression_when10DAmount_thenReturnUsd1000() {
    // Arrange, Act and Assert
    assertEquals("USD10.00", new BLCVariableExpression().getPrice("10[^\\d.]+Amount"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression} (default constructor).
   *   <li>When {@code 10[^\d.]+USD}.
   *   <li>Then return {@code USD10.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  public void testGetPrice_givenBLCVariableExpression_when10DUsd_thenReturnUsd1000() {
    // Arrange, Act and Assert
    assertEquals("USD10.00", new BLCVariableExpression().getPrice("10[^\\d.]+USD"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression} (default constructor).
   *   <li>When {@code 10[^\d.]+UUU}.
   *   <li>Then return {@code USD10.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  public void testGetPrice_givenBLCVariableExpression_when10DUuu_thenReturnUsd1000() {
    // Arrange, Act and Assert
    assertEquals("USD10.00", new BLCVariableExpression().getPrice("10[^\\d.]+UUU"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression} (default constructor).
   *   <li>When {@code 10[^\d.]+}.
   *   <li>Then return {@code USD10.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  public void testGetPrice_givenBLCVariableExpression_when10D_thenReturnUsd1000() {
    // Arrange, Act and Assert
    assertEquals("USD10.00", new BLCVariableExpression().getPrice("10[^\\d.]+"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression} (default constructor).
   *   <li>When {@code 10USDAmount}.
   *   <li>Then return {@code USD10.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  public void testGetPrice_givenBLCVariableExpression_when10USDAmount_thenReturnUsd1000() {
    // Arrange, Act and Assert
    assertEquals("USD10.00", new BLCVariableExpression().getPrice("10USDAmount"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression} (default constructor).
   *   <li>When {@code 10UUUAmount}.
   *   <li>Then return {@code USD10.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  public void testGetPrice_givenBLCVariableExpression_when10UUUAmount_thenReturnUsd1000() {
    // Arrange, Act and Assert
    assertEquals("USD10.00", new BLCVariableExpression().getPrice("10UUUAmount"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression} (default constructor).
   *   <li>When {@code 10}.
   *   <li>Then return {@code USD10.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  public void testGetPrice_givenBLCVariableExpression_when10_thenReturnUsd1000() {
    // Arrange, Act and Assert
    assertEquals("USD10.00", new BLCVariableExpression().getPrice("10"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression} (default constructor).
   *   <li>When {@code 10currency.default}.
   *   <li>Then return {@code USD10.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  public void testGetPrice_givenBLCVariableExpression_when10currencyDefault_thenReturnUsd1000() {
    // Arrange, Act and Assert
    assertEquals("USD10.00", new BLCVariableExpression().getPrice("10currency.default"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression} (default constructor).
   *   <li>When {@code 10USD10}.
   *   <li>Then return {@code USD1,010.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  public void testGetPrice_givenBLCVariableExpression_when10usd10_thenReturnUsd101000() {
    // Arrange, Act and Assert
    assertEquals("USD1,010.00", new BLCVariableExpression().getPrice("10USD10"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression} (default constructor).
   *   <li>When {@code 10USD42}.
   *   <li>Then return {@code USD1,042.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  public void testGetPrice_givenBLCVariableExpression_when10usd42_thenReturnUsd104200() {
    // Arrange, Act and Assert
    assertEquals("USD1,042.00", new BLCVariableExpression().getPrice("10USD42"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression} (default constructor).
   *   <li>When {@code 10USD[^\d.]+}.
   *   <li>Then return {@code USD10.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  public void testGetPrice_givenBLCVariableExpression_when10usdD_thenReturnUsd1000() {
    // Arrange, Act and Assert
    assertEquals("USD10.00", new BLCVariableExpression().getPrice("10USD[^\\d.]+"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression} (default constructor).
   *   <li>When {@code 10USD}.
   *   <li>Then return {@code USD10.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  public void testGetPrice_givenBLCVariableExpression_when10usd_thenReturnUsd1000() {
    // Arrange, Act and Assert
    assertEquals("USD10.00", new BLCVariableExpression().getPrice("10USD"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression} (default constructor).
   *   <li>When {@code 10USDUSD}.
   *   <li>Then return {@code USD10.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  public void testGetPrice_givenBLCVariableExpression_when10usdusd_thenReturnUsd1000() {
    // Arrange, Act and Assert
    assertEquals("USD10.00", new BLCVariableExpression().getPrice("10USDUSD"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression} (default constructor).
   *   <li>When {@code 10USDUUU}.
   *   <li>Then return {@code USD10.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  public void testGetPrice_givenBLCVariableExpression_when10usduuu_thenReturnUsd1000() {
    // Arrange, Act and Assert
    assertEquals("USD10.00", new BLCVariableExpression().getPrice("10USDUUU"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression} (default constructor).
   *   <li>When {@code 10UUU10}.
   *   <li>Then return {@code USD1,010.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  public void testGetPrice_givenBLCVariableExpression_when10uuu10_thenReturnUsd101000() {
    // Arrange, Act and Assert
    assertEquals("USD1,010.00", new BLCVariableExpression().getPrice("10UUU10"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression} (default constructor).
   *   <li>When {@code 10UUU42}.
   *   <li>Then return {@code USD1,042.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  public void testGetPrice_givenBLCVariableExpression_when10uuu42_thenReturnUsd104200() {
    // Arrange, Act and Assert
    assertEquals("USD1,042.00", new BLCVariableExpression().getPrice("10UUU42"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression} (default constructor).
   *   <li>When {@code 10UUU[^\d.]+}.
   *   <li>Then return {@code USD10.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  public void testGetPrice_givenBLCVariableExpression_when10uuuD_thenReturnUsd1000() {
    // Arrange, Act and Assert
    assertEquals("USD10.00", new BLCVariableExpression().getPrice("10UUU[^\\d.]+"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression} (default constructor).
   *   <li>When {@code 10UUU}.
   *   <li>Then return {@code USD10.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  public void testGetPrice_givenBLCVariableExpression_when10uuu_thenReturnUsd1000() {
    // Arrange, Act and Assert
    assertEquals("USD10.00", new BLCVariableExpression().getPrice("10UUU"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression} (default constructor).
   *   <li>When {@code 10UUUUSD}.
   *   <li>Then return {@code USD10.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  public void testGetPrice_givenBLCVariableExpression_when10uuuusd_thenReturnUsd1000() {
    // Arrange, Act and Assert
    assertEquals("USD10.00", new BLCVariableExpression().getPrice("10UUUUSD"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression} (default constructor).
   *   <li>When {@code 10UUUUUU}.
   *   <li>Then return {@code USD10.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  public void testGetPrice_givenBLCVariableExpression_when10uuuuuu_thenReturnUsd1000() {
    // Arrange, Act and Assert
    assertEquals("USD10.00", new BLCVariableExpression().getPrice("10UUUUUU"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression} (default constructor).
   *   <li>When {@code 42[^\d.]+}.
   *   <li>Then return {@code USD42.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  public void testGetPrice_givenBLCVariableExpression_when42D_thenReturnUsd4200() {
    // Arrange, Act and Assert
    assertEquals("USD42.00", new BLCVariableExpression().getPrice("42[^\\d.]+"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression} (default constructor).
   *   <li>When {@code 42currency.default}.
   *   <li>Then return {@code USD42.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  public void testGetPrice_givenBLCVariableExpression_when42currencyDefault_thenReturnUsd4200() {
    // Arrange, Act and Assert
    assertEquals("USD42.00", new BLCVariableExpression().getPrice("42currency.default"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression} (default constructor).
   *   <li>When {@code 42USD}.
   *   <li>Then return {@code USD42.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  public void testGetPrice_givenBLCVariableExpression_when42usd_thenReturnUsd4200() {
    // Arrange, Act and Assert
    assertEquals("USD42.00", new BLCVariableExpression().getPrice("42USD"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression} (default constructor).
   *   <li>When {@code 42UUU}.
   *   <li>Then return {@code USD42.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  public void testGetPrice_givenBLCVariableExpression_when42uuu_thenReturnUsd4200() {
    // Arrange, Act and Assert
    assertEquals("USD42.00", new BLCVariableExpression().getPrice("42UUU"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression} (default constructor).
   *   <li>When {@code 1010[^\d.]+}.
   *   <li>Then return {@code USD1,010.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  public void testGetPrice_givenBLCVariableExpression_when1010D_thenReturnUsd101000() {
    // Arrange, Act and Assert
    assertEquals("USD1,010.00", new BLCVariableExpression().getPrice("1010[^\\d.]+"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression} (default constructor).
   *   <li>When {@code 1010USD}.
   *   <li>Then return {@code USD1,010.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  public void testGetPrice_givenBLCVariableExpression_when1010usd_thenReturnUsd101000() {
    // Arrange, Act and Assert
    assertEquals("USD1,010.00", new BLCVariableExpression().getPrice("1010USD"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression} (default constructor).
   *   <li>When {@code 1010UUU}.
   *   <li>Then return {@code USD1,010.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  public void testGetPrice_givenBLCVariableExpression_when1010uuu_thenReturnUsd101000() {
    // Arrange, Act and Assert
    assertEquals("USD1,010.00", new BLCVariableExpression().getPrice("1010UUU"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression} (default constructor).
   *   <li>When {@code 1042[^\d.]+}.
   *   <li>Then return {@code USD1,042.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  public void testGetPrice_givenBLCVariableExpression_when1042D_thenReturnUsd104200() {
    // Arrange, Act and Assert
    assertEquals("USD1,042.00", new BLCVariableExpression().getPrice("1042[^\\d.]+"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression} (default constructor).
   *   <li>When {@code 1042USD}.
   *   <li>Then return {@code USD1,042.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  public void testGetPrice_givenBLCVariableExpression_when1042usd_thenReturnUsd104200() {
    // Arrange, Act and Assert
    assertEquals("USD1,042.00", new BLCVariableExpression().getPrice("1042USD"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression} (default constructor).
   *   <li>When {@code 1042UUU}.
   *   <li>Then return {@code USD1,042.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  public void testGetPrice_givenBLCVariableExpression_when1042uuu_thenReturnUsd104200() {
    // Arrange, Act and Assert
    assertEquals("USD1,042.00", new BLCVariableExpression().getPrice("1042UUU"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression}.
   *   <li>When {@code Amount10[^\d.]+}.
   *   <li>Then return {@code USD10.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  public void testGetPrice_givenBLCVariableExpression_whenAmount10D_thenReturnUsd1000() {
    // Arrange, Act and Assert
    assertEquals("USD10.00", bLCVariableExpression.getPrice("Amount10[^\\d.]+"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression}.
   *   <li>When {@code Amount10USD}.
   *   <li>Then return {@code USD10.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  public void testGetPrice_givenBLCVariableExpression_whenAmount10USD_thenReturnUsd1000() {
    // Arrange, Act and Assert
    assertEquals("USD10.00", bLCVariableExpression.getPrice("Amount10USD"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression}.
   *   <li>When {@code Amount10UUU}.
   *   <li>Then return {@code USD10.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  public void testGetPrice_givenBLCVariableExpression_whenAmount10UUU_thenReturnUsd1000() {
    // Arrange, Act and Assert
    assertEquals("USD10.00", bLCVariableExpression.getPrice("Amount10UUU"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression} (default constructor).
   *   <li>When {@code AmountUSD}.
   *   <li>Then return {@code $ 0.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  public void testGetPrice_givenBLCVariableExpression_whenAmountUSD_thenReturn000() {
    // Arrange, Act and Assert
    assertEquals("$ 0.00", new BLCVariableExpression().getPrice("AmountUSD"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression} (default constructor).
   *   <li>When {@code AmountUUU}.
   *   <li>Then return {@code $ 0.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  public void testGetPrice_givenBLCVariableExpression_whenAmountUUU_thenReturn000() {
    // Arrange, Act and Assert
    assertEquals("$ 0.00", new BLCVariableExpression().getPrice("AmountUUU"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression} (default constructor).
   *   <li>When {@code Amount}.
   *   <li>Then return {@code $ 0.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  public void testGetPrice_givenBLCVariableExpression_whenAmount_thenReturn000() {
    // Arrange, Act and Assert
    assertEquals("$ 0.00", new BLCVariableExpression().getPrice("Amount"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression} (default constructor).
   *   <li>When {@code currency.default10}.
   *   <li>Then return {@code USD0.10}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  public void testGetPrice_givenBLCVariableExpression_whenCurrencyDefault10_thenReturnUsd010() {
    // Arrange, Act and Assert
    assertEquals("USD0.10", new BLCVariableExpression().getPrice("currency.default10"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression} (default constructor).
   *   <li>When {@code currency.default42}.
   *   <li>Then return {@code USD0.42}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  public void testGetPrice_givenBLCVariableExpression_whenCurrencyDefault42_thenReturnUsd042() {
    // Arrange, Act and Assert
    assertEquals("USD0.42", new BLCVariableExpression().getPrice("currency.default42"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression} (default constructor).
   *   <li>When {@code currency.default1010}.
   *   <li>Then return {@code USD0.10}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  public void testGetPrice_givenBLCVariableExpression_whenCurrencyDefault1010_thenReturnUsd010() {
    // Arrange, Act and Assert
    assertEquals("USD0.10", new BLCVariableExpression().getPrice("currency.default1010"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression} (default constructor).
   *   <li>When {@code currency.default1042}.
   *   <li>Then return {@code USD0.10}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  public void testGetPrice_givenBLCVariableExpression_whenCurrencyDefault1042_thenReturnUsd010() {
    // Arrange, Act and Assert
    assertEquals("USD0.10", new BLCVariableExpression().getPrice("currency.default1042"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression} (default constructor).
   *   <li>When {@code currency.default4210}.
   *   <li>Then return {@code USD0.42}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  public void testGetPrice_givenBLCVariableExpression_whenCurrencyDefault4210_thenReturnUsd042() {
    // Arrange, Act and Assert
    assertEquals("USD0.42", new BLCVariableExpression().getPrice("currency.default4210"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression} (default constructor).
   *   <li>When {@code currency.default4242}.
   *   <li>Then return {@code USD0.42}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  public void testGetPrice_givenBLCVariableExpression_whenCurrencyDefault4242_thenReturnUsd042() {
    // Arrange, Act and Assert
    assertEquals("USD0.42", new BLCVariableExpression().getPrice("currency.default4242"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression} (default constructor).
   *   <li>When {@code [^\d.]+10Amount}.
   *   <li>Then return {@code USD0.10}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  public void testGetPrice_givenBLCVariableExpression_whenD10Amount_thenReturnUsd010() {
    // Arrange, Act and Assert
    assertEquals("USD0.10", new BLCVariableExpression().getPrice("[^\\d.]+10Amount"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression} (default constructor).
   *   <li>When {@code [^\d.]+10}.
   *   <li>Then return {@code USD0.10}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  public void testGetPrice_givenBLCVariableExpression_whenD10_thenReturnUsd010() {
    // Arrange, Act and Assert
    assertEquals("USD0.10", new BLCVariableExpression().getPrice("[^\\d.]+10"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression} (default constructor).
   *   <li>When {@code [^\d.]+10USD}.
   *   <li>Then return {@code USD0.10}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  public void testGetPrice_givenBLCVariableExpression_whenD10usd_thenReturnUsd010() {
    // Arrange, Act and Assert
    assertEquals("USD0.10", new BLCVariableExpression().getPrice("[^\\d.]+10USD"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression} (default constructor).
   *   <li>When {@code [^\d.]+10UUU}.
   *   <li>Then return {@code USD0.10}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  public void testGetPrice_givenBLCVariableExpression_whenD10uuu_thenReturnUsd010() {
    // Arrange, Act and Assert
    assertEquals("USD0.10", new BLCVariableExpression().getPrice("[^\\d.]+10UUU"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression} (default constructor).
   *   <li>When {@code [^\d.]+42Amount}.
   *   <li>Then return {@code USD0.42}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  public void testGetPrice_givenBLCVariableExpression_whenD42Amount_thenReturnUsd042() {
    // Arrange, Act and Assert
    assertEquals("USD0.42", new BLCVariableExpression().getPrice("[^\\d.]+42Amount"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression} (default constructor).
   *   <li>When {@code [^\d.]+42}.
   *   <li>Then return {@code USD0.42}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  public void testGetPrice_givenBLCVariableExpression_whenD42_thenReturnUsd042() {
    // Arrange, Act and Assert
    assertEquals("USD0.42", new BLCVariableExpression().getPrice("[^\\d.]+42"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression} (default constructor).
   *   <li>When {@code [^\d.]+42USD}.
   *   <li>Then return {@code USD0.42}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  public void testGetPrice_givenBLCVariableExpression_whenD42usd_thenReturnUsd042() {
    // Arrange, Act and Assert
    assertEquals("USD0.42", new BLCVariableExpression().getPrice("[^\\d.]+42USD"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression} (default constructor).
   *   <li>When {@code [^\d.]+42UUU}.
   *   <li>Then return {@code USD0.42}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  public void testGetPrice_givenBLCVariableExpression_whenD42uuu_thenReturnUsd042() {
    // Arrange, Act and Assert
    assertEquals("USD0.42", new BLCVariableExpression().getPrice("[^\\d.]+42UUU"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression} (default constructor).
   *   <li>When {@code [^\d.]+1010}.
   *   <li>Then return {@code USD0.10}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  public void testGetPrice_givenBLCVariableExpression_whenD1010_thenReturnUsd010() {
    // Arrange, Act and Assert
    assertEquals("USD0.10", new BLCVariableExpression().getPrice("[^\\d.]+1010"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression} (default constructor).
   *   <li>When {@code [^\d.]+1042}.
   *   <li>Then return {@code USD0.10}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  public void testGetPrice_givenBLCVariableExpression_whenD1042_thenReturnUsd010() {
    // Arrange, Act and Assert
    assertEquals("USD0.10", new BLCVariableExpression().getPrice("[^\\d.]+1042"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression} (default constructor).
   *   <li>When {@code [^\d.]+4210}.
   *   <li>Then return {@code USD0.42}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  public void testGetPrice_givenBLCVariableExpression_whenD4210_thenReturnUsd042() {
    // Arrange, Act and Assert
    assertEquals("USD0.42", new BLCVariableExpression().getPrice("[^\\d.]+4210"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression} (default constructor).
   *   <li>When {@code [^\d.]+4242}.
   *   <li>Then return {@code USD0.42}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  public void testGetPrice_givenBLCVariableExpression_whenD4242_thenReturnUsd042() {
    // Arrange, Act and Assert
    assertEquals("USD0.42", new BLCVariableExpression().getPrice("[^\\d.]+4242"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression} (default constructor).
   *   <li>When {@code [^\d.]+Amount10}.
   *   <li>Then return {@code USD0.10}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  public void testGetPrice_givenBLCVariableExpression_whenDAmount10_thenReturnUsd010() {
    // Arrange, Act and Assert
    assertEquals("USD0.10", new BLCVariableExpression().getPrice("[^\\d.]+Amount10"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression} (default constructor).
   *   <li>When {@code [^\d.]+Amount42}.
   *   <li>Then return {@code USD0.42}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  public void testGetPrice_givenBLCVariableExpression_whenDAmount42_thenReturnUsd042() {
    // Arrange, Act and Assert
    assertEquals("USD0.42", new BLCVariableExpression().getPrice("[^\\d.]+Amount42"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression} (default constructor).
   *   <li>When {@code [^\d.]+USD10}.
   *   <li>Then return {@code USD0.10}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  public void testGetPrice_givenBLCVariableExpression_whenDUsd10_thenReturnUsd010() {
    // Arrange, Act and Assert
    assertEquals("USD0.10", new BLCVariableExpression().getPrice("[^\\d.]+USD10"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression} (default constructor).
   *   <li>When {@code [^\d.]+USD42}.
   *   <li>Then return {@code USD0.42}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  public void testGetPrice_givenBLCVariableExpression_whenDUsd42_thenReturnUsd042() {
    // Arrange, Act and Assert
    assertEquals("USD0.42", new BLCVariableExpression().getPrice("[^\\d.]+USD42"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression} (default constructor).
   *   <li>When {@code [^\d.]+UUU10}.
   *   <li>Then return {@code USD0.10}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  public void testGetPrice_givenBLCVariableExpression_whenDUuu10_thenReturnUsd010() {
    // Arrange, Act and Assert
    assertEquals("USD0.10", new BLCVariableExpression().getPrice("[^\\d.]+UUU10"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression} (default constructor).
   *   <li>When {@code [^\d.]+UUU42}.
   *   <li>Then return {@code USD0.42}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  public void testGetPrice_givenBLCVariableExpression_whenDUuu42_thenReturnUsd042() {
    // Arrange, Act and Assert
    assertEquals("USD0.42", new BLCVariableExpression().getPrice("[^\\d.]+UUU42"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression} (default constructor).
   *   <li>When {@code USD10Amount}.
   *   <li>Then return {@code USD10.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  public void testGetPrice_givenBLCVariableExpression_whenUSD10Amount_thenReturnUsd1000() {
    // Arrange, Act and Assert
    assertEquals("USD10.00", new BLCVariableExpression().getPrice("USD10Amount"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression}.
   *   <li>When {@code USD42Amount}.
   *   <li>Then return {@code USD42.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  public void testGetPrice_givenBLCVariableExpression_whenUSD42Amount_thenReturnUsd4200() {
    // Arrange, Act and Assert
    assertEquals("USD42.00", bLCVariableExpression.getPrice("USD42Amount"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression}.
   *   <li>When {@code USDAmount10}.
   *   <li>Then return {@code USD10.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  public void testGetPrice_givenBLCVariableExpression_whenUSDAmount10_thenReturnUsd1000() {
    // Arrange, Act and Assert
    assertEquals("USD10.00", bLCVariableExpression.getPrice("USDAmount10"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression}.
   *   <li>When {@code USDAmount42}.
   *   <li>Then return {@code USD42.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  public void testGetPrice_givenBLCVariableExpression_whenUSDAmount42_thenReturnUsd4200() {
    // Arrange, Act and Assert
    assertEquals("USD42.00", bLCVariableExpression.getPrice("USDAmount42"));
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  public void testGetPrice_givenBLCVariableExpression_whenUSDAmountAmount_thenReturn000() {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  public void testGetPrice_givenBLCVariableExpression_whenUSDAmountUSD_thenReturn000() {
    // Arrange, Act and Assert
    assertEquals("$ 0.00", bLCVariableExpression.getPrice("USDAmountUSD"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression}.
   *   <li>When {@code USDAmountUUU}.
   *   <li>Then return {@code $ 0.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  public void testGetPrice_givenBLCVariableExpression_whenUSDAmountUUU_thenReturn000() {
    // Arrange, Act and Assert
    assertEquals("$ 0.00", bLCVariableExpression.getPrice("USDAmountUUU"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression} (default constructor).
   *   <li>When {@code USDAmount}.
   *   <li>Then return {@code $ 0.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  public void testGetPrice_givenBLCVariableExpression_whenUSDAmount_thenReturn000() {
    // Arrange, Act and Assert
    assertEquals("$ 0.00", new BLCVariableExpression().getPrice("USDAmount"));
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  public void testGetPrice_givenBLCVariableExpression_whenUSDUSDAmount_thenReturn000() {
    // Arrange, Act and Assert
    assertEquals("$ 0.00", bLCVariableExpression.getPrice("USDUSDAmount"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression} (default constructor).
   *   <li>When {@code USDUUUAmount}.
   *   <li>Then return {@code $ 0.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  public void testGetPrice_givenBLCVariableExpression_whenUSDUUUAmount_thenReturn000() {
    // Arrange, Act and Assert
    assertEquals("$ 0.00", new BLCVariableExpression().getPrice("USDUUUAmount"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression} (default constructor).
   *   <li>When {@code UUU10Amount}.
   *   <li>Then return {@code USD10.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  public void testGetPrice_givenBLCVariableExpression_whenUUU10Amount_thenReturnUsd1000() {
    // Arrange, Act and Assert
    assertEquals("USD10.00", new BLCVariableExpression().getPrice("UUU10Amount"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression} (default constructor).
   *   <li>When {@code UUU42Amount}.
   *   <li>Then return {@code USD42.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  public void testGetPrice_givenBLCVariableExpression_whenUUU42Amount_thenReturnUsd4200() {
    // Arrange, Act and Assert
    assertEquals("USD42.00", new BLCVariableExpression().getPrice("UUU42Amount"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression} (default constructor).
   *   <li>When {@code UUUAmount10}.
   *   <li>Then return {@code USD10.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  public void testGetPrice_givenBLCVariableExpression_whenUUUAmount10_thenReturnUsd1000() {
    // Arrange, Act and Assert
    assertEquals("USD10.00", new BLCVariableExpression().getPrice("UUUAmount10"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression} (default constructor).
   *   <li>When {@code UUUAmount42}.
   *   <li>Then return {@code USD42.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  public void testGetPrice_givenBLCVariableExpression_whenUUUAmount42_thenReturnUsd4200() {
    // Arrange, Act and Assert
    assertEquals("USD42.00", new BLCVariableExpression().getPrice("UUUAmount42"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression} (default constructor).
   *   <li>When {@code UUUAmountAmount}.
   *   <li>Then return {@code $ 0.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  public void testGetPrice_givenBLCVariableExpression_whenUUUAmountAmount_thenReturn000() {
    // Arrange, Act and Assert
    assertEquals("$ 0.00", new BLCVariableExpression().getPrice("UUUAmountAmount"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression} (default constructor).
   *   <li>When {@code UUUAmountUSD}.
   *   <li>Then return {@code $ 0.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  public void testGetPrice_givenBLCVariableExpression_whenUUUAmountUSD_thenReturn000() {
    // Arrange, Act and Assert
    assertEquals("$ 0.00", new BLCVariableExpression().getPrice("UUUAmountUSD"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression} (default constructor).
   *   <li>When {@code UUUAmountUUU}.
   *   <li>Then return {@code $ 0.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  public void testGetPrice_givenBLCVariableExpression_whenUUUAmountUUU_thenReturn000() {
    // Arrange, Act and Assert
    assertEquals("$ 0.00", new BLCVariableExpression().getPrice("UUUAmountUUU"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression} (default constructor).
   *   <li>When {@code UUUAmount}.
   *   <li>Then return {@code $ 0.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  public void testGetPrice_givenBLCVariableExpression_whenUUUAmount_thenReturn000() {
    // Arrange, Act and Assert
    assertEquals("$ 0.00", new BLCVariableExpression().getPrice("UUUAmount"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression} (default constructor).
   *   <li>When {@code UUUUSDAmount}.
   *   <li>Then return {@code $ 0.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  public void testGetPrice_givenBLCVariableExpression_whenUUUUSDAmount_thenReturn000() {
    // Arrange, Act and Assert
    assertEquals("$ 0.00", new BLCVariableExpression().getPrice("UUUUSDAmount"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression} (default constructor).
   *   <li>When {@code UUUUUUAmount}.
   *   <li>Then return {@code $ 0.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  public void testGetPrice_givenBLCVariableExpression_whenUUUUUUAmount_thenReturn000() {
    // Arrange, Act and Assert
    assertEquals("$ 0.00", new BLCVariableExpression().getPrice("UUUUUUAmount"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression} (default constructor).
   *   <li>When {@code USD10[^\d.]+}.
   *   <li>Then return {@code USD10.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  public void testGetPrice_givenBLCVariableExpression_whenUsd10D_thenReturnUsd1000() {
    // Arrange, Act and Assert
    assertEquals("USD10.00", new BLCVariableExpression().getPrice("USD10[^\\d.]+"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression} (default constructor).
   *   <li>When {@code USD10}.
   *   <li>Then return {@code USD10.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  public void testGetPrice_givenBLCVariableExpression_whenUsd10_thenReturnUsd1000() {
    // Arrange, Act and Assert
    assertEquals("USD10.00", new BLCVariableExpression().getPrice("USD10"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression} (default constructor).
   *   <li>When {@code USD10USD}.
   *   <li>Then return {@code USD10.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  public void testGetPrice_givenBLCVariableExpression_whenUsd10usd_thenReturnUsd1000() {
    // Arrange, Act and Assert
    assertEquals("USD10.00", new BLCVariableExpression().getPrice("USD10USD"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression} (default constructor).
   *   <li>When {@code USD10UUU}.
   *   <li>Then return {@code USD10.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  public void testGetPrice_givenBLCVariableExpression_whenUsd10uuu_thenReturnUsd1000() {
    // Arrange, Act and Assert
    assertEquals("USD10.00", new BLCVariableExpression().getPrice("USD10UUU"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression}.
   *   <li>When {@code USD42[^\d.]+}.
   *   <li>Then return {@code USD42.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  public void testGetPrice_givenBLCVariableExpression_whenUsd42D_thenReturnUsd4200() {
    // Arrange, Act and Assert
    assertEquals("USD42.00", bLCVariableExpression.getPrice("USD42[^\\d.]+"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression} (default constructor).
   *   <li>When {@code USD42}.
   *   <li>Then return {@code USD42.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  public void testGetPrice_givenBLCVariableExpression_whenUsd42_thenReturnUsd4200() {
    // Arrange, Act and Assert
    assertEquals("USD42.00", new BLCVariableExpression().getPrice("USD42"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression}.
   *   <li>When {@code USD42USD}.
   *   <li>Then return {@code USD42.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  public void testGetPrice_givenBLCVariableExpression_whenUsd42usd_thenReturnUsd4200() {
    // Arrange, Act and Assert
    assertEquals("USD42.00", bLCVariableExpression.getPrice("USD42USD"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression}.
   *   <li>When {@code USD42UUU}.
   *   <li>Then return {@code USD42.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  public void testGetPrice_givenBLCVariableExpression_whenUsd42uuu_thenReturnUsd4200() {
    // Arrange, Act and Assert
    assertEquals("USD42.00", bLCVariableExpression.getPrice("USD42UUU"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression} (default constructor).
   *   <li>When {@code USD1010}.
   *   <li>Then return {@code USD1,010.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  public void testGetPrice_givenBLCVariableExpression_whenUsd1010_thenReturnUsd101000() {
    // Arrange, Act and Assert
    assertEquals("USD1,010.00", new BLCVariableExpression().getPrice("USD1010"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression} (default constructor).
   *   <li>When {@code USD1042}.
   *   <li>Then return {@code USD1,042.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  public void testGetPrice_givenBLCVariableExpression_whenUsd1042_thenReturnUsd104200() {
    // Arrange, Act and Assert
    assertEquals("USD1,042.00", new BLCVariableExpression().getPrice("USD1042"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression}.
   *   <li>When {@code USD4210}.
   *   <li>Then return {@code USD4,210.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  public void testGetPrice_givenBLCVariableExpression_whenUsd4210_thenReturnUsd421000() {
    // Arrange, Act and Assert
    assertEquals("USD4,210.00", bLCVariableExpression.getPrice("USD4210"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression}.
   *   <li>When {@code USD4242}.
   *   <li>Then return {@code USD4,242.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  public void testGetPrice_givenBLCVariableExpression_whenUsd4242_thenReturnUsd424200() {
    // Arrange, Act and Assert
    assertEquals("USD4,242.00", bLCVariableExpression.getPrice("USD4242"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression} (default constructor).
   *   <li>When {@code USD[^\d.]+10}.
   *   <li>Then return {@code USD0.10}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  public void testGetPrice_givenBLCVariableExpression_whenUsdD10_thenReturnUsd010() {
    // Arrange, Act and Assert
    assertEquals("USD0.10", new BLCVariableExpression().getPrice("USD[^\\d.]+10"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression}.
   *   <li>When {@code USD[^\d.]+42}.
   *   <li>Then return {@code USD0.42}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  public void testGetPrice_givenBLCVariableExpression_whenUsdD42_thenReturnUsd042() {
    // Arrange, Act and Assert
    assertEquals("USD0.42", bLCVariableExpression.getPrice("USD[^\\d.]+42"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression} (default constructor).
   *   <li>When {@code USD}.
   *   <li>Then return {@code $ 0.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  public void testGetPrice_givenBLCVariableExpression_whenUsd_thenReturn000() {
    // Arrange, Act and Assert
    assertEquals("$ 0.00", new BLCVariableExpression().getPrice("USD"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression}.
   *   <li>When {@code USDUSD10}.
   *   <li>Then return {@code USD10.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  public void testGetPrice_givenBLCVariableExpression_whenUsdusd10_thenReturnUsd1000() {
    // Arrange, Act and Assert
    assertEquals("USD10.00", bLCVariableExpression.getPrice("USDUSD10"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression}.
   *   <li>When {@code USDUSD42}.
   *   <li>Then return {@code USD42.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  public void testGetPrice_givenBLCVariableExpression_whenUsdusd42_thenReturnUsd4200() {
    // Arrange, Act and Assert
    assertEquals("USD42.00", bLCVariableExpression.getPrice("USDUSD42"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression} (default constructor).
   *   <li>When {@code USDUSD}.
   *   <li>Then return {@code $ 0.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  public void testGetPrice_givenBLCVariableExpression_whenUsdusd_thenReturn000() {
    // Arrange, Act and Assert
    assertEquals("$ 0.00", new BLCVariableExpression().getPrice("USDUSD"));
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  public void testGetPrice_givenBLCVariableExpression_whenUsdusdusd_thenReturn000() {
    // Arrange, Act and Assert
    assertEquals("$ 0.00", bLCVariableExpression.getPrice("USDUSDUSD"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression}.
   *   <li>When {@code USDUSDUUU}.
   *   <li>Then return {@code $ 0.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  public void testGetPrice_givenBLCVariableExpression_whenUsdusduuu_thenReturn000() {
    // Arrange, Act and Assert
    assertEquals("$ 0.00", bLCVariableExpression.getPrice("USDUSDUUU"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression} (default constructor).
   *   <li>When {@code USDUUU10}.
   *   <li>Then return {@code USD10.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  public void testGetPrice_givenBLCVariableExpression_whenUsduuu10_thenReturnUsd1000() {
    // Arrange, Act and Assert
    assertEquals("USD10.00", new BLCVariableExpression().getPrice("USDUUU10"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression} (default constructor).
   *   <li>When {@code USDUUU42}.
   *   <li>Then return {@code USD42.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  public void testGetPrice_givenBLCVariableExpression_whenUsduuu42_thenReturnUsd4200() {
    // Arrange, Act and Assert
    assertEquals("USD42.00", new BLCVariableExpression().getPrice("USDUUU42"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression} (default constructor).
   *   <li>When {@code USDUUU}.
   *   <li>Then return {@code $ 0.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  public void testGetPrice_givenBLCVariableExpression_whenUsduuu_thenReturn000() {
    // Arrange, Act and Assert
    assertEquals("$ 0.00", new BLCVariableExpression().getPrice("USDUUU"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression} (default constructor).
   *   <li>When {@code USDUUUUSD}.
   *   <li>Then return {@code $ 0.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  public void testGetPrice_givenBLCVariableExpression_whenUsduuuusd_thenReturn000() {
    // Arrange, Act and Assert
    assertEquals("$ 0.00", new BLCVariableExpression().getPrice("USDUUUUSD"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression} (default constructor).
   *   <li>When {@code USDUUUUUU}.
   *   <li>Then return {@code $ 0.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  public void testGetPrice_givenBLCVariableExpression_whenUsduuuuuu_thenReturn000() {
    // Arrange, Act and Assert
    assertEquals("$ 0.00", new BLCVariableExpression().getPrice("USDUUUUUU"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression} (default constructor).
   *   <li>When {@code UUU10[^\d.]+}.
   *   <li>Then return {@code USD10.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  public void testGetPrice_givenBLCVariableExpression_whenUuu10D_thenReturnUsd1000() {
    // Arrange, Act and Assert
    assertEquals("USD10.00", new BLCVariableExpression().getPrice("UUU10[^\\d.]+"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression} (default constructor).
   *   <li>When {@code UUU10}.
   *   <li>Then return {@code USD10.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  public void testGetPrice_givenBLCVariableExpression_whenUuu10_thenReturnUsd1000() {
    // Arrange, Act and Assert
    assertEquals("USD10.00", new BLCVariableExpression().getPrice("UUU10"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression} (default constructor).
   *   <li>When {@code UUU10USD}.
   *   <li>Then return {@code USD10.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  public void testGetPrice_givenBLCVariableExpression_whenUuu10usd_thenReturnUsd1000() {
    // Arrange, Act and Assert
    assertEquals("USD10.00", new BLCVariableExpression().getPrice("UUU10USD"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression} (default constructor).
   *   <li>When {@code UUU10UUU}.
   *   <li>Then return {@code USD10.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  public void testGetPrice_givenBLCVariableExpression_whenUuu10uuu_thenReturnUsd1000() {
    // Arrange, Act and Assert
    assertEquals("USD10.00", new BLCVariableExpression().getPrice("UUU10UUU"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression} (default constructor).
   *   <li>When {@code UUU42[^\d.]+}.
   *   <li>Then return {@code USD42.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  public void testGetPrice_givenBLCVariableExpression_whenUuu42D_thenReturnUsd4200() {
    // Arrange, Act and Assert
    assertEquals("USD42.00", new BLCVariableExpression().getPrice("UUU42[^\\d.]+"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression} (default constructor).
   *   <li>When {@code UUU42}.
   *   <li>Then return {@code USD42.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  public void testGetPrice_givenBLCVariableExpression_whenUuu42_thenReturnUsd4200() {
    // Arrange, Act and Assert
    assertEquals("USD42.00", new BLCVariableExpression().getPrice("UUU42"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression} (default constructor).
   *   <li>When {@code UUU42USD}.
   *   <li>Then return {@code USD42.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  public void testGetPrice_givenBLCVariableExpression_whenUuu42usd_thenReturnUsd4200() {
    // Arrange, Act and Assert
    assertEquals("USD42.00", new BLCVariableExpression().getPrice("UUU42USD"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression} (default constructor).
   *   <li>When {@code UUU42UUU}.
   *   <li>Then return {@code USD42.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  public void testGetPrice_givenBLCVariableExpression_whenUuu42uuu_thenReturnUsd4200() {
    // Arrange, Act and Assert
    assertEquals("USD42.00", new BLCVariableExpression().getPrice("UUU42UUU"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression} (default constructor).
   *   <li>When {@code UUU1010}.
   *   <li>Then return {@code USD1,010.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  public void testGetPrice_givenBLCVariableExpression_whenUuu1010_thenReturnUsd101000() {
    // Arrange, Act and Assert
    assertEquals("USD1,010.00", new BLCVariableExpression().getPrice("UUU1010"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression} (default constructor).
   *   <li>When {@code UUU1042}.
   *   <li>Then return {@code USD1,042.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  public void testGetPrice_givenBLCVariableExpression_whenUuu1042_thenReturnUsd104200() {
    // Arrange, Act and Assert
    assertEquals("USD1,042.00", new BLCVariableExpression().getPrice("UUU1042"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression} (default constructor).
   *   <li>When {@code UUU4210}.
   *   <li>Then return {@code USD4,210.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  public void testGetPrice_givenBLCVariableExpression_whenUuu4210_thenReturnUsd421000() {
    // Arrange, Act and Assert
    assertEquals("USD4,210.00", new BLCVariableExpression().getPrice("UUU4210"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression} (default constructor).
   *   <li>When {@code UUU4242}.
   *   <li>Then return {@code USD4,242.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  public void testGetPrice_givenBLCVariableExpression_whenUuu4242_thenReturnUsd424200() {
    // Arrange, Act and Assert
    assertEquals("USD4,242.00", new BLCVariableExpression().getPrice("UUU4242"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression} (default constructor).
   *   <li>When {@code UUU[^\d.]+10}.
   *   <li>Then return {@code USD0.10}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  public void testGetPrice_givenBLCVariableExpression_whenUuuD10_thenReturnUsd010() {
    // Arrange, Act and Assert
    assertEquals("USD0.10", new BLCVariableExpression().getPrice("UUU[^\\d.]+10"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression} (default constructor).
   *   <li>When {@code UUU[^\d.]+42}.
   *   <li>Then return {@code USD0.42}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  public void testGetPrice_givenBLCVariableExpression_whenUuuD42_thenReturnUsd042() {
    // Arrange, Act and Assert
    assertEquals("USD0.42", new BLCVariableExpression().getPrice("UUU[^\\d.]+42"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression} (default constructor).
   *   <li>When {@code UUU}.
   *   <li>Then return {@code $ 0.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  public void testGetPrice_givenBLCVariableExpression_whenUuu_thenReturn000() {
    // Arrange, Act and Assert
    assertEquals("$ 0.00", new BLCVariableExpression().getPrice("UUU"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression} (default constructor).
   *   <li>When {@code UUUUSD10}.
   *   <li>Then return {@code USD10.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  public void testGetPrice_givenBLCVariableExpression_whenUuuusd10_thenReturnUsd1000() {
    // Arrange, Act and Assert
    assertEquals("USD10.00", new BLCVariableExpression().getPrice("UUUUSD10"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression} (default constructor).
   *   <li>When {@code UUUUSD42}.
   *   <li>Then return {@code USD42.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  public void testGetPrice_givenBLCVariableExpression_whenUuuusd42_thenReturnUsd4200() {
    // Arrange, Act and Assert
    assertEquals("USD42.00", new BLCVariableExpression().getPrice("UUUUSD42"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression} (default constructor).
   *   <li>When {@code UUUUSD}.
   *   <li>Then return {@code $ 0.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  public void testGetPrice_givenBLCVariableExpression_whenUuuusd_thenReturn000() {
    // Arrange, Act and Assert
    assertEquals("$ 0.00", new BLCVariableExpression().getPrice("UUUUSD"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression} (default constructor).
   *   <li>When {@code UUUUSDUSD}.
   *   <li>Then return {@code $ 0.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  public void testGetPrice_givenBLCVariableExpression_whenUuuusdusd_thenReturn000() {
    // Arrange, Act and Assert
    assertEquals("$ 0.00", new BLCVariableExpression().getPrice("UUUUSDUSD"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression} (default constructor).
   *   <li>When {@code UUUUSDUUU}.
   *   <li>Then return {@code $ 0.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  public void testGetPrice_givenBLCVariableExpression_whenUuuusduuu_thenReturn000() {
    // Arrange, Act and Assert
    assertEquals("$ 0.00", new BLCVariableExpression().getPrice("UUUUSDUUU"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression} (default constructor).
   *   <li>When {@code UUUUUU10}.
   *   <li>Then return {@code USD10.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  public void testGetPrice_givenBLCVariableExpression_whenUuuuuu10_thenReturnUsd1000() {
    // Arrange, Act and Assert
    assertEquals("USD10.00", new BLCVariableExpression().getPrice("UUUUUU10"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression} (default constructor).
   *   <li>When {@code UUUUUU42}.
   *   <li>Then return {@code USD42.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  public void testGetPrice_givenBLCVariableExpression_whenUuuuuu42_thenReturnUsd4200() {
    // Arrange, Act and Assert
    assertEquals("USD42.00", new BLCVariableExpression().getPrice("UUUUUU42"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression} (default constructor).
   *   <li>When {@code UUUUUU}.
   *   <li>Then return {@code $ 0.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  public void testGetPrice_givenBLCVariableExpression_whenUuuuuu_thenReturn000() {
    // Arrange, Act and Assert
    assertEquals("$ 0.00", new BLCVariableExpression().getPrice("UUUUUU"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression} (default constructor).
   *   <li>When {@code UUUUUUUSD}.
   *   <li>Then return {@code $ 0.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  public void testGetPrice_givenBLCVariableExpression_whenUuuuuuusd_thenReturn000() {
    // Arrange, Act and Assert
    assertEquals("$ 0.00", new BLCVariableExpression().getPrice("UUUUUUUSD"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link BLCVariableExpression} (default constructor).
   *   <li>When {@code UUUUUUUUU}.
   *   <li>Then return {@code $ 0.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  public void testGetPrice_givenBLCVariableExpression_whenUuuuuuuuu_thenReturn000() {
    // Arrange, Act and Assert
    assertEquals("$ 0.00", new BLCVariableExpression().getPrice("UUUUUUUUU"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link PromotionMessageVariableExpression} (default constructor).
   *   <li>When {@code 10AmountAmount}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  public void testGetPrice_givenPromotionMessageVariableExpression_when10AmountAmount() {
    // Arrange, Act and Assert
    assertEquals("USD10.00", new PromotionMessageVariableExpression().getPrice("10AmountAmount"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link PromotionMessageVariableExpression} (default constructor).
   *   <li>When {@code 42Amount}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  public void testGetPrice_givenPromotionMessageVariableExpression_when42Amount() {
    // Arrange, Act and Assert
    assertEquals("USD42.00", new PromotionMessageVariableExpression().getPrice("42Amount"));
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  public void testGetPrice_givenPromotionMessageVariableExpression_when42AmountAmount() {
    // Arrange, Act and Assert
    assertEquals("USD42.00", new PromotionMessageVariableExpression().getPrice("42AmountAmount"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link PromotionMessageVariableExpression} (default constructor).
   *   <li>When {@code Amount10}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  public void testGetPrice_givenPromotionMessageVariableExpression_whenAmount10() {
    // Arrange, Act and Assert
    assertEquals("USD10.00", new PromotionMessageVariableExpression().getPrice("Amount10"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link PromotionMessageVariableExpression} (default constructor).
   *   <li>When {@code Amount10Amount}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  public void testGetPrice_givenPromotionMessageVariableExpression_whenAmount10Amount() {
    // Arrange, Act and Assert
    assertEquals("USD10.00", new PromotionMessageVariableExpression().getPrice("Amount10Amount"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link PromotionMessageVariableExpression} (default constructor).
   *   <li>When {@code Amount42}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  public void testGetPrice_givenPromotionMessageVariableExpression_whenAmount42() {
    // Arrange, Act and Assert
    assertEquals("USD42.00", new PromotionMessageVariableExpression().getPrice("Amount42"));
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  public void testGetPrice_givenPromotionMessageVariableExpression_whenAmount42Amount() {
    // Arrange, Act and Assert
    assertEquals("USD42.00", new PromotionMessageVariableExpression().getPrice("Amount42Amount"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>Given {@link PromotionMessageVariableExpression} (default constructor).
   *   <li>When {@code AmountAmount}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  public void testGetPrice_givenPromotionMessageVariableExpression_whenAmountAmount() {
    // Arrange, Act and Assert
    assertEquals("$ 0.00", new PromotionMessageVariableExpression().getPrice("AmountAmount"));
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  public void testGetPrice_givenPromotionMessageVariableExpression_whenAmountAmount10() {
    // Arrange, Act and Assert
    assertEquals("USD10.00", new PromotionMessageVariableExpression().getPrice("AmountAmount10"));
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  public void testGetPrice_givenPromotionMessageVariableExpression_whenAmountAmount42() {
    // Arrange, Act and Assert
    assertEquals("USD42.00", new PromotionMessageVariableExpression().getPrice("AmountAmount42"));
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  public void testGetPrice_givenPromotionMessageVariableExpression_whenAmountAmountAmount() {
    // Arrange, Act and Assert
    assertEquals("$ 0.00", new PromotionMessageVariableExpression().getPrice("AmountAmountAmount"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>When {@code 10Amount10}.
   *   <li>Then return {@code USD1,010.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  public void testGetPrice_when10Amount10_thenReturnUsd101000() {
    // Arrange, Act and Assert
    assertEquals("USD1,010.00", new PromotionMessageVariableExpression().getPrice("10Amount10"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>When {@code 10Amount42}.
   *   <li>Then return {@code USD1,042.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  public void testGetPrice_when10Amount42_thenReturnUsd104200() {
    // Arrange, Act and Assert
    assertEquals("USD1,042.00", new PromotionMessageVariableExpression().getPrice("10Amount42"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>When {@code 10Amountcurrency.default}.
   *   <li>Then return {@code USD10.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  public void testGetPrice_when10AmountcurrencyDefault_thenReturnUsd1000() {
    // Arrange, Act and Assert
    assertEquals("USD10.00", new BLCVariableExpression().getPrice("10Amountcurrency.default"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>When {@code 10USDcurrency.default}.
   *   <li>Then return {@code USD10.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  public void testGetPrice_when10USDcurrencyDefault_thenReturnUsd1000() {
    // Arrange, Act and Assert
    assertEquals("USD10.00", new BLCVariableExpression().getPrice("10USDcurrency.default"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>When {@code 10UUUcurrency.default}.
   *   <li>Then return {@code USD10.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  public void testGetPrice_when10UUUcurrencyDefault_thenReturnUsd1000() {
    // Arrange, Act and Assert
    assertEquals("USD10.00", new BLCVariableExpression().getPrice("10UUUcurrency.default"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>When {@code 10currency.default10}.
   *   <li>Then return {@code USD10.10}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  public void testGetPrice_when10currencyDefault10_thenReturnUsd1010() {
    // Arrange, Act and Assert
    assertEquals("USD10.10", new BLCVariableExpression().getPrice("10currency.default10"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>When {@code 10currency.default42}.
   *   <li>Then return {@code USD10.42}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  public void testGetPrice_when10currencyDefault42_thenReturnUsd1042() {
    // Arrange, Act and Assert
    assertEquals("USD10.42", new BLCVariableExpression().getPrice("10currency.default42"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>When {@code 10currency.defaultAmount}.
   *   <li>Then return {@code USD10.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  public void testGetPrice_when10currencyDefaultAmount_thenReturnUsd1000() {
    // Arrange, Act and Assert
    assertEquals("USD10.00", new BLCVariableExpression().getPrice("10currency.defaultAmount"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>When {@code 10currency.defaultUSD}.
   *   <li>Then return {@code USD10.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  public void testGetPrice_when10currencyDefaultUSD_thenReturnUsd1000() {
    // Arrange, Act and Assert
    assertEquals("USD10.00", new BLCVariableExpression().getPrice("10currency.defaultUSD"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>When {@code 10currency.defaultUUU}.
   *   <li>Then return {@code USD10.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  public void testGetPrice_when10currencyDefaultUUU_thenReturnUsd1000() {
    // Arrange, Act and Assert
    assertEquals("USD10.00", new BLCVariableExpression().getPrice("10currency.defaultUUU"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>When {@code 42Amount10}.
   *   <li>Then return {@code USD4,210.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  public void testGetPrice_when42Amount10_thenReturnUsd421000() {
    // Arrange, Act and Assert
    assertEquals("USD4,210.00", new PromotionMessageVariableExpression().getPrice("42Amount10"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>When {@code 42Amount42}.
   *   <li>Then return {@code USD4,242.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  public void testGetPrice_when42Amount42_thenReturnUsd424200() {
    // Arrange, Act and Assert
    assertEquals("USD4,242.00", new PromotionMessageVariableExpression().getPrice("42Amount42"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>When {@code 1010Amount}.
   *   <li>Then return {@code USD1,010.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  public void testGetPrice_when1010Amount_thenReturnUsd101000() {
    // Arrange, Act and Assert
    assertEquals("USD1,010.00", new PromotionMessageVariableExpression().getPrice("1010Amount"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>When {@code 1010currency.default}.
   *   <li>Then return {@code USD1,010.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  public void testGetPrice_when1010currencyDefault_thenReturnUsd101000() {
    // Arrange, Act and Assert
    assertEquals("USD1,010.00", new BLCVariableExpression().getPrice("1010currency.default"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>When {@code 1042Amount}.
   *   <li>Then return {@code USD1,042.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  public void testGetPrice_when1042Amount_thenReturnUsd104200() {
    // Arrange, Act and Assert
    assertEquals("USD1,042.00", new PromotionMessageVariableExpression().getPrice("1042Amount"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>When {@code 1042currency.default}.
   *   <li>Then return {@code USD1,042.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  public void testGetPrice_when1042currencyDefault_thenReturnUsd104200() {
    // Arrange, Act and Assert
    assertEquals("USD1,042.00", new BLCVariableExpression().getPrice("1042currency.default"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>When {@code 4210Amount}.
   *   <li>Then return {@code USD4,210.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  public void testGetPrice_when4210Amount_thenReturnUsd421000() {
    // Arrange, Act and Assert
    assertEquals("USD4,210.00", new PromotionMessageVariableExpression().getPrice("4210Amount"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>When {@code 4242Amount}.
   *   <li>Then return {@code USD4,242.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  public void testGetPrice_when4242Amount_thenReturnUsd424200() {
    // Arrange, Act and Assert
    assertEquals("USD4,242.00", new PromotionMessageVariableExpression().getPrice("4242Amount"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>When {@code Amount10currency.default}.
   *   <li>Then return {@code USD10.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  public void testGetPrice_whenAmount10currencyDefault_thenReturnUsd1000() {
    // Arrange, Act and Assert
    assertEquals("USD10.00", bLCVariableExpression.getPrice("Amount10currency.default"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>When {@code Amount1010}.
   *   <li>Then return {@code USD1,010.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  public void testGetPrice_whenAmount1010_thenReturnUsd101000() {
    // Arrange, Act and Assert
    assertEquals("USD1,010.00", new PromotionMessageVariableExpression().getPrice("Amount1010"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>When {@code Amount1042}.
   *   <li>Then return {@code USD1,042.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  public void testGetPrice_whenAmount1042_thenReturnUsd104200() {
    // Arrange, Act and Assert
    assertEquals("USD1,042.00", new PromotionMessageVariableExpression().getPrice("Amount1042"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>When {@code Amount4210}.
   *   <li>Then return {@code USD4,210.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  public void testGetPrice_whenAmount4210_thenReturnUsd421000() {
    // Arrange, Act and Assert
    assertEquals("USD4,210.00", new PromotionMessageVariableExpression().getPrice("Amount4210"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>When {@code Amount4242}.
   *   <li>Then return {@code USD4,242.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  public void testGetPrice_whenAmount4242_thenReturnUsd424200() {
    // Arrange, Act and Assert
    assertEquals("USD4,242.00", new PromotionMessageVariableExpression().getPrice("Amount4242"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>When {@code currency.default10Amount}.
   *   <li>Then return {@code USD0.10}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  public void testGetPrice_whenCurrencyDefault10Amount_thenReturnUsd010() {
    // Arrange, Act and Assert
    assertEquals("USD0.10", new BLCVariableExpression().getPrice("currency.default10Amount"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>When {@code currency.default10USD}.
   *   <li>Then return {@code USD0.10}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  public void testGetPrice_whenCurrencyDefault10USD_thenReturnUsd010() {
    // Arrange, Act and Assert
    assertEquals("USD0.10", new BLCVariableExpression().getPrice("currency.default10USD"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>When {@code currency.default10UUU}.
   *   <li>Then return {@code USD0.10}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  public void testGetPrice_whenCurrencyDefault10UUU_thenReturnUsd010() {
    // Arrange, Act and Assert
    assertEquals("USD0.10", new BLCVariableExpression().getPrice("currency.default10UUU"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>When {@code currency.default42Amount}.
   *   <li>Then return {@code USD0.42}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  public void testGetPrice_whenCurrencyDefault42Amount_thenReturnUsd042() {
    // Arrange, Act and Assert
    assertEquals("USD0.42", new BLCVariableExpression().getPrice("currency.default42Amount"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>When {@code currency.default42USD}.
   *   <li>Then return {@code USD0.42}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  public void testGetPrice_whenCurrencyDefault42USD_thenReturnUsd042() {
    // Arrange, Act and Assert
    assertEquals("USD0.42", new BLCVariableExpression().getPrice("currency.default42USD"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>When {@code currency.default42UUU}.
   *   <li>Then return {@code USD0.42}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  public void testGetPrice_whenCurrencyDefault42UUU_thenReturnUsd042() {
    // Arrange, Act and Assert
    assertEquals("USD0.42", new BLCVariableExpression().getPrice("currency.default42UUU"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>When {@code currency.defaultAmount10}.
   *   <li>Then return {@code USD0.10}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  public void testGetPrice_whenCurrencyDefaultAmount10_thenReturnUsd010() {
    // Arrange, Act and Assert
    assertEquals("USD0.10", new BLCVariableExpression().getPrice("currency.defaultAmount10"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>When {@code currency.defaultAmount42}.
   *   <li>Then return {@code USD0.42}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  public void testGetPrice_whenCurrencyDefaultAmount42_thenReturnUsd042() {
    // Arrange, Act and Assert
    assertEquals("USD0.42", new BLCVariableExpression().getPrice("currency.defaultAmount42"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>When {@code currency.defaultUSD10}.
   *   <li>Then return {@code USD0.10}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  public void testGetPrice_whenCurrencyDefaultUSD10_thenReturnUsd010() {
    // Arrange, Act and Assert
    assertEquals("USD0.10", new BLCVariableExpression().getPrice("currency.defaultUSD10"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>When {@code currency.defaultUSD42}.
   *   <li>Then return {@code USD0.42}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  public void testGetPrice_whenCurrencyDefaultUSD42_thenReturnUsd042() {
    // Arrange, Act and Assert
    assertEquals("USD0.42", new BLCVariableExpression().getPrice("currency.defaultUSD42"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>When {@code currency.defaultUUU10}.
   *   <li>Then return {@code USD0.10}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  public void testGetPrice_whenCurrencyDefaultUUU10_thenReturnUsd010() {
    // Arrange, Act and Assert
    assertEquals("USD0.10", new BLCVariableExpression().getPrice("currency.defaultUUU10"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>When {@code currency.defaultUUU42}.
   *   <li>Then return {@code USD0.42}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  public void testGetPrice_whenCurrencyDefaultUUU42_thenReturnUsd042() {
    // Arrange, Act and Assert
    assertEquals("USD0.42", new BLCVariableExpression().getPrice("currency.defaultUUU42"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>When {@code USD10currency.default}.
   *   <li>Then return {@code USD10.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  public void testGetPrice_whenUSD10currencyDefault_thenReturnUsd1000() {
    // Arrange, Act and Assert
    assertEquals("USD10.00", new BLCVariableExpression().getPrice("USD10currency.default"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>When {@code USD42currency.default}.
   *   <li>Then return {@code USD42.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  public void testGetPrice_whenUSD42currencyDefault_thenReturnUsd4200() {
    // Arrange, Act and Assert
    assertEquals("USD42.00", bLCVariableExpression.getPrice("USD42currency.default"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>When {@code USDcurrency.default10}.
   *   <li>Then return {@code USD0.10}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  public void testGetPrice_whenUSDcurrencyDefault10_thenReturnUsd010() {
    // Arrange, Act and Assert
    assertEquals("USD0.10", bLCVariableExpression.getPrice("USDcurrency.default10"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>When {@code USDcurrency.default42}.
   *   <li>Then return {@code USD0.42}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  public void testGetPrice_whenUSDcurrencyDefault42_thenReturnUsd042() {
    // Arrange, Act and Assert
    assertEquals("USD0.42", bLCVariableExpression.getPrice("USDcurrency.default42"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>When {@code UUU10currency.default}.
   *   <li>Then return {@code USD10.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  public void testGetPrice_whenUUU10currencyDefault_thenReturnUsd1000() {
    // Arrange, Act and Assert
    assertEquals("USD10.00", new BLCVariableExpression().getPrice("UUU10currency.default"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>When {@code UUU42currency.default}.
   *   <li>Then return {@code USD42.00}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  public void testGetPrice_whenUUU42currencyDefault_thenReturnUsd4200() {
    // Arrange, Act and Assert
    assertEquals("USD42.00", new BLCVariableExpression().getPrice("UUU42currency.default"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>When {@code UUUcurrency.default10}.
   *   <li>Then return {@code USD0.10}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  public void testGetPrice_whenUUUcurrencyDefault10_thenReturnUsd010() {
    // Arrange, Act and Assert
    assertEquals("USD0.10", new BLCVariableExpression().getPrice("UUUcurrency.default10"));
  }

  /**
   * Test {@link BLCVariableExpression#getPrice(String)}.
   *
   * <ul>
   *   <li>When {@code UUUcurrency.default42}.
   *   <li>Then return {@code USD0.42}.
   * </ul>
   *
   * <p>Method under test: {@link BLCVariableExpression#getPrice(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCVariableExpression.getPrice(String)"})
  public void testGetPrice_whenUUUcurrencyDefault42_thenReturnUsd042() {
    // Arrange, Act and Assert
    assertEquals("USD0.42", new BLCVariableExpression().getPrice("UUUcurrency.default42"));
  }
}
