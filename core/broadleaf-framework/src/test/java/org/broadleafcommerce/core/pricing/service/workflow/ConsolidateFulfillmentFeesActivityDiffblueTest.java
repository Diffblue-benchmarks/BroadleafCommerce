package org.broadleafcommerce.core.pricing.service.workflow;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
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
import org.broadleafcommerce.core.catalog.domain.Sku;
import org.broadleafcommerce.core.catalog.domain.SkuFee;
import org.broadleafcommerce.core.catalog.domain.SkuFeeImpl;
import org.broadleafcommerce.core.catalog.domain.SkuImpl;
import org.broadleafcommerce.core.catalog.service.type.SkuFeeType;
import org.broadleafcommerce.core.order.domain.BundleOrderItemImpl;
import org.broadleafcommerce.core.order.domain.FulfillmentGroup;
import org.broadleafcommerce.core.order.domain.FulfillmentGroupFee;
import org.broadleafcommerce.core.order.domain.FulfillmentGroupFeeImpl;
import org.broadleafcommerce.core.order.domain.FulfillmentGroupImpl;
import org.broadleafcommerce.core.order.domain.FulfillmentGroupItem;
import org.broadleafcommerce.core.order.domain.FulfillmentGroupItemImpl;
import org.broadleafcommerce.core.order.domain.Order;
import org.broadleafcommerce.core.order.domain.OrderImpl;
import org.broadleafcommerce.core.order.service.FulfillmentGroupService;
import org.broadleafcommerce.core.order.service.type.FulfillmentGroupStatusType;
import org.broadleafcommerce.core.order.service.type.OrderStatus;
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
public class ConsolidateFulfillmentFeesActivityDiffblueTest {
  @InjectMocks private ConsolidateFulfillmentFeesActivity consolidateFulfillmentFeesActivity;

  @Mock private FulfillmentGroupService fulfillmentGroupService;

  /**
   * Test {@link ConsolidateFulfillmentFeesActivity#execute(ProcessContext)}.
   *
   * <p>Method under test: {@link ConsolidateFulfillmentFeesActivity#execute(ProcessContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ProcessContext ConsolidateFulfillmentFeesActivity.execute(ProcessContext)"})
  public void testExecute() throws Exception {
    // Arrange
    ConsolidateFulfillmentFeesActivity consolidateFulfillmentFeesActivity =
        new ConsolidateFulfillmentFeesActivity();

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();
    FulfillmentGroupItemImpl fulfillmentGroupItem = new FulfillmentGroupItemImpl();
    fulfillmentGroupImpl.addFulfillmentGroupItem(fulfillmentGroupItem);

    ArrayList<FulfillmentGroup> fulfillmentGroups = new ArrayList<>();
    fulfillmentGroups.add(fulfillmentGroupImpl);

    OrderImpl orderImpl = new OrderImpl();
    orderImpl.setAdditionalOfferInformation(new HashMap<>());
    orderImpl.setAuditable(auditable);
    orderImpl.setCandidateOrderOffers(new ArrayList<>());
    orderImpl.setCurrency(new BroadleafCurrencyImpl());
    orderImpl.setCustomer(new CustomerImpl());
    orderImpl.setEmailAddress("42 Main St");
    orderImpl.setFulfillmentGroups(fulfillmentGroups);
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

    DefaultProcessContextImpl<Order> context = new DefaultProcessContextImpl<>();
    context.setSeedData(orderImpl);

    // Act
    ProcessContext<Order> actualExecuteResult = consolidateFulfillmentFeesActivity.execute(context);

    // Assert
    Order seedData = actualExecuteResult.getSeedData();
    List<FulfillmentGroup> fulfillmentGroups2 = seedData.getFulfillmentGroups();
    assertEquals(1, fulfillmentGroups2.size());
    FulfillmentGroup getResult = fulfillmentGroups2.get(0);
    assertTrue(getResult instanceof FulfillmentGroupImpl);
    assertTrue(seedData instanceof OrderImpl);
    assertTrue(actualExecuteResult instanceof DefaultProcessContextImpl);
    List<FulfillmentGroupItem> fulfillmentGroupItems = getResult.getFulfillmentGroupItems();
    assertEquals(1, fulfillmentGroupItems.size());
    assertSame(fulfillmentGroupItem, fulfillmentGroupItems.get(0));
  }

  /**
   * Test {@link ConsolidateFulfillmentFeesActivity#execute(ProcessContext)}.
   *
   * <p>Method under test: {@link ConsolidateFulfillmentFeesActivity#execute(ProcessContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ProcessContext ConsolidateFulfillmentFeesActivity.execute(ProcessContext)"})
  public void testExecute2() throws Exception {
    // Arrange
    ConsolidateFulfillmentFeesActivity consolidateFulfillmentFeesActivity =
        new ConsolidateFulfillmentFeesActivity();

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    SkuFee skuFee = mock(SkuFee.class);
    when(skuFee.getFeeType()).thenReturn(new SkuFeeType("fulfillmentGroup", "fulfillmentGroup"));

    ArrayList<SkuFee> skuFeeList = new ArrayList<>();
    skuFeeList.add(skuFee);

    Sku sku = mock(Sku.class);
    when(sku.getFees()).thenReturn(skuFeeList);

    BundleOrderItemImpl orderItem = mock(BundleOrderItemImpl.class);
    when(orderItem.getSku()).thenReturn(sku);

    FulfillmentGroupItemImpl fulfillmentGroupItemImpl = new FulfillmentGroupItemImpl();
    fulfillmentGroupItemImpl.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupItemImpl.setId(1L);
    fulfillmentGroupItemImpl.setProratedOrderAdjustmentAmount(new Money());
    fulfillmentGroupItemImpl.setQuantity(1);
    fulfillmentGroupItemImpl.setStatus(FulfillmentGroupStatusType.CANCELLED);
    fulfillmentGroupItemImpl.setTaxes(new ArrayList<>());
    fulfillmentGroupItemImpl.setTotalItemAmount(new Money());
    fulfillmentGroupItemImpl.setTotalItemTaxableAmount(new Money());
    fulfillmentGroupItemImpl.setTotalTax(new Money());
    fulfillmentGroupItemImpl.setOrderItem(orderItem);

    ArrayList<FulfillmentGroupItem> fulfillmentGroupItemList = new ArrayList<>();
    fulfillmentGroupItemList.add(fulfillmentGroupItemImpl);

    FulfillmentGroup fulfillmentGroup = mock(FulfillmentGroup.class);
    when(fulfillmentGroup.getFulfillmentGroupItems()).thenReturn(fulfillmentGroupItemList);
    when(fulfillmentGroup.getFulfillmentGroupFees()).thenReturn(new ArrayList<>());

    ArrayList<FulfillmentGroup> fulfillmentGroups = new ArrayList<>();
    fulfillmentGroups.add(fulfillmentGroup);

    OrderImpl orderImpl = new OrderImpl();
    orderImpl.setAdditionalOfferInformation(new HashMap<>());
    orderImpl.setAuditable(auditable);
    orderImpl.setCandidateOrderOffers(new ArrayList<>());
    orderImpl.setCurrency(new BroadleafCurrencyImpl());
    orderImpl.setCustomer(new CustomerImpl());
    orderImpl.setEmailAddress("42 Main St");
    orderImpl.setFulfillmentGroups(fulfillmentGroups);
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

    DefaultProcessContextImpl<Order> context = new DefaultProcessContextImpl<>();
    context.setSeedData(orderImpl);

    // Act
    ProcessContext<Order> actualExecuteResult = consolidateFulfillmentFeesActivity.execute(context);

    // Assert
    verify(sku).getFees();
    verify(skuFee).getFeeType();
    verify(orderItem).getSku();
    verify(fulfillmentGroup).getFulfillmentGroupFees();
    verify(fulfillmentGroup).getFulfillmentGroupItems();
    assertSame(context, actualExecuteResult);
  }

  /**
   * Test {@link ConsolidateFulfillmentFeesActivity#execute(ProcessContext)}.
   *
   * <p>Method under test: {@link ConsolidateFulfillmentFeesActivity#execute(ProcessContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ProcessContext ConsolidateFulfillmentFeesActivity.execute(ProcessContext)"})
  public void testExecute3() throws Exception {
    // Arrange
    when(fulfillmentGroupService.save(Mockito.<FulfillmentGroup>any()))
        .thenReturn(new FulfillmentGroupImpl());

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();
    fulfillmentGroupImpl.addFulfillmentGroupFee(new FulfillmentGroupFeeImpl());
    fulfillmentGroupImpl.addFulfillmentGroupItem(new FulfillmentGroupItemImpl());

    ArrayList<FulfillmentGroup> fulfillmentGroups = new ArrayList<>();
    fulfillmentGroups.add(fulfillmentGroupImpl);

    OrderImpl orderImpl = new OrderImpl();
    orderImpl.setAdditionalOfferInformation(new HashMap<>());
    orderImpl.setAuditable(auditable);
    orderImpl.setCandidateOrderOffers(new ArrayList<>());
    orderImpl.setCurrency(new BroadleafCurrencyImpl());
    orderImpl.setCustomer(new CustomerImpl());
    orderImpl.setEmailAddress("42 Main St");
    orderImpl.setFulfillmentGroups(fulfillmentGroups);
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

    DefaultProcessContextImpl<Order> context = new DefaultProcessContextImpl<>();
    context.setSeedData(orderImpl);

    // Act
    ProcessContext<Order> actualExecuteResult = consolidateFulfillmentFeesActivity.execute(context);

    // Assert
    verify(fulfillmentGroupService).save(isA(FulfillmentGroup.class));
    Order seedData = actualExecuteResult.getSeedData();
    List<FulfillmentGroup> fulfillmentGroups2 = seedData.getFulfillmentGroups();
    assertEquals(1, fulfillmentGroups2.size());
    FulfillmentGroup getResult = fulfillmentGroups2.get(0);
    assertTrue(getResult instanceof FulfillmentGroupImpl);
    List<FulfillmentGroupItem> fulfillmentGroupItems = getResult.getFulfillmentGroupItems();
    assertEquals(1, fulfillmentGroupItems.size());
    FulfillmentGroupItem getResult2 = fulfillmentGroupItems.get(0);
    assertTrue(getResult2 instanceof FulfillmentGroupItemImpl);
    assertTrue(seedData instanceof OrderImpl);
    assertTrue(actualExecuteResult instanceof DefaultProcessContextImpl);
    assertNull(getResult2.getId());
    assertNull(getResult2.getProratedOrderAdjustmentAmount());
    assertNull(getResult2.getTotalItemAmount());
    assertNull(getResult2.getTotalItemTaxableAmount());
    assertNull(getResult2.getTotalTax());
    assertNull(getResult2.getFulfillmentGroup());
    assertNull(getResult2.getOrderItem());
    assertNull(getResult2.getStatus());
    assertEquals(0, getResult2.getQuantity());
    assertFalse(getResult2.getHasProratedOrderAdjustments());
    assertTrue(getResult2.getTaxes().isEmpty());
  }

  /**
   * Test {@link ConsolidateFulfillmentFeesActivity#execute(ProcessContext)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link SkuFeeImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link ConsolidateFulfillmentFeesActivity#execute(ProcessContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ProcessContext ConsolidateFulfillmentFeesActivity.execute(ProcessContext)"})
  public void testExecute_givenArrayListAddSkuFeeImpl() throws Exception {
    // Arrange
    FulfillmentGroupFeeImpl fulfillmentGroupFeeImpl = new FulfillmentGroupFeeImpl();
    when(fulfillmentGroupService.createFulfillmentGroupFee()).thenReturn(fulfillmentGroupFeeImpl);
    when(fulfillmentGroupService.save(Mockito.<FulfillmentGroup>any()))
        .thenReturn(new FulfillmentGroupImpl());

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    ArrayList<SkuFee> skuFeeList = new ArrayList<>();
    skuFeeList.add(new SkuFeeImpl());

    Sku sku = mock(Sku.class);
    when(sku.getFees()).thenReturn(skuFeeList);

    BundleOrderItemImpl bundleOrderItemImpl = mock(BundleOrderItemImpl.class);
    when(bundleOrderItemImpl.getSku()).thenReturn(sku);

    FulfillmentGroupItemImpl fulfillmentGroupItem = mock(FulfillmentGroupItemImpl.class);
    when(fulfillmentGroupItem.getOrderItem()).thenReturn(bundleOrderItemImpl);

    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();
    fulfillmentGroupImpl.addFulfillmentGroupFee(new FulfillmentGroupFeeImpl());
    fulfillmentGroupImpl.addFulfillmentGroupItem(fulfillmentGroupItem);

    ArrayList<FulfillmentGroup> fulfillmentGroups = new ArrayList<>();
    fulfillmentGroups.add(fulfillmentGroupImpl);

    OrderImpl orderImpl = new OrderImpl();
    orderImpl.setAdditionalOfferInformation(new HashMap<>());
    orderImpl.setAuditable(auditable);
    orderImpl.setCandidateOrderOffers(new ArrayList<>());
    orderImpl.setCurrency(new BroadleafCurrencyImpl());
    orderImpl.setCustomer(new CustomerImpl());
    orderImpl.setEmailAddress("42 Main St");
    orderImpl.setFulfillmentGroups(fulfillmentGroups);
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

    DefaultProcessContextImpl<Order> context = new DefaultProcessContextImpl<>();
    context.setSeedData(orderImpl);

    // Act
    ProcessContext<Order> actualExecuteResult = consolidateFulfillmentFeesActivity.execute(context);

    // Assert
    verify(sku).getFees();
    verify(bundleOrderItemImpl).getSku();
    verify(fulfillmentGroupItem, atLeast(1)).getOrderItem();
    verify(fulfillmentGroupService).createFulfillmentGroupFee();
    verify(fulfillmentGroupService).save(isA(FulfillmentGroup.class));
    Order seedData = actualExecuteResult.getSeedData();
    List<FulfillmentGroup> fulfillmentGroups2 = seedData.getFulfillmentGroups();
    assertEquals(1, fulfillmentGroups2.size());
    FulfillmentGroup getResult = fulfillmentGroups2.get(0);
    assertTrue(getResult instanceof FulfillmentGroupImpl);
    assertTrue(seedData instanceof OrderImpl);
    assertTrue(actualExecuteResult instanceof DefaultProcessContextImpl);
    List<FulfillmentGroupFee> fulfillmentGroupFees = getResult.getFulfillmentGroupFees();
    assertEquals(2, fulfillmentGroupFees.size());
    assertSame(fulfillmentGroupFeeImpl, fulfillmentGroupFees.get(1));
  }

  /**
   * Test {@link ConsolidateFulfillmentFeesActivity#execute(ProcessContext)}.
   *
   * <ul>
   *   <li>Given {@link BundleOrderItemImpl} {@link BundleOrderItemImpl#getSku()} return {@link
   *       SkuImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link ConsolidateFulfillmentFeesActivity#execute(ProcessContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ProcessContext ConsolidateFulfillmentFeesActivity.execute(ProcessContext)"})
  public void testExecute_givenBundleOrderItemImplGetSkuReturnSkuImpl() throws Exception {
    // Arrange
    ConsolidateFulfillmentFeesActivity consolidateFulfillmentFeesActivity =
        new ConsolidateFulfillmentFeesActivity();

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    BundleOrderItemImpl orderItem = mock(BundleOrderItemImpl.class);
    when(orderItem.getSku()).thenReturn(new SkuImpl());

    FulfillmentGroupItemImpl fulfillmentGroupItemImpl = new FulfillmentGroupItemImpl();
    fulfillmentGroupItemImpl.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupItemImpl.setId(1L);
    fulfillmentGroupItemImpl.setProratedOrderAdjustmentAmount(new Money());
    fulfillmentGroupItemImpl.setQuantity(1);
    fulfillmentGroupItemImpl.setStatus(FulfillmentGroupStatusType.CANCELLED);
    fulfillmentGroupItemImpl.setTaxes(new ArrayList<>());
    fulfillmentGroupItemImpl.setTotalItemAmount(new Money());
    fulfillmentGroupItemImpl.setTotalItemTaxableAmount(new Money());
    fulfillmentGroupItemImpl.setTotalTax(new Money());
    fulfillmentGroupItemImpl.setOrderItem(orderItem);

    ArrayList<FulfillmentGroupItem> fulfillmentGroupItemList = new ArrayList<>();
    fulfillmentGroupItemList.add(fulfillmentGroupItemImpl);

    FulfillmentGroup fulfillmentGroup = mock(FulfillmentGroup.class);
    when(fulfillmentGroup.getFulfillmentGroupItems()).thenReturn(fulfillmentGroupItemList);
    when(fulfillmentGroup.getFulfillmentGroupFees()).thenReturn(new ArrayList<>());

    ArrayList<FulfillmentGroup> fulfillmentGroups = new ArrayList<>();
    fulfillmentGroups.add(fulfillmentGroup);

    OrderImpl orderImpl = new OrderImpl();
    orderImpl.setAdditionalOfferInformation(new HashMap<>());
    orderImpl.setAuditable(auditable);
    orderImpl.setCandidateOrderOffers(new ArrayList<>());
    orderImpl.setCurrency(new BroadleafCurrencyImpl());
    orderImpl.setCustomer(new CustomerImpl());
    orderImpl.setEmailAddress("42 Main St");
    orderImpl.setFulfillmentGroups(fulfillmentGroups);
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

    DefaultProcessContextImpl<Order> context = new DefaultProcessContextImpl<>();
    context.setSeedData(orderImpl);

    // Act
    ProcessContext<Order> actualExecuteResult = consolidateFulfillmentFeesActivity.execute(context);

    // Assert
    verify(orderItem).getSku();
    verify(fulfillmentGroup).getFulfillmentGroupFees();
    verify(fulfillmentGroup).getFulfillmentGroupItems();
    assertSame(context, actualExecuteResult);
  }

  /**
   * Test {@link ConsolidateFulfillmentFeesActivity#execute(ProcessContext)}.
   *
   * <ul>
   *   <li>Given {@link SkuFee} {@link SkuFee#getExpression()} return empty string.
   *   <li>Then calls {@link SkuFee#getAmount()}.
   * </ul>
   *
   * <p>Method under test: {@link ConsolidateFulfillmentFeesActivity#execute(ProcessContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ProcessContext ConsolidateFulfillmentFeesActivity.execute(ProcessContext)"})
  public void testExecute_givenSkuFeeGetExpressionReturnEmptyString_thenCallsGetAmount()
      throws Exception {
    // Arrange
    FulfillmentGroupFeeImpl fulfillmentGroupFeeImpl = new FulfillmentGroupFeeImpl();
    when(fulfillmentGroupService.createFulfillmentGroupFee()).thenReturn(fulfillmentGroupFeeImpl);
    when(fulfillmentGroupService.save(Mockito.<FulfillmentGroup>any()))
        .thenReturn(new FulfillmentGroupImpl());

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    SkuFee skuFee = mock(SkuFee.class);
    when(skuFee.getExpression()).thenReturn("");
    when(skuFee.getTaxable()).thenReturn(true);
    when(skuFee.getName()).thenReturn("Name");
    when(skuFee.getAmount()).thenReturn(new Money());
    when(skuFee.getFeeType()).thenReturn(SkuFeeType.FULFILLMENT);

    ArrayList<SkuFee> skuFeeList = new ArrayList<>();
    skuFeeList.add(skuFee);

    Sku sku = mock(Sku.class);
    when(sku.getFees()).thenReturn(skuFeeList);

    BundleOrderItemImpl bundleOrderItemImpl = mock(BundleOrderItemImpl.class);
    when(bundleOrderItemImpl.getSku()).thenReturn(sku);

    FulfillmentGroupItemImpl fulfillmentGroupItem = mock(FulfillmentGroupItemImpl.class);
    when(fulfillmentGroupItem.getOrderItem()).thenReturn(bundleOrderItemImpl);

    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();
    fulfillmentGroupImpl.addFulfillmentGroupFee(new FulfillmentGroupFeeImpl());
    fulfillmentGroupImpl.addFulfillmentGroupItem(fulfillmentGroupItem);

    ArrayList<FulfillmentGroup> fulfillmentGroups = new ArrayList<>();
    fulfillmentGroups.add(fulfillmentGroupImpl);

    OrderImpl orderImpl = new OrderImpl();
    orderImpl.setAdditionalOfferInformation(new HashMap<>());
    orderImpl.setAuditable(auditable);
    orderImpl.setCandidateOrderOffers(new ArrayList<>());
    orderImpl.setCurrency(new BroadleafCurrencyImpl());
    orderImpl.setCustomer(new CustomerImpl());
    orderImpl.setEmailAddress("42 Main St");
    orderImpl.setFulfillmentGroups(fulfillmentGroups);
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

    DefaultProcessContextImpl<Order> context = new DefaultProcessContextImpl<>();
    context.setSeedData(orderImpl);

    // Act
    ProcessContext<Order> actualExecuteResult = consolidateFulfillmentFeesActivity.execute(context);

    // Assert
    verify(sku).getFees();
    verify(skuFee).getAmount();
    verify(skuFee).getExpression();
    verify(skuFee).getFeeType();
    verify(skuFee).getName();
    verify(skuFee).getTaxable();
    verify(bundleOrderItemImpl).getSku();
    verify(fulfillmentGroupItem, atLeast(1)).getOrderItem();
    verify(fulfillmentGroupService).createFulfillmentGroupFee();
    verify(fulfillmentGroupService).save(isA(FulfillmentGroup.class));
    Order seedData = actualExecuteResult.getSeedData();
    List<FulfillmentGroup> fulfillmentGroups2 = seedData.getFulfillmentGroups();
    assertEquals(1, fulfillmentGroups2.size());
    FulfillmentGroup getResult = fulfillmentGroups2.get(0);
    assertTrue(getResult instanceof FulfillmentGroupImpl);
    assertTrue(seedData instanceof OrderImpl);
    assertTrue(actualExecuteResult instanceof DefaultProcessContextImpl);
    List<FulfillmentGroupFee> fulfillmentGroupFees = getResult.getFulfillmentGroupFees();
    assertEquals(2, fulfillmentGroupFees.size());
    assertSame(fulfillmentGroupFeeImpl, fulfillmentGroupFees.get(1));
  }

  /**
   * Test {@link ConsolidateFulfillmentFeesActivity#execute(ProcessContext)}.
   *
   * <ul>
   *   <li>Given {@link SkuFee} {@link SkuFee#getExpression()} return {@code fulfillmentGroup}.
   *   <li>Then calls {@link SkuFee#getAmount()}.
   * </ul>
   *
   * <p>Method under test: {@link ConsolidateFulfillmentFeesActivity#execute(ProcessContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ProcessContext ConsolidateFulfillmentFeesActivity.execute(ProcessContext)"})
  public void testExecute_givenSkuFeeGetExpressionReturnFulfillmentGroup_thenCallsGetAmount()
      throws Exception {
    // Arrange
    FulfillmentGroupFeeImpl fulfillmentGroupFeeImpl = new FulfillmentGroupFeeImpl();
    when(fulfillmentGroupService.createFulfillmentGroupFee()).thenReturn(fulfillmentGroupFeeImpl);
    when(fulfillmentGroupService.save(Mockito.<FulfillmentGroup>any()))
        .thenReturn(new FulfillmentGroupImpl());

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    SkuFee skuFee = mock(SkuFee.class);
    when(skuFee.getExpression()).thenReturn("fulfillmentGroup");
    when(skuFee.getTaxable()).thenReturn(true);
    when(skuFee.getName()).thenReturn("Name");
    when(skuFee.getAmount()).thenReturn(new Money());
    when(skuFee.getFeeType()).thenReturn(SkuFeeType.FULFILLMENT);

    ArrayList<SkuFee> skuFeeList = new ArrayList<>();
    skuFeeList.add(skuFee);

    Sku sku = mock(Sku.class);
    when(sku.getFees()).thenReturn(skuFeeList);

    BundleOrderItemImpl bundleOrderItemImpl = mock(BundleOrderItemImpl.class);
    when(bundleOrderItemImpl.getSku()).thenReturn(sku);

    FulfillmentGroupItemImpl fulfillmentGroupItem = mock(FulfillmentGroupItemImpl.class);
    when(fulfillmentGroupItem.getOrderItem()).thenReturn(bundleOrderItemImpl);

    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();
    fulfillmentGroupImpl.addFulfillmentGroupFee(new FulfillmentGroupFeeImpl());
    fulfillmentGroupImpl.addFulfillmentGroupItem(fulfillmentGroupItem);

    ArrayList<FulfillmentGroup> fulfillmentGroups = new ArrayList<>();
    fulfillmentGroups.add(fulfillmentGroupImpl);

    OrderImpl orderImpl = new OrderImpl();
    orderImpl.setAdditionalOfferInformation(new HashMap<>());
    orderImpl.setAuditable(auditable);
    orderImpl.setCandidateOrderOffers(new ArrayList<>());
    orderImpl.setCurrency(new BroadleafCurrencyImpl());
    orderImpl.setCustomer(new CustomerImpl());
    orderImpl.setEmailAddress("42 Main St");
    orderImpl.setFulfillmentGroups(fulfillmentGroups);
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

    DefaultProcessContextImpl<Order> context = new DefaultProcessContextImpl<>();
    context.setSeedData(orderImpl);

    // Act
    ProcessContext<Order> actualExecuteResult = consolidateFulfillmentFeesActivity.execute(context);

    // Assert
    verify(sku).getFees();
    verify(skuFee).getAmount();
    verify(skuFee).getExpression();
    verify(skuFee).getFeeType();
    verify(skuFee).getName();
    verify(skuFee).getTaxable();
    verify(bundleOrderItemImpl).getSku();
    verify(fulfillmentGroupItem, atLeast(1)).getOrderItem();
    verify(fulfillmentGroupService).createFulfillmentGroupFee();
    verify(fulfillmentGroupService).save(isA(FulfillmentGroup.class));
    Order seedData = actualExecuteResult.getSeedData();
    List<FulfillmentGroup> fulfillmentGroups2 = seedData.getFulfillmentGroups();
    assertEquals(1, fulfillmentGroups2.size());
    FulfillmentGroup getResult = fulfillmentGroups2.get(0);
    assertTrue(getResult instanceof FulfillmentGroupImpl);
    assertTrue(seedData instanceof OrderImpl);
    assertTrue(actualExecuteResult instanceof DefaultProcessContextImpl);
    List<FulfillmentGroupFee> fulfillmentGroupFees = getResult.getFulfillmentGroupFees();
    assertEquals(2, fulfillmentGroupFees.size());
    assertSame(fulfillmentGroupFeeImpl, fulfillmentGroupFees.get(1));
  }

  /**
   * Test {@link ConsolidateFulfillmentFeesActivity#execute(ProcessContext)}.
   *
   * <ul>
   *   <li>Given {@link SkuFee} {@link SkuFee#getExpression()} return {@code not empty}.
   *   <li>Then calls {@link SkuFee#getAmount()}.
   * </ul>
   *
   * <p>Method under test: {@link ConsolidateFulfillmentFeesActivity#execute(ProcessContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ProcessContext ConsolidateFulfillmentFeesActivity.execute(ProcessContext)"})
  public void testExecute_givenSkuFeeGetExpressionReturnNotEmpty_thenCallsGetAmount()
      throws Exception {
    // Arrange
    FulfillmentGroupFeeImpl fulfillmentGroupFeeImpl = new FulfillmentGroupFeeImpl();
    when(fulfillmentGroupService.createFulfillmentGroupFee()).thenReturn(fulfillmentGroupFeeImpl);
    when(fulfillmentGroupService.save(Mockito.<FulfillmentGroup>any()))
        .thenReturn(new FulfillmentGroupImpl());

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    SkuFee skuFee = mock(SkuFee.class);
    when(skuFee.getExpression()).thenReturn("not empty");
    when(skuFee.getTaxable()).thenReturn(true);
    when(skuFee.getName()).thenReturn("Name");
    when(skuFee.getAmount()).thenReturn(new Money());
    when(skuFee.getFeeType()).thenReturn(SkuFeeType.FULFILLMENT);

    ArrayList<SkuFee> skuFeeList = new ArrayList<>();
    skuFeeList.add(skuFee);

    Sku sku = mock(Sku.class);
    when(sku.getFees()).thenReturn(skuFeeList);

    BundleOrderItemImpl bundleOrderItemImpl = mock(BundleOrderItemImpl.class);
    when(bundleOrderItemImpl.getSku()).thenReturn(sku);

    FulfillmentGroupItemImpl fulfillmentGroupItem = mock(FulfillmentGroupItemImpl.class);
    when(fulfillmentGroupItem.getOrderItem()).thenReturn(bundleOrderItemImpl);

    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();
    fulfillmentGroupImpl.addFulfillmentGroupFee(new FulfillmentGroupFeeImpl());
    fulfillmentGroupImpl.addFulfillmentGroupItem(fulfillmentGroupItem);

    ArrayList<FulfillmentGroup> fulfillmentGroups = new ArrayList<>();
    fulfillmentGroups.add(fulfillmentGroupImpl);

    OrderImpl orderImpl = new OrderImpl();
    orderImpl.setAdditionalOfferInformation(new HashMap<>());
    orderImpl.setAuditable(auditable);
    orderImpl.setCandidateOrderOffers(new ArrayList<>());
    orderImpl.setCurrency(new BroadleafCurrencyImpl());
    orderImpl.setCustomer(new CustomerImpl());
    orderImpl.setEmailAddress("42 Main St");
    orderImpl.setFulfillmentGroups(fulfillmentGroups);
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

    DefaultProcessContextImpl<Order> context = new DefaultProcessContextImpl<>();
    context.setSeedData(orderImpl);

    // Act
    ProcessContext<Order> actualExecuteResult = consolidateFulfillmentFeesActivity.execute(context);

    // Assert
    verify(sku).getFees();
    verify(skuFee).getAmount();
    verify(skuFee).getExpression();
    verify(skuFee).getFeeType();
    verify(skuFee).getName();
    verify(skuFee).getTaxable();
    verify(bundleOrderItemImpl).getSku();
    verify(fulfillmentGroupItem, atLeast(1)).getOrderItem();
    verify(fulfillmentGroupService).createFulfillmentGroupFee();
    verify(fulfillmentGroupService).save(isA(FulfillmentGroup.class));
    Order seedData = actualExecuteResult.getSeedData();
    List<FulfillmentGroup> fulfillmentGroups2 = seedData.getFulfillmentGroups();
    assertEquals(1, fulfillmentGroups2.size());
    FulfillmentGroup getResult = fulfillmentGroups2.get(0);
    assertTrue(getResult instanceof FulfillmentGroupImpl);
    assertTrue(seedData instanceof OrderImpl);
    assertTrue(actualExecuteResult instanceof DefaultProcessContextImpl);
    List<FulfillmentGroupFee> fulfillmentGroupFees = getResult.getFulfillmentGroupFees();
    assertEquals(2, fulfillmentGroupFees.size());
    assertSame(fulfillmentGroupFeeImpl, fulfillmentGroupFees.get(1));
  }

  /**
   * Test {@link ConsolidateFulfillmentFeesActivity#execute(ProcessContext)}.
   *
   * <ul>
   *   <li>Given {@link SkuFee} {@link SkuFee#getExpression()} return space space.
   *   <li>Then calls {@link SkuFee#getAmount()}.
   * </ul>
   *
   * <p>Method under test: {@link ConsolidateFulfillmentFeesActivity#execute(ProcessContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ProcessContext ConsolidateFulfillmentFeesActivity.execute(ProcessContext)"})
  public void testExecute_givenSkuFeeGetExpressionReturnSpaceSpace_thenCallsGetAmount()
      throws Exception {
    // Arrange
    FulfillmentGroupFeeImpl fulfillmentGroupFeeImpl = new FulfillmentGroupFeeImpl();
    when(fulfillmentGroupService.createFulfillmentGroupFee()).thenReturn(fulfillmentGroupFeeImpl);
    when(fulfillmentGroupService.save(Mockito.<FulfillmentGroup>any()))
        .thenReturn(new FulfillmentGroupImpl());

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    SkuFee skuFee = mock(SkuFee.class);
    when(skuFee.getExpression()).thenReturn("  ");
    when(skuFee.getTaxable()).thenReturn(true);
    when(skuFee.getName()).thenReturn("Name");
    when(skuFee.getAmount()).thenReturn(new Money());
    when(skuFee.getFeeType()).thenReturn(SkuFeeType.FULFILLMENT);

    ArrayList<SkuFee> skuFeeList = new ArrayList<>();
    skuFeeList.add(skuFee);

    Sku sku = mock(Sku.class);
    when(sku.getFees()).thenReturn(skuFeeList);

    BundleOrderItemImpl bundleOrderItemImpl = mock(BundleOrderItemImpl.class);
    when(bundleOrderItemImpl.getSku()).thenReturn(sku);

    FulfillmentGroupItemImpl fulfillmentGroupItem = mock(FulfillmentGroupItemImpl.class);
    when(fulfillmentGroupItem.getOrderItem()).thenReturn(bundleOrderItemImpl);

    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();
    fulfillmentGroupImpl.addFulfillmentGroupFee(new FulfillmentGroupFeeImpl());
    fulfillmentGroupImpl.addFulfillmentGroupItem(fulfillmentGroupItem);

    ArrayList<FulfillmentGroup> fulfillmentGroups = new ArrayList<>();
    fulfillmentGroups.add(fulfillmentGroupImpl);

    OrderImpl orderImpl = new OrderImpl();
    orderImpl.setAdditionalOfferInformation(new HashMap<>());
    orderImpl.setAuditable(auditable);
    orderImpl.setCandidateOrderOffers(new ArrayList<>());
    orderImpl.setCurrency(new BroadleafCurrencyImpl());
    orderImpl.setCustomer(new CustomerImpl());
    orderImpl.setEmailAddress("42 Main St");
    orderImpl.setFulfillmentGroups(fulfillmentGroups);
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

    DefaultProcessContextImpl<Order> context = new DefaultProcessContextImpl<>();
    context.setSeedData(orderImpl);

    // Act
    ProcessContext<Order> actualExecuteResult = consolidateFulfillmentFeesActivity.execute(context);

    // Assert
    verify(sku).getFees();
    verify(skuFee).getAmount();
    verify(skuFee).getExpression();
    verify(skuFee).getFeeType();
    verify(skuFee).getName();
    verify(skuFee).getTaxable();
    verify(bundleOrderItemImpl).getSku();
    verify(fulfillmentGroupItem, atLeast(1)).getOrderItem();
    verify(fulfillmentGroupService).createFulfillmentGroupFee();
    verify(fulfillmentGroupService).save(isA(FulfillmentGroup.class));
    Order seedData = actualExecuteResult.getSeedData();
    List<FulfillmentGroup> fulfillmentGroups2 = seedData.getFulfillmentGroups();
    assertEquals(1, fulfillmentGroups2.size());
    FulfillmentGroup getResult = fulfillmentGroups2.get(0);
    assertTrue(getResult instanceof FulfillmentGroupImpl);
    assertTrue(seedData instanceof OrderImpl);
    assertTrue(actualExecuteResult instanceof DefaultProcessContextImpl);
    List<FulfillmentGroupFee> fulfillmentGroupFees = getResult.getFulfillmentGroupFees();
    assertEquals(2, fulfillmentGroupFees.size());
    assertSame(fulfillmentGroupFeeImpl, fulfillmentGroupFees.get(1));
  }

  /**
   * Test {@link ConsolidateFulfillmentFeesActivity#execute(ProcessContext)}.
   *
   * <ul>
   *   <li>Given {@link SkuFee} {@link SkuFee#getFeeType()} return {@code null}.
   *   <li>Then calls {@link FulfillmentGroup#getFulfillmentGroupFees()}.
   * </ul>
   *
   * <p>Method under test: {@link ConsolidateFulfillmentFeesActivity#execute(ProcessContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ProcessContext ConsolidateFulfillmentFeesActivity.execute(ProcessContext)"})
  public void testExecute_givenSkuFeeGetFeeTypeReturnNull_thenCallsGetFulfillmentGroupFees()
      throws Exception {
    // Arrange
    ConsolidateFulfillmentFeesActivity consolidateFulfillmentFeesActivity =
        new ConsolidateFulfillmentFeesActivity();

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    SkuFee skuFee = mock(SkuFee.class);
    when(skuFee.getFeeType()).thenReturn(null);

    ArrayList<SkuFee> skuFeeList = new ArrayList<>();
    skuFeeList.add(skuFee);

    Sku sku = mock(Sku.class);
    when(sku.getFees()).thenReturn(skuFeeList);

    BundleOrderItemImpl orderItem = mock(BundleOrderItemImpl.class);
    when(orderItem.getSku()).thenReturn(sku);

    FulfillmentGroupItemImpl fulfillmentGroupItemImpl = new FulfillmentGroupItemImpl();
    fulfillmentGroupItemImpl.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupItemImpl.setId(1L);
    fulfillmentGroupItemImpl.setProratedOrderAdjustmentAmount(new Money());
    fulfillmentGroupItemImpl.setQuantity(1);
    fulfillmentGroupItemImpl.setStatus(FulfillmentGroupStatusType.CANCELLED);
    fulfillmentGroupItemImpl.setTaxes(new ArrayList<>());
    fulfillmentGroupItemImpl.setTotalItemAmount(new Money());
    fulfillmentGroupItemImpl.setTotalItemTaxableAmount(new Money());
    fulfillmentGroupItemImpl.setTotalTax(new Money());
    fulfillmentGroupItemImpl.setOrderItem(orderItem);

    ArrayList<FulfillmentGroupItem> fulfillmentGroupItemList = new ArrayList<>();
    fulfillmentGroupItemList.add(fulfillmentGroupItemImpl);

    FulfillmentGroup fulfillmentGroup = mock(FulfillmentGroup.class);
    when(fulfillmentGroup.getFulfillmentGroupItems()).thenReturn(fulfillmentGroupItemList);
    when(fulfillmentGroup.getFulfillmentGroupFees()).thenReturn(new ArrayList<>());

    ArrayList<FulfillmentGroup> fulfillmentGroups = new ArrayList<>();
    fulfillmentGroups.add(fulfillmentGroup);

    OrderImpl orderImpl = new OrderImpl();
    orderImpl.setAdditionalOfferInformation(new HashMap<>());
    orderImpl.setAuditable(auditable);
    orderImpl.setCandidateOrderOffers(new ArrayList<>());
    orderImpl.setCurrency(new BroadleafCurrencyImpl());
    orderImpl.setCustomer(new CustomerImpl());
    orderImpl.setEmailAddress("42 Main St");
    orderImpl.setFulfillmentGroups(fulfillmentGroups);
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

    DefaultProcessContextImpl<Order> context = new DefaultProcessContextImpl<>();
    context.setSeedData(orderImpl);

    // Act
    ProcessContext<Order> actualExecuteResult = consolidateFulfillmentFeesActivity.execute(context);

    // Assert
    verify(sku).getFees();
    verify(skuFee).getFeeType();
    verify(orderItem).getSku();
    verify(fulfillmentGroup).getFulfillmentGroupFees();
    verify(fulfillmentGroup).getFulfillmentGroupItems();
    assertSame(context, actualExecuteResult);
  }

  /**
   * Test {@link ConsolidateFulfillmentFeesActivity#execute(ProcessContext)}.
   *
   * <ul>
   *   <li>Then return {@link DefaultProcessContextImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link ConsolidateFulfillmentFeesActivity#execute(ProcessContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ProcessContext ConsolidateFulfillmentFeesActivity.execute(ProcessContext)"})
  public void testExecute_thenReturnDefaultProcessContextImpl() throws Exception {
    // Arrange
    ConsolidateFulfillmentFeesActivity consolidateFulfillmentFeesActivity =
        new ConsolidateFulfillmentFeesActivity();

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    OrderImpl orderImpl = new OrderImpl();
    orderImpl.setAdditionalOfferInformation(new HashMap<>());
    orderImpl.setAuditable(auditable);
    orderImpl.setCandidateOrderOffers(new ArrayList<>());
    orderImpl.setCurrency(new BroadleafCurrencyImpl());
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

    DefaultProcessContextImpl<Order> context = new DefaultProcessContextImpl<>();
    context.setSeedData(orderImpl);

    // Act
    ProcessContext<Order> actualExecuteResult = consolidateFulfillmentFeesActivity.execute(context);

    // Assert
    assertSame(context, actualExecuteResult);
  }

  /**
   * Test {@link ConsolidateFulfillmentFeesActivity#execute(ProcessContext)}.
   *
   * <ul>
   *   <li>Then return SeedData FulfillmentGroups first is {@link FulfillmentGroupImpl} (default
   *       constructor).
   * </ul>
   *
   * <p>Method under test: {@link ConsolidateFulfillmentFeesActivity#execute(ProcessContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ProcessContext ConsolidateFulfillmentFeesActivity.execute(ProcessContext)"})
  public void testExecute_thenReturnSeedDataFulfillmentGroupsFirstIsFulfillmentGroupImpl()
      throws Exception {
    // Arrange
    ConsolidateFulfillmentFeesActivity consolidateFulfillmentFeesActivity =
        new ConsolidateFulfillmentFeesActivity();

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    ArrayList<FulfillmentGroup> fulfillmentGroups = new ArrayList<>();
    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();
    fulfillmentGroups.add(fulfillmentGroupImpl);

    OrderImpl orderImpl = new OrderImpl();
    orderImpl.setAdditionalOfferInformation(new HashMap<>());
    orderImpl.setAuditable(auditable);
    orderImpl.setCandidateOrderOffers(new ArrayList<>());
    orderImpl.setCurrency(new BroadleafCurrencyImpl());
    orderImpl.setCustomer(new CustomerImpl());
    orderImpl.setEmailAddress("42 Main St");
    orderImpl.setFulfillmentGroups(fulfillmentGroups);
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

    DefaultProcessContextImpl<Order> context = new DefaultProcessContextImpl<>();
    context.setSeedData(orderImpl);

    // Act
    ProcessContext<Order> actualExecuteResult = consolidateFulfillmentFeesActivity.execute(context);

    // Assert
    Order seedData = actualExecuteResult.getSeedData();
    List<FulfillmentGroup> fulfillmentGroups2 = seedData.getFulfillmentGroups();
    assertEquals(1, fulfillmentGroups2.size());
    FulfillmentGroup getResult = fulfillmentGroups2.get(0);
    assertTrue(getResult instanceof FulfillmentGroupImpl);
    assertTrue(seedData instanceof OrderImpl);
    assertTrue(actualExecuteResult instanceof DefaultProcessContextImpl);
    assertSame(fulfillmentGroupImpl, getResult);
  }

  /**
   * Test {@link ConsolidateFulfillmentFeesActivity#shouldApplyFeeToFulfillmentGroup(SkuFee,
   * FulfillmentGroup)}.
   *
   * <p>Method under test: {@link
   * ConsolidateFulfillmentFeesActivity#shouldApplyFeeToFulfillmentGroup(SkuFee, FulfillmentGroup)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ConsolidateFulfillmentFeesActivity.shouldApplyFeeToFulfillmentGroup(SkuFee, FulfillmentGroup)"
  })
  public void testShouldApplyFeeToFulfillmentGroup() {
    // Arrange
    ConsolidateFulfillmentFeesActivity consolidateFulfillmentFeesActivity =
        new ConsolidateFulfillmentFeesActivity();

    SkuFeeImpl fee = new SkuFeeImpl();
    fee.setAmount(new Money());
    fee.setCurrency(new BroadleafCurrencyImpl());
    fee.setDescription("The characteristics of someone or something");
    fee.setFeeType(SkuFeeType.FULFILLMENT);
    fee.setId(1L);
    fee.setName("Name");
    fee.setSkus(new ArrayList<>());
    fee.setTaxable(true);
    fee.setExpression("Expressionorg.broadleafcommerce.core.catalog.domain.SkuFeeImpl");

    // Act and Assert
    assertTrue(
        consolidateFulfillmentFeesActivity.shouldApplyFeeToFulfillmentGroup(
            fee, new FulfillmentGroupImpl()));
  }

  /**
   * Test {@link ConsolidateFulfillmentFeesActivity#shouldApplyFeeToFulfillmentGroup(SkuFee,
   * FulfillmentGroup)}.
   *
   * <p>Method under test: {@link
   * ConsolidateFulfillmentFeesActivity#shouldApplyFeeToFulfillmentGroup(SkuFee, FulfillmentGroup)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ConsolidateFulfillmentFeesActivity.shouldApplyFeeToFulfillmentGroup(SkuFee, FulfillmentGroup)"
  })
  public void testShouldApplyFeeToFulfillmentGroup2() {
    // Arrange
    ConsolidateFulfillmentFeesActivity consolidateFulfillmentFeesActivity =
        new ConsolidateFulfillmentFeesActivity();

    SkuFeeImpl fee = new SkuFeeImpl();
    fee.setAmount(new Money());
    fee.setCurrency(new BroadleafCurrencyImpl());
    fee.setDescription("The characteristics of someone or something");
    fee.setFeeType(SkuFeeType.FULFILLMENT);
    fee.setId(1L);
    fee.setName("Name");
    fee.setSkus(new ArrayList<>());
    fee.setTaxable(true);
    fee.setExpression("getProductAttributes()[xx]getProductAttributes()[xx]");

    // Act and Assert
    assertTrue(
        consolidateFulfillmentFeesActivity.shouldApplyFeeToFulfillmentGroup(
            fee, new FulfillmentGroupImpl()));
  }

  /**
   * Test {@link ConsolidateFulfillmentFeesActivity#shouldApplyFeeToFulfillmentGroup(SkuFee,
   * FulfillmentGroup)}.
   *
   * <ul>
   *   <li>Given empty string.
   * </ul>
   *
   * <p>Method under test: {@link
   * ConsolidateFulfillmentFeesActivity#shouldApplyFeeToFulfillmentGroup(SkuFee, FulfillmentGroup)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ConsolidateFulfillmentFeesActivity.shouldApplyFeeToFulfillmentGroup(SkuFee, FulfillmentGroup)"
  })
  public void testShouldApplyFeeToFulfillmentGroup_givenEmptyString() {
    // Arrange
    ConsolidateFulfillmentFeesActivity consolidateFulfillmentFeesActivity =
        new ConsolidateFulfillmentFeesActivity();

    SkuFeeImpl fee = new SkuFeeImpl();
    fee.setAmount(new Money());
    fee.setCurrency(new BroadleafCurrencyImpl());
    fee.setDescription("The characteristics of someone or something");
    fee.setFeeType(SkuFeeType.FULFILLMENT);
    fee.setId(1L);
    fee.setName("Name");
    fee.setSkus(new ArrayList<>());
    fee.setTaxable(true);
    fee.setExpression("");

    // Act and Assert
    assertTrue(
        consolidateFulfillmentFeesActivity.shouldApplyFeeToFulfillmentGroup(
            fee, new FulfillmentGroupImpl()));
  }

  /**
   * Test {@link ConsolidateFulfillmentFeesActivity#shouldApplyFeeToFulfillmentGroup(SkuFee,
   * FulfillmentGroup)}.
   *
   * <ul>
   *   <li>Given {@code fulfillmentGroup}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ConsolidateFulfillmentFeesActivity#shouldApplyFeeToFulfillmentGroup(SkuFee, FulfillmentGroup)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ConsolidateFulfillmentFeesActivity.shouldApplyFeeToFulfillmentGroup(SkuFee, FulfillmentGroup)"
  })
  public void testShouldApplyFeeToFulfillmentGroup_givenFulfillmentGroup() {
    // Arrange
    ConsolidateFulfillmentFeesActivity consolidateFulfillmentFeesActivity =
        new ConsolidateFulfillmentFeesActivity();

    SkuFeeImpl fee = new SkuFeeImpl();
    fee.setAmount(new Money());
    fee.setCurrency(new BroadleafCurrencyImpl());
    fee.setDescription("The characteristics of someone or something");
    fee.setFeeType(SkuFeeType.FULFILLMENT);
    fee.setId(1L);
    fee.setName("Name");
    fee.setSkus(new ArrayList<>());
    fee.setTaxable(true);
    fee.setExpression("fulfillmentGroup");

    // Act and Assert
    assertTrue(
        consolidateFulfillmentFeesActivity.shouldApplyFeeToFulfillmentGroup(
            fee, new FulfillmentGroupImpl()));
  }

  /**
   * Test {@link ConsolidateFulfillmentFeesActivity#shouldApplyFeeToFulfillmentGroup(SkuFee,
   * FulfillmentGroup)}.
   *
   * <ul>
   *   <li>Given {@code fulfillmentGroupfulfillmentGroup}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ConsolidateFulfillmentFeesActivity#shouldApplyFeeToFulfillmentGroup(SkuFee, FulfillmentGroup)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ConsolidateFulfillmentFeesActivity.shouldApplyFeeToFulfillmentGroup(SkuFee, FulfillmentGroup)"
  })
  public void testShouldApplyFeeToFulfillmentGroup_givenFulfillmentGroupfulfillmentGroup() {
    // Arrange
    ConsolidateFulfillmentFeesActivity consolidateFulfillmentFeesActivity =
        new ConsolidateFulfillmentFeesActivity();

    SkuFeeImpl fee = new SkuFeeImpl();
    fee.setAmount(new Money());
    fee.setCurrency(new BroadleafCurrencyImpl());
    fee.setDescription("The characteristics of someone or something");
    fee.setFeeType(SkuFeeType.FULFILLMENT);
    fee.setId(1L);
    fee.setName("Name");
    fee.setSkus(new ArrayList<>());
    fee.setTaxable(true);
    fee.setExpression("fulfillmentGroupfulfillmentGroup");

    // Act and Assert
    assertTrue(
        consolidateFulfillmentFeesActivity.shouldApplyFeeToFulfillmentGroup(
            fee, new FulfillmentGroupImpl()));
  }

  /**
   * Test {@link ConsolidateFulfillmentFeesActivity#shouldApplyFeeToFulfillmentGroup(SkuFee,
   * FulfillmentGroup)}.
   *
   * <ul>
   *   <li>Given {@code MvelHelper}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ConsolidateFulfillmentFeesActivity#shouldApplyFeeToFulfillmentGroup(SkuFee, FulfillmentGroup)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ConsolidateFulfillmentFeesActivity.shouldApplyFeeToFulfillmentGroup(SkuFee, FulfillmentGroup)"
  })
  public void testShouldApplyFeeToFulfillmentGroup_givenMvelHelper() {
    // Arrange
    ConsolidateFulfillmentFeesActivity consolidateFulfillmentFeesActivity =
        new ConsolidateFulfillmentFeesActivity();

    SkuFeeImpl fee = new SkuFeeImpl();
    fee.setAmount(new Money());
    fee.setCurrency(new BroadleafCurrencyImpl());
    fee.setDescription("The characteristics of someone or something");
    fee.setFeeType(SkuFeeType.FULFILLMENT);
    fee.setId(1L);
    fee.setName("Name");
    fee.setSkus(new ArrayList<>());
    fee.setTaxable(true);
    fee.setExpression("MvelHelper");

    // Act and Assert
    assertTrue(
        consolidateFulfillmentFeesActivity.shouldApplyFeeToFulfillmentGroup(
            fee, new FulfillmentGroupImpl()));
  }

  /**
   * Test {@link ConsolidateFulfillmentFeesActivity#shouldApplyFeeToFulfillmentGroup(SkuFee,
   * FulfillmentGroup)}.
   *
   * <ul>
   *   <li>Given {@code not empty}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ConsolidateFulfillmentFeesActivity#shouldApplyFeeToFulfillmentGroup(SkuFee, FulfillmentGroup)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ConsolidateFulfillmentFeesActivity.shouldApplyFeeToFulfillmentGroup(SkuFee, FulfillmentGroup)"
  })
  public void testShouldApplyFeeToFulfillmentGroup_givenNotEmpty() {
    // Arrange
    ConsolidateFulfillmentFeesActivity consolidateFulfillmentFeesActivity =
        new ConsolidateFulfillmentFeesActivity();

    SkuFeeImpl fee = new SkuFeeImpl();
    fee.setAmount(new Money());
    fee.setCurrency(new BroadleafCurrencyImpl());
    fee.setDescription("The characteristics of someone or something");
    fee.setFeeType(SkuFeeType.FULFILLMENT);
    fee.setId(1L);
    fee.setName("Name");
    fee.setSkus(new ArrayList<>());
    fee.setTaxable(true);
    fee.setExpression("not empty");

    // Act and Assert
    assertTrue(
        consolidateFulfillmentFeesActivity.shouldApplyFeeToFulfillmentGroup(
            fee, new FulfillmentGroupImpl()));
  }

  /**
   * Test {@link ConsolidateFulfillmentFeesActivity#shouldApplyFeeToFulfillmentGroup(SkuFee,
   * FulfillmentGroup)}.
   *
   * <ul>
   *   <li>Given space space.
   * </ul>
   *
   * <p>Method under test: {@link
   * ConsolidateFulfillmentFeesActivity#shouldApplyFeeToFulfillmentGroup(SkuFee, FulfillmentGroup)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ConsolidateFulfillmentFeesActivity.shouldApplyFeeToFulfillmentGroup(SkuFee, FulfillmentGroup)"
  })
  public void testShouldApplyFeeToFulfillmentGroup_givenSpaceSpace() {
    // Arrange
    ConsolidateFulfillmentFeesActivity consolidateFulfillmentFeesActivity =
        new ConsolidateFulfillmentFeesActivity();

    SkuFeeImpl fee = new SkuFeeImpl();
    fee.setAmount(new Money());
    fee.setCurrency(new BroadleafCurrencyImpl());
    fee.setDescription("The characteristics of someone or something");
    fee.setFeeType(SkuFeeType.FULFILLMENT);
    fee.setId(1L);
    fee.setName("Name");
    fee.setSkus(new ArrayList<>());
    fee.setTaxable(true);
    fee.setExpression("  ");

    // Act and Assert
    assertTrue(
        consolidateFulfillmentFeesActivity.shouldApplyFeeToFulfillmentGroup(
            fee, new FulfillmentGroupImpl()));
  }

  /**
   * Test {@link ConsolidateFulfillmentFeesActivity#shouldApplyFeeToFulfillmentGroup(SkuFee,
   * FulfillmentGroup)}.
   *
   * <ul>
   *   <li>When {@link SkuFeeImpl} (default constructor).
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ConsolidateFulfillmentFeesActivity#shouldApplyFeeToFulfillmentGroup(SkuFee, FulfillmentGroup)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ConsolidateFulfillmentFeesActivity.shouldApplyFeeToFulfillmentGroup(SkuFee, FulfillmentGroup)"
  })
  public void testShouldApplyFeeToFulfillmentGroup_whenSkuFeeImpl_thenReturnTrue() {
    // Arrange
    ConsolidateFulfillmentFeesActivity consolidateFulfillmentFeesActivity =
        new ConsolidateFulfillmentFeesActivity();
    SkuFeeImpl fee = new SkuFeeImpl();

    // Act and Assert
    assertTrue(
        consolidateFulfillmentFeesActivity.shouldApplyFeeToFulfillmentGroup(
            fee, new FulfillmentGroupImpl()));
  }
}
