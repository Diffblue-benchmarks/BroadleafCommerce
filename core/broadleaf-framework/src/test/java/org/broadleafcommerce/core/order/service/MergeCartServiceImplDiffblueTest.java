/*-
 * #%L
 * BroadleafCommerce Framework
 * %%
 * Copyright (C) 2009 - 2024 Broadleaf Commerce
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
package org.broadleafcommerce.core.order.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import org.broadleafcommerce.common.audit.Auditable;
import org.broadleafcommerce.common.currency.domain.BroadleafCurrencyImpl;
import org.broadleafcommerce.common.locale.domain.LocaleImpl;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.core.catalog.domain.Category;
import org.broadleafcommerce.core.catalog.domain.CategoryImpl;
import org.broadleafcommerce.core.catalog.domain.Product;
import org.broadleafcommerce.core.catalog.domain.ProductBundleImpl;
import org.broadleafcommerce.core.catalog.domain.SkuImpl;
import org.broadleafcommerce.core.order.domain.BundleOrderItemImpl;
import org.broadleafcommerce.core.order.domain.DiscreteOrderItem;
import org.broadleafcommerce.core.order.domain.DiscreteOrderItemImpl;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.Order;
import org.broadleafcommerce.core.order.domain.OrderImpl;
import org.broadleafcommerce.core.order.domain.OrderItem;
import org.broadleafcommerce.core.order.service.type.OrderStatus;
import org.broadleafcommerce.profile.core.domain.CustomerImpl;
import org.junit.Test;
import org.mockito.Mockito;

public class MergeCartServiceImplDiffblueTest {
  /**
   * Test {@link MergeCartServiceImpl#setSavedCartAttributes(Order)}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()}.</li>
   *   <li>Then {@link OrderImpl} (default constructor) Status Type is
   * {@code NAMED}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MergeCartServiceImpl#setSavedCartAttributes(Order)}
   */
  @Test
  public void testSetSavedCartAttributes_givenHashMap_thenOrderImplStatusTypeIsNamed() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MergeCartServiceImpl mergeCartServiceImpl = new MergeCartServiceImpl();

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    OrderImpl cart = new OrderImpl();
    cart.setAdditionalOfferInformation(new HashMap<>());
    cart.setAuditable(auditable);
    cart.setCandidateOrderOffers(new ArrayList<>());
    cart.setCurrency(new BroadleafCurrencyImpl());
    cart.setCustomer(new CustomerImpl());
    cart.setEmailAddress("42 Main St");
    cart.setFulfillmentGroups(new ArrayList<>());
    cart.setId(1L);
    cart.setLocale(new LocaleImpl());
    cart.setName("MMM dd, ''yy");
    cart.setOrderAttributes(new HashMap<>());
    cart.setOrderItems(new ArrayList<>());
    cart.setOrderMessages(new ArrayList<>());
    cart.setOrderNumber("42");
    cart.setPayments(new ArrayList<>());
    cart.setStatus(OrderStatus.ARCHIVED);
    cart.setSubTotal(new Money());
    cart.setSubmitDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    cart.setTaxOverride(true);
    cart.setTotal(new Money());
    cart.setTotalFulfillmentCharges(new Money());
    cart.setTotalShipping(new Money());
    cart.setTotalTax(new Money());

    // Act
    mergeCartServiceImpl.setSavedCartAttributes(cart);

    // Assert
    OrderStatus status = cart.getStatus();
    assertEquals("NAMED", status.getType());
    assertEquals("Named", status.getFriendlyType());
    assertTrue(status.isEditable());
  }

  /**
   * Test {@link MergeCartServiceImpl#setSavedCartAttributes(Order)}.
   * <ul>
   *   <li>Then calls {@link NullOrderImpl#getAuditable()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MergeCartServiceImpl#setSavedCartAttributes(Order)}
   */
  @Test
  public void testSetSavedCartAttributes_thenCallsGetAuditable() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MergeCartServiceImpl mergeCartServiceImpl = new MergeCartServiceImpl();

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);
    NullOrderImpl cart = mock(NullOrderImpl.class);
    doNothing().when(cart).setName(Mockito.<String>any());
    doNothing().when(cart).setStatus(Mockito.<OrderStatus>any());
    when(cart.getAuditable()).thenReturn(auditable);

    // Act
    mergeCartServiceImpl.setSavedCartAttributes(cart);

    // Assert
    verify(cart).getAuditable();
    verify(cart).setName(eq("Previously saved cart - Jan 01, '70"));
    verify(cart).setStatus(isA(OrderStatus.class));
  }

  /**
   * Test {@link MergeCartServiceImpl#checkActive(DiscreteOrderItem)}.
   * <ul>
   *   <li>Given {@link SkuImpl} {@link SkuImpl#isActive(Product, Category)} return
   * {@code true}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MergeCartServiceImpl#checkActive(DiscreteOrderItem)}
   */
  @Test
  public void testCheckActive_givenSkuImplIsActiveReturnTrue_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MergeCartServiceImpl mergeCartServiceImpl = new MergeCartServiceImpl();
    SkuImpl skuImpl = mock(SkuImpl.class);
    when(skuImpl.isActive(Mockito.<Product>any(), Mockito.<Category>any())).thenReturn(true);
    DiscreteOrderItem orderItem = mock(DiscreteOrderItem.class);
    when(orderItem.getCategory()).thenReturn(new CategoryImpl());
    when(orderItem.getProduct()).thenReturn(new ProductBundleImpl());
    when(orderItem.getSku()).thenReturn(skuImpl);

    // Act
    boolean actualCheckActiveResult = mergeCartServiceImpl.checkActive(orderItem);

    // Assert
    verify(skuImpl).isActive(isA(Product.class), isA(Category.class));
    verify(orderItem).getProduct();
    verify(orderItem).getSku();
    verify(orderItem).getCategory();
    assertTrue(actualCheckActiveResult);
  }

  /**
   * Test {@link MergeCartServiceImpl#checkActive(DiscreteOrderItem)}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MergeCartServiceImpl#checkActive(DiscreteOrderItem)}
   */
  @Test
  public void testCheckActive_givenSkuImpl_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MergeCartServiceImpl mergeCartServiceImpl = new MergeCartServiceImpl();
    DiscreteOrderItem orderItem = mock(DiscreteOrderItem.class);
    when(orderItem.getCategory()).thenReturn(new CategoryImpl());
    when(orderItem.getProduct()).thenReturn(new ProductBundleImpl());
    when(orderItem.getSku()).thenReturn(new SkuImpl());

    // Act
    boolean actualCheckActiveResult = mergeCartServiceImpl.checkActive(orderItem);

    // Assert
    verify(orderItem).getProduct();
    verify(orderItem).getSku();
    verify(orderItem).getCategory();
    assertFalse(actualCheckActiveResult);
  }

  /**
   * Test {@link MergeCartServiceImpl#checkInventory(DiscreteOrderItem)}.
   * <ul>
   *   <li>When {@link DiscreteOrderItemImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MergeCartServiceImpl#checkInventory(DiscreteOrderItem)}
   */
  @Test
  public void testCheckInventory_whenDiscreteOrderItemImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MergeCartServiceImpl mergeCartServiceImpl = new MergeCartServiceImpl();

    // Act and Assert
    assertTrue(mergeCartServiceImpl.checkInventory(new DiscreteOrderItemImpl()));
  }

  /**
   * Test {@link MergeCartServiceImpl#checkInventory(DiscreteOrderItem)}.
   * <ul>
   *   <li>When {@link DiscreteOrderItemImpl}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MergeCartServiceImpl#checkInventory(DiscreteOrderItem)}
   */
  @Test
  public void testCheckInventory_whenDiscreteOrderItemImpl2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new MergeCartServiceImpl()).checkInventory(mock(DiscreteOrderItemImpl.class)));
  }

  /**
   * Test {@link MergeCartServiceImpl#checkOtherValidity(OrderItem)}.
   * <ul>
   *   <li>When {@link BundleOrderItemImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link MergeCartServiceImpl#checkOtherValidity(OrderItem)}
   */
  @Test
  public void testCheckOtherValidity_whenBundleOrderItemImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MergeCartServiceImpl mergeCartServiceImpl = new MergeCartServiceImpl();

    // Act and Assert
    assertTrue(mergeCartServiceImpl.checkOtherValidity(new BundleOrderItemImpl()));
  }

  /**
   * Test {@link MergeCartServiceImpl#checkOtherValidity(OrderItem)}.
   * <ul>
   *   <li>When {@link BundleOrderItemImpl}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MergeCartServiceImpl#checkOtherValidity(OrderItem)}
   */
  @Test
  public void testCheckOtherValidity_whenBundleOrderItemImpl2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new MergeCartServiceImpl()).checkOtherValidity(mock(BundleOrderItemImpl.class)));
  }
}
