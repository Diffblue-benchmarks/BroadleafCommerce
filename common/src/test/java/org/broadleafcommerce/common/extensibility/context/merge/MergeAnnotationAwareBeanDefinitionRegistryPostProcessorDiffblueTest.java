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
package org.broadleafcommerce.common.extensibility.context.merge;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.yahoo.platform.yui.compressor.JarClassLoader;
import java.util.HashSet;
import org.junit.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.core.type.MethodMetadata;
import org.springframework.core.type.StandardMethodMetadata;
import org.springframework.core.type.classreading.MethodMetadataReadingVisitor;

public class MergeAnnotationAwareBeanDefinitionRegistryPostProcessorDiffblueTest {
  /**
   * Method under test:
   * {@link MergeAnnotationAwareBeanDefinitionRegistryPostProcessor#isBroadleafAnnotationBean(MethodMetadata)}
   */
  @Test
  public void testIsBroadleafAnnotationBean() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MergeAnnotationAwareBeanDefinitionRegistryPostProcessor mergeAnnotationAwareBeanDefinitionRegistryPostProcessor = new MergeAnnotationAwareBeanDefinitionRegistryPostProcessor();
    JarClassLoader classLoader = new JarClassLoader();

    // Act and Assert
    assertFalse(mergeAnnotationAwareBeanDefinitionRegistryPostProcessor
        .isBroadleafAnnotationBean(new MethodMetadataReadingVisitor("Method Name", 1, "Declaring Class Name",
            "Return Type Name", classLoader, new HashSet<>())));
  }

  /**
   * Method under test:
   * {@link MergeAnnotationAwareBeanDefinitionRegistryPostProcessor#isBroadleafAnnotationBean(MethodMetadata)}
   */
  @Test
  public void testIsBroadleafAnnotationBean2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MergeAnnotationAwareBeanDefinitionRegistryPostProcessor mergeAnnotationAwareBeanDefinitionRegistryPostProcessor = new MergeAnnotationAwareBeanDefinitionRegistryPostProcessor();
    StandardMethodMetadata metadata = mock(StandardMethodMetadata.class);
    when(metadata.getDeclaringClassName()).thenReturn("Declaring Class Name");

    // Act
    boolean actualIsBroadleafAnnotationBeanResult = mergeAnnotationAwareBeanDefinitionRegistryPostProcessor
        .isBroadleafAnnotationBean(metadata);

    // Assert
    verify(metadata, atLeast(1)).getDeclaringClassName();
    assertFalse(actualIsBroadleafAnnotationBeanResult);
  }

  /**
   * Method under test:
   * {@link MergeAnnotationAwareBeanDefinitionRegistryPostProcessor#isBroadleafAnnotationBean(MethodMetadata)}
   */
  @Test
  public void testIsBroadleafAnnotationBean3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MergeAnnotationAwareBeanDefinitionRegistryPostProcessor mergeAnnotationAwareBeanDefinitionRegistryPostProcessor = new MergeAnnotationAwareBeanDefinitionRegistryPostProcessor();
    StandardMethodMetadata metadata = mock(StandardMethodMetadata.class);
    when(metadata.getDeclaringClassName()).thenReturn("org.broadleafcommerce");

    // Act
    boolean actualIsBroadleafAnnotationBeanResult = mergeAnnotationAwareBeanDefinitionRegistryPostProcessor
        .isBroadleafAnnotationBean(metadata);

    // Assert
    verify(metadata).getDeclaringClassName();
    assertTrue(actualIsBroadleafAnnotationBeanResult);
  }

  /**
   * Method under test:
   * {@link MergeAnnotationAwareBeanDefinitionRegistryPostProcessor#isBroadleafAnnotationBean(MethodMetadata)}
   */
  @Test
  public void testIsBroadleafAnnotationBean4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MergeAnnotationAwareBeanDefinitionRegistryPostProcessor mergeAnnotationAwareBeanDefinitionRegistryPostProcessor = new MergeAnnotationAwareBeanDefinitionRegistryPostProcessor();
    StandardMethodMetadata metadata = mock(StandardMethodMetadata.class);
    when(metadata.getDeclaringClassName()).thenReturn("com.broadleafcommerce");

    // Act
    boolean actualIsBroadleafAnnotationBeanResult = mergeAnnotationAwareBeanDefinitionRegistryPostProcessor
        .isBroadleafAnnotationBean(metadata);

    // Assert
    verify(metadata, atLeast(1)).getDeclaringClassName();
    assertTrue(actualIsBroadleafAnnotationBeanResult);
  }

  /**
   * Method under test:
   * {@link MergeAnnotationAwareBeanDefinitionRegistryPostProcessor#isBroadleafBean(BeanDefinition)}
   */
  @Test
  public void testIsBroadleafBean() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MergeAnnotationAwareBeanDefinitionRegistryPostProcessor mergeAnnotationAwareBeanDefinitionRegistryPostProcessor = new MergeAnnotationAwareBeanDefinitionRegistryPostProcessor();

    // Act and Assert
    assertFalse(mergeAnnotationAwareBeanDefinitionRegistryPostProcessor.isBroadleafBean(new GenericBeanDefinition()));
  }

  /**
   * Method under test:
   * {@link MergeAnnotationAwareBeanDefinitionRegistryPostProcessor#isBroadleafBean(BeanDefinition)}
   */
  @Test
  public void testIsBroadleafBean2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new MergeAnnotationAwareBeanDefinitionRegistryPostProcessor()).isBroadleafBean(null));
  }
}
