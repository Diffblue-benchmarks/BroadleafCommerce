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
package org.broadleafcommerce.common.extensibility.context.merge.handlers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.imageio.metadata.IIOMetadataNode;
import org.apache.xerces.dom.AttrNSImpl;
import org.broadleafcommerce.common.extensibility.context.merge.handlers.SchemaLocationMergeTest.DummyNode;
import org.junit.Test;
import org.junit.runner.RunWith;
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
   *   <li>Given {@link DummyNode}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link DummyNode}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link NodeValueMerge#merge(List, List, List)}
   */
  @Test
  public void testMerge_givenDummyNode_whenArrayListAddDummyNode_thenReturnNull() {
    // Arrange
    ArrayList<Node> nodeList1 = new ArrayList<>();
    nodeList1.add(mock(SchemaLocationMergeTest.DummyNode.class));
    ArrayList<Node> nodeList2 = new ArrayList<>();

    // Act and Assert
    assertNull(nodeValueMerge.merge(nodeList1, nodeList2, new ArrayList<>()));
  }

  /**
   * Test {@link NodeValueMerge#merge(List, List, List)}.
   * <ul>
   *   <li>Given {@link IIOMetadataNode#IIOMetadataNode(String)} with
   * {@code foo}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add
   * {@link IIOMetadataNode#IIOMetadataNode(String)} with {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link NodeValueMerge#merge(List, List, List)}
   */
  @Test
  public void testMerge_givenIIOMetadataNodeWithFoo_whenArrayListAddIIOMetadataNodeWithFoo() {
    // Arrange
    ArrayList<Node> nodeList1 = new ArrayList<>();
    nodeList1.add(new IIOMetadataNode("foo"));
    ArrayList<Node> nodeList2 = new ArrayList<>();

    // Act and Assert
    assertNull(nodeValueMerge.merge(nodeList1, nodeList2, new ArrayList<>()));
  }

  /**
   * Test {@link NodeValueMerge#merge(List, List, List)}.
   * <ul>
   *   <li>Given {@link IIOMetadataNode#IIOMetadataNode(String)} with
   * {@code foo}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add
   * {@link IIOMetadataNode#IIOMetadataNode(String)} with {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link NodeValueMerge#merge(List, List, List)}
   */
  @Test
  public void testMerge_givenIIOMetadataNodeWithFoo_whenArrayListAddIIOMetadataNodeWithFoo2() {
    // Arrange
    ArrayList<Node> nodeList1 = new ArrayList<>();
    nodeList1.add(new IIOMetadataNode("foo"));
    nodeList1.add(new IIOMetadataNode("foo"));
    ArrayList<Node> nodeList2 = new ArrayList<>();

    // Act and Assert
    assertNull(nodeValueMerge.merge(nodeList1, nodeList2, new ArrayList<>()));
  }

  /**
   * Test {@link NodeValueMerge#merge(List, List, List)}.
   * <ul>
   *   <li>Given {@link IIOMetadataNode#IIOMetadataNode(String)} with
   * {@code foo}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add
   * {@link IIOMetadataNode#IIOMetadataNode(String)} with {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link NodeValueMerge#merge(List, List, List)}
   */
  @Test
  public void testMerge_givenIIOMetadataNodeWithFoo_whenArrayListAddIIOMetadataNodeWithFoo3() {
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
   *   <li>Given {@link IIOMetadataNode#IIOMetadataNode(String)} with
   * {@code foo}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add
   * {@link IIOMetadataNode#IIOMetadataNode(String)} with {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link NodeValueMerge#merge(List, List, List)}
   */
  @Test
  public void testMerge_givenIIOMetadataNodeWithFoo_whenArrayListAddIIOMetadataNodeWithFoo4() {
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
   *   <li>Given {@link IIOMetadataNode#IIOMetadataNode(String)} with
   * {@code foo}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add
   * {@link IIOMetadataNode#IIOMetadataNode(String)} with {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link NodeValueMerge#merge(List, List, List)}
   */
  @Test
  public void testMerge_givenIIOMetadataNodeWithFoo_whenArrayListAddIIOMetadataNodeWithFoo5() {
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
   *   <li>Given {@link IIOMetadataNode#IIOMetadataNode(String)} with
   * {@code foo}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add
   * {@link IIOMetadataNode#IIOMetadataNode(String)} with {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link NodeValueMerge#merge(List, List, List)}
   */
  @Test
  public void testMerge_givenIIOMetadataNodeWithFoo_whenArrayListAddIIOMetadataNodeWithFoo6() {
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
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link NodeValueMerge#merge(List, List, List)}
   */
  @Test
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
   *   <li>Given {@link SchemaLocationNodeValueMerge} (default constructor).</li>
   *   <li>Then return contains {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link NodeValueMerge#getMergedNodeValues(Node, Node)}
   */
  @Test
  public void testGetMergedNodeValues_givenSchemaLocationNodeValueMerge_thenReturnContains42() throws DOMException {
    // Arrange
    SchemaLocationNodeValueMerge schemaLocationNodeValueMerge = new SchemaLocationNodeValueMerge();
    SchemaLocationMergeTest.DummyNode node1 = mock(SchemaLocationMergeTest.DummyNode.class);
    when(node1.getNodeValue()).thenReturn("42");

    IIOMetadataNode node2 = new IIOMetadataNode("foo");
    node2.setNodeValue("foo");

    // Act
    Set<String> actualMergedNodeValues = schemaLocationNodeValueMerge.getMergedNodeValues(node1, node2);

    // Assert
    verify(node1).getNodeValue();
    assertEquals(2, actualMergedNodeValues.size());
    assertTrue(actualMergedNodeValues.contains("42"));
    assertTrue(actualMergedNodeValues.contains("foo"));
  }

  /**
   * Test {@link NodeValueMerge#getMergedNodeValues(Node, Node)}.
   * <ul>
   *   <li>Given {@code spring-U-9.9.xsd}.</li>
   *   <li>Then return contains {@code spring-U.xsd}.</li>
   * </ul>
   * <p>
   * Method under test: {@link NodeValueMerge#getMergedNodeValues(Node, Node)}
   */
  @Test
  public void testGetMergedNodeValues_givenSpringU99Xsd_thenReturnContainsSpringUXsd() throws DOMException {
    // Arrange
    SchemaLocationNodeValueMerge schemaLocationNodeValueMerge = new SchemaLocationNodeValueMerge();
    SchemaLocationMergeTest.DummyNode node1 = mock(SchemaLocationMergeTest.DummyNode.class);
    when(node1.getNodeValue()).thenReturn("spring-U-9.9.xsd");

    IIOMetadataNode node2 = new IIOMetadataNode("foo");
    node2.setNodeValue("foo");

    // Act
    Set<String> actualMergedNodeValues = schemaLocationNodeValueMerge.getMergedNodeValues(node1, node2);

    // Assert
    verify(node1).getNodeValue();
    assertEquals(2, actualMergedNodeValues.size());
    assertTrue(actualMergedNodeValues.contains("foo"));
    assertTrue(actualMergedNodeValues.contains("spring-U.xsd"));
  }

  /**
   * Test {@link NodeValueMerge#getMergedNodeValues(Node, Node)}.
   * <ul>
   *   <li>When {@link AttrNSImpl#AttrNSImpl()}.</li>
   *   <li>Then return contains empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link NodeValueMerge#getMergedNodeValues(Node, Node)}
   */
  @Test
  public void testGetMergedNodeValues_whenAttrNSImpl_thenReturnContainsEmptyString() throws DOMException {
    // Arrange
    NodeValueMerge nodeValueMerge = new NodeValueMerge();
    SchemaLocationMergeTest.DummyNode node1 = mock(SchemaLocationMergeTest.DummyNode.class);
    when(node1.getNodeValue()).thenReturn("42");

    // Act
    Set<String> actualMergedNodeValues = nodeValueMerge.getMergedNodeValues(node1, new AttrNSImpl());

    // Assert
    verify(node1).getNodeValue();
    assertEquals(2, actualMergedNodeValues.size());
    assertTrue(actualMergedNodeValues.contains(""));
    assertTrue(actualMergedNodeValues.contains("42"));
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
   * Method under test: default or parameterless constructor of
   * {@link NodeValueMerge}
   */
  @Test
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
