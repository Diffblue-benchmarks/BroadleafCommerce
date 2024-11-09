/*-
 * #%L
 * BroadleafCommerce Framework
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
package org.broadleafcommerce.core.search.service.solr;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.HashMap;
import javax.imageio.metadata.IIOMetadataNode;
import javax.xml.xpath.XPathExpressionException;
import org.apache.html.dom.HTMLAnchorElementImpl;
import org.apache.html.dom.HTMLDocumentImpl;
import org.apache.xerces.dom.ParentNode;
import org.apache.xerces.impl.xs.opti.DefaultElement;
import org.apache.xerces.impl.xs.opti.DefaultNode;
import org.broadleafcommerce.core.search.service.solr.index.IndexStatusInfo;
import org.broadleafcommerce.core.search.service.solr.index.IndexStatusInfoImpl;
import org.dom4j.dom.DOMAttributeNodeMap;
import org.dom4j.dom.DOMElement;
import org.junit.Test;
import org.mockito.Mockito;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class FileSystemSolrIndexStatusProviderImplDiffblueTest {
  /**
   * Test
   * {@link FileSystemSolrIndexStatusProviderImpl#updateIndexSegment(Document, Element, IndexStatusInfo)}.
   * <ul>
   *   <li>Then {@link IIOMetadataNode#IIOMetadataNode(String)} with {@code foo}
   * FirstChild Length is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FileSystemSolrIndexStatusProviderImpl#updateIndexSegment(Document, Element, IndexStatusInfo)}
   */
  @Test
  public void testUpdateIndexSegment_thenIIOMetadataNodeWithFooFirstChildLengthIsOne()
      throws ParseException, XPathExpressionException, DOMException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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

    HashMap<String, String> stringStringMap = new HashMap<>();
    stringStringMap.put("/status/index", "/status/index");
    IndexStatusInfo status = mock(IndexStatusInfo.class);
    when(status.getAdditionalInfo()).thenReturn(stringStringMap);
    when(status.getLastIndexDate())
        .thenReturn(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    // Act
    fileSystemSolrIndexStatusProviderImpl.updateIndexSegment(document, rootElement, status);

    // Assert
    verify(status).getAdditionalInfo();
    verify(status).getLastIndexDate();
    verify(document, atLeast(1)).createElement(Mockito.<String>any());
    verify(document).getAttributes();
    verify(document, atLeast(1)).getLocalName();
    verify(document).getNamespaceURI();
    verify(document, atLeast(1)).getNodeType();
    verify(document).getParentNode();
    Node firstChild = rootElement.getFirstChild();
    assertTrue(firstChild instanceof IIOMetadataNode);
    assertEquals(1, ((IIOMetadataNode) firstChild).getLength());
    assertTrue(firstChild.hasChildNodes());
    Node firstChild2 = firstChild.getFirstChild();
    assertSame(iioMetadataNode, firstChild2);
    assertSame(iioMetadataNode, firstChild.getLastChild());
    assertSame(firstChild2, firstChild.getParentNode());
  }

  /**
   * Test
   * {@link FileSystemSolrIndexStatusProviderImpl#updateIndexSegment(Document, Element, IndexStatusInfo)}.
   * <ul>
   *   <li>Then {@link IIOMetadataNode#IIOMetadataNode(String)} with {@code foo}
   * FirstChild Length is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FileSystemSolrIndexStatusProviderImpl#updateIndexSegment(Document, Element, IndexStatusInfo)}
   */
  @Test
  public void testUpdateIndexSegment_thenIIOMetadataNodeWithFooFirstChildLengthIsZero()
      throws ParseException, XPathExpressionException, DOMException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FileSystemSolrIndexStatusProviderImpl fileSystemSolrIndexStatusProviderImpl = new FileSystemSolrIndexStatusProviderImpl();
    Document document = mock(Document.class);
    when(document.getAttributes()).thenReturn(new DOMAttributeNodeMap(new DOMElement("Name")));
    when(document.getLocalName()).thenReturn("Local Name");
    when(document.getNamespaceURI()).thenReturn("Namespace URI");
    when(document.createElement(Mockito.<String>any())).thenReturn(new IIOMetadataNode("foo"));
    when(document.getParentNode()).thenReturn(null);
    when(document.getNodeType()).thenReturn((short) 1);
    IIOMetadataNode rootElement = new IIOMetadataNode("foo");
    IndexStatusInfo status = mock(IndexStatusInfo.class);
    when(status.getAdditionalInfo()).thenReturn(new HashMap<>());
    when(status.getLastIndexDate())
        .thenReturn(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    // Act
    fileSystemSolrIndexStatusProviderImpl.updateIndexSegment(document, rootElement, status);

    // Assert that nothing has changed
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
    assertEquals(0, ((IIOMetadataNode) firstChild).getLength());
    assertFalse(firstChild.hasChildNodes());
  }

  /**
   * Test
   * {@link FileSystemSolrIndexStatusProviderImpl#updateErrorSegment(Document, Element, IndexStatusInfo)}.
   * <p>
   * Method under test:
   * {@link FileSystemSolrIndexStatusProviderImpl#updateErrorSegment(Document, Element, IndexStatusInfo)}
   */
  @Test
  public void testUpdateErrorSegment() throws XPathExpressionException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
   * Test
   * {@link FileSystemSolrIndexStatusProviderImpl#updateErrorSegment(Document, Element, IndexStatusInfo)}.
   * <p>
   * Method under test:
   * {@link FileSystemSolrIndexStatusProviderImpl#updateErrorSegment(Document, Element, IndexStatusInfo)}
   */
  @Test
  public void testUpdateErrorSegment2() throws XPathExpressionException, DOMException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FileSystemSolrIndexStatusProviderImpl fileSystemSolrIndexStatusProviderImpl = new FileSystemSolrIndexStatusProviderImpl();
    HTMLDocumentImpl document = new HTMLDocumentImpl();
    HTMLAnchorElementImpl htmlAnchorElementImpl = mock(HTMLAnchorElementImpl.class);
    when(htmlAnchorElementImpl.item(anyInt())).thenReturn(new IIOMetadataNode("foo"));
    when(htmlAnchorElementImpl.getLength()).thenReturn(3);
    HTMLAnchorElementImpl rootElement = mock(HTMLAnchorElementImpl.class);
    when(rootElement.removeChild(Mockito.<Node>any())).thenReturn(new IIOMetadataNode("foo"));
    when(rootElement.getAttributes()).thenReturn(new DOMAttributeNodeMap(new DOMElement("Name")));
    when(rootElement.getLocalName()).thenReturn("Local Name");
    when(rootElement.getNamespaceURI()).thenReturn("Namespace URI");
    when(rootElement.getParentNode()).thenReturn(null);
    when(rootElement.getFirstChild()).thenReturn(new IIOMetadataNode("errors"));
    when(rootElement.getChildNodes()).thenReturn(htmlAnchorElementImpl);
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
    verify(htmlAnchorElementImpl, atLeast(1)).getLength();
    verify(rootElement, atLeast(1)).hasChildNodes();
    verify(htmlAnchorElementImpl, atLeast(1)).item(anyInt());
    verify(rootElement).removeChild(isA(Node.class));
  }

  /**
   * Test
   * {@link FileSystemSolrIndexStatusProviderImpl#updateErrorSegment(Document, Element, IndexStatusInfo)}.
   * <p>
   * Method under test:
   * {@link FileSystemSolrIndexStatusProviderImpl#updateErrorSegment(Document, Element, IndexStatusInfo)}
   */
  @Test
  public void testUpdateErrorSegment3() throws XPathExpressionException, DOMException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FileSystemSolrIndexStatusProviderImpl fileSystemSolrIndexStatusProviderImpl = new FileSystemSolrIndexStatusProviderImpl();
    HTMLDocumentImpl document = new HTMLDocumentImpl();
    HTMLAnchorElementImpl htmlAnchorElementImpl = mock(HTMLAnchorElementImpl.class);
    when(htmlAnchorElementImpl.item(anyInt())).thenReturn(new IIOMetadataNode("#text"));
    when(htmlAnchorElementImpl.getLength()).thenReturn(3);
    HTMLAnchorElementImpl rootElement = mock(HTMLAnchorElementImpl.class);
    when(rootElement.removeChild(Mockito.<Node>any())).thenReturn(new IIOMetadataNode("foo"));
    when(rootElement.getAttributes()).thenReturn(new DOMAttributeNodeMap(new DOMElement("Name")));
    when(rootElement.getLocalName()).thenReturn("Local Name");
    when(rootElement.getNamespaceURI()).thenReturn("Namespace URI");
    when(rootElement.getParentNode()).thenReturn(null);
    when(rootElement.getFirstChild()).thenReturn(new IIOMetadataNode("errors"));
    when(rootElement.getChildNodes()).thenReturn(htmlAnchorElementImpl);
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
    verify(htmlAnchorElementImpl, atLeast(1)).getLength();
    verify(rootElement, atLeast(1)).hasChildNodes();
    verify(htmlAnchorElementImpl, atLeast(1)).item(anyInt());
    verify(rootElement, atLeast(1)).removeChild(Mockito.<Node>any());
  }

  /**
   * Test
   * {@link FileSystemSolrIndexStatusProviderImpl#updateErrorSegment(Document, Element, IndexStatusInfo)}.
   * <ul>
   *   <li>Then calls {@link ParentNode#removeChild(Node)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FileSystemSolrIndexStatusProviderImpl#updateErrorSegment(Document, Element, IndexStatusInfo)}
   */
  @Test
  public void testUpdateErrorSegment_thenCallsRemoveChild() throws XPathExpressionException, DOMException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
   * Test
   * {@link FileSystemSolrIndexStatusProviderImpl#updateDeadEventSegment(Document, Element, IndexStatusInfo, boolean)}.
   * <p>
   * Method under test:
   * {@link FileSystemSolrIndexStatusProviderImpl#updateDeadEventSegment(Document, Element, IndexStatusInfo, boolean)}
   */
  @Test
  public void testUpdateDeadEventSegment() throws XPathExpressionException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
   * Test
   * {@link FileSystemSolrIndexStatusProviderImpl#updateDeadEventSegment(Document, Element, IndexStatusInfo, boolean)}.
   * <p>
   * Method under test:
   * {@link FileSystemSolrIndexStatusProviderImpl#updateDeadEventSegment(Document, Element, IndexStatusInfo, boolean)}
   */
  @Test
  public void testUpdateDeadEventSegment2() throws XPathExpressionException, DOMException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FileSystemSolrIndexStatusProviderImpl fileSystemSolrIndexStatusProviderImpl = new FileSystemSolrIndexStatusProviderImpl();
    HTMLDocumentImpl document = new HTMLDocumentImpl();
    HTMLAnchorElementImpl htmlAnchorElementImpl = mock(HTMLAnchorElementImpl.class);
    when(htmlAnchorElementImpl.item(anyInt())).thenReturn(new IIOMetadataNode("foo"));
    when(htmlAnchorElementImpl.getLength()).thenReturn(3);
    HTMLAnchorElementImpl rootElement = mock(HTMLAnchorElementImpl.class);
    when(rootElement.removeChild(Mockito.<Node>any())).thenReturn(new IIOMetadataNode("foo"));
    when(rootElement.getAttributes()).thenReturn(new DOMAttributeNodeMap(new DOMElement("Name")));
    when(rootElement.getLocalName()).thenReturn("Local Name");
    when(rootElement.getNamespaceURI()).thenReturn("Namespace URI");
    when(rootElement.getParentNode()).thenReturn(null);
    when(rootElement.getFirstChild()).thenReturn(new IIOMetadataNode("dead-events"));
    when(rootElement.getChildNodes()).thenReturn(htmlAnchorElementImpl);
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
    verify(htmlAnchorElementImpl, atLeast(1)).getLength();
    verify(rootElement, atLeast(1)).hasChildNodes();
    verify(htmlAnchorElementImpl, atLeast(1)).item(anyInt());
    verify(rootElement).removeChild(isA(Node.class));
  }

  /**
   * Test
   * {@link FileSystemSolrIndexStatusProviderImpl#updateDeadEventSegment(Document, Element, IndexStatusInfo, boolean)}.
   * <p>
   * Method under test:
   * {@link FileSystemSolrIndexStatusProviderImpl#updateDeadEventSegment(Document, Element, IndexStatusInfo, boolean)}
   */
  @Test
  public void testUpdateDeadEventSegment3() throws XPathExpressionException, DOMException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FileSystemSolrIndexStatusProviderImpl fileSystemSolrIndexStatusProviderImpl = new FileSystemSolrIndexStatusProviderImpl();
    HTMLDocumentImpl document = new HTMLDocumentImpl();
    HTMLAnchorElementImpl htmlAnchorElementImpl = mock(HTMLAnchorElementImpl.class);
    when(htmlAnchorElementImpl.item(anyInt())).thenReturn(new IIOMetadataNode("#text"));
    when(htmlAnchorElementImpl.getLength()).thenReturn(3);
    HTMLAnchorElementImpl rootElement = mock(HTMLAnchorElementImpl.class);
    when(rootElement.removeChild(Mockito.<Node>any())).thenReturn(new IIOMetadataNode("foo"));
    when(rootElement.getAttributes()).thenReturn(new DOMAttributeNodeMap(new DOMElement("Name")));
    when(rootElement.getLocalName()).thenReturn("Local Name");
    when(rootElement.getNamespaceURI()).thenReturn("Namespace URI");
    when(rootElement.getParentNode()).thenReturn(null);
    when(rootElement.getFirstChild()).thenReturn(new IIOMetadataNode("dead-events"));
    when(rootElement.getChildNodes()).thenReturn(htmlAnchorElementImpl);
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
    verify(htmlAnchorElementImpl, atLeast(1)).getLength();
    verify(rootElement, atLeast(1)).hasChildNodes();
    verify(htmlAnchorElementImpl, atLeast(1)).item(anyInt());
    verify(rootElement, atLeast(1)).removeChild(Mockito.<Node>any());
  }

  /**
   * Test
   * {@link FileSystemSolrIndexStatusProviderImpl#updateDeadEventSegment(Document, Element, IndexStatusInfo, boolean)}.
   * <ul>
   *   <li>Then calls {@link ParentNode#removeChild(Node)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FileSystemSolrIndexStatusProviderImpl#updateDeadEventSegment(Document, Element, IndexStatusInfo, boolean)}
   */
  @Test
  public void testUpdateDeadEventSegment_thenCallsRemoveChild() throws XPathExpressionException, DOMException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
   * Test
   * {@link FileSystemSolrIndexStatusProviderImpl#clearNode(Element, String)}.
   * <ul>
   *   <li>Given {@link HTMLAnchorElementImpl} {@link ParentNode#item(int)} return
   * {@link IIOMetadataNode#IIOMetadataNode(String)} with {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FileSystemSolrIndexStatusProviderImpl#clearNode(Element, String)}
   */
  @Test
  public void testClearNode_givenHTMLAnchorElementImplItemReturnIIOMetadataNodeWithFoo()
      throws XPathExpressionException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
   * Test
   * {@link FileSystemSolrIndexStatusProviderImpl#clearNode(Element, String)}.
   * <ul>
   *   <li>Then calls {@link DefaultNode#removeChild(Node)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FileSystemSolrIndexStatusProviderImpl#clearNode(Element, String)}
   */
  @Test
  public void testClearNode_thenCallsRemoveChild() throws XPathExpressionException, DOMException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FileSystemSolrIndexStatusProviderImpl fileSystemSolrIndexStatusProviderImpl = new FileSystemSolrIndexStatusProviderImpl();
    HTMLAnchorElementImpl htmlAnchorElementImpl = mock(HTMLAnchorElementImpl.class);
    when(htmlAnchorElementImpl.item(anyInt())).thenReturn(new IIOMetadataNode("#text"));
    when(htmlAnchorElementImpl.getLength()).thenReturn(3);
    DefaultElement parentElement = mock(DefaultElement.class);
    when(parentElement.removeChild(Mockito.<Node>any())).thenReturn(new IIOMetadataNode("foo"));
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
    verify(parentElement, atLeast(1)).removeChild(isA(Node.class));
    verify(parentElement, atLeast(1)).getLocalName();
    verify(parentElement).getNamespaceURI();
    verify(parentElement, atLeast(1)).getNodeType();
  }

  /**
   * Test
   * {@link FileSystemSolrIndexStatusProviderImpl#clearNode(Element, String)}.
   * <ul>
   *   <li>When {@link DefaultElement} {@link DefaultNode#getChildNodes()} return
   * {@link IIOMetadataNode#IIOMetadataNode(String)} with {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FileSystemSolrIndexStatusProviderImpl#clearNode(Element, String)}
   */
  @Test
  public void testClearNode_whenDefaultElementGetChildNodesReturnIIOMetadataNodeWithFoo()
      throws XPathExpressionException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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

    // Assert that nothing has changed
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
   * Test
   * {@link FileSystemSolrIndexStatusProviderImpl#readIndexStatus(IndexStatusInfo)}.
   * <ul>
   *   <li>When {@link IndexStatusInfoImpl} (default constructor).</li>
   *   <li>Then return {@link IndexStatusInfoImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FileSystemSolrIndexStatusProviderImpl#readIndexStatus(IndexStatusInfo)}
   */
  @Test
  public void testReadIndexStatus_whenIndexStatusInfoImpl_thenReturnIndexStatusInfoImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FileSystemSolrIndexStatusProviderImpl fileSystemSolrIndexStatusProviderImpl = new FileSystemSolrIndexStatusProviderImpl();
    IndexStatusInfoImpl status = new IndexStatusInfoImpl();

    // Act and Assert
    assertSame(status, fileSystemSolrIndexStatusProviderImpl.readIndexStatus(status));
  }

  /**
   * Test
   * {@link FileSystemSolrIndexStatusProviderImpl#readIndexStatus(IndexStatusInfo)}.
   * <ul>
   *   <li>When {@link IndexStatusInfo}.</li>
   *   <li>Then return {@link IndexStatusInfo}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FileSystemSolrIndexStatusProviderImpl#readIndexStatus(IndexStatusInfo)}
   */
  @Test
  public void testReadIndexStatus_whenIndexStatusInfo_thenReturnIndexStatusInfo() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    IndexStatusInfo status = mock(IndexStatusInfo.class);

    // Act and Assert
    assertSame(status, (new FileSystemSolrIndexStatusProviderImpl()).readIndexStatus(status));
  }
}
