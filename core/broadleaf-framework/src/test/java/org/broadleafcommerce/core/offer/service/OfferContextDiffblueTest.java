package org.broadleafcommerce.core.offer.service;

import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class OfferContextDiffblueTest {
  /**
   * Test {@link OfferContext#getOfferContext()}.
   * <p>
   * Method under test: {@link OfferContext#getOfferContext()}
   */
  @Test
  public void testGetOfferContext() {
    // Arrange, Act and Assert
    assertTrue(OfferContext.getOfferContext().getExecutePromotionCalculation());
  }

  /**
   * Test {@link OfferContext#setOfferContext(OfferContext)}.
   * <p>
   * Method under test: {@link OfferContext#setOfferContext(OfferContext)}
   */
  @Test
  public void testSetOfferContext() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange
    OfferContext offerContext = new OfferContext();
    offerContext.setExecutePromotionCalculation(true);

    // Act
    OfferContext.setOfferContext(offerContext);
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link OfferContext}
   *   <li>{@link OfferContext#setExecutePromotionCalculation(Boolean)}
   *   <li>{@link OfferContext#getExecutePromotionCalculation()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    OfferContext actualOfferContext = new OfferContext();
    actualOfferContext.setExecutePromotionCalculation(true);

    // Assert that nothing has changed
    assertTrue(actualOfferContext.getExecutePromotionCalculation());
  }
}
