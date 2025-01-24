package org.broadleafcommerce.core.web.config;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.broadleafcommerce.common.security.util.GenericCookieUtilsImpl;
import org.broadleafcommerce.core.rule.RuleDTOConfig;
import org.broadleafcommerce.core.web.cookie.CookieRuleFilter;
import org.broadleafcommerce.core.web.cookie.CookieRuleRequestProcessor;
import org.broadleafcommerce.core.web.seo.BasicSeoPropertyGeneratorImpl;
import org.broadleafcommerce.core.web.seo.SeoPropertyGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.ListFactoryBean;
import org.springframework.boot.web.servlet.filter.OrderedRequestContextFilter;
import org.springframework.core.convert.support.DefaultConversionService;
import org.springframework.core.env.Environment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.core.env.PropertySource;
import org.springframework.core.env.SystemEnvironmentPropertySource;
import org.springframework.web.context.support.StandardServletEnvironment;
import org.springframework.web.filter.RequestContextFilter;

class FrameworkWebConfigDiffblueTest {
  /**
   * Test {@link FrameworkWebConfig#blRequestContextFilter()}.
   * <p>
   * Method under test: {@link FrameworkWebConfig#blRequestContextFilter()}
   */
  @Test
  @DisplayName("Test blRequestContextFilter()")
  void testBlRequestContextFilter() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    RequestContextFilter actualBlRequestContextFilterResult = (new FrameworkWebConfig()).blRequestContextFilter();

    // Assert
    assertTrue(actualBlRequestContextFilterResult instanceof OrderedRequestContextFilter);
    Environment environment = actualBlRequestContextFilterResult.getEnvironment();
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
    assertNull(actualBlRequestContextFilterResult.getFilterConfig());
    assertEquals(-1001000, ((OrderedRequestContextFilter) actualBlRequestContextFilterResult).getOrder());
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
    assertSame(systemEnvironment, getResult2.getSource());
    assertSame(nextResult, collectResult.get(0));
    assertSame(nextResult2, collectResult.get(1));
    assertArrayEquals(new String[]{"default"}, environment.getDefaultProfiles());
    assertArrayEquals(new String[]{"PATH", "MANPATH", "JAVA_HOME", "TERM", "HOMEBREW_PREFIX", "LANG", "GRADLE_HOME",
        "MAVEN_HOME", "SDKMAN_DIR", "LOGNAME", "DIFFBLUE_COMMAND", "HOMEBREW_REPOSITORY", "JAVA_MAIN_CLASS_56008",
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

  /**
   * Test
   * {@link FrameworkWebConfig#blSeoPropertyGenerators(BasicSeoPropertyGeneratorImpl)}.
   * <ul>
   *   <li>Then first return {@link BasicSeoPropertyGeneratorImpl}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FrameworkWebConfig#blSeoPropertyGenerators(BasicSeoPropertyGeneratorImpl)}
   */
  @Test
  @DisplayName("Test blSeoPropertyGenerators(BasicSeoPropertyGeneratorImpl); then first return BasicSeoPropertyGeneratorImpl")
  void testBlSeoPropertyGenerators_thenFirstReturnBasicSeoPropertyGeneratorImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FrameworkWebConfig frameworkWebConfig = new FrameworkWebConfig();
    BasicSeoPropertyGeneratorImpl basicSeo = new BasicSeoPropertyGeneratorImpl();

    // Act
    List<SeoPropertyGenerator> actualBlSeoPropertyGeneratorsResult = frameworkWebConfig
        .blSeoPropertyGenerators(basicSeo);

    // Assert
    assertEquals(1, actualBlSeoPropertyGeneratorsResult.size());
    SeoPropertyGenerator getResult = actualBlSeoPropertyGeneratorsResult.get(0);
    assertTrue(getResult instanceof BasicSeoPropertyGeneratorImpl);
    assertSame(basicSeo, getResult);
  }

  /**
   * Test
   * {@link FrameworkWebConfig#blSeoPropertyGenerators(BasicSeoPropertyGeneratorImpl)}.
   * <ul>
   *   <li>Then return first is {@link BasicSeoPropertyGeneratorImpl}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FrameworkWebConfig#blSeoPropertyGenerators(BasicSeoPropertyGeneratorImpl)}
   */
  @Test
  @DisplayName("Test blSeoPropertyGenerators(BasicSeoPropertyGeneratorImpl); then return first is BasicSeoPropertyGeneratorImpl")
  void testBlSeoPropertyGenerators_thenReturnFirstIsBasicSeoPropertyGeneratorImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicSeoPropertyGeneratorImpl basicSeo = mock(BasicSeoPropertyGeneratorImpl.class);

    // Act
    List<SeoPropertyGenerator> actualBlSeoPropertyGeneratorsResult = (new FrameworkWebConfig())
        .blSeoPropertyGenerators(basicSeo);

    // Assert
    assertEquals(1, actualBlSeoPropertyGeneratorsResult.size());
    assertSame(basicSeo, actualBlSeoPropertyGeneratorsResult.get(0));
  }

  /**
   * Test {@link FrameworkWebConfig#blCookieRuleConfigs()}.
   * <p>
   * Method under test: {@link FrameworkWebConfig#blCookieRuleConfigs()}
   */
  @Test
  @DisplayName("Test blCookieRuleConfigs()")
  void testBlCookieRuleConfigs() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    ListFactoryBean actualBlCookieRuleConfigsResult = (new FrameworkWebConfig()).blCookieRuleConfigs();

    // Assert
    assertTrue(actualBlCookieRuleConfigsResult.isSingleton());
    Class<List> expectedObjectType = List.class;
    assertEquals(expectedObjectType, actualBlCookieRuleConfigsResult.getObjectType());
  }

  /**
   * Test
   * {@link FrameworkWebConfig#blCookieRuleFilter(CookieRuleRequestProcessor)}.
   * <p>
   * Method under test:
   * {@link FrameworkWebConfig#blCookieRuleFilter(CookieRuleRequestProcessor)}
   */
  @Test
  @DisplayName("Test blCookieRuleFilter(CookieRuleRequestProcessor)")
  void testBlCookieRuleFilter() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FrameworkWebConfig frameworkWebConfig = new FrameworkWebConfig();
    ArrayList<RuleDTOConfig> configs = new ArrayList<>();

    // Act
    CookieRuleFilter actualBlCookieRuleFilterResult = frameworkWebConfig
        .blCookieRuleFilter(new CookieRuleRequestProcessor(configs, new GenericCookieUtilsImpl()));

    // Assert
    Environment environment = actualBlCookieRuleFilterResult.getEnvironment();
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
    assertNull(actualBlCookieRuleFilterResult.getFilterConfig());
    assertEquals(0, environment.getActiveProfiles().length);
    assertEquals(1000000, actualBlCookieRuleFilterResult.getOrder());
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
    assertSame(systemEnvironment, getResult2.getSource());
    assertSame(nextResult, collectResult.get(0));
    assertSame(nextResult2, collectResult.get(1));
    assertArrayEquals(new String[]{"default"}, environment.getDefaultProfiles());
    assertArrayEquals(new String[]{"PATH", "MANPATH", "JAVA_HOME", "TERM", "HOMEBREW_PREFIX", "LANG", "GRADLE_HOME",
        "MAVEN_HOME", "SDKMAN_DIR", "LOGNAME", "DIFFBLUE_COMMAND", "HOMEBREW_REPOSITORY", "JAVA_MAIN_CLASS_56008",
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

  /**
   * Test
   * {@link FrameworkWebConfig#blCookieRuleFilter(CookieRuleRequestProcessor)}.
   * <p>
   * Method under test:
   * {@link FrameworkWebConfig#blCookieRuleFilter(CookieRuleRequestProcessor)}
   */
  @Test
  @DisplayName("Test blCookieRuleFilter(CookieRuleRequestProcessor)")
  void testBlCookieRuleFilter2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FrameworkWebConfig frameworkWebConfig = new FrameworkWebConfig();

    // Act
    CookieRuleFilter actualBlCookieRuleFilterResult = frameworkWebConfig
        .blCookieRuleFilter(new CookieRuleRequestProcessor(new ArrayList<>(), mock(GenericCookieUtilsImpl.class)));

    // Assert
    Environment environment = actualBlCookieRuleFilterResult.getEnvironment();
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
    assertNull(actualBlCookieRuleFilterResult.getFilterConfig());
    assertEquals(0, environment.getActiveProfiles().length);
    assertEquals(1000000, actualBlCookieRuleFilterResult.getOrder());
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
    assertSame(systemEnvironment, getResult2.getSource());
    assertSame(nextResult, collectResult.get(0));
    assertSame(nextResult2, collectResult.get(1));
    assertArrayEquals(new String[]{"default"}, environment.getDefaultProfiles());
    assertArrayEquals(new String[]{"PATH", "MANPATH", "JAVA_HOME", "TERM", "HOMEBREW_PREFIX", "LANG", "GRADLE_HOME",
        "MAVEN_HOME", "SDKMAN_DIR", "LOGNAME", "DIFFBLUE_COMMAND", "HOMEBREW_REPOSITORY", "JAVA_MAIN_CLASS_56008",
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
