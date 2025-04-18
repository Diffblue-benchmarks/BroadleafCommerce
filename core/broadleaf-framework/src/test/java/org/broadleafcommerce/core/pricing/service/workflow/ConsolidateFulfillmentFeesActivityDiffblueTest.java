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

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
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
import org.broadleafcommerce.common.audit.Auditable;
import org.broadleafcommerce.common.currency.domain.BroadleafCurrencyImpl;
import org.broadleafcommerce.common.locale.domain.LocaleImpl;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.core.catalog.domain.SkuFee;
import org.broadleafcommerce.core.catalog.domain.SkuFeeImpl;
import org.broadleafcommerce.core.catalog.service.type.SkuFeeType;
import org.broadleafcommerce.core.order.domain.FulfillmentGroup;
import org.broadleafcommerce.core.order.domain.FulfillmentGroupImpl;
import org.broadleafcommerce.core.order.domain.Order;
import org.broadleafcommerce.core.order.domain.OrderImpl;
import org.broadleafcommerce.core.order.service.FulfillmentGroupService;
import org.broadleafcommerce.core.order.service.type.OrderStatus;
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
  @InjectMocks
  private ConsolidateFulfillmentFeesActivity consolidateFulfillmentFeesActivity;

  @Mock
  private FulfillmentGroupService fulfillmentGroupService;

  /**
   * Test {@link ConsolidateFulfillmentFeesActivity#execute(ProcessContext)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link FulfillmentGroupImpl} (default constructor).</li>
   *   <li>Then return {@link ProcessContext}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ConsolidateFulfillmentFeesActivity#execute(ProcessContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ProcessContext ConsolidateFulfillmentFeesActivity.execute(ProcessContext)"})
  public void testExecute_givenArrayListAddFulfillmentGroupImpl_thenReturnProcessContext() throws Exception {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    orderImpl.setSubmitDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    orderImpl.setTaxOverride(true);
    orderImpl.setTotal(new Money());
    orderImpl.setTotalFulfillmentCharges(new Money());
    orderImpl.setTotalTax(new Money());
    ProcessContext<Order> context = mock(ProcessContext.class);
    doNothing().when(context).setSeedData(Mockito.<Order>any());
    when(context.getSeedData()).thenReturn(orderImpl);

    // Act
    ProcessContext<Order> actualExecuteResult = consolidateFulfillmentFeesActivity.execute(context);

    // Assert
    verify(context).getSeedData();
    verify(context).setSeedData(isA(Order.class));
    assertSame(context, actualExecuteResult);
  }

  /**
   * Test {@link ConsolidateFulfillmentFeesActivity#execute(ProcessContext)}.
   * <ul>
   *   <li>Given {@link Auditable} (default constructor) CreatedBy is one.</li>
   *   <li>Then return {@link ProcessContext}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ConsolidateFulfillmentFeesActivity#execute(ProcessContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ProcessContext ConsolidateFulfillmentFeesActivity.execute(ProcessContext)"})
  public void testExecute_givenAuditableCreatedByIsOne_thenReturnProcessContext() throws Exception {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    orderImpl.setSubmitDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    orderImpl.setTaxOverride(true);
    orderImpl.setTotal(new Money());
    orderImpl.setTotalFulfillmentCharges(new Money());
    orderImpl.setTotalTax(new Money());
    ProcessContext<Order> context = mock(ProcessContext.class);
    doNothing().when(context).setSeedData(Mockito.<Order>any());
    when(context.getSeedData()).thenReturn(orderImpl);

    // Act
    ProcessContext<Order> actualExecuteResult = consolidateFulfillmentFeesActivity.execute(context);

    // Assert
    verify(context).getSeedData();
    verify(context).setSeedData(isA(Order.class));
    assertSame(context, actualExecuteResult);
  }

  /**
   * Test {@link ConsolidateFulfillmentFeesActivity#shouldApplyFeeToFulfillmentGroup(SkuFee, FulfillmentGroup)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link SkuFee} {@link SkuFee#getExpression()} return {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ConsolidateFulfillmentFeesActivity#shouldApplyFeeToFulfillmentGroup(SkuFee, FulfillmentGroup)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "boolean ConsolidateFulfillmentFeesActivity.shouldApplyFeeToFulfillmentGroup(SkuFee, FulfillmentGroup)"})
  public void testShouldApplyFeeToFulfillmentGroup_given42_whenSkuFeeGetExpressionReturn42() {
    // Arrange
    SkuFee fee = mock(SkuFee.class);
    when(fee.getExpression()).thenReturn("42");

    // Act
    boolean actualShouldApplyFeeToFulfillmentGroupResult = consolidateFulfillmentFeesActivity
        .shouldApplyFeeToFulfillmentGroup(fee, new FulfillmentGroupImpl());

    // Assert
    verify(fee).getExpression();
    assertTrue(actualShouldApplyFeeToFulfillmentGroupResult);
  }

  /**
   * Test {@link ConsolidateFulfillmentFeesActivity#shouldApplyFeeToFulfillmentGroup(SkuFee, FulfillmentGroup)}.
   * <ul>
   *   <li>Given empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link ConsolidateFulfillmentFeesActivity#shouldApplyFeeToFulfillmentGroup(SkuFee, FulfillmentGroup)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "boolean ConsolidateFulfillmentFeesActivity.shouldApplyFeeToFulfillmentGroup(SkuFee, FulfillmentGroup)"})
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
    assertTrue(consolidateFulfillmentFeesActivity.shouldApplyFeeToFulfillmentGroup(fee, new FulfillmentGroupImpl()));
  }

  /**
   * Test {@link ConsolidateFulfillmentFeesActivity#shouldApplyFeeToFulfillmentGroup(SkuFee, FulfillmentGroup)}.
   * <ul>
   *   <li>Given {@code Expression}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ConsolidateFulfillmentFeesActivity#shouldApplyFeeToFulfillmentGroup(SkuFee, FulfillmentGroup)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "boolean ConsolidateFulfillmentFeesActivity.shouldApplyFeeToFulfillmentGroup(SkuFee, FulfillmentGroup)"})
  public void testShouldApplyFeeToFulfillmentGroup_givenExpression() {
    // Arrange
    SkuFee fee = mock(SkuFee.class);
    when(fee.getExpression()).thenReturn("Expression");

    // Act
    boolean actualShouldApplyFeeToFulfillmentGroupResult = consolidateFulfillmentFeesActivity
        .shouldApplyFeeToFulfillmentGroup(fee, new FulfillmentGroupImpl());

    // Assert
    verify(fee).getExpression();
    assertTrue(actualShouldApplyFeeToFulfillmentGroupResult);
  }

  /**
   * Test {@link ConsolidateFulfillmentFeesActivity#shouldApplyFeeToFulfillmentGroup(SkuFee, FulfillmentGroup)}.
   * <ul>
   *   <li>Given {@code fulfillmentGroup}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ConsolidateFulfillmentFeesActivity#shouldApplyFeeToFulfillmentGroup(SkuFee, FulfillmentGroup)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "boolean ConsolidateFulfillmentFeesActivity.shouldApplyFeeToFulfillmentGroup(SkuFee, FulfillmentGroup)"})
  public void testShouldApplyFeeToFulfillmentGroup_givenFulfillmentGroup() {
    // Arrange
    SkuFee fee = mock(SkuFee.class);
    when(fee.getExpression()).thenReturn("fulfillmentGroup");

    // Act
    boolean actualShouldApplyFeeToFulfillmentGroupResult = consolidateFulfillmentFeesActivity
        .shouldApplyFeeToFulfillmentGroup(fee, new FulfillmentGroupImpl());

    // Assert
    verify(fee).getExpression();
    assertTrue(actualShouldApplyFeeToFulfillmentGroupResult);
  }

  /**
   * Test {@link ConsolidateFulfillmentFeesActivity#shouldApplyFeeToFulfillmentGroup(SkuFee, FulfillmentGroup)}.
   * <ul>
   *   <li>Given {@code fulfillmentGroup}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ConsolidateFulfillmentFeesActivity#shouldApplyFeeToFulfillmentGroup(SkuFee, FulfillmentGroup)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "boolean ConsolidateFulfillmentFeesActivity.shouldApplyFeeToFulfillmentGroup(SkuFee, FulfillmentGroup)"})
  public void testShouldApplyFeeToFulfillmentGroup_givenFulfillmentGroup2() {
    // Arrange
    SkuFee fee = mock(SkuFee.class);
    when(fee.getExpression()).thenReturn("fulfillmentGroup");

    // Act
    boolean actualShouldApplyFeeToFulfillmentGroupResult = consolidateFulfillmentFeesActivity
        .shouldApplyFeeToFulfillmentGroup(fee, null);

    // Assert
    verify(fee).getExpression();
    assertTrue(actualShouldApplyFeeToFulfillmentGroupResult);
  }

  /**
   * Test {@link ConsolidateFulfillmentFeesActivity#shouldApplyFeeToFulfillmentGroup(SkuFee, FulfillmentGroup)}.
   * <ul>
   *   <li>Given {@code getAdditionalAttributes()[UU]}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ConsolidateFulfillmentFeesActivity#shouldApplyFeeToFulfillmentGroup(SkuFee, FulfillmentGroup)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "boolean ConsolidateFulfillmentFeesActivity.shouldApplyFeeToFulfillmentGroup(SkuFee, FulfillmentGroup)"})
  public void testShouldApplyFeeToFulfillmentGroup_givenGetAdditionalAttributesUu() {
    // Arrange
    SkuFee fee = mock(SkuFee.class);
    when(fee.getExpression()).thenReturn("getAdditionalAttributes()[UU]");

    // Act
    boolean actualShouldApplyFeeToFulfillmentGroupResult = consolidateFulfillmentFeesActivity
        .shouldApplyFeeToFulfillmentGroup(fee, new FulfillmentGroupImpl());

    // Assert
    verify(fee).getExpression();
    assertTrue(actualShouldApplyFeeToFulfillmentGroupResult);
  }

  /**
   * Test {@link ConsolidateFulfillmentFeesActivity#shouldApplyFeeToFulfillmentGroup(SkuFee, FulfillmentGroup)}.
   * <ul>
   *   <li>Given {@code getAdditionalFields()[UU]}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ConsolidateFulfillmentFeesActivity#shouldApplyFeeToFulfillmentGroup(SkuFee, FulfillmentGroup)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "boolean ConsolidateFulfillmentFeesActivity.shouldApplyFeeToFulfillmentGroup(SkuFee, FulfillmentGroup)"})
  public void testShouldApplyFeeToFulfillmentGroup_givenGetAdditionalFieldsUu() {
    // Arrange
    SkuFee fee = mock(SkuFee.class);
    when(fee.getExpression()).thenReturn("getAdditionalFields()[UU]");

    // Act
    boolean actualShouldApplyFeeToFulfillmentGroupResult = consolidateFulfillmentFeesActivity
        .shouldApplyFeeToFulfillmentGroup(fee, new FulfillmentGroupImpl());

    // Assert
    verify(fee).getExpression();
    assertTrue(actualShouldApplyFeeToFulfillmentGroupResult);
  }

  /**
   * Test {@link ConsolidateFulfillmentFeesActivity#shouldApplyFeeToFulfillmentGroup(SkuFee, FulfillmentGroup)}.
   * <ul>
   *   <li>Given {@code getCategoryAttributesMap()[UU]}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ConsolidateFulfillmentFeesActivity#shouldApplyFeeToFulfillmentGroup(SkuFee, FulfillmentGroup)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "boolean ConsolidateFulfillmentFeesActivity.shouldApplyFeeToFulfillmentGroup(SkuFee, FulfillmentGroup)"})
  public void testShouldApplyFeeToFulfillmentGroup_givenGetCategoryAttributesMapUu() {
    // Arrange
    SkuFee fee = mock(SkuFee.class);
    when(fee.getExpression()).thenReturn("getCategoryAttributesMap()[UU]");

    // Act
    boolean actualShouldApplyFeeToFulfillmentGroupResult = consolidateFulfillmentFeesActivity
        .shouldApplyFeeToFulfillmentGroup(fee, new FulfillmentGroupImpl());

    // Assert
    verify(fee).getExpression();
    assertTrue(actualShouldApplyFeeToFulfillmentGroupResult);
  }

  /**
   * Test {@link ConsolidateFulfillmentFeesActivity#shouldApplyFeeToFulfillmentGroup(SkuFee, FulfillmentGroup)}.
   * <ul>
   *   <li>Given {@code getCustomerAttributes()[UU]}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ConsolidateFulfillmentFeesActivity#shouldApplyFeeToFulfillmentGroup(SkuFee, FulfillmentGroup)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "boolean ConsolidateFulfillmentFeesActivity.shouldApplyFeeToFulfillmentGroup(SkuFee, FulfillmentGroup)"})
  public void testShouldApplyFeeToFulfillmentGroup_givenGetCustomerAttributesUu() {
    // Arrange
    SkuFee fee = mock(SkuFee.class);
    when(fee.getExpression()).thenReturn("getCustomerAttributes()[UU]");

    // Act
    boolean actualShouldApplyFeeToFulfillmentGroupResult = consolidateFulfillmentFeesActivity
        .shouldApplyFeeToFulfillmentGroup(fee, new FulfillmentGroupImpl());

    // Assert
    verify(fee).getExpression();
    assertTrue(actualShouldApplyFeeToFulfillmentGroupResult);
  }

  /**
   * Test {@link ConsolidateFulfillmentFeesActivity#shouldApplyFeeToFulfillmentGroup(SkuFee, FulfillmentGroup)}.
   * <ul>
   *   <li>Given {@code getOrderItemAttributes()[UU]}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ConsolidateFulfillmentFeesActivity#shouldApplyFeeToFulfillmentGroup(SkuFee, FulfillmentGroup)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "boolean ConsolidateFulfillmentFeesActivity.shouldApplyFeeToFulfillmentGroup(SkuFee, FulfillmentGroup)"})
  public void testShouldApplyFeeToFulfillmentGroup_givenGetOrderItemAttributesUu() {
    // Arrange
    SkuFee fee = mock(SkuFee.class);
    when(fee.getExpression()).thenReturn("getOrderItemAttributes()[UU]");

    // Act
    boolean actualShouldApplyFeeToFulfillmentGroupResult = consolidateFulfillmentFeesActivity
        .shouldApplyFeeToFulfillmentGroup(fee, new FulfillmentGroupImpl());

    // Assert
    verify(fee).getExpression();
    assertTrue(actualShouldApplyFeeToFulfillmentGroupResult);
  }

  /**
   * Test {@link ConsolidateFulfillmentFeesActivity#shouldApplyFeeToFulfillmentGroup(SkuFee, FulfillmentGroup)}.
   * <ul>
   *   <li>Given {@code getProductAttributes()[UU]}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ConsolidateFulfillmentFeesActivity#shouldApplyFeeToFulfillmentGroup(SkuFee, FulfillmentGroup)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "boolean ConsolidateFulfillmentFeesActivity.shouldApplyFeeToFulfillmentGroup(SkuFee, FulfillmentGroup)"})
  public void testShouldApplyFeeToFulfillmentGroup_givenGetProductAttributesUu() {
    // Arrange
    SkuFee fee = mock(SkuFee.class);
    when(fee.getExpression()).thenReturn("getProductAttributes()[UU]");

    // Act
    boolean actualShouldApplyFeeToFulfillmentGroupResult = consolidateFulfillmentFeesActivity
        .shouldApplyFeeToFulfillmentGroup(fee, new FulfillmentGroupImpl());

    // Assert
    verify(fee).getExpression();
    assertTrue(actualShouldApplyFeeToFulfillmentGroupResult);
  }

  /**
   * Test {@link ConsolidateFulfillmentFeesActivity#shouldApplyFeeToFulfillmentGroup(SkuFee, FulfillmentGroup)}.
   * <ul>
   *   <li>Given {@code getSkuAttributes()[UU]}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ConsolidateFulfillmentFeesActivity#shouldApplyFeeToFulfillmentGroup(SkuFee, FulfillmentGroup)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "boolean ConsolidateFulfillmentFeesActivity.shouldApplyFeeToFulfillmentGroup(SkuFee, FulfillmentGroup)"})
  public void testShouldApplyFeeToFulfillmentGroup_givenGetSkuAttributesUu() {
    // Arrange
    SkuFee fee = mock(SkuFee.class);
    when(fee.getExpression()).thenReturn("getSkuAttributes()[UU]");

    // Act
    boolean actualShouldApplyFeeToFulfillmentGroupResult = consolidateFulfillmentFeesActivity
        .shouldApplyFeeToFulfillmentGroup(fee, new FulfillmentGroupImpl());

    // Assert
    verify(fee).getExpression();
    assertTrue(actualShouldApplyFeeToFulfillmentGroupResult);
  }

  /**
   * Test {@link ConsolidateFulfillmentFeesActivity#shouldApplyFeeToFulfillmentGroup(SkuFee, FulfillmentGroup)}.
   * <ul>
   *   <li>Given {@code MVEL}.</li>
   *   <li>When {@link SkuFee} {@link SkuFee#getExpression()} return {@code MVEL}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ConsolidateFulfillmentFeesActivity#shouldApplyFeeToFulfillmentGroup(SkuFee, FulfillmentGroup)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "boolean ConsolidateFulfillmentFeesActivity.shouldApplyFeeToFulfillmentGroup(SkuFee, FulfillmentGroup)"})
  public void testShouldApplyFeeToFulfillmentGroup_givenMvel_whenSkuFeeGetExpressionReturnMvel() {
    // Arrange
    SkuFee fee = mock(SkuFee.class);
    when(fee.getExpression()).thenReturn("MVEL");

    // Act
    boolean actualShouldApplyFeeToFulfillmentGroupResult = consolidateFulfillmentFeesActivity
        .shouldApplyFeeToFulfillmentGroup(fee, new FulfillmentGroupImpl());

    // Assert
    verify(fee).getExpression();
    assertTrue(actualShouldApplyFeeToFulfillmentGroupResult);
  }

  /**
   * Test {@link ConsolidateFulfillmentFeesActivity#shouldApplyFeeToFulfillmentGroup(SkuFee, FulfillmentGroup)}.
   * <ul>
   *   <li>Given {@code not empty}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ConsolidateFulfillmentFeesActivity#shouldApplyFeeToFulfillmentGroup(SkuFee, FulfillmentGroup)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "boolean ConsolidateFulfillmentFeesActivity.shouldApplyFeeToFulfillmentGroup(SkuFee, FulfillmentGroup)"})
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
    assertTrue(consolidateFulfillmentFeesActivity.shouldApplyFeeToFulfillmentGroup(fee, new FulfillmentGroupImpl()));
  }

  /**
   * Test {@link ConsolidateFulfillmentFeesActivity#shouldApplyFeeToFulfillmentGroup(SkuFee, FulfillmentGroup)}.
   * <ul>
   *   <li>When {@link SkuFeeImpl} (default constructor).</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ConsolidateFulfillmentFeesActivity#shouldApplyFeeToFulfillmentGroup(SkuFee, FulfillmentGroup)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "boolean ConsolidateFulfillmentFeesActivity.shouldApplyFeeToFulfillmentGroup(SkuFee, FulfillmentGroup)"})
  public void testShouldApplyFeeToFulfillmentGroup_whenSkuFeeImpl_thenReturnTrue() {
    // Arrange
    SkuFeeImpl fee = new SkuFeeImpl();

    // Act and Assert
    assertTrue(consolidateFulfillmentFeesActivity.shouldApplyFeeToFulfillmentGroup(fee, new FulfillmentGroupImpl()));
  }
}
