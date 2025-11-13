package org.broadleafcommerce.openadmin.dto;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.List;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class ClassTreeDiffblueTest {
  /**
   * Test {@link ClassTree#ClassTree()}.
   *
   * <p>Method under test: {@link ClassTree#ClassTree()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ClassTree.<init>()"})
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
   *
   * <p>Method under test: {@link ClassTree#ClassTree()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ClassTree.<init>()"})
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
   *
   * <p>Methods under test:
   *
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ClassTree[] ClassTree.getChildren()",
    "String ClassTree.getFullyQualifiedClassname()",
    "int ClassTree.getLeft()",
    "String ClassTree.getName()",
    "int ClassTree.getRight()",
    "boolean ClassTree.isExcludeFromPolymorphism()",
    "void ClassTree.setChildren(ClassTree[])",
    "void ClassTree.setFriendlyName(String)",
    "void ClassTree.setLeft(int)",
    "void ClassTree.setName(String)",
    "void ClassTree.setRight(int)"
  })
  public void testGettersAndSetters() {
    // Arrange
    ClassTree classTree = new ClassTree();
    ClassTree[] children = new ClassTree[] {new ClassTree()};

    // Act
    classTree.setChildren(children);
    classTree.setFriendlyName("Friendly Name");
    classTree.setLeft(1);
    classTree.setName("Name");
    classTree.setRight(1);
    ClassTree[] actualChildren = classTree.getChildren();
    String actualFullyQualifiedClassname = classTree.getFullyQualifiedClassname();
    int actualLeft = classTree.getLeft();
    String actualName = classTree.getName();
    int actualRight = classTree.getRight();

    // Assert
    assertEquals("Name", actualName);
    assertNull(actualFullyQualifiedClassname);
    assertEquals(1, actualLeft);
    assertEquals(1, actualRight);
    assertFalse(classTree.isExcludeFromPolymorphism());
    assertSame(children, actualChildren);
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ClassTree[] ClassTree.getChildren()",
    "String ClassTree.getFullyQualifiedClassname()",
    "int ClassTree.getLeft()",
    "String ClassTree.getName()",
    "int ClassTree.getRight()",
    "boolean ClassTree.isExcludeFromPolymorphism()",
    "void ClassTree.setChildren(ClassTree[])",
    "void ClassTree.setFriendlyName(String)",
    "void ClassTree.setLeft(int)",
    "void ClassTree.setName(String)",
    "void ClassTree.setRight(int)"
  })
  public void testGettersAndSetters2() {
    // Arrange
    ClassTree classTree = new ClassTree();
    ClassTree[] children = new ClassTree[] {new ClassTree()};

    // Act
    classTree.setChildren(children);
    classTree.setFriendlyName("Friendly Name");
    classTree.setLeft(1);
    classTree.setName("Name");
    classTree.setRight(1);
    ClassTree[] actualChildren = classTree.getChildren();
    String actualFullyQualifiedClassname = classTree.getFullyQualifiedClassname();
    int actualLeft = classTree.getLeft();
    String actualName = classTree.getName();
    int actualRight = classTree.getRight();

    // Assert
    assertEquals("Name", actualName);
    assertNull(actualFullyQualifiedClassname);
    assertEquals(1, actualLeft);
    assertEquals(1, actualRight);
    assertFalse(classTree.isExcludeFromPolymorphism());
    assertSame(children, actualChildren);
  }
}
