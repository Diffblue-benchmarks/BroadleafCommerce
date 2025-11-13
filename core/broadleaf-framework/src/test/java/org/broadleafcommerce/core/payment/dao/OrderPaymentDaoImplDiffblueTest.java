package org.broadleafcommerce.core.payment.dao;

import static org.junit.Assert.assertSame;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.common.payment.PaymentGatewayType;
import org.broadleafcommerce.common.payment.PaymentType;
import org.broadleafcommerce.common.persistence.EntityConfiguration;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.payment.domain.OrderPayment;
import org.broadleafcommerce.core.payment.domain.OrderPaymentImpl;
import org.broadleafcommerce.core.payment.domain.PaymentLog;
import org.broadleafcommerce.core.payment.domain.PaymentLogImpl;
import org.broadleafcommerce.core.payment.domain.PaymentTransaction;
import org.broadleafcommerce.core.payment.domain.PaymentTransactionImpl;
import org.broadleafcommerce.profile.core.domain.AddressImpl;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class OrderPaymentDaoImplDiffblueTest {
  @Mock private EntityConfiguration entityConfiguration;

  @InjectMocks private OrderPaymentDaoImpl orderPaymentDaoImpl;

  /**
   * Test {@link OrderPaymentDaoImpl#create()}.
   *
   * <p>Method under test: {@link OrderPaymentDaoImpl#create()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"OrderPayment OrderPaymentDaoImpl.create()"})
  public void testCreate() {
    // Arrange
    OrderPaymentImpl orderPaymentImpl = new OrderPaymentImpl();
    orderPaymentImpl.setAmount(new Money());
    orderPaymentImpl.setBillingAddress(new AddressImpl());
    orderPaymentImpl.setId(1L);
    orderPaymentImpl.setOrder(new NullOrderImpl());
    orderPaymentImpl.setPaymentGatewayType(new PaymentGatewayType());
    orderPaymentImpl.setReferenceNumber("42");
    orderPaymentImpl.setTransactions(new ArrayList<>());
    orderPaymentImpl.setType(new PaymentType());
    when(entityConfiguration.createEntityInstance(Mockito.<String>any()))
        .thenReturn(orderPaymentImpl);

    // Act
    OrderPayment actualCreateResult = orderPaymentDaoImpl.create();

    // Assert
    verify(entityConfiguration)
        .createEntityInstance("org.broadleafcommerce.core.payment.domain.OrderPayment");
    assertSame(orderPaymentImpl, actualCreateResult);
  }

  /**
   * Test {@link OrderPaymentDaoImpl#createTransaction()}.
   *
   * <p>Method under test: {@link OrderPaymentDaoImpl#createTransaction()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PaymentTransaction OrderPaymentDaoImpl.createTransaction()"})
  public void testCreateTransaction() {
    // Arrange
    PaymentTransactionImpl paymentTransactionImpl = new PaymentTransactionImpl();
    when(entityConfiguration.createEntityInstance(
            Mockito.<String>any(), eq(PaymentTransaction.class)))
        .thenReturn(paymentTransactionImpl);

    // Act
    PaymentTransaction actualCreateTransactionResult = orderPaymentDaoImpl.createTransaction();

    // Assert
    verify(entityConfiguration)
        .createEntityInstance(
            eq("org.broadleafcommerce.core.payment.domain.PaymentTransaction"), isA(Class.class));
    assertSame(paymentTransactionImpl, actualCreateTransactionResult);
  }

  /**
   * Test {@link OrderPaymentDaoImpl#createLog()}.
   *
   * <p>Method under test: {@link OrderPaymentDaoImpl#createLog()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PaymentLog OrderPaymentDaoImpl.createLog()"})
  public void testCreateLog() {
    // Arrange
    PaymentLogImpl paymentLogImpl = new PaymentLogImpl();
    when(entityConfiguration.createEntityInstance(Mockito.<String>any(), eq(PaymentLog.class)))
        .thenReturn(paymentLogImpl);

    // Act
    PaymentLog actualCreateLogResult = orderPaymentDaoImpl.createLog();

    // Assert
    verify(entityConfiguration)
        .createEntityInstance(
            eq("org.broadleafcommerce.core.payment.domain.PaymentLog"), isA(Class.class));
    assertSame(paymentLogImpl, actualCreateLogResult);
  }
}
