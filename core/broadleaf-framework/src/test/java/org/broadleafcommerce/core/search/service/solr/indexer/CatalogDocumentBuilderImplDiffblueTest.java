package org.broadleafcommerce.core.search.service.solr.indexer;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.solr.common.SolrInputDocument;
import org.apache.solr.common.SolrInputField;
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
import org.broadleafcommerce.core.search.domain.IndexFieldType;
import org.broadleafcommerce.core.search.domain.IndexFieldTypeImpl;
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
import org.mvel2.util.InternalNumber;

@RunWith(MockitoJUnitRunner.class)
public class CatalogDocumentBuilderImplDiffblueTest {
  @InjectMocks private CatalogDocumentBuilderImpl catalogDocumentBuilderImpl;

  @Mock private SolrHelperService solrHelperService;

  @Mock private SolrIndexServiceExtensionManager solrIndexServiceExtensionManager;

  /**
   * Test {@link CatalogDocumentBuilderImpl#buildDocument(Indexable, List, List)}.
   *
   * <ul>
   *   <li>Given {@link IllegalStateException#IllegalStateException()}.
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link CatalogDocumentBuilderImpl#buildDocument(Indexable, List, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "SolrInputDocument CatalogDocumentBuilderImpl.buildDocument(Indexable, List, List)"
  })
  public void testBuildDocument_givenIllegalStateException_thenThrowIllegalStateException() {
    // Arrange
    CatalogDocumentBuilderImpl catalogDocumentBuilderImpl = new CatalogDocumentBuilderImpl();

    Indexable indexable = mock(Indexable.class);
    when(indexable.getId()).thenThrow(new IllegalStateException());
    ArrayList<IndexField> fields = new ArrayList<>();

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () -> catalogDocumentBuilderImpl.buildDocument(indexable, fields, new ArrayList<>()));
    verify(indexable).getId();
  }

  /**
   * Test {@link CatalogDocumentBuilderImpl#buildDocument(Indexable, List, List)}.
   *
   * <ul>
   *   <li>Given {@link IndexFieldImpl} (default constructor).
   *   <li>When {@link ArrayList#ArrayList()} add {@link IndexFieldImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link CatalogDocumentBuilderImpl#buildDocument(Indexable, List, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "SolrInputDocument CatalogDocumentBuilderImpl.buildDocument(Indexable, List, List)"
  })
  public void testBuildDocument_givenIndexFieldImpl_whenArrayListAddIndexFieldImpl() {
    // Arrange
    CatalogDocumentBuilderImpl catalogDocumentBuilderImpl = new CatalogDocumentBuilderImpl();

    Indexable indexable = mock(Indexable.class);
    when(indexable.getId()).thenThrow(new IllegalStateException());

    ArrayList<IndexField> fields = new ArrayList<>();
    fields.add(new IndexFieldImpl());

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () -> catalogDocumentBuilderImpl.buildDocument(indexable, fields, new ArrayList<>()));
    verify(indexable).getId();
  }

  /**
   * Test {@link CatalogDocumentBuilderImpl#buildDocument(Indexable, List, List)}.
   *
   * <ul>
   *   <li>Given {@link IndexFieldImpl} (default constructor).
   *   <li>When {@link ArrayList#ArrayList()} add {@link IndexFieldImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link CatalogDocumentBuilderImpl#buildDocument(Indexable, List, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "SolrInputDocument CatalogDocumentBuilderImpl.buildDocument(Indexable, List, List)"
  })
  public void testBuildDocument_givenIndexFieldImpl_whenArrayListAddIndexFieldImpl2() {
    // Arrange
    CatalogDocumentBuilderImpl catalogDocumentBuilderImpl = new CatalogDocumentBuilderImpl();

    Indexable indexable = mock(Indexable.class);
    when(indexable.getId()).thenThrow(new IllegalStateException());

    ArrayList<IndexField> fields = new ArrayList<>();
    fields.add(new IndexFieldImpl());
    fields.add(new IndexFieldImpl());

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () -> catalogDocumentBuilderImpl.buildDocument(indexable, fields, new ArrayList<>()));
    verify(indexable).getId();
  }

  /**
   * Test {@link CatalogDocumentBuilderImpl#buildDocument(Indexable, List, List)}.
   *
   * <ul>
   *   <li>Given {@link LocaleImpl} (default constructor).
   *   <li>When {@link ArrayList#ArrayList()} add {@link LocaleImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link CatalogDocumentBuilderImpl#buildDocument(Indexable, List, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "SolrInputDocument CatalogDocumentBuilderImpl.buildDocument(Indexable, List, List)"
  })
  public void testBuildDocument_givenLocaleImpl_whenArrayListAddLocaleImpl() {
    // Arrange
    CatalogDocumentBuilderImpl catalogDocumentBuilderImpl = new CatalogDocumentBuilderImpl();

    Indexable indexable = mock(Indexable.class);
    when(indexable.getId()).thenThrow(new IllegalStateException());
    ArrayList<IndexField> fields = new ArrayList<>();

    ArrayList<Locale> locales = new ArrayList<>();
    locales.add(new LocaleImpl());

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () -> catalogDocumentBuilderImpl.buildDocument(indexable, fields, locales));
    verify(indexable).getId();
  }

  /**
   * Test {@link CatalogDocumentBuilderImpl#buildDocument(Indexable, List, List)}.
   *
   * <ul>
   *   <li>Given {@link LocaleImpl} (default constructor).
   *   <li>When {@link ArrayList#ArrayList()} add {@link LocaleImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link CatalogDocumentBuilderImpl#buildDocument(Indexable, List, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "SolrInputDocument CatalogDocumentBuilderImpl.buildDocument(Indexable, List, List)"
  })
  public void testBuildDocument_givenLocaleImpl_whenArrayListAddLocaleImpl2() {
    // Arrange
    CatalogDocumentBuilderImpl catalogDocumentBuilderImpl = new CatalogDocumentBuilderImpl();

    Indexable indexable = mock(Indexable.class);
    when(indexable.getId()).thenThrow(new IllegalStateException());
    ArrayList<IndexField> fields = new ArrayList<>();

    ArrayList<Locale> locales = new ArrayList<>();
    locales.add(new LocaleImpl());
    locales.add(new LocaleImpl());

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () -> catalogDocumentBuilderImpl.buildDocument(indexable, fields, locales));
    verify(indexable).getId();
  }

  /**
   * Test {@link CatalogDocumentBuilderImpl#buildDocument(Indexable, List, List)}.
   *
   * <ul>
   *   <li>When {@link ProductBundleImpl} (default constructor).
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link CatalogDocumentBuilderImpl#buildDocument(Indexable, List, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "SolrInputDocument CatalogDocumentBuilderImpl.buildDocument(Indexable, List, List)"
  })
  public void testBuildDocument_whenProductBundleImpl_thenReturnNull() {
    // Arrange
    CatalogDocumentBuilderImpl catalogDocumentBuilderImpl = new CatalogDocumentBuilderImpl();
    ProductBundleImpl indexable = new ProductBundleImpl();
    ArrayList<IndexField> fields = new ArrayList<>();

    // Act and Assert
    assertNull(catalogDocumentBuilderImpl.buildDocument(indexable, fields, new ArrayList<>()));
  }

  /**
   * Test {@link CatalogDocumentBuilderImpl#attachIndexableDocumentFields(SolrInputDocument,
   * Indexable, List, List)}.
   *
   * <p>Method under test: {@link
   * CatalogDocumentBuilderImpl#attachIndexableDocumentFields(SolrInputDocument, Indexable, List,
   * List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CatalogDocumentBuilderImpl.attachIndexableDocumentFields(SolrInputDocument, Indexable, List, List)"
  })
  public void testAttachIndexableDocumentFields() {
    // Arrange
    CatalogDocumentBuilderImpl catalogDocumentBuilderImpl = new CatalogDocumentBuilderImpl();
    ProductBundleImpl indexable = new ProductBundleImpl();

    IndexFieldImpl indexFieldImpl = mock(IndexFieldImpl.class);
    when(indexFieldImpl.getField()).thenThrow(new IllegalStateException());
    when(indexFieldImpl.getFieldTypes()).thenThrow(new IllegalStateException());

    ArrayList<IndexField> fields = new ArrayList<>();
    fields.add(indexFieldImpl);

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () ->
            catalogDocumentBuilderImpl.attachIndexableDocumentFields(
                null, indexable, fields, new ArrayList<>()));
    verify(indexFieldImpl).getField();
    verify(indexFieldImpl).getFieldTypes();
  }

  /**
   * Test {@link CatalogDocumentBuilderImpl#attachIndexableDocumentFields(SolrInputDocument,
   * Indexable, List, List)}.
   *
   * <p>Method under test: {@link
   * CatalogDocumentBuilderImpl#attachIndexableDocumentFields(SolrInputDocument, Indexable, List,
   * List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CatalogDocumentBuilderImpl.attachIndexableDocumentFields(SolrInputDocument, Indexable, List, List)"
  })
  public void testAttachIndexableDocumentFields2()
      throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
    // Arrange
    when(solrIndexServiceExtensionManager.getProxy())
        .thenReturn(new I18nSolrIndexServiceExtensionHandler());
    when(solrHelperService.getPropertyNameForIndexField(
            Mockito.<IndexField>any(), Mockito.<FieldType>any(), Mockito.<String>any()))
        .thenReturn("Property Name For Index Field");
    when(solrHelperService.getPropertyValue(Mockito.<Object>any(), Mockito.<Field>any()))
        .thenReturn("Property Value");
    SolrInputDocument document = new SolrInputDocument();
    ProductBundleImpl indexable = new ProductBundleImpl();

    IndexFieldTypeImpl indexFieldTypeImpl = mock(IndexFieldTypeImpl.class);
    when(indexFieldTypeImpl.getFieldType()).thenReturn(FieldType.BOOLEAN);

    ArrayList<IndexFieldType> fieldTypes = new ArrayList<>();
    fieldTypes.add(indexFieldTypeImpl);

    IndexFieldImpl indexFieldImpl = new IndexFieldImpl();
    indexFieldImpl.setField(new FieldImpl());
    indexFieldImpl.setId(1L);
    indexFieldImpl.setSearchable(true);
    indexFieldImpl.setFieldTypes(fieldTypes);

    ArrayList<IndexField> fields = new ArrayList<>();
    fields.add(indexFieldImpl);

    // Act
    catalogDocumentBuilderImpl.attachIndexableDocumentFields(
        document, indexable, fields, new ArrayList<>());

    // Assert
    verify(solrIndexServiceExtensionManager, atLeast(1)).getProxy();
    verify(indexFieldTypeImpl).getFieldType();
    verify(solrHelperService)
        .getPropertyNameForIndexField(isA(IndexField.class), isA(FieldType.class), eq(""));
    verify(solrHelperService).getPropertyValue(isA(Object.class), isA(Field.class));
    assertEquals(1, document.size());
    SolrInputField getResult = document.get("Property Name For Index Field");
    Collection<Object> values = getResult.getValues();
    assertEquals(1, values.size());
    assertTrue(values instanceof List);
    assertEquals("Property Name For Index Field", getResult.getName());
    Iterator<Object> iteratorResult = getResult.iterator();
    assertEquals("Property Value", iteratorResult.next());
    assertEquals("Property Value", ((List<Object>) values).get(0));
    assertEquals("Property Value", getResult.getFirstValue());
    assertEquals("Property Value", getResult.getValue());
    assertEquals(1, getResult.getValueCount());
    assertFalse(iteratorResult.hasNext());
  }

  /**
   * Test {@link CatalogDocumentBuilderImpl#attachIndexableDocumentFields(SolrInputDocument,
   * Indexable, List, List)}.
   *
   * <p>Method under test: {@link
   * CatalogDocumentBuilderImpl#attachIndexableDocumentFields(SolrInputDocument, Indexable, List,
   * List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CatalogDocumentBuilderImpl.attachIndexableDocumentFields(SolrInputDocument, Indexable, List, List)"
  })
  public void testAttachIndexableDocumentFields3()
      throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
    // Arrange
    when(solrIndexServiceExtensionManager.getProxy())
        .thenReturn(new I18nSolrIndexServiceExtensionHandler());
    when(solrHelperService.getPropertyNameForIndexField(
            Mockito.<IndexField>any(), Mockito.<FieldType>any(), Mockito.<String>any()))
        .thenReturn("Property Name For Index Field");
    when(solrHelperService.getPropertyValue(Mockito.<Object>any(), Mockito.<Field>any()))
        .thenReturn("Property Value");
    SolrInputDocument document = new SolrInputDocument();
    ProductBundleImpl indexable = new ProductBundleImpl();

    IndexFieldTypeImpl indexFieldTypeImpl = mock(IndexFieldTypeImpl.class);
    when(indexFieldTypeImpl.getFieldType()).thenReturn(FieldType.BOOLEANS);

    ArrayList<IndexFieldType> fieldTypes = new ArrayList<>();
    fieldTypes.add(indexFieldTypeImpl);

    IndexFieldImpl indexFieldImpl = new IndexFieldImpl();
    indexFieldImpl.setField(new FieldImpl());
    indexFieldImpl.setId(1L);
    indexFieldImpl.setSearchable(true);
    indexFieldImpl.setFieldTypes(fieldTypes);

    ArrayList<IndexField> fields = new ArrayList<>();
    fields.add(indexFieldImpl);

    // Act
    catalogDocumentBuilderImpl.attachIndexableDocumentFields(
        document, indexable, fields, new ArrayList<>());

    // Assert
    verify(solrIndexServiceExtensionManager, atLeast(1)).getProxy();
    verify(indexFieldTypeImpl).getFieldType();
    verify(solrHelperService)
        .getPropertyNameForIndexField(isA(IndexField.class), isA(FieldType.class), eq(""));
    verify(solrHelperService).getPropertyValue(isA(Object.class), isA(Field.class));
    assertEquals(1, document.size());
    SolrInputField getResult = document.get("Property Name For Index Field");
    Collection<Object> values = getResult.getValues();
    assertEquals(1, values.size());
    assertTrue(values instanceof List);
    assertEquals("Property Name For Index Field", getResult.getName());
    Iterator<Object> iteratorResult = getResult.iterator();
    assertEquals("Property Value", iteratorResult.next());
    assertEquals("Property Value", ((List<Object>) values).get(0));
    assertEquals("Property Value", getResult.getFirstValue());
    assertEquals("Property Value", getResult.getValue());
    assertEquals(1, getResult.getValueCount());
    assertFalse(iteratorResult.hasNext());
  }

  /**
   * Test {@link CatalogDocumentBuilderImpl#attachIndexableDocumentFields(SolrInputDocument,
   * Indexable, List, List)}.
   *
   * <p>Method under test: {@link
   * CatalogDocumentBuilderImpl#attachIndexableDocumentFields(SolrInputDocument, Indexable, List,
   * List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CatalogDocumentBuilderImpl.attachIndexableDocumentFields(SolrInputDocument, Indexable, List, List)"
  })
  public void testAttachIndexableDocumentFields4()
      throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
    // Arrange
    when(solrIndexServiceExtensionManager.getProxy())
        .thenReturn(new I18nSolrIndexServiceExtensionHandler());
    when(solrHelperService.getPropertyNameForIndexField(
            Mockito.<IndexField>any(), Mockito.<FieldType>any(), Mockito.<String>any()))
        .thenReturn("Property Name For Index Field");
    when(solrHelperService.getPropertyValue(Mockito.<Object>any(), Mockito.<Field>any()))
        .thenReturn("Property Value");
    SolrInputDocument document = new SolrInputDocument();
    ProductBundleImpl indexable = new ProductBundleImpl();

    IndexFieldTypeImpl indexFieldTypeImpl = mock(IndexFieldTypeImpl.class);
    when(indexFieldTypeImpl.getFieldType()).thenReturn(new FieldType());

    ArrayList<IndexFieldType> fieldTypes = new ArrayList<>();
    fieldTypes.add(indexFieldTypeImpl);

    IndexFieldImpl indexFieldImpl = new IndexFieldImpl();
    indexFieldImpl.setField(new FieldImpl());
    indexFieldImpl.setId(1L);
    indexFieldImpl.setSearchable(true);
    indexFieldImpl.setFieldTypes(fieldTypes);

    ArrayList<IndexField> fields = new ArrayList<>();
    fields.add(indexFieldImpl);

    // Act
    catalogDocumentBuilderImpl.attachIndexableDocumentFields(
        document, indexable, fields, new ArrayList<>());

    // Assert
    verify(solrIndexServiceExtensionManager, atLeast(1)).getProxy();
    verify(indexFieldTypeImpl).getFieldType();
    verify(solrHelperService)
        .getPropertyNameForIndexField(isA(IndexField.class), isA(FieldType.class), eq(""));
    verify(solrHelperService).getPropertyValue(isA(Object.class), isA(Field.class));
    assertEquals(1, document.size());
    SolrInputField getResult = document.get("Property Name For Index Field");
    Collection<Object> values = getResult.getValues();
    assertEquals(1, values.size());
    assertTrue(values instanceof List);
    assertEquals("Property Name For Index Field", getResult.getName());
    Iterator<Object> iteratorResult = getResult.iterator();
    assertEquals("Property Value", iteratorResult.next());
    assertEquals("Property Value", ((List<Object>) values).get(0));
    assertEquals("Property Value", getResult.getFirstValue());
    assertEquals("Property Value", getResult.getValue());
    assertEquals(1, getResult.getValueCount());
    assertFalse(iteratorResult.hasNext());
  }

  /**
   * Test {@link CatalogDocumentBuilderImpl#attachIndexableDocumentFields(SolrInputDocument,
   * Indexable, List, List)}.
   *
   * <ul>
   *   <li>Given {@link IndexFieldImpl} (default constructor).
   *   <li>When {@code null}.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link
   * CatalogDocumentBuilderImpl#attachIndexableDocumentFields(SolrInputDocument, Indexable, List,
   * List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CatalogDocumentBuilderImpl.attachIndexableDocumentFields(SolrInputDocument, Indexable, List, List)"
  })
  public void testAttachIndexableDocumentFields_givenIndexFieldImpl_whenNull_thenDoesNotThrow() {
    // Arrange
    CatalogDocumentBuilderImpl catalogDocumentBuilderImpl = new CatalogDocumentBuilderImpl();
    ProductBundleImpl indexable = new ProductBundleImpl();

    ArrayList<IndexField> fields = new ArrayList<>();
    fields.add(new IndexFieldImpl());

    // Act and Assert
    catalogDocumentBuilderImpl.attachIndexableDocumentFields(
        null, indexable, fields, new ArrayList<>());
  }

  /**
   * Test {@link CatalogDocumentBuilderImpl#attachIndexableDocumentFields(SolrInputDocument,
   * Indexable, List, List)}.
   *
   * <ul>
   *   <li>Given {@link IndexFieldImpl} (default constructor).
   *   <li>When {@code null}.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link
   * CatalogDocumentBuilderImpl#attachIndexableDocumentFields(SolrInputDocument, Indexable, List,
   * List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CatalogDocumentBuilderImpl.attachIndexableDocumentFields(SolrInputDocument, Indexable, List, List)"
  })
  public void testAttachIndexableDocumentFields_givenIndexFieldImpl_whenNull_thenDoesNotThrow2() {
    // Arrange
    CatalogDocumentBuilderImpl catalogDocumentBuilderImpl = new CatalogDocumentBuilderImpl();
    ProductBundleImpl indexable = new ProductBundleImpl();

    ArrayList<IndexField> fields = new ArrayList<>();
    fields.add(new IndexFieldImpl());
    fields.add(new IndexFieldImpl());

    // Act and Assert
    catalogDocumentBuilderImpl.attachIndexableDocumentFields(
        null, indexable, fields, new ArrayList<>());
  }

  /**
   * Test {@link CatalogDocumentBuilderImpl#attachIndexableDocumentFields(SolrInputDocument,
   * Indexable, List, List)}.
   *
   * <ul>
   *   <li>Given {@link LocaleImpl} (default constructor).
   *   <li>When {@link ArrayList#ArrayList()} add {@link LocaleImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link
   * CatalogDocumentBuilderImpl#attachIndexableDocumentFields(SolrInputDocument, Indexable, List,
   * List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CatalogDocumentBuilderImpl.attachIndexableDocumentFields(SolrInputDocument, Indexable, List, List)"
  })
  public void testAttachIndexableDocumentFields_givenLocaleImpl_whenArrayListAddLocaleImpl() {
    // Arrange
    CatalogDocumentBuilderImpl catalogDocumentBuilderImpl = new CatalogDocumentBuilderImpl();
    ProductBundleImpl indexable = new ProductBundleImpl();

    FieldImpl fieldImpl = mock(FieldImpl.class);
    when(fieldImpl.getQualifiedFieldName()).thenReturn("Qualified Field Name");

    IndexFieldImpl indexFieldImpl = mock(IndexFieldImpl.class);
    when(indexFieldImpl.getField()).thenReturn(fieldImpl);
    when(indexFieldImpl.getFieldTypes()).thenThrow(new IllegalStateException());

    ArrayList<IndexField> fields = new ArrayList<>();
    fields.add(indexFieldImpl);

    ArrayList<Locale> locales = new ArrayList<>();
    locales.add(new LocaleImpl());

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () ->
            catalogDocumentBuilderImpl.attachIndexableDocumentFields(
                null, indexable, fields, locales));
    verify(fieldImpl).getQualifiedFieldName();
    verify(indexFieldImpl).getField();
    verify(indexFieldImpl).getFieldTypes();
  }

  /**
   * Test {@link CatalogDocumentBuilderImpl#attachIndexableDocumentFields(SolrInputDocument,
   * Indexable, List, List)}.
   *
   * <ul>
   *   <li>Given {@link LocaleImpl} (default constructor).
   *   <li>When {@link ArrayList#ArrayList()} add {@link LocaleImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link
   * CatalogDocumentBuilderImpl#attachIndexableDocumentFields(SolrInputDocument, Indexable, List,
   * List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CatalogDocumentBuilderImpl.attachIndexableDocumentFields(SolrInputDocument, Indexable, List, List)"
  })
  public void testAttachIndexableDocumentFields_givenLocaleImpl_whenArrayListAddLocaleImpl2() {
    // Arrange
    CatalogDocumentBuilderImpl catalogDocumentBuilderImpl = new CatalogDocumentBuilderImpl();
    ProductBundleImpl indexable = new ProductBundleImpl();

    FieldImpl fieldImpl = mock(FieldImpl.class);
    when(fieldImpl.getQualifiedFieldName()).thenReturn("Qualified Field Name");

    IndexFieldImpl indexFieldImpl = mock(IndexFieldImpl.class);
    when(indexFieldImpl.getField()).thenReturn(fieldImpl);
    when(indexFieldImpl.getFieldTypes()).thenThrow(new IllegalStateException());

    ArrayList<IndexField> fields = new ArrayList<>();
    fields.add(indexFieldImpl);

    ArrayList<Locale> locales = new ArrayList<>();
    locales.add(new LocaleImpl());
    locales.add(new LocaleImpl());

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () ->
            catalogDocumentBuilderImpl.attachIndexableDocumentFields(
                null, indexable, fields, locales));
    verify(fieldImpl).getQualifiedFieldName();
    verify(indexFieldImpl).getField();
    verify(indexFieldImpl).getFieldTypes();
  }

  /**
   * Test {@link CatalogDocumentBuilderImpl#attachIndexableDocumentFields(SolrInputDocument,
   * Indexable, List, List)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * CatalogDocumentBuilderImpl#attachIndexableDocumentFields(SolrInputDocument, Indexable, List,
   * List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CatalogDocumentBuilderImpl.attachIndexableDocumentFields(SolrInputDocument, Indexable, List, List)"
  })
  public void testAttachIndexableDocumentFields_givenNull_whenArrayListAddNull() {
    // Arrange
    CatalogDocumentBuilderImpl catalogDocumentBuilderImpl = new CatalogDocumentBuilderImpl();
    ProductBundleImpl indexable = new ProductBundleImpl();

    ArrayList<IndexField> fields = new ArrayList<>();
    fields.add(null);

    // Act and Assert
    catalogDocumentBuilderImpl.attachIndexableDocumentFields(
        null, indexable, fields, new ArrayList<>());
  }

  /**
   * Test {@link CatalogDocumentBuilderImpl#attachIndexableDocumentFields(SolrInputDocument,
   * Indexable, List, List)}.
   *
   * <ul>
   *   <li>Then calls {@link FieldImpl#getQualifiedFieldName()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * CatalogDocumentBuilderImpl#attachIndexableDocumentFields(SolrInputDocument, Indexable, List,
   * List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CatalogDocumentBuilderImpl.attachIndexableDocumentFields(SolrInputDocument, Indexable, List, List)"
  })
  public void testAttachIndexableDocumentFields_thenCallsGetQualifiedFieldName() {
    // Arrange
    CatalogDocumentBuilderImpl catalogDocumentBuilderImpl = new CatalogDocumentBuilderImpl();
    ProductBundleImpl indexable = new ProductBundleImpl();

    FieldImpl fieldImpl = mock(FieldImpl.class);
    when(fieldImpl.getQualifiedFieldName()).thenReturn("Qualified Field Name");

    IndexFieldImpl indexFieldImpl = mock(IndexFieldImpl.class);
    when(indexFieldImpl.getField()).thenReturn(fieldImpl);
    when(indexFieldImpl.getFieldTypes()).thenThrow(new IllegalStateException());

    ArrayList<IndexField> fields = new ArrayList<>();
    fields.add(indexFieldImpl);

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () ->
            catalogDocumentBuilderImpl.attachIndexableDocumentFields(
                null, indexable, fields, new ArrayList<>()));
    verify(fieldImpl).getQualifiedFieldName();
    verify(indexFieldImpl).getField();
    verify(indexFieldImpl).getFieldTypes();
  }

  /**
   * Test {@link CatalogDocumentBuilderImpl#attachIndexableDocumentFields(SolrInputDocument,
   * Indexable, List, List)}.
   *
   * <ul>
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link
   * CatalogDocumentBuilderImpl#attachIndexableDocumentFields(SolrInputDocument, Indexable, List,
   * List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CatalogDocumentBuilderImpl.attachIndexableDocumentFields(SolrInputDocument, Indexable, List, List)"
  })
  public void testAttachIndexableDocumentFields_thenDoesNotThrow() {
    // Arrange
    CatalogDocumentBuilderImpl catalogDocumentBuilderImpl = new CatalogDocumentBuilderImpl();
    ProductBundleImpl indexable = new ProductBundleImpl();
    ArrayList<IndexField> fields = new ArrayList<>();

    // Act and Assert
    catalogDocumentBuilderImpl.attachIndexableDocumentFields(
        null, indexable, fields, new ArrayList<>());
  }

  /**
   * Test {@link CatalogDocumentBuilderImpl#attachIndexableDocumentFields(SolrInputDocument,
   * Indexable, List, List)}.
   *
   * <ul>
   *   <li>Then {@link SolrInputDocument#SolrInputDocument(String[])} Empty.
   * </ul>
   *
   * <p>Method under test: {@link
   * CatalogDocumentBuilderImpl#attachIndexableDocumentFields(SolrInputDocument, Indexable, List,
   * List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CatalogDocumentBuilderImpl.attachIndexableDocumentFields(SolrInputDocument, Indexable, List, List)"
  })
  public void testAttachIndexableDocumentFields_thenSolrInputDocumentEmpty()
      throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
    // Arrange
    I18nSolrIndexServiceExtensionHandler i18nSolrIndexServiceExtensionHandler =
        mock(I18nSolrIndexServiceExtensionHandler.class);
    when(i18nSolrIndexServiceExtensionHandler.populateDocumentForIndexField(
            Mockito.<SolrInputDocument>any(),
            Mockito.<IndexField>any(),
            Mockito.<FieldType>any(),
            Mockito.<Map<String, Object>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(i18nSolrIndexServiceExtensionHandler.addPropertyValues(
            Mockito.<Indexable>any(),
            Mockito.<Field>any(),
            Mockito.<FieldType>any(),
            Mockito.<Map<String, Object>>any(),
            Mockito.<String>any(),
            Mockito.<List<Locale>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(solrIndexServiceExtensionManager.getProxy())
        .thenReturn(i18nSolrIndexServiceExtensionHandler);
    SolrInputDocument document = new SolrInputDocument();
    ProductBundleImpl indexable = new ProductBundleImpl();

    IndexFieldTypeImpl indexFieldTypeImpl = mock(IndexFieldTypeImpl.class);
    when(indexFieldTypeImpl.getFieldType()).thenReturn(FieldType.BOOLEAN);

    ArrayList<IndexFieldType> fieldTypes = new ArrayList<>();
    fieldTypes.add(indexFieldTypeImpl);

    IndexFieldImpl indexFieldImpl = new IndexFieldImpl();
    indexFieldImpl.setField(new FieldImpl());
    indexFieldImpl.setId(1L);
    indexFieldImpl.setSearchable(true);
    indexFieldImpl.setFieldTypes(fieldTypes);

    ArrayList<IndexField> fields = new ArrayList<>();
    fields.add(indexFieldImpl);

    // Act
    catalogDocumentBuilderImpl.attachIndexableDocumentFields(
        document, indexable, fields, new ArrayList<>());

    // Assert that nothing has changed
    verify(solrIndexServiceExtensionManager, atLeast(1)).getProxy();
    verify(indexFieldTypeImpl).getFieldType();
    verify(i18nSolrIndexServiceExtensionHandler)
        .populateDocumentForIndexField(
            isA(SolrInputDocument.class),
            isA(IndexField.class),
            isA(FieldType.class),
            isA(Map.class));
    verify(i18nSolrIndexServiceExtensionHandler)
        .addPropertyValues(
            isA(Indexable.class),
            isA(Field.class),
            isA(FieldType.class),
            isA(Map.class),
            (String) isNull(),
            isA(List.class));
    assertTrue(document.isEmpty());
  }

  /**
   * Test {@link CatalogDocumentBuilderImpl#attachIndexableDocumentFields(SolrInputDocument,
   * Indexable, List, List)}.
   *
   * <ul>
   *   <li>Then {@link SolrInputDocument#SolrInputDocument(String[])} size is one.
   * </ul>
   *
   * <p>Method under test: {@link
   * CatalogDocumentBuilderImpl#attachIndexableDocumentFields(SolrInputDocument, Indexable, List,
   * List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CatalogDocumentBuilderImpl.attachIndexableDocumentFields(SolrInputDocument, Indexable, List, List)"
  })
  public void testAttachIndexableDocumentFields_thenSolrInputDocumentSizeIsOne()
      throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
    // Arrange
    when(solrIndexServiceExtensionManager.getProxy())
        .thenReturn(new I18nSolrIndexServiceExtensionHandler());
    when(solrHelperService.getPropertyNameForIndexField(
            Mockito.<IndexField>any(), Mockito.<FieldType>any(), Mockito.<String>any()))
        .thenReturn("Property Name For Index Field");
    when(solrHelperService.getPropertyValue(Mockito.<Object>any(), Mockito.<Field>any()))
        .thenReturn("Property Value");
    SolrInputDocument document = new SolrInputDocument();
    ProductBundleImpl indexable = new ProductBundleImpl();

    ArrayList<IndexFieldType> fieldTypes = new ArrayList<>();
    fieldTypes.add(new IndexFieldTypeImpl());

    IndexFieldImpl indexFieldImpl = new IndexFieldImpl();
    indexFieldImpl.setField(new FieldImpl());
    indexFieldImpl.setId(1L);
    indexFieldImpl.setSearchable(true);
    indexFieldImpl.setFieldTypes(fieldTypes);

    ArrayList<IndexField> fields = new ArrayList<>();
    fields.add(indexFieldImpl);

    // Act
    catalogDocumentBuilderImpl.attachIndexableDocumentFields(
        document, indexable, fields, new ArrayList<>());

    // Assert
    verify(solrIndexServiceExtensionManager, atLeast(1)).getProxy();
    verify(solrHelperService).getPropertyNameForIndexField(isA(IndexField.class), isNull(), eq(""));
    verify(solrHelperService).getPropertyValue(isA(Object.class), isA(Field.class));
    assertEquals(1, document.size());
    SolrInputField getResult = document.get("Property Name For Index Field");
    Collection<Object> values = getResult.getValues();
    assertEquals(1, values.size());
    assertTrue(values instanceof List);
    assertEquals("Property Name For Index Field", getResult.getName());
    Iterator<Object> iteratorResult = getResult.iterator();
    assertEquals("Property Value", iteratorResult.next());
    assertEquals("Property Value", ((List<Object>) values).get(0));
    assertEquals("Property Value", getResult.getFirstValue());
    assertEquals("Property Value", getResult.getValue());
    assertEquals(1, getResult.getValueCount());
    assertFalse(iteratorResult.hasNext());
  }

  /**
   * Test {@link CatalogDocumentBuilderImpl#attachAdditionalDocumentFields(Indexable,
   * SolrInputDocument)}.
   *
   * <p>Method under test: {@link
   * CatalogDocumentBuilderImpl#attachAdditionalDocumentFields(Indexable, SolrInputDocument)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CatalogDocumentBuilderImpl.attachAdditionalDocumentFields(Indexable, SolrInputDocument)"
  })
  public void testAttachAdditionalDocumentFields() {
    // Arrange
    when(solrIndexServiceExtensionManager.getProxy())
        .thenReturn(new I18nSolrIndexServiceExtensionHandler());

    // Act
    catalogDocumentBuilderImpl.attachAdditionalDocumentFields(new ProductBundleImpl(), null);

    // Assert
    verify(solrIndexServiceExtensionManager).getProxy();
  }

  /**
   * Test {@link CatalogDocumentBuilderImpl#attachAdditionalDocumentFields(Indexable,
   * SolrInputDocument)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * CatalogDocumentBuilderImpl#attachAdditionalDocumentFields(Indexable, SolrInputDocument)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CatalogDocumentBuilderImpl.attachAdditionalDocumentFields(Indexable, SolrInputDocument)"
  })
  public void testAttachAdditionalDocumentFields_thenThrowIllegalStateException() {
    // Arrange
    when(solrIndexServiceExtensionManager.getProxy()).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () ->
            catalogDocumentBuilderImpl.attachAdditionalDocumentFields(
                new ProductBundleImpl(), null));
    verify(solrIndexServiceExtensionManager).getProxy();
  }

  /**
   * Test {@link CatalogDocumentBuilderImpl#attachBasicDocumentFields(Indexable,
   * SolrInputDocument)}.
   *
   * <p>Method under test: {@link CatalogDocumentBuilderImpl#attachBasicDocumentFields(Indexable,
   * SolrInputDocument)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CatalogDocumentBuilderImpl.attachBasicDocumentFields(Indexable, SolrInputDocument)"
  })
  public void testAttachBasicDocumentFields() {
    // Arrange
    CatalogDocumentBuilderImpl catalogDocumentBuilderImpl = new CatalogDocumentBuilderImpl();

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () -> catalogDocumentBuilderImpl.attachBasicDocumentFields(new ProductBundleImpl(), null));
  }

  /**
   * Test {@link CatalogDocumentBuilderImpl#buildFullCategoryHierarchy(SolrInputDocument,
   * CatalogStructure, Long, Set)}.
   *
   * <p>Method under test: {@link
   * CatalogDocumentBuilderImpl#buildFullCategoryHierarchy(SolrInputDocument, CatalogStructure,
   * Long, Set)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CatalogDocumentBuilderImpl.buildFullCategoryHierarchy(SolrInputDocument, CatalogStructure, Long, Set)"
  })
  public void testBuildFullCategoryHierarchy() {
    // Arrange
    when(solrHelperService.getCategoryId(Mockito.<Long>any())).thenReturn(1L);
    when(solrHelperService.getCategoryFieldName()).thenReturn("Category Field Name");
    SolrInputDocument document = new SolrInputDocument();

    HashMap<Long, Set<Long>> parentCategoriesByCategory = new HashMap<>();
    HashSet<Long> resultLongSet = new HashSet<>();
    parentCategoriesByCategory.put(1L, resultLongSet);

    CatalogStructure cache = new CatalogStructure();
    cache.setDisplayOrdersByCategoryProduct(new HashMap<>());
    cache.setParentCategoriesByProduct(new HashMap<>());
    cache.setParentCategoriesByCategory(parentCategoriesByCategory);
    HashSet<Long> indexedParents = new HashSet<>();

    // Act
    catalogDocumentBuilderImpl.buildFullCategoryHierarchy(document, cache, 1L, indexedParents);

    // Assert
    verify(solrHelperService, atLeast(1)).getCategoryFieldName();
    verify(solrHelperService).getCategoryId(1L);
    assertEquals(1, document.size());
    SolrInputField getResult = document.get("Category Field Name");
    Collection<Object> values = getResult.getValues();
    assertEquals(1, values.size());
    assertTrue(values instanceof List);
    assertEquals(1, getResult.getValueCount());
    Iterator<Object> iteratorResult = getResult.iterator();
    assertEquals(1L, ((Long) iteratorResult.next()).longValue());
    assertEquals(1L, ((Long) ((List<Object>) values).get(0)).longValue());
    assertEquals(1L, ((Long) getResult.getFirstValue()).longValue());
    assertEquals(1L, ((Long) getResult.getValue()).longValue());
    assertFalse(iteratorResult.hasNext());
    assertEquals(resultLongSet, indexedParents);
  }

  /**
   * Test {@link CatalogDocumentBuilderImpl#buildFullCategoryHierarchy(SolrInputDocument,
   * CatalogStructure, Long, Set)}.
   *
   * <p>Method under test: {@link
   * CatalogDocumentBuilderImpl#buildFullCategoryHierarchy(SolrInputDocument, CatalogStructure,
   * Long, Set)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CatalogDocumentBuilderImpl.buildFullCategoryHierarchy(SolrInputDocument, CatalogStructure, Long, Set)"
  })
  public void testBuildFullCategoryHierarchy2() {
    // Arrange
    when(solrHelperService.getCategoryId(Mockito.<Long>any())).thenReturn(1L);
    when(solrHelperService.getCategoryFieldName()).thenReturn("Category Field Name");
    SolrInputDocument document = new SolrInputDocument();

    HashSet<Long> resultLongSet = new HashSet<>();
    resultLongSet.add(1L);

    HashMap<Long, Set<Long>> parentCategoriesByCategory = new HashMap<>();
    parentCategoriesByCategory.put(1L, resultLongSet);

    CatalogStructure cache = new CatalogStructure();
    cache.setDisplayOrdersByCategoryProduct(new HashMap<>());
    cache.setParentCategoriesByProduct(new HashMap<>());
    cache.setParentCategoriesByCategory(parentCategoriesByCategory);
    HashSet<Long> indexedParents = new HashSet<>();

    // Act
    catalogDocumentBuilderImpl.buildFullCategoryHierarchy(document, cache, 1L, indexedParents);

    // Assert
    verify(solrHelperService, atLeast(1)).getCategoryFieldName();
    verify(solrHelperService, atLeast(1)).getCategoryId(1L);
    assertEquals(1, document.size());
    SolrInputField getResult = document.get("Category Field Name");
    Collection<Object> values = getResult.getValues();
    assertEquals(1, values.size());
    assertTrue(values instanceof List);
    assertEquals(1, getResult.getValueCount());
    Iterator<Object> iteratorResult = getResult.iterator();
    assertEquals(1L, ((Long) iteratorResult.next()).longValue());
    assertEquals(1L, ((Long) ((List<Object>) values).get(0)).longValue());
    assertEquals(1L, ((Long) getResult.getFirstValue()).longValue());
    assertEquals(1L, ((Long) getResult.getValue()).longValue());
    assertFalse(iteratorResult.hasNext());
    assertEquals(resultLongSet, indexedParents);
  }

  /**
   * Test {@link CatalogDocumentBuilderImpl#buildFullCategoryHierarchy(SolrInputDocument,
   * CatalogStructure, Long, Set)}.
   *
   * <p>Method under test: {@link
   * CatalogDocumentBuilderImpl#buildFullCategoryHierarchy(SolrInputDocument, CatalogStructure,
   * Long, Set)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CatalogDocumentBuilderImpl.buildFullCategoryHierarchy(SolrInputDocument, CatalogStructure, Long, Set)"
  })
  public void testBuildFullCategoryHierarchy3() {
    // Arrange
    when(solrHelperService.getCategoryId(Mockito.<Long>any())).thenReturn(null);
    when(solrHelperService.getCategoryFieldName()).thenReturn("Category Field Name");
    SolrInputDocument document = new SolrInputDocument();

    HashSet<Long> resultLongSet = new HashSet<>();
    resultLongSet.add(1L);

    HashMap<Long, Set<Long>> parentCategoriesByCategory = new HashMap<>();
    parentCategoriesByCategory.put(1L, resultLongSet);

    CatalogStructure cache = new CatalogStructure();
    cache.setDisplayOrdersByCategoryProduct(new HashMap<>());
    cache.setParentCategoriesByProduct(new HashMap<>());
    cache.setParentCategoriesByCategory(parentCategoriesByCategory);

    // Act
    catalogDocumentBuilderImpl.buildFullCategoryHierarchy(document, cache, 1L, new HashSet<>());

    // Assert
    verify(solrHelperService, atLeast(1)).getCategoryFieldName();
    verify(solrHelperService, atLeast(1)).getCategoryId(1L);
    assertEquals(1, document.size());
    SolrInputField getResult = document.get("Category Field Name");
    assertNull(getResult.getFirstValue());
    assertNull(getResult.getValue());
    assertNull(getResult.getValues());
    assertEquals(0, getResult.getValueCount());
    assertFalse(getResult.iterator().hasNext());
  }

  /**
   * Test {@link CatalogDocumentBuilderImpl#buildFullCategoryHierarchy(SolrInputDocument,
   * CatalogStructure, Long, Set)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * CatalogDocumentBuilderImpl#buildFullCategoryHierarchy(SolrInputDocument, CatalogStructure,
   * Long, Set)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CatalogDocumentBuilderImpl.buildFullCategoryHierarchy(SolrInputDocument, CatalogStructure, Long, Set)"
  })
  public void testBuildFullCategoryHierarchy_thenThrowIllegalStateException() {
    // Arrange
    when(solrHelperService.getCategoryId(Mockito.<Long>any()))
        .thenThrow(new IllegalStateException());

    CatalogStructure cache = new CatalogStructure();
    cache.setDisplayOrdersByCategoryProduct(new HashMap<>());
    cache.setParentCategoriesByCategory(new HashMap<>());
    cache.setParentCategoriesByProduct(new HashMap<>());

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () ->
            catalogDocumentBuilderImpl.buildFullCategoryHierarchy(
                null, cache, 1L, new HashSet<>()));
    verify(solrHelperService).getCategoryId(1L);
  }

  /**
   * Test {@link CatalogDocumentBuilderImpl#getPropertyValues(Indexable, Field, FieldType, List)}.
   *
   * <p>Method under test: {@link CatalogDocumentBuilderImpl#getPropertyValues(Indexable, Field,
   * FieldType, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Map CatalogDocumentBuilderImpl.getPropertyValues(Indexable, Field, FieldType, List)"
  })
  public void testGetPropertyValues()
      throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
    // Arrange
    when(solrIndexServiceExtensionManager.getProxy()).thenThrow(new IllegalStateException());
    ProductBundleImpl indexedItem = new ProductBundleImpl();
    FieldImpl field = new FieldImpl();

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () ->
            catalogDocumentBuilderImpl.getPropertyValues(
                indexedItem, field, FieldType.BOOLEAN, new ArrayList<>()));
    verify(solrIndexServiceExtensionManager).getProxy();
  }

  /**
   * Test {@link CatalogDocumentBuilderImpl#getPropertyValues(Indexable, Field, FieldType, List)}.
   *
   * <p>Method under test: {@link CatalogDocumentBuilderImpl#getPropertyValues(Indexable, Field,
   * FieldType, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Map CatalogDocumentBuilderImpl.getPropertyValues(Indexable, Field, FieldType, List)"
  })
  public void testGetPropertyValues2()
      throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
    // Arrange
    when(solrIndexServiceExtensionManager.getProxy())
        .thenReturn(new I18nSolrIndexServiceExtensionHandler());
    when(solrHelperService.getPropertyValue(Mockito.<Object>any(), Mockito.<Field>any()))
        .thenThrow(new IllegalStateException());
    ProductBundleImpl indexedItem = new ProductBundleImpl();
    FieldImpl field = new FieldImpl();

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () ->
            catalogDocumentBuilderImpl.getPropertyValues(
                indexedItem, field, FieldType.BOOLEAN, new ArrayList<>()));
    verify(solrIndexServiceExtensionManager).getProxy();
    verify(solrHelperService).getPropertyValue(isA(Object.class), isA(Field.class));
  }

  /**
   * Test {@link CatalogDocumentBuilderImpl#getPropertyValues(Indexable, Field, FieldType, List)}.
   *
   * <ul>
   *   <li>Given {@link LocaleImpl} (default constructor).
   *   <li>When {@link ArrayList#ArrayList()} add {@link LocaleImpl} (default constructor).
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link CatalogDocumentBuilderImpl#getPropertyValues(Indexable, Field,
   * FieldType, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Map CatalogDocumentBuilderImpl.getPropertyValues(Indexable, Field, FieldType, List)"
  })
  public void testGetPropertyValues_givenLocaleImpl_whenArrayListAddLocaleImpl_thenReturnEmpty()
      throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
    // Arrange
    I18nSolrIndexServiceExtensionHandler i18nSolrIndexServiceExtensionHandler =
        mock(I18nSolrIndexServiceExtensionHandler.class);
    when(i18nSolrIndexServiceExtensionHandler.addPropertyValues(
            Mockito.<Indexable>any(),
            Mockito.<Field>any(),
            Mockito.<FieldType>any(),
            Mockito.<Map<String, Object>>any(),
            Mockito.<String>any(),
            Mockito.<List<Locale>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(solrIndexServiceExtensionManager.getProxy())
        .thenReturn(i18nSolrIndexServiceExtensionHandler);
    ProductBundleImpl indexedItem = new ProductBundleImpl();
    FieldImpl field = new FieldImpl();

    ArrayList<Locale> locales = new ArrayList<>();
    locales.add(new LocaleImpl());

    // Act
    Map<String, Object> actualPropertyValues =
        catalogDocumentBuilderImpl.getPropertyValues(
            indexedItem, field, FieldType.BOOLEAN, locales);

    // Assert
    verify(solrIndexServiceExtensionManager).getProxy();
    verify(i18nSolrIndexServiceExtensionHandler)
        .addPropertyValues(
            isA(Indexable.class),
            isA(Field.class),
            isA(FieldType.class),
            isA(Map.class),
            (String) isNull(),
            isA(List.class));
    assertTrue(actualPropertyValues.isEmpty());
  }

  /**
   * Test {@link CatalogDocumentBuilderImpl#getPropertyValues(Indexable, Field, FieldType, List)}.
   *
   * <ul>
   *   <li>Given {@link LocaleImpl} (default constructor).
   *   <li>When {@link ArrayList#ArrayList()} add {@link LocaleImpl} (default constructor).
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link CatalogDocumentBuilderImpl#getPropertyValues(Indexable, Field,
   * FieldType, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Map CatalogDocumentBuilderImpl.getPropertyValues(Indexable, Field, FieldType, List)"
  })
  public void testGetPropertyValues_givenLocaleImpl_whenArrayListAddLocaleImpl_thenReturnEmpty2()
      throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
    // Arrange
    I18nSolrIndexServiceExtensionHandler i18nSolrIndexServiceExtensionHandler =
        mock(I18nSolrIndexServiceExtensionHandler.class);
    when(i18nSolrIndexServiceExtensionHandler.addPropertyValues(
            Mockito.<Indexable>any(),
            Mockito.<Field>any(),
            Mockito.<FieldType>any(),
            Mockito.<Map<String, Object>>any(),
            Mockito.<String>any(),
            Mockito.<List<Locale>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(solrIndexServiceExtensionManager.getProxy())
        .thenReturn(i18nSolrIndexServiceExtensionHandler);
    ProductBundleImpl indexedItem = new ProductBundleImpl();
    FieldImpl field = new FieldImpl();

    ArrayList<Locale> locales = new ArrayList<>();
    locales.add(new LocaleImpl());
    locales.add(new LocaleImpl());

    // Act
    Map<String, Object> actualPropertyValues =
        catalogDocumentBuilderImpl.getPropertyValues(
            indexedItem, field, FieldType.BOOLEAN, locales);

    // Assert
    verify(solrIndexServiceExtensionManager).getProxy();
    verify(i18nSolrIndexServiceExtensionHandler)
        .addPropertyValues(
            isA(Indexable.class),
            isA(Field.class),
            isA(FieldType.class),
            isA(Map.class),
            (String) isNull(),
            isA(List.class));
    assertTrue(actualPropertyValues.isEmpty());
  }

  /**
   * Test {@link CatalogDocumentBuilderImpl#getPropertyValues(Indexable, Field, FieldType, List)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link CatalogDocumentBuilderImpl#getPropertyValues(Indexable, Field,
   * FieldType, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Map CatalogDocumentBuilderImpl.getPropertyValues(Indexable, Field, FieldType, List)"
  })
  public void testGetPropertyValues_thenReturnEmpty()
      throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
    // Arrange
    I18nSolrIndexServiceExtensionHandler i18nSolrIndexServiceExtensionHandler =
        mock(I18nSolrIndexServiceExtensionHandler.class);
    when(i18nSolrIndexServiceExtensionHandler.addPropertyValues(
            Mockito.<Indexable>any(),
            Mockito.<Field>any(),
            Mockito.<FieldType>any(),
            Mockito.<Map<String, Object>>any(),
            Mockito.<String>any(),
            Mockito.<List<Locale>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(solrIndexServiceExtensionManager.getProxy())
        .thenReturn(i18nSolrIndexServiceExtensionHandler);
    ProductBundleImpl indexedItem = new ProductBundleImpl();
    FieldImpl field = new FieldImpl();

    // Act
    Map<String, Object> actualPropertyValues =
        catalogDocumentBuilderImpl.getPropertyValues(
            indexedItem, field, FieldType.BOOLEAN, new ArrayList<>());

    // Assert
    verify(solrIndexServiceExtensionManager).getProxy();
    verify(i18nSolrIndexServiceExtensionHandler)
        .addPropertyValues(
            isA(Indexable.class),
            isA(Field.class),
            isA(FieldType.class),
            isA(Map.class),
            (String) isNull(),
            isA(List.class));
    assertTrue(actualPropertyValues.isEmpty());
  }

  /**
   * Test {@link CatalogDocumentBuilderImpl#getPropertyValues(Indexable, Field, FieldType, List)}.
   *
   * <ul>
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link CatalogDocumentBuilderImpl#getPropertyValues(Indexable, Field,
   * FieldType, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Map CatalogDocumentBuilderImpl.getPropertyValues(Indexable, Field, FieldType, List)"
  })
  public void testGetPropertyValues_thenReturnSizeIsOne()
      throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
    // Arrange
    when(solrIndexServiceExtensionManager.getProxy())
        .thenReturn(new I18nSolrIndexServiceExtensionHandler());
    when(solrHelperService.getPropertyValue(Mockito.<Object>any(), Mockito.<Field>any()))
        .thenReturn("Property Value");
    ProductBundleImpl indexedItem = new ProductBundleImpl();
    FieldImpl field = new FieldImpl();

    // Act
    Map<String, Object> actualPropertyValues =
        catalogDocumentBuilderImpl.getPropertyValues(
            indexedItem, field, FieldType.BOOLEAN, new ArrayList<>());

    // Assert
    verify(solrIndexServiceExtensionManager).getProxy();
    verify(solrHelperService).getPropertyValue(isA(Object.class), isA(Field.class));
    assertEquals(1, actualPropertyValues.size());
    assertEquals("Property Value", actualPropertyValues.get(""));
  }

  /**
   * Test {@link CatalogDocumentBuilderImpl#convertDisplayOrderToLong(CatalogStructure, String)}.
   *
   * <ul>
   *   <li>Then return longValue is {@code 2300000}.
   * </ul>
   *
   * <p>Method under test: {@link
   * CatalogDocumentBuilderImpl#convertDisplayOrderToLong(CatalogStructure, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Long CatalogDocumentBuilderImpl.convertDisplayOrderToLong(CatalogStructure, String)"
  })
  public void testConvertDisplayOrderToLong_thenReturnLongValueIs2300000() {
    // Arrange
    CatalogDocumentBuilderImpl catalogDocumentBuilderImpl = new CatalogDocumentBuilderImpl();

    HashMap<String, BigDecimal> displayOrdersByCategoryProduct = new HashMap<>();
    displayOrdersByCategoryProduct.put("42", new BigDecimal("2.3"));

    CatalogStructure cache = new CatalogStructure();
    cache.setDisplayOrdersByCategoryProduct(displayOrdersByCategoryProduct);
    cache.setParentCategoriesByCategory(new HashMap<>());
    cache.setParentCategoriesByProduct(new HashMap<>());

    // Act and Assert
    assertEquals(
        2300000L, catalogDocumentBuilderImpl.convertDisplayOrderToLong(cache, "42").longValue());
  }

  /**
   * Test {@link CatalogDocumentBuilderImpl#convertDisplayOrderToLong(CatalogStructure, String)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * CatalogDocumentBuilderImpl#convertDisplayOrderToLong(CatalogStructure, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Long CatalogDocumentBuilderImpl.convertDisplayOrderToLong(CatalogStructure, String)"
  })
  public void testConvertDisplayOrderToLong_thenThrowIllegalStateException() {
    // Arrange
    CatalogDocumentBuilderImpl catalogDocumentBuilderImpl = new CatalogDocumentBuilderImpl();

    InternalNumber internalNumber = mock(InternalNumber.class);
    when(internalNumber.multiply(Mockito.<BigDecimal>any())).thenThrow(new IllegalStateException());

    HashMap<String, BigDecimal> displayOrdersByCategoryProduct = new HashMap<>();
    displayOrdersByCategoryProduct.put("42", internalNumber);

    CatalogStructure cache = new CatalogStructure();
    cache.setDisplayOrdersByCategoryProduct(displayOrdersByCategoryProduct);
    cache.setParentCategoriesByCategory(new HashMap<>());
    cache.setParentCategoriesByProduct(new HashMap<>());

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () -> catalogDocumentBuilderImpl.convertDisplayOrderToLong(cache, "42"));
    verify(internalNumber).multiply(isA(BigDecimal.class));
  }

  /**
   * Test {@link CatalogDocumentBuilderImpl#convertDisplayOrderToLong(CatalogStructure, String)}.
   *
   * <ul>
   *   <li>When {@code Display Order Key}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * CatalogDocumentBuilderImpl#convertDisplayOrderToLong(CatalogStructure, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Long CatalogDocumentBuilderImpl.convertDisplayOrderToLong(CatalogStructure, String)"
  })
  public void testConvertDisplayOrderToLong_whenDisplayOrderKey_thenReturnNull() {
    // Arrange
    CatalogDocumentBuilderImpl catalogDocumentBuilderImpl = new CatalogDocumentBuilderImpl();

    CatalogStructure cache = new CatalogStructure();
    cache.setDisplayOrdersByCategoryProduct(new HashMap<>());
    cache.setParentCategoriesByCategory(new HashMap<>());
    cache.setParentCategoriesByProduct(new HashMap<>());

    // Act and Assert
    assertNull(catalogDocumentBuilderImpl.convertDisplayOrderToLong(cache, "Display Order Key"));
  }
}
