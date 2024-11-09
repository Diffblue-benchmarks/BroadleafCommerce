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
package org.broadleafcommerce.core.search.service.solr.index;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.http.impl.client.AutoRetryHttpClient;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.embedded.SSLConfig;
import org.apache.solr.client.solrj.impl.BinaryResponseParser;
import org.apache.solr.client.solrj.impl.Http2SolrClient;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.impl.LBHttp2SolrClient;
import org.apache.solr.client.solrj.response.UpdateResponse;
import org.apache.solr.common.SolrInputDocument;
import org.broadleafcommerce.common.exception.ServiceException;
import org.broadleafcommerce.common.locale.domain.Locale;
import org.broadleafcommerce.common.locale.domain.LocaleImpl;
import org.broadleafcommerce.core.catalog.domain.Indexable;
import org.broadleafcommerce.core.catalog.domain.ProductBundleImpl;
import org.broadleafcommerce.core.search.dao.CatalogStructure;
import org.broadleafcommerce.core.search.domain.FieldImpl;
import org.broadleafcommerce.core.search.domain.IndexField;
import org.broadleafcommerce.core.search.domain.IndexFieldImpl;
import org.broadleafcommerce.core.search.service.solr.DelegatingHttpSolrClient;
import org.broadleafcommerce.core.search.service.solr.index.SolrIndexCachedOperation.CacheOperation;
import org.junit.Test;
import org.mockito.Mockito;

public class SolrIndexServiceImplDiffblueTest {
  /**
   * Test {@link SolrIndexServiceImpl#performCachedOperation(CacheOperation)}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SolrIndexServiceImpl#performCachedOperation(SolrIndexCachedOperation.CacheOperation)}
   */
  @Test
  public void testPerformCachedOperation_thenThrowIllegalStateException() throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SolrIndexServiceImpl solrIndexServiceImpl = new SolrIndexServiceImpl();
    SolrIndexCachedOperation.CacheOperation cacheOperation = mock(SolrIndexCachedOperation.CacheOperation.class);
    doThrow(new IllegalStateException("ThreadLocalManager.notify.orphans")).when(cacheOperation).execute();

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> solrIndexServiceImpl.performCachedOperation(cacheOperation));
    verify(cacheOperation).execute();
  }

  /**
   * Test {@link SolrIndexServiceImpl#performCachedOperation(CacheOperation)}.
   * <ul>
   *   <li>When {@link CacheOperation} {@link CacheOperation#execute()} does
   * nothing.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SolrIndexServiceImpl#performCachedOperation(SolrIndexCachedOperation.CacheOperation)}
   */
  @Test
  public void testPerformCachedOperation_whenCacheOperationExecuteDoesNothing() throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SolrIndexServiceImpl solrIndexServiceImpl = new SolrIndexServiceImpl();
    SolrIndexCachedOperation.CacheOperation cacheOperation = mock(SolrIndexCachedOperation.CacheOperation.class);
    doNothing().when(cacheOperation).execute();

    // Act
    solrIndexServiceImpl.performCachedOperation(cacheOperation);

    // Assert
    verify(cacheOperation).execute();
  }

  /**
   * Test
   * {@link SolrIndexServiceImpl#executeSolrIndexOperation(SolrIndexOperation)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SolrIndexServiceImpl#executeSolrIndexOperation(SolrIndexOperation)}
   */
  @Test
  public void testExecuteSolrIndexOperation_thenThrowRuntimeException() throws IOException, ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SolrIndexServiceImpl solrIndexServiceImpl = new SolrIndexServiceImpl();
    SolrIndexOperation operation = mock(SolrIndexOperation.class);
    when(operation.obtainLock()).thenThrow(new RuntimeException("Executing Indexing operation"));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> solrIndexServiceImpl.executeSolrIndexOperation(operation));
    verify(operation).obtainLock();
  }

  /**
   * Test {@link SolrIndexServiceImpl#deleteAllDocuments(String, SolrClient)} with
   * {@code collection}, {@code server}.
   * <p>
   * Method under test:
   * {@link SolrIndexServiceImpl#deleteAllDocuments(String, SolrClient)}
   */
  @Test
  public void testDeleteAllDocumentsWithCollectionServer() throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SolrIndexServiceImpl solrIndexServiceImpl = new SolrIndexServiceImpl();
    Http2SolrClient.Builder connectionTimeoutResult = (new Http2SolrClient.Builder()).connectionTimeout(1);
    Http2SolrClient.Builder connectionTimeoutResult2 = (new Http2SolrClient.Builder()).connectionTimeout(1);
    Http2SolrClient.Builder connectionTimeoutResult3 = (new Http2SolrClient.Builder()).connectionTimeout(1);
    Http2SolrClient.Builder connectionTimeoutResult4 = (new Http2SolrClient.Builder()).connectionTimeout(1);
    Http2SolrClient httpClient = (new Http2SolrClient.Builder()).build();
    Http2SolrClient httpClient2 = connectionTimeoutResult4.withHttpClient(httpClient)
        .idleTimeout(1)
        .maxConnectionsPerHost(3)
        .withSSLConfig(null)
        .useHttp1_1(true)
        .build();
    Http2SolrClient.Builder maxConnectionsPerHostResult = connectionTimeoutResult3.withHttpClient(httpClient2)
        .idleTimeout(1)
        .maxConnectionsPerHost(3);
    Http2SolrClient httpClient3 = maxConnectionsPerHostResult
        .withSSLConfig(new SSLConfig(true, true, "Key Store", "iloveyou", "Trust Store", "iloveyou"))
        .useHttp1_1(true)
        .build();
    Http2SolrClient.Builder maxConnectionsPerHostResult2 = connectionTimeoutResult2.withHttpClient(httpClient3)
        .idleTimeout(1)
        .maxConnectionsPerHost(3);
    Http2SolrClient httpClient4 = maxConnectionsPerHostResult2
        .withSSLConfig(new SSLConfig(true, true, "Key Store", "iloveyou", "Trust Store", "iloveyou"))
        .useHttp1_1(true)
        .build();
    Http2SolrClient.Builder maxConnectionsPerHostResult3 = connectionTimeoutResult.withHttpClient(httpClient4)
        .idleTimeout(1)
        .maxConnectionsPerHost(3);
    Http2SolrClient httpClient5 = maxConnectionsPerHostResult3
        .withSSLConfig(new SSLConfig(true, true, "Key Store", "iloveyou", "Trust Store", "iloveyou"))
        .useHttp1_1(true)
        .build();

    // Act and Assert
    assertThrows(ServiceException.class, () -> solrIndexServiceImpl.deleteAllDocuments("Collection",
        new LBHttp2SolrClient(httpClient5, "https://example.org/example")));
  }

  /**
   * Test {@link SolrIndexServiceImpl#deleteAllDocuments(String, SolrClient)} with
   * {@code collection}, {@code server}.
   * <p>
   * Method under test:
   * {@link SolrIndexServiceImpl#deleteAllDocuments(String, SolrClient)}
   */
  @Test
  public void testDeleteAllDocumentsWithCollectionServer2() throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SolrIndexServiceImpl solrIndexServiceImpl = new SolrIndexServiceImpl();
    HttpSolrClient.Builder withConnectionTimeoutResult = (new HttpSolrClient.Builder())
        .withBaseSolrUrl("https://example.org/example")
        .allowCompression(true)
        .withConnectionTimeout(10);
    HttpSolrClient.Builder withHttpClientResult = withConnectionTimeoutResult.withHttpClient(new AutoRetryHttpClient());
    HttpSolrClient delegate = withHttpClientResult.withResponseParser(new BinaryResponseParser())
        .withSocketTimeout(10)
        .build();

    // Act and Assert
    assertThrows(ServiceException.class,
        () -> solrIndexServiceImpl.deleteAllDocuments("Collection", new DelegatingHttpSolrClient(delegate)));
  }

  /**
   * Test {@link SolrIndexServiceImpl#deleteAllDocuments(String, SolrClient)} with
   * {@code collection}, {@code server}.
   * <ul>
   *   <li>Given {@link UpdateResponse} (default constructor).</li>
   *   <li>Then calls {@link SolrClient#commit(String)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SolrIndexServiceImpl#deleteAllDocuments(String, SolrClient)}
   */
  @Test
  public void testDeleteAllDocumentsWithCollectionServer_givenUpdateResponse_thenCallsCommit()
      throws IOException, SolrServerException, ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SolrIndexServiceImpl solrIndexServiceImpl = new SolrIndexServiceImpl();
    LBHttp2SolrClient server = mock(LBHttp2SolrClient.class);
    when(server.commit(Mockito.<String>any())).thenReturn(new UpdateResponse());
    when(server.deleteByQuery(Mockito.<String>any(), Mockito.<String>any())).thenReturn(new UpdateResponse());

    // Act
    solrIndexServiceImpl.deleteAllDocuments("Collection", server);

    // Assert
    verify(server).commit(eq("Collection"));
    verify(server).deleteByQuery(eq("Collection"), eq("*:*"));
  }

  /**
   * Test {@link SolrIndexServiceImpl#deleteAllDocuments(SolrClient)} with
   * {@code server}.
   * <p>
   * Method under test:
   * {@link SolrIndexServiceImpl#deleteAllDocuments(SolrClient)}
   */
  @Test
  public void testDeleteAllDocumentsWithServer() throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SolrIndexServiceImpl solrIndexServiceImpl = new SolrIndexServiceImpl();
    Http2SolrClient.Builder connectionTimeoutResult = (new Http2SolrClient.Builder()).connectionTimeout(1);
    Http2SolrClient.Builder connectionTimeoutResult2 = (new Http2SolrClient.Builder()).connectionTimeout(1);
    Http2SolrClient.Builder connectionTimeoutResult3 = (new Http2SolrClient.Builder()).connectionTimeout(1);
    Http2SolrClient.Builder connectionTimeoutResult4 = (new Http2SolrClient.Builder()).connectionTimeout(1);
    Http2SolrClient httpClient = (new Http2SolrClient.Builder()).build();
    Http2SolrClient httpClient2 = connectionTimeoutResult4.withHttpClient(httpClient)
        .idleTimeout(1)
        .maxConnectionsPerHost(3)
        .withSSLConfig(null)
        .useHttp1_1(true)
        .build();
    Http2SolrClient.Builder maxConnectionsPerHostResult = connectionTimeoutResult3.withHttpClient(httpClient2)
        .idleTimeout(1)
        .maxConnectionsPerHost(3);
    Http2SolrClient httpClient3 = maxConnectionsPerHostResult
        .withSSLConfig(new SSLConfig(true, true, "Key Store", "iloveyou", "Trust Store", "iloveyou"))
        .useHttp1_1(true)
        .build();
    Http2SolrClient.Builder maxConnectionsPerHostResult2 = connectionTimeoutResult2.withHttpClient(httpClient3)
        .idleTimeout(1)
        .maxConnectionsPerHost(3);
    Http2SolrClient httpClient4 = maxConnectionsPerHostResult2
        .withSSLConfig(new SSLConfig(true, true, "Key Store", "iloveyou", "Trust Store", "iloveyou"))
        .useHttp1_1(true)
        .build();
    Http2SolrClient.Builder maxConnectionsPerHostResult3 = connectionTimeoutResult.withHttpClient(httpClient4)
        .idleTimeout(1)
        .maxConnectionsPerHost(3);
    Http2SolrClient httpClient5 = maxConnectionsPerHostResult3
        .withSSLConfig(new SSLConfig(true, true, "Key Store", "iloveyou", "Trust Store", "iloveyou"))
        .useHttp1_1(true)
        .build();

    // Act and Assert
    assertThrows(ServiceException.class, () -> solrIndexServiceImpl
        .deleteAllDocuments(new LBHttp2SolrClient(httpClient5, "https://example.org/example")));
  }

  /**
   * Test {@link SolrIndexServiceImpl#deleteAllDocuments(SolrClient)} with
   * {@code server}.
   * <p>
   * Method under test:
   * {@link SolrIndexServiceImpl#deleteAllDocuments(SolrClient)}
   */
  @Test
  public void testDeleteAllDocumentsWithServer2() throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SolrIndexServiceImpl solrIndexServiceImpl = new SolrIndexServiceImpl();
    HttpSolrClient.Builder withConnectionTimeoutResult = (new HttpSolrClient.Builder())
        .withBaseSolrUrl("https://example.org/example")
        .allowCompression(true)
        .withConnectionTimeout(10);
    HttpSolrClient.Builder withHttpClientResult = withConnectionTimeoutResult.withHttpClient(new AutoRetryHttpClient());
    HttpSolrClient delegate = withHttpClientResult.withResponseParser(new BinaryResponseParser())
        .withSocketTimeout(10)
        .build();

    // Act and Assert
    assertThrows(ServiceException.class,
        () -> solrIndexServiceImpl.deleteAllDocuments(new DelegatingHttpSolrClient(delegate)));
  }

  /**
   * Test {@link SolrIndexServiceImpl#deleteAllDocuments(SolrClient)} with
   * {@code server}.
   * <ul>
   *   <li>Given {@link UpdateResponse} (default constructor).</li>
   *   <li>Then calls {@link SolrClient#commit(String)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SolrIndexServiceImpl#deleteAllDocuments(SolrClient)}
   */
  @Test
  public void testDeleteAllDocumentsWithServer_givenUpdateResponse_thenCallsCommit()
      throws IOException, SolrServerException, ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SolrIndexServiceImpl solrIndexServiceImpl = new SolrIndexServiceImpl();
    LBHttp2SolrClient server = mock(LBHttp2SolrClient.class);
    when(server.commit(Mockito.<String>any())).thenReturn(new UpdateResponse());
    when(server.deleteByQuery(Mockito.<String>any(), Mockito.<String>any())).thenReturn(new UpdateResponse());

    // Act
    solrIndexServiceImpl.deleteAllDocuments(server);

    // Assert
    verify(server).commit(isNull());
    verify(server).deleteByQuery((String) isNull(), eq("*:*"));
  }

  /**
   * Test {@link SolrIndexServiceImpl#useLegacyIndexer()}.
   * <p>
   * Method under test: {@link SolrIndexServiceImpl#useLegacyIndexer()}
   */
  @Test
  public void testUseLegacyIndexer() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new SolrIndexServiceImpl()).useLegacyIndexer());
  }

  /**
   * Test {@link SolrIndexServiceImpl#buildDocument(Indexable, List, List)}.
   * <ul>
   *   <li>Given {@link IndexFieldImpl} (default constructor).</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link IndexFieldImpl} (default
   * constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SolrIndexServiceImpl#buildDocument(Indexable, List, List)}
   */
  @Test
  public void testBuildDocument_givenIndexFieldImpl_whenArrayListAddIndexFieldImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SolrIndexServiceImpl solrIndexServiceImpl = new SolrIndexServiceImpl();
    Indexable indexable = mock(Indexable.class);

    ArrayList<IndexField> fields = new ArrayList<>();
    fields.add(new IndexFieldImpl());

    // Act and Assert
    assertThrows(IllegalStateException.class,
        () -> solrIndexServiceImpl.buildDocument(indexable, fields, new ArrayList<>()));
  }

  /**
   * Test {@link SolrIndexServiceImpl#buildDocument(Indexable, List, List)}.
   * <ul>
   *   <li>Given {@link LocaleImpl} (default constructor).</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link LocaleImpl} (default
   * constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SolrIndexServiceImpl#buildDocument(Indexable, List, List)}
   */
  @Test
  public void testBuildDocument_givenLocaleImpl_whenArrayListAddLocaleImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SolrIndexServiceImpl solrIndexServiceImpl = new SolrIndexServiceImpl();
    Indexable indexable = mock(Indexable.class);
    ArrayList<IndexField> fields = new ArrayList<>();

    ArrayList<Locale> locales = new ArrayList<>();
    locales.add(new LocaleImpl());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> solrIndexServiceImpl.buildDocument(indexable, fields, locales));
  }

  /**
   * Test {@link SolrIndexServiceImpl#buildDocument(Indexable, List, List)}.
   * <ul>
   *   <li>When {@link ProductBundleImpl} (default constructor).</li>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SolrIndexServiceImpl#buildDocument(Indexable, List, List)}
   */
  @Test
  public void testBuildDocument_whenProductBundleImpl_thenThrowIllegalStateException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SolrIndexServiceImpl solrIndexServiceImpl = new SolrIndexServiceImpl();
    ProductBundleImpl indexable = new ProductBundleImpl();
    ArrayList<IndexField> fields = new ArrayList<>();

    // Act and Assert
    assertThrows(IllegalStateException.class,
        () -> solrIndexServiceImpl.buildDocument(indexable, fields, new ArrayList<>()));
  }

  /**
   * Test
   * {@link SolrIndexServiceImpl#attachIndexableDocumentFields(SolrInputDocument, Indexable, List, List)}.
   * <p>
   * Method under test:
   * {@link SolrIndexServiceImpl#attachIndexableDocumentFields(SolrInputDocument, Indexable, List, List)}
   */
  @Test
  public void testAttachIndexableDocumentFields() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SolrIndexServiceImpl solrIndexServiceImpl = new SolrIndexServiceImpl();
    ProductBundleImpl indexable = new ProductBundleImpl();
    IndexFieldImpl indexFieldImpl = mock(IndexFieldImpl.class);
    when(indexFieldImpl.getField()).thenThrow(new IllegalStateException("Could not get value for property["));
    when(indexFieldImpl.getFieldTypes()).thenThrow(new IllegalStateException("foo"));

    ArrayList<IndexField> fields = new ArrayList<>();
    fields.add(indexFieldImpl);

    // Act and Assert
    assertThrows(IllegalStateException.class,
        () -> solrIndexServiceImpl.attachIndexableDocumentFields(null, indexable, fields, new ArrayList<>()));
    verify(indexFieldImpl).getField();
    verify(indexFieldImpl).getFieldTypes();
  }

  /**
   * Test
   * {@link SolrIndexServiceImpl#attachIndexableDocumentFields(SolrInputDocument, Indexable, List, List)}.
   * <ul>
   *   <li>Then calls {@link FieldImpl#getQualifiedFieldName()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SolrIndexServiceImpl#attachIndexableDocumentFields(SolrInputDocument, Indexable, List, List)}
   */
  @Test
  public void testAttachIndexableDocumentFields_thenCallsGetQualifiedFieldName() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SolrIndexServiceImpl solrIndexServiceImpl = new SolrIndexServiceImpl();
    ProductBundleImpl indexable = new ProductBundleImpl();
    FieldImpl fieldImpl = mock(FieldImpl.class);
    when(fieldImpl.getQualifiedFieldName()).thenReturn("Qualified Field Name");
    IndexFieldImpl indexFieldImpl = mock(IndexFieldImpl.class);
    when(indexFieldImpl.getField()).thenReturn(fieldImpl);
    when(indexFieldImpl.getFieldTypes()).thenThrow(new IllegalStateException("foo"));

    ArrayList<IndexField> fields = new ArrayList<>();
    fields.add(indexFieldImpl);

    // Act and Assert
    assertThrows(IllegalStateException.class,
        () -> solrIndexServiceImpl.attachIndexableDocumentFields(null, indexable, fields, new ArrayList<>()));
    verify(fieldImpl).getQualifiedFieldName();
    verify(indexFieldImpl).getField();
    verify(indexFieldImpl).getFieldTypes();
  }

  /**
   * Test
   * {@link SolrIndexServiceImpl#attachBasicDocumentFields(Indexable, SolrInputDocument)}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SolrIndexServiceImpl#attachBasicDocumentFields(Indexable, SolrInputDocument)}
   */
  @Test
  public void testAttachBasicDocumentFields_thenThrowIllegalStateException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SolrIndexServiceImpl solrIndexServiceImpl = new SolrIndexServiceImpl();

    // Act and Assert
    assertThrows(IllegalStateException.class,
        () -> solrIndexServiceImpl.attachBasicDocumentFields(new ProductBundleImpl(), null));
  }

  /**
   * Test
   * {@link SolrIndexServiceImpl#convertToMappedProperty(String, String, String)}.
   * <ul>
   *   <li>When {@code \.}.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SolrIndexServiceImpl#convertToMappedProperty(String, String, String)}
   */
  @Test
  public void testConvertToMappedProperty_whenBackslashDot_thenReturnEmptyString() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("",
        (new SolrIndexServiceImpl()).convertToMappedProperty("\\.", "List Property Name", "Map Property Name"));
  }

  /**
   * Test
   * {@link SolrIndexServiceImpl#convertToMappedProperty(String, String, String)}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SolrIndexServiceImpl#convertToMappedProperty(String, String, String)}
   */
  @Test
  public void testConvertToMappedProperty_whenEmptyString_thenReturnEmptyString() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("",
        (new SolrIndexServiceImpl()).convertToMappedProperty("", "List Property Name", "Map Property Name"));
  }

  /**
   * Test
   * {@link SolrIndexServiceImpl#convertToMappedProperty(String, String, String)}.
   * <ul>
   *   <li>When {@code java.lang.Long}.</li>
   *   <li>Then return {@code java.lang.Long}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SolrIndexServiceImpl#convertToMappedProperty(String, String, String)}
   */
  @Test
  public void testConvertToMappedProperty_whenJavaLangLong_thenReturnJavaLangLong() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("java.lang.Long", (new SolrIndexServiceImpl()).convertToMappedProperty("java.lang.Long",
        "List Property Name", "Map Property Name"));
  }

  /**
   * Test
   * {@link SolrIndexServiceImpl#convertToMappedProperty(String, String, String)}.
   * <ul>
   *   <li>When {@code java}.</li>
   *   <li>Then return {@code Map Property Name(lang).value.Long}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SolrIndexServiceImpl#convertToMappedProperty(String, String, String)}
   */
  @Test
  public void testConvertToMappedProperty_whenJava_thenReturnMapPropertyNameLangValueLong() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("Map Property Name(lang).value.Long",
        (new SolrIndexServiceImpl()).convertToMappedProperty("java.lang.Long", "java", "Map Property Name"));
  }

  /**
   * Test
   * {@link SolrIndexServiceImpl#convertToMappedProperty(String, String, String)}.
   * <ul>
   *   <li>When {@code Property Name}.</li>
   *   <li>Then return {@code Property Name}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SolrIndexServiceImpl#convertToMappedProperty(String, String, String)}
   */
  @Test
  public void testConvertToMappedProperty_whenPropertyName_thenReturnPropertyName() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("Property Name", (new SolrIndexServiceImpl()).convertToMappedProperty("Property Name",
        "List Property Name", "Map Property Name"));
  }

  /**
   * Test
   * {@link SolrIndexServiceImpl#commit(String, SolrClient, boolean, boolean, boolean)}
   * with {@code collection}, {@code server}, {@code softCommit},
   * {@code waitSearcher}, {@code waitFlush}.
   * <p>
   * Method under test:
   * {@link SolrIndexServiceImpl#commit(String, SolrClient, boolean, boolean, boolean)}
   */
  @Test
  public void testCommitWithCollectionServerSoftCommitWaitSearcherWaitFlush() throws IOException, ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SolrIndexServiceImpl solrIndexServiceImpl = new SolrIndexServiceImpl();
    Http2SolrClient.Builder connectionTimeoutResult = (new Http2SolrClient.Builder()).connectionTimeout(1);
    Http2SolrClient.Builder connectionTimeoutResult2 = (new Http2SolrClient.Builder()).connectionTimeout(1);
    Http2SolrClient.Builder connectionTimeoutResult3 = (new Http2SolrClient.Builder()).connectionTimeout(1);
    Http2SolrClient.Builder connectionTimeoutResult4 = (new Http2SolrClient.Builder()).connectionTimeout(1);
    Http2SolrClient httpClient = (new Http2SolrClient.Builder()).build();
    Http2SolrClient httpClient2 = connectionTimeoutResult4.withHttpClient(httpClient)
        .idleTimeout(1)
        .maxConnectionsPerHost(3)
        .withSSLConfig(null)
        .useHttp1_1(true)
        .build();
    Http2SolrClient.Builder maxConnectionsPerHostResult = connectionTimeoutResult3.withHttpClient(httpClient2)
        .idleTimeout(1)
        .maxConnectionsPerHost(3);
    Http2SolrClient httpClient3 = maxConnectionsPerHostResult
        .withSSLConfig(new SSLConfig(true, true, "Key Store", "iloveyou", "Trust Store", "iloveyou"))
        .useHttp1_1(true)
        .build();
    Http2SolrClient.Builder maxConnectionsPerHostResult2 = connectionTimeoutResult2.withHttpClient(httpClient3)
        .idleTimeout(1)
        .maxConnectionsPerHost(3);
    Http2SolrClient httpClient4 = maxConnectionsPerHostResult2
        .withSSLConfig(new SSLConfig(true, true, "Key Store", "iloveyou", "Trust Store", "iloveyou"))
        .useHttp1_1(true)
        .build();
    Http2SolrClient.Builder maxConnectionsPerHostResult3 = connectionTimeoutResult.withHttpClient(httpClient4)
        .idleTimeout(1)
        .maxConnectionsPerHost(3);
    Http2SolrClient httpClient5 = maxConnectionsPerHostResult3
        .withSSLConfig(new SSLConfig(true, true, "Key Store", "iloveyou", "Trust Store", "iloveyou"))
        .useHttp1_1(true)
        .build();

    // Act and Assert
    assertThrows(ServiceException.class, () -> solrIndexServiceImpl.commit("Collection",
        new LBHttp2SolrClient(httpClient5, "https://example.org/example"), true, true, true));
  }

  /**
   * Test
   * {@link SolrIndexServiceImpl#commit(String, SolrClient, boolean, boolean, boolean)}
   * with {@code collection}, {@code server}, {@code softCommit},
   * {@code waitSearcher}, {@code waitFlush}.
   * <p>
   * Method under test:
   * {@link SolrIndexServiceImpl#commit(String, SolrClient, boolean, boolean, boolean)}
   */
  @Test
  public void testCommitWithCollectionServerSoftCommitWaitSearcherWaitFlush2()
      throws IOException, SolrServerException, ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SolrIndexServiceImpl solrIndexServiceImpl = new SolrIndexServiceImpl();
    LBHttp2SolrClient server = mock(LBHttp2SolrClient.class);
    when(server.commit(Mockito.<String>any(), anyBoolean(), anyBoolean(), anyBoolean()))
        .thenReturn(new UpdateResponse());

    // Act
    solrIndexServiceImpl.commit("Collection", server, true, true, true);

    // Assert
    verify(server).commit(eq("Collection"), eq(true), eq(true), eq(true));
  }

  /**
   * Test
   * {@link SolrIndexServiceImpl#commit(String, SolrClient, boolean, boolean, boolean)}
   * with {@code collection}, {@code server}, {@code softCommit},
   * {@code waitSearcher}, {@code waitFlush}.
   * <p>
   * Method under test:
   * {@link SolrIndexServiceImpl#commit(String, SolrClient, boolean, boolean, boolean)}
   */
  @Test
  public void testCommitWithCollectionServerSoftCommitWaitSearcherWaitFlush3()
      throws IOException, SolrServerException, ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SolrIndexServiceImpl solrIndexServiceImpl = new SolrIndexServiceImpl();
    LBHttp2SolrClient server = mock(LBHttp2SolrClient.class);
    when(server.commit(Mockito.<String>any(), anyBoolean(), anyBoolean(), anyBoolean()))
        .thenThrow(new SolrServerException("An error occurred"));

    // Act and Assert
    assertThrows(ServiceException.class, () -> solrIndexServiceImpl.commit("Collection", server, true, true, true));
    verify(server).commit(eq("Collection"), eq(true), eq(true), eq(true));
  }

  /**
   * Test
   * {@link SolrIndexServiceImpl#commit(SolrClient, boolean, boolean, boolean)}
   * with {@code server}, {@code softCommit}, {@code waitSearcher},
   * {@code waitFlush}.
   * <p>
   * Method under test:
   * {@link SolrIndexServiceImpl#commit(SolrClient, boolean, boolean, boolean)}
   */
  @Test
  public void testCommitWithServerSoftCommitWaitSearcherWaitFlush() throws IOException, ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SolrIndexServiceImpl solrIndexServiceImpl = new SolrIndexServiceImpl();
    Http2SolrClient.Builder connectionTimeoutResult = (new Http2SolrClient.Builder()).connectionTimeout(1);
    Http2SolrClient.Builder connectionTimeoutResult2 = (new Http2SolrClient.Builder()).connectionTimeout(1);
    Http2SolrClient.Builder connectionTimeoutResult3 = (new Http2SolrClient.Builder()).connectionTimeout(1);
    Http2SolrClient.Builder connectionTimeoutResult4 = (new Http2SolrClient.Builder()).connectionTimeout(1);
    Http2SolrClient httpClient = (new Http2SolrClient.Builder()).build();
    Http2SolrClient httpClient2 = connectionTimeoutResult4.withHttpClient(httpClient)
        .idleTimeout(1)
        .maxConnectionsPerHost(3)
        .withSSLConfig(null)
        .useHttp1_1(true)
        .build();
    Http2SolrClient.Builder maxConnectionsPerHostResult = connectionTimeoutResult3.withHttpClient(httpClient2)
        .idleTimeout(1)
        .maxConnectionsPerHost(3);
    Http2SolrClient httpClient3 = maxConnectionsPerHostResult
        .withSSLConfig(new SSLConfig(true, true, "Key Store", "iloveyou", "Trust Store", "iloveyou"))
        .useHttp1_1(true)
        .build();
    Http2SolrClient.Builder maxConnectionsPerHostResult2 = connectionTimeoutResult2.withHttpClient(httpClient3)
        .idleTimeout(1)
        .maxConnectionsPerHost(3);
    Http2SolrClient httpClient4 = maxConnectionsPerHostResult2
        .withSSLConfig(new SSLConfig(true, true, "Key Store", "iloveyou", "Trust Store", "iloveyou"))
        .useHttp1_1(true)
        .build();
    Http2SolrClient.Builder maxConnectionsPerHostResult3 = connectionTimeoutResult.withHttpClient(httpClient4)
        .idleTimeout(1)
        .maxConnectionsPerHost(3);
    Http2SolrClient httpClient5 = maxConnectionsPerHostResult3
        .withSSLConfig(new SSLConfig(true, true, "Key Store", "iloveyou", "Trust Store", "iloveyou"))
        .useHttp1_1(true)
        .build();

    // Act and Assert
    assertThrows(ServiceException.class, () -> solrIndexServiceImpl
        .commit(new LBHttp2SolrClient(httpClient5, "https://example.org/example"), true, true, true));
  }

  /**
   * Test
   * {@link SolrIndexServiceImpl#commit(SolrClient, boolean, boolean, boolean)}
   * with {@code server}, {@code softCommit}, {@code waitSearcher},
   * {@code waitFlush}.
   * <p>
   * Method under test:
   * {@link SolrIndexServiceImpl#commit(SolrClient, boolean, boolean, boolean)}
   */
  @Test
  public void testCommitWithServerSoftCommitWaitSearcherWaitFlush2()
      throws IOException, SolrServerException, ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SolrIndexServiceImpl solrIndexServiceImpl = new SolrIndexServiceImpl();
    LBHttp2SolrClient server = mock(LBHttp2SolrClient.class);
    when(server.commit(Mockito.<String>any(), anyBoolean(), anyBoolean(), anyBoolean()))
        .thenThrow(new SolrServerException("An error occurred"));

    // Act and Assert
    assertThrows(ServiceException.class, () -> solrIndexServiceImpl.commit(server, true, true, true));
    verify(server).commit(isNull(), eq(true), eq(true), eq(true));
  }

  /**
   * Test
   * {@link SolrIndexServiceImpl#commit(SolrClient, boolean, boolean, boolean)}
   * with {@code server}, {@code softCommit}, {@code waitSearcher},
   * {@code waitFlush}.
   * <ul>
   *   <li>Given {@link UpdateResponse} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SolrIndexServiceImpl#commit(SolrClient, boolean, boolean, boolean)}
   */
  @Test
  public void testCommitWithServerSoftCommitWaitSearcherWaitFlush_givenUpdateResponse()
      throws IOException, SolrServerException, ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SolrIndexServiceImpl solrIndexServiceImpl = new SolrIndexServiceImpl();
    LBHttp2SolrClient server = mock(LBHttp2SolrClient.class);
    when(server.commit(Mockito.<String>any(), anyBoolean(), anyBoolean(), anyBoolean()))
        .thenReturn(new UpdateResponse());

    // Act
    solrIndexServiceImpl.commit(server, true, true, true);

    // Assert
    verify(server).commit(isNull(), eq(true), eq(true), eq(true));
  }

  /**
   * Test
   * {@link SolrIndexServiceImpl#convertDisplayOrderToLong(CatalogStructure, String)}.
   * <p>
   * Method under test:
   * {@link SolrIndexServiceImpl#convertDisplayOrderToLong(CatalogStructure, String)}
   */
  @Test
  public void testConvertDisplayOrderToLong() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SolrIndexServiceImpl solrIndexServiceImpl = new SolrIndexServiceImpl();

    CatalogStructure cache = new CatalogStructure();
    cache.setDisplayOrdersByCategoryProduct(new HashMap<>());
    cache.setParentCategoriesByCategory(new HashMap<>());
    cache.setParentCategoriesByProduct(new HashMap<>());

    // Act and Assert
    assertNull(solrIndexServiceImpl.convertDisplayOrderToLong(cache, "Display Order Key"));
  }

  /**
   * Test
   * {@link SolrIndexServiceImpl#convertDisplayOrderToLong(CatalogStructure, String)}.
   * <ul>
   *   <li>Then calls
   * {@link CatalogStructure#getDisplayOrdersByCategoryProduct()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SolrIndexServiceImpl#convertDisplayOrderToLong(CatalogStructure, String)}
   */
  @Test
  public void testConvertDisplayOrderToLong_thenCallsGetDisplayOrdersByCategoryProduct() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SolrIndexServiceImpl solrIndexServiceImpl = new SolrIndexServiceImpl();
    CatalogStructure cache = mock(CatalogStructure.class);
    when(cache.getDisplayOrdersByCategoryProduct()).thenReturn(new HashMap<>());
    doNothing().when(cache).setDisplayOrdersByCategoryProduct(Mockito.<Map<String, BigDecimal>>any());
    doNothing().when(cache).setParentCategoriesByCategory(Mockito.<Map<Long, Set<Long>>>any());
    doNothing().when(cache).setParentCategoriesByProduct(Mockito.<Map<Long, Set<Long>>>any());
    cache.setDisplayOrdersByCategoryProduct(new HashMap<>());
    cache.setParentCategoriesByCategory(new HashMap<>());
    cache.setParentCategoriesByProduct(new HashMap<>());

    // Act
    Long actualConvertDisplayOrderToLongResult = solrIndexServiceImpl.convertDisplayOrderToLong(cache,
        "Display Order Key");

    // Assert
    verify(cache).getDisplayOrdersByCategoryProduct();
    verify(cache).setDisplayOrdersByCategoryProduct(isA(Map.class));
    verify(cache).setParentCategoriesByCategory(isA(Map.class));
    verify(cache).setParentCategoriesByProduct(isA(Map.class));
    assertNull(actualConvertDisplayOrderToLongResult);
  }
}
