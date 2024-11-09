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
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.IOException;
import org.apache.http.impl.client.AutoRetryHttpClient;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.BinaryResponseParser;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.impl.HttpSolrClient.Builder;
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
