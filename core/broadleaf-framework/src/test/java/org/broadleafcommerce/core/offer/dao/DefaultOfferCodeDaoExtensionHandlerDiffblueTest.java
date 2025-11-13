package org.broadleafcommerce.core.offer.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class DefaultOfferCodeDaoExtensionHandlerDiffblueTest {
  /**
   * Test new {@link DefaultOfferCodeDaoExtensionHandler} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link
   * DefaultOfferCodeDaoExtensionHandler}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DefaultOfferCodeDaoExtensionHandler.<init>()"})
  public void testNewDefaultOfferCodeDaoExtensionHandler() {
    // Arrange and Act
    DefaultOfferCodeDaoExtensionHandler actualDefaultOfferCodeDaoExtensionHandler =
        new DefaultOfferCodeDaoExtensionHandler();

    // Assert
    assertEquals(0, actualDefaultOfferCodeDaoExtensionHandler.getPriority());
    assertTrue(actualDefaultOfferCodeDaoExtensionHandler.isEnabled());
  }
}
