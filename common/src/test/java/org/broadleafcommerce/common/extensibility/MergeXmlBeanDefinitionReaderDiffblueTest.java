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
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.UnsupportedEncodingException;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.imageio.metadata.IIOMetadataNode;
import org.apache.html.dom.HTMLAnchorElementImpl;
import org.apache.html.dom.HTMLDocumentImpl;
import org.apache.xerces.impl.xs.opti.DefaultElement;
import org.broadleafcommerce.common.extensibility.MergeXmlBeanDefinitionReader.BeanUtil;
import org.broadleafcommerce.common.extensibility.MergeXmlBeanDefinitionReader.MergeBeanDefinitionDocumentReader;
import org.broadleafcommerce.common.resource.GeneratedResource;
import org.dom4j.dom.DOMAttributeNodeMap;
import org.dom4j.dom.DOMElement;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.parsing.EmptyReaderEventListener;
import org.springframework.beans.factory.parsing.FailFastProblemReporter;
import org.springframework.beans.factory.parsing.NullSourceExtractor;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.DefaultBeanNameGenerator;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.beans.factory.xml.BeanDefinitionParserDelegate;
import org.springframework.beans.factory.xml.DefaultNamespaceHandlerResolver;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlReaderContext;
import org.springframework.context.annotation.ScannedGenericBeanDefinition;
import org.springframework.core.convert.support.DefaultConversionService;
import org.springframework.core.env.Environment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.core.env.PropertySource;
import org.springframework.core.env.StandardEnvironment;
import org.springframework.core.env.SystemEnvironmentPropertySource;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.ProtocolResolver;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.type.StandardAnnotationMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.StringValueResolver;
import org.w3c.dom.Element;
import org.w3c.dom.events.EventListener;

public class MergeXmlBeanDefinitionReaderDiffblueTest {
  /**
   * Test BeanUtil {@link BeanUtil#isXMLBean(BeanDefinition)}.
   * <p>
   * Method under test:
   * {@link MergeXmlBeanDefinitionReader.BeanUtil#isXMLBean(BeanDefinition)}
   */
  @Test
  public void testBeanUtilIsXMLBean() throws UnsupportedEncodingException {
    // Arrange
    MetadataReader metadataReader = mock(MetadataReader.class);
    when(metadataReader.getResource())
        .thenReturn(new GeneratedResource("AXAXAXAX".getBytes("UTF-8"), "The characteristics of someone or something"));
    Class<Object> introspectedClass = Object.class;
    when(metadataReader.getAnnotationMetadata()).thenReturn(new StandardAnnotationMetadata(introspectedClass));

    // Act
    boolean actualIsXMLBeanResult = MergeXmlBeanDefinitionReader.BeanUtil
        .isXMLBean(new ScannedGenericBeanDefinition(metadataReader));

    // Assert
    verify(metadataReader).getAnnotationMetadata();
    verify(metadataReader).getResource();
    assertFalse(actualIsXMLBeanResult);
  }

  /**
   * Test BeanUtil {@link BeanUtil#isXMLBean(BeanDefinition)}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MergeXmlBeanDefinitionReader.BeanUtil#isXMLBean(BeanDefinition)}
   */
  @Test
  public void testBeanUtilIsXMLBean_thenReturnTrue() throws UnsupportedEncodingException {
    // Arrange
    MetadataReader metadataReader = mock(MetadataReader.class);
    when(metadataReader.getResource()).thenReturn(new GeneratedResource("AXAXAXAX".getBytes("UTF-8"), ".xml"));
    Class<Object> introspectedClass = Object.class;
    when(metadataReader.getAnnotationMetadata()).thenReturn(new StandardAnnotationMetadata(introspectedClass));

    // Act
    boolean actualIsXMLBeanResult = MergeXmlBeanDefinitionReader.BeanUtil
        .isXMLBean(new ScannedGenericBeanDefinition(metadataReader));

    // Assert
    verify(metadataReader).getAnnotationMetadata();
    verify(metadataReader).getResource();
    assertTrue(actualIsXMLBeanResult);
  }

  /**
   * Test BeanUtil {@link BeanUtil#isXMLBean(BeanDefinition)}.
   * <ul>
   *   <li>When {@link GenericBeanDefinition#GenericBeanDefinition()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MergeXmlBeanDefinitionReader.BeanUtil#isXMLBean(BeanDefinition)}
   */
  @Test
  public void testBeanUtilIsXMLBean_whenGenericBeanDefinition_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(MergeXmlBeanDefinitionReader.BeanUtil.isXMLBean(new GenericBeanDefinition()));
  }

  /**
   * Test BeanUtil {@link BeanUtil#isXMLBean(BeanDefinition)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MergeXmlBeanDefinitionReader.BeanUtil#isXMLBean(BeanDefinition)}
   */
  @Test
  public void testBeanUtilIsXMLBean_whenNull_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(MergeXmlBeanDefinitionReader.BeanUtil.isXMLBean(null));
  }

  /**
   * Test MergeBeanDefinitionDocumentReader
   * {@link MergeBeanDefinitionDocumentReader#getBeanId(Element)}.
   * <p>
   * Method under test:
   * {@link MergeXmlBeanDefinitionReader.MergeBeanDefinitionDocumentReader#getBeanId(Element)}
   */
  @Test
  public void testMergeBeanDefinitionDocumentReaderGetBeanId() {
    // Arrange
    MergeXmlBeanDefinitionReader.MergeBeanDefinitionDocumentReader mergeBeanDefinitionDocumentReader = new MergeXmlBeanDefinitionReader.MergeBeanDefinitionDocumentReader();

    HTMLDocumentImpl htmlDocumentImpl = new HTMLDocumentImpl();
    htmlDocumentImpl.addEventListener("foo", mock(EventListener.class), true);

    // Act and Assert
    assertEquals("", mergeBeanDefinitionDocumentReader.getBeanId(new HTMLAnchorElementImpl(htmlDocumentImpl, "id")));
  }

  /**
   * Test MergeBeanDefinitionDocumentReader
   * {@link MergeBeanDefinitionDocumentReader#getBeanId(Element)}.
   * <p>
   * Method under test:
   * {@link MergeXmlBeanDefinitionReader.MergeBeanDefinitionDocumentReader#getBeanId(Element)}
   */
  @Test
  public void testMergeBeanDefinitionDocumentReaderGetBeanId2() {
    // Arrange
    MergeXmlBeanDefinitionReader.MergeBeanDefinitionDocumentReader mergeBeanDefinitionDocumentReader = new MergeXmlBeanDefinitionReader.MergeBeanDefinitionDocumentReader();

    HTMLDocumentImpl htmlDocumentImpl = new HTMLDocumentImpl();
    htmlDocumentImpl.addEventListener("foo", mock(EventListener.class), true);

    HTMLAnchorElementImpl ele = new HTMLAnchorElementImpl(htmlDocumentImpl, "id");
    ele.setAttribute("id", "id");

    // Act and Assert
    assertEquals("id", mergeBeanDefinitionDocumentReader.getBeanId(ele));
  }

  /**
   * Test MergeBeanDefinitionDocumentReader
   * {@link MergeBeanDefinitionDocumentReader#getBeanId(Element)}.
   * <ul>
   *   <li>Given {@code name}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MergeXmlBeanDefinitionReader.MergeBeanDefinitionDocumentReader#getBeanId(Element)}
   */
  @Test
  public void testMergeBeanDefinitionDocumentReaderGetBeanId_givenName() {
    // Arrange
    MergeXmlBeanDefinitionReader.MergeBeanDefinitionDocumentReader mergeBeanDefinitionDocumentReader = new MergeXmlBeanDefinitionReader.MergeBeanDefinitionDocumentReader();

    HTMLDocumentImpl htmlDocumentImpl = new HTMLDocumentImpl();
    htmlDocumentImpl.addEventListener("foo", mock(EventListener.class), true);

    HTMLAnchorElementImpl ele = new HTMLAnchorElementImpl(htmlDocumentImpl, "id");
    ele.setAttribute("name", "id");

    // Act and Assert
    assertEquals("id", mergeBeanDefinitionDocumentReader.getBeanId(ele));
  }

  /**
   * Test MergeBeanDefinitionDocumentReader
   * {@link MergeBeanDefinitionDocumentReader#getBeanId(Element)}.
   * <ul>
   *   <li>When {@link IIOMetadataNode#IIOMetadataNode(String)} with
   * {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MergeXmlBeanDefinitionReader.MergeBeanDefinitionDocumentReader#getBeanId(Element)}
   */
  @Test
  public void testMergeBeanDefinitionDocumentReaderGetBeanId_whenIIOMetadataNodeWithFoo() {
    // Arrange
    MergeXmlBeanDefinitionReader.MergeBeanDefinitionDocumentReader mergeBeanDefinitionDocumentReader = new MergeXmlBeanDefinitionReader.MergeBeanDefinitionDocumentReader();

    // Act and Assert
    assertEquals("", mergeBeanDefinitionDocumentReader.getBeanId(new IIOMetadataNode("foo")));
  }

  /**
   * Test MergeBeanDefinitionDocumentReader
   * {@link MergeBeanDefinitionDocumentReader#isXMLBean(BeanDefinition)}.
   * <p>
   * Method under test:
   * {@link MergeXmlBeanDefinitionReader.MergeBeanDefinitionDocumentReader#isXMLBean(BeanDefinition)}
   */
  @Test
  public void testMergeBeanDefinitionDocumentReaderIsXMLBean() throws UnsupportedEncodingException {
    // Arrange
    MergeXmlBeanDefinitionReader.MergeBeanDefinitionDocumentReader mergeBeanDefinitionDocumentReader = new MergeXmlBeanDefinitionReader.MergeBeanDefinitionDocumentReader();
    MetadataReader metadataReader = mock(MetadataReader.class);
    when(metadataReader.getResource())
        .thenReturn(new GeneratedResource("AXAXAXAX".getBytes("UTF-8"), "The characteristics of someone or something"));
    Class<Object> introspectedClass = Object.class;
    when(metadataReader.getAnnotationMetadata()).thenReturn(new StandardAnnotationMetadata(introspectedClass));

    // Act
    boolean actualIsXMLBeanResult = mergeBeanDefinitionDocumentReader
        .isXMLBean(new ScannedGenericBeanDefinition(metadataReader));

    // Assert
    verify(metadataReader).getAnnotationMetadata();
    verify(metadataReader).getResource();
    assertFalse(actualIsXMLBeanResult);
  }

  /**
   * Test MergeBeanDefinitionDocumentReader
   * {@link MergeBeanDefinitionDocumentReader#isXMLBean(BeanDefinition)}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MergeXmlBeanDefinitionReader.MergeBeanDefinitionDocumentReader#isXMLBean(BeanDefinition)}
   */
  @Test
  public void testMergeBeanDefinitionDocumentReaderIsXMLBean_thenReturnTrue() throws UnsupportedEncodingException {
    // Arrange
    MergeXmlBeanDefinitionReader.MergeBeanDefinitionDocumentReader mergeBeanDefinitionDocumentReader = new MergeXmlBeanDefinitionReader.MergeBeanDefinitionDocumentReader();
    MetadataReader metadataReader = mock(MetadataReader.class);
    when(metadataReader.getResource()).thenReturn(new GeneratedResource("AXAXAXAX".getBytes("UTF-8"), ".xml"));
    Class<Object> introspectedClass = Object.class;
    when(metadataReader.getAnnotationMetadata()).thenReturn(new StandardAnnotationMetadata(introspectedClass));

    // Act
    boolean actualIsXMLBeanResult = mergeBeanDefinitionDocumentReader
        .isXMLBean(new ScannedGenericBeanDefinition(metadataReader));

    // Assert
    verify(metadataReader).getAnnotationMetadata();
    verify(metadataReader).getResource();
    assertTrue(actualIsXMLBeanResult);
  }

  /**
   * Test MergeBeanDefinitionDocumentReader
   * {@link MergeBeanDefinitionDocumentReader#isXMLBean(BeanDefinition)}.
   * <ul>
   *   <li>When {@link GenericBeanDefinition#GenericBeanDefinition()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MergeXmlBeanDefinitionReader.MergeBeanDefinitionDocumentReader#isXMLBean(BeanDefinition)}
   */
  @Test
  public void testMergeBeanDefinitionDocumentReaderIsXMLBean_whenGenericBeanDefinition() {
    // Arrange
    MergeXmlBeanDefinitionReader.MergeBeanDefinitionDocumentReader mergeBeanDefinitionDocumentReader = new MergeXmlBeanDefinitionReader.MergeBeanDefinitionDocumentReader();

    // Act and Assert
    assertFalse(mergeBeanDefinitionDocumentReader.isXMLBean(new GenericBeanDefinition()));
  }

  /**
   * Test MergeBeanDefinitionDocumentReader
   * {@link MergeBeanDefinitionDocumentReader#isXMLBean(BeanDefinition)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MergeXmlBeanDefinitionReader.MergeBeanDefinitionDocumentReader#isXMLBean(BeanDefinition)}
   */
  @Test
  public void testMergeBeanDefinitionDocumentReaderIsXMLBean_whenNull_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new MergeXmlBeanDefinitionReader.MergeBeanDefinitionDocumentReader()).isXMLBean(null));
  }

  /**
   * Test MergeBeanDefinitionDocumentReader new
   * {@link MergeBeanDefinitionDocumentReader} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link MergeXmlBeanDefinitionReader.MergeBeanDefinitionDocumentReader}
   */
  @Test
  public void testMergeBeanDefinitionDocumentReaderNewMergeBeanDefinitionDocumentReader() {
    // Arrange and Act
    MergeXmlBeanDefinitionReader.MergeBeanDefinitionDocumentReader actualMergeBeanDefinitionDocumentReader = new MergeXmlBeanDefinitionReader.MergeBeanDefinitionDocumentReader();
    HTMLDocumentImpl doc = new HTMLDocumentImpl();
    GeneratedResource resource = new GeneratedResource();
    FailFastProblemReporter problemReporter = new FailFastProblemReporter();
    EmptyReaderEventListener eventListener = new EmptyReaderEventListener();
    NullSourceExtractor sourceExtractor = new NullSourceExtractor();
    XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(new DefaultListableBeanFactory());
    actualMergeBeanDefinitionDocumentReader.registerBeanDefinitions(doc, new XmlReaderContext(resource, problemReporter,
        eventListener, sourceExtractor, reader, new DefaultNamespaceHandlerResolver()));

    // Assert
    assertFalse(actualMergeBeanDefinitionDocumentReader.isXMLBean(null));
  }

  /**
   * Test MergeBeanDefinitionDocumentReader
   * {@link MergeBeanDefinitionDocumentReader#processBeanDefinition(Element, BeanDefinitionParserDelegate)}.
   * <ul>
   *   <li>Then calls {@link DefaultElement#getAttribute(String)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MergeXmlBeanDefinitionReader.MergeBeanDefinitionDocumentReader#processBeanDefinition(Element, BeanDefinitionParserDelegate)}
   */
  @Test
  public void testMergeBeanDefinitionDocumentReaderProcessBeanDefinition_thenCallsGetAttribute() {
    // Arrange
    MergeXmlBeanDefinitionReader.MergeBeanDefinitionDocumentReader mergeBeanDefinitionDocumentReader = new MergeXmlBeanDefinitionReader.MergeBeanDefinitionDocumentReader();
    HTMLDocumentImpl doc = new HTMLDocumentImpl();
    GeneratedResource resource = new GeneratedResource();
    FailFastProblemReporter problemReporter = new FailFastProblemReporter();
    EmptyReaderEventListener eventListener = new EmptyReaderEventListener();
    NullSourceExtractor sourceExtractor = new NullSourceExtractor();
    XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(new DefaultListableBeanFactory());
    mergeBeanDefinitionDocumentReader.registerBeanDefinitions(doc, new XmlReaderContext(resource, problemReporter,
        eventListener, sourceExtractor, reader, new DefaultNamespaceHandlerResolver()));
    DefaultElement ele = mock(DefaultElement.class);
    when(ele.getAttributes()).thenReturn(new DOMAttributeNodeMap(new DOMElement("Name")));
    when(ele.hasAttribute(Mockito.<String>any())).thenReturn(false);
    when(ele.getAttribute(Mockito.<String>any())).thenReturn("Attribute");
    when(ele.getChildNodes()).thenReturn(new IIOMetadataNode("foo"));
    GeneratedResource resource2 = new GeneratedResource();
    FailFastProblemReporter problemReporter2 = new FailFastProblemReporter();
    EmptyReaderEventListener eventListener2 = new EmptyReaderEventListener();
    NullSourceExtractor sourceExtractor2 = new NullSourceExtractor();
    XmlBeanDefinitionReader reader2 = new XmlBeanDefinitionReader(new DefaultListableBeanFactory());

    // Act
    mergeBeanDefinitionDocumentReader.processBeanDefinition(ele,
        new BeanDefinitionParserDelegate(new XmlReaderContext(resource2, problemReporter2, eventListener2,
            sourceExtractor2, reader2, new DefaultNamespaceHandlerResolver())));

    // Assert
    verify(ele, atLeast(1)).getAttribute(Mockito.<String>any());
    verify(ele, atLeast(1)).hasAttribute(Mockito.<String>any());
    verify(ele).getAttributes();
    verify(ele, atLeast(1)).getChildNodes();
  }

  /**
   * Test
   * {@link MergeXmlBeanDefinitionReader#MergeXmlBeanDefinitionReader(BeanDefinitionRegistry)}.
   * <ul>
   *   <li>Given {@link StringValueResolver}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MergeXmlBeanDefinitionReader#MergeXmlBeanDefinitionReader(BeanDefinitionRegistry)}
   */
  @Test
  public void testNewMergeXmlBeanDefinitionReader_givenStringValueResolver() {
    // Arrange
    DefaultListableBeanFactory registry = new DefaultListableBeanFactory();
    registry.addEmbeddedValueResolver(mock(StringValueResolver.class));

    // Act
    MergeXmlBeanDefinitionReader actualMergeXmlBeanDefinitionReader = new MergeXmlBeanDefinitionReader(registry);

    // Assert
    ResourceLoader resourceLoader = actualMergeXmlBeanDefinitionReader.getResourceLoader();
    ResourceLoader resourceLoader2 = ((PathMatchingResourcePatternResolver) resourceLoader).getResourceLoader();
    Collection<ProtocolResolver> protocolResolvers = ((DefaultResourceLoader) resourceLoader2).getProtocolResolvers();
    assertTrue(protocolResolvers instanceof Set);
    assertTrue(actualMergeXmlBeanDefinitionReader.getBeanNameGenerator() instanceof DefaultBeanNameGenerator);
    assertTrue(
        actualMergeXmlBeanDefinitionReader.getNamespaceHandlerResolver() instanceof DefaultNamespaceHandlerResolver);
    Environment environment = actualMergeXmlBeanDefinitionReader.getEnvironment();
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
    assertNull(actualMergeXmlBeanDefinitionReader.getBeanClassLoader());
    assertEquals(1, actualMergeXmlBeanDefinitionReader.getValidationMode());
    Stream<PropertySource<?>> streamResult = propertySources.stream();
    List<PropertySource<?>> collectResult = streamResult.limit(5).collect(Collectors.toList());
    assertEquals(2, collectResult.size());
    assertEquals(2, propertySources.size());
    assertEquals(2L, propertySources.spliterator().getExactSizeIfKnown());
    assertFalse(iteratorResult.hasNext());
    assertFalse(actualMergeXmlBeanDefinitionReader.isNamespaceAware());
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
    assertSame(registry, actualMergeXmlBeanDefinitionReader.getBeanFactory());
    assertSame(registry, actualMergeXmlBeanDefinitionReader.getRegistry());
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
   * {@link MergeXmlBeanDefinitionReader#MergeXmlBeanDefinitionReader(BeanDefinitionRegistry)}.
   * <ul>
   *   <li>When
   * {@link DefaultListableBeanFactory#DefaultListableBeanFactory()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MergeXmlBeanDefinitionReader#MergeXmlBeanDefinitionReader(BeanDefinitionRegistry)}
   */
  @Test
  public void testNewMergeXmlBeanDefinitionReader_whenDefaultListableBeanFactory() {
    // Arrange
    DefaultListableBeanFactory registry = new DefaultListableBeanFactory();

    // Act
    MergeXmlBeanDefinitionReader actualMergeXmlBeanDefinitionReader = new MergeXmlBeanDefinitionReader(registry);

    // Assert
    ResourceLoader resourceLoader = actualMergeXmlBeanDefinitionReader.getResourceLoader();
    ResourceLoader resourceLoader2 = ((PathMatchingResourcePatternResolver) resourceLoader).getResourceLoader();
    Collection<ProtocolResolver> protocolResolvers = ((DefaultResourceLoader) resourceLoader2).getProtocolResolvers();
    assertTrue(protocolResolvers instanceof Set);
    assertTrue(actualMergeXmlBeanDefinitionReader.getBeanNameGenerator() instanceof DefaultBeanNameGenerator);
    assertTrue(
        actualMergeXmlBeanDefinitionReader.getNamespaceHandlerResolver() instanceof DefaultNamespaceHandlerResolver);
    Environment environment = actualMergeXmlBeanDefinitionReader.getEnvironment();
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
    assertNull(actualMergeXmlBeanDefinitionReader.getBeanClassLoader());
    assertEquals(1, actualMergeXmlBeanDefinitionReader.getValidationMode());
    Stream<PropertySource<?>> streamResult = propertySources.stream();
    List<PropertySource<?>> collectResult = streamResult.limit(5).collect(Collectors.toList());
    assertEquals(2, collectResult.size());
    assertEquals(2, propertySources.size());
    assertEquals(2L, propertySources.spliterator().getExactSizeIfKnown());
    assertFalse(iteratorResult.hasNext());
    assertFalse(actualMergeXmlBeanDefinitionReader.isNamespaceAware());
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
    assertSame(registry, actualMergeXmlBeanDefinitionReader.getBeanFactory());
    assertSame(registry, actualMergeXmlBeanDefinitionReader.getRegistry());
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
   * Test {@link MergeXmlBeanDefinitionReader#isXMLBean(BeanDefinition)}.
   * <p>
   * Method under test:
   * {@link MergeXmlBeanDefinitionReader#isXMLBean(BeanDefinition)}
   */
  @Test
  public void testIsXMLBean() {
    // Arrange
    DefaultListableBeanFactory registry = new DefaultListableBeanFactory();
    registry.addEmbeddedValueResolver(mock(StringValueResolver.class));
    MergeXmlBeanDefinitionReader mergeXmlBeanDefinitionReader = new MergeXmlBeanDefinitionReader(registry);

    // Act and Assert
    assertFalse(mergeXmlBeanDefinitionReader.isXMLBean(new GenericBeanDefinition()));
  }

  /**
   * Test {@link MergeXmlBeanDefinitionReader#isXMLBean(BeanDefinition)}.
   * <p>
   * Method under test:
   * {@link MergeXmlBeanDefinitionReader#isXMLBean(BeanDefinition)}
   */
  @Test
  public void testIsXMLBean2() {
    // Arrange
    MergeXmlBeanDefinitionReader mergeXmlBeanDefinitionReader = new MergeXmlBeanDefinitionReader(
        new DefaultListableBeanFactory());

    GenericBeanDefinition beanDefinition = new GenericBeanDefinition();
    beanDefinition.setResource(new GeneratedResource(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1},
        "The characteristics of someone or something"));

    // Act and Assert
    assertFalse(mergeXmlBeanDefinitionReader.isXMLBean(beanDefinition));
  }

  /**
   * Test {@link MergeXmlBeanDefinitionReader#isXMLBean(BeanDefinition)}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MergeXmlBeanDefinitionReader#isXMLBean(BeanDefinition)}
   */
  @Test
  public void testIsXMLBean_thenReturnTrue() {
    // Arrange
    MergeXmlBeanDefinitionReader mergeXmlBeanDefinitionReader = new MergeXmlBeanDefinitionReader(
        new DefaultListableBeanFactory());

    GenericBeanDefinition beanDefinition = new GenericBeanDefinition();
    beanDefinition.setResource(new GeneratedResource(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}, ".xml"));

    // Act and Assert
    assertTrue(mergeXmlBeanDefinitionReader.isXMLBean(beanDefinition));
  }

  /**
   * Test {@link MergeXmlBeanDefinitionReader#isXMLBean(BeanDefinition)}.
   * <ul>
   *   <li>When {@link GenericBeanDefinition#GenericBeanDefinition()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MergeXmlBeanDefinitionReader#isXMLBean(BeanDefinition)}
   */
  @Test
  public void testIsXMLBean_whenGenericBeanDefinition_thenReturnFalse() {
    // Arrange
    MergeXmlBeanDefinitionReader mergeXmlBeanDefinitionReader = new MergeXmlBeanDefinitionReader(
        new DefaultListableBeanFactory());

    // Act and Assert
    assertFalse(mergeXmlBeanDefinitionReader.isXMLBean(new GenericBeanDefinition()));
  }

  /**
   * Test {@link MergeXmlBeanDefinitionReader#isXMLBean(BeanDefinition)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MergeXmlBeanDefinitionReader#isXMLBean(BeanDefinition)}
   */
  @Test
  public void testIsXMLBean_whenNull_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new MergeXmlBeanDefinitionReader(new DefaultListableBeanFactory())).isXMLBean(null));
  }
}
