package org.broadleafcommerce.core.offer.service.exception;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {OfferExpiredException.class, String.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class OfferExpiredExceptionDiffblueTest {
  @Autowired private OfferExpiredException offerExpiredException;

  /**
   * Test {@link OfferExpiredException#OfferExpiredException(String)}.
   *
   * <p>Method under test: {@link OfferExpiredException#OfferExpiredException(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void OfferExpiredException.<init>(String)"})
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
    Throwable actualRootCause = actualOfferExpiredException.getRootCause();
    assertSame(actualOfferExpiredException, actualRootCause);
  }
}
