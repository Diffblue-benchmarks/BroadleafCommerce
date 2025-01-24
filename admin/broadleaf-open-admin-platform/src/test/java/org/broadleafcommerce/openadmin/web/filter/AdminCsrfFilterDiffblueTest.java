package org.broadleafcommerce.openadmin.web.filter;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import org.broadleafcommerce.common.security.service.ExploitProtectionService;
import org.broadleafcommerce.openadmin.web.compatibility.JSCompatibilityRequestWrapper;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.core.convert.support.DefaultConversionService;
import org.springframework.core.env.Environment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.core.env.PropertySource;
import org.springframework.core.env.SystemEnvironmentPropertySource;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.context.support.StandardServletEnvironment;

@ContextConfiguration(classes = {AdminCsrfFilter.class, AuthenticationFailureHandler.class})
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
public class AdminCsrfFilterDiffblueTest {
  @Autowired
  private AdminCsrfFilter adminCsrfFilter;

  @MockBean(name = "blExploitProtectionService")
  private ExploitProtectionService exploitProtectionService;

  /**
   * Test
   * {@link AdminCsrfFilter#doFilter(ServletRequest, ServletResponse, FilterChain)}.
   * <p>
   * Method under test:
   * {@link AdminCsrfFilter#doFilter(ServletRequest, ServletResponse, FilterChain)}
   */
  @Test
  public void testDoFilter() throws IOException, ServletException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminCsrfFilter adminCsrfFilter = new AdminCsrfFilter();
    JSCompatibilityRequestWrapper baseRequest = new JSCompatibilityRequestWrapper(new MockHttpServletRequest());
    MockHttpServletResponse baseResponse = new MockHttpServletResponse();
    FilterChain chain = mock(FilterChain.class);
    doNothing().when(chain).doFilter(Mockito.<ServletRequest>any(), Mockito.<ServletResponse>any());

    // Act
    adminCsrfFilter.doFilter(baseRequest, baseResponse, chain);

    // Assert that nothing has changed
    verify(chain).doFilter(isA(ServletRequest.class), isA(ServletResponse.class));
  }

  /**
   * Test
   * {@link AdminCsrfFilter#doFilter(ServletRequest, ServletResponse, FilterChain)}.
   * <p>
   * Method under test:
   * {@link AdminCsrfFilter#doFilter(ServletRequest, ServletResponse, FilterChain)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testDoFilter2() throws IOException, ServletException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   - org.springframework.security.web.authentication.AuthenticationFailureHandler
    //   when running class:
    //   package org.broadleafcommerce.openadmin.web.filter;
    //   @org.springframework.test.context.web.WebAppConfiguration
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.openadmin.web.filter.AdminCsrfFilter.class,org.springframework.security.web.authentication.AuthenticationFailureHandler.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass733 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.web.filter.AdminCsrfFilter adminCsrfFilter;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blExploitProtectionService") org.broadleafcommerce.common.security.service.ExploitProtectionService exploitProtectionService;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    JSCompatibilityRequestWrapper baseRequest = new JSCompatibilityRequestWrapper(new MockHttpServletRequest());

    // Act
    adminCsrfFilter.doFilter(baseRequest, new MockHttpServletResponse(), mock(FilterChain.class));
  }

  /**
   * Test
   * {@link AdminCsrfFilter#doFilter(ServletRequest, ServletResponse, FilterChain)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code /**}.</li>
   *   <li>Then calls
   * {@link FilterChain#doFilter(ServletRequest, ServletResponse)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminCsrfFilter#doFilter(ServletRequest, ServletResponse, FilterChain)}
   */
  @Test
  public void testDoFilter_givenArrayListAddSlashAsteriskAsterisk_thenCallsDoFilter()
      throws IOException, ServletException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ArrayList<String> excludedRequestPatterns = new ArrayList<>();
    excludedRequestPatterns.add("/**");

    AdminCsrfFilter adminCsrfFilter = new AdminCsrfFilter();
    adminCsrfFilter.setExcludedRequestPatterns(excludedRequestPatterns);

    MockHttpServletRequest baseRequest = new MockHttpServletRequest();
    baseRequest.setMethod("POST");
    MockHttpServletResponse baseResponse = new MockHttpServletResponse();
    FilterChain chain = mock(FilterChain.class);
    doNothing().when(chain).doFilter(Mockito.<ServletRequest>any(), Mockito.<ServletResponse>any());

    // Act
    adminCsrfFilter.doFilter(baseRequest, baseResponse, chain);

    // Assert
    verify(chain).doFilter(isA(ServletRequest.class), isA(ServletResponse.class));
  }

  /**
   * Test new {@link AdminCsrfFilter} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link AdminCsrfFilter}
   */
  @Test
  public void testNewAdminCsrfFilter() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    AdminCsrfFilter actualAdminCsrfFilter = new AdminCsrfFilter();

    // Assert
    Environment environment = actualAdminCsrfFilter.getEnvironment();
    assertTrue(((StandardServletEnvironment) environment).getConversionService() instanceof DefaultConversionService);
    MutablePropertySources propertySources = ((StandardServletEnvironment) environment).getPropertySources();
    Stream<PropertySource<?>> streamResult = propertySources.stream();
    List<PropertySource<?>> collectResult = streamResult.limit(5).collect(Collectors.toList());
    assertEquals(4, collectResult.size());
    PropertySource<?> getResult = collectResult.get(2);
    assertTrue(getResult instanceof PropertiesPropertySource);
    Iterator<PropertySource<?>> iteratorResult = propertySources.iterator();
    PropertySource<?> nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof PropertySource.StubPropertySource);
    PropertySource<?> nextResult2 = iteratorResult.next();
    assertTrue(nextResult2 instanceof PropertySource.StubPropertySource);
    PropertySource<?> getResult2 = collectResult.get(3);
    assertTrue(getResult2 instanceof SystemEnvironmentPropertySource);
    assertTrue(environment instanceof StandardServletEnvironment);
    Map<String, Object> systemEnvironment = ((StandardServletEnvironment) environment).getSystemEnvironment();
    assertEquals(37, systemEnvironment.size());
    assertEquals("/opt/homebrew/share/man::", systemEnvironment.get("MANPATH"));
    Map<String, Object> systemProperties = ((StandardServletEnvironment) environment).getSystemProperties();
    assertEquals(66, systemProperties.size());
    assertEquals("11", systemProperties.get("java.specification.version"));
    String[] propertyNames = ((PropertiesPropertySource) getResult).getPropertyNames();
    assertEquals("awt.toolkit", propertyNames[2]);
    assertEquals("com.diffblue.assertionSuggestionJar", propertyNames[13]);
    assertEquals("com.diffblue.logging.directory", propertyNames[49]);
    assertEquals("com.diffblue.springIsolationJar", propertyNames[57]);
    assertEquals("cover.jar.path", propertyNames[1]);
    assertEquals("cover.main.class", propertyNames[47]);
    assertEquals("file.encoding", propertyNames[46]);
    assertEquals("gopherProxySet", propertyNames[0]);
    assertEquals("http.nonProxyHosts", propertyNames[20]);
    assertEquals("java.awt.printerjob", propertyNames[56]);
    assertEquals("java.class.path", propertyNames[6]);
    assertEquals("java.class.version", propertyNames[Double.SIZE]);
    assertEquals("java.io.tmpdir", propertyNames[51]);
    assertEquals("java.library.path", propertyNames[59]);
    assertEquals("java.runtime.name", propertyNames[45]);
    assertEquals("java.specification.version", propertyNames[3]);
    assertEquals("java.vendor", propertyNames[61]);
    assertEquals("java.vendor.url", propertyNames[11]);
    assertEquals("java.vendor.url.bug", propertyNames[50]);
    assertEquals("java.version", propertyNames[52]);
    assertEquals("java.vm.info", propertyNames[60]);
    assertEquals("java.vm.name", propertyNames[48]);
    assertEquals("java.vm.specification.name", propertyNames[55]);
    assertEquals("java.vm.specification.version", propertyNames[15]);
    assertEquals("java.vm.vendor", propertyNames[8]);
    assertEquals("java.vm.version", propertyNames[62]);
    assertEquals("jdk.debug", propertyNames[21]);
    assertEquals("org.springframework.boot.logging.LoggingSystem", propertyNames[42]);
    assertEquals("os.arch", propertyNames[54]);
    assertEquals("os.name", propertyNames[14]);
    assertEquals("os.version", propertyNames[44]);
    assertEquals("path.separator", propertyNames[43]);
    assertEquals("servletConfigInitParams", nextResult.getName());
    assertEquals("servletContextInitParams", nextResult2.getName());
    assertEquals("socksNonProxyHosts", propertyNames[65]);
    assertEquals("sun.arch.data.model", propertyNames[9]);
    assertEquals("sun.awt.enableExtraMouseButtons", propertyNames[7]);
    assertEquals("sun.boot.library.path", propertyNames[18]);
    assertEquals("sun.cpu.endian", propertyNames[22]);
    assertEquals("sun.cpu.isalist", propertyNames[4]);
    assertEquals("sun.font.fontmanager", propertyNames[10]);
    assertEquals("sun.io.unicode.encoding", propertyNames[63]);
    assertEquals("sun.java.command", propertyNames[19]);
    assertEquals("sun.java.launcher", propertyNames[Short.SIZE]);
    assertEquals("sun.jnu.encoding", propertyNames[5]);
    assertEquals("sun.os.patch.level", propertyNames[58]);
    assertEquals("systemEnvironment", getResult2.getName());
    assertEquals("systemProperties", getResult.getName());
    assertEquals("user.country", propertyNames[17]);
    assertEquals("user.dir", propertyNames[53]);
    assertEquals("user.home", propertyNames[23]);
    assertEquals("user.language", propertyNames[24]);
    assertEquals("user.name", propertyNames[41]);
    assertEquals("user.timezone", propertyNames[12]);
    assertEquals("xterm-256color", systemEnvironment.get("TERM"));
    assertNull(actualAdminCsrfFilter.getExcludedRequestPatterns());
    assertNull(actualAdminCsrfFilter.getFilterConfig());
    assertNull(actualAdminCsrfFilter.failureHandler);
    assertEquals(0, environment.getActiveProfiles().length);
    assertEquals(4, propertySources.size());
    assertEquals(4L, propertySources.spliterator().getExactSizeIfKnown());
    Object source = getResult.getSource();
    assertEquals(66, ((Map<String, Object>) source).size());
    assertEquals(66, propertyNames.length);
    assertTrue(iteratorResult.hasNext());
    String expectedString = Boolean.FALSE.toString();
    assertEquals(expectedString, systemProperties.get("gopherProxySet"));
    String expectedString2 = Boolean.FALSE.toString();
    assertEquals(expectedString2, ((Map<String, Object>) source).get("gopherProxySet"));
    String expectedString3 = Paths.get(System.getProperty("user.home"), ".sdkman", "candidates", "java", "current")
        .toString();
    assertEquals(expectedString3, systemEnvironment.get("JAVA_HOME"));
    String expectedString4 = Paths
        .get(System.getProperty("user.home"), "Documents", "dcover", "diffblue-cover-cli-2024.10.02",
            "cover-service-analyzer.jar")
        .toString();
    assertEquals(expectedString4, systemProperties.get("cover.jar.path"));
    String expectedString5 = Paths
        .get(System.getProperty("user.home"), "Documents", "dcover", "diffblue-cover-cli-2024.10.02",
            "cover-service-analyzer.jar")
        .toString();
    assertEquals(expectedString5, ((Map<String, Object>) source).get("cover.jar.path"));
    String toStringResult = Paths.get(System.getProperty("user.home"), ".docker", "bin").toString();
    String toStringResult2 = Paths
        .get(System.getProperty("user.home"), ".sdkman", "candidates", "springboot", "current", "bin")
        .toString();
    String toStringResult3 = Paths
        .get(System.getProperty("user.home"), ".sdkman", "candidates", "maven", "current", "bin")
        .toString();
    String toStringResult4 = Paths
        .get(System.getProperty("user.home"), ".sdkman", "candidates", "java", "current", "bin")
        .toString();
    String toStringResult5 = Paths
        .get(System.getProperty("user.home"), ".sdkman", "candidates", "gradle", "current", "bin")
        .toString();
    String expectedString6 = String.join("", toStringResult, ":", toStringResult2, ":", toStringResult3, ":",
        toStringResult4, ":", toStringResult5,
        ":/opt/homebrew/bin:/opt/homebrew/sbin:/usr/local/bin:/System/Cryptexes/App/usr/bin:/usr/bin:/bin:/usr"
            + "/sbin:/sbin:/var/run/com.apple.security.cryptexd/codex.system/bootstrap/usr/local/bin:/var/run/com"
            + ".apple.security.cryptexd/codex.system/bootstrap/usr/bin:/var/run/com.apple.security.cryptexd/codex"
            + ".system/bootstrap/usr/appleinternal/bin:",
        Paths.get(System.getProperty("user.home"), "Library", "Python", "3.9", "bin").toString());
    assertEquals(expectedString6, systemEnvironment.get("PATH"));
    String expectedString7 = System.getProperty("awt.toolkit");
    assertEquals(expectedString7, systemProperties.get("awt.toolkit"));
    assertSame(systemEnvironment, getResult2.getSource());
    assertSame(nextResult, collectResult.get(0));
    assertSame(nextResult2, collectResult.get(1));
    assertArrayEquals(new String[]{"default"}, environment.getDefaultProfiles());
    assertArrayEquals(new String[]{"PATH", "MANPATH", "JAVA_HOME", "TERM", "HOMEBREW_PREFIX", "LANG", "GRADLE_HOME",
        "MAVEN_HOME", "JAVA_MAIN_CLASS_71589", "SDKMAN_DIR", "LOGNAME", "DIFFBLUE_COMMAND", "HOMEBREW_REPOSITORY",
        "XPC_SERVICE_NAME", "PWD", "TERM_PROGRAM_VERSION", "INFOPATH", "SPRINGBOOT_HOME", "_", "SDKMAN_CANDIDATES_DIR",
        "__CFBundleIdentifier", "SHELL", "TERM_PROGRAM", "JAVA_MAIN_CLASS_17836", "SDKMAN_CANDIDATES_API",
        "SECURITYSESSIONID", "HOMEBREW_CELLAR", "SDKMAN_PLATFORM", "USER", "LaunchInstanceID", "TMPDIR",
        "SSH_AUTH_SOCK", "XPC_FLAGS", "TERM_SESSION_ID", "__CF_USER_TEXT_ENCODING", "HOME", "SHLVL"},
        ((SystemEnvironmentPropertySource) getResult2).getPropertyNames());
  }

  /**
   * Test new {@link AdminCsrfFilter} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link AdminCsrfFilter}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testNewAdminCsrfFilter2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   - org.springframework.security.web.authentication.AuthenticationFailureHandler
    //   when running class:
    //   package org.broadleafcommerce.openadmin.web.filter;
    //   @org.springframework.test.context.web.WebAppConfiguration
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.openadmin.web.filter.AdminCsrfFilter.class,org.springframework.security.web.authentication.AuthenticationFailureHandler.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass732 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.web.filter.AdminCsrfFilter adminCsrfFilter;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blExploitProtectionService") org.broadleafcommerce.common.security.service.ExploitProtectionService exploitProtectionService;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    new AdminCsrfFilter();
  }
}
