package org.broadleafcommerce.core.web.order;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import org.aspectj.lang.ProceedingJoinPoint;
import org.broadleafcommerce.common.audit.Auditable;
import org.broadleafcommerce.common.currency.domain.BroadleafCurrencyImpl;
import org.broadleafcommerce.common.locale.domain.LocaleImpl;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.Order;
import org.broadleafcommerce.core.order.domain.OrderImpl;
import org.broadleafcommerce.core.order.service.type.OrderStatus;
import org.broadleafcommerce.profile.core.domain.ChallengeQuestionImpl;
import org.broadleafcommerce.profile.core.domain.Customer;
import org.broadleafcommerce.profile.core.domain.CustomerImpl;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.aop.aspectj.MethodInvocationProceedingJoinPoint;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.reactive.context.AnnotationConfigReactiveWebApplicationContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml",
    "/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml",
    "/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
@ExtendWith(SpringExtension.class)
class OrderStateAOPDiffblueTest {
  @Autowired
  private OrderStateAOP orderStateAOP;

  /**
   * Test {@link OrderStateAOP#processOrderRetrieval(ProceedingJoinPoint)}.
   * <p>
   * Method under test:
   * {@link OrderStateAOP#processOrderRetrieval(ProceedingJoinPoint)}
   */
  @Test
  @DisplayName("Test processOrderRetrieval(ProceedingJoinPoint)")
  void testProcessOrderRetrieval() throws Throwable {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderState orderState = mock(OrderState.class);
    when(orderState.getOrder(Mockito.<Customer>any())).thenReturn(new NullOrderImpl());
    AnnotationConfigApplicationContext applicationContext = mock(AnnotationConfigApplicationContext.class);
    when(applicationContext.getBean(Mockito.<String>any())).thenReturn(orderState);

    OrderStateAOP orderStateAOP = new OrderStateAOP();
    orderStateAOP.setApplicationContext(applicationContext);

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    CustomerImpl customerImpl = new CustomerImpl();
    customerImpl.setAuditable(auditable);
    customerImpl.setChallengeAnswer("blOrderState");
    customerImpl.setChallengeQuestion(new ChallengeQuestionImpl());
    customerImpl.setCustomerAddresses(new ArrayList<>());
    customerImpl.setCustomerAttributes(new HashMap<>());
    customerImpl.setCustomerLocale(new LocaleImpl());
    customerImpl.setCustomerPayments(new ArrayList<>());
    customerImpl.setCustomerPhones(new ArrayList<>());
    customerImpl.setDeactivated(true);
    customerImpl.setEmailAddress("42 Main St");
    customerImpl.setExternalId("42");
    customerImpl.setFirstName("Jane");
    customerImpl.setId(1L);
    customerImpl.setLastName("Doe");
    customerImpl.setPassword("iloveyou");
    customerImpl.setPasswordChangeRequired(true);
    customerImpl.setReceiveEmail(true);
    customerImpl.setRegistered(true);
    customerImpl.setUnencodedChallengeAnswer("secret");
    customerImpl.setUnencodedPassword("secret");
    customerImpl.setUsername("janedoe");
    ProceedingJoinPoint call = mock(ProceedingJoinPoint.class);
    when(call.getArgs()).thenReturn(new Object[]{customerImpl});

    // Act
    Object actualProcessOrderRetrievalResult = orderStateAOP.processOrderRetrieval(call);

    // Assert
    verify(call).getArgs();
    verify(orderState).getOrder(isA(Customer.class));
    verify(applicationContext).getBean(eq("blOrderState"));
    assertTrue(actualProcessOrderRetrievalResult instanceof NullOrderImpl);
    Money orderAdjustmentsValue = ((NullOrderImpl) actualProcessOrderRetrievalResult).getOrderAdjustmentsValue();
    assertEquals(orderAdjustmentsValue, orderAdjustmentsValue.abs());
    assertEquals(orderAdjustmentsValue, orderAdjustmentsValue.zero());
    assertEquals(orderAdjustmentsValue, ((NullOrderImpl) actualProcessOrderRetrievalResult).getSubTotal());
  }

  /**
   * Test {@link OrderStateAOP#processOrderRetrieval(ProceedingJoinPoint)}.
   * <p>
   * Method under test:
   * {@link OrderStateAOP#processOrderRetrieval(ProceedingJoinPoint)}
   */
  @Test
  @DisplayName("Test processOrderRetrieval(ProceedingJoinPoint)")
  @Disabled("TODO: Complete this test")
  void testProcessOrderRetrieval2() throws Throwable {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.order;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml","/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass7560 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.order.OrderStateAOP orderStateAOP;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    orderStateAOP.processOrderRetrieval(new MethodInvocationProceedingJoinPoint(null));
  }

  /**
   * Test {@link OrderStateAOP#processOrderRetrieval(ProceedingJoinPoint)}.
   * <ul>
   *   <li>Then return SubTotal is {@link Money#Money()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OrderStateAOP#processOrderRetrieval(ProceedingJoinPoint)}
   */
  @Test
  @DisplayName("Test processOrderRetrieval(ProceedingJoinPoint); then return SubTotal is Money()")
  void testProcessOrderRetrieval_thenReturnSubTotalIsMoney() throws Throwable {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderState orderState = mock(OrderState.class);
    when(orderState.setOrder(Mockito.<Customer>any(), Mockito.<Order>any())).thenReturn(new NullOrderImpl());
    when(orderState.getOrder(Mockito.<Customer>any())).thenReturn(null);
    AnnotationConfigApplicationContext applicationContext = mock(AnnotationConfigApplicationContext.class);
    when(applicationContext.getBean(Mockito.<String>any())).thenReturn(orderState);

    OrderStateAOP orderStateAOP = new OrderStateAOP();
    orderStateAOP.setApplicationContext(applicationContext);

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    CustomerImpl customerImpl = new CustomerImpl();
    customerImpl.setAuditable(auditable);
    customerImpl.setChallengeAnswer("blOrderState");
    customerImpl.setChallengeQuestion(new ChallengeQuestionImpl());
    customerImpl.setCustomerAddresses(new ArrayList<>());
    customerImpl.setCustomerAttributes(new HashMap<>());
    customerImpl.setCustomerLocale(new LocaleImpl());
    customerImpl.setCustomerPayments(new ArrayList<>());
    customerImpl.setCustomerPhones(new ArrayList<>());
    customerImpl.setDeactivated(true);
    customerImpl.setEmailAddress("42 Main St");
    customerImpl.setExternalId("42");
    customerImpl.setFirstName("Jane");
    customerImpl.setId(1L);
    customerImpl.setLastName("Doe");
    customerImpl.setPassword("iloveyou");
    customerImpl.setPasswordChangeRequired(true);
    customerImpl.setReceiveEmail(true);
    customerImpl.setRegistered(true);
    customerImpl.setUnencodedChallengeAnswer("secret");
    customerImpl.setUnencodedPassword("secret");
    customerImpl.setUsername("janedoe");

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(1L);
    auditable2.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(1L);

    OrderImpl orderImpl = new OrderImpl();
    orderImpl.setAdditionalOfferInformation(new HashMap<>());
    orderImpl.setAuditable(auditable2);
    orderImpl.setCandidateOrderOffers(new ArrayList<>());
    orderImpl.setCurrency(new BroadleafCurrencyImpl());
    orderImpl.setCustomer(new CustomerImpl());
    orderImpl.setEmailAddress("42 Main St");
    orderImpl.setFulfillmentGroups(new ArrayList<>());
    orderImpl.setId(1L);
    orderImpl.setLocale(new LocaleImpl());
    orderImpl.setName("blOrderState");
    orderImpl.setOrderAttributes(new HashMap<>());
    orderImpl.setOrderItems(new ArrayList<>());
    orderImpl.setOrderMessages(new ArrayList<>());
    orderImpl.setOrderNumber("42");
    orderImpl.setPayments(new ArrayList<>());
    orderImpl.setStatus(new OrderStatus("blOrderState", "blOrderState"));
    Money subTotal = new Money();
    orderImpl.setSubTotal(subTotal);
    orderImpl.setSubmitDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    orderImpl.setTaxOverride(true);
    orderImpl.setTotal(new Money());
    orderImpl.setTotalFulfillmentCharges(new Money());
    orderImpl.setTotalShipping(new Money());
    Money totalTax = new Money();
    orderImpl.setTotalTax(totalTax);
    ProceedingJoinPoint call = mock(ProceedingJoinPoint.class);
    when(call.proceed()).thenReturn(orderImpl);
    when(call.getArgs()).thenReturn(new Object[]{customerImpl});

    // Act
    Object actualProcessOrderRetrievalResult = orderStateAOP.processOrderRetrieval(call);

    // Assert
    verify(call).getArgs();
    verify(call).proceed();
    verify(orderState).getOrder(isA(Customer.class));
    verify(orderState).setOrder(isA(Customer.class), isA(Order.class));
    verify(applicationContext).getBean(eq("blOrderState"));
    assertTrue(actualProcessOrderRetrievalResult instanceof NullOrderImpl);
    assertEquals(subTotal, ((NullOrderImpl) actualProcessOrderRetrievalResult).getSubTotal());
    Money expectedOrderAdjustmentsValue = totalTax.ZERO;
    assertSame(expectedOrderAdjustmentsValue,
        ((NullOrderImpl) actualProcessOrderRetrievalResult).getOrderAdjustmentsValue());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link OrderStateAOP}
   *   <li>{@link OrderStateAOP#setApplicationContext(ApplicationContext)}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() throws BeansException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing observers.
    //   Diffblue Cover was unable to create an assertion.
    //   Add getters for the following fields or make them package-private:
    //     OrderStateAOP.applicationContext

    // Arrange and Act
    OrderStateAOP actualOrderStateAOP = new OrderStateAOP();
    actualOrderStateAOP.setApplicationContext(new AnnotationConfigReactiveWebApplicationContext());
  }
}
