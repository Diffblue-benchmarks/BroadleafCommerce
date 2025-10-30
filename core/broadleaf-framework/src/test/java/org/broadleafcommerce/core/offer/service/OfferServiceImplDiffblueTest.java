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
package org.broadleafcommerce.core.offer.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.broadleafcommerce.common.audit.Auditable;
import org.broadleafcommerce.common.currency.domain.BroadleafCurrencyImpl;
import org.broadleafcommerce.common.extension.ExtensionManager;
import org.broadleafcommerce.common.extension.ExtensionResultStatusType;
import org.broadleafcommerce.common.locale.domain.LocaleImpl;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.common.persistence.EntityDuplicator;
import org.broadleafcommerce.common.util.StreamCapableTransactionalOperation;
import org.broadleafcommerce.common.util.StreamingTransactionCapableUtil;
import org.broadleafcommerce.core.offer.dao.CustomerOfferDao;
import org.broadleafcommerce.core.offer.dao.CustomerOfferDaoImpl;
import org.broadleafcommerce.core.offer.dao.OfferCodeDao;
import org.broadleafcommerce.core.offer.dao.OfferCodeDaoImpl;
import org.broadleafcommerce.core.offer.dao.OfferDao;
import org.broadleafcommerce.core.offer.dao.OfferDaoImpl;
import org.broadleafcommerce.core.offer.domain.Offer;
import org.broadleafcommerce.core.offer.domain.OfferCode;
import org.broadleafcommerce.core.offer.domain.OfferCodeImpl;
import org.broadleafcommerce.core.offer.domain.OfferImpl;
import org.broadleafcommerce.core.offer.service.discount.domain.PromotableItemFactory;
import org.broadleafcommerce.core.offer.service.discount.domain.PromotableItemFactoryImpl;
import org.broadleafcommerce.core.offer.service.discount.domain.PromotableOfferUtilityImpl;
import org.broadleafcommerce.core.offer.service.discount.domain.PromotableOrder;
import org.broadleafcommerce.core.offer.service.processor.BaseProcessor;
import org.broadleafcommerce.core.offer.service.processor.FulfillmentGroupOfferProcessor;
import org.broadleafcommerce.core.offer.service.processor.FulfillmentGroupOfferProcessorImpl;
import org.broadleafcommerce.core.offer.service.processor.ItemOfferProcessor;
import org.broadleafcommerce.core.offer.service.processor.ItemOfferProcessorImpl;
import org.broadleafcommerce.core.offer.service.processor.OrderOfferProcessor;
import org.broadleafcommerce.core.offer.service.type.CustomerMaxUsesStrategyType;
import org.broadleafcommerce.core.offer.service.type.OfferAdjustmentType;
import org.broadleafcommerce.core.offer.service.type.OfferDiscountType;
import org.broadleafcommerce.core.offer.service.type.OfferItemRestrictionRuleType;
import org.broadleafcommerce.core.offer.service.type.OfferType;
import org.broadleafcommerce.core.order.domain.BundleOrderItemImpl;
import org.broadleafcommerce.core.order.domain.FulfillmentGroup;
import org.broadleafcommerce.core.order.domain.FulfillmentGroupImpl;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.Order;
import org.broadleafcommerce.core.order.domain.OrderImpl;
import org.broadleafcommerce.core.order.domain.OrderItem;
import org.broadleafcommerce.core.order.service.OrderService;
import org.broadleafcommerce.core.order.service.OrderServiceImpl;
import org.broadleafcommerce.core.order.service.type.OrderStatus;
import org.broadleafcommerce.core.pricing.service.exception.PricingException;
import org.broadleafcommerce.profile.core.domain.Customer;
import org.broadleafcommerce.profile.core.domain.CustomerImpl;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class OfferServiceImplDiffblueTest {
  @Mock
  private OfferServiceExtensionManager offerServiceExtensionManager;

  @InjectMocks
  private OfferServiceImpl offerServiceImpl;

  @Mock
  private CustomerOfferDao customerOfferDao;

  @Mock
  private StreamingTransactionCapableUtil streamingTransactionCapableUtil;

  @Mock
  private OfferDao offerDao;

  @Mock
  private OfferCodeDao offerCodeDao;

  @Mock
  private EntityDuplicator entityDuplicator;

  /**
   * Test {@link OfferServiceImpl#findAllOffers()}.
   * <ul>
   *   <li>Given {@link OfferDao} {@link OfferDao#readAllOffers()} return {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferServiceImpl#findAllOffers()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List OfferServiceImpl.findAllOffers()"})
  public void testFindAllOffers_givenOfferDaoReadAllOffersReturnArrayList_thenReturnEmpty() {
    // Arrange
    when(offerDao.readAllOffers()).thenReturn(new ArrayList<>());

    // Act
    List<Offer> actualFindAllOffersResult = offerServiceImpl.findAllOffers();

    // Assert
    verify(offerDao).readAllOffers();
    assertTrue(actualFindAllOffersResult.isEmpty());
  }

  /**
   * Test {@link OfferServiceImpl#findAllOffers()}.
   * <ul>
   *   <li>Given {@link OfferDao} {@link OfferDao#readAllOffers()} return {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferServiceImpl#findAllOffers()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List OfferServiceImpl.findAllOffers()"})
  public void testFindAllOffers_givenOfferDaoReadAllOffersReturnArrayList_thenReturnEmpty2() {
    // Arrange
    when(offerDao.readAllOffers()).thenReturn(new ArrayList<>());

    // Act
    List<Offer> actualFindAllOffersResult = offerServiceImpl.findAllOffers();

    // Assert
    verify(offerDao).readAllOffers();
    assertTrue(actualFindAllOffersResult.isEmpty());
  }

  /**
   * Test {@link OfferServiceImpl#findAllOffers()}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferServiceImpl#findAllOffers()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List OfferServiceImpl.findAllOffers()"})
  public void testFindAllOffers_thenThrowRuntimeException() {
    // Arrange
    when(offerDao.readAllOffers()).thenThrow(new RuntimeException("foo"));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> offerServiceImpl.findAllOffers());
    verify(offerDao).readAllOffers();
  }

  /**
   * Test {@link OfferServiceImpl#findAllOffers()}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferServiceImpl#findAllOffers()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List OfferServiceImpl.findAllOffers()"})
  public void testFindAllOffers_thenThrowRuntimeException2() {
    // Arrange
    when(offerDao.readAllOffers()).thenThrow(new RuntimeException("foo"));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> offerServiceImpl.findAllOffers());
    verify(offerDao).readAllOffers();
  }

  /**
   * Test {@link OfferServiceImpl#buildOfferListForOrder(Order)}.
   * <p>
   * Method under test: {@link OfferServiceImpl#buildOfferListForOrder(Order)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List OfferServiceImpl.buildOfferListForOrder(Order)"})
  public void testBuildOfferListForOrder() throws Throwable {
    // Arrange
    when(customerOfferDao.readCustomerOffersByCustomer(Mockito.<Customer>any())).thenReturn(new ArrayList<>());
    doThrow(new RuntimeException("foo")).when(streamingTransactionCapableUtil)
        .runTransactionalOperation(Mockito.<StreamCapableTransactionalOperation>any(),
            Mockito.<Class<RuntimeException>>any());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> offerServiceImpl.buildOfferListForOrder(new NullOrderImpl()));
    verify(streamingTransactionCapableUtil).runTransactionalOperation(isA(StreamCapableTransactionalOperation.class),
        isA(Class.class));
    verify(customerOfferDao).readCustomerOffersByCustomer(isNull());
  }

  /**
   * Test {@link OfferServiceImpl#buildOfferListForOrder(Order)}.
   * <p>
   * Method under test: {@link OfferServiceImpl#buildOfferListForOrder(Order)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List OfferServiceImpl.buildOfferListForOrder(Order)"})
  public void testBuildOfferListForOrder2() throws Throwable {
    // Arrange
    when(customerOfferDao.readCustomerOffersByCustomer(Mockito.<Customer>any())).thenReturn(new ArrayList<>());
    when(offerDao.readOffersByAutomaticDeliveryType()).thenThrow(new RuntimeException("foo"));
    doNothing().when(streamingTransactionCapableUtil)
        .runTransactionalOperation(Mockito.<StreamCapableTransactionalOperation>any(),
            Mockito.<Class<RuntimeException>>any());

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(2L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(2L);

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCurrency(new BroadleafCurrencyImpl());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
    order.setFulfillmentGroups(new ArrayList<>());
    order.setId(1L);
    order.setLocale(new LocaleImpl());
    order.setName("Name");
    order.setOrderAttributes(new HashMap<>());
    order.setOrderItems(new ArrayList<>());
    order.setOrderMessages(new ArrayList<>());
    order.setOrderNumber("42");
    order.setPayments(new ArrayList<>());
    order.setStatus(OrderStatus.ARCHIVED);
    order.setSubTotal(new Money());
    order.setSubmitDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalShipping(new Money());
    order.setTotalTax(new Money());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> offerServiceImpl.buildOfferListForOrder(order));
    verify(streamingTransactionCapableUtil).runTransactionalOperation(isA(StreamCapableTransactionalOperation.class),
        isA(Class.class));
    verify(customerOfferDao).readCustomerOffersByCustomer(isA(Customer.class));
    verify(offerDao).readOffersByAutomaticDeliveryType();
  }

  /**
   * Test {@link OfferServiceImpl#buildOfferListForOrder(Order)}.
   * <p>
   * Method under test: {@link OfferServiceImpl#buildOfferListForOrder(Order)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List OfferServiceImpl.buildOfferListForOrder(Order)"})
  public void testBuildOfferListForOrder3() throws Throwable {
    // Arrange
    when(customerOfferDao.readCustomerOffersByCustomer(Mockito.<Customer>any())).thenReturn(new ArrayList<>());
    doThrow(new RuntimeException("foo")).when(streamingTransactionCapableUtil)
        .runTransactionalOperation(Mockito.<StreamCapableTransactionalOperation>any(),
            Mockito.<Class<RuntimeException>>any());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> offerServiceImpl.buildOfferListForOrder(new NullOrderImpl()));
    verify(streamingTransactionCapableUtil).runTransactionalOperation(isA(StreamCapableTransactionalOperation.class),
        isA(Class.class));
    verify(customerOfferDao).readCustomerOffersByCustomer(isNull());
  }

  /**
   * Test {@link OfferServiceImpl#buildOfferListForOrder(Order)}.
   * <p>
   * Method under test: {@link OfferServiceImpl#buildOfferListForOrder(Order)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List OfferServiceImpl.buildOfferListForOrder(Order)"})
  public void testBuildOfferListForOrder4() throws Throwable {
    // Arrange
    when(customerOfferDao.readCustomerOffersByCustomer(Mockito.<Customer>any())).thenReturn(new ArrayList<>());
    when(offerDao.readOffersByAutomaticDeliveryType()).thenThrow(new RuntimeException("foo"));
    doNothing().when(streamingTransactionCapableUtil)
        .runTransactionalOperation(Mockito.<StreamCapableTransactionalOperation>any(),
            Mockito.<Class<RuntimeException>>any());

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(2L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(2L);

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCurrency(new BroadleafCurrencyImpl());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
    order.setFulfillmentGroups(new ArrayList<>());
    order.setId(1L);
    order.setLocale(new LocaleImpl());
    order.setName("Name");
    order.setOrderAttributes(new HashMap<>());
    order.setOrderItems(new ArrayList<>());
    order.setOrderMessages(new ArrayList<>());
    order.setOrderNumber("42");
    order.setPayments(new ArrayList<>());
    order.setStatus(OrderStatus.ARCHIVED);
    order.setSubTotal(new Money());
    order.setSubmitDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalShipping(new Money());
    order.setTotalTax(new Money());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> offerServiceImpl.buildOfferListForOrder(order));
    verify(streamingTransactionCapableUtil).runTransactionalOperation(isA(StreamCapableTransactionalOperation.class),
        isA(Class.class));
    verify(customerOfferDao).readCustomerOffersByCustomer(isA(Customer.class));
    verify(offerDao).readOffersByAutomaticDeliveryType();
  }

  /**
   * Test {@link OfferServiceImpl#buildOfferListForOrder(Order)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link OfferImpl} (default constructor).</li>
   *   <li>Then return {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferServiceImpl#buildOfferListForOrder(Order)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List OfferServiceImpl.buildOfferListForOrder(Order)"})
  public void testBuildOfferListForOrder_givenArrayListAddOfferImpl_thenReturnArrayList() throws Throwable {
    // Arrange
    when(customerOfferDao.readCustomerOffersByCustomer(Mockito.<Customer>any())).thenReturn(new ArrayList<>());
    when(offerServiceExtensionManager.applyAdditionalFilters(Mockito.<List<Offer>>any(), Mockito.<Order>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);

    ArrayList<Offer> offerList = new ArrayList<>();
    offerList.add(new OfferImpl());
    when(offerDao.readOffersByAutomaticDeliveryType()).thenReturn(offerList);
    doNothing().when(streamingTransactionCapableUtil)
        .runTransactionalOperation(Mockito.<StreamCapableTransactionalOperation>any(),
            Mockito.<Class<RuntimeException>>any());

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(2L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(2L);

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCurrency(new BroadleafCurrencyImpl());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
    order.setFulfillmentGroups(new ArrayList<>());
    order.setId(1L);
    order.setLocale(new LocaleImpl());
    order.setName("Name");
    order.setOrderAttributes(new HashMap<>());
    order.setOrderItems(new ArrayList<>());
    order.setOrderMessages(new ArrayList<>());
    order.setOrderNumber("42");
    order.setPayments(new ArrayList<>());
    order.setStatus(OrderStatus.ARCHIVED);
    order.setSubTotal(new Money());
    order.setSubmitDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalShipping(new Money());
    order.setTotalTax(new Money());

    // Act
    List<Offer> actualBuildOfferListForOrderResult = offerServiceImpl.buildOfferListForOrder(order);

    // Assert
    verify(streamingTransactionCapableUtil).runTransactionalOperation(isA(StreamCapableTransactionalOperation.class),
        isA(Class.class));
    verify(customerOfferDao).readCustomerOffersByCustomer(isA(Customer.class));
    verify(offerDao).readOffersByAutomaticDeliveryType();
    verify(offerServiceExtensionManager).applyAdditionalFilters(isA(List.class), isA(Order.class));
    assertEquals(offerList, actualBuildOfferListForOrderResult);
  }

  /**
   * Test {@link OfferServiceImpl#buildOfferListForOrder(Order)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link OfferImpl} (default constructor).</li>
   *   <li>Then return {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferServiceImpl#buildOfferListForOrder(Order)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List OfferServiceImpl.buildOfferListForOrder(Order)"})
  public void testBuildOfferListForOrder_givenArrayListAddOfferImpl_thenReturnArrayList2() throws Throwable {
    // Arrange
    when(customerOfferDao.readCustomerOffersByCustomer(Mockito.<Customer>any())).thenReturn(new ArrayList<>());
    when(offerServiceExtensionManager.applyAdditionalFilters(Mockito.<List<Offer>>any(), Mockito.<Order>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);

    ArrayList<Offer> offerList = new ArrayList<>();
    offerList.add(new OfferImpl());
    when(offerDao.readOffersByAutomaticDeliveryType()).thenReturn(offerList);
    doNothing().when(streamingTransactionCapableUtil)
        .runTransactionalOperation(Mockito.<StreamCapableTransactionalOperation>any(),
            Mockito.<Class<RuntimeException>>any());

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(2L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(2L);

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCurrency(new BroadleafCurrencyImpl());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
    order.setFulfillmentGroups(new ArrayList<>());
    order.setId(1L);
    order.setLocale(new LocaleImpl());
    order.setName("Name");
    order.setOrderAttributes(new HashMap<>());
    order.setOrderItems(new ArrayList<>());
    order.setOrderMessages(new ArrayList<>());
    order.setOrderNumber("42");
    order.setPayments(new ArrayList<>());
    order.setStatus(OrderStatus.ARCHIVED);
    order.setSubTotal(new Money());
    order.setSubmitDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalShipping(new Money());
    order.setTotalTax(new Money());

    // Act
    List<Offer> actualBuildOfferListForOrderResult = offerServiceImpl.buildOfferListForOrder(order);

    // Assert
    verify(streamingTransactionCapableUtil).runTransactionalOperation(isA(StreamCapableTransactionalOperation.class),
        isA(Class.class));
    verify(customerOfferDao).readCustomerOffersByCustomer(isA(Customer.class));
    verify(offerDao).readOffersByAutomaticDeliveryType();
    verify(offerServiceExtensionManager).applyAdditionalFilters(isA(List.class), isA(Order.class));
    assertEquals(offerList, actualBuildOfferListForOrderResult);
  }

  /**
   * Test {@link OfferServiceImpl#buildOfferListForOrder(Order)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link OfferImpl} (default constructor).</li>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferServiceImpl#buildOfferListForOrder(Order)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List OfferServiceImpl.buildOfferListForOrder(Order)"})
  public void testBuildOfferListForOrder_givenArrayListAddOfferImpl_thenReturnSizeIsOne() throws Throwable {
    // Arrange
    when(customerOfferDao.readCustomerOffersByCustomer(Mockito.<Customer>any())).thenReturn(new ArrayList<>());
    when(offerServiceExtensionManager.applyAdditionalFilters(Mockito.<List<Offer>>any(), Mockito.<Order>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);

    ArrayList<Offer> offerList = new ArrayList<>();
    OfferImpl offerImpl = new OfferImpl();
    offerList.add(offerImpl);
    offerList.add(new OfferImpl());
    when(offerDao.readOffersByAutomaticDeliveryType()).thenReturn(offerList);
    doNothing().when(streamingTransactionCapableUtil)
        .runTransactionalOperation(Mockito.<StreamCapableTransactionalOperation>any(),
            Mockito.<Class<RuntimeException>>any());

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(2L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(2L);

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCurrency(new BroadleafCurrencyImpl());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
    order.setFulfillmentGroups(new ArrayList<>());
    order.setId(1L);
    order.setLocale(new LocaleImpl());
    order.setName("Name");
    order.setOrderAttributes(new HashMap<>());
    order.setOrderItems(new ArrayList<>());
    order.setOrderMessages(new ArrayList<>());
    order.setOrderNumber("42");
    order.setPayments(new ArrayList<>());
    order.setStatus(OrderStatus.ARCHIVED);
    order.setSubTotal(new Money());
    order.setSubmitDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalShipping(new Money());
    order.setTotalTax(new Money());

    // Act
    List<Offer> actualBuildOfferListForOrderResult = offerServiceImpl.buildOfferListForOrder(order);

    // Assert
    verify(streamingTransactionCapableUtil).runTransactionalOperation(isA(StreamCapableTransactionalOperation.class),
        isA(Class.class));
    verify(customerOfferDao).readCustomerOffersByCustomer(isA(Customer.class));
    verify(offerDao).readOffersByAutomaticDeliveryType();
    verify(offerServiceExtensionManager).applyAdditionalFilters(isA(List.class), isA(Order.class));
    assertEquals(1, actualBuildOfferListForOrderResult.size());
    Offer getResult = actualBuildOfferListForOrderResult.get(0);
    assertTrue(getResult instanceof OfferImpl);
    assertSame(offerImpl, getResult);
  }

  /**
   * Test {@link OfferServiceImpl#buildOfferListForOrder(Order)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link OfferImpl} (default constructor).</li>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferServiceImpl#buildOfferListForOrder(Order)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List OfferServiceImpl.buildOfferListForOrder(Order)"})
  public void testBuildOfferListForOrder_givenArrayListAddOfferImpl_thenReturnSizeIsOne2() throws Throwable {
    // Arrange
    when(customerOfferDao.readCustomerOffersByCustomer(Mockito.<Customer>any())).thenReturn(new ArrayList<>());
    when(offerServiceExtensionManager.applyAdditionalFilters(Mockito.<List<Offer>>any(), Mockito.<Order>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);

    ArrayList<Offer> offerList = new ArrayList<>();
    OfferImpl offerImpl = new OfferImpl();
    offerList.add(offerImpl);
    offerList.add(new OfferImpl());
    when(offerDao.readOffersByAutomaticDeliveryType()).thenReturn(offerList);
    doNothing().when(streamingTransactionCapableUtil)
        .runTransactionalOperation(Mockito.<StreamCapableTransactionalOperation>any(),
            Mockito.<Class<RuntimeException>>any());

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(2L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(2L);

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCurrency(new BroadleafCurrencyImpl());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
    order.setFulfillmentGroups(new ArrayList<>());
    order.setId(1L);
    order.setLocale(new LocaleImpl());
    order.setName("Name");
    order.setOrderAttributes(new HashMap<>());
    order.setOrderItems(new ArrayList<>());
    order.setOrderMessages(new ArrayList<>());
    order.setOrderNumber("42");
    order.setPayments(new ArrayList<>());
    order.setStatus(OrderStatus.ARCHIVED);
    order.setSubTotal(new Money());
    order.setSubmitDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalShipping(new Money());
    order.setTotalTax(new Money());

    // Act
    List<Offer> actualBuildOfferListForOrderResult = offerServiceImpl.buildOfferListForOrder(order);

    // Assert
    verify(streamingTransactionCapableUtil).runTransactionalOperation(isA(StreamCapableTransactionalOperation.class),
        isA(Class.class));
    verify(customerOfferDao).readCustomerOffersByCustomer(isA(Customer.class));
    verify(offerDao).readOffersByAutomaticDeliveryType();
    verify(offerServiceExtensionManager).applyAdditionalFilters(isA(List.class), isA(Order.class));
    assertEquals(1, actualBuildOfferListForOrderResult.size());
    Offer getResult = actualBuildOfferListForOrderResult.get(0);
    assertTrue(getResult instanceof OfferImpl);
    assertSame(offerImpl, getResult);
  }

  /**
   * Test {@link OfferServiceImpl#buildOfferListForOrder(Order)}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferServiceImpl#buildOfferListForOrder(Order)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List OfferServiceImpl.buildOfferListForOrder(Order)"})
  public void testBuildOfferListForOrder_thenReturnEmpty() throws Throwable {
    // Arrange
    when(customerOfferDao.readCustomerOffersByCustomer(Mockito.<Customer>any())).thenReturn(new ArrayList<>());
    when(offerServiceExtensionManager.applyAdditionalFilters(Mockito.<List<Offer>>any(), Mockito.<Order>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(offerDao.readOffersByAutomaticDeliveryType()).thenReturn(new ArrayList<>());
    doNothing().when(streamingTransactionCapableUtil)
        .runTransactionalOperation(Mockito.<StreamCapableTransactionalOperation>any(),
            Mockito.<Class<RuntimeException>>any());

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(2L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(2L);

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCurrency(new BroadleafCurrencyImpl());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
    order.setFulfillmentGroups(new ArrayList<>());
    order.setId(1L);
    order.setLocale(new LocaleImpl());
    order.setName("Name");
    order.setOrderAttributes(new HashMap<>());
    order.setOrderItems(new ArrayList<>());
    order.setOrderMessages(new ArrayList<>());
    order.setOrderNumber("42");
    order.setPayments(new ArrayList<>());
    order.setStatus(OrderStatus.ARCHIVED);
    order.setSubTotal(new Money());
    order.setSubmitDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalShipping(new Money());
    order.setTotalTax(new Money());

    // Act
    List<Offer> actualBuildOfferListForOrderResult = offerServiceImpl.buildOfferListForOrder(order);

    // Assert
    verify(streamingTransactionCapableUtil).runTransactionalOperation(isA(StreamCapableTransactionalOperation.class),
        isA(Class.class));
    verify(customerOfferDao).readCustomerOffersByCustomer(isA(Customer.class));
    verify(offerDao).readOffersByAutomaticDeliveryType();
    verify(offerServiceExtensionManager).applyAdditionalFilters(isA(List.class), isA(Order.class));
    assertTrue(actualBuildOfferListForOrderResult.isEmpty());
  }

  /**
   * Test {@link OfferServiceImpl#buildOfferListForOrder(Order)}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferServiceImpl#buildOfferListForOrder(Order)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List OfferServiceImpl.buildOfferListForOrder(Order)"})
  public void testBuildOfferListForOrder_thenReturnEmpty2() throws Throwable {
    // Arrange
    when(customerOfferDao.readCustomerOffersByCustomer(Mockito.<Customer>any())).thenReturn(new ArrayList<>());
    when(offerServiceExtensionManager.applyAdditionalFilters(Mockito.<List<Offer>>any(), Mockito.<Order>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(offerDao.readOffersByAutomaticDeliveryType()).thenReturn(new ArrayList<>());
    doNothing().when(streamingTransactionCapableUtil)
        .runTransactionalOperation(Mockito.<StreamCapableTransactionalOperation>any(),
            Mockito.<Class<RuntimeException>>any());

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(2L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(2L);

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCurrency(new BroadleafCurrencyImpl());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
    order.setFulfillmentGroups(new ArrayList<>());
    order.setId(1L);
    order.setLocale(new LocaleImpl());
    order.setName("Name");
    order.setOrderAttributes(new HashMap<>());
    order.setOrderItems(new ArrayList<>());
    order.setOrderMessages(new ArrayList<>());
    order.setOrderNumber("42");
    order.setPayments(new ArrayList<>());
    order.setStatus(OrderStatus.ARCHIVED);
    order.setSubTotal(new Money());
    order.setSubmitDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalShipping(new Money());
    order.setTotalTax(new Money());

    // Act
    List<Offer> actualBuildOfferListForOrderResult = offerServiceImpl.buildOfferListForOrder(order);

    // Assert
    verify(streamingTransactionCapableUtil).runTransactionalOperation(isA(StreamCapableTransactionalOperation.class),
        isA(Class.class));
    verify(customerOfferDao).readCustomerOffersByCustomer(isA(Customer.class));
    verify(offerDao).readOffersByAutomaticDeliveryType();
    verify(offerServiceExtensionManager).applyAdditionalFilters(isA(List.class), isA(Order.class));
    assertTrue(actualBuildOfferListForOrderResult.isEmpty());
  }

  /**
   * Test {@link OfferServiceImpl#buildOfferCodeListForCustomer(Customer)} with {@code customer}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferServiceImpl#buildOfferCodeListForCustomer(Customer)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List OfferServiceImpl.buildOfferCodeListForCustomer(Customer)"})
  public void testBuildOfferCodeListForCustomerWithCustomer_thenReturnEmpty() {
    // Arrange
    when(offerServiceExtensionManager.buildOfferCodeListForCustomer(Mockito.<Customer>any(),
        Mockito.<List<OfferCode>>any())).thenReturn(ExtensionResultStatusType.HANDLED);

    // Act
    List<OfferCode> actualBuildOfferCodeListForCustomerResult = offerServiceImpl
        .buildOfferCodeListForCustomer(new CustomerImpl());

    // Assert
    verify(offerServiceExtensionManager).buildOfferCodeListForCustomer(isA(Customer.class), isA(List.class));
    assertTrue(actualBuildOfferCodeListForCustomerResult.isEmpty());
  }

  /**
   * Test {@link OfferServiceImpl#buildOfferCodeListForCustomer(Customer)} with {@code customer}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferServiceImpl#buildOfferCodeListForCustomer(Customer)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List OfferServiceImpl.buildOfferCodeListForCustomer(Customer)"})
  public void testBuildOfferCodeListForCustomerWithCustomer_thenReturnEmpty2() {
    // Arrange
    when(offerServiceExtensionManager.buildOfferCodeListForCustomer(Mockito.<Customer>any(),
        Mockito.<List<OfferCode>>any())).thenReturn(ExtensionResultStatusType.HANDLED);

    // Act
    List<OfferCode> actualBuildOfferCodeListForCustomerResult = offerServiceImpl
        .buildOfferCodeListForCustomer(new CustomerImpl());

    // Assert
    verify(offerServiceExtensionManager).buildOfferCodeListForCustomer(isA(Customer.class), isA(List.class));
    assertTrue(actualBuildOfferCodeListForCustomerResult.isEmpty());
  }

  /**
   * Test {@link OfferServiceImpl#buildOfferCodeListForCustomer(Customer)} with {@code customer}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferServiceImpl#buildOfferCodeListForCustomer(Customer)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List OfferServiceImpl.buildOfferCodeListForCustomer(Customer)"})
  public void testBuildOfferCodeListForCustomerWithCustomer_thenThrowRuntimeException() {
    // Arrange
    when(offerServiceExtensionManager.buildOfferCodeListForCustomer(Mockito.<Customer>any(),
        Mockito.<List<OfferCode>>any())).thenThrow(new RuntimeException("foo"));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> offerServiceImpl.buildOfferCodeListForCustomer(new CustomerImpl()));
    verify(offerServiceExtensionManager).buildOfferCodeListForCustomer(isA(Customer.class), isA(List.class));
  }

  /**
   * Test {@link OfferServiceImpl#buildOfferCodeListForCustomer(Customer)} with {@code customer}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferServiceImpl#buildOfferCodeListForCustomer(Customer)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List OfferServiceImpl.buildOfferCodeListForCustomer(Customer)"})
  public void testBuildOfferCodeListForCustomerWithCustomer_thenThrowRuntimeException2() {
    // Arrange
    when(offerServiceExtensionManager.buildOfferCodeListForCustomer(Mockito.<Customer>any(),
        Mockito.<List<OfferCode>>any())).thenThrow(new RuntimeException("foo"));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> offerServiceImpl.buildOfferCodeListForCustomer(new CustomerImpl()));
    verify(offerServiceExtensionManager).buildOfferCodeListForCustomer(isA(Customer.class), isA(List.class));
  }

  /**
   * Test {@link OfferServiceImpl#buildOfferCodeListForCustomer(Order)} with {@code order}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferServiceImpl#buildOfferCodeListForCustomer(Order)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List OfferServiceImpl.buildOfferCodeListForCustomer(Order)"})
  public void testBuildOfferCodeListForCustomerWithOrder_thenReturnEmpty() {
    // Arrange
    when(offerServiceExtensionManager.buildOfferCodeListForCustomer(Mockito.<Customer>any(),
        Mockito.<List<OfferCode>>any())).thenReturn(ExtensionResultStatusType.HANDLED);

    // Act
    List<OfferCode> actualBuildOfferCodeListForCustomerResult = offerServiceImpl
        .buildOfferCodeListForCustomer(new NullOrderImpl());

    // Assert
    verify(offerServiceExtensionManager).buildOfferCodeListForCustomer(isNull(), isA(List.class));
    assertTrue(actualBuildOfferCodeListForCustomerResult.isEmpty());
  }

  /**
   * Test {@link OfferServiceImpl#buildOfferCodeListForCustomer(Order)} with {@code order}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferServiceImpl#buildOfferCodeListForCustomer(Order)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List OfferServiceImpl.buildOfferCodeListForCustomer(Order)"})
  public void testBuildOfferCodeListForCustomerWithOrder_thenReturnEmpty2() {
    // Arrange
    when(offerServiceExtensionManager.buildOfferCodeListForCustomer(Mockito.<Customer>any(),
        Mockito.<List<OfferCode>>any())).thenReturn(ExtensionResultStatusType.HANDLED);

    // Act
    List<OfferCode> actualBuildOfferCodeListForCustomerResult = offerServiceImpl
        .buildOfferCodeListForCustomer(new NullOrderImpl());

    // Assert
    verify(offerServiceExtensionManager).buildOfferCodeListForCustomer(isNull(), isA(List.class));
    assertTrue(actualBuildOfferCodeListForCustomerResult.isEmpty());
  }

  /**
   * Test {@link OfferServiceImpl#buildOfferCodeListForCustomer(Order)} with {@code order}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferServiceImpl#buildOfferCodeListForCustomer(Order)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List OfferServiceImpl.buildOfferCodeListForCustomer(Order)"})
  public void testBuildOfferCodeListForCustomerWithOrder_thenThrowRuntimeException() {
    // Arrange
    when(offerServiceExtensionManager.buildOfferCodeListForCustomer(Mockito.<Customer>any(),
        Mockito.<List<OfferCode>>any())).thenThrow(new RuntimeException("foo"));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> offerServiceImpl.buildOfferCodeListForCustomer(new NullOrderImpl()));
    verify(offerServiceExtensionManager).buildOfferCodeListForCustomer(isNull(), isA(List.class));
  }

  /**
   * Test {@link OfferServiceImpl#buildOfferCodeListForCustomer(Order)} with {@code order}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferServiceImpl#buildOfferCodeListForCustomer(Order)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List OfferServiceImpl.buildOfferCodeListForCustomer(Order)"})
  public void testBuildOfferCodeListForCustomerWithOrder_thenThrowRuntimeException2() {
    // Arrange
    when(offerServiceExtensionManager.buildOfferCodeListForCustomer(Mockito.<Customer>any(),
        Mockito.<List<OfferCode>>any())).thenThrow(new RuntimeException("foo"));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> offerServiceImpl.buildOfferCodeListForCustomer(new NullOrderImpl()));
    verify(offerServiceExtensionManager).buildOfferCodeListForCustomer(isNull(), isA(List.class));
  }

  /**
   * Test {@link OfferServiceImpl#applyAndSaveOffersToOrder(List, Order)}.
   * <ul>
   *   <li>Then return {@link NullOrderImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferServiceImpl#applyAndSaveOffersToOrder(List, Order)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Order OfferServiceImpl.applyAndSaveOffersToOrder(List, Order)"})
  public void testApplyAndSaveOffersToOrder_thenReturnNullOrderImpl() throws PricingException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    OrderOfferProcessor orderOfferProcessor = mock(OrderOfferProcessor.class);
    when(orderOfferProcessor.filterOffers(Mockito.<List<Offer>>any(), Mockito.<Customer>any()))
        .thenReturn(new ArrayList<>());
    doNothing().when(orderOfferProcessor).synchronizeAdjustmentsAndPrices(Mockito.<PromotableOrder>any());
    OrderService orderService = mock(OrderService.class);
    NullOrderImpl nullOrderImpl = new NullOrderImpl();
    when(orderService.save(Mockito.<Order>any(), Mockito.<Boolean>any())).thenReturn(nullOrderImpl);

    OfferServiceImpl offerServiceImpl = new OfferServiceImpl();
    offerServiceImpl.setOrderService(orderService);
    offerServiceImpl.setOrderOfferProcessor(orderOfferProcessor);
    offerServiceImpl.setPromotableItemFactory(new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()));
    ArrayList<Offer> offers = new ArrayList<>();
    Order order = mock(Order.class);
    when(order.finalizeItemPrices()).thenReturn(true);
    when(order.getOrderItems()).thenReturn(new ArrayList<>());
    when(order.calculateSubTotal()).thenReturn(new Money());
    when(order.getCustomer()).thenReturn(new CustomerImpl());
    doNothing().when(order).setSubTotal(Mockito.<Money>any());

    // Act
    Order actualApplyAndSaveOffersToOrderResult = offerServiceImpl.applyAndSaveOffersToOrder(offers, order);

    // Assert
    verify(orderOfferProcessor).filterOffers(isA(List.class), isA(Customer.class));
    verify(orderOfferProcessor).synchronizeAdjustmentsAndPrices(isA(PromotableOrder.class));
    verify(order).calculateSubTotal();
    verify(order).finalizeItemPrices();
    verify(order).getCustomer();
    verify(order, atLeast(1)).getOrderItems();
    verify(order).setSubTotal(isA(Money.class));
    verify(orderService).save(isA(Order.class), eq(false));
    assertSame(nullOrderImpl, actualApplyAndSaveOffersToOrderResult);
  }

  /**
   * Test {@link OfferServiceImpl#applyAndSaveOffersToOrder(List, Order)}.
   * <ul>
   *   <li>Then return {@link NullOrderImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferServiceImpl#applyAndSaveOffersToOrder(List, Order)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Order OfferServiceImpl.applyAndSaveOffersToOrder(List, Order)"})
  public void testApplyAndSaveOffersToOrder_thenReturnNullOrderImpl2() throws PricingException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    OrderOfferProcessor orderOfferProcessor = mock(OrderOfferProcessor.class);
    when(orderOfferProcessor.filterOffers(Mockito.<List<Offer>>any(), Mockito.<Customer>any()))
        .thenReturn(new ArrayList<>());
    doNothing().when(orderOfferProcessor).synchronizeAdjustmentsAndPrices(Mockito.<PromotableOrder>any());
    OrderService orderService = mock(OrderService.class);
    NullOrderImpl nullOrderImpl = new NullOrderImpl();
    when(orderService.save(Mockito.<Order>any(), Mockito.<Boolean>any())).thenReturn(nullOrderImpl);

    OfferServiceImpl offerServiceImpl = new OfferServiceImpl();
    offerServiceImpl.setOrderService(orderService);
    offerServiceImpl.setOrderOfferProcessor(orderOfferProcessor);
    offerServiceImpl.setPromotableItemFactory(new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()));
    ArrayList<Offer> offers = new ArrayList<>();
    Order order = mock(Order.class);
    when(order.finalizeItemPrices()).thenReturn(true);
    when(order.getOrderItems()).thenReturn(new ArrayList<>());
    when(order.calculateSubTotal()).thenReturn(new Money());
    when(order.getCustomer()).thenReturn(new CustomerImpl());
    doNothing().when(order).setSubTotal(Mockito.<Money>any());

    // Act
    Order actualApplyAndSaveOffersToOrderResult = offerServiceImpl.applyAndSaveOffersToOrder(offers, order);

    // Assert
    verify(orderOfferProcessor).filterOffers(isA(List.class), isA(Customer.class));
    verify(orderOfferProcessor).synchronizeAdjustmentsAndPrices(isA(PromotableOrder.class));
    verify(order).calculateSubTotal();
    verify(order).finalizeItemPrices();
    verify(order).getCustomer();
    verify(order, atLeast(1)).getOrderItems();
    verify(order).setSubTotal(isA(Money.class));
    verify(orderService).save(isA(Order.class), eq(false));
    assertSame(nullOrderImpl, actualApplyAndSaveOffersToOrderResult);
  }

  /**
   * Test {@link OfferServiceImpl#applyOffersToOrder(List, Order)}.
   * <ul>
   *   <li>Then calls {@link BaseProcessor#filterOffers(List, Customer)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferServiceImpl#applyOffersToOrder(List, Order)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OfferServiceImpl.applyOffersToOrder(List, Order)"})
  public void testApplyOffersToOrder_thenCallsFilterOffers() throws PricingException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    OrderOfferProcessor orderOfferProcessor = mock(OrderOfferProcessor.class);
    when(orderOfferProcessor.filterOffers(Mockito.<List<Offer>>any(), Mockito.<Customer>any()))
        .thenReturn(new ArrayList<>());
    doNothing().when(orderOfferProcessor).synchronizeAdjustmentsAndPrices(Mockito.<PromotableOrder>any());
    OrderService orderService = mock(OrderService.class);
    when(orderService.save(Mockito.<Order>any(), Mockito.<Boolean>any())).thenReturn(new NullOrderImpl());

    OfferServiceImpl offerServiceImpl = new OfferServiceImpl();
    offerServiceImpl.setOrderService(orderService);
    offerServiceImpl.setOrderOfferProcessor(orderOfferProcessor);
    offerServiceImpl.setPromotableItemFactory(new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()));
    ArrayList<Offer> offers = new ArrayList<>();
    Order order = mock(Order.class);
    when(order.finalizeItemPrices()).thenReturn(true);
    when(order.getOrderItems()).thenReturn(new ArrayList<>());
    when(order.calculateSubTotal()).thenReturn(new Money());
    when(order.getCustomer()).thenReturn(new CustomerImpl());
    doNothing().when(order).setSubTotal(Mockito.<Money>any());

    // Act
    offerServiceImpl.applyOffersToOrder(offers, order);

    // Assert
    verify(orderOfferProcessor).filterOffers(isA(List.class), isA(Customer.class));
    verify(orderOfferProcessor).synchronizeAdjustmentsAndPrices(isA(PromotableOrder.class));
    verify(order).calculateSubTotal();
    verify(order).finalizeItemPrices();
    verify(order).getCustomer();
    verify(order, atLeast(1)).getOrderItems();
    verify(order).setSubTotal(isA(Money.class));
    verify(orderService).save(isA(Order.class), eq(false));
  }

  /**
   * Test {@link OfferServiceImpl#applyOffersToOrder(List, Order)}.
   * <ul>
   *   <li>Then calls {@link BaseProcessor#filterOffers(List, Customer)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferServiceImpl#applyOffersToOrder(List, Order)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OfferServiceImpl.applyOffersToOrder(List, Order)"})
  public void testApplyOffersToOrder_thenCallsFilterOffers2() throws PricingException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    OrderOfferProcessor orderOfferProcessor = mock(OrderOfferProcessor.class);
    when(orderOfferProcessor.filterOffers(Mockito.<List<Offer>>any(), Mockito.<Customer>any()))
        .thenReturn(new ArrayList<>());
    doNothing().when(orderOfferProcessor).synchronizeAdjustmentsAndPrices(Mockito.<PromotableOrder>any());
    OrderService orderService = mock(OrderService.class);
    when(orderService.save(Mockito.<Order>any(), Mockito.<Boolean>any())).thenReturn(new NullOrderImpl());

    OfferServiceImpl offerServiceImpl = new OfferServiceImpl();
    offerServiceImpl.setOrderService(orderService);
    offerServiceImpl.setOrderOfferProcessor(orderOfferProcessor);
    offerServiceImpl.setPromotableItemFactory(new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()));
    ArrayList<Offer> offers = new ArrayList<>();
    Order order = mock(Order.class);
    when(order.finalizeItemPrices()).thenReturn(true);
    when(order.getOrderItems()).thenReturn(new ArrayList<>());
    when(order.calculateSubTotal()).thenReturn(new Money());
    when(order.getCustomer()).thenReturn(new CustomerImpl());
    doNothing().when(order).setSubTotal(Mockito.<Money>any());

    // Act
    offerServiceImpl.applyOffersToOrder(offers, order);

    // Assert
    verify(orderOfferProcessor).filterOffers(isA(List.class), isA(Customer.class));
    verify(orderOfferProcessor).synchronizeAdjustmentsAndPrices(isA(PromotableOrder.class));
    verify(order).calculateSubTotal();
    verify(order).finalizeItemPrices();
    verify(order).getCustomer();
    verify(order, atLeast(1)).getOrderItems();
    verify(order).setSubTotal(isA(Money.class));
    verify(orderService).save(isA(Order.class), eq(false));
  }

  /**
   * Test {@link OfferServiceImpl#applyFulfillmentGroupOffersToOrder(List, Order)}.
   * <ul>
   *   <li>Then calls {@link OfferImpl#getType()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferServiceImpl#applyFulfillmentGroupOffersToOrder(List, Order)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OfferServiceImpl.applyFulfillmentGroupOffersToOrder(List, Order)"})
  public void testApplyFulfillmentGroupOffersToOrder_thenCallsGetType() throws PricingException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    OrderService orderService = mock(OrderService.class);
    when(orderService.save(Mockito.<Order>any(), Mockito.<Boolean>any())).thenReturn(new NullOrderImpl());

    OfferServiceImpl offerServiceImpl = new OfferServiceImpl();
    offerServiceImpl.setOrderService(orderService);
    offerServiceImpl.setOrderOfferProcessor(new FulfillmentGroupOfferProcessorImpl(new PromotableOfferUtilityImpl()));
    offerServiceImpl.setPromotableItemFactory(new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()));
    OfferImpl offerImpl = mock(OfferImpl.class);
    when(offerImpl.getType()).thenReturn(OfferType.ORDER);

    ArrayList<Offer> offers = new ArrayList<>();
    offers.add(offerImpl);

    // Act
    offerServiceImpl.applyFulfillmentGroupOffersToOrder(offers, new NullOrderImpl());

    // Assert
    verify(offerImpl).getType();
    verify(orderService).save(isA(Order.class), eq(false));
  }

  /**
   * Test {@link OfferServiceImpl#applyFulfillmentGroupOffersToOrder(List, Order)}.
   * <ul>
   *   <li>Then calls {@link OfferImpl#getType()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferServiceImpl#applyFulfillmentGroupOffersToOrder(List, Order)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OfferServiceImpl.applyFulfillmentGroupOffersToOrder(List, Order)"})
  public void testApplyFulfillmentGroupOffersToOrder_thenCallsGetType2() throws PricingException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    OrderService orderService = mock(OrderService.class);
    when(orderService.save(Mockito.<Order>any(), Mockito.<Boolean>any())).thenReturn(new NullOrderImpl());

    OfferServiceImpl offerServiceImpl = new OfferServiceImpl();
    offerServiceImpl.setOrderService(orderService);
    offerServiceImpl.setOrderOfferProcessor(new FulfillmentGroupOfferProcessorImpl(new PromotableOfferUtilityImpl()));
    offerServiceImpl.setPromotableItemFactory(new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()));
    OfferImpl offerImpl = mock(OfferImpl.class);
    when(offerImpl.getType()).thenReturn(OfferType.ORDER);

    ArrayList<Offer> offers = new ArrayList<>();
    offers.add(offerImpl);

    // Act
    offerServiceImpl.applyFulfillmentGroupOffersToOrder(offers, new NullOrderImpl());

    // Assert
    verify(offerImpl).getType();
    verify(orderService).save(isA(Order.class), eq(false));
  }

  /**
   * Test {@link OfferServiceImpl#applyAndSaveFulfillmentGroupOffersToOrder(List, Order)}.
   * <ul>
   *   <li>Then return {@link NullOrderImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferServiceImpl#applyAndSaveFulfillmentGroupOffersToOrder(List, Order)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Order OfferServiceImpl.applyAndSaveFulfillmentGroupOffersToOrder(List, Order)"})
  public void testApplyAndSaveFulfillmentGroupOffersToOrder_thenReturnNullOrderImpl() throws PricingException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    OrderService orderService = mock(OrderService.class);
    NullOrderImpl nullOrderImpl = new NullOrderImpl();
    when(orderService.save(Mockito.<Order>any(), Mockito.<Boolean>any())).thenReturn(nullOrderImpl);

    OfferServiceImpl offerServiceImpl = new OfferServiceImpl();
    offerServiceImpl.setOrderService(orderService);
    offerServiceImpl.setOrderOfferProcessor(new FulfillmentGroupOfferProcessorImpl(new PromotableOfferUtilityImpl()));
    offerServiceImpl.setPromotableItemFactory(new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()));
    OfferImpl offerImpl = mock(OfferImpl.class);
    when(offerImpl.getType()).thenReturn(OfferType.ORDER);

    ArrayList<Offer> offers = new ArrayList<>();
    offers.add(offerImpl);

    // Act
    Order actualApplyAndSaveFulfillmentGroupOffersToOrderResult = offerServiceImpl
        .applyAndSaveFulfillmentGroupOffersToOrder(offers, new NullOrderImpl());

    // Assert
    verify(offerImpl).getType();
    verify(orderService).save(isA(Order.class), eq(false));
    assertSame(nullOrderImpl, actualApplyAndSaveFulfillmentGroupOffersToOrderResult);
  }

  /**
   * Test {@link OfferServiceImpl#applyAndSaveFulfillmentGroupOffersToOrder(List, Order)}.
   * <ul>
   *   <li>Then return {@link NullOrderImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferServiceImpl#applyAndSaveFulfillmentGroupOffersToOrder(List, Order)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Order OfferServiceImpl.applyAndSaveFulfillmentGroupOffersToOrder(List, Order)"})
  public void testApplyAndSaveFulfillmentGroupOffersToOrder_thenReturnNullOrderImpl2() throws PricingException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    OrderService orderService = mock(OrderService.class);
    NullOrderImpl nullOrderImpl = new NullOrderImpl();
    when(orderService.save(Mockito.<Order>any(), Mockito.<Boolean>any())).thenReturn(nullOrderImpl);

    OfferServiceImpl offerServiceImpl = new OfferServiceImpl();
    offerServiceImpl.setOrderService(orderService);
    offerServiceImpl.setOrderOfferProcessor(new FulfillmentGroupOfferProcessorImpl(new PromotableOfferUtilityImpl()));
    offerServiceImpl.setPromotableItemFactory(new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()));
    OfferImpl offerImpl = mock(OfferImpl.class);
    when(offerImpl.getType()).thenReturn(OfferType.ORDER);

    ArrayList<Offer> offers = new ArrayList<>();
    offers.add(offerImpl);

    // Act
    Order actualApplyAndSaveFulfillmentGroupOffersToOrderResult = offerServiceImpl
        .applyAndSaveFulfillmentGroupOffersToOrder(offers, new NullOrderImpl());

    // Assert
    verify(offerImpl).getType();
    verify(orderService).save(isA(Order.class), eq(false));
    assertSame(nullOrderImpl, actualApplyAndSaveFulfillmentGroupOffersToOrderResult);
  }

  /**
   * Test {@link OfferServiceImpl#getOffersRetrievedFromCodes(List, Set)} with {@code codes}, {@code appliedOffers}.
   * <p>
   * Method under test: {@link OfferServiceImpl#getOffersRetrievedFromCodes(List, Set)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map OfferServiceImpl.getOffersRetrievedFromCodes(List, Set)"})
  public void testGetOffersRetrievedFromCodesWithCodesAppliedOffers() {
    // Arrange
    when(offerServiceExtensionManager.getProxy()).thenReturn(new AbstractOfferServiceExtensionHandler());

    ArrayList<OfferCode> codes = new ArrayList<>();
    codes.add(new OfferCodeImpl());

    // Act
    Map<Offer, OfferCode> actualOffersRetrievedFromCodes = offerServiceImpl.getOffersRetrievedFromCodes(codes,
        new HashSet<>());

    // Assert
    verify(offerServiceExtensionManager).getProxy();
    assertTrue(actualOffersRetrievedFromCodes.isEmpty());
  }

  /**
   * Test {@link OfferServiceImpl#getOffersRetrievedFromCodes(List, Set)} with {@code codes}, {@code appliedOffers}.
   * <p>
   * Method under test: {@link OfferServiceImpl#getOffersRetrievedFromCodes(List, Set)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map OfferServiceImpl.getOffersRetrievedFromCodes(List, Set)"})
  public void testGetOffersRetrievedFromCodesWithCodesAppliedOffers2() {
    // Arrange
    when(offerServiceExtensionManager.getProxy()).thenReturn(new OfferServiceExtensionManager());

    ArrayList<OfferCode> codes = new ArrayList<>();
    codes.add(new OfferCodeImpl());

    // Act
    Map<Offer, OfferCode> actualOffersRetrievedFromCodes = offerServiceImpl.getOffersRetrievedFromCodes(codes,
        new HashSet<>());

    // Assert
    verify(offerServiceExtensionManager).getProxy();
    assertTrue(actualOffersRetrievedFromCodes.isEmpty());
  }

  /**
   * Test {@link OfferServiceImpl#getOffersRetrievedFromCodes(List, Set)} with {@code codes}, {@code appliedOffers}.
   * <p>
   * Method under test: {@link OfferServiceImpl#getOffersRetrievedFromCodes(List, Set)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map OfferServiceImpl.getOffersRetrievedFromCodes(List, Set)"})
  public void testGetOffersRetrievedFromCodesWithCodesAppliedOffers3() {
    // Arrange
    when(offerServiceExtensionManager.getProxy()).thenReturn(new AbstractOfferServiceExtensionHandler());

    ArrayList<OfferCode> codes = new ArrayList<>();
    codes.add(new OfferCodeImpl());
    codes.add(new OfferCodeImpl());

    // Act
    Map<Offer, OfferCode> actualOffersRetrievedFromCodes = offerServiceImpl.getOffersRetrievedFromCodes(codes,
        new HashSet<>());

    // Assert
    verify(offerServiceExtensionManager, atLeast(1)).getProxy();
    assertTrue(actualOffersRetrievedFromCodes.isEmpty());
  }

  /**
   * Test {@link OfferServiceImpl#getOffersRetrievedFromCodes(List, Set)} with {@code codes}, {@code appliedOffers}.
   * <p>
   * Method under test: {@link OfferServiceImpl#getOffersRetrievedFromCodes(List, Set)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map OfferServiceImpl.getOffersRetrievedFromCodes(List, Set)"})
  public void testGetOffersRetrievedFromCodesWithCodesAppliedOffers4() {
    // Arrange
    OfferServiceExtensionManager offerServiceExtensionManager2 = new OfferServiceExtensionManager();
    ArrayList<Offer> offers = new ArrayList<>();
    offerServiceExtensionManager2.addAdditionalOffersForCode(offers, new OfferCodeImpl());
    when(offerServiceExtensionManager.getProxy()).thenReturn(offerServiceExtensionManager2);

    ArrayList<OfferCode> codes = new ArrayList<>();
    codes.add(new OfferCodeImpl());

    // Act
    Map<Offer, OfferCode> actualOffersRetrievedFromCodes = offerServiceImpl.getOffersRetrievedFromCodes(codes,
        new HashSet<>());

    // Assert
    verify(offerServiceExtensionManager).getProxy();
    assertTrue(actualOffersRetrievedFromCodes.isEmpty());
  }

  /**
   * Test {@link OfferServiceImpl#getOffersRetrievedFromCodes(List, Set)} with {@code codes}, {@code appliedOffers}.
   * <p>
   * Method under test: {@link OfferServiceImpl#getOffersRetrievedFromCodes(List, Set)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map OfferServiceImpl.getOffersRetrievedFromCodes(List, Set)"})
  public void testGetOffersRetrievedFromCodesWithCodesAppliedOffers5() {
    // Arrange
    OfferServiceExtensionManager offerServiceExtensionManager2 = new OfferServiceExtensionManager();
    offerServiceExtensionManager2.registerHandler(new AbstractOfferServiceExtensionHandler());
    ArrayList<Offer> offers = new ArrayList<>();
    offerServiceExtensionManager2.addAdditionalOffersForCode(offers, new OfferCodeImpl());
    when(offerServiceExtensionManager.getProxy()).thenReturn(offerServiceExtensionManager2);

    ArrayList<OfferCode> codes = new ArrayList<>();
    codes.add(new OfferCodeImpl());

    // Act
    Map<Offer, OfferCode> actualOffersRetrievedFromCodes = offerServiceImpl.getOffersRetrievedFromCodes(codes,
        new HashSet<>());

    // Assert
    verify(offerServiceExtensionManager).getProxy();
    assertTrue(actualOffersRetrievedFromCodes.isEmpty());
  }

  /**
   * Test {@link OfferServiceImpl#getOffersRetrievedFromCodes(List, Set)} with {@code codes}, {@code appliedOffers}.
   * <p>
   * Method under test: {@link OfferServiceImpl#getOffersRetrievedFromCodes(List, Set)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map OfferServiceImpl.getOffersRetrievedFromCodes(List, Set)"})
  public void testGetOffersRetrievedFromCodesWithCodesAppliedOffers6() {
    // Arrange
    when(offerServiceExtensionManager.getProxy()).thenReturn(new AbstractOfferServiceExtensionHandler());

    ArrayList<OfferCode> codes = new ArrayList<>();
    codes.add(new OfferCodeImpl());

    // Act
    Map<Offer, OfferCode> actualOffersRetrievedFromCodes = offerServiceImpl.getOffersRetrievedFromCodes(codes,
        new HashSet<>());

    // Assert
    verify(offerServiceExtensionManager).getProxy();
    assertTrue(actualOffersRetrievedFromCodes.isEmpty());
  }

  /**
   * Test {@link OfferServiceImpl#getOffersRetrievedFromCodes(List, Set)} with {@code codes}, {@code appliedOffers}.
   * <p>
   * Method under test: {@link OfferServiceImpl#getOffersRetrievedFromCodes(List, Set)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map OfferServiceImpl.getOffersRetrievedFromCodes(List, Set)"})
  public void testGetOffersRetrievedFromCodesWithCodesAppliedOffers7() {
    // Arrange
    when(offerServiceExtensionManager.getProxy()).thenReturn(new OfferServiceExtensionManager());

    ArrayList<OfferCode> codes = new ArrayList<>();
    codes.add(new OfferCodeImpl());

    // Act
    Map<Offer, OfferCode> actualOffersRetrievedFromCodes = offerServiceImpl.getOffersRetrievedFromCodes(codes,
        new HashSet<>());

    // Assert
    verify(offerServiceExtensionManager).getProxy();
    assertTrue(actualOffersRetrievedFromCodes.isEmpty());
  }

  /**
   * Test {@link OfferServiceImpl#getOffersRetrievedFromCodes(List, Set)} with {@code codes}, {@code appliedOffers}.
   * <p>
   * Method under test: {@link OfferServiceImpl#getOffersRetrievedFromCodes(List, Set)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map OfferServiceImpl.getOffersRetrievedFromCodes(List, Set)"})
  public void testGetOffersRetrievedFromCodesWithCodesAppliedOffers8() {
    // Arrange
    when(offerServiceExtensionManager.getProxy()).thenReturn(new AbstractOfferServiceExtensionHandler());

    ArrayList<OfferCode> codes = new ArrayList<>();
    codes.add(new OfferCodeImpl());
    codes.add(new OfferCodeImpl());

    // Act
    Map<Offer, OfferCode> actualOffersRetrievedFromCodes = offerServiceImpl.getOffersRetrievedFromCodes(codes,
        new HashSet<>());

    // Assert
    verify(offerServiceExtensionManager, atLeast(1)).getProxy();
    assertTrue(actualOffersRetrievedFromCodes.isEmpty());
  }

  /**
   * Test {@link OfferServiceImpl#getOffersRetrievedFromCodes(List, Set)} with {@code codes}, {@code appliedOffers}.
   * <p>
   * Method under test: {@link OfferServiceImpl#getOffersRetrievedFromCodes(List, Set)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map OfferServiceImpl.getOffersRetrievedFromCodes(List, Set)"})
  public void testGetOffersRetrievedFromCodesWithCodesAppliedOffers9() {
    // Arrange
    OfferServiceExtensionManager offerServiceExtensionManager2 = new OfferServiceExtensionManager();
    ArrayList<Offer> offers = new ArrayList<>();
    offerServiceExtensionManager2.addAdditionalOffersForCode(offers, new OfferCodeImpl());
    when(offerServiceExtensionManager.getProxy()).thenReturn(offerServiceExtensionManager2);

    ArrayList<OfferCode> codes = new ArrayList<>();
    codes.add(new OfferCodeImpl());

    // Act
    Map<Offer, OfferCode> actualOffersRetrievedFromCodes = offerServiceImpl.getOffersRetrievedFromCodes(codes,
        new HashSet<>());

    // Assert
    verify(offerServiceExtensionManager).getProxy();
    assertTrue(actualOffersRetrievedFromCodes.isEmpty());
  }

  /**
   * Test {@link OfferServiceImpl#getOffersRetrievedFromCodes(List, Set)} with {@code codes}, {@code appliedOffers}.
   * <p>
   * Method under test: {@link OfferServiceImpl#getOffersRetrievedFromCodes(List, Set)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map OfferServiceImpl.getOffersRetrievedFromCodes(List, Set)"})
  public void testGetOffersRetrievedFromCodesWithCodesAppliedOffers10() {
    // Arrange
    OfferServiceExtensionManager offerServiceExtensionManager2 = new OfferServiceExtensionManager();
    offerServiceExtensionManager2.registerHandler(new AbstractOfferServiceExtensionHandler());
    ArrayList<Offer> offers = new ArrayList<>();
    offerServiceExtensionManager2.addAdditionalOffersForCode(offers, new OfferCodeImpl());
    when(offerServiceExtensionManager.getProxy()).thenReturn(offerServiceExtensionManager2);

    ArrayList<OfferCode> codes = new ArrayList<>();
    codes.add(new OfferCodeImpl());

    // Act
    Map<Offer, OfferCode> actualOffersRetrievedFromCodes = offerServiceImpl.getOffersRetrievedFromCodes(codes,
        new HashSet<>());

    // Assert
    verify(offerServiceExtensionManager).getProxy();
    assertTrue(actualOffersRetrievedFromCodes.isEmpty());
  }

  /**
   * Test {@link OfferServiceImpl#getOffersRetrievedFromCodes(List, Set)} with {@code codes}, {@code appliedOffers}.
   * <ul>
   *   <li>Given {@link OfferImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferServiceImpl#getOffersRetrievedFromCodes(List, Set)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map OfferServiceImpl.getOffersRetrievedFromCodes(List, Set)"})
  public void testGetOffersRetrievedFromCodesWithCodesAppliedOffers_givenOfferImpl() {
    // Arrange
    when(offerServiceExtensionManager.getProxy()).thenReturn(new AbstractOfferServiceExtensionHandler());

    ArrayList<OfferCode> codes = new ArrayList<>();
    codes.add(new OfferCodeImpl());

    HashSet<Offer> appliedOffers = new HashSet<>();
    appliedOffers.add(new OfferImpl());

    // Act
    Map<Offer, OfferCode> actualOffersRetrievedFromCodes = offerServiceImpl.getOffersRetrievedFromCodes(codes,
        appliedOffers);

    // Assert
    verify(offerServiceExtensionManager).getProxy();
    assertTrue(actualOffersRetrievedFromCodes.isEmpty());
  }

  /**
   * Test {@link OfferServiceImpl#getOffersRetrievedFromCodes(List, Set)} with {@code codes}, {@code appliedOffers}.
   * <ul>
   *   <li>Given {@link OfferImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferServiceImpl#getOffersRetrievedFromCodes(List, Set)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map OfferServiceImpl.getOffersRetrievedFromCodes(List, Set)"})
  public void testGetOffersRetrievedFromCodesWithCodesAppliedOffers_givenOfferImpl2() {
    // Arrange
    when(offerServiceExtensionManager.getProxy()).thenReturn(new AbstractOfferServiceExtensionHandler());

    ArrayList<OfferCode> codes = new ArrayList<>();
    codes.add(new OfferCodeImpl());

    HashSet<Offer> appliedOffers = new HashSet<>();
    appliedOffers.add(new OfferImpl());

    // Act
    Map<Offer, OfferCode> actualOffersRetrievedFromCodes = offerServiceImpl.getOffersRetrievedFromCodes(codes,
        appliedOffers);

    // Assert
    verify(offerServiceExtensionManager).getProxy();
    assertTrue(actualOffersRetrievedFromCodes.isEmpty());
  }

  /**
   * Test {@link OfferServiceImpl#getOffersRetrievedFromCodes(List, Set)} with {@code codes}, {@code appliedOffers}.
   * <ul>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferServiceImpl#getOffersRetrievedFromCodes(List, Set)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map OfferServiceImpl.getOffersRetrievedFromCodes(List, Set)"})
  public void testGetOffersRetrievedFromCodesWithCodesAppliedOffers_thenReturnSizeIsOne() {
    // Arrange
    when(offerServiceExtensionManager.getProxy()).thenReturn(new AbstractOfferServiceExtensionHandler());
    OfferCodeImpl offerCodeImpl = mock(OfferCodeImpl.class);
    when(offerCodeImpl.getOffer()).thenReturn(new OfferImpl());

    ArrayList<OfferCode> codes = new ArrayList<>();
    codes.add(offerCodeImpl);

    HashSet<Offer> appliedOffers = new HashSet<>();
    appliedOffers.add(new OfferImpl());

    // Act
    Map<Offer, OfferCode> actualOffersRetrievedFromCodes = offerServiceImpl.getOffersRetrievedFromCodes(codes,
        appliedOffers);

    // Assert
    verify(offerServiceExtensionManager).getProxy();
    verify(offerCodeImpl, atLeast(1)).getOffer();
    assertEquals(1, actualOffersRetrievedFromCodes.size());
  }

  /**
   * Test {@link OfferServiceImpl#getOffersRetrievedFromCodes(List, Set)} with {@code codes}, {@code appliedOffers}.
   * <ul>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferServiceImpl#getOffersRetrievedFromCodes(List, Set)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map OfferServiceImpl.getOffersRetrievedFromCodes(List, Set)"})
  public void testGetOffersRetrievedFromCodesWithCodesAppliedOffers_thenReturnSizeIsOne2() {
    // Arrange
    when(offerServiceExtensionManager.getProxy()).thenReturn(new AbstractOfferServiceExtensionHandler());
    OfferCodeImpl offerCodeImpl = mock(OfferCodeImpl.class);
    when(offerCodeImpl.getOffer()).thenReturn(new OfferImpl());

    ArrayList<OfferCode> codes = new ArrayList<>();
    codes.add(offerCodeImpl);

    HashSet<Offer> appliedOffers = new HashSet<>();
    appliedOffers.add(new OfferImpl());

    // Act
    Map<Offer, OfferCode> actualOffersRetrievedFromCodes = offerServiceImpl.getOffersRetrievedFromCodes(codes,
        appliedOffers);

    // Assert
    verify(offerServiceExtensionManager).getProxy();
    verify(offerCodeImpl, atLeast(1)).getOffer();
    assertEquals(1, actualOffersRetrievedFromCodes.size());
  }

  /**
   * Test {@link OfferServiceImpl#getOffersRetrievedFromCodes(List, Set)} with {@code codes}, {@code appliedOffers}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferServiceImpl#getOffersRetrievedFromCodes(List, Set)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map OfferServiceImpl.getOffersRetrievedFromCodes(List, Set)"})
  public void testGetOffersRetrievedFromCodesWithCodesAppliedOffers_thenThrowRuntimeException() {
    // Arrange
    when(offerServiceExtensionManager.getProxy()).thenThrow(new RuntimeException("foo"));

    ArrayList<OfferCode> codes = new ArrayList<>();
    codes.add(new OfferCodeImpl());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> offerServiceImpl.getOffersRetrievedFromCodes(codes, new HashSet<>()));
    verify(offerServiceExtensionManager).getProxy();
  }

  /**
   * Test {@link OfferServiceImpl#getOffersRetrievedFromCodes(List, Set)} with {@code codes}, {@code appliedOffers}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferServiceImpl#getOffersRetrievedFromCodes(List, Set)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map OfferServiceImpl.getOffersRetrievedFromCodes(List, Set)"})
  public void testGetOffersRetrievedFromCodesWithCodesAppliedOffers_thenThrowRuntimeException2() {
    // Arrange
    when(offerServiceExtensionManager.getProxy()).thenThrow(new RuntimeException("foo"));

    ArrayList<OfferCode> codes = new ArrayList<>();
    codes.add(new OfferCodeImpl());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> offerServiceImpl.getOffersRetrievedFromCodes(codes, new HashSet<>()));
    verify(offerServiceExtensionManager).getProxy();
  }

  /**
   * Test {@link OfferServiceImpl#getOffersRetrievedFromCodes(List, Set)} with {@code codes}, {@code appliedOffers}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferServiceImpl#getOffersRetrievedFromCodes(List, Set)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map OfferServiceImpl.getOffersRetrievedFromCodes(List, Set)"})
  public void testGetOffersRetrievedFromCodesWithCodesAppliedOffers_whenArrayList() {
    // Arrange
    ArrayList<OfferCode> codes = new ArrayList<>();

    // Act and Assert
    assertTrue(offerServiceImpl.getOffersRetrievedFromCodes(codes, new HashSet<>()).isEmpty());
  }

  /**
   * Test {@link OfferServiceImpl#getOffersRetrievedFromCodes(List, Set)} with {@code codes}, {@code appliedOffers}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferServiceImpl#getOffersRetrievedFromCodes(List, Set)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map OfferServiceImpl.getOffersRetrievedFromCodes(List, Set)"})
  public void testGetOffersRetrievedFromCodesWithCodesAppliedOffers_whenArrayList2() {
    // Arrange
    ArrayList<OfferCode> codes = new ArrayList<>();

    // Act and Assert
    assertTrue(offerServiceImpl.getOffersRetrievedFromCodes(codes, new HashSet<>()).isEmpty());
  }

  /**
   * Test {@link OfferServiceImpl#getOffersRetrievedFromCodes(Order)} with {@code order}.
   * <p>
   * Method under test: {@link OfferServiceImpl#getOffersRetrievedFromCodes(Order)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map OfferServiceImpl.getOffersRetrievedFromCodes(Order)"})
  public void testGetOffersRetrievedFromCodesWithOrder() {
    // Arrange
    when(offerServiceExtensionManager.getProxy()).thenReturn(new OfferServiceExtensionManager());

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    OrderImpl order = new OrderImpl();
    order.addAddedOfferCode(new OfferCodeImpl());
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCurrency(new BroadleafCurrencyImpl());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
    order.setFulfillmentGroups(new ArrayList<>());
    order.setId(1L);
    order.setLocale(new LocaleImpl());
    order.setName("Name");
    order.setOrderAttributes(new HashMap<>());
    order.setOrderItems(new ArrayList<>());
    order.setOrderMessages(new ArrayList<>());
    order.setOrderNumber("42");
    order.setPayments(new ArrayList<>());
    order.setStatus(OrderStatus.ARCHIVED);
    order.setSubTotal(new Money());
    order.setSubmitDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalShipping(new Money());
    order.setTotalTax(new Money());

    // Act
    Map<Offer, OfferCode> actualOffersRetrievedFromCodes = offerServiceImpl.getOffersRetrievedFromCodes(order);

    // Assert
    verify(offerServiceExtensionManager).getProxy();
    assertTrue(actualOffersRetrievedFromCodes.isEmpty());
  }

  /**
   * Test {@link OfferServiceImpl#getOffersRetrievedFromCodes(Order)} with {@code order}.
   * <p>
   * Method under test: {@link OfferServiceImpl#getOffersRetrievedFromCodes(Order)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map OfferServiceImpl.getOffersRetrievedFromCodes(Order)"})
  public void testGetOffersRetrievedFromCodesWithOrder2() {
    // Arrange
    when(offerServiceExtensionManager.getProxy()).thenReturn(new OfferServiceExtensionManager());

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    OrderImpl order = new OrderImpl();
    order.addAddedOfferCode(new OfferCodeImpl());
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCurrency(new BroadleafCurrencyImpl());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
    order.setFulfillmentGroups(new ArrayList<>());
    order.setId(1L);
    order.setLocale(new LocaleImpl());
    order.setName("Name");
    order.setOrderAttributes(new HashMap<>());
    order.setOrderItems(new ArrayList<>());
    order.setOrderMessages(new ArrayList<>());
    order.setOrderNumber("42");
    order.setPayments(new ArrayList<>());
    order.setStatus(OrderStatus.ARCHIVED);
    order.setSubTotal(new Money());
    order.setSubmitDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalShipping(new Money());
    order.setTotalTax(new Money());

    // Act
    Map<Offer, OfferCode> actualOffersRetrievedFromCodes = offerServiceImpl.getOffersRetrievedFromCodes(order);

    // Assert
    verify(offerServiceExtensionManager).getProxy();
    assertTrue(actualOffersRetrievedFromCodes.isEmpty());
  }

  /**
   * Test {@link OfferServiceImpl#getOffersRetrievedFromCodes(Order)} with {@code order}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link BundleOrderItemImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferServiceImpl#getOffersRetrievedFromCodes(Order)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map OfferServiceImpl.getOffersRetrievedFromCodes(Order)"})
  public void testGetOffersRetrievedFromCodesWithOrder_givenArrayListAddBundleOrderItemImpl() {
    // Arrange
    when(offerServiceExtensionManager.getProxy()).thenReturn(new AbstractOfferServiceExtensionHandler());

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    ArrayList<OrderItem> orderItems = new ArrayList<>();
    orderItems.add(new BundleOrderItemImpl());

    OrderImpl order = new OrderImpl();
    order.addAddedOfferCode(new OfferCodeImpl());
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCurrency(new BroadleafCurrencyImpl());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
    order.setFulfillmentGroups(new ArrayList<>());
    order.setId(1L);
    order.setLocale(new LocaleImpl());
    order.setName("Name");
    order.setOrderAttributes(new HashMap<>());
    order.setOrderItems(orderItems);
    order.setOrderMessages(new ArrayList<>());
    order.setOrderNumber("42");
    order.setPayments(new ArrayList<>());
    order.setStatus(OrderStatus.ARCHIVED);
    order.setSubTotal(new Money());
    order.setSubmitDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalShipping(new Money());
    order.setTotalTax(new Money());

    // Act
    Map<Offer, OfferCode> actualOffersRetrievedFromCodes = offerServiceImpl.getOffersRetrievedFromCodes(order);

    // Assert
    verify(offerServiceExtensionManager).getProxy();
    assertTrue(actualOffersRetrievedFromCodes.isEmpty());
  }

  /**
   * Test {@link OfferServiceImpl#getOffersRetrievedFromCodes(Order)} with {@code order}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link BundleOrderItemImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferServiceImpl#getOffersRetrievedFromCodes(Order)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map OfferServiceImpl.getOffersRetrievedFromCodes(Order)"})
  public void testGetOffersRetrievedFromCodesWithOrder_givenArrayListAddBundleOrderItemImpl2() {
    // Arrange
    when(offerServiceExtensionManager.getProxy()).thenReturn(new AbstractOfferServiceExtensionHandler());

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    ArrayList<OrderItem> orderItems = new ArrayList<>();
    orderItems.add(new BundleOrderItemImpl());

    OrderImpl order = new OrderImpl();
    order.addAddedOfferCode(new OfferCodeImpl());
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCurrency(new BroadleafCurrencyImpl());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
    order.setFulfillmentGroups(new ArrayList<>());
    order.setId(1L);
    order.setLocale(new LocaleImpl());
    order.setName("Name");
    order.setOrderAttributes(new HashMap<>());
    order.setOrderItems(orderItems);
    order.setOrderMessages(new ArrayList<>());
    order.setOrderNumber("42");
    order.setPayments(new ArrayList<>());
    order.setStatus(OrderStatus.ARCHIVED);
    order.setSubTotal(new Money());
    order.setSubmitDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalShipping(new Money());
    order.setTotalTax(new Money());

    // Act
    Map<Offer, OfferCode> actualOffersRetrievedFromCodes = offerServiceImpl.getOffersRetrievedFromCodes(order);

    // Assert
    verify(offerServiceExtensionManager).getProxy();
    assertTrue(actualOffersRetrievedFromCodes.isEmpty());
  }

  /**
   * Test {@link OfferServiceImpl#getOffersRetrievedFromCodes(Order)} with {@code order}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link FulfillmentGroupImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferServiceImpl#getOffersRetrievedFromCodes(Order)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map OfferServiceImpl.getOffersRetrievedFromCodes(Order)"})
  public void testGetOffersRetrievedFromCodesWithOrder_givenArrayListAddFulfillmentGroupImpl() {
    // Arrange
    when(offerServiceExtensionManager.getProxy()).thenReturn(new AbstractOfferServiceExtensionHandler());

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    ArrayList<FulfillmentGroup> fulfillmentGroups = new ArrayList<>();
    fulfillmentGroups.add(new FulfillmentGroupImpl());

    OrderImpl order = new OrderImpl();
    order.addAddedOfferCode(new OfferCodeImpl());
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCurrency(new BroadleafCurrencyImpl());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
    order.setFulfillmentGroups(fulfillmentGroups);
    order.setId(1L);
    order.setLocale(new LocaleImpl());
    order.setName("Name");
    order.setOrderAttributes(new HashMap<>());
    order.setOrderItems(new ArrayList<>());
    order.setOrderMessages(new ArrayList<>());
    order.setOrderNumber("42");
    order.setPayments(new ArrayList<>());
    order.setStatus(OrderStatus.ARCHIVED);
    order.setSubTotal(new Money());
    order.setSubmitDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalShipping(new Money());
    order.setTotalTax(new Money());

    // Act
    Map<Offer, OfferCode> actualOffersRetrievedFromCodes = offerServiceImpl.getOffersRetrievedFromCodes(order);

    // Assert
    verify(offerServiceExtensionManager).getProxy();
    assertTrue(actualOffersRetrievedFromCodes.isEmpty());
  }

  /**
   * Test {@link OfferServiceImpl#getOffersRetrievedFromCodes(Order)} with {@code order}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link FulfillmentGroupImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferServiceImpl#getOffersRetrievedFromCodes(Order)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map OfferServiceImpl.getOffersRetrievedFromCodes(Order)"})
  public void testGetOffersRetrievedFromCodesWithOrder_givenArrayListAddFulfillmentGroupImpl2() {
    // Arrange
    when(offerServiceExtensionManager.getProxy()).thenReturn(new AbstractOfferServiceExtensionHandler());

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    ArrayList<FulfillmentGroup> fulfillmentGroups = new ArrayList<>();
    fulfillmentGroups.add(new FulfillmentGroupImpl());

    OrderImpl order = new OrderImpl();
    order.addAddedOfferCode(new OfferCodeImpl());
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCurrency(new BroadleafCurrencyImpl());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
    order.setFulfillmentGroups(fulfillmentGroups);
    order.setId(1L);
    order.setLocale(new LocaleImpl());
    order.setName("Name");
    order.setOrderAttributes(new HashMap<>());
    order.setOrderItems(new ArrayList<>());
    order.setOrderMessages(new ArrayList<>());
    order.setOrderNumber("42");
    order.setPayments(new ArrayList<>());
    order.setStatus(OrderStatus.ARCHIVED);
    order.setSubTotal(new Money());
    order.setSubmitDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalShipping(new Money());
    order.setTotalTax(new Money());

    // Act
    Map<Offer, OfferCode> actualOffersRetrievedFromCodes = offerServiceImpl.getOffersRetrievedFromCodes(order);

    // Assert
    verify(offerServiceExtensionManager).getProxy();
    assertTrue(actualOffersRetrievedFromCodes.isEmpty());
  }

  /**
   * Test {@link OfferServiceImpl#getOffersRetrievedFromCodes(Order)} with {@code order}.
   * <ul>
   *   <li>Then calls {@link ExtensionManager#getProxy()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferServiceImpl#getOffersRetrievedFromCodes(Order)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map OfferServiceImpl.getOffersRetrievedFromCodes(Order)"})
  public void testGetOffersRetrievedFromCodesWithOrder_thenCallsGetProxy() {
    // Arrange
    when(offerServiceExtensionManager.getProxy()).thenReturn(new AbstractOfferServiceExtensionHandler());

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    OrderImpl order = new OrderImpl();
    order.addAddedOfferCode(new OfferCodeImpl());
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCurrency(new BroadleafCurrencyImpl());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
    order.setFulfillmentGroups(new ArrayList<>());
    order.setId(1L);
    order.setLocale(new LocaleImpl());
    order.setName("Name");
    order.setOrderAttributes(new HashMap<>());
    order.setOrderItems(new ArrayList<>());
    order.setOrderMessages(new ArrayList<>());
    order.setOrderNumber("42");
    order.setPayments(new ArrayList<>());
    order.setStatus(OrderStatus.ARCHIVED);
    order.setSubTotal(new Money());
    order.setSubmitDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalShipping(new Money());
    order.setTotalTax(new Money());

    // Act
    Map<Offer, OfferCode> actualOffersRetrievedFromCodes = offerServiceImpl.getOffersRetrievedFromCodes(order);

    // Assert
    verify(offerServiceExtensionManager).getProxy();
    assertTrue(actualOffersRetrievedFromCodes.isEmpty());
  }

  /**
   * Test {@link OfferServiceImpl#getOffersRetrievedFromCodes(Order)} with {@code order}.
   * <ul>
   *   <li>Then calls {@link ExtensionManager#getProxy()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferServiceImpl#getOffersRetrievedFromCodes(Order)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map OfferServiceImpl.getOffersRetrievedFromCodes(Order)"})
  public void testGetOffersRetrievedFromCodesWithOrder_thenCallsGetProxy2() {
    // Arrange
    when(offerServiceExtensionManager.getProxy()).thenReturn(new AbstractOfferServiceExtensionHandler());

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    OrderImpl order = new OrderImpl();
    order.addAddedOfferCode(new OfferCodeImpl());
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCurrency(new BroadleafCurrencyImpl());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
    order.setFulfillmentGroups(new ArrayList<>());
    order.setId(1L);
    order.setLocale(new LocaleImpl());
    order.setName("Name");
    order.setOrderAttributes(new HashMap<>());
    order.setOrderItems(new ArrayList<>());
    order.setOrderMessages(new ArrayList<>());
    order.setOrderNumber("42");
    order.setPayments(new ArrayList<>());
    order.setStatus(OrderStatus.ARCHIVED);
    order.setSubTotal(new Money());
    order.setSubmitDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalShipping(new Money());
    order.setTotalTax(new Money());

    // Act
    Map<Offer, OfferCode> actualOffersRetrievedFromCodes = offerServiceImpl.getOffersRetrievedFromCodes(order);

    // Assert
    verify(offerServiceExtensionManager).getProxy();
    assertTrue(actualOffersRetrievedFromCodes.isEmpty());
  }

  /**
   * Test {@link OfferServiceImpl#getOffersRetrievedFromCodes(Order)} with {@code order}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferServiceImpl#getOffersRetrievedFromCodes(Order)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map OfferServiceImpl.getOffersRetrievedFromCodes(Order)"})
  public void testGetOffersRetrievedFromCodesWithOrder_thenReturnEmpty() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCurrency(new BroadleafCurrencyImpl());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
    order.setFulfillmentGroups(new ArrayList<>());
    order.setId(1L);
    order.setLocale(new LocaleImpl());
    order.setName("Name");
    order.setOrderAttributes(new HashMap<>());
    order.setOrderItems(new ArrayList<>());
    order.setOrderMessages(new ArrayList<>());
    order.setOrderNumber("42");
    order.setPayments(new ArrayList<>());
    order.setStatus(OrderStatus.ARCHIVED);
    order.setSubTotal(new Money());
    order.setSubmitDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalShipping(new Money());
    order.setTotalTax(new Money());

    // Act and Assert
    assertTrue(offerServiceImpl.getOffersRetrievedFromCodes(order).isEmpty());
  }

  /**
   * Test {@link OfferServiceImpl#getOffersRetrievedFromCodes(Order)} with {@code order}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferServiceImpl#getOffersRetrievedFromCodes(Order)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map OfferServiceImpl.getOffersRetrievedFromCodes(Order)"})
  public void testGetOffersRetrievedFromCodesWithOrder_thenReturnEmpty2() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCurrency(new BroadleafCurrencyImpl());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
    order.setFulfillmentGroups(new ArrayList<>());
    order.setId(1L);
    order.setLocale(new LocaleImpl());
    order.setName("Name");
    order.setOrderAttributes(new HashMap<>());
    order.setOrderItems(new ArrayList<>());
    order.setOrderMessages(new ArrayList<>());
    order.setOrderNumber("42");
    order.setPayments(new ArrayList<>());
    order.setStatus(OrderStatus.ARCHIVED);
    order.setSubTotal(new Money());
    order.setSubmitDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalShipping(new Money());
    order.setTotalTax(new Money());

    // Act and Assert
    assertTrue(offerServiceImpl.getOffersRetrievedFromCodes(order).isEmpty());
  }

  /**
   * Test {@link OfferServiceImpl#deleteOfferCode(OfferCode)}.
   * <ul>
   *   <li>Given {@link OfferCodeDao} {@link OfferCodeDao#offerCodeIsUsed(OfferCode)} return {@code false}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferServiceImpl#deleteOfferCode(OfferCode)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Boolean OfferServiceImpl.deleteOfferCode(OfferCode)"})
  public void testDeleteOfferCode_givenOfferCodeDaoOfferCodeIsUsedReturnFalse_thenReturnTrue() {
    // Arrange
    when(offerCodeDao.offerCodeIsUsed(Mockito.<OfferCode>any())).thenReturn(false);
    doNothing().when(offerCodeDao).delete(Mockito.<OfferCode>any());

    // Act
    Boolean actualDeleteOfferCodeResult = offerServiceImpl.deleteOfferCode(new OfferCodeImpl());

    // Assert
    verify(offerCodeDao).delete(isA(OfferCode.class));
    verify(offerCodeDao).offerCodeIsUsed(isA(OfferCode.class));
    assertTrue(actualDeleteOfferCodeResult);
  }

  /**
   * Test {@link OfferServiceImpl#deleteOfferCode(OfferCode)}.
   * <ul>
   *   <li>Given {@link OfferCodeDao} {@link OfferCodeDao#offerCodeIsUsed(OfferCode)} return {@code false}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferServiceImpl#deleteOfferCode(OfferCode)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Boolean OfferServiceImpl.deleteOfferCode(OfferCode)"})
  public void testDeleteOfferCode_givenOfferCodeDaoOfferCodeIsUsedReturnFalse_thenReturnTrue2() {
    // Arrange
    when(offerCodeDao.offerCodeIsUsed(Mockito.<OfferCode>any())).thenReturn(false);
    doNothing().when(offerCodeDao).delete(Mockito.<OfferCode>any());

    // Act
    Boolean actualDeleteOfferCodeResult = offerServiceImpl.deleteOfferCode(new OfferCodeImpl());

    // Assert
    verify(offerCodeDao).delete(isA(OfferCode.class));
    verify(offerCodeDao).offerCodeIsUsed(isA(OfferCode.class));
    assertTrue(actualDeleteOfferCodeResult);
  }

  /**
   * Test {@link OfferServiceImpl#deleteOfferCode(OfferCode)}.
   * <ul>
   *   <li>Given {@link OfferCodeDao} {@link OfferCodeDao#offerCodeIsUsed(OfferCode)} return {@code true}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferServiceImpl#deleteOfferCode(OfferCode)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Boolean OfferServiceImpl.deleteOfferCode(OfferCode)"})
  public void testDeleteOfferCode_givenOfferCodeDaoOfferCodeIsUsedReturnTrue_thenReturnFalse() {
    // Arrange
    when(offerCodeDao.offerCodeIsUsed(Mockito.<OfferCode>any())).thenReturn(true);

    // Act
    Boolean actualDeleteOfferCodeResult = offerServiceImpl.deleteOfferCode(new OfferCodeImpl());

    // Assert
    verify(offerCodeDao).offerCodeIsUsed(isA(OfferCode.class));
    assertFalse(actualDeleteOfferCodeResult);
  }

  /**
   * Test {@link OfferServiceImpl#deleteOfferCode(OfferCode)}.
   * <ul>
   *   <li>Given {@link OfferCodeDao} {@link OfferCodeDao#offerCodeIsUsed(OfferCode)} return {@code true}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferServiceImpl#deleteOfferCode(OfferCode)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Boolean OfferServiceImpl.deleteOfferCode(OfferCode)"})
  public void testDeleteOfferCode_givenOfferCodeDaoOfferCodeIsUsedReturnTrue_thenReturnFalse2() {
    // Arrange
    when(offerCodeDao.offerCodeIsUsed(Mockito.<OfferCode>any())).thenReturn(true);

    // Act
    Boolean actualDeleteOfferCodeResult = offerServiceImpl.deleteOfferCode(new OfferCodeImpl());

    // Assert
    verify(offerCodeDao).offerCodeIsUsed(isA(OfferCode.class));
    assertFalse(actualDeleteOfferCodeResult);
  }

  /**
   * Test {@link OfferServiceImpl#deleteOfferCode(OfferCode)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferServiceImpl#deleteOfferCode(OfferCode)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Boolean OfferServiceImpl.deleteOfferCode(OfferCode)"})
  public void testDeleteOfferCode_thenThrowRuntimeException() {
    // Arrange
    when(offerCodeDao.offerCodeIsUsed(Mockito.<OfferCode>any())).thenThrow(new RuntimeException("foo"));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> offerServiceImpl.deleteOfferCode(new OfferCodeImpl()));
    verify(offerCodeDao).offerCodeIsUsed(isA(OfferCode.class));
  }

  /**
   * Test {@link OfferServiceImpl#deleteOfferCode(OfferCode)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferServiceImpl#deleteOfferCode(OfferCode)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Boolean OfferServiceImpl.deleteOfferCode(OfferCode)"})
  public void testDeleteOfferCode_thenThrowRuntimeException2() {
    // Arrange
    when(offerCodeDao.offerCodeIsUsed(Mockito.<OfferCode>any())).thenThrow(new RuntimeException("foo"));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> offerServiceImpl.deleteOfferCode(new OfferCodeImpl()));
    verify(offerCodeDao).offerCodeIsUsed(isA(OfferCode.class));
  }

  /**
   * Test {@link OfferServiceImpl#duplicate(Long)}.
   * <ul>
   *   <li>Given {@link OfferImpl} (default constructor) AdjustmentType is {@link OfferAdjustmentType#FUTURE_CREDIT}.</li>
   *   <li>Then return {@link OfferImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferServiceImpl#duplicate(Long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Offer OfferServiceImpl.duplicate(Long)"})
  public void testDuplicate_givenOfferImplAdjustmentTypeIsFuture_credit_thenReturnOfferImpl() {
    // Arrange
    OfferImpl offerImpl = new OfferImpl();
    offerImpl.setAdjustmentType(OfferAdjustmentType.FUTURE_CREDIT);
    offerImpl.setApplyDiscountToSalePrice(true);
    offerImpl.setApplyToChildItems(true);
    offerImpl.setAutomaticallyAdded(true);
    offerImpl.setCombinableWithOtherOffers(true);
    offerImpl.setDescription("The characteristics of someone or something");
    offerImpl.setDiscountType(OfferDiscountType.AMOUNT_OFF);
    offerImpl.setEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerImpl.setId(OfferImpl.serialVersionUID);
    offerImpl.setMarketingMessage("Marketing Message");
    offerImpl.setMaxUsesPerCustomer(OfferImpl.serialVersionUID);
    offerImpl.setMaxUsesPerOrder(3);
    offerImpl.setMaxUsesStrategyType(CustomerMaxUsesStrategyType.ACCOUNT);
    offerImpl.setMinimumDaysPerUsage(OfferImpl.serialVersionUID);
    offerImpl.setName("Name");
    offerImpl.setOfferCodes(new ArrayList<>());
    offerImpl.setOfferItemQualifierRuleType(OfferItemRestrictionRuleType.NONE);
    offerImpl.setOfferItemTargetRuleType(OfferItemRestrictionRuleType.NONE);
    offerImpl.setOfferMatchRulesXref(new HashMap<>());
    offerImpl.setOfferPriceData(new ArrayList<>());
    offerImpl.setOrderMinSubTotal(new Money());
    offerImpl.setPriority(1);
    offerImpl.setQualifyingItemCriteriaXref(new HashSet<>());
    offerImpl.setQualifyingItemSubTotal(new Money());
    offerImpl.setRequiresRelatedTargetAndQualifiers(true);
    offerImpl.setStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerImpl.setTargetItemCriteriaXref(new HashSet<>());
    offerImpl.setTargetMinSubTotal(new Money());
    offerImpl.setTargetSystem("Target System");
    offerImpl.setTotalitarianOffer(true);
    offerImpl.setType(OfferType.FULFILLMENT_GROUP);
    offerImpl.setUseListForDiscounts(true);
    offerImpl.setValue(new BigDecimal("2.3"));
    when(entityDuplicator.copy(Mockito.<Class<OfferImpl>>any(), Mockito.<Long>any())).thenReturn(offerImpl);

    // Act
    Offer actualDuplicateResult = offerServiceImpl.duplicate(1L);

    // Assert
    verify(entityDuplicator).copy(isA(Class.class), eq(1L));
    assertSame(offerImpl, actualDuplicateResult);
  }

  /**
   * Test {@link OfferServiceImpl#duplicate(Long)}.
   * <ul>
   *   <li>Given {@link OfferImpl} (default constructor) AdjustmentType is {@link OfferAdjustmentType#FUTURE_CREDIT}.</li>
   *   <li>Then return {@link OfferImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferServiceImpl#duplicate(Long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Offer OfferServiceImpl.duplicate(Long)"})
  public void testDuplicate_givenOfferImplAdjustmentTypeIsFuture_credit_thenReturnOfferImpl2() {
    // Arrange
    OfferImpl offerImpl = new OfferImpl();
    offerImpl.setAdjustmentType(OfferAdjustmentType.FUTURE_CREDIT);
    offerImpl.setApplyDiscountToSalePrice(true);
    offerImpl.setApplyToChildItems(true);
    offerImpl.setAutomaticallyAdded(true);
    offerImpl.setCombinableWithOtherOffers(true);
    offerImpl.setDescription("The characteristics of someone or something");
    offerImpl.setDiscountType(OfferDiscountType.AMOUNT_OFF);
    offerImpl.setEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerImpl.setId(OfferImpl.serialVersionUID);
    offerImpl.setMarketingMessage("Marketing Message");
    offerImpl.setMaxUsesPerCustomer(OfferImpl.serialVersionUID);
    offerImpl.setMaxUsesPerOrder(3);
    offerImpl.setMaxUsesStrategyType(CustomerMaxUsesStrategyType.ACCOUNT);
    offerImpl.setMinimumDaysPerUsage(OfferImpl.serialVersionUID);
    offerImpl.setName("Name");
    offerImpl.setOfferCodes(new ArrayList<>());
    offerImpl.setOfferItemQualifierRuleType(OfferItemRestrictionRuleType.NONE);
    offerImpl.setOfferItemTargetRuleType(OfferItemRestrictionRuleType.NONE);
    offerImpl.setOfferMatchRulesXref(new HashMap<>());
    offerImpl.setOfferPriceData(new ArrayList<>());
    offerImpl.setOrderMinSubTotal(new Money());
    offerImpl.setPriority(1);
    offerImpl.setQualifyingItemCriteriaXref(new HashSet<>());
    offerImpl.setQualifyingItemSubTotal(new Money());
    offerImpl.setRequiresRelatedTargetAndQualifiers(true);
    offerImpl.setStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerImpl.setTargetItemCriteriaXref(new HashSet<>());
    offerImpl.setTargetMinSubTotal(new Money());
    offerImpl.setTargetSystem("Target System");
    offerImpl.setTotalitarianOffer(true);
    offerImpl.setType(OfferType.FULFILLMENT_GROUP);
    offerImpl.setUseListForDiscounts(true);
    offerImpl.setValue(new BigDecimal("2.3"));
    when(entityDuplicator.copy(Mockito.<Class<OfferImpl>>any(), Mockito.<Long>any())).thenReturn(offerImpl);

    // Act
    Offer actualDuplicateResult = offerServiceImpl.duplicate(1L);

    // Assert
    verify(entityDuplicator).copy(isA(Class.class), eq(1L));
    assertSame(offerImpl, actualDuplicateResult);
  }

  /**
   * Test {@link OfferServiceImpl#duplicate(Long)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferServiceImpl#duplicate(Long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Offer OfferServiceImpl.duplicate(Long)"})
  public void testDuplicate_thenThrowRuntimeException() {
    // Arrange
    when(entityDuplicator.copy(Mockito.<Class<OfferImpl>>any(), Mockito.<Long>any()))
        .thenThrow(new RuntimeException("foo"));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> offerServiceImpl.duplicate(1L));
    verify(entityDuplicator).copy(isA(Class.class), eq(1L));
  }

  /**
   * Test {@link OfferServiceImpl#duplicate(Long)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferServiceImpl#duplicate(Long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Offer OfferServiceImpl.duplicate(Long)"})
  public void testDuplicate_thenThrowRuntimeException2() {
    // Arrange
    when(entityDuplicator.copy(Mockito.<Class<OfferImpl>>any(), Mockito.<Long>any()))
        .thenThrow(new RuntimeException("foo"));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> offerServiceImpl.duplicate(1L));
    verify(entityDuplicator).copy(isA(Class.class), eq(1L));
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link OfferServiceImpl#setCustomerOfferDao(CustomerOfferDao)}
   *   <li>{@link OfferServiceImpl#setFulfillmentGroupOfferProcessor(FulfillmentGroupOfferProcessor)}
   *   <li>{@link OfferServiceImpl#setItemOfferProcessor(ItemOfferProcessor)}
   *   <li>{@link OfferServiceImpl#setOfferCodeDao(OfferCodeDao)}
   *   <li>{@link OfferServiceImpl#setOfferDao(OfferDao)}
   *   <li>{@link OfferServiceImpl#setOrderOfferProcessor(OrderOfferProcessor)}
   *   <li>{@link OfferServiceImpl#setOrderService(OrderService)}
   *   <li>{@link OfferServiceImpl#setPromotableItemFactory(PromotableItemFactory)}
   *   <li>{@link OfferServiceImpl#getCustomerOfferDao()}
   *   <li>{@link OfferServiceImpl#getFulfillmentGroupOfferProcessor()}
   *   <li>{@link OfferServiceImpl#getItemOfferProcessor()}
   *   <li>{@link OfferServiceImpl#getOfferCodeDao()}
   *   <li>{@link OfferServiceImpl#getOfferDao()}
   *   <li>{@link OfferServiceImpl#getOrderOfferProcessor()}
   *   <li>{@link OfferServiceImpl#getOrderService()}
   *   <li>{@link OfferServiceImpl#getPromotableItemFactory()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CustomerOfferDao OfferServiceImpl.getCustomerOfferDao()",
      "FulfillmentGroupOfferProcessor OfferServiceImpl.getFulfillmentGroupOfferProcessor()",
      "ItemOfferProcessor OfferServiceImpl.getItemOfferProcessor()", "OfferCodeDao OfferServiceImpl.getOfferCodeDao()",
      "OfferDao OfferServiceImpl.getOfferDao()", "OrderOfferProcessor OfferServiceImpl.getOrderOfferProcessor()",
      "OrderService OfferServiceImpl.getOrderService()",
      "PromotableItemFactory OfferServiceImpl.getPromotableItemFactory()",
      "void OfferServiceImpl.setCustomerOfferDao(CustomerOfferDao)",
      "void OfferServiceImpl.setFulfillmentGroupOfferProcessor(FulfillmentGroupOfferProcessor)",
      "void OfferServiceImpl.setItemOfferProcessor(ItemOfferProcessor)",
      "void OfferServiceImpl.setOfferCodeDao(OfferCodeDao)", "void OfferServiceImpl.setOfferDao(OfferDao)",
      "void OfferServiceImpl.setOrderOfferProcessor(OrderOfferProcessor)",
      "void OfferServiceImpl.setOrderService(OrderService)",
      "void OfferServiceImpl.setPromotableItemFactory(PromotableItemFactory)"})
  public void testGettersAndSetters() {
    // Arrange
    OfferServiceImpl offerServiceImpl = new OfferServiceImpl();
    CustomerOfferDaoImpl customerOfferDao = new CustomerOfferDaoImpl();

    // Act
    offerServiceImpl.setCustomerOfferDao(customerOfferDao);
    FulfillmentGroupOfferProcessorImpl fulfillmentGroupOfferProcessor = new FulfillmentGroupOfferProcessorImpl(
        new PromotableOfferUtilityImpl());
    offerServiceImpl.setFulfillmentGroupOfferProcessor(fulfillmentGroupOfferProcessor);
    ItemOfferProcessorImpl itemOfferProcessor = new ItemOfferProcessorImpl(new PromotableOfferUtilityImpl());
    offerServiceImpl.setItemOfferProcessor(itemOfferProcessor);
    OfferCodeDaoImpl offerCodeDao = new OfferCodeDaoImpl();
    offerServiceImpl.setOfferCodeDao(offerCodeDao);
    OfferDaoImpl offerDao = new OfferDaoImpl();
    offerServiceImpl.setOfferDao(offerDao);
    FulfillmentGroupOfferProcessorImpl orderOfferProcessor = new FulfillmentGroupOfferProcessorImpl(
        new PromotableOfferUtilityImpl());
    offerServiceImpl.setOrderOfferProcessor(orderOfferProcessor);
    OrderServiceImpl orderService = new OrderServiceImpl();
    offerServiceImpl.setOrderService(orderService);
    PromotableItemFactoryImpl promotableItemFactory = new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl());
    offerServiceImpl.setPromotableItemFactory(promotableItemFactory);
    CustomerOfferDao actualCustomerOfferDao = offerServiceImpl.getCustomerOfferDao();
    FulfillmentGroupOfferProcessor actualFulfillmentGroupOfferProcessor = offerServiceImpl
        .getFulfillmentGroupOfferProcessor();
    ItemOfferProcessor actualItemOfferProcessor = offerServiceImpl.getItemOfferProcessor();
    OfferCodeDao actualOfferCodeDao = offerServiceImpl.getOfferCodeDao();
    OfferDao actualOfferDao = offerServiceImpl.getOfferDao();
    OrderOfferProcessor actualOrderOfferProcessor = offerServiceImpl.getOrderOfferProcessor();
    OrderService actualOrderService = offerServiceImpl.getOrderService();
    PromotableItemFactory actualPromotableItemFactory = offerServiceImpl.getPromotableItemFactory();

    // Assert
    assertTrue(actualCustomerOfferDao instanceof CustomerOfferDaoImpl);
    assertTrue(actualOfferCodeDao instanceof OfferCodeDaoImpl);
    assertTrue(actualOfferDao instanceof OfferDaoImpl);
    assertTrue(actualPromotableItemFactory instanceof PromotableItemFactoryImpl);
    assertSame(customerOfferDao, actualCustomerOfferDao);
    assertSame(offerCodeDao, actualOfferCodeDao);
    assertSame(offerDao, actualOfferDao);
    assertSame(promotableItemFactory, actualPromotableItemFactory);
    assertSame(fulfillmentGroupOfferProcessor, actualFulfillmentGroupOfferProcessor);
    assertSame(orderOfferProcessor, actualOrderOfferProcessor);
    assertSame(itemOfferProcessor, actualItemOfferProcessor);
    assertSame(orderService, actualOrderService);
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link OfferServiceImpl#setCustomerOfferDao(CustomerOfferDao)}
   *   <li>{@link OfferServiceImpl#setFulfillmentGroupOfferProcessor(FulfillmentGroupOfferProcessor)}
   *   <li>{@link OfferServiceImpl#setItemOfferProcessor(ItemOfferProcessor)}
   *   <li>{@link OfferServiceImpl#setOfferCodeDao(OfferCodeDao)}
   *   <li>{@link OfferServiceImpl#setOfferDao(OfferDao)}
   *   <li>{@link OfferServiceImpl#setOrderOfferProcessor(OrderOfferProcessor)}
   *   <li>{@link OfferServiceImpl#setOrderService(OrderService)}
   *   <li>{@link OfferServiceImpl#setPromotableItemFactory(PromotableItemFactory)}
   *   <li>{@link OfferServiceImpl#getCustomerOfferDao()}
   *   <li>{@link OfferServiceImpl#getFulfillmentGroupOfferProcessor()}
   *   <li>{@link OfferServiceImpl#getItemOfferProcessor()}
   *   <li>{@link OfferServiceImpl#getOfferCodeDao()}
   *   <li>{@link OfferServiceImpl#getOfferDao()}
   *   <li>{@link OfferServiceImpl#getOrderOfferProcessor()}
   *   <li>{@link OfferServiceImpl#getOrderService()}
   *   <li>{@link OfferServiceImpl#getPromotableItemFactory()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CustomerOfferDao OfferServiceImpl.getCustomerOfferDao()",
      "FulfillmentGroupOfferProcessor OfferServiceImpl.getFulfillmentGroupOfferProcessor()",
      "ItemOfferProcessor OfferServiceImpl.getItemOfferProcessor()", "OfferCodeDao OfferServiceImpl.getOfferCodeDao()",
      "OfferDao OfferServiceImpl.getOfferDao()", "OrderOfferProcessor OfferServiceImpl.getOrderOfferProcessor()",
      "OrderService OfferServiceImpl.getOrderService()",
      "PromotableItemFactory OfferServiceImpl.getPromotableItemFactory()",
      "void OfferServiceImpl.setCustomerOfferDao(CustomerOfferDao)",
      "void OfferServiceImpl.setFulfillmentGroupOfferProcessor(FulfillmentGroupOfferProcessor)",
      "void OfferServiceImpl.setItemOfferProcessor(ItemOfferProcessor)",
      "void OfferServiceImpl.setOfferCodeDao(OfferCodeDao)", "void OfferServiceImpl.setOfferDao(OfferDao)",
      "void OfferServiceImpl.setOrderOfferProcessor(OrderOfferProcessor)",
      "void OfferServiceImpl.setOrderService(OrderService)",
      "void OfferServiceImpl.setPromotableItemFactory(PromotableItemFactory)"})
  public void testGettersAndSetters2() {
    // Arrange
    OfferServiceImpl offerServiceImpl = new OfferServiceImpl();
    CustomerOfferDaoImpl customerOfferDao = new CustomerOfferDaoImpl();

    // Act
    offerServiceImpl.setCustomerOfferDao(customerOfferDao);
    FulfillmentGroupOfferProcessorImpl fulfillmentGroupOfferProcessor = new FulfillmentGroupOfferProcessorImpl(
        new PromotableOfferUtilityImpl());
    offerServiceImpl.setFulfillmentGroupOfferProcessor(fulfillmentGroupOfferProcessor);
    ItemOfferProcessorImpl itemOfferProcessor = new ItemOfferProcessorImpl(new PromotableOfferUtilityImpl());
    offerServiceImpl.setItemOfferProcessor(itemOfferProcessor);
    OfferCodeDaoImpl offerCodeDao = new OfferCodeDaoImpl();
    offerServiceImpl.setOfferCodeDao(offerCodeDao);
    OfferDaoImpl offerDao = new OfferDaoImpl();
    offerServiceImpl.setOfferDao(offerDao);
    FulfillmentGroupOfferProcessorImpl orderOfferProcessor = new FulfillmentGroupOfferProcessorImpl(
        new PromotableOfferUtilityImpl());
    offerServiceImpl.setOrderOfferProcessor(orderOfferProcessor);
    OrderServiceImpl orderService = new OrderServiceImpl();
    offerServiceImpl.setOrderService(orderService);
    PromotableItemFactoryImpl promotableItemFactory = new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl());
    offerServiceImpl.setPromotableItemFactory(promotableItemFactory);
    CustomerOfferDao actualCustomerOfferDao = offerServiceImpl.getCustomerOfferDao();
    FulfillmentGroupOfferProcessor actualFulfillmentGroupOfferProcessor = offerServiceImpl
        .getFulfillmentGroupOfferProcessor();
    ItemOfferProcessor actualItemOfferProcessor = offerServiceImpl.getItemOfferProcessor();
    OfferCodeDao actualOfferCodeDao = offerServiceImpl.getOfferCodeDao();
    OfferDao actualOfferDao = offerServiceImpl.getOfferDao();
    OrderOfferProcessor actualOrderOfferProcessor = offerServiceImpl.getOrderOfferProcessor();
    OrderService actualOrderService = offerServiceImpl.getOrderService();
    PromotableItemFactory actualPromotableItemFactory = offerServiceImpl.getPromotableItemFactory();

    // Assert
    assertTrue(actualCustomerOfferDao instanceof CustomerOfferDaoImpl);
    assertTrue(actualOfferCodeDao instanceof OfferCodeDaoImpl);
    assertTrue(actualOfferDao instanceof OfferDaoImpl);
    assertTrue(actualPromotableItemFactory instanceof PromotableItemFactoryImpl);
    assertSame(customerOfferDao, actualCustomerOfferDao);
    assertSame(offerCodeDao, actualOfferCodeDao);
    assertSame(offerDao, actualOfferDao);
    assertSame(promotableItemFactory, actualPromotableItemFactory);
    assertSame(fulfillmentGroupOfferProcessor, actualFulfillmentGroupOfferProcessor);
    assertSame(orderOfferProcessor, actualOrderOfferProcessor);
    assertSame(itemOfferProcessor, actualItemOfferProcessor);
    assertSame(orderService, actualOrderService);
  }

  /**
   * Test {@link OfferServiceImpl#findOfferCodeById(Long)}.
   * <ul>
   *   <li>Then return {@link OfferCodeImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferServiceImpl#findOfferCodeById(Long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"OfferCode OfferServiceImpl.findOfferCodeById(Long)"})
  public void testFindOfferCodeById_thenReturnOfferCodeImpl() {
    // Arrange
    OfferCodeImpl offerCodeImpl = new OfferCodeImpl();
    when(offerCodeDao.readOfferCodeById(Mockito.<Long>any())).thenReturn(offerCodeImpl);

    // Act
    OfferCode actualFindOfferCodeByIdResult = offerServiceImpl.findOfferCodeById(1L);

    // Assert
    verify(offerCodeDao).readOfferCodeById(eq(1L));
    assertSame(offerCodeImpl, actualFindOfferCodeByIdResult);
  }

  /**
   * Test {@link OfferServiceImpl#findOfferCodeById(Long)}.
   * <ul>
   *   <li>Then return {@link OfferCodeImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferServiceImpl#findOfferCodeById(Long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"OfferCode OfferServiceImpl.findOfferCodeById(Long)"})
  public void testFindOfferCodeById_thenReturnOfferCodeImpl2() {
    // Arrange
    OfferCodeImpl offerCodeImpl = new OfferCodeImpl();
    when(offerCodeDao.readOfferCodeById(Mockito.<Long>any())).thenReturn(offerCodeImpl);

    // Act
    OfferCode actualFindOfferCodeByIdResult = offerServiceImpl.findOfferCodeById(1L);

    // Assert
    verify(offerCodeDao).readOfferCodeById(eq(1L));
    assertSame(offerCodeImpl, actualFindOfferCodeByIdResult);
  }

  /**
   * Test {@link OfferServiceImpl#findOfferCodeById(Long)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferServiceImpl#findOfferCodeById(Long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"OfferCode OfferServiceImpl.findOfferCodeById(Long)"})
  public void testFindOfferCodeById_thenThrowRuntimeException() {
    // Arrange
    when(offerCodeDao.readOfferCodeById(Mockito.<Long>any())).thenThrow(new RuntimeException("foo"));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> offerServiceImpl.findOfferCodeById(1L));
    verify(offerCodeDao).readOfferCodeById(eq(1L));
  }

  /**
   * Test {@link OfferServiceImpl#findOfferCodeById(Long)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferServiceImpl#findOfferCodeById(Long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"OfferCode OfferServiceImpl.findOfferCodeById(Long)"})
  public void testFindOfferCodeById_thenThrowRuntimeException2() {
    // Arrange
    when(offerCodeDao.readOfferCodeById(Mockito.<Long>any())).thenThrow(new RuntimeException("foo"));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> offerServiceImpl.findOfferCodeById(1L));
    verify(offerCodeDao).readOfferCodeById(eq(1L));
  }

  /**
   * Test {@link OfferServiceImpl#findOfferCodesByIds(Collection)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>When {@link ArrayList#ArrayList()} add one.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferServiceImpl#findOfferCodesByIds(Collection)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List OfferServiceImpl.findOfferCodesByIds(Collection)"})
  public void testFindOfferCodesByIds_givenOne_whenArrayListAddOne_thenReturnEmpty() {
    // Arrange
    when(offerCodeDao.readOfferCodesByIds(Mockito.<Collection<Long>>any())).thenReturn(new ArrayList<>());

    ArrayList<Long> ids = new ArrayList<>();
    ids.add(1L);

    // Act
    List<OfferCode> actualFindOfferCodesByIdsResult = offerServiceImpl.findOfferCodesByIds(ids);

    // Assert
    verify(offerCodeDao).readOfferCodesByIds(isA(Collection.class));
    assertTrue(actualFindOfferCodesByIdsResult.isEmpty());
  }

  /**
   * Test {@link OfferServiceImpl#findOfferCodesByIds(Collection)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>When {@link ArrayList#ArrayList()} add one.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferServiceImpl#findOfferCodesByIds(Collection)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List OfferServiceImpl.findOfferCodesByIds(Collection)"})
  public void testFindOfferCodesByIds_givenOne_whenArrayListAddOne_thenReturnEmpty2() {
    // Arrange
    when(offerCodeDao.readOfferCodesByIds(Mockito.<Collection<Long>>any())).thenReturn(new ArrayList<>());

    ArrayList<Long> ids = new ArrayList<>();
    ids.add(1L);

    // Act
    List<OfferCode> actualFindOfferCodesByIdsResult = offerServiceImpl.findOfferCodesByIds(ids);

    // Assert
    verify(offerCodeDao).readOfferCodesByIds(isA(Collection.class));
    assertTrue(actualFindOfferCodesByIdsResult.isEmpty());
  }

  /**
   * Test {@link OfferServiceImpl#findOfferCodesByIds(Collection)}.
   * <ul>
   *   <li>Given zero.</li>
   *   <li>When {@link ArrayList#ArrayList()} add zero.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferServiceImpl#findOfferCodesByIds(Collection)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List OfferServiceImpl.findOfferCodesByIds(Collection)"})
  public void testFindOfferCodesByIds_givenZero_whenArrayListAddZero_thenReturnEmpty() {
    // Arrange
    when(offerCodeDao.readOfferCodesByIds(Mockito.<Collection<Long>>any())).thenReturn(new ArrayList<>());

    ArrayList<Long> ids = new ArrayList<>();
    ids.add(0L);
    ids.add(1L);

    // Act
    List<OfferCode> actualFindOfferCodesByIdsResult = offerServiceImpl.findOfferCodesByIds(ids);

    // Assert
    verify(offerCodeDao).readOfferCodesByIds(isA(Collection.class));
    assertTrue(actualFindOfferCodesByIdsResult.isEmpty());
  }

  /**
   * Test {@link OfferServiceImpl#findOfferCodesByIds(Collection)}.
   * <ul>
   *   <li>Given zero.</li>
   *   <li>When {@link ArrayList#ArrayList()} add zero.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferServiceImpl#findOfferCodesByIds(Collection)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List OfferServiceImpl.findOfferCodesByIds(Collection)"})
  public void testFindOfferCodesByIds_givenZero_whenArrayListAddZero_thenReturnEmpty2() {
    // Arrange
    when(offerCodeDao.readOfferCodesByIds(Mockito.<Collection<Long>>any())).thenReturn(new ArrayList<>());

    ArrayList<Long> ids = new ArrayList<>();
    ids.add(0L);
    ids.add(1L);

    // Act
    List<OfferCode> actualFindOfferCodesByIdsResult = offerServiceImpl.findOfferCodesByIds(ids);

    // Assert
    verify(offerCodeDao).readOfferCodesByIds(isA(Collection.class));
    assertTrue(actualFindOfferCodesByIdsResult.isEmpty());
  }

  /**
   * Test {@link OfferServiceImpl#findOfferCodesByIds(Collection)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferServiceImpl#findOfferCodesByIds(Collection)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List OfferServiceImpl.findOfferCodesByIds(Collection)"})
  public void testFindOfferCodesByIds_thenThrowRuntimeException() {
    // Arrange
    when(offerCodeDao.readOfferCodesByIds(Mockito.<Collection<Long>>any())).thenThrow(new RuntimeException("foo"));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> offerServiceImpl.findOfferCodesByIds(new ArrayList<>()));
    verify(offerCodeDao).readOfferCodesByIds(isA(Collection.class));
  }

  /**
   * Test {@link OfferServiceImpl#findOfferCodesByIds(Collection)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferServiceImpl#findOfferCodesByIds(Collection)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List OfferServiceImpl.findOfferCodesByIds(Collection)"})
  public void testFindOfferCodesByIds_thenThrowRuntimeException2() {
    // Arrange
    when(offerCodeDao.readOfferCodesByIds(Mockito.<Collection<Long>>any())).thenThrow(new RuntimeException("foo"));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> offerServiceImpl.findOfferCodesByIds(new ArrayList<>()));
    verify(offerCodeDao).readOfferCodesByIds(isA(Collection.class));
  }

  /**
   * Test {@link OfferServiceImpl#findOfferCodesByIds(Collection)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferServiceImpl#findOfferCodesByIds(Collection)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List OfferServiceImpl.findOfferCodesByIds(Collection)"})
  public void testFindOfferCodesByIds_whenArrayList_thenReturnEmpty() {
    // Arrange
    when(offerCodeDao.readOfferCodesByIds(Mockito.<Collection<Long>>any())).thenReturn(new ArrayList<>());

    // Act
    List<OfferCode> actualFindOfferCodesByIdsResult = offerServiceImpl.findOfferCodesByIds(new ArrayList<>());

    // Assert
    verify(offerCodeDao).readOfferCodesByIds(isA(Collection.class));
    assertTrue(actualFindOfferCodesByIdsResult.isEmpty());
  }

  /**
   * Test {@link OfferServiceImpl#findOfferCodesByIds(Collection)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferServiceImpl#findOfferCodesByIds(Collection)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List OfferServiceImpl.findOfferCodesByIds(Collection)"})
  public void testFindOfferCodesByIds_whenArrayList_thenReturnEmpty2() {
    // Arrange
    when(offerCodeDao.readOfferCodesByIds(Mockito.<Collection<Long>>any())).thenReturn(new ArrayList<>());

    // Act
    List<OfferCode> actualFindOfferCodesByIdsResult = offerServiceImpl.findOfferCodesByIds(new ArrayList<>());

    // Assert
    verify(offerCodeDao).readOfferCodesByIds(isA(Collection.class));
    assertTrue(actualFindOfferCodesByIdsResult.isEmpty());
  }

  /**
   * Test {@link OfferServiceImpl#findOfferById(Long)}.
   * <ul>
   *   <li>Given {@link OfferDao} {@link OfferDao#readOfferById(Long)} return {@link OfferImpl} (default constructor).</li>
   *   <li>Then return {@link OfferImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferServiceImpl#findOfferById(Long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Offer OfferServiceImpl.findOfferById(Long)"})
  public void testFindOfferById_givenOfferDaoReadOfferByIdReturnOfferImpl_thenReturnOfferImpl() {
    // Arrange
    OfferImpl offerImpl = new OfferImpl();
    when(offerDao.readOfferById(Mockito.<Long>any())).thenReturn(offerImpl);

    // Act
    Offer actualFindOfferByIdResult = offerServiceImpl.findOfferById(1L);

    // Assert
    verify(offerDao).readOfferById(eq(1L));
    assertSame(offerImpl, actualFindOfferByIdResult);
  }

  /**
   * Test {@link OfferServiceImpl#findOfferById(Long)}.
   * <ul>
   *   <li>Given {@link OfferDao} {@link OfferDao#readOfferById(Long)} return {@link OfferImpl} (default constructor).</li>
   *   <li>Then return {@link OfferImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferServiceImpl#findOfferById(Long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Offer OfferServiceImpl.findOfferById(Long)"})
  public void testFindOfferById_givenOfferDaoReadOfferByIdReturnOfferImpl_thenReturnOfferImpl2() {
    // Arrange
    OfferImpl offerImpl = new OfferImpl();
    when(offerDao.readOfferById(Mockito.<Long>any())).thenReturn(offerImpl);

    // Act
    Offer actualFindOfferByIdResult = offerServiceImpl.findOfferById(1L);

    // Assert
    verify(offerDao).readOfferById(eq(1L));
    assertSame(offerImpl, actualFindOfferByIdResult);
  }

  /**
   * Test {@link OfferServiceImpl#findOfferById(Long)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferServiceImpl#findOfferById(Long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Offer OfferServiceImpl.findOfferById(Long)"})
  public void testFindOfferById_thenThrowRuntimeException() {
    // Arrange
    when(offerDao.readOfferById(Mockito.<Long>any())).thenThrow(new RuntimeException("foo"));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> offerServiceImpl.findOfferById(1L));
    verify(offerDao).readOfferById(eq(1L));
  }

  /**
   * Test {@link OfferServiceImpl#findOfferById(Long)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferServiceImpl#findOfferById(Long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Offer OfferServiceImpl.findOfferById(Long)"})
  public void testFindOfferById_thenThrowRuntimeException2() {
    // Arrange
    when(offerDao.readOfferById(Mockito.<Long>any())).thenThrow(new RuntimeException("foo"));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> offerServiceImpl.findOfferById(1L));
    verify(offerDao).readOfferById(eq(1L));
  }
}
