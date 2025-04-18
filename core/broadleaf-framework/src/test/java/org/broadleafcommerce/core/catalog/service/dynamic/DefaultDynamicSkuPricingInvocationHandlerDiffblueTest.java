/*-
 * #%L
 * BroadleafCommerce Framework
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
package org.broadleafcommerce.core.catalog.service.dynamic;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.math.BigDecimal;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.core.catalog.domain.Sku;
import org.broadleafcommerce.core.catalog.domain.SkuImpl;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class DefaultDynamicSkuPricingInvocationHandlerDiffblueTest {
  /**
   * Test {@link DefaultDynamicSkuPricingInvocationHandler#DefaultDynamicSkuPricingInvocationHandler(BigDecimal)}.
   * <p>
   * Method under test: {@link DefaultDynamicSkuPricingInvocationHandler#DefaultDynamicSkuPricingInvocationHandler(BigDecimal)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DefaultDynamicSkuPricingInvocationHandler.<init>(BigDecimal)"})
  public void testNewDefaultDynamicSkuPricingInvocationHandler() {
    // Arrange and Act
    DefaultDynamicSkuPricingInvocationHandler actualDefaultDynamicSkuPricingInvocationHandler = new DefaultDynamicSkuPricingInvocationHandler(
        new BigDecimal("2.3"));

    // Assert
    assertTrue(actualDefaultDynamicSkuPricingInvocationHandler.delegate instanceof SkuImpl);
    BigDecimal expectedAmount = new BigDecimal("2.30");
    Money money = actualDefaultDynamicSkuPricingInvocationHandler.salePrice;
    assertEquals(expectedAmount, money.getAmount());
    Money expectedAbsResult = actualDefaultDynamicSkuPricingInvocationHandler.salePrice;
    assertEquals(expectedAbsResult, money.abs());
    Sku expectedUnwrapResult = actualDefaultDynamicSkuPricingInvocationHandler.delegate;
    assertSame(expectedUnwrapResult, actualDefaultDynamicSkuPricingInvocationHandler.unwrap());
  }

  /**
   * Test {@link DefaultDynamicSkuPricingInvocationHandler#DefaultDynamicSkuPricingInvocationHandler(Sku)}.
   * <p>
   * Method under test: {@link DefaultDynamicSkuPricingInvocationHandler#DefaultDynamicSkuPricingInvocationHandler(Sku)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DefaultDynamicSkuPricingInvocationHandler.<init>(Sku)"})
  public void testNewDefaultDynamicSkuPricingInvocationHandler2() {
    // Arrange and Act
    DefaultDynamicSkuPricingInvocationHandler actualDefaultDynamicSkuPricingInvocationHandler = new DefaultDynamicSkuPricingInvocationHandler(
        new SkuImpl());

    // Assert
    Sku unwrapResult = actualDefaultDynamicSkuPricingInvocationHandler.unwrap();
    assertTrue(unwrapResult instanceof SkuImpl);
    Sku sku = actualDefaultDynamicSkuPricingInvocationHandler.delegate;
    assertTrue(sku instanceof SkuImpl);
    assertNull(unwrapResult.getPriceData().getPrice());
    assertNull(sku.getPriceData().getPrice());
    BigDecimal expectedAmount = new BigDecimal("0.00");
    Money margin = unwrapResult.getMargin();
    assertEquals(expectedAmount, margin.getAmount());
    assertEquals(margin, margin.abs());
    assertEquals(margin, margin.zero());
  }

  /**
   * Test {@link DefaultDynamicSkuPricingInvocationHandler#DefaultDynamicSkuPricingInvocationHandler(Sku, BigDecimal)}.
   * <p>
   * Method under test: {@link DefaultDynamicSkuPricingInvocationHandler#DefaultDynamicSkuPricingInvocationHandler(Sku, BigDecimal)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DefaultDynamicSkuPricingInvocationHandler.<init>(Sku, BigDecimal)"})
  public void testNewDefaultDynamicSkuPricingInvocationHandler3() {
    // Arrange
    SkuImpl sku = new SkuImpl();

    // Act
    DefaultDynamicSkuPricingInvocationHandler actualDefaultDynamicSkuPricingInvocationHandler = new DefaultDynamicSkuPricingInvocationHandler(
        sku, new BigDecimal("2.3"));

    // Assert
    Sku unwrapResult = actualDefaultDynamicSkuPricingInvocationHandler.unwrap();
    assertTrue(unwrapResult instanceof SkuImpl);
    Money money = actualDefaultDynamicSkuPricingInvocationHandler.salePrice;
    Money zeroResult = money.zero();
    Money zeroResult2 = zeroResult.zero();
    assertEquals(zeroResult2, money.abs().zero());
    assertEquals(zeroResult2, zeroResult2);
    assertEquals(zeroResult2, unwrapResult.getMargin());
    assertEquals(zeroResult, zeroResult.abs());
  }

  /**
   * Test {@link DefaultDynamicSkuPricingInvocationHandler#DefaultDynamicSkuPricingInvocationHandler(Sku, Money)}.
   * <p>
   * Method under test: {@link DefaultDynamicSkuPricingInvocationHandler#DefaultDynamicSkuPricingInvocationHandler(Sku, Money)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DefaultDynamicSkuPricingInvocationHandler.<init>(Sku, Money)"})
  public void testNewDefaultDynamicSkuPricingInvocationHandler4() {
    // Arrange
    SkuImpl sku = new SkuImpl();

    // Act
    DefaultDynamicSkuPricingInvocationHandler actualDefaultDynamicSkuPricingInvocationHandler = new DefaultDynamicSkuPricingInvocationHandler(
        sku, new Money());

    // Assert
    Sku unwrapResult = actualDefaultDynamicSkuPricingInvocationHandler.unwrap();
    assertTrue(unwrapResult instanceof SkuImpl);
    Money money = actualDefaultDynamicSkuPricingInvocationHandler.salePrice;
    Money money2 = actualDefaultDynamicSkuPricingInvocationHandler.retailPrice;
    assertEquals(money, money2.abs());
    Money money3 = actualDefaultDynamicSkuPricingInvocationHandler.salePrice;
    assertEquals(money, money3.abs());
    assertEquals(money, money2.zero());
    assertEquals(money, money3.zero());
    assertEquals(money, unwrapResult.getMargin());
  }

  /**
   * Test {@link DefaultDynamicSkuPricingInvocationHandler#DefaultDynamicSkuPricingInvocationHandler(Sku, Money)}.
   * <ul>
   *   <li>Then return {@link DefaultDynamicSkuPricingInvocationHandler#retailPrice} is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultDynamicSkuPricingInvocationHandler#DefaultDynamicSkuPricingInvocationHandler(Sku, Money)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DefaultDynamicSkuPricingInvocationHandler.<init>(Sku, Money)"})
  public void testNewDefaultDynamicSkuPricingInvocationHandler_thenReturnRetailPriceIsNull() {
    // Arrange and Act
    DefaultDynamicSkuPricingInvocationHandler actualDefaultDynamicSkuPricingInvocationHandler = new DefaultDynamicSkuPricingInvocationHandler(
        new SkuImpl(), (Money) null);

    // Assert
    Sku unwrapResult = actualDefaultDynamicSkuPricingInvocationHandler.unwrap();
    assertTrue(unwrapResult instanceof SkuImpl);
    assertTrue(actualDefaultDynamicSkuPricingInvocationHandler.delegate instanceof SkuImpl);
    assertNull(actualDefaultDynamicSkuPricingInvocationHandler.retailPrice);
    assertNull(actualDefaultDynamicSkuPricingInvocationHandler.salePrice);
    assertSame(actualDefaultDynamicSkuPricingInvocationHandler.delegate, unwrapResult);
  }

  /**
   * Test {@link DefaultDynamicSkuPricingInvocationHandler#DefaultDynamicSkuPricingInvocationHandler(Sku, BigDecimal)}.
   * <ul>
   *   <li>Then return {@link DefaultDynamicSkuPricingInvocationHandler#salePrice} is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultDynamicSkuPricingInvocationHandler#DefaultDynamicSkuPricingInvocationHandler(Sku, BigDecimal)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DefaultDynamicSkuPricingInvocationHandler.<init>(Sku, BigDecimal)"})
  public void testNewDefaultDynamicSkuPricingInvocationHandler_thenReturnSalePriceIsNull() {
    // Arrange and Act
    DefaultDynamicSkuPricingInvocationHandler actualDefaultDynamicSkuPricingInvocationHandler = new DefaultDynamicSkuPricingInvocationHandler(
        new SkuImpl(), (BigDecimal) null);

    // Assert
    Sku unwrapResult = actualDefaultDynamicSkuPricingInvocationHandler.unwrap();
    assertTrue(unwrapResult instanceof SkuImpl);
    assertTrue(actualDefaultDynamicSkuPricingInvocationHandler.delegate instanceof SkuImpl);
    assertNull(actualDefaultDynamicSkuPricingInvocationHandler.salePrice);
    assertSame(actualDefaultDynamicSkuPricingInvocationHandler.delegate, unwrapResult);
  }

  /**
   * Test {@link DefaultDynamicSkuPricingInvocationHandler#DefaultDynamicSkuPricingInvocationHandler(Sku)}.
   * <ul>
   *   <li>Then return unwrap hasRetailPrice.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultDynamicSkuPricingInvocationHandler#DefaultDynamicSkuPricingInvocationHandler(Sku)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DefaultDynamicSkuPricingInvocationHandler.<init>(Sku)"})
  public void testNewDefaultDynamicSkuPricingInvocationHandler_thenReturnUnwrapHasRetailPrice() {
    // Arrange
    SkuImpl sku = new SkuImpl();
    Money retailPrice = new Money();
    sku.setRetailPrice(retailPrice);

    // Act
    DefaultDynamicSkuPricingInvocationHandler actualDefaultDynamicSkuPricingInvocationHandler = new DefaultDynamicSkuPricingInvocationHandler(
        sku);

    // Assert
    Sku unwrapResult = actualDefaultDynamicSkuPricingInvocationHandler.unwrap();
    assertTrue(unwrapResult instanceof SkuImpl);
    Sku sku2 = actualDefaultDynamicSkuPricingInvocationHandler.delegate;
    assertTrue(sku2 instanceof SkuImpl);
    assertTrue(unwrapResult.hasRetailPrice());
    assertTrue(sku2.hasRetailPrice());
    assertEquals(retailPrice, unwrapResult.getBaseRetailPrice());
    assertEquals(retailPrice, sku2.getBaseRetailPrice());
    assertEquals(retailPrice, unwrapResult.getListPrice());
    assertEquals(retailPrice, sku2.getListPrice());
    assertEquals(retailPrice, unwrapResult.getPrice());
    assertEquals(retailPrice, sku2.getPrice());
    assertEquals(retailPrice, unwrapResult.getRetailPrice());
    assertEquals(retailPrice, sku2.getRetailPrice());
    assertEquals(retailPrice, actualDefaultDynamicSkuPricingInvocationHandler.retailPrice);
  }

  /**
   * Test {@link DefaultDynamicSkuPricingInvocationHandler#DefaultDynamicSkuPricingInvocationHandler(Sku, BigDecimal)}.
   * <ul>
   *   <li>Then return unwrap hasRetailPrice.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultDynamicSkuPricingInvocationHandler#DefaultDynamicSkuPricingInvocationHandler(Sku, BigDecimal)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DefaultDynamicSkuPricingInvocationHandler.<init>(Sku, BigDecimal)"})
  public void testNewDefaultDynamicSkuPricingInvocationHandler_thenReturnUnwrapHasRetailPrice2() {
    // Arrange
    SkuImpl sku = new SkuImpl();
    Money retailPrice = new Money();
    sku.setRetailPrice(retailPrice);

    // Act
    DefaultDynamicSkuPricingInvocationHandler actualDefaultDynamicSkuPricingInvocationHandler = new DefaultDynamicSkuPricingInvocationHandler(
        sku, new BigDecimal("2.3"));

    // Assert
    Sku unwrapResult = actualDefaultDynamicSkuPricingInvocationHandler.unwrap();
    assertTrue(unwrapResult instanceof SkuImpl);
    Sku sku2 = actualDefaultDynamicSkuPricingInvocationHandler.delegate;
    assertTrue(sku2 instanceof SkuImpl);
    assertTrue(unwrapResult.hasRetailPrice());
    assertTrue(sku2.hasRetailPrice());
    assertEquals(retailPrice, unwrapResult.getBaseRetailPrice());
    assertEquals(retailPrice, sku2.getBaseRetailPrice());
    assertEquals(retailPrice, unwrapResult.getListPrice());
    assertEquals(retailPrice, sku2.getListPrice());
    assertEquals(retailPrice, unwrapResult.getPrice());
    assertEquals(retailPrice, sku2.getPrice());
    assertEquals(retailPrice, unwrapResult.getRetailPrice());
    assertEquals(retailPrice, sku2.getRetailPrice());
    assertEquals(retailPrice, actualDefaultDynamicSkuPricingInvocationHandler.retailPrice);
  }

  /**
   * Test {@link DefaultDynamicSkuPricingInvocationHandler#DefaultDynamicSkuPricingInvocationHandler(Sku, Money)}.
   * <ul>
   *   <li>Then return unwrap hasRetailPrice.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultDynamicSkuPricingInvocationHandler#DefaultDynamicSkuPricingInvocationHandler(Sku, Money)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DefaultDynamicSkuPricingInvocationHandler.<init>(Sku, Money)"})
  public void testNewDefaultDynamicSkuPricingInvocationHandler_thenReturnUnwrapHasRetailPrice3() {
    // Arrange
    SkuImpl sku = new SkuImpl();
    Money retailPrice = new Money();
    sku.setRetailPrice(retailPrice);

    // Act
    DefaultDynamicSkuPricingInvocationHandler actualDefaultDynamicSkuPricingInvocationHandler = new DefaultDynamicSkuPricingInvocationHandler(
        sku, new Money());

    // Assert
    Sku unwrapResult = actualDefaultDynamicSkuPricingInvocationHandler.unwrap();
    assertTrue(unwrapResult instanceof SkuImpl);
    Sku sku2 = actualDefaultDynamicSkuPricingInvocationHandler.delegate;
    assertTrue(sku2 instanceof SkuImpl);
    assertTrue(unwrapResult.hasRetailPrice());
    assertTrue(sku2.hasRetailPrice());
    assertEquals(retailPrice, unwrapResult.getBaseRetailPrice());
    assertEquals(retailPrice, sku2.getBaseRetailPrice());
    assertEquals(retailPrice, unwrapResult.getListPrice());
    assertEquals(retailPrice, sku2.getListPrice());
    assertEquals(retailPrice, unwrapResult.getPrice());
    assertEquals(retailPrice, sku2.getPrice());
    assertEquals(retailPrice, unwrapResult.getRetailPrice());
    assertEquals(retailPrice, sku2.getRetailPrice());
  }

  /**
   * Test {@link DefaultDynamicSkuPricingInvocationHandler#DefaultDynamicSkuPricingInvocationHandler(Sku)}.
   * <ul>
   *   <li>Then return unwrap hasSalePrice.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultDynamicSkuPricingInvocationHandler#DefaultDynamicSkuPricingInvocationHandler(Sku)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DefaultDynamicSkuPricingInvocationHandler.<init>(Sku)"})
  public void testNewDefaultDynamicSkuPricingInvocationHandler_thenReturnUnwrapHasSalePrice() {
    // Arrange
    SkuImpl sku = new SkuImpl();
    Money salePrice = new Money();
    sku.setSalePrice(salePrice);

    // Act
    DefaultDynamicSkuPricingInvocationHandler actualDefaultDynamicSkuPricingInvocationHandler = new DefaultDynamicSkuPricingInvocationHandler(
        sku);

    // Assert
    Sku unwrapResult = actualDefaultDynamicSkuPricingInvocationHandler.unwrap();
    assertTrue(unwrapResult instanceof SkuImpl);
    Sku sku2 = actualDefaultDynamicSkuPricingInvocationHandler.delegate;
    assertTrue(sku2 instanceof SkuImpl);
    assertTrue(unwrapResult.hasSalePrice());
    assertTrue(sku2.hasSalePrice());
    assertEquals(salePrice, unwrapResult.getBaseSalePrice());
    assertEquals(salePrice, sku2.getBaseSalePrice());
    assertEquals(salePrice, unwrapResult.getSalePrice());
    assertEquals(salePrice, sku2.getSalePrice());
    assertEquals(salePrice, actualDefaultDynamicSkuPricingInvocationHandler.salePrice);
  }

  /**
   * Test {@link DefaultDynamicSkuPricingInvocationHandler#DefaultDynamicSkuPricingInvocationHandler(Sku, BigDecimal)}.
   * <ul>
   *   <li>Then return unwrap hasSalePrice.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultDynamicSkuPricingInvocationHandler#DefaultDynamicSkuPricingInvocationHandler(Sku, BigDecimal)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DefaultDynamicSkuPricingInvocationHandler.<init>(Sku, BigDecimal)"})
  public void testNewDefaultDynamicSkuPricingInvocationHandler_thenReturnUnwrapHasSalePrice2() {
    // Arrange
    SkuImpl sku = new SkuImpl();
    Money salePrice = new Money();
    sku.setSalePrice(salePrice);

    // Act
    DefaultDynamicSkuPricingInvocationHandler actualDefaultDynamicSkuPricingInvocationHandler = new DefaultDynamicSkuPricingInvocationHandler(
        sku, new BigDecimal("2.3"));

    // Assert
    Sku unwrapResult = actualDefaultDynamicSkuPricingInvocationHandler.unwrap();
    assertTrue(unwrapResult instanceof SkuImpl);
    Sku sku2 = actualDefaultDynamicSkuPricingInvocationHandler.delegate;
    assertTrue(sku2 instanceof SkuImpl);
    assertTrue(unwrapResult.hasSalePrice());
    assertTrue(sku2.hasSalePrice());
    assertEquals(salePrice, unwrapResult.getBaseSalePrice());
    assertEquals(salePrice, sku2.getBaseSalePrice());
    assertEquals(salePrice, unwrapResult.getSalePrice());
    assertEquals(salePrice, sku2.getSalePrice());
  }

  /**
   * Test {@link DefaultDynamicSkuPricingInvocationHandler#DefaultDynamicSkuPricingInvocationHandler(Sku, Money)}.
   * <ul>
   *   <li>Then return unwrap hasSalePrice.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultDynamicSkuPricingInvocationHandler#DefaultDynamicSkuPricingInvocationHandler(Sku, Money)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DefaultDynamicSkuPricingInvocationHandler.<init>(Sku, Money)"})
  public void testNewDefaultDynamicSkuPricingInvocationHandler_thenReturnUnwrapHasSalePrice3() {
    // Arrange
    SkuImpl sku = new SkuImpl();
    Money salePrice = new Money();
    sku.setSalePrice(salePrice);

    // Act
    DefaultDynamicSkuPricingInvocationHandler actualDefaultDynamicSkuPricingInvocationHandler = new DefaultDynamicSkuPricingInvocationHandler(
        sku, new Money());

    // Assert
    Sku unwrapResult = actualDefaultDynamicSkuPricingInvocationHandler.unwrap();
    assertTrue(unwrapResult instanceof SkuImpl);
    Sku sku2 = actualDefaultDynamicSkuPricingInvocationHandler.delegate;
    assertTrue(sku2 instanceof SkuImpl);
    assertTrue(unwrapResult.hasSalePrice());
    assertTrue(sku2.hasSalePrice());
    assertEquals(salePrice, unwrapResult.getBaseSalePrice());
    assertEquals(salePrice, sku2.getBaseSalePrice());
    assertEquals(salePrice, unwrapResult.getSalePrice());
    assertEquals(salePrice, sku2.getSalePrice());
  }

  /**
   * Test {@link DefaultDynamicSkuPricingInvocationHandler#DefaultDynamicSkuPricingInvocationHandler(BigDecimal)}.
   * <ul>
   *   <li>Then unwrap return {@link SkuImpl}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultDynamicSkuPricingInvocationHandler#DefaultDynamicSkuPricingInvocationHandler(BigDecimal)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DefaultDynamicSkuPricingInvocationHandler.<init>(BigDecimal)"})
  public void testNewDefaultDynamicSkuPricingInvocationHandler_thenUnwrapReturnSkuImpl() {
    // Arrange and Act
    DefaultDynamicSkuPricingInvocationHandler actualDefaultDynamicSkuPricingInvocationHandler = new DefaultDynamicSkuPricingInvocationHandler(
        (BigDecimal) null);

    // Assert
    Sku unwrapResult = actualDefaultDynamicSkuPricingInvocationHandler.unwrap();
    assertTrue(unwrapResult instanceof SkuImpl);
    assertTrue(actualDefaultDynamicSkuPricingInvocationHandler.delegate instanceof SkuImpl);
    assertNull(actualDefaultDynamicSkuPricingInvocationHandler.salePrice);
    assertSame(actualDefaultDynamicSkuPricingInvocationHandler.delegate, unwrapResult);
  }

  /**
   * Test {@link DefaultDynamicSkuPricingInvocationHandler#unwrap()}.
   * <p>
   * Method under test: {@link DefaultDynamicSkuPricingInvocationHandler#unwrap()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Sku DefaultDynamicSkuPricingInvocationHandler.unwrap()"})
  public void testUnwrap() {
    // Arrange
    DefaultDynamicSkuPricingInvocationHandler defaultDynamicSkuPricingInvocationHandler = new DefaultDynamicSkuPricingInvocationHandler(
        new BigDecimal("2.3"));

    // Act and Assert
    assertSame(defaultDynamicSkuPricingInvocationHandler.delegate, defaultDynamicSkuPricingInvocationHandler.unwrap());
  }

  /**
   * Test {@link DefaultDynamicSkuPricingInvocationHandler#reset()}.
   * <p>
   * Method under test: {@link DefaultDynamicSkuPricingInvocationHandler#reset()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DefaultDynamicSkuPricingInvocationHandler.reset()"})
  public void testReset() {
    // Arrange
    DefaultDynamicSkuPricingInvocationHandler defaultDynamicSkuPricingInvocationHandler = new DefaultDynamicSkuPricingInvocationHandler(
        new BigDecimal("2.3"));

    // Act
    defaultDynamicSkuPricingInvocationHandler.reset();

    // Assert
    assertNull(defaultDynamicSkuPricingInvocationHandler.salePrice);
    assertNull(defaultDynamicSkuPricingInvocationHandler.unwrap());
    assertNull(defaultDynamicSkuPricingInvocationHandler.delegate);
  }
}
