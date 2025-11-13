package org.broadleafcommerce.core.web.order;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import org.aspectj.lang.ProceedingJoinPoint;
import org.broadleafcommerce.common.audit.Auditable;
import org.broadleafcommerce.common.locale.domain.LocaleImpl;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.profile.core.domain.ChallengeQuestionImpl;
import org.broadleafcommerce.profile.core.domain.CustomerImpl;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mockito.Mockito;
import org.springframework.context.ApplicationContext;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;

@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class OrderStateAOPDiffblueTest {
  /**
   * Test {@link OrderStateAOP#processOrderRetrieval(ProceedingJoinPoint)}.
   *
   * <ul>
   *   <li>Given {@link NullOrderImpl} (default constructor).
   *   <li>Then return {@link NullOrderImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link OrderStateAOP#processOrderRetrieval(ProceedingJoinPoint)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Object OrderStateAOP.processOrderRetrieval(ProceedingJoinPoint)"})
  public void testProcessOrderRetrieval_givenNullOrderImpl_thenReturnNullOrderImpl()
      throws Throwable {
    // Arrange
    ApplicationContext applicationContext = mock(ApplicationContext.class);
    when(applicationContext.getBean(Mockito.<String>any())).thenReturn(new OrderState());

    OrderStateAOP orderStateAOP = new OrderStateAOP();
    orderStateAOP.setApplicationContext(applicationContext);

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    NullOrderImpl nullOrderImpl = new NullOrderImpl();
    when(call.proceed()).thenReturn(nullOrderImpl);
    when(call.getArgs()).thenReturn(new Object[] {customerImpl});

    // Act
    Object actualProcessOrderRetrievalResult = orderStateAOP.processOrderRetrieval(call);

    // Assert
    verify(call).getArgs();
    verify(call).proceed();
    verify(applicationContext).getBean("blOrderState");
    assertSame(nullOrderImpl, actualProcessOrderRetrievalResult);
  }

  /**
   * Test {@link OrderStateAOP#processOrderRetrieval(ProceedingJoinPoint)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link OrderStateAOP#processOrderRetrieval(ProceedingJoinPoint)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Object OrderStateAOP.processOrderRetrieval(ProceedingJoinPoint)"})
  public void testProcessOrderRetrieval_givenNull_thenReturnNull() throws Throwable {
    // Arrange
    ApplicationContext applicationContext = mock(ApplicationContext.class);
    when(applicationContext.getBean(Mockito.<String>any())).thenReturn(new OrderState());

    OrderStateAOP orderStateAOP = new OrderStateAOP();
    orderStateAOP.setApplicationContext(applicationContext);

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    when(call.proceed()).thenReturn(null);
    when(call.getArgs()).thenReturn(new Object[] {customerImpl});

    // Act
    Object actualProcessOrderRetrievalResult = orderStateAOP.processOrderRetrieval(call);

    // Assert
    verify(call).getArgs();
    verify(call).proceed();
    verify(applicationContext).getBean("blOrderState");
    assertNull(actualProcessOrderRetrievalResult);
  }

  /**
   * Test {@link OrderStateAOP#processOrderRetrieval(ProceedingJoinPoint)}.
   *
   * <ul>
   *   <li>Given {@link Throwable#Throwable()}.
   *   <li>Then throw {@link Throwable}.
   * </ul>
   *
   * <p>Method under test: {@link OrderStateAOP#processOrderRetrieval(ProceedingJoinPoint)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Object OrderStateAOP.processOrderRetrieval(ProceedingJoinPoint)"})
  public void testProcessOrderRetrieval_givenThrowable_thenThrowThrowable() throws Throwable {
    // Arrange
    ApplicationContext applicationContext = mock(ApplicationContext.class);
    when(applicationContext.getBean(Mockito.<String>any())).thenReturn(new OrderState());

    OrderStateAOP orderStateAOP = new OrderStateAOP();
    orderStateAOP.setApplicationContext(applicationContext);

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    when(call.proceed()).thenThrow(new Throwable());
    when(call.getArgs()).thenReturn(new Object[] {customerImpl});

    // Act and Assert
    assertThrows(Throwable.class, () -> orderStateAOP.processOrderRetrieval(call));
    verify(call).getArgs();
    verify(call).proceed();
    verify(applicationContext).getBean("blOrderState");
  }
}
