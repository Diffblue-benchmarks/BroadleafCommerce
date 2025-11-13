package org.broadleafcommerce.core.offer.service.workflow;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import org.broadleafcommerce.core.checkout.service.workflow.CheckoutSeed;
import org.broadleafcommerce.core.offer.domain.Offer;
import org.broadleafcommerce.core.offer.domain.OfferCode;
import org.broadleafcommerce.core.offer.domain.OfferCodeImpl;
import org.broadleafcommerce.core.offer.domain.OfferImpl;
import org.broadleafcommerce.core.offer.service.OfferAuditService;
import org.broadleafcommerce.core.offer.service.OfferService;
import org.broadleafcommerce.core.offer.service.exception.OfferMaxUseExceededException;
import org.broadleafcommerce.core.offer.service.type.CustomerMaxUsesStrategyType;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.Order;
import org.broadleafcommerce.core.order.domain.OrderImpl;
import org.broadleafcommerce.core.workflow.DefaultProcessContextImpl;
import org.broadleafcommerce.core.workflow.ProcessContext;
import org.broadleafcommerce.profile.core.domain.CustomerImpl;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class VerifyCustomerMaxOfferUsesActivityDiffblueTest {
  @Mock private OfferAuditService offerAuditService;

  @Mock private OfferService offerService;

  @InjectMocks private VerifyCustomerMaxOfferUsesActivity verifyCustomerMaxOfferUsesActivity;

  /**
   * Test {@link VerifyCustomerMaxOfferUsesActivity#execute(ProcessContext)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link OfferCodeImpl} (default constructor).
   *   <li>Then return {@link DefaultProcessContextImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link VerifyCustomerMaxOfferUsesActivity#execute(ProcessContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ProcessContext VerifyCustomerMaxOfferUsesActivity.execute(ProcessContext)"})
  public void testExecute_givenArrayListAddOfferCodeImpl_thenReturnDefaultProcessContextImpl()
      throws Exception {
    // Arrange
    when(offerService.getUniqueOffersFromOrder(Mockito.<Order>any())).thenReturn(new HashSet<>());

    ArrayList<OfferCode> offerCodeList = new ArrayList<>();
    offerCodeList.add(new OfferCodeImpl());

    Order order = mock(Order.class);
    when(order.getAddedOfferCodes()).thenReturn(offerCodeList);
    CheckoutSeed checkoutSeed = new CheckoutSeed(order, new HashMap<>());

    DefaultProcessContextImpl<CheckoutSeed> context = new DefaultProcessContextImpl<>();
    context.setSeedData(checkoutSeed);

    // Act
    ProcessContext<CheckoutSeed> actualExecuteResult =
        verifyCustomerMaxOfferUsesActivity.execute(context);

    // Assert
    verify(offerService).getUniqueOffersFromOrder(isA(Order.class));
    verify(order).getAddedOfferCodes();
    assertSame(context, actualExecuteResult);
  }

  /**
   * Test {@link VerifyCustomerMaxOfferUsesActivity#execute(ProcessContext)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link OfferCodeImpl} (default constructor).
   *   <li>Then return {@link DefaultProcessContextImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link VerifyCustomerMaxOfferUsesActivity#execute(ProcessContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ProcessContext VerifyCustomerMaxOfferUsesActivity.execute(ProcessContext)"})
  public void testExecute_givenArrayListAddOfferCodeImpl_thenReturnDefaultProcessContextImpl2()
      throws Exception {
    // Arrange
    HashSet<Offer> offerSet = new HashSet<>();
    offerSet.add(new OfferImpl());
    when(offerService.getUniqueOffersFromOrder(Mockito.<Order>any())).thenReturn(offerSet);

    ArrayList<OfferCode> offerCodeList = new ArrayList<>();
    offerCodeList.add(new OfferCodeImpl());

    Order order = mock(Order.class);
    when(order.getAddedOfferCodes()).thenReturn(offerCodeList);
    CheckoutSeed checkoutSeed = new CheckoutSeed(order, new HashMap<>());

    DefaultProcessContextImpl<CheckoutSeed> context = new DefaultProcessContextImpl<>();
    context.setSeedData(checkoutSeed);

    // Act
    ProcessContext<CheckoutSeed> actualExecuteResult =
        verifyCustomerMaxOfferUsesActivity.execute(context);

    // Assert
    verify(offerService).getUniqueOffersFromOrder(isA(Order.class));
    verify(order).getAddedOfferCodes();
    assertSame(context, actualExecuteResult);
  }

  /**
   * Test {@link VerifyCustomerMaxOfferUsesActivity#execute(ProcessContext)}.
   *
   * <ul>
   *   <li>Given {@link OfferAuditService} {@link OfferAuditService#countOfferCodeUses(Order, Long)}
   *       return one.
   *   <li>Then calls {@link OfferCodeImpl#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link VerifyCustomerMaxOfferUsesActivity#execute(ProcessContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ProcessContext VerifyCustomerMaxOfferUsesActivity.execute(ProcessContext)"})
  public void testExecute_givenOfferAuditServiceCountOfferCodeUsesReturnOne_thenCallsGetId()
      throws Exception {
    // Arrange
    when(offerAuditService.countOfferCodeUses(Mockito.<Order>any(), Mockito.<Long>any()))
        .thenReturn(1L);
    when(offerService.getUniqueOffersFromOrder(Mockito.<Order>any())).thenReturn(new HashSet<>());

    OfferCodeImpl offerCodeImpl = mock(OfferCodeImpl.class);
    when(offerCodeImpl.getMaxUses()).thenReturn(3);
    when(offerCodeImpl.getId()).thenReturn(1L);
    when(offerCodeImpl.isLimitedUse()).thenReturn(true);

    ArrayList<OfferCode> offerCodeList = new ArrayList<>();
    offerCodeList.add(offerCodeImpl);

    Order order = mock(Order.class);
    when(order.getAddedOfferCodes()).thenReturn(offerCodeList);
    CheckoutSeed checkoutSeed = new CheckoutSeed(order, new HashMap<>());

    DefaultProcessContextImpl<CheckoutSeed> context = new DefaultProcessContextImpl<>();
    context.setSeedData(checkoutSeed);

    // Act
    ProcessContext<CheckoutSeed> actualExecuteResult =
        verifyCustomerMaxOfferUsesActivity.execute(context);

    // Assert
    verify(offerCodeImpl).getId();
    verify(offerCodeImpl).getMaxUses();
    verify(offerCodeImpl).isLimitedUse();
    verify(offerAuditService).countOfferCodeUses(isA(Order.class), eq(1L));
    verify(offerService).getUniqueOffersFromOrder(isA(Order.class));
    verify(order).getAddedOfferCodes();
    assertSame(context, actualExecuteResult);
  }

  /**
   * Test {@link VerifyCustomerMaxOfferUsesActivity#execute(ProcessContext)}.
   *
   * <ul>
   *   <li>Given {@link OfferCodeImpl} {@link OfferCodeImpl#getOfferCode()} return {@code Offer
   *       Code}.
   *   <li>Then calls {@link OfferCodeImpl#getOfferCode()}.
   * </ul>
   *
   * <p>Method under test: {@link VerifyCustomerMaxOfferUsesActivity#execute(ProcessContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ProcessContext VerifyCustomerMaxOfferUsesActivity.execute(ProcessContext)"})
  public void testExecute_givenOfferCodeImplGetOfferCodeReturnOfferCode_thenCallsGetOfferCode()
      throws Exception {
    // Arrange
    when(offerAuditService.countOfferCodeUses(Mockito.<Order>any(), Mockito.<Long>any()))
        .thenReturn(3L);
    when(offerService.getUniqueOffersFromOrder(Mockito.<Order>any())).thenReturn(new HashSet<>());

    OfferCodeImpl offerCodeImpl = mock(OfferCodeImpl.class);
    when(offerCodeImpl.getMaxUses()).thenReturn(3);
    when(offerCodeImpl.getId()).thenReturn(1L);
    when(offerCodeImpl.getOfferCode()).thenReturn("Offer Code");
    when(offerCodeImpl.isLimitedUse()).thenReturn(true);

    ArrayList<OfferCode> offerCodeList = new ArrayList<>();
    offerCodeList.add(offerCodeImpl);

    Order order = mock(Order.class);
    when(order.getAddedOfferCodes()).thenReturn(offerCodeList);
    CheckoutSeed checkoutSeed = new CheckoutSeed(order, new HashMap<>());

    DefaultProcessContextImpl<CheckoutSeed> context = new DefaultProcessContextImpl<>();
    context.setSeedData(checkoutSeed);

    // Act and Assert
    assertThrows(
        OfferMaxUseExceededException.class,
        () -> verifyCustomerMaxOfferUsesActivity.execute(context));
    verify(offerCodeImpl).getId();
    verify(offerCodeImpl).getMaxUses();
    verify(offerCodeImpl).getOfferCode();
    verify(offerCodeImpl).isLimitedUse();
    verify(offerAuditService).countOfferCodeUses(isA(Order.class), eq(1L));
    verify(offerService).getUniqueOffersFromOrder(isA(Order.class));
    verify(order).getAddedOfferCodes();
  }

  /**
   * Test {@link VerifyCustomerMaxOfferUsesActivity#execute(ProcessContext)}.
   *
   * <ul>
   *   <li>Given {@link OfferImpl} {@link OfferImpl#getMaxUsesStrategyType()} return {@link
   *       CustomerMaxUsesStrategyType#ACCOUNT}.
   * </ul>
   *
   * <p>Method under test: {@link VerifyCustomerMaxOfferUsesActivity#execute(ProcessContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ProcessContext VerifyCustomerMaxOfferUsesActivity.execute(ProcessContext)"})
  public void testExecute_givenOfferImplGetMaxUsesStrategyTypeReturnAccount() throws Exception {
    // Arrange
    when(offerAuditService.countUsesByAccount(
            Mockito.<Order>any(), Mockito.<Long>any(), Mockito.<Long>any(), Mockito.<Long>any()))
        .thenReturn(3L);

    OfferImpl offerImpl = mock(OfferImpl.class);
    when(offerImpl.getId()).thenReturn(1L);
    when(offerImpl.getMaxUsesPerCustomer()).thenReturn(1L);
    when(offerImpl.getMinimumDaysPerUsage()).thenReturn(1L);
    when(offerImpl.getMaxUsesStrategyType()).thenReturn(CustomerMaxUsesStrategyType.ACCOUNT);
    when(offerImpl.isLimitedUsePerCustomer()).thenReturn(true);
    doNothing().when(offerImpl).setMaxUsesPerCustomer(Mockito.<Long>any());
    offerImpl.setMaxUsesPerCustomer(OfferImpl.serialVersionUID);

    HashSet<Offer> offerSet = new HashSet<>();
    offerSet.add(offerImpl);
    when(offerService.getUniqueOffersFromOrder(Mockito.<Order>any())).thenReturn(offerSet);

    Order order = mock(Order.class);
    when(order.getBroadleafAccountId()).thenReturn(1L);
    CheckoutSeed checkoutSeed = new CheckoutSeed(order, new HashMap<>());

    DefaultProcessContextImpl<CheckoutSeed> context = new DefaultProcessContextImpl<>();
    context.setSeedData(checkoutSeed);

    // Act and Assert
    assertThrows(
        OfferMaxUseExceededException.class,
        () -> verifyCustomerMaxOfferUsesActivity.execute(context));
    verify(offerImpl).getId();
    verify(offerImpl).getMaxUsesPerCustomer();
    verify(offerImpl).getMaxUsesStrategyType();
    verify(offerImpl).getMinimumDaysPerUsage();
    verify(offerImpl).isLimitedUsePerCustomer();
    verify(offerImpl).setMaxUsesPerCustomer(1L);
    verify(offerAuditService).countUsesByAccount(isA(Order.class), eq(1L), eq(1L), eq(1L));
    verify(offerService).getUniqueOffersFromOrder(isA(Order.class));
    verify(order).getBroadleafAccountId();
  }

  /**
   * Test {@link VerifyCustomerMaxOfferUsesActivity#execute(ProcessContext)}.
   *
   * <ul>
   *   <li>Given {@link Order} {@link Order#getCustomer()} return {@link CustomerImpl} (default
   *       constructor).
   *   <li>Then calls {@link OfferAuditService#countUsesByCustomer(Order, Long, Long, Long)}.
   * </ul>
   *
   * <p>Method under test: {@link VerifyCustomerMaxOfferUsesActivity#execute(ProcessContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ProcessContext VerifyCustomerMaxOfferUsesActivity.execute(ProcessContext)"})
  public void testExecute_givenOrderGetCustomerReturnCustomerImpl_thenCallsCountUsesByCustomer()
      throws Exception {
    // Arrange
    when(offerAuditService.countUsesByCustomer(
            Mockito.<Order>any(), Mockito.<Long>any(), Mockito.<Long>any(), Mockito.<Long>any()))
        .thenReturn(3L);

    OfferImpl offerImpl = mock(OfferImpl.class);
    when(offerImpl.getId()).thenReturn(1L);
    when(offerImpl.getMaxUsesPerCustomer()).thenReturn(1L);
    when(offerImpl.getMinimumDaysPerUsage()).thenReturn(1L);
    when(offerImpl.getMaxUsesStrategyType()).thenReturn(CustomerMaxUsesStrategyType.CUSTOMER);
    when(offerImpl.isLimitedUsePerCustomer()).thenReturn(true);
    doNothing().when(offerImpl).setMaxUsesPerCustomer(Mockito.<Long>any());
    offerImpl.setMaxUsesPerCustomer(OfferImpl.serialVersionUID);

    HashSet<Offer> offerSet = new HashSet<>();
    offerSet.add(offerImpl);
    when(offerService.getUniqueOffersFromOrder(Mockito.<Order>any())).thenReturn(offerSet);

    Order order = mock(Order.class);
    when(order.getCustomer()).thenReturn(new CustomerImpl());
    CheckoutSeed checkoutSeed = new CheckoutSeed(order, new HashMap<>());

    DefaultProcessContextImpl<CheckoutSeed> context = new DefaultProcessContextImpl<>();
    context.setSeedData(checkoutSeed);

    // Act and Assert
    assertThrows(
        OfferMaxUseExceededException.class,
        () -> verifyCustomerMaxOfferUsesActivity.execute(context));
    verify(offerImpl).getId();
    verify(offerImpl).getMaxUsesPerCustomer();
    verify(offerImpl).getMaxUsesStrategyType();
    verify(offerImpl).getMinimumDaysPerUsage();
    verify(offerImpl).isLimitedUsePerCustomer();
    verify(offerImpl).setMaxUsesPerCustomer(1L);
    verify(offerAuditService).countUsesByCustomer(isA(Order.class), isNull(), eq(1L), eq(1L));
    verify(offerService).getUniqueOffersFromOrder(isA(Order.class));
    verify(order).getCustomer();
  }

  /**
   * Test {@link VerifyCustomerMaxOfferUsesActivity#execute(ProcessContext)}.
   *
   * <ul>
   *   <li>Then calls {@link CheckoutSeed#getOrder()}.
   * </ul>
   *
   * <p>Method under test: {@link VerifyCustomerMaxOfferUsesActivity#execute(ProcessContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ProcessContext VerifyCustomerMaxOfferUsesActivity.execute(ProcessContext)"})
  public void testExecute_thenCallsGetOrder() throws Exception {
    // Arrange
    when(offerAuditService.countUsesByAccount(
            Mockito.<Order>any(), Mockito.<Long>any(), Mockito.<Long>any(), Mockito.<Long>any()))
        .thenReturn(3L);

    OfferImpl offerImpl = mock(OfferImpl.class);
    when(offerImpl.getId()).thenReturn(1L);
    when(offerImpl.getMaxUsesPerCustomer()).thenReturn(1L);
    when(offerImpl.getMinimumDaysPerUsage()).thenReturn(1L);
    when(offerImpl.getMaxUsesStrategyType()).thenReturn(mock(CustomerMaxUsesStrategyType.class));
    when(offerImpl.isLimitedUsePerCustomer()).thenReturn(true);
    doNothing().when(offerImpl).setMaxUsesPerCustomer(Mockito.<Long>any());
    offerImpl.setMaxUsesPerCustomer(OfferImpl.serialVersionUID);

    HashSet<Offer> offerSet = new HashSet<>();
    offerSet.add(offerImpl);
    when(offerService.getUniqueOffersFromOrder(Mockito.<Order>any())).thenReturn(offerSet);

    CheckoutSeed checkoutSeed = mock(CheckoutSeed.class);
    when(checkoutSeed.getOrder()).thenReturn(new NullOrderImpl());

    DefaultProcessContextImpl<CheckoutSeed> context = new DefaultProcessContextImpl<>();
    context.setSeedData(checkoutSeed);

    // Act and Assert
    assertThrows(
        OfferMaxUseExceededException.class,
        () -> verifyCustomerMaxOfferUsesActivity.execute(context));
    verify(checkoutSeed).getOrder();
    verify(offerImpl).getId();
    verify(offerImpl).getMaxUsesPerCustomer();
    verify(offerImpl).getMaxUsesStrategyType();
    verify(offerImpl).getMinimumDaysPerUsage();
    verify(offerImpl).isLimitedUsePerCustomer();
    verify(offerImpl).setMaxUsesPerCustomer(1L);
    verify(offerAuditService).countUsesByAccount(isA(Order.class), isNull(), eq(1L), eq(1L));
    verify(offerService).getUniqueOffersFromOrder(isA(Order.class));
  }

  /**
   * Test {@link VerifyCustomerMaxOfferUsesActivity#execute(ProcessContext)}.
   *
   * <ul>
   *   <li>Then return {@link DefaultProcessContextImpl}.
   * </ul>
   *
   * <p>Method under test: {@link VerifyCustomerMaxOfferUsesActivity#execute(ProcessContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ProcessContext VerifyCustomerMaxOfferUsesActivity.execute(ProcessContext)"})
  public void testExecute_thenReturnDefaultProcessContextImpl() throws Exception {
    // Arrange
    when(offerService.getUniqueOffersFromOrder(Mockito.<Order>any())).thenReturn(new HashSet<>());

    DefaultProcessContextImpl<CheckoutSeed> context = new DefaultProcessContextImpl<>();
    OrderImpl order = new OrderImpl();
    CheckoutSeed checkoutSeed = new CheckoutSeed(order, new HashMap<>());
    context.setSeedData(checkoutSeed);

    // Act
    ProcessContext<CheckoutSeed> actualExecuteResult =
        verifyCustomerMaxOfferUsesActivity.execute(context);

    // Assert
    verify(offerService).getUniqueOffersFromOrder(isA(Order.class));
    assertTrue(actualExecuteResult instanceof DefaultProcessContextImpl);
    assertSame(checkoutSeed, actualExecuteResult.getSeedData());
  }
}
