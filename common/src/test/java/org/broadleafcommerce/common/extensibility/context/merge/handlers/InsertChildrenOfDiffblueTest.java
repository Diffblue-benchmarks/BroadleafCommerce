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
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.metadata.IIOMetadataNode;
import org.broadleafcommerce.common.extensibility.context.merge.handlers.SchemaLocationMergeTest.DummyNode;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.w3c.dom.Node;

@ContextConfiguration(classes = {InsertChildrenOf.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class InsertChildrenOfDiffblueTest {
  @Autowired
  private InsertChildrenOf insertChildrenOf;

  /**
   * Test {@link InsertChildrenOf#merge(List, List, List)}.
   * <ul>
   *   <li>Given {@link DummyNode}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link DummyNode}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link InsertChildrenOf#merge(List, List, List)}
   */
  @Test
  public void testMerge_givenDummyNode_whenArrayListAddDummyNode_thenReturnNull() {
    // Arrange
    ArrayList<Node> nodeList1 = new ArrayList<>();
    nodeList1.add(mock(SchemaLocationMergeTest.DummyNode.class));
    ArrayList<Node> nodeList2 = new ArrayList<>();

    // Act and Assert
    assertNull(insertChildrenOf.merge(nodeList1, nodeList2, new ArrayList<>()));
  }

  /**
   * Test {@link InsertChildrenOf#merge(List, List, List)}.
   * <ul>
   *   <li>Given {@link IIOMetadataNode#IIOMetadataNode(String)} with
   * {@code foo}.</li>
   *   <li>Then return array length is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link InsertChildrenOf#merge(List, List, List)}
   */
  @Test
  public void testMerge_givenIIOMetadataNodeWithFoo_thenReturnArrayLengthIsOne() {
    // Arrange
    ArrayList<Node> nodeList1 = new ArrayList<>();
    nodeList1.add(new IIOMetadataNode("foo"));

    ArrayList<Node> nodeList2 = new ArrayList<>();
    IIOMetadataNode iioMetadataNode = new IIOMetadataNode("foo");
    nodeList2.add(iioMetadataNode);

    // Act
    Node[] actualMergeResult = insertChildrenOf.merge(nodeList1, nodeList2, new ArrayList<>());

    // Assert
    assertEquals(1, actualMergeResult.length);
    assertSame(iioMetadataNode, actualMergeResult[0]);
  }

  /**
   * Test {@link InsertChildrenOf#merge(List, List, List)}.
   * <ul>
   *   <li>Given {@link IIOMetadataNode#IIOMetadataNode(String)} with
   * {@code foo}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add
   * {@link IIOMetadataNode#IIOMetadataNode(String)} with {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link InsertChildrenOf#merge(List, List, List)}
   */
  @Test
  public void testMerge_givenIIOMetadataNodeWithFoo_whenArrayListAddIIOMetadataNodeWithFoo() {
    // Arrange
    ArrayList<Node> nodeList1 = new ArrayList<>();
    nodeList1.add(new IIOMetadataNode("foo"));
    ArrayList<Node> nodeList2 = new ArrayList<>();

    // Act and Assert
    assertNull(insertChildrenOf.merge(nodeList1, nodeList2, new ArrayList<>()));
  }

  /**
   * Test {@link InsertChildrenOf#merge(List, List, List)}.
   * <ul>
   *   <li>Given {@link IIOMetadataNode#IIOMetadataNode(String)} with
   * {@code foo}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add
   * {@link IIOMetadataNode#IIOMetadataNode(String)} with {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link InsertChildrenOf#merge(List, List, List)}
   */
  @Test
  public void testMerge_givenIIOMetadataNodeWithFoo_whenArrayListAddIIOMetadataNodeWithFoo2() {
    // Arrange
    ArrayList<Node> nodeList1 = new ArrayList<>();
    nodeList1.add(new IIOMetadataNode("foo"));
    nodeList1.add(new IIOMetadataNode("foo"));
    ArrayList<Node> nodeList2 = new ArrayList<>();

    // Act and Assert
    assertNull(insertChildrenOf.merge(nodeList1, nodeList2, new ArrayList<>()));
  }

  /**
   * Test {@link InsertChildrenOf#merge(List, List, List)}.
   * <ul>
   *   <li>Given {@link IIOMetadataNode#IIOMetadataNode(String)} with
   * {@code foo}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add
   * {@link IIOMetadataNode#IIOMetadataNode(String)} with {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link InsertChildrenOf#merge(List, List, List)}
   */
  @Test
  public void testMerge_givenIIOMetadataNodeWithFoo_whenArrayListAddIIOMetadataNodeWithFoo3() {
    // Arrange
    ArrayList<Node> nodeList1 = new ArrayList<>();

    ArrayList<Node> nodeList2 = new ArrayList<>();
    nodeList2.add(new IIOMetadataNode("foo"));

    // Act and Assert
    assertNull(insertChildrenOf.merge(nodeList1, nodeList2, new ArrayList<>()));
  }

  /**
   * Test {@link InsertChildrenOf#merge(List, List, List)}.
   * <ul>
   *   <li>Given {@link IIOMetadataNode#IIOMetadataNode(String)} with
   * {@code foo}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add
   * {@link IIOMetadataNode#IIOMetadataNode(String)} with {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link InsertChildrenOf#merge(List, List, List)}
   */
  @Test
  public void testMerge_givenIIOMetadataNodeWithFoo_whenArrayListAddIIOMetadataNodeWithFoo4() {
    // Arrange
    ArrayList<Node> nodeList1 = new ArrayList<>();

    ArrayList<Node> nodeList2 = new ArrayList<>();
    nodeList2.add(new IIOMetadataNode("foo"));
    nodeList2.add(new IIOMetadataNode("foo"));

    // Act and Assert
    assertNull(insertChildrenOf.merge(nodeList1, nodeList2, new ArrayList<>()));
  }

  /**
   * Test {@link InsertChildrenOf#merge(List, List, List)}.
   * <ul>
   *   <li>Given {@link IIOMetadataNode#IIOMetadataNode(String)} with
   * {@code foo}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add
   * {@link IIOMetadataNode#IIOMetadataNode(String)} with {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link InsertChildrenOf#merge(List, List, List)}
   */
  @Test
  public void testMerge_givenIIOMetadataNodeWithFoo_whenArrayListAddIIOMetadataNodeWithFoo5() {
    // Arrange
    ArrayList<Node> nodeList1 = new ArrayList<>();
    ArrayList<Node> nodeList2 = new ArrayList<>();

    ArrayList<Node> exhaustedNodes = new ArrayList<>();
    exhaustedNodes.add(new IIOMetadataNode("foo"));

    // Act and Assert
    assertNull(insertChildrenOf.merge(nodeList1, nodeList2, exhaustedNodes));
  }

  /**
   * Test {@link InsertChildrenOf#merge(List, List, List)}.
   * <ul>
   *   <li>Given {@link IIOMetadataNode#IIOMetadataNode(String)} with
   * {@code foo}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add
   * {@link IIOMetadataNode#IIOMetadataNode(String)} with {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link InsertChildrenOf#merge(List, List, List)}
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
    assertNull(insertChildrenOf.merge(nodeList1, nodeList2, exhaustedNodes));
  }

  /**
   * Test {@link InsertChildrenOf#merge(List, List, List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link InsertChildrenOf#merge(List, List, List)}
   */
  @Test
  public void testMerge_whenArrayList_thenReturnNull() {
    // Arrange
    ArrayList<Node> nodeList1 = new ArrayList<>();
    ArrayList<Node> nodeList2 = new ArrayList<>();

    // Act and Assert
    assertNull(insertChildrenOf.merge(nodeList1, nodeList2, new ArrayList<>()));
  }

  /**
   * Test new {@link InsertChildrenOf} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link InsertChildrenOf}
   */
  @Test
  public void testNewInsertChildrenOf() {
    // Arrange and Act
    InsertChildrenOf actualInsertChildrenOf = new InsertChildrenOf();

    // Assert
    assertNull(actualInsertChildrenOf.getName());
    assertNull(actualInsertChildrenOf.getXPath());
    assertEquals(0, actualInsertChildrenOf.getPriority());
    assertEquals(0, actualInsertChildrenOf.getChildren().length);
  }
}
