package org.broadleafcommerce.core.order.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
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
import org.broadleafcommerce.core.order.domain.DiscreteOrderItemImpl;
import org.broadleafcommerce.core.order.domain.FulfillmentOption;
import org.broadleafcommerce.core.order.domain.FulfillmentOptionImpl;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.Order;
import org.broadleafcommerce.core.order.domain.OrderImpl;
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
  @Mock private AddressService addressService;

  @Mock private FulfillmentGroupService fulfillmentGroupService;

  @Mock private FulfillmentOptionService fulfillmentOptionService;

  @Mock private OrderItemService orderItemService;

  @Mock private OrderMultishipOptionDao orderMultishipOptionDao;

  @InjectMocks private OrderMultishipOptionServiceImpl orderMultishipOptionServiceImpl;

  /**
   * Test {@link OrderMultishipOptionServiceImpl#save(OrderMultishipOption)}.
   *
   * <p>Method under test: {@link OrderMultishipOptionServiceImpl#save(OrderMultishipOption)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "OrderMultishipOption OrderMultishipOptionServiceImpl.save(OrderMultishipOption)"
  })
  public void testSave() {
    // Arrange
    OrderMultishipOptionImpl orderMultishipOptionImpl = new OrderMultishipOptionImpl();
    when(orderMultishipOptionDao.save(Mockito.<OrderMultishipOption>any()))
        .thenReturn(orderMultishipOptionImpl);

    // Act
    OrderMultishipOption actualSaveResult =
        orderMultishipOptionServiceImpl.save(new OrderMultishipOptionImpl());

    // Assert
    verify(orderMultishipOptionDao).save(isA(OrderMultishipOption.class));
    assertSame(orderMultishipOptionImpl, actualSaveResult);
  }

  /**
   * Test {@link OrderMultishipOptionServiceImpl#findOrderMultishipOptions(Long)}.
   *
   * <p>Method under test: {@link OrderMultishipOptionServiceImpl#findOrderMultishipOptions(Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List OrderMultishipOptionServiceImpl.findOrderMultishipOptions(Long)"})
  public void testFindOrderMultishipOptions() {
    // Arrange
    when(orderMultishipOptionDao.readOrderMultishipOptions(Mockito.<Long>any()))
        .thenReturn(new ArrayList<>());

    // Act
    List<OrderMultishipOption> actualFindOrderMultishipOptionsResult =
        orderMultishipOptionServiceImpl.findOrderMultishipOptions(1L);

    // Assert
    verify(orderMultishipOptionDao).readOrderMultishipOptions(1L);
    assertTrue(actualFindOrderMultishipOptionsResult.isEmpty());
  }

  /**
   * Test {@link OrderMultishipOptionServiceImpl#findOrderItemOrderMultishipOptions(Long)}.
   *
   * <p>Method under test: {@link
   * OrderMultishipOptionServiceImpl#findOrderItemOrderMultishipOptions(Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List OrderMultishipOptionServiceImpl.findOrderItemOrderMultishipOptions(Long)"
  })
  public void testFindOrderItemOrderMultishipOptions() {
    // Arrange
    when(orderMultishipOptionDao.readOrderItemOrderMultishipOptions(Mockito.<Long>any()))
        .thenReturn(new ArrayList<>());

    // Act
    List<OrderMultishipOption> actualFindOrderItemOrderMultishipOptionsResult =
        orderMultishipOptionServiceImpl.findOrderItemOrderMultishipOptions(1L);

    // Assert
    verify(orderMultishipOptionDao).readOrderItemOrderMultishipOptions(1L);
    assertTrue(actualFindOrderItemOrderMultishipOptionsResult.isEmpty());
  }

  /**
   * Test {@link OrderMultishipOptionServiceImpl#create()}.
   *
   * <p>Method under test: {@link OrderMultishipOptionServiceImpl#create()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
   * Test {@link OrderMultishipOptionServiceImpl#deleteOrderItemOrderMultishipOptions(Long)} with
   * {@code orderItemId}.
   *
   * <p>Method under test: {@link
   * OrderMultishipOptionServiceImpl#deleteOrderItemOrderMultishipOptions(Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void OrderMultishipOptionServiceImpl.deleteOrderItemOrderMultishipOptions(Long)"
  })
  public void testDeleteOrderItemOrderMultishipOptionsWithOrderItemId() {
    // Arrange
    when(orderMultishipOptionDao.readOrderItemOrderMultishipOptions(Mockito.<Long>any()))
        .thenReturn(new ArrayList<>());
    doNothing().when(orderMultishipOptionDao).deleteAll(Mockito.<List<OrderMultishipOption>>any());

    // Act
    orderMultishipOptionServiceImpl.deleteOrderItemOrderMultishipOptions(1L);

    // Assert
    verify(orderMultishipOptionDao).deleteAll(isA(List.class));
    verify(orderMultishipOptionDao).readOrderItemOrderMultishipOptions(1L);
  }

  /**
   * Test {@link OrderMultishipOptionServiceImpl#deleteOrderItemOrderMultishipOptions(Long, int)}
   * with {@code orderItemId}, {@code numToDelete}.
   *
   * <ul>
   *   <li>When ten.
   * </ul>
   *
   * <p>Method under test: {@link
   * OrderMultishipOptionServiceImpl#deleteOrderItemOrderMultishipOptions(Long, int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void OrderMultishipOptionServiceImpl.deleteOrderItemOrderMultishipOptions(Long, int)"
  })
  public void testDeleteOrderItemOrderMultishipOptionsWithOrderItemIdNumToDelete_whenTen() {
    // Arrange
    when(orderMultishipOptionDao.readOrderItemOrderMultishipOptions(Mockito.<Long>any()))
        .thenReturn(new ArrayList<>());
    doNothing().when(orderMultishipOptionDao).deleteAll(Mockito.<List<OrderMultishipOption>>any());

    // Act
    orderMultishipOptionServiceImpl.deleteOrderItemOrderMultishipOptions(1L, 10);

    // Assert
    verify(orderMultishipOptionDao).deleteAll(isA(List.class));
    verify(orderMultishipOptionDao).readOrderItemOrderMultishipOptions(1L);
  }

  /**
   * Test {@link OrderMultishipOptionServiceImpl#deleteOrderItemOrderMultishipOptions(Long, int)}
   * with {@code orderItemId}, {@code numToDelete}.
   *
   * <ul>
   *   <li>When zero.
   * </ul>
   *
   * <p>Method under test: {@link
   * OrderMultishipOptionServiceImpl#deleteOrderItemOrderMultishipOptions(Long, int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void OrderMultishipOptionServiceImpl.deleteOrderItemOrderMultishipOptions(Long, int)"
  })
  public void testDeleteOrderItemOrderMultishipOptionsWithOrderItemIdNumToDelete_whenZero() {
    // Arrange
    when(orderMultishipOptionDao.readOrderItemOrderMultishipOptions(Mockito.<Long>any()))
        .thenReturn(new ArrayList<>());
    doNothing().when(orderMultishipOptionDao).deleteAll(Mockito.<List<OrderMultishipOption>>any());

    // Act
    orderMultishipOptionServiceImpl.deleteOrderItemOrderMultishipOptions(1L, 0);

    // Assert
    verify(orderMultishipOptionDao).deleteAll(isA(List.class));
    verify(orderMultishipOptionDao).readOrderItemOrderMultishipOptions(1L);
  }

  /**
   * Test {@link OrderMultishipOptionServiceImpl#deleteAllOrderMultishipOptions(Order)}.
   *
   * <ul>
   *   <li>When {@link NullOrderImpl} (default constructor).
   *   <li>Then calls {@link OrderMultishipOptionDao#deleteAll(List)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * OrderMultishipOptionServiceImpl#deleteAllOrderMultishipOptions(Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void OrderMultishipOptionServiceImpl.deleteAllOrderMultishipOptions(Order)"})
  public void testDeleteAllOrderMultishipOptions_whenNullOrderImpl_thenCallsDeleteAll() {
    // Arrange
    when(orderMultishipOptionDao.readOrderMultishipOptions(Mockito.<Long>any()))
        .thenReturn(new ArrayList<>());
    doNothing().when(orderMultishipOptionDao).deleteAll(Mockito.<List<OrderMultishipOption>>any());

    // Act
    orderMultishipOptionServiceImpl.deleteAllOrderMultishipOptions(new NullOrderImpl());

    // Assert
    verify(orderMultishipOptionDao).deleteAll(isA(List.class));
    verify(orderMultishipOptionDao).readOrderMultishipOptions(isNull());
  }

  /**
   * Test {@link OrderMultishipOptionServiceImpl#saveOrderMultishipOptions(Order, List)}.
   *
   * <p>Method under test: {@link OrderMultishipOptionServiceImpl#saveOrderMultishipOptions(Order,
   * List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void OrderMultishipOptionServiceImpl.saveOrderMultishipOptions(Order, List)"})
  public void testSaveOrderMultishipOptions() {
    // Arrange
    when(addressService.readAddressById(Mockito.<Long>any())).thenReturn(new AddressImpl());
    when(orderItemService.readOrderItemById(Mockito.<Long>any()))
        .thenReturn(new BundleOrderItemImpl());
    when(orderMultishipOptionDao.save(Mockito.<OrderMultishipOption>any()))
        .thenReturn(new OrderMultishipOptionImpl());
    when(orderMultishipOptionDao.create()).thenReturn(new OrderMultishipOptionImpl());
    when(orderMultishipOptionDao.readOrderMultishipOptions(Mockito.<Long>any()))
        .thenReturn(new ArrayList<>());
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
    verify(orderItemService).readOrderItemById(1L);
    verify(addressService).readAddressById(1L);
  }

  /**
   * Test {@link OrderMultishipOptionServiceImpl#saveOrderMultishipOptions(Order, List)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link OrderMultishipOptionImpl} (default
   *       constructor).
   * </ul>
   *
   * <p>Method under test: {@link OrderMultishipOptionServiceImpl#saveOrderMultishipOptions(Order,
   * List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void OrderMultishipOptionServiceImpl.saveOrderMultishipOptions(Order, List)"})
  public void testSaveOrderMultishipOptions_givenArrayListAddOrderMultishipOptionImpl() {
    // Arrange
    ArrayList<OrderMultishipOption> orderMultishipOptionList = new ArrayList<>();
    orderMultishipOptionList.add(new OrderMultishipOptionImpl());
    when(orderMultishipOptionDao.readOrderMultishipOptions(Mockito.<Long>any()))
        .thenReturn(orderMultishipOptionList);
    NullOrderImpl order = new NullOrderImpl();

    // Act
    orderMultishipOptionServiceImpl.saveOrderMultishipOptions(order, new ArrayList<>());

    // Assert
    verify(orderMultishipOptionDao).readOrderMultishipOptions(isNull());
  }

  /**
   * Test {@link OrderMultishipOptionServiceImpl#saveOrderMultishipOptions(Order, List)}.
   *
   * <ul>
   *   <li>Given {@link OrderMultishipOptionDTO} (default constructor) AddressId is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link OrderMultishipOptionServiceImpl#saveOrderMultishipOptions(Order,
   * List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void OrderMultishipOptionServiceImpl.saveOrderMultishipOptions(Order, List)"})
  public void testSaveOrderMultishipOptions_givenOrderMultishipOptionDTOAddressIdIsNull() {
    // Arrange
    when(fulfillmentOptionService.readFulfillmentOptionById(Mockito.<Long>any()))
        .thenReturn(new FulfillmentOptionImpl());
    when(orderItemService.readOrderItemById(Mockito.<Long>any()))
        .thenReturn(new BundleOrderItemImpl());
    when(orderMultishipOptionDao.save(Mockito.<OrderMultishipOption>any()))
        .thenReturn(new OrderMultishipOptionImpl());
    when(orderMultishipOptionDao.create()).thenReturn(new OrderMultishipOptionImpl());
    when(orderMultishipOptionDao.readOrderMultishipOptions(Mockito.<Long>any()))
        .thenReturn(new ArrayList<>());
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
    verify(fulfillmentOptionService).readFulfillmentOptionById(1L);
    verify(orderItemService).readOrderItemById(1L);
  }

  /**
   * Test {@link OrderMultishipOptionServiceImpl#saveOrderMultishipOptions(Order, List)}.
   *
   * <ul>
   *   <li>Given {@link OrderMultishipOptionDTO} (default constructor) AddressId is two.
   * </ul>
   *
   * <p>Method under test: {@link OrderMultishipOptionServiceImpl#saveOrderMultishipOptions(Order,
   * List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void OrderMultishipOptionServiceImpl.saveOrderMultishipOptions(Order, List)"})
  public void testSaveOrderMultishipOptions_givenOrderMultishipOptionDTOAddressIdIsTwo() {
    // Arrange
    when(addressService.readAddressById(Mockito.<Long>any())).thenReturn(new AddressImpl());
    when(fulfillmentOptionService.readFulfillmentOptionById(Mockito.<Long>any()))
        .thenReturn(new FulfillmentOptionImpl());
    when(orderItemService.readOrderItemById(Mockito.<Long>any()))
        .thenReturn(new BundleOrderItemImpl());
    when(orderMultishipOptionDao.save(Mockito.<OrderMultishipOption>any()))
        .thenReturn(new OrderMultishipOptionImpl());
    when(orderMultishipOptionDao.create()).thenReturn(new OrderMultishipOptionImpl());
    when(orderMultishipOptionDao.readOrderMultishipOptions(Mockito.<Long>any()))
        .thenReturn(new ArrayList<>());
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
   *
   * <ul>
   *   <li>Then calls {@link FulfillmentOptionService#readFulfillmentOptionById(Long)}.
   * </ul>
   *
   * <p>Method under test: {@link OrderMultishipOptionServiceImpl#saveOrderMultishipOptions(Order,
   * List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void OrderMultishipOptionServiceImpl.saveOrderMultishipOptions(Order, List)"})
  public void testSaveOrderMultishipOptions_thenCallsReadFulfillmentOptionById() {
    // Arrange
    when(addressService.readAddressById(Mockito.<Long>any())).thenReturn(new AddressImpl());
    when(fulfillmentOptionService.readFulfillmentOptionById(Mockito.<Long>any()))
        .thenReturn(new FulfillmentOptionImpl());
    when(orderItemService.readOrderItemById(Mockito.<Long>any()))
        .thenReturn(new BundleOrderItemImpl());
    when(orderMultishipOptionDao.save(Mockito.<OrderMultishipOption>any()))
        .thenReturn(new OrderMultishipOptionImpl());
    when(orderMultishipOptionDao.create()).thenReturn(new OrderMultishipOptionImpl());
    when(orderMultishipOptionDao.readOrderMultishipOptions(Mockito.<Long>any()))
        .thenReturn(new ArrayList<>());
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
    verify(fulfillmentOptionService).readFulfillmentOptionById(1L);
    verify(orderItemService).readOrderItemById(1L);
    verify(addressService).readAddressById(1L);
  }

  /**
   * Test {@link OrderMultishipOptionServiceImpl#saveOrderMultishipOptions(Order, List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then calls {@link OrderMultishipOptionDao#readOrderMultishipOptions(Long)}.
   * </ul>
   *
   * <p>Method under test: {@link OrderMultishipOptionServiceImpl#saveOrderMultishipOptions(Order,
   * List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void OrderMultishipOptionServiceImpl.saveOrderMultishipOptions(Order, List)"})
  public void testSaveOrderMultishipOptions_whenArrayList_thenCallsReadOrderMultishipOptions() {
    // Arrange
    when(orderMultishipOptionDao.readOrderMultishipOptions(Mockito.<Long>any()))
        .thenReturn(new ArrayList<>());
    NullOrderImpl order = new NullOrderImpl();

    // Act
    orderMultishipOptionServiceImpl.saveOrderMultishipOptions(order, new ArrayList<>());

    // Assert
    verify(orderMultishipOptionDao).readOrderMultishipOptions(isNull());
  }

  /**
   * Test {@link OrderMultishipOptionServiceImpl#getOrGenerateOrderMultishipOptions(Order)}.
   *
   * <ul>
   *   <li>Then calls {@link OrderMultishipOptionImpl#getOrderItem()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * OrderMultishipOptionServiceImpl#getOrGenerateOrderMultishipOptions(Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List OrderMultishipOptionServiceImpl.getOrGenerateOrderMultishipOptions(Order)"
  })
  public void testGetOrGenerateOrderMultishipOptions_thenCallsGetOrderItem() {
    // Arrange
    OrderMultishipOptionImpl orderMultishipOptionImpl = mock(OrderMultishipOptionImpl.class);
    when(orderMultishipOptionImpl.getOrderItem()).thenReturn(new BundleOrderItemImpl());

    ArrayList<OrderMultishipOption> orderMultishipOptionList = new ArrayList<>();
    orderMultishipOptionList.add(orderMultishipOptionImpl);
    doNothing().when(orderMultishipOptionDao).deleteAll(Mockito.<List<OrderMultishipOption>>any());
    when(orderMultishipOptionDao.readOrderMultishipOptions(Mockito.<Long>any()))
        .thenReturn(orderMultishipOptionList);

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());

    // Act
    List<OrderMultishipOption> actualOrGenerateOrderMultishipOptions =
        orderMultishipOptionServiceImpl.getOrGenerateOrderMultishipOptions(order);

    // Assert
    verify(orderMultishipOptionDao).deleteAll(isA(List.class));
    verify(orderMultishipOptionDao).readOrderMultishipOptions(1L);
    verify(orderMultishipOptionImpl).getOrderItem();
    assertTrue(actualOrGenerateOrderMultishipOptions.isEmpty());
  }

  /**
   * Test {@link OrderMultishipOptionServiceImpl#getOrGenerateOrderMultishipOptions(Order)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link
   * OrderMultishipOptionServiceImpl#getOrGenerateOrderMultishipOptions(Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List OrderMultishipOptionServiceImpl.getOrGenerateOrderMultishipOptions(Order)"
  })
  public void testGetOrGenerateOrderMultishipOptions_thenReturnEmpty() {
    // Arrange
    doNothing().when(orderMultishipOptionDao).deleteAll(Mockito.<List<OrderMultishipOption>>any());
    when(orderMultishipOptionDao.readOrderMultishipOptions(Mockito.<Long>any()))
        .thenReturn(new ArrayList<>());

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());

    // Act
    List<OrderMultishipOption> actualOrGenerateOrderMultishipOptions =
        orderMultishipOptionServiceImpl.getOrGenerateOrderMultishipOptions(order);

    // Assert
    verify(orderMultishipOptionDao).deleteAll(isA(List.class));
    verify(orderMultishipOptionDao).readOrderMultishipOptions(1L);
    assertTrue(actualOrGenerateOrderMultishipOptions.isEmpty());
  }

  /**
   * Test {@link OrderMultishipOptionServiceImpl#getOrderMultishipOptionsFromDTOs(Order, List)}.
   *
   * <p>Method under test: {@link
   * OrderMultishipOptionServiceImpl#getOrderMultishipOptionsFromDTOs(Order, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List OrderMultishipOptionServiceImpl.getOrderMultishipOptionsFromDTOs(Order, List)"
  })
  public void testGetOrderMultishipOptionsFromDTOs() {
    // Arrange
    AddressImpl addressImpl = new AddressImpl();
    when(addressService.readAddressById(Mockito.<Long>any())).thenReturn(addressImpl);
    FulfillmentOptionImpl fulfillmentOptionImpl = new FulfillmentOptionImpl();
    when(fulfillmentOptionService.readFulfillmentOptionById(Mockito.<Long>any()))
        .thenReturn(fulfillmentOptionImpl);
    when(orderItemService.readOrderItemById(Mockito.<Long>any()))
        .thenReturn(new BundleOrderItemImpl());
    NullOrderImpl order = new NullOrderImpl();

    OrderMultishipOptionDTO orderMultishipOptionDTO = new OrderMultishipOptionDTO();
    orderMultishipOptionDTO.setId(1L);
    orderMultishipOptionDTO.setOrderItemId(1L);
    orderMultishipOptionDTO.setAddressId(1L);
    orderMultishipOptionDTO.setFulfillmentOptionId(1L);

    ArrayList<OrderMultishipOptionDTO> optionDtos = new ArrayList<>();
    optionDtos.add(orderMultishipOptionDTO);

    // Act
    List<OrderMultishipOption> actualOrderMultishipOptionsFromDTOs =
        orderMultishipOptionServiceImpl.getOrderMultishipOptionsFromDTOs(order, optionDtos);

    // Assert
    verify(fulfillmentOptionService).readFulfillmentOptionById(1L);
    verify(orderItemService).readOrderItemById(1L);
    verify(addressService).readAddressById(1L);
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
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link
   * OrderMultishipOptionServiceImpl#getOrderMultishipOptionsFromDTOs(Order, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List OrderMultishipOptionServiceImpl.getOrderMultishipOptionsFromDTOs(Order, List)"
  })
  public void testGetOrderMultishipOptionsFromDTOs_thenReturnEmpty() {
    // Arrange
    OrderMultishipOptionServiceImpl orderMultishipOptionServiceImpl =
        new OrderMultishipOptionServiceImpl();
    NullOrderImpl order = new NullOrderImpl();

    // Act and Assert
    assertTrue(
        orderMultishipOptionServiceImpl
            .getOrderMultishipOptionsFromDTOs(order, new ArrayList<>())
            .isEmpty());
  }

  /**
   * Test {@link OrderMultishipOptionServiceImpl#getOrderMultishipOptionsFromDTOs(Order, List)}.
   *
   * <ul>
   *   <li>Then return first FulfillmentOption Id is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * OrderMultishipOptionServiceImpl#getOrderMultishipOptionsFromDTOs(Order, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List OrderMultishipOptionServiceImpl.getOrderMultishipOptionsFromDTOs(Order, List)"
  })
  public void testGetOrderMultishipOptionsFromDTOs_thenReturnFirstFulfillmentOptionIdIsNull() {
    // Arrange
    when(fulfillmentOptionService.readFulfillmentOptionById(Mockito.<Long>any()))
        .thenReturn(new FulfillmentOptionImpl());
    when(orderItemService.readOrderItemById(Mockito.<Long>any()))
        .thenReturn(new BundleOrderItemImpl());
    NullOrderImpl order = new NullOrderImpl();

    OrderMultishipOptionDTO orderMultishipOptionDTO = new OrderMultishipOptionDTO();
    orderMultishipOptionDTO.setId(1L);
    orderMultishipOptionDTO.setOrderItemId(1L);
    orderMultishipOptionDTO.setAddressId(null);
    orderMultishipOptionDTO.setFulfillmentOptionId(1L);

    ArrayList<OrderMultishipOptionDTO> optionDtos = new ArrayList<>();
    optionDtos.add(orderMultishipOptionDTO);

    // Act
    List<OrderMultishipOption> actualOrderMultishipOptionsFromDTOs =
        orderMultishipOptionServiceImpl.getOrderMultishipOptionsFromDTOs(order, optionDtos);

    // Assert
    verify(fulfillmentOptionService).readFulfillmentOptionById(1L);
    verify(orderItemService).readOrderItemById(1L);
    assertEquals(1, actualOrderMultishipOptionsFromDTOs.size());
    OrderMultishipOption getResult = actualOrderMultishipOptionsFromDTOs.get(0);
    FulfillmentOption fulfillmentOption = getResult.getFulfillmentOption();
    assertTrue(fulfillmentOption instanceof FulfillmentOptionImpl);
    assertTrue(getResult instanceof OrderMultishipOptionImpl);
    assertNull(fulfillmentOption.getId());
    assertNull(fulfillmentOption.getLongDescription());
    assertNull(fulfillmentOption.getName());
    assertNull(fulfillmentOption.getTaxCode());
    assertNull(fulfillmentOption.getFulfillmentType());
    assertNull(getResult.getAddress());
    assertFalse(fulfillmentOption.getTaxable());
    assertTrue(fulfillmentOption.getUseFlatRates());
  }

  /**
   * Test {@link OrderMultishipOptionServiceImpl#getOrderMultishipOptionsFromDTOs(Order, List)}.
   *
   * <ul>
   *   <li>Then return first FulfillmentOption is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * OrderMultishipOptionServiceImpl#getOrderMultishipOptionsFromDTOs(Order, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List OrderMultishipOptionServiceImpl.getOrderMultishipOptionsFromDTOs(Order, List)"
  })
  public void testGetOrderMultishipOptionsFromDTOs_thenReturnFirstFulfillmentOptionIsNull() {
    // Arrange
    AddressImpl addressImpl = new AddressImpl();
    when(addressService.readAddressById(Mockito.<Long>any())).thenReturn(addressImpl);
    when(orderItemService.readOrderItemById(Mockito.<Long>any()))
        .thenReturn(new BundleOrderItemImpl());
    NullOrderImpl order = new NullOrderImpl();

    OrderMultishipOptionDTO orderMultishipOptionDTO = new OrderMultishipOptionDTO();
    orderMultishipOptionDTO.setId(1L);
    orderMultishipOptionDTO.setOrderItemId(1L);
    orderMultishipOptionDTO.setAddressId(1L);
    orderMultishipOptionDTO.setFulfillmentOptionId(null);

    ArrayList<OrderMultishipOptionDTO> optionDtos = new ArrayList<>();
    optionDtos.add(orderMultishipOptionDTO);

    // Act
    List<OrderMultishipOption> actualOrderMultishipOptionsFromDTOs =
        orderMultishipOptionServiceImpl.getOrderMultishipOptionsFromDTOs(order, optionDtos);

    // Assert
    verify(orderItemService).readOrderItemById(1L);
    verify(addressService).readAddressById(1L);
    assertEquals(1, actualOrderMultishipOptionsFromDTOs.size());
    OrderMultishipOption getResult = actualOrderMultishipOptionsFromDTOs.get(0);
    assertTrue(getResult instanceof OrderMultishipOptionImpl);
    Address address = getResult.getAddress();
    assertTrue(address instanceof AddressImpl);
    assertNull(getResult.getFulfillmentOption());
    assertSame(addressImpl, address);
  }

  /**
   * Test {@link OrderMultishipOptionServiceImpl#generateOrderMultishipOptions(Order)}.
   *
   * <p>Method under test: {@link
   * OrderMultishipOptionServiceImpl#generateOrderMultishipOptions(Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List OrderMultishipOptionServiceImpl.generateOrderMultishipOptions(Order)"})
  public void testGenerateOrderMultishipOptions() {
    // Arrange
    when(fulfillmentGroupService.isShippable(Mockito.<FulfillmentType>any())).thenReturn(false);

    DiscreteOrderItemImpl discreteOrderItemImpl = mock(DiscreteOrderItemImpl.class);
    when(discreteOrderItemImpl.getQuantity()).thenReturn(1);
    when(discreteOrderItemImpl.getSku()).thenReturn(new SkuImpl());

    ArrayList<DiscreteOrderItem> discreteOrderItemList = new ArrayList<>();
    discreteOrderItemList.add(discreteOrderItemImpl);

    Order order = mock(Order.class);
    when(order.getDiscreteOrderItems()).thenReturn(discreteOrderItemList);

    // Act
    List<OrderMultishipOption> actualGenerateOrderMultishipOptionsResult =
        orderMultishipOptionServiceImpl.generateOrderMultishipOptions(order);

    // Assert
    verify(discreteOrderItemImpl).getSku();
    verify(order).getDiscreteOrderItems();
    verify(discreteOrderItemImpl).getQuantity();
    verify(fulfillmentGroupService).isShippable(isNull());
    assertTrue(actualGenerateOrderMultishipOptionsResult.isEmpty());
  }

  /**
   * Test {@link OrderMultishipOptionServiceImpl#generateOrderMultishipOptions(Order)}.
   *
   * <p>Method under test: {@link
   * OrderMultishipOptionServiceImpl#generateOrderMultishipOptions(Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List OrderMultishipOptionServiceImpl.generateOrderMultishipOptions(Order)"})
  public void testGenerateOrderMultishipOptions2() {
    // Arrange
    when(fulfillmentGroupService.isShippable(Mockito.<FulfillmentType>any())).thenReturn(true);

    DiscreteOrderItemImpl discreteOrderItemImpl = mock(DiscreteOrderItemImpl.class);
    when(discreteOrderItemImpl.getQuantity()).thenReturn(0);
    when(discreteOrderItemImpl.getSku()).thenReturn(new SkuImpl());

    ArrayList<DiscreteOrderItem> discreteOrderItemList = new ArrayList<>();
    discreteOrderItemList.add(discreteOrderItemImpl);

    Order order = mock(Order.class);
    when(order.getDiscreteOrderItems()).thenReturn(discreteOrderItemList);

    // Act
    List<OrderMultishipOption> actualGenerateOrderMultishipOptionsResult =
        orderMultishipOptionServiceImpl.generateOrderMultishipOptions(order);

    // Assert
    verify(discreteOrderItemImpl).getSku();
    verify(order).getDiscreteOrderItems();
    verify(discreteOrderItemImpl).getQuantity();
    verify(fulfillmentGroupService).isShippable(isNull());
    assertTrue(actualGenerateOrderMultishipOptionsResult.isEmpty());
  }

  /**
   * Test {@link OrderMultishipOptionServiceImpl#generateOrderMultishipOptions(Order)}.
   *
   * <ul>
   *   <li>Given {@link OrderMultishipOptionServiceImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link
   * OrderMultishipOptionServiceImpl#generateOrderMultishipOptions(Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List OrderMultishipOptionServiceImpl.generateOrderMultishipOptions(Order)"})
  public void testGenerateOrderMultishipOptions_givenOrderMultishipOptionServiceImpl() {
    // Arrange
    OrderMultishipOptionServiceImpl orderMultishipOptionServiceImpl =
        new OrderMultishipOptionServiceImpl();

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());

    // Act and Assert
    assertTrue(orderMultishipOptionServiceImpl.generateOrderMultishipOptions(order).isEmpty());
  }

  /**
   * Test {@link OrderMultishipOptionServiceImpl#generateOrderMultishipOptions(Order)}.
   *
   * <ul>
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link
   * OrderMultishipOptionServiceImpl#generateOrderMultishipOptions(Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List OrderMultishipOptionServiceImpl.generateOrderMultishipOptions(Order)"})
  public void testGenerateOrderMultishipOptions_thenReturnSizeIsOne() {
    // Arrange
    when(fulfillmentGroupService.isShippable(Mockito.<FulfillmentType>any())).thenReturn(true);

    DiscreteOrderItemImpl discreteOrderItemImpl = mock(DiscreteOrderItemImpl.class);
    when(discreteOrderItemImpl.getQuantity()).thenReturn(1);
    when(discreteOrderItemImpl.getSku()).thenReturn(new SkuImpl());

    ArrayList<DiscreteOrderItem> discreteOrderItemList = new ArrayList<>();
    discreteOrderItemList.add(discreteOrderItemImpl);

    Order order = mock(Order.class);
    when(order.getDiscreteOrderItems()).thenReturn(discreteOrderItemList);

    // Act
    List<OrderMultishipOption> actualGenerateOrderMultishipOptionsResult =
        orderMultishipOptionServiceImpl.generateOrderMultishipOptions(order);

    // Assert
    verify(discreteOrderItemImpl).getSku();
    verify(order).getDiscreteOrderItems();
    verify(discreteOrderItemImpl).getQuantity();
    verify(fulfillmentGroupService).isShippable(isNull());
    assertEquals(1, actualGenerateOrderMultishipOptionsResult.size());
    OrderMultishipOption getResult = actualGenerateOrderMultishipOptionsResult.get(0);
    assertTrue(getResult instanceof OrderMultishipOptionImpl);
    assertNull(getResult.getId());
    assertNull(getResult.getFulfillmentOption());
    assertNull(getResult.getAddress());
    assertSame(order, getResult.getOrder());
  }

  /**
   * Test {@link OrderMultishipOptionServiceImpl#createPopulatedOrderMultishipOption(Order,
   * DiscreteOrderItem, Integer)}.
   *
   * <p>Method under test: {@link
   * OrderMultishipOptionServiceImpl#createPopulatedOrderMultishipOption(Order, DiscreteOrderItem,
   * Integer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List OrderMultishipOptionServiceImpl.createPopulatedOrderMultishipOption(Order, DiscreteOrderItem, Integer)"
  })
  public void testCreatePopulatedOrderMultishipOption() {
    // Arrange
    when(fulfillmentGroupService.isShippable(Mockito.<FulfillmentType>any())).thenReturn(false);
    NullOrderImpl order = new NullOrderImpl();

    DiscreteOrderItem item = mock(DiscreteOrderItem.class);
    when(item.getSku()).thenReturn(new SkuImpl());

    // Act
    List<OrderMultishipOption> actualCreatePopulatedOrderMultishipOptionResult =
        orderMultishipOptionServiceImpl.createPopulatedOrderMultishipOption(order, item, 1);

    // Assert
    verify(item).getSku();
    verify(fulfillmentGroupService).isShippable(isNull());
    assertTrue(actualCreatePopulatedOrderMultishipOptionResult.isEmpty());
  }

  /**
   * Test {@link OrderMultishipOptionServiceImpl#createPopulatedOrderMultishipOption(Order,
   * DiscreteOrderItem, Integer)}.
   *
   * <ul>
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link
   * OrderMultishipOptionServiceImpl#createPopulatedOrderMultishipOption(Order, DiscreteOrderItem,
   * Integer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List OrderMultishipOptionServiceImpl.createPopulatedOrderMultishipOption(Order, DiscreteOrderItem, Integer)"
  })
  public void testCreatePopulatedOrderMultishipOption_thenReturnSizeIsOne() {
    // Arrange
    when(fulfillmentGroupService.isShippable(Mockito.<FulfillmentType>any())).thenReturn(true);
    NullOrderImpl order = new NullOrderImpl();

    DiscreteOrderItem item = mock(DiscreteOrderItem.class);
    when(item.getSku()).thenReturn(new SkuImpl());

    // Act
    List<OrderMultishipOption> actualCreatePopulatedOrderMultishipOptionResult =
        orderMultishipOptionServiceImpl.createPopulatedOrderMultishipOption(order, item, 1);

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
   * Test {@link OrderMultishipOptionServiceImpl#createPopulatedOrderMultishipOption(Order,
   * DiscreteOrderItem, Integer)}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link
   * OrderMultishipOptionServiceImpl#createPopulatedOrderMultishipOption(Order, DiscreteOrderItem,
   * Integer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List OrderMultishipOptionServiceImpl.createPopulatedOrderMultishipOption(Order, DiscreteOrderItem, Integer)"
  })
  public void testCreatePopulatedOrderMultishipOption_whenZero_thenReturnEmpty() {
    // Arrange
    when(fulfillmentGroupService.isShippable(Mockito.<FulfillmentType>any())).thenReturn(true);
    NullOrderImpl order = new NullOrderImpl();

    DiscreteOrderItem item = mock(DiscreteOrderItem.class);
    when(item.getSku()).thenReturn(new SkuImpl());

    // Act
    List<OrderMultishipOption> actualCreatePopulatedOrderMultishipOptionResult =
        orderMultishipOptionServiceImpl.createPopulatedOrderMultishipOption(order, item, 0);

    // Assert
    verify(item).getSku();
    verify(fulfillmentGroupService).isShippable(isNull());
    assertTrue(actualCreatePopulatedOrderMultishipOptionResult.isEmpty());
  }
}
