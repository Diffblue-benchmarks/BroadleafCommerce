/*-
 * #%L
 * BroadleafCommerce CMS Module
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
package org.broadleafcommerce.cms.web;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.io.UnsupportedEncodingException;
import java.util.Set;
import org.junit.Test;

public class URLHandlerFilterDiffblueTest {
  /**
   * Test {@link URLHandlerFilter#getExistingQueryParams(String)}.
   * <ul>
   *   <li>When {@code https://example.org/example}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link URLHandlerFilter#getExistingQueryParams(String)}
   */
  @Test
  public void testGetExistingQueryParams_whenHttpsExampleOrgExample_thenReturnEmpty()
      throws UnsupportedEncodingException {
    // Arrange and Act
    Set<String> actualExistingQueryParams = URLHandlerFilter.getExistingQueryParams("https://example.org/example");

    // Assert
    assertTrue(actualExistingQueryParams.isEmpty());
  }

  /**
   * Test {@link URLHandlerFilter#getExistingQueryParams(String)}.
   * <ul>
   *   <li>When {@code https://example.org/example?}.</li>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link URLHandlerFilter#getExistingQueryParams(String)}
   */
  @Test
  public void testGetExistingQueryParams_whenHttpsExampleOrgExample_thenReturnSizeIsOne()
      throws UnsupportedEncodingException {
    // Arrange and Act
    Set<String> actualExistingQueryParams = URLHandlerFilter.getExistingQueryParams("https://example.org/example?");

    // Assert
    assertEquals(1, actualExistingQueryParams.size());
    assertTrue(actualExistingQueryParams.contains("?"));
  }

  /**
   * Test {@link URLHandlerFilter#getOrder()}.
   * <p>
   * Method under test: {@link URLHandlerFilter#getOrder()}
   */
  @Test
  public void testGetOrder() {
    // Arrange, Act and Assert
    assertEquals(1000000, (new URLHandlerFilter()).getOrder());
  }
}
