package org.broadleafcommerce.core.catalog.service.dynamic;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import java.sql.Date;
import java.util.HashMap;
import java.util.Map;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.core.catalog.domain.Sku;
import org.broadleafcommerce.core.catalog.domain.SkuImpl;
import org.junit.Ignore;
import org.junit.Test;

public class SkuPricingConsiderationContextDiffblueTest {
  /**
   * Test
   * {@link SkuPricingConsiderationContext#getSkuPricingConsiderationContext()}.
   * <p>
   * Method under test:
   * {@link SkuPricingConsiderationContext#getSkuPricingConsiderationContext()}
   */
  @Test
  public void testGetSkuPricingConsiderationContext() {
    // Arrange, Act and Assert
    assertNull(SkuPricingConsiderationContext.getSkuPricingConsiderationContext());
  }

  /**
   * Test
   * {@link SkuPricingConsiderationContext#setSkuPricingConsiderationContext(HashMap)}.
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SkuPricingConsiderationContext#setSkuPricingConsiderationContext(HashMap)}
   */
  @Test
  public void testSetSkuPricingConsiderationContext_whenHashMap() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange and Act
    SkuPricingConsiderationContext.setSkuPricingConsiderationContext(new HashMap());
  }

  /**
   * Test {@link SkuPricingConsiderationContext#getSkuPricingService()}.
   * <p>
   * Method under test:
   * {@link SkuPricingConsiderationContext#getSkuPricingService()}
   */
  @Test
  public void testGetSkuPricingService() {
    // Arrange, Act and Assert
    assertNull(SkuPricingConsiderationContext.getSkuPricingService());
  }

  /**
   * Test
   * {@link SkuPricingConsiderationContext#setSkuPricingService(DynamicSkuPricingService)}.
   * <p>
   * Method under test:
   * {@link SkuPricingConsiderationContext#setSkuPricingService(DynamicSkuPricingService)}
   */
  @Test
  public void testSetSkuPricingService() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange and Act
    SkuPricingConsiderationContext.setSkuPricingService(new DefaultDynamicSkuPricingServiceImpl());
  }

  /**
   * Test {@link SkuPricingConsiderationContext#startPricingConsideration()}.
   * <p>
   * Method under test:
   * {@link SkuPricingConsiderationContext#startPricingConsideration()}
   */
  @Test
  public void testStartPricingConsideration() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange and Act
    SkuPricingConsiderationContext.startPricingConsideration();
  }

  /**
   * Test {@link SkuPricingConsiderationContext#endPricingConsideration()}.
   * <p>
   * Method under test:
   * {@link SkuPricingConsiderationContext#endPricingConsideration()}
   */
  @Test
  public void testEndPricingConsideration() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange and Act
    SkuPricingConsiderationContext.endPricingConsideration();
  }

  /**
   * Test {@link SkuPricingConsiderationContext#isPricingConsiderationActive()}.
   * <p>
   * Method under test:
   * {@link SkuPricingConsiderationContext#isPricingConsiderationActive()}
   */
  @Test
  public void testIsPricingConsiderationActive() {
    // Arrange, Act and Assert
    assertFalse(SkuPricingConsiderationContext.isPricingConsiderationActive());
  }

  /**
   * Test {@link SkuPricingConsiderationContext#hasDynamicPricing()}.
   * <p>
   * Method under test: {@link SkuPricingConsiderationContext#hasDynamicPricing()}
   */
  @Test
  public void testHasDynamicPricing() {
    // Arrange, Act and Assert
    assertFalse(SkuPricingConsiderationContext.hasDynamicPricing());
  }

  /**
   * Test {@link SkuPricingConsiderationContext#getThreadCache()}.
   * <p>
   * Method under test: {@link SkuPricingConsiderationContext#getThreadCache()}
   */
  @Test
  public void testGetThreadCache() {
    // Arrange and Act
    Map<Long, DynamicSkuPrices> actualThreadCache = SkuPricingConsiderationContext.getThreadCache();

    // Assert
    assertTrue(actualThreadCache.isEmpty());
  }

  /**
   * Test {@link SkuPricingConsiderationContext#clearThreadCache()}.
   * <p>
   * Method under test: {@link SkuPricingConsiderationContext#clearThreadCache()}
   */
  @Test
  public void testClearThreadCache() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange and Act
    SkuPricingConsiderationContext.clearThreadCache();
  }

  /**
   * Test {@link SkuPricingConsiderationContext#removeFromThreadCache(Long)}.
   * <p>
   * Method under test:
   * {@link SkuPricingConsiderationContext#removeFromThreadCache(Long)}
   */
  @Test
  public void testRemoveFromThreadCache() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange and Act
    SkuPricingConsiderationContext.removeFromThreadCache(1L);
  }

  /**
   * Test {@link SkuPricingConsiderationContext#getDynamicSkuPrices(Sku)}.
   * <ul>
   *   <li>Given {@link Date}.</li>
   *   <li>When {@link SkuImpl} (default constructor) ActiveStartDate is
   * {@link Date}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SkuPricingConsiderationContext#getDynamicSkuPrices(Sku)}
   */
  @Test
  public void testGetDynamicSkuPrices_givenDate_whenSkuImplActiveStartDateIsDate() {
    // Arrange
    SkuImpl sku = new SkuImpl();
    sku.setActiveStartDate(mock(Date.class));

    // Act and Assert
    assertNull(SkuPricingConsiderationContext.getDynamicSkuPrices(sku));
  }

  /**
   * Test {@link SkuPricingConsiderationContext#getDynamicSkuPrices(Sku)}.
   * <ul>
   *   <li>Given {@link Money#Money()}.</li>
   *   <li>When {@link SkuImpl} (default constructor) SalePrice is
   * {@link Money#Money()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SkuPricingConsiderationContext#getDynamicSkuPrices(Sku)}
   */
  @Test
  public void testGetDynamicSkuPrices_givenMoney_whenSkuImplSalePriceIsMoney() {
    // Arrange
    SkuImpl sku = new SkuImpl();
    sku.setSalePrice(new Money());

    // Act and Assert
    assertNull(SkuPricingConsiderationContext.getDynamicSkuPrices(sku));
  }

  /**
   * Test {@link SkuPricingConsiderationContext#getDynamicSkuPrices(Sku)}.
   * <ul>
   *   <li>When {@link SkuImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SkuPricingConsiderationContext#getDynamicSkuPrices(Sku)}
   */
  @Test
  public void testGetDynamicSkuPrices_whenSkuImpl() {
    // Arrange, Act and Assert
    assertNull(SkuPricingConsiderationContext.getDynamicSkuPrices(new SkuImpl()));
  }

  /**
   * Test {@link SkuPricingConsiderationContext#getSingleField(Class, String)}.
   * <ul>
   *   <li>When {@code java.lang.Object}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SkuPricingConsiderationContext#getSingleField(Class, String)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetSingleField_whenJavaLangObject() throws IllegalStateException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.NullPointerException
    //       at java.base/java.util.concurrent.ConcurrentHashMap.putVal(ConcurrentHashMap.java:1011)
    //       at java.base/java.util.concurrent.ConcurrentHashMap.put(ConcurrentHashMap.java:1006)
    //       at org.broadleafcommerce.core.catalog.service.dynamic.SkuPricingConsiderationContext.getSingleField(SkuPricingConsiderationContext.java:142)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange
    Class<Object> clazz = Object.class;

    // Act
    SkuPricingConsiderationContext.getSingleField(clazz, "Field Name");
  }

  /**
   * Test new {@link SkuPricingConsiderationContext} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link SkuPricingConsiderationContext}
   */
  @Test
  public void testNewSkuPricingConsiderationContext() {
    // Arrange and Act
    SkuPricingConsiderationContext actualSkuPricingConsiderationContext = new SkuPricingConsiderationContext();

    // Assert
    assertNull(actualSkuPricingConsiderationContext.considerations);
    assertNull(actualSkuPricingConsiderationContext.pricingService);
    assertFalse(actualSkuPricingConsiderationContext.isActive);
    assertTrue(actualSkuPricingConsiderationContext.pricesBySku.isEmpty());
  }
}
