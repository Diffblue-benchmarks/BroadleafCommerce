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
   * Test {@link SchemaLocationNodeValueMerge#getMergedNodeValues(Node, Node)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link AttrNSImpl#AttrNSImpl()}.</li>
   *   <li>Then return contains empty string.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SchemaLocationNodeValueMerge#getMergedNodeValues(Node, Node)}
   */
  @Test
  public void testGetMergedNodeValues_given42_whenAttrNSImpl_thenReturnContainsEmptyString() throws DOMException {
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
   * Test {@link SchemaLocationNodeValueMerge#getMergedNodeValues(Node, Node)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link Node} {@link Node#getNodeValue()} return {@code 42}.</li>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SchemaLocationNodeValueMerge#getMergedNodeValues(Node, Node)}
   */
  @Test
  public void testGetMergedNodeValues_given42_whenNodeGetNodeValueReturn42_thenReturnSizeIsOne() throws DOMException {
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
   * Test {@link SchemaLocationNodeValueMerge#getMergedNodeValues(Node, Node)}.
   * <ul>
   *   <li>Given {@code spring-U-9.9.xsd}.</li>
   *   <li>Then return contains {@code spring-U.xsd}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SchemaLocationNodeValueMerge#getMergedNodeValues(Node, Node)}
   */
  @Test
  public void testGetMergedNodeValues_givenSpringU99Xsd_thenReturnContainsSpringUXsd() throws DOMException {
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
   * Test {@link SchemaLocationNodeValueMerge#getSanitizedValue(String)}.
   * <ul>
   *   <li>Then return {@code 42Attribute Valuespring-U.xsd}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SchemaLocationNodeValueMerge#getSanitizedValue(String)}
   */
  @Test
  public void testGetSanitizedValue_thenReturn42AttributeValuespringUXsd() {
    // Arrange, Act and Assert
    assertEquals("42Attribute Valuespring-U.xsd",
        schemaLocationNodeValueMerge.getSanitizedValue("42Attribute Valuespring-U-9.9.xsd"));
  }

  /**
   * Test {@link SchemaLocationNodeValueMerge#getSanitizedValue(String)}.
   * <ul>
   *   <li>Then return {@code 42(spring-\w*-[0-9]\.[0-9]\.xsd)spring-U.xsd}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SchemaLocationNodeValueMerge#getSanitizedValue(String)}
   */
  @Test
  public void testGetSanitizedValue_thenReturn42SpringW0909XsdSpringUXsd() {
    // Arrange, Act and Assert
    assertEquals("42(spring-\\w*-[0-9]\\.[0-9]\\.xsd)spring-U.xsd",
        schemaLocationNodeValueMerge.getSanitizedValue("42(spring-\\w*-[0-9]\\.[0-9]\\.xsd)spring-U-9.9.xsd"));
  }

  /**
   * Test {@link SchemaLocationNodeValueMerge#getSanitizedValue(String)}.
   * <ul>
   *   <li>Then return {@code 42spring-U.xsdAttribute Value}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SchemaLocationNodeValueMerge#getSanitizedValue(String)}
   */
  @Test
  public void testGetSanitizedValue_thenReturn42springUXsdAttributeValue() {
    // Arrange, Act and Assert
    assertEquals("42spring-U.xsdAttribute Value",
        schemaLocationNodeValueMerge.getSanitizedValue("42spring-U-9.9.xsdAttribute Value"));
  }

  /**
   * Test {@link SchemaLocationNodeValueMerge#getSanitizedValue(String)}.
   * <ul>
   *   <li>Then return {@code 42spring-U.xsd(spring-\w*-[0-9]\.[0-9]\.xsd)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SchemaLocationNodeValueMerge#getSanitizedValue(String)}
   */
  @Test
  public void testGetSanitizedValue_thenReturn42springUXsdSpringW0909Xsd() {
    // Arrange, Act and Assert
    assertEquals("42spring-U.xsd(spring-\\w*-[0-9]\\.[0-9]\\.xsd)",
        schemaLocationNodeValueMerge.getSanitizedValue("42spring-U-9.9.xsd(spring-\\w*-[0-9]\\.[0-9]\\.xsd)"));
  }

  /**
   * Test {@link SchemaLocationNodeValueMerge#getSanitizedValue(String)}.
   * <ul>
   *   <li>Then return {@code 42spring-U.xsdspring-U.xsd}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SchemaLocationNodeValueMerge#getSanitizedValue(String)}
   */
  @Test
  public void testGetSanitizedValue_thenReturn42springUXsdspringUXsd() {
    // Arrange, Act and Assert
    assertEquals("42spring-U.xsdspring-U.xsd",
        schemaLocationNodeValueMerge.getSanitizedValue("42spring-U-9.9.xsdspring-U-9.9.xsd"));
  }

  /**
   * Test {@link SchemaLocationNodeValueMerge#getSanitizedValue(String)}.
   * <ul>
   *   <li>Then return {@code Attribute Value42spring-U.xsd}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SchemaLocationNodeValueMerge#getSanitizedValue(String)}
   */
  @Test
  public void testGetSanitizedValue_thenReturnAttributeValue42springUXsd() {
    // Arrange, Act and Assert
    assertEquals("Attribute Value42spring-U.xsd",
        schemaLocationNodeValueMerge.getSanitizedValue("Attribute Value42spring-U-9.9.xsd"));
  }

  /**
   * Test {@link SchemaLocationNodeValueMerge#getSanitizedValue(String)}.
   * <ul>
   *   <li>Then return {@code Attribute ValueAttribute Valuespring-U.xsd}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SchemaLocationNodeValueMerge#getSanitizedValue(String)}
   */
  @Test
  public void testGetSanitizedValue_thenReturnAttributeValueAttributeValuespringUXsd() {
    // Arrange, Act and Assert
    assertEquals("Attribute ValueAttribute Valuespring-U.xsd",
        schemaLocationNodeValueMerge.getSanitizedValue("Attribute ValueAttribute Valuespring-U-9.9.xsd"));
  }

  /**
   * Test {@link SchemaLocationNodeValueMerge#getSanitizedValue(String)}.
   * <ul>
   *   <li>Then return
   * {@code Attribute Value(spring-\w*-[0-9]\.[0-9]\.xsd)spring-U.xsd}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SchemaLocationNodeValueMerge#getSanitizedValue(String)}
   */
  @Test
  public void testGetSanitizedValue_thenReturnAttributeValueSpringW0909XsdSpringUXsd() {
    // Arrange, Act and Assert
    assertEquals("Attribute Value(spring-\\w*-[0-9]\\.[0-9]\\.xsd)spring-U.xsd", schemaLocationNodeValueMerge
        .getSanitizedValue("Attribute Value(spring-\\w*-[0-9]\\.[0-9]\\.xsd)spring-U-9.9.xsd"));
  }

  /**
   * Test {@link SchemaLocationNodeValueMerge#getSanitizedValue(String)}.
   * <ul>
   *   <li>Then return {@code Attribute Valuespring-U.xsd}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SchemaLocationNodeValueMerge#getSanitizedValue(String)}
   */
  @Test
  public void testGetSanitizedValue_thenReturnAttributeValuespringUXsd() {
    // Arrange, Act and Assert
    assertEquals("Attribute Valuespring-U.xsd",
        schemaLocationNodeValueMerge.getSanitizedValue("Attribute Valuespring-U-9.9.xsd"));
  }

  /**
   * Test {@link SchemaLocationNodeValueMerge#getSanitizedValue(String)}.
   * <ul>
   *   <li>Then return {@code Attribute Valuespring-U.xsd42}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SchemaLocationNodeValueMerge#getSanitizedValue(String)}
   */
  @Test
  public void testGetSanitizedValue_thenReturnAttributeValuespringUXsd42() {
    // Arrange, Act and Assert
    assertEquals("Attribute Valuespring-U.xsd42",
        schemaLocationNodeValueMerge.getSanitizedValue("Attribute Valuespring-U-9.9.xsd42"));
  }

  /**
   * Test {@link SchemaLocationNodeValueMerge#getSanitizedValue(String)}.
   * <ul>
   *   <li>Then return {@code Attribute Valuespring-U.xsdAttribute Value}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SchemaLocationNodeValueMerge#getSanitizedValue(String)}
   */
  @Test
  public void testGetSanitizedValue_thenReturnAttributeValuespringUXsdAttributeValue() {
    // Arrange, Act and Assert
    assertEquals("Attribute Valuespring-U.xsdAttribute Value",
        schemaLocationNodeValueMerge.getSanitizedValue("Attribute Valuespring-U-9.9.xsdAttribute Value"));
  }

  /**
   * Test {@link SchemaLocationNodeValueMerge#getSanitizedValue(String)}.
   * <ul>
   *   <li>Then return
   * {@code Attribute Valuespring-U.xsd(spring-\w*-[0-9]\.[0-9]\.xsd)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SchemaLocationNodeValueMerge#getSanitizedValue(String)}
   */
  @Test
  public void testGetSanitizedValue_thenReturnAttributeValuespringUXsdSpringW0909Xsd() {
    // Arrange, Act and Assert
    assertEquals("Attribute Valuespring-U.xsd(spring-\\w*-[0-9]\\.[0-9]\\.xsd)", schemaLocationNodeValueMerge
        .getSanitizedValue("Attribute Valuespring-U-9.9.xsd(spring-\\w*-[0-9]\\.[0-9]\\.xsd)"));
  }

  /**
   * Test {@link SchemaLocationNodeValueMerge#getSanitizedValue(String)}.
   * <ul>
   *   <li>Then return {@code Attribute Valuespring-U.xsdspring-U.xsd}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SchemaLocationNodeValueMerge#getSanitizedValue(String)}
   */
  @Test
  public void testGetSanitizedValue_thenReturnAttributeValuespringUXsdspringUXsd() {
    // Arrange, Act and Assert
    assertEquals("Attribute Valuespring-U.xsdspring-U.xsd",
        schemaLocationNodeValueMerge.getSanitizedValue("Attribute Valuespring-U-9.9.xsdspring-U-9.9.xsd"));
  }

  /**
   * Test {@link SchemaLocationNodeValueMerge#getSanitizedValue(String)}.
   * <ul>
   *   <li>Then return {@code spring-U.xsd42Attribute Value}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SchemaLocationNodeValueMerge#getSanitizedValue(String)}
   */
  @Test
  public void testGetSanitizedValue_thenReturnSpringUXsd42AttributeValue() {
    // Arrange, Act and Assert
    assertEquals("spring-U.xsd42Attribute Value",
        schemaLocationNodeValueMerge.getSanitizedValue("spring-U-9.9.xsd42Attribute Value"));
  }

  /**
   * Test {@link SchemaLocationNodeValueMerge#getSanitizedValue(String)}.
   * <ul>
   *   <li>Then return {@code spring-U.xsd42(spring-\w*-[0-9]\.[0-9]\.xsd)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SchemaLocationNodeValueMerge#getSanitizedValue(String)}
   */
  @Test
  public void testGetSanitizedValue_thenReturnSpringUXsd42SpringW0909Xsd() {
    // Arrange, Act and Assert
    assertEquals("spring-U.xsd42(spring-\\w*-[0-9]\\.[0-9]\\.xsd)",
        schemaLocationNodeValueMerge.getSanitizedValue("spring-U-9.9.xsd42(spring-\\w*-[0-9]\\.[0-9]\\.xsd)"));
  }

  /**
   * Test {@link SchemaLocationNodeValueMerge#getSanitizedValue(String)}.
   * <ul>
   *   <li>Then return {@code spring-U.xsd42spring-U.xsd}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SchemaLocationNodeValueMerge#getSanitizedValue(String)}
   */
  @Test
  public void testGetSanitizedValue_thenReturnSpringUXsd42springUXsd() {
    // Arrange, Act and Assert
    assertEquals("spring-U.xsd42spring-U.xsd",
        schemaLocationNodeValueMerge.getSanitizedValue("spring-U-9.9.xsd42spring-U-9.9.xsd"));
  }

  /**
   * Test {@link SchemaLocationNodeValueMerge#getSanitizedValue(String)}.
   * <ul>
   *   <li>Then return {@code spring-U.xsdAttribute Value}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SchemaLocationNodeValueMerge#getSanitizedValue(String)}
   */
  @Test
  public void testGetSanitizedValue_thenReturnSpringUXsdAttributeValue() {
    // Arrange, Act and Assert
    assertEquals("spring-U.xsdAttribute Value",
        schemaLocationNodeValueMerge.getSanitizedValue("spring-U-9.9.xsdAttribute Value"));
  }

  /**
   * Test {@link SchemaLocationNodeValueMerge#getSanitizedValue(String)}.
   * <ul>
   *   <li>Then return {@code spring-U.xsdAttribute Value42}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SchemaLocationNodeValueMerge#getSanitizedValue(String)}
   */
  @Test
  public void testGetSanitizedValue_thenReturnSpringUXsdAttributeValue42() {
    // Arrange, Act and Assert
    assertEquals("spring-U.xsdAttribute Value42",
        schemaLocationNodeValueMerge.getSanitizedValue("spring-U-9.9.xsdAttribute Value42"));
  }

  /**
   * Test {@link SchemaLocationNodeValueMerge#getSanitizedValue(String)}.
   * <ul>
   *   <li>Then return {@code spring-U.xsdAttribute ValueAttribute Value}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SchemaLocationNodeValueMerge#getSanitizedValue(String)}
   */
  @Test
  public void testGetSanitizedValue_thenReturnSpringUXsdAttributeValueAttributeValue() {
    // Arrange, Act and Assert
    assertEquals("spring-U.xsdAttribute ValueAttribute Value",
        schemaLocationNodeValueMerge.getSanitizedValue("spring-U-9.9.xsdAttribute ValueAttribute Value"));
  }

  /**
   * Test {@link SchemaLocationNodeValueMerge#getSanitizedValue(String)}.
   * <ul>
   *   <li>Then return
   * {@code spring-U.xsdAttribute Value(spring-\w*-[0-9]\.[0-9]\.xsd)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SchemaLocationNodeValueMerge#getSanitizedValue(String)}
   */
  @Test
  public void testGetSanitizedValue_thenReturnSpringUXsdAttributeValueSpringW0909Xsd() {
    // Arrange, Act and Assert
    assertEquals("spring-U.xsdAttribute Value(spring-\\w*-[0-9]\\.[0-9]\\.xsd)", schemaLocationNodeValueMerge
        .getSanitizedValue("spring-U-9.9.xsdAttribute Value(spring-\\w*-[0-9]\\.[0-9]\\.xsd)"));
  }

  /**
   * Test {@link SchemaLocationNodeValueMerge#getSanitizedValue(String)}.
   * <ul>
   *   <li>Then return {@code spring-U.xsdAttribute Valuespring-U.xsd}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SchemaLocationNodeValueMerge#getSanitizedValue(String)}
   */
  @Test
  public void testGetSanitizedValue_thenReturnSpringUXsdAttributeValuespringUXsd() {
    // Arrange, Act and Assert
    assertEquals("spring-U.xsdAttribute Valuespring-U.xsd",
        schemaLocationNodeValueMerge.getSanitizedValue("spring-U-9.9.xsdAttribute Valuespring-U-9.9.xsd"));
  }

  /**
   * Test {@link SchemaLocationNodeValueMerge#getSanitizedValue(String)}.
   * <ul>
   *   <li>Then return {@code spring-U.xsd(spring-\w*-[0-9]\.[0-9]\.xsd)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SchemaLocationNodeValueMerge#getSanitizedValue(String)}
   */
  @Test
  public void testGetSanitizedValue_thenReturnSpringUXsdSpringW0909Xsd() {
    // Arrange, Act and Assert
    assertEquals("spring-U.xsd(spring-\\w*-[0-9]\\.[0-9]\\.xsd)",
        schemaLocationNodeValueMerge.getSanitizedValue("spring-U-9.9.xsd(spring-\\w*-[0-9]\\.[0-9]\\.xsd)"));
  }

  /**
   * Test {@link SchemaLocationNodeValueMerge#getSanitizedValue(String)}.
   * <ul>
   *   <li>Then return {@code spring-U.xsd(spring-\w*-[0-9]\.[0-9]\.xsd)42}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SchemaLocationNodeValueMerge#getSanitizedValue(String)}
   */
  @Test
  public void testGetSanitizedValue_thenReturnSpringUXsdSpringW0909Xsd42() {
    // Arrange, Act and Assert
    assertEquals("spring-U.xsd(spring-\\w*-[0-9]\\.[0-9]\\.xsd)42",
        schemaLocationNodeValueMerge.getSanitizedValue("spring-U-9.9.xsd(spring-\\w*-[0-9]\\.[0-9]\\.xsd)42"));
  }

  /**
   * Test {@link SchemaLocationNodeValueMerge#getSanitizedValue(String)}.
   * <ul>
   *   <li>Then return
   * {@code spring-U.xsd(spring-\w*-[0-9]\.[0-9]\.xsd)Attribute Value}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SchemaLocationNodeValueMerge#getSanitizedValue(String)}
   */
  @Test
  public void testGetSanitizedValue_thenReturnSpringUXsdSpringW0909XsdAttributeValue() {
    // Arrange, Act and Assert
    assertEquals("spring-U.xsd(spring-\\w*-[0-9]\\.[0-9]\\.xsd)Attribute Value", schemaLocationNodeValueMerge
        .getSanitizedValue("spring-U-9.9.xsd(spring-\\w*-[0-9]\\.[0-9]\\.xsd)Attribute Value"));
  }

  /**
   * Test {@link SchemaLocationNodeValueMerge#getSanitizedValue(String)}.
   * <ul>
   *   <li>Then return
   * {@code spring-U.xsd(spring-\w*-[0-9]\.[0-9]\.xsd)spring-U.xsd}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SchemaLocationNodeValueMerge#getSanitizedValue(String)}
   */
  @Test
  public void testGetSanitizedValue_thenReturnSpringUXsdSpringW0909XsdSpringUXsd() {
    // Arrange, Act and Assert
    assertEquals("spring-U.xsd(spring-\\w*-[0-9]\\.[0-9]\\.xsd)spring-U.xsd", schemaLocationNodeValueMerge
        .getSanitizedValue("spring-U-9.9.xsd(spring-\\w*-[0-9]\\.[0-9]\\.xsd)spring-U-9.9.xsd"));
  }

  /**
   * Test {@link SchemaLocationNodeValueMerge#getSanitizedValue(String)}.
   * <ul>
   *   <li>Then return
   * {@code spring-U.xsd(spring-\w*-[0-9]\.[0-9]\.xsd)(spring-\w*-[0-9]\.[0-9]\.xsd)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SchemaLocationNodeValueMerge#getSanitizedValue(String)}
   */
  @Test
  public void testGetSanitizedValue_thenReturnSpringUXsdSpringW0909XsdSpringW0909Xsd() {
    // Arrange, Act and Assert
    assertEquals("spring-U.xsd(spring-\\w*-[0-9]\\.[0-9]\\.xsd)(spring-\\w*-[0-9]\\.[0-9]\\.xsd)",
        schemaLocationNodeValueMerge
            .getSanitizedValue("spring-U-9.9.xsd(spring-\\w*-[0-9]\\.[0-9]\\.xsd)(spring-\\w*-[0-9]\\.[0-9]\\.xsd)"));
  }

  /**
   * Test {@link SchemaLocationNodeValueMerge#getSanitizedValue(String)}.
   * <ul>
   *   <li>Then return {@code spring-U.xsdspring-U.xsd}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SchemaLocationNodeValueMerge#getSanitizedValue(String)}
   */
  @Test
  public void testGetSanitizedValue_thenReturnSpringUXsdspringUXsd() {
    // Arrange, Act and Assert
    assertEquals("spring-U.xsdspring-U.xsd",
        schemaLocationNodeValueMerge.getSanitizedValue("spring-U-9.9.xsdspring-U-9.9.xsd"));
  }

  /**
   * Test {@link SchemaLocationNodeValueMerge#getSanitizedValue(String)}.
   * <ul>
   *   <li>Then return {@code spring-U.xsdspring-U.xsd42}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SchemaLocationNodeValueMerge#getSanitizedValue(String)}
   */
  @Test
  public void testGetSanitizedValue_thenReturnSpringUXsdspringUXsd42() {
    // Arrange, Act and Assert
    assertEquals("spring-U.xsdspring-U.xsd42",
        schemaLocationNodeValueMerge.getSanitizedValue("spring-U-9.9.xsdspring-U-9.9.xsd42"));
  }

  /**
   * Test {@link SchemaLocationNodeValueMerge#getSanitizedValue(String)}.
   * <ul>
   *   <li>Then return {@code spring-U.xsdspring-U.xsdAttribute Value}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SchemaLocationNodeValueMerge#getSanitizedValue(String)}
   */
  @Test
  public void testGetSanitizedValue_thenReturnSpringUXsdspringUXsdAttributeValue() {
    // Arrange, Act and Assert
    assertEquals("spring-U.xsdspring-U.xsdAttribute Value",
        schemaLocationNodeValueMerge.getSanitizedValue("spring-U-9.9.xsdspring-U-9.9.xsdAttribute Value"));
  }

  /**
   * Test {@link SchemaLocationNodeValueMerge#getSanitizedValue(String)}.
   * <ul>
   *   <li>Then return
   * {@code spring-U.xsdspring-U.xsd(spring-\w*-[0-9]\.[0-9]\.xsd)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SchemaLocationNodeValueMerge#getSanitizedValue(String)}
   */
  @Test
  public void testGetSanitizedValue_thenReturnSpringUXsdspringUXsdSpringW0909Xsd() {
    // Arrange, Act and Assert
    assertEquals("spring-U.xsdspring-U.xsd(spring-\\w*-[0-9]\\.[0-9]\\.xsd)", schemaLocationNodeValueMerge
        .getSanitizedValue("spring-U-9.9.xsdspring-U-9.9.xsd(spring-\\w*-[0-9]\\.[0-9]\\.xsd)"));
  }

  /**
   * Test {@link SchemaLocationNodeValueMerge#getSanitizedValue(String)}.
   * <ul>
   *   <li>Then return {@code spring-U.xsdspring-U.xsdspring-U.xsd}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SchemaLocationNodeValueMerge#getSanitizedValue(String)}
   */
  @Test
  public void testGetSanitizedValue_thenReturnSpringUXsdspringUXsdspringUXsd() {
    // Arrange, Act and Assert
    assertEquals("spring-U.xsdspring-U.xsdspring-U.xsd",
        schemaLocationNodeValueMerge.getSanitizedValue("spring-U-9.9.xsdspring-U-9.9.xsdspring-U-9.9.xsd"));
  }

  /**
   * Test {@link SchemaLocationNodeValueMerge#getSanitizedValue(String)}.
   * <ul>
   *   <li>Then return {@code (spring-\w*-[0-9]\.[0-9]\.xsd)42spring-U.xsd}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SchemaLocationNodeValueMerge#getSanitizedValue(String)}
   */
  @Test
  public void testGetSanitizedValue_thenReturnSpringW0909Xsd42springUXsd() {
    // Arrange, Act and Assert
    assertEquals("(spring-\\w*-[0-9]\\.[0-9]\\.xsd)42spring-U.xsd",
        schemaLocationNodeValueMerge.getSanitizedValue("(spring-\\w*-[0-9]\\.[0-9]\\.xsd)42spring-U-9.9.xsd"));
  }

  /**
   * Test {@link SchemaLocationNodeValueMerge#getSanitizedValue(String)}.
   * <ul>
   *   <li>Then return
   * {@code (spring-\w*-[0-9]\.[0-9]\.xsd)Attribute Valuespring-U.xsd}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SchemaLocationNodeValueMerge#getSanitizedValue(String)}
   */
  @Test
  public void testGetSanitizedValue_thenReturnSpringW0909XsdAttributeValuespringUXsd() {
    // Arrange, Act and Assert
    assertEquals("(spring-\\w*-[0-9]\\.[0-9]\\.xsd)Attribute Valuespring-U.xsd", schemaLocationNodeValueMerge
        .getSanitizedValue("(spring-\\w*-[0-9]\\.[0-9]\\.xsd)Attribute Valuespring-U-9.9.xsd"));
  }

  /**
   * Test {@link SchemaLocationNodeValueMerge#getSanitizedValue(String)}.
   * <ul>
   *   <li>Then return {@code (spring-\w*-[0-9]\.[0-9]\.xsd)spring-U.xsd}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SchemaLocationNodeValueMerge#getSanitizedValue(String)}
   */
  @Test
  public void testGetSanitizedValue_thenReturnSpringW0909XsdSpringUXsd() {
    // Arrange, Act and Assert
    assertEquals("(spring-\\w*-[0-9]\\.[0-9]\\.xsd)spring-U.xsd",
        schemaLocationNodeValueMerge.getSanitizedValue("(spring-\\w*-[0-9]\\.[0-9]\\.xsd)spring-U-9.9.xsd"));
  }

  /**
   * Test {@link SchemaLocationNodeValueMerge#getSanitizedValue(String)}.
   * <ul>
   *   <li>Then return {@code (spring-\w*-[0-9]\.[0-9]\.xsd)spring-U.xsd42}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SchemaLocationNodeValueMerge#getSanitizedValue(String)}
   */
  @Test
  public void testGetSanitizedValue_thenReturnSpringW0909XsdSpringUXsd42() {
    // Arrange, Act and Assert
    assertEquals("(spring-\\w*-[0-9]\\.[0-9]\\.xsd)spring-U.xsd42",
        schemaLocationNodeValueMerge.getSanitizedValue("(spring-\\w*-[0-9]\\.[0-9]\\.xsd)spring-U-9.9.xsd42"));
  }

  /**
   * Test {@link SchemaLocationNodeValueMerge#getSanitizedValue(String)}.
   * <ul>
   *   <li>Then return
   * {@code (spring-\w*-[0-9]\.[0-9]\.xsd)spring-U.xsdAttribute Value}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SchemaLocationNodeValueMerge#getSanitizedValue(String)}
   */
  @Test
  public void testGetSanitizedValue_thenReturnSpringW0909XsdSpringUXsdAttributeValue() {
    // Arrange, Act and Assert
    assertEquals("(spring-\\w*-[0-9]\\.[0-9]\\.xsd)spring-U.xsdAttribute Value", schemaLocationNodeValueMerge
        .getSanitizedValue("(spring-\\w*-[0-9]\\.[0-9]\\.xsd)spring-U-9.9.xsdAttribute Value"));
  }

  /**
   * Test {@link SchemaLocationNodeValueMerge#getSanitizedValue(String)}.
   * <ul>
   *   <li>Then return
   * {@code (spring-\w*-[0-9]\.[0-9]\.xsd)spring-U.xsd(spring-\w*-[0-9]\.[0-9]\.xsd)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SchemaLocationNodeValueMerge#getSanitizedValue(String)}
   */
  @Test
  public void testGetSanitizedValue_thenReturnSpringW0909XsdSpringUXsdSpringW0909Xsd() {
    // Arrange, Act and Assert
    assertEquals("(spring-\\w*-[0-9]\\.[0-9]\\.xsd)spring-U.xsd(spring-\\w*-[0-9]\\.[0-9]\\.xsd)",
        schemaLocationNodeValueMerge
            .getSanitizedValue("(spring-\\w*-[0-9]\\.[0-9]\\.xsd)spring-U-9.9.xsd(spring-\\w*-[0-9]\\.[0-9]\\.xsd)"));
  }

  /**
   * Test {@link SchemaLocationNodeValueMerge#getSanitizedValue(String)}.
   * <ul>
   *   <li>Then return
   * {@code (spring-\w*-[0-9]\.[0-9]\.xsd)spring-U.xsdspring-U.xsd}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SchemaLocationNodeValueMerge#getSanitizedValue(String)}
   */
  @Test
  public void testGetSanitizedValue_thenReturnSpringW0909XsdSpringUXsdspringUXsd() {
    // Arrange, Act and Assert
    assertEquals("(spring-\\w*-[0-9]\\.[0-9]\\.xsd)spring-U.xsdspring-U.xsd", schemaLocationNodeValueMerge
        .getSanitizedValue("(spring-\\w*-[0-9]\\.[0-9]\\.xsd)spring-U-9.9.xsdspring-U-9.9.xsd"));
  }

  /**
   * Test {@link SchemaLocationNodeValueMerge#getSanitizedValue(String)}.
   * <ul>
   *   <li>Then return
   * {@code (spring-\w*-[0-9]\.[0-9]\.xsd)(spring-\w*-[0-9]\.[0-9]\.xsd)spring-U.xsd}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SchemaLocationNodeValueMerge#getSanitizedValue(String)}
   */
  @Test
  public void testGetSanitizedValue_thenReturnSpringW0909XsdSpringW0909XsdSpringUXsd() {
    // Arrange, Act and Assert
    assertEquals("(spring-\\w*-[0-9]\\.[0-9]\\.xsd)(spring-\\w*-[0-9]\\.[0-9]\\.xsd)spring-U.xsd",
        schemaLocationNodeValueMerge
            .getSanitizedValue("(spring-\\w*-[0-9]\\.[0-9]\\.xsd)(spring-\\w*-[0-9]\\.[0-9]\\.xsd)spring-U-9.9.xsd"));
  }

  /**
   * Test {@link SchemaLocationNodeValueMerge#getSanitizedValue(String)}.
   * <ul>
   *   <li>When {@code 42}.</li>
   *   <li>Then return {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SchemaLocationNodeValueMerge#getSanitizedValue(String)}
   */
  @Test
  public void testGetSanitizedValue_when42_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("42", schemaLocationNodeValueMerge.getSanitizedValue("42"));
  }

  /**
   * Test {@link SchemaLocationNodeValueMerge#getSanitizedValue(String)}.
   * <ul>
   *   <li>When {@code 42spring-U-9.9.xsd42}.</li>
   *   <li>Then return {@code 42spring-U.xsd42}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SchemaLocationNodeValueMerge#getSanitizedValue(String)}
   */
  @Test
  public void testGetSanitizedValue_when42springU99Xsd42_thenReturn42springUXsd42() {
    // Arrange, Act and Assert
    assertEquals("42spring-U.xsd42", schemaLocationNodeValueMerge.getSanitizedValue("42spring-U-9.9.xsd42"));
  }

  /**
   * Test {@link SchemaLocationNodeValueMerge#getSanitizedValue(String)}.
   * <ul>
   *   <li>When {@code 42spring-U-9.9.xsd}.</li>
   *   <li>Then return {@code 42spring-U.xsd}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SchemaLocationNodeValueMerge#getSanitizedValue(String)}
   */
  @Test
  public void testGetSanitizedValue_when42springU99Xsd_thenReturn42springUXsd() {
    // Arrange, Act and Assert
    assertEquals("42spring-U.xsd", schemaLocationNodeValueMerge.getSanitizedValue("42spring-U-9.9.xsd"));
  }

  /**
   * Test {@link SchemaLocationNodeValueMerge#getSanitizedValue(String)}.
   * <ul>
   *   <li>When {@code 4242spring-U-9.9.xsd}.</li>
   *   <li>Then return {@code 4242spring-U.xsd}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SchemaLocationNodeValueMerge#getSanitizedValue(String)}
   */
  @Test
  public void testGetSanitizedValue_when4242springU99Xsd_thenReturn4242springUXsd() {
    // Arrange, Act and Assert
    assertEquals("4242spring-U.xsd", schemaLocationNodeValueMerge.getSanitizedValue("4242spring-U-9.9.xsd"));
  }

  /**
   * Test {@link SchemaLocationNodeValueMerge#getSanitizedValue(String)}.
   * <ul>
   *   <li>When {@code spring-U-9.9.xsd42}.</li>
   *   <li>Then return {@code spring-U.xsd42}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SchemaLocationNodeValueMerge#getSanitizedValue(String)}
   */
  @Test
  public void testGetSanitizedValue_whenSpringU99Xsd42_thenReturnSpringUXsd42() {
    // Arrange, Act and Assert
    assertEquals("spring-U.xsd42", schemaLocationNodeValueMerge.getSanitizedValue("spring-U-9.9.xsd42"));
  }

  /**
   * Test {@link SchemaLocationNodeValueMerge#getSanitizedValue(String)}.
   * <ul>
   *   <li>When {@code spring-U-9.9.xsd4242}.</li>
   *   <li>Then return {@code spring-U.xsd4242}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SchemaLocationNodeValueMerge#getSanitizedValue(String)}
   */
  @Test
  public void testGetSanitizedValue_whenSpringU99Xsd4242_thenReturnSpringUXsd4242() {
    // Arrange, Act and Assert
    assertEquals("spring-U.xsd4242", schemaLocationNodeValueMerge.getSanitizedValue("spring-U-9.9.xsd4242"));
  }

  /**
   * Test {@link SchemaLocationNodeValueMerge#getSanitizedValue(String)}.
   * <ul>
   *   <li>When {@code spring-U-9.9.xsd}.</li>
   *   <li>Then return {@code spring-U.xsd}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SchemaLocationNodeValueMerge#getSanitizedValue(String)}
   */
  @Test
  public void testGetSanitizedValue_whenSpringU99Xsd_thenReturnSpringUXsd() {
    // Arrange, Act and Assert
    assertEquals("spring-U.xsd", schemaLocationNodeValueMerge.getSanitizedValue("spring-U-9.9.xsd"));
  }

  /**
   * Test new {@link SchemaLocationNodeValueMerge} (default constructor).
   * <p>
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
