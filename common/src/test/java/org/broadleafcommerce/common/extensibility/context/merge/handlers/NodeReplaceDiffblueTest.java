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
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.metadata.IIOMetadataNode;
import org.apache.xerces.impl.xs.opti.DefaultDocument;
import org.apache.xerces.impl.xs.opti.DefaultElement;
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

@ContextConfiguration(classes = {NodeReplace.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class NodeReplaceDiffblueTest {
  @Autowired private NodeReplace nodeReplace;

  /**
   * Test {@link NodeReplace#checkNode(List, Node[], Node)}.
   *
   * <ul>
   *   <li>Given {@code false}.
   *   <li>When {@link DummyNode} {@link DummyNode#isEqualNode(Node)} return {@code false}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link NodeReplace#checkNode(List, Node[], Node)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean NodeReplace.checkNode(List, Node[], Node)"})
  public void testCheckNode_givenFalse_whenDummyNodeIsEqualNodeReturnFalse_thenReturnFalse() {
    // Arrange
    ArrayList<Node> usedNodes = new ArrayList<>();

    DummyNode dummyNode = mock(DummyNode.class);
    when(dummyNode.isEqualNode(Mockito.<Node>any())).thenReturn(false);
    when(dummyNode.getNodeName()).thenReturn("Node Name");

    // Act
    boolean actualCheckNodeResult =
        nodeReplace.checkNode(usedNodes, new Node[] {dummyNode}, new IIOMetadataNode());

    // Assert
    verify(dummyNode).getNodeName();
    verify(dummyNode).isEqualNode(isA(Node.class));
    assertFalse(actualCheckNodeResult);
    assertTrue(usedNodes.isEmpty());
  }

  /**
   * Test {@link NodeReplace#checkNode(List, Node[], Node)}.
   *
   * <ul>
   *   <li>Given {@link NodeReplace} (default constructor).
   *   <li>Then {@link ArrayList#ArrayList()} first {@link DefaultElement}.
   * </ul>
   *
   * <p>Method under test: {@link NodeReplace#checkNode(List, Node[], Node)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean NodeReplace.checkNode(List, Node[], Node)"})
  public void testCheckNode_givenNodeReplace_thenArrayListFirstDefaultElement()
      throws DOMException {
    // Arrange
    NodeReplace nodeReplace = new NodeReplace();
    ArrayList<Node> usedNodes = new ArrayList<>();

    DefaultDocument defaultDocument = mock(DefaultDocument.class);
    when(defaultDocument.importNode(Mockito.<Node>any(), anyBoolean()))
        .thenReturn(new IIOMetadataNode());

    DefaultDocument defaultDocument2 = mock(DefaultDocument.class);
    when(defaultDocument2.replaceChild(Mockito.<Node>any(), Mockito.<Node>any()))
        .thenReturn(new IIOMetadataNode());

    DummyNode dummyNode = mock(DummyNode.class);
    when(dummyNode.getParentNode()).thenReturn(defaultDocument2);
    when(dummyNode.getOwnerDocument()).thenReturn(defaultDocument);
    when(dummyNode.getNodeName()).thenReturn("foo");
    DefaultElement node = new DefaultElement("foo", "foo", "foo", "foo", (short) 1);

    // Act
    nodeReplace.checkNode(usedNodes, new Node[] {dummyNode}, node);

    // Assert
    verify(defaultDocument).importNode(isNull(), eq(true));
    verify(dummyNode).getNodeName();
    verify(dummyNode).getOwnerDocument();
    verify(dummyNode).getParentNode();
    verify(defaultDocument2).replaceChild(isA(Node.class), isA(Node.class));
    assertEquals(1, usedNodes.size());
    Node getResult = usedNodes.get(0);
    assertTrue(getResult instanceof DefaultElement);
    assertSame(node, getResult);
  }

  /**
   * Test {@link NodeReplace#checkNode(List, Node[], Node)}.
   *
   * <ul>
   *   <li>Given {@link NodeReplace}.
   *   <li>When empty array of {@link Node}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link NodeReplace#checkNode(List, Node[], Node)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean NodeReplace.checkNode(List, Node[], Node)"})
  public void testCheckNode_givenNodeReplace_whenEmptyArrayOfNode_thenReturnFalse() {
    // Arrange
    ArrayList<Node> usedNodes = new ArrayList<>();

    // Act and Assert
    assertFalse(nodeReplace.checkNode(usedNodes, new Node[] {}, new IIOMetadataNode()));
    assertTrue(usedNodes.isEmpty());
  }

  /**
   * Test {@link NodeReplace#checkNode(List, Node[], Node)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>When {@link DummyNode} {@link DummyNode#isEqualNode(Node)} return {@code true}.
   *   <li>Then array length is one.
   * </ul>
   *
   * <p>Method under test: {@link NodeReplace#checkNode(List, Node[], Node)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean NodeReplace.checkNode(List, Node[], Node)"})
  public void testCheckNode_givenTrue_whenDummyNodeIsEqualNodeReturnTrue_thenArrayLengthIsOne() {
    // Arrange
    ArrayList<Node> usedNodes = new ArrayList<>();

    DummyNode dummyNode = mock(DummyNode.class);
    when(dummyNode.isEqualNode(Mockito.<Node>any())).thenReturn(true);
    when(dummyNode.getNodeName()).thenReturn("Node Name");
    Node[] primaryNodes = new Node[] {dummyNode};

    // Act
    boolean actualCheckNodeResult =
        nodeReplace.checkNode(usedNodes, primaryNodes, new IIOMetadataNode());

    // Assert
    verify(dummyNode).getNodeName();
    verify(dummyNode).isEqualNode(isA(Node.class));
    assertEquals(1, usedNodes.size());
    assertEquals(1, primaryNodes.length);
    assertTrue(actualCheckNodeResult);
    assertSame(usedNodes.get(0), primaryNodes[0]);
  }

  /**
   * Test {@link NodeReplace#replaceNode(Node[], Node, List)} with {@code primaryNodes}, {@code
   * testNode}, {@code usedNodes}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link NodeReplace#replaceNode(Node[], Node, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean NodeReplace.replaceNode(Node[], Node, List)"})
  public void testReplaceNodeWithPrimaryNodesTestNodeUsedNodes_thenReturnFalse() {
    // Arrange
    IIOMetadataNode testNode = new IIOMetadataNode();

    // Act and Assert
    assertFalse(
        nodeReplace.replaceNode(new Node[] {new DefaultDocument()}, testNode, new ArrayList<>()));
  }

  /**
   * Test {@link NodeReplace#replaceNode(Node[], Node, List)} with {@code primaryNodes}, {@code
   * testNode}, {@code usedNodes}.
   *
   * <ul>
   *   <li>When empty array of {@link Node}.
   * </ul>
   *
   * <p>Method under test: {@link NodeReplace#replaceNode(Node[], Node, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean NodeReplace.replaceNode(Node[], Node, List)"})
  public void testReplaceNodeWithPrimaryNodesTestNodeUsedNodes_whenEmptyArrayOfNode() {
    // Arrange
    IIOMetadataNode testNode = new IIOMetadataNode();

    // Act and Assert
    assertFalse(nodeReplace.replaceNode(new Node[] {}, testNode, new ArrayList<>()));
  }

  /**
   * Test new {@link NodeReplace} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link NodeReplace}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void NodeReplace.<init>()"})
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
