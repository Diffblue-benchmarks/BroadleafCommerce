package org.broadleafcommerce.core.search.service.solr;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.LBHttp2SolrClient;
import org.apache.solr.client.solrj.response.GroupCommand;
import org.apache.solr.client.solrj.response.GroupResponse;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.broadleafcommerce.core.catalog.domain.Category;
import org.broadleafcommerce.core.catalog.domain.CategoryImpl;
import org.broadleafcommerce.core.catalog.domain.Indexable;
import org.broadleafcommerce.core.catalog.domain.ProductBundleImpl;
import org.broadleafcommerce.core.catalog.domain.SkuImpl;
import org.broadleafcommerce.core.search.domain.Field;
import org.broadleafcommerce.core.search.domain.FieldImpl;
import org.broadleafcommerce.core.search.domain.IndexField;
import org.broadleafcommerce.core.search.domain.IndexFieldImpl;
import org.broadleafcommerce.core.search.domain.SearchCriteria;
import org.broadleafcommerce.core.search.domain.SearchFacetDTO;
import org.broadleafcommerce.core.search.domain.SearchFacetRange;
import org.broadleafcommerce.core.search.domain.SearchFacetRangeImpl;
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
public class SolrHelperServiceImplDiffblueTest {
  @Autowired
  private SolrHelperServiceImpl solrHelperServiceImpl;

  /**
   * Test
   * {@link SolrHelperServiceImpl#getPropertyNameForIndexField(IndexField, FieldType, String)}
   * with {@code field}, {@code fieldType}, {@code prefix}.
   * <p>
   * Method under test:
   * {@link SolrHelperServiceImpl#getPropertyNameForIndexField(IndexField, FieldType, String)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetPropertyNameForIndexFieldWithFieldFieldTypePrefix() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.search.service.solr;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass20903 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.service.solr.SolrHelperServiceImpl solrHelperServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    SolrHelperServiceImpl solrHelperServiceImpl2 = new SolrHelperServiceImpl();

    // Act
    solrHelperServiceImpl2.getPropertyNameForIndexField(new IndexFieldImpl(), FieldType.BOOLEAN, "Prefix");
  }

  /**
   * Test
   * {@link SolrHelperServiceImpl#getPropertyNameForIndexField(IndexField, FieldType)}
   * with {@code field}, {@code searchableFieldType}.
   * <p>
   * Method under test:
   * {@link SolrHelperServiceImpl#getPropertyNameForIndexField(IndexField, FieldType)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetPropertyNameForIndexFieldWithFieldSearchableFieldType() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.search.service.solr;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass20874 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.service.solr.SolrHelperServiceImpl solrHelperServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    SolrHelperServiceImpl solrHelperServiceImpl2 = new SolrHelperServiceImpl();

    // Act
    solrHelperServiceImpl2.getPropertyNameForIndexField(new IndexFieldImpl(), FieldType.BOOLEAN);
  }

  /**
   * Test {@link SolrHelperServiceImpl#convertPrefixListToString(List)}.
   * <p>
   * Method under test:
   * {@link SolrHelperServiceImpl#convertPrefixListToString(List)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testConvertPrefixListToString() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.search.service.solr;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass20587 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.service.solr.SolrHelperServiceImpl solrHelperServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    SolrHelperServiceImpl solrHelperServiceImpl2 = new SolrHelperServiceImpl();

    // Act
    solrHelperServiceImpl2.convertPrefixListToString(new ArrayList<>());
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
   * Test {@link SolrHelperServiceImpl#getCategoryId(Category)} with
   * {@code Category}.
   * <p>
   * Method under test: {@link SolrHelperServiceImpl#getCategoryId(Category)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetCategoryIdWithCategory() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.search.service.solr;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass20657 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.service.solr.SolrHelperServiceImpl solrHelperServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    SolrHelperServiceImpl solrHelperServiceImpl2 = new SolrHelperServiceImpl();

    // Act
    solrHelperServiceImpl2.getCategoryId(new CategoryImpl());
  }

  /**
   * Test {@link SolrHelperServiceImpl#getCategoryId(Long)} with {@code Long}.
   * <p>
   * Method under test: {@link SolrHelperServiceImpl#getCategoryId(Long)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetCategoryIdWithLong() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.search.service.solr;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass20652 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.service.solr.SolrHelperServiceImpl solrHelperServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new SolrHelperServiceImpl()).getCategoryId(1L);
  }

  /**
   * Test {@link SolrHelperServiceImpl#getIndexableId(Indexable)}.
   * <p>
   * Method under test: {@link SolrHelperServiceImpl#getIndexableId(Indexable)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetIndexableId() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.search.service.solr;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass20794 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.service.solr.SolrHelperServiceImpl solrHelperServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    SolrHelperServiceImpl solrHelperServiceImpl2 = new SolrHelperServiceImpl();

    // Act
    solrHelperServiceImpl2.getIndexableId(new ProductBundleImpl());
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
   * Test {@link SolrHelperServiceImpl#getPrimaryDocumentType()}.
   * <p>
   * Method under test: {@link SolrHelperServiceImpl#getPrimaryDocumentType()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetPrimaryDocumentType2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.search.service.solr;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass20843 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.service.solr.SolrHelperServiceImpl solrHelperServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new SolrHelperServiceImpl()).getPrimaryDocumentType();
  }

  /**
   * Test {@link SolrHelperServiceImpl#getCurrentProductId(Indexable)}.
   * <p>
   * Method under test:
   * {@link SolrHelperServiceImpl#getCurrentProductId(Indexable)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetCurrentProductId() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.search.service.solr;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass20732 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.service.solr.SolrHelperServiceImpl solrHelperServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    SolrHelperServiceImpl solrHelperServiceImpl2 = new SolrHelperServiceImpl();

    // Act
    solrHelperServiceImpl2.getCurrentProductId(new ProductBundleImpl());
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
   * <p>
   * Method under test:
   * {@link SolrHelperServiceImpl#getProductForIndexable(Indexable)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetProductForIndexable() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.search.service.solr;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass20844 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.service.solr.SolrHelperServiceImpl solrHelperServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    SolrHelperServiceImpl solrHelperServiceImpl2 = new SolrHelperServiceImpl();

    // Act
    solrHelperServiceImpl2.getProductForIndexable(new ProductBundleImpl());
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
   * Test {@link SolrHelperServiceImpl#getDocumentType(Indexable)}.
   * <p>
   * Method under test: {@link SolrHelperServiceImpl#getDocumentType(Indexable)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetDocumentType() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.search.service.solr;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass20764 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.service.solr.SolrHelperServiceImpl solrHelperServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    SolrHelperServiceImpl solrHelperServiceImpl2 = new SolrHelperServiceImpl();

    // Act
    solrHelperServiceImpl2.getDocumentType(new ProductBundleImpl());
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
   * Test {@link SolrHelperServiceImpl#getCategorySortFieldName(Category)} with
   * {@code category}.
   * <p>
   * Method under test:
   * {@link SolrHelperServiceImpl#getCategorySortFieldName(Category)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetCategorySortFieldNameWithCategory() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.search.service.solr;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass20702 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.service.solr.SolrHelperServiceImpl solrHelperServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    SolrHelperServiceImpl solrHelperServiceImpl2 = new SolrHelperServiceImpl();

    // Act
    solrHelperServiceImpl2.getCategorySortFieldName(new CategoryImpl());
  }

  /**
   * Test {@link SolrHelperServiceImpl#getCategorySortFieldName(Long)} with
   * {@code categoryId}.
   * <p>
   * Method under test:
   * {@link SolrHelperServiceImpl#getCategorySortFieldName(Long)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetCategorySortFieldNameWithCategoryId() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.search.service.solr;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass20687 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.service.solr.SolrHelperServiceImpl solrHelperServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new SolrHelperServiceImpl()).getCategorySortFieldName(1L);
  }

  /**
   * Test {@link SolrHelperServiceImpl#getLocalePrefix()}.
   * <p>
   * Method under test: {@link SolrHelperServiceImpl#getLocalePrefix()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetLocalePrefix() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.search.service.solr;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass20824 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.service.solr.SolrHelperServiceImpl solrHelperServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new SolrHelperServiceImpl()).getLocalePrefix();
  }

  /**
   * Test {@link SolrHelperServiceImpl#getDefaultLocalePrefix()}.
   * <p>
   * Method under test: {@link SolrHelperServiceImpl#getDefaultLocalePrefix()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetDefaultLocalePrefix() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.search.service.solr;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass20763 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.service.solr.SolrHelperServiceImpl solrHelperServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new SolrHelperServiceImpl()).getDefaultLocalePrefix();
  }

  /**
   * Test {@link SolrHelperServiceImpl#getDefaultLocale()}.
   * <p>
   * Method under test: {@link SolrHelperServiceImpl#getDefaultLocale()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetDefaultLocale() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.search.service.solr;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass20762 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.service.solr.SolrHelperServiceImpl solrHelperServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new SolrHelperServiceImpl()).getDefaultLocale();
  }

  /**
   * Test {@link SolrHelperServiceImpl#getPropertyValue(Object, Field)} with
   * {@code object}, {@code field}.
   * <p>
   * Method under test:
   * {@link SolrHelperServiceImpl#getPropertyValue(Object, Field)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetPropertyValueWithObjectField()
      throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.search.service.solr;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass20963 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.service.solr.SolrHelperServiceImpl solrHelperServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    SolrHelperServiceImpl solrHelperServiceImpl2 = new SolrHelperServiceImpl();

    // Act
    solrHelperServiceImpl2.getPropertyValue("Object", new FieldImpl());
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
   * <p>
   * Method under test:
   * {@link SolrHelperServiceImpl#getPropertyValue(Object, String)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetPropertyValueWithObjectPropertyName()
      throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.search.service.solr;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass20933 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.service.solr.SolrHelperServiceImpl solrHelperServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new SolrHelperServiceImpl()).getPropertyValue("Object", "Property Name");
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
   * Test {@link SolrHelperServiceImpl#buildSearchFacetDTOs(List)}.
   * <p>
   * Method under test: {@link SolrHelperServiceImpl#buildSearchFacetDTOs(List)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testBuildSearchFacetDTOs() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.search.service.solr;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass20522 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.service.solr.SolrHelperServiceImpl solrHelperServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    SolrHelperServiceImpl solrHelperServiceImpl2 = new SolrHelperServiceImpl();

    // Act
    solrHelperServiceImpl2.buildSearchFacetDTOs(new ArrayList<>());
  }

  /**
   * Test {@link SolrHelperServiceImpl#buildSolrFacetField(String, String)}.
   * <p>
   * Method under test:
   * {@link SolrHelperServiceImpl#buildSolrFacetField(String, String)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testBuildSolrFacetField() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.search.service.solr;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass20527 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.service.solr.SolrHelperServiceImpl solrHelperServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new SolrHelperServiceImpl()).buildSolrFacetField("Field Name", "Param");
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
   * <p>
   * Method under test:
   * {@link SolrHelperServiceImpl#buildSolrFacetQuery(String, SearchFacetRange, Boolean, String)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testBuildSolrFacetQuery3() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.search.service.solr;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass20557 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.service.solr.SolrHelperServiceImpl solrHelperServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    SolrHelperServiceImpl solrHelperServiceImpl2 = new SolrHelperServiceImpl();

    // Act
    solrHelperServiceImpl2.buildSolrFacetQuery("Field Name", new SearchFacetRangeImpl(), true, "Param");
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
   * Test {@link SolrHelperServiceImpl#attachFacets(SolrQuery, Map)} with
   * {@code query}, {@code namedFacetMap}.
   * <p>
   * Method under test: {@link SolrHelperServiceImpl#attachFacets(SolrQuery, Map)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testAttachFacetsWithQueryNamedFacetMap() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.search.service.solr;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass20432 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.service.solr.SolrHelperServiceImpl solrHelperServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    SolrHelperServiceImpl solrHelperServiceImpl2 = new SolrHelperServiceImpl();
    SolrQuery query = new SolrQuery("foo");

    // Act
    solrHelperServiceImpl2.attachFacets(query, new HashMap<>());
  }

  /**
   * Test
   * {@link SolrHelperServiceImpl#attachFacets(SolrQuery, Map, SearchCriteria)}
   * with {@code query}, {@code namedFacetMap}, {@code searchCriteria}.
   * <p>
   * Method under test:
   * {@link SolrHelperServiceImpl#attachFacets(SolrQuery, Map, SearchCriteria)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testAttachFacetsWithQueryNamedFacetMapSearchCriteria() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.search.service.solr;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass20462 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.service.solr.SolrHelperServiceImpl solrHelperServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    SolrHelperServiceImpl solrHelperServiceImpl2 = new SolrHelperServiceImpl();
    SolrQuery query = new SolrQuery("foo");
    HashMap<String, SearchFacetDTO> namedFacetMap = new HashMap<>();

    // Act
    solrHelperServiceImpl2.attachFacets(query, namedFacetMap, new SearchCriteria());
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
   * <p>
   * Method under test:
   * {@link SolrHelperServiceImpl#getResponseDocuments(QueryResponse)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetResponseDocuments2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.search.service.solr;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass20995 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.service.solr.SolrHelperServiceImpl solrHelperServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    SolrHelperServiceImpl solrHelperServiceImpl2 = new SolrHelperServiceImpl();

    // Act
    solrHelperServiceImpl2.getResponseDocuments(new QueryResponse());
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
   * Test
   * {@link SolrHelperServiceImpl#attachSortClause(SolrQuery, SearchCriteria, String)}.
   * <p>
   * Method under test:
   * {@link SolrHelperServiceImpl#attachSortClause(SolrQuery, SearchCriteria, String)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testAttachSortClause() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.search.service.solr;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass20492 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.service.solr.SolrHelperServiceImpl solrHelperServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    SolrHelperServiceImpl solrHelperServiceImpl2 = new SolrHelperServiceImpl();
    SolrQuery query = new SolrQuery("foo");

    // Act
    solrHelperServiceImpl2.attachSortClause(query, new SearchCriteria(), "Default Sort");
  }

  /**
   * Test {@link SolrHelperServiceImpl#getNamedFacetMap(List, SearchCriteria)}.
   * <p>
   * Method under test:
   * {@link SolrHelperServiceImpl#getNamedFacetMap(List, SearchCriteria)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetNamedFacetMap() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.search.service.solr;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass20825 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.service.solr.SolrHelperServiceImpl solrHelperServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    SolrHelperServiceImpl solrHelperServiceImpl2 = new SolrHelperServiceImpl();
    ArrayList<SearchFacetDTO> facets = new ArrayList<>();

    // Act
    solrHelperServiceImpl2.getNamedFacetMap(facets, new SearchCriteria());
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
   * <p>
   * Method under test:
   * {@link SolrHelperServiceImpl#attachActiveFacetFilters(SolrQuery, Map, SearchCriteria)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testAttachActiveFacetFilters() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.search.service.solr;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass20402 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.service.solr.SolrHelperServiceImpl solrHelperServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    SolrHelperServiceImpl solrHelperServiceImpl2 = new SolrHelperServiceImpl();
    SolrQuery query = new SolrQuery("foo");
    HashMap<String, SearchFacetDTO> namedFacetMap = new HashMap<>();

    // Act
    solrHelperServiceImpl2.attachActiveFacetFilters(query, namedFacetMap, new SearchCriteria());
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
   * <p>
   * Method under test:
   * {@link SolrHelperServiceImpl#getPropertyValueInternal(Object, String[], int)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetPropertyValueInternal2()
      throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.search.service.solr;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass20965 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.service.solr.SolrHelperServiceImpl solrHelperServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new SolrHelperServiceImpl()).getPropertyValueInternal("Object", new String[]{"Components"}, 1);
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
   * <p>
   * Method under test:
   * {@link SolrHelperServiceImpl#copyPropertyToCollection(Collection, Object)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testCopyPropertyToCollection() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.search.service.solr;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass20592 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.service.solr.SolrHelperServiceImpl solrHelperServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    SolrHelperServiceImpl solrHelperServiceImpl2 = new SolrHelperServiceImpl();

    // Act
    solrHelperServiceImpl2.copyPropertyToCollection(new ArrayList<>(), "42");
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

  /**
   * Test {@link SolrHelperServiceImpl#getSearchableIndexFields()}.
   * <p>
   * Method under test: {@link SolrHelperServiceImpl#getSearchableIndexFields()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetSearchableIndexFields() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.search.service.solr;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass21003 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.service.solr.SolrHelperServiceImpl solrHelperServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new SolrHelperServiceImpl()).getSearchableIndexFields();
  }

  /**
   * Test
   * {@link SolrHelperServiceImpl#getCategoryFilterIds(Category, SearchCriteria)}.
   * <p>
   * Method under test:
   * {@link SolrHelperServiceImpl#getCategoryFilterIds(Category, SearchCriteria)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetCategoryFilterIds() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.search.service.solr;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass20622 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.service.solr.SolrHelperServiceImpl solrHelperServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    SolrHelperServiceImpl solrHelperServiceImpl2 = new SolrHelperServiceImpl();
    CategoryImpl category = new CategoryImpl();

    // Act
    solrHelperServiceImpl2.getCategoryFilterIds(category, new SearchCriteria());
  }
}
