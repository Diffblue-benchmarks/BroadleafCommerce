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
package org.broadleafcommerce.common.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import javax.imageio.metadata.IIOMetadataNode;
import org.apache.html.dom.HTMLAnchorElementImpl;
import org.apache.xerces.dom.AttrNSImpl;
import org.apache.xerces.impl.xs.opti.DefaultDocument;
import org.dom4j.dom.DOMAttributeNodeMap;
import org.dom4j.dom.DOMElement;
import org.junit.Test;
import org.mockito.Mockito;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class NodeUtilDiffblueTest {
  /**
   * Method under test: {@link NodeUtil#filterByAttribute(Node[], String)}
   */
  @Test
  public void testFilterByAttribute() {
    // Arrange, Act and Assert
    assertEquals(0, NodeUtil.filterByAttribute(new Node[]{new IIOMetadataNode("foo")}, "Attribute Name").length);
  }

  /**
   * Method under test: {@link NodeUtil#filterByAttribute(Node[], String)}
   */
  @Test
  public void testFilterByAttribute2() {
    // Arrange
    Node node = mock(Node.class);
    when(node.getAttributes()).thenReturn(new DOMAttributeNodeMap(new DOMElement("Name")));

    // Act
    Node[] actualFilterByAttributeResult = NodeUtil.filterByAttribute(new Node[]{node}, "Attribute Name");

    // Assert
    verify(node).getAttributes();
    assertEquals(0, actualFilterByAttributeResult.length);
  }

  /**
   * Method under test: {@link NodeUtil#filterByAttribute(Node[], String)}
   */
  @Test
  public void testFilterByAttribute3() {
    // Arrange
    DOMElement element = mock(DOMElement.class);
    when(element.getAttributeNode(Mockito.<String>any())).thenReturn(new AttrNSImpl());
    Node node = mock(Node.class);
    when(node.getAttributes()).thenReturn(new DOMAttributeNodeMap(element));

    // Act
    Node[] actualFilterByAttributeResult = NodeUtil.filterByAttribute(new Node[]{node}, "Attribute Name");

    // Assert
    verify(element).getAttributeNode(eq("Attribute Name"));
    verify(node).getAttributes();
    assertEquals(1, actualFilterByAttributeResult.length);
  }

  /**
   * Method under test: {@link NodeUtil#findNode(Node[], Node, String, boolean)}
   */
  @Test
  public void testFindNode() {
    // Arrange, Act and Assert
    assertEquals(-2,
        NodeUtil.findNode(new Node[]{new IIOMetadataNode("foo")}, new IIOMetadataNode("foo"), "Attribute Name", true));
  }

  /**
   * Method under test: {@link NodeUtil#findNode(Node[], Node, String, boolean)}
   */
  @Test
  public void testFindNode2() {
    // Arrange
    DefaultDocument defaultDocument = mock(DefaultDocument.class);
    when(defaultDocument.getNodeName()).thenReturn("Node Name");
    when(defaultDocument.getAttributes()).thenReturn(new DOMAttributeNodeMap(new DOMElement("Name")));

    // Act
    int actualFindNodeResult = NodeUtil.findNode(new Node[]{defaultDocument}, new IIOMetadataNode("foo"),
        "Attribute Name", true);

    // Assert
    verify(defaultDocument, atLeast(1)).getNodeName();
    verify(defaultDocument).getAttributes();
    assertEquals(-2, actualFindNodeResult);
  }

  /**
   * Method under test: {@link NodeUtil#findNode(Node[], Node, String, boolean)}
   */
  @Test
  public void testFindNode3() {
    // Arrange
    DefaultDocument defaultDocument = mock(DefaultDocument.class);
    when(defaultDocument.getNodeName()).thenReturn("Node Name");
    when(defaultDocument.getAttributes()).thenReturn(new DOMAttributeNodeMap(new DOMElement("Name")));

    // Act
    int actualFindNodeResult = NodeUtil.findNode(new Node[]{defaultDocument}, new IIOMetadataNode("foo"),
        "Attribute Name", false);

    // Assert
    verify(defaultDocument, atLeast(1)).getNodeName();
    verify(defaultDocument).getAttributes();
    assertEquals(-2, actualFindNodeResult);
  }

  /**
   * Method under test:
   * {@link NodeUtil#mergeNodeLists(Node, NodeList, NodeList, String)}
   */
  @Test
  public void testMergeNodeLists() {
    // Arrange
    IIOMetadataNode targetNode = new IIOMetadataNode("foo");
    IIOMetadataNode list1 = new IIOMetadataNode("foo");

    // Act
    NodeUtil.mergeNodeLists(targetNode, list1, new IIOMetadataNode("foo"), "Attribute Name");

    // Assert
    assertNull(targetNode.getFirstChild());
    assertNull(targetNode.getLastChild());
    assertEquals(0, targetNode.getLength());
    assertFalse(targetNode.hasChildNodes());
  }

  /**
   * Method under test:
   * {@link NodeUtil#mergeNodeLists(Node, NodeList, NodeList, String)}
   */
  @Test
  public void testMergeNodeLists2() {
    // Arrange
    DefaultDocument targetNode = mock(DefaultDocument.class);
    IIOMetadataNode list1 = new IIOMetadataNode("foo");

    // Act
    NodeUtil.mergeNodeLists(targetNode, list1, new IIOMetadataNode("foo"), "Attribute Name");

    // Assert
    assertNull(list1.getFirstChild());
    assertNull(list1.getLastChild());
    assertEquals(0, list1.getLength());
    assertFalse(list1.hasChildNodes());
  }

  /**
   * Method under test:
   * {@link NodeUtil#mergeNodeLists(Node, NodeList, NodeList, String)}
   */
  @Test
  public void testMergeNodeLists3() {
    // Arrange
    IIOMetadataNode targetNode = new IIOMetadataNode("foo");

    // Act
    NodeUtil.mergeNodeLists(targetNode, null, new IIOMetadataNode("foo"), "Attribute Name");

    // Assert
    assertNull(targetNode.getFirstChild());
    assertNull(targetNode.getLastChild());
    assertEquals(0, targetNode.getLength());
    assertFalse(targetNode.hasChildNodes());
  }

  /**
   * Method under test:
   * {@link NodeUtil#mergeNodeLists(Node, NodeList, NodeList, String)}
   */
  @Test
  public void testMergeNodeLists4() {
    // Arrange
    IIOMetadataNode targetNode = new IIOMetadataNode("foo");
    HTMLAnchorElementImpl list1 = mock(HTMLAnchorElementImpl.class);
    IIOMetadataNode iioMetadataNode = new IIOMetadataNode("foo");
    when(list1.item(anyInt())).thenReturn(iioMetadataNode);
    when(list1.getLength()).thenReturn(3);

    // Act
    NodeUtil.mergeNodeLists(targetNode, list1, new IIOMetadataNode("foo"), "Attribute Name");

    // Assert
    verify(list1, atLeast(1)).getLength();
    verify(list1, atLeast(1)).item(anyInt());
    assertEquals(3, targetNode.getLength());
    assertTrue(targetNode.hasChildNodes());
    assertSame(iioMetadataNode, targetNode.getFirstChild());
    assertSame(iioMetadataNode, targetNode.getLastChild());
  }

  /**
   * Method under test:
   * {@link NodeUtil#mergeNodeLists(Node, NodeList, NodeList, String)}
   */
  @Test
  public void testMergeNodeLists5() {
    // Arrange
    IIOMetadataNode targetNode = new IIOMetadataNode("foo");
    HTMLAnchorElementImpl list1 = mock(HTMLAnchorElementImpl.class);
    when(list1.item(anyInt())).thenReturn(new IIOMetadataNode("#text"));
    when(list1.getLength()).thenReturn(3);

    // Act
    NodeUtil.mergeNodeLists(targetNode, list1, new IIOMetadataNode("foo"), "Attribute Name");

    // Assert
    verify(list1, atLeast(1)).getLength();
    verify(list1, atLeast(1)).item(anyInt());
    assertNull(targetNode.getFirstChild());
    assertNull(targetNode.getLastChild());
    assertEquals(0, targetNode.getLength());
    assertFalse(targetNode.hasChildNodes());
  }

  /**
   * Method under test:
   * {@link NodeUtil#mergeNodeLists(Node, NodeList, NodeList, String)}
   */
  @Test
  public void testMergeNodeLists6() {
    // Arrange
    IIOMetadataNode targetNode = new IIOMetadataNode("foo");
    HTMLAnchorElementImpl list1 = mock(HTMLAnchorElementImpl.class);
    IIOMetadataNode iioMetadataNode = new IIOMetadataNode("foo");
    when(list1.item(anyInt())).thenReturn(iioMetadataNode);
    when(list1.getLength()).thenReturn(3);

    // Act
    NodeUtil.mergeNodeLists(targetNode, list1, null, "Attribute Name");

    // Assert
    verify(list1, atLeast(1)).getLength();
    verify(list1, atLeast(1)).item(anyInt());
    assertEquals(3, targetNode.getLength());
    assertTrue(targetNode.hasChildNodes());
    assertSame(iioMetadataNode, targetNode.getFirstChild());
    assertSame(iioMetadataNode, targetNode.getLastChild());
  }

  /**
   * Method under test:
   * {@link NodeUtil#mergeNodeLists(Node, NodeList, NodeList, String)}
   */
  @Test
  public void testMergeNodeLists7() {
    // Arrange
    IIOMetadataNode targetNode = new IIOMetadataNode("foo");
    HTMLAnchorElementImpl list1 = mock(HTMLAnchorElementImpl.class);
    IIOMetadataNode iioMetadataNode = new IIOMetadataNode("foo");
    when(list1.item(anyInt())).thenReturn(iioMetadataNode);
    when(list1.getLength()).thenReturn(3);
    HTMLAnchorElementImpl list2 = mock(HTMLAnchorElementImpl.class);
    IIOMetadataNode iioMetadataNode2 = new IIOMetadataNode("foo");
    when(list2.item(anyInt())).thenReturn(iioMetadataNode2);
    when(list2.getLength()).thenReturn(3);

    // Act
    NodeUtil.mergeNodeLists(targetNode, list1, list2, "Attribute Name");

    // Assert
    verify(list1, atLeast(1)).getLength();
    verify(list2, atLeast(1)).getLength();
    verify(list1, atLeast(1)).item(anyInt());
    verify(list2, atLeast(1)).item(anyInt());
    assertEquals(6, targetNode.getLength());
    assertTrue(targetNode.hasChildNodes());
    assertSame(iioMetadataNode2, targetNode.getFirstChild());
    assertSame(iioMetadataNode, targetNode.getLastChild());
  }

  /**
   * Method under test:
   * {@link NodeUtil#mergeNodeLists(Node, NodeList, NodeList, String)}
   */
  @Test
  public void testMergeNodeLists8() {
    // Arrange
    IIOMetadataNode targetNode = new IIOMetadataNode("foo");
    HTMLAnchorElementImpl list1 = mock(HTMLAnchorElementImpl.class);
    IIOMetadataNode iioMetadataNode = new IIOMetadataNode("foo");
    when(list1.item(anyInt())).thenReturn(iioMetadataNode);
    when(list1.getLength()).thenReturn(3);
    HTMLAnchorElementImpl list2 = mock(HTMLAnchorElementImpl.class);
    when(list2.item(anyInt())).thenReturn(new IIOMetadataNode("#text"));
    when(list2.getLength()).thenReturn(3);

    // Act
    NodeUtil.mergeNodeLists(targetNode, list1, list2, "Attribute Name");

    // Assert
    verify(list1, atLeast(1)).getLength();
    verify(list2, atLeast(1)).getLength();
    verify(list2, atLeast(1)).item(anyInt());
    verify(list1, atLeast(1)).item(anyInt());
    assertEquals(3, targetNode.getLength());
    assertTrue(targetNode.hasChildNodes());
    assertSame(iioMetadataNode, targetNode.getFirstChild());
    assertSame(iioMetadataNode, targetNode.getLastChild());
  }

  /**
   * Method under test:
   * {@link NodeUtil.NodeComparatorBySingleAttribute#compare(Node, Node)}
   */
  @Test
  public void testNodeComparatorBySingleAttributeCompare() {
    // Arrange
    NodeUtil.NodeComparatorBySingleAttribute nodeComparatorBySingleAttribute = new NodeUtil.NodeComparatorBySingleAttribute(
        "Attribute Name");
    IIOMetadataNode o1 = new IIOMetadataNode("foo");

    // Act and Assert
    assertEquals(-1, nodeComparatorBySingleAttribute.compare(o1, new IIOMetadataNode("foo")));
  }

  /**
   * Method under test:
   * {@link NodeUtil.NodeComparatorBySingleAttribute#compare(Node, Node)}
   */
  @Test
  public void testNodeComparatorBySingleAttributeCompare2() {
    // Arrange
    NodeUtil.NodeComparatorBySingleAttribute nodeComparatorBySingleAttribute = new NodeUtil.NodeComparatorBySingleAttribute(
        "Attribute Name");
    IIOMetadataNode o1 = new IIOMetadataNode("mo:tab");

    // Act and Assert
    assertEquals(-1, nodeComparatorBySingleAttribute.compare(o1, new IIOMetadataNode("foo")));
  }

  /**
   * Method under test:
   * {@link NodeUtil.NodeComparatorBySingleAttribute#compare(Node, Node)}
   */
  @Test
  public void testNodeComparatorBySingleAttributeCompare3() {
    // Arrange
    NodeUtil.NodeComparatorBySingleAttribute nodeComparatorBySingleAttribute = new NodeUtil.NodeComparatorBySingleAttribute(
        "Attribute Name");
    IIOMetadataNode o1 = new IIOMetadataNode("mo:group");

    // Act and Assert
    assertEquals(-1, nodeComparatorBySingleAttribute.compare(o1, new IIOMetadataNode("foo")));
  }

  /**
   * Method under test:
   * {@link NodeUtil.NodeComparatorBySingleAttribute#compare(Node, Node)}
   */
  @Test
  public void testNodeComparatorBySingleAttributeCompare4() {
    // Arrange
    NodeUtil.NodeComparatorBySingleAttribute nodeComparatorBySingleAttribute = new NodeUtil.NodeComparatorBySingleAttribute(
        "Attribute Name");
    DefaultDocument o1 = new DefaultDocument();

    // Act and Assert
    assertEquals(1, nodeComparatorBySingleAttribute.compare(o1, new IIOMetadataNode("foo")));
  }

  /**
   * Method under test:
   * {@link NodeUtil.NodeComparatorBySingleAttribute#compare(Node, Node)}
   */
  @Test
  public void testNodeComparatorBySingleAttributeCompare5() {
    // Arrange
    NodeUtil.NodeComparatorBySingleAttribute nodeComparatorBySingleAttribute = new NodeUtil.NodeComparatorBySingleAttribute(
        "Attribute Name");
    IIOMetadataNode o1 = new IIOMetadataNode("foo");

    // Act and Assert
    assertEquals(1, nodeComparatorBySingleAttribute.compare(o1, new IIOMetadataNode("mo:tab")));
  }

  /**
   * Method under test:
   * {@link NodeUtil.NodeComparatorBySingleAttribute#compare(Node, Node)}
   */
  @Test
  public void testNodeComparatorBySingleAttributeCompare6() {
    // Arrange
    NodeUtil.NodeComparatorBySingleAttribute nodeComparatorBySingleAttribute = new NodeUtil.NodeComparatorBySingleAttribute(
        "Attribute Name");
    IIOMetadataNode o1 = new IIOMetadataNode("foo");

    // Act and Assert
    assertEquals(1, nodeComparatorBySingleAttribute.compare(o1, new IIOMetadataNode("mo:group")));
  }

  /**
   * Method under test:
   * {@link NodeUtil.NodeComparatorBySingleAttribute#compare(Node, Node)}
   */
  @Test
  public void testNodeComparatorBySingleAttributeCompare7() {
    // Arrange
    NodeUtil.NodeComparatorBySingleAttribute nodeComparatorBySingleAttribute = new NodeUtil.NodeComparatorBySingleAttribute(
        "Attribute Name");
    IIOMetadataNode o1 = new IIOMetadataNode("foo");

    // Act and Assert
    assertEquals(-1, nodeComparatorBySingleAttribute.compare(o1, new DefaultDocument()));
  }

  /**
   * Method under test:
   * {@link NodeUtil.NodeComparatorBySingleAttribute#compare(Node, Node)}
   */
  @Test
  public void testNodeComparatorBySingleAttributeCompare8() {
    // Arrange
    NodeUtil.NodeComparatorBySingleAttribute nodeComparatorBySingleAttribute = new NodeUtil.NodeComparatorBySingleAttribute(
        "Attribute Name");
    IIOMetadataNode o1 = new IIOMetadataNode("mo:tab");

    // Act and Assert
    assertEquals(-1, nodeComparatorBySingleAttribute.compare(o1, new IIOMetadataNode("mo:tab")));
  }

  /**
   * Method under test:
   * {@link NodeUtil.NodeComparatorBySingleAttribute#compare(Node, Node)}
   */
  @Test
  public void testNodeComparatorBySingleAttributeCompare9() {
    // Arrange
    NodeUtil.NodeComparatorBySingleAttribute nodeComparatorBySingleAttribute = new NodeUtil.NodeComparatorBySingleAttribute(
        "Attribute Name");
    IIOMetadataNode o1 = new IIOMetadataNode("mo:group");

    // Act and Assert
    assertEquals(-1, nodeComparatorBySingleAttribute.compare(o1, new IIOMetadataNode("mo:group")));
  }
}
