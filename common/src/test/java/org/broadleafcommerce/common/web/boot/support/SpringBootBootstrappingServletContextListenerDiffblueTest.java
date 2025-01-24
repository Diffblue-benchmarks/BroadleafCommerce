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
package org.broadleafcommerce.common.web.boot.support;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import java.security.PrivilegedActionException;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletException;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.mock.web.MockServletContext;
import org.springframework.web.WebApplicationInitializer;

public class SpringBootBootstrappingServletContextListenerDiffblueTest {
  /**
   * Test
   * {@link SpringBootBootstrappingServletContextListener#contextInitialized(ServletContextEvent)}.
   * <ul>
   *   <li>Given
   * {@link SpringBootBootstrappingServletContextListener#APPLICATION_CLASS}.</li>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SpringBootBootstrappingServletContextListener#contextInitialized(ServletContextEvent)}
   */
  @Test
  public void testContextInitialized_givenApplication_class_thenThrowRuntimeException() {
    // Arrange
    SpringBootBootstrappingServletContextListener springBootBootstrappingServletContextListener = new SpringBootBootstrappingServletContextListener();

    MockServletContext source = new MockServletContext();
    source.addInitParameter(SpringBootBootstrappingServletContextListener.APPLICATION_CLASS, "42");

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> springBootBootstrappingServletContextListener.contextInitialized(new ServletContextEvent(source)));
  }

  /**
   * Test
   * {@link SpringBootBootstrappingServletContextListener#contextInitialized(ServletContextEvent)}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SpringBootBootstrappingServletContextListener#contextInitialized(ServletContextEvent)}
   */
  @Test
  public void testContextInitialized_thenThrowIllegalStateException() {
    // Arrange
    SpringBootBootstrappingServletContextListener springBootBootstrappingServletContextListener = new SpringBootBootstrappingServletContextListener();

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> springBootBootstrappingServletContextListener
        .contextInitialized(new ServletContextEvent(new MockServletContext())));
  }

  /**
   * Test
   * {@link SpringBootBootstrappingServletContextListener#contextDestroyed(ServletContextEvent)}.
   * <p>
   * Method under test:
   * {@link SpringBootBootstrappingServletContextListener#contextDestroyed(ServletContextEvent)}
   */
  @Test
  public void testContextDestroyed() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange
    SpringBootBootstrappingServletContextListener springBootBootstrappingServletContextListener = new SpringBootBootstrappingServletContextListener();

    // Act
    springBootBootstrappingServletContextListener.contextDestroyed(new ServletContextEvent(new MockServletContext()));
  }

  /**
   * Test
   * {@link SpringBootBootstrappingServletContextListener#getInitializerClass(ServletContext)}.
   * <ul>
   *   <li>When {@link MockServletContext#MockServletContext()}.</li>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SpringBootBootstrappingServletContextListener#getInitializerClass(ServletContext)}
   */
  @Test
  public void testGetInitializerClass_whenMockServletContext_thenThrowIllegalStateException()
      throws ClassNotFoundException, LinkageError {
    // Arrange
    SpringBootBootstrappingServletContextListener springBootBootstrappingServletContextListener = new SpringBootBootstrappingServletContextListener();

    // Act and Assert
    assertThrows(IllegalStateException.class,
        () -> springBootBootstrappingServletContextListener.getInitializerClass(new MockServletContext()));
  }

  /**
   * Test
   * {@link SpringBootBootstrappingServletContextListener#createInitializer(Class)}.
   * <ul>
   *   <li>When {@code org.springframework.web.WebApplicationInitializer}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SpringBootBootstrappingServletContextListener#createInitializer(Class)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testCreateInitializer_whenOrgSpringframeworkWebWebApplicationInitializer()
      throws PrivilegedActionException, ServletException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.NullPointerException
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange
    SpringBootBootstrappingServletContextListener springBootBootstrappingServletContextListener = new SpringBootBootstrappingServletContextListener();
    Class<WebApplicationInitializer> initializerClass = WebApplicationInitializer.class;

    // Act
    WebApplicationInitializer actualCreateInitializerResult = springBootBootstrappingServletContextListener
        .createInitializer(initializerClass);
    actualCreateInitializerResult.onStartup(new MockServletContext());
  }

  /**
   * Test new {@link SpringBootBootstrappingServletContextListener} (default
   * constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link SpringBootBootstrappingServletContextListener}
   */
  @Test
  public void testNewSpringBootBootstrappingServletContextListener() {
    // Arrange, Act and Assert
    assertNull((new SpringBootBootstrappingServletContextListener()).delegateListener);
  }
}
