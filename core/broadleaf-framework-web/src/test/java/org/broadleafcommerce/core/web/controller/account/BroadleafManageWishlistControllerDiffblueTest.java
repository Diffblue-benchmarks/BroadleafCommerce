/*-
 * #%L
 * BroadleafCommerce Framework Web
 * %%
 * Copyright (C) 2009 - 2024 Broadleaf Commerce
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
package org.broadleafcommerce.core.web.controller.account;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import org.broadleafcommerce.common.audit.Auditable;
import org.broadleafcommerce.common.currency.domain.BroadleafCurrencyImpl;
import org.broadleafcommerce.common.locale.domain.LocaleImpl;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.core.order.domain.Order;
import org.broadleafcommerce.core.order.domain.OrderImpl;
import org.broadleafcommerce.core.order.service.type.OrderStatus;
import org.broadleafcommerce.profile.core.domain.CustomerImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BroadleafManageWishlistControllerDiffblueTest {
  /**
   * Test {@link BroadleafManageWishlistController#isWishlistValid(Order)}.
   * <ul>
   *   <li>Given {@link Auditable} (default constructor) DateCreated is
   * {@link java.sql.Date}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BroadleafManageWishlistController#isWishlistValid(Order)}
   */
  @Test
  @DisplayName("Test isWishlistValid(Order); given Auditable (default constructor) DateCreated is Date; then return 'true'")
  void testIsWishlistValid_givenAuditableDateCreatedIsDate_thenReturnTrue() {
    // Arrange
    BroadleafManageWishlistController broadleafManageWishlistController = new BroadleafManageWishlistController();

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(mock(java.sql.Date.class));
    auditable.setDateUpdated(
        java.util.Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    wishlist.setStatus(new OrderStatus("Type", "Friendly Type"));
    wishlist.setSubTotal(new Money());
    wishlist
        .setSubmitDate(java.util.Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    wishlist.setTaxOverride(true);
    wishlist.setTotal(new Money());
    wishlist.setTotalFulfillmentCharges(new Money());
    wishlist.setTotalShipping(new Money());
    wishlist.setTotalTax(new Money());

    // Act and Assert
    assertTrue(broadleafManageWishlistController.isWishlistValid(wishlist));
  }

  /**
   * Test {@link BroadleafManageWishlistController#isWishlistValid(Order)}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BroadleafManageWishlistController#isWishlistValid(Order)}
   */
  @Test
  @DisplayName("Test isWishlistValid(Order); then return 'true'")
  void testIsWishlistValid_thenReturnTrue() {
    // Arrange
    BroadleafManageWishlistController broadleafManageWishlistController = new BroadleafManageWishlistController();

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    wishlist.setStatus(new OrderStatus("Type", "Friendly Type"));
    wishlist.setSubTotal(new Money());
    wishlist.setSubmitDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    wishlist.setTaxOverride(true);
    wishlist.setTotal(new Money());
    wishlist.setTotalFulfillmentCharges(new Money());
    wishlist.setTotalShipping(new Money());
    wishlist.setTotalTax(new Money());

    // Act and Assert
    assertTrue(broadleafManageWishlistController.isWishlistValid(wishlist));
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link BroadleafManageWishlistController}
   *   <li>{@link BroadleafManageWishlistController#getAccountWishlistRedirect()}
   *   <li>{@link BroadleafManageWishlistController#getAccountWishlistView()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange and Act
    BroadleafManageWishlistController actualBroadleafManageWishlistController = new BroadleafManageWishlistController();
    String actualAccountWishlistRedirect = actualBroadleafManageWishlistController.getAccountWishlistRedirect();

    // Assert
    assertEquals("account/manageWishlist", actualBroadleafManageWishlistController.getAccountWishlistView());
    assertEquals("redirect:/account/wishlist", actualAccountWishlistRedirect);
  }
}
