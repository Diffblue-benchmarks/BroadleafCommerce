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
package org.broadleafcommerce.core.offer.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import org.broadleafcommerce.common.audit.Auditable;
import org.broadleafcommerce.common.currency.domain.BroadleafCurrencyImpl;
import org.broadleafcommerce.common.locale.domain.LocaleImpl;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.Order;
import org.broadleafcommerce.core.order.domain.OrderImpl;
import org.broadleafcommerce.core.order.service.type.OrderStatus;
import org.broadleafcommerce.profile.core.domain.CustomerImpl;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class OrderAdjustmentImplDiffblueTest {
  @Autowired
  private OrderAdjustmentImpl orderAdjustmentImpl;

  /**
   * Test {@link OrderAdjustmentImpl#init(Order, Offer, String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then not {@link OrderAdjustmentImpl} (default constructor) {@link OrderAdjustmentImpl#isFutureCredit}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderAdjustmentImpl#init(Order, Offer, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OrderAdjustmentImpl.init(Order, Offer, String)"})
  public void testInit_whenNull_thenNotOrderAdjustmentImplIsFutureCredit() {
    // Arrange
    OrderAdjustmentImpl orderAdjustmentImpl2 = new OrderAdjustmentImpl();

    // Act
    orderAdjustmentImpl2.init(new NullOrderImpl(), null, "Just cause");

    // Assert that nothing has changed
    assertFalse(orderAdjustmentImpl2.isFutureCredit);
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link OrderAdjustmentImpl#setFutureCredit(Boolean)}
   *   <li>{@link OrderAdjustmentImpl#setId(Long)}
   *   <li>{@link OrderAdjustmentImpl#setOrder(Order)}
   *   <li>{@link OrderAdjustmentImpl#setReason(String)}
   *   <li>{@link OrderAdjustmentImpl#getId()}
   *   <li>{@link OrderAdjustmentImpl#getOrder()}
   *   <li>{@link OrderAdjustmentImpl#getReason()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Long OrderAdjustmentImpl.getId()", "Order OrderAdjustmentImpl.getOrder()",
      "String OrderAdjustmentImpl.getReason()", "void OrderAdjustmentImpl.setFutureCredit(Boolean)",
      "void OrderAdjustmentImpl.setId(Long)", "void OrderAdjustmentImpl.setOrder(Order)",
      "void OrderAdjustmentImpl.setReason(String)"})
  public void testGettersAndSetters() {
    // Arrange
    OrderAdjustmentImpl orderAdjustmentImpl = new OrderAdjustmentImpl();

    // Act
    orderAdjustmentImpl.setFutureCredit(true);
    orderAdjustmentImpl.setId(OrderAdjustmentImpl.serialVersionUID);
    NullOrderImpl order = new NullOrderImpl();
    orderAdjustmentImpl.setOrder(order);
    orderAdjustmentImpl.setReason("Just cause");
    Long actualId = orderAdjustmentImpl.getId();
    Order actualOrder = orderAdjustmentImpl.getOrder();

    // Assert
    assertEquals("Just cause", orderAdjustmentImpl.getReason());
    assertEquals(OrderAdjustmentImpl.serialVersionUID, actualId.longValue());
    assertSame(order, actualOrder);
  }

  /**
   * Test {@link OrderAdjustmentImpl#getOffer()}.
   * <p>
   * Method under test: {@link OrderAdjustmentImpl#getOffer()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Offer OrderAdjustmentImpl.getOffer()"})
  public void testGetOffer() {
    // Arrange, Act and Assert
    assertNull((new OrderAdjustmentImpl()).getOffer());
  }

  /**
   * Test {@link OrderAdjustmentImpl#setOffer(Offer)}.
   * <p>
   * Method under test: {@link OrderAdjustmentImpl#setOffer(Offer)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OrderAdjustmentImpl.setOffer(Offer)"})
  public void testSetOffer() {
    // Arrange
    OrderAdjustmentImpl orderAdjustmentImpl2 = new OrderAdjustmentImpl();
    OfferImpl offer = new OfferImpl();

    // Act
    orderAdjustmentImpl2.setOffer(offer);

    // Assert
    assertTrue(orderAdjustmentImpl2.offer instanceof OfferImpl);
    assertSame(offer, orderAdjustmentImpl2.getOffer());
    assertSame(offer, orderAdjustmentImpl2.deproxiedOffer);
  }

  /**
   * Test {@link OrderAdjustmentImpl#getValue()}.
   * <ul>
   *   <li>Given {@link Money} {@link Money#getAmount()} return {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderAdjustmentImpl#getValue()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money OrderAdjustmentImpl.getValue()"})
  public void testGetValue_givenMoneyGetAmountReturnNull_thenReturnNull() {
    // Arrange
    Money value = mock(Money.class);
    when(value.getAmount()).thenReturn(null);

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderAdjustmentImpl.serialVersionUID);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderAdjustmentImpl.serialVersionUID);

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
    order.setFulfillmentGroups(new ArrayList<>());
    order.setId(OrderAdjustmentImpl.serialVersionUID);
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
    order.setCurrency(null);

    OrderAdjustmentImpl orderAdjustmentImpl2 = new OrderAdjustmentImpl();
    orderAdjustmentImpl2.setFutureCredit(true);
    orderAdjustmentImpl2.setId(OrderAdjustmentImpl.serialVersionUID);
    orderAdjustmentImpl2.setReason("Just cause");
    orderAdjustmentImpl2.setValue(value);
    orderAdjustmentImpl2.setOrder(order);

    // Act
    Money actualValue = orderAdjustmentImpl2.getValue();

    // Assert
    verify(value).getAmount();
    assertNull(actualValue);
  }

  /**
   * Test {@link OrderAdjustmentImpl#getValue()}.
   * <ul>
   *   <li>Given {@link OrderImpl} (default constructor) Currency is {@code null}.</li>
   *   <li>Then return {@link Money#Money()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderAdjustmentImpl#getValue()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money OrderAdjustmentImpl.getValue()"})
  public void testGetValue_givenOrderImplCurrencyIsNull_thenReturnMoney() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderAdjustmentImpl.serialVersionUID);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderAdjustmentImpl.serialVersionUID);

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
    order.setFulfillmentGroups(new ArrayList<>());
    order.setId(OrderAdjustmentImpl.serialVersionUID);
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
    order.setCurrency(null);

    OrderAdjustmentImpl orderAdjustmentImpl2 = new OrderAdjustmentImpl();
    orderAdjustmentImpl2.setFutureCredit(true);
    orderAdjustmentImpl2.setId(OrderAdjustmentImpl.serialVersionUID);
    orderAdjustmentImpl2.setReason("Just cause");
    Money value = new Money();
    orderAdjustmentImpl2.setValue(value);
    orderAdjustmentImpl2.setOrder(order);

    // Act and Assert
    assertEquals(value, orderAdjustmentImpl2.getValue());
  }

  /**
   * Test {@link OrderAdjustmentImpl#setValue(Money)}.
   * <ul>
   *   <li>Then {@link OrderAdjustmentImpl} (default constructor) {@link OrderAdjustmentImpl#value} is {@link BigDecimal#BigDecimal(String)} with {@code 2.3}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderAdjustmentImpl#setValue(Money)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OrderAdjustmentImpl.setValue(Money)"})
  public void testSetValue_thenOrderAdjustmentImplValueIsBigDecimalWith23() {
    // Arrange
    OrderAdjustmentImpl orderAdjustmentImpl2 = new OrderAdjustmentImpl();
    Money value = mock(Money.class);
    when(value.getAmount()).thenReturn(new BigDecimal("2.3"));

    // Act
    orderAdjustmentImpl2.setValue(value);

    // Assert
    verify(value).getAmount();
    assertEquals(new BigDecimal("2.3"), orderAdjustmentImpl2.value);
  }

  /**
   * Test {@link OrderAdjustmentImpl#setValue(Money)}.
   * <ul>
   *   <li>When {@link Money#Money()}.</li>
   *   <li>Then {@link OrderAdjustmentImpl} (default constructor) {@link OrderAdjustmentImpl#value} is {@link BigDecimal#BigDecimal(String)} with {@code 0.00}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderAdjustmentImpl#setValue(Money)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OrderAdjustmentImpl.setValue(Money)"})
  public void testSetValue_whenMoney_thenOrderAdjustmentImplValueIsBigDecimalWith000() {
    // Arrange
    OrderAdjustmentImpl orderAdjustmentImpl2 = new OrderAdjustmentImpl();

    // Act
    orderAdjustmentImpl2.setValue(new Money());

    // Assert that nothing has changed
    assertEquals(new BigDecimal("0.00"), orderAdjustmentImpl2.value);
  }

  /**
   * Test {@link OrderAdjustmentImpl#getCurrencyCode()}.
   * <ul>
   *   <li>Given {@link OrderImpl} (default constructor) Currency is {@link BroadleafCurrencyImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderAdjustmentImpl#getCurrencyCode()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String OrderAdjustmentImpl.getCurrencyCode()"})
  public void testGetCurrencyCode_givenOrderImplCurrencyIsBroadleafCurrencyImpl_thenReturnNull() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderAdjustmentImpl.serialVersionUID);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderAdjustmentImpl.serialVersionUID);

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
    order.setFulfillmentGroups(new ArrayList<>());
    order.setId(OrderAdjustmentImpl.serialVersionUID);
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
    order.setCurrency(new BroadleafCurrencyImpl());

    OrderAdjustmentImpl orderAdjustmentImpl2 = new OrderAdjustmentImpl();
    orderAdjustmentImpl2.setFutureCredit(true);
    orderAdjustmentImpl2.setId(OrderAdjustmentImpl.serialVersionUID);
    orderAdjustmentImpl2.setReason("Just cause");
    orderAdjustmentImpl2.setValue(new Money());
    orderAdjustmentImpl2.setOrder(order);

    // Act and Assert
    assertNull(orderAdjustmentImpl2.getCurrencyCode());
  }

  /**
   * Test {@link OrderAdjustmentImpl#getCurrencyCode()}.
   * <ul>
   *   <li>Given {@link OrderImpl} (default constructor) Currency is {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderAdjustmentImpl#getCurrencyCode()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String OrderAdjustmentImpl.getCurrencyCode()"})
  public void testGetCurrencyCode_givenOrderImplCurrencyIsNull_thenReturnNull() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderAdjustmentImpl.serialVersionUID);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderAdjustmentImpl.serialVersionUID);

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
    order.setFulfillmentGroups(new ArrayList<>());
    order.setId(OrderAdjustmentImpl.serialVersionUID);
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
    order.setCurrency(null);

    OrderAdjustmentImpl orderAdjustmentImpl2 = new OrderAdjustmentImpl();
    orderAdjustmentImpl2.setFutureCredit(true);
    orderAdjustmentImpl2.setId(OrderAdjustmentImpl.serialVersionUID);
    orderAdjustmentImpl2.setReason("Just cause");
    orderAdjustmentImpl2.setValue(new Money());
    orderAdjustmentImpl2.setOrder(order);

    // Act and Assert
    assertNull(orderAdjustmentImpl2.getCurrencyCode());
  }

  /**
   * Test {@link OrderAdjustmentImpl#isFutureCredit()}.
   * <ul>
   *   <li>Given {@link OrderAdjustmentImpl} (default constructor) FutureCredit is {@code null}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderAdjustmentImpl#isFutureCredit()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Boolean OrderAdjustmentImpl.isFutureCredit()"})
  public void testIsFutureCredit_givenOrderAdjustmentImplFutureCreditIsNull_thenReturnFalse() {
    // Arrange
    OrderAdjustmentImpl orderAdjustmentImpl2 = new OrderAdjustmentImpl();
    orderAdjustmentImpl2.setId(OrderAdjustmentImpl.serialVersionUID);
    orderAdjustmentImpl2.setOrder(new NullOrderImpl());
    orderAdjustmentImpl2.setReason("Just cause");
    orderAdjustmentImpl2.setValue(new Money());
    orderAdjustmentImpl2.setFutureCredit(null);

    // Act and Assert
    assertFalse(orderAdjustmentImpl2.isFutureCredit());
  }

  /**
   * Test {@link OrderAdjustmentImpl#isFutureCredit()}.
   * <ul>
   *   <li>Given {@link OrderAdjustmentImpl} (default constructor) FutureCredit is {@code true}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderAdjustmentImpl#isFutureCredit()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Boolean OrderAdjustmentImpl.isFutureCredit()"})
  public void testIsFutureCredit_givenOrderAdjustmentImplFutureCreditIsTrue_thenReturnTrue() {
    // Arrange
    OrderAdjustmentImpl orderAdjustmentImpl2 = new OrderAdjustmentImpl();
    orderAdjustmentImpl2.setId(OrderAdjustmentImpl.serialVersionUID);
    orderAdjustmentImpl2.setOrder(new NullOrderImpl());
    orderAdjustmentImpl2.setReason("Just cause");
    orderAdjustmentImpl2.setValue(new Money());
    orderAdjustmentImpl2.setFutureCredit(true);

    // Act and Assert
    assertTrue(orderAdjustmentImpl2.isFutureCredit());
  }

  /**
   * Test {@link OrderAdjustmentImpl#isFutureCredit()}.
   * <ul>
   *   <li>Given {@link OrderAdjustmentImpl} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderAdjustmentImpl#isFutureCredit()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Boolean OrderAdjustmentImpl.isFutureCredit()"})
  public void testIsFutureCredit_givenOrderAdjustmentImpl_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new OrderAdjustmentImpl()).isFutureCredit());
  }

  /**
   * Test {@link OrderAdjustmentImpl#equals(Object)}, and {@link OrderAdjustmentImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link OrderAdjustmentImpl#equals(Object)}
   *   <li>{@link OrderAdjustmentImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean OrderAdjustmentImpl.equals(Object)", "int OrderAdjustmentImpl.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    OrderAdjustmentImpl orderAdjustmentImpl = new OrderAdjustmentImpl();
    orderAdjustmentImpl.setFutureCredit(true);
    orderAdjustmentImpl.setId(OrderAdjustmentImpl.serialVersionUID);
    orderAdjustmentImpl.setOrder(new NullOrderImpl());
    orderAdjustmentImpl.setReason("Just cause");
    orderAdjustmentImpl.setValue(new Money());

    OrderAdjustmentImpl orderAdjustmentImpl2 = new OrderAdjustmentImpl();
    orderAdjustmentImpl2.setFutureCredit(true);
    orderAdjustmentImpl2.setId(OrderAdjustmentImpl.serialVersionUID);
    orderAdjustmentImpl2.setOrder(new NullOrderImpl());
    orderAdjustmentImpl2.setReason("Just cause");
    orderAdjustmentImpl2.setValue(new Money());

    // Act and Assert
    assertEquals(orderAdjustmentImpl, orderAdjustmentImpl2);
    int notExpectedHashCodeResult = orderAdjustmentImpl.hashCode();
    assertNotEquals(notExpectedHashCodeResult, orderAdjustmentImpl2.hashCode());
  }

  /**
   * Test {@link OrderAdjustmentImpl#equals(Object)}, and {@link OrderAdjustmentImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link OrderAdjustmentImpl#equals(Object)}
   *   <li>{@link OrderAdjustmentImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean OrderAdjustmentImpl.equals(Object)", "int OrderAdjustmentImpl.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    OrderAdjustmentImpl orderAdjustmentImpl = new OrderAdjustmentImpl();
    orderAdjustmentImpl.setFutureCredit(true);
    orderAdjustmentImpl.setId(null);
    orderAdjustmentImpl.setOrder(null);
    orderAdjustmentImpl.setReason("Just cause");
    orderAdjustmentImpl.setValue(new Money());

    OrderAdjustmentImpl orderAdjustmentImpl2 = new OrderAdjustmentImpl();
    orderAdjustmentImpl2.setFutureCredit(true);
    orderAdjustmentImpl2.setId(OrderAdjustmentImpl.serialVersionUID);
    orderAdjustmentImpl2.setOrder(null);
    orderAdjustmentImpl2.setReason("Just cause");
    orderAdjustmentImpl2.setValue(new Money());

    // Act and Assert
    assertEquals(orderAdjustmentImpl, orderAdjustmentImpl2);
    int expectedHashCodeResult = orderAdjustmentImpl.hashCode();
    assertEquals(expectedHashCodeResult, orderAdjustmentImpl2.hashCode());
  }

  /**
   * Test {@link OrderAdjustmentImpl#equals(Object)}, and {@link OrderAdjustmentImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link OrderAdjustmentImpl#equals(Object)}
   *   <li>{@link OrderAdjustmentImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean OrderAdjustmentImpl.equals(Object)", "int OrderAdjustmentImpl.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    Money value = mock(Money.class);
    when(value.getAmount()).thenReturn(null);

    OrderAdjustmentImpl orderAdjustmentImpl = new OrderAdjustmentImpl();
    orderAdjustmentImpl.setFutureCredit(true);
    orderAdjustmentImpl.setId(null);
    orderAdjustmentImpl.setOrder(null);
    orderAdjustmentImpl.setReason("Just cause");
    orderAdjustmentImpl.setValue(value);
    Money value2 = mock(Money.class);
    when(value2.getAmount()).thenReturn(null);

    OrderAdjustmentImpl orderAdjustmentImpl2 = new OrderAdjustmentImpl();
    orderAdjustmentImpl2.setFutureCredit(true);
    orderAdjustmentImpl2.setId(OrderAdjustmentImpl.serialVersionUID);
    orderAdjustmentImpl2.setOrder(null);
    orderAdjustmentImpl2.setReason("Just cause");
    orderAdjustmentImpl2.setValue(value2);

    // Act and Assert
    assertEquals(orderAdjustmentImpl, orderAdjustmentImpl2);
    int expectedHashCodeResult = orderAdjustmentImpl.hashCode();
    assertEquals(expectedHashCodeResult, orderAdjustmentImpl2.hashCode());
  }

  /**
   * Test {@link OrderAdjustmentImpl#equals(Object)}, and {@link OrderAdjustmentImpl#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link OrderAdjustmentImpl#equals(Object)}
   *   <li>{@link OrderAdjustmentImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean OrderAdjustmentImpl.equals(Object)", "int OrderAdjustmentImpl.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    OrderAdjustmentImpl orderAdjustmentImpl = new OrderAdjustmentImpl();
    orderAdjustmentImpl.setFutureCredit(true);
    orderAdjustmentImpl.setId(OrderAdjustmentImpl.serialVersionUID);
    orderAdjustmentImpl.setOrder(new NullOrderImpl());
    orderAdjustmentImpl.setReason("Just cause");
    orderAdjustmentImpl.setValue(new Money());

    // Act and Assert
    assertEquals(orderAdjustmentImpl, orderAdjustmentImpl);
    int expectedHashCodeResult = orderAdjustmentImpl.hashCode();
    assertEquals(expectedHashCodeResult, orderAdjustmentImpl.hashCode());
  }

  /**
   * Test {@link OrderAdjustmentImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderAdjustmentImpl#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean OrderAdjustmentImpl.equals(Object)", "int OrderAdjustmentImpl.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    OrderAdjustmentImpl orderAdjustmentImpl = new OrderAdjustmentImpl();
    orderAdjustmentImpl.setFutureCredit(true);
    orderAdjustmentImpl.setId(2L);
    orderAdjustmentImpl.setOrder(new NullOrderImpl());
    orderAdjustmentImpl.setReason("Just cause");
    orderAdjustmentImpl.setValue(new Money());

    OrderAdjustmentImpl orderAdjustmentImpl2 = new OrderAdjustmentImpl();
    orderAdjustmentImpl2.setFutureCredit(true);
    orderAdjustmentImpl2.setId(OrderAdjustmentImpl.serialVersionUID);
    orderAdjustmentImpl2.setOrder(new NullOrderImpl());
    orderAdjustmentImpl2.setReason("Just cause");
    orderAdjustmentImpl2.setValue(new Money());

    // Act and Assert
    assertNotEquals(orderAdjustmentImpl, orderAdjustmentImpl2);
  }

  /**
   * Test {@link OrderAdjustmentImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderAdjustmentImpl#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean OrderAdjustmentImpl.equals(Object)", "int OrderAdjustmentImpl.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    OrderAdjustmentImpl orderAdjustmentImpl = new OrderAdjustmentImpl();
    orderAdjustmentImpl.setFutureCredit(true);
    orderAdjustmentImpl.setId(null);
    orderAdjustmentImpl.setOrder(new NullOrderImpl());
    orderAdjustmentImpl.setReason("Just cause");
    orderAdjustmentImpl.setValue(new Money());

    OrderAdjustmentImpl orderAdjustmentImpl2 = new OrderAdjustmentImpl();
    orderAdjustmentImpl2.setFutureCredit(true);
    orderAdjustmentImpl2.setId(OrderAdjustmentImpl.serialVersionUID);
    orderAdjustmentImpl2.setOrder(new NullOrderImpl());
    orderAdjustmentImpl2.setReason("Just cause");
    orderAdjustmentImpl2.setValue(new Money());

    // Act and Assert
    assertNotEquals(orderAdjustmentImpl, orderAdjustmentImpl2);
  }

  /**
   * Test {@link OrderAdjustmentImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderAdjustmentImpl#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean OrderAdjustmentImpl.equals(Object)", "int OrderAdjustmentImpl.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    OrderAdjustmentImpl orderAdjustmentImpl = new OrderAdjustmentImpl();
    orderAdjustmentImpl.setFutureCredit(true);
    orderAdjustmentImpl.setId(OrderAdjustmentImpl.serialVersionUID);
    orderAdjustmentImpl.setOrder(new NullOrderImpl());
    orderAdjustmentImpl.setReason("Just cause");
    orderAdjustmentImpl.setValue(new Money());

    OrderAdjustmentImpl orderAdjustmentImpl2 = new OrderAdjustmentImpl();
    orderAdjustmentImpl2.setFutureCredit(true);
    orderAdjustmentImpl2.setId(null);
    orderAdjustmentImpl2.setOrder(new NullOrderImpl());
    orderAdjustmentImpl2.setReason("Just cause");
    orderAdjustmentImpl2.setValue(new Money());

    // Act and Assert
    assertNotEquals(orderAdjustmentImpl, orderAdjustmentImpl2);
  }

  /**
   * Test {@link OrderAdjustmentImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderAdjustmentImpl#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean OrderAdjustmentImpl.equals(Object)", "int OrderAdjustmentImpl.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    OrderAdjustmentImpl orderAdjustmentImpl = new OrderAdjustmentImpl();
    orderAdjustmentImpl.setFutureCredit(true);
    orderAdjustmentImpl.setId(null);
    orderAdjustmentImpl.setOrder(null);
    orderAdjustmentImpl.setReason("Just cause");
    orderAdjustmentImpl.setValue(new Money());

    OrderAdjustmentImpl orderAdjustmentImpl2 = new OrderAdjustmentImpl();
    orderAdjustmentImpl2.setFutureCredit(true);
    orderAdjustmentImpl2.setId(OrderAdjustmentImpl.serialVersionUID);
    orderAdjustmentImpl2.setOrder(new NullOrderImpl());
    orderAdjustmentImpl2.setReason("Just cause");
    orderAdjustmentImpl2.setValue(new Money());

    // Act and Assert
    assertNotEquals(orderAdjustmentImpl, orderAdjustmentImpl2);
  }

  /**
   * Test {@link OrderAdjustmentImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderAdjustmentImpl#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean OrderAdjustmentImpl.equals(Object)", "int OrderAdjustmentImpl.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    OrderAdjustmentImpl orderAdjustmentImpl = new OrderAdjustmentImpl();
    orderAdjustmentImpl.setFutureCredit(false);
    orderAdjustmentImpl.setId(null);
    orderAdjustmentImpl.setOrder(null);
    orderAdjustmentImpl.setReason("Just cause");
    orderAdjustmentImpl.setValue(new Money());

    OrderAdjustmentImpl orderAdjustmentImpl2 = new OrderAdjustmentImpl();
    orderAdjustmentImpl2.setFutureCredit(true);
    orderAdjustmentImpl2.setId(OrderAdjustmentImpl.serialVersionUID);
    orderAdjustmentImpl2.setOrder(null);
    orderAdjustmentImpl2.setReason("Just cause");
    orderAdjustmentImpl2.setValue(new Money());

    // Act and Assert
    assertNotEquals(orderAdjustmentImpl, orderAdjustmentImpl2);
  }

  /**
   * Test {@link OrderAdjustmentImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderAdjustmentImpl#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean OrderAdjustmentImpl.equals(Object)", "int OrderAdjustmentImpl.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    OrderAdjustmentImpl orderAdjustmentImpl = new OrderAdjustmentImpl();
    orderAdjustmentImpl.setFutureCredit(true);
    orderAdjustmentImpl.setId(null);
    orderAdjustmentImpl.setOrder(null);
    orderAdjustmentImpl.setReason("Reason");
    orderAdjustmentImpl.setValue(new Money());

    OrderAdjustmentImpl orderAdjustmentImpl2 = new OrderAdjustmentImpl();
    orderAdjustmentImpl2.setFutureCredit(true);
    orderAdjustmentImpl2.setId(OrderAdjustmentImpl.serialVersionUID);
    orderAdjustmentImpl2.setOrder(null);
    orderAdjustmentImpl2.setReason("Just cause");
    orderAdjustmentImpl2.setValue(new Money());

    // Act and Assert
    assertNotEquals(orderAdjustmentImpl, orderAdjustmentImpl2);
  }

  /**
   * Test {@link OrderAdjustmentImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderAdjustmentImpl#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean OrderAdjustmentImpl.equals(Object)", "int OrderAdjustmentImpl.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    OrderAdjustmentImpl orderAdjustmentImpl = new OrderAdjustmentImpl();
    orderAdjustmentImpl.setFutureCredit(true);
    orderAdjustmentImpl.setId(null);
    orderAdjustmentImpl.setOrder(null);
    orderAdjustmentImpl.setReason(null);
    orderAdjustmentImpl.setValue(new Money());

    OrderAdjustmentImpl orderAdjustmentImpl2 = new OrderAdjustmentImpl();
    orderAdjustmentImpl2.setFutureCredit(true);
    orderAdjustmentImpl2.setId(OrderAdjustmentImpl.serialVersionUID);
    orderAdjustmentImpl2.setOrder(null);
    orderAdjustmentImpl2.setReason("Just cause");
    orderAdjustmentImpl2.setValue(new Money());

    // Act and Assert
    assertNotEquals(orderAdjustmentImpl, orderAdjustmentImpl2);
  }

  /**
   * Test {@link OrderAdjustmentImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderAdjustmentImpl#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean OrderAdjustmentImpl.equals(Object)", "int OrderAdjustmentImpl.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    OrderAdjustmentImpl orderAdjustmentImpl = new OrderAdjustmentImpl();
    orderAdjustmentImpl.setFutureCredit(true);
    orderAdjustmentImpl.setId(null);
    orderAdjustmentImpl.setOrder(null);
    orderAdjustmentImpl.setReason("Just cause");
    orderAdjustmentImpl.setValue(new Money(10.0d));

    OrderAdjustmentImpl orderAdjustmentImpl2 = new OrderAdjustmentImpl();
    orderAdjustmentImpl2.setFutureCredit(true);
    orderAdjustmentImpl2.setId(OrderAdjustmentImpl.serialVersionUID);
    orderAdjustmentImpl2.setOrder(null);
    orderAdjustmentImpl2.setReason("Just cause");
    orderAdjustmentImpl2.setValue(new Money());

    // Act and Assert
    assertNotEquals(orderAdjustmentImpl, orderAdjustmentImpl2);
  }

  /**
   * Test {@link OrderAdjustmentImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderAdjustmentImpl#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean OrderAdjustmentImpl.equals(Object)", "int OrderAdjustmentImpl.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    Money value = mock(Money.class);
    when(value.getAmount()).thenReturn(null);

    OrderAdjustmentImpl orderAdjustmentImpl = new OrderAdjustmentImpl();
    orderAdjustmentImpl.setFutureCredit(true);
    orderAdjustmentImpl.setId(null);
    orderAdjustmentImpl.setOrder(null);
    orderAdjustmentImpl.setReason("Just cause");
    orderAdjustmentImpl.setValue(value);

    OrderAdjustmentImpl orderAdjustmentImpl2 = new OrderAdjustmentImpl();
    orderAdjustmentImpl2.setFutureCredit(true);
    orderAdjustmentImpl2.setId(OrderAdjustmentImpl.serialVersionUID);
    orderAdjustmentImpl2.setOrder(null);
    orderAdjustmentImpl2.setReason("Just cause");
    orderAdjustmentImpl2.setValue(new Money());

    // Act and Assert
    assertNotEquals(orderAdjustmentImpl, orderAdjustmentImpl2);
  }

  /**
   * Test {@link OrderAdjustmentImpl#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderAdjustmentImpl#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean OrderAdjustmentImpl.equals(Object)", "int OrderAdjustmentImpl.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    OrderAdjustmentImpl orderAdjustmentImpl = new OrderAdjustmentImpl();
    orderAdjustmentImpl.setFutureCredit(true);
    orderAdjustmentImpl.setId(OrderAdjustmentImpl.serialVersionUID);
    orderAdjustmentImpl.setOrder(new NullOrderImpl());
    orderAdjustmentImpl.setReason("Just cause");
    orderAdjustmentImpl.setValue(new Money());

    // Act and Assert
    assertNotEquals(orderAdjustmentImpl, null);
  }

  /**
   * Test {@link OrderAdjustmentImpl#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderAdjustmentImpl#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean OrderAdjustmentImpl.equals(Object)", "int OrderAdjustmentImpl.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    OrderAdjustmentImpl orderAdjustmentImpl = new OrderAdjustmentImpl();
    orderAdjustmentImpl.setFutureCredit(true);
    orderAdjustmentImpl.setId(OrderAdjustmentImpl.serialVersionUID);
    orderAdjustmentImpl.setOrder(new NullOrderImpl());
    orderAdjustmentImpl.setReason("Just cause");
    orderAdjustmentImpl.setValue(new Money());

    // Act and Assert
    assertNotEquals(orderAdjustmentImpl, "Different type to OrderAdjustmentImpl");
  }

  /**
   * Test new {@link OrderAdjustmentImpl} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link OrderAdjustmentImpl}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OrderAdjustmentImpl.<init>()"})
  public void testNewOrderAdjustmentImpl() {
    // Arrange and Act
    OrderAdjustmentImpl actualOrderAdjustmentImpl = new OrderAdjustmentImpl();

    // Assert
    assertNull(actualOrderAdjustmentImpl.getId());
    assertNull(actualOrderAdjustmentImpl.getReason());
    assertNull(actualOrderAdjustmentImpl.getOffer());
    assertNull(actualOrderAdjustmentImpl.deproxiedOffer);
    assertNull(actualOrderAdjustmentImpl.offer);
    assertNull(actualOrderAdjustmentImpl.getOrder());
    assertFalse(actualOrderAdjustmentImpl.isFutureCredit);
    assertEquals(new BigDecimal("0.00"), actualOrderAdjustmentImpl.value);
  }
}
