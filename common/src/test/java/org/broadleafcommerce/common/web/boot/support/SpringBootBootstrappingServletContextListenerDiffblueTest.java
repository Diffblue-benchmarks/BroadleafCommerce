package org.broadleafcommerce.common.web.boot.support;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.springframework.mock.web.MockServletContext;

public class SpringBootBootstrappingServletContextListenerDiffblueTest {
  /**
   * Test {@link
   * SpringBootBootstrappingServletContextListener#contextInitialized(ServletContextEvent)}.
   *
   * <ul>
   *   <li>Given {@link SpringBootBootstrappingServletContextListener#APPLICATION_CLASS}.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * SpringBootBootstrappingServletContextListener#contextInitialized(ServletContextEvent)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SpringBootBootstrappingServletContextListener.contextInitialized(ServletContextEvent)"
  })
  public void testContextInitialized_givenApplication_class_thenThrowRuntimeException() {
    // Arrange
    SpringBootBootstrappingServletContextListener springBootBootstrappingServletContextListener =
        new SpringBootBootstrappingServletContextListener();

    MockServletContext source = new MockServletContext();
    source.addInitParameter(SpringBootBootstrappingServletContextListener.APPLICATION_CLASS, "42");

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            springBootBootstrappingServletContextListener.contextInitialized(
                new ServletContextEvent(source)));
  }

  /**
   * Test {@link
   * SpringBootBootstrappingServletContextListener#contextInitialized(ServletContextEvent)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * SpringBootBootstrappingServletContextListener#contextInitialized(ServletContextEvent)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SpringBootBootstrappingServletContextListener.contextInitialized(ServletContextEvent)"
  })
  public void testContextInitialized_thenThrowIllegalStateException() {
    // Arrange
    SpringBootBootstrappingServletContextListener springBootBootstrappingServletContextListener =
        new SpringBootBootstrappingServletContextListener();

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () ->
            springBootBootstrappingServletContextListener.contextInitialized(
                new ServletContextEvent(new MockServletContext())));
  }

  /**
   * Test {@link SpringBootBootstrappingServletContextListener#getInitializerClass(ServletContext)}.
   *
   * <ul>
   *   <li>When {@link MockServletContext#MockServletContext()}.
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * SpringBootBootstrappingServletContextListener#getInitializerClass(ServletContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Class SpringBootBootstrappingServletContextListener.getInitializerClass(ServletContext)"
  })
  public void testGetInitializerClass_whenMockServletContext_thenThrowIllegalStateException()
      throws ClassNotFoundException, LinkageError {
    // Arrange
    SpringBootBootstrappingServletContextListener springBootBootstrappingServletContextListener =
        new SpringBootBootstrappingServletContextListener();

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () ->
            springBootBootstrappingServletContextListener.getInitializerClass(
                new MockServletContext()));
  }

  /**
   * Test new {@link SpringBootBootstrappingServletContextListener} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link
   * SpringBootBootstrappingServletContextListener}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SpringBootBootstrappingServletContextListener.<init>()"})
  public void testNewSpringBootBootstrappingServletContextListener() {
    // Arrange, Act and Assert
    assertNull(new SpringBootBootstrappingServletContextListener().delegateListener);
  }
}
