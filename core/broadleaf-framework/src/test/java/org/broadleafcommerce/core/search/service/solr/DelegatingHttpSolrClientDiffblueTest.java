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
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrRequest;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.StreamingResponseCallback;
import org.apache.solr.client.solrj.beans.DocumentObjectBinder;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.client.solrj.response.SolrPingResponse;
import org.apache.solr.client.solrj.response.UpdateResponse;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;
import org.apache.solr.common.params.SolrParams;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;

public class DelegatingHttpSolrClientDiffblueTest {
  @MockBean
  private DelegatingHttpSolrClient delegatingHttpSolrClient;

  /**
   * Method under test: {@link DelegatingHttpSolrClient#add(Collection)}
   */
  @Test
  public void testAdd() throws IOException, SolrServerException {
    // Arrange
    HttpSolrClient delegate = mock(HttpSolrClient.class);
    UpdateResponse updateResponse = new UpdateResponse();
    when(delegate.add(Mockito.<Collection<SolrInputDocument>>any())).thenReturn(updateResponse);
    DelegatingHttpSolrClient delegatingHttpSolrClient = new DelegatingHttpSolrClient(delegate);

    // Act
    UpdateResponse actualAddResult = delegatingHttpSolrClient.add(new ArrayList<>());

    // Assert
    verify(delegate).add(isA(Collection.class));
    assertSame(updateResponse, actualAddResult);
  }

  /**
   * Method under test: {@link DelegatingHttpSolrClient#add(Collection)}
   */
  @Test
  public void testAdd2() throws IOException, SolrServerException {
    // Arrange
    HttpSolrClient delegate = mock(HttpSolrClient.class);
    UpdateResponse updateResponse = new UpdateResponse();
    when(delegate.add(Mockito.<String>any(), Mockito.<Collection<SolrInputDocument>>any())).thenReturn(updateResponse);
    when(delegate.getBaseURL()).thenReturn("https://example.org/example");
    DelegatingHttpSolrClient delegatingHttpSolrClient = new DelegatingHttpSolrClient(delegate,
        "https://example.org/example");

    // Act
    UpdateResponse actualAddResult = delegatingHttpSolrClient.add(new ArrayList<>());

    // Assert
    verify(delegate).add(eq("https://example.org/example"), isA(Collection.class));
    verify(delegate).getBaseURL();
    assertSame(updateResponse, actualAddResult);
  }

  /**
   * Method under test: {@link DelegatingHttpSolrClient#add(Collection)}
   */
  @Test
  public void testAdd3() throws IOException, SolrServerException {
    // Arrange
    HttpSolrClient delegate = mock(HttpSolrClient.class);
    when(delegate.add(Mockito.<String>any(), Mockito.<Collection<SolrInputDocument>>any()))
        .thenThrow(new SolrServerException("An error occurred"));
    when(delegate.getBaseURL()).thenReturn("https://example.org/example");
    DelegatingHttpSolrClient delegatingHttpSolrClient = new DelegatingHttpSolrClient(delegate,
        "https://example.org/example");

    // Act and Assert
    assertThrows(SolrServerException.class, () -> delegatingHttpSolrClient.add(new ArrayList<>()));
    verify(delegate).add(eq("https://example.org/example"), isA(Collection.class));
    verify(delegate).getBaseURL();
  }

  /**
   * Method under test: {@link DelegatingHttpSolrClient#add(Collection)}
   */
  @Test
  public void testAdd4() throws IOException, SolrServerException {
    // Arrange
    HttpSolrClient delegate = mock(HttpSolrClient.class);
    when(delegate.add(Mockito.<Collection<SolrInputDocument>>any()))
        .thenThrow(new SolrServerException("An error occurred"));
    DelegatingHttpSolrClient delegatingHttpSolrClient = new DelegatingHttpSolrClient(delegate, null);

    // Act and Assert
    assertThrows(SolrServerException.class, () -> delegatingHttpSolrClient.add(new ArrayList<>()));
    verify(delegate).add(isA(Collection.class));
  }

  /**
   * Method under test: {@link DelegatingHttpSolrClient#add(Collection)}
   */
  @Test
  public void testAdd5() throws IOException, SolrServerException {
    // Arrange
    HttpSolrClient delegate = mock(HttpSolrClient.class);
    when(delegate.add(Mockito.<Collection<SolrInputDocument>>any()))
        .thenThrow(new SolrServerException("An error occurred"));
    DelegatingHttpSolrClient delegatingHttpSolrClient = new DelegatingHttpSolrClient(delegate, null);

    ArrayList<SolrInputDocument> docs = new ArrayList<>();
    docs.add(mock(SolrInputDocument.class));

    // Act and Assert
    assertThrows(SolrServerException.class, () -> delegatingHttpSolrClient.add(docs));
    verify(delegate).add(isA(Collection.class));
  }

  /**
   * Method under test: {@link DelegatingHttpSolrClient#add(Collection)}
   */
  @Test
  public void testAdd6() throws IOException, SolrServerException {
    // Arrange
    HttpSolrClient delegate = mock(HttpSolrClient.class);
    when(delegate.add(Mockito.<Collection<SolrInputDocument>>any()))
        .thenThrow(new SolrServerException("An error occurred"));
    DelegatingHttpSolrClient delegatingHttpSolrClient = new DelegatingHttpSolrClient(delegate, null);

    ArrayList<SolrInputDocument> docs = new ArrayList<>();
    docs.add(mock(SolrInputDocument.class));
    docs.add(mock(SolrInputDocument.class));

    // Act and Assert
    assertThrows(SolrServerException.class, () -> delegatingHttpSolrClient.add(docs));
    verify(delegate).add(isA(Collection.class));
  }

  /**
   * Method under test: {@link DelegatingHttpSolrClient#add(Collection, int)}
   */
  @Test
  public void testAdd7() throws IOException, SolrServerException {
    // Arrange
    HttpSolrClient delegate = mock(HttpSolrClient.class);
    UpdateResponse updateResponse = new UpdateResponse();
    when(delegate.add(Mockito.<Collection<SolrInputDocument>>any(), anyInt())).thenReturn(updateResponse);
    DelegatingHttpSolrClient delegatingHttpSolrClient = new DelegatingHttpSolrClient(delegate);

    // Act
    UpdateResponse actualAddResult = delegatingHttpSolrClient.add(new ArrayList<>(), 2);

    // Assert
    verify(delegate).add(isA(Collection.class), eq(2));
    assertSame(updateResponse, actualAddResult);
  }

  /**
   * Method under test: {@link DelegatingHttpSolrClient#add(Collection, int)}
   */
  @Test
  public void testAdd8() throws IOException, SolrServerException {
    // Arrange
    HttpSolrClient delegate = mock(HttpSolrClient.class);
    UpdateResponse updateResponse = new UpdateResponse();
    when(delegate.add(Mockito.<String>any(), Mockito.<Collection<SolrInputDocument>>any(), anyInt()))
        .thenReturn(updateResponse);
    when(delegate.getBaseURL()).thenReturn("https://example.org/example");
    DelegatingHttpSolrClient delegatingHttpSolrClient = new DelegatingHttpSolrClient(delegate,
        "https://example.org/example");

    // Act
    UpdateResponse actualAddResult = delegatingHttpSolrClient.add(new ArrayList<>(), 2);

    // Assert
    verify(delegate).add(eq("https://example.org/example"), isA(Collection.class), eq(2));
    verify(delegate).getBaseURL();
    assertSame(updateResponse, actualAddResult);
  }

  /**
   * Method under test: {@link DelegatingHttpSolrClient#add(Collection, int)}
   */
  @Test
  public void testAdd9() throws IOException, SolrServerException {
    // Arrange
    HttpSolrClient delegate = mock(HttpSolrClient.class);
    when(delegate.add(Mockito.<String>any(), Mockito.<Collection<SolrInputDocument>>any(), anyInt()))
        .thenThrow(new SolrServerException("An error occurred"));
    when(delegate.getBaseURL()).thenReturn("https://example.org/example");
    DelegatingHttpSolrClient delegatingHttpSolrClient = new DelegatingHttpSolrClient(delegate,
        "https://example.org/example");

    // Act and Assert
    assertThrows(SolrServerException.class, () -> delegatingHttpSolrClient.add(new ArrayList<>(), 2));
    verify(delegate).add(eq("https://example.org/example"), isA(Collection.class), eq(2));
    verify(delegate).getBaseURL();
  }

  /**
   * Method under test: {@link DelegatingHttpSolrClient#add(Collection, int)}
   */
  @Test
  public void testAdd10() throws IOException, SolrServerException {
    // Arrange
    HttpSolrClient delegate = mock(HttpSolrClient.class);
    when(delegate.add(Mockito.<Collection<SolrInputDocument>>any(), anyInt()))
        .thenThrow(new SolrServerException("An error occurred"));
    DelegatingHttpSolrClient delegatingHttpSolrClient = new DelegatingHttpSolrClient(delegate, null);

    // Act and Assert
    assertThrows(SolrServerException.class, () -> delegatingHttpSolrClient.add(new ArrayList<>(), 2));
    verify(delegate).add(isA(Collection.class), eq(2));
  }

  /**
   * Method under test: {@link DelegatingHttpSolrClient#add(Collection, int)}
   */
  @Test
  public void testAdd11() throws IOException, SolrServerException {
    // Arrange
    HttpSolrClient delegate = mock(HttpSolrClient.class);
    when(delegate.add(Mockito.<Collection<SolrInputDocument>>any(), anyInt()))
        .thenThrow(new SolrServerException("An error occurred"));
    DelegatingHttpSolrClient delegatingHttpSolrClient = new DelegatingHttpSolrClient(delegate, null);

    ArrayList<SolrInputDocument> docs = new ArrayList<>();
    docs.add(mock(SolrInputDocument.class));

    // Act and Assert
    assertThrows(SolrServerException.class, () -> delegatingHttpSolrClient.add(docs, 2));
    verify(delegate).add(isA(Collection.class), eq(2));
  }

  /**
   * Method under test: {@link DelegatingHttpSolrClient#add(Collection, int)}
   */
  @Test
  public void testAdd12() throws IOException, SolrServerException {
    // Arrange
    HttpSolrClient delegate = mock(HttpSolrClient.class);
    when(delegate.add(Mockito.<Collection<SolrInputDocument>>any(), anyInt()))
        .thenThrow(new SolrServerException("An error occurred"));
    DelegatingHttpSolrClient delegatingHttpSolrClient = new DelegatingHttpSolrClient(delegate, null);

    ArrayList<SolrInputDocument> docs = new ArrayList<>();
    docs.add(mock(SolrInputDocument.class));
    docs.add(mock(SolrInputDocument.class));

    // Act and Assert
    assertThrows(SolrServerException.class, () -> delegatingHttpSolrClient.add(docs, 2));
    verify(delegate).add(isA(Collection.class), eq(2));
  }

  /**
   * Method under test: {@link DelegatingHttpSolrClient#add(Iterator)}
   */
  @Test
  public void testAdd13() throws IOException, SolrServerException {
    // Arrange
    HttpSolrClient delegate = mock(HttpSolrClient.class);
    UpdateResponse updateResponse = new UpdateResponse();
    when(delegate.add(Mockito.<Iterator<SolrInputDocument>>any())).thenReturn(updateResponse);
    DelegatingHttpSolrClient delegatingHttpSolrClient = new DelegatingHttpSolrClient(delegate);

    ArrayList<SolrInputDocument> solrInputDocumentList = new ArrayList<>();

    // Act
    UpdateResponse actualAddResult = delegatingHttpSolrClient.add(solrInputDocumentList.iterator());

    // Assert
    verify(delegate).add(isA(Iterator.class));
    assertSame(updateResponse, actualAddResult);
  }

  /**
   * Method under test: {@link DelegatingHttpSolrClient#add(Iterator)}
   */
  @Test
  public void testAdd14() throws IOException, SolrServerException {
    // Arrange
    HttpSolrClient delegate = mock(HttpSolrClient.class);
    UpdateResponse updateResponse = new UpdateResponse();
    when(delegate.add(Mockito.<String>any(), Mockito.<Iterator<SolrInputDocument>>any())).thenReturn(updateResponse);
    when(delegate.getBaseURL()).thenReturn("https://example.org/example");
    DelegatingHttpSolrClient delegatingHttpSolrClient = new DelegatingHttpSolrClient(delegate,
        "https://example.org/example");

    ArrayList<SolrInputDocument> solrInputDocumentList = new ArrayList<>();

    // Act
    UpdateResponse actualAddResult = delegatingHttpSolrClient.add(solrInputDocumentList.iterator());

    // Assert
    verify(delegate).add(eq("https://example.org/example"), isA(Iterator.class));
    verify(delegate).getBaseURL();
    assertSame(updateResponse, actualAddResult);
  }

  /**
   * Method under test: {@link DelegatingHttpSolrClient#add(Iterator)}
   */
  @Test
  public void testAdd15() throws IOException, SolrServerException {
    // Arrange
    HttpSolrClient delegate = mock(HttpSolrClient.class);
    when(delegate.add(Mockito.<String>any(), Mockito.<Iterator<SolrInputDocument>>any()))
        .thenThrow(new SolrServerException("An error occurred"));
    when(delegate.getBaseURL()).thenReturn("https://example.org/example");
    DelegatingHttpSolrClient delegatingHttpSolrClient = new DelegatingHttpSolrClient(delegate,
        "https://example.org/example");

    ArrayList<SolrInputDocument> solrInputDocumentList = new ArrayList<>();

    // Act and Assert
    assertThrows(SolrServerException.class, () -> delegatingHttpSolrClient.add(solrInputDocumentList.iterator()));
    verify(delegate).add(eq("https://example.org/example"), isA(Iterator.class));
    verify(delegate).getBaseURL();
  }

  /**
   * Method under test: {@link DelegatingHttpSolrClient#add(Iterator)}
   */
  @Test
  public void testAdd16() throws IOException, SolrServerException {
    // Arrange
    HttpSolrClient delegate = mock(HttpSolrClient.class);
    when(delegate.add(Mockito.<Iterator<SolrInputDocument>>any()))
        .thenThrow(new SolrServerException("An error occurred"));
    DelegatingHttpSolrClient delegatingHttpSolrClient = new DelegatingHttpSolrClient(delegate, null);

    ArrayList<SolrInputDocument> solrInputDocumentList = new ArrayList<>();

    // Act and Assert
    assertThrows(SolrServerException.class, () -> delegatingHttpSolrClient.add(solrInputDocumentList.iterator()));
    verify(delegate).add(isA(Iterator.class));
  }

  /**
   * Method under test: {@link DelegatingHttpSolrClient#add(SolrInputDocument)}
   */
  @Test
  public void testAdd17() throws IOException, SolrServerException {
    // Arrange
    HttpSolrClient delegate = mock(HttpSolrClient.class);
    UpdateResponse updateResponse = new UpdateResponse();
    when(delegate.add(Mockito.<SolrInputDocument>any())).thenReturn(updateResponse);

    // Act
    UpdateResponse actualAddResult = (new DelegatingHttpSolrClient(delegate)).add(mock(SolrInputDocument.class));

    // Assert
    verify(delegate).add(isA(SolrInputDocument.class));
    assertSame(updateResponse, actualAddResult);
  }

  /**
   * Method under test: {@link DelegatingHttpSolrClient#add(SolrInputDocument)}
   */
  @Test
  public void testAdd18() throws IOException, SolrServerException {
    // Arrange
    HttpSolrClient delegate = mock(HttpSolrClient.class);
    UpdateResponse updateResponse = new UpdateResponse();
    when(delegate.add(Mockito.<String>any(), Mockito.<SolrInputDocument>any())).thenReturn(updateResponse);
    when(delegate.getBaseURL()).thenReturn("https://example.org/example");

    // Act
    UpdateResponse actualAddResult = (new DelegatingHttpSolrClient(delegate, "https://example.org/example"))
        .add(mock(SolrInputDocument.class));

    // Assert
    verify(delegate).add(eq("https://example.org/example"), isA(SolrInputDocument.class));
    verify(delegate).getBaseURL();
    assertSame(updateResponse, actualAddResult);
  }

  /**
   * Method under test: {@link DelegatingHttpSolrClient#add(SolrInputDocument)}
   */
  @Test
  public void testAdd19() throws IOException, SolrServerException {
    // Arrange
    HttpSolrClient delegate = mock(HttpSolrClient.class);
    when(delegate.add(Mockito.<String>any(), Mockito.<SolrInputDocument>any()))
        .thenThrow(new SolrServerException("An error occurred"));
    when(delegate.getBaseURL()).thenReturn("https://example.org/example");

    // Act and Assert
    assertThrows(SolrServerException.class,
        () -> (new DelegatingHttpSolrClient(delegate, "https://example.org/example"))
            .add(mock(SolrInputDocument.class)));
    verify(delegate).add(eq("https://example.org/example"), isA(SolrInputDocument.class));
    verify(delegate).getBaseURL();
  }

  /**
   * Method under test: {@link DelegatingHttpSolrClient#add(SolrInputDocument)}
   */
  @Test
  public void testAdd20() throws IOException, SolrServerException {
    // Arrange
    HttpSolrClient delegate = mock(HttpSolrClient.class);
    when(delegate.add(Mockito.<SolrInputDocument>any())).thenThrow(new SolrServerException("An error occurred"));

    // Act and Assert
    assertThrows(SolrServerException.class,
        () -> (new DelegatingHttpSolrClient(delegate, null)).add(mock(SolrInputDocument.class)));
    verify(delegate).add(isA(SolrInputDocument.class));
  }

  /**
   * Method under test:
   * {@link DelegatingHttpSolrClient#add(SolrInputDocument, int)}
   */
  @Test
  public void testAdd21() throws IOException, SolrServerException {
    // Arrange
    HttpSolrClient delegate = mock(HttpSolrClient.class);
    UpdateResponse updateResponse = new UpdateResponse();
    when(delegate.add(Mockito.<SolrInputDocument>any(), anyInt())).thenReturn(updateResponse);

    // Act
    UpdateResponse actualAddResult = (new DelegatingHttpSolrClient(delegate)).add(mock(SolrInputDocument.class), 2);

    // Assert
    verify(delegate).add(isA(SolrInputDocument.class), eq(2));
    assertSame(updateResponse, actualAddResult);
  }

  /**
   * Method under test:
   * {@link DelegatingHttpSolrClient#add(SolrInputDocument, int)}
   */
  @Test
  public void testAdd22() throws IOException, SolrServerException {
    // Arrange
    HttpSolrClient delegate = mock(HttpSolrClient.class);
    UpdateResponse updateResponse = new UpdateResponse();
    when(delegate.add(Mockito.<String>any(), Mockito.<SolrInputDocument>any(), anyInt())).thenReturn(updateResponse);
    when(delegate.getBaseURL()).thenReturn("https://example.org/example");

    // Act
    UpdateResponse actualAddResult = (new DelegatingHttpSolrClient(delegate, "https://example.org/example"))
        .add(mock(SolrInputDocument.class), 2);

    // Assert
    verify(delegate).add(eq("https://example.org/example"), isA(SolrInputDocument.class), eq(2));
    verify(delegate).getBaseURL();
    assertSame(updateResponse, actualAddResult);
  }

  /**
   * Method under test:
   * {@link DelegatingHttpSolrClient#add(SolrInputDocument, int)}
   */
  @Test
  public void testAdd23() throws IOException, SolrServerException {
    // Arrange
    HttpSolrClient delegate = mock(HttpSolrClient.class);
    when(delegate.add(Mockito.<String>any(), Mockito.<SolrInputDocument>any(), anyInt()))
        .thenThrow(new SolrServerException("An error occurred"));
    when(delegate.getBaseURL()).thenReturn("https://example.org/example");

    // Act and Assert
    assertThrows(SolrServerException.class,
        () -> (new DelegatingHttpSolrClient(delegate, "https://example.org/example")).add(mock(SolrInputDocument.class),
            2));
    verify(delegate).add(eq("https://example.org/example"), isA(SolrInputDocument.class), eq(2));
    verify(delegate).getBaseURL();
  }

  /**
   * Method under test:
   * {@link DelegatingHttpSolrClient#add(SolrInputDocument, int)}
   */
  @Test
  public void testAdd24() throws IOException, SolrServerException {
    // Arrange
    HttpSolrClient delegate = mock(HttpSolrClient.class);
    when(delegate.add(Mockito.<SolrInputDocument>any(), anyInt()))
        .thenThrow(new SolrServerException("An error occurred"));

    // Act and Assert
    assertThrows(SolrServerException.class,
        () -> (new DelegatingHttpSolrClient(delegate, null)).add(mock(SolrInputDocument.class), 2));
    verify(delegate).add(isA(SolrInputDocument.class), eq(2));
  }

  /**
   * Method under test: {@link DelegatingHttpSolrClient#addBean(Object)}
   */
  @Test
  public void testAddBean() throws IOException, SolrServerException {
    // Arrange
    HttpSolrClient delegate = mock(HttpSolrClient.class);
    UpdateResponse updateResponse = new UpdateResponse();
    when(delegate.addBean(Mockito.<Object>any())).thenReturn(updateResponse);

    // Act
    UpdateResponse actualAddBeanResult = (new DelegatingHttpSolrClient(delegate)).addBean("Obj");

    // Assert
    verify(delegate).addBean(isA(Object.class));
    assertSame(updateResponse, actualAddBeanResult);
  }

  /**
   * Method under test: {@link DelegatingHttpSolrClient#addBean(Object)}
   */
  @Test
  public void testAddBean2() throws IOException, SolrServerException {
    // Arrange
    HttpSolrClient delegate = mock(HttpSolrClient.class);
    UpdateResponse updateResponse = new UpdateResponse();
    when(delegate.addBean(Mockito.<String>any(), Mockito.<Object>any())).thenReturn(updateResponse);
    when(delegate.getBaseURL()).thenReturn("https://example.org/example");

    // Act
    UpdateResponse actualAddBeanResult = (new DelegatingHttpSolrClient(delegate, "https://example.org/example"))
        .addBean("Obj");

    // Assert
    verify(delegate).addBean(eq("https://example.org/example"), isA(Object.class));
    verify(delegate).getBaseURL();
    assertSame(updateResponse, actualAddBeanResult);
  }

  /**
   * Method under test: {@link DelegatingHttpSolrClient#addBean(Object)}
   */
  @Test
  public void testAddBean3() throws IOException, SolrServerException {
    // Arrange
    HttpSolrClient delegate = mock(HttpSolrClient.class);
    when(delegate.addBean(Mockito.<String>any(), Mockito.<Object>any()))
        .thenThrow(new SolrServerException("An error occurred"));
    when(delegate.getBaseURL()).thenReturn("https://example.org/example");

    // Act and Assert
    assertThrows(SolrServerException.class,
        () -> (new DelegatingHttpSolrClient(delegate, "https://example.org/example")).addBean("Obj"));
    verify(delegate).addBean(eq("https://example.org/example"), isA(Object.class));
    verify(delegate).getBaseURL();
  }

  /**
   * Method under test: {@link DelegatingHttpSolrClient#addBean(Object)}
   */
  @Test
  public void testAddBean4() throws IOException, SolrServerException {
    // Arrange
    HttpSolrClient delegate = mock(HttpSolrClient.class);
    when(delegate.addBean(Mockito.<Object>any())).thenThrow(new SolrServerException("An error occurred"));

    // Act and Assert
    assertThrows(SolrServerException.class, () -> (new DelegatingHttpSolrClient(delegate, null)).addBean("Obj"));
    verify(delegate).addBean(isA(Object.class));
  }

  /**
   * Method under test: {@link DelegatingHttpSolrClient#addBean(Object, int)}
   */
  @Test
  public void testAddBean5() throws IOException, SolrServerException {
    // Arrange
    HttpSolrClient delegate = mock(HttpSolrClient.class);
    UpdateResponse updateResponse = new UpdateResponse();
    when(delegate.addBean(Mockito.<Object>any(), anyInt())).thenReturn(updateResponse);

    // Act
    UpdateResponse actualAddBeanResult = (new DelegatingHttpSolrClient(delegate)).addBean((Object) "Obj", 2);

    // Assert
    verify(delegate).addBean(isA(Object.class), eq(2));
    assertSame(updateResponse, actualAddBeanResult);
  }

  /**
   * Method under test: {@link DelegatingHttpSolrClient#addBean(Object, int)}
   */
  @Test
  public void testAddBean6() throws IOException, SolrServerException {
    // Arrange
    HttpSolrClient delegate = mock(HttpSolrClient.class);
    UpdateResponse updateResponse = new UpdateResponse();
    when(delegate.addBean(Mockito.<String>any(), Mockito.<Object>any(), anyInt())).thenReturn(updateResponse);
    when(delegate.getBaseURL()).thenReturn("https://example.org/example");

    // Act
    UpdateResponse actualAddBeanResult = (new DelegatingHttpSolrClient(delegate, "https://example.org/example"))
        .addBean((Object) "Obj", 2);

    // Assert
    verify(delegate).addBean(eq("https://example.org/example"), isA(Object.class), eq(2));
    verify(delegate).getBaseURL();
    assertSame(updateResponse, actualAddBeanResult);
  }

  /**
   * Method under test: {@link DelegatingHttpSolrClient#addBean(Object, int)}
   */
  @Test
  public void testAddBean7() throws IOException, SolrServerException {
    // Arrange
    HttpSolrClient delegate = mock(HttpSolrClient.class);
    when(delegate.addBean(Mockito.<String>any(), Mockito.<Object>any(), anyInt()))
        .thenThrow(new SolrServerException("An error occurred"));
    when(delegate.getBaseURL()).thenReturn("https://example.org/example");

    // Act and Assert
    assertThrows(SolrServerException.class,
        () -> (new DelegatingHttpSolrClient(delegate, "https://example.org/example")).addBean((Object) "Obj", 2));
    verify(delegate).addBean(eq("https://example.org/example"), isA(Object.class), eq(2));
    verify(delegate).getBaseURL();
  }

  /**
   * Method under test: {@link DelegatingHttpSolrClient#addBean(Object, int)}
   */
  @Test
  public void testAddBean8() throws IOException, SolrServerException {
    // Arrange
    HttpSolrClient delegate = mock(HttpSolrClient.class);
    when(delegate.addBean(Mockito.<Object>any(), anyInt())).thenThrow(new SolrServerException("An error occurred"));

    // Act and Assert
    assertThrows(SolrServerException.class,
        () -> (new DelegatingHttpSolrClient(delegate, null)).addBean((Object) "Obj", 2));
    verify(delegate).addBean(isA(Object.class), eq(2));
  }

  /**
   * Method under test: {@link DelegatingHttpSolrClient#addBeans(Collection)}
   */
  @Test
  public void testAddBeans() throws IOException, SolrServerException {
    // Arrange
    HttpSolrClient delegate = mock(HttpSolrClient.class);
    UpdateResponse updateResponse = new UpdateResponse();
    when(delegate.addBeans(Mockito.<Collection<Object>>any())).thenReturn(updateResponse);
    DelegatingHttpSolrClient delegatingHttpSolrClient = new DelegatingHttpSolrClient(delegate);

    // Act
    UpdateResponse actualAddBeansResult = delegatingHttpSolrClient.addBeans(new ArrayList<>());

    // Assert
    verify(delegate).addBeans(isA(Collection.class));
    assertSame(updateResponse, actualAddBeansResult);
  }

  /**
   * Method under test: {@link DelegatingHttpSolrClient#addBeans(Collection)}
   */
  @Test
  public void testAddBeans2() throws IOException, SolrServerException {
    // Arrange
    HttpSolrClient delegate = mock(HttpSolrClient.class);
    UpdateResponse updateResponse = new UpdateResponse();
    when(delegate.addBeans(Mockito.<String>any(), Mockito.<Collection<Object>>any())).thenReturn(updateResponse);
    when(delegate.getBaseURL()).thenReturn("https://example.org/example");
    DelegatingHttpSolrClient delegatingHttpSolrClient = new DelegatingHttpSolrClient(delegate,
        "https://example.org/example");

    // Act
    UpdateResponse actualAddBeansResult = delegatingHttpSolrClient.addBeans(new ArrayList<>());

    // Assert
    verify(delegate).addBeans(eq("https://example.org/example"), isA(Collection.class));
    verify(delegate).getBaseURL();
    assertSame(updateResponse, actualAddBeansResult);
  }

  /**
   * Method under test: {@link DelegatingHttpSolrClient#addBeans(Collection)}
   */
  @Test
  public void testAddBeans3() throws IOException, SolrServerException {
    // Arrange
    HttpSolrClient delegate = mock(HttpSolrClient.class);
    when(delegate.addBeans(Mockito.<String>any(), Mockito.<Collection<Object>>any()))
        .thenThrow(new SolrServerException("An error occurred"));
    when(delegate.getBaseURL()).thenReturn("https://example.org/example");
    DelegatingHttpSolrClient delegatingHttpSolrClient = new DelegatingHttpSolrClient(delegate,
        "https://example.org/example");

    // Act and Assert
    assertThrows(SolrServerException.class, () -> delegatingHttpSolrClient.addBeans(new ArrayList<>()));
    verify(delegate).addBeans(eq("https://example.org/example"), isA(Collection.class));
    verify(delegate).getBaseURL();
  }

  /**
   * Method under test: {@link DelegatingHttpSolrClient#addBeans(Collection)}
   */
  @Test
  public void testAddBeans4() throws IOException, SolrServerException {
    // Arrange
    HttpSolrClient delegate = mock(HttpSolrClient.class);
    when(delegate.addBeans(Mockito.<Collection<Object>>any())).thenThrow(new SolrServerException("An error occurred"));
    DelegatingHttpSolrClient delegatingHttpSolrClient = new DelegatingHttpSolrClient(delegate, null);

    // Act and Assert
    assertThrows(SolrServerException.class, () -> delegatingHttpSolrClient.addBeans(new ArrayList<>()));
    verify(delegate).addBeans(isA(Collection.class));
  }

  /**
   * Method under test: {@link DelegatingHttpSolrClient#addBeans(Collection)}
   */
  @Test
  public void testAddBeans5() throws IOException, SolrServerException {
    // Arrange
    HttpSolrClient delegate = mock(HttpSolrClient.class);
    when(delegate.addBeans(Mockito.<Collection<Object>>any())).thenThrow(new SolrServerException("An error occurred"));
    DelegatingHttpSolrClient delegatingHttpSolrClient = new DelegatingHttpSolrClient(delegate, null);

    ArrayList<Object> beans = new ArrayList<>();
    beans.add("42");

    // Act and Assert
    assertThrows(SolrServerException.class, () -> delegatingHttpSolrClient.addBeans(beans));
    verify(delegate).addBeans(isA(Collection.class));
  }

  /**
   * Method under test: {@link DelegatingHttpSolrClient#addBeans(Collection)}
   */
  @Test
  public void testAddBeans6() throws IOException, SolrServerException {
    // Arrange
    HttpSolrClient delegate = mock(HttpSolrClient.class);
    when(delegate.addBeans(Mockito.<Collection<Object>>any())).thenThrow(new SolrServerException("An error occurred"));
    DelegatingHttpSolrClient delegatingHttpSolrClient = new DelegatingHttpSolrClient(delegate, null);

    ArrayList<Object> beans = new ArrayList<>();
    beans.add("42");
    beans.add("42");

    // Act and Assert
    assertThrows(SolrServerException.class, () -> delegatingHttpSolrClient.addBeans(beans));
    verify(delegate).addBeans(isA(Collection.class));
  }

  /**
   * Method under test: {@link DelegatingHttpSolrClient#addBeans(Collection, int)}
   */
  @Test
  public void testAddBeans7() throws IOException, SolrServerException {
    // Arrange
    HttpSolrClient delegate = mock(HttpSolrClient.class);
    UpdateResponse updateResponse = new UpdateResponse();
    when(delegate.addBeans(Mockito.<Collection<Object>>any(), anyInt())).thenReturn(updateResponse);
    DelegatingHttpSolrClient delegatingHttpSolrClient = new DelegatingHttpSolrClient(delegate);

    // Act
    UpdateResponse actualAddBeansResult = delegatingHttpSolrClient.addBeans(new ArrayList<>(), 2);

    // Assert
    verify(delegate).addBeans(isA(Collection.class), eq(2));
    assertSame(updateResponse, actualAddBeansResult);
  }

  /**
   * Method under test: {@link DelegatingHttpSolrClient#addBeans(Collection, int)}
   */
  @Test
  public void testAddBeans8() throws IOException, SolrServerException {
    // Arrange
    HttpSolrClient delegate = mock(HttpSolrClient.class);
    UpdateResponse updateResponse = new UpdateResponse();
    when(delegate.addBeans(Mockito.<String>any(), Mockito.<Collection<Object>>any(), anyInt()))
        .thenReturn(updateResponse);
    when(delegate.getBaseURL()).thenReturn("https://example.org/example");
    DelegatingHttpSolrClient delegatingHttpSolrClient = new DelegatingHttpSolrClient(delegate,
        "https://example.org/example");

    // Act
    UpdateResponse actualAddBeansResult = delegatingHttpSolrClient.addBeans(new ArrayList<>(), 2);

    // Assert
    verify(delegate).addBeans(eq("https://example.org/example"), isA(Collection.class), eq(2));
    verify(delegate).getBaseURL();
    assertSame(updateResponse, actualAddBeansResult);
  }

  /**
   * Method under test: {@link DelegatingHttpSolrClient#addBeans(Collection, int)}
   */
  @Test
  public void testAddBeans9() throws IOException, SolrServerException {
    // Arrange
    HttpSolrClient delegate = mock(HttpSolrClient.class);
    when(delegate.addBeans(Mockito.<String>any(), Mockito.<Collection<Object>>any(), anyInt()))
        .thenThrow(new SolrServerException("An error occurred"));
    when(delegate.getBaseURL()).thenReturn("https://example.org/example");
    DelegatingHttpSolrClient delegatingHttpSolrClient = new DelegatingHttpSolrClient(delegate,
        "https://example.org/example");

    // Act and Assert
    assertThrows(SolrServerException.class, () -> delegatingHttpSolrClient.addBeans(new ArrayList<>(), 2));
    verify(delegate).addBeans(eq("https://example.org/example"), isA(Collection.class), eq(2));
    verify(delegate).getBaseURL();
  }

  /**
   * Method under test: {@link DelegatingHttpSolrClient#addBeans(Collection, int)}
   */
  @Test
  public void testAddBeans10() throws IOException, SolrServerException {
    // Arrange
    HttpSolrClient delegate = mock(HttpSolrClient.class);
    when(delegate.addBeans(Mockito.<Collection<Object>>any(), anyInt()))
        .thenThrow(new SolrServerException("An error occurred"));
    DelegatingHttpSolrClient delegatingHttpSolrClient = new DelegatingHttpSolrClient(delegate, null);

    // Act and Assert
    assertThrows(SolrServerException.class, () -> delegatingHttpSolrClient.addBeans(new ArrayList<>(), 2));
    verify(delegate).addBeans(isA(Collection.class), eq(2));
  }

  /**
   * Method under test: {@link DelegatingHttpSolrClient#addBeans(Collection, int)}
   */
  @Test
  public void testAddBeans11() throws IOException, SolrServerException {
    // Arrange
    HttpSolrClient delegate = mock(HttpSolrClient.class);
    when(delegate.addBeans(Mockito.<Collection<Object>>any(), anyInt()))
        .thenThrow(new SolrServerException("An error occurred"));
    DelegatingHttpSolrClient delegatingHttpSolrClient = new DelegatingHttpSolrClient(delegate, null);

    ArrayList<Object> beans = new ArrayList<>();
    beans.add("42");

    // Act and Assert
    assertThrows(SolrServerException.class, () -> delegatingHttpSolrClient.addBeans(beans, 2));
    verify(delegate).addBeans(isA(Collection.class), eq(2));
  }

  /**
   * Method under test: {@link DelegatingHttpSolrClient#addBeans(Collection, int)}
   */
  @Test
  public void testAddBeans12() throws IOException, SolrServerException {
    // Arrange
    HttpSolrClient delegate = mock(HttpSolrClient.class);
    when(delegate.addBeans(Mockito.<Collection<Object>>any(), anyInt()))
        .thenThrow(new SolrServerException("An error occurred"));
    DelegatingHttpSolrClient delegatingHttpSolrClient = new DelegatingHttpSolrClient(delegate, null);

    ArrayList<Object> beans = new ArrayList<>();
    beans.add("42");
    beans.add("42");

    // Act and Assert
    assertThrows(SolrServerException.class, () -> delegatingHttpSolrClient.addBeans(beans, 2));
    verify(delegate).addBeans(isA(Collection.class), eq(2));
  }

  /**
   * Method under test: {@link DelegatingHttpSolrClient#addBeans(Iterator)}
   */
  @Test
  public void testAddBeans13() throws IOException, SolrServerException {
    // Arrange
    HttpSolrClient delegate = mock(HttpSolrClient.class);
    UpdateResponse updateResponse = new UpdateResponse();
    when(delegate.addBeans(Mockito.<Iterator<Object>>any())).thenReturn(updateResponse);
    DelegatingHttpSolrClient delegatingHttpSolrClient = new DelegatingHttpSolrClient(delegate);

    ArrayList<Object> objectList = new ArrayList<>();

    // Act
    UpdateResponse actualAddBeansResult = delegatingHttpSolrClient.addBeans(objectList.iterator());

    // Assert
    verify(delegate).addBeans(isA(Iterator.class));
    assertSame(updateResponse, actualAddBeansResult);
  }

  /**
   * Method under test: {@link DelegatingHttpSolrClient#addBeans(Iterator)}
   */
  @Test
  public void testAddBeans14() throws IOException, SolrServerException {
    // Arrange
    HttpSolrClient delegate = mock(HttpSolrClient.class);
    UpdateResponse updateResponse = new UpdateResponse();
    when(delegate.addBeans(Mockito.<String>any(), Mockito.<Iterator<Object>>any())).thenReturn(updateResponse);
    when(delegate.getBaseURL()).thenReturn("https://example.org/example");
    DelegatingHttpSolrClient delegatingHttpSolrClient = new DelegatingHttpSolrClient(delegate,
        "https://example.org/example");

    ArrayList<Object> objectList = new ArrayList<>();

    // Act
    UpdateResponse actualAddBeansResult = delegatingHttpSolrClient.addBeans(objectList.iterator());

    // Assert
    verify(delegate).addBeans(eq("https://example.org/example"), isA(Iterator.class));
    verify(delegate).getBaseURL();
    assertSame(updateResponse, actualAddBeansResult);
  }

  /**
   * Method under test: {@link DelegatingHttpSolrClient#addBeans(Iterator)}
   */
  @Test
  public void testAddBeans15() throws IOException, SolrServerException {
    // Arrange
    HttpSolrClient delegate = mock(HttpSolrClient.class);
    when(delegate.addBeans(Mockito.<String>any(), Mockito.<Iterator<Object>>any()))
        .thenThrow(new SolrServerException("An error occurred"));
    when(delegate.getBaseURL()).thenReturn("https://example.org/example");
    DelegatingHttpSolrClient delegatingHttpSolrClient = new DelegatingHttpSolrClient(delegate,
        "https://example.org/example");

    ArrayList<Object> objectList = new ArrayList<>();

    // Act and Assert
    assertThrows(SolrServerException.class, () -> delegatingHttpSolrClient.addBeans(objectList.iterator()));
    verify(delegate).addBeans(eq("https://example.org/example"), isA(Iterator.class));
    verify(delegate).getBaseURL();
  }

  /**
   * Method under test: {@link DelegatingHttpSolrClient#addBeans(Iterator)}
   */
  @Test
  public void testAddBeans16() throws IOException, SolrServerException {
    // Arrange
    HttpSolrClient delegate = mock(HttpSolrClient.class);
    when(delegate.addBeans(Mockito.<Iterator<Object>>any())).thenThrow(new SolrServerException("An error occurred"));
    DelegatingHttpSolrClient delegatingHttpSolrClient = new DelegatingHttpSolrClient(delegate, null);

    ArrayList<Object> objectList = new ArrayList<>();

    // Act and Assert
    assertThrows(SolrServerException.class, () -> delegatingHttpSolrClient.addBeans(objectList.iterator()));
    verify(delegate).addBeans(isA(Iterator.class));
  }

  /**
   * Method under test: {@link DelegatingHttpSolrClient#commit()}
   */
  @Test
  public void testCommit() throws IOException, SolrServerException {
    // Arrange
    HttpSolrClient delegate = mock(HttpSolrClient.class);
    UpdateResponse updateResponse = new UpdateResponse();
    when(delegate.commit()).thenReturn(updateResponse);

    // Act
    UpdateResponse actualCommitResult = (new DelegatingHttpSolrClient(delegate)).commit();

    // Assert
    verify(delegate).commit();
    assertSame(updateResponse, actualCommitResult);
  }

  /**
   * Method under test: {@link DelegatingHttpSolrClient#commit()}
   */
  @Test
  public void testCommit2() throws IOException, SolrServerException {
    // Arrange
    HttpSolrClient delegate = mock(HttpSolrClient.class);
    UpdateResponse updateResponse = new UpdateResponse();
    when(delegate.commit(Mockito.<String>any())).thenReturn(updateResponse);
    when(delegate.getBaseURL()).thenReturn("https://example.org/example");

    // Act
    UpdateResponse actualCommitResult = (new DelegatingHttpSolrClient(delegate, "https://example.org/example"))
        .commit();

    // Assert
    verify(delegate).commit(eq("https://example.org/example"));
    verify(delegate).getBaseURL();
    assertSame(updateResponse, actualCommitResult);
  }

  /**
   * Method under test: {@link DelegatingHttpSolrClient#commit()}
   */
  @Test
  public void testCommit3() throws IOException, SolrServerException {
    // Arrange
    HttpSolrClient delegate = mock(HttpSolrClient.class);
    when(delegate.commit(Mockito.<String>any())).thenThrow(new SolrServerException("An error occurred"));
    when(delegate.getBaseURL()).thenReturn("https://example.org/example");

    // Act and Assert
    assertThrows(SolrServerException.class,
        () -> (new DelegatingHttpSolrClient(delegate, "https://example.org/example")).commit());
    verify(delegate).commit(eq("https://example.org/example"));
    verify(delegate).getBaseURL();
  }

  /**
   * Method under test: {@link DelegatingHttpSolrClient#commit()}
   */
  @Test
  public void testCommit4() throws IOException, SolrServerException {
    // Arrange
    HttpSolrClient delegate = mock(HttpSolrClient.class);
    when(delegate.commit()).thenThrow(new SolrServerException("An error occurred"));

    // Act and Assert
    assertThrows(SolrServerException.class, () -> (new DelegatingHttpSolrClient(delegate, null)).commit());
    verify(delegate).commit();
  }

  /**
   * Method under test: {@link DelegatingHttpSolrClient#commit(boolean, boolean)}
   */
  @Test
  public void testCommit5() throws IOException, SolrServerException {
    // Arrange
    HttpSolrClient delegate = mock(HttpSolrClient.class);
    UpdateResponse updateResponse = new UpdateResponse();
    when(delegate.commit(anyBoolean(), anyBoolean())).thenReturn(updateResponse);

    // Act
    UpdateResponse actualCommitResult = (new DelegatingHttpSolrClient(delegate)).commit(true, true);

    // Assert
    verify(delegate).commit(eq(true), eq(true));
    assertSame(updateResponse, actualCommitResult);
  }

  /**
   * Method under test: {@link DelegatingHttpSolrClient#commit(boolean, boolean)}
   */
  @Test
  public void testCommit6() throws IOException, SolrServerException {
    // Arrange
    HttpSolrClient delegate = mock(HttpSolrClient.class);
    UpdateResponse updateResponse = new UpdateResponse();
    when(delegate.commit(Mockito.<String>any(), anyBoolean(), anyBoolean())).thenReturn(updateResponse);
    when(delegate.getBaseURL()).thenReturn("https://example.org/example");

    // Act
    UpdateResponse actualCommitResult = (new DelegatingHttpSolrClient(delegate, "https://example.org/example"))
        .commit(true, true);

    // Assert
    verify(delegate).commit(eq("https://example.org/example"), eq(true), eq(true));
    verify(delegate).getBaseURL();
    assertSame(updateResponse, actualCommitResult);
  }

  /**
   * Method under test: {@link DelegatingHttpSolrClient#commit(boolean, boolean)}
   */
  @Test
  public void testCommit7() throws IOException, SolrServerException {
    // Arrange
    HttpSolrClient delegate = mock(HttpSolrClient.class);
    when(delegate.commit(Mockito.<String>any(), anyBoolean(), anyBoolean()))
        .thenThrow(new SolrServerException("An error occurred"));
    when(delegate.getBaseURL()).thenReturn("https://example.org/example");

    // Act and Assert
    assertThrows(SolrServerException.class,
        () -> (new DelegatingHttpSolrClient(delegate, "https://example.org/example")).commit(true, true));
    verify(delegate).commit(eq("https://example.org/example"), eq(true), eq(true));
    verify(delegate).getBaseURL();
  }

  /**
   * Method under test: {@link DelegatingHttpSolrClient#commit(boolean, boolean)}
   */
  @Test
  public void testCommit8() throws IOException, SolrServerException {
    // Arrange
    HttpSolrClient delegate = mock(HttpSolrClient.class);
    when(delegate.commit(anyBoolean(), anyBoolean())).thenThrow(new SolrServerException("An error occurred"));

    // Act and Assert
    assertThrows(SolrServerException.class, () -> (new DelegatingHttpSolrClient(delegate, null)).commit(true, true));
    verify(delegate).commit(eq(true), eq(true));
  }

  /**
   * Method under test:
   * {@link DelegatingHttpSolrClient#commit(boolean, boolean, boolean)}
   */
  @Test
  public void testCommit9() throws IOException, SolrServerException {
    // Arrange
    HttpSolrClient delegate = mock(HttpSolrClient.class);
    UpdateResponse updateResponse = new UpdateResponse();
    when(delegate.commit(anyBoolean(), anyBoolean(), anyBoolean())).thenReturn(updateResponse);

    // Act
    UpdateResponse actualCommitResult = (new DelegatingHttpSolrClient(delegate)).commit(true, true, true);

    // Assert
    verify(delegate).commit(eq(true), eq(true), eq(true));
    assertSame(updateResponse, actualCommitResult);
  }

  /**
   * Method under test:
   * {@link DelegatingHttpSolrClient#commit(boolean, boolean, boolean)}
   */
  @Test
  public void testCommit10() throws IOException, SolrServerException {
    // Arrange
    HttpSolrClient delegate = mock(HttpSolrClient.class);
    UpdateResponse updateResponse = new UpdateResponse();
    when(delegate.commit(Mockito.<String>any(), anyBoolean(), anyBoolean(), anyBoolean())).thenReturn(updateResponse);
    when(delegate.getBaseURL()).thenReturn("https://example.org/example");

    // Act
    UpdateResponse actualCommitResult = (new DelegatingHttpSolrClient(delegate, "https://example.org/example"))
        .commit(true, true, true);

    // Assert
    verify(delegate).commit(eq("https://example.org/example"), eq(true), eq(true), eq(true));
    verify(delegate).getBaseURL();
    assertSame(updateResponse, actualCommitResult);
  }

  /**
   * Method under test:
   * {@link DelegatingHttpSolrClient#commit(boolean, boolean, boolean)}
   */
  @Test
  public void testCommit11() throws IOException, SolrServerException {
    // Arrange
    HttpSolrClient delegate = mock(HttpSolrClient.class);
    when(delegate.commit(Mockito.<String>any(), anyBoolean(), anyBoolean(), anyBoolean()))
        .thenThrow(new SolrServerException("An error occurred"));
    when(delegate.getBaseURL()).thenReturn("https://example.org/example");

    // Act and Assert
    assertThrows(SolrServerException.class,
        () -> (new DelegatingHttpSolrClient(delegate, "https://example.org/example")).commit(true, true, true));
    verify(delegate).commit(eq("https://example.org/example"), eq(true), eq(true), eq(true));
    verify(delegate).getBaseURL();
  }

  /**
   * Method under test:
   * {@link DelegatingHttpSolrClient#commit(boolean, boolean, boolean)}
   */
  @Test
  public void testCommit12() throws IOException, SolrServerException {
    // Arrange
    HttpSolrClient delegate = mock(HttpSolrClient.class);
    when(delegate.commit(anyBoolean(), anyBoolean(), anyBoolean()))
        .thenThrow(new SolrServerException("An error occurred"));

    // Act and Assert
    assertThrows(SolrServerException.class,
        () -> (new DelegatingHttpSolrClient(delegate, null)).commit(true, true, true));
    verify(delegate).commit(eq(true), eq(true), eq(true));
  }

  /**
   * Method under test:
   * {@link DelegatingHttpSolrClient#DelegatingHttpSolrClient(HttpSolrClient, String)}
   */
  @Test
  public void testNewDelegatingHttpSolrClient2() throws IOException, SolrServerException {
    // Arrange
    HttpSolrClient delegate = mock(HttpSolrClient.class);

    // Act
    DelegatingHttpSolrClient actualDelegatingHttpSolrClient = new DelegatingHttpSolrClient(delegate,
        "https://example.org/example");

    // Assert
    assertEquals("/https://example.org/example", actualDelegatingHttpSolrClient.defaultCollectionPath);
    assertEquals("https://example.org/example", actualDelegatingHttpSolrClient.getDefaultCollection());
    assertNull(actualDelegatingHttpSolrClient.getBinder());
    assertNull(actualDelegatingHttpSolrClient.ping());
    assertSame(delegate, actualDelegatingHttpSolrClient.getDelegate());
  }

  /**
   * Method under test:
   * {@link DelegatingHttpSolrClient#DelegatingHttpSolrClient(HttpSolrClient, String)}
   */
  @Test
  public void testNewDelegatingHttpSolrClient3() throws IOException, SolrServerException {
    // Arrange
    HttpSolrClient delegate = mock(HttpSolrClient.class);

    // Act
    DelegatingHttpSolrClient actualDelegatingHttpSolrClient = new DelegatingHttpSolrClient(delegate, "");

    // Assert
    assertNull(actualDelegatingHttpSolrClient.getDefaultCollection());
    assertNull(actualDelegatingHttpSolrClient.defaultCollectionPath);
    assertNull(actualDelegatingHttpSolrClient.getBinder());
    assertNull(actualDelegatingHttpSolrClient.ping());
    assertNull(actualDelegatingHttpSolrClient.optimize());
    assertNull(actualDelegatingHttpSolrClient.rollback());
    assertSame(delegate, actualDelegatingHttpSolrClient.getDelegate());
  }

  /**
   * Method under test: {@link DelegatingHttpSolrClient#optimize()}
   */
  @Test
  public void testOptimize() throws IOException, SolrServerException {
    // Arrange
    HttpSolrClient delegate = mock(HttpSolrClient.class);
    UpdateResponse updateResponse = new UpdateResponse();
    when(delegate.optimize()).thenReturn(updateResponse);

    // Act
    UpdateResponse actualOptimizeResult = (new DelegatingHttpSolrClient(delegate)).optimize();

    // Assert
    verify(delegate).optimize();
    assertSame(updateResponse, actualOptimizeResult);
  }

  /**
   * Method under test: {@link DelegatingHttpSolrClient#optimize()}
   */
  @Test
  public void testOptimize2() throws IOException, SolrServerException {
    // Arrange
    HttpSolrClient delegate = mock(HttpSolrClient.class);
    UpdateResponse updateResponse = new UpdateResponse();
    when(delegate.optimize(Mockito.<String>any())).thenReturn(updateResponse);
    when(delegate.getBaseURL()).thenReturn("https://example.org/example");

    // Act
    UpdateResponse actualOptimizeResult = (new DelegatingHttpSolrClient(delegate, "https://example.org/example"))
        .optimize();

    // Assert
    verify(delegate).optimize(eq("https://example.org/example"));
    verify(delegate).getBaseURL();
    assertSame(updateResponse, actualOptimizeResult);
  }

  /**
   * Method under test: {@link DelegatingHttpSolrClient#optimize()}
   */
  @Test
  public void testOptimize3() throws IOException, SolrServerException {
    // Arrange
    HttpSolrClient delegate = mock(HttpSolrClient.class);
    when(delegate.optimize(Mockito.<String>any())).thenThrow(new SolrServerException("An error occurred"));
    when(delegate.getBaseURL()).thenReturn("https://example.org/example");

    // Act and Assert
    assertThrows(SolrServerException.class,
        () -> (new DelegatingHttpSolrClient(delegate, "https://example.org/example")).optimize());
    verify(delegate).optimize(eq("https://example.org/example"));
    verify(delegate).getBaseURL();
  }

  /**
   * Method under test: {@link DelegatingHttpSolrClient#optimize()}
   */
  @Test
  public void testOptimize4() throws IOException, SolrServerException {
    // Arrange
    HttpSolrClient delegate = mock(HttpSolrClient.class);
    when(delegate.optimize()).thenThrow(new SolrServerException("An error occurred"));

    // Act and Assert
    assertThrows(SolrServerException.class, () -> (new DelegatingHttpSolrClient(delegate, null)).optimize());
    verify(delegate).optimize();
  }

  /**
   * Method under test:
   * {@link DelegatingHttpSolrClient#optimize(boolean, boolean)}
   */
  @Test
  public void testOptimize5() throws IOException, SolrServerException {
    // Arrange
    HttpSolrClient delegate = mock(HttpSolrClient.class);
    UpdateResponse updateResponse = new UpdateResponse();
    when(delegate.optimize(anyBoolean(), anyBoolean())).thenReturn(updateResponse);

    // Act
    UpdateResponse actualOptimizeResult = (new DelegatingHttpSolrClient(delegate)).optimize(true, true);

    // Assert
    verify(delegate).optimize(eq(true), eq(true));
    assertSame(updateResponse, actualOptimizeResult);
  }

  /**
   * Method under test:
   * {@link DelegatingHttpSolrClient#optimize(boolean, boolean)}
   */
  @Test
  public void testOptimize6() throws IOException, SolrServerException {
    // Arrange
    HttpSolrClient delegate = mock(HttpSolrClient.class);
    UpdateResponse updateResponse = new UpdateResponse();
    when(delegate.optimize(Mockito.<String>any(), anyBoolean(), anyBoolean())).thenReturn(updateResponse);
    when(delegate.getBaseURL()).thenReturn("https://example.org/example");

    // Act
    UpdateResponse actualOptimizeResult = (new DelegatingHttpSolrClient(delegate, "https://example.org/example"))
        .optimize(true, true);

    // Assert
    verify(delegate).optimize(eq("https://example.org/example"), eq(true), eq(true));
    verify(delegate).getBaseURL();
    assertSame(updateResponse, actualOptimizeResult);
  }

  /**
   * Method under test:
   * {@link DelegatingHttpSolrClient#optimize(boolean, boolean)}
   */
  @Test
  public void testOptimize7() throws IOException, SolrServerException {
    // Arrange
    HttpSolrClient delegate = mock(HttpSolrClient.class);
    when(delegate.optimize(Mockito.<String>any(), anyBoolean(), anyBoolean()))
        .thenThrow(new SolrServerException("An error occurred"));
    when(delegate.getBaseURL()).thenReturn("https://example.org/example");

    // Act and Assert
    assertThrows(SolrServerException.class,
        () -> (new DelegatingHttpSolrClient(delegate, "https://example.org/example")).optimize(true, true));
    verify(delegate).optimize(eq("https://example.org/example"), eq(true), eq(true));
    verify(delegate).getBaseURL();
  }

  /**
   * Method under test:
   * {@link DelegatingHttpSolrClient#optimize(boolean, boolean)}
   */
  @Test
  public void testOptimize8() throws IOException, SolrServerException {
    // Arrange
    HttpSolrClient delegate = mock(HttpSolrClient.class);
    when(delegate.optimize(anyBoolean(), anyBoolean())).thenThrow(new SolrServerException("An error occurred"));

    // Act and Assert
    assertThrows(SolrServerException.class, () -> (new DelegatingHttpSolrClient(delegate, null)).optimize(true, true));
    verify(delegate).optimize(eq(true), eq(true));
  }

  /**
   * Method under test:
   * {@link DelegatingHttpSolrClient#optimize(boolean, boolean, int)}
   */
  @Test
  public void testOptimize9() throws IOException, SolrServerException {
    // Arrange
    HttpSolrClient delegate = mock(HttpSolrClient.class);
    UpdateResponse updateResponse = new UpdateResponse();
    when(delegate.optimize(anyBoolean(), anyBoolean(), anyInt())).thenReturn(updateResponse);

    // Act
    UpdateResponse actualOptimizeResult = (new DelegatingHttpSolrClient(delegate)).optimize(true, true, 3);

    // Assert
    verify(delegate).optimize(eq(true), eq(true), eq(3));
    assertSame(updateResponse, actualOptimizeResult);
  }

  /**
   * Method under test:
   * {@link DelegatingHttpSolrClient#optimize(boolean, boolean, int)}
   */
  @Test
  public void testOptimize10() throws IOException, SolrServerException {
    // Arrange
    HttpSolrClient delegate = mock(HttpSolrClient.class);
    UpdateResponse updateResponse = new UpdateResponse();
    when(delegate.optimize(Mockito.<String>any(), anyBoolean(), anyBoolean(), anyInt())).thenReturn(updateResponse);
    when(delegate.getBaseURL()).thenReturn("https://example.org/example");

    // Act
    UpdateResponse actualOptimizeResult = (new DelegatingHttpSolrClient(delegate, "https://example.org/example"))
        .optimize(true, true, 3);

    // Assert
    verify(delegate).optimize(eq("https://example.org/example"), eq(true), eq(true), eq(3));
    verify(delegate).getBaseURL();
    assertSame(updateResponse, actualOptimizeResult);
  }

  /**
   * Method under test:
   * {@link DelegatingHttpSolrClient#optimize(boolean, boolean, int)}
   */
  @Test
  public void testOptimize11() throws IOException, SolrServerException {
    // Arrange
    HttpSolrClient delegate = mock(HttpSolrClient.class);
    when(delegate.optimize(Mockito.<String>any(), anyBoolean(), anyBoolean(), anyInt()))
        .thenThrow(new SolrServerException("An error occurred"));
    when(delegate.getBaseURL()).thenReturn("https://example.org/example");

    // Act and Assert
    assertThrows(SolrServerException.class,
        () -> (new DelegatingHttpSolrClient(delegate, "https://example.org/example")).optimize(true, true, 3));
    verify(delegate).optimize(eq("https://example.org/example"), eq(true), eq(true), eq(3));
    verify(delegate).getBaseURL();
  }

  /**
   * Method under test:
   * {@link DelegatingHttpSolrClient#optimize(boolean, boolean, int)}
   */
  @Test
  public void testOptimize12() throws IOException, SolrServerException {
    // Arrange
    HttpSolrClient delegate = mock(HttpSolrClient.class);
    when(delegate.optimize(anyBoolean(), anyBoolean(), anyInt()))
        .thenThrow(new SolrServerException("An error occurred"));

    // Act and Assert
    assertThrows(SolrServerException.class,
        () -> (new DelegatingHttpSolrClient(delegate, null)).optimize(true, true, 3));
    verify(delegate).optimize(eq(true), eq(true), eq(3));
  }

  /**
   * Method under test: {@link DelegatingHttpSolrClient#rollback()}
   */
  @Test
  public void testRollback() throws IOException, SolrServerException {
    // Arrange
    HttpSolrClient delegate = mock(HttpSolrClient.class);
    UpdateResponse updateResponse = new UpdateResponse();
    when(delegate.rollback()).thenReturn(updateResponse);

    // Act
    UpdateResponse actualRollbackResult = (new DelegatingHttpSolrClient(delegate)).rollback();

    // Assert
    verify(delegate).rollback();
    assertSame(updateResponse, actualRollbackResult);
  }

  /**
   * Method under test: {@link DelegatingHttpSolrClient#rollback()}
   */
  @Test
  public void testRollback2() throws IOException, SolrServerException {
    // Arrange
    HttpSolrClient delegate = mock(HttpSolrClient.class);
    UpdateResponse updateResponse = new UpdateResponse();
    when(delegate.rollback(Mockito.<String>any())).thenReturn(updateResponse);
    when(delegate.getBaseURL()).thenReturn("https://example.org/example");

    // Act
    UpdateResponse actualRollbackResult = (new DelegatingHttpSolrClient(delegate, "https://example.org/example"))
        .rollback();

    // Assert
    verify(delegate).rollback(eq("https://example.org/example"));
    verify(delegate).getBaseURL();
    assertSame(updateResponse, actualRollbackResult);
  }

  /**
   * Method under test: {@link DelegatingHttpSolrClient#rollback()}
   */
  @Test
  public void testRollback3() throws IOException, SolrServerException {
    // Arrange
    HttpSolrClient delegate = mock(HttpSolrClient.class);
    when(delegate.rollback(Mockito.<String>any())).thenThrow(new SolrServerException("An error occurred"));
    when(delegate.getBaseURL()).thenReturn("https://example.org/example");

    // Act and Assert
    assertThrows(SolrServerException.class,
        () -> (new DelegatingHttpSolrClient(delegate, "https://example.org/example")).rollback());
    verify(delegate).rollback(eq("https://example.org/example"));
    verify(delegate).getBaseURL();
  }

  /**
   * Method under test: {@link DelegatingHttpSolrClient#rollback()}
   */
  @Test
  public void testRollback4() throws IOException, SolrServerException {
    // Arrange
    HttpSolrClient delegate = mock(HttpSolrClient.class);
    when(delegate.rollback()).thenThrow(new SolrServerException("An error occurred"));

    // Act and Assert
    assertThrows(SolrServerException.class, () -> (new DelegatingHttpSolrClient(delegate, null)).rollback());
    verify(delegate).rollback();
  }

  /**
   * Method under test: {@link DelegatingHttpSolrClient#ping()}
   */
  @Test
  public void testPing() throws IOException, SolrServerException {
    // Arrange
    HttpSolrClient delegate = mock(HttpSolrClient.class);
    SolrPingResponse solrPingResponse = new SolrPingResponse();
    when(delegate.ping()).thenReturn(solrPingResponse);

    // Act
    SolrPingResponse actualPingResult = (new DelegatingHttpSolrClient(delegate)).ping();

    // Assert
    verify(delegate).ping();
    assertSame(solrPingResponse, actualPingResult);
  }

  /**
   * Method under test: {@link DelegatingHttpSolrClient#ping()}
   */
  @Test
  public void testPing2() throws IOException, SolrServerException {
    // Arrange
    HttpSolrClient delegate = mock(HttpSolrClient.class);
    when(delegate.ping()).thenThrow(new SolrServerException("An error occurred"));

    // Act and Assert
    assertThrows(SolrServerException.class,
        () -> (new DelegatingHttpSolrClient(delegate, "https://example.org/example")).ping());
    verify(delegate).ping();
  }

  /**
   * Method under test: {@link DelegatingHttpSolrClient#query(SolrParams)}
   */
  @Test
  public void testQuery() throws IOException, SolrServerException {
    // Arrange
    HttpSolrClient delegate = mock(HttpSolrClient.class);
    QueryResponse queryResponse = new QueryResponse();
    when(delegate.query(Mockito.<SolrParams>any())).thenReturn(queryResponse);
    DelegatingHttpSolrClient delegatingHttpSolrClient = new DelegatingHttpSolrClient(delegate);

    // Act
    QueryResponse actualQueryResult = delegatingHttpSolrClient.query(new SolrQuery("foo"));

    // Assert
    verify(delegate).query(isA(SolrParams.class));
    assertSame(queryResponse, actualQueryResult);
  }

  /**
   * Method under test: {@link DelegatingHttpSolrClient#query(SolrParams)}
   */
  @Test
  public void testQuery2() throws IOException, SolrServerException {
    // Arrange
    HttpSolrClient delegate = mock(HttpSolrClient.class);
    QueryResponse queryResponse = new QueryResponse();
    when(delegate.query(Mockito.<String>any(), Mockito.<SolrParams>any())).thenReturn(queryResponse);
    when(delegate.getBaseURL()).thenReturn("https://example.org/example");
    DelegatingHttpSolrClient delegatingHttpSolrClient = new DelegatingHttpSolrClient(delegate,
        "https://example.org/example");

    // Act
    QueryResponse actualQueryResult = delegatingHttpSolrClient.query(new SolrQuery("foo"));

    // Assert
    verify(delegate).query(eq("https://example.org/example"), isA(SolrParams.class));
    verify(delegate).getBaseURL();
    assertSame(queryResponse, actualQueryResult);
  }

  /**
   * Method under test: {@link DelegatingHttpSolrClient#query(SolrParams)}
   */
  @Test
  public void testQuery3() throws IOException, SolrServerException {
    // Arrange
    HttpSolrClient delegate = mock(HttpSolrClient.class);
    when(delegate.query(Mockito.<String>any(), Mockito.<SolrParams>any()))
        .thenThrow(new SolrServerException("An error occurred"));
    when(delegate.getBaseURL()).thenReturn("https://example.org/example");
    DelegatingHttpSolrClient delegatingHttpSolrClient = new DelegatingHttpSolrClient(delegate,
        "https://example.org/example");

    // Act and Assert
    assertThrows(SolrServerException.class, () -> delegatingHttpSolrClient.query(new SolrQuery("foo")));
    verify(delegate).query(eq("https://example.org/example"), isA(SolrParams.class));
    verify(delegate).getBaseURL();
  }

  /**
   * Method under test: {@link DelegatingHttpSolrClient#query(SolrParams)}
   */
  @Test
  public void testQuery4() throws IOException, SolrServerException {
    // Arrange
    HttpSolrClient delegate = mock(HttpSolrClient.class);
    when(delegate.query(Mockito.<SolrParams>any())).thenThrow(new SolrServerException("An error occurred"));
    DelegatingHttpSolrClient delegatingHttpSolrClient = new DelegatingHttpSolrClient(delegate, null);

    // Act and Assert
    assertThrows(SolrServerException.class, () -> delegatingHttpSolrClient.query(new SolrQuery("foo")));
    verify(delegate).query(isA(SolrParams.class));
  }

  /**
   * Method under test:
   * {@link DelegatingHttpSolrClient#query(SolrParams, SolrRequest.METHOD)}
   */
  @Test
  public void testQuery5() throws IOException, SolrServerException {
    // Arrange
    HttpSolrClient delegate = mock(HttpSolrClient.class);
    QueryResponse queryResponse = new QueryResponse();
    when(delegate.query(Mockito.<SolrParams>any(), Mockito.<SolrRequest.METHOD>any())).thenReturn(queryResponse);
    DelegatingHttpSolrClient delegatingHttpSolrClient = new DelegatingHttpSolrClient(delegate);

    // Act
    QueryResponse actualQueryResult = delegatingHttpSolrClient.query(new SolrQuery("foo"), SolrRequest.METHOD.GET);

    // Assert
    verify(delegate).query(isA(SolrParams.class), eq(SolrRequest.METHOD.GET));
    assertSame(queryResponse, actualQueryResult);
  }

  /**
   * Method under test:
   * {@link DelegatingHttpSolrClient#query(SolrParams, SolrRequest.METHOD)}
   */
  @Test
  public void testQuery6() throws IOException, SolrServerException {
    // Arrange
    HttpSolrClient delegate = mock(HttpSolrClient.class);
    QueryResponse queryResponse = new QueryResponse();
    when(delegate.query(Mockito.<String>any(), Mockito.<SolrParams>any(), Mockito.<SolrRequest.METHOD>any()))
        .thenReturn(queryResponse);
    when(delegate.getBaseURL()).thenReturn("https://example.org/example");
    DelegatingHttpSolrClient delegatingHttpSolrClient = new DelegatingHttpSolrClient(delegate,
        "https://example.org/example");

    // Act
    QueryResponse actualQueryResult = delegatingHttpSolrClient.query(new SolrQuery("foo"), SolrRequest.METHOD.GET);

    // Assert
    verify(delegate).query(eq("https://example.org/example"), isA(SolrParams.class), eq(SolrRequest.METHOD.GET));
    verify(delegate).getBaseURL();
    assertSame(queryResponse, actualQueryResult);
  }

  /**
   * Method under test:
   * {@link DelegatingHttpSolrClient#query(SolrParams, SolrRequest.METHOD)}
   */
  @Test
  public void testQuery7() throws IOException, SolrServerException {
    // Arrange
    HttpSolrClient delegate = mock(HttpSolrClient.class);
    when(delegate.query(Mockito.<String>any(), Mockito.<SolrParams>any(), Mockito.<SolrRequest.METHOD>any()))
        .thenThrow(new SolrServerException("An error occurred"));
    when(delegate.getBaseURL()).thenReturn("https://example.org/example");
    DelegatingHttpSolrClient delegatingHttpSolrClient = new DelegatingHttpSolrClient(delegate,
        "https://example.org/example");

    // Act and Assert
    assertThrows(SolrServerException.class,
        () -> delegatingHttpSolrClient.query(new SolrQuery("foo"), SolrRequest.METHOD.GET));
    verify(delegate).query(eq("https://example.org/example"), isA(SolrParams.class), eq(SolrRequest.METHOD.GET));
    verify(delegate).getBaseURL();
  }

  /**
   * Method under test:
   * {@link DelegatingHttpSolrClient#query(SolrParams, SolrRequest.METHOD)}
   */
  @Test
  public void testQuery8() throws IOException, SolrServerException {
    // Arrange
    HttpSolrClient delegate = mock(HttpSolrClient.class);
    when(delegate.query(Mockito.<SolrParams>any(), Mockito.<SolrRequest.METHOD>any()))
        .thenThrow(new SolrServerException("An error occurred"));
    DelegatingHttpSolrClient delegatingHttpSolrClient = new DelegatingHttpSolrClient(delegate, null);

    // Act and Assert
    assertThrows(SolrServerException.class,
        () -> delegatingHttpSolrClient.query(new SolrQuery("foo"), SolrRequest.METHOD.GET));
    verify(delegate).query(isA(SolrParams.class), eq(SolrRequest.METHOD.GET));
  }

  /**
   * Method under test:
   * {@link DelegatingHttpSolrClient#queryAndStreamResponse(SolrParams, StreamingResponseCallback)}
   */
  @Test
  public void testQueryAndStreamResponse() throws IOException, SolrServerException {
    // Arrange
    HttpSolrClient delegate = mock(HttpSolrClient.class);
    QueryResponse queryResponse = new QueryResponse();
    when(delegate.queryAndStreamResponse(Mockito.<SolrParams>any(), Mockito.<StreamingResponseCallback>any()))
        .thenReturn(queryResponse);
    DelegatingHttpSolrClient delegatingHttpSolrClient = new DelegatingHttpSolrClient(delegate);

    // Act
    QueryResponse actualQueryAndStreamResponseResult = delegatingHttpSolrClient
        .queryAndStreamResponse(new SolrQuery("foo"), mock(StreamingResponseCallback.class));

    // Assert
    verify(delegate).queryAndStreamResponse(isA(SolrParams.class), isA(StreamingResponseCallback.class));
    assertSame(queryResponse, actualQueryAndStreamResponseResult);
  }

  /**
   * Method under test:
   * {@link DelegatingHttpSolrClient#queryAndStreamResponse(SolrParams, StreamingResponseCallback)}
   */
  @Test
  public void testQueryAndStreamResponse2() throws IOException, SolrServerException {
    // Arrange
    HttpSolrClient delegate = mock(HttpSolrClient.class);
    QueryResponse queryResponse = new QueryResponse();
    when(delegate.queryAndStreamResponse(Mockito.<String>any(), Mockito.<SolrParams>any(),
        Mockito.<StreamingResponseCallback>any())).thenReturn(queryResponse);
    when(delegate.getBaseURL()).thenReturn("https://example.org/example");
    DelegatingHttpSolrClient delegatingHttpSolrClient = new DelegatingHttpSolrClient(delegate,
        "https://example.org/example");

    // Act
    QueryResponse actualQueryAndStreamResponseResult = delegatingHttpSolrClient
        .queryAndStreamResponse(new SolrQuery("foo"), mock(StreamingResponseCallback.class));

    // Assert
    verify(delegate).queryAndStreamResponse(eq("https://example.org/example"), isA(SolrParams.class),
        isA(StreamingResponseCallback.class));
    verify(delegate).getBaseURL();
    assertSame(queryResponse, actualQueryAndStreamResponseResult);
  }

  /**
   * Method under test:
   * {@link DelegatingHttpSolrClient#queryAndStreamResponse(SolrParams, StreamingResponseCallback)}
   */
  @Test
  public void testQueryAndStreamResponse3() throws IOException, SolrServerException {
    // Arrange
    HttpSolrClient delegate = mock(HttpSolrClient.class);
    when(delegate.queryAndStreamResponse(Mockito.<String>any(), Mockito.<SolrParams>any(),
        Mockito.<StreamingResponseCallback>any())).thenThrow(new SolrServerException("An error occurred"));
    when(delegate.getBaseURL()).thenReturn("https://example.org/example");
    DelegatingHttpSolrClient delegatingHttpSolrClient = new DelegatingHttpSolrClient(delegate,
        "https://example.org/example");

    // Act and Assert
    assertThrows(SolrServerException.class, () -> delegatingHttpSolrClient.queryAndStreamResponse(new SolrQuery("foo"),
        mock(StreamingResponseCallback.class)));
    verify(delegate).queryAndStreamResponse(eq("https://example.org/example"), isA(SolrParams.class),
        isA(StreamingResponseCallback.class));
    verify(delegate).getBaseURL();
  }

  /**
   * Method under test:
   * {@link DelegatingHttpSolrClient#queryAndStreamResponse(SolrParams, StreamingResponseCallback)}
   */
  @Test
  public void testQueryAndStreamResponse4() throws IOException, SolrServerException {
    // Arrange
    HttpSolrClient delegate = mock(HttpSolrClient.class);
    when(delegate.queryAndStreamResponse(Mockito.<SolrParams>any(), Mockito.<StreamingResponseCallback>any()))
        .thenThrow(new SolrServerException("An error occurred"));
    DelegatingHttpSolrClient delegatingHttpSolrClient = new DelegatingHttpSolrClient(delegate, null);

    // Act and Assert
    assertThrows(SolrServerException.class, () -> delegatingHttpSolrClient.queryAndStreamResponse(new SolrQuery("foo"),
        mock(StreamingResponseCallback.class)));
    verify(delegate).queryAndStreamResponse(isA(SolrParams.class), isA(StreamingResponseCallback.class));
  }

  /**
   * Method under test: {@link DelegatingHttpSolrClient#getById(Collection)}
   */
  @Test
  public void testGetById() throws IOException, SolrServerException {
    // Arrange
    HttpSolrClient delegate = mock(HttpSolrClient.class);
    SolrDocumentList solrDocumentList = new SolrDocumentList();
    when(delegate.getById(Mockito.<Collection<String>>any())).thenReturn(solrDocumentList);
    DelegatingHttpSolrClient delegatingHttpSolrClient = new DelegatingHttpSolrClient(delegate);

    // Act
    SolrDocumentList actualById = delegatingHttpSolrClient.getById(new ArrayList<>());

    // Assert
    verify(delegate).getById(isA(Collection.class));
    assertTrue(actualById.isEmpty());
    assertSame(solrDocumentList, actualById);
  }

  /**
   * Method under test: {@link DelegatingHttpSolrClient#getById(Collection)}
   */
  @Test
  public void testGetById2() throws IOException, SolrServerException {
    // Arrange
    HttpSolrClient delegate = mock(HttpSolrClient.class);
    SolrDocumentList solrDocumentList = new SolrDocumentList();
    when(delegate.getById(Mockito.<String>any(), Mockito.<Collection<String>>any())).thenReturn(solrDocumentList);
    when(delegate.getBaseURL()).thenReturn("https://example.org/example");
    DelegatingHttpSolrClient delegatingHttpSolrClient = new DelegatingHttpSolrClient(delegate,
        "https://example.org/example");

    // Act
    SolrDocumentList actualById = delegatingHttpSolrClient.getById(new ArrayList<>());

    // Assert
    verify(delegate).getById(eq("https://example.org/example"), isA(Collection.class));
    verify(delegate).getBaseURL();
    assertTrue(actualById.isEmpty());
    assertSame(solrDocumentList, actualById);
  }

  /**
   * Method under test: {@link DelegatingHttpSolrClient#getById(Collection)}
   */
  @Test
  public void testGetById3() throws IOException, SolrServerException {
    // Arrange
    HttpSolrClient delegate = mock(HttpSolrClient.class);
    when(delegate.getById(Mockito.<String>any(), Mockito.<Collection<String>>any()))
        .thenThrow(new SolrServerException("An error occurred"));
    when(delegate.getBaseURL()).thenReturn("https://example.org/example");
    DelegatingHttpSolrClient delegatingHttpSolrClient = new DelegatingHttpSolrClient(delegate,
        "https://example.org/example");

    // Act and Assert
    assertThrows(SolrServerException.class, () -> delegatingHttpSolrClient.getById(new ArrayList<>()));
    verify(delegate).getById(eq("https://example.org/example"), isA(Collection.class));
    verify(delegate).getBaseURL();
  }

  /**
   * Method under test: {@link DelegatingHttpSolrClient#getById(Collection)}
   */
  @Test
  public void testGetById4() throws IOException, SolrServerException {
    // Arrange
    HttpSolrClient delegate = mock(HttpSolrClient.class);
    when(delegate.getById(Mockito.<Collection<String>>any())).thenThrow(new SolrServerException("An error occurred"));
    DelegatingHttpSolrClient delegatingHttpSolrClient = new DelegatingHttpSolrClient(delegate, null);

    // Act and Assert
    assertThrows(SolrServerException.class, () -> delegatingHttpSolrClient.getById(new ArrayList<>()));
    verify(delegate).getById(isA(Collection.class));
  }

  /**
   * Method under test: {@link DelegatingHttpSolrClient#getById(Collection)}
   */
  @Test
  public void testGetById5() throws IOException, SolrServerException {
    // Arrange
    HttpSolrClient delegate = mock(HttpSolrClient.class);
    when(delegate.getById(Mockito.<Collection<String>>any())).thenThrow(new SolrServerException("An error occurred"));
    DelegatingHttpSolrClient delegatingHttpSolrClient = new DelegatingHttpSolrClient(delegate, null);

    ArrayList<String> ids = new ArrayList<>();
    ids.add("foo");

    // Act and Assert
    assertThrows(SolrServerException.class, () -> delegatingHttpSolrClient.getById(ids));
    verify(delegate).getById(isA(Collection.class));
  }

  /**
   * Method under test: {@link DelegatingHttpSolrClient#getById(Collection)}
   */
  @Test
  public void testGetById6() throws IOException, SolrServerException {
    // Arrange
    HttpSolrClient delegate = mock(HttpSolrClient.class);
    when(delegate.getById(Mockito.<Collection<String>>any())).thenThrow(new SolrServerException("An error occurred"));
    DelegatingHttpSolrClient delegatingHttpSolrClient = new DelegatingHttpSolrClient(delegate, null);

    ArrayList<String> ids = new ArrayList<>();
    ids.add("42");
    ids.add("foo");

    // Act and Assert
    assertThrows(SolrServerException.class, () -> delegatingHttpSolrClient.getById(ids));
    verify(delegate).getById(isA(Collection.class));
  }

  /**
   * Method under test:
   * {@link DelegatingHttpSolrClient#getById(Collection, SolrParams)}
   */
  @Test
  public void testGetById7() throws IOException, SolrServerException {
    // Arrange
    HttpSolrClient delegate = mock(HttpSolrClient.class);
    SolrDocumentList solrDocumentList = new SolrDocumentList();
    when(delegate.getById(Mockito.<Collection<String>>any(), Mockito.<SolrParams>any())).thenReturn(solrDocumentList);
    DelegatingHttpSolrClient delegatingHttpSolrClient = new DelegatingHttpSolrClient(delegate);
    ArrayList<String> ids = new ArrayList<>();

    // Act
    SolrDocumentList actualById = delegatingHttpSolrClient.getById(ids, new SolrQuery("foo"));

    // Assert
    verify(delegate).getById(isA(Collection.class), isA(SolrParams.class));
    assertTrue(actualById.isEmpty());
    assertSame(solrDocumentList, actualById);
  }

  /**
   * Method under test:
   * {@link DelegatingHttpSolrClient#getById(Collection, SolrParams)}
   */
  @Test
  public void testGetById8() throws IOException, SolrServerException {
    // Arrange
    HttpSolrClient delegate = mock(HttpSolrClient.class);
    SolrDocumentList solrDocumentList = new SolrDocumentList();
    when(delegate.getById(Mockito.<String>any(), Mockito.<Collection<String>>any(), Mockito.<SolrParams>any()))
        .thenReturn(solrDocumentList);
    when(delegate.getBaseURL()).thenReturn("https://example.org/example");
    DelegatingHttpSolrClient delegatingHttpSolrClient = new DelegatingHttpSolrClient(delegate,
        "https://example.org/example");
    ArrayList<String> ids = new ArrayList<>();

    // Act
    SolrDocumentList actualById = delegatingHttpSolrClient.getById(ids, new SolrQuery("foo"));

    // Assert
    verify(delegate).getById(eq("https://example.org/example"), isA(Collection.class), isA(SolrParams.class));
    verify(delegate).getBaseURL();
    assertTrue(actualById.isEmpty());
    assertSame(solrDocumentList, actualById);
  }

  /**
   * Method under test:
   * {@link DelegatingHttpSolrClient#getById(Collection, SolrParams)}
   */
  @Test
  public void testGetById9() throws IOException, SolrServerException {
    // Arrange
    HttpSolrClient delegate = mock(HttpSolrClient.class);
    when(delegate.getById(Mockito.<String>any(), Mockito.<Collection<String>>any(), Mockito.<SolrParams>any()))
        .thenThrow(new SolrServerException("An error occurred"));
    when(delegate.getBaseURL()).thenReturn("https://example.org/example");
    DelegatingHttpSolrClient delegatingHttpSolrClient = new DelegatingHttpSolrClient(delegate,
        "https://example.org/example");
    ArrayList<String> ids = new ArrayList<>();

    // Act and Assert
    assertThrows(SolrServerException.class, () -> delegatingHttpSolrClient.getById(ids, new SolrQuery("foo")));
    verify(delegate).getById(eq("https://example.org/example"), isA(Collection.class), isA(SolrParams.class));
    verify(delegate).getBaseURL();
  }

  /**
   * Method under test:
   * {@link DelegatingHttpSolrClient#getById(Collection, SolrParams)}
   */
  @Test
  public void testGetById10() throws IOException, SolrServerException {
    // Arrange
    HttpSolrClient delegate = mock(HttpSolrClient.class);
    when(delegate.getById(Mockito.<Collection<String>>any(), Mockito.<SolrParams>any()))
        .thenThrow(new SolrServerException("An error occurred"));
    DelegatingHttpSolrClient delegatingHttpSolrClient = new DelegatingHttpSolrClient(delegate, null);
    ArrayList<String> ids = new ArrayList<>();

    // Act and Assert
    assertThrows(SolrServerException.class, () -> delegatingHttpSolrClient.getById(ids, new SolrQuery("foo")));
    verify(delegate).getById(isA(Collection.class), isA(SolrParams.class));
  }

  /**
   * Method under test:
   * {@link DelegatingHttpSolrClient#getById(Collection, SolrParams)}
   */
  @Test
  public void testGetById11() throws IOException, SolrServerException {
    // Arrange
    HttpSolrClient delegate = mock(HttpSolrClient.class);
    when(delegate.getById(Mockito.<Collection<String>>any(), Mockito.<SolrParams>any()))
        .thenThrow(new SolrServerException("An error occurred"));
    DelegatingHttpSolrClient delegatingHttpSolrClient = new DelegatingHttpSolrClient(delegate, null);

    ArrayList<String> ids = new ArrayList<>();
    ids.add("foo");

    // Act and Assert
    assertThrows(SolrServerException.class, () -> delegatingHttpSolrClient.getById(ids, new SolrQuery("foo")));
    verify(delegate).getById(isA(Collection.class), isA(SolrParams.class));
  }

  /**
   * Method under test:
   * {@link DelegatingHttpSolrClient#getById(Collection, SolrParams)}
   */
  @Test
  public void testGetById12() throws IOException, SolrServerException {
    // Arrange
    HttpSolrClient delegate = mock(HttpSolrClient.class);
    when(delegate.getById(Mockito.<Collection<String>>any(), Mockito.<SolrParams>any()))
        .thenThrow(new SolrServerException("An error occurred"));
    DelegatingHttpSolrClient delegatingHttpSolrClient = new DelegatingHttpSolrClient(delegate, null);

    ArrayList<String> ids = new ArrayList<>();
    ids.add("42");
    ids.add("foo");

    // Act and Assert
    assertThrows(SolrServerException.class, () -> delegatingHttpSolrClient.getById(ids, new SolrQuery("foo")));
    verify(delegate).getById(isA(Collection.class), isA(SolrParams.class));
  }

  /**
   * Method under test: {@link DelegatingHttpSolrClient#getBinder()}
   */
  @Test
  public void testGetBinder() {
    // Arrange
    HttpSolrClient delegate = mock(HttpSolrClient.class);
    DocumentObjectBinder documentObjectBinder = new DocumentObjectBinder();
    when(delegate.getBinder()).thenReturn(documentObjectBinder);

    // Act
    DocumentObjectBinder actualBinder = (new DelegatingHttpSolrClient(delegate)).getBinder();

    // Assert
    verify(delegate).getBinder();
    assertSame(documentObjectBinder, actualBinder);
  }

  /**
   * Method under test: {@link DelegatingHttpSolrClient#close()}
   */
  @Test
  public void testClose() throws IOException {
    // Arrange
    HttpSolrClient delegate = mock(HttpSolrClient.class);
    doNothing().when(delegate).close();

    // Act
    (new DelegatingHttpSolrClient(delegate)).close();

    // Assert
    verify(delegate).close();
  }

  /**
   * Method under test: {@link DelegatingHttpSolrClient#close()}
   */
  @Test
  public void testClose2() throws IOException {
    // Arrange
    HttpSolrClient delegate = mock(HttpSolrClient.class);
    doThrow(new IOException("foo")).when(delegate).close();

    // Act and Assert
    assertThrows(IOException.class,
        () -> (new DelegatingHttpSolrClient(delegate, "https://example.org/example")).close());
    verify(delegate).close();
  }

  /**
   * Method under test:
   * {@link DelegatingHttpSolrClient#DelegatingHttpSolrClient(HttpSolrClient)}
   */
  @Test
  public void testNewDelegatingHttpSolrClient() throws IOException, SolrServerException {
    // Arrange
    HttpSolrClient delegate = mock(HttpSolrClient.class);

    // Act
    DelegatingHttpSolrClient actualDelegatingHttpSolrClient = new DelegatingHttpSolrClient(delegate);

    // Assert
    assertNull(actualDelegatingHttpSolrClient.getDefaultCollection());
    assertNull(actualDelegatingHttpSolrClient.defaultCollectionPath);
    assertNull(actualDelegatingHttpSolrClient.getBinder());
    assertNull(actualDelegatingHttpSolrClient.ping());
    assertNull(actualDelegatingHttpSolrClient.optimize());
    assertNull(actualDelegatingHttpSolrClient.rollback());
    assertSame(delegate, actualDelegatingHttpSolrClient.getDelegate());
  }
}
