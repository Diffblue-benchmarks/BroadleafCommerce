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
package org.broadleafcommerce.common.web.util;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.broadleafcommerce.common.web.filter.SessionlessHttpServletRequestWrapper;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.core.convert.support.DefaultConversionService;
import org.springframework.core.env.Environment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.core.env.PropertySource;
import org.springframework.core.env.StandardEnvironment;
import org.springframework.core.env.SystemEnvironmentPropertySource;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.web.context.support.StandardServletEnvironment;
import org.springframework.web.multipart.support.DefaultMultipartHttpServletRequest;

public class PrecompressedArtifactFilterDiffblueTest {
  /**
   * Test {@link PrecompressedArtifactFilter#getResourcePath(HttpServletRequest)}.
   * <p>
   * Method under test:
   * {@link PrecompressedArtifactFilter#getResourcePath(HttpServletRequest)}
   */
  @Test
  public void testGetResourcePath() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PrecompressedArtifactFilter precompressedArtifactFilter = new PrecompressedArtifactFilter();
    DefaultMultipartHttpServletRequest request = mock(DefaultMultipartHttpServletRequest.class);
    when(request.getAttribute(Mockito.<String>any())).thenReturn("javax.servlet.include.servlet_path");

    // Act
    String actualResourcePath = precompressedArtifactFilter.getResourcePath(request);

    // Assert
    verify(request, atLeast(1)).getAttribute(Mockito.<String>any());
    assertEquals("javax.servlet.include.servlet_pathjavax.servlet.include.servlet_path", actualResourcePath);
  }

  /**
   * Test {@link PrecompressedArtifactFilter#getResourcePath(HttpServletRequest)}.
   * <ul>
   *   <li>Given {@code Request}.</li>
   *   <li>Then return {@code Request}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PrecompressedArtifactFilter#getResourcePath(HttpServletRequest)}
   */
  @Test
  public void testGetResourcePath_givenRequest_thenReturnRequest() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PrecompressedArtifactFilter precompressedArtifactFilter = new PrecompressedArtifactFilter();

    MockHttpServletRequest request = new MockHttpServletRequest();
    request.setPathInfo("Request");

    // Act and Assert
    assertEquals("Request", precompressedArtifactFilter.getResourcePath(request));
  }

  /**
   * Test {@link PrecompressedArtifactFilter#getResourcePath(HttpServletRequest)}.
   * <ul>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PrecompressedArtifactFilter#getResourcePath(HttpServletRequest)}
   */
  @Test
  public void testGetResourcePath_thenReturnEmptyString() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PrecompressedArtifactFilter precompressedArtifactFilter = new PrecompressedArtifactFilter();

    // Act and Assert
    assertEquals("", precompressedArtifactFilter
        .getResourcePath(new SessionlessHttpServletRequestWrapper(new MockHttpServletRequest())));
  }

  /**
   * Test
   * {@link PrecompressedArtifactFilter#useGzipCompression(HttpServletRequest, HttpServletResponse, String, String)}.
   * <p>
   * Method under test:
   * {@link PrecompressedArtifactFilter#useGzipCompression(HttpServletRequest, HttpServletResponse, String, String)}
   */
  @Test
  public void testUseGzipCompression() throws IOException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PrecompressedArtifactFilter precompressedArtifactFilter = new PrecompressedArtifactFilter();
    SessionlessHttpServletRequestWrapper request = new SessionlessHttpServletRequestWrapper(
        mock(DefaultMultipartHttpServletRequest.class));
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act and Assert
    assertFalse(precompressedArtifactFilter.useGzipCompression(request, new StatusExposingServletResponse(
        new FileSystemResponseWrapper(response, Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile())),
        "Path", "Gzip Path"));
  }

  /**
   * Test
   * {@link PrecompressedArtifactFilter#useGzipCompression(HttpServletRequest, HttpServletResponse, String, String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PrecompressedArtifactFilter#useGzipCompression(HttpServletRequest, HttpServletResponse, String, String)}
   */
  @Test
  public void testUseGzipCompression_whenNull_thenReturnFalse() throws IOException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PrecompressedArtifactFilter precompressedArtifactFilter = new PrecompressedArtifactFilter();
    SessionlessHttpServletRequestWrapper request = new SessionlessHttpServletRequestWrapper(
        new MockHttpServletRequest());
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act and Assert
    assertFalse(precompressedArtifactFilter.useGzipCompression(request, new StatusExposingServletResponse(
        new FileSystemResponseWrapper(response, Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile())),
        "Path", null));
  }

  /**
   * Test
   * {@link PrecompressedArtifactFilter#useGzipCompression(HttpServletRequest, HttpServletResponse, String, String)}.
   * <ul>
   *   <li>When {@code Path}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PrecompressedArtifactFilter#useGzipCompression(HttpServletRequest, HttpServletResponse, String, String)}
   */
  @Test
  public void testUseGzipCompression_whenPath_thenReturnFalse() throws IOException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PrecompressedArtifactFilter precompressedArtifactFilter = new PrecompressedArtifactFilter();
    SessionlessHttpServletRequestWrapper request = new SessionlessHttpServletRequestWrapper(
        new MockHttpServletRequest());
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act and Assert
    assertFalse(precompressedArtifactFilter.useGzipCompression(request, new StatusExposingServletResponse(
        new FileSystemResponseWrapper(response, Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile())),
        "Path", "Gzip Path"));
  }

  /**
   * Test {@link PrecompressedArtifactFilter#fileExtensionInWhitelist(String)}.
   * <p>
   * Method under test:
   * {@link PrecompressedArtifactFilter#fileExtensionInWhitelist(String)}
   */
  @Test
  public void testFileExtensionInWhitelist() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PrecompressedArtifactFilter precompressedArtifactFilter = new PrecompressedArtifactFilter();
    precompressedArtifactFilter.setEnvironment(mock(StandardEnvironment.class));

    // Act and Assert
    assertFalse(precompressedArtifactFilter.fileExtensionInWhitelist("Path"));
  }

  /**
   * Test {@link PrecompressedArtifactFilter#fileExtensionInWhitelist(String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PrecompressedArtifactFilter#fileExtensionInWhitelist(String)}
   */
  @Test
  public void testFileExtensionInWhitelist_whenNull_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new PrecompressedArtifactFilter()).fileExtensionInWhitelist(null));
  }

  /**
   * Test {@link PrecompressedArtifactFilter#fileExtensionInWhitelist(String)}.
   * <ul>
   *   <li>When {@code Path}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PrecompressedArtifactFilter#fileExtensionInWhitelist(String)}
   */
  @Test
  public void testFileExtensionInWhitelist_whenPath_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new PrecompressedArtifactFilter()).fileExtensionInWhitelist("Path"));
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>
   * {@link PrecompressedArtifactFilter#setUseWhileInDefaultEnvironment(boolean)}
   *   <li>{@link PrecompressedArtifactFilter#isUseWhileInDefaultEnvironment()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    PrecompressedArtifactFilter precompressedArtifactFilter = new PrecompressedArtifactFilter();

    // Act
    precompressedArtifactFilter.setUseWhileInDefaultEnvironment(true);

    // Assert that nothing has changed
    assertTrue(precompressedArtifactFilter.isUseWhileInDefaultEnvironment());
  }

  /**
   * Test new {@link PrecompressedArtifactFilter} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link PrecompressedArtifactFilter}
   */
  @Test
  public void testNewPrecompressedArtifactFilter() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    PrecompressedArtifactFilter actualPrecompressedArtifactFilter = new PrecompressedArtifactFilter();

    // Assert
    Environment environment = actualPrecompressedArtifactFilter.getEnvironment();
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
    assertEquals("servletConfigInitParams", nextResult.getName());
    assertEquals("servletContextInitParams", nextResult2.getName());
    assertEquals("systemEnvironment", getResult2.getName());
    assertEquals("systemProperties", getResult.getName());
    assertEquals("xterm-256color", systemEnvironment.get("TERM"));
    assertNull(actualPrecompressedArtifactFilter.fileExtensionWhitelist);
    assertNull(actualPrecompressedArtifactFilter.getFilterConfig());
    assertNull(actualPrecompressedArtifactFilter.environment);
    assertEquals(0, environment.getActiveProfiles().length);
    assertEquals(4, propertySources.size());
    assertEquals(4L, propertySources.spliterator().getExactSizeIfKnown());
    assertTrue(iteratorResult.hasNext());
    assertTrue(actualPrecompressedArtifactFilter.isUseWhileInDefaultEnvironment());
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
    assertSame(systemEnvironment, getResult2.getSource());
    assertSame(nextResult, collectResult.get(0));
    assertSame(nextResult2, collectResult.get(1));
    assertArrayEquals(new String[]{"default"}, environment.getDefaultProfiles());
    assertArrayEquals(new String[]{"PATH", "MANPATH", "JAVA_HOME", "TERM", "JAVA_MAIN_CLASS_28785", "HOMEBREW_PREFIX",
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
