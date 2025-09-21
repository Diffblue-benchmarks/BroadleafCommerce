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
package org.broadleafcommerce.common.web.util;

import static org.junit.Assert.assertEquals;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class BroadleafUrlParamUtilsDiffblueTest {
  /**
   * Test {@link BroadleafUrlParamUtils#addPaginationParam(String, String, Integer)}.
   *
   * <p>Method under test: {@link BroadleafUrlParamUtils#addPaginationParam(String, String,
   * Integer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BroadleafUrlParamUtils.addPaginationParam(String, String, Integer)"})
  public void testAddPaginationParam() {
    // Arrange and Act
    String actualAddPaginationParamResult =
        BroadleafUrlParamUtils.addPaginationParam(
            "https://example.org/example", "https://example.org/example", 10);

    // Assert
    assertEquals(
        "https://example.org/example?https%3A%2F%2Fexample.org%2Fexample=10",
        actualAddPaginationParamResult);
  }

  /**
   * Test {@link BroadleafUrlParamUtils#addPaginationParam(String, String, Integer)}.
   *
   * <ul>
   *   <li>Then return {@code ?https%3A%2F%2Fexample.org%2Fexample=10}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafUrlParamUtils#addPaginationParam(String, String,
   * Integer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BroadleafUrlParamUtils.addPaginationParam(String, String, Integer)"})
  public void testAddPaginationParam_thenReturnHttps3a2f2FexampleOrg2Fexample10() {
    // Arrange and Act
    String actualAddPaginationParamResult =
        BroadleafUrlParamUtils.addPaginationParam("", "https://example.org/example", 10);

    // Assert
    assertEquals("?https%3A%2F%2Fexample.org%2Fexample=10", actualAddPaginationParamResult);
  }

  /**
   * Test {@link BroadleafUrlParamUtils#addPaginationParam(String, String, Integer)}.
   *
   * <ul>
   *   <li>Then return {@code https://example.org/example?Pagination+Param+Name=10}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafUrlParamUtils#addPaginationParam(String, String,
   * Integer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BroadleafUrlParamUtils.addPaginationParam(String, String, Integer)"})
  public void testAddPaginationParam_thenReturnHttpsExampleOrgExamplePaginationParamName10() {
    // Arrange and Act
    String actualAddPaginationParamResult =
        BroadleafUrlParamUtils.addPaginationParam(
            "https://example.org/example", "Pagination Param Name", 10);

    // Assert
    assertEquals(
        "https://example.org/example?Pagination+Param+Name=10", actualAddPaginationParamResult);
  }

  /**
   * Test {@link BroadleafUrlParamUtils#addPaginationParam(String, String, Integer)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return {@code https://example.org/example}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafUrlParamUtils#addPaginationParam(String, String,
   * Integer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BroadleafUrlParamUtils.addPaginationParam(String, String, Integer)"})
  public void testAddPaginationParam_whenOne_thenReturnHttpsExampleOrgExample() {
    // Arrange and Act
    String actualAddPaginationParamResult =
        BroadleafUrlParamUtils.addPaginationParam("https://example.org/example", null, 1);

    // Assert
    assertEquals("https://example.org/example", actualAddPaginationParamResult);
  }

  /**
   * Test {@link BroadleafUrlParamUtils#addPaginationParam(String, String, Integer)}.
   *
   * <ul>
   *   <li>When {@code Url}.
   *   <li>Then return {@code Url?https%3A%2F%2Fexample.org%2Fexample=10}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafUrlParamUtils#addPaginationParam(String, String,
   * Integer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BroadleafUrlParamUtils.addPaginationParam(String, String, Integer)"})
  public void testAddPaginationParam_whenUrl_thenReturnUrlHttps3a2f2FexampleOrg2Fexample10() {
    // Arrange and Act
    String actualAddPaginationParamResult =
        BroadleafUrlParamUtils.addPaginationParam("Url", "https://example.org/example", 10);

    // Assert
    assertEquals("Url?https%3A%2F%2Fexample.org%2Fexample=10", actualAddPaginationParamResult);
  }
}
