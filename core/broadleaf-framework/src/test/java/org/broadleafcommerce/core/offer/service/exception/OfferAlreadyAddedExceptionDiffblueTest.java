package org.broadleafcommerce.core.offer.service.exception;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class OfferAlreadyAddedExceptionDiffblueTest {
  /**
   * Test {@link OfferAlreadyAddedException#OfferAlreadyAddedException(String)}.
   *
   * <p>Method under test: {@link OfferAlreadyAddedException#OfferAlreadyAddedException(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void OfferAlreadyAddedException.<init>(String)"})
  public void testNewOfferAlreadyAddedException() {
    // Arrange and Act
    OfferAlreadyAddedException actualOfferAlreadyAddedException =
        new OfferAlreadyAddedException("String");

    // Assert
    assertEquals("String", actualOfferAlreadyAddedException.getMessage());
    assertNull(actualOfferAlreadyAddedException.getCause());
    assertNull(actualOfferAlreadyAddedException.getCheckoutResponse());
    assertEquals(0, actualOfferAlreadyAddedException.getSuppressed().length);
    Throwable actualRootCause = actualOfferAlreadyAddedException.getRootCause();
    assertSame(actualOfferAlreadyAddedException, actualRootCause);
  }
}
