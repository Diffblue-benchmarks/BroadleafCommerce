package org.broadleafcommerce.core.web.controller.account;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
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
import org.broadleafcommerce.core.order.domain.BundleOrderItemImpl;
import org.broadleafcommerce.core.order.domain.GiftWrapOrderItemImpl;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.Order;
import org.broadleafcommerce.core.order.domain.OrderImpl;
import org.broadleafcommerce.core.order.domain.OrderItem;
import org.broadleafcommerce.core.order.domain.OrderItemImpl;
import org.broadleafcommerce.core.order.domain.PersonalMessageImpl;
import org.broadleafcommerce.core.order.service.type.OrderItemType;
import org.broadleafcommerce.core.order.service.type.OrderStatus;
import org.broadleafcommerce.profile.core.domain.CustomerImpl;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class BroadleafManageWishlistControllerDiffblueTest {
  /**
   * Test {@link BroadleafManageWishlistController#isWishlistValid(Order)}.
   *
   * <ul>
   *   <li>Given {@link Auditable} (default constructor) CreatedBy is one.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafManageWishlistController#isWishlistValid(Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BroadleafManageWishlistController.isWishlistValid(Order)"})
  public void testIsWishlistValid_givenAuditableCreatedByIsOne_thenReturnTrue() {
    // Arrange
    BroadleafManageWishlistController broadleafManageWishlistController =
        new BroadleafManageWishlistController();

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    OrderImpl wishlist = new OrderImpl();
    wishlist.setAdditionalOfferInformation(new HashMap<>());
    wishlist.setAuditable(auditable);
    wishlist.setCandidateOrderOffers(new ArrayList<>());
    wishlist.setCurrency(new BroadleafCurrencyImpl());
    wishlist.setCustomer(new CustomerImpl());
    wishlist.setEmailAddress("42 Main St");
    wishlist.setFulfillmentGroups(new ArrayList<>());
    wishlist.setId(1L);
    wishlist.setLocale(new LocaleImpl());
    wishlist.setName("Name");
    wishlist.setOrderAttributes(new HashMap<>());
    wishlist.setOrderItems(new ArrayList<>());
    wishlist.setOrderMessages(new ArrayList<>());
    wishlist.setOrderNumber("42");
    wishlist.setPayments(new ArrayList<>());
    wishlist.setStatus(new OrderStatus());
    wishlist.setSubTotal(new Money());
    wishlist.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    wishlist.setTaxOverride(true);
    wishlist.setTotal(new Money());
    wishlist.setTotalFulfillmentCharges(new Money());
    wishlist.setTotalTax(new Money());

    // Act and Assert
    assertTrue(broadleafManageWishlistController.isWishlistValid(wishlist));
  }

  /**
   * Test {@link BroadleafManageWishlistController#isWishlistValid(Order)}.
   *
   * <ul>
   *   <li>Given {@link OrderItemImpl} (default constructor) Auditable is {@link Auditable} (default
   *       constructor).
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafManageWishlistController#isWishlistValid(Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BroadleafManageWishlistController.isWishlistValid(Order)"})
  public void testIsWishlistValid_givenOrderItemImplAuditableIsAuditable_thenReturnFalse() {
    // Arrange
    BroadleafManageWishlistController broadleafManageWishlistController =
        new BroadleafManageWishlistController();

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(1L);
    auditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(1L);

    OrderItemImpl orderItemImpl = new OrderItemImpl();
    orderItemImpl.setAuditable(auditable2);
    orderItemImpl.setCandidateItemOffers(new ArrayList<>());
    orderItemImpl.setCartMessages(new ArrayList<>());
    orderItemImpl.setChildOrderItems(new ArrayList<>());
    orderItemImpl.setDiscountingAllowed(true);
    orderItemImpl.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    orderItemImpl.setHasValidationError(true);
    orderItemImpl.setId(1L);
    orderItemImpl.setName("Name");
    orderItemImpl.setOrder(new NullOrderImpl());
    orderItemImpl.setOrderItemAdjustments(new ArrayList<>());
    orderItemImpl.setOrderItemAttributes(new HashMap<>());
    orderItemImpl.setOrderItemPriceDetails(new ArrayList<>());
    orderItemImpl.setOrderItemQualifiers(new ArrayList<>());
    orderItemImpl.setOrderItemType(new OrderItemType());
    orderItemImpl.setParentOrderItem(new BundleOrderItemImpl());
    orderItemImpl.setPersonalMessage(new PersonalMessageImpl());
    orderItemImpl.setPrice(new Money());
    orderItemImpl.setProratedOrderItemAdjustments(new ArrayList<>());
    orderItemImpl.setQuantity(1);
    orderItemImpl.setRetailPrice(new Money());
    orderItemImpl.setRetailPriceOverride(true);
    orderItemImpl.setSalePrice(new Money());
    orderItemImpl.setSalePriceOverride(true);
    orderItemImpl.setTaxable(true);
    orderItemImpl.updateSaleAndRetailPrices();

    ArrayList<OrderItem> orderItems = new ArrayList<>();
    orderItems.add(orderItemImpl);

    OrderImpl wishlist = new OrderImpl();
    wishlist.setAdditionalOfferInformation(new HashMap<>());
    wishlist.setAuditable(auditable);
    wishlist.setCandidateOrderOffers(new ArrayList<>());
    wishlist.setCurrency(new BroadleafCurrencyImpl());
    wishlist.setCustomer(new CustomerImpl());
    wishlist.setEmailAddress("42 Main St");
    wishlist.setFulfillmentGroups(new ArrayList<>());
    wishlist.setId(1L);
    wishlist.setLocale(new LocaleImpl());
    wishlist.setName("Name");
    wishlist.setOrderAttributes(new HashMap<>());
    wishlist.setOrderMessages(new ArrayList<>());
    wishlist.setOrderNumber("42");
    wishlist.setPayments(new ArrayList<>());
    wishlist.setStatus(new OrderStatus());
    wishlist.setSubTotal(new Money());
    wishlist.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    wishlist.setTaxOverride(true);
    wishlist.setTotal(new Money());
    wishlist.setTotalFulfillmentCharges(new Money());
    wishlist.setTotalTax(new Money());
    wishlist.setOrderItems(orderItems);

    // Act and Assert
    assertFalse(broadleafManageWishlistController.isWishlistValid(wishlist));
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link BroadleafManageWishlistController}
   *   <li>{@link BroadleafManageWishlistController#getAccountWishlistRedirect()}
   *   <li>{@link BroadleafManageWishlistController#getAccountWishlistView()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BroadleafManageWishlistController.<init>()",
    "String BroadleafManageWishlistController.getAccountWishlistRedirect()",
    "String BroadleafManageWishlistController.getAccountWishlistView()"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    BroadleafManageWishlistController actualBroadleafManageWishlistController =
        new BroadleafManageWishlistController();
    String actualAccountWishlistRedirect =
        actualBroadleafManageWishlistController.getAccountWishlistRedirect();

    // Assert
    assertEquals(
        "account/manageWishlist", actualBroadleafManageWishlistController.getAccountWishlistView());
    assertEquals("redirect:/account/wishlist", actualAccountWishlistRedirect);
  }
}
