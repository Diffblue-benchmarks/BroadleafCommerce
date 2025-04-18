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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import javax.imageio.metadata.IIOMetadataNode;
import org.apache.html.dom.HTMLDocumentImpl;
import org.apache.xerces.impl.xs.opti.DefaultElement;
import org.broadleafcommerce.common.extensibility.MergeXmlBeanDefinitionReader.BeanUtil;
import org.broadleafcommerce.common.extensibility.MergeXmlBeanDefinitionReader.MergeBeanDefinitionDocumentReader;
import org.broadleafcommerce.common.resource.GeneratedResource;
import org.dom4j.dom.DOMAttributeNodeMap;
import org.dom4j.dom.DOMElement;
import org.junit.Test;
import org.junit.experimental.categories.Category;
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
import org.springframework.core.env.StandardEnvironment;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.w3c.dom.Element;

public class MergeXmlBeanDefinitionReaderDiffblueTest {
  /**
   * Test BeanUtil {@link BeanUtil#isXMLBean(BeanDefinition)}.
   * <p>
   * Method under test: {@link BeanUtil#isXMLBean(BeanDefinition)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean BeanUtil.isXMLBean(BeanDefinition)"})
  public void testBeanUtilIsXMLBean() {
    // Arrange
    GenericBeanDefinition beanDefinition = new GenericBeanDefinition();
    beanDefinition.setResource(new GeneratedResource(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1},
        "The characteristics of someone or something"));

    // Act and Assert
    assertFalse(BeanUtil.isXMLBean(beanDefinition));
  }

  /**
   * Test BeanUtil {@link BeanUtil#isXMLBean(BeanDefinition)}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BeanUtil#isXMLBean(BeanDefinition)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean BeanUtil.isXMLBean(BeanDefinition)"})
  public void testBeanUtilIsXMLBean_thenReturnTrue() {
    // Arrange
    GenericBeanDefinition beanDefinition = new GenericBeanDefinition();
    beanDefinition.setResource(new GeneratedResource(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}, ".xml"));

    // Act and Assert
    assertTrue(BeanUtil.isXMLBean(beanDefinition));
  }

  /**
   * Test BeanUtil {@link BeanUtil#isXMLBean(BeanDefinition)}.
   * <ul>
   *   <li>When {@link GenericBeanDefinition#GenericBeanDefinition()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BeanUtil#isXMLBean(BeanDefinition)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean BeanUtil.isXMLBean(BeanDefinition)"})
  public void testBeanUtilIsXMLBean_whenGenericBeanDefinition_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(BeanUtil.isXMLBean(new GenericBeanDefinition()));
  }

  /**
   * Test BeanUtil {@link BeanUtil#isXMLBean(BeanDefinition)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BeanUtil#isXMLBean(BeanDefinition)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean BeanUtil.isXMLBean(BeanDefinition)"})
  public void testBeanUtilIsXMLBean_whenNull_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(BeanUtil.isXMLBean(null));
  }

  /**
   * Test MergeBeanDefinitionDocumentReader {@link MergeBeanDefinitionDocumentReader#getBeanId(Element)}.
   * <ul>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link MergeBeanDefinitionDocumentReader#getBeanId(Element)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String MergeBeanDefinitionDocumentReader.getBeanId(Element)"})
  public void testMergeBeanDefinitionDocumentReaderGetBeanId_thenReturnEmptyString() {
    // Arrange
    MergeBeanDefinitionDocumentReader mergeBeanDefinitionDocumentReader = new MergeBeanDefinitionDocumentReader();

    // Act and Assert
    assertEquals("", mergeBeanDefinitionDocumentReader.getBeanId(new IIOMetadataNode("foo")));
  }

  /**
   * Test MergeBeanDefinitionDocumentReader {@link MergeBeanDefinitionDocumentReader#isXMLBean(BeanDefinition)}.
   * <p>
   * Method under test: {@link MergeBeanDefinitionDocumentReader#isXMLBean(BeanDefinition)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MergeBeanDefinitionDocumentReader.isXMLBean(BeanDefinition)"})
  public void testMergeBeanDefinitionDocumentReaderIsXMLBean() {
    // Arrange
    MergeBeanDefinitionDocumentReader mergeBeanDefinitionDocumentReader = new MergeBeanDefinitionDocumentReader();

    GenericBeanDefinition beanDefinition = new GenericBeanDefinition();
    beanDefinition.setResource(new GeneratedResource(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1},
        "The characteristics of someone or something"));

    // Act and Assert
    assertFalse(mergeBeanDefinitionDocumentReader.isXMLBean(beanDefinition));
  }

  /**
   * Test MergeBeanDefinitionDocumentReader {@link MergeBeanDefinitionDocumentReader#isXMLBean(BeanDefinition)}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MergeBeanDefinitionDocumentReader#isXMLBean(BeanDefinition)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MergeBeanDefinitionDocumentReader.isXMLBean(BeanDefinition)"})
  public void testMergeBeanDefinitionDocumentReaderIsXMLBean_thenReturnTrue() {
    // Arrange
    MergeBeanDefinitionDocumentReader mergeBeanDefinitionDocumentReader = new MergeBeanDefinitionDocumentReader();

    GenericBeanDefinition beanDefinition = new GenericBeanDefinition();
    beanDefinition.setResource(new GeneratedResource(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}, ".xml"));

    // Act and Assert
    assertTrue(mergeBeanDefinitionDocumentReader.isXMLBean(beanDefinition));
  }

  /**
   * Test MergeBeanDefinitionDocumentReader {@link MergeBeanDefinitionDocumentReader#isXMLBean(BeanDefinition)}.
   * <ul>
   *   <li>When {@link GenericBeanDefinition#GenericBeanDefinition()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MergeBeanDefinitionDocumentReader#isXMLBean(BeanDefinition)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MergeBeanDefinitionDocumentReader.isXMLBean(BeanDefinition)"})
  public void testMergeBeanDefinitionDocumentReaderIsXMLBean_whenGenericBeanDefinition() {
    // Arrange
    MergeBeanDefinitionDocumentReader mergeBeanDefinitionDocumentReader = new MergeBeanDefinitionDocumentReader();

    // Act and Assert
    assertFalse(mergeBeanDefinitionDocumentReader.isXMLBean(new GenericBeanDefinition()));
  }

  /**
   * Test MergeBeanDefinitionDocumentReader {@link MergeBeanDefinitionDocumentReader#isXMLBean(BeanDefinition)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MergeBeanDefinitionDocumentReader#isXMLBean(BeanDefinition)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MergeBeanDefinitionDocumentReader.isXMLBean(BeanDefinition)"})
  public void testMergeBeanDefinitionDocumentReaderIsXMLBean_whenNull_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new MergeBeanDefinitionDocumentReader()).isXMLBean(null));
  }

  /**
   * Test MergeBeanDefinitionDocumentReader new {@link MergeBeanDefinitionDocumentReader} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link MergeBeanDefinitionDocumentReader}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MergeBeanDefinitionDocumentReader.<init>()"})
  public void testMergeBeanDefinitionDocumentReaderNewMergeBeanDefinitionDocumentReader() {
    // Arrange and Act
    MergeBeanDefinitionDocumentReader actualMergeBeanDefinitionDocumentReader = new MergeBeanDefinitionDocumentReader();
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
   * Test MergeBeanDefinitionDocumentReader {@link MergeBeanDefinitionDocumentReader#processBeanDefinition(Element, BeanDefinitionParserDelegate)}.
   * <ul>
   *   <li>Then calls {@link DefaultElement#getAttribute(String)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MergeBeanDefinitionDocumentReader#processBeanDefinition(Element, BeanDefinitionParserDelegate)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void MergeBeanDefinitionDocumentReader.processBeanDefinition(Element, BeanDefinitionParserDelegate)"})
  public void testMergeBeanDefinitionDocumentReaderProcessBeanDefinition_thenCallsGetAttribute() {
    // Arrange
    MergeBeanDefinitionDocumentReader mergeBeanDefinitionDocumentReader = new MergeBeanDefinitionDocumentReader();
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
   * Test {@link MergeXmlBeanDefinitionReader#MergeXmlBeanDefinitionReader(BeanDefinitionRegistry)}.
   * <p>
   * Method under test: {@link MergeXmlBeanDefinitionReader#MergeXmlBeanDefinitionReader(BeanDefinitionRegistry)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MergeXmlBeanDefinitionReader.<init>(BeanDefinitionRegistry)"})
  public void testNewMergeXmlBeanDefinitionReader() {
    // Arrange
    DefaultListableBeanFactory registry = new DefaultListableBeanFactory();

    // Act
    MergeXmlBeanDefinitionReader actualMergeXmlBeanDefinitionReader = new MergeXmlBeanDefinitionReader(registry);

    // Assert
    assertTrue(actualMergeXmlBeanDefinitionReader.getBeanNameGenerator() instanceof DefaultBeanNameGenerator);
    BeanDefinitionRegistry beanFactory = actualMergeXmlBeanDefinitionReader.getBeanFactory();
    assertTrue(beanFactory instanceof DefaultListableBeanFactory);
    assertTrue(
        actualMergeXmlBeanDefinitionReader.getNamespaceHandlerResolver() instanceof DefaultNamespaceHandlerResolver);
    assertTrue(actualMergeXmlBeanDefinitionReader.getEnvironment() instanceof StandardEnvironment);
    assertTrue(actualMergeXmlBeanDefinitionReader.getResourceLoader() instanceof PathMatchingResourcePatternResolver);
    assertNull(actualMergeXmlBeanDefinitionReader.getBeanClassLoader());
    assertEquals(1, actualMergeXmlBeanDefinitionReader.getValidationMode());
    assertFalse(actualMergeXmlBeanDefinitionReader.isNamespaceAware());
    assertSame(registry, beanFactory);
    assertSame(registry, actualMergeXmlBeanDefinitionReader.getRegistry());
  }

  /**
   * Test {@link MergeXmlBeanDefinitionReader#isXMLBean(BeanDefinition)}.
   * <p>
   * Method under test: {@link MergeXmlBeanDefinitionReader#isXMLBean(BeanDefinition)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MergeXmlBeanDefinitionReader.isXMLBean(BeanDefinition)"})
  public void testIsXMLBean() {
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
   * Method under test: {@link MergeXmlBeanDefinitionReader#isXMLBean(BeanDefinition)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MergeXmlBeanDefinitionReader.isXMLBean(BeanDefinition)"})
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
   * Method under test: {@link MergeXmlBeanDefinitionReader#isXMLBean(BeanDefinition)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MergeXmlBeanDefinitionReader.isXMLBean(BeanDefinition)"})
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
   * Method under test: {@link MergeXmlBeanDefinitionReader#isXMLBean(BeanDefinition)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MergeXmlBeanDefinitionReader.isXMLBean(BeanDefinition)"})
  public void testIsXMLBean_whenNull_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new MergeXmlBeanDefinitionReader(new DefaultListableBeanFactory())).isXMLBean(null));
  }
}
