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
import static org.junit.Assert.assertFalse;
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

@ContextConfiguration(classes = {NonEmptyNodeReplaceInsert.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class NonEmptyNodeReplaceInsertDiffblueTest {
  @Autowired
  private NonEmptyNodeReplaceInsert nonEmptyNodeReplaceInsert;

  /**
   * Test
   * {@link NonEmptyNodeReplaceInsert#replaceNode(Node[], Node, String, List)}.
   * <ul>
   *   <li>Given {@link IIOMetadataNode#IIOMetadataNode(String)} with
   * {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link NonEmptyNodeReplaceInsert#replaceNode(Node[], Node, String, List)}
   */
  @Test
  public void testReplaceNode_givenIIOMetadataNodeWithFoo() {
    // Arrange
    IIOMetadataNode testNode = new IIOMetadataNode("foo");

    ArrayList<Node> usedNodes = new ArrayList<>();
    usedNodes.add(new IIOMetadataNode("foo"));

    // Act and Assert
    assertFalse(nonEmptyNodeReplaceInsert.replaceNode(new Node[]{new IIOMetadataNode("foo")}, testNode, "Attribute",
        usedNodes));
  }

  /**
   * Test
   * {@link NonEmptyNodeReplaceInsert#replaceNode(Node[], Node, String, List)}.
   * <ul>
   *   <li>Given {@link IIOMetadataNode#IIOMetadataNode(String)} with
   * {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link NonEmptyNodeReplaceInsert#replaceNode(Node[], Node, String, List)}
   */
  @Test
  public void testReplaceNode_givenIIOMetadataNodeWithFoo2() {
    // Arrange
    IIOMetadataNode testNode = new IIOMetadataNode("foo");

    ArrayList<Node> usedNodes = new ArrayList<>();
    usedNodes.add(new IIOMetadataNode("foo"));
    usedNodes.add(new IIOMetadataNode("foo"));

    // Act and Assert
    assertFalse(nonEmptyNodeReplaceInsert.replaceNode(new Node[]{new IIOMetadataNode("foo")}, testNode, "Attribute",
        usedNodes));
  }

  /**
   * Test
   * {@link NonEmptyNodeReplaceInsert#replaceNode(Node[], Node, String, List)}.
   * <ul>
   *   <li>When array of {@link Node} with {@link DummyNode}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link NonEmptyNodeReplaceInsert#replaceNode(Node[], Node, String, List)}
   */
  @Test
  public void testReplaceNode_whenArrayOfNodeWithDummyNode_thenReturnFalse() {
    // Arrange
    IIOMetadataNode testNode = new IIOMetadataNode("foo");

    // Act and Assert
    assertFalse(nonEmptyNodeReplaceInsert.replaceNode(new Node[]{mock(SchemaLocationMergeTest.DummyNode.class)},
        testNode, "Attribute", new ArrayList<>()));
  }

  /**
   * Test
   * {@link NonEmptyNodeReplaceInsert#replaceNode(Node[], Node, String, List)}.
   * <ul>
   *   <li>When {@link IIOMetadataNode#IIOMetadataNode(String)} with
   * {@code foo}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link NonEmptyNodeReplaceInsert#replaceNode(Node[], Node, String, List)}
   */
  @Test
  public void testReplaceNode_whenIIOMetadataNodeWithFoo_thenReturnFalse() {
    // Arrange
    IIOMetadataNode testNode = new IIOMetadataNode("foo");

    // Act and Assert
    assertFalse(nonEmptyNodeReplaceInsert.replaceNode(new Node[]{new IIOMetadataNode("foo")}, testNode, "Attribute",
        new ArrayList<>()));
  }

  /**
   * Test new {@link NonEmptyNodeReplaceInsert} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link NonEmptyNodeReplaceInsert}
   */
  @Test
  public void testNewNonEmptyNodeReplaceInsert() {
    // Arrange and Act
    NonEmptyNodeReplaceInsert actualNonEmptyNodeReplaceInsert = new NonEmptyNodeReplaceInsert();

    // Assert
    assertNull(actualNonEmptyNodeReplaceInsert.getName());
    assertNull(actualNonEmptyNodeReplaceInsert.getXPath());
    assertEquals(0, actualNonEmptyNodeReplaceInsert.getPriority());
    assertEquals(0, actualNonEmptyNodeReplaceInsert.getChildren().length);
  }
}
