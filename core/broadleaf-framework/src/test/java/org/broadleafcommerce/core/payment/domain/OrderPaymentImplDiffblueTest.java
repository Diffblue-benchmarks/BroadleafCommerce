package org.broadleafcommerce.core.payment.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.common.payment.PaymentGatewayType;
import org.broadleafcommerce.common.payment.PaymentType;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.Order;
import org.broadleafcommerce.profile.core.domain.Address;
import org.broadleafcommerce.profile.core.domain.AddressImpl;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class OrderPaymentImplDiffblueTest {
  @Autowired private OrderPaymentImpl orderPaymentImpl;

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link OrderPaymentImpl#setBillingAddress(Address)}
   *   <li>{@link OrderPaymentImpl#setId(Long)}
   *   <li>{@link OrderPaymentImpl#setOrder(Order)}
   *   <li>{@link OrderPaymentImpl#setReferenceNumber(String)}
   *   <li>{@link OrderPaymentImpl#setTransactions(List)}
   *   <li>{@link OrderPaymentImpl#getBillingAddress()}
   *   <li>{@link OrderPaymentImpl#getId()}
   *   <li>{@link OrderPaymentImpl#getOrder()}
   *   <li>{@link OrderPaymentImpl#getReferenceNumber()}
   *   <li>{@link OrderPaymentImpl#getTransactions()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Address OrderPaymentImpl.getBillingAddress()",
    "Long OrderPaymentImpl.getId()",
    "Order OrderPaymentImpl.getOrder()",
    "String OrderPaymentImpl.getReferenceNumber()",
    "List OrderPaymentImpl.getTransactions()",
    "void OrderPaymentImpl.setBillingAddress(Address)",
    "void OrderPaymentImpl.setId(Long)",
    "void OrderPaymentImpl.setOrder(Order)",
    "void OrderPaymentImpl.setReferenceNumber(String)",
    "void OrderPaymentImpl.setTransactions(List)"
  })
  public void testGettersAndSetters() {
    // Arrange
    OrderPaymentImpl orderPaymentImpl = new OrderPaymentImpl();
    AddressImpl billingAddress = new AddressImpl();

    // Act
    orderPaymentImpl.setBillingAddress(billingAddress);
    orderPaymentImpl.setId(1L);
    NullOrderImpl order = new NullOrderImpl();
    orderPaymentImpl.setOrder(order);
    orderPaymentImpl.setReferenceNumber("42");
    ArrayList<PaymentTransaction> transactions = new ArrayList<>();
    orderPaymentImpl.setTransactions(transactions);
    Address actualBillingAddress = orderPaymentImpl.getBillingAddress();
    Long actualId = orderPaymentImpl.getId();
    Order actualOrder = orderPaymentImpl.getOrder();
    String actualReferenceNumber = orderPaymentImpl.getReferenceNumber();
    List<PaymentTransaction> actualTransactions = orderPaymentImpl.getTransactions();

    // Assert
    assertEquals("42", actualReferenceNumber);
    assertEquals(1L, actualId.longValue());
    assertSame(transactions, actualTransactions);
    assertSame(order, actualOrder);
    assertSame(billingAddress, actualBillingAddress);
  }

  /**
   * Test {@link OrderPaymentImpl#addTransaction(PaymentTransaction)}.
   *
   * <p>Method under test: {@link OrderPaymentImpl#addTransaction(PaymentTransaction)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void OrderPaymentImpl.addTransaction(PaymentTransaction)"})
  public void testAddTransaction() {
    // Arrange
    PaymentTransactionImpl transaction = new PaymentTransactionImpl();

    // Act
    orderPaymentImpl.addTransaction(transaction);

    // Assert
    List<PaymentTransaction> transactions = orderPaymentImpl.getTransactions();
    assertEquals(1, transactions.size());
    assertSame(transaction, transactions.get(0));
    assertSame(transaction, orderPaymentImpl.getInitialTransaction());
  }

  /**
   * Test {@link OrderPaymentImpl#equals(Object)}, and {@link OrderPaymentImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link OrderPaymentImpl#equals(Object)}
   *   <li>{@link OrderPaymentImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OrderPaymentImpl.equals(Object)", "int OrderPaymentImpl.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
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

    OrderPaymentImpl orderPaymentImpl2 = new OrderPaymentImpl();
    orderPaymentImpl2.setAmount(new Money());
    orderPaymentImpl2.setBillingAddress(new AddressImpl());
    orderPaymentImpl2.setId(1L);
    orderPaymentImpl2.setOrder(new NullOrderImpl());
    orderPaymentImpl2.setPaymentGatewayType(new PaymentGatewayType());
    orderPaymentImpl2.setReferenceNumber("42");
    orderPaymentImpl2.setTransactions(new ArrayList<>());
    orderPaymentImpl2.setType(new PaymentType());

    // Act and Assert
    assertEquals(orderPaymentImpl, orderPaymentImpl2);
    assertEquals(orderPaymentImpl.hashCode(), orderPaymentImpl2.hashCode());
  }

  /**
   * Test {@link OrderPaymentImpl#equals(Object)}, and {@link OrderPaymentImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link OrderPaymentImpl#equals(Object)}
   *   <li>{@link OrderPaymentImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OrderPaymentImpl.equals(Object)", "int OrderPaymentImpl.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
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

    // Act and Assert
    assertEquals(orderPaymentImpl, orderPaymentImpl);
    int expectedHashCodeResult = orderPaymentImpl.hashCode();
    assertEquals(expectedHashCodeResult, orderPaymentImpl.hashCode());
  }

  /**
   * Test {@link OrderPaymentImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OrderPaymentImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OrderPaymentImpl.equals(Object)", "int OrderPaymentImpl.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    OrderPaymentImpl orderPaymentImpl = new OrderPaymentImpl();
    orderPaymentImpl.setAmount(new Money());
    orderPaymentImpl.setBillingAddress(new AddressImpl());
    orderPaymentImpl.setId(2L);
    orderPaymentImpl.setOrder(new NullOrderImpl());
    orderPaymentImpl.setPaymentGatewayType(new PaymentGatewayType());
    orderPaymentImpl.setReferenceNumber("42");
    orderPaymentImpl.setTransactions(new ArrayList<>());
    orderPaymentImpl.setType(new PaymentType());

    OrderPaymentImpl orderPaymentImpl2 = new OrderPaymentImpl();
    orderPaymentImpl2.setAmount(new Money());
    orderPaymentImpl2.setBillingAddress(new AddressImpl());
    orderPaymentImpl2.setId(1L);
    orderPaymentImpl2.setOrder(new NullOrderImpl());
    orderPaymentImpl2.setPaymentGatewayType(new PaymentGatewayType());
    orderPaymentImpl2.setReferenceNumber("42");
    orderPaymentImpl2.setTransactions(new ArrayList<>());
    orderPaymentImpl2.setType(new PaymentType());

    // Act and Assert
    assertNotEquals(orderPaymentImpl, orderPaymentImpl2);
  }

  /**
   * Test {@link OrderPaymentImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OrderPaymentImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OrderPaymentImpl.equals(Object)", "int OrderPaymentImpl.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
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

    // Act and Assert
    assertNotEquals(orderPaymentImpl, null);
  }

  /**
   * Test {@link OrderPaymentImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OrderPaymentImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OrderPaymentImpl.equals(Object)", "int OrderPaymentImpl.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
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

    // Act and Assert
    assertNotEquals(orderPaymentImpl, "Different type to OrderPaymentImpl");
  }

  /**
   * Test new {@link OrderPaymentImpl} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link OrderPaymentImpl}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void OrderPaymentImpl.<init>()"})
  public void testNewOrderPaymentImpl() {
    // Arrange and Act
    OrderPaymentImpl actualOrderPaymentImpl = new OrderPaymentImpl();

    // Assert
    assertEquals('N', actualOrderPaymentImpl.getArchived().charValue());
    assertNull(actualOrderPaymentImpl.getId());
    assertNull(actualOrderPaymentImpl.getCurrencyCode());
    assertNull(actualOrderPaymentImpl.getReferenceNumber());
    assertNull(actualOrderPaymentImpl.gatewayType);
    assertNull(actualOrderPaymentImpl.type);
    assertNull(actualOrderPaymentImpl.amount);
    assertNull(actualOrderPaymentImpl.getCurrency());
    assertNull(actualOrderPaymentImpl.getAmount());
    assertNull(actualOrderPaymentImpl.getGatewayType());
    assertNull(actualOrderPaymentImpl.getType());
    assertNull(actualOrderPaymentImpl.getOrder());
    assertNull(actualOrderPaymentImpl.getAuthorizeTransaction());
    assertNull(actualOrderPaymentImpl.getInitialTransaction());
    assertNull(actualOrderPaymentImpl.getStatus());
    assertNull(actualOrderPaymentImpl.getBillingAddress());
    assertTrue(actualOrderPaymentImpl.getTransactions().isEmpty());
  }
}
