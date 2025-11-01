/*-
 * #%L
 * BroadleafCommerce Common Libraries
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
import java.util.ArrayList;
import java.util.List;
import javax.imageio.metadata.IIOMetadataNode;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.w3c.dom.Node;

@ContextConfiguration(classes = {NodeReplaceInsert.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class NodeReplaceInsertDiffblueTest {
  @Autowired
  private NodeReplaceInsert nodeReplaceInsert;

  /**
   * Method under test: {@link NodeReplaceInsert#merge(List, List, List)}
   */
  @Test
  public void testMerge() {
    // Arrange
    ArrayList<Node> nodeList1 = new ArrayList<>();
    ArrayList<Node> nodeList2 = new ArrayList<>();

    // Act and Assert
    assertNull(nodeReplaceInsert.merge(nodeList1, nodeList2, new ArrayList<>()));
  }

  /**
   * Method under test: {@link NodeReplaceInsert#merge(List, List, List)}
   */
  @Test
  public void testMerge2() {
    // Arrange
    ArrayList<Node> nodeList1 = new ArrayList<>();
    nodeList1.add(new IIOMetadataNode("foo"));
    ArrayList<Node> nodeList2 = new ArrayList<>();

    // Act and Assert
    assertNull(nodeReplaceInsert.merge(nodeList1, nodeList2, new ArrayList<>()));
  }

  /**
   * Method under test: {@link NodeReplaceInsert#merge(List, List, List)}
   */
  @Test
  public void testMerge3() {
    // Arrange
    ArrayList<Node> nodeList1 = new ArrayList<>();
    nodeList1.add(new IIOMetadataNode("foo"));
    nodeList1.add(new IIOMetadataNode("foo"));
    ArrayList<Node> nodeList2 = new ArrayList<>();

    // Act and Assert
    assertNull(nodeReplaceInsert.merge(nodeList1, nodeList2, new ArrayList<>()));
  }

  /**
   * Method under test: {@link NodeReplaceInsert#merge(List, List, List)}
   */
  @Test
  public void testMerge4() {
    // Arrange
    ArrayList<Node> nodeList1 = new ArrayList<>();

    ArrayList<Node> nodeList2 = new ArrayList<>();
    nodeList2.add(new IIOMetadataNode("foo"));

    // Act and Assert
    assertNull(nodeReplaceInsert.merge(nodeList1, nodeList2, new ArrayList<>()));
  }

  /**
   * Method under test: {@link NodeReplaceInsert#merge(List, List, List)}
   */
  @Test
  public void testMerge5() {
    // Arrange
    ArrayList<Node> nodeList1 = new ArrayList<>();

    ArrayList<Node> nodeList2 = new ArrayList<>();
    nodeList2.add(new IIOMetadataNode("foo"));
    nodeList2.add(new IIOMetadataNode("foo"));

    // Act and Assert
    assertNull(nodeReplaceInsert.merge(nodeList1, nodeList2, new ArrayList<>()));
  }

  /**
   * Method under test: {@link NodeReplaceInsert#merge(List, List, List)}
   */
  @Test
  public void testMerge6() {
    // Arrange
    ArrayList<Node> nodeList1 = new ArrayList<>();
    ArrayList<Node> nodeList2 = new ArrayList<>();

    ArrayList<Node> exhaustedNodes = new ArrayList<>();
    exhaustedNodes.add(new IIOMetadataNode("foo"));

    // Act and Assert
    assertNull(nodeReplaceInsert.merge(nodeList1, nodeList2, exhaustedNodes));
  }

  /**
   * Method under test: {@link NodeReplaceInsert#merge(List, List, List)}
   */
  @Test
  public void testMerge7() {
    // Arrange
    ArrayList<Node> nodeList1 = new ArrayList<>();
    ArrayList<Node> nodeList2 = new ArrayList<>();

    ArrayList<Node> exhaustedNodes = new ArrayList<>();
    exhaustedNodes.add(new IIOMetadataNode("foo"));
    exhaustedNodes.add(new IIOMetadataNode("foo"));

    // Act and Assert
    assertNull(nodeReplaceInsert.merge(nodeList1, nodeList2, exhaustedNodes));
  }

  /**
   * Method under test: {@link NodeReplaceInsert#merge(List, List, List)}
   */
  @Test
  public void testMerge8() {
    // Arrange
    ArrayList<Node> nodeList1 = new ArrayList<>();
    nodeList1.add(mock(SchemaLocationMergeTest.DummyNode.class));
    ArrayList<Node> nodeList2 = new ArrayList<>();

    // Act and Assert
    assertNull(nodeReplaceInsert.merge(nodeList1, nodeList2, new ArrayList<>()));
  }

  /**
   * Method under test: {@link NodeReplaceInsert#checkNode(List, Node[], Node)}
   */
  @Test
  public void testCheckNode() {
    // Arrange
    ArrayList<Node> usedNodes = new ArrayList<>();
    SchemaLocationMergeTest.DummyNode dummyNode = mock(SchemaLocationMergeTest.DummyNode.class);
    when(dummyNode.isEqualNode(Mockito.<Node>any())).thenReturn(true);
    Node[] primaryNodes = new Node[]{dummyNode};

    // Act
    boolean actualCheckNodeResult = nodeReplaceInsert.checkNode(usedNodes, primaryNodes, new IIOMetadataNode("foo"));

    // Assert
    verify(dummyNode).isEqualNode(isA(Node.class));
    assertEquals(1, usedNodes.size());
    assertEquals(1, primaryNodes.length);
    assertTrue(actualCheckNodeResult);
    assertSame(usedNodes.get(0), primaryNodes[0]);
  }

  /**
   * Method under test: {@link NodeReplaceInsert#checkNode(List, Node[], Node)}
   */
  @Test
  public void testCheckNode2() {
    // Arrange
    ArrayList<Node> usedNodes = new ArrayList<>();
    SchemaLocationMergeTest.DummyNode dummyNode = mock(SchemaLocationMergeTest.DummyNode.class);
    when(dummyNode.isEqualNode(Mockito.<Node>any())).thenReturn(false);
    Node[] primaryNodes = new Node[]{dummyNode};

    // Act
    boolean actualCheckNodeResult = nodeReplaceInsert.checkNode(usedNodes, primaryNodes, new IIOMetadataNode("foo"));

    // Assert
    verify(dummyNode).isEqualNode(isA(Node.class));
    assertEquals(1, primaryNodes.length);
    assertFalse(actualCheckNodeResult);
    assertTrue(usedNodes.isEmpty());
  }

  /**
   * Method under test:
   * {@link NodeReplaceInsert#exactNodeExists(Node[], Node, List)}
   */
  @Test
  public void testExactNodeExists() {
    // Arrange
    SchemaLocationMergeTest.DummyNode dummyNode = mock(SchemaLocationMergeTest.DummyNode.class);
    when(dummyNode.isEqualNode(Mockito.<Node>any())).thenReturn(true);
    IIOMetadataNode testNode = new IIOMetadataNode("foo");
    ArrayList<Node> usedNodes = new ArrayList<>();

    // Act
    boolean actualExactNodeExistsResult = nodeReplaceInsert.exactNodeExists(new Node[]{dummyNode}, testNode, usedNodes);

    // Assert
    verify(dummyNode).isEqualNode(isA(Node.class));
    assertEquals(1, usedNodes.size());
    assertTrue(actualExactNodeExistsResult);
  }

  /**
   * Method under test:
   * {@link NodeReplaceInsert#exactNodeExists(Node[], Node, List)}
   */
  @Test
  public void testExactNodeExists2() {
    // Arrange
    SchemaLocationMergeTest.DummyNode dummyNode = mock(SchemaLocationMergeTest.DummyNode.class);
    when(dummyNode.isEqualNode(Mockito.<Node>any())).thenReturn(false);
    IIOMetadataNode testNode = new IIOMetadataNode("foo");
    ArrayList<Node> usedNodes = new ArrayList<>();

    // Act
    boolean actualExactNodeExistsResult = nodeReplaceInsert.exactNodeExists(new Node[]{dummyNode}, testNode, usedNodes);

    // Assert
    verify(dummyNode).isEqualNode(isA(Node.class));
    assertFalse(actualExactNodeExistsResult);
    assertTrue(usedNodes.isEmpty());
  }

  /**
   * Method under test:
   * {@link NodeReplaceInsert#exactNodeExists(Node[], Node, List)}
   */
  @Test
  public void testExactNodeExists3() {
    // Arrange
    SchemaLocationMergeTest.DummyNode dummyNode = mock(SchemaLocationMergeTest.DummyNode.class);
    when(dummyNode.isEqualNode(Mockito.<Node>any())).thenReturn(true);
    IIOMetadataNode testNode = new IIOMetadataNode("foo");

    ArrayList<Node> usedNodes = new ArrayList<>();
    IIOMetadataNode iioMetadataNode = new IIOMetadataNode("foo");
    usedNodes.add(iioMetadataNode);

    // Act
    boolean actualExactNodeExistsResult = nodeReplaceInsert.exactNodeExists(new Node[]{dummyNode}, testNode, usedNodes);

    // Assert
    verify(dummyNode).isEqualNode(isA(Node.class));
    assertEquals(2, usedNodes.size());
    Node getResult = usedNodes.get(0);
    assertTrue(getResult instanceof IIOMetadataNode);
    assertTrue(actualExactNodeExistsResult);
    assertSame(iioMetadataNode, getResult);
  }

  /**
   * Method under test:
   * {@link NodeReplaceInsert#replaceNode(Node[], Node, String, List)}
   */
  @Test
  public void testReplaceNode() {
    // Arrange
    IIOMetadataNode testNode = new IIOMetadataNode("foo");

    // Act and Assert
    assertFalse(nodeReplaceInsert.replaceNode(new Node[]{new IIOMetadataNode("foo")}, testNode, "Attribute",
        new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link NodeReplaceInsert#replaceNode(Node[], Node, String, List)}
   */
  @Test
  public void testReplaceNode2() {
    // Arrange
    IIOMetadataNode testNode = new IIOMetadataNode("foo");

    // Act and Assert
    assertFalse(nodeReplaceInsert.replaceNode(new Node[]{mock(SchemaLocationMergeTest.DummyNode.class)}, testNode,
        "Attribute", new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link NodeReplaceInsert#replaceNode(Node[], Node, String, List)}
   */
  @Test
  public void testReplaceNode3() {
    // Arrange
    IIOMetadataNode testNode = new IIOMetadataNode("foo");

    ArrayList<Node> usedNodes = new ArrayList<>();
    usedNodes.add(new IIOMetadataNode("foo"));

    // Act and Assert
    assertFalse(
        nodeReplaceInsert.replaceNode(new Node[]{new IIOMetadataNode("foo")}, testNode, "Attribute", usedNodes));
  }

  /**
   * Method under test:
   * {@link NodeReplaceInsert#replaceNode(Node[], Node, String, List)}
   */
  @Test
  public void testReplaceNode4() {
    // Arrange
    IIOMetadataNode testNode = new IIOMetadataNode("foo");

    ArrayList<Node> usedNodes = new ArrayList<>();
    usedNodes.add(new IIOMetadataNode("foo"));
    usedNodes.add(new IIOMetadataNode("foo"));

    // Act and Assert
    assertFalse(
        nodeReplaceInsert.replaceNode(new Node[]{new IIOMetadataNode("foo")}, testNode, "Attribute", usedNodes));
  }

  /**
   * Method under test:
   * {@link NodeReplaceInsert#replaceCeilingEntityNode(Node[], Node, List)}
   */
  @Test
  public void testReplaceCeilingEntityNode() {
    // Arrange
    IIOMetadataNode testNode = new IIOMetadataNode("foo");

    // Act and Assert
    assertFalse(nodeReplaceInsert.replaceCeilingEntityNode(new Node[]{new IIOMetadataNode("foo")}, testNode,
        new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link NodeReplaceInsert#replaceCeilingEntityNode(Node[], Node, List)}
   */
  @Test
  public void testReplaceCeilingEntityNode2() {
    // Arrange
    IIOMetadataNode testNode = new IIOMetadataNode("foo");

    // Act and Assert
    assertFalse(nodeReplaceInsert.replaceCeilingEntityNode(new Node[]{mock(SchemaLocationMergeTest.DummyNode.class)},
        testNode, new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link NodeReplaceInsert#replaceCeilingEntityNode(Node[], Node, List)}
   */
  @Test
  public void testReplaceCeilingEntityNode3() {
    // Arrange
    IIOMetadataNode testNode = new IIOMetadataNode("foo");

    ArrayList<Node> usedNodes = new ArrayList<>();
    usedNodes.add(new IIOMetadataNode("foo"));

    // Act and Assert
    assertFalse(
        nodeReplaceInsert.replaceCeilingEntityNode(new Node[]{new IIOMetadataNode("foo")}, testNode, usedNodes));
  }

  /**
   * Method under test:
   * {@link NodeReplaceInsert#replaceCeilingEntityNode(Node[], Node, List)}
   */
  @Test
  public void testReplaceCeilingEntityNode4() {
    // Arrange
    IIOMetadataNode testNode = new IIOMetadataNode("foo");

    ArrayList<Node> usedNodes = new ArrayList<>();
    usedNodes.add(new IIOMetadataNode("foo"));
    usedNodes.add(new IIOMetadataNode("foo"));

    // Act and Assert
    assertFalse(
        nodeReplaceInsert.replaceCeilingEntityNode(new Node[]{new IIOMetadataNode("foo")}, testNode, usedNodes));
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link NodeReplaceInsert}
   */
  @Test
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
