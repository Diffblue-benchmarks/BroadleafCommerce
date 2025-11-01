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
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrServerException;
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
import org.junit.Test;
import org.mockito.Mockito;

public class SolrIndexServiceImplDiffblueTest {
  /**
   * Method under test:
   * {@link SolrIndexServiceImpl#performCachedOperation(SolrIndexCachedOperation.CacheOperation)}
   */
  @Test
  public void testPerformCachedOperation() throws ServiceException {
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
   * Method under test:
   * {@link SolrIndexServiceImpl#performCachedOperation(SolrIndexCachedOperation.CacheOperation)}
   */
  @Test
  public void testPerformCachedOperation2() throws ServiceException {
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
   * Method under test:
   * {@link SolrIndexServiceImpl#executeSolrIndexOperation(SolrIndexOperation)}
   */
  @Test
  public void testExecuteSolrIndexOperation() throws IOException, ServiceException {
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
   * Method under test:
   * {@link SolrIndexServiceImpl#deleteAllDocuments(String, SolrClient)}
   */
  @Test
  public void testDeleteAllDocuments() throws IOException, SolrServerException, ServiceException {
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
   * Method under test:
   * {@link SolrIndexServiceImpl#deleteAllDocuments(SolrClient)}
   */
  @Test
  public void testDeleteAllDocuments2() throws IOException, SolrServerException, ServiceException {
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
   * Method under test: {@link SolrIndexServiceImpl#useLegacyIndexer()}
   */
  @Test
  public void testUseLegacyIndexer() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new SolrIndexServiceImpl()).useLegacyIndexer());
  }

  /**
   * Method under test:
   * {@link SolrIndexServiceImpl#buildDocument(Indexable, List, List)}
   */
  @Test
  public void testBuildDocument() {
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
   * Method under test:
   * {@link SolrIndexServiceImpl#buildDocument(Indexable, List, List)}
   */
  @Test
  public void testBuildDocument2() {
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
   * Method under test:
   * {@link SolrIndexServiceImpl#buildDocument(Indexable, List, List)}
   */
  @Test
  public void testBuildDocument3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SolrIndexServiceImpl solrIndexServiceImpl = new SolrIndexServiceImpl();
    Indexable indexable = mock(Indexable.class);

    ArrayList<IndexField> fields = new ArrayList<>();
    fields.add(new IndexFieldImpl());
    fields.add(new IndexFieldImpl());

    // Act and Assert
    assertThrows(IllegalStateException.class,
        () -> solrIndexServiceImpl.buildDocument(indexable, fields, new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link SolrIndexServiceImpl#buildDocument(Indexable, List, List)}
   */
  @Test
  public void testBuildDocument4() {
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
   * Method under test:
   * {@link SolrIndexServiceImpl#buildDocument(Indexable, List, List)}
   */
  @Test
  public void testBuildDocument5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SolrIndexServiceImpl solrIndexServiceImpl = new SolrIndexServiceImpl();
    Indexable indexable = mock(Indexable.class);
    ArrayList<IndexField> fields = new ArrayList<>();

    ArrayList<Locale> locales = new ArrayList<>();
    locales.add(new LocaleImpl());
    locales.add(new LocaleImpl());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> solrIndexServiceImpl.buildDocument(indexable, fields, locales));
  }

  /**
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
   * Method under test:
   * {@link SolrIndexServiceImpl#attachIndexableDocumentFields(SolrInputDocument, Indexable, List, List)}
   */
  @Test
  public void testAttachIndexableDocumentFields2() {
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
   * Method under test:
   * {@link SolrIndexServiceImpl#attachBasicDocumentFields(Indexable, SolrInputDocument)}
   */
  @Test
  public void testAttachBasicDocumentFields() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SolrIndexServiceImpl solrIndexServiceImpl = new SolrIndexServiceImpl();

    // Act and Assert
    assertThrows(IllegalStateException.class,
        () -> solrIndexServiceImpl.attachBasicDocumentFields(new ProductBundleImpl(), null));
  }

  /**
   * Method under test:
   * {@link SolrIndexServiceImpl#convertToMappedProperty(String, String, String)}
   */
  @Test
  public void testConvertToMappedProperty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("Property Name", (new SolrIndexServiceImpl()).convertToMappedProperty("Property Name",
        "List Property Name", "Map Property Name"));
    assertEquals("",
        (new SolrIndexServiceImpl()).convertToMappedProperty("\\.", "List Property Name", "Map Property Name"));
    assertEquals("",
        (new SolrIndexServiceImpl()).convertToMappedProperty("", "List Property Name", "Map Property Name"));
    assertEquals("java.lang.Long", (new SolrIndexServiceImpl()).convertToMappedProperty("java.lang.Long",
        "List Property Name", "Map Property Name"));
    assertEquals("Map Property Name(lang).value.Long",
        (new SolrIndexServiceImpl()).convertToMappedProperty("java.lang.Long", "java", "Map Property Name"));
  }

  /**
   * Method under test:
   * {@link SolrIndexServiceImpl#commit(String, SolrClient, boolean, boolean, boolean)}
   */
  @Test
  public void testCommit() throws IOException, SolrServerException, ServiceException {
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
   * Method under test:
   * {@link SolrIndexServiceImpl#commit(String, SolrClient, boolean, boolean, boolean)}
   */
  @Test
  public void testCommit2() throws IOException, SolrServerException, ServiceException {
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
   * Method under test:
   * {@link SolrIndexServiceImpl#commit(SolrClient, boolean, boolean, boolean)}
   */
  @Test
  public void testCommit3() throws IOException, SolrServerException, ServiceException {
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
   * Method under test:
   * {@link SolrIndexServiceImpl#commit(SolrClient, boolean, boolean, boolean)}
   */
  @Test
  public void testCommit4() throws IOException, SolrServerException, ServiceException {
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
   * Method under test:
   * {@link SolrIndexServiceImpl#convertDisplayOrderToLong(CatalogStructure, String)}
   */
  @Test
  public void testConvertDisplayOrderToLong2() {
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
