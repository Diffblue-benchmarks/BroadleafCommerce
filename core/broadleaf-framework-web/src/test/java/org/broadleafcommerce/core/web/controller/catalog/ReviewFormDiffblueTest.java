package org.broadleafcommerce.core.web.controller.catalog;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import org.broadleafcommerce.core.catalog.domain.Product;
import org.broadleafcommerce.core.catalog.domain.ProductBundleImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ReviewFormDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link ReviewForm}
   *   <li>{@link ReviewForm#setProduct(Product)}
   *   <li>{@link ReviewForm#setRating(Double)}
   *   <li>{@link ReviewForm#setReviewText(String)}
   *   <li>{@link ReviewForm#getProduct()}
   *   <li>{@link ReviewForm#getRating()}
   *   <li>{@link ReviewForm#getReviewText()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange and Act
    ReviewForm actualReviewForm = new ReviewForm();
    ProductBundleImpl product = new ProductBundleImpl();
    actualReviewForm.setProduct(product);
    actualReviewForm.setRating(10.0d);
    actualReviewForm.setReviewText("Review Text");
    Product actualProduct = actualReviewForm.getProduct();
    Double actualRating = actualReviewForm.getRating();

    // Assert that nothing has changed
    assertEquals("Review Text", actualReviewForm.getReviewText());
    assertEquals(10.0d, actualRating.doubleValue());
    assertSame(product, actualProduct);
  }
}
