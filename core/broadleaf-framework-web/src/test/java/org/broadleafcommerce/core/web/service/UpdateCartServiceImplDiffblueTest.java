package org.broadleafcommerce.core.web.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import org.broadleafcommerce.common.audit.Auditable;
import org.broadleafcommerce.common.currency.domain.BroadleafCurrency;
import org.broadleafcommerce.common.currency.domain.BroadleafCurrencyImpl;
import org.broadleafcommerce.common.locale.domain.LocaleImpl;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.core.catalog.domain.SkuImpl;
import org.broadleafcommerce.core.order.domain.DiscreteOrderItem;
import org.broadleafcommerce.core.order.domain.DiscreteOrderItemImpl;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.Order;
import org.broadleafcommerce.core.order.domain.OrderImpl;
import org.broadleafcommerce.core.order.service.call.OrderItemRequestDTO;
import org.broadleafcommerce.core.order.service.call.UpdateCartResponse;
import org.broadleafcommerce.core.order.service.type.OrderStatus;
import org.broadleafcommerce.profile.core.domain.CustomerImpl;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml",
    "/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml",
    "/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
@ExtendWith(SpringExtension.class)
class UpdateCartServiceImplDiffblueTest {
  @Autowired
  private UpdateCartServiceImpl updateCartServiceImpl;

  /**
   * Test {@link UpdateCartServiceImpl#currencyHasChanged()}.
   * <p>
   * Method under test: {@link UpdateCartServiceImpl#currencyHasChanged()}
   */
  @Test
  @DisplayName("Test currencyHasChanged()")
  void testCurrencyHasChanged() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new UpdateCartServiceImpl()).currencyHasChanged());
  }

  /**
   * Test {@link UpdateCartServiceImpl#currencyHasChanged()}.
   * <p>
   * Method under test: {@link UpdateCartServiceImpl#currencyHasChanged()}
   */
  @Test
  @DisplayName("Test currencyHasChanged()")
  @Disabled("TODO: Complete this test")
  void testCurrencyHasChanged2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml","/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass4737 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.service.UpdateCartServiceImpl updateCartServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new UpdateCartServiceImpl()).currencyHasChanged();
  }

  /**
   * Test {@link UpdateCartServiceImpl#copyCartToCurrentContext(Order)}.
   * <p>
   * Method under test:
   * {@link UpdateCartServiceImpl#copyCartToCurrentContext(Order)}
   */
  @Test
  @DisplayName("Test copyCartToCurrentContext(Order)")
  @Disabled("TODO: Complete this test")
  void testCopyCartToCurrentContext() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml","/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass4725 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.service.UpdateCartServiceImpl updateCartServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    UpdateCartServiceImpl updateCartServiceImpl2 = new UpdateCartServiceImpl();

    // Act
    updateCartServiceImpl2.copyCartToCurrentContext(new NullOrderImpl());
  }

  /**
   * Test {@link UpdateCartServiceImpl#copyCartToCurrentContext(Order)}.
   * <ul>
   *   <li>Given {@link Auditable} (default constructor) CreatedBy is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link UpdateCartServiceImpl#copyCartToCurrentContext(Order)}
   */
  @Test
  @DisplayName("Test copyCartToCurrentContext(Order); given Auditable (default constructor) CreatedBy is one")
  void testCopyCartToCurrentContext_givenAuditableCreatedByIsOne() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    UpdateCartServiceImpl updateCartServiceImpl = new UpdateCartServiceImpl();

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    OrderImpl currentCart = new OrderImpl();
    currentCart.setAdditionalOfferInformation(new HashMap<>());
    currentCart.setAuditable(auditable);
    currentCart.setCandidateOrderOffers(new ArrayList<>());
    currentCart.setCurrency(new BroadleafCurrencyImpl());
    currentCart.setCustomer(new CustomerImpl());
    currentCart.setEmailAddress("42 Main St");
    currentCart.setFulfillmentGroups(new ArrayList<>());
    currentCart.setId(1L);
    currentCart.setLocale(new LocaleImpl());
    currentCart.setName("Name");
    currentCart.setOrderAttributes(new HashMap<>());
    currentCart.setOrderItems(new ArrayList<>());
    currentCart.setOrderMessages(new ArrayList<>());
    currentCart.setOrderNumber("42");
    currentCart.setPayments(new ArrayList<>());
    currentCart.setStatus(new OrderStatus("Type", "Friendly Type"));
    currentCart.setSubTotal(new Money());
    currentCart.setSubmitDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    currentCart.setTaxOverride(true);
    currentCart.setTotal(new Money());
    currentCart.setTotalFulfillmentCharges(new Money());
    currentCart.setTotalShipping(new Money());
    currentCart.setTotalTax(new Money());

    // Act and Assert
    assertNull(updateCartServiceImpl.copyCartToCurrentContext(currentCart));
  }

  /**
   * Test {@link UpdateCartServiceImpl#copyCartToCurrentContext(Order)}.
   * <ul>
   *   <li>Then calls {@link NullOrderImpl#getOrderItems()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link UpdateCartServiceImpl#copyCartToCurrentContext(Order)}
   */
  @Test
  @DisplayName("Test copyCartToCurrentContext(Order); then calls getOrderItems()")
  void testCopyCartToCurrentContext_thenCallsGetOrderItems() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    UpdateCartServiceImpl updateCartServiceImpl = new UpdateCartServiceImpl();
    NullOrderImpl currentCart = mock(NullOrderImpl.class);
    when(currentCart.getOrderItems()).thenReturn(new ArrayList<>());

    // Act
    UpdateCartResponse actualCopyCartToCurrentContextResult = updateCartServiceImpl
        .copyCartToCurrentContext(currentCart);

    // Assert
    verify(currentCart).getOrderItems();
    assertNull(actualCopyCartToCurrentContextResult);
  }

  /**
   * Test {@link UpdateCartServiceImpl#copyCartToCurrentContext(Order)}.
   * <ul>
   *   <li>When {@link NullOrderImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link UpdateCartServiceImpl#copyCartToCurrentContext(Order)}
   */
  @Test
  @DisplayName("Test copyCartToCurrentContext(Order); when NullOrderImpl (default constructor); then return 'null'")
  void testCopyCartToCurrentContext_whenNullOrderImpl_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    UpdateCartServiceImpl updateCartServiceImpl = new UpdateCartServiceImpl();

    // Act and Assert
    assertNull(updateCartServiceImpl.copyCartToCurrentContext(new NullOrderImpl()));
  }

  /**
   * Test
   * {@link UpdateCartServiceImpl#validateAddToCartRequest(OrderItemRequestDTO, Order)}.
   * <p>
   * Method under test:
   * {@link UpdateCartServiceImpl#validateAddToCartRequest(OrderItemRequestDTO, Order)}
   */
  @Test
  @DisplayName("Test validateAddToCartRequest(OrderItemRequestDTO, Order)")
  @Disabled("TODO: Complete this test")
  void testValidateAddToCartRequest() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml","/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass4779 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.service.UpdateCartServiceImpl updateCartServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    UpdateCartServiceImpl updateCartServiceImpl2 = new UpdateCartServiceImpl();
    OrderItemRequestDTO itemRequest = new OrderItemRequestDTO();

    // Act
    updateCartServiceImpl2.validateAddToCartRequest(itemRequest, new NullOrderImpl());
  }

  /**
   * Test {@link UpdateCartServiceImpl#updateAndValidateCart(Order)}.
   * <p>
   * Method under test: {@link UpdateCartServiceImpl#updateAndValidateCart(Order)}
   */
  @Test
  @DisplayName("Test updateAndValidateCart(Order)")
  @Disabled("TODO: Complete this test")
  void testUpdateAndValidateCart() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml","/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass4767 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.service.UpdateCartServiceImpl updateCartServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    UpdateCartServiceImpl updateCartServiceImpl2 = new UpdateCartServiceImpl();

    // Act
    updateCartServiceImpl2.updateAndValidateCart(new NullOrderImpl());
  }

  /**
   * Test {@link UpdateCartServiceImpl#lockOrder(Order, Object)}.
   * <p>
   * Method under test: {@link UpdateCartServiceImpl#lockOrder(Order, Object)}
   */
  @Test
  @DisplayName("Test lockOrder(Order, Object)")
  @Disabled("TODO: Complete this test")
  void testLockOrder() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml","/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass4740 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.service.UpdateCartServiceImpl updateCartServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    UpdateCartServiceImpl updateCartServiceImpl2 = new UpdateCartServiceImpl();

    // Act
    updateCartServiceImpl2.lockOrder(new NullOrderImpl(), "Lock Object");
  }

  /**
   * Test {@link UpdateCartServiceImpl#lockOrder(Order, Object)}.
   * <ul>
   *   <li>When {@link NullOrderImpl} (default constructor).</li>
   *   <li>Then return {@code Lock Object}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UpdateCartServiceImpl#lockOrder(Order, Object)}
   */
  @Test
  @DisplayName("Test lockOrder(Order, Object); when NullOrderImpl (default constructor); then return 'Lock Object'")
  void testLockOrder_whenNullOrderImpl_thenReturnLockObject() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    UpdateCartServiceImpl updateCartServiceImpl = new UpdateCartServiceImpl();

    // Act and Assert
    assertEquals("Lock Object", updateCartServiceImpl.lockOrder(new NullOrderImpl(), "Lock Object"));
  }

  /**
   * Test {@link UpdateCartServiceImpl#lockOrder(Order, Object)}.
   * <ul>
   *   <li>When {@link NullOrderImpl}.</li>
   *   <li>Then return {@code Lock Object}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UpdateCartServiceImpl#lockOrder(Order, Object)}
   */
  @Test
  @DisplayName("Test lockOrder(Order, Object); when NullOrderImpl; then return 'Lock Object'")
  void testLockOrder_whenNullOrderImpl_thenReturnLockObject2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("Lock Object", (new UpdateCartServiceImpl()).lockOrder(mock(NullOrderImpl.class), "Lock Object"));
  }

  /**
   * Test {@link UpdateCartServiceImpl#getErrorInsteadOfQueue()}.
   * <p>
   * Method under test: {@link UpdateCartServiceImpl#getErrorInsteadOfQueue()}
   */
  @Test
  @DisplayName("Test getErrorInsteadOfQueue()")
  @Disabled("TODO: Complete this test")
  void testGetErrorInsteadOfQueue() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml","/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass4739 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.service.UpdateCartServiceImpl updateCartServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new UpdateCartServiceImpl()).getErrorInsteadOfQueue();
  }

  /**
   * Test {@link UpdateCartServiceImpl#findActiveCurrency()}.
   * <p>
   * Method under test: {@link UpdateCartServiceImpl#findActiveCurrency()}
   */
  @Test
  @DisplayName("Test findActiveCurrency()")
  void testFindActiveCurrency() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new UpdateCartServiceImpl()).findActiveCurrency());
  }

  /**
   * Test {@link UpdateCartServiceImpl#findActiveCurrency()}.
   * <p>
   * Method under test: {@link UpdateCartServiceImpl#findActiveCurrency()}
   */
  @Test
  @DisplayName("Test findActiveCurrency()")
  @Disabled("TODO: Complete this test")
  void testFindActiveCurrency2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml","/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass4738 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.service.UpdateCartServiceImpl updateCartServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new UpdateCartServiceImpl()).findActiveCurrency();
  }

  /**
   * Test
   * {@link UpdateCartServiceImpl#checkAvailabilityInLocale(DiscreteOrderItem, BroadleafCurrency)}.
   * <p>
   * Method under test:
   * {@link UpdateCartServiceImpl#checkAvailabilityInLocale(DiscreteOrderItem, BroadleafCurrency)}
   */
  @Test
  @DisplayName("Test checkAvailabilityInLocale(DiscreteOrderItem, BroadleafCurrency)")
  @Disabled("TODO: Complete this test")
  void testCheckAvailabilityInLocale() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml","/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass4668 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.service.UpdateCartServiceImpl updateCartServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    UpdateCartServiceImpl updateCartServiceImpl2 = new UpdateCartServiceImpl();
    DiscreteOrderItemImpl doi = new DiscreteOrderItemImpl();

    // Act
    updateCartServiceImpl2.checkAvailabilityInLocale(doi, new BroadleafCurrencyImpl());
  }

  /**
   * Test
   * {@link UpdateCartServiceImpl#checkAvailabilityInLocale(DiscreteOrderItem, BroadleafCurrency)}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor).</li>
   *   <li>Then calls {@link DiscreteOrderItem#getSku()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link UpdateCartServiceImpl#checkAvailabilityInLocale(DiscreteOrderItem, BroadleafCurrency)}
   */
  @Test
  @DisplayName("Test checkAvailabilityInLocale(DiscreteOrderItem, BroadleafCurrency); given SkuImpl (default constructor); then calls getSku()")
  void testCheckAvailabilityInLocale_givenSkuImpl_thenCallsGetSku() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    UpdateCartServiceImpl updateCartServiceImpl = new UpdateCartServiceImpl();
    DiscreteOrderItem doi = mock(DiscreteOrderItem.class);
    when(doi.getSku()).thenReturn(new SkuImpl());

    // Act
    boolean actualCheckAvailabilityInLocaleResult = updateCartServiceImpl.checkAvailabilityInLocale(doi,
        new BroadleafCurrencyImpl());

    // Assert
    verify(doi).getSku();
    assertFalse(actualCheckAvailabilityInLocaleResult);
  }

  /**
   * Test
   * {@link UpdateCartServiceImpl#checkAvailabilityInLocale(DiscreteOrderItem, BroadleafCurrency)}.
   * <ul>
   *   <li>When {@link DiscreteOrderItemImpl} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link UpdateCartServiceImpl#checkAvailabilityInLocale(DiscreteOrderItem, BroadleafCurrency)}
   */
  @Test
  @DisplayName("Test checkAvailabilityInLocale(DiscreteOrderItem, BroadleafCurrency); when DiscreteOrderItemImpl (default constructor); then return 'false'")
  void testCheckAvailabilityInLocale_whenDiscreteOrderItemImpl_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    UpdateCartServiceImpl updateCartServiceImpl = new UpdateCartServiceImpl();
    DiscreteOrderItemImpl doi = new DiscreteOrderItemImpl();

    // Act and Assert
    assertFalse(updateCartServiceImpl.checkAvailabilityInLocale(doi, new BroadleafCurrencyImpl()));
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link UpdateCartServiceImpl#setSavedCurrency(BroadleafCurrency)}
   *   <li>{@link UpdateCartServiceImpl#getSavedCurrency()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange
    UpdateCartServiceImpl updateCartServiceImpl = new UpdateCartServiceImpl();
    BroadleafCurrencyImpl savedCurrency = new BroadleafCurrencyImpl();

    // Act
    updateCartServiceImpl.setSavedCurrency(savedCurrency);

    // Assert that nothing has changed
    assertSame(savedCurrency, updateCartServiceImpl.getSavedCurrency());
  }
}
