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
   * Method under test:
   * {@link AnnotationsCopyClassTransformer#getImplementationType(String)}
   */
  @Test
  public void testGetImplementationType() {
    // Arrange, Act and Assert
    assertEquals("Class Name", annotationsCopyClassTransformer.getImplementationType("Class Name"));
    assertEquals("java.util.ArrayList", annotationsCopyClassTransformer.getImplementationType("java.util.List"));
    assertEquals("java.util.HashMap", annotationsCopyClassTransformer.getImplementationType("java.util.Map"));
    assertEquals("java.util.HashSet", annotationsCopyClassTransformer.getImplementationType("java.util.Set"));
    assertNull(annotationsCopyClassTransformer.getImplementationType("["));
  }

  /**
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
}
