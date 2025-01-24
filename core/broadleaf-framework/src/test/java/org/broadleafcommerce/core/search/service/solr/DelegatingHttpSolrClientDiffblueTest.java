package org.broadleafcommerce.core.search.service.solr;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.apache.http.impl.client.AutoRetryHttpClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrRequest;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.StreamingResponseCallback;
import org.apache.solr.client.solrj.impl.BinaryResponseParser;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.impl.HttpSolrClient.Builder;
import org.apache.solr.client.solrj.request.CollectionAdminRequest;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.client.solrj.response.UpdateResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;
import org.apache.solr.common.params.SolrParams;
import org.apache.solr.common.util.NamedList;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;

public class DelegatingHttpSolrClientDiffblueTest {
  @MockBean
  private DelegatingHttpSolrClient delegatingHttpSolrClient;

  /**
   * Test
   * {@link DelegatingHttpSolrClient#DelegatingHttpSolrClient(HttpSolrClient, String)}.
   * <p>
   * Method under test:
   * {@link DelegatingHttpSolrClient#DelegatingHttpSolrClient(HttpSolrClient, String)}
   */
  @Test
  public void testNewDelegatingHttpSolrClient() {
    // Arrange
    HttpSolrClient.Builder withConnectionTimeoutResult = (new HttpSolrClient.Builder())
        .withBaseSolrUrl("https://example.org/example")
        .allowCompression(true)
        .withConnectionTimeout(10);
    HttpSolrClient.Builder withHttpClientResult = withConnectionTimeoutResult.withHttpClient(new AutoRetryHttpClient());
    HttpSolrClient delegate = withHttpClientResult.withResponseParser(new BinaryResponseParser())
        .withSocketTimeout(10)
        .build();

    // Act
    DelegatingHttpSolrClient actualDelegatingHttpSolrClient = new DelegatingHttpSolrClient(delegate,
        "https://example.org/example");

    // Assert
    assertEquals("/https://example.org/example", actualDelegatingHttpSolrClient.defaultCollectionPath);
    assertEquals("https://example.org/example", actualDelegatingHttpSolrClient.getDefaultCollection());
    assertSame(delegate, actualDelegatingHttpSolrClient.getDelegate());
  }

  /**
   * Test
   * {@link DelegatingHttpSolrClient#DelegatingHttpSolrClient(HttpSolrClient)}.
   * <ul>
   *   <li>Then return DefaultCollection is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DelegatingHttpSolrClient#DelegatingHttpSolrClient(HttpSolrClient)}
   */
  @Test
  public void testNewDelegatingHttpSolrClient_thenReturnDefaultCollectionIsNull()
      throws IOException, SolrServerException {
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

  /**
   * Test
   * {@link DelegatingHttpSolrClient#DelegatingHttpSolrClient(HttpSolrClient, String)}.
   * <ul>
   *   <li>Then return DefaultCollection is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DelegatingHttpSolrClient#DelegatingHttpSolrClient(HttpSolrClient, String)}
   */
  @Test
  public void testNewDelegatingHttpSolrClient_thenReturnDefaultCollectionIsNull2() {
    // Arrange
    HttpSolrClient.Builder withConnectionTimeoutResult = (new HttpSolrClient.Builder())
        .withBaseSolrUrl("https://example.org/example")
        .allowCompression(true)
        .withConnectionTimeout(10);
    HttpSolrClient.Builder withHttpClientResult = withConnectionTimeoutResult.withHttpClient(new AutoRetryHttpClient());
    HttpSolrClient delegate = withHttpClientResult.withResponseParser(new BinaryResponseParser())
        .withSocketTimeout(10)
        .build();

    // Act
    DelegatingHttpSolrClient actualDelegatingHttpSolrClient = new DelegatingHttpSolrClient(delegate, "");

    // Assert
    assertNull(actualDelegatingHttpSolrClient.getDefaultCollection());
    assertNull(actualDelegatingHttpSolrClient.defaultCollectionPath);
    assertSame(delegate, actualDelegatingHttpSolrClient.getDelegate());
  }

  /**
   * Test
   * {@link DelegatingHttpSolrClient#DelegatingHttpSolrClient(HttpSolrClient, String)}.
   * <ul>
   *   <li>When {@link HttpSolrClient}.</li>
   *   <li>Then return Binder is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DelegatingHttpSolrClient#DelegatingHttpSolrClient(HttpSolrClient, String)}
   */
  @Test
  public void testNewDelegatingHttpSolrClient_whenHttpSolrClient_thenReturnBinderIsNull()
      throws IOException, SolrServerException {
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
   * Test {@link DelegatingHttpSolrClient#request(SolrRequest, String)} with
   * {@code request}, {@code collection}.
   * <p>
   * Method under test:
   * {@link DelegatingHttpSolrClient#request(SolrRequest, String)}
   */
  @Test
  public void testRequestWithRequestCollection() throws IOException, SolrServerException {
    // Arrange
    NamedList<Object> namedList = new NamedList<>(1);
    when(delegatingHttpSolrClient.request(Mockito.<SolrRequest<Object>>any(), Mockito.<String>any()))
        .thenReturn(namedList);

    // Act
    NamedList<Object> actualRequestResult = delegatingHttpSolrClient.request(CollectionAdminRequest.getClusterStatus(),
        "https://example.org/example");

    // Assert
    verify(delegatingHttpSolrClient).request(isA(SolrRequest.class), eq("https://example.org/example"));
    assertSame(namedList, actualRequestResult);
  }

  /**
   * Test {@link DelegatingHttpSolrClient#add(String, SolrInputDocument)} with
   * {@code collection}, {@code doc}.
   * <p>
   * Method under test:
   * {@link DelegatingHttpSolrClient#add(String, SolrInputDocument)}
   */
  @Test
  public void testAddWithCollectionDoc() throws IOException, SolrServerException {
    // Arrange
    UpdateResponse updateResponse = new UpdateResponse();
    when(delegatingHttpSolrClient.add(Mockito.<String>any(), Mockito.<SolrInputDocument>any()))
        .thenReturn(updateResponse);

    // Act
    UpdateResponse actualAddResult = delegatingHttpSolrClient.add("https://example.org/example",
        (SolrInputDocument) null);

    // Assert
    verify(delegatingHttpSolrClient).add(eq("https://example.org/example"), (SolrInputDocument) isNull());
    assertSame(updateResponse, actualAddResult);
  }

  /**
   * Test {@link DelegatingHttpSolrClient#add(String, SolrInputDocument, int)}
   * with {@code collection}, {@code doc}, {@code commitWithinMs}.
   * <p>
   * Method under test:
   * {@link DelegatingHttpSolrClient#add(String, SolrInputDocument, int)}
   */
  @Test
  public void testAddWithCollectionDocCommitWithinMs() throws IOException, SolrServerException {
    // Arrange
    UpdateResponse updateResponse = new UpdateResponse();
    when(delegatingHttpSolrClient.add(Mockito.<String>any(), Mockito.<SolrInputDocument>any(), anyInt()))
        .thenReturn(updateResponse);

    // Act
    UpdateResponse actualAddResult = delegatingHttpSolrClient.add("https://example.org/example",
        (SolrInputDocument) null, 2);

    // Assert
    verify(delegatingHttpSolrClient).add(eq("https://example.org/example"), (SolrInputDocument) isNull(), eq(2));
    assertSame(updateResponse, actualAddResult);
  }

  /**
   * Test {@link DelegatingHttpSolrClient#add(String, Iterator)} with
   * {@code collection}, {@code docIterator}.
   * <p>
   * Method under test: {@link DelegatingHttpSolrClient#add(String, Iterator)}
   */
  @Test
  public void testAddWithCollectionDocIterator() throws IOException, SolrServerException {
    // Arrange
    UpdateResponse updateResponse = new UpdateResponse();
    when(delegatingHttpSolrClient.add(Mockito.<String>any(), Mockito.<Iterator<SolrInputDocument>>any()))
        .thenReturn(updateResponse);

    ArrayList<SolrInputDocument> solrInputDocumentList = new ArrayList<>();

    // Act
    UpdateResponse actualAddResult = delegatingHttpSolrClient.add("https://example.org/example",
        solrInputDocumentList.iterator());

    // Assert
    verify(delegatingHttpSolrClient).add(eq("https://example.org/example"), isA(Iterator.class));
    assertSame(updateResponse, actualAddResult);
  }

  /**
   * Test {@link DelegatingHttpSolrClient#add(String, Collection, int)} with
   * {@code collection}, {@code docs}, {@code commitWithinMs}.
   * <ul>
   *   <li>Given {@link SolrInputDocument}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DelegatingHttpSolrClient#add(String, Collection, int)}
   */
  @Test
  public void testAddWithCollectionDocsCommitWithinMs_givenSolrInputDocument() throws IOException, SolrServerException {
    // Arrange
    UpdateResponse updateResponse = new UpdateResponse();
    when(delegatingHttpSolrClient.add(Mockito.<String>any(), Mockito.<Collection<SolrInputDocument>>any(), anyInt()))
        .thenReturn(updateResponse);

    ArrayList<SolrInputDocument> docs = new ArrayList<>();
    docs.add(mock(SolrInputDocument.class));

    // Act
    UpdateResponse actualAddResult = delegatingHttpSolrClient.add("https://example.org/example", docs, 2);

    // Assert
    verify(delegatingHttpSolrClient).add(eq("https://example.org/example"), isA(Collection.class), eq(2));
    assertSame(updateResponse, actualAddResult);
  }

  /**
   * Test {@link DelegatingHttpSolrClient#add(String, Collection, int)} with
   * {@code collection}, {@code docs}, {@code commitWithinMs}.
   * <ul>
   *   <li>Given {@link SolrInputDocument}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DelegatingHttpSolrClient#add(String, Collection, int)}
   */
  @Test
  public void testAddWithCollectionDocsCommitWithinMs_givenSolrInputDocument2()
      throws IOException, SolrServerException {
    // Arrange
    UpdateResponse updateResponse = new UpdateResponse();
    when(delegatingHttpSolrClient.add(Mockito.<String>any(), Mockito.<Collection<SolrInputDocument>>any(), anyInt()))
        .thenReturn(updateResponse);

    ArrayList<SolrInputDocument> docs = new ArrayList<>();
    docs.add(mock(SolrInputDocument.class));
    docs.add(mock(SolrInputDocument.class));

    // Act
    UpdateResponse actualAddResult = delegatingHttpSolrClient.add("https://example.org/example", docs, 2);

    // Assert
    verify(delegatingHttpSolrClient).add(eq("https://example.org/example"), isA(Collection.class), eq(2));
    assertSame(updateResponse, actualAddResult);
  }

  /**
   * Test {@link DelegatingHttpSolrClient#add(String, Collection, int)} with
   * {@code collection}, {@code docs}, {@code commitWithinMs}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DelegatingHttpSolrClient#add(String, Collection, int)}
   */
  @Test
  public void testAddWithCollectionDocsCommitWithinMs_whenArrayList() throws IOException, SolrServerException {
    // Arrange
    UpdateResponse updateResponse = new UpdateResponse();
    when(delegatingHttpSolrClient.add(Mockito.<String>any(), Mockito.<Collection<SolrInputDocument>>any(), anyInt()))
        .thenReturn(updateResponse);

    // Act
    UpdateResponse actualAddResult = delegatingHttpSolrClient.add("https://example.org/example", new ArrayList<>(), 2);

    // Assert
    verify(delegatingHttpSolrClient).add(eq("https://example.org/example"), isA(Collection.class), eq(2));
    assertSame(updateResponse, actualAddResult);
  }

  /**
   * Test {@link DelegatingHttpSolrClient#add(String, Collection)} with
   * {@code collection}, {@code docs}.
   * <ul>
   *   <li>Given {@link SolrInputDocument}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DelegatingHttpSolrClient#add(String, Collection)}
   */
  @Test
  public void testAddWithCollectionDocs_givenSolrInputDocument() throws IOException, SolrServerException {
    // Arrange
    UpdateResponse updateResponse = new UpdateResponse();
    when(delegatingHttpSolrClient.add(Mockito.<String>any(), Mockito.<Collection<SolrInputDocument>>any()))
        .thenReturn(updateResponse);

    ArrayList<SolrInputDocument> docs = new ArrayList<>();
    docs.add(mock(SolrInputDocument.class));

    // Act
    UpdateResponse actualAddResult = delegatingHttpSolrClient.add("https://example.org/example", docs);

    // Assert
    verify(delegatingHttpSolrClient).add(eq("https://example.org/example"), isA(Collection.class));
    assertSame(updateResponse, actualAddResult);
  }

  /**
   * Test {@link DelegatingHttpSolrClient#add(String, Collection)} with
   * {@code collection}, {@code docs}.
   * <ul>
   *   <li>Given {@link SolrInputDocument}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DelegatingHttpSolrClient#add(String, Collection)}
   */
  @Test
  public void testAddWithCollectionDocs_givenSolrInputDocument2() throws IOException, SolrServerException {
    // Arrange
    UpdateResponse updateResponse = new UpdateResponse();
    when(delegatingHttpSolrClient.add(Mockito.<String>any(), Mockito.<Collection<SolrInputDocument>>any()))
        .thenReturn(updateResponse);

    ArrayList<SolrInputDocument> docs = new ArrayList<>();
    docs.add(mock(SolrInputDocument.class));
    docs.add(mock(SolrInputDocument.class));

    // Act
    UpdateResponse actualAddResult = delegatingHttpSolrClient.add("https://example.org/example", docs);

    // Assert
    verify(delegatingHttpSolrClient).add(eq("https://example.org/example"), isA(Collection.class));
    assertSame(updateResponse, actualAddResult);
  }

  /**
   * Test {@link DelegatingHttpSolrClient#add(String, Collection)} with
   * {@code collection}, {@code docs}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DelegatingHttpSolrClient#add(String, Collection)}
   */
  @Test
  public void testAddWithCollectionDocs_whenArrayList() throws IOException, SolrServerException {
    // Arrange
    UpdateResponse updateResponse = new UpdateResponse();
    when(delegatingHttpSolrClient.add(Mockito.<String>any(), Mockito.<Collection<SolrInputDocument>>any()))
        .thenReturn(updateResponse);

    // Act
    UpdateResponse actualAddResult = delegatingHttpSolrClient.add("https://example.org/example", new ArrayList<>());

    // Assert
    verify(delegatingHttpSolrClient).add(eq("https://example.org/example"), isA(Collection.class));
    assertSame(updateResponse, actualAddResult);
  }

  /**
   * Test {@link DelegatingHttpSolrClient#add(SolrInputDocument)} with
   * {@code doc}.
   * <p>
   * Method under test: {@link DelegatingHttpSolrClient#add(SolrInputDocument)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testAddWithDoc() throws IOException, SolrServerException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Sandboxing policy violation.
    //   Diffblue Cover ran code in your project that tried
    //     to access the network.
    //   Diffblue Cover's default sandboxing policy disallows this in order to prevent
    //   your code from damaging your system environment.
    //   See https://diff.blue/R011 to resolve this issue.

    // Arrange
    HttpSolrClient.Builder withConnectionTimeoutResult = (new HttpSolrClient.Builder())
        .withBaseSolrUrl("https://example.org/example")
        .allowCompression(true)
        .withConnectionTimeout(10);
    HttpSolrClient.Builder withHttpClientResult = withConnectionTimeoutResult.withHttpClient(new AutoRetryHttpClient());
    HttpSolrClient delegate = withHttpClientResult.withResponseParser(new BinaryResponseParser())
        .withSocketTimeout(10)
        .build();

    // Act
    (new DelegatingHttpSolrClient(delegate)).add(mock(SolrInputDocument.class));
  }

  /**
   * Test {@link DelegatingHttpSolrClient#add(SolrInputDocument)} with
   * {@code doc}.
   * <p>
   * Method under test: {@link DelegatingHttpSolrClient#add(SolrInputDocument)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testAddWithDoc2() throws IOException, SolrServerException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.IllegalArgumentException: Illegal character in path at index 4: Base Solr Url/update?wt=javabin&version=2
    //       at java.base/java.net.URI.create(URI.java:883)
    //       at org.apache.http.client.methods.HttpPost.<init>(HttpPost.java:73)
    //       at org.apache.solr.client.solrj.impl.HttpSolrClient.createMethod(HttpSolrClient.java:416)
    //       at org.apache.solr.client.solrj.impl.HttpSolrClient.request(HttpSolrClient.java:257)
    //       at org.apache.solr.client.solrj.impl.HttpSolrClient.request(HttpSolrClient.java:248)
    //       at org.apache.solr.client.solrj.SolrRequest.process(SolrRequest.java:225)
    //       at org.apache.solr.client.solrj.SolrClient.add(SolrClient.java:177)
    //       at org.apache.solr.client.solrj.SolrClient.add(SolrClient.java:138)
    //       at org.apache.solr.client.solrj.SolrClient.add(SolrClient.java:156)
    //       at org.broadleafcommerce.core.search.service.solr.DelegatingHttpSolrClient.add(DelegatingHttpSolrClient.java:142)
    //   java.net.URISyntaxException: Illegal character in path at index 4: Base Solr Url/update?wt=javabin&version=2
    //       at java.base/java.net.URI$Parser.fail(URI.java:2913)
    //       at java.base/java.net.URI$Parser.checkChars(URI.java:3084)
    //       at java.base/java.net.URI$Parser.parseHierarchical(URI.java:3166)
    //       at java.base/java.net.URI$Parser.parse(URI.java:3125)
    //       at java.base/java.net.URI.<init>(URI.java:600)
    //       at java.base/java.net.URI.create(URI.java:881)
    //       at org.apache.http.client.methods.HttpPost.<init>(HttpPost.java:73)
    //       at org.apache.solr.client.solrj.impl.HttpSolrClient.createMethod(HttpSolrClient.java:416)
    //       at org.apache.solr.client.solrj.impl.HttpSolrClient.request(HttpSolrClient.java:257)
    //       at org.apache.solr.client.solrj.impl.HttpSolrClient.request(HttpSolrClient.java:248)
    //       at org.apache.solr.client.solrj.SolrRequest.process(SolrRequest.java:225)
    //       at org.apache.solr.client.solrj.SolrClient.add(SolrClient.java:177)
    //       at org.apache.solr.client.solrj.SolrClient.add(SolrClient.java:138)
    //       at org.apache.solr.client.solrj.SolrClient.add(SolrClient.java:156)
    //       at org.broadleafcommerce.core.search.service.solr.DelegatingHttpSolrClient.add(DelegatingHttpSolrClient.java:142)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange
    HttpSolrClient.Builder withConnectionTimeoutResult = (new HttpSolrClient.Builder()).withBaseSolrUrl("Base Solr Url")
        .allowCompression(true)
        .withConnectionTimeout(10);
    HttpSolrClient.Builder withHttpClientResult = withConnectionTimeoutResult.withHttpClient(new AutoRetryHttpClient());
    HttpSolrClient delegate = withHttpClientResult.withResponseParser(new BinaryResponseParser())
        .withSocketTimeout(10)
        .build();

    // Act
    (new DelegatingHttpSolrClient(delegate)).add(mock(SolrInputDocument.class));
  }

  /**
   * Test {@link DelegatingHttpSolrClient#add(SolrInputDocument, int)} with
   * {@code doc}, {@code commitWithinMs}.
   * <p>
   * Method under test:
   * {@link DelegatingHttpSolrClient#add(SolrInputDocument, int)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testAddWithDocCommitWithinMs() throws IOException, SolrServerException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Sandboxing policy violation.
    //   Diffblue Cover ran code in your project that tried
    //     to access the network.
    //   Diffblue Cover's default sandboxing policy disallows this in order to prevent
    //   your code from damaging your system environment.
    //   See https://diff.blue/R011 to resolve this issue.

    // Arrange
    HttpSolrClient.Builder withConnectionTimeoutResult = (new HttpSolrClient.Builder())
        .withBaseSolrUrl("https://example.org/example")
        .allowCompression(true)
        .withConnectionTimeout(10);
    HttpSolrClient.Builder withHttpClientResult = withConnectionTimeoutResult.withHttpClient(new AutoRetryHttpClient());
    HttpSolrClient delegate = withHttpClientResult.withResponseParser(new BinaryResponseParser())
        .withSocketTimeout(10)
        .build();

    // Act
    (new DelegatingHttpSolrClient(delegate)).add(mock(SolrInputDocument.class), 2);
  }

  /**
   * Test {@link DelegatingHttpSolrClient#add(SolrInputDocument, int)} with
   * {@code doc}, {@code commitWithinMs}.
   * <p>
   * Method under test:
   * {@link DelegatingHttpSolrClient#add(SolrInputDocument, int)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testAddWithDocCommitWithinMs2() throws IOException, SolrServerException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.IllegalArgumentException: Illegal character in path at index 4: Base Solr Url/update?wt=javabin&version=2
    //       at java.base/java.net.URI.create(URI.java:883)
    //       at org.apache.http.client.methods.HttpPost.<init>(HttpPost.java:73)
    //       at org.apache.solr.client.solrj.impl.HttpSolrClient.createMethod(HttpSolrClient.java:416)
    //       at org.apache.solr.client.solrj.impl.HttpSolrClient.request(HttpSolrClient.java:257)
    //       at org.apache.solr.client.solrj.impl.HttpSolrClient.request(HttpSolrClient.java:248)
    //       at org.apache.solr.client.solrj.SolrRequest.process(SolrRequest.java:225)
    //       at org.apache.solr.client.solrj.SolrClient.add(SolrClient.java:177)
    //       at org.apache.solr.client.solrj.SolrClient.add(SolrClient.java:194)
    //       at org.broadleafcommerce.core.search.service.solr.DelegatingHttpSolrClient.add(DelegatingHttpSolrClient.java:160)
    //   java.net.URISyntaxException: Illegal character in path at index 4: Base Solr Url/update?wt=javabin&version=2
    //       at java.base/java.net.URI$Parser.fail(URI.java:2913)
    //       at java.base/java.net.URI$Parser.checkChars(URI.java:3084)
    //       at java.base/java.net.URI$Parser.parseHierarchical(URI.java:3166)
    //       at java.base/java.net.URI$Parser.parse(URI.java:3125)
    //       at java.base/java.net.URI.<init>(URI.java:600)
    //       at java.base/java.net.URI.create(URI.java:881)
    //       at org.apache.http.client.methods.HttpPost.<init>(HttpPost.java:73)
    //       at org.apache.solr.client.solrj.impl.HttpSolrClient.createMethod(HttpSolrClient.java:416)
    //       at org.apache.solr.client.solrj.impl.HttpSolrClient.request(HttpSolrClient.java:257)
    //       at org.apache.solr.client.solrj.impl.HttpSolrClient.request(HttpSolrClient.java:248)
    //       at org.apache.solr.client.solrj.SolrRequest.process(SolrRequest.java:225)
    //       at org.apache.solr.client.solrj.SolrClient.add(SolrClient.java:177)
    //       at org.apache.solr.client.solrj.SolrClient.add(SolrClient.java:194)
    //       at org.broadleafcommerce.core.search.service.solr.DelegatingHttpSolrClient.add(DelegatingHttpSolrClient.java:160)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange
    HttpSolrClient.Builder withConnectionTimeoutResult = (new HttpSolrClient.Builder()).withBaseSolrUrl("Base Solr Url")
        .allowCompression(true)
        .withConnectionTimeout(10);
    HttpSolrClient.Builder withHttpClientResult = withConnectionTimeoutResult.withHttpClient(new AutoRetryHttpClient());
    HttpSolrClient delegate = withHttpClientResult.withResponseParser(new BinaryResponseParser())
        .withSocketTimeout(10)
        .build();

    // Act
    (new DelegatingHttpSolrClient(delegate)).add(mock(SolrInputDocument.class), 2);
  }

  /**
   * Test {@link DelegatingHttpSolrClient#add(Iterator)} with {@code docIterator}.
   * <p>
   * Method under test: {@link DelegatingHttpSolrClient#add(Iterator)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testAddWithDocIterator() throws IOException, SolrServerException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Sandboxing policy violation.
    //   Diffblue Cover ran code in your project that tried
    //     to access the network.
    //   Diffblue Cover's default sandboxing policy disallows this in order to prevent
    //   your code from damaging your system environment.
    //   See https://diff.blue/R011 to resolve this issue.

    // Arrange
    HttpSolrClient.Builder withConnectionTimeoutResult = (new HttpSolrClient.Builder())
        .withBaseSolrUrl("https://example.org/example")
        .allowCompression(true)
        .withConnectionTimeout(10);
    HttpSolrClient.Builder withHttpClientResult = withConnectionTimeoutResult.withHttpClient(new AutoRetryHttpClient());
    HttpSolrClient delegate = withHttpClientResult.withResponseParser(new BinaryResponseParser())
        .withSocketTimeout(10)
        .build();
    DelegatingHttpSolrClient delegatingHttpSolrClient = new DelegatingHttpSolrClient(delegate);

    ArrayList<SolrInputDocument> solrInputDocumentList = new ArrayList<>();

    // Act
    delegatingHttpSolrClient.add(solrInputDocumentList.iterator());
  }

  /**
   * Test {@link DelegatingHttpSolrClient#add(Iterator)} with {@code docIterator}.
   * <p>
   * Method under test: {@link DelegatingHttpSolrClient#add(Iterator)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testAddWithDocIterator2() throws IOException, SolrServerException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.IllegalArgumentException: Illegal character in path at index 4: Base Solr Url/update?wt=javabin&version=2
    //       at java.base/java.net.URI.create(URI.java:883)
    //       at org.apache.http.client.methods.HttpPost.<init>(HttpPost.java:73)
    //       at org.apache.solr.client.solrj.impl.HttpSolrClient.createMethod(HttpSolrClient.java:416)
    //       at org.apache.solr.client.solrj.impl.HttpSolrClient.request(HttpSolrClient.java:257)
    //       at org.apache.solr.client.solrj.impl.HttpSolrClient.request(HttpSolrClient.java:248)
    //       at org.apache.solr.client.solrj.SolrRequest.process(SolrRequest.java:225)
    //       at org.apache.solr.client.solrj.SolrClient.add(SolrClient.java:213)
    //       at org.apache.solr.client.solrj.SolrClient.add(SolrClient.java:228)
    //       at org.broadleafcommerce.core.search.service.solr.DelegatingHttpSolrClient.add(DelegatingHttpSolrClient.java:178)
    //   java.net.URISyntaxException: Illegal character in path at index 4: Base Solr Url/update?wt=javabin&version=2
    //       at java.base/java.net.URI$Parser.fail(URI.java:2913)
    //       at java.base/java.net.URI$Parser.checkChars(URI.java:3084)
    //       at java.base/java.net.URI$Parser.parseHierarchical(URI.java:3166)
    //       at java.base/java.net.URI$Parser.parse(URI.java:3125)
    //       at java.base/java.net.URI.<init>(URI.java:600)
    //       at java.base/java.net.URI.create(URI.java:881)
    //       at org.apache.http.client.methods.HttpPost.<init>(HttpPost.java:73)
    //       at org.apache.solr.client.solrj.impl.HttpSolrClient.createMethod(HttpSolrClient.java:416)
    //       at org.apache.solr.client.solrj.impl.HttpSolrClient.request(HttpSolrClient.java:257)
    //       at org.apache.solr.client.solrj.impl.HttpSolrClient.request(HttpSolrClient.java:248)
    //       at org.apache.solr.client.solrj.SolrRequest.process(SolrRequest.java:225)
    //       at org.apache.solr.client.solrj.SolrClient.add(SolrClient.java:213)
    //       at org.apache.solr.client.solrj.SolrClient.add(SolrClient.java:228)
    //       at org.broadleafcommerce.core.search.service.solr.DelegatingHttpSolrClient.add(DelegatingHttpSolrClient.java:178)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange
    HttpSolrClient.Builder withConnectionTimeoutResult = (new HttpSolrClient.Builder()).withBaseSolrUrl("Base Solr Url")
        .allowCompression(true)
        .withConnectionTimeout(10);
    HttpSolrClient.Builder withHttpClientResult = withConnectionTimeoutResult.withHttpClient(new AutoRetryHttpClient());
    HttpSolrClient delegate = withHttpClientResult.withResponseParser(new BinaryResponseParser())
        .withSocketTimeout(10)
        .build();
    DelegatingHttpSolrClient delegatingHttpSolrClient = new DelegatingHttpSolrClient(delegate);

    ArrayList<SolrInputDocument> solrInputDocumentList = new ArrayList<>();

    // Act
    delegatingHttpSolrClient.add(solrInputDocumentList.iterator());
  }

  /**
   * Test {@link DelegatingHttpSolrClient#add(Collection)} with {@code docs}.
   * <p>
   * Method under test: {@link DelegatingHttpSolrClient#add(Collection)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testAddWithDocs() throws IOException, SolrServerException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Sandboxing policy violation.
    //   Diffblue Cover ran code in your project that tried
    //     to access the network.
    //   Diffblue Cover's default sandboxing policy disallows this in order to prevent
    //   your code from damaging your system environment.
    //   See https://diff.blue/R011 to resolve this issue.

    // Arrange
    HttpSolrClient.Builder withConnectionTimeoutResult = (new HttpSolrClient.Builder())
        .withBaseSolrUrl("https://example.org/example")
        .allowCompression(true)
        .withConnectionTimeout(10);
    HttpSolrClient.Builder withHttpClientResult = withConnectionTimeoutResult.withHttpClient(new AutoRetryHttpClient());
    HttpSolrClient delegate = withHttpClientResult.withResponseParser(new BinaryResponseParser())
        .withSocketTimeout(10)
        .build();
    DelegatingHttpSolrClient delegatingHttpSolrClient = new DelegatingHttpSolrClient(delegate);

    // Act
    delegatingHttpSolrClient.add(new ArrayList<>());
  }

  /**
   * Test {@link DelegatingHttpSolrClient#add(Collection)} with {@code docs}.
   * <p>
   * Method under test: {@link DelegatingHttpSolrClient#add(Collection)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testAddWithDocs2() throws IOException, SolrServerException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.IllegalArgumentException: Illegal character in path at index 4: Base Solr Url/update
    //       at java.base/java.net.URI.create(URI.java:883)
    //       at org.apache.http.client.methods.HttpPost.<init>(HttpPost.java:73)
    //       at org.apache.solr.client.solrj.impl.HttpSolrClient.fillContentStream(HttpSolrClient.java:484)
    //       at org.apache.solr.client.solrj.impl.HttpSolrClient.createMethod(HttpSolrClient.java:438)
    //       at org.apache.solr.client.solrj.impl.HttpSolrClient.request(HttpSolrClient.java:257)
    //       at org.apache.solr.client.solrj.impl.HttpSolrClient.request(HttpSolrClient.java:248)
    //       at org.apache.solr.client.solrj.SolrRequest.process(SolrRequest.java:225)
    //       at org.apache.solr.client.solrj.SolrClient.add(SolrClient.java:106)
    //       at org.apache.solr.client.solrj.SolrClient.add(SolrClient.java:71)
    //       at org.apache.solr.client.solrj.SolrClient.add(SolrClient.java:85)
    //       at org.broadleafcommerce.core.search.service.solr.DelegatingHttpSolrClient.add(DelegatingHttpSolrClient.java:106)
    //   java.net.URISyntaxException: Illegal character in path at index 4: Base Solr Url/update
    //       at java.base/java.net.URI$Parser.fail(URI.java:2913)
    //       at java.base/java.net.URI$Parser.checkChars(URI.java:3084)
    //       at java.base/java.net.URI$Parser.parseHierarchical(URI.java:3166)
    //       at java.base/java.net.URI$Parser.parse(URI.java:3125)
    //       at java.base/java.net.URI.<init>(URI.java:600)
    //       at java.base/java.net.URI.create(URI.java:881)
    //       at org.apache.http.client.methods.HttpPost.<init>(HttpPost.java:73)
    //       at org.apache.solr.client.solrj.impl.HttpSolrClient.fillContentStream(HttpSolrClient.java:484)
    //       at org.apache.solr.client.solrj.impl.HttpSolrClient.createMethod(HttpSolrClient.java:438)
    //       at org.apache.solr.client.solrj.impl.HttpSolrClient.request(HttpSolrClient.java:257)
    //       at org.apache.solr.client.solrj.impl.HttpSolrClient.request(HttpSolrClient.java:248)
    //       at org.apache.solr.client.solrj.SolrRequest.process(SolrRequest.java:225)
    //       at org.apache.solr.client.solrj.SolrClient.add(SolrClient.java:106)
    //       at org.apache.solr.client.solrj.SolrClient.add(SolrClient.java:71)
    //       at org.apache.solr.client.solrj.SolrClient.add(SolrClient.java:85)
    //       at org.broadleafcommerce.core.search.service.solr.DelegatingHttpSolrClient.add(DelegatingHttpSolrClient.java:106)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange
    HttpSolrClient.Builder withConnectionTimeoutResult = (new HttpSolrClient.Builder()).withBaseSolrUrl("Base Solr Url")
        .allowCompression(true)
        .withConnectionTimeout(10);
    HttpSolrClient.Builder withHttpClientResult = withConnectionTimeoutResult.withHttpClient(new AutoRetryHttpClient());
    HttpSolrClient delegate = withHttpClientResult.withResponseParser(new BinaryResponseParser())
        .withSocketTimeout(10)
        .build();
    DelegatingHttpSolrClient delegatingHttpSolrClient = new DelegatingHttpSolrClient(delegate);

    // Act
    delegatingHttpSolrClient.add(new ArrayList<>());
  }

  /**
   * Test {@link DelegatingHttpSolrClient#add(Collection, int)} with {@code docs},
   * {@code commitWithinMs}.
   * <p>
   * Method under test: {@link DelegatingHttpSolrClient#add(Collection, int)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testAddWithDocsCommitWithinMs() throws IOException, SolrServerException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Sandboxing policy violation.
    //   Diffblue Cover ran code in your project that tried
    //     to access the network.
    //   Diffblue Cover's default sandboxing policy disallows this in order to prevent
    //   your code from damaging your system environment.
    //   See https://diff.blue/R011 to resolve this issue.

    // Arrange
    HttpSolrClient.Builder withConnectionTimeoutResult = (new HttpSolrClient.Builder())
        .withBaseSolrUrl("https://example.org/example")
        .allowCompression(true)
        .withConnectionTimeout(10);
    HttpSolrClient.Builder withHttpClientResult = withConnectionTimeoutResult.withHttpClient(new AutoRetryHttpClient());
    HttpSolrClient delegate = withHttpClientResult.withResponseParser(new BinaryResponseParser())
        .withSocketTimeout(10)
        .build();
    DelegatingHttpSolrClient delegatingHttpSolrClient = new DelegatingHttpSolrClient(delegate);

    // Act
    delegatingHttpSolrClient.add(new ArrayList<>(), 2);
  }

  /**
   * Test {@link DelegatingHttpSolrClient#add(Collection, int)} with {@code docs},
   * {@code commitWithinMs}.
   * <p>
   * Method under test: {@link DelegatingHttpSolrClient#add(Collection, int)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testAddWithDocsCommitWithinMs2() throws IOException, SolrServerException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.IllegalArgumentException: Illegal character in path at index 4: Base Solr Url/update
    //       at java.base/java.net.URI.create(URI.java:883)
    //       at org.apache.http.client.methods.HttpPost.<init>(HttpPost.java:73)
    //       at org.apache.solr.client.solrj.impl.HttpSolrClient.fillContentStream(HttpSolrClient.java:484)
    //       at org.apache.solr.client.solrj.impl.HttpSolrClient.createMethod(HttpSolrClient.java:438)
    //       at org.apache.solr.client.solrj.impl.HttpSolrClient.request(HttpSolrClient.java:257)
    //       at org.apache.solr.client.solrj.impl.HttpSolrClient.request(HttpSolrClient.java:248)
    //       at org.apache.solr.client.solrj.SolrRequest.process(SolrRequest.java:225)
    //       at org.apache.solr.client.solrj.SolrClient.add(SolrClient.java:106)
    //       at org.apache.solr.client.solrj.SolrClient.add(SolrClient.java:123)
    //       at org.broadleafcommerce.core.search.service.solr.DelegatingHttpSolrClient.add(DelegatingHttpSolrClient.java:124)
    //   java.net.URISyntaxException: Illegal character in path at index 4: Base Solr Url/update
    //       at java.base/java.net.URI$Parser.fail(URI.java:2913)
    //       at java.base/java.net.URI$Parser.checkChars(URI.java:3084)
    //       at java.base/java.net.URI$Parser.parseHierarchical(URI.java:3166)
    //       at java.base/java.net.URI$Parser.parse(URI.java:3125)
    //       at java.base/java.net.URI.<init>(URI.java:600)
    //       at java.base/java.net.URI.create(URI.java:881)
    //       at org.apache.http.client.methods.HttpPost.<init>(HttpPost.java:73)
    //       at org.apache.solr.client.solrj.impl.HttpSolrClient.fillContentStream(HttpSolrClient.java:484)
    //       at org.apache.solr.client.solrj.impl.HttpSolrClient.createMethod(HttpSolrClient.java:438)
    //       at org.apache.solr.client.solrj.impl.HttpSolrClient.request(HttpSolrClient.java:257)
    //       at org.apache.solr.client.solrj.impl.HttpSolrClient.request(HttpSolrClient.java:248)
    //       at org.apache.solr.client.solrj.SolrRequest.process(SolrRequest.java:225)
    //       at org.apache.solr.client.solrj.SolrClient.add(SolrClient.java:106)
    //       at org.apache.solr.client.solrj.SolrClient.add(SolrClient.java:123)
    //       at org.broadleafcommerce.core.search.service.solr.DelegatingHttpSolrClient.add(DelegatingHttpSolrClient.java:124)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange
    HttpSolrClient.Builder withConnectionTimeoutResult = (new HttpSolrClient.Builder()).withBaseSolrUrl("Base Solr Url")
        .allowCompression(true)
        .withConnectionTimeout(10);
    HttpSolrClient.Builder withHttpClientResult = withConnectionTimeoutResult.withHttpClient(new AutoRetryHttpClient());
    HttpSolrClient delegate = withHttpClientResult.withResponseParser(new BinaryResponseParser())
        .withSocketTimeout(10)
        .build();
    DelegatingHttpSolrClient delegatingHttpSolrClient = new DelegatingHttpSolrClient(delegate);

    // Act
    delegatingHttpSolrClient.add(new ArrayList<>(), 2);
  }

  /**
   * Test {@link DelegatingHttpSolrClient#addBean(String, Object)} with
   * {@code collection}, {@code obj}.
   * <p>
   * Method under test: {@link DelegatingHttpSolrClient#addBean(String, Object)}
   */
  @Test
  public void testAddBeanWithCollectionObj() throws IOException, SolrServerException {
    // Arrange
    UpdateResponse updateResponse = new UpdateResponse();
    when(delegatingHttpSolrClient.addBean(Mockito.<String>any(), Mockito.<Object>any())).thenReturn(updateResponse);

    // Act
    UpdateResponse actualAddBeanResult = delegatingHttpSolrClient.addBean("https://example.org/example", "Obj");

    // Assert
    verify(delegatingHttpSolrClient).addBean(eq("https://example.org/example"), isA(Object.class));
    assertSame(updateResponse, actualAddBeanResult);
  }

  /**
   * Test {@link DelegatingHttpSolrClient#addBean(String, Object, int)} with
   * {@code collection}, {@code obj}, {@code commitWithinMs}.
   * <p>
   * Method under test:
   * {@link DelegatingHttpSolrClient#addBean(String, Object, int)}
   */
  @Test
  public void testAddBeanWithCollectionObjCommitWithinMs() throws IOException, SolrServerException {
    // Arrange
    UpdateResponse updateResponse = new UpdateResponse();
    when(delegatingHttpSolrClient.addBean(Mockito.<String>any(), Mockito.<Object>any(), anyInt()))
        .thenReturn(updateResponse);

    // Act
    UpdateResponse actualAddBeanResult = delegatingHttpSolrClient.addBean("https://example.org/example", "Obj", 2);

    // Assert
    verify(delegatingHttpSolrClient).addBean(eq("https://example.org/example"), isA(Object.class), eq(2));
    assertSame(updateResponse, actualAddBeanResult);
  }

  /**
   * Test {@link DelegatingHttpSolrClient#addBean(Object)} with {@code obj}.
   * <p>
   * Method under test: {@link DelegatingHttpSolrClient#addBean(Object)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testAddBeanWithObj() throws IOException, SolrServerException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   org.apache.solr.client.solrj.beans.BindingException: class: class java.lang.String does not define any fields.
    //       at org.apache.solr.client.solrj.beans.DocumentObjectBinder.toSolrInputDocument(DocumentObjectBinder.java:79)
    //       at org.apache.solr.client.solrj.SolrClient.addBean(SolrClient.java:285)
    //       at org.apache.solr.client.solrj.SolrClient.addBean(SolrClient.java:267)
    //       at org.broadleafcommerce.core.search.service.solr.DelegatingHttpSolrClient.addBean(DelegatingHttpSolrClient.java:196)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange
    HttpSolrClient.Builder withConnectionTimeoutResult = (new HttpSolrClient.Builder())
        .withBaseSolrUrl("https://example.org/example")
        .allowCompression(true)
        .withConnectionTimeout(10);
    HttpSolrClient.Builder withHttpClientResult = withConnectionTimeoutResult.withHttpClient(new AutoRetryHttpClient());
    HttpSolrClient delegate = withHttpClientResult.withResponseParser(new BinaryResponseParser())
        .withSocketTimeout(10)
        .build();

    // Act
    (new DelegatingHttpSolrClient(delegate)).addBean("Obj");
  }

  /**
   * Test {@link DelegatingHttpSolrClient#addBean(Object, int)} with {@code obj},
   * {@code commitWithinMs}.
   * <p>
   * Method under test: {@link DelegatingHttpSolrClient#addBean(Object, int)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testAddBeanWithObjCommitWithinMs() throws IOException, SolrServerException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   org.apache.solr.client.solrj.beans.BindingException: class: class java.lang.String does not define any fields.
    //       at org.apache.solr.client.solrj.beans.DocumentObjectBinder.toSolrInputDocument(DocumentObjectBinder.java:79)
    //       at org.apache.solr.client.solrj.SolrClient.addBean(SolrClient.java:302)
    //       at org.broadleafcommerce.core.search.service.solr.DelegatingHttpSolrClient.addBean(DelegatingHttpSolrClient.java:214)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange
    HttpSolrClient.Builder withConnectionTimeoutResult = (new HttpSolrClient.Builder())
        .withBaseSolrUrl("https://example.org/example")
        .allowCompression(true)
        .withConnectionTimeout(10);
    HttpSolrClient.Builder withHttpClientResult = withConnectionTimeoutResult.withHttpClient(new AutoRetryHttpClient());
    HttpSolrClient delegate = withHttpClientResult.withResponseParser(new BinaryResponseParser())
        .withSocketTimeout(10)
        .build();

    // Act
    (new DelegatingHttpSolrClient(delegate)).addBean((Object) "Obj", 2);
  }

  /**
   * Test {@link DelegatingHttpSolrClient#addBeans(Iterator)} with
   * {@code beanIterator}.
   * <p>
   * Method under test: {@link DelegatingHttpSolrClient#addBeans(Iterator)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testAddBeansWithBeanIterator() throws IOException, SolrServerException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Sandboxing policy violation.
    //   Diffblue Cover ran code in your project that tried
    //     to access the network.
    //   Diffblue Cover's default sandboxing policy disallows this in order to prevent
    //   your code from damaging your system environment.
    //   See https://diff.blue/R011 to resolve this issue.

    // Arrange
    HttpSolrClient.Builder withConnectionTimeoutResult = (new HttpSolrClient.Builder())
        .withBaseSolrUrl("https://example.org/example")
        .allowCompression(true)
        .withConnectionTimeout(10);
    HttpSolrClient.Builder withHttpClientResult = withConnectionTimeoutResult.withHttpClient(new AutoRetryHttpClient());
    HttpSolrClient delegate = withHttpClientResult.withResponseParser(new BinaryResponseParser())
        .withSocketTimeout(10)
        .build();
    DelegatingHttpSolrClient delegatingHttpSolrClient = new DelegatingHttpSolrClient(delegate);

    ArrayList<Object> objectList = new ArrayList<>();

    // Act
    delegatingHttpSolrClient.addBeans(objectList.iterator());
  }

  /**
   * Test {@link DelegatingHttpSolrClient#addBeans(Iterator)} with
   * {@code beanIterator}.
   * <p>
   * Method under test: {@link DelegatingHttpSolrClient#addBeans(Iterator)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testAddBeansWithBeanIterator2() throws IOException, SolrServerException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.IllegalArgumentException: Illegal character in path at index 4: Base Solr Url/update?wt=javabin&version=2
    //       at java.base/java.net.URI.create(URI.java:883)
    //       at org.apache.http.client.methods.HttpPost.<init>(HttpPost.java:73)
    //       at org.apache.solr.client.solrj.impl.HttpSolrClient.createMethod(HttpSolrClient.java:416)
    //       at org.apache.solr.client.solrj.impl.HttpSolrClient.request(HttpSolrClient.java:257)
    //       at org.apache.solr.client.solrj.impl.HttpSolrClient.request(HttpSolrClient.java:248)
    //       at org.apache.solr.client.solrj.SolrRequest.process(SolrRequest.java:225)
    //       at org.apache.solr.client.solrj.SolrClient.addBeans(SolrClient.java:424)
    //       at org.apache.solr.client.solrj.SolrClient.addBeans(SolrClient.java:439)
    //       at org.broadleafcommerce.core.search.service.solr.DelegatingHttpSolrClient.addBeans(DelegatingHttpSolrClient.java:268)
    //   java.net.URISyntaxException: Illegal character in path at index 4: Base Solr Url/update?wt=javabin&version=2
    //       at java.base/java.net.URI$Parser.fail(URI.java:2913)
    //       at java.base/java.net.URI$Parser.checkChars(URI.java:3084)
    //       at java.base/java.net.URI$Parser.parseHierarchical(URI.java:3166)
    //       at java.base/java.net.URI$Parser.parse(URI.java:3125)
    //       at java.base/java.net.URI.<init>(URI.java:600)
    //       at java.base/java.net.URI.create(URI.java:881)
    //       at org.apache.http.client.methods.HttpPost.<init>(HttpPost.java:73)
    //       at org.apache.solr.client.solrj.impl.HttpSolrClient.createMethod(HttpSolrClient.java:416)
    //       at org.apache.solr.client.solrj.impl.HttpSolrClient.request(HttpSolrClient.java:257)
    //       at org.apache.solr.client.solrj.impl.HttpSolrClient.request(HttpSolrClient.java:248)
    //       at org.apache.solr.client.solrj.SolrRequest.process(SolrRequest.java:225)
    //       at org.apache.solr.client.solrj.SolrClient.addBeans(SolrClient.java:424)
    //       at org.apache.solr.client.solrj.SolrClient.addBeans(SolrClient.java:439)
    //       at org.broadleafcommerce.core.search.service.solr.DelegatingHttpSolrClient.addBeans(DelegatingHttpSolrClient.java:268)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange
    HttpSolrClient.Builder withConnectionTimeoutResult = (new HttpSolrClient.Builder()).withBaseSolrUrl("Base Solr Url")
        .allowCompression(true)
        .withConnectionTimeout(10);
    HttpSolrClient.Builder withHttpClientResult = withConnectionTimeoutResult.withHttpClient(new AutoRetryHttpClient());
    HttpSolrClient delegate = withHttpClientResult.withResponseParser(new BinaryResponseParser())
        .withSocketTimeout(10)
        .build();
    DelegatingHttpSolrClient delegatingHttpSolrClient = new DelegatingHttpSolrClient(delegate);

    ArrayList<Object> objectList = new ArrayList<>();

    // Act
    delegatingHttpSolrClient.addBeans(objectList.iterator());
  }

  /**
   * Test {@link DelegatingHttpSolrClient#addBeans(Collection)} with
   * {@code beans}.
   * <p>
   * Method under test: {@link DelegatingHttpSolrClient#addBeans(Collection)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testAddBeansWithBeans() throws IOException, SolrServerException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Sandboxing policy violation.
    //   Diffblue Cover ran code in your project that tried
    //     to access the network.
    //   Diffblue Cover's default sandboxing policy disallows this in order to prevent
    //   your code from damaging your system environment.
    //   See https://diff.blue/R011 to resolve this issue.

    // Arrange
    HttpSolrClient.Builder withConnectionTimeoutResult = (new HttpSolrClient.Builder())
        .withBaseSolrUrl("https://example.org/example")
        .allowCompression(true)
        .withConnectionTimeout(10);
    HttpSolrClient.Builder withHttpClientResult = withConnectionTimeoutResult.withHttpClient(new AutoRetryHttpClient());
    HttpSolrClient delegate = withHttpClientResult.withResponseParser(new BinaryResponseParser())
        .withSocketTimeout(10)
        .build();
    DelegatingHttpSolrClient delegatingHttpSolrClient = new DelegatingHttpSolrClient(delegate);

    // Act
    delegatingHttpSolrClient.addBeans(new ArrayList<>());
  }

  /**
   * Test {@link DelegatingHttpSolrClient#addBeans(Collection)} with
   * {@code beans}.
   * <p>
   * Method under test: {@link DelegatingHttpSolrClient#addBeans(Collection)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testAddBeansWithBeans2() throws IOException, SolrServerException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.IllegalArgumentException: Illegal character in path at index 4: Base Solr Url/update
    //       at java.base/java.net.URI.create(URI.java:883)
    //       at org.apache.http.client.methods.HttpPost.<init>(HttpPost.java:73)
    //       at org.apache.solr.client.solrj.impl.HttpSolrClient.fillContentStream(HttpSolrClient.java:484)
    //       at org.apache.solr.client.solrj.impl.HttpSolrClient.createMethod(HttpSolrClient.java:438)
    //       at org.apache.solr.client.solrj.impl.HttpSolrClient.request(HttpSolrClient.java:257)
    //       at org.apache.solr.client.solrj.impl.HttpSolrClient.request(HttpSolrClient.java:248)
    //       at org.apache.solr.client.solrj.SolrRequest.process(SolrRequest.java:225)
    //       at org.apache.solr.client.solrj.SolrClient.add(SolrClient.java:106)
    //       at org.apache.solr.client.solrj.SolrClient.addBeans(SolrClient.java:365)
    //       at org.apache.solr.client.solrj.SolrClient.addBeans(SolrClient.java:337)
    //       at org.broadleafcommerce.core.search.service.solr.DelegatingHttpSolrClient.addBeans(DelegatingHttpSolrClient.java:232)
    //   java.net.URISyntaxException: Illegal character in path at index 4: Base Solr Url/update
    //       at java.base/java.net.URI$Parser.fail(URI.java:2913)
    //       at java.base/java.net.URI$Parser.checkChars(URI.java:3084)
    //       at java.base/java.net.URI$Parser.parseHierarchical(URI.java:3166)
    //       at java.base/java.net.URI$Parser.parse(URI.java:3125)
    //       at java.base/java.net.URI.<init>(URI.java:600)
    //       at java.base/java.net.URI.create(URI.java:881)
    //       at org.apache.http.client.methods.HttpPost.<init>(HttpPost.java:73)
    //       at org.apache.solr.client.solrj.impl.HttpSolrClient.fillContentStream(HttpSolrClient.java:484)
    //       at org.apache.solr.client.solrj.impl.HttpSolrClient.createMethod(HttpSolrClient.java:438)
    //       at org.apache.solr.client.solrj.impl.HttpSolrClient.request(HttpSolrClient.java:257)
    //       at org.apache.solr.client.solrj.impl.HttpSolrClient.request(HttpSolrClient.java:248)
    //       at org.apache.solr.client.solrj.SolrRequest.process(SolrRequest.java:225)
    //       at org.apache.solr.client.solrj.SolrClient.add(SolrClient.java:106)
    //       at org.apache.solr.client.solrj.SolrClient.addBeans(SolrClient.java:365)
    //       at org.apache.solr.client.solrj.SolrClient.addBeans(SolrClient.java:337)
    //       at org.broadleafcommerce.core.search.service.solr.DelegatingHttpSolrClient.addBeans(DelegatingHttpSolrClient.java:232)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange
    HttpSolrClient.Builder withConnectionTimeoutResult = (new HttpSolrClient.Builder()).withBaseSolrUrl("Base Solr Url")
        .allowCompression(true)
        .withConnectionTimeout(10);
    HttpSolrClient.Builder withHttpClientResult = withConnectionTimeoutResult.withHttpClient(new AutoRetryHttpClient());
    HttpSolrClient delegate = withHttpClientResult.withResponseParser(new BinaryResponseParser())
        .withSocketTimeout(10)
        .build();
    DelegatingHttpSolrClient delegatingHttpSolrClient = new DelegatingHttpSolrClient(delegate);

    // Act
    delegatingHttpSolrClient.addBeans(new ArrayList<>());
  }

  /**
   * Test {@link DelegatingHttpSolrClient#addBeans(Collection, int)} with
   * {@code beans}, {@code commitWithinMs}.
   * <p>
   * Method under test: {@link DelegatingHttpSolrClient#addBeans(Collection, int)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testAddBeansWithBeansCommitWithinMs() throws IOException, SolrServerException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Sandboxing policy violation.
    //   Diffblue Cover ran code in your project that tried
    //     to access the network.
    //   Diffblue Cover's default sandboxing policy disallows this in order to prevent
    //   your code from damaging your system environment.
    //   See https://diff.blue/R011 to resolve this issue.

    // Arrange
    HttpSolrClient.Builder withConnectionTimeoutResult = (new HttpSolrClient.Builder())
        .withBaseSolrUrl("https://example.org/example")
        .allowCompression(true)
        .withConnectionTimeout(10);
    HttpSolrClient.Builder withHttpClientResult = withConnectionTimeoutResult.withHttpClient(new AutoRetryHttpClient());
    HttpSolrClient delegate = withHttpClientResult.withResponseParser(new BinaryResponseParser())
        .withSocketTimeout(10)
        .build();
    DelegatingHttpSolrClient delegatingHttpSolrClient = new DelegatingHttpSolrClient(delegate);

    // Act
    delegatingHttpSolrClient.addBeans(new ArrayList<>(), 2);
  }

  /**
   * Test {@link DelegatingHttpSolrClient#addBeans(Collection, int)} with
   * {@code beans}, {@code commitWithinMs}.
   * <p>
   * Method under test: {@link DelegatingHttpSolrClient#addBeans(Collection, int)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testAddBeansWithBeansCommitWithinMs2() throws IOException, SolrServerException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.IllegalArgumentException: Illegal character in path at index 4: Base Solr Url/update
    //       at java.base/java.net.URI.create(URI.java:883)
    //       at org.apache.http.client.methods.HttpPost.<init>(HttpPost.java:73)
    //       at org.apache.solr.client.solrj.impl.HttpSolrClient.fillContentStream(HttpSolrClient.java:484)
    //       at org.apache.solr.client.solrj.impl.HttpSolrClient.createMethod(HttpSolrClient.java:438)
    //       at org.apache.solr.client.solrj.impl.HttpSolrClient.request(HttpSolrClient.java:257)
    //       at org.apache.solr.client.solrj.impl.HttpSolrClient.request(HttpSolrClient.java:248)
    //       at org.apache.solr.client.solrj.SolrRequest.process(SolrRequest.java:225)
    //       at org.apache.solr.client.solrj.SolrClient.add(SolrClient.java:106)
    //       at org.apache.solr.client.solrj.SolrClient.addBeans(SolrClient.java:365)
    //       at org.apache.solr.client.solrj.SolrClient.addBeans(SolrClient.java:387)
    //       at org.broadleafcommerce.core.search.service.solr.DelegatingHttpSolrClient.addBeans(DelegatingHttpSolrClient.java:250)
    //   java.net.URISyntaxException: Illegal character in path at index 4: Base Solr Url/update
    //       at java.base/java.net.URI$Parser.fail(URI.java:2913)
    //       at java.base/java.net.URI$Parser.checkChars(URI.java:3084)
    //       at java.base/java.net.URI$Parser.parseHierarchical(URI.java:3166)
    //       at java.base/java.net.URI$Parser.parse(URI.java:3125)
    //       at java.base/java.net.URI.<init>(URI.java:600)
    //       at java.base/java.net.URI.create(URI.java:881)
    //       at org.apache.http.client.methods.HttpPost.<init>(HttpPost.java:73)
    //       at org.apache.solr.client.solrj.impl.HttpSolrClient.fillContentStream(HttpSolrClient.java:484)
    //       at org.apache.solr.client.solrj.impl.HttpSolrClient.createMethod(HttpSolrClient.java:438)
    //       at org.apache.solr.client.solrj.impl.HttpSolrClient.request(HttpSolrClient.java:257)
    //       at org.apache.solr.client.solrj.impl.HttpSolrClient.request(HttpSolrClient.java:248)
    //       at org.apache.solr.client.solrj.SolrRequest.process(SolrRequest.java:225)
    //       at org.apache.solr.client.solrj.SolrClient.add(SolrClient.java:106)
    //       at org.apache.solr.client.solrj.SolrClient.addBeans(SolrClient.java:365)
    //       at org.apache.solr.client.solrj.SolrClient.addBeans(SolrClient.java:387)
    //       at org.broadleafcommerce.core.search.service.solr.DelegatingHttpSolrClient.addBeans(DelegatingHttpSolrClient.java:250)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange
    HttpSolrClient.Builder withConnectionTimeoutResult = (new HttpSolrClient.Builder()).withBaseSolrUrl("Base Solr Url")
        .allowCompression(true)
        .withConnectionTimeout(10);
    HttpSolrClient.Builder withHttpClientResult = withConnectionTimeoutResult.withHttpClient(new AutoRetryHttpClient());
    HttpSolrClient delegate = withHttpClientResult.withResponseParser(new BinaryResponseParser())
        .withSocketTimeout(10)
        .build();
    DelegatingHttpSolrClient delegatingHttpSolrClient = new DelegatingHttpSolrClient(delegate);

    // Act
    delegatingHttpSolrClient.addBeans(new ArrayList<>(), 2);
  }

  /**
   * Test {@link DelegatingHttpSolrClient#addBeans(String, Iterator)} with
   * {@code collection}, {@code beanIterator}.
   * <p>
   * Method under test:
   * {@link DelegatingHttpSolrClient#addBeans(String, Iterator)}
   */
  @Test
  public void testAddBeansWithCollectionBeanIterator() throws IOException, SolrServerException {
    // Arrange
    UpdateResponse updateResponse = new UpdateResponse();
    when(delegatingHttpSolrClient.addBeans(Mockito.<String>any(), Mockito.<Iterator<Object>>any()))
        .thenReturn(updateResponse);

    ArrayList<Object> objectList = new ArrayList<>();

    // Act
    UpdateResponse actualAddBeansResult = delegatingHttpSolrClient.addBeans("https://example.org/example",
        objectList.iterator());

    // Assert
    verify(delegatingHttpSolrClient).addBeans(eq("https://example.org/example"), isA(Iterator.class));
    assertSame(updateResponse, actualAddBeansResult);
  }

  /**
   * Test {@link DelegatingHttpSolrClient#addBeans(String, Collection, int)} with
   * {@code collection}, {@code beans}, {@code commitWithinMs}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DelegatingHttpSolrClient#addBeans(String, Collection, int)}
   */
  @Test
  public void testAddBeansWithCollectionBeansCommitWithinMs_given42_whenArrayListAdd42()
      throws IOException, SolrServerException {
    // Arrange
    UpdateResponse updateResponse = new UpdateResponse();
    when(delegatingHttpSolrClient.addBeans(Mockito.<String>any(), Mockito.<Collection<Object>>any(), anyInt()))
        .thenReturn(updateResponse);

    ArrayList<Object> beans = new ArrayList<>();
    beans.add("42");

    // Act
    UpdateResponse actualAddBeansResult = delegatingHttpSolrClient.addBeans("https://example.org/example", beans, 2);

    // Assert
    verify(delegatingHttpSolrClient).addBeans(eq("https://example.org/example"), isA(Collection.class), eq(2));
    assertSame(updateResponse, actualAddBeansResult);
  }

  /**
   * Test {@link DelegatingHttpSolrClient#addBeans(String, Collection, int)} with
   * {@code collection}, {@code beans}, {@code commitWithinMs}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DelegatingHttpSolrClient#addBeans(String, Collection, int)}
   */
  @Test
  public void testAddBeansWithCollectionBeansCommitWithinMs_given42_whenArrayListAdd422()
      throws IOException, SolrServerException {
    // Arrange
    UpdateResponse updateResponse = new UpdateResponse();
    when(delegatingHttpSolrClient.addBeans(Mockito.<String>any(), Mockito.<Collection<Object>>any(), anyInt()))
        .thenReturn(updateResponse);

    ArrayList<Object> beans = new ArrayList<>();
    beans.add("42");
    beans.add("42");

    // Act
    UpdateResponse actualAddBeansResult = delegatingHttpSolrClient.addBeans("https://example.org/example", beans, 2);

    // Assert
    verify(delegatingHttpSolrClient).addBeans(eq("https://example.org/example"), isA(Collection.class), eq(2));
    assertSame(updateResponse, actualAddBeansResult);
  }

  /**
   * Test {@link DelegatingHttpSolrClient#addBeans(String, Collection, int)} with
   * {@code collection}, {@code beans}, {@code commitWithinMs}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DelegatingHttpSolrClient#addBeans(String, Collection, int)}
   */
  @Test
  public void testAddBeansWithCollectionBeansCommitWithinMs_whenArrayList() throws IOException, SolrServerException {
    // Arrange
    UpdateResponse updateResponse = new UpdateResponse();
    when(delegatingHttpSolrClient.addBeans(Mockito.<String>any(), Mockito.<Collection<Object>>any(), anyInt()))
        .thenReturn(updateResponse);

    // Act
    UpdateResponse actualAddBeansResult = delegatingHttpSolrClient.addBeans("https://example.org/example",
        new ArrayList<>(), 2);

    // Assert
    verify(delegatingHttpSolrClient).addBeans(eq("https://example.org/example"), isA(Collection.class), eq(2));
    assertSame(updateResponse, actualAddBeansResult);
  }

  /**
   * Test {@link DelegatingHttpSolrClient#addBeans(String, Collection)} with
   * {@code collection}, {@code beans}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DelegatingHttpSolrClient#addBeans(String, Collection)}
   */
  @Test
  public void testAddBeansWithCollectionBeans_given42_whenArrayListAdd42() throws IOException, SolrServerException {
    // Arrange
    UpdateResponse updateResponse = new UpdateResponse();
    when(delegatingHttpSolrClient.addBeans(Mockito.<String>any(), Mockito.<Collection<Object>>any()))
        .thenReturn(updateResponse);

    ArrayList<Object> beans = new ArrayList<>();
    beans.add("42");

    // Act
    UpdateResponse actualAddBeansResult = delegatingHttpSolrClient.addBeans("https://example.org/example", beans);

    // Assert
    verify(delegatingHttpSolrClient).addBeans(eq("https://example.org/example"), isA(Collection.class));
    assertSame(updateResponse, actualAddBeansResult);
  }

  /**
   * Test {@link DelegatingHttpSolrClient#addBeans(String, Collection)} with
   * {@code collection}, {@code beans}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DelegatingHttpSolrClient#addBeans(String, Collection)}
   */
  @Test
  public void testAddBeansWithCollectionBeans_given42_whenArrayListAdd422() throws IOException, SolrServerException {
    // Arrange
    UpdateResponse updateResponse = new UpdateResponse();
    when(delegatingHttpSolrClient.addBeans(Mockito.<String>any(), Mockito.<Collection<Object>>any()))
        .thenReturn(updateResponse);

    ArrayList<Object> beans = new ArrayList<>();
    beans.add("42");
    beans.add("42");

    // Act
    UpdateResponse actualAddBeansResult = delegatingHttpSolrClient.addBeans("https://example.org/example", beans);

    // Assert
    verify(delegatingHttpSolrClient).addBeans(eq("https://example.org/example"), isA(Collection.class));
    assertSame(updateResponse, actualAddBeansResult);
  }

  /**
   * Test {@link DelegatingHttpSolrClient#addBeans(String, Collection)} with
   * {@code collection}, {@code beans}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DelegatingHttpSolrClient#addBeans(String, Collection)}
   */
  @Test
  public void testAddBeansWithCollectionBeans_whenArrayList() throws IOException, SolrServerException {
    // Arrange
    UpdateResponse updateResponse = new UpdateResponse();
    when(delegatingHttpSolrClient.addBeans(Mockito.<String>any(), Mockito.<Collection<Object>>any()))
        .thenReturn(updateResponse);

    // Act
    UpdateResponse actualAddBeansResult = delegatingHttpSolrClient.addBeans("https://example.org/example",
        new ArrayList<>());

    // Assert
    verify(delegatingHttpSolrClient).addBeans(eq("https://example.org/example"), isA(Collection.class));
    assertSame(updateResponse, actualAddBeansResult);
  }

  /**
   * Test {@link DelegatingHttpSolrClient#commit()}.
   * <p>
   * Method under test: {@link DelegatingHttpSolrClient#commit()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testCommit() throws IOException, SolrServerException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Sandboxing policy violation.
    //   Diffblue Cover ran code in your project that tried
    //     to access the network.
    //   Diffblue Cover's default sandboxing policy disallows this in order to prevent
    //   your code from damaging your system environment.
    //   See https://diff.blue/R011 to resolve this issue.

    // Arrange
    HttpSolrClient.Builder withConnectionTimeoutResult = (new HttpSolrClient.Builder())
        .withBaseSolrUrl("https://example.org/example")
        .allowCompression(true)
        .withConnectionTimeout(10);
    HttpSolrClient.Builder withHttpClientResult = withConnectionTimeoutResult.withHttpClient(new AutoRetryHttpClient());
    HttpSolrClient delegate = withHttpClientResult.withResponseParser(new BinaryResponseParser())
        .withSocketTimeout(10)
        .build();

    // Act
    (new DelegatingHttpSolrClient(delegate)).commit();
  }

  /**
   * Test {@link DelegatingHttpSolrClient#commit()}.
   * <p>
   * Method under test: {@link DelegatingHttpSolrClient#commit()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testCommit2() throws IOException, SolrServerException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.IllegalArgumentException: Illegal character in path at index 4: Base Solr Url/update
    //       at java.base/java.net.URI.create(URI.java:883)
    //       at org.apache.http.client.methods.HttpPost.<init>(HttpPost.java:73)
    //       at org.apache.solr.client.solrj.impl.HttpSolrClient.fillContentStream(HttpSolrClient.java:484)
    //       at org.apache.solr.client.solrj.impl.HttpSolrClient.createMethod(HttpSolrClient.java:438)
    //       at org.apache.solr.client.solrj.impl.HttpSolrClient.request(HttpSolrClient.java:257)
    //       at org.apache.solr.client.solrj.impl.HttpSolrClient.request(HttpSolrClient.java:248)
    //       at org.apache.solr.client.solrj.SolrRequest.process(SolrRequest.java:225)
    //       at org.apache.solr.client.solrj.SolrClient.commit(SolrClient.java:504)
    //       at org.apache.solr.client.solrj.SolrClient.commit(SolrClient.java:479)
    //       at org.broadleafcommerce.core.search.service.solr.DelegatingHttpSolrClient.commit(DelegatingHttpSolrClient.java:286)
    //   java.net.URISyntaxException: Illegal character in path at index 4: Base Solr Url/update
    //       at java.base/java.net.URI$Parser.fail(URI.java:2913)
    //       at java.base/java.net.URI$Parser.checkChars(URI.java:3084)
    //       at java.base/java.net.URI$Parser.parseHierarchical(URI.java:3166)
    //       at java.base/java.net.URI$Parser.parse(URI.java:3125)
    //       at java.base/java.net.URI.<init>(URI.java:600)
    //       at java.base/java.net.URI.create(URI.java:881)
    //       at org.apache.http.client.methods.HttpPost.<init>(HttpPost.java:73)
    //       at org.apache.solr.client.solrj.impl.HttpSolrClient.fillContentStream(HttpSolrClient.java:484)
    //       at org.apache.solr.client.solrj.impl.HttpSolrClient.createMethod(HttpSolrClient.java:438)
    //       at org.apache.solr.client.solrj.impl.HttpSolrClient.request(HttpSolrClient.java:257)
    //       at org.apache.solr.client.solrj.impl.HttpSolrClient.request(HttpSolrClient.java:248)
    //       at org.apache.solr.client.solrj.SolrRequest.process(SolrRequest.java:225)
    //       at org.apache.solr.client.solrj.SolrClient.commit(SolrClient.java:504)
    //       at org.apache.solr.client.solrj.SolrClient.commit(SolrClient.java:479)
    //       at org.broadleafcommerce.core.search.service.solr.DelegatingHttpSolrClient.commit(DelegatingHttpSolrClient.java:286)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange
    HttpSolrClient.Builder withConnectionTimeoutResult = (new HttpSolrClient.Builder()).withBaseSolrUrl("Base Solr Url")
        .allowCompression(true)
        .withConnectionTimeout(10);
    HttpSolrClient.Builder withHttpClientResult = withConnectionTimeoutResult.withHttpClient(new AutoRetryHttpClient());
    HttpSolrClient delegate = withHttpClientResult.withResponseParser(new BinaryResponseParser())
        .withSocketTimeout(10)
        .build();

    // Act
    (new DelegatingHttpSolrClient(delegate)).commit();
  }

  /**
   * Test {@link DelegatingHttpSolrClient#commit(String)} with {@code collection}.
   * <p>
   * Method under test: {@link DelegatingHttpSolrClient#commit(String)}
   */
  @Test
  public void testCommitWithCollection() throws IOException, SolrServerException {
    // Arrange
    UpdateResponse updateResponse = new UpdateResponse();
    when(delegatingHttpSolrClient.commit(Mockito.<String>any())).thenReturn(updateResponse);

    // Act
    UpdateResponse actualCommitResult = delegatingHttpSolrClient.commit("https://example.org/example");

    // Assert
    verify(delegatingHttpSolrClient).commit(eq("https://example.org/example"));
    assertSame(updateResponse, actualCommitResult);
  }

  /**
   * Test {@link DelegatingHttpSolrClient#commit(String, boolean, boolean)} with
   * {@code collection}, {@code waitFlush}, {@code waitSearcher}.
   * <p>
   * Method under test:
   * {@link DelegatingHttpSolrClient#commit(String, boolean, boolean)}
   */
  @Test
  public void testCommitWithCollectionWaitFlushWaitSearcher() throws IOException, SolrServerException {
    // Arrange
    UpdateResponse updateResponse = new UpdateResponse();
    when(delegatingHttpSolrClient.commit(Mockito.<String>any(), anyBoolean(), anyBoolean())).thenReturn(updateResponse);

    // Act
    UpdateResponse actualCommitResult = delegatingHttpSolrClient.commit("https://example.org/example", true, true);

    // Assert
    verify(delegatingHttpSolrClient).commit(eq("https://example.org/example"), eq(true), eq(true));
    assertSame(updateResponse, actualCommitResult);
  }

  /**
   * Test
   * {@link DelegatingHttpSolrClient#commit(String, boolean, boolean, boolean)}
   * with {@code collection}, {@code waitFlush}, {@code waitSearcher},
   * {@code softCommit}.
   * <p>
   * Method under test:
   * {@link DelegatingHttpSolrClient#commit(String, boolean, boolean, boolean)}
   */
  @Test
  public void testCommitWithCollectionWaitFlushWaitSearcherSoftCommit() throws IOException, SolrServerException {
    // Arrange
    UpdateResponse updateResponse = new UpdateResponse();
    when(delegatingHttpSolrClient.commit(Mockito.<String>any(), anyBoolean(), anyBoolean(), anyBoolean()))
        .thenReturn(updateResponse);

    // Act
    UpdateResponse actualCommitResult = delegatingHttpSolrClient.commit("https://example.org/example", true, true,
        true);

    // Assert
    verify(delegatingHttpSolrClient).commit(eq("https://example.org/example"), eq(true), eq(true), eq(true));
    assertSame(updateResponse, actualCommitResult);
  }

  /**
   * Test {@link DelegatingHttpSolrClient#commit(boolean, boolean)} with
   * {@code waitFlush}, {@code waitSearcher}.
   * <p>
   * Method under test: {@link DelegatingHttpSolrClient#commit(boolean, boolean)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testCommitWithWaitFlushWaitSearcher() throws IOException, SolrServerException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Sandboxing policy violation.
    //   Diffblue Cover ran code in your project that tried
    //     to access the network.
    //   Diffblue Cover's default sandboxing policy disallows this in order to prevent
    //   your code from damaging your system environment.
    //   See https://diff.blue/R011 to resolve this issue.

    // Arrange
    HttpSolrClient.Builder withConnectionTimeoutResult = (new HttpSolrClient.Builder())
        .withBaseSolrUrl("https://example.org/example")
        .allowCompression(true)
        .withConnectionTimeout(10);
    HttpSolrClient.Builder withHttpClientResult = withConnectionTimeoutResult.withHttpClient(new AutoRetryHttpClient());
    HttpSolrClient delegate = withHttpClientResult.withResponseParser(new BinaryResponseParser())
        .withSocketTimeout(10)
        .build();

    // Act
    (new DelegatingHttpSolrClient(delegate)).commit(true, true);
  }

  /**
   * Test {@link DelegatingHttpSolrClient#commit(boolean, boolean)} with
   * {@code waitFlush}, {@code waitSearcher}.
   * <p>
   * Method under test: {@link DelegatingHttpSolrClient#commit(boolean, boolean)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testCommitWithWaitFlushWaitSearcher2() throws IOException, SolrServerException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.IllegalArgumentException: Illegal character in path at index 4: Base Solr Url/update
    //       at java.base/java.net.URI.create(URI.java:883)
    //       at org.apache.http.client.methods.HttpPost.<init>(HttpPost.java:73)
    //       at org.apache.solr.client.solrj.impl.HttpSolrClient.fillContentStream(HttpSolrClient.java:484)
    //       at org.apache.solr.client.solrj.impl.HttpSolrClient.createMethod(HttpSolrClient.java:438)
    //       at org.apache.solr.client.solrj.impl.HttpSolrClient.request(HttpSolrClient.java:257)
    //       at org.apache.solr.client.solrj.impl.HttpSolrClient.request(HttpSolrClient.java:248)
    //       at org.apache.solr.client.solrj.SolrRequest.process(SolrRequest.java:225)
    //       at org.apache.solr.client.solrj.SolrClient.commit(SolrClient.java:504)
    //       at org.apache.solr.client.solrj.SolrClient.commit(SolrClient.java:525)
    //       at org.broadleafcommerce.core.search.service.solr.DelegatingHttpSolrClient.commit(DelegatingHttpSolrClient.java:304)
    //   java.net.URISyntaxException: Illegal character in path at index 4: Base Solr Url/update
    //       at java.base/java.net.URI$Parser.fail(URI.java:2913)
    //       at java.base/java.net.URI$Parser.checkChars(URI.java:3084)
    //       at java.base/java.net.URI$Parser.parseHierarchical(URI.java:3166)
    //       at java.base/java.net.URI$Parser.parse(URI.java:3125)
    //       at java.base/java.net.URI.<init>(URI.java:600)
    //       at java.base/java.net.URI.create(URI.java:881)
    //       at org.apache.http.client.methods.HttpPost.<init>(HttpPost.java:73)
    //       at org.apache.solr.client.solrj.impl.HttpSolrClient.fillContentStream(HttpSolrClient.java:484)
    //       at org.apache.solr.client.solrj.impl.HttpSolrClient.createMethod(HttpSolrClient.java:438)
    //       at org.apache.solr.client.solrj.impl.HttpSolrClient.request(HttpSolrClient.java:257)
    //       at org.apache.solr.client.solrj.impl.HttpSolrClient.request(HttpSolrClient.java:248)
    //       at org.apache.solr.client.solrj.SolrRequest.process(SolrRequest.java:225)
    //       at org.apache.solr.client.solrj.SolrClient.commit(SolrClient.java:504)
    //       at org.apache.solr.client.solrj.SolrClient.commit(SolrClient.java:525)
    //       at org.broadleafcommerce.core.search.service.solr.DelegatingHttpSolrClient.commit(DelegatingHttpSolrClient.java:304)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange
    HttpSolrClient.Builder withConnectionTimeoutResult = (new HttpSolrClient.Builder()).withBaseSolrUrl("Base Solr Url")
        .allowCompression(true)
        .withConnectionTimeout(10);
    HttpSolrClient.Builder withHttpClientResult = withConnectionTimeoutResult.withHttpClient(new AutoRetryHttpClient());
    HttpSolrClient delegate = withHttpClientResult.withResponseParser(new BinaryResponseParser())
        .withSocketTimeout(10)
        .build();

    // Act
    (new DelegatingHttpSolrClient(delegate)).commit(true, true);
  }

  /**
   * Test {@link DelegatingHttpSolrClient#commit(boolean, boolean, boolean)} with
   * {@code waitFlush}, {@code waitSearcher}, {@code softCommit}.
   * <p>
   * Method under test:
   * {@link DelegatingHttpSolrClient#commit(boolean, boolean, boolean)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testCommitWithWaitFlushWaitSearcherSoftCommit() throws IOException, SolrServerException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Sandboxing policy violation.
    //   Diffblue Cover ran code in your project that tried
    //     to access the network.
    //   Diffblue Cover's default sandboxing policy disallows this in order to prevent
    //   your code from damaging your system environment.
    //   See https://diff.blue/R011 to resolve this issue.

    // Arrange
    HttpSolrClient.Builder withConnectionTimeoutResult = (new HttpSolrClient.Builder())
        .withBaseSolrUrl("https://example.org/example")
        .allowCompression(true)
        .withConnectionTimeout(10);
    HttpSolrClient.Builder withHttpClientResult = withConnectionTimeoutResult.withHttpClient(new AutoRetryHttpClient());
    HttpSolrClient delegate = withHttpClientResult.withResponseParser(new BinaryResponseParser())
        .withSocketTimeout(10)
        .build();

    // Act
    (new DelegatingHttpSolrClient(delegate)).commit(true, true, true);
  }

  /**
   * Test {@link DelegatingHttpSolrClient#commit(boolean, boolean, boolean)} with
   * {@code waitFlush}, {@code waitSearcher}, {@code softCommit}.
   * <p>
   * Method under test:
   * {@link DelegatingHttpSolrClient#commit(boolean, boolean, boolean)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testCommitWithWaitFlushWaitSearcherSoftCommit2() throws IOException, SolrServerException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.IllegalArgumentException: Illegal character in path at index 4: Base Solr Url/update
    //       at java.base/java.net.URI.create(URI.java:883)
    //       at org.apache.http.client.methods.HttpPost.<init>(HttpPost.java:73)
    //       at org.apache.solr.client.solrj.impl.HttpSolrClient.fillContentStream(HttpSolrClient.java:484)
    //       at org.apache.solr.client.solrj.impl.HttpSolrClient.createMethod(HttpSolrClient.java:438)
    //       at org.apache.solr.client.solrj.impl.HttpSolrClient.request(HttpSolrClient.java:257)
    //       at org.apache.solr.client.solrj.impl.HttpSolrClient.request(HttpSolrClient.java:248)
    //       at org.apache.solr.client.solrj.SolrRequest.process(SolrRequest.java:225)
    //       at org.apache.solr.client.solrj.SolrClient.commit(SolrClient.java:552)
    //       at org.apache.solr.client.solrj.SolrClient.commit(SolrClient.java:576)
    //       at org.broadleafcommerce.core.search.service.solr.DelegatingHttpSolrClient.commit(DelegatingHttpSolrClient.java:322)
    //   java.net.URISyntaxException: Illegal character in path at index 4: Base Solr Url/update
    //       at java.base/java.net.URI$Parser.fail(URI.java:2913)
    //       at java.base/java.net.URI$Parser.checkChars(URI.java:3084)
    //       at java.base/java.net.URI$Parser.parseHierarchical(URI.java:3166)
    //       at java.base/java.net.URI$Parser.parse(URI.java:3125)
    //       at java.base/java.net.URI.<init>(URI.java:600)
    //       at java.base/java.net.URI.create(URI.java:881)
    //       at org.apache.http.client.methods.HttpPost.<init>(HttpPost.java:73)
    //       at org.apache.solr.client.solrj.impl.HttpSolrClient.fillContentStream(HttpSolrClient.java:484)
    //       at org.apache.solr.client.solrj.impl.HttpSolrClient.createMethod(HttpSolrClient.java:438)
    //       at org.apache.solr.client.solrj.impl.HttpSolrClient.request(HttpSolrClient.java:257)
    //       at org.apache.solr.client.solrj.impl.HttpSolrClient.request(HttpSolrClient.java:248)
    //       at org.apache.solr.client.solrj.SolrRequest.process(SolrRequest.java:225)
    //       at org.apache.solr.client.solrj.SolrClient.commit(SolrClient.java:552)
    //       at org.apache.solr.client.solrj.SolrClient.commit(SolrClient.java:576)
    //       at org.broadleafcommerce.core.search.service.solr.DelegatingHttpSolrClient.commit(DelegatingHttpSolrClient.java:322)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange
    HttpSolrClient.Builder withConnectionTimeoutResult = (new HttpSolrClient.Builder()).withBaseSolrUrl("Base Solr Url")
        .allowCompression(true)
        .withConnectionTimeout(10);
    HttpSolrClient.Builder withHttpClientResult = withConnectionTimeoutResult.withHttpClient(new AutoRetryHttpClient());
    HttpSolrClient delegate = withHttpClientResult.withResponseParser(new BinaryResponseParser())
        .withSocketTimeout(10)
        .build();

    // Act
    (new DelegatingHttpSolrClient(delegate)).commit(true, true, true);
  }

  /**
   * Test {@link DelegatingHttpSolrClient#optimize()}.
   * <p>
   * Method under test: {@link DelegatingHttpSolrClient#optimize()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testOptimize() throws IOException, SolrServerException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Sandboxing policy violation.
    //   Diffblue Cover ran code in your project that tried
    //     to access the network.
    //   Diffblue Cover's default sandboxing policy disallows this in order to prevent
    //   your code from damaging your system environment.
    //   See https://diff.blue/R011 to resolve this issue.

    // Arrange
    HttpSolrClient.Builder withConnectionTimeoutResult = (new HttpSolrClient.Builder())
        .withBaseSolrUrl("https://example.org/example")
        .allowCompression(true)
        .withConnectionTimeout(10);
    HttpSolrClient.Builder withHttpClientResult = withConnectionTimeoutResult.withHttpClient(new AutoRetryHttpClient());
    HttpSolrClient delegate = withHttpClientResult.withResponseParser(new BinaryResponseParser())
        .withSocketTimeout(10)
        .build();

    // Act
    (new DelegatingHttpSolrClient(delegate)).optimize();
  }

  /**
   * Test {@link DelegatingHttpSolrClient#optimize()}.
   * <p>
   * Method under test: {@link DelegatingHttpSolrClient#optimize()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testOptimize2() throws IOException, SolrServerException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.IllegalArgumentException: Illegal character in path at index 4: Base Solr Url/update
    //       at java.base/java.net.URI.create(URI.java:883)
    //       at org.apache.http.client.methods.HttpPost.<init>(HttpPost.java:73)
    //       at org.apache.solr.client.solrj.impl.HttpSolrClient.fillContentStream(HttpSolrClient.java:484)
    //       at org.apache.solr.client.solrj.impl.HttpSolrClient.createMethod(HttpSolrClient.java:438)
    //       at org.apache.solr.client.solrj.impl.HttpSolrClient.request(HttpSolrClient.java:257)
    //       at org.apache.solr.client.solrj.impl.HttpSolrClient.request(HttpSolrClient.java:248)
    //       at org.apache.solr.client.solrj.SolrRequest.process(SolrRequest.java:225)
    //       at org.apache.solr.client.solrj.SolrClient.optimize(SolrClient.java:675)
    //       at org.apache.solr.client.solrj.SolrClient.optimize(SolrClient.java:612)
    //       at org.broadleafcommerce.core.search.service.solr.DelegatingHttpSolrClient.optimize(DelegatingHttpSolrClient.java:340)
    //   java.net.URISyntaxException: Illegal character in path at index 4: Base Solr Url/update
    //       at java.base/java.net.URI$Parser.fail(URI.java:2913)
    //       at java.base/java.net.URI$Parser.checkChars(URI.java:3084)
    //       at java.base/java.net.URI$Parser.parseHierarchical(URI.java:3166)
    //       at java.base/java.net.URI$Parser.parse(URI.java:3125)
    //       at java.base/java.net.URI.<init>(URI.java:600)
    //       at java.base/java.net.URI.create(URI.java:881)
    //       at org.apache.http.client.methods.HttpPost.<init>(HttpPost.java:73)
    //       at org.apache.solr.client.solrj.impl.HttpSolrClient.fillContentStream(HttpSolrClient.java:484)
    //       at org.apache.solr.client.solrj.impl.HttpSolrClient.createMethod(HttpSolrClient.java:438)
    //       at org.apache.solr.client.solrj.impl.HttpSolrClient.request(HttpSolrClient.java:257)
    //       at org.apache.solr.client.solrj.impl.HttpSolrClient.request(HttpSolrClient.java:248)
    //       at org.apache.solr.client.solrj.SolrRequest.process(SolrRequest.java:225)
    //       at org.apache.solr.client.solrj.SolrClient.optimize(SolrClient.java:675)
    //       at org.apache.solr.client.solrj.SolrClient.optimize(SolrClient.java:612)
    //       at org.broadleafcommerce.core.search.service.solr.DelegatingHttpSolrClient.optimize(DelegatingHttpSolrClient.java:340)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange
    HttpSolrClient.Builder withConnectionTimeoutResult = (new HttpSolrClient.Builder()).withBaseSolrUrl("Base Solr Url")
        .allowCompression(true)
        .withConnectionTimeout(10);
    HttpSolrClient.Builder withHttpClientResult = withConnectionTimeoutResult.withHttpClient(new AutoRetryHttpClient());
    HttpSolrClient delegate = withHttpClientResult.withResponseParser(new BinaryResponseParser())
        .withSocketTimeout(10)
        .build();

    // Act
    (new DelegatingHttpSolrClient(delegate)).optimize();
  }

  /**
   * Test {@link DelegatingHttpSolrClient#optimize(String)} with
   * {@code collection}.
   * <p>
   * Method under test: {@link DelegatingHttpSolrClient#optimize(String)}
   */
  @Test
  public void testOptimizeWithCollection() throws IOException, SolrServerException {
    // Arrange
    UpdateResponse updateResponse = new UpdateResponse();
    when(delegatingHttpSolrClient.optimize(Mockito.<String>any())).thenReturn(updateResponse);

    // Act
    UpdateResponse actualOptimizeResult = delegatingHttpSolrClient.optimize("https://example.org/example");

    // Assert
    verify(delegatingHttpSolrClient).optimize(eq("https://example.org/example"));
    assertSame(updateResponse, actualOptimizeResult);
  }

  /**
   * Test {@link DelegatingHttpSolrClient#optimize(String, boolean, boolean)} with
   * {@code collection}, {@code waitFlush}, {@code waitSearcher}.
   * <p>
   * Method under test:
   * {@link DelegatingHttpSolrClient#optimize(String, boolean, boolean)}
   */
  @Test
  public void testOptimizeWithCollectionWaitFlushWaitSearcher() throws IOException, SolrServerException {
    // Arrange
    UpdateResponse updateResponse = new UpdateResponse();
    when(delegatingHttpSolrClient.optimize(Mockito.<String>any(), anyBoolean(), anyBoolean()))
        .thenReturn(updateResponse);

    // Act
    UpdateResponse actualOptimizeResult = delegatingHttpSolrClient.optimize("https://example.org/example", true, true);

    // Assert
    verify(delegatingHttpSolrClient).optimize(eq("https://example.org/example"), eq(true), eq(true));
    assertSame(updateResponse, actualOptimizeResult);
  }

  /**
   * Test {@link DelegatingHttpSolrClient#optimize(String, boolean, boolean, int)}
   * with {@code collection}, {@code waitFlush}, {@code waitSearcher},
   * {@code maxSegments}.
   * <p>
   * Method under test:
   * {@link DelegatingHttpSolrClient#optimize(String, boolean, boolean, int)}
   */
  @Test
  public void testOptimizeWithCollectionWaitFlushWaitSearcherMaxSegments() throws IOException, SolrServerException {
    // Arrange
    UpdateResponse updateResponse = new UpdateResponse();
    when(delegatingHttpSolrClient.optimize(Mockito.<String>any(), anyBoolean(), anyBoolean(), anyInt()))
        .thenReturn(updateResponse);

    // Act
    UpdateResponse actualOptimizeResult = delegatingHttpSolrClient.optimize("https://example.org/example", true, true,
        3);

    // Assert
    verify(delegatingHttpSolrClient).optimize(eq("https://example.org/example"), eq(true), eq(true), eq(3));
    assertSame(updateResponse, actualOptimizeResult);
  }

  /**
   * Test {@link DelegatingHttpSolrClient#optimize(boolean, boolean)} with
   * {@code waitFlush}, {@code waitSearcher}.
   * <p>
   * Method under test:
   * {@link DelegatingHttpSolrClient#optimize(boolean, boolean)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testOptimizeWithWaitFlushWaitSearcher() throws IOException, SolrServerException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Sandboxing policy violation.
    //   Diffblue Cover ran code in your project that tried
    //     to access the network.
    //   Diffblue Cover's default sandboxing policy disallows this in order to prevent
    //   your code from damaging your system environment.
    //   See https://diff.blue/R011 to resolve this issue.

    // Arrange
    HttpSolrClient.Builder withConnectionTimeoutResult = (new HttpSolrClient.Builder())
        .withBaseSolrUrl("https://example.org/example")
        .allowCompression(true)
        .withConnectionTimeout(10);
    HttpSolrClient.Builder withHttpClientResult = withConnectionTimeoutResult.withHttpClient(new AutoRetryHttpClient());
    HttpSolrClient delegate = withHttpClientResult.withResponseParser(new BinaryResponseParser())
        .withSocketTimeout(10)
        .build();

    // Act
    (new DelegatingHttpSolrClient(delegate)).optimize(true, true);
  }

  /**
   * Test {@link DelegatingHttpSolrClient#optimize(boolean, boolean)} with
   * {@code waitFlush}, {@code waitSearcher}.
   * <p>
   * Method under test:
   * {@link DelegatingHttpSolrClient#optimize(boolean, boolean)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testOptimizeWithWaitFlushWaitSearcher2() throws IOException, SolrServerException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.IllegalArgumentException: Illegal character in path at index 4: Base Solr Url/update
    //       at java.base/java.net.URI.create(URI.java:883)
    //       at org.apache.http.client.methods.HttpPost.<init>(HttpPost.java:73)
    //       at org.apache.solr.client.solrj.impl.HttpSolrClient.fillContentStream(HttpSolrClient.java:484)
    //       at org.apache.solr.client.solrj.impl.HttpSolrClient.createMethod(HttpSolrClient.java:438)
    //       at org.apache.solr.client.solrj.impl.HttpSolrClient.request(HttpSolrClient.java:257)
    //       at org.apache.solr.client.solrj.impl.HttpSolrClient.request(HttpSolrClient.java:248)
    //       at org.apache.solr.client.solrj.SolrRequest.process(SolrRequest.java:225)
    //       at org.apache.solr.client.solrj.SolrClient.optimize(SolrClient.java:675)
    //       at org.apache.solr.client.solrj.SolrClient.optimize(SolrClient.java:632)
    //       at org.apache.solr.client.solrj.SolrClient.optimize(SolrClient.java:651)
    //       at org.broadleafcommerce.core.search.service.solr.DelegatingHttpSolrClient.optimize(DelegatingHttpSolrClient.java:358)
    //   java.net.URISyntaxException: Illegal character in path at index 4: Base Solr Url/update
    //       at java.base/java.net.URI$Parser.fail(URI.java:2913)
    //       at java.base/java.net.URI$Parser.checkChars(URI.java:3084)
    //       at java.base/java.net.URI$Parser.parseHierarchical(URI.java:3166)
    //       at java.base/java.net.URI$Parser.parse(URI.java:3125)
    //       at java.base/java.net.URI.<init>(URI.java:600)
    //       at java.base/java.net.URI.create(URI.java:881)
    //       at org.apache.http.client.methods.HttpPost.<init>(HttpPost.java:73)
    //       at org.apache.solr.client.solrj.impl.HttpSolrClient.fillContentStream(HttpSolrClient.java:484)
    //       at org.apache.solr.client.solrj.impl.HttpSolrClient.createMethod(HttpSolrClient.java:438)
    //       at org.apache.solr.client.solrj.impl.HttpSolrClient.request(HttpSolrClient.java:257)
    //       at org.apache.solr.client.solrj.impl.HttpSolrClient.request(HttpSolrClient.java:248)
    //       at org.apache.solr.client.solrj.SolrRequest.process(SolrRequest.java:225)
    //       at org.apache.solr.client.solrj.SolrClient.optimize(SolrClient.java:675)
    //       at org.apache.solr.client.solrj.SolrClient.optimize(SolrClient.java:632)
    //       at org.apache.solr.client.solrj.SolrClient.optimize(SolrClient.java:651)
    //       at org.broadleafcommerce.core.search.service.solr.DelegatingHttpSolrClient.optimize(DelegatingHttpSolrClient.java:358)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange
    HttpSolrClient.Builder withConnectionTimeoutResult = (new HttpSolrClient.Builder()).withBaseSolrUrl("Base Solr Url")
        .allowCompression(true)
        .withConnectionTimeout(10);
    HttpSolrClient.Builder withHttpClientResult = withConnectionTimeoutResult.withHttpClient(new AutoRetryHttpClient());
    HttpSolrClient delegate = withHttpClientResult.withResponseParser(new BinaryResponseParser())
        .withSocketTimeout(10)
        .build();

    // Act
    (new DelegatingHttpSolrClient(delegate)).optimize(true, true);
  }

  /**
   * Test {@link DelegatingHttpSolrClient#optimize(boolean, boolean, int)} with
   * {@code waitFlush}, {@code waitSearcher}, {@code maxSegments}.
   * <p>
   * Method under test:
   * {@link DelegatingHttpSolrClient#optimize(boolean, boolean, int)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testOptimizeWithWaitFlushWaitSearcherMaxSegments() throws IOException, SolrServerException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Sandboxing policy violation.
    //   Diffblue Cover ran code in your project that tried
    //     to access the network.
    //   Diffblue Cover's default sandboxing policy disallows this in order to prevent
    //   your code from damaging your system environment.
    //   See https://diff.blue/R011 to resolve this issue.

    // Arrange
    HttpSolrClient.Builder withConnectionTimeoutResult = (new HttpSolrClient.Builder())
        .withBaseSolrUrl("https://example.org/example")
        .allowCompression(true)
        .withConnectionTimeout(10);
    HttpSolrClient.Builder withHttpClientResult = withConnectionTimeoutResult.withHttpClient(new AutoRetryHttpClient());
    HttpSolrClient delegate = withHttpClientResult.withResponseParser(new BinaryResponseParser())
        .withSocketTimeout(10)
        .build();

    // Act
    (new DelegatingHttpSolrClient(delegate)).optimize(true, true, 3);
  }

  /**
   * Test {@link DelegatingHttpSolrClient#optimize(boolean, boolean, int)} with
   * {@code waitFlush}, {@code waitSearcher}, {@code maxSegments}.
   * <p>
   * Method under test:
   * {@link DelegatingHttpSolrClient#optimize(boolean, boolean, int)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testOptimizeWithWaitFlushWaitSearcherMaxSegments2() throws IOException, SolrServerException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.IllegalArgumentException: Illegal character in path at index 4: Base Solr Url/update
    //       at java.base/java.net.URI.create(URI.java:883)
    //       at org.apache.http.client.methods.HttpPost.<init>(HttpPost.java:73)
    //       at org.apache.solr.client.solrj.impl.HttpSolrClient.fillContentStream(HttpSolrClient.java:484)
    //       at org.apache.solr.client.solrj.impl.HttpSolrClient.createMethod(HttpSolrClient.java:438)
    //       at org.apache.solr.client.solrj.impl.HttpSolrClient.request(HttpSolrClient.java:257)
    //       at org.apache.solr.client.solrj.impl.HttpSolrClient.request(HttpSolrClient.java:248)
    //       at org.apache.solr.client.solrj.SolrRequest.process(SolrRequest.java:225)
    //       at org.apache.solr.client.solrj.SolrClient.optimize(SolrClient.java:675)
    //       at org.apache.solr.client.solrj.SolrClient.optimize(SolrClient.java:696)
    //       at org.broadleafcommerce.core.search.service.solr.DelegatingHttpSolrClient.optimize(DelegatingHttpSolrClient.java:376)
    //   java.net.URISyntaxException: Illegal character in path at index 4: Base Solr Url/update
    //       at java.base/java.net.URI$Parser.fail(URI.java:2913)
    //       at java.base/java.net.URI$Parser.checkChars(URI.java:3084)
    //       at java.base/java.net.URI$Parser.parseHierarchical(URI.java:3166)
    //       at java.base/java.net.URI$Parser.parse(URI.java:3125)
    //       at java.base/java.net.URI.<init>(URI.java:600)
    //       at java.base/java.net.URI.create(URI.java:881)
    //       at org.apache.http.client.methods.HttpPost.<init>(HttpPost.java:73)
    //       at org.apache.solr.client.solrj.impl.HttpSolrClient.fillContentStream(HttpSolrClient.java:484)
    //       at org.apache.solr.client.solrj.impl.HttpSolrClient.createMethod(HttpSolrClient.java:438)
    //       at org.apache.solr.client.solrj.impl.HttpSolrClient.request(HttpSolrClient.java:257)
    //       at org.apache.solr.client.solrj.impl.HttpSolrClient.request(HttpSolrClient.java:248)
    //       at org.apache.solr.client.solrj.SolrRequest.process(SolrRequest.java:225)
    //       at org.apache.solr.client.solrj.SolrClient.optimize(SolrClient.java:675)
    //       at org.apache.solr.client.solrj.SolrClient.optimize(SolrClient.java:696)
    //       at org.broadleafcommerce.core.search.service.solr.DelegatingHttpSolrClient.optimize(DelegatingHttpSolrClient.java:376)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange
    HttpSolrClient.Builder withConnectionTimeoutResult = (new HttpSolrClient.Builder()).withBaseSolrUrl("Base Solr Url")
        .allowCompression(true)
        .withConnectionTimeout(10);
    HttpSolrClient.Builder withHttpClientResult = withConnectionTimeoutResult.withHttpClient(new AutoRetryHttpClient());
    HttpSolrClient delegate = withHttpClientResult.withResponseParser(new BinaryResponseParser())
        .withSocketTimeout(10)
        .build();

    // Act
    (new DelegatingHttpSolrClient(delegate)).optimize(true, true, 3);
  }

  /**
   * Test {@link DelegatingHttpSolrClient#rollback()}.
   * <p>
   * Method under test: {@link DelegatingHttpSolrClient#rollback()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testRollback() throws IOException, SolrServerException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Sandboxing policy violation.
    //   Diffblue Cover ran code in your project that tried
    //     to access the network.
    //   Diffblue Cover's default sandboxing policy disallows this in order to prevent
    //   your code from damaging your system environment.
    //   See https://diff.blue/R011 to resolve this issue.

    // Arrange
    HttpSolrClient.Builder withConnectionTimeoutResult = (new HttpSolrClient.Builder())
        .withBaseSolrUrl("https://example.org/example")
        .allowCompression(true)
        .withConnectionTimeout(10);
    HttpSolrClient.Builder withHttpClientResult = withConnectionTimeoutResult.withHttpClient(new AutoRetryHttpClient());
    HttpSolrClient delegate = withHttpClientResult.withResponseParser(new BinaryResponseParser())
        .withSocketTimeout(10)
        .build();

    // Act
    (new DelegatingHttpSolrClient(delegate)).rollback();
  }

  /**
   * Test {@link DelegatingHttpSolrClient#rollback()}.
   * <p>
   * Method under test: {@link DelegatingHttpSolrClient#rollback()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testRollback2() throws IOException, SolrServerException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.IllegalArgumentException: Illegal character in path at index 4: Base Solr Url/update
    //       at java.base/java.net.URI.create(URI.java:883)
    //       at org.apache.http.client.methods.HttpPost.<init>(HttpPost.java:73)
    //       at org.apache.solr.client.solrj.impl.HttpSolrClient.fillContentStream(HttpSolrClient.java:484)
    //       at org.apache.solr.client.solrj.impl.HttpSolrClient.createMethod(HttpSolrClient.java:438)
    //       at org.apache.solr.client.solrj.impl.HttpSolrClient.request(HttpSolrClient.java:257)
    //       at org.apache.solr.client.solrj.impl.HttpSolrClient.request(HttpSolrClient.java:248)
    //       at org.apache.solr.client.solrj.SolrRequest.process(SolrRequest.java:225)
    //       at org.apache.solr.client.solrj.SolrClient.rollback(SolrClient.java:718)
    //       at org.apache.solr.client.solrj.SolrClient.rollback(SolrClient.java:738)
    //       at org.broadleafcommerce.core.search.service.solr.DelegatingHttpSolrClient.rollback(DelegatingHttpSolrClient.java:394)
    //   java.net.URISyntaxException: Illegal character in path at index 4: Base Solr Url/update
    //       at java.base/java.net.URI$Parser.fail(URI.java:2913)
    //       at java.base/java.net.URI$Parser.checkChars(URI.java:3084)
    //       at java.base/java.net.URI$Parser.parseHierarchical(URI.java:3166)
    //       at java.base/java.net.URI$Parser.parse(URI.java:3125)
    //       at java.base/java.net.URI.<init>(URI.java:600)
    //       at java.base/java.net.URI.create(URI.java:881)
    //       at org.apache.http.client.methods.HttpPost.<init>(HttpPost.java:73)
    //       at org.apache.solr.client.solrj.impl.HttpSolrClient.fillContentStream(HttpSolrClient.java:484)
    //       at org.apache.solr.client.solrj.impl.HttpSolrClient.createMethod(HttpSolrClient.java:438)
    //       at org.apache.solr.client.solrj.impl.HttpSolrClient.request(HttpSolrClient.java:257)
    //       at org.apache.solr.client.solrj.impl.HttpSolrClient.request(HttpSolrClient.java:248)
    //       at org.apache.solr.client.solrj.SolrRequest.process(SolrRequest.java:225)
    //       at org.apache.solr.client.solrj.SolrClient.rollback(SolrClient.java:718)
    //       at org.apache.solr.client.solrj.SolrClient.rollback(SolrClient.java:738)
    //       at org.broadleafcommerce.core.search.service.solr.DelegatingHttpSolrClient.rollback(DelegatingHttpSolrClient.java:394)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange
    HttpSolrClient.Builder withConnectionTimeoutResult = (new HttpSolrClient.Builder()).withBaseSolrUrl("Base Solr Url")
        .allowCompression(true)
        .withConnectionTimeout(10);
    HttpSolrClient.Builder withHttpClientResult = withConnectionTimeoutResult.withHttpClient(new AutoRetryHttpClient());
    HttpSolrClient delegate = withHttpClientResult.withResponseParser(new BinaryResponseParser())
        .withSocketTimeout(10)
        .build();

    // Act
    (new DelegatingHttpSolrClient(delegate)).rollback();
  }

  /**
   * Test {@link DelegatingHttpSolrClient#rollback(String)} with {@code String}.
   * <p>
   * Method under test: {@link DelegatingHttpSolrClient#rollback(String)}
   */
  @Test
  public void testRollbackWithString() throws IOException, SolrServerException {
    // Arrange
    UpdateResponse updateResponse = new UpdateResponse();
    when(delegatingHttpSolrClient.rollback(Mockito.<String>any())).thenReturn(updateResponse);

    // Act
    UpdateResponse actualRollbackResult = delegatingHttpSolrClient.rollback("https://example.org/example");

    // Assert
    verify(delegatingHttpSolrClient).rollback(eq("https://example.org/example"));
    assertSame(updateResponse, actualRollbackResult);
  }

  /**
   * Test {@link DelegatingHttpSolrClient#deleteById(String, String)} with
   * {@code collection}, {@code id}.
   * <p>
   * Method under test:
   * {@link DelegatingHttpSolrClient#deleteById(String, String)}
   */
  @Test
  public void testDeleteByIdWithCollectionId() throws IOException, SolrServerException {
    // Arrange
    UpdateResponse updateResponse = new UpdateResponse();
    when(delegatingHttpSolrClient.deleteById(Mockito.<String>any(), Mockito.<String>any())).thenReturn(updateResponse);

    // Act
    UpdateResponse actualDeleteByIdResult = delegatingHttpSolrClient.deleteById("https://example.org/example",
        "https://example.org/example");

    // Assert
    verify(delegatingHttpSolrClient).deleteById(eq("https://example.org/example"), eq("https://example.org/example"));
    assertSame(updateResponse, actualDeleteByIdResult);
  }

  /**
   * Test {@link DelegatingHttpSolrClient#deleteById(String, String, int)} with
   * {@code collection}, {@code id}, {@code commitWithinMs}.
   * <p>
   * Method under test:
   * {@link DelegatingHttpSolrClient#deleteById(String, String, int)}
   */
  @Test
  public void testDeleteByIdWithCollectionIdCommitWithinMs() throws IOException, SolrServerException {
    // Arrange
    UpdateResponse updateResponse = new UpdateResponse();
    when(delegatingHttpSolrClient.deleteById(Mockito.<String>any(), Mockito.<String>any(), anyInt()))
        .thenReturn(updateResponse);

    // Act
    UpdateResponse actualDeleteByIdResult = delegatingHttpSolrClient.deleteById("https://example.org/example",
        "https://example.org/example", 1);

    // Assert
    verify(delegatingHttpSolrClient).deleteById(eq("https://example.org/example"), eq("https://example.org/example"),
        eq(1));
    assertSame(updateResponse, actualDeleteByIdResult);
  }

  /**
   * Test {@link DelegatingHttpSolrClient#deleteById(String, List, int)} with
   * {@code collection}, {@code ids}, {@code commitWithinMs}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DelegatingHttpSolrClient#deleteById(String, List, int)}
   */
  @Test
  public void testDeleteByIdWithCollectionIdsCommitWithinMs_given42_whenArrayListAdd42()
      throws IOException, SolrServerException {
    // Arrange
    UpdateResponse updateResponse = new UpdateResponse();
    when(delegatingHttpSolrClient.deleteById(Mockito.<String>any(), Mockito.<List<String>>any(), anyInt()))
        .thenReturn(updateResponse);

    ArrayList<String> ids = new ArrayList<>();
    ids.add("42");
    ids.add("foo");

    // Act
    UpdateResponse actualDeleteByIdResult = delegatingHttpSolrClient.deleteById("https://example.org/example", ids, 1);

    // Assert
    verify(delegatingHttpSolrClient).deleteById(eq("https://example.org/example"), isA(List.class), eq(1));
    assertSame(updateResponse, actualDeleteByIdResult);
  }

  /**
   * Test {@link DelegatingHttpSolrClient#deleteById(String, List, int)} with
   * {@code collection}, {@code ids}, {@code commitWithinMs}.
   * <ul>
   *   <li>Given {@code foo}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DelegatingHttpSolrClient#deleteById(String, List, int)}
   */
  @Test
  public void testDeleteByIdWithCollectionIdsCommitWithinMs_givenFoo_whenArrayListAddFoo()
      throws IOException, SolrServerException {
    // Arrange
    UpdateResponse updateResponse = new UpdateResponse();
    when(delegatingHttpSolrClient.deleteById(Mockito.<String>any(), Mockito.<List<String>>any(), anyInt()))
        .thenReturn(updateResponse);

    ArrayList<String> ids = new ArrayList<>();
    ids.add("foo");

    // Act
    UpdateResponse actualDeleteByIdResult = delegatingHttpSolrClient.deleteById("https://example.org/example", ids, 1);

    // Assert
    verify(delegatingHttpSolrClient).deleteById(eq("https://example.org/example"), isA(List.class), eq(1));
    assertSame(updateResponse, actualDeleteByIdResult);
  }

  /**
   * Test {@link DelegatingHttpSolrClient#deleteById(String, List, int)} with
   * {@code collection}, {@code ids}, {@code commitWithinMs}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DelegatingHttpSolrClient#deleteById(String, List, int)}
   */
  @Test
  public void testDeleteByIdWithCollectionIdsCommitWithinMs_whenArrayList() throws IOException, SolrServerException {
    // Arrange
    UpdateResponse updateResponse = new UpdateResponse();
    when(delegatingHttpSolrClient.deleteById(Mockito.<String>any(), Mockito.<List<String>>any(), anyInt()))
        .thenReturn(updateResponse);

    // Act
    UpdateResponse actualDeleteByIdResult = delegatingHttpSolrClient.deleteById("https://example.org/example",
        new ArrayList<>(), 1);

    // Assert
    verify(delegatingHttpSolrClient).deleteById(eq("https://example.org/example"), isA(List.class), eq(1));
    assertSame(updateResponse, actualDeleteByIdResult);
  }

  /**
   * Test {@link DelegatingHttpSolrClient#deleteById(String, List)} with
   * {@code collection}, {@code ids}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DelegatingHttpSolrClient#deleteById(String, List)}
   */
  @Test
  public void testDeleteByIdWithCollectionIds_given42_whenArrayListAdd42() throws IOException, SolrServerException {
    // Arrange
    UpdateResponse updateResponse = new UpdateResponse();
    when(delegatingHttpSolrClient.deleteById(Mockito.<String>any(), Mockito.<List<String>>any()))
        .thenReturn(updateResponse);

    ArrayList<String> ids = new ArrayList<>();
    ids.add("42");
    ids.add("foo");

    // Act
    UpdateResponse actualDeleteByIdResult = delegatingHttpSolrClient.deleteById("https://example.org/example", ids);

    // Assert
    verify(delegatingHttpSolrClient).deleteById(eq("https://example.org/example"), isA(List.class));
    assertSame(updateResponse, actualDeleteByIdResult);
  }

  /**
   * Test {@link DelegatingHttpSolrClient#deleteById(String, List)} with
   * {@code collection}, {@code ids}.
   * <ul>
   *   <li>Given {@code foo}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DelegatingHttpSolrClient#deleteById(String, List)}
   */
  @Test
  public void testDeleteByIdWithCollectionIds_givenFoo_whenArrayListAddFoo() throws IOException, SolrServerException {
    // Arrange
    UpdateResponse updateResponse = new UpdateResponse();
    when(delegatingHttpSolrClient.deleteById(Mockito.<String>any(), Mockito.<List<String>>any()))
        .thenReturn(updateResponse);

    ArrayList<String> ids = new ArrayList<>();
    ids.add("foo");

    // Act
    UpdateResponse actualDeleteByIdResult = delegatingHttpSolrClient.deleteById("https://example.org/example", ids);

    // Assert
    verify(delegatingHttpSolrClient).deleteById(eq("https://example.org/example"), isA(List.class));
    assertSame(updateResponse, actualDeleteByIdResult);
  }

  /**
   * Test {@link DelegatingHttpSolrClient#deleteById(String, List)} with
   * {@code collection}, {@code ids}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DelegatingHttpSolrClient#deleteById(String, List)}
   */
  @Test
  public void testDeleteByIdWithCollectionIds_whenArrayList() throws IOException, SolrServerException {
    // Arrange
    UpdateResponse updateResponse = new UpdateResponse();
    when(delegatingHttpSolrClient.deleteById(Mockito.<String>any(), Mockito.<List<String>>any()))
        .thenReturn(updateResponse);

    // Act
    UpdateResponse actualDeleteByIdResult = delegatingHttpSolrClient.deleteById("https://example.org/example",
        new ArrayList<>());

    // Assert
    verify(delegatingHttpSolrClient).deleteById(eq("https://example.org/example"), isA(List.class));
    assertSame(updateResponse, actualDeleteByIdResult);
  }

  /**
   * Test {@link DelegatingHttpSolrClient#deleteById(String)} with {@code id}.
   * <p>
   * Method under test: {@link DelegatingHttpSolrClient#deleteById(String)}
   */
  @Test
  public void testDeleteByIdWithId() throws IOException, SolrServerException {
    // Arrange
    UpdateResponse updateResponse = new UpdateResponse();
    when(delegatingHttpSolrClient.deleteById(Mockito.<String>any())).thenReturn(updateResponse);

    // Act
    UpdateResponse actualDeleteByIdResult = delegatingHttpSolrClient.deleteById("https://example.org/example");

    // Assert
    verify(delegatingHttpSolrClient).deleteById(eq("https://example.org/example"));
    assertSame(updateResponse, actualDeleteByIdResult);
  }

  /**
   * Test {@link DelegatingHttpSolrClient#deleteById(String, int)} with
   * {@code id}, {@code commitWithinMs}.
   * <p>
   * Method under test: {@link DelegatingHttpSolrClient#deleteById(String, int)}
   */
  @Test
  public void testDeleteByIdWithIdCommitWithinMs() throws IOException, SolrServerException {
    // Arrange
    UpdateResponse updateResponse = new UpdateResponse();
    when(delegatingHttpSolrClient.deleteById(Mockito.<String>any(), anyInt())).thenReturn(updateResponse);

    // Act
    UpdateResponse actualDeleteByIdResult = delegatingHttpSolrClient.deleteById("https://example.org/example", 1);

    // Assert
    verify(delegatingHttpSolrClient).deleteById(eq("https://example.org/example"), eq(1));
    assertSame(updateResponse, actualDeleteByIdResult);
  }

  /**
   * Test {@link DelegatingHttpSolrClient#deleteById(List, int)} with {@code ids},
   * {@code commitWithinMs}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DelegatingHttpSolrClient#deleteById(List, int)}
   */
  @Test
  public void testDeleteByIdWithIdsCommitWithinMs_given42_whenArrayListAdd42() throws IOException, SolrServerException {
    // Arrange
    UpdateResponse updateResponse = new UpdateResponse();
    when(delegatingHttpSolrClient.deleteById(Mockito.<List<String>>any(), anyInt())).thenReturn(updateResponse);

    ArrayList<String> ids = new ArrayList<>();
    ids.add("42");
    ids.add("foo");

    // Act
    UpdateResponse actualDeleteByIdResult = delegatingHttpSolrClient.deleteById(ids, 1);

    // Assert
    verify(delegatingHttpSolrClient).deleteById(isA(List.class), eq(1));
    assertSame(updateResponse, actualDeleteByIdResult);
  }

  /**
   * Test {@link DelegatingHttpSolrClient#deleteById(List, int)} with {@code ids},
   * {@code commitWithinMs}.
   * <ul>
   *   <li>Given {@code foo}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DelegatingHttpSolrClient#deleteById(List, int)}
   */
  @Test
  public void testDeleteByIdWithIdsCommitWithinMs_givenFoo_whenArrayListAddFoo()
      throws IOException, SolrServerException {
    // Arrange
    UpdateResponse updateResponse = new UpdateResponse();
    when(delegatingHttpSolrClient.deleteById(Mockito.<List<String>>any(), anyInt())).thenReturn(updateResponse);

    ArrayList<String> ids = new ArrayList<>();
    ids.add("foo");

    // Act
    UpdateResponse actualDeleteByIdResult = delegatingHttpSolrClient.deleteById(ids, 1);

    // Assert
    verify(delegatingHttpSolrClient).deleteById(isA(List.class), eq(1));
    assertSame(updateResponse, actualDeleteByIdResult);
  }

  /**
   * Test {@link DelegatingHttpSolrClient#deleteById(List, int)} with {@code ids},
   * {@code commitWithinMs}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DelegatingHttpSolrClient#deleteById(List, int)}
   */
  @Test
  public void testDeleteByIdWithIdsCommitWithinMs_whenArrayList() throws IOException, SolrServerException {
    // Arrange
    UpdateResponse updateResponse = new UpdateResponse();
    when(delegatingHttpSolrClient.deleteById(Mockito.<List<String>>any(), anyInt())).thenReturn(updateResponse);

    // Act
    UpdateResponse actualDeleteByIdResult = delegatingHttpSolrClient.deleteById(new ArrayList<>(), 1);

    // Assert
    verify(delegatingHttpSolrClient).deleteById(isA(List.class), eq(1));
    assertSame(updateResponse, actualDeleteByIdResult);
  }

  /**
   * Test {@link DelegatingHttpSolrClient#deleteById(List)} with {@code ids}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DelegatingHttpSolrClient#deleteById(List)}
   */
  @Test
  public void testDeleteByIdWithIds_given42_whenArrayListAdd42() throws IOException, SolrServerException {
    // Arrange
    UpdateResponse updateResponse = new UpdateResponse();
    when(delegatingHttpSolrClient.deleteById(Mockito.<List<String>>any())).thenReturn(updateResponse);

    ArrayList<String> ids = new ArrayList<>();
    ids.add("42");
    ids.add("foo");

    // Act
    UpdateResponse actualDeleteByIdResult = delegatingHttpSolrClient.deleteById(ids);

    // Assert
    verify(delegatingHttpSolrClient).deleteById(isA(List.class));
    assertSame(updateResponse, actualDeleteByIdResult);
  }

  /**
   * Test {@link DelegatingHttpSolrClient#deleteById(List)} with {@code ids}.
   * <ul>
   *   <li>Given {@code foo}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DelegatingHttpSolrClient#deleteById(List)}
   */
  @Test
  public void testDeleteByIdWithIds_givenFoo_whenArrayListAddFoo() throws IOException, SolrServerException {
    // Arrange
    UpdateResponse updateResponse = new UpdateResponse();
    when(delegatingHttpSolrClient.deleteById(Mockito.<List<String>>any())).thenReturn(updateResponse);

    ArrayList<String> ids = new ArrayList<>();
    ids.add("foo");

    // Act
    UpdateResponse actualDeleteByIdResult = delegatingHttpSolrClient.deleteById(ids);

    // Assert
    verify(delegatingHttpSolrClient).deleteById(isA(List.class));
    assertSame(updateResponse, actualDeleteByIdResult);
  }

  /**
   * Test {@link DelegatingHttpSolrClient#deleteById(List)} with {@code ids}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DelegatingHttpSolrClient#deleteById(List)}
   */
  @Test
  public void testDeleteByIdWithIds_whenArrayList() throws IOException, SolrServerException {
    // Arrange
    UpdateResponse updateResponse = new UpdateResponse();
    when(delegatingHttpSolrClient.deleteById(Mockito.<List<String>>any())).thenReturn(updateResponse);

    // Act
    UpdateResponse actualDeleteByIdResult = delegatingHttpSolrClient.deleteById(new ArrayList<>());

    // Assert
    verify(delegatingHttpSolrClient).deleteById(isA(List.class));
    assertSame(updateResponse, actualDeleteByIdResult);
  }

  /**
   * Test {@link DelegatingHttpSolrClient#deleteByQuery(String, String)} with
   * {@code collection}, {@code query}.
   * <p>
   * Method under test:
   * {@link DelegatingHttpSolrClient#deleteByQuery(String, String)}
   */
  @Test
  public void testDeleteByQueryWithCollectionQuery() throws IOException, SolrServerException {
    // Arrange
    UpdateResponse updateResponse = new UpdateResponse();
    when(delegatingHttpSolrClient.deleteByQuery(Mockito.<String>any(), Mockito.<String>any()))
        .thenReturn(updateResponse);

    // Act
    UpdateResponse actualDeleteByQueryResult = delegatingHttpSolrClient.deleteByQuery("https://example.org/example",
        "https://example.org/example");

    // Assert
    verify(delegatingHttpSolrClient).deleteByQuery(eq("https://example.org/example"),
        eq("https://example.org/example"));
    assertSame(updateResponse, actualDeleteByQueryResult);
  }

  /**
   * Test {@link DelegatingHttpSolrClient#deleteByQuery(String, String, int)} with
   * {@code collection}, {@code query}, {@code commitWithinMs}.
   * <p>
   * Method under test:
   * {@link DelegatingHttpSolrClient#deleteByQuery(String, String, int)}
   */
  @Test
  public void testDeleteByQueryWithCollectionQueryCommitWithinMs() throws IOException, SolrServerException {
    // Arrange
    UpdateResponse updateResponse = new UpdateResponse();
    when(delegatingHttpSolrClient.deleteByQuery(Mockito.<String>any(), Mockito.<String>any(), anyInt()))
        .thenReturn(updateResponse);

    // Act
    UpdateResponse actualDeleteByQueryResult = delegatingHttpSolrClient.deleteByQuery("https://example.org/example",
        "https://example.org/example", 1);

    // Assert
    verify(delegatingHttpSolrClient).deleteByQuery(eq("https://example.org/example"), eq("https://example.org/example"),
        eq(1));
    assertSame(updateResponse, actualDeleteByQueryResult);
  }

  /**
   * Test {@link DelegatingHttpSolrClient#deleteByQuery(String)} with
   * {@code query}.
   * <p>
   * Method under test: {@link DelegatingHttpSolrClient#deleteByQuery(String)}
   */
  @Test
  public void testDeleteByQueryWithQuery() throws IOException, SolrServerException {
    // Arrange
    UpdateResponse updateResponse = new UpdateResponse();
    when(delegatingHttpSolrClient.deleteByQuery(Mockito.<String>any())).thenReturn(updateResponse);

    // Act
    UpdateResponse actualDeleteByQueryResult = delegatingHttpSolrClient.deleteByQuery("https://example.org/example");

    // Assert
    verify(delegatingHttpSolrClient).deleteByQuery(eq("https://example.org/example"));
    assertSame(updateResponse, actualDeleteByQueryResult);
  }

  /**
   * Test {@link DelegatingHttpSolrClient#deleteByQuery(String, int)} with
   * {@code query}, {@code commitWithinMs}.
   * <p>
   * Method under test:
   * {@link DelegatingHttpSolrClient#deleteByQuery(String, int)}
   */
  @Test
  public void testDeleteByQueryWithQueryCommitWithinMs() throws IOException, SolrServerException {
    // Arrange
    UpdateResponse updateResponse = new UpdateResponse();
    when(delegatingHttpSolrClient.deleteByQuery(Mockito.<String>any(), anyInt())).thenReturn(updateResponse);

    // Act
    UpdateResponse actualDeleteByQueryResult = delegatingHttpSolrClient.deleteByQuery("https://example.org/example", 1);

    // Assert
    verify(delegatingHttpSolrClient).deleteByQuery(eq("https://example.org/example"), eq(1));
    assertSame(updateResponse, actualDeleteByQueryResult);
  }

  /**
   * Test {@link DelegatingHttpSolrClient#ping()}.
   * <p>
   * Method under test: {@link DelegatingHttpSolrClient#ping()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testPing() throws IOException, SolrServerException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Sandboxing policy violation.
    //   Diffblue Cover ran code in your project that tried
    //     to access the network.
    //   Diffblue Cover's default sandboxing policy disallows this in order to prevent
    //   your code from damaging your system environment.
    //   See https://diff.blue/R011 to resolve this issue.

    // Arrange
    HttpSolrClient.Builder withConnectionTimeoutResult = (new HttpSolrClient.Builder())
        .withBaseSolrUrl("https://example.org/example")
        .allowCompression(true)
        .withConnectionTimeout(10);
    HttpSolrClient.Builder withHttpClientResult = withConnectionTimeoutResult.withHttpClient(new AutoRetryHttpClient());
    HttpSolrClient delegate = withHttpClientResult.withResponseParser(new BinaryResponseParser())
        .withSocketTimeout(10)
        .build();

    // Act
    (new DelegatingHttpSolrClient(delegate)).ping();
  }

  /**
   * Test {@link DelegatingHttpSolrClient#ping()}.
   * <p>
   * Method under test: {@link DelegatingHttpSolrClient#ping()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testPing2() throws IOException, SolrServerException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.IllegalArgumentException: Illegal character in path at index 4: Base Solr Url/admin/ping?wt=javabin&version=2
    //       at java.base/java.net.URI.create(URI.java:883)
    //       at org.apache.http.client.methods.HttpGet.<init>(HttpGet.java:66)
    //       at org.apache.solr.client.solrj.impl.HttpSolrClient.createMethod(HttpSolrClient.java:390)
    //       at org.apache.solr.client.solrj.impl.HttpSolrClient.request(HttpSolrClient.java:257)
    //       at org.apache.solr.client.solrj.impl.HttpSolrClient.request(HttpSolrClient.java:248)
    //       at org.apache.solr.client.solrj.SolrRequest.process(SolrRequest.java:225)
    //       at org.apache.solr.client.solrj.SolrClient.ping(SolrClient.java:986)
    //       at org.broadleafcommerce.core.search.service.solr.DelegatingHttpSolrClient.ping(DelegatingHttpSolrClient.java:510)
    //   java.net.URISyntaxException: Illegal character in path at index 4: Base Solr Url/admin/ping?wt=javabin&version=2
    //       at java.base/java.net.URI$Parser.fail(URI.java:2913)
    //       at java.base/java.net.URI$Parser.checkChars(URI.java:3084)
    //       at java.base/java.net.URI$Parser.parseHierarchical(URI.java:3166)
    //       at java.base/java.net.URI$Parser.parse(URI.java:3125)
    //       at java.base/java.net.URI.<init>(URI.java:600)
    //       at java.base/java.net.URI.create(URI.java:881)
    //       at org.apache.http.client.methods.HttpGet.<init>(HttpGet.java:66)
    //       at org.apache.solr.client.solrj.impl.HttpSolrClient.createMethod(HttpSolrClient.java:390)
    //       at org.apache.solr.client.solrj.impl.HttpSolrClient.request(HttpSolrClient.java:257)
    //       at org.apache.solr.client.solrj.impl.HttpSolrClient.request(HttpSolrClient.java:248)
    //       at org.apache.solr.client.solrj.SolrRequest.process(SolrRequest.java:225)
    //       at org.apache.solr.client.solrj.SolrClient.ping(SolrClient.java:986)
    //       at org.broadleafcommerce.core.search.service.solr.DelegatingHttpSolrClient.ping(DelegatingHttpSolrClient.java:510)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange
    HttpSolrClient.Builder withConnectionTimeoutResult = (new HttpSolrClient.Builder()).withBaseSolrUrl("Base Solr Url")
        .allowCompression(true)
        .withConnectionTimeout(10);
    HttpSolrClient.Builder withHttpClientResult = withConnectionTimeoutResult.withHttpClient(new AutoRetryHttpClient());
    HttpSolrClient delegate = withHttpClientResult.withResponseParser(new BinaryResponseParser())
        .withSocketTimeout(10)
        .build();

    // Act
    (new DelegatingHttpSolrClient(delegate)).ping();
  }

  /**
   * Test {@link DelegatingHttpSolrClient#query(String, SolrParams)} with
   * {@code collection}, {@code params}.
   * <p>
   * Method under test: {@link DelegatingHttpSolrClient#query(String, SolrParams)}
   */
  @Test
  public void testQueryWithCollectionParams() throws IOException, SolrServerException {
    // Arrange
    QueryResponse queryResponse = new QueryResponse();
    when(delegatingHttpSolrClient.query(Mockito.<String>any(), Mockito.<SolrParams>any())).thenReturn(queryResponse);

    // Act
    QueryResponse actualQueryResult = delegatingHttpSolrClient.query("https://example.org/example",
        new SolrQuery("foo"));

    // Assert
    verify(delegatingHttpSolrClient).query(eq("https://example.org/example"), isA(SolrParams.class));
    assertSame(queryResponse, actualQueryResult);
  }

  /**
   * Test {@link DelegatingHttpSolrClient#query(String, SolrParams, METHOD)} with
   * {@code collection}, {@code params}, {@code method}.
   * <p>
   * Method under test:
   * {@link DelegatingHttpSolrClient#query(String, SolrParams, SolrRequest.METHOD)}
   */
  @Test
  public void testQueryWithCollectionParamsMethod() throws IOException, SolrServerException {
    // Arrange
    QueryResponse queryResponse = new QueryResponse();
    when(delegatingHttpSolrClient.query(Mockito.<String>any(), Mockito.<SolrParams>any(),
        Mockito.<SolrRequest.METHOD>any())).thenReturn(queryResponse);

    // Act
    QueryResponse actualQueryResult = delegatingHttpSolrClient.query("https://example.org/example",
        new SolrQuery("foo"), SolrRequest.METHOD.GET);

    // Assert
    verify(delegatingHttpSolrClient).query(eq("https://example.org/example"), isA(SolrParams.class),
        eq(SolrRequest.METHOD.GET));
    assertSame(queryResponse, actualQueryResult);
  }

  /**
   * Test {@link DelegatingHttpSolrClient#query(SolrParams)} with {@code params}.
   * <p>
   * Method under test: {@link DelegatingHttpSolrClient#query(SolrParams)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testQueryWithParams() throws IOException, SolrServerException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Sandboxing policy violation.
    //   Diffblue Cover ran code in your project that tried
    //     to access the network.
    //   Diffblue Cover's default sandboxing policy disallows this in order to prevent
    //   your code from damaging your system environment.
    //   See https://diff.blue/R011 to resolve this issue.

    // Arrange
    HttpSolrClient.Builder withConnectionTimeoutResult = (new HttpSolrClient.Builder())
        .withBaseSolrUrl("https://example.org/example")
        .allowCompression(true)
        .withConnectionTimeout(10);
    HttpSolrClient.Builder withHttpClientResult = withConnectionTimeoutResult.withHttpClient(new AutoRetryHttpClient());
    HttpSolrClient delegate = withHttpClientResult.withResponseParser(new BinaryResponseParser())
        .withSocketTimeout(10)
        .build();
    DelegatingHttpSolrClient delegatingHttpSolrClient = new DelegatingHttpSolrClient(delegate);

    // Act
    delegatingHttpSolrClient.query(new SolrQuery("foo"));
  }

  /**
   * Test {@link DelegatingHttpSolrClient#query(SolrParams)} with {@code params}.
   * <p>
   * Method under test: {@link DelegatingHttpSolrClient#query(SolrParams)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testQueryWithParams2() throws IOException, SolrServerException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.IllegalArgumentException: Illegal character in path at index 4: Base Solr Url/select?q=foo&wt=javabin&version=2
    //       at java.base/java.net.URI.create(URI.java:883)
    //       at org.apache.http.client.methods.HttpGet.<init>(HttpGet.java:66)
    //       at org.apache.solr.client.solrj.impl.HttpSolrClient.createMethod(HttpSolrClient.java:390)
    //       at org.apache.solr.client.solrj.impl.HttpSolrClient.request(HttpSolrClient.java:257)
    //       at org.apache.solr.client.solrj.impl.HttpSolrClient.request(HttpSolrClient.java:248)
    //       at org.apache.solr.client.solrj.SolrRequest.process(SolrRequest.java:225)
    //       at org.apache.solr.client.solrj.SolrClient.query(SolrClient.java:1003)
    //       at org.apache.solr.client.solrj.SolrClient.query(SolrClient.java:1018)
    //       at org.broadleafcommerce.core.search.service.solr.DelegatingHttpSolrClient.query(DelegatingHttpSolrClient.java:525)
    //   java.net.URISyntaxException: Illegal character in path at index 4: Base Solr Url/select?q=foo&wt=javabin&version=2
    //       at java.base/java.net.URI$Parser.fail(URI.java:2913)
    //       at java.base/java.net.URI$Parser.checkChars(URI.java:3084)
    //       at java.base/java.net.URI$Parser.parseHierarchical(URI.java:3166)
    //       at java.base/java.net.URI$Parser.parse(URI.java:3125)
    //       at java.base/java.net.URI.<init>(URI.java:600)
    //       at java.base/java.net.URI.create(URI.java:881)
    //       at org.apache.http.client.methods.HttpGet.<init>(HttpGet.java:66)
    //       at org.apache.solr.client.solrj.impl.HttpSolrClient.createMethod(HttpSolrClient.java:390)
    //       at org.apache.solr.client.solrj.impl.HttpSolrClient.request(HttpSolrClient.java:257)
    //       at org.apache.solr.client.solrj.impl.HttpSolrClient.request(HttpSolrClient.java:248)
    //       at org.apache.solr.client.solrj.SolrRequest.process(SolrRequest.java:225)
    //       at org.apache.solr.client.solrj.SolrClient.query(SolrClient.java:1003)
    //       at org.apache.solr.client.solrj.SolrClient.query(SolrClient.java:1018)
    //       at org.broadleafcommerce.core.search.service.solr.DelegatingHttpSolrClient.query(DelegatingHttpSolrClient.java:525)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange
    HttpSolrClient.Builder withConnectionTimeoutResult = (new HttpSolrClient.Builder()).withBaseSolrUrl("Base Solr Url")
        .allowCompression(true)
        .withConnectionTimeout(10);
    HttpSolrClient.Builder withHttpClientResult = withConnectionTimeoutResult.withHttpClient(new AutoRetryHttpClient());
    HttpSolrClient delegate = withHttpClientResult.withResponseParser(new BinaryResponseParser())
        .withSocketTimeout(10)
        .build();
    DelegatingHttpSolrClient delegatingHttpSolrClient = new DelegatingHttpSolrClient(delegate);

    // Act
    delegatingHttpSolrClient.query(new SolrQuery("foo"));
  }

  /**
   * Test {@link DelegatingHttpSolrClient#query(SolrParams, METHOD)} with
   * {@code params}, {@code method}.
   * <p>
   * Method under test:
   * {@link DelegatingHttpSolrClient#query(SolrParams, SolrRequest.METHOD)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testQueryWithParamsMethod() throws IOException, SolrServerException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Sandboxing policy violation.
    //   Diffblue Cover ran code in your project that tried
    //     to access the network.
    //   Diffblue Cover's default sandboxing policy disallows this in order to prevent
    //   your code from damaging your system environment.
    //   See https://diff.blue/R011 to resolve this issue.

    // Arrange
    HttpSolrClient.Builder withConnectionTimeoutResult = (new HttpSolrClient.Builder())
        .withBaseSolrUrl("https://example.org/example")
        .allowCompression(true)
        .withConnectionTimeout(10);
    HttpSolrClient.Builder withHttpClientResult = withConnectionTimeoutResult.withHttpClient(new AutoRetryHttpClient());
    HttpSolrClient delegate = withHttpClientResult.withResponseParser(new BinaryResponseParser())
        .withSocketTimeout(10)
        .build();
    DelegatingHttpSolrClient delegatingHttpSolrClient = new DelegatingHttpSolrClient(delegate);

    // Act
    delegatingHttpSolrClient.query(new SolrQuery("foo"), SolrRequest.METHOD.GET);
  }

  /**
   * Test {@link DelegatingHttpSolrClient#query(SolrParams, METHOD)} with
   * {@code params}, {@code method}.
   * <p>
   * Method under test:
   * {@link DelegatingHttpSolrClient#query(SolrParams, SolrRequest.METHOD)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testQueryWithParamsMethod2() throws IOException, SolrServerException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.IllegalArgumentException: Illegal character in path at index 4: Base Solr Url/select?q=foo&wt=javabin&version=2
    //       at java.base/java.net.URI.create(URI.java:883)
    //       at org.apache.http.client.methods.HttpGet.<init>(HttpGet.java:66)
    //       at org.apache.solr.client.solrj.impl.HttpSolrClient.createMethod(HttpSolrClient.java:390)
    //       at org.apache.solr.client.solrj.impl.HttpSolrClient.request(HttpSolrClient.java:257)
    //       at org.apache.solr.client.solrj.impl.HttpSolrClient.request(HttpSolrClient.java:248)
    //       at org.apache.solr.client.solrj.SolrRequest.process(SolrRequest.java:225)
    //       at org.apache.solr.client.solrj.SolrClient.query(SolrClient.java:1035)
    //       at org.apache.solr.client.solrj.SolrClient.query(SolrClient.java:1051)
    //       at org.broadleafcommerce.core.search.service.solr.DelegatingHttpSolrClient.query(DelegatingHttpSolrClient.java:543)
    //   java.net.URISyntaxException: Illegal character in path at index 4: Base Solr Url/select?q=foo&wt=javabin&version=2
    //       at java.base/java.net.URI$Parser.fail(URI.java:2913)
    //       at java.base/java.net.URI$Parser.checkChars(URI.java:3084)
    //       at java.base/java.net.URI$Parser.parseHierarchical(URI.java:3166)
    //       at java.base/java.net.URI$Parser.parse(URI.java:3125)
    //       at java.base/java.net.URI.<init>(URI.java:600)
    //       at java.base/java.net.URI.create(URI.java:881)
    //       at org.apache.http.client.methods.HttpGet.<init>(HttpGet.java:66)
    //       at org.apache.solr.client.solrj.impl.HttpSolrClient.createMethod(HttpSolrClient.java:390)
    //       at org.apache.solr.client.solrj.impl.HttpSolrClient.request(HttpSolrClient.java:257)
    //       at org.apache.solr.client.solrj.impl.HttpSolrClient.request(HttpSolrClient.java:248)
    //       at org.apache.solr.client.solrj.SolrRequest.process(SolrRequest.java:225)
    //       at org.apache.solr.client.solrj.SolrClient.query(SolrClient.java:1035)
    //       at org.apache.solr.client.solrj.SolrClient.query(SolrClient.java:1051)
    //       at org.broadleafcommerce.core.search.service.solr.DelegatingHttpSolrClient.query(DelegatingHttpSolrClient.java:543)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange
    HttpSolrClient.Builder withConnectionTimeoutResult = (new HttpSolrClient.Builder()).withBaseSolrUrl("Base Solr Url")
        .allowCompression(true)
        .withConnectionTimeout(10);
    HttpSolrClient.Builder withHttpClientResult = withConnectionTimeoutResult.withHttpClient(new AutoRetryHttpClient());
    HttpSolrClient delegate = withHttpClientResult.withResponseParser(new BinaryResponseParser())
        .withSocketTimeout(10)
        .build();
    DelegatingHttpSolrClient delegatingHttpSolrClient = new DelegatingHttpSolrClient(delegate);

    // Act
    delegatingHttpSolrClient.query(new SolrQuery("foo"), SolrRequest.METHOD.GET);
  }

  /**
   * Test
   * {@link DelegatingHttpSolrClient#queryAndStreamResponse(SolrParams, StreamingResponseCallback)}
   * with {@code SolrParams}, {@code StreamingResponseCallback}.
   * <p>
   * Method under test:
   * {@link DelegatingHttpSolrClient#queryAndStreamResponse(SolrParams, StreamingResponseCallback)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testQueryAndStreamResponseWithSolrParamsStreamingResponseCallback()
      throws IOException, SolrServerException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Sandboxing policy violation.
    //   Diffblue Cover ran code in your project that tried
    //     to access the network.
    //   Diffblue Cover's default sandboxing policy disallows this in order to prevent
    //   your code from damaging your system environment.
    //   See https://diff.blue/R011 to resolve this issue.

    // Arrange
    HttpSolrClient.Builder withConnectionTimeoutResult = (new HttpSolrClient.Builder())
        .withBaseSolrUrl("https://example.org/example")
        .allowCompression(true)
        .withConnectionTimeout(10);
    HttpSolrClient.Builder withHttpClientResult = withConnectionTimeoutResult.withHttpClient(new AutoRetryHttpClient());
    HttpSolrClient delegate = withHttpClientResult.withResponseParser(new BinaryResponseParser())
        .withSocketTimeout(10)
        .build();
    DelegatingHttpSolrClient delegatingHttpSolrClient = new DelegatingHttpSolrClient(delegate);

    // Act
    delegatingHttpSolrClient.queryAndStreamResponse(new SolrQuery("foo"), mock(StreamingResponseCallback.class));
  }

  /**
   * Test
   * {@link DelegatingHttpSolrClient#queryAndStreamResponse(SolrParams, StreamingResponseCallback)}
   * with {@code SolrParams}, {@code StreamingResponseCallback}.
   * <p>
   * Method under test:
   * {@link DelegatingHttpSolrClient#queryAndStreamResponse(SolrParams, StreamingResponseCallback)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testQueryAndStreamResponseWithSolrParamsStreamingResponseCallback2()
      throws IOException, SolrServerException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.IllegalArgumentException: Illegal character in path at index 4: Base Solr Url/select?q=foo&wt=javabin&version=2
    //       at java.base/java.net.URI.create(URI.java:883)
    //       at org.apache.http.client.methods.HttpGet.<init>(HttpGet.java:66)
    //       at org.apache.solr.client.solrj.impl.HttpSolrClient.createMethod(HttpSolrClient.java:390)
    //       at org.apache.solr.client.solrj.impl.HttpSolrClient.request(HttpSolrClient.java:257)
    //       at org.apache.solr.client.solrj.impl.HttpSolrClient.request(HttpSolrClient.java:248)
    //       at org.apache.solr.client.solrj.SolrRequest.process(SolrRequest.java:225)
    //       at org.apache.solr.client.solrj.SolrClient.getQueryResponse(SolrClient.java:1091)
    //       at org.apache.solr.client.solrj.SolrClient.queryAndStreamResponse(SolrClient.java:1077)
    //       at org.apache.solr.client.solrj.SolrClient.queryAndStreamResponse(SolrClient.java:1116)
    //       at org.broadleafcommerce.core.search.service.solr.DelegatingHttpSolrClient.queryAndStreamResponse(DelegatingHttpSolrClient.java:561)
    //   java.net.URISyntaxException: Illegal character in path at index 4: Base Solr Url/select?q=foo&wt=javabin&version=2
    //       at java.base/java.net.URI$Parser.fail(URI.java:2913)
    //       at java.base/java.net.URI$Parser.checkChars(URI.java:3084)
    //       at java.base/java.net.URI$Parser.parseHierarchical(URI.java:3166)
    //       at java.base/java.net.URI$Parser.parse(URI.java:3125)
    //       at java.base/java.net.URI.<init>(URI.java:600)
    //       at java.base/java.net.URI.create(URI.java:881)
    //       at org.apache.http.client.methods.HttpGet.<init>(HttpGet.java:66)
    //       at org.apache.solr.client.solrj.impl.HttpSolrClient.createMethod(HttpSolrClient.java:390)
    //       at org.apache.solr.client.solrj.impl.HttpSolrClient.request(HttpSolrClient.java:257)
    //       at org.apache.solr.client.solrj.impl.HttpSolrClient.request(HttpSolrClient.java:248)
    //       at org.apache.solr.client.solrj.SolrRequest.process(SolrRequest.java:225)
    //       at org.apache.solr.client.solrj.SolrClient.getQueryResponse(SolrClient.java:1091)
    //       at org.apache.solr.client.solrj.SolrClient.queryAndStreamResponse(SolrClient.java:1077)
    //       at org.apache.solr.client.solrj.SolrClient.queryAndStreamResponse(SolrClient.java:1116)
    //       at org.broadleafcommerce.core.search.service.solr.DelegatingHttpSolrClient.queryAndStreamResponse(DelegatingHttpSolrClient.java:561)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange
    HttpSolrClient.Builder withConnectionTimeoutResult = (new HttpSolrClient.Builder()).withBaseSolrUrl("Base Solr Url")
        .allowCompression(true)
        .withConnectionTimeout(10);
    HttpSolrClient.Builder withHttpClientResult = withConnectionTimeoutResult.withHttpClient(new AutoRetryHttpClient());
    HttpSolrClient delegate = withHttpClientResult.withResponseParser(new BinaryResponseParser())
        .withSocketTimeout(10)
        .build();
    DelegatingHttpSolrClient delegatingHttpSolrClient = new DelegatingHttpSolrClient(delegate);

    // Act
    delegatingHttpSolrClient.queryAndStreamResponse(new SolrQuery("foo"), mock(StreamingResponseCallback.class));
  }

  /**
   * Test
   * {@link DelegatingHttpSolrClient#queryAndStreamResponse(String, SolrParams, StreamingResponseCallback)}
   * with {@code String}, {@code SolrParams}, {@code StreamingResponseCallback}.
   * <p>
   * Method under test:
   * {@link DelegatingHttpSolrClient#queryAndStreamResponse(String, SolrParams, StreamingResponseCallback)}
   */
  @Test
  public void testQueryAndStreamResponseWithStringSolrParamsStreamingResponseCallback()
      throws IOException, SolrServerException {
    // Arrange
    QueryResponse queryResponse = new QueryResponse();
    when(delegatingHttpSolrClient.queryAndStreamResponse(Mockito.<String>any(), Mockito.<SolrParams>any(),
        Mockito.<StreamingResponseCallback>any())).thenReturn(queryResponse);

    // Act
    QueryResponse actualQueryAndStreamResponseResult = delegatingHttpSolrClient
        .queryAndStreamResponse("https://example.org/example", new SolrQuery("foo"), (StreamingResponseCallback) null);

    // Assert
    verify(delegatingHttpSolrClient).queryAndStreamResponse(eq("https://example.org/example"), isA(SolrParams.class),
        (StreamingResponseCallback) isNull());
    assertSame(queryResponse, actualQueryAndStreamResponseResult);
  }

  /**
   * Test {@link DelegatingHttpSolrClient#getById(String, String)} with
   * {@code collection}, {@code id}.
   * <p>
   * Method under test: {@link DelegatingHttpSolrClient#getById(String, String)}
   */
  @Test
  public void testGetByIdWithCollectionId() throws IOException, SolrServerException {
    // Arrange
    SolrDocument solrDocument = new SolrDocument();
    when(delegatingHttpSolrClient.getById(Mockito.<String>any(), Mockito.<String>any())).thenReturn(solrDocument);

    // Act
    SolrDocument actualById = delegatingHttpSolrClient.getById("https://example.org/example",
        "https://example.org/example");

    // Assert
    verify(delegatingHttpSolrClient).getById(eq("https://example.org/example"), eq("https://example.org/example"));
    assertTrue(actualById.isEmpty());
    assertSame(solrDocument, actualById);
  }

  /**
   * Test {@link DelegatingHttpSolrClient#getById(String, String, SolrParams)}
   * with {@code collection}, {@code id}, {@code params}.
   * <p>
   * Method under test:
   * {@link DelegatingHttpSolrClient#getById(String, String, SolrParams)}
   */
  @Test
  public void testGetByIdWithCollectionIdParams() throws IOException, SolrServerException {
    // Arrange
    SolrDocument solrDocument = new SolrDocument();
    when(delegatingHttpSolrClient.getById(Mockito.<String>any(), Mockito.<String>any(), Mockito.<SolrParams>any()))
        .thenReturn(solrDocument);

    // Act
    SolrDocument actualById = delegatingHttpSolrClient.getById("https://example.org/example",
        "https://example.org/example", new SolrQuery("foo"));

    // Assert
    verify(delegatingHttpSolrClient).getById(eq("https://example.org/example"), eq("https://example.org/example"),
        isA(SolrParams.class));
    assertTrue(actualById.isEmpty());
    assertSame(solrDocument, actualById);
  }

  /**
   * Test {@link DelegatingHttpSolrClient#getById(String, Collection, SolrParams)}
   * with {@code collection}, {@code ids}, {@code params}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DelegatingHttpSolrClient#getById(String, Collection, SolrParams)}
   */
  @Test
  public void testGetByIdWithCollectionIdsParams_given42_whenArrayListAdd42() throws IOException, SolrServerException {
    // Arrange
    SolrDocumentList solrDocumentList = new SolrDocumentList();
    when(delegatingHttpSolrClient.getById(Mockito.<String>any(), Mockito.<Collection<String>>any(),
        Mockito.<SolrParams>any())).thenReturn(solrDocumentList);

    ArrayList<String> ids = new ArrayList<>();
    ids.add("42");
    ids.add("foo");

    // Act
    SolrDocumentList actualById = delegatingHttpSolrClient.getById("https://example.org/example", ids,
        new SolrQuery("foo"));

    // Assert
    verify(delegatingHttpSolrClient).getById(eq("https://example.org/example"), isA(Collection.class),
        isA(SolrParams.class));
    assertTrue(actualById.isEmpty());
    assertSame(solrDocumentList, actualById);
  }

  /**
   * Test {@link DelegatingHttpSolrClient#getById(String, Collection, SolrParams)}
   * with {@code collection}, {@code ids}, {@code params}.
   * <ul>
   *   <li>Given {@code foo}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DelegatingHttpSolrClient#getById(String, Collection, SolrParams)}
   */
  @Test
  public void testGetByIdWithCollectionIdsParams_givenFoo_whenArrayListAddFoo()
      throws IOException, SolrServerException {
    // Arrange
    SolrDocumentList solrDocumentList = new SolrDocumentList();
    when(delegatingHttpSolrClient.getById(Mockito.<String>any(), Mockito.<Collection<String>>any(),
        Mockito.<SolrParams>any())).thenReturn(solrDocumentList);

    ArrayList<String> ids = new ArrayList<>();
    ids.add("foo");

    // Act
    SolrDocumentList actualById = delegatingHttpSolrClient.getById("https://example.org/example", ids,
        new SolrQuery("foo"));

    // Assert
    verify(delegatingHttpSolrClient).getById(eq("https://example.org/example"), isA(Collection.class),
        isA(SolrParams.class));
    assertTrue(actualById.isEmpty());
    assertSame(solrDocumentList, actualById);
  }

  /**
   * Test {@link DelegatingHttpSolrClient#getById(String, Collection, SolrParams)}
   * with {@code collection}, {@code ids}, {@code params}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DelegatingHttpSolrClient#getById(String, Collection, SolrParams)}
   */
  @Test
  public void testGetByIdWithCollectionIdsParams_whenArrayList() throws IOException, SolrServerException {
    // Arrange
    SolrDocumentList solrDocumentList = new SolrDocumentList();
    when(delegatingHttpSolrClient.getById(Mockito.<String>any(), Mockito.<Collection<String>>any(),
        Mockito.<SolrParams>any())).thenReturn(solrDocumentList);
    ArrayList<String> ids = new ArrayList<>();

    // Act
    SolrDocumentList actualById = delegatingHttpSolrClient.getById("https://example.org/example", ids,
        new SolrQuery("foo"));

    // Assert
    verify(delegatingHttpSolrClient).getById(eq("https://example.org/example"), isA(Collection.class),
        isA(SolrParams.class));
    assertTrue(actualById.isEmpty());
    assertSame(solrDocumentList, actualById);
  }

  /**
   * Test {@link DelegatingHttpSolrClient#getById(String, Collection)} with
   * {@code collection}, {@code ids}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DelegatingHttpSolrClient#getById(String, Collection)}
   */
  @Test
  public void testGetByIdWithCollectionIds_given42_whenArrayListAdd42() throws IOException, SolrServerException {
    // Arrange
    SolrDocumentList solrDocumentList = new SolrDocumentList();
    when(delegatingHttpSolrClient.getById(Mockito.<String>any(), Mockito.<Collection<String>>any()))
        .thenReturn(solrDocumentList);

    ArrayList<String> ids = new ArrayList<>();
    ids.add("42");
    ids.add("foo");

    // Act
    SolrDocumentList actualById = delegatingHttpSolrClient.getById("https://example.org/example", ids);

    // Assert
    verify(delegatingHttpSolrClient).getById(eq("https://example.org/example"), isA(Collection.class));
    assertTrue(actualById.isEmpty());
    assertSame(solrDocumentList, actualById);
  }

  /**
   * Test {@link DelegatingHttpSolrClient#getById(String, Collection)} with
   * {@code collection}, {@code ids}.
   * <ul>
   *   <li>Given {@code foo}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DelegatingHttpSolrClient#getById(String, Collection)}
   */
  @Test
  public void testGetByIdWithCollectionIds_givenFoo_whenArrayListAddFoo() throws IOException, SolrServerException {
    // Arrange
    SolrDocumentList solrDocumentList = new SolrDocumentList();
    when(delegatingHttpSolrClient.getById(Mockito.<String>any(), Mockito.<Collection<String>>any()))
        .thenReturn(solrDocumentList);

    ArrayList<String> ids = new ArrayList<>();
    ids.add("foo");

    // Act
    SolrDocumentList actualById = delegatingHttpSolrClient.getById("https://example.org/example", ids);

    // Assert
    verify(delegatingHttpSolrClient).getById(eq("https://example.org/example"), isA(Collection.class));
    assertTrue(actualById.isEmpty());
    assertSame(solrDocumentList, actualById);
  }

  /**
   * Test {@link DelegatingHttpSolrClient#getById(String, Collection)} with
   * {@code collection}, {@code ids}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DelegatingHttpSolrClient#getById(String, Collection)}
   */
  @Test
  public void testGetByIdWithCollectionIds_whenArrayList() throws IOException, SolrServerException {
    // Arrange
    SolrDocumentList solrDocumentList = new SolrDocumentList();
    when(delegatingHttpSolrClient.getById(Mockito.<String>any(), Mockito.<Collection<String>>any()))
        .thenReturn(solrDocumentList);

    // Act
    SolrDocumentList actualById = delegatingHttpSolrClient.getById("https://example.org/example", new ArrayList<>());

    // Assert
    verify(delegatingHttpSolrClient).getById(eq("https://example.org/example"), isA(Collection.class));
    assertTrue(actualById.isEmpty());
    assertSame(solrDocumentList, actualById);
  }

  /**
   * Test {@link DelegatingHttpSolrClient#getById(String)} with {@code id}.
   * <p>
   * Method under test: {@link DelegatingHttpSolrClient#getById(String)}
   */
  @Test
  public void testGetByIdWithId() throws IOException, SolrServerException {
    // Arrange
    SolrDocument solrDocument = new SolrDocument();
    when(delegatingHttpSolrClient.getById(Mockito.<String>any())).thenReturn(solrDocument);

    // Act
    SolrDocument actualById = delegatingHttpSolrClient.getById("https://example.org/example");

    // Assert
    verify(delegatingHttpSolrClient).getById(eq("https://example.org/example"));
    assertTrue(actualById.isEmpty());
    assertSame(solrDocument, actualById);
  }

  /**
   * Test {@link DelegatingHttpSolrClient#getById(String, SolrParams)} with
   * {@code id}, {@code params}.
   * <p>
   * Method under test:
   * {@link DelegatingHttpSolrClient#getById(String, SolrParams)}
   */
  @Test
  public void testGetByIdWithIdParams() throws IOException, SolrServerException {
    // Arrange
    SolrDocument solrDocument = new SolrDocument();
    when(delegatingHttpSolrClient.getById(Mockito.<String>any(), Mockito.<SolrParams>any())).thenReturn(solrDocument);

    // Act
    SolrDocument actualById = delegatingHttpSolrClient.getById("https://example.org/example", new SolrQuery("foo"));

    // Assert
    verify(delegatingHttpSolrClient).getById(eq("https://example.org/example"), isA(SolrParams.class));
    assertTrue(actualById.isEmpty());
    assertSame(solrDocument, actualById);
  }

  /**
   * Test {@link DelegatingHttpSolrClient#getById(Collection, SolrParams)} with
   * {@code ids}, {@code params}.
   * <ul>
   *   <li>Given {@code foo}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DelegatingHttpSolrClient#getById(Collection, SolrParams)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetByIdWithIdsParams_givenFoo_whenArrayListAddFoo() throws IOException, SolrServerException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Sandboxing policy violation.
    //   Diffblue Cover ran code in your project that tried
    //     to access the network.
    //   Diffblue Cover's default sandboxing policy disallows this in order to prevent
    //   your code from damaging your system environment.
    //   See https://diff.blue/R011 to resolve this issue.

    // Arrange
    HttpSolrClient.Builder withConnectionTimeoutResult = (new HttpSolrClient.Builder())
        .withBaseSolrUrl("https://example.org/example")
        .allowCompression(true)
        .withConnectionTimeout(10);
    HttpSolrClient.Builder withHttpClientResult = withConnectionTimeoutResult.withHttpClient(new AutoRetryHttpClient());
    HttpSolrClient delegate = withHttpClientResult.withResponseParser(new BinaryResponseParser())
        .withSocketTimeout(10)
        .build();
    DelegatingHttpSolrClient delegatingHttpSolrClient = new DelegatingHttpSolrClient(delegate);

    ArrayList<String> ids = new ArrayList<>();
    ids.add("foo");

    // Act
    delegatingHttpSolrClient.getById(ids, new SolrQuery("foo"));
  }

  /**
   * Test {@link DelegatingHttpSolrClient#getById(Collection, SolrParams)} with
   * {@code ids}, {@code params}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DelegatingHttpSolrClient#getById(Collection, SolrParams)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetByIdWithIdsParams_whenArrayList() throws IOException, SolrServerException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.IllegalArgumentException: Must provide an identifier of a document to retrieve.
    //       at org.apache.solr.client.solrj.SolrClient.getById(SolrClient.java:1235)
    //       at org.apache.solr.client.solrj.SolrClient.getById(SolrClient.java:1262)
    //       at org.broadleafcommerce.core.search.service.solr.DelegatingHttpSolrClient.getById(DelegatingHttpSolrClient.java:633)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange
    HttpSolrClient.Builder withConnectionTimeoutResult = (new HttpSolrClient.Builder())
        .withBaseSolrUrl("https://example.org/example")
        .allowCompression(true)
        .withConnectionTimeout(10);
    HttpSolrClient.Builder withHttpClientResult = withConnectionTimeoutResult.withHttpClient(new AutoRetryHttpClient());
    HttpSolrClient delegate = withHttpClientResult.withResponseParser(new BinaryResponseParser())
        .withSocketTimeout(10)
        .build();
    DelegatingHttpSolrClient delegatingHttpSolrClient = new DelegatingHttpSolrClient(delegate);
    ArrayList<String> ids = new ArrayList<>();

    // Act
    delegatingHttpSolrClient.getById(ids, new SolrQuery("foo"));
  }

  /**
   * Test {@link DelegatingHttpSolrClient#getById(Collection)} with {@code ids}.
   * <ul>
   *   <li>Given {@code foo}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DelegatingHttpSolrClient#getById(Collection)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetByIdWithIds_givenFoo_whenArrayListAddFoo() throws IOException, SolrServerException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Sandboxing policy violation.
    //   Diffblue Cover ran code in your project that tried
    //     to access the network.
    //   Diffblue Cover's default sandboxing policy disallows this in order to prevent
    //   your code from damaging your system environment.
    //   See https://diff.blue/R011 to resolve this issue.

    // Arrange
    HttpSolrClient.Builder withConnectionTimeoutResult = (new HttpSolrClient.Builder())
        .withBaseSolrUrl("https://example.org/example")
        .allowCompression(true)
        .withConnectionTimeout(10);
    HttpSolrClient.Builder withHttpClientResult = withConnectionTimeoutResult.withHttpClient(new AutoRetryHttpClient());
    HttpSolrClient delegate = withHttpClientResult.withResponseParser(new BinaryResponseParser())
        .withSocketTimeout(10)
        .build();
    DelegatingHttpSolrClient delegatingHttpSolrClient = new DelegatingHttpSolrClient(delegate);

    ArrayList<String> ids = new ArrayList<>();
    ids.add("foo");

    // Act
    delegatingHttpSolrClient.getById(ids);
  }

  /**
   * Test {@link DelegatingHttpSolrClient#getById(Collection)} with {@code ids}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DelegatingHttpSolrClient#getById(Collection)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetByIdWithIds_whenArrayList() throws IOException, SolrServerException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.IllegalArgumentException: Must provide an identifier of a document to retrieve.
    //       at org.apache.solr.client.solrj.SolrClient.getById(SolrClient.java:1235)
    //       at org.apache.solr.client.solrj.SolrClient.getById(SolrClient.java:1198)
    //       at org.apache.solr.client.solrj.SolrClient.getById(SolrClient.java:1214)
    //       at org.broadleafcommerce.core.search.service.solr.DelegatingHttpSolrClient.getById(DelegatingHttpSolrClient.java:615)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange
    HttpSolrClient.Builder withConnectionTimeoutResult = (new HttpSolrClient.Builder())
        .withBaseSolrUrl("https://example.org/example")
        .allowCompression(true)
        .withConnectionTimeout(10);
    HttpSolrClient.Builder withHttpClientResult = withConnectionTimeoutResult.withHttpClient(new AutoRetryHttpClient());
    HttpSolrClient delegate = withHttpClientResult.withResponseParser(new BinaryResponseParser())
        .withSocketTimeout(10)
        .build();
    DelegatingHttpSolrClient delegatingHttpSolrClient = new DelegatingHttpSolrClient(delegate);

    // Act
    delegatingHttpSolrClient.getById(new ArrayList<>());
  }

  /**
   * Test {@link DelegatingHttpSolrClient#getBinder()}.
   * <ul>
   *   <li>Then calls {@link Builder#withBaseSolrUrl(String)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DelegatingHttpSolrClient#getBinder()}
   */
  @Test
  public void testGetBinder_thenCallsWithBaseSolrUrl() {
    // Arrange
    HttpSolrClient.Builder builder = mock(HttpSolrClient.Builder.class);
    when(builder.withBaseSolrUrl(Mockito.<String>any()))
        .thenReturn(new HttpSolrClient.Builder("https://example.org/example"));
    HttpSolrClient.Builder withConnectionTimeoutResult = builder.withBaseSolrUrl("https://example.org/example")
        .allowCompression(true)
        .withConnectionTimeout(10);
    HttpSolrClient.Builder withHttpClientResult = withConnectionTimeoutResult.withHttpClient(new AutoRetryHttpClient());
    HttpSolrClient delegate = withHttpClientResult.withResponseParser(new BinaryResponseParser())
        .withSocketTimeout(10)
        .build();

    // Act
    (new DelegatingHttpSolrClient(delegate)).getBinder();

    // Assert
    verify(builder).withBaseSolrUrl(eq("https://example.org/example"));
  }

  /**
   * Test {@link DelegatingHttpSolrClient#close()}.
   * <p>
   * Method under test: {@link DelegatingHttpSolrClient#close()}
   */
  @Test
  public void testClose() throws IOException {
    // Arrange
    HttpSolrClient.Builder builder = mock(HttpSolrClient.Builder.class);
    when(builder.withBaseSolrUrl(Mockito.<String>any()))
        .thenReturn(new HttpSolrClient.Builder("https://example.org/example"));
    HttpSolrClient.Builder withConnectionTimeoutResult = builder.withBaseSolrUrl("https://example.org/example")
        .allowCompression(true)
        .withConnectionTimeout(10);
    HttpSolrClient.Builder withHttpClientResult = withConnectionTimeoutResult.withHttpClient(new AutoRetryHttpClient());
    HttpSolrClient delegate = withHttpClientResult.withResponseParser(new BinaryResponseParser())
        .withSocketTimeout(10)
        .build();

    // Act
    (new DelegatingHttpSolrClient(delegate)).close();

    // Assert that nothing has changed
    verify(builder).withBaseSolrUrl(eq("https://example.org/example"));
  }

  /**
   * Test {@link DelegatingHttpSolrClient#close()}.
   * <p>
   * Method under test: {@link DelegatingHttpSolrClient#close()}
   */
  @Test
  public void testClose2() throws IOException {
    // Arrange
    HttpSolrClient.Builder builder = mock(HttpSolrClient.Builder.class);
    when(builder.withBaseSolrUrl(Mockito.<String>any()))
        .thenReturn(new HttpSolrClient.Builder("https://example.org/example"));
    HttpSolrClient.Builder withHttpClientResult = builder.withBaseSolrUrl("https://example.org/example")
        .allowCompression(true)
        .withConnectionTimeout(10)
        .withHttpClient(null);
    HttpSolrClient delegate = withHttpClientResult.withResponseParser(new BinaryResponseParser())
        .withSocketTimeout(10)
        .build();

    // Act
    (new DelegatingHttpSolrClient(delegate)).close();

    // Assert
    verify(builder).withBaseSolrUrl(eq("https://example.org/example"));
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DelegatingHttpSolrClient#getDefaultCollection()}
   *   <li>{@link DelegatingHttpSolrClient#getDelegate()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    HttpSolrClient.Builder withConnectionTimeoutResult = (new HttpSolrClient.Builder())
        .withBaseSolrUrl("https://example.org/example")
        .allowCompression(true)
        .withConnectionTimeout(10);
    HttpSolrClient.Builder withHttpClientResult = withConnectionTimeoutResult.withHttpClient(new AutoRetryHttpClient());
    HttpSolrClient delegate = withHttpClientResult.withResponseParser(new BinaryResponseParser())
        .withSocketTimeout(10)
        .build();
    DelegatingHttpSolrClient delegatingHttpSolrClient = new DelegatingHttpSolrClient(delegate);

    // Act
    String actualDefaultCollection = delegatingHttpSolrClient.getDefaultCollection();

    // Assert
    assertNull(actualDefaultCollection);
    assertSame(delegatingHttpSolrClient.delegate, delegatingHttpSolrClient.getDelegate());
  }
}
