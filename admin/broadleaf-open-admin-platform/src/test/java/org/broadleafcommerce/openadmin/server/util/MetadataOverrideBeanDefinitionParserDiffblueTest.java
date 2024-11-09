/*-
 * #%L
 * BroadleafCommerce Open Admin Platform
 * %%
 * Copyright (C) 2009 - 2024 Broadleaf Commerce
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
import static org.mockito.Mockito.mock;
import java.lang.reflect.Member;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.imageio.metadata.IIOMetadataNode;
import org.broadleafcommerce.common.resource.GeneratedResource;
import org.junit.Test;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.PropertyValue;
import org.springframework.beans.factory.Aware;
import org.springframework.beans.factory.BeanClassLoaderAware;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.AbstractFactoryBean;
import org.springframework.beans.factory.config.ConstructorArgumentValues;
import org.springframework.beans.factory.config.MapFactoryBean;
import org.springframework.beans.factory.parsing.EmptyReaderEventListener;
import org.springframework.beans.factory.parsing.FailFastProblemReporter;
import org.springframework.beans.factory.parsing.NullSourceExtractor;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.MethodOverrides;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.beans.factory.xml.BeanDefinitionParserDelegate;
import org.springframework.beans.factory.xml.DefaultNamespaceHandlerResolver;
import org.springframework.beans.factory.xml.ParserContext;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlReaderContext;
import org.springframework.core.ResolvableType;
import org.springframework.util.StringValueResolver;
import org.w3c.dom.Element;

public class MetadataOverrideBeanDefinitionParserDiffblueTest {
  /**
   * Test
   * {@link MetadataOverrideBeanDefinitionParser#parseInternal(Element, ParserContext)}.
   * <ul>
   *   <li>Given {@link StringValueResolver}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MetadataOverrideBeanDefinitionParser#parseInternal(Element, ParserContext)}
   */
  @Test
  public void testParseInternal_givenStringValueResolver() throws IllegalStateException {
    // Arrange
    MetadataOverrideBeanDefinitionParser metadataOverrideBeanDefinitionParser = new MetadataOverrideBeanDefinitionParser();
    IIOMetadataNode element = new IIOMetadataNode("foo");

    DefaultListableBeanFactory registry = new DefaultListableBeanFactory();
    registry.addEmbeddedValueResolver(mock(StringValueResolver.class));
    XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(registry);
    GeneratedResource resource = new GeneratedResource();
    FailFastProblemReporter problemReporter = new FailFastProblemReporter();
    EmptyReaderEventListener eventListener = new EmptyReaderEventListener();
    NullSourceExtractor sourceExtractor = new NullSourceExtractor();
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
    MutablePropertyValues propertyValues = actualParseInternalResult.getPropertyValues();
    List<PropertyValue> propertyValueList = propertyValues.getPropertyValueList();
    assertEquals(1, propertyValueList.size());
    PropertyValue getResult = propertyValueList.get(0);
    Object value = getResult.getValue();
    assertTrue(value instanceof Map);
    assertTrue(actualParseInternalResult instanceof RootBeanDefinition);
    assertEquals("", actualParseInternalResult.getScope());
    assertEquals("org.springframework.beans.factory.config.MapFactoryBean",
        actualParseInternalResult.getBeanClassName());
    assertEquals("sourceMap", getResult.getName());
    assertNull(actualParseInternalResult.getDependsOn());
    assertNull(((RootBeanDefinition) actualParseInternalResult).getPreferredConstructors());
    assertNull(actualParseInternalResult.getLazyInit());
    assertNull(((RootBeanDefinition) actualParseInternalResult).getTargetType());
    ResolvableType resolvableType = actualParseInternalResult.getResolvableType();
    ResolvableType componentType = resolvableType.getComponentType();
    assertNull(componentType.getRawClass());
    ResolvableType superType = resolvableType.getSuperType();
    ResolvableType[] interfaces = superType.getInterfaces();
    ResolvableType resolvableType2 = interfaces[0];
    ResolvableType[] generics = resolvableType2.getGenerics();
    ResolvableType resolvableType3 = generics[0];
    assertNull(resolvableType3.getRawClass());
    assertNull(getResult.getSource());
    assertNull(actualParseInternalResult.getSource());
    assertNull(getResult.getConvertedValue());
    assertNull(actualParseInternalResult.getParentName());
    assertNull(actualParseInternalResult.getDescription());
    assertNull(actualParseInternalResult.getDestroyMethodName());
    assertNull(actualParseInternalResult.getFactoryBeanName());
    assertNull(actualParseInternalResult.getFactoryMethodName());
    assertNull(actualParseInternalResult.getInitMethodName());
    assertNull(actualParseInternalResult.getResourceDescription());
    assertNull(((RootBeanDefinition) actualParseInternalResult).getQualifiedElement());
    assertNull(((RootBeanDefinition) actualParseInternalResult).getResolvedFactoryMethod());
    assertNull(actualParseInternalResult.getInstanceSupplier());
    assertNull(actualParseInternalResult.getOriginatingBeanDefinition());
    assertNull(((RootBeanDefinition) actualParseInternalResult).getDecoratedDefinition());
    assertNull(actualParseInternalResult.getResource());
    ConstructorArgumentValues constructorArgumentValues = actualParseInternalResult.getConstructorArgumentValues();
    assertEquals(0, constructorArgumentValues.getArgumentCount());
    assertEquals(0, actualParseInternalResult.getAutowireMode());
    assertEquals(0, actualParseInternalResult.getDependencyCheck());
    assertEquals(0, actualParseInternalResult.getResolvedAutowireMode());
    assertEquals(0, actualParseInternalResult.getRole());
    assertEquals(0, resolvableType.getGenerics().length);
    ResolvableType[] generics2 = componentType.getGenerics();
    assertEquals(0, generics2.length);
    ResolvableType superType2 = superType.getSuperType();
    assertEquals(0, superType2.getGenerics().length);
    ResolvableType[] generics3 = superType.getGenerics();
    ResolvableType resolvableType4 = generics3[0];
    ResolvableType[] generics4 = resolvableType4.getGenerics();
    ResolvableType resolvableType5 = generics4[0];
    assertEquals(0, resolvableType5.getGenerics().length);
    ResolvableType resolvableType6 = interfaces[1];
    assertEquals(0, resolvableType6.getGenerics().length);
    ResolvableType resolvableType7 = interfaces[2];
    assertEquals(0, resolvableType7.getGenerics().length);
    ResolvableType resolvableType8 = interfaces[3];
    assertEquals(0, resolvableType8.getGenerics().length);
    ResolvableType resolvableType9 = interfaces[4];
    assertEquals(0, resolvableType9.getGenerics().length);
    ResolvableType[] interfaces2 = resolvableType6.getInterfaces();
    ResolvableType resolvableType10 = interfaces2[0];
    assertEquals(0, resolvableType10.getGenerics().length);
    ResolvableType[] interfaces3 = resolvableType7.getInterfaces();
    ResolvableType resolvableType11 = interfaces3[0];
    assertEquals(0, resolvableType11.getGenerics().length);
    assertEquals(0, resolvableType.getInterfaces().length);
    assertEquals(0, superType2.getInterfaces().length);
    assertEquals(0, resolvableType4.getInterfaces().length);
    assertEquals(0, resolvableType5.getInterfaces().length);
    assertEquals(0, resolvableType3.getInterfaces().length);
    assertEquals(0, resolvableType2.getInterfaces().length);
    assertEquals(0, resolvableType8.getInterfaces().length);
    assertEquals(0, resolvableType9.getInterfaces().length);
    assertEquals(0, resolvableType10.getInterfaces().length);
    assertEquals(0, resolvableType11.getInterfaces().length);
    Stream<PropertyValue> streamResult = propertyValues.stream();
    List<PropertyValue> collectResult = streamResult.limit(5).collect(Collectors.toList());
    assertEquals(1, collectResult.size());
    assertEquals(1, propertyValues.size());
    PropertyValue[] propertyValues2 = propertyValues.getPropertyValues();
    assertEquals(1, propertyValues2.length);
    assertEquals(1, generics3.length);
    assertEquals(1, generics.length);
    assertEquals(1, interfaces2.length);
    assertEquals(1, interfaces3.length);
    assertEquals(1L, propertyValues.spliterator().getExactSizeIfKnown());
    assertEquals(2, generics4.length);
    assertEquals(2, resolvableType3.getGenerics().length);
    assertEquals(5, interfaces.length);
    assertFalse(propertyValues.isConverted());
    assertFalse(propertyValues.isEmpty());
    assertFalse(getResult.isConverted());
    assertFalse(getResult.isOptional());
    assertFalse(actualParseInternalResult.hasConstructorArgumentValues());
    assertFalse(actualParseInternalResult.hasMethodOverrides());
    assertFalse(actualParseInternalResult.isAbstract());
    assertFalse(actualParseInternalResult.isPrimary());
    assertFalse(actualParseInternalResult.isPrototype());
    assertFalse(actualParseInternalResult.isSynthetic());
    assertFalse(resolvableType.hasGenerics());
    assertFalse(componentType.hasGenerics());
    assertFalse(superType2.hasGenerics());
    assertFalse(resolvableType5.hasGenerics());
    assertFalse(resolvableType6.hasGenerics());
    assertFalse(resolvableType7.hasGenerics());
    assertFalse(resolvableType8.hasGenerics());
    assertFalse(resolvableType9.hasGenerics());
    assertFalse(resolvableType10.hasGenerics());
    assertFalse(resolvableType11.hasGenerics());
    assertTrue(constructorArgumentValues.getGenericArgumentValues().isEmpty());
    assertTrue(constructorArgumentValues.getIndexedArgumentValues().isEmpty());
    assertTrue(((Map<Object, Object>) value).isEmpty());
    assertTrue(actualParseInternalResult.getQualifiers().isEmpty());
    MethodOverrides methodOverrides = actualParseInternalResult.getMethodOverrides();
    assertTrue(methodOverrides.getOverrides().isEmpty());
    Set<Member> externallyManagedConfigMembers = ((RootBeanDefinition) actualParseInternalResult)
        .getExternallyManagedConfigMembers();
    assertTrue(externallyManagedConfigMembers.isEmpty());
    assertTrue(constructorArgumentValues.isEmpty());
    assertTrue(actualParseInternalResult.hasBeanClass());
    assertTrue(actualParseInternalResult.hasPropertyValues());
    assertTrue(actualParseInternalResult.isAutowireCandidate());
    assertTrue(actualParseInternalResult.isEnforceDestroyMethod());
    assertTrue(actualParseInternalResult.isEnforceInitMethod());
    assertTrue(actualParseInternalResult.isLenientConstructorResolution());
    assertTrue(actualParseInternalResult.isNonPublicAccessAllowed());
    assertTrue(actualParseInternalResult.isSingleton());
    assertTrue(methodOverrides.isEmpty());
    assertTrue(superType.hasGenerics());
    assertTrue(resolvableType4.hasGenerics());
    assertTrue(resolvableType3.hasGenerics());
    assertTrue(resolvableType2.hasGenerics());
    Class<Object> expectedRawClass = Object.class;
    assertEquals(expectedRawClass, superType2.getRawClass());
    Class<Map> expectedRawClass2 = Map.class;
    assertEquals(expectedRawClass2, resolvableType4.getRawClass());
    Class<Aware> expectedRawClass3 = Aware.class;
    assertEquals(expectedRawClass3, resolvableType10.getRawClass());
    Class<BeanClassLoaderAware> expectedRawClass4 = BeanClassLoaderAware.class;
    Class<?> rawClass = resolvableType6.getRawClass();
    assertEquals(expectedRawClass4, rawClass);
    Class<BeanFactoryAware> expectedRawClass5 = BeanFactoryAware.class;
    Class<?> rawClass2 = resolvableType7.getRawClass();
    assertEquals(expectedRawClass5, rawClass2);
    Class<DisposableBean> expectedRawClass6 = DisposableBean.class;
    Class<?> rawClass3 = resolvableType9.getRawClass();
    assertEquals(expectedRawClass6, rawClass3);
    Class<FactoryBean> expectedRawClass7 = FactoryBean.class;
    assertEquals(expectedRawClass7, resolvableType2.getRawClass());
    Class<InitializingBean> expectedRawClass8 = InitializingBean.class;
    Class<?> rawClass4 = resolvableType8.getRawClass();
    assertEquals(expectedRawClass8, rawClass4);
    Class<AbstractFactoryBean> expectedRawClass9 = AbstractFactoryBean.class;
    assertEquals(expectedRawClass9, superType.getRawClass());
    Class<MapFactoryBean> expectedBeanClass = MapFactoryBean.class;
    Class<?> beanClass = actualParseInternalResult.getBeanClass();
    assertEquals(expectedBeanClass, beanClass);
    assertSame(getResult, collectResult.get(0));
    assertSame(getResult, getResult.getOriginalPropertyValue());
    assertSame(getResult, propertyValues2[0]);
    assertSame(beanClass, resolvableType.getRawClass());
    assertSame(beanClass, resolvableType.getSource());
    assertSame(beanClass, resolvableType.getType());
    assertSame(externallyManagedConfigMembers,
        ((RootBeanDefinition) actualParseInternalResult).getExternallyManagedDestroyMethods());
    assertSame(externallyManagedConfigMembers,
        ((RootBeanDefinition) actualParseInternalResult).getExternallyManagedInitMethods());
    ResolvableType componentType2 = componentType.getComponentType();
    assertSame(componentType2, componentType2);
    assertSame(componentType2, superType.getComponentType());
    assertSame(componentType2, superType2.getComponentType());
    assertSame(componentType2, resolvableType4.getComponentType());
    assertSame(componentType2, resolvableType5.getComponentType());
    assertSame(componentType2, resolvableType3.getComponentType());
    assertSame(componentType2, resolvableType2.getComponentType());
    assertSame(componentType2, resolvableType6.getComponentType());
    assertSame(componentType2, resolvableType7.getComponentType());
    assertSame(componentType2, resolvableType8.getComponentType());
    assertSame(componentType2, resolvableType9.getComponentType());
    assertSame(componentType2, resolvableType10.getComponentType());
    assertSame(componentType2, resolvableType11.getComponentType());
    assertSame(componentType2, componentType.getSuperType());
    assertSame(componentType2, superType2.getSuperType());
    assertSame(componentType2, resolvableType4.getSuperType());
    assertSame(componentType2, resolvableType5.getSuperType());
    assertSame(componentType2, resolvableType3.getSuperType());
    assertSame(componentType2, resolvableType2.getSuperType());
    assertSame(componentType2, resolvableType6.getSuperType());
    assertSame(componentType2, resolvableType7.getSuperType());
    assertSame(componentType2, resolvableType8.getSuperType());
    assertSame(componentType2, resolvableType9.getSuperType());
    assertSame(componentType2, resolvableType10.getSuperType());
    assertSame(componentType2, resolvableType11.getSuperType());
    assertSame(generics2, componentType.getInterfaces());
    assertSame(rawClass, resolvableType6.getSource());
    assertSame(rawClass, resolvableType6.getType());
    assertSame(rawClass2, resolvableType7.getSource());
    assertSame(rawClass2, resolvableType7.getType());
    assertSame(rawClass4, resolvableType8.getSource());
    assertSame(rawClass4, resolvableType8.getType());
    assertSame(rawClass3, resolvableType9.getSource());
    assertSame(rawClass3, resolvableType9.getType());
  }

  /**
   * Test
   * {@link MetadataOverrideBeanDefinitionParser#parseInternal(Element, ParserContext)}.
   * <ul>
   *   <li>Then return PropertyValues PropertyValueList size is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MetadataOverrideBeanDefinitionParser#parseInternal(Element, ParserContext)}
   */
  @Test
  public void testParseInternal_thenReturnPropertyValuesPropertyValueListSizeIsOne() throws IllegalStateException {
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
    MutablePropertyValues propertyValues = actualParseInternalResult.getPropertyValues();
    List<PropertyValue> propertyValueList = propertyValues.getPropertyValueList();
    assertEquals(1, propertyValueList.size());
    PropertyValue getResult = propertyValueList.get(0);
    Object value = getResult.getValue();
    assertTrue(value instanceof Map);
    assertTrue(actualParseInternalResult instanceof RootBeanDefinition);
    assertEquals("", actualParseInternalResult.getScope());
    assertEquals("org.springframework.beans.factory.config.MapFactoryBean",
        actualParseInternalResult.getBeanClassName());
    assertEquals("sourceMap", getResult.getName());
    assertNull(actualParseInternalResult.getDependsOn());
    assertNull(((RootBeanDefinition) actualParseInternalResult).getPreferredConstructors());
    assertNull(actualParseInternalResult.getLazyInit());
    assertNull(((RootBeanDefinition) actualParseInternalResult).getTargetType());
    ResolvableType resolvableType = actualParseInternalResult.getResolvableType();
    ResolvableType componentType = resolvableType.getComponentType();
    assertNull(componentType.getRawClass());
    ResolvableType superType = resolvableType.getSuperType();
    ResolvableType[] interfaces = superType.getInterfaces();
    ResolvableType resolvableType2 = interfaces[0];
    ResolvableType[] generics = resolvableType2.getGenerics();
    ResolvableType resolvableType3 = generics[0];
    assertNull(resolvableType3.getRawClass());
    assertNull(getResult.getSource());
    assertNull(actualParseInternalResult.getSource());
    assertNull(getResult.getConvertedValue());
    assertNull(actualParseInternalResult.getParentName());
    assertNull(actualParseInternalResult.getDescription());
    assertNull(actualParseInternalResult.getDestroyMethodName());
    assertNull(actualParseInternalResult.getFactoryBeanName());
    assertNull(actualParseInternalResult.getFactoryMethodName());
    assertNull(actualParseInternalResult.getInitMethodName());
    assertNull(actualParseInternalResult.getResourceDescription());
    assertNull(((RootBeanDefinition) actualParseInternalResult).getQualifiedElement());
    assertNull(((RootBeanDefinition) actualParseInternalResult).getResolvedFactoryMethod());
    assertNull(actualParseInternalResult.getInstanceSupplier());
    assertNull(actualParseInternalResult.getOriginatingBeanDefinition());
    assertNull(((RootBeanDefinition) actualParseInternalResult).getDecoratedDefinition());
    assertNull(actualParseInternalResult.getResource());
    ConstructorArgumentValues constructorArgumentValues = actualParseInternalResult.getConstructorArgumentValues();
    assertEquals(0, constructorArgumentValues.getArgumentCount());
    assertEquals(0, actualParseInternalResult.getAutowireMode());
    assertEquals(0, actualParseInternalResult.getDependencyCheck());
    assertEquals(0, actualParseInternalResult.getResolvedAutowireMode());
    assertEquals(0, actualParseInternalResult.getRole());
    assertEquals(0, resolvableType.getGenerics().length);
    ResolvableType[] generics2 = componentType.getGenerics();
    assertEquals(0, generics2.length);
    ResolvableType superType2 = superType.getSuperType();
    assertEquals(0, superType2.getGenerics().length);
    ResolvableType[] generics3 = superType.getGenerics();
    ResolvableType resolvableType4 = generics3[0];
    ResolvableType[] generics4 = resolvableType4.getGenerics();
    ResolvableType resolvableType5 = generics4[0];
    assertEquals(0, resolvableType5.getGenerics().length);
    ResolvableType resolvableType6 = interfaces[1];
    assertEquals(0, resolvableType6.getGenerics().length);
    ResolvableType resolvableType7 = interfaces[2];
    assertEquals(0, resolvableType7.getGenerics().length);
    ResolvableType resolvableType8 = interfaces[3];
    assertEquals(0, resolvableType8.getGenerics().length);
    ResolvableType resolvableType9 = interfaces[4];
    assertEquals(0, resolvableType9.getGenerics().length);
    ResolvableType[] interfaces2 = resolvableType6.getInterfaces();
    ResolvableType resolvableType10 = interfaces2[0];
    assertEquals(0, resolvableType10.getGenerics().length);
    ResolvableType[] interfaces3 = resolvableType7.getInterfaces();
    ResolvableType resolvableType11 = interfaces3[0];
    assertEquals(0, resolvableType11.getGenerics().length);
    assertEquals(0, resolvableType.getInterfaces().length);
    assertEquals(0, superType2.getInterfaces().length);
    assertEquals(0, resolvableType4.getInterfaces().length);
    assertEquals(0, resolvableType5.getInterfaces().length);
    assertEquals(0, resolvableType3.getInterfaces().length);
    assertEquals(0, resolvableType2.getInterfaces().length);
    assertEquals(0, resolvableType8.getInterfaces().length);
    assertEquals(0, resolvableType9.getInterfaces().length);
    assertEquals(0, resolvableType10.getInterfaces().length);
    assertEquals(0, resolvableType11.getInterfaces().length);
    Stream<PropertyValue> streamResult = propertyValues.stream();
    List<PropertyValue> collectResult = streamResult.limit(5).collect(Collectors.toList());
    assertEquals(1, collectResult.size());
    assertEquals(1, propertyValues.size());
    PropertyValue[] propertyValues2 = propertyValues.getPropertyValues();
    assertEquals(1, propertyValues2.length);
    assertEquals(1, generics3.length);
    assertEquals(1, generics.length);
    assertEquals(1, interfaces2.length);
    assertEquals(1, interfaces3.length);
    assertEquals(1L, propertyValues.spliterator().getExactSizeIfKnown());
    assertEquals(2, generics4.length);
    assertEquals(2, resolvableType3.getGenerics().length);
    assertEquals(5, interfaces.length);
    assertFalse(propertyValues.isConverted());
    assertFalse(propertyValues.isEmpty());
    assertFalse(getResult.isConverted());
    assertFalse(getResult.isOptional());
    assertFalse(actualParseInternalResult.hasConstructorArgumentValues());
    assertFalse(actualParseInternalResult.hasMethodOverrides());
    assertFalse(actualParseInternalResult.isAbstract());
    assertFalse(actualParseInternalResult.isPrimary());
    assertFalse(actualParseInternalResult.isPrototype());
    assertFalse(actualParseInternalResult.isSynthetic());
    assertFalse(resolvableType.hasGenerics());
    assertFalse(componentType.hasGenerics());
    assertFalse(superType2.hasGenerics());
    assertFalse(resolvableType5.hasGenerics());
    assertFalse(resolvableType6.hasGenerics());
    assertFalse(resolvableType7.hasGenerics());
    assertFalse(resolvableType8.hasGenerics());
    assertFalse(resolvableType9.hasGenerics());
    assertFalse(resolvableType10.hasGenerics());
    assertFalse(resolvableType11.hasGenerics());
    assertTrue(constructorArgumentValues.getGenericArgumentValues().isEmpty());
    assertTrue(constructorArgumentValues.getIndexedArgumentValues().isEmpty());
    assertTrue(((Map<Object, Object>) value).isEmpty());
    assertTrue(actualParseInternalResult.getQualifiers().isEmpty());
    MethodOverrides methodOverrides = actualParseInternalResult.getMethodOverrides();
    assertTrue(methodOverrides.getOverrides().isEmpty());
    Set<Member> externallyManagedConfigMembers = ((RootBeanDefinition) actualParseInternalResult)
        .getExternallyManagedConfigMembers();
    assertTrue(externallyManagedConfigMembers.isEmpty());
    assertTrue(constructorArgumentValues.isEmpty());
    assertTrue(actualParseInternalResult.hasBeanClass());
    assertTrue(actualParseInternalResult.hasPropertyValues());
    assertTrue(actualParseInternalResult.isAutowireCandidate());
    assertTrue(actualParseInternalResult.isEnforceDestroyMethod());
    assertTrue(actualParseInternalResult.isEnforceInitMethod());
    assertTrue(actualParseInternalResult.isLenientConstructorResolution());
    assertTrue(actualParseInternalResult.isNonPublicAccessAllowed());
    assertTrue(actualParseInternalResult.isSingleton());
    assertTrue(methodOverrides.isEmpty());
    assertTrue(superType.hasGenerics());
    assertTrue(resolvableType4.hasGenerics());
    assertTrue(resolvableType3.hasGenerics());
    assertTrue(resolvableType2.hasGenerics());
    Class<Object> expectedRawClass = Object.class;
    assertEquals(expectedRawClass, superType2.getRawClass());
    Class<Map> expectedRawClass2 = Map.class;
    assertEquals(expectedRawClass2, resolvableType4.getRawClass());
    Class<Aware> expectedRawClass3 = Aware.class;
    assertEquals(expectedRawClass3, resolvableType10.getRawClass());
    Class<BeanClassLoaderAware> expectedRawClass4 = BeanClassLoaderAware.class;
    Class<?> rawClass = resolvableType6.getRawClass();
    assertEquals(expectedRawClass4, rawClass);
    Class<BeanFactoryAware> expectedRawClass5 = BeanFactoryAware.class;
    Class<?> rawClass2 = resolvableType7.getRawClass();
    assertEquals(expectedRawClass5, rawClass2);
    Class<DisposableBean> expectedRawClass6 = DisposableBean.class;
    Class<?> rawClass3 = resolvableType9.getRawClass();
    assertEquals(expectedRawClass6, rawClass3);
    Class<FactoryBean> expectedRawClass7 = FactoryBean.class;
    assertEquals(expectedRawClass7, resolvableType2.getRawClass());
    Class<InitializingBean> expectedRawClass8 = InitializingBean.class;
    Class<?> rawClass4 = resolvableType8.getRawClass();
    assertEquals(expectedRawClass8, rawClass4);
    Class<AbstractFactoryBean> expectedRawClass9 = AbstractFactoryBean.class;
    assertEquals(expectedRawClass9, superType.getRawClass());
    Class<MapFactoryBean> expectedBeanClass = MapFactoryBean.class;
    Class<?> beanClass = actualParseInternalResult.getBeanClass();
    assertEquals(expectedBeanClass, beanClass);
    assertSame(getResult, collectResult.get(0));
    assertSame(getResult, getResult.getOriginalPropertyValue());
    assertSame(getResult, propertyValues2[0]);
    assertSame(beanClass, resolvableType.getRawClass());
    assertSame(beanClass, resolvableType.getSource());
    assertSame(beanClass, resolvableType.getType());
    assertSame(externallyManagedConfigMembers,
        ((RootBeanDefinition) actualParseInternalResult).getExternallyManagedDestroyMethods());
    assertSame(externallyManagedConfigMembers,
        ((RootBeanDefinition) actualParseInternalResult).getExternallyManagedInitMethods());
    ResolvableType componentType2 = componentType.getComponentType();
    assertSame(componentType2, componentType2);
    assertSame(componentType2, superType.getComponentType());
    assertSame(componentType2, superType2.getComponentType());
    assertSame(componentType2, resolvableType4.getComponentType());
    assertSame(componentType2, resolvableType5.getComponentType());
    assertSame(componentType2, resolvableType3.getComponentType());
    assertSame(componentType2, resolvableType2.getComponentType());
    assertSame(componentType2, resolvableType6.getComponentType());
    assertSame(componentType2, resolvableType7.getComponentType());
    assertSame(componentType2, resolvableType8.getComponentType());
    assertSame(componentType2, resolvableType9.getComponentType());
    assertSame(componentType2, resolvableType10.getComponentType());
    assertSame(componentType2, resolvableType11.getComponentType());
    assertSame(componentType2, componentType.getSuperType());
    assertSame(componentType2, superType2.getSuperType());
    assertSame(componentType2, resolvableType4.getSuperType());
    assertSame(componentType2, resolvableType5.getSuperType());
    assertSame(componentType2, resolvableType3.getSuperType());
    assertSame(componentType2, resolvableType2.getSuperType());
    assertSame(componentType2, resolvableType6.getSuperType());
    assertSame(componentType2, resolvableType7.getSuperType());
    assertSame(componentType2, resolvableType8.getSuperType());
    assertSame(componentType2, resolvableType9.getSuperType());
    assertSame(componentType2, resolvableType10.getSuperType());
    assertSame(componentType2, resolvableType11.getSuperType());
    assertSame(generics2, componentType.getInterfaces());
    assertSame(rawClass, resolvableType6.getSource());
    assertSame(rawClass, resolvableType6.getType());
    assertSame(rawClass2, resolvableType7.getSource());
    assertSame(rawClass2, resolvableType7.getType());
    assertSame(rawClass4, resolvableType8.getSource());
    assertSame(rawClass4, resolvableType8.getType());
    assertSame(rawClass3, resolvableType9.getSource());
    assertSame(rawClass3, resolvableType9.getType());
  }
}
