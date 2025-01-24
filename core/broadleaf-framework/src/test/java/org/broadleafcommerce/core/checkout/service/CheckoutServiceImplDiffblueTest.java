package org.broadleafcommerce.core.checkout.service;

import static org.junit.Assert.assertFalse;
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
import org.broadleafcommerce.common.audit.Auditable;
import org.broadleafcommerce.common.currency.domain.BroadleafCurrencyImpl;
import org.broadleafcommerce.common.locale.domain.LocaleImpl;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.core.checkout.service.exception.CheckoutException;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.Order;
import org.broadleafcommerce.core.order.domain.OrderImpl;
import org.broadleafcommerce.core.order.service.type.OrderStatus;
import org.broadleafcommerce.profile.core.domain.CustomerImpl;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml",
    "/bl-framework-applicationContext-persistence.xml", "/bl-framework-applicationContext-workflow.xml",
    "/bl-framework-applicationContext.xml", "/blc-config/admin/framework/bl-framework-admin-applicationContext.xml",
    "/blc-config/site/framework/bl-framework-applicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class CheckoutServiceImplDiffblueTest {
  @Autowired
  private CheckoutServiceImpl checkoutServiceImpl;

  /**
   * Test {@link CheckoutServiceImpl#performCheckout(Order)}.
   * <p>
   * Method under test: {@link CheckoutServiceImpl#performCheckout(Order)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testPerformCheckout() throws CheckoutException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.checkout.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass277 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.checkout.service.CheckoutServiceImpl checkoutServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    CheckoutServiceImpl checkoutServiceImpl2 = new CheckoutServiceImpl();

    // Act
    checkoutServiceImpl2.performCheckout(new NullOrderImpl());
  }

  /**
   * Test {@link CheckoutServiceImpl#hasOrderBeenCompleted(Order)}.
   * <p>
   * Method under test: {@link CheckoutServiceImpl#hasOrderBeenCompleted(Order)}
   */
  @Test
  public void testHasOrderBeenCompleted() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CheckoutServiceImpl checkoutServiceImpl = new CheckoutServiceImpl();
    NullOrderImpl order = mock(NullOrderImpl.class);
    when(order.getStatus()).thenReturn(new OrderStatus("SUBMITTED", "SUBMITTED"));

    // Act
    boolean actualHasOrderBeenCompletedResult = checkoutServiceImpl.hasOrderBeenCompleted(order);

    // Assert
    verify(order).getStatus();
    assertTrue(actualHasOrderBeenCompletedResult);
  }

  /**
   * Test {@link CheckoutServiceImpl#hasOrderBeenCompleted(Order)}.
   * <p>
   * Method under test: {@link CheckoutServiceImpl#hasOrderBeenCompleted(Order)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testHasOrderBeenCompleted2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.checkout.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass264 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.checkout.service.CheckoutServiceImpl checkoutServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    CheckoutServiceImpl checkoutServiceImpl2 = new CheckoutServiceImpl();

    // Act
    checkoutServiceImpl2.hasOrderBeenCompleted(new NullOrderImpl());
  }

  /**
   * Test {@link CheckoutServiceImpl#hasOrderBeenCompleted(Order)}.
   * <ul>
   *   <li>Given {@link OrderStatus#ARCHIVED}.</li>
   *   <li>When {@link NullOrderImpl} {@link NullOrderImpl#getStatus()} return
   * {@link OrderStatus#ARCHIVED}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CheckoutServiceImpl#hasOrderBeenCompleted(Order)}
   */
  @Test
  public void testHasOrderBeenCompleted_givenArchived_whenNullOrderImplGetStatusReturnArchived() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CheckoutServiceImpl checkoutServiceImpl = new CheckoutServiceImpl();
    NullOrderImpl order = mock(NullOrderImpl.class);
    when(order.getStatus()).thenReturn(OrderStatus.ARCHIVED);

    // Act
    boolean actualHasOrderBeenCompletedResult = checkoutServiceImpl.hasOrderBeenCompleted(order);

    // Assert
    verify(order, atLeast(1)).getStatus();
    assertFalse(actualHasOrderBeenCompletedResult);
  }

  /**
   * Test {@link CheckoutServiceImpl#hasOrderBeenCompleted(Order)}.
   * <ul>
   *   <li>Given {@link Auditable} (default constructor) CreatedBy is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link CheckoutServiceImpl#hasOrderBeenCompleted(Order)}
   */
  @Test
  public void testHasOrderBeenCompleted_givenAuditableCreatedByIsOne() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CheckoutServiceImpl checkoutServiceImpl = new CheckoutServiceImpl();

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
    assertFalse(checkoutServiceImpl.hasOrderBeenCompleted(order));
  }

  /**
   * Test {@link CheckoutServiceImpl#hasOrderBeenCompleted(Order)}.
   * <ul>
   *   <li>Given {@link OrderStatus#CANCELLED}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CheckoutServiceImpl#hasOrderBeenCompleted(Order)}
   */
  @Test
  public void testHasOrderBeenCompleted_givenCancelled() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CheckoutServiceImpl checkoutServiceImpl = new CheckoutServiceImpl();
    NullOrderImpl order = mock(NullOrderImpl.class);
    when(order.getStatus()).thenReturn(OrderStatus.CANCELLED);

    // Act
    boolean actualHasOrderBeenCompletedResult = checkoutServiceImpl.hasOrderBeenCompleted(order);

    // Assert
    verify(order, atLeast(1)).getStatus();
    assertTrue(actualHasOrderBeenCompletedResult);
  }

  /**
   * Test {@link CheckoutServiceImpl#hasOrderBeenCompleted(Order)}.
   * <ul>
   *   <li>Given {@link OrderStatus#SUBMITTED}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CheckoutServiceImpl#hasOrderBeenCompleted(Order)}
   */
  @Test
  public void testHasOrderBeenCompleted_givenSubmitted() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CheckoutServiceImpl checkoutServiceImpl = new CheckoutServiceImpl();
    NullOrderImpl order = mock(NullOrderImpl.class);
    when(order.getStatus()).thenReturn(OrderStatus.SUBMITTED);

    // Act
    boolean actualHasOrderBeenCompletedResult = checkoutServiceImpl.hasOrderBeenCompleted(order);

    // Assert
    verify(order).getStatus();
    assertTrue(actualHasOrderBeenCompletedResult);
  }

  /**
   * Test {@link CheckoutServiceImpl#hasOrderBeenCompleted(Order)}.
   * <ul>
   *   <li>When {@link NullOrderImpl} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CheckoutServiceImpl#hasOrderBeenCompleted(Order)}
   */
  @Test
  public void testHasOrderBeenCompleted_whenNullOrderImpl_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CheckoutServiceImpl checkoutServiceImpl = new CheckoutServiceImpl();

    // Act and Assert
    assertFalse(checkoutServiceImpl.hasOrderBeenCompleted(new NullOrderImpl()));
  }
}
