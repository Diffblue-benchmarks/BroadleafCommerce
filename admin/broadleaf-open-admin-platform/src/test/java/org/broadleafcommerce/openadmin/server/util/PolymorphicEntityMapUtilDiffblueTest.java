package org.broadleafcommerce.openadmin.server.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.LinkedHashMap;
import org.broadleafcommerce.openadmin.dto.ClassTree;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class PolymorphicEntityMapUtilDiffblueTest {
  /**
   * Test {@link PolymorphicEntityMapUtil#convertClassTreeToMap(ClassTree)}.
   *
   * <ul>
   *   <li>Given array of {@link ClassTree} with {@link ClassTree#ClassTree()}.
   * </ul>
   *
   * <p>Method under test: {@link PolymorphicEntityMapUtil#convertClassTreeToMap(ClassTree)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"LinkedHashMap PolymorphicEntityMapUtil.convertClassTreeToMap(ClassTree)"})
  public void testConvertClassTreeToMap_givenArrayOfClassTreeWithClassTree() {
    // Arrange
    PolymorphicEntityMapUtil polymorphicEntityMapUtil = new PolymorphicEntityMapUtil();

    ClassTree polymorphicEntityTree = new ClassTree();
    polymorphicEntityTree.setChildren(new ClassTree[] {new ClassTree()});

    // Act
    LinkedHashMap<String, String> actualConvertClassTreeToMapResult =
        polymorphicEntityMapUtil.convertClassTreeToMap(polymorphicEntityTree);

    // Assert
    assertEquals(1, actualConvertClassTreeToMapResult.size());
    assertNull(actualConvertClassTreeToMapResult.get(null));
  }

  /**
   * Test {@link PolymorphicEntityMapUtil#convertClassTreeToMap(ClassTree)}.
   *
   * <ul>
   *   <li>Then return {@code Dr Jane Doe}.
   * </ul>
   *
   * <p>Method under test: {@link PolymorphicEntityMapUtil#convertClassTreeToMap(ClassTree)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"LinkedHashMap PolymorphicEntityMapUtil.convertClassTreeToMap(ClassTree)"})
  public void testConvertClassTreeToMap_thenReturnDrJaneDoe() {
    // Arrange
    PolymorphicEntityMapUtil polymorphicEntityMapUtil = new PolymorphicEntityMapUtil();

    // Act
    LinkedHashMap<String, String> actualConvertClassTreeToMapResult =
        polymorphicEntityMapUtil.convertClassTreeToMap(new ClassTree("Dr Jane Doe"));

    // Assert
    assertEquals(1, actualConvertClassTreeToMapResult.size());
    assertEquals("Dr Jane Doe", actualConvertClassTreeToMapResult.get("Dr Jane Doe"));
  }

  /**
   * Test {@link PolymorphicEntityMapUtil#convertClassTreeToMap(ClassTree)}.
   *
   * <ul>
   *   <li>When {@link ClassTree#ClassTree()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PolymorphicEntityMapUtil#convertClassTreeToMap(ClassTree)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"LinkedHashMap PolymorphicEntityMapUtil.convertClassTreeToMap(ClassTree)"})
  public void testConvertClassTreeToMap_whenClassTree_thenReturnNull() {
    // Arrange
    PolymorphicEntityMapUtil polymorphicEntityMapUtil = new PolymorphicEntityMapUtil();

    // Act
    LinkedHashMap<String, String> actualConvertClassTreeToMapResult =
        polymorphicEntityMapUtil.convertClassTreeToMap(new ClassTree());

    // Assert
    assertEquals(1, actualConvertClassTreeToMapResult.size());
    assertNull(actualConvertClassTreeToMapResult.get(null));
  }

  /**
   * Test {@link PolymorphicEntityMapUtil#buildPolymorphicEntityMap(ClassTree, LinkedHashMap)}.
   *
   * <ul>
   *   <li>Given array of {@link ClassTree} with {@link ClassTree#ClassTree()}.
   * </ul>
   *
   * <p>Method under test: {@link PolymorphicEntityMapUtil#buildPolymorphicEntityMap(ClassTree,
   * LinkedHashMap)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PolymorphicEntityMapUtil.buildPolymorphicEntityMap(ClassTree, LinkedHashMap)"
  })
  public void testBuildPolymorphicEntityMap_givenArrayOfClassTreeWithClassTree() {
    // Arrange
    PolymorphicEntityMapUtil polymorphicEntityMapUtil = new PolymorphicEntityMapUtil();

    ClassTree entity = new ClassTree();
    entity.setChildren(new ClassTree[] {new ClassTree()});
    LinkedHashMap<String, String> map = new LinkedHashMap<>();

    // Act
    polymorphicEntityMapUtil.buildPolymorphicEntityMap(entity, map);

    // Assert
    assertEquals(1, map.size());
    assertNull(map.get(null));
  }

  /**
   * Test {@link PolymorphicEntityMapUtil#buildPolymorphicEntityMap(ClassTree, LinkedHashMap)}.
   *
   * <ul>
   *   <li>Then {@link LinkedHashMap#LinkedHashMap()} {@code Dr Jane Doe} is {@code Dr Jane Doe}.
   * </ul>
   *
   * <p>Method under test: {@link PolymorphicEntityMapUtil#buildPolymorphicEntityMap(ClassTree,
   * LinkedHashMap)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PolymorphicEntityMapUtil.buildPolymorphicEntityMap(ClassTree, LinkedHashMap)"
  })
  public void testBuildPolymorphicEntityMap_thenLinkedHashMapDrJaneDoeIsDrJaneDoe() {
    // Arrange
    PolymorphicEntityMapUtil polymorphicEntityMapUtil = new PolymorphicEntityMapUtil();
    ClassTree entity = new ClassTree("Dr Jane Doe");
    LinkedHashMap<String, String> map = new LinkedHashMap<>();

    // Act
    polymorphicEntityMapUtil.buildPolymorphicEntityMap(entity, map);

    // Assert
    assertEquals(1, map.size());
    assertEquals("Dr Jane Doe", map.get("Dr Jane Doe"));
  }

  /**
   * Test {@link PolymorphicEntityMapUtil#buildPolymorphicEntityMap(ClassTree, LinkedHashMap)}.
   *
   * <ul>
   *   <li>When {@link ClassTree#ClassTree()}.
   *   <li>Then {@link LinkedHashMap#LinkedHashMap()} {@code null} is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PolymorphicEntityMapUtil#buildPolymorphicEntityMap(ClassTree,
   * LinkedHashMap)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PolymorphicEntityMapUtil.buildPolymorphicEntityMap(ClassTree, LinkedHashMap)"
  })
  public void testBuildPolymorphicEntityMap_whenClassTree_thenLinkedHashMapNullIsNull() {
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
}
