package org.broadleafcommerce.openadmin.server.service.persistence.module.criteria;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.mock;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.broadleafcommerce.common.exception.NoPossibleResultsException;
import org.broadleafcommerce.openadmin.dto.ClassTree;
import org.broadleafcommerce.openadmin.server.dao.DynamicEntityDao;
import org.broadleafcommerce.openadmin.server.dao.DynamicEntityDaoImpl;
import org.hibernate.boot.internal.BootstrapContextImpl;
import org.hibernate.boot.internal.InFlightMetadataCollectorImpl;
import org.hibernate.boot.internal.MetadataBuilderImpl;
import org.hibernate.boot.internal.MetadataBuildingContextRootImpl;
import org.hibernate.boot.spi.AbstractDelegatingSessionFactoryOptions;
import org.hibernate.engine.query.spi.QueryPlanCache;
import org.hibernate.engine.spi.SessionDelegatorBaseImpl;
import org.hibernate.engine.spi.SessionFactoryDelegatingImpl;
import org.hibernate.internal.SessionFactoryImpl;
import org.hibernate.mapping.RootClass;
import org.hibernate.metamodel.model.domain.internal.EntityTypeImpl;
import org.hibernate.metamodel.model.domain.internal.MappedSuperclassTypeImpl;
import org.hibernate.procedure.internal.ProcedureCallImpl;
import org.hibernate.query.criteria.internal.CriteriaBuilderImpl;
import org.hibernate.query.criteria.internal.CriteriaQueryImpl;
import org.hibernate.query.criteria.internal.path.CollectionAttributeJoin;
import org.hibernate.query.criteria.internal.path.ListAttributeJoin;
import org.hibernate.query.criteria.internal.path.RootImpl;
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
public class CriteriaTranslatorImplDiffblueTest {
  @Autowired
  private CriteriaTranslatorImpl criteriaTranslatorImpl;

  /**
   * Test
   * {@link CriteriaTranslatorImpl#translateCountQuery(DynamicEntityDao, String, List)}.
   * <p>
   * Method under test:
   * {@link CriteriaTranslatorImpl#translateCountQuery(DynamicEntityDao, String, List)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testTranslateCountQuery() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.service.persistence.module.criteria;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass4873 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.service.persistence.module.criteria.CriteriaTranslatorImpl criteriaTranslatorImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    CriteriaTranslatorImpl criteriaTranslatorImpl2 = new CriteriaTranslatorImpl();
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    // Act
    criteriaTranslatorImpl2.translateCountQuery(dynamicEntityDao, "Ceiling Entity", new ArrayList<>());
  }

  /**
   * Test
   * {@link CriteriaTranslatorImpl#translateMaxQuery(DynamicEntityDao, String, List, String)}.
   * <p>
   * Method under test:
   * {@link CriteriaTranslatorImpl#translateMaxQuery(DynamicEntityDao, String, List, String)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testTranslateMaxQuery() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.service.persistence.module.criteria;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass4902 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.service.persistence.module.criteria.CriteriaTranslatorImpl criteriaTranslatorImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    CriteriaTranslatorImpl criteriaTranslatorImpl2 = new CriteriaTranslatorImpl();
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    // Act
    criteriaTranslatorImpl2.translateMaxQuery(dynamicEntityDao, "Ceiling Entity", new ArrayList<>(), "Max Field");
  }

  /**
   * Test
   * {@link CriteriaTranslatorImpl#translateQuery(DynamicEntityDao, String, List, Integer, Integer)}.
   * <p>
   * Method under test:
   * {@link CriteriaTranslatorImpl#translateQuery(DynamicEntityDao, String, List, Integer, Integer)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testTranslateQuery() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.service.persistence.module.criteria;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass4941 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.service.persistence.module.criteria.CriteriaTranslatorImpl criteriaTranslatorImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    CriteriaTranslatorImpl criteriaTranslatorImpl2 = new CriteriaTranslatorImpl();
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    // Act
    criteriaTranslatorImpl2.translateQuery(dynamicEntityDao, "Ceiling Entity", new ArrayList<>(), 1, 3);
  }

  /**
   * Test
   * {@link CriteriaTranslatorImpl#determineRoot(DynamicEntityDao, Class, List)}.
   * <p>
   * Method under test:
   * {@link CriteriaTranslatorImpl#determineRoot(DynamicEntityDao, Class, List)}
   */
  @Test
  public void testDetermineRoot() throws NoPossibleResultsException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CriteriaTranslatorImpl criteriaTranslatorImpl = new CriteriaTranslatorImpl();
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();
    Class<Serializable> ceilingMarker = Serializable.class;

    // Act and Assert
    assertThrows(IllegalStateException.class,
        () -> criteriaTranslatorImpl.determineRoot(dynamicEntityDao, ceilingMarker, new ArrayList<>()));
  }

  /**
   * Test
   * {@link CriteriaTranslatorImpl#determineRoot(DynamicEntityDao, Class, List)}.
   * <p>
   * Method under test:
   * {@link CriteriaTranslatorImpl#determineRoot(DynamicEntityDao, Class, List)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testDetermineRoot2() throws NoPossibleResultsException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.service.persistence.module.criteria;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3898 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.service.persistence.module.criteria.CriteriaTranslatorImpl criteriaTranslatorImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    CriteriaTranslatorImpl criteriaTranslatorImpl2 = new CriteriaTranslatorImpl();
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();
    Class<Serializable> ceilingMarker = Serializable.class;

    // Act
    criteriaTranslatorImpl2.determineRoot(dynamicEntityDao, ceilingMarker, new ArrayList<>());
  }

  /**
   * Test
   * {@link CriteriaTranslatorImpl#determineRootInternal(ClassTree, List, Class)}.
   * <p>
   * Method under test:
   * {@link CriteriaTranslatorImpl#determineRootInternal(ClassTree, List, Class)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testDetermineRootInternal() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.service.persistence.module.criteria;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass4227 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.service.persistence.module.criteria.CriteriaTranslatorImpl criteriaTranslatorImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    CriteriaTranslatorImpl criteriaTranslatorImpl2 = new CriteriaTranslatorImpl();
    ClassTree root = new ClassTree();
    ArrayList<ClassTree> parents = new ArrayList<>();
    Class<Object> classToCheck = Object.class;

    // Act
    criteriaTranslatorImpl2.determineRootInternal(root, parents, classToCheck);
  }

  /**
   * Test
   * {@link CriteriaTranslatorImpl#constructQuery(DynamicEntityDao, String, List, boolean, boolean, Integer, Integer, String)}.
   * <p>
   * Method under test:
   * {@link CriteriaTranslatorImpl#constructQuery(DynamicEntityDao, String, List, boolean, boolean, Integer, Integer, String)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testConstructQuery() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.service.persistence.module.criteria;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3848 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.service.persistence.module.criteria.CriteriaTranslatorImpl criteriaTranslatorImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    CriteriaTranslatorImpl criteriaTranslatorImpl2 = new CriteriaTranslatorImpl();
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    // Act
    criteriaTranslatorImpl2.constructQuery(dynamicEntityDao, "Ceiling Entity", new ArrayList<>(), true, true, 1, 3,
        "Max Field");
  }

  /**
   * Test {@link CriteriaTranslatorImpl#addPaging(Query, Integer, Integer)}.
   * <p>
   * Method under test:
   * {@link CriteriaTranslatorImpl#addPaging(Query, Integer, Integer)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testAddPaging() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.service.persistence.module.criteria;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2883 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.service.persistence.module.criteria.CriteriaTranslatorImpl criteriaTranslatorImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    CriteriaTranslatorImpl criteriaTranslatorImpl2 = new CriteriaTranslatorImpl();
    SessionDelegatorBaseImpl delegate = new SessionDelegatorBaseImpl(null);

    // Act
    criteriaTranslatorImpl2.addPaging(new ProcedureCallImpl<>(
        new SessionDelegatorBaseImpl(delegate, new SessionDelegatorBaseImpl(null)), "Procedure Name"), 2, 3);
  }

  /**
   * Test
   * {@link CriteriaTranslatorImpl#addRestrictions(String, List, CriteriaBuilder, Root, List, List)}
   * with {@code ceilingEntity}, {@code filterMappings}, {@code criteriaBuilder},
   * {@code original}, {@code restrictions}, {@code sorts}.
   * <p>
   * Method under test:
   * {@link CriteriaTranslatorImpl#addRestrictions(String, List, CriteriaBuilder, Root, List, List)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testAddRestrictionsWithCeilingEntityFilterMappingsCriteriaBuilderOriginalRestrictionsSorts() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.service.persistence.module.criteria;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3039 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.service.persistence.module.criteria.CriteriaTranslatorImpl criteriaTranslatorImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    CriteriaTranslatorImpl criteriaTranslatorImpl2 = new CriteriaTranslatorImpl();
    ArrayList<FilterMapping> filterMappings = new ArrayList<>();
    BootstrapContextImpl bootstrapContext = new BootstrapContextImpl(null, null);

    InFlightMetadataCollectorImpl metadata = new InFlightMetadataCollectorImpl(bootstrapContext,
        new MetadataBuilderImpl.MetadataBuildingOptionsImpl(null));

    CriteriaBuilderImpl criteriaBuilder = new CriteriaBuilderImpl(new SessionFactoryImpl(metadata,
        new AbstractDelegatingSessionFactoryOptions(null), mock(QueryPlanCache.QueryPlanCreator.class)));
    InFlightMetadataCollectorImpl metadata2 = new InFlightMetadataCollectorImpl(null, null);

    CriteriaBuilderImpl criteriaBuilder2 = new CriteriaBuilderImpl(new SessionFactoryImpl(metadata2,
        new AbstractDelegatingSessionFactoryOptions(null), mock(QueryPlanCache.QueryPlanCreator.class)));
    Class<Object> javaType = Object.class;
    Class<Object> javaType2 = Object.class;
    MappedSuperclassTypeImpl superType = new MappedSuperclassTypeImpl(javaType2, null, null, null);

    RootClass persistentClass = new RootClass(new MetadataBuildingContextRootImpl(null, null, null));
    RootImpl original = new RootImpl(criteriaBuilder2,
        new EntityTypeImpl(javaType, superType, persistentClass, new SessionFactoryDelegatingImpl(null)));

    ArrayList<Predicate> restrictions = new ArrayList<>();

    // Act
    criteriaTranslatorImpl2.addRestrictions("Ceiling Entity", filterMappings, criteriaBuilder, original, restrictions,
        new ArrayList<>());
  }

  /**
   * Test
   * {@link CriteriaTranslatorImpl#addRestrictions(String, List, CriteriaBuilder, Root, List, List, CriteriaQuery)}
   * with {@code ceilingEntity}, {@code filterMappings}, {@code criteriaBuilder},
   * {@code original}, {@code restrictions}, {@code sorts}, {@code criteria}.
   * <p>
   * Method under test:
   * {@link CriteriaTranslatorImpl#addRestrictions(String, List, CriteriaBuilder, Root, List, List, CriteriaQuery)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testAddRestrictionsWithCeilingEntityFilterMappingsCriteriaBuilderOriginalRestrictionsSortsCriteria() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.service.persistence.module.criteria;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3304 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.service.persistence.module.criteria.CriteriaTranslatorImpl criteriaTranslatorImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    CriteriaTranslatorImpl criteriaTranslatorImpl2 = new CriteriaTranslatorImpl();
    ArrayList<FilterMapping> filterMappings = new ArrayList<>();
    BootstrapContextImpl bootstrapContext = new BootstrapContextImpl(null, null);

    InFlightMetadataCollectorImpl metadata = new InFlightMetadataCollectorImpl(bootstrapContext,
        new MetadataBuilderImpl.MetadataBuildingOptionsImpl(null));

    CriteriaBuilderImpl criteriaBuilder = new CriteriaBuilderImpl(new SessionFactoryImpl(metadata,
        new AbstractDelegatingSessionFactoryOptions(null), mock(QueryPlanCache.QueryPlanCreator.class)));
    InFlightMetadataCollectorImpl metadata2 = new InFlightMetadataCollectorImpl(null, null);

    CriteriaBuilderImpl criteriaBuilder2 = new CriteriaBuilderImpl(new SessionFactoryImpl(metadata2,
        new AbstractDelegatingSessionFactoryOptions(null), mock(QueryPlanCache.QueryPlanCreator.class)));
    Class<Object> javaType = Object.class;
    Class<Object> javaType2 = Object.class;
    MappedSuperclassTypeImpl superType = new MappedSuperclassTypeImpl(javaType2, null, null, null);

    RootClass persistentClass = new RootClass(new MetadataBuildingContextRootImpl(null, null, null));
    RootImpl original = new RootImpl(criteriaBuilder2,
        new EntityTypeImpl(javaType, superType, persistentClass, new SessionFactoryDelegatingImpl(null)));

    ArrayList<Predicate> restrictions = new ArrayList<>();
    ArrayList<Order> sorts = new ArrayList<>();
    InFlightMetadataCollectorImpl metadata3 = new InFlightMetadataCollectorImpl(null, null);

    CriteriaBuilderImpl criteriaBuilder3 = new CriteriaBuilderImpl(new SessionFactoryImpl(metadata3,
        new AbstractDelegatingSessionFactoryOptions(null), mock(QueryPlanCache.QueryPlanCreator.class)));
    Class<Object> returnType = Object.class;

    // Act
    criteriaTranslatorImpl2.addRestrictions("Ceiling Entity", filterMappings, criteriaBuilder, original, restrictions,
        sorts, new CriteriaQueryImpl(criteriaBuilder3, returnType));
  }

  /**
   * Test
   * {@link CriteriaTranslatorImpl#addSorting(CriteriaBuilder, List, FilterMapping, Path)}.
   * <p>
   * Method under test:
   * {@link CriteriaTranslatorImpl#addSorting(CriteriaBuilder, List, FilterMapping, Path)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testAddSorting() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.service.persistence.module.criteria;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3569 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.service.persistence.module.criteria.CriteriaTranslatorImpl criteriaTranslatorImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    CriteriaTranslatorImpl criteriaTranslatorImpl2 = new CriteriaTranslatorImpl();
    BootstrapContextImpl bootstrapContext = new BootstrapContextImpl(null, null);

    InFlightMetadataCollectorImpl metadata = new InFlightMetadataCollectorImpl(bootstrapContext,
        new MetadataBuilderImpl.MetadataBuildingOptionsImpl(null));

    CriteriaBuilderImpl criteriaBuilder = new CriteriaBuilderImpl(new SessionFactoryImpl(metadata,
        new AbstractDelegatingSessionFactoryOptions(null), mock(QueryPlanCache.QueryPlanCreator.class)));
    ArrayList<Order> sorts = new ArrayList<>();
    FilterMapping filterMapping = new FilterMapping();
    CriteriaBuilderImpl criteriaBuilder2 = new CriteriaBuilderImpl(
        new SessionFactoryImpl(null, null, mock(QueryPlanCache.QueryPlanCreator.class)));
    Class<Object> javaType = Object.class;
    Class<Object> treatAsType = Object.class;
    CollectionAttributeJoin original = new CollectionAttributeJoin(criteriaBuilder2, javaType,
        new ListAttributeJoin.TreatedListAttributeJoin(null, treatAsType), null, JoinType.INNER);

    Class<Object> treatAsType2 = Object.class;

    // Act
    criteriaTranslatorImpl2.addSorting(criteriaBuilder, sorts, filterMapping,
        new CollectionAttributeJoin.TreatedCollectionAttributeJoin(original, treatAsType2));
  }

  /**
   * Test {@link CriteriaTranslatorImpl#getAppropriateLargeSortingValue(Class)}.
   * <p>
   * Method under test:
   * {@link CriteriaTranslatorImpl#getAppropriateLargeSortingValue(Class)}
   */
  @Test
  public void testGetAppropriateLargeSortingValue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CriteriaTranslatorImpl criteriaTranslatorImpl = new CriteriaTranslatorImpl();
    Class<Object> javaType = Object.class;

    // Act and Assert
    assertNull(criteriaTranslatorImpl.getAppropriateLargeSortingValue(javaType));
  }

  /**
   * Test {@link CriteriaTranslatorImpl#getAppropriateLargeSortingValue(Class)}.
   * <p>
   * Method under test:
   * {@link CriteriaTranslatorImpl#getAppropriateLargeSortingValue(Class)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetAppropriateLargeSortingValue2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.service.persistence.module.criteria;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass4556 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.service.persistence.module.criteria.CriteriaTranslatorImpl criteriaTranslatorImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    CriteriaTranslatorImpl criteriaTranslatorImpl2 = new CriteriaTranslatorImpl();
    Class<Object> javaType = Object.class;

    // Act
    criteriaTranslatorImpl2.getAppropriateLargeSortingValue(javaType);
  }
}
