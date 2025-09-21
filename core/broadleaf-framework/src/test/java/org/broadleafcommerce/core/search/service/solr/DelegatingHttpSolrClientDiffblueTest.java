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

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.UpdateResponse;
import org.apache.solr.common.SolrInputDocument;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mockito.Mockito;

public class DelegatingHttpSolrClientDiffblueTest {
  /**
   * Test {@link DelegatingHttpSolrClient#DelegatingHttpSolrClient(HttpSolrClient)}.
   *
   * <ul>
   *   <li>Then return DefaultCollection is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DelegatingHttpSolrClient#DelegatingHttpSolrClient(HttpSolrClient)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DelegatingHttpSolrClient.<init>(HttpSolrClient)"})
  public void testNewDelegatingHttpSolrClient_thenReturnDefaultCollectionIsNull()
      throws IOException, SolrServerException {
    // Arrange
    HttpSolrClient delegate = mock(HttpSolrClient.class);

    // Act
    DelegatingHttpSolrClient actualDelegatingHttpSolrClient =
        new DelegatingHttpSolrClient(delegate);

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
   * Test {@link DelegatingHttpSolrClient#add(String, SolrInputDocument, int)} with {@code
   * collection}, {@code doc}, {@code commitWithinMs}.
   *
   * <ul>
   *   <li>Then calls {@link HttpSolrClient#add(SolrInputDocument, int)}.
   * </ul>
   *
   * <p>Method under test: {@link DelegatingHttpSolrClient#add(String, SolrInputDocument, int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"UpdateResponse DelegatingHttpSolrClient.add(String, SolrInputDocument, int)"})
  public void testAddWithCollectionDocCommitWithinMs_thenCallsAdd()
      throws IOException, SolrServerException {
    // Arrange
    HttpSolrClient delegate = mock(HttpSolrClient.class);
    UpdateResponse updateResponse = new UpdateResponse();
    when(delegate.add(Mockito.<SolrInputDocument>any(), anyInt())).thenReturn(updateResponse);
    doNothing().when(delegate).setBaseURL(Mockito.<String>any());
    delegate.setBaseURL("https://example.org/example");

    // Act
    UpdateResponse actualAddResult =
        new DelegatingHttpSolrClient(delegate).add(" ", (SolrInputDocument) null, 2);

    // Assert
    verify(delegate).add((SolrInputDocument) isNull(), eq(2));
    verify(delegate).setBaseURL("https://example.org/example");
    assertSame(updateResponse, actualAddResult);
  }

  /**
   * Test {@link DelegatingHttpSolrClient#add(String, SolrInputDocument, int)} with {@code
   * collection}, {@code doc}, {@code commitWithinMs}.
   *
   * <ul>
   *   <li>Then calls {@link HttpSolrClient#add(String, SolrInputDocument, int)}.
   * </ul>
   *
   * <p>Method under test: {@link DelegatingHttpSolrClient#add(String, SolrInputDocument, int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"UpdateResponse DelegatingHttpSolrClient.add(String, SolrInputDocument, int)"})
  public void testAddWithCollectionDocCommitWithinMs_thenCallsAdd2()
      throws IOException, SolrServerException {
    // Arrange
    HttpSolrClient delegate = mock(HttpSolrClient.class);
    UpdateResponse updateResponse = new UpdateResponse();
    when(delegate.add(Mockito.<String>any(), Mockito.<SolrInputDocument>any(), anyInt()))
        .thenReturn(updateResponse);
    when(delegate.getBaseURL()).thenReturn("https://example.org/example");
    doNothing().when(delegate).setBaseURL(Mockito.<String>any());
    delegate.setBaseURL("https://example.org/example");

    // Act
    UpdateResponse actualAddResult =
        new DelegatingHttpSolrClient(delegate)
            .add("https://example.org/example", (SolrInputDocument) null, 2);

    // Assert
    verify(delegate).add(eq("https://example.org/example"), (SolrInputDocument) isNull(), eq(2));
    verify(delegate).getBaseURL();
    verify(delegate).setBaseURL("https://example.org/example");
    assertSame(updateResponse, actualAddResult);
  }

  /**
   * Test {@link DelegatingHttpSolrClient#add(String, SolrInputDocument)} with {@code collection},
   * {@code doc}.
   *
   * <ul>
   *   <li>Given {@link HttpSolrClient} {@link HttpSolrClient#add(SolrInputDocument)} return {@link
   *       UpdateResponse} (default constructor).
   *   <li>Then calls {@link HttpSolrClient#add(SolrInputDocument)}.
   * </ul>
   *
   * <p>Method under test: {@link DelegatingHttpSolrClient#add(String, SolrInputDocument)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"UpdateResponse DelegatingHttpSolrClient.add(String, SolrInputDocument)"})
  public void testAddWithCollectionDoc_givenHttpSolrClientAddReturnUpdateResponse_thenCallsAdd()
      throws IOException, SolrServerException {
    // Arrange
    HttpSolrClient delegate = mock(HttpSolrClient.class);
    UpdateResponse updateResponse = new UpdateResponse();
    when(delegate.add(Mockito.<SolrInputDocument>any())).thenReturn(updateResponse);
    doNothing().when(delegate).setBaseURL(Mockito.<String>any());
    delegate.setBaseURL("https://example.org/example");

    // Act
    UpdateResponse actualAddResult =
        new DelegatingHttpSolrClient(delegate).add(" ", (SolrInputDocument) null);

    // Assert
    verify(delegate).add((SolrInputDocument) isNull());
    verify(delegate).setBaseURL("https://example.org/example");
    assertSame(updateResponse, actualAddResult);
  }

  /**
   * Test {@link DelegatingHttpSolrClient#add(String, SolrInputDocument)} with {@code collection},
   * {@code doc}.
   *
   * <ul>
   *   <li>Given {@link HttpSolrClient} {@link HttpSolrClient#add(String, SolrInputDocument)} return
   *       {@link UpdateResponse} (default constructor).
   *   <li>Then calls {@link HttpSolrClient#add(String, SolrInputDocument)}.
   * </ul>
   *
   * <p>Method under test: {@link DelegatingHttpSolrClient#add(String, SolrInputDocument)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"UpdateResponse DelegatingHttpSolrClient.add(String, SolrInputDocument)"})
  public void testAddWithCollectionDoc_givenHttpSolrClientAddReturnUpdateResponse_thenCallsAdd2()
      throws IOException, SolrServerException {
    // Arrange
    HttpSolrClient delegate = mock(HttpSolrClient.class);
    UpdateResponse updateResponse = new UpdateResponse();
    when(delegate.add(Mockito.<String>any(), Mockito.<SolrInputDocument>any()))
        .thenReturn(updateResponse);
    when(delegate.getBaseURL()).thenReturn("https://example.org/example");
    doNothing().when(delegate).setBaseURL(Mockito.<String>any());
    delegate.setBaseURL("https://example.org/example");

    // Act
    UpdateResponse actualAddResult =
        new DelegatingHttpSolrClient(delegate)
            .add("https://example.org/example", (SolrInputDocument) null);

    // Assert
    verify(delegate).add(eq("https://example.org/example"), (SolrInputDocument) isNull());
    verify(delegate).getBaseURL();
    verify(delegate).setBaseURL("https://example.org/example");
    assertSame(updateResponse, actualAddResult);
  }

  /**
   * Test {@link DelegatingHttpSolrClient#addBean(String, Object, int)} with {@code collection},
   * {@code obj}, {@code commitWithinMs}.
   *
   * <ul>
   *   <li>Then calls {@link HttpSolrClient#addBean(Object, int)}.
   * </ul>
   *
   * <p>Method under test: {@link DelegatingHttpSolrClient#addBean(String, Object, int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"UpdateResponse DelegatingHttpSolrClient.addBean(String, Object, int)"})
  public void testAddBeanWithCollectionObjCommitWithinMs_thenCallsAddBean()
      throws IOException, SolrServerException {
    // Arrange
    HttpSolrClient delegate = mock(HttpSolrClient.class);
    UpdateResponse updateResponse = new UpdateResponse();
    when(delegate.addBean(Mockito.<Object>any(), anyInt())).thenReturn(updateResponse);
    doNothing().when(delegate).setBaseURL(Mockito.<String>any());
    delegate.setBaseURL("https://example.org/example");

    // Act
    UpdateResponse actualAddBeanResult =
        new DelegatingHttpSolrClient(delegate).addBean(" ", "Obj", 2);

    // Assert
    verify(delegate).addBean(isA(Object.class), eq(2));
    verify(delegate).setBaseURL("https://example.org/example");
    assertSame(updateResponse, actualAddBeanResult);
  }

  /**
   * Test {@link DelegatingHttpSolrClient#addBean(String, Object, int)} with {@code collection},
   * {@code obj}, {@code commitWithinMs}.
   *
   * <ul>
   *   <li>Then calls {@link HttpSolrClient#addBean(String, Object, int)}.
   * </ul>
   *
   * <p>Method under test: {@link DelegatingHttpSolrClient#addBean(String, Object, int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"UpdateResponse DelegatingHttpSolrClient.addBean(String, Object, int)"})
  public void testAddBeanWithCollectionObjCommitWithinMs_thenCallsAddBean2()
      throws IOException, SolrServerException {
    // Arrange
    HttpSolrClient delegate = mock(HttpSolrClient.class);
    UpdateResponse updateResponse = new UpdateResponse();
    when(delegate.addBean(Mockito.<String>any(), Mockito.<Object>any(), anyInt()))
        .thenReturn(updateResponse);
    when(delegate.getBaseURL()).thenReturn("https://example.org/example");
    doNothing().when(delegate).setBaseURL(Mockito.<String>any());
    delegate.setBaseURL("https://example.org/example");

    // Act
    UpdateResponse actualAddBeanResult =
        new DelegatingHttpSolrClient(delegate).addBean("https://example.org/example", "Obj", 2);

    // Assert
    verify(delegate).addBean(eq("https://example.org/example"), isA(Object.class), eq(2));
    verify(delegate).getBaseURL();
    verify(delegate).setBaseURL("https://example.org/example");
    assertSame(updateResponse, actualAddBeanResult);
  }

  /**
   * Test {@link DelegatingHttpSolrClient#addBean(String, Object)} with {@code collection}, {@code
   * obj}.
   *
   * <ul>
   *   <li>Then calls {@link HttpSolrClient#addBean(Object)}.
   * </ul>
   *
   * <p>Method under test: {@link DelegatingHttpSolrClient#addBean(String, Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"UpdateResponse DelegatingHttpSolrClient.addBean(String, Object)"})
  public void testAddBeanWithCollectionObj_thenCallsAddBean()
      throws IOException, SolrServerException {
    // Arrange
    HttpSolrClient delegate = mock(HttpSolrClient.class);
    UpdateResponse updateResponse = new UpdateResponse();
    when(delegate.addBean(Mockito.<Object>any())).thenReturn(updateResponse);
    doNothing().when(delegate).setBaseURL(Mockito.<String>any());
    delegate.setBaseURL("https://example.org/example");

    // Act
    UpdateResponse actualAddBeanResult = new DelegatingHttpSolrClient(delegate).addBean(" ", "Obj");

    // Assert
    verify(delegate).addBean(isA(Object.class));
    verify(delegate).setBaseURL("https://example.org/example");
    assertSame(updateResponse, actualAddBeanResult);
  }

  /**
   * Test {@link DelegatingHttpSolrClient#addBean(String, Object)} with {@code collection}, {@code
   * obj}.
   *
   * <ul>
   *   <li>Then calls {@link HttpSolrClient#addBean(String, Object)}.
   * </ul>
   *
   * <p>Method under test: {@link DelegatingHttpSolrClient#addBean(String, Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"UpdateResponse DelegatingHttpSolrClient.addBean(String, Object)"})
  public void testAddBeanWithCollectionObj_thenCallsAddBean2()
      throws IOException, SolrServerException {
    // Arrange
    HttpSolrClient delegate = mock(HttpSolrClient.class);
    UpdateResponse updateResponse = new UpdateResponse();
    when(delegate.addBean(Mockito.<String>any(), Mockito.<Object>any())).thenReturn(updateResponse);
    when(delegate.getBaseURL()).thenReturn("https://example.org/example");
    doNothing().when(delegate).setBaseURL(Mockito.<String>any());
    delegate.setBaseURL("https://example.org/example");

    // Act
    UpdateResponse actualAddBeanResult =
        new DelegatingHttpSolrClient(delegate).addBean("https://example.org/example", "Obj");

    // Assert
    verify(delegate).addBean(eq("https://example.org/example"), isA(Object.class));
    verify(delegate).getBaseURL();
    verify(delegate).setBaseURL("https://example.org/example");
    assertSame(updateResponse, actualAddBeanResult);
  }
}
