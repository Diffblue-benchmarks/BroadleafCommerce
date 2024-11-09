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
package org.broadleafcommerce.common.web;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import javax.servlet.http.HttpServletRequest;
import org.broadleafcommerce.common.web.filter.SessionlessHttpServletRequestWrapper;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.core.env.StandardEnvironment;
import org.springframework.mock.web.MockHttpServletRequest;

public class BroadleafRequestFilterDiffblueTest {
  /**
   * Test
   * {@link BroadleafRequestFilter#shouldProcessURL(HttpServletRequest, String, boolean)}
   * with {@code request}, {@code requestURI}, {@code ignoreSessionCheck}.
   * <p>
   * Method under test:
   * {@link BroadleafRequestFilter#shouldProcessURL(HttpServletRequest, String, boolean)}
   */
  @Test
  public void testShouldProcessURLWithRequestRequestURIIgnoreSessionCheck() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafRequestFilter broadleafRequestFilter = new BroadleafRequestFilter();

    // Act and Assert
    assertTrue(broadleafRequestFilter.shouldProcessURL(
        new SessionlessHttpServletRequestWrapper(mock(SessionlessHttpServletRequestWrapper.class)),
        "https://example.org/example", true));
  }

  /**
   * Test
   * {@link BroadleafRequestFilter#shouldProcessURL(HttpServletRequest, String, boolean)}
   * with {@code request}, {@code requestURI}, {@code ignoreSessionCheck}.
   * <p>
   * Method under test:
   * {@link BroadleafRequestFilter#shouldProcessURL(HttpServletRequest, String, boolean)}
   */
  @Test
  public void testShouldProcessURLWithRequestRequestURIIgnoreSessionCheck2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafRequestFilter broadleafRequestFilter = new BroadleafRequestFilter();

    // Act and Assert
    assertFalse(broadleafRequestFilter.shouldProcessURL(
        new SessionlessHttpServletRequestWrapper(new MockHttpServletRequest()), "org.broadleafcommerce.admin", true));
  }

  /**
   * Test
   * {@link BroadleafRequestFilter#shouldProcessURL(HttpServletRequest, String, boolean)}
   * with {@code request}, {@code requestURI}, {@code ignoreSessionCheck}.
   * <ul>
   *   <li>Given {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BroadleafRequestFilter#shouldProcessURL(HttpServletRequest, String, boolean)}
   */
  @Test
  public void testShouldProcessURLWithRequestRequestURIIgnoreSessionCheck_givenFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafRequestFilter broadleafRequestFilter = new BroadleafRequestFilter();
    SessionlessHttpServletRequestWrapper request = mock(SessionlessHttpServletRequestWrapper.class);
    when(request.getAttribute(Mockito.<String>any())).thenReturn(false);

    // Act
    boolean actualShouldProcessURLResult = broadleafRequestFilter
        .shouldProcessURL(new SessionlessHttpServletRequestWrapper(request), "https://example.org/example", false);

    // Assert
    verify(request).getAttribute(eq("blOkToUseSession"));
    assertTrue(actualShouldProcessURLResult);
  }

  /**
   * Test
   * {@link BroadleafRequestFilter#shouldProcessURL(HttpServletRequest, String, boolean)}
   * with {@code request}, {@code requestURI}, {@code ignoreSessionCheck}.
   * <ul>
   *   <li>Given {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BroadleafRequestFilter#shouldProcessURL(HttpServletRequest, String, boolean)}
   */
  @Test
  public void testShouldProcessURLWithRequestRequestURIIgnoreSessionCheck_givenTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafRequestFilter broadleafRequestFilter = new BroadleafRequestFilter();
    SessionlessHttpServletRequestWrapper request = mock(SessionlessHttpServletRequestWrapper.class);
    when(request.getAttribute(Mockito.<String>any())).thenReturn(true);

    // Act
    boolean actualShouldProcessURLResult = broadleafRequestFilter
        .shouldProcessURL(new SessionlessHttpServletRequestWrapper(request), "https://example.org/example", false);

    // Assert
    verify(request).getAttribute(eq("blOkToUseSession"));
    assertTrue(actualShouldProcessURLResult);
  }

  /**
   * Test
   * {@link BroadleafRequestFilter#shouldProcessURL(HttpServletRequest, String, boolean)}
   * with {@code request}, {@code requestURI}, {@code ignoreSessionCheck}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BroadleafRequestFilter#shouldProcessURL(HttpServletRequest, String, boolean)}
   */
  @Test
  public void testShouldProcessURLWithRequestRequestURIIgnoreSessionCheck_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafRequestFilter broadleafRequestFilter = new BroadleafRequestFilter();

    // Act and Assert
    assertTrue(broadleafRequestFilter.shouldProcessURL(
        new SessionlessHttpServletRequestWrapper(new MockHttpServletRequest()), "https://example.org/example", true));
  }

  /**
   * Test
   * {@link BroadleafRequestFilter#shouldProcessURL(HttpServletRequest, String, boolean)}
   * with {@code request}, {@code requestURI}, {@code ignoreSessionCheck}.
   * <ul>
   *   <li>When {@code blcadmin}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BroadleafRequestFilter#shouldProcessURL(HttpServletRequest, String, boolean)}
   */
  @Test
  public void testShouldProcessURLWithRequestRequestURIIgnoreSessionCheck_whenBlcadmin() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafRequestFilter broadleafRequestFilter = new BroadleafRequestFilter();

    // Act and Assert
    assertFalse(broadleafRequestFilter
        .shouldProcessURL(new SessionlessHttpServletRequestWrapper(new MockHttpServletRequest()), "blcadmin", true));
  }

  /**
   * Test
   * {@link BroadleafRequestFilter#shouldProcessURL(HttpServletRequest, String, boolean)}
   * with {@code request}, {@code requestURI}, {@code ignoreSessionCheck}.
   * <ul>
   *   <li>When {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BroadleafRequestFilter#shouldProcessURL(HttpServletRequest, String, boolean)}
   */
  @Test
  public void testShouldProcessURLWithRequestRequestURIIgnoreSessionCheck_whenFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafRequestFilter broadleafRequestFilter = new BroadleafRequestFilter();

    // Act and Assert
    assertTrue(broadleafRequestFilter.shouldProcessURL(
        new SessionlessHttpServletRequestWrapper(new MockHttpServletRequest()), "https://example.org/example", false));
  }

  /**
   * Test
   * {@link BroadleafRequestFilter#shouldProcessURL(HttpServletRequest, String, boolean)}
   * with {@code request}, {@code requestURI}, {@code ignoreSessionCheck}.
   * <ul>
   *   <li>When {@code .service}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BroadleafRequestFilter#shouldProcessURL(HttpServletRequest, String, boolean)}
   */
  @Test
  public void testShouldProcessURLWithRequestRequestURIIgnoreSessionCheck_whenService() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafRequestFilter broadleafRequestFilter = new BroadleafRequestFilter();

    // Act and Assert
    assertFalse(broadleafRequestFilter
        .shouldProcessURL(new SessionlessHttpServletRequestWrapper(new MockHttpServletRequest()), ".service", true));
  }

  /**
   * Test
   * {@link BroadleafRequestFilter#shouldProcessURL(HttpServletRequest, String)}
   * with {@code request}, {@code requestURI}.
   * <ul>
   *   <li>Given {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BroadleafRequestFilter#shouldProcessURL(HttpServletRequest, String)}
   */
  @Test
  public void testShouldProcessURLWithRequestRequestURI_givenFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafRequestFilter broadleafRequestFilter = new BroadleafRequestFilter();
    SessionlessHttpServletRequestWrapper request = mock(SessionlessHttpServletRequestWrapper.class);
    when(request.getAttribute(Mockito.<String>any())).thenReturn(false);

    // Act
    boolean actualShouldProcessURLResult = broadleafRequestFilter
        .shouldProcessURL(new SessionlessHttpServletRequestWrapper(request), "https://example.org/example");

    // Assert
    verify(request).getAttribute(eq("blOkToUseSession"));
    assertTrue(actualShouldProcessURLResult);
  }

  /**
   * Test
   * {@link BroadleafRequestFilter#shouldProcessURL(HttpServletRequest, String)}
   * with {@code request}, {@code requestURI}.
   * <ul>
   *   <li>Given {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BroadleafRequestFilter#shouldProcessURL(HttpServletRequest, String)}
   */
  @Test
  public void testShouldProcessURLWithRequestRequestURI_givenTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafRequestFilter broadleafRequestFilter = new BroadleafRequestFilter();
    SessionlessHttpServletRequestWrapper request = mock(SessionlessHttpServletRequestWrapper.class);
    when(request.getAttribute(Mockito.<String>any())).thenReturn(true);

    // Act
    boolean actualShouldProcessURLResult = broadleafRequestFilter
        .shouldProcessURL(new SessionlessHttpServletRequestWrapper(request), "https://example.org/example");

    // Assert
    verify(request).getAttribute(eq("blOkToUseSession"));
    assertTrue(actualShouldProcessURLResult);
  }

  /**
   * Test
   * {@link BroadleafRequestFilter#shouldProcessURL(HttpServletRequest, String)}
   * with {@code request}, {@code requestURI}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BroadleafRequestFilter#shouldProcessURL(HttpServletRequest, String)}
   */
  @Test
  public void testShouldProcessURLWithRequestRequestURI_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafRequestFilter broadleafRequestFilter = new BroadleafRequestFilter();

    // Act and Assert
    assertTrue(broadleafRequestFilter.shouldProcessURL(
        new SessionlessHttpServletRequestWrapper(new MockHttpServletRequest()), "https://example.org/example"));
  }

  /**
   * Test
   * {@link BroadleafRequestFilter#shouldProcessURL(HttpServletRequest, String)}
   * with {@code request}, {@code requestURI}.
   * <ul>
   *   <li>When {@code blcadmin}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BroadleafRequestFilter#shouldProcessURL(HttpServletRequest, String)}
   */
  @Test
  public void testShouldProcessURLWithRequestRequestURI_whenBlcadmin_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafRequestFilter broadleafRequestFilter = new BroadleafRequestFilter();

    // Act and Assert
    assertFalse(broadleafRequestFilter
        .shouldProcessURL(new SessionlessHttpServletRequestWrapper(new MockHttpServletRequest()), "blcadmin"));
  }

  /**
   * Test
   * {@link BroadleafRequestFilter#shouldProcessURL(HttpServletRequest, String)}
   * with {@code request}, {@code requestURI}.
   * <ul>
   *   <li>When {@code org.broadleafcommerce.admin}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BroadleafRequestFilter#shouldProcessURL(HttpServletRequest, String)}
   */
  @Test
  public void testShouldProcessURLWithRequestRequestURI_whenOrgBroadleafcommerceAdmin() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafRequestFilter broadleafRequestFilter = new BroadleafRequestFilter();

    // Act and Assert
    assertFalse(broadleafRequestFilter.shouldProcessURL(
        new SessionlessHttpServletRequestWrapper(new MockHttpServletRequest()), "org.broadleafcommerce.admin"));
  }

  /**
   * Test
   * {@link BroadleafRequestFilter#shouldProcessURL(HttpServletRequest, String)}
   * with {@code request}, {@code requestURI}.
   * <ul>
   *   <li>When {@code org.broadleafcommerce.admin}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BroadleafRequestFilter#shouldProcessURL(HttpServletRequest, String)}
   */
  @Test
  public void testShouldProcessURLWithRequestRequestURI_whenOrgBroadleafcommerceAdmin2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafRequestFilter broadleafRequestFilter = new BroadleafRequestFilter();

    // Act and Assert
    assertFalse(broadleafRequestFilter.shouldProcessURL(
        new SessionlessHttpServletRequestWrapper(mock(SessionlessHttpServletRequestWrapper.class)),
        "org.broadleafcommerce.admin"));
  }

  /**
   * Test
   * {@link BroadleafRequestFilter#shouldProcessURL(HttpServletRequest, String)}
   * with {@code request}, {@code requestURI}.
   * <ul>
   *   <li>When {@code .service}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BroadleafRequestFilter#shouldProcessURL(HttpServletRequest, String)}
   */
  @Test
  public void testShouldProcessURLWithRequestRequestURI_whenService_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafRequestFilter broadleafRequestFilter = new BroadleafRequestFilter();

    // Act and Assert
    assertFalse(broadleafRequestFilter
        .shouldProcessURL(new SessionlessHttpServletRequestWrapper(new MockHttpServletRequest()), ".service"));
  }

  /**
   * Test {@link BroadleafRequestFilter#getIgnoreSuffixes()}.
   * <p>
   * Method under test: {@link BroadleafRequestFilter#getIgnoreSuffixes()}
   */
  @Test
  public void testGetIgnoreSuffixes() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafRequestFilter broadleafRequestFilter = new BroadleafRequestFilter();
    broadleafRequestFilter.setEnvironment(mock(StandardEnvironment.class));

    // Act and Assert
    assertEquals(44, broadleafRequestFilter.getIgnoreSuffixes().size());
  }

  /**
   * Test {@link BroadleafRequestFilter#getIgnoreSuffixes()}.
   * <ul>
   *   <li>Given {@link BroadleafRequestFilter} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafRequestFilter#getIgnoreSuffixes()}
   */
  @Test
  public void testGetIgnoreSuffixes_givenBroadleafRequestFilter() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals(44, (new BroadleafRequestFilter()).getIgnoreSuffixes().size());
  }

  /**
   * Test {@link BroadleafRequestFilter#shouldNotFilterErrorDispatch()}.
   * <p>
   * Method under test:
   * {@link BroadleafRequestFilter#shouldNotFilterErrorDispatch()}
   */
  @Test
  public void testShouldNotFilterErrorDispatch() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafRequestFilter broadleafRequestFilter = new BroadleafRequestFilter();
    broadleafRequestFilter.setEnvironment(mock(StandardEnvironment.class));

    // Act and Assert
    assertFalse(broadleafRequestFilter.shouldNotFilterErrorDispatch());
  }

  /**
   * Test {@link BroadleafRequestFilter#shouldNotFilterErrorDispatch()}.
   * <ul>
   *   <li>Given {@link BroadleafRequestFilter} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BroadleafRequestFilter#shouldNotFilterErrorDispatch()}
   */
  @Test
  public void testShouldNotFilterErrorDispatch_givenBroadleafRequestFilter() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new BroadleafRequestFilter()).shouldNotFilterErrorDispatch());
  }

  /**
   * Test {@link BroadleafRequestFilter#getOrder()}.
   * <ul>
   *   <li>Given {@link BroadleafRequestFilter} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafRequestFilter#getOrder()}
   */
  @Test
  public void testGetOrder_givenBroadleafRequestFilter() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals(-10000, (new BroadleafRequestFilter()).getOrder());
  }

  /**
   * Test {@link BroadleafRequestFilter#getOrder()}.
   * <ul>
   *   <li>Given {@link BroadleafRequestFilter} (default constructor) Environment is
   * {@link StandardEnvironment}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafRequestFilter#getOrder()}
   */
  @Test
  public void testGetOrder_givenBroadleafRequestFilterEnvironmentIsStandardEnvironment() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafRequestFilter broadleafRequestFilter = new BroadleafRequestFilter();
    broadleafRequestFilter.setEnvironment(mock(StandardEnvironment.class));

    // Act and Assert
    assertEquals(-10000, broadleafRequestFilter.getOrder());
  }
}
