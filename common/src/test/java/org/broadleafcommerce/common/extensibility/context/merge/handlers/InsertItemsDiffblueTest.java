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

@ContextConfiguration(classes = {InsertItems.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class InsertItemsDiffblueTest {
  @Autowired private InsertItems insertItems;

  /**
   * Test {@link InsertItems#merge(List, List, List)}.
   *
   * <ul>
   *   <li>Given {@link IIOMetadataNode#IIOMetadataNode()}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link IIOMetadataNode#IIOMetadataNode()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link InsertItems#merge(List, List, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Node[] InsertItems.merge(List, List, List)"})
  public void testMerge_givenIIOMetadataNode_whenArrayListAddIIOMetadataNode_thenReturnNull() {
    // Arrange
    ArrayList<Node> nodeList1 = new ArrayList<>();
    nodeList1.add(new IIOMetadataNode());
    ArrayList<Node> nodeList2 = new ArrayList<>();

    // Act and Assert
    assertNull(insertItems.merge(nodeList1, nodeList2, new ArrayList<>()));
  }

  /**
   * Test {@link InsertItems#merge(List, List, List)}.
   *
   * <ul>
   *   <li>Given {@link IIOMetadataNode#IIOMetadataNode()}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link IIOMetadataNode#IIOMetadataNode()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link InsertItems#merge(List, List, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Node[] InsertItems.merge(List, List, List)"})
  public void testMerge_givenIIOMetadataNode_whenArrayListAddIIOMetadataNode_thenReturnNull2() {
    // Arrange
    ArrayList<Node> nodeList1 = new ArrayList<>();
    nodeList1.add(new IIOMetadataNode());
    nodeList1.add(new IIOMetadataNode());
    ArrayList<Node> nodeList2 = new ArrayList<>();

    // Act and Assert
    assertNull(insertItems.merge(nodeList1, nodeList2, new ArrayList<>()));
  }

  /**
   * Test {@link InsertItems#merge(List, List, List)}.
   *
   * <ul>
   *   <li>Given {@link IIOMetadataNode#IIOMetadataNode()}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link IIOMetadataNode#IIOMetadataNode()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link InsertItems#merge(List, List, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Node[] InsertItems.merge(List, List, List)"})
  public void testMerge_givenIIOMetadataNode_whenArrayListAddIIOMetadataNode_thenReturnNull3() {
    // Arrange
    ArrayList<Node> nodeList1 = new ArrayList<>();
    ArrayList<Node> nodeList2 = new ArrayList<>();

    ArrayList<Node> exhaustedNodes = new ArrayList<>();
    exhaustedNodes.add(new IIOMetadataNode());

    // Act and Assert
    assertNull(insertItems.merge(nodeList1, nodeList2, exhaustedNodes));
  }

  /**
   * Test {@link InsertItems#merge(List, List, List)}.
   *
   * <ul>
   *   <li>Given {@link IIOMetadataNode#IIOMetadataNode()}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link IIOMetadataNode#IIOMetadataNode()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link InsertItems#merge(List, List, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Node[] InsertItems.merge(List, List, List)"})
  public void testMerge_givenIIOMetadataNode_whenArrayListAddIIOMetadataNode_thenReturnNull4() {
    // Arrange
    ArrayList<Node> nodeList1 = new ArrayList<>();
    ArrayList<Node> nodeList2 = new ArrayList<>();

    ArrayList<Node> exhaustedNodes = new ArrayList<>();
    exhaustedNodes.add(new IIOMetadataNode());
    exhaustedNodes.add(new IIOMetadataNode());

    // Act and Assert
    assertNull(insertItems.merge(nodeList1, nodeList2, exhaustedNodes));
  }

  /**
   * Test {@link InsertItems#merge(List, List, List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link InsertItems#merge(List, List, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Node[] InsertItems.merge(List, List, List)"})
  public void testMerge_whenArrayList_thenReturnNull() {
    // Arrange
    ArrayList<Node> nodeList1 = new ArrayList<>();
    ArrayList<Node> nodeList2 = new ArrayList<>();

    // Act and Assert
    assertNull(insertItems.merge(nodeList1, nodeList2, new ArrayList<>()));
  }

  /**
   * Test new {@link InsertItems} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link InsertItems}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void InsertItems.<init>()"})
  public void testNewInsertItems() {
    // Arrange and Act
    InsertItems actualInsertItems = new InsertItems();

    // Assert
    assertNull(actualInsertItems.getName());
    assertNull(actualInsertItems.getXPath());
    assertEquals(0, actualInsertItems.getPriority());
    assertEquals(0, actualInsertItems.getChildren().length);
  }
}
