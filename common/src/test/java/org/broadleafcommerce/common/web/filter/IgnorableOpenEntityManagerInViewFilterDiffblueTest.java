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
package org.broadleafcommerce.common.web.filter;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.broadleafcommerce.common.web.util.FileSystemResponseWrapper;
import org.broadleafcommerce.common.web.util.StatusExposingServletResponse;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.core.convert.support.DefaultConversionService;
import org.springframework.core.env.Environment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.core.env.PropertySource;
import org.springframework.core.env.SystemEnvironmentPropertySource;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.web.context.support.StandardServletEnvironment;

public class IgnorableOpenEntityManagerInViewFilterDiffblueTest {
  /**
   * Test
   * {@link IgnorableOpenEntityManagerInViewFilter#doFilterInternal(HttpServletRequest, HttpServletResponse, FilterChain)}.
   * <p>
   * Method under test:
   * {@link IgnorableOpenEntityManagerInViewFilter#doFilterInternal(HttpServletRequest, HttpServletResponse, FilterChain)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testDoFilterInternal() throws IOException, ServletException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.IllegalStateException: No ServletContext
    //       at org.broadleafcommerce.common.web.filter.IgnorableOpenEntityManagerInViewFilter.doFilterInternal(IgnorableOpenEntityManagerInViewFilter.java:54)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange
    IgnorableOpenEntityManagerInViewFilter ignorableOpenEntityManagerInViewFilter = new IgnorableOpenEntityManagerInViewFilter();
    SessionlessHttpServletRequestWrapper request = new SessionlessHttpServletRequestWrapper(
        new MockHttpServletRequest());
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    ignorableOpenEntityManagerInViewFilter.doFilterInternal(request, new StatusExposingServletResponse(
        new FileSystemResponseWrapper(response, Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile())),
        mock(FilterChain.class));
  }

  /**
   * Test
   * {@link IgnorableOpenEntityManagerInViewFilter#isIgnored(HttpServletRequest, HttpServletResponse)}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link IgnorableOpenEntityManagerInViewFilter#isIgnored(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  public void testIsIgnored_thenReturnFalse() throws IOException {
    // Arrange
    IgnorableOpenEntityManagerInViewFilter ignorableOpenEntityManagerInViewFilter = new IgnorableOpenEntityManagerInViewFilter();
    SessionlessHttpServletRequestWrapper httpServletRequest = new SessionlessHttpServletRequestWrapper(
        new MockHttpServletRequest());
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act and Assert
    assertFalse(ignorableOpenEntityManagerInViewFilter.isIgnored(httpServletRequest,
        new StatusExposingServletResponse(new FileSystemResponseWrapper(response,
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()))));
  }

  /**
   * Test {@link IgnorableOpenEntityManagerInViewFilter#getOrder()}.
   * <p>
   * Method under test: {@link IgnorableOpenEntityManagerInViewFilter#getOrder()}
   */
  @Test
  public void testGetOrder() {
    // Arrange, Act and Assert
    assertEquals(FilterOrdered.PRE_SECURITY_HIGH, (new IgnorableOpenEntityManagerInViewFilter()).getOrder());
  }

  /**
   * Test new {@link IgnorableOpenEntityManagerInViewFilter} (default
   * constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link IgnorableOpenEntityManagerInViewFilter}
   */
  @Test
  public void testNewIgnorableOpenEntityManagerInViewFilter() {
    // Arrange and Act
    IgnorableOpenEntityManagerInViewFilter actualIgnorableOpenEntityManagerInViewFilter = new IgnorableOpenEntityManagerInViewFilter();

    // Assert
    Environment environment = actualIgnorableOpenEntityManagerInViewFilter.getEnvironment();
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
    assertEquals(Double.SIZE, systemProperties.size());
    assertEquals("11", systemProperties.get("java.specification.version"));
    assertEquals("com.diffblue.cover.launcher.Launcher", systemEnvironment.get("JAVA_MAIN_CLASS_27198"));
    assertEquals("servletConfigInitParams", nextResult.getName());
    assertEquals("servletContextInitParams", nextResult2.getName());
    assertEquals("systemEnvironment", getResult2.getName());
    assertEquals("systemProperties", getResult.getName());
    assertNull(actualIgnorableOpenEntityManagerInViewFilter.getFilterConfig());
    assertEquals(0, environment.getActiveProfiles().length);
    assertEquals(4, propertySources.size());
    assertEquals(4L, propertySources.spliterator().getExactSizeIfKnown());
    assertTrue(iteratorResult.hasNext());
    String expectedString = Boolean.FALSE.toString();
    assertEquals(expectedString, systemProperties.get("gopherProxySet"));
    String expectedString2 = Boolean.FALSE.toString();
    Object source = getResult.getSource();
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
    assertEquals(Double.SIZE, ((Map<String, Object>) source).size());
    assertEquals(FilterOrdered.PRE_SECURITY_HIGH, actualIgnorableOpenEntityManagerInViewFilter.getOrder());
    assertSame(systemEnvironment, getResult2.getSource());
    assertSame(nextResult, collectResult.get(0));
    assertSame(nextResult2, collectResult.get(1));
    assertArrayEquals(new String[]{"default"}, environment.getDefaultProfiles());
    assertArrayEquals(new String[]{"PATH", "MANPATH", "JAVA_HOME", "JAVA_MAIN_CLASS_27198", "TERM", "HOMEBREW_PREFIX",
        "LANG", "GRADLE_HOME", "MAVEN_HOME", "SDKMAN_DIR", "LOGNAME", "DIFFBLUE_COMMAND", "HOMEBREW_REPOSITORY",
        "XPC_SERVICE_NAME", "PWD", "TERM_PROGRAM_VERSION", "INFOPATH", "SPRINGBOOT_HOME", "_", "SDKMAN_CANDIDATES_DIR",
        "__CFBundleIdentifier", "SHELL", "TERM_PROGRAM", "JAVA_MAIN_CLASS_17836", "SDKMAN_CANDIDATES_API",
        "SECURITYSESSIONID", "HOMEBREW_CELLAR", "SDKMAN_PLATFORM", "USER", "LaunchInstanceID", "TMPDIR",
        "SSH_AUTH_SOCK", "XPC_FLAGS", "TERM_SESSION_ID", "__CF_USER_TEXT_ENCODING", "HOME", "SHLVL"},
        ((SystemEnvironmentPropertySource) getResult2).getPropertyNames());
    assertArrayEquals(new String[]{"gopherProxySet", "cover.jar.path", "awt.toolkit", "java.specification.version",
        "sun.cpu.isalist", "sun.jnu.encoding", "java.class.path", "java.vm.vendor", "sun.arch.data.model",
        "java.vendor.url", "user.timezone", "com.diffblue.assertionSuggestionJar", "os.name",
        "java.vm.specification.version", "sun.java.launcher", "user.country", "sun.boot.library.path",
        "sun.java.command", "http.nonProxyHosts", "jdk.debug", "sun.cpu.endian", "user.home", "user.language",
        "java.specification.vendor", "jdk.jar.maxSignatureFileSize", "java.version.date", "java.home", "file.separator",
        "java.vm.compressedOopsMode", "line.separator", "java.specification.name", "java.vm.specification.vendor",
        "jdk.attach.allowAttachSelf", "java.awt.graphicsenv", "java.awt.headless", "logback.configurationFile",
        "sun.management.compiler", "ftp.nonProxyHosts", "java.runtime.version", "user.name",
        "org.springframework.boot.logging.LoggingSystem", "path.separator", "os.version", "java.runtime.name",
        "file.encoding", "cover.main.class", "java.vm.name", "com.diffblue.logging.directory", "java.vendor.url.bug",
        "java.io.tmpdir", "java.version", "user.dir", "os.arch", "java.vm.specification.name", "java.awt.printerjob",
        "com.diffblue.springIsolationJar", "sun.os.patch.level", "java.library.path", "java.vm.info", "java.vendor",
        "java.vm.version", "sun.io.unicode.encoding", "java.class.version", "socksNonProxyHosts"},
        ((PropertiesPropertySource) getResult).getPropertyNames());
  }
}
