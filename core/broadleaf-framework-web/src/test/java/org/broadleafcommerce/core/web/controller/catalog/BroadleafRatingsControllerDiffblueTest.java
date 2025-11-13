package org.broadleafcommerce.core.web.controller.catalog;

import static org.junit.Assert.assertEquals;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class BroadleafRatingsControllerDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link BroadleafRatingsController}
   *   <li>{@link BroadleafRatingsController#getFormView()}
   *   <li>{@link BroadleafRatingsController#getSuccessView()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BroadleafRatingsController.<init>()",
    "String BroadleafRatingsController.getFormView()",
    "String BroadleafRatingsController.getSuccessView()"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    BroadleafRatingsController actualBroadleafRatingsController = new BroadleafRatingsController();
    String actualFormView = actualBroadleafRatingsController.getFormView();

    // Assert
    assertEquals("catalog/partials/review", actualFormView);
    assertEquals(
        "catalog/partials/reviewSuccessful", actualBroadleafRatingsController.getSuccessView());
  }
}
