/*-
 * #%L
 * BroadleafCommerce Common Libraries
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
package org.broadleafcommerce.common.util;

import static org.junit.Assert.assertEquals;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
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
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return {@code The entity has failed validation - ;}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ValidationUtil#buildErrorMessage(Map, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String ValidationUtil.buildErrorMessage(Map, List)"})
  public void testBuildErrorMessage_givenArrayList_thenReturnTheEntityHasFailedValidation() {
    // Arrange
    HashMap<String, List<String>> propertyErrors = new HashMap<>();
    propertyErrors.put("The entity has failed validation -\n", new ArrayList<>());

    // Act and Assert
    assertEquals("The entity has failed validation -\n;\n",
        ValidationUtil.buildErrorMessage(propertyErrors, new ArrayList<>()));
  }

  /**
   * Test {@link ValidationUtil#buildErrorMessage(Map, List)}.
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.</li>
   *   <li>Then return {@code The entity has failed validation -}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ValidationUtil#buildErrorMessage(Map, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String ValidationUtil.buildErrorMessage(Map, List)"})
  public void testBuildErrorMessage_whenHashMap_thenReturnTheEntityHasFailedValidation() {
    // Arrange
    HashMap<String, List<String>> propertyErrors = new HashMap<>();

    // Act and Assert
    assertEquals("The entity has failed validation -\n",
        ValidationUtil.buildErrorMessage(propertyErrors, new ArrayList<>()));
  }
}
