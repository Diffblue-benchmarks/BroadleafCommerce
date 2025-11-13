package org.broadleafcommerce.common.exception;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.common.vendor.service.exception.PaymentException;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class BroadleafExceptionDiffblueTest {
  /**
   * Test {@link BroadleafException#getRootCause()}.
   *
   * <p>Method under test: {@link BroadleafException#getRootCause()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Throwable BroadleafException.getRootCause()"})
  public void testGetRootCause() {
    // Arrange
    PaymentException paymentException = new PaymentException("An error occurred");

    // Act
    Throwable actualRootCause = paymentException.getRootCause();

    // Assert
    assertSame(paymentException, actualRootCause);
  }

  /**
   * Test {@link BroadleafException#getRootCauseMessage()}.
   *
   * <ul>
   *   <li>Given {@link PaymentException#PaymentException()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafException#getRootCauseMessage()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String BroadleafException.getRootCauseMessage()"})
  public void testGetRootCauseMessage_givenPaymentException_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new PaymentException().getRootCauseMessage());
  }

  /**
   * Test {@link BroadleafException#getRootCauseMessage()}.
   *
   * <ul>
   *   <li>Then return {@code An error occurred}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafException#getRootCauseMessage()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String BroadleafException.getRootCauseMessage()"})
  public void testGetRootCauseMessage_thenReturnAnErrorOccurred() {
    // Arrange, Act and Assert
    assertEquals(
        "An error occurred", new PaymentException("An error occurred").getRootCauseMessage());
  }
}
