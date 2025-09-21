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
package org.broadleafcommerce.common.extensibility.context.merge;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
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
import org.apache.html.dom.HTMLDocumentImpl;
import org.broadleafcommerce.common.extensibility.context.merge.handlers.AttributePreserveInsert;
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
   *   <li>Then calls {@link MergeHandler#getChildren()}.
   * </ul>
   *
   * <p>Method under test: {@link MergePoint#merge(List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Node[] MergePoint.merge(List)"})
  public void testMergeWithExhaustedNodes_thenCallsGetChildren()
      throws TransformerException, XPathExpressionException {
    // Arrange
    IIOMetadataNode iioMetadataNode = new IIOMetadataNode();
    when(mergeHandler.merge(
            Mockito.<List<Node>>any(), Mockito.<List<Node>>any(), Mockito.<List<Node>>any()))
        .thenReturn(new Node[] {iioMetadataNode});
    when(mergeHandler.getXPath()).thenReturn("X Path");
    when(mergeHandler.getChildren()).thenReturn(null);
    when(mergeHandler.getXPath()).thenReturn("X Path");

    // Act
    Node[] actualMergeResult = mergePoint.merge(new ArrayList<>());

    // Assert
    verify(mergeHandler).getChildren();
    verify(mergeHandler, atLeast(1)).getXPath();
    verify(mergeHandler).merge(isA(List.class), isA(List.class), isA(List.class));
    assertEquals(1, actualMergeResult.length);
    assertSame(iioMetadataNode, actualMergeResult[0]);
  }

  /**
   * Test {@link MergePoint#merge(List)} with {@code exhaustedNodes}.
   *
   * <ul>
   *   <li>Then calls {@link AttributePreserveInsert#merge(List, List, List)}.
   * </ul>
   *
   * <p>Method under test: {@link MergePoint#merge(List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Node[] MergePoint.merge(List)"})
  public void testMergeWithExhaustedNodes_thenCallsMerge()
      throws TransformerException, XPathExpressionException {
    // Arrange
    AttributePreserveInsert handler = mock(AttributePreserveInsert.class);
    IIOMetadataNode iioMetadataNode = new IIOMetadataNode();
    when(handler.merge(
            Mockito.<List<Node>>any(), Mockito.<List<Node>>any(), Mockito.<List<Node>>any()))
        .thenReturn(new Node[] {iioMetadataNode});
    when(handler.getXPath()).thenReturn("X Path");
    when(handler.getChildren()).thenReturn(null);
    HTMLDocumentImpl doc1 = new HTMLDocumentImpl();

    MergePoint mergePoint = new MergePoint(handler, doc1, new HTMLDocumentImpl());

    ArrayList<Node> exhaustedNodes = new ArrayList<>();
    exhaustedNodes.add(new IIOMetadataNode());

    // Act
    Node[] actualMergeResult = mergePoint.merge(exhaustedNodes);

    // Assert
    verify(handler).merge(isA(List.class), isA(List.class), isA(List.class));
    verify(handler).getChildren();
    verify(handler).getXPath();
    assertEquals(1, actualMergeResult.length);
    assertSame(iioMetadataNode, actualMergeResult[0]);
  }

  /**
   * Test {@link MergePoint#merge(List)} with {@code exhaustedNodes}.
   *
   * <ul>
   *   <li>Then calls {@link AttributePreserveInsert#merge(List, List, List)}.
   * </ul>
   *
   * <p>Method under test: {@link MergePoint#merge(List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Node[] MergePoint.merge(List)"})
  public void testMergeWithExhaustedNodes_thenCallsMerge2()
      throws TransformerException, XPathExpressionException {
    // Arrange
    AttributePreserveInsert handler = mock(AttributePreserveInsert.class);
    IIOMetadataNode iioMetadataNode = new IIOMetadataNode();
    when(handler.merge(
            Mockito.<List<Node>>any(), Mockito.<List<Node>>any(), Mockito.<List<Node>>any()))
        .thenReturn(new Node[] {iioMetadataNode});
    when(handler.getXPath()).thenReturn("X Path");
    when(handler.getChildren()).thenReturn(null);
    HTMLDocumentImpl doc1 = new HTMLDocumentImpl();

    MergePoint mergePoint = new MergePoint(handler, doc1, new HTMLDocumentImpl());

    ArrayList<Node> exhaustedNodes = new ArrayList<>();
    exhaustedNodes.add(new IIOMetadataNode());
    exhaustedNodes.add(new IIOMetadataNode());

    // Act
    Node[] actualMergeResult = mergePoint.merge(exhaustedNodes);

    // Assert
    verify(handler).merge(isA(List.class), isA(List.class), isA(List.class));
    verify(handler).getChildren();
    verify(handler).getXPath();
    assertEquals(1, actualMergeResult.length);
    assertSame(iioMetadataNode, actualMergeResult[0]);
  }
}
