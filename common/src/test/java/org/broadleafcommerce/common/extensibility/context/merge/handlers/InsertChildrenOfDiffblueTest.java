package org.broadleafcommerce.common.extensibility.context.merge.handlers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
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

@ContextConfiguration(classes = {InsertChildrenOf.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class InsertChildrenOfDiffblueTest {
  @Autowired private InsertChildrenOf insertChildrenOf;

  /**
   * Test {@link InsertChildrenOf#merge(List, List, List)}.
   *
   * <ul>
   *   <li>Given {@link IIOMetadataNode#IIOMetadataNode()}.
   *   <li>Then eleventh element return {@link IIOMetadataNode}.
   * </ul>
   *
   * <p>Method under test: {@link InsertChildrenOf#merge(List, List, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Node[] InsertChildrenOf.merge(List, List, List)"})
  public void testMerge_givenIIOMetadataNode_thenEleventhElementReturnIIOMetadataNode() {
    // Arrange
    ArrayList<Node> nodeList1 = new ArrayList<>();
    nodeList1.add(new IIOMetadataNode());

    ArrayList<Node> nodeList2 = new ArrayList<>();
    nodeList2.add(new IIOMetadataNode());
    nodeList2.add(new IIOMetadataNode());
    IIOMetadataNode iioMetadataNode = new IIOMetadataNode();
    nodeList2.add(iioMetadataNode);
    IIOMetadataNode iioMetadataNode2 = new IIOMetadataNode();
    nodeList2.add(iioMetadataNode2);
    IIOMetadataNode iioMetadataNode3 = new IIOMetadataNode();
    nodeList2.add(iioMetadataNode3);
    IIOMetadataNode iioMetadataNode4 = new IIOMetadataNode();
    nodeList2.add(iioMetadataNode4);
    IIOMetadataNode iioMetadataNode5 = new IIOMetadataNode();
    nodeList2.add(iioMetadataNode5);
    IIOMetadataNode iioMetadataNode6 = new IIOMetadataNode();
    nodeList2.add(iioMetadataNode6);
    IIOMetadataNode iioMetadataNode7 = new IIOMetadataNode();
    nodeList2.add(iioMetadataNode7);
    IIOMetadataNode iioMetadataNode8 = new IIOMetadataNode();
    nodeList2.add(iioMetadataNode8);
    IIOMetadataNode iioMetadataNode9 = new IIOMetadataNode();
    nodeList2.add(iioMetadataNode9);
    IIOMetadataNode iioMetadataNode10 = new IIOMetadataNode();
    nodeList2.add(iioMetadataNode10);
    IIOMetadataNode iioMetadataNode11 = new IIOMetadataNode();
    nodeList2.add(iioMetadataNode11);
    IIOMetadataNode iioMetadataNode12 = new IIOMetadataNode();
    nodeList2.add(iioMetadataNode12);
    IIOMetadataNode iioMetadataNode13 = new IIOMetadataNode();
    nodeList2.add(iioMetadataNode13);
    IIOMetadataNode iioMetadataNode14 = new IIOMetadataNode();
    nodeList2.add(iioMetadataNode14);
    IIOMetadataNode iioMetadataNode15 = new IIOMetadataNode();
    nodeList2.add(iioMetadataNode15);
    IIOMetadataNode iioMetadataNode16 = new IIOMetadataNode();
    nodeList2.add(iioMetadataNode16);

    // Act
    Node[] actualMergeResult = insertChildrenOf.merge(nodeList1, nodeList2, new ArrayList<>());

    // Assert
    Node node = actualMergeResult[10];
    assertTrue(node instanceof IIOMetadataNode);
    Node node2 = actualMergeResult[11];
    assertTrue(node2 instanceof IIOMetadataNode);
    Node node3 = actualMergeResult[12];
    assertTrue(node3 instanceof IIOMetadataNode);
    Node node4 = actualMergeResult[13];
    assertTrue(node4 instanceof IIOMetadataNode);
    Node node5 = actualMergeResult[14];
    assertTrue(node5 instanceof IIOMetadataNode);
    Node node6 = actualMergeResult[15];
    assertTrue(node6 instanceof IIOMetadataNode);
    Node node7 = actualMergeResult[17];
    assertTrue(node7 instanceof IIOMetadataNode);
    Node node8 = actualMergeResult[2];
    assertTrue(node8 instanceof IIOMetadataNode);
    Node node9 = actualMergeResult[3];
    assertTrue(node9 instanceof IIOMetadataNode);
    Node node10 = actualMergeResult[4];
    assertTrue(node10 instanceof IIOMetadataNode);
    Node node11 = actualMergeResult[5];
    assertTrue(node11 instanceof IIOMetadataNode);
    Node node12 = actualMergeResult[6];
    assertTrue(node12 instanceof IIOMetadataNode);
    Node node13 = actualMergeResult[7];
    assertTrue(node13 instanceof IIOMetadataNode);
    Node node14 = actualMergeResult[8];
    assertTrue(node14 instanceof IIOMetadataNode);
    Node node15 = actualMergeResult[9];
    assertTrue(node15 instanceof IIOMetadataNode);
    Node node16 = actualMergeResult[Short.SIZE];
    assertTrue(node16 instanceof IIOMetadataNode);
    assertEquals(18, actualMergeResult.length);
    assertSame(iioMetadataNode9, node);
    assertSame(iioMetadataNode10, node2);
    assertSame(iioMetadataNode11, node3);
    assertSame(iioMetadataNode12, node4);
    assertSame(iioMetadataNode13, node5);
    assertSame(iioMetadataNode14, node6);
    assertSame(iioMetadataNode16, node7);
    assertSame(iioMetadataNode, node8);
    assertSame(iioMetadataNode2, node9);
    assertSame(iioMetadataNode3, node10);
    assertSame(iioMetadataNode4, node11);
    assertSame(iioMetadataNode5, node12);
    assertSame(iioMetadataNode6, node13);
    assertSame(iioMetadataNode7, node14);
    assertSame(iioMetadataNode8, node15);
    assertSame(iioMetadataNode15, node16);
  }

  /**
   * Test {@link InsertChildrenOf#merge(List, List, List)}.
   *
   * <ul>
   *   <li>Given {@link IIOMetadataNode#IIOMetadataNode()}.
   *   <li>Then return array length is one.
   * </ul>
   *
   * <p>Method under test: {@link InsertChildrenOf#merge(List, List, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Node[] InsertChildrenOf.merge(List, List, List)"})
  public void testMerge_givenIIOMetadataNode_thenReturnArrayLengthIsOne() {
    // Arrange
    ArrayList<Node> nodeList1 = new ArrayList<>();
    nodeList1.add(new IIOMetadataNode());

    ArrayList<Node> nodeList2 = new ArrayList<>();
    IIOMetadataNode iioMetadataNode = new IIOMetadataNode();
    nodeList2.add(iioMetadataNode);

    // Act
    Node[] actualMergeResult = insertChildrenOf.merge(nodeList1, nodeList2, new ArrayList<>());

    // Assert
    assertEquals(1, actualMergeResult.length);
    assertSame(iioMetadataNode, actualMergeResult[0]);
  }

  /**
   * Test {@link InsertChildrenOf#merge(List, List, List)}.
   *
   * <ul>
   *   <li>Given {@link IIOMetadataNode#IIOMetadataNode()}.
   *   <li>Then return array length is two.
   * </ul>
   *
   * <p>Method under test: {@link InsertChildrenOf#merge(List, List, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Node[] InsertChildrenOf.merge(List, List, List)"})
  public void testMerge_givenIIOMetadataNode_thenReturnArrayLengthIsTwo() {
    // Arrange
    ArrayList<Node> nodeList1 = new ArrayList<>();
    nodeList1.add(new IIOMetadataNode());

    ArrayList<Node> nodeList2 = new ArrayList<>();
    nodeList2.add(new IIOMetadataNode());
    IIOMetadataNode iioMetadataNode = new IIOMetadataNode();
    nodeList2.add(iioMetadataNode);

    // Act
    Node[] actualMergeResult = insertChildrenOf.merge(nodeList1, nodeList2, new ArrayList<>());

    // Assert
    assertEquals(2, actualMergeResult.length);
    assertSame(iioMetadataNode, actualMergeResult[1]);
  }

  /**
   * Test {@link InsertChildrenOf#merge(List, List, List)}.
   *
   * <ul>
   *   <li>Given {@link IIOMetadataNode#IIOMetadataNode()}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link IIOMetadataNode#IIOMetadataNode()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link InsertChildrenOf#merge(List, List, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Node[] InsertChildrenOf.merge(List, List, List)"})
  public void testMerge_givenIIOMetadataNode_whenArrayListAddIIOMetadataNode_thenReturnNull() {
    // Arrange
    ArrayList<Node> nodeList1 = new ArrayList<>();
    nodeList1.add(new IIOMetadataNode());
    ArrayList<Node> nodeList2 = new ArrayList<>();

    // Act and Assert
    assertNull(insertChildrenOf.merge(nodeList1, nodeList2, new ArrayList<>()));
  }

  /**
   * Test {@link InsertChildrenOf#merge(List, List, List)}.
   *
   * <ul>
   *   <li>Given {@link IIOMetadataNode#IIOMetadataNode()}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link IIOMetadataNode#IIOMetadataNode()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link InsertChildrenOf#merge(List, List, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Node[] InsertChildrenOf.merge(List, List, List)"})
  public void testMerge_givenIIOMetadataNode_whenArrayListAddIIOMetadataNode_thenReturnNull2() {
    // Arrange
    ArrayList<Node> nodeList1 = new ArrayList<>();
    nodeList1.add(new IIOMetadataNode());
    nodeList1.add(new IIOMetadataNode());
    ArrayList<Node> nodeList2 = new ArrayList<>();

    // Act and Assert
    assertNull(insertChildrenOf.merge(nodeList1, nodeList2, new ArrayList<>()));
  }

  /**
   * Test {@link InsertChildrenOf#merge(List, List, List)}.
   *
   * <ul>
   *   <li>Given {@link IIOMetadataNode#IIOMetadataNode()}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link IIOMetadataNode#IIOMetadataNode()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link InsertChildrenOf#merge(List, List, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Node[] InsertChildrenOf.merge(List, List, List)"})
  public void testMerge_givenIIOMetadataNode_whenArrayListAddIIOMetadataNode_thenReturnNull3() {
    // Arrange
    ArrayList<Node> nodeList1 = new ArrayList<>();
    ArrayList<Node> nodeList2 = new ArrayList<>();

    ArrayList<Node> exhaustedNodes = new ArrayList<>();
    exhaustedNodes.add(new IIOMetadataNode());

    // Act and Assert
    assertNull(insertChildrenOf.merge(nodeList1, nodeList2, exhaustedNodes));
  }

  /**
   * Test {@link InsertChildrenOf#merge(List, List, List)}.
   *
   * <ul>
   *   <li>Given {@link IIOMetadataNode#IIOMetadataNode()}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link IIOMetadataNode#IIOMetadataNode()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link InsertChildrenOf#merge(List, List, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Node[] InsertChildrenOf.merge(List, List, List)"})
  public void testMerge_givenIIOMetadataNode_whenArrayListAddIIOMetadataNode_thenReturnNull4() {
    // Arrange
    ArrayList<Node> nodeList1 = new ArrayList<>();
    ArrayList<Node> nodeList2 = new ArrayList<>();

    ArrayList<Node> exhaustedNodes = new ArrayList<>();
    exhaustedNodes.add(new IIOMetadataNode());
    exhaustedNodes.add(new IIOMetadataNode());

    // Act and Assert
    assertNull(insertChildrenOf.merge(nodeList1, nodeList2, exhaustedNodes));
  }

  /**
   * Test {@link InsertChildrenOf#merge(List, List, List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link InsertChildrenOf#merge(List, List, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Node[] InsertChildrenOf.merge(List, List, List)"})
  public void testMerge_whenArrayList_thenReturnNull() {
    // Arrange
    ArrayList<Node> nodeList1 = new ArrayList<>();
    ArrayList<Node> nodeList2 = new ArrayList<>();

    // Act and Assert
    assertNull(insertChildrenOf.merge(nodeList1, nodeList2, new ArrayList<>()));
  }

  /**
   * Test new {@link InsertChildrenOf} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link InsertChildrenOf}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void InsertChildrenOf.<init>()"})
  public void testNewInsertChildrenOf() {
    // Arrange and Act
    InsertChildrenOf actualInsertChildrenOf = new InsertChildrenOf();

    // Assert
    assertNull(actualInsertChildrenOf.getName());
    assertNull(actualInsertChildrenOf.getXPath());
    assertEquals(0, actualInsertChildrenOf.getPriority());
    assertEquals(0, actualInsertChildrenOf.getChildren().length);
  }
}
