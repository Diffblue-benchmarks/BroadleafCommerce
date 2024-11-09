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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import org.broadleafcommerce.common.util.BLCFieldUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {AnnotationsCopyClassTransformer.class, String.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class AnnotationsCopyClassTransformerDiffblueTest {
  @Autowired
  private AnnotationsCopyClassTransformer annotationsCopyClassTransformer;

  /**
   * Test
   * {@link AnnotationsCopyClassTransformer#AnnotationsCopyClassTransformer(String)}.
   * <p>
   * Method under test:
   * {@link AnnotationsCopyClassTransformer#AnnotationsCopyClassTransformer(String)}
   */
  @Test
  public void testNewAnnotationsCopyClassTransformer() {
    // Arrange and Act
    AnnotationsCopyClassTransformer actualAnnotationsCopyClassTransformer = new AnnotationsCopyClassTransformer(
        "Module Name");

    // Assert
    assertEquals("Module Name", actualAnnotationsCopyClassTransformer.moduleName);
    assertTrue(actualAnnotationsCopyClassTransformer.getXformTemplates().isEmpty());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AnnotationsCopyClassTransformer#setXformTemplates(Map)}
   *   <li>
   * {@link AnnotationsCopyClassTransformer#compileJPAProperties(Properties, Object)}
   *   <li>{@link AnnotationsCopyClassTransformer#getXformTemplates()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() throws Exception {
    // Arrange
    AnnotationsCopyClassTransformer annotationsCopyClassTransformer = new AnnotationsCopyClassTransformer(
        "Module Name");
    HashMap<String, String> xformTemplates = new HashMap<>();

    // Act
    annotationsCopyClassTransformer.setXformTemplates(xformTemplates);
    annotationsCopyClassTransformer.compileJPAProperties(new Properties(), BLCFieldUtils.NULL_FIELD);
    Map<String, String> actualXformTemplates = annotationsCopyClassTransformer.getXformTemplates();

    // Assert that nothing has changed
    assertTrue(actualXformTemplates.isEmpty());
    assertSame(xformTemplates, actualXformTemplates);
  }

  /**
   * Test {@link AnnotationsCopyClassTransformer#getImplementationType(String)}.
   * <ul>
   *   <li>When {@code Class Name}.</li>
   *   <li>Then return {@code Class Name}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AnnotationsCopyClassTransformer#getImplementationType(String)}
   */
  @Test
  public void testGetImplementationType_whenClassName_thenReturnClassName() {
    // Arrange, Act and Assert
    assertEquals("Class Name", annotationsCopyClassTransformer.getImplementationType("Class Name"));
  }

  /**
   * Test {@link AnnotationsCopyClassTransformer#getImplementationType(String)}.
   * <ul>
   *   <li>When {@code java.util.List}.</li>
   *   <li>Then return {@code java.util.ArrayList}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AnnotationsCopyClassTransformer#getImplementationType(String)}
   */
  @Test
  public void testGetImplementationType_whenJavaUtilList_thenReturnJavaUtilArrayList() {
    // Arrange, Act and Assert
    assertEquals("java.util.ArrayList", annotationsCopyClassTransformer.getImplementationType("java.util.List"));
  }

  /**
   * Test {@link AnnotationsCopyClassTransformer#getImplementationType(String)}.
   * <ul>
   *   <li>When {@code java.util.Map}.</li>
   *   <li>Then return {@code java.util.HashMap}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AnnotationsCopyClassTransformer#getImplementationType(String)}
   */
  @Test
  public void testGetImplementationType_whenJavaUtilMap_thenReturnJavaUtilHashMap() {
    // Arrange, Act and Assert
    assertEquals("java.util.HashMap", annotationsCopyClassTransformer.getImplementationType("java.util.Map"));
  }

  /**
   * Test {@link AnnotationsCopyClassTransformer#getImplementationType(String)}.
   * <ul>
   *   <li>When {@code java.util.Set}.</li>
   *   <li>Then return {@code java.util.HashSet}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AnnotationsCopyClassTransformer#getImplementationType(String)}
   */
  @Test
  public void testGetImplementationType_whenJavaUtilSet_thenReturnJavaUtilHashSet() {
    // Arrange, Act and Assert
    assertEquals("java.util.HashSet", annotationsCopyClassTransformer.getImplementationType("java.util.Set"));
  }

  /**
   * Test {@link AnnotationsCopyClassTransformer#getImplementationType(String)}.
   * <ul>
   *   <li>When {@code [}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AnnotationsCopyClassTransformer#getImplementationType(String)}
   */
  @Test
  public void testGetImplementationType_whenLeftSquareBracket_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(annotationsCopyClassTransformer.getImplementationType("["));
  }
}
