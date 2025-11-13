package org.broadleafcommerce.profile.web.core.expression;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.broadleafcommerce.profile.core.domain.CustomerPayment;
import org.broadleafcommerce.profile.core.domain.CustomerPaymentImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class CustomerVariableExpressionDiffblueTest {
  /**
   * Test {@link CustomerVariableExpression#getName()}.
   *
   * <p>Method under test: {@link CustomerVariableExpression#getName()}
   */
  @Test
  @DisplayName("Test getName()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String CustomerVariableExpression.getName()"})
  void testGetName() {
    // Arrange, Act and Assert
    assertEquals("customer", new CustomerVariableExpression().getName());
  }

  /**
   * Test {@link CustomerVariableExpression#getCurrent()}.
   *
   * <p>Method under test: {@link CustomerVariableExpression#getCurrent()}
   */
  @Test
  @DisplayName("Test getCurrent()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.broadleafcommerce.profile.core.domain.Customer CustomerVariableExpression.getCurrent()"
  })
  void testGetCurrent() {
    // Arrange, Act and Assert
    assertNull(new CustomerVariableExpression().getCurrent());
  }

  /**
   * Test {@link CustomerVariableExpression#sortCustomerPaymentsByDefault(List)}.
   *
   * <ul>
   *   <li>Given {@link CustomerPaymentImpl}.
   *   <li>Then calls {@link CustomerPaymentImpl#isDefault()}.
   * </ul>
   *
   * <p>Method under test: {@link CustomerVariableExpression#sortCustomerPaymentsByDefault(List)}
   */
  @Test
  @DisplayName(
      "Test sortCustomerPaymentsByDefault(List); given CustomerPaymentImpl; then calls isDefault()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CustomerVariableExpression.sortCustomerPaymentsByDefault(List)"})
  void testSortCustomerPaymentsByDefault_givenCustomerPaymentImpl_thenCallsIsDefault() {
    // Arrange
    CustomerVariableExpression customerVariableExpression = new CustomerVariableExpression();

    CustomerPaymentImpl customerPaymentImpl = mock(CustomerPaymentImpl.class);
    when(customerPaymentImpl.isDefault()).thenReturn(true);

    ArrayList<CustomerPayment> savedPayments = new ArrayList<>();
    savedPayments.add(mock(CustomerPaymentImpl.class));
    savedPayments.add(customerPaymentImpl);

    // Act
    customerVariableExpression.sortCustomerPaymentsByDefault(savedPayments);

    // Assert
    verify(customerPaymentImpl).isDefault();
  }

  /**
   * Test {@link CustomerVariableExpression#sortCustomerPaymentsByDefault(List)}.
   *
   * <ul>
   *   <li>Then calls {@link CustomerPaymentImpl#isDefault()}.
   * </ul>
   *
   * <p>Method under test: {@link CustomerVariableExpression#sortCustomerPaymentsByDefault(List)}
   */
  @Test
  @DisplayName("Test sortCustomerPaymentsByDefault(List); then calls isDefault()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CustomerVariableExpression.sortCustomerPaymentsByDefault(List)"})
  void testSortCustomerPaymentsByDefault_thenCallsIsDefault() {
    // Arrange
    CustomerVariableExpression customerVariableExpression = new CustomerVariableExpression();

    CustomerPaymentImpl customerPaymentImpl = mock(CustomerPaymentImpl.class);
    when(customerPaymentImpl.isDefault()).thenReturn(true);

    ArrayList<CustomerPayment> savedPayments = new ArrayList<>();
    savedPayments.add(customerPaymentImpl);
    savedPayments.add(new CustomerPaymentImpl());

    // Act
    customerVariableExpression.sortCustomerPaymentsByDefault(savedPayments);

    // Assert
    verify(customerPaymentImpl).isDefault();
  }
}
