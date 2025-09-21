/*-
 * #%L
 * BroadleafCommerce Framework Web
 * %%
 * Copyright (C) 2009 - 2025 Broadleaf Commerce
 * %%
 * Licensed under the Broadleaf Fair Use License Agreement, Version 1.0
 * (the "Fair Use License" located  at http://license.broadleafcommerce.org/fair_use_license-1.0.txt)
 * unless the restrictions on use therein are violated and require payment to Broadleaf in which case
 * the Broadleaf End User License Agreement (EULA), Version 1.1
 * (the "Commercial License" located at http://license.broadleafcommerce.org/commercial_license-1.1.txt)
 * shall apply.
 * 
 * Alternatively, the Commercial License may be replaced with a mutually agreed upon license (the "Custom License")
 * between you and Broadleaf Commerce. You may not use this file except in compliance with the applicable license.
 * #L%
 */
package org.broadleafcommerce.core.web.controller.catalog;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.core.catalog.domain.Product;
import org.broadleafcommerce.core.catalog.domain.ProductBundleImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ReviewFormDiffblueTest {
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
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
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
  void testGettersAndSetters() {
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
    assertEquals(10.0d, actualRating.doubleValue());
    assertSame(product, actualProduct);
  }
}
