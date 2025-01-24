package org.broadleafcommerce.core.order.dao;

import org.broadleafcommerce.core.order.domain.FulfillmentGroup;
import org.broadleafcommerce.core.order.domain.FulfillmentGroupImpl;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.Order;
import org.broadleafcommerce.core.order.service.type.FulfillmentGroupStatusType;
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
public class FulfillmentGroupDaoImplDiffblueTest {
  @Autowired
  private FulfillmentGroupDaoImpl fulfillmentGroupDaoImpl;

  /**
   * Test {@link FulfillmentGroupDaoImpl#readFulfillmentGroupById(Long)}.
   * <p>
   * Method under test:
   * {@link FulfillmentGroupDaoImpl#readFulfillmentGroupById(Long)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testReadFulfillmentGroupById() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.order.dao;
    //   @org.springframework.transaction.annotation.Transactional
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass10021 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.order.dao.FulfillmentGroupDaoImpl fulfillmentGroupDaoImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new FulfillmentGroupDaoImpl()).readFulfillmentGroupById(1L);
  }

  /**
   * Test
   * {@link FulfillmentGroupDaoImpl#readDefaultFulfillmentGroupForOrder(Order)}.
   * <p>
   * Method under test:
   * {@link FulfillmentGroupDaoImpl#readDefaultFulfillmentGroupForOrder(Order)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testReadDefaultFulfillmentGroupForOrder() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.order.dao;
    //   @org.springframework.transaction.annotation.Transactional
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass10008 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.order.dao.FulfillmentGroupDaoImpl fulfillmentGroupDaoImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    FulfillmentGroupDaoImpl fulfillmentGroupDaoImpl2 = new FulfillmentGroupDaoImpl();

    // Act
    fulfillmentGroupDaoImpl2.readDefaultFulfillmentGroupForOrder(new NullOrderImpl());
  }

  /**
   * Test {@link FulfillmentGroupDaoImpl#delete(FulfillmentGroup)}.
   * <p>
   * Method under test: {@link FulfillmentGroupDaoImpl#delete(FulfillmentGroup)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testDelete() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.order.dao;
    //   @org.springframework.transaction.annotation.Transactional
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass9978 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.order.dao.FulfillmentGroupDaoImpl fulfillmentGroupDaoImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    FulfillmentGroupDaoImpl fulfillmentGroupDaoImpl2 = new FulfillmentGroupDaoImpl();

    // Act
    fulfillmentGroupDaoImpl2.delete(new FulfillmentGroupImpl());
  }

  /**
   * Test {@link FulfillmentGroupDaoImpl#createDefault()}.
   * <p>
   * Method under test: {@link FulfillmentGroupDaoImpl#createDefault()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testCreateDefault() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.order.dao;
    //   @org.springframework.transaction.annotation.Transactional
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass9976 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.order.dao.FulfillmentGroupDaoImpl fulfillmentGroupDaoImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new FulfillmentGroupDaoImpl()).createDefault();
  }

  /**
   * Test {@link FulfillmentGroupDaoImpl#create()}.
   * <p>
   * Method under test: {@link FulfillmentGroupDaoImpl#create()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testCreate() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.order.dao;
    //   @org.springframework.transaction.annotation.Transactional
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass9975 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.order.dao.FulfillmentGroupDaoImpl fulfillmentGroupDaoImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new FulfillmentGroupDaoImpl()).create();
  }

  /**
   * Test {@link FulfillmentGroupDaoImpl#createFulfillmentGroupFee()}.
   * <p>
   * Method under test:
   * {@link FulfillmentGroupDaoImpl#createFulfillmentGroupFee()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testCreateFulfillmentGroupFee() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.order.dao;
    //   @org.springframework.transaction.annotation.Transactional
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass9977 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.order.dao.FulfillmentGroupDaoImpl fulfillmentGroupDaoImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new FulfillmentGroupDaoImpl()).createFulfillmentGroupFee();
  }

  /**
   * Test
   * {@link FulfillmentGroupDaoImpl#readUnfulfilledFulfillmentGroups(int, int)}.
   * <p>
   * Method under test:
   * {@link FulfillmentGroupDaoImpl#readUnfulfilledFulfillmentGroups(int, int)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testReadUnfulfilledFulfillmentGroups() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.order.dao;
    //   @org.springframework.transaction.annotation.Transactional
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass10094 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.order.dao.FulfillmentGroupDaoImpl fulfillmentGroupDaoImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new FulfillmentGroupDaoImpl()).readUnfulfilledFulfillmentGroups(1, 3);
  }

  /**
   * Test
   * {@link FulfillmentGroupDaoImpl#readPartiallyFulfilledFulfillmentGroups(int, int)}.
   * <p>
   * Method under test:
   * {@link FulfillmentGroupDaoImpl#readPartiallyFulfilledFulfillmentGroups(int, int)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testReadPartiallyFulfilledFulfillmentGroups() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.order.dao;
    //   @org.springframework.transaction.annotation.Transactional
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass10086 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.order.dao.FulfillmentGroupDaoImpl fulfillmentGroupDaoImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new FulfillmentGroupDaoImpl()).readPartiallyFulfilledFulfillmentGroups(1, 3);
  }

  /**
   * Test
   * {@link FulfillmentGroupDaoImpl#readFulfillmentGroupsByStatus(FulfillmentGroupStatusType, int, int)}
   * with {@code status}, {@code start}, {@code maxResults}.
   * <p>
   * Method under test:
   * {@link FulfillmentGroupDaoImpl#readFulfillmentGroupsByStatus(FulfillmentGroupStatusType, int, int)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testReadFulfillmentGroupsByStatusWithStatusStartMaxResults() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.order.dao;
    //   @org.springframework.transaction.annotation.Transactional
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass10036 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.order.dao.FulfillmentGroupDaoImpl fulfillmentGroupDaoImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new FulfillmentGroupDaoImpl()).readFulfillmentGroupsByStatus(FulfillmentGroupStatusType.CANCELLED, 1, 3);
  }

  /**
   * Test
   * {@link FulfillmentGroupDaoImpl#readFulfillmentGroupsByStatus(FulfillmentGroupStatusType, int, int, boolean)}
   * with {@code status}, {@code start}, {@code maxResults}, {@code ascending}.
   * <p>
   * Method under test:
   * {@link FulfillmentGroupDaoImpl#readFulfillmentGroupsByStatus(FulfillmentGroupStatusType, int, int, boolean)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testReadFulfillmentGroupsByStatusWithStatusStartMaxResultsAscending() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.order.dao;
    //   @org.springframework.transaction.annotation.Transactional
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass10054 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.order.dao.FulfillmentGroupDaoImpl fulfillmentGroupDaoImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new FulfillmentGroupDaoImpl()).readFulfillmentGroupsByStatus(FulfillmentGroupStatusType.CANCELLED, 1, 3, true);
  }

  /**
   * Test
   * {@link FulfillmentGroupDaoImpl#readNextFulfillmentGroupSequnceForOrder(Order)}.
   * <p>
   * Method under test:
   * {@link FulfillmentGroupDaoImpl#readNextFulfillmentGroupSequnceForOrder(Order)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testReadNextFulfillmentGroupSequnceForOrder() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.order.dao;
    //   @org.springframework.transaction.annotation.Transactional
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass10073 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.order.dao.FulfillmentGroupDaoImpl fulfillmentGroupDaoImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    FulfillmentGroupDaoImpl fulfillmentGroupDaoImpl2 = new FulfillmentGroupDaoImpl();

    // Act
    fulfillmentGroupDaoImpl2.readNextFulfillmentGroupSequnceForOrder(new NullOrderImpl());
  }
}
