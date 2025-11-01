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

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
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
import java.math.RoundingMode;
import java.text.DateFormatSymbols;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.Calendar;
import java.util.Currency;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.TimeZone;
import javax.imageio.metadata.IIOMetadataNode;
import javax.xml.xpath.XPathExpressionException;
import org.apache.html.dom.HTMLAnchorElementImpl;
import org.apache.html.dom.HTMLDocumentImpl;
import org.apache.xerces.impl.xs.opti.DefaultElement;
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
   * Method under test:
   * {@link FileSystemSolrIndexStatusProviderImpl#updateIndexSegment(Document, Element, IndexStatusInfo)}
   */
  @Test
  public void testUpdateIndexSegment() throws ParseException, XPathExpressionException, DOMException {
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
    Calendar calendar = fileSystemSolrIndexStatusProviderImpl.format.getCalendar();
    assertTrue(calendar instanceof GregorianCalendar);
    assertEquals(0L, calendar.getTimeInMillis());
    assertEquals(1, rootElement.getLength());
    assertEquals(1970, calendar.getWeekYear());
    assertTrue(rootElement.hasChildNodes());
    assertSame(iioMetadataNode, rootElement.getFirstChild());
    assertSame(iioMetadataNode, rootElement.getLastChild());
  }

  /**
   * Method under test:
   * {@link FileSystemSolrIndexStatusProviderImpl#updateIndexSegment(Document, Element, IndexStatusInfo)}
   */
  @Test
  public void testUpdateIndexSegment2() throws ParseException, XPathExpressionException, DOMException {
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
    Calendar calendar = fileSystemSolrIndexStatusProviderImpl.format.getCalendar();
    assertTrue(calendar instanceof GregorianCalendar);
    assertEquals(0L, calendar.getTimeInMillis());
    assertEquals(1, rootElement.getLength());
    assertEquals(1970, calendar.getWeekYear());
    assertTrue(rootElement.hasChildNodes());
    assertSame(iioMetadataNode, rootElement.getFirstChild());
    assertSame(iioMetadataNode, rootElement.getLastChild());
  }

  /**
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
   * Method under test:
   * {@link FileSystemSolrIndexStatusProviderImpl#updateErrorSegment(Document, Element, IndexStatusInfo)}
   */
  @Test
  public void testUpdateErrorSegment2() throws XPathExpressionException, DOMException {
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
   * Method under test:
   * {@link FileSystemSolrIndexStatusProviderImpl#updateErrorSegment(Document, Element, IndexStatusInfo)}
   */
  @Test
  public void testUpdateErrorSegment4() throws XPathExpressionException, DOMException {
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
   * Method under test:
   * {@link FileSystemSolrIndexStatusProviderImpl#updateDeadEventSegment(Document, Element, IndexStatusInfo, boolean)}
   */
  @Test
  public void testUpdateDeadEventSegment2() throws XPathExpressionException, DOMException {
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
   * Method under test:
   * {@link FileSystemSolrIndexStatusProviderImpl#updateDeadEventSegment(Document, Element, IndexStatusInfo, boolean)}
   */
  @Test
  public void testUpdateDeadEventSegment4() throws XPathExpressionException, DOMException {
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
   * Method under test:
   * {@link FileSystemSolrIndexStatusProviderImpl#clearNode(Element, String)}
   */
  @Test
  public void testClearNode() throws XPathExpressionException {
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
   * Method under test:
   * {@link FileSystemSolrIndexStatusProviderImpl#clearNode(Element, String)}
   */
  @Test
  public void testClearNode2() throws XPathExpressionException {
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
   * Method under test:
   * {@link FileSystemSolrIndexStatusProviderImpl#clearNode(Element, String)}
   */
  @Test
  public void testClearNode3() throws XPathExpressionException, DOMException {
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
   * Method under test:
   * {@link FileSystemSolrIndexStatusProviderImpl#readIndexStatus(IndexStatusInfo)}
   */
  @Test
  public void testReadIndexStatus() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FileSystemSolrIndexStatusProviderImpl fileSystemSolrIndexStatusProviderImpl = new FileSystemSolrIndexStatusProviderImpl();
    IndexStatusInfoImpl status = new IndexStatusInfoImpl();

    // Act and Assert
    assertSame(status, fileSystemSolrIndexStatusProviderImpl.readIndexStatus(status));
  }

  /**
   * Method under test:
   * {@link FileSystemSolrIndexStatusProviderImpl#readIndexStatus(IndexStatusInfo)}
   */
  @Test
  public void testReadIndexStatus2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    IndexStatusInfo status = mock(IndexStatusInfo.class);

    // Act and Assert
    assertSame(status, (new FileSystemSolrIndexStatusProviderImpl()).readIndexStatus(status));
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link FileSystemSolrIndexStatusProviderImpl}
   */
  @Test
  public void testNewFileSystemSolrIndexStatusProviderImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    FileSystemSolrIndexStatusProviderImpl actualFileSystemSolrIndexStatusProviderImpl = new FileSystemSolrIndexStatusProviderImpl();

    // Assert
    SimpleDateFormat simpleDateFormat = actualFileSystemSolrIndexStatusProviderImpl.format;
    NumberFormat numberFormat = simpleDateFormat.getNumberFormat();
    assertTrue(numberFormat instanceof DecimalFormat);
    Calendar calendar = simpleDateFormat.getCalendar();
    assertTrue(calendar instanceof GregorianCalendar);
    assertEquals("", ((DecimalFormat) numberFormat).getNegativeSuffix());
    assertEquals("", ((DecimalFormat) numberFormat).getPositivePrefix());
    assertEquals("", ((DecimalFormat) numberFormat).getPositiveSuffix());
    assertEquals("###0", ((DecimalFormat) numberFormat).toLocalizedPattern());
    assertEquals("###0", ((DecimalFormat) numberFormat).toPattern());
    assertEquals("-", ((DecimalFormat) numberFormat).getNegativePrefix());
    DecimalFormatSymbols decimalFormatSymbols = ((DecimalFormat) numberFormat).getDecimalFormatSymbols();
    assertEquals("E", decimalFormatSymbols.getExponentSeparator());
    DateFormatSymbols dateFormatSymbols = simpleDateFormat.getDateFormatSymbols();
    assertEquals("GyMdkHmsSEDFwWahKzZ", dateFormatSymbols.getLocalPatternChars());
    assertEquals("NaN", decimalFormatSymbols.getNaN());
    Currency currency = numberFormat.getCurrency();
    assertEquals("Unknown Currency", currency.getDisplayName());
    assertEquals("XXX", decimalFormatSymbols.getInternationalCurrencySymbol());
    assertEquals("XXX", currency.getCurrencyCode());
    assertEquals("XXX", currency.toString());
    assertEquals("¤", decimalFormatSymbols.getCurrencySymbol());
    assertEquals("¤", currency.getSymbol());
    assertEquals("∞", decimalFormatSymbols.getInfinity());
    assertEquals("gregory", calendar.getCalendarType());
    assertEquals("yyyy-MM-dd'T'HH:mm:ssZ", simpleDateFormat.toPattern());
    assertEquals('#', decimalFormatSymbols.getDigit());
    assertEquals('%', decimalFormatSymbols.getPercent());
    assertEquals(',', decimalFormatSymbols.getGroupingSeparator());
    assertEquals('-', decimalFormatSymbols.getMinusSign());
    assertEquals('.', decimalFormatSymbols.getDecimalSeparator());
    assertEquals('.', decimalFormatSymbols.getMonetaryDecimalSeparator());
    assertEquals('0', decimalFormatSymbols.getZeroDigit());
    assertEquals(';', decimalFormatSymbols.getPatternSeparator());
    assertEquals('‰', decimalFormatSymbols.getPerMill());
    assertNull(actualFileSystemSolrIndexStatusProviderImpl.deadEventPurgeCycleSeconds);
    assertNull(actualFileSystemSolrIndexStatusProviderImpl.deadEventTTLSeconds);
    assertNull(actualFileSystemSolrIndexStatusProviderImpl.builder);
    assertNull(actualFileSystemSolrIndexStatusProviderImpl.searchService);
    assertNull(actualFileSystemSolrIndexStatusProviderImpl.solrConfiguration);
    assertEquals(-1, currency.getDefaultFractionDigits());
    assertEquals(0, numberFormat.getMaximumFractionDigits());
    assertEquals(0, numberFormat.getMinimumFractionDigits());
    TimeZone timeZone = simpleDateFormat.getTimeZone();
    assertEquals(0, timeZone.getDSTSavings());
    assertEquals(1, ((DecimalFormat) numberFormat).getMultiplier());
    assertEquals(1, numberFormat.getMinimumIntegerDigits());
    assertEquals(1, calendar.getFirstDayOfWeek());
    assertEquals(1, calendar.getMinimalDaysInFirstWeek());
    assertEquals(1945, calendar.getWeekYear());
    assertEquals(3, ((DecimalFormat) numberFormat).getGroupingSize());
    assertEquals(52, calendar.getWeeksInWeekYear());
    String[][] zoneStrings = dateFormatSymbols.getZoneStrings();
    assertEquals(602, zoneStrings.length);
    assertEquals(999, currency.getNumericCode());
    assertEquals(RoundingMode.HALF_EVEN, numberFormat.getRoundingMode());
    assertFalse(((DecimalFormat) numberFormat).isDecimalSeparatorAlwaysShown());
    assertFalse(((DecimalFormat) numberFormat).isParseBigDecimal());
    assertFalse(numberFormat.isGroupingUsed());
    assertTrue(simpleDateFormat.isLenient());
    assertTrue(numberFormat.isParseIntegerOnly());
    assertTrue(calendar.isLenient());
    assertTrue(calendar.isWeekDateSupported());
    assertEquals(Integer.MAX_VALUE, numberFormat.getMaximumIntegerDigits());
    assertSame(timeZone, calendar.getTimeZone());
    assertSame(currency, decimalFormatSymbols.getCurrency());
    assertArrayEquals(new String[]{"AM", "PM"}, dateFormatSymbols.getAmPmStrings());
    assertArrayEquals(new String[]{"BC", "AD"}, dateFormatSymbols.getEras());
    assertArrayEquals(new String[]{"ACT", "Australian Central Standard Time", "ACST",
        "Australian Central Daylight Time", "ACDT", "Central Australia Time", "ACT"}, zoneStrings[18]);
    assertArrayEquals(new String[]{"AET", "Australian Eastern Standard Time", "AEST",
        "Australian Eastern Daylight Time", "AEDT", "Eastern Australia Time", "AET"}, zoneStrings[19]);
    assertArrayEquals(new String[]{"ART", "Eastern European Standard Time", "EET", "Eastern European Summer Time",
        "EEST", "Eastern European Time", "EET"}, zoneStrings[20]);
    assertArrayEquals(
        new String[]{"AST", "Alaska Standard Time", "AKST", "Alaska Daylight Time", "AKDT", "Alaska Time", "AKT"},
        zoneStrings[21]);
    assertArrayEquals(new String[]{"America/Anchorage", "Alaska Standard Time", "AKST", "Alaska Daylight Time", "AKDT",
        "Alaska Time", "AKT"}, zoneStrings[7]);
    assertArrayEquals(new String[]{"America/Argentina/Buenos_Aires", "Argentina Standard Time", "ART",
        "Argentina Summer Time", "ARST", "Argentina Time", "ART"}, zoneStrings[599]);
    assertArrayEquals(new String[]{"America/Argentina/ComodRivadavia", "Argentina Standard Time", "ART",
        "Argentina Summer Time", "ARST", "Argentina Time", "ART"}, zoneStrings[588]);
    assertArrayEquals(new String[]{"America/Chicago", "Central Standard Time", "CST", "Central Daylight Time", "CDT",
        "Central Time", "CT"}, zoneStrings[3]);
    assertArrayEquals(new String[]{"America/Denver", "Mountain Standard Time", "MST", "Mountain Daylight Time", "MDT",
        "Mountain Time", "MT"}, zoneStrings[1]);
    assertArrayEquals(new String[]{"America/Ensenada", "Pacific Standard Time", "PST", "Pacific Daylight Time", "PDT",
        "Pacific Time", "PT"}, zoneStrings[582]);
    assertArrayEquals(new String[]{"America/Halifax", "Atlantic Standard Time", "AST", "Atlantic Daylight Time", "ADT",
        "Atlantic Time", "AT"}, zoneStrings[8]);
    assertArrayEquals(new String[]{"America/Indianapolis", "Eastern Standard Time", "EST", "Eastern Daylight Time",
        "EDT", "Eastern Time", "ET"}, zoneStrings[5]);
    assertArrayEquals(new String[]{"America/Los_Angeles", "Pacific Standard Time", "PST", "Pacific Daylight Time",
        "PDT", "Pacific Time", "PT"}, zoneStrings[0]);
    assertArrayEquals(new String[]{"America/New_York", "Eastern Standard Time", "EST", "Eastern Daylight Time", "EDT",
        "Eastern Time", "ET"}, zoneStrings[4]);
    assertArrayEquals(new String[]{"America/Nuuk", "West Greenland Standard Time", "WGT", "West Greenland Summer Time",
        "WGST", "West Greenland Time", "WGT"}, zoneStrings[591]);
    assertArrayEquals(new String[]{"America/Phoenix", "Mountain Standard Time", "MST", "Mountain Daylight Time", "MDT",
        "Mountain Time", "MT"}, zoneStrings[2]);
    assertArrayEquals(new String[]{"America/Rosario", "Argentina Standard Time", "ART", "Argentina Summer Time", "ARST",
        "Argentina Time", "ART"}, zoneStrings[595]);
    assertArrayEquals(new String[]{"America/Sitka", "Alaska Standard Time", "AKST", "Alaska Daylight Time", "AKDT",
        "Alaska Time", "AKT"}, zoneStrings[9]);
    assertArrayEquals(new String[]{"America/St_Johns", "Newfoundland Standard Time", "NST",
        "Newfoundland Daylight Time", "NDT", "Newfoundland Time", "NT"}, zoneStrings[10]);
    assertArrayEquals(new String[]{"America/Virgin", "Atlantic Standard Time", "AST", "Atlantic Daylight Time", "ADT",
        "Atlantic Time", "AT"}, zoneStrings[583]);
    assertArrayEquals(new String[]{"Asia/Famagusta", "Eastern European Time", "EET", "Eastern European Summer Time",
        "EEST", "Eastern European Time", "EET"}, zoneStrings[589]);
    assertArrayEquals(new String[]{"Asia/Jerusalem", "Israel Standard Time", "IST", "Israel Daylight Time", "IDT",
        "Israel Time", "IT"}, zoneStrings[13]);
    assertArrayEquals(
        new String[]{"Asia/Shanghai", "China Standard Time", "CST", "China Daylight Time", "CDT", "China Time", "CT"},
        zoneStrings[Short.SIZE]);
    assertArrayEquals(new String[]{"Asia/Srednekolymsk", "Srednekolymsk Time", "SRET", "Srednekolymsk Daylight Time",
        "SREDT", "Srednekolymsk Time", "SRET"}, zoneStrings[598]);
    assertArrayEquals(
        new String[]{"Asia/Tokyo", "Japan Standard Time", "JST", "Japan Daylight Time", "JDT", "Japan Time", "JT"},
        zoneStrings[14]);
    assertArrayEquals(
        new String[]{"BET", "Brasilia Standard Time", "BRT", "Brasilia Summer Time", "BRST", "Brasilia Time", "BRT"},
        zoneStrings[22]);
    assertArrayEquals(new String[]{"BST", "Bangladesh Standard Time", "BDT", "Bangladesh Summer Time", "BDST",
        "Bangladesh Time", "BDT"}, zoneStrings[23]);
    assertArrayEquals(new String[]{"CAT", "Central Africa Time", "CAT", "Central African Summer Time", "CAST",
        "Central Africa Time", "CAT"}, zoneStrings[24]);
    assertArrayEquals(new String[]{"Canada/Saskatchewan", "Central Standard Time", "CST", "Central Daylight Time",
        "CDT", "Central Time", "CT"}, zoneStrings[596]);
    assertArrayEquals(new String[]{"EET", "Eastern European Time", "EET", "Eastern European Summer Time", "EEST",
        "Eastern European Time", "EET"}, zoneStrings[594]);
    assertArrayEquals(new String[]{"Egypt", "Eastern European Standard Time", "EET", "Eastern European Summer Time",
        "EEST", "Eastern European Time", "EET"}, zoneStrings[597]);
    assertArrayEquals(new String[]{"Etc/Greenwich", "Greenwich Mean Time", "GMT", "Greenwich Mean Time", "GMT",
        "Greenwich Mean Time", "GMT"}, zoneStrings[581]);
    assertArrayEquals(new String[]{"Europe/Astrakhan", "Astrakhan Standard Time", "GMT+04:00",
        "Astrakhan Standard Time", "GMT+04:00", "Astrakhan Time", "GMT+04:00"}, zoneStrings[580]);
    assertArrayEquals(new String[]{"Europe/Bucharest", "Eastern European Standard Time", "EET",
        "Eastern European Summer Time", "EEST", "Eastern European Time", "EET"}, zoneStrings[15]);
    assertArrayEquals(new String[]{"Europe/Kyiv", "Eastern European Standard Time", "EET",
        "Eastern European Summer Time", "EEST", "Eastern European Time", "EET"}, zoneStrings[585]);
    assertArrayEquals(new String[]{"Europe/Nicosia", "Eastern European Standard Time", "EET",
        "Eastern European Summer Time", "EEST", "Eastern European Time", "EET"}, zoneStrings[600]);
    assertArrayEquals(new String[]{"Europe/Paris", "Central European Standard Time", "CET",
        "Central European Summer Time", "CEST", "Central European Time", "CET"}, zoneStrings[11]);
    assertArrayEquals(new String[]{"Europe/Ulyanovsk", "Ulyanovsk Standard Time", "GMT+04:00",
        "Ulyanovsk Standard Time", "GMT+04:00", "Ulyanovsk Time", "GMT+04:00"}, zoneStrings[592]);
    assertArrayEquals(
        new String[]{"GMT", "Greenwich Mean Time", "GMT", "Greenwich Mean Time", "GMT", "Greenwich Mean Time", "GMT"},
        zoneStrings[12]);
    assertArrayEquals(new String[]{"Hongkong", "Hong Kong Standard Time", "HKT", "Hong Kong Summer Time", "HKST",
        "Hong Kong Time", "HKT"}, zoneStrings[586]);
    assertArrayEquals(
        new String[]{"Jamaica", "Eastern Standard Time", "EST", "Eastern Daylight Time", "EDT", "Eastern Time", "ET"},
        zoneStrings[578]);
    assertArrayEquals(
        new String[]{"Japan", "Japan Standard Time", "JST", "Japan Daylight Time", "JDT", "Japan Time", "JT"},
        zoneStrings[590]);
    assertArrayEquals(new String[]{"MST", "Mountain Standard Time", "MST", "Mountain Standard Time", "MST",
        "Mountain Standard Time", "MST"}, zoneStrings[584]);
    assertArrayEquals(new String[]{"Pacific/Honolulu", "Hawaii-Aleutian Standard Time", "HST",
        "Hawaii-Aleutian Daylight Time", "HDT", "Hawaii-Aleutian Time", "HST"}, zoneStrings[6]);
    assertArrayEquals(new String[]{"Turkey", "Turkey Time", "TRT", "Turkey Summer Time", "TRST", "Turkey Time", "TRT"},
        zoneStrings[577]);
    assertArrayEquals(new String[]{"UCT", "Coordinated Universal Time", "UTC", "Coordinated Universal Time", "UTC",
        "Coordinated Universal Time", "UTC"}, zoneStrings[587]);
    assertArrayEquals(new String[]{"US/Pacific", "Pacific Standard Time", "PST", "Pacific Daylight Time", "PDT",
        "Pacific Time", "PT"}, zoneStrings[601]);
    assertArrayEquals(new String[]{"UTC", "Coordinated Universal Time", "UTC", "Coordinated Universal Time", "UTC",
        "Coordinated Universal Time", "UTC"}, zoneStrings[17]);
    assertArrayEquals(
        new String[]{"W-SU", "Moscow Standard Time", "MSK", "Moscow Summer Time", "MSD", "Moscow Time", "MT"},
        zoneStrings[593]);
    assertArrayEquals(new String[]{"WET", "Western European Time", "WET", "Western European Summer Time", "WEST",
        "Western European Time", "WET"}, zoneStrings[579]);
    assertArrayEquals(new String[]{"", "Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"},
        dateFormatSymbols.getShortWeekdays());
    assertArrayEquals(new String[]{"", "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"},
        dateFormatSymbols.getWeekdays());
    assertArrayEquals(
        new String[]{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec", ""},
        dateFormatSymbols.getShortMonths());
    assertArrayEquals(new String[]{"January", "February", "March", "April", "May", "June", "July", "August",
        "September", "October", "November", "December", ""}, dateFormatSymbols.getMonths());
  }
}
