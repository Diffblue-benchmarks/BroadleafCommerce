package org.broadleafcommerce.common.vendor.service.exception;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class PaymentExceptionDiffblueTest {
  /**
   * Test {@link PaymentException#PaymentException()}.
   *
   * <p>Method under test: {@link PaymentException#PaymentException()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void PaymentException.<init>()"})
  public void testNewPaymentException() {
    // Arrange and Act
    PaymentException actualPaymentException = new PaymentException();

    // Assert
    assertNull(actualPaymentException.getMessage());
    assertNull(actualPaymentException.getCause());
    assertNull(actualPaymentException.getRootCause());
    assertEquals(0, actualPaymentException.getSuppressed().length);
  }
}
