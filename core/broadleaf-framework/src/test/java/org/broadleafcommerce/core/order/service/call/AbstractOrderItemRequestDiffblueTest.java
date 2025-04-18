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
package org.broadleafcommerce.core.order.service.call;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.Map;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.core.catalog.domain.CategoryImpl;
import org.broadleafcommerce.core.catalog.domain.Product;
import org.broadleafcommerce.core.catalog.domain.ProductBundleImpl;
import org.broadleafcommerce.core.catalog.domain.Sku;
import org.broadleafcommerce.core.catalog.domain.SkuImpl;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.Order;
import org.broadleafcommerce.core.order.domain.PersonalMessage;
import org.broadleafcommerce.core.order.domain.PersonalMessageImpl;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mockito.Mockito;

public class AbstractOrderItemRequestDiffblueTest {
  /**
   * Test {@link AbstractOrderItemRequest#getSku()}.
   * <p>
   * Method under test: {@link AbstractOrderItemRequest#getSku()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Sku AbstractOrderItemRequest.getSku()"})
  public void testGetSku() {
    // Arrange, Act and Assert
    assertNull((new DiscreteOrderItemRequest()).getSku());
  }

  /**
   * Test {@link AbstractOrderItemRequest#getCategory()}.
   * <p>
   * Method under test: {@link AbstractOrderItemRequest#getCategory()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"org.broadleafcommerce.core.catalog.domain.Category AbstractOrderItemRequest.getCategory()"})
  public void testGetCategory() {
    // Arrange, Act and Assert
    assertNull((new DiscreteOrderItemRequest()).getCategory());
  }

  /**
   * Test {@link AbstractOrderItemRequest#setCategory(Category)}.
   * <p>
   * Method under test: {@link AbstractOrderItemRequest#setCategory(org.broadleafcommerce.core.catalog.domain.Category)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AbstractOrderItemRequest.setCategory(org.broadleafcommerce.core.catalog.domain.Category)"})
  public void testSetCategory() {
    // Arrange
    DiscreteOrderItemRequest discreteOrderItemRequest = new DiscreteOrderItemRequest();
    CategoryImpl category = new CategoryImpl();

    // Act
    discreteOrderItemRequest.setCategory(category);

    // Assert
    assertSame(category, discreteOrderItemRequest.getCategory());
  }

  /**
   * Test {@link AbstractOrderItemRequest#getProduct()}.
   * <p>
   * Method under test: {@link AbstractOrderItemRequest#getProduct()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Product AbstractOrderItemRequest.getProduct()"})
  public void testGetProduct() {
    // Arrange, Act and Assert
    assertNull((new DiscreteOrderItemRequest()).getProduct());
  }

  /**
   * Test {@link AbstractOrderItemRequest#getOrder()}.
   * <p>
   * Method under test: {@link AbstractOrderItemRequest#getOrder()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Order AbstractOrderItemRequest.getOrder()"})
  public void testGetOrder() {
    // Arrange, Act and Assert
    assertNull((new DiscreteOrderItemRequest()).getOrder());
  }

  /**
   * Test {@link AbstractOrderItemRequest#getQuantity()}.
   * <p>
   * Method under test: {@link AbstractOrderItemRequest#getQuantity()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int AbstractOrderItemRequest.getQuantity()"})
  public void testGetQuantity() {
    // Arrange, Act and Assert
    assertEquals(0, (new DiscreteOrderItemRequest()).getQuantity());
  }

  /**
   * Test {@link AbstractOrderItemRequest#setQuantity(int)}.
   * <p>
   * Method under test: {@link AbstractOrderItemRequest#setQuantity(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AbstractOrderItemRequest.setQuantity(int)"})
  public void testSetQuantity() {
    // Arrange
    DiscreteOrderItemRequest discreteOrderItemRequest = new DiscreteOrderItemRequest();

    // Act
    discreteOrderItemRequest.setQuantity(1);

    // Assert
    assertEquals(1, discreteOrderItemRequest.getQuantity());
  }

  /**
   * Test {@link AbstractOrderItemRequest#getItemAttributes()}.
   * <p>
   * Method under test: {@link AbstractOrderItemRequest#getItemAttributes()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map AbstractOrderItemRequest.getItemAttributes()"})
  public void testGetItemAttributes() {
    // Arrange, Act and Assert
    assertTrue((new DiscreteOrderItemRequest()).getItemAttributes().isEmpty());
  }

  /**
   * Test {@link AbstractOrderItemRequest#setItemAttributes(Map)}.
   * <p>
   * Method under test: {@link AbstractOrderItemRequest#setItemAttributes(Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AbstractOrderItemRequest.setItemAttributes(Map)"})
  public void testSetItemAttributes() {
    // Arrange
    DiscreteOrderItemRequest discreteOrderItemRequest = new DiscreteOrderItemRequest();
    HashMap<String, String> itemAttributes = new HashMap<>();

    // Act
    discreteOrderItemRequest.setItemAttributes(itemAttributes);

    // Assert
    assertSame(itemAttributes, discreteOrderItemRequest.getItemAttributes());
  }

  /**
   * Test {@link AbstractOrderItemRequest#getAdditionalAttributes()}.
   * <p>
   * Method under test: {@link AbstractOrderItemRequest#getAdditionalAttributes()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map AbstractOrderItemRequest.getAdditionalAttributes()"})
  public void testGetAdditionalAttributes() {
    // Arrange, Act and Assert
    assertTrue((new DiscreteOrderItemRequest()).getAdditionalAttributes().isEmpty());
  }

  /**
   * Test {@link AbstractOrderItemRequest#setAdditionalAttributes(Map)}.
   * <p>
   * Method under test: {@link AbstractOrderItemRequest#setAdditionalAttributes(Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AbstractOrderItemRequest.setAdditionalAttributes(Map)"})
  public void testSetAdditionalAttributes() {
    // Arrange
    DiscreteOrderItemRequest discreteOrderItemRequest = new DiscreteOrderItemRequest();
    HashMap<String, String> additionalAttributes = new HashMap<>();

    // Act
    discreteOrderItemRequest.setAdditionalAttributes(additionalAttributes);

    // Assert
    assertSame(additionalAttributes, discreteOrderItemRequest.getAdditionalAttributes());
  }

  /**
   * Test {@link AbstractOrderItemRequest#getSalePriceOverride()}.
   * <p>
   * Method under test: {@link AbstractOrderItemRequest#getSalePriceOverride()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money AbstractOrderItemRequest.getSalePriceOverride()"})
  public void testGetSalePriceOverride() {
    // Arrange, Act and Assert
    assertNull((new DiscreteOrderItemRequest()).getSalePriceOverride());
  }

  /**
   * Test {@link AbstractOrderItemRequest#getRetailPriceOverride()}.
   * <p>
   * Method under test: {@link AbstractOrderItemRequest#getRetailPriceOverride()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money AbstractOrderItemRequest.getRetailPriceOverride()"})
  public void testGetRetailPriceOverride() {
    // Arrange, Act and Assert
    assertNull((new DiscreteOrderItemRequest()).getRetailPriceOverride());
  }

  /**
   * Test {@link AbstractOrderItemRequest#copyProperties(AbstractOrderItemRequest)}.
   * <ul>
   *   <li>Then calls {@link AbstractOrderItemRequest#setAdditionalAttributes(Map)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractOrderItemRequest#copyProperties(AbstractOrderItemRequest)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AbstractOrderItemRequest.copyProperties(AbstractOrderItemRequest)"})
  public void testCopyProperties_thenCallsSetAdditionalAttributes() {
    // Arrange
    DiscreteOrderItemRequest discreteOrderItemRequest = new DiscreteOrderItemRequest();
    GiftWrapOrderItemRequest newRequest = mock(GiftWrapOrderItemRequest.class);
    doNothing().when(newRequest).setAdditionalAttributes(Mockito.<Map<String, String>>any());
    doNothing().when(newRequest).setCategory(Mockito.<org.broadleafcommerce.core.catalog.domain.Category>any());
    doNothing().when(newRequest).setItemAttributes(Mockito.<Map<String, String>>any());
    doNothing().when(newRequest).setOrder(Mockito.<Order>any());
    doNothing().when(newRequest).setPersonalMessage(Mockito.<PersonalMessage>any());
    doNothing().when(newRequest).setProduct(Mockito.<Product>any());
    doNothing().when(newRequest).setQuantity(anyInt());
    doNothing().when(newRequest).setRetailPriceOverride(Mockito.<Money>any());
    doNothing().when(newRequest).setSalePriceOverride(Mockito.<Money>any());
    doNothing().when(newRequest).setSku(Mockito.<Sku>any());

    // Act
    discreteOrderItemRequest.copyProperties(newRequest);

    // Assert
    verify(newRequest).setAdditionalAttributes(isA(Map.class));
    verify(newRequest).setCategory(isNull());
    verify(newRequest).setItemAttributes(isA(Map.class));
    verify(newRequest).setOrder(isNull());
    verify(newRequest).setPersonalMessage(isNull());
    verify(newRequest).setProduct(isNull());
    verify(newRequest).setQuantity(eq(0));
    verify(newRequest).setRetailPriceOverride(isNull());
    verify(newRequest).setSalePriceOverride(isNull());
    verify(newRequest).setSku(isNull());
  }

  /**
   * Test {@link AbstractOrderItemRequest#equals(Object)}, and {@link AbstractOrderItemRequest#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AbstractOrderItemRequest#equals(Object)}
   *   <li>{@link AbstractOrderItemRequest#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AbstractOrderItemRequest.equals(Object)", "int AbstractOrderItemRequest.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    DiscreteOrderItemRequest discreteOrderItemRequest = new DiscreteOrderItemRequest();
    DiscreteOrderItemRequest discreteOrderItemRequest2 = new DiscreteOrderItemRequest();

    // Act and Assert
    assertEquals(discreteOrderItemRequest, discreteOrderItemRequest2);
    int expectedHashCodeResult = discreteOrderItemRequest.hashCode();
    assertEquals(expectedHashCodeResult, discreteOrderItemRequest2.hashCode());
  }

  /**
   * Test {@link AbstractOrderItemRequest#equals(Object)}, and {@link AbstractOrderItemRequest#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AbstractOrderItemRequest#equals(Object)}
   *   <li>{@link AbstractOrderItemRequest#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AbstractOrderItemRequest.equals(Object)", "int AbstractOrderItemRequest.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    DiscreteOrderItemRequest discreteOrderItemRequest = new DiscreteOrderItemRequest();
    discreteOrderItemRequest.setSku(new SkuImpl());

    DiscreteOrderItemRequest discreteOrderItemRequest2 = new DiscreteOrderItemRequest();
    discreteOrderItemRequest2.setSku(new SkuImpl());

    // Act and Assert
    assertEquals(discreteOrderItemRequest, discreteOrderItemRequest2);
    int expectedHashCodeResult = discreteOrderItemRequest.hashCode();
    assertEquals(expectedHashCodeResult, discreteOrderItemRequest2.hashCode());
  }

  /**
   * Test {@link AbstractOrderItemRequest#equals(Object)}, and {@link AbstractOrderItemRequest#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AbstractOrderItemRequest#equals(Object)}
   *   <li>{@link AbstractOrderItemRequest#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AbstractOrderItemRequest.equals(Object)", "int AbstractOrderItemRequest.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    DiscreteOrderItemRequest discreteOrderItemRequest = new DiscreteOrderItemRequest();
    discreteOrderItemRequest.setCategory(new CategoryImpl());

    DiscreteOrderItemRequest discreteOrderItemRequest2 = new DiscreteOrderItemRequest();
    discreteOrderItemRequest2.setCategory(new CategoryImpl());

    // Act and Assert
    assertEquals(discreteOrderItemRequest, discreteOrderItemRequest2);
    int expectedHashCodeResult = discreteOrderItemRequest.hashCode();
    assertEquals(expectedHashCodeResult, discreteOrderItemRequest2.hashCode());
  }

  /**
   * Test {@link AbstractOrderItemRequest#equals(Object)}, and {@link AbstractOrderItemRequest#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AbstractOrderItemRequest#equals(Object)}
   *   <li>{@link AbstractOrderItemRequest#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AbstractOrderItemRequest.equals(Object)", "int AbstractOrderItemRequest.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    DiscreteOrderItemRequest discreteOrderItemRequest = new DiscreteOrderItemRequest();
    discreteOrderItemRequest.setProduct(new ProductBundleImpl());

    DiscreteOrderItemRequest discreteOrderItemRequest2 = new DiscreteOrderItemRequest();
    discreteOrderItemRequest2.setProduct(new ProductBundleImpl());

    // Act and Assert
    assertEquals(discreteOrderItemRequest, discreteOrderItemRequest2);
    int expectedHashCodeResult = discreteOrderItemRequest.hashCode();
    assertEquals(expectedHashCodeResult, discreteOrderItemRequest2.hashCode());
  }

  /**
   * Test {@link AbstractOrderItemRequest#equals(Object)}, and {@link AbstractOrderItemRequest#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AbstractOrderItemRequest#equals(Object)}
   *   <li>{@link AbstractOrderItemRequest#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AbstractOrderItemRequest.equals(Object)", "int AbstractOrderItemRequest.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual5() {
    // Arrange
    DiscreteOrderItemRequest discreteOrderItemRequest = new DiscreteOrderItemRequest();
    discreteOrderItemRequest.setSalePriceOverride(new Money());

    DiscreteOrderItemRequest discreteOrderItemRequest2 = new DiscreteOrderItemRequest();
    discreteOrderItemRequest2.setSalePriceOverride(new Money());

    // Act and Assert
    assertEquals(discreteOrderItemRequest, discreteOrderItemRequest2);
    int expectedHashCodeResult = discreteOrderItemRequest.hashCode();
    assertEquals(expectedHashCodeResult, discreteOrderItemRequest2.hashCode());
  }

  /**
   * Test {@link AbstractOrderItemRequest#equals(Object)}, and {@link AbstractOrderItemRequest#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AbstractOrderItemRequest#equals(Object)}
   *   <li>{@link AbstractOrderItemRequest#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AbstractOrderItemRequest.equals(Object)", "int AbstractOrderItemRequest.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    DiscreteOrderItemRequest discreteOrderItemRequest = new DiscreteOrderItemRequest();

    // Act and Assert
    assertEquals(discreteOrderItemRequest, discreteOrderItemRequest);
    int expectedHashCodeResult = discreteOrderItemRequest.hashCode();
    assertEquals(expectedHashCodeResult, discreteOrderItemRequest.hashCode());
  }

  /**
   * Test {@link AbstractOrderItemRequest#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractOrderItemRequest#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AbstractOrderItemRequest.equals(Object)", "int AbstractOrderItemRequest.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    GiftWrapOrderItemRequest giftWrapOrderItemRequest = new GiftWrapOrderItemRequest();

    // Act and Assert
    assertNotEquals(giftWrapOrderItemRequest, new DiscreteOrderItemRequest());
  }

  /**
   * Test {@link AbstractOrderItemRequest#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractOrderItemRequest#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AbstractOrderItemRequest.equals(Object)", "int AbstractOrderItemRequest.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    DiscreteOrderItemRequest discreteOrderItemRequest = new DiscreteOrderItemRequest();
    discreteOrderItemRequest.setSku(new SkuImpl());

    // Act and Assert
    assertNotEquals(discreteOrderItemRequest, new DiscreteOrderItemRequest());
  }

  /**
   * Test {@link AbstractOrderItemRequest#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractOrderItemRequest#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AbstractOrderItemRequest.equals(Object)", "int AbstractOrderItemRequest.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    DiscreteOrderItemRequest discreteOrderItemRequest = new DiscreteOrderItemRequest();
    discreteOrderItemRequest.setCategory(new CategoryImpl());

    // Act and Assert
    assertNotEquals(discreteOrderItemRequest, new DiscreteOrderItemRequest());
  }

  /**
   * Test {@link AbstractOrderItemRequest#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractOrderItemRequest#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AbstractOrderItemRequest.equals(Object)", "int AbstractOrderItemRequest.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    DiscreteOrderItemRequest discreteOrderItemRequest = new DiscreteOrderItemRequest();
    discreteOrderItemRequest.setProduct(new ProductBundleImpl());

    // Act and Assert
    assertNotEquals(discreteOrderItemRequest, new DiscreteOrderItemRequest());
  }

  /**
   * Test {@link AbstractOrderItemRequest#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractOrderItemRequest#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AbstractOrderItemRequest.equals(Object)", "int AbstractOrderItemRequest.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    DiscreteOrderItemRequest discreteOrderItemRequest = new DiscreteOrderItemRequest();
    discreteOrderItemRequest.setOrder(new NullOrderImpl());

    // Act and Assert
    assertNotEquals(discreteOrderItemRequest, new DiscreteOrderItemRequest());
  }

  /**
   * Test {@link AbstractOrderItemRequest#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractOrderItemRequest#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AbstractOrderItemRequest.equals(Object)", "int AbstractOrderItemRequest.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    DiscreteOrderItemRequest discreteOrderItemRequest = new DiscreteOrderItemRequest();
    discreteOrderItemRequest.setQuantity(1);

    // Act and Assert
    assertNotEquals(discreteOrderItemRequest, new DiscreteOrderItemRequest());
  }

  /**
   * Test {@link AbstractOrderItemRequest#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractOrderItemRequest#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AbstractOrderItemRequest.equals(Object)", "int AbstractOrderItemRequest.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    DiscreteOrderItemRequest discreteOrderItemRequest = new DiscreteOrderItemRequest();
    discreteOrderItemRequest.setSalePriceOverride(new Money());

    // Act and Assert
    assertNotEquals(discreteOrderItemRequest, new DiscreteOrderItemRequest());
  }

  /**
   * Test {@link AbstractOrderItemRequest#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractOrderItemRequest#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AbstractOrderItemRequest.equals(Object)", "int AbstractOrderItemRequest.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    DiscreteOrderItemRequest discreteOrderItemRequest = new DiscreteOrderItemRequest();

    DiscreteOrderItemRequest discreteOrderItemRequest2 = new DiscreteOrderItemRequest();
    discreteOrderItemRequest2.setSku(new SkuImpl());

    // Act and Assert
    assertNotEquals(discreteOrderItemRequest, discreteOrderItemRequest2);
  }

  /**
   * Test {@link AbstractOrderItemRequest#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractOrderItemRequest#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AbstractOrderItemRequest.equals(Object)", "int AbstractOrderItemRequest.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    DiscreteOrderItemRequest discreteOrderItemRequest = new DiscreteOrderItemRequest();

    DiscreteOrderItemRequest discreteOrderItemRequest2 = new DiscreteOrderItemRequest();
    discreteOrderItemRequest2.setCategory(new CategoryImpl());

    // Act and Assert
    assertNotEquals(discreteOrderItemRequest, discreteOrderItemRequest2);
  }

  /**
   * Test {@link AbstractOrderItemRequest#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractOrderItemRequest#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AbstractOrderItemRequest.equals(Object)", "int AbstractOrderItemRequest.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    DiscreteOrderItemRequest discreteOrderItemRequest = new DiscreteOrderItemRequest();

    DiscreteOrderItemRequest discreteOrderItemRequest2 = new DiscreteOrderItemRequest();
    discreteOrderItemRequest2.setProduct(new ProductBundleImpl());

    // Act and Assert
    assertNotEquals(discreteOrderItemRequest, discreteOrderItemRequest2);
  }

  /**
   * Test {@link AbstractOrderItemRequest#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractOrderItemRequest#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AbstractOrderItemRequest.equals(Object)", "int AbstractOrderItemRequest.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    DiscreteOrderItemRequest discreteOrderItemRequest = new DiscreteOrderItemRequest();

    DiscreteOrderItemRequest discreteOrderItemRequest2 = new DiscreteOrderItemRequest();
    discreteOrderItemRequest2.setOrder(new NullOrderImpl());

    // Act and Assert
    assertNotEquals(discreteOrderItemRequest, discreteOrderItemRequest2);
  }

  /**
   * Test {@link AbstractOrderItemRequest#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractOrderItemRequest#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AbstractOrderItemRequest.equals(Object)", "int AbstractOrderItemRequest.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
    // Arrange
    DiscreteOrderItemRequest discreteOrderItemRequest = new DiscreteOrderItemRequest();

    DiscreteOrderItemRequest discreteOrderItemRequest2 = new DiscreteOrderItemRequest();
    discreteOrderItemRequest2.setSalePriceOverride(new Money());

    // Act and Assert
    assertNotEquals(discreteOrderItemRequest, discreteOrderItemRequest2);
  }

  /**
   * Test {@link AbstractOrderItemRequest#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractOrderItemRequest#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AbstractOrderItemRequest.equals(Object)", "int AbstractOrderItemRequest.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new DiscreteOrderItemRequest(), null);
  }

  /**
   * Test {@link AbstractOrderItemRequest#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractOrderItemRequest#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AbstractOrderItemRequest.equals(Object)", "int AbstractOrderItemRequest.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new DiscreteOrderItemRequest(), "Different type to AbstractOrderItemRequest");
  }

  /**
   * Test {@link AbstractOrderItemRequest#getPersonalMessage()}.
   * <p>
   * Method under test: {@link AbstractOrderItemRequest#getPersonalMessage()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PersonalMessage AbstractOrderItemRequest.getPersonalMessage()"})
  public void testGetPersonalMessage() {
    // Arrange, Act and Assert
    assertNull((new DiscreteOrderItemRequest()).getPersonalMessage());
  }

  /**
   * Test {@link AbstractOrderItemRequest#setPersonalMessage(PersonalMessage)}.
   * <p>
   * Method under test: {@link AbstractOrderItemRequest#setPersonalMessage(PersonalMessage)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AbstractOrderItemRequest.setPersonalMessage(PersonalMessage)"})
  public void testSetPersonalMessage() {
    // Arrange
    DiscreteOrderItemRequest discreteOrderItemRequest = new DiscreteOrderItemRequest();
    PersonalMessageImpl personalMessage = new PersonalMessageImpl();

    // Act
    discreteOrderItemRequest.setPersonalMessage(personalMessage);

    // Assert
    assertSame(personalMessage, discreteOrderItemRequest.getPersonalMessage());
  }
}
