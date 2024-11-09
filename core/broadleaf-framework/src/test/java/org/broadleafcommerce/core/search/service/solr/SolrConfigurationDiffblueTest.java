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
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
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
import org.apache.solr.client.solrj.impl.Http2SolrClient;
import org.apache.solr.client.solrj.impl.LBHttp2SolrClient;
import org.apache.solr.client.solrj.response.UpdateResponse;
import org.apache.solr.common.SolrInputDocument;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;

public class SolrConfigurationDiffblueTest {
  @MockBean
  private SolrConfiguration solrConfiguration;

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
}
