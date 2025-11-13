package org.broadleafcommerce.core.catalog.service.dynamic;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Map;
import org.broadleafcommerce.core.catalog.domain.Sku;
import org.broadleafcommerce.core.catalog.domain.SkuImpl;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class SkuPricingConsiderationContextDiffblueTest {
  /**
   * Test {@link SkuPricingConsiderationContext#getSkuPricingConsiderationContext()}.
   *
   * <p>Method under test: {@link
   * SkuPricingConsiderationContext#getSkuPricingConsiderationContext()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.util.HashMap SkuPricingConsiderationContext.getSkuPricingConsiderationContext()"
  })
  public void testGetSkuPricingConsiderationContext() {
    // Arrange, Act and Assert
    assertNull(SkuPricingConsiderationContext.getSkuPricingConsiderationContext());
  }

  /**
   * Test {@link SkuPricingConsiderationContext#getSkuPricingService()}.
   *
   * <p>Method under test: {@link SkuPricingConsiderationContext#getSkuPricingService()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.broadleafcommerce.core.catalog.service.dynamic.DynamicSkuPricingService SkuPricingConsiderationContext.getSkuPricingService()"
  })
  public void testGetSkuPricingService() {
    // Arrange, Act and Assert
    assertNull(SkuPricingConsiderationContext.getSkuPricingService());
  }

  /**
   * Test {@link SkuPricingConsiderationContext#isPricingConsiderationActive()}.
   *
   * <p>Method under test: {@link SkuPricingConsiderationContext#isPricingConsiderationActive()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SkuPricingConsiderationContext.isPricingConsiderationActive()"})
  public void testIsPricingConsiderationActive() {
    // Arrange, Act and Assert
    assertFalse(SkuPricingConsiderationContext.isPricingConsiderationActive());
  }

  /**
   * Test {@link SkuPricingConsiderationContext#hasDynamicPricing()}.
   *
   * <p>Method under test: {@link SkuPricingConsiderationContext#hasDynamicPricing()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SkuPricingConsiderationContext.hasDynamicPricing()"})
  public void testHasDynamicPricing() {
    // Arrange, Act and Assert
    assertFalse(SkuPricingConsiderationContext.hasDynamicPricing());
  }

  /**
   * Test {@link SkuPricingConsiderationContext#getThreadCache()}.
   *
   * <p>Method under test: {@link SkuPricingConsiderationContext#getThreadCache()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map SkuPricingConsiderationContext.getThreadCache()"})
  public void testGetThreadCache() {
    // Arrange and Act
    Map<Long, DynamicSkuPrices> actualThreadCache = SkuPricingConsiderationContext.getThreadCache();

    // Assert
    assertTrue(actualThreadCache.isEmpty());
  }

  /**
   * Test {@link SkuPricingConsiderationContext#getDynamicSkuPrices(Sku)}.
   *
   * <p>Method under test: {@link SkuPricingConsiderationContext#getDynamicSkuPrices(Sku)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"DynamicSkuPrices SkuPricingConsiderationContext.getDynamicSkuPrices(Sku)"})
  public void testGetDynamicSkuPrices() {
    // Arrange, Act and Assert
    assertNull(SkuPricingConsiderationContext.getDynamicSkuPrices(new SkuImpl()));
  }

  /**
   * Test new {@link SkuPricingConsiderationContext} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link
   * SkuPricingConsiderationContext}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SkuPricingConsiderationContext.<init>()"})
  public void testNewSkuPricingConsiderationContext() {
    // Arrange and Act
    SkuPricingConsiderationContext actualSkuPricingConsiderationContext =
        new SkuPricingConsiderationContext();

    // Assert
    assertNull(actualSkuPricingConsiderationContext.considerations);
    assertNull(actualSkuPricingConsiderationContext.pricingService);
    assertFalse(actualSkuPricingConsiderationContext.isActive);
    assertTrue(actualSkuPricingConsiderationContext.pricesBySku.isEmpty());
  }
}
