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
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.imageio.metadata.IIOMetadataNode;
import org.apache.xerces.dom.AttrNSImpl;
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

@ContextConfiguration(classes = {NodeValueMerge.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class NodeValueMergeDiffblueTest {
  @Autowired
  private NodeValueMerge nodeValueMerge;

  /**
   * Test {@link NodeValueMerge#merge(List, List, List)}.
   * <ul>
   *   <li>Given {@link DummyNode} {@link DummyNode#getNodeValue()} return {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link NodeValueMerge#merge(List, List, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Node[] NodeValueMerge.merge(List, List, List)"})
  public void testMerge_givenDummyNodeGetNodeValueReturnFoo() throws DOMException {
    // Arrange
    DummyNode dummyNode = mock(DummyNode.class);
    doNothing().when(dummyNode).setNodeValue(Mockito.<String>any());
    when(dummyNode.getNodeValue()).thenReturn("foo");

    ArrayList<Node> nodeList1 = new ArrayList<>();
    nodeList1.add(dummyNode);
    DummyNode dummyNode2 = mock(DummyNode.class);
    doNothing().when(dummyNode2).setNodeValue(Mockito.<String>any());
    when(dummyNode2.getNodeValue()).thenReturn("42");

    ArrayList<Node> nodeList2 = new ArrayList<>();
    nodeList2.add(dummyNode2);
    IIOMetadataNode iioMetadataNode = new IIOMetadataNode("foo");
    nodeList2.add(iioMetadataNode);
    IIOMetadataNode iioMetadataNode2 = new IIOMetadataNode("foo");
    nodeList2.add(iioMetadataNode2);
    IIOMetadataNode iioMetadataNode3 = new IIOMetadataNode("foo");
    nodeList2.add(iioMetadataNode3);
    IIOMetadataNode iioMetadataNode4 = new IIOMetadataNode("foo");
    nodeList2.add(iioMetadataNode4);
    IIOMetadataNode iioMetadataNode5 = new IIOMetadataNode("foo");
    nodeList2.add(iioMetadataNode5);
    IIOMetadataNode iioMetadataNode6 = new IIOMetadataNode("foo");
    nodeList2.add(iioMetadataNode6);
    IIOMetadataNode iioMetadataNode7 = new IIOMetadataNode("foo");
    nodeList2.add(iioMetadataNode7);
    IIOMetadataNode iioMetadataNode8 = new IIOMetadataNode("foo");
    nodeList2.add(iioMetadataNode8);
    IIOMetadataNode iioMetadataNode9 = new IIOMetadataNode("foo");
    nodeList2.add(iioMetadataNode9);
    IIOMetadataNode iioMetadataNode10 = new IIOMetadataNode("foo");
    nodeList2.add(iioMetadataNode10);
    IIOMetadataNode iioMetadataNode11 = new IIOMetadataNode("foo");
    nodeList2.add(iioMetadataNode11);
    IIOMetadataNode iioMetadataNode12 = new IIOMetadataNode("foo");
    nodeList2.add(iioMetadataNode12);
    IIOMetadataNode iioMetadataNode13 = new IIOMetadataNode("foo");
    nodeList2.add(iioMetadataNode13);
    IIOMetadataNode iioMetadataNode14 = new IIOMetadataNode("foo");
    nodeList2.add(iioMetadataNode14);
    IIOMetadataNode iioMetadataNode15 = new IIOMetadataNode("foo");
    nodeList2.add(iioMetadataNode15);
    IIOMetadataNode iioMetadataNode16 = new IIOMetadataNode("foo");
    nodeList2.add(iioMetadataNode16);
    IIOMetadataNode iioMetadataNode17 = new IIOMetadataNode("foo");
    nodeList2.add(iioMetadataNode17);

    // Act
    Node[] actualMergeResult = nodeValueMerge.merge(nodeList1, nodeList2, new ArrayList<>());

    // Assert
    verify(dummyNode).getNodeValue();
    verify(dummyNode2).getNodeValue();
    verify(dummyNode).setNodeValue(eq("foo 42"));
    verify(dummyNode2).setNodeValue(eq("foo 42"));
    Node node = actualMergeResult[1];
    assertTrue(node instanceof IIOMetadataNode);
    Node node2 = actualMergeResult[10];
    assertTrue(node2 instanceof IIOMetadataNode);
    Node node3 = actualMergeResult[11];
    assertTrue(node3 instanceof IIOMetadataNode);
    Node node4 = actualMergeResult[12];
    assertTrue(node4 instanceof IIOMetadataNode);
    Node node5 = actualMergeResult[13];
    assertTrue(node5 instanceof IIOMetadataNode);
    Node node6 = actualMergeResult[14];
    assertTrue(node6 instanceof IIOMetadataNode);
    Node node7 = actualMergeResult[15];
    assertTrue(node7 instanceof IIOMetadataNode);
    Node node8 = actualMergeResult[17];
    assertTrue(node8 instanceof IIOMetadataNode);
    Node node9 = actualMergeResult[2];
    assertTrue(node9 instanceof IIOMetadataNode);
    Node node10 = actualMergeResult[3];
    assertTrue(node10 instanceof IIOMetadataNode);
    Node node11 = actualMergeResult[4];
    assertTrue(node11 instanceof IIOMetadataNode);
    Node node12 = actualMergeResult[5];
    assertTrue(node12 instanceof IIOMetadataNode);
    Node node13 = actualMergeResult[6];
    assertTrue(node13 instanceof IIOMetadataNode);
    Node node14 = actualMergeResult[7];
    assertTrue(node14 instanceof IIOMetadataNode);
    Node node15 = actualMergeResult[8];
    assertTrue(node15 instanceof IIOMetadataNode);
    Node node16 = actualMergeResult[9];
    assertTrue(node16 instanceof IIOMetadataNode);
    Node node17 = actualMergeResult[Short.SIZE];
    assertTrue(node17 instanceof IIOMetadataNode);
    assertEquals(18, actualMergeResult.length);
    assertSame(iioMetadataNode, node);
    assertSame(iioMetadataNode10, node2);
    assertSame(iioMetadataNode11, node3);
    assertSame(iioMetadataNode12, node4);
    assertSame(iioMetadataNode13, node5);
    assertSame(iioMetadataNode14, node6);
    assertSame(iioMetadataNode15, node7);
    assertSame(iioMetadataNode17, node8);
    assertSame(iioMetadataNode2, node9);
    assertSame(iioMetadataNode3, node10);
    assertSame(iioMetadataNode4, node11);
    assertSame(iioMetadataNode5, node12);
    assertSame(iioMetadataNode6, node13);
    assertSame(iioMetadataNode7, node14);
    assertSame(iioMetadataNode8, node15);
    assertSame(iioMetadataNode9, node16);
    assertSame(iioMetadataNode16, node17);
  }

  /**
   * Test {@link NodeValueMerge#merge(List, List, List)}.
   * <ul>
   *   <li>Given {@link IIOMetadataNode#IIOMetadataNode(String)} with {@code foo}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link NodeValueMerge#merge(List, List, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Node[] NodeValueMerge.merge(List, List, List)"})
  public void testMerge_givenIIOMetadataNodeWithFoo_thenReturnNull() {
    // Arrange
    ArrayList<Node> nodeList1 = new ArrayList<>();

    ArrayList<Node> nodeList2 = new ArrayList<>();
    nodeList2.add(new IIOMetadataNode("foo"));

    // Act and Assert
    assertNull(nodeValueMerge.merge(nodeList1, nodeList2, new ArrayList<>()));
  }

  /**
   * Test {@link NodeValueMerge#merge(List, List, List)}.
   * <ul>
   *   <li>Given {@link IIOMetadataNode#IIOMetadataNode(String)} with {@code foo}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link NodeValueMerge#merge(List, List, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Node[] NodeValueMerge.merge(List, List, List)"})
  public void testMerge_givenIIOMetadataNodeWithFoo_thenReturnNull2() {
    // Arrange
    ArrayList<Node> nodeList1 = new ArrayList<>();

    ArrayList<Node> nodeList2 = new ArrayList<>();
    nodeList2.add(new IIOMetadataNode("foo"));
    nodeList2.add(new IIOMetadataNode("foo"));

    // Act and Assert
    assertNull(nodeValueMerge.merge(nodeList1, nodeList2, new ArrayList<>()));
  }

  /**
   * Test {@link NodeValueMerge#merge(List, List, List)}.
   * <ul>
   *   <li>Given {@link IIOMetadataNode#IIOMetadataNode(String)} with {@code foo}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link NodeValueMerge#merge(List, List, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Node[] NodeValueMerge.merge(List, List, List)"})
  public void testMerge_givenIIOMetadataNodeWithFoo_thenReturnNull3() {
    // Arrange
    ArrayList<Node> nodeList1 = new ArrayList<>();
    ArrayList<Node> nodeList2 = new ArrayList<>();

    ArrayList<Node> exhaustedNodes = new ArrayList<>();
    exhaustedNodes.add(new IIOMetadataNode("foo"));

    // Act and Assert
    assertNull(nodeValueMerge.merge(nodeList1, nodeList2, exhaustedNodes));
  }

  /**
   * Test {@link NodeValueMerge#merge(List, List, List)}.
   * <ul>
   *   <li>Given {@link IIOMetadataNode#IIOMetadataNode(String)} with {@code foo}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link NodeValueMerge#merge(List, List, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Node[] NodeValueMerge.merge(List, List, List)"})
  public void testMerge_givenIIOMetadataNodeWithFoo_thenReturnNull4() {
    // Arrange
    ArrayList<Node> nodeList1 = new ArrayList<>();
    ArrayList<Node> nodeList2 = new ArrayList<>();

    ArrayList<Node> exhaustedNodes = new ArrayList<>();
    exhaustedNodes.add(new IIOMetadataNode("foo"));
    exhaustedNodes.add(new IIOMetadataNode("foo"));

    // Act and Assert
    assertNull(nodeValueMerge.merge(nodeList1, nodeList2, exhaustedNodes));
  }

  /**
   * Test {@link NodeValueMerge#merge(List, List, List)}.
   * <ul>
   *   <li>Given {@link IIOMetadataNode#IIOMetadataNode(String)} with {@code foo}.</li>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link NodeValueMerge#merge(List, List, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Node[] NodeValueMerge.merge(List, List, List)"})
  public void testMerge_givenIIOMetadataNodeWithFoo_whenNull_thenReturnNull() {
    // Arrange
    ArrayList<Node> nodeList1 = new ArrayList<>();
    nodeList1.add(new IIOMetadataNode("foo"));

    // Act and Assert
    assertNull(nodeValueMerge.merge(nodeList1, null, new ArrayList<>()));
  }

  /**
   * Test {@link NodeValueMerge#merge(List, List, List)}.
   * <ul>
   *   <li>Then second element return {@link IIOMetadataNode}.</li>
   * </ul>
   * <p>
   * Method under test: {@link NodeValueMerge#merge(List, List, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Node[] NodeValueMerge.merge(List, List, List)"})
  public void testMerge_thenSecondElementReturnIIOMetadataNode() throws DOMException {
    // Arrange
    DummyNode dummyNode = mock(DummyNode.class);
    doNothing().when(dummyNode).setNodeValue(Mockito.<String>any());
    when(dummyNode.getNodeValue()).thenReturn("42");

    ArrayList<Node> nodeList1 = new ArrayList<>();
    nodeList1.add(dummyNode);
    DummyNode dummyNode2 = mock(DummyNode.class);
    doNothing().when(dummyNode2).setNodeValue(Mockito.<String>any());
    when(dummyNode2.getNodeValue()).thenReturn("42");

    ArrayList<Node> nodeList2 = new ArrayList<>();
    nodeList2.add(dummyNode2);
    IIOMetadataNode iioMetadataNode = new IIOMetadataNode("foo");
    nodeList2.add(iioMetadataNode);
    IIOMetadataNode iioMetadataNode2 = new IIOMetadataNode("foo");
    nodeList2.add(iioMetadataNode2);
    IIOMetadataNode iioMetadataNode3 = new IIOMetadataNode("foo");
    nodeList2.add(iioMetadataNode3);
    IIOMetadataNode iioMetadataNode4 = new IIOMetadataNode("foo");
    nodeList2.add(iioMetadataNode4);
    IIOMetadataNode iioMetadataNode5 = new IIOMetadataNode("foo");
    nodeList2.add(iioMetadataNode5);
    IIOMetadataNode iioMetadataNode6 = new IIOMetadataNode("foo");
    nodeList2.add(iioMetadataNode6);
    IIOMetadataNode iioMetadataNode7 = new IIOMetadataNode("foo");
    nodeList2.add(iioMetadataNode7);
    IIOMetadataNode iioMetadataNode8 = new IIOMetadataNode("foo");
    nodeList2.add(iioMetadataNode8);
    IIOMetadataNode iioMetadataNode9 = new IIOMetadataNode("foo");
    nodeList2.add(iioMetadataNode9);
    IIOMetadataNode iioMetadataNode10 = new IIOMetadataNode("foo");
    nodeList2.add(iioMetadataNode10);
    IIOMetadataNode iioMetadataNode11 = new IIOMetadataNode("foo");
    nodeList2.add(iioMetadataNode11);
    IIOMetadataNode iioMetadataNode12 = new IIOMetadataNode("foo");
    nodeList2.add(iioMetadataNode12);
    IIOMetadataNode iioMetadataNode13 = new IIOMetadataNode("foo");
    nodeList2.add(iioMetadataNode13);
    IIOMetadataNode iioMetadataNode14 = new IIOMetadataNode("foo");
    nodeList2.add(iioMetadataNode14);
    IIOMetadataNode iioMetadataNode15 = new IIOMetadataNode("foo");
    nodeList2.add(iioMetadataNode15);
    IIOMetadataNode iioMetadataNode16 = new IIOMetadataNode("foo");
    nodeList2.add(iioMetadataNode16);
    IIOMetadataNode iioMetadataNode17 = new IIOMetadataNode("foo");
    nodeList2.add(iioMetadataNode17);

    // Act
    Node[] actualMergeResult = nodeValueMerge.merge(nodeList1, nodeList2, new ArrayList<>());

    // Assert
    verify(dummyNode).getNodeValue();
    verify(dummyNode2).getNodeValue();
    verify(dummyNode).setNodeValue(eq("42"));
    verify(dummyNode2).setNodeValue(eq("42"));
    Node node = actualMergeResult[1];
    assertTrue(node instanceof IIOMetadataNode);
    Node node2 = actualMergeResult[10];
    assertTrue(node2 instanceof IIOMetadataNode);
    Node node3 = actualMergeResult[11];
    assertTrue(node3 instanceof IIOMetadataNode);
    Node node4 = actualMergeResult[12];
    assertTrue(node4 instanceof IIOMetadataNode);
    Node node5 = actualMergeResult[13];
    assertTrue(node5 instanceof IIOMetadataNode);
    Node node6 = actualMergeResult[14];
    assertTrue(node6 instanceof IIOMetadataNode);
    Node node7 = actualMergeResult[15];
    assertTrue(node7 instanceof IIOMetadataNode);
    Node node8 = actualMergeResult[17];
    assertTrue(node8 instanceof IIOMetadataNode);
    Node node9 = actualMergeResult[2];
    assertTrue(node9 instanceof IIOMetadataNode);
    Node node10 = actualMergeResult[3];
    assertTrue(node10 instanceof IIOMetadataNode);
    Node node11 = actualMergeResult[4];
    assertTrue(node11 instanceof IIOMetadataNode);
    Node node12 = actualMergeResult[5];
    assertTrue(node12 instanceof IIOMetadataNode);
    Node node13 = actualMergeResult[6];
    assertTrue(node13 instanceof IIOMetadataNode);
    Node node14 = actualMergeResult[7];
    assertTrue(node14 instanceof IIOMetadataNode);
    Node node15 = actualMergeResult[8];
    assertTrue(node15 instanceof IIOMetadataNode);
    Node node16 = actualMergeResult[9];
    assertTrue(node16 instanceof IIOMetadataNode);
    Node node17 = actualMergeResult[Short.SIZE];
    assertTrue(node17 instanceof IIOMetadataNode);
    assertEquals(18, actualMergeResult.length);
    assertSame(iioMetadataNode, node);
    assertSame(iioMetadataNode10, node2);
    assertSame(iioMetadataNode11, node3);
    assertSame(iioMetadataNode12, node4);
    assertSame(iioMetadataNode13, node5);
    assertSame(iioMetadataNode14, node6);
    assertSame(iioMetadataNode15, node7);
    assertSame(iioMetadataNode17, node8);
    assertSame(iioMetadataNode2, node9);
    assertSame(iioMetadataNode3, node10);
    assertSame(iioMetadataNode4, node11);
    assertSame(iioMetadataNode5, node12);
    assertSame(iioMetadataNode6, node13);
    assertSame(iioMetadataNode7, node14);
    assertSame(iioMetadataNode8, node15);
    assertSame(iioMetadataNode9, node16);
    assertSame(iioMetadataNode16, node17);
  }

  /**
   * Test {@link NodeValueMerge#merge(List, List, List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link NodeValueMerge#merge(List, List, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Node[] NodeValueMerge.merge(List, List, List)"})
  public void testMerge_whenArrayList_thenReturnNull() {
    // Arrange
    ArrayList<Node> nodeList1 = new ArrayList<>();
    ArrayList<Node> nodeList2 = new ArrayList<>();

    // Act and Assert
    assertNull(nodeValueMerge.merge(nodeList1, nodeList2, new ArrayList<>()));
  }

  /**
   * Test {@link NodeValueMerge#getMergedNodeValues(Node, Node)}.
   * <ul>
   *   <li>Given {@link NodeValueMerge} (default constructor).</li>
   *   <li>When {@link AttrNSImpl#AttrNSImpl()}.</li>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link NodeValueMerge#getMergedNodeValues(Node, Node)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Set NodeValueMerge.getMergedNodeValues(Node, Node)"})
  public void testGetMergedNodeValues_givenNodeValueMerge_whenAttrNSImpl_thenReturnSizeIsOne() {
    // Arrange
    NodeValueMerge nodeValueMerge = new NodeValueMerge();
    AttrNSImpl node1 = new AttrNSImpl();

    // Act
    Set<String> actualMergedNodeValues = nodeValueMerge.getMergedNodeValues(node1, new AttrNSImpl());

    // Assert
    assertEquals(1, actualMergedNodeValues.size());
    assertTrue(actualMergedNodeValues.contains(""));
  }

  /**
   * Test {@link NodeValueMerge#getMergedNodeValues(Node, Node)}.
   * <ul>
   *   <li>Given {@link SchemaLocationNodeValueMerge} (default constructor).</li>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link NodeValueMerge#getMergedNodeValues(Node, Node)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Set NodeValueMerge.getMergedNodeValues(Node, Node)"})
  public void testGetMergedNodeValues_givenSchemaLocationNodeValueMerge_thenReturnSizeIsOne() {
    // Arrange
    SchemaLocationNodeValueMerge schemaLocationNodeValueMerge = new SchemaLocationNodeValueMerge();
    AttrNSImpl node1 = new AttrNSImpl();

    // Act
    Set<String> actualMergedNodeValues = schemaLocationNodeValueMerge.getMergedNodeValues(node1, new AttrNSImpl());

    // Assert
    assertEquals(1, actualMergedNodeValues.size());
    assertTrue(actualMergedNodeValues.contains(""));
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link NodeValueMerge#getDelimiter()}
   *   <li>{@link NodeValueMerge#getRegEx()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
   * <p>
   * Method under test: default or parameterless constructor of {@link NodeValueMerge}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
