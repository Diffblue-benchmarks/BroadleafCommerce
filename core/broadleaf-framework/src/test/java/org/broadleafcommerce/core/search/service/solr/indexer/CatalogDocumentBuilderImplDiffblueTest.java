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
package org.broadleafcommerce.core.search.service.solr.indexer;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.solr.common.SolrInputDocument;
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

public class CatalogDocumentBuilderImplDiffblueTest {
  /**
   * Test {@link CatalogDocumentBuilderImpl#buildDocument(Indexable, List, List)}.
   * <ul>
   *   <li>Given {@link IndexFieldImpl} (default constructor).</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link IndexFieldImpl} (default
   * constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CatalogDocumentBuilderImpl#buildDocument(Indexable, List, List)}
   */
  @Test
  public void testBuildDocument_givenIndexFieldImpl_whenArrayListAddIndexFieldImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CatalogDocumentBuilderImpl catalogDocumentBuilderImpl = new CatalogDocumentBuilderImpl();
    Indexable indexable = mock(Indexable.class);
    when(indexable.getId()).thenReturn(1L);

    ArrayList<IndexField> fields = new ArrayList<>();
    fields.add(new IndexFieldImpl());

    // Act
    SolrInputDocument actualBuildDocumentResult = catalogDocumentBuilderImpl.buildDocument(indexable, fields,
        new ArrayList<>());

    // Assert
    verify(indexable).getId();
    assertNull(actualBuildDocumentResult);
  }

  /**
   * Test {@link CatalogDocumentBuilderImpl#buildDocument(Indexable, List, List)}.
   * <ul>
   *   <li>Given {@link IndexFieldImpl} (default constructor).</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link IndexFieldImpl} (default
   * constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CatalogDocumentBuilderImpl#buildDocument(Indexable, List, List)}
   */
  @Test
  public void testBuildDocument_givenIndexFieldImpl_whenArrayListAddIndexFieldImpl2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CatalogDocumentBuilderImpl catalogDocumentBuilderImpl = new CatalogDocumentBuilderImpl();
    Indexable indexable = mock(Indexable.class);
    when(indexable.getId()).thenReturn(1L);

    ArrayList<IndexField> fields = new ArrayList<>();
    fields.add(new IndexFieldImpl());
    fields.add(new IndexFieldImpl());

    // Act
    SolrInputDocument actualBuildDocumentResult = catalogDocumentBuilderImpl.buildDocument(indexable, fields,
        new ArrayList<>());

    // Assert
    verify(indexable).getId();
    assertNull(actualBuildDocumentResult);
  }

  /**
   * Test {@link CatalogDocumentBuilderImpl#buildDocument(Indexable, List, List)}.
   * <ul>
   *   <li>Given {@link LocaleImpl} (default constructor).</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link LocaleImpl} (default
   * constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CatalogDocumentBuilderImpl#buildDocument(Indexable, List, List)}
   */
  @Test
  public void testBuildDocument_givenLocaleImpl_whenArrayListAddLocaleImpl_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CatalogDocumentBuilderImpl catalogDocumentBuilderImpl = new CatalogDocumentBuilderImpl();
    Indexable indexable = mock(Indexable.class);
    when(indexable.getId()).thenReturn(1L);
    ArrayList<IndexField> fields = new ArrayList<>();

    ArrayList<Locale> locales = new ArrayList<>();
    locales.add(new LocaleImpl());

    // Act
    SolrInputDocument actualBuildDocumentResult = catalogDocumentBuilderImpl.buildDocument(indexable, fields, locales);

    // Assert
    verify(indexable).getId();
    assertNull(actualBuildDocumentResult);
  }

  /**
   * Test {@link CatalogDocumentBuilderImpl#buildDocument(Indexable, List, List)}.
   * <ul>
   *   <li>Given {@link LocaleImpl} (default constructor).</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link LocaleImpl} (default
   * constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CatalogDocumentBuilderImpl#buildDocument(Indexable, List, List)}
   */
  @Test
  public void testBuildDocument_givenLocaleImpl_whenArrayListAddLocaleImpl_thenReturnNull2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CatalogDocumentBuilderImpl catalogDocumentBuilderImpl = new CatalogDocumentBuilderImpl();
    Indexable indexable = mock(Indexable.class);
    when(indexable.getId()).thenReturn(1L);
    ArrayList<IndexField> fields = new ArrayList<>();

    ArrayList<Locale> locales = new ArrayList<>();
    locales.add(new LocaleImpl());
    locales.add(new LocaleImpl());

    // Act
    SolrInputDocument actualBuildDocumentResult = catalogDocumentBuilderImpl.buildDocument(indexable, fields, locales);

    // Assert
    verify(indexable).getId();
    assertNull(actualBuildDocumentResult);
  }

  /**
   * Test {@link CatalogDocumentBuilderImpl#buildDocument(Indexable, List, List)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>When {@link Indexable} {@link Indexable#getId()} return one.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CatalogDocumentBuilderImpl#buildDocument(Indexable, List, List)}
   */
  @Test
  public void testBuildDocument_givenOne_whenIndexableGetIdReturnOne_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CatalogDocumentBuilderImpl catalogDocumentBuilderImpl = new CatalogDocumentBuilderImpl();
    Indexable indexable = mock(Indexable.class);
    when(indexable.getId()).thenReturn(1L);
    ArrayList<IndexField> fields = new ArrayList<>();

    // Act
    SolrInputDocument actualBuildDocumentResult = catalogDocumentBuilderImpl.buildDocument(indexable, fields,
        new ArrayList<>());

    // Assert
    verify(indexable).getId();
    assertNull(actualBuildDocumentResult);
  }

  /**
   * Test {@link CatalogDocumentBuilderImpl#buildDocument(Indexable, List, List)}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CatalogDocumentBuilderImpl#buildDocument(Indexable, List, List)}
   */
  @Test
  public void testBuildDocument_thenThrowIllegalStateException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CatalogDocumentBuilderImpl catalogDocumentBuilderImpl = new CatalogDocumentBuilderImpl();
    Indexable indexable = mock(Indexable.class);
    when(indexable.getId()).thenThrow(new IllegalStateException("blPU"));
    ArrayList<IndexField> fields = new ArrayList<>();

    // Act and Assert
    assertThrows(IllegalStateException.class,
        () -> catalogDocumentBuilderImpl.buildDocument(indexable, fields, new ArrayList<>()));
    verify(indexable).getId();
  }

  /**
   * Test {@link CatalogDocumentBuilderImpl#buildDocument(Indexable, List, List)}.
   * <ul>
   *   <li>When {@link ProductBundleImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CatalogDocumentBuilderImpl#buildDocument(Indexable, List, List)}
   */
  @Test
  public void testBuildDocument_whenProductBundleImpl_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CatalogDocumentBuilderImpl catalogDocumentBuilderImpl = new CatalogDocumentBuilderImpl();
    ProductBundleImpl indexable = new ProductBundleImpl();
    ArrayList<IndexField> fields = new ArrayList<>();

    // Act and Assert
    assertNull(catalogDocumentBuilderImpl.buildDocument(indexable, fields, new ArrayList<>()));
  }

  /**
   * Test
   * {@link CatalogDocumentBuilderImpl#attachIndexableDocumentFields(SolrInputDocument, Indexable, List, List)}.
   * <p>
   * Method under test:
   * {@link CatalogDocumentBuilderImpl#attachIndexableDocumentFields(SolrInputDocument, Indexable, List, List)}
   */
  @Test
  public void testAttachIndexableDocumentFields() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CatalogDocumentBuilderImpl catalogDocumentBuilderImpl = new CatalogDocumentBuilderImpl();
    ProductBundleImpl indexable = new ProductBundleImpl();
    IndexFieldImpl indexFieldImpl = mock(IndexFieldImpl.class);
    when(indexFieldImpl.getField()).thenThrow(new IllegalStateException("Could not get value for property["));
    when(indexFieldImpl.getFieldTypes()).thenThrow(new IllegalStateException("foo"));

    ArrayList<IndexField> fields = new ArrayList<>();
    fields.add(indexFieldImpl);

    // Act and Assert
    assertThrows(IllegalStateException.class,
        () -> catalogDocumentBuilderImpl.attachIndexableDocumentFields(null, indexable, fields, new ArrayList<>()));
    verify(indexFieldImpl).getField();
    verify(indexFieldImpl).getFieldTypes();
  }

  /**
   * Test
   * {@link CatalogDocumentBuilderImpl#attachIndexableDocumentFields(SolrInputDocument, Indexable, List, List)}.
   * <ul>
   *   <li>Then calls {@link FieldImpl#getQualifiedFieldName()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CatalogDocumentBuilderImpl#attachIndexableDocumentFields(SolrInputDocument, Indexable, List, List)}
   */
  @Test
  public void testAttachIndexableDocumentFields_thenCallsGetQualifiedFieldName() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CatalogDocumentBuilderImpl catalogDocumentBuilderImpl = new CatalogDocumentBuilderImpl();
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
        () -> catalogDocumentBuilderImpl.attachIndexableDocumentFields(null, indexable, fields, new ArrayList<>()));
    verify(fieldImpl).getQualifiedFieldName();
    verify(indexFieldImpl).getField();
    verify(indexFieldImpl).getFieldTypes();
  }

  /**
   * Test
   * {@link CatalogDocumentBuilderImpl#attachBasicDocumentFields(Indexable, SolrInputDocument)}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CatalogDocumentBuilderImpl#attachBasicDocumentFields(Indexable, SolrInputDocument)}
   */
  @Test
  public void testAttachBasicDocumentFields_thenThrowIllegalStateException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CatalogDocumentBuilderImpl catalogDocumentBuilderImpl = new CatalogDocumentBuilderImpl();

    // Act and Assert
    assertThrows(IllegalStateException.class,
        () -> catalogDocumentBuilderImpl.attachBasicDocumentFields(new ProductBundleImpl(), null));
  }

  /**
   * Test
   * {@link CatalogDocumentBuilderImpl#convertDisplayOrderToLong(CatalogStructure, String)}.
   * <p>
   * Method under test:
   * {@link CatalogDocumentBuilderImpl#convertDisplayOrderToLong(CatalogStructure, String)}
   */
  @Test
  public void testConvertDisplayOrderToLong() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CatalogDocumentBuilderImpl catalogDocumentBuilderImpl = new CatalogDocumentBuilderImpl();

    CatalogStructure cache = new CatalogStructure();
    cache.setDisplayOrdersByCategoryProduct(new HashMap<>());
    cache.setParentCategoriesByCategory(new HashMap<>());
    cache.setParentCategoriesByProduct(new HashMap<>());

    // Act and Assert
    assertNull(catalogDocumentBuilderImpl.convertDisplayOrderToLong(cache, "Display Order Key"));
  }

  /**
   * Test
   * {@link CatalogDocumentBuilderImpl#convertDisplayOrderToLong(CatalogStructure, String)}.
   * <ul>
   *   <li>Then calls
   * {@link CatalogStructure#getDisplayOrdersByCategoryProduct()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CatalogDocumentBuilderImpl#convertDisplayOrderToLong(CatalogStructure, String)}
   */
  @Test
  public void testConvertDisplayOrderToLong_thenCallsGetDisplayOrdersByCategoryProduct() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CatalogDocumentBuilderImpl catalogDocumentBuilderImpl = new CatalogDocumentBuilderImpl();
    CatalogStructure cache = mock(CatalogStructure.class);
    when(cache.getDisplayOrdersByCategoryProduct()).thenReturn(new HashMap<>());
    doNothing().when(cache).setDisplayOrdersByCategoryProduct(Mockito.<Map<String, BigDecimal>>any());
    doNothing().when(cache).setParentCategoriesByCategory(Mockito.<Map<Long, Set<Long>>>any());
    doNothing().when(cache).setParentCategoriesByProduct(Mockito.<Map<Long, Set<Long>>>any());
    cache.setDisplayOrdersByCategoryProduct(new HashMap<>());
    cache.setParentCategoriesByCategory(new HashMap<>());
    cache.setParentCategoriesByProduct(new HashMap<>());

    // Act
    Long actualConvertDisplayOrderToLongResult = catalogDocumentBuilderImpl.convertDisplayOrderToLong(cache,
        "Display Order Key");

    // Assert
    verify(cache).getDisplayOrdersByCategoryProduct();
    verify(cache).setDisplayOrdersByCategoryProduct(isA(Map.class));
    verify(cache).setParentCategoriesByCategory(isA(Map.class));
    verify(cache).setParentCategoriesByProduct(isA(Map.class));
    assertNull(actualConvertDisplayOrderToLongResult);
  }
}
