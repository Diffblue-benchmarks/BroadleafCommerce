package org.broadleafcommerce.common.extensibility.context.merge.handlers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.metadata.IIOMetadataNode;
import org.broadleafcommerce.common.extensibility.context.merge.handlers.SchemaLocationMergeTest.DummyNode;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.w3c.dom.Node;

@ContextConfiguration(classes = {LiberalNodeReplaceInsert.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class LiberalNodeReplaceInsertDiffblueTest {
  @Autowired private LiberalNodeReplaceInsert liberalNodeReplaceInsert;

  /**
   * Test {@link LiberalNodeReplaceInsert#checkNode(List, Node[], Node)}.
   *
   * <ul>
   *   <li>Given {@code false}.
   *   <li>When {@link DummyNode} {@link DummyNode#isEqualNode(Node)} return {@code false}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link LiberalNodeReplaceInsert#checkNode(List, Node[], Node)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean LiberalNodeReplaceInsert.checkNode(List, Node[], Node)"})
  public void testCheckNode_givenFalse_whenDummyNodeIsEqualNodeReturnFalse_thenReturnFalse() {
    // Arrange
    ArrayList<Node> usedNodes = new ArrayList<>();

    DummyNode dummyNode = mock(DummyNode.class);
    when(dummyNode.isEqualNode(Mockito.<Node>any())).thenReturn(false);

    // Act
    boolean actualCheckNodeResult =
        liberalNodeReplaceInsert.checkNode(
            usedNodes, new Node[] {dummyNode}, new IIOMetadataNode());

    // Assert
    verify(dummyNode).isEqualNode(isA(Node.class));
    assertFalse(actualCheckNodeResult);
    assertTrue(usedNodes.isEmpty());
  }

  /**
   * Test {@link LiberalNodeReplaceInsert#checkNode(List, Node[], Node)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>Then {@link ArrayList#ArrayList()} size is one.
   * </ul>
   *
   * <p>Method under test: {@link LiberalNodeReplaceInsert#checkNode(List, Node[], Node)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean LiberalNodeReplaceInsert.checkNode(List, Node[], Node)"})
  public void testCheckNode_givenTrue_thenArrayListSizeIsOne() {
    // Arrange
    ArrayList<Node> usedNodes = new ArrayList<>();

    DummyNode dummyNode = mock(DummyNode.class);
    when(dummyNode.isEqualNode(Mockito.<Node>any())).thenReturn(true);
    Node[] primaryNodes = new Node[] {dummyNode};

    // Act
    boolean actualCheckNodeResult =
        liberalNodeReplaceInsert.checkNode(usedNodes, primaryNodes, new IIOMetadataNode());

    // Assert
    verify(dummyNode).isEqualNode(isA(Node.class));
    assertEquals(1, usedNodes.size());
    assertEquals(1, primaryNodes.length);
    assertTrue(actualCheckNodeResult);
    assertSame(usedNodes.get(0), primaryNodes[0]);
  }

  /**
   * Test {@link LiberalNodeReplaceInsert#checkNode(List, Node[], Node)}.
   *
   * <ul>
   *   <li>When empty array of {@link Node}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link LiberalNodeReplaceInsert#checkNode(List, Node[], Node)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean LiberalNodeReplaceInsert.checkNode(List, Node[], Node)"})
  public void testCheckNode_whenEmptyArrayOfNode_thenReturnFalse() {
    // Arrange
    ArrayList<Node> usedNodes = new ArrayList<>();

    // Act and Assert
    assertFalse(
        liberalNodeReplaceInsert.checkNode(usedNodes, new Node[] {}, new IIOMetadataNode()));
    assertTrue(usedNodes.isEmpty());
  }

  /**
   * Test new {@link LiberalNodeReplaceInsert} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link LiberalNodeReplaceInsert}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void LiberalNodeReplaceInsert.<init>()"})
  public void testNewLiberalNodeReplaceInsert() {
    // Arrange and Act
    LiberalNodeReplaceInsert actualLiberalNodeReplaceInsert = new LiberalNodeReplaceInsert();

    // Assert
    assertNull(actualLiberalNodeReplaceInsert.getName());
    assertNull(actualLiberalNodeReplaceInsert.getXPath());
    assertEquals(0, actualLiberalNodeReplaceInsert.getPriority());
    assertEquals(0, actualLiberalNodeReplaceInsert.getChildren().length);
  }
}
