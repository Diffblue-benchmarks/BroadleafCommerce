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
package org.broadleafcommerce.common.extensibility.jpa.copy;

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

@ContextConfiguration(classes = {RemoveAnnotationClassTransformer.class, String.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class RemoveAnnotationClassTransformerDiffblueTest {
  @Autowired
  private RemoveAnnotationClassTransformer removeAnnotationClassTransformer;

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>
   * {@link RemoveAnnotationClassTransformer#RemoveAnnotationClassTransformer(String)}
   *   <li>{@link RemoveAnnotationClassTransformer#setAnnotationClass(String)}
   *   <li>{@link RemoveAnnotationClassTransformer#setBeanFactory(BeanFactory)}
   *   <li>{@link RemoveAnnotationClassTransformer#setClassNames(List)}
   *   <li>
   * {@link RemoveAnnotationClassTransformer#setConditionalPropertyName(String)}
   *   <li>
   * {@link RemoveAnnotationClassTransformer#compileJPAProperties(Properties, Object)}
   *   <li>{@link RemoveAnnotationClassTransformer#getAnnotationClass()}
   *   <li>{@link RemoveAnnotationClassTransformer#getClassNames()}
   *   <li>{@link RemoveAnnotationClassTransformer#getConditionalPropertyName()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() throws Exception {
    // Arrange and Act
    RemoveAnnotationClassTransformer actualRemoveAnnotationClassTransformer = new RemoveAnnotationClassTransformer(
        "Module Name");
    actualRemoveAnnotationClassTransformer.setAnnotationClass("Annotation Class");
    actualRemoveAnnotationClassTransformer.setBeanFactory(new DefaultListableBeanFactory());
    ArrayList<String> classNames = new ArrayList<>();
    actualRemoveAnnotationClassTransformer.setClassNames(classNames);
    actualRemoveAnnotationClassTransformer.setConditionalPropertyName("Conditional Property Name");
    actualRemoveAnnotationClassTransformer.compileJPAProperties(new Properties(), BLCFieldUtils.NULL_FIELD);
    String actualAnnotationClass = actualRemoveAnnotationClassTransformer.getAnnotationClass();
    List<String> actualClassNames = actualRemoveAnnotationClassTransformer.getClassNames();

    // Assert that nothing has changed
    assertEquals("Annotation Class", actualAnnotationClass);
    assertEquals("Conditional Property Name", actualRemoveAnnotationClassTransformer.getConditionalPropertyName());
    assertTrue(actualClassNames.isEmpty());
    assertTrue(actualRemoveAnnotationClassTransformer.preLoadClassNamePatterns.isEmpty());
    assertSame(classNames, actualClassNames);
  }

  /**
   * Test
   * {@link RemoveAnnotationClassTransformer#stripAnnotation(ConstPool, List)}.
   * <ul>
   *   <li>Then return Name is {@code RuntimeVisibleAnnotations}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RemoveAnnotationClassTransformer#stripAnnotation(ConstPool, List)}
   */
  @Test
  public void testStripAnnotation_thenReturnNameIsRuntimeVisibleAnnotations() {
    // Arrange
    ConstPool constantPool = new ConstPool("Thisclass");

    // Act
    AnnotationsAttribute actualStripAnnotationResult = removeAnnotationClassTransformer.stripAnnotation(constantPool,
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
   * Test {@link RemoveAnnotationClassTransformer#isPropertyEnabled(String)}.
   * <p>
   * Method under test:
   * {@link RemoveAnnotationClassTransformer#isPropertyEnabled(String)}
   */
  @Test
  public void testIsPropertyEnabled() {
    // Arrange, Act and Assert
    assertFalse(removeAnnotationClassTransformer.isPropertyEnabled("Property Name"));
  }
}
