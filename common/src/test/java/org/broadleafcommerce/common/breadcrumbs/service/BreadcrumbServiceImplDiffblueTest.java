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
package org.broadleafcommerce.common.breadcrumbs.service;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import org.junit.Test;

public class BreadcrumbServiceImplDiffblueTest {
  /**
   * Test {@link BreadcrumbServiceImpl#buildBreadcrumbDTOs(String, Map)}.
   * <ul>
   *   <li>Given {@code foo}.</li>
   *   <li>When {@link HashMap#HashMap()} computeIfPresent {@code foo} and
   * {@link BiFunction}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BreadcrumbServiceImpl#buildBreadcrumbDTOs(String, Map)}
   */
  @Test
  public void testBuildBreadcrumbDTOs_givenFoo_whenHashMapComputeIfPresentFooAndBiFunction() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BreadcrumbServiceImpl breadcrumbServiceImpl = new BreadcrumbServiceImpl();

    HashMap<String, String[]> params = new HashMap<>();
    params.computeIfPresent("foo", mock(BiFunction.class));

    // Act and Assert
    assertTrue(breadcrumbServiceImpl.buildBreadcrumbDTOs("https://example.org/example", params).isEmpty());
  }

  /**
   * Test {@link BreadcrumbServiceImpl#buildBreadcrumbDTOs(String, Map)}.
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BreadcrumbServiceImpl#buildBreadcrumbDTOs(String, Map)}
   */
  @Test
  public void testBuildBreadcrumbDTOs_whenHashMap() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BreadcrumbServiceImpl breadcrumbServiceImpl = new BreadcrumbServiceImpl();

    // Act and Assert
    assertTrue(breadcrumbServiceImpl.buildBreadcrumbDTOs("https://example.org/example", new HashMap<>()).isEmpty());
  }
}
