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
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
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
import org.broadleafcommerce.common.copy.CreateResponse;
import org.broadleafcommerce.common.copy.MultiTenantCopyContext;
import org.broadleafcommerce.common.currency.domain.BroadleafCurrency;
import org.broadleafcommerce.common.currency.domain.BroadleafCurrencyImpl;
import org.broadleafcommerce.common.locale.domain.LocaleImpl;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.core.offer.service.type.OfferAdjustmentType;
import org.broadleafcommerce.core.order.domain.BundleOrderItemImpl;
import org.broadleafcommerce.core.order.domain.GiftWrapOrderItemImpl;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.OrderImpl;
import org.broadleafcommerce.core.order.domain.OrderItemImpl;
import org.broadleafcommerce.core.order.domain.OrderItemPriceDetail;
import org.broadleafcommerce.core.order.domain.OrderItemPriceDetailImpl;
import org.broadleafcommerce.core.order.domain.PersonalMessageImpl;
import org.broadleafcommerce.core.order.service.type.OrderItemType;
import org.broadleafcommerce.core.order.service.type.OrderStatus;
import org.broadleafcommerce.profile.core.domain.CustomerImpl;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class OrderItemPriceDetailAdjustmentImplDiffblueTest {
  @Autowired
  private OrderItemPriceDetailAdjustmentImpl orderItemPriceDetailAdjustmentImpl;

  /**
   * Test {@link OrderItemPriceDetailAdjustmentImpl#init(OrderItemPriceDetail, Offer, String)}.
   * <ul>
   *   <li>Given {@link OfferAdjustmentType#FUTURE_CREDIT}.</li>
   *   <li>Then {@link OrderItemPriceDetailAdjustmentImpl} (default constructor) {@link OrderItemPriceDetailAdjustmentImpl#isFutureCredit}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderItemPriceDetailAdjustmentImpl#init(OrderItemPriceDetail, Offer, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OrderItemPriceDetailAdjustmentImpl.init(OrderItemPriceDetail, Offer, String)"})
  public void testInit_givenFuture_credit_thenOrderItemPriceDetailAdjustmentImplIsFutureCredit() {
    // Arrange
    OrderItemPriceDetailAdjustmentImpl orderItemPriceDetailAdjustmentImpl2 = new OrderItemPriceDetailAdjustmentImpl();
    OrderItemPriceDetailImpl orderItemPriceDetail = new OrderItemPriceDetailImpl();
    Offer offer = mock(Offer.class);
    when(offer.getMarketingMessage()).thenReturn("Marketing Message");
    when(offer.getAdjustmentType()).thenReturn(OfferAdjustmentType.FUTURE_CREDIT);

    // Act
    orderItemPriceDetailAdjustmentImpl2.init(orderItemPriceDetail, offer, "Just cause");

    // Assert
    verify(offer).getAdjustmentType();
    verify(offer, atLeast(1)).getMarketingMessage();
    assertEquals("Marketing Message", orderItemPriceDetailAdjustmentImpl2.getOfferName());
    assertTrue(orderItemPriceDetailAdjustmentImpl2.isFutureCredit);
    assertSame(offer, orderItemPriceDetailAdjustmentImpl2.getOffer());
    assertSame(offer, orderItemPriceDetailAdjustmentImpl2.deproxiedOffer);
  }

  /**
   * Test {@link OrderItemPriceDetailAdjustmentImpl#init(OrderItemPriceDetail, Offer, String)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>Then not {@link OrderItemPriceDetailAdjustmentImpl} (default constructor) {@link OrderItemPriceDetailAdjustmentImpl#isFutureCredit}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderItemPriceDetailAdjustmentImpl#init(OrderItemPriceDetail, Offer, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OrderItemPriceDetailAdjustmentImpl.init(OrderItemPriceDetail, Offer, String)"})
  public void testInit_givenNull_thenNotOrderItemPriceDetailAdjustmentImplIsFutureCredit() {
    // Arrange
    OrderItemPriceDetailAdjustmentImpl orderItemPriceDetailAdjustmentImpl2 = new OrderItemPriceDetailAdjustmentImpl();
    OrderItemPriceDetailImpl orderItemPriceDetail = new OrderItemPriceDetailImpl();
    Offer offer = mock(Offer.class);
    when(offer.getMarketingMessage()).thenReturn("Marketing Message");
    when(offer.getAdjustmentType()).thenReturn(null);

    // Act
    orderItemPriceDetailAdjustmentImpl2.init(orderItemPriceDetail, offer, "Just cause");

    // Assert
    verify(offer).getAdjustmentType();
    verify(offer, atLeast(1)).getMarketingMessage();
    assertEquals("Marketing Message", orderItemPriceDetailAdjustmentImpl2.getOfferName());
    assertFalse(orderItemPriceDetailAdjustmentImpl2.isFutureCredit);
    assertSame(offer, orderItemPriceDetailAdjustmentImpl2.getOffer());
    assertSame(offer, orderItemPriceDetailAdjustmentImpl2.deproxiedOffer);
  }

  /**
   * Test {@link OrderItemPriceDetailAdjustmentImpl#init(OrderItemPriceDetail, Offer, String)}.
   * <ul>
   *   <li>Then {@link OrderItemPriceDetailAdjustmentImpl} (default constructor) Reason is {@code Marketing Message}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderItemPriceDetailAdjustmentImpl#init(OrderItemPriceDetail, Offer, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OrderItemPriceDetailAdjustmentImpl.init(OrderItemPriceDetail, Offer, String)"})
  public void testInit_thenOrderItemPriceDetailAdjustmentImplReasonIsMarketingMessage() {
    // Arrange
    OrderItemPriceDetailAdjustmentImpl orderItemPriceDetailAdjustmentImpl2 = new OrderItemPriceDetailAdjustmentImpl();
    OrderItemPriceDetailImpl orderItemPriceDetail = new OrderItemPriceDetailImpl();
    Offer offer = mock(Offer.class);
    when(offer.getMarketingMessage()).thenReturn("Marketing Message");
    when(offer.getAdjustmentType()).thenReturn(OfferAdjustmentType.FUTURE_CREDIT);

    // Act
    orderItemPriceDetailAdjustmentImpl2.init(orderItemPriceDetail, offer, null);

    // Assert
    verify(offer).getAdjustmentType();
    verify(offer, atLeast(1)).getMarketingMessage();
    assertEquals("Marketing Message", orderItemPriceDetailAdjustmentImpl2.getOfferName());
    assertEquals("Marketing Message", orderItemPriceDetailAdjustmentImpl2.getReason());
    assertTrue(orderItemPriceDetailAdjustmentImpl2.isFutureCredit);
    assertSame(offer, orderItemPriceDetailAdjustmentImpl2.getOffer());
    assertSame(offer, orderItemPriceDetailAdjustmentImpl2.deproxiedOffer);
  }

  /**
   * Test {@link OrderItemPriceDetailAdjustmentImpl#init(OrderItemPriceDetail, Offer, String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link OrderItemPriceDetailAdjustmentImpl} (default constructor) OfferName is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderItemPriceDetailAdjustmentImpl#init(OrderItemPriceDetail, Offer, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OrderItemPriceDetailAdjustmentImpl.init(OrderItemPriceDetail, Offer, String)"})
  public void testInit_whenNull_thenOrderItemPriceDetailAdjustmentImplOfferNameIsNull() {
    // Arrange
    OrderItemPriceDetailAdjustmentImpl orderItemPriceDetailAdjustmentImpl2 = new OrderItemPriceDetailAdjustmentImpl();

    // Act
    orderItemPriceDetailAdjustmentImpl2.init(new OrderItemPriceDetailImpl(), null, "Just cause");

    // Assert that nothing has changed
    assertNull(orderItemPriceDetailAdjustmentImpl2.getOfferName());
    assertNull(orderItemPriceDetailAdjustmentImpl2.getOffer());
    assertNull(orderItemPriceDetailAdjustmentImpl2.deproxiedOffer);
    assertNull(orderItemPriceDetailAdjustmentImpl2.offer);
  }

  /**
   * Test {@link OrderItemPriceDetailAdjustmentImpl#init(OrderItemPriceDetail, Offer, String)}.
   * <ul>
   *   <li>When {@link OfferImpl} (default constructor).</li>
   *   <li>Then {@link OrderItemPriceDetailAdjustmentImpl} (default constructor) {@link OrderItemPriceDetailAdjustmentImpl#offer} {@link OfferImpl}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderItemPriceDetailAdjustmentImpl#init(OrderItemPriceDetail, Offer, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OrderItemPriceDetailAdjustmentImpl.init(OrderItemPriceDetail, Offer, String)"})
  public void testInit_whenOfferImpl_thenOrderItemPriceDetailAdjustmentImplOfferOfferImpl() {
    // Arrange
    OrderItemPriceDetailAdjustmentImpl orderItemPriceDetailAdjustmentImpl2 = new OrderItemPriceDetailAdjustmentImpl();
    OrderItemPriceDetailImpl orderItemPriceDetail = new OrderItemPriceDetailImpl();
    OfferImpl offer = new OfferImpl();

    // Act
    orderItemPriceDetailAdjustmentImpl2.init(orderItemPriceDetail, offer, "Just cause");

    // Assert
    assertTrue(orderItemPriceDetailAdjustmentImpl2.offer instanceof OfferImpl);
    assertSame(offer, orderItemPriceDetailAdjustmentImpl2.getOffer());
    assertSame(offer, orderItemPriceDetailAdjustmentImpl2.deproxiedOffer);
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link OrderItemPriceDetailAdjustmentImpl#setAppliedToSalePrice(boolean)}
   *   <li>{@link OrderItemPriceDetailAdjustmentImpl#setId(Long)}
   *   <li>{@link OrderItemPriceDetailAdjustmentImpl#setOfferName(String)}
   *   <li>{@link OrderItemPriceDetailAdjustmentImpl#setOrderItemPriceDetail(OrderItemPriceDetail)}
   *   <li>{@link OrderItemPriceDetailAdjustmentImpl#setRetailPriceValue(Money)}
   *   <li>{@link OrderItemPriceDetailAdjustmentImpl#setSalesPriceValue(Money)}
   *   <li>{@link OrderItemPriceDetailAdjustmentImpl#getId()}
   *   <li>{@link OrderItemPriceDetailAdjustmentImpl#getOfferName()}
   *   <li>{@link OrderItemPriceDetailAdjustmentImpl#getOrderItemPriceDetail()}
   *   <li>{@link OrderItemPriceDetailAdjustmentImpl#getReason()}
   *   <li>{@link OrderItemPriceDetailAdjustmentImpl#isAppliedToSalePrice()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Long OrderItemPriceDetailAdjustmentImpl.getId()",
      "String OrderItemPriceDetailAdjustmentImpl.getOfferName()",
      "OrderItemPriceDetail OrderItemPriceDetailAdjustmentImpl.getOrderItemPriceDetail()",
      "String OrderItemPriceDetailAdjustmentImpl.getReason()",
      "boolean OrderItemPriceDetailAdjustmentImpl.isAppliedToSalePrice()",
      "void OrderItemPriceDetailAdjustmentImpl.setAppliedToSalePrice(boolean)",
      "void OrderItemPriceDetailAdjustmentImpl.setId(Long)",
      "void OrderItemPriceDetailAdjustmentImpl.setOfferName(String)",
      "void OrderItemPriceDetailAdjustmentImpl.setOrderItemPriceDetail(OrderItemPriceDetail)",
      "void OrderItemPriceDetailAdjustmentImpl.setRetailPriceValue(Money)",
      "void OrderItemPriceDetailAdjustmentImpl.setSalesPriceValue(Money)"})
  public void testGettersAndSetters() {
    // Arrange
    OrderItemPriceDetailAdjustmentImpl orderItemPriceDetailAdjustmentImpl = new OrderItemPriceDetailAdjustmentImpl();

    // Act
    orderItemPriceDetailAdjustmentImpl.setAppliedToSalePrice(true);
    orderItemPriceDetailAdjustmentImpl.setId(OrderItemPriceDetailAdjustmentImpl.serialVersionUID);
    orderItemPriceDetailAdjustmentImpl.setOfferName("Offer Name");
    OrderItemPriceDetailImpl orderItemPriceDetail = new OrderItemPriceDetailImpl();
    orderItemPriceDetailAdjustmentImpl.setOrderItemPriceDetail(orderItemPriceDetail);
    orderItemPriceDetailAdjustmentImpl.setRetailPriceValue(new Money());
    orderItemPriceDetailAdjustmentImpl.setSalesPriceValue(new Money());
    Long actualId = orderItemPriceDetailAdjustmentImpl.getId();
    String actualOfferName = orderItemPriceDetailAdjustmentImpl.getOfferName();
    OrderItemPriceDetail actualOrderItemPriceDetail = orderItemPriceDetailAdjustmentImpl.getOrderItemPriceDetail();
    String actualReason = orderItemPriceDetailAdjustmentImpl.getReason();

    // Assert
    assertEquals("Offer Name", actualOfferName);
    assertNull(actualReason);
    assertTrue(orderItemPriceDetailAdjustmentImpl.isAppliedToSalePrice());
    assertEquals(OrderItemPriceDetailAdjustmentImpl.serialVersionUID, actualId.longValue());
    assertSame(orderItemPriceDetail, actualOrderItemPriceDetail);
  }

  /**
   * Test {@link OrderItemPriceDetailAdjustmentImpl#getOffer()}.
   * <p>
   * Method under test: {@link OrderItemPriceDetailAdjustmentImpl#getOffer()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Offer OrderItemPriceDetailAdjustmentImpl.getOffer()"})
  public void testGetOffer() {
    // Arrange, Act and Assert
    assertNull((new OrderItemPriceDetailAdjustmentImpl()).getOffer());
  }

  /**
   * Test {@link OrderItemPriceDetailAdjustmentImpl#setReason(String)}.
   * <ul>
   *   <li>Given {@link OrderItemPriceDetailAdjustmentImpl} (default constructor) OfferName is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderItemPriceDetailAdjustmentImpl#setReason(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OrderItemPriceDetailAdjustmentImpl.setReason(String)"})
  public void testSetReason_givenOrderItemPriceDetailAdjustmentImplOfferNameIsNull() {
    // Arrange
    OrderItemPriceDetailAdjustmentImpl orderItemPriceDetailAdjustmentImpl2 = new OrderItemPriceDetailAdjustmentImpl();
    orderItemPriceDetailAdjustmentImpl2.setAppliedToSalePrice(true);
    orderItemPriceDetailAdjustmentImpl2.setFutureCredit(true);
    orderItemPriceDetailAdjustmentImpl2.setId(OrderItemPriceDetailAdjustmentImpl.serialVersionUID);
    orderItemPriceDetailAdjustmentImpl2.setOrderItemPriceDetail(new OrderItemPriceDetailImpl());
    orderItemPriceDetailAdjustmentImpl2.setReason("Just cause");
    orderItemPriceDetailAdjustmentImpl2.setRetailPriceValue(new Money());
    orderItemPriceDetailAdjustmentImpl2.setSalesPriceValue(new Money());
    orderItemPriceDetailAdjustmentImpl2.setValue(new Money());
    orderItemPriceDetailAdjustmentImpl2.setOfferName(null);

    // Act
    orderItemPriceDetailAdjustmentImpl2.setReason(null);

    // Assert that nothing has changed
    assertEquals("Just cause", orderItemPriceDetailAdjustmentImpl2.getReason());
  }

  /**
   * Test {@link OrderItemPriceDetailAdjustmentImpl#setReason(String)}.
   * <ul>
   *   <li>Given {@link OrderItemPriceDetailAdjustmentImpl} (default constructor).</li>
   *   <li>When {@code Just cause}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderItemPriceDetailAdjustmentImpl#setReason(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OrderItemPriceDetailAdjustmentImpl.setReason(String)"})
  public void testSetReason_givenOrderItemPriceDetailAdjustmentImpl_whenJustCause() {
    // Arrange
    OrderItemPriceDetailAdjustmentImpl orderItemPriceDetailAdjustmentImpl2 = new OrderItemPriceDetailAdjustmentImpl();

    // Act
    orderItemPriceDetailAdjustmentImpl2.setReason("Just cause");

    // Assert
    assertEquals("Just cause", orderItemPriceDetailAdjustmentImpl2.getReason());
  }

  /**
   * Test {@link OrderItemPriceDetailAdjustmentImpl#setReason(String)}.
   * <ul>
   *   <li>Then {@link OrderItemPriceDetailAdjustmentImpl} (default constructor) Reason is {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderItemPriceDetailAdjustmentImpl#setReason(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OrderItemPriceDetailAdjustmentImpl.setReason(String)"})
  public void testSetReason_thenOrderItemPriceDetailAdjustmentImplReasonIsFoo() {
    // Arrange
    OrderItemPriceDetailAdjustmentImpl orderItemPriceDetailAdjustmentImpl2 = new OrderItemPriceDetailAdjustmentImpl();
    orderItemPriceDetailAdjustmentImpl2.setAppliedToSalePrice(true);
    orderItemPriceDetailAdjustmentImpl2.setFutureCredit(true);
    orderItemPriceDetailAdjustmentImpl2.setId(OrderItemPriceDetailAdjustmentImpl.serialVersionUID);
    orderItemPriceDetailAdjustmentImpl2.setOrderItemPriceDetail(new OrderItemPriceDetailImpl());
    orderItemPriceDetailAdjustmentImpl2.setReason("Just cause");
    orderItemPriceDetailAdjustmentImpl2.setRetailPriceValue(new Money());
    orderItemPriceDetailAdjustmentImpl2.setSalesPriceValue(new Money());
    orderItemPriceDetailAdjustmentImpl2.setValue(new Money());
    orderItemPriceDetailAdjustmentImpl2.setOfferName("foo");

    // Act
    orderItemPriceDetailAdjustmentImpl2.setReason(null);

    // Assert
    assertEquals("foo", orderItemPriceDetailAdjustmentImpl2.getReason());
  }

  /**
   * Test {@link OrderItemPriceDetailAdjustmentImpl#setOffer(Offer)}.
   * <ul>
   *   <li>Then {@link OrderItemPriceDetailAdjustmentImpl} (default constructor) Offer is {@link OfferImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderItemPriceDetailAdjustmentImpl#setOffer(Offer)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OrderItemPriceDetailAdjustmentImpl.setOffer(Offer)"})
  public void testSetOffer_thenOrderItemPriceDetailAdjustmentImplOfferIsOfferImpl() {
    // Arrange
    OrderItemPriceDetailAdjustmentImpl orderItemPriceDetailAdjustmentImpl2 = new OrderItemPriceDetailAdjustmentImpl();
    OfferImpl offer = new OfferImpl();

    // Act
    orderItemPriceDetailAdjustmentImpl2.setOffer(offer);

    // Assert
    assertTrue(orderItemPriceDetailAdjustmentImpl2.offer instanceof OfferImpl);
    assertSame(offer, orderItemPriceDetailAdjustmentImpl2.getOffer());
  }

  /**
   * Test {@link OrderItemPriceDetailAdjustmentImpl#setOffer(Offer)}.
   * <ul>
   *   <li>Then {@link OrderItemPriceDetailAdjustmentImpl} (default constructor) OfferName is {@code Marketing Message}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderItemPriceDetailAdjustmentImpl#setOffer(Offer)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OrderItemPriceDetailAdjustmentImpl.setOffer(Offer)"})
  public void testSetOffer_thenOrderItemPriceDetailAdjustmentImplOfferNameIsMarketingMessage() {
    // Arrange
    OrderItemPriceDetailAdjustmentImpl orderItemPriceDetailAdjustmentImpl2 = new OrderItemPriceDetailAdjustmentImpl();
    Offer offer = mock(Offer.class);
    when(offer.getMarketingMessage()).thenReturn("Marketing Message");

    // Act
    orderItemPriceDetailAdjustmentImpl2.setOffer(offer);

    // Assert
    verify(offer, atLeast(1)).getMarketingMessage();
    assertEquals("Marketing Message", orderItemPriceDetailAdjustmentImpl2.getOfferName());
    assertSame(offer, orderItemPriceDetailAdjustmentImpl2.getOffer());
    assertSame(offer, orderItemPriceDetailAdjustmentImpl2.deproxiedOffer);
  }

  /**
   * Test {@link OrderItemPriceDetailAdjustmentImpl#setOffer(Offer)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link OrderItemPriceDetailAdjustmentImpl} (default constructor) OfferName is {@code Offer Name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderItemPriceDetailAdjustmentImpl#setOffer(Offer)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OrderItemPriceDetailAdjustmentImpl.setOffer(Offer)"})
  public void testSetOffer_whenNull_thenOrderItemPriceDetailAdjustmentImplOfferNameIsOfferName() {
    // Arrange
    OrderItemPriceDetailAdjustmentImpl orderItemPriceDetailAdjustmentImpl2 = new OrderItemPriceDetailAdjustmentImpl();
    orderItemPriceDetailAdjustmentImpl2.setAppliedToSalePrice(true);
    orderItemPriceDetailAdjustmentImpl2.setFutureCredit(true);
    orderItemPriceDetailAdjustmentImpl2.setId(OrderItemPriceDetailAdjustmentImpl.serialVersionUID);
    orderItemPriceDetailAdjustmentImpl2.setOfferName("Offer Name");
    orderItemPriceDetailAdjustmentImpl2.setOrderItemPriceDetail(new OrderItemPriceDetailImpl());
    orderItemPriceDetailAdjustmentImpl2.setReason("Just cause");
    orderItemPriceDetailAdjustmentImpl2.setRetailPriceValue(new Money());
    orderItemPriceDetailAdjustmentImpl2.setSalesPriceValue(new Money());
    orderItemPriceDetailAdjustmentImpl2.setValue(new Money());

    // Act
    orderItemPriceDetailAdjustmentImpl2.setOffer(null);

    // Assert that nothing has changed
    assertEquals("Offer Name", orderItemPriceDetailAdjustmentImpl2.getOfferName());
  }

  /**
   * Test {@link OrderItemPriceDetailAdjustmentImpl#setOffer(Offer)}.
   * <ul>
   *   <li>When {@link OfferImpl} (default constructor).</li>
   *   <li>Then {@link OrderItemPriceDetailAdjustmentImpl} (default constructor) OfferName is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderItemPriceDetailAdjustmentImpl#setOffer(Offer)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OrderItemPriceDetailAdjustmentImpl.setOffer(Offer)"})
  public void testSetOffer_whenOfferImpl_thenOrderItemPriceDetailAdjustmentImplOfferNameIsNull() {
    // Arrange
    OrderItemPriceDetailAdjustmentImpl orderItemPriceDetailAdjustmentImpl2 = new OrderItemPriceDetailAdjustmentImpl();
    orderItemPriceDetailAdjustmentImpl2.setAppliedToSalePrice(true);
    orderItemPriceDetailAdjustmentImpl2.setFutureCredit(true);
    orderItemPriceDetailAdjustmentImpl2.setId(OrderItemPriceDetailAdjustmentImpl.serialVersionUID);
    orderItemPriceDetailAdjustmentImpl2.setOfferName("Offer Name");
    orderItemPriceDetailAdjustmentImpl2.setOrderItemPriceDetail(new OrderItemPriceDetailImpl());
    orderItemPriceDetailAdjustmentImpl2.setReason("Just cause");
    orderItemPriceDetailAdjustmentImpl2.setRetailPriceValue(new Money());
    orderItemPriceDetailAdjustmentImpl2.setSalesPriceValue(new Money());
    orderItemPriceDetailAdjustmentImpl2.setValue(new Money());
    OfferImpl offer = new OfferImpl();

    // Act
    orderItemPriceDetailAdjustmentImpl2.setOffer(offer);

    // Assert
    assertTrue(orderItemPriceDetailAdjustmentImpl2.offer instanceof OfferImpl);
    assertNull(orderItemPriceDetailAdjustmentImpl2.getOfferName());
    assertSame(offer, orderItemPriceDetailAdjustmentImpl2.getOffer());
  }

  /**
   * Test {@link OrderItemPriceDetailAdjustmentImpl#getCurrency()}.
   * <ul>
   *   <li>Given {@link Auditable} (default constructor) CreatedBy is {@link OrderItemPriceDetailAdjustmentImpl#serialVersionUID}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderItemPriceDetailAdjustmentImpl#getCurrency()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"BroadleafCurrency OrderItemPriceDetailAdjustmentImpl.getCurrency()"})
  public void testGetCurrency_givenAuditableCreatedByIsSerialVersionUID_thenReturnNull() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemPriceDetailAdjustmentImpl.serialVersionUID);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemPriceDetailAdjustmentImpl.serialVersionUID);

    OrderItemImpl orderItemImpl = new OrderItemImpl();
    orderItemImpl.setAuditable(auditable);
    orderItemImpl.setCandidateItemOffers(new ArrayList<>());
    orderItemImpl.setCartMessages(new ArrayList<>());
    orderItemImpl.setChildOrderItems(new ArrayList<>());
    orderItemImpl.setDiscountingAllowed(true);
    orderItemImpl.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    orderItemImpl.setHasValidationError(true);
    orderItemImpl.setId(OrderItemPriceDetailAdjustmentImpl.serialVersionUID);
    orderItemImpl.setName("Name");
    orderItemImpl.setOrder(new NullOrderImpl());
    orderItemImpl.setOrderItemAdjustments(new ArrayList<>());
    orderItemImpl.setOrderItemAttributes(new HashMap<>());
    orderItemImpl.setOrderItemPriceDetails(new ArrayList<>());
    orderItemImpl.setOrderItemQualifiers(new ArrayList<>());
    orderItemImpl.setOrderItemType(OrderItemType.BASIC);
    orderItemImpl.setParentOrderItem(new BundleOrderItemImpl());
    orderItemImpl.setPersonalMessage(new PersonalMessageImpl());
    orderItemImpl.setProratedOrderItemAdjustments(new ArrayList<>());
    orderItemImpl.setQuantity(1);
    orderItemImpl.setRetailPrice(new Money());
    orderItemImpl.setRetailPriceOverride(true);
    orderItemImpl.setSalePrice(new Money());
    orderItemImpl.setSalePriceOverride(true);
    orderItemImpl.setTaxable(true);
    orderItemImpl.updateSaleAndRetailPrices();
    OrderItemPriceDetailImpl orderItemPriceDetail = mock(OrderItemPriceDetailImpl.class);
    when(orderItemPriceDetail.getOrderItem()).thenReturn(orderItemImpl);

    OrderItemPriceDetailAdjustmentImpl orderItemPriceDetailAdjustmentImpl2 = new OrderItemPriceDetailAdjustmentImpl();
    orderItemPriceDetailAdjustmentImpl2.setAppliedToSalePrice(true);
    orderItemPriceDetailAdjustmentImpl2.setFutureCredit(true);
    orderItemPriceDetailAdjustmentImpl2.setId(OrderItemPriceDetailAdjustmentImpl.serialVersionUID);
    orderItemPriceDetailAdjustmentImpl2.setOfferName("Offer Name");
    orderItemPriceDetailAdjustmentImpl2.setOrderItemPriceDetail(orderItemPriceDetail);
    orderItemPriceDetailAdjustmentImpl2.setReason("Just cause");
    orderItemPriceDetailAdjustmentImpl2.setRetailPriceValue(new Money());
    orderItemPriceDetailAdjustmentImpl2.setSalesPriceValue(new Money());
    orderItemPriceDetailAdjustmentImpl2.setValue(new Money());

    // Act
    BroadleafCurrency actualCurrency = orderItemPriceDetailAdjustmentImpl2.getCurrency();

    // Assert
    verify(orderItemPriceDetail).getOrderItem();
    assertNull(actualCurrency);
  }

  /**
   * Test {@link OrderItemPriceDetailAdjustmentImpl#getValue()}.
   * <ul>
   *   <li>Given {@link BundleOrderItemImpl} {@link OrderItemImpl#getOrder()} return {@link NullOrderImpl} (default constructor).</li>
   *   <li>Then return {@link Money#ZERO}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderItemPriceDetailAdjustmentImpl#getValue()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money OrderItemPriceDetailAdjustmentImpl.getValue()"})
  public void testGetValue_givenBundleOrderItemImplGetOrderReturnNullOrderImpl_thenReturnZero() {
    // Arrange
    BundleOrderItemImpl bundleOrderItemImpl = mock(BundleOrderItemImpl.class);
    when(bundleOrderItemImpl.getOrder()).thenReturn(new NullOrderImpl());
    OrderItemPriceDetailImpl orderItemPriceDetail = mock(OrderItemPriceDetailImpl.class);
    when(orderItemPriceDetail.getOrderItem()).thenReturn(bundleOrderItemImpl);

    OrderItemPriceDetailAdjustmentImpl orderItemPriceDetailAdjustmentImpl2 = new OrderItemPriceDetailAdjustmentImpl();
    orderItemPriceDetailAdjustmentImpl2.setOrderItemPriceDetail(orderItemPriceDetail);

    // Act
    Money actualValue = orderItemPriceDetailAdjustmentImpl2.getValue();

    // Assert
    verify(bundleOrderItemImpl).getOrder();
    verify(orderItemPriceDetail).getOrderItem();
    assertEquals(actualValue.ZERO, actualValue);
  }

  /**
   * Test {@link OrderItemPriceDetailAdjustmentImpl#getValue()}.
   * <ul>
   *   <li>Given {@link OrderImpl} (default constructor) Currency is {@code null}.</li>
   *   <li>Then return {@link Money#Money()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderItemPriceDetailAdjustmentImpl#getValue()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money OrderItemPriceDetailAdjustmentImpl.getValue()"})
  public void testGetValue_givenOrderImplCurrencyIsNull_thenReturnMoney() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemPriceDetailAdjustmentImpl.serialVersionUID);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemPriceDetailAdjustmentImpl.serialVersionUID);

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(OrderItemPriceDetailAdjustmentImpl.serialVersionUID);
    auditable2.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(OrderItemPriceDetailAdjustmentImpl.serialVersionUID);

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable2);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
    order.setFulfillmentGroups(new ArrayList<>());
    order.setId(OrderItemPriceDetailAdjustmentImpl.serialVersionUID);
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

    BundleOrderItemImpl orderItem = new BundleOrderItemImpl();
    orderItem.setAuditable(auditable);
    orderItem.setBaseRetailPrice(new Money());
    orderItem.setBaseSalePrice(new Money());
    orderItem.setBundleOrderItemFeePrices(new ArrayList<>());
    orderItem.setCandidateItemOffers(new ArrayList<>());
    orderItem.setCartMessages(new ArrayList<>());
    orderItem.setChildOrderItems(new ArrayList<>());
    orderItem.setDiscountingAllowed(true);
    orderItem.setDiscreteOrderItems(new ArrayList<>());
    orderItem.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    orderItem.setHasValidationError(true);
    orderItem.setId(OrderItemPriceDetailAdjustmentImpl.serialVersionUID);
    orderItem.setName("Name");
    orderItem.setOrderItemAdjustments(new ArrayList<>());
    orderItem.setOrderItemAttributes(new HashMap<>());
    orderItem.setOrderItemPriceDetails(new ArrayList<>());
    orderItem.setOrderItemQualifiers(new ArrayList<>());
    orderItem.setOrderItemType(OrderItemType.BASIC);
    orderItem.setParentOrderItem(new BundleOrderItemImpl());
    orderItem.setPersonalMessage(new PersonalMessageImpl());
    orderItem.setProratedOrderItemAdjustments(new ArrayList<>());
    orderItem.setQuantity(1);
    orderItem.setRetailPrice(new Money());
    orderItem.setRetailPriceOverride(true);
    orderItem.setSalePrice(new Money());
    orderItem.setSalePriceOverride(true);
    orderItem.setTaxable(true);
    orderItem.updateSaleAndRetailPrices();
    orderItem.setOrder(order);

    OrderItemPriceDetailImpl orderItemPriceDetail = new OrderItemPriceDetailImpl();
    orderItemPriceDetail.setId(OrderItemPriceDetailAdjustmentImpl.serialVersionUID);
    orderItemPriceDetail.setOrderItemAdjustments(new ArrayList<>());
    orderItemPriceDetail.setQuantity(1);
    orderItemPriceDetail.setUseSalePrice(true);
    orderItemPriceDetail.setOrderItem(orderItem);

    OrderItemPriceDetailAdjustmentImpl orderItemPriceDetailAdjustmentImpl2 = new OrderItemPriceDetailAdjustmentImpl();
    orderItemPriceDetailAdjustmentImpl2.setAppliedToSalePrice(true);
    orderItemPriceDetailAdjustmentImpl2.setFutureCredit(true);
    orderItemPriceDetailAdjustmentImpl2.setId(OrderItemPriceDetailAdjustmentImpl.serialVersionUID);
    orderItemPriceDetailAdjustmentImpl2.setOfferName("Offer Name");
    orderItemPriceDetailAdjustmentImpl2.setReason("Just cause");
    Money retailPriceValue = new Money();
    orderItemPriceDetailAdjustmentImpl2.setRetailPriceValue(retailPriceValue);
    orderItemPriceDetailAdjustmentImpl2.setSalesPriceValue(new Money());
    orderItemPriceDetailAdjustmentImpl2.setValue(new Money());
    orderItemPriceDetailAdjustmentImpl2.setOrderItemPriceDetail(orderItemPriceDetail);

    // Act and Assert
    assertEquals(retailPriceValue, orderItemPriceDetailAdjustmentImpl2.getValue());
  }

  /**
   * Test {@link OrderItemPriceDetailAdjustmentImpl#setValue(Money)}.
   * <ul>
   *   <li>Then {@link OrderItemPriceDetailAdjustmentImpl} (default constructor) {@link OrderItemPriceDetailAdjustmentImpl#value} is {@link BigDecimal#BigDecimal(String)} with {@code 0.00}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderItemPriceDetailAdjustmentImpl#setValue(Money)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OrderItemPriceDetailAdjustmentImpl.setValue(Money)"})
  public void testSetValue_thenOrderItemPriceDetailAdjustmentImplValueIsBigDecimalWith000() {
    // Arrange
    OrderItemPriceDetailAdjustmentImpl orderItemPriceDetailAdjustmentImpl2 = new OrderItemPriceDetailAdjustmentImpl();

    // Act
    orderItemPriceDetailAdjustmentImpl2.setValue(new Money());

    // Assert that nothing has changed
    assertEquals(new BigDecimal("0.00"), orderItemPriceDetailAdjustmentImpl2.value);
  }

  /**
   * Test {@link OrderItemPriceDetailAdjustmentImpl#setValue(Money)}.
   * <ul>
   *   <li>Then {@link OrderItemPriceDetailAdjustmentImpl} (default constructor) {@link OrderItemPriceDetailAdjustmentImpl#value} is {@link BigDecimal#BigDecimal(String)} with {@code 2.3}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderItemPriceDetailAdjustmentImpl#setValue(Money)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OrderItemPriceDetailAdjustmentImpl.setValue(Money)"})
  public void testSetValue_thenOrderItemPriceDetailAdjustmentImplValueIsBigDecimalWith23() {
    // Arrange
    OrderItemPriceDetailAdjustmentImpl orderItemPriceDetailAdjustmentImpl2 = new OrderItemPriceDetailAdjustmentImpl();
    Money value = mock(Money.class);
    when(value.getAmount()).thenReturn(new BigDecimal("2.3"));

    // Act
    orderItemPriceDetailAdjustmentImpl2.setValue(value);

    // Assert
    verify(value).getAmount();
    assertEquals(new BigDecimal("2.3"), orderItemPriceDetailAdjustmentImpl2.value);
  }

  /**
   * Test {@link OrderItemPriceDetailAdjustmentImpl#getRetailPriceValue()}.
   * <p>
   * Method under test: {@link OrderItemPriceDetailAdjustmentImpl#getRetailPriceValue()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money OrderItemPriceDetailAdjustmentImpl.getRetailPriceValue()"})
  public void testGetRetailPriceValue() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemPriceDetailAdjustmentImpl.serialVersionUID);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemPriceDetailAdjustmentImpl.serialVersionUID);

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(OrderItemPriceDetailAdjustmentImpl.serialVersionUID);
    auditable2.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(OrderItemPriceDetailAdjustmentImpl.serialVersionUID);

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable2);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
    order.setFulfillmentGroups(new ArrayList<>());
    order.setId(OrderItemPriceDetailAdjustmentImpl.serialVersionUID);
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

    BundleOrderItemImpl orderItem = new BundleOrderItemImpl();
    orderItem.setAuditable(auditable);
    orderItem.setBaseRetailPrice(new Money());
    orderItem.setBaseSalePrice(new Money());
    orderItem.setBundleOrderItemFeePrices(new ArrayList<>());
    orderItem.setCandidateItemOffers(new ArrayList<>());
    orderItem.setCartMessages(new ArrayList<>());
    orderItem.setChildOrderItems(new ArrayList<>());
    orderItem.setDiscountingAllowed(true);
    orderItem.setDiscreteOrderItems(new ArrayList<>());
    orderItem.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    orderItem.setHasValidationError(true);
    orderItem.setId(OrderItemPriceDetailAdjustmentImpl.serialVersionUID);
    orderItem.setName("Name");
    orderItem.setOrderItemAdjustments(new ArrayList<>());
    orderItem.setOrderItemAttributes(new HashMap<>());
    orderItem.setOrderItemPriceDetails(new ArrayList<>());
    orderItem.setOrderItemQualifiers(new ArrayList<>());
    orderItem.setOrderItemType(OrderItemType.BASIC);
    orderItem.setParentOrderItem(new BundleOrderItemImpl());
    orderItem.setPersonalMessage(new PersonalMessageImpl());
    orderItem.setProratedOrderItemAdjustments(new ArrayList<>());
    orderItem.setQuantity(1);
    orderItem.setRetailPrice(new Money());
    orderItem.setRetailPriceOverride(true);
    orderItem.setSalePrice(new Money());
    orderItem.setSalePriceOverride(true);
    orderItem.setTaxable(true);
    orderItem.updateSaleAndRetailPrices();
    orderItem.setOrder(order);

    OrderItemPriceDetailImpl orderItemPriceDetail = new OrderItemPriceDetailImpl();
    orderItemPriceDetail.setId(OrderItemPriceDetailAdjustmentImpl.serialVersionUID);
    orderItemPriceDetail.setOrderItemAdjustments(new ArrayList<>());
    orderItemPriceDetail.setQuantity(1);
    orderItemPriceDetail.setUseSalePrice(true);
    orderItemPriceDetail.setOrderItem(orderItem);

    OrderItemPriceDetailAdjustmentImpl orderItemPriceDetailAdjustmentImpl2 = new OrderItemPriceDetailAdjustmentImpl();
    orderItemPriceDetailAdjustmentImpl2.setAppliedToSalePrice(true);
    orderItemPriceDetailAdjustmentImpl2.setFutureCredit(true);
    orderItemPriceDetailAdjustmentImpl2.setId(OrderItemPriceDetailAdjustmentImpl.serialVersionUID);
    orderItemPriceDetailAdjustmentImpl2.setOfferName("Offer Name");
    orderItemPriceDetailAdjustmentImpl2.setReason("Just cause");
    orderItemPriceDetailAdjustmentImpl2.setSalesPriceValue(new Money());
    orderItemPriceDetailAdjustmentImpl2.setValue(new Money());
    Money retailPriceValue = new Money();
    orderItemPriceDetailAdjustmentImpl2.setRetailPriceValue(retailPriceValue);
    orderItemPriceDetailAdjustmentImpl2.setOrderItemPriceDetail(orderItemPriceDetail);

    // Act and Assert
    assertSame(retailPriceValue, orderItemPriceDetailAdjustmentImpl2.getRetailPriceValue());
  }

  /**
   * Test {@link OrderItemPriceDetailAdjustmentImpl#getRetailPriceValue()}.
   * <ul>
   *   <li>Given {@link OrderImpl} (default constructor) Currency is {@code null}.</li>
   *   <li>Then return {@link Money#Money()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderItemPriceDetailAdjustmentImpl#getRetailPriceValue()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money OrderItemPriceDetailAdjustmentImpl.getRetailPriceValue()"})
  public void testGetRetailPriceValue_givenOrderImplCurrencyIsNull_thenReturnMoney() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemPriceDetailAdjustmentImpl.serialVersionUID);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemPriceDetailAdjustmentImpl.serialVersionUID);

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(OrderItemPriceDetailAdjustmentImpl.serialVersionUID);
    auditable2.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(OrderItemPriceDetailAdjustmentImpl.serialVersionUID);

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable2);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
    order.setFulfillmentGroups(new ArrayList<>());
    order.setId(OrderItemPriceDetailAdjustmentImpl.serialVersionUID);
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

    BundleOrderItemImpl orderItem = new BundleOrderItemImpl();
    orderItem.setAuditable(auditable);
    orderItem.setBaseRetailPrice(new Money());
    orderItem.setBaseSalePrice(new Money());
    orderItem.setBundleOrderItemFeePrices(new ArrayList<>());
    orderItem.setCandidateItemOffers(new ArrayList<>());
    orderItem.setCartMessages(new ArrayList<>());
    orderItem.setChildOrderItems(new ArrayList<>());
    orderItem.setDiscountingAllowed(true);
    orderItem.setDiscreteOrderItems(new ArrayList<>());
    orderItem.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    orderItem.setHasValidationError(true);
    orderItem.setId(OrderItemPriceDetailAdjustmentImpl.serialVersionUID);
    orderItem.setName("Name");
    orderItem.setOrderItemAdjustments(new ArrayList<>());
    orderItem.setOrderItemAttributes(new HashMap<>());
    orderItem.setOrderItemPriceDetails(new ArrayList<>());
    orderItem.setOrderItemQualifiers(new ArrayList<>());
    orderItem.setOrderItemType(OrderItemType.BASIC);
    orderItem.setParentOrderItem(new BundleOrderItemImpl());
    orderItem.setPersonalMessage(new PersonalMessageImpl());
    orderItem.setProratedOrderItemAdjustments(new ArrayList<>());
    orderItem.setQuantity(1);
    orderItem.setRetailPrice(new Money());
    orderItem.setRetailPriceOverride(true);
    orderItem.setSalePrice(new Money());
    orderItem.setSalePriceOverride(true);
    orderItem.setTaxable(true);
    orderItem.updateSaleAndRetailPrices();
    orderItem.setOrder(order);

    OrderItemPriceDetailImpl orderItemPriceDetail = new OrderItemPriceDetailImpl();
    orderItemPriceDetail.setId(OrderItemPriceDetailAdjustmentImpl.serialVersionUID);
    orderItemPriceDetail.setOrderItemAdjustments(new ArrayList<>());
    orderItemPriceDetail.setQuantity(1);
    orderItemPriceDetail.setUseSalePrice(true);
    orderItemPriceDetail.setOrderItem(orderItem);

    OrderItemPriceDetailAdjustmentImpl orderItemPriceDetailAdjustmentImpl2 = new OrderItemPriceDetailAdjustmentImpl();
    orderItemPriceDetailAdjustmentImpl2.setAppliedToSalePrice(true);
    orderItemPriceDetailAdjustmentImpl2.setFutureCredit(true);
    orderItemPriceDetailAdjustmentImpl2.setId(OrderItemPriceDetailAdjustmentImpl.serialVersionUID);
    orderItemPriceDetailAdjustmentImpl2.setOfferName("Offer Name");
    orderItemPriceDetailAdjustmentImpl2.setReason("Just cause");
    Money salesPriceValue = new Money();
    orderItemPriceDetailAdjustmentImpl2.setSalesPriceValue(salesPriceValue);
    orderItemPriceDetailAdjustmentImpl2.setValue(new Money());
    orderItemPriceDetailAdjustmentImpl2.setRetailPriceValue(null);
    orderItemPriceDetailAdjustmentImpl2.setOrderItemPriceDetail(orderItemPriceDetail);

    // Act and Assert
    assertEquals(salesPriceValue, orderItemPriceDetailAdjustmentImpl2.getRetailPriceValue());
  }

  /**
   * Test {@link OrderItemPriceDetailAdjustmentImpl#getRetailPriceValue()}.
   * <ul>
   *   <li>Then return {@link Money#ZERO}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderItemPriceDetailAdjustmentImpl#getRetailPriceValue()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money OrderItemPriceDetailAdjustmentImpl.getRetailPriceValue()"})
  public void testGetRetailPriceValue_thenReturnZero() {
    // Arrange
    BundleOrderItemImpl bundleOrderItemImpl = mock(BundleOrderItemImpl.class);
    when(bundleOrderItemImpl.getOrder()).thenReturn(new NullOrderImpl());
    OrderItemPriceDetailImpl orderItemPriceDetail = mock(OrderItemPriceDetailImpl.class);
    when(orderItemPriceDetail.getOrderItem()).thenReturn(bundleOrderItemImpl);

    OrderItemPriceDetailAdjustmentImpl orderItemPriceDetailAdjustmentImpl2 = new OrderItemPriceDetailAdjustmentImpl();
    orderItemPriceDetailAdjustmentImpl2.setOrderItemPriceDetail(orderItemPriceDetail);

    // Act
    Money actualRetailPriceValue = orderItemPriceDetailAdjustmentImpl2.getRetailPriceValue();

    // Assert
    verify(bundleOrderItemImpl).getOrder();
    verify(orderItemPriceDetail).getOrderItem();
    assertEquals(actualRetailPriceValue.ZERO, actualRetailPriceValue);
  }

  /**
   * Test {@link OrderItemPriceDetailAdjustmentImpl#getSalesPriceValue()}.
   * <p>
   * Method under test: {@link OrderItemPriceDetailAdjustmentImpl#getSalesPriceValue()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money OrderItemPriceDetailAdjustmentImpl.getSalesPriceValue()"})
  public void testGetSalesPriceValue() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemPriceDetailAdjustmentImpl.serialVersionUID);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemPriceDetailAdjustmentImpl.serialVersionUID);

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(OrderItemPriceDetailAdjustmentImpl.serialVersionUID);
    auditable2.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(OrderItemPriceDetailAdjustmentImpl.serialVersionUID);

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable2);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
    order.setFulfillmentGroups(new ArrayList<>());
    order.setId(OrderItemPriceDetailAdjustmentImpl.serialVersionUID);
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

    BundleOrderItemImpl orderItem = new BundleOrderItemImpl();
    orderItem.setAuditable(auditable);
    orderItem.setBaseRetailPrice(new Money());
    orderItem.setBaseSalePrice(new Money());
    orderItem.setBundleOrderItemFeePrices(new ArrayList<>());
    orderItem.setCandidateItemOffers(new ArrayList<>());
    orderItem.setCartMessages(new ArrayList<>());
    orderItem.setChildOrderItems(new ArrayList<>());
    orderItem.setDiscountingAllowed(true);
    orderItem.setDiscreteOrderItems(new ArrayList<>());
    orderItem.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    orderItem.setHasValidationError(true);
    orderItem.setId(OrderItemPriceDetailAdjustmentImpl.serialVersionUID);
    orderItem.setName("Name");
    orderItem.setOrderItemAdjustments(new ArrayList<>());
    orderItem.setOrderItemAttributes(new HashMap<>());
    orderItem.setOrderItemPriceDetails(new ArrayList<>());
    orderItem.setOrderItemQualifiers(new ArrayList<>());
    orderItem.setOrderItemType(OrderItemType.BASIC);
    orderItem.setParentOrderItem(new BundleOrderItemImpl());
    orderItem.setPersonalMessage(new PersonalMessageImpl());
    orderItem.setProratedOrderItemAdjustments(new ArrayList<>());
    orderItem.setQuantity(1);
    orderItem.setRetailPrice(new Money());
    orderItem.setRetailPriceOverride(true);
    orderItem.setSalePrice(new Money());
    orderItem.setSalePriceOverride(true);
    orderItem.setTaxable(true);
    orderItem.updateSaleAndRetailPrices();
    orderItem.setOrder(order);

    OrderItemPriceDetailImpl orderItemPriceDetail = new OrderItemPriceDetailImpl();
    orderItemPriceDetail.setId(OrderItemPriceDetailAdjustmentImpl.serialVersionUID);
    orderItemPriceDetail.setOrderItemAdjustments(new ArrayList<>());
    orderItemPriceDetail.setQuantity(1);
    orderItemPriceDetail.setUseSalePrice(true);
    orderItemPriceDetail.setOrderItem(orderItem);

    OrderItemPriceDetailAdjustmentImpl orderItemPriceDetailAdjustmentImpl2 = new OrderItemPriceDetailAdjustmentImpl();
    orderItemPriceDetailAdjustmentImpl2.setAppliedToSalePrice(true);
    orderItemPriceDetailAdjustmentImpl2.setFutureCredit(true);
    orderItemPriceDetailAdjustmentImpl2.setId(OrderItemPriceDetailAdjustmentImpl.serialVersionUID);
    orderItemPriceDetailAdjustmentImpl2.setOfferName("Offer Name");
    orderItemPriceDetailAdjustmentImpl2.setReason("Just cause");
    orderItemPriceDetailAdjustmentImpl2.setRetailPriceValue(new Money());
    orderItemPriceDetailAdjustmentImpl2.setValue(new Money());
    Money salesPriceValue = new Money();
    orderItemPriceDetailAdjustmentImpl2.setSalesPriceValue(salesPriceValue);
    orderItemPriceDetailAdjustmentImpl2.setOrderItemPriceDetail(orderItemPriceDetail);

    // Act and Assert
    assertSame(salesPriceValue, orderItemPriceDetailAdjustmentImpl2.getSalesPriceValue());
  }

  /**
   * Test {@link OrderItemPriceDetailAdjustmentImpl#getSalesPriceValue()}.
   * <ul>
   *   <li>Given {@link OrderImpl} (default constructor) Currency is {@code null}.</li>
   *   <li>Then return {@link Money#Money()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderItemPriceDetailAdjustmentImpl#getSalesPriceValue()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money OrderItemPriceDetailAdjustmentImpl.getSalesPriceValue()"})
  public void testGetSalesPriceValue_givenOrderImplCurrencyIsNull_thenReturnMoney() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemPriceDetailAdjustmentImpl.serialVersionUID);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemPriceDetailAdjustmentImpl.serialVersionUID);

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(OrderItemPriceDetailAdjustmentImpl.serialVersionUID);
    auditable2.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(OrderItemPriceDetailAdjustmentImpl.serialVersionUID);

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable2);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
    order.setFulfillmentGroups(new ArrayList<>());
    order.setId(OrderItemPriceDetailAdjustmentImpl.serialVersionUID);
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

    BundleOrderItemImpl orderItem = new BundleOrderItemImpl();
    orderItem.setAuditable(auditable);
    orderItem.setBaseRetailPrice(new Money());
    orderItem.setBaseSalePrice(new Money());
    orderItem.setBundleOrderItemFeePrices(new ArrayList<>());
    orderItem.setCandidateItemOffers(new ArrayList<>());
    orderItem.setCartMessages(new ArrayList<>());
    orderItem.setChildOrderItems(new ArrayList<>());
    orderItem.setDiscountingAllowed(true);
    orderItem.setDiscreteOrderItems(new ArrayList<>());
    orderItem.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    orderItem.setHasValidationError(true);
    orderItem.setId(OrderItemPriceDetailAdjustmentImpl.serialVersionUID);
    orderItem.setName("Name");
    orderItem.setOrderItemAdjustments(new ArrayList<>());
    orderItem.setOrderItemAttributes(new HashMap<>());
    orderItem.setOrderItemPriceDetails(new ArrayList<>());
    orderItem.setOrderItemQualifiers(new ArrayList<>());
    orderItem.setOrderItemType(OrderItemType.BASIC);
    orderItem.setParentOrderItem(new BundleOrderItemImpl());
    orderItem.setPersonalMessage(new PersonalMessageImpl());
    orderItem.setProratedOrderItemAdjustments(new ArrayList<>());
    orderItem.setQuantity(1);
    orderItem.setRetailPrice(new Money());
    orderItem.setRetailPriceOverride(true);
    orderItem.setSalePrice(new Money());
    orderItem.setSalePriceOverride(true);
    orderItem.setTaxable(true);
    orderItem.updateSaleAndRetailPrices();
    orderItem.setOrder(order);

    OrderItemPriceDetailImpl orderItemPriceDetail = new OrderItemPriceDetailImpl();
    orderItemPriceDetail.setId(OrderItemPriceDetailAdjustmentImpl.serialVersionUID);
    orderItemPriceDetail.setOrderItemAdjustments(new ArrayList<>());
    orderItemPriceDetail.setQuantity(1);
    orderItemPriceDetail.setUseSalePrice(true);
    orderItemPriceDetail.setOrderItem(orderItem);

    OrderItemPriceDetailAdjustmentImpl orderItemPriceDetailAdjustmentImpl2 = new OrderItemPriceDetailAdjustmentImpl();
    orderItemPriceDetailAdjustmentImpl2.setAppliedToSalePrice(true);
    orderItemPriceDetailAdjustmentImpl2.setFutureCredit(true);
    orderItemPriceDetailAdjustmentImpl2.setId(OrderItemPriceDetailAdjustmentImpl.serialVersionUID);
    orderItemPriceDetailAdjustmentImpl2.setOfferName("Offer Name");
    orderItemPriceDetailAdjustmentImpl2.setReason("Just cause");
    Money retailPriceValue = new Money();
    orderItemPriceDetailAdjustmentImpl2.setRetailPriceValue(retailPriceValue);
    orderItemPriceDetailAdjustmentImpl2.setValue(new Money());
    orderItemPriceDetailAdjustmentImpl2.setSalesPriceValue(null);
    orderItemPriceDetailAdjustmentImpl2.setOrderItemPriceDetail(orderItemPriceDetail);

    // Act and Assert
    assertEquals(retailPriceValue, orderItemPriceDetailAdjustmentImpl2.getSalesPriceValue());
  }

  /**
   * Test {@link OrderItemPriceDetailAdjustmentImpl#getSalesPriceValue()}.
   * <ul>
   *   <li>Then return {@link Money#ZERO}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderItemPriceDetailAdjustmentImpl#getSalesPriceValue()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money OrderItemPriceDetailAdjustmentImpl.getSalesPriceValue()"})
  public void testGetSalesPriceValue_thenReturnZero() {
    // Arrange
    BundleOrderItemImpl bundleOrderItemImpl = mock(BundleOrderItemImpl.class);
    when(bundleOrderItemImpl.getOrder()).thenReturn(new NullOrderImpl());
    OrderItemPriceDetailImpl orderItemPriceDetail = mock(OrderItemPriceDetailImpl.class);
    when(orderItemPriceDetail.getOrderItem()).thenReturn(bundleOrderItemImpl);

    OrderItemPriceDetailAdjustmentImpl orderItemPriceDetailAdjustmentImpl2 = new OrderItemPriceDetailAdjustmentImpl();
    orderItemPriceDetailAdjustmentImpl2.setOrderItemPriceDetail(orderItemPriceDetail);

    // Act
    Money actualSalesPriceValue = orderItemPriceDetailAdjustmentImpl2.getSalesPriceValue();

    // Assert
    verify(bundleOrderItemImpl).getOrder();
    verify(orderItemPriceDetail).getOrderItem();
    assertEquals(actualSalesPriceValue.ZERO, actualSalesPriceValue);
  }

  /**
   * Test {@link OrderItemPriceDetailAdjustmentImpl#getCurrencyCode()}.
   * <ul>
   *   <li>Given {@link OrderImpl} (default constructor) Currency is {@link BroadleafCurrencyImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderItemPriceDetailAdjustmentImpl#getCurrencyCode()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String OrderItemPriceDetailAdjustmentImpl.getCurrencyCode()"})
  public void testGetCurrencyCode_givenOrderImplCurrencyIsBroadleafCurrencyImpl_thenReturnNull() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemPriceDetailAdjustmentImpl.serialVersionUID);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemPriceDetailAdjustmentImpl.serialVersionUID);

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(OrderItemPriceDetailAdjustmentImpl.serialVersionUID);
    auditable2.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(OrderItemPriceDetailAdjustmentImpl.serialVersionUID);

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable2);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
    order.setFulfillmentGroups(new ArrayList<>());
    order.setId(OrderItemPriceDetailAdjustmentImpl.serialVersionUID);
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

    BundleOrderItemImpl orderItem = new BundleOrderItemImpl();
    orderItem.setAuditable(auditable);
    orderItem.setBaseRetailPrice(new Money());
    orderItem.setBaseSalePrice(new Money());
    orderItem.setBundleOrderItemFeePrices(new ArrayList<>());
    orderItem.setCandidateItemOffers(new ArrayList<>());
    orderItem.setCartMessages(new ArrayList<>());
    orderItem.setChildOrderItems(new ArrayList<>());
    orderItem.setDiscountingAllowed(true);
    orderItem.setDiscreteOrderItems(new ArrayList<>());
    orderItem.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    orderItem.setHasValidationError(true);
    orderItem.setId(OrderItemPriceDetailAdjustmentImpl.serialVersionUID);
    orderItem.setName("Name");
    orderItem.setOrderItemAdjustments(new ArrayList<>());
    orderItem.setOrderItemAttributes(new HashMap<>());
    orderItem.setOrderItemPriceDetails(new ArrayList<>());
    orderItem.setOrderItemQualifiers(new ArrayList<>());
    orderItem.setOrderItemType(OrderItemType.BASIC);
    orderItem.setParentOrderItem(new BundleOrderItemImpl());
    orderItem.setPersonalMessage(new PersonalMessageImpl());
    orderItem.setProratedOrderItemAdjustments(new ArrayList<>());
    orderItem.setQuantity(1);
    orderItem.setRetailPrice(new Money());
    orderItem.setRetailPriceOverride(true);
    orderItem.setSalePrice(new Money());
    orderItem.setSalePriceOverride(true);
    orderItem.setTaxable(true);
    orderItem.updateSaleAndRetailPrices();
    orderItem.setOrder(order);

    OrderItemPriceDetailImpl orderItemPriceDetail = new OrderItemPriceDetailImpl();
    orderItemPriceDetail.setId(OrderItemPriceDetailAdjustmentImpl.serialVersionUID);
    orderItemPriceDetail.setOrderItemAdjustments(new ArrayList<>());
    orderItemPriceDetail.setQuantity(1);
    orderItemPriceDetail.setUseSalePrice(true);
    orderItemPriceDetail.setOrderItem(orderItem);

    OrderItemPriceDetailAdjustmentImpl orderItemPriceDetailAdjustmentImpl2 = new OrderItemPriceDetailAdjustmentImpl();
    orderItemPriceDetailAdjustmentImpl2.setAppliedToSalePrice(true);
    orderItemPriceDetailAdjustmentImpl2.setFutureCredit(true);
    orderItemPriceDetailAdjustmentImpl2.setId(OrderItemPriceDetailAdjustmentImpl.serialVersionUID);
    orderItemPriceDetailAdjustmentImpl2.setOfferName("Offer Name");
    orderItemPriceDetailAdjustmentImpl2.setReason("Just cause");
    orderItemPriceDetailAdjustmentImpl2.setRetailPriceValue(new Money());
    orderItemPriceDetailAdjustmentImpl2.setSalesPriceValue(new Money());
    orderItemPriceDetailAdjustmentImpl2.setValue(new Money());
    orderItemPriceDetailAdjustmentImpl2.setOrderItemPriceDetail(orderItemPriceDetail);

    // Act and Assert
    assertNull(orderItemPriceDetailAdjustmentImpl2.getCurrencyCode());
  }

  /**
   * Test {@link OrderItemPriceDetailAdjustmentImpl#getCurrencyCode()}.
   * <ul>
   *   <li>Given {@link OrderImpl} (default constructor) Currency is {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderItemPriceDetailAdjustmentImpl#getCurrencyCode()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String OrderItemPriceDetailAdjustmentImpl.getCurrencyCode()"})
  public void testGetCurrencyCode_givenOrderImplCurrencyIsNull_thenReturnNull() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemPriceDetailAdjustmentImpl.serialVersionUID);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemPriceDetailAdjustmentImpl.serialVersionUID);

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(OrderItemPriceDetailAdjustmentImpl.serialVersionUID);
    auditable2.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(OrderItemPriceDetailAdjustmentImpl.serialVersionUID);

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable2);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
    order.setFulfillmentGroups(new ArrayList<>());
    order.setId(OrderItemPriceDetailAdjustmentImpl.serialVersionUID);
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

    BundleOrderItemImpl orderItem = new BundleOrderItemImpl();
    orderItem.setAuditable(auditable);
    orderItem.setBaseRetailPrice(new Money());
    orderItem.setBaseSalePrice(new Money());
    orderItem.setBundleOrderItemFeePrices(new ArrayList<>());
    orderItem.setCandidateItemOffers(new ArrayList<>());
    orderItem.setCartMessages(new ArrayList<>());
    orderItem.setChildOrderItems(new ArrayList<>());
    orderItem.setDiscountingAllowed(true);
    orderItem.setDiscreteOrderItems(new ArrayList<>());
    orderItem.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    orderItem.setHasValidationError(true);
    orderItem.setId(OrderItemPriceDetailAdjustmentImpl.serialVersionUID);
    orderItem.setName("Name");
    orderItem.setOrderItemAdjustments(new ArrayList<>());
    orderItem.setOrderItemAttributes(new HashMap<>());
    orderItem.setOrderItemPriceDetails(new ArrayList<>());
    orderItem.setOrderItemQualifiers(new ArrayList<>());
    orderItem.setOrderItemType(OrderItemType.BASIC);
    orderItem.setParentOrderItem(new BundleOrderItemImpl());
    orderItem.setPersonalMessage(new PersonalMessageImpl());
    orderItem.setProratedOrderItemAdjustments(new ArrayList<>());
    orderItem.setQuantity(1);
    orderItem.setRetailPrice(new Money());
    orderItem.setRetailPriceOverride(true);
    orderItem.setSalePrice(new Money());
    orderItem.setSalePriceOverride(true);
    orderItem.setTaxable(true);
    orderItem.updateSaleAndRetailPrices();
    orderItem.setOrder(order);

    OrderItemPriceDetailImpl orderItemPriceDetail = new OrderItemPriceDetailImpl();
    orderItemPriceDetail.setId(OrderItemPriceDetailAdjustmentImpl.serialVersionUID);
    orderItemPriceDetail.setOrderItemAdjustments(new ArrayList<>());
    orderItemPriceDetail.setQuantity(1);
    orderItemPriceDetail.setUseSalePrice(true);
    orderItemPriceDetail.setOrderItem(orderItem);

    OrderItemPriceDetailAdjustmentImpl orderItemPriceDetailAdjustmentImpl2 = new OrderItemPriceDetailAdjustmentImpl();
    orderItemPriceDetailAdjustmentImpl2.setAppliedToSalePrice(true);
    orderItemPriceDetailAdjustmentImpl2.setFutureCredit(true);
    orderItemPriceDetailAdjustmentImpl2.setId(OrderItemPriceDetailAdjustmentImpl.serialVersionUID);
    orderItemPriceDetailAdjustmentImpl2.setOfferName("Offer Name");
    orderItemPriceDetailAdjustmentImpl2.setReason("Just cause");
    orderItemPriceDetailAdjustmentImpl2.setRetailPriceValue(new Money());
    orderItemPriceDetailAdjustmentImpl2.setSalesPriceValue(new Money());
    orderItemPriceDetailAdjustmentImpl2.setValue(new Money());
    orderItemPriceDetailAdjustmentImpl2.setOrderItemPriceDetail(orderItemPriceDetail);

    // Act and Assert
    assertNull(orderItemPriceDetailAdjustmentImpl2.getCurrencyCode());
  }

  /**
   * Test {@link OrderItemPriceDetailAdjustmentImpl#isFutureCredit()}.
   * <ul>
   *   <li>Given {@link OrderItemPriceDetailAdjustmentImpl} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderItemPriceDetailAdjustmentImpl#isFutureCredit()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean OrderItemPriceDetailAdjustmentImpl.isFutureCredit()"})
  public void testIsFutureCredit_givenOrderItemPriceDetailAdjustmentImpl_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new OrderItemPriceDetailAdjustmentImpl()).isFutureCredit());
  }

  /**
   * Test {@link OrderItemPriceDetailAdjustmentImpl#isFutureCredit()}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderItemPriceDetailAdjustmentImpl#isFutureCredit()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean OrderItemPriceDetailAdjustmentImpl.isFutureCredit()"})
  public void testIsFutureCredit_thenReturnTrue() {
    // Arrange
    OrderItemPriceDetailAdjustmentImpl orderItemPriceDetailAdjustmentImpl2 = new OrderItemPriceDetailAdjustmentImpl();
    orderItemPriceDetailAdjustmentImpl2.setAppliedToSalePrice(true);
    orderItemPriceDetailAdjustmentImpl2.setId(OrderItemPriceDetailAdjustmentImpl.serialVersionUID);
    orderItemPriceDetailAdjustmentImpl2.setOfferName("Offer Name");
    orderItemPriceDetailAdjustmentImpl2.setOrderItemPriceDetail(new OrderItemPriceDetailImpl());
    orderItemPriceDetailAdjustmentImpl2.setReason("Just cause");
    orderItemPriceDetailAdjustmentImpl2.setRetailPriceValue(new Money());
    orderItemPriceDetailAdjustmentImpl2.setSalesPriceValue(new Money());
    orderItemPriceDetailAdjustmentImpl2.setValue(new Money());
    orderItemPriceDetailAdjustmentImpl2.setFutureCredit(true);

    // Act and Assert
    assertTrue(orderItemPriceDetailAdjustmentImpl2.isFutureCredit());
  }

  /**
   * Test {@link OrderItemPriceDetailAdjustmentImpl#setFutureCredit(boolean)}.
   * <p>
   * Method under test: {@link OrderItemPriceDetailAdjustmentImpl#setFutureCredit(boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OrderItemPriceDetailAdjustmentImpl.setFutureCredit(boolean)"})
  public void testSetFutureCredit() {
    // Arrange
    OrderItemPriceDetailAdjustmentImpl orderItemPriceDetailAdjustmentImpl2 = new OrderItemPriceDetailAdjustmentImpl();

    // Act
    orderItemPriceDetailAdjustmentImpl2.setFutureCredit(true);

    // Assert
    assertTrue(orderItemPriceDetailAdjustmentImpl2.isFutureCredit);
  }

  /**
   * Test {@link OrderItemPriceDetailAdjustmentImpl#equals(Object)}, and {@link OrderItemPriceDetailAdjustmentImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link OrderItemPriceDetailAdjustmentImpl#equals(Object)}
   *   <li>{@link OrderItemPriceDetailAdjustmentImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean OrderItemPriceDetailAdjustmentImpl.equals(Object)",
      "int OrderItemPriceDetailAdjustmentImpl.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    OrderItemPriceDetailAdjustmentImpl orderItemPriceDetailAdjustmentImpl = new OrderItemPriceDetailAdjustmentImpl();
    orderItemPriceDetailAdjustmentImpl.setAppliedToSalePrice(true);
    orderItemPriceDetailAdjustmentImpl.setFutureCredit(true);
    orderItemPriceDetailAdjustmentImpl.setId(OrderItemPriceDetailAdjustmentImpl.serialVersionUID);
    orderItemPriceDetailAdjustmentImpl.setOfferName("Offer Name");
    orderItemPriceDetailAdjustmentImpl.setOrderItemPriceDetail(new OrderItemPriceDetailImpl());
    orderItemPriceDetailAdjustmentImpl.setReason("Just cause");
    orderItemPriceDetailAdjustmentImpl.setRetailPriceValue(new Money());
    orderItemPriceDetailAdjustmentImpl.setSalesPriceValue(new Money());
    orderItemPriceDetailAdjustmentImpl.setValue(new Money());

    OrderItemPriceDetailAdjustmentImpl orderItemPriceDetailAdjustmentImpl2 = new OrderItemPriceDetailAdjustmentImpl();
    orderItemPriceDetailAdjustmentImpl2.setAppliedToSalePrice(true);
    orderItemPriceDetailAdjustmentImpl2.setFutureCredit(true);
    orderItemPriceDetailAdjustmentImpl2.setId(OrderItemPriceDetailAdjustmentImpl.serialVersionUID);
    orderItemPriceDetailAdjustmentImpl2.setOfferName("Offer Name");
    orderItemPriceDetailAdjustmentImpl2.setOrderItemPriceDetail(new OrderItemPriceDetailImpl());
    orderItemPriceDetailAdjustmentImpl2.setReason("Just cause");
    orderItemPriceDetailAdjustmentImpl2.setRetailPriceValue(new Money());
    orderItemPriceDetailAdjustmentImpl2.setSalesPriceValue(new Money());
    orderItemPriceDetailAdjustmentImpl2.setValue(new Money());

    // Act and Assert
    assertEquals(orderItemPriceDetailAdjustmentImpl, orderItemPriceDetailAdjustmentImpl2);
    int notExpectedHashCodeResult = orderItemPriceDetailAdjustmentImpl.hashCode();
    assertNotEquals(notExpectedHashCodeResult, orderItemPriceDetailAdjustmentImpl2.hashCode());
  }

  /**
   * Test {@link OrderItemPriceDetailAdjustmentImpl#equals(Object)}, and {@link OrderItemPriceDetailAdjustmentImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link OrderItemPriceDetailAdjustmentImpl#equals(Object)}
   *   <li>{@link OrderItemPriceDetailAdjustmentImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean OrderItemPriceDetailAdjustmentImpl.equals(Object)",
      "int OrderItemPriceDetailAdjustmentImpl.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    OrderItemPriceDetailAdjustmentImpl orderItemPriceDetailAdjustmentImpl = new OrderItemPriceDetailAdjustmentImpl();
    orderItemPriceDetailAdjustmentImpl.setAppliedToSalePrice(true);
    orderItemPriceDetailAdjustmentImpl.setFutureCredit(true);
    orderItemPriceDetailAdjustmentImpl.setId(null);
    orderItemPriceDetailAdjustmentImpl.setOfferName("Offer Name");
    orderItemPriceDetailAdjustmentImpl.setOrderItemPriceDetail(null);
    orderItemPriceDetailAdjustmentImpl.setReason("Just cause");
    orderItemPriceDetailAdjustmentImpl.setRetailPriceValue(new Money());
    orderItemPriceDetailAdjustmentImpl.setSalesPriceValue(new Money());
    orderItemPriceDetailAdjustmentImpl.setValue(new Money());

    OrderItemPriceDetailAdjustmentImpl orderItemPriceDetailAdjustmentImpl2 = new OrderItemPriceDetailAdjustmentImpl();
    orderItemPriceDetailAdjustmentImpl2.setAppliedToSalePrice(true);
    orderItemPriceDetailAdjustmentImpl2.setFutureCredit(true);
    orderItemPriceDetailAdjustmentImpl2.setId(OrderItemPriceDetailAdjustmentImpl.serialVersionUID);
    orderItemPriceDetailAdjustmentImpl2.setOfferName("Offer Name");
    orderItemPriceDetailAdjustmentImpl2.setOrderItemPriceDetail(null);
    orderItemPriceDetailAdjustmentImpl2.setReason("Just cause");
    orderItemPriceDetailAdjustmentImpl2.setRetailPriceValue(new Money());
    orderItemPriceDetailAdjustmentImpl2.setSalesPriceValue(new Money());
    orderItemPriceDetailAdjustmentImpl2.setValue(new Money());

    // Act and Assert
    assertEquals(orderItemPriceDetailAdjustmentImpl, orderItemPriceDetailAdjustmentImpl2);
    int expectedHashCodeResult = orderItemPriceDetailAdjustmentImpl.hashCode();
    assertEquals(expectedHashCodeResult, orderItemPriceDetailAdjustmentImpl2.hashCode());
  }

  /**
   * Test {@link OrderItemPriceDetailAdjustmentImpl#equals(Object)}, and {@link OrderItemPriceDetailAdjustmentImpl#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link OrderItemPriceDetailAdjustmentImpl#equals(Object)}
   *   <li>{@link OrderItemPriceDetailAdjustmentImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean OrderItemPriceDetailAdjustmentImpl.equals(Object)",
      "int OrderItemPriceDetailAdjustmentImpl.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    OrderItemPriceDetailAdjustmentImpl orderItemPriceDetailAdjustmentImpl = new OrderItemPriceDetailAdjustmentImpl();
    orderItemPriceDetailAdjustmentImpl.setAppliedToSalePrice(true);
    orderItemPriceDetailAdjustmentImpl.setFutureCredit(true);
    orderItemPriceDetailAdjustmentImpl.setId(OrderItemPriceDetailAdjustmentImpl.serialVersionUID);
    orderItemPriceDetailAdjustmentImpl.setOfferName("Offer Name");
    orderItemPriceDetailAdjustmentImpl.setOrderItemPriceDetail(new OrderItemPriceDetailImpl());
    orderItemPriceDetailAdjustmentImpl.setReason("Just cause");
    orderItemPriceDetailAdjustmentImpl.setRetailPriceValue(new Money());
    orderItemPriceDetailAdjustmentImpl.setSalesPriceValue(new Money());
    orderItemPriceDetailAdjustmentImpl.setValue(new Money());

    // Act and Assert
    assertEquals(orderItemPriceDetailAdjustmentImpl, orderItemPriceDetailAdjustmentImpl);
    int expectedHashCodeResult = orderItemPriceDetailAdjustmentImpl.hashCode();
    assertEquals(expectedHashCodeResult, orderItemPriceDetailAdjustmentImpl.hashCode());
  }

  /**
   * Test {@link OrderItemPriceDetailAdjustmentImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderItemPriceDetailAdjustmentImpl#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean OrderItemPriceDetailAdjustmentImpl.equals(Object)",
      "int OrderItemPriceDetailAdjustmentImpl.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    OrderItemPriceDetailAdjustmentImpl orderItemPriceDetailAdjustmentImpl = new OrderItemPriceDetailAdjustmentImpl();
    orderItemPriceDetailAdjustmentImpl.setAppliedToSalePrice(true);
    orderItemPriceDetailAdjustmentImpl.setFutureCredit(true);
    orderItemPriceDetailAdjustmentImpl.setId(2L);
    orderItemPriceDetailAdjustmentImpl.setOfferName("Offer Name");
    orderItemPriceDetailAdjustmentImpl.setOrderItemPriceDetail(new OrderItemPriceDetailImpl());
    orderItemPriceDetailAdjustmentImpl.setReason("Just cause");
    orderItemPriceDetailAdjustmentImpl.setRetailPriceValue(new Money());
    orderItemPriceDetailAdjustmentImpl.setSalesPriceValue(new Money());
    orderItemPriceDetailAdjustmentImpl.setValue(new Money());

    OrderItemPriceDetailAdjustmentImpl orderItemPriceDetailAdjustmentImpl2 = new OrderItemPriceDetailAdjustmentImpl();
    orderItemPriceDetailAdjustmentImpl2.setAppliedToSalePrice(true);
    orderItemPriceDetailAdjustmentImpl2.setFutureCredit(true);
    orderItemPriceDetailAdjustmentImpl2.setId(OrderItemPriceDetailAdjustmentImpl.serialVersionUID);
    orderItemPriceDetailAdjustmentImpl2.setOfferName("Offer Name");
    orderItemPriceDetailAdjustmentImpl2.setOrderItemPriceDetail(new OrderItemPriceDetailImpl());
    orderItemPriceDetailAdjustmentImpl2.setReason("Just cause");
    orderItemPriceDetailAdjustmentImpl2.setRetailPriceValue(new Money());
    orderItemPriceDetailAdjustmentImpl2.setSalesPriceValue(new Money());
    orderItemPriceDetailAdjustmentImpl2.setValue(new Money());

    // Act and Assert
    assertNotEquals(orderItemPriceDetailAdjustmentImpl, orderItemPriceDetailAdjustmentImpl2);
  }

  /**
   * Test {@link OrderItemPriceDetailAdjustmentImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderItemPriceDetailAdjustmentImpl#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean OrderItemPriceDetailAdjustmentImpl.equals(Object)",
      "int OrderItemPriceDetailAdjustmentImpl.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    OrderItemPriceDetailAdjustmentImpl orderItemPriceDetailAdjustmentImpl = new OrderItemPriceDetailAdjustmentImpl();
    orderItemPriceDetailAdjustmentImpl.setAppliedToSalePrice(true);
    orderItemPriceDetailAdjustmentImpl.setFutureCredit(true);
    orderItemPriceDetailAdjustmentImpl.setId(null);
    orderItemPriceDetailAdjustmentImpl.setOfferName("Offer Name");
    orderItemPriceDetailAdjustmentImpl.setOrderItemPriceDetail(new OrderItemPriceDetailImpl());
    orderItemPriceDetailAdjustmentImpl.setReason("Just cause");
    orderItemPriceDetailAdjustmentImpl.setRetailPriceValue(new Money());
    orderItemPriceDetailAdjustmentImpl.setSalesPriceValue(new Money());
    orderItemPriceDetailAdjustmentImpl.setValue(new Money());

    OrderItemPriceDetailAdjustmentImpl orderItemPriceDetailAdjustmentImpl2 = new OrderItemPriceDetailAdjustmentImpl();
    orderItemPriceDetailAdjustmentImpl2.setAppliedToSalePrice(true);
    orderItemPriceDetailAdjustmentImpl2.setFutureCredit(true);
    orderItemPriceDetailAdjustmentImpl2.setId(OrderItemPriceDetailAdjustmentImpl.serialVersionUID);
    orderItemPriceDetailAdjustmentImpl2.setOfferName("Offer Name");
    orderItemPriceDetailAdjustmentImpl2.setOrderItemPriceDetail(new OrderItemPriceDetailImpl());
    orderItemPriceDetailAdjustmentImpl2.setReason("Just cause");
    orderItemPriceDetailAdjustmentImpl2.setRetailPriceValue(new Money());
    orderItemPriceDetailAdjustmentImpl2.setSalesPriceValue(new Money());
    orderItemPriceDetailAdjustmentImpl2.setValue(new Money());

    // Act and Assert
    assertNotEquals(orderItemPriceDetailAdjustmentImpl, orderItemPriceDetailAdjustmentImpl2);
  }

  /**
   * Test {@link OrderItemPriceDetailAdjustmentImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderItemPriceDetailAdjustmentImpl#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean OrderItemPriceDetailAdjustmentImpl.equals(Object)",
      "int OrderItemPriceDetailAdjustmentImpl.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    OrderItemPriceDetailAdjustmentImpl orderItemPriceDetailAdjustmentImpl = new OrderItemPriceDetailAdjustmentImpl();
    orderItemPriceDetailAdjustmentImpl.setAppliedToSalePrice(true);
    orderItemPriceDetailAdjustmentImpl.setFutureCredit(true);
    orderItemPriceDetailAdjustmentImpl.setId(OrderItemPriceDetailAdjustmentImpl.serialVersionUID);
    orderItemPriceDetailAdjustmentImpl.setOfferName("Offer Name");
    orderItemPriceDetailAdjustmentImpl.setOrderItemPriceDetail(new OrderItemPriceDetailImpl());
    orderItemPriceDetailAdjustmentImpl.setReason("Just cause");
    orderItemPriceDetailAdjustmentImpl.setRetailPriceValue(new Money());
    orderItemPriceDetailAdjustmentImpl.setSalesPriceValue(new Money());
    orderItemPriceDetailAdjustmentImpl.setValue(new Money());

    OrderItemPriceDetailAdjustmentImpl orderItemPriceDetailAdjustmentImpl2 = new OrderItemPriceDetailAdjustmentImpl();
    orderItemPriceDetailAdjustmentImpl2.setAppliedToSalePrice(true);
    orderItemPriceDetailAdjustmentImpl2.setFutureCredit(true);
    orderItemPriceDetailAdjustmentImpl2.setId(null);
    orderItemPriceDetailAdjustmentImpl2.setOfferName("Offer Name");
    orderItemPriceDetailAdjustmentImpl2.setOrderItemPriceDetail(new OrderItemPriceDetailImpl());
    orderItemPriceDetailAdjustmentImpl2.setReason("Just cause");
    orderItemPriceDetailAdjustmentImpl2.setRetailPriceValue(new Money());
    orderItemPriceDetailAdjustmentImpl2.setSalesPriceValue(new Money());
    orderItemPriceDetailAdjustmentImpl2.setValue(new Money());

    // Act and Assert
    assertNotEquals(orderItemPriceDetailAdjustmentImpl, orderItemPriceDetailAdjustmentImpl2);
  }

  /**
   * Test {@link OrderItemPriceDetailAdjustmentImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderItemPriceDetailAdjustmentImpl#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean OrderItemPriceDetailAdjustmentImpl.equals(Object)",
      "int OrderItemPriceDetailAdjustmentImpl.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    OrderItemPriceDetailAdjustmentImpl orderItemPriceDetailAdjustmentImpl = new OrderItemPriceDetailAdjustmentImpl();
    orderItemPriceDetailAdjustmentImpl.setAppliedToSalePrice(true);
    orderItemPriceDetailAdjustmentImpl.setFutureCredit(true);
    orderItemPriceDetailAdjustmentImpl.setId(null);
    orderItemPriceDetailAdjustmentImpl.setOfferName("Offer Name");
    orderItemPriceDetailAdjustmentImpl.setOrderItemPriceDetail(null);
    orderItemPriceDetailAdjustmentImpl.setReason("Just cause");
    orderItemPriceDetailAdjustmentImpl.setRetailPriceValue(new Money());
    orderItemPriceDetailAdjustmentImpl.setSalesPriceValue(new Money());
    orderItemPriceDetailAdjustmentImpl.setValue(new Money());

    OrderItemPriceDetailAdjustmentImpl orderItemPriceDetailAdjustmentImpl2 = new OrderItemPriceDetailAdjustmentImpl();
    orderItemPriceDetailAdjustmentImpl2.setAppliedToSalePrice(true);
    orderItemPriceDetailAdjustmentImpl2.setFutureCredit(true);
    orderItemPriceDetailAdjustmentImpl2.setId(OrderItemPriceDetailAdjustmentImpl.serialVersionUID);
    orderItemPriceDetailAdjustmentImpl2.setOfferName("Offer Name");
    orderItemPriceDetailAdjustmentImpl2.setOrderItemPriceDetail(new OrderItemPriceDetailImpl());
    orderItemPriceDetailAdjustmentImpl2.setReason("Just cause");
    orderItemPriceDetailAdjustmentImpl2.setRetailPriceValue(new Money());
    orderItemPriceDetailAdjustmentImpl2.setSalesPriceValue(new Money());
    orderItemPriceDetailAdjustmentImpl2.setValue(new Money());

    // Act and Assert
    assertNotEquals(orderItemPriceDetailAdjustmentImpl, orderItemPriceDetailAdjustmentImpl2);
  }

  /**
   * Test {@link OrderItemPriceDetailAdjustmentImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderItemPriceDetailAdjustmentImpl#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean OrderItemPriceDetailAdjustmentImpl.equals(Object)",
      "int OrderItemPriceDetailAdjustmentImpl.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    OrderItemPriceDetailAdjustmentImpl orderItemPriceDetailAdjustmentImpl = new OrderItemPriceDetailAdjustmentImpl();
    orderItemPriceDetailAdjustmentImpl.setAppliedToSalePrice(true);
    orderItemPriceDetailAdjustmentImpl.setFutureCredit(false);
    orderItemPriceDetailAdjustmentImpl.setId(null);
    orderItemPriceDetailAdjustmentImpl.setOfferName("Offer Name");
    orderItemPriceDetailAdjustmentImpl.setOrderItemPriceDetail(null);
    orderItemPriceDetailAdjustmentImpl.setReason("Just cause");
    orderItemPriceDetailAdjustmentImpl.setRetailPriceValue(new Money());
    orderItemPriceDetailAdjustmentImpl.setSalesPriceValue(new Money());
    orderItemPriceDetailAdjustmentImpl.setValue(new Money());

    OrderItemPriceDetailAdjustmentImpl orderItemPriceDetailAdjustmentImpl2 = new OrderItemPriceDetailAdjustmentImpl();
    orderItemPriceDetailAdjustmentImpl2.setAppliedToSalePrice(true);
    orderItemPriceDetailAdjustmentImpl2.setFutureCredit(true);
    orderItemPriceDetailAdjustmentImpl2.setId(OrderItemPriceDetailAdjustmentImpl.serialVersionUID);
    orderItemPriceDetailAdjustmentImpl2.setOfferName("Offer Name");
    orderItemPriceDetailAdjustmentImpl2.setOrderItemPriceDetail(null);
    orderItemPriceDetailAdjustmentImpl2.setReason("Just cause");
    orderItemPriceDetailAdjustmentImpl2.setRetailPriceValue(new Money());
    orderItemPriceDetailAdjustmentImpl2.setSalesPriceValue(new Money());
    orderItemPriceDetailAdjustmentImpl2.setValue(new Money());

    // Act and Assert
    assertNotEquals(orderItemPriceDetailAdjustmentImpl, orderItemPriceDetailAdjustmentImpl2);
  }

  /**
   * Test {@link OrderItemPriceDetailAdjustmentImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderItemPriceDetailAdjustmentImpl#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean OrderItemPriceDetailAdjustmentImpl.equals(Object)",
      "int OrderItemPriceDetailAdjustmentImpl.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    OrderItemPriceDetailAdjustmentImpl orderItemPriceDetailAdjustmentImpl = new OrderItemPriceDetailAdjustmentImpl();
    orderItemPriceDetailAdjustmentImpl.setAppliedToSalePrice(true);
    orderItemPriceDetailAdjustmentImpl.setFutureCredit(true);
    orderItemPriceDetailAdjustmentImpl.setId(null);
    orderItemPriceDetailAdjustmentImpl.setOfferName("Offer Name");
    orderItemPriceDetailAdjustmentImpl.setOrderItemPriceDetail(null);
    orderItemPriceDetailAdjustmentImpl.setReason("Reason");
    orderItemPriceDetailAdjustmentImpl.setRetailPriceValue(new Money());
    orderItemPriceDetailAdjustmentImpl.setSalesPriceValue(new Money());
    orderItemPriceDetailAdjustmentImpl.setValue(new Money());

    OrderItemPriceDetailAdjustmentImpl orderItemPriceDetailAdjustmentImpl2 = new OrderItemPriceDetailAdjustmentImpl();
    orderItemPriceDetailAdjustmentImpl2.setAppliedToSalePrice(true);
    orderItemPriceDetailAdjustmentImpl2.setFutureCredit(true);
    orderItemPriceDetailAdjustmentImpl2.setId(OrderItemPriceDetailAdjustmentImpl.serialVersionUID);
    orderItemPriceDetailAdjustmentImpl2.setOfferName("Offer Name");
    orderItemPriceDetailAdjustmentImpl2.setOrderItemPriceDetail(null);
    orderItemPriceDetailAdjustmentImpl2.setReason("Just cause");
    orderItemPriceDetailAdjustmentImpl2.setRetailPriceValue(new Money());
    orderItemPriceDetailAdjustmentImpl2.setSalesPriceValue(new Money());
    orderItemPriceDetailAdjustmentImpl2.setValue(new Money());

    // Act and Assert
    assertNotEquals(orderItemPriceDetailAdjustmentImpl, orderItemPriceDetailAdjustmentImpl2);
  }

  /**
   * Test {@link OrderItemPriceDetailAdjustmentImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderItemPriceDetailAdjustmentImpl#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean OrderItemPriceDetailAdjustmentImpl.equals(Object)",
      "int OrderItemPriceDetailAdjustmentImpl.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    OrderItemPriceDetailAdjustmentImpl orderItemPriceDetailAdjustmentImpl = new OrderItemPriceDetailAdjustmentImpl();
    orderItemPriceDetailAdjustmentImpl.setAppliedToSalePrice(true);
    orderItemPriceDetailAdjustmentImpl.setFutureCredit(true);
    orderItemPriceDetailAdjustmentImpl.setId(null);
    orderItemPriceDetailAdjustmentImpl.setOfferName("Offer Name");
    orderItemPriceDetailAdjustmentImpl.setOrderItemPriceDetail(null);
    orderItemPriceDetailAdjustmentImpl.setReason("Just cause");
    orderItemPriceDetailAdjustmentImpl.setRetailPriceValue(new Money());
    orderItemPriceDetailAdjustmentImpl.setSalesPriceValue(new Money());
    orderItemPriceDetailAdjustmentImpl.setValue(new Money(10.0d));

    OrderItemPriceDetailAdjustmentImpl orderItemPriceDetailAdjustmentImpl2 = new OrderItemPriceDetailAdjustmentImpl();
    orderItemPriceDetailAdjustmentImpl2.setAppliedToSalePrice(true);
    orderItemPriceDetailAdjustmentImpl2.setFutureCredit(true);
    orderItemPriceDetailAdjustmentImpl2.setId(OrderItemPriceDetailAdjustmentImpl.serialVersionUID);
    orderItemPriceDetailAdjustmentImpl2.setOfferName("Offer Name");
    orderItemPriceDetailAdjustmentImpl2.setOrderItemPriceDetail(null);
    orderItemPriceDetailAdjustmentImpl2.setReason("Just cause");
    orderItemPriceDetailAdjustmentImpl2.setRetailPriceValue(new Money());
    orderItemPriceDetailAdjustmentImpl2.setSalesPriceValue(new Money());
    orderItemPriceDetailAdjustmentImpl2.setValue(new Money());

    // Act and Assert
    assertNotEquals(orderItemPriceDetailAdjustmentImpl, orderItemPriceDetailAdjustmentImpl2);
  }

  /**
   * Test {@link OrderItemPriceDetailAdjustmentImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderItemPriceDetailAdjustmentImpl#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean OrderItemPriceDetailAdjustmentImpl.equals(Object)",
      "int OrderItemPriceDetailAdjustmentImpl.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    Money value = mock(Money.class);
    when(value.getAmount()).thenReturn(null);

    OrderItemPriceDetailAdjustmentImpl orderItemPriceDetailAdjustmentImpl = new OrderItemPriceDetailAdjustmentImpl();
    orderItemPriceDetailAdjustmentImpl.setAppliedToSalePrice(true);
    orderItemPriceDetailAdjustmentImpl.setFutureCredit(true);
    orderItemPriceDetailAdjustmentImpl.setId(null);
    orderItemPriceDetailAdjustmentImpl.setOfferName("Offer Name");
    orderItemPriceDetailAdjustmentImpl.setOrderItemPriceDetail(null);
    orderItemPriceDetailAdjustmentImpl.setReason("Just cause");
    orderItemPriceDetailAdjustmentImpl.setRetailPriceValue(new Money());
    orderItemPriceDetailAdjustmentImpl.setSalesPriceValue(new Money());
    orderItemPriceDetailAdjustmentImpl.setValue(value);

    OrderItemPriceDetailAdjustmentImpl orderItemPriceDetailAdjustmentImpl2 = new OrderItemPriceDetailAdjustmentImpl();
    orderItemPriceDetailAdjustmentImpl2.setAppliedToSalePrice(true);
    orderItemPriceDetailAdjustmentImpl2.setFutureCredit(true);
    orderItemPriceDetailAdjustmentImpl2.setId(OrderItemPriceDetailAdjustmentImpl.serialVersionUID);
    orderItemPriceDetailAdjustmentImpl2.setOfferName("Offer Name");
    orderItemPriceDetailAdjustmentImpl2.setOrderItemPriceDetail(null);
    orderItemPriceDetailAdjustmentImpl2.setReason("Just cause");
    orderItemPriceDetailAdjustmentImpl2.setRetailPriceValue(new Money());
    orderItemPriceDetailAdjustmentImpl2.setSalesPriceValue(new Money());
    orderItemPriceDetailAdjustmentImpl2.setValue(new Money());

    // Act and Assert
    assertNotEquals(orderItemPriceDetailAdjustmentImpl, orderItemPriceDetailAdjustmentImpl2);
  }

  /**
   * Test {@link OrderItemPriceDetailAdjustmentImpl#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderItemPriceDetailAdjustmentImpl#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean OrderItemPriceDetailAdjustmentImpl.equals(Object)",
      "int OrderItemPriceDetailAdjustmentImpl.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    OrderItemPriceDetailAdjustmentImpl orderItemPriceDetailAdjustmentImpl = new OrderItemPriceDetailAdjustmentImpl();
    orderItemPriceDetailAdjustmentImpl.setAppliedToSalePrice(true);
    orderItemPriceDetailAdjustmentImpl.setFutureCredit(true);
    orderItemPriceDetailAdjustmentImpl.setId(OrderItemPriceDetailAdjustmentImpl.serialVersionUID);
    orderItemPriceDetailAdjustmentImpl.setOfferName("Offer Name");
    orderItemPriceDetailAdjustmentImpl.setOrderItemPriceDetail(new OrderItemPriceDetailImpl());
    orderItemPriceDetailAdjustmentImpl.setReason("Just cause");
    orderItemPriceDetailAdjustmentImpl.setRetailPriceValue(new Money());
    orderItemPriceDetailAdjustmentImpl.setSalesPriceValue(new Money());
    orderItemPriceDetailAdjustmentImpl.setValue(new Money());

    // Act and Assert
    assertNotEquals(orderItemPriceDetailAdjustmentImpl, null);
  }

  /**
   * Test {@link OrderItemPriceDetailAdjustmentImpl#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderItemPriceDetailAdjustmentImpl#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean OrderItemPriceDetailAdjustmentImpl.equals(Object)",
      "int OrderItemPriceDetailAdjustmentImpl.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    OrderItemPriceDetailAdjustmentImpl orderItemPriceDetailAdjustmentImpl = new OrderItemPriceDetailAdjustmentImpl();
    orderItemPriceDetailAdjustmentImpl.setAppliedToSalePrice(true);
    orderItemPriceDetailAdjustmentImpl.setFutureCredit(true);
    orderItemPriceDetailAdjustmentImpl.setId(OrderItemPriceDetailAdjustmentImpl.serialVersionUID);
    orderItemPriceDetailAdjustmentImpl.setOfferName("Offer Name");
    orderItemPriceDetailAdjustmentImpl.setOrderItemPriceDetail(new OrderItemPriceDetailImpl());
    orderItemPriceDetailAdjustmentImpl.setReason("Just cause");
    orderItemPriceDetailAdjustmentImpl.setRetailPriceValue(new Money());
    orderItemPriceDetailAdjustmentImpl.setSalesPriceValue(new Money());
    orderItemPriceDetailAdjustmentImpl.setValue(new Money());

    // Act and Assert
    assertNotEquals(orderItemPriceDetailAdjustmentImpl, "Different type to OrderItemPriceDetailAdjustmentImpl");
  }

  /**
   * Test {@link OrderItemPriceDetailAdjustmentImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   * <p>
   * Method under test: {@link OrderItemPriceDetailAdjustmentImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "CreateResponse OrderItemPriceDetailAdjustmentImpl.createOrRetrieveCopyInstance(MultiTenantCopyContext)"})
  public void testCreateOrRetrieveCopyInstance() throws CloneNotSupportedException {
    // Arrange
    OrderItemPriceDetailAdjustmentImpl orderItemPriceDetailAdjustmentImpl2 = new OrderItemPriceDetailAdjustmentImpl();
    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    CreateResponse<Object> createResponse = new CreateResponse<>("Clone", true);

    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<OrderItemPriceDetailAdjustment> actualCreateOrRetrieveCopyInstanceResult = orderItemPriceDetailAdjustmentImpl2
        .createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
  }

  /**
   * Test new {@link OrderItemPriceDetailAdjustmentImpl} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link OrderItemPriceDetailAdjustmentImpl}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OrderItemPriceDetailAdjustmentImpl.<init>()"})
  public void testNewOrderItemPriceDetailAdjustmentImpl() {
    // Arrange and Act
    OrderItemPriceDetailAdjustmentImpl actualOrderItemPriceDetailAdjustmentImpl = new OrderItemPriceDetailAdjustmentImpl();

    // Assert
    assertNull(actualOrderItemPriceDetailAdjustmentImpl.getId());
    assertNull(actualOrderItemPriceDetailAdjustmentImpl.getOfferName());
    assertNull(actualOrderItemPriceDetailAdjustmentImpl.getReason());
    assertNull(actualOrderItemPriceDetailAdjustmentImpl.retailValue);
    assertNull(actualOrderItemPriceDetailAdjustmentImpl.salesValue);
    assertNull(actualOrderItemPriceDetailAdjustmentImpl.getOffer());
    assertNull(actualOrderItemPriceDetailAdjustmentImpl.deproxiedOffer);
    assertNull(actualOrderItemPriceDetailAdjustmentImpl.offer);
    assertNull(actualOrderItemPriceDetailAdjustmentImpl.getOrderItemPriceDetail());
    assertFalse(actualOrderItemPriceDetailAdjustmentImpl.isAppliedToSalePrice());
    assertFalse(actualOrderItemPriceDetailAdjustmentImpl.isFutureCredit);
    assertEquals(new BigDecimal("0.00"), actualOrderItemPriceDetailAdjustmentImpl.value);
  }
}
