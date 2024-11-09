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
package org.broadleafcommerce.core.web.processor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import org.broadleafcommerce.common.audit.Auditable;
import org.broadleafcommerce.common.currency.domain.BroadleafCurrencyImpl;
import org.broadleafcommerce.common.locale.domain.LocaleImpl;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.core.catalog.domain.CategoryImpl;
import org.broadleafcommerce.core.order.domain.BundleOrderItemImpl;
import org.broadleafcommerce.core.order.domain.FulfillmentGroup;
import org.broadleafcommerce.core.order.domain.FulfillmentGroupImpl;
import org.broadleafcommerce.core.order.domain.FulfillmentGroupItemImpl;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.Order;
import org.broadleafcommerce.core.order.domain.OrderImpl;
import org.broadleafcommerce.core.order.domain.OrderItem;
import org.broadleafcommerce.core.order.domain.OrderItemAttribute;
import org.broadleafcommerce.core.order.domain.OrderItemAttributeImpl;
import org.broadleafcommerce.core.order.service.type.OrderStatus;
import org.broadleafcommerce.profile.core.domain.CustomerImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GoogleUniversalAnalyticsProcessorDiffblueTest {
  /**
   * Test {@link GoogleUniversalAnalyticsProcessor#shouldShowMasterTracker()}.
   * <p>
   * Method under test:
   * {@link GoogleUniversalAnalyticsProcessor#shouldShowMasterTracker()}
   */
  @Test
  @DisplayName("Test shouldShowMasterTracker()")
  void testShouldShowMasterTracker() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    GoogleUniversalAnalyticsProcessor googleUniversalAnalyticsProcessor = new GoogleUniversalAnalyticsProcessor();
    googleUniversalAnalyticsProcessor.setMasterWebPropertyId("UA-XXXXXXX-X");

    // Act and Assert
    assertFalse(googleUniversalAnalyticsProcessor.shouldShowMasterTracker());
  }

  /**
   * Test {@link GoogleUniversalAnalyticsProcessor#shouldShowMasterTracker()}.
   * <ul>
   *   <li>Given {@link GoogleUniversalAnalyticsProcessor} (default
   * constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link GoogleUniversalAnalyticsProcessor#shouldShowMasterTracker()}
   */
  @Test
  @DisplayName("Test shouldShowMasterTracker(); given GoogleUniversalAnalyticsProcessor (default constructor)")
  void testShouldShowMasterTracker_givenGoogleUniversalAnalyticsProcessor() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new GoogleUniversalAnalyticsProcessor()).shouldShowMasterTracker());
  }

  /**
   * Test {@link GoogleUniversalAnalyticsProcessor#shouldShowMasterTracker()}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link GoogleUniversalAnalyticsProcessor#shouldShowMasterTracker()}
   */
  @Test
  @DisplayName("Test shouldShowMasterTracker(); then return 'true'")
  void testShouldShowMasterTracker_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    GoogleUniversalAnalyticsProcessor googleUniversalAnalyticsProcessor = new GoogleUniversalAnalyticsProcessor();
    googleUniversalAnalyticsProcessor.setMasterWebPropertyId("foo");

    // Act and Assert
    assertTrue(googleUniversalAnalyticsProcessor.shouldShowMasterTracker());
  }

  /**
   * Test {@link GoogleUniversalAnalyticsProcessor#getLinkAttributionJs(String)}.
   * <p>
   * Method under test:
   * {@link GoogleUniversalAnalyticsProcessor#getLinkAttributionJs(String)}
   */
  @Test
  @DisplayName("Test getLinkAttributionJs(String)")
  void testGetLinkAttributionJs() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("ga('Tracker Prefixrequire', 'linkid', 'linkid.js');",
        (new GoogleUniversalAnalyticsProcessor()).getLinkAttributionJs("Tracker Prefix"));
  }

  /**
   * Test
   * {@link GoogleUniversalAnalyticsProcessor#getDisplayAdvertisingJs(String)}.
   * <p>
   * Method under test:
   * {@link GoogleUniversalAnalyticsProcessor#getDisplayAdvertisingJs(String)}
   */
  @Test
  @DisplayName("Test getDisplayAdvertisingJs(String)")
  void testGetDisplayAdvertisingJs() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("ga('Tracker Prefixrequire', 'displayfeatures');",
        (new GoogleUniversalAnalyticsProcessor()).getDisplayAdvertisingJs("Tracker Prefix"));
  }

  /**
   * Test {@link GoogleUniversalAnalyticsProcessor#getItemJs(Order, String)}.
   * <p>
   * Method under test:
   * {@link GoogleUniversalAnalyticsProcessor#getItemJs(Order, String)}
   */
  @Test
  @DisplayName("Test getItemJs(Order, String)")
  void testGetItemJs() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    GoogleUniversalAnalyticsProcessor googleUniversalAnalyticsProcessor = new GoogleUniversalAnalyticsProcessor();

    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();
    fulfillmentGroupImpl.addFulfillmentGroupItem(new FulfillmentGroupItemImpl());

    ArrayList<FulfillmentGroup> fulfillmentGroupList = new ArrayList<>();
    fulfillmentGroupList.add(fulfillmentGroupImpl);
    NullOrderImpl order = mock(NullOrderImpl.class);
    when(order.getFulfillmentGroups()).thenReturn(fulfillmentGroupList);

    // Act
    String actualItemJs = googleUniversalAnalyticsProcessor.getItemJs(order, "Tracker Prefix");

    // Assert
    verify(order).getFulfillmentGroups();
    assertEquals("", actualItemJs);
  }

  /**
   * Test {@link GoogleUniversalAnalyticsProcessor#getItemJs(Order, String)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.</li>
   *   <li>Then calls {@link NullOrderImpl#getFulfillmentGroups()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link GoogleUniversalAnalyticsProcessor#getItemJs(Order, String)}
   */
  @Test
  @DisplayName("Test getItemJs(Order, String); given ArrayList(); then calls getFulfillmentGroups()")
  void testGetItemJs_givenArrayList_thenCallsGetFulfillmentGroups() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    GoogleUniversalAnalyticsProcessor googleUniversalAnalyticsProcessor = new GoogleUniversalAnalyticsProcessor();
    NullOrderImpl order = mock(NullOrderImpl.class);
    when(order.getFulfillmentGroups()).thenReturn(new ArrayList<>());

    // Act
    String actualItemJs = googleUniversalAnalyticsProcessor.getItemJs(order, "Tracker Prefix");

    // Assert
    verify(order).getFulfillmentGroups();
    assertEquals("", actualItemJs);
  }

  /**
   * Test {@link GoogleUniversalAnalyticsProcessor#getItemJs(Order, String)}.
   * <ul>
   *   <li>Given {@link Auditable} (default constructor) CreatedBy is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link GoogleUniversalAnalyticsProcessor#getItemJs(Order, String)}
   */
  @Test
  @DisplayName("Test getItemJs(Order, String); given Auditable (default constructor) CreatedBy is one")
  void testGetItemJs_givenAuditableCreatedByIsOne() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    GoogleUniversalAnalyticsProcessor googleUniversalAnalyticsProcessor = new GoogleUniversalAnalyticsProcessor();

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    order.setSubmitDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalShipping(new Money());
    order.setTotalTax(new Money());

    // Act and Assert
    assertEquals("", googleUniversalAnalyticsProcessor.getItemJs(order, "Tracker Prefix"));
  }

  /**
   * Test {@link GoogleUniversalAnalyticsProcessor#getItemJs(Order, String)}.
   * <ul>
   *   <li>Then calls {@link NullOrderImpl#getFulfillmentGroups()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link GoogleUniversalAnalyticsProcessor#getItemJs(Order, String)}
   */
  @Test
  @DisplayName("Test getItemJs(Order, String); then calls getFulfillmentGroups()")
  void testGetItemJs_thenCallsGetFulfillmentGroups() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    GoogleUniversalAnalyticsProcessor googleUniversalAnalyticsProcessor = new GoogleUniversalAnalyticsProcessor();

    ArrayList<FulfillmentGroup> fulfillmentGroupList = new ArrayList<>();
    fulfillmentGroupList.add(new FulfillmentGroupImpl());
    NullOrderImpl order = mock(NullOrderImpl.class);
    when(order.getFulfillmentGroups()).thenReturn(fulfillmentGroupList);

    // Act
    String actualItemJs = googleUniversalAnalyticsProcessor.getItemJs(order, "Tracker Prefix");

    // Assert
    verify(order).getFulfillmentGroups();
    assertEquals("", actualItemJs);
  }

  /**
   * Test {@link GoogleUniversalAnalyticsProcessor#getVariation(OrderItem)}.
   * <ul>
   *   <li>Given {@link CategoryImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link GoogleUniversalAnalyticsProcessor#getVariation(OrderItem)}
   */
  @Test
  @DisplayName("Test getVariation(OrderItem); given CategoryImpl (default constructor)")
  void testGetVariation_givenCategoryImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    GoogleUniversalAnalyticsProcessor googleUniversalAnalyticsProcessor = new GoogleUniversalAnalyticsProcessor();
    BundleOrderItemImpl item = mock(BundleOrderItemImpl.class);
    when(item.getOrderItemAttributes()).thenReturn(new HashMap<>());
    when(item.getCategory()).thenReturn(new CategoryImpl());

    // Act
    String actualVariation = googleUniversalAnalyticsProcessor.getVariation(item);

    // Assert
    verify(item, atLeast(1)).getCategory();
    verify(item).getOrderItemAttributes();
    assertNull(actualVariation);
  }

  /**
   * Test {@link GoogleUniversalAnalyticsProcessor#getVariation(OrderItem)}.
   * <ul>
   *   <li>Given {@link CategoryImpl} {@link CategoryImpl#getName()} return
   * {@code Name}.</li>
   *   <li>Then return {@code Name}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link GoogleUniversalAnalyticsProcessor#getVariation(OrderItem)}
   */
  @Test
  @DisplayName("Test getVariation(OrderItem); given CategoryImpl getName() return 'Name'; then return 'Name'")
  void testGetVariation_givenCategoryImplGetNameReturnName_thenReturnName() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    GoogleUniversalAnalyticsProcessor googleUniversalAnalyticsProcessor = new GoogleUniversalAnalyticsProcessor();
    CategoryImpl categoryImpl = mock(CategoryImpl.class);
    when(categoryImpl.getName()).thenReturn("Name");
    BundleOrderItemImpl item = mock(BundleOrderItemImpl.class);
    when(item.getOrderItemAttributes()).thenReturn(new HashMap<>());
    when(item.getCategory()).thenReturn(categoryImpl);

    // Act
    String actualVariation = googleUniversalAnalyticsProcessor.getVariation(item);

    // Assert
    verify(categoryImpl).getName();
    verify(item, atLeast(1)).getCategory();
    verify(item).getOrderItemAttributes();
    assertEquals("Name", actualVariation);
  }

  /**
   * Test {@link GoogleUniversalAnalyticsProcessor#getVariation(OrderItem)}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@code name} is
   * {@link OrderItemAttributeImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link GoogleUniversalAnalyticsProcessor#getVariation(OrderItem)}
   */
  @Test
  @DisplayName("Test getVariation(OrderItem); given HashMap() 'name' is OrderItemAttributeImpl (default constructor); then return 'null'")
  void testGetVariation_givenHashMapNameIsOrderItemAttributeImpl_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    GoogleUniversalAnalyticsProcessor googleUniversalAnalyticsProcessor = new GoogleUniversalAnalyticsProcessor();

    HashMap<String, OrderItemAttribute> stringOrderItemAttributeMap = new HashMap<>();
    stringOrderItemAttributeMap.put("name", new OrderItemAttributeImpl());
    BundleOrderItemImpl item = mock(BundleOrderItemImpl.class);
    when(item.getOrderItemAttributes()).thenReturn(stringOrderItemAttributeMap);

    // Act
    String actualVariation = googleUniversalAnalyticsProcessor.getVariation(item);

    // Assert
    verify(item, atLeast(1)).getOrderItemAttributes();
    assertEquals("null", actualVariation);
  }

  /**
   * Test {@link GoogleUniversalAnalyticsProcessor#getVariation(OrderItem)}.
   * <ul>
   *   <li>When {@link BundleOrderItemImpl} (default constructor).</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link GoogleUniversalAnalyticsProcessor#getVariation(OrderItem)}
   */
  @Test
  @DisplayName("Test getVariation(OrderItem); when BundleOrderItemImpl (default constructor); then return empty string")
  void testGetVariation_whenBundleOrderItemImpl_thenReturnEmptyString() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    GoogleUniversalAnalyticsProcessor googleUniversalAnalyticsProcessor = new GoogleUniversalAnalyticsProcessor();

    // Act and Assert
    assertEquals("", googleUniversalAnalyticsProcessor.getVariation(new BundleOrderItemImpl()));
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link GoogleUniversalAnalyticsProcessor#setMasterWebPropertyId(String)}
   *   <li>{@link GoogleUniversalAnalyticsProcessor#getMasterWebPropertyId()}
   *   <li>{@link GoogleUniversalAnalyticsProcessor#getName()}
   *   <li>{@link GoogleUniversalAnalyticsProcessor#getPrecedence()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange
    GoogleUniversalAnalyticsProcessor googleUniversalAnalyticsProcessor = new GoogleUniversalAnalyticsProcessor();

    // Act
    googleUniversalAnalyticsProcessor.setMasterWebPropertyId("42");
    String actualMasterWebPropertyId = googleUniversalAnalyticsProcessor.getMasterWebPropertyId();
    String actualName = googleUniversalAnalyticsProcessor.getName();

    // Assert that nothing has changed
    assertEquals("42", actualMasterWebPropertyId);
    assertEquals("google_universal_analytics", actualName);
    assertEquals(0, googleUniversalAnalyticsProcessor.getPrecedence());
  }
}
