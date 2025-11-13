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

@ContextConfiguration(classes = {MergeHandlerAdapter.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class MergeHandlerAdapterDiffblueTest {
  @Autowired private MergeHandlerAdapter mergeHandlerAdapter;

  /**
   * Test {@link MergeHandlerAdapter#merge(List, List, List)}.
   *
   * <ul>
   *   <li>Given {@link IIOMetadataNode#IIOMetadataNode()}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link IIOMetadataNode#IIOMetadataNode()}.
   * </ul>
   *
   * <p>Method under test: {@link MergeHandlerAdapter#merge(List, List, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Node[] MergeHandlerAdapter.merge(List, List, List)"})
  public void testMerge_givenIIOMetadataNode_whenArrayListAddIIOMetadataNode() {
    // Arrange
    ArrayList<Node> nodeList1 = new ArrayList<>();
    nodeList1.add(new IIOMetadataNode());
    ArrayList<Node> nodeList2 = new ArrayList<>();

    // Act and Assert
    assertNull(mergeHandlerAdapter.merge(nodeList1, nodeList2, new ArrayList<>()));
  }

  /**
   * Test {@link MergeHandlerAdapter#merge(List, List, List)}.
   *
   * <ul>
   *   <li>Given {@link IIOMetadataNode#IIOMetadataNode()}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link IIOMetadataNode#IIOMetadataNode()}.
   * </ul>
   *
   * <p>Method under test: {@link MergeHandlerAdapter#merge(List, List, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Node[] MergeHandlerAdapter.merge(List, List, List)"})
  public void testMerge_givenIIOMetadataNode_whenArrayListAddIIOMetadataNode2() {
    // Arrange
    ArrayList<Node> nodeList1 = new ArrayList<>();
    nodeList1.add(new IIOMetadataNode());
    nodeList1.add(new IIOMetadataNode());
    ArrayList<Node> nodeList2 = new ArrayList<>();

    // Act and Assert
    assertNull(mergeHandlerAdapter.merge(nodeList1, nodeList2, new ArrayList<>()));
  }

  /**
   * Test {@link MergeHandlerAdapter#merge(List, List, List)}.
   *
   * <ul>
   *   <li>Given {@link IIOMetadataNode#IIOMetadataNode()}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link IIOMetadataNode#IIOMetadataNode()}.
   * </ul>
   *
   * <p>Method under test: {@link MergeHandlerAdapter#merge(List, List, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Node[] MergeHandlerAdapter.merge(List, List, List)"})
  public void testMerge_givenIIOMetadataNode_whenArrayListAddIIOMetadataNode3() {
    // Arrange
    ArrayList<Node> nodeList1 = new ArrayList<>();

    ArrayList<Node> nodeList2 = new ArrayList<>();
    nodeList2.add(new IIOMetadataNode());

    // Act and Assert
    assertNull(mergeHandlerAdapter.merge(nodeList1, nodeList2, new ArrayList<>()));
  }

  /**
   * Test {@link MergeHandlerAdapter#merge(List, List, List)}.
   *
   * <ul>
   *   <li>Given {@link IIOMetadataNode#IIOMetadataNode()}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link IIOMetadataNode#IIOMetadataNode()}.
   * </ul>
   *
   * <p>Method under test: {@link MergeHandlerAdapter#merge(List, List, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Node[] MergeHandlerAdapter.merge(List, List, List)"})
  public void testMerge_givenIIOMetadataNode_whenArrayListAddIIOMetadataNode4() {
    // Arrange
    ArrayList<Node> nodeList1 = new ArrayList<>();

    ArrayList<Node> nodeList2 = new ArrayList<>();
    nodeList2.add(new IIOMetadataNode());
    nodeList2.add(new IIOMetadataNode());

    // Act and Assert
    assertNull(mergeHandlerAdapter.merge(nodeList1, nodeList2, new ArrayList<>()));
  }

  /**
   * Test {@link MergeHandlerAdapter#merge(List, List, List)}.
   *
   * <ul>
   *   <li>Given {@link IIOMetadataNode#IIOMetadataNode()}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link IIOMetadataNode#IIOMetadataNode()}.
   * </ul>
   *
   * <p>Method under test: {@link MergeHandlerAdapter#merge(List, List, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Node[] MergeHandlerAdapter.merge(List, List, List)"})
  public void testMerge_givenIIOMetadataNode_whenArrayListAddIIOMetadataNode5() {
    // Arrange
    ArrayList<Node> nodeList1 = new ArrayList<>();
    ArrayList<Node> nodeList2 = new ArrayList<>();

    ArrayList<Node> exhaustedNodes = new ArrayList<>();
    exhaustedNodes.add(new IIOMetadataNode());

    // Act and Assert
    assertNull(mergeHandlerAdapter.merge(nodeList1, nodeList2, exhaustedNodes));
  }

  /**
   * Test {@link MergeHandlerAdapter#merge(List, List, List)}.
   *
   * <ul>
   *   <li>Given {@link IIOMetadataNode#IIOMetadataNode()}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link IIOMetadataNode#IIOMetadataNode()}.
   * </ul>
   *
   * <p>Method under test: {@link MergeHandlerAdapter#merge(List, List, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Node[] MergeHandlerAdapter.merge(List, List, List)"})
  public void testMerge_givenIIOMetadataNode_whenArrayListAddIIOMetadataNode6() {
    // Arrange
    ArrayList<Node> nodeList1 = new ArrayList<>();
    ArrayList<Node> nodeList2 = new ArrayList<>();

    ArrayList<Node> exhaustedNodes = new ArrayList<>();
    exhaustedNodes.add(new IIOMetadataNode());
    exhaustedNodes.add(new IIOMetadataNode());

    // Act and Assert
    assertNull(mergeHandlerAdapter.merge(nodeList1, nodeList2, exhaustedNodes));
  }

  /**
   * Test {@link MergeHandlerAdapter#merge(List, List, List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link MergeHandlerAdapter#merge(List, List, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Node[] MergeHandlerAdapter.merge(List, List, List)"})
  public void testMerge_whenArrayList() {
    // Arrange
    ArrayList<Node> nodeList1 = new ArrayList<>();
    ArrayList<Node> nodeList2 = new ArrayList<>();

    // Act and Assert
    assertNull(mergeHandlerAdapter.merge(nodeList1, nodeList2, new ArrayList<>()));
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void MergeHandlerAdapter.<init>()",
    "MergeHandler[] MergeHandlerAdapter.getChildren()",
    "String MergeHandlerAdapter.getName()",
    "int MergeHandlerAdapter.getPriority()",
    "String MergeHandlerAdapter.getXPath()",
    "void MergeHandlerAdapter.setChildren(MergeHandler[])",
    "void MergeHandlerAdapter.setName(String)",
    "void MergeHandlerAdapter.setPriority(int)",
    "void MergeHandlerAdapter.setXPath(String)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    MergeHandlerAdapter actualMergeHandlerAdapter = new MergeHandlerAdapter();
    actualMergeHandlerAdapter.setChildren(new MergeHandler[] {new AttributePreserveInsert()});
    actualMergeHandlerAdapter.setName("Name");
    actualMergeHandlerAdapter.setPriority(1);
    actualMergeHandlerAdapter.setXPath("Xpath");
    MergeHandler[] actualChildren = actualMergeHandlerAdapter.getChildren();
    String actualName = actualMergeHandlerAdapter.getName();
    int actualPriority = actualMergeHandlerAdapter.getPriority();

    // Assert
    assertNull(actualName);
    assertNull(actualMergeHandlerAdapter.getXPath());
    assertNull(actualChildren);
    assertEquals(0, actualPriority);
  }
}
