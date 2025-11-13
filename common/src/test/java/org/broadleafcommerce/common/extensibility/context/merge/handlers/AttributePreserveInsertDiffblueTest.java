package org.broadleafcommerce.common.extensibility.context.merge.handlers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.metadata.IIOMetadataNode;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.w3c.dom.Node;

@ContextConfiguration(classes = {AttributePreserveInsert.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class AttributePreserveInsertDiffblueTest {
  @Autowired private AttributePreserveInsert attributePreserveInsert;

  /**
   * Test {@link AttributePreserveInsert#merge(List, List, List)}.
   *
   * <ul>
   *   <li>Given {@link AttributePreserveInsert}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AttributePreserveInsert#merge(List, List, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Node[] AttributePreserveInsert.merge(List, List, List)"})
  public void testMerge_givenAttributePreserveInsert_thenReturnNull() {
    // Arrange
    ArrayList<Node> nodeList1 = new ArrayList<>();
    nodeList1.add(new IIOMetadataNode());

    ArrayList<Node> nodeList2 = new ArrayList<>();
    nodeList2.add(new IIOMetadataNode());

    // Act and Assert
    assertNull(attributePreserveInsert.merge(nodeList1, nodeList2, new ArrayList<>()));
  }

  /**
   * Test {@link AttributePreserveInsert#merge(List, List, List)}.
   *
   * <ul>
   *   <li>Given {@link AttributePreserveInsert}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AttributePreserveInsert#merge(List, List, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Node[] AttributePreserveInsert.merge(List, List, List)"})
  public void testMerge_givenAttributePreserveInsert_thenReturnNull2() {
    // Arrange
    ArrayList<Node> nodeList1 = new ArrayList<>();
    nodeList1.add(new IIOMetadataNode());
    ArrayList<Node> nodeList2 = new ArrayList<>();

    // Act and Assert
    assertNull(attributePreserveInsert.merge(nodeList1, nodeList2, new ArrayList<>()));
  }

  /**
   * Test {@link AttributePreserveInsert#merge(List, List, List)}.
   *
   * <ul>
   *   <li>Given {@link AttributePreserveInsert}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AttributePreserveInsert#merge(List, List, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Node[] AttributePreserveInsert.merge(List, List, List)"})
  public void testMerge_givenAttributePreserveInsert_thenReturnNull3() {
    // Arrange
    ArrayList<Node> nodeList1 = new ArrayList<>();
    nodeList1.add(new IIOMetadataNode());
    nodeList1.add(new IIOMetadataNode());
    ArrayList<Node> nodeList2 = new ArrayList<>();

    // Act and Assert
    assertNull(attributePreserveInsert.merge(nodeList1, nodeList2, new ArrayList<>()));
  }

  /**
   * Test {@link AttributePreserveInsert#merge(List, List, List)}.
   *
   * <ul>
   *   <li>Given {@link AttributePreserveInsert}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AttributePreserveInsert#merge(List, List, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Node[] AttributePreserveInsert.merge(List, List, List)"})
  public void testMerge_givenAttributePreserveInsert_thenReturnNull4() {
    // Arrange
    ArrayList<Node> nodeList1 = new ArrayList<>();
    ArrayList<Node> nodeList2 = new ArrayList<>();

    ArrayList<Node> exhaustedNodes = new ArrayList<>();
    exhaustedNodes.add(new IIOMetadataNode());

    // Act and Assert
    assertNull(attributePreserveInsert.merge(nodeList1, nodeList2, exhaustedNodes));
  }

  /**
   * Test {@link AttributePreserveInsert#merge(List, List, List)}.
   *
   * <ul>
   *   <li>Given {@link AttributePreserveInsert}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AttributePreserveInsert#merge(List, List, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Node[] AttributePreserveInsert.merge(List, List, List)"})
  public void testMerge_givenAttributePreserveInsert_thenReturnNull5() {
    // Arrange
    ArrayList<Node> nodeList1 = new ArrayList<>();
    ArrayList<Node> nodeList2 = new ArrayList<>();

    ArrayList<Node> exhaustedNodes = new ArrayList<>();
    exhaustedNodes.add(new IIOMetadataNode());
    exhaustedNodes.add(new IIOMetadataNode());

    // Act and Assert
    assertNull(attributePreserveInsert.merge(nodeList1, nodeList2, exhaustedNodes));
  }

  /**
   * Test {@link AttributePreserveInsert#merge(List, List, List)}.
   *
   * <ul>
   *   <li>Given {@link AttributePreserveInsert} (default constructor).
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AttributePreserveInsert#merge(List, List, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Node[] AttributePreserveInsert.merge(List, List, List)"})
  public void testMerge_givenAttributePreserveInsert_thenReturnNull6() {
    // Arrange
    AttributePreserveInsert attributePreserveInsert = new AttributePreserveInsert();

    ArrayList<Node> nodeList1 = new ArrayList<>();
    nodeList1.add(new IIOMetadataNode());

    ArrayList<Node> nodeList2 = new ArrayList<>();
    nodeList2.add(new IIOMetadataNode());
    nodeList2.add(new IIOMetadataNode());

    // Act and Assert
    assertNull(attributePreserveInsert.merge(nodeList1, nodeList2, new ArrayList<>()));
  }

  /**
   * Test {@link AttributePreserveInsert#merge(List, List, List)}.
   *
   * <ul>
   *   <li>Given {@link AttributePreserveInsert}.
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AttributePreserveInsert#merge(List, List, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Node[] AttributePreserveInsert.merge(List, List, List)"})
  public void testMerge_givenAttributePreserveInsert_whenArrayList_thenReturnNull() {
    // Arrange
    ArrayList<Node> nodeList1 = new ArrayList<>();
    ArrayList<Node> nodeList2 = new ArrayList<>();

    // Act and Assert
    assertNull(attributePreserveInsert.merge(nodeList1, nodeList2, new ArrayList<>()));
  }

  /**
   * Test new {@link AttributePreserveInsert} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link AttributePreserveInsert}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AttributePreserveInsert.<init>()"})
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
