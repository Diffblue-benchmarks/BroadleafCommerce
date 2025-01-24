package org.broadleafcommerce.core.catalog.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.mock;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.From;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Path;
import org.broadleafcommerce.core.catalog.domain.Product;
import org.broadleafcommerce.core.catalog.domain.ProductBundleImpl;
import org.broadleafcommerce.core.catalog.domain.Sku;
import org.broadleafcommerce.core.catalog.service.type.ProductType;
import org.broadleafcommerce.core.search.domain.SearchCriteria;
import org.hibernate.boot.internal.InFlightMetadataCollectorImpl;
import org.hibernate.boot.spi.AbstractDelegatingSessionFactoryOptions;
import org.hibernate.engine.query.spi.QueryPlanCache;
import org.hibernate.internal.SessionFactoryImpl;
import org.hibernate.query.criteria.internal.CriteriaBuilderImpl;
import org.hibernate.query.criteria.internal.CriteriaQueryImpl;
import org.hibernate.query.criteria.internal.path.CollectionAttributeJoin;
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
public class ProductDaoImplDiffblueTest {
  @Autowired
  private ProductDaoImpl productDaoImpl;

  /**
   * Test {@link ProductDaoImpl#save(Product)}.
   * <p>
   * Method under test: {@link ProductDaoImpl#save(Product)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testSave() {
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
    //   public class DiffblueFakeClass2153 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.catalog.dao.ProductDaoImpl productDaoImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    ProductDaoImpl productDaoImpl2 = new ProductDaoImpl();

    // Act
    productDaoImpl2.save(new ProductBundleImpl());
  }

  /**
   * Test {@link ProductDaoImpl#readProductById(Long)}.
   * <p>
   * Method under test: {@link ProductDaoImpl#readProductById(Long)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testReadProductById() {
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
    //   public class DiffblueFakeClass2025 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.catalog.dao.ProductDaoImpl productDaoImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new ProductDaoImpl()).readProductById(1L);
  }

  /**
   * Test {@link ProductDaoImpl#readProductByExternalId(String)}.
   * <p>
   * Method under test: {@link ProductDaoImpl#readProductByExternalId(String)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testReadProductByExternalId() {
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
    //   public class DiffblueFakeClass1704 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.catalog.dao.ProductDaoImpl productDaoImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new ProductDaoImpl()).readProductByExternalId("42");
  }

  /**
   * Test {@link ProductDaoImpl#readProductsByIds(List)}.
   * <p>
   * Method under test: {@link ProductDaoImpl#readProductsByIds(List)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testReadProductsByIds() {
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
    //   public class DiffblueFakeClass2087 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.catalog.dao.ProductDaoImpl productDaoImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    ProductDaoImpl productDaoImpl2 = new ProductDaoImpl();

    // Act
    productDaoImpl2.readProductsByIds(new ArrayList<>());
  }

  /**
   * Test {@link ProductDaoImpl#readProductsByIds(List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductDaoImpl#readProductsByIds(List)}
   */
  @Test
  public void testReadProductsByIds_whenArrayList_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductDaoImpl productDaoImpl = new ProductDaoImpl();

    // Act and Assert
    assertNull(productDaoImpl.readProductsByIds(new ArrayList<>()));
  }

  /**
   * Test {@link ProductDaoImpl#readProductsByIds(List)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductDaoImpl#readProductsByIds(List)}
   */
  @Test
  public void testReadProductsByIds_whenNull_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new ProductDaoImpl()).readProductsByIds(null));
  }

  /**
   * Test {@link ProductDaoImpl#readProductsByName(String)} with
   * {@code searchName}.
   * <p>
   * Method under test: {@link ProductDaoImpl#readProductsByName(String)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testReadProductsByNameWithSearchName() {
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
    //   public class DiffblueFakeClass2093 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.catalog.dao.ProductDaoImpl productDaoImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new ProductDaoImpl()).readProductsByName("Search Name");
  }

  /**
   * Test {@link ProductDaoImpl#readProductsByName(String, int, int)} with
   * {@code searchName}, {@code limit}, {@code offset}.
   * <p>
   * Method under test:
   * {@link ProductDaoImpl#readProductsByName(String, int, int)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testReadProductsByNameWithSearchNameLimitOffset() {
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
    //   public class DiffblueFakeClass2123 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.catalog.dao.ProductDaoImpl productDaoImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new ProductDaoImpl()).readProductsByName("Search Name", 1, 2);
  }

  /**
   * Test {@link ProductDaoImpl#readActiveProductsByCategory(Long)} with
   * {@code categoryId}.
   * <p>
   * Method under test: {@link ProductDaoImpl#readActiveProductsByCategory(Long)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testReadActiveProductsByCategoryWithCategoryId() {
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
    //   public class DiffblueFakeClass1047 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.catalog.dao.ProductDaoImpl productDaoImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new ProductDaoImpl()).readActiveProductsByCategory(1L);
  }

  /**
   * Test {@link ProductDaoImpl#readActiveProductsByCategory(Long, Date)} with
   * {@code categoryId}, {@code currentDate}.
   * <p>
   * Method under test:
   * {@link ProductDaoImpl#readActiveProductsByCategory(Long, Date)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testReadActiveProductsByCategoryWithCategoryIdCurrentDate() {
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
    //   public class DiffblueFakeClass1093 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.catalog.dao.ProductDaoImpl productDaoImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    ProductDaoImpl productDaoImpl2 = new ProductDaoImpl();

    // Act
    productDaoImpl2.readActiveProductsByCategory(1L,
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
  }

  /**
   * Test
   * {@link ProductDaoImpl#readActiveProductsByCategory(Long, Date, int, int)}
   * with {@code categoryId}, {@code currentDate}, {@code limit}, {@code offset}.
   * <p>
   * Method under test:
   * {@link ProductDaoImpl#readActiveProductsByCategory(Long, Date, int, int)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testReadActiveProductsByCategoryWithCategoryIdCurrentDateLimitOffset() {
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
    //   public class DiffblueFakeClass1122 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.catalog.dao.ProductDaoImpl productDaoImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    ProductDaoImpl productDaoImpl2 = new ProductDaoImpl();

    // Act
    productDaoImpl2.readActiveProductsByCategory(1L,
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()), 1, 2);
  }

  /**
   * Test {@link ProductDaoImpl#readActiveProductsByCategory(Long, int, int)} with
   * {@code categoryId}, {@code limit}, {@code offset}.
   * <p>
   * Method under test:
   * {@link ProductDaoImpl#readActiveProductsByCategory(Long, int, int)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testReadActiveProductsByCategoryWithCategoryIdLimitOffset() {
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
    //   public class DiffblueFakeClass1063 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.catalog.dao.ProductDaoImpl productDaoImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new ProductDaoImpl()).readActiveProductsByCategory(1L, 1, 2);
  }

  /**
   * Test {@link ProductDaoImpl#readActiveProductsByCategoryInternal(Long, Date)}
   * with {@code categoryId}, {@code currentDate}.
   * <p>
   * Method under test:
   * {@link ProductDaoImpl#readActiveProductsByCategoryInternal(Long, Date)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testReadActiveProductsByCategoryInternalWithCategoryIdCurrentDate() {
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
    //   public class DiffblueFakeClass1165 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.catalog.dao.ProductDaoImpl productDaoImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    ProductDaoImpl productDaoImpl2 = new ProductDaoImpl();

    // Act
    productDaoImpl2.readActiveProductsByCategoryInternal(1L,
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
  }

  /**
   * Test
   * {@link ProductDaoImpl#readActiveProductsByCategoryInternal(Long, Date, int, int)}
   * with {@code categoryId}, {@code currentDate}, {@code limit}, {@code offset}.
   * <p>
   * Method under test:
   * {@link ProductDaoImpl#readActiveProductsByCategoryInternal(Long, Date, int, int)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testReadActiveProductsByCategoryInternalWithCategoryIdCurrentDateLimitOffset() {
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
    //   public class DiffblueFakeClass1194 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.catalog.dao.ProductDaoImpl productDaoImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    ProductDaoImpl productDaoImpl2 = new ProductDaoImpl();

    // Act
    productDaoImpl2.readActiveProductsByCategoryInternal(1L,
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()), 1, 2);
  }

  /**
   * Test {@link ProductDaoImpl#readProductsByCategory(Long)} with
   * {@code categoryId}.
   * <p>
   * Method under test: {@link ProductDaoImpl#readProductsByCategory(Long)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testReadProductsByCategoryWithCategoryId() {
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
    //   public class DiffblueFakeClass2041 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.catalog.dao.ProductDaoImpl productDaoImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new ProductDaoImpl()).readProductsByCategory(1L);
  }

  /**
   * Test {@link ProductDaoImpl#readProductsByCategory(Long, int, int)} with
   * {@code categoryId}, {@code limit}, {@code offset}.
   * <p>
   * Method under test:
   * {@link ProductDaoImpl#readProductsByCategory(Long, int, int)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testReadProductsByCategoryWithCategoryIdLimitOffset() {
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
    //   public class DiffblueFakeClass2057 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.catalog.dao.ProductDaoImpl productDaoImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new ProductDaoImpl()).readProductsByCategory(1L, 1, 2);
  }

  /**
   * Test
   * {@link ProductDaoImpl#readFilteredActiveProductsByQuery(String, Date, SearchCriteria)}
   * with {@code query}, {@code currentDate}, {@code searchCriteria}.
   * <p>
   * Method under test:
   * {@link ProductDaoImpl#readFilteredActiveProductsByQuery(String, Date, SearchCriteria)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testReadFilteredActiveProductsByQueryWithQueryCurrentDateSearchCriteria() {
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
    //   public class DiffblueFakeClass1576 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.catalog.dao.ProductDaoImpl productDaoImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    ProductDaoImpl productDaoImpl2 = new ProductDaoImpl();
    Date currentDate = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act
    productDaoImpl2.readFilteredActiveProductsByQuery("Query", currentDate, new SearchCriteria());
  }

  /**
   * Test
   * {@link ProductDaoImpl#readFilteredActiveProductsByQuery(String, SearchCriteria)}
   * with {@code query}, {@code searchCriteria}.
   * <p>
   * Method under test:
   * {@link ProductDaoImpl#readFilteredActiveProductsByQuery(String, SearchCriteria)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testReadFilteredActiveProductsByQueryWithQuerySearchCriteria() {
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
    //   public class DiffblueFakeClass1623 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.catalog.dao.ProductDaoImpl productDaoImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    ProductDaoImpl productDaoImpl2 = new ProductDaoImpl();

    // Act
    productDaoImpl2.readFilteredActiveProductsByQuery("Query", new SearchCriteria());
  }

  /**
   * Test
   * {@link ProductDaoImpl#readFilteredActiveProductsByQueryInternal(String, Date, SearchCriteria)}.
   * <p>
   * Method under test:
   * {@link ProductDaoImpl#readFilteredActiveProductsByQueryInternal(String, Date, SearchCriteria)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testReadFilteredActiveProductsByQueryInternal() {
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
    //   public class DiffblueFakeClass1657 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.catalog.dao.ProductDaoImpl productDaoImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    ProductDaoImpl productDaoImpl2 = new ProductDaoImpl();
    Date currentDate = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act
    productDaoImpl2.readFilteredActiveProductsByQueryInternal("Query", currentDate, new SearchCriteria());
  }

  /**
   * Test
   * {@link ProductDaoImpl#readFilteredActiveProductsByCategory(Long, Date, SearchCriteria)}
   * with {@code categoryId}, {@code currentDate}, {@code searchCriteria}.
   * <p>
   * Method under test:
   * {@link ProductDaoImpl#readFilteredActiveProductsByCategory(Long, Date, SearchCriteria)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testReadFilteredActiveProductsByCategoryWithCategoryIdCurrentDateSearchCriteria() {
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
    //   public class DiffblueFakeClass1475 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.catalog.dao.ProductDaoImpl productDaoImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    ProductDaoImpl productDaoImpl2 = new ProductDaoImpl();
    Date currentDate = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act
    productDaoImpl2.readFilteredActiveProductsByCategory(1L, currentDate, new SearchCriteria());
  }

  /**
   * Test
   * {@link ProductDaoImpl#readFilteredActiveProductsByCategory(Long, SearchCriteria)}
   * with {@code categoryId}, {@code searchCriteria}.
   * <p>
   * Method under test:
   * {@link ProductDaoImpl#readFilteredActiveProductsByCategory(Long, SearchCriteria)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testReadFilteredActiveProductsByCategoryWithCategoryIdSearchCriteria() {
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
    //   public class DiffblueFakeClass1517 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.catalog.dao.ProductDaoImpl productDaoImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    ProductDaoImpl productDaoImpl2 = new ProductDaoImpl();

    // Act
    productDaoImpl2.readFilteredActiveProductsByCategory(1L, new SearchCriteria());
  }

  /**
   * Test
   * {@link ProductDaoImpl#readFilteredActiveProductsByCategoryInternal(Long, Date, SearchCriteria)}.
   * <p>
   * Method under test:
   * {@link ProductDaoImpl#readFilteredActiveProductsByCategoryInternal(Long, Date, SearchCriteria)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testReadFilteredActiveProductsByCategoryInternal() {
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
    //   public class DiffblueFakeClass1546 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.catalog.dao.ProductDaoImpl productDaoImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    ProductDaoImpl productDaoImpl2 = new ProductDaoImpl();
    Date currentDate = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act
    productDaoImpl2.readFilteredActiveProductsByCategoryInternal(1L, currentDate, new SearchCriteria());
  }

  /**
   * Test {@link ProductDaoImpl#attachActiveRestriction(Date, Path, Path, List)}.
   * <p>
   * Method under test:
   * {@link ProductDaoImpl#attachActiveRestriction(Date, Path, Path, List)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testAttachActiveRestriction() {
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
    //   public class DiffblueFakeClass830 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.catalog.dao.ProductDaoImpl productDaoImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    ProductDaoImpl productDaoImpl2 = new ProductDaoImpl();
    Date currentDate = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    InFlightMetadataCollectorImpl metadata = new InFlightMetadataCollectorImpl(null, null);

    CriteriaBuilderImpl criteriaBuilder = new CriteriaBuilderImpl(new SessionFactoryImpl(metadata,
        new AbstractDelegatingSessionFactoryOptions(null), mock(QueryPlanCache.QueryPlanCreator.class)));
    Class<Product> javaType = Product.class;
    Class<Object> treatAsType = Object.class;
    CollectionAttributeJoin<Object, ? extends Product> product = new CollectionAttributeJoin<>(criteriaBuilder,
        javaType, new CollectionAttributeJoin.TreatedCollectionAttributeJoin<>(null, treatAsType), null,
        JoinType.INNER);

    InFlightMetadataCollectorImpl metadata2 = new InFlightMetadataCollectorImpl(null, null);

    CriteriaBuilderImpl criteriaBuilder2 = new CriteriaBuilderImpl(new SessionFactoryImpl(metadata2,
        new AbstractDelegatingSessionFactoryOptions(null), mock(QueryPlanCache.QueryPlanCreator.class)));
    Class<Sku> javaType2 = Sku.class;
    Class<Object> treatAsType2 = Object.class;
    CollectionAttributeJoin<Object, ? extends Sku> sku = new CollectionAttributeJoin<>(criteriaBuilder2, javaType2,
        new CollectionAttributeJoin.TreatedCollectionAttributeJoin<>(null, treatAsType2), null, JoinType.INNER);

    // Act
    productDaoImpl2.attachActiveRestriction(currentDate, product, sku, new ArrayList<>());
  }

  /**
   * Test
   * {@link ProductDaoImpl#attachOrderBy(SearchCriteria, From, Path, CriteriaQuery)}.
   * <p>
   * Method under test:
   * {@link ProductDaoImpl#attachOrderBy(SearchCriteria, From, Path, CriteriaQuery)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testAttachOrderBy() {
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
    //   public class DiffblueFakeClass860 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.catalog.dao.ProductDaoImpl productDaoImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    ProductDaoImpl productDaoImpl2 = new ProductDaoImpl();
    SearchCriteria searchCriteria = new SearchCriteria();
    InFlightMetadataCollectorImpl metadata = new InFlightMetadataCollectorImpl(null, null);

    CriteriaBuilderImpl criteriaBuilder = new CriteriaBuilderImpl(new SessionFactoryImpl(metadata,
        new AbstractDelegatingSessionFactoryOptions(null), mock(QueryPlanCache.QueryPlanCreator.class)));
    Class<Product> javaType = Product.class;
    Class<Object> treatAsType = Object.class;
    CollectionAttributeJoin<?, ? extends Product> product = new CollectionAttributeJoin<>(criteriaBuilder, javaType,
        new CollectionAttributeJoin.TreatedCollectionAttributeJoin<>(null, treatAsType), null, JoinType.INNER);

    InFlightMetadataCollectorImpl metadata2 = new InFlightMetadataCollectorImpl(null, null);

    CriteriaBuilderImpl criteriaBuilder2 = new CriteriaBuilderImpl(new SessionFactoryImpl(metadata2,
        new AbstractDelegatingSessionFactoryOptions(null), mock(QueryPlanCache.QueryPlanCreator.class)));
    Class<Sku> javaType2 = Sku.class;
    Class<Object> treatAsType2 = Object.class;
    CollectionAttributeJoin<Object, ? extends Sku> sku = new CollectionAttributeJoin<>(criteriaBuilder2, javaType2,
        new CollectionAttributeJoin.TreatedCollectionAttributeJoin<>(null, treatAsType2), null, JoinType.INNER);

    InFlightMetadataCollectorImpl metadata3 = new InFlightMetadataCollectorImpl(null, null);

    CriteriaBuilderImpl criteriaBuilder3 = new CriteriaBuilderImpl(new SessionFactoryImpl(metadata3,
        new AbstractDelegatingSessionFactoryOptions(null), mock(QueryPlanCache.QueryPlanCreator.class)));
    Class<Object> returnType = Object.class;

    // Act
    productDaoImpl2.attachOrderBy(searchCriteria, product, sku, new CriteriaQueryImpl<>(criteriaBuilder3, returnType));
  }

  /**
   * Test
   * {@link ProductDaoImpl#attachSearchCriteria(SearchCriteria, From, From, List)}.
   * <p>
   * Method under test:
   * {@link ProductDaoImpl#attachSearchCriteria(SearchCriteria, From, From, List)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testAttachSearchCriteria() {
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
    //   public class DiffblueFakeClass890 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.catalog.dao.ProductDaoImpl productDaoImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    ProductDaoImpl productDaoImpl2 = new ProductDaoImpl();
    SearchCriteria searchCriteria = new SearchCriteria();
    InFlightMetadataCollectorImpl metadata = new InFlightMetadataCollectorImpl(null, null);

    CriteriaBuilderImpl criteriaBuilder = new CriteriaBuilderImpl(new SessionFactoryImpl(metadata,
        new AbstractDelegatingSessionFactoryOptions(null), mock(QueryPlanCache.QueryPlanCreator.class)));
    Class<Product> javaType = Product.class;
    Class<Object> treatAsType = Object.class;
    CollectionAttributeJoin<?, ? extends Product> product = new CollectionAttributeJoin<>(criteriaBuilder, javaType,
        new CollectionAttributeJoin.TreatedCollectionAttributeJoin<>(null, treatAsType), null, JoinType.INNER);

    InFlightMetadataCollectorImpl metadata2 = new InFlightMetadataCollectorImpl(null, null);

    CriteriaBuilderImpl criteriaBuilder2 = new CriteriaBuilderImpl(new SessionFactoryImpl(metadata2,
        new AbstractDelegatingSessionFactoryOptions(null), mock(QueryPlanCache.QueryPlanCreator.class)));
    Class<Sku> javaType2 = Sku.class;
    Class<Object> treatAsType2 = Object.class;
    CollectionAttributeJoin<?, ? extends Sku> sku = new CollectionAttributeJoin<>(criteriaBuilder2, javaType2,
        new CollectionAttributeJoin.TreatedCollectionAttributeJoin<>(null, treatAsType2), null, JoinType.INNER);

    // Act
    productDaoImpl2.attachSearchCriteria(searchCriteria, product, sku, new ArrayList<>());
  }

  /**
   * Test {@link ProductDaoImpl#delete(Product)}.
   * <p>
   * Method under test: {@link ProductDaoImpl#delete(Product)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testDelete() {
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
    //   public class DiffblueFakeClass927 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.catalog.dao.ProductDaoImpl productDaoImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    ProductDaoImpl productDaoImpl2 = new ProductDaoImpl();

    // Act
    productDaoImpl2.delete(new ProductBundleImpl());
  }

  /**
   * Test {@link ProductDaoImpl#create(ProductType)}.
   * <p>
   * Method under test: {@link ProductDaoImpl#create(ProductType)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testCreate() {
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
    //   public class DiffblueFakeClass920 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.catalog.dao.ProductDaoImpl productDaoImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new ProductDaoImpl()).create(ProductType.BUNDLE);
  }

  /**
   * Test {@link ProductDaoImpl#readAutomaticProductBundles()}.
   * <p>
   * Method under test: {@link ProductDaoImpl#readAutomaticProductBundles()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testReadAutomaticProductBundles() {
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
    //   public class DiffblueFakeClass1441 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.catalog.dao.ProductDaoImpl productDaoImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new ProductDaoImpl()).readAutomaticProductBundles();
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ProductDaoImpl#setCurrentDateResolution(Long)}
   *   <li>{@link ProductDaoImpl#getCurrentDateResolution()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    ProductDaoImpl productDaoImpl = new ProductDaoImpl();

    // Act
    productDaoImpl.setCurrentDateResolution(1L);

    // Assert that nothing has changed
    assertEquals(1L, productDaoImpl.getCurrentDateResolution().longValue());
  }

  /**
   * Test {@link ProductDaoImpl#findProductByURI(String)}.
   * <p>
   * Method under test: {@link ProductDaoImpl#findProductByURI(String)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testFindProductByURI() {
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
    //   public class DiffblueFakeClass957 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.catalog.dao.ProductDaoImpl productDaoImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new ProductDaoImpl()).findProductByURI("Uri");
  }

  /**
   * Test {@link ProductDaoImpl#readAllActiveProducts()}.
   * <p>
   * Method under test: {@link ProductDaoImpl#readAllActiveProducts()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testReadAllActiveProducts() {
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
    //   public class DiffblueFakeClass1261 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.catalog.dao.ProductDaoImpl productDaoImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new ProductDaoImpl()).readAllActiveProducts();
  }

  /**
   * Test {@link ProductDaoImpl#readAllActiveProducts(Date)} with
   * {@code currentDate}.
   * <p>
   * Method under test: {@link ProductDaoImpl#readAllActiveProducts(Date)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testReadAllActiveProductsWithCurrentDate() {
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
    //   public class DiffblueFakeClass1334 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.catalog.dao.ProductDaoImpl productDaoImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    ProductDaoImpl productDaoImpl2 = new ProductDaoImpl();

    // Act
    productDaoImpl2
        .readAllActiveProducts(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
  }

  /**
   * Test {@link ProductDaoImpl#readAllActiveProducts(int, int)} with
   * {@code page}, {@code pageSize}.
   * <p>
   * Method under test: {@link ProductDaoImpl#readAllActiveProducts(int, int)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testReadAllActiveProductsWithPagePageSize() {
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
    //   public class DiffblueFakeClass1263 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.catalog.dao.ProductDaoImpl productDaoImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new ProductDaoImpl()).readAllActiveProducts(1, 3);
  }

  /**
   * Test {@link ProductDaoImpl#readAllActiveProducts(int, int, Date)} with
   * {@code page}, {@code pageSize}, {@code currentDate}.
   * <p>
   * Method under test:
   * {@link ProductDaoImpl#readAllActiveProducts(int, int, Date)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testReadAllActiveProductsWithPagePageSizeCurrentDate() {
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
    //   public class DiffblueFakeClass1280 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.catalog.dao.ProductDaoImpl productDaoImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    ProductDaoImpl productDaoImpl2 = new ProductDaoImpl();

    // Act
    productDaoImpl2.readAllActiveProducts(1, 3,
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
  }

  /**
   * Test {@link ProductDaoImpl#readAllActiveProducts(Integer, Long)} with
   * {@code pageSize}, {@code lastId}.
   * <p>
   * Method under test:
   * {@link ProductDaoImpl#readAllActiveProducts(Integer, Long)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testReadAllActiveProductsWithPageSizeLastId() {
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
    //   public class DiffblueFakeClass1310 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.catalog.dao.ProductDaoImpl productDaoImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new ProductDaoImpl()).readAllActiveProducts(3, 1L);
  }

  /**
   * Test {@link ProductDaoImpl#readAllActiveProductsForSiteMap(int, int)}.
   * <p>
   * Method under test:
   * {@link ProductDaoImpl#readAllActiveProductsForSiteMap(int, int)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testReadAllActiveProductsForSiteMap() {
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
    //   public class DiffblueFakeClass1349 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.catalog.dao.ProductDaoImpl productDaoImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new ProductDaoImpl()).readAllActiveProductsForSiteMap(1, 3);
  }

  /**
   * Test {@link ProductDaoImpl#getCriteriaForActiveProductsForSiteMap(Date)}.
   * <p>
   * Method under test:
   * {@link ProductDaoImpl#getCriteriaForActiveProductsForSiteMap(Date)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetCriteriaForActiveProductsForSiteMap() {
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
    //   public class DiffblueFakeClass1032 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.catalog.dao.ProductDaoImpl productDaoImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    ProductDaoImpl productDaoImpl2 = new ProductDaoImpl();

    // Act
    productDaoImpl2.getCriteriaForActiveProductsForSiteMap(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
  }

  /**
   * Test {@link ProductDaoImpl#readAllActiveProductIds(Long, int)}.
   * <p>
   * Method under test: {@link ProductDaoImpl#readAllActiveProductIds(Long, int)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testReadAllActiveProductIds() {
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
    //   public class DiffblueFakeClass1237 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.catalog.dao.ProductDaoImpl productDaoImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new ProductDaoImpl()).readAllActiveProductIds(1L, 3);
  }

  /**
   * Test {@link ProductDaoImpl#readAllActiveProductsInternal(Date)} with
   * {@code currentDate}.
   * <p>
   * Method under test: {@link ProductDaoImpl#readAllActiveProductsInternal(Date)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testReadAllActiveProductsInternalWithCurrentDate() {
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
    //   public class DiffblueFakeClass1426 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.catalog.dao.ProductDaoImpl productDaoImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    ProductDaoImpl productDaoImpl2 = new ProductDaoImpl();

    // Act
    productDaoImpl2.readAllActiveProductsInternal(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
  }

  /**
   * Test {@link ProductDaoImpl#readAllActiveProductsInternal(int, int, Date)}
   * with {@code page}, {@code pageSize}, {@code currentDate}.
   * <p>
   * Method under test:
   * {@link ProductDaoImpl#readAllActiveProductsInternal(int, int, Date)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testReadAllActiveProductsInternalWithPagePageSizeCurrentDate() {
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
    //   public class DiffblueFakeClass1366 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.catalog.dao.ProductDaoImpl productDaoImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    ProductDaoImpl productDaoImpl2 = new ProductDaoImpl();

    // Act
    productDaoImpl2.readAllActiveProductsInternal(1, 3,
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
  }

  /**
   * Test
   * {@link ProductDaoImpl#readAllActiveProductsInternal(Integer, Date, Long)}
   * with {@code pageSize}, {@code currentDate}, {@code lastId}.
   * <p>
   * Method under test:
   * {@link ProductDaoImpl#readAllActiveProductsInternal(Integer, Date, Long)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testReadAllActiveProductsInternalWithPageSizeCurrentDateLastId() {
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
    //   public class DiffblueFakeClass1396 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.catalog.dao.ProductDaoImpl productDaoImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    ProductDaoImpl productDaoImpl2 = new ProductDaoImpl();

    // Act
    productDaoImpl2.readAllActiveProductsInternal(3,
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()), 1L);
  }

  /**
   * Test {@link ProductDaoImpl#readCountAllActiveProducts()}.
   * <p>
   * Method under test: {@link ProductDaoImpl#readCountAllActiveProducts()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testReadCountAllActiveProducts() {
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
    //   public class DiffblueFakeClass1443 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.catalog.dao.ProductDaoImpl productDaoImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new ProductDaoImpl()).readCountAllActiveProducts();
  }

  /**
   * Test {@link ProductDaoImpl#readCountAllActiveProducts(Date)} with
   * {@code Date}.
   * <p>
   * Method under test: {@link ProductDaoImpl#readCountAllActiveProducts(Date)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testReadCountAllActiveProductsWithDate() {
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
    //   public class DiffblueFakeClass1445 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.catalog.dao.ProductDaoImpl productDaoImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    ProductDaoImpl productDaoImpl2 = new ProductDaoImpl();

    // Act
    productDaoImpl2.readCountAllActiveProducts(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
  }

  /**
   * Test {@link ProductDaoImpl#readCountAllActiveProductsInternal(Date)}.
   * <p>
   * Method under test:
   * {@link ProductDaoImpl#readCountAllActiveProductsInternal(Date)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testReadCountAllActiveProductsInternal() {
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
    //   public class DiffblueFakeClass1460 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.catalog.dao.ProductDaoImpl productDaoImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    ProductDaoImpl productDaoImpl2 = new ProductDaoImpl();

    // Act
    productDaoImpl2.readCountAllActiveProductsInternal(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
  }

  /**
   * Test {@link ProductDaoImpl#getCriteriaForActiveProducts(Date)} with
   * {@code currentDate}.
   * <p>
   * Method under test: {@link ProductDaoImpl#getCriteriaForActiveProducts(Date)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetCriteriaForActiveProductsWithCurrentDate() {
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
    //   public class DiffblueFakeClass987 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.catalog.dao.ProductDaoImpl productDaoImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    ProductDaoImpl productDaoImpl2 = new ProductDaoImpl();

    // Act
    productDaoImpl2.getCriteriaForActiveProducts(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
  }

  /**
   * Test {@link ProductDaoImpl#getCriteriaForActiveProducts(Date, Long, boolean)}
   * with {@code currentDate}, {@code lastId}, {@code forSiteMap}.
   * <p>
   * Method under test:
   * {@link ProductDaoImpl#getCriteriaForActiveProducts(Date, Long, boolean)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetCriteriaForActiveProductsWithCurrentDateLastIdForSiteMap() {
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
    //   public class DiffblueFakeClass1002 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.catalog.dao.ProductDaoImpl productDaoImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    ProductDaoImpl productDaoImpl2 = new ProductDaoImpl();

    // Act
    productDaoImpl2.getCriteriaForActiveProducts(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()), 1L, true);
  }
}
