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
package org.broadleafcommerce.core.web.controller.catalog;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import org.broadleafcommerce.common.audit.Auditable;
import org.broadleafcommerce.common.currency.domain.BroadleafCurrencyImpl;
import org.broadleafcommerce.common.locale.domain.LocaleImpl;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.common.template.TemplateType;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.OrderImpl;
import org.broadleafcommerce.core.order.domain.OrderItem;
import org.broadleafcommerce.core.order.service.type.OrderStatus;
import org.broadleafcommerce.core.web.controller.catalog.BroadleafProductController.ResourceNotFoundException;
import org.broadleafcommerce.core.web.search.SearchRequestWrapper;
import org.broadleafcommerce.core.web.security.XssRequestWrapper;
import org.broadleafcommerce.profile.core.domain.CustomerImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.web.reactive.context.StandardReactiveWebEnvironment;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.multipart.support.DefaultMultipartHttpServletRequest;

class BroadleafProductControllerDiffblueTest {
  /**
   * Test
   * {@link BroadleafProductController#orderItemBelongsToCurrentCustomer(OrderItem)}.
   * <ul>
   *   <li>Given {@link Auditable} (default constructor) CreatedBy is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BroadleafProductController#orderItemBelongsToCurrentCustomer(OrderItem)}
   */
  @Test
  @DisplayName("Test orderItemBelongsToCurrentCustomer(OrderItem); given Auditable (default constructor) CreatedBy is one")
  void testOrderItemBelongsToCurrentCustomer_givenAuditableCreatedByIsOne() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafProductController broadleafProductController = new BroadleafProductController();

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
    orderImpl.setName("ThreadLocalManager.notify.orphans");
    orderImpl.setOrderAttributes(new HashMap<>());
    orderImpl.setOrderItems(new ArrayList<>());
    orderImpl.setOrderMessages(new ArrayList<>());
    orderImpl.setOrderNumber("42");
    orderImpl.setPayments(new ArrayList<>());
    orderImpl.setStatus(new OrderStatus("ThreadLocalManager.notify.orphans", "ThreadLocalManager.notify.orphans"));
    orderImpl.setSubTotal(new Money());
    orderImpl.setSubmitDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    orderImpl.setTaxOverride(true);
    orderImpl.setTotal(new Money());
    orderImpl.setTotalFulfillmentCharges(new Money());
    orderImpl.setTotalShipping(new Money());
    orderImpl.setTotalTax(new Money());
    OrderItem orderItem = mock(OrderItem.class);
    when(orderItem.getOrder()).thenReturn(orderImpl);

    // Act
    boolean actualOrderItemBelongsToCurrentCustomerResult = broadleafProductController
        .orderItemBelongsToCurrentCustomer(orderItem);

    // Assert
    verify(orderItem).getOrder();
    assertFalse(actualOrderItemBelongsToCurrentCustomerResult);
  }

  /**
   * Test
   * {@link BroadleafProductController#orderItemBelongsToCurrentCustomer(OrderItem)}.
   * <ul>
   *   <li>Given {@link NullOrderImpl} (default constructor).</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BroadleafProductController#orderItemBelongsToCurrentCustomer(OrderItem)}
   */
  @Test
  @DisplayName("Test orderItemBelongsToCurrentCustomer(OrderItem); given NullOrderImpl (default constructor); then return 'true'")
  void testOrderItemBelongsToCurrentCustomer_givenNullOrderImpl_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafProductController broadleafProductController = new BroadleafProductController();
    OrderItem orderItem = mock(OrderItem.class);
    when(orderItem.getOrder()).thenReturn(new NullOrderImpl());

    // Act
    boolean actualOrderItemBelongsToCurrentCustomerResult = broadleafProductController
        .orderItemBelongsToCurrentCustomer(orderItem);

    // Assert
    verify(orderItem).getOrder();
    assertTrue(actualOrderItemBelongsToCurrentCustomerResult);
  }

  /**
   * Test
   * {@link BroadleafProductController#orderItemBelongsToCurrentCustomer(OrderItem)}.
   * <ul>
   *   <li>Then throw {@link ResourceNotFoundException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BroadleafProductController#orderItemBelongsToCurrentCustomer(OrderItem)}
   */
  @Test
  @DisplayName("Test orderItemBelongsToCurrentCustomer(OrderItem); then throw ResourceNotFoundException")
  void testOrderItemBelongsToCurrentCustomer_thenThrowResourceNotFoundException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafProductController broadleafProductController = new BroadleafProductController();
    OrderItem orderItem = mock(OrderItem.class);
    when(orderItem.getOrder()).thenThrow((new BroadleafProductController()).new ResourceNotFoundException());

    // Act and Assert
    assertThrows(BroadleafProductController.ResourceNotFoundException.class,
        () -> broadleafProductController.orderItemBelongsToCurrentCustomer(orderItem));
    verify(orderItem).getOrder();
  }

  /**
   * Test
   * {@link BroadleafProductController#orderItemBelongsToCurrentCustomer(OrderItem)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BroadleafProductController#orderItemBelongsToCurrentCustomer(OrderItem)}
   */
  @Test
  @DisplayName("Test orderItemBelongsToCurrentCustomer(OrderItem); when 'null'; then return 'false'")
  void testOrderItemBelongsToCurrentCustomer_whenNull_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new BroadleafProductController()).orderItemBelongsToCurrentCustomer(null));
  }

  /**
   * Test {@link BroadleafProductController#getTemplateType(HttpServletRequest)}.
   * <p>
   * Method under test:
   * {@link BroadleafProductController#getTemplateType(HttpServletRequest)}
   */
  @Test
  @DisplayName("Test getTemplateType(HttpServletRequest)")
  void testGetTemplateType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafProductController broadleafProductController = new BroadleafProductController();
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();

    // Act
    TemplateType actualTemplateType = broadleafProductController
        .getTemplateType(new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
            new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"})));

    // Assert
    assertSame(actualTemplateType.PRODUCT, actualTemplateType);
  }

  /**
   * Test {@link BroadleafProductController#getTemplateType(HttpServletRequest)}.
   * <p>
   * Method under test:
   * {@link BroadleafProductController#getTemplateType(HttpServletRequest)}
   */
  @Test
  @DisplayName("Test getTemplateType(HttpServletRequest)")
  void testGetTemplateType2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafProductController broadleafProductController = new BroadleafProductController();
    DefaultMultipartHttpServletRequest servletRequest = mock(DefaultMultipartHttpServletRequest.class);

    // Act
    TemplateType actualTemplateType = broadleafProductController
        .getTemplateType(new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
            new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"})));

    // Assert
    assertSame(actualTemplateType.PRODUCT, actualTemplateType);
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link BroadleafProductController}
   *   <li>{@link BroadleafProductController#setDefaultProductView(String)}
   *   <li>{@link BroadleafProductController#getDefaultProductView()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange and Act
    BroadleafProductController actualBroadleafProductController = new BroadleafProductController();
    actualBroadleafProductController.setDefaultProductView("Default Product View");

    // Assert that nothing has changed
    assertEquals("Default Product View", actualBroadleafProductController.getDefaultProductView());
  }

  /**
   * Test ResourceNotFoundException
   * {@link ResourceNotFoundException#ResourceNotFoundException(BroadleafProductController)}.
   * <p>
   * Method under test:
   * {@link BroadleafProductController.ResourceNotFoundException#ResourceNotFoundException(BroadleafProductController)}
   */
  @Test
  @DisplayName("Test ResourceNotFoundException new ResourceNotFoundException(BroadleafProductController)")
  void testResourceNotFoundExceptionNewResourceNotFoundException() {
    // Arrange and Act
    BroadleafProductController.ResourceNotFoundException actualResourceNotFoundException = (new BroadleafProductController()).new ResourceNotFoundException();

    // Assert
    assertNull(actualResourceNotFoundException.getMessage());
    assertNull(actualResourceNotFoundException.getCause());
    assertEquals(0, actualResourceNotFoundException.getSuppressed().length);
  }
}
