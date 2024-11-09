/*-
 * #%L
 * BroadleafCommerce Open Admin Platform
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
package org.broadleafcommerce.openadmin.dto;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import java.util.List;
import org.junit.Test;

public class ClassTreeDiffblueTest {
  /**
   * Test {@link ClassTree#ClassTree()}.
   * <p>
   * Method under test: {@link ClassTree#ClassTree()}
   */
  @Test
  public void testNewClassTree() {
    // Arrange and Act
    ClassTree actualClassTree = new ClassTree();

    // Assert
    assertNull(actualClassTree.getFriendlyName());
    assertNull(actualClassTree.getFullyQualifiedClassname());
    assertNull(actualClassTree.getName());
    assertNull(actualClassTree.friendlyName);
    assertEquals(0, actualClassTree.getLeft());
    assertEquals(0, actualClassTree.getRight());
    assertEquals(0, actualClassTree.getChildren().length);
    List<ClassTree> collapsedClassTrees = actualClassTree.getCollapsedClassTrees();
    assertEquals(1, collapsedClassTrees.size());
    assertFalse(actualClassTree.hasChildren());
    assertFalse(actualClassTree.isExcludeFromPolymorphism());
    assertSame(actualClassTree, collapsedClassTrees.get(0));
  }

  /**
   * Test {@link ClassTree#ClassTree()}.
   * <p>
   * Method under test: {@link ClassTree#ClassTree()}
   */
  @Test
  public void testNewClassTree2() {
    // Arrange and Act
    ClassTree actualClassTree = new ClassTree();

    // Assert
    assertNull(actualClassTree.getFriendlyName());
    assertNull(actualClassTree.getFullyQualifiedClassname());
    assertNull(actualClassTree.getName());
    assertNull(actualClassTree.friendlyName);
    assertEquals(0, actualClassTree.getLeft());
    assertEquals(0, actualClassTree.getRight());
    assertEquals(0, actualClassTree.getChildren().length);
    List<ClassTree> collapsedClassTrees = actualClassTree.getCollapsedClassTrees();
    assertEquals(1, collapsedClassTrees.size());
    assertFalse(actualClassTree.hasChildren());
    assertFalse(actualClassTree.isExcludeFromPolymorphism());
    assertSame(actualClassTree, collapsedClassTrees.get(0));
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ClassTree#setChildren(ClassTree[])}
   *   <li>{@link ClassTree#setFriendlyName(String)}
   *   <li>{@link ClassTree#setLeft(int)}
   *   <li>{@link ClassTree#setName(String)}
   *   <li>{@link ClassTree#setRight(int)}
   *   <li>{@link ClassTree#getChildren()}
   *   <li>{@link ClassTree#getFullyQualifiedClassname()}
   *   <li>{@link ClassTree#getLeft()}
   *   <li>{@link ClassTree#getName()}
   *   <li>{@link ClassTree#getRight()}
   *   <li>{@link ClassTree#isExcludeFromPolymorphism()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    ClassTree classTree = new ClassTree();
    ClassTree[] children = new ClassTree[]{new ClassTree()};

    // Act
    classTree.setChildren(children);
    classTree.setFriendlyName("Friendly Name");
    classTree.setLeft(1);
    classTree.setName("Name");
    classTree.setRight(1);
    ClassTree[] actualChildren = classTree.getChildren();
    classTree.getFullyQualifiedClassname();
    int actualLeft = classTree.getLeft();
    String actualName = classTree.getName();
    int actualRight = classTree.getRight();

    // Assert that nothing has changed
    assertEquals("Name", actualName);
    assertEquals(1, actualLeft);
    assertEquals(1, actualRight);
    assertFalse(classTree.isExcludeFromPolymorphism());
    assertSame(children, actualChildren);
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ClassTree#setChildren(ClassTree[])}
   *   <li>{@link ClassTree#setFriendlyName(String)}
   *   <li>{@link ClassTree#setLeft(int)}
   *   <li>{@link ClassTree#setName(String)}
   *   <li>{@link ClassTree#setRight(int)}
   *   <li>{@link ClassTree#getChildren()}
   *   <li>{@link ClassTree#getFullyQualifiedClassname()}
   *   <li>{@link ClassTree#getLeft()}
   *   <li>{@link ClassTree#getName()}
   *   <li>{@link ClassTree#getRight()}
   *   <li>{@link ClassTree#isExcludeFromPolymorphism()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters2() {
    // Arrange
    ClassTree classTree = new ClassTree();
    ClassTree[] children = new ClassTree[]{new ClassTree()};

    // Act
    classTree.setChildren(children);
    classTree.setFriendlyName("Friendly Name");
    classTree.setLeft(1);
    classTree.setName("Name");
    classTree.setRight(1);
    ClassTree[] actualChildren = classTree.getChildren();
    classTree.getFullyQualifiedClassname();
    int actualLeft = classTree.getLeft();
    String actualName = classTree.getName();
    int actualRight = classTree.getRight();

    // Assert that nothing has changed
    assertEquals("Name", actualName);
    assertEquals(1, actualLeft);
    assertEquals(1, actualRight);
    assertFalse(classTree.isExcludeFromPolymorphism());
    assertSame(children, actualChildren);
  }
}
