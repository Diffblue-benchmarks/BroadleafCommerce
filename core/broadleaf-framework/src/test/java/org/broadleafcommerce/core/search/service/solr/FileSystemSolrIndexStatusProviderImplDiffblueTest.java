/*-
 * #%L
 * BroadleafCommerce Framework
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
package org.broadleafcommerce.core.search.service.solr;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import javax.imageio.metadata.IIOMetadataNode;
import javax.xml.xpath.XPathExpressionException;
import org.apache.html.dom.HTMLAnchorElementImpl;
import org.apache.html.dom.HTMLDocumentImpl;
import org.apache.xerces.dom.ChildNode;
import org.apache.xerces.dom.ParentNode;
import org.apache.xerces.impl.xs.opti.DefaultElement;
import org.apache.xerces.impl.xs.opti.DefaultNode;
import org.broadleafcommerce.core.search.service.solr.index.IndexStatusInfo;
import org.broadleafcommerce.core.search.service.solr.index.IndexStatusInfoImpl;
import org.dom4j.dom.DOMAttributeNodeMap;
import org.dom4j.dom.DOMElement;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mockito.Mockito;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class FileSystemSolrIndexStatusProviderImplDiffblueTest {
  /**
   * Test new {@link FileSystemSolrIndexStatusProviderImpl} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link FileSystemSolrIndexStatusProviderImpl}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FileSystemSolrIndexStatusProviderImpl.<init>()"})
  public void testNewFileSystemSolrIndexStatusProviderImpl() {
    // Arrange and Act
    FileSystemSolrIndexStatusProviderImpl actualFileSystemSolrIndexStatusProviderImpl = new FileSystemSolrIndexStatusProviderImpl();

    // Assert
    SimpleDateFormat simpleDateFormat = actualFileSystemSolrIndexStatusProviderImpl.format;
    assertTrue(simpleDateFormat.getNumberFormat() instanceof DecimalFormat);
    assertTrue(simpleDateFormat.getCalendar() instanceof GregorianCalendar);
    assertEquals("yyyy-MM-dd'T'HH:mm:ssZ", simpleDateFormat.toPattern());
    assertNull(actualFileSystemSolrIndexStatusProviderImpl.deadEventPurgeCycleSeconds);
    assertNull(actualFileSystemSolrIndexStatusProviderImpl.deadEventTTLSeconds);
    assertNull(actualFileSystemSolrIndexStatusProviderImpl.builder);
    assertNull(actualFileSystemSolrIndexStatusProviderImpl.searchService);
    assertNull(actualFileSystemSolrIndexStatusProviderImpl.solrConfiguration);
    assertTrue(simpleDateFormat.isLenient());
  }

  /**
   * Test {@link FileSystemSolrIndexStatusProviderImpl#updateIndexSegment(Document, Element, IndexStatusInfo)}.
   * <ul>
   *   <li>Then {@link IIOMetadataNode#IIOMetadataNode(String)} with {@code foo} FirstChild {@link IIOMetadataNode}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FileSystemSolrIndexStatusProviderImpl#updateIndexSegment(Document, Element, IndexStatusInfo)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void FileSystemSolrIndexStatusProviderImpl.updateIndexSegment(Document, Element, IndexStatusInfo)"})
  public void testUpdateIndexSegment_thenIIOMetadataNodeWithFooFirstChildIIOMetadataNode()
      throws ParseException, XPathExpressionException, DOMException {
    // Arrange
    FileSystemSolrIndexStatusProviderImpl fileSystemSolrIndexStatusProviderImpl = new FileSystemSolrIndexStatusProviderImpl();
    Document document = mock(Document.class);
    when(document.getAttributes()).thenReturn(new DOMAttributeNodeMap(new DOMElement("Name")));
    when(document.getLocalName()).thenReturn("Local Name");
    when(document.getNamespaceURI()).thenReturn("Namespace URI");
    IIOMetadataNode iioMetadataNode = new IIOMetadataNode("foo");
    when(document.createElement(Mockito.<String>any())).thenReturn(iioMetadataNode);
    when(document.getParentNode()).thenReturn(null);
    when(document.getNodeType()).thenReturn((short) 1);
    IIOMetadataNode rootElement = new IIOMetadataNode("foo");
    IndexStatusInfo status = mock(IndexStatusInfo.class);
    when(status.getAdditionalInfo()).thenReturn(new HashMap<>());
    when(status.getLastIndexDate())
        .thenReturn(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    // Act
    fileSystemSolrIndexStatusProviderImpl.updateIndexSegment(document, rootElement, status);

    // Assert
    verify(status).getAdditionalInfo();
    verify(status).getLastIndexDate();
    verify(document).createElement(eq("index"));
    verify(document).getAttributes();
    verify(document, atLeast(1)).getLocalName();
    verify(document).getNamespaceURI();
    verify(document, atLeast(1)).getNodeType();
    verify(document).getParentNode();
    Node firstChild = rootElement.getFirstChild();
    assertTrue(firstChild instanceof IIOMetadataNode);
    assertEquals(1, rootElement.getLength());
    assertTrue(rootElement.hasChildNodes());
    assertSame(iioMetadataNode, firstChild);
    assertSame(iioMetadataNode, rootElement.getLastChild());
  }

  /**
   * Test {@link FileSystemSolrIndexStatusProviderImpl#updateErrorSegment(Document, Element, IndexStatusInfo)}.
   * <ul>
   *   <li>Given {@link DOMElement#DOMElement(String)} with {@code Name}.</li>
   *   <li>Then calls {@link ChildNode#getParentNode()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FileSystemSolrIndexStatusProviderImpl#updateErrorSegment(Document, Element, IndexStatusInfo)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void FileSystemSolrIndexStatusProviderImpl.updateErrorSegment(Document, Element, IndexStatusInfo)"})
  public void testUpdateErrorSegment_givenDOMElementWithName_thenCallsGetParentNode() throws XPathExpressionException {
    // Arrange
    FileSystemSolrIndexStatusProviderImpl fileSystemSolrIndexStatusProviderImpl = new FileSystemSolrIndexStatusProviderImpl();
    HTMLDocumentImpl document = new HTMLDocumentImpl();
    HTMLAnchorElementImpl rootElement = mock(HTMLAnchorElementImpl.class);
    when(rootElement.getAttributes()).thenReturn(new DOMAttributeNodeMap(new DOMElement("Name")));
    when(rootElement.getLocalName()).thenReturn("Local Name");
    when(rootElement.getNamespaceURI()).thenReturn("Namespace URI");
    when(rootElement.getParentNode()).thenReturn(null);
    when(rootElement.getFirstChild()).thenReturn(new IIOMetadataNode("foo"));
    when(rootElement.getChildNodes()).thenReturn(new IIOMetadataNode("foo"));
    when(rootElement.getNodeType()).thenReturn((short) 1);
    when(rootElement.hasChildNodes()).thenReturn(true);

    // Act
    fileSystemSolrIndexStatusProviderImpl.updateErrorSegment(document, rootElement, new IndexStatusInfoImpl());

    // Assert
    verify(rootElement).getParentNode();
    verify(rootElement).getAttributes();
    verify(rootElement, atLeast(1)).getNodeType();
    verify(rootElement, atLeast(1)).getLocalName();
    verify(rootElement).getNamespaceURI();
    verify(rootElement).getChildNodes();
    verify(rootElement).getFirstChild();
    verify(rootElement, atLeast(1)).hasChildNodes();
  }

  /**
   * Test {@link FileSystemSolrIndexStatusProviderImpl#updateErrorSegment(Document, Element, IndexStatusInfo)}.
   * <ul>
   *   <li>Given {@link IIOMetadataNode#IIOMetadataNode(String)} with {@code errors}.</li>
   *   <li>Then calls {@link ParentNode#removeChild(Node)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FileSystemSolrIndexStatusProviderImpl#updateErrorSegment(Document, Element, IndexStatusInfo)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void FileSystemSolrIndexStatusProviderImpl.updateErrorSegment(Document, Element, IndexStatusInfo)"})
  public void testUpdateErrorSegment_givenIIOMetadataNodeWithErrors_thenCallsRemoveChild()
      throws XPathExpressionException, DOMException {
    // Arrange
    FileSystemSolrIndexStatusProviderImpl fileSystemSolrIndexStatusProviderImpl = new FileSystemSolrIndexStatusProviderImpl();
    HTMLDocumentImpl document = new HTMLDocumentImpl();
    HTMLAnchorElementImpl rootElement = mock(HTMLAnchorElementImpl.class);
    when(rootElement.removeChild(Mockito.<Node>any())).thenReturn(new IIOMetadataNode("foo"));
    when(rootElement.getAttributes()).thenReturn(new DOMAttributeNodeMap(new DOMElement("Name")));
    when(rootElement.getLocalName()).thenReturn("Local Name");
    when(rootElement.getNamespaceURI()).thenReturn("Namespace URI");
    when(rootElement.getParentNode()).thenReturn(null);
    when(rootElement.getFirstChild()).thenReturn(new IIOMetadataNode("errors"));
    when(rootElement.getChildNodes()).thenReturn(new IIOMetadataNode("foo"));
    when(rootElement.getNodeType()).thenReturn((short) 1);
    when(rootElement.hasChildNodes()).thenReturn(true);

    // Act
    fileSystemSolrIndexStatusProviderImpl.updateErrorSegment(document, rootElement, new IndexStatusInfoImpl());

    // Assert
    verify(rootElement).getParentNode();
    verify(rootElement).getAttributes();
    verify(rootElement, atLeast(1)).getNodeType();
    verify(rootElement, atLeast(1)).getLocalName();
    verify(rootElement).getNamespaceURI();
    verify(rootElement).getChildNodes();
    verify(rootElement).getFirstChild();
    verify(rootElement, atLeast(1)).hasChildNodes();
    verify(rootElement).removeChild(isA(Node.class));
  }

  /**
   * Test {@link FileSystemSolrIndexStatusProviderImpl#updateDeadEventSegment(Document, Element, IndexStatusInfo, boolean)}.
   * <ul>
   *   <li>Given {@link DOMElement#DOMElement(String)} with {@code Name}.</li>
   *   <li>Then calls {@link ChildNode#getParentNode()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FileSystemSolrIndexStatusProviderImpl#updateDeadEventSegment(Document, Element, IndexStatusInfo, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void FileSystemSolrIndexStatusProviderImpl.updateDeadEventSegment(Document, Element, IndexStatusInfo, boolean)"})
  public void testUpdateDeadEventSegment_givenDOMElementWithName_thenCallsGetParentNode()
      throws XPathExpressionException {
    // Arrange
    FileSystemSolrIndexStatusProviderImpl fileSystemSolrIndexStatusProviderImpl = new FileSystemSolrIndexStatusProviderImpl();
    HTMLDocumentImpl document = new HTMLDocumentImpl();
    HTMLAnchorElementImpl rootElement = mock(HTMLAnchorElementImpl.class);
    when(rootElement.getAttributes()).thenReturn(new DOMAttributeNodeMap(new DOMElement("Name")));
    when(rootElement.getLocalName()).thenReturn("Local Name");
    when(rootElement.getNamespaceURI()).thenReturn("Namespace URI");
    when(rootElement.getParentNode()).thenReturn(null);
    when(rootElement.getFirstChild()).thenReturn(new IIOMetadataNode("foo"));
    when(rootElement.getChildNodes()).thenReturn(new IIOMetadataNode("foo"));
    when(rootElement.getNodeType()).thenReturn((short) 1);
    when(rootElement.hasChildNodes()).thenReturn(true);

    // Act
    fileSystemSolrIndexStatusProviderImpl.updateDeadEventSegment(document, rootElement, new IndexStatusInfoImpl(),
        true);

    // Assert
    verify(rootElement).getParentNode();
    verify(rootElement).getAttributes();
    verify(rootElement, atLeast(1)).getNodeType();
    verify(rootElement, atLeast(1)).getLocalName();
    verify(rootElement).getNamespaceURI();
    verify(rootElement).getChildNodes();
    verify(rootElement).getFirstChild();
    verify(rootElement, atLeast(1)).hasChildNodes();
  }

  /**
   * Test {@link FileSystemSolrIndexStatusProviderImpl#updateDeadEventSegment(Document, Element, IndexStatusInfo, boolean)}.
   * <ul>
   *   <li>Then calls {@link ParentNode#removeChild(Node)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FileSystemSolrIndexStatusProviderImpl#updateDeadEventSegment(Document, Element, IndexStatusInfo, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void FileSystemSolrIndexStatusProviderImpl.updateDeadEventSegment(Document, Element, IndexStatusInfo, boolean)"})
  public void testUpdateDeadEventSegment_thenCallsRemoveChild() throws XPathExpressionException, DOMException {
    // Arrange
    FileSystemSolrIndexStatusProviderImpl fileSystemSolrIndexStatusProviderImpl = new FileSystemSolrIndexStatusProviderImpl();
    HTMLDocumentImpl document = new HTMLDocumentImpl();
    HTMLAnchorElementImpl rootElement = mock(HTMLAnchorElementImpl.class);
    when(rootElement.removeChild(Mockito.<Node>any())).thenReturn(new IIOMetadataNode("foo"));
    when(rootElement.getAttributes()).thenReturn(new DOMAttributeNodeMap(new DOMElement("Name")));
    when(rootElement.getLocalName()).thenReturn("Local Name");
    when(rootElement.getNamespaceURI()).thenReturn("Namespace URI");
    when(rootElement.getParentNode()).thenReturn(null);
    when(rootElement.getFirstChild()).thenReturn(new IIOMetadataNode("dead-events"));
    when(rootElement.getChildNodes()).thenReturn(new IIOMetadataNode("foo"));
    when(rootElement.getNodeType()).thenReturn((short) 1);
    when(rootElement.hasChildNodes()).thenReturn(true);

    // Act
    fileSystemSolrIndexStatusProviderImpl.updateDeadEventSegment(document, rootElement, new IndexStatusInfoImpl(),
        true);

    // Assert
    verify(rootElement).getParentNode();
    verify(rootElement).getAttributes();
    verify(rootElement, atLeast(1)).getNodeType();
    verify(rootElement, atLeast(1)).getLocalName();
    verify(rootElement).getNamespaceURI();
    verify(rootElement).getChildNodes();
    verify(rootElement).getFirstChild();
    verify(rootElement, atLeast(1)).hasChildNodes();
    verify(rootElement).removeChild(isA(Node.class));
  }

  /**
   * Test {@link FileSystemSolrIndexStatusProviderImpl#clearNode(Element, String)}.
   * <ul>
   *   <li>Then calls {@link ParentNode#getLength()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FileSystemSolrIndexStatusProviderImpl#clearNode(Element, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FileSystemSolrIndexStatusProviderImpl.clearNode(Element, String)"})
  public void testClearNode_thenCallsGetLength() throws XPathExpressionException {
    // Arrange
    FileSystemSolrIndexStatusProviderImpl fileSystemSolrIndexStatusProviderImpl = new FileSystemSolrIndexStatusProviderImpl();
    HTMLAnchorElementImpl htmlAnchorElementImpl = mock(HTMLAnchorElementImpl.class);
    when(htmlAnchorElementImpl.item(anyInt())).thenReturn(new IIOMetadataNode("foo"));
    when(htmlAnchorElementImpl.getLength()).thenReturn(3);
    DefaultElement parentElement = mock(DefaultElement.class);
    when(parentElement.getAttributes()).thenReturn(new DOMAttributeNodeMap(new DOMElement("Name")));
    when(parentElement.getLocalName()).thenReturn("Local Name");
    when(parentElement.getNamespaceURI()).thenReturn("Namespace URI");
    when(parentElement.getFirstChild()).thenReturn(new IIOMetadataNode("foo"));
    when(parentElement.getParentNode()).thenReturn(null);
    when(parentElement.getChildNodes()).thenReturn(htmlAnchorElementImpl);
    when(parentElement.getNodeType()).thenReturn((short) 1);
    when(parentElement.hasChildNodes()).thenReturn(true);

    // Act
    fileSystemSolrIndexStatusProviderImpl.clearNode(parentElement, "UTF-8");

    // Assert
    verify(htmlAnchorElementImpl, atLeast(1)).getLength();
    verify(htmlAnchorElementImpl, atLeast(1)).item(anyInt());
    verify(parentElement).getAttributes();
    verify(parentElement).getChildNodes();
    verify(parentElement).getFirstChild();
    verify(parentElement).getParentNode();
    verify(parentElement, atLeast(1)).hasChildNodes();
    verify(parentElement, atLeast(1)).getLocalName();
    verify(parentElement).getNamespaceURI();
    verify(parentElement, atLeast(1)).getNodeType();
  }

  /**
   * Test {@link FileSystemSolrIndexStatusProviderImpl#clearNode(Element, String)}.
   * <ul>
   *   <li>When {@link DefaultElement} {@link DefaultNode#getChildNodes()} return {@link IIOMetadataNode#IIOMetadataNode(String)} with {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FileSystemSolrIndexStatusProviderImpl#clearNode(Element, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FileSystemSolrIndexStatusProviderImpl.clearNode(Element, String)"})
  public void testClearNode_whenDefaultElementGetChildNodesReturnIIOMetadataNodeWithFoo()
      throws XPathExpressionException {
    // Arrange
    FileSystemSolrIndexStatusProviderImpl fileSystemSolrIndexStatusProviderImpl = new FileSystemSolrIndexStatusProviderImpl();
    DefaultElement parentElement = mock(DefaultElement.class);
    when(parentElement.getAttributes()).thenReturn(new DOMAttributeNodeMap(new DOMElement("Name")));
    when(parentElement.getLocalName()).thenReturn("Local Name");
    when(parentElement.getNamespaceURI()).thenReturn("Namespace URI");
    when(parentElement.getFirstChild()).thenReturn(new IIOMetadataNode("foo"));
    when(parentElement.getParentNode()).thenReturn(null);
    when(parentElement.getChildNodes()).thenReturn(new IIOMetadataNode("foo"));
    when(parentElement.getNodeType()).thenReturn((short) 1);
    when(parentElement.hasChildNodes()).thenReturn(true);

    // Act
    fileSystemSolrIndexStatusProviderImpl.clearNode(parentElement, "UTF-8");

    // Assert
    verify(parentElement).getAttributes();
    verify(parentElement).getChildNodes();
    verify(parentElement).getFirstChild();
    verify(parentElement).getParentNode();
    verify(parentElement, atLeast(1)).hasChildNodes();
    verify(parentElement, atLeast(1)).getLocalName();
    verify(parentElement).getNamespaceURI();
    verify(parentElement, atLeast(1)).getNodeType();
  }

  /**
   * Test {@link FileSystemSolrIndexStatusProviderImpl#readIndexStatus(IndexStatusInfo)}.
   * <p>
   * Method under test: {@link FileSystemSolrIndexStatusProviderImpl#readIndexStatus(IndexStatusInfo)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IndexStatusInfo FileSystemSolrIndexStatusProviderImpl.readIndexStatus(IndexStatusInfo)"})
  public void testReadIndexStatus() {
    // Arrange
    FileSystemSolrIndexStatusProviderImpl fileSystemSolrIndexStatusProviderImpl = new FileSystemSolrIndexStatusProviderImpl();
    IndexStatusInfoImpl status = new IndexStatusInfoImpl();

    // Act and Assert
    assertSame(status, fileSystemSolrIndexStatusProviderImpl.readIndexStatus(status));
  }
}
