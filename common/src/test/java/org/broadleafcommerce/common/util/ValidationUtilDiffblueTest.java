package org.broadleafcommerce.common.util;

import static org.junit.Assert.assertEquals;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class ValidationUtilDiffblueTest {
  /**
   * Test {@link ValidationUtil#buildErrorMessage(Map, List)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.
   *   <li>Then return {@code The entity has failed validation - ;}.
   * </ul>
   *
   * <p>Method under test: {@link ValidationUtil#buildErrorMessage(Map, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ValidationUtil.buildErrorMessage(Map, List)"})
  public void testBuildErrorMessage_givenArrayList_thenReturnTheEntityHasFailedValidation() {
    // Arrange
    HashMap<String, List<String>> propertyErrors = new HashMap<>();
    propertyErrors.put("The entity has failed validation -\n", new ArrayList<>());

    // Act and Assert
    assertEquals(
        "The entity has failed validation -\n;\n",
        ValidationUtil.buildErrorMessage(propertyErrors, new ArrayList<>()));
  }

  /**
   * Test {@link ValidationUtil#buildErrorMessage(Map, List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return {@code The entity has failed validation -}.
   * </ul>
   *
   * <p>Method under test: {@link ValidationUtil#buildErrorMessage(Map, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ValidationUtil.buildErrorMessage(Map, List)"})
  public void testBuildErrorMessage_whenArrayList_thenReturnTheEntityHasFailedValidation() {
    // Arrange
    HashMap<String, List<String>> propertyErrors = new HashMap<>();

    // Act and Assert
    assertEquals(
        "The entity has failed validation -\n",
        ValidationUtil.buildErrorMessage(propertyErrors, new ArrayList<>()));
  }
}
