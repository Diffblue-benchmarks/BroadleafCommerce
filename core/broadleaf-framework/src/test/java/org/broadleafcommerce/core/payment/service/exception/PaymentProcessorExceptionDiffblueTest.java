package org.broadleafcommerce.core.payment.service.exception;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.core.payment.domain.PaymentResponseItem;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class PaymentProcessorExceptionDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@code An error occurred}.
   *   <li>Then return Message is {@code An error occurred}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PaymentProcessorException#PaymentProcessorException(String, Throwable,
   *       PaymentResponseItem)}
   *   <li>{@link PaymentProcessorException#getPaymentResponseItem()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PaymentProcessorException.<init>(String, Throwable, PaymentResponseItem)",
    "void PaymentProcessorException.<init>(String, PaymentResponseItem)",
    "void PaymentProcessorException.<init>(Throwable, PaymentResponseItem)",
    "void PaymentProcessorException.<init>(PaymentResponseItem)",
    "PaymentResponseItem PaymentProcessorException.getPaymentResponseItem()"
  })
  public void testGettersAndSetters_whenAnErrorOccurred_thenReturnMessageIsAnErrorOccurred() {
    // Arrange
    Throwable cause = new Throwable();
    PaymentResponseItem paymentResponseItem = mock(PaymentResponseItem.class);

    // Act
    PaymentProcessorException actualPaymentProcessorException =
        new PaymentProcessorException("An error occurred", cause, paymentResponseItem);
    PaymentResponseItem actualPaymentResponseItem =
        actualPaymentProcessorException.getPaymentResponseItem();

    // Assert
    assertEquals("An error occurred", actualPaymentProcessorException.getMessage());
    assertEquals(0, actualPaymentProcessorException.getSuppressed().length);
    assertSame(cause, actualPaymentProcessorException.getCause());
    assertSame(paymentResponseItem, actualPaymentResponseItem);
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@code An error occurred}.
   *   <li>Then return Message is {@code An error occurred}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PaymentProcessorException#PaymentProcessorException(String, PaymentResponseItem)}
   *   <li>{@link PaymentProcessorException#getPaymentResponseItem()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PaymentProcessorException.<init>(String, Throwable, PaymentResponseItem)",
    "void PaymentProcessorException.<init>(String, PaymentResponseItem)",
    "void PaymentProcessorException.<init>(Throwable, PaymentResponseItem)",
    "void PaymentProcessorException.<init>(PaymentResponseItem)",
    "PaymentResponseItem PaymentProcessorException.getPaymentResponseItem()"
  })
  public void testGettersAndSetters_whenAnErrorOccurred_thenReturnMessageIsAnErrorOccurred2() {
    // Arrange
    PaymentResponseItem paymentResponseItem = mock(PaymentResponseItem.class);

    // Act
    PaymentProcessorException actualPaymentProcessorException =
        new PaymentProcessorException("An error occurred", paymentResponseItem);
    PaymentResponseItem actualPaymentResponseItem =
        actualPaymentProcessorException.getPaymentResponseItem();

    // Assert
    assertEquals("An error occurred", actualPaymentProcessorException.getMessage());
    assertNull(actualPaymentProcessorException.getCause());
    assertEquals(0, actualPaymentProcessorException.getSuppressed().length);
    assertSame(paymentResponseItem, actualPaymentResponseItem);
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@link PaymentResponseItem}.
   *   <li>Then return Message is {@code null}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PaymentProcessorException#PaymentProcessorException(PaymentResponseItem)}
   *   <li>{@link PaymentProcessorException#getPaymentResponseItem()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PaymentProcessorException.<init>(String, Throwable, PaymentResponseItem)",
    "void PaymentProcessorException.<init>(String, PaymentResponseItem)",
    "void PaymentProcessorException.<init>(Throwable, PaymentResponseItem)",
    "void PaymentProcessorException.<init>(PaymentResponseItem)",
    "PaymentResponseItem PaymentProcessorException.getPaymentResponseItem()"
  })
  public void testGettersAndSetters_whenPaymentResponseItem_thenReturnMessageIsNull() {
    // Arrange
    PaymentResponseItem paymentResponseItem = mock(PaymentResponseItem.class);

    // Act
    PaymentProcessorException actualPaymentProcessorException =
        new PaymentProcessorException(paymentResponseItem);
    PaymentResponseItem actualPaymentResponseItem =
        actualPaymentProcessorException.getPaymentResponseItem();

    // Assert
    assertNull(actualPaymentProcessorException.getMessage());
    assertNull(actualPaymentProcessorException.getCause());
    assertEquals(0, actualPaymentProcessorException.getSuppressed().length);
    assertSame(paymentResponseItem, actualPaymentResponseItem);
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@link Throwable#Throwable()}.
   *   <li>Then return Message is {@code Throwable}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PaymentProcessorException#PaymentProcessorException(Throwable,
   *       PaymentResponseItem)}
   *   <li>{@link PaymentProcessorException#getPaymentResponseItem()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PaymentProcessorException.<init>(String, Throwable, PaymentResponseItem)",
    "void PaymentProcessorException.<init>(String, PaymentResponseItem)",
    "void PaymentProcessorException.<init>(Throwable, PaymentResponseItem)",
    "void PaymentProcessorException.<init>(PaymentResponseItem)",
    "PaymentResponseItem PaymentProcessorException.getPaymentResponseItem()"
  })
  public void testGettersAndSetters_whenThrowable_thenReturnMessageIsJavaLangThrowable() {
    // Arrange
    Throwable cause = new Throwable();
    PaymentResponseItem paymentResponseItem = mock(PaymentResponseItem.class);

    // Act
    PaymentProcessorException actualPaymentProcessorException =
        new PaymentProcessorException(cause, paymentResponseItem);
    PaymentResponseItem actualPaymentResponseItem =
        actualPaymentProcessorException.getPaymentResponseItem();

    // Assert
    assertEquals("java.lang.Throwable", actualPaymentProcessorException.getMessage());
    assertEquals(0, actualPaymentProcessorException.getSuppressed().length);
    assertSame(cause, actualPaymentProcessorException.getCause());
    assertSame(paymentResponseItem, actualPaymentResponseItem);
  }
}
