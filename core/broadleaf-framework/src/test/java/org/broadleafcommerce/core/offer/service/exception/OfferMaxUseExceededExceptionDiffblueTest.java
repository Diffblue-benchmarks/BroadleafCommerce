package org.broadleafcommerce.core.offer.service.exception;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {OfferMaxUseExceededException.class, String.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class OfferMaxUseExceededExceptionDiffblueTest {
  @Autowired
  private OfferMaxUseExceededException offerMaxUseExceededException;

  /**
   * Test
   * {@link OfferMaxUseExceededException#OfferMaxUseExceededException(String)}.
   * <p>
   * Method under test:
   * {@link OfferMaxUseExceededException#OfferMaxUseExceededException(String)}
   */
  @Test
  public void testNewOfferMaxUseExceededException() {
    // Arrange and Act
    OfferMaxUseExceededException actualOfferMaxUseExceededException = new OfferMaxUseExceededException("String");

    // Assert
    assertEquals("String", actualOfferMaxUseExceededException.getLocalizedMessage());
    assertEquals("String", actualOfferMaxUseExceededException.getMessage());
    assertEquals("String", actualOfferMaxUseExceededException.getRootCauseMessage());
    assertNull(actualOfferMaxUseExceededException.getCause());
    assertNull(actualOfferMaxUseExceededException.getCheckoutResponse());
    assertEquals(0, actualOfferMaxUseExceededException.getSuppressed().length);
    assertSame(actualOfferMaxUseExceededException, actualOfferMaxUseExceededException.getRootCause());
  }
}
