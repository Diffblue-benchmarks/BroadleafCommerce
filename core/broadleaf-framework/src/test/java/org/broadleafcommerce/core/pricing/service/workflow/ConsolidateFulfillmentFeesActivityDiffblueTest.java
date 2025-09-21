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
   * <p>Method under test: {@link ConsolidateFulfillmentFeesActivity#execute(ProcessContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ProcessContext ConsolidateFulfillmentFeesActivity.execute(ProcessContext)"})
  public void testExecute2() throws Exception {
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

    SkuFee skuFee = mock(SkuFee.class);
    when(skuFee.getFeeType()).thenReturn(new SkuFeeType("fulfillmentGroup", "fulfillmentGroup"));

    ArrayList<SkuFee> skuFeeList = new ArrayList<>();
    skuFeeList.add(skuFee);

    Sku sku = mock(Sku.class);
    when(sku.getFees()).thenReturn(skuFeeList);

    BundleOrderItemImpl bundleOrderItemImpl = mock(BundleOrderItemImpl.class);
    when(bundleOrderItemImpl.getSku()).thenReturn(sku);

    FulfillmentGroupItemImpl fulfillmentGroupItem = mock(FulfillmentGroupItemImpl.class);
    when(fulfillmentGroupItem.getOrderItem()).thenReturn(bundleOrderItemImpl);

    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();
    FulfillmentGroupFeeImpl fulfillmentGroupFee = new FulfillmentGroupFeeImpl();
    fulfillmentGroupImpl.addFulfillmentGroupFee(fulfillmentGroupFee);
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
    verify(skuFee).getFeeType();
    verify(bundleOrderItemImpl).getSku();
    verify(fulfillmentGroupItem, atLeast(1)).getOrderItem();
    verify(fulfillmentGroupService).save(isA(FulfillmentGroup.class));
    Order seedData = actualExecuteResult.getSeedData();
    List<FulfillmentGroup> fulfillmentGroups2 = seedData.getFulfillmentGroups();
    assertEquals(1, fulfillmentGroups2.size());
    FulfillmentGroup getResult = fulfillmentGroups2.get(0);
    assertTrue(getResult instanceof FulfillmentGroupImpl);
    assertTrue(seedData instanceof OrderImpl);
    assertTrue(actualExecuteResult instanceof DefaultProcessContextImpl);
    List<FulfillmentGroupFee> fulfillmentGroupFees = getResult.getFulfillmentGroupFees();
    assertEquals(1, fulfillmentGroupFees.size());
    assertSame(fulfillmentGroupFee, fulfillmentGroupFees.get(0));
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
   *   <li>Given {@link Auditable} (default constructor) CreatedBy is one.
   *   <li>Then return {@link DefaultProcessContextImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link ConsolidateFulfillmentFeesActivity#execute(ProcessContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ProcessContext ConsolidateFulfillmentFeesActivity.execute(ProcessContext)"})
  public void testExecute_givenAuditableCreatedByIsOne_thenReturnDefaultProcessContextImpl()
      throws Exception {
    // Arrange
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
    when(fulfillmentGroupService.save(Mockito.<FulfillmentGroup>any()))
        .thenReturn(new FulfillmentGroupImpl());

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    BundleOrderItemImpl bundleOrderItemImpl = mock(BundleOrderItemImpl.class);
    when(bundleOrderItemImpl.getSku()).thenReturn(new SkuImpl());

    FulfillmentGroupItemImpl fulfillmentGroupItem = mock(FulfillmentGroupItemImpl.class);
    when(fulfillmentGroupItem.getOrderItem()).thenReturn(bundleOrderItemImpl);

    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();
    FulfillmentGroupFeeImpl fulfillmentGroupFee = new FulfillmentGroupFeeImpl();
    fulfillmentGroupImpl.addFulfillmentGroupFee(fulfillmentGroupFee);
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
    verify(bundleOrderItemImpl).getSku();
    verify(fulfillmentGroupItem, atLeast(1)).getOrderItem();
    verify(fulfillmentGroupService).save(isA(FulfillmentGroup.class));
    Order seedData = actualExecuteResult.getSeedData();
    List<FulfillmentGroup> fulfillmentGroups2 = seedData.getFulfillmentGroups();
    assertEquals(1, fulfillmentGroups2.size());
    FulfillmentGroup getResult = fulfillmentGroups2.get(0);
    assertTrue(getResult instanceof FulfillmentGroupImpl);
    assertTrue(seedData instanceof OrderImpl);
    assertTrue(actualExecuteResult instanceof DefaultProcessContextImpl);
    List<FulfillmentGroupFee> fulfillmentGroupFees = getResult.getFulfillmentGroupFees();
    assertEquals(1, fulfillmentGroupFees.size());
    assertSame(fulfillmentGroupFee, fulfillmentGroupFees.get(0));
  }

  /**
   * Test {@link ConsolidateFulfillmentFeesActivity#execute(ProcessContext)}.
   *
   * <ul>
   *   <li>Given {@link SkuFee} {@link SkuFee#getExpression()} return {@code 42}.
   *   <li>Then calls {@link SkuFee#getAmount()}.
   * </ul>
   *
   * <p>Method under test: {@link ConsolidateFulfillmentFeesActivity#execute(ProcessContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ProcessContext ConsolidateFulfillmentFeesActivity.execute(ProcessContext)"})
  public void testExecute_givenSkuFeeGetExpressionReturn42_thenCallsGetAmount() throws Exception {
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
    when(skuFee.getExpression()).thenReturn("42");
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
   *   <li>Given {@link SkuFee} {@link SkuFee#getExpression()} return {@code Expression}.
   *   <li>Then calls {@link SkuFee#getAmount()}.
   * </ul>
   *
   * <p>Method under test: {@link ConsolidateFulfillmentFeesActivity#execute(ProcessContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ProcessContext ConsolidateFulfillmentFeesActivity.execute(ProcessContext)"})
  public void testExecute_givenSkuFeeGetExpressionReturnExpression_thenCallsGetAmount()
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
    when(skuFee.getTaxable()).thenReturn(true);
    when(skuFee.getExpression()).thenReturn("Expression");
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
   *   <li>Given {@link SkuFee} {@link SkuFee#getFeeType()} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ConsolidateFulfillmentFeesActivity#execute(ProcessContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ProcessContext ConsolidateFulfillmentFeesActivity.execute(ProcessContext)"})
  public void testExecute_givenSkuFeeGetFeeTypeReturnNull() throws Exception {
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

    SkuFee skuFee = mock(SkuFee.class);
    when(skuFee.getFeeType()).thenReturn(null);

    ArrayList<SkuFee> skuFeeList = new ArrayList<>();
    skuFeeList.add(skuFee);

    Sku sku = mock(Sku.class);
    when(sku.getFees()).thenReturn(skuFeeList);

    BundleOrderItemImpl bundleOrderItemImpl = mock(BundleOrderItemImpl.class);
    when(bundleOrderItemImpl.getSku()).thenReturn(sku);

    FulfillmentGroupItemImpl fulfillmentGroupItem = mock(FulfillmentGroupItemImpl.class);
    when(fulfillmentGroupItem.getOrderItem()).thenReturn(bundleOrderItemImpl);

    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();
    FulfillmentGroupFeeImpl fulfillmentGroupFee = new FulfillmentGroupFeeImpl();
    fulfillmentGroupImpl.addFulfillmentGroupFee(fulfillmentGroupFee);
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
    verify(skuFee).getFeeType();
    verify(bundleOrderItemImpl).getSku();
    verify(fulfillmentGroupItem, atLeast(1)).getOrderItem();
    verify(fulfillmentGroupService).save(isA(FulfillmentGroup.class));
    Order seedData = actualExecuteResult.getSeedData();
    List<FulfillmentGroup> fulfillmentGroups2 = seedData.getFulfillmentGroups();
    assertEquals(1, fulfillmentGroups2.size());
    FulfillmentGroup getResult = fulfillmentGroups2.get(0);
    assertTrue(getResult instanceof FulfillmentGroupImpl);
    assertTrue(seedData instanceof OrderImpl);
    assertTrue(actualExecuteResult instanceof DefaultProcessContextImpl);
    List<FulfillmentGroupFee> fulfillmentGroupFees = getResult.getFulfillmentGroupFees();
    assertEquals(1, fulfillmentGroupFees.size());
    assertSame(fulfillmentGroupFee, fulfillmentGroupFees.get(0));
  }

  /**
   * Test {@link ConsolidateFulfillmentFeesActivity#execute(ProcessContext)}.
   *
   * <ul>
   *   <li>Then return SeedData FulfillmentGroups first FulfillmentGroupFees Empty.
   * </ul>
   *
   * <p>Method under test: {@link ConsolidateFulfillmentFeesActivity#execute(ProcessContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ProcessContext ConsolidateFulfillmentFeesActivity.execute(ProcessContext)"})
  public void testExecute_thenReturnSeedDataFulfillmentGroupsFirstFulfillmentGroupFeesEmpty()
      throws Exception {
    // Arrange
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
    List<FulfillmentGroupItem> fulfillmentGroupItems = getResult.getFulfillmentGroupItems();
    assertEquals(1, fulfillmentGroupItems.size());
    FulfillmentGroupItem getResult2 = fulfillmentGroupItems.get(0);
    assertTrue(getResult2 instanceof FulfillmentGroupItemImpl);
    assertTrue(seedData instanceof OrderImpl);
    assertTrue(actualExecuteResult instanceof DefaultProcessContextImpl);
    assertTrue(getResult.getFulfillmentGroupFees().isEmpty());
    assertSame(fulfillmentGroupItem, getResult2);
  }

  /**
   * Test {@link ConsolidateFulfillmentFeesActivity#execute(ProcessContext)}.
   *
   * <ul>
   *   <li>Then return SeedData FulfillmentGroups is {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link ConsolidateFulfillmentFeesActivity#execute(ProcessContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ProcessContext ConsolidateFulfillmentFeesActivity.execute(ProcessContext)"})
  public void testExecute_thenReturnSeedDataFulfillmentGroupsIsArrayList() throws Exception {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    ArrayList<FulfillmentGroup> fulfillmentGroups = new ArrayList<>();
    fulfillmentGroups.add(new FulfillmentGroupImpl());

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
    assertTrue(seedData instanceof OrderImpl);
    assertTrue(actualExecuteResult instanceof DefaultProcessContextImpl);
    assertSame(fulfillmentGroups, seedData.getFulfillmentGroups());
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
    SkuFeeImpl fee = new SkuFeeImpl();
    fee.setAmount(new Money());
    fee.setCurrency(new BroadleafCurrencyImpl());
    fee.setDescription("The characteristics of someone or something");
    fee.setFeeType(SkuFeeType.FULFILLMENT);
    fee.setId(1L);
    fee.setName("Name");
    fee.setSkus(new ArrayList<>());
    fee.setTaxable(true);
    fee.setExpression("org.broadleafcommerce.core.catalog.domain.SkuFeeImpl");

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
   *   <li>Given {@link ConsolidateFulfillmentFeesActivity} (default constructor).
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
  public void testShouldApplyFeeToFulfillmentGroup_givenConsolidateFulfillmentFeesActivity() {
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
   *   <li>Given {@code Fee}.
   *   <li>When {@link SkuFeeImpl} (default constructor) Expression is {@code Fee}.
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
  public void testShouldApplyFeeToFulfillmentGroup_givenFee_whenSkuFeeImplExpressionIsFee() {
    // Arrange
    SkuFeeImpl fee = new SkuFeeImpl();
    fee.setAmount(new Money());
    fee.setCurrency(new BroadleafCurrencyImpl());
    fee.setDescription("The characteristics of someone or something");
    fee.setFeeType(SkuFeeType.FULFILLMENT);
    fee.setId(1L);
    fee.setName("Name");
    fee.setSkus(new ArrayList<>());
    fee.setTaxable(true);
    fee.setExpression("Fee");

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
   *   <li>Given {@code getAdditionalAttributes()[UU]}.
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
  public void testShouldApplyFeeToFulfillmentGroup_givenGetAdditionalAttributesUu() {
    // Arrange
    SkuFeeImpl fee = new SkuFeeImpl();
    fee.setAmount(new Money());
    fee.setCurrency(new BroadleafCurrencyImpl());
    fee.setDescription("The characteristics of someone or something");
    fee.setFeeType(SkuFeeType.FULFILLMENT);
    fee.setId(1L);
    fee.setName("Name");
    fee.setSkus(new ArrayList<>());
    fee.setTaxable(true);
    fee.setExpression("getAdditionalAttributes()[UU]");

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
   *   <li>Given {@code getAdditionalFields()[UU]}.
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
  public void testShouldApplyFeeToFulfillmentGroup_givenGetAdditionalFieldsUu() {
    // Arrange
    SkuFeeImpl fee = new SkuFeeImpl();
    fee.setAmount(new Money());
    fee.setCurrency(new BroadleafCurrencyImpl());
    fee.setDescription("The characteristics of someone or something");
    fee.setFeeType(SkuFeeType.FULFILLMENT);
    fee.setId(1L);
    fee.setName("Name");
    fee.setSkus(new ArrayList<>());
    fee.setTaxable(true);
    fee.setExpression("getAdditionalFields()[UU]");

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
   *   <li>Given {@code getCategoryAttributesMap()[UU]}.
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
  public void testShouldApplyFeeToFulfillmentGroup_givenGetCategoryAttributesMapUu() {
    // Arrange
    SkuFeeImpl fee = new SkuFeeImpl();
    fee.setAmount(new Money());
    fee.setCurrency(new BroadleafCurrencyImpl());
    fee.setDescription("The characteristics of someone or something");
    fee.setFeeType(SkuFeeType.FULFILLMENT);
    fee.setId(1L);
    fee.setName("Name");
    fee.setSkus(new ArrayList<>());
    fee.setTaxable(true);
    fee.setExpression("getCategoryAttributesMap()[UU]");

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
   *   <li>Given {@code getCustomerAttributes()[UU]}.
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
  public void testShouldApplyFeeToFulfillmentGroup_givenGetCustomerAttributesUu() {
    // Arrange
    SkuFeeImpl fee = new SkuFeeImpl();
    fee.setAmount(new Money());
    fee.setCurrency(new BroadleafCurrencyImpl());
    fee.setDescription("The characteristics of someone or something");
    fee.setFeeType(SkuFeeType.FULFILLMENT);
    fee.setId(1L);
    fee.setName("Name");
    fee.setSkus(new ArrayList<>());
    fee.setTaxable(true);
    fee.setExpression("getCustomerAttributes()[UU]");

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
   *   <li>Given {@code getOrderItemAttributes()[UU]}.
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
  public void testShouldApplyFeeToFulfillmentGroup_givenGetOrderItemAttributesUu() {
    // Arrange
    SkuFeeImpl fee = new SkuFeeImpl();
    fee.setAmount(new Money());
    fee.setCurrency(new BroadleafCurrencyImpl());
    fee.setDescription("The characteristics of someone or something");
    fee.setFeeType(SkuFeeType.FULFILLMENT);
    fee.setId(1L);
    fee.setName("Name");
    fee.setSkus(new ArrayList<>());
    fee.setTaxable(true);
    fee.setExpression("getOrderItemAttributes()[UU]");

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
   *   <li>Given {@code getProductAttributes()[UU]}.
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
  public void testShouldApplyFeeToFulfillmentGroup_givenGetProductAttributesUu() {
    // Arrange
    SkuFeeImpl fee = new SkuFeeImpl();
    fee.setAmount(new Money());
    fee.setCurrency(new BroadleafCurrencyImpl());
    fee.setDescription("The characteristics of someone or something");
    fee.setFeeType(SkuFeeType.FULFILLMENT);
    fee.setId(1L);
    fee.setName("Name");
    fee.setSkus(new ArrayList<>());
    fee.setTaxable(true);
    fee.setExpression("getProductAttributes()[UU]");

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
   *   <li>Given {@code getSkuAttributes()[UU]}.
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
  public void testShouldApplyFeeToFulfillmentGroup_givenGetSkuAttributesUu() {
    // Arrange
    SkuFeeImpl fee = new SkuFeeImpl();
    fee.setAmount(new Money());
    fee.setCurrency(new BroadleafCurrencyImpl());
    fee.setDescription("The characteristics of someone or something");
    fee.setFeeType(SkuFeeType.FULFILLMENT);
    fee.setId(1L);
    fee.setName("Name");
    fee.setSkus(new ArrayList<>());
    fee.setTaxable(true);
    fee.setExpression("getSkuAttributes()[UU]");

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
   *   <li>Given {@code MVEL}.
   *   <li>When {@link SkuFeeImpl} (default constructor) Expression is {@code MVEL}.
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
  public void testShouldApplyFeeToFulfillmentGroup_givenMvel_whenSkuFeeImplExpressionIsMvel() {
    // Arrange
    SkuFeeImpl fee = new SkuFeeImpl();
    fee.setAmount(new Money());
    fee.setCurrency(new BroadleafCurrencyImpl());
    fee.setDescription("The characteristics of someone or something");
    fee.setFeeType(SkuFeeType.FULFILLMENT);
    fee.setId(1L);
    fee.setName("Name");
    fee.setSkus(new ArrayList<>());
    fee.setTaxable(true);
    fee.setExpression("MVEL");

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
    SkuFeeImpl fee = new SkuFeeImpl();

    // Act and Assert
    assertTrue(
        consolidateFulfillmentFeesActivity.shouldApplyFeeToFulfillmentGroup(
            fee, new FulfillmentGroupImpl()));
  }
}
