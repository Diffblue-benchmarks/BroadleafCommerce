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
package org.broadleafcommerce.core.order.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.broadleafcommerce.common.copy.CreateResponse;
import org.broadleafcommerce.common.copy.MultiTenantCopyContext;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.core.catalog.domain.Product;
import org.broadleafcommerce.core.catalog.domain.ProductBundleImpl;
import org.broadleafcommerce.core.catalog.domain.Sku;
import org.broadleafcommerce.core.catalog.domain.SkuBundleItem;
import org.broadleafcommerce.core.catalog.domain.SkuBundleItemImpl;
import org.broadleafcommerce.core.catalog.domain.SkuImpl;
import org.broadleafcommerce.core.order.service.type.OrderItemType;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {DiscreteOrderItemImpl.class})
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@RunWith(SpringJUnit4ClassRunner.class)
public class DiscreteOrderItemImplDiffblueTest {
  @Autowired private DiscreteOrderItemImpl discreteOrderItemImpl;

  /**
   * Test {@link DiscreteOrderItemImpl#setSku(Sku)}.
   *
   * <ul>
   *   <li>Then {@link DiscreteOrderItemImpl} {@link DiscreteOrderItemImpl#baseRetailPrice} is
   *       {@link BigDecimal#BigDecimal(String)} with {@code 0.00}.
   * </ul>
   *
   * <p>Method under test: {@link DiscreteOrderItemImpl#setSku(Sku)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DiscreteOrderItemImpl.setSku(Sku)"})
  public void testSetSku_thenDiscreteOrderItemImplBaseRetailPriceIsBigDecimalWith000() {
    // Arrange
    SkuImpl sku = new SkuImpl();
    sku.setRetailPrice(new Money());

    // Act
    discreteOrderItemImpl.setSku(sku);

    // Assert
    assertEquals(new BigDecimal("0.00"), discreteOrderItemImpl.baseRetailPrice);
    BigDecimal bigDecimal = discreteOrderItemImpl.baseRetailPrice;
    assertSame(bigDecimal, sku.getListPrice().getAmount());
    assertSame(bigDecimal, sku.getMargin().getAmount());
    assertSame(bigDecimal, sku.getPrice().getAmount());
    assertSame(bigDecimal, sku.getRetailPrice().getAmount());
  }

  /**
   * Test {@link DiscreteOrderItemImpl#setSku(Sku)}.
   *
   * <ul>
   *   <li>When {@link SkuImpl} (default constructor).
   *   <li>Then {@link SkuImpl} (default constructor) Margin Amount is {@link
   *       BigDecimal#BigDecimal(String)} with {@code 0.00}.
   * </ul>
   *
   * <p>Method under test: {@link DiscreteOrderItemImpl#setSku(Sku)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DiscreteOrderItemImpl.setSku(Sku)"})
  public void testSetSku_whenSkuImpl_thenSkuImplMarginAmountIsBigDecimalWith000() {
    // Arrange
    SkuImpl sku = new SkuImpl();

    // Act
    discreteOrderItemImpl.setSku(sku);

    // Assert that nothing has changed
    assertEquals(new BigDecimal("0.00"), sku.getMargin().getAmount());
  }

  /**
   * Test {@link DiscreteOrderItemImpl#getProduct()}.
   *
   * <ul>
   *   <li>Then return {@link ProductBundleImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link DiscreteOrderItemImpl#getProduct()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Product DiscreteOrderItemImpl.getProduct()"})
  public void testGetProduct_thenReturnProductBundleImpl() {
    // Arrange
    DiscreteOrderItemImpl discreteOrderItemImpl = new DiscreteOrderItemImpl();
    ProductBundleImpl product = new ProductBundleImpl();
    discreteOrderItemImpl.setProduct(product);

    // Act and Assert
    assertSame(product, discreteOrderItemImpl.getProduct());
  }

  /**
   * Test {@link DiscreteOrderItemImpl#updateSalePrice()}.
   *
   * <ul>
   *   <li>Given {@link DiscreteOrderItemImpl} (default constructor) Price is {@link Money#Money()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link DiscreteOrderItemImpl#updateSalePrice()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DiscreteOrderItemImpl.updateSalePrice()"})
  public void testUpdateSalePrice_givenDiscreteOrderItemImplPriceIsMoney_thenReturnFalse() {
    // Arrange
    DiscreteOrderItemImpl discreteOrderItemImpl = new DiscreteOrderItemImpl();
    discreteOrderItemImpl.setPrice(new Money());

    // Act and Assert
    assertFalse(discreteOrderItemImpl.updateSalePrice());
  }

  /**
   * Test {@link DiscreteOrderItemImpl#updateRetailPrice()}.
   *
   * <ul>
   *   <li>Given {@link DiscreteOrderItemImpl} (default constructor) Price is {@link Money#Money()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link DiscreteOrderItemImpl#updateRetailPrice()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DiscreteOrderItemImpl.updateRetailPrice()"})
  public void testUpdateRetailPrice_givenDiscreteOrderItemImplPriceIsMoney_thenReturnFalse() {
    // Arrange
    DiscreteOrderItemImpl discreteOrderItemImpl = new DiscreteOrderItemImpl();
    discreteOrderItemImpl.setPrice(new Money());

    // Act and Assert
    assertFalse(discreteOrderItemImpl.updateRetailPrice());
  }

  /**
   * Test {@link DiscreteOrderItemImpl#updateRetailPrice()}.
   *
   * <ul>
   *   <li>Given {@link DiscreteOrderItemImpl}.
   *   <li>Then throw {@link NullPointerException}.
   * </ul>
   *
   * <p>Method under test: {@link DiscreteOrderItemImpl#updateRetailPrice()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DiscreteOrderItemImpl.updateRetailPrice()"})
  public void testUpdateRetailPrice_givenDiscreteOrderItemImpl_thenThrowNullPointerException() {
    // Arrange, Act and Assert
    assertThrows(NullPointerException.class, () -> discreteOrderItemImpl.updateRetailPrice());
  }

  /**
   * Test {@link DiscreteOrderItemImpl#updateSaleAndRetailPrices()}.
   *
   * <ul>
   *   <li>Given {@link DiscreteOrderItemImpl} (default constructor) Price is {@link Money#Money()}.
   * </ul>
   *
   * <p>Method under test: {@link DiscreteOrderItemImpl#updateSaleAndRetailPrices()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DiscreteOrderItemImpl.updateSaleAndRetailPrices()"})
  public void testUpdateSaleAndRetailPrices_givenDiscreteOrderItemImplPriceIsMoney() {
    // Arrange
    DiscreteOrderItemImpl discreteOrderItemImpl = new DiscreteOrderItemImpl();
    discreteOrderItemImpl.setPrice(new Money());

    // Act and Assert
    assertFalse(discreteOrderItemImpl.updateSaleAndRetailPrices());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DiscreteOrderItemImpl#setAdditionalAttributes(Map)}
   *   <li>{@link DiscreteOrderItemImpl#setDiscreteOrderItemFeePrices(List)}
   *   <li>{@link DiscreteOrderItemImpl#setProduct(Product)}
   *   <li>{@link DiscreteOrderItemImpl#setSkuBundleItem(SkuBundleItem)}
   *   <li>{@link DiscreteOrderItemImpl#getAdditionalAttributes()}
   *   <li>{@link DiscreteOrderItemImpl#getBundleOrderItem()}
   *   <li>{@link DiscreteOrderItemImpl#getDiscreteOrderItemFeePrices()}
   *   <li>{@link DiscreteOrderItemImpl#getSkuBundleItem()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Map DiscreteOrderItemImpl.getAdditionalAttributes()",
    "BundleOrderItem DiscreteOrderItemImpl.getBundleOrderItem()",
    "List DiscreteOrderItemImpl.getDiscreteOrderItemFeePrices()",
    "SkuBundleItem DiscreteOrderItemImpl.getSkuBundleItem()",
    "void DiscreteOrderItemImpl.setAdditionalAttributes(Map)",
    "void DiscreteOrderItemImpl.setDiscreteOrderItemFeePrices(List)",
    "void DiscreteOrderItemImpl.setProduct(Product)",
    "void DiscreteOrderItemImpl.setSkuBundleItem(SkuBundleItem)"
  })
  public void testGettersAndSetters() {
    // Arrange
    DiscreteOrderItemImpl discreteOrderItemImpl = new DiscreteOrderItemImpl();
    HashMap<String, String> additionalAttributes = new HashMap<>();

    // Act
    discreteOrderItemImpl.setAdditionalAttributes(additionalAttributes);
    ArrayList<DiscreteOrderItemFeePrice> discreteOrderItemFeePrices = new ArrayList<>();
    discreteOrderItemImpl.setDiscreteOrderItemFeePrices(discreteOrderItemFeePrices);
    discreteOrderItemImpl.setProduct(new ProductBundleImpl());
    SkuBundleItemImpl SkuBundleItem = new SkuBundleItemImpl();
    discreteOrderItemImpl.setSkuBundleItem(SkuBundleItem);
    Map<String, String> actualAdditionalAttributes =
        discreteOrderItemImpl.getAdditionalAttributes();
    BundleOrderItem actualBundleOrderItem = discreteOrderItemImpl.getBundleOrderItem();
    List<DiscreteOrderItemFeePrice> actualDiscreteOrderItemFeePrices =
        discreteOrderItemImpl.getDiscreteOrderItemFeePrices();
    SkuBundleItem actualSkuBundleItem = discreteOrderItemImpl.getSkuBundleItem();

    // Assert
    assertNull(actualBundleOrderItem);
    assertTrue(actualDiscreteOrderItemFeePrices.isEmpty());
    assertTrue(actualAdditionalAttributes.isEmpty());
    assertSame(discreteOrderItemFeePrices, actualDiscreteOrderItemFeePrices);
    assertSame(additionalAttributes, actualAdditionalAttributes);
    assertSame(SkuBundleItem, actualSkuBundleItem);
  }

  /**
   * Test {@link DiscreteOrderItemImpl#isDiscountingAllowed()}.
   *
   * <ul>
   *   <li>Given {@link DiscreteOrderItemImpl} (default constructor) Price is {@link Money#Money()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link DiscreteOrderItemImpl#isDiscountingAllowed()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DiscreteOrderItemImpl.isDiscountingAllowed()"})
  public void testIsDiscountingAllowed_givenDiscreteOrderItemImplPriceIsMoney_thenReturnFalse() {
    // Arrange
    DiscreteOrderItemImpl discreteOrderItemImpl = new DiscreteOrderItemImpl();
    discreteOrderItemImpl.setPrice(new Money());

    // Act and Assert
    assertFalse(discreteOrderItemImpl.isDiscountingAllowed());
  }

  /**
   * Test {@link DiscreteOrderItemImpl#isDiscountingAllowed()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link DiscreteOrderItemImpl#isDiscountingAllowed()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DiscreteOrderItemImpl.isDiscountingAllowed()"})
  public void testIsDiscountingAllowed_thenReturnTrue() {
    // Arrange
    DiscreteOrderItemImpl discreteOrderItemImpl = new DiscreteOrderItemImpl();
    discreteOrderItemImpl.setDiscountingAllowed(true);

    // Act and Assert
    assertTrue(discreteOrderItemImpl.isDiscountingAllowed());
  }

  /**
   * Test {@link DiscreteOrderItemImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DiscreteOrderItemImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CreateResponse DiscreteOrderItemImpl.createOrRetrieveCopyInstance(MultiTenantCopyContext)"
  })
  public void testCreateOrRetrieveCopyInstance_thenThrowIllegalStateException()
      throws CloneNotSupportedException {
    // Arrange
    DiscreteOrderItemImpl discreteOrderItemImpl = new DiscreteOrderItemImpl();
    discreteOrderItemImpl.setParentOrderItem(new BundleOrderItemImpl());

    BundleOrderItemImpl bundleOrderItemImpl = mock(BundleOrderItemImpl.class);
    doThrow(new IllegalStateException())
        .when(bundleOrderItemImpl)
        .setBaseRetailPrice(Mockito.<Money>any());
    doNothing().when(bundleOrderItemImpl).finalizePrice();
    doNothing()
        .when(bundleOrderItemImpl)
        .setCategory(Mockito.<org.broadleafcommerce.core.catalog.domain.Category>any());
    doNothing().when(bundleOrderItemImpl).setGiftWrapOrderItem(Mockito.<GiftWrapOrderItem>any());
    doNothing().when(bundleOrderItemImpl).setName(Mockito.<String>any());
    doNothing().when(bundleOrderItemImpl).setOrder(Mockito.<Order>any());
    doNothing().when(bundleOrderItemImpl).setOrderItemType(Mockito.<OrderItemType>any());
    doNothing().when(bundleOrderItemImpl).setParentOrderItem(Mockito.<OrderItem>any());
    doNothing().when(bundleOrderItemImpl).setPersonalMessage(Mockito.<PersonalMessage>any());
    doNothing().when(bundleOrderItemImpl).setQuantity(anyInt());
    doNothing().when(bundleOrderItemImpl).setTaxable(Mockito.<Boolean>any());

    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any()))
        .thenReturn(new CreateResponse<>(bundleOrderItemImpl, false));

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () -> discreteOrderItemImpl.createOrRetrieveCopyInstance(context));
    verify(context, atLeast(1)).createOrRetrieveCopyInstance(Mockito.<Object>any());
    verify(bundleOrderItemImpl).setBaseRetailPrice(isNull());
    verify(bundleOrderItemImpl).finalizePrice();
    verify(bundleOrderItemImpl, atLeast(1)).setCategory(isNull());
    verify(bundleOrderItemImpl).setGiftWrapOrderItem(isNull());
    verify(bundleOrderItemImpl, atLeast(1)).setName(null);
    verify(bundleOrderItemImpl, atLeast(1)).setOrder(isNull());
    verify(bundleOrderItemImpl, atLeast(1)).setOrderItemType(isNull());
    verify(bundleOrderItemImpl).setParentOrderItem(isNull());
    verify(bundleOrderItemImpl, atLeast(1)).setPersonalMessage(isNull());
    verify(bundleOrderItemImpl, atLeast(1)).setQuantity(0);
    verify(bundleOrderItemImpl, atLeast(1)).setTaxable(true);
  }
}
