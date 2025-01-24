package org.broadleafcommerce.core.search.service.solr;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.embedded.SSLConfig;
import org.apache.solr.client.solrj.impl.CloudSolrClient;
import org.apache.solr.client.solrj.impl.Http2SolrClient;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.impl.LBHttp2SolrClient;
import org.apache.solr.client.solrj.response.UpdateResponse;
import org.apache.solr.common.SolrInputDocument;
import org.broadleafcommerce.common.site.domain.Site;
import org.broadleafcommerce.common.site.domain.SiteImpl;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.annotation.DirtiesContext;

@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class SolrConfigurationDiffblueTest {
  @MockBean
  private SolrConfiguration solrConfiguration;

  /**
   * Test {@link SolrConfiguration#setSolrCloudNumShards(int)} with {@code int}.
   * <p>
   * Method under test: {@link SolrConfiguration#setSolrCloudNumShards(int)}
   */
  @Test
  public void testSetSolrCloudNumShardsWithInt() {
    // Arrange
    doNothing().when(solrConfiguration).setSolrCloudNumShards(anyInt());

    // Act
    solrConfiguration.setSolrCloudNumShards(10);

    // Assert
    verify(solrConfiguration).setSolrCloudNumShards(eq(10));
  }

  /**
   * Test {@link SolrConfiguration#setServer(SolrClient)}.
   * <ul>
   *   <li>Given {@link SolrConfiguration}
   * {@link SolrConfiguration#setServer(SolrClient)} does nothing.</li>
   *   <li>Then calls {@link SolrConfiguration#setServer(SolrClient)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrConfiguration#setServer(SolrClient)}
   */
  @Test
  public void testSetServer_givenSolrConfigurationSetServerDoesNothing_thenCallsSetServer()
      throws IllegalStateException {
    // Arrange
    doNothing().when(solrConfiguration).setServer(Mockito.<SolrClient>any());
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

    // Act
    solrConfiguration.setServer(new LBHttp2SolrClient(httpClient5, "https://example.org/example"));

    // Assert
    verify(solrConfiguration).setServer(isA(SolrClient.class));
  }

  /**
   * Test {@link SolrConfiguration#setReindexServer(SolrClient)}.
   * <ul>
   *   <li>Then calls {@link SolrConfiguration#setReindexServer(SolrClient)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrConfiguration#setReindexServer(SolrClient)}
   */
  @Test
  public void testSetReindexServer_thenCallsSetReindexServer() throws IllegalStateException {
    // Arrange
    doNothing().when(solrConfiguration).setReindexServer(Mockito.<SolrClient>any());
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

    // Act
    solrConfiguration.setReindexServer(new LBHttp2SolrClient(httpClient5, "https://example.org/example"));

    // Assert
    verify(solrConfiguration).setReindexServer(isA(SolrClient.class));
  }

  /**
   * Test {@link SolrConfiguration#getAdminServer()}.
   * <p>
   * Method under test: {@link SolrConfiguration#getAdminServer()}
   */
  @Test
  public void testGetAdminServer() {
    // Arrange
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
    LBHttp2SolrClient lbHttp2SolrClient = new LBHttp2SolrClient(httpClient5, "https://example.org/example");

    when(solrConfiguration.getAdminServer()).thenReturn(lbHttp2SolrClient);

    // Act
    SolrClient actualAdminServer = solrConfiguration.getAdminServer();

    // Assert
    verify(solrConfiguration).getAdminServer();
    assertSame(lbHttp2SolrClient, actualAdminServer);
  }

  /**
   * Test {@link SolrConfiguration#getServer()}.
   * <p>
   * Method under test: {@link SolrConfiguration#getServer()}
   */
  @Test
  public void testGetServer() {
    // Arrange
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
    LBHttp2SolrClient lbHttp2SolrClient = new LBHttp2SolrClient(httpClient5, "https://example.org/example");

    when(solrConfiguration.getServer()).thenReturn(lbHttp2SolrClient);

    // Act
    SolrClient actualServer = solrConfiguration.getServer();

    // Assert
    verify(solrConfiguration).getServer();
    assertSame(lbHttp2SolrClient, actualServer);
  }

  /**
   * Test {@link SolrConfiguration#getReindexServer()}.
   * <p>
   * Method under test: {@link SolrConfiguration#getReindexServer()}
   */
  @Test
  public void testGetReindexServer() {
    // Arrange
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
    LBHttp2SolrClient lbHttp2SolrClient = new LBHttp2SolrClient(httpClient5, "https://example.org/example");

    when(solrConfiguration.getReindexServer()).thenReturn(lbHttp2SolrClient);

    // Act
    SolrClient actualReindexServer = solrConfiguration.getReindexServer();

    // Assert
    verify(solrConfiguration).getReindexServer();
    assertSame(lbHttp2SolrClient, actualReindexServer);
  }

  /**
   * Test {@link SolrConfiguration#isSingleCoreMode()}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrConfiguration#isSingleCoreMode()}
   */
  @Test
  public void testIsSingleCoreMode_thenReturnFalse() {
    // Arrange
    when(solrConfiguration.isSingleCoreMode()).thenReturn(false);

    // Act
    boolean actualIsSingleCoreModeResult = solrConfiguration.isSingleCoreMode();

    // Assert
    verify(solrConfiguration).isSingleCoreMode();
    assertFalse(actualIsSingleCoreModeResult);
  }

  /**
   * Test {@link SolrConfiguration#isSingleCoreMode()}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrConfiguration#isSingleCoreMode()}
   */
  @Test
  public void testIsSingleCoreMode_thenReturnTrue() {
    // Arrange
    when(solrConfiguration.isSingleCoreMode()).thenReturn(true);

    // Act
    boolean actualIsSingleCoreModeResult = solrConfiguration.isSingleCoreMode();

    // Assert
    verify(solrConfiguration).isSingleCoreMode();
    assertTrue(actualIsSingleCoreModeResult);
  }

  /**
   * Test {@link SolrConfiguration#isSolrCloudMode()}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrConfiguration#isSolrCloudMode()}
   */
  @Test
  public void testIsSolrCloudMode_thenReturnFalse() {
    // Arrange
    when(solrConfiguration.isSolrCloudMode()).thenReturn(false);

    // Act
    boolean actualIsSolrCloudModeResult = solrConfiguration.isSolrCloudMode();

    // Assert
    verify(solrConfiguration).isSolrCloudMode();
    assertFalse(actualIsSolrCloudModeResult);
  }

  /**
   * Test {@link SolrConfiguration#isSolrCloudMode()}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrConfiguration#isSolrCloudMode()}
   */
  @Test
  public void testIsSolrCloudMode_thenReturnTrue() {
    // Arrange
    when(solrConfiguration.isSolrCloudMode()).thenReturn(true);

    // Act
    boolean actualIsSolrCloudModeResult = solrConfiguration.isSolrCloudMode();

    // Assert
    verify(solrConfiguration).isSolrCloudMode();
    assertTrue(actualIsSolrCloudModeResult);
  }

  /**
   * Test
   * {@link SolrConfiguration#SolrConfiguration(SolrClient, SolrClient, String, int)}.
   * <ul>
   *   <li>Given {@code Default Collection}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SolrConfiguration#SolrConfiguration(SolrClient, SolrClient, String, int)}
   */
  @Test
  public void testNewSolrConfiguration_givenDefaultCollection() throws IllegalStateException {
    // Arrange
    LBHttp2SolrClient solrServer = mock(LBHttp2SolrClient.class);
    BroadleafCloudSolrClient reindexServer = mock(BroadleafCloudSolrClient.class);
    when(reindexServer.getDefaultCollection()).thenReturn("Default Collection");

    // Act
    SolrConfiguration actualSolrConfiguration = new SolrConfiguration(solrServer, reindexServer,
        "Solr Cloud Config Name", 10);

    // Assert
    verify(reindexServer).getDefaultCollection();
    SolrClient solrClient = actualSolrConfiguration.primaryServer;
    assertSame(solrClient, actualSolrConfiguration.getAdminServer());
    assertSame(solrClient, actualSolrConfiguration.getServer());
    SolrClient expectedReindexServer = actualSolrConfiguration.reindexServer;
    assertSame(expectedReindexServer, actualSolrConfiguration.getReindexServer());
  }

  /**
   * Test
   * {@link SolrConfiguration#SolrConfiguration(SolrClient, SolrClient, String, int, String)}.
   * <ul>
   *   <li>Given {@code Default Collection}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SolrConfiguration#SolrConfiguration(SolrClient, SolrClient, String, int, String)}
   */
  @Test
  public void testNewSolrConfiguration_givenDefaultCollection2() throws IllegalStateException {
    // Arrange
    LBHttp2SolrClient solrServer = mock(LBHttp2SolrClient.class);
    BroadleafCloudSolrClient reindexServer = mock(BroadleafCloudSolrClient.class);
    when(reindexServer.getDefaultCollection()).thenReturn("Default Collection");

    // Act
    SolrConfiguration actualSolrConfiguration = new SolrConfiguration(solrServer, reindexServer,
        "Solr Cloud Config Name", 10, "Namespace");

    // Assert
    verify(reindexServer).getDefaultCollection();
    SolrClient solrClient = actualSolrConfiguration.primaryServer;
    assertSame(solrClient, actualSolrConfiguration.getAdminServer());
    assertSame(solrClient, actualSolrConfiguration.getServer());
    SolrClient expectedReindexServer = actualSolrConfiguration.reindexServer;
    assertSame(expectedReindexServer, actualSolrConfiguration.getReindexServer());
  }

  /**
   * Test
   * {@link SolrConfiguration#SolrConfiguration(SolrClient, SolrClient, String, int)}.
   * <ul>
   *   <li>Given empty string.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SolrConfiguration#SolrConfiguration(SolrClient, SolrClient, String, int)}
   */
  @Test
  public void testNewSolrConfiguration_givenEmptyString() throws IllegalStateException {
    // Arrange
    LBHttp2SolrClient solrServer = mock(LBHttp2SolrClient.class);
    BroadleafCloudSolrClient reindexServer = mock(BroadleafCloudSolrClient.class);
    when(reindexServer.getDefaultCollection()).thenReturn("");
    doNothing().when(reindexServer).setDefaultCollection(Mockito.<String>any());

    // Act
    SolrConfiguration actualSolrConfiguration = new SolrConfiguration(solrServer, reindexServer,
        "Solr Cloud Config Name", 10);

    // Assert
    verify(reindexServer).getDefaultCollection();
    verify(reindexServer).setDefaultCollection(isNull());
    SolrClient solrClient = actualSolrConfiguration.primaryServer;
    assertSame(solrClient, actualSolrConfiguration.getAdminServer());
    assertSame(solrClient, actualSolrConfiguration.getServer());
    SolrClient expectedReindexServer = actualSolrConfiguration.reindexServer;
    assertSame(expectedReindexServer, actualSolrConfiguration.getReindexServer());
  }

  /**
   * Test
   * {@link SolrConfiguration#SolrConfiguration(SolrClient, SolrClient, String, int, String)}.
   * <ul>
   *   <li>Given empty string.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SolrConfiguration#SolrConfiguration(SolrClient, SolrClient, String, int, String)}
   */
  @Test
  public void testNewSolrConfiguration_givenEmptyString2() throws IllegalStateException {
    // Arrange
    LBHttp2SolrClient solrServer = mock(LBHttp2SolrClient.class);
    BroadleafCloudSolrClient reindexServer = mock(BroadleafCloudSolrClient.class);
    when(reindexServer.getDefaultCollection()).thenReturn("");
    doNothing().when(reindexServer).setDefaultCollection(Mockito.<String>any());

    // Act
    SolrConfiguration actualSolrConfiguration = new SolrConfiguration(solrServer, reindexServer,
        "Solr Cloud Config Name", 10, "Namespace");

    // Assert
    verify(reindexServer).getDefaultCollection();
    verify(reindexServer).setDefaultCollection(isNull());
    SolrClient solrClient = actualSolrConfiguration.primaryServer;
    assertSame(solrClient, actualSolrConfiguration.getAdminServer());
    assertSame(solrClient, actualSolrConfiguration.getServer());
    SolrClient expectedReindexServer = actualSolrConfiguration.reindexServer;
    assertSame(expectedReindexServer, actualSolrConfiguration.getReindexServer());
  }

  /**
   * Test
   * {@link SolrConfiguration#SolrConfiguration(SolrClient, SolrClient, String, int)}.
   * <ul>
   *   <li>Given {@link IllegalStateException#IllegalStateException(String)} with
   * {@code d}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SolrConfiguration#SolrConfiguration(SolrClient, SolrClient, String, int)}
   */
  @Test
  public void testNewSolrConfiguration_givenIllegalStateExceptionWithD() throws IllegalStateException {
    // Arrange
    LBHttp2SolrClient solrServer = mock(LBHttp2SolrClient.class);
    BroadleafCloudSolrClient reindexServer = mock(BroadleafCloudSolrClient.class);
    when(reindexServer.getDefaultCollection()).thenThrow(new IllegalStateException("d"));

    // Act
    new SolrConfiguration(solrServer, reindexServer, "Solr Cloud Config Name", 10);

    // Assert
    verify(reindexServer).getDefaultCollection();
  }

  /**
   * Test
   * {@link SolrConfiguration#SolrConfiguration(SolrClient, SolrClient, String, int, String)}.
   * <ul>
   *   <li>Given {@link IllegalStateException#IllegalStateException(String)} with
   * {@code d}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SolrConfiguration#SolrConfiguration(SolrClient, SolrClient, String, int, String)}
   */
  @Test
  public void testNewSolrConfiguration_givenIllegalStateExceptionWithD2() throws IllegalStateException {
    // Arrange
    LBHttp2SolrClient solrServer = mock(LBHttp2SolrClient.class);
    BroadleafCloudSolrClient reindexServer = mock(BroadleafCloudSolrClient.class);
    when(reindexServer.getDefaultCollection()).thenThrow(new IllegalStateException("d"));

    // Act
    new SolrConfiguration(solrServer, reindexServer, "Solr Cloud Config Name", 10, "Namespace");

    // Assert
    verify(reindexServer).getDefaultCollection();
  }

  /**
   * Test
   * {@link SolrConfiguration#SolrConfiguration(SolrClient, SolrClient, String, int)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SolrConfiguration#SolrConfiguration(SolrClient, SolrClient, String, int)}
   */
  @Test
  public void testNewSolrConfiguration_givenNull() throws IllegalStateException {
    // Arrange
    LBHttp2SolrClient solrServer = mock(LBHttp2SolrClient.class);
    BroadleafCloudSolrClient reindexServer = mock(BroadleafCloudSolrClient.class);
    when(reindexServer.getDefaultCollection()).thenReturn(null);
    doNothing().when(reindexServer).setDefaultCollection(Mockito.<String>any());

    // Act
    SolrConfiguration actualSolrConfiguration = new SolrConfiguration(solrServer, reindexServer,
        "Solr Cloud Config Name", 10);

    // Assert
    verify(reindexServer).getDefaultCollection();
    verify(reindexServer).setDefaultCollection(isNull());
    SolrClient solrClient = actualSolrConfiguration.primaryServer;
    assertSame(solrClient, actualSolrConfiguration.getAdminServer());
    assertSame(solrClient, actualSolrConfiguration.getServer());
    SolrClient expectedReindexServer = actualSolrConfiguration.reindexServer;
    assertSame(expectedReindexServer, actualSolrConfiguration.getReindexServer());
  }

  /**
   * Test
   * {@link SolrConfiguration#SolrConfiguration(SolrClient, SolrClient, String, int, String)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SolrConfiguration#SolrConfiguration(SolrClient, SolrClient, String, int, String)}
   */
  @Test
  public void testNewSolrConfiguration_givenNull2() throws IllegalStateException {
    // Arrange
    LBHttp2SolrClient solrServer = mock(LBHttp2SolrClient.class);
    BroadleafCloudSolrClient reindexServer = mock(BroadleafCloudSolrClient.class);
    when(reindexServer.getDefaultCollection()).thenReturn(null);
    doNothing().when(reindexServer).setDefaultCollection(Mockito.<String>any());

    // Act
    SolrConfiguration actualSolrConfiguration = new SolrConfiguration(solrServer, reindexServer,
        "Solr Cloud Config Name", 10, "Namespace");

    // Assert
    verify(reindexServer).getDefaultCollection();
    verify(reindexServer).setDefaultCollection(isNull());
    SolrClient solrClient = actualSolrConfiguration.primaryServer;
    assertSame(solrClient, actualSolrConfiguration.getAdminServer());
    assertSame(solrClient, actualSolrConfiguration.getServer());
    SolrClient expectedReindexServer = actualSolrConfiguration.reindexServer;
    assertSame(expectedReindexServer, actualSolrConfiguration.getReindexServer());
  }

  /**
   * Test
   * {@link SolrConfiguration#SolrConfiguration(SolrClient, SolrClient, SolrClient)}.
   * <ul>
   *   <li>Then {@link SolrConfiguration#adminServer} return
   * {@link LBHttp2SolrClient}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SolrConfiguration#SolrConfiguration(SolrClient, SolrClient, SolrClient)}
   */
  @Test
  public void testNewSolrConfiguration_thenAdminServerReturnLBHttp2SolrClient()
      throws IOException, IllegalStateException, SolrServerException {
    // Arrange
    LBHttp2SolrClient solrServer = mock(LBHttp2SolrClient.class);
    LBHttp2SolrClient reindexServer = mock(LBHttp2SolrClient.class);
    when(reindexServer.add(Mockito.<String>any(), Mockito.<Collection<SolrInputDocument>>any()))
        .thenReturn(new UpdateResponse());
    reindexServer.add("Collection", new ArrayList<>());
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

    // Act
    SolrConfiguration actualSolrConfiguration = new SolrConfiguration(solrServer, reindexServer,
        new LBHttp2SolrClient(httpClient5, "https://example.org/example"));

    // Assert
    verify(reindexServer).add(eq("Collection"), isA(Collection.class));
    SolrClient solrClient = actualSolrConfiguration.adminServer;
    assertTrue(solrClient instanceof LBHttp2SolrClient);
    assertEquals("d", actualSolrConfiguration.getNamespace());
    assertNull(actualSolrConfiguration.getSolrCloudNumReplicas());
    assertNull(actualSolrConfiguration.getSolrCloudNumShards());
    assertNull(actualSolrConfiguration.getPrimaryName());
    assertNull(actualSolrConfiguration.getQueryCollectionName());
    assertNull(actualSolrConfiguration.getReindexCollectionName());
    assertNull(actualSolrConfiguration.getReindexName());
    assertNull(actualSolrConfiguration.getSiteAliasBase());
    assertNull(actualSolrConfiguration.getSiteCollectionBase());
    assertNull(actualSolrConfiguration.getSolrCloudConfigName());
    assertNull(actualSolrConfiguration.getSolrHomePath());
    assertNull(((LBHttp2SolrClient) solrClient).getParser());
    assertNull(((LBHttp2SolrClient) solrClient).getRequestWriter());
    assertFalse(actualSolrConfiguration.isSingleCoreMode());
    assertFalse(actualSolrConfiguration.isSiteCollections());
    assertFalse(actualSolrConfiguration.isSolrCloudMode());
    SolrClient expectedAdminServer = actualSolrConfiguration.adminServer;
    assertSame(expectedAdminServer, actualSolrConfiguration.getAdminServer());
    SolrClient expectedServer = actualSolrConfiguration.primaryServer;
    assertSame(expectedServer, actualSolrConfiguration.getServer());
    SolrClient expectedReindexServer = actualSolrConfiguration.reindexServer;
    assertSame(expectedReindexServer, actualSolrConfiguration.getReindexServer());
  }

  /**
   * Test
   * {@link SolrConfiguration#SolrConfiguration(SolrClient, SolrClient, SolrClient, String)}.
   * <ul>
   *   <li>Then {@link SolrConfiguration#adminServer} return
   * {@link LBHttp2SolrClient}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SolrConfiguration#SolrConfiguration(SolrClient, SolrClient, SolrClient, String)}
   */
  @Test
  public void testNewSolrConfiguration_thenAdminServerReturnLBHttp2SolrClient2()
      throws IOException, IllegalStateException, SolrServerException {
    // Arrange
    LBHttp2SolrClient solrServer = mock(LBHttp2SolrClient.class);
    LBHttp2SolrClient reindexServer = mock(LBHttp2SolrClient.class);
    when(reindexServer.add(Mockito.<String>any(), Mockito.<Collection<SolrInputDocument>>any()))
        .thenReturn(new UpdateResponse());
    reindexServer.add("Collection", new ArrayList<>());
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

    // Act
    SolrConfiguration actualSolrConfiguration = new SolrConfiguration(solrServer, reindexServer,
        new LBHttp2SolrClient(httpClient5, "https://example.org/example"), "Namespace");

    // Assert
    verify(reindexServer).add(eq("Collection"), isA(Collection.class));
    SolrClient solrClient = actualSolrConfiguration.adminServer;
    assertTrue(solrClient instanceof LBHttp2SolrClient);
    assertEquals("Namespace", actualSolrConfiguration.getNamespace());
    assertNull(actualSolrConfiguration.getSolrCloudNumReplicas());
    assertNull(actualSolrConfiguration.getSolrCloudNumShards());
    assertNull(actualSolrConfiguration.getPrimaryName());
    assertNull(actualSolrConfiguration.getQueryCollectionName());
    assertNull(actualSolrConfiguration.getReindexCollectionName());
    assertNull(actualSolrConfiguration.getReindexName());
    assertNull(actualSolrConfiguration.getSiteAliasBase());
    assertNull(actualSolrConfiguration.getSiteCollectionBase());
    assertNull(actualSolrConfiguration.getSolrCloudConfigName());
    assertNull(actualSolrConfiguration.getSolrHomePath());
    assertNull(((LBHttp2SolrClient) solrClient).getParser());
    assertNull(((LBHttp2SolrClient) solrClient).getRequestWriter());
    assertFalse(actualSolrConfiguration.isSingleCoreMode());
    assertFalse(actualSolrConfiguration.isSiteCollections());
    assertFalse(actualSolrConfiguration.isSolrCloudMode());
    SolrClient expectedAdminServer = actualSolrConfiguration.adminServer;
    assertSame(expectedAdminServer, actualSolrConfiguration.getAdminServer());
    SolrClient expectedServer = actualSolrConfiguration.primaryServer;
    assertSame(expectedServer, actualSolrConfiguration.getServer());
    SolrClient expectedReindexServer = actualSolrConfiguration.reindexServer;
    assertSame(expectedReindexServer, actualSolrConfiguration.getReindexServer());
  }

  /**
   * Test
   * {@link SolrConfiguration#SolrConfiguration(SolrClient, SolrClient, SolrClient, String, String)}.
   * <ul>
   *   <li>Then {@link SolrConfiguration#adminServer} return
   * {@link LBHttp2SolrClient}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SolrConfiguration#SolrConfiguration(SolrClient, SolrClient, SolrClient, String, String)}
   */
  @Test
  public void testNewSolrConfiguration_thenAdminServerReturnLBHttp2SolrClient3()
      throws IOException, IllegalStateException, SolrServerException {
    // Arrange
    LBHttp2SolrClient solrServer = mock(LBHttp2SolrClient.class);
    LBHttp2SolrClient reindexServer = mock(LBHttp2SolrClient.class);
    when(reindexServer.add(Mockito.<String>any(), Mockito.<Collection<SolrInputDocument>>any()))
        .thenReturn(new UpdateResponse());
    reindexServer.add("Collection", new ArrayList<>());
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

    // Act
    SolrConfiguration actualSolrConfiguration = new SolrConfiguration(solrServer, reindexServer,
        new LBHttp2SolrClient(httpClient5, "https://example.org/example"), "Primary Core Name", "Reindex Core Name");

    // Assert
    verify(reindexServer).add(eq("Collection"), isA(Collection.class));
    SolrClient solrClient = actualSolrConfiguration.adminServer;
    assertTrue(solrClient instanceof LBHttp2SolrClient);
    assertEquals("Primary Core Name", actualSolrConfiguration.getPrimaryName());
    assertEquals("Reindex Core Name", actualSolrConfiguration.getReindexName());
    assertEquals("d", actualSolrConfiguration.getNamespace());
    assertNull(actualSolrConfiguration.getSolrCloudNumReplicas());
    assertNull(actualSolrConfiguration.getSolrCloudNumShards());
    assertNull(actualSolrConfiguration.getQueryCollectionName());
    assertNull(actualSolrConfiguration.getReindexCollectionName());
    assertNull(actualSolrConfiguration.getSiteAliasBase());
    assertNull(actualSolrConfiguration.getSiteCollectionBase());
    assertNull(actualSolrConfiguration.getSolrCloudConfigName());
    assertNull(actualSolrConfiguration.getSolrHomePath());
    assertNull(((LBHttp2SolrClient) solrClient).getParser());
    assertNull(((LBHttp2SolrClient) solrClient).getRequestWriter());
    assertFalse(actualSolrConfiguration.isSingleCoreMode());
    assertFalse(actualSolrConfiguration.isSiteCollections());
    assertFalse(actualSolrConfiguration.isSolrCloudMode());
    SolrClient expectedAdminServer = actualSolrConfiguration.adminServer;
    assertSame(expectedAdminServer, actualSolrConfiguration.getAdminServer());
    SolrClient expectedServer = actualSolrConfiguration.primaryServer;
    assertSame(expectedServer, actualSolrConfiguration.getServer());
    SolrClient expectedReindexServer = actualSolrConfiguration.reindexServer;
    assertSame(expectedReindexServer, actualSolrConfiguration.getReindexServer());
  }

  /**
   * Test
   * {@link SolrConfiguration#SolrConfiguration(SolrClient, SolrClient, SolrClient, String, String, String)}.
   * <ul>
   *   <li>Then {@link SolrConfiguration#adminServer} return
   * {@link LBHttp2SolrClient}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SolrConfiguration#SolrConfiguration(SolrClient, SolrClient, SolrClient, String, String, String)}
   */
  @Test
  public void testNewSolrConfiguration_thenAdminServerReturnLBHttp2SolrClient4()
      throws IOException, IllegalStateException, SolrServerException {
    // Arrange
    LBHttp2SolrClient solrServer = mock(LBHttp2SolrClient.class);
    LBHttp2SolrClient reindexServer = mock(LBHttp2SolrClient.class);
    when(reindexServer.add(Mockito.<String>any(), Mockito.<Collection<SolrInputDocument>>any()))
        .thenReturn(new UpdateResponse());
    reindexServer.add("Collection", new ArrayList<>());
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

    // Act
    SolrConfiguration actualSolrConfiguration = new SolrConfiguration(solrServer, reindexServer,
        new LBHttp2SolrClient(httpClient5, "https://example.org/example"), "Primary Core Name", "Reindex Core Name",
        "Namespace");

    // Assert
    verify(reindexServer).add(eq("Collection"), isA(Collection.class));
    SolrClient solrClient = actualSolrConfiguration.adminServer;
    assertTrue(solrClient instanceof LBHttp2SolrClient);
    assertEquals("Namespace", actualSolrConfiguration.getNamespace());
    assertEquals("Primary Core Name", actualSolrConfiguration.getPrimaryName());
    assertEquals("Reindex Core Name", actualSolrConfiguration.getReindexName());
    assertNull(actualSolrConfiguration.getSolrCloudNumReplicas());
    assertNull(actualSolrConfiguration.getSolrCloudNumShards());
    assertNull(actualSolrConfiguration.getQueryCollectionName());
    assertNull(actualSolrConfiguration.getReindexCollectionName());
    assertNull(actualSolrConfiguration.getSiteAliasBase());
    assertNull(actualSolrConfiguration.getSiteCollectionBase());
    assertNull(actualSolrConfiguration.getSolrCloudConfigName());
    assertNull(actualSolrConfiguration.getSolrHomePath());
    assertNull(((LBHttp2SolrClient) solrClient).getParser());
    assertNull(((LBHttp2SolrClient) solrClient).getRequestWriter());
    assertFalse(actualSolrConfiguration.isSingleCoreMode());
    assertFalse(actualSolrConfiguration.isSiteCollections());
    assertFalse(actualSolrConfiguration.isSolrCloudMode());
    SolrClient expectedAdminServer = actualSolrConfiguration.adminServer;
    assertSame(expectedAdminServer, actualSolrConfiguration.getAdminServer());
    SolrClient expectedServer = actualSolrConfiguration.primaryServer;
    assertSame(expectedServer, actualSolrConfiguration.getServer());
    SolrClient expectedReindexServer = actualSolrConfiguration.reindexServer;
    assertSame(expectedReindexServer, actualSolrConfiguration.getReindexServer());
  }

  /**
   * Test
   * {@link SolrConfiguration#SolrConfiguration(SolrClient, SolrClient, String, int)}.
   * <ul>
   *   <li>Then {@link SolrConfiguration#reindexServer} return
   * {@link LBHttp2SolrClient}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SolrConfiguration#SolrConfiguration(SolrClient, SolrClient, String, int)}
   */
  @Test
  public void testNewSolrConfiguration_thenReindexServerReturnLBHttp2SolrClient() throws IllegalStateException {
    // Arrange
    LBHttp2SolrClient solrServer = mock(LBHttp2SolrClient.class);
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

    // Act
    SolrConfiguration actualSolrConfiguration = new SolrConfiguration(solrServer,
        new LBHttp2SolrClient(httpClient5, "https://example.org/example"), "Solr Cloud Config Name", 10);

    // Assert
    SolrClient solrClient = actualSolrConfiguration.reindexServer;
    assertTrue(solrClient instanceof LBHttp2SolrClient);
    assertNull(((LBHttp2SolrClient) solrClient).getParser());
    assertNull(((LBHttp2SolrClient) solrClient).getRequestWriter());
    SolrClient solrClient2 = actualSolrConfiguration.primaryServer;
    assertSame(solrClient2, actualSolrConfiguration.getAdminServer());
    assertSame(solrClient2, actualSolrConfiguration.getServer());
    SolrClient expectedReindexServer = actualSolrConfiguration.reindexServer;
    assertSame(expectedReindexServer, actualSolrConfiguration.getReindexServer());
  }

  /**
   * Test
   * {@link SolrConfiguration#SolrConfiguration(SolrClient, SolrClient, String, int, String)}.
   * <ul>
   *   <li>Then {@link SolrConfiguration#reindexServer} return
   * {@link LBHttp2SolrClient}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SolrConfiguration#SolrConfiguration(SolrClient, SolrClient, String, int, String)}
   */
  @Test
  public void testNewSolrConfiguration_thenReindexServerReturnLBHttp2SolrClient2() throws IllegalStateException {
    // Arrange
    LBHttp2SolrClient solrServer = mock(LBHttp2SolrClient.class);
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

    // Act
    SolrConfiguration actualSolrConfiguration = new SolrConfiguration(solrServer,
        new LBHttp2SolrClient(httpClient5, "https://example.org/example"), "Solr Cloud Config Name", 10, "Namespace");

    // Assert
    SolrClient solrClient = actualSolrConfiguration.reindexServer;
    assertTrue(solrClient instanceof LBHttp2SolrClient);
    assertNull(((LBHttp2SolrClient) solrClient).getParser());
    assertNull(((LBHttp2SolrClient) solrClient).getRequestWriter());
    SolrClient solrClient2 = actualSolrConfiguration.primaryServer;
    assertSame(solrClient2, actualSolrConfiguration.getAdminServer());
    assertSame(solrClient2, actualSolrConfiguration.getServer());
    SolrClient expectedReindexServer = actualSolrConfiguration.reindexServer;
    assertSame(expectedReindexServer, actualSolrConfiguration.getReindexServer());
  }

  /**
   * Test
   * {@link SolrConfiguration#SolrConfiguration(SolrClient, SolrClient, String, int)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@link SolrConfiguration#reindexServer} is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SolrConfiguration#SolrConfiguration(SolrClient, SolrClient, String, int)}
   */
  @Test
  public void testNewSolrConfiguration_whenNull_thenReturnReindexServerIsNull() throws IllegalStateException {
    // Arrange and Act
    SolrConfiguration actualSolrConfiguration = new SolrConfiguration(mock(LBHttp2SolrClient.class), null,
        "Solr Cloud Config Name", 10);

    // Assert
    assertNull(actualSolrConfiguration.reindexServer);
    assertTrue(actualSolrConfiguration.isSingleCoreMode());
    SolrClient solrClient = actualSolrConfiguration.primaryServer;
    assertSame(solrClient, actualSolrConfiguration.getAdminServer());
    assertSame(solrClient, actualSolrConfiguration.getReindexServer());
    assertSame(solrClient, actualSolrConfiguration.getServer());
  }

  /**
   * Test
   * {@link SolrConfiguration#SolrConfiguration(SolrClient, SolrClient, String, int, String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@link SolrConfiguration#reindexServer} is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SolrConfiguration#SolrConfiguration(SolrClient, SolrClient, String, int, String)}
   */
  @Test
  public void testNewSolrConfiguration_whenNull_thenReturnReindexServerIsNull2() throws IllegalStateException {
    // Arrange and Act
    SolrConfiguration actualSolrConfiguration = new SolrConfiguration(mock(LBHttp2SolrClient.class), null,
        "Solr Cloud Config Name", 10, "Namespace");

    // Assert
    assertNull(actualSolrConfiguration.reindexServer);
    assertTrue(actualSolrConfiguration.isSingleCoreMode());
    SolrClient solrClient = actualSolrConfiguration.primaryServer;
    assertSame(solrClient, actualSolrConfiguration.getAdminServer());
    assertSame(solrClient, actualSolrConfiguration.getReindexServer());
    assertSame(solrClient, actualSolrConfiguration.getServer());
  }

  /**
   * Test {@link SolrConfiguration#getSiteServer()}.
   * <p>
   * Method under test: {@link SolrConfiguration#getSiteServer()}
   */
  @Test
  public void testGetSiteServer() {
    // Arrange
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
    LBHttp2SolrClient lbHttp2SolrClient = new LBHttp2SolrClient(httpClient5, "https://example.org/example");

    when(solrConfiguration.getSiteServer()).thenReturn(lbHttp2SolrClient);

    // Act
    SolrClient actualSiteServer = solrConfiguration.getSiteServer();

    // Assert
    verify(solrConfiguration).getSiteServer();
    assertSame(lbHttp2SolrClient, actualSiteServer);
  }

  /**
   * Test {@link SolrConfiguration#getSiteReindexServer()}.
   * <p>
   * Method under test: {@link SolrConfiguration#getSiteReindexServer()}
   */
  @Test
  public void testGetSiteReindexServer() {
    // Arrange
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
    LBHttp2SolrClient lbHttp2SolrClient = new LBHttp2SolrClient(httpClient5, "https://example.org/example");

    when(solrConfiguration.getSiteReindexServer()).thenReturn(lbHttp2SolrClient);

    // Act
    SolrClient actualSiteReindexServer = solrConfiguration.getSiteReindexServer();

    // Assert
    verify(solrConfiguration).getSiteReindexServer();
    assertSame(lbHttp2SolrClient, actualSiteReindexServer);
  }

  /**
   * Test
   * {@link SolrConfiguration#createCollectionIfNotExist(CloudSolrClient, String)}.
   * <ul>
   *   <li>Then calls
   * {@link SolrConfiguration#createCollectionIfNotExist(CloudSolrClient, String)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SolrConfiguration#createCollectionIfNotExist(CloudSolrClient, String)}
   */
  @Test
  public void testCreateCollectionIfNotExist_thenCallsCreateCollectionIfNotExist() {
    // Arrange
    doNothing().when(solrConfiguration)
        .createCollectionIfNotExist(Mockito.<CloudSolrClient>any(), Mockito.<String>any());

    // Act
    solrConfiguration.createCollectionIfNotExist(null, "Collection Name");

    // Assert
    verify(solrConfiguration).createCollectionIfNotExist(isNull(), eq("Collection Name"));
  }

  /**
   * Test
   * {@link SolrConfiguration#createAliasIfNotExist(CloudSolrClient, String, String)}.
   * <ul>
   *   <li>Then calls
   * {@link SolrConfiguration#createAliasIfNotExist(CloudSolrClient, String, String)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SolrConfiguration#createAliasIfNotExist(CloudSolrClient, String, String)}
   */
  @Test
  public void testCreateAliasIfNotExist_thenCallsCreateAliasIfNotExist() {
    // Arrange
    doNothing().when(solrConfiguration)
        .createAliasIfNotExist(Mockito.<CloudSolrClient>any(), Mockito.<String>any(), Mockito.<String>any());

    // Act
    solrConfiguration.createAliasIfNotExist(null, "Collection Name", "Alias Name");

    // Assert
    verify(solrConfiguration).createAliasIfNotExist(isNull(), eq("Collection Name"), eq("Alias Name"));
  }

  /**
   * Test {@link SolrConfiguration#getSiteAliasName(Site)}.
   * <p>
   * Method under test: {@link SolrConfiguration#getSiteAliasName(Site)}
   */
  @Test
  public void testGetSiteAliasName() {
    // Arrange
    when(solrConfiguration.getSiteAliasName(Mockito.<Site>any())).thenReturn("Site Alias Name");

    // Act
    String actualSiteAliasName = solrConfiguration.getSiteAliasName(new SiteImpl());

    // Assert
    verify(solrConfiguration).getSiteAliasName(isA(Site.class));
    assertEquals("Site Alias Name", actualSiteAliasName);
  }

  /**
   * Test {@link SolrConfiguration#getSiteCollectionName(Site)}.
   * <p>
   * Method under test: {@link SolrConfiguration#getSiteCollectionName(Site)}
   */
  @Test
  public void testGetSiteCollectionName() {
    // Arrange
    when(solrConfiguration.getSiteCollectionName(Mockito.<Site>any())).thenReturn("Site Collection Name");

    // Act
    String actualSiteCollectionName = solrConfiguration.getSiteCollectionName(new SiteImpl());

    // Assert
    verify(solrConfiguration).getSiteCollectionName(isA(Site.class));
    assertEquals("Site Collection Name", actualSiteCollectionName);
  }

  /**
   * Test {@link SolrConfiguration#getSiteReindexAliasName(Site)}.
   * <p>
   * Method under test: {@link SolrConfiguration#getSiteReindexAliasName(Site)}
   */
  @Test
  public void testGetSiteReindexAliasName() {
    // Arrange
    when(solrConfiguration.getSiteReindexAliasName(Mockito.<Site>any())).thenReturn("Site Reindex Alias Name");

    // Act
    String actualSiteReindexAliasName = solrConfiguration.getSiteReindexAliasName(new SiteImpl());

    // Assert
    verify(solrConfiguration).getSiteReindexAliasName(isA(Site.class));
    assertEquals("Site Reindex Alias Name", actualSiteReindexAliasName);
  }

  /**
   * Test {@link SolrConfiguration#getSiteReindexCollectionName(Site)}.
   * <p>
   * Method under test:
   * {@link SolrConfiguration#getSiteReindexCollectionName(Site)}
   */
  @Test
  public void testGetSiteReindexCollectionName() {
    // Arrange
    when(solrConfiguration.getSiteReindexCollectionName(Mockito.<Site>any()))
        .thenReturn("Site Reindex Collection Name");

    // Act
    String actualSiteReindexCollectionName = solrConfiguration.getSiteReindexCollectionName(new SiteImpl());

    // Assert
    verify(solrConfiguration).getSiteReindexCollectionName(isA(Site.class));
    assertEquals("Site Reindex Collection Name", actualSiteReindexCollectionName);
  }

  /**
   * Test {@link SolrConfiguration#getQueryCollectionName()}.
   * <p>
   * Method under test: {@link SolrConfiguration#getQueryCollectionName()}
   */
  @Test
  public void testGetQueryCollectionName() {
    // Arrange
    when(solrConfiguration.getQueryCollectionName()).thenReturn("Query Collection Name");

    // Act
    String actualQueryCollectionName = solrConfiguration.getQueryCollectionName();

    // Assert
    verify(solrConfiguration).getQueryCollectionName();
    assertEquals("Query Collection Name", actualQueryCollectionName);
  }

  /**
   * Test {@link SolrConfiguration#getReindexCollectionName()}.
   * <p>
   * Method under test: {@link SolrConfiguration#getReindexCollectionName()}
   */
  @Test
  public void testGetReindexCollectionName() {
    // Arrange
    when(solrConfiguration.getReindexCollectionName()).thenReturn("Reindex Collection Name");

    // Act
    String actualReindexCollectionName = solrConfiguration.getReindexCollectionName();

    // Assert
    verify(solrConfiguration).getReindexCollectionName();
    assertEquals("Reindex Collection Name", actualReindexCollectionName);
  }

  /**
   * Test {@link SolrConfiguration#determineCoreName(HttpSolrClient)}.
   * <ul>
   *   <li>Then return {@code Determine Core Name}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SolrConfiguration#determineCoreName(HttpSolrClient)}
   */
  @Test
  public void testDetermineCoreName_thenReturnDetermineCoreName() {
    // Arrange
    when(solrConfiguration.determineCoreName(Mockito.<HttpSolrClient>any())).thenReturn("Determine Core Name");

    // Act
    String actualDetermineCoreNameResult = solrConfiguration.determineCoreName(null);

    // Assert
    verify(solrConfiguration).determineCoreName(isNull());
    assertEquals("Determine Core Name", actualDetermineCoreNameResult);
  }

  /**
   * Test {@link SolrConfiguration#destroy()}.
   * <p>
   * Method under test: {@link SolrConfiguration#destroy()}
   */
  @Test
  public void testDestroy() throws Exception {
    // Arrange
    doNothing().when(solrConfiguration).destroy();

    // Act
    solrConfiguration.destroy();

    // Assert
    verify(solrConfiguration).destroy();
  }
}
