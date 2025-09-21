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
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.yahoo.platform.yui.compressor.JarClassLoader;
import java.util.HashSet;
import org.broadleafcommerce.common.resource.GeneratedResource;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.FactoryBeanNotInitializedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.core.io.Resource;
import org.springframework.core.type.MethodMetadata;
import org.springframework.core.type.classreading.MethodMetadataReadingVisitor;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = {"/context/merge/bl-framework.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class MergeAnnotationAwareBeanDefinitionRegistryPostProcessorDiffblueTest {
  @Autowired
  private MergeAnnotationAwareBeanDefinitionRegistryPostProcessor
      mergeAnnotationAwareBeanDefinitionRegistryPostProcessor;

  /**
   * Test {@link
   * MergeAnnotationAwareBeanDefinitionRegistryPostProcessor#isBroadleafAnnotationBean(MethodMetadata)}.
   *
   * <p>Method under test: {@link
   * MergeAnnotationAwareBeanDefinitionRegistryPostProcessor#isBroadleafAnnotationBean(MethodMetadata)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean MergeAnnotationAwareBeanDefinitionRegistryPostProcessor.isBroadleafAnnotationBean(MethodMetadata)"
  })
  public void testIsBroadleafAnnotationBean() {
    // Arrange
    JarClassLoader classLoader = new JarClassLoader();
    MethodMetadataReadingVisitor metadata =
        new MethodMetadataReadingVisitor(
            "Method Name",
            1,
            "org.broadleafcommerce",
            "Return Type Name",
            classLoader,
            new HashSet<>());

    // Act and Assert
    assertTrue(
        mergeAnnotationAwareBeanDefinitionRegistryPostProcessor.isBroadleafAnnotationBean(
            metadata));
  }

  /**
   * Test {@link
   * MergeAnnotationAwareBeanDefinitionRegistryPostProcessor#isBroadleafAnnotationBean(MethodMetadata)}.
   *
   * <p>Method under test: {@link
   * MergeAnnotationAwareBeanDefinitionRegistryPostProcessor#isBroadleafAnnotationBean(MethodMetadata)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean MergeAnnotationAwareBeanDefinitionRegistryPostProcessor.isBroadleafAnnotationBean(MethodMetadata)"
  })
  public void testIsBroadleafAnnotationBean2() {
    // Arrange
    JarClassLoader classLoader = new JarClassLoader();
    MethodMetadataReadingVisitor metadata =
        new MethodMetadataReadingVisitor(
            "Method Name",
            1,
            "com.broadleafcommerce",
            "Return Type Name",
            classLoader,
            new HashSet<>());

    // Act and Assert
    assertTrue(
        mergeAnnotationAwareBeanDefinitionRegistryPostProcessor.isBroadleafAnnotationBean(
            metadata));
  }

  /**
   * Test {@link
   * MergeAnnotationAwareBeanDefinitionRegistryPostProcessor#isBroadleafAnnotationBean(MethodMetadata)}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link
   * MergeAnnotationAwareBeanDefinitionRegistryPostProcessor#isBroadleafAnnotationBean(MethodMetadata)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean MergeAnnotationAwareBeanDefinitionRegistryPostProcessor.isBroadleafAnnotationBean(MethodMetadata)"
  })
  public void testIsBroadleafAnnotationBean_thenReturnFalse() {
    // Arrange
    JarClassLoader classLoader = new JarClassLoader();
    MethodMetadataReadingVisitor metadata =
        new MethodMetadataReadingVisitor(
            "Method Name",
            1,
            "Declaring Class Name",
            "Return Type Name",
            classLoader,
            new HashSet<>());

    // Act and Assert
    assertFalse(
        mergeAnnotationAwareBeanDefinitionRegistryPostProcessor.isBroadleafAnnotationBean(
            metadata));
  }

  /**
   * Test {@link
   * MergeAnnotationAwareBeanDefinitionRegistryPostProcessor#isBroadleafBean(BeanDefinition)}.
   *
   * <ul>
   *   <li>Given {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link
   * MergeAnnotationAwareBeanDefinitionRegistryPostProcessor#isBroadleafBean(BeanDefinition)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean MergeAnnotationAwareBeanDefinitionRegistryPostProcessor.isBroadleafBean(BeanDefinition)"
  })
  public void testIsBroadleafBean_givenA() {
    // Arrange
    GenericBeanDefinition beanDefinition = new GenericBeanDefinition(new GenericBeanDefinition());
    GeneratedResource resource =
        new GeneratedResource(
            new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1},
            "The characteristics of someone or something");
    beanDefinition.setResource(resource);

    // Act and Assert
    assertFalse(
        mergeAnnotationAwareBeanDefinitionRegistryPostProcessor.isBroadleafBean(beanDefinition));
  }

  /**
   * Test {@link
   * MergeAnnotationAwareBeanDefinitionRegistryPostProcessor#isBroadleafBean(BeanDefinition)}.
   *
   * <ul>
   *   <li>Given {@link Resource} {@link Resource#getFilename()} return {@code bl-}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link
   * MergeAnnotationAwareBeanDefinitionRegistryPostProcessor#isBroadleafBean(BeanDefinition)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean MergeAnnotationAwareBeanDefinitionRegistryPostProcessor.isBroadleafBean(BeanDefinition)"
  })
  public void testIsBroadleafBean_givenResourceGetFilenameReturnBl_thenReturnTrue() {
    // Arrange
    Resource resource = mock(Resource.class);
    when(resource.getFilename()).thenReturn("bl-");

    GenericBeanDefinition beanDefinition = new GenericBeanDefinition(new GenericBeanDefinition());
    beanDefinition.setResource(resource);

    // Act
    boolean actualIsBroadleafBeanResult =
        mergeAnnotationAwareBeanDefinitionRegistryPostProcessor.isBroadleafBean(beanDefinition);

    // Assert
    verify(resource).getFilename();
    assertTrue(actualIsBroadleafBeanResult);
  }

  /**
   * Test {@link
   * MergeAnnotationAwareBeanDefinitionRegistryPostProcessor#isBroadleafBean(BeanDefinition)}.
   *
   * <ul>
   *   <li>Then throw {@link FactoryBeanNotInitializedException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * MergeAnnotationAwareBeanDefinitionRegistryPostProcessor#isBroadleafBean(BeanDefinition)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean MergeAnnotationAwareBeanDefinitionRegistryPostProcessor.isBroadleafBean(BeanDefinition)"
  })
  public void testIsBroadleafBean_thenThrowFactoryBeanNotInitializedException() {
    // Arrange
    Resource resource = mock(Resource.class);
    when(resource.getFilename()).thenThrow(new FactoryBeanNotInitializedException("Msg"));

    GenericBeanDefinition beanDefinition = new GenericBeanDefinition(new GenericBeanDefinition());
    beanDefinition.setResource(resource);

    // Act and Assert
    assertThrows(
        FactoryBeanNotInitializedException.class,
        () ->
            mergeAnnotationAwareBeanDefinitionRegistryPostProcessor.isBroadleafBean(
                beanDefinition));
    verify(resource).getFilename();
  }

  /**
   * Test {@link
   * MergeAnnotationAwareBeanDefinitionRegistryPostProcessor#isBroadleafBean(BeanDefinition)}.
   *
   * <ul>
   *   <li>When {@link GenericBeanDefinition#GenericBeanDefinition()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link
   * MergeAnnotationAwareBeanDefinitionRegistryPostProcessor#isBroadleafBean(BeanDefinition)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean MergeAnnotationAwareBeanDefinitionRegistryPostProcessor.isBroadleafBean(BeanDefinition)"
  })
  public void testIsBroadleafBean_whenGenericBeanDefinition_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(
        mergeAnnotationAwareBeanDefinitionRegistryPostProcessor.isBroadleafBean(
            new GenericBeanDefinition()));
  }

  /**
   * Test {@link
   * MergeAnnotationAwareBeanDefinitionRegistryPostProcessor#isBroadleafBean(BeanDefinition)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link
   * MergeAnnotationAwareBeanDefinitionRegistryPostProcessor#isBroadleafBean(BeanDefinition)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean MergeAnnotationAwareBeanDefinitionRegistryPostProcessor.isBroadleafBean(BeanDefinition)"
  })
  public void testIsBroadleafBean_whenNull_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(mergeAnnotationAwareBeanDefinitionRegistryPostProcessor.isBroadleafBean(null));
  }
}
