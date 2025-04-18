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
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.solr.common.SolrInputDocument;
import org.broadleafcommerce.common.extension.ExtensionResultStatusType;
import org.broadleafcommerce.common.i18n.service.TranslationService;
import org.broadleafcommerce.common.locale.domain.Locale;
import org.broadleafcommerce.common.locale.domain.LocaleImpl;
import org.broadleafcommerce.common.locale.service.LocaleService;
import org.broadleafcommerce.core.catalog.domain.Indexable;
import org.broadleafcommerce.core.catalog.domain.ProductBundleImpl;
import org.broadleafcommerce.core.search.domain.IndexField;
import org.broadleafcommerce.core.search.domain.IndexFieldImpl;
import org.broadleafcommerce.core.search.domain.solr.FieldType;
import org.broadleafcommerce.core.search.service.solr.SolrHelperService;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class AbstractSolrIndexServiceExtensionHandlerDiffblueTest {
  @Mock
  private LocaleService localeService;

  @Mock
  private SolrHelperService solrHelperService;

  @Mock
  private TranslationService translationService;

  /**
   * Test {@link AbstractSolrIndexServiceExtensionHandler#attachAdditionalBasicFields(Indexable, SolrInputDocument, SolrHelperService)}.
   * <p>
   * Method under test: {@link AbstractSolrIndexServiceExtensionHandler#attachAdditionalBasicFields(Indexable, SolrInputDocument, SolrHelperService)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "ExtensionResultStatusType AbstractSolrIndexServiceExtensionHandler.attachAdditionalBasicFields(Indexable, SolrInputDocument, SolrHelperService)"})
  public void testAttachAdditionalBasicFields() {
    // Arrange
    I18nSolrIndexServiceExtensionHandler i18nSolrIndexServiceExtensionHandler = new I18nSolrIndexServiceExtensionHandler();

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, i18nSolrIndexServiceExtensionHandler
        .attachAdditionalBasicFields(new ProductBundleImpl(), null, solrHelperService));
  }

  /**
   * Test {@link AbstractSolrIndexServiceExtensionHandler#populateDocumentForIndexField(SolrInputDocument, IndexField, FieldType, Map)}.
   * <p>
   * Method under test: {@link AbstractSolrIndexServiceExtensionHandler#populateDocumentForIndexField(SolrInputDocument, IndexField, FieldType, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "ExtensionResultStatusType AbstractSolrIndexServiceExtensionHandler.populateDocumentForIndexField(SolrInputDocument, IndexField, FieldType, Map)"})
  public void testPopulateDocumentForIndexField() {
    // Arrange
    I18nSolrIndexServiceExtensionHandler i18nSolrIndexServiceExtensionHandler = new I18nSolrIndexServiceExtensionHandler();
    IndexFieldImpl field = new IndexFieldImpl();

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, i18nSolrIndexServiceExtensionHandler
        .populateDocumentForIndexField(null, field, FieldType.BOOLEAN, new HashMap<>()));
  }

  /**
   * Test {@link AbstractSolrIndexServiceExtensionHandler#attachAdditionalDocumentFields(Indexable, SolrInputDocument)}.
   * <p>
   * Method under test: {@link AbstractSolrIndexServiceExtensionHandler#attachAdditionalDocumentFields(Indexable, SolrInputDocument)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "ExtensionResultStatusType AbstractSolrIndexServiceExtensionHandler.attachAdditionalDocumentFields(Indexable, SolrInputDocument)"})
  public void testAttachAdditionalDocumentFields() {
    // Arrange
    I18nSolrIndexServiceExtensionHandler i18nSolrIndexServiceExtensionHandler = new I18nSolrIndexServiceExtensionHandler();

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        i18nSolrIndexServiceExtensionHandler.attachAdditionalDocumentFields(new ProductBundleImpl(), null));
  }

  /**
   * Test {@link AbstractSolrIndexServiceExtensionHandler#attachChildDocuments(Indexable, SolrInputDocument, List, List)}.
   * <ul>
   *   <li>Given {@link IndexFieldImpl} (default constructor).</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link IndexFieldImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractSolrIndexServiceExtensionHandler#attachChildDocuments(Indexable, SolrInputDocument, List, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "ExtensionResultStatusType AbstractSolrIndexServiceExtensionHandler.attachChildDocuments(Indexable, SolrInputDocument, List, List)"})
  public void testAttachChildDocuments_givenIndexFieldImpl_whenArrayListAddIndexFieldImpl() {
    // Arrange
    I18nSolrIndexServiceExtensionHandler i18nSolrIndexServiceExtensionHandler = new I18nSolrIndexServiceExtensionHandler();
    ProductBundleImpl indexable = new ProductBundleImpl();

    ArrayList<IndexField> fields = new ArrayList<>();
    fields.add(new IndexFieldImpl());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        i18nSolrIndexServiceExtensionHandler.attachChildDocuments(indexable, null, fields, new ArrayList<>()));
  }

  /**
   * Test {@link AbstractSolrIndexServiceExtensionHandler#attachChildDocuments(Indexable, SolrInputDocument, List, List)}.
   * <ul>
   *   <li>Given {@link IndexFieldImpl} (default constructor).</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link IndexFieldImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractSolrIndexServiceExtensionHandler#attachChildDocuments(Indexable, SolrInputDocument, List, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "ExtensionResultStatusType AbstractSolrIndexServiceExtensionHandler.attachChildDocuments(Indexable, SolrInputDocument, List, List)"})
  public void testAttachChildDocuments_givenIndexFieldImpl_whenArrayListAddIndexFieldImpl2() {
    // Arrange
    I18nSolrIndexServiceExtensionHandler i18nSolrIndexServiceExtensionHandler = new I18nSolrIndexServiceExtensionHandler();
    ProductBundleImpl indexable = new ProductBundleImpl();

    ArrayList<IndexField> fields = new ArrayList<>();
    fields.add(new IndexFieldImpl());
    fields.add(new IndexFieldImpl());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        i18nSolrIndexServiceExtensionHandler.attachChildDocuments(indexable, null, fields, new ArrayList<>()));
  }

  /**
   * Test {@link AbstractSolrIndexServiceExtensionHandler#attachChildDocuments(Indexable, SolrInputDocument, List, List)}.
   * <ul>
   *   <li>Given {@link LocaleImpl} (default constructor).</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link LocaleImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractSolrIndexServiceExtensionHandler#attachChildDocuments(Indexable, SolrInputDocument, List, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "ExtensionResultStatusType AbstractSolrIndexServiceExtensionHandler.attachChildDocuments(Indexable, SolrInputDocument, List, List)"})
  public void testAttachChildDocuments_givenLocaleImpl_whenArrayListAddLocaleImpl() {
    // Arrange
    I18nSolrIndexServiceExtensionHandler i18nSolrIndexServiceExtensionHandler = new I18nSolrIndexServiceExtensionHandler();
    ProductBundleImpl indexable = new ProductBundleImpl();
    ArrayList<IndexField> fields = new ArrayList<>();

    ArrayList<Locale> locales = new ArrayList<>();
    locales.add(new LocaleImpl());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        i18nSolrIndexServiceExtensionHandler.attachChildDocuments(indexable, null, fields, locales));
  }

  /**
   * Test {@link AbstractSolrIndexServiceExtensionHandler#attachChildDocuments(Indexable, SolrInputDocument, List, List)}.
   * <ul>
   *   <li>Given {@link LocaleImpl} (default constructor).</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link LocaleImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractSolrIndexServiceExtensionHandler#attachChildDocuments(Indexable, SolrInputDocument, List, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "ExtensionResultStatusType AbstractSolrIndexServiceExtensionHandler.attachChildDocuments(Indexable, SolrInputDocument, List, List)"})
  public void testAttachChildDocuments_givenLocaleImpl_whenArrayListAddLocaleImpl2() {
    // Arrange
    I18nSolrIndexServiceExtensionHandler i18nSolrIndexServiceExtensionHandler = new I18nSolrIndexServiceExtensionHandler();
    ProductBundleImpl indexable = new ProductBundleImpl();
    ArrayList<IndexField> fields = new ArrayList<>();

    ArrayList<Locale> locales = new ArrayList<>();
    locales.add(new LocaleImpl());
    locales.add(new LocaleImpl());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        i18nSolrIndexServiceExtensionHandler.attachChildDocuments(indexable, null, fields, locales));
  }

  /**
   * Test {@link AbstractSolrIndexServiceExtensionHandler#attachChildDocuments(Indexable, SolrInputDocument, List, List)}.
   * <ul>
   *   <li>When {@link ProductBundleImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractSolrIndexServiceExtensionHandler#attachChildDocuments(Indexable, SolrInputDocument, List, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "ExtensionResultStatusType AbstractSolrIndexServiceExtensionHandler.attachChildDocuments(Indexable, SolrInputDocument, List, List)"})
  public void testAttachChildDocuments_whenProductBundleImpl() {
    // Arrange
    I18nSolrIndexServiceExtensionHandler i18nSolrIndexServiceExtensionHandler = new I18nSolrIndexServiceExtensionHandler();
    ProductBundleImpl indexable = new ProductBundleImpl();
    ArrayList<IndexField> fields = new ArrayList<>();

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        i18nSolrIndexServiceExtensionHandler.attachChildDocuments(indexable, null, fields, new ArrayList<>()));
  }

  /**
   * Test {@link AbstractSolrIndexServiceExtensionHandler#modifyBuiltDocuments(Collection, List, List, List)}.
   * <ul>
   *   <li>Given {@link IndexFieldImpl} (default constructor).</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link IndexFieldImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractSolrIndexServiceExtensionHandler#modifyBuiltDocuments(Collection, List, List, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "ExtensionResultStatusType AbstractSolrIndexServiceExtensionHandler.modifyBuiltDocuments(Collection, List, List, List)"})
  public void testModifyBuiltDocuments_givenIndexFieldImpl_whenArrayListAddIndexFieldImpl() {
    // Arrange
    I18nSolrIndexServiceExtensionHandler i18nSolrIndexServiceExtensionHandler = new I18nSolrIndexServiceExtensionHandler();
    ArrayList<SolrInputDocument> documents = new ArrayList<>();
    ArrayList<Indexable> products = new ArrayList<>();

    ArrayList<IndexField> fields = new ArrayList<>();
    fields.add(new IndexFieldImpl());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        i18nSolrIndexServiceExtensionHandler.modifyBuiltDocuments(documents, products, fields, new ArrayList<>()));
  }

  /**
   * Test {@link AbstractSolrIndexServiceExtensionHandler#modifyBuiltDocuments(Collection, List, List, List)}.
   * <ul>
   *   <li>Given {@link IndexFieldImpl} (default constructor).</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link IndexFieldImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractSolrIndexServiceExtensionHandler#modifyBuiltDocuments(Collection, List, List, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "ExtensionResultStatusType AbstractSolrIndexServiceExtensionHandler.modifyBuiltDocuments(Collection, List, List, List)"})
  public void testModifyBuiltDocuments_givenIndexFieldImpl_whenArrayListAddIndexFieldImpl2() {
    // Arrange
    I18nSolrIndexServiceExtensionHandler i18nSolrIndexServiceExtensionHandler = new I18nSolrIndexServiceExtensionHandler();
    ArrayList<SolrInputDocument> documents = new ArrayList<>();
    ArrayList<Indexable> products = new ArrayList<>();

    ArrayList<IndexField> fields = new ArrayList<>();
    fields.add(new IndexFieldImpl());
    fields.add(new IndexFieldImpl());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        i18nSolrIndexServiceExtensionHandler.modifyBuiltDocuments(documents, products, fields, new ArrayList<>()));
  }

  /**
   * Test {@link AbstractSolrIndexServiceExtensionHandler#modifyBuiltDocuments(Collection, List, List, List)}.
   * <ul>
   *   <li>Given {@link LocaleImpl} (default constructor).</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link LocaleImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractSolrIndexServiceExtensionHandler#modifyBuiltDocuments(Collection, List, List, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "ExtensionResultStatusType AbstractSolrIndexServiceExtensionHandler.modifyBuiltDocuments(Collection, List, List, List)"})
  public void testModifyBuiltDocuments_givenLocaleImpl_whenArrayListAddLocaleImpl() {
    // Arrange
    I18nSolrIndexServiceExtensionHandler i18nSolrIndexServiceExtensionHandler = new I18nSolrIndexServiceExtensionHandler();
    ArrayList<SolrInputDocument> documents = new ArrayList<>();
    ArrayList<Indexable> products = new ArrayList<>();
    ArrayList<IndexField> fields = new ArrayList<>();

    ArrayList<Locale> locales = new ArrayList<>();
    locales.add(new LocaleImpl());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        i18nSolrIndexServiceExtensionHandler.modifyBuiltDocuments(documents, products, fields, locales));
  }

  /**
   * Test {@link AbstractSolrIndexServiceExtensionHandler#modifyBuiltDocuments(Collection, List, List, List)}.
   * <ul>
   *   <li>Given {@link LocaleImpl} (default constructor).</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link LocaleImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractSolrIndexServiceExtensionHandler#modifyBuiltDocuments(Collection, List, List, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "ExtensionResultStatusType AbstractSolrIndexServiceExtensionHandler.modifyBuiltDocuments(Collection, List, List, List)"})
  public void testModifyBuiltDocuments_givenLocaleImpl_whenArrayListAddLocaleImpl2() {
    // Arrange
    I18nSolrIndexServiceExtensionHandler i18nSolrIndexServiceExtensionHandler = new I18nSolrIndexServiceExtensionHandler();
    ArrayList<SolrInputDocument> documents = new ArrayList<>();
    ArrayList<Indexable> products = new ArrayList<>();
    ArrayList<IndexField> fields = new ArrayList<>();

    ArrayList<Locale> locales = new ArrayList<>();
    locales.add(new LocaleImpl());
    locales.add(new LocaleImpl());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        i18nSolrIndexServiceExtensionHandler.modifyBuiltDocuments(documents, products, fields, locales));
  }

  /**
   * Test {@link AbstractSolrIndexServiceExtensionHandler#modifyBuiltDocuments(Collection, List, List, List)}.
   * <ul>
   *   <li>Given {@link ProductBundleImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractSolrIndexServiceExtensionHandler#modifyBuiltDocuments(Collection, List, List, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "ExtensionResultStatusType AbstractSolrIndexServiceExtensionHandler.modifyBuiltDocuments(Collection, List, List, List)"})
  public void testModifyBuiltDocuments_givenProductBundleImpl() {
    // Arrange
    I18nSolrIndexServiceExtensionHandler i18nSolrIndexServiceExtensionHandler = new I18nSolrIndexServiceExtensionHandler();
    ArrayList<SolrInputDocument> documents = new ArrayList<>();

    ArrayList<Indexable> products = new ArrayList<>();
    products.add(new ProductBundleImpl());
    ArrayList<IndexField> fields = new ArrayList<>();

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        i18nSolrIndexServiceExtensionHandler.modifyBuiltDocuments(documents, products, fields, new ArrayList<>()));
  }

  /**
   * Test {@link AbstractSolrIndexServiceExtensionHandler#modifyBuiltDocuments(Collection, List, List, List)}.
   * <ul>
   *   <li>Given {@link ProductBundleImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractSolrIndexServiceExtensionHandler#modifyBuiltDocuments(Collection, List, List, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "ExtensionResultStatusType AbstractSolrIndexServiceExtensionHandler.modifyBuiltDocuments(Collection, List, List, List)"})
  public void testModifyBuiltDocuments_givenProductBundleImpl2() {
    // Arrange
    I18nSolrIndexServiceExtensionHandler i18nSolrIndexServiceExtensionHandler = new I18nSolrIndexServiceExtensionHandler();
    ArrayList<SolrInputDocument> documents = new ArrayList<>();

    ArrayList<Indexable> products = new ArrayList<>();
    products.add(new ProductBundleImpl());
    products.add(new ProductBundleImpl());
    ArrayList<IndexField> fields = new ArrayList<>();

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        i18nSolrIndexServiceExtensionHandler.modifyBuiltDocuments(documents, products, fields, new ArrayList<>()));
  }

  /**
   * Test {@link AbstractSolrIndexServiceExtensionHandler#modifyBuiltDocuments(Collection, List, List, List)}.
   * <ul>
   *   <li>Given {@link SolrInputDocument}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractSolrIndexServiceExtensionHandler#modifyBuiltDocuments(Collection, List, List, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "ExtensionResultStatusType AbstractSolrIndexServiceExtensionHandler.modifyBuiltDocuments(Collection, List, List, List)"})
  public void testModifyBuiltDocuments_givenSolrInputDocument() {
    // Arrange
    I18nSolrIndexServiceExtensionHandler i18nSolrIndexServiceExtensionHandler = new I18nSolrIndexServiceExtensionHandler();

    ArrayList<SolrInputDocument> documents = new ArrayList<>();
    documents.add(mock(SolrInputDocument.class));
    ArrayList<Indexable> products = new ArrayList<>();
    ArrayList<IndexField> fields = new ArrayList<>();

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        i18nSolrIndexServiceExtensionHandler.modifyBuiltDocuments(documents, products, fields, new ArrayList<>()));
  }

  /**
   * Test {@link AbstractSolrIndexServiceExtensionHandler#modifyBuiltDocuments(Collection, List, List, List)}.
   * <ul>
   *   <li>Given {@link SolrInputDocument}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractSolrIndexServiceExtensionHandler#modifyBuiltDocuments(Collection, List, List, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "ExtensionResultStatusType AbstractSolrIndexServiceExtensionHandler.modifyBuiltDocuments(Collection, List, List, List)"})
  public void testModifyBuiltDocuments_givenSolrInputDocument2() {
    // Arrange
    I18nSolrIndexServiceExtensionHandler i18nSolrIndexServiceExtensionHandler = new I18nSolrIndexServiceExtensionHandler();

    ArrayList<SolrInputDocument> documents = new ArrayList<>();
    documents.add(mock(SolrInputDocument.class));
    documents.add(mock(SolrInputDocument.class));
    ArrayList<Indexable> products = new ArrayList<>();
    ArrayList<IndexField> fields = new ArrayList<>();

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        i18nSolrIndexServiceExtensionHandler.modifyBuiltDocuments(documents, products, fields, new ArrayList<>()));
  }

  /**
   * Test {@link AbstractSolrIndexServiceExtensionHandler#modifyBuiltDocuments(Collection, List, List, List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractSolrIndexServiceExtensionHandler#modifyBuiltDocuments(Collection, List, List, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "ExtensionResultStatusType AbstractSolrIndexServiceExtensionHandler.modifyBuiltDocuments(Collection, List, List, List)"})
  public void testModifyBuiltDocuments_whenArrayList() {
    // Arrange
    I18nSolrIndexServiceExtensionHandler i18nSolrIndexServiceExtensionHandler = new I18nSolrIndexServiceExtensionHandler();
    ArrayList<SolrInputDocument> documents = new ArrayList<>();
    ArrayList<Indexable> products = new ArrayList<>();
    ArrayList<IndexField> fields = new ArrayList<>();

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        i18nSolrIndexServiceExtensionHandler.modifyBuiltDocuments(documents, products, fields, new ArrayList<>()));
  }

  /**
   * Test {@link AbstractSolrIndexServiceExtensionHandler#getIndexableId(Indexable, Long[])}.
   * <p>
   * Method under test: {@link AbstractSolrIndexServiceExtensionHandler#getIndexableId(Indexable, Long[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "ExtensionResultStatusType AbstractSolrIndexServiceExtensionHandler.getIndexableId(Indexable, Long[])"})
  public void testGetIndexableId() {
    // Arrange
    I18nSolrIndexServiceExtensionHandler i18nSolrIndexServiceExtensionHandler = new I18nSolrIndexServiceExtensionHandler();

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        i18nSolrIndexServiceExtensionHandler.getIndexableId(new ProductBundleImpl(), new Long[]{1L}));
  }

  /**
   * Test {@link AbstractSolrIndexServiceExtensionHandler#getCategoryId(Long, Long[])}.
   * <p>
   * Method under test: {@link AbstractSolrIndexServiceExtensionHandler#getCategoryId(Long, Long[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ExtensionResultStatusType AbstractSolrIndexServiceExtensionHandler.getCategoryId(Long, Long[])"})
  public void testGetCategoryId() {
    // Arrange, Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        (new I18nSolrIndexServiceExtensionHandler()).getCategoryId(1L, new Long[]{1L}));
  }
}
