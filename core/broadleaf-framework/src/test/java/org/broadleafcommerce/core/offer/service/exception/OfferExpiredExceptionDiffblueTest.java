package org.broadleafcommerce.core.offer.service.exception;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {OfferExpiredException.class, String.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class OfferExpiredExceptionDiffblueTest {
  @Autowired
  private OfferExpiredException offerExpiredException;

  /**
   * Test {@link OfferExpiredException#OfferExpiredException(String)}.
   * <p>
   * Method under test:
   * {@link OfferExpiredException#OfferExpiredException(String)}
   */
  @Test
  public void testNewOfferExpiredException() {
    // Arrange and Act
    OfferExpiredException actualOfferExpiredException = new OfferExpiredException("String");

    // Assert
    assertEquals("String", actualOfferExpiredException.getLocalizedMessage());
    assertEquals("String", actualOfferExpiredException.getMessage());
    assertEquals("String", actualOfferExpiredException.getRootCauseMessage());
    assertNull(actualOfferExpiredException.getCause());
    assertNull(actualOfferExpiredException.getCheckoutResponse());
    assertEquals(0, actualOfferExpiredException.getSuppressed().length);
    assertSame(actualOfferExpiredException, actualOfferExpiredException.getRootCause());
  }
}
