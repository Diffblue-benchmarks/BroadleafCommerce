package org.broadleafcommerce.openadmin.server.service.persistence.module.criteria;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.From;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Path;
import org.broadleafcommerce.common.util.dao.DynamicDaoHelperImpl;
import org.broadleafcommerce.openadmin.server.service.persistence.module.criteria.converter.FilterValueConverter;
import org.broadleafcommerce.openadmin.server.service.persistence.module.criteria.predicate.PredicateProvider;
import org.hibernate.boot.internal.BootstrapContextImpl;
import org.hibernate.boot.internal.InFlightMetadataCollectorImpl;
import org.hibernate.boot.internal.MetadataBuilderImpl;
import org.hibernate.boot.spi.AbstractDelegatingSessionFactoryOptions;
import org.hibernate.engine.query.spi.QueryPlanCache;
import org.hibernate.internal.SessionFactoryImpl;
import org.hibernate.query.criteria.internal.CriteriaBuilderImpl;
import org.hibernate.query.criteria.internal.CriteriaQueryImpl;
import org.hibernate.query.criteria.internal.path.CollectionAttributeJoin;
import org.hibernate.query.criteria.internal.path.ListAttributeJoin;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@ContextConfiguration(locations = {"/bl-open-admin-contentCreator-applicationContext.xml",
    "/applicationContext-servlet-open-admin.xml", "/bl-open-admin-applicationContext-entity.xml",
    "/bl-open-admin-contentClient-applicationContext.xml",
    "/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml",
    "/blc-config/admin/framework/bl-open-admin-applicationContext.xml",
    "/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class RestrictionDiffblueTest {
  @Autowired
  private Restriction restriction;

  /**
   * Test {@link Restriction#withPredicateProvider(PredicateProvider)}.
   * <p>
   * Method under test:
   * {@link Restriction#withPredicateProvider(PredicateProvider)}
   */
  @Test
  public void testWithPredicateProvider() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Restriction restriction = new Restriction();
    PredicateProvider predicateProvider = mock(PredicateProvider.class);

    // Act and Assert
    assertSame(restriction, restriction.withPredicateProvider(predicateProvider));
    assertSame(predicateProvider, restriction.getPredicateProvider());
  }

  /**
   * Test {@link Restriction#withPredicateProvider(PredicateProvider)}.
   * <p>
   * Method under test:
   * {@link Restriction#withPredicateProvider(PredicateProvider)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testWithPredicateProvider2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.service.persistence.module.criteria;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-open-admin-contentCreator-applicationContext.xml","/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass7748 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.service.persistence.module.criteria.Restriction restriction;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    restriction.withPredicateProvider(mock(PredicateProvider.class));
  }

  /**
   * Test {@link Restriction#withFilterValueConverter(FilterValueConverter)}.
   * <p>
   * Method under test:
   * {@link Restriction#withFilterValueConverter(FilterValueConverter)}
   */
  @Test
  public void testWithFilterValueConverter() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Restriction restriction = new Restriction();
    FilterValueConverter filterValueConverter = mock(FilterValueConverter.class);

    // Act and Assert
    assertSame(restriction, restriction.withFilterValueConverter(filterValueConverter));
    assertSame(filterValueConverter, restriction.getFilterValueConverter());
  }

  /**
   * Test {@link Restriction#withFilterValueConverter(FilterValueConverter)}.
   * <p>
   * Method under test:
   * {@link Restriction#withFilterValueConverter(FilterValueConverter)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testWithFilterValueConverter2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.service.persistence.module.criteria;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-open-admin-contentCreator-applicationContext.xml","/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass7720 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.service.persistence.module.criteria.Restriction restriction;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    restriction.withFilterValueConverter(mock(FilterValueConverter.class));
  }

  /**
   * Test {@link Restriction#withFieldPathBuilder(FieldPathBuilder)}.
   * <p>
   * Method under test: {@link Restriction#withFieldPathBuilder(FieldPathBuilder)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testWithFieldPathBuilder() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.service.persistence.module.criteria;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-open-admin-contentCreator-applicationContext.xml","/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass7638 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.service.persistence.module.criteria.Restriction restriction;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    FieldPathBuilder fieldPathBuilder = new FieldPathBuilder();
    CriteriaBuilderImpl criteriaBuilder = new CriteriaBuilderImpl(
        new SessionFactoryImpl(null, null, mock(QueryPlanCache.QueryPlanCreator.class)));
    Class<Object> returnType = Object.class;
    fieldPathBuilder.setCriteria(new CriteriaQueryImpl(criteriaBuilder, returnType));
    fieldPathBuilder.setRestrictions(new ArrayList<>());

    // Act
    restriction.withFieldPathBuilder(fieldPathBuilder);
  }

  /**
   * Test {@link Restriction#withFieldPathBuilder(FieldPathBuilder)}.
   * <ul>
   *   <li>Then {@link Restriction} (default constructor) FieldPathBuilder is
   * {@link FieldPathBuilder} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link Restriction#withFieldPathBuilder(FieldPathBuilder)}
   */
  @Test
  public void testWithFieldPathBuilder_thenRestrictionFieldPathBuilderIsFieldPathBuilder() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Restriction restriction = new Restriction();

    FieldPathBuilder fieldPathBuilder = new FieldPathBuilder();
    CriteriaBuilderImpl criteriaBuilder = new CriteriaBuilderImpl(null);
    Class<Object> returnType = Object.class;
    fieldPathBuilder.setCriteria(new CriteriaQueryImpl(criteriaBuilder, returnType));
    fieldPathBuilder.setRestrictions(new ArrayList<>());

    // Act
    Restriction actualWithFieldPathBuilderResult = restriction.withFieldPathBuilder(fieldPathBuilder);

    // Assert
    assertSame(fieldPathBuilder, restriction.getFieldPathBuilder());
    assertSame(restriction, actualWithFieldPathBuilderResult);
  }

  /**
   * Test
   * {@link Restriction#buildRestriction(CriteriaBuilder, From, String, String, Path, List, boolean, CriteriaQuery, List)}.
   * <p>
   * Method under test:
   * {@link Restriction#buildRestriction(CriteriaBuilder, From, String, String, Path, List, boolean, CriteriaQuery, List)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testBuildRestriction() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.service.persistence.module.criteria;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-open-admin-contentCreator-applicationContext.xml","/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass7398 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.service.persistence.module.criteria.Restriction restriction;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    BootstrapContextImpl bootstrapContext = new BootstrapContextImpl(null, null);

    InFlightMetadataCollectorImpl metadata = new InFlightMetadataCollectorImpl(bootstrapContext,
        new MetadataBuilderImpl.MetadataBuildingOptionsImpl(null));

    CriteriaBuilderImpl builder = new CriteriaBuilderImpl(new SessionFactoryImpl(metadata,
        new AbstractDelegatingSessionFactoryOptions(null), mock(QueryPlanCache.QueryPlanCreator.class)));
    CriteriaBuilderImpl criteriaBuilder = new CriteriaBuilderImpl(
        new SessionFactoryImpl(null, null, mock(QueryPlanCache.QueryPlanCreator.class)));
    Class<Object> javaType = Object.class;
    Class<Object> treatAsType = Object.class;
    CollectionAttributeJoin original = new CollectionAttributeJoin(criteriaBuilder, javaType,
        new ListAttributeJoin.TreatedListAttributeJoin(null, treatAsType), null, JoinType.INNER);

    Class<Object> treatAsType2 = Object.class;
    CollectionAttributeJoin.TreatedCollectionAttributeJoin root = new CollectionAttributeJoin.TreatedCollectionAttributeJoin(
        original, treatAsType2);

    CriteriaBuilderImpl criteriaBuilder2 = new CriteriaBuilderImpl(
        new SessionFactoryImpl(null, null, mock(QueryPlanCache.QueryPlanCreator.class)));
    Class<Object> javaType2 = Object.class;
    Class<Object> treatAsType3 = Object.class;
    CollectionAttributeJoin original2 = new CollectionAttributeJoin(criteriaBuilder2, javaType2,
        new ListAttributeJoin.TreatedListAttributeJoin(null, treatAsType3), null, JoinType.INNER);

    Class<Object> treatAsType4 = Object.class;
    CollectionAttributeJoin.TreatedCollectionAttributeJoin explicitPath = new CollectionAttributeJoin.TreatedCollectionAttributeJoin(
        original2, treatAsType4);

    ArrayList<Object> directValues = new ArrayList<>();
    InFlightMetadataCollectorImpl metadata2 = new InFlightMetadataCollectorImpl(null, null);

    CriteriaBuilderImpl criteriaBuilder3 = new CriteriaBuilderImpl(new SessionFactoryImpl(metadata2,
        new AbstractDelegatingSessionFactoryOptions(null), mock(QueryPlanCache.QueryPlanCreator.class)));
    Class<Object> returnType = Object.class;
    CriteriaQueryImpl criteria = new CriteriaQueryImpl(criteriaBuilder3, returnType);

    // Act
    restriction.buildRestriction(builder, root, "Ceiling Entity", "Target Property Name", explicitPath, directValues,
        true, criteria, new ArrayList<>());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link Restriction#setFilterValueConverter(FilterValueConverter)}
   *   <li>{@link Restriction#setPredicateProvider(PredicateProvider)}
   *   <li>{@link Restriction#getFieldPathBuilder()}
   *   <li>{@link Restriction#getFilterValueConverter()}
   *   <li>{@link Restriction#getPredicateProvider()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    Restriction restriction = new Restriction();
    FilterValueConverter filterValueConverter = mock(FilterValueConverter.class);

    // Act
    restriction.setFilterValueConverter(filterValueConverter);
    PredicateProvider predicateProvider = mock(PredicateProvider.class);
    restriction.setPredicateProvider(predicateProvider);
    FieldPathBuilder actualFieldPathBuilder = restriction.getFieldPathBuilder();
    FilterValueConverter actualFilterValueConverter = restriction.getFilterValueConverter();

    // Assert that nothing has changed
    assertTrue(actualFieldPathBuilder.dynamicDaoHelper instanceof DynamicDaoHelperImpl);
    assertSame(filterValueConverter, actualFilterValueConverter);
    assertSame(predicateProvider, restriction.getPredicateProvider());
  }

  /**
   * Test {@link Restriction#clone()}.
   * <p>
   * Method under test: {@link Restriction#clone()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testClone() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.service.persistence.module.criteria;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-open-admin-contentCreator-applicationContext.xml","/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass7637 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.service.persistence.module.criteria.Restriction restriction;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    restriction.clone();
  }

  /**
   * Test {@link Restriction#clone()}.
   * <ul>
   *   <li>Given {@link Restriction} (default constructor) FilterValueConverter is
   * {@link FilterValueConverter}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Restriction#clone()}
   */
  @Test
  public void testClone_givenRestrictionFilterValueConverterIsFilterValueConverter() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Restriction restriction = new Restriction();
    restriction.setFilterValueConverter(mock(FilterValueConverter.class));

    // Act
    Restriction actualCloneResult = restriction.clone();

    // Assert
    FieldPathBuilder fieldPathBuilder = actualCloneResult.getFieldPathBuilder();
    assertTrue(fieldPathBuilder.dynamicDaoHelper instanceof DynamicDaoHelperImpl);
    assertNull(fieldPathBuilder.getRestrictions());
    assertNull(fieldPathBuilder.getCriteria());
    assertNull(actualCloneResult.getPredicateProvider());
  }

  /**
   * Test {@link Restriction#clone()}.
   * <ul>
   *   <li>Given {@link Restriction} (default constructor).</li>
   *   <li>Then return FilterValueConverter is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Restriction#clone()}
   */
  @Test
  public void testClone_givenRestriction_thenReturnFilterValueConverterIsNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    Restriction actualCloneResult = (new Restriction()).clone();

    // Assert
    FieldPathBuilder fieldPathBuilder = actualCloneResult.getFieldPathBuilder();
    assertTrue(fieldPathBuilder.dynamicDaoHelper instanceof DynamicDaoHelperImpl);
    assertNull(fieldPathBuilder.getRestrictions());
    assertNull(fieldPathBuilder.getCriteria());
    assertNull(actualCloneResult.getFilterValueConverter());
    assertNull(actualCloneResult.getPredicateProvider());
  }

  /**
   * Test new {@link Restriction} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link Restriction}
   */
  @Test
  public void testNewRestriction() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    Restriction actualRestriction = new Restriction();

    // Assert
    FieldPathBuilder fieldPathBuilder = actualRestriction.getFieldPathBuilder();
    assertTrue(fieldPathBuilder.dynamicDaoHelper instanceof DynamicDaoHelperImpl);
    assertNull(fieldPathBuilder.getRestrictions());
    assertNull(fieldPathBuilder.getCriteria());
    assertNull(actualRestriction.getFilterValueConverter());
    assertNull(actualRestriction.getPredicateProvider());
  }

  /**
   * Test new {@link Restriction} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link Restriction}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testNewRestriction2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.service.persistence.module.criteria;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-open-admin-contentCreator-applicationContext.xml","/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass7397 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.service.persistence.module.criteria.Restriction restriction;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    new Restriction();
  }
}
