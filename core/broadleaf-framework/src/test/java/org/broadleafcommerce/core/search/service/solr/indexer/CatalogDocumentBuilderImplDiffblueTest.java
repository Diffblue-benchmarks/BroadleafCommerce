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
package org.broadleafcommerce.core.search.service.solr.indexer;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.solr.common.SolrInputDocument;
import org.broadleafcommerce.common.extension.ExtensionResultStatusType;
import org.broadleafcommerce.common.locale.domain.Locale;
import org.broadleafcommerce.common.locale.domain.LocaleImpl;
import org.broadleafcommerce.core.catalog.domain.Indexable;
import org.broadleafcommerce.core.catalog.domain.ProductBundleImpl;
import org.broadleafcommerce.core.search.dao.CatalogStructure;
import org.broadleafcommerce.core.search.domain.Field;
import org.broadleafcommerce.core.search.domain.FieldImpl;
import org.broadleafcommerce.core.search.domain.IndexField;
import org.broadleafcommerce.core.search.domain.IndexFieldImpl;
import org.broadleafcommerce.core.search.domain.solr.FieldType;
import org.broadleafcommerce.core.search.service.solr.SolrHelperService;
import org.broadleafcommerce.core.search.service.solr.index.I18nSolrIndexServiceExtensionHandler;
import org.broadleafcommerce.core.search.service.solr.index.SolrIndexServiceExtensionManager;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CatalogDocumentBuilderImplDiffblueTest {
  @InjectMocks
  private CatalogDocumentBuilderImpl catalogDocumentBuilderImpl;

  @Mock
  private SolrIndexServiceExtensionManager solrIndexServiceExtensionManager;

  @Mock
  private SolrHelperService solrHelperService;

  /**
   * Test {@link CatalogDocumentBuilderImpl#buildDocument(Indexable, List, List)}.
   * <ul>
   *   <li>Given {@link IndexFieldImpl} (default constructor).</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link IndexFieldImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link CatalogDocumentBuilderImpl#buildDocument(Indexable, List, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"SolrInputDocument CatalogDocumentBuilderImpl.buildDocument(Indexable, List, List)"})
  public void testBuildDocument_givenIndexFieldImpl_whenArrayListAddIndexFieldImpl() {
    // Arrange
    Indexable indexable = mock(Indexable.class);
    when(indexable.getId()).thenThrow(new IllegalStateException("foo"));

    ArrayList<IndexField> fields = new ArrayList<>();
    fields.add(new IndexFieldImpl());

    // Act and Assert
    assertThrows(IllegalStateException.class,
        () -> catalogDocumentBuilderImpl.buildDocument(indexable, fields, new ArrayList<>()));
    verify(indexable).getId();
  }

  /**
   * Test {@link CatalogDocumentBuilderImpl#buildDocument(Indexable, List, List)}.
   * <ul>
   *   <li>Given {@link IndexFieldImpl} (default constructor).</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link IndexFieldImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link CatalogDocumentBuilderImpl#buildDocument(Indexable, List, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"SolrInputDocument CatalogDocumentBuilderImpl.buildDocument(Indexable, List, List)"})
  public void testBuildDocument_givenIndexFieldImpl_whenArrayListAddIndexFieldImpl2() {
    // Arrange
    Indexable indexable = mock(Indexable.class);
    when(indexable.getId()).thenThrow(new IllegalStateException("foo"));

    ArrayList<IndexField> fields = new ArrayList<>();
    fields.add(new IndexFieldImpl());
    fields.add(new IndexFieldImpl());

    // Act and Assert
    assertThrows(IllegalStateException.class,
        () -> catalogDocumentBuilderImpl.buildDocument(indexable, fields, new ArrayList<>()));
    verify(indexable).getId();
  }

  /**
   * Test {@link CatalogDocumentBuilderImpl#buildDocument(Indexable, List, List)}.
   * <ul>
   *   <li>Given {@link LocaleImpl} (default constructor).</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link LocaleImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link CatalogDocumentBuilderImpl#buildDocument(Indexable, List, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"SolrInputDocument CatalogDocumentBuilderImpl.buildDocument(Indexable, List, List)"})
  public void testBuildDocument_givenLocaleImpl_whenArrayListAddLocaleImpl() {
    // Arrange
    Indexable indexable = mock(Indexable.class);
    when(indexable.getId()).thenThrow(new IllegalStateException("foo"));
    ArrayList<IndexField> fields = new ArrayList<>();

    ArrayList<Locale> locales = new ArrayList<>();
    locales.add(new LocaleImpl());

    // Act and Assert
    assertThrows(IllegalStateException.class,
        () -> catalogDocumentBuilderImpl.buildDocument(indexable, fields, locales));
    verify(indexable).getId();
  }

  /**
   * Test {@link CatalogDocumentBuilderImpl#buildDocument(Indexable, List, List)}.
   * <ul>
   *   <li>Given {@link LocaleImpl} (default constructor).</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link LocaleImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link CatalogDocumentBuilderImpl#buildDocument(Indexable, List, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"SolrInputDocument CatalogDocumentBuilderImpl.buildDocument(Indexable, List, List)"})
  public void testBuildDocument_givenLocaleImpl_whenArrayListAddLocaleImpl2() {
    // Arrange
    Indexable indexable = mock(Indexable.class);
    when(indexable.getId()).thenThrow(new IllegalStateException("foo"));
    ArrayList<IndexField> fields = new ArrayList<>();

    ArrayList<Locale> locales = new ArrayList<>();
    locales.add(new LocaleImpl());
    locales.add(new LocaleImpl());

    // Act and Assert
    assertThrows(IllegalStateException.class,
        () -> catalogDocumentBuilderImpl.buildDocument(indexable, fields, locales));
    verify(indexable).getId();
  }

  /**
   * Test {@link CatalogDocumentBuilderImpl#buildDocument(Indexable, List, List)}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CatalogDocumentBuilderImpl#buildDocument(Indexable, List, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"SolrInputDocument CatalogDocumentBuilderImpl.buildDocument(Indexable, List, List)"})
  public void testBuildDocument_thenThrowIllegalStateException() {
    // Arrange
    Indexable indexable = mock(Indexable.class);
    when(indexable.getId()).thenThrow(new IllegalStateException("foo"));
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
   * Method under test: {@link CatalogDocumentBuilderImpl#buildDocument(Indexable, List, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"SolrInputDocument CatalogDocumentBuilderImpl.buildDocument(Indexable, List, List)"})
  public void testBuildDocument_whenProductBundleImpl_thenReturnNull() {
    // Arrange
    ProductBundleImpl indexable = new ProductBundleImpl();
    ArrayList<IndexField> fields = new ArrayList<>();

    // Act and Assert
    assertNull(catalogDocumentBuilderImpl.buildDocument(indexable, fields, new ArrayList<>()));
  }

  /**
   * Test {@link CatalogDocumentBuilderImpl#attachIndexableDocumentFields(SolrInputDocument, Indexable, List, List)}.
   * <p>
   * Method under test: {@link CatalogDocumentBuilderImpl#attachIndexableDocumentFields(SolrInputDocument, Indexable, List, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void CatalogDocumentBuilderImpl.attachIndexableDocumentFields(SolrInputDocument, Indexable, List, List)"})
  public void testAttachIndexableDocumentFields() {
    // Arrange
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
   * Test {@link CatalogDocumentBuilderImpl#attachIndexableDocumentFields(SolrInputDocument, Indexable, List, List)}.
   * <ul>
   *   <li>Then calls {@link FieldImpl#getQualifiedFieldName()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CatalogDocumentBuilderImpl#attachIndexableDocumentFields(SolrInputDocument, Indexable, List, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void CatalogDocumentBuilderImpl.attachIndexableDocumentFields(SolrInputDocument, Indexable, List, List)"})
  public void testAttachIndexableDocumentFields_thenCallsGetQualifiedFieldName() {
    // Arrange
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
   * Test {@link CatalogDocumentBuilderImpl#attachAdditionalDocumentFields(Indexable, SolrInputDocument)}.
   * <p>
   * Method under test: {@link CatalogDocumentBuilderImpl#attachAdditionalDocumentFields(Indexable, SolrInputDocument)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CatalogDocumentBuilderImpl.attachAdditionalDocumentFields(Indexable, SolrInputDocument)"})
  public void testAttachAdditionalDocumentFields() {
    // Arrange
    when(solrIndexServiceExtensionManager.getProxy()).thenReturn(new I18nSolrIndexServiceExtensionHandler());

    // Act
    catalogDocumentBuilderImpl.attachAdditionalDocumentFields(new ProductBundleImpl(), null);

    // Assert
    verify(solrIndexServiceExtensionManager).getProxy();
  }

  /**
   * Test {@link CatalogDocumentBuilderImpl#attachAdditionalDocumentFields(Indexable, SolrInputDocument)}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CatalogDocumentBuilderImpl#attachAdditionalDocumentFields(Indexable, SolrInputDocument)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CatalogDocumentBuilderImpl.attachAdditionalDocumentFields(Indexable, SolrInputDocument)"})
  public void testAttachAdditionalDocumentFields_thenThrowIllegalStateException() {
    // Arrange
    when(solrIndexServiceExtensionManager.getProxy()).thenThrow(new IllegalStateException("foo"));

    // Act and Assert
    assertThrows(IllegalStateException.class,
        () -> catalogDocumentBuilderImpl.attachAdditionalDocumentFields(new ProductBundleImpl(), null));
    verify(solrIndexServiceExtensionManager).getProxy();
  }

  /**
   * Test {@link CatalogDocumentBuilderImpl#attachBasicDocumentFields(Indexable, SolrInputDocument)}.
   * <p>
   * Method under test: {@link CatalogDocumentBuilderImpl#attachBasicDocumentFields(Indexable, SolrInputDocument)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CatalogDocumentBuilderImpl.attachBasicDocumentFields(Indexable, SolrInputDocument)"})
  public void testAttachBasicDocumentFields() {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class,
        () -> catalogDocumentBuilderImpl.attachBasicDocumentFields(new ProductBundleImpl(), null));
  }

  /**
   * Test {@link CatalogDocumentBuilderImpl#buildFullCategoryHierarchy(SolrInputDocument, CatalogStructure, Long, Set)}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CatalogDocumentBuilderImpl#buildFullCategoryHierarchy(SolrInputDocument, CatalogStructure, Long, Set)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void CatalogDocumentBuilderImpl.buildFullCategoryHierarchy(SolrInputDocument, CatalogStructure, Long, Set)"})
  public void testBuildFullCategoryHierarchy_thenThrowIllegalStateException() {
    // Arrange
    when(solrHelperService.getCategoryId(Mockito.<Long>any())).thenThrow(new IllegalStateException("foo"));

    CatalogStructure cache = new CatalogStructure();
    cache.setDisplayOrdersByCategoryProduct(new HashMap<>());
    cache.setParentCategoriesByCategory(new HashMap<>());
    cache.setParentCategoriesByProduct(new HashMap<>());

    // Act and Assert
    assertThrows(IllegalStateException.class,
        () -> catalogDocumentBuilderImpl.buildFullCategoryHierarchy(null, cache, 1L, new HashSet<>()));
    verify(solrHelperService).getCategoryId(eq(1L));
  }

  /**
   * Test {@link CatalogDocumentBuilderImpl#getPropertyValues(Indexable, Field, FieldType, List)}.
   * <ul>
   *   <li>Given {@link LocaleImpl} (default constructor).</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link LocaleImpl} (default constructor).</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link CatalogDocumentBuilderImpl#getPropertyValues(Indexable, Field, FieldType, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map CatalogDocumentBuilderImpl.getPropertyValues(Indexable, Field, FieldType, List)"})
  public void testGetPropertyValues_givenLocaleImpl_whenArrayListAddLocaleImpl_thenReturnEmpty()
      throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
    // Arrange
    I18nSolrIndexServiceExtensionHandler i18nSolrIndexServiceExtensionHandler = mock(
        I18nSolrIndexServiceExtensionHandler.class);
    when(i18nSolrIndexServiceExtensionHandler.addPropertyValues(Mockito.<Indexable>any(), Mockito.<Field>any(),
        Mockito.<FieldType>any(), Mockito.<Map<String, Object>>any(), Mockito.<String>any(),
        Mockito.<List<Locale>>any())).thenReturn(ExtensionResultStatusType.HANDLED);
    when(solrIndexServiceExtensionManager.getProxy()).thenReturn(i18nSolrIndexServiceExtensionHandler);
    ProductBundleImpl indexedItem = new ProductBundleImpl();
    FieldImpl field = new FieldImpl();

    ArrayList<Locale> locales = new ArrayList<>();
    locales.add(new LocaleImpl());

    // Act
    Map<String, Object> actualPropertyValues = catalogDocumentBuilderImpl.getPropertyValues(indexedItem, field,
        FieldType.BOOLEAN, locales);

    // Assert
    verify(solrIndexServiceExtensionManager).getProxy();
    verify(i18nSolrIndexServiceExtensionHandler).addPropertyValues(isA(Indexable.class), isA(Field.class),
        isA(FieldType.class), isA(Map.class), (String) isNull(), isA(List.class));
    assertTrue(actualPropertyValues.isEmpty());
  }

  /**
   * Test {@link CatalogDocumentBuilderImpl#getPropertyValues(Indexable, Field, FieldType, List)}.
   * <ul>
   *   <li>Given {@link LocaleImpl} (default constructor).</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link LocaleImpl} (default constructor).</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link CatalogDocumentBuilderImpl#getPropertyValues(Indexable, Field, FieldType, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map CatalogDocumentBuilderImpl.getPropertyValues(Indexable, Field, FieldType, List)"})
  public void testGetPropertyValues_givenLocaleImpl_whenArrayListAddLocaleImpl_thenReturnEmpty2()
      throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
    // Arrange
    I18nSolrIndexServiceExtensionHandler i18nSolrIndexServiceExtensionHandler = mock(
        I18nSolrIndexServiceExtensionHandler.class);
    when(i18nSolrIndexServiceExtensionHandler.addPropertyValues(Mockito.<Indexable>any(), Mockito.<Field>any(),
        Mockito.<FieldType>any(), Mockito.<Map<String, Object>>any(), Mockito.<String>any(),
        Mockito.<List<Locale>>any())).thenReturn(ExtensionResultStatusType.HANDLED);
    when(solrIndexServiceExtensionManager.getProxy()).thenReturn(i18nSolrIndexServiceExtensionHandler);
    ProductBundleImpl indexedItem = new ProductBundleImpl();
    FieldImpl field = new FieldImpl();

    ArrayList<Locale> locales = new ArrayList<>();
    locales.add(new LocaleImpl());
    locales.add(new LocaleImpl());

    // Act
    Map<String, Object> actualPropertyValues = catalogDocumentBuilderImpl.getPropertyValues(indexedItem, field,
        FieldType.BOOLEAN, locales);

    // Assert
    verify(solrIndexServiceExtensionManager).getProxy();
    verify(i18nSolrIndexServiceExtensionHandler).addPropertyValues(isA(Indexable.class), isA(Field.class),
        isA(FieldType.class), isA(Map.class), (String) isNull(), isA(List.class));
    assertTrue(actualPropertyValues.isEmpty());
  }

  /**
   * Test {@link CatalogDocumentBuilderImpl#getPropertyValues(Indexable, Field, FieldType, List)}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link CatalogDocumentBuilderImpl#getPropertyValues(Indexable, Field, FieldType, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map CatalogDocumentBuilderImpl.getPropertyValues(Indexable, Field, FieldType, List)"})
  public void testGetPropertyValues_thenReturnEmpty()
      throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
    // Arrange
    I18nSolrIndexServiceExtensionHandler i18nSolrIndexServiceExtensionHandler = mock(
        I18nSolrIndexServiceExtensionHandler.class);
    when(i18nSolrIndexServiceExtensionHandler.addPropertyValues(Mockito.<Indexable>any(), Mockito.<Field>any(),
        Mockito.<FieldType>any(), Mockito.<Map<String, Object>>any(), Mockito.<String>any(),
        Mockito.<List<Locale>>any())).thenReturn(ExtensionResultStatusType.HANDLED);
    when(solrIndexServiceExtensionManager.getProxy()).thenReturn(i18nSolrIndexServiceExtensionHandler);
    ProductBundleImpl indexedItem = new ProductBundleImpl();
    FieldImpl field = new FieldImpl();

    // Act
    Map<String, Object> actualPropertyValues = catalogDocumentBuilderImpl.getPropertyValues(indexedItem, field,
        FieldType.BOOLEAN, new ArrayList<>());

    // Assert
    verify(solrIndexServiceExtensionManager).getProxy();
    verify(i18nSolrIndexServiceExtensionHandler).addPropertyValues(isA(Indexable.class), isA(Field.class),
        isA(FieldType.class), isA(Map.class), (String) isNull(), isA(List.class));
    assertTrue(actualPropertyValues.isEmpty());
  }

  /**
   * Test {@link CatalogDocumentBuilderImpl#getPropertyValues(Indexable, Field, FieldType, List)}.
   * <ul>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link CatalogDocumentBuilderImpl#getPropertyValues(Indexable, Field, FieldType, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map CatalogDocumentBuilderImpl.getPropertyValues(Indexable, Field, FieldType, List)"})
  public void testGetPropertyValues_thenReturnSizeIsOne()
      throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
    // Arrange
    when(solrIndexServiceExtensionManager.getProxy()).thenReturn(new I18nSolrIndexServiceExtensionHandler());
    when(solrHelperService.getPropertyValue(Mockito.<Object>any(), Mockito.<Field>any())).thenReturn("Property Value");
    ProductBundleImpl indexedItem = new ProductBundleImpl();
    FieldImpl field = new FieldImpl();

    // Act
    Map<String, Object> actualPropertyValues = catalogDocumentBuilderImpl.getPropertyValues(indexedItem, field,
        FieldType.BOOLEAN, new ArrayList<>());

    // Assert
    verify(solrIndexServiceExtensionManager).getProxy();
    verify(solrHelperService).getPropertyValue(isA(Object.class), isA(Field.class));
    assertEquals(1, actualPropertyValues.size());
    assertEquals("Property Value", actualPropertyValues.get(""));
  }

  /**
   * Test {@link CatalogDocumentBuilderImpl#getPropertyValues(Indexable, Field, FieldType, List)}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CatalogDocumentBuilderImpl#getPropertyValues(Indexable, Field, FieldType, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map CatalogDocumentBuilderImpl.getPropertyValues(Indexable, Field, FieldType, List)"})
  public void testGetPropertyValues_thenThrowIllegalStateException()
      throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
    // Arrange
    when(solrIndexServiceExtensionManager.getProxy()).thenReturn(new I18nSolrIndexServiceExtensionHandler());
    when(solrHelperService.getPropertyValue(Mockito.<Object>any(), Mockito.<Field>any()))
        .thenThrow(new IllegalStateException("foo"));
    ProductBundleImpl indexedItem = new ProductBundleImpl();
    FieldImpl field = new FieldImpl();

    // Act and Assert
    assertThrows(IllegalStateException.class,
        () -> catalogDocumentBuilderImpl.getPropertyValues(indexedItem, field, FieldType.BOOLEAN, new ArrayList<>()));
    verify(solrIndexServiceExtensionManager).getProxy();
    verify(solrHelperService).getPropertyValue(isA(Object.class), isA(Field.class));
  }

  /**
   * Test {@link CatalogDocumentBuilderImpl#convertDisplayOrderToLong(CatalogStructure, String)}.
   * <p>
   * Method under test: {@link CatalogDocumentBuilderImpl#convertDisplayOrderToLong(CatalogStructure, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Long CatalogDocumentBuilderImpl.convertDisplayOrderToLong(CatalogStructure, String)"})
  public void testConvertDisplayOrderToLong() {
    // Arrange
    CatalogStructure cache = new CatalogStructure();
    cache.setDisplayOrdersByCategoryProduct(new HashMap<>());
    cache.setParentCategoriesByCategory(new HashMap<>());
    cache.setParentCategoriesByProduct(new HashMap<>());

    // Act and Assert
    assertNull(catalogDocumentBuilderImpl.convertDisplayOrderToLong(cache, "Display Order Key"));
  }
}
