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
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.Set;
import org.apache.xerces.dom.AttrNSImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.w3c.dom.DOMException;
import org.w3c.dom.Node;

@ContextConfiguration(classes = {SchemaLocationNodeValueMerge.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class SchemaLocationNodeValueMergeDiffblueTest {
  @Autowired
  private SchemaLocationNodeValueMerge schemaLocationNodeValueMerge;

  /**
   * Method under test:
   * {@link SchemaLocationNodeValueMerge#getMergedNodeValues(Node, Node)}
   */
  @Test
  public void testGetMergedNodeValues() throws DOMException {
    // Arrange
    SchemaLocationNodeValueMerge schemaLocationNodeValueMerge = new SchemaLocationNodeValueMerge();
    SchemaLocationMergeTest.DummyNode node1 = mock(SchemaLocationMergeTest.DummyNode.class);
    when(node1.getNodeValue()).thenReturn("42");

    // Act
    Set<String> actualMergedNodeValues = schemaLocationNodeValueMerge.getMergedNodeValues(node1, new AttrNSImpl());

    // Assert
    verify(node1).getNodeValue();
    assertEquals(2, actualMergedNodeValues.size());
    assertTrue(actualMergedNodeValues.contains(""));
    assertTrue(actualMergedNodeValues.contains("42"));
  }

  /**
   * Method under test:
   * {@link SchemaLocationNodeValueMerge#getMergedNodeValues(Node, Node)}
   */
  @Test
  public void testGetMergedNodeValues2() throws DOMException {
    // Arrange
    SchemaLocationNodeValueMerge schemaLocationNodeValueMerge = new SchemaLocationNodeValueMerge();
    SchemaLocationMergeTest.DummyNode node1 = mock(SchemaLocationMergeTest.DummyNode.class);
    when(node1.getNodeValue()).thenReturn("42");
    Node node2 = mock(Node.class);
    when(node2.getNodeValue()).thenReturn("42");

    // Act
    Set<String> actualMergedNodeValues = schemaLocationNodeValueMerge.getMergedNodeValues(node1, node2);

    // Assert
    verify(node1).getNodeValue();
    verify(node2).getNodeValue();
    assertEquals(1, actualMergedNodeValues.size());
    assertTrue(actualMergedNodeValues.contains("42"));
  }

  /**
   * Method under test:
   * {@link SchemaLocationNodeValueMerge#getMergedNodeValues(Node, Node)}
   */
  @Test
  public void testGetMergedNodeValues3() throws DOMException {
    // Arrange
    SchemaLocationNodeValueMerge schemaLocationNodeValueMerge = new SchemaLocationNodeValueMerge();
    SchemaLocationMergeTest.DummyNode node1 = mock(SchemaLocationMergeTest.DummyNode.class);
    when(node1.getNodeValue()).thenReturn("spring-U-9.9.xsd");
    Node node2 = mock(Node.class);
    when(node2.getNodeValue()).thenReturn("42");

    // Act
    Set<String> actualMergedNodeValues = schemaLocationNodeValueMerge.getMergedNodeValues(node1, node2);

    // Assert
    verify(node1).getNodeValue();
    verify(node2).getNodeValue();
    assertEquals(2, actualMergedNodeValues.size());
    assertTrue(actualMergedNodeValues.contains("42"));
    assertTrue(actualMergedNodeValues.contains("spring-U.xsd"));
  }

  /**
   * Method under test:
   * {@link SchemaLocationNodeValueMerge#getSanitizedValue(String)}
   */
  @Test
  public void testGetSanitizedValue() {
    // Arrange, Act and Assert
    assertEquals("42", schemaLocationNodeValueMerge.getSanitizedValue("42"));
    assertEquals("spring-U.xsd", schemaLocationNodeValueMerge.getSanitizedValue("spring-U-9.9.xsd"));
    assertEquals("42spring-U.xsd", schemaLocationNodeValueMerge.getSanitizedValue("42spring-U-9.9.xsd"));
    assertEquals("spring-U.xsd42", schemaLocationNodeValueMerge.getSanitizedValue("spring-U-9.9.xsd42"));
    assertEquals("spring-U.xsdspring-U.xsd",
        schemaLocationNodeValueMerge.getSanitizedValue("spring-U-9.9.xsdspring-U-9.9.xsd"));
    assertEquals("spring-U.xsd(spring-\\w*-[0-9]\\.[0-9]\\.xsd)",
        schemaLocationNodeValueMerge.getSanitizedValue("spring-U-9.9.xsd(spring-\\w*-[0-9]\\.[0-9]\\.xsd)"));
    assertEquals("spring-U.xsdAttribute Value",
        schemaLocationNodeValueMerge.getSanitizedValue("spring-U-9.9.xsdAttribute Value"));
    assertEquals("(spring-\\w*-[0-9]\\.[0-9]\\.xsd)spring-U.xsd",
        schemaLocationNodeValueMerge.getSanitizedValue("(spring-\\w*-[0-9]\\.[0-9]\\.xsd)spring-U-9.9.xsd"));
    assertEquals("Attribute Valuespring-U.xsd",
        schemaLocationNodeValueMerge.getSanitizedValue("Attribute Valuespring-U-9.9.xsd"));
    assertEquals("4242spring-U.xsd", schemaLocationNodeValueMerge.getSanitizedValue("4242spring-U-9.9.xsd"));
    assertEquals("42spring-U.xsd42", schemaLocationNodeValueMerge.getSanitizedValue("42spring-U-9.9.xsd42"));
    assertEquals("42spring-U.xsdspring-U.xsd",
        schemaLocationNodeValueMerge.getSanitizedValue("42spring-U-9.9.xsdspring-U-9.9.xsd"));
    assertEquals("42spring-U.xsd(spring-\\w*-[0-9]\\.[0-9]\\.xsd)",
        schemaLocationNodeValueMerge.getSanitizedValue("42spring-U-9.9.xsd(spring-\\w*-[0-9]\\.[0-9]\\.xsd)"));
    assertEquals("42spring-U.xsdAttribute Value",
        schemaLocationNodeValueMerge.getSanitizedValue("42spring-U-9.9.xsdAttribute Value"));
    assertEquals("42(spring-\\w*-[0-9]\\.[0-9]\\.xsd)spring-U.xsd",
        schemaLocationNodeValueMerge.getSanitizedValue("42(spring-\\w*-[0-9]\\.[0-9]\\.xsd)spring-U-9.9.xsd"));
    assertEquals("42Attribute Valuespring-U.xsd",
        schemaLocationNodeValueMerge.getSanitizedValue("42Attribute Valuespring-U-9.9.xsd"));
    assertEquals("spring-U.xsd4242", schemaLocationNodeValueMerge.getSanitizedValue("spring-U-9.9.xsd4242"));
    assertEquals("spring-U.xsd42spring-U.xsd",
        schemaLocationNodeValueMerge.getSanitizedValue("spring-U-9.9.xsd42spring-U-9.9.xsd"));
    assertEquals("spring-U.xsd42(spring-\\w*-[0-9]\\.[0-9]\\.xsd)",
        schemaLocationNodeValueMerge.getSanitizedValue("spring-U-9.9.xsd42(spring-\\w*-[0-9]\\.[0-9]\\.xsd)"));
    assertEquals("spring-U.xsd42Attribute Value",
        schemaLocationNodeValueMerge.getSanitizedValue("spring-U-9.9.xsd42Attribute Value"));
    assertEquals("spring-U.xsdspring-U.xsd42",
        schemaLocationNodeValueMerge.getSanitizedValue("spring-U-9.9.xsdspring-U-9.9.xsd42"));
    assertEquals("spring-U.xsdspring-U.xsdspring-U.xsd",
        schemaLocationNodeValueMerge.getSanitizedValue("spring-U-9.9.xsdspring-U-9.9.xsdspring-U-9.9.xsd"));
    assertEquals("spring-U.xsdspring-U.xsd(spring-\\w*-[0-9]\\.[0-9]\\.xsd)", schemaLocationNodeValueMerge
        .getSanitizedValue("spring-U-9.9.xsdspring-U-9.9.xsd(spring-\\w*-[0-9]\\.[0-9]\\.xsd)"));
    assertEquals("spring-U.xsdspring-U.xsdAttribute Value",
        schemaLocationNodeValueMerge.getSanitizedValue("spring-U-9.9.xsdspring-U-9.9.xsdAttribute Value"));
    assertEquals("spring-U.xsd(spring-\\w*-[0-9]\\.[0-9]\\.xsd)42",
        schemaLocationNodeValueMerge.getSanitizedValue("spring-U-9.9.xsd(spring-\\w*-[0-9]\\.[0-9]\\.xsd)42"));
    assertEquals("spring-U.xsd(spring-\\w*-[0-9]\\.[0-9]\\.xsd)spring-U.xsd", schemaLocationNodeValueMerge
        .getSanitizedValue("spring-U-9.9.xsd(spring-\\w*-[0-9]\\.[0-9]\\.xsd)spring-U-9.9.xsd"));
    assertEquals("spring-U.xsd(spring-\\w*-[0-9]\\.[0-9]\\.xsd)(spring-\\w*-[0-9]\\.[0-9]\\.xsd)",
        schemaLocationNodeValueMerge
            .getSanitizedValue("spring-U-9.9.xsd(spring-\\w*-[0-9]\\.[0-9]\\.xsd)(spring-\\w*-[0-9]\\.[0-9]\\.xsd)"));
    assertEquals("spring-U.xsd(spring-\\w*-[0-9]\\.[0-9]\\.xsd)Attribute Value", schemaLocationNodeValueMerge
        .getSanitizedValue("spring-U-9.9.xsd(spring-\\w*-[0-9]\\.[0-9]\\.xsd)Attribute Value"));
    assertEquals("spring-U.xsdAttribute Value42",
        schemaLocationNodeValueMerge.getSanitizedValue("spring-U-9.9.xsdAttribute Value42"));
    assertEquals("spring-U.xsdAttribute Valuespring-U.xsd",
        schemaLocationNodeValueMerge.getSanitizedValue("spring-U-9.9.xsdAttribute Valuespring-U-9.9.xsd"));
    assertEquals("spring-U.xsdAttribute Value(spring-\\w*-[0-9]\\.[0-9]\\.xsd)", schemaLocationNodeValueMerge
        .getSanitizedValue("spring-U-9.9.xsdAttribute Value(spring-\\w*-[0-9]\\.[0-9]\\.xsd)"));
    assertEquals("spring-U.xsdAttribute ValueAttribute Value",
        schemaLocationNodeValueMerge.getSanitizedValue("spring-U-9.9.xsdAttribute ValueAttribute Value"));
    assertEquals("(spring-\\w*-[0-9]\\.[0-9]\\.xsd)42spring-U.xsd",
        schemaLocationNodeValueMerge.getSanitizedValue("(spring-\\w*-[0-9]\\.[0-9]\\.xsd)42spring-U-9.9.xsd"));
    assertEquals("(spring-\\w*-[0-9]\\.[0-9]\\.xsd)spring-U.xsd42",
        schemaLocationNodeValueMerge.getSanitizedValue("(spring-\\w*-[0-9]\\.[0-9]\\.xsd)spring-U-9.9.xsd42"));
    assertEquals("(spring-\\w*-[0-9]\\.[0-9]\\.xsd)spring-U.xsdspring-U.xsd", schemaLocationNodeValueMerge
        .getSanitizedValue("(spring-\\w*-[0-9]\\.[0-9]\\.xsd)spring-U-9.9.xsdspring-U-9.9.xsd"));
    assertEquals("(spring-\\w*-[0-9]\\.[0-9]\\.xsd)spring-U.xsd(spring-\\w*-[0-9]\\.[0-9]\\.xsd)",
        schemaLocationNodeValueMerge
            .getSanitizedValue("(spring-\\w*-[0-9]\\.[0-9]\\.xsd)spring-U-9.9.xsd(spring-\\w*-[0-9]\\.[0-9]\\.xsd)"));
    assertEquals("(spring-\\w*-[0-9]\\.[0-9]\\.xsd)spring-U.xsdAttribute Value", schemaLocationNodeValueMerge
        .getSanitizedValue("(spring-\\w*-[0-9]\\.[0-9]\\.xsd)spring-U-9.9.xsdAttribute Value"));
    assertEquals("(spring-\\w*-[0-9]\\.[0-9]\\.xsd)(spring-\\w*-[0-9]\\.[0-9]\\.xsd)spring-U.xsd",
        schemaLocationNodeValueMerge
            .getSanitizedValue("(spring-\\w*-[0-9]\\.[0-9]\\.xsd)(spring-\\w*-[0-9]\\.[0-9]\\.xsd)spring-U-9.9.xsd"));
    assertEquals("(spring-\\w*-[0-9]\\.[0-9]\\.xsd)Attribute Valuespring-U.xsd", schemaLocationNodeValueMerge
        .getSanitizedValue("(spring-\\w*-[0-9]\\.[0-9]\\.xsd)Attribute Valuespring-U-9.9.xsd"));
    assertEquals("Attribute Value42spring-U.xsd",
        schemaLocationNodeValueMerge.getSanitizedValue("Attribute Value42spring-U-9.9.xsd"));
    assertEquals("Attribute Valuespring-U.xsd42",
        schemaLocationNodeValueMerge.getSanitizedValue("Attribute Valuespring-U-9.9.xsd42"));
    assertEquals("Attribute Valuespring-U.xsdspring-U.xsd",
        schemaLocationNodeValueMerge.getSanitizedValue("Attribute Valuespring-U-9.9.xsdspring-U-9.9.xsd"));
    assertEquals("Attribute Valuespring-U.xsd(spring-\\w*-[0-9]\\.[0-9]\\.xsd)", schemaLocationNodeValueMerge
        .getSanitizedValue("Attribute Valuespring-U-9.9.xsd(spring-\\w*-[0-9]\\.[0-9]\\.xsd)"));
    assertEquals("Attribute Valuespring-U.xsdAttribute Value",
        schemaLocationNodeValueMerge.getSanitizedValue("Attribute Valuespring-U-9.9.xsdAttribute Value"));
    assertEquals("Attribute Value(spring-\\w*-[0-9]\\.[0-9]\\.xsd)spring-U.xsd", schemaLocationNodeValueMerge
        .getSanitizedValue("Attribute Value(spring-\\w*-[0-9]\\.[0-9]\\.xsd)spring-U-9.9.xsd"));
    assertEquals("Attribute ValueAttribute Valuespring-U.xsd",
        schemaLocationNodeValueMerge.getSanitizedValue("Attribute ValueAttribute Valuespring-U-9.9.xsd"));
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link SchemaLocationNodeValueMerge}
   */
  @Test
  public void testNewSchemaLocationNodeValueMerge() {
    // Arrange and Act
    SchemaLocationNodeValueMerge actualSchemaLocationNodeValueMerge = new SchemaLocationNodeValueMerge();

    // Assert
    assertEquals(" ", actualSchemaLocationNodeValueMerge.getDelimiter());
    assertEquals("[\\s\\n\\r]+", actualSchemaLocationNodeValueMerge.getRegEx());
    assertNull(actualSchemaLocationNodeValueMerge.getName());
    assertNull(actualSchemaLocationNodeValueMerge.getXPath());
    assertEquals(0, actualSchemaLocationNodeValueMerge.getPriority());
    assertEquals(0, actualSchemaLocationNodeValueMerge.getChildren().length);
  }
}
