package org.broadleafcommerce.core.offer.service.exception;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class OfferExceptionDiffblueTest {
  /**
   * Test {@link OfferException#OfferException()}.
   *
   * <p>Method under test: {@link OfferException#OfferException()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void OfferException.<init>()"})
  public void testNewOfferException() {
    // Arrange and Act
    OfferException actualOfferException = new OfferException();

    // Assert
    assertNull(actualOfferException.getMessage());
    assertNull(actualOfferException.getCause());
    assertNull(actualOfferException.getRootCause());
    assertNull(actualOfferException.getCheckoutResponse());
    assertEquals(0, actualOfferException.getSuppressed().length);
  }
}
