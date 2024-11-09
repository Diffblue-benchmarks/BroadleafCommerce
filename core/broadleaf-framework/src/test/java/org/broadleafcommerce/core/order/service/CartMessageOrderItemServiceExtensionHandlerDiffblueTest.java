/*-
 * #%L
 * BroadleafCommerce Framework
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
package org.broadleafcommerce.core.order.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import org.broadleafcommerce.common.audit.Auditable;
import org.broadleafcommerce.common.currency.domain.BroadleafCurrencyImpl;
import org.broadleafcommerce.common.extension.ExtensionResultStatusType;
import org.broadleafcommerce.common.locale.domain.LocaleImpl;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.core.catalog.domain.CategoryMediaXrefImpl;
import org.broadleafcommerce.core.order.domain.BundleOrderItemImpl;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.Order;
import org.broadleafcommerce.core.order.domain.OrderImpl;
import org.broadleafcommerce.core.order.domain.OrderItem;
import org.broadleafcommerce.core.order.service.type.OrderStatus;
import org.broadleafcommerce.core.promotionMessage.domain.PromotionMessageImpl;
import org.broadleafcommerce.core.promotionMessage.dto.PromotionMessageDTO;
import org.broadleafcommerce.profile.core.domain.CustomerImpl;
import org.junit.Test;

public class CartMessageOrderItemServiceExtensionHandlerDiffblueTest {
  /**
   * Test
   * {@link CartMessageOrderItemServiceExtensionHandler#attachAdditionalDataToOrder(Order, boolean)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.</li>
   *   <li>Then calls {@link NullOrderImpl#getOrderItems()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CartMessageOrderItemServiceExtensionHandler#attachAdditionalDataToOrder(Order, boolean)}
   */
  @Test
  public void testAttachAdditionalDataToOrder_givenArrayList_thenCallsGetOrderItems() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CartMessageOrderItemServiceExtensionHandler cartMessageOrderItemServiceExtensionHandler = new CartMessageOrderItemServiceExtensionHandler();
    NullOrderImpl order = mock(NullOrderImpl.class);
    when(order.getOrderItems()).thenReturn(new ArrayList<>());

    // Act
    ExtensionResultStatusType actualAttachAdditionalDataToOrderResult = cartMessageOrderItemServiceExtensionHandler
        .attachAdditionalDataToOrder(order, true);

    // Assert
    verify(order).getOrderItems();
    assertEquals(ExtensionResultStatusType.HANDLED_CONTINUE, actualAttachAdditionalDataToOrderResult);
  }

  /**
   * Test
   * {@link CartMessageOrderItemServiceExtensionHandler#attachAdditionalDataToOrder(Order, boolean)}.
   * <ul>
   *   <li>Given {@link Auditable} (default constructor) CreatedBy is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CartMessageOrderItemServiceExtensionHandler#attachAdditionalDataToOrder(Order, boolean)}
   */
  @Test
  public void testAttachAdditionalDataToOrder_givenAuditableCreatedByIsOne() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CartMessageOrderItemServiceExtensionHandler cartMessageOrderItemServiceExtensionHandler = new CartMessageOrderItemServiceExtensionHandler();

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
    order.setStatus(OrderStatus.ARCHIVED);
    order.setSubTotal(new Money());
    order.setSubmitDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalShipping(new Money());
    order.setTotalTax(new Money());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.HANDLED_CONTINUE,
        cartMessageOrderItemServiceExtensionHandler.attachAdditionalDataToOrder(order, true));
  }

  /**
   * Test
   * {@link CartMessageOrderItemServiceExtensionHandler#gatherProductCartMessages(OrderItem)}.
   * <ul>
   *   <li>When {@link BundleOrderItemImpl} (default constructor).</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CartMessageOrderItemServiceExtensionHandler#gatherProductCartMessages(OrderItem)}
   */
  @Test
  public void testGatherProductCartMessages_whenBundleOrderItemImpl_thenReturnEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CartMessageOrderItemServiceExtensionHandler cartMessageOrderItemServiceExtensionHandler = new CartMessageOrderItemServiceExtensionHandler();

    // Act and Assert
    assertTrue(
        cartMessageOrderItemServiceExtensionHandler.gatherProductCartMessages(new BundleOrderItemImpl()).isEmpty());
  }

  /**
   * Test
   * {@link CartMessageOrderItemServiceExtensionHandler#gatherProductCartMessages(OrderItem)}.
   * <ul>
   *   <li>When {@link BundleOrderItemImpl}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CartMessageOrderItemServiceExtensionHandler#gatherProductCartMessages(OrderItem)}
   */
  @Test
  public void testGatherProductCartMessages_whenBundleOrderItemImpl_thenReturnEmpty2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue(
        (new CartMessageOrderItemServiceExtensionHandler()).gatherProductCartMessages(mock(BundleOrderItemImpl.class))
            .isEmpty());
  }

  /**
   * Test
   * {@link CartMessageOrderItemServiceExtensionHandler#addPromotionMessagesForType(List, List)}.
   * <p>
   * Method under test:
   * {@link CartMessageOrderItemServiceExtensionHandler#addPromotionMessagesForType(List, List)}
   */
  @Test
  public void testAddPromotionMessagesForType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CartMessageOrderItemServiceExtensionHandler cartMessageOrderItemServiceExtensionHandler = new CartMessageOrderItemServiceExtensionHandler();
    ArrayList<PromotionMessageDTO> messageDTOs = new ArrayList<>();

    ArrayList<PromotionMessageDTO> messages = new ArrayList<>();
    messages.add(new PromotionMessageDTO(new PromotionMessageImpl()));
    PromotionMessageDTO promotionMessageDTO = new PromotionMessageDTO(new PromotionMessageImpl());
    messages.add(promotionMessageDTO);

    // Act
    cartMessageOrderItemServiceExtensionHandler.addPromotionMessagesForType(messageDTOs, messages);

    // Assert
    assertEquals(2, messageDTOs.size());
    assertSame(promotionMessageDTO, messageDTOs.get(1));
  }

  /**
   * Test
   * {@link CartMessageOrderItemServiceExtensionHandler#addPromotionMessagesForType(List, List)}.
   * <p>
   * Method under test:
   * {@link CartMessageOrderItemServiceExtensionHandler#addPromotionMessagesForType(List, List)}
   */
  @Test
  public void testAddPromotionMessagesForType2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CartMessageOrderItemServiceExtensionHandler cartMessageOrderItemServiceExtensionHandler = new CartMessageOrderItemServiceExtensionHandler();
    PromotionMessageImpl promotionMessage = mock(PromotionMessageImpl.class);
    when(promotionMessage.getPriority()).thenReturn(1);
    when(promotionMessage.getMessage()).thenReturn("Not all who wander are lost");
    when(promotionMessage.getMessagePlacement()).thenReturn("Message Placement");
    when(promotionMessage.getEndDate())
        .thenReturn(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    when(promotionMessage.getLocale()).thenReturn(new LocaleImpl());
    when(promotionMessage.getMedia()).thenReturn(new CategoryMediaXrefImpl());
    PromotionMessageDTO promotionMessageDTO = new PromotionMessageDTO(promotionMessage);

    ArrayList<PromotionMessageDTO> messageDTOs = new ArrayList<>();
    messageDTOs.add(promotionMessageDTO);

    // Act
    cartMessageOrderItemServiceExtensionHandler.addPromotionMessagesForType(messageDTOs, new ArrayList<>());

    // Assert that nothing has changed
    verify(promotionMessage).getEndDate();
    verify(promotionMessage, atLeast(1)).getLocale();
    verify(promotionMessage).getMedia();
    verify(promotionMessage).getMessage();
    verify(promotionMessage).getMessagePlacement();
    verify(promotionMessage).getPriority();
    assertEquals(1, messageDTOs.size());
    assertSame(promotionMessageDTO, messageDTOs.get(0));
  }

  /**
   * Test
   * {@link CartMessageOrderItemServiceExtensionHandler#addPromotionMessagesForType(List, List)}.
   * <ul>
   *   <li>Then {@link ArrayList#ArrayList()} size is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CartMessageOrderItemServiceExtensionHandler#addPromotionMessagesForType(List, List)}
   */
  @Test
  public void testAddPromotionMessagesForType_thenArrayListSizeIsOne() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CartMessageOrderItemServiceExtensionHandler cartMessageOrderItemServiceExtensionHandler = new CartMessageOrderItemServiceExtensionHandler();

    ArrayList<PromotionMessageDTO> messageDTOs = new ArrayList<>();
    PromotionMessageDTO promotionMessageDTO = new PromotionMessageDTO(new PromotionMessageImpl());
    messageDTOs.add(promotionMessageDTO);

    // Act
    cartMessageOrderItemServiceExtensionHandler.addPromotionMessagesForType(messageDTOs, new ArrayList<>());

    // Assert that nothing has changed
    assertEquals(1, messageDTOs.size());
    assertSame(promotionMessageDTO, messageDTOs.get(0));
  }

  /**
   * Test
   * {@link CartMessageOrderItemServiceExtensionHandler#addPromotionMessagesForType(List, List)}.
   * <ul>
   *   <li>Then {@link ArrayList#ArrayList()} size is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CartMessageOrderItemServiceExtensionHandler#addPromotionMessagesForType(List, List)}
   */
  @Test
  public void testAddPromotionMessagesForType_thenArrayListSizeIsOne2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CartMessageOrderItemServiceExtensionHandler cartMessageOrderItemServiceExtensionHandler = new CartMessageOrderItemServiceExtensionHandler();
    ArrayList<PromotionMessageDTO> messageDTOs = new ArrayList<>();

    ArrayList<PromotionMessageDTO> messages = new ArrayList<>();
    PromotionMessageDTO promotionMessageDTO = new PromotionMessageDTO(new PromotionMessageImpl());
    messages.add(promotionMessageDTO);

    // Act
    cartMessageOrderItemServiceExtensionHandler.addPromotionMessagesForType(messageDTOs, messages);

    // Assert
    assertEquals(1, messageDTOs.size());
    assertSame(promotionMessageDTO, messageDTOs.get(0));
  }

  /**
   * Test
   * {@link CartMessageOrderItemServiceExtensionHandler#addPromotionMessagesForType(List, List)}.
   * <ul>
   *   <li>Then {@link ArrayList#ArrayList()} size is two.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CartMessageOrderItemServiceExtensionHandler#addPromotionMessagesForType(List, List)}
   */
  @Test
  public void testAddPromotionMessagesForType_thenArrayListSizeIsTwo() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CartMessageOrderItemServiceExtensionHandler cartMessageOrderItemServiceExtensionHandler = new CartMessageOrderItemServiceExtensionHandler();

    ArrayList<PromotionMessageDTO> messageDTOs = new ArrayList<>();
    PromotionMessageDTO promotionMessageDTO = new PromotionMessageDTO(new PromotionMessageImpl());
    messageDTOs.add(promotionMessageDTO);
    messageDTOs.add(new PromotionMessageDTO(new PromotionMessageImpl()));

    // Act
    cartMessageOrderItemServiceExtensionHandler.addPromotionMessagesForType(messageDTOs, new ArrayList<>());

    // Assert that nothing has changed
    assertEquals(2, messageDTOs.size());
    assertSame(promotionMessageDTO, messageDTOs.get(0));
  }

  /**
   * Test
   * {@link CartMessageOrderItemServiceExtensionHandler#addPromotionMessagesForType(List, List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then {@link ArrayList#ArrayList()} Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CartMessageOrderItemServiceExtensionHandler#addPromotionMessagesForType(List, List)}
   */
  @Test
  public void testAddPromotionMessagesForType_whenArrayList_thenArrayListEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CartMessageOrderItemServiceExtensionHandler cartMessageOrderItemServiceExtensionHandler = new CartMessageOrderItemServiceExtensionHandler();
    ArrayList<PromotionMessageDTO> messageDTOs = new ArrayList<>();

    // Act
    cartMessageOrderItemServiceExtensionHandler.addPromotionMessagesForType(messageDTOs, new ArrayList<>());

    // Assert that nothing has changed
    assertTrue(messageDTOs.isEmpty());
  }

  /**
   * Test
   * {@link CartMessageOrderItemServiceExtensionHandler#addPromotionMessagesForType(List, List)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link ArrayList#ArrayList()} Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CartMessageOrderItemServiceExtensionHandler#addPromotionMessagesForType(List, List)}
   */
  @Test
  public void testAddPromotionMessagesForType_whenNull_thenArrayListEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CartMessageOrderItemServiceExtensionHandler cartMessageOrderItemServiceExtensionHandler = new CartMessageOrderItemServiceExtensionHandler();
    ArrayList<PromotionMessageDTO> messageDTOs = new ArrayList<>();

    // Act
    cartMessageOrderItemServiceExtensionHandler.addPromotionMessagesForType(messageDTOs, null);

    // Assert that nothing has changed
    assertTrue(messageDTOs.isEmpty());
  }

  /**
   * Test {@link CartMessageOrderItemServiceExtensionHandler#getPriority()}.
   * <p>
   * Method under test:
   * {@link CartMessageOrderItemServiceExtensionHandler#getPriority()}
   */
  @Test
  public void testGetPriority() {
    // Arrange, Act and Assert
    assertEquals(Integer.MAX_VALUE, (new CartMessageOrderItemServiceExtensionHandler()).getPriority());
  }
}
