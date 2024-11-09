/*-
 * #%L
 * BroadleafCommerce Framework
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
package org.broadleafcommerce.core.search.domain;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class SearchInterceptImplDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link SearchInterceptImpl}
   *   <li>{@link SearchInterceptImpl#setId(Long)}
   *   <li>{@link SearchInterceptImpl#setRedirect(String)}
   *   <li>{@link SearchInterceptImpl#setTerm(String)}
   *   <li>{@link SearchInterceptImpl#getId()}
   *   <li>{@link SearchInterceptImpl#getRedirect()}
   *   <li>{@link SearchInterceptImpl#getTerm()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    SearchInterceptImpl actualSearchInterceptImpl = new SearchInterceptImpl();
    actualSearchInterceptImpl.setId(1L);
    actualSearchInterceptImpl.setRedirect("Redirect");
    actualSearchInterceptImpl.setTerm("Term");
    Long actualId = actualSearchInterceptImpl.getId();
    String actualRedirect = actualSearchInterceptImpl.getRedirect();

    // Assert that nothing has changed
    assertEquals("Redirect", actualRedirect);
    assertEquals("Term", actualSearchInterceptImpl.getTerm());
    assertEquals(1L, actualId.longValue());
  }
}
