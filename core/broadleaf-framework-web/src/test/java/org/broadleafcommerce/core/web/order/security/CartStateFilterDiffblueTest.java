/*-
 * #%L
 * BroadleafCommerce Framework Web
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
package org.broadleafcommerce.core.web.order.security;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletRequest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.core.env.StandardEnvironment;

class CartStateFilterDiffblueTest {
  /**
   * Test {@link CartStateFilter#requestRequiresLock(ServletRequest)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CartStateFilter#requestRequiresLock(ServletRequest)}
   */
  @Test
  @DisplayName("Test requestRequiresLock(ServletRequest); when 'null'; then return 'false'")
  void testRequestRequiresLock_whenNull_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new CartStateFilter()).requestRequiresLock(null));
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link CartStateFilter#setExcludedOrderLockRequestPatterns(List)}
   *   <li>{@link CartStateFilter#getExcludedOrderLockRequestPatterns()}
   *   <li>{@link CartStateFilter#getOrder()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange
    CartStateFilter cartStateFilter = new CartStateFilter();
    ArrayList<String> excludedOrderLockRequestPatterns = new ArrayList<>();

    // Act
    cartStateFilter.setExcludedOrderLockRequestPatterns(excludedOrderLockRequestPatterns);
    List<String> actualExcludedOrderLockRequestPatterns = cartStateFilter.getExcludedOrderLockRequestPatterns();

    // Assert that nothing has changed
    assertEquals(1000000, cartStateFilter.getOrder());
    assertTrue(actualExcludedOrderLockRequestPatterns.isEmpty());
    assertSame(excludedOrderLockRequestPatterns, actualExcludedOrderLockRequestPatterns);
  }

  /**
   * Test {@link CartStateFilter#shouldNotFilterErrorDispatch()}.
   * <p>
   * Method under test: {@link CartStateFilter#shouldNotFilterErrorDispatch()}
   */
  @Test
  @DisplayName("Test shouldNotFilterErrorDispatch()")
  void testShouldNotFilterErrorDispatch() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CartStateFilter cartStateFilter = new CartStateFilter();
    cartStateFilter.setEnvironment(mock(StandardEnvironment.class));

    // Act and Assert
    assertFalse(cartStateFilter.shouldNotFilterErrorDispatch());
  }

  /**
   * Test {@link CartStateFilter#shouldNotFilterErrorDispatch()}.
   * <ul>
   *   <li>Given {@link CartStateFilter} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link CartStateFilter#shouldNotFilterErrorDispatch()}
   */
  @Test
  @DisplayName("Test shouldNotFilterErrorDispatch(); given CartStateFilter (default constructor)")
  void testShouldNotFilterErrorDispatch_givenCartStateFilter() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new CartStateFilter()).shouldNotFilterErrorDispatch());
  }
}
