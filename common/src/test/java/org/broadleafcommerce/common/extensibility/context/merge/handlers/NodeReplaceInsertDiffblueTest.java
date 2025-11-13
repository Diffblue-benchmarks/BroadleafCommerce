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
import org.apache.html.dom.HTMLAnchorElementImpl;
import org.apache.html.dom.HTMLDocumentImpl;
import org.apache.xerces.impl.xs.opti.DefaultElement;
import org.broadleafcommerce.common.extensibility.context.merge.handlers.SchemaLocationMergeTest.DummyNode;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.w3c.dom.Node;

@ContextConfiguration(classes = {NodeReplaceInsert.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class NodeReplaceInsertDiffblueTest {
  @Autowired private NodeReplaceInsert nodeReplaceInsert;

  /**
   * Test {@link NodeReplaceInsert#merge(List, List, List)}.
   *
   * <ul>
   *   <li>Given {@link DefaultElement} {@link DefaultElement#isSameNode(Node)} return {@code true}.
   *   <li>Then calls {@link DefaultElement#isSameNode(Node)}.
   * </ul>
   *
   * <p>Method under test: {@link NodeReplaceInsert#merge(List, List, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Node[] NodeReplaceInsert.merge(List, List, List)"})
  public void testMerge_givenDefaultElementIsSameNodeReturnTrue_thenCallsIsSameNode() {
    // Arrange
    NodeReplaceInsert nodeReplaceInsert = new NodeReplaceInsert();

    DummyNode dummyNode = mock(DummyNode.class);
    when(dummyNode.getParentNode()).thenReturn(new IIOMetadataNode());

    ArrayList<Node> nodeList1 = new ArrayList<>();
    nodeList1.add(dummyNode);

    DefaultElement defaultElement = mock(DefaultElement.class);
    when(defaultElement.isSameNode(Mockito.<Node>any())).thenReturn(true);

    ArrayList<Node> nodeList2 = new ArrayList<>();
    nodeList2.add(defaultElement);

    DummyNode dummyNode2 = mock(DummyNode.class);
    when(dummyNode2.isSameNode(Mockito.<Node>any())).thenReturn(false);
    when(dummyNode2.getParentNode()).thenReturn(new IIOMetadataNode());

    ArrayList<Node> exhaustedNodes = new ArrayList<>();
    exhaustedNodes.add(dummyNode2);

    // Act
    Node[] actualMergeResult = nodeReplaceInsert.merge(nodeList1, nodeList2, exhaustedNodes);

    // Assert
    verify(dummyNode).getParentNode();
    verify(dummyNode2).getParentNode();
    verify(defaultElement).isSameNode(isA(Node.class));
    verify(dummyNode2).isSameNode(isA(Node.class));
    assertEquals(0, actualMergeResult.length);
  }

  /**
   * Test {@link NodeReplaceInsert#merge(List, List, List)}.
   *
   * <ul>
   *   <li>Given {@link DummyNode} {@link DummyNode#isEqualNode(Node)} return {@code true}.
   *   <li>Then return array length is one.
   * </ul>
   *
   * <p>Method under test: {@link NodeReplaceInsert#merge(List, List, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Node[] NodeReplaceInsert.merge(List, List, List)"})
  public void testMerge_givenDummyNodeIsEqualNodeReturnTrue_thenReturnArrayLengthIsOne() {
    // Arrange
    DummyNode dummyNode = mock(DummyNode.class);
    when(dummyNode.isEqualNode(Mockito.<Node>any())).thenReturn(true);
    when(dummyNode.getParentNode()).thenReturn(new IIOMetadataNode());

    ArrayList<Node> nodeList1 = new ArrayList<>();
    nodeList1.add(dummyNode);

    ArrayList<Node> nodeList2 = new ArrayList<>();
    nodeList2.add(new IIOMetadataNode());

    // Act
    Node[] actualMergeResult = nodeReplaceInsert.merge(nodeList1, nodeList2, new ArrayList<>());

    // Assert
    verify(dummyNode).getParentNode();
    verify(dummyNode).isEqualNode(isA(Node.class));
    assertEquals(1, actualMergeResult.length);
  }

  /**
   * Test {@link NodeReplaceInsert#merge(List, List, List)}.
   *
   * <ul>
   *   <li>Given {@link DummyNode} {@link DummyNode#isSameNode(Node)} return {@code true}.
   *   <li>Then return array length is zero.
   * </ul>
   *
   * <p>Method under test: {@link NodeReplaceInsert#merge(List, List, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Node[] NodeReplaceInsert.merge(List, List, List)"})
  public void testMerge_givenDummyNodeIsSameNodeReturnTrue_thenReturnArrayLengthIsZero() {
    // Arrange
    NodeReplaceInsert nodeReplaceInsert = new NodeReplaceInsert();

    DummyNode dummyNode = mock(DummyNode.class);
    when(dummyNode.getParentNode()).thenReturn(new IIOMetadataNode());

    ArrayList<Node> nodeList1 = new ArrayList<>();
    nodeList1.add(dummyNode);

    ArrayList<Node> nodeList2 = new ArrayList<>();
    nodeList2.add(new IIOMetadataNode());

    DummyNode dummyNode2 = mock(DummyNode.class);
    when(dummyNode2.isSameNode(Mockito.<Node>any())).thenReturn(true);

    ArrayList<Node> exhaustedNodes = new ArrayList<>();
    exhaustedNodes.add(dummyNode2);

    // Act
    Node[] actualMergeResult = nodeReplaceInsert.merge(nodeList1, nodeList2, exhaustedNodes);

    // Assert
    verify(dummyNode).getParentNode();
    verify(dummyNode2).isSameNode(isA(Node.class));
    assertEquals(0, actualMergeResult.length);
  }

  /**
   * Test {@link NodeReplaceInsert#merge(List, List, List)}.
   *
   * <ul>
   *   <li>Given {@link DummyNode#DummyNode(SchemaLocationMergeTest)} with this$0 is {@link
   *       SchemaLocationMergeTest} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link NodeReplaceInsert#merge(List, List, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Node[] NodeReplaceInsert.merge(List, List, List)"})
  public void testMerge_givenDummyNodeWithThis$0IsSchemaLocationMergeTest() {
    // Arrange
    DummyNode dummyNode = mock(DummyNode.class);
    when(dummyNode.getParentNode()).thenReturn(new IIOMetadataNode());

    ArrayList<Node> nodeList1 = new ArrayList<>();
    nodeList1.add(dummyNode);

    ArrayList<Node> nodeList2 = new ArrayList<>();
    nodeList2.add(new SchemaLocationMergeTest().new DummyNode());

    // Act
    Node[] actualMergeResult = nodeReplaceInsert.merge(nodeList1, nodeList2, new ArrayList<>());

    // Assert
    verify(dummyNode).getParentNode();
    assertEquals(0, actualMergeResult.length);
  }

  /**
   * Test {@link NodeReplaceInsert#merge(List, List, List)}.
   *
   * <ul>
   *   <li>Given {@link HTMLAnchorElementImpl#HTMLAnchorElementImpl(HTMLDocumentImpl, String)} with
   *       {@link HTMLDocumentImpl} (default constructor) and {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link NodeReplaceInsert#merge(List, List, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Node[] NodeReplaceInsert.merge(List, List, List)"})
  public void testMerge_givenHTMLAnchorElementImplWithHTMLDocumentImplAndFoo() {
    // Arrange
    NodeReplaceInsert nodeReplaceInsert = new NodeReplaceInsert();

    DummyNode dummyNode = mock(DummyNode.class);
    when(dummyNode.isEqualNode(Mockito.<Node>any())).thenReturn(true);
    when(dummyNode.getParentNode()).thenReturn(new IIOMetadataNode());

    ArrayList<Node> nodeList1 = new ArrayList<>();
    nodeList1.add(dummyNode);

    ArrayList<Node> nodeList2 = new ArrayList<>();
    nodeList2.add(new HTMLAnchorElementImpl(new HTMLDocumentImpl(), "foo"));

    DummyNode dummyNode2 = mock(DummyNode.class);
    when(dummyNode2.isSameNode(Mockito.<Node>any())).thenReturn(false);
    when(dummyNode2.getParentNode()).thenReturn(new IIOMetadataNode());

    ArrayList<Node> exhaustedNodes = new ArrayList<>();
    exhaustedNodes.add(dummyNode2);

    // Act
    Node[] actualMergeResult = nodeReplaceInsert.merge(nodeList1, nodeList2, exhaustedNodes);

    // Assert
    verify(dummyNode).getParentNode();
    verify(dummyNode2).getParentNode();
    verify(dummyNode).isEqualNode(isA(Node.class));
    verify(dummyNode2).isSameNode(isA(Node.class));
    assertEquals(1, actualMergeResult.length);
  }

  /**
   * Test {@link NodeReplaceInsert#merge(List, List, List)}.
   *
   * <ul>
   *   <li>Given {@link IIOMetadataNode#IIOMetadataNode()}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link IIOMetadataNode#IIOMetadataNode()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link NodeReplaceInsert#merge(List, List, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Node[] NodeReplaceInsert.merge(List, List, List)"})
  public void testMerge_givenIIOMetadataNode_whenArrayListAddIIOMetadataNode_thenReturnNull() {
    // Arrange
    ArrayList<Node> nodeList1 = new ArrayList<>();
    nodeList1.add(new IIOMetadataNode());
    nodeList1.add(new IIOMetadataNode());
    nodeList1.add(new IIOMetadataNode());
    nodeList1.add(new IIOMetadataNode());
    nodeList1.add(new IIOMetadataNode());
    nodeList1.add(new IIOMetadataNode());
    nodeList1.add(new IIOMetadataNode());
    nodeList1.add(new IIOMetadataNode());
    nodeList1.add(new IIOMetadataNode());
    nodeList1.add(new IIOMetadataNode());
    nodeList1.add(new IIOMetadataNode());
    nodeList1.add(new IIOMetadataNode());
    nodeList1.add(new IIOMetadataNode());
    nodeList1.add(new IIOMetadataNode());
    nodeList1.add(new IIOMetadataNode());
    nodeList1.add(new IIOMetadataNode());
    nodeList1.add(new IIOMetadataNode());
    nodeList1.add(new IIOMetadataNode());
    ArrayList<Node> nodeList2 = new ArrayList<>();

    // Act and Assert
    assertNull(nodeReplaceInsert.merge(nodeList1, nodeList2, new ArrayList<>()));
  }

  /**
   * Test {@link NodeReplaceInsert#merge(List, List, List)}.
   *
   * <ul>
   *   <li>Given {@link IIOMetadataNode#IIOMetadataNode()}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link IIOMetadataNode#IIOMetadataNode()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link NodeReplaceInsert#merge(List, List, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Node[] NodeReplaceInsert.merge(List, List, List)"})
  public void testMerge_givenIIOMetadataNode_whenArrayListAddIIOMetadataNode_thenReturnNull2() {
    // Arrange
    ArrayList<Node> nodeList1 = new ArrayList<>();
    nodeList1.add(new IIOMetadataNode());
    ArrayList<Node> nodeList2 = new ArrayList<>();

    // Act and Assert
    assertNull(nodeReplaceInsert.merge(nodeList1, nodeList2, new ArrayList<>()));
  }

  /**
   * Test {@link NodeReplaceInsert#merge(List, List, List)}.
   *
   * <ul>
   *   <li>Given {@link IIOMetadataNode#IIOMetadataNode()}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link IIOMetadataNode#IIOMetadataNode()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link NodeReplaceInsert#merge(List, List, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Node[] NodeReplaceInsert.merge(List, List, List)"})
  public void testMerge_givenIIOMetadataNode_whenArrayListAddIIOMetadataNode_thenReturnNull3() {
    // Arrange
    ArrayList<Node> nodeList1 = new ArrayList<>();
    nodeList1.add(new IIOMetadataNode());
    nodeList1.add(new IIOMetadataNode());
    ArrayList<Node> nodeList2 = new ArrayList<>();

    // Act and Assert
    assertNull(nodeReplaceInsert.merge(nodeList1, nodeList2, new ArrayList<>()));
  }

  /**
   * Test {@link NodeReplaceInsert#merge(List, List, List)}.
   *
   * <ul>
   *   <li>Given {@link IIOMetadataNode#IIOMetadataNode()}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link IIOMetadataNode#IIOMetadataNode()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link NodeReplaceInsert#merge(List, List, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Node[] NodeReplaceInsert.merge(List, List, List)"})
  public void testMerge_givenIIOMetadataNode_whenArrayListAddIIOMetadataNode_thenReturnNull4() {
    // Arrange
    ArrayList<Node> nodeList1 = new ArrayList<>();
    ArrayList<Node> nodeList2 = new ArrayList<>();

    ArrayList<Node> exhaustedNodes = new ArrayList<>();
    exhaustedNodes.add(new IIOMetadataNode());

    // Act and Assert
    assertNull(nodeReplaceInsert.merge(nodeList1, nodeList2, exhaustedNodes));
  }

  /**
   * Test {@link NodeReplaceInsert#merge(List, List, List)}.
   *
   * <ul>
   *   <li>Given {@link IIOMetadataNode#IIOMetadataNode()}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link IIOMetadataNode#IIOMetadataNode()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link NodeReplaceInsert#merge(List, List, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Node[] NodeReplaceInsert.merge(List, List, List)"})
  public void testMerge_givenIIOMetadataNode_whenArrayListAddIIOMetadataNode_thenReturnNull5() {
    // Arrange
    ArrayList<Node> nodeList1 = new ArrayList<>();
    ArrayList<Node> nodeList2 = new ArrayList<>();

    ArrayList<Node> exhaustedNodes = new ArrayList<>();
    exhaustedNodes.add(new IIOMetadataNode());
    exhaustedNodes.add(new IIOMetadataNode());

    // Act and Assert
    assertNull(nodeReplaceInsert.merge(nodeList1, nodeList2, exhaustedNodes));
  }

  /**
   * Test {@link NodeReplaceInsert#merge(List, List, List)}.
   *
   * <ul>
   *   <li>Given {@link IIOMetadataNode#IIOMetadataNode()}.
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link NodeReplaceInsert#merge(List, List, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Node[] NodeReplaceInsert.merge(List, List, List)"})
  public void testMerge_givenIIOMetadataNode_whenNull_thenReturnNull() {
    // Arrange
    ArrayList<Node> nodeList1 = new ArrayList<>();
    nodeList1.add(new IIOMetadataNode());
    nodeList1.add(new IIOMetadataNode());
    nodeList1.add(new IIOMetadataNode());
    nodeList1.add(new IIOMetadataNode());
    nodeList1.add(new IIOMetadataNode());
    nodeList1.add(new IIOMetadataNode());
    nodeList1.add(new IIOMetadataNode());
    nodeList1.add(new IIOMetadataNode());
    nodeList1.add(new IIOMetadataNode());
    nodeList1.add(new IIOMetadataNode());
    nodeList1.add(new IIOMetadataNode());
    nodeList1.add(new IIOMetadataNode());
    nodeList1.add(new IIOMetadataNode());
    nodeList1.add(new IIOMetadataNode());
    nodeList1.add(new IIOMetadataNode());
    nodeList1.add(new IIOMetadataNode());
    nodeList1.add(new IIOMetadataNode());
    nodeList1.add(new IIOMetadataNode());

    // Act and Assert
    assertNull(nodeReplaceInsert.merge(nodeList1, null, new ArrayList<>()));
  }

  /**
   * Test {@link NodeReplaceInsert#merge(List, List, List)}.
   *
   * <ul>
   *   <li>Given {@link NodeReplaceInsert}.
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link NodeReplaceInsert#merge(List, List, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Node[] NodeReplaceInsert.merge(List, List, List)"})
  public void testMerge_givenNodeReplaceInsert_whenArrayList_thenReturnNull() {
    // Arrange
    ArrayList<Node> nodeList1 = new ArrayList<>();
    ArrayList<Node> nodeList2 = new ArrayList<>();

    // Act and Assert
    assertNull(nodeReplaceInsert.merge(nodeList1, nodeList2, new ArrayList<>()));
  }

  /**
   * Test {@link NodeReplaceInsert#checkNode(List, Node[], Node)}.
   *
   * <ul>
   *   <li>Given {@code false}.
   *   <li>When {@link DummyNode} {@link DummyNode#isEqualNode(Node)} return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link NodeReplaceInsert#checkNode(List, Node[], Node)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean NodeReplaceInsert.checkNode(List, Node[], Node)"})
  public void testCheckNode_givenFalse_whenDummyNodeIsEqualNodeReturnFalse() {
    // Arrange
    ArrayList<Node> usedNodes = new ArrayList<>();

    DummyNode dummyNode = mock(DummyNode.class);
    when(dummyNode.isEqualNode(Mockito.<Node>any())).thenReturn(false);

    // Act
    boolean actualCheckNodeResult =
        nodeReplaceInsert.checkNode(usedNodes, new Node[] {dummyNode}, new IIOMetadataNode());

    // Assert
    verify(dummyNode).isEqualNode(isA(Node.class));
    assertFalse(actualCheckNodeResult);
    assertTrue(usedNodes.isEmpty());
  }

  /**
   * Test {@link NodeReplaceInsert#checkNode(List, Node[], Node)}.
   *
   * <ul>
   *   <li>Given {@link LiberalNodeReplaceInsert} (default constructor).
   *   <li>When empty array of {@link Node}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link NodeReplaceInsert#checkNode(List, Node[], Node)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean NodeReplaceInsert.checkNode(List, Node[], Node)"})
  public void testCheckNode_givenLiberalNodeReplaceInsert_whenEmptyArrayOfNode_thenReturnFalse() {
    // Arrange
    LiberalNodeReplaceInsert liberalNodeReplaceInsert = new LiberalNodeReplaceInsert();
    ArrayList<Node> usedNodes = new ArrayList<>();

    // Act and Assert
    assertFalse(
        liberalNodeReplaceInsert.checkNode(usedNodes, new Node[] {}, new IIOMetadataNode()));
    assertTrue(usedNodes.isEmpty());
  }

  /**
   * Test {@link NodeReplaceInsert#checkNode(List, Node[], Node)}.
   *
   * <ul>
   *   <li>Given {@link MetadataOverrideNodeReplaceInsert} (default constructor).
   *   <li>When empty array of {@link Node}.
   * </ul>
   *
   * <p>Method under test: {@link NodeReplaceInsert#checkNode(List, Node[], Node)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean NodeReplaceInsert.checkNode(List, Node[], Node)"})
  public void testCheckNode_givenMetadataOverrideNodeReplaceInsert_whenEmptyArrayOfNode() {
    // Arrange
    MetadataOverrideNodeReplaceInsert metadataOverrideNodeReplaceInsert =
        new MetadataOverrideNodeReplaceInsert();
    ArrayList<Node> usedNodes = new ArrayList<>();

    // Act and Assert
    assertFalse(
        metadataOverrideNodeReplaceInsert.checkNode(
            usedNodes, new Node[] {}, new IIOMetadataNode()));
    assertTrue(usedNodes.isEmpty());
  }

  /**
   * Test {@link NodeReplaceInsert#checkNode(List, Node[], Node)}.
   *
   * <ul>
   *   <li>Given {@link NodeReplaceInsert}.
   *   <li>When empty array of {@link Node}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link NodeReplaceInsert#checkNode(List, Node[], Node)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean NodeReplaceInsert.checkNode(List, Node[], Node)"})
  public void testCheckNode_givenNodeReplaceInsert_whenEmptyArrayOfNode_thenReturnFalse() {
    // Arrange
    ArrayList<Node> usedNodes = new ArrayList<>();

    // Act and Assert
    assertFalse(nodeReplaceInsert.checkNode(usedNodes, new Node[] {}, new IIOMetadataNode()));
    assertTrue(usedNodes.isEmpty());
  }

  /**
   * Test {@link NodeReplaceInsert#checkNode(List, Node[], Node)}.
   *
   * <ul>
   *   <li>Given {@link NodeReplace} (default constructor).
   *   <li>Then calls {@link DummyNode#getNodeName()}.
   * </ul>
   *
   * <p>Method under test: {@link NodeReplaceInsert#checkNode(List, Node[], Node)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean NodeReplaceInsert.checkNode(List, Node[], Node)"})
  public void testCheckNode_givenNodeReplace_thenCallsGetNodeName() {
    // Arrange
    NodeReplace nodeReplace = new NodeReplace();
    ArrayList<Node> usedNodes = new ArrayList<>();

    DummyNode dummyNode = mock(DummyNode.class);
    when(dummyNode.getNodeName()).thenReturn("Node Name");
    when(dummyNode.isEqualNode(Mockito.<Node>any())).thenReturn(true);
    Node[] primaryNodes = new Node[] {dummyNode};

    // Act
    boolean actualCheckNodeResult =
        nodeReplace.checkNode(usedNodes, primaryNodes, new HTMLDocumentImpl());

    // Assert
    verify(dummyNode).getNodeName();
    verify(dummyNode).isEqualNode(isA(Node.class));
    assertEquals(1, usedNodes.size());
    assertEquals(1, primaryNodes.length);
    assertTrue(actualCheckNodeResult);
    assertSame(usedNodes.get(0), primaryNodes[0]);
  }

  /**
   * Test {@link NodeReplaceInsert#checkNode(List, Node[], Node)}.
   *
   * <ul>
   *   <li>Given {@link NonEmptyNodeReplaceInsert} (default constructor).
   *   <li>When empty array of {@link Node}.
   * </ul>
   *
   * <p>Method under test: {@link NodeReplaceInsert#checkNode(List, Node[], Node)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean NodeReplaceInsert.checkNode(List, Node[], Node)"})
  public void testCheckNode_givenNonEmptyNodeReplaceInsert_whenEmptyArrayOfNode() {
    // Arrange
    NonEmptyNodeReplaceInsert nonEmptyNodeReplaceInsert = new NonEmptyNodeReplaceInsert();
    ArrayList<Node> usedNodes = new ArrayList<>();

    // Act and Assert
    assertFalse(
        nonEmptyNodeReplaceInsert.checkNode(usedNodes, new Node[] {}, new IIOMetadataNode()));
    assertTrue(usedNodes.isEmpty());
  }

  /**
   * Test {@link NodeReplaceInsert#checkNode(List, Node[], Node)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>Then {@link ArrayList#ArrayList()} size is one.
   * </ul>
   *
   * <p>Method under test: {@link NodeReplaceInsert#checkNode(List, Node[], Node)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean NodeReplaceInsert.checkNode(List, Node[], Node)"})
  public void testCheckNode_givenTrue_thenArrayListSizeIsOne() {
    // Arrange
    ArrayList<Node> usedNodes = new ArrayList<>();

    DummyNode dummyNode = mock(DummyNode.class);
    when(dummyNode.isEqualNode(Mockito.<Node>any())).thenReturn(true);
    Node[] primaryNodes = new Node[] {dummyNode};

    // Act
    boolean actualCheckNodeResult =
        nodeReplaceInsert.checkNode(usedNodes, primaryNodes, new IIOMetadataNode());

    // Assert
    verify(dummyNode).isEqualNode(isA(Node.class));
    assertEquals(1, usedNodes.size());
    assertEquals(1, primaryNodes.length);
    assertTrue(actualCheckNodeResult);
    assertSame(usedNodes.get(0), primaryNodes[0]);
  }

  /**
   * Test {@link NodeReplaceInsert#exactNodeExists(Node[], Node, List)}.
   *
   * <ul>
   *   <li>Given {@code false}.
   *   <li>When {@link DummyNode} {@link DummyNode#isEqualNode(Node)} return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link NodeReplaceInsert#exactNodeExists(Node[], Node, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean NodeReplaceInsert.exactNodeExists(Node[], Node, List)"})
  public void testExactNodeExists_givenFalse_whenDummyNodeIsEqualNodeReturnFalse() {
    // Arrange
    DummyNode dummyNode = mock(DummyNode.class);
    when(dummyNode.isEqualNode(Mockito.<Node>any())).thenReturn(false);
    IIOMetadataNode testNode = new IIOMetadataNode();
    ArrayList<Node> usedNodes = new ArrayList<>();

    // Act
    boolean actualExactNodeExistsResult =
        nodeReplaceInsert.exactNodeExists(new Node[] {dummyNode}, testNode, usedNodes);

    // Assert
    verify(dummyNode).isEqualNode(isA(Node.class));
    assertFalse(actualExactNodeExistsResult);
    assertTrue(usedNodes.isEmpty());
  }

  /**
   * Test {@link NodeReplaceInsert#exactNodeExists(Node[], Node, List)}.
   *
   * <ul>
   *   <li>Given {@link IIOMetadataNode#IIOMetadataNode()}.
   *   <li>Then {@link ArrayList#ArrayList()} size is two.
   * </ul>
   *
   * <p>Method under test: {@link NodeReplaceInsert#exactNodeExists(Node[], Node, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean NodeReplaceInsert.exactNodeExists(Node[], Node, List)"})
  public void testExactNodeExists_givenIIOMetadataNode_thenArrayListSizeIsTwo() {
    // Arrange
    DummyNode dummyNode = mock(DummyNode.class);
    when(dummyNode.isEqualNode(Mockito.<Node>any())).thenReturn(true);
    IIOMetadataNode testNode = new IIOMetadataNode();

    ArrayList<Node> usedNodes = new ArrayList<>();
    usedNodes.add(new IIOMetadataNode());

    // Act
    boolean actualExactNodeExistsResult =
        nodeReplaceInsert.exactNodeExists(new Node[] {dummyNode}, testNode, usedNodes);

    // Assert
    verify(dummyNode).isEqualNode(isA(Node.class));
    assertEquals(2, usedNodes.size());
    assertTrue(actualExactNodeExistsResult);
  }

  /**
   * Test {@link NodeReplaceInsert#exactNodeExists(Node[], Node, List)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>Then {@link ArrayList#ArrayList()} size is one.
   * </ul>
   *
   * <p>Method under test: {@link NodeReplaceInsert#exactNodeExists(Node[], Node, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean NodeReplaceInsert.exactNodeExists(Node[], Node, List)"})
  public void testExactNodeExists_givenTrue_thenArrayListSizeIsOne() {
    // Arrange
    DummyNode dummyNode = mock(DummyNode.class);
    when(dummyNode.isEqualNode(Mockito.<Node>any())).thenReturn(true);
    IIOMetadataNode testNode = new IIOMetadataNode();
    ArrayList<Node> usedNodes = new ArrayList<>();

    // Act
    boolean actualExactNodeExistsResult =
        nodeReplaceInsert.exactNodeExists(new Node[] {dummyNode}, testNode, usedNodes);

    // Assert
    verify(dummyNode).isEqualNode(isA(Node.class));
    assertEquals(1, usedNodes.size());
    assertTrue(actualExactNodeExistsResult);
  }

  /**
   * Test {@link NodeReplaceInsert#exactNodeExists(Node[], Node, List)}.
   *
   * <ul>
   *   <li>When empty array of {@link Node}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link NodeReplaceInsert#exactNodeExists(Node[], Node, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean NodeReplaceInsert.exactNodeExists(Node[], Node, List)"})
  public void testExactNodeExists_whenEmptyArrayOfNode_thenReturnFalse() {
    // Arrange
    IIOMetadataNode testNode = new IIOMetadataNode();
    ArrayList<Node> usedNodes = new ArrayList<>();

    // Act and Assert
    assertFalse(nodeReplaceInsert.exactNodeExists(new Node[] {}, testNode, usedNodes));
    assertTrue(usedNodes.isEmpty());
  }

  /**
   * Test {@link NodeReplaceInsert#replaceNode(Node[], Node, String, List)}.
   *
   * <ul>
   *   <li>Given {@link IIOMetadataNode#IIOMetadataNode()}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link IIOMetadataNode#IIOMetadataNode()}.
   * </ul>
   *
   * <p>Method under test: {@link NodeReplaceInsert#replaceNode(Node[], Node, String, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean NodeReplaceInsert.replaceNode(Node[], Node, String, List)"})
  public void testReplaceNode_givenIIOMetadataNode_whenArrayListAddIIOMetadataNode() {
    // Arrange
    IIOMetadataNode testNode = new IIOMetadataNode();

    ArrayList<Node> usedNodes = new ArrayList<>();
    usedNodes.add(new IIOMetadataNode());

    // Act and Assert
    assertFalse(
        nodeReplaceInsert.replaceNode(
            new Node[] {new IIOMetadataNode()}, testNode, "Attribute", usedNodes));
  }

  /**
   * Test {@link NodeReplaceInsert#replaceNode(Node[], Node, String, List)}.
   *
   * <ul>
   *   <li>Given {@link IIOMetadataNode#IIOMetadataNode()}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link IIOMetadataNode#IIOMetadataNode()}.
   * </ul>
   *
   * <p>Method under test: {@link NodeReplaceInsert#replaceNode(Node[], Node, String, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean NodeReplaceInsert.replaceNode(Node[], Node, String, List)"})
  public void testReplaceNode_givenIIOMetadataNode_whenArrayListAddIIOMetadataNode2() {
    // Arrange
    IIOMetadataNode testNode = new IIOMetadataNode();

    ArrayList<Node> usedNodes = new ArrayList<>();
    usedNodes.add(new IIOMetadataNode());
    usedNodes.add(new IIOMetadataNode());

    // Act and Assert
    assertFalse(
        nodeReplaceInsert.replaceNode(
            new Node[] {new IIOMetadataNode()}, testNode, "Attribute", usedNodes));
  }

  /**
   * Test {@link NodeReplaceInsert#replaceNode(Node[], Node, String, List)}.
   *
   * <ul>
   *   <li>When {@link IIOMetadataNode#IIOMetadataNode()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link NodeReplaceInsert#replaceNode(Node[], Node, String, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean NodeReplaceInsert.replaceNode(Node[], Node, String, List)"})
  public void testReplaceNode_whenIIOMetadataNode_thenReturnFalse() {
    // Arrange
    IIOMetadataNode testNode = new IIOMetadataNode();

    // Act and Assert
    assertFalse(
        nodeReplaceInsert.replaceNode(
            new Node[] {new IIOMetadataNode()}, testNode, "Attribute", new ArrayList<>()));
  }

  /**
   * Test {@link NodeReplaceInsert#replaceCeilingEntityNode(Node[], Node, List)}.
   *
   * <ul>
   *   <li>Given {@link IIOMetadataNode#IIOMetadataNode()}.
   * </ul>
   *
   * <p>Method under test: {@link NodeReplaceInsert#replaceCeilingEntityNode(Node[], Node, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean NodeReplaceInsert.replaceCeilingEntityNode(Node[], Node, List)"})
  public void testReplaceCeilingEntityNode_givenIIOMetadataNode() {
    // Arrange
    IIOMetadataNode testNode = new IIOMetadataNode();

    ArrayList<Node> usedNodes = new ArrayList<>();
    usedNodes.add(new IIOMetadataNode());

    // Act and Assert
    assertFalse(
        nodeReplaceInsert.replaceCeilingEntityNode(
            new Node[] {new IIOMetadataNode()}, testNode, usedNodes));
  }

  /**
   * Test {@link NodeReplaceInsert#replaceCeilingEntityNode(Node[], Node, List)}.
   *
   * <ul>
   *   <li>Given {@link IIOMetadataNode#IIOMetadataNode()}.
   * </ul>
   *
   * <p>Method under test: {@link NodeReplaceInsert#replaceCeilingEntityNode(Node[], Node, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean NodeReplaceInsert.replaceCeilingEntityNode(Node[], Node, List)"})
  public void testReplaceCeilingEntityNode_givenIIOMetadataNode2() {
    // Arrange
    IIOMetadataNode testNode = new IIOMetadataNode();

    ArrayList<Node> usedNodes = new ArrayList<>();
    usedNodes.add(new IIOMetadataNode());
    usedNodes.add(new IIOMetadataNode());

    // Act and Assert
    assertFalse(
        nodeReplaceInsert.replaceCeilingEntityNode(
            new Node[] {new IIOMetadataNode()}, testNode, usedNodes));
  }

  /**
   * Test {@link NodeReplaceInsert#replaceCeilingEntityNode(Node[], Node, List)}.
   *
   * <ul>
   *   <li>When {@link IIOMetadataNode#IIOMetadataNode()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link NodeReplaceInsert#replaceCeilingEntityNode(Node[], Node, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean NodeReplaceInsert.replaceCeilingEntityNode(Node[], Node, List)"})
  public void testReplaceCeilingEntityNode_whenIIOMetadataNode_thenReturnFalse() {
    // Arrange
    IIOMetadataNode testNode = new IIOMetadataNode();

    // Act and Assert
    assertFalse(
        nodeReplaceInsert.replaceCeilingEntityNode(
            new Node[] {new IIOMetadataNode()}, testNode, new ArrayList<>()));
  }

  /**
   * Test new {@link NodeReplaceInsert} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link NodeReplaceInsert}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void NodeReplaceInsert.<init>()"})
  public void testNewNodeReplaceInsert() {
    // Arrange and Act
    NodeReplaceInsert actualNodeReplaceInsert = new NodeReplaceInsert();

    // Assert
    assertNull(actualNodeReplaceInsert.getName());
    assertNull(actualNodeReplaceInsert.getXPath());
    assertEquals(0, actualNodeReplaceInsert.getPriority());
    assertEquals(0, actualNodeReplaceInsert.getChildren().length);
  }
}
