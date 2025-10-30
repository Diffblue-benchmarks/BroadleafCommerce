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
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.apache.html.dom.HTMLDocumentImpl;
import org.broadleafcommerce.common.resource.GeneratedResource;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.springframework.beans.factory.BeanDefinitionStoreException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.DefaultBeanNameGenerator;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.beans.factory.xml.DefaultNamespaceHandlerResolver;
import org.springframework.boot.web.reactive.context.AnnotationConfigReactiveWebApplicationContext;
import org.springframework.core.env.StandardEnvironment;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.w3c.dom.Document;

public class FrameworkXmlBeanDefinitionReaderDiffblueTest {
  /**
   * Test {@link FrameworkXmlBeanDefinitionReader#FrameworkXmlBeanDefinitionReader(BeanDefinitionRegistry)}.
   * <p>
   * Method under test: {@link FrameworkXmlBeanDefinitionReader#FrameworkXmlBeanDefinitionReader(BeanDefinitionRegistry)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FrameworkXmlBeanDefinitionReader.<init>(BeanDefinitionRegistry)"})
  public void testNewFrameworkXmlBeanDefinitionReader() {
    // Arrange
    DefaultListableBeanFactory registry = new DefaultListableBeanFactory();

    // Act
    FrameworkXmlBeanDefinitionReader actualFrameworkXmlBeanDefinitionReader = new FrameworkXmlBeanDefinitionReader(
        registry);

    // Assert
    assertTrue(actualFrameworkXmlBeanDefinitionReader.getBeanNameGenerator() instanceof DefaultBeanNameGenerator);
    BeanDefinitionRegistry beanFactory = actualFrameworkXmlBeanDefinitionReader.getBeanFactory();
    assertTrue(beanFactory instanceof DefaultListableBeanFactory);
    assertTrue(actualFrameworkXmlBeanDefinitionReader
        .getNamespaceHandlerResolver() instanceof DefaultNamespaceHandlerResolver);
    assertTrue(actualFrameworkXmlBeanDefinitionReader.getEnvironment() instanceof StandardEnvironment);
    assertTrue(
        actualFrameworkXmlBeanDefinitionReader.getResourceLoader() instanceof PathMatchingResourcePatternResolver);
    assertNull(actualFrameworkXmlBeanDefinitionReader.getBeanClassLoader());
    assertEquals(1, actualFrameworkXmlBeanDefinitionReader.getValidationMode());
    assertFalse(actualFrameworkXmlBeanDefinitionReader.isNamespaceAware());
    assertSame(registry, beanFactory);
    assertSame(registry, actualFrameworkXmlBeanDefinitionReader.getRegistry());
  }

  /**
   * Test {@link FrameworkXmlBeanDefinitionReader#registerBeanDefinitions(Document, Resource)}.
   * <p>
   * Method under test: {@link FrameworkXmlBeanDefinitionReader#registerBeanDefinitions(Document, Resource)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int FrameworkXmlBeanDefinitionReader.registerBeanDefinitions(Document, Resource)"})
  public void testRegisterBeanDefinitions() throws BeanDefinitionStoreException {
    // Arrange
    FrameworkXmlBeanDefinitionReader frameworkXmlBeanDefinitionReader = new FrameworkXmlBeanDefinitionReader(
        new DefaultListableBeanFactory());
    HTMLDocumentImpl doc = new HTMLDocumentImpl();

    // Act and Assert
    assertEquals(0, frameworkXmlBeanDefinitionReader.registerBeanDefinitions(doc, new GeneratedResource()));
  }

  /**
   * Test {@link FrameworkXmlBeanDefinitionReader#registerBeanDefinitions(Document, Resource)}.
   * <p>
   * Method under test: {@link FrameworkXmlBeanDefinitionReader#registerBeanDefinitions(Document, Resource)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int FrameworkXmlBeanDefinitionReader.registerBeanDefinitions(Document, Resource)"})
  public void testRegisterBeanDefinitions2() throws BeanDefinitionStoreException {
    // Arrange
    FrameworkXmlBeanDefinitionReader frameworkXmlBeanDefinitionReader = new FrameworkXmlBeanDefinitionReader(
        new AnnotationConfigReactiveWebApplicationContext());
    HTMLDocumentImpl doc = new HTMLDocumentImpl();

    // Act and Assert
    assertEquals(0, frameworkXmlBeanDefinitionReader.registerBeanDefinitions(doc, new GeneratedResource()));
  }

  /**
   * Test {@link FrameworkXmlBeanDefinitionReader#registerBeanDefinitions(Document, Resource)}.
   * <ul>
   *   <li>Given {@code Object}.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link FrameworkXmlBeanDefinitionReader#registerBeanDefinitions(Document, Resource)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int FrameworkXmlBeanDefinitionReader.registerBeanDefinitions(Document, Resource)"})
  public void testRegisterBeanDefinitions_givenJavaLangObject_thenReturnZero() throws BeanDefinitionStoreException {
    // Arrange
    Class<Object> forNameResult = Object.class;
    FrameworkXmlBeanDefinitionReader frameworkXmlBeanDefinitionReader = new FrameworkXmlBeanDefinitionReader(
        new AnnotationConfigReactiveWebApplicationContext(forNameResult));
    HTMLDocumentImpl doc = new HTMLDocumentImpl();

    // Act and Assert
    assertEquals(0, frameworkXmlBeanDefinitionReader.registerBeanDefinitions(doc, new GeneratedResource()));
  }

  /**
   * Test {@link FrameworkXmlBeanDefinitionReader#isConfigurationClassBean(BeanDefinition)}.
   * <ul>
   *   <li>When {@link GenericBeanDefinition#GenericBeanDefinition()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FrameworkXmlBeanDefinitionReader#isConfigurationClassBean(BeanDefinition)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean FrameworkXmlBeanDefinitionReader.isConfigurationClassBean(BeanDefinition)"})
  public void testIsConfigurationClassBean_whenGenericBeanDefinition_thenReturnFalse() {
    // Arrange
    FrameworkXmlBeanDefinitionReader frameworkXmlBeanDefinitionReader = new FrameworkXmlBeanDefinitionReader(
        new DefaultListableBeanFactory());

    // Act and Assert
    assertFalse(frameworkXmlBeanDefinitionReader.isConfigurationClassBean(new GenericBeanDefinition()));
  }

  /**
   * Test {@link FrameworkXmlBeanDefinitionReader#isConfigurationClassBean(BeanDefinition)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FrameworkXmlBeanDefinitionReader#isConfigurationClassBean(BeanDefinition)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean FrameworkXmlBeanDefinitionReader.isConfigurationClassBean(BeanDefinition)"})
  public void testIsConfigurationClassBean_whenNull_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue((new FrameworkXmlBeanDefinitionReader(new DefaultListableBeanFactory())).isConfigurationClassBean(null));
  }
}
