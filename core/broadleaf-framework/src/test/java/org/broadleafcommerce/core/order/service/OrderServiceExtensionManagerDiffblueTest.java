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
import static org.junit.Assert.assertTrue;
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
import org.broadleafcommerce.common.extension.ExtensionResultHolder;
import org.broadleafcommerce.common.extension.ExtensionResultStatusType;
import org.broadleafcommerce.common.locale.domain.LocaleImpl;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.core.offer.domain.OfferCode;
import org.broadleafcommerce.core.offer.domain.OfferCodeImpl;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.Order;
import org.broadleafcommerce.core.order.domain.OrderImpl;
import org.broadleafcommerce.core.order.service.call.OrderItemRequestDTO;
import org.broadleafcommerce.core.order.service.type.OrderStatus;
import org.broadleafcommerce.profile.core.domain.Customer;
import org.broadleafcommerce.profile.core.domain.CustomerImpl;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {OrderServiceExtensionManager.class})
@RunWith(SpringJUnit4ClassRunner.class)
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class OrderServiceExtensionManagerDiffblueTest {
  @Autowired
  private OrderServiceExtensionManager orderServiceExtensionManager;

  /**
   * Test {@link OrderServiceExtensionManager#continueOnHandled()}.
   * <p>
   * Method under test: {@link OrderServiceExtensionManager#continueOnHandled()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean OrderServiceExtensionManager.continueOnHandled()"})
  public void testContinueOnHandled() {
    // Arrange, Act and Assert
    assertTrue(orderServiceExtensionManager.continueOnHandled());
  }

  /**
   * Test {@link OrderServiceExtensionManager#attachAdditionalDataToNewNamedCart(Customer, Order)}.
   * <ul>
   *   <li>When {@link CustomerImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderServiceExtensionManager#attachAdditionalDataToNewNamedCart(Customer, Order)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "ExtensionResultStatusType OrderServiceExtensionManager.attachAdditionalDataToNewNamedCart(Customer, Order)"})
  public void testAttachAdditionalDataToNewNamedCart_whenCustomerImpl() {
    // Arrange
    CustomerImpl customer = new CustomerImpl();

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        orderServiceExtensionManager.attachAdditionalDataToNewNamedCart(customer, new NullOrderImpl()));
  }

  /**
   * Test {@link OrderServiceExtensionManager#attachAdditionalDataToNewNamedCart(Customer, Order)}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderServiceExtensionManager#attachAdditionalDataToNewNamedCart(Customer, Order)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "ExtensionResultStatusType OrderServiceExtensionManager.attachAdditionalDataToNewNamedCart(Customer, Order)"})
  public void testAttachAdditionalDataToNewNamedCart_whenNull() {
    // Arrange, Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        orderServiceExtensionManager.attachAdditionalDataToNewNamedCart(null, new NullOrderImpl()));
  }

  /**
   * Test {@link OrderServiceExtensionManager#preValidateCartOperation(Order, ExtensionResultHolder)}.
   * <ul>
   *   <li>Given {@link Auditable} (default constructor) CreatedBy is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderServiceExtensionManager#preValidateCartOperation(Order, ExtensionResultHolder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "ExtensionResultStatusType OrderServiceExtensionManager.preValidateCartOperation(Order, ExtensionResultHolder)"})
  public void testPreValidateCartOperation_givenAuditableCreatedByIsTwo() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(2L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(2L);

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
    cart.setName("priority");
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

    ExtensionResultHolder erh = new ExtensionResultHolder();
    erh.setResult("Result");
    erh.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        orderServiceExtensionManager.preValidateCartOperation(cart, erh));
  }

  /**
   * Test {@link OrderServiceExtensionManager#preValidateCartOperation(Order, ExtensionResultHolder)}.
   * <ul>
   *   <li>When {@link NullOrderImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderServiceExtensionManager#preValidateCartOperation(Order, ExtensionResultHolder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "ExtensionResultStatusType OrderServiceExtensionManager.preValidateCartOperation(Order, ExtensionResultHolder)"})
  public void testPreValidateCartOperation_whenNullOrderImpl() {
    // Arrange
    NullOrderImpl cart = new NullOrderImpl();

    ExtensionResultHolder erh = new ExtensionResultHolder();
    erh.setResult("Result");
    erh.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        orderServiceExtensionManager.preValidateCartOperation(cart, erh));
  }

  /**
   * Test {@link OrderServiceExtensionManager#preValidateUpdateQuantityOperation(Order, OrderItemRequestDTO, ExtensionResultHolder)}.
   * <ul>
   *   <li>Given {@link Auditable} (default constructor) CreatedBy is three.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderServiceExtensionManager#preValidateUpdateQuantityOperation(Order, OrderItemRequestDTO, ExtensionResultHolder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "ExtensionResultStatusType OrderServiceExtensionManager.preValidateUpdateQuantityOperation(Order, OrderItemRequestDTO, ExtensionResultHolder)"})
  public void testPreValidateUpdateQuantityOperation_givenAuditableCreatedByIsThree() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(3L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(3L);

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
    cart.setName("priority");
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
    OrderItemRequestDTO dto = new OrderItemRequestDTO();

    ExtensionResultHolder erh = new ExtensionResultHolder();
    erh.setResult("Result");
    erh.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        orderServiceExtensionManager.preValidateUpdateQuantityOperation(cart, dto, erh));
  }

  /**
   * Test {@link OrderServiceExtensionManager#preValidateUpdateQuantityOperation(Order, OrderItemRequestDTO, ExtensionResultHolder)}.
   * <ul>
   *   <li>When {@link NullOrderImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderServiceExtensionManager#preValidateUpdateQuantityOperation(Order, OrderItemRequestDTO, ExtensionResultHolder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "ExtensionResultStatusType OrderServiceExtensionManager.preValidateUpdateQuantityOperation(Order, OrderItemRequestDTO, ExtensionResultHolder)"})
  public void testPreValidateUpdateQuantityOperation_whenNullOrderImpl() {
    // Arrange
    NullOrderImpl cart = new NullOrderImpl();
    OrderItemRequestDTO dto = new OrderItemRequestDTO();

    ExtensionResultHolder erh = new ExtensionResultHolder();
    erh.setResult("Result");
    erh.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        orderServiceExtensionManager.preValidateUpdateQuantityOperation(cart, dto, erh));
  }

  /**
   * Test {@link OrderServiceExtensionManager#attachAdditionalDataToOrder(Order, boolean)}.
   * <ul>
   *   <li>Given {@link Auditable} (default constructor) CreatedBy is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderServiceExtensionManager#attachAdditionalDataToOrder(Order, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "ExtensionResultStatusType OrderServiceExtensionManager.attachAdditionalDataToOrder(Order, boolean)"})
  public void testAttachAdditionalDataToOrder_givenAuditableCreatedByIsTwo() {
    // Arrange
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
    order.setName("priority");
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
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        orderServiceExtensionManager.attachAdditionalDataToOrder(order, true));
  }

  /**
   * Test {@link OrderServiceExtensionManager#attachAdditionalDataToOrder(Order, boolean)}.
   * <ul>
   *   <li>When {@link NullOrderImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderServiceExtensionManager#attachAdditionalDataToOrder(Order, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "ExtensionResultStatusType OrderServiceExtensionManager.attachAdditionalDataToOrder(Order, boolean)"})
  public void testAttachAdditionalDataToOrder_whenNullOrderImpl() {
    // Arrange, Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        orderServiceExtensionManager.attachAdditionalDataToOrder(new NullOrderImpl(), true));
  }

  /**
   * Test {@link OrderServiceExtensionManager#addOfferCodes(Order, List, boolean)}.
   * <ul>
   *   <li>Given {@link Auditable} (default constructor) CreatedBy is three.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderServiceExtensionManager#addOfferCodes(Order, List, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ExtensionResultStatusType OrderServiceExtensionManager.addOfferCodes(Order, List, boolean)"})
  public void testAddOfferCodes_givenAuditableCreatedByIsThree() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(3L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(3L);

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
    order.setName("priority");
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
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        orderServiceExtensionManager.addOfferCodes(order, new ArrayList<>(), true));
  }

  /**
   * Test {@link OrderServiceExtensionManager#addOfferCodes(Order, List, boolean)}.
   * <ul>
   *   <li>Given {@link OfferCodeImpl} (default constructor).</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link OfferCodeImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderServiceExtensionManager#addOfferCodes(Order, List, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ExtensionResultStatusType OrderServiceExtensionManager.addOfferCodes(Order, List, boolean)"})
  public void testAddOfferCodes_givenOfferCodeImpl_whenArrayListAddOfferCodeImpl() {
    // Arrange
    NullOrderImpl order = new NullOrderImpl();

    ArrayList<OfferCode> offerCodes = new ArrayList<>();
    offerCodes.add(new OfferCodeImpl());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        orderServiceExtensionManager.addOfferCodes(order, offerCodes, true));
  }

  /**
   * Test {@link OrderServiceExtensionManager#addOfferCodes(Order, List, boolean)}.
   * <ul>
   *   <li>Given {@link OfferCodeImpl} (default constructor).</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link OfferCodeImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderServiceExtensionManager#addOfferCodes(Order, List, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ExtensionResultStatusType OrderServiceExtensionManager.addOfferCodes(Order, List, boolean)"})
  public void testAddOfferCodes_givenOfferCodeImpl_whenArrayListAddOfferCodeImpl2() {
    // Arrange
    NullOrderImpl order = new NullOrderImpl();

    ArrayList<OfferCode> offerCodes = new ArrayList<>();
    offerCodes.add(new OfferCodeImpl());
    offerCodes.add(new OfferCodeImpl());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        orderServiceExtensionManager.addOfferCodes(order, offerCodes, true));
  }

  /**
   * Test {@link OrderServiceExtensionManager#addOfferCodes(Order, List, boolean)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderServiceExtensionManager#addOfferCodes(Order, List, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ExtensionResultStatusType OrderServiceExtensionManager.addOfferCodes(Order, List, boolean)"})
  public void testAddOfferCodes_whenArrayList() {
    // Arrange
    NullOrderImpl order = new NullOrderImpl();

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        orderServiceExtensionManager.addOfferCodes(order, new ArrayList<>(), true));
  }

  /**
   * Test {@link OrderServiceExtensionManager#findCartForCustomerWithEnhancements(Customer, Order, ExtensionResultHolder)} with {@code customer}, {@code candidateCart}, {@code erh}.
   * <p>
   * Method under test: {@link OrderServiceExtensionManager#findCartForCustomerWithEnhancements(Customer, Order, ExtensionResultHolder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "ExtensionResultStatusType OrderServiceExtensionManager.findCartForCustomerWithEnhancements(Customer, Order, ExtensionResultHolder)"})
  public void testFindCartForCustomerWithEnhancementsWithCustomerCandidateCartErh() {
    // Arrange
    CustomerImpl customer = new CustomerImpl();
    NullOrderImpl candidateCart = new NullOrderImpl();

    ExtensionResultHolder erh = new ExtensionResultHolder();
    erh.setResult("Result");
    erh.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        orderServiceExtensionManager.findCartForCustomerWithEnhancements(customer, candidateCart, erh));
  }

  /**
   * Test {@link OrderServiceExtensionManager#findCartForCustomerWithEnhancements(Customer, Order, ExtensionResultHolder)} with {@code customer}, {@code candidateCart}, {@code erh}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderServiceExtensionManager#findCartForCustomerWithEnhancements(Customer, Order, ExtensionResultHolder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "ExtensionResultStatusType OrderServiceExtensionManager.findCartForCustomerWithEnhancements(Customer, Order, ExtensionResultHolder)"})
  public void testFindCartForCustomerWithEnhancementsWithCustomerCandidateCartErh_whenNull() {
    // Arrange
    NullOrderImpl candidateCart = new NullOrderImpl();

    ExtensionResultHolder erh = new ExtensionResultHolder();
    erh.setResult("Result");
    erh.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        orderServiceExtensionManager.findCartForCustomerWithEnhancements(null, candidateCart, erh));
  }

  /**
   * Test {@link OrderServiceExtensionManager#findCartForCustomerWithEnhancements(Customer, ExtensionResultHolder)} with {@code customer}, {@code erh}.
   * <ul>
   *   <li>When {@link CustomerImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderServiceExtensionManager#findCartForCustomerWithEnhancements(Customer, ExtensionResultHolder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "ExtensionResultStatusType OrderServiceExtensionManager.findCartForCustomerWithEnhancements(Customer, ExtensionResultHolder)"})
  public void testFindCartForCustomerWithEnhancementsWithCustomerErh_whenCustomerImpl() {
    // Arrange
    CustomerImpl customer = new CustomerImpl();

    ExtensionResultHolder erh = new ExtensionResultHolder();
    erh.setResult("Result");
    erh.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        orderServiceExtensionManager.findCartForCustomerWithEnhancements(customer, erh));
  }

  /**
   * Test {@link OrderServiceExtensionManager#findCartForCustomerWithEnhancements(Customer, ExtensionResultHolder)} with {@code customer}, {@code erh}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderServiceExtensionManager#findCartForCustomerWithEnhancements(Customer, ExtensionResultHolder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "ExtensionResultStatusType OrderServiceExtensionManager.findCartForCustomerWithEnhancements(Customer, ExtensionResultHolder)"})
  public void testFindCartForCustomerWithEnhancementsWithCustomerErh_whenNull() {
    // Arrange
    ExtensionResultHolder erh = new ExtensionResultHolder();
    erh.setResult("Result");
    erh.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        orderServiceExtensionManager.findCartForCustomerWithEnhancements(null, erh));
  }

  /**
   * Test {@link OrderServiceExtensionManager#isEnabled()}.
   * <p>
   * Method under test: {@link OrderServiceExtensionManager#isEnabled()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean OrderServiceExtensionManager.isEnabled()"})
  public void testIsEnabled() {
    // Arrange, Act and Assert
    assertTrue((new OrderServiceExtensionManager()).isEnabled());
  }
}
