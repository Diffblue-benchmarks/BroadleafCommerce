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
package org.broadleafcommerce.core.catalog.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.math.BigDecimal;
import java.util.HashMap;
import org.broadleafcommerce.common.copy.CreateResponse;
import org.broadleafcommerce.common.copy.MultiTenantCopyContext;
import org.broadleafcommerce.common.money.Money;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml"})
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@RunWith(SpringJUnit4ClassRunner.class)
public class ProductOptionValueImplDiffblueTest {
  @Autowired private ProductOptionValueImpl productOptionValueImpl;

  /**
   * Test {@link ProductOptionValueImpl#getAttributeValue()}.
   *
   * <p>Method under test: {@link ProductOptionValueImpl#getAttributeValue()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ProductOptionValueImpl.getAttributeValue()"})
  public void testGetAttributeValue() {
    // Arrange, Act and Assert
    assertNull(productOptionValueImpl.getAttributeValue());
  }

  /**
   * Test {@link ProductOptionValueImpl#getPriceAdjustment()}.
   *
   * <ul>
   *   <li>Given {@link ProductOptionValueImpl}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ProductOptionValueImpl#getPriceAdjustment()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money ProductOptionValueImpl.getPriceAdjustment()"})
  public void testGetPriceAdjustment_givenProductOptionValueImpl_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(productOptionValueImpl.getPriceAdjustment());
  }

  /**
   * Test {@link ProductOptionValueImpl#getPriceAdjustment()}.
   *
   * <ul>
   *   <li>Then return {@link Money#Money()}.
   * </ul>
   *
   * <p>Method under test: {@link ProductOptionValueImpl#getPriceAdjustment()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money ProductOptionValueImpl.getPriceAdjustment()"})
  public void testGetPriceAdjustment_thenReturnMoney() {
    // Arrange
    Money priceAdjustment = new Money();
    productOptionValueImpl.setPriceAdjustment(priceAdjustment);

    // Act and Assert
    assertEquals(priceAdjustment, productOptionValueImpl.getPriceAdjustment());
  }

  /**
   * Test {@link ProductOptionValueImpl#getPriceAdjustmentSkipDynamicPricing()}.
   *
   * <ul>
   *   <li>Then return {@link Money#Money()}.
   * </ul>
   *
   * <p>Method under test: {@link ProductOptionValueImpl#getPriceAdjustmentSkipDynamicPricing()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money ProductOptionValueImpl.getPriceAdjustmentSkipDynamicPricing()"})
  public void testGetPriceAdjustmentSkipDynamicPricing_thenReturnMoney() {
    // Arrange
    Money priceAdjustment = new Money();
    productOptionValueImpl.setPriceAdjustment(priceAdjustment);

    // Act and Assert
    assertEquals(priceAdjustment, productOptionValueImpl.getPriceAdjustmentSkipDynamicPricing());
  }

  /**
   * Test {@link ProductOptionValueImpl#getPriceAdjustmentSkipDynamicPricing()}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ProductOptionValueImpl#getPriceAdjustmentSkipDynamicPricing()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money ProductOptionValueImpl.getPriceAdjustmentSkipDynamicPricing()"})
  public void testGetPriceAdjustmentSkipDynamicPricing_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(productOptionValueImpl.getPriceAdjustmentSkipDynamicPricing());
  }

  /**
   * Test {@link ProductOptionValueImpl#setPriceAdjustment(Money)}.
   *
   * <p>Method under test: {@link ProductOptionValueImpl#setPriceAdjustment(Money)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ProductOptionValueImpl.setPriceAdjustment(Money)"})
  public void testSetPriceAdjustment() {
    // Arrange
    Money priceAdjustment = new Money();

    // Act
    productOptionValueImpl.setPriceAdjustment(priceAdjustment);

    // Assert
    assertEquals(new BigDecimal("0.00"), productOptionValueImpl.priceAdjustment);
    BigDecimal bigDecimal = productOptionValueImpl.priceAdjustment;
    Money absResult = priceAdjustment.abs();
    assertSame(bigDecimal, absResult.getAmount());
    Money absResult2 = absResult.abs();
    assertSame(bigDecimal, absResult2.getAmount());
    assertSame(bigDecimal, absResult2.abs().getAmount());
    Money zeroResult = priceAdjustment.zero();
    Money absResult3 = zeroResult.abs();
    assertSame(bigDecimal, absResult3.abs().getAmount());
    assertSame(bigDecimal, absResult3.getAmount());
    Money zeroResult2 = absResult.zero();
    assertSame(bigDecimal, zeroResult2.abs().getAmount());
    Money zeroResult3 = zeroResult.zero();
    assertSame(bigDecimal, zeroResult3.abs().getAmount());
    assertSame(bigDecimal, zeroResult.getAmount());
    assertSame(bigDecimal, zeroResult2.getAmount());
    assertSame(bigDecimal, absResult2.zero().getAmount());
    assertSame(bigDecimal, absResult3.zero().getAmount());
    assertSame(bigDecimal, zeroResult3.getAmount());
    assertSame(bigDecimal, zeroResult2.zero().getAmount());
    assertSame(bigDecimal, zeroResult3.zero().getAmount());
  }

  /**
   * Test {@link ProductOptionValueImpl#setPriceAdjustment(Money)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link ProductOptionValueImpl} {@link ProductOptionValueImpl#priceAdjustment} is
   *       {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ProductOptionValueImpl#setPriceAdjustment(Money)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ProductOptionValueImpl.setPriceAdjustment(Money)"})
  public void testSetPriceAdjustment_whenNull_thenProductOptionValueImplPriceAdjustmentIsNull() {
    // Arrange and Act
    productOptionValueImpl.setPriceAdjustment(null);

    // Assert that nothing has changed
    assertNull(productOptionValueImpl.priceAdjustment);
  }

  /**
   * Test {@link ProductOptionValueImpl#equals(Object)}, and {@link
   * ProductOptionValueImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ProductOptionValueImpl#equals(Object)}
   *   <li>{@link ProductOptionValueImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ProductOptionValueImpl.equals(Object)",
    "int ProductOptionValueImpl.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ProductOptionValueImpl productOptionValueImpl = new ProductOptionValueImpl();
    productOptionValueImpl.setAttributeValue("42");
    productOptionValueImpl.setDisplayOrder(1L);
    productOptionValueImpl.setId(1L);
    productOptionValueImpl.setPriceAdjustment(new Money());
    productOptionValueImpl.setProductOption(new ProductOptionImpl());

    ProductOptionValueImpl productOptionValueImpl2 = new ProductOptionValueImpl();
    productOptionValueImpl2.setAttributeValue("42");
    productOptionValueImpl2.setDisplayOrder(1L);
    productOptionValueImpl2.setId(1L);
    productOptionValueImpl2.setPriceAdjustment(new Money());
    productOptionValueImpl2.setProductOption(new ProductOptionImpl());

    // Act and Assert
    assertEquals(productOptionValueImpl, productOptionValueImpl2);
    assertEquals(productOptionValueImpl.hashCode(), productOptionValueImpl2.hashCode());
  }

  /**
   * Test {@link ProductOptionValueImpl#equals(Object)}, and {@link
   * ProductOptionValueImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ProductOptionValueImpl#equals(Object)}
   *   <li>{@link ProductOptionValueImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ProductOptionValueImpl.equals(Object)",
    "int ProductOptionValueImpl.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    ProductOptionValueImpl productOptionValueImpl = new ProductOptionValueImpl();
    productOptionValueImpl.setAttributeValue("42");
    productOptionValueImpl.setDisplayOrder(1L);
    productOptionValueImpl.setId(null);
    productOptionValueImpl.setPriceAdjustment(new Money());
    productOptionValueImpl.setProductOption(new ProductOptionImpl());

    ProductOptionValueImpl productOptionValueImpl2 = new ProductOptionValueImpl();
    productOptionValueImpl2.setAttributeValue("42");
    productOptionValueImpl2.setDisplayOrder(1L);
    productOptionValueImpl2.setId(1L);
    productOptionValueImpl2.setPriceAdjustment(new Money());
    productOptionValueImpl2.setProductOption(new ProductOptionImpl());

    // Act and Assert
    assertEquals(productOptionValueImpl, productOptionValueImpl2);
    assertNotEquals(productOptionValueImpl.hashCode(), productOptionValueImpl2.hashCode());
  }

  /**
   * Test {@link ProductOptionValueImpl#equals(Object)}, and {@link
   * ProductOptionValueImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ProductOptionValueImpl#equals(Object)}
   *   <li>{@link ProductOptionValueImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ProductOptionValueImpl.equals(Object)",
    "int ProductOptionValueImpl.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    ProductOptionValueImpl productOptionValueImpl = new ProductOptionValueImpl();
    productOptionValueImpl.setAttributeValue("42");
    productOptionValueImpl.setDisplayOrder(1L);
    productOptionValueImpl.setId(1L);
    productOptionValueImpl.setPriceAdjustment(new Money());
    productOptionValueImpl.setProductOption(new ProductOptionImpl());

    ProductOptionValueImpl productOptionValueImpl2 = new ProductOptionValueImpl();
    productOptionValueImpl2.setAttributeValue("42");
    productOptionValueImpl2.setDisplayOrder(1L);
    productOptionValueImpl2.setId(null);
    productOptionValueImpl2.setPriceAdjustment(new Money());
    productOptionValueImpl2.setProductOption(new ProductOptionImpl());

    // Act and Assert
    assertEquals(productOptionValueImpl, productOptionValueImpl2);
    assertNotEquals(productOptionValueImpl.hashCode(), productOptionValueImpl2.hashCode());
  }

  /**
   * Test {@link ProductOptionValueImpl#equals(Object)}, and {@link
   * ProductOptionValueImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ProductOptionValueImpl#equals(Object)}
   *   <li>{@link ProductOptionValueImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ProductOptionValueImpl.equals(Object)",
    "int ProductOptionValueImpl.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    ProductOptionValueImpl productOptionValueImpl = new ProductOptionValueImpl();
    productOptionValueImpl.setAttributeValue(null);
    productOptionValueImpl.setDisplayOrder(1L);
    productOptionValueImpl.setId(null);
    productOptionValueImpl.setPriceAdjustment(new Money());
    productOptionValueImpl.setProductOption(new ProductOptionImpl());

    ProductOptionValueImpl productOptionValueImpl2 = new ProductOptionValueImpl();
    productOptionValueImpl2.setAttributeValue(null);
    productOptionValueImpl2.setDisplayOrder(1L);
    productOptionValueImpl2.setId(1L);
    productOptionValueImpl2.setPriceAdjustment(new Money());
    productOptionValueImpl2.setProductOption(new ProductOptionImpl());

    // Act and Assert
    assertEquals(productOptionValueImpl, productOptionValueImpl2);
    assertNotEquals(productOptionValueImpl.hashCode(), productOptionValueImpl2.hashCode());
  }

  /**
   * Test {@link ProductOptionValueImpl#equals(Object)}, and {@link
   * ProductOptionValueImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ProductOptionValueImpl#equals(Object)}
   *   <li>{@link ProductOptionValueImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ProductOptionValueImpl.equals(Object)",
    "int ProductOptionValueImpl.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ProductOptionValueImpl productOptionValueImpl = new ProductOptionValueImpl();
    productOptionValueImpl.setAttributeValue("42");
    productOptionValueImpl.setDisplayOrder(1L);
    productOptionValueImpl.setId(1L);
    productOptionValueImpl.setPriceAdjustment(new Money());
    productOptionValueImpl.setProductOption(new ProductOptionImpl());

    // Act and Assert
    assertEquals(productOptionValueImpl, productOptionValueImpl);
    int expectedHashCodeResult = productOptionValueImpl.hashCode();
    assertEquals(expectedHashCodeResult, productOptionValueImpl.hashCode());
  }

  /**
   * Test {@link ProductOptionValueImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ProductOptionValueImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ProductOptionValueImpl.equals(Object)",
    "int ProductOptionValueImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ProductOptionValueImpl productOptionValueImpl = new ProductOptionValueImpl();
    productOptionValueImpl.setAttributeValue("42");
    productOptionValueImpl.setDisplayOrder(1L);
    productOptionValueImpl.setId(2L);
    productOptionValueImpl.setPriceAdjustment(new Money());
    productOptionValueImpl.setProductOption(new ProductOptionImpl());

    ProductOptionValueImpl productOptionValueImpl2 = new ProductOptionValueImpl();
    productOptionValueImpl2.setAttributeValue("42");
    productOptionValueImpl2.setDisplayOrder(1L);
    productOptionValueImpl2.setId(1L);
    productOptionValueImpl2.setPriceAdjustment(new Money());
    productOptionValueImpl2.setProductOption(new ProductOptionImpl());

    // Act and Assert
    assertNotEquals(productOptionValueImpl, productOptionValueImpl2);
  }

  /**
   * Test {@link ProductOptionValueImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ProductOptionValueImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ProductOptionValueImpl.equals(Object)",
    "int ProductOptionValueImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ProductOptionValueImpl productOptionValueImpl = new ProductOptionValueImpl();
    productOptionValueImpl.setAttributeValue("Attribute Value");
    productOptionValueImpl.setDisplayOrder(1L);
    productOptionValueImpl.setId(null);
    productOptionValueImpl.setPriceAdjustment(new Money());
    productOptionValueImpl.setProductOption(new ProductOptionImpl());

    ProductOptionValueImpl productOptionValueImpl2 = new ProductOptionValueImpl();
    productOptionValueImpl2.setAttributeValue("42");
    productOptionValueImpl2.setDisplayOrder(1L);
    productOptionValueImpl2.setId(1L);
    productOptionValueImpl2.setPriceAdjustment(new Money());
    productOptionValueImpl2.setProductOption(new ProductOptionImpl());

    // Act and Assert
    assertNotEquals(productOptionValueImpl, productOptionValueImpl2);
  }

  /**
   * Test {@link ProductOptionValueImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ProductOptionValueImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ProductOptionValueImpl.equals(Object)",
    "int ProductOptionValueImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ProductOptionValueImpl productOptionValueImpl = new ProductOptionValueImpl();
    productOptionValueImpl.setAttributeValue(null);
    productOptionValueImpl.setDisplayOrder(1L);
    productOptionValueImpl.setId(null);
    productOptionValueImpl.setPriceAdjustment(new Money());
    productOptionValueImpl.setProductOption(new ProductOptionImpl());

    ProductOptionValueImpl productOptionValueImpl2 = new ProductOptionValueImpl();
    productOptionValueImpl2.setAttributeValue("42");
    productOptionValueImpl2.setDisplayOrder(1L);
    productOptionValueImpl2.setId(1L);
    productOptionValueImpl2.setPriceAdjustment(new Money());
    productOptionValueImpl2.setProductOption(new ProductOptionImpl());

    // Act and Assert
    assertNotEquals(productOptionValueImpl, productOptionValueImpl2);
  }

  /**
   * Test {@link ProductOptionValueImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ProductOptionValueImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ProductOptionValueImpl.equals(Object)",
    "int ProductOptionValueImpl.hashCode()"
  })
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    ProductOptionValueImpl productOptionValueImpl = new ProductOptionValueImpl();
    productOptionValueImpl.setAttributeValue("42");
    productOptionValueImpl.setDisplayOrder(1L);
    productOptionValueImpl.setId(1L);
    productOptionValueImpl.setPriceAdjustment(new Money());
    productOptionValueImpl.setProductOption(new ProductOptionImpl());

    // Act and Assert
    assertNotEquals(productOptionValueImpl, null);
  }

  /**
   * Test {@link ProductOptionValueImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ProductOptionValueImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ProductOptionValueImpl.equals(Object)",
    "int ProductOptionValueImpl.hashCode()"
  })
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    ProductOptionValueImpl productOptionValueImpl = new ProductOptionValueImpl();
    productOptionValueImpl.setAttributeValue("42");
    productOptionValueImpl.setDisplayOrder(1L);
    productOptionValueImpl.setId(1L);
    productOptionValueImpl.setPriceAdjustment(new Money());
    productOptionValueImpl.setProductOption(new ProductOptionImpl());

    // Act and Assert
    assertNotEquals(productOptionValueImpl, "Different type to ProductOptionValueImpl");
  }

  /**
   * Test {@link ProductOptionValueImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   *
   * <p>Method under test: {@link
   * ProductOptionValueImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CreateResponse ProductOptionValueImpl.createOrRetrieveCopyInstance(MultiTenantCopyContext)"
  })
  public void testCreateOrRetrieveCopyInstance() throws CloneNotSupportedException {
    // Arrange
    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    CreateResponse<Object> createResponse =
        new CreateResponse<>(new ProductOptionValueImpl(), true);
    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<ProductOptionValue> actualCreateOrRetrieveCopyInstanceResult =
        productOptionValueImpl.createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
  }

  /**
   * Test {@link ProductOptionValueImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   *
   * <p>Method under test: {@link
   * ProductOptionValueImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CreateResponse ProductOptionValueImpl.createOrRetrieveCopyInstance(MultiTenantCopyContext)"
  })
  public void testCreateOrRetrieveCopyInstance2() throws CloneNotSupportedException {
    // Arrange
    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    CreateResponse<Object> createResponse = new CreateResponse<>(productOptionValueImpl, false);
    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<ProductOptionValue> actualCreateOrRetrieveCopyInstanceResult =
        productOptionValueImpl.createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
  }

  /**
   * Test {@link ProductOptionValueImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   *
   * <p>Method under test: {@link
   * ProductOptionValueImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CreateResponse ProductOptionValueImpl.createOrRetrieveCopyInstance(MultiTenantCopyContext)"
  })
  public void testCreateOrRetrieveCopyInstance3() throws CloneNotSupportedException {
    // Arrange
    ProductOptionValueImpl productOptionValueImpl = new ProductOptionValueImpl();
    Money priceAdjustment = new Money();
    productOptionValueImpl.setPriceAdjustment(priceAdjustment);

    ProductOptionValueImpl productOptionValueImpl2 = new ProductOptionValueImpl();
    productOptionValueImpl2.setAttributeValue("42");
    productOptionValueImpl2.setDisplayOrder(1L);
    productOptionValueImpl2.setId(1L);
    productOptionValueImpl2.setPriceAdjustment(new Money());
    productOptionValueImpl2.setProductOption(new ProductOptionImpl());

    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any()))
        .thenReturn(new CreateResponse<>(productOptionValueImpl2, false));

    // Act
    CreateResponse<ProductOptionValue> actualCreateOrRetrieveCopyInstanceResult =
        productOptionValueImpl.createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    ProductOptionValue clone = actualCreateOrRetrieveCopyInstanceResult.getClone();
    assertTrue(clone instanceof ProductOptionValueImpl);
    assertEquals(new BigDecimal("0.00"), ((ProductOptionValueImpl) clone).priceAdjustment);
    assertEquals(priceAdjustment, clone.getPriceAdjustment());
    assertEquals(priceAdjustment, clone.getPriceAdjustmentSkipDynamicPricing());
  }

  /**
   * Test {@link ProductOptionValueImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   *
   * <p>Method under test: {@link
   * ProductOptionValueImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CreateResponse ProductOptionValueImpl.createOrRetrieveCopyInstance(MultiTenantCopyContext)"
  })
  public void testCreateOrRetrieveCopyInstance4() throws CloneNotSupportedException {
    // Arrange
    ProductOptionImpl productOption = mock(ProductOptionImpl.class);
    ProductOptionImpl productOptionImpl = new ProductOptionImpl();
    when(productOption.createOrRetrieveCopyInstance(Mockito.<MultiTenantCopyContext>any()))
        .thenReturn(new CreateResponse<>(productOptionImpl, true));

    ProductOptionValueImpl productOptionValueImpl = new ProductOptionValueImpl();
    productOptionValueImpl.setProductOption(productOption);

    ProductOptionValueImpl productOptionValueImpl2 = new ProductOptionValueImpl();
    productOptionValueImpl2.setAttributeValue("42");
    productOptionValueImpl2.setDisplayOrder(1L);
    productOptionValueImpl2.setId(1L);
    productOptionValueImpl2.setPriceAdjustment(new Money());
    productOptionValueImpl2.setProductOption(new ProductOptionImpl());
    CreateResponse<Object> createResponse = new CreateResponse<>(productOptionValueImpl2, false);

    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    when(context.getCopyHints()).thenReturn(new HashMap<>());
    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<ProductOptionValue> actualCreateOrRetrieveCopyInstanceResult =
        productOptionValueImpl.createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    verify(context).getCopyHints();
    verify(productOption).createOrRetrieveCopyInstance(isA(MultiTenantCopyContext.class));
    ProductOptionValue clone = actualCreateOrRetrieveCopyInstanceResult.getClone();
    ProductOption productOption2 = clone.getProductOption();
    assertTrue(productOption2 instanceof ProductOptionImpl);
    assertTrue(clone instanceof ProductOptionValueImpl);
    assertSame(productOptionImpl, productOption2);
  }

  /**
   * Test {@link ProductOptionValueImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@code MANUAL_DUPLICATION} is {@code Copy Hints}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ProductOptionValueImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CreateResponse ProductOptionValueImpl.createOrRetrieveCopyInstance(MultiTenantCopyContext)"
  })
  public void testCreateOrRetrieveCopyInstance_givenHashMapManualDuplicationIsCopyHints()
      throws CloneNotSupportedException {
    // Arrange
    ProductOptionValueImpl productOptionValueImpl = new ProductOptionValueImpl();
    ProductOptionImpl productOption = new ProductOptionImpl();
    productOptionValueImpl.setProductOption(productOption);

    ProductOptionValueImpl productOptionValueImpl2 = new ProductOptionValueImpl();
    productOptionValueImpl2.setAttributeValue("42");
    productOptionValueImpl2.setDisplayOrder(1L);
    productOptionValueImpl2.setId(1L);
    productOptionValueImpl2.setPriceAdjustment(new Money());
    productOptionValueImpl2.setProductOption(new ProductOptionImpl());
    CreateResponse<Object> createResponse = new CreateResponse<>(productOptionValueImpl2, false);

    HashMap<String, String> stringStringMap = new HashMap<>();
    stringStringMap.put("MANUAL_DUPLICATION", "Copy Hints");

    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    when(context.getCopyHints()).thenReturn(stringStringMap);
    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<ProductOptionValue> actualCreateOrRetrieveCopyInstanceResult =
        productOptionValueImpl.createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    verify(context).getCopyHints();
    ProductOptionValue clone = actualCreateOrRetrieveCopyInstanceResult.getClone();
    ProductOption productOption2 = clone.getProductOption();
    assertTrue(productOption2 instanceof ProductOptionImpl);
    assertTrue(clone instanceof ProductOptionValueImpl);
    assertSame(productOption, productOption2);
  }

  /**
   * Test {@link ProductOptionValueImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   *
   * <ul>
   *   <li>Then throw {@link CloneNotSupportedException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ProductOptionValueImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CreateResponse ProductOptionValueImpl.createOrRetrieveCopyInstance(MultiTenantCopyContext)"
  })
  public void testCreateOrRetrieveCopyInstance_thenThrowCloneNotSupportedException()
      throws CloneNotSupportedException {
    // Arrange
    ProductOptionImpl productOption = mock(ProductOptionImpl.class);
    when(productOption.createOrRetrieveCopyInstance(Mockito.<MultiTenantCopyContext>any()))
        .thenThrow(new CloneNotSupportedException());

    ProductOptionValueImpl productOptionValueImpl = new ProductOptionValueImpl();
    productOptionValueImpl.setProductOption(productOption);

    ProductOptionValueImpl productOptionValueImpl2 = new ProductOptionValueImpl();
    productOptionValueImpl2.setAttributeValue("42");
    productOptionValueImpl2.setDisplayOrder(1L);
    productOptionValueImpl2.setId(1L);
    productOptionValueImpl2.setPriceAdjustment(new Money());
    productOptionValueImpl2.setProductOption(new ProductOptionImpl());
    CreateResponse<Object> createResponse = new CreateResponse<>(productOptionValueImpl2, false);

    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    when(context.getCopyHints()).thenReturn(new HashMap<>());
    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act and Assert
    assertThrows(
        CloneNotSupportedException.class,
        () -> productOptionValueImpl.createOrRetrieveCopyInstance(context));
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    verify(context).getCopyHints();
    verify(productOption).createOrRetrieveCopyInstance(isA(MultiTenantCopyContext.class));
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link ProductOptionValueImpl}
   *   <li>{@link ProductOptionValueImpl#setAttributeValue(String)}
   *   <li>{@link ProductOptionValueImpl#setDisplayOrder(Long)}
   *   <li>{@link ProductOptionValueImpl#setId(Long)}
   *   <li>{@link ProductOptionValueImpl#setProductOption(ProductOption)}
   *   <li>{@link ProductOptionValueImpl#getDisplayOrder()}
   *   <li>{@link ProductOptionValueImpl#getId()}
   *   <li>{@link ProductOptionValueImpl#getProductOption()}
   *   <li>{@link ProductOptionValueImpl#getRawAttributeValue()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ProductOptionValueImpl.<init>()",
    "Long ProductOptionValueImpl.getDisplayOrder()",
    "Long ProductOptionValueImpl.getId()",
    "ProductOption ProductOptionValueImpl.getProductOption()",
    "String ProductOptionValueImpl.getRawAttributeValue()",
    "void ProductOptionValueImpl.setAttributeValue(String)",
    "void ProductOptionValueImpl.setDisplayOrder(Long)",
    "void ProductOptionValueImpl.setId(Long)",
    "void ProductOptionValueImpl.setProductOption(ProductOption)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    ProductOptionValueImpl actualProductOptionValueImpl = new ProductOptionValueImpl();
    actualProductOptionValueImpl.setAttributeValue("42");
    actualProductOptionValueImpl.setDisplayOrder(1L);
    actualProductOptionValueImpl.setId(1L);
    ProductOptionImpl productOption = new ProductOptionImpl();
    actualProductOptionValueImpl.setProductOption(productOption);
    Long actualDisplayOrder = actualProductOptionValueImpl.getDisplayOrder();
    Long actualId = actualProductOptionValueImpl.getId();
    ProductOption actualProductOption = actualProductOptionValueImpl.getProductOption();

    // Assert
    assertEquals("42", actualProductOptionValueImpl.getRawAttributeValue());
    assertEquals(1L, actualDisplayOrder.longValue());
    assertEquals(1L, actualId.longValue());
    assertSame(productOption, actualProductOption);
  }
}
