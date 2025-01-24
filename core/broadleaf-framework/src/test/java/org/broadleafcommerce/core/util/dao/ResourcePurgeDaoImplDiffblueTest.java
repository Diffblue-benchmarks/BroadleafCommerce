package org.broadleafcommerce.core.util.dao;

import static org.mockito.Mockito.mock;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Root;
import org.broadleafcommerce.core.order.service.type.OrderStatus;
import org.hibernate.boot.internal.BootstrapContextImpl;
import org.hibernate.boot.internal.InFlightMetadataCollectorImpl;
import org.hibernate.boot.internal.MetadataBuilderImpl;
import org.hibernate.boot.internal.MetadataBuildingContextRootImpl;
import org.hibernate.boot.spi.AbstractDelegatingSessionFactoryOptions;
import org.hibernate.engine.query.spi.QueryPlanCache;
import org.hibernate.engine.spi.SessionFactoryDelegatingImpl;
import org.hibernate.internal.SessionFactoryImpl;
import org.hibernate.mapping.RootClass;
import org.hibernate.metamodel.model.domain.internal.EntityTypeImpl;
import org.hibernate.metamodel.model.domain.internal.MappedSuperclassTypeImpl;
import org.hibernate.query.criteria.internal.CriteriaBuilderImpl;
import org.hibernate.query.criteria.internal.path.RootImpl;
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
public class ResourcePurgeDaoImplDiffblueTest {
  @Autowired
  private ResourcePurgeDaoImpl resourcePurgeDaoImpl;

  /**
   * Test
   * {@link ResourcePurgeDaoImpl#findCarts(String[], OrderStatus[], Date, Boolean, List)}
   * with {@code names}, {@code statuses}, {@code dateCreatedMinThreshold},
   * {@code isPreview}, {@code excludedIds}.
   * <p>
   * Method under test:
   * {@link ResourcePurgeDaoImpl#findCarts(String[], OrderStatus[], Date, Boolean, List)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testFindCartsWithNamesStatusesDateCreatedMinThresholdIsPreviewExcludedIds() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.util.dao;
    //   @org.springframework.transaction.annotation.Transactional
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1653 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.util.dao.ResourcePurgeDaoImpl resourcePurgeDaoImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    ResourcePurgeDaoImpl resourcePurgeDaoImpl2 = new ResourcePurgeDaoImpl();
    Date dateCreatedMinThreshold = Date
        .from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act
    resourcePurgeDaoImpl2.findCarts(new String[]{"Names"}, new OrderStatus[]{OrderStatus.ARCHIVED},
        dateCreatedMinThreshold, true, new ArrayList<>());
  }

  /**
   * Test
   * {@link ResourcePurgeDaoImpl#findCarts(String[], OrderStatus[], Date, Boolean, int, int, List)}
   * with {@code names}, {@code statuses}, {@code dateCreatedMinThreshold},
   * {@code isPreview}, {@code startPos}, {@code length}, {@code excludedIds}.
   * <p>
   * Method under test:
   * {@link ResourcePurgeDaoImpl#findCarts(String[], OrderStatus[], Date, Boolean, int, int, List)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testFindCartsWithNamesStatusesDateCreatedMinThresholdIsPreviewStartPosLengthExcludedIds() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.util.dao;
    //   @org.springframework.transaction.annotation.Transactional
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1623 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.util.dao.ResourcePurgeDaoImpl resourcePurgeDaoImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    ResourcePurgeDaoImpl resourcePurgeDaoImpl2 = new ResourcePurgeDaoImpl();
    Date dateCreatedMinThreshold = Date
        .from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act
    resourcePurgeDaoImpl2.findCarts(new String[]{"Names"}, new OrderStatus[]{OrderStatus.ARCHIVED},
        dateCreatedMinThreshold, true, 1, 3, new ArrayList<>());
  }

  /**
   * Test
   * {@link ResourcePurgeDaoImpl#findCartsCount(String[], OrderStatus[], Date, Boolean, List)}.
   * <p>
   * Method under test:
   * {@link ResourcePurgeDaoImpl#findCartsCount(String[], OrderStatus[], Date, Boolean, List)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testFindCartsCount() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.util.dao;
    //   @org.springframework.transaction.annotation.Transactional
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1683 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.util.dao.ResourcePurgeDaoImpl resourcePurgeDaoImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    ResourcePurgeDaoImpl resourcePurgeDaoImpl2 = new ResourcePurgeDaoImpl();
    Date dateCreatedMinThreshold = Date
        .from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act
    resourcePurgeDaoImpl2.findCartsCount(new String[]{"Names"}, new OrderStatus[]{OrderStatus.ARCHIVED},
        dateCreatedMinThreshold, true, new ArrayList<>());
  }

  /**
   * Test
   * {@link ResourcePurgeDaoImpl#findCustomers(Date, Boolean, Boolean, Boolean, List)}
   * with {@code dateCreatedMinThreshold}, {@code registered},
   * {@code deactivated}, {@code isPreview}, {@code excludedIds}.
   * <p>
   * Method under test:
   * {@link ResourcePurgeDaoImpl#findCustomers(Date, Boolean, Boolean, Boolean, List)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testFindCustomersWithDateCreatedMinThresholdRegisteredDeactivatedIsPreviewExcludedIds() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.util.dao;
    //   @org.springframework.transaction.annotation.Transactional
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1743 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.util.dao.ResourcePurgeDaoImpl resourcePurgeDaoImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    ResourcePurgeDaoImpl resourcePurgeDaoImpl2 = new ResourcePurgeDaoImpl();
    Date dateCreatedMinThreshold = Date
        .from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act
    resourcePurgeDaoImpl2.findCustomers(dateCreatedMinThreshold, true, true, true, new ArrayList<>());
  }

  /**
   * Test
   * {@link ResourcePurgeDaoImpl#findCustomers(Date, Boolean, Boolean, Boolean, int, int, List)}
   * with {@code dateCreatedMinThreshold}, {@code registered},
   * {@code deactivated}, {@code isPreview}, {@code startPos}, {@code length},
   * {@code excludedIds}.
   * <p>
   * Method under test:
   * {@link ResourcePurgeDaoImpl#findCustomers(Date, Boolean, Boolean, Boolean, int, int, List)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testFindCustomersWithDateCreatedMinThresholdRegisteredDeactivatedIsPreviewStartPosLengthExcludedIds() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.util.dao;
    //   @org.springframework.transaction.annotation.Transactional
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1713 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.util.dao.ResourcePurgeDaoImpl resourcePurgeDaoImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    ResourcePurgeDaoImpl resourcePurgeDaoImpl2 = new ResourcePurgeDaoImpl();
    Date dateCreatedMinThreshold = Date
        .from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act
    resourcePurgeDaoImpl2.findCustomers(dateCreatedMinThreshold, true, true, true, 1, 3, new ArrayList<>());
  }

  /**
   * Test
   * {@link ResourcePurgeDaoImpl#findCustomersCount(Date, Boolean, Boolean, Boolean, List)}.
   * <p>
   * Method under test:
   * {@link ResourcePurgeDaoImpl#findCustomersCount(Date, Boolean, Boolean, Boolean, List)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testFindCustomersCount() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.util.dao;
    //   @org.springframework.transaction.annotation.Transactional
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1764 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.util.dao.ResourcePurgeDaoImpl resourcePurgeDaoImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    ResourcePurgeDaoImpl resourcePurgeDaoImpl2 = new ResourcePurgeDaoImpl();
    Date dateCreatedMinThreshold = Date
        .from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act
    resourcePurgeDaoImpl2.findCustomersCount(dateCreatedMinThreshold, true, true, true, new ArrayList<>());
  }

  /**
   * Test
   * {@link ResourcePurgeDaoImpl#buildCustomerQuery(Date, Boolean, Boolean, Boolean, Class, List)}.
   * <p>
   * Method under test:
   * {@link ResourcePurgeDaoImpl#buildCustomerQuery(Date, Boolean, Boolean, Boolean, Class, List)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testBuildCustomerQuery() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.util.dao;
    //   @org.springframework.transaction.annotation.Transactional
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1593 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.util.dao.ResourcePurgeDaoImpl resourcePurgeDaoImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    ResourcePurgeDaoImpl resourcePurgeDaoImpl2 = new ResourcePurgeDaoImpl();
    Date dateCreatedMinThreshold = Date
        .from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    Class<Object> returnType = Object.class;

    // Act
    resourcePurgeDaoImpl2.buildCustomerQuery(dateCreatedMinThreshold, true, true, true, returnType, new ArrayList<>());
  }

  /**
   * Test
   * {@link ResourcePurgeDaoImpl#applyLimitedInClause(List, CriteriaBuilder, Root, List)}.
   * <p>
   * Method under test:
   * {@link ResourcePurgeDaoImpl#applyLimitedInClause(List, CriteriaBuilder, Root, List)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testApplyLimitedInClause() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.util.dao;
    //   @org.springframework.transaction.annotation.Transactional
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1533 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.util.dao.ResourcePurgeDaoImpl resourcePurgeDaoImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    ResourcePurgeDaoImpl resourcePurgeDaoImpl2 = new ResourcePurgeDaoImpl();
    ArrayList<Long> ids = new ArrayList<>();
    BootstrapContextImpl bootstrapContext = new BootstrapContextImpl(null, null);

    InFlightMetadataCollectorImpl metadata = new InFlightMetadataCollectorImpl(bootstrapContext,
        new MetadataBuilderImpl.MetadataBuildingOptionsImpl(null));

    CriteriaBuilderImpl builder = new CriteriaBuilderImpl(new SessionFactoryImpl(metadata,
        new AbstractDelegatingSessionFactoryOptions(null), mock(QueryPlanCache.QueryPlanCreator.class)));
    InFlightMetadataCollectorImpl metadata2 = new InFlightMetadataCollectorImpl(null, null);

    CriteriaBuilderImpl criteriaBuilder = new CriteriaBuilderImpl(new SessionFactoryImpl(metadata2,
        new AbstractDelegatingSessionFactoryOptions(null), mock(QueryPlanCache.QueryPlanCreator.class)));
    Class<Object> javaType = Object.class;
    Class<Object> javaType2 = Object.class;
    MappedSuperclassTypeImpl<? super Object> superType = new MappedSuperclassTypeImpl<>(javaType2, null, null, null);

    RootClass persistentClass = new RootClass(new MetadataBuildingContextRootImpl(null, null, null));
    RootImpl<Object> root = new RootImpl<>(criteriaBuilder,
        new EntityTypeImpl<>(javaType, superType, persistentClass, new SessionFactoryDelegatingImpl(null)));

    // Act
    resourcePurgeDaoImpl2.applyLimitedInClause(ids, builder, root, new ArrayList<>());
  }

  /**
   * Test
   * {@link ResourcePurgeDaoImpl#buildCartQuery(String[], OrderStatus[], Date, Boolean, Class, List)}.
   * <p>
   * Method under test:
   * {@link ResourcePurgeDaoImpl#buildCartQuery(String[], OrderStatus[], Date, Boolean, Class, List)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testBuildCartQuery() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.util.dao;
    //   @org.springframework.transaction.annotation.Transactional
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1563 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.util.dao.ResourcePurgeDaoImpl resourcePurgeDaoImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    ResourcePurgeDaoImpl resourcePurgeDaoImpl2 = new ResourcePurgeDaoImpl();
    Date dateCreatedMinThreshold = Date
        .from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    Class<Object> returnType = Object.class;

    // Act
    resourcePurgeDaoImpl2.buildCartQuery(new String[]{"Names"}, new OrderStatus[]{OrderStatus.ARCHIVED},
        dateCreatedMinThreshold, true, returnType, new ArrayList<>());
  }
}
