package org.broadleafcommerce.openadmin.web.handler;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.broadleafcommerce.openadmin.exception.EntityNotFoundException;
import org.broadleafcommerce.openadmin.web.compatibility.JSCompatibilityRequestWrapper;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml",
    "/bl-open-admin-applicationContext-entity.xml", "/bl-open-admin-contentClient-applicationContext.xml",
    "/bl-open-admin-contentCreator-applicationContext.xml",
    "/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml",
    "/blc-config/admin/framework/bl-open-admin-applicationContext.xml",
    "/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class AdminMappingExceptionResolverDiffblueTest {
  @Autowired
  private AdminMappingExceptionResolver adminMappingExceptionResolver;

  /**
   * Test
   * {@link AdminMappingExceptionResolver#resolveException(HttpServletRequest, HttpServletResponse, Object, Exception)}.
   * <p>
   * Method under test:
   * {@link AdminMappingExceptionResolver#resolveException(HttpServletRequest, HttpServletResponse, Object, Exception)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testResolveException() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.web.handler;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass15225 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.web.handler.AdminMappingExceptionResolver adminMappingExceptionResolver;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    JSCompatibilityRequestWrapper request = new JSCompatibilityRequestWrapper(new MockHttpServletRequest());
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    adminMappingExceptionResolver.resolveException(request, response, "Handler", new Exception("foo"));
  }

  /**
   * Test
   * {@link AdminMappingExceptionResolver#resolveException(HttpServletRequest, HttpServletResponse, Object, Exception)}.
   * <ul>
   *   <li>Given {@link AdminMappingExceptionResolver} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminMappingExceptionResolver#resolveException(HttpServletRequest, HttpServletResponse, Object, Exception)}
   */
  @Test
  public void testResolveException_givenAdminMappingExceptionResolver_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminMappingExceptionResolver adminMappingExceptionResolver = new AdminMappingExceptionResolver();
    JSCompatibilityRequestWrapper request = new JSCompatibilityRequestWrapper(new MockHttpServletRequest());
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act and Assert
    assertNull(adminMappingExceptionResolver.resolveException(request, response, "Handler", new Exception("foo")));
  }

  /**
   * Test
   * {@link AdminMappingExceptionResolver#resolveException(HttpServletRequest, HttpServletResponse, Object, Exception)}.
   * <ul>
   *   <li>When {@link EntityNotFoundException}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminMappingExceptionResolver#resolveException(HttpServletRequest, HttpServletResponse, Object, Exception)}
   */
  @Test
  public void testResolveException_whenEntityNotFoundException_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminMappingExceptionResolver adminMappingExceptionResolver = new AdminMappingExceptionResolver();
    JSCompatibilityRequestWrapper request = new JSCompatibilityRequestWrapper(new MockHttpServletRequest());
    MockHttpServletResponse response = new MockHttpServletResponse();
    EntityNotFoundException entityNotFoundException = mock(EntityNotFoundException.class);

    // Act and Assert
    assertNull(adminMappingExceptionResolver.resolveException(request, response, entityNotFoundException,
        new Exception("foo")));
  }

  /**
   * Test
   * {@link AdminMappingExceptionResolver#appendStackTrace(Throwable, StringBuilder)}.
   * <p>
   * Method under test:
   * {@link AdminMappingExceptionResolver#appendStackTrace(Throwable, StringBuilder)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testAppendStackTrace() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.web.handler;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass15141 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.web.handler.AdminMappingExceptionResolver adminMappingExceptionResolver;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    Throwable throwable = new Throwable();

    // Act
    adminMappingExceptionResolver.appendStackTrace(throwable, new StringBuilder("foo"));
  }

  /**
   * Test
   * {@link AdminMappingExceptionResolver#appendStackTrace(Throwable, StringBuilder)}.
   * <ul>
   *   <li>Then {@link StringBuilder#StringBuilder(String)} with {@code foo}
   * toString is a string.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminMappingExceptionResolver#appendStackTrace(Throwable, StringBuilder)}
   */
  @Test
  public void testAppendStackTrace_thenStringBuilderWithFooToStringIsAString() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminMappingExceptionResolver adminMappingExceptionResolver = new AdminMappingExceptionResolver();
    Throwable throwable = new Throwable();
    StringBuilder sb = new StringBuilder("foo");

    // Act
    adminMappingExceptionResolver.appendStackTrace(throwable, sb);

    // Assert
    assertEquals(
        "foo\r\n" + "\r\n" + "java.lang.Throwable\r\n"
            + "java.base/jdk.internal.reflect.GeneratedConstructorAccessor136.newInstance(Unknown Source)",
        sb.toString());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AdminMappingExceptionResolver#setEnableStacktrace(boolean)}
   *   <li>{@link AdminMappingExceptionResolver#setShowDebugMessage(boolean)}
   *   <li>{@link AdminMappingExceptionResolver#isEnableStacktrace()}
   *   <li>{@link AdminMappingExceptionResolver#isShowDebugMessage()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    AdminMappingExceptionResolver adminMappingExceptionResolver = new AdminMappingExceptionResolver();

    // Act
    adminMappingExceptionResolver.setEnableStacktrace(true);
    adminMappingExceptionResolver.setShowDebugMessage(true);
    boolean actualIsEnableStacktraceResult = adminMappingExceptionResolver.isEnableStacktrace();

    // Assert that nothing has changed
    assertTrue(actualIsEnableStacktraceResult);
    assertTrue(adminMappingExceptionResolver.isShowDebugMessage());
  }

  /**
   * Test new {@link AdminMappingExceptionResolver} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link AdminMappingExceptionResolver}
   */
  @Test
  public void testNewAdminMappingExceptionResolver() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    AdminMappingExceptionResolver actualAdminMappingExceptionResolver = new AdminMappingExceptionResolver();

    // Assert
    assertFalse(actualAdminMappingExceptionResolver.isEnableStacktrace());
    assertFalse(actualAdminMappingExceptionResolver.isShowDebugMessage());
    assertTrue(actualAdminMappingExceptionResolver.getStatusCodesAsMap().isEmpty());
    assertEquals(Integer.MAX_VALUE, actualAdminMappingExceptionResolver.getOrder());
  }

  /**
   * Test new {@link AdminMappingExceptionResolver} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link AdminMappingExceptionResolver}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testNewAdminMappingExceptionResolver2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.web.handler;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass15140 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.web.handler.AdminMappingExceptionResolver adminMappingExceptionResolver;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    new AdminMappingExceptionResolver();
  }
}
