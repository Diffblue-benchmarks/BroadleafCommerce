package org.broadleafcommerce.core.web.controller.catalog;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.core.catalog.domain.Product;
import org.broadleafcommerce.core.catalog.domain.ProductBundleImpl;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class ReviewFormDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ReviewForm.<init>()",
    "Product ReviewForm.getProduct()",
    "Double ReviewForm.getRating()",
    "String ReviewForm.getReviewText()",
    "void ReviewForm.setProduct(Product)",
    "void ReviewForm.setRating(Double)",
    "void ReviewForm.setReviewText(String)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    ReviewForm actualReviewForm = new ReviewForm();
    ProductBundleImpl product = new ProductBundleImpl();
    actualReviewForm.setProduct(product);
    actualReviewForm.setRating(10.0d);
    actualReviewForm.setReviewText("Review Text");
    Product actualProduct = actualReviewForm.getProduct();
    Double actualRating = actualReviewForm.getRating();

    // Assert
    assertEquals("Review Text", actualReviewForm.getReviewText());
    assertEquals(10.0d, actualRating.doubleValue(), 0.0);
    assertSame(product, actualProduct);
  }
}
