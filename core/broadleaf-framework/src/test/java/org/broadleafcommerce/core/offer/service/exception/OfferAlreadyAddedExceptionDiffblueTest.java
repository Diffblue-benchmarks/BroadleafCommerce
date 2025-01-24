package org.broadleafcommerce.core.offer.service.exception;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {OfferAlreadyAddedException.class, String.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class OfferAlreadyAddedExceptionDiffblueTest {
  @Autowired
  private OfferAlreadyAddedException offerAlreadyAddedException;

  /**
   * Test {@link OfferAlreadyAddedException#OfferAlreadyAddedException(String)}.
   * <p>
   * Method under test:
   * {@link OfferAlreadyAddedException#OfferAlreadyAddedException(String)}
   */
  @Test
  public void testNewOfferAlreadyAddedException() {
    // Arrange and Act
    OfferAlreadyAddedException actualOfferAlreadyAddedException = new OfferAlreadyAddedException("String");

    // Assert
    assertEquals("String", actualOfferAlreadyAddedException.getLocalizedMessage());
    assertEquals("String", actualOfferAlreadyAddedException.getMessage());
    assertEquals("String", actualOfferAlreadyAddedException.getRootCauseMessage());
    assertNull(actualOfferAlreadyAddedException.getCause());
    assertNull(actualOfferAlreadyAddedException.getCheckoutResponse());
    assertEquals(0, actualOfferAlreadyAddedException.getSuppressed().length);
    assertSame(actualOfferAlreadyAddedException, actualOfferAlreadyAddedException.getRootCause());
  }
}
