package org.broadleafcommerce.core.offer.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.broadleafcommerce.common.audit.Auditable;
import org.broadleafcommerce.common.currency.domain.BroadleafCurrencyImpl;
import org.broadleafcommerce.common.extension.ExtensionResultHolder;
import org.broadleafcommerce.common.extension.ExtensionResultStatusType;
import org.broadleafcommerce.common.locale.domain.LocaleImpl;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.core.offer.domain.Offer;
import org.broadleafcommerce.core.offer.domain.OfferCode;
import org.broadleafcommerce.core.offer.domain.OfferCodeImpl;
import org.broadleafcommerce.core.offer.domain.OfferImpl;
import org.broadleafcommerce.core.offer.service.discount.domain.PromotableCandidateItemOffer;
import org.broadleafcommerce.core.offer.service.discount.domain.PromotableCandidateItemOfferImpl;
import org.broadleafcommerce.core.offer.service.discount.domain.PromotableItemFactoryImpl;
import org.broadleafcommerce.core.offer.service.discount.domain.PromotableOfferUtilityImpl;
import org.broadleafcommerce.core.offer.service.discount.domain.PromotableOrder;
import org.broadleafcommerce.core.offer.service.discount.domain.PromotableOrderImpl;
import org.broadleafcommerce.core.offer.service.discount.domain.PromotableOrderItem;
import org.broadleafcommerce.core.offer.service.discount.domain.PromotableOrderItemImpl;
import org.broadleafcommerce.core.order.domain.BundleOrderItemImpl;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.Order;
import org.broadleafcommerce.core.order.domain.OrderImpl;
import org.broadleafcommerce.core.order.domain.OrderItemPriceDetail;
import org.broadleafcommerce.core.order.domain.OrderItemPriceDetailImpl;
import org.broadleafcommerce.core.order.service.type.OrderStatus;
import org.broadleafcommerce.profile.core.domain.Customer;
import org.broadleafcommerce.profile.core.domain.CustomerImpl;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {AbstractOfferServiceExtensionHandler.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class AbstractOfferServiceExtensionHandlerDiffblueTest {
  @Autowired
  private AbstractOfferServiceExtensionHandler abstractOfferServiceExtensionHandler;

  /**
   * Test
   * {@link AbstractOfferServiceExtensionHandler#applyAdditionalFilters(List, Order)}.
   * <ul>
   *   <li>Given {@link OfferImpl} (default constructor).</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link OfferImpl} (default
   * constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractOfferServiceExtensionHandler#applyAdditionalFilters(List, Order)}
   */
  @Test
  public void testApplyAdditionalFilters_givenOfferImpl_whenArrayListAddOfferImpl() {
    // Arrange
    ArrayList<Offer> offers = new ArrayList<>();
    offers.add(new OfferImpl());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        abstractOfferServiceExtensionHandler.applyAdditionalFilters(offers, new NullOrderImpl()));
  }

  /**
   * Test
   * {@link AbstractOfferServiceExtensionHandler#applyAdditionalFilters(List, Order)}.
   * <ul>
   *   <li>Given {@link OfferImpl} (default constructor).</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link OfferImpl} (default
   * constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractOfferServiceExtensionHandler#applyAdditionalFilters(List, Order)}
   */
  @Test
  public void testApplyAdditionalFilters_givenOfferImpl_whenArrayListAddOfferImpl2() {
    // Arrange
    ArrayList<Offer> offers = new ArrayList<>();
    offers.add(new OfferImpl());
    offers.add(new OfferImpl());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        abstractOfferServiceExtensionHandler.applyAdditionalFilters(offers, new NullOrderImpl()));
  }

  /**
   * Test
   * {@link AbstractOfferServiceExtensionHandler#applyAdditionalFilters(List, Order)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractOfferServiceExtensionHandler#applyAdditionalFilters(List, Order)}
   */
  @Test
  public void testApplyAdditionalFilters_whenArrayList() {
    // Arrange
    ArrayList<Offer> offers = new ArrayList<>();

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        abstractOfferServiceExtensionHandler.applyAdditionalFilters(offers, new NullOrderImpl()));
  }

  /**
   * Test
   * {@link AbstractOfferServiceExtensionHandler#applyAdditionalFilters(List, Order)}.
   * <ul>
   *   <li>When {@link NullOrderImpl}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractOfferServiceExtensionHandler#applyAdditionalFilters(List, Order)}
   */
  @Test
  public void testApplyAdditionalFilters_whenNullOrderImpl() {
    // Arrange, Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        abstractOfferServiceExtensionHandler.applyAdditionalFilters(new ArrayList<>(), mock(NullOrderImpl.class)));
  }

  /**
   * Test
   * {@link AbstractOfferServiceExtensionHandler#buildOfferCodeListForCustomer(Customer, List)}.
   * <ul>
   *   <li>Given {@link OfferCodeImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractOfferServiceExtensionHandler#buildOfferCodeListForCustomer(Customer, List)}
   */
  @Test
  public void testBuildOfferCodeListForCustomer_givenOfferCodeImpl() {
    // Arrange
    CustomerImpl customer = new CustomerImpl();

    ArrayList<OfferCode> offerCodes = new ArrayList<>();
    offerCodes.add(new OfferCodeImpl());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        abstractOfferServiceExtensionHandler.buildOfferCodeListForCustomer(customer, offerCodes));
  }

  /**
   * Test
   * {@link AbstractOfferServiceExtensionHandler#buildOfferCodeListForCustomer(Customer, List)}.
   * <ul>
   *   <li>Given {@link OfferCodeImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractOfferServiceExtensionHandler#buildOfferCodeListForCustomer(Customer, List)}
   */
  @Test
  public void testBuildOfferCodeListForCustomer_givenOfferCodeImpl2() {
    // Arrange
    CustomerImpl customer = new CustomerImpl();

    ArrayList<OfferCode> offerCodes = new ArrayList<>();
    offerCodes.add(new OfferCodeImpl());
    offerCodes.add(new OfferCodeImpl());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        abstractOfferServiceExtensionHandler.buildOfferCodeListForCustomer(customer, offerCodes));
  }

  /**
   * Test
   * {@link AbstractOfferServiceExtensionHandler#buildOfferCodeListForCustomer(Customer, List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractOfferServiceExtensionHandler#buildOfferCodeListForCustomer(Customer, List)}
   */
  @Test
  public void testBuildOfferCodeListForCustomer_whenArrayList() {
    // Arrange
    CustomerImpl customer = new CustomerImpl();

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        abstractOfferServiceExtensionHandler.buildOfferCodeListForCustomer(customer, new ArrayList<>()));
  }

  /**
   * Test
   * {@link AbstractOfferServiceExtensionHandler#buildOfferCodeListForCustomer(Customer, List)}.
   * <ul>
   *   <li>When {@link CustomerImpl}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractOfferServiceExtensionHandler#buildOfferCodeListForCustomer(Customer, List)}
   */
  @Test
  public void testBuildOfferCodeListForCustomer_whenCustomerImpl() {
    // Arrange
    CustomerImpl customer = mock(CustomerImpl.class);

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        abstractOfferServiceExtensionHandler.buildOfferCodeListForCustomer(customer, new ArrayList<>()));
  }

  /**
   * Test
   * {@link AbstractOfferServiceExtensionHandler#calculatePotentialSavings(PromotableCandidateItemOffer, PromotableOrderItem, int, Map)}.
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractOfferServiceExtensionHandler#calculatePotentialSavings(PromotableCandidateItemOffer, PromotableOrderItem, int, Map)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testCalculatePotentialSavings_whenHashMap() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange
    AbstractOfferServiceExtensionHandler abstractOfferServiceExtensionHandler = new AbstractOfferServiceExtensionHandler();
    NullOrderImpl order = new NullOrderImpl();
    PromotableOrderImpl promotableOrder = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    PromotableCandidateItemOfferImpl itemOffer = new PromotableCandidateItemOfferImpl(promotableOrder, new OfferImpl());

    BundleOrderItemImpl orderItem = new BundleOrderItemImpl();
    NullOrderImpl order2 = new NullOrderImpl();
    PromotableOrderImpl promotableOrder2 = new PromotableOrderImpl(order2,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    PromotableOrderItemImpl item = new PromotableOrderItemImpl(orderItem, promotableOrder2,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    // Act
    abstractOfferServiceExtensionHandler.calculatePotentialSavings(itemOffer, item, 1, new HashMap<>());
  }

  /**
   * Test
   * {@link AbstractOfferServiceExtensionHandler#resetPriceDetails(PromotableOrderItem)}.
   * <p>
   * Method under test:
   * {@link AbstractOfferServiceExtensionHandler#resetPriceDetails(PromotableOrderItem)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testResetPriceDetails() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange
    AbstractOfferServiceExtensionHandler abstractOfferServiceExtensionHandler = new AbstractOfferServiceExtensionHandler();
    BundleOrderItemImpl orderItem = new BundleOrderItemImpl();
    NullOrderImpl order = new NullOrderImpl();
    PromotableOrderImpl promotableOrder = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    // Act
    abstractOfferServiceExtensionHandler.resetPriceDetails(new PromotableOrderItemImpl(orderItem, promotableOrder,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true));
  }

  /**
   * Test
   * {@link AbstractOfferServiceExtensionHandler#applyItemOffer(PromotableOrder, PromotableCandidateItemOffer, Map)}.
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractOfferServiceExtensionHandler#applyItemOffer(PromotableOrder, PromotableCandidateItemOffer, Map)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testApplyItemOffer_whenHashMap() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange
    AbstractOfferServiceExtensionHandler abstractOfferServiceExtensionHandler = new AbstractOfferServiceExtensionHandler();
    NullOrderImpl order = new NullOrderImpl();
    PromotableOrderImpl order2 = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    NullOrderImpl order3 = new NullOrderImpl();
    PromotableOrderImpl promotableOrder = new PromotableOrderImpl(order3,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    PromotableCandidateItemOfferImpl itemOffer = new PromotableCandidateItemOfferImpl(promotableOrder, new OfferImpl());

    // Act
    abstractOfferServiceExtensionHandler.applyItemOffer(order2, itemOffer, new HashMap<>());
  }

  /**
   * Test
   * {@link AbstractOfferServiceExtensionHandler#synchronizeAdjustmentsAndPrices(PromotableOrder)}.
   * <p>
   * Method under test:
   * {@link AbstractOfferServiceExtensionHandler#synchronizeAdjustmentsAndPrices(PromotableOrder)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testSynchronizeAdjustmentsAndPrices() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange
    AbstractOfferServiceExtensionHandler abstractOfferServiceExtensionHandler = new AbstractOfferServiceExtensionHandler();
    NullOrderImpl order = new NullOrderImpl();

    // Act
    abstractOfferServiceExtensionHandler.synchronizeAdjustmentsAndPrices(
        new PromotableOrderImpl(order, new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true));
  }

  /**
   * Test
   * {@link AbstractOfferServiceExtensionHandler#chooseSaleOrRetailAdjustments(PromotableOrder)}.
   * <p>
   * Method under test:
   * {@link AbstractOfferServiceExtensionHandler#chooseSaleOrRetailAdjustments(PromotableOrder)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testChooseSaleOrRetailAdjustments() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange
    AbstractOfferServiceExtensionHandler abstractOfferServiceExtensionHandler = new AbstractOfferServiceExtensionHandler();
    NullOrderImpl order = new NullOrderImpl();

    // Act
    abstractOfferServiceExtensionHandler.chooseSaleOrRetailAdjustments(
        new PromotableOrderImpl(order, new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true));
  }

  /**
   * Test
   * {@link AbstractOfferServiceExtensionHandler#createOrderItemPriceDetailAdjustment(ExtensionResultHolder, OrderItemPriceDetail)}.
   * <p>
   * Method under test:
   * {@link AbstractOfferServiceExtensionHandler#createOrderItemPriceDetailAdjustment(ExtensionResultHolder, OrderItemPriceDetail)}
   */
  @Test
  public void testCreateOrderItemPriceDetailAdjustment() {
    // Arrange
    AbstractOfferServiceExtensionHandler abstractOfferServiceExtensionHandler = new AbstractOfferServiceExtensionHandler();

    ExtensionResultHolder<?> resultHolder = new ExtensionResultHolder<>();
    resultHolder.setResult("Result");
    resultHolder.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, abstractOfferServiceExtensionHandler
        .createOrderItemPriceDetailAdjustment(resultHolder, new OrderItemPriceDetailImpl()));
  }

  /**
   * Test
   * {@link AbstractOfferServiceExtensionHandler#applyAdditionalRuleVariablesForItemOfferEvaluation(PromotableOrderItem, HashMap)}.
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractOfferServiceExtensionHandler#applyAdditionalRuleVariablesForItemOfferEvaluation(PromotableOrderItem, HashMap)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testApplyAdditionalRuleVariablesForItemOfferEvaluation_whenHashMap() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange
    AbstractOfferServiceExtensionHandler abstractOfferServiceExtensionHandler = new AbstractOfferServiceExtensionHandler();
    BundleOrderItemImpl orderItem = new BundleOrderItemImpl();
    NullOrderImpl order = new NullOrderImpl();
    PromotableOrderImpl promotableOrder = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    PromotableOrderItemImpl orderItem2 = new PromotableOrderItemImpl(orderItem, promotableOrder,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    // Act
    abstractOfferServiceExtensionHandler.applyAdditionalRuleVariablesForItemOfferEvaluation(orderItem2,
        new HashMap<>());
  }

  /**
   * Test
   * {@link AbstractOfferServiceExtensionHandler#addAdditionalOffersForCode(List, OfferCode)}.
   * <ul>
   *   <li>Given {@link OfferImpl} (default constructor).</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link OfferImpl} (default
   * constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractOfferServiceExtensionHandler#addAdditionalOffersForCode(List, OfferCode)}
   */
  @Test
  public void testAddAdditionalOffersForCode_givenOfferImpl_whenArrayListAddOfferImpl() {
    // Arrange
    ArrayList<Offer> offers = new ArrayList<>();
    offers.add(new OfferImpl());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        abstractOfferServiceExtensionHandler.addAdditionalOffersForCode(offers, new OfferCodeImpl()));
  }

  /**
   * Test
   * {@link AbstractOfferServiceExtensionHandler#addAdditionalOffersForCode(List, OfferCode)}.
   * <ul>
   *   <li>Given {@link OfferImpl} (default constructor).</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link OfferImpl} (default
   * constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractOfferServiceExtensionHandler#addAdditionalOffersForCode(List, OfferCode)}
   */
  @Test
  public void testAddAdditionalOffersForCode_givenOfferImpl_whenArrayListAddOfferImpl2() {
    // Arrange
    ArrayList<Offer> offers = new ArrayList<>();
    offers.add(new OfferImpl());
    offers.add(new OfferImpl());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        abstractOfferServiceExtensionHandler.addAdditionalOffersForCode(offers, new OfferCodeImpl()));
  }

  /**
   * Test
   * {@link AbstractOfferServiceExtensionHandler#addAdditionalOffersForCode(List, OfferCode)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractOfferServiceExtensionHandler#addAdditionalOffersForCode(List, OfferCode)}
   */
  @Test
  public void testAddAdditionalOffersForCode_whenArrayList() {
    // Arrange
    ArrayList<Offer> offers = new ArrayList<>();

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        abstractOfferServiceExtensionHandler.addAdditionalOffersForCode(offers, new OfferCodeImpl()));
  }

  /**
   * Test
   * {@link AbstractOfferServiceExtensionHandler#addAdditionalOffersForCode(List, OfferCode)}.
   * <ul>
   *   <li>When {@link OfferCodeImpl}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractOfferServiceExtensionHandler#addAdditionalOffersForCode(List, OfferCode)}
   */
  @Test
  public void testAddAdditionalOffersForCode_whenOfferCodeImpl() {
    // Arrange, Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        abstractOfferServiceExtensionHandler.addAdditionalOffersForCode(new ArrayList<>(), mock(OfferCodeImpl.class)));
  }

  /**
   * Test
   * {@link AbstractOfferServiceExtensionHandler#removeOfferCodeFromOrder(OfferCode, Order)}.
   * <ul>
   *   <li>Given {@link Auditable} (default constructor) CreatedBy is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractOfferServiceExtensionHandler#removeOfferCodeFromOrder(OfferCode, Order)}
   */
  @Test
  public void testRemoveOfferCodeFromOrder_givenAuditableCreatedByIsOne() {
    // Arrange
    AbstractOfferServiceExtensionHandler abstractOfferServiceExtensionHandler = new AbstractOfferServiceExtensionHandler();
    OfferCodeImpl offerCode = new OfferCodeImpl();

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(mock(java.sql.Date.class));
    auditable.setDateUpdated(
        java.util.Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    order
        .setSubmitDate(java.util.Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalShipping(new Money());
    order.setTotalTax(new Money());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        abstractOfferServiceExtensionHandler.removeOfferCodeFromOrder(offerCode, order));
  }

  /**
   * Test
   * {@link AbstractOfferServiceExtensionHandler#removeOfferCodeFromOrder(OfferCode, Order)}.
   * <ul>
   *   <li>When {@link NullOrderImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractOfferServiceExtensionHandler#removeOfferCodeFromOrder(OfferCode, Order)}
   */
  @Test
  public void testRemoveOfferCodeFromOrder_whenNullOrderImpl() {
    // Arrange
    AbstractOfferServiceExtensionHandler abstractOfferServiceExtensionHandler = new AbstractOfferServiceExtensionHandler();
    OfferCodeImpl offerCode = new OfferCodeImpl();

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        abstractOfferServiceExtensionHandler.removeOfferCodeFromOrder(offerCode, new NullOrderImpl()));
  }

  /**
   * Test new {@link AbstractOfferServiceExtensionHandler} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link AbstractOfferServiceExtensionHandler}
   */
  @Test
  public void testNewAbstractOfferServiceExtensionHandler() {
    // Arrange and Act
    AbstractOfferServiceExtensionHandler actualAbstractOfferServiceExtensionHandler = new AbstractOfferServiceExtensionHandler();

    // Assert
    assertEquals(0, actualAbstractOfferServiceExtensionHandler.getPriority());
    assertTrue(actualAbstractOfferServiceExtensionHandler.isEnabled());
  }
}
