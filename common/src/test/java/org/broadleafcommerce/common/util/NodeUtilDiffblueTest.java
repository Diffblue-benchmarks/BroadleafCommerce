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
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import javax.imageio.metadata.IIOMetadataNode;
import org.apache.html.dom.HTMLAnchorElementImpl;
import org.apache.xerces.impl.xs.opti.DefaultDocument;
import org.apache.xerces.impl.xs.opti.DefaultElement;
import org.broadleafcommerce.common.util.NodeUtil.NodeComparatorBySingleAttribute;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class NodeUtilDiffblueTest {
  /**
   * Test {@link NodeUtil#filterByAttribute(Node[], String)}.
   *
   * <ul>
   *   <li>Then return array length is zero.
   * </ul>
   *
   * <p>Method under test: {@link NodeUtil#filterByAttribute(Node[], String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Node[] NodeUtil.filterByAttribute(Node[], String)"})
  public void testFilterByAttribute_thenReturnArrayLengthIsZero() {
    // Arrange, Act and Assert
    assertEquals(
        0, NodeUtil.filterByAttribute(new Node[] {new IIOMetadataNode()}, "Attribute Name").length);
  }

  /**
   * Test {@link NodeUtil#findNode(Node[], Node, String, boolean)}.
   *
   * <ul>
   *   <li>When array of {@link Node} with {@link IIOMetadataNode#IIOMetadataNode()}.
   *   <li>Then return minus two.
   * </ul>
   *
   * <p>Method under test: {@link NodeUtil#findNode(Node[], Node, String, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int NodeUtil.findNode(Node[], Node, String, boolean)"})
  public void testFindNode_whenArrayOfNodeWithIIOMetadataNode_thenReturnMinusTwo() {
    // Arrange and Act
    int actualFindNodeResult =
        NodeUtil.findNode(
            new Node[] {new IIOMetadataNode()}, new IIOMetadataNode(), "Attribute Name", true);

    // Assert
    assertEquals(-2, actualFindNodeResult);
  }

  /**
   * Test {@link NodeUtil#findNode(Node[], Node, String, boolean)}.
   *
   * <ul>
   *   <li>When {@code false}.
   *   <li>Then return minus two.
   * </ul>
   *
   * <p>Method under test: {@link NodeUtil#findNode(Node[], Node, String, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int NodeUtil.findNode(Node[], Node, String, boolean)"})
  public void testFindNode_whenFalse_thenReturnMinusTwo() {
    // Arrange and Act
    int actualFindNodeResult =
        NodeUtil.findNode(
            new Node[] {new IIOMetadataNode()}, new IIOMetadataNode(), "Attribute Name", false);

    // Assert
    assertEquals(-2, actualFindNodeResult);
  }

  /**
   * Test {@link NodeUtil#mergeNodeLists(Node, NodeList, NodeList, String)}.
   *
   * <ul>
   *   <li>Given {@link DefaultElement#DefaultElement(String, String, String, String, short)} with
   *       {@code #text} and {@code #text} and {@code #text} and {@code #text} and three.
   * </ul>
   *
   * <p>Method under test: {@link NodeUtil#mergeNodeLists(Node, NodeList, NodeList, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void NodeUtil.mergeNodeLists(Node, NodeList, NodeList, String)"})
  public void testMergeNodeLists_givenDefaultElementWithTextAndTextAndTextAndTextAndThree() {
    // Arrange
    IIOMetadataNode targetNode = new IIOMetadataNode();

    HTMLAnchorElementImpl list1 = mock(HTMLAnchorElementImpl.class);
    DefaultElement defaultElement =
        new DefaultElement("#text", "#text", "#text", "#text", (short) 3);
    when(list1.item(anyInt())).thenReturn(defaultElement);
    when(list1.getLength()).thenReturn(3);

    // Act
    NodeUtil.mergeNodeLists(targetNode, list1, new IIOMetadataNode(), "Attribute Name");

    // Assert that nothing has changed
    verify(list1, atLeast(1)).getLength();
    verify(list1, atLeast(1)).item(anyInt());
    assertEquals(0, targetNode.getLength());
    assertFalse(targetNode.hasChildNodes());
  }

  /**
   * Test {@link NodeUtil#mergeNodeLists(Node, NodeList, NodeList, String)}.
   *
   * <ul>
   *   <li>Given {@link IIOMetadataNode#IIOMetadataNode()}.
   *   <li>Then {@link IIOMetadataNode#IIOMetadataNode()} Length is three.
   * </ul>
   *
   * <p>Method under test: {@link NodeUtil#mergeNodeLists(Node, NodeList, NodeList, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void NodeUtil.mergeNodeLists(Node, NodeList, NodeList, String)"})
  public void testMergeNodeLists_givenIIOMetadataNode_thenIIOMetadataNodeLengthIsThree() {
    // Arrange
    IIOMetadataNode targetNode = new IIOMetadataNode();

    HTMLAnchorElementImpl list1 = mock(HTMLAnchorElementImpl.class);
    IIOMetadataNode iioMetadataNode = new IIOMetadataNode();
    when(list1.item(anyInt())).thenReturn(iioMetadataNode);
    when(list1.getLength()).thenReturn(3);

    // Act
    NodeUtil.mergeNodeLists(targetNode, list1, new IIOMetadataNode(), "Attribute Name");

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
   *
   * <ul>
   *   <li>Then {@link IIOMetadataNode#IIOMetadataNode()} FirstChild {@link IIOMetadataNode}.
   * </ul>
   *
   * <p>Method under test: {@link NodeUtil#mergeNodeLists(Node, NodeList, NodeList, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void NodeUtil.mergeNodeLists(Node, NodeList, NodeList, String)"})
  public void testMergeNodeLists_thenIIOMetadataNodeFirstChildIIOMetadataNode() {
    // Arrange
    IIOMetadataNode targetNode = new IIOMetadataNode();

    HTMLAnchorElementImpl list1 = mock(HTMLAnchorElementImpl.class);
    when(list1.item(anyInt())).thenReturn(new IIOMetadataNode());
    when(list1.getLength()).thenReturn(3);

    HTMLAnchorElementImpl list2 = mock(HTMLAnchorElementImpl.class);
    when(list2.item(anyInt())).thenReturn(new IIOMetadataNode());
    when(list2.getLength()).thenReturn(3);

    // Act
    NodeUtil.mergeNodeLists(targetNode, list1, list2, "Attribute Name");

    // Assert
    verify(list1, atLeast(1)).getLength();
    verify(list2, atLeast(1)).getLength();
    verify(list1, atLeast(1)).item(anyInt());
    verify(list2, atLeast(1)).item(anyInt());
    assertTrue(targetNode.getFirstChild() instanceof IIOMetadataNode);
    assertTrue(targetNode.getLastChild() instanceof IIOMetadataNode);
    assertEquals(6, targetNode.getLength());
  }

  /**
   * Test {@link NodeUtil#mergeNodeLists(Node, NodeList, NodeList, String)}.
   *
   * <ul>
   *   <li>Then {@link IIOMetadataNode#IIOMetadataNode()} Length is three.
   * </ul>
   *
   * <p>Method under test: {@link NodeUtil#mergeNodeLists(Node, NodeList, NodeList, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void NodeUtil.mergeNodeLists(Node, NodeList, NodeList, String)"})
  public void testMergeNodeLists_thenIIOMetadataNodeLengthIsThree() {
    // Arrange
    IIOMetadataNode targetNode = new IIOMetadataNode();

    HTMLAnchorElementImpl list1 = mock(HTMLAnchorElementImpl.class);
    IIOMetadataNode iioMetadataNode = new IIOMetadataNode();
    when(list1.item(anyInt())).thenReturn(iioMetadataNode);
    when(list1.getLength()).thenReturn(3);

    HTMLAnchorElementImpl list2 = mock(HTMLAnchorElementImpl.class);
    DefaultElement defaultElement =
        new DefaultElement("#text", "#text", "#text", "#text", (short) 3);
    when(list2.item(anyInt())).thenReturn(defaultElement);
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
   *
   * <ul>
   *   <li>When {@link IIOMetadataNode#IIOMetadataNode()}.
   *   <li>Then {@link IIOMetadataNode#IIOMetadataNode()} Length is zero.
   * </ul>
   *
   * <p>Method under test: {@link NodeUtil#mergeNodeLists(Node, NodeList, NodeList, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void NodeUtil.mergeNodeLists(Node, NodeList, NodeList, String)"})
  public void testMergeNodeLists_whenIIOMetadataNode_thenIIOMetadataNodeLengthIsZero() {
    // Arrange
    IIOMetadataNode targetNode = new IIOMetadataNode();
    IIOMetadataNode list1 = new IIOMetadataNode();

    // Act
    NodeUtil.mergeNodeLists(targetNode, list1, new IIOMetadataNode(), "Attribute Name");

    // Assert that nothing has changed
    assertEquals(0, targetNode.getLength());
    assertFalse(targetNode.hasChildNodes());
  }

  /**
   * Test {@link NodeUtil#mergeNodeLists(Node, NodeList, NodeList, String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link IIOMetadataNode#IIOMetadataNode()} Length is zero.
   * </ul>
   *
   * <p>Method under test: {@link NodeUtil#mergeNodeLists(Node, NodeList, NodeList, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void NodeUtil.mergeNodeLists(Node, NodeList, NodeList, String)"})
  public void testMergeNodeLists_whenNull_thenIIOMetadataNodeLengthIsZero() {
    // Arrange
    IIOMetadataNode targetNode = new IIOMetadataNode();

    // Act
    NodeUtil.mergeNodeLists(targetNode, null, null, "Attribute Name");

    // Assert that nothing has changed
    assertEquals(0, targetNode.getLength());
    assertFalse(targetNode.hasChildNodes());
  }

  /**
   * Test NodeComparatorBySingleAttribute {@link NodeComparatorBySingleAttribute#compare(Node,
   * Node)} with {@code Node}, {@code Node}.
   *
   * <p>Method under test: {@link NodeComparatorBySingleAttribute#compare(Node, Node)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int NodeComparatorBySingleAttribute.compare(Node, Node)"})
  public void testNodeComparatorBySingleAttributeCompareWithNodeNode() {
    // Arrange
    NodeComparatorBySingleAttribute nodeComparatorBySingleAttribute =
        new NodeComparatorBySingleAttribute("Attribute Name");
    IIOMetadataNode o1 = new IIOMetadataNode("mo:tab");

    // Act and Assert
    assertEquals(-1, nodeComparatorBySingleAttribute.compare(o1, new IIOMetadataNode("mo:tab")));
  }

  /**
   * Test NodeComparatorBySingleAttribute {@link NodeComparatorBySingleAttribute#compare(Node,
   * Node)} with {@code Node}, {@code Node}.
   *
   * <p>Method under test: {@link NodeComparatorBySingleAttribute#compare(Node, Node)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int NodeComparatorBySingleAttribute.compare(Node, Node)"})
  public void testNodeComparatorBySingleAttributeCompareWithNodeNode2() {
    // Arrange
    NodeComparatorBySingleAttribute nodeComparatorBySingleAttribute =
        new NodeComparatorBySingleAttribute("Attribute Name");
    IIOMetadataNode o1 = new IIOMetadataNode("mo:tab");

    // Act and Assert
    assertEquals(-1, nodeComparatorBySingleAttribute.compare(o1, new IIOMetadataNode("mo:group")));
  }

  /**
   * Test NodeComparatorBySingleAttribute {@link NodeComparatorBySingleAttribute#compare(Node,
   * Node)} with {@code Node}, {@code Node}.
   *
   * <p>Method under test: {@link NodeComparatorBySingleAttribute#compare(Node, Node)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int NodeComparatorBySingleAttribute.compare(Node, Node)"})
  public void testNodeComparatorBySingleAttributeCompareWithNodeNode3() {
    // Arrange
    NodeComparatorBySingleAttribute nodeComparatorBySingleAttribute =
        new NodeComparatorBySingleAttribute("Attribute Name");
    IIOMetadataNode o1 = new IIOMetadataNode("mo:group");

    // Act and Assert
    assertEquals(-1, nodeComparatorBySingleAttribute.compare(o1, new IIOMetadataNode("mo:group")));
  }

  /**
   * Test NodeComparatorBySingleAttribute {@link NodeComparatorBySingleAttribute#compare(Node,
   * Node)} with {@code Node}, {@code Node}.
   *
   * <p>Method under test: {@link NodeComparatorBySingleAttribute#compare(Node, Node)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int NodeComparatorBySingleAttribute.compare(Node, Node)"})
  public void testNodeComparatorBySingleAttributeCompareWithNodeNode4() {
    // Arrange
    NodeComparatorBySingleAttribute nodeComparatorBySingleAttribute =
        new NodeComparatorBySingleAttribute("Attribute Name");
    IIOMetadataNode o1 = new IIOMetadataNode("mo:group");

    // Act and Assert
    assertEquals(-1, nodeComparatorBySingleAttribute.compare(o1, new IIOMetadataNode()));
  }

  /**
   * Test NodeComparatorBySingleAttribute {@link NodeComparatorBySingleAttribute#compare(Node,
   * Node)} with {@code Node}, {@code Node}.
   *
   * <ul>
   *   <li>Then return minus one.
   * </ul>
   *
   * <p>Method under test: {@link NodeComparatorBySingleAttribute#compare(Node, Node)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int NodeComparatorBySingleAttribute.compare(Node, Node)"})
  public void testNodeComparatorBySingleAttributeCompareWithNodeNode_thenReturnMinusOne() {
    // Arrange
    NodeComparatorBySingleAttribute nodeComparatorBySingleAttribute =
        new NodeComparatorBySingleAttribute("Attribute Name");
    IIOMetadataNode o1 = new IIOMetadataNode();

    // Act and Assert
    assertEquals(-1, nodeComparatorBySingleAttribute.compare(o1, new IIOMetadataNode()));
  }

  /**
   * Test NodeComparatorBySingleAttribute {@link NodeComparatorBySingleAttribute#compare(Node,
   * Node)} with {@code Node}, {@code Node}.
   *
   * <ul>
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link NodeComparatorBySingleAttribute#compare(Node, Node)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int NodeComparatorBySingleAttribute.compare(Node, Node)"})
  public void testNodeComparatorBySingleAttributeCompareWithNodeNode_thenReturnOne() {
    // Arrange
    NodeComparatorBySingleAttribute nodeComparatorBySingleAttribute =
        new NodeComparatorBySingleAttribute("Attribute Name");
    IIOMetadataNode o1 = new IIOMetadataNode("mo:group");

    // Act and Assert
    assertEquals(1, nodeComparatorBySingleAttribute.compare(o1, new IIOMetadataNode("mo:tab")));
  }

  /**
   * Test NodeComparatorBySingleAttribute {@link NodeComparatorBySingleAttribute#compare(Node,
   * Node)} with {@code Node}, {@code Node}.
   *
   * <ul>
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link NodeComparatorBySingleAttribute#compare(Node, Node)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int NodeComparatorBySingleAttribute.compare(Node, Node)"})
  public void testNodeComparatorBySingleAttributeCompareWithNodeNode_thenReturnOne2() {
    // Arrange
    NodeComparatorBySingleAttribute nodeComparatorBySingleAttribute =
        new NodeComparatorBySingleAttribute("Attribute Name");
    IIOMetadataNode o1 = new IIOMetadataNode();

    // Act and Assert
    assertEquals(1, nodeComparatorBySingleAttribute.compare(o1, new IIOMetadataNode("mo:group")));
  }

  /**
   * Test NodeComparatorBySingleAttribute {@link NodeComparatorBySingleAttribute#compare(Node,
   * Node)} with {@code Node}, {@code Node}.
   *
   * <ul>
   *   <li>When {@link DefaultDocument} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link NodeComparatorBySingleAttribute#compare(Node, Node)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int NodeComparatorBySingleAttribute.compare(Node, Node)"})
  public void testNodeComparatorBySingleAttributeCompareWithNodeNode_whenDefaultDocument() {
    // Arrange
    NodeComparatorBySingleAttribute nodeComparatorBySingleAttribute =
        new NodeComparatorBySingleAttribute("Attribute Name");
    DefaultDocument o1 = new DefaultDocument();

    // Act and Assert
    assertEquals(1, nodeComparatorBySingleAttribute.compare(o1, new IIOMetadataNode()));
  }

  /**
   * Test NodeComparatorBySingleAttribute {@link NodeComparatorBySingleAttribute#compare(Node,
   * Node)} with {@code Node}, {@code Node}.
   *
   * <ul>
   *   <li>When {@link DefaultDocument} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link NodeComparatorBySingleAttribute#compare(Node, Node)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int NodeComparatorBySingleAttribute.compare(Node, Node)"})
  public void testNodeComparatorBySingleAttributeCompareWithNodeNode_whenDefaultDocument2() {
    // Arrange
    NodeComparatorBySingleAttribute nodeComparatorBySingleAttribute =
        new NodeComparatorBySingleAttribute("Attribute Name");
    IIOMetadataNode o1 = new IIOMetadataNode();

    // Act and Assert
    assertEquals(-1, nodeComparatorBySingleAttribute.compare(o1, new DefaultDocument()));
  }
}
