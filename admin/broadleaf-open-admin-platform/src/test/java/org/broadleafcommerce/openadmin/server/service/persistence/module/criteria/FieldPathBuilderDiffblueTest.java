package org.broadleafcommerce.openadmin.server.service.persistence.module.criteria;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.From;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import org.broadleafcommerce.common.util.dao.DynamicDaoHelperImpl;
import org.hibernate.boot.internal.BootstrapContextImpl;
import org.hibernate.boot.internal.InFlightMetadataCollectorImpl;
import org.hibernate.boot.internal.MetadataBuilderImpl;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.spi.AbstractDelegatingSessionFactoryOptions;
import org.hibernate.boot.spi.MetadataBuildingOptions;
import org.hibernate.boot.spi.MetadataImplementor;
import org.hibernate.boot.spi.SessionFactoryOptions;
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

@ContextConfiguration(classes = {FieldPathBuilder.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class FieldPathBuilderDiffblueTest {
  @Autowired
  private FieldPathBuilder fieldPathBuilder;

  /**
   * Test {@link FieldPathBuilder#getFieldPath(From, String)}.
   * <p>
   * Method under test: {@link FieldPathBuilder#getFieldPath(From, String)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetFieldPath() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.NullPointerException
    //       at org.hibernate.cfg.Settings.<init>(Settings.java:53)
    //       at org.hibernate.internal.SessionFactoryImpl.<init>(SessionFactoryImpl.java:207)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange
    FieldPathBuilder fieldPathBuilder2 = new FieldPathBuilder();
    CriteriaBuilderImpl criteriaBuilder = new CriteriaBuilderImpl(
        new SessionFactoryImpl(null, null, mock(QueryPlanCache.QueryPlanCreator.class)));
    Class<Object> javaType = Object.class;
    Class<Object> treatAsType = Object.class;
    CollectionAttributeJoin original = new CollectionAttributeJoin(criteriaBuilder, javaType,
        new ListAttributeJoin.TreatedListAttributeJoin(null, treatAsType), null, JoinType.INNER);

    Class<Object> treatAsType2 = Object.class;

    // Act
    fieldPathBuilder2.getFieldPath(new CollectionAttributeJoin.TreatedCollectionAttributeJoin(original, treatAsType2),
        "Dr Jane Doe");
  }

  /**
   * Test {@link FieldPathBuilder#getPath(From, FieldPath, CriteriaBuilder)} with
   * {@code root}, {@code fieldPath}, {@code builder}.
   * <p>
   * Method under test:
   * {@link FieldPathBuilder#getPath(From, FieldPath, CriteriaBuilder)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetPathWithRootFieldPathBuilder() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.NullPointerException
    //       at org.hibernate.cfg.Settings.<init>(Settings.java:53)
    //       at org.hibernate.internal.SessionFactoryImpl.<init>(SessionFactoryImpl.java:207)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange
    FieldPathBuilder fieldPathBuilder = new FieldPathBuilder();
    CriteriaBuilderImpl criteriaBuilder = new CriteriaBuilderImpl(
        new SessionFactoryImpl(mock(MetadataImplementor.class), mock(SessionFactoryOptions.class),
            mock(QueryPlanCache.QueryPlanCreator.class)));
    Class<Object> javaType = Object.class;
    ListAttributeJoin original = mock(ListAttributeJoin.class);
    Class<Object> treatAsType = Object.class;
    CollectionAttributeJoin original2 = new CollectionAttributeJoin(criteriaBuilder, javaType,
        new ListAttributeJoin.TreatedListAttributeJoin(original, treatAsType), null, JoinType.INNER);

    Class<Object> treatAsType2 = Object.class;
    CollectionAttributeJoin.TreatedCollectionAttributeJoin root = new CollectionAttributeJoin.TreatedCollectionAttributeJoin(
        original2, treatAsType2);

    FieldPath fieldPath = new FieldPath();
    BootstrapContextImpl bootstrapContext = new BootstrapContextImpl(mock(StandardServiceRegistry.class),
        mock(MetadataBuildingOptions.class));

    InFlightMetadataCollectorImpl metadata = new InFlightMetadataCollectorImpl(bootstrapContext,
        new MetadataBuilderImpl.MetadataBuildingOptionsImpl(mock(StandardServiceRegistry.class)));

    // Act
    fieldPathBuilder.getPath(root, fieldPath,
        new CriteriaBuilderImpl(new SessionFactoryImpl(metadata,
            new AbstractDelegatingSessionFactoryOptions(mock(SessionFactoryOptions.class)),
            mock(QueryPlanCache.QueryPlanCreator.class))));
  }

  /**
   * Test {@link FieldPathBuilder#getPath(From, String, CriteriaBuilder)} with
   * {@code root}, {@code fullPropertyName}, {@code builder}.
   * <p>
   * Method under test:
   * {@link FieldPathBuilder#getPath(From, String, CriteriaBuilder)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetPathWithRootFullPropertyNameBuilder() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.NullPointerException
    //       at org.hibernate.cfg.Settings.<init>(Settings.java:53)
    //       at org.hibernate.internal.SessionFactoryImpl.<init>(SessionFactoryImpl.java:207)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange
    FieldPathBuilder fieldPathBuilder2 = new FieldPathBuilder();
    CriteriaBuilderImpl criteriaBuilder = new CriteriaBuilderImpl(
        new SessionFactoryImpl(null, null, mock(QueryPlanCache.QueryPlanCreator.class)));
    Class<Object> javaType = Object.class;
    Class<Object> treatAsType = Object.class;
    CollectionAttributeJoin original = new CollectionAttributeJoin(criteriaBuilder, javaType,
        new ListAttributeJoin.TreatedListAttributeJoin(null, treatAsType), null, JoinType.INNER);

    Class<Object> treatAsType2 = Object.class;
    CollectionAttributeJoin.TreatedCollectionAttributeJoin root = new CollectionAttributeJoin.TreatedCollectionAttributeJoin(
        original, treatAsType2);

    BootstrapContextImpl bootstrapContext = new BootstrapContextImpl(null, null);

    InFlightMetadataCollectorImpl metadata = new InFlightMetadataCollectorImpl(bootstrapContext,
        new MetadataBuilderImpl.MetadataBuildingOptionsImpl(null));

    // Act
    fieldPathBuilder2.getPath(root, "Dr Jane Doe", new CriteriaBuilderImpl(new SessionFactoryImpl(metadata,
        new AbstractDelegatingSessionFactoryOptions(null), mock(QueryPlanCache.QueryPlanCreator.class))));
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link FieldPathBuilder#setRestrictions(List)}
   *   <li>{@link FieldPathBuilder#getCriteria()}
   *   <li>{@link FieldPathBuilder#getRestrictions()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    FieldPathBuilder fieldPathBuilder = new FieldPathBuilder();
    ArrayList<Predicate> restrictions = new ArrayList<>();

    // Act
    fieldPathBuilder.setRestrictions(restrictions);
    fieldPathBuilder.getCriteria();
    List<Predicate> actualRestrictions = fieldPathBuilder.getRestrictions();

    // Assert that nothing has changed
    assertTrue(actualRestrictions.isEmpty());
    assertSame(restrictions, actualRestrictions);
  }

  /**
   * Test new {@link FieldPathBuilder} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link FieldPathBuilder}
   */
  @Test
  public void testNewFieldPathBuilder() {
    // Arrange and Act
    FieldPathBuilder actualFieldPathBuilder = new FieldPathBuilder();

    // Assert
    assertTrue(actualFieldPathBuilder.dynamicDaoHelper instanceof DynamicDaoHelperImpl);
    assertNull(actualFieldPathBuilder.getRestrictions());
    assertNull(actualFieldPathBuilder.getCriteria());
  }
}
