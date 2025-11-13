package org.broadleafcommerce.core.catalog.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.math.BigDecimal;
import org.broadleafcommerce.common.money.Money;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;

@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class SkuBundleItemImplDiffblueTest {
  /**
   * Test {@link SkuBundleItemImpl#clearDynamicPrices()}.
   *
   * <ul>
   *   <li>Given {@link Sku} {@link Sku#getId()} return one.
   *   <li>Then {@link SkuBundleItemImpl} (default constructor) {@link SkuBundleItemImpl#sku}.
   * </ul>
   *
   * <p>Method under test: {@link SkuBundleItemImpl#clearDynamicPrices()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SkuBundleItemImpl.clearDynamicPrices()"})
  public void testClearDynamicPrices_givenSkuGetIdReturnOne_thenSkuBundleItemImplSku() {
    // Arrange
    Sku sku = mock(Sku.class);
    when(sku.getId()).thenReturn(1L);
    doNothing().when(sku).clearDynamicPrices();

    SkuBundleItemImpl skuBundleItemImpl = new SkuBundleItemImpl();
    skuBundleItemImpl.setBundle(new ProductBundleImpl());
    skuBundleItemImpl.setId(1L);
    skuBundleItemImpl.setQuantity(1);
    skuBundleItemImpl.setSalePrice(new Money());
    skuBundleItemImpl.setSequence(new BigDecimal("2.3"));
    skuBundleItemImpl.setSku(sku);

    // Act
    skuBundleItemImpl.clearDynamicPrices();

    // Assert
    verify(sku).clearDynamicPrices();
    verify(sku).getId();
    Sku expectedSku = skuBundleItemImpl.sku;
    assertSame(expectedSku, skuBundleItemImpl.getSku());
  }

  /**
   * Test {@link SkuBundleItemImpl#clearDynamicPrices()}.
   *
   * <ul>
   *   <li>Then {@link SkuBundleItemImpl} (default constructor) Sku {@link SkuImpl}.
   * </ul>
   *
   * <p>Method under test: {@link SkuBundleItemImpl#clearDynamicPrices()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SkuBundleItemImpl.clearDynamicPrices()"})
  public void testClearDynamicPrices_thenSkuBundleItemImplSkuSkuImpl() {
    // Arrange
    SkuBundleItemImpl skuBundleItemImpl = new SkuBundleItemImpl();
    skuBundleItemImpl.setBundle(new ProductBundleImpl());
    skuBundleItemImpl.setId(1L);
    skuBundleItemImpl.setQuantity(1);
    skuBundleItemImpl.setSalePrice(new Money());
    skuBundleItemImpl.setSequence(new BigDecimal("2.3"));
    SkuImpl sku = new SkuImpl();
    skuBundleItemImpl.setSku(sku);

    // Act
    skuBundleItemImpl.clearDynamicPrices();

    // Assert
    Sku sku2 = skuBundleItemImpl.getSku();
    assertTrue(sku2 instanceof SkuImpl);
    assertTrue(skuBundleItemImpl.deproxiedSku instanceof SkuImpl);
    assertSame(sku, sku2);
  }

  /**
   * Test {@link SkuBundleItemImpl#equals(Object)}, and {@link SkuBundleItemImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SkuBundleItemImpl#equals(Object)}
   *   <li>{@link SkuBundleItemImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SkuBundleItemImpl.equals(Object)",
    "int SkuBundleItemImpl.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    SkuBundleItemImpl skuBundleItemImpl = new SkuBundleItemImpl();
    skuBundleItemImpl.setBundle(new ProductBundleImpl());
    skuBundleItemImpl.setId(1L);
    skuBundleItemImpl.setQuantity(1);
    skuBundleItemImpl.setSalePrice(new Money());
    skuBundleItemImpl.setSequence(new BigDecimal("2.3"));
    skuBundleItemImpl.setSku(new SkuImpl());

    SkuBundleItemImpl skuBundleItemImpl2 = new SkuBundleItemImpl();
    skuBundleItemImpl2.setBundle(new ProductBundleImpl());
    skuBundleItemImpl2.setId(1L);
    skuBundleItemImpl2.setQuantity(1);
    skuBundleItemImpl2.setSalePrice(new Money());
    skuBundleItemImpl2.setSequence(new BigDecimal("2.3"));
    skuBundleItemImpl2.setSku(new SkuImpl());

    // Act and Assert
    assertEquals(skuBundleItemImpl, skuBundleItemImpl2);
    assertEquals(skuBundleItemImpl.hashCode(), skuBundleItemImpl2.hashCode());
  }

  /**
   * Test {@link SkuBundleItemImpl#equals(Object)}, and {@link SkuBundleItemImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SkuBundleItemImpl#equals(Object)}
   *   <li>{@link SkuBundleItemImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SkuBundleItemImpl.equals(Object)",
    "int SkuBundleItemImpl.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    SkuBundleItemImpl skuBundleItemImpl = new SkuBundleItemImpl();
    skuBundleItemImpl.setBundle(new ProductBundleImpl());
    skuBundleItemImpl.setId(1L);
    skuBundleItemImpl.setQuantity(1);
    skuBundleItemImpl.setSalePrice(new Money());
    skuBundleItemImpl.setSequence(new BigDecimal("2.3"));
    skuBundleItemImpl.setSku(new SkuImpl());

    // Act and Assert
    assertEquals(skuBundleItemImpl, skuBundleItemImpl);
    int expectedHashCodeResult = skuBundleItemImpl.hashCode();
    assertEquals(expectedHashCodeResult, skuBundleItemImpl.hashCode());
  }

  /**
   * Test {@link SkuBundleItemImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SkuBundleItemImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SkuBundleItemImpl.equals(Object)",
    "int SkuBundleItemImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    SkuBundleItemImpl skuBundleItemImpl = new SkuBundleItemImpl();
    skuBundleItemImpl.setBundle(new ProductBundleImpl());
    skuBundleItemImpl.setId(2L);
    skuBundleItemImpl.setQuantity(1);
    skuBundleItemImpl.setSalePrice(new Money());
    skuBundleItemImpl.setSequence(new BigDecimal("2.3"));
    skuBundleItemImpl.setSku(new SkuImpl());

    SkuBundleItemImpl skuBundleItemImpl2 = new SkuBundleItemImpl();
    skuBundleItemImpl2.setBundle(new ProductBundleImpl());
    skuBundleItemImpl2.setId(1L);
    skuBundleItemImpl2.setQuantity(1);
    skuBundleItemImpl2.setSalePrice(new Money());
    skuBundleItemImpl2.setSequence(new BigDecimal("2.3"));
    skuBundleItemImpl2.setSku(new SkuImpl());

    // Act and Assert
    assertNotEquals(skuBundleItemImpl, skuBundleItemImpl2);
  }

  /**
   * Test {@link SkuBundleItemImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SkuBundleItemImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SkuBundleItemImpl.equals(Object)",
    "int SkuBundleItemImpl.hashCode()"
  })
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    SkuBundleItemImpl skuBundleItemImpl = new SkuBundleItemImpl();
    skuBundleItemImpl.setBundle(new ProductBundleImpl());
    skuBundleItemImpl.setId(1L);
    skuBundleItemImpl.setQuantity(1);
    skuBundleItemImpl.setSalePrice(new Money());
    skuBundleItemImpl.setSequence(new BigDecimal("2.3"));
    skuBundleItemImpl.setSku(new SkuImpl());

    // Act and Assert
    assertNotEquals(skuBundleItemImpl, null);
  }

  /**
   * Test {@link SkuBundleItemImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SkuBundleItemImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SkuBundleItemImpl.equals(Object)",
    "int SkuBundleItemImpl.hashCode()"
  })
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    SkuBundleItemImpl skuBundleItemImpl = new SkuBundleItemImpl();
    skuBundleItemImpl.setBundle(new ProductBundleImpl());
    skuBundleItemImpl.setId(1L);
    skuBundleItemImpl.setQuantity(1);
    skuBundleItemImpl.setSalePrice(new Money());
    skuBundleItemImpl.setSequence(new BigDecimal("2.3"));
    skuBundleItemImpl.setSku(new SkuImpl());

    // Act and Assert
    assertNotEquals(skuBundleItemImpl, "Different type to SkuBundleItemImpl");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link SkuBundleItemImpl}
   *   <li>{@link SkuBundleItemImpl#setBundle(ProductBundle)}
   *   <li>{@link SkuBundleItemImpl#setId(Long)}
   *   <li>{@link SkuBundleItemImpl#setQuantity(Integer)}
   *   <li>{@link SkuBundleItemImpl#setSequence(BigDecimal)}
   *   <li>{@link SkuBundleItemImpl#setSku(Sku)}
   *   <li>{@link SkuBundleItemImpl#getId()}
   *   <li>{@link SkuBundleItemImpl#getQuantity()}
   *   <li>{@link SkuBundleItemImpl#getSequence()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SkuBundleItemImpl.<init>()",
    "Long SkuBundleItemImpl.getId()",
    "Integer SkuBundleItemImpl.getQuantity()",
    "BigDecimal SkuBundleItemImpl.getSequence()",
    "void SkuBundleItemImpl.setBundle(ProductBundle)",
    "void SkuBundleItemImpl.setId(Long)",
    "void SkuBundleItemImpl.setQuantity(Integer)",
    "void SkuBundleItemImpl.setSequence(BigDecimal)",
    "void SkuBundleItemImpl.setSku(Sku)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    SkuBundleItemImpl actualSkuBundleItemImpl = new SkuBundleItemImpl();
    actualSkuBundleItemImpl.setBundle(new ProductBundleImpl());
    actualSkuBundleItemImpl.setId(1L);
    actualSkuBundleItemImpl.setQuantity(1);
    BigDecimal sequence = new BigDecimal("2.3");
    actualSkuBundleItemImpl.setSequence(sequence);
    actualSkuBundleItemImpl.setSku(new SkuImpl());
    Long actualId = actualSkuBundleItemImpl.getId();
    Integer actualQuantity = actualSkuBundleItemImpl.getQuantity();
    BigDecimal actualSequence = actualSkuBundleItemImpl.getSequence();

    // Assert
    assertEquals(1, actualQuantity.intValue());
    assertEquals(1L, actualId.longValue());
    assertEquals(new BigDecimal("2.3"), actualSequence);
    assertSame(sequence, actualSequence);
  }
}
