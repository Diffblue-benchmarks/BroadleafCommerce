package org.broadleafcommerce.core.order.service.workflow.add;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
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
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.broadleafcommerce.common.audit.Auditable;
import org.broadleafcommerce.common.currency.domain.BroadleafCurrencyImpl;
import org.broadleafcommerce.common.extension.ExtensionResultHolder;
import org.broadleafcommerce.common.extension.ExtensionResultStatusType;
import org.broadleafcommerce.common.locale.domain.LocaleImpl;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.common.sandbox.SandBoxHelper;
import org.broadleafcommerce.common.sandbox.SandBoxHelper.OriginalIdResponse;
import org.broadleafcommerce.core.catalog.domain.Product;
import org.broadleafcommerce.core.catalog.domain.ProductBundleImpl;
import org.broadleafcommerce.core.catalog.domain.ProductOption;
import org.broadleafcommerce.core.catalog.domain.ProductOptionImpl;
import org.broadleafcommerce.core.catalog.domain.ProductOptionXref;
import org.broadleafcommerce.core.catalog.domain.ProductOptionXrefImpl;
import org.broadleafcommerce.core.catalog.domain.Sku;
import org.broadleafcommerce.core.catalog.domain.SkuImpl;
import org.broadleafcommerce.core.catalog.service.CatalogService;
import org.broadleafcommerce.core.order.domain.BundleOrderItemImpl;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.Order;
import org.broadleafcommerce.core.order.domain.OrderImpl;
import org.broadleafcommerce.core.order.service.OrderItemService;
import org.broadleafcommerce.core.order.service.ProductOptionValidationService;
import org.broadleafcommerce.core.order.service.call.NonDiscreteOrderItemRequestDTO;
import org.broadleafcommerce.core.order.service.call.OrderItemRequestDTO;
import org.broadleafcommerce.core.order.service.exception.MinQuantityNotFulfilledException;
import org.broadleafcommerce.core.order.service.exception.RequiredAttributeNotProvidedException;
import org.broadleafcommerce.core.order.service.type.OrderStatus;
import org.broadleafcommerce.core.order.service.workflow.CartOperationRequest;
import org.broadleafcommerce.core.order.service.workflow.add.extension.ValidateAddRequestActivityExtensionHandler;
import org.broadleafcommerce.core.order.service.workflow.add.extension.ValidateAddRequestActivityExtensionManager;
import org.broadleafcommerce.core.order.service.workflow.service.OrderItemRequestValidationService;
import org.broadleafcommerce.core.workflow.ActivityMessages;
import org.broadleafcommerce.core.workflow.DefaultProcessContextImpl;
import org.broadleafcommerce.core.workflow.ProcessContext;
import org.broadleafcommerce.profile.core.domain.CustomerImpl;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ValidateAddRequestActivityDiffblueTest {
  @Mock private CatalogService catalogService;

  @Mock private OrderItemRequestValidationService orderItemRequestValidationService;

  @Mock private OrderItemService orderItemService;

  @Mock private ProductOptionValidationService productOptionValidationService;

  @Mock private SandBoxHelper sandBoxHelper;

  @InjectMocks private ValidateAddRequestActivity validateAddRequestActivity;

  @Mock
  private ValidateAddRequestActivityExtensionManager validateAddRequestActivityExtensionManager;

  /**
   * Test {@link ValidateAddRequestActivity#execute(ProcessContext)}.
   *
   * <p>Method under test: {@link ValidateAddRequestActivity#execute(ProcessContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ProcessContext ValidateAddRequestActivity.execute(ProcessContext)"})
  public void testExecute() throws Exception {
    // Arrange
    ValidateAddRequestActivity validateAddRequestActivity = new ValidateAddRequestActivity();

    NonDiscreteOrderItemRequestDTO itemRequest =
        new NonDiscreteOrderItemRequestDTO("Item Name", 1, new Money());
    itemRequest.setQuantity(-1);
    itemRequest.setProductId(1L);
    itemRequest.setSkuId(1L);
    itemRequest.setParentOrderItemId(1L);
    itemRequest.setItemAttributes(new HashMap<>());

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
    order.setCurrency(new BroadleafCurrencyImpl());
    NullOrderImpl order2 = new NullOrderImpl();

    CartOperationRequest cartOperationRequest =
        new CartOperationRequest(order2, new OrderItemRequestDTO(), true);
    cartOperationRequest.setItemRequest(itemRequest);
    cartOperationRequest.setOrder(order);

    DefaultProcessContextImpl<CartOperationRequest> context = new DefaultProcessContextImpl<>();
    context.setSeedData(cartOperationRequest);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> validateAddRequestActivity.execute(context));
  }

  /**
   * Test {@link ValidateAddRequestActivity#execute(ProcessContext)}.
   *
   * <p>Method under test: {@link ValidateAddRequestActivity#execute(ProcessContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ProcessContext ValidateAddRequestActivity.execute(ProcessContext)"})
  public void testExecute2() throws Exception {
    // Arrange
    when(validateAddRequestActivityExtensionManager.getProxy())
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> validateAddRequestActivity.execute(new DefaultProcessContextImpl<>()));
    verify(validateAddRequestActivityExtensionManager).getProxy();
  }

  /**
   * Test {@link ValidateAddRequestActivity#execute(ProcessContext)}.
   *
   * <p>Method under test: {@link ValidateAddRequestActivity#execute(ProcessContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ProcessContext ValidateAddRequestActivity.execute(ProcessContext)"})
  public void testExecute3() throws Exception {
    // Arrange
    ValidateAddRequestActivityExtensionHandler validateAddRequestActivityExtensionHandler =
        mock(ValidateAddRequestActivityExtensionHandler.class);
    when(validateAddRequestActivityExtensionHandler.validate(
            Mockito.<CartOperationRequest>any(), Mockito.<ExtensionResultHolder<Exception>>any()))
        .thenThrow(new IllegalArgumentException());
    when(validateAddRequestActivityExtensionManager.getProxy())
        .thenReturn(validateAddRequestActivityExtensionHandler);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> validateAddRequestActivity.execute(new DefaultProcessContextImpl<>()));
    verify(validateAddRequestActivityExtensionManager, atLeast(1)).getProxy();
    verify(validateAddRequestActivityExtensionHandler)
        .validate(isNull(), isA(ExtensionResultHolder.class));
  }

  /**
   * Test {@link ValidateAddRequestActivity#execute(ProcessContext)}.
   *
   * <p>Method under test: {@link ValidateAddRequestActivity#execute(ProcessContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ProcessContext ValidateAddRequestActivity.execute(ProcessContext)"})
  public void testExecute4() throws Exception {
    // Arrange
    ValidateAddRequestActivityExtensionHandler validateAddRequestActivityExtensionHandler =
        mock(ValidateAddRequestActivityExtensionHandler.class);
    when(validateAddRequestActivityExtensionHandler.validate(
            Mockito.<CartOperationRequest>any(), Mockito.<ExtensionResultHolder<Exception>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(validateAddRequestActivityExtensionManager.getProxy())
        .thenReturn(validateAddRequestActivityExtensionHandler);
    when(orderItemRequestValidationService.satisfiesMinQuantityCondition(
            Mockito.<OrderItemRequestDTO>any(),
            Mockito.<ProcessContext<CartOperationRequest>>any()))
        .thenThrow(new IllegalArgumentException());

    NonDiscreteOrderItemRequestDTO itemRequest =
        new NonDiscreteOrderItemRequestDTO("Item Name", 1, new Money());
    itemRequest.setQuantity(0);
    itemRequest.setProductId(42L);
    itemRequest.setSkuId(42L);
    itemRequest.setParentOrderItemId(42L);
    itemRequest.setItemAttributes(new HashMap<>());

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
    order.setCurrency(new BroadleafCurrencyImpl());

    NonDiscreteOrderItemRequestDTO nonDiscreteOrderItemRequestDTO =
        new NonDiscreteOrderItemRequestDTO("Item Name", 1, new Money());
    nonDiscreteOrderItemRequestDTO.setItemName(" ");

    CartOperationRequest cartOperationRequest = mock(CartOperationRequest.class);
    when(cartOperationRequest.getItemRequest()).thenReturn(nonDiscreteOrderItemRequestDTO);
    doNothing().when(cartOperationRequest).setItemRequest(Mockito.<OrderItemRequestDTO>any());
    doNothing().when(cartOperationRequest).setOrder(Mockito.<Order>any());
    cartOperationRequest.setItemRequest(itemRequest);
    cartOperationRequest.setOrder(order);

    ProcessContext<CartOperationRequest> context = mock(ProcessContext.class);
    when(context.getSeedData()).thenReturn(cartOperationRequest);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> validateAddRequestActivity.execute(context));
    verify(validateAddRequestActivityExtensionManager, atLeast(1)).getProxy();
    verify(cartOperationRequest).getItemRequest();
    verify(cartOperationRequest).setItemRequest(isA(OrderItemRequestDTO.class));
    verify(cartOperationRequest).setOrder(isA(Order.class));
    verify(validateAddRequestActivityExtensionHandler)
        .validate(isA(CartOperationRequest.class), isA(ExtensionResultHolder.class));
    verify(orderItemRequestValidationService)
        .satisfiesMinQuantityCondition(isA(OrderItemRequestDTO.class), isA(ProcessContext.class));
    verify(context, atLeast(1)).getSeedData();
  }

  /**
   * Test {@link ValidateAddRequestActivity#execute(ProcessContext)}.
   *
   * <p>Method under test: {@link ValidateAddRequestActivity#execute(ProcessContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ProcessContext ValidateAddRequestActivity.execute(ProcessContext)"})
  public void testExecute5() throws Exception {
    // Arrange
    ValidateAddRequestActivityExtensionHandler validateAddRequestActivityExtensionHandler =
        mock(ValidateAddRequestActivityExtensionHandler.class);
    when(validateAddRequestActivityExtensionHandler.validate(
            Mockito.<CartOperationRequest>any(), Mockito.<ExtensionResultHolder<Exception>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(validateAddRequestActivityExtensionManager.getProxy())
        .thenReturn(validateAddRequestActivityExtensionHandler);
    when(orderItemRequestValidationService.satisfiesMinQuantityCondition(
            Mockito.<OrderItemRequestDTO>any(),
            Mockito.<ProcessContext<CartOperationRequest>>any()))
        .thenReturn(true);

    NonDiscreteOrderItemRequestDTO itemRequest =
        new NonDiscreteOrderItemRequestDTO("Item Name", 1, new Money());
    itemRequest.setQuantity(0);
    itemRequest.setProductId(42L);
    itemRequest.setSkuId(42L);
    itemRequest.setParentOrderItemId(42L);
    itemRequest.setItemAttributes(new HashMap<>());

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
    order.setCurrency(new BroadleafCurrencyImpl());

    NonDiscreteOrderItemRequestDTO nonDiscreteOrderItemRequestDTO =
        mock(NonDiscreteOrderItemRequestDTO.class);
    when(nonDiscreteOrderItemRequestDTO.getProductId()).thenThrow(new IllegalArgumentException());
    when(nonDiscreteOrderItemRequestDTO.getQuantity()).thenReturn(1);
    doNothing().when(nonDiscreteOrderItemRequestDTO).setItemName(Mockito.<String>any());
    nonDiscreteOrderItemRequestDTO.setItemName(" ");

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(1L);
    auditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(1L);

    OrderImpl orderImpl = new OrderImpl();
    orderImpl.setAdditionalOfferInformation(new HashMap<>());
    orderImpl.setAuditable(auditable2);
    orderImpl.setCandidateOrderOffers(new ArrayList<>());
    orderImpl.setCustomer(new CustomerImpl());
    orderImpl.setEmailAddress("42 Main St");
    orderImpl.setFulfillmentGroups(new ArrayList<>());
    orderImpl.setId(1L);
    orderImpl.setLocale(new LocaleImpl());
    orderImpl.setName("Name");
    orderImpl.setOrderAttributes(new HashMap<>());
    orderImpl.setOrderItems(new ArrayList<>());
    orderImpl.setOrderMessages(new ArrayList<>());
    orderImpl.setOrderNumber("42");
    orderImpl.setPayments(new ArrayList<>());
    orderImpl.setStatus(OrderStatus.ARCHIVED);
    orderImpl.setSubTotal(new Money());
    orderImpl.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    orderImpl.setTaxOverride(true);
    orderImpl.setTotal(new Money());
    orderImpl.setTotalFulfillmentCharges(new Money());
    orderImpl.setTotalTax(new Money());
    orderImpl.setCurrency(new BroadleafCurrencyImpl());

    CartOperationRequest cartOperationRequest = mock(CartOperationRequest.class);
    when(cartOperationRequest.getOrder()).thenReturn(orderImpl);
    when(cartOperationRequest.getItemRequest()).thenReturn(nonDiscreteOrderItemRequestDTO);
    doNothing().when(cartOperationRequest).setItemRequest(Mockito.<OrderItemRequestDTO>any());
    doNothing().when(cartOperationRequest).setOrder(Mockito.<Order>any());
    cartOperationRequest.setItemRequest(itemRequest);
    cartOperationRequest.setOrder(order);

    ProcessContext<CartOperationRequest> context = mock(ProcessContext.class);
    when(context.getSeedData()).thenReturn(cartOperationRequest);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> validateAddRequestActivity.execute(context));
    verify(validateAddRequestActivityExtensionManager, atLeast(1)).getProxy();
    verify(nonDiscreteOrderItemRequestDTO).setItemName(" ");
    verify(nonDiscreteOrderItemRequestDTO).getProductId();
    verify(nonDiscreteOrderItemRequestDTO).getQuantity();
    verify(cartOperationRequest).getItemRequest();
    verify(cartOperationRequest).getOrder();
    verify(cartOperationRequest).setItemRequest(isA(OrderItemRequestDTO.class));
    verify(cartOperationRequest).setOrder(isA(Order.class));
    verify(validateAddRequestActivityExtensionHandler)
        .validate(isA(CartOperationRequest.class), isA(ExtensionResultHolder.class));
    verify(orderItemRequestValidationService)
        .satisfiesMinQuantityCondition(isA(OrderItemRequestDTO.class), isA(ProcessContext.class));
    verify(context, atLeast(1)).getSeedData();
  }

  /**
   * Test {@link ValidateAddRequestActivity#execute(ProcessContext)}.
   *
   * <p>Method under test: {@link ValidateAddRequestActivity#execute(ProcessContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ProcessContext ValidateAddRequestActivity.execute(ProcessContext)"})
  public void testExecute6() throws Exception {
    // Arrange
    ValidateAddRequestActivityExtensionHandler validateAddRequestActivityExtensionHandler =
        mock(ValidateAddRequestActivityExtensionHandler.class);
    when(validateAddRequestActivityExtensionHandler.validate(
            Mockito.<CartOperationRequest>any(), Mockito.<ExtensionResultHolder<Exception>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(validateAddRequestActivityExtensionManager.getProxy())
        .thenReturn(validateAddRequestActivityExtensionHandler);
    when(orderItemRequestValidationService.satisfiesMinQuantityCondition(
            Mockito.<OrderItemRequestDTO>any(),
            Mockito.<ProcessContext<CartOperationRequest>>any()))
        .thenReturn(true);

    NonDiscreteOrderItemRequestDTO itemRequest =
        new NonDiscreteOrderItemRequestDTO("Item Name", 1, new Money());
    itemRequest.setItemName(" ");

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
    order.setCurrency(new BroadleafCurrencyImpl());
    NullOrderImpl order2 = new NullOrderImpl();

    CartOperationRequest cartOperationRequest =
        new CartOperationRequest(order2, new OrderItemRequestDTO(), true);
    cartOperationRequest.setItemRequest(itemRequest);
    cartOperationRequest.setOrder(order);

    DefaultProcessContextImpl<CartOperationRequest> context = new DefaultProcessContextImpl<>();
    context.setSeedData(cartOperationRequest);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> validateAddRequestActivity.execute(context));
    verify(validateAddRequestActivityExtensionManager, atLeast(1)).getProxy();
    verify(validateAddRequestActivityExtensionHandler)
        .validate(isA(CartOperationRequest.class), isA(ExtensionResultHolder.class));
    verify(orderItemRequestValidationService)
        .satisfiesMinQuantityCondition(isA(OrderItemRequestDTO.class), isA(ProcessContext.class));
  }

  /**
   * Test {@link ValidateAddRequestActivity#execute(ProcessContext)}.
   *
   * <p>Method under test: {@link ValidateAddRequestActivity#execute(ProcessContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ProcessContext ValidateAddRequestActivity.execute(ProcessContext)"})
  public void testExecute7() throws Exception {
    // Arrange
    ValidateAddRequestActivityExtensionHandler validateAddRequestActivityExtensionHandler =
        mock(ValidateAddRequestActivityExtensionHandler.class);
    when(validateAddRequestActivityExtensionHandler.validate(
            Mockito.<CartOperationRequest>any(), Mockito.<ExtensionResultHolder<Exception>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(validateAddRequestActivityExtensionManager.getProxy())
        .thenReturn(validateAddRequestActivityExtensionHandler);
    when(orderItemRequestValidationService.satisfiesMinQuantityCondition(
            Mockito.<OrderItemRequestDTO>any(),
            Mockito.<ProcessContext<CartOperationRequest>>any()))
        .thenReturn(true);

    NonDiscreteOrderItemRequestDTO itemRequest =
        new NonDiscreteOrderItemRequestDTO("Item Name", 1, new Money());
    itemRequest.setItemName(" ");

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
    order.setCurrency(new BroadleafCurrencyImpl());

    NonDiscreteOrderItemRequestDTO nonDiscreteOrderItemRequestDTO =
        new NonDiscreteOrderItemRequestDTO("Item Name", 1, new Money());
    nonDiscreteOrderItemRequestDTO.setItemName("");

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(1L);
    auditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(1L);

    OrderImpl orderImpl = new OrderImpl();
    orderImpl.setAdditionalOfferInformation(new HashMap<>());
    orderImpl.setAuditable(auditable2);
    orderImpl.setCandidateOrderOffers(new ArrayList<>());
    orderImpl.setCustomer(new CustomerImpl());
    orderImpl.setEmailAddress("42 Main St");
    orderImpl.setFulfillmentGroups(new ArrayList<>());
    orderImpl.setId(1L);
    orderImpl.setLocale(new LocaleImpl());
    orderImpl.setName("Name");
    orderImpl.setOrderAttributes(new HashMap<>());
    orderImpl.setOrderItems(new ArrayList<>());
    orderImpl.setOrderMessages(new ArrayList<>());
    orderImpl.setOrderNumber("42");
    orderImpl.setPayments(new ArrayList<>());
    orderImpl.setStatus(OrderStatus.ARCHIVED);
    orderImpl.setSubTotal(new Money());
    orderImpl.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    orderImpl.setTaxOverride(true);
    orderImpl.setTotal(new Money());
    orderImpl.setTotalFulfillmentCharges(new Money());
    orderImpl.setTotalTax(new Money());
    orderImpl.setCurrency(new BroadleafCurrencyImpl());

    CartOperationRequest cartOperationRequest = mock(CartOperationRequest.class);
    when(cartOperationRequest.getOrder()).thenReturn(orderImpl);
    when(cartOperationRequest.getItemRequest()).thenReturn(nonDiscreteOrderItemRequestDTO);
    doNothing().when(cartOperationRequest).setItemRequest(Mockito.<OrderItemRequestDTO>any());
    doNothing().when(cartOperationRequest).setOrder(Mockito.<Order>any());
    cartOperationRequest.setItemRequest(itemRequest);
    cartOperationRequest.setOrder(order);

    DefaultProcessContextImpl<CartOperationRequest> context = new DefaultProcessContextImpl<>();
    context.setSeedData(cartOperationRequest);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> validateAddRequestActivity.execute(context));
    verify(validateAddRequestActivityExtensionManager, atLeast(1)).getProxy();
    verify(cartOperationRequest).getItemRequest();
    verify(cartOperationRequest).getOrder();
    verify(cartOperationRequest).setItemRequest(isA(OrderItemRequestDTO.class));
    verify(cartOperationRequest).setOrder(isA(Order.class));
    verify(validateAddRequestActivityExtensionHandler)
        .validate(isA(CartOperationRequest.class), isA(ExtensionResultHolder.class));
    verify(orderItemRequestValidationService)
        .satisfiesMinQuantityCondition(isA(OrderItemRequestDTO.class), isA(ProcessContext.class));
  }

  /**
   * Test {@link ValidateAddRequestActivity#execute(ProcessContext)}.
   *
   * <p>Method under test: {@link ValidateAddRequestActivity#execute(ProcessContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ProcessContext ValidateAddRequestActivity.execute(ProcessContext)"})
  public void testExecute8() throws Exception {
    // Arrange
    ValidateAddRequestActivityExtensionHandler validateAddRequestActivityExtensionHandler =
        mock(ValidateAddRequestActivityExtensionHandler.class);
    when(validateAddRequestActivityExtensionHandler.validate(
            Mockito.<CartOperationRequest>any(), Mockito.<ExtensionResultHolder<Exception>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(validateAddRequestActivityExtensionManager.getProxy())
        .thenReturn(validateAddRequestActivityExtensionHandler);
    when(orderItemRequestValidationService.satisfiesMinQuantityCondition(
            Mockito.<OrderItemRequestDTO>any(),
            Mockito.<ProcessContext<CartOperationRequest>>any()))
        .thenReturn(true);

    NonDiscreteOrderItemRequestDTO itemRequest =
        new NonDiscreteOrderItemRequestDTO("Item Name", 1, new Money());
    itemRequest.setItemName(" ");

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
    order.setCurrency(new BroadleafCurrencyImpl());

    NonDiscreteOrderItemRequestDTO nonDiscreteOrderItemRequestDTO =
        new NonDiscreteOrderItemRequestDTO("Item Name", 1, new Money());
    nonDiscreteOrderItemRequestDTO.setItemName(null);

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(1L);
    auditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(1L);

    OrderImpl orderImpl = new OrderImpl();
    orderImpl.setAdditionalOfferInformation(new HashMap<>());
    orderImpl.setAuditable(auditable2);
    orderImpl.setCandidateOrderOffers(new ArrayList<>());
    orderImpl.setCustomer(new CustomerImpl());
    orderImpl.setEmailAddress("42 Main St");
    orderImpl.setFulfillmentGroups(new ArrayList<>());
    orderImpl.setId(1L);
    orderImpl.setLocale(new LocaleImpl());
    orderImpl.setName("Name");
    orderImpl.setOrderAttributes(new HashMap<>());
    orderImpl.setOrderItems(new ArrayList<>());
    orderImpl.setOrderMessages(new ArrayList<>());
    orderImpl.setOrderNumber("42");
    orderImpl.setPayments(new ArrayList<>());
    orderImpl.setStatus(OrderStatus.ARCHIVED);
    orderImpl.setSubTotal(new Money());
    orderImpl.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    orderImpl.setTaxOverride(true);
    orderImpl.setTotal(new Money());
    orderImpl.setTotalFulfillmentCharges(new Money());
    orderImpl.setTotalTax(new Money());
    orderImpl.setCurrency(new BroadleafCurrencyImpl());

    CartOperationRequest cartOperationRequest = mock(CartOperationRequest.class);
    when(cartOperationRequest.getOrder()).thenReturn(orderImpl);
    when(cartOperationRequest.getItemRequest()).thenReturn(nonDiscreteOrderItemRequestDTO);
    doNothing().when(cartOperationRequest).setItemRequest(Mockito.<OrderItemRequestDTO>any());
    doNothing().when(cartOperationRequest).setOrder(Mockito.<Order>any());
    cartOperationRequest.setItemRequest(itemRequest);
    cartOperationRequest.setOrder(order);

    DefaultProcessContextImpl<CartOperationRequest> context = new DefaultProcessContextImpl<>();
    context.setSeedData(cartOperationRequest);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> validateAddRequestActivity.execute(context));
    verify(validateAddRequestActivityExtensionManager, atLeast(1)).getProxy();
    verify(cartOperationRequest).getItemRequest();
    verify(cartOperationRequest).getOrder();
    verify(cartOperationRequest).setItemRequest(isA(OrderItemRequestDTO.class));
    verify(cartOperationRequest).setOrder(isA(Order.class));
    verify(validateAddRequestActivityExtensionHandler)
        .validate(isA(CartOperationRequest.class), isA(ExtensionResultHolder.class));
    verify(orderItemRequestValidationService)
        .satisfiesMinQuantityCondition(isA(OrderItemRequestDTO.class), isA(ProcessContext.class));
  }

  /**
   * Test {@link ValidateAddRequestActivity#execute(ProcessContext)}.
   *
   * <ul>
   *   <li>Given {@link CartOperationRequest} {@link CartOperationRequest#getOrder()} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link ValidateAddRequestActivity#execute(ProcessContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ProcessContext ValidateAddRequestActivity.execute(ProcessContext)"})
  public void testExecute_givenCartOperationRequestGetOrderThrowIllegalArgumentException()
      throws Exception {
    // Arrange
    ValidateAddRequestActivityExtensionHandler validateAddRequestActivityExtensionHandler =
        mock(ValidateAddRequestActivityExtensionHandler.class);
    when(validateAddRequestActivityExtensionHandler.validate(
            Mockito.<CartOperationRequest>any(), Mockito.<ExtensionResultHolder<Exception>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(validateAddRequestActivityExtensionManager.getProxy())
        .thenReturn(validateAddRequestActivityExtensionHandler);
    when(orderItemRequestValidationService.satisfiesMinQuantityCondition(
            Mockito.<OrderItemRequestDTO>any(),
            Mockito.<ProcessContext<CartOperationRequest>>any()))
        .thenReturn(true);

    NonDiscreteOrderItemRequestDTO itemRequest =
        new NonDiscreteOrderItemRequestDTO("Item Name", 1, new Money());
    itemRequest.setQuantity(0);
    itemRequest.setProductId(42L);
    itemRequest.setSkuId(42L);
    itemRequest.setParentOrderItemId(42L);
    itemRequest.setItemAttributes(new HashMap<>());

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
    order.setCurrency(new BroadleafCurrencyImpl());

    NonDiscreteOrderItemRequestDTO nonDiscreteOrderItemRequestDTO =
        new NonDiscreteOrderItemRequestDTO("Item Name", 1, new Money());
    nonDiscreteOrderItemRequestDTO.setItemName(" ");

    CartOperationRequest cartOperationRequest = mock(CartOperationRequest.class);
    when(cartOperationRequest.getOrder()).thenThrow(new IllegalArgumentException());
    when(cartOperationRequest.getItemRequest()).thenReturn(nonDiscreteOrderItemRequestDTO);
    doNothing().when(cartOperationRequest).setItemRequest(Mockito.<OrderItemRequestDTO>any());
    doNothing().when(cartOperationRequest).setOrder(Mockito.<Order>any());
    cartOperationRequest.setItemRequest(itemRequest);
    cartOperationRequest.setOrder(order);

    ProcessContext<CartOperationRequest> context = mock(ProcessContext.class);
    when(context.getSeedData()).thenReturn(cartOperationRequest);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> validateAddRequestActivity.execute(context));
    verify(validateAddRequestActivityExtensionManager, atLeast(1)).getProxy();
    verify(cartOperationRequest).getItemRequest();
    verify(cartOperationRequest).getOrder();
    verify(cartOperationRequest).setItemRequest(isA(OrderItemRequestDTO.class));
    verify(cartOperationRequest).setOrder(isA(Order.class));
    verify(validateAddRequestActivityExtensionHandler)
        .validate(isA(CartOperationRequest.class), isA(ExtensionResultHolder.class));
    verify(orderItemRequestValidationService)
        .satisfiesMinQuantityCondition(isA(OrderItemRequestDTO.class), isA(ProcessContext.class));
    verify(context, atLeast(1)).getSeedData();
  }

  /**
   * Test {@link ValidateAddRequestActivity#execute(ProcessContext)}.
   *
   * <ul>
   *   <li>Given {@link CatalogService} {@link CatalogService#findProductById(Long)} return {@code
   *       null}.
   * </ul>
   *
   * <p>Method under test: {@link ValidateAddRequestActivity#execute(ProcessContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ProcessContext ValidateAddRequestActivity.execute(ProcessContext)"})
  public void testExecute_givenCatalogServiceFindProductByIdReturnNull() throws Exception {
    // Arrange
    when(catalogService.findProductById(Mockito.<Long>any())).thenReturn(null);

    ValidateAddRequestActivityExtensionHandler validateAddRequestActivityExtensionHandler =
        mock(ValidateAddRequestActivityExtensionHandler.class);
    when(validateAddRequestActivityExtensionHandler.validate(
            Mockito.<CartOperationRequest>any(), Mockito.<ExtensionResultHolder<Exception>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(validateAddRequestActivityExtensionManager.getProxy())
        .thenReturn(validateAddRequestActivityExtensionHandler);
    when(orderItemRequestValidationService.satisfiesMinQuantityCondition(
            Mockito.<OrderItemRequestDTO>any(),
            Mockito.<ProcessContext<CartOperationRequest>>any()))
        .thenReturn(true);

    NonDiscreteOrderItemRequestDTO itemRequest =
        new NonDiscreteOrderItemRequestDTO("Item Name", 1, new Money());
    itemRequest.setQuantity(0);
    itemRequest.setProductId(42L);
    itemRequest.setSkuId(42L);
    itemRequest.setParentOrderItemId(42L);
    itemRequest.setItemAttributes(new HashMap<>());

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
    order.setCurrency(new BroadleafCurrencyImpl());

    NonDiscreteOrderItemRequestDTO nonDiscreteOrderItemRequestDTO =
        mock(NonDiscreteOrderItemRequestDTO.class);
    when(nonDiscreteOrderItemRequestDTO.getProductId()).thenReturn(1L);
    when(nonDiscreteOrderItemRequestDTO.getQuantity()).thenReturn(1);
    doNothing().when(nonDiscreteOrderItemRequestDTO).setItemName(Mockito.<String>any());
    nonDiscreteOrderItemRequestDTO.setItemName(" ");

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(1L);
    auditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(1L);

    OrderImpl orderImpl = new OrderImpl();
    orderImpl.setAdditionalOfferInformation(new HashMap<>());
    orderImpl.setAuditable(auditable2);
    orderImpl.setCandidateOrderOffers(new ArrayList<>());
    orderImpl.setCustomer(new CustomerImpl());
    orderImpl.setEmailAddress("42 Main St");
    orderImpl.setFulfillmentGroups(new ArrayList<>());
    orderImpl.setId(1L);
    orderImpl.setLocale(new LocaleImpl());
    orderImpl.setName("Name");
    orderImpl.setOrderAttributes(new HashMap<>());
    orderImpl.setOrderItems(new ArrayList<>());
    orderImpl.setOrderMessages(new ArrayList<>());
    orderImpl.setOrderNumber("42");
    orderImpl.setPayments(new ArrayList<>());
    orderImpl.setStatus(OrderStatus.ARCHIVED);
    orderImpl.setSubTotal(new Money());
    orderImpl.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    orderImpl.setTaxOverride(true);
    orderImpl.setTotal(new Money());
    orderImpl.setTotalFulfillmentCharges(new Money());
    orderImpl.setTotalTax(new Money());
    orderImpl.setCurrency(new BroadleafCurrencyImpl());

    CartOperationRequest cartOperationRequest = mock(CartOperationRequest.class);
    when(cartOperationRequest.getOrder()).thenReturn(orderImpl);
    when(cartOperationRequest.getItemRequest()).thenReturn(nonDiscreteOrderItemRequestDTO);
    doNothing().when(cartOperationRequest).setItemRequest(Mockito.<OrderItemRequestDTO>any());
    doNothing().when(cartOperationRequest).setOrder(Mockito.<Order>any());
    cartOperationRequest.setItemRequest(itemRequest);
    cartOperationRequest.setOrder(order);

    ProcessContext<CartOperationRequest> context = mock(ProcessContext.class);
    when(context.getSeedData()).thenReturn(cartOperationRequest);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> validateAddRequestActivity.execute(context));
    verify(validateAddRequestActivityExtensionManager, atLeast(1)).getProxy();
    verify(catalogService).findProductById(1L);
    verify(nonDiscreteOrderItemRequestDTO).setItemName(" ");
    verify(nonDiscreteOrderItemRequestDTO, atLeast(1)).getProductId();
    verify(nonDiscreteOrderItemRequestDTO).getQuantity();
    verify(cartOperationRequest).getItemRequest();
    verify(cartOperationRequest).getOrder();
    verify(cartOperationRequest).setItemRequest(isA(OrderItemRequestDTO.class));
    verify(cartOperationRequest).setOrder(isA(Order.class));
    verify(validateAddRequestActivityExtensionHandler)
        .validate(isA(CartOperationRequest.class), isA(ExtensionResultHolder.class));
    verify(orderItemRequestValidationService)
        .satisfiesMinQuantityCondition(isA(OrderItemRequestDTO.class), isA(ProcessContext.class));
    verify(context, atLeast(1)).getSeedData();
  }

  /**
   * Test {@link ValidateAddRequestActivity#execute(ProcessContext)}.
   *
   * <ul>
   *   <li>Given {@link CatalogService} {@link CatalogService#findProductById(Long)} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link ValidateAddRequestActivity#execute(ProcessContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ProcessContext ValidateAddRequestActivity.execute(ProcessContext)"})
  public void testExecute_givenCatalogServiceFindProductByIdThrowIllegalArgumentException()
      throws Exception {
    // Arrange
    when(catalogService.findProductById(Mockito.<Long>any()))
        .thenThrow(new IllegalArgumentException());

    ValidateAddRequestActivityExtensionHandler validateAddRequestActivityExtensionHandler =
        mock(ValidateAddRequestActivityExtensionHandler.class);
    when(validateAddRequestActivityExtensionHandler.validate(
            Mockito.<CartOperationRequest>any(), Mockito.<ExtensionResultHolder<Exception>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(validateAddRequestActivityExtensionManager.getProxy())
        .thenReturn(validateAddRequestActivityExtensionHandler);
    when(orderItemRequestValidationService.satisfiesMinQuantityCondition(
            Mockito.<OrderItemRequestDTO>any(),
            Mockito.<ProcessContext<CartOperationRequest>>any()))
        .thenReturn(true);

    NonDiscreteOrderItemRequestDTO itemRequest =
        new NonDiscreteOrderItemRequestDTO("Item Name", 1, new Money());
    itemRequest.setQuantity(0);
    itemRequest.setProductId(42L);
    itemRequest.setSkuId(42L);
    itemRequest.setParentOrderItemId(42L);
    itemRequest.setItemAttributes(new HashMap<>());

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
    order.setCurrency(new BroadleafCurrencyImpl());

    NonDiscreteOrderItemRequestDTO nonDiscreteOrderItemRequestDTO =
        mock(NonDiscreteOrderItemRequestDTO.class);
    when(nonDiscreteOrderItemRequestDTO.getProductId()).thenReturn(1L);
    when(nonDiscreteOrderItemRequestDTO.getQuantity()).thenReturn(1);
    doNothing().when(nonDiscreteOrderItemRequestDTO).setItemName(Mockito.<String>any());
    nonDiscreteOrderItemRequestDTO.setItemName(" ");

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(1L);
    auditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(1L);

    OrderImpl orderImpl = new OrderImpl();
    orderImpl.setAdditionalOfferInformation(new HashMap<>());
    orderImpl.setAuditable(auditable2);
    orderImpl.setCandidateOrderOffers(new ArrayList<>());
    orderImpl.setCustomer(new CustomerImpl());
    orderImpl.setEmailAddress("42 Main St");
    orderImpl.setFulfillmentGroups(new ArrayList<>());
    orderImpl.setId(1L);
    orderImpl.setLocale(new LocaleImpl());
    orderImpl.setName("Name");
    orderImpl.setOrderAttributes(new HashMap<>());
    orderImpl.setOrderItems(new ArrayList<>());
    orderImpl.setOrderMessages(new ArrayList<>());
    orderImpl.setOrderNumber("42");
    orderImpl.setPayments(new ArrayList<>());
    orderImpl.setStatus(OrderStatus.ARCHIVED);
    orderImpl.setSubTotal(new Money());
    orderImpl.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    orderImpl.setTaxOverride(true);
    orderImpl.setTotal(new Money());
    orderImpl.setTotalFulfillmentCharges(new Money());
    orderImpl.setTotalTax(new Money());
    orderImpl.setCurrency(new BroadleafCurrencyImpl());

    CartOperationRequest cartOperationRequest = mock(CartOperationRequest.class);
    when(cartOperationRequest.getOrder()).thenReturn(orderImpl);
    when(cartOperationRequest.getItemRequest()).thenReturn(nonDiscreteOrderItemRequestDTO);
    doNothing().when(cartOperationRequest).setItemRequest(Mockito.<OrderItemRequestDTO>any());
    doNothing().when(cartOperationRequest).setOrder(Mockito.<Order>any());
    cartOperationRequest.setItemRequest(itemRequest);
    cartOperationRequest.setOrder(order);

    ProcessContext<CartOperationRequest> context = mock(ProcessContext.class);
    when(context.getSeedData()).thenReturn(cartOperationRequest);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> validateAddRequestActivity.execute(context));
    verify(validateAddRequestActivityExtensionManager, atLeast(1)).getProxy();
    verify(catalogService).findProductById(1L);
    verify(nonDiscreteOrderItemRequestDTO).setItemName(" ");
    verify(nonDiscreteOrderItemRequestDTO, atLeast(1)).getProductId();
    verify(nonDiscreteOrderItemRequestDTO).getQuantity();
    verify(cartOperationRequest).getItemRequest();
    verify(cartOperationRequest).getOrder();
    verify(cartOperationRequest).setItemRequest(isA(OrderItemRequestDTO.class));
    verify(cartOperationRequest).setOrder(isA(Order.class));
    verify(validateAddRequestActivityExtensionHandler)
        .validate(isA(CartOperationRequest.class), isA(ExtensionResultHolder.class));
    verify(orderItemRequestValidationService)
        .satisfiesMinQuantityCondition(isA(OrderItemRequestDTO.class), isA(ProcessContext.class));
    verify(context, atLeast(1)).getSeedData();
  }

  /**
   * Test {@link ValidateAddRequestActivity#execute(ProcessContext)}.
   *
   * <ul>
   *   <li>Given {@link CatalogService} {@link CatalogService#findSkuById(Long)} return {@link
   *       SkuImpl} (default constructor).
   *   <li>Then calls {@link CatalogService#findSkuById(Long)}.
   * </ul>
   *
   * <p>Method under test: {@link ValidateAddRequestActivity#execute(ProcessContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ProcessContext ValidateAddRequestActivity.execute(ProcessContext)"})
  public void testExecute_givenCatalogServiceFindSkuByIdReturnSkuImpl_thenCallsFindSkuById()
      throws Exception {
    // Arrange
    when(catalogService.findSkuById(Mockito.<Long>any())).thenReturn(new SkuImpl());

    ValidateAddRequestActivityExtensionHandler validateAddRequestActivityExtensionHandler =
        mock(ValidateAddRequestActivityExtensionHandler.class);
    when(validateAddRequestActivityExtensionHandler.validate(
            Mockito.<CartOperationRequest>any(), Mockito.<ExtensionResultHolder<Exception>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(validateAddRequestActivityExtensionManager.getProxy())
        .thenReturn(validateAddRequestActivityExtensionHandler);
    when(orderItemRequestValidationService.satisfiesMinQuantityCondition(
            Mockito.<OrderItemRequestDTO>any(),
            Mockito.<ProcessContext<CartOperationRequest>>any()))
        .thenReturn(true);

    NonDiscreteOrderItemRequestDTO itemRequest =
        new NonDiscreteOrderItemRequestDTO("Item Name", 1, new Money());
    itemRequest.setItemName(" ");

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
    order.setCurrency(new BroadleafCurrencyImpl());

    NonDiscreteOrderItemRequestDTO nonDiscreteOrderItemRequestDTO =
        new NonDiscreteOrderItemRequestDTO("Item Name", 1, new Money());
    nonDiscreteOrderItemRequestDTO.setSkuId(1L);
    nonDiscreteOrderItemRequestDTO.setItemName(" ");

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(1L);
    auditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(1L);

    OrderImpl orderImpl = new OrderImpl();
    orderImpl.setAdditionalOfferInformation(new HashMap<>());
    orderImpl.setAuditable(auditable2);
    orderImpl.setCandidateOrderOffers(new ArrayList<>());
    orderImpl.setCustomer(new CustomerImpl());
    orderImpl.setEmailAddress("42 Main St");
    orderImpl.setFulfillmentGroups(new ArrayList<>());
    orderImpl.setId(1L);
    orderImpl.setLocale(new LocaleImpl());
    orderImpl.setName("Name");
    orderImpl.setOrderAttributes(new HashMap<>());
    orderImpl.setOrderItems(new ArrayList<>());
    orderImpl.setOrderMessages(new ArrayList<>());
    orderImpl.setOrderNumber("42");
    orderImpl.setPayments(new ArrayList<>());
    orderImpl.setStatus(OrderStatus.ARCHIVED);
    orderImpl.setSubTotal(new Money());
    orderImpl.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    orderImpl.setTaxOverride(true);
    orderImpl.setTotal(new Money());
    orderImpl.setTotalFulfillmentCharges(new Money());
    orderImpl.setTotalTax(new Money());
    orderImpl.setCurrency(new BroadleafCurrencyImpl());

    CartOperationRequest cartOperationRequest = mock(CartOperationRequest.class);
    when(cartOperationRequest.getOrder()).thenReturn(orderImpl);
    when(cartOperationRequest.getItemRequest()).thenReturn(nonDiscreteOrderItemRequestDTO);
    doNothing().when(cartOperationRequest).setItemRequest(Mockito.<OrderItemRequestDTO>any());
    doNothing().when(cartOperationRequest).setOrder(Mockito.<Order>any());
    cartOperationRequest.setItemRequest(itemRequest);
    cartOperationRequest.setOrder(order);

    DefaultProcessContextImpl<CartOperationRequest> context = new DefaultProcessContextImpl<>();
    context.setSeedData(cartOperationRequest);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> validateAddRequestActivity.execute(context));
    verify(validateAddRequestActivityExtensionManager, atLeast(1)).getProxy();
    verify(catalogService).findSkuById(1L);
    verify(cartOperationRequest).getItemRequest();
    verify(cartOperationRequest).getOrder();
    verify(cartOperationRequest).setItemRequest(isA(OrderItemRequestDTO.class));
    verify(cartOperationRequest).setOrder(isA(Order.class));
    verify(validateAddRequestActivityExtensionHandler)
        .validate(isA(CartOperationRequest.class), isA(ExtensionResultHolder.class));
    verify(orderItemRequestValidationService)
        .satisfiesMinQuantityCondition(isA(OrderItemRequestDTO.class), isA(ProcessContext.class));
  }

  /**
   * Test {@link ValidateAddRequestActivity#execute(ProcessContext)}.
   *
   * <ul>
   *   <li>Given {@link CatalogService} {@link CatalogService#findSkuById(Long)} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link ValidateAddRequestActivity#execute(ProcessContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ProcessContext ValidateAddRequestActivity.execute(ProcessContext)"})
  public void testExecute_givenCatalogServiceFindSkuByIdThrowIllegalArgumentException()
      throws Exception {
    // Arrange
    when(catalogService.findSkuById(Mockito.<Long>any())).thenThrow(new IllegalArgumentException());

    ValidateAddRequestActivityExtensionHandler validateAddRequestActivityExtensionHandler =
        mock(ValidateAddRequestActivityExtensionHandler.class);
    when(validateAddRequestActivityExtensionHandler.validate(
            Mockito.<CartOperationRequest>any(), Mockito.<ExtensionResultHolder<Exception>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(validateAddRequestActivityExtensionManager.getProxy())
        .thenReturn(validateAddRequestActivityExtensionHandler);
    when(orderItemRequestValidationService.satisfiesMinQuantityCondition(
            Mockito.<OrderItemRequestDTO>any(),
            Mockito.<ProcessContext<CartOperationRequest>>any()))
        .thenReturn(true);

    NonDiscreteOrderItemRequestDTO itemRequest =
        new NonDiscreteOrderItemRequestDTO("Item Name", 1, new Money());
    itemRequest.setItemName(" ");

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
    order.setCurrency(new BroadleafCurrencyImpl());

    NonDiscreteOrderItemRequestDTO nonDiscreteOrderItemRequestDTO =
        new NonDiscreteOrderItemRequestDTO("Item Name", 1, new Money());
    nonDiscreteOrderItemRequestDTO.setSkuId(1L);
    nonDiscreteOrderItemRequestDTO.setItemName(" ");

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(1L);
    auditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(1L);

    OrderImpl orderImpl = new OrderImpl();
    orderImpl.setAdditionalOfferInformation(new HashMap<>());
    orderImpl.setAuditable(auditable2);
    orderImpl.setCandidateOrderOffers(new ArrayList<>());
    orderImpl.setCustomer(new CustomerImpl());
    orderImpl.setEmailAddress("42 Main St");
    orderImpl.setFulfillmentGroups(new ArrayList<>());
    orderImpl.setId(1L);
    orderImpl.setLocale(new LocaleImpl());
    orderImpl.setName("Name");
    orderImpl.setOrderAttributes(new HashMap<>());
    orderImpl.setOrderItems(new ArrayList<>());
    orderImpl.setOrderMessages(new ArrayList<>());
    orderImpl.setOrderNumber("42");
    orderImpl.setPayments(new ArrayList<>());
    orderImpl.setStatus(OrderStatus.ARCHIVED);
    orderImpl.setSubTotal(new Money());
    orderImpl.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    orderImpl.setTaxOverride(true);
    orderImpl.setTotal(new Money());
    orderImpl.setTotalFulfillmentCharges(new Money());
    orderImpl.setTotalTax(new Money());
    orderImpl.setCurrency(new BroadleafCurrencyImpl());

    CartOperationRequest cartOperationRequest = mock(CartOperationRequest.class);
    when(cartOperationRequest.getOrder()).thenReturn(orderImpl);
    when(cartOperationRequest.getItemRequest()).thenReturn(nonDiscreteOrderItemRequestDTO);
    doNothing().when(cartOperationRequest).setItemRequest(Mockito.<OrderItemRequestDTO>any());
    doNothing().when(cartOperationRequest).setOrder(Mockito.<Order>any());
    cartOperationRequest.setItemRequest(itemRequest);
    cartOperationRequest.setOrder(order);

    DefaultProcessContextImpl<CartOperationRequest> context = new DefaultProcessContextImpl<>();
    context.setSeedData(cartOperationRequest);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> validateAddRequestActivity.execute(context));
    verify(validateAddRequestActivityExtensionManager, atLeast(1)).getProxy();
    verify(catalogService).findSkuById(1L);
    verify(cartOperationRequest).getItemRequest();
    verify(cartOperationRequest).getOrder();
    verify(cartOperationRequest).setItemRequest(isA(OrderItemRequestDTO.class));
    verify(cartOperationRequest).setOrder(isA(Order.class));
    verify(validateAddRequestActivityExtensionHandler)
        .validate(isA(CartOperationRequest.class), isA(ExtensionResultHolder.class));
    verify(orderItemRequestValidationService)
        .satisfiesMinQuantityCondition(isA(OrderItemRequestDTO.class), isA(ProcessContext.class));
  }

  /**
   * Test {@link ValidateAddRequestActivity#execute(ProcessContext)}.
   *
   * <ul>
   *   <li>Given {@link IllegalArgumentException#IllegalArgumentException()}.
   *   <li>Then calls {@link ProcessContext#stopProcess()}.
   * </ul>
   *
   * <p>Method under test: {@link ValidateAddRequestActivity#execute(ProcessContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ProcessContext ValidateAddRequestActivity.execute(ProcessContext)"})
  public void testExecute_givenIllegalArgumentException_thenCallsStopProcess() throws Exception {
    // Arrange
    ValidateAddRequestActivityExtensionHandler validateAddRequestActivityExtensionHandler =
        mock(ValidateAddRequestActivityExtensionHandler.class);
    when(validateAddRequestActivityExtensionHandler.validate(
            Mockito.<CartOperationRequest>any(), Mockito.<ExtensionResultHolder<Exception>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(validateAddRequestActivityExtensionManager.getProxy())
        .thenReturn(validateAddRequestActivityExtensionHandler);

    NonDiscreteOrderItemRequestDTO itemRequest =
        new NonDiscreteOrderItemRequestDTO("Item Name", 1, new Money());
    itemRequest.setQuantity(0);
    itemRequest.setProductId(42L);
    itemRequest.setSkuId(42L);
    itemRequest.setParentOrderItemId(42L);
    itemRequest.setItemAttributes(new HashMap<>());

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
    order.setCurrency(new BroadleafCurrencyImpl());
    NullOrderImpl order2 = new NullOrderImpl();

    CartOperationRequest cartOperationRequest =
        new CartOperationRequest(order2, new OrderItemRequestDTO(), true);
    cartOperationRequest.setItemRequest(itemRequest);
    cartOperationRequest.setOrder(order);

    ProcessContext<CartOperationRequest> context = mock(ProcessContext.class);
    when(context.stopProcess()).thenThrow(new IllegalArgumentException());
    when(context.getSeedData()).thenReturn(cartOperationRequest);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> validateAddRequestActivity.execute(context));
    verify(validateAddRequestActivityExtensionManager, atLeast(1)).getProxy();
    verify(validateAddRequestActivityExtensionHandler)
        .validate(isA(CartOperationRequest.class), isA(ExtensionResultHolder.class));
    verify(context, atLeast(1)).getSeedData();
    verify(context).stopProcess();
  }

  /**
   * Test {@link ValidateAddRequestActivity#execute(ProcessContext)}.
   *
   * <ul>
   *   <li>Given {@link SandBoxHelper.OriginalIdResponse} (default constructor) OriginalId is one.
   *   <li>Then calls {@link NonDiscreteOrderItemRequestDTO#getSkuId()}.
   * </ul>
   *
   * <p>Method under test: {@link ValidateAddRequestActivity#execute(ProcessContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ProcessContext ValidateAddRequestActivity.execute(ProcessContext)"})
  public void testExecute_givenOriginalIdResponseOriginalIdIsOne_thenCallsGetSkuId()
      throws Exception {
    // Arrange
    when(catalogService.findProductById(Mockito.<Long>any())).thenReturn(new ProductBundleImpl());

    ValidateAddRequestActivityExtensionHandler validateAddRequestActivityExtensionHandler =
        mock(ValidateAddRequestActivityExtensionHandler.class);
    when(validateAddRequestActivityExtensionHandler.validate(
            Mockito.<CartOperationRequest>any(), Mockito.<ExtensionResultHolder<Exception>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(validateAddRequestActivityExtensionManager.getProxy())
        .thenReturn(validateAddRequestActivityExtensionHandler);
    when(orderItemRequestValidationService.satisfiesMinQuantityCondition(
            Mockito.<OrderItemRequestDTO>any(),
            Mockito.<ProcessContext<CartOperationRequest>>any()))
        .thenReturn(true);

    OriginalIdResponse originalIdResponse = new OriginalIdResponse();
    originalIdResponse.setOriginalId(1L);
    originalIdResponse.setRecordFound(true);
    when(sandBoxHelper.getOriginalId(Mockito.<Object>any())).thenReturn(1L);
    when(sandBoxHelper.getProductionOriginalId(Mockito.<Class<?>>any(), Mockito.<Long>any()))
        .thenReturn(originalIdResponse);

    NonDiscreteOrderItemRequestDTO itemRequest =
        new NonDiscreteOrderItemRequestDTO("Item Name", 1, new Money());
    itemRequest.setQuantity(0);
    itemRequest.setProductId(42L);
    itemRequest.setSkuId(42L);
    itemRequest.setParentOrderItemId(42L);
    itemRequest.setItemAttributes(new HashMap<>());

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
    order.setCurrency(new BroadleafCurrencyImpl());

    NonDiscreteOrderItemRequestDTO nonDiscreteOrderItemRequestDTO =
        mock(NonDiscreteOrderItemRequestDTO.class);
    when(nonDiscreteOrderItemRequestDTO.getSkuId()).thenThrow(new IllegalArgumentException());
    when(nonDiscreteOrderItemRequestDTO.getProductId()).thenReturn(1L);
    when(nonDiscreteOrderItemRequestDTO.getQuantity()).thenReturn(1);
    doNothing().when(nonDiscreteOrderItemRequestDTO).setItemName(Mockito.<String>any());
    nonDiscreteOrderItemRequestDTO.setItemName(" ");

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(1L);
    auditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(1L);

    OrderImpl orderImpl = new OrderImpl();
    orderImpl.setAdditionalOfferInformation(new HashMap<>());
    orderImpl.setAuditable(auditable2);
    orderImpl.setCandidateOrderOffers(new ArrayList<>());
    orderImpl.setCustomer(new CustomerImpl());
    orderImpl.setEmailAddress("42 Main St");
    orderImpl.setFulfillmentGroups(new ArrayList<>());
    orderImpl.setId(1L);
    orderImpl.setLocale(new LocaleImpl());
    orderImpl.setName("Name");
    orderImpl.setOrderAttributes(new HashMap<>());
    orderImpl.setOrderItems(new ArrayList<>());
    orderImpl.setOrderMessages(new ArrayList<>());
    orderImpl.setOrderNumber("42");
    orderImpl.setPayments(new ArrayList<>());
    orderImpl.setStatus(OrderStatus.ARCHIVED);
    orderImpl.setSubTotal(new Money());
    orderImpl.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    orderImpl.setTaxOverride(true);
    orderImpl.setTotal(new Money());
    orderImpl.setTotalFulfillmentCharges(new Money());
    orderImpl.setTotalTax(new Money());
    orderImpl.setCurrency(new BroadleafCurrencyImpl());

    CartOperationRequest cartOperationRequest = mock(CartOperationRequest.class);
    when(cartOperationRequest.getOrder()).thenReturn(orderImpl);
    when(cartOperationRequest.getItemRequest()).thenReturn(nonDiscreteOrderItemRequestDTO);
    doNothing().when(cartOperationRequest).setItemRequest(Mockito.<OrderItemRequestDTO>any());
    doNothing().when(cartOperationRequest).setOrder(Mockito.<Order>any());
    cartOperationRequest.setItemRequest(itemRequest);
    cartOperationRequest.setOrder(order);

    ProcessContext<CartOperationRequest> context = mock(ProcessContext.class);
    when(context.getSeedData()).thenReturn(cartOperationRequest);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> validateAddRequestActivity.execute(context));
    verify(validateAddRequestActivityExtensionManager, atLeast(1)).getProxy();
    verify(sandBoxHelper).getOriginalId(isA(Object.class));
    verify(sandBoxHelper).getProductionOriginalId(isA(Class.class), isNull());
    verify(catalogService).findProductById(1L);
    verify(nonDiscreteOrderItemRequestDTO).setItemName(" ");
    verify(nonDiscreteOrderItemRequestDTO, atLeast(1)).getProductId();
    verify(nonDiscreteOrderItemRequestDTO).getQuantity();
    verify(nonDiscreteOrderItemRequestDTO).getSkuId();
    verify(cartOperationRequest).getItemRequest();
    verify(cartOperationRequest).getOrder();
    verify(cartOperationRequest).setItemRequest(isA(OrderItemRequestDTO.class));
    verify(cartOperationRequest).setOrder(isA(Order.class));
    verify(validateAddRequestActivityExtensionHandler)
        .validate(isA(CartOperationRequest.class), isA(ExtensionResultHolder.class));
    verify(orderItemRequestValidationService)
        .satisfiesMinQuantityCondition(isA(OrderItemRequestDTO.class), isA(ProcessContext.class));
    verify(context, atLeast(1)).getSeedData();
  }

  /**
   * Test {@link ValidateAddRequestActivity#execute(ProcessContext)}.
   *
   * <ul>
   *   <li>Given {@link SandBoxHelper.OriginalIdResponse} (default constructor) OriginalId is two.
   * </ul>
   *
   * <p>Method under test: {@link ValidateAddRequestActivity#execute(ProcessContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ProcessContext ValidateAddRequestActivity.execute(ProcessContext)"})
  public void testExecute_givenOriginalIdResponseOriginalIdIsTwo() throws Exception {
    // Arrange
    when(catalogService.findProductById(Mockito.<Long>any())).thenReturn(new ProductBundleImpl());

    ValidateAddRequestActivityExtensionHandler validateAddRequestActivityExtensionHandler =
        mock(ValidateAddRequestActivityExtensionHandler.class);
    when(validateAddRequestActivityExtensionHandler.validate(
            Mockito.<CartOperationRequest>any(), Mockito.<ExtensionResultHolder<Exception>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(validateAddRequestActivityExtensionManager.getProxy())
        .thenReturn(validateAddRequestActivityExtensionHandler);
    when(orderItemRequestValidationService.satisfiesMinQuantityCondition(
            Mockito.<OrderItemRequestDTO>any(),
            Mockito.<ProcessContext<CartOperationRequest>>any()))
        .thenReturn(true);

    OriginalIdResponse originalIdResponse = new OriginalIdResponse();
    originalIdResponse.setOriginalId(2L);
    originalIdResponse.setRecordFound(true);
    when(sandBoxHelper.getOriginalId(Mockito.<Object>any())).thenReturn(1L);
    when(sandBoxHelper.getProductionOriginalId(Mockito.<Class<?>>any(), Mockito.<Long>any()))
        .thenReturn(originalIdResponse);

    NonDiscreteOrderItemRequestDTO itemRequest =
        new NonDiscreteOrderItemRequestDTO("Item Name", 1, new Money());
    itemRequest.setQuantity(0);
    itemRequest.setProductId(42L);
    itemRequest.setSkuId(42L);
    itemRequest.setParentOrderItemId(42L);
    itemRequest.setItemAttributes(new HashMap<>());

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
    order.setCurrency(new BroadleafCurrencyImpl());

    NonDiscreteOrderItemRequestDTO nonDiscreteOrderItemRequestDTO =
        mock(NonDiscreteOrderItemRequestDTO.class);
    when(nonDiscreteOrderItemRequestDTO.getProductId()).thenReturn(1L);
    when(nonDiscreteOrderItemRequestDTO.getQuantity()).thenReturn(1);
    doNothing().when(nonDiscreteOrderItemRequestDTO).setItemName(Mockito.<String>any());
    nonDiscreteOrderItemRequestDTO.setItemName(" ");

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(1L);
    auditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(1L);

    OrderImpl orderImpl = new OrderImpl();
    orderImpl.setAdditionalOfferInformation(new HashMap<>());
    orderImpl.setAuditable(auditable2);
    orderImpl.setCandidateOrderOffers(new ArrayList<>());
    orderImpl.setCustomer(new CustomerImpl());
    orderImpl.setEmailAddress("42 Main St");
    orderImpl.setFulfillmentGroups(new ArrayList<>());
    orderImpl.setId(1L);
    orderImpl.setLocale(new LocaleImpl());
    orderImpl.setName("Name");
    orderImpl.setOrderAttributes(new HashMap<>());
    orderImpl.setOrderItems(new ArrayList<>());
    orderImpl.setOrderMessages(new ArrayList<>());
    orderImpl.setOrderNumber("42");
    orderImpl.setPayments(new ArrayList<>());
    orderImpl.setStatus(OrderStatus.ARCHIVED);
    orderImpl.setSubTotal(new Money());
    orderImpl.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    orderImpl.setTaxOverride(true);
    orderImpl.setTotal(new Money());
    orderImpl.setTotalFulfillmentCharges(new Money());
    orderImpl.setTotalTax(new Money());
    orderImpl.setCurrency(new BroadleafCurrencyImpl());

    CartOperationRequest cartOperationRequest = mock(CartOperationRequest.class);
    when(cartOperationRequest.getOrder()).thenReturn(orderImpl);
    when(cartOperationRequest.getItemRequest()).thenReturn(nonDiscreteOrderItemRequestDTO);
    doNothing().when(cartOperationRequest).setItemRequest(Mockito.<OrderItemRequestDTO>any());
    doNothing().when(cartOperationRequest).setOrder(Mockito.<Order>any());
    cartOperationRequest.setItemRequest(itemRequest);
    cartOperationRequest.setOrder(order);

    ProcessContext<CartOperationRequest> context = mock(ProcessContext.class);
    when(context.getSeedData()).thenReturn(cartOperationRequest);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> validateAddRequestActivity.execute(context));
    verify(validateAddRequestActivityExtensionManager, atLeast(1)).getProxy();
    verify(sandBoxHelper).getOriginalId(isA(Object.class));
    verify(sandBoxHelper).getProductionOriginalId(isA(Class.class), isNull());
    verify(catalogService).findProductById(1L);
    verify(nonDiscreteOrderItemRequestDTO).setItemName(" ");
    verify(nonDiscreteOrderItemRequestDTO, atLeast(1)).getProductId();
    verify(nonDiscreteOrderItemRequestDTO).getQuantity();
    verify(cartOperationRequest).getItemRequest();
    verify(cartOperationRequest).getOrder();
    verify(cartOperationRequest).setItemRequest(isA(OrderItemRequestDTO.class));
    verify(cartOperationRequest).setOrder(isA(Order.class));
    verify(validateAddRequestActivityExtensionHandler)
        .validate(isA(CartOperationRequest.class), isA(ExtensionResultHolder.class));
    verify(orderItemRequestValidationService)
        .satisfiesMinQuantityCondition(isA(OrderItemRequestDTO.class), isA(ProcessContext.class));
    verify(context, atLeast(1)).getSeedData();
  }

  /**
   * Test {@link ValidateAddRequestActivity#execute(ProcessContext)}.
   *
   * <ul>
   *   <li>Given {@link SandBoxHelper} {@link SandBoxHelper#getOriginalId(Object)} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link ValidateAddRequestActivity#execute(ProcessContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ProcessContext ValidateAddRequestActivity.execute(ProcessContext)"})
  public void testExecute_givenSandBoxHelperGetOriginalIdThrowIllegalArgumentException()
      throws Exception {
    // Arrange
    when(catalogService.findProductById(Mockito.<Long>any())).thenReturn(new ProductBundleImpl());

    ValidateAddRequestActivityExtensionHandler validateAddRequestActivityExtensionHandler =
        mock(ValidateAddRequestActivityExtensionHandler.class);
    when(validateAddRequestActivityExtensionHandler.validate(
            Mockito.<CartOperationRequest>any(), Mockito.<ExtensionResultHolder<Exception>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(validateAddRequestActivityExtensionManager.getProxy())
        .thenReturn(validateAddRequestActivityExtensionHandler);
    when(orderItemRequestValidationService.satisfiesMinQuantityCondition(
            Mockito.<OrderItemRequestDTO>any(),
            Mockito.<ProcessContext<CartOperationRequest>>any()))
        .thenReturn(true);
    when(sandBoxHelper.getOriginalId(Mockito.<Object>any()))
        .thenThrow(new IllegalArgumentException());

    NonDiscreteOrderItemRequestDTO itemRequest =
        new NonDiscreteOrderItemRequestDTO("Item Name", 1, new Money());
    itemRequest.setQuantity(0);
    itemRequest.setProductId(42L);
    itemRequest.setSkuId(42L);
    itemRequest.setParentOrderItemId(42L);
    itemRequest.setItemAttributes(new HashMap<>());

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
    order.setCurrency(new BroadleafCurrencyImpl());

    NonDiscreteOrderItemRequestDTO nonDiscreteOrderItemRequestDTO =
        mock(NonDiscreteOrderItemRequestDTO.class);
    when(nonDiscreteOrderItemRequestDTO.getProductId()).thenReturn(1L);
    when(nonDiscreteOrderItemRequestDTO.getQuantity()).thenReturn(1);
    doNothing().when(nonDiscreteOrderItemRequestDTO).setItemName(Mockito.<String>any());
    nonDiscreteOrderItemRequestDTO.setItemName(" ");

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(1L);
    auditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(1L);

    OrderImpl orderImpl = new OrderImpl();
    orderImpl.setAdditionalOfferInformation(new HashMap<>());
    orderImpl.setAuditable(auditable2);
    orderImpl.setCandidateOrderOffers(new ArrayList<>());
    orderImpl.setCustomer(new CustomerImpl());
    orderImpl.setEmailAddress("42 Main St");
    orderImpl.setFulfillmentGroups(new ArrayList<>());
    orderImpl.setId(1L);
    orderImpl.setLocale(new LocaleImpl());
    orderImpl.setName("Name");
    orderImpl.setOrderAttributes(new HashMap<>());
    orderImpl.setOrderItems(new ArrayList<>());
    orderImpl.setOrderMessages(new ArrayList<>());
    orderImpl.setOrderNumber("42");
    orderImpl.setPayments(new ArrayList<>());
    orderImpl.setStatus(OrderStatus.ARCHIVED);
    orderImpl.setSubTotal(new Money());
    orderImpl.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    orderImpl.setTaxOverride(true);
    orderImpl.setTotal(new Money());
    orderImpl.setTotalFulfillmentCharges(new Money());
    orderImpl.setTotalTax(new Money());
    orderImpl.setCurrency(new BroadleafCurrencyImpl());

    CartOperationRequest cartOperationRequest = mock(CartOperationRequest.class);
    when(cartOperationRequest.getOrder()).thenReturn(orderImpl);
    when(cartOperationRequest.getItemRequest()).thenReturn(nonDiscreteOrderItemRequestDTO);
    doNothing().when(cartOperationRequest).setItemRequest(Mockito.<OrderItemRequestDTO>any());
    doNothing().when(cartOperationRequest).setOrder(Mockito.<Order>any());
    cartOperationRequest.setItemRequest(itemRequest);
    cartOperationRequest.setOrder(order);

    ProcessContext<CartOperationRequest> context = mock(ProcessContext.class);
    when(context.getSeedData()).thenReturn(cartOperationRequest);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> validateAddRequestActivity.execute(context));
    verify(validateAddRequestActivityExtensionManager, atLeast(1)).getProxy();
    verify(sandBoxHelper).getOriginalId(isA(Object.class));
    verify(catalogService).findProductById(1L);
    verify(nonDiscreteOrderItemRequestDTO).setItemName(" ");
    verify(nonDiscreteOrderItemRequestDTO, atLeast(1)).getProductId();
    verify(nonDiscreteOrderItemRequestDTO).getQuantity();
    verify(cartOperationRequest).getItemRequest();
    verify(cartOperationRequest).getOrder();
    verify(cartOperationRequest).setItemRequest(isA(OrderItemRequestDTO.class));
    verify(cartOperationRequest).setOrder(isA(Order.class));
    verify(validateAddRequestActivityExtensionHandler)
        .validate(isA(CartOperationRequest.class), isA(ExtensionResultHolder.class));
    verify(orderItemRequestValidationService)
        .satisfiesMinQuantityCondition(isA(OrderItemRequestDTO.class), isA(ProcessContext.class));
    verify(context, atLeast(1)).getSeedData();
  }

  /**
   * Test {@link ValidateAddRequestActivity#execute(ProcessContext)}.
   *
   * <ul>
   *   <li>Then {@link DefaultProcessContextImpl} (default constructor) Stopped.
   * </ul>
   *
   * <p>Method under test: {@link ValidateAddRequestActivity#execute(ProcessContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ProcessContext ValidateAddRequestActivity.execute(ProcessContext)"})
  public void testExecute_thenDefaultProcessContextImplStopped() throws Exception {
    // Arrange
    ValidateAddRequestActivityExtensionHandler validateAddRequestActivityExtensionHandler =
        mock(ValidateAddRequestActivityExtensionHandler.class);
    when(validateAddRequestActivityExtensionHandler.validate(
            Mockito.<CartOperationRequest>any(), Mockito.<ExtensionResultHolder<Exception>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(validateAddRequestActivityExtensionManager.getProxy())
        .thenReturn(validateAddRequestActivityExtensionHandler);

    DefaultProcessContextImpl<CartOperationRequest> context = new DefaultProcessContextImpl<>();
    NullOrderImpl order = new NullOrderImpl();
    CartOperationRequest cartOperationRequest =
        new CartOperationRequest(order, new OrderItemRequestDTO(), true);
    context.setSeedData(cartOperationRequest);

    // Act
    ProcessContext<CartOperationRequest> actualExecuteResult =
        validateAddRequestActivity.execute(context);

    // Assert
    verify(validateAddRequestActivityExtensionManager, atLeast(1)).getProxy();
    verify(validateAddRequestActivityExtensionHandler)
        .validate(isA(CartOperationRequest.class), isA(ExtensionResultHolder.class));
    assertTrue(actualExecuteResult instanceof DefaultProcessContextImpl);
    assertTrue(context.isStopped());
    assertTrue(actualExecuteResult.isStopped());
    assertSame(cartOperationRequest, actualExecuteResult.getSeedData());
  }

  /**
   * Test {@link ValidateAddRequestActivity#execute(ProcessContext)}.
   *
   * <ul>
   *   <li>Then return {@link DefaultProcessContextImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link ValidateAddRequestActivity#execute(ProcessContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ProcessContext ValidateAddRequestActivity.execute(ProcessContext)"})
  public void testExecute_thenReturnDefaultProcessContextImpl() throws Exception {
    // Arrange
    ValidateAddRequestActivityExtensionHandler validateAddRequestActivityExtensionHandler =
        mock(ValidateAddRequestActivityExtensionHandler.class);
    when(validateAddRequestActivityExtensionHandler.validate(
            Mockito.<CartOperationRequest>any(), Mockito.<ExtensionResultHolder<Exception>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(validateAddRequestActivityExtensionManager.getProxy())
        .thenReturn(validateAddRequestActivityExtensionHandler);
    when(orderItemRequestValidationService.satisfiesMinQuantityCondition(
            Mockito.<OrderItemRequestDTO>any(),
            Mockito.<ProcessContext<CartOperationRequest>>any()))
        .thenReturn(true);

    NonDiscreteOrderItemRequestDTO itemRequest =
        new NonDiscreteOrderItemRequestDTO("Item Name", 1, new Money());
    itemRequest.setItemName(" ");

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
    order.setCurrency(new BroadleafCurrencyImpl());

    NonDiscreteOrderItemRequestDTO nonDiscreteOrderItemRequestDTO =
        new NonDiscreteOrderItemRequestDTO("Item Name", 1, new Money());
    nonDiscreteOrderItemRequestDTO.setItemName("Item Name");

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(1L);
    auditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(1L);

    OrderImpl orderImpl = new OrderImpl();
    orderImpl.setAdditionalOfferInformation(new HashMap<>());
    orderImpl.setAuditable(auditable2);
    orderImpl.setCandidateOrderOffers(new ArrayList<>());
    orderImpl.setCustomer(new CustomerImpl());
    orderImpl.setEmailAddress("42 Main St");
    orderImpl.setFulfillmentGroups(new ArrayList<>());
    orderImpl.setId(1L);
    orderImpl.setLocale(new LocaleImpl());
    orderImpl.setName("Name");
    orderImpl.setOrderAttributes(new HashMap<>());
    orderImpl.setOrderItems(new ArrayList<>());
    orderImpl.setOrderMessages(new ArrayList<>());
    orderImpl.setOrderNumber("42");
    orderImpl.setPayments(new ArrayList<>());
    orderImpl.setStatus(OrderStatus.ARCHIVED);
    orderImpl.setSubTotal(new Money());
    orderImpl.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    orderImpl.setTaxOverride(true);
    orderImpl.setTotal(new Money());
    orderImpl.setTotalFulfillmentCharges(new Money());
    orderImpl.setTotalTax(new Money());
    orderImpl.setCurrency(new BroadleafCurrencyImpl());

    CartOperationRequest cartOperationRequest = mock(CartOperationRequest.class);
    when(cartOperationRequest.getOrder()).thenReturn(orderImpl);
    when(cartOperationRequest.getItemRequest()).thenReturn(nonDiscreteOrderItemRequestDTO);
    doNothing().when(cartOperationRequest).setItemRequest(Mockito.<OrderItemRequestDTO>any());
    doNothing().when(cartOperationRequest).setOrder(Mockito.<Order>any());
    cartOperationRequest.setItemRequest(itemRequest);
    cartOperationRequest.setOrder(order);

    DefaultProcessContextImpl<CartOperationRequest> context = new DefaultProcessContextImpl<>();
    context.setSeedData(cartOperationRequest);

    // Act
    ProcessContext<CartOperationRequest> actualExecuteResult =
        validateAddRequestActivity.execute(context);

    // Assert
    verify(validateAddRequestActivityExtensionManager, atLeast(1)).getProxy();
    verify(cartOperationRequest).getItemRequest();
    verify(cartOperationRequest).getOrder();
    verify(cartOperationRequest).setItemRequest(isA(OrderItemRequestDTO.class));
    verify(cartOperationRequest).setOrder(isA(Order.class));
    verify(validateAddRequestActivityExtensionHandler)
        .validate(isA(CartOperationRequest.class), isA(ExtensionResultHolder.class));
    verify(orderItemRequestValidationService)
        .satisfiesMinQuantityCondition(isA(OrderItemRequestDTO.class), isA(ProcessContext.class));
    assertSame(context, actualExecuteResult);
  }

  /**
   * Test {@link ValidateAddRequestActivity#execute(ProcessContext)}.
   *
   * <ul>
   *   <li>Then SeedData Order return {@link NullOrderImpl}.
   * </ul>
   *
   * <p>Method under test: {@link ValidateAddRequestActivity#execute(ProcessContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ProcessContext ValidateAddRequestActivity.execute(ProcessContext)"})
  public void testExecute_thenSeedDataOrderReturnNullOrderImpl() throws Exception {
    // Arrange
    ValidateAddRequestActivity validateAddRequestActivity = new ValidateAddRequestActivity();

    DefaultProcessContextImpl<CartOperationRequest> context = new DefaultProcessContextImpl<>();
    NullOrderImpl order = new NullOrderImpl();
    OrderItemRequestDTO itemRequest = new OrderItemRequestDTO();

    CartOperationRequest cartOperationRequest = new CartOperationRequest(order, itemRequest, true);
    context.setSeedData(cartOperationRequest);

    // Act
    ProcessContext<CartOperationRequest> actualExecuteResult =
        validateAddRequestActivity.execute(context);

    // Assert
    CartOperationRequest seedData = actualExecuteResult.getSeedData();
    Order order2 = seedData.getOrder();
    assertTrue(order2 instanceof NullOrderImpl);
    assertTrue(actualExecuteResult instanceof DefaultProcessContextImpl);
    assertSame(order, order2);
    assertSame(itemRequest, seedData.getItemRequest());
  }

  /**
   * Test {@link ValidateAddRequestActivity#execute(ProcessContext)}.
   *
   * <ul>
   *   <li>Then SeedData Order return {@link OrderImpl}.
   * </ul>
   *
   * <p>Method under test: {@link ValidateAddRequestActivity#execute(ProcessContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ProcessContext ValidateAddRequestActivity.execute(ProcessContext)"})
  public void testExecute_thenSeedDataOrderReturnOrderImpl() throws Exception {
    // Arrange
    ValidateAddRequestActivity validateAddRequestActivity = new ValidateAddRequestActivity();

    NonDiscreteOrderItemRequestDTO itemRequest =
        new NonDiscreteOrderItemRequestDTO("Item Name", 1, new Money());
    itemRequest.setQuantity(0);
    itemRequest.setProductId(1L);
    itemRequest.setSkuId(1L);
    itemRequest.setParentOrderItemId(1L);
    itemRequest.setItemAttributes(new HashMap<>());

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
    order.setCurrency(new BroadleafCurrencyImpl());
    NullOrderImpl order2 = new NullOrderImpl();

    CartOperationRequest cartOperationRequest =
        new CartOperationRequest(order2, new OrderItemRequestDTO(), true);
    cartOperationRequest.setItemRequest(itemRequest);
    cartOperationRequest.setOrder(order);

    DefaultProcessContextImpl<CartOperationRequest> context = new DefaultProcessContextImpl<>();
    context.setSeedData(cartOperationRequest);

    // Act
    ProcessContext<CartOperationRequest> actualExecuteResult =
        validateAddRequestActivity.execute(context);

    // Assert
    CartOperationRequest seedData = actualExecuteResult.getSeedData();
    Order order3 = seedData.getOrder();
    assertTrue(order3 instanceof OrderImpl);
    OrderItemRequestDTO itemRequest2 = seedData.getItemRequest();
    assertTrue(itemRequest2 instanceof NonDiscreteOrderItemRequestDTO);
    assertTrue(actualExecuteResult instanceof DefaultProcessContextImpl);
    assertSame(order, order3);
    assertSame(itemRequest, itemRequest2);
  }

  /**
   * Test {@link ValidateAddRequestActivity#execute(ProcessContext)}.
   *
   * <ul>
   *   <li>Then throw {@link RequiredAttributeNotProvidedException}.
   * </ul>
   *
   * <p>Method under test: {@link ValidateAddRequestActivity#execute(ProcessContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ProcessContext ValidateAddRequestActivity.execute(ProcessContext)"})
  public void testExecute_thenThrowRequiredAttributeNotProvidedException() throws Exception {
    // Arrange
    when(catalogService.findSkuById(Mockito.<Long>any()))
        .thenThrow(
            new RequiredAttributeNotProvidedException(
                "Item name is required for non discrete order item add requests"));

    ValidateAddRequestActivityExtensionHandler validateAddRequestActivityExtensionHandler =
        mock(ValidateAddRequestActivityExtensionHandler.class);
    when(validateAddRequestActivityExtensionHandler.validate(
            Mockito.<CartOperationRequest>any(), Mockito.<ExtensionResultHolder<Exception>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(validateAddRequestActivityExtensionManager.getProxy())
        .thenReturn(validateAddRequestActivityExtensionHandler);
    when(orderItemRequestValidationService.satisfiesMinQuantityCondition(
            Mockito.<OrderItemRequestDTO>any(),
            Mockito.<ProcessContext<CartOperationRequest>>any()))
        .thenReturn(true);

    NonDiscreteOrderItemRequestDTO itemRequest =
        new NonDiscreteOrderItemRequestDTO("Item Name", 1, new Money());
    itemRequest.setItemName(" ");

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
    order.setCurrency(new BroadleafCurrencyImpl());

    NonDiscreteOrderItemRequestDTO nonDiscreteOrderItemRequestDTO =
        new NonDiscreteOrderItemRequestDTO("Item Name", 1, new Money());
    nonDiscreteOrderItemRequestDTO.setSkuId(1L);
    nonDiscreteOrderItemRequestDTO.setItemName(" ");

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(1L);
    auditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(1L);

    OrderImpl orderImpl = new OrderImpl();
    orderImpl.setAdditionalOfferInformation(new HashMap<>());
    orderImpl.setAuditable(auditable2);
    orderImpl.setCandidateOrderOffers(new ArrayList<>());
    orderImpl.setCustomer(new CustomerImpl());
    orderImpl.setEmailAddress("42 Main St");
    orderImpl.setFulfillmentGroups(new ArrayList<>());
    orderImpl.setId(1L);
    orderImpl.setLocale(new LocaleImpl());
    orderImpl.setName("Name");
    orderImpl.setOrderAttributes(new HashMap<>());
    orderImpl.setOrderItems(new ArrayList<>());
    orderImpl.setOrderMessages(new ArrayList<>());
    orderImpl.setOrderNumber("42");
    orderImpl.setPayments(new ArrayList<>());
    orderImpl.setStatus(OrderStatus.ARCHIVED);
    orderImpl.setSubTotal(new Money());
    orderImpl.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    orderImpl.setTaxOverride(true);
    orderImpl.setTotal(new Money());
    orderImpl.setTotalFulfillmentCharges(new Money());
    orderImpl.setTotalTax(new Money());
    orderImpl.setCurrency(new BroadleafCurrencyImpl());

    CartOperationRequest cartOperationRequest = mock(CartOperationRequest.class);
    when(cartOperationRequest.getOrder()).thenReturn(orderImpl);
    when(cartOperationRequest.getItemRequest()).thenReturn(nonDiscreteOrderItemRequestDTO);
    doNothing().when(cartOperationRequest).setItemRequest(Mockito.<OrderItemRequestDTO>any());
    doNothing().when(cartOperationRequest).setOrder(Mockito.<Order>any());
    cartOperationRequest.setItemRequest(itemRequest);
    cartOperationRequest.setOrder(order);

    DefaultProcessContextImpl<CartOperationRequest> context = new DefaultProcessContextImpl<>();
    context.setSeedData(cartOperationRequest);

    // Act and Assert
    assertThrows(
        RequiredAttributeNotProvidedException.class,
        () -> validateAddRequestActivity.execute(context));
    verify(validateAddRequestActivityExtensionManager, atLeast(1)).getProxy();
    verify(catalogService).findSkuById(1L);
    verify(cartOperationRequest).getItemRequest();
    verify(cartOperationRequest).getOrder();
    verify(cartOperationRequest).setItemRequest(isA(OrderItemRequestDTO.class));
    verify(cartOperationRequest).setOrder(isA(Order.class));
    verify(validateAddRequestActivityExtensionHandler)
        .validate(isA(CartOperationRequest.class), isA(ExtensionResultHolder.class));
    verify(orderItemRequestValidationService)
        .satisfiesMinQuantityCondition(isA(OrderItemRequestDTO.class), isA(ProcessContext.class));
  }

  /**
   * Test {@link ValidateAddRequestActivity#validate(ProcessContext)}.
   *
   * <p>Method under test: {@link ValidateAddRequestActivity#validate(ProcessContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ProcessContext ValidateAddRequestActivity.validate(ProcessContext)"})
  public void testValidate() {
    // Arrange
    when(orderItemRequestValidationService.satisfiesMinQuantityCondition(
            Mockito.<OrderItemRequestDTO>any(),
            Mockito.<ProcessContext<CartOperationRequest>>any()))
        .thenThrow(new IllegalArgumentException());

    OrderItemRequestDTO itemRequest = new OrderItemRequestDTO();
    itemRequest.setQuantity(1);
    CartOperationRequest cartOperationRequest =
        new CartOperationRequest(new NullOrderImpl(), itemRequest, true);

    DefaultProcessContextImpl<CartOperationRequest> context = new DefaultProcessContextImpl<>();
    context.setSeedData(cartOperationRequest);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> validateAddRequestActivity.validate(context));
    verify(orderItemRequestValidationService)
        .satisfiesMinQuantityCondition(isA(OrderItemRequestDTO.class), isA(ProcessContext.class));
  }

  /**
   * Test {@link ValidateAddRequestActivity#validate(ProcessContext)}.
   *
   * <p>Method under test: {@link ValidateAddRequestActivity#validate(ProcessContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ProcessContext ValidateAddRequestActivity.validate(ProcessContext)"})
  public void testValidate2() {
    // Arrange
    when(orderItemRequestValidationService.satisfiesMinQuantityCondition(
            Mockito.<OrderItemRequestDTO>any(),
            Mockito.<ProcessContext<CartOperationRequest>>any()))
        .thenReturn(true);

    OrderItemRequestDTO itemRequest = new OrderItemRequestDTO(1L, 1);
    itemRequest.setSkuId(1L);
    itemRequest.setQuantity(1);
    CartOperationRequest cartOperationRequest = new CartOperationRequest(null, itemRequest, true);

    DefaultProcessContextImpl<CartOperationRequest> context = new DefaultProcessContextImpl<>();
    context.setSeedData(cartOperationRequest);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> validateAddRequestActivity.validate(context));
    verify(orderItemRequestValidationService)
        .satisfiesMinQuantityCondition(isA(OrderItemRequestDTO.class), isA(ProcessContext.class));
  }

  /**
   * Test {@link ValidateAddRequestActivity#validate(ProcessContext)}.
   *
   * <p>Method under test: {@link ValidateAddRequestActivity#validate(ProcessContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ProcessContext ValidateAddRequestActivity.validate(ProcessContext)"})
  public void testValidate3() {
    // Arrange
    when(orderItemRequestValidationService.satisfiesMinQuantityCondition(
            Mockito.<OrderItemRequestDTO>any(),
            Mockito.<ProcessContext<CartOperationRequest>>any()))
        .thenReturn(true);

    NonDiscreteOrderItemRequestDTO itemRequest = mock(NonDiscreteOrderItemRequestDTO.class);
    when(itemRequest.getProductId()).thenThrow(new IllegalArgumentException());
    when(itemRequest.getQuantity()).thenReturn(1);
    when(itemRequest.getChildOrderItems()).thenReturn(new ArrayList<>());
    when(itemRequest.setQuantity(Mockito.<Integer>any())).thenReturn(new OrderItemRequestDTO());
    when(itemRequest.setSkuId(Mockito.<Long>any())).thenReturn(new OrderItemRequestDTO());
    itemRequest.setSkuId(1L);
    itemRequest.setQuantity(1);
    CartOperationRequest cartOperationRequest =
        new CartOperationRequest(new NullOrderImpl(), itemRequest, true);

    DefaultProcessContextImpl<CartOperationRequest> context = new DefaultProcessContextImpl<>();
    context.setSeedData(cartOperationRequest);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> validateAddRequestActivity.validate(context));
    verify(itemRequest).getChildOrderItems();
    verify(itemRequest).getProductId();
    verify(itemRequest).getQuantity();
    verify(itemRequest).setQuantity(1);
    verify(itemRequest).setSkuId(1L);
    verify(orderItemRequestValidationService)
        .satisfiesMinQuantityCondition(isA(OrderItemRequestDTO.class), isA(ProcessContext.class));
  }

  /**
   * Test {@link ValidateAddRequestActivity#validate(ProcessContext)}.
   *
   * <ul>
   *   <li>Given {@link CatalogService} {@link CatalogService#findProductById(Long)} return {@code
   *       null}.
   * </ul>
   *
   * <p>Method under test: {@link ValidateAddRequestActivity#validate(ProcessContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ProcessContext ValidateAddRequestActivity.validate(ProcessContext)"})
  public void testValidate_givenCatalogServiceFindProductByIdReturnNull() {
    // Arrange
    when(catalogService.findProductById(Mockito.<Long>any())).thenReturn(null);
    when(orderItemRequestValidationService.satisfiesMinQuantityCondition(
            Mockito.<OrderItemRequestDTO>any(),
            Mockito.<ProcessContext<CartOperationRequest>>any()))
        .thenReturn(true);

    OrderItemRequestDTO itemRequest = new OrderItemRequestDTO(1L, 1);
    itemRequest.setSkuId(1L);
    itemRequest.setQuantity(1);
    CartOperationRequest cartOperationRequest =
        new CartOperationRequest(new NullOrderImpl(), itemRequest, true);

    DefaultProcessContextImpl<CartOperationRequest> context = new DefaultProcessContextImpl<>();
    context.setSeedData(cartOperationRequest);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> validateAddRequestActivity.validate(context));
    verify(catalogService).findProductById(1L);
    verify(orderItemRequestValidationService)
        .satisfiesMinQuantityCondition(isA(OrderItemRequestDTO.class), isA(ProcessContext.class));
  }

  /**
   * Test {@link ValidateAddRequestActivity#validate(ProcessContext)}.
   *
   * <ul>
   *   <li>Given {@link CatalogService} {@link CatalogService#findProductById(Long)} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link ValidateAddRequestActivity#validate(ProcessContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ProcessContext ValidateAddRequestActivity.validate(ProcessContext)"})
  public void testValidate_givenCatalogServiceFindProductByIdThrowIllegalArgumentException() {
    // Arrange
    when(catalogService.findProductById(Mockito.<Long>any()))
        .thenThrow(new IllegalArgumentException());
    when(orderItemRequestValidationService.satisfiesMinQuantityCondition(
            Mockito.<OrderItemRequestDTO>any(),
            Mockito.<ProcessContext<CartOperationRequest>>any()))
        .thenReturn(true);

    OrderItemRequestDTO itemRequest = new OrderItemRequestDTO(1L, 1);
    itemRequest.setSkuId(1L);
    itemRequest.setQuantity(1);
    CartOperationRequest cartOperationRequest =
        new CartOperationRequest(new NullOrderImpl(), itemRequest, true);

    DefaultProcessContextImpl<CartOperationRequest> context = new DefaultProcessContextImpl<>();
    context.setSeedData(cartOperationRequest);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> validateAddRequestActivity.validate(context));
    verify(catalogService).findProductById(1L);
    verify(orderItemRequestValidationService)
        .satisfiesMinQuantityCondition(isA(OrderItemRequestDTO.class), isA(ProcessContext.class));
  }

  /**
   * Test {@link ValidateAddRequestActivity#validate(ProcessContext)}.
   *
   * <ul>
   *   <li>Given {@link CatalogService} {@link CatalogService#findSkuById(Long)} return {@code
   *       null}.
   * </ul>
   *
   * <p>Method under test: {@link ValidateAddRequestActivity#validate(ProcessContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ProcessContext ValidateAddRequestActivity.validate(ProcessContext)"})
  public void testValidate_givenCatalogServiceFindSkuByIdReturnNull() {
    // Arrange
    when(catalogService.findProductById(Mockito.<Long>any())).thenReturn(new ProductBundleImpl());
    when(catalogService.findSkuById(Mockito.<Long>any())).thenReturn(null);
    when(orderItemRequestValidationService.satisfiesMinQuantityCondition(
            Mockito.<OrderItemRequestDTO>any(),
            Mockito.<ProcessContext<CartOperationRequest>>any()))
        .thenReturn(true);

    OriginalIdResponse originalIdResponse = new OriginalIdResponse();
    originalIdResponse.setOriginalId(1L);
    originalIdResponse.setRecordFound(true);
    when(sandBoxHelper.getOriginalId(Mockito.<Object>any())).thenReturn(1L);
    when(sandBoxHelper.getProductionOriginalId(Mockito.<Class<?>>any(), Mockito.<Long>any()))
        .thenReturn(originalIdResponse);

    OrderItemRequestDTO itemRequest = new OrderItemRequestDTO(1L, 1);
    itemRequest.setSkuId(1L);
    itemRequest.setQuantity(1);
    CartOperationRequest cartOperationRequest =
        new CartOperationRequest(new NullOrderImpl(), itemRequest, true);

    DefaultProcessContextImpl<CartOperationRequest> context = new DefaultProcessContextImpl<>();
    context.setSeedData(cartOperationRequest);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> validateAddRequestActivity.validate(context));
    verify(sandBoxHelper).getOriginalId(isA(Object.class));
    verify(sandBoxHelper).getProductionOriginalId(isA(Class.class), isNull());
    verify(catalogService).findProductById(1L);
    verify(catalogService).findSkuById(1L);
    verify(orderItemRequestValidationService)
        .satisfiesMinQuantityCondition(isA(OrderItemRequestDTO.class), isA(ProcessContext.class));
  }

  /**
   * Test {@link ValidateAddRequestActivity#validate(ProcessContext)}.
   *
   * <ul>
   *   <li>Given {@link CatalogService} {@link CatalogService#findSkuById(Long)} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link ValidateAddRequestActivity#validate(ProcessContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ProcessContext ValidateAddRequestActivity.validate(ProcessContext)"})
  public void testValidate_givenCatalogServiceFindSkuByIdThrowIllegalArgumentException() {
    // Arrange
    when(catalogService.findSkuById(Mockito.<Long>any())).thenThrow(new IllegalArgumentException());
    when(orderItemRequestValidationService.satisfiesMinQuantityCondition(
            Mockito.<OrderItemRequestDTO>any(),
            Mockito.<ProcessContext<CartOperationRequest>>any()))
        .thenReturn(true);

    OrderItemRequestDTO itemRequest = new OrderItemRequestDTO();
    itemRequest.setSkuId(1L);
    itemRequest.setQuantity(1);
    CartOperationRequest cartOperationRequest =
        new CartOperationRequest(new NullOrderImpl(), itemRequest, true);

    DefaultProcessContextImpl<CartOperationRequest> context = new DefaultProcessContextImpl<>();
    context.setSeedData(cartOperationRequest);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> validateAddRequestActivity.validate(context));
    verify(catalogService).findSkuById(1L);
    verify(orderItemRequestValidationService)
        .satisfiesMinQuantityCondition(isA(OrderItemRequestDTO.class), isA(ProcessContext.class));
  }

  /**
   * Test {@link ValidateAddRequestActivity#validate(ProcessContext)}.
   *
   * <ul>
   *   <li>Given {@link NonDiscreteOrderItemRequestDTO#NonDiscreteOrderItemRequestDTO()} SkuId is
   *       one.
   * </ul>
   *
   * <p>Method under test: {@link ValidateAddRequestActivity#validate(ProcessContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ProcessContext ValidateAddRequestActivity.validate(ProcessContext)"})
  public void testValidate_givenNonDiscreteOrderItemRequestDTOSkuIdIsOne() {
    // Arrange
    when(catalogService.findSkuById(Mockito.<Long>any())).thenReturn(null);
    when(orderItemRequestValidationService.satisfiesMinQuantityCondition(
            Mockito.<OrderItemRequestDTO>any(),
            Mockito.<ProcessContext<CartOperationRequest>>any()))
        .thenReturn(true);

    NonDiscreteOrderItemRequestDTO itemRequest = new NonDiscreteOrderItemRequestDTO();
    itemRequest.setSkuId(1L);
    itemRequest.setQuantity(1);
    CartOperationRequest cartOperationRequest =
        new CartOperationRequest(new NullOrderImpl(), itemRequest, true);

    DefaultProcessContextImpl<CartOperationRequest> context = new DefaultProcessContextImpl<>();
    context.setSeedData(cartOperationRequest);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> validateAddRequestActivity.validate(context));
    verify(catalogService).findSkuById(1L);
    verify(orderItemRequestValidationService)
        .satisfiesMinQuantityCondition(isA(OrderItemRequestDTO.class), isA(ProcessContext.class));
  }

  /**
   * Test {@link ValidateAddRequestActivity#validate(ProcessContext)}.
   *
   * <ul>
   *   <li>Given {@link OrderItemRequestDTO#OrderItemRequestDTO()} Quantity is minus one.
   * </ul>
   *
   * <p>Method under test: {@link ValidateAddRequestActivity#validate(ProcessContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ProcessContext ValidateAddRequestActivity.validate(ProcessContext)"})
  public void testValidate_givenOrderItemRequestDTOQuantityIsMinusOne() {
    // Arrange
    ValidateAddRequestActivity validateAddRequestActivity = new ValidateAddRequestActivity();

    OrderItemRequestDTO itemRequest = new OrderItemRequestDTO();
    itemRequest.setQuantity(-1);
    CartOperationRequest cartOperationRequest =
        new CartOperationRequest(new NullOrderImpl(), itemRequest, true);

    DefaultProcessContextImpl<CartOperationRequest> context = new DefaultProcessContextImpl<>();
    context.setSeedData(cartOperationRequest);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> validateAddRequestActivity.validate(context));
  }

  /**
   * Test {@link ValidateAddRequestActivity#validate(ProcessContext)}.
   *
   * <ul>
   *   <li>Given {@link OrderItemRequestDTO#OrderItemRequestDTO()} Quantity is one.
   * </ul>
   *
   * <p>Method under test: {@link ValidateAddRequestActivity#validate(ProcessContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ProcessContext ValidateAddRequestActivity.validate(ProcessContext)"})
  public void testValidate_givenOrderItemRequestDTOQuantityIsOne() {
    // Arrange
    when(orderItemRequestValidationService.satisfiesMinQuantityCondition(
            Mockito.<OrderItemRequestDTO>any(),
            Mockito.<ProcessContext<CartOperationRequest>>any()))
        .thenReturn(true);

    OrderItemRequestDTO itemRequest = new OrderItemRequestDTO();
    itemRequest.setQuantity(1);
    CartOperationRequest cartOperationRequest =
        new CartOperationRequest(new NullOrderImpl(), itemRequest, true);

    DefaultProcessContextImpl<CartOperationRequest> context = new DefaultProcessContextImpl<>();
    context.setSeedData(cartOperationRequest);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> validateAddRequestActivity.validate(context));
    verify(orderItemRequestValidationService)
        .satisfiesMinQuantityCondition(isA(OrderItemRequestDTO.class), isA(ProcessContext.class));
  }

  /**
   * Test {@link ValidateAddRequestActivity#validate(ProcessContext)}.
   *
   * <ul>
   *   <li>Given {@link OrderItemRequestDTO#OrderItemRequestDTO()} Quantity is zero.
   * </ul>
   *
   * <p>Method under test: {@link ValidateAddRequestActivity#validate(ProcessContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ProcessContext ValidateAddRequestActivity.validate(ProcessContext)"})
  public void testValidate_givenOrderItemRequestDTOQuantityIsZero() {
    // Arrange
    ValidateAddRequestActivity validateAddRequestActivity = new ValidateAddRequestActivity();

    OrderItemRequestDTO itemRequest = new OrderItemRequestDTO();
    itemRequest.setQuantity(0);
    CartOperationRequest cartOperationRequest =
        new CartOperationRequest(new NullOrderImpl(), itemRequest, true);

    DefaultProcessContextImpl<CartOperationRequest> context = new DefaultProcessContextImpl<>();
    context.setSeedData(cartOperationRequest);

    // Act
    ProcessContext<CartOperationRequest> actualValidateResult =
        validateAddRequestActivity.validate(context);

    // Assert
    assertTrue(context.isStopped());
    assertSame(context, actualValidateResult);
  }

  /**
   * Test {@link ValidateAddRequestActivity#validate(ProcessContext)}.
   *
   * <ul>
   *   <li>Given {@link OrderItemRequestDTO#OrderItemRequestDTO()} SkuId is one.
   * </ul>
   *
   * <p>Method under test: {@link ValidateAddRequestActivity#validate(ProcessContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ProcessContext ValidateAddRequestActivity.validate(ProcessContext)"})
  public void testValidate_givenOrderItemRequestDTOSkuIdIsOne() {
    // Arrange
    when(catalogService.findSkuById(Mockito.<Long>any())).thenReturn(new SkuImpl());
    when(orderItemRequestValidationService.satisfiesMinQuantityCondition(
            Mockito.<OrderItemRequestDTO>any(),
            Mockito.<ProcessContext<CartOperationRequest>>any()))
        .thenReturn(true);

    OrderItemRequestDTO itemRequest = new OrderItemRequestDTO();
    itemRequest.setSkuId(1L);
    itemRequest.setQuantity(1);
    CartOperationRequest cartOperationRequest =
        new CartOperationRequest(new NullOrderImpl(), itemRequest, true);

    DefaultProcessContextImpl<CartOperationRequest> context = new DefaultProcessContextImpl<>();
    context.setSeedData(cartOperationRequest);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> validateAddRequestActivity.validate(context));
    verify(catalogService).findSkuById(1L);
    verify(orderItemRequestValidationService)
        .satisfiesMinQuantityCondition(isA(OrderItemRequestDTO.class), isA(ProcessContext.class));
  }

  /**
   * Test {@link ValidateAddRequestActivity#validate(ProcessContext)}.
   *
   * <ul>
   *   <li>Given {@link SandBoxHelper.OriginalIdResponse} (default constructor) OriginalId is two.
   * </ul>
   *
   * <p>Method under test: {@link ValidateAddRequestActivity#validate(ProcessContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ProcessContext ValidateAddRequestActivity.validate(ProcessContext)"})
  public void testValidate_givenOriginalIdResponseOriginalIdIsTwo() {
    // Arrange
    when(catalogService.findProductById(Mockito.<Long>any())).thenReturn(new ProductBundleImpl());
    when(orderItemRequestValidationService.satisfiesMinQuantityCondition(
            Mockito.<OrderItemRequestDTO>any(),
            Mockito.<ProcessContext<CartOperationRequest>>any()))
        .thenReturn(true);

    OriginalIdResponse originalIdResponse = new OriginalIdResponse();
    originalIdResponse.setOriginalId(2L);
    originalIdResponse.setRecordFound(true);
    when(sandBoxHelper.getOriginalId(Mockito.<Object>any())).thenReturn(1L);
    when(sandBoxHelper.getProductionOriginalId(Mockito.<Class<?>>any(), Mockito.<Long>any()))
        .thenReturn(originalIdResponse);

    OrderItemRequestDTO itemRequest = new OrderItemRequestDTO(1L, 1);
    itemRequest.setSkuId(1L);
    itemRequest.setQuantity(1);
    CartOperationRequest cartOperationRequest =
        new CartOperationRequest(new NullOrderImpl(), itemRequest, true);

    DefaultProcessContextImpl<CartOperationRequest> context = new DefaultProcessContextImpl<>();
    context.setSeedData(cartOperationRequest);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> validateAddRequestActivity.validate(context));
    verify(sandBoxHelper).getOriginalId(isA(Object.class));
    verify(sandBoxHelper).getProductionOriginalId(isA(Class.class), isNull());
    verify(catalogService).findProductById(1L);
    verify(orderItemRequestValidationService)
        .satisfiesMinQuantityCondition(isA(OrderItemRequestDTO.class), isA(ProcessContext.class));
  }

  /**
   * Test {@link ValidateAddRequestActivity#validate(ProcessContext)}.
   *
   * <ul>
   *   <li>Given {@link SandBoxHelper} {@link SandBoxHelper#getOriginalId(Object)} return {@code
   *       null}.
   *   <li>Then calls {@link SandBoxHelper#getOriginalId(Object)}.
   * </ul>
   *
   * <p>Method under test: {@link ValidateAddRequestActivity#validate(ProcessContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ProcessContext ValidateAddRequestActivity.validate(ProcessContext)"})
  public void testValidate_givenSandBoxHelperGetOriginalIdReturnNull_thenCallsGetOriginalId() {
    // Arrange
    when(catalogService.findProductById(Mockito.<Long>any())).thenReturn(new ProductBundleImpl());
    when(catalogService.findSkuById(Mockito.<Long>any())).thenReturn(new SkuImpl());
    when(orderItemRequestValidationService.satisfiesMinQuantityCondition(
            Mockito.<OrderItemRequestDTO>any(),
            Mockito.<ProcessContext<CartOperationRequest>>any()))
        .thenReturn(true);
    when(sandBoxHelper.getOriginalId(Mockito.<Object>any())).thenReturn(null);

    OrderItemRequestDTO itemRequest = new OrderItemRequestDTO(1L, 1);
    itemRequest.setSkuId(1L);
    itemRequest.setQuantity(1);
    CartOperationRequest cartOperationRequest =
        new CartOperationRequest(new NullOrderImpl(), itemRequest, true);

    DefaultProcessContextImpl<CartOperationRequest> context = new DefaultProcessContextImpl<>();
    context.setSeedData(cartOperationRequest);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> validateAddRequestActivity.validate(context));
    verify(sandBoxHelper).getOriginalId(isA(Object.class));
    verify(catalogService).findProductById(1L);
    verify(catalogService).findSkuById(1L);
    verify(orderItemRequestValidationService)
        .satisfiesMinQuantityCondition(isA(OrderItemRequestDTO.class), isA(ProcessContext.class));
  }

  /**
   * Test {@link ValidateAddRequestActivity#validate(ProcessContext)}.
   *
   * <ul>
   *   <li>Given {@link SandBoxHelper} {@link SandBoxHelper#getOriginalId(Object)} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link ValidateAddRequestActivity#validate(ProcessContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ProcessContext ValidateAddRequestActivity.validate(ProcessContext)"})
  public void testValidate_givenSandBoxHelperGetOriginalIdThrowIllegalArgumentException() {
    // Arrange
    when(catalogService.findProductById(Mockito.<Long>any())).thenReturn(new ProductBundleImpl());
    when(orderItemRequestValidationService.satisfiesMinQuantityCondition(
            Mockito.<OrderItemRequestDTO>any(),
            Mockito.<ProcessContext<CartOperationRequest>>any()))
        .thenReturn(true);
    when(sandBoxHelper.getOriginalId(Mockito.<Object>any()))
        .thenThrow(new IllegalArgumentException());

    OrderItemRequestDTO itemRequest = new OrderItemRequestDTO(1L, 1);
    itemRequest.setSkuId(1L);
    itemRequest.setQuantity(1);
    CartOperationRequest cartOperationRequest =
        new CartOperationRequest(new NullOrderImpl(), itemRequest, true);

    DefaultProcessContextImpl<CartOperationRequest> context = new DefaultProcessContextImpl<>();
    context.setSeedData(cartOperationRequest);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> validateAddRequestActivity.validate(context));
    verify(sandBoxHelper).getOriginalId(isA(Object.class));
    verify(catalogService).findProductById(1L);
    verify(orderItemRequestValidationService)
        .satisfiesMinQuantityCondition(isA(OrderItemRequestDTO.class), isA(ProcessContext.class));
  }

  /**
   * Test {@link ValidateAddRequestActivity#validate(ProcessContext)}.
   *
   * <ul>
   *   <li>Then calls {@link SandBoxHelper#getProductionOriginalId(Class, Long)}.
   * </ul>
   *
   * <p>Method under test: {@link ValidateAddRequestActivity#validate(ProcessContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ProcessContext ValidateAddRequestActivity.validate(ProcessContext)"})
  public void testValidate_thenCallsGetProductionOriginalId() {
    // Arrange
    when(catalogService.findProductById(Mockito.<Long>any())).thenReturn(new ProductBundleImpl());
    when(catalogService.findSkuById(Mockito.<Long>any())).thenReturn(new SkuImpl());
    when(orderItemRequestValidationService.satisfiesMinQuantityCondition(
            Mockito.<OrderItemRequestDTO>any(),
            Mockito.<ProcessContext<CartOperationRequest>>any()))
        .thenReturn(true);

    OriginalIdResponse originalIdResponse = new OriginalIdResponse();
    originalIdResponse.setOriginalId(1L);
    originalIdResponse.setRecordFound(true);
    when(sandBoxHelper.getOriginalId(Mockito.<Object>any())).thenReturn(1L);
    when(sandBoxHelper.getProductionOriginalId(Mockito.<Class<?>>any(), Mockito.<Long>any()))
        .thenReturn(originalIdResponse);

    OrderItemRequestDTO itemRequest = new OrderItemRequestDTO(1L, 1);
    itemRequest.setSkuId(1L);
    itemRequest.setQuantity(1);
    CartOperationRequest cartOperationRequest =
        new CartOperationRequest(new NullOrderImpl(), itemRequest, true);

    DefaultProcessContextImpl<CartOperationRequest> context = new DefaultProcessContextImpl<>();
    context.setSeedData(cartOperationRequest);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> validateAddRequestActivity.validate(context));
    verify(sandBoxHelper).getOriginalId(isA(Object.class));
    verify(sandBoxHelper).getProductionOriginalId(isA(Class.class), isNull());
    verify(catalogService).findProductById(1L);
    verify(catalogService).findSkuById(1L);
    verify(orderItemRequestValidationService)
        .satisfiesMinQuantityCondition(isA(OrderItemRequestDTO.class), isA(ProcessContext.class));
  }

  /**
   * Test {@link ValidateAddRequestActivity#validate(ProcessContext)}.
   *
   * <ul>
   *   <li>Then {@link DefaultProcessContextImpl} (default constructor) Stopped.
   * </ul>
   *
   * <p>Method under test: {@link ValidateAddRequestActivity#validate(ProcessContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ProcessContext ValidateAddRequestActivity.validate(ProcessContext)"})
  public void testValidate_thenDefaultProcessContextImplStopped() {
    // Arrange
    ValidateAddRequestActivity validateAddRequestActivity = new ValidateAddRequestActivity();

    DefaultProcessContextImpl<CartOperationRequest> context = new DefaultProcessContextImpl<>();
    NullOrderImpl order = new NullOrderImpl();
    CartOperationRequest cartOperationRequest =
        new CartOperationRequest(order, new OrderItemRequestDTO(), true);
    context.setSeedData(cartOperationRequest);

    // Act
    ProcessContext<CartOperationRequest> actualValidateResult =
        validateAddRequestActivity.validate(context);

    // Assert
    assertTrue(context.isStopped());
    assertSame(context, actualValidateResult);
  }

  /**
   * Test {@link ValidateAddRequestActivity#validate(ProcessContext)}.
   *
   * <ul>
   *   <li>Then return {@link DefaultProcessContextImpl}.
   * </ul>
   *
   * <p>Method under test: {@link ValidateAddRequestActivity#validate(ProcessContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ProcessContext ValidateAddRequestActivity.validate(ProcessContext)"})
  public void testValidate_thenReturnDefaultProcessContextImpl() {
    // Arrange
    when(catalogService.findSkuById(Mockito.<Long>any())).thenReturn(null);
    when(orderItemRequestValidationService.satisfiesMinQuantityCondition(
            Mockito.<OrderItemRequestDTO>any(),
            Mockito.<ProcessContext<CartOperationRequest>>any()))
        .thenReturn(true);

    NonDiscreteOrderItemRequestDTO itemRequest =
        new NonDiscreteOrderItemRequestDTO("Could not find SKU for : productId: ", 1, new Money());
    itemRequest.setSkuId(1L);
    itemRequest.setQuantity(1);
    CartOperationRequest cartOperationRequest =
        new CartOperationRequest(new NullOrderImpl(), itemRequest, true);

    DefaultProcessContextImpl<CartOperationRequest> context = new DefaultProcessContextImpl<>();
    context.setSeedData(cartOperationRequest);

    // Act
    ProcessContext<CartOperationRequest> actualValidateResult =
        validateAddRequestActivity.validate(context);

    // Assert
    verify(catalogService).findSkuById(1L);
    verify(orderItemRequestValidationService)
        .satisfiesMinQuantityCondition(isA(OrderItemRequestDTO.class), isA(ProcessContext.class));
    assertTrue(actualValidateResult instanceof DefaultProcessContextImpl);
    assertFalse(actualValidateResult.isStopped());
    assertSame(cartOperationRequest, actualValidateResult.getSeedData());
  }

  /**
   * Test {@link ValidateAddRequestActivity#validate(ProcessContext)}.
   *
   * <ul>
   *   <li>Then throw {@link MinQuantityNotFulfilledException}.
   * </ul>
   *
   * <p>Method under test: {@link ValidateAddRequestActivity#validate(ProcessContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ProcessContext ValidateAddRequestActivity.validate(ProcessContext)"})
  public void testValidate_thenThrowMinQuantityNotFulfilledException() {
    // Arrange
    when(orderItemRequestValidationService.satisfiesMinQuantityCondition(
            Mockito.<OrderItemRequestDTO>any(),
            Mockito.<ProcessContext<CartOperationRequest>>any()))
        .thenReturn(false);
    when(orderItemRequestValidationService.getMinQuantity(
            Mockito.<OrderItemRequestDTO>any(),
            Mockito.<ProcessContext<CartOperationRequest>>any()))
        .thenReturn(1);

    OrderItemRequestDTO itemRequest = new OrderItemRequestDTO(1L, 1);
    itemRequest.setSkuId(1L);
    itemRequest.setQuantity(1);
    CartOperationRequest cartOperationRequest =
        new CartOperationRequest(new NullOrderImpl(), itemRequest, true);

    DefaultProcessContextImpl<CartOperationRequest> context = new DefaultProcessContextImpl<>();
    context.setSeedData(cartOperationRequest);

    // Act and Assert
    assertThrows(
        MinQuantityNotFulfilledException.class, () -> validateAddRequestActivity.validate(context));
    verify(orderItemRequestValidationService)
        .getMinQuantity(isA(OrderItemRequestDTO.class), isA(ProcessContext.class));
    verify(orderItemRequestValidationService)
        .satisfiesMinQuantityCondition(isA(OrderItemRequestDTO.class), isA(ProcessContext.class));
  }

  /**
   * Test {@link ValidateAddRequestActivity#validate(ProcessContext)}.
   *
   * <ul>
   *   <li>Then throw {@link RequiredAttributeNotProvidedException}.
   * </ul>
   *
   * <p>Method under test: {@link ValidateAddRequestActivity#validate(ProcessContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ProcessContext ValidateAddRequestActivity.validate(ProcessContext)"})
  public void testValidate_thenThrowRequiredAttributeNotProvidedException() {
    // Arrange
    when(catalogService.findSkuById(Mockito.<Long>any()))
        .thenThrow(
            new RequiredAttributeNotProvidedException("Could not find SKU for : productId: "));
    when(orderItemRequestValidationService.satisfiesMinQuantityCondition(
            Mockito.<OrderItemRequestDTO>any(),
            Mockito.<ProcessContext<CartOperationRequest>>any()))
        .thenReturn(true);

    OrderItemRequestDTO itemRequest = new OrderItemRequestDTO();
    itemRequest.setSkuId(1L);
    itemRequest.setQuantity(1);
    CartOperationRequest cartOperationRequest =
        new CartOperationRequest(new NullOrderImpl(), itemRequest, true);

    DefaultProcessContextImpl<CartOperationRequest> context = new DefaultProcessContextImpl<>();
    context.setSeedData(cartOperationRequest);

    // Act and Assert
    assertThrows(
        RequiredAttributeNotProvidedException.class,
        () -> validateAddRequestActivity.validate(context));
    verify(catalogService).findSkuById(1L);
    verify(orderItemRequestValidationService)
        .satisfiesMinQuantityCondition(isA(OrderItemRequestDTO.class), isA(ProcessContext.class));
  }

  /**
   * Test {@link ValidateAddRequestActivity#validateIfProductIsProdRecord(Product)}.
   *
   * <p>Method under test: {@link ValidateAddRequestActivity#validateIfProductIsProdRecord(Product)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ValidateAddRequestActivity.validateIfProductIsProdRecord(Product)"})
  public void testValidateIfProductIsProdRecord() {
    // Arrange
    when(sandBoxHelper.getOriginalId(Mockito.<Object>any()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> validateAddRequestActivity.validateIfProductIsProdRecord(new ProductBundleImpl()));
    verify(sandBoxHelper).getOriginalId(isA(Object.class));
  }

  /**
   * Test {@link ValidateAddRequestActivity#validateIfProductIsProdRecord(Product)}.
   *
   * <ul>
   *   <li>Given {@link SandBoxHelper.OriginalIdResponse} (default constructor) OriginalId is one.
   * </ul>
   *
   * <p>Method under test: {@link ValidateAddRequestActivity#validateIfProductIsProdRecord(Product)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ValidateAddRequestActivity.validateIfProductIsProdRecord(Product)"})
  public void testValidateIfProductIsProdRecord_givenOriginalIdResponseOriginalIdIsOne() {
    // Arrange
    OriginalIdResponse originalIdResponse = new OriginalIdResponse();
    originalIdResponse.setOriginalId(1L);
    originalIdResponse.setRecordFound(true);
    when(sandBoxHelper.getOriginalId(Mockito.<Object>any())).thenReturn(1L);
    when(sandBoxHelper.getProductionOriginalId(Mockito.<Class<?>>any(), Mockito.<Long>any()))
        .thenReturn(originalIdResponse);

    // Act
    validateAddRequestActivity.validateIfProductIsProdRecord(new ProductBundleImpl());

    // Assert
    verify(sandBoxHelper).getOriginalId(isA(Object.class));
    verify(sandBoxHelper).getProductionOriginalId(isA(Class.class), isNull());
  }

  /**
   * Test {@link ValidateAddRequestActivity#validateIfProductIsProdRecord(Product)}.
   *
   * <ul>
   *   <li>Given {@link SandBoxHelper.OriginalIdResponse} (default constructor) OriginalId is two.
   * </ul>
   *
   * <p>Method under test: {@link ValidateAddRequestActivity#validateIfProductIsProdRecord(Product)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ValidateAddRequestActivity.validateIfProductIsProdRecord(Product)"})
  public void testValidateIfProductIsProdRecord_givenOriginalIdResponseOriginalIdIsTwo() {
    // Arrange
    OriginalIdResponse originalIdResponse = new OriginalIdResponse();
    originalIdResponse.setOriginalId(2L);
    originalIdResponse.setRecordFound(true);
    when(sandBoxHelper.getOriginalId(Mockito.<Object>any())).thenReturn(1L);
    when(sandBoxHelper.getProductionOriginalId(Mockito.<Class<?>>any(), Mockito.<Long>any()))
        .thenReturn(originalIdResponse);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> validateAddRequestActivity.validateIfProductIsProdRecord(new ProductBundleImpl()));
    verify(sandBoxHelper).getOriginalId(isA(Object.class));
    verify(sandBoxHelper).getProductionOriginalId(isA(Class.class), isNull());
  }

  /**
   * Test {@link ValidateAddRequestActivity#validateIfProductIsProdRecord(Product)}.
   *
   * <ul>
   *   <li>Given {@link SandBoxHelper} {@link SandBoxHelper#getOriginalId(Object)} return {@code
   *       null}.
   * </ul>
   *
   * <p>Method under test: {@link ValidateAddRequestActivity#validateIfProductIsProdRecord(Product)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ValidateAddRequestActivity.validateIfProductIsProdRecord(Product)"})
  public void testValidateIfProductIsProdRecord_givenSandBoxHelperGetOriginalIdReturnNull() {
    // Arrange
    when(sandBoxHelper.getOriginalId(Mockito.<Object>any())).thenReturn(null);

    // Act
    validateAddRequestActivity.validateIfProductIsProdRecord(mock(ProductBundleImpl.class));

    // Assert
    verify(sandBoxHelper).getOriginalId(isA(Object.class));
  }

  /**
   * Test {@link ValidateAddRequestActivity#validateIfProductIsProdRecord(Product)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link ValidateAddRequestActivity#validateIfProductIsProdRecord(Product)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ValidateAddRequestActivity.validateIfProductIsProdRecord(Product)"})
  public void testValidateIfProductIsProdRecord_whenNull_thenDoesNotThrow() {
    // Arrange, Act and Assert
    validateAddRequestActivity.validateIfProductIsProdRecord(null);
  }

  /**
   * Test {@link ValidateAddRequestActivity#hasQuantity(Integer)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ValidateAddRequestActivity#hasQuantity(Integer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ValidateAddRequestActivity.hasQuantity(Integer)"})
  public void testHasQuantity_whenNull_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new ValidateAddRequestActivity().hasQuantity(null));
  }

  /**
   * Test {@link ValidateAddRequestActivity#hasQuantity(Integer)}.
   *
   * <ul>
   *   <li>When two.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ValidateAddRequestActivity#hasQuantity(Integer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ValidateAddRequestActivity.hasQuantity(Integer)"})
  public void testHasQuantity_whenTwo_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(new ValidateAddRequestActivity().hasQuantity(2));
  }

  /**
   * Test {@link ValidateAddRequestActivity#hasQuantity(Integer)}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ValidateAddRequestActivity#hasQuantity(Integer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ValidateAddRequestActivity.hasQuantity(Integer)"})
  public void testHasQuantity_whenZero_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new ValidateAddRequestActivity().hasQuantity(0));
  }

  /**
   * Test {@link ValidateAddRequestActivity#determineProduct(OrderItemRequestDTO)}.
   *
   * <p>Method under test: {@link ValidateAddRequestActivity#determineProduct(OrderItemRequestDTO)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Product ValidateAddRequestActivity.determineProduct(OrderItemRequestDTO)"})
  public void testDetermineProduct() {
    // Arrange
    when(catalogService.findProductById(Mockito.<Long>any()))
        .thenThrow(new IllegalArgumentException());

    NonDiscreteOrderItemRequestDTO orderItemRequestDTO =
        new NonDiscreteOrderItemRequestDTO("Item Name", 1, new Money());
    orderItemRequestDTO.setProductId(1L);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> validateAddRequestActivity.determineProduct(orderItemRequestDTO));
    verify(catalogService).findProductById(1L);
  }

  /**
   * Test {@link ValidateAddRequestActivity#determineProduct(OrderItemRequestDTO)}.
   *
   * <ul>
   *   <li>Given {@link CatalogService} {@link CatalogService#findProductById(Long)} return {@code
   *       null}.
   * </ul>
   *
   * <p>Method under test: {@link ValidateAddRequestActivity#determineProduct(OrderItemRequestDTO)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Product ValidateAddRequestActivity.determineProduct(OrderItemRequestDTO)"})
  public void testDetermineProduct_givenCatalogServiceFindProductByIdReturnNull() {
    // Arrange
    when(catalogService.findProductById(Mockito.<Long>any())).thenReturn(null);

    NonDiscreteOrderItemRequestDTO orderItemRequestDTO =
        new NonDiscreteOrderItemRequestDTO("Item Name", 1, new Money());
    orderItemRequestDTO.setProductId(1L);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> validateAddRequestActivity.determineProduct(orderItemRequestDTO));
    verify(catalogService).findProductById(1L);
  }

  /**
   * Test {@link ValidateAddRequestActivity#determineProduct(OrderItemRequestDTO)}.
   *
   * <ul>
   *   <li>Given {@link ValidateAddRequestActivity} (default constructor).
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ValidateAddRequestActivity#determineProduct(OrderItemRequestDTO)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Product ValidateAddRequestActivity.determineProduct(OrderItemRequestDTO)"})
  public void testDetermineProduct_givenValidateAddRequestActivity_thenReturnNull() {
    // Arrange
    ValidateAddRequestActivity validateAddRequestActivity = new ValidateAddRequestActivity();

    // Act and Assert
    assertNull(validateAddRequestActivity.determineProduct(new OrderItemRequestDTO()));
  }

  /**
   * Test {@link ValidateAddRequestActivity#determineProduct(OrderItemRequestDTO)}.
   *
   * <ul>
   *   <li>Then return {@link ProductBundleImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link ValidateAddRequestActivity#determineProduct(OrderItemRequestDTO)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Product ValidateAddRequestActivity.determineProduct(OrderItemRequestDTO)"})
  public void testDetermineProduct_thenReturnProductBundleImpl() {
    // Arrange
    ProductBundleImpl productBundleImpl = new ProductBundleImpl();
    when(catalogService.findProductById(Mockito.<Long>any())).thenReturn(productBundleImpl);

    NonDiscreteOrderItemRequestDTO orderItemRequestDTO =
        new NonDiscreteOrderItemRequestDTO("Item Name", 1, new Money());
    orderItemRequestDTO.setProductId(1L);

    // Act
    Product actualDetermineProductResult =
        validateAddRequestActivity.determineProduct(orderItemRequestDTO);

    // Assert
    verify(catalogService).findProductById(1L);
    assertSame(productBundleImpl, actualDetermineProductResult);
  }

  /**
   * Test {@link ValidateAddRequestActivity#determineSku(Product, Long, Map, ActivityMessages)}.
   *
   * <ul>
   *   <li>Given {@link CatalogService} {@link CatalogService#findSkuById(Long)} return {@link
   *       SkuImpl} (default constructor).
   *   <li>Then return {@link SkuImpl}.
   * </ul>
   *
   * <p>Method under test: {@link ValidateAddRequestActivity#determineSku(Product, Long, Map,
   * ActivityMessages)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Sku ValidateAddRequestActivity.determineSku(Product, Long, Map, ActivityMessages)"
  })
  public void testDetermineSku_givenCatalogServiceFindSkuByIdReturnSkuImpl_thenReturnSkuImpl()
      throws RequiredAttributeNotProvidedException {
    // Arrange
    when(catalogService.findSkuById(Mockito.<Long>any())).thenReturn(new SkuImpl());
    ProductBundleImpl product = new ProductBundleImpl();
    HashMap<String, String> attributeValues = new HashMap<>();

    // Act
    Sku actualDetermineSkuResult =
        validateAddRequestActivity.determineSku(
            product, 1L, attributeValues, new DefaultProcessContextImpl<>());

    // Assert
    verify(catalogService).findSkuById(1L);
    assertTrue(actualDetermineSkuResult instanceof SkuImpl);
    Money margin = actualDetermineSkuResult.getMargin();
    Money actualAbsResult = margin.abs();
    assertEquals(margin, actualAbsResult);
    Money actualZeroResult = margin.zero();
    assertEquals(margin, actualZeroResult);
  }

  /**
   * Test {@link ValidateAddRequestActivity#determineSku(Product, Long, Map, ActivityMessages)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link ValidateAddRequestActivity#determineSku(Product, Long, Map,
   * ActivityMessages)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Sku ValidateAddRequestActivity.determineSku(Product, Long, Map, ActivityMessages)"
  })
  public void testDetermineSku_thenThrowIllegalArgumentException()
      throws RequiredAttributeNotProvidedException {
    // Arrange
    when(catalogService.findSkuById(Mockito.<Long>any())).thenThrow(new IllegalArgumentException());
    ProductBundleImpl product = new ProductBundleImpl();
    HashMap<String, String> attributeValues = new HashMap<>();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            validateAddRequestActivity.determineSku(
                product, 1L, attributeValues, new DefaultProcessContextImpl<>()));
    verify(catalogService).findSkuById(1L);
  }

  /**
   * Test {@link ValidateAddRequestActivity#determineSku(Product, Long, Map, ActivityMessages)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@link SkuImpl}.
   * </ul>
   *
   * <p>Method under test: {@link ValidateAddRequestActivity#determineSku(Product, Long, Map,
   * ActivityMessages)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Sku ValidateAddRequestActivity.determineSku(Product, Long, Map, ActivityMessages)"
  })
  public void testDetermineSku_whenNull_thenReturnSkuImpl()
      throws RequiredAttributeNotProvidedException {
    // Arrange
    when(catalogService.findSkuById(Mockito.<Long>any())).thenReturn(new SkuImpl());
    HashMap<String, String> attributeValues = new HashMap<>();

    // Act
    Sku actualDetermineSkuResult =
        validateAddRequestActivity.determineSku(
            null, 1L, attributeValues, new DefaultProcessContextImpl<>());

    // Assert
    verify(catalogService).findSkuById(1L);
    assertTrue(actualDetermineSkuResult instanceof SkuImpl);
    Money margin = actualDetermineSkuResult.getMargin();
    Money actualAbsResult = margin.abs();
    assertEquals(margin, actualAbsResult);
    Money actualZeroResult = margin.zero();
    assertEquals(margin, actualZeroResult);
  }

  /**
   * Test {@link ValidateAddRequestActivity#canSellDefaultSku(Product)}.
   *
   * <ul>
   *   <li>Given {@link ValidateAddRequestActivity} (default constructor).
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ValidateAddRequestActivity#canSellDefaultSku(Product)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ValidateAddRequestActivity.canSellDefaultSku(Product)"})
  public void testCanSellDefaultSku_givenValidateAddRequestActivity_thenReturnTrue() {
    // Arrange
    ValidateAddRequestActivity validateAddRequestActivity = new ValidateAddRequestActivity();

    // Act and Assert
    assertTrue(validateAddRequestActivity.canSellDefaultSku(new ProductBundleImpl()));
  }

  /**
   * Test {@link ValidateAddRequestActivity#findMatchingSku(Product, Map)} with {@code product},
   * {@code attributeValuesForSku}.
   *
   * <p>Method under test: {@link ValidateAddRequestActivity#findMatchingSku(Product, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Sku ValidateAddRequestActivity.findMatchingSku(Product, Map)"})
  public void testFindMatchingSkuWithProductAttributeValuesForSku() {
    // Arrange
    ValidateAddRequestActivity validateAddRequestActivity = new ValidateAddRequestActivity();
    ProductBundleImpl product = new ProductBundleImpl();

    // Act and Assert
    assertNull(validateAddRequestActivity.findMatchingSku(product, new HashMap<>()));
  }

  /**
   * Test {@link ValidateAddRequestActivity#findMatchingSku(Product, Map)} with {@code product},
   * {@code attributeValuesForSku}.
   *
   * <p>Method under test: {@link ValidateAddRequestActivity#findMatchingSku(Product, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Sku ValidateAddRequestActivity.findMatchingSku(Product, Map)"})
  public void testFindMatchingSkuWithProductAttributeValuesForSku2() {
    // Arrange
    when(productOptionValidationService.findSkuIdsForProductOptionValues(
            Mockito.<Long>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<List<Long>>any()))
        .thenThrow(new IllegalArgumentException());
    ProductBundleImpl product = new ProductBundleImpl();

    HashMap<String, String> attributeValuesForSku = new HashMap<>();
    attributeValuesForSku.put("foo", "foo");

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> validateAddRequestActivity.findMatchingSku(product, attributeValuesForSku));
    verify(productOptionValidationService)
        .findSkuIdsForProductOptionValues(isNull(), eq("foo"), eq("foo"), isA(List.class));
  }

  /**
   * Test {@link ValidateAddRequestActivity#findMatchingSku(Product, Map)} with {@code product},
   * {@code attributeValuesForSku}.
   *
   * <p>Method under test: {@link ValidateAddRequestActivity#findMatchingSku(Product, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Sku ValidateAddRequestActivity.findMatchingSku(Product, Map)"})
  public void testFindMatchingSkuWithProductAttributeValuesForSku3() {
    // Arrange
    when(catalogService.findSkuById(Mockito.<Long>any())).thenThrow(new IllegalArgumentException());

    ArrayList<Long> resultLongList = new ArrayList<>();
    resultLongList.add(1L);
    when(productOptionValidationService.findSkuIdsForProductOptionValues(
            Mockito.<Long>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<List<Long>>any()))
        .thenReturn(resultLongList);
    ProductBundleImpl product = new ProductBundleImpl();

    HashMap<String, String> attributeValuesForSku = new HashMap<>();
    attributeValuesForSku.put("foo", "foo");

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> validateAddRequestActivity.findMatchingSku(product, attributeValuesForSku));
    verify(catalogService).findSkuById(1L);
    verify(productOptionValidationService)
        .findSkuIdsForProductOptionValues(isNull(), eq("foo"), eq("foo"), isA(List.class));
  }

  /**
   * Test {@link ValidateAddRequestActivity#findMatchingSku(Product, Map)} with {@code product},
   * {@code attributeValuesForSku}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ValidateAddRequestActivity#findMatchingSku(Product, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Sku ValidateAddRequestActivity.findMatchingSku(Product, Map)"})
  public void testFindMatchingSkuWithProductAttributeValuesForSku_thenReturnNull() {
    // Arrange
    when(productOptionValidationService.findSkuIdsForProductOptionValues(
            Mockito.<Long>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<List<Long>>any()))
        .thenReturn(new ArrayList<>());
    ProductBundleImpl product = new ProductBundleImpl();

    HashMap<String, String> attributeValuesForSku = new HashMap<>();
    attributeValuesForSku.put("foo", "foo");

    // Act
    Sku actualFindMatchingSkuResult =
        validateAddRequestActivity.findMatchingSku(product, attributeValuesForSku);

    // Assert
    verify(productOptionValidationService)
        .findSkuIdsForProductOptionValues(isNull(), eq("foo"), eq("foo"), isA(List.class));
    assertNull(actualFindMatchingSkuResult);
  }

  /**
   * Test {@link ValidateAddRequestActivity#findMatchingSku(Product, Map)} with {@code product},
   * {@code attributeValuesForSku}.
   *
   * <ul>
   *   <li>Then return {@link SkuImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link ValidateAddRequestActivity#findMatchingSku(Product, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Sku ValidateAddRequestActivity.findMatchingSku(Product, Map)"})
  public void testFindMatchingSkuWithProductAttributeValuesForSku_thenReturnSkuImpl() {
    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    when(catalogService.findSkuById(Mockito.<Long>any())).thenReturn(skuImpl);

    ArrayList<Long> resultLongList = new ArrayList<>();
    resultLongList.add(1L);
    when(productOptionValidationService.findSkuIdsForProductOptionValues(
            Mockito.<Long>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<List<Long>>any()))
        .thenReturn(resultLongList);
    ProductBundleImpl product = new ProductBundleImpl();

    HashMap<String, String> attributeValuesForSku = new HashMap<>();
    attributeValuesForSku.put("foo", "foo");

    // Act
    Sku actualFindMatchingSkuResult =
        validateAddRequestActivity.findMatchingSku(product, attributeValuesForSku);

    // Assert
    verify(catalogService).findSkuById(1L);
    verify(productOptionValidationService)
        .findSkuIdsForProductOptionValues(isNull(), eq("foo"), eq("foo"), isA(List.class));
    assertSame(skuImpl, actualFindMatchingSkuResult);
  }

  /**
   * Test {@link ValidateAddRequestActivity#findMatchingSku(Product, Map, ActivityMessages)} with
   * {@code product}, {@code attributeValues}, {@code messages}.
   *
   * <p>Method under test: {@link ValidateAddRequestActivity#findMatchingSku(Product, Map,
   * ActivityMessages)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Sku ValidateAddRequestActivity.findMatchingSku(Product, Map, ActivityMessages)"
  })
  public void testFindMatchingSkuWithProductAttributeValuesMessages()
      throws RequiredAttributeNotProvidedException {
    // Arrange
    when(productOptionValidationService.hasProductOptionValidationStrategy(
            Mockito.<ProductOption>any()))
        .thenThrow(new IllegalArgumentException());

    ProductOptionImpl productOptionImpl = mock(ProductOptionImpl.class);
    when(productOptionImpl.getRequired()).thenReturn(true);
    when(productOptionImpl.getAttributeName()).thenReturn("Attribute Name");

    ProductOptionXrefImpl productOptionXrefImpl = mock(ProductOptionXrefImpl.class);
    when(productOptionXrefImpl.getProductOption()).thenReturn(productOptionImpl);

    ArrayList<ProductOptionXref> productOptions = new ArrayList<>();
    productOptions.add(productOptionXrefImpl);

    ProductBundleImpl product = new ProductBundleImpl();
    product.setProductOptionXrefs(productOptions);
    HashMap<String, String> attributeValues = new HashMap<>();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            validateAddRequestActivity.findMatchingSku(
                product, attributeValues, new DefaultProcessContextImpl<>()));
    verify(productOptionImpl).getAttributeName();
    verify(productOptionImpl).getRequired();
    verify(productOptionXrefImpl).getProductOption();
    verify(productOptionValidationService)
        .hasProductOptionValidationStrategy(isA(ProductOption.class));
  }

  /**
   * Test {@link ValidateAddRequestActivity#findMatchingSku(Product, Map, ActivityMessages)} with
   * {@code product}, {@code attributeValues}, {@code messages}.
   *
   * <p>Method under test: {@link ValidateAddRequestActivity#findMatchingSku(Product, Map,
   * ActivityMessages)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Sku ValidateAddRequestActivity.findMatchingSku(Product, Map, ActivityMessages)"
  })
  public void testFindMatchingSkuWithProductAttributeValuesMessages2()
      throws RequiredAttributeNotProvidedException {
    // Arrange
    when(catalogService.findSkuById(Mockito.<Long>any())).thenThrow(new IllegalArgumentException());

    ArrayList<Long> resultLongList = new ArrayList<>();
    resultLongList.add(1L);
    when(productOptionValidationService.hasProductOptionValidationStrategy(
            Mockito.<ProductOption>any()))
        .thenReturn(true);
    when(productOptionValidationService.isAddOrNoneType(Mockito.<ProductOption>any()))
        .thenReturn(true);
    when(productOptionValidationService.validate(
            Mockito.<ProductOption>any(), Mockito.<String>any()))
        .thenReturn(true);
    when(productOptionValidationService.findSkuIdsForProductOptionValues(
            Mockito.<Long>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<List<Long>>any()))
        .thenReturn(resultLongList);

    ProductOptionImpl productOptionImpl = mock(ProductOptionImpl.class);
    when(productOptionImpl.getRequired()).thenReturn(true);
    when(productOptionImpl.getUseInSkuGeneration()).thenReturn(true);
    when(productOptionImpl.getAttributeName()).thenReturn("Attribute Name");

    ProductOptionXrefImpl productOptionXrefImpl = mock(ProductOptionXrefImpl.class);
    when(productOptionXrefImpl.getProductOption()).thenReturn(productOptionImpl);

    ArrayList<ProductOptionXref> productOptions = new ArrayList<>();
    productOptions.add(productOptionXrefImpl);

    ProductBundleImpl product = new ProductBundleImpl();
    product.setProductOptionXrefs(productOptions);
    HashMap<String, String> attributeValues = new HashMap<>();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            validateAddRequestActivity.findMatchingSku(
                product, attributeValues, new DefaultProcessContextImpl<>()));
    verify(productOptionImpl).getAttributeName();
    verify(productOptionImpl).getRequired();
    verify(productOptionImpl).getUseInSkuGeneration();
    verify(productOptionXrefImpl).getProductOption();
    verify(catalogService).findSkuById(1L);
    verify(productOptionValidationService)
        .findSkuIdsForProductOptionValues(
            isNull(), eq("Attribute Name"), isNull(), isA(List.class));
    verify(productOptionValidationService)
        .hasProductOptionValidationStrategy(isA(ProductOption.class));
    verify(productOptionValidationService).isAddOrNoneType(isA(ProductOption.class));
    verify(productOptionValidationService).validate(isA(ProductOption.class), isNull());
  }

  /**
   * Test {@link ValidateAddRequestActivity#findMatchingSku(Product, Map, ActivityMessages)} with
   * {@code product}, {@code attributeValues}, {@code messages}.
   *
   * <p>Method under test: {@link ValidateAddRequestActivity#findMatchingSku(Product, Map,
   * ActivityMessages)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Sku ValidateAddRequestActivity.findMatchingSku(Product, Map, ActivityMessages)"
  })
  public void testFindMatchingSkuWithProductAttributeValuesMessages3()
      throws RequiredAttributeNotProvidedException {
    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    when(catalogService.findSkuById(Mockito.<Long>any())).thenReturn(skuImpl);

    ArrayList<Long> resultLongList = new ArrayList<>();
    resultLongList.add(1L);
    when(productOptionValidationService.hasProductOptionValidationStrategy(
            Mockito.<ProductOption>any()))
        .thenReturn(false);
    when(productOptionValidationService.isAddOrNoneType(Mockito.<ProductOption>any()))
        .thenReturn(true);
    when(productOptionValidationService.validate(
            Mockito.<ProductOption>any(), Mockito.<String>any()))
        .thenReturn(true);
    when(productOptionValidationService.findSkuIdsForProductOptionValues(
            Mockito.<Long>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<List<Long>>any()))
        .thenReturn(resultLongList);

    ProductOptionImpl productOptionImpl = mock(ProductOptionImpl.class);
    when(productOptionImpl.getRequired()).thenReturn(true);
    when(productOptionImpl.getUseInSkuGeneration()).thenReturn(true);
    when(productOptionImpl.getAttributeName()).thenReturn("Attribute Name");

    ProductOptionXrefImpl productOptionXrefImpl = mock(ProductOptionXrefImpl.class);
    when(productOptionXrefImpl.getProductOption()).thenReturn(productOptionImpl);

    ArrayList<ProductOptionXref> productOptions = new ArrayList<>();
    productOptions.add(productOptionXrefImpl);

    ProductBundleImpl product = new ProductBundleImpl();
    product.setProductOptionXrefs(productOptions);
    HashMap<String, String> attributeValues = new HashMap<>();

    // Act
    Sku actualFindMatchingSkuResult =
        validateAddRequestActivity.findMatchingSku(
            product, attributeValues, new DefaultProcessContextImpl<>());

    // Assert
    verify(productOptionImpl).getAttributeName();
    verify(productOptionImpl).getRequired();
    verify(productOptionImpl).getUseInSkuGeneration();
    verify(productOptionXrefImpl).getProductOption();
    verify(catalogService).findSkuById(1L);
    verify(productOptionValidationService)
        .findSkuIdsForProductOptionValues(
            isNull(), eq("Attribute Name"), isNull(), isA(List.class));
    verify(productOptionValidationService)
        .hasProductOptionValidationStrategy(isA(ProductOption.class));
    verify(productOptionValidationService).isAddOrNoneType(isA(ProductOption.class));
    verify(productOptionValidationService).validate(isA(ProductOption.class), isNull());
    assertSame(skuImpl, actualFindMatchingSkuResult);
  }

  /**
   * Test {@link ValidateAddRequestActivity#findMatchingSku(Product, Map, ActivityMessages)} with
   * {@code product}, {@code attributeValues}, {@code messages}.
   *
   * <p>Method under test: {@link ValidateAddRequestActivity#findMatchingSku(Product, Map,
   * ActivityMessages)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Sku ValidateAddRequestActivity.findMatchingSku(Product, Map, ActivityMessages)"
  })
  public void testFindMatchingSkuWithProductAttributeValuesMessages4()
      throws RequiredAttributeNotProvidedException {
    // Arrange
    doThrow(new IllegalArgumentException())
        .when(productOptionValidationService)
        .validateWithoutException(
            Mockito.<ProductOption>any(), Mockito.<String>any(), Mockito.<ActivityMessages>any());
    when(productOptionValidationService.hasProductOptionValidationStrategy(
            Mockito.<ProductOption>any()))
        .thenReturn(true);
    when(productOptionValidationService.isAddOrNoneType(Mockito.<ProductOption>any()))
        .thenReturn(false);

    ProductOptionImpl productOptionImpl = mock(ProductOptionImpl.class);
    when(productOptionImpl.getRequired()).thenReturn(true);
    when(productOptionImpl.getAttributeName()).thenReturn("Attribute Name");

    ProductOptionXrefImpl productOptionXrefImpl = mock(ProductOptionXrefImpl.class);
    when(productOptionXrefImpl.getProductOption()).thenReturn(productOptionImpl);

    ArrayList<ProductOptionXref> productOptions = new ArrayList<>();
    productOptions.add(productOptionXrefImpl);

    ProductBundleImpl product = new ProductBundleImpl();
    product.setProductOptionXrefs(productOptions);
    HashMap<String, String> attributeValues = new HashMap<>();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            validateAddRequestActivity.findMatchingSku(
                product, attributeValues, new DefaultProcessContextImpl<>()));
    verify(productOptionImpl).getAttributeName();
    verify(productOptionImpl).getRequired();
    verify(productOptionXrefImpl).getProductOption();
    verify(productOptionValidationService)
        .hasProductOptionValidationStrategy(isA(ProductOption.class));
    verify(productOptionValidationService).isAddOrNoneType(isA(ProductOption.class));
    verify(productOptionValidationService)
        .validateWithoutException(isA(ProductOption.class), isNull(), isA(ActivityMessages.class));
  }

  /**
   * Test {@link ValidateAddRequestActivity#findMatchingSku(Product, Map, ActivityMessages)} with
   * {@code product}, {@code attributeValues}, {@code messages}.
   *
   * <p>Method under test: {@link ValidateAddRequestActivity#findMatchingSku(Product, Map,
   * ActivityMessages)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Sku ValidateAddRequestActivity.findMatchingSku(Product, Map, ActivityMessages)"
  })
  public void testFindMatchingSkuWithProductAttributeValuesMessages5()
      throws RequiredAttributeNotProvidedException {
    // Arrange
    doNothing()
        .when(productOptionValidationService)
        .validateWithoutException(
            Mockito.<ProductOption>any(), Mockito.<String>any(), Mockito.<ActivityMessages>any());
    when(productOptionValidationService.hasProductOptionValidationStrategy(
            Mockito.<ProductOption>any()))
        .thenReturn(true);
    when(productOptionValidationService.isAddOrNoneType(Mockito.<ProductOption>any()))
        .thenReturn(false);

    ProductOptionImpl productOptionImpl = mock(ProductOptionImpl.class);
    when(productOptionImpl.getRequired()).thenReturn(true);
    when(productOptionImpl.getUseInSkuGeneration()).thenReturn(false);
    when(productOptionImpl.getAttributeName()).thenReturn("Attribute Name");

    ProductOptionXrefImpl productOptionXrefImpl = mock(ProductOptionXrefImpl.class);
    when(productOptionXrefImpl.getProductOption()).thenReturn(productOptionImpl);

    ArrayList<ProductOptionXref> productOptions = new ArrayList<>();
    productOptions.add(productOptionXrefImpl);

    ProductBundleImpl product = new ProductBundleImpl();
    product.setProductOptionXrefs(productOptions);
    HashMap<String, String> attributeValues = new HashMap<>();

    // Act
    Sku actualFindMatchingSkuResult =
        validateAddRequestActivity.findMatchingSku(
            product, attributeValues, new DefaultProcessContextImpl<>());

    // Assert
    verify(productOptionImpl).getAttributeName();
    verify(productOptionImpl).getRequired();
    verify(productOptionImpl).getUseInSkuGeneration();
    verify(productOptionXrefImpl).getProductOption();
    verify(productOptionValidationService)
        .hasProductOptionValidationStrategy(isA(ProductOption.class));
    verify(productOptionValidationService).isAddOrNoneType(isA(ProductOption.class));
    verify(productOptionValidationService)
        .validateWithoutException(isA(ProductOption.class), isNull(), isA(ActivityMessages.class));
    assertNull(actualFindMatchingSkuResult);
  }

  /**
   * Test {@link ValidateAddRequestActivity#findMatchingSku(Product, Map, ActivityMessages)} with
   * {@code product}, {@code attributeValues}, {@code messages}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ValidateAddRequestActivity#findMatchingSku(Product, Map,
   * ActivityMessages)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Sku ValidateAddRequestActivity.findMatchingSku(Product, Map, ActivityMessages)"
  })
  public void testFindMatchingSkuWithProductAttributeValuesMessages_thenReturnNull()
      throws RequiredAttributeNotProvidedException {
    // Arrange
    when(productOptionValidationService.hasProductOptionValidationStrategy(
            Mockito.<ProductOption>any()))
        .thenReturn(true);
    when(productOptionValidationService.isAddOrNoneType(Mockito.<ProductOption>any()))
        .thenReturn(true);
    when(productOptionValidationService.validate(
            Mockito.<ProductOption>any(), Mockito.<String>any()))
        .thenReturn(true);
    when(productOptionValidationService.findSkuIdsForProductOptionValues(
            Mockito.<Long>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<List<Long>>any()))
        .thenReturn(new ArrayList<>());

    ProductOptionImpl productOptionImpl = mock(ProductOptionImpl.class);
    when(productOptionImpl.getRequired()).thenReturn(true);
    when(productOptionImpl.getUseInSkuGeneration()).thenReturn(true);
    when(productOptionImpl.getAttributeName()).thenReturn("Attribute Name");

    ProductOptionXrefImpl productOptionXrefImpl = mock(ProductOptionXrefImpl.class);
    when(productOptionXrefImpl.getProductOption()).thenReturn(productOptionImpl);

    ArrayList<ProductOptionXref> productOptions = new ArrayList<>();
    productOptions.add(productOptionXrefImpl);

    ProductBundleImpl product = new ProductBundleImpl();
    product.setProductOptionXrefs(productOptions);
    HashMap<String, String> attributeValues = new HashMap<>();

    // Act
    Sku actualFindMatchingSkuResult =
        validateAddRequestActivity.findMatchingSku(
            product, attributeValues, new DefaultProcessContextImpl<>());

    // Assert
    verify(productOptionImpl).getAttributeName();
    verify(productOptionImpl).getRequired();
    verify(productOptionImpl).getUseInSkuGeneration();
    verify(productOptionXrefImpl).getProductOption();
    verify(productOptionValidationService)
        .findSkuIdsForProductOptionValues(
            isNull(), eq("Attribute Name"), isNull(), isA(List.class));
    verify(productOptionValidationService)
        .hasProductOptionValidationStrategy(isA(ProductOption.class));
    verify(productOptionValidationService).isAddOrNoneType(isA(ProductOption.class));
    verify(productOptionValidationService).validate(isA(ProductOption.class), isNull());
    assertNull(actualFindMatchingSkuResult);
  }

  /**
   * Test {@link ValidateAddRequestActivity#findMatchingSku(Product, Map, ActivityMessages)} with
   * {@code product}, {@code attributeValues}, {@code messages}.
   *
   * <ul>
   *   <li>Then return {@link SkuImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link ValidateAddRequestActivity#findMatchingSku(Product, Map,
   * ActivityMessages)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Sku ValidateAddRequestActivity.findMatchingSku(Product, Map, ActivityMessages)"
  })
  public void testFindMatchingSkuWithProductAttributeValuesMessages_thenReturnSkuImpl()
      throws RequiredAttributeNotProvidedException {
    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    when(catalogService.findSkuById(Mockito.<Long>any())).thenReturn(skuImpl);

    ArrayList<Long> resultLongList = new ArrayList<>();
    resultLongList.add(1L);
    when(productOptionValidationService.hasProductOptionValidationStrategy(
            Mockito.<ProductOption>any()))
        .thenReturn(true);
    when(productOptionValidationService.isAddOrNoneType(Mockito.<ProductOption>any()))
        .thenReturn(true);
    when(productOptionValidationService.validate(
            Mockito.<ProductOption>any(), Mockito.<String>any()))
        .thenReturn(true);
    when(productOptionValidationService.findSkuIdsForProductOptionValues(
            Mockito.<Long>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<List<Long>>any()))
        .thenReturn(resultLongList);

    ProductOptionImpl productOptionImpl = mock(ProductOptionImpl.class);
    when(productOptionImpl.getRequired()).thenReturn(true);
    when(productOptionImpl.getUseInSkuGeneration()).thenReturn(true);
    when(productOptionImpl.getAttributeName()).thenReturn("Attribute Name");

    ProductOptionXrefImpl productOptionXrefImpl = mock(ProductOptionXrefImpl.class);
    when(productOptionXrefImpl.getProductOption()).thenReturn(productOptionImpl);

    ArrayList<ProductOptionXref> productOptions = new ArrayList<>();
    productOptions.add(productOptionXrefImpl);

    ProductBundleImpl product = new ProductBundleImpl();
    product.setProductOptionXrefs(productOptions);
    HashMap<String, String> attributeValues = new HashMap<>();

    // Act
    Sku actualFindMatchingSkuResult =
        validateAddRequestActivity.findMatchingSku(
            product, attributeValues, new DefaultProcessContextImpl<>());

    // Assert
    verify(productOptionImpl).getAttributeName();
    verify(productOptionImpl).getRequired();
    verify(productOptionImpl).getUseInSkuGeneration();
    verify(productOptionXrefImpl).getProductOption();
    verify(catalogService).findSkuById(1L);
    verify(productOptionValidationService)
        .findSkuIdsForProductOptionValues(
            isNull(), eq("Attribute Name"), isNull(), isA(List.class));
    verify(productOptionValidationService)
        .hasProductOptionValidationStrategy(isA(ProductOption.class));
    verify(productOptionValidationService).isAddOrNoneType(isA(ProductOption.class));
    verify(productOptionValidationService).validate(isA(ProductOption.class), isNull());
    assertSame(skuImpl, actualFindMatchingSkuResult);
  }

  /**
   * Test {@link ValidateAddRequestActivity#findMatchingSku(Product, Map, ActivityMessages)} with
   * {@code product}, {@code attributeValues}, {@code messages}.
   *
   * <ul>
   *   <li>Then return {@link SkuImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link ValidateAddRequestActivity#findMatchingSku(Product, Map,
   * ActivityMessages)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Sku ValidateAddRequestActivity.findMatchingSku(Product, Map, ActivityMessages)"
  })
  public void testFindMatchingSkuWithProductAttributeValuesMessages_thenReturnSkuImpl2()
      throws RequiredAttributeNotProvidedException {
    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    when(catalogService.findSkuById(Mockito.<Long>any())).thenReturn(skuImpl);

    ArrayList<Long> resultLongList = new ArrayList<>();
    resultLongList.add(1L);
    doNothing()
        .when(productOptionValidationService)
        .validateWithoutException(
            Mockito.<ProductOption>any(), Mockito.<String>any(), Mockito.<ActivityMessages>any());
    when(productOptionValidationService.hasProductOptionValidationStrategy(
            Mockito.<ProductOption>any()))
        .thenReturn(true);
    when(productOptionValidationService.isAddOrNoneType(Mockito.<ProductOption>any()))
        .thenReturn(false);
    when(productOptionValidationService.findSkuIdsForProductOptionValues(
            Mockito.<Long>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<List<Long>>any()))
        .thenReturn(resultLongList);

    ProductOptionImpl productOptionImpl = mock(ProductOptionImpl.class);
    when(productOptionImpl.getRequired()).thenReturn(true);
    when(productOptionImpl.getUseInSkuGeneration()).thenReturn(true);
    when(productOptionImpl.getAttributeName()).thenReturn("Attribute Name");

    ProductOptionXrefImpl productOptionXrefImpl = mock(ProductOptionXrefImpl.class);
    when(productOptionXrefImpl.getProductOption()).thenReturn(productOptionImpl);

    ArrayList<ProductOptionXref> productOptions = new ArrayList<>();
    productOptions.add(productOptionXrefImpl);

    ProductBundleImpl product = new ProductBundleImpl();
    product.setProductOptionXrefs(productOptions);
    HashMap<String, String> attributeValues = new HashMap<>();

    // Act
    Sku actualFindMatchingSkuResult =
        validateAddRequestActivity.findMatchingSku(
            product, attributeValues, new DefaultProcessContextImpl<>());

    // Assert
    verify(productOptionImpl).getAttributeName();
    verify(productOptionImpl).getRequired();
    verify(productOptionImpl).getUseInSkuGeneration();
    verify(productOptionXrefImpl).getProductOption();
    verify(catalogService).findSkuById(1L);
    verify(productOptionValidationService)
        .findSkuIdsForProductOptionValues(
            isNull(), eq("Attribute Name"), isNull(), isA(List.class));
    verify(productOptionValidationService)
        .hasProductOptionValidationStrategy(isA(ProductOption.class));
    verify(productOptionValidationService).isAddOrNoneType(isA(ProductOption.class));
    verify(productOptionValidationService)
        .validateWithoutException(isA(ProductOption.class), isNull(), isA(ActivityMessages.class));
    assertSame(skuImpl, actualFindMatchingSkuResult);
  }

  /**
   * Test {@link ValidateAddRequestActivity#findMatchingSku(Product, Map, ActivityMessages)} with
   * {@code product}, {@code attributeValues}, {@code messages}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ValidateAddRequestActivity#findMatchingSku(Product, Map,
   * ActivityMessages)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Sku ValidateAddRequestActivity.findMatchingSku(Product, Map, ActivityMessages)"
  })
  public void testFindMatchingSkuWithProductAttributeValuesMessages_whenNull()
      throws RequiredAttributeNotProvidedException {
    // Arrange
    ValidateAddRequestActivity validateAddRequestActivity = new ValidateAddRequestActivity();
    HashMap<String, String> attributeValues = new HashMap<>();

    // Act and Assert
    assertNull(
        validateAddRequestActivity.findMatchingSku(
            null, attributeValues, new DefaultProcessContextImpl<>()));
  }

  /**
   * Test {@link ValidateAddRequestActivity#findMatchingSku(Product, Map, ActivityMessages)} with
   * {@code product}, {@code attributeValues}, {@code messages}.
   *
   * <ul>
   *   <li>When {@link ProductBundleImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link ValidateAddRequestActivity#findMatchingSku(Product, Map,
   * ActivityMessages)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Sku ValidateAddRequestActivity.findMatchingSku(Product, Map, ActivityMessages)"
  })
  public void testFindMatchingSkuWithProductAttributeValuesMessages_whenProductBundleImpl()
      throws RequiredAttributeNotProvidedException {
    // Arrange
    ValidateAddRequestActivity validateAddRequestActivity = new ValidateAddRequestActivity();
    ProductBundleImpl product = new ProductBundleImpl();
    HashMap<String, String> attributeValues = new HashMap<>();

    // Act and Assert
    assertNull(
        validateAddRequestActivity.findMatchingSku(
            product, attributeValues, new DefaultProcessContextImpl<>()));
  }

  /**
   * Test {@link ValidateAddRequestActivity#shouldValidateWithException(boolean, boolean, String,
   * boolean)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ValidateAddRequestActivity#shouldValidateWithException(boolean,
   * boolean, String, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ValidateAddRequestActivity.shouldValidateWithException(boolean, boolean, String, boolean)"
  })
  public void testShouldValidateWithException_whenEmptyString_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(
        new ValidateAddRequestActivity().shouldValidateWithException(false, false, "", false));
  }

  /**
   * Test {@link ValidateAddRequestActivity#shouldValidateWithException(boolean, boolean, String,
   * boolean)}.
   *
   * <ul>
   *   <li>When {@code not empty}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ValidateAddRequestActivity#shouldValidateWithException(boolean,
   * boolean, String, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ValidateAddRequestActivity.shouldValidateWithException(boolean, boolean, String, boolean)"
  })
  public void testShouldValidateWithException_whenNotEmpty_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(
        new ValidateAddRequestActivity()
            .shouldValidateWithException(false, false, "not empty", false));
  }

  /**
   * Test {@link ValidateAddRequestActivity#shouldValidateWithException(boolean, boolean, String,
   * boolean)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ValidateAddRequestActivity#shouldValidateWithException(boolean,
   * boolean, String, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ValidateAddRequestActivity.shouldValidateWithException(boolean, boolean, String, boolean)"
  })
  public void testShouldValidateWithException_whenNull_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(
        new ValidateAddRequestActivity().shouldValidateWithException(false, false, null, false));
  }

  /**
   * Test {@link ValidateAddRequestActivity#shouldValidateWithException(boolean, boolean, String,
   * boolean)}.
   *
   * <ul>
   *   <li>When {@code true}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ValidateAddRequestActivity#shouldValidateWithException(boolean,
   * boolean, String, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ValidateAddRequestActivity.shouldValidateWithException(boolean, boolean, String, boolean)"
  })
  public void testShouldValidateWithException_whenTrue_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(
        new ValidateAddRequestActivity()
            .shouldValidateWithException(true, false, "0123456789ABCDEF", true));
  }

  /**
   * Test {@link ValidateAddRequestActivity#shouldValidateWithException(boolean, boolean, String,
   * boolean)}.
   *
   * <ul>
   *   <li>When {@code true}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ValidateAddRequestActivity#shouldValidateWithException(boolean,
   * boolean, String, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ValidateAddRequestActivity.shouldValidateWithException(boolean, boolean, String, boolean)"
  })
  public void testShouldValidateWithException_whenTrue_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(
        new ValidateAddRequestActivity()
            .shouldValidateWithException(true, true, "0123456789ABCDEF", true));
  }

  /**
   * Test {@link ValidateAddRequestActivity#addSkuToCart(Sku, OrderItemRequestDTO, Product,
   * CartOperationRequest)}.
   *
   * <p>Method under test: {@link ValidateAddRequestActivity#addSkuToCart(Sku, OrderItemRequestDTO,
   * Product, CartOperationRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ValidateAddRequestActivity.addSkuToCart(Sku, OrderItemRequestDTO, Product, CartOperationRequest)"
  })
  public void testAddSkuToCart() {
    // Arrange
    ValidateAddRequestActivity validateAddRequestActivity = new ValidateAddRequestActivity();

    NonDiscreteOrderItemRequestDTO orderItemRequestDTO =
        new NonDiscreteOrderItemRequestDTO("Item Name", 1, new Money());
    orderItemRequestDTO.setItemName(null);
    orderItemRequestDTO.setOverrideRetailPrice(new Money());
    orderItemRequestDTO.setOverrideSalePrice(new Money());
    ProductBundleImpl product = new ProductBundleImpl();
    NullOrderImpl order = new NullOrderImpl();
    CartOperationRequest request = new CartOperationRequest(order, new OrderItemRequestDTO(), true);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> validateAddRequestActivity.addSkuToCart(null, orderItemRequestDTO, product, request));
  }

  /**
   * Test {@link ValidateAddRequestActivity#addSkuToCart(Sku, OrderItemRequestDTO, Product,
   * CartOperationRequest)}.
   *
   * <p>Method under test: {@link ValidateAddRequestActivity#addSkuToCart(Sku, OrderItemRequestDTO,
   * Product, CartOperationRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ValidateAddRequestActivity.addSkuToCart(Sku, OrderItemRequestDTO, Product, CartOperationRequest)"
  })
  public void testAddSkuToCart2() {
    // Arrange
    ValidateAddRequestActivity validateAddRequestActivity = new ValidateAddRequestActivity();

    NonDiscreteOrderItemRequestDTO orderItemRequestDTO = mock(NonDiscreteOrderItemRequestDTO.class);
    when(orderItemRequestDTO.getOverrideRetailPrice()).thenReturn(null);
    when(orderItemRequestDTO.getOverrideSalePrice()).thenReturn(new Money());
    when(orderItemRequestDTO.getItemName()).thenReturn("Item Name");
    ProductBundleImpl product = new ProductBundleImpl();
    NullOrderImpl order = new NullOrderImpl();
    CartOperationRequest request = new CartOperationRequest(order, new OrderItemRequestDTO(), true);

    // Act
    validateAddRequestActivity.addSkuToCart(null, orderItemRequestDTO, product, request);

    // Assert
    verify(orderItemRequestDTO).getItemName();
    verify(orderItemRequestDTO).getOverrideRetailPrice();
    verify(orderItemRequestDTO).getOverrideSalePrice();
  }

  /**
   * Test {@link ValidateAddRequestActivity#addSkuToCart(Sku, OrderItemRequestDTO, Product,
   * CartOperationRequest)}.
   *
   * <p>Method under test: {@link ValidateAddRequestActivity#addSkuToCart(Sku, OrderItemRequestDTO,
   * Product, CartOperationRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ValidateAddRequestActivity.addSkuToCart(Sku, OrderItemRequestDTO, Product, CartOperationRequest)"
  })
  public void testAddSkuToCart3() {
    // Arrange
    ValidateAddRequestActivity validateAddRequestActivity = new ValidateAddRequestActivity();

    NonDiscreteOrderItemRequestDTO orderItemRequestDTO = mock(NonDiscreteOrderItemRequestDTO.class);
    when(orderItemRequestDTO.getOverrideRetailPrice()).thenReturn(null);
    when(orderItemRequestDTO.getOverrideSalePrice()).thenReturn(null);
    when(orderItemRequestDTO.getItemName()).thenReturn("Item Name");
    ProductBundleImpl product = new ProductBundleImpl();
    NullOrderImpl order = new NullOrderImpl();
    CartOperationRequest request = new CartOperationRequest(order, new OrderItemRequestDTO(), true);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> validateAddRequestActivity.addSkuToCart(null, orderItemRequestDTO, product, request));
    verify(orderItemRequestDTO).getItemName();
    verify(orderItemRequestDTO).getOverrideRetailPrice();
    verify(orderItemRequestDTO).getOverrideSalePrice();
  }

  /**
   * Test {@link ValidateAddRequestActivity#addSkuToCart(Sku, OrderItemRequestDTO, Product,
   * CartOperationRequest)}.
   *
   * <ul>
   *   <li>Given empty string.
   * </ul>
   *
   * <p>Method under test: {@link ValidateAddRequestActivity#addSkuToCart(Sku, OrderItemRequestDTO,
   * Product, CartOperationRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ValidateAddRequestActivity.addSkuToCart(Sku, OrderItemRequestDTO, Product, CartOperationRequest)"
  })
  public void testAddSkuToCart_givenEmptyString() {
    // Arrange
    ValidateAddRequestActivity validateAddRequestActivity = new ValidateAddRequestActivity();

    NonDiscreteOrderItemRequestDTO orderItemRequestDTO = mock(NonDiscreteOrderItemRequestDTO.class);
    when(orderItemRequestDTO.getItemName()).thenReturn("");
    ProductBundleImpl product = new ProductBundleImpl();
    NullOrderImpl order = new NullOrderImpl();
    CartOperationRequest request = new CartOperationRequest(order, new OrderItemRequestDTO(), true);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> validateAddRequestActivity.addSkuToCart(null, orderItemRequestDTO, product, request));
    verify(orderItemRequestDTO).getItemName();
  }

  /**
   * Test {@link ValidateAddRequestActivity#addSkuToCart(Sku, OrderItemRequestDTO, Product,
   * CartOperationRequest)}.
   *
   * <ul>
   *   <li>Given space.
   * </ul>
   *
   * <p>Method under test: {@link ValidateAddRequestActivity#addSkuToCart(Sku, OrderItemRequestDTO,
   * Product, CartOperationRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ValidateAddRequestActivity.addSkuToCart(Sku, OrderItemRequestDTO, Product, CartOperationRequest)"
  })
  public void testAddSkuToCart_givenSpace() {
    // Arrange
    ValidateAddRequestActivity validateAddRequestActivity = new ValidateAddRequestActivity();

    NonDiscreteOrderItemRequestDTO orderItemRequestDTO =
        new NonDiscreteOrderItemRequestDTO("Item Name", 1, new Money());
    orderItemRequestDTO.setItemName(" ");
    orderItemRequestDTO.setOverrideRetailPrice(new Money());
    orderItemRequestDTO.setOverrideSalePrice(new Money());
    ProductBundleImpl product = new ProductBundleImpl();
    NullOrderImpl order = new NullOrderImpl();
    CartOperationRequest request = new CartOperationRequest(order, new OrderItemRequestDTO(), true);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> validateAddRequestActivity.addSkuToCart(null, orderItemRequestDTO, product, request));
  }

  /**
   * Test {@link ValidateAddRequestActivity#addSkuToCart(Sku, OrderItemRequestDTO, Product,
   * CartOperationRequest)}.
   *
   * <ul>
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link ValidateAddRequestActivity#addSkuToCart(Sku, OrderItemRequestDTO,
   * Product, CartOperationRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ValidateAddRequestActivity.addSkuToCart(Sku, OrderItemRequestDTO, Product, CartOperationRequest)"
  })
  public void testAddSkuToCart_thenDoesNotThrow() {
    // Arrange
    ValidateAddRequestActivity validateAddRequestActivity = new ValidateAddRequestActivity();
    NonDiscreteOrderItemRequestDTO orderItemRequestDTO =
        new NonDiscreteOrderItemRequestDTO("Could not find SKU for : productId: ", 1, new Money());
    ProductBundleImpl product = new ProductBundleImpl();
    NullOrderImpl order = new NullOrderImpl();
    CartOperationRequest request = new CartOperationRequest(order, new OrderItemRequestDTO(), true);

    // Act and Assert
    validateAddRequestActivity.addSkuToCart(null, orderItemRequestDTO, product, request);
  }

  /**
   * Test {@link ValidateAddRequestActivity#addSkuToCart(Sku, OrderItemRequestDTO, Product,
   * CartOperationRequest)}.
   *
   * <ul>
   *   <li>When {@link OrderItemRequestDTO#OrderItemRequestDTO()}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link ValidateAddRequestActivity#addSkuToCart(Sku, OrderItemRequestDTO,
   * Product, CartOperationRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ValidateAddRequestActivity.addSkuToCart(Sku, OrderItemRequestDTO, Product, CartOperationRequest)"
  })
  public void testAddSkuToCart_whenOrderItemRequestDTO_thenThrowIllegalArgumentException() {
    // Arrange
    ValidateAddRequestActivity validateAddRequestActivity = new ValidateAddRequestActivity();
    OrderItemRequestDTO orderItemRequestDTO = new OrderItemRequestDTO();
    ProductBundleImpl product = new ProductBundleImpl();
    NullOrderImpl order = new NullOrderImpl();
    CartOperationRequest request = new CartOperationRequest(order, new OrderItemRequestDTO(), true);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> validateAddRequestActivity.addSkuToCart(null, orderItemRequestDTO, product, request));
  }

  /**
   * Test {@link ValidateAddRequestActivity#addSkuToCart(Sku, OrderItemRequestDTO, Product,
   * CartOperationRequest)}.
   *
   * <ul>
   *   <li>When {@link SkuImpl} (default constructor).
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link ValidateAddRequestActivity#addSkuToCart(Sku, OrderItemRequestDTO,
   * Product, CartOperationRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ValidateAddRequestActivity.addSkuToCart(Sku, OrderItemRequestDTO, Product, CartOperationRequest)"
  })
  public void testAddSkuToCart_whenSkuImpl_thenThrowIllegalArgumentException() {
    // Arrange
    ValidateAddRequestActivity validateAddRequestActivity = new ValidateAddRequestActivity();
    SkuImpl sku = new SkuImpl();
    OrderItemRequestDTO orderItemRequestDTO = new OrderItemRequestDTO();
    ProductBundleImpl product = new ProductBundleImpl();
    NullOrderImpl order = new NullOrderImpl();
    CartOperationRequest request = new CartOperationRequest(order, new OrderItemRequestDTO(), true);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> validateAddRequestActivity.addSkuToCart(sku, orderItemRequestDTO, product, request));
  }

  /**
   * Test {@link ValidateAddRequestActivity#hasSkuOrIsNonDiscreteOI(Sku, OrderItemRequestDTO)}.
   *
   * <ul>
   *   <li>When {@link NonDiscreteOrderItemRequestDTO#NonDiscreteOrderItemRequestDTO()}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ValidateAddRequestActivity#hasSkuOrIsNonDiscreteOI(Sku,
   * OrderItemRequestDTO)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ValidateAddRequestActivity.hasSkuOrIsNonDiscreteOI(Sku, OrderItemRequestDTO)"
  })
  public void testHasSkuOrIsNonDiscreteOI_whenNonDiscreteOrderItemRequestDTO_thenReturnTrue() {
    // Arrange
    ValidateAddRequestActivity validateAddRequestActivity = new ValidateAddRequestActivity();

    // Act and Assert
    assertTrue(
        validateAddRequestActivity.hasSkuOrIsNonDiscreteOI(
            null, new NonDiscreteOrderItemRequestDTO()));
  }

  /**
   * Test {@link ValidateAddRequestActivity#hasSkuOrIsNonDiscreteOI(Sku, OrderItemRequestDTO)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ValidateAddRequestActivity#hasSkuOrIsNonDiscreteOI(Sku,
   * OrderItemRequestDTO)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ValidateAddRequestActivity.hasSkuOrIsNonDiscreteOI(Sku, OrderItemRequestDTO)"
  })
  public void testHasSkuOrIsNonDiscreteOI_whenNull_thenReturnFalse() {
    // Arrange
    ValidateAddRequestActivity validateAddRequestActivity = new ValidateAddRequestActivity();

    // Act and Assert
    assertFalse(
        validateAddRequestActivity.hasSkuOrIsNonDiscreteOI(null, new OrderItemRequestDTO()));
  }

  /**
   * Test {@link ValidateAddRequestActivity#hasSkuOrIsNonDiscreteOI(Sku, OrderItemRequestDTO)}.
   *
   * <ul>
   *   <li>When {@link SkuImpl} (default constructor).
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ValidateAddRequestActivity#hasSkuOrIsNonDiscreteOI(Sku,
   * OrderItemRequestDTO)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ValidateAddRequestActivity.hasSkuOrIsNonDiscreteOI(Sku, OrderItemRequestDTO)"
  })
  public void testHasSkuOrIsNonDiscreteOI_whenSkuImpl_thenReturnTrue() {
    // Arrange
    ValidateAddRequestActivity validateAddRequestActivity = new ValidateAddRequestActivity();
    SkuImpl sku = new SkuImpl();

    // Act and Assert
    assertTrue(validateAddRequestActivity.hasSkuOrIsNonDiscreteOI(sku, new OrderItemRequestDTO()));
  }

  /**
   * Test {@link ValidateAddRequestActivity#handleIfNoSku(OrderItemRequestDTO, Product)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link ValidateAddRequestActivity#handleIfNoSku(OrderItemRequestDTO,
   * Product)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ValidateAddRequestActivity.handleIfNoSku(OrderItemRequestDTO, Product)"})
  public void testHandleIfNoSku_whenNull_thenThrowIllegalArgumentException() {
    // Arrange
    ValidateAddRequestActivity validateAddRequestActivity = new ValidateAddRequestActivity();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> validateAddRequestActivity.handleIfNoSku(new OrderItemRequestDTO(), null));
  }

  /**
   * Test {@link ValidateAddRequestActivity#handleIfNoSku(OrderItemRequestDTO, Product)}.
   *
   * <ul>
   *   <li>When {@link ProductBundleImpl} (default constructor).
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link ValidateAddRequestActivity#handleIfNoSku(OrderItemRequestDTO,
   * Product)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ValidateAddRequestActivity.handleIfNoSku(OrderItemRequestDTO, Product)"})
  public void testHandleIfNoSku_whenProductBundleImpl_thenThrowIllegalArgumentException() {
    // Arrange
    ValidateAddRequestActivity validateAddRequestActivity = new ValidateAddRequestActivity();
    OrderItemRequestDTO orderItemRequestDTO = new OrderItemRequestDTO();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            validateAddRequestActivity.handleIfNoSku(orderItemRequestDTO, new ProductBundleImpl()));
  }

  /**
   * Test {@link ValidateAddRequestActivity#handleIfNonDiscreteOI(OrderItemRequestDTO)}.
   *
   * <p>Method under test: {@link
   * ValidateAddRequestActivity#handleIfNonDiscreteOI(OrderItemRequestDTO)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ValidateAddRequestActivity.handleIfNonDiscreteOI(OrderItemRequestDTO)"})
  public void testHandleIfNonDiscreteOI() {
    // Arrange
    ValidateAddRequestActivity validateAddRequestActivity = new ValidateAddRequestActivity();

    NonDiscreteOrderItemRequestDTO orderItemRequestDTO =
        new NonDiscreteOrderItemRequestDTO("Item Name", 1, new Money());
    orderItemRequestDTO.setItemName(null);
    orderItemRequestDTO.setOverrideRetailPrice(new Money());
    orderItemRequestDTO.setOverrideSalePrice(new Money());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> validateAddRequestActivity.handleIfNonDiscreteOI(orderItemRequestDTO));
  }

  /**
   * Test {@link ValidateAddRequestActivity#handleIfNonDiscreteOI(OrderItemRequestDTO)}.
   *
   * <p>Method under test: {@link
   * ValidateAddRequestActivity#handleIfNonDiscreteOI(OrderItemRequestDTO)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ValidateAddRequestActivity.handleIfNonDiscreteOI(OrderItemRequestDTO)"})
  public void testHandleIfNonDiscreteOI2() {
    // Arrange
    ValidateAddRequestActivity validateAddRequestActivity = new ValidateAddRequestActivity();

    NonDiscreteOrderItemRequestDTO orderItemRequestDTO = mock(NonDiscreteOrderItemRequestDTO.class);
    when(orderItemRequestDTO.getOverrideRetailPrice()).thenReturn(null);
    when(orderItemRequestDTO.getOverrideSalePrice()).thenReturn(new Money());
    when(orderItemRequestDTO.getItemName()).thenReturn("Item Name");

    // Act
    validateAddRequestActivity.handleIfNonDiscreteOI(orderItemRequestDTO);

    // Assert
    verify(orderItemRequestDTO).getItemName();
    verify(orderItemRequestDTO).getOverrideRetailPrice();
    verify(orderItemRequestDTO).getOverrideSalePrice();
  }

  /**
   * Test {@link ValidateAddRequestActivity#handleIfNonDiscreteOI(OrderItemRequestDTO)}.
   *
   * <p>Method under test: {@link
   * ValidateAddRequestActivity#handleIfNonDiscreteOI(OrderItemRequestDTO)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ValidateAddRequestActivity.handleIfNonDiscreteOI(OrderItemRequestDTO)"})
  public void testHandleIfNonDiscreteOI3() {
    // Arrange
    ValidateAddRequestActivity validateAddRequestActivity = new ValidateAddRequestActivity();

    NonDiscreteOrderItemRequestDTO orderItemRequestDTO = mock(NonDiscreteOrderItemRequestDTO.class);
    when(orderItemRequestDTO.getOverrideRetailPrice()).thenReturn(null);
    when(orderItemRequestDTO.getOverrideSalePrice()).thenReturn(null);
    when(orderItemRequestDTO.getItemName()).thenReturn("Item Name");

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> validateAddRequestActivity.handleIfNonDiscreteOI(orderItemRequestDTO));
    verify(orderItemRequestDTO).getItemName();
    verify(orderItemRequestDTO).getOverrideRetailPrice();
    verify(orderItemRequestDTO).getOverrideSalePrice();
  }

  /**
   * Test {@link ValidateAddRequestActivity#handleIfNonDiscreteOI(OrderItemRequestDTO)}.
   *
   * <ul>
   *   <li>Given empty string.
   * </ul>
   *
   * <p>Method under test: {@link
   * ValidateAddRequestActivity#handleIfNonDiscreteOI(OrderItemRequestDTO)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ValidateAddRequestActivity.handleIfNonDiscreteOI(OrderItemRequestDTO)"})
  public void testHandleIfNonDiscreteOI_givenEmptyString() {
    // Arrange
    ValidateAddRequestActivity validateAddRequestActivity = new ValidateAddRequestActivity();

    NonDiscreteOrderItemRequestDTO orderItemRequestDTO = mock(NonDiscreteOrderItemRequestDTO.class);
    when(orderItemRequestDTO.getItemName()).thenReturn("");

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> validateAddRequestActivity.handleIfNonDiscreteOI(orderItemRequestDTO));
    verify(orderItemRequestDTO).getItemName();
  }

  /**
   * Test {@link ValidateAddRequestActivity#handleIfNonDiscreteOI(OrderItemRequestDTO)}.
   *
   * <ul>
   *   <li>Given space.
   * </ul>
   *
   * <p>Method under test: {@link
   * ValidateAddRequestActivity#handleIfNonDiscreteOI(OrderItemRequestDTO)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ValidateAddRequestActivity.handleIfNonDiscreteOI(OrderItemRequestDTO)"})
  public void testHandleIfNonDiscreteOI_givenSpace() {
    // Arrange
    ValidateAddRequestActivity validateAddRequestActivity = new ValidateAddRequestActivity();

    NonDiscreteOrderItemRequestDTO orderItemRequestDTO =
        new NonDiscreteOrderItemRequestDTO("Item Name", 1, new Money());
    orderItemRequestDTO.setItemName(" ");
    orderItemRequestDTO.setOverrideRetailPrice(new Money());
    orderItemRequestDTO.setOverrideSalePrice(new Money());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> validateAddRequestActivity.handleIfNonDiscreteOI(orderItemRequestDTO));
  }

  /**
   * Test {@link ValidateAddRequestActivity#handleIfNonDiscreteOI(OrderItemRequestDTO)}.
   *
   * <ul>
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link
   * ValidateAddRequestActivity#handleIfNonDiscreteOI(OrderItemRequestDTO)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ValidateAddRequestActivity.handleIfNonDiscreteOI(OrderItemRequestDTO)"})
  public void testHandleIfNonDiscreteOI_thenDoesNotThrow() {
    // Arrange
    ValidateAddRequestActivity validateAddRequestActivity = new ValidateAddRequestActivity();

    // Act and Assert
    validateAddRequestActivity.handleIfNonDiscreteOI(
        new NonDiscreteOrderItemRequestDTO("Item Name", 1, new Money()));
  }

  /**
   * Test {@link ValidateAddRequestActivity#hasPrice(NonDiscreteOrderItemRequestDTO)}.
   *
   * <p>Method under test: {@link
   * ValidateAddRequestActivity#hasPrice(NonDiscreteOrderItemRequestDTO)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ValidateAddRequestActivity.hasPrice(NonDiscreteOrderItemRequestDTO)"})
  public void testHasPrice() {
    // Arrange
    ValidateAddRequestActivity validateAddRequestActivity = new ValidateAddRequestActivity();

    NonDiscreteOrderItemRequestDTO ndr =
        new NonDiscreteOrderItemRequestDTO("Item Name", 1, new Money());
    ndr.setOverrideRetailPrice(new Money());
    ndr.setOverrideSalePrice(new Money());

    // Act
    boolean actualHasPriceResult = validateAddRequestActivity.hasPrice(ndr);

    // Assert
    assertTrue(actualHasPriceResult);
  }

  /**
   * Test {@link ValidateAddRequestActivity#hasPrice(NonDiscreteOrderItemRequestDTO)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ValidateAddRequestActivity#hasPrice(NonDiscreteOrderItemRequestDTO)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ValidateAddRequestActivity.hasPrice(NonDiscreteOrderItemRequestDTO)"})
  public void testHasPrice_givenNull() {
    // Arrange
    ValidateAddRequestActivity validateAddRequestActivity = new ValidateAddRequestActivity();

    NonDiscreteOrderItemRequestDTO ndr =
        new NonDiscreteOrderItemRequestDTO("Item Name", 1, new Money());
    ndr.setOverrideRetailPrice(null);
    ndr.setOverrideSalePrice(new Money());

    // Act
    boolean actualHasPriceResult = validateAddRequestActivity.hasPrice(ndr);

    // Assert
    assertTrue(actualHasPriceResult);
  }

  /**
   * Test {@link ValidateAddRequestActivity#hasPrice(NonDiscreteOrderItemRequestDTO)}.
   *
   * <ul>
   *   <li>When {@link NonDiscreteOrderItemRequestDTO#NonDiscreteOrderItemRequestDTO()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ValidateAddRequestActivity#hasPrice(NonDiscreteOrderItemRequestDTO)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ValidateAddRequestActivity.hasPrice(NonDiscreteOrderItemRequestDTO)"})
  public void testHasPrice_whenNonDiscreteOrderItemRequestDTO_thenReturnFalse() {
    // Arrange
    ValidateAddRequestActivity validateAddRequestActivity = new ValidateAddRequestActivity();

    // Act and Assert
    assertFalse(validateAddRequestActivity.hasPrice(new NonDiscreteOrderItemRequestDTO()));
  }

  /**
   * Test {@link ValidateAddRequestActivity#hasSameCurrency(OrderItemRequestDTO,
   * CartOperationRequest, Sku)}.
   *
   * <ul>
   *   <li>Given {@link Auditable} (default constructor) CreatedBy is one.
   * </ul>
   *
   * <p>Method under test: {@link ValidateAddRequestActivity#hasSameCurrency(OrderItemRequestDTO,
   * CartOperationRequest, Sku)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ValidateAddRequestActivity.hasSameCurrency(OrderItemRequestDTO, CartOperationRequest, Sku)"
  })
  public void testHasSameCurrency_givenAuditableCreatedByIsOne() {
    // Arrange
    ValidateAddRequestActivity validateAddRequestActivity = new ValidateAddRequestActivity();
    NonDiscreteOrderItemRequestDTO orderItemRequestDTO = new NonDiscreteOrderItemRequestDTO();

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
    order.setCurrency(new BroadleafCurrencyImpl());
    NullOrderImpl order2 = new NullOrderImpl();

    CartOperationRequest request =
        new CartOperationRequest(order2, new OrderItemRequestDTO(), true);
    request.setOrder(order);

    // Act and Assert
    assertTrue(
        validateAddRequestActivity.hasSameCurrency(orderItemRequestDTO, request, new SkuImpl()));
  }

  /**
   * Test {@link ValidateAddRequestActivity#hasSameCurrency(OrderItemRequestDTO,
   * CartOperationRequest, Sku)}.
   *
   * <ul>
   *   <li>Given {@link BroadleafCurrencyImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link ValidateAddRequestActivity#hasSameCurrency(OrderItemRequestDTO,
   * CartOperationRequest, Sku)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ValidateAddRequestActivity.hasSameCurrency(OrderItemRequestDTO, CartOperationRequest, Sku)"
  })
  public void testHasSameCurrency_givenBroadleafCurrencyImpl() {
    // Arrange
    ValidateAddRequestActivity validateAddRequestActivity = new ValidateAddRequestActivity();
    OrderItemRequestDTO orderItemRequestDTO = new OrderItemRequestDTO();
    NullOrderImpl order = new NullOrderImpl();
    CartOperationRequest request = new CartOperationRequest(order, new OrderItemRequestDTO(), true);

    SkuImpl sku = new SkuImpl();
    sku.setCurrency(new BroadleafCurrencyImpl());

    // Act and Assert
    assertTrue(validateAddRequestActivity.hasSameCurrency(orderItemRequestDTO, request, sku));
  }

  /**
   * Test {@link ValidateAddRequestActivity#hasSameCurrency(OrderItemRequestDTO,
   * CartOperationRequest, Sku)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link ValidateAddRequestActivity#hasSameCurrency(OrderItemRequestDTO,
   * CartOperationRequest, Sku)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ValidateAddRequestActivity.hasSameCurrency(OrderItemRequestDTO, CartOperationRequest, Sku)"
  })
  public void testHasSameCurrency_thenThrowIllegalArgumentException() {
    // Arrange
    ValidateAddRequestActivity validateAddRequestActivity = new ValidateAddRequestActivity();
    OrderItemRequestDTO orderItemRequestDTO = new OrderItemRequestDTO();
    NullOrderImpl order = new NullOrderImpl();
    CartOperationRequest request = new CartOperationRequest(order, new OrderItemRequestDTO(), true);

    Sku sku = mock(Sku.class);
    when(sku.getCurrency()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> validateAddRequestActivity.hasSameCurrency(orderItemRequestDTO, request, sku));
    verify(sku).getCurrency();
  }

  /**
   * Test {@link ValidateAddRequestActivity#hasSameCurrency(OrderItemRequestDTO,
   * CartOperationRequest, Sku)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ValidateAddRequestActivity#hasSameCurrency(OrderItemRequestDTO,
   * CartOperationRequest, Sku)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ValidateAddRequestActivity.hasSameCurrency(OrderItemRequestDTO, CartOperationRequest, Sku)"
  })
  public void testHasSameCurrency_whenNull_thenReturnTrue() {
    // Arrange
    ValidateAddRequestActivity validateAddRequestActivity = new ValidateAddRequestActivity();
    OrderItemRequestDTO orderItemRequestDTO = new OrderItemRequestDTO();
    NullOrderImpl order = new NullOrderImpl();
    CartOperationRequest request = new CartOperationRequest(order, new OrderItemRequestDTO(), true);

    // Act and Assert
    assertTrue(validateAddRequestActivity.hasSameCurrency(orderItemRequestDTO, request, null));
  }

  /**
   * Test {@link ValidateAddRequestActivity#hasSameCurrency(OrderItemRequestDTO,
   * CartOperationRequest, Sku)}.
   *
   * <ul>
   *   <li>When {@link SkuImpl} (default constructor).
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ValidateAddRequestActivity#hasSameCurrency(OrderItemRequestDTO,
   * CartOperationRequest, Sku)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ValidateAddRequestActivity.hasSameCurrency(OrderItemRequestDTO, CartOperationRequest, Sku)"
  })
  public void testHasSameCurrency_whenSkuImpl_thenReturnTrue() {
    // Arrange
    ValidateAddRequestActivity validateAddRequestActivity = new ValidateAddRequestActivity();
    OrderItemRequestDTO orderItemRequestDTO = new OrderItemRequestDTO();
    NullOrderImpl order = new NullOrderImpl();
    CartOperationRequest request = new CartOperationRequest(order, new OrderItemRequestDTO(), true);

    // Act and Assert
    assertTrue(
        validateAddRequestActivity.hasSameCurrency(orderItemRequestDTO, request, new SkuImpl()));
  }

  /**
   * Test {@link ValidateAddRequestActivity#validateIfParentOrderItemExists(OrderItemRequestDTO)}.
   *
   * <p>Method under test: {@link
   * ValidateAddRequestActivity#validateIfParentOrderItemExists(OrderItemRequestDTO)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ValidateAddRequestActivity.validateIfParentOrderItemExists(OrderItemRequestDTO)"
  })
  public void testValidateIfParentOrderItemExists() {
    // Arrange
    when(orderItemService.readOrderItemById(Mockito.<Long>any()))
        .thenReturn(new BundleOrderItemImpl());

    NonDiscreteOrderItemRequestDTO orderItemRequestDTO =
        new NonDiscreteOrderItemRequestDTO("Item Name", 1, new Money());
    orderItemRequestDTO.setParentOrderItemId(1L);

    // Act
    validateAddRequestActivity.validateIfParentOrderItemExists(orderItemRequestDTO);

    // Assert
    verify(orderItemService).readOrderItemById(1L);
  }

  /**
   * Test {@link ValidateAddRequestActivity#validateIfParentOrderItemExists(OrderItemRequestDTO)}.
   *
   * <p>Method under test: {@link
   * ValidateAddRequestActivity#validateIfParentOrderItemExists(OrderItemRequestDTO)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ValidateAddRequestActivity.validateIfParentOrderItemExists(OrderItemRequestDTO)"
  })
  public void testValidateIfParentOrderItemExists2() {
    // Arrange
    when(orderItemService.readOrderItemById(Mockito.<Long>any()))
        .thenThrow(new IllegalArgumentException());

    NonDiscreteOrderItemRequestDTO orderItemRequestDTO =
        new NonDiscreteOrderItemRequestDTO("Item Name", 1, new Money());
    orderItemRequestDTO.setParentOrderItemId(1L);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> validateAddRequestActivity.validateIfParentOrderItemExists(orderItemRequestDTO));
    verify(orderItemService).readOrderItemById(1L);
  }

  /**
   * Test {@link ValidateAddRequestActivity#validateIfParentOrderItemExists(OrderItemRequestDTO)}.
   *
   * <p>Method under test: {@link
   * ValidateAddRequestActivity#validateIfParentOrderItemExists(OrderItemRequestDTO)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ValidateAddRequestActivity.validateIfParentOrderItemExists(OrderItemRequestDTO)"
  })
  public void testValidateIfParentOrderItemExists3() {
    // Arrange
    when(orderItemService.readOrderItemById(Mockito.<Long>any())).thenReturn(null);

    NonDiscreteOrderItemRequestDTO orderItemRequestDTO =
        new NonDiscreteOrderItemRequestDTO("Item Name", 1, new Money());
    orderItemRequestDTO.setParentOrderItemId(1L);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> validateAddRequestActivity.validateIfParentOrderItemExists(orderItemRequestDTO));
    verify(orderItemService).readOrderItemById(1L);
  }

  /**
   * Test {@link ValidateAddRequestActivity#validateIfParentOrderItemExists(OrderItemRequestDTO)}.
   *
   * <ul>
   *   <li>When {@link OrderItemRequestDTO#OrderItemRequestDTO()}.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link
   * ValidateAddRequestActivity#validateIfParentOrderItemExists(OrderItemRequestDTO)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ValidateAddRequestActivity.validateIfParentOrderItemExists(OrderItemRequestDTO)"
  })
  public void testValidateIfParentOrderItemExists_whenOrderItemRequestDTO_thenDoesNotThrow() {
    // Arrange, Act and Assert
    validateAddRequestActivity.validateIfParentOrderItemExists(new OrderItemRequestDTO());
  }
}
