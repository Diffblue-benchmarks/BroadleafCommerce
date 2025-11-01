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
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.solr.common.SolrInputDocument;
import org.broadleafcommerce.common.extension.ExtensionResultStatusType;
import org.broadleafcommerce.common.locale.domain.Locale;
import org.broadleafcommerce.common.locale.domain.LocaleImpl;
import org.broadleafcommerce.core.catalog.domain.Indexable;
import org.broadleafcommerce.core.catalog.domain.ProductBundleImpl;
import org.broadleafcommerce.core.search.domain.FieldImpl;
import org.broadleafcommerce.core.search.domain.IndexField;
import org.broadleafcommerce.core.search.domain.IndexFieldImpl;
import org.broadleafcommerce.core.search.domain.solr.FieldType;
import org.broadleafcommerce.core.search.service.solr.SolrHelperService;
import org.broadleafcommerce.core.search.service.solr.SolrHelperServiceImpl;
import org.junit.Test;

public class AbstractSolrIndexServiceExtensionHandlerDiffblueTest {
  /**
   * Method under test:
   * {@link AbstractSolrIndexServiceExtensionHandler#attachAdditionalBasicFields(Indexable, SolrInputDocument, SolrHelperService)}
   */
  @Test
  public void testAttachAdditionalBasicFields() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    I18nSolrIndexServiceExtensionHandler i18nSolrIndexServiceExtensionHandler = new I18nSolrIndexServiceExtensionHandler();
    ProductBundleImpl indexable = new ProductBundleImpl();

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        i18nSolrIndexServiceExtensionHandler.attachAdditionalBasicFields(indexable, null, new SolrHelperServiceImpl()));
  }

  /**
   * Method under test:
   * {@link AbstractSolrIndexServiceExtensionHandler#attachAdditionalBasicFields(Indexable, SolrInputDocument, SolrHelperService)}
   */
  @Test
  public void testAttachAdditionalBasicFields2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    I18nSolrIndexServiceExtensionHandler i18nSolrIndexServiceExtensionHandler = new I18nSolrIndexServiceExtensionHandler();
    ProductBundleImpl indexable = mock(ProductBundleImpl.class);

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        i18nSolrIndexServiceExtensionHandler.attachAdditionalBasicFields(indexable, null, new SolrHelperServiceImpl()));
  }

  /**
   * Method under test:
   * {@link AbstractSolrIndexServiceExtensionHandler#populateDocumentForIndexField(SolrInputDocument, IndexField, FieldType, Map)}
   */
  @Test
  public void testPopulateDocumentForIndexField() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    I18nSolrIndexServiceExtensionHandler i18nSolrIndexServiceExtensionHandler = new I18nSolrIndexServiceExtensionHandler();
    IndexFieldImpl field = new IndexFieldImpl();

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, i18nSolrIndexServiceExtensionHandler
        .populateDocumentForIndexField(null, field, FieldType.BOOLEAN, new HashMap<>()));
  }

  /**
   * Method under test:
   * {@link AbstractSolrIndexServiceExtensionHandler#populateDocumentForIndexField(SolrInputDocument, IndexField, FieldType, Map)}
   */
  @Test
  public void testPopulateDocumentForIndexField2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    I18nSolrIndexServiceExtensionHandler i18nSolrIndexServiceExtensionHandler = new I18nSolrIndexServiceExtensionHandler();
    SolrInputDocument document = mock(SolrInputDocument.class);
    IndexFieldImpl field = new IndexFieldImpl();

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, i18nSolrIndexServiceExtensionHandler
        .populateDocumentForIndexField(document, field, FieldType.BOOLEAN, new HashMap<>()));
  }

  /**
   * Method under test:
   * {@link AbstractSolrIndexServiceExtensionHandler#attachAdditionalDocumentFields(Indexable, SolrInputDocument)}
   */
  @Test
  public void testAttachAdditionalDocumentFields() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    I18nSolrIndexServiceExtensionHandler i18nSolrIndexServiceExtensionHandler = new I18nSolrIndexServiceExtensionHandler();

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        i18nSolrIndexServiceExtensionHandler.attachAdditionalDocumentFields(new ProductBundleImpl(), null));
  }

  /**
   * Method under test:
   * {@link AbstractSolrIndexServiceExtensionHandler#attachAdditionalDocumentFields(Indexable, SolrInputDocument)}
   */
  @Test
  public void testAttachAdditionalDocumentFields2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, (new I18nSolrIndexServiceExtensionHandler())
        .attachAdditionalDocumentFields(mock(ProductBundleImpl.class), null));
  }

  /**
   * Method under test:
   * {@link AbstractSolrIndexServiceExtensionHandler#attachChildDocuments(Indexable, SolrInputDocument, List, List)}
   */
  @Test
  public void testAttachChildDocuments() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    I18nSolrIndexServiceExtensionHandler i18nSolrIndexServiceExtensionHandler = new I18nSolrIndexServiceExtensionHandler();
    ProductBundleImpl indexable = new ProductBundleImpl();
    ArrayList<IndexField> fields = new ArrayList<>();

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        i18nSolrIndexServiceExtensionHandler.attachChildDocuments(indexable, null, fields, new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link AbstractSolrIndexServiceExtensionHandler#attachChildDocuments(Indexable, SolrInputDocument, List, List)}
   */
  @Test
  public void testAttachChildDocuments2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    I18nSolrIndexServiceExtensionHandler i18nSolrIndexServiceExtensionHandler = new I18nSolrIndexServiceExtensionHandler();
    ProductBundleImpl indexable = mock(ProductBundleImpl.class);
    ArrayList<IndexField> fields = new ArrayList<>();

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        i18nSolrIndexServiceExtensionHandler.attachChildDocuments(indexable, null, fields, new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link AbstractSolrIndexServiceExtensionHandler#attachChildDocuments(Indexable, SolrInputDocument, List, List)}
   */
  @Test
  public void testAttachChildDocuments3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
   * Method under test:
   * {@link AbstractSolrIndexServiceExtensionHandler#attachChildDocuments(Indexable, SolrInputDocument, List, List)}
   */
  @Test
  public void testAttachChildDocuments4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
   * Method under test:
   * {@link AbstractSolrIndexServiceExtensionHandler#attachChildDocuments(Indexable, SolrInputDocument, List, List)}
   */
  @Test
  public void testAttachChildDocuments5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
   * Method under test:
   * {@link AbstractSolrIndexServiceExtensionHandler#attachChildDocuments(Indexable, SolrInputDocument, List, List)}
   */
  @Test
  public void testAttachChildDocuments6() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
   * Method under test:
   * {@link AbstractSolrIndexServiceExtensionHandler#modifyBuiltDocuments(Collection, List, List, List)}
   */
  @Test
  public void testModifyBuiltDocuments() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
   * Method under test:
   * {@link AbstractSolrIndexServiceExtensionHandler#modifyBuiltDocuments(Collection, List, List, List)}
   */
  @Test
  public void testModifyBuiltDocuments2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
   * Method under test:
   * {@link AbstractSolrIndexServiceExtensionHandler#modifyBuiltDocuments(Collection, List, List, List)}
   */
  @Test
  public void testModifyBuiltDocuments3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
   * Method under test:
   * {@link AbstractSolrIndexServiceExtensionHandler#modifyBuiltDocuments(Collection, List, List, List)}
   */
  @Test
  public void testModifyBuiltDocuments4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
   * Method under test:
   * {@link AbstractSolrIndexServiceExtensionHandler#modifyBuiltDocuments(Collection, List, List, List)}
   */
  @Test
  public void testModifyBuiltDocuments5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
   * Method under test:
   * {@link AbstractSolrIndexServiceExtensionHandler#modifyBuiltDocuments(Collection, List, List, List)}
   */
  @Test
  public void testModifyBuiltDocuments6() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
   * Method under test:
   * {@link AbstractSolrIndexServiceExtensionHandler#modifyBuiltDocuments(Collection, List, List, List)}
   */
  @Test
  public void testModifyBuiltDocuments7() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
   * Method under test:
   * {@link AbstractSolrIndexServiceExtensionHandler#modifyBuiltDocuments(Collection, List, List, List)}
   */
  @Test
  public void testModifyBuiltDocuments8() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
   * Method under test:
   * {@link AbstractSolrIndexServiceExtensionHandler#modifyBuiltDocuments(Collection, List, List, List)}
   */
  @Test
  public void testModifyBuiltDocuments9() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
   * Method under test:
   * {@link AbstractSolrIndexServiceExtensionHandler#getIndexableId(Indexable, Long[])}
   */
  @Test
  public void testGetIndexableId() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    I18nSolrIndexServiceExtensionHandler i18nSolrIndexServiceExtensionHandler = new I18nSolrIndexServiceExtensionHandler();

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        i18nSolrIndexServiceExtensionHandler.getIndexableId(new ProductBundleImpl(), new Long[]{1L}));
  }

  /**
   * Method under test:
   * {@link AbstractSolrIndexServiceExtensionHandler#getIndexableId(Indexable, Long[])}
   */
  @Test
  public void testGetIndexableId2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        (new I18nSolrIndexServiceExtensionHandler()).getIndexableId(mock(ProductBundleImpl.class), new Long[]{1L}));
  }

  /**
   * Method under test:
   * {@link AbstractSolrIndexServiceExtensionHandler#getCategoryId(Long, Long[])}
   */
  @Test
  public void testGetCategoryId() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        (new I18nSolrIndexServiceExtensionHandler()).getCategoryId(1L, new Long[]{1L}));
  }

  /**
   * Method under test:
   * {@link AbstractSolrIndexServiceExtensionHandler#getCategoryId(Long, Long[])}
   */
  @Test
  public void testGetCategoryId2() throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    I18nSolrIndexServiceExtensionHandler i18nSolrIndexServiceExtensionHandler = new I18nSolrIndexServiceExtensionHandler();
    ProductBundleImpl indexable = mock(ProductBundleImpl.class);
    FieldImpl field = new FieldImpl();
    HashMap<String, Object> values = new HashMap<>();
    i18nSolrIndexServiceExtensionHandler.addPropertyValues(indexable, field, FieldType.BOOLEAN, values, "Property Name",
        new ArrayList<>());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        i18nSolrIndexServiceExtensionHandler.getCategoryId(1L, new Long[]{1L}));
  }
}
