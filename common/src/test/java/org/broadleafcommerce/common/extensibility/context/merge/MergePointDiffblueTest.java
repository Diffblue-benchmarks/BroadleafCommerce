package org.broadleafcommerce.common.extensibility.context.merge;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.metadata.IIOMetadataNode;
import javax.xml.transform.TransformerException;
import javax.xml.xpath.XPathExpressionException;
import org.broadleafcommerce.common.extensibility.context.merge.handlers.MergeHandler;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

@ContextConfiguration(classes = {MergePoint.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class MergePointDiffblueTest {
  @MockBean private Document document;

  @MockBean private MergeHandler mergeHandler;

  @Autowired private MergePoint mergePoint;

  /**
   * Test {@link MergePoint#merge(List)} with {@code exhaustedNodes}.
   *
   * <ul>
   *   <li>Then return array length is one.
   * </ul>
   *
   * <p>Method under test: {@link MergePoint#merge(List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Node[] MergePoint.merge(List)"})
  public void testMergeWithExhaustedNodes_thenReturnArrayLengthIsOne()
      throws TransformerException, XPathExpressionException {
    // Arrange
    IIOMetadataNode iioMetadataNode = new IIOMetadataNode();
    when(mergeHandler.merge(
            Mockito.<List<Node>>any(), Mockito.<List<Node>>any(), Mockito.<List<Node>>any()))
        .thenReturn(new Node[] {iioMetadataNode});
    when(mergeHandler.getXPath()).thenReturn("X Path");
    when(mergeHandler.getChildren()).thenReturn(new MergeHandler[] {});
    when(mergeHandler.getXPath()).thenReturn("X Path");

    // Act
    Node[] actualMergeResult = mergePoint.merge(new ArrayList<>());

    // Assert
    verify(mergeHandler, atLeast(1)).getChildren();
    verify(mergeHandler, atLeast(1)).getXPath();
    verify(mergeHandler).merge(isA(List.class), isA(List.class), isA(List.class));
    assertEquals(1, actualMergeResult.length);
    assertSame(iioMetadataNode, actualMergeResult[0]);
  }
}
