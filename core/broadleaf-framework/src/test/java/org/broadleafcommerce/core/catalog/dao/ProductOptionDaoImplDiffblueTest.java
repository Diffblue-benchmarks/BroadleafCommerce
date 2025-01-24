package org.broadleafcommerce.core.catalog.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Path;
import org.broadleafcommerce.core.catalog.domain.Product;
import org.broadleafcommerce.core.catalog.domain.ProductBundleImpl;
import org.broadleafcommerce.core.catalog.domain.ProductOption;
import org.broadleafcommerce.core.catalog.domain.ProductOptionImpl;
import org.broadleafcommerce.core.catalog.domain.Sku;
import org.broadleafcommerce.core.catalog.domain.SkuImpl;
import org.broadleafcommerce.core.order.domain.OrderItemAttribute;
import org.broadleafcommerce.core.order.domain.OrderItemAttributeImpl;
import org.hibernate.boot.internal.BootstrapContextImpl;
import org.hibernate.boot.internal.InFlightMetadataCollectorImpl;
import org.hibernate.boot.internal.MetadataBuilderImpl;
import org.hibernate.boot.spi.AbstractDelegatingSessionFactoryOptions;
import org.hibernate.engine.query.spi.QueryPlanCache;
import org.hibernate.internal.SessionFactoryImpl;
import org.hibernate.query.criteria.internal.CriteriaBuilderImpl;
import org.hibernate.query.criteria.internal.path.CollectionAttributeJoin;
import org.hibernate.query.criteria.internal.path.ListAttributeJoin;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml",
    "/bl-framework-applicationContext-persistence.xml", "/bl-framework-applicationContext-workflow.xml",
    "/bl-framework-applicationContext.xml", "/blc-config/admin/framework/bl-framework-admin-applicationContext.xml",
    "/blc-config/site/framework/bl-framework-applicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class ProductOptionDaoImplDiffblueTest {
  @Autowired
  private ProductOptionDaoImpl productOptionDaoImpl;

  /**
   * Test {@link ProductOptionDaoImpl#readAllProductOptions()}.
   * <p>
   * Method under test: {@link ProductOptionDaoImpl#readAllProductOptions()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testReadAllProductOptions() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.catalog.dao;
    //   @org.springframework.transaction.annotation.Transactional
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2351 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.catalog.dao.ProductOptionDaoImpl productOptionDaoImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new ProductOptionDaoImpl()).readAllProductOptions();
  }

  /**
   * Test {@link ProductOptionDaoImpl#saveProductOption(ProductOption)}.
   * <p>
   * Method under test:
   * {@link ProductOptionDaoImpl#saveProductOption(ProductOption)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testSaveProductOption() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.catalog.dao;
    //   @org.springframework.transaction.annotation.Transactional
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2412 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.catalog.dao.ProductOptionDaoImpl productOptionDaoImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    ProductOptionDaoImpl productOptionDaoImpl2 = new ProductOptionDaoImpl();

    // Act
    productOptionDaoImpl2.saveProductOption(new ProductOptionImpl());
  }

  /**
   * Test {@link ProductOptionDaoImpl#readProductOptionById(Long)}.
   * <p>
   * Method under test: {@link ProductOptionDaoImpl#readProductOptionById(Long)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testReadProductOptionById() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.catalog.dao;
    //   @org.springframework.transaction.annotation.Transactional
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2352 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.catalog.dao.ProductOptionDaoImpl productOptionDaoImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new ProductOptionDaoImpl()).readProductOptionById(1L);
  }

  /**
   * Test {@link ProductOptionDaoImpl#readProductOptionValueById(Long)}.
   * <p>
   * Method under test:
   * {@link ProductOptionDaoImpl#readProductOptionValueById(Long)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testReadProductOptionValueById() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.catalog.dao;
    //   @org.springframework.transaction.annotation.Transactional
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2367 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.catalog.dao.ProductOptionDaoImpl productOptionDaoImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new ProductOptionDaoImpl()).readProductOptionValueById(1L);
  }

  /**
   * Test
   * {@link ProductOptionDaoImpl#findAssignedProductOptionsByProductId(Long)}.
   * <p>
   * Method under test:
   * {@link ProductOptionDaoImpl#findAssignedProductOptionsByProductId(Long)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testFindAssignedProductOptionsByProductId() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.catalog.dao;
    //   @org.springframework.transaction.annotation.Transactional
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2308 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.catalog.dao.ProductOptionDaoImpl productOptionDaoImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new ProductOptionDaoImpl()).findAssignedProductOptionsByProductId(1L);
  }

  /**
   * Test
   * {@link ProductOptionDaoImpl#findAssignedProductOptionsByProduct(Product)}.
   * <p>
   * Method under test:
   * {@link ProductOptionDaoImpl#findAssignedProductOptionsByProduct(Product)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testFindAssignedProductOptionsByProduct() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.catalog.dao;
    //   @org.springframework.transaction.annotation.Transactional
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2278 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.catalog.dao.ProductOptionDaoImpl productOptionDaoImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    ProductOptionDaoImpl productOptionDaoImpl2 = new ProductOptionDaoImpl();

    // Act
    productOptionDaoImpl2.findAssignedProductOptionsByProduct(new ProductBundleImpl());
  }

  /**
   * Test
   * {@link ProductOptionDaoImpl#countAllowedValuesForProductOptionById(Long)}.
   * <p>
   * Method under test:
   * {@link ProductOptionDaoImpl#countAllowedValuesForProductOptionById(Long)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testCountAllowedValuesForProductOptionById() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.catalog.dao;
    //   @org.springframework.transaction.annotation.Transactional
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2243 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.catalog.dao.ProductOptionDaoImpl productOptionDaoImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new ProductOptionDaoImpl()).countAllowedValuesForProductOptionById(1L);
  }

  /**
   * Test
   * {@link ProductOptionDaoImpl#readSkuIdsForProductOptionValues(Long, String, String, List)}.
   * <p>
   * Method under test:
   * {@link ProductOptionDaoImpl#readSkuIdsForProductOptionValues(Long, String, String, List)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testReadSkuIdsForProductOptionValues() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.catalog.dao;
    //   @org.springframework.transaction.annotation.Transactional
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2382 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.catalog.dao.ProductOptionDaoImpl productOptionDaoImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    ProductOptionDaoImpl productOptionDaoImpl2 = new ProductOptionDaoImpl();

    // Act
    productOptionDaoImpl2.readSkuIdsForProductOptionValues(1L, "Attribute Name", "42", new ArrayList<>());
  }

  /**
   * Test {@link ProductOptionDaoImpl#filterCandidateSkusForArchivedStatus(List)}.
   * <p>
   * Method under test:
   * {@link ProductOptionDaoImpl#filterCandidateSkusForArchivedStatus(List)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testFilterCandidateSkusForArchivedStatus() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.catalog.dao;
    //   @org.springframework.transaction.annotation.Transactional
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2273 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.catalog.dao.ProductOptionDaoImpl productOptionDaoImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    ProductOptionDaoImpl productOptionDaoImpl2 = new ProductOptionDaoImpl();

    // Act
    productOptionDaoImpl2.filterCandidateSkusForArchivedStatus(new ArrayList<>());
  }

  /**
   * Test {@link ProductOptionDaoImpl#filterCandidateSkusForArchivedStatus(List)}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor).</li>
   *   <li>Then return first is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ProductOptionDaoImpl#filterCandidateSkusForArchivedStatus(List)}
   */
  @Test
  public void testFilterCandidateSkusForArchivedStatus_givenSkuImpl_thenReturnFirstIsNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductOptionDaoImpl productOptionDaoImpl = new ProductOptionDaoImpl();

    ArrayList<Sku> candidateSkus = new ArrayList<>();
    candidateSkus.add(new SkuImpl());

    // Act
    List<Long> actualFilterCandidateSkusForArchivedStatusResult = productOptionDaoImpl
        .filterCandidateSkusForArchivedStatus(candidateSkus);

    // Assert
    assertEquals(1, actualFilterCandidateSkusForArchivedStatusResult.size());
    assertNull(actualFilterCandidateSkusForArchivedStatusResult.get(0));
  }

  /**
   * Test {@link ProductOptionDaoImpl#filterCandidateSkusForArchivedStatus(List)}.
   * <ul>
   *   <li>Then return first longValue is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ProductOptionDaoImpl#filterCandidateSkusForArchivedStatus(List)}
   */
  @Test
  public void testFilterCandidateSkusForArchivedStatus_thenReturnFirstLongValueIsOne() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductOptionDaoImpl productOptionDaoImpl = new ProductOptionDaoImpl();
    SkuImpl skuImpl = mock(SkuImpl.class);
    when(skuImpl.getId()).thenReturn(1L);

    ArrayList<Sku> candidateSkus = new ArrayList<>();
    candidateSkus.add(skuImpl);

    // Act
    List<Long> actualFilterCandidateSkusForArchivedStatusResult = productOptionDaoImpl
        .filterCandidateSkusForArchivedStatus(candidateSkus);

    // Assert
    verify(skuImpl).getId();
    assertEquals(1, actualFilterCandidateSkusForArchivedStatusResult.size());
    assertEquals(1L, actualFilterCandidateSkusForArchivedStatusResult.get(0).longValue());
  }

  /**
   * Test {@link ProductOptionDaoImpl#filterCandidateSkusForArchivedStatus(List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ProductOptionDaoImpl#filterCandidateSkusForArchivedStatus(List)}
   */
  @Test
  public void testFilterCandidateSkusForArchivedStatus_whenArrayList_thenReturnEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductOptionDaoImpl productOptionDaoImpl = new ProductOptionDaoImpl();

    // Act and Assert
    assertTrue(productOptionDaoImpl.filterCandidateSkusForArchivedStatus(new ArrayList<>()).isEmpty());
  }

  /**
   * Test
   * {@link ProductOptionDaoImpl#attachArchivalConditionIfPossible(Class, Path, CriteriaBuilder, List)}.
   * <p>
   * Method under test:
   * {@link ProductOptionDaoImpl#attachArchivalConditionIfPossible(Class, Path, CriteriaBuilder, List)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testAttachArchivalConditionIfPossible() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.catalog.dao;
    //   @org.springframework.transaction.annotation.Transactional
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2183 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.catalog.dao.ProductOptionDaoImpl productOptionDaoImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    ProductOptionDaoImpl productOptionDaoImpl2 = new ProductOptionDaoImpl();
    Class<Object> clazz = Object.class;
    InFlightMetadataCollectorImpl metadata = new InFlightMetadataCollectorImpl(null, null);

    CriteriaBuilderImpl criteriaBuilder = new CriteriaBuilderImpl(new SessionFactoryImpl(metadata,
        new AbstractDelegatingSessionFactoryOptions(null), mock(QueryPlanCache.QueryPlanCreator.class)));
    Class<Object> javaType = Object.class;
    Class<Object> treatAsType = Object.class;
    CollectionAttributeJoin<Object, ?> path = new CollectionAttributeJoin<>(criteriaBuilder, javaType,
        new CollectionAttributeJoin.TreatedCollectionAttributeJoin<>(null, treatAsType), null, JoinType.INNER);

    BootstrapContextImpl bootstrapContext = new BootstrapContextImpl(null, null);

    InFlightMetadataCollectorImpl metadata2 = new InFlightMetadataCollectorImpl(bootstrapContext,
        new MetadataBuilderImpl.MetadataBuildingOptionsImpl(null));

    CriteriaBuilderImpl cb = new CriteriaBuilderImpl(new SessionFactoryImpl(metadata2,
        new AbstractDelegatingSessionFactoryOptions(null), mock(QueryPlanCache.QueryPlanCreator.class)));

    // Act
    productOptionDaoImpl2.attachArchivalConditionIfPossible(clazz, path, cb, new ArrayList<>());
  }

  /**
   * Test
   * {@link ProductOptionDaoImpl#buildSkuDomainPredicate(CriteriaBuilder, Path, List)}.
   * <p>
   * Method under test:
   * {@link ProductOptionDaoImpl#buildSkuDomainPredicate(CriteriaBuilder, Path, List)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testBuildSkuDomainPredicate() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.catalog.dao;
    //   @org.springframework.transaction.annotation.Transactional
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2213 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.catalog.dao.ProductOptionDaoImpl productOptionDaoImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    ProductOptionDaoImpl productOptionDaoImpl2 = new ProductOptionDaoImpl();
    BootstrapContextImpl bootstrapContext = new BootstrapContextImpl(null, null);

    InFlightMetadataCollectorImpl metadata = new InFlightMetadataCollectorImpl(bootstrapContext,
        new MetadataBuilderImpl.MetadataBuildingOptionsImpl(null));

    CriteriaBuilderImpl cb = new CriteriaBuilderImpl(new SessionFactoryImpl(metadata,
        new AbstractDelegatingSessionFactoryOptions(null), mock(QueryPlanCache.QueryPlanCreator.class)));
    CriteriaBuilderImpl criteriaBuilder = new CriteriaBuilderImpl(
        new SessionFactoryImpl(null, null, mock(QueryPlanCache.QueryPlanCreator.class)));
    Class<Object> javaType = Object.class;
    Class<Object> treatAsType = Object.class;
    CollectionAttributeJoin original = new CollectionAttributeJoin(criteriaBuilder, javaType,
        new ListAttributeJoin.TreatedListAttributeJoin(null, treatAsType), null, JoinType.INNER);

    Class<Object> treatAsType2 = Object.class;
    CollectionAttributeJoin.TreatedCollectionAttributeJoin fieldName = new CollectionAttributeJoin.TreatedCollectionAttributeJoin(
        original, treatAsType2);

    // Act
    productOptionDaoImpl2.buildSkuDomainPredicate(cb, fieldName, new ArrayList<>());
  }

  /**
   * Test {@link ProductOptionDaoImpl#countProductsUsingProductOptionById(Long)}.
   * <p>
   * Method under test:
   * {@link ProductOptionDaoImpl#countProductsUsingProductOptionById(Long)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testCountProductsUsingProductOptionById() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.catalog.dao;
    //   @org.springframework.transaction.annotation.Transactional
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2258 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.catalog.dao.ProductOptionDaoImpl productOptionDaoImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new ProductOptionDaoImpl()).countProductsUsingProductOptionById(1L);
  }

  /**
   * Test
   * {@link ProductOptionDaoImpl#findProductIdsUsingProductOptionById(Long, int, int)}.
   * <p>
   * Method under test:
   * {@link ProductOptionDaoImpl#findProductIdsUsingProductOptionById(Long, int, int)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testFindProductIdsUsingProductOptionById() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.catalog.dao;
    //   @org.springframework.transaction.annotation.Transactional
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2323 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.catalog.dao.ProductOptionDaoImpl productOptionDaoImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new ProductOptionDaoImpl()).findProductIdsUsingProductOptionById(1L, 1, 3);
  }

  /**
   * Test
   * {@link ProductOptionDaoImpl#translateItemAttributeValue(OrderItemAttribute, ProductOption)}.
   * <p>
   * Method under test:
   * {@link ProductOptionDaoImpl#translateItemAttributeValue(OrderItemAttribute, ProductOption)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testTranslateItemAttributeValue() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.catalog.dao;
    //   @org.springframework.transaction.annotation.Transactional
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2433 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.catalog.dao.ProductOptionDaoImpl productOptionDaoImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    ProductOptionDaoImpl productOptionDaoImpl2 = new ProductOptionDaoImpl();
    OrderItemAttributeImpl itemAttribute = new OrderItemAttributeImpl();

    // Act
    productOptionDaoImpl2.translateItemAttributeValue(itemAttribute, new ProductOptionImpl());
  }
}
