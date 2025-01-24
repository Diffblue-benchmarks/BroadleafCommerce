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
   * Test {@link PolymorphicEntityMapUtil#convertClassTreeToMap(ClassTree)}.
   * <ul>
   *   <li>Given array of {@link ClassTree} with {@link ClassTree#ClassTree()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PolymorphicEntityMapUtil#convertClassTreeToMap(ClassTree)}
   */
  @Test
  public void testConvertClassTreeToMap_givenArrayOfClassTreeWithClassTree() {
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
   * Test {@link PolymorphicEntityMapUtil#convertClassTreeToMap(ClassTree)}.
   * <ul>
   *   <li>Given empty string.</li>
   *   <li>Then return {@code null} is empty string.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PolymorphicEntityMapUtil#convertClassTreeToMap(ClassTree)}
   */
  @Test
  public void testConvertClassTreeToMap_givenEmptyString_thenReturnNullIsEmptyString() {
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
   * Test {@link PolymorphicEntityMapUtil#convertClassTreeToMap(ClassTree)}.
   * <ul>
   *   <li>When {@link ClassTree#ClassTree()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PolymorphicEntityMapUtil#convertClassTreeToMap(ClassTree)}
   */
  @Test
  public void testConvertClassTreeToMap_whenClassTree_thenReturnNull() {
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
   * Test
   * {@link PolymorphicEntityMapUtil#buildPolymorphicEntityMap(ClassTree, LinkedHashMap)}.
   * <ul>
   *   <li>Given array of {@link ClassTree} with {@link ClassTree#ClassTree()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PolymorphicEntityMapUtil#buildPolymorphicEntityMap(ClassTree, LinkedHashMap)}
   */
  @Test
  public void testBuildPolymorphicEntityMap_givenArrayOfClassTreeWithClassTree() {
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
   * Test
   * {@link PolymorphicEntityMapUtil#buildPolymorphicEntityMap(ClassTree, LinkedHashMap)}.
   * <ul>
   *   <li>Given {@link BiFunction}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PolymorphicEntityMapUtil#buildPolymorphicEntityMap(ClassTree, LinkedHashMap)}
   */
  @Test
  public void testBuildPolymorphicEntityMap_givenBiFunction() {
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

  /**
   * Test
   * {@link PolymorphicEntityMapUtil#buildPolymorphicEntityMap(ClassTree, LinkedHashMap)}.
   * <ul>
   *   <li>Then {@link LinkedHashMap#LinkedHashMap()} {@code null} is empty
   * string.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PolymorphicEntityMapUtil#buildPolymorphicEntityMap(ClassTree, LinkedHashMap)}
   */
  @Test
  public void testBuildPolymorphicEntityMap_thenLinkedHashMapNullIsEmptyString() {
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
   * Test
   * {@link PolymorphicEntityMapUtil#buildPolymorphicEntityMap(ClassTree, LinkedHashMap)}.
   * <ul>
   *   <li>When {@link ClassTree#ClassTree()}.</li>
   *   <li>Then {@link LinkedHashMap#LinkedHashMap()} {@code null} is
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PolymorphicEntityMapUtil#buildPolymorphicEntityMap(ClassTree, LinkedHashMap)}
   */
  @Test
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

  /**
   * Test new {@link PolymorphicEntityMapUtil} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link PolymorphicEntityMapUtil}
   */
  @Test
  public void testNewPolymorphicEntityMapUtil() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing observers.
    //   Diffblue Cover was unable to create an assertion.
    //   There are no fields that could be asserted on.

    // Arrange and Act
    new PolymorphicEntityMapUtil();
  }
}
