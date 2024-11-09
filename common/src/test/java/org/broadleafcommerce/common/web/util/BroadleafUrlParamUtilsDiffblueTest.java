/*-
 * #%L
 * BroadleafCommerce Common Libraries
 * %%
 * Copyright (C) 2009 - 2024 Broadleaf Commerce
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
import org.junit.Test;

public class BroadleafUrlParamUtilsDiffblueTest {
  /**
   * Test
   * {@link BroadleafUrlParamUtils#addPaginationParam(String, String, Integer)}.
   * <p>
   * Method under test:
   * {@link BroadleafUrlParamUtils#addPaginationParam(String, String, Integer)}
   */
  @Test
  public void testAddPaginationParam() {
    // Arrange, Act and Assert
    assertEquals("https://example.org/example?https%3A%2F%2Fexample.org%2Fexample=10",
        BroadleafUrlParamUtils.addPaginationParam("https://example.org/example", "https://example.org/example", 10));
  }

  /**
   * Test
   * {@link BroadleafUrlParamUtils#addPaginationParam(String, String, Integer)}.
   * <ul>
   *   <li>Then return {@code ?https%3A%2F%2Fexample.org%2Fexample=10}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BroadleafUrlParamUtils#addPaginationParam(String, String, Integer)}
   */
  @Test
  public void testAddPaginationParam_thenReturnHttps3a2f2FexampleOrg2Fexample10() {
    // Arrange, Act and Assert
    assertEquals("?https%3A%2F%2Fexample.org%2Fexample=10",
        BroadleafUrlParamUtils.addPaginationParam("", "https://example.org/example", 10));
  }

  /**
   * Test
   * {@link BroadleafUrlParamUtils#addPaginationParam(String, String, Integer)}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return {@code https://example.org/example}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BroadleafUrlParamUtils#addPaginationParam(String, String, Integer)}
   */
  @Test
  public void testAddPaginationParam_whenOne_thenReturnHttpsExampleOrgExample() {
    // Arrange, Act and Assert
    assertEquals("https://example.org/example",
        BroadleafUrlParamUtils.addPaginationParam("https://example.org/example", "https://example.org/example", 1));
  }

  /**
   * Test
   * {@link BroadleafUrlParamUtils#addPaginationParam(String, String, Integer)}.
   * <ul>
   *   <li>When {@code Url}.</li>
   *   <li>Then return {@code Url?https%3A%2F%2Fexample.org%2Fexample=10}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BroadleafUrlParamUtils#addPaginationParam(String, String, Integer)}
   */
  @Test
  public void testAddPaginationParam_whenUrl_thenReturnUrlHttps3a2f2FexampleOrg2Fexample10() {
    // Arrange, Act and Assert
    assertEquals("Url?https%3A%2F%2Fexample.org%2Fexample=10",
        BroadleafUrlParamUtils.addPaginationParam("Url", "https://example.org/example", 10));
  }
}
