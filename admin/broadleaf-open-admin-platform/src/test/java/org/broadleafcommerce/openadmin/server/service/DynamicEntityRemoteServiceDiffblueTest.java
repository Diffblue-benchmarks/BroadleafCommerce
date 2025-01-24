package org.broadleafcommerce.openadmin.server.service;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.broadleafcommerce.common.exception.ServiceException;
import org.broadleafcommerce.openadmin.dto.CriteriaTransferObject;
import org.broadleafcommerce.openadmin.dto.Entity;
import org.broadleafcommerce.openadmin.dto.PersistencePackage;
import org.broadleafcommerce.openadmin.dto.Property;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml",
    "/bl-open-admin-applicationContext-entity.xml", "/bl-open-admin-contentClient-applicationContext.xml",
    "/bl-open-admin-contentCreator-applicationContext.xml",
    "/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml",
    "/blc-config/admin/framework/bl-open-admin-applicationContext.xml",
    "/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class DynamicEntityRemoteServiceDiffblueTest {
  @Autowired
  private DynamicEntityRemoteService dynamicEntityRemoteService;

  /**
   * Test
   * {@link DynamicEntityRemoteService#recreateSpecificServiceException(ServiceException, String, Throwable)}.
   * <p>
   * Method under test:
   * {@link DynamicEntityRemoteService#recreateSpecificServiceException(ServiceException, String, Throwable)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testRecreateSpecificServiceException() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass367 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.service.DynamicEntityRemoteService dynamicEntityRemoteService;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    DynamicEntityRemoteService dynamicEntityRemoteService2 = new DynamicEntityRemoteService();
    ServiceException e = new ServiceException("An error occurred");

    // Act
    dynamicEntityRemoteService2.recreateSpecificServiceException(e, "An error occurred", new Throwable());
  }

  /**
   * Test {@link DynamicEntityRemoteService#inspect(PersistencePackage)}.
   * <p>
   * Method under test:
   * {@link DynamicEntityRemoteService#inspect(PersistencePackage)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testInspect() throws ServiceException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass205 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.service.DynamicEntityRemoteService dynamicEntityRemoteService;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    DynamicEntityRemoteService dynamicEntityRemoteService2 = new DynamicEntityRemoteService();

    // Act
    dynamicEntityRemoteService2.inspect(new PersistencePackage());
  }

  /**
   * Test
   * {@link DynamicEntityRemoteService#nonTransactionalInspect(PersistencePackage)}.
   * <p>
   * Method under test:
   * {@link DynamicEntityRemoteService#nonTransactionalInspect(PersistencePackage)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testNonTransactionalInspect() throws ServiceException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass295 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.service.DynamicEntityRemoteService dynamicEntityRemoteService;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    DynamicEntityRemoteService dynamicEntityRemoteService2 = new DynamicEntityRemoteService();

    // Act
    dynamicEntityRemoteService2.nonTransactionalInspect(new PersistencePackage());
  }

  /**
   * Test
   * {@link DynamicEntityRemoteService#fetch(PersistencePackage, CriteriaTransferObject)}.
   * <p>
   * Method under test:
   * {@link DynamicEntityRemoteService#fetch(PersistencePackage, CriteriaTransferObject)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testFetch() throws ServiceException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass141 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.service.DynamicEntityRemoteService dynamicEntityRemoteService;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    DynamicEntityRemoteService dynamicEntityRemoteService2 = new DynamicEntityRemoteService();
    PersistencePackage persistencePackage = new PersistencePackage();

    // Act
    dynamicEntityRemoteService2.fetch(persistencePackage, new CriteriaTransferObject());
  }

  /**
   * Test
   * {@link DynamicEntityRemoteService#nonTransactionalFetch(PersistencePackage, CriteriaTransferObject)}.
   * <p>
   * Method under test:
   * {@link DynamicEntityRemoteService#nonTransactionalFetch(PersistencePackage, CriteriaTransferObject)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testNonTransactionalFetch() throws ServiceException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass255 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.service.DynamicEntityRemoteService dynamicEntityRemoteService;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    DynamicEntityRemoteService dynamicEntityRemoteService2 = new DynamicEntityRemoteService();
    PersistencePackage persistencePackage = new PersistencePackage();

    // Act
    dynamicEntityRemoteService2.nonTransactionalFetch(persistencePackage, new CriteriaTransferObject());
  }

  /**
   * Test {@link DynamicEntityRemoteService#cleanEntity(Entity)}.
   * <p>
   * Method under test: {@link DynamicEntityRemoteService#cleanEntity(Entity)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testCleanEntity() throws ServiceException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass120 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.service.DynamicEntityRemoteService dynamicEntityRemoteService;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    DynamicEntityRemoteService dynamicEntityRemoteService2 = new DynamicEntityRemoteService();

    // Act
    dynamicEntityRemoteService2.cleanEntity(new Entity());
  }

  /**
   * Test {@link DynamicEntityRemoteService#cleanEntity(Entity)}.
   * <ul>
   *   <li>Given empty array of {@link Property}.</li>
   *   <li>Then calls {@link Entity#getProperties()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DynamicEntityRemoteService#cleanEntity(Entity)}
   */
  @Test
  public void testCleanEntity_givenEmptyArrayOfProperty_thenCallsGetProperties() throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DynamicEntityRemoteService dynamicEntityRemoteService = new DynamicEntityRemoteService();
    Entity entity = mock(Entity.class);
    when(entity.getProperties()).thenReturn(new Property[]{});

    // Act
    dynamicEntityRemoteService.cleanEntity(entity);

    // Assert
    verify(entity).getProperties();
  }

  /**
   * Test {@link DynamicEntityRemoteService#add(PersistencePackage)}.
   * <p>
   * Method under test: {@link DynamicEntityRemoteService#add(PersistencePackage)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testAdd() throws ServiceException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass96 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.service.DynamicEntityRemoteService dynamicEntityRemoteService;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    DynamicEntityRemoteService dynamicEntityRemoteService2 = new DynamicEntityRemoteService();

    // Act
    dynamicEntityRemoteService2.add(new PersistencePackage());
  }

  /**
   * Test {@link DynamicEntityRemoteService#update(PersistencePackage)}.
   * <p>
   * Method under test:
   * {@link DynamicEntityRemoteService#update(PersistencePackage)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testUpdate() throws ServiceException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass542 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.service.DynamicEntityRemoteService dynamicEntityRemoteService;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    DynamicEntityRemoteService dynamicEntityRemoteService2 = new DynamicEntityRemoteService();

    // Act
    dynamicEntityRemoteService2.update(new PersistencePackage());
  }

  /**
   * Test {@link DynamicEntityRemoteService#remove(PersistencePackage)}.
   * <p>
   * Method under test:
   * {@link DynamicEntityRemoteService#remove(PersistencePackage)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testRemove() throws ServiceException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass518 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.service.DynamicEntityRemoteService dynamicEntityRemoteService;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    DynamicEntityRemoteService dynamicEntityRemoteService2 = new DynamicEntityRemoteService();

    // Act
    dynamicEntityRemoteService2.remove(new PersistencePackage());
  }

  /**
   * Test
   * {@link DynamicEntityRemoteService#nonTransactionalAdd(PersistencePackage)}.
   * <p>
   * Method under test:
   * {@link DynamicEntityRemoteService#nonTransactionalAdd(PersistencePackage)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testNonTransactionalAdd() throws ServiceException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass231 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.service.DynamicEntityRemoteService dynamicEntityRemoteService;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    DynamicEntityRemoteService dynamicEntityRemoteService2 = new DynamicEntityRemoteService();

    // Act
    dynamicEntityRemoteService2.nonTransactionalAdd(new PersistencePackage());
  }

  /**
   * Test
   * {@link DynamicEntityRemoteService#nonTransactionalUpdate(PersistencePackage)}.
   * <p>
   * Method under test:
   * {@link DynamicEntityRemoteService#nonTransactionalUpdate(PersistencePackage)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testNonTransactionalUpdate() throws ServiceException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass343 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.service.DynamicEntityRemoteService dynamicEntityRemoteService;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    DynamicEntityRemoteService dynamicEntityRemoteService2 = new DynamicEntityRemoteService();

    // Act
    dynamicEntityRemoteService2.nonTransactionalUpdate(new PersistencePackage());
  }

  /**
   * Test
   * {@link DynamicEntityRemoteService#nonTransactionalRemove(PersistencePackage)}.
   * <p>
   * Method under test:
   * {@link DynamicEntityRemoteService#nonTransactionalRemove(PersistencePackage)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testNonTransactionalRemove() throws ServiceException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass319 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.service.DynamicEntityRemoteService dynamicEntityRemoteService;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    DynamicEntityRemoteService dynamicEntityRemoteService2 = new DynamicEntityRemoteService();

    // Act
    dynamicEntityRemoteService2.nonTransactionalRemove(new PersistencePackage());
  }

  /**
   * Test {@link DynamicEntityRemoteService#isShouldClean()}.
   * <p>
   * Method under test: {@link DynamicEntityRemoteService#isShouldClean()}
   */
  @Test
  public void testIsShouldClean() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new DynamicEntityRemoteService()).isShouldClean());
  }

  /**
   * Test {@link DynamicEntityRemoteService#isShouldClean()}.
   * <p>
   * Method under test: {@link DynamicEntityRemoteService#isShouldClean()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testIsShouldClean2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass229 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.service.DynamicEntityRemoteService dynamicEntityRemoteService;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new DynamicEntityRemoteService()).isShouldClean();
  }

  /**
   * Test
   * {@link DynamicEntityRemoteService#identifyTransactionManager(PersistencePackage)}.
   * <p>
   * Method under test:
   * {@link DynamicEntityRemoteService#identifyTransactionManager(PersistencePackage)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testIdentifyTransactionManager() throws ServiceException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass181 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.service.DynamicEntityRemoteService dynamicEntityRemoteService;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    DynamicEntityRemoteService dynamicEntityRemoteService2 = new DynamicEntityRemoteService();

    // Act
    dynamicEntityRemoteService2.identifyTransactionManager(new PersistencePackage());
  }
}
