package org.broadleafcommerce.openadmin.server.service.persistence;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.broadleafcommerce.common.exception.NoPossibleResultsException;
import org.broadleafcommerce.common.exception.ServiceException;
import org.broadleafcommerce.common.persistence.TargetModeType;
import org.broadleafcommerce.common.presentation.client.OperationType;
import org.broadleafcommerce.openadmin.dto.ClassMetadata;
import org.broadleafcommerce.openadmin.dto.ClassTree;
import org.broadleafcommerce.openadmin.dto.CriteriaTransferObject;
import org.broadleafcommerce.openadmin.dto.DynamicResultSet;
import org.broadleafcommerce.openadmin.dto.Entity;
import org.broadleafcommerce.openadmin.dto.PersistencePackage;
import org.broadleafcommerce.openadmin.dto.PersistencePerspective;
import org.broadleafcommerce.openadmin.dto.Property;
import org.broadleafcommerce.openadmin.dto.SectionCrumb;
import org.broadleafcommerce.openadmin.server.dao.DynamicEntityDao;
import org.broadleafcommerce.openadmin.server.dao.DynamicEntityDaoImpl;
import org.broadleafcommerce.openadmin.server.security.remote.AdminSecurityServiceRemote;
import org.broadleafcommerce.openadmin.server.security.remote.SecurityVerifier;
import org.broadleafcommerce.openadmin.server.service.handler.CustomPersistenceHandlerFilter;
import org.broadleafcommerce.openadmin.server.service.persistence.module.AdornedTargetListPersistenceModule;
import org.broadleafcommerce.openadmin.server.service.persistence.module.BasicPersistenceModule;
import org.broadleafcommerce.openadmin.server.service.persistence.module.PersistenceModule;
import org.broadleafcommerce.openadmin.server.service.type.ChangeType;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.reactive.context.AnnotationConfigReactiveWebApplicationContext;
import org.springframework.context.ApplicationContext;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml",
    "/bl-open-admin-applicationContext-entity.xml", "/bl-open-admin-contentClient-applicationContext.xml",
    "/bl-open-admin-contentCreator-applicationContext.xml",
    "/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml",
    "/blc-config/admin/framework/bl-open-admin-applicationContext.xml",
    "/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class PersistenceManagerImplDiffblueTest {
  @Autowired
  private PersistenceManagerImpl persistenceManagerImpl;

  /**
   * Test
   * {@link PersistenceManagerImpl#getAllPolymorphicEntitiesFromCeiling(Class)}.
   * <p>
   * Method under test:
   * {@link PersistenceManagerImpl#getAllPolymorphicEntitiesFromCeiling(Class)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetAllPolymorphicEntitiesFromCeiling() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.service.persistence;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass5314 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.service.persistence.PersistenceManagerImpl persistenceManagerImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    PersistenceManagerImpl persistenceManagerImpl2 = new PersistenceManagerImpl();
    Class<Object> ceilingClass = Object.class;

    // Act
    persistenceManagerImpl2.getAllPolymorphicEntitiesFromCeiling(ceilingClass);
  }

  /**
   * Test
   * {@link PersistenceManagerImpl#getAllPolymorphicEntitiesFromCeiling(Class)}.
   * <ul>
   *   <li>Then return array length is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PersistenceManagerImpl#getAllPolymorphicEntitiesFromCeiling(Class)}
   */
  @Test
  public void testGetAllPolymorphicEntitiesFromCeiling_thenReturnArrayLengthIsOne() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DynamicEntityDao dynamicEntityDao = mock(DynamicEntityDao.class);
    Class<Object> forNameResult = Object.class;
    when(dynamicEntityDao.getAllPolymorphicEntitiesFromCeiling(Mockito.<Class<Object>>any()))
        .thenReturn(new Class[]{forNameResult});

    PersistenceManagerImpl persistenceManagerImpl = new PersistenceManagerImpl();
    persistenceManagerImpl.setDynamicEntityDao(dynamicEntityDao);
    Class<Object> ceilingClass = Object.class;

    // Act
    Class<?>[] actualAllPolymorphicEntitiesFromCeiling = persistenceManagerImpl
        .getAllPolymorphicEntitiesFromCeiling(ceilingClass);

    // Assert
    verify(dynamicEntityDao).getAllPolymorphicEntitiesFromCeiling(isA(Class.class));
    assertEquals(1, actualAllPolymorphicEntitiesFromCeiling.length);
    Class<Object> expectedResultClass = Object.class;
    assertEquals(expectedResultClass, actualAllPolymorphicEntitiesFromCeiling[0]);
  }

  /**
   * Test
   * {@link PersistenceManagerImpl#getAllPolymorphicEntitiesFromCeiling(Class)}.
   * <ul>
   *   <li>Then return array length is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PersistenceManagerImpl#getAllPolymorphicEntitiesFromCeiling(Class)}
   */
  @Test
  public void testGetAllPolymorphicEntitiesFromCeiling_thenReturnArrayLengthIsZero() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PersistenceManagerImpl persistenceManagerImpl = new PersistenceManagerImpl();
    persistenceManagerImpl.setDynamicEntityDao(new DynamicEntityDaoImpl());
    Class<Object> ceilingClass = Object.class;

    // Act and Assert
    assertEquals(0, persistenceManagerImpl.getAllPolymorphicEntitiesFromCeiling(ceilingClass).length);
  }

  /**
   * Test
   * {@link PersistenceManagerImpl#buildClassMetadata(Class[], PersistencePackage, Map)}.
   * <p>
   * Method under test:
   * {@link PersistenceManagerImpl#buildClassMetadata(Class[], PersistencePackage, Map)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testBuildClassMetadata() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.service.persistence;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass4317 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.service.persistence.PersistenceManagerImpl persistenceManagerImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    PersistenceManagerImpl persistenceManagerImpl2 = new PersistenceManagerImpl();
    Class<Object> forNameResult = Object.class;
    PersistencePackage persistencePackage = new PersistencePackage();

    // Act
    persistenceManagerImpl2.buildClassMetadata(new Class[]{forNameResult}, persistencePackage, new HashMap<>());
  }

  /**
   * Test
   * {@link PersistenceManagerImpl#buildClassMetadata(Class[], PersistencePackage, Map)}.
   * <ul>
   *   <li>Then return CeilingType is {@code Dr Jane Doe}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PersistenceManagerImpl#buildClassMetadata(Class[], PersistencePackage, Map)}
   */
  @Test
  public void testBuildClassMetadata_thenReturnCeilingTypeIsDrJaneDoe() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DynamicEntityDao dynamicEntityDao = mock(DynamicEntityDao.class);
    when(dynamicEntityDao.getTabAndGroupMetadata(Mockito.<Class<Object>[]>any(), Mockito.<ClassMetadata>any()))
        .thenReturn(new HashMap<>());
    ClassTree classTree = new ClassTree();
    when(dynamicEntityDao.getClassTree(Mockito.<Class<Object>[]>any())).thenReturn(classTree);

    PersistenceManagerImpl persistenceManagerImpl = new PersistenceManagerImpl();
    persistenceManagerImpl.setModules(new PersistenceModule[]{new AdornedTargetListPersistenceModule()});
    persistenceManagerImpl.setDynamicEntityDao(dynamicEntityDao);
    Class<Object> forNameResult = Object.class;
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getCeilingEntityFullyQualifiedClassname()).thenReturn("Dr Jane Doe");
    when(persistencePackage.getSecurityCeilingEntityFullyQualifiedClassname()).thenReturn("Dr Jane Doe");

    // Act
    ClassMetadata actualBuildClassMetadataResult = persistenceManagerImpl.buildClassMetadata(new Class[]{forNameResult},
        persistencePackage, new HashMap<>());

    // Assert
    verify(persistencePackage).getCeilingEntityFullyQualifiedClassname();
    verify(persistencePackage).getSecurityCeilingEntityFullyQualifiedClassname();
    verify(dynamicEntityDao).getClassTree(isA(Class[].class));
    verify(dynamicEntityDao).getTabAndGroupMetadata(isA(Class[].class), isA(ClassMetadata.class));
    assertEquals("Dr Jane Doe", actualBuildClassMetadataResult.getCeilingType());
    assertEquals("Dr Jane Doe", actualBuildClassMetadataResult.getSecurityCeilingType());
    assertEquals("GBP", actualBuildClassMetadataResult.getCurrencyCode());
    assertNull(actualBuildClassMetadataResult.getFirstTab());
    assertEquals(0, actualBuildClassMetadataResult.getGroupOptionsFromTabAndGroupMetadata().length);
    assertEquals(0, actualBuildClassMetadataResult.getProperties().length);
    assertTrue(actualBuildClassMetadataResult.getPMap().isEmpty());
    assertTrue(actualBuildClassMetadataResult.getTabAndGroupMetadata().isEmpty());
    assertSame(classTree, actualBuildClassMetadataResult.getPolymorphicEntities());
  }

  /**
   * Test
   * {@link PersistenceManagerImpl#buildClassMetadata(Class[], PersistencePackage, Map)}.
   * <ul>
   *   <li>Then throw {@link NoPossibleResultsException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PersistenceManagerImpl#buildClassMetadata(Class[], PersistencePackage, Map)}
   */
  @Test
  public void testBuildClassMetadata_thenThrowNoPossibleResultsException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DynamicEntityDao dynamicEntityDao = mock(DynamicEntityDao.class);
    when(dynamicEntityDao.getTabAndGroupMetadata(Mockito.<Class<Object>[]>any(), Mockito.<ClassMetadata>any()))
        .thenThrow(new NoPossibleResultsException("An error occurred"));
    when(dynamicEntityDao.getClassTree(Mockito.<Class<Object>[]>any())).thenReturn(new ClassTree());

    PersistenceManagerImpl persistenceManagerImpl = new PersistenceManagerImpl();
    persistenceManagerImpl.setModules(new PersistenceModule[]{new AdornedTargetListPersistenceModule()});
    persistenceManagerImpl.setDynamicEntityDao(dynamicEntityDao);
    Class<Object> forNameResult = Object.class;
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getCeilingEntityFullyQualifiedClassname()).thenReturn("Dr Jane Doe");
    when(persistencePackage.getSecurityCeilingEntityFullyQualifiedClassname()).thenReturn("Dr Jane Doe");

    // Act and Assert
    assertThrows(NoPossibleResultsException.class, () -> persistenceManagerImpl
        .buildClassMetadata(new Class[]{forNameResult}, persistencePackage, new HashMap<>()));
    verify(persistencePackage).getCeilingEntityFullyQualifiedClassname();
    verify(persistencePackage).getSecurityCeilingEntityFullyQualifiedClassname();
    verify(dynamicEntityDao).getClassTree(isA(Class[].class));
    verify(dynamicEntityDao).getTabAndGroupMetadata(isA(Class[].class), isA(ClassMetadata.class));
  }

  /**
   * Test
   * {@link PersistenceManagerImpl#executePostInspectHandlers(PersistencePackage, PersistenceResponse)}.
   * <p>
   * Method under test:
   * {@link PersistenceManagerImpl#executePostInspectHandlers(PersistencePackage, PersistenceResponse)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testExecutePostInspectHandlers() throws ServiceException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.service.persistence;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass5113 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.service.persistence.PersistenceManagerImpl persistenceManagerImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    PersistenceManagerImpl persistenceManagerImpl2 = new PersistenceManagerImpl();
    PersistencePackage persistencePackage = new PersistencePackage();

    // Act
    persistenceManagerImpl2.executePostInspectHandlers(persistencePackage, new PersistenceResponse());
  }

  /**
   * Test
   * {@link PersistenceManagerImpl#fetch(PersistencePackage, CriteriaTransferObject)}.
   * <p>
   * Method under test:
   * {@link PersistenceManagerImpl#fetch(PersistencePackage, CriteriaTransferObject)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testFetch() throws ServiceException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.service.persistence;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass5265 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.service.persistence.PersistenceManagerImpl persistenceManagerImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    PersistenceManagerImpl persistenceManagerImpl2 = new PersistenceManagerImpl();
    PersistencePackage persistencePackage = new PersistencePackage();

    // Act
    persistenceManagerImpl2.fetch(persistencePackage, new CriteriaTransferObject());
  }

  /**
   * Test
   * {@link PersistenceManagerImpl#executePostFetchHandlers(PersistencePackage, CriteriaTransferObject, PersistenceResponse)}.
   * <p>
   * Method under test:
   * {@link PersistenceManagerImpl#executePostFetchHandlers(PersistencePackage, CriteriaTransferObject, PersistenceResponse)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testExecutePostFetchHandlers() throws ServiceException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.service.persistence;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass5059 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.service.persistence.PersistenceManagerImpl persistenceManagerImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    PersistenceManagerImpl persistenceManagerImpl2 = new PersistenceManagerImpl();
    PersistencePackage persistencePackage = new PersistencePackage();
    CriteriaTransferObject cto = new CriteriaTransferObject();

    // Act
    persistenceManagerImpl2.executePostFetchHandlers(persistencePackage, cto, new PersistenceResponse());
  }

  /**
   * Test
   * {@link PersistenceManagerImpl#executePostFetchHandlers(PersistencePackage, CriteriaTransferObject, PersistenceResponse)}.
   * <ul>
   *   <li>Then throw {@link NoPossibleResultsException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PersistenceManagerImpl#executePostFetchHandlers(PersistencePackage, CriteriaTransferObject, PersistenceResponse)}
   */
  @Test
  public void testExecutePostFetchHandlers_thenThrowNoPossibleResultsException() throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PersistenceManagerImpl persistenceManagerImpl = new PersistenceManagerImpl();
    PersistencePerspective persistencePerspective = mock(PersistencePerspective.class);
    when(persistencePerspective.getPersistencePerspectiveItems()).thenReturn(new HashMap<>());

    SectionCrumb sectionCrumb = new SectionCrumb();
    sectionCrumb.setOriginalSectionIdentifier("42");
    sectionCrumb.setSectionId("42");
    sectionCrumb.setSectionIdentifier("42");

    PersistencePackage persistencePackage = new PersistencePackage();
    persistencePackage.setSectionCrumbs(new SectionCrumb[]{sectionCrumb});
    persistencePackage.setPersistencePerspective(persistencePerspective);
    CriteriaTransferObject cto = new CriteriaTransferObject();
    DynamicResultSet dynamicResultSet = mock(DynamicResultSet.class);
    when(dynamicResultSet.getRecords()).thenThrow(new NoPossibleResultsException("An error occurred"));
    PersistenceResponse persistenceResponse = mock(PersistenceResponse.class);
    when(persistenceResponse.getDynamicResultSet()).thenReturn(dynamicResultSet);

    // Act and Assert
    assertThrows(NoPossibleResultsException.class,
        () -> persistenceManagerImpl.executePostFetchHandlers(persistencePackage, cto, persistenceResponse));
    verify(dynamicResultSet).getRecords();
    verify(persistencePerspective).getPersistencePerspectiveItems();
    verify(persistenceResponse).getDynamicResultSet();
  }

  /**
   * Test {@link PersistenceManagerImpl#add(PersistencePackage)}.
   * <p>
   * Method under test: {@link PersistenceManagerImpl#add(PersistencePackage)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testAdd() throws ServiceException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.service.persistence;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass4284 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.service.persistence.PersistenceManagerImpl persistenceManagerImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    PersistenceManagerImpl persistenceManagerImpl2 = new PersistenceManagerImpl();

    // Act
    persistenceManagerImpl2.add(new PersistencePackage());
  }

  /**
   * Test
   * {@link PersistenceManagerImpl#executeValidationProcessors(PersistencePackage, PersistenceResponse)}.
   * <p>
   * Method under test:
   * {@link PersistenceManagerImpl#executeValidationProcessors(PersistencePackage, PersistenceResponse)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testExecuteValidationProcessors() throws ServiceException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.service.persistence;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass5227 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.service.persistence.PersistenceManagerImpl persistenceManagerImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    PersistenceManagerImpl persistenceManagerImpl2 = new PersistenceManagerImpl();
    PersistencePackage persistencePackage = new PersistencePackage();

    // Act
    persistenceManagerImpl2.executeValidationProcessors(persistencePackage, new PersistenceResponse());
  }

  /**
   * Test
   * {@link PersistenceManagerImpl#executePostAddHandlers(PersistencePackage, PersistenceResponse)}.
   * <p>
   * Method under test:
   * {@link PersistenceManagerImpl#executePostAddHandlers(PersistencePackage, PersistenceResponse)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testExecutePostAddHandlers() throws ServiceException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.service.persistence;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass5021 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.service.persistence.PersistenceManagerImpl persistenceManagerImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    PersistenceManagerImpl persistenceManagerImpl2 = new PersistenceManagerImpl();
    PersistencePackage persistencePackage = new PersistencePackage();

    // Act
    persistenceManagerImpl2.executePostAddHandlers(persistencePackage, new PersistenceResponse());
  }

  /**
   * Test
   * {@link PersistenceManagerImpl#executePostAddHandlers(PersistencePackage, PersistenceResponse)}.
   * <ul>
   *   <li>Then throw {@link NoPossibleResultsException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PersistenceManagerImpl#executePostAddHandlers(PersistencePackage, PersistenceResponse)}
   */
  @Test
  public void testExecutePostAddHandlers_thenThrowNoPossibleResultsException() throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DynamicEntityDaoImpl dynamicEntityDao = mock(DynamicEntityDaoImpl.class);
    doNothing().when(dynamicEntityDao).flush();

    PersistenceManagerImpl persistenceManagerImpl = new PersistenceManagerImpl();
    persistenceManagerImpl.setDynamicEntityDao(dynamicEntityDao);
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getRequestingEntityName()).thenReturn("");
    Property property = mock(Property.class);
    when(property.getValue()).thenThrow(new NoPossibleResultsException("An error occurred"));

    HashMap<String, Property> stringPropertyMap = new HashMap<>();
    stringPropertyMap.put("__adminMainEntity", property);
    Entity entity = mock(Entity.class);
    when(entity.getPMap()).thenReturn(stringPropertyMap);
    PersistenceResponse persistenceResponse = mock(PersistenceResponse.class);
    when(persistenceResponse.getEntity()).thenReturn(entity);

    // Act and Assert
    assertThrows(NoPossibleResultsException.class,
        () -> persistenceManagerImpl.executePostAddHandlers(persistencePackage, persistenceResponse));
    verify(entity).getPMap();
    verify(persistencePackage).getRequestingEntityName();
    verify(property).getValue();
    verify(dynamicEntityDao).flush();
    verify(persistenceResponse).getEntity();
  }

  /**
   * Test
   * {@link PersistenceManagerImpl#executeDeferredOperations(PersistencePackage)}.
   * <p>
   * Method under test:
   * {@link PersistenceManagerImpl#executeDeferredOperations(PersistencePackage)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testExecuteDeferredOperations() throws ServiceException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.service.persistence;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass4988 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.service.persistence.PersistenceManagerImpl persistenceManagerImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    PersistenceManagerImpl persistenceManagerImpl2 = new PersistenceManagerImpl();

    // Act
    persistenceManagerImpl2.executeDeferredOperations(new PersistencePackage());
  }

  /**
   * Test
   * {@link PersistenceManagerImpl#executeDeferredOperations(PersistencePackage)}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@code ADD} is
   * {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PersistenceManagerImpl#executeDeferredOperations(PersistencePackage)}
   */
  @Test
  public void testExecuteDeferredOperations_givenHashMapAddIsArrayList() throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PersistenceManagerImpl persistenceManagerImpl = new PersistenceManagerImpl();

    HashMap<ChangeType, List<PersistencePackage>> changeTypeListMap = new HashMap<>();
    changeTypeListMap.put(ChangeType.ADD, new ArrayList<>());
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getDeferredOperations()).thenReturn(changeTypeListMap);
    when(persistencePackage.getSubPackages()).thenReturn(new HashMap<>());

    // Act
    persistenceManagerImpl.executeDeferredOperations(persistencePackage);

    // Assert
    verify(persistencePackage, atLeast(1)).getDeferredOperations();
    verify(persistencePackage).getSubPackages();
  }

  /**
   * Test
   * {@link PersistenceManagerImpl#executeDeferredOperations(PersistencePackage)}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()}.</li>
   *   <li>Then calls {@link PersistencePackage#getDeferredOperations()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PersistenceManagerImpl#executeDeferredOperations(PersistencePackage)}
   */
  @Test
  public void testExecuteDeferredOperations_givenHashMap_thenCallsGetDeferredOperations() throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PersistenceManagerImpl persistenceManagerImpl = new PersistenceManagerImpl();
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getDeferredOperations()).thenReturn(new HashMap<>());
    when(persistencePackage.getSubPackages()).thenReturn(new HashMap<>());

    // Act
    persistenceManagerImpl.executeDeferredOperations(persistencePackage);

    // Assert
    verify(persistencePackage).getDeferredOperations();
    verify(persistencePackage).getSubPackages();
  }

  /**
   * Test
   * {@link PersistenceManagerImpl#executeDeferredOperations(PersistencePackage)}.
   * <ul>
   *   <li>Then calls {@link PersistencePackage#getDeferredOperations()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PersistenceManagerImpl#executeDeferredOperations(PersistencePackage)}
   */
  @Test
  public void testExecuteDeferredOperations_thenCallsGetDeferredOperations() throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PersistenceManagerImpl persistenceManagerImpl = new PersistenceManagerImpl();

    HashMap<String, PersistencePackage> stringPersistencePackageMap = new HashMap<>();
    stringPersistencePackageMap.put("foo", new PersistencePackage());
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getDeferredOperations()).thenReturn(new HashMap<>());
    when(persistencePackage.getSubPackages()).thenReturn(stringPersistencePackageMap);

    // Act
    persistenceManagerImpl.executeDeferredOperations(persistencePackage);

    // Assert
    verify(persistencePackage).getDeferredOperations();
    verify(persistencePackage).getSubPackages();
  }

  /**
   * Test
   * {@link PersistenceManagerImpl#executePostUpdateHandlers(PersistencePackage, PersistenceResponse)}.
   * <p>
   * Method under test:
   * {@link PersistenceManagerImpl#executePostUpdateHandlers(PersistencePackage, PersistenceResponse)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testExecutePostUpdateHandlers() throws ServiceException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.service.persistence;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass5189 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.service.persistence.PersistenceManagerImpl persistenceManagerImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    PersistenceManagerImpl persistenceManagerImpl2 = new PersistenceManagerImpl();
    PersistencePackage persistencePackage = new PersistencePackage();

    // Act
    persistenceManagerImpl2.executePostUpdateHandlers(persistencePackage, new PersistenceResponse());
  }

  /**
   * Test
   * {@link PersistenceManagerImpl#executePostUpdateHandlers(PersistencePackage, PersistenceResponse)}.
   * <ul>
   *   <li>Then throw {@link NoPossibleResultsException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PersistenceManagerImpl#executePostUpdateHandlers(PersistencePackage, PersistenceResponse)}
   */
  @Test
  public void testExecutePostUpdateHandlers_thenThrowNoPossibleResultsException() throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DynamicEntityDaoImpl dynamicEntityDao = mock(DynamicEntityDaoImpl.class);
    doNothing().when(dynamicEntityDao).flush();

    PersistenceManagerImpl persistenceManagerImpl = new PersistenceManagerImpl();
    persistenceManagerImpl.setDynamicEntityDao(dynamicEntityDao);
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getRequestingEntityName()).thenReturn("");
    Property property = mock(Property.class);
    when(property.getValue()).thenThrow(new NoPossibleResultsException("An error occurred"));

    HashMap<String, Property> stringPropertyMap = new HashMap<>();
    stringPropertyMap.put("__adminMainEntity", property);
    Entity entity = mock(Entity.class);
    when(entity.getPMap()).thenReturn(stringPropertyMap);
    PersistenceResponse persistenceResponse = mock(PersistenceResponse.class);
    when(persistenceResponse.getEntity()).thenReturn(entity);

    // Act and Assert
    assertThrows(NoPossibleResultsException.class,
        () -> persistenceManagerImpl.executePostUpdateHandlers(persistencePackage, persistenceResponse));
    verify(entity).getPMap();
    verify(persistencePackage).getRequestingEntityName();
    verify(property).getValue();
    verify(dynamicEntityDao).flush();
    verify(persistenceResponse).getEntity();
  }

  /**
   * Test
   * {@link PersistenceManagerImpl#executePostRemoveHandlers(PersistencePackage, PersistenceResponse)}.
   * <p>
   * Method under test:
   * {@link PersistenceManagerImpl#executePostRemoveHandlers(PersistencePackage, PersistenceResponse)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testExecutePostRemoveHandlers() throws ServiceException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.service.persistence;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass5151 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.service.persistence.PersistenceManagerImpl persistenceManagerImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    PersistenceManagerImpl persistenceManagerImpl2 = new PersistenceManagerImpl();
    PersistencePackage persistencePackage = new PersistencePackage();

    // Act
    persistenceManagerImpl2.executePostRemoveHandlers(persistencePackage, new PersistenceResponse());
  }

  /**
   * Test
   * {@link PersistenceManagerImpl#executePostRemoveHandlers(PersistencePackage, PersistenceResponse)}.
   * <ul>
   *   <li>Then throw {@link NoPossibleResultsException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PersistenceManagerImpl#executePostRemoveHandlers(PersistencePackage, PersistenceResponse)}
   */
  @Test
  public void testExecutePostRemoveHandlers_thenThrowNoPossibleResultsException() throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DynamicEntityDaoImpl dynamicEntityDao = mock(DynamicEntityDaoImpl.class);
    doNothing().when(dynamicEntityDao).flush();

    PersistenceManagerImpl persistenceManagerImpl = new PersistenceManagerImpl();
    persistenceManagerImpl.setDynamicEntityDao(dynamicEntityDao);
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getRequestingEntityName()).thenReturn("");
    Property property = mock(Property.class);
    when(property.getValue()).thenThrow(new NoPossibleResultsException("An error occurred"));

    HashMap<String, Property> stringPropertyMap = new HashMap<>();
    stringPropertyMap.put("__adminMainEntity", property);
    Entity entity = mock(Entity.class);
    when(entity.getPMap()).thenReturn(stringPropertyMap);
    PersistenceResponse persistenceResponse = mock(PersistenceResponse.class);
    when(persistenceResponse.getEntity()).thenReturn(entity);

    // Act and Assert
    assertThrows(NoPossibleResultsException.class,
        () -> persistenceManagerImpl.executePostRemoveHandlers(persistencePackage, persistenceResponse));
    verify(entity).getPMap();
    verify(persistencePackage).getRequestingEntityName();
    verify(property).getValue();
    verify(dynamicEntityDao).flush();
    verify(persistenceResponse).getEntity();
  }

  /**
   * Test {@link PersistenceManagerImpl#getCompatibleModule(OperationType)}.
   * <p>
   * Method under test:
   * {@link PersistenceManagerImpl#getCompatibleModule(OperationType)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetCompatibleModule() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.service.persistence;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass5638 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.service.persistence.PersistenceManagerImpl persistenceManagerImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new PersistenceManagerImpl()).getCompatibleModule(OperationType.NONDESTRUCTIVEREMOVE);
  }

  /**
   * Test {@link PersistenceManagerImpl#getCompatibleModule(OperationType)}.
   * <ul>
   *   <li>Then calls
   * {@link AdornedTargetListPersistenceModule#isCompatible(OperationType)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PersistenceManagerImpl#getCompatibleModule(OperationType)}
   */
  @Test
  public void testGetCompatibleModule_thenCallsIsCompatible() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdornedTargetListPersistenceModule adornedTargetListPersistenceModule = mock(
        AdornedTargetListPersistenceModule.class);
    when(adornedTargetListPersistenceModule.isCompatible(Mockito.<OperationType>any())).thenReturn(true);

    PersistenceManagerImpl persistenceManagerImpl = new PersistenceManagerImpl();
    persistenceManagerImpl.setModules(new PersistenceModule[]{adornedTargetListPersistenceModule});

    // Act
    persistenceManagerImpl.getCompatibleModule(OperationType.NONDESTRUCTIVEREMOVE);

    // Assert
    verify(adornedTargetListPersistenceModule).isCompatible(eq(OperationType.NONDESTRUCTIVEREMOVE));
  }

  /**
   * Test {@link PersistenceManagerImpl#getCompatibleModule(OperationType)}.
   * <ul>
   *   <li>Then return {@link BasicPersistenceModule} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PersistenceManagerImpl#getCompatibleModule(OperationType)}
   */
  @Test
  public void testGetCompatibleModule_thenReturnBasicPersistenceModule() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PersistenceManagerImpl persistenceManagerImpl = new PersistenceManagerImpl();
    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    persistenceManagerImpl.setModules(new PersistenceModule[]{basicPersistenceModule});

    // Act and Assert
    assertSame(basicPersistenceModule, persistenceManagerImpl.getCompatibleModule(OperationType.NONDESTRUCTIVEREMOVE));
  }

  /**
   * Test {@link PersistenceManagerImpl#getCompatibleModule(OperationType)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PersistenceManagerImpl#getCompatibleModule(OperationType)}
   */
  @Test
  public void testGetCompatibleModule_thenThrowRuntimeException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PersistenceManagerImpl persistenceManagerImpl = new PersistenceManagerImpl();
    persistenceManagerImpl.setModules(new PersistenceModule[]{new AdornedTargetListPersistenceModule()});

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> persistenceManagerImpl.getCompatibleModule(OperationType.NONDESTRUCTIVEREMOVE));
  }

  /**
   * Test
   * {@link PersistenceManagerImpl#configureDynamicEntityDao(Class, TargetModeType)}.
   * <p>
   * Method under test:
   * {@link PersistenceManagerImpl#configureDynamicEntityDao(Class, TargetModeType)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testConfigureDynamicEntityDao() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.service.persistence;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass4662 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.service.persistence.PersistenceManagerImpl persistenceManagerImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    PersistenceManagerImpl persistenceManagerImpl2 = new PersistenceManagerImpl();
    Class<Object> entityClass = Object.class;

    // Act
    persistenceManagerImpl2.configureDynamicEntityDao(entityClass, new TargetModeType("Type", "Friendly Type"));
  }

  /**
   * Test
   * {@link PersistenceManagerImpl#configureDefaultDynamicEntityDao(TargetModeType)}.
   * <p>
   * Method under test:
   * {@link PersistenceManagerImpl#configureDefaultDynamicEntityDao(TargetModeType)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testConfigureDefaultDynamicEntityDao() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.service.persistence;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass4645 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.service.persistence.PersistenceManagerImpl persistenceManagerImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    PersistenceManagerImpl persistenceManagerImpl2 = new PersistenceManagerImpl();

    // Act
    persistenceManagerImpl2.configureDefaultDynamicEntityDao(new TargetModeType("Type", "Friendly Type"));
  }

  /**
   * Test {@link PersistenceManagerImpl#getDefaultEntityManager(TargetModeType)}.
   * <p>
   * Method under test:
   * {@link PersistenceManagerImpl#getDefaultEntityManager(TargetModeType)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetDefaultEntityManager() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.service.persistence;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass5663 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.service.persistence.PersistenceManagerImpl persistenceManagerImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    PersistenceManagerImpl persistenceManagerImpl2 = new PersistenceManagerImpl();

    // Act
    persistenceManagerImpl2.getDefaultEntityManager(new TargetModeType("Type", "Friendly Type"));
  }

  /**
   * Test {@link PersistenceManagerImpl#getCustomPersistenceHandlers()}.
   * <p>
   * Method under test:
   * {@link PersistenceManagerImpl#getCustomPersistenceHandlers()}
   */
  @Test
  public void testGetCustomPersistenceHandlers() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PersistenceManagerImpl persistenceManagerImpl = new PersistenceManagerImpl();
    persistenceManagerImpl.setCustomPersistenceHandlerFilters(null);

    // Act and Assert
    assertTrue(persistenceManagerImpl.getCustomPersistenceHandlers().isEmpty());
  }

  /**
   * Test {@link PersistenceManagerImpl#getCustomPersistenceHandlers()}.
   * <p>
   * Method under test:
   * {@link PersistenceManagerImpl#getCustomPersistenceHandlers()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetCustomPersistenceHandlers2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.service.persistence;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass5652 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.service.persistence.PersistenceManagerImpl persistenceManagerImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new PersistenceManagerImpl()).getCustomPersistenceHandlers();
  }

  /**
   * Test {@link PersistenceManagerImpl#getCustomPersistenceHandlers()}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add
   * {@link CustomPersistenceHandlerFilter}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PersistenceManagerImpl#getCustomPersistenceHandlers()}
   */
  @Test
  public void testGetCustomPersistenceHandlers_givenArrayListAddCustomPersistenceHandlerFilter() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ArrayList<CustomPersistenceHandlerFilter> customPersistenceHandlerFilters = new ArrayList<>();
    customPersistenceHandlerFilters.add(mock(CustomPersistenceHandlerFilter.class));

    PersistenceManagerImpl persistenceManagerImpl = new PersistenceManagerImpl();
    persistenceManagerImpl.setCustomPersistenceHandlerFilters(customPersistenceHandlerFilters);

    // Act and Assert
    assertTrue(persistenceManagerImpl.getCustomPersistenceHandlers().isEmpty());
  }

  /**
   * Test {@link PersistenceManagerImpl#getCustomPersistenceHandlers()}.
   * <ul>
   *   <li>Given {@link PersistenceManagerImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PersistenceManagerImpl#getCustomPersistenceHandlers()}
   */
  @Test
  public void testGetCustomPersistenceHandlers_givenPersistenceManagerImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new PersistenceManagerImpl()).getCustomPersistenceHandlers().isEmpty());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>
   * {@link PersistenceManagerImpl#setAdminRemoteSecurityService(AdminSecurityServiceRemote)}
   *   <li>{@link PersistenceManagerImpl#setApplicationContext(ApplicationContext)}
   *   <li>{@link PersistenceManagerImpl#setCustomPersistenceHandlerFilters(List)}
   *   <li>{@link PersistenceManagerImpl#setCustomPersistenceHandlers(List)}
   *   <li>{@link PersistenceManagerImpl#setDynamicEntityDao(DynamicEntityDao)}
   *   <li>{@link PersistenceManagerImpl#setModules(PersistenceModule[])}
   *   <li>{@link PersistenceManagerImpl#setTargetMode(TargetModeType)}
   *   <li>{@link PersistenceManagerImpl#getAdminRemoteSecurityService()}
   *   <li>{@link PersistenceManagerImpl#getCustomPersistenceHandlerFilters()}
   *   <li>{@link PersistenceManagerImpl#getDynamicEntityDao()}
   *   <li>{@link PersistenceManagerImpl#getModules()}
   *   <li>{@link PersistenceManagerImpl#getTargetMode()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() throws BeansException {
    // Arrange
    PersistenceManagerImpl persistenceManagerImpl = new PersistenceManagerImpl();
    AdminSecurityServiceRemote adminRemoteSecurityService = new AdminSecurityServiceRemote();

    // Act
    persistenceManagerImpl.setAdminRemoteSecurityService(adminRemoteSecurityService);
    persistenceManagerImpl.setApplicationContext(new AnnotationConfigReactiveWebApplicationContext());
    ArrayList<CustomPersistenceHandlerFilter> customPersistenceHandlerFilters = new ArrayList<>();
    persistenceManagerImpl.setCustomPersistenceHandlerFilters(customPersistenceHandlerFilters);
    persistenceManagerImpl.setCustomPersistenceHandlers(new ArrayList<>());
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();
    persistenceManagerImpl.setDynamicEntityDao(dynamicEntityDao);
    PersistenceModule[] modules = new PersistenceModule[]{new AdornedTargetListPersistenceModule()};
    persistenceManagerImpl.setModules(modules);
    TargetModeType targetMode = new TargetModeType("Type", "Friendly Type");

    persistenceManagerImpl.setTargetMode(targetMode);
    SecurityVerifier actualAdminRemoteSecurityService = persistenceManagerImpl.getAdminRemoteSecurityService();
    List<CustomPersistenceHandlerFilter> actualCustomPersistenceHandlerFilters = persistenceManagerImpl
        .getCustomPersistenceHandlerFilters();
    DynamicEntityDao actualDynamicEntityDao = persistenceManagerImpl.getDynamicEntityDao();
    PersistenceModule[] actualModules = persistenceManagerImpl.getModules();
    TargetModeType actualTargetMode = persistenceManagerImpl.getTargetMode();

    // Assert that nothing has changed
    assertTrue(actualCustomPersistenceHandlerFilters.isEmpty());
    assertSame(customPersistenceHandlerFilters, actualCustomPersistenceHandlerFilters);
    assertSame(targetMode, actualTargetMode);
    assertSame(dynamicEntityDao, actualDynamicEntityDao);
    assertSame(adminRemoteSecurityService, actualAdminRemoteSecurityService);
    assertSame(modules, actualModules);
  }
}
