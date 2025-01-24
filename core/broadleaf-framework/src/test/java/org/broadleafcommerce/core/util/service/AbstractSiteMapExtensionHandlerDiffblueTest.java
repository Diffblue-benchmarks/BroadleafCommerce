package org.broadleafcommerce.core.util.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.boot.internal.BootstrapContextImpl;
import org.hibernate.boot.internal.InFlightMetadataCollectorImpl;
import org.hibernate.boot.internal.MetadataBuilderImpl;
import org.hibernate.boot.internal.MetadataBuildingContextRootImpl;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.spi.AbstractDelegatingSessionFactoryOptions;
import org.hibernate.boot.spi.BootstrapContext;
import org.hibernate.boot.spi.InFlightMetadataCollector;
import org.hibernate.boot.spi.MetadataBuildingOptions;
import org.hibernate.boot.spi.SessionFactoryOptions;
import org.hibernate.engine.query.spi.QueryPlanCache;
import org.hibernate.engine.spi.SessionFactoryDelegatingImpl;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.hibernate.internal.SessionFactoryImpl;
import org.hibernate.mapping.MappedSuperclass;
import org.hibernate.mapping.RootClass;
import org.hibernate.metamodel.model.domain.internal.EntityTypeImpl;
import org.hibernate.metamodel.model.domain.internal.MappedSuperclassTypeImpl;
import org.hibernate.metamodel.model.domain.spi.IdentifiableTypeDescriptor;
import org.hibernate.query.criteria.internal.CriteriaBuilderImpl;
import org.hibernate.query.criteria.internal.CriteriaQueryImpl;
import org.hibernate.query.criteria.internal.path.RootImpl;
import org.junit.Ignore;
import org.junit.Test;

public class AbstractSiteMapExtensionHandlerDiffblueTest {
  /**
   * Test
   * {@link AbstractSiteMapExtensionHandler#modifyQuery(CriteriaQuery, CriteriaBuilder, Root)}.
   * <p>
   * Method under test:
   * {@link AbstractSiteMapExtensionHandler#modifyQuery(CriteriaQuery, CriteriaBuilder, Root)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testModifyQuery() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.NullPointerException
    //       at org.hibernate.boot.internal.InFlightMetadataCollectorImpl.<init>(InFlightMetadataCollectorImpl.java:176)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange
    AbstractSiteMapExtensionHandler abstractSiteMapExtensionHandler = new AbstractSiteMapExtensionHandler();
    InFlightMetadataCollectorImpl metadata = new InFlightMetadataCollectorImpl(mock(BootstrapContext.class),
        mock(MetadataBuildingOptions.class));

    CriteriaBuilderImpl criteriaBuilder = new CriteriaBuilderImpl(
        new SessionFactoryImpl(metadata, new AbstractDelegatingSessionFactoryOptions(mock(SessionFactoryOptions.class)),
            mock(QueryPlanCache.QueryPlanCreator.class)));
    Class<Object> returnType = Object.class;
    CriteriaQueryImpl criteriaQuery = new CriteriaQueryImpl(criteriaBuilder, returnType);

    BootstrapContextImpl bootstrapContext = new BootstrapContextImpl(mock(StandardServiceRegistry.class),
        mock(MetadataBuildingOptions.class));

    InFlightMetadataCollectorImpl metadata2 = new InFlightMetadataCollectorImpl(bootstrapContext,
        new MetadataBuilderImpl.MetadataBuildingOptionsImpl(mock(StandardServiceRegistry.class)));

    CriteriaBuilderImpl builder = new CriteriaBuilderImpl(new SessionFactoryImpl(metadata2,
        new AbstractDelegatingSessionFactoryOptions(mock(SessionFactoryOptions.class)),
        mock(QueryPlanCache.QueryPlanCreator.class)));
    InFlightMetadataCollectorImpl metadata3 = new InFlightMetadataCollectorImpl(mock(BootstrapContext.class),
        mock(MetadataBuildingOptions.class));

    CriteriaBuilderImpl criteriaBuilder2 = new CriteriaBuilderImpl(new SessionFactoryImpl(metadata3,
        new AbstractDelegatingSessionFactoryOptions(mock(SessionFactoryOptions.class)),
        mock(QueryPlanCache.QueryPlanCreator.class)));
    Class<Object> javaType = Object.class;
    Class<Object> javaType2 = Object.class;
    MappedSuperclassTypeImpl superType = new MappedSuperclassTypeImpl(javaType2, mock(MappedSuperclass.class),
        mock(IdentifiableTypeDescriptor.class), mock(SessionFactoryImplementor.class));

    RootClass persistentClass = new RootClass(new MetadataBuildingContextRootImpl(mock(BootstrapContext.class),
        mock(MetadataBuildingOptions.class), mock(InFlightMetadataCollector.class)));

    // Act
    abstractSiteMapExtensionHandler.modifyQuery(criteriaQuery, builder,
        new RootImpl(criteriaBuilder2, new EntityTypeImpl(javaType, superType, persistentClass,
            new SessionFactoryDelegatingImpl(mock(SessionFactoryImplementor.class)))));
  }

  /**
   * Test new {@link AbstractSiteMapExtensionHandler} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link AbstractSiteMapExtensionHandler}
   */
  @Test
  public void testNewAbstractSiteMapExtensionHandler() {
    // Arrange and Act
    AbstractSiteMapExtensionHandler actualAbstractSiteMapExtensionHandler = new AbstractSiteMapExtensionHandler();

    // Assert
    assertEquals(0, actualAbstractSiteMapExtensionHandler.getPriority());
    assertTrue(actualAbstractSiteMapExtensionHandler.isEnabled());
  }
}
