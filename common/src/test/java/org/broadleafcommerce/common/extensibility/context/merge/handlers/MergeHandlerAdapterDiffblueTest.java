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

@ContextConfiguration(classes = {MergeHandlerAdapter.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class MergeHandlerAdapterDiffblueTest {
  @Autowired
  private MergeHandlerAdapter mergeHandlerAdapter;

  /**
   * Test {@link MergeHandlerAdapter#merge(List, List, List)}.
   * <ul>
   *   <li>Given {@link DummyNode}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link DummyNode}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MergeHandlerAdapter#merge(List, List, List)}
   */
  @Test
  public void testMerge_givenDummyNode_whenArrayListAddDummyNode() {
    // Arrange
    ArrayList<Node> nodeList1 = new ArrayList<>();
    nodeList1.add(mock(SchemaLocationMergeTest.DummyNode.class));
    ArrayList<Node> nodeList2 = new ArrayList<>();

    // Act and Assert
    assertNull(mergeHandlerAdapter.merge(nodeList1, nodeList2, new ArrayList<>()));
  }

  /**
   * Test {@link MergeHandlerAdapter#merge(List, List, List)}.
   * <ul>
   *   <li>Given {@link IIOMetadataNode#IIOMetadataNode(String)} with
   * {@code foo}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add
   * {@link IIOMetadataNode#IIOMetadataNode(String)} with {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MergeHandlerAdapter#merge(List, List, List)}
   */
  @Test
  public void testMerge_givenIIOMetadataNodeWithFoo_whenArrayListAddIIOMetadataNodeWithFoo() {
    // Arrange
    ArrayList<Node> nodeList1 = new ArrayList<>();
    nodeList1.add(new IIOMetadataNode("foo"));
    ArrayList<Node> nodeList2 = new ArrayList<>();

    // Act and Assert
    assertNull(mergeHandlerAdapter.merge(nodeList1, nodeList2, new ArrayList<>()));
  }

  /**
   * Test {@link MergeHandlerAdapter#merge(List, List, List)}.
   * <ul>
   *   <li>Given {@link IIOMetadataNode#IIOMetadataNode(String)} with
   * {@code foo}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add
   * {@link IIOMetadataNode#IIOMetadataNode(String)} with {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MergeHandlerAdapter#merge(List, List, List)}
   */
  @Test
  public void testMerge_givenIIOMetadataNodeWithFoo_whenArrayListAddIIOMetadataNodeWithFoo2() {
    // Arrange
    ArrayList<Node> nodeList1 = new ArrayList<>();
    nodeList1.add(new IIOMetadataNode("foo"));
    nodeList1.add(new IIOMetadataNode("foo"));
    ArrayList<Node> nodeList2 = new ArrayList<>();

    // Act and Assert
    assertNull(mergeHandlerAdapter.merge(nodeList1, nodeList2, new ArrayList<>()));
  }

  /**
   * Test {@link MergeHandlerAdapter#merge(List, List, List)}.
   * <ul>
   *   <li>Given {@link IIOMetadataNode#IIOMetadataNode(String)} with
   * {@code foo}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add
   * {@link IIOMetadataNode#IIOMetadataNode(String)} with {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MergeHandlerAdapter#merge(List, List, List)}
   */
  @Test
  public void testMerge_givenIIOMetadataNodeWithFoo_whenArrayListAddIIOMetadataNodeWithFoo3() {
    // Arrange
    ArrayList<Node> nodeList1 = new ArrayList<>();

    ArrayList<Node> nodeList2 = new ArrayList<>();
    nodeList2.add(new IIOMetadataNode("foo"));

    // Act and Assert
    assertNull(mergeHandlerAdapter.merge(nodeList1, nodeList2, new ArrayList<>()));
  }

  /**
   * Test {@link MergeHandlerAdapter#merge(List, List, List)}.
   * <ul>
   *   <li>Given {@link IIOMetadataNode#IIOMetadataNode(String)} with
   * {@code foo}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add
   * {@link IIOMetadataNode#IIOMetadataNode(String)} with {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MergeHandlerAdapter#merge(List, List, List)}
   */
  @Test
  public void testMerge_givenIIOMetadataNodeWithFoo_whenArrayListAddIIOMetadataNodeWithFoo4() {
    // Arrange
    ArrayList<Node> nodeList1 = new ArrayList<>();

    ArrayList<Node> nodeList2 = new ArrayList<>();
    nodeList2.add(new IIOMetadataNode("foo"));
    nodeList2.add(new IIOMetadataNode("foo"));

    // Act and Assert
    assertNull(mergeHandlerAdapter.merge(nodeList1, nodeList2, new ArrayList<>()));
  }

  /**
   * Test {@link MergeHandlerAdapter#merge(List, List, List)}.
   * <ul>
   *   <li>Given {@link IIOMetadataNode#IIOMetadataNode(String)} with
   * {@code foo}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add
   * {@link IIOMetadataNode#IIOMetadataNode(String)} with {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MergeHandlerAdapter#merge(List, List, List)}
   */
  @Test
  public void testMerge_givenIIOMetadataNodeWithFoo_whenArrayListAddIIOMetadataNodeWithFoo5() {
    // Arrange
    ArrayList<Node> nodeList1 = new ArrayList<>();
    ArrayList<Node> nodeList2 = new ArrayList<>();

    ArrayList<Node> exhaustedNodes = new ArrayList<>();
    exhaustedNodes.add(new IIOMetadataNode("foo"));

    // Act and Assert
    assertNull(mergeHandlerAdapter.merge(nodeList1, nodeList2, exhaustedNodes));
  }

  /**
   * Test {@link MergeHandlerAdapter#merge(List, List, List)}.
   * <ul>
   *   <li>Given {@link IIOMetadataNode#IIOMetadataNode(String)} with
   * {@code foo}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add
   * {@link IIOMetadataNode#IIOMetadataNode(String)} with {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MergeHandlerAdapter#merge(List, List, List)}
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
    assertNull(mergeHandlerAdapter.merge(nodeList1, nodeList2, exhaustedNodes));
  }

  /**
   * Test {@link MergeHandlerAdapter#merge(List, List, List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MergeHandlerAdapter#merge(List, List, List)}
   */
  @Test
  public void testMerge_whenArrayList() {
    // Arrange
    ArrayList<Node> nodeList1 = new ArrayList<>();
    ArrayList<Node> nodeList2 = new ArrayList<>();

    // Act and Assert
    assertNull(mergeHandlerAdapter.merge(nodeList1, nodeList2, new ArrayList<>()));
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link MergeHandlerAdapter}
   *   <li>{@link MergeHandlerAdapter#setChildren(MergeHandler[])}
   *   <li>{@link MergeHandlerAdapter#setName(String)}
   *   <li>{@link MergeHandlerAdapter#setPriority(int)}
   *   <li>{@link MergeHandlerAdapter#setXPath(String)}
   *   <li>{@link MergeHandlerAdapter#getChildren()}
   *   <li>{@link MergeHandlerAdapter#getName()}
   *   <li>{@link MergeHandlerAdapter#getPriority()}
   *   <li>{@link MergeHandlerAdapter#getXPath()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    MergeHandlerAdapter actualMergeHandlerAdapter = new MergeHandlerAdapter();
    actualMergeHandlerAdapter.setChildren(new MergeHandler[]{new AttributePreserveInsert()});
    actualMergeHandlerAdapter.setName("Name");
    actualMergeHandlerAdapter.setPriority(1);
    actualMergeHandlerAdapter.setXPath("Xpath");
    actualMergeHandlerAdapter.getChildren();
    actualMergeHandlerAdapter.getName();
    int actualPriority = actualMergeHandlerAdapter.getPriority();
    actualMergeHandlerAdapter.getXPath();

    // Assert that nothing has changed
    assertEquals(0, actualPriority);
  }
}
