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
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.UnsupportedEncodingException;
import javax.imageio.metadata.IIOMetadataNode;
import org.apache.html.dom.HTMLAnchorElementImpl;
import org.apache.html.dom.HTMLDocumentImpl;
import org.apache.xerces.impl.xs.opti.DefaultElement;
import org.broadleafcommerce.common.resource.GeneratedResource;
import org.dom4j.dom.DOMAttributeNodeMap;
import org.dom4j.dom.DOMElement;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.parsing.EmptyReaderEventListener;
import org.springframework.beans.factory.parsing.FailFastProblemReporter;
import org.springframework.beans.factory.parsing.NullSourceExtractor;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.beans.factory.xml.BeanDefinitionParserDelegate;
import org.springframework.beans.factory.xml.DefaultNamespaceHandlerResolver;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlReaderContext;
import org.springframework.context.annotation.ScannedGenericBeanDefinition;
import org.springframework.core.type.StandardAnnotationMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.util.StringValueResolver;
import org.w3c.dom.Element;
import org.w3c.dom.events.EventListener;

public class MergeXmlBeanDefinitionReaderDiffblueTest {
  /**
   * Method under test:
   * {@link MergeXmlBeanDefinitionReader.BeanUtil#isXMLBean(BeanDefinition)}
   */
  @Test
  public void testBeanUtilIsXMLBean() {
    // Arrange, Act and Assert
    assertFalse(MergeXmlBeanDefinitionReader.BeanUtil.isXMLBean(new GenericBeanDefinition()));
    assertFalse(MergeXmlBeanDefinitionReader.BeanUtil.isXMLBean(null));
  }

  /**
   * Method under test:
   * {@link MergeXmlBeanDefinitionReader.BeanUtil#isXMLBean(BeanDefinition)}
   */
  @Test
  public void testBeanUtilIsXMLBean2() throws UnsupportedEncodingException {
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
   * Method under test:
   * {@link MergeXmlBeanDefinitionReader.BeanUtil#isXMLBean(BeanDefinition)}
   */
  @Test
  public void testBeanUtilIsXMLBean3() throws UnsupportedEncodingException {
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
   * Method under test:
   * {@link MergeXmlBeanDefinitionReader#isXMLBean(BeanDefinition)}
   */
  @Test
  public void testIsXMLBean() {
    // Arrange
    MergeXmlBeanDefinitionReader mergeXmlBeanDefinitionReader = new MergeXmlBeanDefinitionReader(
        new DefaultListableBeanFactory());

    // Act and Assert
    assertFalse(mergeXmlBeanDefinitionReader.isXMLBean(new GenericBeanDefinition()));
  }

  /**
   * Method under test:
   * {@link MergeXmlBeanDefinitionReader#isXMLBean(BeanDefinition)}
   */
  @Test
  public void testIsXMLBean2() {
    // Arrange
    DefaultListableBeanFactory registry = new DefaultListableBeanFactory();
    registry.addEmbeddedValueResolver(mock(StringValueResolver.class));
    MergeXmlBeanDefinitionReader mergeXmlBeanDefinitionReader = new MergeXmlBeanDefinitionReader(registry);

    // Act and Assert
    assertFalse(mergeXmlBeanDefinitionReader.isXMLBean(new GenericBeanDefinition()));
  }

  /**
   * Method under test:
   * {@link MergeXmlBeanDefinitionReader#isXMLBean(BeanDefinition)}
   */
  @Test
  public void testIsXMLBean3() {
    // Arrange, Act and Assert
    assertFalse((new MergeXmlBeanDefinitionReader(new DefaultListableBeanFactory())).isXMLBean(null));
  }

  /**
   * Method under test:
   * {@link MergeXmlBeanDefinitionReader#isXMLBean(BeanDefinition)}
   */
  @Test
  public void testIsXMLBean4() {
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
   * Method under test:
   * {@link MergeXmlBeanDefinitionReader#isXMLBean(BeanDefinition)}
   */
  @Test
  public void testIsXMLBean5() {
    // Arrange
    MergeXmlBeanDefinitionReader mergeXmlBeanDefinitionReader = new MergeXmlBeanDefinitionReader(
        new DefaultListableBeanFactory());

    GenericBeanDefinition beanDefinition = new GenericBeanDefinition();
    beanDefinition.setResource(new GeneratedResource(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}, ".xml"));

    // Act and Assert
    assertTrue(mergeXmlBeanDefinitionReader.isXMLBean(beanDefinition));
  }

  /**
   * Method under test:
   * {@link MergeXmlBeanDefinitionReader.MergeBeanDefinitionDocumentReader#getBeanId(Element)}
   */
  @Test
  public void testMergeBeanDefinitionDocumentReaderGetBeanId() {
    // Arrange
    MergeXmlBeanDefinitionReader.MergeBeanDefinitionDocumentReader mergeBeanDefinitionDocumentReader = new MergeXmlBeanDefinitionReader.MergeBeanDefinitionDocumentReader();

    // Act and Assert
    assertEquals("", mergeBeanDefinitionDocumentReader.getBeanId(new IIOMetadataNode("foo")));
  }

  /**
   * Method under test:
   * {@link MergeXmlBeanDefinitionReader.MergeBeanDefinitionDocumentReader#getBeanId(Element)}
   */
  @Test
  public void testMergeBeanDefinitionDocumentReaderGetBeanId2() {
    // Arrange
    MergeXmlBeanDefinitionReader.MergeBeanDefinitionDocumentReader mergeBeanDefinitionDocumentReader = new MergeXmlBeanDefinitionReader.MergeBeanDefinitionDocumentReader();

    HTMLDocumentImpl htmlDocumentImpl = new HTMLDocumentImpl();
    htmlDocumentImpl.addEventListener("foo", mock(EventListener.class), true);

    // Act and Assert
    assertEquals("", mergeBeanDefinitionDocumentReader.getBeanId(new HTMLAnchorElementImpl(htmlDocumentImpl, "id")));
  }

  /**
   * Method under test:
   * {@link MergeXmlBeanDefinitionReader.MergeBeanDefinitionDocumentReader#getBeanId(Element)}
   */
  @Test
  public void testMergeBeanDefinitionDocumentReaderGetBeanId3() {
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
   * Method under test:
   * {@link MergeXmlBeanDefinitionReader.MergeBeanDefinitionDocumentReader#getBeanId(Element)}
   */
  @Test
  public void testMergeBeanDefinitionDocumentReaderGetBeanId4() {
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
   * Method under test:
   * {@link MergeXmlBeanDefinitionReader.MergeBeanDefinitionDocumentReader#isXMLBean(BeanDefinition)}
   */
  @Test
  public void testMergeBeanDefinitionDocumentReaderIsXMLBean() {
    // Arrange
    MergeXmlBeanDefinitionReader.MergeBeanDefinitionDocumentReader mergeBeanDefinitionDocumentReader = new MergeXmlBeanDefinitionReader.MergeBeanDefinitionDocumentReader();

    // Act and Assert
    assertFalse(mergeBeanDefinitionDocumentReader.isXMLBean(new GenericBeanDefinition()));
  }

  /**
   * Method under test:
   * {@link MergeXmlBeanDefinitionReader.MergeBeanDefinitionDocumentReader#isXMLBean(BeanDefinition)}
   */
  @Test
  public void testMergeBeanDefinitionDocumentReaderIsXMLBean2() {
    // Arrange, Act and Assert
    assertFalse((new MergeXmlBeanDefinitionReader.MergeBeanDefinitionDocumentReader()).isXMLBean(null));
  }

  /**
   * Method under test:
   * {@link MergeXmlBeanDefinitionReader.MergeBeanDefinitionDocumentReader#isXMLBean(BeanDefinition)}
   */
  @Test
  public void testMergeBeanDefinitionDocumentReaderIsXMLBean3() throws UnsupportedEncodingException {
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
   * Method under test:
   * {@link MergeXmlBeanDefinitionReader.MergeBeanDefinitionDocumentReader#isXMLBean(BeanDefinition)}
   */
  @Test
  public void testMergeBeanDefinitionDocumentReaderIsXMLBean4() throws UnsupportedEncodingException {
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
   * Method under test:
   * {@link MergeXmlBeanDefinitionReader.MergeBeanDefinitionDocumentReader#processBeanDefinition(Element, BeanDefinitionParserDelegate)}
   */
  @Test
  public void testMergeBeanDefinitionDocumentReaderProcessBeanDefinition() {
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
}
