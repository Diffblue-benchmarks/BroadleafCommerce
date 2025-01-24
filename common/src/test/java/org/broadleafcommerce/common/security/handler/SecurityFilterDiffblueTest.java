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
package org.broadleafcommerce.common.security.handler;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
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
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.broadleafcommerce.common.security.service.ExploitProtectionService;
import org.broadleafcommerce.common.security.service.StaleStateProtectionService;
import org.broadleafcommerce.common.web.filter.SessionlessHttpServletRequestWrapper;
import org.broadleafcommerce.common.web.util.FileSystemResponseWrapper;
import org.broadleafcommerce.common.web.util.StatusExposingServletResponse;
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
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.context.support.StandardServletEnvironment;

@ContextConfiguration(classes = {SecurityFilter.class})
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
public class SecurityFilterDiffblueTest {
  @MockBean(name = "blExploitProtectionService")
  private ExploitProtectionService exploitProtectionService;

  @Autowired
  private SecurityFilter securityFilter;

  @MockBean(name = "blStaleStateProtectionService")
  private StaleStateProtectionService staleStateProtectionService;

  /**
   * Test
   * {@link SecurityFilter#doFilterInternal(HttpServletRequest, HttpServletResponse, FilterChain)}.
   * <ul>
   *   <li>Given {@code blStaleStateProtectionService}
   * {@link StaleStateProtectionService#isEnabled()} return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SecurityFilter#doFilterInternal(HttpServletRequest, HttpServletResponse, FilterChain)}
   */
  @Test
  public void testDoFilterInternal_givenBlStaleStateProtectionServiceIsEnabledReturnFalse()
      throws IOException, ServletException {
    // Arrange
    when(staleStateProtectionService.isEnabled()).thenReturn(false);
    SessionlessHttpServletRequestWrapper request = new SessionlessHttpServletRequestWrapper(
        new MockHttpServletRequest());
    MockHttpServletResponse response = new MockHttpServletResponse();
    StatusExposingServletResponse response2 = new StatusExposingServletResponse(
        new FileSystemResponseWrapper(response, Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));
    FilterChain filterChain = mock(FilterChain.class);
    doNothing().when(filterChain).doFilter(Mockito.<ServletRequest>any(), Mockito.<ServletResponse>any());

    // Act
    securityFilter.doFilterInternal(request, response2, filterChain);

    // Assert that nothing has changed
    verify(filterChain).doFilter(isA(ServletRequest.class), isA(ServletResponse.class));
    verify(staleStateProtectionService).isEnabled();
  }

  /**
   * Test
   * {@link SecurityFilter#doFilterInternal(HttpServletRequest, HttpServletResponse, FilterChain)}.
   * <ul>
   *   <li>Then calls
   * {@link FilterChain#doFilter(ServletRequest, ServletResponse)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SecurityFilter#doFilterInternal(HttpServletRequest, HttpServletResponse, FilterChain)}
   */
  @Test
  public void testDoFilterInternal_thenCallsDoFilter() throws IOException, ServletException {
    // Arrange
    when(staleStateProtectionService.isEnabled()).thenReturn(true);
    SessionlessHttpServletRequestWrapper request = new SessionlessHttpServletRequestWrapper(
        new MockHttpServletRequest());
    MockHttpServletResponse response = new MockHttpServletResponse();
    StatusExposingServletResponse response2 = new StatusExposingServletResponse(
        new FileSystemResponseWrapper(response, Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));
    FilterChain filterChain = mock(FilterChain.class);
    doNothing().when(filterChain).doFilter(Mockito.<ServletRequest>any(), Mockito.<ServletResponse>any());

    // Act
    securityFilter.doFilterInternal(request, response2, filterChain);

    // Assert that nothing has changed
    verify(filterChain).doFilter(isA(ServletRequest.class), isA(ServletResponse.class));
    verify(staleStateProtectionService).isEnabled();
  }

  /**
   * Test
   * {@link SecurityFilter#doFilterInternal(HttpServletRequest, HttpServletResponse, FilterChain)}.
   * <ul>
   *   <li>Then throw {@link ServletException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SecurityFilter#doFilterInternal(HttpServletRequest, HttpServletResponse, FilterChain)}
   */
  @Test
  public void testDoFilterInternal_thenThrowServletException() throws IOException, ServletException {
    // Arrange
    when(staleStateProtectionService.isEnabled()).thenReturn(true);
    SessionlessHttpServletRequestWrapper request = new SessionlessHttpServletRequestWrapper(
        new MockHttpServletRequest());
    MockHttpServletResponse response = new MockHttpServletResponse();
    StatusExposingServletResponse response2 = new StatusExposingServletResponse(
        new FileSystemResponseWrapper(response, Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));
    FilterChain filterChain = mock(FilterChain.class);
    doThrow(new ServletException("An error occurred")).when(filterChain)
        .doFilter(Mockito.<ServletRequest>any(), Mockito.<ServletResponse>any());

    // Act and Assert
    assertThrows(ServletException.class, () -> securityFilter.doFilterInternal(request, response2, filterChain));
    verify(filterChain).doFilter(isA(ServletRequest.class), isA(ServletResponse.class));
    verify(staleStateProtectionService).isEnabled();
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link SecurityFilter#setExcludedRequestPatterns(List)}
   *   <li>{@link SecurityFilter#getExcludedRequestPatterns()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    SecurityFilter securityFilter = new SecurityFilter();
    ArrayList<String> excludedRequestPatterns = new ArrayList<>();

    // Act
    securityFilter.setExcludedRequestPatterns(excludedRequestPatterns);
    List<String> actualExcludedRequestPatterns = securityFilter.getExcludedRequestPatterns();

    // Assert that nothing has changed
    assertTrue(actualExcludedRequestPatterns.isEmpty());
    assertSame(excludedRequestPatterns, actualExcludedRequestPatterns);
  }

  /**
   * Test new {@link SecurityFilter} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link SecurityFilter}
   */
  @Test
  public void testNewSecurityFilter() {
    // Arrange and Act
    SecurityFilter actualSecurityFilter = new SecurityFilter();

    // Assert
    Environment environment = actualSecurityFilter.getEnvironment();
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
    assertEquals(65, systemProperties.size());
    assertEquals("11", systemProperties.get("java.specification.version"));
    String[] propertyNames = ((PropertiesPropertySource) getResult).getPropertyNames();
    assertEquals("awt.toolkit", propertyNames[2]);
    assertEquals("com.diffblue.assertionSuggestionJar", propertyNames[12]);
    assertEquals("com.diffblue.logging.directory", propertyNames[48]);
    assertEquals("com.diffblue.springIsolationJar", propertyNames[56]);
    assertEquals("cover.jar.path", propertyNames[1]);
    assertEquals("cover.main.class", propertyNames[46]);
    assertEquals("file.encoding", propertyNames[45]);
    assertEquals("gopherProxySet", propertyNames[0]);
    assertEquals("http.nonProxyHosts", propertyNames[19]);
    assertEquals("java.awt.printerjob", propertyNames[55]);
    assertEquals("java.class.path", propertyNames[6]);
    assertEquals("java.class.version", propertyNames[63]);
    assertEquals("java.io.tmpdir", propertyNames[50]);
    assertEquals("java.library.path", propertyNames[58]);
    assertEquals("java.runtime.name", propertyNames[44]);
    assertEquals("java.specification.vendor", propertyNames[24]);
    assertEquals("java.specification.version", propertyNames[3]);
    assertEquals("java.vendor", propertyNames[60]);
    assertEquals("java.vendor.url", propertyNames[10]);
    assertEquals("java.vendor.url.bug", propertyNames[49]);
    assertEquals("java.version", propertyNames[51]);
    assertEquals("java.vm.info", propertyNames[59]);
    assertEquals("java.vm.name", propertyNames[47]);
    assertEquals("java.vm.specification.name", propertyNames[54]);
    assertEquals("java.vm.specification.version", propertyNames[14]);
    assertEquals("java.vm.vendor", propertyNames[7]);
    assertEquals("java.vm.version", propertyNames[61]);
    assertEquals("jdk.debug", propertyNames[20]);
    assertEquals("mvel2.disable.jit", propertyNames[9]);
    assertEquals("org.springframework.boot.logging.LoggingSystem", propertyNames[41]);
    assertEquals("os.arch", propertyNames[53]);
    assertEquals("os.name", propertyNames[13]);
    assertEquals("os.version", propertyNames[43]);
    assertEquals("path.separator", propertyNames[42]);
    assertEquals("servletConfigInitParams", nextResult.getName());
    assertEquals("servletContextInitParams", nextResult2.getName());
    assertEquals("socksNonProxyHosts", propertyNames[Double.SIZE]);
    assertEquals("sun.arch.data.model", propertyNames[8]);
    assertEquals("sun.boot.library.path", propertyNames[17]);
    assertEquals("sun.cpu.endian", propertyNames[21]);
    assertEquals("sun.cpu.isalist", propertyNames[4]);
    assertEquals("sun.io.unicode.encoding", propertyNames[62]);
    assertEquals("sun.java.command", propertyNames[18]);
    assertEquals("sun.java.launcher", propertyNames[15]);
    assertEquals("sun.jnu.encoding", propertyNames[5]);
    assertEquals("sun.os.patch.level", propertyNames[57]);
    assertEquals("systemEnvironment", getResult2.getName());
    assertEquals("systemProperties", getResult.getName());
    assertEquals("user.country", propertyNames[Short.SIZE]);
    assertEquals("user.dir", propertyNames[52]);
    assertEquals("user.home", propertyNames[22]);
    assertEquals("user.language", propertyNames[23]);
    assertEquals("user.name", propertyNames[40]);
    assertEquals("user.timezone", propertyNames[11]);
    assertEquals("xterm-256color", systemEnvironment.get("TERM"));
    assertNull(actualSecurityFilter.getExcludedRequestPatterns());
    assertNull(actualSecurityFilter.getFilterConfig());
    assertNull(actualSecurityFilter.exploitProtectionService);
    assertNull(actualSecurityFilter.staleStateProtectionService);
    assertEquals(0, environment.getActiveProfiles().length);
    assertEquals(4, propertySources.size());
    assertEquals(4L, propertySources.spliterator().getExactSizeIfKnown());
    Object source = getResult.getSource();
    assertEquals(65, ((Map<String, Object>) source).size());
    assertEquals(65, propertyNames.length);
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
    assertArrayEquals(
        new String[]{"PATH", "MANPATH", "JAVA_HOME", "TERM", "HOMEBREW_PREFIX", "LANG", "GRADLE_HOME", "MAVEN_HOME",
            "SDKMAN_DIR", "LOGNAME", "DIFFBLUE_COMMAND", "HOMEBREW_REPOSITORY", "XPC_SERVICE_NAME", "PWD",
            "TERM_PROGRAM_VERSION", "INFOPATH", "SPRINGBOOT_HOME", "_", "SDKMAN_CANDIDATES_DIR", "__CFBundleIdentifier",
            "SHELL", "TERM_PROGRAM", "JAVA_MAIN_CLASS_17836", "SDKMAN_CANDIDATES_API", "SECURITYSESSIONID",
            "HOMEBREW_CELLAR", "SDKMAN_PLATFORM", "USER", "JAVA_MAIN_CLASS_24573", "LaunchInstanceID", "TMPDIR",
            "SSH_AUTH_SOCK", "XPC_FLAGS", "TERM_SESSION_ID", "__CF_USER_TEXT_ENCODING", "HOME", "SHLVL"},
        ((SystemEnvironmentPropertySource) getResult2).getPropertyNames());
  }
}
