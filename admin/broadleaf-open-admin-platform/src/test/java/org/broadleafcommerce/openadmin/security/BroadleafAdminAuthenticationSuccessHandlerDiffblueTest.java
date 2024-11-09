/*-
 * #%L
 * BroadleafCommerce Open Admin Platform
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
package org.broadleafcommerce.openadmin.security;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.mock;
import org.broadleafcommerce.common.security.LocalRedirectStrategy;
import org.junit.Test;

public class BroadleafAdminAuthenticationSuccessHandlerDiffblueTest {
  /**
   * Test
   * {@link BroadleafAdminAuthenticationSuccessHandler#removeLoginSegment(String)}.
   * <p>
   * Method under test:
   * {@link BroadleafAdminAuthenticationSuccessHandler#removeLoginSegment(String)}
   */
  @Test
  public void testRemoveLoginSegment() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafAdminAuthenticationSuccessHandler broadleafAdminAuthenticationSuccessHandler = new BroadleafAdminAuthenticationSuccessHandler();
    broadleafAdminAuthenticationSuccessHandler.setRedirectStrategy(mock(LocalRedirectStrategy.class));

    // Act and Assert
    assertEquals("https://example.org/example",
        broadleafAdminAuthenticationSuccessHandler.removeLoginSegment("https://example.org/example"));
  }

  /**
   * Test
   * {@link BroadleafAdminAuthenticationSuccessHandler#removeLoginSegment(String)}.
   * <ul>
   *   <li>Then return {@code https://example.org/example}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BroadleafAdminAuthenticationSuccessHandler#removeLoginSegment(String)}
   */
  @Test
  public void testRemoveLoginSegment_thenReturnHttpsExampleOrgExample() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("https://example.org/example",
        (new BroadleafAdminAuthenticationSuccessHandler()).removeLoginSegment("https://example.org/example"));
  }

  /**
   * Test
   * {@link BroadleafAdminAuthenticationSuccessHandler#removeLoginSegment(String)}.
   * <ul>
   *   <li>When {@code /login}.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BroadleafAdminAuthenticationSuccessHandler#removeLoginSegment(String)}
   */
  @Test
  public void testRemoveLoginSegment_whenLogin_thenReturnEmptyString() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("", (new BroadleafAdminAuthenticationSuccessHandler()).removeLoginSegment("/login"));
  }

  /**
   * Test
   * {@link BroadleafAdminAuthenticationSuccessHandler#removeLoginSegment(String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code /}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BroadleafAdminAuthenticationSuccessHandler#removeLoginSegment(String)}
   */
  @Test
  public void testRemoveLoginSegment_whenNull_thenReturnSlash() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("/", (new BroadleafAdminAuthenticationSuccessHandler()).removeLoginSegment(null));
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link BroadleafAdminAuthenticationSuccessHandler#setLoginUri(String)}
   *   <li>{@link BroadleafAdminAuthenticationSuccessHandler#getLoginUri()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    BroadleafAdminAuthenticationSuccessHandler broadleafAdminAuthenticationSuccessHandler = new BroadleafAdminAuthenticationSuccessHandler();

    // Act
    broadleafAdminAuthenticationSuccessHandler.setLoginUri("Login Uri");

    // Assert that nothing has changed
    assertEquals("Login Uri", broadleafAdminAuthenticationSuccessHandler.getLoginUri());
  }

  /**
   * Test new {@link BroadleafAdminAuthenticationSuccessHandler} (default
   * constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link BroadleafAdminAuthenticationSuccessHandler}
   */
  @Test
  public void testNewBroadleafAdminAuthenticationSuccessHandler() {
    // Arrange and Act
    BroadleafAdminAuthenticationSuccessHandler actualBroadleafAdminAuthenticationSuccessHandler = new BroadleafAdminAuthenticationSuccessHandler();

    // Assert
    assertEquals("/login", actualBroadleafAdminAuthenticationSuccessHandler.getLoginUri());
    assertNull(actualBroadleafAdminAuthenticationSuccessHandler.adminRemoteSecurityService);
  }
}
