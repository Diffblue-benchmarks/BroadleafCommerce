package org.broadleafcommerce.openadmin.server.service.persistence.module.criteria.predicate;

import static org.mockito.Mockito.mock;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.From;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Path;
import org.broadleafcommerce.openadmin.server.service.persistence.module.criteria.FieldPathBuilder;
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
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml",
    "/bl-open-admin-applicationContext-entity.xml", "/bl-open-admin-contentClient-applicationContext.xml",
    "/bl-open-admin-contentCreator-applicationContext.xml",
    "/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml",
    "/blc-config/admin/framework/bl-open-admin-applicationContext.xml",
    "/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class LikePredicateProviderDiffblueTest {
  @Autowired
  private LikePredicateProvider likePredicateProvider;

  /**
   * Test
   * {@link LikePredicateProvider#buildPredicate(CriteriaBuilder, FieldPathBuilder, From, String, String, Path, List)}.
   * <p>
   * Method under test:
   * {@link LikePredicateProvider#buildPredicate(CriteriaBuilder, FieldPathBuilder, From, String, String, Path, List)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testBuildPredicate() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.service.persistence.module.criteria.predicate;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass10062 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.service.persistence.module.criteria.predicate.LikePredicateProvider likePredicateProvider;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    LikePredicateProvider likePredicateProvider2 = new LikePredicateProvider();
    BootstrapContextImpl bootstrapContext = new BootstrapContextImpl(null, null);

    InFlightMetadataCollectorImpl metadata = new InFlightMetadataCollectorImpl(bootstrapContext,
        new MetadataBuilderImpl.MetadataBuildingOptionsImpl(null));

    CriteriaBuilderImpl builder = new CriteriaBuilderImpl(new SessionFactoryImpl(metadata,
        new AbstractDelegatingSessionFactoryOptions(null), mock(QueryPlanCache.QueryPlanCreator.class)));

    FieldPathBuilder fieldPathBuilder = new FieldPathBuilder();
    CriteriaBuilderImpl criteriaBuilder = new CriteriaBuilderImpl(
        new SessionFactoryImpl(null, null, mock(QueryPlanCache.QueryPlanCreator.class)));
    Class<Object> returnType = Object.class;
    fieldPathBuilder.setCriteria(new CriteriaQueryImpl(criteriaBuilder, returnType));
    fieldPathBuilder.setRestrictions(new ArrayList<>());
    CriteriaBuilderImpl criteriaBuilder2 = new CriteriaBuilderImpl(
        new SessionFactoryImpl(null, null, mock(QueryPlanCache.QueryPlanCreator.class)));
    Class<Object> javaType = Object.class;
    Class<Object> treatAsType = Object.class;
    CollectionAttributeJoin original = new CollectionAttributeJoin(criteriaBuilder2, javaType,
        new ListAttributeJoin.TreatedListAttributeJoin(null, treatAsType), null, JoinType.INNER);

    Class<Object> treatAsType2 = Object.class;
    CollectionAttributeJoin.TreatedCollectionAttributeJoin root = new CollectionAttributeJoin.TreatedCollectionAttributeJoin(
        original, treatAsType2);

    InFlightMetadataCollectorImpl metadata2 = new InFlightMetadataCollectorImpl(null, null);

    CriteriaBuilderImpl criteriaBuilder3 = new CriteriaBuilderImpl(new SessionFactoryImpl(metadata2,
        new AbstractDelegatingSessionFactoryOptions(null), mock(QueryPlanCache.QueryPlanCreator.class)));
    Class<String> javaType2 = String.class;
    Class<Object> treatAsType3 = Object.class;
    CollectionAttributeJoin<Object, String> explicitPath = new CollectionAttributeJoin<>(criteriaBuilder3, javaType2,
        new CollectionAttributeJoin.TreatedCollectionAttributeJoin<>(null, treatAsType3), null, JoinType.INNER);

    // Act
    likePredicateProvider2.buildPredicate(builder, fieldPathBuilder, root, "Ceiling Entity", "Dr Jane Doe",
        explicitPath, new ArrayList<>());
  }
}
