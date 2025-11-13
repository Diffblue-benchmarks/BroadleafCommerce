package org.broadleafcommerce.common.extensibility.context.merge.handlers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.imageio.metadata.IIOMetadataNode;
import org.apache.xerces.dom.AttrNSImpl;
import org.apache.xerces.dom.CoreDocumentImpl;
import org.broadleafcommerce.common.extensibility.context.merge.handlers.SchemaLocationMergeTest.DummyNode;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.w3c.dom.DOMException;
import org.w3c.dom.Node;
import org.w3c.dom.events.EventListener;

@ContextConfiguration(classes = {NodeValueMerge.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class NodeValueMergeDiffblueTest {
  @Autowired private NodeValueMerge nodeValueMerge;

  /**
   * Test {@link NodeValueMerge#merge(List, List, List)}.
   *
   * <ul>
   *   <li>Given {@link CommaDelimitedNodeValueMerge} (default constructor).
   *   <li>Then first element return {@link AttrNSImpl}.
   * </ul>
   *
   * <p>Method under test: {@link NodeValueMerge#merge(List, List, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Node[] NodeValueMerge.merge(List, List, List)"})
  public void testMerge_givenCommaDelimitedNodeValueMerge_thenFirstElementReturnAttrNSImpl()
      throws DOMException {
    // Arrange
    CommaDelimitedNodeValueMerge commaDelimitedNodeValueMerge = new CommaDelimitedNodeValueMerge();

    DummyNode dummyNode = mock(DummyNode.class);
    doNothing().when(dummyNode).setNodeValue(Mockito.<String>any());
    when(dummyNode.getNodeValue()).thenReturn("42");

    ArrayList<Node> nodeList1 = new ArrayList<>();
    nodeList1.add(dummyNode);
    nodeList1.add(mock(DummyNode.class));

    AttrNSImpl attrNSImpl = new AttrNSImpl(new CoreDocumentImpl(), "foo", "foo", "foo");
    attrNSImpl.addEventListener("foo", mock(EventListener.class), false);

    ArrayList<Node> nodeList2 = new ArrayList<>();
    nodeList2.add(attrNSImpl);

    // Act
    Node[] actualMergeResult =
        commaDelimitedNodeValueMerge.merge(nodeList1, nodeList2, new ArrayList<>());

    // Assert
    verify(dummyNode).getNodeValue();
    verify(dummyNode).setNodeValue("42,");
    Node node = actualMergeResult[0];
    assertTrue(node instanceof AttrNSImpl);
    assertEquals(1, actualMergeResult.length);
    assertSame(attrNSImpl, node);
  }

  /**
   * Test {@link NodeValueMerge#merge(List, List, List)}.
   *
   * <ul>
   *   <li>Given {@link IIOMetadataNode#IIOMetadataNode(String)} with {@code foo} NodeValue is
   *       {@code Node List1}.
   * </ul>
   *
   * <p>Method under test: {@link NodeValueMerge#merge(List, List, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Node[] NodeValueMerge.merge(List, List, List)"})
  public void testMerge_givenIIOMetadataNodeWithFooNodeValueIsNodeList1() {
    // Arrange
    IIOMetadataNode iioMetadataNode = new IIOMetadataNode("foo");
    iioMetadataNode.setNodeValue("Node List1");

    ArrayList<Node> nodeList1 = new ArrayList<>();
    nodeList1.add(iioMetadataNode);
    ArrayList<Node> nodeList2 = new ArrayList<>();

    // Act and Assert
    assertNull(nodeValueMerge.merge(nodeList1, nodeList2, new ArrayList<>()));
  }

  /**
   * Test {@link NodeValueMerge#merge(List, List, List)}.
   *
   * <ul>
   *   <li>Given {@link IIOMetadataNode#IIOMetadataNode(String)} with {@code foo} NodeValue is
   *       {@code Node List1}.
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link NodeValueMerge#merge(List, List, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Node[] NodeValueMerge.merge(List, List, List)"})
  public void testMerge_givenIIOMetadataNodeWithFooNodeValueIsNodeList1_whenNull() {
    // Arrange
    IIOMetadataNode iioMetadataNode = new IIOMetadataNode("foo");
    iioMetadataNode.setNodeValue("Node List1");

    ArrayList<Node> nodeList1 = new ArrayList<>();
    nodeList1.add(iioMetadataNode);

    // Act and Assert
    assertNull(nodeValueMerge.merge(nodeList1, null, new ArrayList<>()));
  }

  /**
   * Test {@link NodeValueMerge#merge(List, List, List)}.
   *
   * <ul>
   *   <li>Given {@link IIOMetadataNode#IIOMetadataNode()}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link IIOMetadataNode#IIOMetadataNode()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link NodeValueMerge#merge(List, List, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Node[] NodeValueMerge.merge(List, List, List)"})
  public void testMerge_givenIIOMetadataNode_whenArrayListAddIIOMetadataNode_thenReturnNull() {
    // Arrange
    ArrayList<Node> nodeList1 = new ArrayList<>();

    ArrayList<Node> nodeList2 = new ArrayList<>();
    nodeList2.add(new IIOMetadataNode());

    // Act and Assert
    assertNull(nodeValueMerge.merge(nodeList1, nodeList2, new ArrayList<>()));
  }

  /**
   * Test {@link NodeValueMerge#merge(List, List, List)}.
   *
   * <ul>
   *   <li>Given {@link IIOMetadataNode#IIOMetadataNode()}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link IIOMetadataNode#IIOMetadataNode()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link NodeValueMerge#merge(List, List, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Node[] NodeValueMerge.merge(List, List, List)"})
  public void testMerge_givenIIOMetadataNode_whenArrayListAddIIOMetadataNode_thenReturnNull2() {
    // Arrange
    ArrayList<Node> nodeList1 = new ArrayList<>();

    ArrayList<Node> nodeList2 = new ArrayList<>();
    nodeList2.add(new IIOMetadataNode());
    nodeList2.add(new IIOMetadataNode());

    // Act and Assert
    assertNull(nodeValueMerge.merge(nodeList1, nodeList2, new ArrayList<>()));
  }

  /**
   * Test {@link NodeValueMerge#merge(List, List, List)}.
   *
   * <ul>
   *   <li>Given {@link IIOMetadataNode#IIOMetadataNode()}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link IIOMetadataNode#IIOMetadataNode()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link NodeValueMerge#merge(List, List, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Node[] NodeValueMerge.merge(List, List, List)"})
  public void testMerge_givenIIOMetadataNode_whenArrayListAddIIOMetadataNode_thenReturnNull3() {
    // Arrange
    ArrayList<Node> nodeList1 = new ArrayList<>();
    ArrayList<Node> nodeList2 = new ArrayList<>();

    ArrayList<Node> exhaustedNodes = new ArrayList<>();
    exhaustedNodes.add(new IIOMetadataNode());

    // Act and Assert
    assertNull(nodeValueMerge.merge(nodeList1, nodeList2, exhaustedNodes));
  }

  /**
   * Test {@link NodeValueMerge#merge(List, List, List)}.
   *
   * <ul>
   *   <li>Given {@link IIOMetadataNode#IIOMetadataNode()}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link IIOMetadataNode#IIOMetadataNode()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link NodeValueMerge#merge(List, List, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Node[] NodeValueMerge.merge(List, List, List)"})
  public void testMerge_givenIIOMetadataNode_whenArrayListAddIIOMetadataNode_thenReturnNull4() {
    // Arrange
    ArrayList<Node> nodeList1 = new ArrayList<>();
    ArrayList<Node> nodeList2 = new ArrayList<>();

    ArrayList<Node> exhaustedNodes = new ArrayList<>();
    exhaustedNodes.add(new IIOMetadataNode());
    exhaustedNodes.add(new IIOMetadataNode());

    // Act and Assert
    assertNull(nodeValueMerge.merge(nodeList1, nodeList2, exhaustedNodes));
  }

  /**
   * Test {@link NodeValueMerge#merge(List, List, List)}.
   *
   * <ul>
   *   <li>Given {@link NodeValueMerge}.
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link NodeValueMerge#merge(List, List, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Node[] NodeValueMerge.merge(List, List, List)"})
  public void testMerge_givenNodeValueMerge_whenArrayList_thenReturnNull() {
    // Arrange
    ArrayList<Node> nodeList1 = new ArrayList<>();
    ArrayList<Node> nodeList2 = new ArrayList<>();

    // Act and Assert
    assertNull(nodeValueMerge.merge(nodeList1, nodeList2, new ArrayList<>()));
  }

  /**
   * Test {@link NodeValueMerge#merge(List, List, List)}.
   *
   * <ul>
   *   <li>Then first element return {@link IIOMetadataNode}.
   * </ul>
   *
   * <p>Method under test: {@link NodeValueMerge#merge(List, List, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Node[] NodeValueMerge.merge(List, List, List)"})
  public void testMerge_thenFirstElementReturnIIOMetadataNode() {
    // Arrange
    IIOMetadataNode iioMetadataNode = new IIOMetadataNode("foo");
    iioMetadataNode.setNodeValue("Node List1");

    ArrayList<Node> nodeList1 = new ArrayList<>();
    nodeList1.add(iioMetadataNode);

    IIOMetadataNode iioMetadataNode2 = new IIOMetadataNode("foo");
    iioMetadataNode2.setNodeValue("Node List2");

    ArrayList<Node> nodeList2 = new ArrayList<>();
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
    IIOMetadataNode iioMetadataNode17 = new IIOMetadataNode();
    nodeList2.add(iioMetadataNode17);
    IIOMetadataNode iioMetadataNode18 = new IIOMetadataNode();
    nodeList2.add(iioMetadataNode18);
    IIOMetadataNode iioMetadataNode19 = new IIOMetadataNode();
    nodeList2.add(iioMetadataNode19);

    // Act
    Node[] actualMergeResult = nodeValueMerge.merge(nodeList1, nodeList2, new ArrayList<>());

    // Assert
    Node node = actualMergeResult[0];
    assertTrue(node instanceof IIOMetadataNode);
    Node node2 = actualMergeResult[1];
    assertTrue(node2 instanceof IIOMetadataNode);
    Node node3 = actualMergeResult[10];
    assertTrue(node3 instanceof IIOMetadataNode);
    Node node4 = actualMergeResult[11];
    assertTrue(node4 instanceof IIOMetadataNode);
    Node node5 = actualMergeResult[12];
    assertTrue(node5 instanceof IIOMetadataNode);
    Node node6 = actualMergeResult[13];
    assertTrue(node6 instanceof IIOMetadataNode);
    Node node7 = actualMergeResult[14];
    assertTrue(node7 instanceof IIOMetadataNode);
    Node node8 = actualMergeResult[15];
    assertTrue(node8 instanceof IIOMetadataNode);
    Node node9 = actualMergeResult[17];
    assertTrue(node9 instanceof IIOMetadataNode);
    Node node10 = actualMergeResult[2];
    assertTrue(node10 instanceof IIOMetadataNode);
    Node node11 = actualMergeResult[3];
    assertTrue(node11 instanceof IIOMetadataNode);
    Node node12 = actualMergeResult[4];
    assertTrue(node12 instanceof IIOMetadataNode);
    Node node13 = actualMergeResult[5];
    assertTrue(node13 instanceof IIOMetadataNode);
    Node node14 = actualMergeResult[6];
    assertTrue(node14 instanceof IIOMetadataNode);
    Node node15 = actualMergeResult[7];
    assertTrue(node15 instanceof IIOMetadataNode);
    Node node16 = actualMergeResult[8];
    assertTrue(node16 instanceof IIOMetadataNode);
    Node node17 = actualMergeResult[9];
    assertTrue(node17 instanceof IIOMetadataNode);
    Node node18 = actualMergeResult[Short.SIZE];
    assertTrue(node18 instanceof IIOMetadataNode);
    assertEquals(18, actualMergeResult.length);
    assertSame(iioMetadataNode3, node2);
    assertSame(iioMetadataNode12, node3);
    assertSame(iioMetadataNode13, node4);
    assertSame(iioMetadataNode14, node5);
    assertSame(iioMetadataNode15, node6);
    assertSame(iioMetadataNode16, node7);
    assertSame(iioMetadataNode17, node8);
    assertSame(iioMetadataNode19, node9);
    assertSame(iioMetadataNode4, node10);
    assertSame(iioMetadataNode5, node11);
    assertSame(iioMetadataNode6, node12);
    assertSame(iioMetadataNode7, node13);
    assertSame(iioMetadataNode8, node14);
    assertSame(iioMetadataNode9, node15);
    assertSame(iioMetadataNode10, node16);
    assertSame(iioMetadataNode11, node17);
    assertSame(iioMetadataNode18, node18);
    assertSame(iioMetadataNode2, node);
  }

  /**
   * Test {@link NodeValueMerge#getMergedNodeValues(Node, Node)}.
   *
   * <ul>
   *   <li>Given {@link CommaDelimitedNodeValueMerge} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link NodeValueMerge#getMergedNodeValues(Node, Node)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Set NodeValueMerge.getMergedNodeValues(Node, Node)"})
  public void testGetMergedNodeValues_givenCommaDelimitedNodeValueMerge() {
    // Arrange
    CommaDelimitedNodeValueMerge commaDelimitedNodeValueMerge = new CommaDelimitedNodeValueMerge();

    IIOMetadataNode node1 = new IIOMetadataNode("foo");
    node1.setNodeValue("Node1");

    IIOMetadataNode node2 = new IIOMetadataNode("foo");
    node2.setNodeValue("Node2");

    // Act
    Set<String> actualMergedNodeValues =
        commaDelimitedNodeValueMerge.getMergedNodeValues(node1, node2);

    // Assert
    assertEquals(2, actualMergedNodeValues.size());
    assertTrue(actualMergedNodeValues.contains("Node1"));
    assertTrue(actualMergedNodeValues.contains("Node2"));
  }

  /**
   * Test {@link NodeValueMerge#getMergedNodeValues(Node, Node)}.
   *
   * <ul>
   *   <li>Given {@code Node1}.
   *   <li>Then return contains {@code Node1}.
   * </ul>
   *
   * <p>Method under test: {@link NodeValueMerge#getMergedNodeValues(Node, Node)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Set NodeValueMerge.getMergedNodeValues(Node, Node)"})
  public void testGetMergedNodeValues_givenNode1_thenReturnContainsNode1() {
    // Arrange
    SchemaLocationNodeValueMerge schemaLocationNodeValueMerge = new SchemaLocationNodeValueMerge();

    IIOMetadataNode node1 = new IIOMetadataNode("foo");
    node1.setNodeValue("Node1");

    IIOMetadataNode node2 = new IIOMetadataNode("foo");
    node2.setNodeValue("Node2");

    // Act
    Set<String> actualMergedNodeValues =
        schemaLocationNodeValueMerge.getMergedNodeValues(node1, node2);

    // Assert
    assertEquals(2, actualMergedNodeValues.size());
    assertTrue(actualMergedNodeValues.contains("Node1"));
    assertTrue(actualMergedNodeValues.contains("Node2"));
  }

  /**
   * Test {@link NodeValueMerge#getMergedNodeValues(Node, Node)}.
   *
   * <ul>
   *   <li>Given {@link NodeValueMerge} (default constructor).
   *   <li>Then return contains {@code Node1}.
   * </ul>
   *
   * <p>Method under test: {@link NodeValueMerge#getMergedNodeValues(Node, Node)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Set NodeValueMerge.getMergedNodeValues(Node, Node)"})
  public void testGetMergedNodeValues_givenNodeValueMerge_thenReturnContainsNode1() {
    // Arrange
    NodeValueMerge nodeValueMerge = new NodeValueMerge();

    IIOMetadataNode node1 = new IIOMetadataNode("foo");
    node1.setNodeValue("Node1");

    IIOMetadataNode node2 = new IIOMetadataNode("foo");
    node2.setNodeValue("Node2");

    // Act
    Set<String> actualMergedNodeValues = nodeValueMerge.getMergedNodeValues(node1, node2);

    // Assert
    assertEquals(2, actualMergedNodeValues.size());
    assertTrue(actualMergedNodeValues.contains("Node1"));
    assertTrue(actualMergedNodeValues.contains("Node2"));
  }

  /**
   * Test {@link NodeValueMerge#getMergedNodeValues(Node, Node)}.
   *
   * <ul>
   *   <li>Given {@code spring-UU-4.4.xsd42}.
   *   <li>Then return contains {@code spring-UU.xsd42}.
   * </ul>
   *
   * <p>Method under test: {@link NodeValueMerge#getMergedNodeValues(Node, Node)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Set NodeValueMerge.getMergedNodeValues(Node, Node)"})
  public void testGetMergedNodeValues_givenSpringUu44Xsd42_thenReturnContainsSpringUuXsd42() {
    // Arrange
    SchemaLocationNodeValueMerge schemaLocationNodeValueMerge = new SchemaLocationNodeValueMerge();

    IIOMetadataNode node1 = new IIOMetadataNode("foo");
    node1.setNodeValue("spring-UU-4.4.xsd42");

    IIOMetadataNode node2 = new IIOMetadataNode("foo");
    node2.setNodeValue("Node2");

    // Act
    Set<String> actualMergedNodeValues =
        schemaLocationNodeValueMerge.getMergedNodeValues(node1, node2);

    // Assert
    assertEquals(2, actualMergedNodeValues.size());
    assertTrue(actualMergedNodeValues.contains("Node2"));
    assertTrue(actualMergedNodeValues.contains("spring-UU.xsd42"));
  }

  /**
   * Test {@link NodeValueMerge#getMergedNodeValues(Node, Node)}.
   *
   * <ul>
   *   <li>Given {@code spring-UU-4.4.xsd-4.4}.
   *   <li>Then return contains {@code spring-UU.xsd-4.4}.
   * </ul>
   *
   * <p>Method under test: {@link NodeValueMerge#getMergedNodeValues(Node, Node)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Set NodeValueMerge.getMergedNodeValues(Node, Node)"})
  public void testGetMergedNodeValues_givenSpringUu44Xsd44_thenReturnContainsSpringUuXsd44() {
    // Arrange
    SchemaLocationNodeValueMerge schemaLocationNodeValueMerge = new SchemaLocationNodeValueMerge();

    IIOMetadataNode node1 = new IIOMetadataNode("foo");
    node1.setNodeValue("spring-UU-4.4.xsd");

    IIOMetadataNode node2 = new IIOMetadataNode("foo");
    node2.setNodeValue("spring-UU-4.4.xsd-4.4");

    // Act
    Set<String> actualMergedNodeValues =
        schemaLocationNodeValueMerge.getMergedNodeValues(node1, node2);

    // Assert
    assertEquals(2, actualMergedNodeValues.size());
    assertTrue(actualMergedNodeValues.contains("spring-UU.xsd"));
    assertTrue(actualMergedNodeValues.contains("spring-UU.xsd-4.4"));
  }

  /**
   * Test {@link NodeValueMerge#getMergedNodeValues(Node, Node)}.
   *
   * <ul>
   *   <li>Given {@code spring-UU-4.4.xsdNode Value}.
   *   <li>Then return size is three.
   * </ul>
   *
   * <p>Method under test: {@link NodeValueMerge#getMergedNodeValues(Node, Node)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Set NodeValueMerge.getMergedNodeValues(Node, Node)"})
  public void testGetMergedNodeValues_givenSpringUu44XsdNodeValue_thenReturnSizeIsThree() {
    // Arrange
    SchemaLocationNodeValueMerge schemaLocationNodeValueMerge = new SchemaLocationNodeValueMerge();

    IIOMetadataNode node1 = new IIOMetadataNode("foo");
    node1.setNodeValue("spring-UU-4.4.xsdNode Value");

    IIOMetadataNode node2 = new IIOMetadataNode("foo");
    node2.setNodeValue("Node2");

    // Act
    Set<String> actualMergedNodeValues =
        schemaLocationNodeValueMerge.getMergedNodeValues(node1, node2);

    // Assert
    assertEquals(3, actualMergedNodeValues.size());
    assertTrue(actualMergedNodeValues.contains("Node2"));
    assertTrue(actualMergedNodeValues.contains("Value"));
    assertTrue(actualMergedNodeValues.contains("spring-UU.xsdNode"));
  }

  /**
   * Test {@link NodeValueMerge#getMergedNodeValues(Node, Node)}.
   *
   * <ul>
   *   <li>Given {@code spring-UU-4.4.xsd}.
   *   <li>Then return contains {@code spring-UU.xsd}.
   * </ul>
   *
   * <p>Method under test: {@link NodeValueMerge#getMergedNodeValues(Node, Node)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Set NodeValueMerge.getMergedNodeValues(Node, Node)"})
  public void testGetMergedNodeValues_givenSpringUu44Xsd_thenReturnContainsSpringUuXsd() {
    // Arrange
    SchemaLocationNodeValueMerge schemaLocationNodeValueMerge = new SchemaLocationNodeValueMerge();

    IIOMetadataNode node1 = new IIOMetadataNode("foo");
    node1.setNodeValue("spring-UU-4.4.xsd");

    IIOMetadataNode node2 = new IIOMetadataNode("foo");
    node2.setNodeValue("Node2");

    // Act
    Set<String> actualMergedNodeValues =
        schemaLocationNodeValueMerge.getMergedNodeValues(node1, node2);

    // Assert
    assertEquals(2, actualMergedNodeValues.size());
    assertTrue(actualMergedNodeValues.contains("Node2"));
    assertTrue(actualMergedNodeValues.contains("spring-UU.xsd"));
  }

  /**
   * Test {@link NodeValueMerge#getMergedNodeValues(Node, Node)}.
   *
   * <ul>
   *   <li>Given {@code spring-UU-4.4.xsdspring-UU-4x4xxsd}.
   * </ul>
   *
   * <p>Method under test: {@link NodeValueMerge#getMergedNodeValues(Node, Node)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Set NodeValueMerge.getMergedNodeValues(Node, Node)"})
  public void testGetMergedNodeValues_givenSpringUu44XsdspringUu4x4xxsd() {
    // Arrange
    SchemaLocationNodeValueMerge schemaLocationNodeValueMerge = new SchemaLocationNodeValueMerge();

    IIOMetadataNode node1 = new IIOMetadataNode("foo");
    node1.setNodeValue("spring-UU-4.4.xsd");

    IIOMetadataNode node2 = new IIOMetadataNode("foo");
    node2.setNodeValue("spring-UU-4.4.xsdspring-UU-4x4xxsd");

    // Act
    Set<String> actualMergedNodeValues =
        schemaLocationNodeValueMerge.getMergedNodeValues(node1, node2);

    // Assert
    assertEquals(2, actualMergedNodeValues.size());
    assertTrue(actualMergedNodeValues.contains("spring-UU.xsd"));
    assertTrue(actualMergedNodeValues.contains("spring-UU.xsdspring-UU.xsd"));
  }

  /**
   * Test {@link NodeValueMerge#getMergedNodeValues(Node, Node)}.
   *
   * <ul>
   *   <li>Given {@code spring-UU-4.4.xsdspring-UU-4.4.xsd}.
   * </ul>
   *
   * <p>Method under test: {@link NodeValueMerge#getMergedNodeValues(Node, Node)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Set NodeValueMerge.getMergedNodeValues(Node, Node)"})
  public void testGetMergedNodeValues_givenSpringUu44XsdspringUu44Xsd() {
    // Arrange
    SchemaLocationNodeValueMerge schemaLocationNodeValueMerge = new SchemaLocationNodeValueMerge();

    IIOMetadataNode node1 = new IIOMetadataNode("foo");
    node1.setNodeValue("spring-UU-4.4.xsdspring-UU-4.4.xsd");

    IIOMetadataNode node2 = new IIOMetadataNode("foo");
    node2.setNodeValue("Node2");

    // Act
    Set<String> actualMergedNodeValues =
        schemaLocationNodeValueMerge.getMergedNodeValues(node1, node2);

    // Assert
    assertEquals(2, actualMergedNodeValues.size());
    assertTrue(actualMergedNodeValues.contains("Node2"));
    assertTrue(actualMergedNodeValues.contains("spring-UU.xsdspring-UU.xsd"));
  }

  /**
   * Test {@link NodeValueMerge#getMergedNodeValues(Node, Node)}.
   *
   * <ul>
   *   <li>Then return contains {@code spring-UU.xsd(spring-\w*-[0-9]\.[0-9]\.xsd)}.
   * </ul>
   *
   * <p>Method under test: {@link NodeValueMerge#getMergedNodeValues(Node, Node)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Set NodeValueMerge.getMergedNodeValues(Node, Node)"})
  public void testGetMergedNodeValues_thenReturnContainsSpringUuXsdSpringW0909Xsd() {
    // Arrange
    SchemaLocationNodeValueMerge schemaLocationNodeValueMerge = new SchemaLocationNodeValueMerge();

    IIOMetadataNode node1 = new IIOMetadataNode("foo");
    node1.setNodeValue("spring-UU-4.4.xsd(spring-\\w*-[0-9]\\.[0-9]\\.xsd)");

    IIOMetadataNode node2 = new IIOMetadataNode("foo");
    node2.setNodeValue("Node2");

    // Act
    Set<String> actualMergedNodeValues =
        schemaLocationNodeValueMerge.getMergedNodeValues(node1, node2);

    // Assert
    assertEquals(2, actualMergedNodeValues.size());
    assertTrue(actualMergedNodeValues.contains("Node2"));
    assertTrue(actualMergedNodeValues.contains("spring-UU.xsd(spring-\\w*-[0-9]\\.[0-9]\\.xsd)"));
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link NodeValueMerge#getDelimiter()}
   *   <li>{@link NodeValueMerge#getRegEx()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String NodeValueMerge.getDelimiter()", "String NodeValueMerge.getRegEx()"})
  public void testGettersAndSetters() {
    // Arrange
    NodeValueMerge nodeValueMerge = new NodeValueMerge();

    // Act
    String actualDelimiter = nodeValueMerge.getDelimiter();

    // Assert
    assertEquals(" ", actualDelimiter);
    assertEquals("[\\s\\n\\r]+", nodeValueMerge.getRegEx());
  }

  /**
   * Test new {@link NodeValueMerge} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link NodeValueMerge}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void NodeValueMerge.<init>()"})
  public void testNewNodeValueMerge() {
    // Arrange and Act
    NodeValueMerge actualNodeValueMerge = new NodeValueMerge();

    // Assert
    assertEquals(" ", actualNodeValueMerge.getDelimiter());
    assertEquals("[\\s\\n\\r]+", actualNodeValueMerge.getRegEx());
    assertNull(actualNodeValueMerge.getName());
    assertNull(actualNodeValueMerge.getXPath());
    assertEquals(0, actualNodeValueMerge.getPriority());
    assertEquals(0, actualNodeValueMerge.getChildren().length);
  }
}
