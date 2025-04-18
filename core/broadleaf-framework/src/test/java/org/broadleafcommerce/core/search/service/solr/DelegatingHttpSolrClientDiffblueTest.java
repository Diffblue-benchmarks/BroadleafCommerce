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
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import org.apache.http.impl.client.AutoRetryHttpClient;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.BinaryResponseParser;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.impl.HttpSolrClient.Builder;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class DelegatingHttpSolrClientDiffblueTest {
  /**
   * Test {@link DelegatingHttpSolrClient#DelegatingHttpSolrClient(HttpSolrClient, String)}.
   * <p>
   * Method under test: {@link DelegatingHttpSolrClient#DelegatingHttpSolrClient(HttpSolrClient, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DelegatingHttpSolrClient.<init>(HttpSolrClient, String)"})
  public void testNewDelegatingHttpSolrClient() {
    // Arrange
    Builder withConnectionTimeoutResult = (new Builder()).withBaseSolrUrl("https://example.org/example")
        .allowCompression(true)
        .withConnectionTimeout(10);
    Builder withHttpClientResult = withConnectionTimeoutResult.withHttpClient(new AutoRetryHttpClient());
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
   * Test {@link DelegatingHttpSolrClient#DelegatingHttpSolrClient(HttpSolrClient)}.
   * <ul>
   *   <li>Then return DefaultCollection is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DelegatingHttpSolrClient#DelegatingHttpSolrClient(HttpSolrClient)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DelegatingHttpSolrClient.<init>(HttpSolrClient)"})
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
   * Test {@link DelegatingHttpSolrClient#DelegatingHttpSolrClient(HttpSolrClient, String)}.
   * <ul>
   *   <li>When empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link DelegatingHttpSolrClient#DelegatingHttpSolrClient(HttpSolrClient, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DelegatingHttpSolrClient.<init>(HttpSolrClient, String)"})
  public void testNewDelegatingHttpSolrClient_whenEmptyString() {
    // Arrange
    Builder withConnectionTimeoutResult = (new Builder()).withBaseSolrUrl("https://example.org/example")
        .allowCompression(true)
        .withConnectionTimeout(10);
    Builder withHttpClientResult = withConnectionTimeoutResult.withHttpClient(new AutoRetryHttpClient());
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
   * Test {@link DelegatingHttpSolrClient#DelegatingHttpSolrClient(HttpSolrClient, String)}.
   * <ul>
   *   <li>When {@link HttpSolrClient}.</li>
   *   <li>Then return Binder is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DelegatingHttpSolrClient#DelegatingHttpSolrClient(HttpSolrClient, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DelegatingHttpSolrClient.<init>(HttpSolrClient, String)"})
  public void testNewDelegatingHttpSolrClient_whenHttpSolrClient_thenReturnBinderIsNull()
      throws IOException, SolrServerException {
    // Arrange
    HttpSolrClient delegate = mock(HttpSolrClient.class);

    // Act
    DelegatingHttpSolrClient actualDelegatingHttpSolrClient = new DelegatingHttpSolrClient(delegate, null);

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
   * Test {@link DelegatingHttpSolrClient#DelegatingHttpSolrClient(HttpSolrClient, String)}.
   * <ul>
   *   <li>When space.</li>
   *   <li>Then return DefaultCollection is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DelegatingHttpSolrClient#DelegatingHttpSolrClient(HttpSolrClient, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DelegatingHttpSolrClient.<init>(HttpSolrClient, String)"})
  public void testNewDelegatingHttpSolrClient_whenSpace_thenReturnDefaultCollectionIsNull() {
    // Arrange
    Builder withConnectionTimeoutResult = (new Builder()).withBaseSolrUrl("https://example.org/example")
        .allowCompression(true)
        .withConnectionTimeout(10);
    Builder withHttpClientResult = withConnectionTimeoutResult.withHttpClient(new AutoRetryHttpClient());
    HttpSolrClient delegate = withHttpClientResult.withResponseParser(new BinaryResponseParser())
        .withSocketTimeout(10)
        .build();

    // Act
    DelegatingHttpSolrClient actualDelegatingHttpSolrClient = new DelegatingHttpSolrClient(delegate, " ");

    // Assert
    assertNull(actualDelegatingHttpSolrClient.getDefaultCollection());
    assertNull(actualDelegatingHttpSolrClient.defaultCollectionPath);
    assertSame(delegate, actualDelegatingHttpSolrClient.getDelegate());
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DelegatingHttpSolrClient.getDefaultCollection()",
      "HttpSolrClient DelegatingHttpSolrClient.getDelegate()"})
  public void testGettersAndSetters() {
    // Arrange
    Builder withConnectionTimeoutResult = (new Builder()).withBaseSolrUrl("https://example.org/example")
        .allowCompression(true)
        .withConnectionTimeout(10);
    Builder withHttpClientResult = withConnectionTimeoutResult.withHttpClient(new AutoRetryHttpClient());
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
