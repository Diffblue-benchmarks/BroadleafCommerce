package org.broadleafcommerce.core.catalog.service.dynamic;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.math.BigDecimal;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.core.catalog.domain.Sku;
import org.broadleafcommerce.core.catalog.domain.SkuImpl;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class DefaultDynamicSkuPricingInvocationHandlerDiffblueTest {
  /**
   * Test {@link
   * DefaultDynamicSkuPricingInvocationHandler#DefaultDynamicSkuPricingInvocationHandler(BigDecimal)}.
   *
   * <p>Method under test: {@link
   * DefaultDynamicSkuPricingInvocationHandler#DefaultDynamicSkuPricingInvocationHandler(BigDecimal)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DefaultDynamicSkuPricingInvocationHandler.<init>(BigDecimal)"})
  public void testNewDefaultDynamicSkuPricingInvocationHandler() {
    // Arrange and Act
    DefaultDynamicSkuPricingInvocationHandler actualDefaultDynamicSkuPricingInvocationHandler =
        new DefaultDynamicSkuPricingInvocationHandler(new BigDecimal("2.3"));

    // Assert
    assertTrue(actualDefaultDynamicSkuPricingInvocationHandler.delegate instanceof SkuImpl);
    Money money = actualDefaultDynamicSkuPricingInvocationHandler.salePrice;
    assertEquals(new BigDecimal("2.30"), money.getAmount());
    Money expectedAbsResult = actualDefaultDynamicSkuPricingInvocationHandler.salePrice;
    assertEquals(expectedAbsResult, money.abs());
    Sku expectedUnwrapResult = actualDefaultDynamicSkuPricingInvocationHandler.delegate;
    assertSame(expectedUnwrapResult, actualDefaultDynamicSkuPricingInvocationHandler.unwrap());
  }

  /**
   * Test {@link
   * DefaultDynamicSkuPricingInvocationHandler#DefaultDynamicSkuPricingInvocationHandler(BigDecimal)}.
   *
   * <p>Method under test: {@link
   * DefaultDynamicSkuPricingInvocationHandler#DefaultDynamicSkuPricingInvocationHandler(BigDecimal)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DefaultDynamicSkuPricingInvocationHandler.<init>(BigDecimal)"})
  public void testNewDefaultDynamicSkuPricingInvocationHandler2() {
    // Arrange and Act
    DefaultDynamicSkuPricingInvocationHandler actualDefaultDynamicSkuPricingInvocationHandler =
        new DefaultDynamicSkuPricingInvocationHandler(new BigDecimal("4.5"));

    // Assert
    assertTrue(actualDefaultDynamicSkuPricingInvocationHandler.delegate instanceof SkuImpl);
    Money money = actualDefaultDynamicSkuPricingInvocationHandler.salePrice;
    assertEquals(new BigDecimal("4.50"), money.getAmount());
    Money expectedAbsResult = actualDefaultDynamicSkuPricingInvocationHandler.salePrice;
    assertEquals(expectedAbsResult, money.abs());
    Sku expectedUnwrapResult = actualDefaultDynamicSkuPricingInvocationHandler.delegate;
    assertSame(expectedUnwrapResult, actualDefaultDynamicSkuPricingInvocationHandler.unwrap());
  }

  /**
   * Test {@link
   * DefaultDynamicSkuPricingInvocationHandler#DefaultDynamicSkuPricingInvocationHandler(Sku)}.
   *
   * <p>Method under test: {@link
   * DefaultDynamicSkuPricingInvocationHandler#DefaultDynamicSkuPricingInvocationHandler(Sku)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DefaultDynamicSkuPricingInvocationHandler.<init>(Sku)"})
  public void testNewDefaultDynamicSkuPricingInvocationHandler3() {
    // Arrange and Act
    DefaultDynamicSkuPricingInvocationHandler actualDefaultDynamicSkuPricingInvocationHandler =
        new DefaultDynamicSkuPricingInvocationHandler(new SkuImpl());

    // Assert
    Sku unwrapResult = actualDefaultDynamicSkuPricingInvocationHandler.unwrap();
    assertTrue(unwrapResult instanceof SkuImpl);
    Sku sku = actualDefaultDynamicSkuPricingInvocationHandler.delegate;
    assertTrue(sku instanceof SkuImpl);
    assertNull(unwrapResult.getPriceData().getPrice());
    assertNull(sku.getPriceData().getPrice());
    Money margin = unwrapResult.getMargin();
    assertEquals(new BigDecimal("0.00"), margin.getAmount());
    Money actualAbsResult = margin.abs();
    assertEquals(margin, actualAbsResult);
    Money actualZeroResult = margin.zero();
    assertEquals(margin, actualZeroResult);
  }

  /**
   * Test {@link
   * DefaultDynamicSkuPricingInvocationHandler#DefaultDynamicSkuPricingInvocationHandler(Sku,
   * BigDecimal)}.
   *
   * <p>Method under test: {@link
   * DefaultDynamicSkuPricingInvocationHandler#DefaultDynamicSkuPricingInvocationHandler(Sku,
   * BigDecimal)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DefaultDynamicSkuPricingInvocationHandler.<init>(Sku, BigDecimal)"})
  public void testNewDefaultDynamicSkuPricingInvocationHandler4() {
    // Arrange
    SkuImpl sku = new SkuImpl();

    // Act
    DefaultDynamicSkuPricingInvocationHandler actualDefaultDynamicSkuPricingInvocationHandler =
        new DefaultDynamicSkuPricingInvocationHandler(sku, new BigDecimal("2.3"));

    // Assert
    Sku unwrapResult = actualDefaultDynamicSkuPricingInvocationHandler.unwrap();
    assertTrue(unwrapResult instanceof SkuImpl);
    Money money = actualDefaultDynamicSkuPricingInvocationHandler.salePrice;
    Money zeroResult = money.zero();
    Money zeroResult2 = zeroResult.zero();
    assertEquals(zeroResult2, money.abs().zero());
    assertEquals(zeroResult2, zeroResult2);
    assertEquals(zeroResult2, unwrapResult.getMargin());
    Money actualAbsResult = zeroResult.abs();
    assertEquals(zeroResult, actualAbsResult);
  }

  /**
   * Test {@link
   * DefaultDynamicSkuPricingInvocationHandler#DefaultDynamicSkuPricingInvocationHandler(Sku,
   * Money)}.
   *
   * <p>Method under test: {@link
   * DefaultDynamicSkuPricingInvocationHandler#DefaultDynamicSkuPricingInvocationHandler(Sku,
   * Money)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DefaultDynamicSkuPricingInvocationHandler.<init>(Sku, Money)"})
  public void testNewDefaultDynamicSkuPricingInvocationHandler5() {
    // Arrange
    SkuImpl sku = new SkuImpl();

    // Act
    DefaultDynamicSkuPricingInvocationHandler actualDefaultDynamicSkuPricingInvocationHandler =
        new DefaultDynamicSkuPricingInvocationHandler(sku, new Money());

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
   * Test {@link
   * DefaultDynamicSkuPricingInvocationHandler#DefaultDynamicSkuPricingInvocationHandler(Sku,
   * Money)}.
   *
   * <ul>
   *   <li>Then return {@link DefaultDynamicSkuPricingInvocationHandler#retailPrice} is {@code
   *       null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultDynamicSkuPricingInvocationHandler#DefaultDynamicSkuPricingInvocationHandler(Sku,
   * Money)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DefaultDynamicSkuPricingInvocationHandler.<init>(Sku, Money)"})
  public void testNewDefaultDynamicSkuPricingInvocationHandler_thenReturnRetailPriceIsNull() {
    // Arrange and Act
    DefaultDynamicSkuPricingInvocationHandler actualDefaultDynamicSkuPricingInvocationHandler =
        new DefaultDynamicSkuPricingInvocationHandler(new SkuImpl(), (Money) null);

    // Assert
    Sku unwrapResult = actualDefaultDynamicSkuPricingInvocationHandler.unwrap();
    assertTrue(unwrapResult instanceof SkuImpl);
    assertTrue(actualDefaultDynamicSkuPricingInvocationHandler.delegate instanceof SkuImpl);
    assertNull(actualDefaultDynamicSkuPricingInvocationHandler.retailPrice);
    assertNull(actualDefaultDynamicSkuPricingInvocationHandler.salePrice);
    assertSame(actualDefaultDynamicSkuPricingInvocationHandler.delegate, unwrapResult);
  }

  /**
   * Test {@link
   * DefaultDynamicSkuPricingInvocationHandler#DefaultDynamicSkuPricingInvocationHandler(Sku,
   * BigDecimal)}.
   *
   * <ul>
   *   <li>Then return {@link DefaultDynamicSkuPricingInvocationHandler#salePrice} is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultDynamicSkuPricingInvocationHandler#DefaultDynamicSkuPricingInvocationHandler(Sku,
   * BigDecimal)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DefaultDynamicSkuPricingInvocationHandler.<init>(Sku, BigDecimal)"})
  public void testNewDefaultDynamicSkuPricingInvocationHandler_thenReturnSalePriceIsNull() {
    // Arrange and Act
    DefaultDynamicSkuPricingInvocationHandler actualDefaultDynamicSkuPricingInvocationHandler =
        new DefaultDynamicSkuPricingInvocationHandler(new SkuImpl(), (BigDecimal) null);

    // Assert
    Sku unwrapResult = actualDefaultDynamicSkuPricingInvocationHandler.unwrap();
    assertTrue(unwrapResult instanceof SkuImpl);
    assertTrue(actualDefaultDynamicSkuPricingInvocationHandler.delegate instanceof SkuImpl);
    assertNull(actualDefaultDynamicSkuPricingInvocationHandler.salePrice);
    assertSame(actualDefaultDynamicSkuPricingInvocationHandler.delegate, unwrapResult);
  }

  /**
   * Test {@link
   * DefaultDynamicSkuPricingInvocationHandler#DefaultDynamicSkuPricingInvocationHandler(Sku)}.
   *
   * <ul>
   *   <li>Then return unwrap hasRetailPrice.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultDynamicSkuPricingInvocationHandler#DefaultDynamicSkuPricingInvocationHandler(Sku)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DefaultDynamicSkuPricingInvocationHandler.<init>(Sku)"})
  public void testNewDefaultDynamicSkuPricingInvocationHandler_thenReturnUnwrapHasRetailPrice() {
    // Arrange
    SkuImpl sku = new SkuImpl();
    Money retailPrice = new Money();
    sku.setRetailPrice(retailPrice);

    // Act
    DefaultDynamicSkuPricingInvocationHandler actualDefaultDynamicSkuPricingInvocationHandler =
        new DefaultDynamicSkuPricingInvocationHandler(sku);

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
   * Test {@link
   * DefaultDynamicSkuPricingInvocationHandler#DefaultDynamicSkuPricingInvocationHandler(Sku,
   * BigDecimal)}.
   *
   * <ul>
   *   <li>Then return unwrap hasRetailPrice.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultDynamicSkuPricingInvocationHandler#DefaultDynamicSkuPricingInvocationHandler(Sku,
   * BigDecimal)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DefaultDynamicSkuPricingInvocationHandler.<init>(Sku, BigDecimal)"})
  public void testNewDefaultDynamicSkuPricingInvocationHandler_thenReturnUnwrapHasRetailPrice2() {
    // Arrange
    SkuImpl sku = new SkuImpl();
    Money retailPrice = new Money();
    sku.setRetailPrice(retailPrice);

    // Act
    DefaultDynamicSkuPricingInvocationHandler actualDefaultDynamicSkuPricingInvocationHandler =
        new DefaultDynamicSkuPricingInvocationHandler(sku, new BigDecimal("2.3"));

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
   * Test {@link
   * DefaultDynamicSkuPricingInvocationHandler#DefaultDynamicSkuPricingInvocationHandler(Sku,
   * Money)}.
   *
   * <ul>
   *   <li>Then return unwrap hasRetailPrice.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultDynamicSkuPricingInvocationHandler#DefaultDynamicSkuPricingInvocationHandler(Sku,
   * Money)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DefaultDynamicSkuPricingInvocationHandler.<init>(Sku, Money)"})
  public void testNewDefaultDynamicSkuPricingInvocationHandler_thenReturnUnwrapHasRetailPrice3() {
    // Arrange
    SkuImpl sku = new SkuImpl();
    Money retailPrice = new Money();
    sku.setRetailPrice(retailPrice);

    // Act
    DefaultDynamicSkuPricingInvocationHandler actualDefaultDynamicSkuPricingInvocationHandler =
        new DefaultDynamicSkuPricingInvocationHandler(sku, new Money());

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
   * Test {@link
   * DefaultDynamicSkuPricingInvocationHandler#DefaultDynamicSkuPricingInvocationHandler(Sku)}.
   *
   * <ul>
   *   <li>Then return unwrap hasSalePrice.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultDynamicSkuPricingInvocationHandler#DefaultDynamicSkuPricingInvocationHandler(Sku)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DefaultDynamicSkuPricingInvocationHandler.<init>(Sku)"})
  public void testNewDefaultDynamicSkuPricingInvocationHandler_thenReturnUnwrapHasSalePrice() {
    // Arrange
    SkuImpl sku = new SkuImpl();
    Money salePrice = new Money();
    sku.setSalePrice(salePrice);

    // Act
    DefaultDynamicSkuPricingInvocationHandler actualDefaultDynamicSkuPricingInvocationHandler =
        new DefaultDynamicSkuPricingInvocationHandler(sku);

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
   * Test {@link
   * DefaultDynamicSkuPricingInvocationHandler#DefaultDynamicSkuPricingInvocationHandler(Sku,
   * BigDecimal)}.
   *
   * <ul>
   *   <li>Then return unwrap hasSalePrice.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultDynamicSkuPricingInvocationHandler#DefaultDynamicSkuPricingInvocationHandler(Sku,
   * BigDecimal)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DefaultDynamicSkuPricingInvocationHandler.<init>(Sku, BigDecimal)"})
  public void testNewDefaultDynamicSkuPricingInvocationHandler_thenReturnUnwrapHasSalePrice2() {
    // Arrange
    SkuImpl sku = new SkuImpl();
    Money salePrice = new Money();
    sku.setSalePrice(salePrice);

    // Act
    DefaultDynamicSkuPricingInvocationHandler actualDefaultDynamicSkuPricingInvocationHandler =
        new DefaultDynamicSkuPricingInvocationHandler(sku, new BigDecimal("2.3"));

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
   * Test {@link
   * DefaultDynamicSkuPricingInvocationHandler#DefaultDynamicSkuPricingInvocationHandler(Sku,
   * Money)}.
   *
   * <ul>
   *   <li>Then return unwrap hasSalePrice.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultDynamicSkuPricingInvocationHandler#DefaultDynamicSkuPricingInvocationHandler(Sku,
   * Money)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DefaultDynamicSkuPricingInvocationHandler.<init>(Sku, Money)"})
  public void testNewDefaultDynamicSkuPricingInvocationHandler_thenReturnUnwrapHasSalePrice3() {
    // Arrange
    SkuImpl sku = new SkuImpl();
    Money salePrice = new Money();
    sku.setSalePrice(salePrice);

    // Act
    DefaultDynamicSkuPricingInvocationHandler actualDefaultDynamicSkuPricingInvocationHandler =
        new DefaultDynamicSkuPricingInvocationHandler(sku, new Money());

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
   * Test {@link
   * DefaultDynamicSkuPricingInvocationHandler#DefaultDynamicSkuPricingInvocationHandler(BigDecimal)}.
   *
   * <ul>
   *   <li>Then unwrap return {@link SkuImpl}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultDynamicSkuPricingInvocationHandler#DefaultDynamicSkuPricingInvocationHandler(BigDecimal)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DefaultDynamicSkuPricingInvocationHandler.<init>(BigDecimal)"})
  public void testNewDefaultDynamicSkuPricingInvocationHandler_thenUnwrapReturnSkuImpl() {
    // Arrange and Act
    DefaultDynamicSkuPricingInvocationHandler actualDefaultDynamicSkuPricingInvocationHandler =
        new DefaultDynamicSkuPricingInvocationHandler((BigDecimal) null);

    // Assert
    Sku unwrapResult = actualDefaultDynamicSkuPricingInvocationHandler.unwrap();
    assertTrue(unwrapResult instanceof SkuImpl);
    assertTrue(actualDefaultDynamicSkuPricingInvocationHandler.delegate instanceof SkuImpl);
    assertNull(actualDefaultDynamicSkuPricingInvocationHandler.salePrice);
    assertSame(actualDefaultDynamicSkuPricingInvocationHandler.delegate, unwrapResult);
  }

  /**
   * Test {@link DefaultDynamicSkuPricingInvocationHandler#unwrap()}.
   *
   * <p>Method under test: {@link DefaultDynamicSkuPricingInvocationHandler#unwrap()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Sku DefaultDynamicSkuPricingInvocationHandler.unwrap()"})
  public void testUnwrap() {
    // Arrange
    DefaultDynamicSkuPricingInvocationHandler defaultDynamicSkuPricingInvocationHandler =
        new DefaultDynamicSkuPricingInvocationHandler(new BigDecimal("2.3"));

    // Act
    Sku actualUnwrapResult = defaultDynamicSkuPricingInvocationHandler.unwrap();

    // Assert
    assertSame(defaultDynamicSkuPricingInvocationHandler.delegate, actualUnwrapResult);
  }

  /**
   * Test {@link DefaultDynamicSkuPricingInvocationHandler#reset()}.
   *
   * <p>Method under test: {@link DefaultDynamicSkuPricingInvocationHandler#reset()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DefaultDynamicSkuPricingInvocationHandler.reset()"})
  public void testReset() {
    // Arrange
    DefaultDynamicSkuPricingInvocationHandler defaultDynamicSkuPricingInvocationHandler =
        new DefaultDynamicSkuPricingInvocationHandler(new BigDecimal("2.3"));

    // Act
    defaultDynamicSkuPricingInvocationHandler.reset();

    // Assert
    assertNull(defaultDynamicSkuPricingInvocationHandler.salePrice);
    assertNull(defaultDynamicSkuPricingInvocationHandler.unwrap());
    assertNull(defaultDynamicSkuPricingInvocationHandler.delegate);
  }
}
