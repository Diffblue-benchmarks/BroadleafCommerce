package org.broadleafcommerce.common.extensibility.context.merge.handlers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.metadata.IIOMetadataNode;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.w3c.dom.Node;

@ContextConfiguration(classes = {NonEmptyNodeReplaceInsert.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class NonEmptyNodeReplaceInsertDiffblueTest {
  @Autowired private NonEmptyNodeReplaceInsert nonEmptyNodeReplaceInsert;

  /**
   * Test {@link NonEmptyNodeReplaceInsert#replaceNode(Node[], Node, String, List)}.
   *
   * <ul>
   *   <li>Given {@link IIOMetadataNode#IIOMetadataNode()}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link IIOMetadataNode#IIOMetadataNode()}.
   * </ul>
   *
   * <p>Method under test: {@link NonEmptyNodeReplaceInsert#replaceNode(Node[], Node, String, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean NonEmptyNodeReplaceInsert.replaceNode(Node[], Node, String, List)"})
  public void testReplaceNode_givenIIOMetadataNode_whenArrayListAddIIOMetadataNode() {
    // Arrange
    IIOMetadataNode testNode = new IIOMetadataNode();

    ArrayList<Node> usedNodes = new ArrayList<>();
    usedNodes.add(new IIOMetadataNode());

    // Act and Assert
    assertFalse(
        nonEmptyNodeReplaceInsert.replaceNode(
            new Node[] {new IIOMetadataNode()}, testNode, "Attribute", usedNodes));
  }

  /**
   * Test {@link NonEmptyNodeReplaceInsert#replaceNode(Node[], Node, String, List)}.
   *
   * <ul>
   *   <li>Given {@link IIOMetadataNode#IIOMetadataNode()}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link IIOMetadataNode#IIOMetadataNode()}.
   * </ul>
   *
   * <p>Method under test: {@link NonEmptyNodeReplaceInsert#replaceNode(Node[], Node, String, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean NonEmptyNodeReplaceInsert.replaceNode(Node[], Node, String, List)"})
  public void testReplaceNode_givenIIOMetadataNode_whenArrayListAddIIOMetadataNode2() {
    // Arrange
    IIOMetadataNode testNode = new IIOMetadataNode();

    ArrayList<Node> usedNodes = new ArrayList<>();
    usedNodes.add(new IIOMetadataNode());
    usedNodes.add(new IIOMetadataNode());

    // Act and Assert
    assertFalse(
        nonEmptyNodeReplaceInsert.replaceNode(
            new Node[] {new IIOMetadataNode()}, testNode, "Attribute", usedNodes));
  }

  /**
   * Test {@link NonEmptyNodeReplaceInsert#replaceNode(Node[], Node, String, List)}.
   *
   * <ul>
   *   <li>When {@link IIOMetadataNode#IIOMetadataNode()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link NonEmptyNodeReplaceInsert#replaceNode(Node[], Node, String, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean NonEmptyNodeReplaceInsert.replaceNode(Node[], Node, String, List)"})
  public void testReplaceNode_whenIIOMetadataNode_thenReturnFalse() {
    // Arrange
    IIOMetadataNode testNode = new IIOMetadataNode();

    // Act and Assert
    assertFalse(
        nonEmptyNodeReplaceInsert.replaceNode(
            new Node[] {new IIOMetadataNode()}, testNode, "Attribute", new ArrayList<>()));
  }

  /**
   * Test new {@link NonEmptyNodeReplaceInsert} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link NonEmptyNodeReplaceInsert}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void NonEmptyNodeReplaceInsert.<init>()"})
  public void testNewNonEmptyNodeReplaceInsert() {
    // Arrange and Act
    NonEmptyNodeReplaceInsert actualNonEmptyNodeReplaceInsert = new NonEmptyNodeReplaceInsert();

    // Assert
    assertNull(actualNonEmptyNodeReplaceInsert.getName());
    assertNull(actualNonEmptyNodeReplaceInsert.getXPath());
    assertEquals(0, actualNonEmptyNodeReplaceInsert.getPriority());
    assertEquals(0, actualNonEmptyNodeReplaceInsert.getChildren().length);
  }
}
