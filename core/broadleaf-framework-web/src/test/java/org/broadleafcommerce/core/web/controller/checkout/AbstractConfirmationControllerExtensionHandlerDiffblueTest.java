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
package org.broadleafcommerce.core.web.controller.checkout;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.HashMap;
import org.broadleafcommerce.common.audit.Auditable;
import org.broadleafcommerce.common.currency.domain.BroadleafCurrencyImpl;
import org.broadleafcommerce.common.extension.ExtensionResultStatusType;
import org.broadleafcommerce.common.locale.domain.LocaleImpl;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.Order;
import org.broadleafcommerce.core.order.domain.OrderImpl;
import org.broadleafcommerce.core.order.service.type.OrderStatus;
import org.broadleafcommerce.profile.core.domain.CustomerImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AbstractConfirmationControllerExtensionHandlerDiffblueTest {
  /**
   * Test
   * {@link AbstractConfirmationControllerExtensionHandler#processAdditionalConfirmationActions(Order)}.
   * <ul>
   *   <li>Given {@link Auditable} (default constructor) CreatedBy is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractConfirmationControllerExtensionHandler#processAdditionalConfirmationActions(Order)}
   */
  @Test
  @DisplayName("Test processAdditionalConfirmationActions(Order); given Auditable (default constructor) CreatedBy is one")
  void testProcessAdditionalConfirmationActions_givenAuditableCreatedByIsOne() {
    // Arrange
    AbstractConfirmationControllerExtensionHandler abstractConfirmationControllerExtensionHandler = new AbstractConfirmationControllerExtensionHandler();

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
    order.setStatus(new OrderStatus("Type", "Friendly Type"));
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
        abstractConfirmationControllerExtensionHandler.processAdditionalConfirmationActions(order));
  }

  /**
   * Test
   * {@link AbstractConfirmationControllerExtensionHandler#processAdditionalConfirmationActions(Order)}.
   * <ul>
   *   <li>When {@link NullOrderImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractConfirmationControllerExtensionHandler#processAdditionalConfirmationActions(Order)}
   */
  @Test
  @DisplayName("Test processAdditionalConfirmationActions(Order); when NullOrderImpl (default constructor)")
  void testProcessAdditionalConfirmationActions_whenNullOrderImpl() {
    // Arrange
    AbstractConfirmationControllerExtensionHandler abstractConfirmationControllerExtensionHandler = new AbstractConfirmationControllerExtensionHandler();

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        abstractConfirmationControllerExtensionHandler.processAdditionalConfirmationActions(new NullOrderImpl()));
  }

  /**
   * Test new {@link AbstractConfirmationControllerExtensionHandler} (default
   * constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link AbstractConfirmationControllerExtensionHandler}
   */
  @Test
  @DisplayName("Test new AbstractConfirmationControllerExtensionHandler (default constructor)")
  void testNewAbstractConfirmationControllerExtensionHandler() {
    // Arrange and Act
    AbstractConfirmationControllerExtensionHandler actualAbstractConfirmationControllerExtensionHandler = new AbstractConfirmationControllerExtensionHandler();

    // Assert
    assertEquals(0, actualAbstractConfirmationControllerExtensionHandler.getPriority());
    assertTrue(actualAbstractConfirmationControllerExtensionHandler.isEnabled());
  }
}
