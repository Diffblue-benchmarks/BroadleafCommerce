package org.broadleafcommerce.core.checkout.service.exception;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.core.checkout.service.workflow.CheckoutResponse;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class CheckoutExceptionDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CheckoutException#CheckoutException()}
   *   <li>{@link CheckoutException#setCheckoutResponse(CheckoutResponse)}
   *   <li>{@link CheckoutException#getCheckoutResponse()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CheckoutException.<init>()",
    "CheckoutResponse CheckoutException.getCheckoutResponse()",
    "void CheckoutException.setCheckoutResponse(CheckoutResponse)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    CheckoutException actualCheckoutException = new CheckoutException();
    CheckoutResponse checkoutResponse = mock(CheckoutResponse.class);
    actualCheckoutException.setCheckoutResponse(checkoutResponse);
    CheckoutResponse actualCheckoutResponse = actualCheckoutException.getCheckoutResponse();

    // Assert
    assertNull(actualCheckoutException.getMessage());
    assertNull(actualCheckoutException.getCause());
    assertNull(actualCheckoutException.getRootCause());
    assertEquals(0, actualCheckoutException.getSuppressed().length);
    assertSame(checkoutResponse, actualCheckoutResponse);
  }
}
