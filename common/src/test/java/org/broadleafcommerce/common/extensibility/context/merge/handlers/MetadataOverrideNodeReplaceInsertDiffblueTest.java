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
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.metadata.IIOMetadataNode;
import org.apache.xerces.impl.xs.opti.DefaultNode;
import org.broadleafcommerce.common.extensibility.context.merge.handlers.SchemaLocationMergeTest.DummyNode;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.w3c.dom.Node;

@ContextConfiguration(classes = {MetadataOverrideNodeReplaceInsert.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class MetadataOverrideNodeReplaceInsertDiffblueTest {
  @Autowired
  private MetadataOverrideNodeReplaceInsert metadataOverrideNodeReplaceInsert;

  /**
   * Test {@link MetadataOverrideNodeReplaceInsert#checkNode(List, Node[], Node)}.
   * <ul>
   *   <li>Given {@code false}.</li>
   *   <li>When {@link DummyNode} {@link DefaultNode#isEqualNode(Node)} return
   * {@code false}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MetadataOverrideNodeReplaceInsert#checkNode(List, Node[], Node)}
   */
  @Test
  public void testCheckNode_givenFalse_whenDummyNodeIsEqualNodeReturnFalse_thenReturnFalse() {
    // Arrange
    ArrayList<Node> usedNodes = new ArrayList<>();
    SchemaLocationMergeTest.DummyNode dummyNode = mock(SchemaLocationMergeTest.DummyNode.class);
    when(dummyNode.isEqualNode(Mockito.<Node>any())).thenReturn(false);

    // Act
    boolean actualCheckNodeResult = metadataOverrideNodeReplaceInsert.checkNode(usedNodes, new Node[]{dummyNode},
        new IIOMetadataNode("foo"));

    // Assert
    verify(dummyNode).isEqualNode(isA(Node.class));
    assertFalse(actualCheckNodeResult);
    assertTrue(usedNodes.isEmpty());
  }

  /**
   * Test {@link MetadataOverrideNodeReplaceInsert#checkNode(List, Node[], Node)}.
   * <ul>
   *   <li>Given {@code true}.</li>
   *   <li>Then {@link ArrayList#ArrayList()} size is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MetadataOverrideNodeReplaceInsert#checkNode(List, Node[], Node)}
   */
  @Test
  public void testCheckNode_givenTrue_thenArrayListSizeIsOne() {
    // Arrange
    ArrayList<Node> usedNodes = new ArrayList<>();
    SchemaLocationMergeTest.DummyNode dummyNode = mock(SchemaLocationMergeTest.DummyNode.class);
    when(dummyNode.isEqualNode(Mockito.<Node>any())).thenReturn(true);
    Node[] primaryNodes = new Node[]{dummyNode};

    // Act
    boolean actualCheckNodeResult = metadataOverrideNodeReplaceInsert.checkNode(usedNodes, primaryNodes,
        new IIOMetadataNode("foo"));

    // Assert
    verify(dummyNode).isEqualNode(isA(Node.class));
    assertEquals(1, usedNodes.size());
    assertEquals(1, primaryNodes.length);
    assertTrue(actualCheckNodeResult);
    assertSame(usedNodes.get(0), primaryNodes[0]);
  }

  /**
   * Test new {@link MetadataOverrideNodeReplaceInsert} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link MetadataOverrideNodeReplaceInsert}
   */
  @Test
  public void testNewMetadataOverrideNodeReplaceInsert() {
    // Arrange and Act
    MetadataOverrideNodeReplaceInsert actualMetadataOverrideNodeReplaceInsert = new MetadataOverrideNodeReplaceInsert();

    // Assert
    assertNull(actualMetadataOverrideNodeReplaceInsert.getName());
    assertNull(actualMetadataOverrideNodeReplaceInsert.getXPath());
    assertEquals(0, actualMetadataOverrideNodeReplaceInsert.getPriority());
    assertEquals(0, actualMetadataOverrideNodeReplaceInsert.getChildren().length);
  }
}
