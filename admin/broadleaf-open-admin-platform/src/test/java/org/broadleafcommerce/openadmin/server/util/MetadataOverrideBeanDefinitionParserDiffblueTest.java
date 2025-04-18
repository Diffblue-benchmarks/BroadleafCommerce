/*-
 * #%L
 * BroadleafCommerce Open Admin Platform
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
package org.broadleafcommerce.openadmin.server.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.lang.reflect.Member;
import java.util.Set;
import javax.imageio.metadata.IIOMetadataNode;
import org.broadleafcommerce.common.resource.GeneratedResource;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.springframework.beans.factory.config.MapFactoryBean;
import org.springframework.beans.factory.parsing.EmptyReaderEventListener;
import org.springframework.beans.factory.parsing.FailFastProblemReporter;
import org.springframework.beans.factory.parsing.NullSourceExtractor;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.beans.factory.xml.BeanDefinitionParserDelegate;
import org.springframework.beans.factory.xml.DefaultNamespaceHandlerResolver;
import org.springframework.beans.factory.xml.ParserContext;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlReaderContext;
import org.w3c.dom.Element;

public class MetadataOverrideBeanDefinitionParserDiffblueTest {
  /**
   * Test {@link MetadataOverrideBeanDefinitionParser#parseInternal(Element, ParserContext)}.
   * <ul>
   *   <li>When {@link IIOMetadataNode#IIOMetadataNode(String)} with {@code foo}.</li>
   *   <li>Then return {@link RootBeanDefinition}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MetadataOverrideBeanDefinitionParser#parseInternal(Element, ParserContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "AbstractBeanDefinition MetadataOverrideBeanDefinitionParser.parseInternal(Element, ParserContext)"})
  public void testParseInternal_whenIIOMetadataNodeWithFoo_thenReturnRootBeanDefinition() throws IllegalStateException {
    // Arrange
    MetadataOverrideBeanDefinitionParser metadataOverrideBeanDefinitionParser = new MetadataOverrideBeanDefinitionParser();
    IIOMetadataNode element = new IIOMetadataNode("foo");
    GeneratedResource resource = new GeneratedResource();
    FailFastProblemReporter problemReporter = new FailFastProblemReporter();
    EmptyReaderEventListener eventListener = new EmptyReaderEventListener();
    NullSourceExtractor sourceExtractor = new NullSourceExtractor();
    XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(new DefaultListableBeanFactory());
    XmlReaderContext readerContext = new XmlReaderContext(resource, problemReporter, eventListener, sourceExtractor,
        reader, new DefaultNamespaceHandlerResolver());

    GeneratedResource resource2 = new GeneratedResource();
    FailFastProblemReporter problemReporter2 = new FailFastProblemReporter();
    EmptyReaderEventListener eventListener2 = new EmptyReaderEventListener();
    NullSourceExtractor sourceExtractor2 = new NullSourceExtractor();
    XmlBeanDefinitionReader reader2 = new XmlBeanDefinitionReader(new DefaultListableBeanFactory());

    // Act
    AbstractBeanDefinition actualParseInternalResult = metadataOverrideBeanDefinitionParser.parseInternal(element,
        new ParserContext(readerContext, new BeanDefinitionParserDelegate(new XmlReaderContext(resource2,
            problemReporter2, eventListener2, sourceExtractor2, reader2, new DefaultNamespaceHandlerResolver()))));

    // Assert
    assertTrue(actualParseInternalResult instanceof RootBeanDefinition);
    assertEquals("", actualParseInternalResult.getScope());
    assertEquals("org.springframework.beans.factory.config.MapFactoryBean",
        actualParseInternalResult.getBeanClassName());
    assertNull(actualParseInternalResult.getLazyInit());
    assertNull(((RootBeanDefinition) actualParseInternalResult).getTargetType());
    assertNull(actualParseInternalResult.getSource());
    assertNull(actualParseInternalResult.getParentName());
    assertNull(actualParseInternalResult.getDescription());
    assertNull(actualParseInternalResult.getDestroyMethodName());
    assertNull(actualParseInternalResult.getFactoryBeanName());
    assertNull(actualParseInternalResult.getFactoryMethodName());
    assertNull(actualParseInternalResult.getInitMethodName());
    assertNull(actualParseInternalResult.getResourceDescription());
    assertNull(actualParseInternalResult.getDependsOn());
    assertNull(((RootBeanDefinition) actualParseInternalResult).getQualifiedElement());
    assertNull(((RootBeanDefinition) actualParseInternalResult).getPreferredConstructors());
    assertNull(((RootBeanDefinition) actualParseInternalResult).getResolvedFactoryMethod());
    assertNull(actualParseInternalResult.getInstanceSupplier());
    assertNull(actualParseInternalResult.getOriginatingBeanDefinition());
    assertNull(((RootBeanDefinition) actualParseInternalResult).getDecoratedDefinition());
    assertNull(actualParseInternalResult.getResource());
    assertEquals(0, actualParseInternalResult.getAutowireMode());
    assertEquals(0, actualParseInternalResult.getDependencyCheck());
    assertEquals(0, actualParseInternalResult.getResolvedAutowireMode());
    assertEquals(0, actualParseInternalResult.getRole());
    assertFalse(actualParseInternalResult.hasConstructorArgumentValues());
    assertFalse(actualParseInternalResult.hasMethodOverrides());
    assertFalse(actualParseInternalResult.isAbstract());
    assertFalse(actualParseInternalResult.isPrimary());
    assertFalse(actualParseInternalResult.isPrototype());
    assertFalse(actualParseInternalResult.isSynthetic());
    assertTrue(actualParseInternalResult.getQualifiers().isEmpty());
    Set<Member> externallyManagedConfigMembers = ((RootBeanDefinition) actualParseInternalResult)
        .getExternallyManagedConfigMembers();
    assertTrue(externallyManagedConfigMembers.isEmpty());
    assertTrue(actualParseInternalResult.hasBeanClass());
    assertTrue(actualParseInternalResult.hasPropertyValues());
    assertTrue(actualParseInternalResult.isAutowireCandidate());
    assertTrue(actualParseInternalResult.isEnforceDestroyMethod());
    assertTrue(actualParseInternalResult.isEnforceInitMethod());
    assertTrue(actualParseInternalResult.isLenientConstructorResolution());
    assertTrue(actualParseInternalResult.isNonPublicAccessAllowed());
    assertTrue(actualParseInternalResult.isSingleton());
    Class<MapFactoryBean> expectedBeanClass = MapFactoryBean.class;
    assertEquals(expectedBeanClass, actualParseInternalResult.getBeanClass());
    assertSame(externallyManagedConfigMembers,
        ((RootBeanDefinition) actualParseInternalResult).getExternallyManagedDestroyMethods());
    assertSame(externallyManagedConfigMembers,
        ((RootBeanDefinition) actualParseInternalResult).getExternallyManagedInitMethods());
  }
}
