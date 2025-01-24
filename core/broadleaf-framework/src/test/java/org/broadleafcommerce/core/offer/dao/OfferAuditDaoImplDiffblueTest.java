package org.broadleafcommerce.core.offer.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;
import org.broadleafcommerce.core.offer.domain.OfferAudit;
import org.broadleafcommerce.core.offer.domain.OfferAuditImpl;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.Order;
import org.broadleafcommerce.core.order.domain.OrderImpl;
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
import org.hibernate.query.criteria.internal.path.CollectionAttributeJoin;
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
public class OfferAuditDaoImplDiffblueTest {
  @Autowired
  private OfferAuditDaoImpl offerAuditDaoImpl;

  /**
   * Test
   * {@link OfferAuditDaoImpl#getCurrentDateAfterFactoringInDateResolution()}.
   * <p>
   * Method under test:
   * {@link OfferAuditDaoImpl#getCurrentDateAfterFactoringInDateResolution()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetCurrentDateAfterFactoringInDateResolution() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.offer.dao;
    //   @org.springframework.transaction.annotation.Transactional
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3682 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.offer.dao.OfferAuditDaoImpl offerAuditDaoImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new OfferAuditDaoImpl()).getCurrentDateAfterFactoringInDateResolution();
  }

  /**
   * Test {@link OfferAuditDaoImpl#create()}.
   * <p>
   * Method under test: {@link OfferAuditDaoImpl#create()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testCreate() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.offer.dao;
    //   @org.springframework.transaction.annotation.Transactional
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3667 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.offer.dao.OfferAuditDaoImpl offerAuditDaoImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new OfferAuditDaoImpl()).create();
  }

  /**
   * Test {@link OfferAuditDaoImpl#delete(OfferAudit)}.
   * <p>
   * Method under test: {@link OfferAuditDaoImpl#delete(OfferAudit)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testDelete() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.offer.dao;
    //   @org.springframework.transaction.annotation.Transactional
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3669 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.offer.dao.OfferAuditDaoImpl offerAuditDaoImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    OfferAuditDaoImpl offerAuditDaoImpl2 = new OfferAuditDaoImpl();

    // Act
    offerAuditDaoImpl2.delete(new OfferAuditImpl());
  }

  /**
   * Test {@link OfferAuditDaoImpl#save(OfferAudit)}.
   * <p>
   * Method under test: {@link OfferAuditDaoImpl#save(OfferAudit)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testSave() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.offer.dao;
    //   @org.springframework.transaction.annotation.Transactional
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3762 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.offer.dao.OfferAuditDaoImpl offerAuditDaoImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    OfferAuditDaoImpl offerAuditDaoImpl2 = new OfferAuditDaoImpl();

    // Act
    offerAuditDaoImpl2.save(new OfferAuditImpl());
  }

  /**
   * Test {@link OfferAuditDaoImpl#readAuditById(Long)}.
   * <p>
   * Method under test: {@link OfferAuditDaoImpl#readAuditById(Long)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testReadAuditById() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.offer.dao;
    //   @org.springframework.transaction.annotation.Transactional
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3728 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.offer.dao.OfferAuditDaoImpl offerAuditDaoImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new OfferAuditDaoImpl()).readAuditById(1L);
  }

  /**
   * Test {@link OfferAuditDaoImpl#countUsesByCustomer(Long, Long)} with
   * {@code customerId}, {@code offerId}.
   * <p>
   * Method under test: {@link OfferAuditDaoImpl#countUsesByCustomer(Long, Long)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testCountUsesByCustomerWithCustomerIdOfferId() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.offer.dao;
    //   @org.springframework.transaction.annotation.Transactional
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3577 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.offer.dao.OfferAuditDaoImpl offerAuditDaoImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new OfferAuditDaoImpl()).countUsesByCustomer(1L, 1L);
  }

  /**
   * Test {@link OfferAuditDaoImpl#countUsesByCustomer(Order, Long, Long)} with
   * {@code order}, {@code customerId}, {@code offerId}.
   * <p>
   * Method under test:
   * {@link OfferAuditDaoImpl#countUsesByCustomer(Order, Long, Long)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testCountUsesByCustomerWithOrderCustomerIdOfferId() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.offer.dao;
    //   @org.springframework.transaction.annotation.Transactional
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3607 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.offer.dao.OfferAuditDaoImpl offerAuditDaoImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    OfferAuditDaoImpl offerAuditDaoImpl2 = new OfferAuditDaoImpl();

    // Act
    offerAuditDaoImpl2.countUsesByCustomer(new NullOrderImpl(), 1L, 1L);
  }

  /**
   * Test {@link OfferAuditDaoImpl#countUsesByCustomer(Order, Long, Long, Long)}
   * with {@code order}, {@code customerId}, {@code offerId},
   * {@code minimumDaysPerUsage}.
   * <p>
   * Method under test:
   * {@link OfferAuditDaoImpl#countUsesByCustomer(Order, Long, Long, Long)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testCountUsesByCustomerWithOrderCustomerIdOfferIdMinimumDaysPerUsage() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.offer.dao;
    //   @org.springframework.transaction.annotation.Transactional
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3637 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.offer.dao.OfferAuditDaoImpl offerAuditDaoImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    OfferAuditDaoImpl offerAuditDaoImpl2 = new OfferAuditDaoImpl();

    // Act
    offerAuditDaoImpl2.countUsesByCustomer(new NullOrderImpl(), 1L, 1L, 3L);
  }

  /**
   * Test {@link OfferAuditDaoImpl#countUsesByAccount(Order, Long, Long)} with
   * {@code order}, {@code accountId}, {@code offerId}.
   * <p>
   * Method under test:
   * {@link OfferAuditDaoImpl#countUsesByAccount(Order, Long, Long)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testCountUsesByAccountWithOrderAccountIdOfferId() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.offer.dao;
    //   @org.springframework.transaction.annotation.Transactional
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3487 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.offer.dao.OfferAuditDaoImpl offerAuditDaoImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    OfferAuditDaoImpl offerAuditDaoImpl2 = new OfferAuditDaoImpl();

    // Act
    offerAuditDaoImpl2.countUsesByAccount(new NullOrderImpl(), 1L, 1L);
  }

  /**
   * Test {@link OfferAuditDaoImpl#countUsesByAccount(Order, Long, Long, Long)}
   * with {@code order}, {@code accountId}, {@code offerId},
   * {@code minimumDaysPerUsage}.
   * <p>
   * Method under test:
   * {@link OfferAuditDaoImpl#countUsesByAccount(Order, Long, Long, Long)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testCountUsesByAccountWithOrderAccountIdOfferIdMinimumDaysPerUsage() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.offer.dao;
    //   @org.springframework.transaction.annotation.Transactional
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3517 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.offer.dao.OfferAuditDaoImpl offerAuditDaoImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    OfferAuditDaoImpl offerAuditDaoImpl2 = new OfferAuditDaoImpl();

    // Act
    offerAuditDaoImpl2.countUsesByAccount(new NullOrderImpl(), 1L, 1L, 3L);
  }

  /**
   * Test
   * {@link OfferAuditDaoImpl#countUsesByAccountOrCustomer(Order, Long, Long, Long, Long)}.
   * <p>
   * Method under test:
   * {@link OfferAuditDaoImpl#countUsesByAccountOrCustomer(Order, Long, Long, Long, Long)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testCountUsesByAccountOrCustomer() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.offer.dao;
    //   @org.springframework.transaction.annotation.Transactional
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3547 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.offer.dao.OfferAuditDaoImpl offerAuditDaoImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    OfferAuditDaoImpl offerAuditDaoImpl2 = new OfferAuditDaoImpl();

    // Act
    offerAuditDaoImpl2.countUsesByAccountOrCustomer(new NullOrderImpl(), 1L, 1L, 1L, 3L);
  }

  /**
   * Test
   * {@link OfferAuditDaoImpl#getOmsOrderPredicate(CriteriaBuilder, Root, Join)}.
   * <p>
   * Method under test:
   * {@link OfferAuditDaoImpl#getOmsOrderPredicate(CriteriaBuilder, Root, Join)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetOmsOrderPredicate() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.offer.dao;
    //   @org.springframework.transaction.annotation.Transactional
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3684 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.offer.dao.OfferAuditDaoImpl offerAuditDaoImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    OfferAuditDaoImpl offerAuditDaoImpl2 = new OfferAuditDaoImpl();
    BootstrapContextImpl bootstrapContext = new BootstrapContextImpl(null, null);

    InFlightMetadataCollectorImpl metadata = new InFlightMetadataCollectorImpl(bootstrapContext,
        new MetadataBuilderImpl.MetadataBuildingOptionsImpl(null));

    CriteriaBuilderImpl builder = new CriteriaBuilderImpl(new SessionFactoryImpl(metadata,
        new AbstractDelegatingSessionFactoryOptions(null), mock(QueryPlanCache.QueryPlanCreator.class)));
    InFlightMetadataCollectorImpl metadata2 = new InFlightMetadataCollectorImpl(null, null);

    CriteriaBuilderImpl criteriaBuilder = new CriteriaBuilderImpl(new SessionFactoryImpl(metadata2,
        new AbstractDelegatingSessionFactoryOptions(null), mock(QueryPlanCache.QueryPlanCreator.class)));
    Class<Object> javaType = Object.class;
    Class<OrderImpl> javaType2 = OrderImpl.class;
    MappedSuperclassTypeImpl<? super OrderImpl> superType = new MappedSuperclassTypeImpl<>(javaType2, null, null, null);

    RootClass persistentClass = new RootClass(new MetadataBuildingContextRootImpl(null, null, null));
    RootImpl<OrderImpl> orderRoot = new RootImpl<>(criteriaBuilder,
        new EntityTypeImpl<>(javaType, superType, persistentClass, new SessionFactoryDelegatingImpl(null)));

    InFlightMetadataCollectorImpl metadata3 = new InFlightMetadataCollectorImpl(null, null);

    CriteriaBuilderImpl criteriaBuilder2 = new CriteriaBuilderImpl(new SessionFactoryImpl(metadata3,
        new AbstractDelegatingSessionFactoryOptions(null), mock(QueryPlanCache.QueryPlanCreator.class)));
    Class<Object> javaType3 = Object.class;
    Class<Object> treatAsType = Object.class;

    // Act
    offerAuditDaoImpl2.getOmsOrderPredicate(builder, orderRoot,
        new CollectionAttributeJoin<>(criteriaBuilder2, javaType3,
            new CollectionAttributeJoin.TreatedCollectionAttributeJoin<>(null, treatAsType), null, JoinType.INNER));
  }

  /**
   * Test {@link OfferAuditDaoImpl#getOrderId(Order)}.
   * <p>
   * Method under test: {@link OfferAuditDaoImpl#getOrderId(Order)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetOrderId() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.offer.dao;
    //   @org.springframework.transaction.annotation.Transactional
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3714 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.offer.dao.OfferAuditDaoImpl offerAuditDaoImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    OfferAuditDaoImpl offerAuditDaoImpl2 = new OfferAuditDaoImpl();

    // Act
    offerAuditDaoImpl2.getOrderId(new NullOrderImpl());
  }

  /**
   * Test {@link OfferAuditDaoImpl#getOrderId(Order)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>When {@link NullOrderImpl} {@link NullOrderImpl#getId()} return one.</li>
   *   <li>Then return longValue is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferAuditDaoImpl#getOrderId(Order)}
   */
  @Test
  public void testGetOrderId_givenOne_whenNullOrderImplGetIdReturnOne_thenReturnLongValueIsOne() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferAuditDaoImpl offerAuditDaoImpl = new OfferAuditDaoImpl();
    NullOrderImpl order = mock(NullOrderImpl.class);
    when(order.getId()).thenReturn(1L);

    // Act
    Long actualOrderId = offerAuditDaoImpl.getOrderId(order);

    // Assert
    verify(order).getId();
    assertEquals(1L, actualOrderId.longValue());
  }

  /**
   * Test {@link OfferAuditDaoImpl#getOrderId(Order)}.
   * <ul>
   *   <li>When {@link NullOrderImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferAuditDaoImpl#getOrderId(Order)}
   */
  @Test
  public void testGetOrderId_whenNullOrderImpl_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferAuditDaoImpl offerAuditDaoImpl = new OfferAuditDaoImpl();

    // Act and Assert
    assertNull(offerAuditDaoImpl.getOrderId(new NullOrderImpl()));
  }

  /**
   * Test {@link OfferAuditDaoImpl#countOfferCodeUses(Long)} with
   * {@code offerCodeId}.
   * <p>
   * Method under test: {@link OfferAuditDaoImpl#countOfferCodeUses(Long)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testCountOfferCodeUsesWithOfferCodeId() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.offer.dao;
    //   @org.springframework.transaction.annotation.Transactional
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3441 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.offer.dao.OfferAuditDaoImpl offerAuditDaoImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new OfferAuditDaoImpl()).countOfferCodeUses(1L);
  }

  /**
   * Test {@link OfferAuditDaoImpl#countOfferCodeUses(Order, Long)} with
   * {@code order}, {@code offerCodeId}.
   * <p>
   * Method under test: {@link OfferAuditDaoImpl#countOfferCodeUses(Order, Long)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testCountOfferCodeUsesWithOrderOfferCodeId() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.offer.dao;
    //   @org.springframework.transaction.annotation.Transactional
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3458 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.offer.dao.OfferAuditDaoImpl offerAuditDaoImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    OfferAuditDaoImpl offerAuditDaoImpl2 = new OfferAuditDaoImpl();

    // Act
    offerAuditDaoImpl2.countOfferCodeUses(new NullOrderImpl(), 1L);
  }

  /**
   * Test {@link OfferAuditDaoImpl#countOfferCodeUses(Order, Long)} with
   * {@code order}, {@code offerCodeId}.
   * <ul>
   *   <li>When {@link NullOrderImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferAuditDaoImpl#countOfferCodeUses(Order, Long)}
   */
  @Test
  public void testCountOfferCodeUsesWithOrderOfferCodeId_whenNullOrderImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferAuditDaoImpl offerAuditDaoImpl = new OfferAuditDaoImpl();

    // Act and Assert
    assertNull(offerAuditDaoImpl.countOfferCodeUses(new NullOrderImpl(), 1L));
  }

  /**
   * Test {@link OfferAuditDaoImpl#countOfferCodeUses(Order, Long)} with
   * {@code order}, {@code offerCodeId}.
   * <ul>
   *   <li>When {@link Order}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferAuditDaoImpl#countOfferCodeUses(Order, Long)}
   */
  @Test
  public void testCountOfferCodeUsesWithOrderOfferCodeId_whenOrder() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new OfferAuditDaoImpl()).countOfferCodeUses(mock(Order.class), 1L));
  }

  /**
   * Test {@link OfferAuditDaoImpl#readOfferAuditsByOrderId(Long)}.
   * <p>
   * Method under test: {@link OfferAuditDaoImpl#readOfferAuditsByOrderId(Long)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testReadOfferAuditsByOrderId() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.offer.dao;
    //   @org.springframework.transaction.annotation.Transactional
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3745 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.offer.dao.OfferAuditDaoImpl offerAuditDaoImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new OfferAuditDaoImpl()).readOfferAuditsByOrderId(1L);
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link OfferAuditDaoImpl#setCurrentDateResolution(Long)}
   *   <li>{@link OfferAuditDaoImpl#getCurrentDateResolution()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    OfferAuditDaoImpl offerAuditDaoImpl = new OfferAuditDaoImpl();

    // Act
    offerAuditDaoImpl.setCurrentDateResolution(1L);

    // Assert that nothing has changed
    assertEquals(1L, offerAuditDaoImpl.getCurrentDateResolution().longValue());
  }
}
