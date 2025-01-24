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
package org.broadleafcommerce.common.extensibility;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.apache.html.dom.HTMLDocumentImpl;
import org.broadleafcommerce.common.resource.GeneratedResource;
import org.junit.Test;
import org.springframework.beans.factory.BeanDefinitionStoreException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.DefaultBeanNameGenerator;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.beans.factory.xml.DefaultNamespaceHandlerResolver;
import org.springframework.boot.web.reactive.context.AnnotationConfigReactiveWebApplicationContext;
import org.springframework.core.convert.support.DefaultConversionService;
import org.springframework.core.env.Environment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.core.env.PropertySource;
import org.springframework.core.env.StandardEnvironment;
import org.springframework.core.env.SystemEnvironmentPropertySource;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.ProtocolResolver;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.StringValueResolver;
import org.w3c.dom.Document;

public class FrameworkXmlBeanDefinitionReaderDiffblueTest {
  /**
   * Test
   * {@link FrameworkXmlBeanDefinitionReader#FrameworkXmlBeanDefinitionReader(BeanDefinitionRegistry)}.
   * <ul>
   *   <li>Given {@link StringValueResolver}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FrameworkXmlBeanDefinitionReader#FrameworkXmlBeanDefinitionReader(BeanDefinitionRegistry)}
   */
  @Test
  public void testNewFrameworkXmlBeanDefinitionReader_givenStringValueResolver() {
    // Arrange
    DefaultListableBeanFactory registry = new DefaultListableBeanFactory();
    registry.addEmbeddedValueResolver(mock(StringValueResolver.class));

    // Act
    FrameworkXmlBeanDefinitionReader actualFrameworkXmlBeanDefinitionReader = new FrameworkXmlBeanDefinitionReader(
        registry);

    // Assert
    ResourceLoader resourceLoader = actualFrameworkXmlBeanDefinitionReader.getResourceLoader();
    ResourceLoader resourceLoader2 = ((PathMatchingResourcePatternResolver) resourceLoader).getResourceLoader();
    Collection<ProtocolResolver> protocolResolvers = ((DefaultResourceLoader) resourceLoader2).getProtocolResolvers();
    assertTrue(protocolResolvers instanceof Set);
    assertTrue(actualFrameworkXmlBeanDefinitionReader.getBeanNameGenerator() instanceof DefaultBeanNameGenerator);
    assertTrue(actualFrameworkXmlBeanDefinitionReader
        .getNamespaceHandlerResolver() instanceof DefaultNamespaceHandlerResolver);
    Environment environment = actualFrameworkXmlBeanDefinitionReader.getEnvironment();
    assertTrue(((StandardEnvironment) environment).getConversionService() instanceof DefaultConversionService);
    MutablePropertySources propertySources = ((StandardEnvironment) environment).getPropertySources();
    Iterator<PropertySource<?>> iteratorResult = propertySources.iterator();
    PropertySource<?> nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof PropertiesPropertySource);
    assertTrue(environment instanceof StandardEnvironment);
    PropertySource<?> nextResult2 = iteratorResult.next();
    assertTrue(nextResult2 instanceof SystemEnvironmentPropertySource);
    assertTrue(resourceLoader2 instanceof DefaultResourceLoader);
    assertTrue(resourceLoader instanceof PathMatchingResourcePatternResolver);
    assertTrue(((PathMatchingResourcePatternResolver) resourceLoader).getPathMatcher() instanceof AntPathMatcher);
    Map<String, Object> systemEnvironment = ((StandardEnvironment) environment).getSystemEnvironment();
    assertEquals(37, systemEnvironment.size());
    assertEquals("/opt/homebrew/share/man::", systemEnvironment.get("MANPATH"));
    Map<String, Object> systemProperties = ((StandardEnvironment) environment).getSystemProperties();
    assertEquals(Double.SIZE, systemProperties.size());
    assertEquals("11", systemProperties.get("java.specification.version"));
    assertEquals("systemEnvironment", nextResult2.getName());
    assertEquals("systemProperties", nextResult.getName());
    assertEquals("xterm-256color", systemEnvironment.get("TERM"));
    assertNull(actualFrameworkXmlBeanDefinitionReader.getBeanClassLoader());
    assertEquals(1, actualFrameworkXmlBeanDefinitionReader.getValidationMode());
    Stream<PropertySource<?>> streamResult = propertySources.stream();
    List<PropertySource<?>> collectResult = streamResult.limit(5).collect(Collectors.toList());
    assertEquals(2, collectResult.size());
    assertEquals(2, propertySources.size());
    assertEquals(2L, propertySources.spliterator().getExactSizeIfKnown());
    assertFalse(iteratorResult.hasNext());
    assertFalse(actualFrameworkXmlBeanDefinitionReader.isNamespaceAware());
    assertTrue(protocolResolvers.isEmpty());
    String expectedString = Boolean.FALSE.toString();
    assertEquals(expectedString, systemProperties.get("gopherProxySet"));
    String expectedString2 = Boolean.FALSE.toString();
    Object source = nextResult.getSource();
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
    String expectedString8 = System.getProperty("awt.toolkit");
    assertEquals(expectedString8, ((Map<String, Object>) source).get("awt.toolkit"));
    assertEquals(Double.SIZE, ((Map<String, Object>) source).size());
    assertSame(registry, actualFrameworkXmlBeanDefinitionReader.getBeanFactory());
    assertSame(registry, actualFrameworkXmlBeanDefinitionReader.getRegistry());
    assertSame(systemEnvironment, nextResult2.getSource());
    assertSame(nextResult, collectResult.get(0));
    assertSame(nextResult2, collectResult.get(1));
    assertArrayEquals(new String[]{"default"}, environment.getDefaultProfiles());
    assertArrayEquals(
        new String[]{"PATH", "MANPATH", "JAVA_HOME", "TERM", "HOMEBREW_PREFIX", "LANG", "GRADLE_HOME", "MAVEN_HOME",
            "SDKMAN_DIR", "LOGNAME", "DIFFBLUE_COMMAND", "HOMEBREW_REPOSITORY", "XPC_SERVICE_NAME", "PWD",
            "TERM_PROGRAM_VERSION", "INFOPATH", "SPRINGBOOT_HOME", "_", "SDKMAN_CANDIDATES_DIR", "__CFBundleIdentifier",
            "SHELL", "TERM_PROGRAM", "JAVA_MAIN_CLASS_17836", "SDKMAN_CANDIDATES_API", "SECURITYSESSIONID",
            "HOMEBREW_CELLAR", "SDKMAN_PLATFORM", "USER", "JAVA_MAIN_CLASS_21310", "LaunchInstanceID", "TMPDIR",
            "SSH_AUTH_SOCK", "XPC_FLAGS", "TERM_SESSION_ID", "__CF_USER_TEXT_ENCODING", "HOME", "SHLVL"},
        ((SystemEnvironmentPropertySource) nextResult2).getPropertyNames());
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
        ((PropertiesPropertySource) nextResult).getPropertyNames());
  }

  /**
   * Test
   * {@link FrameworkXmlBeanDefinitionReader#FrameworkXmlBeanDefinitionReader(BeanDefinitionRegistry)}.
   * <ul>
   *   <li>When
   * {@link DefaultListableBeanFactory#DefaultListableBeanFactory()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FrameworkXmlBeanDefinitionReader#FrameworkXmlBeanDefinitionReader(BeanDefinitionRegistry)}
   */
  @Test
  public void testNewFrameworkXmlBeanDefinitionReader_whenDefaultListableBeanFactory() {
    // Arrange
    DefaultListableBeanFactory registry = new DefaultListableBeanFactory();

    // Act
    FrameworkXmlBeanDefinitionReader actualFrameworkXmlBeanDefinitionReader = new FrameworkXmlBeanDefinitionReader(
        registry);

    // Assert
    ResourceLoader resourceLoader = actualFrameworkXmlBeanDefinitionReader.getResourceLoader();
    ResourceLoader resourceLoader2 = ((PathMatchingResourcePatternResolver) resourceLoader).getResourceLoader();
    Collection<ProtocolResolver> protocolResolvers = ((DefaultResourceLoader) resourceLoader2).getProtocolResolvers();
    assertTrue(protocolResolvers instanceof Set);
    assertTrue(actualFrameworkXmlBeanDefinitionReader.getBeanNameGenerator() instanceof DefaultBeanNameGenerator);
    assertTrue(actualFrameworkXmlBeanDefinitionReader
        .getNamespaceHandlerResolver() instanceof DefaultNamespaceHandlerResolver);
    Environment environment = actualFrameworkXmlBeanDefinitionReader.getEnvironment();
    assertTrue(((StandardEnvironment) environment).getConversionService() instanceof DefaultConversionService);
    MutablePropertySources propertySources = ((StandardEnvironment) environment).getPropertySources();
    Iterator<PropertySource<?>> iteratorResult = propertySources.iterator();
    PropertySource<?> nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof PropertiesPropertySource);
    assertTrue(environment instanceof StandardEnvironment);
    PropertySource<?> nextResult2 = iteratorResult.next();
    assertTrue(nextResult2 instanceof SystemEnvironmentPropertySource);
    assertTrue(resourceLoader2 instanceof DefaultResourceLoader);
    assertTrue(resourceLoader instanceof PathMatchingResourcePatternResolver);
    assertTrue(((PathMatchingResourcePatternResolver) resourceLoader).getPathMatcher() instanceof AntPathMatcher);
    Map<String, Object> systemEnvironment = ((StandardEnvironment) environment).getSystemEnvironment();
    assertEquals(37, systemEnvironment.size());
    assertEquals("/opt/homebrew/share/man::", systemEnvironment.get("MANPATH"));
    Map<String, Object> systemProperties = ((StandardEnvironment) environment).getSystemProperties();
    assertEquals(Double.SIZE, systemProperties.size());
    assertEquals("11", systemProperties.get("java.specification.version"));
    assertEquals("systemEnvironment", nextResult2.getName());
    assertEquals("systemProperties", nextResult.getName());
    assertEquals("xterm-256color", systemEnvironment.get("TERM"));
    assertNull(actualFrameworkXmlBeanDefinitionReader.getBeanClassLoader());
    assertEquals(1, actualFrameworkXmlBeanDefinitionReader.getValidationMode());
    Stream<PropertySource<?>> streamResult = propertySources.stream();
    List<PropertySource<?>> collectResult = streamResult.limit(5).collect(Collectors.toList());
    assertEquals(2, collectResult.size());
    assertEquals(2, propertySources.size());
    assertEquals(2L, propertySources.spliterator().getExactSizeIfKnown());
    assertFalse(iteratorResult.hasNext());
    assertFalse(actualFrameworkXmlBeanDefinitionReader.isNamespaceAware());
    assertTrue(protocolResolvers.isEmpty());
    String expectedString = Boolean.FALSE.toString();
    assertEquals(expectedString, systemProperties.get("gopherProxySet"));
    String expectedString2 = Boolean.FALSE.toString();
    Object source = nextResult.getSource();
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
    String expectedString8 = System.getProperty("awt.toolkit");
    assertEquals(expectedString8, ((Map<String, Object>) source).get("awt.toolkit"));
    assertEquals(Double.SIZE, ((Map<String, Object>) source).size());
    assertSame(registry, actualFrameworkXmlBeanDefinitionReader.getBeanFactory());
    assertSame(registry, actualFrameworkXmlBeanDefinitionReader.getRegistry());
    assertSame(systemEnvironment, nextResult2.getSource());
    assertSame(nextResult, collectResult.get(0));
    assertSame(nextResult2, collectResult.get(1));
    assertArrayEquals(new String[]{"default"}, environment.getDefaultProfiles());
    assertArrayEquals(
        new String[]{"PATH", "MANPATH", "JAVA_HOME", "TERM", "HOMEBREW_PREFIX", "LANG", "GRADLE_HOME", "MAVEN_HOME",
            "SDKMAN_DIR", "LOGNAME", "DIFFBLUE_COMMAND", "HOMEBREW_REPOSITORY", "XPC_SERVICE_NAME", "PWD",
            "TERM_PROGRAM_VERSION", "INFOPATH", "SPRINGBOOT_HOME", "_", "SDKMAN_CANDIDATES_DIR", "__CFBundleIdentifier",
            "SHELL", "TERM_PROGRAM", "JAVA_MAIN_CLASS_17836", "SDKMAN_CANDIDATES_API", "SECURITYSESSIONID",
            "HOMEBREW_CELLAR", "SDKMAN_PLATFORM", "USER", "JAVA_MAIN_CLASS_21310", "LaunchInstanceID", "TMPDIR",
            "SSH_AUTH_SOCK", "XPC_FLAGS", "TERM_SESSION_ID", "__CF_USER_TEXT_ENCODING", "HOME", "SHLVL"},
        ((SystemEnvironmentPropertySource) nextResult2).getPropertyNames());
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
        ((PropertiesPropertySource) nextResult).getPropertyNames());
  }

  /**
   * Test
   * {@link FrameworkXmlBeanDefinitionReader#registerBeanDefinitions(Document, Resource)}.
   * <p>
   * Method under test:
   * {@link FrameworkXmlBeanDefinitionReader#registerBeanDefinitions(Document, Resource)}
   */
  @Test
  public void testRegisterBeanDefinitions() throws BeanDefinitionStoreException {
    // Arrange
    FrameworkXmlBeanDefinitionReader frameworkXmlBeanDefinitionReader = new FrameworkXmlBeanDefinitionReader(
        new AnnotationConfigReactiveWebApplicationContext());
    HTMLDocumentImpl doc = new HTMLDocumentImpl();

    // Act
    int actualRegisterBeanDefinitionsResult = frameworkXmlBeanDefinitionReader.registerBeanDefinitions(doc,
        new GeneratedResource());

    // Assert
    BeanDefinitionRegistry beanFactory = frameworkXmlBeanDefinitionReader.getBeanFactory();
    assertTrue(beanFactory instanceof AnnotationConfigReactiveWebApplicationContext);
    assertEquals(0, actualRegisterBeanDefinitionsResult);
    assertEquals(0L, ((AnnotationConfigReactiveWebApplicationContext) beanFactory).getStartupDate());
  }

  /**
   * Test
   * {@link FrameworkXmlBeanDefinitionReader#registerBeanDefinitions(Document, Resource)}.
   * <p>
   * Method under test:
   * {@link FrameworkXmlBeanDefinitionReader#registerBeanDefinitions(Document, Resource)}
   */
  @Test
  public void testRegisterBeanDefinitions2() throws BeanDefinitionStoreException {
    // Arrange
    DefaultListableBeanFactory registry = new DefaultListableBeanFactory();
    registry.addEmbeddedValueResolver(mock(StringValueResolver.class));
    FrameworkXmlBeanDefinitionReader frameworkXmlBeanDefinitionReader = new FrameworkXmlBeanDefinitionReader(registry);
    HTMLDocumentImpl doc = new HTMLDocumentImpl();

    // Act and Assert
    assertEquals(0, frameworkXmlBeanDefinitionReader.registerBeanDefinitions(doc, new GeneratedResource()));
  }

  /**
   * Test
   * {@link FrameworkXmlBeanDefinitionReader#registerBeanDefinitions(Document, Resource)}.
   * <ul>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FrameworkXmlBeanDefinitionReader#registerBeanDefinitions(Document, Resource)}
   */
  @Test
  public void testRegisterBeanDefinitions_thenReturnZero() throws BeanDefinitionStoreException {
    // Arrange
    FrameworkXmlBeanDefinitionReader frameworkXmlBeanDefinitionReader = new FrameworkXmlBeanDefinitionReader(
        new DefaultListableBeanFactory());
    HTMLDocumentImpl doc = new HTMLDocumentImpl();

    // Act and Assert
    assertEquals(0, frameworkXmlBeanDefinitionReader.registerBeanDefinitions(doc, new GeneratedResource()));
  }

  /**
   * Test
   * {@link FrameworkXmlBeanDefinitionReader#isConfigurationClassBean(BeanDefinition)}.
   * <p>
   * Method under test:
   * {@link FrameworkXmlBeanDefinitionReader#isConfigurationClassBean(BeanDefinition)}
   */
  @Test
  public void testIsConfigurationClassBean() {
    // Arrange
    DefaultListableBeanFactory registry = new DefaultListableBeanFactory();
    registry.addEmbeddedValueResolver(mock(StringValueResolver.class));
    FrameworkXmlBeanDefinitionReader frameworkXmlBeanDefinitionReader = new FrameworkXmlBeanDefinitionReader(registry);

    // Act and Assert
    assertFalse(frameworkXmlBeanDefinitionReader.isConfigurationClassBean(new GenericBeanDefinition()));
  }

  /**
   * Test
   * {@link FrameworkXmlBeanDefinitionReader#isConfigurationClassBean(BeanDefinition)}.
   * <ul>
   *   <li>When {@link GenericBeanDefinition#GenericBeanDefinition()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FrameworkXmlBeanDefinitionReader#isConfigurationClassBean(BeanDefinition)}
   */
  @Test
  public void testIsConfigurationClassBean_whenGenericBeanDefinition_thenReturnFalse() {
    // Arrange
    FrameworkXmlBeanDefinitionReader frameworkXmlBeanDefinitionReader = new FrameworkXmlBeanDefinitionReader(
        new DefaultListableBeanFactory());

    // Act and Assert
    assertFalse(frameworkXmlBeanDefinitionReader.isConfigurationClassBean(new GenericBeanDefinition()));
  }

  /**
   * Test
   * {@link FrameworkXmlBeanDefinitionReader#isConfigurationClassBean(BeanDefinition)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FrameworkXmlBeanDefinitionReader#isConfigurationClassBean(BeanDefinition)}
   */
  @Test
  public void testIsConfigurationClassBean_whenNull_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue((new FrameworkXmlBeanDefinitionReader(new DefaultListableBeanFactory())).isConfigurationClassBean(null));
  }
}
