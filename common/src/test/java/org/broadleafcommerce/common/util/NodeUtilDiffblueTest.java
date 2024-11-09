/*-
 * #%L
 * BroadleafCommerce Common Libraries
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
import org.broadleafcommerce.common.util.NodeUtil.NodeComparatorBySingleAttribute;
import org.dom4j.dom.DOMAttributeNodeMap;
import org.dom4j.dom.DOMElement;
import org.junit.Test;
import org.mockito.Mockito;
import org.w3c.dom.DOMException;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class NodeUtilDiffblueTest {
  /**
   * Test {@link NodeUtil#filterByAttribute(Node[], String)}.
   * <ul>
   *   <li>Given {@link DOMElement#DOMElement(String)} with {@code Name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link NodeUtil#filterByAttribute(Node[], String)}
   */
  @Test
  public void testFilterByAttribute_givenDOMElementWithName() {
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
   * Test {@link NodeUtil#filterByAttribute(Node[], String)}.
   * <ul>
   *   <li>Then return array length is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link NodeUtil#filterByAttribute(Node[], String)}
   */
  @Test
  public void testFilterByAttribute_thenReturnArrayLengthIsOne() {
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
   * Test {@link NodeUtil#filterByAttribute(Node[], String)}.
   * <ul>
   *   <li>When array of {@link Node} with
   * {@link IIOMetadataNode#IIOMetadataNode(String)} with {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link NodeUtil#filterByAttribute(Node[], String)}
   */
  @Test
  public void testFilterByAttribute_whenArrayOfNodeWithIIOMetadataNodeWithFoo() {
    // Arrange, Act and Assert
    assertEquals(0, NodeUtil.filterByAttribute(new Node[]{new IIOMetadataNode("foo")}, "Attribute Name").length);
  }

  /**
   * Test {@link NodeUtil#findNode(Node[], Node, String, boolean)}.
   * <ul>
   *   <li>Given {@code Node Name}.</li>
   *   <li>Then calls {@link DefaultDocument#getNodeName()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link NodeUtil#findNode(Node[], Node, String, boolean)}
   */
  @Test
  public void testFindNode_givenNodeName_thenCallsGetNodeName() {
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
   * Test {@link NodeUtil#findNode(Node[], Node, String, boolean)}.
   * <ul>
   *   <li>Given {@code Node Name}.</li>
   *   <li>When {@code false}.</li>
   *   <li>Then calls {@link DefaultDocument#getNodeName()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link NodeUtil#findNode(Node[], Node, String, boolean)}
   */
  @Test
  public void testFindNode_givenNodeName_whenFalse_thenCallsGetNodeName() {
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
   * Test {@link NodeUtil#findNode(Node[], Node, String, boolean)}.
   * <ul>
   *   <li>When array of {@link Node} with
   * {@link IIOMetadataNode#IIOMetadataNode(String)} with {@code foo}.</li>
   *   <li>Then return minus two.</li>
   * </ul>
   * <p>
   * Method under test: {@link NodeUtil#findNode(Node[], Node, String, boolean)}
   */
  @Test
  public void testFindNode_whenArrayOfNodeWithIIOMetadataNodeWithFoo_thenReturnMinusTwo() {
    // Arrange, Act and Assert
    assertEquals(-2,
        NodeUtil.findNode(new Node[]{new IIOMetadataNode("foo")}, new IIOMetadataNode("foo"), "Attribute Name", true));
  }

  /**
   * Test {@link NodeUtil#mergeNodeLists(Node, NodeList, NodeList, String)}.
   * <ul>
   *   <li>Given {@link IIOMetadataNode#IIOMetadataNode(String)} with
   * {@code #text}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link NodeUtil#mergeNodeLists(Node, NodeList, NodeList, String)}
   */
  @Test
  public void testMergeNodeLists_givenIIOMetadataNodeWithText() {
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
   * Test {@link NodeUtil#mergeNodeLists(Node, NodeList, NodeList, String)}.
   * <ul>
   *   <li>Given {@link IIOMetadataNode#IIOMetadataNode(String)} with
   * {@code #text}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link NodeUtil#mergeNodeLists(Node, NodeList, NodeList, String)}
   */
  @Test
  public void testMergeNodeLists_givenIIOMetadataNodeWithText2() {
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
   * Test {@link NodeUtil#mergeNodeLists(Node, NodeList, NodeList, String)}.
   * <ul>
   *   <li>Then {@link IIOMetadataNode#IIOMetadataNode(String)} with {@code foo}
   * FirstChild {@link IIOMetadataNode}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link NodeUtil#mergeNodeLists(Node, NodeList, NodeList, String)}
   */
  @Test
  public void testMergeNodeLists_thenIIOMetadataNodeWithFooFirstChildIIOMetadataNode() throws DOMException {
    // Arrange
    IIOMetadataNode targetNode = new IIOMetadataNode("foo");
    HTMLAnchorElementImpl list1 = mock(HTMLAnchorElementImpl.class);
    IIOMetadataNode iioMetadataNode = new IIOMetadataNode("foo");
    when(list1.item(anyInt())).thenReturn(iioMetadataNode);
    when(list1.getLength()).thenReturn(3);
    HTMLAnchorElementImpl list2 = mock(HTMLAnchorElementImpl.class);
    when(list2.item(anyInt())).thenReturn(new IIOMetadataNode("foo"));
    when(list2.getLength()).thenReturn(3);

    // Act
    NodeUtil.mergeNodeLists(targetNode, list1, list2, "Attribute Name");

    // Assert
    verify(list1, atLeast(1)).getLength();
    verify(list2, atLeast(1)).getLength();
    verify(list1, atLeast(1)).item(anyInt());
    verify(list2, atLeast(1)).item(anyInt());
    Node firstChild = targetNode.getFirstChild();
    assertTrue(firstChild instanceof IIOMetadataNode);
    Node lastChild = targetNode.getLastChild();
    assertTrue(lastChild instanceof IIOMetadataNode);
    assertEquals("foo", ((IIOMetadataNode) lastChild).getTagName());
    assertEquals("foo", lastChild.getLocalName());
    assertEquals("foo", lastChild.getNodeName());
    assertNull(((IIOMetadataNode) lastChild).getUserObject());
    assertNull(lastChild.getNamespaceURI());
    assertNull(lastChild.getNodeValue());
    assertNull(lastChild.getPrefix());
    assertNull(lastChild.getOwnerDocument());
    assertNull(lastChild.getFirstChild());
    assertNull(lastChild.getLastChild());
    assertNull(lastChild.getNextSibling());
    assertEquals(0, ((IIOMetadataNode) lastChild).getLength());
    assertEquals((short) 1, lastChild.getNodeType());
    assertEquals(6, targetNode.getLength());
    assertFalse(lastChild.hasAttributes());
    assertFalse(lastChild.hasChildNodes());
    assertSame(iioMetadataNode, firstChild.getNextSibling());
    assertSame(targetNode, lastChild.getParentNode());
    assertSame(iioMetadataNode, lastChild.getPreviousSibling());
  }

  /**
   * Test {@link NodeUtil#mergeNodeLists(Node, NodeList, NodeList, String)}.
   * <ul>
   *   <li>Then {@link IIOMetadataNode#IIOMetadataNode(String)} with {@code foo}
   * FirstChild is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link NodeUtil#mergeNodeLists(Node, NodeList, NodeList, String)}
   */
  @Test
  public void testMergeNodeLists_thenIIOMetadataNodeWithFooFirstChildIsNull() {
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
   * Test {@link NodeUtil#mergeNodeLists(Node, NodeList, NodeList, String)}.
   * <ul>
   *   <li>Then {@link IIOMetadataNode#IIOMetadataNode(String)} with {@code foo}
   * Length is three.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link NodeUtil#mergeNodeLists(Node, NodeList, NodeList, String)}
   */
  @Test
  public void testMergeNodeLists_thenIIOMetadataNodeWithFooLengthIsThree() {
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
   * Test {@link NodeUtil#mergeNodeLists(Node, NodeList, NodeList, String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link IIOMetadataNode#IIOMetadataNode(String)} with {@code foo}
   * FirstChild is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link NodeUtil#mergeNodeLists(Node, NodeList, NodeList, String)}
   */
  @Test
  public void testMergeNodeLists_whenNull_thenIIOMetadataNodeWithFooFirstChildIsNull() {
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
   * Test {@link NodeUtil#mergeNodeLists(Node, NodeList, NodeList, String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link IIOMetadataNode#IIOMetadataNode(String)} with {@code foo}
   * Length is three.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link NodeUtil#mergeNodeLists(Node, NodeList, NodeList, String)}
   */
  @Test
  public void testMergeNodeLists_whenNull_thenIIOMetadataNodeWithFooLengthIsThree() {
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
   * Test NodeComparatorBySingleAttribute
   * {@link NodeComparatorBySingleAttribute#compare(Node, Node)} with
   * {@code Node}, {@code Node}.
   * <p>
   * Method under test:
   * {@link NodeUtil.NodeComparatorBySingleAttribute#compare(Node, Node)}
   */
  @Test
  public void testNodeComparatorBySingleAttributeCompareWithNodeNode() {
    // Arrange
    NodeUtil.NodeComparatorBySingleAttribute nodeComparatorBySingleAttribute = new NodeUtil.NodeComparatorBySingleAttribute(
        "Attribute Name");
    IIOMetadataNode o1 = new IIOMetadataNode("mo:tab");

    // Act and Assert
    assertEquals(-1, nodeComparatorBySingleAttribute.compare(o1, new IIOMetadataNode("foo")));
  }

  /**
   * Test NodeComparatorBySingleAttribute
   * {@link NodeComparatorBySingleAttribute#compare(Node, Node)} with
   * {@code Node}, {@code Node}.
   * <p>
   * Method under test:
   * {@link NodeUtil.NodeComparatorBySingleAttribute#compare(Node, Node)}
   */
  @Test
  public void testNodeComparatorBySingleAttributeCompareWithNodeNode2() {
    // Arrange
    NodeUtil.NodeComparatorBySingleAttribute nodeComparatorBySingleAttribute = new NodeUtil.NodeComparatorBySingleAttribute(
        "Attribute Name");
    IIOMetadataNode o1 = new IIOMetadataNode("mo:group");

    // Act and Assert
    assertEquals(-1, nodeComparatorBySingleAttribute.compare(o1, new IIOMetadataNode("foo")));
  }

  /**
   * Test NodeComparatorBySingleAttribute
   * {@link NodeComparatorBySingleAttribute#compare(Node, Node)} with
   * {@code Node}, {@code Node}.
   * <p>
   * Method under test:
   * {@link NodeUtil.NodeComparatorBySingleAttribute#compare(Node, Node)}
   */
  @Test
  public void testNodeComparatorBySingleAttributeCompareWithNodeNode3() {
    // Arrange
    NodeUtil.NodeComparatorBySingleAttribute nodeComparatorBySingleAttribute = new NodeUtil.NodeComparatorBySingleAttribute(
        "Attribute Name");
    IIOMetadataNode o1 = new IIOMetadataNode("mo:tab");

    // Act and Assert
    assertEquals(-1, nodeComparatorBySingleAttribute.compare(o1, new IIOMetadataNode("mo:tab")));
  }

  /**
   * Test NodeComparatorBySingleAttribute
   * {@link NodeComparatorBySingleAttribute#compare(Node, Node)} with
   * {@code Node}, {@code Node}.
   * <p>
   * Method under test:
   * {@link NodeUtil.NodeComparatorBySingleAttribute#compare(Node, Node)}
   */
  @Test
  public void testNodeComparatorBySingleAttributeCompareWithNodeNode4() {
    // Arrange
    NodeUtil.NodeComparatorBySingleAttribute nodeComparatorBySingleAttribute = new NodeUtil.NodeComparatorBySingleAttribute(
        "Attribute Name");
    IIOMetadataNode o1 = new IIOMetadataNode("mo:group");

    // Act and Assert
    assertEquals(-1, nodeComparatorBySingleAttribute.compare(o1, new IIOMetadataNode("mo:group")));
  }

  /**
   * Test NodeComparatorBySingleAttribute
   * {@link NodeComparatorBySingleAttribute#compare(Node, Node)} with
   * {@code Node}, {@code Node}.
   * <ul>
   *   <li>Then return minus one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link NodeUtil.NodeComparatorBySingleAttribute#compare(Node, Node)}
   */
  @Test
  public void testNodeComparatorBySingleAttributeCompareWithNodeNode_thenReturnMinusOne() {
    // Arrange
    NodeUtil.NodeComparatorBySingleAttribute nodeComparatorBySingleAttribute = new NodeUtil.NodeComparatorBySingleAttribute(
        "Attribute Name");
    IIOMetadataNode o1 = new IIOMetadataNode("foo");

    // Act and Assert
    assertEquals(-1, nodeComparatorBySingleAttribute.compare(o1, new IIOMetadataNode("foo")));
  }

  /**
   * Test NodeComparatorBySingleAttribute
   * {@link NodeComparatorBySingleAttribute#compare(Node, Node)} with
   * {@code Node}, {@code Node}.
   * <ul>
   *   <li>Then return one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link NodeUtil.NodeComparatorBySingleAttribute#compare(Node, Node)}
   */
  @Test
  public void testNodeComparatorBySingleAttributeCompareWithNodeNode_thenReturnOne() {
    // Arrange
    NodeUtil.NodeComparatorBySingleAttribute nodeComparatorBySingleAttribute = new NodeUtil.NodeComparatorBySingleAttribute(
        "Attribute Name");
    IIOMetadataNode o1 = new IIOMetadataNode("foo");

    // Act and Assert
    assertEquals(1, nodeComparatorBySingleAttribute.compare(o1, new IIOMetadataNode("mo:tab")));
  }

  /**
   * Test NodeComparatorBySingleAttribute
   * {@link NodeComparatorBySingleAttribute#compare(Node, Node)} with
   * {@code Node}, {@code Node}.
   * <ul>
   *   <li>Then return one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link NodeUtil.NodeComparatorBySingleAttribute#compare(Node, Node)}
   */
  @Test
  public void testNodeComparatorBySingleAttributeCompareWithNodeNode_thenReturnOne2() {
    // Arrange
    NodeUtil.NodeComparatorBySingleAttribute nodeComparatorBySingleAttribute = new NodeUtil.NodeComparatorBySingleAttribute(
        "Attribute Name");
    IIOMetadataNode o1 = new IIOMetadataNode("foo");

    // Act and Assert
    assertEquals(1, nodeComparatorBySingleAttribute.compare(o1, new IIOMetadataNode("mo:group")));
  }

  /**
   * Test NodeComparatorBySingleAttribute
   * {@link NodeComparatorBySingleAttribute#compare(Node, Node)} with
   * {@code Node}, {@code Node}.
   * <ul>
   *   <li>When {@link DefaultDocument} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link NodeUtil.NodeComparatorBySingleAttribute#compare(Node, Node)}
   */
  @Test
  public void testNodeComparatorBySingleAttributeCompareWithNodeNode_whenDefaultDocument() {
    // Arrange
    NodeUtil.NodeComparatorBySingleAttribute nodeComparatorBySingleAttribute = new NodeUtil.NodeComparatorBySingleAttribute(
        "Attribute Name");
    DefaultDocument o1 = new DefaultDocument();

    // Act and Assert
    assertEquals(1, nodeComparatorBySingleAttribute.compare(o1, new IIOMetadataNode("foo")));
  }

  /**
   * Test NodeComparatorBySingleAttribute
   * {@link NodeComparatorBySingleAttribute#compare(Node, Node)} with
   * {@code Node}, {@code Node}.
   * <ul>
   *   <li>When {@link DefaultDocument} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link NodeUtil.NodeComparatorBySingleAttribute#compare(Node, Node)}
   */
  @Test
  public void testNodeComparatorBySingleAttributeCompareWithNodeNode_whenDefaultDocument2() {
    // Arrange
    NodeUtil.NodeComparatorBySingleAttribute nodeComparatorBySingleAttribute = new NodeUtil.NodeComparatorBySingleAttribute(
        "Attribute Name");
    IIOMetadataNode o1 = new IIOMetadataNode("foo");

    // Act and Assert
    assertEquals(-1, nodeComparatorBySingleAttribute.compare(o1, new DefaultDocument()));
  }
}
