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
import static org.mockito.Mockito.mock;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.metadata.IIOMetadataNode;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.w3c.dom.Node;

@ContextConfiguration(classes = {AttributePreserveInsert.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class AttributePreserveInsertDiffblueTest {
  @Autowired
  private AttributePreserveInsert attributePreserveInsert;

  /**
   * Method under test: {@link AttributePreserveInsert#merge(List, List, List)}
   */
  @Test
  public void testMerge() {
    // Arrange
    ArrayList<Node> nodeList1 = new ArrayList<>();
    ArrayList<Node> nodeList2 = new ArrayList<>();

    // Act and Assert
    assertNull(attributePreserveInsert.merge(nodeList1, nodeList2, new ArrayList<>()));
  }

  /**
   * Method under test: {@link AttributePreserveInsert#merge(List, List, List)}
   */
  @Test
  public void testMerge2() {
    // Arrange
    ArrayList<Node> nodeList1 = new ArrayList<>();
    nodeList1.add(new IIOMetadataNode("foo"));
    ArrayList<Node> nodeList2 = new ArrayList<>();

    // Act and Assert
    assertNull(attributePreserveInsert.merge(nodeList1, nodeList2, new ArrayList<>()));
  }

  /**
   * Method under test: {@link AttributePreserveInsert#merge(List, List, List)}
   */
  @Test
  public void testMerge3() {
    // Arrange
    ArrayList<Node> nodeList1 = new ArrayList<>();
    nodeList1.add(new IIOMetadataNode("foo"));
    nodeList1.add(new IIOMetadataNode("foo"));
    ArrayList<Node> nodeList2 = new ArrayList<>();

    // Act and Assert
    assertNull(attributePreserveInsert.merge(nodeList1, nodeList2, new ArrayList<>()));
  }

  /**
   * Method under test: {@link AttributePreserveInsert#merge(List, List, List)}
   */
  @Test
  public void testMerge4() {
    // Arrange
    ArrayList<Node> nodeList1 = new ArrayList<>();

    ArrayList<Node> nodeList2 = new ArrayList<>();
    nodeList2.add(new IIOMetadataNode("foo"));

    // Act and Assert
    assertNull(attributePreserveInsert.merge(nodeList1, nodeList2, new ArrayList<>()));
  }

  /**
   * Method under test: {@link AttributePreserveInsert#merge(List, List, List)}
   */
  @Test
  public void testMerge5() {
    // Arrange
    ArrayList<Node> nodeList1 = new ArrayList<>();

    ArrayList<Node> nodeList2 = new ArrayList<>();
    nodeList2.add(new IIOMetadataNode("foo"));
    nodeList2.add(new IIOMetadataNode("foo"));

    // Act and Assert
    assertNull(attributePreserveInsert.merge(nodeList1, nodeList2, new ArrayList<>()));
  }

  /**
   * Method under test: {@link AttributePreserveInsert#merge(List, List, List)}
   */
  @Test
  public void testMerge6() {
    // Arrange
    ArrayList<Node> nodeList1 = new ArrayList<>();
    ArrayList<Node> nodeList2 = new ArrayList<>();

    ArrayList<Node> exhaustedNodes = new ArrayList<>();
    exhaustedNodes.add(new IIOMetadataNode("foo"));

    // Act and Assert
    assertNull(attributePreserveInsert.merge(nodeList1, nodeList2, exhaustedNodes));
  }

  /**
   * Method under test: {@link AttributePreserveInsert#merge(List, List, List)}
   */
  @Test
  public void testMerge7() {
    // Arrange
    ArrayList<Node> nodeList1 = new ArrayList<>();
    ArrayList<Node> nodeList2 = new ArrayList<>();

    ArrayList<Node> exhaustedNodes = new ArrayList<>();
    exhaustedNodes.add(new IIOMetadataNode("foo"));
    exhaustedNodes.add(new IIOMetadataNode("foo"));

    // Act and Assert
    assertNull(attributePreserveInsert.merge(nodeList1, nodeList2, exhaustedNodes));
  }

  /**
   * Method under test: {@link AttributePreserveInsert#merge(List, List, List)}
   */
  @Test
  public void testMerge8() {
    // Arrange
    ArrayList<Node> nodeList1 = new ArrayList<>();
    nodeList1.add(mock(SchemaLocationMergeTest.DummyNode.class));
    ArrayList<Node> nodeList2 = new ArrayList<>();

    // Act and Assert
    assertNull(attributePreserveInsert.merge(nodeList1, nodeList2, new ArrayList<>()));
  }

  /**
   * Method under test: {@link AttributePreserveInsert#merge(List, List, List)}
   */
  @Test
  public void testMerge9() {
    // Arrange
    ArrayList<Node> nodeList1 = new ArrayList<>();
    nodeList1.add(new IIOMetadataNode("foo"));

    ArrayList<Node> nodeList2 = new ArrayList<>();
    nodeList2.add(new IIOMetadataNode("foo"));

    // Act and Assert
    assertNull(attributePreserveInsert.merge(nodeList1, nodeList2, new ArrayList<>()));
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link AttributePreserveInsert}
   */
  @Test
  public void testNewAttributePreserveInsert() {
    // Arrange and Act
    AttributePreserveInsert actualAttributePreserveInsert = new AttributePreserveInsert();

    // Assert
    assertNull(actualAttributePreserveInsert.getName());
    assertNull(actualAttributePreserveInsert.getXPath());
    assertEquals(0, actualAttributePreserveInsert.getPriority());
    assertEquals(0, actualAttributePreserveInsert.getChildren().length);
  }
}
