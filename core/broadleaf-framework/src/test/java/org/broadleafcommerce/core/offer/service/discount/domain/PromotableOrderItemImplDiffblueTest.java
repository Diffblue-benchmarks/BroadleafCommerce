package org.broadleafcommerce.core.offer.service.discount.domain;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.broadleafcommerce.common.audit.Auditable;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.core.order.domain.BundleOrderItemImpl;
import org.broadleafcommerce.core.order.domain.DiscreteOrderItemImpl;
import org.broadleafcommerce.core.order.domain.GiftWrapOrderItemImpl;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.OrderItem;
import org.broadleafcommerce.core.order.domain.OrderItemImpl;
import org.broadleafcommerce.core.order.domain.PersonalMessageImpl;
import org.broadleafcommerce.core.order.service.type.OrderItemType;
import org.junit.Ignore;
import org.junit.Test;

public class PromotableOrderItemImplDiffblueTest {
  /**
   * Test
   * {@link PromotableOrderItemImpl#PromotableOrderItemImpl(OrderItem, PromotableOrder, PromotableItemFactory, boolean)}.
   * <ul>
   *   <li>When {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PromotableOrderItemImpl#PromotableOrderItemImpl(OrderItem, PromotableOrder, PromotableItemFactory, boolean)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testNewPromotableOrderItemImpl_whenTrue() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange
    BundleOrderItemImpl orderItem = new BundleOrderItemImpl();
    NullOrderImpl order = new NullOrderImpl();
    PromotableOrderImpl promotableOrder = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    // Act
    new PromotableOrderItemImpl(orderItem, promotableOrder,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

  }

  /**
   * Test
   * {@link PromotableOrderItemImpl#PromotableOrderItemImpl(OrderItem, PromotableOrder, PromotableItemFactory, boolean)}.
   * <ul>
   *   <li>When {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PromotableOrderItemImpl#PromotableOrderItemImpl(OrderItem, PromotableOrder, PromotableItemFactory, boolean)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testNewPromotableOrderItemImpl_whenTrue2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.NullPointerException
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange
    NullOrderImpl order = new NullOrderImpl();
    PromotableOrderImpl promotableOrder = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    // Act
    new PromotableOrderItemImpl(null, promotableOrder, new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()),
        true);

  }

  /**
   * Test {@link PromotableOrderItemImpl#resetPriceDetails()}.
   * <p>
   * Method under test: {@link PromotableOrderItemImpl#resetPriceDetails()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testResetPriceDetails() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange
    BundleOrderItemImpl orderItem = new BundleOrderItemImpl();
    NullOrderImpl order = new NullOrderImpl();
    PromotableOrderImpl promotableOrder = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    // Act
    (new PromotableOrderItemImpl(orderItem, promotableOrder,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true)).resetPriceDetails();
  }

  /**
   * Test {@link PromotableOrderItemImpl#initializePriceDetails()}.
   * <p>
   * Method under test: {@link PromotableOrderItemImpl#initializePriceDetails()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testInitializePriceDetails() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange
    BundleOrderItemImpl orderItem = new BundleOrderItemImpl();
    NullOrderImpl order = new NullOrderImpl();
    PromotableOrderImpl promotableOrder = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    // Act
    (new PromotableOrderItemImpl(orderItem, promotableOrder,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true)).initializePriceDetails();
  }

  /**
   * Test {@link PromotableOrderItemImpl#updateRuleVariables(Map)}.
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PromotableOrderItemImpl#updateRuleVariables(Map)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testUpdateRuleVariables_whenHashMap() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange
    BundleOrderItemImpl orderItem = new BundleOrderItemImpl();
    NullOrderImpl order = new NullOrderImpl();
    PromotableOrderImpl promotableOrder = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    PromotableOrderItemImpl promotableOrderItemImpl = new PromotableOrderItemImpl(orderItem, promotableOrder,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    // Act
    promotableOrderItemImpl.updateRuleVariables(new HashMap<>());
  }

  /**
   * Test {@link PromotableOrderItemImpl#isDiscountingAllowed()}.
   * <p>
   * Method under test: {@link PromotableOrderItemImpl#isDiscountingAllowed()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testIsDiscountingAllowed() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange
    BundleOrderItemImpl orderItem = new BundleOrderItemImpl();
    NullOrderImpl order = new NullOrderImpl();
    PromotableOrderImpl promotableOrder = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    // Act
    (new PromotableOrderItemImpl(orderItem, promotableOrder,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true)).isDiscountingAllowed();
  }

  /**
   * Test {@link PromotableOrderItemImpl#isDiscountingAllowed()}.
   * <p>
   * Method under test: {@link PromotableOrderItemImpl#isDiscountingAllowed()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testIsDiscountingAllowed2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.NullPointerException
    //       at org.broadleafcommerce.core.order.domain.DiscreteOrderItemImpl.isDiscountingAllowed(DiscreteOrderItemImpl.java:469)
    //       at org.broadleafcommerce.core.offer.service.discount.domain.PromotableOrderItemImpl.isDiscountingAllowed(PromotableOrderItemImpl.java:110)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange
    DiscreteOrderItemImpl orderItem = new DiscreteOrderItemImpl();
    NullOrderImpl order = new NullOrderImpl();
    PromotableOrderImpl promotableOrder = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    // Act
    (new PromotableOrderItemImpl(orderItem, promotableOrder,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true)).isDiscountingAllowed();
  }

  /**
   * Test {@link PromotableOrderItemImpl#isOrderItemContainer()}.
   * <p>
   * Method under test: {@link PromotableOrderItemImpl#isOrderItemContainer()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testIsOrderItemContainer() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange
    BundleOrderItemImpl orderItem = new BundleOrderItemImpl();
    NullOrderImpl order = new NullOrderImpl();
    PromotableOrderImpl promotableOrder = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    // Act
    (new PromotableOrderItemImpl(orderItem, promotableOrder,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true)).isOrderItemContainer();
  }

  /**
   * Test {@link PromotableOrderItemImpl#getOrderItemContainer()}.
   * <p>
   * Method under test: {@link PromotableOrderItemImpl#getOrderItemContainer()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetOrderItemContainer() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange
    BundleOrderItemImpl orderItem = new BundleOrderItemImpl();
    NullOrderImpl order = new NullOrderImpl();
    PromotableOrderImpl promotableOrder = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    // Act
    (new PromotableOrderItemImpl(orderItem, promotableOrder,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true)).getOrderItemContainer();
  }

  /**
   * Test {@link PromotableOrderItemImpl#getSalePriceBeforeAdjustments()}.
   * <p>
   * Method under test:
   * {@link PromotableOrderItemImpl#getSalePriceBeforeAdjustments()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetSalePriceBeforeAdjustments() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange
    BundleOrderItemImpl orderItem = new BundleOrderItemImpl();
    NullOrderImpl order = new NullOrderImpl();
    PromotableOrderImpl promotableOrder = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    // Act
    (new PromotableOrderItemImpl(orderItem, promotableOrder,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true)).getSalePriceBeforeAdjustments();
  }

  /**
   * Test {@link PromotableOrderItemImpl#getSalePriceBeforeAdjustments()}.
   * <p>
   * Method under test:
   * {@link PromotableOrderItemImpl#getSalePriceBeforeAdjustments()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetSalePriceBeforeAdjustments2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.NullPointerException
    //       at org.broadleafcommerce.core.order.domain.DiscreteOrderItemImpl.updateSalePrice(DiscreteOrderItemImpl.java:261)
    //       at org.broadleafcommerce.core.order.domain.DiscreteOrderItemImpl.updateSaleAndRetailPrices(DiscreteOrderItemImpl.java:336)
    //       at org.broadleafcommerce.core.order.domain.OrderItemImpl.getSalePrice(OrderItemImpl.java:296)
    //       at org.broadleafcommerce.core.offer.service.discount.domain.PromotableOrderItemImpl.getSalePriceBeforeAdjustments(PromotableOrderItemImpl.java:131)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange
    DiscreteOrderItemImpl orderItem = new DiscreteOrderItemImpl();
    NullOrderImpl order = new NullOrderImpl();
    PromotableOrderImpl promotableOrder = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    // Act
    (new PromotableOrderItemImpl(orderItem, promotableOrder,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true)).getSalePriceBeforeAdjustments();
  }

  /**
   * Test {@link PromotableOrderItemImpl#getRetailPriceBeforeAdjustments()}.
   * <p>
   * Method under test:
   * {@link PromotableOrderItemImpl#getRetailPriceBeforeAdjustments()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetRetailPriceBeforeAdjustments() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.NullPointerException
    //       at org.broadleafcommerce.core.order.domain.BundleOrderItemImpl.getRetailPrice(BundleOrderItemImpl.java:258)
    //       at org.broadleafcommerce.core.offer.service.discount.domain.PromotableOrderItemImpl.getRetailPriceBeforeAdjustments(PromotableOrderItemImpl.java:135)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange
    BundleOrderItemImpl orderItem = new BundleOrderItemImpl();
    NullOrderImpl order = new NullOrderImpl();
    PromotableOrderImpl promotableOrder = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    // Act
    (new PromotableOrderItemImpl(orderItem, promotableOrder,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true)).getRetailPriceBeforeAdjustments();
  }

  /**
   * Test {@link PromotableOrderItemImpl#getRetailPriceBeforeAdjustments()}.
   * <ul>
   *   <li>Given {@link BundleOrderItemImpl} (default constructor) Order is
   * {@link NullOrderImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PromotableOrderItemImpl#getRetailPriceBeforeAdjustments()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetRetailPriceBeforeAdjustments_givenBundleOrderItemImplOrderIsNullOrderImpl() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange
    BundleOrderItemImpl orderItem = new BundleOrderItemImpl();
    orderItem.setOrder(new NullOrderImpl());
    NullOrderImpl order = new NullOrderImpl();
    PromotableOrderImpl promotableOrder = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    // Act
    (new PromotableOrderItemImpl(orderItem, promotableOrder,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true)).getRetailPriceBeforeAdjustments();
  }

  /**
   * Test {@link PromotableOrderItemImpl#getPriceBeforeAdjustments(boolean)}.
   * <p>
   * Method under test:
   * {@link PromotableOrderItemImpl#getPriceBeforeAdjustments(boolean)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetPriceBeforeAdjustments() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.NullPointerException
    //       at org.broadleafcommerce.core.order.domain.BundleOrderItemImpl.getRetailPrice(BundleOrderItemImpl.java:258)
    //       at org.broadleafcommerce.core.offer.service.discount.domain.PromotableOrderItemImpl.getRetailPriceBeforeAdjustments(PromotableOrderItemImpl.java:135)
    //       at org.broadleafcommerce.core.offer.service.discount.domain.PromotableOrderItemImpl.getPriceBeforeAdjustments(PromotableOrderItemImpl.java:142)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange
    BundleOrderItemImpl orderItem = new BundleOrderItemImpl();
    NullOrderImpl order = new NullOrderImpl();
    PromotableOrderImpl promotableOrder = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    // Act
    (new PromotableOrderItemImpl(orderItem, promotableOrder,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true)).getPriceBeforeAdjustments(true);
  }

  /**
   * Test {@link PromotableOrderItemImpl#getPriceBeforeAdjustments(boolean)}.
   * <ul>
   *   <li>Given {@link BundleOrderItemImpl} (default constructor) Order is
   * {@link NullOrderImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PromotableOrderItemImpl#getPriceBeforeAdjustments(boolean)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetPriceBeforeAdjustments_givenBundleOrderItemImplOrderIsNullOrderImpl() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange
    BundleOrderItemImpl orderItem = new BundleOrderItemImpl();
    orderItem.setOrder(new NullOrderImpl());
    NullOrderImpl order = new NullOrderImpl();
    PromotableOrderImpl promotableOrder = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    // Act
    (new PromotableOrderItemImpl(orderItem, promotableOrder,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true)).getPriceBeforeAdjustments(true);
  }

  /**
   * Test {@link PromotableOrderItemImpl#getCurrentBasePrice()}.
   * <p>
   * Method under test: {@link PromotableOrderItemImpl#getCurrentBasePrice()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetCurrentBasePrice() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.NullPointerException
    //       at org.broadleafcommerce.core.order.domain.BundleOrderItemImpl.getRetailPrice(BundleOrderItemImpl.java:258)
    //       at org.broadleafcommerce.core.offer.service.discount.domain.PromotableOrderItemImpl.getCurrentBasePrice(PromotableOrderItemImpl.java:149)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange
    BundleOrderItemImpl orderItem = new BundleOrderItemImpl();
    NullOrderImpl order = new NullOrderImpl();
    PromotableOrderImpl promotableOrder = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    // Act
    (new PromotableOrderItemImpl(orderItem, promotableOrder,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true)).getCurrentBasePrice();
  }

  /**
   * Test {@link PromotableOrderItemImpl#getCurrentBasePrice()}.
   * <ul>
   *   <li>Given {@link BundleOrderItemImpl} (default constructor) Order is
   * {@link NullOrderImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link PromotableOrderItemImpl#getCurrentBasePrice()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetCurrentBasePrice_givenBundleOrderItemImplOrderIsNullOrderImpl() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange
    BundleOrderItemImpl orderItem = new BundleOrderItemImpl();
    orderItem.setOrder(new NullOrderImpl());
    NullOrderImpl order = new NullOrderImpl();
    PromotableOrderImpl promotableOrder = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    // Act
    (new PromotableOrderItemImpl(orderItem, promotableOrder,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true)).getCurrentBasePrice();
  }

  /**
   * Test {@link PromotableOrderItemImpl#getQuantity()}.
   * <p>
   * Method under test: {@link PromotableOrderItemImpl#getQuantity()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetQuantity() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange
    BundleOrderItemImpl orderItem = new BundleOrderItemImpl();
    NullOrderImpl order = new NullOrderImpl();
    PromotableOrderImpl promotableOrder = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    // Act
    (new PromotableOrderItemImpl(orderItem, promotableOrder,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true)).getQuantity();
  }

  /**
   * Test {@link PromotableOrderItemImpl#isOnSale()}.
   * <p>
   * Method under test: {@link PromotableOrderItemImpl#isOnSale()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testIsOnSale() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange
    BundleOrderItemImpl orderItem = new BundleOrderItemImpl();
    NullOrderImpl order = new NullOrderImpl();
    PromotableOrderImpl promotableOrder = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    // Act
    (new PromotableOrderItemImpl(orderItem, promotableOrder,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true)).isOnSale();
  }

  /**
   * Test {@link PromotableOrderItemImpl#isOnSale()}.
   * <p>
   * Method under test: {@link PromotableOrderItemImpl#isOnSale()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testIsOnSale2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.NullPointerException
    //       at org.broadleafcommerce.core.order.domain.DiscreteOrderItemImpl.updateSalePrice(DiscreteOrderItemImpl.java:261)
    //       at org.broadleafcommerce.core.order.domain.DiscreteOrderItemImpl.updateSaleAndRetailPrices(DiscreteOrderItemImpl.java:336)
    //       at org.broadleafcommerce.core.order.domain.OrderItemImpl.getSalePrice(OrderItemImpl.java:296)
    //       at org.broadleafcommerce.core.order.domain.OrderItemImpl.getIsOnSale(OrderItemImpl.java:509)
    //       at org.broadleafcommerce.core.offer.service.discount.domain.PromotableOrderItemImpl.isOnSale(PromotableOrderItemImpl.java:159)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange
    DiscreteOrderItemImpl orderItem = new DiscreteOrderItemImpl();
    NullOrderImpl order = new NullOrderImpl();
    PromotableOrderImpl promotableOrder = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    // Act
    (new PromotableOrderItemImpl(orderItem, promotableOrder,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true)).isOnSale();
  }

  /**
   * Test {@link PromotableOrderItemImpl#getCurrency()}.
   * <p>
   * Method under test: {@link PromotableOrderItemImpl#getCurrency()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetCurrency() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    OrderItemImpl orderItem = new OrderItemImpl();
    orderItem.setAuditable(auditable);
    orderItem.setCandidateItemOffers(new ArrayList<>());
    orderItem.setCartMessages(new ArrayList<>());
    orderItem.setChildOrderItems(new ArrayList<>());
    orderItem.setDiscountingAllowed(true);
    orderItem.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    orderItem.setHasValidationError(true);
    orderItem.setId(1L);
    orderItem.setName("Name");
    orderItem.setOrder(new NullOrderImpl());
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
    NullOrderImpl order = new NullOrderImpl();
    PromotableOrderImpl promotableOrder = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    // Act
    (new PromotableOrderItemImpl(orderItem, promotableOrder,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true)).getCurrency();
  }

  /**
   * Test {@link PromotableOrderItemImpl#getCurrency()}.
   * <p>
   * Method under test: {@link PromotableOrderItemImpl#getCurrency()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetCurrency2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.NullPointerException
    //       at org.broadleafcommerce.core.offer.service.discount.domain.PromotableOrderItemImpl.getCurrency(PromotableOrderItemImpl.java:164)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange
    BundleOrderItemImpl orderItem = new BundleOrderItemImpl();
    NullOrderImpl order = new NullOrderImpl();
    PromotableOrderImpl promotableOrder = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    // Act
    (new PromotableOrderItemImpl(orderItem, promotableOrder,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true)).getCurrency();
  }

  /**
   * Test {@link PromotableOrderItemImpl#removeAllItemAdjustments()}.
   * <p>
   * Method under test: {@link PromotableOrderItemImpl#removeAllItemAdjustments()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testRemoveAllItemAdjustments() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange
    BundleOrderItemImpl orderItem = new BundleOrderItemImpl();
    NullOrderImpl order = new NullOrderImpl();
    PromotableOrderImpl promotableOrder = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    // Act
    (new PromotableOrderItemImpl(orderItem, promotableOrder,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true)).removeAllItemAdjustments();
  }

  /**
   * Test {@link PromotableOrderItemImpl#removeAllItemAdjustments()}.
   * <p>
   * Method under test: {@link PromotableOrderItemImpl#removeAllItemAdjustments()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testRemoveAllItemAdjustments2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.NullPointerException
    //       at org.broadleafcommerce.core.order.domain.BundleOrderItemImpl.getRetailPrice(BundleOrderItemImpl.java:258)
    //       at org.broadleafcommerce.core.offer.service.discount.domain.PromotableOrderItemImpl.getRetailPriceBeforeAdjustments(PromotableOrderItemImpl.java:135)
    //       at org.broadleafcommerce.core.offer.service.discount.domain.PromotableOrderItemPriceDetailImpl.chooseSaleOrRetailAdjustments(PromotableOrderItemPriceDetailImpl.java:144)
    //       at org.broadleafcommerce.core.offer.service.discount.domain.PromotableOrderItemPriceDetailImpl.removeAllAdjustments(PromotableOrderItemPriceDetailImpl.java:197)
    //       at org.broadleafcommerce.core.offer.service.discount.domain.PromotableOrderItemImpl.removeAllItemAdjustments(PromotableOrderItemImpl.java:178)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange
    BundleOrderItemImpl orderItem = new BundleOrderItemImpl();
    NullOrderImpl order = new NullOrderImpl();
    PromotableOrderImpl promotableOrder = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    // Act
    (new PromotableOrderItemImpl(orderItem, promotableOrder,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), false)).removeAllItemAdjustments();
  }

  /**
   * Test
   * {@link PromotableOrderItemImpl#mergeDetails(PromotableOrderItemPriceDetail, PromotableOrderItemPriceDetail)}.
   * <p>
   * Method under test:
   * {@link PromotableOrderItemImpl#mergeDetails(PromotableOrderItemPriceDetail, PromotableOrderItemPriceDetail)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testMergeDetails() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange
    BundleOrderItemImpl orderItem = new BundleOrderItemImpl();
    NullOrderImpl order = new NullOrderImpl();
    PromotableOrderImpl promotableOrder = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    PromotableOrderItemImpl promotableOrderItemImpl = new PromotableOrderItemImpl(orderItem, promotableOrder,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);
    PromotableOrderItemPriceDetailWrapper firstDetail = new PromotableOrderItemPriceDetailWrapper(
        new PromotableOrderItemPriceDetailImpl(new PromotableOrderItemImpl(new BundleOrderItemImpl(),
            mock(PromotableOrder.class), mock(PromotableItemFactory.class), true), 1));

    // Act
    promotableOrderItemImpl
        .mergeDetails(firstDetail,
            new PromotableOrderItemPriceDetailWrapper(
                new PromotableOrderItemPriceDetailImpl(new PromotableOrderItemImpl(new BundleOrderItemImpl(),
                    mock(PromotableOrder.class), mock(PromotableItemFactory.class), true), 1)));
  }

  /**
   * Test
   * {@link PromotableOrderItemImpl#mergeDetails(PromotableOrderItemPriceDetail, PromotableOrderItemPriceDetail)}.
   * <p>
   * Method under test:
   * {@link PromotableOrderItemImpl#mergeDetails(PromotableOrderItemPriceDetail, PromotableOrderItemPriceDetail)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testMergeDetails2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.NullPointerException
    //       at org.broadleafcommerce.core.offer.service.discount.domain.PromotableOrderItemPriceDetailWrapper.getQuantity(PromotableOrderItemPriceDetailWrapper.java:78)
    //       at org.broadleafcommerce.core.offer.service.discount.domain.PromotableOrderItemImpl.mergeDetails(PromotableOrderItemImpl.java:188)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange
    BundleOrderItemImpl orderItem = new BundleOrderItemImpl();
    NullOrderImpl order = new NullOrderImpl();
    PromotableOrderImpl promotableOrder = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    PromotableOrderItemImpl promotableOrderItemImpl = new PromotableOrderItemImpl(orderItem, promotableOrder,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);
    PromotableOrderItemPriceDetailWrapper firstDetail = new PromotableOrderItemPriceDetailWrapper(null);

    // Act
    promotableOrderItemImpl
        .mergeDetails(firstDetail,
            new PromotableOrderItemPriceDetailWrapper(
                new PromotableOrderItemPriceDetailImpl(new PromotableOrderItemImpl(new BundleOrderItemImpl(),
                    mock(PromotableOrder.class), mock(PromotableItemFactory.class), true), 1)));
  }

  /**
   * Test {@link PromotableOrderItemImpl#mergeLikeDetails()}.
   * <p>
   * Method under test: {@link PromotableOrderItemImpl#mergeLikeDetails()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testMergeLikeDetails() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange
    BundleOrderItemImpl orderItem = new BundleOrderItemImpl();
    NullOrderImpl order = new NullOrderImpl();
    PromotableOrderImpl promotableOrder = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    // Act
    (new PromotableOrderItemImpl(orderItem, promotableOrder,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true)).mergeLikeDetails();
  }

  /**
   * Test {@link PromotableOrderItemImpl#getOrderItemId()}.
   * <p>
   * Method under test: {@link PromotableOrderItemImpl#getOrderItemId()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetOrderItemId() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange
    BundleOrderItemImpl orderItem = new BundleOrderItemImpl();
    NullOrderImpl order = new NullOrderImpl();
    PromotableOrderImpl promotableOrder = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    // Act
    (new PromotableOrderItemImpl(orderItem, promotableOrder,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true)).getOrderItemId();
  }

  /**
   * Test {@link PromotableOrderItemImpl#calculateTotalWithAdjustments()}.
   * <p>
   * Method under test:
   * {@link PromotableOrderItemImpl#calculateTotalWithAdjustments()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testCalculateTotalWithAdjustments() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.NullPointerException
    //       at org.broadleafcommerce.core.offer.service.discount.domain.PromotableOrderItemImpl.getCurrency(PromotableOrderItemImpl.java:164)
    //       at org.broadleafcommerce.core.offer.service.discount.domain.PromotableOrderItemImpl.calculateTotalWithAdjustments(PromotableOrderItemImpl.java:225)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange
    BundleOrderItemImpl orderItem = new BundleOrderItemImpl();
    NullOrderImpl order = new NullOrderImpl();
    PromotableOrderImpl promotableOrder = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    // Act
    (new PromotableOrderItemImpl(orderItem, promotableOrder,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true)).calculateTotalWithAdjustments();
  }

  /**
   * Test {@link PromotableOrderItemImpl#calculateTotalWithAdjustments()}.
   * <ul>
   *   <li>Given {@link OrderItemImpl} (default constructor) RetailPrice is
   * {@link Money#Money()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PromotableOrderItemImpl#calculateTotalWithAdjustments()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testCalculateTotalWithAdjustments_givenOrderItemImplRetailPriceIsMoney() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    OrderItemImpl orderItem = new OrderItemImpl();
    orderItem.setAuditable(auditable);
    orderItem.setCandidateItemOffers(new ArrayList<>());
    orderItem.setCartMessages(new ArrayList<>());
    orderItem.setChildOrderItems(new ArrayList<>());
    orderItem.setDiscountingAllowed(true);
    orderItem.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    orderItem.setHasValidationError(true);
    orderItem.setId(1L);
    orderItem.setName("Name");
    orderItem.setOrder(new NullOrderImpl());
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
    NullOrderImpl order = new NullOrderImpl();
    PromotableOrderImpl promotableOrder = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    // Act
    (new PromotableOrderItemImpl(orderItem, promotableOrder,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true)).calculateTotalWithAdjustments();
  }

  /**
   * Test {@link PromotableOrderItemImpl#calculateTotalWithoutAdjustments()}.
   * <p>
   * Method under test:
   * {@link PromotableOrderItemImpl#calculateTotalWithoutAdjustments()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testCalculateTotalWithoutAdjustments() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange
    BundleOrderItemImpl orderItem = new BundleOrderItemImpl();
    orderItem.setOrder(new NullOrderImpl());
    NullOrderImpl order = new NullOrderImpl();
    PromotableOrderImpl promotableOrder = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    // Act
    (new PromotableOrderItemImpl(orderItem, promotableOrder,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true)).calculateTotalWithoutAdjustments();
  }

  /**
   * Test {@link PromotableOrderItemImpl#calculateTotalWithoutAdjustments()}.
   * <p>
   * Method under test:
   * {@link PromotableOrderItemImpl#calculateTotalWithoutAdjustments()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testCalculateTotalWithoutAdjustments2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.NullPointerException
    //       at org.broadleafcommerce.core.order.domain.BundleOrderItemImpl.getRetailPrice(BundleOrderItemImpl.java:258)
    //       at org.broadleafcommerce.core.offer.service.discount.domain.PromotableOrderItemImpl.getCurrentBasePrice(PromotableOrderItemImpl.java:149)
    //       at org.broadleafcommerce.core.offer.service.discount.domain.PromotableOrderItemImpl.calculateTotalWithoutAdjustments(PromotableOrderItemImpl.java:234)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange
    BundleOrderItemImpl orderItem = new BundleOrderItemImpl();
    NullOrderImpl order = new NullOrderImpl();
    PromotableOrderImpl promotableOrder = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    // Act
    (new PromotableOrderItemImpl(orderItem, promotableOrder,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true)).calculateTotalWithoutAdjustments();
  }

  /**
   * Test {@link PromotableOrderItemImpl#calculateTotalAdjustmentValue()}.
   * <p>
   * Method under test:
   * {@link PromotableOrderItemImpl#calculateTotalAdjustmentValue()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testCalculateTotalAdjustmentValue() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.NullPointerException
    //       at org.broadleafcommerce.core.offer.service.discount.domain.PromotableOrderItemImpl.getCurrency(PromotableOrderItemImpl.java:164)
    //       at org.broadleafcommerce.core.offer.service.discount.domain.PromotableOrderItemImpl.calculateTotalAdjustmentValue(PromotableOrderItemImpl.java:239)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange
    BundleOrderItemImpl orderItem = new BundleOrderItemImpl();
    NullOrderImpl order = new NullOrderImpl();
    PromotableOrderImpl promotableOrder = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    // Act
    (new PromotableOrderItemImpl(orderItem, promotableOrder,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true)).calculateTotalAdjustmentValue();
  }

  /**
   * Test {@link PromotableOrderItemImpl#calculateTotalAdjustmentValue()}.
   * <ul>
   *   <li>Given {@link Auditable} (default constructor) CreatedBy is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PromotableOrderItemImpl#calculateTotalAdjustmentValue()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testCalculateTotalAdjustmentValue_givenAuditableCreatedByIsOne() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    OrderItemImpl orderItem = new OrderItemImpl();
    orderItem.setAuditable(auditable);
    orderItem.setCandidateItemOffers(new ArrayList<>());
    orderItem.setCartMessages(new ArrayList<>());
    orderItem.setChildOrderItems(new ArrayList<>());
    orderItem.setDiscountingAllowed(true);
    orderItem.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    orderItem.setHasValidationError(true);
    orderItem.setId(1L);
    orderItem.setName("Name");
    orderItem.setOrder(new NullOrderImpl());
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
    NullOrderImpl order = new NullOrderImpl();
    PromotableOrderImpl promotableOrder = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    // Act
    (new PromotableOrderItemImpl(orderItem, promotableOrder,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true)).calculateTotalAdjustmentValue();
  }

  /**
   * Test {@link PromotableOrderItemImpl#createNewDetail(int)}.
   * <p>
   * Method under test: {@link PromotableOrderItemImpl#createNewDetail(int)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testCreateNewDetail() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange
    BundleOrderItemImpl orderItem = new BundleOrderItemImpl();
    NullOrderImpl order = new NullOrderImpl();
    PromotableOrderImpl promotableOrder = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    // Act
    (new PromotableOrderItemImpl(orderItem, promotableOrder,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true)).createNewDetail(1);
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link PromotableOrderItemImpl#getExtraDataMap()}
   *   <li>{@link PromotableOrderItemImpl#getOrderItem()}
   *   <li>{@link PromotableOrderItemImpl#getPromotableOrderItemPriceDetails()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    BundleOrderItemImpl orderItem = new BundleOrderItemImpl();
    NullOrderImpl order = new NullOrderImpl();
    PromotableOrderImpl promotableOrder = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    PromotableOrderItemImpl promotableOrderItemImpl = new PromotableOrderItemImpl(orderItem, promotableOrder,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    // Act
    Map<String, Object> actualExtraDataMap = promotableOrderItemImpl.getExtraDataMap();
    OrderItem actualOrderItem = promotableOrderItemImpl.getOrderItem();

    // Assert
    assertTrue(promotableOrderItemImpl.getPromotableOrderItemPriceDetails().isEmpty());
    assertTrue(actualExtraDataMap.isEmpty());
    assertSame(promotableOrderItemImpl.orderItem, actualOrderItem);
  }
}
