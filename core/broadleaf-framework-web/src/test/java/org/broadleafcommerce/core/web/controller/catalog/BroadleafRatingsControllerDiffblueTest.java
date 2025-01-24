package org.broadleafcommerce.core.web.controller.catalog;

import static org.junit.jupiter.api.Assertions.assertEquals;
import javax.servlet.http.HttpServletRequest;
import org.broadleafcommerce.core.catalog.domain.ProductBundleImpl;
import org.broadleafcommerce.core.web.search.SearchRequestWrapper;
import org.broadleafcommerce.core.web.security.XssRequestWrapper;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.web.reactive.context.StandardReactiveWebEnvironment;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.ui.ConcurrentModel;
import org.springframework.ui.Model;

class BroadleafRatingsControllerDiffblueTest {
  /**
   * Test
   * {@link BroadleafRatingsController#viewReviewForm(HttpServletRequest, Model, ReviewForm, String)}.
   * <ul>
   *   <li>When {@link ConcurrentModel#ConcurrentModel()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BroadleafRatingsController#viewReviewForm(HttpServletRequest, Model, ReviewForm, String)}
   */
  @Test
  @DisplayName("Test viewReviewForm(HttpServletRequest, Model, ReviewForm, String); when ConcurrentModel()")
  @Disabled("TODO: Complete this test")
  void testViewReviewForm_whenConcurrentModel() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.NullPointerException
    //       at org.broadleafcommerce.core.web.controller.catalog.BroadleafRatingsController.viewReviewForm(BroadleafRatingsController.java:43)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange
    BroadleafRatingsController broadleafRatingsController = new BroadleafRatingsController();
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();
    SearchRequestWrapper request = new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
        new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"}));
    ConcurrentModel model = new ConcurrentModel();

    ReviewForm form = new ReviewForm();
    form.setProduct(new ProductBundleImpl());
    form.setRating(10.0d);
    form.setReviewText("Review Text");

    // Act
    broadleafRatingsController.viewReviewForm(request, model, form, "42");
  }

  /**
   * Test
   * {@link BroadleafRatingsController#reviewItem(HttpServletRequest, Model, ReviewForm, String)}.
   * <ul>
   *   <li>When {@link ConcurrentModel#ConcurrentModel()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BroadleafRatingsController#reviewItem(HttpServletRequest, Model, ReviewForm, String)}
   */
  @Test
  @DisplayName("Test reviewItem(HttpServletRequest, Model, ReviewForm, String); when ConcurrentModel()")
  @Disabled("TODO: Complete this test")
  void testReviewItem_whenConcurrentModel() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.NullPointerException
    //       at org.broadleafcommerce.core.web.controller.catalog.BroadleafRatingsController.reviewItem(BroadleafRatingsController.java:55)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange
    BroadleafRatingsController broadleafRatingsController = new BroadleafRatingsController();
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();
    SearchRequestWrapper request = new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
        new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"}));
    ConcurrentModel model = new ConcurrentModel();

    ReviewForm form = new ReviewForm();
    form.setProduct(new ProductBundleImpl());
    form.setRating(10.0d);
    form.setReviewText("Review Text");

    // Act
    broadleafRatingsController.reviewItem(request, model, form, "42");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link BroadleafRatingsController}
   *   <li>{@link BroadleafRatingsController#getFormView()}
   *   <li>{@link BroadleafRatingsController#getSuccessView()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange and Act
    BroadleafRatingsController actualBroadleafRatingsController = new BroadleafRatingsController();
    String actualFormView = actualBroadleafRatingsController.getFormView();

    // Assert
    assertEquals("catalog/partials/review", actualFormView);
    assertEquals("catalog/partials/reviewSuccessful", actualBroadleafRatingsController.getSuccessView());
  }
}
