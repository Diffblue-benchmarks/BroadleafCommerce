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
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.mock;
import java.util.LinkedHashMap;
import java.util.function.BiFunction;
import org.broadleafcommerce.openadmin.dto.ClassTree;
import org.junit.Test;

public class PolymorphicEntityMapUtilDiffblueTest {
  /**
   * Method under test:
   * {@link PolymorphicEntityMapUtil#convertClassTreeToMap(ClassTree)}
   */
  @Test
  public void testConvertClassTreeToMap() {
    // Arrange
    PolymorphicEntityMapUtil polymorphicEntityMapUtil = new PolymorphicEntityMapUtil();

    // Act
    LinkedHashMap<String, String> actualConvertClassTreeToMapResult = polymorphicEntityMapUtil
        .convertClassTreeToMap(new ClassTree());

    // Assert
    assertEquals(1, actualConvertClassTreeToMapResult.size());
    assertNull(actualConvertClassTreeToMapResult.get(null));
  }

  /**
   * Method under test:
   * {@link PolymorphicEntityMapUtil#convertClassTreeToMap(ClassTree)}
   */
  @Test
  public void testConvertClassTreeToMap2() {
    // Arrange
    PolymorphicEntityMapUtil polymorphicEntityMapUtil = new PolymorphicEntityMapUtil();

    ClassTree polymorphicEntityTree = new ClassTree();
    polymorphicEntityTree.setFriendlyName(null);
    polymorphicEntityTree.setName("");

    // Act
    LinkedHashMap<String, String> actualConvertClassTreeToMapResult = polymorphicEntityMapUtil
        .convertClassTreeToMap(polymorphicEntityTree);

    // Assert
    assertEquals(1, actualConvertClassTreeToMapResult.size());
    assertEquals("", actualConvertClassTreeToMapResult.get(null));
  }

  /**
   * Method under test:
   * {@link PolymorphicEntityMapUtil#convertClassTreeToMap(ClassTree)}
   */
  @Test
  public void testConvertClassTreeToMap3() {
    // Arrange
    PolymorphicEntityMapUtil polymorphicEntityMapUtil = new PolymorphicEntityMapUtil();

    ClassTree polymorphicEntityTree = new ClassTree();
    polymorphicEntityTree.setChildren(new ClassTree[]{new ClassTree()});

    // Act
    LinkedHashMap<String, String> actualConvertClassTreeToMapResult = polymorphicEntityMapUtil
        .convertClassTreeToMap(polymorphicEntityTree);

    // Assert
    assertEquals(1, actualConvertClassTreeToMapResult.size());
    assertNull(actualConvertClassTreeToMapResult.get(null));
  }

  /**
   * Method under test:
   * {@link PolymorphicEntityMapUtil#buildPolymorphicEntityMap(ClassTree, LinkedHashMap)}
   */
  @Test
  public void testBuildPolymorphicEntityMap() {
    // Arrange
    PolymorphicEntityMapUtil polymorphicEntityMapUtil = new PolymorphicEntityMapUtil();
    ClassTree entity = new ClassTree();
    LinkedHashMap<String, String> map = new LinkedHashMap<>();

    // Act
    polymorphicEntityMapUtil.buildPolymorphicEntityMap(entity, map);

    // Assert
    assertEquals(1, map.size());
    assertNull(map.get(null));
  }

  /**
   * Method under test:
   * {@link PolymorphicEntityMapUtil#buildPolymorphicEntityMap(ClassTree, LinkedHashMap)}
   */
  @Test
  public void testBuildPolymorphicEntityMap2() {
    // Arrange
    PolymorphicEntityMapUtil polymorphicEntityMapUtil = new PolymorphicEntityMapUtil();

    ClassTree entity = new ClassTree();
    entity.setFriendlyName(null);
    entity.setName("");
    LinkedHashMap<String, String> map = new LinkedHashMap<>();

    // Act
    polymorphicEntityMapUtil.buildPolymorphicEntityMap(entity, map);

    // Assert
    assertEquals(1, map.size());
    assertEquals("", map.get(null));
  }

  /**
   * Method under test:
   * {@link PolymorphicEntityMapUtil#buildPolymorphicEntityMap(ClassTree, LinkedHashMap)}
   */
  @Test
  public void testBuildPolymorphicEntityMap3() {
    // Arrange
    PolymorphicEntityMapUtil polymorphicEntityMapUtil = new PolymorphicEntityMapUtil();

    ClassTree entity = new ClassTree();
    entity.setChildren(new ClassTree[]{new ClassTree()});
    LinkedHashMap<String, String> map = new LinkedHashMap<>();

    // Act
    polymorphicEntityMapUtil.buildPolymorphicEntityMap(entity, map);

    // Assert
    assertEquals(1, map.size());
    assertNull(map.get(null));
  }

  /**
   * Method under test:
   * {@link PolymorphicEntityMapUtil#buildPolymorphicEntityMap(ClassTree, LinkedHashMap)}
   */
  @Test
  public void testBuildPolymorphicEntityMap4() {
    // Arrange
    PolymorphicEntityMapUtil polymorphicEntityMapUtil = new PolymorphicEntityMapUtil();
    ClassTree entity = new ClassTree();

    LinkedHashMap<String, String> map = new LinkedHashMap<>();
    map.replaceAll(mock(BiFunction.class));

    // Act
    polymorphicEntityMapUtil.buildPolymorphicEntityMap(entity, map);

    // Assert
    assertEquals(1, map.size());
    assertNull(map.get(null));
  }
}
