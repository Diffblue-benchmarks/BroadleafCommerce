package org.broadleafcommerce.common.extensibility.context.merge.handlers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Set;
import javax.imageio.metadata.IIOMetadataNode;
import org.apache.xerces.dom.AttrNSImpl;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.w3c.dom.Node;

@ContextConfiguration(classes = {SchemaLocationNodeValueMerge.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class SchemaLocationNodeValueMergeDiffblueTest {
  @Autowired private SchemaLocationNodeValueMerge schemaLocationNodeValueMerge;

  /**
   * Test {@link SchemaLocationNodeValueMerge#getMergedNodeValues(Node, Node)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>Then return contains {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link SchemaLocationNodeValueMerge#getMergedNodeValues(Node, Node)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Set SchemaLocationNodeValueMerge.getMergedNodeValues(Node, Node)"})
  public void testGetMergedNodeValues_given42_thenReturnContains42() {
    // Arrange
    SchemaLocationNodeValueMerge schemaLocationNodeValueMerge = new SchemaLocationNodeValueMerge();
    AttrNSImpl node1 = new AttrNSImpl();

    IIOMetadataNode node2 = new IIOMetadataNode();
    node2.setNodeValue("42");

    // Act
    Set<String> actualMergedNodeValues =
        schemaLocationNodeValueMerge.getMergedNodeValues(node1, node2);

    // Assert
    assertEquals(2, actualMergedNodeValues.size());
    assertTrue(actualMergedNodeValues.contains(""));
    assertTrue(actualMergedNodeValues.contains("42"));
  }

  /**
   * Test {@link SchemaLocationNodeValueMerge#getMergedNodeValues(Node, Node)}.
   *
   * <ul>
   *   <li>Given {@code spring-UU-4.4.xsd}.
   *   <li>Then return contains {@code spring-UU.xsd}.
   * </ul>
   *
   * <p>Method under test: {@link SchemaLocationNodeValueMerge#getMergedNodeValues(Node, Node)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Set SchemaLocationNodeValueMerge.getMergedNodeValues(Node, Node)"})
  public void testGetMergedNodeValues_givenSpringUu44Xsd_thenReturnContainsSpringUuXsd() {
    // Arrange
    SchemaLocationNodeValueMerge schemaLocationNodeValueMerge = new SchemaLocationNodeValueMerge();
    AttrNSImpl node1 = new AttrNSImpl();

    IIOMetadataNode node2 = new IIOMetadataNode();
    node2.setNodeValue("spring-UU-4.4.xsd");

    // Act
    Set<String> actualMergedNodeValues =
        schemaLocationNodeValueMerge.getMergedNodeValues(node1, node2);

    // Assert
    assertEquals(2, actualMergedNodeValues.size());
    assertTrue(actualMergedNodeValues.contains(""));
    assertTrue(actualMergedNodeValues.contains("spring-UU.xsd"));
  }

  /**
   * Test {@link SchemaLocationNodeValueMerge#getMergedNodeValues(Node, Node)}.
   *
   * <ul>
   *   <li>When {@link AttrNSImpl#AttrNSImpl()}.
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link SchemaLocationNodeValueMerge#getMergedNodeValues(Node, Node)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Set SchemaLocationNodeValueMerge.getMergedNodeValues(Node, Node)"})
  public void testGetMergedNodeValues_whenAttrNSImpl_thenReturnSizeIsOne() {
    // Arrange
    SchemaLocationNodeValueMerge schemaLocationNodeValueMerge = new SchemaLocationNodeValueMerge();
    AttrNSImpl node1 = new AttrNSImpl();

    // Act
    Set<String> actualMergedNodeValues =
        schemaLocationNodeValueMerge.getMergedNodeValues(node1, new AttrNSImpl());

    // Assert
    assertEquals(1, actualMergedNodeValues.size());
    assertTrue(actualMergedNodeValues.contains(""));
  }

  /**
   * Test {@link SchemaLocationNodeValueMerge#getSanitizedValue(String)}.
   *
   * <ul>
   *   <li>Then return {@code 42Attribute Valuespring-UU.xsd}.
   * </ul>
   *
   * <p>Method under test: {@link SchemaLocationNodeValueMerge#getSanitizedValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SchemaLocationNodeValueMerge.getSanitizedValue(String)"})
  public void testGetSanitizedValue_thenReturn42AttributeValuespringUuXsd() {
    // Arrange, Act and Assert
    assertEquals(
        "42Attribute Valuespring-UU.xsd",
        schemaLocationNodeValueMerge.getSanitizedValue("42Attribute Valuespring-UU-4.4.xsd"));
  }

  /**
   * Test {@link SchemaLocationNodeValueMerge#getSanitizedValue(String)}.
   *
   * <ul>
   *   <li>Then return {@code 42(spring-\w*-[0-9]\.[0-9]\.xsd)spring-UU.xsd}.
   * </ul>
   *
   * <p>Method under test: {@link SchemaLocationNodeValueMerge#getSanitizedValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SchemaLocationNodeValueMerge.getSanitizedValue(String)"})
  public void testGetSanitizedValue_thenReturn42SpringW0909XsdSpringUuXsd() {
    // Arrange, Act and Assert
    assertEquals(
        "42(spring-\\w*-[0-9]\\.[0-9]\\.xsd)spring-UU.xsd",
        schemaLocationNodeValueMerge.getSanitizedValue(
            "42(spring-\\w*-[0-9]\\.[0-9]\\.xsd)spring-UU-4.4.xsd"));
  }

  /**
   * Test {@link SchemaLocationNodeValueMerge#getSanitizedValue(String)}.
   *
   * <ul>
   *   <li>Then return {@code 42spring-UU.xsdAttribute Value}.
   * </ul>
   *
   * <p>Method under test: {@link SchemaLocationNodeValueMerge#getSanitizedValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SchemaLocationNodeValueMerge.getSanitizedValue(String)"})
  public void testGetSanitizedValue_thenReturn42springUuXsdAttributeValue() {
    // Arrange, Act and Assert
    assertEquals(
        "42spring-UU.xsdAttribute Value",
        schemaLocationNodeValueMerge.getSanitizedValue("42spring-UU-4.4.xsdAttribute Value"));
  }

  /**
   * Test {@link SchemaLocationNodeValueMerge#getSanitizedValue(String)}.
   *
   * <ul>
   *   <li>Then return {@code 42spring-UU.xsd(spring-\w*-[0-9]\.[0-9]\.xsd)}.
   * </ul>
   *
   * <p>Method under test: {@link SchemaLocationNodeValueMerge#getSanitizedValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SchemaLocationNodeValueMerge.getSanitizedValue(String)"})
  public void testGetSanitizedValue_thenReturn42springUuXsdSpringW0909Xsd() {
    // Arrange, Act and Assert
    assertEquals(
        "42spring-UU.xsd(spring-\\w*-[0-9]\\.[0-9]\\.xsd)",
        schemaLocationNodeValueMerge.getSanitizedValue(
            "42spring-UU-4.4.xsd(spring-\\w*-[0-9]\\.[0-9]\\.xsd)"));
  }

  /**
   * Test {@link SchemaLocationNodeValueMerge#getSanitizedValue(String)}.
   *
   * <ul>
   *   <li>Then return {@code 42spring-UU.xsdspring-UU.xsd}.
   * </ul>
   *
   * <p>Method under test: {@link SchemaLocationNodeValueMerge#getSanitizedValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SchemaLocationNodeValueMerge.getSanitizedValue(String)"})
  public void testGetSanitizedValue_thenReturn42springUuXsdspringUuXsd() {
    // Arrange, Act and Assert
    assertEquals(
        "42spring-UU.xsdspring-UU.xsd",
        schemaLocationNodeValueMerge.getSanitizedValue("42spring-UU-4.4.xsdspring-UU-4.4.xsd"));
  }

  /**
   * Test {@link SchemaLocationNodeValueMerge#getSanitizedValue(String)}.
   *
   * <ul>
   *   <li>Then return {@code Attribute Value42spring-UU.xsd}.
   * </ul>
   *
   * <p>Method under test: {@link SchemaLocationNodeValueMerge#getSanitizedValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SchemaLocationNodeValueMerge.getSanitizedValue(String)"})
  public void testGetSanitizedValue_thenReturnAttributeValue42springUuXsd() {
    // Arrange, Act and Assert
    assertEquals(
        "Attribute Value42spring-UU.xsd",
        schemaLocationNodeValueMerge.getSanitizedValue("Attribute Value42spring-UU-4.4.xsd"));
  }

  /**
   * Test {@link SchemaLocationNodeValueMerge#getSanitizedValue(String)}.
   *
   * <ul>
   *   <li>Then return {@code Attribute ValueAttribute Valuespring-UU.xsd}.
   * </ul>
   *
   * <p>Method under test: {@link SchemaLocationNodeValueMerge#getSanitizedValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SchemaLocationNodeValueMerge.getSanitizedValue(String)"})
  public void testGetSanitizedValue_thenReturnAttributeValueAttributeValuespringUuXsd() {
    // Arrange, Act and Assert
    assertEquals(
        "Attribute ValueAttribute Valuespring-UU.xsd",
        schemaLocationNodeValueMerge.getSanitizedValue(
            "Attribute ValueAttribute Valuespring-UU-4.4.xsd"));
  }

  /**
   * Test {@link SchemaLocationNodeValueMerge#getSanitizedValue(String)}.
   *
   * <ul>
   *   <li>Then return {@code Attribute Value(spring-\w*-[0-9]\.[0-9]\.xsd)spring-UU.xsd}.
   * </ul>
   *
   * <p>Method under test: {@link SchemaLocationNodeValueMerge#getSanitizedValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SchemaLocationNodeValueMerge.getSanitizedValue(String)"})
  public void testGetSanitizedValue_thenReturnAttributeValueSpringW0909XsdSpringUuXsd() {
    // Arrange, Act and Assert
    assertEquals(
        "Attribute Value(spring-\\w*-[0-9]\\.[0-9]\\.xsd)spring-UU.xsd",
        schemaLocationNodeValueMerge.getSanitizedValue(
            "Attribute Value(spring-\\w*-[0-9]\\.[0-9]\\.xsd)spring-UU-4.4.xsd"));
  }

  /**
   * Test {@link SchemaLocationNodeValueMerge#getSanitizedValue(String)}.
   *
   * <ul>
   *   <li>Then return {@code Attribute Valuespring-UU.xsd}.
   * </ul>
   *
   * <p>Method under test: {@link SchemaLocationNodeValueMerge#getSanitizedValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SchemaLocationNodeValueMerge.getSanitizedValue(String)"})
  public void testGetSanitizedValue_thenReturnAttributeValuespringUuXsd() {
    // Arrange, Act and Assert
    assertEquals(
        "Attribute Valuespring-UU.xsd",
        schemaLocationNodeValueMerge.getSanitizedValue("Attribute Valuespring-UU-4.4.xsd"));
  }

  /**
   * Test {@link SchemaLocationNodeValueMerge#getSanitizedValue(String)}.
   *
   * <ul>
   *   <li>Then return {@code Attribute Valuespring-UU.xsd42}.
   * </ul>
   *
   * <p>Method under test: {@link SchemaLocationNodeValueMerge#getSanitizedValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SchemaLocationNodeValueMerge.getSanitizedValue(String)"})
  public void testGetSanitizedValue_thenReturnAttributeValuespringUuXsd42() {
    // Arrange, Act and Assert
    assertEquals(
        "Attribute Valuespring-UU.xsd42",
        schemaLocationNodeValueMerge.getSanitizedValue("Attribute Valuespring-UU-4.4.xsd42"));
  }

  /**
   * Test {@link SchemaLocationNodeValueMerge#getSanitizedValue(String)}.
   *
   * <ul>
   *   <li>Then return {@code Attribute Valuespring-UU.xsdAttribute Value}.
   * </ul>
   *
   * <p>Method under test: {@link SchemaLocationNodeValueMerge#getSanitizedValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SchemaLocationNodeValueMerge.getSanitizedValue(String)"})
  public void testGetSanitizedValue_thenReturnAttributeValuespringUuXsdAttributeValue() {
    // Arrange, Act and Assert
    assertEquals(
        "Attribute Valuespring-UU.xsdAttribute Value",
        schemaLocationNodeValueMerge.getSanitizedValue(
            "Attribute Valuespring-UU-4.4.xsdAttribute Value"));
  }

  /**
   * Test {@link SchemaLocationNodeValueMerge#getSanitizedValue(String)}.
   *
   * <ul>
   *   <li>Then return {@code Attribute Valuespring-UU.xsd(spring-\w*-[0-9]\.[0-9]\.xsd)}.
   * </ul>
   *
   * <p>Method under test: {@link SchemaLocationNodeValueMerge#getSanitizedValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SchemaLocationNodeValueMerge.getSanitizedValue(String)"})
  public void testGetSanitizedValue_thenReturnAttributeValuespringUuXsdSpringW0909Xsd() {
    // Arrange, Act and Assert
    assertEquals(
        "Attribute Valuespring-UU.xsd(spring-\\w*-[0-9]\\.[0-9]\\.xsd)",
        schemaLocationNodeValueMerge.getSanitizedValue(
            "Attribute Valuespring-UU-4.4.xsd(spring-\\w*-[0-9]\\.[0-9]\\.xsd)"));
  }

  /**
   * Test {@link SchemaLocationNodeValueMerge#getSanitizedValue(String)}.
   *
   * <ul>
   *   <li>Then return {@code Attribute Valuespring-UU.xsdspring-UU.xsd}.
   * </ul>
   *
   * <p>Method under test: {@link SchemaLocationNodeValueMerge#getSanitizedValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SchemaLocationNodeValueMerge.getSanitizedValue(String)"})
  public void testGetSanitizedValue_thenReturnAttributeValuespringUuXsdspringUuXsd() {
    // Arrange, Act and Assert
    assertEquals(
        "Attribute Valuespring-UU.xsdspring-UU.xsd",
        schemaLocationNodeValueMerge.getSanitizedValue(
            "Attribute Valuespring-UU-4.4.xsdspring-UU-4.4.xsd"));
  }

  /**
   * Test {@link SchemaLocationNodeValueMerge#getSanitizedValue(String)}.
   *
   * <ul>
   *   <li>Then return {@code spring-UU.xsd42Attribute Value}.
   * </ul>
   *
   * <p>Method under test: {@link SchemaLocationNodeValueMerge#getSanitizedValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SchemaLocationNodeValueMerge.getSanitizedValue(String)"})
  public void testGetSanitizedValue_thenReturnSpringUuXsd42AttributeValue() {
    // Arrange, Act and Assert
    assertEquals(
        "spring-UU.xsd42Attribute Value",
        schemaLocationNodeValueMerge.getSanitizedValue("spring-UU-4.4.xsd42Attribute Value"));
  }

  /**
   * Test {@link SchemaLocationNodeValueMerge#getSanitizedValue(String)}.
   *
   * <ul>
   *   <li>Then return {@code spring-UU.xsd42(spring-\w*-[0-9]\.[0-9]\.xsd)}.
   * </ul>
   *
   * <p>Method under test: {@link SchemaLocationNodeValueMerge#getSanitizedValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SchemaLocationNodeValueMerge.getSanitizedValue(String)"})
  public void testGetSanitizedValue_thenReturnSpringUuXsd42SpringW0909Xsd() {
    // Arrange, Act and Assert
    assertEquals(
        "spring-UU.xsd42(spring-\\w*-[0-9]\\.[0-9]\\.xsd)",
        schemaLocationNodeValueMerge.getSanitizedValue(
            "spring-UU-4.4.xsd42(spring-\\w*-[0-9]\\.[0-9]\\.xsd)"));
  }

  /**
   * Test {@link SchemaLocationNodeValueMerge#getSanitizedValue(String)}.
   *
   * <ul>
   *   <li>Then return {@code spring-UU.xsd42spring-UU.xsd}.
   * </ul>
   *
   * <p>Method under test: {@link SchemaLocationNodeValueMerge#getSanitizedValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SchemaLocationNodeValueMerge.getSanitizedValue(String)"})
  public void testGetSanitizedValue_thenReturnSpringUuXsd42springUuXsd() {
    // Arrange, Act and Assert
    assertEquals(
        "spring-UU.xsd42spring-UU.xsd",
        schemaLocationNodeValueMerge.getSanitizedValue("spring-UU-4.4.xsd42spring-UU-4.4.xsd"));
  }

  /**
   * Test {@link SchemaLocationNodeValueMerge#getSanitizedValue(String)}.
   *
   * <ul>
   *   <li>Then return {@code spring-UU.xsdAttribute Value}.
   * </ul>
   *
   * <p>Method under test: {@link SchemaLocationNodeValueMerge#getSanitizedValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SchemaLocationNodeValueMerge.getSanitizedValue(String)"})
  public void testGetSanitizedValue_thenReturnSpringUuXsdAttributeValue() {
    // Arrange, Act and Assert
    assertEquals(
        "spring-UU.xsdAttribute Value",
        schemaLocationNodeValueMerge.getSanitizedValue("spring-UU-4.4.xsdAttribute Value"));
  }

  /**
   * Test {@link SchemaLocationNodeValueMerge#getSanitizedValue(String)}.
   *
   * <ul>
   *   <li>Then return {@code spring-UU.xsdAttribute Value42}.
   * </ul>
   *
   * <p>Method under test: {@link SchemaLocationNodeValueMerge#getSanitizedValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SchemaLocationNodeValueMerge.getSanitizedValue(String)"})
  public void testGetSanitizedValue_thenReturnSpringUuXsdAttributeValue42() {
    // Arrange, Act and Assert
    assertEquals(
        "spring-UU.xsdAttribute Value42",
        schemaLocationNodeValueMerge.getSanitizedValue("spring-UU-4.4.xsdAttribute Value42"));
  }

  /**
   * Test {@link SchemaLocationNodeValueMerge#getSanitizedValue(String)}.
   *
   * <ul>
   *   <li>Then return {@code spring-UU.xsdAttribute ValueAttribute Value}.
   * </ul>
   *
   * <p>Method under test: {@link SchemaLocationNodeValueMerge#getSanitizedValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SchemaLocationNodeValueMerge.getSanitizedValue(String)"})
  public void testGetSanitizedValue_thenReturnSpringUuXsdAttributeValueAttributeValue() {
    // Arrange, Act and Assert
    assertEquals(
        "spring-UU.xsdAttribute ValueAttribute Value",
        schemaLocationNodeValueMerge.getSanitizedValue(
            "spring-UU-4.4.xsdAttribute ValueAttribute Value"));
  }

  /**
   * Test {@link SchemaLocationNodeValueMerge#getSanitizedValue(String)}.
   *
   * <ul>
   *   <li>Then return {@code spring-UU.xsdAttribute Value(spring-\w*-[0-9]\.[0-9]\.xsd)}.
   * </ul>
   *
   * <p>Method under test: {@link SchemaLocationNodeValueMerge#getSanitizedValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SchemaLocationNodeValueMerge.getSanitizedValue(String)"})
  public void testGetSanitizedValue_thenReturnSpringUuXsdAttributeValueSpringW0909Xsd() {
    // Arrange, Act and Assert
    assertEquals(
        "spring-UU.xsdAttribute Value(spring-\\w*-[0-9]\\.[0-9]\\.xsd)",
        schemaLocationNodeValueMerge.getSanitizedValue(
            "spring-UU-4.4.xsdAttribute Value(spring-\\w*-[0-9]\\.[0-9]\\.xsd)"));
  }

  /**
   * Test {@link SchemaLocationNodeValueMerge#getSanitizedValue(String)}.
   *
   * <ul>
   *   <li>Then return {@code spring-UU.xsdAttribute Valuespring-UU.xsd}.
   * </ul>
   *
   * <p>Method under test: {@link SchemaLocationNodeValueMerge#getSanitizedValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SchemaLocationNodeValueMerge.getSanitizedValue(String)"})
  public void testGetSanitizedValue_thenReturnSpringUuXsdAttributeValuespringUuXsd() {
    // Arrange, Act and Assert
    assertEquals(
        "spring-UU.xsdAttribute Valuespring-UU.xsd",
        schemaLocationNodeValueMerge.getSanitizedValue(
            "spring-UU-4.4.xsdAttribute Valuespring-UU-4.4.xsd"));
  }

  /**
   * Test {@link SchemaLocationNodeValueMerge#getSanitizedValue(String)}.
   *
   * <ul>
   *   <li>Then return {@code spring-UU.xsd(spring-\w*-[0-9]\.[0-9]\.xsd)}.
   * </ul>
   *
   * <p>Method under test: {@link SchemaLocationNodeValueMerge#getSanitizedValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SchemaLocationNodeValueMerge.getSanitizedValue(String)"})
  public void testGetSanitizedValue_thenReturnSpringUuXsdSpringW0909Xsd() {
    // Arrange, Act and Assert
    assertEquals(
        "spring-UU.xsd(spring-\\w*-[0-9]\\.[0-9]\\.xsd)",
        schemaLocationNodeValueMerge.getSanitizedValue(
            "spring-UU-4.4.xsd(spring-\\w*-[0-9]\\.[0-9]\\.xsd)"));
  }

  /**
   * Test {@link SchemaLocationNodeValueMerge#getSanitizedValue(String)}.
   *
   * <ul>
   *   <li>Then return {@code spring-UU.xsd(spring-\w*-[0-9]\.[0-9]\.xsd)42}.
   * </ul>
   *
   * <p>Method under test: {@link SchemaLocationNodeValueMerge#getSanitizedValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SchemaLocationNodeValueMerge.getSanitizedValue(String)"})
  public void testGetSanitizedValue_thenReturnSpringUuXsdSpringW0909Xsd42() {
    // Arrange, Act and Assert
    assertEquals(
        "spring-UU.xsd(spring-\\w*-[0-9]\\.[0-9]\\.xsd)42",
        schemaLocationNodeValueMerge.getSanitizedValue(
            "spring-UU-4.4.xsd(spring-\\w*-[0-9]\\.[0-9]\\.xsd)42"));
  }

  /**
   * Test {@link SchemaLocationNodeValueMerge#getSanitizedValue(String)}.
   *
   * <ul>
   *   <li>Then return {@code spring-UU.xsd(spring-\w*-[0-9]\.[0-9]\.xsd)Attribute Value}.
   * </ul>
   *
   * <p>Method under test: {@link SchemaLocationNodeValueMerge#getSanitizedValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SchemaLocationNodeValueMerge.getSanitizedValue(String)"})
  public void testGetSanitizedValue_thenReturnSpringUuXsdSpringW0909XsdAttributeValue() {
    // Arrange, Act and Assert
    assertEquals(
        "spring-UU.xsd(spring-\\w*-[0-9]\\.[0-9]\\.xsd)Attribute Value",
        schemaLocationNodeValueMerge.getSanitizedValue(
            "spring-UU-4.4.xsd(spring-\\w*-[0-9]\\.[0-9]\\.xsd)Attribute Value"));
  }

  /**
   * Test {@link SchemaLocationNodeValueMerge#getSanitizedValue(String)}.
   *
   * <ul>
   *   <li>Then return {@code spring-UU.xsd(spring-\w*-[0-9]\.[0-9]\.xsd)spring-UU.xsd}.
   * </ul>
   *
   * <p>Method under test: {@link SchemaLocationNodeValueMerge#getSanitizedValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SchemaLocationNodeValueMerge.getSanitizedValue(String)"})
  public void testGetSanitizedValue_thenReturnSpringUuXsdSpringW0909XsdSpringUuXsd() {
    // Arrange, Act and Assert
    assertEquals(
        "spring-UU.xsd(spring-\\w*-[0-9]\\.[0-9]\\.xsd)spring-UU.xsd",
        schemaLocationNodeValueMerge.getSanitizedValue(
            "spring-UU-4.4.xsd(spring-\\w*-[0-9]\\.[0-9]\\.xsd)spring-UU-4.4.xsd"));
  }

  /**
   * Test {@link SchemaLocationNodeValueMerge#getSanitizedValue(String)}.
   *
   * <ul>
   *   <li>Then return {@code
   *       spring-UU.xsd(spring-\w*-[0-9]\.[0-9]\.xsd)(spring-\w*-[0-9]\.[0-9]\.xsd)}.
   * </ul>
   *
   * <p>Method under test: {@link SchemaLocationNodeValueMerge#getSanitizedValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SchemaLocationNodeValueMerge.getSanitizedValue(String)"})
  public void testGetSanitizedValue_thenReturnSpringUuXsdSpringW0909XsdSpringW0909Xsd() {
    // Arrange, Act and Assert
    assertEquals(
        "spring-UU.xsd(spring-\\w*-[0-9]\\.[0-9]\\.xsd)(spring-\\w*-[0-9]\\.[0-9]\\.xsd)",
        schemaLocationNodeValueMerge.getSanitizedValue(
            "spring-UU-4.4.xsd(spring-\\w*-[0-9]\\.[0-9]\\.xsd)(spring-\\w*-[0-9]\\.[0-9]\\.xsd)"));
  }

  /**
   * Test {@link SchemaLocationNodeValueMerge#getSanitizedValue(String)}.
   *
   * <ul>
   *   <li>Then return {@code spring-UU.xsdspring-UU.xsd}.
   * </ul>
   *
   * <p>Method under test: {@link SchemaLocationNodeValueMerge#getSanitizedValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SchemaLocationNodeValueMerge.getSanitizedValue(String)"})
  public void testGetSanitizedValue_thenReturnSpringUuXsdspringUuXsd() {
    // Arrange, Act and Assert
    assertEquals(
        "spring-UU.xsdspring-UU.xsd",
        schemaLocationNodeValueMerge.getSanitizedValue("spring-UU-4.4.xsdspring-UU-4.4.xsd"));
  }

  /**
   * Test {@link SchemaLocationNodeValueMerge#getSanitizedValue(String)}.
   *
   * <ul>
   *   <li>Then return {@code spring-UU.xsdspring-UU.xsd42}.
   * </ul>
   *
   * <p>Method under test: {@link SchemaLocationNodeValueMerge#getSanitizedValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SchemaLocationNodeValueMerge.getSanitizedValue(String)"})
  public void testGetSanitizedValue_thenReturnSpringUuXsdspringUuXsd42() {
    // Arrange, Act and Assert
    assertEquals(
        "spring-UU.xsdspring-UU.xsd42",
        schemaLocationNodeValueMerge.getSanitizedValue("spring-UU-4.4.xsdspring-UU-4.4.xsd42"));
  }

  /**
   * Test {@link SchemaLocationNodeValueMerge#getSanitizedValue(String)}.
   *
   * <ul>
   *   <li>Then return {@code spring-UU.xsdspring-UU.xsdAttribute Value}.
   * </ul>
   *
   * <p>Method under test: {@link SchemaLocationNodeValueMerge#getSanitizedValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SchemaLocationNodeValueMerge.getSanitizedValue(String)"})
  public void testGetSanitizedValue_thenReturnSpringUuXsdspringUuXsdAttributeValue() {
    // Arrange, Act and Assert
    assertEquals(
        "spring-UU.xsdspring-UU.xsdAttribute Value",
        schemaLocationNodeValueMerge.getSanitizedValue(
            "spring-UU-4.4.xsdspring-UU-4.4.xsdAttribute Value"));
  }

  /**
   * Test {@link SchemaLocationNodeValueMerge#getSanitizedValue(String)}.
   *
   * <ul>
   *   <li>Then return {@code spring-UU.xsdspring-UU.xsd(spring-\w*-[0-9]\.[0-9]\.xsd)}.
   * </ul>
   *
   * <p>Method under test: {@link SchemaLocationNodeValueMerge#getSanitizedValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SchemaLocationNodeValueMerge.getSanitizedValue(String)"})
  public void testGetSanitizedValue_thenReturnSpringUuXsdspringUuXsdSpringW0909Xsd() {
    // Arrange, Act and Assert
    assertEquals(
        "spring-UU.xsdspring-UU.xsd(spring-\\w*-[0-9]\\.[0-9]\\.xsd)",
        schemaLocationNodeValueMerge.getSanitizedValue(
            "spring-UU-4.4.xsdspring-UU-4.4.xsd(spring-\\w*-[0-9]\\.[0-9]\\.xsd)"));
  }

  /**
   * Test {@link SchemaLocationNodeValueMerge#getSanitizedValue(String)}.
   *
   * <ul>
   *   <li>Then return {@code spring-UU.xsdspring-UU.xsdspring-UU.xsd}.
   * </ul>
   *
   * <p>Method under test: {@link SchemaLocationNodeValueMerge#getSanitizedValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SchemaLocationNodeValueMerge.getSanitizedValue(String)"})
  public void testGetSanitizedValue_thenReturnSpringUuXsdspringUuXsdspringUuXsd() {
    // Arrange, Act and Assert
    assertEquals(
        "spring-UU.xsdspring-UU.xsdspring-UU.xsd",
        schemaLocationNodeValueMerge.getSanitizedValue(
            "spring-UU-4.4.xsdspring-UU-4.4.xsdspring-UU-4.4.xsd"));
  }

  /**
   * Test {@link SchemaLocationNodeValueMerge#getSanitizedValue(String)}.
   *
   * <ul>
   *   <li>Then return {@code (spring-\w*-[0-9]\.[0-9]\.xsd)42spring-UU.xsd}.
   * </ul>
   *
   * <p>Method under test: {@link SchemaLocationNodeValueMerge#getSanitizedValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SchemaLocationNodeValueMerge.getSanitizedValue(String)"})
  public void testGetSanitizedValue_thenReturnSpringW0909Xsd42springUuXsd() {
    // Arrange, Act and Assert
    assertEquals(
        "(spring-\\w*-[0-9]\\.[0-9]\\.xsd)42spring-UU.xsd",
        schemaLocationNodeValueMerge.getSanitizedValue(
            "(spring-\\w*-[0-9]\\.[0-9]\\.xsd)42spring-UU-4.4.xsd"));
  }

  /**
   * Test {@link SchemaLocationNodeValueMerge#getSanitizedValue(String)}.
   *
   * <ul>
   *   <li>Then return {@code (spring-\w*-[0-9]\.[0-9]\.xsd)Attribute Valuespring-UU.xsd}.
   * </ul>
   *
   * <p>Method under test: {@link SchemaLocationNodeValueMerge#getSanitizedValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SchemaLocationNodeValueMerge.getSanitizedValue(String)"})
  public void testGetSanitizedValue_thenReturnSpringW0909XsdAttributeValuespringUuXsd() {
    // Arrange, Act and Assert
    assertEquals(
        "(spring-\\w*-[0-9]\\.[0-9]\\.xsd)Attribute Valuespring-UU.xsd",
        schemaLocationNodeValueMerge.getSanitizedValue(
            "(spring-\\w*-[0-9]\\.[0-9]\\.xsd)Attribute Valuespring-UU-4.4.xsd"));
  }

  /**
   * Test {@link SchemaLocationNodeValueMerge#getSanitizedValue(String)}.
   *
   * <ul>
   *   <li>Then return {@code (spring-\w*-[0-9]\.[0-9]\.xsd)spring-UU.xsd}.
   * </ul>
   *
   * <p>Method under test: {@link SchemaLocationNodeValueMerge#getSanitizedValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SchemaLocationNodeValueMerge.getSanitizedValue(String)"})
  public void testGetSanitizedValue_thenReturnSpringW0909XsdSpringUuXsd() {
    // Arrange, Act and Assert
    assertEquals(
        "(spring-\\w*-[0-9]\\.[0-9]\\.xsd)spring-UU.xsd",
        schemaLocationNodeValueMerge.getSanitizedValue(
            "(spring-\\w*-[0-9]\\.[0-9]\\.xsd)spring-UU-4.4.xsd"));
  }

  /**
   * Test {@link SchemaLocationNodeValueMerge#getSanitizedValue(String)}.
   *
   * <ul>
   *   <li>Then return {@code (spring-\w*-[0-9]\.[0-9]\.xsd)spring-UU.xsd42}.
   * </ul>
   *
   * <p>Method under test: {@link SchemaLocationNodeValueMerge#getSanitizedValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SchemaLocationNodeValueMerge.getSanitizedValue(String)"})
  public void testGetSanitizedValue_thenReturnSpringW0909XsdSpringUuXsd42() {
    // Arrange, Act and Assert
    assertEquals(
        "(spring-\\w*-[0-9]\\.[0-9]\\.xsd)spring-UU.xsd42",
        schemaLocationNodeValueMerge.getSanitizedValue(
            "(spring-\\w*-[0-9]\\.[0-9]\\.xsd)spring-UU-4.4.xsd42"));
  }

  /**
   * Test {@link SchemaLocationNodeValueMerge#getSanitizedValue(String)}.
   *
   * <ul>
   *   <li>Then return {@code (spring-\w*-[0-9]\.[0-9]\.xsd)spring-UU.xsdAttribute Value}.
   * </ul>
   *
   * <p>Method under test: {@link SchemaLocationNodeValueMerge#getSanitizedValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SchemaLocationNodeValueMerge.getSanitizedValue(String)"})
  public void testGetSanitizedValue_thenReturnSpringW0909XsdSpringUuXsdAttributeValue() {
    // Arrange, Act and Assert
    assertEquals(
        "(spring-\\w*-[0-9]\\.[0-9]\\.xsd)spring-UU.xsdAttribute Value",
        schemaLocationNodeValueMerge.getSanitizedValue(
            "(spring-\\w*-[0-9]\\.[0-9]\\.xsd)spring-UU-4.4.xsdAttribute Value"));
  }

  /**
   * Test {@link SchemaLocationNodeValueMerge#getSanitizedValue(String)}.
   *
   * <ul>
   *   <li>Then return {@code
   *       (spring-\w*-[0-9]\.[0-9]\.xsd)spring-UU.xsd(spring-\w*-[0-9]\.[0-9]\.xsd)}.
   * </ul>
   *
   * <p>Method under test: {@link SchemaLocationNodeValueMerge#getSanitizedValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SchemaLocationNodeValueMerge.getSanitizedValue(String)"})
  public void testGetSanitizedValue_thenReturnSpringW0909XsdSpringUuXsdSpringW0909Xsd() {
    // Arrange, Act and Assert
    assertEquals(
        "(spring-\\w*-[0-9]\\.[0-9]\\.xsd)spring-UU.xsd(spring-\\w*-[0-9]\\.[0-9]\\.xsd)",
        schemaLocationNodeValueMerge.getSanitizedValue(
            "(spring-\\w*-[0-9]\\.[0-9]\\.xsd)spring-UU-4.4.xsd(spring-\\w*-[0-9]\\.[0-9]\\.xsd)"));
  }

  /**
   * Test {@link SchemaLocationNodeValueMerge#getSanitizedValue(String)}.
   *
   * <ul>
   *   <li>Then return {@code (spring-\w*-[0-9]\.[0-9]\.xsd)spring-UU.xsdspring-UU.xsd}.
   * </ul>
   *
   * <p>Method under test: {@link SchemaLocationNodeValueMerge#getSanitizedValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SchemaLocationNodeValueMerge.getSanitizedValue(String)"})
  public void testGetSanitizedValue_thenReturnSpringW0909XsdSpringUuXsdspringUuXsd() {
    // Arrange, Act and Assert
    assertEquals(
        "(spring-\\w*-[0-9]\\.[0-9]\\.xsd)spring-UU.xsdspring-UU.xsd",
        schemaLocationNodeValueMerge.getSanitizedValue(
            "(spring-\\w*-[0-9]\\.[0-9]\\.xsd)spring-UU-4.4.xsdspring-UU-4.4.xsd"));
  }

  /**
   * Test {@link SchemaLocationNodeValueMerge#getSanitizedValue(String)}.
   *
   * <ul>
   *   <li>Then return {@code
   *       (spring-\w*-[0-9]\.[0-9]\.xsd)(spring-\w*-[0-9]\.[0-9]\.xsd)spring-UU.xsd}.
   * </ul>
   *
   * <p>Method under test: {@link SchemaLocationNodeValueMerge#getSanitizedValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SchemaLocationNodeValueMerge.getSanitizedValue(String)"})
  public void testGetSanitizedValue_thenReturnSpringW0909XsdSpringW0909XsdSpringUuXsd() {
    // Arrange, Act and Assert
    assertEquals(
        "(spring-\\w*-[0-9]\\.[0-9]\\.xsd)(spring-\\w*-[0-9]\\.[0-9]\\.xsd)spring-UU.xsd",
        schemaLocationNodeValueMerge.getSanitizedValue(
            "(spring-\\w*-[0-9]\\.[0-9]\\.xsd)(spring-\\w*-[0-9]\\.[0-9]\\.xsd)spring-UU-4.4.xsd"));
  }

  /**
   * Test {@link SchemaLocationNodeValueMerge#getSanitizedValue(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link SchemaLocationNodeValueMerge#getSanitizedValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SchemaLocationNodeValueMerge.getSanitizedValue(String)"})
  public void testGetSanitizedValue_when42_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("42", schemaLocationNodeValueMerge.getSanitizedValue("42"));
  }

  /**
   * Test {@link SchemaLocationNodeValueMerge#getSanitizedValue(String)}.
   *
   * <ul>
   *   <li>When {@code 42spring-UU-4.4.xsd42}.
   *   <li>Then return {@code 42spring-UU.xsd42}.
   * </ul>
   *
   * <p>Method under test: {@link SchemaLocationNodeValueMerge#getSanitizedValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SchemaLocationNodeValueMerge.getSanitizedValue(String)"})
  public void testGetSanitizedValue_when42springUu44Xsd42_thenReturn42springUuXsd42() {
    // Arrange, Act and Assert
    assertEquals(
        "42spring-UU.xsd42",
        schemaLocationNodeValueMerge.getSanitizedValue("42spring-UU-4.4.xsd42"));
  }

  /**
   * Test {@link SchemaLocationNodeValueMerge#getSanitizedValue(String)}.
   *
   * <ul>
   *   <li>When {@code 42spring-UU-4.4.xsd}.
   *   <li>Then return {@code 42spring-UU.xsd}.
   * </ul>
   *
   * <p>Method under test: {@link SchemaLocationNodeValueMerge#getSanitizedValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SchemaLocationNodeValueMerge.getSanitizedValue(String)"})
  public void testGetSanitizedValue_when42springUu44Xsd_thenReturn42springUuXsd() {
    // Arrange, Act and Assert
    assertEquals(
        "42spring-UU.xsd", schemaLocationNodeValueMerge.getSanitizedValue("42spring-UU-4.4.xsd"));
  }

  /**
   * Test {@link SchemaLocationNodeValueMerge#getSanitizedValue(String)}.
   *
   * <ul>
   *   <li>When {@code 4242spring-UU-4.4.xsd}.
   *   <li>Then return {@code 4242spring-UU.xsd}.
   * </ul>
   *
   * <p>Method under test: {@link SchemaLocationNodeValueMerge#getSanitizedValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SchemaLocationNodeValueMerge.getSanitizedValue(String)"})
  public void testGetSanitizedValue_when4242springUu44Xsd_thenReturn4242springUuXsd() {
    // Arrange, Act and Assert
    assertEquals(
        "4242spring-UU.xsd",
        schemaLocationNodeValueMerge.getSanitizedValue("4242spring-UU-4.4.xsd"));
  }

  /**
   * Test {@link SchemaLocationNodeValueMerge#getSanitizedValue(String)}.
   *
   * <ul>
   *   <li>When {@code spring-UU-4.4.xsd42}.
   *   <li>Then return {@code spring-UU.xsd42}.
   * </ul>
   *
   * <p>Method under test: {@link SchemaLocationNodeValueMerge#getSanitizedValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SchemaLocationNodeValueMerge.getSanitizedValue(String)"})
  public void testGetSanitizedValue_whenSpringUu44Xsd42_thenReturnSpringUuXsd42() {
    // Arrange, Act and Assert
    assertEquals(
        "spring-UU.xsd42", schemaLocationNodeValueMerge.getSanitizedValue("spring-UU-4.4.xsd42"));
  }

  /**
   * Test {@link SchemaLocationNodeValueMerge#getSanitizedValue(String)}.
   *
   * <ul>
   *   <li>When {@code spring-UU-4.4.xsd4242}.
   *   <li>Then return {@code spring-UU.xsd4242}.
   * </ul>
   *
   * <p>Method under test: {@link SchemaLocationNodeValueMerge#getSanitizedValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SchemaLocationNodeValueMerge.getSanitizedValue(String)"})
  public void testGetSanitizedValue_whenSpringUu44Xsd4242_thenReturnSpringUuXsd4242() {
    // Arrange, Act and Assert
    assertEquals(
        "spring-UU.xsd4242",
        schemaLocationNodeValueMerge.getSanitizedValue("spring-UU-4.4.xsd4242"));
  }

  /**
   * Test {@link SchemaLocationNodeValueMerge#getSanitizedValue(String)}.
   *
   * <ul>
   *   <li>When {@code spring-UU-4.4.xsd}.
   *   <li>Then return {@code spring-UU.xsd}.
   * </ul>
   *
   * <p>Method under test: {@link SchemaLocationNodeValueMerge#getSanitizedValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SchemaLocationNodeValueMerge.getSanitizedValue(String)"})
  public void testGetSanitizedValue_whenSpringUu44Xsd_thenReturnSpringUuXsd() {
    // Arrange, Act and Assert
    assertEquals(
        "spring-UU.xsd", schemaLocationNodeValueMerge.getSanitizedValue("spring-UU-4.4.xsd"));
  }

  /**
   * Test new {@link SchemaLocationNodeValueMerge} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link
   * SchemaLocationNodeValueMerge}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SchemaLocationNodeValueMerge.<init>()"})
  public void testNewSchemaLocationNodeValueMerge() {
    // Arrange and Act
    SchemaLocationNodeValueMerge actualSchemaLocationNodeValueMerge =
        new SchemaLocationNodeValueMerge();

    // Assert
    assertEquals(" ", actualSchemaLocationNodeValueMerge.getDelimiter());
    assertEquals(" ", actualSchemaLocationNodeValueMerge.delimiter);
    assertEquals("[\\s\\n\\r]+", actualSchemaLocationNodeValueMerge.getRegEx());
    assertNull(actualSchemaLocationNodeValueMerge.getName());
    assertNull(actualSchemaLocationNodeValueMerge.getXPath());
    assertEquals(0, actualSchemaLocationNodeValueMerge.getPriority());
    assertEquals(0, actualSchemaLocationNodeValueMerge.getChildren().length);
  }
}
