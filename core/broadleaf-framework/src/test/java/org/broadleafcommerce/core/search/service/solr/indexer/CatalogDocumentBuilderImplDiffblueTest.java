package org.broadleafcommerce.core.search.service.solr.indexer;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.solr.common.SolrInputDocument;
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
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml",
    "/bl-framework-applicationContext-persistence.xml", "/bl-framework-applicationContext-workflow.xml",
    "/bl-framework-applicationContext.xml", "/blc-config/admin/framework/bl-framework-admin-applicationContext.xml",
    "/blc-config/site/framework/bl-framework-applicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class CatalogDocumentBuilderImplDiffblueTest {
  @Autowired
  private CatalogDocumentBuilderImpl catalogDocumentBuilderImpl;

  /**
   * Test {@link CatalogDocumentBuilderImpl#buildDocument(Indexable, List, List)}.
   * <p>
   * Method under test:
   * {@link CatalogDocumentBuilderImpl#buildDocument(Indexable, List, List)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testBuildDocument() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.search.service.solr.indexer;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2782 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.service.solr.indexer.CatalogDocumentBuilderImpl catalogDocumentBuilderImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    CatalogDocumentBuilderImpl catalogDocumentBuilderImpl2 = new CatalogDocumentBuilderImpl();
    ProductBundleImpl indexable = new ProductBundleImpl();
    ArrayList<IndexField> fields = new ArrayList<>();

    // Act
    catalogDocumentBuilderImpl2.buildDocument(indexable, fields, new ArrayList<>());
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
   * <p>
   * Method under test:
   * {@link CatalogDocumentBuilderImpl#attachIndexableDocumentFields(SolrInputDocument, Indexable, List, List)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testAttachIndexableDocumentFields2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.search.service.solr.indexer;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2752 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.service.solr.indexer.CatalogDocumentBuilderImpl catalogDocumentBuilderImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    CatalogDocumentBuilderImpl catalogDocumentBuilderImpl2 = new CatalogDocumentBuilderImpl();
    ProductBundleImpl indexable = new ProductBundleImpl();
    ArrayList<IndexField> fields = new ArrayList<>();

    // Act
    catalogDocumentBuilderImpl2.attachIndexableDocumentFields(null, indexable, fields, new ArrayList<>());
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
   * {@link CatalogDocumentBuilderImpl#attachAdditionalDocumentFields(Indexable, SolrInputDocument)}.
   * <p>
   * Method under test:
   * {@link CatalogDocumentBuilderImpl#attachAdditionalDocumentFields(Indexable, SolrInputDocument)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testAttachAdditionalDocumentFields() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.search.service.solr.indexer;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2692 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.service.solr.indexer.CatalogDocumentBuilderImpl catalogDocumentBuilderImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    CatalogDocumentBuilderImpl catalogDocumentBuilderImpl2 = new CatalogDocumentBuilderImpl();

    // Act
    catalogDocumentBuilderImpl2.attachAdditionalDocumentFields(new ProductBundleImpl(), null);
  }

  /**
   * Test
   * {@link CatalogDocumentBuilderImpl#attachBasicDocumentFields(Indexable, SolrInputDocument)}.
   * <p>
   * Method under test:
   * {@link CatalogDocumentBuilderImpl#attachBasicDocumentFields(Indexable, SolrInputDocument)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testAttachBasicDocumentFields() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.search.service.solr.indexer;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2722 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.service.solr.indexer.CatalogDocumentBuilderImpl catalogDocumentBuilderImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    CatalogDocumentBuilderImpl catalogDocumentBuilderImpl2 = new CatalogDocumentBuilderImpl();

    // Act
    catalogDocumentBuilderImpl2.attachBasicDocumentFields(new ProductBundleImpl(), null);
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
   * {@link CatalogDocumentBuilderImpl#buildFullCategoryHierarchy(SolrInputDocument, CatalogStructure, Long, Set)}.
   * <p>
   * Method under test:
   * {@link CatalogDocumentBuilderImpl#buildFullCategoryHierarchy(SolrInputDocument, CatalogStructure, Long, Set)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testBuildFullCategoryHierarchy() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.search.service.solr.indexer;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2812 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.service.solr.indexer.CatalogDocumentBuilderImpl catalogDocumentBuilderImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    CatalogDocumentBuilderImpl catalogDocumentBuilderImpl2 = new CatalogDocumentBuilderImpl();

    CatalogStructure cache = new CatalogStructure();
    cache.setDisplayOrdersByCategoryProduct(new HashMap<>());
    cache.setParentCategoriesByCategory(new HashMap<>());
    cache.setParentCategoriesByProduct(new HashMap<>());

    // Act
    catalogDocumentBuilderImpl2.buildFullCategoryHierarchy(null, cache, 1L, new HashSet<>());
  }

  /**
   * Test
   * {@link CatalogDocumentBuilderImpl#getPropertyValues(Indexable, Field, FieldType, List)}.
   * <p>
   * Method under test:
   * {@link CatalogDocumentBuilderImpl#getPropertyValues(Indexable, Field, FieldType, List)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetPropertyValues() throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.search.service.solr.indexer;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2872 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.service.solr.indexer.CatalogDocumentBuilderImpl catalogDocumentBuilderImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    CatalogDocumentBuilderImpl catalogDocumentBuilderImpl2 = new CatalogDocumentBuilderImpl();
    ProductBundleImpl indexedItem = new ProductBundleImpl();
    FieldImpl field = new FieldImpl();

    // Act
    catalogDocumentBuilderImpl2.getPropertyValues(indexedItem, field, FieldType.BOOLEAN, new ArrayList<>());
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
   * <p>
   * Method under test:
   * {@link CatalogDocumentBuilderImpl#convertDisplayOrderToLong(CatalogStructure, String)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testConvertDisplayOrderToLong2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.search.service.solr.indexer;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2842 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.service.solr.indexer.CatalogDocumentBuilderImpl catalogDocumentBuilderImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    CatalogDocumentBuilderImpl catalogDocumentBuilderImpl2 = new CatalogDocumentBuilderImpl();

    CatalogStructure cache = new CatalogStructure();
    cache.setDisplayOrdersByCategoryProduct(new HashMap<>());
    cache.setParentCategoriesByCategory(new HashMap<>());
    cache.setParentCategoriesByProduct(new HashMap<>());

    // Act
    catalogDocumentBuilderImpl2.convertDisplayOrderToLong(cache, "Display Order Key");
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

  /**
   * Test
   * {@link CatalogDocumentBuilderImpl#modifyDocument(Indexable, List, List)}.
   * <p>
   * Method under test:
   * {@link CatalogDocumentBuilderImpl#modifyDocument(Indexable, List, List)}
   */
  @Test
  public void testModifyDocument() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing observers.
    //   Diffblue Cover was unable to create an assertion.
    //   Add getters for the following fields or make them package-private:
    //     CatalogDocumentBuilderImpl.extensionManager
    //     CatalogDocumentBuilderImpl.sandBoxHelper
    //     CatalogDocumentBuilderImpl.shs
    //     CatalogDocumentBuilderImpl.solrConfiguration

    // Arrange
    CatalogDocumentBuilderImpl catalogDocumentBuilderImpl = new CatalogDocumentBuilderImpl();
    ProductBundleImpl indexable = new ProductBundleImpl();
    ArrayList<IndexField> fields = new ArrayList<>();

    // Act
    catalogDocumentBuilderImpl.modifyDocument(indexable, fields, new ArrayList<>());
  }
}
