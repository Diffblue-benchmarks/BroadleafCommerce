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
package org.broadleafcommerce.core.order.dao;

import static org.junit.Assert.assertSame;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import org.broadleafcommerce.common.audit.Auditable;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.common.persistence.EntityConfiguration;
import org.broadleafcommerce.core.order.domain.BundleOrderItemImpl;
import org.broadleafcommerce.core.order.domain.GiftWrapOrderItemImpl;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.OrderItem;
import org.broadleafcommerce.core.order.domain.OrderItemPriceDetail;
import org.broadleafcommerce.core.order.domain.OrderItemPriceDetailImpl;
import org.broadleafcommerce.core.order.domain.OrderItemQualifier;
import org.broadleafcommerce.core.order.domain.OrderItemQualifierImpl;
import org.broadleafcommerce.core.order.domain.PersonalMessage;
import org.broadleafcommerce.core.order.domain.PersonalMessageImpl;
import org.broadleafcommerce.core.order.service.type.OrderItemType;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class OrderItemDaoImplDiffblueTest {
  @Mock
  private EntityConfiguration entityConfiguration;

  @InjectMocks
  private OrderItemDaoImpl orderItemDaoImpl;

  /**
   * Test {@link OrderItemDaoImpl#create(OrderItemType)}.
   * <ul>
   *   <li>Given {@link Auditable} (default constructor) CreatedBy is one.</li>
   *   <li>When {@link OrderItemType#BASIC}.</li>
   *   <li>Then return {@link BundleOrderItemImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderItemDaoImpl#create(OrderItemType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"OrderItem OrderItemDaoImpl.create(OrderItemType)"})
  public void testCreate_givenAuditableCreatedByIsOne_whenBasic_thenReturnBundleOrderItemImpl() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    BundleOrderItemImpl bundleOrderItemImpl = new BundleOrderItemImpl();
    bundleOrderItemImpl.setAuditable(auditable);
    bundleOrderItemImpl.setBaseRetailPrice(new Money());
    bundleOrderItemImpl.setBaseSalePrice(new Money());
    bundleOrderItemImpl.setBundleOrderItemFeePrices(new ArrayList<>());
    bundleOrderItemImpl.setCandidateItemOffers(new ArrayList<>());
    bundleOrderItemImpl.setCartMessages(new ArrayList<>());
    bundleOrderItemImpl.setChildOrderItems(new ArrayList<>());
    bundleOrderItemImpl.setDiscountingAllowed(true);
    bundleOrderItemImpl.setDiscreteOrderItems(new ArrayList<>());
    bundleOrderItemImpl.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    bundleOrderItemImpl.setHasValidationError(true);
    bundleOrderItemImpl.setId(1L);
    bundleOrderItemImpl.setName("Name");
    bundleOrderItemImpl.setOrder(new NullOrderImpl());
    bundleOrderItemImpl.setOrderItemAdjustments(new ArrayList<>());
    bundleOrderItemImpl.setOrderItemAttributes(new HashMap<>());
    bundleOrderItemImpl.setOrderItemPriceDetails(new ArrayList<>());
    bundleOrderItemImpl.setOrderItemQualifiers(new ArrayList<>());
    bundleOrderItemImpl.setOrderItemType(OrderItemType.BASIC);
    bundleOrderItemImpl.setParentOrderItem(new BundleOrderItemImpl());
    bundleOrderItemImpl.setPersonalMessage(new PersonalMessageImpl());
    bundleOrderItemImpl.setProratedOrderItemAdjustments(new ArrayList<>());
    bundleOrderItemImpl.setQuantity(1);
    bundleOrderItemImpl.setRetailPrice(new Money());
    bundleOrderItemImpl.setRetailPriceOverride(true);
    bundleOrderItemImpl.setSalePrice(new Money());
    bundleOrderItemImpl.setSalePriceOverride(true);
    bundleOrderItemImpl.setTaxable(true);
    bundleOrderItemImpl.updateSaleAndRetailPrices();
    when(entityConfiguration.createEntityInstance(Mockito.<String>any())).thenReturn(bundleOrderItemImpl);

    // Act
    OrderItem actualCreateResult = orderItemDaoImpl.create(OrderItemType.BASIC);

    // Assert
    verify(entityConfiguration).createEntityInstance(eq("org.broadleafcommerce.core.order.domain.OrderItem"));
    assertSame(bundleOrderItemImpl, actualCreateResult);
  }

  /**
   * Test {@link OrderItemDaoImpl#createPersonalMessage()}.
   * <p>
   * Method under test: {@link OrderItemDaoImpl#createPersonalMessage()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PersonalMessage OrderItemDaoImpl.createPersonalMessage()"})
  public void testCreatePersonalMessage() {
    // Arrange
    PersonalMessageImpl personalMessageImpl = new PersonalMessageImpl();
    personalMessageImpl.setId(1L);
    personalMessageImpl.setMessage("Not all who wander are lost");
    personalMessageImpl.setMessageFrom("jane.doe@example.org");
    personalMessageImpl.setMessageTo("alice.liddell@example.org");
    personalMessageImpl.setOccasion("Occasion");
    when(entityConfiguration.createEntityInstance(Mockito.<String>any())).thenReturn(personalMessageImpl);

    // Act
    PersonalMessage actualCreatePersonalMessageResult = orderItemDaoImpl.createPersonalMessage();

    // Assert
    verify(entityConfiguration).createEntityInstance(eq("org.broadleafcommerce.core.order.domain.PersonalMessage"));
    assertSame(personalMessageImpl, actualCreatePersonalMessageResult);
  }

  /**
   * Test {@link OrderItemDaoImpl#createOrderItemPriceDetail()}.
   * <p>
   * Method under test: {@link OrderItemDaoImpl#createOrderItemPriceDetail()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"OrderItemPriceDetail OrderItemDaoImpl.createOrderItemPriceDetail()"})
  public void testCreateOrderItemPriceDetail() {
    // Arrange
    OrderItemPriceDetailImpl orderItemPriceDetailImpl = new OrderItemPriceDetailImpl();
    orderItemPriceDetailImpl.setId(1L);
    orderItemPriceDetailImpl.setOrderItem(new BundleOrderItemImpl());
    orderItemPriceDetailImpl.setOrderItemAdjustments(new ArrayList<>());
    orderItemPriceDetailImpl.setQuantity(1);
    orderItemPriceDetailImpl.setUseSalePrice(true);
    when(entityConfiguration.createEntityInstance(Mockito.<String>any())).thenReturn(orderItemPriceDetailImpl);

    // Act
    OrderItemPriceDetail actualCreateOrderItemPriceDetailResult = orderItemDaoImpl.createOrderItemPriceDetail();

    // Assert
    verify(entityConfiguration)
        .createEntityInstance(eq("org.broadleafcommerce.core.order.domain.OrderItemPriceDetail"));
    assertSame(orderItemPriceDetailImpl, actualCreateOrderItemPriceDetailResult);
  }

  /**
   * Test {@link OrderItemDaoImpl#createOrderItemQualifier()}.
   * <p>
   * Method under test: {@link OrderItemDaoImpl#createOrderItemQualifier()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"OrderItemQualifier OrderItemDaoImpl.createOrderItemQualifier()"})
  public void testCreateOrderItemQualifier() {
    // Arrange
    OrderItemQualifierImpl orderItemQualifierImpl = new OrderItemQualifierImpl();
    orderItemQualifierImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    orderItemQualifierImpl.setOrderItem(new BundleOrderItemImpl());
    orderItemQualifierImpl.setQuantity(OrderItemQualifierImpl.serialVersionUID);
    when(entityConfiguration.createEntityInstance(Mockito.<String>any())).thenReturn(orderItemQualifierImpl);

    // Act
    OrderItemQualifier actualCreateOrderItemQualifierResult = orderItemDaoImpl.createOrderItemQualifier();

    // Assert
    verify(entityConfiguration).createEntityInstance(eq("org.broadleafcommerce.core.order.domain.OrderItemQualifier"));
    assertSame(orderItemQualifierImpl, actualCreateOrderItemQualifierResult);
  }

  /**
   * Test {@link OrderItemDaoImpl#initializeOrderItemPriceDetails(OrderItem)}.
   * <ul>
   *   <li>Then return {@link OrderItemPriceDetailImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderItemDaoImpl#initializeOrderItemPriceDetails(OrderItem)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"OrderItemPriceDetail OrderItemDaoImpl.initializeOrderItemPriceDetails(OrderItem)"})
  public void testInitializeOrderItemPriceDetails_thenReturnOrderItemPriceDetailImpl() {
    // Arrange
    OrderItemPriceDetailImpl orderItemPriceDetailImpl = new OrderItemPriceDetailImpl();
    orderItemPriceDetailImpl.setId(1L);
    orderItemPriceDetailImpl.setOrderItem(new BundleOrderItemImpl());
    orderItemPriceDetailImpl.setOrderItemAdjustments(new ArrayList<>());
    orderItemPriceDetailImpl.setQuantity(1);
    orderItemPriceDetailImpl.setUseSalePrice(true);
    when(entityConfiguration.createEntityInstance(Mockito.<String>any())).thenReturn(orderItemPriceDetailImpl);

    // Act
    OrderItemPriceDetail actualInitializeOrderItemPriceDetailsResult = orderItemDaoImpl
        .initializeOrderItemPriceDetails(new BundleOrderItemImpl());

    // Assert
    verify(entityConfiguration)
        .createEntityInstance(eq("org.broadleafcommerce.core.order.domain.OrderItemPriceDetail"));
    assertSame(orderItemPriceDetailImpl, actualInitializeOrderItemPriceDetailsResult);
  }
}
