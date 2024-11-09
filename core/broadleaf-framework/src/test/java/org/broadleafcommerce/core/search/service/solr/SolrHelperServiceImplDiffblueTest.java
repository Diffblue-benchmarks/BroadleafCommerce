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
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.embedded.SSLConfig;
import org.apache.solr.client.solrj.impl.Http2SolrClient;
import org.apache.solr.client.solrj.impl.LBHttp2SolrClient;
import org.apache.solr.client.solrj.response.GroupCommand;
import org.apache.solr.client.solrj.response.GroupResponse;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.client.solrj.response.UpdateResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrInputDocument;
import org.broadleafcommerce.common.exception.ServiceException;
import org.broadleafcommerce.core.catalog.domain.Indexable;
import org.broadleafcommerce.core.catalog.domain.ProductBundleImpl;
import org.broadleafcommerce.core.catalog.domain.SkuImpl;
import org.broadleafcommerce.core.search.domain.Field;
import org.broadleafcommerce.core.search.domain.FieldImpl;
import org.broadleafcommerce.core.search.domain.IndexField;
import org.broadleafcommerce.core.search.domain.IndexFieldImpl;
import org.broadleafcommerce.core.search.domain.RequiredFacet;
import org.broadleafcommerce.core.search.domain.RequiredFacetImpl;
import org.broadleafcommerce.core.search.domain.SearchCriteria;
import org.broadleafcommerce.core.search.domain.SearchFacet;
import org.broadleafcommerce.core.search.domain.SearchFacetDTO;
import org.broadleafcommerce.core.search.domain.SearchFacetImpl;
import org.broadleafcommerce.core.search.domain.SearchFacetRange;
import org.broadleafcommerce.core.search.domain.SearchFacetRangeImpl;
import org.junit.Test;
import org.mockito.Mockito;
import org.mvel2.util.InternalNumber;

public class SolrHelperServiceImplDiffblueTest {
  /**
   * Test {@link SolrHelperServiceImpl#swapActiveCores(SolrConfiguration)}.
   * <ul>
   *   <li>Given {@link UpdateResponse} (default constructor).</li>
   *   <li>Then calls {@link SolrClient#add(String, Collection)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SolrHelperServiceImpl#swapActiveCores(SolrConfiguration)}
   */
  @Test
  public void testSwapActiveCores_givenUpdateResponse_thenCallsAdd()
      throws IOException, IllegalStateException, SolrServerException, ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SolrHelperServiceImpl solrHelperServiceImpl = new SolrHelperServiceImpl();
    LBHttp2SolrClient reindexServer = mock(LBHttp2SolrClient.class);
    when(reindexServer.add(Mockito.<String>any(), Mockito.<Collection<SolrInputDocument>>any()))
        .thenReturn(new UpdateResponse());
    reindexServer.add("Collection", new ArrayList<>());
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
    solrHelperServiceImpl.swapActiveCores(new SolrConfiguration(solrServer, reindexServer,
        new LBHttp2SolrClient(httpClient5, "https://example.org/example")));

    // Assert that nothing has changed
    verify(reindexServer).add(eq("Collection"), isA(Collection.class));
  }

  /**
   * Test {@link SolrHelperServiceImpl#convertPrefixListToString(List)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.</li>
   *   <li>Then return {@code 42_foo_}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SolrHelperServiceImpl#convertPrefixListToString(List)}
   */
  @Test
  public void testConvertPrefixListToString_given42_whenArrayListAdd42_thenReturn42Foo() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SolrHelperServiceImpl solrHelperServiceImpl = new SolrHelperServiceImpl();

    ArrayList<String> prefixList = new ArrayList<>();
    prefixList.add("42");
    prefixList.add("foo");

    // Act and Assert
    assertEquals("42_foo_", solrHelperServiceImpl.convertPrefixListToString(prefixList));
  }

  /**
   * Test {@link SolrHelperServiceImpl#convertPrefixListToString(List)}.
   * <ul>
   *   <li>Given empty string.</li>
   *   <li>When {@link ArrayList#ArrayList()} add empty string.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SolrHelperServiceImpl#convertPrefixListToString(List)}
   */
  @Test
  public void testConvertPrefixListToString_givenEmptyString_whenArrayListAddEmptyString() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SolrHelperServiceImpl solrHelperServiceImpl = new SolrHelperServiceImpl();

    ArrayList<String> prefixList = new ArrayList<>();
    prefixList.add("");

    // Act and Assert
    assertEquals("", solrHelperServiceImpl.convertPrefixListToString(prefixList));
  }

  /**
   * Test {@link SolrHelperServiceImpl#convertPrefixListToString(List)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SolrHelperServiceImpl#convertPrefixListToString(List)}
   */
  @Test
  public void testConvertPrefixListToString_givenNull_whenArrayListAddNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SolrHelperServiceImpl solrHelperServiceImpl = new SolrHelperServiceImpl();

    ArrayList<String> prefixList = new ArrayList<>();
    prefixList.add(null);

    // Act and Assert
    assertEquals("", solrHelperServiceImpl.convertPrefixListToString(prefixList));
  }

  /**
   * Test {@link SolrHelperServiceImpl#convertPrefixListToString(List)}.
   * <ul>
   *   <li>Given {@code Prefix List}.</li>
   *   <li>Then return {@code Prefix List_}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SolrHelperServiceImpl#convertPrefixListToString(List)}
   */
  @Test
  public void testConvertPrefixListToString_givenPrefixList_thenReturnPrefixList() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SolrHelperServiceImpl solrHelperServiceImpl = new SolrHelperServiceImpl();

    ArrayList<String> prefixList = new ArrayList<>();
    prefixList.add("Prefix List");

    // Act and Assert
    assertEquals("Prefix List_", solrHelperServiceImpl.convertPrefixListToString(prefixList));
  }

  /**
   * Test {@link SolrHelperServiceImpl#convertPrefixListToString(List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SolrHelperServiceImpl#convertPrefixListToString(List)}
   */
  @Test
  public void testConvertPrefixListToString_whenArrayList_thenReturnEmptyString() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SolrHelperServiceImpl solrHelperServiceImpl = new SolrHelperServiceImpl();

    // Act and Assert
    assertEquals("", solrHelperServiceImpl.convertPrefixListToString(new ArrayList<>()));
  }

  /**
   * Test {@link SolrHelperServiceImpl#getPrimaryDocumentType()}.
   * <p>
   * Method under test: {@link SolrHelperServiceImpl#getPrimaryDocumentType()}
   */
  @Test
  public void testGetPrimaryDocumentType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("PRODUCT", (new SolrHelperServiceImpl()).getPrimaryDocumentType());
  }

  /**
   * Test {@link SolrHelperServiceImpl#getCurrentProductId(Indexable)}.
   * <ul>
   *   <li>When {@link ProductBundleImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SolrHelperServiceImpl#getCurrentProductId(Indexable)}
   */
  @Test
  public void testGetCurrentProductId_whenProductBundleImpl_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SolrHelperServiceImpl solrHelperServiceImpl = new SolrHelperServiceImpl();

    // Act and Assert
    assertNull(solrHelperServiceImpl.getCurrentProductId(new ProductBundleImpl()));
  }

  /**
   * Test {@link SolrHelperServiceImpl#getProductForIndexable(Indexable)}.
   * <ul>
   *   <li>When {@link ProductBundleImpl} (default constructor).</li>
   *   <li>Then return {@link ProductBundleImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SolrHelperServiceImpl#getProductForIndexable(Indexable)}
   */
  @Test
  public void testGetProductForIndexable_whenProductBundleImpl_thenReturnProductBundleImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SolrHelperServiceImpl solrHelperServiceImpl = new SolrHelperServiceImpl();
    ProductBundleImpl indexable = new ProductBundleImpl();

    // Act and Assert
    assertSame(indexable, solrHelperServiceImpl.getProductForIndexable(indexable));
  }

  /**
   * Test {@link SolrHelperServiceImpl#getProductForIndexable(Indexable)}.
   * <ul>
   *   <li>When {@link SkuImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SolrHelperServiceImpl#getProductForIndexable(Indexable)}
   */
  @Test
  public void testGetProductForIndexable_whenSkuImpl_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SolrHelperServiceImpl solrHelperServiceImpl = new SolrHelperServiceImpl();

    // Act and Assert
    assertNull(solrHelperServiceImpl.getProductForIndexable(new SkuImpl()));
  }

  /**
   * Test {@link SolrHelperServiceImpl#getTypeFieldName()}.
   * <p>
   * Method under test: {@link SolrHelperServiceImpl#getTypeFieldName()}
   */
  @Test
  public void testGetTypeFieldName() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("type_s", (new SolrHelperServiceImpl()).getTypeFieldName());
  }

  /**
   * Test {@link SolrHelperServiceImpl#getDocumentType(Indexable)}.
   * <ul>
   *   <li>When {@link ProductBundleImpl} (default constructor).</li>
   *   <li>Then return {@code PRODUCT}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrHelperServiceImpl#getDocumentType(Indexable)}
   */
  @Test
  public void testGetDocumentType_whenProductBundleImpl_thenReturnProduct() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SolrHelperServiceImpl solrHelperServiceImpl = new SolrHelperServiceImpl();

    // Act and Assert
    assertEquals("PRODUCT", solrHelperServiceImpl.getDocumentType(new ProductBundleImpl()));
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link SolrHelperServiceImpl#getCatalogFieldName()}
   *   <li>{@link SolrHelperServiceImpl#getCatalogOverridesFieldName()}
   *   <li>{@link SolrHelperServiceImpl#getCategoryFieldName()}
   *   <li>{@link SolrHelperServiceImpl#getExplicitCategoryFieldName()}
   *   <li>{@link SolrHelperServiceImpl#getGlobalFacetTagField()}
   *   <li>{@link SolrHelperServiceImpl#getIdFieldName()}
   *   <li>{@link SolrHelperServiceImpl#getIndexableIdFieldName()}
   *   <li>{@link SolrHelperServiceImpl#getNamespaceFieldName()}
   *   <li>{@link SolrHelperServiceImpl#getSandBoxChangeTypeFieldName()}
   *   <li>{@link SolrHelperServiceImpl#getSandBoxFieldName()}
   *   <li>{@link SolrHelperServiceImpl#getSandBoxPriorityFieldName()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    SolrHelperServiceImpl solrHelperServiceImpl = new SolrHelperServiceImpl();

    // Act
    String actualCatalogFieldName = solrHelperServiceImpl.getCatalogFieldName();
    String actualCatalogOverridesFieldName = solrHelperServiceImpl.getCatalogOverridesFieldName();
    String actualCategoryFieldName = solrHelperServiceImpl.getCategoryFieldName();
    String actualExplicitCategoryFieldName = solrHelperServiceImpl.getExplicitCategoryFieldName();
    String actualGlobalFacetTagField = solrHelperServiceImpl.getGlobalFacetTagField();
    String actualIdFieldName = solrHelperServiceImpl.getIdFieldName();
    String actualIndexableIdFieldName = solrHelperServiceImpl.getIndexableIdFieldName();
    String actualNamespaceFieldName = solrHelperServiceImpl.getNamespaceFieldName();
    String actualSandBoxChangeTypeFieldName = solrHelperServiceImpl.getSandBoxChangeTypeFieldName();
    String actualSandBoxFieldName = solrHelperServiceImpl.getSandBoxFieldName();

    // Assert
    assertEquals("a", actualGlobalFacetTagField);
    assertEquals("catalog_overrides", actualCatalogOverridesFieldName);
    assertEquals("catalog_s", actualCatalogFieldName);
    assertEquals("category", actualCategoryFieldName);
    assertEquals("explicitCategory", actualExplicitCategoryFieldName);
    assertEquals("id", actualIdFieldName);
    assertEquals("namespace", actualNamespaceFieldName);
    assertEquals("productId", actualIndexableIdFieldName);
    assertEquals("sandboxChangeType_s", actualSandBoxChangeTypeFieldName);
    assertEquals("sandboxId", actualSandBoxFieldName);
    assertEquals("sandboxPriority", solrHelperServiceImpl.getSandBoxPriorityFieldName());
  }

  /**
   * Test {@link SolrHelperServiceImpl#getPropertyValue(Object, Field)} with
   * {@code object}, {@code field}.
   * <ul>
   *   <li>Given {@code Property Name}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SolrHelperServiceImpl#getPropertyValue(Object, Field)}
   */
  @Test
  public void testGetPropertyValueWithObjectField_givenPropertyName_thenReturnNull()
      throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SolrHelperServiceImpl solrHelperServiceImpl = new SolrHelperServiceImpl();
    FieldImpl field = mock(FieldImpl.class);
    when(field.getPropertyName()).thenReturn("Property Name");

    // Act
    Object actualPropertyValue = solrHelperServiceImpl.getPropertyValue("Object", field);

    // Assert
    verify(field).getPropertyName();
    assertNull(actualPropertyValue);
  }

  /**
   * Test {@link SolrHelperServiceImpl#getPropertyValue(Object, Field)} with
   * {@code object}, {@code field}.
   * <ul>
   *   <li>Given {@code Property Name}.</li>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SolrHelperServiceImpl#getPropertyValue(Object, Field)}
   */
  @Test
  public void testGetPropertyValueWithObjectField_givenPropertyName_whenNull_thenReturnNull()
      throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SolrHelperServiceImpl solrHelperServiceImpl = new SolrHelperServiceImpl();
    FieldImpl field = mock(FieldImpl.class);
    when(field.getPropertyName()).thenReturn("Property Name");

    // Act
    Object actualPropertyValue = solrHelperServiceImpl.getPropertyValue(null, field);

    // Assert
    verify(field).getPropertyName();
    assertNull(actualPropertyValue);
  }

  /**
   * Test {@link SolrHelperServiceImpl#getPropertyValue(Object, String)} with
   * {@code object}, {@code propertyName}.
   * <ul>
   *   <li>When {@code \.}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SolrHelperServiceImpl#getPropertyValue(Object, String)}
   */
  @Test
  public void testGetPropertyValueWithObjectPropertyName_whenBackslashDot_thenReturnNull()
      throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new SolrHelperServiceImpl()).getPropertyValue("\\.", "Property Name"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#getPropertyValue(Object, String)} with
   * {@code object}, {@code propertyName}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SolrHelperServiceImpl#getPropertyValue(Object, String)}
   */
  @Test
  public void testGetPropertyValueWithObjectPropertyName_whenNull_thenReturnNull()
      throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new SolrHelperServiceImpl()).getPropertyValue(null, "Property Name"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#getPropertyValue(Object, String)} with
   * {@code object}, {@code propertyName}.
   * <ul>
   *   <li>When {@code Object}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SolrHelperServiceImpl#getPropertyValue(Object, String)}
   */
  @Test
  public void testGetPropertyValueWithObjectPropertyName_whenObject_thenReturnNull()
      throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new SolrHelperServiceImpl()).getPropertyValue("Object", "Property Name"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   * <p>
   * Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  public void testScrubFacetValue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("\\\\\\||", (new SolrHelperServiceImpl()).scrubFacetValue("\\||"));
    assertEquals("\\\\\\\\\\?", (new SolrHelperServiceImpl()).scrubFacetValue("\\\\?"));
    assertEquals("\\+\\\\\\?", (new SolrHelperServiceImpl()).scrubFacetValue("+\\?"));
    assertEquals("\\-\\\\\\?", (new SolrHelperServiceImpl()).scrubFacetValue("-\\?"));
    assertEquals("\\&&\\&&", (new SolrHelperServiceImpl()).scrubFacetValue("&&&&"));
    assertEquals("\\&&\\||", (new SolrHelperServiceImpl()).scrubFacetValue("&&||"));
    assertEquals("\\&&\\!", (new SolrHelperServiceImpl()).scrubFacetValue("&&!"));
    assertEquals("\\&&\\(", (new SolrHelperServiceImpl()).scrubFacetValue("&&("));
    assertEquals("\\&&\\)", (new SolrHelperServiceImpl()).scrubFacetValue("&&)"));
    assertEquals("\\&&\\{", (new SolrHelperServiceImpl()).scrubFacetValue("&&{"));
    assertEquals("\\&&\\\\\\?", (new SolrHelperServiceImpl()).scrubFacetValue("&&\\?"));
    assertEquals("\\&&\\}", (new SolrHelperServiceImpl()).scrubFacetValue("&&}"));
    assertEquals("\\&&\\]", (new SolrHelperServiceImpl()).scrubFacetValue("&&]"));
    assertEquals("\\&&\\[", (new SolrHelperServiceImpl()).scrubFacetValue("&&["));
    assertEquals("\\||\\\\", (new SolrHelperServiceImpl()).scrubFacetValue("||\\"));
    assertEquals("\\||\\&&", (new SolrHelperServiceImpl()).scrubFacetValue("||&&"));
    assertEquals("\\||\\||", (new SolrHelperServiceImpl()).scrubFacetValue("||||"));
    assertEquals("\\||\\!", (new SolrHelperServiceImpl()).scrubFacetValue("||!"));
    assertEquals("\\||\\(", (new SolrHelperServiceImpl()).scrubFacetValue("||("));
    assertEquals("\\||\\)", (new SolrHelperServiceImpl()).scrubFacetValue("||)"));
    assertEquals("\\||\\{", (new SolrHelperServiceImpl()).scrubFacetValue("||{"));
    assertEquals("\\||\\\\\\?", (new SolrHelperServiceImpl()).scrubFacetValue("||\\?"));
    assertEquals("\\||\\}", (new SolrHelperServiceImpl()).scrubFacetValue("||}"));
    assertEquals("\\||\\]", (new SolrHelperServiceImpl()).scrubFacetValue("||]"));
    assertEquals("\\||\\[", (new SolrHelperServiceImpl()).scrubFacetValue("||["));
    assertEquals("\\!\\&&", (new SolrHelperServiceImpl()).scrubFacetValue("!&&"));
    assertEquals("\\!\\||", (new SolrHelperServiceImpl()).scrubFacetValue("!||"));
    assertEquals("\\!\\\\\\?", (new SolrHelperServiceImpl()).scrubFacetValue("!\\?"));
    assertEquals("\\!\\]", (new SolrHelperServiceImpl()).scrubFacetValue("!]"));
    assertEquals("\\(\\&&", (new SolrHelperServiceImpl()).scrubFacetValue("(&&"));
    assertEquals("\\(\\||", (new SolrHelperServiceImpl()).scrubFacetValue("(||"));
    assertEquals("\\(\\\\\\?", (new SolrHelperServiceImpl()).scrubFacetValue("(\\?"));
    assertEquals("\\(\\]", (new SolrHelperServiceImpl()).scrubFacetValue("(]"));
    assertEquals("\\*\\\\\\?", (new SolrHelperServiceImpl()).scrubFacetValue("*\\?"));
    assertEquals("\\)\\&&", (new SolrHelperServiceImpl()).scrubFacetValue(")&&"));
    assertEquals("\\)\\||", (new SolrHelperServiceImpl()).scrubFacetValue(")||"));
    assertEquals("\\)\\\\\\?", (new SolrHelperServiceImpl()).scrubFacetValue(")\\?"));
    assertEquals("\\)\\}", (new SolrHelperServiceImpl()).scrubFacetValue(")}"));
    assertEquals("\\)\\]", (new SolrHelperServiceImpl()).scrubFacetValue(")]"));
    assertEquals("\\)\\[", (new SolrHelperServiceImpl()).scrubFacetValue(")["));
    assertEquals("\\:\\\\\\?", (new SolrHelperServiceImpl()).scrubFacetValue(":\\?"));
    assertEquals("\\{\\&&", (new SolrHelperServiceImpl()).scrubFacetValue("{&&"));
    assertEquals("\\{\\||", (new SolrHelperServiceImpl()).scrubFacetValue("{||"));
    assertEquals("\\{\\\\\\?", (new SolrHelperServiceImpl()).scrubFacetValue("{\\?"));
    assertEquals("\\{\\}", (new SolrHelperServiceImpl()).scrubFacetValue("{}"));
    assertEquals("\\{\\]", (new SolrHelperServiceImpl()).scrubFacetValue("{]"));
    assertEquals("\\{\\[", (new SolrHelperServiceImpl()).scrubFacetValue("{["));
    assertEquals("\\\\\\?\\\\", (new SolrHelperServiceImpl()).scrubFacetValue("\\?\\"));
    assertEquals("\\\\\\?\\+", (new SolrHelperServiceImpl()).scrubFacetValue("\\?+"));
    assertEquals("\\\\\\?\\-", (new SolrHelperServiceImpl()).scrubFacetValue("\\?-"));
    assertEquals("\\\\\\?\\&&", (new SolrHelperServiceImpl()).scrubFacetValue("\\?&&"));
    assertEquals("\\\\\\?\\||", (new SolrHelperServiceImpl()).scrubFacetValue("\\?||"));
    assertEquals("\\\\\\?\\!", (new SolrHelperServiceImpl()).scrubFacetValue("\\?!"));
    assertEquals("\\\\\\?\\(", (new SolrHelperServiceImpl()).scrubFacetValue("\\?("));
    assertEquals("\\\\\\?\\*", (new SolrHelperServiceImpl()).scrubFacetValue("\\?*"));
    assertEquals("\\\\\\?\\)", (new SolrHelperServiceImpl()).scrubFacetValue("\\?)"));
    assertEquals("\\\\\\?\\:", (new SolrHelperServiceImpl()).scrubFacetValue("\\?:"));
    assertEquals("\\\\\\?\\{", (new SolrHelperServiceImpl()).scrubFacetValue("\\?{"));
    assertEquals("\\\\\\?\\\\\\?", (new SolrHelperServiceImpl()).scrubFacetValue("\\?\\?"));
    assertEquals("\\\\\\?\\}", (new SolrHelperServiceImpl()).scrubFacetValue("\\?}"));
    assertEquals("\\\\\\?\\]", (new SolrHelperServiceImpl()).scrubFacetValue("\\?]"));
    assertEquals("\\\\\\?\\[", (new SolrHelperServiceImpl()).scrubFacetValue("\\?["));
    assertEquals("\\}\\&&", (new SolrHelperServiceImpl()).scrubFacetValue("}&&"));
    assertEquals("\\}\\||", (new SolrHelperServiceImpl()).scrubFacetValue("}||"));
    assertEquals("\\}\\)", (new SolrHelperServiceImpl()).scrubFacetValue("})"));
    assertEquals("\\}\\{", (new SolrHelperServiceImpl()).scrubFacetValue("}{"));
    assertEquals("\\}\\\\\\?", (new SolrHelperServiceImpl()).scrubFacetValue("}\\?"));
    assertEquals("\\}\\}", (new SolrHelperServiceImpl()).scrubFacetValue("}}"));
    assertEquals("\\}\\]", (new SolrHelperServiceImpl()).scrubFacetValue("}]"));
    assertEquals("\\}\\[", (new SolrHelperServiceImpl()).scrubFacetValue("}["));
    assertEquals("\\]\\&&", (new SolrHelperServiceImpl()).scrubFacetValue("]&&"));
    assertEquals("\\]\\||", (new SolrHelperServiceImpl()).scrubFacetValue("]||"));
    assertEquals("\\]\\!", (new SolrHelperServiceImpl()).scrubFacetValue("]!"));
    assertEquals("\\]\\(", (new SolrHelperServiceImpl()).scrubFacetValue("]("));
    assertEquals("\\]\\)", (new SolrHelperServiceImpl()).scrubFacetValue("])"));
    assertEquals("\\]\\{", (new SolrHelperServiceImpl()).scrubFacetValue("]{"));
    assertEquals("\\]\\\\\\?", (new SolrHelperServiceImpl()).scrubFacetValue("]\\?"));
    assertEquals("\\]\\}", (new SolrHelperServiceImpl()).scrubFacetValue("]}"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   * <ul>
   *   <li>Then return {@code \&&\*}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  public void testScrubFacetValue_thenReturnBackslashAmpersandAmpersandBackslashAsterisk() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("\\&&\\*", (new SolrHelperServiceImpl()).scrubFacetValue("&&*"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   * <ul>
   *   <li>Then return {@code \&&\\}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  public void testScrubFacetValue_thenReturnBackslashAmpersandAmpersandBackslashBackslash() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("\\&&\\\\", (new SolrHelperServiceImpl()).scrubFacetValue("&&\\"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   * <ul>
   *   <li>Then return {@code \&&\:}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  public void testScrubFacetValue_thenReturnBackslashAmpersandAmpersandBackslashColon() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("\\&&\\:", (new SolrHelperServiceImpl()).scrubFacetValue("&&:"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   * <ul>
   *   <li>Then return {@code \&&\-}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  public void testScrubFacetValue_thenReturnBackslashAmpersandAmpersandBackslashDash() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("\\&&\\-", (new SolrHelperServiceImpl()).scrubFacetValue("&&-"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   * <ul>
   *   <li>Then return {@code \&&\+}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  public void testScrubFacetValue_thenReturnBackslashAmpersandAmpersandBackslashPlusSign() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("\\&&\\+", (new SolrHelperServiceImpl()).scrubFacetValue("&&+"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   * <ul>
   *   <li>Then return {@code \*\&&}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  public void testScrubFacetValue_thenReturnBackslashAsteriskBackslashAmpersandAmpersand() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("\\*\\&&", (new SolrHelperServiceImpl()).scrubFacetValue("*&&"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   * <ul>
   *   <li>Then return {@code \*\*}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  public void testScrubFacetValue_thenReturnBackslashAsteriskBackslashAsterisk() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("\\*\\*", (new SolrHelperServiceImpl()).scrubFacetValue("**"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   * <ul>
   *   <li>Then return {@code \*\\}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  public void testScrubFacetValue_thenReturnBackslashAsteriskBackslashBackslash() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("\\*\\\\", (new SolrHelperServiceImpl()).scrubFacetValue("*\\"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   * <ul>
   *   <li>Then return {@code \*\!}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  public void testScrubFacetValue_thenReturnBackslashAsteriskBackslashExclamationMark() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("\\*\\!", (new SolrHelperServiceImpl()).scrubFacetValue("*!"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   * <ul>
   *   <li>Then return {@code \*\{}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  public void testScrubFacetValue_thenReturnBackslashAsteriskBackslashLeftCurlyBracket() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("\\*\\{", (new SolrHelperServiceImpl()).scrubFacetValue("*{"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   * <ul>
   *   <li>Then return {@code \*\(}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  public void testScrubFacetValue_thenReturnBackslashAsteriskBackslashLeftParenthesis() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("\\*\\(", (new SolrHelperServiceImpl()).scrubFacetValue("*("));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   * <ul>
   *   <li>Then return {@code \*\[}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  public void testScrubFacetValue_thenReturnBackslashAsteriskBackslashLeftSquareBracket() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("\\*\\[", (new SolrHelperServiceImpl()).scrubFacetValue("*["));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   * <ul>
   *   <li>Then return {@code \*\+}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  public void testScrubFacetValue_thenReturnBackslashAsteriskBackslashPlusSign() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("\\*\\+", (new SolrHelperServiceImpl()).scrubFacetValue("*+"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   * <ul>
   *   <li>Then return {@code \*\}}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  public void testScrubFacetValue_thenReturnBackslashAsteriskBackslashRightCurlyBracket() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("\\*\\}", (new SolrHelperServiceImpl()).scrubFacetValue("*}"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   * <ul>
   *   <li>Then return {@code \*\)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  public void testScrubFacetValue_thenReturnBackslashAsteriskBackslashRightParenthesis() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("\\*\\)", (new SolrHelperServiceImpl()).scrubFacetValue("*)"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   * <ul>
   *   <li>Then return {@code \*\]}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  public void testScrubFacetValue_thenReturnBackslashAsteriskBackslashRightSquareBracket() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("\\*\\]", (new SolrHelperServiceImpl()).scrubFacetValue("*]"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   * <ul>
   *   <li>Then return {@code \*\||}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  public void testScrubFacetValue_thenReturnBackslashAsteriskBackslashVerticalLineVerticalLine() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("\\*\\||", (new SolrHelperServiceImpl()).scrubFacetValue("*||"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   * <ul>
   *   <li>Then return {@code \\\&&}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  public void testScrubFacetValue_thenReturnBackslashBackslashBackslashAmpersandAmpersand() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("\\\\\\&&", (new SolrHelperServiceImpl()).scrubFacetValue("\\&&"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   * <ul>
   *   <li>Then return {@code \\\*}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  public void testScrubFacetValue_thenReturnBackslashBackslashBackslashAsterisk() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("\\\\\\*", (new SolrHelperServiceImpl()).scrubFacetValue("\\*"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   * <ul>
   *   <li>Then return {@code \\\\}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  public void testScrubFacetValue_thenReturnBackslashBackslashBackslashBackslash() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("\\\\\\\\", (new SolrHelperServiceImpl()).scrubFacetValue("\\\\"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   * <ul>
   *   <li>Then return {@code \\\:}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  public void testScrubFacetValue_thenReturnBackslashBackslashBackslashColon() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("\\\\\\:", (new SolrHelperServiceImpl()).scrubFacetValue("\\:"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   * <ul>
   *   <li>Then return {@code \\\!}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  public void testScrubFacetValue_thenReturnBackslashBackslashBackslashExclamationMark() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("\\\\\\!", (new SolrHelperServiceImpl()).scrubFacetValue("\\!"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   * <ul>
   *   <li>Then return {@code \\\{}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  public void testScrubFacetValue_thenReturnBackslashBackslashBackslashLeftCurlyBracket() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("\\\\\\{", (new SolrHelperServiceImpl()).scrubFacetValue("\\{"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   * <ul>
   *   <li>Then return {@code \\\(}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  public void testScrubFacetValue_thenReturnBackslashBackslashBackslashLeftParenthesis() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("\\\\\\(", (new SolrHelperServiceImpl()).scrubFacetValue("\\("));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   * <ul>
   *   <li>Then return {@code \\\[}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  public void testScrubFacetValue_thenReturnBackslashBackslashBackslashLeftSquareBracket() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("\\\\\\[", (new SolrHelperServiceImpl()).scrubFacetValue("\\["));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   * <ul>
   *   <li>Then return {@code \\\+}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  public void testScrubFacetValue_thenReturnBackslashBackslashBackslashPlusSign() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("\\\\\\+", (new SolrHelperServiceImpl()).scrubFacetValue("\\+"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   * <ul>
   *   <li>Then return {@code \\\?}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  public void testScrubFacetValue_thenReturnBackslashBackslashBackslashQuestionMark() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("\\\\\\?", (new SolrHelperServiceImpl()).scrubFacetValue("\\?"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   * <ul>
   *   <li>Then return {@code \\\}}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  public void testScrubFacetValue_thenReturnBackslashBackslashBackslashRightCurlyBracket() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("\\\\\\}", (new SolrHelperServiceImpl()).scrubFacetValue("\\}"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   * <ul>
   *   <li>Then return {@code \\\)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  public void testScrubFacetValue_thenReturnBackslashBackslashBackslashRightParenthesis() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("\\\\\\)", (new SolrHelperServiceImpl()).scrubFacetValue("\\)"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   * <ul>
   *   <li>Then return {@code \\\]}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  public void testScrubFacetValue_thenReturnBackslashBackslashBackslashRightSquareBracket() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("\\\\\\]", (new SolrHelperServiceImpl()).scrubFacetValue("\\]"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   * <ul>
   *   <li>Then return {@code \:\&&}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  public void testScrubFacetValue_thenReturnBackslashColonBackslashAmpersandAmpersand() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("\\:\\&&", (new SolrHelperServiceImpl()).scrubFacetValue(":&&"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   * <ul>
   *   <li>Then return {@code \:\\}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  public void testScrubFacetValue_thenReturnBackslashColonBackslashBackslash() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("\\:\\\\", (new SolrHelperServiceImpl()).scrubFacetValue(":\\"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   * <ul>
   *   <li>Then return {@code \:\!}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  public void testScrubFacetValue_thenReturnBackslashColonBackslashExclamationMark() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("\\:\\!", (new SolrHelperServiceImpl()).scrubFacetValue(":!"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   * <ul>
   *   <li>Then return {@code \:\{}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  public void testScrubFacetValue_thenReturnBackslashColonBackslashLeftCurlyBracket() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("\\:\\{", (new SolrHelperServiceImpl()).scrubFacetValue(":{"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   * <ul>
   *   <li>Then return {@code \:\(}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  public void testScrubFacetValue_thenReturnBackslashColonBackslashLeftParenthesis() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("\\:\\(", (new SolrHelperServiceImpl()).scrubFacetValue(":("));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   * <ul>
   *   <li>Then return {@code \:\[}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  public void testScrubFacetValue_thenReturnBackslashColonBackslashLeftSquareBracket() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("\\:\\[", (new SolrHelperServiceImpl()).scrubFacetValue(":["));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   * <ul>
   *   <li>Then return {@code \:\}}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  public void testScrubFacetValue_thenReturnBackslashColonBackslashRightCurlyBracket() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("\\:\\}", (new SolrHelperServiceImpl()).scrubFacetValue(":}"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   * <ul>
   *   <li>Then return {@code \:\)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  public void testScrubFacetValue_thenReturnBackslashColonBackslashRightParenthesis() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("\\:\\)", (new SolrHelperServiceImpl()).scrubFacetValue(":)"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   * <ul>
   *   <li>Then return {@code \:\]}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  public void testScrubFacetValue_thenReturnBackslashColonBackslashRightSquareBracket() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("\\:\\]", (new SolrHelperServiceImpl()).scrubFacetValue(":]"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   * <ul>
   *   <li>Then return {@code \:\||}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  public void testScrubFacetValue_thenReturnBackslashColonBackslashVerticalLineVerticalLine() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("\\:\\||", (new SolrHelperServiceImpl()).scrubFacetValue(":||"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   * <ul>
   *   <li>Then return {@code \-\&&}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  public void testScrubFacetValue_thenReturnBackslashDashBackslashAmpersandAmpersand() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("\\-\\&&", (new SolrHelperServiceImpl()).scrubFacetValue("-&&"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   * <ul>
   *   <li>Then return {@code \-\!}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  public void testScrubFacetValue_thenReturnBackslashDashBackslashExclamationMark() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("\\-\\!", (new SolrHelperServiceImpl()).scrubFacetValue("-!"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   * <ul>
   *   <li>Then return {@code \-\{}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  public void testScrubFacetValue_thenReturnBackslashDashBackslashLeftCurlyBracket() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("\\-\\{", (new SolrHelperServiceImpl()).scrubFacetValue("-{"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   * <ul>
   *   <li>Then return {@code \-\(}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  public void testScrubFacetValue_thenReturnBackslashDashBackslashLeftParenthesis() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("\\-\\(", (new SolrHelperServiceImpl()).scrubFacetValue("-("));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   * <ul>
   *   <li>Then return {@code \-\[}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  public void testScrubFacetValue_thenReturnBackslashDashBackslashLeftSquareBracket() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("\\-\\[", (new SolrHelperServiceImpl()).scrubFacetValue("-["));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   * <ul>
   *   <li>Then return {@code \-\}}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  public void testScrubFacetValue_thenReturnBackslashDashBackslashRightCurlyBracket() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("\\-\\}", (new SolrHelperServiceImpl()).scrubFacetValue("-}"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   * <ul>
   *   <li>Then return {@code \-\)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  public void testScrubFacetValue_thenReturnBackslashDashBackslashRightParenthesis() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("\\-\\)", (new SolrHelperServiceImpl()).scrubFacetValue("-)"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   * <ul>
   *   <li>Then return {@code \-\]}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  public void testScrubFacetValue_thenReturnBackslashDashBackslashRightSquareBracket() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("\\-\\]", (new SolrHelperServiceImpl()).scrubFacetValue("-]"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   * <ul>
   *   <li>Then return {@code \-\||}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  public void testScrubFacetValue_thenReturnBackslashDashBackslashVerticalLineVerticalLine() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("\\-\\||", (new SolrHelperServiceImpl()).scrubFacetValue("-||"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   * <ul>
   *   <li>Then return {@code \!\*}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  public void testScrubFacetValue_thenReturnBackslashExclamationMarkBackslashAsterisk() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("\\!\\*", (new SolrHelperServiceImpl()).scrubFacetValue("!*"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   * <ul>
   *   <li>Then return {@code \!\\}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  public void testScrubFacetValue_thenReturnBackslashExclamationMarkBackslashBackslash() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("\\!\\\\", (new SolrHelperServiceImpl()).scrubFacetValue("!\\"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   * <ul>
   *   <li>Then return {@code \!\:}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  public void testScrubFacetValue_thenReturnBackslashExclamationMarkBackslashColon() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("\\!\\:", (new SolrHelperServiceImpl()).scrubFacetValue("!:"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   * <ul>
   *   <li>Then return {@code \!\-}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  public void testScrubFacetValue_thenReturnBackslashExclamationMarkBackslashDash() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("\\!\\-", (new SolrHelperServiceImpl()).scrubFacetValue("!-"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   * <ul>
   *   <li>Then return {@code \!\!}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  public void testScrubFacetValue_thenReturnBackslashExclamationMarkBackslashExclamationMark() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("\\!\\!", (new SolrHelperServiceImpl()).scrubFacetValue("!!"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   * <ul>
   *   <li>Then return {@code \!\{}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  public void testScrubFacetValue_thenReturnBackslashExclamationMarkBackslashLeftCurlyBracket() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("\\!\\{", (new SolrHelperServiceImpl()).scrubFacetValue("!{"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   * <ul>
   *   <li>Then return {@code \!\(}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  public void testScrubFacetValue_thenReturnBackslashExclamationMarkBackslashLeftParenthesis() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("\\!\\(", (new SolrHelperServiceImpl()).scrubFacetValue("!("));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   * <ul>
   *   <li>Then return {@code \!\[}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  public void testScrubFacetValue_thenReturnBackslashExclamationMarkBackslashLeftSquareBracket() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("\\!\\[", (new SolrHelperServiceImpl()).scrubFacetValue("!["));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   * <ul>
   *   <li>Then return {@code \!\+}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  public void testScrubFacetValue_thenReturnBackslashExclamationMarkBackslashPlusSign() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("\\!\\+", (new SolrHelperServiceImpl()).scrubFacetValue("!+"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   * <ul>
   *   <li>Then return {@code \!\}}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  public void testScrubFacetValue_thenReturnBackslashExclamationMarkBackslashRightCurlyBracket() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("\\!\\}", (new SolrHelperServiceImpl()).scrubFacetValue("!}"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   * <ul>
   *   <li>Then return {@code \!\)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  public void testScrubFacetValue_thenReturnBackslashExclamationMarkBackslashRightParenthesis() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("\\!\\)", (new SolrHelperServiceImpl()).scrubFacetValue("!)"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   * <ul>
   *   <li>Then return {@code \{\*}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  public void testScrubFacetValue_thenReturnBackslashLeftCurlyBracketBackslashAsterisk() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("\\{\\*", (new SolrHelperServiceImpl()).scrubFacetValue("{*"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   * <ul>
   *   <li>Then return {@code \{\\}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  public void testScrubFacetValue_thenReturnBackslashLeftCurlyBracketBackslashBackslash() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("\\{\\\\", (new SolrHelperServiceImpl()).scrubFacetValue("{\\"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   * <ul>
   *   <li>Then return {@code \{\:}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  public void testScrubFacetValue_thenReturnBackslashLeftCurlyBracketBackslashColon() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("\\{\\:", (new SolrHelperServiceImpl()).scrubFacetValue("{:"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   * <ul>
   *   <li>Then return {@code \{\-}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  public void testScrubFacetValue_thenReturnBackslashLeftCurlyBracketBackslashDash() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("\\{\\-", (new SolrHelperServiceImpl()).scrubFacetValue("{-"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   * <ul>
   *   <li>Then return {@code \{\!}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  public void testScrubFacetValue_thenReturnBackslashLeftCurlyBracketBackslashExclamationMark() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("\\{\\!", (new SolrHelperServiceImpl()).scrubFacetValue("{!"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   * <ul>
   *   <li>Then return {@code \{\{}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  public void testScrubFacetValue_thenReturnBackslashLeftCurlyBracketBackslashLeftCurlyBracket() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("\\{\\{", (new SolrHelperServiceImpl()).scrubFacetValue("{{"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   * <ul>
   *   <li>Then return {@code \{\(}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  public void testScrubFacetValue_thenReturnBackslashLeftCurlyBracketBackslashLeftParenthesis() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("\\{\\(", (new SolrHelperServiceImpl()).scrubFacetValue("{("));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   * <ul>
   *   <li>Then return {@code \{\+}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  public void testScrubFacetValue_thenReturnBackslashLeftCurlyBracketBackslashPlusSign() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("\\{\\+", (new SolrHelperServiceImpl()).scrubFacetValue("{+"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   * <ul>
   *   <li>Then return {@code \{\)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  public void testScrubFacetValue_thenReturnBackslashLeftCurlyBracketBackslashRightParenthesis() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("\\{\\)", (new SolrHelperServiceImpl()).scrubFacetValue("{)"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   * <ul>
   *   <li>Then return {@code \(\*}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  public void testScrubFacetValue_thenReturnBackslashLeftParenthesisBackslashAsterisk() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("\\(\\*", (new SolrHelperServiceImpl()).scrubFacetValue("(*"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   * <ul>
   *   <li>Then return {@code \(\\}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  public void testScrubFacetValue_thenReturnBackslashLeftParenthesisBackslashBackslash() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("\\(\\\\", (new SolrHelperServiceImpl()).scrubFacetValue("(\\"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   * <ul>
   *   <li>Then return {@code \(\:}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  public void testScrubFacetValue_thenReturnBackslashLeftParenthesisBackslashColon() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("\\(\\:", (new SolrHelperServiceImpl()).scrubFacetValue("(:"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   * <ul>
   *   <li>Then return {@code \(\-}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  public void testScrubFacetValue_thenReturnBackslashLeftParenthesisBackslashDash() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("\\(\\-", (new SolrHelperServiceImpl()).scrubFacetValue("(-"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   * <ul>
   *   <li>Then return {@code \(\!}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  public void testScrubFacetValue_thenReturnBackslashLeftParenthesisBackslashExclamationMark() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("\\(\\!", (new SolrHelperServiceImpl()).scrubFacetValue("(!"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   * <ul>
   *   <li>Then return {@code \(\{}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  public void testScrubFacetValue_thenReturnBackslashLeftParenthesisBackslashLeftCurlyBracket() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("\\(\\{", (new SolrHelperServiceImpl()).scrubFacetValue("({"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   * <ul>
   *   <li>Then return {@code \(\(}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  public void testScrubFacetValue_thenReturnBackslashLeftParenthesisBackslashLeftParenthesis() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("\\(\\(", (new SolrHelperServiceImpl()).scrubFacetValue("(("));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   * <ul>
   *   <li>Then return {@code \(\[}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  public void testScrubFacetValue_thenReturnBackslashLeftParenthesisBackslashLeftSquareBracket() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("\\(\\[", (new SolrHelperServiceImpl()).scrubFacetValue("(["));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   * <ul>
   *   <li>Then return {@code \(\+}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  public void testScrubFacetValue_thenReturnBackslashLeftParenthesisBackslashPlusSign() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("\\(\\+", (new SolrHelperServiceImpl()).scrubFacetValue("(+"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   * <ul>
   *   <li>Then return {@code \(\}}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  public void testScrubFacetValue_thenReturnBackslashLeftParenthesisBackslashRightCurlyBracket() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("\\(\\}", (new SolrHelperServiceImpl()).scrubFacetValue("(}"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   * <ul>
   *   <li>Then return {@code \(\)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  public void testScrubFacetValue_thenReturnBackslashLeftParenthesisBackslashRightParenthesis() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("\\(\\)", (new SolrHelperServiceImpl()).scrubFacetValue("()"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   * <ul>
   *   <li>Then return {@code \+\&&}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  public void testScrubFacetValue_thenReturnBackslashPlusSignBackslashAmpersandAmpersand() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("\\+\\&&", (new SolrHelperServiceImpl()).scrubFacetValue("+&&"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   * <ul>
   *   <li>Then return {@code \+\*}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  public void testScrubFacetValue_thenReturnBackslashPlusSignBackslashAsterisk() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("\\+\\*", (new SolrHelperServiceImpl()).scrubFacetValue("+*"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   * <ul>
   *   <li>Then return {@code \+\\}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  public void testScrubFacetValue_thenReturnBackslashPlusSignBackslashBackslash() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("\\+\\\\", (new SolrHelperServiceImpl()).scrubFacetValue("+\\"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   * <ul>
   *   <li>Then return {@code \+\!}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  public void testScrubFacetValue_thenReturnBackslashPlusSignBackslashExclamationMark() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("\\+\\!", (new SolrHelperServiceImpl()).scrubFacetValue("+!"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   * <ul>
   *   <li>Then return {@code \+\{}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  public void testScrubFacetValue_thenReturnBackslashPlusSignBackslashLeftCurlyBracket() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("\\+\\{", (new SolrHelperServiceImpl()).scrubFacetValue("+{"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   * <ul>
   *   <li>Then return {@code \+\(}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  public void testScrubFacetValue_thenReturnBackslashPlusSignBackslashLeftParenthesis() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("\\+\\(", (new SolrHelperServiceImpl()).scrubFacetValue("+("));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   * <ul>
   *   <li>Then return {@code \+\[}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  public void testScrubFacetValue_thenReturnBackslashPlusSignBackslashLeftSquareBracket() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("\\+\\[", (new SolrHelperServiceImpl()).scrubFacetValue("+["));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   * <ul>
   *   <li>Then return {@code \+\+}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  public void testScrubFacetValue_thenReturnBackslashPlusSignBackslashPlusSign() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("\\+\\+", (new SolrHelperServiceImpl()).scrubFacetValue("++"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   * <ul>
   *   <li>Then return {@code \+\}}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  public void testScrubFacetValue_thenReturnBackslashPlusSignBackslashRightCurlyBracket() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("\\+\\}", (new SolrHelperServiceImpl()).scrubFacetValue("+}"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   * <ul>
   *   <li>Then return {@code \+\)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  public void testScrubFacetValue_thenReturnBackslashPlusSignBackslashRightParenthesis() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("\\+\\)", (new SolrHelperServiceImpl()).scrubFacetValue("+)"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   * <ul>
   *   <li>Then return {@code \+\]}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  public void testScrubFacetValue_thenReturnBackslashPlusSignBackslashRightSquareBracket() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("\\+\\]", (new SolrHelperServiceImpl()).scrubFacetValue("+]"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   * <ul>
   *   <li>Then return {@code \+\||}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  public void testScrubFacetValue_thenReturnBackslashPlusSignBackslashVerticalLineVerticalLine() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("\\+\\||", (new SolrHelperServiceImpl()).scrubFacetValue("+||"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   * <ul>
   *   <li>Then return {@code \}\*}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  public void testScrubFacetValue_thenReturnBackslashRightCurlyBracketBackslashAsterisk() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("\\}\\*", (new SolrHelperServiceImpl()).scrubFacetValue("}*"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   * <ul>
   *   <li>Then return {@code \}\\}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  public void testScrubFacetValue_thenReturnBackslashRightCurlyBracketBackslashBackslash() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("\\}\\\\", (new SolrHelperServiceImpl()).scrubFacetValue("}\\"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   * <ul>
   *   <li>Then return {@code \}\:}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  public void testScrubFacetValue_thenReturnBackslashRightCurlyBracketBackslashColon() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("\\}\\:", (new SolrHelperServiceImpl()).scrubFacetValue("}:"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   * <ul>
   *   <li>Then return {@code \}\-}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  public void testScrubFacetValue_thenReturnBackslashRightCurlyBracketBackslashDash() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("\\}\\-", (new SolrHelperServiceImpl()).scrubFacetValue("}-"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   * <ul>
   *   <li>Then return {@code \}\!}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  public void testScrubFacetValue_thenReturnBackslashRightCurlyBracketBackslashExclamationMark() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("\\}\\!", (new SolrHelperServiceImpl()).scrubFacetValue("}!"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   * <ul>
   *   <li>Then return {@code \}\(}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  public void testScrubFacetValue_thenReturnBackslashRightCurlyBracketBackslashLeftParenthesis() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("\\}\\(", (new SolrHelperServiceImpl()).scrubFacetValue("}("));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   * <ul>
   *   <li>Then return {@code \}\+}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  public void testScrubFacetValue_thenReturnBackslashRightCurlyBracketBackslashPlusSign() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("\\}\\+", (new SolrHelperServiceImpl()).scrubFacetValue("}+"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   * <ul>
   *   <li>Then return {@code \)\*}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  public void testScrubFacetValue_thenReturnBackslashRightParenthesisBackslashAsterisk() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("\\)\\*", (new SolrHelperServiceImpl()).scrubFacetValue(")*"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   * <ul>
   *   <li>Then return {@code \)\\}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  public void testScrubFacetValue_thenReturnBackslashRightParenthesisBackslashBackslash() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("\\)\\\\", (new SolrHelperServiceImpl()).scrubFacetValue(")\\"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   * <ul>
   *   <li>Then return {@code \)\:}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  public void testScrubFacetValue_thenReturnBackslashRightParenthesisBackslashColon() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("\\)\\:", (new SolrHelperServiceImpl()).scrubFacetValue("):"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   * <ul>
   *   <li>Then return {@code \)\-}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  public void testScrubFacetValue_thenReturnBackslashRightParenthesisBackslashDash() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("\\)\\-", (new SolrHelperServiceImpl()).scrubFacetValue(")-"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   * <ul>
   *   <li>Then return {@code \)\!}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  public void testScrubFacetValue_thenReturnBackslashRightParenthesisBackslashExclamationMark() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("\\)\\!", (new SolrHelperServiceImpl()).scrubFacetValue(")!"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   * <ul>
   *   <li>Then return {@code \)\{}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  public void testScrubFacetValue_thenReturnBackslashRightParenthesisBackslashLeftCurlyBracket() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("\\)\\{", (new SolrHelperServiceImpl()).scrubFacetValue("){"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   * <ul>
   *   <li>Then return {@code \)\(}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  public void testScrubFacetValue_thenReturnBackslashRightParenthesisBackslashLeftParenthesis() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("\\)\\(", (new SolrHelperServiceImpl()).scrubFacetValue(")("));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   * <ul>
   *   <li>Then return {@code \)\+}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  public void testScrubFacetValue_thenReturnBackslashRightParenthesisBackslashPlusSign() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("\\)\\+", (new SolrHelperServiceImpl()).scrubFacetValue(")+"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   * <ul>
   *   <li>Then return {@code \)\)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  public void testScrubFacetValue_thenReturnBackslashRightParenthesisBackslashRightParenthesis() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("\\)\\)", (new SolrHelperServiceImpl()).scrubFacetValue("))"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   * <ul>
   *   <li>Then return {@code \]\*}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  public void testScrubFacetValue_thenReturnBackslashRightSquareBracketBackslashAsterisk() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("\\]\\*", (new SolrHelperServiceImpl()).scrubFacetValue("]*"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   * <ul>
   *   <li>Then return {@code \]\\}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  public void testScrubFacetValue_thenReturnBackslashRightSquareBracketBackslashBackslash() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("\\]\\\\", (new SolrHelperServiceImpl()).scrubFacetValue("]\\"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   * <ul>
   *   <li>Then return {@code \]\:}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  public void testScrubFacetValue_thenReturnBackslashRightSquareBracketBackslashColon() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("\\]\\:", (new SolrHelperServiceImpl()).scrubFacetValue("]:"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   * <ul>
   *   <li>Then return {@code \]\-}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  public void testScrubFacetValue_thenReturnBackslashRightSquareBracketBackslashDash() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("\\]\\-", (new SolrHelperServiceImpl()).scrubFacetValue("]-"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   * <ul>
   *   <li>Then return {@code \]\+}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  public void testScrubFacetValue_thenReturnBackslashRightSquareBracketBackslashPlusSign() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("\\]\\+", (new SolrHelperServiceImpl()).scrubFacetValue("]+"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   * <ul>
   *   <li>Then return {@code \||}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  public void testScrubFacetValue_thenReturnBackslashVerticalLineVerticalLine() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("\\||", (new SolrHelperServiceImpl()).scrubFacetValue("||"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   * <ul>
   *   <li>Then return {@code \||\*}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  public void testScrubFacetValue_thenReturnBackslashVerticalLineVerticalLineBackslashAsterisk() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("\\||\\*", (new SolrHelperServiceImpl()).scrubFacetValue("||*"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   * <ul>
   *   <li>Then return {@code \||\:}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  public void testScrubFacetValue_thenReturnBackslashVerticalLineVerticalLineBackslashColon() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("\\||\\:", (new SolrHelperServiceImpl()).scrubFacetValue("||:"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   * <ul>
   *   <li>Then return {@code \||\-}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  public void testScrubFacetValue_thenReturnBackslashVerticalLineVerticalLineBackslashDash() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("\\||\\-", (new SolrHelperServiceImpl()).scrubFacetValue("||-"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   * <ul>
   *   <li>Then return {@code \||\+}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  public void testScrubFacetValue_thenReturnBackslashVerticalLineVerticalLineBackslashPlusSign() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("\\||\\+", (new SolrHelperServiceImpl()).scrubFacetValue("||+"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   * <ul>
   *   <li>Then return {@code \\exploitProtection.xssEnabled}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  public void testScrubFacetValue_thenReturnExploitProtectionXssEnabled() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("\\\\exploitProtection.xssEnabled",
        (new SolrHelperServiceImpl()).scrubFacetValue("\\exploitProtection.xssEnabled"));
    assertEquals("\\+exploitProtection.xssEnabled",
        (new SolrHelperServiceImpl()).scrubFacetValue("+exploitProtection.xssEnabled"));
    assertEquals("\\-exploitProtection.xssEnabled",
        (new SolrHelperServiceImpl()).scrubFacetValue("-exploitProtection.xssEnabled"));
    assertEquals("\\&&exploitProtection.xssEnabled",
        (new SolrHelperServiceImpl()).scrubFacetValue("&&exploitProtection.xssEnabled"));
    assertEquals("\\||exploitProtection.xssEnabled",
        (new SolrHelperServiceImpl()).scrubFacetValue("||exploitProtection.xssEnabled"));
    assertEquals("\\!exploitProtection.xssEnabled",
        (new SolrHelperServiceImpl()).scrubFacetValue("!exploitProtection.xssEnabled"));
    assertEquals("\\(exploitProtection.xssEnabled",
        (new SolrHelperServiceImpl()).scrubFacetValue("(exploitProtection.xssEnabled"));
    assertEquals("\\*exploitProtection.xssEnabled",
        (new SolrHelperServiceImpl()).scrubFacetValue("*exploitProtection.xssEnabled"));
    assertEquals("\\)exploitProtection.xssEnabled",
        (new SolrHelperServiceImpl()).scrubFacetValue(")exploitProtection.xssEnabled"));
    assertEquals("\\:exploitProtection.xssEnabled",
        (new SolrHelperServiceImpl()).scrubFacetValue(":exploitProtection.xssEnabled"));
    assertEquals("\\{exploitProtection.xssEnabled",
        (new SolrHelperServiceImpl()).scrubFacetValue("{exploitProtection.xssEnabled"));
    assertEquals("\\\\\\?exploitProtection.xssEnabled",
        (new SolrHelperServiceImpl()).scrubFacetValue("\\?exploitProtection.xssEnabled"));
    assertEquals("\\}exploitProtection.xssEnabled",
        (new SolrHelperServiceImpl()).scrubFacetValue("}exploitProtection.xssEnabled"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   * <ul>
   *   <li>When {@code 42}.</li>
   *   <li>Then return {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  public void testScrubFacetValue_when42_thenReturn42() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("42", (new SolrHelperServiceImpl()).scrubFacetValue("42"));
    assertEquals("42\\\\", (new SolrHelperServiceImpl()).scrubFacetValue("42\\"));
    assertEquals("42\\+", (new SolrHelperServiceImpl()).scrubFacetValue("42+"));
    assertEquals("42\\-", (new SolrHelperServiceImpl()).scrubFacetValue("42-"));
    assertEquals("42\\&&", (new SolrHelperServiceImpl()).scrubFacetValue("42&&"));
    assertEquals("42\\||", (new SolrHelperServiceImpl()).scrubFacetValue("42||"));
    assertEquals("42\\!", (new SolrHelperServiceImpl()).scrubFacetValue("42!"));
    assertEquals("42\\(", (new SolrHelperServiceImpl()).scrubFacetValue("42("));
    assertEquals("42\\*", (new SolrHelperServiceImpl()).scrubFacetValue("42*"));
    assertEquals("42\\)", (new SolrHelperServiceImpl()).scrubFacetValue("42)"));
    assertEquals("42\\:", (new SolrHelperServiceImpl()).scrubFacetValue("42:"));
    assertEquals("42\\{", (new SolrHelperServiceImpl()).scrubFacetValue("42{"));
    assertEquals("42\\\\\\?", (new SolrHelperServiceImpl()).scrubFacetValue("42\\?"));
    assertEquals("42\\}", (new SolrHelperServiceImpl()).scrubFacetValue("42}"));
    assertEquals("42\\]", (new SolrHelperServiceImpl()).scrubFacetValue("42]"));
    assertEquals("42\\[", (new SolrHelperServiceImpl()).scrubFacetValue("42["));
    assertEquals("\\\\42", (new SolrHelperServiceImpl()).scrubFacetValue("\\42"));
    assertEquals("\\+42", (new SolrHelperServiceImpl()).scrubFacetValue("+42"));
    assertEquals("\\-42", (new SolrHelperServiceImpl()).scrubFacetValue("-42"));
    assertEquals("\\&&42", (new SolrHelperServiceImpl()).scrubFacetValue("&&42"));
    assertEquals("\\||42", (new SolrHelperServiceImpl()).scrubFacetValue("||42"));
    assertEquals("\\!42", (new SolrHelperServiceImpl()).scrubFacetValue("!42"));
    assertEquals("\\(42", (new SolrHelperServiceImpl()).scrubFacetValue("(42"));
    assertEquals("\\*42", (new SolrHelperServiceImpl()).scrubFacetValue("*42"));
    assertEquals("\\)42", (new SolrHelperServiceImpl()).scrubFacetValue(")42"));
    assertEquals("\\:42", (new SolrHelperServiceImpl()).scrubFacetValue(":42"));
    assertEquals("\\{42", (new SolrHelperServiceImpl()).scrubFacetValue("{42"));
    assertEquals("\\\\\\?42", (new SolrHelperServiceImpl()).scrubFacetValue("\\?42"));
    assertEquals("\\}42", (new SolrHelperServiceImpl()).scrubFacetValue("}42"));
    assertEquals("\\]42", (new SolrHelperServiceImpl()).scrubFacetValue("]42"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   * <ul>
   *   <li>When {@code &&}.</li>
   *   <li>Then return {@code \&&}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  public void testScrubFacetValue_whenAmpersandAmpersand_thenReturnBackslashAmpersandAmpersand() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("\\&&", (new SolrHelperServiceImpl()).scrubFacetValue("&&"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   * <ul>
   *   <li>When {@code *:}.</li>
   *   <li>Then return {@code \*\:}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  public void testScrubFacetValue_whenAsteriskColon_thenReturnBackslashAsteriskBackslashColon() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("\\*\\:", (new SolrHelperServiceImpl()).scrubFacetValue("*:"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   * <ul>
   *   <li>When {@code *-}.</li>
   *   <li>Then return {@code \*\-}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  public void testScrubFacetValue_whenAsteriskDash_thenReturnBackslashAsteriskBackslashDash() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("\\*\\-", (new SolrHelperServiceImpl()).scrubFacetValue("*-"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   * <ul>
   *   <li>When {@code *}.</li>
   *   <li>Then return {@code \*}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  public void testScrubFacetValue_whenAsterisk_thenReturnBackslashAsterisk() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("\\*", (new SolrHelperServiceImpl()).scrubFacetValue("*"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   * <ul>
   *   <li>When {@code \-}.</li>
   *   <li>Then return {@code \\\-}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  public void testScrubFacetValue_whenBackslashDash_thenReturnBackslashBackslashBackslashDash() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("\\\\\\-", (new SolrHelperServiceImpl()).scrubFacetValue("\\-"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   * <ul>
   *   <li>When {@code \}.</li>
   *   <li>Then return {@code \\}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  public void testScrubFacetValue_whenBackslash_thenReturnBackslashBackslash() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("\\\\", (new SolrHelperServiceImpl()).scrubFacetValue("\\"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   * <ul>
   *   <li>When {@code :*}.</li>
   *   <li>Then return {@code \:\*}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  public void testScrubFacetValue_whenColonAsterisk_thenReturnBackslashColonBackslashAsterisk() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("\\:\\*", (new SolrHelperServiceImpl()).scrubFacetValue(":*"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   * <ul>
   *   <li>When {@code ::}.</li>
   *   <li>Then return {@code \:\:}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  public void testScrubFacetValue_whenColonColon_thenReturnBackslashColonBackslashColon() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("\\:\\:", (new SolrHelperServiceImpl()).scrubFacetValue("::"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   * <ul>
   *   <li>When {@code :-}.</li>
   *   <li>Then return {@code \:\-}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  public void testScrubFacetValue_whenColonDash_thenReturnBackslashColonBackslashDash() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("\\:\\-", (new SolrHelperServiceImpl()).scrubFacetValue(":-"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   * <ul>
   *   <li>When {@code :+}.</li>
   *   <li>Then return {@code \:\+}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  public void testScrubFacetValue_whenColonPlusSign_thenReturnBackslashColonBackslashPlusSign() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("\\:\\+", (new SolrHelperServiceImpl()).scrubFacetValue(":+"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   * <ul>
   *   <li>When {@code :}.</li>
   *   <li>Then return {@code \:}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  public void testScrubFacetValue_whenColon_thenReturnBackslashColon() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("\\:", (new SolrHelperServiceImpl()).scrubFacetValue(":"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   * <ul>
   *   <li>When {@code -*}.</li>
   *   <li>Then return {@code \-\*}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  public void testScrubFacetValue_whenDashAsterisk_thenReturnBackslashDashBackslashAsterisk() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("\\-\\*", (new SolrHelperServiceImpl()).scrubFacetValue("-*"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   * <ul>
   *   <li>When {@code -\}.</li>
   *   <li>Then return {@code \-\\}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  public void testScrubFacetValue_whenDashBackslash_thenReturnBackslashDashBackslashBackslash() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("\\-\\\\", (new SolrHelperServiceImpl()).scrubFacetValue("-\\"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   * <ul>
   *   <li>When {@code -:}.</li>
   *   <li>Then return {@code \-\:}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  public void testScrubFacetValue_whenDashColon_thenReturnBackslashDashBackslashColon() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("\\-\\:", (new SolrHelperServiceImpl()).scrubFacetValue("-:"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   * <ul>
   *   <li>When {@code --}.</li>
   *   <li>Then return {@code \-\-}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  public void testScrubFacetValue_whenDashDash_thenReturnBackslashDashBackslashDash() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("\\-\\-", (new SolrHelperServiceImpl()).scrubFacetValue("--"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   * <ul>
   *   <li>When {@code -+}.</li>
   *   <li>Then return {@code \-\+}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  public void testScrubFacetValue_whenDashPlusSign_thenReturnBackslashDashBackslashPlusSign() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("\\-\\+", (new SolrHelperServiceImpl()).scrubFacetValue("-+"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   * <ul>
   *   <li>When {@code -}.</li>
   *   <li>Then return {@code \-}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  public void testScrubFacetValue_whenDash_thenReturnBackslashDash() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("\\-", (new SolrHelperServiceImpl()).scrubFacetValue("-"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   * <ul>
   *   <li>When {@code \desc}.</li>
   *   <li>Then return {@code \\desc}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  public void testScrubFacetValue_whenDesc_thenReturnDesc() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("\\\\desc", (new SolrHelperServiceImpl()).scrubFacetValue("\\desc"));
    assertEquals("\\+desc", (new SolrHelperServiceImpl()).scrubFacetValue("+desc"));
    assertEquals("\\-desc", (new SolrHelperServiceImpl()).scrubFacetValue("-desc"));
    assertEquals("\\&&desc", (new SolrHelperServiceImpl()).scrubFacetValue("&&desc"));
    assertEquals("\\||desc", (new SolrHelperServiceImpl()).scrubFacetValue("||desc"));
    assertEquals("\\!desc", (new SolrHelperServiceImpl()).scrubFacetValue("!desc"));
    assertEquals("\\(desc", (new SolrHelperServiceImpl()).scrubFacetValue("(desc"));
    assertEquals("\\*desc", (new SolrHelperServiceImpl()).scrubFacetValue("*desc"));
    assertEquals("\\)desc", (new SolrHelperServiceImpl()).scrubFacetValue(")desc"));
    assertEquals("\\:desc", (new SolrHelperServiceImpl()).scrubFacetValue(":desc"));
    assertEquals("\\{desc", (new SolrHelperServiceImpl()).scrubFacetValue("{desc"));
    assertEquals("\\\\\\?desc", (new SolrHelperServiceImpl()).scrubFacetValue("\\?desc"));
    assertEquals("\\}desc", (new SolrHelperServiceImpl()).scrubFacetValue("}desc"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   * <ul>
   *   <li>When {@code !}.</li>
   *   <li>Then return {@code \!}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  public void testScrubFacetValue_whenExclamationMark_thenReturnBackslashExclamationMark() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("\\!", (new SolrHelperServiceImpl()).scrubFacetValue("!"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   * <ul>
   *   <li>When {@code \Facet Value}.</li>
   *   <li>Then return {@code \\Facet Value}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  public void testScrubFacetValue_whenFacetValue_thenReturnFacetValue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("\\\\Facet Value", (new SolrHelperServiceImpl()).scrubFacetValue("\\Facet Value"));
    assertEquals("\\+Facet Value", (new SolrHelperServiceImpl()).scrubFacetValue("+Facet Value"));
    assertEquals("\\-Facet Value", (new SolrHelperServiceImpl()).scrubFacetValue("-Facet Value"));
    assertEquals("\\&&Facet Value", (new SolrHelperServiceImpl()).scrubFacetValue("&&Facet Value"));
    assertEquals("\\||Facet Value", (new SolrHelperServiceImpl()).scrubFacetValue("||Facet Value"));
    assertEquals("\\!Facet Value", (new SolrHelperServiceImpl()).scrubFacetValue("!Facet Value"));
    assertEquals("Facet Value\\\\", (new SolrHelperServiceImpl()).scrubFacetValue("Facet Value\\"));
    assertEquals("Facet Value\\+", (new SolrHelperServiceImpl()).scrubFacetValue("Facet Value+"));
    assertEquals("Facet Value\\-", (new SolrHelperServiceImpl()).scrubFacetValue("Facet Value-"));
    assertEquals("Facet Value\\&&", (new SolrHelperServiceImpl()).scrubFacetValue("Facet Value&&"));
    assertEquals("Facet Value\\||", (new SolrHelperServiceImpl()).scrubFacetValue("Facet Value||"));
    assertEquals("Facet Value\\!", (new SolrHelperServiceImpl()).scrubFacetValue("Facet Value!"));
    assertEquals("Facet Value\\(", (new SolrHelperServiceImpl()).scrubFacetValue("Facet Value("));
    assertEquals("Facet Value\\*", (new SolrHelperServiceImpl()).scrubFacetValue("Facet Value*"));
    assertEquals("Facet Value\\)", (new SolrHelperServiceImpl()).scrubFacetValue("Facet Value)"));
    assertEquals("Facet Value\\:", (new SolrHelperServiceImpl()).scrubFacetValue("Facet Value:"));
    assertEquals("Facet Value\\{", (new SolrHelperServiceImpl()).scrubFacetValue("Facet Value{"));
    assertEquals("Facet Value\\\\\\?", (new SolrHelperServiceImpl()).scrubFacetValue("Facet Value\\?"));
    assertEquals("Facet Value\\}", (new SolrHelperServiceImpl()).scrubFacetValue("Facet Value}"));
    assertEquals("Facet Value\\]", (new SolrHelperServiceImpl()).scrubFacetValue("Facet Value]"));
    assertEquals("Facet Value\\[", (new SolrHelperServiceImpl()).scrubFacetValue("Facet Value["));
    assertEquals("\\(Facet Value", (new SolrHelperServiceImpl()).scrubFacetValue("(Facet Value"));
    assertEquals("\\*Facet Value", (new SolrHelperServiceImpl()).scrubFacetValue("*Facet Value"));
    assertEquals("\\)Facet Value", (new SolrHelperServiceImpl()).scrubFacetValue(")Facet Value"));
    assertEquals("\\:Facet Value", (new SolrHelperServiceImpl()).scrubFacetValue(":Facet Value"));
    assertEquals("\\{Facet Value", (new SolrHelperServiceImpl()).scrubFacetValue("{Facet Value"));
    assertEquals("\\\\\\?Facet Value", (new SolrHelperServiceImpl()).scrubFacetValue("\\?Facet Value"));
    assertEquals("\\}Facet Value", (new SolrHelperServiceImpl()).scrubFacetValue("}Facet Value"));
    assertEquals("\\]Facet Value", (new SolrHelperServiceImpl()).scrubFacetValue("]Facet Value"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   * <ul>
   *   <li>When {@code {}.</li>
   *   <li>Then return {@code \{}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  public void testScrubFacetValue_whenLeftCurlyBracket_thenReturnBackslashLeftCurlyBracket() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("\\{", (new SolrHelperServiceImpl()).scrubFacetValue("{"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   * <ul>
   *   <li>When {@code (}.</li>
   *   <li>Then return {@code \(}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  public void testScrubFacetValue_whenLeftParenthesis_thenReturnBackslashLeftParenthesis() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("\\(", (new SolrHelperServiceImpl()).scrubFacetValue("("));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   * <ul>
   *   <li>When {@code [}.</li>
   *   <li>Then return {@code \[}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  public void testScrubFacetValue_whenLeftSquareBracket_thenReturnBackslashLeftSquareBracket() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("\\[", (new SolrHelperServiceImpl()).scrubFacetValue("["));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   * <ul>
   *   <li>When {@code +:}.</li>
   *   <li>Then return {@code \+\:}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  public void testScrubFacetValue_whenPlusSignColon_thenReturnBackslashPlusSignBackslashColon() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("\\+\\:", (new SolrHelperServiceImpl()).scrubFacetValue("+:"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   * <ul>
   *   <li>When {@code +-}.</li>
   *   <li>Then return {@code \+\-}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  public void testScrubFacetValue_whenPlusSignDash_thenReturnBackslashPlusSignBackslashDash() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("\\+\\-", (new SolrHelperServiceImpl()).scrubFacetValue("+-"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   * <ul>
   *   <li>When {@code +}.</li>
   *   <li>Then return {@code \+}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  public void testScrubFacetValue_whenPlusSign_thenReturnBackslashPlusSign() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("\\+", (new SolrHelperServiceImpl()).scrubFacetValue("+"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   * <ul>
   *   <li>When {@code }}.</li>
   *   <li>Then return {@code \}}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  public void testScrubFacetValue_whenRightCurlyBracket_thenReturnBackslashRightCurlyBracket() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("\\}", (new SolrHelperServiceImpl()).scrubFacetValue("}"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   * <ul>
   *   <li>When {@code )}.</li>
   *   <li>Then return {@code \)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  public void testScrubFacetValue_whenRightParenthesis_thenReturnBackslashRightParenthesis() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("\\)", (new SolrHelperServiceImpl()).scrubFacetValue(")"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#scrubFacetValue(String)}.
   * <ul>
   *   <li>When {@code ]}.</li>
   *   <li>Then return {@code \]}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrHelperServiceImpl#scrubFacetValue(String)}
   */
  @Test
  public void testScrubFacetValue_whenRightSquareBracket_thenReturnBackslashRightSquareBracket() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("\\]", (new SolrHelperServiceImpl()).scrubFacetValue("]"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#sanitizeQuery(String)}.
   * <p>
   * Method under test: {@link SolrHelperServiceImpl#sanitizeQuery(String)}
   */
  @Test
  public void testSanitizeQuery() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("Query", (new SolrHelperServiceImpl()).sanitizeQuery("Query"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#isFacetAvailable(SearchFacet, Map)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.</li>
   *   <li>When {@link HashMap#HashMap()}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SolrHelperServiceImpl#isFacetAvailable(SearchFacet, Map)}
   */
  @Test
  public void testIsFacetAvailable_givenArrayList_whenHashMap_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SolrHelperServiceImpl solrHelperServiceImpl = new SolrHelperServiceImpl();
    SearchFacetImpl facet = mock(SearchFacetImpl.class);
    when(facet.getRequiredFacets()).thenReturn(new ArrayList<>());

    // Act
    boolean actualIsFacetAvailableResult = solrHelperServiceImpl.isFacetAvailable(facet, new HashMap<>());

    // Assert
    verify(facet).getRequiredFacets();
    assertTrue(actualIsFacetAvailableResult);
  }

  /**
   * Test {@link SolrHelperServiceImpl#isFacetAvailable(SearchFacet, Map)}.
   * <ul>
   *   <li>Then calls {@link SearchFacetImpl#getField()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SolrHelperServiceImpl#isFacetAvailable(SearchFacet, Map)}
   */
  @Test
  public void testIsFacetAvailable_thenCallsGetField() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SolrHelperServiceImpl solrHelperServiceImpl = new SolrHelperServiceImpl();
    SearchFacetImpl requiredFacet = mock(SearchFacetImpl.class);
    when(requiredFacet.getField()).thenReturn(new FieldImpl());

    RequiredFacetImpl requiredFacetImpl = new RequiredFacetImpl();
    requiredFacetImpl.setRequiredFacet(requiredFacet);

    ArrayList<RequiredFacet> requiredFacetList = new ArrayList<>();
    requiredFacetList.add(requiredFacetImpl);
    SearchFacetImpl facet = mock(SearchFacetImpl.class);
    when(facet.getRequiresAllDependentFacets()).thenReturn(true);
    when(facet.getRequiredFacets()).thenReturn(requiredFacetList);

    HashMap<String, String[]> params = new HashMap<>();
    params.put("42", new String[]{"foo"});

    // Act
    boolean actualIsFacetAvailableResult = solrHelperServiceImpl.isFacetAvailable(facet, params);

    // Assert
    verify(requiredFacet).getField();
    verify(facet, atLeast(1)).getRequiredFacets();
    verify(facet).getRequiresAllDependentFacets();
    assertFalse(actualIsFacetAvailableResult);
  }

  /**
   * Test {@link SolrHelperServiceImpl#isFacetAvailable(SearchFacet, Map)}.
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SolrHelperServiceImpl#isFacetAvailable(SearchFacet, Map)}
   */
  @Test
  public void testIsFacetAvailable_whenHashMap_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SolrHelperServiceImpl solrHelperServiceImpl = new SolrHelperServiceImpl();

    ArrayList<RequiredFacet> requiredFacetList = new ArrayList<>();
    requiredFacetList.add(new RequiredFacetImpl());
    SearchFacetImpl facet = mock(SearchFacetImpl.class);
    when(facet.getRequiredFacets()).thenReturn(requiredFacetList);

    // Act
    boolean actualIsFacetAvailableResult = solrHelperServiceImpl.isFacetAvailable(facet, new HashMap<>());

    // Assert
    verify(facet).getRequiredFacets();
    assertFalse(actualIsFacetAvailableResult);
  }

  /**
   * Test {@link SolrHelperServiceImpl#isFacetAvailable(SearchFacet, Map)}.
   * <ul>
   *   <li>When {@link SearchFacetImpl} (default constructor).</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SolrHelperServiceImpl#isFacetAvailable(SearchFacet, Map)}
   */
  @Test
  public void testIsFacetAvailable_whenSearchFacetImpl_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SolrHelperServiceImpl solrHelperServiceImpl = new SolrHelperServiceImpl();
    SearchFacetImpl facet = new SearchFacetImpl();

    // Act and Assert
    assertTrue(solrHelperServiceImpl.isFacetAvailable(facet, new HashMap<>()));
  }

  /**
   * Test
   * {@link SolrHelperServiceImpl#getSolrRangeString(String, BigDecimal, BigDecimal)}.
   * <ul>
   *   <li>Given {@code 2.3}.</li>
   *   <li>Then calls {@link BigDecimal#toPlainString()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SolrHelperServiceImpl#getSolrRangeString(String, BigDecimal, BigDecimal)}
   */
  @Test
  public void testGetSolrRangeString_given23_thenCallsToPlainString() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SolrHelperServiceImpl solrHelperServiceImpl = new SolrHelperServiceImpl();
    InternalNumber minValue = mock(InternalNumber.class);
    when(minValue.toPlainString()).thenReturn("2.3");

    // Act
    String actualSolrRangeString = solrHelperServiceImpl.getSolrRangeString("Field Name", minValue,
        new BigDecimal("2.3"));

    // Assert
    verify(minValue).toPlainString();
    assertEquals("Field Name:[2.3 TO 2.3]", actualSolrRangeString);
  }

  /**
   * Test
   * {@link SolrHelperServiceImpl#getSolrRangeString(String, BigDecimal, BigDecimal)}.
   * <ul>
   *   <li>When {@link BigDecimal#BigDecimal(String)} with {@code 2.3}.</li>
   *   <li>Then return {@code Field Name:[2.3 TO 2.3]}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SolrHelperServiceImpl#getSolrRangeString(String, BigDecimal, BigDecimal)}
   */
  @Test
  public void testGetSolrRangeString_whenBigDecimalWith23_thenReturnFieldName23To23() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SolrHelperServiceImpl solrHelperServiceImpl = new SolrHelperServiceImpl();
    BigDecimal minValue = new BigDecimal("2.3");

    // Act and Assert
    assertEquals("Field Name:[2.3 TO 2.3]",
        solrHelperServiceImpl.getSolrRangeString("Field Name", minValue, new BigDecimal("2.3")));
  }

  /**
   * Test
   * {@link SolrHelperServiceImpl#getSolrRangeString(String, BigDecimal, BigDecimal)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code Field Name:[* TO *]}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SolrHelperServiceImpl#getSolrRangeString(String, BigDecimal, BigDecimal)}
   */
  @Test
  public void testGetSolrRangeString_whenNull_thenReturnFieldNameTo() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("Field Name:[* TO *]", (new SolrHelperServiceImpl()).getSolrRangeString("Field Name", null, null));
  }

  /**
   * Test
   * {@link SolrHelperServiceImpl#getSolrRangeFunctionString(BigDecimal, BigDecimal)}.
   * <ul>
   *   <li>Given {@code 2.3}.</li>
   *   <li>Then calls {@link BigDecimal#toPlainString()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SolrHelperServiceImpl#getSolrRangeFunctionString(BigDecimal, BigDecimal)}
   */
  @Test
  public void testGetSolrRangeFunctionString_given23_thenCallsToPlainString() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SolrHelperServiceImpl solrHelperServiceImpl = new SolrHelperServiceImpl();
    InternalNumber minValue = mock(InternalNumber.class);
    when(minValue.toPlainString()).thenReturn("2.3");

    // Act
    String actualSolrRangeFunctionString = solrHelperServiceImpl.getSolrRangeFunctionString(minValue,
        new BigDecimal("2.3"));

    // Assert
    verify(minValue).toPlainString();
    assertEquals("frange incl=false l=2.3 u=2.3", actualSolrRangeFunctionString);
  }

  /**
   * Test
   * {@link SolrHelperServiceImpl#getSolrRangeFunctionString(BigDecimal, BigDecimal)}.
   * <ul>
   *   <li>Then return {@code frange incl=false l=2.3 u=2.3}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SolrHelperServiceImpl#getSolrRangeFunctionString(BigDecimal, BigDecimal)}
   */
  @Test
  public void testGetSolrRangeFunctionString_thenReturnFrangeInclFalseL23U23() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SolrHelperServiceImpl solrHelperServiceImpl = new SolrHelperServiceImpl();
    BigDecimal minValue = new BigDecimal("2.3");

    // Act and Assert
    assertEquals("frange incl=false l=2.3 u=2.3",
        solrHelperServiceImpl.getSolrRangeFunctionString(minValue, new BigDecimal("2.3")));
  }

  /**
   * Test
   * {@link SolrHelperServiceImpl#getSolrRangeFunctionString(BigDecimal, BigDecimal)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code frange incl=false l=2.3}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SolrHelperServiceImpl#getSolrRangeFunctionString(BigDecimal, BigDecimal)}
   */
  @Test
  public void testGetSolrRangeFunctionString_whenNull_thenReturnFrangeInclFalseL23() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SolrHelperServiceImpl solrHelperServiceImpl = new SolrHelperServiceImpl();

    // Act and Assert
    assertEquals("frange incl=false l=2.3",
        solrHelperServiceImpl.getSolrRangeFunctionString(new BigDecimal("2.3"), null));
  }

  /**
   * Test
   * {@link SolrHelperServiceImpl#getSolrFieldTag(String, String, SearchFacetRange)}.
   * <ul>
   *   <li>Then return {@code {!ex=Field Name Param=Field Name[2.3:*] frange
   * incl=false l=2.3}}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SolrHelperServiceImpl#getSolrFieldTag(String, String, SearchFacetRange)}
   */
  @Test
  public void testGetSolrFieldTag_thenReturnExFieldNameParamFieldName23FrangeInclFalseL23() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SolrHelperServiceImpl solrHelperServiceImpl = new SolrHelperServiceImpl();

    SearchFacetRangeImpl range = new SearchFacetRangeImpl();
    range.setId(1L);
    range.setMinValue(new BigDecimal("2.3"));
    range.setSearchFacet(new SearchFacetImpl());
    range.setMaxValue(null);

    // Act and Assert
    assertEquals("{!ex=Field Name Param=Field Name[2.3:*] frange incl=false l=2.3}",
        solrHelperServiceImpl.getSolrFieldTag("Field Name", "Param", range));
  }

  /**
   * Test
   * {@link SolrHelperServiceImpl#getSolrFieldTag(String, String, SearchFacetRange)}.
   * <ul>
   *   <li>Then return {@code {!ex=Field Name Param=Field Name[2.3:2.3] frange
   * incl=false l=2.3 u=2.3}}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SolrHelperServiceImpl#getSolrFieldTag(String, String, SearchFacetRange)}
   */
  @Test
  public void testGetSolrFieldTag_thenReturnExFieldNameParamFieldName2323FrangeInclFalseL23U23() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SolrHelperServiceImpl solrHelperServiceImpl = new SolrHelperServiceImpl();
    SearchFacetRangeImpl range = mock(SearchFacetRangeImpl.class);
    when(range.getMaxValue()).thenReturn(new BigDecimal("2.3"));
    when(range.getMinValue()).thenReturn(new BigDecimal("2.3"));

    // Act
    String actualSolrFieldTag = solrHelperServiceImpl.getSolrFieldTag("Field Name", "Param", range);

    // Assert
    verify(range, atLeast(1)).getMaxValue();
    verify(range, atLeast(1)).getMinValue();
    assertEquals("{!ex=Field Name Param=Field Name[2.3:2.3] frange incl=false l=2.3 u=2.3}", actualSolrFieldTag);
  }

  /**
   * Test
   * {@link SolrHelperServiceImpl#getSolrFieldTag(String, String, SearchFacetRange)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SolrHelperServiceImpl#getSolrFieldTag(String, String, SearchFacetRange)}
   */
  @Test
  public void testGetSolrFieldTag_whenNull_thenReturnEmptyString() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("", (new SolrHelperServiceImpl()).getSolrFieldTag(null, null, null));
    assertEquals("", (new SolrHelperServiceImpl()).getSolrFieldTag("Field Name", null, null));
  }

  /**
   * Test
   * {@link SolrHelperServiceImpl#getSolrFieldTag(String, String, SearchFacetRange)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code {!Param=Field Name}}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SolrHelperServiceImpl#getSolrFieldTag(String, String, SearchFacetRange)}
   */
  @Test
  public void testGetSolrFieldTag_whenNull_thenReturnParamFieldName() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("{!Param=Field Name}", (new SolrHelperServiceImpl()).getSolrFieldTag("Field Name", "Param", null));
  }

  /**
   * Test
   * {@link SolrHelperServiceImpl#getSolrFieldTag(String, String, SearchFacetRange)}.
   * <ul>
   *   <li>When {@link SearchFacetRangeImpl} (default constructor) MaxValue is
   * {@link BigDecimal#BigDecimal(String)} with {@code 2.3}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SolrHelperServiceImpl#getSolrFieldTag(String, String, SearchFacetRange)}
   */
  @Test
  public void testGetSolrFieldTag_whenSearchFacetRangeImplMaxValueIsBigDecimalWith23() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SolrHelperServiceImpl solrHelperServiceImpl = new SolrHelperServiceImpl();

    SearchFacetRangeImpl range = new SearchFacetRangeImpl();
    range.setId(1L);
    range.setMinValue(new BigDecimal("2.3"));
    range.setSearchFacet(new SearchFacetImpl());
    range.setMaxValue(new BigDecimal("2.3"));

    // Act and Assert
    assertEquals("{!ex=Field Name Param=Field Name[2.3:2.3] frange incl=false l=2.3 u=2.3}",
        solrHelperServiceImpl.getSolrFieldTag("Field Name", "Param", range));
  }

  /**
   * Test
   * {@link SolrHelperServiceImpl#getSolrFieldTag(String, String, SearchFacetRange)}.
   * <ul>
   *   <li>When {@code u=}.</li>
   *   <li>Then return {@code {!ex= u= Param= u=[2.3:2.3] frange incl=false l=2.3
   * u=2.3}}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SolrHelperServiceImpl#getSolrFieldTag(String, String, SearchFacetRange)}
   */
  @Test
  public void testGetSolrFieldTag_whenU_thenReturnExUParamU2323FrangeInclFalseL23U23() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SolrHelperServiceImpl solrHelperServiceImpl = new SolrHelperServiceImpl();
    SearchFacetRangeImpl range = mock(SearchFacetRangeImpl.class);
    when(range.getMaxValue()).thenReturn(new BigDecimal("2.3"));
    when(range.getMinValue()).thenReturn(new BigDecimal("2.3"));

    // Act
    String actualSolrFieldTag = solrHelperServiceImpl.getSolrFieldTag(" u=", "Param", range);

    // Assert
    verify(range, atLeast(1)).getMaxValue();
    verify(range, atLeast(1)).getMinValue();
    assertEquals("{!ex= u= Param= u=[2.3:2.3] frange incl=false l=2.3 u=2.3}", actualSolrFieldTag);
  }

  /**
   * Test {@link SolrHelperServiceImpl#buildSolrFacetField(String, String)}.
   * <ul>
   *   <li>When {@code Field Name}.</li>
   *   <li>Then return {@code {!ex=Field Name}}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SolrHelperServiceImpl#buildSolrFacetField(String, String)}
   */
  @Test
  public void testBuildSolrFacetField_whenFieldName_thenReturnExFieldName() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("{!ex=Field Name}", (new SolrHelperServiceImpl()).buildSolrFacetField("Field Name", null));
  }

  /**
   * Test {@link SolrHelperServiceImpl#buildSolrFacetField(String, String)}.
   * <ul>
   *   <li>When {@code Param}.</li>
   *   <li>Then return {@code {!Param=Field Name}}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SolrHelperServiceImpl#buildSolrFacetField(String, String)}
   */
  @Test
  public void testBuildSolrFacetField_whenParam_thenReturnParamFieldName() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("{!Param=Field Name}", (new SolrHelperServiceImpl()).buildSolrFacetField("Field Name", "Param"));
  }

  /**
   * Test
   * {@link SolrHelperServiceImpl#buildSolrFacetQuery(String, SearchFacetRange, Boolean, String)}.
   * <p>
   * Method under test:
   * {@link SolrHelperServiceImpl#buildSolrFacetQuery(String, SearchFacetRange, Boolean, String)}
   */
  @Test
  public void testBuildSolrFacetQuery() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SolrHelperServiceImpl solrHelperServiceImpl = new SolrHelperServiceImpl();
    SearchFacetRangeImpl range = mock(SearchFacetRangeImpl.class);
    when(range.getMaxValue()).thenReturn(new BigDecimal("2.3"));
    when(range.getMinValue()).thenReturn(new BigDecimal("2.3"));

    // Act
    String actualBuildSolrFacetQueryResult = solrHelperServiceImpl.buildSolrFacetQuery("Field Name", range, true,
        "Param");

    // Assert
    verify(range, atLeast(1)).getMaxValue();
    verify(range, atLeast(1)).getMinValue();
    assertEquals("{!ex=Field Name Param=Field Name[2.3:2.3] frange incl=false l=2.3 u=2.3}",
        actualBuildSolrFacetQueryResult);
  }

  /**
   * Test
   * {@link SolrHelperServiceImpl#buildSolrFacetQuery(String, SearchFacetRange, Boolean, String)}.
   * <p>
   * Method under test:
   * {@link SolrHelperServiceImpl#buildSolrFacetQuery(String, SearchFacetRange, Boolean, String)}
   */
  @Test
  public void testBuildSolrFacetQuery2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SolrHelperServiceImpl solrHelperServiceImpl = new SolrHelperServiceImpl();
    SearchFacetRangeImpl range = mock(SearchFacetRangeImpl.class);
    when(range.getMaxValue()).thenReturn(new BigDecimal("2.3"));
    when(range.getMinValue()).thenReturn(new BigDecimal("2.3"));

    // Act
    String actualBuildSolrFacetQueryResult = solrHelperServiceImpl.buildSolrFacetQuery("Field Name", range, true, null);

    // Assert
    verify(range, atLeast(1)).getMaxValue();
    verify(range, atLeast(1)).getMinValue();
    assertEquals("{!ex=Field Name key=Field Name[2.3:2.3] frange incl=false l=2.3 u=2.3}",
        actualBuildSolrFacetQueryResult);
  }

  /**
   * Test
   * {@link SolrHelperServiceImpl#buildSolrFacetQuery(String, SearchFacetRange, Boolean, String)}.
   * <ul>
   *   <li>Then return {@code {!ex=Field Name Param=Field Name[2.3:*] frange
   * incl=false l=2.3}}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SolrHelperServiceImpl#buildSolrFacetQuery(String, SearchFacetRange, Boolean, String)}
   */
  @Test
  public void testBuildSolrFacetQuery_thenReturnExFieldNameParamFieldName23FrangeInclFalseL23() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SolrHelperServiceImpl solrHelperServiceImpl = new SolrHelperServiceImpl();
    SearchFacetRangeImpl range = mock(SearchFacetRangeImpl.class);
    when(range.getMaxValue()).thenReturn(null);
    when(range.getMinValue()).thenReturn(new BigDecimal("2.3"));

    // Act
    String actualBuildSolrFacetQueryResult = solrHelperServiceImpl.buildSolrFacetQuery("Field Name", range, true,
        "Param");

    // Assert
    verify(range, atLeast(1)).getMaxValue();
    verify(range, atLeast(1)).getMinValue();
    assertEquals("{!ex=Field Name Param=Field Name[2.3:*] frange incl=false l=2.3}", actualBuildSolrFacetQueryResult);
  }

  /**
   * Test
   * {@link SolrHelperServiceImpl#buildSolrFacetQuery(String, SearchFacetRange, Boolean, String)}.
   * <ul>
   *   <li>Then return {@code {!ex=Field Name u==Field Name[2.3:2.3] frange
   * incl=false l=2.3 u=2.3}}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SolrHelperServiceImpl#buildSolrFacetQuery(String, SearchFacetRange, Boolean, String)}
   */
  @Test
  public void testBuildSolrFacetQuery_thenReturnExFieldNameUFieldName2323FrangeInclFalseL23U23() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SolrHelperServiceImpl solrHelperServiceImpl = new SolrHelperServiceImpl();
    SearchFacetRangeImpl range = mock(SearchFacetRangeImpl.class);
    when(range.getMaxValue()).thenReturn(new BigDecimal("2.3"));
    when(range.getMinValue()).thenReturn(new BigDecimal("2.3"));

    // Act
    String actualBuildSolrFacetQueryResult = solrHelperServiceImpl.buildSolrFacetQuery("Field Name", range, true,
        " u=");

    // Assert
    verify(range, atLeast(1)).getMaxValue();
    verify(range, atLeast(1)).getMinValue();
    assertEquals("{!ex=Field Name  u==Field Name[2.3:2.3] frange incl=false l=2.3 u=2.3}",
        actualBuildSolrFacetQueryResult);
  }

  /**
   * Test
   * {@link SolrHelperServiceImpl#buildSolrFacetQuery(String, SearchFacetRange, Boolean, String)}.
   * <ul>
   *   <li>Then return {@code {Param=Field Name[2.3:2.3] frange incl=false l=2.3
   * u=2.3}}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SolrHelperServiceImpl#buildSolrFacetQuery(String, SearchFacetRange, Boolean, String)}
   */
  @Test
  public void testBuildSolrFacetQuery_thenReturnParamFieldName2323FrangeInclFalseL23U23() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SolrHelperServiceImpl solrHelperServiceImpl = new SolrHelperServiceImpl();
    SearchFacetRangeImpl range = mock(SearchFacetRangeImpl.class);
    when(range.getMaxValue()).thenReturn(new BigDecimal("2.3"));
    when(range.getMinValue()).thenReturn(new BigDecimal("2.3"));

    // Act
    String actualBuildSolrFacetQueryResult = solrHelperServiceImpl.buildSolrFacetQuery("Field Name", range, false,
        "Param");

    // Assert
    verify(range, atLeast(1)).getMaxValue();
    verify(range, atLeast(1)).getMinValue();
    assertEquals("{Param=Field Name[2.3:2.3] frange incl=false l=2.3 u=2.3}", actualBuildSolrFacetQueryResult);
  }

  /**
   * Test
   * {@link SolrHelperServiceImpl#attachFacets(SolrQuery, Map, SearchCriteria)}
   * with {@code query}, {@code namedFacetMap}, {@code searchCriteria}.
   * <ul>
   *   <li>Then calls {@link SolrQuery#addTermsField(String)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SolrHelperServiceImpl#attachFacets(SolrQuery, Map, SearchCriteria)}
   */
  @Test
  public void testAttachFacetsWithQueryNamedFacetMapSearchCriteria_thenCallsAddTermsField() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SolrHelperServiceImpl solrHelperServiceImpl = new SolrHelperServiceImpl();
    SolrQuery query = mock(SolrQuery.class);
    when(query.addTermsField(Mockito.<String>any())).thenReturn(new SolrQuery("foo"));
    when(query.setFacet(anyBoolean())).thenReturn(new SolrQuery("foo"));
    query.addTermsField("42");
    HashMap<String, SearchFacetDTO> namedFacetMap = new HashMap<>();

    // Act
    solrHelperServiceImpl.attachFacets(query, namedFacetMap, new SearchCriteria());

    // Assert
    verify(query).addTermsField(eq("42"));
    verify(query).setFacet(eq(true));
  }

  /**
   * Test {@link SolrHelperServiceImpl#attachFacets(SolrQuery, Map)} with
   * {@code query}, {@code namedFacetMap}.
   * <ul>
   *   <li>Then calls {@link SolrQuery#addTermsField(String)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrHelperServiceImpl#attachFacets(SolrQuery, Map)}
   */
  @Test
  public void testAttachFacetsWithQueryNamedFacetMap_thenCallsAddTermsField() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SolrHelperServiceImpl solrHelperServiceImpl = new SolrHelperServiceImpl();
    SolrQuery query = mock(SolrQuery.class);
    when(query.addTermsField(Mockito.<String>any())).thenReturn(new SolrQuery("foo"));
    when(query.setFacet(anyBoolean())).thenReturn(new SolrQuery("foo"));
    query.addTermsField("42");

    // Act
    solrHelperServiceImpl.attachFacets(query, new HashMap<>());

    // Assert
    verify(query).addTermsField(eq("42"));
    verify(query).setFacet(eq(true));
  }

  /**
   * Test
   * {@link SolrHelperServiceImpl#getSolrTaggedFieldString(String, String, SearchFacetRange)}.
   * <p>
   * Method under test:
   * {@link SolrHelperServiceImpl#getSolrTaggedFieldString(String, String, SearchFacetRange)}
   */
  @Test
  public void testGetSolrTaggedFieldString() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SolrHelperServiceImpl solrHelperServiceImpl = new SolrHelperServiceImpl();

    SearchFacetRangeImpl range = new SearchFacetRangeImpl();
    range.setId(1L);
    range.setMinValue(new BigDecimal("2.3"));
    range.setSearchFacet(new SearchFacetImpl());
    range.setMaxValue(null);

    // Act and Assert
    assertEquals("{!ex=Index Field Tag=Index Field[2.3:*] frange incl=false l=2.3}field(Index Field)",
        solrHelperServiceImpl.getSolrTaggedFieldString("Index Field", "Tag", range));
  }

  /**
   * Test
   * {@link SolrHelperServiceImpl#getSolrTaggedFieldString(String, String, SearchFacetRange)}.
   * <p>
   * Method under test:
   * {@link SolrHelperServiceImpl#getSolrTaggedFieldString(String, String, SearchFacetRange)}
   */
  @Test
  public void testGetSolrTaggedFieldString2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SolrHelperServiceImpl solrHelperServiceImpl = new SolrHelperServiceImpl();
    SearchFacetRangeImpl range = mock(SearchFacetRangeImpl.class);
    when(range.getMaxValue()).thenReturn(new BigDecimal("2.3"));
    when(range.getMinValue()).thenReturn(new BigDecimal("2.3"));

    // Act
    String actualSolrTaggedFieldString = solrHelperServiceImpl.getSolrTaggedFieldString("Index Field", "Tag", range);

    // Assert
    verify(range, atLeast(1)).getMaxValue();
    verify(range, atLeast(1)).getMinValue();
    assertEquals("{!ex=Index Field Tag=Index Field[2.3:2.3] frange incl=false l=2.3 u=2.3}field(Index Field)",
        actualSolrTaggedFieldString);
  }

  /**
   * Test
   * {@link SolrHelperServiceImpl#getSolrTaggedFieldString(String, String, SearchFacetRange)}.
   * <ul>
   *   <li>Then return {@code {!ex= u= Tag= u=[2.3:2.3] frange incl=false l=2.3
   * u=2.3}field( u=)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SolrHelperServiceImpl#getSolrTaggedFieldString(String, String, SearchFacetRange)}
   */
  @Test
  public void testGetSolrTaggedFieldString_thenReturnExUTagU2323FrangeInclFalseL23U23FieldU() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SolrHelperServiceImpl solrHelperServiceImpl = new SolrHelperServiceImpl();
    SearchFacetRangeImpl range = mock(SearchFacetRangeImpl.class);
    when(range.getMaxValue()).thenReturn(new BigDecimal("2.3"));
    when(range.getMinValue()).thenReturn(new BigDecimal("2.3"));

    // Act
    String actualSolrTaggedFieldString = solrHelperServiceImpl.getSolrTaggedFieldString(" u=", "Tag", range);

    // Assert
    verify(range, atLeast(1)).getMaxValue();
    verify(range, atLeast(1)).getMinValue();
    assertEquals("{!ex= u= Tag= u=[2.3:2.3] frange incl=false l=2.3 u=2.3}field( u=)", actualSolrTaggedFieldString);
  }

  /**
   * Test
   * {@link SolrHelperServiceImpl#getSolrTaggedFieldString(String, String, SearchFacetRange)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code Index Field}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SolrHelperServiceImpl#getSolrTaggedFieldString(String, String, SearchFacetRange)}
   */
  @Test
  public void testGetSolrTaggedFieldString_whenNull_thenReturnIndexField() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("Index Field", (new SolrHelperServiceImpl()).getSolrTaggedFieldString("Index Field", null, null));
  }

  /**
   * Test
   * {@link SolrHelperServiceImpl#getSolrTaggedFieldString(String, String, SearchFacetRange)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SolrHelperServiceImpl#getSolrTaggedFieldString(String, String, SearchFacetRange)}
   */
  @Test
  public void testGetSolrTaggedFieldString_whenNull_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("null", (new SolrHelperServiceImpl()).getSolrTaggedFieldString(null, null, null));
  }

  /**
   * Test
   * {@link SolrHelperServiceImpl#getSolrTaggedFieldString(String, String, SearchFacetRange)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code {!Tag=Index Field}Index Field}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SolrHelperServiceImpl#getSolrTaggedFieldString(String, String, SearchFacetRange)}
   */
  @Test
  public void testGetSolrTaggedFieldString_whenNull_thenReturnTagIndexFieldIndexField() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("{!Tag=Index Field}Index Field",
        (new SolrHelperServiceImpl()).getSolrTaggedFieldString("Index Field", "Tag", null));
  }

  /**
   * Test
   * {@link SolrHelperServiceImpl#getSolrTaggedFieldString(String, String, SearchFacetRange)}.
   * <ul>
   *   <li>When {@link SearchFacetRangeImpl} (default constructor) MaxValue is
   * {@link BigDecimal#BigDecimal(String)} with {@code 2.3}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SolrHelperServiceImpl#getSolrTaggedFieldString(String, String, SearchFacetRange)}
   */
  @Test
  public void testGetSolrTaggedFieldString_whenSearchFacetRangeImplMaxValueIsBigDecimalWith23() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SolrHelperServiceImpl solrHelperServiceImpl = new SolrHelperServiceImpl();

    SearchFacetRangeImpl range = new SearchFacetRangeImpl();
    range.setId(1L);
    range.setMinValue(new BigDecimal("2.3"));
    range.setSearchFacet(new SearchFacetImpl());
    range.setMaxValue(new BigDecimal("2.3"));

    // Act and Assert
    assertEquals("{!ex=Index Field Tag=Index Field[2.3:2.3] frange incl=false l=2.3 u=2.3}field(Index Field)",
        solrHelperServiceImpl.getSolrTaggedFieldString("Index Field", "Tag", range));
  }

  /**
   * Test
   * {@link SolrHelperServiceImpl#getSolrTaggedFieldString(String, String, SearchFacetRange)}.
   * <ul>
   *   <li>When {@link SearchFacetRangeImpl} (default constructor).</li>
   *   <li>Then return {@code field(null)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SolrHelperServiceImpl#getSolrTaggedFieldString(String, String, SearchFacetRange)}
   */
  @Test
  public void testGetSolrTaggedFieldString_whenSearchFacetRangeImpl_thenReturnFieldNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SolrHelperServiceImpl solrHelperServiceImpl = new SolrHelperServiceImpl();

    // Act and Assert
    assertEquals("field(null)", solrHelperServiceImpl.getSolrTaggedFieldString(null, null, new SearchFacetRangeImpl()));
  }

  /**
   * Test {@link SolrHelperServiceImpl#getResponseDocuments(QueryResponse)}.
   * <p>
   * Method under test:
   * {@link SolrHelperServiceImpl#getResponseDocuments(QueryResponse)}
   */
  @Test
  public void testGetResponseDocuments() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SolrHelperServiceImpl solrHelperServiceImpl = new SolrHelperServiceImpl();
    new SolrServerException("An error occurred");

    GroupResponse groupResponse = new GroupResponse();
    groupResponse.add(new GroupCommand("Name", 1));
    QueryResponse response = mock(QueryResponse.class);
    when(response.getGroupResponse()).thenReturn(groupResponse);

    // Act
    List<SolrDocument> actualResponseDocuments = solrHelperServiceImpl.getResponseDocuments(response);

    // Assert
    verify(response, atLeast(1)).getGroupResponse();
    assertTrue(actualResponseDocuments.isEmpty());
  }

  /**
   * Test {@link SolrHelperServiceImpl#getResponseDocuments(QueryResponse)}.
   * <ul>
   *   <li>Given {@link GroupResponse} (default constructor).</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SolrHelperServiceImpl#getResponseDocuments(QueryResponse)}
   */
  @Test
  public void testGetResponseDocuments_givenGroupResponse_thenReturnEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SolrHelperServiceImpl solrHelperServiceImpl = new SolrHelperServiceImpl();
    new SolrServerException("An error occurred");
    QueryResponse response = mock(QueryResponse.class);
    when(response.getGroupResponse()).thenReturn(new GroupResponse());

    // Act
    List<SolrDocument> actualResponseDocuments = solrHelperServiceImpl.getResponseDocuments(response);

    // Assert
    verify(response, atLeast(1)).getGroupResponse();
    assertTrue(actualResponseDocuments.isEmpty());
  }

  /**
   * Test {@link SolrHelperServiceImpl#getResponseDocuments(QueryResponse)}.
   * <ul>
   *   <li>When {@link QueryResponse#QueryResponse(SolrClient)} with solrClient is
   * {@link LBHttp2SolrClient}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SolrHelperServiceImpl#getResponseDocuments(QueryResponse)}
   */
  @Test
  public void testGetResponseDocuments_whenQueryResponseWithSolrClientIsLBHttp2SolrClient() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SolrHelperServiceImpl solrHelperServiceImpl = new SolrHelperServiceImpl();

    // Act and Assert
    assertNull(solrHelperServiceImpl.getResponseDocuments(new QueryResponse(mock(LBHttp2SolrClient.class))));
  }

  /**
   * Test {@link SolrHelperServiceImpl#getResponseDocuments(QueryResponse)}.
   * <ul>
   *   <li>When {@link QueryResponse#QueryResponse()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SolrHelperServiceImpl#getResponseDocuments(QueryResponse)}
   */
  @Test
  public void testGetResponseDocuments_whenQueryResponse_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SolrHelperServiceImpl solrHelperServiceImpl = new SolrHelperServiceImpl();

    // Act and Assert
    assertNull(solrHelperServiceImpl.getResponseDocuments(new QueryResponse()));
  }

  /**
   * Test {@link SolrHelperServiceImpl#getSortableFieldTypes()}.
   * <p>
   * Method under test: {@link SolrHelperServiceImpl#getSortableFieldTypes()}
   */
  @Test
  public void testGetSortableFieldTypes() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    List<String> actualSortableFieldTypes = (new SolrHelperServiceImpl()).getSortableFieldTypes();

    // Assert
    assertEquals(5, actualSortableFieldTypes.size());
    assertEquals("i", actualSortableFieldTypes.get(3));
    assertEquals("l", actualSortableFieldTypes.get(4));
    assertEquals("p", actualSortableFieldTypes.get(2));
    assertEquals("s", actualSortableFieldTypes.get(1));
    assertEquals("sort", actualSortableFieldTypes.get(0));
  }

  /**
   * Test {@link SolrHelperServiceImpl#getSortOrder(String[], String)}.
   * <p>
   * Method under test:
   * {@link SolrHelperServiceImpl#getSortOrder(String[], String)}
   */
  @Test
  public void testGetSortOrder() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals(SolrQuery.ORDER.asc, (new SolrHelperServiceImpl()).getSortOrder(
        new String[]{"Solr sortquery received was ", ", but no sorting tokens could be extracted."}, "Sort Query"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#getSortOrder(String[], String)}.
   * <ul>
   *   <li>When array of {@link String} with {@code Sort Fields Segments} and
   * {@code desc}.</li>
   *   <li>Then return {@code desc}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SolrHelperServiceImpl#getSortOrder(String[], String)}
   */
  @Test
  public void testGetSortOrder_whenArrayOfStringWithSortFieldsSegmentsAndDesc_thenReturnDesc() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals(SolrQuery.ORDER.desc,
        (new SolrHelperServiceImpl()).getSortOrder(new String[]{"Sort Fields Segments", "desc"}, null));
  }

  /**
   * Test {@link SolrHelperServiceImpl#getSortOrder(String[], String)}.
   * <ul>
   *   <li>When array of {@link String} with {@code Sort Fields Segments}.</li>
   *   <li>Then return {@code asc}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SolrHelperServiceImpl#getSortOrder(String[], String)}
   */
  @Test
  public void testGetSortOrder_whenArrayOfStringWithSortFieldsSegments_thenReturnAsc() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals(SolrQuery.ORDER.asc,
        (new SolrHelperServiceImpl()).getSortOrder(new String[]{"Sort Fields Segments"}, "Sort Query"));
  }

  /**
   * Test {@link SolrHelperServiceImpl#getSolrFieldKeyMap(SearchCriteria, List)}.
   * <ul>
   *   <li>Given {@link IndexFieldImpl} (default constructor).</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link IndexFieldImpl} (default
   * constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SolrHelperServiceImpl#getSolrFieldKeyMap(SearchCriteria, List)}
   */
  @Test
  public void testGetSolrFieldKeyMap_givenIndexFieldImpl_whenArrayListAddIndexFieldImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SolrHelperServiceImpl solrHelperServiceImpl = new SolrHelperServiceImpl();
    SearchCriteria searchCriteria = new SearchCriteria();

    ArrayList<IndexField> fields = new ArrayList<>();
    fields.add(new IndexFieldImpl());

    // Act and Assert
    assertTrue(solrHelperServiceImpl.getSolrFieldKeyMap(searchCriteria, fields).isEmpty());
  }

  /**
   * Test {@link SolrHelperServiceImpl#getSolrFieldKeyMap(SearchCriteria, List)}.
   * <ul>
   *   <li>Given {@link IndexFieldImpl} (default constructor).</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link IndexFieldImpl} (default
   * constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SolrHelperServiceImpl#getSolrFieldKeyMap(SearchCriteria, List)}
   */
  @Test
  public void testGetSolrFieldKeyMap_givenIndexFieldImpl_whenArrayListAddIndexFieldImpl2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SolrHelperServiceImpl solrHelperServiceImpl = new SolrHelperServiceImpl();
    SearchCriteria searchCriteria = new SearchCriteria();

    ArrayList<IndexField> fields = new ArrayList<>();
    fields.add(new IndexFieldImpl());
    fields.add(new IndexFieldImpl());

    // Act and Assert
    assertTrue(solrHelperServiceImpl.getSolrFieldKeyMap(searchCriteria, fields).isEmpty());
  }

  /**
   * Test {@link SolrHelperServiceImpl#getSolrFieldKeyMap(SearchCriteria, List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SolrHelperServiceImpl#getSolrFieldKeyMap(SearchCriteria, List)}
   */
  @Test
  public void testGetSolrFieldKeyMap_whenArrayList_thenReturnEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SolrHelperServiceImpl solrHelperServiceImpl = new SolrHelperServiceImpl();
    SearchCriteria searchCriteria = new SearchCriteria();

    // Act and Assert
    assertTrue(solrHelperServiceImpl.getSolrFieldKeyMap(searchCriteria, new ArrayList<>()).isEmpty());
  }

  /**
   * Test {@link SolrHelperServiceImpl#getSolrFieldKeyMap(SearchCriteria, List)}.
   * <ul>
   *   <li>When {@link SearchCriteria}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SolrHelperServiceImpl#getSolrFieldKeyMap(SearchCriteria, List)}
   */
  @Test
  public void testGetSolrFieldKeyMap_whenSearchCriteria_thenReturnEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SolrHelperServiceImpl solrHelperServiceImpl = new SolrHelperServiceImpl();
    SearchCriteria searchCriteria = mock(SearchCriteria.class);

    // Act and Assert
    assertTrue(solrHelperServiceImpl.getSolrFieldKeyMap(searchCriteria, new ArrayList<>()).isEmpty());
  }

  /**
   * Test {@link SolrHelperServiceImpl#getNamedFacetMap(List, SearchCriteria)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SolrHelperServiceImpl#getNamedFacetMap(List, SearchCriteria)}
   */
  @Test
  public void testGetNamedFacetMap_whenArrayList_thenReturnEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SolrHelperServiceImpl solrHelperServiceImpl = new SolrHelperServiceImpl();
    ArrayList<SearchFacetDTO> facets = new ArrayList<>();

    // Act and Assert
    assertTrue(solrHelperServiceImpl.getNamedFacetMap(facets, new SearchCriteria()).isEmpty());
  }

  /**
   * Test {@link SolrHelperServiceImpl#getNamedFacetMap(List, SearchCriteria)}.
   * <ul>
   *   <li>When {@link SearchCriteria}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SolrHelperServiceImpl#getNamedFacetMap(List, SearchCriteria)}
   */
  @Test
  public void testGetNamedFacetMap_whenSearchCriteria_thenReturnEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SolrHelperServiceImpl solrHelperServiceImpl = new SolrHelperServiceImpl();

    // Act and Assert
    assertTrue(solrHelperServiceImpl.getNamedFacetMap(new ArrayList<>(), mock(SearchCriteria.class)).isEmpty());
  }

  /**
   * Test
   * {@link SolrHelperServiceImpl#attachActiveFacetFilters(SolrQuery, Map, SearchCriteria)}.
   * <ul>
   *   <li>Given {@link SolrQuery#SolrQuery(String)} with q is {@code foo}.</li>
   *   <li>Then calls {@link SolrQuery#addTermsField(String)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SolrHelperServiceImpl#attachActiveFacetFilters(SolrQuery, Map, SearchCriteria)}
   */
  @Test
  public void testAttachActiveFacetFilters_givenSolrQueryWithQIsFoo_thenCallsAddTermsField() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SolrHelperServiceImpl solrHelperServiceImpl = new SolrHelperServiceImpl();
    SolrQuery query = mock(SolrQuery.class);
    when(query.addTermsField(Mockito.<String>any())).thenReturn(new SolrQuery("foo"));
    query.addTermsField("42");
    HashMap<String, SearchFacetDTO> namedFacetMap = new HashMap<>();

    // Act
    solrHelperServiceImpl.attachActiveFacetFilters(query, namedFacetMap, new SearchCriteria());

    // Assert that nothing has changed
    verify(query).addTermsField(eq("42"));
  }

  /**
   * Test
   * {@link SolrHelperServiceImpl#getPropertyValueInternal(Object, String[], int)}.
   * <p>
   * Method under test:
   * {@link SolrHelperServiceImpl#getPropertyValueInternal(Object, String[], int)}
   */
  @Test
  public void testGetPropertyValueInternal()
      throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new SolrHelperServiceImpl()).getPropertyValueInternal("Object",
        new String[]{"Components", "exploitProtection.xssEnabled"}, 1));
  }

  /**
   * Test
   * {@link SolrHelperServiceImpl#getPropertyValueInternal(Object, String[], int)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SolrHelperServiceImpl#getPropertyValueInternal(Object, String[], int)}
   */
  @Test
  public void testGetPropertyValueInternal_whenNull_thenReturnNull()
      throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new SolrHelperServiceImpl()).getPropertyValueInternal(null, new String[]{"Components"}, 1));
  }

  /**
   * Test
   * {@link SolrHelperServiceImpl#getPropertyValueInternal(Object, String[], int)}.
   * <ul>
   *   <li>When zero.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SolrHelperServiceImpl#getPropertyValueInternal(Object, String[], int)}
   */
  @Test
  public void testGetPropertyValueInternal_whenZero_thenReturnNull()
      throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new SolrHelperServiceImpl()).getPropertyValueInternal("Object", new String[]{"Components"}, 0));
  }

  /**
   * Test
   * {@link SolrHelperServiceImpl#copyPropertyToCollection(Collection, Object)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.</li>
   *   <li>Then {@link ArrayList#ArrayList()} size is two.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SolrHelperServiceImpl#copyPropertyToCollection(Collection, Object)}
   */
  @Test
  public void testCopyPropertyToCollection_given42_whenArrayListAdd42_thenArrayListSizeIsTwo() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SolrHelperServiceImpl solrHelperServiceImpl = new SolrHelperServiceImpl();

    ArrayList<Object> collection = new ArrayList<>();
    collection.add("42");

    // Act
    solrHelperServiceImpl.copyPropertyToCollection(collection, "42");

    // Assert
    assertEquals(2, collection.size());
    assertEquals("42", collection.get(0));
    assertEquals("42", collection.get(1));
  }

  /**
   * Test
   * {@link SolrHelperServiceImpl#copyPropertyToCollection(Collection, Object)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then {@link ArrayList#ArrayList()} size is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SolrHelperServiceImpl#copyPropertyToCollection(Collection, Object)}
   */
  @Test
  public void testCopyPropertyToCollection_whenArrayList_thenArrayListSizeIsOne() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SolrHelperServiceImpl solrHelperServiceImpl = new SolrHelperServiceImpl();
    ArrayList<Object> collection = new ArrayList<>();

    // Act
    solrHelperServiceImpl.copyPropertyToCollection(collection, "42");

    // Assert
    assertEquals(1, collection.size());
    assertEquals("42", collection.get(0));
  }

  /**
   * Test
   * {@link SolrHelperServiceImpl#copyPropertyToCollection(Collection, Object)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link ArrayList#ArrayList()} Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SolrHelperServiceImpl#copyPropertyToCollection(Collection, Object)}
   */
  @Test
  public void testCopyPropertyToCollection_whenNull_thenArrayListEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SolrHelperServiceImpl solrHelperServiceImpl = new SolrHelperServiceImpl();
    ArrayList<Object> collection = new ArrayList<>();

    // Act
    solrHelperServiceImpl.copyPropertyToCollection(collection, null);

    // Assert that nothing has changed
    assertTrue(collection.isEmpty());
  }
}
