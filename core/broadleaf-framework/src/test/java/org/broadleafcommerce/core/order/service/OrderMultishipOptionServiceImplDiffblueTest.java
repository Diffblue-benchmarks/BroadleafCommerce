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
package org.broadleafcommerce.core.order.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import org.broadleafcommerce.common.audit.Auditable;
import org.broadleafcommerce.common.currency.domain.BroadleafCurrencyImpl;
import org.broadleafcommerce.common.locale.domain.LocaleImpl;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.core.catalog.domain.SkuImpl;
import org.broadleafcommerce.core.order.dao.OrderMultishipOptionDao;
import org.broadleafcommerce.core.order.domain.BundleOrderItemImpl;
import org.broadleafcommerce.core.order.domain.DiscreteOrderItem;
import org.broadleafcommerce.core.order.domain.FulfillmentOption;
import org.broadleafcommerce.core.order.domain.FulfillmentOptionImpl;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.Order;
import org.broadleafcommerce.core.order.domain.OrderImpl;
import org.broadleafcommerce.core.order.domain.OrderItem;
import org.broadleafcommerce.core.order.domain.OrderMultishipOption;
import org.broadleafcommerce.core.order.domain.OrderMultishipOptionImpl;
import org.broadleafcommerce.core.order.service.call.OrderMultishipOptionDTO;
import org.broadleafcommerce.core.order.service.type.FulfillmentType;
import org.broadleafcommerce.core.order.service.type.OrderStatus;
import org.broadleafcommerce.profile.core.domain.Address;
import org.broadleafcommerce.profile.core.domain.AddressImpl;
import org.broadleafcommerce.profile.core.domain.CustomerImpl;
import org.broadleafcommerce.profile.core.service.AddressService;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class OrderMultishipOptionServiceImplDiffblueTest {
  @Mock
  private AddressService addressService;

  @Mock
  private FulfillmentGroupService fulfillmentGroupService;

  @Mock
  private FulfillmentOptionService fulfillmentOptionService;

  @Mock
  private OrderItemService orderItemService;

  @Mock
  private OrderMultishipOptionDao orderMultishipOptionDao;

  @InjectMocks
  private OrderMultishipOptionServiceImpl orderMultishipOptionServiceImpl;

  /**
   * Test {@link OrderMultishipOptionServiceImpl#save(OrderMultishipOption)}.
   * <p>
   * Method under test: {@link OrderMultishipOptionServiceImpl#save(OrderMultishipOption)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"OrderMultishipOption OrderMultishipOptionServiceImpl.save(OrderMultishipOption)"})
  public void testSave() {
    // Arrange
    OrderMultishipOptionImpl orderMultishipOptionImpl = new OrderMultishipOptionImpl();
    when(orderMultishipOptionDao.save(Mockito.<OrderMultishipOption>any())).thenReturn(orderMultishipOptionImpl);

    // Act
    OrderMultishipOption actualSaveResult = orderMultishipOptionServiceImpl.save(new OrderMultishipOptionImpl());

    // Assert
    verify(orderMultishipOptionDao).save(isA(OrderMultishipOption.class));
    assertSame(orderMultishipOptionImpl, actualSaveResult);
  }

  /**
   * Test {@link OrderMultishipOptionServiceImpl#findOrderMultishipOptions(Long)}.
   * <p>
   * Method under test: {@link OrderMultishipOptionServiceImpl#findOrderMultishipOptions(Long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List OrderMultishipOptionServiceImpl.findOrderMultishipOptions(Long)"})
  public void testFindOrderMultishipOptions() {
    // Arrange
    when(orderMultishipOptionDao.readOrderMultishipOptions(Mockito.<Long>any())).thenReturn(new ArrayList<>());

    // Act
    List<OrderMultishipOption> actualFindOrderMultishipOptionsResult = orderMultishipOptionServiceImpl
        .findOrderMultishipOptions(1L);

    // Assert
    verify(orderMultishipOptionDao).readOrderMultishipOptions(eq(1L));
    assertTrue(actualFindOrderMultishipOptionsResult.isEmpty());
  }

  /**
   * Test {@link OrderMultishipOptionServiceImpl#findOrderItemOrderMultishipOptions(Long)}.
   * <p>
   * Method under test: {@link OrderMultishipOptionServiceImpl#findOrderItemOrderMultishipOptions(Long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List OrderMultishipOptionServiceImpl.findOrderItemOrderMultishipOptions(Long)"})
  public void testFindOrderItemOrderMultishipOptions() {
    // Arrange
    when(orderMultishipOptionDao.readOrderItemOrderMultishipOptions(Mockito.<Long>any())).thenReturn(new ArrayList<>());

    // Act
    List<OrderMultishipOption> actualFindOrderItemOrderMultishipOptionsResult = orderMultishipOptionServiceImpl
        .findOrderItemOrderMultishipOptions(1L);

    // Assert
    verify(orderMultishipOptionDao).readOrderItemOrderMultishipOptions(eq(1L));
    assertTrue(actualFindOrderItemOrderMultishipOptionsResult.isEmpty());
  }

  /**
   * Test {@link OrderMultishipOptionServiceImpl#create()}.
   * <p>
   * Method under test: {@link OrderMultishipOptionServiceImpl#create()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"OrderMultishipOption OrderMultishipOptionServiceImpl.create()"})
  public void testCreate() {
    // Arrange
    OrderMultishipOptionImpl orderMultishipOptionImpl = new OrderMultishipOptionImpl();
    when(orderMultishipOptionDao.create()).thenReturn(orderMultishipOptionImpl);

    // Act
    OrderMultishipOption actualCreateResult = orderMultishipOptionServiceImpl.create();

    // Assert
    verify(orderMultishipOptionDao).create();
    assertSame(orderMultishipOptionImpl, actualCreateResult);
  }

  /**
   * Test {@link OrderMultishipOptionServiceImpl#deleteOrderItemOrderMultishipOptions(Long)} with {@code orderItemId}.
   * <p>
   * Method under test: {@link OrderMultishipOptionServiceImpl#deleteOrderItemOrderMultishipOptions(Long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OrderMultishipOptionServiceImpl.deleteOrderItemOrderMultishipOptions(Long)"})
  public void testDeleteOrderItemOrderMultishipOptionsWithOrderItemId() {
    // Arrange
    when(orderMultishipOptionDao.readOrderItemOrderMultishipOptions(Mockito.<Long>any())).thenReturn(new ArrayList<>());
    doNothing().when(orderMultishipOptionDao).deleteAll(Mockito.<List<OrderMultishipOption>>any());

    // Act
    orderMultishipOptionServiceImpl.deleteOrderItemOrderMultishipOptions(1L);

    // Assert
    verify(orderMultishipOptionDao).deleteAll(isA(List.class));
    verify(orderMultishipOptionDao).readOrderItemOrderMultishipOptions(eq(1L));
  }

  /**
   * Test {@link OrderMultishipOptionServiceImpl#deleteOrderItemOrderMultishipOptions(Long, int)} with {@code orderItemId}, {@code numToDelete}.
   * <ul>
   *   <li>When ten.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderMultishipOptionServiceImpl#deleteOrderItemOrderMultishipOptions(Long, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OrderMultishipOptionServiceImpl.deleteOrderItemOrderMultishipOptions(Long, int)"})
  public void testDeleteOrderItemOrderMultishipOptionsWithOrderItemIdNumToDelete_whenTen() {
    // Arrange
    when(orderMultishipOptionDao.readOrderItemOrderMultishipOptions(Mockito.<Long>any())).thenReturn(new ArrayList<>());
    doNothing().when(orderMultishipOptionDao).deleteAll(Mockito.<List<OrderMultishipOption>>any());

    // Act
    orderMultishipOptionServiceImpl.deleteOrderItemOrderMultishipOptions(1L, 10);

    // Assert
    verify(orderMultishipOptionDao).deleteAll(isA(List.class));
    verify(orderMultishipOptionDao).readOrderItemOrderMultishipOptions(eq(1L));
  }

  /**
   * Test {@link OrderMultishipOptionServiceImpl#deleteOrderItemOrderMultishipOptions(Long, int)} with {@code orderItemId}, {@code numToDelete}.
   * <ul>
   *   <li>When zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderMultishipOptionServiceImpl#deleteOrderItemOrderMultishipOptions(Long, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OrderMultishipOptionServiceImpl.deleteOrderItemOrderMultishipOptions(Long, int)"})
  public void testDeleteOrderItemOrderMultishipOptionsWithOrderItemIdNumToDelete_whenZero() {
    // Arrange
    when(orderMultishipOptionDao.readOrderItemOrderMultishipOptions(Mockito.<Long>any())).thenReturn(new ArrayList<>());
    doNothing().when(orderMultishipOptionDao).deleteAll(Mockito.<List<OrderMultishipOption>>any());

    // Act
    orderMultishipOptionServiceImpl.deleteOrderItemOrderMultishipOptions(1L, 0);

    // Assert
    verify(orderMultishipOptionDao).deleteAll(isA(List.class));
    verify(orderMultishipOptionDao).readOrderItemOrderMultishipOptions(eq(1L));
  }

  /**
   * Test {@link OrderMultishipOptionServiceImpl#deleteAllOrderMultishipOptions(Order)}.
   * <ul>
   *   <li>When {@link NullOrderImpl} (default constructor).</li>
   *   <li>Then calls {@link OrderMultishipOptionDao#deleteAll(List)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderMultishipOptionServiceImpl#deleteAllOrderMultishipOptions(Order)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OrderMultishipOptionServiceImpl.deleteAllOrderMultishipOptions(Order)"})
  public void testDeleteAllOrderMultishipOptions_whenNullOrderImpl_thenCallsDeleteAll() {
    // Arrange
    when(orderMultishipOptionDao.readOrderMultishipOptions(Mockito.<Long>any())).thenReturn(new ArrayList<>());
    doNothing().when(orderMultishipOptionDao).deleteAll(Mockito.<List<OrderMultishipOption>>any());

    // Act
    orderMultishipOptionServiceImpl.deleteAllOrderMultishipOptions(new NullOrderImpl());

    // Assert
    verify(orderMultishipOptionDao).deleteAll(isA(List.class));
    verify(orderMultishipOptionDao).readOrderMultishipOptions(isNull());
  }

  /**
   * Test {@link OrderMultishipOptionServiceImpl#saveOrderMultishipOptions(Order, List)}.
   * <p>
   * Method under test: {@link OrderMultishipOptionServiceImpl#saveOrderMultishipOptions(Order, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OrderMultishipOptionServiceImpl.saveOrderMultishipOptions(Order, List)"})
  public void testSaveOrderMultishipOptions() {
    // Arrange
    when(addressService.readAddressById(Mockito.<Long>any())).thenReturn(new AddressImpl());
    when(orderItemService.readOrderItemById(Mockito.<Long>any())).thenReturn(new BundleOrderItemImpl());
    when(orderMultishipOptionDao.save(Mockito.<OrderMultishipOption>any())).thenReturn(new OrderMultishipOptionImpl());
    when(orderMultishipOptionDao.create()).thenReturn(new OrderMultishipOptionImpl());
    when(orderMultishipOptionDao.readOrderMultishipOptions(Mockito.<Long>any())).thenReturn(new ArrayList<>());
    NullOrderImpl order = new NullOrderImpl();

    OrderMultishipOptionDTO orderMultishipOptionDTO = new OrderMultishipOptionDTO();
    orderMultishipOptionDTO.setAddressId(1L);
    orderMultishipOptionDTO.setFulfillmentOptionId(null);
    orderMultishipOptionDTO.setId(1L);
    orderMultishipOptionDTO.setOrderItemId(1L);

    ArrayList<OrderMultishipOptionDTO> optionDTOs = new ArrayList<>();
    optionDTOs.add(orderMultishipOptionDTO);

    // Act
    orderMultishipOptionServiceImpl.saveOrderMultishipOptions(order, optionDTOs);

    // Assert
    verify(orderMultishipOptionDao).create();
    verify(orderMultishipOptionDao).readOrderMultishipOptions(isNull());
    verify(orderMultishipOptionDao).save(isA(OrderMultishipOption.class));
    verify(orderItemService).readOrderItemById(eq(1L));
    verify(addressService).readAddressById(eq(1L));
  }

  /**
   * Test {@link OrderMultishipOptionServiceImpl#saveOrderMultishipOptions(Order, List)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link OrderMultishipOptionImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderMultishipOptionServiceImpl#saveOrderMultishipOptions(Order, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OrderMultishipOptionServiceImpl.saveOrderMultishipOptions(Order, List)"})
  public void testSaveOrderMultishipOptions_givenArrayListAddOrderMultishipOptionImpl() {
    // Arrange
    ArrayList<OrderMultishipOption> orderMultishipOptionList = new ArrayList<>();
    orderMultishipOptionList.add(new OrderMultishipOptionImpl());
    when(orderMultishipOptionDao.readOrderMultishipOptions(Mockito.<Long>any())).thenReturn(orderMultishipOptionList);
    NullOrderImpl order = new NullOrderImpl();

    // Act
    orderMultishipOptionServiceImpl.saveOrderMultishipOptions(order, new ArrayList<>());

    // Assert
    verify(orderMultishipOptionDao).readOrderMultishipOptions(isNull());
  }

  /**
   * Test {@link OrderMultishipOptionServiceImpl#saveOrderMultishipOptions(Order, List)}.
   * <ul>
   *   <li>Given {@link OrderItemService}.</li>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderMultishipOptionServiceImpl#saveOrderMultishipOptions(Order, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OrderMultishipOptionServiceImpl.saveOrderMultishipOptions(Order, List)"})
  public void testSaveOrderMultishipOptions_givenOrderItemService_whenArrayList() {
    // Arrange
    when(orderMultishipOptionDao.readOrderMultishipOptions(Mockito.<Long>any())).thenReturn(new ArrayList<>());
    NullOrderImpl order = new NullOrderImpl();

    // Act
    orderMultishipOptionServiceImpl.saveOrderMultishipOptions(order, new ArrayList<>());

    // Assert
    verify(orderMultishipOptionDao).readOrderMultishipOptions(isNull());
  }

  /**
   * Test {@link OrderMultishipOptionServiceImpl#saveOrderMultishipOptions(Order, List)}.
   * <ul>
   *   <li>Given {@link OrderMultishipOptionDTO} (default constructor) AddressId is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderMultishipOptionServiceImpl#saveOrderMultishipOptions(Order, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OrderMultishipOptionServiceImpl.saveOrderMultishipOptions(Order, List)"})
  public void testSaveOrderMultishipOptions_givenOrderMultishipOptionDTOAddressIdIsNull() {
    // Arrange
    when(fulfillmentOptionService.readFulfillmentOptionById(Mockito.<Long>any()))
        .thenReturn(new FulfillmentOptionImpl());
    when(orderItemService.readOrderItemById(Mockito.<Long>any())).thenReturn(new BundleOrderItemImpl());
    when(orderMultishipOptionDao.save(Mockito.<OrderMultishipOption>any())).thenReturn(new OrderMultishipOptionImpl());
    when(orderMultishipOptionDao.create()).thenReturn(new OrderMultishipOptionImpl());
    when(orderMultishipOptionDao.readOrderMultishipOptions(Mockito.<Long>any())).thenReturn(new ArrayList<>());
    NullOrderImpl order = new NullOrderImpl();

    OrderMultishipOptionDTO orderMultishipOptionDTO = new OrderMultishipOptionDTO();
    orderMultishipOptionDTO.setAddressId(null);
    orderMultishipOptionDTO.setFulfillmentOptionId(1L);
    orderMultishipOptionDTO.setId(1L);
    orderMultishipOptionDTO.setOrderItemId(1L);

    ArrayList<OrderMultishipOptionDTO> optionDTOs = new ArrayList<>();
    optionDTOs.add(orderMultishipOptionDTO);

    // Act
    orderMultishipOptionServiceImpl.saveOrderMultishipOptions(order, optionDTOs);

    // Assert
    verify(orderMultishipOptionDao).create();
    verify(orderMultishipOptionDao).readOrderMultishipOptions(isNull());
    verify(orderMultishipOptionDao).save(isA(OrderMultishipOption.class));
    verify(fulfillmentOptionService).readFulfillmentOptionById(eq(1L));
    verify(orderItemService).readOrderItemById(eq(1L));
  }

  /**
   * Test {@link OrderMultishipOptionServiceImpl#saveOrderMultishipOptions(Order, List)}.
   * <ul>
   *   <li>Given {@link OrderMultishipOptionDTO} (default constructor) AddressId is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderMultishipOptionServiceImpl#saveOrderMultishipOptions(Order, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OrderMultishipOptionServiceImpl.saveOrderMultishipOptions(Order, List)"})
  public void testSaveOrderMultishipOptions_givenOrderMultishipOptionDTOAddressIdIsTwo() {
    // Arrange
    when(addressService.readAddressById(Mockito.<Long>any())).thenReturn(new AddressImpl());
    when(fulfillmentOptionService.readFulfillmentOptionById(Mockito.<Long>any()))
        .thenReturn(new FulfillmentOptionImpl());
    when(orderItemService.readOrderItemById(Mockito.<Long>any())).thenReturn(new BundleOrderItemImpl());
    when(orderMultishipOptionDao.save(Mockito.<OrderMultishipOption>any())).thenReturn(new OrderMultishipOptionImpl());
    when(orderMultishipOptionDao.create()).thenReturn(new OrderMultishipOptionImpl());
    when(orderMultishipOptionDao.readOrderMultishipOptions(Mockito.<Long>any())).thenReturn(new ArrayList<>());
    NullOrderImpl order = new NullOrderImpl();

    OrderMultishipOptionDTO orderMultishipOptionDTO = new OrderMultishipOptionDTO();
    orderMultishipOptionDTO.setAddressId(1L);
    orderMultishipOptionDTO.setFulfillmentOptionId(1L);
    orderMultishipOptionDTO.setId(1L);
    orderMultishipOptionDTO.setOrderItemId(1L);

    OrderMultishipOptionDTO orderMultishipOptionDTO2 = new OrderMultishipOptionDTO();
    orderMultishipOptionDTO2.setAddressId(2L);
    orderMultishipOptionDTO2.setFulfillmentOptionId(2L);
    orderMultishipOptionDTO2.setId(2L);
    orderMultishipOptionDTO2.setOrderItemId(2L);

    ArrayList<OrderMultishipOptionDTO> optionDTOs = new ArrayList<>();
    optionDTOs.add(orderMultishipOptionDTO2);
    optionDTOs.add(orderMultishipOptionDTO);

    // Act
    orderMultishipOptionServiceImpl.saveOrderMultishipOptions(order, optionDTOs);

    // Assert
    verify(orderMultishipOptionDao, atLeast(1)).create();
    verify(orderMultishipOptionDao).readOrderMultishipOptions(isNull());
    verify(orderMultishipOptionDao, atLeast(1)).save(isA(OrderMultishipOption.class));
    verify(fulfillmentOptionService, atLeast(1)).readFulfillmentOptionById(Mockito.<Long>any());
    verify(orderItemService, atLeast(1)).readOrderItemById(Mockito.<Long>any());
    verify(addressService, atLeast(1)).readAddressById(Mockito.<Long>any());
  }

  /**
   * Test {@link OrderMultishipOptionServiceImpl#saveOrderMultishipOptions(Order, List)}.
   * <ul>
   *   <li>Then calls {@link FulfillmentOptionService#readFulfillmentOptionById(Long)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderMultishipOptionServiceImpl#saveOrderMultishipOptions(Order, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OrderMultishipOptionServiceImpl.saveOrderMultishipOptions(Order, List)"})
  public void testSaveOrderMultishipOptions_thenCallsReadFulfillmentOptionById() {
    // Arrange
    when(addressService.readAddressById(Mockito.<Long>any())).thenReturn(new AddressImpl());
    when(fulfillmentOptionService.readFulfillmentOptionById(Mockito.<Long>any()))
        .thenReturn(new FulfillmentOptionImpl());
    when(orderItemService.readOrderItemById(Mockito.<Long>any())).thenReturn(new BundleOrderItemImpl());
    when(orderMultishipOptionDao.save(Mockito.<OrderMultishipOption>any())).thenReturn(new OrderMultishipOptionImpl());
    when(orderMultishipOptionDao.create()).thenReturn(new OrderMultishipOptionImpl());
    when(orderMultishipOptionDao.readOrderMultishipOptions(Mockito.<Long>any())).thenReturn(new ArrayList<>());
    NullOrderImpl order = new NullOrderImpl();

    OrderMultishipOptionDTO orderMultishipOptionDTO = new OrderMultishipOptionDTO();
    orderMultishipOptionDTO.setAddressId(1L);
    orderMultishipOptionDTO.setFulfillmentOptionId(1L);
    orderMultishipOptionDTO.setId(1L);
    orderMultishipOptionDTO.setOrderItemId(1L);

    ArrayList<OrderMultishipOptionDTO> optionDTOs = new ArrayList<>();
    optionDTOs.add(orderMultishipOptionDTO);

    // Act
    orderMultishipOptionServiceImpl.saveOrderMultishipOptions(order, optionDTOs);

    // Assert
    verify(orderMultishipOptionDao).create();
    verify(orderMultishipOptionDao).readOrderMultishipOptions(isNull());
    verify(orderMultishipOptionDao).save(isA(OrderMultishipOption.class));
    verify(fulfillmentOptionService).readFulfillmentOptionById(eq(1L));
    verify(orderItemService).readOrderItemById(eq(1L));
    verify(addressService).readAddressById(eq(1L));
  }

  /**
   * Test {@link OrderMultishipOptionServiceImpl#getOrGenerateOrderMultishipOptions(Order)}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderMultishipOptionServiceImpl#getOrGenerateOrderMultishipOptions(Order)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List OrderMultishipOptionServiceImpl.getOrGenerateOrderMultishipOptions(Order)"})
  public void testGetOrGenerateOrderMultishipOptions_thenReturnEmpty() {
    // Arrange
    doNothing().when(orderMultishipOptionDao).deleteAll(Mockito.<List<OrderMultishipOption>>any());
    when(orderMultishipOptionDao.readOrderMultishipOptions(Mockito.<Long>any())).thenReturn(new ArrayList<>());

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
    order.setTotalTax(new Money());

    // Act
    List<OrderMultishipOption> actualOrGenerateOrderMultishipOptions = orderMultishipOptionServiceImpl
        .getOrGenerateOrderMultishipOptions(order);

    // Assert
    verify(orderMultishipOptionDao).deleteAll(isA(List.class));
    verify(orderMultishipOptionDao).readOrderMultishipOptions(eq(1L));
    assertTrue(actualOrGenerateOrderMultishipOptions.isEmpty());
  }

  /**
   * Test {@link OrderMultishipOptionServiceImpl#getOrderMultishipOptionsFromDTOs(Order, List)}.
   * <p>
   * Method under test: {@link OrderMultishipOptionServiceImpl#getOrderMultishipOptionsFromDTOs(Order, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List OrderMultishipOptionServiceImpl.getOrderMultishipOptionsFromDTOs(Order, List)"})
  public void testGetOrderMultishipOptionsFromDTOs() {
    // Arrange
    AddressImpl addressImpl = new AddressImpl();
    when(addressService.readAddressById(Mockito.<Long>any())).thenReturn(addressImpl);
    FulfillmentOptionImpl fulfillmentOptionImpl = new FulfillmentOptionImpl();
    when(fulfillmentOptionService.readFulfillmentOptionById(Mockito.<Long>any())).thenReturn(fulfillmentOptionImpl);
    when(orderItemService.readOrderItemById(Mockito.<Long>any())).thenReturn(new BundleOrderItemImpl());
    NullOrderImpl order = new NullOrderImpl();
    OrderMultishipOptionDTO orderMultishipOptionDTO = mock(OrderMultishipOptionDTO.class);
    when(orderMultishipOptionDTO.getAddressId()).thenReturn(1L);
    when(orderMultishipOptionDTO.getFulfillmentOptionId()).thenReturn(1L);
    when(orderMultishipOptionDTO.getId()).thenReturn(1L);
    when(orderMultishipOptionDTO.getOrderItemId()).thenReturn(1L);
    doNothing().when(orderMultishipOptionDTO).setAddressId(Mockito.<Long>any());
    doNothing().when(orderMultishipOptionDTO).setFulfillmentOptionId(Mockito.<Long>any());
    doNothing().when(orderMultishipOptionDTO).setId(Mockito.<Long>any());
    doNothing().when(orderMultishipOptionDTO).setOrderItemId(Mockito.<Long>any());
    orderMultishipOptionDTO.setId(1L);
    orderMultishipOptionDTO.setOrderItemId(1L);
    orderMultishipOptionDTO.setAddressId(null);
    orderMultishipOptionDTO.setFulfillmentOptionId(null);

    ArrayList<OrderMultishipOptionDTO> optionDtos = new ArrayList<>();
    optionDtos.add(orderMultishipOptionDTO);

    // Act
    List<OrderMultishipOption> actualOrderMultishipOptionsFromDTOs = orderMultishipOptionServiceImpl
        .getOrderMultishipOptionsFromDTOs(order, optionDtos);

    // Assert
    verify(fulfillmentOptionService).readFulfillmentOptionById(eq(1L));
    verify(orderItemService).readOrderItemById(eq(1L));
    verify(orderMultishipOptionDTO, atLeast(1)).getAddressId();
    verify(orderMultishipOptionDTO, atLeast(1)).getFulfillmentOptionId();
    verify(orderMultishipOptionDTO).getId();
    verify(orderMultishipOptionDTO).getOrderItemId();
    verify(orderMultishipOptionDTO).setAddressId(isNull());
    verify(orderMultishipOptionDTO).setFulfillmentOptionId(isNull());
    verify(orderMultishipOptionDTO).setId(eq(1L));
    verify(orderMultishipOptionDTO).setOrderItemId(eq(1L));
    verify(addressService).readAddressById(eq(1L));
    assertEquals(1, actualOrderMultishipOptionsFromDTOs.size());
    OrderMultishipOption getResult = actualOrderMultishipOptionsFromDTOs.get(0);
    FulfillmentOption fulfillmentOption = getResult.getFulfillmentOption();
    assertTrue(fulfillmentOption instanceof FulfillmentOptionImpl);
    assertTrue(getResult instanceof OrderMultishipOptionImpl);
    Address address = getResult.getAddress();
    assertTrue(address instanceof AddressImpl);
    assertSame(fulfillmentOptionImpl, fulfillmentOption);
    assertSame(addressImpl, address);
  }

  /**
   * Test {@link OrderMultishipOptionServiceImpl#getOrderMultishipOptionsFromDTOs(Order, List)}.
   * <ul>
   *   <li>Given {@link OrderItemService}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderMultishipOptionServiceImpl#getOrderMultishipOptionsFromDTOs(Order, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List OrderMultishipOptionServiceImpl.getOrderMultishipOptionsFromDTOs(Order, List)"})
  public void testGetOrderMultishipOptionsFromDTOs_givenOrderItemService_thenReturnEmpty() {
    // Arrange
    NullOrderImpl order = new NullOrderImpl();

    // Act and Assert
    assertTrue(orderMultishipOptionServiceImpl.getOrderMultishipOptionsFromDTOs(order, new ArrayList<>()).isEmpty());
  }

  /**
   * Test {@link OrderMultishipOptionServiceImpl#getOrderMultishipOptionsFromDTOs(Order, List)}.
   * <ul>
   *   <li>Then first OrderItem return {@link BundleOrderItemImpl}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderMultishipOptionServiceImpl#getOrderMultishipOptionsFromDTOs(Order, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List OrderMultishipOptionServiceImpl.getOrderMultishipOptionsFromDTOs(Order, List)"})
  public void testGetOrderMultishipOptionsFromDTOs_thenFirstOrderItemReturnBundleOrderItemImpl() {
    // Arrange
    BundleOrderItemImpl bundleOrderItemImpl = new BundleOrderItemImpl();
    when(orderItemService.readOrderItemById(Mockito.<Long>any())).thenReturn(bundleOrderItemImpl);
    NullOrderImpl order = new NullOrderImpl();

    OrderMultishipOptionDTO orderMultishipOptionDTO = new OrderMultishipOptionDTO();
    orderMultishipOptionDTO.setId(1L);
    orderMultishipOptionDTO.setOrderItemId(1L);
    orderMultishipOptionDTO.setAddressId(null);
    orderMultishipOptionDTO.setFulfillmentOptionId(null);

    ArrayList<OrderMultishipOptionDTO> optionDtos = new ArrayList<>();
    optionDtos.add(orderMultishipOptionDTO);

    // Act
    List<OrderMultishipOption> actualOrderMultishipOptionsFromDTOs = orderMultishipOptionServiceImpl
        .getOrderMultishipOptionsFromDTOs(order, optionDtos);

    // Assert
    verify(orderItemService).readOrderItemById(eq(1L));
    assertEquals(1, actualOrderMultishipOptionsFromDTOs.size());
    OrderMultishipOption getResult = actualOrderMultishipOptionsFromDTOs.get(0);
    OrderItem orderItem = getResult.getOrderItem();
    assertTrue(orderItem instanceof BundleOrderItemImpl);
    Order order2 = getResult.getOrder();
    assertTrue(order2 instanceof NullOrderImpl);
    assertTrue(getResult instanceof OrderMultishipOptionImpl);
    assertNull(getResult.getFulfillmentOption());
    assertNull(getResult.getAddress());
    assertEquals(1L, getResult.getId().longValue());
    assertSame(bundleOrderItemImpl, orderItem);
    assertSame(order, order2);
  }

  /**
   * Test {@link OrderMultishipOptionServiceImpl#generateOrderMultishipOptions(Order)}.
   * <ul>
   *   <li>Given {@link Auditable} (default constructor) CreatedBy is one.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderMultishipOptionServiceImpl#generateOrderMultishipOptions(Order)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List OrderMultishipOptionServiceImpl.generateOrderMultishipOptions(Order)"})
  public void testGenerateOrderMultishipOptions_givenAuditableCreatedByIsOne_thenReturnEmpty() {
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
    order.setTotalTax(new Money());

    // Act and Assert
    assertTrue(orderMultishipOptionServiceImpl.generateOrderMultishipOptions(order).isEmpty());
  }

  /**
   * Test {@link OrderMultishipOptionServiceImpl#createPopulatedOrderMultishipOption(Order, DiscreteOrderItem, Integer)}.
   * <p>
   * Method under test: {@link OrderMultishipOptionServiceImpl#createPopulatedOrderMultishipOption(Order, DiscreteOrderItem, Integer)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "List OrderMultishipOptionServiceImpl.createPopulatedOrderMultishipOption(Order, DiscreteOrderItem, Integer)"})
  public void testCreatePopulatedOrderMultishipOption() {
    // Arrange
    when(fulfillmentGroupService.isShippable(Mockito.<FulfillmentType>any())).thenReturn(false);
    NullOrderImpl order = new NullOrderImpl();
    DiscreteOrderItem item = mock(DiscreteOrderItem.class);
    when(item.getSku()).thenReturn(new SkuImpl());

    // Act
    List<OrderMultishipOption> actualCreatePopulatedOrderMultishipOptionResult = orderMultishipOptionServiceImpl
        .createPopulatedOrderMultishipOption(order, item, 1);

    // Assert
    verify(item).getSku();
    verify(fulfillmentGroupService).isShippable(isNull());
    assertTrue(actualCreatePopulatedOrderMultishipOptionResult.isEmpty());
  }

  /**
   * Test {@link OrderMultishipOptionServiceImpl#createPopulatedOrderMultishipOption(Order, DiscreteOrderItem, Integer)}.
   * <ul>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderMultishipOptionServiceImpl#createPopulatedOrderMultishipOption(Order, DiscreteOrderItem, Integer)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "List OrderMultishipOptionServiceImpl.createPopulatedOrderMultishipOption(Order, DiscreteOrderItem, Integer)"})
  public void testCreatePopulatedOrderMultishipOption_thenReturnSizeIsOne() {
    // Arrange
    when(fulfillmentGroupService.isShippable(Mockito.<FulfillmentType>any())).thenReturn(true);
    NullOrderImpl order = new NullOrderImpl();
    DiscreteOrderItem item = mock(DiscreteOrderItem.class);
    when(item.getSku()).thenReturn(new SkuImpl());

    // Act
    List<OrderMultishipOption> actualCreatePopulatedOrderMultishipOptionResult = orderMultishipOptionServiceImpl
        .createPopulatedOrderMultishipOption(order, item, 1);

    // Assert
    verify(item).getSku();
    verify(fulfillmentGroupService).isShippable(isNull());
    assertEquals(1, actualCreatePopulatedOrderMultishipOptionResult.size());
    OrderMultishipOption getResult = actualCreatePopulatedOrderMultishipOptionResult.get(0);
    Order order2 = getResult.getOrder();
    assertTrue(order2 instanceof NullOrderImpl);
    assertTrue(getResult instanceof OrderMultishipOptionImpl);
    assertNull(getResult.getId());
    assertNull(getResult.getFulfillmentOption());
    assertNull(getResult.getAddress());
    assertSame(order, order2);
    assertSame(item, getResult.getOrderItem());
  }

  /**
   * Test {@link OrderMultishipOptionServiceImpl#createPopulatedOrderMultishipOption(Order, DiscreteOrderItem, Integer)}.
   * <ul>
   *   <li>When zero.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderMultishipOptionServiceImpl#createPopulatedOrderMultishipOption(Order, DiscreteOrderItem, Integer)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "List OrderMultishipOptionServiceImpl.createPopulatedOrderMultishipOption(Order, DiscreteOrderItem, Integer)"})
  public void testCreatePopulatedOrderMultishipOption_whenZero_thenReturnEmpty() {
    // Arrange
    when(fulfillmentGroupService.isShippable(Mockito.<FulfillmentType>any())).thenReturn(true);
    NullOrderImpl order = new NullOrderImpl();
    DiscreteOrderItem item = mock(DiscreteOrderItem.class);
    when(item.getSku()).thenReturn(new SkuImpl());

    // Act
    List<OrderMultishipOption> actualCreatePopulatedOrderMultishipOptionResult = orderMultishipOptionServiceImpl
        .createPopulatedOrderMultishipOption(order, item, 0);

    // Assert
    verify(item).getSku();
    verify(fulfillmentGroupService).isShippable(isNull());
    assertTrue(actualCreatePopulatedOrderMultishipOptionResult.isEmpty());
  }
}
