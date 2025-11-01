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
   * Method under test:
   * {@link BroadleafRequestFilter#shouldProcessURL(HttpServletRequest, String)}
   */
  @Test
  public void testShouldProcessURL() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafRequestFilter broadleafRequestFilter = new BroadleafRequestFilter();

    // Act and Assert
    assertTrue(broadleafRequestFilter.shouldProcessURL(
        new SessionlessHttpServletRequestWrapper(new MockHttpServletRequest()), "https://example.org/example"));
  }

  /**
   * Method under test:
   * {@link BroadleafRequestFilter#shouldProcessURL(HttpServletRequest, String)}
   */
  @Test
  public void testShouldProcessURL2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafRequestFilter broadleafRequestFilter = new BroadleafRequestFilter();

    // Act and Assert
    assertFalse(broadleafRequestFilter.shouldProcessURL(
        new SessionlessHttpServletRequestWrapper(new MockHttpServletRequest()), "org.broadleafcommerce.admin"));
  }

  /**
   * Method under test:
   * {@link BroadleafRequestFilter#shouldProcessURL(HttpServletRequest, String)}
   */
  @Test
  public void testShouldProcessURL3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafRequestFilter broadleafRequestFilter = new BroadleafRequestFilter();

    // Act and Assert
    assertFalse(broadleafRequestFilter
        .shouldProcessURL(new SessionlessHttpServletRequestWrapper(new MockHttpServletRequest()), ".service"));
  }

  /**
   * Method under test:
   * {@link BroadleafRequestFilter#shouldProcessURL(HttpServletRequest, String)}
   */
  @Test
  public void testShouldProcessURL4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafRequestFilter broadleafRequestFilter = new BroadleafRequestFilter();

    // Act and Assert
    assertFalse(broadleafRequestFilter
        .shouldProcessURL(new SessionlessHttpServletRequestWrapper(new MockHttpServletRequest()), "blcadmin"));
  }

  /**
   * Method under test:
   * {@link BroadleafRequestFilter#shouldProcessURL(HttpServletRequest, String)}
   */
  @Test
  public void testShouldProcessURL5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafRequestFilter broadleafRequestFilter = new BroadleafRequestFilter();

    // Act and Assert
    assertFalse(broadleafRequestFilter.shouldProcessURL(
        new SessionlessHttpServletRequestWrapper(mock(SessionlessHttpServletRequestWrapper.class)),
        "org.broadleafcommerce.admin"));
  }

  /**
   * Method under test:
   * {@link BroadleafRequestFilter#shouldProcessURL(HttpServletRequest, String)}
   */
  @Test
  public void testShouldProcessURL6() {
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
   * Method under test:
   * {@link BroadleafRequestFilter#shouldProcessURL(HttpServletRequest, String)}
   */
  @Test
  public void testShouldProcessURL7() {
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
   * Method under test:
   * {@link BroadleafRequestFilter#shouldProcessURL(HttpServletRequest, String, boolean)}
   */
  @Test
  public void testShouldProcessURL8() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafRequestFilter broadleafRequestFilter = new BroadleafRequestFilter();

    // Act and Assert
    assertTrue(broadleafRequestFilter.shouldProcessURL(
        new SessionlessHttpServletRequestWrapper(new MockHttpServletRequest()), "https://example.org/example", true));
  }

  /**
   * Method under test:
   * {@link BroadleafRequestFilter#shouldProcessURL(HttpServletRequest, String, boolean)}
   */
  @Test
  public void testShouldProcessURL9() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafRequestFilter broadleafRequestFilter = new BroadleafRequestFilter();

    // Act and Assert
    assertTrue(broadleafRequestFilter.shouldProcessURL(
        new SessionlessHttpServletRequestWrapper(mock(SessionlessHttpServletRequestWrapper.class)),
        "https://example.org/example", true));
  }

  /**
   * Method under test:
   * {@link BroadleafRequestFilter#shouldProcessURL(HttpServletRequest, String, boolean)}
   */
  @Test
  public void testShouldProcessURL10() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafRequestFilter broadleafRequestFilter = new BroadleafRequestFilter();

    // Act and Assert
    assertFalse(broadleafRequestFilter.shouldProcessURL(
        new SessionlessHttpServletRequestWrapper(new MockHttpServletRequest()), "org.broadleafcommerce.admin", true));
  }

  /**
   * Method under test:
   * {@link BroadleafRequestFilter#shouldProcessURL(HttpServletRequest, String, boolean)}
   */
  @Test
  public void testShouldProcessURL11() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafRequestFilter broadleafRequestFilter = new BroadleafRequestFilter();

    // Act and Assert
    assertFalse(broadleafRequestFilter
        .shouldProcessURL(new SessionlessHttpServletRequestWrapper(new MockHttpServletRequest()), ".service", true));
  }

  /**
   * Method under test:
   * {@link BroadleafRequestFilter#shouldProcessURL(HttpServletRequest, String, boolean)}
   */
  @Test
  public void testShouldProcessURL12() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafRequestFilter broadleafRequestFilter = new BroadleafRequestFilter();

    // Act and Assert
    assertFalse(broadleafRequestFilter
        .shouldProcessURL(new SessionlessHttpServletRequestWrapper(new MockHttpServletRequest()), "blcadmin", true));
  }

  /**
   * Method under test:
   * {@link BroadleafRequestFilter#shouldProcessURL(HttpServletRequest, String, boolean)}
   */
  @Test
  public void testShouldProcessURL13() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafRequestFilter broadleafRequestFilter = new BroadleafRequestFilter();

    // Act and Assert
    assertTrue(broadleafRequestFilter.shouldProcessURL(
        new SessionlessHttpServletRequestWrapper(new MockHttpServletRequest()), "https://example.org/example", false));
  }

  /**
   * Method under test:
   * {@link BroadleafRequestFilter#shouldProcessURL(HttpServletRequest, String, boolean)}
   */
  @Test
  public void testShouldProcessURL14() {
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
   * Method under test:
   * {@link BroadleafRequestFilter#shouldProcessURL(HttpServletRequest, String, boolean)}
   */
  @Test
  public void testShouldProcessURL15() {
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
   * Method under test: {@link BroadleafRequestFilter#getIgnoreSuffixes()}
   */
  @Test
  public void testGetIgnoreSuffixes() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals(44, (new BroadleafRequestFilter()).getIgnoreSuffixes().size());
  }

  /**
   * Method under test: {@link BroadleafRequestFilter#getIgnoreSuffixes()}
   */
  @Test
  public void testGetIgnoreSuffixes2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafRequestFilter broadleafRequestFilter = new BroadleafRequestFilter();
    broadleafRequestFilter.setEnvironment(mock(StandardEnvironment.class));

    // Act and Assert
    assertEquals(44, broadleafRequestFilter.getIgnoreSuffixes().size());
  }

  /**
   * Method under test:
   * {@link BroadleafRequestFilter#shouldNotFilterErrorDispatch()}
   */
  @Test
  public void testShouldNotFilterErrorDispatch() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new BroadleafRequestFilter()).shouldNotFilterErrorDispatch());
  }

  /**
   * Method under test:
   * {@link BroadleafRequestFilter#shouldNotFilterErrorDispatch()}
   */
  @Test
  public void testShouldNotFilterErrorDispatch2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafRequestFilter broadleafRequestFilter = new BroadleafRequestFilter();
    broadleafRequestFilter.setEnvironment(mock(StandardEnvironment.class));

    // Act and Assert
    assertFalse(broadleafRequestFilter.shouldNotFilterErrorDispatch());
  }

  /**
   * Method under test: {@link BroadleafRequestFilter#getOrder()}
   */
  @Test
  public void testGetOrder() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals(-10000, (new BroadleafRequestFilter()).getOrder());
  }

  /**
   * Method under test: {@link BroadleafRequestFilter#getOrder()}
   */
  @Test
  public void testGetOrder2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafRequestFilter broadleafRequestFilter = new BroadleafRequestFilter();
    broadleafRequestFilter.setEnvironment(mock(StandardEnvironment.class));

    // Act and Assert
    assertEquals(-10000, broadleafRequestFilter.getOrder());
  }
}
