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
import org.apache.xerces.impl.xs.opti.DefaultDocument;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.w3c.dom.Node;

@ContextConfiguration(classes = {NodeReplace.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class NodeReplaceDiffblueTest {
  @Autowired
  private NodeReplace nodeReplace;

  /**
   * Method under test: {@link NodeReplace#checkNode(List, Node[], Node)}
   */
  @Test
  public void testCheckNode() {
    // Arrange
    ArrayList<Node> usedNodes = new ArrayList<>();
    SchemaLocationMergeTest.DummyNode dummyNode = mock(SchemaLocationMergeTest.DummyNode.class);
    when(dummyNode.isEqualNode(Mockito.<Node>any())).thenReturn(true);
    when(dummyNode.getNodeName()).thenReturn("Node Name");
    Node[] primaryNodes = new Node[]{dummyNode};

    // Act
    boolean actualCheckNodeResult = nodeReplace.checkNode(usedNodes, primaryNodes, new IIOMetadataNode("foo"));

    // Assert
    verify(dummyNode).getNodeName();
    verify(dummyNode).isEqualNode(isA(Node.class));
    assertEquals(1, usedNodes.size());
    assertEquals(1, primaryNodes.length);
    assertTrue(actualCheckNodeResult);
    assertSame(usedNodes.get(0), primaryNodes[0]);
  }

  /**
   * Method under test: {@link NodeReplace#checkNode(List, Node[], Node)}
   */
  @Test
  public void testCheckNode2() {
    // Arrange
    ArrayList<Node> usedNodes = new ArrayList<>();
    SchemaLocationMergeTest.DummyNode dummyNode = mock(SchemaLocationMergeTest.DummyNode.class);
    when(dummyNode.isEqualNode(Mockito.<Node>any())).thenReturn(false);
    when(dummyNode.getNodeName()).thenReturn("Node Name");
    Node[] primaryNodes = new Node[]{dummyNode};

    // Act
    boolean actualCheckNodeResult = nodeReplace.checkNode(usedNodes, primaryNodes, new IIOMetadataNode("foo"));

    // Assert
    verify(dummyNode).getNodeName();
    verify(dummyNode).isEqualNode(isA(Node.class));
    assertEquals(1, primaryNodes.length);
    assertFalse(actualCheckNodeResult);
    assertTrue(usedNodes.isEmpty());
  }

  /**
   * Method under test: {@link NodeReplace#replaceNode(Node[], Node, List)}
   */
  @Test
  public void testReplaceNode() {
    // Arrange
    IIOMetadataNode testNode = new IIOMetadataNode("foo");

    // Act and Assert
    assertFalse(nodeReplace.replaceNode(new Node[]{new DefaultDocument()}, testNode, new ArrayList<>()));
  }

  /**
   * Method under test: {@link NodeReplace#replaceNode(Node[], Node, List)}
   */
  @Test
  public void testReplaceNode2() {
    // Arrange
    SchemaLocationMergeTest.DummyNode dummyNode = mock(SchemaLocationMergeTest.DummyNode.class);
    when(dummyNode.getNodeName()).thenReturn("Node Name");
    IIOMetadataNode testNode = new IIOMetadataNode("foo");

    // Act
    boolean actualReplaceNodeResult = nodeReplace.replaceNode(new Node[]{dummyNode}, testNode, new ArrayList<>());

    // Assert
    verify(dummyNode).getNodeName();
    assertFalse(actualReplaceNodeResult);
  }

  /**
   * Method under test: {@link NodeReplace#replaceNode(Node[], Node, List)}
   */
  @Test
  public void testReplaceNode3() {
    // Arrange
    SchemaLocationMergeTest.DummyNode dummyNode = mock(SchemaLocationMergeTest.DummyNode.class);
    when(dummyNode.getNodeName()).thenReturn("Node Name");
    IIOMetadataNode testNode = new IIOMetadataNode("foo");

    ArrayList<Node> usedNodes = new ArrayList<>();
    usedNodes.add(new IIOMetadataNode("Node Name"));

    // Act
    boolean actualReplaceNodeResult = nodeReplace.replaceNode(new Node[]{dummyNode}, testNode, usedNodes);

    // Assert
    verify(dummyNode).getNodeName();
    assertFalse(actualReplaceNodeResult);
  }

  /**
   * Method under test: {@link NodeReplace#replaceNode(Node[], Node, List)}
   */
  @Test
  public void testReplaceNode4() {
    // Arrange
    SchemaLocationMergeTest.DummyNode dummyNode = mock(SchemaLocationMergeTest.DummyNode.class);
    when(dummyNode.getNodeName()).thenReturn("Node Name");
    IIOMetadataNode testNode = new IIOMetadataNode("foo");

    ArrayList<Node> usedNodes = new ArrayList<>();
    usedNodes.add(new IIOMetadataNode("Node Name"));
    usedNodes.add(new IIOMetadataNode("Node Name"));

    // Act
    boolean actualReplaceNodeResult = nodeReplace.replaceNode(new Node[]{dummyNode}, testNode, usedNodes);

    // Assert
    verify(dummyNode).getNodeName();
    assertFalse(actualReplaceNodeResult);
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link NodeReplace}
   */
  @Test
  public void testNewNodeReplace() {
    // Arrange and Act
    NodeReplace actualNodeReplace = new NodeReplace();

    // Assert
    assertNull(actualNodeReplace.getName());
    assertNull(actualNodeReplace.getXPath());
    assertEquals(0, actualNodeReplace.getPriority());
    assertEquals(0, actualNodeReplace.getChildren().length);
  }
}
