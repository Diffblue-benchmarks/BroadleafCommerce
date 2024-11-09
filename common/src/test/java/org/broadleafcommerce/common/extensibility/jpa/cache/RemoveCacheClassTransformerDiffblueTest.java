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
package org.broadleafcommerce.common.extensibility.jpa.cache;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import javassist.bytecode.AnnotationsAttribute;
import javassist.bytecode.ConstPool;
import org.broadleafcommerce.common.util.BLCFieldUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {RemoveCacheClassTransformer.class, String.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class RemoveCacheClassTransformerDiffblueTest {
  @Autowired
  private RemoveCacheClassTransformer removeCacheClassTransformer;

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link RemoveCacheClassTransformer#RemoveCacheClassTransformer(String)}
   *   <li>{@link RemoveCacheClassTransformer#setAnnotationClass(String)}
   *   <li>{@link RemoveCacheClassTransformer#setBeanFactory(BeanFactory)}
   *   <li>{@link RemoveCacheClassTransformer#setCacheRegions(List)}
   *   <li>{@link RemoveCacheClassTransformer#setClassNames(List)}
   *   <li>
   * {@link RemoveCacheClassTransformer#compileJPAProperties(Properties, Object)}
   *   <li>{@link RemoveCacheClassTransformer#getAnnotationClass()}
   *   <li>{@link RemoveCacheClassTransformer#getCacheRegions()}
   *   <li>{@link RemoveCacheClassTransformer#getClassNames()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() throws Exception {
    // Arrange and Act
    RemoveCacheClassTransformer actualRemoveCacheClassTransformer = new RemoveCacheClassTransformer("Module Name");
    actualRemoveCacheClassTransformer.setAnnotationClass("Annotation Class");
    actualRemoveCacheClassTransformer.setBeanFactory(new DefaultListableBeanFactory());
    ArrayList<String> cacheRegions = new ArrayList<>();
    actualRemoveCacheClassTransformer.setCacheRegions(cacheRegions);
    ArrayList<String> classNames = new ArrayList<>();
    actualRemoveCacheClassTransformer.setClassNames(classNames);
    actualRemoveCacheClassTransformer.compileJPAProperties(new Properties(), BLCFieldUtils.NULL_FIELD);
    String actualAnnotationClass = actualRemoveCacheClassTransformer.getAnnotationClass();
    List<String> actualCacheRegions = actualRemoveCacheClassTransformer.getCacheRegions();
    List<String> actualClassNames = actualRemoveCacheClassTransformer.getClassNames();

    // Assert that nothing has changed
    assertEquals("Annotation Class", actualAnnotationClass);
    assertTrue(actualCacheRegions.isEmpty());
    assertTrue(actualClassNames.isEmpty());
    assertSame(cacheRegions, actualCacheRegions);
    assertSame(classNames, actualClassNames);
  }

  /**
   * Test {@link RemoveCacheClassTransformer#classQualifies(String)}.
   * <p>
   * Method under test: {@link RemoveCacheClassTransformer#classQualifies(String)}
   */
  @Test
  public void testClassQualifies() {
    // Arrange, Act and Assert
    assertTrue(removeCacheClassTransformer.classQualifies("Class Name"));
  }

  /**
   * Test
   * {@link RemoveCacheClassTransformer#annotationQualifies(ConstPool, List)}.
   * <p>
   * Method under test:
   * {@link RemoveCacheClassTransformer#annotationQualifies(ConstPool, List)}
   */
  @Test
  public void testAnnotationQualifies() {
    // Arrange
    ConstPool constantPool = new ConstPool("Thisclass");

    // Act and Assert
    assertFalse(removeCacheClassTransformer.annotationQualifies(constantPool, new ArrayList<>()));
  }

  /**
   * Test {@link RemoveCacheClassTransformer#stripAnnotation(ConstPool, List)}.
   * <p>
   * Method under test:
   * {@link RemoveCacheClassTransformer#stripAnnotation(ConstPool, List)}
   */
  @Test
  public void testStripAnnotation() {
    // Arrange
    ConstPool constantPool = new ConstPool("RuntimeVisibleAnnotations");

    // Act
    AnnotationsAttribute actualStripAnnotationResult = removeCacheClassTransformer.stripAnnotation(constantPool,
        new ArrayList<>());

    // Assert
    assertEquals("RuntimeVisibleAnnotations", actualStripAnnotationResult.getName());
    assertEquals(0, actualStripAnnotationResult.getAnnotations().length);
    assertEquals(3, constantPool.getSize());
    assertEquals(8, actualStripAnnotationResult.length());
    assertSame(constantPool, actualStripAnnotationResult.getConstPool());
    assertArrayEquals(new byte[]{0, 0}, actualStripAnnotationResult.get());
  }

  /**
   * Test {@link RemoveCacheClassTransformer#stripAnnotation(ConstPool, List)}.
   * <ul>
   *   <li>Then {@link ConstPool#ConstPool(String)} with {@code Thisclass} Size is
   * four.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RemoveCacheClassTransformer#stripAnnotation(ConstPool, List)}
   */
  @Test
  public void testStripAnnotation_thenConstPoolWithThisclassSizeIsFour() {
    // Arrange
    ConstPool constantPool = new ConstPool("Thisclass");

    // Act
    AnnotationsAttribute actualStripAnnotationResult = removeCacheClassTransformer.stripAnnotation(constantPool,
        new ArrayList<>());

    // Assert
    assertEquals("RuntimeVisibleAnnotations", actualStripAnnotationResult.getName());
    assertEquals(0, actualStripAnnotationResult.getAnnotations().length);
    assertEquals(4, constantPool.getSize());
    assertEquals(8, actualStripAnnotationResult.length());
    assertSame(constantPool, actualStripAnnotationResult.getConstPool());
    assertArrayEquals(new byte[]{0, 0}, actualStripAnnotationResult.get());
  }

  /**
   * Test {@link RemoveCacheClassTransformer#isPropertyEnabled(String)}.
   * <p>
   * Method under test:
   * {@link RemoveCacheClassTransformer#isPropertyEnabled(String)}
   */
  @Test
  public void testIsPropertyEnabled() {
    // Arrange, Act and Assert
    assertFalse(removeCacheClassTransformer.isPropertyEnabled("Property Name"));
  }
}
