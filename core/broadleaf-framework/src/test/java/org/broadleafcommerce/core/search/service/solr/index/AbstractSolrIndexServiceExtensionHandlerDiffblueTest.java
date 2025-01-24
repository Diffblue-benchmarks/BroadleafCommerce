package org.broadleafcommerce.core.search.service.solr.index;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
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
import org.broadleafcommerce.core.search.domain.Field;
import org.broadleafcommerce.core.search.domain.FieldImpl;
import org.broadleafcommerce.core.search.domain.IndexField;
import org.broadleafcommerce.core.search.domain.IndexFieldImpl;
import org.broadleafcommerce.core.search.domain.solr.FieldType;
import org.broadleafcommerce.core.search.service.solr.SolrHelperService;
import org.broadleafcommerce.core.search.service.solr.SolrHelperServiceImpl;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml",
    "/bl-framework-applicationContext-persistence.xml", "/bl-framework-applicationContext-workflow.xml",
    "/bl-framework-applicationContext.xml", "/blc-config/admin/framework/bl-framework-admin-applicationContext.xml",
    "/blc-config/site/framework/bl-framework-applicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class AbstractSolrIndexServiceExtensionHandlerDiffblueTest {
  @MockBean
  private AbstractSolrIndexServiceExtensionHandler abstractSolrIndexServiceExtensionHandler;

  /**
   * Test
   * {@link AbstractSolrIndexServiceExtensionHandler#addPropertyValues(Indexable, Field, FieldType, Map, String, List)}.
   * <ul>
   *   <li>Given {@link LocaleImpl} (default constructor).</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link LocaleImpl} (default
   * constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractSolrIndexServiceExtensionHandler#addPropertyValues(Indexable, Field, FieldType, Map, String, List)}
   */
  @Test
  public void testAddPropertyValues_givenLocaleImpl_whenArrayListAddLocaleImpl()
      throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
    // Arrange
    when(abstractSolrIndexServiceExtensionHandler.addPropertyValues(Mockito.<Indexable>any(), Mockito.<Field>any(),
        Mockito.<FieldType>any(), Mockito.<Map<String, Object>>any(), Mockito.<String>any(),
        Mockito.<List<Locale>>any())).thenReturn(ExtensionResultStatusType.HANDLED);
    ProductBundleImpl indexable = new ProductBundleImpl();
    FieldImpl field = new FieldImpl();
    HashMap<String, Object> values = new HashMap<>();

    ArrayList<Locale> locales = new ArrayList<>();
    locales.add(new LocaleImpl());

    // Act
    ExtensionResultStatusType actualAddPropertyValuesResult = abstractSolrIndexServiceExtensionHandler
        .addPropertyValues(indexable, field, FieldType.BOOLEAN, values, "Property Name", locales);

    // Assert
    verify(abstractSolrIndexServiceExtensionHandler).addPropertyValues(isA(Indexable.class), isA(Field.class),
        isA(FieldType.class), isA(Map.class), eq("Property Name"), isA(List.class));
    assertEquals(ExtensionResultStatusType.HANDLED, actualAddPropertyValuesResult);
  }

  /**
   * Test
   * {@link AbstractSolrIndexServiceExtensionHandler#addPropertyValues(Indexable, Field, FieldType, Map, String, List)}.
   * <ul>
   *   <li>Given {@link LocaleImpl} (default constructor).</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link LocaleImpl} (default
   * constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractSolrIndexServiceExtensionHandler#addPropertyValues(Indexable, Field, FieldType, Map, String, List)}
   */
  @Test
  public void testAddPropertyValues_givenLocaleImpl_whenArrayListAddLocaleImpl2()
      throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
    // Arrange
    when(abstractSolrIndexServiceExtensionHandler.addPropertyValues(Mockito.<Indexable>any(), Mockito.<Field>any(),
        Mockito.<FieldType>any(), Mockito.<Map<String, Object>>any(), Mockito.<String>any(),
        Mockito.<List<Locale>>any())).thenReturn(ExtensionResultStatusType.HANDLED);
    ProductBundleImpl indexable = new ProductBundleImpl();
    FieldImpl field = new FieldImpl();
    HashMap<String, Object> values = new HashMap<>();

    ArrayList<Locale> locales = new ArrayList<>();
    locales.add(new LocaleImpl());
    locales.add(new LocaleImpl());

    // Act
    ExtensionResultStatusType actualAddPropertyValuesResult = abstractSolrIndexServiceExtensionHandler
        .addPropertyValues(indexable, field, FieldType.BOOLEAN, values, "Property Name", locales);

    // Assert
    verify(abstractSolrIndexServiceExtensionHandler).addPropertyValues(isA(Indexable.class), isA(Field.class),
        isA(FieldType.class), isA(Map.class), eq("Property Name"), isA(List.class));
    assertEquals(ExtensionResultStatusType.HANDLED, actualAddPropertyValuesResult);
  }

  /**
   * Test
   * {@link AbstractSolrIndexServiceExtensionHandler#addPropertyValues(Indexable, Field, FieldType, Map, String, List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractSolrIndexServiceExtensionHandler#addPropertyValues(Indexable, Field, FieldType, Map, String, List)}
   */
  @Test
  public void testAddPropertyValues_whenArrayList()
      throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
    // Arrange
    when(abstractSolrIndexServiceExtensionHandler.addPropertyValues(Mockito.<Indexable>any(), Mockito.<Field>any(),
        Mockito.<FieldType>any(), Mockito.<Map<String, Object>>any(), Mockito.<String>any(),
        Mockito.<List<Locale>>any())).thenReturn(ExtensionResultStatusType.HANDLED);
    ProductBundleImpl indexable = new ProductBundleImpl();
    FieldImpl field = new FieldImpl();
    HashMap<String, Object> values = new HashMap<>();

    // Act
    ExtensionResultStatusType actualAddPropertyValuesResult = abstractSolrIndexServiceExtensionHandler
        .addPropertyValues(indexable, field, FieldType.BOOLEAN, values, "Property Name", new ArrayList<>());

    // Assert
    verify(abstractSolrIndexServiceExtensionHandler).addPropertyValues(isA(Indexable.class), isA(Field.class),
        isA(FieldType.class), isA(Map.class), eq("Property Name"), isA(List.class));
    assertEquals(ExtensionResultStatusType.HANDLED, actualAddPropertyValuesResult);
  }

  /**
   * Test
   * {@link AbstractSolrIndexServiceExtensionHandler#attachAdditionalBasicFields(Indexable, SolrInputDocument, SolrHelperService)}.
   * <p>
   * Method under test:
   * {@link AbstractSolrIndexServiceExtensionHandler#attachAdditionalBasicFields(Indexable, SolrInputDocument, SolrHelperService)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testAttachAdditionalBasicFields() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.search.service.solr.index;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass838 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.service.solr.index.AbstractSolrIndexServiceExtensionHandler abstractSolrIndexServiceExtensionHandler;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    I18nSolrIndexServiceExtensionHandler i18nSolrIndexServiceExtensionHandler = new I18nSolrIndexServiceExtensionHandler();
    ProductBundleImpl indexable = new ProductBundleImpl();

    // Act
    i18nSolrIndexServiceExtensionHandler.attachAdditionalBasicFields(indexable, null, new SolrHelperServiceImpl());
  }

  /**
   * Test
   * {@link AbstractSolrIndexServiceExtensionHandler#attachAdditionalBasicFields(Indexable, SolrInputDocument, SolrHelperService)}.
   * <ul>
   *   <li>When {@link ProductBundleImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractSolrIndexServiceExtensionHandler#attachAdditionalBasicFields(Indexable, SolrInputDocument, SolrHelperService)}
   */
  @Test
  public void testAttachAdditionalBasicFields_whenProductBundleImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    I18nSolrIndexServiceExtensionHandler i18nSolrIndexServiceExtensionHandler = new I18nSolrIndexServiceExtensionHandler();
    ProductBundleImpl indexable = new ProductBundleImpl();

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        i18nSolrIndexServiceExtensionHandler.attachAdditionalBasicFields(indexable, null, new SolrHelperServiceImpl()));
  }

  /**
   * Test
   * {@link AbstractSolrIndexServiceExtensionHandler#attachAdditionalBasicFields(Indexable, SolrInputDocument, SolrHelperService)}.
   * <ul>
   *   <li>When {@link ProductBundleImpl}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractSolrIndexServiceExtensionHandler#attachAdditionalBasicFields(Indexable, SolrInputDocument, SolrHelperService)}
   */
  @Test
  public void testAttachAdditionalBasicFields_whenProductBundleImpl2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    I18nSolrIndexServiceExtensionHandler i18nSolrIndexServiceExtensionHandler = new I18nSolrIndexServiceExtensionHandler();
    ProductBundleImpl indexable = mock(ProductBundleImpl.class);

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        i18nSolrIndexServiceExtensionHandler.attachAdditionalBasicFields(indexable, null, new SolrHelperServiceImpl()));
  }

  /**
   * Test
   * {@link AbstractSolrIndexServiceExtensionHandler#populateDocumentForIndexField(SolrInputDocument, IndexField, FieldType, Map)}.
   * <p>
   * Method under test:
   * {@link AbstractSolrIndexServiceExtensionHandler#populateDocumentForIndexField(SolrInputDocument, IndexField, FieldType, Map)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testPopulateDocumentForIndexField() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.search.service.solr.index;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass995 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.service.solr.index.AbstractSolrIndexServiceExtensionHandler abstractSolrIndexServiceExtensionHandler;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    I18nSolrIndexServiceExtensionHandler i18nSolrIndexServiceExtensionHandler = new I18nSolrIndexServiceExtensionHandler();
    IndexFieldImpl field = new IndexFieldImpl();

    // Act
    i18nSolrIndexServiceExtensionHandler.populateDocumentForIndexField(null, field, FieldType.BOOLEAN, new HashMap<>());
  }

  /**
   * Test
   * {@link AbstractSolrIndexServiceExtensionHandler#populateDocumentForIndexField(SolrInputDocument, IndexField, FieldType, Map)}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractSolrIndexServiceExtensionHandler#populateDocumentForIndexField(SolrInputDocument, IndexField, FieldType, Map)}
   */
  @Test
  public void testPopulateDocumentForIndexField_whenNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    I18nSolrIndexServiceExtensionHandler i18nSolrIndexServiceExtensionHandler = new I18nSolrIndexServiceExtensionHandler();
    IndexFieldImpl field = new IndexFieldImpl();

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, i18nSolrIndexServiceExtensionHandler
        .populateDocumentForIndexField(null, field, FieldType.BOOLEAN, new HashMap<>()));
  }

  /**
   * Test
   * {@link AbstractSolrIndexServiceExtensionHandler#populateDocumentForIndexField(SolrInputDocument, IndexField, FieldType, Map)}.
   * <ul>
   *   <li>When {@link SolrInputDocument}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractSolrIndexServiceExtensionHandler#populateDocumentForIndexField(SolrInputDocument, IndexField, FieldType, Map)}
   */
  @Test
  public void testPopulateDocumentForIndexField_whenSolrInputDocument() {
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
   * Test
   * {@link AbstractSolrIndexServiceExtensionHandler#attachAdditionalDocumentFields(Indexable, SolrInputDocument)}.
   * <p>
   * Method under test:
   * {@link AbstractSolrIndexServiceExtensionHandler#attachAdditionalDocumentFields(Indexable, SolrInputDocument)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testAttachAdditionalDocumentFields() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.search.service.solr.index;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass868 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.service.solr.index.AbstractSolrIndexServiceExtensionHandler abstractSolrIndexServiceExtensionHandler;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    I18nSolrIndexServiceExtensionHandler i18nSolrIndexServiceExtensionHandler = new I18nSolrIndexServiceExtensionHandler();

    // Act
    i18nSolrIndexServiceExtensionHandler.attachAdditionalDocumentFields(new ProductBundleImpl(), null);
  }

  /**
   * Test
   * {@link AbstractSolrIndexServiceExtensionHandler#attachAdditionalDocumentFields(Indexable, SolrInputDocument)}.
   * <ul>
   *   <li>When {@link ProductBundleImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractSolrIndexServiceExtensionHandler#attachAdditionalDocumentFields(Indexable, SolrInputDocument)}
   */
  @Test
  public void testAttachAdditionalDocumentFields_whenProductBundleImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    I18nSolrIndexServiceExtensionHandler i18nSolrIndexServiceExtensionHandler = new I18nSolrIndexServiceExtensionHandler();

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        i18nSolrIndexServiceExtensionHandler.attachAdditionalDocumentFields(new ProductBundleImpl(), null));
  }

  /**
   * Test
   * {@link AbstractSolrIndexServiceExtensionHandler#attachAdditionalDocumentFields(Indexable, SolrInputDocument)}.
   * <ul>
   *   <li>When {@link ProductBundleImpl}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractSolrIndexServiceExtensionHandler#attachAdditionalDocumentFields(Indexable, SolrInputDocument)}
   */
  @Test
  public void testAttachAdditionalDocumentFields_whenProductBundleImpl2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, (new I18nSolrIndexServiceExtensionHandler())
        .attachAdditionalDocumentFields(mock(ProductBundleImpl.class), null));
  }

  /**
   * Test
   * {@link AbstractSolrIndexServiceExtensionHandler#attachChildDocuments(Indexable, SolrInputDocument, List, List)}.
   * <p>
   * Method under test:
   * {@link AbstractSolrIndexServiceExtensionHandler#attachChildDocuments(Indexable, SolrInputDocument, List, List)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testAttachChildDocuments() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.search.service.solr.index;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass898 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.service.solr.index.AbstractSolrIndexServiceExtensionHandler abstractSolrIndexServiceExtensionHandler;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    I18nSolrIndexServiceExtensionHandler i18nSolrIndexServiceExtensionHandler = new I18nSolrIndexServiceExtensionHandler();
    ProductBundleImpl indexable = new ProductBundleImpl();
    ArrayList<IndexField> fields = new ArrayList<>();

    // Act
    i18nSolrIndexServiceExtensionHandler.attachChildDocuments(indexable, null, fields, new ArrayList<>());
  }

  /**
   * Test
   * {@link AbstractSolrIndexServiceExtensionHandler#attachChildDocuments(Indexable, SolrInputDocument, List, List)}.
   * <ul>
   *   <li>Given {@link IndexFieldImpl} (default constructor).</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link IndexFieldImpl} (default
   * constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractSolrIndexServiceExtensionHandler#attachChildDocuments(Indexable, SolrInputDocument, List, List)}
   */
  @Test
  public void testAttachChildDocuments_givenIndexFieldImpl_whenArrayListAddIndexFieldImpl() {
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
   * Test
   * {@link AbstractSolrIndexServiceExtensionHandler#attachChildDocuments(Indexable, SolrInputDocument, List, List)}.
   * <ul>
   *   <li>Given {@link IndexFieldImpl} (default constructor).</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link IndexFieldImpl} (default
   * constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractSolrIndexServiceExtensionHandler#attachChildDocuments(Indexable, SolrInputDocument, List, List)}
   */
  @Test
  public void testAttachChildDocuments_givenIndexFieldImpl_whenArrayListAddIndexFieldImpl2() {
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
   * Test
   * {@link AbstractSolrIndexServiceExtensionHandler#attachChildDocuments(Indexable, SolrInputDocument, List, List)}.
   * <ul>
   *   <li>Given {@link LocaleImpl} (default constructor).</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link LocaleImpl} (default
   * constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractSolrIndexServiceExtensionHandler#attachChildDocuments(Indexable, SolrInputDocument, List, List)}
   */
  @Test
  public void testAttachChildDocuments_givenLocaleImpl_whenArrayListAddLocaleImpl() {
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
   * Test
   * {@link AbstractSolrIndexServiceExtensionHandler#attachChildDocuments(Indexable, SolrInputDocument, List, List)}.
   * <ul>
   *   <li>Given {@link LocaleImpl} (default constructor).</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link LocaleImpl} (default
   * constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractSolrIndexServiceExtensionHandler#attachChildDocuments(Indexable, SolrInputDocument, List, List)}
   */
  @Test
  public void testAttachChildDocuments_givenLocaleImpl_whenArrayListAddLocaleImpl2() {
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
   * Test
   * {@link AbstractSolrIndexServiceExtensionHandler#attachChildDocuments(Indexable, SolrInputDocument, List, List)}.
   * <ul>
   *   <li>When {@link ProductBundleImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractSolrIndexServiceExtensionHandler#attachChildDocuments(Indexable, SolrInputDocument, List, List)}
   */
  @Test
  public void testAttachChildDocuments_whenProductBundleImpl() {
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
   * Test
   * {@link AbstractSolrIndexServiceExtensionHandler#attachChildDocuments(Indexable, SolrInputDocument, List, List)}.
   * <ul>
   *   <li>When {@link ProductBundleImpl}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractSolrIndexServiceExtensionHandler#attachChildDocuments(Indexable, SolrInputDocument, List, List)}
   */
  @Test
  public void testAttachChildDocuments_whenProductBundleImpl2() {
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
   * Test
   * {@link AbstractSolrIndexServiceExtensionHandler#modifyBuiltDocuments(Collection, List, List, List)}.
   * <p>
   * Method under test:
   * {@link AbstractSolrIndexServiceExtensionHandler#modifyBuiltDocuments(Collection, List, List, List)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testModifyBuiltDocuments() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.search.service.solr.index;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass974 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.service.solr.index.AbstractSolrIndexServiceExtensionHandler abstractSolrIndexServiceExtensionHandler;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    I18nSolrIndexServiceExtensionHandler i18nSolrIndexServiceExtensionHandler = new I18nSolrIndexServiceExtensionHandler();
    ArrayList<SolrInputDocument> documents = new ArrayList<>();
    ArrayList<Indexable> products = new ArrayList<>();
    ArrayList<IndexField> fields = new ArrayList<>();

    // Act
    i18nSolrIndexServiceExtensionHandler.modifyBuiltDocuments(documents, products, fields, new ArrayList<>());
  }

  /**
   * Test
   * {@link AbstractSolrIndexServiceExtensionHandler#modifyBuiltDocuments(Collection, List, List, List)}.
   * <ul>
   *   <li>Given {@link IndexFieldImpl} (default constructor).</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link IndexFieldImpl} (default
   * constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractSolrIndexServiceExtensionHandler#modifyBuiltDocuments(Collection, List, List, List)}
   */
  @Test
  public void testModifyBuiltDocuments_givenIndexFieldImpl_whenArrayListAddIndexFieldImpl() {
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
   * Test
   * {@link AbstractSolrIndexServiceExtensionHandler#modifyBuiltDocuments(Collection, List, List, List)}.
   * <ul>
   *   <li>Given {@link IndexFieldImpl} (default constructor).</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link IndexFieldImpl} (default
   * constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractSolrIndexServiceExtensionHandler#modifyBuiltDocuments(Collection, List, List, List)}
   */
  @Test
  public void testModifyBuiltDocuments_givenIndexFieldImpl_whenArrayListAddIndexFieldImpl2() {
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
   * Test
   * {@link AbstractSolrIndexServiceExtensionHandler#modifyBuiltDocuments(Collection, List, List, List)}.
   * <ul>
   *   <li>Given {@link LocaleImpl} (default constructor).</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link LocaleImpl} (default
   * constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractSolrIndexServiceExtensionHandler#modifyBuiltDocuments(Collection, List, List, List)}
   */
  @Test
  public void testModifyBuiltDocuments_givenLocaleImpl_whenArrayListAddLocaleImpl() {
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
   * Test
   * {@link AbstractSolrIndexServiceExtensionHandler#modifyBuiltDocuments(Collection, List, List, List)}.
   * <ul>
   *   <li>Given {@link LocaleImpl} (default constructor).</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link LocaleImpl} (default
   * constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractSolrIndexServiceExtensionHandler#modifyBuiltDocuments(Collection, List, List, List)}
   */
  @Test
  public void testModifyBuiltDocuments_givenLocaleImpl_whenArrayListAddLocaleImpl2() {
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
   * Test
   * {@link AbstractSolrIndexServiceExtensionHandler#modifyBuiltDocuments(Collection, List, List, List)}.
   * <ul>
   *   <li>Given {@link ProductBundleImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractSolrIndexServiceExtensionHandler#modifyBuiltDocuments(Collection, List, List, List)}
   */
  @Test
  public void testModifyBuiltDocuments_givenProductBundleImpl() {
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
   * Test
   * {@link AbstractSolrIndexServiceExtensionHandler#modifyBuiltDocuments(Collection, List, List, List)}.
   * <ul>
   *   <li>Given {@link ProductBundleImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractSolrIndexServiceExtensionHandler#modifyBuiltDocuments(Collection, List, List, List)}
   */
  @Test
  public void testModifyBuiltDocuments_givenProductBundleImpl2() {
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
   * Test
   * {@link AbstractSolrIndexServiceExtensionHandler#modifyBuiltDocuments(Collection, List, List, List)}.
   * <ul>
   *   <li>Given {@link SolrInputDocument}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractSolrIndexServiceExtensionHandler#modifyBuiltDocuments(Collection, List, List, List)}
   */
  @Test
  public void testModifyBuiltDocuments_givenSolrInputDocument() {
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
   * Test
   * {@link AbstractSolrIndexServiceExtensionHandler#modifyBuiltDocuments(Collection, List, List, List)}.
   * <ul>
   *   <li>Given {@link SolrInputDocument}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractSolrIndexServiceExtensionHandler#modifyBuiltDocuments(Collection, List, List, List)}
   */
  @Test
  public void testModifyBuiltDocuments_givenSolrInputDocument2() {
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
   * Test
   * {@link AbstractSolrIndexServiceExtensionHandler#modifyBuiltDocuments(Collection, List, List, List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractSolrIndexServiceExtensionHandler#modifyBuiltDocuments(Collection, List, List, List)}
   */
  @Test
  public void testModifyBuiltDocuments_whenArrayList() {
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
   * Test {@link AbstractSolrIndexServiceExtensionHandler#startBatchEvent(List)}.
   * <ul>
   *   <li>Given {@link ProductBundleImpl} (default constructor).</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link ProductBundleImpl} (default
   * constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractSolrIndexServiceExtensionHandler#startBatchEvent(List)}
   */
  @Test
  public void testStartBatchEvent_givenProductBundleImpl_whenArrayListAddProductBundleImpl() {
    // Arrange
    when(abstractSolrIndexServiceExtensionHandler.startBatchEvent(Mockito.<List<Indexable>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);

    ArrayList<Indexable> products = new ArrayList<>();
    products.add(new ProductBundleImpl());

    // Act
    ExtensionResultStatusType actualStartBatchEventResult = abstractSolrIndexServiceExtensionHandler
        .startBatchEvent(products);

    // Assert
    verify(abstractSolrIndexServiceExtensionHandler).startBatchEvent(isA(List.class));
    assertEquals(ExtensionResultStatusType.HANDLED, actualStartBatchEventResult);
  }

  /**
   * Test {@link AbstractSolrIndexServiceExtensionHandler#startBatchEvent(List)}.
   * <ul>
   *   <li>Given {@link ProductBundleImpl} (default constructor).</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link ProductBundleImpl} (default
   * constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractSolrIndexServiceExtensionHandler#startBatchEvent(List)}
   */
  @Test
  public void testStartBatchEvent_givenProductBundleImpl_whenArrayListAddProductBundleImpl2() {
    // Arrange
    when(abstractSolrIndexServiceExtensionHandler.startBatchEvent(Mockito.<List<Indexable>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);

    ArrayList<Indexable> products = new ArrayList<>();
    products.add(new ProductBundleImpl());
    products.add(new ProductBundleImpl());

    // Act
    ExtensionResultStatusType actualStartBatchEventResult = abstractSolrIndexServiceExtensionHandler
        .startBatchEvent(products);

    // Assert
    verify(abstractSolrIndexServiceExtensionHandler).startBatchEvent(isA(List.class));
    assertEquals(ExtensionResultStatusType.HANDLED, actualStartBatchEventResult);
  }

  /**
   * Test {@link AbstractSolrIndexServiceExtensionHandler#startBatchEvent(List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractSolrIndexServiceExtensionHandler#startBatchEvent(List)}
   */
  @Test
  public void testStartBatchEvent_whenArrayList() {
    // Arrange
    when(abstractSolrIndexServiceExtensionHandler.startBatchEvent(Mockito.<List<Indexable>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);

    // Act
    ExtensionResultStatusType actualStartBatchEventResult = abstractSolrIndexServiceExtensionHandler
        .startBatchEvent(new ArrayList<>());

    // Assert
    verify(abstractSolrIndexServiceExtensionHandler).startBatchEvent(isA(List.class));
    assertEquals(ExtensionResultStatusType.HANDLED, actualStartBatchEventResult);
  }

  /**
   * Test {@link AbstractSolrIndexServiceExtensionHandler#endBatchEvent(List)}.
   * <ul>
   *   <li>Given {@link ProductBundleImpl} (default constructor).</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link ProductBundleImpl} (default
   * constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractSolrIndexServiceExtensionHandler#endBatchEvent(List)}
   */
  @Test
  public void testEndBatchEvent_givenProductBundleImpl_whenArrayListAddProductBundleImpl() {
    // Arrange
    when(abstractSolrIndexServiceExtensionHandler.endBatchEvent(Mockito.<List<Indexable>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);

    ArrayList<Indexable> products = new ArrayList<>();
    products.add(new ProductBundleImpl());

    // Act
    ExtensionResultStatusType actualEndBatchEventResult = abstractSolrIndexServiceExtensionHandler
        .endBatchEvent(products);

    // Assert
    verify(abstractSolrIndexServiceExtensionHandler).endBatchEvent(isA(List.class));
    assertEquals(ExtensionResultStatusType.HANDLED, actualEndBatchEventResult);
  }

  /**
   * Test {@link AbstractSolrIndexServiceExtensionHandler#endBatchEvent(List)}.
   * <ul>
   *   <li>Given {@link ProductBundleImpl} (default constructor).</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link ProductBundleImpl} (default
   * constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractSolrIndexServiceExtensionHandler#endBatchEvent(List)}
   */
  @Test
  public void testEndBatchEvent_givenProductBundleImpl_whenArrayListAddProductBundleImpl2() {
    // Arrange
    when(abstractSolrIndexServiceExtensionHandler.endBatchEvent(Mockito.<List<Indexable>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);

    ArrayList<Indexable> products = new ArrayList<>();
    products.add(new ProductBundleImpl());
    products.add(new ProductBundleImpl());

    // Act
    ExtensionResultStatusType actualEndBatchEventResult = abstractSolrIndexServiceExtensionHandler
        .endBatchEvent(products);

    // Assert
    verify(abstractSolrIndexServiceExtensionHandler).endBatchEvent(isA(List.class));
    assertEquals(ExtensionResultStatusType.HANDLED, actualEndBatchEventResult);
  }

  /**
   * Test {@link AbstractSolrIndexServiceExtensionHandler#endBatchEvent(List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractSolrIndexServiceExtensionHandler#endBatchEvent(List)}
   */
  @Test
  public void testEndBatchEvent_whenArrayList() {
    // Arrange
    when(abstractSolrIndexServiceExtensionHandler.endBatchEvent(Mockito.<List<Indexable>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);

    // Act
    ExtensionResultStatusType actualEndBatchEventResult = abstractSolrIndexServiceExtensionHandler
        .endBatchEvent(new ArrayList<>());

    // Assert
    verify(abstractSolrIndexServiceExtensionHandler).endBatchEvent(isA(List.class));
    assertEquals(ExtensionResultStatusType.HANDLED, actualEndBatchEventResult);
  }

  /**
   * Test
   * {@link AbstractSolrIndexServiceExtensionHandler#getIndexableId(Indexable, Long[])}.
   * <p>
   * Method under test:
   * {@link AbstractSolrIndexServiceExtensionHandler#getIndexableId(Indexable, Long[])}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetIndexableId() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.search.service.solr.index;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass944 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.service.solr.index.AbstractSolrIndexServiceExtensionHandler abstractSolrIndexServiceExtensionHandler;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    I18nSolrIndexServiceExtensionHandler i18nSolrIndexServiceExtensionHandler = new I18nSolrIndexServiceExtensionHandler();

    // Act
    i18nSolrIndexServiceExtensionHandler.getIndexableId(new ProductBundleImpl(), new Long[]{1L});
  }

  /**
   * Test
   * {@link AbstractSolrIndexServiceExtensionHandler#getIndexableId(Indexable, Long[])}.
   * <ul>
   *   <li>When {@link ProductBundleImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractSolrIndexServiceExtensionHandler#getIndexableId(Indexable, Long[])}
   */
  @Test
  public void testGetIndexableId_whenProductBundleImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    I18nSolrIndexServiceExtensionHandler i18nSolrIndexServiceExtensionHandler = new I18nSolrIndexServiceExtensionHandler();

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        i18nSolrIndexServiceExtensionHandler.getIndexableId(new ProductBundleImpl(), new Long[]{1L}));
  }

  /**
   * Test
   * {@link AbstractSolrIndexServiceExtensionHandler#getIndexableId(Indexable, Long[])}.
   * <ul>
   *   <li>When {@link ProductBundleImpl}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractSolrIndexServiceExtensionHandler#getIndexableId(Indexable, Long[])}
   */
  @Test
  public void testGetIndexableId_whenProductBundleImpl2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        (new I18nSolrIndexServiceExtensionHandler()).getIndexableId(mock(ProductBundleImpl.class), new Long[]{1L}));
  }

  /**
   * Test
   * {@link AbstractSolrIndexServiceExtensionHandler#getCategoryId(Long, Long[])}.
   * <p>
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
   * Test
   * {@link AbstractSolrIndexServiceExtensionHandler#getCategoryId(Long, Long[])}.
   * <p>
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

  /**
   * Test
   * {@link AbstractSolrIndexServiceExtensionHandler#getCategoryId(Long, Long[])}.
   * <p>
   * Method under test:
   * {@link AbstractSolrIndexServiceExtensionHandler#getCategoryId(Long, Long[])}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetCategoryId3() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.search.service.solr.index;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass928 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.service.solr.index.AbstractSolrIndexServiceExtensionHandler abstractSolrIndexServiceExtensionHandler;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new I18nSolrIndexServiceExtensionHandler()).getCategoryId(1L, new Long[]{1L});
  }
}
