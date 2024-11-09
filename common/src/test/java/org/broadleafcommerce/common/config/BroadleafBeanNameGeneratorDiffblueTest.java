/*-
 * #%L
 * BroadleafCommerce Common Libraries
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
package org.broadleafcommerce.common.config;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.broadleafcommerce.common.resource.GeneratedResource;
import org.junit.Test;
import org.springframework.beans.factory.annotation.AnnotatedGenericBeanDefinition;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.ScannedGenericBeanDefinition;
import org.springframework.core.type.StandardAnnotationMetadata;
import org.springframework.core.type.classreading.MetadataReader;

public class BroadleafBeanNameGeneratorDiffblueTest {
  /**
   * Test
   * {@link BroadleafBeanNameGenerator#generateBeanName(BeanDefinition, BeanDefinitionRegistry)}.
   * <ul>
   *   <li>Given {@link BroadleafBeanNameGenerator#BROADLEAF_BEAN_PREFIX}.</li>
   *   <li>Then return
   * {@link BroadleafBeanNameGenerator#BROADLEAF_BEAN_PREFIX}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BroadleafBeanNameGenerator#generateBeanName(BeanDefinition, BeanDefinitionRegistry)}
   */
  @Test
  public void testGenerateBeanName_givenBroadleaf_bean_prefix_thenReturnBroadleaf_bean_prefix() {
    // Arrange
    BroadleafBeanNameGenerator broadleafBeanNameGenerator = new BroadleafBeanNameGenerator();
    MetadataReader metadataReader = mock(MetadataReader.class);
    when(metadataReader.getResource()).thenReturn(new GeneratedResource());
    Class<Object> introspectedClass = Object.class;
    when(metadataReader.getAnnotationMetadata()).thenReturn(new StandardAnnotationMetadata(introspectedClass));

    ScannedGenericBeanDefinition definition = new ScannedGenericBeanDefinition(metadataReader);
    definition.setBeanClassName(BroadleafBeanNameGenerator.BROADLEAF_BEAN_PREFIX);

    // Act
    String actualGenerateBeanNameResult = broadleafBeanNameGenerator.generateBeanName(definition,
        new DefaultListableBeanFactory());

    // Assert
    verify(metadataReader).getAnnotationMetadata();
    verify(metadataReader).getResource();
    assertEquals(BroadleafBeanNameGenerator.BROADLEAF_BEAN_PREFIX, actualGenerateBeanNameResult);
  }

  /**
   * Test
   * {@link BroadleafBeanNameGenerator#generateBeanName(BeanDefinition, BeanDefinitionRegistry)}.
   * <ul>
   *   <li>When {@code java.lang.Object}.</li>
   *   <li>Then return {@code blObject}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BroadleafBeanNameGenerator#generateBeanName(BeanDefinition, BeanDefinitionRegistry)}
   */
  @Test
  public void testGenerateBeanName_whenJavaLangObject_thenReturnBlObject() {
    // Arrange
    BroadleafBeanNameGenerator broadleafBeanNameGenerator = new BroadleafBeanNameGenerator();
    Class<Object> beanClass = Object.class;
    AnnotatedGenericBeanDefinition definition = new AnnotatedGenericBeanDefinition(beanClass);

    // Act and Assert
    assertEquals("blObject", broadleafBeanNameGenerator.generateBeanName(definition, new DefaultListableBeanFactory()));
  }

  /**
   * Test
   * {@link BroadleafBeanNameGenerator#generateBeanName(BeanDefinition, BeanDefinitionRegistry)}.
   * <ul>
   *   <li>When
   * {@link ScannedGenericBeanDefinition#ScannedGenericBeanDefinition(MetadataReader)}
   * with {@link MetadataReader}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BroadleafBeanNameGenerator#generateBeanName(BeanDefinition, BeanDefinitionRegistry)}
   */
  @Test
  public void testGenerateBeanName_whenScannedGenericBeanDefinitionWithMetadataReader() {
    // Arrange
    BroadleafBeanNameGenerator broadleafBeanNameGenerator = new BroadleafBeanNameGenerator();
    MetadataReader metadataReader = mock(MetadataReader.class);
    when(metadataReader.getResource()).thenReturn(new GeneratedResource());
    Class<Object> introspectedClass = Object.class;
    when(metadataReader.getAnnotationMetadata()).thenReturn(new StandardAnnotationMetadata(introspectedClass));
    ScannedGenericBeanDefinition definition = new ScannedGenericBeanDefinition(metadataReader);

    // Act
    String actualGenerateBeanNameResult = broadleafBeanNameGenerator.generateBeanName(definition,
        new DefaultListableBeanFactory());

    // Assert
    verify(metadataReader).getAnnotationMetadata();
    verify(metadataReader).getResource();
    assertEquals("blObject", actualGenerateBeanNameResult);
  }
}
